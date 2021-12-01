package com.kwad.sdk.e.kwai;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kuaishou.tachikoma.api.model.TKCDNUrl;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c implements com.kwad.sdk.e.e<TKCDNUrl> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public c() {
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
    @Override // com.kwad.sdk.e.e
    public void a(TKCDNUrl tKCDNUrl, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, tKCDNUrl, jSONObject) == null) || jSONObject == null) {
            return;
        }
        tKCDNUrl.mCdn = jSONObject.optString("cdn");
        tKCDNUrl.mUrl = jSONObject.optString("url");
        tKCDNUrl.mUrlType = jSONObject.optString("urlType");
        tKCDNUrl.mIsFreeTrafficCdn = jSONObject.optBoolean("freeTrafficCdn");
        tKCDNUrl.mPushCdn = jSONObject.optString("pushCdn");
        tKCDNUrl.mIp = jSONObject.optString("ip");
        tKCDNUrl.mUrlPattern = jSONObject.optString("urlPattern");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.e.e
    public JSONObject b(TKCDNUrl tKCDNUrl, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, tKCDNUrl, jSONObject)) == null) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            com.kwad.sdk.e.f.a(jSONObject, "cdn", tKCDNUrl.mCdn);
            com.kwad.sdk.e.f.a(jSONObject, "url", tKCDNUrl.mUrl);
            com.kwad.sdk.e.f.a(jSONObject, "urlType", tKCDNUrl.mUrlType);
            com.kwad.sdk.e.f.a(jSONObject, "freeTrafficCdn", tKCDNUrl.mIsFreeTrafficCdn);
            com.kwad.sdk.e.f.a(jSONObject, "pushCdn", tKCDNUrl.mPushCdn);
            com.kwad.sdk.e.f.a(jSONObject, "ip", tKCDNUrl.mIp);
            com.kwad.sdk.e.f.a(jSONObject, "urlPattern", tKCDNUrl.mUrlPattern);
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }
}
