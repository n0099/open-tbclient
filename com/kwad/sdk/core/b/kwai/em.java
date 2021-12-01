package com.kwad.sdk.core.b.kwai;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.heytap.mcssdk.PushManager;
import com.kwad.sdk.core.webview.jshandler.h;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class em implements com.kwad.sdk.core.d<h.a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public em() {
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
    public void a(h.a aVar, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, jSONObject) == null) || jSONObject == null) {
            return;
        }
        aVar.a = jSONObject.optInt("type");
        aVar.f58013b = jSONObject.optString("appName");
        if (jSONObject.opt("appName") == JSONObject.NULL) {
            aVar.f58013b = "";
        }
        aVar.f58014c = jSONObject.optString("pkgName");
        if (jSONObject.opt("pkgName") == JSONObject.NULL) {
            aVar.f58014c = "";
        }
        aVar.f58015d = jSONObject.optString("version");
        if (jSONObject.opt("version") == JSONObject.NULL) {
            aVar.f58015d = "";
        }
        aVar.f58016e = jSONObject.optInt(PushManager.APP_VERSION_CODE);
        aVar.f58017f = jSONObject.optInt("appSize");
        aVar.f58018g = jSONObject.optString(PackageTable.MD5);
        if (jSONObject.opt(PackageTable.MD5) == JSONObject.NULL) {
            aVar.f58018g = "";
        }
        aVar.f58019h = jSONObject.optString("url");
        if (jSONObject.opt("url") == JSONObject.NULL) {
            aVar.f58019h = "";
        }
        aVar.f58020i = jSONObject.optString("appLink");
        if (jSONObject.opt("appLink") == JSONObject.NULL) {
            aVar.f58020i = "";
        }
        aVar.f58021j = jSONObject.optString("icon");
        if (jSONObject.opt("icon") == JSONObject.NULL) {
            aVar.f58021j = "";
        }
        aVar.f58022k = jSONObject.optString("desc");
        if (jSONObject.opt("desc") == JSONObject.NULL) {
            aVar.f58022k = "";
        }
        aVar.l = jSONObject.optString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID);
        if (jSONObject.opt(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID) == JSONObject.NULL) {
            aVar.l = "";
        }
        aVar.m = jSONObject.optString("marketUri");
        if (jSONObject.opt("marketUri") == JSONObject.NULL) {
            aVar.m = "";
        }
        aVar.n = jSONObject.optBoolean("disableLandingPageDeepLink");
        aVar.o = jSONObject.optBoolean("isLandscapeSupported");
        aVar.p = jSONObject.optBoolean("isFromLive");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(h.a aVar, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, aVar, jSONObject)) == null) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            com.kwad.sdk.utils.t.a(jSONObject, "type", aVar.a);
            com.kwad.sdk.utils.t.a(jSONObject, "appName", aVar.f58013b);
            com.kwad.sdk.utils.t.a(jSONObject, "pkgName", aVar.f58014c);
            com.kwad.sdk.utils.t.a(jSONObject, "version", aVar.f58015d);
            com.kwad.sdk.utils.t.a(jSONObject, PushManager.APP_VERSION_CODE, aVar.f58016e);
            com.kwad.sdk.utils.t.a(jSONObject, "appSize", aVar.f58017f);
            com.kwad.sdk.utils.t.a(jSONObject, PackageTable.MD5, aVar.f58018g);
            com.kwad.sdk.utils.t.a(jSONObject, "url", aVar.f58019h);
            com.kwad.sdk.utils.t.a(jSONObject, "appLink", aVar.f58020i);
            com.kwad.sdk.utils.t.a(jSONObject, "icon", aVar.f58021j);
            com.kwad.sdk.utils.t.a(jSONObject, "desc", aVar.f58022k);
            com.kwad.sdk.utils.t.a(jSONObject, BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, aVar.l);
            com.kwad.sdk.utils.t.a(jSONObject, "marketUri", aVar.m);
            com.kwad.sdk.utils.t.a(jSONObject, "disableLandingPageDeepLink", aVar.n);
            com.kwad.sdk.utils.t.a(jSONObject, "isLandscapeSupported", aVar.o);
            com.kwad.sdk.utils.t.a(jSONObject, "isFromLive", aVar.p);
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }
}
