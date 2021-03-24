package com.kwad.sdk.core.b;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.utils.j;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public final class a implements i {
    public static String a() {
        Context context = KsAdSDKImpl.get().getContext();
        if (context == null) {
            return "";
        }
        return context.getPackageName() + com.kwai.sodler.lib.c.b.b(context);
    }

    @Override // com.kwad.sdk.core.b.i
    public String a(String str) {
        try {
            String a2 = j.a(0);
            return new String(c.a().a(b.a(a2.getBytes("UTF-8"), b.a(str.getBytes()))), "UTF-8");
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.a(e2);
            return str;
        }
    }

    @Override // com.kwad.sdk.core.b.i
    public void a(String str, Map<String, String> map, JSONObject jSONObject) {
        f.a(str, map, jSONObject);
    }

    @Override // com.kwad.sdk.core.b.i
    public void a(@NonNull Map<String, String> map) {
        map.put("Ks-PkgId", a());
        map.put("Ks-Encoding", "2");
    }

    @Override // com.kwad.sdk.core.b.i
    public String b(String str) {
        try {
            return new String(b.b(b.a(j.a(0), c.b().a(str.getBytes()))), "UTF-8");
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.b(e2);
            return str;
        }
    }
}
