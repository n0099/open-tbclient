package com.kwad.sdk.core.b;

import androidx.annotation.NonNull;
import com.kwad.sdk.utils.j;
import java.util.Map;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class g implements i {
    @Override // com.kwad.sdk.core.b.i
    public String a(String str) {
        try {
            return new String(c.a().a(h.a(str.getBytes(), j.a(1))), "UTF-8");
        } catch (Exception e) {
            com.kwad.sdk.core.d.a.a(e);
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
            return h.b(c.b().a(str.getBytes()), j.a(2));
        } catch (Exception e) {
            return str;
        }
    }
}
