package com.kwad.sdk.core.g.a;

import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.export.proxy.AdRequestExtentParamsProxy;
import com.kwad.sdk.utils.o;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class l implements com.kwad.sdk.core.b {

    /* renamed from: a  reason: collision with root package name */
    public String f33093a;

    /* renamed from: b  reason: collision with root package name */
    public String f33094b;

    public static l a() {
        Map<String, String> extentParams;
        l lVar = new l();
        AdRequestExtentParamsProxy requestExtentParamsProxy = KsAdSDKImpl.get().getRequestExtentParamsProxy();
        if (requestExtentParamsProxy != null && (extentParams = requestExtentParamsProxy.getExtentParams()) != null) {
            lVar.f33093a = extentParams.get("user_id");
        }
        return lVar;
    }

    public void a(String str) {
        this.f33094b = str;
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        o.a(jSONObject, "user_id", this.f33093a);
        o.a(jSONObject, "thirdUserId", this.f33094b);
        return jSONObject;
    }
}
