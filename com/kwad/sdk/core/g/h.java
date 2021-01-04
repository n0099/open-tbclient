package com.kwad.sdk.core.g;

import android.text.TextUtils;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.utils.ae;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes5.dex */
public class h extends com.kwad.sdk.core.network.d {

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public List<com.kwad.sdk.core.g.a.f> f9560a = new ArrayList(1);

        /* renamed from: b  reason: collision with root package name */
        public com.kwad.sdk.core.g.a.c f9561b;
        public String c;
        public com.kwad.sdk.core.g.a.j d;
    }

    public h(a aVar) {
        JSONArray jSONArray = new JSONArray();
        for (com.kwad.sdk.core.g.a.f fVar : aVar.f9560a) {
            com.kwad.sdk.utils.o.a(jSONArray, fVar.toJson());
        }
        a("impInfo", jSONArray);
        a("contentInfo", aVar.f9561b);
        if (aVar.d != null) {
            a("preloadInfo", aVar.d);
        }
        if (!TextUtils.isEmpty(aVar.c)) {
            b("pushStr", aVar.c);
        }
        b("appTag", ae.g(KsAdSDKImpl.get().getContext()));
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public String a() {
        return com.kwad.sdk.d.c();
    }
}
