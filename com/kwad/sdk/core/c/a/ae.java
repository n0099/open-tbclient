package com.kwad.sdk.core.c.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.heytap.mcssdk.PushManager;
import com.kwad.sdk.core.webview.jshandler.g;
import com.vivo.push.PushClientConstants;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class ae implements com.kwad.sdk.core.c<g.a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ae() {
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
    @Override // com.kwad.sdk.core.c
    public JSONObject a(g.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar)) == null) {
            JSONObject jSONObject = new JSONObject();
            com.kwad.sdk.utils.o.a(jSONObject, "type", aVar.f36848a);
            com.kwad.sdk.utils.o.a(jSONObject, "appName", aVar.f36849b);
            com.kwad.sdk.utils.o.a(jSONObject, PushClientConstants.TAG_PKG_NAME, aVar.f36850c);
            com.kwad.sdk.utils.o.a(jSONObject, "version", aVar.f36851d);
            com.kwad.sdk.utils.o.a(jSONObject, PushManager.APP_VERSION_CODE, aVar.f36852e);
            com.kwad.sdk.utils.o.a(jSONObject, "appSize", aVar.f36853f);
            com.kwad.sdk.utils.o.a(jSONObject, PackageTable.MD5, aVar.f36854g);
            com.kwad.sdk.utils.o.a(jSONObject, "url", aVar.f36855h);
            com.kwad.sdk.utils.o.a(jSONObject, "appLink", aVar.f36856i);
            com.kwad.sdk.utils.o.a(jSONObject, "icon", aVar.j);
            com.kwad.sdk.utils.o.a(jSONObject, "desc", aVar.k);
            com.kwad.sdk.utils.o.a(jSONObject, BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, aVar.l);
            com.kwad.sdk.utils.o.a(jSONObject, "marketUri", aVar.m);
            com.kwad.sdk.utils.o.a(jSONObject, "disableLandingPageDeepLink", aVar.n);
            com.kwad.sdk.utils.o.a(jSONObject, "isLandscapeSupported", aVar.o);
            com.kwad.sdk.utils.o.a(jSONObject, "isFromLive", aVar.p);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public void a(g.a aVar, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, aVar, jSONObject) == null) || jSONObject == null) {
            return;
        }
        aVar.f36848a = jSONObject.optInt("type");
        aVar.f36849b = jSONObject.optString("appName");
        aVar.f36850c = jSONObject.optString(PushClientConstants.TAG_PKG_NAME);
        aVar.f36851d = jSONObject.optString("version");
        aVar.f36852e = jSONObject.optInt(PushManager.APP_VERSION_CODE);
        aVar.f36853f = jSONObject.optInt("appSize");
        aVar.f36854g = jSONObject.optString(PackageTable.MD5);
        aVar.f36855h = jSONObject.optString("url");
        aVar.f36856i = jSONObject.optString("appLink");
        aVar.j = jSONObject.optString("icon");
        aVar.k = jSONObject.optString("desc");
        aVar.l = jSONObject.optString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID);
        aVar.m = jSONObject.optString("marketUri");
        aVar.n = jSONObject.optBoolean("disableLandingPageDeepLink");
        aVar.o = jSONObject.optBoolean("isLandscapeSupported");
        aVar.p = jSONObject.optBoolean("isFromLive");
    }
}
