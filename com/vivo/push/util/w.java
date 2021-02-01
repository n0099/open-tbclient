package com.vivo.push.util;

import android.content.Context;
/* loaded from: classes15.dex */
public final class w extends a {

    /* renamed from: b  reason: collision with root package name */
    private static w f13704b;

    public static synchronized w b() {
        w wVar;
        synchronized (w.class) {
            if (f13704b == null) {
                f13704b = new w();
            }
            wVar = f13704b;
        }
        return wVar;
    }

    public final void a(Context context) {
        if (this.f13683a == null) {
            this.f13683a = context;
            a(context, "com.vivo.push_preferences");
        }
    }
}
