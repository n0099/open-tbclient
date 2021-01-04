package com.kwai.video.hodor.util;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.io.File;
/* loaded from: classes5.dex */
public class FileUtils {
    public static long getAvailableBytes(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        StatFs statFs = new StatFs(str);
        if (Build.VERSION.SDK_INT >= 18) {
            long availableBytes = statFs.getAvailableBytes();
            Timber.d("[getAvailableBytes] avilabeBytes new way:%dMB, path:%s", Long.valueOf(availableBytes / 1048576), str);
            return availableBytes;
        }
        long availableBlocks = statFs.getAvailableBlocks() * statFs.getBlockSize();
        Timber.d("[getAvailableBytes] avilabeBytes old way:%dMB, path:%s", Long.valueOf(availableBlocks / 1048576), str);
        return availableBlocks;
    }

    public static File getDefaultCacheDir(@NonNull Context context, boolean z) {
        if (z) {
            File filesDir = context.getFilesDir();
            if (isValidDir(filesDir)) {
                Timber.d("[getDefaultCacheDir] getFilesDir:%s is valid", filesDir.getAbsolutePath());
                return filesDir;
            }
            Object[] objArr = new Object[1];
            objArr[0] = filesDir == null ? "null" : filesDir.getAbsolutePath();
            Timber.w("[getDefaultCacheDir] getFilesDir:%s is not valid", objArr);
        }
        File externalFilesDir = context.getApplicationContext().getExternalFilesDir(null);
        if (isValidDir(externalFilesDir)) {
            Timber.d("[getDefaultCacheDir] getExternalFilesDir:%s is valid", externalFilesDir.getAbsolutePath());
            return externalFilesDir;
        }
        Object[] objArr2 = new Object[1];
        objArr2[0] = externalFilesDir == null ? "null" : externalFilesDir.getAbsolutePath();
        Timber.w("[getDefaultCacheDir] getExternalFilesDir:%s is not valid", objArr2);
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        if (isValidDir(externalStorageDirectory)) {
            Timber.d("[getDefaultCacheDir] externalStorageDir:%s is valid", externalStorageDirectory.getAbsolutePath());
            return externalStorageDirectory;
        }
        Object[] objArr3 = new Object[1];
        objArr3[0] = externalStorageDirectory == null ? "null" : externalStorageDirectory.getAbsolutePath();
        Timber.w("[getDefaultCacheDir] externalStorageDir:%s is not valid", objArr3);
        File dir = context.getDir("gdata", 0);
        if (isValidDir(dir)) {
            Timber.d("[getDefaultCacheDir] getDir(gdata):%s is valid", dir.getAbsolutePath());
            return dir;
        }
        Object[] objArr4 = new Object[1];
        objArr4[0] = dir == null ? "null" : dir.getAbsolutePath();
        Timber.e("[getDefaultCacheDir]AwesomeCache getDir(gdata) fail, Hodor won't work due to no valid cache dir path", objArr4);
        return null;
    }

    public static boolean isValidDir(File file) {
        if (file == null) {
            return false;
        }
        try {
            if (!file.mkdirs()) {
                file.mkdir();
            }
            if (file.exists()) {
                if (file.canWrite()) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return file.exists() && file.canWrite();
        }
    }
}
