package com.vivo.push.util;

import android.content.Context;
/* loaded from: classes7.dex */
public final class w extends a {

    /* renamed from: b  reason: collision with root package name */
    public static w f39956b;

    public static synchronized w b() {
        w wVar;
        synchronized (w.class) {
            if (f39956b == null) {
                f39956b = new w();
            }
            wVar = f39956b;
        }
        return wVar;
    }

    public final void a(Context context) {
        if (this.f39914a == null) {
            this.f39914a = context;
            a(context, "com.vivo.push_preferences");
        }
    }
}
