package com.huawei.hms.framework.common;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.libcore.io.ExternalStorageFile;
import com.huawei.libcore.io.ExternalStorageFileInputStream;
import com.huawei.libcore.io.ExternalStorageFileOutputStream;
import com.huawei.libcore.io.ExternalStorageRandomAccessFile;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes9.dex */
public class CreateFileUtil {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String EXTERNAL_FILE_NAME = "com.huawei.libcore.io.ExternalStorageFile";
    public static final String EXTERNAL_INPUTSTREAM_NAME = "com.huawei.libcore.io.ExternalStorageFileInputStream";
    public static final String EXTERNAL_OUTPUTSTREAM_NAME = "com.huawei.libcore.io.ExternalStorageFileOutputStream";
    public static final String RANDOM_ACCESS_FILE_NAME = "com.huawei.libcore.io.ExternalStorageRandomAccessFile";
    public static final String TAG = "CreateFileUtil";
    public transient /* synthetic */ FieldHolder $fh;

    public CreateFileUtil() {
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

    @Deprecated
    public static boolean isPVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            return EmuiUtil.isUpPVersion();
        }
        return invokeV.booleanValue;
    }

    public static void deleteSecure(File file) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, file) == null) && file != null && file.exists() && !file.delete()) {
            Logger.w(TAG, "deleteSecure exception");
        }
    }

    public static String getCacheDirPath(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            if (context == null) {
                return "";
            }
            return ContextCompat.getProtectedStorageContext(context).getCacheDir().getPath();
        }
        return (String) invokeL.objValue;
    }

    public static void deleteSecure(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, null, str) == null) && !TextUtils.isEmpty(str)) {
            deleteSecure(newFile(str));
        }
    }

    public static String getCanonicalPath(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            try {
                return newFile(str).getCanonicalPath();
            } catch (IOException e) {
                Logger.w(TAG, "the canonicalPath has IOException", e);
                return str;
            } catch (SecurityException e2) {
                Logger.w(TAG, "the canonicalPath has securityException", e2);
                return str;
            } catch (Exception e3) {
                Logger.w(TAG, "the canonicalPath has other Exception", e3);
                return str;
            }
        }
        return (String) invokeL.objValue;
    }

    public static File newFile(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) {
            if (str == null) {
                return null;
            }
            if (EmuiUtil.isUpPVersion() && ReflectionUtils.checkCompatible(EXTERNAL_FILE_NAME)) {
                return new ExternalStorageFile(str);
            }
            return new File(str);
        }
        return (File) invokeL.objValue;
    }

    public static FileInputStream newFileInputStream(String str) throws FileNotFoundException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            if (str != null) {
                if (EmuiUtil.isUpPVersion() && ReflectionUtils.checkCompatible(EXTERNAL_INPUTSTREAM_NAME)) {
                    return new ExternalStorageFileInputStream(str);
                }
                return new FileInputStream(str);
            }
            Logger.w(TAG, "newFileInputStream  file is null");
            throw new FileNotFoundException("file is null");
        }
        return (FileInputStream) invokeL.objValue;
    }

    public static FileOutputStream newFileOutputStream(File file) throws FileNotFoundException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, file)) == null) {
            if (file != null) {
                if (EmuiUtil.isUpPVersion() && ReflectionUtils.checkCompatible(EXTERNAL_OUTPUTSTREAM_NAME)) {
                    return new ExternalStorageFileOutputStream(file);
                }
                return new FileOutputStream(file);
            }
            Logger.e(TAG, "newFileOutputStream  file is null");
            throw new FileNotFoundException("file is null");
        }
        return (FileOutputStream) invokeL.objValue;
    }

    public static RandomAccessFile newRandomAccessFile(String str, String str2) throws FileNotFoundException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, str, str2)) == null) {
            if (str != null) {
                if (EmuiUtil.isUpPVersion() && ReflectionUtils.checkCompatible(RANDOM_ACCESS_FILE_NAME)) {
                    return new ExternalStorageRandomAccessFile(str, str2);
                }
                return new RandomAccessFile(str, str2);
            }
            Logger.w(TAG, "newFileOutputStream  file is null");
            throw new FileNotFoundException("file is null");
        }
        return (RandomAccessFile) invokeLL.objValue;
    }
}
