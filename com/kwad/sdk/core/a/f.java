package com.kwad.sdk.core.a;

import androidx.annotation.NonNull;
import com.kwad.sdk.utils.n;
import java.util.Base64;
import java.util.Map;
/* loaded from: classes7.dex */
public final class f implements h {
    @Override // com.kwad.sdk.core.a.h
    public final void a(String str, Map<String, String> map, String str2) {
    }

    @Override // com.kwad.sdk.core.a.h
    public final String bM(String str) {
        try {
            return new String(Base64.getEncoder().encode(g.d(str.getBytes(), n.bA(1))), "UTF-8");
        } catch (Exception e) {
            com.kwad.sdk.core.e.b.printStackTrace(e);
            return str;
        }
    }

    @Override // com.kwad.sdk.core.a.h
    public final void c(@NonNull Map<String, String> map) {
    }

    @Override // com.kwad.sdk.core.a.h
    public final String getResponseData(String str) {
        try {
            return g.e(Base64.getDecoder().decode(str.getBytes()), n.bA(2));
        } catch (Exception unused) {
            return str;
        }
    }
}
