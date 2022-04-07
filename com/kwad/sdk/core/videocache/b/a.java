package com.kwad.sdk.core.videocache.b;

import android.content.Context;
import com.kwad.sdk.core.videocache.f;
/* loaded from: classes5.dex */
public class a {
    public static f a;

    public static f a(Context context) {
        f fVar = a;
        if (fVar == null) {
            f b = b(context);
            a = b;
            return b;
        }
        return fVar;
    }

    public static f b(Context context) {
        return new f.a(context).a(104857600L).a();
    }
}
