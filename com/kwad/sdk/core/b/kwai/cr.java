package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.config.item.InstallActivateReminderConfigItem;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class cr implements com.kwad.sdk.core.d<InstallActivateReminderConfigItem.InstallActivateReminderConfig> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(InstallActivateReminderConfigItem.InstallActivateReminderConfig installActivateReminderConfig, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        installActivateReminderConfig.noticeTotalCount = jSONObject.optInt("noticeTotalCount", new Integer("3").intValue());
        installActivateReminderConfig.perAppNoticeCount = jSONObject.optInt("perAppNoticeCount", new Integer("2").intValue());
        installActivateReminderConfig.noticeAppearTime = jSONObject.optInt("noticeAppearTime", new Integer("15000").intValue());
        installActivateReminderConfig.noticeContinueTime = jSONObject.optInt("noticeContinueTime", new Integer("15000").intValue());
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(InstallActivateReminderConfigItem.InstallActivateReminderConfig installActivateReminderConfig, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.r.a(jSONObject, "noticeTotalCount", installActivateReminderConfig.noticeTotalCount);
        com.kwad.sdk.utils.r.a(jSONObject, "perAppNoticeCount", installActivateReminderConfig.perAppNoticeCount);
        com.kwad.sdk.utils.r.a(jSONObject, "noticeAppearTime", installActivateReminderConfig.noticeAppearTime);
        com.kwad.sdk.utils.r.a(jSONObject, "noticeContinueTime", installActivateReminderConfig.noticeContinueTime);
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(InstallActivateReminderConfigItem.InstallActivateReminderConfig installActivateReminderConfig, JSONObject jSONObject) {
        a2(installActivateReminderConfig, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(InstallActivateReminderConfigItem.InstallActivateReminderConfig installActivateReminderConfig, JSONObject jSONObject) {
        return b2(installActivateReminderConfig, jSONObject);
    }
}
