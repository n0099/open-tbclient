package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class InstallActivateReminderConfigItem extends b {

    /* loaded from: classes7.dex */
    public class InstallActivateReminderConfig extends com.kwad.sdk.core.response.kwai.a implements Serializable {
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
    public final void a(SharedPreferences sharedPreferences) {
        InstallActivateReminderConfig installActivateReminderConfig = (InstallActivateReminderConfig) getValue();
        if (installActivateReminderConfig == null) {
            installActivateReminderConfig = new InstallActivateReminderConfig();
        }
        JSONObject jSONObject = null;
        try {
            jSONObject = new JSONObject(sharedPreferences.getString(getKey(), ""));
        } catch (JSONException e) {
            com.kwad.sdk.core.e.b.printStackTraceOnly(e);
        }
        if (jSONObject != null) {
            installActivateReminderConfig.parseJson(jSONObject);
        }
        setValue(installActivateReminderConfig);
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void b(SharedPreferences.Editor editor) {
        String key;
        String str;
        if (getValue() == null || ((InstallActivateReminderConfig) getValue()).toJson() == null) {
            key = getKey();
            str = "";
        } else {
            key = getKey();
            str = ((InstallActivateReminderConfig) getValue()).toJson().toString();
        }
        editor.putString(key, str);
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void e(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject(getKey())) == null) {
            setValue(sx());
            return;
        }
        InstallActivateReminderConfig installActivateReminderConfig = new InstallActivateReminderConfig();
        installActivateReminderConfig.parseJson(optJSONObject);
        setValue(installActivateReminderConfig);
    }
}
