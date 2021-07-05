package com.kwad.sdk.core.c.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.heytap.mcssdk.PushManager;
import com.kwad.sdk.core.webview.jshandler.l;
import com.vivo.push.PushClientConstants;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class i implements com.kwad.sdk.core.c<l.b> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public i() {
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
    public JSONObject a(l.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar)) == null) {
            JSONObject jSONObject = new JSONObject();
            com.kwad.sdk.utils.o.a(jSONObject, "appName", bVar.f36889a);
            com.kwad.sdk.utils.o.a(jSONObject, PushClientConstants.TAG_PKG_NAME, bVar.f36890b);
            com.kwad.sdk.utils.o.a(jSONObject, "version", bVar.f36891c);
            com.kwad.sdk.utils.o.a(jSONObject, PushManager.APP_VERSION_CODE, bVar.f36892d);
            com.kwad.sdk.utils.o.a(jSONObject, "appSize", bVar.f36893e);
            com.kwad.sdk.utils.o.a(jSONObject, PackageTable.MD5, bVar.f36894f);
            com.kwad.sdk.utils.o.a(jSONObject, "url", bVar.f36895g);
            com.kwad.sdk.utils.o.a(jSONObject, "icon", bVar.f36896h);
            com.kwad.sdk.utils.o.a(jSONObject, "desc", bVar.f36897i);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public void a(l.b bVar, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, bVar, jSONObject) == null) || jSONObject == null) {
            return;
        }
        bVar.f36889a = jSONObject.optString("appName");
        bVar.f36890b = jSONObject.optString(PushClientConstants.TAG_PKG_NAME);
        bVar.f36891c = jSONObject.optString("version");
        bVar.f36892d = jSONObject.optInt(PushManager.APP_VERSION_CODE);
        bVar.f36893e = jSONObject.optLong("appSize");
        bVar.f36894f = jSONObject.optString(PackageTable.MD5);
        bVar.f36895g = jSONObject.optString("url");
        bVar.f36896h = jSONObject.optString("icon");
        bVar.f36897i = jSONObject.optString("desc");
    }
}
