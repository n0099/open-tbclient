package com.kwad.sdk.api.loader;

import android.content.Context;
import java.io.File;
/* loaded from: classes5.dex */
public final class h {
    public static File Sq;

    public static String a(Context context, String str) {
        return e(new File(aG(context), "apk-".concat(String.valueOf(str)))).getPath();
    }

    public static File aG(Context context) {
        if (Sq == null) {
            Sq = e(new File(context.getApplicationInfo().dataDir, "ksad_dynamic"));
        }
        return Sq;
    }

    public static void d(File file) {
        if (file == null) {
            return;
        }
        if (file.isFile()) {
            file.delete();
            return;
        }
        File[] listFiles = file.listFiles();
        if (listFiles != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                d(file2);
            }
        }
        file.delete();
    }

    public static File e(File file) {
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

    public static void f(File file) {
        try {
            d(file);
        } catch (Exception unused) {
        }
    }

    public static File l(Context context, String str) {
        return e(new File(aG(context), "apk-".concat(String.valueOf(str))));
    }

    public static String m(Context context, String str) {
        return new File(a(context, str), "dynamic.apk").getPath();
    }

    public static String n(Context context, String str) {
        return e(new File(a(context, str), "dex")).getPath();
    }

    public static String o(Context context, String str) {
        return e(new File(a(context, str), "libs")).getPath();
    }
}
