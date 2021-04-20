package com.vivo.push.util;

import android.content.Context;
/* loaded from: classes7.dex */
public final class w extends a {

    /* renamed from: b  reason: collision with root package name */
    public static w f39861b;

    public static synchronized w b() {
        w wVar;
        synchronized (w.class) {
            if (f39861b == null) {
                f39861b = new w();
            }
            wVar = f39861b;
        }
        return wVar;
    }

    public final void a(Context context) {
        if (this.f39819a == null) {
            this.f39819a = context;
            a(context, "com.vivo.push_preferences");
        }
    }
}
