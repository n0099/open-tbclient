package com.kwad.sdk.core.b.kwai;

import com.baidu.android.imsdk.db.DBTableDefine;
import com.baidu.tbadk.core.util.TbEnum;
import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class ae implements com.kwad.sdk.core.d<AdInfo.AdvertiserInfo> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(AdInfo.AdvertiserInfo advertiserInfo, JSONObject jSONObject) {
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

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(AdInfo.AdvertiserInfo advertiserInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.r.a(jSONObject, "userId", advertiserInfo.userId);
        com.kwad.sdk.utils.r.a(jSONObject, TbEnum.SystemMessage.KEY_USER_NAME, advertiserInfo.userName);
        com.kwad.sdk.utils.r.a(jSONObject, "rawUserName", advertiserInfo.rawUserName);
        com.kwad.sdk.utils.r.a(jSONObject, "userGender", advertiserInfo.userGender);
        com.kwad.sdk.utils.r.a(jSONObject, "portraitUrl", advertiserInfo.portraitUrl);
        com.kwad.sdk.utils.r.a(jSONObject, "adAuthorText", advertiserInfo.adAuthorText);
        com.kwad.sdk.utils.r.a(jSONObject, "authorIconGuide", advertiserInfo.authorIconGuide);
        com.kwad.sdk.utils.r.a(jSONObject, "followed", advertiserInfo.followed);
        com.kwad.sdk.utils.r.a(jSONObject, "fansCount", advertiserInfo.fansCount);
        com.kwad.sdk.utils.r.a(jSONObject, DBTableDefine.GroupInfoColumns.COLUMN_BRIEF, advertiserInfo.brief);
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdInfo.AdvertiserInfo advertiserInfo, JSONObject jSONObject) {
        a2(advertiserInfo, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdInfo.AdvertiserInfo advertiserInfo, JSONObject jSONObject) {
        return b2(advertiserInfo, jSONObject);
    }
}
