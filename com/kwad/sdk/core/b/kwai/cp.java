package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.response.model.NewsInfo;
import com.kwad.sdk.core.response.model.PhotoInfo;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class cp implements com.kwad.sdk.core.d<NewsInfo> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public void a(NewsInfo newsInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        PhotoInfo.AuthorInfo authorInfo = new PhotoInfo.AuthorInfo();
        newsInfo.authorInfo = authorInfo;
        authorInfo.parseJson(jSONObject.optJSONObject("authorInfo"));
        newsInfo.photoId = jSONObject.optLong("photoId");
        newsInfo.title = jSONObject.optString("title");
        if (jSONObject.opt("title") == JSONObject.NULL) {
            newsInfo.title = "";
        }
        newsInfo.content = jSONObject.optString("content");
        if (jSONObject.opt("content") == JSONObject.NULL) {
            newsInfo.content = "";
        }
        newsInfo.imageInfo = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("imageInfo");
        if (optJSONArray != null) {
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                NewsInfo.ImageInfo imageInfo = new NewsInfo.ImageInfo();
                imageInfo.parseJson(optJSONArray.optJSONObject(i2));
                newsInfo.imageInfo.add(imageInfo);
            }
        }
        newsInfo.thumbnailInfo = new ArrayList();
        JSONArray optJSONArray2 = jSONObject.optJSONArray("thumbnailInfo");
        if (optJSONArray2 != null) {
            for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                NewsInfo.ImageInfo imageInfo2 = new NewsInfo.ImageInfo();
                imageInfo2.parseJson(optJSONArray2.optJSONObject(i3));
                newsInfo.thumbnailInfo.add(imageInfo2);
            }
        }
        newsInfo.templateUrl = jSONObject.optString("templateUrl");
        if (jSONObject.opt("templateUrl") == JSONObject.NULL) {
            newsInfo.templateUrl = "";
        }
        newsInfo.publishTimestamp = jSONObject.optLong("publishTimestamp");
        newsInfo.contentSourceType = jSONObject.optInt("contentSourceType");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(NewsInfo newsInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "authorInfo", newsInfo.authorInfo);
        com.kwad.sdk.utils.t.a(jSONObject, "photoId", newsInfo.photoId);
        com.kwad.sdk.utils.t.a(jSONObject, "title", newsInfo.title);
        com.kwad.sdk.utils.t.a(jSONObject, "content", newsInfo.content);
        com.kwad.sdk.utils.t.a(jSONObject, "imageInfo", newsInfo.imageInfo);
        com.kwad.sdk.utils.t.a(jSONObject, "thumbnailInfo", newsInfo.thumbnailInfo);
        com.kwad.sdk.utils.t.a(jSONObject, "templateUrl", newsInfo.templateUrl);
        com.kwad.sdk.utils.t.a(jSONObject, "publishTimestamp", newsInfo.publishTimestamp);
        com.kwad.sdk.utils.t.a(jSONObject, "contentSourceType", newsInfo.contentSourceType);
        return jSONObject;
    }
}
