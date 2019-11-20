package com.xiaomi.push;

import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import java.io.File;
/* loaded from: classes3.dex */
public class aa {
    public static long a() {
        File externalStorageDirectory;
        if (b() || (externalStorageDirectory = Environment.getExternalStorageDirectory()) == null || TextUtils.isEmpty(externalStorageDirectory.getPath())) {
            return 0L;
        }
        try {
            StatFs statFs = new StatFs(externalStorageDirectory.getPath());
            return (statFs.getAvailableBlocks() - 4) * statFs.getBlockSize();
        } catch (Throwable th) {
            return 0L;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m106a() {
        try {
            return Environment.getExternalStorageState().equals("removed");
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            return true;
        }
    }

    public static boolean b() {
        try {
            return !Environment.getExternalStorageState().equals("mounted");
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            return true;
        }
    }

    public static boolean c() {
        return a() <= 102400;
    }

    public static boolean d() {
        return (b() || c() || m106a()) ? false : true;
    }
}
