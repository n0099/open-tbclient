package com.kwad.sdk.e.kwai;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tachikoma.core.component.imageview.TKCDNUrlInner;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d implements com.kwad.sdk.e.e<TKCDNUrlInner> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public d() {
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
    public void a(TKCDNUrlInner tKCDNUrlInner, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tKCDNUrlInner, jSONObject) == null) || jSONObject == null) {
            return;
        }
        tKCDNUrlInner.mCdn = jSONObject.optString("cdn");
        tKCDNUrlInner.mUrl = jSONObject.optString("url");
        tKCDNUrlInner.mUrlType = jSONObject.optString("urlType");
        tKCDNUrlInner.mIsFreeTrafficCdn = jSONObject.optBoolean("freeTrafficCdn");
        tKCDNUrlInner.mPushCdn = jSONObject.optString("pushCdn");
        tKCDNUrlInner.mIp = jSONObject.optString("ip");
        tKCDNUrlInner.mUrlPattern = jSONObject.optString("urlPattern");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.e.e
    public JSONObject b(TKCDNUrlInner tKCDNUrlInner, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, tKCDNUrlInner, jSONObject)) == null) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            com.kwad.sdk.e.f.a(jSONObject, "cdn", tKCDNUrlInner.mCdn);
            com.kwad.sdk.e.f.a(jSONObject, "url", tKCDNUrlInner.mUrl);
            com.kwad.sdk.e.f.a(jSONObject, "urlType", tKCDNUrlInner.mUrlType);
            com.kwad.sdk.e.f.a(jSONObject, "freeTrafficCdn", tKCDNUrlInner.mIsFreeTrafficCdn);
            com.kwad.sdk.e.f.a(jSONObject, "pushCdn", tKCDNUrlInner.mPushCdn);
            com.kwad.sdk.e.f.a(jSONObject, "ip", tKCDNUrlInner.mIp);
            com.kwad.sdk.e.f.a(jSONObject, "urlPattern", tKCDNUrlInner.mUrlPattern);
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }
}
