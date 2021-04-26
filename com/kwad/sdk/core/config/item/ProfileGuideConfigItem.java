package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class ProfileGuideConfigItem extends a<ProfileGuideConfig> {

    /* loaded from: classes6.dex */
    public static class ProfileGuideConfig extends com.kwad.sdk.core.response.a.a implements Serializable {
        public static final long serialVersionUID = -2971202373481870211L;
        public long appearTime = 2000;
        public int showInterval = 3;
        public int showCount = 2;
    }

    public ProfileGuideConfigItem() {
        super("profileGuideConfig", new ProfileGuideConfig());
    }

    @Override // com.kwad.sdk.core.config.item.a
    public void a(@NonNull SharedPreferences.Editor editor) {
        String a2;
        String str;
        if (b() == null || b().toJson() == null) {
            a2 = a();
            str = "";
        } else {
            a2 = a();
            str = b().toJson().toString();
        }
        editor.putString(a2, str);
    }

    @Override // com.kwad.sdk.core.config.item.a
    public void a(@NonNull SharedPreferences sharedPreferences) {
        ProfileGuideConfig b2 = b();
        if (b2 == null) {
            b2 = new ProfileGuideConfig();
        }
        JSONObject jSONObject = null;
        try {
            jSONObject = new JSONObject(sharedPreferences.getString(a(), ""));
        } catch (JSONException e2) {
            com.kwad.sdk.core.d.a.b(e2);
        }
        if (jSONObject != null) {
            b2.parseJson(jSONObject);
        }
        a((ProfileGuideConfigItem) b2);
    }

    @Override // com.kwad.sdk.core.config.item.a
    public void a(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject(a())) == null) {
            a((ProfileGuideConfigItem) c());
            return;
        }
        ProfileGuideConfig profileGuideConfig = new ProfileGuideConfig();
        profileGuideConfig.parseJson(optJSONObject);
        a((ProfileGuideConfigItem) profileGuideConfig);
    }
}
