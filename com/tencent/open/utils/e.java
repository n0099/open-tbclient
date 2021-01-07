package com.tencent.open.utils;

import android.content.Context;
import java.io.File;
/* loaded from: classes4.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    private static Context f13731a;

    public static final Context a() {
        if (f13731a == null) {
            return null;
        }
        return f13731a;
    }

    public static final void a(Context context) {
        f13731a = context;
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
