package com.kwad.sdk.core.a;

import androidx.annotation.NonNull;
import com.kwad.sdk.utils.n;
import java.util.Base64;
import java.util.Map;
/* loaded from: classes5.dex */
public final class f implements h {
    @Override // com.kwad.sdk.core.a.h
    public final String a(String str) {
        try {
            return new String(Base64.getEncoder().encode(g.a(str.getBytes(), n.a(1))), "UTF-8");
        } catch (Exception e) {
            com.kwad.sdk.core.d.b.a(e);
            return str;
        }
    }

    @Override // com.kwad.sdk.core.a.h
    public final void a(String str, Map<String, String> map, String str2) {
    }

    @Override // com.kwad.sdk.core.a.h
    public final void a(@NonNull Map<String, String> map) {
    }

    @Override // com.kwad.sdk.core.a.h
    public final String b(String str) {
        try {
            return g.b(Base64.getDecoder().decode(str.getBytes()), n.a(2));
        } catch (Exception unused) {
            return str;
        }
    }
}
