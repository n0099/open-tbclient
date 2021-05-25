package com.tencent.open.utils;

import android.content.Context;
import java.io.File;
/* loaded from: classes7.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    public static Context f36467a;

    public static final Context a() {
        Context context = f36467a;
        if (context == null) {
            return null;
        }
        return context;
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

    public static final void a(Context context) {
        f36467a = context;
    }
}
