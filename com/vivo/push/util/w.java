package com.vivo.push.util;

import android.content.Context;
/* loaded from: classes7.dex */
public final class w extends a {

    /* renamed from: b  reason: collision with root package name */
    public static w f36735b;

    public static synchronized w b() {
        w wVar;
        synchronized (w.class) {
            if (f36735b == null) {
                f36735b = new w();
            }
            wVar = f36735b;
        }
        return wVar;
    }

    public final void a(Context context) {
        if (this.f36692a == null) {
            this.f36692a = context;
            a(context, "com.vivo.push_preferences");
        }
    }
}
