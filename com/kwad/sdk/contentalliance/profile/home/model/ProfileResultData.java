package com.kwad.sdk.contentalliance.profile.home.model;

import androidx.annotation.Nullable;
import com.kwad.sdk.core.b;
import com.kwad.sdk.core.b.d;
import com.kwad.sdk.core.network.BaseResultData;
import com.kwad.sdk.utils.o;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class ProfileResultData extends BaseResultData implements b {
    private static final long serialVersionUID = 5593104938742949008L;
    public UserProfile userProfile = new UserProfile();

    @Override // com.kwad.sdk.core.network.BaseResultData
    public boolean isDataEmpty() {
        return this.userProfile == null || this.userProfile.tabList.isEmpty();
    }

    @Override // com.kwad.sdk.core.network.BaseResultData
    public void parseJson(@Nullable JSONObject jSONObject) {
        super.parseJson(jSONObject);
        if (jSONObject == null) {
            return;
        }
        try {
            this.userProfile.parseJson(new JSONObject(d.b(jSONObject.optString("data"))));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override // com.kwad.sdk.core.network.BaseResultData, com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject json = super.toJson();
        o.a(json, "data", this.userProfile);
        return json;
    }
}
