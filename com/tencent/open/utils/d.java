package com.tencent.open.utils;

import android.content.Context;
import java.io.File;
/* loaded from: classes3.dex */
public final class d {
    private static Context a;

    public static final Context a() {
        if (a == null) {
            return null;
        }
        return a;
    }

    public static final void a(Context context) {
        a = context;
    }

    public static final String b() {
        return a() == null ? "" : a().getPackageName();
    }

    public static final File c() {
        if (a() == null) {
            return null;
        }
        return a().getFilesDir();
    }
}
