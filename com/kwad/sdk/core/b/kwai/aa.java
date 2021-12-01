package com.kwad.sdk.core.b.kwai;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.heytap.mcssdk.PushManager;
import com.kwad.sdk.core.webview.jshandler.q;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class aa implements com.kwad.sdk.core.d<q.b> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public aa() {
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
    public void a(q.b bVar, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, jSONObject) == null) || jSONObject == null) {
            return;
        }
        bVar.a = jSONObject.optString("appName");
        if (jSONObject.opt("appName") == JSONObject.NULL) {
            bVar.a = "";
        }
        bVar.f58063b = jSONObject.optString("pkgName");
        if (jSONObject.opt("pkgName") == JSONObject.NULL) {
            bVar.f58063b = "";
        }
        bVar.f58064c = jSONObject.optString("version");
        if (jSONObject.opt("version") == JSONObject.NULL) {
            bVar.f58064c = "";
        }
        bVar.f58065d = jSONObject.optInt(PushManager.APP_VERSION_CODE);
        bVar.f58066e = jSONObject.optLong("appSize");
        bVar.f58067f = jSONObject.optString(PackageTable.MD5);
        if (jSONObject.opt(PackageTable.MD5) == JSONObject.NULL) {
            bVar.f58067f = "";
        }
        bVar.f58068g = jSONObject.optString("url");
        if (jSONObject.opt("url") == JSONObject.NULL) {
            bVar.f58068g = "";
        }
        bVar.f58069h = jSONObject.optString("icon");
        if (jSONObject.opt("icon") == JSONObject.NULL) {
            bVar.f58069h = "";
        }
        bVar.f58070i = jSONObject.optString("desc");
        if (jSONObject.opt("desc") == JSONObject.NULL) {
            bVar.f58070i = "";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(q.b bVar, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, bVar, jSONObject)) == null) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            com.kwad.sdk.utils.t.a(jSONObject, "appName", bVar.a);
            com.kwad.sdk.utils.t.a(jSONObject, "pkgName", bVar.f58063b);
            com.kwad.sdk.utils.t.a(jSONObject, "version", bVar.f58064c);
            com.kwad.sdk.utils.t.a(jSONObject, PushManager.APP_VERSION_CODE, bVar.f58065d);
            com.kwad.sdk.utils.t.a(jSONObject, "appSize", bVar.f58066e);
            com.kwad.sdk.utils.t.a(jSONObject, PackageTable.MD5, bVar.f58067f);
            com.kwad.sdk.utils.t.a(jSONObject, "url", bVar.f58068g);
            com.kwad.sdk.utils.t.a(jSONObject, "icon", bVar.f58069h);
            com.kwad.sdk.utils.t.a(jSONObject, "desc", bVar.f58070i);
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }
}
