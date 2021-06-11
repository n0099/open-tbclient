package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class InstallActivateReminderConfigItem extends a<InstallActivateReminderConfig> {

    /* loaded from: classes6.dex */
    public static class InstallActivateReminderConfig extends com.kwad.sdk.core.response.a.a implements Serializable {
        public static final long serialVersionUID = -6457271849826128465L;
        public int noticeTotalCount = 3;
        public int perAppNoticeCount = 2;
        public int noticeAppearTime = 15000;
        public int noticeContinueTime = 15000;
    }

    public InstallActivateReminderConfigItem() {
        super("installActivateReminderConfig", new InstallActivateReminderConfig());
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
        InstallActivateReminderConfig b2 = b();
        if (b2 == null) {
            b2 = new InstallActivateReminderConfig();
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
        a((InstallActivateReminderConfigItem) b2);
    }

    @Override // com.kwad.sdk.core.config.item.a
    public void a(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject(a())) == null) {
            a((InstallActivateReminderConfigItem) c());
            return;
        }
        InstallActivateReminderConfig installActivateReminderConfig = new InstallActivateReminderConfig();
        installActivateReminderConfig.parseJson(optJSONObject);
        a((InstallActivateReminderConfigItem) installActivateReminderConfig);
    }

    public int d() {
        return b().noticeTotalCount;
    }

    public int e() {
        return b().perAppNoticeCount;
    }

    public int f() {
        return b().noticeAppearTime;
    }

    public int g() {
        return b().noticeContinueTime;
    }
}
