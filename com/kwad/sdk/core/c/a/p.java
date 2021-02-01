package com.kwad.sdk.core.c.a;

import com.kwad.sdk.emotion.model.CDNUrl;
import com.kwad.sdk.emotion.model.EmotionCode;
import com.kwad.sdk.emotion.model.EmotionInfo;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class p implements com.kwad.sdk.core.c<EmotionInfo> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public JSONObject a(EmotionInfo emotionInfo) {
        JSONObject jSONObject = new JSONObject();
        com.kwad.sdk.utils.o.a(jSONObject, "id", emotionInfo.id);
        com.kwad.sdk.utils.o.a(jSONObject, "name", emotionInfo.name);
        com.kwad.sdk.utils.o.a(jSONObject, "type", emotionInfo.type);
        com.kwad.sdk.utils.o.a(jSONObject, "packageId", emotionInfo.packageId);
        com.kwad.sdk.utils.o.a(jSONObject, "emotionImageSmallUrl", emotionInfo.emotionImageSmallUrl);
        com.kwad.sdk.utils.o.a(jSONObject, "emotionImageBigUrl", emotionInfo.emotionImageBigUrl);
        com.kwad.sdk.utils.o.a(jSONObject, "emotionCodes", emotionInfo.emotionCodes);
        com.kwad.sdk.utils.o.a(jSONObject, "width", emotionInfo.width);
        com.kwad.sdk.utils.o.a(jSONObject, "height", emotionInfo.height);
        com.kwad.sdk.utils.o.a(jSONObject, "mPageIndex", emotionInfo.mPageIndex);
        com.kwad.sdk.utils.o.a(jSONObject, "mIndex", emotionInfo.mIndex);
        return jSONObject;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public void a(EmotionInfo emotionInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        emotionInfo.id = jSONObject.optString("id");
        emotionInfo.name = jSONObject.optString("name");
        emotionInfo.type = jSONObject.optInt("type");
        emotionInfo.packageId = jSONObject.optString("packageId");
        emotionInfo.emotionImageSmallUrl = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("emotionImageSmallUrl");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                CDNUrl cDNUrl = new CDNUrl();
                cDNUrl.parseJson(optJSONArray.optJSONObject(i));
                emotionInfo.emotionImageSmallUrl.add(cDNUrl);
            }
        }
        emotionInfo.emotionImageBigUrl = new ArrayList();
        JSONArray optJSONArray2 = jSONObject.optJSONArray("emotionImageBigUrl");
        if (optJSONArray2 != null) {
            for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                CDNUrl cDNUrl2 = new CDNUrl();
                cDNUrl2.parseJson(optJSONArray2.optJSONObject(i2));
                emotionInfo.emotionImageBigUrl.add(cDNUrl2);
            }
        }
        emotionInfo.emotionCodes = new ArrayList();
        JSONArray optJSONArray3 = jSONObject.optJSONArray("emotionCodes");
        if (optJSONArray3 != null) {
            for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                EmotionCode emotionCode = new EmotionCode();
                emotionCode.parseJson(optJSONArray3.optJSONObject(i3));
                emotionInfo.emotionCodes.add(emotionCode);
            }
        }
        emotionInfo.width = jSONObject.optInt("width");
        emotionInfo.height = jSONObject.optInt("height");
        emotionInfo.mPageIndex = jSONObject.optInt("mPageIndex");
        emotionInfo.mIndex = jSONObject.optInt("mIndex");
    }
}
