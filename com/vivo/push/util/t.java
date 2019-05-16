package com.vivo.push.util;

import android.content.Context;
/* loaded from: classes3.dex */
public final class t extends a {
    private static t b;

    public static synchronized t b() {
        t tVar;
        synchronized (t.class) {
            if (b == null) {
                b = new t();
            }
            tVar = b;
        }
        return tVar;
    }

    public final void a(Context context) {
        if (this.a == null) {
            this.a = context;
            a(context, "com.vivo.push_preferences");
        }
    }
}
