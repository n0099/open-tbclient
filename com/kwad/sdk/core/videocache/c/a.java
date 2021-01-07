package com.kwad.sdk.core.videocache.c;

import android.content.Context;
import com.kwad.sdk.core.videocache.f;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static f f9781a;

    public static f a(Context context) {
        if (f9781a == null) {
            f b2 = b(context);
            f9781a = b2;
            return b2;
        }
        return f9781a;
    }

    private static f b(Context context) {
        return new f.a(context).a(104857600L).a();
    }
}
