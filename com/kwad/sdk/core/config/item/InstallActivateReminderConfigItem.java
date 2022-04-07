package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class InstallActivateReminderConfigItem extends b<InstallActivateReminderConfig> {

    /* loaded from: classes5.dex */
    public static class InstallActivateReminderConfig extends com.kwad.sdk.core.response.kwai.a implements Serializable {
        public static final long serialVersionUID = -6457271849826128465L;
        public int noticeTotalCount = 3;
        public int perAppNoticeCount = 2;
        public int noticeAppearTime = 15000;
        public int noticeContinueTime = 15000;
    }

    public InstallActivateReminderConfigItem() {
        super("installActivateReminderConfig", new InstallActivateReminderConfig());
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
        InstallActivateReminderConfig a = a();
        if (a == null) {
            a = new InstallActivateReminderConfig();
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
        a((InstallActivateReminderConfigItem) a);
    }

    @Override // com.kwad.sdk.core.config.item.b
    public void a(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject(b())) == null) {
            a((InstallActivateReminderConfigItem) c());
            return;
        }
        InstallActivateReminderConfig installActivateReminderConfig = new InstallActivateReminderConfig();
        installActivateReminderConfig.parseJson(optJSONObject);
        a((InstallActivateReminderConfigItem) installActivateReminderConfig);
    }
}
