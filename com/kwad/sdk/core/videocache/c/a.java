package com.kwad.sdk.core.videocache.c;

import android.content.Context;
import com.kwad.sdk.core.videocache.f;
/* loaded from: classes10.dex */
public final class a {
    public static f aBz;

    public static f b(Context context, int i, int i2) {
        f fVar = aBz;
        if (fVar == null) {
            f c = c(context, i, i2);
            aBz = c;
            return c;
        }
        return fVar;
    }

    public static f c(Context context, int i, int i2) {
        return new f.a(context).ak(536870912L).cV(i).cW(i2).Fi();
    }

    public static f bl(Context context) {
        return b(context, 0, 0);
    }
}
