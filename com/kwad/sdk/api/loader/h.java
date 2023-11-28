package com.kwad.sdk.api.loader;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.nps.utils.Constant;
import java.io.File;
/* loaded from: classes10.dex */
public final class h {
    public static File alL;

    public static File aB(Context context) {
        if (alL == null) {
            alL = i(new File(context.getApplicationInfo().dataDir, "ksad_dynamic"));
        }
        return alL;
    }

    public static void h(File file) {
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
                h(file2);
            }
        }
        file.delete();
    }

    public static void j(File file) {
        try {
            h(file);
        } catch (Exception unused) {
        }
    }

    public static File i(File file) {
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
        if (!com.kwad.sdk.api.a.mc.booleanValue()) {
            return file;
        }
        throw new RuntimeException("Can not ensureDir:" + file);
    }

    public static File p(Context context, String str) {
        File aB = aB(context);
        return new File(aB, "dynamic-" + System.currentTimeMillis() + "-" + str + Constant.FILE.SUFFIX.BUNDLE_SUFFIX);
    }

    public static String q(Context context, String str) {
        File aB = aB(context);
        return i(new File(aB, "apk-" + str)).getPath();
    }

    public static File r(Context context, String str) {
        File aB = aB(context);
        return i(new File(aB, "apk-" + str));
    }

    public static String s(Context context, String str) {
        return new File(q(context, str), "dynamic.apk").getPath();
    }

    public static String t(Context context, String str) {
        return i(new File(q(context, str), "dex")).getPath();
    }

    public static String u(Context context, String str) {
        return i(new File(q(context, str), "libs")).getPath();
    }

    public static void v(final Context context, final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.kwad.sdk.api.a.a.submit(new Runnable() { // from class: com.kwad.sdk.api.loader.h.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    File[] listFiles = h.r(context, str).getParentFile().listFiles();
                    if (listFiles != null && listFiles.length > 0) {
                        for (File file : listFiles) {
                            if (g.G(str, file.getName().substring(file.getName().indexOf("-") + 1))) {
                                h.h(file);
                            }
                        }
                    }
                } catch (Exception unused) {
                }
            }
        });
    }
}
