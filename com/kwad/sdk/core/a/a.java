package com.kwad.sdk.core.a;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.utils.ar;
import com.kwad.sdk.utils.p;
import java.util.Map;
/* loaded from: classes3.dex */
public final class a implements i {
    public static String a() {
        Context context = KsAdSDKImpl.get().getContext();
        if (context == null) {
            return "";
        }
        return context.getPackageName() + ar.b(context);
    }

    @Override // com.kwad.sdk.core.a.i
    public String a(String str) {
        try {
            String a = p.a(0);
            return new String(c.a().a(b.a(a.getBytes("UTF-8"), b.a(str.getBytes()))), "UTF-8");
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.a(e2);
            return str;
        }
    }

    @Override // com.kwad.sdk.core.a.i
    public void a(String str, Map<String, String> map, String str2) {
        f.a(str, map, str2);
    }

    @Override // com.kwad.sdk.core.a.i
    public void a(@NonNull Map<String, String> map) {
        map.put("Ks-PkgId", a());
        map.put("Ks-Encoding", "2");
    }

    @Override // com.kwad.sdk.core.a.i
    public String b(String str) {
        try {
            return new String(b.b(b.a(p.a(0), c.b().a(str.getBytes()))), "UTF-8");
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.b(e2);
            return str;
        }
    }
}
