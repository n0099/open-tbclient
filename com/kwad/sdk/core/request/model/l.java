package com.kwad.sdk.core.request.model;

import androidx.annotation.Nullable;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.export.proxy.AdRequestExtentParamsProxy;
import com.kwad.sdk.utils.t;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class l implements com.kwad.sdk.core.b {
    public int a;
    public int b;
    public String c;
    public String d;
    public String e;

    public static l a() {
        Map<String, String> extentParams;
        l lVar = new l();
        AdRequestExtentParamsProxy requestExtentParamsProxy = KsAdSDKImpl.get().getRequestExtentParamsProxy();
        if (requestExtentParamsProxy != null && (extentParams = requestExtentParamsProxy.getExtentParams()) != null) {
            lVar.d = extentParams.get("user_id");
        }
        return lVar;
    }

    public void a(String str) {
        this.e = str;
    }

    @Override // com.kwad.sdk.core.b
    public void parseJson(@Nullable JSONObject jSONObject) {
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        t.a(jSONObject, "user_id", this.d);
        t.a(jSONObject, "thirdUserId", this.e);
        int i = this.a;
        if (i != 0) {
            t.a(jSONObject, "thirdAge", i);
        }
        int i2 = this.b;
        if (i2 != 0) {
            t.a(jSONObject, "thirdGender", i2);
        }
        t.a(jSONObject, "thirdInterest", this.c);
        return jSONObject;
    }
}
