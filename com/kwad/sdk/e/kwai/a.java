package com.kwad.sdk.e.kwai;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.wallet.paysdk.entrance.EnterDxmPayServiceAction;
import com.kuaishou.tachikoma.api.app.TKBaseResponse;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a implements com.kwad.sdk.e.e<TKBaseResponse> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public a() {
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
    @Override // com.kwad.sdk.e.e
    public void a(TKBaseResponse tKBaseResponse, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, tKBaseResponse, jSONObject) == null) || jSONObject == null) {
            return;
        }
        tKBaseResponse.body = jSONObject.optString("body");
        tKBaseResponse.statusCode = jSONObject.optInt(EnterDxmPayServiceAction.SERVICE_STATUS_CODE);
        tKBaseResponse.allHeaderFields = jSONObject.optString("allHeaderFields");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.e.e
    public JSONObject b(TKBaseResponse tKBaseResponse, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, tKBaseResponse, jSONObject)) == null) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            com.kwad.sdk.e.f.a(jSONObject, "body", tKBaseResponse.body);
            com.kwad.sdk.e.f.a(jSONObject, EnterDxmPayServiceAction.SERVICE_STATUS_CODE, tKBaseResponse.statusCode);
            com.kwad.sdk.e.f.a(jSONObject, "allHeaderFields", tKBaseResponse.allHeaderFields);
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }
}
