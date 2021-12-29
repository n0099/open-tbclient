package com.kwad.sdk.core.b.kwai;

import com.baidu.android.imsdk.db.DBTableDefine;
import com.baidu.tbadk.core.util.TbEnum;
import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class x implements com.kwad.sdk.core.d<AdInfo.AdvertiserInfo> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public void a(AdInfo.AdvertiserInfo advertiserInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        advertiserInfo.userId = jSONObject.optLong("userId");
        advertiserInfo.userName = jSONObject.optString(TbEnum.SystemMessage.KEY_USER_NAME);
        if (jSONObject.opt(TbEnum.SystemMessage.KEY_USER_NAME) == JSONObject.NULL) {
            advertiserInfo.userName = "";
        }
        advertiserInfo.rawUserName = jSONObject.optString("rawUserName");
        if (jSONObject.opt("rawUserName") == JSONObject.NULL) {
            advertiserInfo.rawUserName = "";
        }
        advertiserInfo.userGender = jSONObject.optString("userGender");
        if (jSONObject.opt("userGender") == JSONObject.NULL) {
            advertiserInfo.userGender = "";
        }
        advertiserInfo.portraitUrl = jSONObject.optString("portraitUrl");
        if (jSONObject.opt("portraitUrl") == JSONObject.NULL) {
            advertiserInfo.portraitUrl = "";
        }
        advertiserInfo.adAuthorText = jSONObject.optString("adAuthorText");
        if (jSONObject.opt("adAuthorText") == JSONObject.NULL) {
            advertiserInfo.adAuthorText = "";
        }
        advertiserInfo.authorIconGuide = jSONObject.optString("authorIconGuide");
        if (jSONObject.opt("authorIconGuide") == JSONObject.NULL) {
            advertiserInfo.authorIconGuide = "";
        }
        advertiserInfo.followed = jSONObject.optBoolean("followed");
        advertiserInfo.fansCount = jSONObject.optInt("fansCount");
        advertiserInfo.brief = jSONObject.optString(DBTableDefine.GroupInfoColumns.COLUMN_BRIEF);
        if (jSONObject.opt(DBTableDefine.GroupInfoColumns.COLUMN_BRIEF) == JSONObject.NULL) {
            advertiserInfo.brief = "";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(AdInfo.AdvertiserInfo advertiserInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "userId", advertiserInfo.userId);
        com.kwad.sdk.utils.t.a(jSONObject, TbEnum.SystemMessage.KEY_USER_NAME, advertiserInfo.userName);
        com.kwad.sdk.utils.t.a(jSONObject, "rawUserName", advertiserInfo.rawUserName);
        com.kwad.sdk.utils.t.a(jSONObject, "userGender", advertiserInfo.userGender);
        com.kwad.sdk.utils.t.a(jSONObject, "portraitUrl", advertiserInfo.portraitUrl);
        com.kwad.sdk.utils.t.a(jSONObject, "adAuthorText", advertiserInfo.adAuthorText);
        com.kwad.sdk.utils.t.a(jSONObject, "authorIconGuide", advertiserInfo.authorIconGuide);
        com.kwad.sdk.utils.t.a(jSONObject, "followed", advertiserInfo.followed);
        com.kwad.sdk.utils.t.a(jSONObject, "fansCount", advertiserInfo.fansCount);
        com.kwad.sdk.utils.t.a(jSONObject, DBTableDefine.GroupInfoColumns.COLUMN_BRIEF, advertiserInfo.brief);
        return jSONObject;
    }
}
