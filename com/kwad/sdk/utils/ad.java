package com.kwad.sdk.utils;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.io.File;
/* loaded from: classes5.dex */
public class ad {
    /* JADX WARN: Removed duplicated region for block: B:14:0x0025  */
    @NonNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(Context context) {
        String str;
        File file;
        String path;
        try {
            str = Environment.getExternalStorageState();
        } catch (IncompatibleClassChangeError e) {
            str = "";
        } catch (NullPointerException e2) {
            str = "";
        }
        if ("mounted".equals(str) || !Environment.isExternalStorageRemovable()) {
            try {
                file = context.getExternalFilesDir(null);
            } catch (Exception e3) {
                com.kwad.sdk.core.d.a.a(e3);
                file = null;
            }
            if (file != null) {
                path = file.getPath();
                if (TextUtils.isEmpty(path)) {
                    path = context.getFilesDir().getPath();
                }
                return path + File.separator + "ksadsdk";
            }
        }
        path = null;
        if (TextUtils.isEmpty(path)) {
        }
        return path + File.separator + "ksadsdk";
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static File b(Context context) {
        String str;
        File file;
        String path;
        try {
            str = Environment.getExternalStorageState();
        } catch (IncompatibleClassChangeError e) {
            str = "";
        } catch (NullPointerException e2) {
            str = "";
        }
        if ("mounted".equals(str) || !Environment.isExternalStorageRemovable()) {
            try {
                file = context.getExternalCacheDir();
            } catch (Exception e3) {
                com.kwad.sdk.core.d.a.a(e3);
                file = null;
            }
            if (file != null) {
                path = file.getPath();
                if (TextUtils.isEmpty(path)) {
                    path = context.getCacheDir().getPath();
                }
                return new File(path + File.separator + "ksadsdk");
            }
        }
        path = null;
        if (TextUtils.isEmpty(path)) {
        }
        return new File(path + File.separator + "ksadsdk");
    }

    public static File c(Context context) {
        return new File(a(context) + File.separator + "Download");
    }

    public static String d(Context context) {
        if (context == null) {
            return "";
        }
        return context.getFilesDir().getPath() + File.separator + "ksadsdk";
    }
}
