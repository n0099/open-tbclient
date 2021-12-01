package com.kwad.sdk.core.b.kwai;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class cq implements com.kwad.sdk.core.d<com.kwad.sdk.core.webview.kwai.i> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public cq() {
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
    public void a(com.kwad.sdk.core.webview.kwai.i iVar, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iVar, jSONObject) == null) || jSONObject == null) {
            return;
        }
        iVar.a = jSONObject.optString("url");
        if (jSONObject.opt("url") == JSONObject.NULL) {
            iVar.a = "";
        }
        iVar.f58113b = jSONObject.optString("title");
        if (jSONObject.opt("title") == JSONObject.NULL) {
            iVar.f58113b = "";
        }
        iVar.f58114c = jSONObject.optString("params");
        if (jSONObject.opt("params") == JSONObject.NULL) {
            iVar.f58114c = "";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(com.kwad.sdk.core.webview.kwai.i iVar, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, iVar, jSONObject)) == null) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            com.kwad.sdk.utils.t.a(jSONObject, "url", iVar.a);
            com.kwad.sdk.utils.t.a(jSONObject, "title", iVar.f58113b);
            com.kwad.sdk.utils.t.a(jSONObject, "params", iVar.f58114c);
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }
}
