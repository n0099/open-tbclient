package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.imageloader.ImageLoaderInfo;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class ey implements com.kwad.sdk.core.d<ImageLoaderInfo> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(ImageLoaderInfo imageLoaderInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        imageLoaderInfo.totalCount = jSONObject.optInt("total_count");
        imageLoaderInfo.failedCount = jSONObject.optInt("failed_count");
        imageLoaderInfo.successCount = jSONObject.optInt("success_count");
        imageLoaderInfo.duration = jSONObject.optDouble("duration");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(ImageLoaderInfo imageLoaderInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = imageLoaderInfo.totalCount;
        if (i != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "total_count", i);
        }
        int i2 = imageLoaderInfo.failedCount;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "failed_count", i2);
        }
        int i3 = imageLoaderInfo.successCount;
        if (i3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "success_count", i3);
        }
        double d = imageLoaderInfo.duration;
        if (d != 0.0d) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "duration", d);
        }
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(ImageLoaderInfo imageLoaderInfo, JSONObject jSONObject) {
        a2(imageLoaderInfo, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(ImageLoaderInfo imageLoaderInfo, JSONObject jSONObject) {
        return b2(imageLoaderInfo, jSONObject);
    }
}
