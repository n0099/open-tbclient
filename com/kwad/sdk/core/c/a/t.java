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
/* loaded from: classes10.dex */
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
        bVar.f72899a = jSONObject.optString("appName");
        bVar.f72900b = jSONObject.optString(PushClientConstants.TAG_PKG_NAME);
        bVar.f72901c = jSONObject.optString("version");
        bVar.f72902d = jSONObject.optInt(PushManager.APP_VERSION_CODE);
        bVar.f72903e = jSONObject.optLong("appSize");
        bVar.f72904f = jSONObject.optString(PackageTable.MD5);
        bVar.f72905g = jSONObject.optString("url");
        bVar.f72906h = jSONObject.optString("icon");
        bVar.f72907i = jSONObject.optString("desc");
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
            com.kwad.sdk.utils.q.a(jSONObject, "appName", bVar.f72899a);
            com.kwad.sdk.utils.q.a(jSONObject, PushClientConstants.TAG_PKG_NAME, bVar.f72900b);
            com.kwad.sdk.utils.q.a(jSONObject, "version", bVar.f72901c);
            com.kwad.sdk.utils.q.a(jSONObject, PushManager.APP_VERSION_CODE, bVar.f72902d);
            com.kwad.sdk.utils.q.a(jSONObject, "appSize", bVar.f72903e);
            com.kwad.sdk.utils.q.a(jSONObject, PackageTable.MD5, bVar.f72904f);
            com.kwad.sdk.utils.q.a(jSONObject, "url", bVar.f72905g);
            com.kwad.sdk.utils.q.a(jSONObject, "icon", bVar.f72906h);
            com.kwad.sdk.utils.q.a(jSONObject, "desc", bVar.f72907i);
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }
}
