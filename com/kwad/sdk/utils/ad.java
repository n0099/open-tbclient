package com.kwad.sdk.utils;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.io.File;
/* loaded from: classes6.dex */
public class ad {
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
            } catch (Exception e2) {
                com.kwad.sdk.core.d.a.a(e2);
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
            } catch (Exception e2) {
                com.kwad.sdk.core.d.a.a(e2);
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
        String a2 = a(context);
        return new File(a2 + File.separator + "Download");
    }

    public static String d(Context context) {
        if (context == null) {
            return "";
        }
        String path = context.getFilesDir().getPath();
        return path + File.separator + "ksadsdk";
    }
}
