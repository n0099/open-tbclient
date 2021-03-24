package com.kwad.sdk.contentalliance.profile.home.model;

import androidx.annotation.Nullable;
import com.kwad.sdk.core.b;
import com.kwad.sdk.core.b.d;
import com.kwad.sdk.core.network.BaseResultData;
import com.kwad.sdk.utils.o;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class ProfileResultData extends BaseResultData implements b {
    public static final long serialVersionUID = 5593104938742949008L;
    public UserProfile userProfile = new UserProfile();

    @Override // com.kwad.sdk.core.network.BaseResultData
    public boolean isDataEmpty() {
        UserProfile userProfile = this.userProfile;
        return userProfile == null || userProfile.tabList.isEmpty();
    }

    @Override // com.kwad.sdk.core.network.BaseResultData
    public void parseJson(@Nullable JSONObject jSONObject) {
        super.parseJson(jSONObject);
        if (jSONObject == null) {
            return;
        }
        try {
            this.userProfile.parseJson(new JSONObject(d.b(jSONObject.optString("data"))));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.kwad.sdk.core.network.BaseResultData, com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject json = super.toJson();
        o.a(json, "data", this.userProfile);
        return json;
    }
}
