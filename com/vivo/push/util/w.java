package com.vivo.push.util;

import android.content.Context;
/* loaded from: classes6.dex */
public final class w extends a {

    /* renamed from: b  reason: collision with root package name */
    public static w f37561b;

    public static synchronized w b() {
        w wVar;
        synchronized (w.class) {
            if (f37561b == null) {
                f37561b = new w();
            }
            wVar = f37561b;
        }
        return wVar;
    }

    public final void a(Context context) {
        if (this.f37518a == null) {
            this.f37518a = context;
            a(context, "com.vivo.push_preferences");
        }
    }
}
