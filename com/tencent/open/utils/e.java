package com.tencent.open.utils;

import android.content.Context;
import java.io.File;
/* loaded from: classes14.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    private static Context f7989a;

    public static final Context a() {
        if (f7989a == null) {
            return null;
        }
        return f7989a;
    }

    public static final void a(Context context) {
        f7989a = context;
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
