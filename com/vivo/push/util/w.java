package com.vivo.push.util;

import android.content.Context;
/* loaded from: classes3.dex */
public final class w extends a {

    /* renamed from: b  reason: collision with root package name */
    private static w f13702b;

    public static synchronized w b() {
        w wVar;
        synchronized (w.class) {
            if (f13702b == null) {
                f13702b = new w();
            }
            wVar = f13702b;
        }
        return wVar;
    }

    public final void a(Context context) {
        if (this.f13681a == null) {
            this.f13681a = context;
            a(context, "com.vivo.push_preferences");
        }
    }
}
