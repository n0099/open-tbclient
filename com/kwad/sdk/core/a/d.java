package com.kwad.sdk.core.a;

import androidx.annotation.NonNull;
import com.kwad.sdk.components.DevelopMangerComponents;
import java.util.Map;
/* loaded from: classes8.dex */
public final class d {
    public static h XC;

    public static void a(String str, Map<String, String> map, String str2) {
        nc().a(str, map, str2);
    }

    public static String bM(String str) {
        return nc().bM(str);
    }

    public static void c(@NonNull Map<String, String> map) {
        nc().c(map);
    }

    public static String getResponseData(String str) {
        com.kwad.sdk.components.c.f(DevelopMangerComponents.class);
        return nc().getResponseData(str);
    }

    public static h nc() {
        h fVar;
        h hVar = XC;
        if (hVar != null) {
            return hVar;
        }
        com.kwad.sdk.components.c.f(DevelopMangerComponents.class);
        com.kwad.sdk.components.f fVar2 = (com.kwad.sdk.components.f) com.kwad.sdk.components.c.f(com.kwad.sdk.components.f.class);
        if (fVar2 != null) {
            fVar2.nc();
            fVar = fVar2.nc();
        } else {
            fVar = new f();
        }
        XC = fVar;
        return XC;
    }
}
