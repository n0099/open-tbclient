package com.kwad.sdk.core.videocache.c;

import android.content.Context;
import com.kwad.sdk.core.videocache.f;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static f f6288a;

    public static f a(Context context) {
        if (f6288a == null) {
            f b = b(context);
            f6288a = b;
            return b;
        }
        return f6288a;
    }

    private static f b(Context context) {
        return new f.a(context).a(104857600L).a();
    }
}
