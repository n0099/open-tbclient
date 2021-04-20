package com.kwad.sdk.core.b;

import androidx.annotation.NonNull;
import com.kwad.sdk.plugin.DevelopMangerPlugin;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static i f33722a;

    public static i a() {
        i gVar;
        i iVar = f33722a;
        if (iVar != null) {
            return iVar;
        }
        DevelopMangerPlugin.DevelopValue a2 = ((DevelopMangerPlugin) com.kwad.sdk.plugin.g.a(DevelopMangerPlugin.class)).a("KEY_CLOSE_AES");
        if (a2 != null && ((Boolean) a2.getValue()).booleanValue()) {
            g gVar2 = new g();
            f33722a = gVar2;
            return gVar2;
        }
        if (com.kwad.sdk.d.f34801a == 1) {
            com.kwad.sdk.plugin.a aVar = (com.kwad.sdk.plugin.a) com.kwad.sdk.plugin.g.a(com.kwad.sdk.plugin.a.class);
            gVar = (aVar == null || aVar.a() == null) ? new g() : aVar.a();
        } else {
            com.kwad.sdk.plugin.b bVar = (com.kwad.sdk.plugin.b) com.kwad.sdk.plugin.g.a(com.kwad.sdk.plugin.b.class);
            gVar = (bVar == null || bVar.a() == null) ? new g() : bVar.a();
        }
        f33722a = gVar;
        return f33722a;
    }

    public static String a(String str) {
        return a().a(str);
    }

    public static void a(String str, Map<String, String> map, JSONObject jSONObject) {
        a().a(str, map, jSONObject);
    }

    public static void a(@NonNull Map<String, String> map) {
        a().a(map);
    }

    public static String b(String str) {
        DevelopMangerPlugin.DevelopValue a2 = ((DevelopMangerPlugin) com.kwad.sdk.plugin.g.a(DevelopMangerPlugin.class)).a("KEY_HOST_ENCRYPT_DISABLE");
        return (a2 == null || !((Boolean) a2.getValue()).booleanValue()) ? a().b(str) : str;
    }
}
