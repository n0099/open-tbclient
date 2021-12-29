package com.kwad.sdk.api.loader;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.nps.utils.Constant;
import java.io.File;
/* loaded from: classes3.dex */
public class g {
    public static File a;

    public static File a(Context context) {
        if (a == null) {
            a = c(new File(context.getApplicationInfo().dataDir, "ksad_dynamic"));
        }
        return a;
    }

    public static File a(Context context, String str) {
        File a2 = a(context);
        return new File(a2, "dynamic-" + System.currentTimeMillis() + "-" + str + Constant.FILE.SUFFIX.BUNDLE_SUFFIX);
    }

    public static void a(File file) {
        File[] listFiles;
        if (!file.isFile() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                a(file2);
            }
        }
        file.delete();
    }

    public static String b(Context context, String str) {
        File a2 = a(context);
        return c(new File(a2, "apk-" + str)).getPath();
    }

    public static void b(File file) {
        try {
            a(file);
        } catch (Exception unused) {
        }
    }

    public static File c(Context context, String str) {
        File a2 = a(context);
        return c(new File(a2, "apk-" + str));
    }

    public static File c(File file) {
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
        throw new RuntimeException("Can not ensureDir:" + file);
    }

    public static String d(Context context, String str) {
        return new File(b(context, str), "dynamic.apk").getPath();
    }

    public static String e(Context context, String str) {
        return c(new File(b(context, str), "dex")).getPath();
    }

    public static String f(Context context, String str) {
        return c(new File(b(context, str), "libs")).getPath();
    }

    public static void g(final Context context, final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        i.a(new Runnable() { // from class: com.kwad.sdk.api.loader.g.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    File[] listFiles = g.c(context, str).getParentFile().listFiles();
                    if (listFiles == null || listFiles.length <= 0) {
                        return;
                    }
                    for (File file : listFiles) {
                        if (f.a(str, file.getName().substring(file.getName().indexOf("-") + 1))) {
                            g.a(file);
                        }
                    }
                } catch (Exception unused) {
                }
            }
        });
    }
}
