package com.kwad.sdk.emotion.model;

import androidx.annotation.Nullable;
import com.kwad.sdk.utils.o;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class EmotionInfo extends com.kwad.sdk.core.response.a.a implements com.kwad.sdk.core.b, Serializable {
    public static final String KEY_EMOTION_INFO_EXTRA_INFO = "extraInfo";
    public static final long serialVersionUID = 8005337986172532989L;
    public List<EmotionCode> emotionCodes = new ArrayList();
    public List<CDNUrl> emotionImageBigUrl;
    public List<CDNUrl> emotionImageSmallUrl;
    public Map<String, String> extraInfo;
    public int height;
    public String id;
    public int mIndex;
    public int mPageIndex;
    public String name;
    public String packageId;
    public int type;
    public int width;

    @Override // com.kwad.sdk.core.response.a.a
    public void afterParseJson(@Nullable JSONObject jSONObject) {
        super.afterParseJson(jSONObject);
        if (jSONObject == null) {
            return;
        }
        this.extraInfo = o.b(jSONObject.optString("extraInfo"));
    }

    @Override // com.kwad.sdk.core.response.a.a
    public void afterToJson(JSONObject jSONObject) {
        super.afterToJson(jSONObject);
        o.a(jSONObject, "extraInfo", o.a(this.extraInfo));
    }
}
