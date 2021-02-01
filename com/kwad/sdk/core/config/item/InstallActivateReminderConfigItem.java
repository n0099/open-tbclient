package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class InstallActivateReminderConfigItem extends a<InstallActivateReminderConfig> {

    /* loaded from: classes3.dex */
    public static class InstallActivateReminderConfig extends com.kwad.sdk.core.response.a.a implements Serializable {
        private static final long serialVersionUID = -6457271849826128465L;
        public int noticeTotalCount = 3;
        public int perAppNoticeCount = 2;
        public int noticeAppearTime = BdStatisticsManager.INIT_UPLOAD_TIME_INTERVAL;
        public int noticeContinueTime = BdStatisticsManager.INIT_UPLOAD_TIME_INTERVAL;
    }

    public InstallActivateReminderConfigItem() {
        super("installActivateReminderConfig", new InstallActivateReminderConfig());
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
        InstallActivateReminderConfig b2 = b();
        if (b2 == null) {
            b2 = new InstallActivateReminderConfig();
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
