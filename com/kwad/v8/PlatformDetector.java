package com.kwad.v8;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;
/* loaded from: classes4.dex */
public class PlatformDetector {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class Arch {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public Arch() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public static String getName() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
                String property = System.getProperty("os.arch");
                String normalizeArch = PlatformDetector.normalizeArch(property);
                if (normalizeArch.equals("unknown")) {
                    throw new UnsatisfiedLinkError("Unsupported arch: " + property);
                }
                return normalizeArch;
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class OS {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public OS() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public static String getLibFileExtension() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
                if (isWindows()) {
                    return "dll";
                }
                if (isMac()) {
                    return "dylib";
                }
                if (isLinux() || isAndroid() || isNativeClient()) {
                    return "so";
                }
                throw new UnsatisfiedLinkError("Unsupported platform library-extension for: " + getName());
            }
            return (String) invokeV.objValue;
        }

        public static String getName() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
                String property = System.getProperty("os.name");
                String normalizeOs = PlatformDetector.normalizeOs(property);
                String property2 = System.getProperty("java.specification.vendor");
                if (PlatformDetector.normalize(property2).contains("android") || normalizeOs.contains("android")) {
                    return "android";
                }
                if (normalizeOs.equals("unknown")) {
                    throw new UnsatisfiedLinkError("Unsupported platform/vendor: " + property + " / " + property2);
                }
                return normalizeOs;
            }
            return (String) invokeV.objValue;
        }

        public static boolean isAndroid() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? getName().equals("android") : invokeV.booleanValue;
        }

        public static boolean isLinux() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? getName().equals(Platform.LINUX) : invokeV.booleanValue;
        }

        public static boolean isMac() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? getName().equals(Platform.MACOSX) : invokeV.booleanValue;
        }

        public static boolean isNativeClient() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) ? getName().equals(Platform.NATIVE_CLIENT) : invokeV.booleanValue;
        }

        public static boolean isWindows() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? getName().equals(Platform.WINDOWS) : invokeV.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class Vendor {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String LINUX_ID_PREFIX = "ID=";
        public static final String[] LINUX_OS_RELEASE_FILES;
        public static final String REDHAT_RELEASE_FILE = "/etc/redhat-release";
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(911515695, "Lcom/kwad/v8/PlatformDetector$Vendor;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(911515695, "Lcom/kwad/v8/PlatformDetector$Vendor;");
                    return;
                }
            }
            LINUX_OS_RELEASE_FILES = new String[]{"/etc/os-release", "/usr/lib/os-release"};
        }

        public Vendor() {
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

        public static void closeQuietly(Closeable closeable) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(65538, null, closeable) == null) || closeable == null) {
                return;
            }
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }

        public static String getLinuxOsReleaseId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                for (String str : LINUX_OS_RELEASE_FILES) {
                    File file = new File(str);
                    if (file.exists()) {
                        return parseLinuxOsReleaseFile(file);
                    }
                }
                File file2 = new File(REDHAT_RELEASE_FILE);
                if (file2.exists()) {
                    return parseLinuxRedhatReleaseFile(file2);
                }
                throw new UnsatisfiedLinkError("Unsupported linux vendor: " + getName());
            }
            return (String) invokeV.objValue;
        }

        public static String getName() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
                if (OS.isWindows()) {
                    return "microsoft";
                }
                if (OS.isMac()) {
                    return "apple";
                }
                if (OS.isLinux()) {
                    return getLinuxOsReleaseId();
                }
                if (OS.isAndroid()) {
                    return "google";
                }
                throw new UnsatisfiedLinkError("Unsupported vendor: " + getName());
            }
            return (String) invokeV.objValue;
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0024, code lost:
            r0 = com.kwad.v8.PlatformDetector.normalizeOsReleaseValue(r4.substring(3));
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static String parseLinuxOsReleaseFile(File file) {
            InterceptResult invokeL;
            BufferedReader bufferedReader;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeL = interceptable.invokeL(65541, null, file)) != null) {
                return (String) invokeL.objValue;
            }
            BufferedReader bufferedReader2 = null;
            String str = null;
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "utf-8"));
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine != null) {
                            if (readLine.startsWith(LINUX_ID_PREFIX)) {
                                break;
                            }
                        } else {
                            break;
                        }
                    } catch (IOException unused) {
                        closeQuietly(bufferedReader);
                        return null;
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader2 = bufferedReader;
                        closeQuietly(bufferedReader2);
                        throw th;
                    }
                }
                closeQuietly(bufferedReader);
                return str;
            } catch (IOException unused2) {
                bufferedReader = null;
            } catch (Throwable th2) {
                th = th2;
            }
        }

        public static String parseLinuxRedhatReleaseFile(File file) {
            InterceptResult invokeL;
            BufferedReader bufferedReader;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, file)) == null) {
                String str = "centos";
                BufferedReader bufferedReader2 = null;
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "utf-8"));
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine != null) {
                            String lowerCase = readLine.toLowerCase(Locale.US);
                            if (!lowerCase.contains("centos")) {
                                if (lowerCase.contains("fedora")) {
                                    str = "fedora";
                                } else if (!lowerCase.contains("red hat enterprise linux")) {
                                    closeQuietly(bufferedReader);
                                    return null;
                                } else {
                                    str = "rhel";
                                }
                            }
                            closeQuietly(bufferedReader);
                            return str;
                        }
                    } catch (IOException unused) {
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader2 = bufferedReader;
                        closeQuietly(bufferedReader2);
                        throw th;
                    }
                } catch (IOException unused2) {
                    bufferedReader = null;
                } catch (Throwable th2) {
                    th = th2;
                }
                closeQuietly(bufferedReader);
                return null;
            }
            return (String) invokeL.objValue;
        }
    }

    public PlatformDetector() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static String normalize(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) ? str == null ? "" : str.toLowerCase(Locale.US).replaceAll("[^a-z0-9]+", "") : (String) invokeL.objValue;
    }

    public static String normalizeArch(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) {
            String normalize = normalize(str);
            return normalize.matches("^(x8664|amd64|ia32e|em64t|x64)$") ? "x86_64" : normalize.matches("^(x8632|x86|i[3-6]86|ia32|x32)$") ? "x86_32" : normalize.matches("^(ia64|itanium64)$") ? "itanium_64" : normalize.matches("^(sparc|sparc32)$") ? "sparc_32" : normalize.matches("^(sparcv9|sparc64)$") ? "sparc_64" : (normalize.matches("^(arm|arm32)$") || normalize.startsWith("armv7")) ? "arm_32" : ("aarch64".equals(normalize) || normalize.startsWith("armv8")) ? "aarch_64" : normalize.matches("^(ppc|ppc32)$") ? "ppc_32" : "ppc64".equals(normalize) ? "ppc_64" : "ppc64le".equals(normalize) ? "ppcle_64" : "s390".equals(normalize) ? "s390_32" : "s390x".equals(normalize) ? "s390_64" : "unknown";
        }
        return (String) invokeL.objValue;
    }

    public static String normalizeOs(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            String normalize = normalize(str);
            return normalize.startsWith("aix") ? "aix" : normalize.startsWith("hpux") ? "hpux" : (!normalize.startsWith("os400") || (normalize.length() > 5 && Character.isDigit(normalize.charAt(5)))) ? normalize.startsWith("android") ? "android" : normalize.startsWith(Platform.LINUX) ? Platform.LINUX : normalize.startsWith(Platform.NATIVE_CLIENT) ? Platform.NATIVE_CLIENT : (normalize.startsWith(Platform.MACOSX) || normalize.startsWith("osx")) ? Platform.MACOSX : normalize.startsWith("freebsd") ? "freebsd" : normalize.startsWith("openbsd") ? "openbsd" : normalize.startsWith("netbsd") ? "netbsd" : (normalize.startsWith("solaris") || normalize.startsWith("sunos")) ? "sunos" : normalize.startsWith(Platform.WINDOWS) ? Platform.WINDOWS : "unknown" : "os400";
        }
        return (String) invokeL.objValue;
    }

    public static String normalizeOsReleaseValue(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) ? str.trim().replace("\"", "") : (String) invokeL.objValue;
    }
}
