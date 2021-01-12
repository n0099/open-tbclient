package com.kwad.sdk.api.loader;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private static File f8201a;

    private static File a(Context context) {
        if (f8201a == null) {
            f8201a = c(new File(context.getApplicationInfo().dataDir, "ksad_dynamic"));
        }
        return f8201a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static File a(Context context, String str) {
        return new File(a(context), "dynamic-" + System.currentTimeMillis() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + str + ".apk");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String b(Context context, String str) {
        return c(new File(a(context), "apk-" + str)).getPath();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(File file) {
        try {
            a(file);
        } catch (Exception e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static File c(Context context, String str) {
        return c(new File(a(context), "apk-" + str));
    }

    private static File c(File file) {
        if (file.exists() && file.isFile()) {
            file.delete();
        }
        if (!file.exists() || !file.isDirectory()) {
            if (!file.exists()) {
                file.mkdirs();
            }
            if (!file.exists() || !file.isDirectory()) {
                throw new RuntimeException("Can not ensureDir:" + file);
            }
        }
        return file;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String d(Context context, String str) {
        return new File(b(context, str), "dynamic.apk").getPath();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String e(Context context, String str) {
        return c(new File(b(context, str), "dex")).getPath();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String f(Context context, String str) {
        return c(new File(b(context, str), "libs")).getPath();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
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
                        if (f.a(str, file.getName().substring(file.getName().indexOf(Constants.ACCEPT_TIME_SEPARATOR_SERVER) + 1))) {
                            g.a(file);
                        }
                    }
                } catch (Exception e) {
                }
            }
        });
    }
}
