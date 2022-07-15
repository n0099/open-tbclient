package com.kwad.sdk.core.a;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ar;
import com.kwad.sdk.utils.n;
import java.util.Map;
/* loaded from: classes5.dex */
public final class a implements h {
    public static String a() {
        Context a = ((com.kwad.sdk.service.kwai.d) ServiceProvider.a(com.kwad.sdk.service.kwai.d.class)).a();
        if (a == null) {
            return "";
        }
        return a.getPackageName() + ar.a(a);
    }

    @Override // com.kwad.sdk.core.a.h
    public final String a(String str) {
        try {
            String a = n.a(0);
            return new String(c.a().a(b.a(a.getBytes("UTF-8"), b.a(str.getBytes()))), "UTF-8");
        } catch (Exception e) {
            com.kwad.sdk.core.d.b.a(e);
            return str;
        }
    }

    @Override // com.kwad.sdk.core.a.h
    public final void a(String str, Map<String, String> map, String str2) {
        e.a(str, map, str2);
    }

    @Override // com.kwad.sdk.core.a.h
    public final void a(@NonNull Map<String, String> map) {
        map.put("Ks-PkgId", a());
        map.put("Ks-Encoding", "2");
    }

    @Override // com.kwad.sdk.core.a.h
    public final String b(String str) {
        try {
            return new String(b.b(b.a(n.a(0), c.b().a(str.getBytes()))), "UTF-8");
        } catch (Exception e) {
            com.kwad.sdk.core.d.b.b(e);
            return str;
        }
    }
}
