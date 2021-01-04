package com.kwad.sdk.core.b;

import androidx.annotation.NonNull;
import com.kwad.sdk.plugin.DevelopMangerPlugin;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private static i f9340a;

    private static i a() {
        if (f9340a != null) {
            return f9340a;
        }
        DevelopMangerPlugin.DevelopValue a2 = ((DevelopMangerPlugin) com.kwad.sdk.plugin.g.a(DevelopMangerPlugin.class)).a("KEY_CLOSE_AES");
        if (a2 != null && ((Boolean) a2.getValue()).booleanValue()) {
            f9340a = new g();
            return f9340a;
        }
        if (com.kwad.sdk.d.f9968a == 1) {
            com.kwad.sdk.plugin.a aVar = (com.kwad.sdk.plugin.a) com.kwad.sdk.plugin.g.a(com.kwad.sdk.plugin.a.class);
            if (aVar == null || aVar.a() == null) {
                f9340a = new g();
            } else {
                f9340a = aVar.a();
            }
        } else {
            com.kwad.sdk.plugin.b bVar = (com.kwad.sdk.plugin.b) com.kwad.sdk.plugin.g.a(com.kwad.sdk.plugin.b.class);
            if (bVar == null || bVar.a() == null) {
                f9340a = new g();
            } else {
                f9340a = bVar.a();
            }
        }
        return f9340a;
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
