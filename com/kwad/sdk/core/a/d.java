package com.kwad.sdk.core.a;

import androidx.annotation.NonNull;
import com.kwad.sdk.components.DevelopMangerComponents;
import java.util.Map;
/* loaded from: classes10.dex */
public final class d {
    public static g asU;

    public static void a(String str, Map<String, String> map, String str2) {
        on().a(str, map, str2);
    }

    public static String ak(String str) {
        return on().ak(str);
    }

    public static void e(@NonNull Map<String, String> map) {
        on().e(map);
    }

    public static String getResponseData(String str) {
        com.kwad.sdk.components.c.f(DevelopMangerComponents.class);
        return on().getResponseData(str);
    }

    public static g on() {
        g gVar = asU;
        if (gVar != null) {
            return gVar;
        }
        com.kwad.sdk.components.f fVar = (com.kwad.sdk.components.f) com.kwad.sdk.components.c.f(com.kwad.sdk.components.f.class);
        if (fVar != null) {
            fVar.on();
            asU = fVar.on();
        } else {
            asU = new a();
        }
        return asU;
    }
}
