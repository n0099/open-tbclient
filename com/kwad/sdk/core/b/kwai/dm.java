package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class dm implements com.kwad.sdk.core.d<AdInfo.MaterialSize> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(AdInfo.MaterialSize materialSize, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        materialSize.width = jSONObject.optInt("width");
        materialSize.height = jSONObject.optInt("height");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(AdInfo.MaterialSize materialSize, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = materialSize.width;
        if (i != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "width", i);
        }
        int i2 = materialSize.height;
        if (i2 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "height", i2);
        }
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdInfo.MaterialSize materialSize, JSONObject jSONObject) {
        a2(materialSize, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdInfo.MaterialSize materialSize, JSONObject jSONObject) {
        return b2(materialSize, jSONObject);
    }
}
