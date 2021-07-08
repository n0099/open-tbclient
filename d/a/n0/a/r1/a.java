package d.a.n0.a.r1;

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
import d.a.n0.a.k;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a implements d.a.n0.a.v2.e1.b<HybridUbcFlow> {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f47054e;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(715740372, "Ld/a/n0/a/r1/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(715740372, "Ld/a/n0/a/r1/a;");
                return;
            }
        }
        f47054e = k.f45831a;
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
            if (hybridUbcFlow != null && !hybridUbcFlow.f11213f.isEmpty()) {
                jSONObject.put("flowId", hybridUbcFlow.j());
                JSONArray jSONArray = new JSONArray();
                for (UbcFlowEvent ubcFlowEvent : hybridUbcFlow.f11213f) {
                    if (!ubcFlowEvent.b() && !TextUtils.isEmpty(ubcFlowEvent.f11222a)) {
                        if (f47054e) {
                            Log.i("FlowJarToH5Reporter", "buildJoMsg: event=" + ubcFlowEvent);
                        }
                        jSONArray.put(new JSONObject().put("actionId", ubcFlowEvent.f11222a).put("timestamp", ubcFlowEvent.g()));
                    }
                }
                jSONObject.put("data", jSONArray);
            }
            if (f47054e) {
                Log.i("FlowJarToH5Reporter", "buildJoMsg: joMsg=" + jSONObject);
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.n0.a.v2.e1.b
    /* renamed from: b */
    public void onCallback(HybridUbcFlow hybridUbcFlow) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hybridUbcFlow) == null) {
            if (f47054e) {
                Log.i("FlowJarToH5Reporter", "report: flow=" + hybridUbcFlow);
            }
            if (d.a.n0.a.g1.f.V().Z()) {
                if (f47054e || d.a.n0.a.g1.f.V().O()) {
                    try {
                        j.e().c(a(hybridUbcFlow));
                    } catch (JSONException e2) {
                        if (f47054e) {
                            e2.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
