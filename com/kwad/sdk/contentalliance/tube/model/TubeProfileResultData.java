package com.kwad.sdk.contentalliance.tube.model;

import androidx.annotation.Nullable;
import com.kwad.sdk.core.b;
import com.kwad.sdk.core.d.a;
import com.kwad.sdk.core.network.BaseResultData;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.o;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class TubeProfileResultData extends BaseResultData implements b {
    public static final long serialVersionUID = 4200733339719277993L;
    public SceneImpl mSceneImpl;
    public TubeProfile tubeProfile = new TubeProfile();
    public List<TubeProfile> trendList = new ArrayList();

    public TubeProfileResultData() {
    }

    public TubeProfileResultData(SceneImpl sceneImpl) {
        this.mSceneImpl = sceneImpl;
    }

    @Override // com.kwad.sdk.core.network.BaseResultData
    public void parseJson(@Nullable JSONObject jSONObject) {
        super.parseJson(jSONObject);
        if (jSONObject == null) {
            return;
        }
        try {
            this.tubeProfile.llsid = this.llsid;
            this.tubeProfile.extra = this.extra;
            this.tubeProfile.mSceneImpl = this.mSceneImpl;
            this.tubeProfile.parseJson(jSONObject.optJSONObject("tubeProfile"));
            JSONArray optJSONArray = jSONObject.optJSONArray("trendList");
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                return;
            }
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    TubeProfile tubeProfile = new TubeProfile();
                    tubeProfile.llsid = this.llsid;
                    tubeProfile.extra = this.extra;
                    tubeProfile.mSceneImpl = this.mSceneImpl;
                    tubeProfile.parseJson(optJSONObject);
                    this.trendList.add(tubeProfile);
                }
            }
        } catch (Exception e2) {
            a.a(e2);
        }
    }

    @Override // com.kwad.sdk.core.network.BaseResultData, com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject json = super.toJson();
        o.a(json, "trendList", this.trendList);
        o.a(json, "tubeProfile", this.tubeProfile);
        return json;
    }
}
