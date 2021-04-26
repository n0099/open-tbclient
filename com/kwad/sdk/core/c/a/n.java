package com.kwad.sdk.core.c.a;

import com.baidu.tbadk.core.util.TbEnum;
import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class n implements com.kwad.sdk.core.c<AdInfo.AdvertiserInfo> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public void a(AdInfo.AdvertiserInfo advertiserInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        advertiserInfo.userId = jSONObject.optLong("userId");
        advertiserInfo.userName = jSONObject.optString(TbEnum.SystemMessage.KEY_USER_NAME);
        advertiserInfo.rawUserName = jSONObject.optString("rawUserName");
        advertiserInfo.userGender = jSONObject.optString("userGender");
        advertiserInfo.portraitUrl = jSONObject.optString("portraitUrl");
        advertiserInfo.adAuthorText = jSONObject.optString("adAuthorText");
        advertiserInfo.authorIconGuide = jSONObject.optString("authorIconGuide");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public JSONObject b(AdInfo.AdvertiserInfo advertiserInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.o.a(jSONObject, "userId", advertiserInfo.userId);
        com.kwad.sdk.utils.o.a(jSONObject, TbEnum.SystemMessage.KEY_USER_NAME, advertiserInfo.userName);
        com.kwad.sdk.utils.o.a(jSONObject, "rawUserName", advertiserInfo.rawUserName);
        com.kwad.sdk.utils.o.a(jSONObject, "userGender", advertiserInfo.userGender);
        com.kwad.sdk.utils.o.a(jSONObject, "portraitUrl", advertiserInfo.portraitUrl);
        com.kwad.sdk.utils.o.a(jSONObject, "adAuthorText", advertiserInfo.adAuthorText);
        com.kwad.sdk.utils.o.a(jSONObject, "authorIconGuide", advertiserInfo.authorIconGuide);
        return jSONObject;
    }
}
