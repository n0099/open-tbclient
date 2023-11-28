package com.kwad.sdk.core.b.a;

import com.baidu.platform.comapi.map.MapBundleKey;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class fw implements com.kwad.sdk.core.d<com.kwad.components.core.page.b.a> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(com.kwad.components.core.page.b.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.adStyle = jSONObject.optInt(MapBundleKey.MapObjKey.OBJ_AD_STYLE);
        aVar.Om = jSONObject.optInt("neo_tk_render_type");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(com.kwad.components.core.page.b.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = aVar.adStyle;
        if (i != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, MapBundleKey.MapObjKey.OBJ_AD_STYLE, i);
        }
        int i2 = aVar.Om;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "neo_tk_render_type", i2);
        }
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.core.page.b.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.core.page.b.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }
}
