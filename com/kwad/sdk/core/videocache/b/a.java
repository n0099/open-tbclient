package com.kwad.sdk.core.videocache.b;

import android.content.Context;
import com.kwad.sdk.core.videocache.f;
/* loaded from: classes9.dex */
public final class a {
    public static f afa;

    /* renamed from: com.kwad.sdk.core.videocache.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C0652a {
        public String Qd;
    }

    public static f bC(Context context) {
        f fVar = afa;
        if (fVar == null) {
            f bD = bD(context);
            afa = bD;
            return bD;
        }
        return fVar;
    }

    public static f bD(Context context) {
        return new f.a(context).H(104857600L).vM();
    }
}
