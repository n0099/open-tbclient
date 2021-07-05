package com.kwad.sdk.core.g.a;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.export.proxy.AdRequestExtentParamsProxy;
import com.kwad.sdk.utils.o;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class m implements com.kwad.sdk.core.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f36163a;

    public m() {
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

    public static m a() {
        InterceptResult invokeV;
        Map<String, String> extentParams;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            m mVar = new m();
            AdRequestExtentParamsProxy requestExtentParamsProxy = KsAdSDKImpl.get().getRequestExtentParamsProxy();
            if (requestExtentParamsProxy != null && (extentParams = requestExtentParamsProxy.getExtentParams()) != null) {
                mVar.f36163a = extentParams.get("user_id");
            }
            return mVar;
        }
        return (m) invokeV.objValue;
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            o.a(jSONObject, "user_id", this.f36163a);
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }
}
