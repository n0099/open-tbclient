package com.kwad.sdk.api.loader;

import android.content.Context;
import java.io.File;
/* loaded from: classes5.dex */
public final class h {
    public static File a;

    public static File a(Context context) {
        if (a == null) {
            a = b(new File(context.getApplicationInfo().dataDir, "ksad_dynamic"));
        }
        return a;
    }

    public static String a(Context context, String str) {
        return b(new File(a(context), "apk-".concat(String.valueOf(str)))).getPath();
    }

    public static void a(File file) {
        if (file.isFile()) {
            file.delete();
            return;
        }
        File[] listFiles = file.listFiles();
        if (listFiles != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                a(file2);
            }
        }
        file.delete();
    }

    public static File b(Context context, String str) {
        return b(new File(a(context), "apk-".concat(String.valueOf(str))));
    }

    public static File b(File file) {
        if (file.exists() && file.isFile()) {
            file.delete();
        }
        if (file.exists() && file.isDirectory()) {
            return file;
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        if (file.exists() && file.isDirectory()) {
            return file;
        }
        throw new RuntimeException("Can not ensureDir:".concat(String.valueOf(file)));
    }

    public static String c(Context context, String str) {
        return new File(a(context, str), "dynamic.apk").getPath();
    }

    public static String d(Context context, String str) {
        return b(new File(a(context, str), "dex")).getPath();
    }

    public static String e(Context context, String str) {
        return b(new File(a(context, str), "libs")).getPath();
    }
}
