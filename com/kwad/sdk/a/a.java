package com.kwad.sdk.a;

import android.content.Context;
import com.kuaishou.weapon.p0.WeaponHI;
import com.kwad.sdk.utils.bf;
/* loaded from: classes5.dex */
public final class a {
    public static void a(Context context) {
        if (com.kwad.b.kwai.a.a.booleanValue()) {
            try {
                WeaponHI.init(bf.a(context), new b());
            } catch (Throwable th) {
                com.kwad.sdk.core.d.b.b(th);
            }
        }
    }
}
