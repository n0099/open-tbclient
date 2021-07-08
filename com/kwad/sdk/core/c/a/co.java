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
/* loaded from: classes6.dex */
public class co implements com.kwad.sdk.core.d<g.a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public co() {
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
    public void a(g.a aVar, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, jSONObject) == null) || jSONObject == null) {
            return;
        }
        aVar.f35193a = jSONObject.optInt("type");
        aVar.f35194b = jSONObject.optString("appName");
        aVar.f35195c = jSONObject.optString(PushClientConstants.TAG_PKG_NAME);
        aVar.f35196d = jSONObject.optString("version");
        aVar.f35197e = jSONObject.optInt(PushManager.APP_VERSION_CODE);
        aVar.f35198f = jSONObject.optInt("appSize");
        aVar.f35199g = jSONObject.optString(PackageTable.MD5);
        aVar.f35200h = jSONObject.optString("url");
        aVar.f35201i = jSONObject.optString("appLink");
        aVar.j = jSONObject.optString("icon");
        aVar.k = jSONObject.optString("desc");
        aVar.l = jSONObject.optString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID);
        aVar.m = jSONObject.optString("marketUri");
        aVar.n = jSONObject.optBoolean("disableLandingPageDeepLink");
        aVar.o = jSONObject.optBoolean("isLandscapeSupported");
        aVar.p = jSONObject.optBoolean("isFromLive");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(g.a aVar, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, aVar, jSONObject)) == null) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            com.kwad.sdk.utils.q.a(jSONObject, "type", aVar.f35193a);
            com.kwad.sdk.utils.q.a(jSONObject, "appName", aVar.f35194b);
            com.kwad.sdk.utils.q.a(jSONObject, PushClientConstants.TAG_PKG_NAME, aVar.f35195c);
            com.kwad.sdk.utils.q.a(jSONObject, "version", aVar.f35196d);
            com.kwad.sdk.utils.q.a(jSONObject, PushManager.APP_VERSION_CODE, aVar.f35197e);
            com.kwad.sdk.utils.q.a(jSONObject, "appSize", aVar.f35198f);
            com.kwad.sdk.utils.q.a(jSONObject, PackageTable.MD5, aVar.f35199g);
            com.kwad.sdk.utils.q.a(jSONObject, "url", aVar.f35200h);
            com.kwad.sdk.utils.q.a(jSONObject, "appLink", aVar.f35201i);
            com.kwad.sdk.utils.q.a(jSONObject, "icon", aVar.j);
            com.kwad.sdk.utils.q.a(jSONObject, "desc", aVar.k);
            com.kwad.sdk.utils.q.a(jSONObject, BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, aVar.l);
            com.kwad.sdk.utils.q.a(jSONObject, "marketUri", aVar.m);
            com.kwad.sdk.utils.q.a(jSONObject, "disableLandingPageDeepLink", aVar.n);
            com.kwad.sdk.utils.q.a(jSONObject, "isLandscapeSupported", aVar.o);
            com.kwad.sdk.utils.q.a(jSONObject, "isFromLive", aVar.p);
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }
}
