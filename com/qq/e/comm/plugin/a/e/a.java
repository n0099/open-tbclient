package com.qq.e.comm.plugin.a.e;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.qq.e.comm.plugin.a.c;
import com.qq.e.comm.plugin.util.ah;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import java.io.File;
/* loaded from: classes4.dex */
public class a {
    public static File a(File file, c cVar) {
        return new File(file, a(cVar.h()) + ".apk");
    }

    public static String a(String str) {
        return str;
    }

    public static boolean a(Context context, String str) {
        if (StringUtil.isEmpty(str)) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo(str, 256) != null;
        } catch (Throwable th) {
            return false;
        }
    }

    public static boolean a(c cVar) {
        File h = ah.h();
        if (h == null) {
            return false;
        }
        return a(h, cVar).exists();
    }

    public static boolean a(File file, String str, Context context) {
        if (file == null || !file.exists()) {
            return false;
        }
        PackageInfo packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(file.getAbsolutePath(), 1);
        if (packageArchiveInfo == null) {
            GDTLogger.e("apk file does not fit current system");
            return false;
        }
        return packageArchiveInfo.packageName.equals(str);
    }
}
