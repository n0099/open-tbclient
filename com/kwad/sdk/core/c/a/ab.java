package com.kwad.sdk.core.c.a;

import com.kwad.sdk.core.config.item.ProfileGuideConfigItem;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class ab implements com.kwad.sdk.core.c<ProfileGuideConfigItem.ProfileGuideConfig> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public JSONObject a(ProfileGuideConfigItem.ProfileGuideConfig profileGuideConfig) {
        JSONObject jSONObject = new JSONObject();
        com.kwad.sdk.utils.o.a(jSONObject, "appearTime", profileGuideConfig.appearTime);
        com.kwad.sdk.utils.o.a(jSONObject, "showInterval", profileGuideConfig.showInterval);
        com.kwad.sdk.utils.o.a(jSONObject, "showCount", profileGuideConfig.showCount);
        return jSONObject;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public void a(ProfileGuideConfigItem.ProfileGuideConfig profileGuideConfig, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        profileGuideConfig.appearTime = jSONObject.optLong("appearTime", new Long("2000").longValue());
        profileGuideConfig.showInterval = jSONObject.optInt("showInterval", new Integer("3").intValue());
        profileGuideConfig.showCount = jSONObject.optInt("showCount", new Integer("2").intValue());
    }
}
