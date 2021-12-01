package com.kwad.sdk.core.b.kwai;

import com.baidu.android.imsdk.db.DBTableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class x implements com.kwad.sdk.core.d<AdInfo.AdvertiserInfo> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public x() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public void a(AdInfo.AdvertiserInfo advertiserInfo, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, advertiserInfo, jSONObject) == null) || jSONObject == null) {
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
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, advertiserInfo, jSONObject)) == null) {
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
        return (JSONObject) invokeLL.objValue;
    }
}
