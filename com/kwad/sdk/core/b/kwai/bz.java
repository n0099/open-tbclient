package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.response.model.AdStyleInfo;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class bz implements com.kwad.sdk.core.d<AdStyleInfo.ExtraDisplayInfo> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(AdStyleInfo.ExtraDisplayInfo extraDisplayInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        extraDisplayInfo.exposeTagInfoList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("exposeTagInfoList");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                AdStyleInfo.ExposeTagInfo exposeTagInfo = new AdStyleInfo.ExposeTagInfo();
                exposeTagInfo.parseJson(optJSONArray.optJSONObject(i));
                extraDisplayInfo.exposeTagInfoList.add(exposeTagInfo);
            }
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(AdStyleInfo.ExtraDisplayInfo extraDisplayInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.r.putValue(jSONObject, "exposeTagInfoList", extraDisplayInfo.exposeTagInfoList);
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdStyleInfo.ExtraDisplayInfo extraDisplayInfo, JSONObject jSONObject) {
        a2(extraDisplayInfo, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdStyleInfo.ExtraDisplayInfo extraDisplayInfo, JSONObject jSONObject) {
        return b2(extraDisplayInfo, jSONObject);
    }
}
