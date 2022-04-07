package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class AvatarGuiderConfigItem extends b<AvatarGuiderConfig> {

    /* loaded from: classes5.dex */
    public static class AvatarGuiderConfig extends com.kwad.sdk.core.response.kwai.a implements Serializable {
        public int showByPlayRate;
        public int showMaxTimes;
        public int showTimeLength;
    }

    public AvatarGuiderConfigItem() {
        super("avatarGuiderConfig", null);
    }

    @Override // com.kwad.sdk.core.config.item.b
    public void a(@NonNull SharedPreferences.Editor editor) {
        String b;
        String str;
        if (a() == null || a().toJson() == null) {
            b = b();
            str = "";
        } else {
            b = b();
            str = a().toJson().toString();
        }
        editor.putString(b, str);
    }

    @Override // com.kwad.sdk.core.config.item.b
    public void a(@NonNull SharedPreferences sharedPreferences) {
        AvatarGuiderConfig a = a();
        if (a == null) {
            a = new AvatarGuiderConfig();
        }
        JSONObject jSONObject = null;
        try {
            jSONObject = new JSONObject(sharedPreferences.getString(b(), ""));
        } catch (JSONException e) {
            com.kwad.sdk.core.d.a.b(e);
        }
        if (jSONObject != null) {
            a.parseJson(jSONObject);
        }
        a((AvatarGuiderConfigItem) a);
    }

    @Override // com.kwad.sdk.core.config.item.b
    public void a(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject(b())) == null) {
            com.kwad.sdk.core.d.a.a("AvatarGuiderConfigItem", "AvatarGuiderConfigItem = getDefault");
            a((AvatarGuiderConfigItem) c());
            return;
        }
        AvatarGuiderConfig avatarGuiderConfig = new AvatarGuiderConfig();
        avatarGuiderConfig.parseJson(optJSONObject);
        com.kwad.sdk.core.d.a.a("AvatarGuiderConfigItem", "AvatarGuiderConfigItem = " + avatarGuiderConfig.toJson().toString());
        a((AvatarGuiderConfigItem) avatarGuiderConfig);
    }
}
