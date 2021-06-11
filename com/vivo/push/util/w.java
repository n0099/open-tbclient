package com.vivo.push.util;

import android.content.Context;
/* loaded from: classes7.dex */
public final class w extends a {

    /* renamed from: b  reason: collision with root package name */
    public static w f40414b;

    public static synchronized w b() {
        w wVar;
        synchronized (w.class) {
            if (f40414b == null) {
                f40414b = new w();
            }
            wVar = f40414b;
        }
        return wVar;
    }

    public final void a(Context context) {
        if (this.f40371a == null) {
            this.f40371a = context;
            a(context, "com.vivo.push_preferences");
        }
    }
}
