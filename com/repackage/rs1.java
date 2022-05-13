package com.repackage;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.v8.NodeJS;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes7.dex */
public class rs1 implements qs1 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<String, cu2> a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755339871, "Lcom/repackage/rs1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755339871, "Lcom/repackage/rs1;");
                return;
            }
        }
        b = eh1.a;
    }

    public rs1() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new ConcurrentHashMap();
    }

    @Override // com.repackage.qs1
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || this.a.containsKey(str)) {
            return;
        }
        if (b) {
            Log.d("Api-FirstRecorder", "markStart: " + str);
        }
        cu2 cu2Var = new cu2();
        this.a.put(str, cu2Var);
        cu2Var.i(System.currentTimeMillis());
        cu2Var.f(str);
    }

    @Override // com.repackage.qs1
    @SuppressLint({"BDThrowableCheck"})
    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            cu2 cu2Var = this.a.get(str);
            if (cu2Var == null) {
                if (b) {
                    throw new RuntimeException(str + " markEnd before markStart");
                }
            } else if (cu2Var.d() > 0) {
            } else {
                cu2Var.h(System.currentTimeMillis());
                if (b) {
                    Log.d("Api-FirstRecorder", str + " first called cost " + cu2Var.c());
                }
                if (TextUtils.equals(str, "request")) {
                    if (b) {
                        Log.d("Api-FirstRecorder", "record first request api called " + cu2Var.toString());
                    }
                    HybridUbcFlow p = zt2.p(NodeJS.STARTUP_SCRIPT_NAME);
                    UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("first_request_api_call_start");
                    ubcFlowEvent.h(cu2Var.e());
                    p.F(ubcFlowEvent);
                    UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("first_request_api_call_end");
                    ubcFlowEvent2.h(cu2Var.d());
                    p.F(ubcFlowEvent2);
                }
            }
        }
    }
}
