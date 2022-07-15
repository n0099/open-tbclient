package com.repackage;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class hr3 extends ms3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755638680, "Lcom/repackage/hr3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755638680, "Lcom/repackage/hr3;");
                return;
            }
        }
        boolean z = rg1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public hr3() {
        super("getDownloadConfig");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // com.repackage.ms3
    public hs1 a(JSONObject jSONObject, ld2 ld2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, jSONObject, ld2Var)) == null) {
            if (jSONObject == null) {
                ld2Var.onFail(202, "params may be error");
                return null;
            }
            if (jSONObject.has("wifiResumeDownloadFlag")) {
                qr3.a().c(jSONObject.optBoolean("wifiResumeDownloadFlag", false));
            }
            if (jSONObject.has("install_guide_switch")) {
                vr3.r(jSONObject.optBoolean("install_guide_switch"));
            }
            if (jSONObject.has("install_guide_count")) {
                vr3.q(jSONObject.optInt("install_guide_count"));
            }
            if (jSONObject.has("get_install_result")) {
                vr3.s(jSONObject.optBoolean("get_install_result"));
            }
            ld2Var.a(null);
            return null;
        }
        return (hs1) invokeLL.objValue;
    }
}
