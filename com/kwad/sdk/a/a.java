package com.kwad.sdk.a;

import android.content.Context;
import com.kuaishou.weapon.p0.WeaponHI;
import com.kwad.sdk.utils.bj;
/* loaded from: classes10.dex */
public final class a {
    public static void init(Context context) {
        if (com.kwad.b.kwai.a.CK.booleanValue()) {
            try {
                WeaponHI.init(bj.getApplicationContext(context), new b());
            } catch (Throwable th) {
                com.kwad.sdk.core.e.b.printStackTraceOnly(th);
            }
        }
    }
}
