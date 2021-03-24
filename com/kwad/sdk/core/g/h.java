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
        public List<com.kwad.sdk.core.g.a.f> f33784a = new ArrayList(1);

        /* renamed from: b  reason: collision with root package name */
        public com.kwad.sdk.core.g.a.c f33785b;

        /* renamed from: c  reason: collision with root package name */
        public String f33786c;

        /* renamed from: d  reason: collision with root package name */
        public com.kwad.sdk.core.g.a.j f33787d;
    }

    public h(a aVar) {
        JSONArray jSONArray = new JSONArray();
        for (com.kwad.sdk.core.g.a.f fVar : aVar.f33784a) {
            com.kwad.sdk.utils.o.a(jSONArray, fVar.toJson());
        }
        a("impInfo", jSONArray);
        a("contentInfo", aVar.f33785b);
        com.kwad.sdk.core.g.a.j jVar = aVar.f33787d;
        if (jVar != null) {
            a("preloadInfo", jVar);
        }
        if (!TextUtils.isEmpty(aVar.f33786c)) {
            b("pushStr", aVar.f33786c);
        }
        b("appTag", ae.g(KsAdSDKImpl.get().getContext()));
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public String a() {
        return com.kwad.sdk.d.c();
    }
}
