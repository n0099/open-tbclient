package com.qq.e.comm.util;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
/* loaded from: classes9.dex */
public class FileUtil {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public FileUtil() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static boolean copyTo(InputStream inputStream, File file) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, inputStream, file)) == null) {
            if (inputStream == null || file == null) {
                return false;
            }
            FileOutputStream fileOutputStream = null;
            try {
                if (file.getParentFile().exists() || file.getParentFile().mkdirs()) {
                    FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                    try {
                        byte[] bArr = new byte[16384];
                        while (true) {
                            int read = inputStream.read(bArr);
                            if (read <= 0) {
                                tryClose(inputStream);
                                tryClose(fileOutputStream2);
                                return true;
                            }
                            fileOutputStream2.write(bArr, 0, read);
                        }
                    } catch (Throwable unused) {
                        fileOutputStream = fileOutputStream2;
                        try {
                            GDTLogger.d(String.format("Exception while copy from InputStream to File %s", file.getAbsolutePath()));
                            return false;
                        } finally {
                            tryClose(inputStream);
                            tryClose(fileOutputStream);
                        }
                    }
                }
            } catch (Throwable unused2) {
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static String getFileName(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? Md5Util.encode(str) : (String) invokeL.objValue;
    }

    public static String getTempFileName(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            return Md5Util.encode(str) + ".temp";
        }
        return (String) invokeL.objValue;
    }

    public static boolean renameTo(File file, File file2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, file, file2)) == null) {
            if (file == null || file2 == null || !file.exists()) {
                return false;
            }
            if (file.renameTo(file2)) {
                return true;
            }
            return copyTo(null, file2);
        }
        return invokeLL.booleanValue;
    }

    public static void tryClose(InputStream inputStream) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65541, null, inputStream) == null) || inputStream == null) {
            return;
        }
        try {
            inputStream.close();
        } catch (Exception unused) {
        }
    }

    public static void tryClose(OutputStream outputStream) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65542, null, outputStream) == null) || outputStream == null) {
            return;
        }
        try {
            outputStream.close();
        } catch (Exception unused) {
        }
    }
}
