package com.kwad.sdk.contentalliance.tube.model;

import androidx.annotation.Nullable;
import com.kwad.sdk.core.b;
import com.kwad.sdk.core.b.d;
import com.kwad.sdk.core.d.a;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.o;
import java.io.Serializable;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class TubeProfile implements b, Serializable {
    private static final long serialVersionUID = 7887251687731744372L;
    public String extra;
    public long llsid;
    public SceneImpl mSceneImpl;
    public TubeInfo tubeInfo = new TubeInfo();
    public com.kwad.sdk.lib.widget.b<AdTemplate> adTemplateList = new com.kwad.sdk.lib.widget.b<>(new ArrayList());

    public void parseJson(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            this.tubeInfo.parseJson(jSONObject.getJSONObject("tubeInfo"));
            JSONArray jSONArray = new JSONArray(d.b(jSONObject.optString("impAdInfo")));
            if (jSONArray.length() > 0) {
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        AdTemplate adTemplate = new AdTemplate();
                        adTemplate.parseJson(optJSONObject);
                        adTemplate.llsid = this.llsid;
                        adTemplate.extra = this.extra;
                        adTemplate.mAdScene = this.mSceneImpl;
                        this.adTemplateList.add(adTemplate);
                    }
                }
            }
        } catch (Exception e) {
            a.a(e);
        }
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        o.a(jSONObject, "tubeInfo", this.tubeInfo);
        o.a(jSONObject, "impAdInfo", this.adTemplateList);
        return jSONObject;
    }
}
