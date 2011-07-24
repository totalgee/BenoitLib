/*
	MandelPlatform
	(c) 2011 by Patrick Borgeat <patrick@borgeat.de>
	http://www.cappel-nord.de
	
	Part of BenoitLib
	http://github.com/cappelnord/BenoitLib
	http://www.the-mandelbrots.de
	
	Contains platform specific functionallity
	
*/

MandelPlatform : MandelModule {
	displayNotification {|title, message|
		"This should have been implemented by the platform".postln;
	}
}

MandelPlatformLinux : MandelPlatform {
	displayNotification {|title, message|
		("notify-send '" ++ title ++ "' '"++ message ++ "'").unixCmd(postOutput:false);
	}
}

MandelPlatformOSX : MandelPlatform {
	
	onStartup {|mc|
		("osascript '" ++ mc.classPath("mcRegisterGrowl.applescript") ++ "'").unixCmd(postOutput:false);
	}
	
	displayNotification {|title, message|
		("osascript '" ++ mc.classPath("mcNotify.applescript") ++ "' '" ++ title ++ "' '" ++ message ++ "'").unixCmd(postOutput:false);
	}
}