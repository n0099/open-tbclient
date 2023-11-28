package com.kwad.sdk.core.b.a;

import com.kwad.sdk.kgeo.KGeoInfo;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class fs implements com.kwad.sdk.core.d<KGeoInfo> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(KGeoInfo kGeoInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        kGeoInfo.latitude = jSONObject.optDouble("latitude");
        kGeoInfo.longitude = jSONObject.optDouble("longitude");
        kGeoInfo.range = jSONObject.optInt("range");
        kGeoInfo.rate = jSONObject.optInt("rate");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(KGeoInfo kGeoInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        double d = kGeoInfo.latitude;
        if (d != 0.0d) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "latitude", d);
        }
        double d2 = kGeoInfo.longitude;
        if (d2 != 0.0d) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "longitude", d2);
        }
        int i = kGeoInfo.range;
        if (i != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "range", i);
        }
        int i2 = kGeoInfo.rate;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "rate", i2);
        }
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(KGeoInfo kGeoInfo, JSONObject jSONObject) {
        a2(kGeoInfo, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(KGeoInfo kGeoInfo, JSONObject jSONObject) {
        return b2(kGeoInfo, jSONObject);
    }
}
