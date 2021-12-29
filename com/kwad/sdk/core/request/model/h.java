package com.kwad.sdk.core.request.model;

import androidx.annotation.Nullable;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.utils.ad;
import com.kwad.sdk.utils.av;
import com.kwad.sdk.utils.t;
import com.yy.hiidostatis.inner.BaseStatisContent;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class h implements com.kwad.sdk.core.b {
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f58380b;

    /* renamed from: c  reason: collision with root package name */
    public int f58381c;

    /* renamed from: d  reason: collision with root package name */
    public int f58382d;

    public static h a() {
        h hVar = new h();
        hVar.a = av.t();
        hVar.f58380b = av.v(KsAdSDKImpl.get().getContext());
        hVar.f58381c = ad.c(KsAdSDKImpl.get().getContext());
        hVar.f58382d = ad.d(KsAdSDKImpl.get().getContext());
        return hVar;
    }

    public static h b() {
        h hVar = new h();
        hVar.f58381c = ad.c(KsAdSDKImpl.get().getContext());
        return hVar;
    }

    @Override // com.kwad.sdk.core.b
    public void parseJson(@Nullable JSONObject jSONObject) {
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        t.a(jSONObject, "ip", this.a);
        t.a(jSONObject, BaseStatisContent.MAC, this.f58380b);
        t.a(jSONObject, "connectionType", this.f58381c);
        t.a(jSONObject, "operatorType", this.f58382d);
        return jSONObject;
    }
}
