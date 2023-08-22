package com.xiaomi.push;

import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.down.statistic.ConfigSpeedStat;
import java.io.File;
/* loaded from: classes10.dex */
public class aa {
    public static long a() {
        File externalStorageDirectory;
        if (!b() && (externalStorageDirectory = Environment.getExternalStorageDirectory()) != null && !TextUtils.isEmpty(externalStorageDirectory.getPath())) {
            try {
                StatFs statFs = new StatFs(externalStorageDirectory.getPath());
                return statFs.getBlockSize() * (statFs.getAvailableBlocks() - 4);
            } catch (Throwable unused) {
            }
        }
        return 0L;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m254a() {
        try {
            return Environment.getExternalStorageState().equals("removed");
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            return true;
        }
    }

    public static boolean b() {
        try {
            return true ^ Environment.getExternalStorageState().equals("mounted");
        } catch (Exception e) {
            Log.e("XMPush-", "check SDCard is busy: " + e);
            return true;
        }
    }

    public static boolean c() {
        return a() <= ConfigSpeedStat.CFG_MIN_SIZE_DEFAULT;
    }

    public static boolean d() {
        return (b() || c() || m254a()) ? false : true;
    }
}
