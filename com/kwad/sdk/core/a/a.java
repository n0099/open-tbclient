package com.kwad.sdk.core.a;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bc;
import com.kwad.sdk.utils.p;
import java.util.Map;
/* loaded from: classes10.dex */
public final class a implements g {
    public static String asG;

    public static String Ch() {
        Context context;
        if (!TextUtils.isEmpty(asG)) {
            return asG;
        }
        if (((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext() == null) {
            return "";
        }
        String str = context.getPackageName() + bc.cT(context);
        asG = str;
        return str;
    }

    @Override // com.kwad.sdk.core.a.g
    public final void a(String str, Map<String, String> map, String str2) {
        f.a(str, map, str2);
    }

    @Override // com.kwad.sdk.core.a.g
    public final String ak(String str) {
        try {
            String dA = p.dA(0);
            return new String(c.Ci().encode(b.d(dA.getBytes("UTF-8"), b.f(str.getBytes()))), "UTF-8");
        } catch (Exception e) {
            com.kwad.sdk.core.e.c.printStackTrace(e);
            return str;
        }
    }

    @Override // com.kwad.sdk.core.a.g
    public final void e(@NonNull Map<String, String> map) {
        map.put("Ks-PkgId", Ch());
        map.put("Ks-Encoding", "2");
    }

    @Override // com.kwad.sdk.core.a.g
    public final String getResponseData(String str) {
        try {
            return new String(b.g(b.a(p.dA(0), c.Ck().decode(str.getBytes()))), "UTF-8");
        } catch (Exception unused) {
            return str;
        }
    }
}
