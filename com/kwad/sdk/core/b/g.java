package com.kwad.sdk.core.b;

import androidx.annotation.NonNull;
import com.kwad.sdk.utils.k;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class g implements i {
    @Override // com.kwad.sdk.core.b.i
    public String a(String str) {
        try {
            return new String(c.a().a(h.a(str.getBytes(), k.a(1))), "UTF-8");
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.a(e2);
            return str;
        }
    }

    @Override // com.kwad.sdk.core.b.i
    public void a(String str, Map<String, String> map, JSONObject jSONObject) {
    }

    @Override // com.kwad.sdk.core.b.i
    public void a(@NonNull Map<String, String> map) {
    }

    @Override // com.kwad.sdk.core.b.i
    public String b(String str) {
        try {
            return h.b(c.b().a(str.getBytes()), k.a(2));
        } catch (Exception unused) {
            return str;
        }
    }
}
