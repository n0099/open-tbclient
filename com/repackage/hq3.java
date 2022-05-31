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
public class hq3 extends mr3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755639641, "Lcom/repackage/hq3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755639641, "Lcom/repackage/hq3;");
                return;
            }
        }
        boolean z = rf1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public hq3() {
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

    @Override // com.repackage.mr3
    public hr1 a(JSONObject jSONObject, lc2 lc2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, jSONObject, lc2Var)) == null) {
            if (jSONObject == null) {
                lc2Var.onFail(202, "params may be error");
                return null;
            }
            if (jSONObject.has("wifiResumeDownloadFlag")) {
                qq3.a().c(jSONObject.optBoolean("wifiResumeDownloadFlag", false));
            }
            if (jSONObject.has("install_guide_switch")) {
                vq3.r(jSONObject.optBoolean("install_guide_switch"));
            }
            if (jSONObject.has("install_guide_count")) {
                vq3.q(jSONObject.optInt("install_guide_count"));
            }
            if (jSONObject.has("get_install_result")) {
                vq3.s(jSONObject.optBoolean("get_install_result"));
            }
            lc2Var.a(null);
            return null;
        }
        return (hr1) invokeLL.objValue;
    }
}
