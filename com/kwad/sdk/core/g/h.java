package com.kwad.sdk.core.g;

import android.text.TextUtils;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.utils.ae;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes6.dex */
public class h extends com.kwad.sdk.core.network.d {

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public List<com.kwad.sdk.core.g.a.f> f34074a = new ArrayList(1);

        /* renamed from: b  reason: collision with root package name */
        public com.kwad.sdk.core.g.a.c f34075b;

        /* renamed from: c  reason: collision with root package name */
        public String f34076c;

        /* renamed from: d  reason: collision with root package name */
        public com.kwad.sdk.core.g.a.j f34077d;
    }

    public h(a aVar) {
        JSONArray jSONArray = new JSONArray();
        for (com.kwad.sdk.core.g.a.f fVar : aVar.f34074a) {
            com.kwad.sdk.utils.o.a(jSONArray, fVar.toJson());
        }
        a("impInfo", jSONArray);
        a("contentInfo", aVar.f34075b);
        com.kwad.sdk.core.g.a.j jVar = aVar.f34077d;
        if (jVar != null) {
            a("preloadInfo", jVar);
        }
        if (!TextUtils.isEmpty(aVar.f34076c)) {
            b("pushStr", aVar.f34076c);
        }
        b("appTag", ae.g(KsAdSDKImpl.get().getContext()));
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public String a() {
        return com.kwad.sdk.d.c();
    }
}
