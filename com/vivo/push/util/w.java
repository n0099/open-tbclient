package com.vivo.push.util;

import android.content.Context;
/* loaded from: classes7.dex */
public final class w extends a {

    /* renamed from: b  reason: collision with root package name */
    public static w f36806b;

    public static synchronized w b() {
        w wVar;
        synchronized (w.class) {
            if (f36806b == null) {
                f36806b = new w();
            }
            wVar = f36806b;
        }
        return wVar;
    }

    public final void a(Context context) {
        if (this.f36763a == null) {
            this.f36763a = context;
            a(context, "com.vivo.push_preferences");
        }
    }
}
