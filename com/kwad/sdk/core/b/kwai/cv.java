package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.response.model.AdStyleInfo;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class cv implements com.kwad.sdk.core.d<AdStyleInfo.PlayDetailInfo.PatchAdInfo> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public void a(AdStyleInfo.PlayDetailInfo.PatchAdInfo patchAdInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        patchAdInfo.weakStyleIcon = jSONObject.optString("weakStyleIcon");
        if (jSONObject.opt("weakStyleIcon") == JSONObject.NULL) {
            patchAdInfo.weakStyleIcon = "";
        }
        patchAdInfo.weakStyleTitle = jSONObject.optString("weakStyleTitle");
        if (jSONObject.opt("weakStyleTitle") == JSONObject.NULL) {
            patchAdInfo.weakStyleTitle = "";
        }
        patchAdInfo.weakStyleDownloadingTitle = jSONObject.optString("weakStyleDownloadingTitle");
        if (jSONObject.opt("weakStyleDownloadingTitle") == JSONObject.NULL) {
            patchAdInfo.weakStyleDownloadingTitle = "";
        }
        patchAdInfo.weakStyleAdMark = jSONObject.optString("weakStyleAdMark");
        if (jSONObject.opt("weakStyleAdMark") == JSONObject.NULL) {
            patchAdInfo.weakStyleAdMark = "";
        }
        patchAdInfo.weakStyleAppearTime = jSONObject.optLong("weakStyleAppearTime");
        patchAdInfo.weakStyleEnableClose = jSONObject.optBoolean("weakStyleEnableClose", new Boolean("true").booleanValue());
        patchAdInfo.typePortrait = jSONObject.optInt("typePortrait");
        patchAdInfo.strongStyleCardUrl = jSONObject.optString("strongStyleCardUrl");
        if (jSONObject.opt("strongStyleCardUrl") == JSONObject.NULL) {
            patchAdInfo.strongStyleCardUrl = "";
        }
        patchAdInfo.strongStyleAppearTime = jSONObject.optLong("strongStyleAppearTime");
        patchAdInfo.strongStyleTitle = jSONObject.optString("strongStyleTitle");
        if (jSONObject.opt("strongStyleTitle") == JSONObject.NULL) {
            patchAdInfo.strongStyleTitle = "";
        }
        patchAdInfo.strongStyleSubTitle = jSONObject.optString("strongStyleSubTitle");
        if (jSONObject.opt("strongStyleSubTitle") == JSONObject.NULL) {
            patchAdInfo.strongStyleSubTitle = "";
        }
        patchAdInfo.strongStyleAdMark = jSONObject.optString("strongStyleAdMark");
        if (jSONObject.opt("strongStyleAdMark") == JSONObject.NULL) {
            patchAdInfo.strongStyleAdMark = "";
        }
        patchAdInfo.strongStyleEnableClose = jSONObject.optBoolean("strongStyleEnableClose", new Boolean("true").booleanValue());
        patchAdInfo.weakStyleShowTime = jSONObject.optLong("weakStyleShowTime");
        patchAdInfo.strongStyleShowTime = jSONObject.optLong("strongStyleShowTime");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(AdStyleInfo.PlayDetailInfo.PatchAdInfo patchAdInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "weakStyleIcon", patchAdInfo.weakStyleIcon);
        com.kwad.sdk.utils.t.a(jSONObject, "weakStyleTitle", patchAdInfo.weakStyleTitle);
        com.kwad.sdk.utils.t.a(jSONObject, "weakStyleDownloadingTitle", patchAdInfo.weakStyleDownloadingTitle);
        com.kwad.sdk.utils.t.a(jSONObject, "weakStyleAdMark", patchAdInfo.weakStyleAdMark);
        com.kwad.sdk.utils.t.a(jSONObject, "weakStyleAppearTime", patchAdInfo.weakStyleAppearTime);
        com.kwad.sdk.utils.t.a(jSONObject, "weakStyleEnableClose", patchAdInfo.weakStyleEnableClose);
        com.kwad.sdk.utils.t.a(jSONObject, "typePortrait", patchAdInfo.typePortrait);
        com.kwad.sdk.utils.t.a(jSONObject, "strongStyleCardUrl", patchAdInfo.strongStyleCardUrl);
        com.kwad.sdk.utils.t.a(jSONObject, "strongStyleAppearTime", patchAdInfo.strongStyleAppearTime);
        com.kwad.sdk.utils.t.a(jSONObject, "strongStyleTitle", patchAdInfo.strongStyleTitle);
        com.kwad.sdk.utils.t.a(jSONObject, "strongStyleSubTitle", patchAdInfo.strongStyleSubTitle);
        com.kwad.sdk.utils.t.a(jSONObject, "strongStyleAdMark", patchAdInfo.strongStyleAdMark);
        com.kwad.sdk.utils.t.a(jSONObject, "strongStyleEnableClose", patchAdInfo.strongStyleEnableClose);
        com.kwad.sdk.utils.t.a(jSONObject, "weakStyleShowTime", patchAdInfo.weakStyleShowTime);
        com.kwad.sdk.utils.t.a(jSONObject, "strongStyleShowTime", patchAdInfo.strongStyleShowTime);
        return jSONObject;
    }
}
