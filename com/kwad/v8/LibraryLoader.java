package com.kwad.v8;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.v8.PlatformDetector;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.lang3.SystemUtils;
/* loaded from: classes4.dex */
public class LibraryLoader {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DELIMITER;
    public static final String KWAD_PREFIX = "kwad-";
    public static final String SEPARATOR;
    public static final String SWT_LIB_DIR = ".j2v8";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1939128652, "Lcom/kwad/v8/LibraryLoader;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1939128652, "Lcom/kwad/v8/LibraryLoader;");
                return;
            }
        }
        DELIMITER = System.getProperty("line.separator");
        SEPARATOR = System.getProperty("file.separator");
    }

    public LibraryLoader() {
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

    public static void chmod(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65538, null, str, str2) == null) || PlatformDetector.OS.isWindows()) {
            return;
        }
        try {
            Runtime.getRuntime().exec(new String[]{"chmod", str, str2}).waitFor();
        } catch (Throwable unused) {
        }
    }

    public static String computeLibraryFullName(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65539, null, z)) == null) {
            return "lib" + computeLibraryShortName(z) + "." + PlatformDetector.OS.getLibFileExtension();
        }
        return (String) invokeZ.objValue;
    }

    public static String computeLibraryShortName(boolean z) {
        InterceptResult invokeZ;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(InputDeviceCompat.SOURCE_TRACKBALL, null, z)) == null) {
            String name = (z && PlatformDetector.OS.isLinux()) ? PlatformDetector.Vendor.getName() : null;
            String name2 = PlatformDetector.OS.getName();
            String name3 = PlatformDetector.Arch.getName();
            StringBuilder sb = new StringBuilder();
            sb.append("kwad-j2v8");
            if (name != null) {
                str = "-" + name;
            } else {
                str = "";
            }
            sb.append(str);
            sb.append("-");
            sb.append(name2);
            sb.append("-");
            sb.append(name3);
            return sb.toString();
        }
        return (String) invokeZ.objValue;
    }

    public static boolean extract(String str, String str2, StringBuffer stringBuffer) {
        InterceptResult invokeLLL;
        InputStream inputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65541, null, str, str2, stringBuffer)) == null) {
            File file = new File(str);
            boolean z = true;
            FileOutputStream fileOutputStream = null;
            try {
                if (file.exists()) {
                    file.delete();
                }
                inputStream = LibraryLoader.class.getResourceAsStream("/" + str2);
                if (inputStream != null) {
                    try {
                        byte[] bArr = new byte[4096];
                        FileOutputStream fileOutputStream2 = new FileOutputStream(str);
                        while (true) {
                            try {
                                int read = inputStream.read(bArr);
                                if (read == -1) {
                                    break;
                                }
                                fileOutputStream2.write(bArr, 0, read);
                            } catch (Throwable unused) {
                                fileOutputStream = fileOutputStream2;
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (IOException unused2) {
                                    }
                                }
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (IOException unused3) {
                                    }
                                }
                                if (z && file.exists()) {
                                    file.delete();
                                }
                                return false;
                            }
                        }
                        fileOutputStream2.close();
                        inputStream.close();
                        chmod("755", str);
                        if (load(str, stringBuffer)) {
                            return true;
                        }
                    } catch (Throwable unused4) {
                    }
                }
            } catch (Throwable unused5) {
                inputStream = null;
                z = false;
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public static boolean extract(String str, boolean z, StringBuffer stringBuffer) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, null, new Object[]{str, Boolean.valueOf(z), stringBuffer})) == null) {
            String computeLibraryFullName = computeLibraryFullName(z);
            return extract(str + SEPARATOR + computeLibraryFullName, computeLibraryFullName, stringBuffer);
        }
        return invokeCommon.booleanValue;
    }

    public static boolean load(String str, StringBuffer stringBuffer) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, str, stringBuffer)) == null) {
            try {
                if (str.indexOf(SEPARATOR) != -1) {
                    System.load(str);
                    return true;
                }
                System.loadLibrary(str);
                return true;
            } catch (UnsatisfiedLinkError e2) {
                if (stringBuffer.length() == 0) {
                    stringBuffer.append(DELIMITER);
                }
                stringBuffer.append('\t');
                stringBuffer.append(e2.getMessage());
                stringBuffer.append(DELIMITER);
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public static void loadLibrary(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, str) == null) {
            if (PlatformDetector.OS.isAndroid()) {
                System.loadLibrary("kwad-j2v8");
                return;
            }
            StringBuffer stringBuffer = new StringBuffer();
            if (tryLoad(true, stringBuffer) || tryLoad(false, stringBuffer)) {
                return;
            }
            if (str == null) {
                str = System.getProperty(SystemUtils.JAVA_IO_TMPDIR_KEY);
            }
            if (extract(str, true, stringBuffer) || extract(str, false, stringBuffer)) {
                return;
            }
            throw new UnsatisfiedLinkError("Could not load J2V8 library. Reasons: " + stringBuffer.toString());
        }
    }

    public static boolean tryLoad(boolean z, StringBuffer stringBuffer) {
        InterceptResult invokeZL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZL = interceptable.invokeZL(65545, null, z, stringBuffer)) == null) {
            String computeLibraryShortName = computeLibraryShortName(z);
            String computeLibraryFullName = computeLibraryFullName(z);
            String str = System.getProperty(SystemUtils.USER_DIR_KEY) + SEPARATOR + "jni" + SEPARATOR + computeLibraryFullName;
            if (load(computeLibraryFullName, stringBuffer) || load(computeLibraryShortName, stringBuffer)) {
                return true;
            }
            return new File(str).exists() && load(str, stringBuffer);
        }
        return invokeZL.booleanValue;
    }
}
