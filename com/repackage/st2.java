package com.repackage;

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
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class st2 implements nf3<HybridUbcFlow> {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755309088, "Lcom/repackage/st2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755309088, "Lcom/repackage/st2;");
                return;
            }
        }
        a = eh1.a;
    }

    public st2() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public final JSONObject a(HybridUbcFlow hybridUbcFlow) throws JSONException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, hybridUbcFlow)) == null) {
            JSONObject jSONObject = new JSONObject();
            if (hybridUbcFlow != null && !hybridUbcFlow.f.isEmpty()) {
                jSONObject.put("flowId", hybridUbcFlow.l());
                JSONArray jSONArray = new JSONArray();
                for (UbcFlowEvent ubcFlowEvent : hybridUbcFlow.f) {
                    if (!ubcFlowEvent.b() && !TextUtils.isEmpty(ubcFlowEvent.a)) {
                        if (a) {
                            Log.i("FlowJarToH5Reporter", "buildJoMsg: event=" + ubcFlowEvent);
                        }
                        jSONArray.put(new JSONObject().put("actionId", ubcFlowEvent.a).put("timestamp", ubcFlowEvent.g()));
                    }
                }
                jSONObject.put("data", jSONArray);
            }
            if (a) {
                Log.i("FlowJarToH5Reporter", "buildJoMsg: joMsg=" + jSONObject);
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.nf3
    /* renamed from: b */
    public void onCallback(HybridUbcFlow hybridUbcFlow) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hybridUbcFlow) == null) {
            if (a) {
                Log.i("FlowJarToH5Reporter", "report: flow=" + hybridUbcFlow);
            }
            if (hm2.U().Y()) {
                if (a || hm2.U().N()) {
                    try {
                        bu2.e().c(a(hybridUbcFlow));
                    } catch (JSONException e) {
                        if (a) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
