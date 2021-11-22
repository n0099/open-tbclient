package com.kwad.sdk.core.c.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.heytap.mcssdk.PushManager;
import com.kwad.sdk.core.webview.jshandler.n;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class t implements com.kwad.sdk.core.d<n.b> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public t() {
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
    public void a(n.b bVar, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, jSONObject) == null) || jSONObject == null) {
            return;
        }
        bVar.f66294a = jSONObject.optString("appName");
        bVar.f66295b = jSONObject.optString("pkgName");
        bVar.f66296c = jSONObject.optString("version");
        bVar.f66297d = jSONObject.optInt(PushManager.APP_VERSION_CODE);
        bVar.f66298e = jSONObject.optLong("appSize");
        bVar.f66299f = jSONObject.optString(PackageTable.MD5);
        bVar.f66300g = jSONObject.optString("url");
        bVar.f66301h = jSONObject.optString("icon");
        bVar.f66302i = jSONObject.optString("desc");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(n.b bVar, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, bVar, jSONObject)) == null) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            com.kwad.sdk.utils.q.a(jSONObject, "appName", bVar.f66294a);
            com.kwad.sdk.utils.q.a(jSONObject, "pkgName", bVar.f66295b);
            com.kwad.sdk.utils.q.a(jSONObject, "version", bVar.f66296c);
            com.kwad.sdk.utils.q.a(jSONObject, PushManager.APP_VERSION_CODE, bVar.f66297d);
            com.kwad.sdk.utils.q.a(jSONObject, "appSize", bVar.f66298e);
            com.kwad.sdk.utils.q.a(jSONObject, PackageTable.MD5, bVar.f66299f);
            com.kwad.sdk.utils.q.a(jSONObject, "url", bVar.f66300g);
            com.kwad.sdk.utils.q.a(jSONObject, "icon", bVar.f66301h);
            com.kwad.sdk.utils.q.a(jSONObject, "desc", bVar.f66302i);
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }
}
