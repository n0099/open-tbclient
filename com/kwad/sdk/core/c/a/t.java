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
import com.vivo.push.PushClientConstants;
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
        bVar.f65382a = jSONObject.optString("appName");
        bVar.f65383b = jSONObject.optString(PushClientConstants.TAG_PKG_NAME);
        bVar.f65384c = jSONObject.optString("version");
        bVar.f65385d = jSONObject.optInt(PushManager.APP_VERSION_CODE);
        bVar.f65386e = jSONObject.optLong("appSize");
        bVar.f65387f = jSONObject.optString(PackageTable.MD5);
        bVar.f65388g = jSONObject.optString("url");
        bVar.f65389h = jSONObject.optString("icon");
        bVar.f65390i = jSONObject.optString("desc");
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
            com.kwad.sdk.utils.q.a(jSONObject, "appName", bVar.f65382a);
            com.kwad.sdk.utils.q.a(jSONObject, PushClientConstants.TAG_PKG_NAME, bVar.f65383b);
            com.kwad.sdk.utils.q.a(jSONObject, "version", bVar.f65384c);
            com.kwad.sdk.utils.q.a(jSONObject, PushManager.APP_VERSION_CODE, bVar.f65385d);
            com.kwad.sdk.utils.q.a(jSONObject, "appSize", bVar.f65386e);
            com.kwad.sdk.utils.q.a(jSONObject, PackageTable.MD5, bVar.f65387f);
            com.kwad.sdk.utils.q.a(jSONObject, "url", bVar.f65388g);
            com.kwad.sdk.utils.q.a(jSONObject, "icon", bVar.f65389h);
            com.kwad.sdk.utils.q.a(jSONObject, "desc", bVar.f65390i);
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }
}
