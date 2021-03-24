package com.vivo.push.util;

import android.content.Context;
/* loaded from: classes7.dex */
public final class w extends a {

    /* renamed from: b  reason: collision with root package name */
    public static w f39571b;

    public static synchronized w b() {
        w wVar;
        synchronized (w.class) {
            if (f39571b == null) {
                f39571b = new w();
            }
            wVar = f39571b;
        }
        return wVar;
    }

    public final void a(Context context) {
        if (this.f39529a == null) {
            this.f39529a = context;
            a(context, "com.vivo.push_preferences");
        }
    }
}
