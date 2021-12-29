package com.kwad.sdk.core.b.kwai;

import com.baidu.ugc.editvideo.filter.FilterValue;
import com.kwad.sdk.core.response.model.NewsInfo;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class by implements com.kwad.sdk.core.d<NewsInfo.ImageInfo> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public void a(NewsInfo.ImageInfo imageInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        imageInfo.width = jSONObject.optInt("width");
        imageInfo.height = jSONObject.optInt("height");
        imageInfo.url = jSONObject.optString("url");
        if (jSONObject.opt("url") == JSONObject.NULL) {
            imageInfo.url = "";
        }
        imageInfo.origin = jSONObject.optString(FilterValue.DEFAULT_FILTER_VALUE);
        if (jSONObject.opt(FilterValue.DEFAULT_FILTER_VALUE) == JSONObject.NULL) {
            imageInfo.origin = "";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(NewsInfo.ImageInfo imageInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "width", imageInfo.width);
        com.kwad.sdk.utils.t.a(jSONObject, "height", imageInfo.height);
        com.kwad.sdk.utils.t.a(jSONObject, "url", imageInfo.url);
        com.kwad.sdk.utils.t.a(jSONObject, FilterValue.DEFAULT_FILTER_VALUE, imageInfo.origin);
        return jSONObject;
    }
}
