package com.kwad.sdk.utils;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import java.io.File;
/* loaded from: classes10.dex */
public final class aw {
    public static String aOc;
    public static File aOd;

    public static boolean KX() {
        try {
            if (!"mounted".equals(Environment.getExternalStorageState())) {
                if (Environment.isExternalStorageRemovable()) {
                    return false;
                }
                return true;
            }
            return true;
        } catch (Throwable th) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(th);
            return false;
        }
    }

    public static String cJ(Context context) {
        if (!TextUtils.isEmpty(aOc)) {
            return aOc;
        }
        String str = null;
        if (KX()) {
            try {
                File externalFilesDir = context.getExternalFilesDir(null);
                if (externalFilesDir != null) {
                    str = externalFilesDir.getPath();
                }
            } catch (Exception e) {
                com.kwad.sdk.core.e.c.printStackTrace(e);
            }
        }
        if (TextUtils.isEmpty(str)) {
            str = context.getFilesDir().getPath();
        }
        String str2 = str + File.separator + "ksadsdk";
        aOc = str2;
        return str2;
    }

    public static File cK(Context context) {
        File file = aOd;
        if (file != null) {
            return file;
        }
        String str = null;
        if (KX()) {
            try {
                File externalCacheDir = context.getExternalCacheDir();
                if (externalCacheDir != null) {
                    str = externalCacheDir.getPath();
                }
            } catch (Exception e) {
                com.kwad.sdk.core.e.c.printStackTrace(e);
            }
        }
        if (TextUtils.isEmpty(str)) {
            str = context.getCacheDir().getPath();
        }
        File file2 = new File(str + File.separator + "ksadsdk");
        aOd = file2;
        if (!file2.exists()) {
            aOd.mkdirs();
        }
        return aOd;
    }

    public static File cN(Context context) {
        String str;
        if (com.kwad.framework.a.a.mc.booleanValue()) {
            str = cJ(context);
        } else {
            str = context.getFilesDir().getAbsolutePath() + File.separator + "ksadsdk";
        }
        return new File(str + File.separator + "ksadlog");
    }

    public static File cL(Context context) {
        String cJ = cJ(context);
        File file = new File(cJ + File.separator + "Download");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File cM(Context context) {
        String cJ = cJ(context);
        File file = new File(cJ + File.separator + "downloadFileSync/.temp");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static String cO(Context context) {
        if (context == null) {
            return "";
        }
        String path = context.getFilesDir().getPath();
        return path + File.separator + "ksadsdk";
    }

    public static String cP(Context context) {
        return cK(context).getPath() + "/cookie";
    }

    public static String getTkJsRootDir(Context context) {
        if (context == null) {
            return "";
        }
        String cO = cO(context);
        return cO + File.separator + "ksad/download/js";
    }

    public static String getTkJsFileDir(Context context, String str) {
        if (context == null) {
            return "";
        }
        String cO = cO(context);
        return cO + File.separator + "ksad/download/js" + File.separator + str;
    }
}
