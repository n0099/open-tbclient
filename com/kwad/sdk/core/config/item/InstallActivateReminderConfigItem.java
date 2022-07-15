package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class InstallActivateReminderConfigItem extends b<InstallActivateReminderConfig> {

    @KsJson
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
    public final void a(@NonNull SharedPreferences.Editor editor) {
        String a;
        String str;
        if (b() == null || b().toJson() == null) {
            a = a();
            str = "";
        } else {
            a = a();
            str = b().toJson().toString();
        }
        editor.putString(a, str);
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void a(@NonNull SharedPreferences sharedPreferences) {
        InstallActivateReminderConfig b = b();
        if (b == null) {
            b = new InstallActivateReminderConfig();
        }
        JSONObject jSONObject = null;
        try {
            jSONObject = new JSONObject(sharedPreferences.getString(a(), ""));
        } catch (JSONException e) {
            com.kwad.sdk.core.d.b.b(e);
        }
        if (jSONObject != null) {
            b.parseJson(jSONObject);
        }
        a((InstallActivateReminderConfigItem) b);
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void a(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject(a())) == null) {
            a((InstallActivateReminderConfigItem) c());
            return;
        }
        InstallActivateReminderConfig installActivateReminderConfig = new InstallActivateReminderConfig();
        installActivateReminderConfig.parseJson(optJSONObject);
        a((InstallActivateReminderConfigItem) installActivateReminderConfig);
    }
}
