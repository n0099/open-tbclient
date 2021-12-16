package com.kwad.sdk.e.kwai;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.wallet.paysdk.entrance.EnterDxmPayServiceAction;
import com.tachikoma.core.component.network.delegate.TKBaseResponseInner;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b implements com.kwad.sdk.e.e<TKBaseResponseInner> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public b() {
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
    public void a(TKBaseResponseInner tKBaseResponseInner, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tKBaseResponseInner, jSONObject) == null) || jSONObject == null) {
            return;
        }
        tKBaseResponseInner.body = jSONObject.optString("body");
        tKBaseResponseInner.statusCode = jSONObject.optInt(EnterDxmPayServiceAction.SERVICE_STATUS_CODE);
        tKBaseResponseInner.allHeaderFields = jSONObject.optString("allHeaderFields");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.e.e
    public JSONObject b(TKBaseResponseInner tKBaseResponseInner, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, tKBaseResponseInner, jSONObject)) == null) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            com.kwad.sdk.e.f.a(jSONObject, "body", tKBaseResponseInner.body);
            com.kwad.sdk.e.f.a(jSONObject, EnterDxmPayServiceAction.SERVICE_STATUS_CODE, tKBaseResponseInner.statusCode);
            com.kwad.sdk.e.f.a(jSONObject, "allHeaderFields", tKBaseResponseInner.allHeaderFields);
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }
}
