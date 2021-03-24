package com.kwad.sdk.core.c.a;

import com.kwad.sdk.core.config.item.InstallActivateReminderConfigItem;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class u implements com.kwad.sdk.core.c<InstallActivateReminderConfigItem.InstallActivateReminderConfig> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public JSONObject a(InstallActivateReminderConfigItem.InstallActivateReminderConfig installActivateReminderConfig) {
        JSONObject jSONObject = new JSONObject();
        com.kwad.sdk.utils.o.a(jSONObject, "noticeTotalCount", installActivateReminderConfig.noticeTotalCount);
        com.kwad.sdk.utils.o.a(jSONObject, "perAppNoticeCount", installActivateReminderConfig.perAppNoticeCount);
        com.kwad.sdk.utils.o.a(jSONObject, "noticeAppearTime", installActivateReminderConfig.noticeAppearTime);
        com.kwad.sdk.utils.o.a(jSONObject, "noticeContinueTime", installActivateReminderConfig.noticeContinueTime);
        return jSONObject;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public void a(InstallActivateReminderConfigItem.InstallActivateReminderConfig installActivateReminderConfig, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        installActivateReminderConfig.noticeTotalCount = jSONObject.optInt("noticeTotalCount", new Integer("3").intValue());
        installActivateReminderConfig.perAppNoticeCount = jSONObject.optInt("perAppNoticeCount", new Integer("2").intValue());
        installActivateReminderConfig.noticeAppearTime = jSONObject.optInt("noticeAppearTime", new Integer("15000").intValue());
        installActivateReminderConfig.noticeContinueTime = jSONObject.optInt("noticeContinueTime", new Integer("15000").intValue());
    }
}
