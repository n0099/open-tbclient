package com.kwai.video.hodor.util;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes7.dex */
public class FileUtils {
    public static /* synthetic */ Interceptable $ic;
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

    public static long getAvailableBytes(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return 0L;
            }
            StatFs statFs = new StatFs(str);
            if (Build.VERSION.SDK_INT >= 18) {
                long availableBytes = statFs.getAvailableBytes();
                Timber.d("[getAvailableBytes] avilabeBytes new way:%dMB, path:%s", Long.valueOf(availableBytes / 1048576), str);
                return availableBytes;
            }
            long blockSize = statFs.getBlockSize() * statFs.getAvailableBlocks();
            Timber.d("[getAvailableBytes] avilabeBytes old way:%dMB, path:%s", Long.valueOf(blockSize / 1048576), str);
            return blockSize;
        }
        return invokeL.longValue;
    }

    public static File getDefaultCacheDir(@NonNull Context context, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65538, null, context, z)) == null) {
            String str = StringUtil.NULL_STRING;
            if (z) {
                File filesDir = context.getFilesDir();
                if (isValidDir(filesDir)) {
                    Timber.d("[getDefaultCacheDir] getFilesDir:%s is valid", filesDir.getAbsolutePath());
                    return filesDir;
                }
                Object[] objArr = new Object[1];
                objArr[0] = filesDir == null ? StringUtil.NULL_STRING : filesDir.getAbsolutePath();
                Timber.w("[getDefaultCacheDir] getFilesDir:%s is not valid", objArr);
            }
            File externalFilesDir = context.getApplicationContext().getExternalFilesDir(null);
            if (isValidDir(externalFilesDir)) {
                Timber.d("[getDefaultCacheDir] getExternalFilesDir:%s is valid", externalFilesDir.getAbsolutePath());
                return externalFilesDir;
            }
            Object[] objArr2 = new Object[1];
            objArr2[0] = externalFilesDir == null ? StringUtil.NULL_STRING : externalFilesDir.getAbsolutePath();
            Timber.w("[getDefaultCacheDir] getExternalFilesDir:%s is not valid", objArr2);
            File externalStorageDirectory = Environment.getExternalStorageDirectory();
            if (isValidDir(externalStorageDirectory)) {
                Timber.d("[getDefaultCacheDir] externalStorageDir:%s is valid", externalStorageDirectory.getAbsolutePath());
                return externalStorageDirectory;
            }
            Object[] objArr3 = new Object[1];
            objArr3[0] = externalStorageDirectory == null ? StringUtil.NULL_STRING : externalStorageDirectory.getAbsolutePath();
            Timber.w("[getDefaultCacheDir] externalStorageDir:%s is not valid", objArr3);
            File dir = context.getDir("gdata", 0);
            if (isValidDir(dir)) {
                Timber.d("[getDefaultCacheDir] getDir(gdata):%s is valid", dir.getAbsolutePath());
                return dir;
            }
            Object[] objArr4 = new Object[1];
            if (dir != null) {
                str = dir.getAbsolutePath();
            }
            objArr4[0] = str;
            Timber.e("[getDefaultCacheDir]AwesomeCache getDir(gdata) fail, Hodor won't work due to no valid cache dir path", objArr4);
            return null;
        }
        return (File) invokeLZ.objValue;
    }

    public static boolean isValidDir(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, file)) == null) {
            if (file == null) {
                return false;
            }
            try {
                if (!file.mkdirs()) {
                    file.mkdir();
                }
                if (file.exists()) {
                    return file.canWrite();
                }
                return false;
            } catch (Exception e2) {
                e2.printStackTrace();
                return file.exists() && file.canWrite();
            }
        }
        return invokeL.booleanValue;
    }
}
