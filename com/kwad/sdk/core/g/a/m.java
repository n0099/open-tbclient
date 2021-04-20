package com.kwad.sdk.core.g.a;

import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.export.proxy.AdRequestExtentParamsProxy;
import com.kwad.sdk.utils.o;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class m implements com.kwad.sdk.core.b {

    /* renamed from: a  reason: collision with root package name */
    public String f33964a;

    public static m a() {
        Map<String, String> extentParams;
        m mVar = new m();
        AdRequestExtentParamsProxy requestExtentParamsProxy = KsAdSDKImpl.get().getRequestExtentParamsProxy();
        if (requestExtentParamsProxy != null && (extentParams = requestExtentParamsProxy.getExtentParams()) != null) {
            mVar.f33964a = extentParams.get("user_id");
        }
        return mVar;
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        o.a(jSONObject, "user_id", this.f33964a);
        return jSONObject;
    }
}
