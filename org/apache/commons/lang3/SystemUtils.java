package org.apache.commons.lang3;

import androidx.core.view.InputDeviceCompat;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.PrintStream;
/* loaded from: classes3.dex */
public class SystemUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String AWT_TOOLKIT;
    public static final String FILE_ENCODING;
    @Deprecated
    public static final String FILE_SEPARATOR;
    public static final boolean IS_JAVA_1_1;
    public static final boolean IS_JAVA_1_2;
    public static final boolean IS_JAVA_1_3;
    public static final boolean IS_JAVA_1_4;
    public static final boolean IS_JAVA_1_5;
    public static final boolean IS_JAVA_1_6;
    public static final boolean IS_JAVA_1_7;
    public static final boolean IS_JAVA_1_8;
    @Deprecated
    public static final boolean IS_JAVA_1_9;
    public static final boolean IS_JAVA_9;
    public static final boolean IS_OS_400;
    public static final boolean IS_OS_AIX;
    public static final boolean IS_OS_FREE_BSD;
    public static final boolean IS_OS_HP_UX;
    public static final boolean IS_OS_IRIX;
    public static final boolean IS_OS_LINUX;
    public static final boolean IS_OS_MAC;
    public static final boolean IS_OS_MAC_OSX;
    public static final boolean IS_OS_MAC_OSX_CHEETAH;
    public static final boolean IS_OS_MAC_OSX_EL_CAPITAN;
    public static final boolean IS_OS_MAC_OSX_JAGUAR;
    public static final boolean IS_OS_MAC_OSX_LEOPARD;
    public static final boolean IS_OS_MAC_OSX_LION;
    public static final boolean IS_OS_MAC_OSX_MAVERICKS;
    public static final boolean IS_OS_MAC_OSX_MOUNTAIN_LION;
    public static final boolean IS_OS_MAC_OSX_PANTHER;
    public static final boolean IS_OS_MAC_OSX_PUMA;
    public static final boolean IS_OS_MAC_OSX_SNOW_LEOPARD;
    public static final boolean IS_OS_MAC_OSX_TIGER;
    public static final boolean IS_OS_MAC_OSX_YOSEMITE;
    public static final boolean IS_OS_NET_BSD;
    public static final boolean IS_OS_OPEN_BSD;
    public static final boolean IS_OS_OS2;
    public static final boolean IS_OS_SOLARIS;
    public static final boolean IS_OS_SUN_OS;
    public static final boolean IS_OS_UNIX;
    public static final boolean IS_OS_WINDOWS;
    public static final boolean IS_OS_WINDOWS_10;
    public static final boolean IS_OS_WINDOWS_2000;
    public static final boolean IS_OS_WINDOWS_2003;
    public static final boolean IS_OS_WINDOWS_2008;
    public static final boolean IS_OS_WINDOWS_2012;
    public static final boolean IS_OS_WINDOWS_7;
    public static final boolean IS_OS_WINDOWS_8;
    public static final boolean IS_OS_WINDOWS_95;
    public static final boolean IS_OS_WINDOWS_98;
    public static final boolean IS_OS_WINDOWS_ME;
    public static final boolean IS_OS_WINDOWS_NT;
    public static final boolean IS_OS_WINDOWS_VISTA;
    public static final boolean IS_OS_WINDOWS_XP;
    public static final boolean IS_OS_ZOS;
    public static final String JAVA_AWT_FONTS;
    public static final String JAVA_AWT_GRAPHICSENV;
    public static final String JAVA_AWT_HEADLESS;
    public static final String JAVA_AWT_PRINTERJOB;
    public static final String JAVA_CLASS_PATH;
    public static final String JAVA_CLASS_VERSION;
    public static final String JAVA_COMPILER;
    public static final String JAVA_ENDORSED_DIRS;
    public static final String JAVA_EXT_DIRS;
    public static final String JAVA_HOME;
    public static final String JAVA_HOME_KEY = "java.home";
    public static final String JAVA_IO_TMPDIR;
    public static final String JAVA_IO_TMPDIR_KEY = "java.io.tmpdir";
    public static final String JAVA_LIBRARY_PATH;
    public static final String JAVA_RUNTIME_NAME;
    public static final String JAVA_RUNTIME_VERSION;
    public static final String JAVA_SPECIFICATION_NAME;
    public static final String JAVA_SPECIFICATION_VENDOR;
    public static final String JAVA_SPECIFICATION_VERSION;
    public static final JavaVersion JAVA_SPECIFICATION_VERSION_AS_ENUM;
    public static final String JAVA_UTIL_PREFS_PREFERENCES_FACTORY;
    public static final String JAVA_VENDOR;
    public static final String JAVA_VENDOR_URL;
    public static final String JAVA_VERSION;
    public static final String JAVA_VM_INFO;
    public static final String JAVA_VM_NAME;
    public static final String JAVA_VM_SPECIFICATION_NAME;
    public static final String JAVA_VM_SPECIFICATION_VENDOR;
    public static final String JAVA_VM_SPECIFICATION_VERSION;
    public static final String JAVA_VM_VENDOR;
    public static final String JAVA_VM_VERSION;
    public static final String LINE_SEPARATOR;
    public static final String OS_ARCH;
    public static final String OS_NAME;
    public static final String OS_NAME_WINDOWS_PREFIX = "Windows";
    public static final String OS_VERSION;
    @Deprecated
    public static final String PATH_SEPARATOR;
    public static final String USER_COUNTRY;
    public static final String USER_DIR;
    public static final String USER_DIR_KEY = "user.dir";
    public static final String USER_HOME;
    public static final String USER_HOME_KEY = "user.home";
    public static final String USER_LANGUAGE;
    public static final String USER_NAME;
    public static final String USER_TIMEZONE;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1155467348, "Lorg/apache/commons/lang3/SystemUtils;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1155467348, "Lorg/apache/commons/lang3/SystemUtils;");
                return;
            }
        }
        AWT_TOOLKIT = getSystemProperty("awt.toolkit");
        FILE_ENCODING = getSystemProperty("file.encoding");
        FILE_SEPARATOR = getSystemProperty("file.separator");
        JAVA_AWT_FONTS = getSystemProperty("java.awt.fonts");
        JAVA_AWT_GRAPHICSENV = getSystemProperty("java.awt.graphicsenv");
        JAVA_AWT_HEADLESS = getSystemProperty("java.awt.headless");
        JAVA_AWT_PRINTERJOB = getSystemProperty("java.awt.printerjob");
        JAVA_CLASS_PATH = getSystemProperty("java.class.path");
        JAVA_CLASS_VERSION = getSystemProperty("java.class.version");
        JAVA_COMPILER = getSystemProperty("java.compiler");
        JAVA_ENDORSED_DIRS = getSystemProperty("java.endorsed.dirs");
        JAVA_EXT_DIRS = getSystemProperty("java.ext.dirs");
        JAVA_HOME = getSystemProperty(JAVA_HOME_KEY);
        JAVA_IO_TMPDIR = getSystemProperty(JAVA_IO_TMPDIR_KEY);
        JAVA_LIBRARY_PATH = getSystemProperty("java.library.path");
        JAVA_RUNTIME_NAME = getSystemProperty("java.runtime.name");
        JAVA_RUNTIME_VERSION = getSystemProperty("java.runtime.version");
        JAVA_SPECIFICATION_NAME = getSystemProperty("java.specification.name");
        JAVA_SPECIFICATION_VENDOR = getSystemProperty("java.specification.vendor");
        String systemProperty = getSystemProperty("java.specification.version");
        JAVA_SPECIFICATION_VERSION = systemProperty;
        JAVA_SPECIFICATION_VERSION_AS_ENUM = JavaVersion.get(systemProperty);
        JAVA_UTIL_PREFS_PREFERENCES_FACTORY = getSystemProperty("java.util.prefs.PreferencesFactory");
        JAVA_VENDOR = getSystemProperty("java.vendor");
        JAVA_VENDOR_URL = getSystemProperty("java.vendor.url");
        JAVA_VERSION = getSystemProperty("java.version");
        JAVA_VM_INFO = getSystemProperty("java.vm.info");
        JAVA_VM_NAME = getSystemProperty("java.vm.name");
        JAVA_VM_SPECIFICATION_NAME = getSystemProperty("java.vm.specification.name");
        JAVA_VM_SPECIFICATION_VENDOR = getSystemProperty("java.vm.specification.vendor");
        JAVA_VM_SPECIFICATION_VERSION = getSystemProperty("java.vm.specification.version");
        JAVA_VM_VENDOR = getSystemProperty("java.vm.vendor");
        JAVA_VM_VERSION = getSystemProperty("java.vm.version");
        LINE_SEPARATOR = getSystemProperty("line.separator");
        OS_ARCH = getSystemProperty("os.arch");
        OS_NAME = getSystemProperty("os.name");
        OS_VERSION = getSystemProperty("os.version");
        PATH_SEPARATOR = getSystemProperty("path.separator");
        USER_COUNTRY = getSystemProperty(getSystemProperty("user.country") == null ? "user.region" : "user.country");
        USER_DIR = getSystemProperty(USER_DIR_KEY);
        USER_HOME = getSystemProperty(USER_HOME_KEY);
        USER_LANGUAGE = getSystemProperty("user.language");
        USER_NAME = getSystemProperty("user.name");
        USER_TIMEZONE = getSystemProperty("user.timezone");
        IS_JAVA_1_1 = getJavaVersionMatches("1.1");
        IS_JAVA_1_2 = getJavaVersionMatches("1.2");
        IS_JAVA_1_3 = getJavaVersionMatches("1.3");
        IS_JAVA_1_4 = getJavaVersionMatches("1.4");
        IS_JAVA_1_5 = getJavaVersionMatches("1.5");
        IS_JAVA_1_6 = getJavaVersionMatches("1.6");
        IS_JAVA_1_7 = getJavaVersionMatches("1.7");
        IS_JAVA_1_8 = getJavaVersionMatches("1.8");
        IS_JAVA_1_9 = getJavaVersionMatches("9");
        IS_JAVA_9 = getJavaVersionMatches("9");
        IS_OS_AIX = getOSMatchesName("AIX");
        IS_OS_HP_UX = getOSMatchesName("HP-UX");
        IS_OS_400 = getOSMatchesName("OS/400");
        IS_OS_IRIX = getOSMatchesName("Irix");
        boolean z = false;
        IS_OS_LINUX = getOSMatchesName("Linux") || getOSMatchesName("LINUX");
        IS_OS_MAC = getOSMatchesName("Mac");
        IS_OS_MAC_OSX = getOSMatchesName("Mac OS X");
        IS_OS_MAC_OSX_CHEETAH = getOSMatches("Mac OS X", "10.0");
        IS_OS_MAC_OSX_PUMA = getOSMatches("Mac OS X", "10.1");
        IS_OS_MAC_OSX_JAGUAR = getOSMatches("Mac OS X", "10.2");
        IS_OS_MAC_OSX_PANTHER = getOSMatches("Mac OS X", "10.3");
        IS_OS_MAC_OSX_TIGER = getOSMatches("Mac OS X", "10.4");
        IS_OS_MAC_OSX_LEOPARD = getOSMatches("Mac OS X", "10.5");
        IS_OS_MAC_OSX_SNOW_LEOPARD = getOSMatches("Mac OS X", "10.6");
        IS_OS_MAC_OSX_LION = getOSMatches("Mac OS X", "10.7");
        IS_OS_MAC_OSX_MOUNTAIN_LION = getOSMatches("Mac OS X", "10.8");
        IS_OS_MAC_OSX_MAVERICKS = getOSMatches("Mac OS X", "10.9");
        IS_OS_MAC_OSX_YOSEMITE = getOSMatches("Mac OS X", "10.10");
        IS_OS_MAC_OSX_EL_CAPITAN = getOSMatches("Mac OS X", "10.11");
        IS_OS_FREE_BSD = getOSMatchesName("FreeBSD");
        IS_OS_OPEN_BSD = getOSMatchesName("OpenBSD");
        IS_OS_NET_BSD = getOSMatchesName("NetBSD");
        IS_OS_OS2 = getOSMatchesName("OS/2");
        IS_OS_SOLARIS = getOSMatchesName("Solaris");
        boolean oSMatchesName = getOSMatchesName("SunOS");
        IS_OS_SUN_OS = oSMatchesName;
        IS_OS_UNIX = (IS_OS_AIX || IS_OS_HP_UX || IS_OS_IRIX || IS_OS_LINUX || IS_OS_MAC_OSX || IS_OS_SOLARIS || oSMatchesName || IS_OS_FREE_BSD || IS_OS_OPEN_BSD || IS_OS_NET_BSD) ? true : true;
        IS_OS_WINDOWS = getOSMatchesName(OS_NAME_WINDOWS_PREFIX);
        IS_OS_WINDOWS_2000 = getOSMatchesName("Windows 2000");
        IS_OS_WINDOWS_2003 = getOSMatchesName("Windows 2003");
        IS_OS_WINDOWS_2008 = getOSMatchesName("Windows Server 2008");
        IS_OS_WINDOWS_2012 = getOSMatchesName("Windows Server 2012");
        IS_OS_WINDOWS_95 = getOSMatchesName("Windows 95");
        IS_OS_WINDOWS_98 = getOSMatchesName("Windows 98");
        IS_OS_WINDOWS_ME = getOSMatchesName("Windows Me");
        IS_OS_WINDOWS_NT = getOSMatchesName("Windows NT");
        IS_OS_WINDOWS_XP = getOSMatchesName("Windows XP");
        IS_OS_WINDOWS_VISTA = getOSMatchesName("Windows Vista");
        IS_OS_WINDOWS_7 = getOSMatchesName("Windows 7");
        IS_OS_WINDOWS_8 = getOSMatchesName("Windows 8");
        IS_OS_WINDOWS_10 = getOSMatchesName("Windows 10");
        IS_OS_ZOS = getOSMatchesName("z/OS");
    }

    public SystemUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static File getJavaHome() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? new File(System.getProperty(JAVA_HOME_KEY)) : (File) invokeV.objValue;
    }

    public static File getJavaIoTmpDir() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? new File(System.getProperty(JAVA_IO_TMPDIR_KEY)) : (File) invokeV.objValue;
    }

    public static boolean getJavaVersionMatches(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) ? isJavaVersionMatch(JAVA_SPECIFICATION_VERSION, str) : invokeL.booleanValue;
    }

    public static boolean getOSMatches(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, str, str2)) == null) ? isOSMatch(OS_NAME, OS_VERSION, str, str2) : invokeLL.booleanValue;
    }

    public static boolean getOSMatchesName(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) ? isOSNameMatch(OS_NAME, str) : invokeL.booleanValue;
    }

    public static String getSystemProperty(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            try {
                return System.getProperty(str);
            } catch (SecurityException unused) {
                PrintStream printStream = System.err;
                printStream.println("Caught a SecurityException reading the system property '" + str + "'; the SystemUtils property value will default to null.");
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public static File getUserDir() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? new File(System.getProperty(USER_DIR_KEY)) : (File) invokeV.objValue;
    }

    public static File getUserHome() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? new File(System.getProperty(USER_HOME_KEY)) : (File) invokeV.objValue;
    }

    public static boolean isJavaAwtHeadless() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? Boolean.TRUE.toString().equals(JAVA_AWT_HEADLESS) : invokeV.booleanValue;
    }

    public static boolean isJavaVersionAtLeast(JavaVersion javaVersion) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65547, null, javaVersion)) == null) ? JAVA_SPECIFICATION_VERSION_AS_ENUM.atLeast(javaVersion) : invokeL.booleanValue;
    }

    public static boolean isJavaVersionMatch(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65548, null, str, str2)) == null) {
            if (str == null) {
                return false;
            }
            return str.startsWith(str2);
        }
        return invokeLL.booleanValue;
    }

    public static boolean isOSMatch(String str, String str2, String str3, String str4) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65549, null, str, str2, str3, str4)) == null) ? str != null && str2 != null && isOSNameMatch(str, str3) && isOSVersionMatch(str2, str4) : invokeLLLL.booleanValue;
    }

    public static boolean isOSNameMatch(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65550, null, str, str2)) == null) {
            if (str == null) {
                return false;
            }
            return str.startsWith(str2);
        }
        return invokeLL.booleanValue;
    }

    public static boolean isOSVersionMatch(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65551, null, str, str2)) == null) {
            if (StringUtils.isEmpty(str)) {
                return false;
            }
            String[] split = str2.split(EmotionResourceInfo.VERSION_NAME_SEPARATOR_REGEX);
            String[] split2 = str.split(EmotionResourceInfo.VERSION_NAME_SEPARATOR_REGEX);
            for (int i2 = 0; i2 < Math.min(split.length, split2.length); i2++) {
                if (!split[i2].equals(split2[i2])) {
                    return false;
                }
            }
            return true;
        }
        return invokeLL.booleanValue;
    }
}
