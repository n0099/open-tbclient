package com.kwad.sdk.core.a;

import androidx.annotation.NonNull;
import com.kwad.sdk.utils.p;
import java.util.Map;
/* loaded from: classes4.dex */
public class g implements i {
    @Override // com.kwad.sdk.core.a.i
    public String a(String str) {
        try {
            return new String(c.a().a(h.a(str.getBytes(), p.a(1))), "UTF-8");
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.a(e2);
            return str;
        }
    }

    @Override // com.kwad.sdk.core.a.i
    public void a(String str, Map<String, String> map, String str2) {
    }

    @Override // com.kwad.sdk.core.a.i
    public void a(@NonNull Map<String, String> map) {
    }

    @Override // com.kwad.sdk.core.a.i
    public String b(String str) {
        try {
            return h.b(c.b().a(str.getBytes()), p.a(2));
        } catch (Exception unused) {
            return str;
        }
    }
}
