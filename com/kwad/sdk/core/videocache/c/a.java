package com.kwad.sdk.core.videocache.c;

import android.content.Context;
import com.kwad.sdk.core.videocache.f;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static f f9483a;

    public static f a(Context context) {
        if (f9483a == null) {
            f b2 = b(context);
            f9483a = b2;
            return b2;
        }
        return f9483a;
    }

    private static f b(Context context) {
        return new f.a(context).a(104857600L).a();
    }
}
