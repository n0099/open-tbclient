package com.kwad.sdk.core.g.a;

import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.export.proxy.AdRequestExtentParamsProxy;
import com.kwad.sdk.utils.o;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class l implements com.kwad.sdk.core.b {

    /* renamed from: a  reason: collision with root package name */
    public String f32338a;

    /* renamed from: b  reason: collision with root package name */
    public String f32339b;

    public static l a() {
        Map<String, String> extentParams;
        l lVar = new l();
        AdRequestExtentParamsProxy requestExtentParamsProxy = KsAdSDKImpl.get().getRequestExtentParamsProxy();
        if (requestExtentParamsProxy != null && (extentParams = requestExtentParamsProxy.getExtentParams()) != null) {
            lVar.f32338a = extentParams.get("user_id");
        }
        return lVar;
    }

    public void a(String str) {
        this.f32339b = str;
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        o.a(jSONObject, "user_id", this.f32338a);
        o.a(jSONObject, "thirdUserId", this.f32339b);
        return jSONObject;
    }
}
