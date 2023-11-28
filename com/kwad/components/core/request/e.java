package com.kwad.components.core.request;

import android.text.TextUtils;
import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.t;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class e extends com.kwad.sdk.core.network.d {
    public long Rh;

    public e(int i, AdTemplate adTemplate) {
        String bP = com.kwad.sdk.core.response.b.a.bP(com.kwad.sdk.core.response.b.e.dP(adTemplate));
        try {
            String bQ = com.kwad.sdk.core.response.b.a.bQ(com.kwad.sdk.core.response.b.e.dP(adTemplate));
            try {
                if (!TextUtils.isEmpty(bQ)) {
                    putBody("serverExt", new JSONObject(bQ));
                }
            } catch (JSONException e) {
                com.kwad.sdk.core.e.c.printStackTrace(e);
            }
            if (!TextUtils.isEmpty(bP) && bP != null) {
                JSONObject jSONObject = new JSONObject(bP);
                t.putValue(jSONObject, "checkType", i);
                putBody("callbackUrlInfo", jSONObject.toString());
            }
        } catch (Exception e2) {
            com.kwad.sdk.core.e.c.printStackTrace(e2);
        }
        ImpInfo impInfo = new ImpInfo(adTemplate.mAdScene);
        JSONArray jSONArray = new JSONArray();
        t.a(jSONArray, impInfo.toJson());
        putBody("impInfo", jSONArray);
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public final String getUrl() {
        return com.kwad.sdk.g.xV();
    }
}
