package com.kwad.sdk.core.a;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.au;
import com.kwad.sdk.utils.n;
import java.util.Map;
/* loaded from: classes5.dex */
public final class a implements h {
    public static String tf() {
        Context context = ((com.kwad.sdk.service.kwai.d) ServiceProvider.get(com.kwad.sdk.service.kwai.d.class)).getContext();
        if (context == null) {
            return "";
        }
        return context.getPackageName() + au.dj(context);
    }

    @Override // com.kwad.sdk.core.a.h
    public final void a(String str, Map<String, String> map, String str2) {
        e.a(str, map, str2);
    }

    @Override // com.kwad.sdk.core.a.h
    public final String bM(String str) {
        try {
            String bA = n.bA(0);
            return new String(c.tg().encode(b.d(bA.getBytes("UTF-8"), b.f(str.getBytes()))), "UTF-8");
        } catch (Exception e) {
            com.kwad.sdk.core.e.b.printStackTrace(e);
            return str;
        }
    }

    @Override // com.kwad.sdk.core.a.h
    public final void c(@NonNull Map<String, String> map) {
        map.put("Ks-PkgId", tf());
        map.put("Ks-Encoding", "2");
    }

    @Override // com.kwad.sdk.core.a.h
    public final String getResponseData(String str) {
        try {
            return new String(b.g(b.a(n.bA(0), c.th().decode(str.getBytes()))), "UTF-8");
        } catch (Exception e) {
            com.kwad.sdk.core.e.b.printStackTraceOnly(e);
            return str;
        }
    }
}
