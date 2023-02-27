package com.tencent.open.utils;

import android.content.Context;
import java.io.File;
/* loaded from: classes8.dex */
public final class f {
    public static Context a;

    public static final Context a() {
        Context context = a;
        if (context == null) {
            return null;
        }
        return context;
    }

    public static final String b() {
        if (a() == null) {
            return "";
        }
        return a().getPackageName();
    }

    public static final File c() {
        if (a() == null) {
            return null;
        }
        return a().getFilesDir();
    }

    public static final File d() {
        Context a2 = a();
        if (a2 != null) {
            return a2.getCacheDir();
        }
        return null;
    }

    public static final File e() {
        return a((String) null);
    }

    public static final File a(String str) {
        return l.h(a(), str);
    }

    public static final void a(Context context) {
        a = context;
    }
}
