package com.kwad.sdk.emotion.model;

import androidx.annotation.Nullable;
import com.kwad.sdk.core.network.BaseResultData;
import com.kwad.sdk.utils.o;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class EmotionResponse extends BaseResultData implements com.kwad.sdk.core.b, Serializable {
    public static final String KEY_EMOTION_RESPONSE_LIST = "emotionPackageList";
    public static final long serialVersionUID = -5365732599060399342L;
    public List<EmotionPackage> mEmotionPackageList = new ArrayList();

    @Override // com.kwad.sdk.core.network.BaseResultData
    public void parseJson(@Nullable JSONObject jSONObject) {
        super.parseJson(jSONObject);
        if (jSONObject == null) {
            return;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray(KEY_EMOTION_RESPONSE_LIST);
        this.mEmotionPackageList.clear();
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            return;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                EmotionPackage emotionPackage = new EmotionPackage();
                emotionPackage.parseJson(optJSONObject);
                this.mEmotionPackageList.add(emotionPackage);
            }
        }
    }

    @Override // com.kwad.sdk.core.network.BaseResultData, com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject json = super.toJson();
        o.a(json, KEY_EMOTION_RESPONSE_LIST, this.mEmotionPackageList);
        return json;
    }
}
