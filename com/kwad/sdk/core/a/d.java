package com.kwad.sdk.core.a;

import androidx.annotation.NonNull;
import com.kwad.sdk.components.DevelopMangerComponents;
import java.util.Map;
/* loaded from: classes5.dex */
public final class d {
    public static h a;

    public static h a() {
        h fVar;
        h hVar = a;
        if (hVar != null) {
            return hVar;
        }
        com.kwad.sdk.components.c.a(DevelopMangerComponents.class);
        com.kwad.sdk.components.f fVar2 = (com.kwad.sdk.components.f) com.kwad.sdk.components.c.a(com.kwad.sdk.components.f.class);
        if (fVar2 != null) {
            fVar2.b();
            fVar = fVar2.b();
        } else {
            fVar = new f();
        }
        a = fVar;
        return a;
    }

    public static String a(String str) {
        return a().a(str);
    }

    public static void a(String str, Map<String, String> map, String str2) {
        a().a(str, map, str2);
    }

    public static void a(@NonNull Map<String, String> map) {
        a().a(map);
    }

    public static String b(String str) {
        com.kwad.sdk.components.c.a(DevelopMangerComponents.class);
        return a().b(str);
    }
}
