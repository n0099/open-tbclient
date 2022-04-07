package com.kwad.sdk.core.a;

import androidx.annotation.NonNull;
import com.kwad.sdk.plugin.DevelopMangerPlugin;
import java.util.Map;
/* loaded from: classes5.dex */
public class d {
    public static i a;

    public static i a() {
        i iVar = a;
        if (iVar != null) {
            return iVar;
        }
        DevelopMangerPlugin.DevelopValue a2 = ((DevelopMangerPlugin) com.kwad.sdk.plugin.f.a(DevelopMangerPlugin.class)).a("KEY_CLOSE_AES");
        if (a2 == null || !((Boolean) a2.getValue()).booleanValue()) {
            com.kwad.sdk.plugin.a aVar = (com.kwad.sdk.plugin.a) com.kwad.sdk.plugin.f.a(com.kwad.sdk.plugin.a.class);
            a = (aVar == null || aVar.b() == null) ? new g() : aVar.b();
            return a;
        }
        g gVar = new g();
        a = gVar;
        return gVar;
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
        DevelopMangerPlugin.DevelopValue a2 = ((DevelopMangerPlugin) com.kwad.sdk.plugin.f.a(DevelopMangerPlugin.class)).a("KEY_HOST_ENCRYPT_DISABLE");
        return (a2 == null || !((Boolean) a2.getValue()).booleanValue()) ? a().b(str) : str;
    }
}
