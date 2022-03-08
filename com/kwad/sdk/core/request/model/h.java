package com.kwad.sdk.core.request.model;

import androidx.annotation.Nullable;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.utils.ad;
import com.kwad.sdk.utils.av;
import com.kwad.sdk.utils.t;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class h implements com.kwad.sdk.core.b {
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f54738b;

    /* renamed from: c  reason: collision with root package name */
    public int f54739c;

    /* renamed from: d  reason: collision with root package name */
    public int f54740d;

    public static h a() {
        h hVar = new h();
        hVar.a = av.t();
        hVar.f54738b = av.v(KsAdSDKImpl.get().getContext());
        hVar.f54739c = ad.c(KsAdSDKImpl.get().getContext());
        hVar.f54740d = ad.d(KsAdSDKImpl.get().getContext());
        return hVar;
    }

    public static h b() {
        h hVar = new h();
        hVar.f54739c = ad.c(KsAdSDKImpl.get().getContext());
        return hVar;
    }

    @Override // com.kwad.sdk.core.b
    public void parseJson(@Nullable JSONObject jSONObject) {
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        t.a(jSONObject, "ip", this.a);
        t.a(jSONObject, "mac", this.f54738b);
        t.a(jSONObject, "connectionType", this.f54739c);
        t.a(jSONObject, "operatorType", this.f54740d);
        return jSONObject;
    }
}
