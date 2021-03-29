package com.vivo.push.util;

import android.content.Context;
/* loaded from: classes7.dex */
public final class w extends a {

    /* renamed from: b  reason: collision with root package name */
    public static w f39572b;

    public static synchronized w b() {
        w wVar;
        synchronized (w.class) {
            if (f39572b == null) {
                f39572b = new w();
            }
            wVar = f39572b;
        }
        return wVar;
    }

    public final void a(Context context) {
        if (this.f39530a == null) {
            this.f39530a = context;
            a(context, "com.vivo.push_preferences");
        }
    }
}
