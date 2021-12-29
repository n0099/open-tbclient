package com.kwad.sdk.e.kwai;

import com.dxmpay.wallet.paysdk.entrance.EnterDxmPayServiceAction;
import com.tachikoma.core.component.network.delegate.TKBaseResponseInner;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b implements com.kwad.sdk.e.e<TKBaseResponseInner> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.e.e
    public void a(TKBaseResponseInner tKBaseResponseInner, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        tKBaseResponseInner.body = jSONObject.optString("body");
        tKBaseResponseInner.statusCode = jSONObject.optInt(EnterDxmPayServiceAction.SERVICE_STATUS_CODE);
        tKBaseResponseInner.allHeaderFields = jSONObject.optString("allHeaderFields");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.e.e
    public JSONObject b(TKBaseResponseInner tKBaseResponseInner, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.e.f.a(jSONObject, "body", tKBaseResponseInner.body);
        com.kwad.sdk.e.f.a(jSONObject, EnterDxmPayServiceAction.SERVICE_STATUS_CODE, tKBaseResponseInner.statusCode);
        com.kwad.sdk.e.f.a(jSONObject, "allHeaderFields", tKBaseResponseInner.allHeaderFields);
        return jSONObject;
    }
}
