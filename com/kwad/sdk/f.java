package com.kwad.sdk;

import androidx.annotation.NonNull;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.export.proxy.AdHttpProxy;
import java.util.Random;
/* loaded from: classes10.dex */
public final class f {
    public static AdHttpProxy akl;

    @NonNull
    public static AdHttpProxy xI() {
        AdHttpProxy adHttpProxy = akl;
        if (adHttpProxy != null) {
            return adHttpProxy;
        }
        if (com.kwad.framework.a.a.mc.booleanValue()) {
            return xJ();
        }
        try {
            if (com.kwad.sdk.core.network.a.c.CH() != null) {
                akl = new com.kwad.sdk.core.network.c.b();
            } else {
                akl = new com.kwad.sdk.core.network.c.a();
            }
        } catch (Throwable unused) {
            akl = new com.kwad.sdk.core.network.c.a();
        }
        return akl;
    }

    public static AdHttpProxy xJ() {
        com.kwad.sdk.components.c.f(DevelopMangerComponents.class);
        if (new Random().nextInt(5) != 0) {
            return new com.kwad.sdk.core.network.c.b();
        }
        return new com.kwad.sdk.core.network.c.a();
    }
}
