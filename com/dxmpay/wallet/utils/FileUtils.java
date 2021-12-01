package com.dxmpay.wallet.utils;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
/* loaded from: classes12.dex */
public class FileUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "FileUtils";
    public transient /* synthetic */ FieldHolder $fh;

    public FileUtils() {
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

    public static boolean checkAndCreadFile(File file) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, file)) == null) {
            if (file.exists()) {
                return true;
            }
            file.getParentFile().mkdirs();
            return file.createNewFile();
        }
        return invokeL.booleanValue;
    }

    public static void deleteDir(File file, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(65538, null, file, z) == null) && file != null && file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null && listFiles.length > 0) {
                for (File file2 : listFiles) {
                    if (file2.isDirectory()) {
                        deleteDir(file2, z);
                    } else {
                        file2.delete();
                    }
                }
            }
            if (z) {
                file.delete();
            }
        }
    }

    public static boolean deleteFile(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (isNullOrEmptyWithoutTrim(str)) {
                return false;
            }
            if (isFileExist(str)) {
                return deleteFile(new File(str));
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static void ensureParent(File file) {
        File parentFile;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65541, null, file) == null) || file == null || (parentFile = file.getParentFile()) == null || parentFile.exists()) {
            return;
        }
        parentFile.mkdirs();
    }

    public static boolean existsFile(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65542, null, file)) == null) ? file != null && file.exists() && file.isFile() : invokeL.booleanValue;
    }

    public static boolean isFileExist(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            if (str == null) {
                return false;
            }
            return new File(str).exists();
        }
        return invokeL.booleanValue;
    }

    public static boolean isNullOrEmptyWithoutTrim(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) ? str == null || "".equals(str) : invokeL.booleanValue;
    }

    public static boolean write(File file, byte[] bArr) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, file, bArr)) == null) ? write(file, bArr, true) : invokeLL.booleanValue;
    }

    public static boolean write(File file, byte[] bArr, boolean z) throws IOException {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLLZ = interceptable.invokeLLZ(65546, null, file, bArr, z)) != null) {
            return invokeLLZ.booleanValue;
        }
        FileOutputStream fileOutputStream = null;
        try {
            if (!file.exists()) {
                file.getParentFile().mkdirs();
                file.createNewFile();
            }
            if (file.canWrite()) {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file, z);
                try {
                    fileOutputStream2.write(bArr);
                    fileOutputStream2.close();
                    return true;
                } catch (Throwable unused) {
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    return false;
                }
            }
            return false;
        } catch (Throwable unused2) {
        }
    }

    public static boolean deleteFile(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, file)) == null) {
            try {
                return file.delete();
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }
}
