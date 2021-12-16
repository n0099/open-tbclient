package com.kwad.sdk.core.b.kwai;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ck implements com.kwad.sdk.core.d<com.kwad.sdk.c.kwai.b> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ck() {
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
    public void a(com.kwad.sdk.c.kwai.b bVar, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, bVar, jSONObject) == null) || jSONObject == null) {
            return;
        }
        bVar.a = jSONObject.optInt("Status");
        bVar.f57648b = jSONObject.optString("Content-Encoding");
        if (jSONObject.opt("Content-Encoding") == JSONObject.NULL) {
            bVar.f57648b = "";
        }
        bVar.f57649c = jSONObject.optString("Cache-Control");
        if (jSONObject.opt("Cache-Control") == JSONObject.NULL) {
            bVar.f57649c = "";
        }
        bVar.f57650d = jSONObject.optString("Content-Type");
        if (jSONObject.opt("Content-Type") == JSONObject.NULL) {
            bVar.f57650d = "";
        }
        com.kwad.sdk.c.kwai.a aVar = new com.kwad.sdk.c.kwai.a();
        bVar.f57651e = aVar;
        aVar.parseJson(jSONObject.optJSONObject("headers"));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(com.kwad.sdk.c.kwai.b bVar, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, bVar, jSONObject)) == null) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            com.kwad.sdk.utils.t.a(jSONObject, "Status", bVar.a);
            com.kwad.sdk.utils.t.a(jSONObject, "Content-Encoding", bVar.f57648b);
            com.kwad.sdk.utils.t.a(jSONObject, "Cache-Control", bVar.f57649c);
            com.kwad.sdk.utils.t.a(jSONObject, "Content-Type", bVar.f57650d);
            com.kwad.sdk.utils.t.a(jSONObject, "headers", bVar.f57651e);
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }
}
