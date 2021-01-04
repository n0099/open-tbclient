package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class ProfileGuideConfigItem extends a<ProfileGuideConfig> {

    /* loaded from: classes5.dex */
    public static class ProfileGuideConfig extends com.kwad.sdk.core.response.a.a implements Serializable {
        private static final long serialVersionUID = -2971202373481870211L;
        public long appearTime = 2000;
        public int showInterval = 3;
        public int showCount = 2;
    }

    public ProfileGuideConfigItem() {
        super("profileGuideConfig", new ProfileGuideConfig());
    }

    @Override // com.kwad.sdk.core.config.item.a
    public void a(@NonNull SharedPreferences.Editor editor) {
        if (b() == null || b().toJson() == null) {
            editor.putString(a(), "");
        } else {
            editor.putString(a(), b().toJson().toString());
        }
    }

    @Override // com.kwad.sdk.core.config.item.a
    public void a(@NonNull SharedPreferences sharedPreferences) {
        JSONObject jSONObject;
        ProfileGuideConfig b2 = b();
        if (b2 == null) {
            b2 = new ProfileGuideConfig();
        }
        try {
            jSONObject = new JSONObject(sharedPreferences.getString(a(), ""));
        } catch (JSONException e) {
            com.kwad.sdk.core.d.a.b(e);
            jSONObject = null;
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

    public long d() {
        return b().appearTime;
    }

    public int e() {
        return b().showInterval;
    }

    public int f() {
        return b().showCount;
    }
}
