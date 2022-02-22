package com.kwad.sdk.core.request.model;

import androidx.annotation.Nullable;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.utils.ad;
import com.kwad.sdk.utils.av;
import com.kwad.sdk.utils.t;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class h implements com.kwad.sdk.core.b {
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f56388b;

    /* renamed from: c  reason: collision with root package name */
    public int f56389c;

    /* renamed from: d  reason: collision with root package name */
    public int f56390d;

    public static h a() {
        h hVar = new h();
        hVar.a = av.t();
        hVar.f56388b = av.v(KsAdSDKImpl.get().getContext());
        hVar.f56389c = ad.c(KsAdSDKImpl.get().getContext());
        hVar.f56390d = ad.d(KsAdSDKImpl.get().getContext());
        return hVar;
    }

    public static h b() {
        h hVar = new h();
        hVar.f56389c = ad.c(KsAdSDKImpl.get().getContext());
        return hVar;
    }

    @Override // com.kwad.sdk.core.b
    public void parseJson(@Nullable JSONObject jSONObject) {
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        t.a(jSONObject, "ip", this.a);
        t.a(jSONObject, "mac", this.f56388b);
        t.a(jSONObject, "connectionType", this.f56389c);
        t.a(jSONObject, "operatorType", this.f56390d);
        return jSONObject;
    }
}
