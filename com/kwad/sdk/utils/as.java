package com.kwad.sdk.utils;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import java.io.File;
/* loaded from: classes8.dex */
public final class as {
    public static boolean An() {
        try {
            if ("mounted".equals(Environment.getExternalStorageState())) {
                return true;
            }
            return !Environment.isExternalStorageRemovable();
        } catch (Throwable th) {
            com.kwad.sdk.core.e.b.printStackTraceOnly(th);
            return false;
        }
    }

    public static String cX(Context context) {
        String str = null;
        if (An()) {
            try {
                File externalFilesDir = context.getExternalFilesDir(null);
                if (externalFilesDir != null) {
                    str = externalFilesDir.getPath();
                }
            } catch (Exception e) {
                com.kwad.sdk.core.e.b.printStackTrace(e);
            }
        }
        if (TextUtils.isEmpty(str)) {
            str = context.getFilesDir().getPath();
        }
        return str + File.separator + "ksadsdk";
    }

    public static File cY(Context context) {
        String str = null;
        if (An()) {
            try {
                File externalCacheDir = context.getExternalCacheDir();
                if (externalCacheDir != null) {
                    str = externalCacheDir.getPath();
                }
            } catch (Exception e) {
                com.kwad.sdk.core.e.b.printStackTrace(e);
            }
        }
        if (TextUtils.isEmpty(str)) {
            str = context.getCacheDir().getPath();
        }
        return new File(str + File.separator + "ksadsdk");
    }

    public static File cZ(Context context) {
        String cX = cX(context);
        return new File(cX + File.separator + "Download");
    }

    public static File da(Context context) {
        String str;
        if (com.kwad.b.kwai.a.aw.booleanValue()) {
            str = cX(context);
        } else {
            str = context.getFilesDir().getAbsolutePath() + File.separator + "ksadsdk";
        }
        return new File(str + File.separator + "ksadlog");
    }

    public static String db(Context context) {
        if (context == null) {
            return "";
        }
        String path = context.getFilesDir().getPath();
        return path + File.separator + "ksadsdk";
    }

    public static String dc(Context context) {
        return cY(context).getPath() + "/cookie";
    }

    public static String getTkJsFileDir(Context context, String str) {
        if (context == null) {
            return "";
        }
        String db = db(context);
        return db + File.separator + "ksad/download/js/" + str;
    }
}
