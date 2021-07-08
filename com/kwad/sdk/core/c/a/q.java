package com.kwad.sdk.core.c.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class q implements com.kwad.sdk.core.d<AdInfo.AdvertiserInfo> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public q() {
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
        advertiserInfo.rawUserName = jSONObject.optString("rawUserName");
        advertiserInfo.userGender = jSONObject.optString("userGender");
        advertiserInfo.portraitUrl = jSONObject.optString("portraitUrl");
        advertiserInfo.adAuthorText = jSONObject.optString("adAuthorText");
        advertiserInfo.authorIconGuide = jSONObject.optString("authorIconGuide");
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
            com.kwad.sdk.utils.q.a(jSONObject, "userId", advertiserInfo.userId);
            com.kwad.sdk.utils.q.a(jSONObject, TbEnum.SystemMessage.KEY_USER_NAME, advertiserInfo.userName);
            com.kwad.sdk.utils.q.a(jSONObject, "rawUserName", advertiserInfo.rawUserName);
            com.kwad.sdk.utils.q.a(jSONObject, "userGender", advertiserInfo.userGender);
            com.kwad.sdk.utils.q.a(jSONObject, "portraitUrl", advertiserInfo.portraitUrl);
            com.kwad.sdk.utils.q.a(jSONObject, "adAuthorText", advertiserInfo.adAuthorText);
            com.kwad.sdk.utils.q.a(jSONObject, "authorIconGuide", advertiserInfo.authorIconGuide);
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }
}
