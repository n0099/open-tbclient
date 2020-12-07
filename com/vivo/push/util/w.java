package com.vivo.push.util;

import android.content.Context;
/* loaded from: classes11.dex */
public final class w extends a {
    private static w b;

    public static synchronized w b() {
        w wVar;
        synchronized (w.class) {
            if (b == null) {
                b = new w();
            }
            wVar = b;
        }
        return wVar;
    }

    public final void a(Context context) {
        if (this.f4468a == null) {
            this.f4468a = context;
            a(context, "com.vivo.push_preferences");
        }
    }
}
