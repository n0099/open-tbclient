package com.vivo.push.util;

import android.content.Context;
/* loaded from: classes4.dex */
public final class w extends a {

    /* renamed from: b  reason: collision with root package name */
    private static w f14002b;

    public static synchronized w b() {
        w wVar;
        synchronized (w.class) {
            if (f14002b == null) {
                f14002b = new w();
            }
            wVar = f14002b;
        }
        return wVar;
    }

    public final void a(Context context) {
        if (this.f13981a == null) {
            this.f13981a = context;
            a(context, "com.vivo.push_preferences");
        }
    }
}
