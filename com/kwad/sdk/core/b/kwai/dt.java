package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.response.model.AdStyleInfo;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class dt implements com.kwad.sdk.core.d<AdStyleInfo.PlayDetailInfo.PatchAdInfo> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(AdStyleInfo.PlayDetailInfo.PatchAdInfo patchAdInfo, JSONObject jSONObject) {
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

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(AdStyleInfo.PlayDetailInfo.PatchAdInfo patchAdInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.r.a(jSONObject, "weakStyleIcon", patchAdInfo.weakStyleIcon);
        com.kwad.sdk.utils.r.a(jSONObject, "weakStyleTitle", patchAdInfo.weakStyleTitle);
        com.kwad.sdk.utils.r.a(jSONObject, "weakStyleDownloadingTitle", patchAdInfo.weakStyleDownloadingTitle);
        com.kwad.sdk.utils.r.a(jSONObject, "weakStyleAdMark", patchAdInfo.weakStyleAdMark);
        com.kwad.sdk.utils.r.a(jSONObject, "weakStyleAppearTime", patchAdInfo.weakStyleAppearTime);
        com.kwad.sdk.utils.r.a(jSONObject, "weakStyleEnableClose", patchAdInfo.weakStyleEnableClose);
        com.kwad.sdk.utils.r.a(jSONObject, "typePortrait", patchAdInfo.typePortrait);
        com.kwad.sdk.utils.r.a(jSONObject, "strongStyleCardUrl", patchAdInfo.strongStyleCardUrl);
        com.kwad.sdk.utils.r.a(jSONObject, "strongStyleAppearTime", patchAdInfo.strongStyleAppearTime);
        com.kwad.sdk.utils.r.a(jSONObject, "strongStyleTitle", patchAdInfo.strongStyleTitle);
        com.kwad.sdk.utils.r.a(jSONObject, "strongStyleSubTitle", patchAdInfo.strongStyleSubTitle);
        com.kwad.sdk.utils.r.a(jSONObject, "strongStyleAdMark", patchAdInfo.strongStyleAdMark);
        com.kwad.sdk.utils.r.a(jSONObject, "strongStyleEnableClose", patchAdInfo.strongStyleEnableClose);
        com.kwad.sdk.utils.r.a(jSONObject, "weakStyleShowTime", patchAdInfo.weakStyleShowTime);
        com.kwad.sdk.utils.r.a(jSONObject, "strongStyleShowTime", patchAdInfo.strongStyleShowTime);
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdStyleInfo.PlayDetailInfo.PatchAdInfo patchAdInfo, JSONObject jSONObject) {
        a2(patchAdInfo, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdStyleInfo.PlayDetailInfo.PatchAdInfo patchAdInfo, JSONObject jSONObject) {
        return b2(patchAdInfo, jSONObject);
    }
}
