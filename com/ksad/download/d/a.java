package com.ksad.download.d;

import android.os.Build;
import android.os.StatFs;
import android.text.TextUtils;
import java.io.File;
/* loaded from: classes5.dex */
public class a {
    public static long a(String str) {
        StatFs statFs = new StatFs(str);
        if (Build.VERSION.SDK_INT >= 18) {
            try {
                return statFs.getAvailableBytes();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return statFs.getAvailableBlocks() * statFs.getBlockSize();
    }

    public static boolean a(File file) {
        return file != null && file.exists();
    }

    public static String b(String str) {
        int lastIndexOf;
        return (!TextUtils.isEmpty(str) && (lastIndexOf = str.lastIndexOf(46)) >= 0) ? str.substring(lastIndexOf + 1) : "";
    }
}
