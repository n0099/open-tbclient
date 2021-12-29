package com.tachikoma.core.utility;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import org.apache.commons.lang3.StringUtils;
/* loaded from: classes4.dex */
public class FileUtil {
    public static /* synthetic */ Interceptable $ic = null;
    public static final char SYSTEM_SEPARATOR;
    public static final char WINDOWS_SEPARATOR = '\\';
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-462231932, "Lcom/tachikoma/core/utility/FileUtil;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-462231932, "Lcom/tachikoma/core/utility/FileUtil;");
                return;
            }
        }
        SYSTEM_SEPARATOR = File.separatorChar;
    }

    public FileUtil() {
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

    public static void cleanDirectory(File file) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, file) == null) {
            if (!file.exists()) {
                throw new IllegalArgumentException(file + " does not exist");
            } else if (!file.isDirectory()) {
                throw new IllegalArgumentException(file + " is not a directory");
            } else {
                File[] listFiles = file.listFiles();
                if (listFiles == null) {
                    throw new IOException("Failed to list contents of " + file);
                }
                IOException e2 = null;
                for (File file2 : listFiles) {
                    try {
                        forceDelete(file2);
                    } catch (IOException e3) {
                        e2 = e3;
                    }
                }
                if (e2 != null) {
                    throw e2;
                }
            }
        }
    }

    public static String convertStreamToString(InputStream inputStream) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65539, null, inputStream)) != null) {
            return (String) invokeL.objValue;
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                bufferedReader.close();
                return sb.toString();
            }
            sb.append(readLine);
            sb.append(StringUtils.LF);
        }
    }

    public static void copyInputStreamToFile(InputStream inputStream, File file) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, inputStream, file) == null) {
            try {
                FileOutputStream openOutputStream = openOutputStream(file);
                IOUtils.copy(inputStream, openOutputStream);
                openOutputStream.close();
                CloseableUtil.closeQuietly((OutputStream) openOutputStream);
            } finally {
                CloseableUtil.closeQuietly(inputStream);
            }
        }
    }

    public static void deleteContents(@NonNull File file) {
        File[] listFiles;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65541, null, file) == null) && file.exists() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    deleteContents(file2);
                }
                file2.delete();
            }
        }
    }

    public static void deleteDirectory(File file) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65542, null, file) == null) && file.exists()) {
            if (!isSymlink(file)) {
                cleanDirectory(file);
            }
            if (file.delete()) {
                return;
            }
            throw new IOException("Unable to delete directory " + file + ".");
        }
    }

    public static boolean deleteQuietly(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, file)) == null) {
            if (file == null) {
                return false;
            }
            try {
                if (file.isDirectory()) {
                    cleanDirectory(file);
                }
            } catch (Exception unused) {
            }
            try {
                return file.delete();
            } catch (Exception unused2) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean exists(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) {
            if (str == null || str.length() <= 0) {
                return false;
            }
            return new File(str).exists();
        }
        return invokeL.booleanValue;
    }

    public static void forceDelete(File file) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, file) == null) {
            if (file.isDirectory()) {
                deleteDirectory(file);
                return;
            }
            boolean exists = file.exists();
            if (file.delete()) {
                return;
            }
            if (exists) {
                throw new IOException("Unable to delete file: " + file);
            }
            throw new FileNotFoundException("File does not exist: " + file);
        }
    }

    public static boolean isSymlink(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, file)) == null) {
            if (file != null) {
                if (isSystemWindows()) {
                    return false;
                }
                if (file.getParent() != null) {
                    file = new File(file.getParentFile().getCanonicalFile(), file.getName());
                }
                return !file.getCanonicalFile().equals(file.getAbsoluteFile());
            }
            throw new NullPointerException("File must not be null");
        }
        return invokeL.booleanValue;
    }

    public static boolean isSystemWindows() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) ? SYSTEM_SEPARATOR == '\\' : invokeV.booleanValue;
    }

    public static FileOutputStream openOutputStream(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65548, null, file)) == null) ? openOutputStream(file, false) : (FileOutputStream) invokeL.objValue;
    }

    public static FileOutputStream openOutputStream(File file, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65549, null, file, z)) == null) {
            if (!file.exists()) {
                File parentFile = file.getParentFile();
                if (parentFile != null && !parentFile.mkdirs() && !parentFile.isDirectory()) {
                    throw new IOException("Directory '" + parentFile + "' could not be created");
                }
            } else if (file.isDirectory()) {
                throw new IOException("File '" + file + "' exists but is a directory");
            } else if (!file.canWrite()) {
                throw new IOException("File '" + file + "' cannot be written to");
            }
            return new FileOutputStream(file, z);
        }
        return (FileOutputStream) invokeLZ.objValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:13:0x0017 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.io.FileInputStream] */
    public static String readFileAsString(File file) {
        InterceptResult invokeL;
        FileInputStream fileInputStream;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65550, null, file)) != null) {
            return (String) invokeL.objValue;
        }
        ?? r0 = 0;
        try {
            if (file == null) {
                return null;
            }
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    String convertStreamToString = convertStreamToString(fileInputStream);
                    try {
                        fileInputStream.close();
                    } catch (IOException unused) {
                    }
                    return convertStreamToString;
                } catch (IOException e2) {
                    e = e2;
                    e.printStackTrace();
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException unused2) {
                        }
                    }
                    return null;
                }
            } catch (IOException e3) {
                e = e3;
                fileInputStream = null;
            } catch (Throwable th) {
                th = th;
                if (r0 != 0) {
                    try {
                        r0.close();
                    } catch (IOException unused3) {
                    }
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            r0 = interceptable;
        }
    }
}
