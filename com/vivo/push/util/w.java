package com.vivo.push.util;

import android.content.Context;
/* loaded from: classes7.dex */
public final class w extends a {

    /* renamed from: b  reason: collision with root package name */
    public static w f40517b;

    public static synchronized w b() {
        w wVar;
        synchronized (w.class) {
            if (f40517b == null) {
                f40517b = new w();
            }
            wVar = f40517b;
        }
        return wVar;
    }

    public final void a(Context context) {
        if (this.f40474a == null) {
            this.f40474a = context;
            a(context, "com.vivo.push_preferences");
        }
    }
}
