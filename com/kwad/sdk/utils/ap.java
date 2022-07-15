package com.kwad.sdk.utils;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.io.File;
/* loaded from: classes5.dex */
public final class ap {
    @NonNull
    public static String a(Context context) {
        File file;
        String str = "";
        try {
            str = Environment.getExternalStorageState();
        } catch (IncompatibleClassChangeError | NullPointerException unused) {
        }
        String str2 = null;
        if ("mounted".equals(str) || !Environment.isExternalStorageRemovable()) {
            try {
                file = context.getExternalFilesDir(null);
            } catch (Exception e) {
                com.kwad.sdk.core.d.b.a(e);
                file = null;
            }
            if (file != null) {
                str2 = file.getPath();
            }
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = context.getFilesDir().getPath();
        }
        return str2 + File.separator + "ksadsdk";
    }

    public static String a(Context context, String str) {
        if (context == null) {
            return "";
        }
        String f = f(context);
        return f + File.separator + "ksad/download/js/" + str;
    }

    public static File b(Context context) {
        File file;
        String str = "";
        try {
            str = Environment.getExternalStorageState();
        } catch (IncompatibleClassChangeError | NullPointerException unused) {
        }
        String str2 = null;
        if ("mounted".equals(str) || !Environment.isExternalStorageRemovable()) {
            try {
                file = context.getExternalCacheDir();
            } catch (Exception e) {
                com.kwad.sdk.core.d.b.a(e);
                file = null;
            }
            if (file != null) {
                str2 = file.getPath();
            }
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = context.getCacheDir().getPath();
        }
        return new File(str2 + File.separator + "ksadsdk");
    }

    public static File c(Context context) {
        String a = a(context);
        return new File(a + File.separator + "Download");
    }

    public static File d(Context context) {
        String str;
        if (com.kwad.b.kwai.a.b.booleanValue()) {
            str = a(context);
        } else {
            str = context.getFilesDir().getAbsolutePath() + File.separator + "ksadsdk";
        }
        return new File(str + File.separator + "ksadlog");
    }

    public static String e(Context context) {
        return b(context).getPath() + "/cookie";
    }

    public static String f(Context context) {
        if (context == null) {
            return "";
        }
        String path = context.getFilesDir().getPath();
        return path + File.separator + "ksadsdk";
    }
}
