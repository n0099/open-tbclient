package com.kwad.sdk.emotion.model;

import androidx.annotation.Nullable;
import com.kwad.sdk.utils.o;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class EmotionPackage extends com.kwad.sdk.core.response.a.a implements com.kwad.sdk.core.b, Serializable {
    public static final String KEY_EMOTION_PACKAGE_EXTRA_INFO = "extraInfo";
    public static final long serialVersionUID = 1381491558995019696L;
    public String description;
    public EmotionAuthor emotionAuthor;
    public List<EmotionInfo> emotions = new ArrayList();
    public Map<String, String> extraInfo;
    public String id;
    public String introduction;
    public String name;
    public List<CDNUrl> packageBannerUrl;
    public List<CDNUrl> packageDownloadUrl;
    public List<CDNUrl> packageImageBigUrl;
    public List<CDNUrl> packageImageMiddleUrl;
    public List<CDNUrl> packageImageSmallUrl;
    public String style;
    public int type;

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

    public String getId() {
        return this.id;
    }
}
