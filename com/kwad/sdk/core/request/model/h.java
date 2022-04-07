package com.kwad.sdk.core.request.model;

import androidx.annotation.Nullable;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.utils.ad;
import com.kwad.sdk.utils.av;
import com.kwad.sdk.utils.t;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class h implements com.kwad.sdk.core.b {
    public String a;
    public String b;
    public int c;
    public int d;

    public static h a() {
        h hVar = new h();
        hVar.a = av.t();
        hVar.b = av.v(KsAdSDKImpl.get().getContext());
        hVar.c = ad.c(KsAdSDKImpl.get().getContext());
        hVar.d = ad.d(KsAdSDKImpl.get().getContext());
        return hVar;
    }

    public static h b() {
        h hVar = new h();
        hVar.c = ad.c(KsAdSDKImpl.get().getContext());
        return hVar;
    }

    @Override // com.kwad.sdk.core.b
    public void parseJson(@Nullable JSONObject jSONObject) {
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        t.a(jSONObject, "ip", this.a);
        t.a(jSONObject, "mac", this.b);
        t.a(jSONObject, "connectionType", this.c);
        t.a(jSONObject, "operatorType", this.d);
        return jSONObject;
    }
}
