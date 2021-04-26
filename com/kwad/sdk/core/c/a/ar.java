package com.kwad.sdk.core.c.a;

import com.kwad.sdk.core.response.model.AdStyleInfo;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class ar implements com.kwad.sdk.core.c<AdStyleInfo.PlayDetailInfo.PatchAdInfo> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public void a(AdStyleInfo.PlayDetailInfo.PatchAdInfo patchAdInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        patchAdInfo.weakStyleIcon = jSONObject.optString("weakStyleIcon");
        patchAdInfo.weakStyleTitle = jSONObject.optString("weakStyleTitle");
        patchAdInfo.weakStyleDownloadingTitle = jSONObject.optString("weakStyleDownloadingTitle");
        patchAdInfo.weakStyleAdMark = jSONObject.optString("weakStyleAdMark");
        patchAdInfo.weakStyleAppearTime = jSONObject.optLong("weakStyleAppearTime");
        patchAdInfo.weakStyleEnableClose = jSONObject.optBoolean("weakStyleEnableClose", new Boolean("true").booleanValue());
        patchAdInfo.typePortrait = jSONObject.optInt("typePortrait");
        patchAdInfo.strongStyleCardUrl = jSONObject.optString("strongStyleCardUrl");
        patchAdInfo.strongStyleAppearTime = jSONObject.optLong("strongStyleAppearTime");
        patchAdInfo.strongStyleTitle = jSONObject.optString("strongStyleTitle");
        patchAdInfo.strongStyleSubTitle = jSONObject.optString("strongStyleSubTitle");
        patchAdInfo.strongStyleAdMark = jSONObject.optString("strongStyleAdMark");
        patchAdInfo.strongStyleEnableClose = jSONObject.optBoolean("strongStyleEnableClose", new Boolean("true").booleanValue());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public JSONObject b(AdStyleInfo.PlayDetailInfo.PatchAdInfo patchAdInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.o.a(jSONObject, "weakStyleIcon", patchAdInfo.weakStyleIcon);
        com.kwad.sdk.utils.o.a(jSONObject, "weakStyleTitle", patchAdInfo.weakStyleTitle);
        com.kwad.sdk.utils.o.a(jSONObject, "weakStyleDownloadingTitle", patchAdInfo.weakStyleDownloadingTitle);
        com.kwad.sdk.utils.o.a(jSONObject, "weakStyleAdMark", patchAdInfo.weakStyleAdMark);
        com.kwad.sdk.utils.o.a(jSONObject, "weakStyleAppearTime", patchAdInfo.weakStyleAppearTime);
        com.kwad.sdk.utils.o.a(jSONObject, "weakStyleEnableClose", patchAdInfo.weakStyleEnableClose);
        com.kwad.sdk.utils.o.a(jSONObject, "typePortrait", patchAdInfo.typePortrait);
        com.kwad.sdk.utils.o.a(jSONObject, "strongStyleCardUrl", patchAdInfo.strongStyleCardUrl);
        com.kwad.sdk.utils.o.a(jSONObject, "strongStyleAppearTime", patchAdInfo.strongStyleAppearTime);
        com.kwad.sdk.utils.o.a(jSONObject, "strongStyleTitle", patchAdInfo.strongStyleTitle);
        com.kwad.sdk.utils.o.a(jSONObject, "strongStyleSubTitle", patchAdInfo.strongStyleSubTitle);
        com.kwad.sdk.utils.o.a(jSONObject, "strongStyleAdMark", patchAdInfo.strongStyleAdMark);
        com.kwad.sdk.utils.o.a(jSONObject, "strongStyleEnableClose", patchAdInfo.strongStyleEnableClose);
        return jSONObject;
    }
}
