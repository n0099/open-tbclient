package com.kwad.sdk.core.videocache.c;

import android.content.Context;
import com.kwad.sdk.core.videocache.f;
/* loaded from: classes7.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static f f34906a;

    public static f a(Context context) {
        f fVar = f34906a;
        if (fVar == null) {
            f b2 = b(context);
            f34906a = b2;
            return b2;
        }
        return fVar;
    }

    public static f b(Context context) {
        return new f.a(context).a(104857600L).a();
    }
}
