package com.repackage;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.pms.constants.PmsConstant;
import com.baidu.swan.apps.core.slave.SwanAppSlaveManager;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.v8.NodeJS;
import com.repackage.ek2;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class sq1 extends gq1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ JSONObject a;
        public final /* synthetic */ hz2 b;

        public a(JSONObject jSONObject, hz2 hz2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jSONObject, hz2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jSONObject;
            this.b = hz2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                sq1.y(this.a, this.b);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ HybridUbcFlow b;
        public final /* synthetic */ nl1 c;

        public b(String str, HybridUbcFlow hybridUbcFlow, nl1 nl1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, hybridUbcFlow, nl1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.b = hybridUbcFlow;
            this.c = nl1Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (TextUtils.equals(this.a, "1")) {
                    this.b.S();
                } else {
                    this.b.C(this.c);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public sq1(@NonNull in1 in1Var) {
        super(in1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {in1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((in1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x005b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void A(HybridUbcFlow hybridUbcFlow, hz2 hz2Var, String str, @Nullable nl1 nl1Var) {
        long j;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(65537, null, hybridUbcFlow, hz2Var, str, nl1Var) == null) || hybridUbcFlow == null || hz2Var == null) {
            return;
        }
        if (!b62.U().p0()) {
            if (TextUtils.equals(str, "1")) {
                hybridUbcFlow.S();
                return;
            } else {
                hybridUbcFlow.C(nl1Var);
                return;
            }
        }
        long I = oi2.g0().I();
        if (I <= 0) {
            return;
        }
        ek2.a X = hz2Var.X();
        boolean z = false;
        if (X != null) {
            long currentTimeMillis = System.currentTimeMillis() - X.N();
            if (currentTimeMillis < I) {
                j = I - currentTimeMillis;
                if (z) {
                    if (j <= 0) {
                        return;
                    }
                    bc3.c(new b(str, hybridUbcFlow, nl1Var), "waitFcp", j, TimeUnit.MILLISECONDS);
                    return;
                } else if (TextUtils.equals(str, "1")) {
                    hybridUbcFlow.S();
                    return;
                } else {
                    hybridUbcFlow.C(nl1Var);
                    return;
                }
            }
            z = true;
        }
        j = 0;
        if (z) {
        }
    }

    public static void B(JSONObject jSONObject, hz2 hz2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, jSONObject, hz2Var) == null) {
            ExecutorUtilsExt.postOnElastic(new a(jSONObject, hz2Var), "handlePerformMsg", 2);
        }
    }

    public static void C(JSONObject jSONObject) {
        JSONArray optJSONArray;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, null, jSONObject) == null) || (optJSONArray = jSONObject.optJSONArray("data")) == null || optJSONArray.length() < 1) {
            return;
        }
        os2.e().c(optJSONArray.optJSONObject(0));
    }

    public static void D(JSONObject jSONObject) {
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONObject) == null) || jSONObject == null || (optJSONObject = jSONObject.optJSONObject("ext")) == null) {
            return;
        }
        String optString = optJSONObject.optString("routeId");
        if (TextUtils.isEmpty(optString)) {
            return;
        }
        HybridUbcFlow q = ms2.q("route", optString);
        if (TextUtils.equals(optJSONObject.optString("hasWebView"), "1")) {
            q.I(HybridUbcFlow.SubmitStrategy.ROUTE_WEB);
        }
        q.G(H(jSONObject.optJSONArray("data")));
        q.n();
        pl1 A = uk2.U().A(optJSONObject.optString("slaveId"));
        if (A instanceof SwanAppSlaveManager) {
            ((SwanAppSlaveManager) A).m1();
        }
    }

    public static void E(@Nullable JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, jSONArray) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("FlowJarAction-671: ");
            sb.append(jSONArray == null ? StringUtil.NULL_STRING : jSONArray);
            hw1.k("UbcFlowJarApi", sb.toString());
            if (jSONArray == null || jSONArray.length() == 0) {
                return;
            }
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                try {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    if (TextUtils.equals(jSONObject.optString("type"), "feTraceError")) {
                        h53.d().h(jSONObject);
                    } else {
                        h53.d().k(jSONObject);
                    }
                } catch (JSONException unused) {
                }
            }
        }
    }

    public static void F(JSONArray jSONArray) {
        py1 H;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65542, null, jSONArray) == null) || (H = uk2.U().H()) == null) {
            return;
        }
        try {
            JSONObject jSONObject = jSONArray.getJSONObject(0);
            if (jSONObject != null) {
                String string = jSONObject.getString(TbEnum.SystemMessage.KEY_EVENT_ID);
                String optString = jSONObject.optString(PmsConstant.Statistic.Key.REV_TIMESTAMP);
                long j = 0;
                if (!TextUtils.isEmpty(optString)) {
                    try {
                        j = Long.valueOf(optString).longValue();
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                }
                H.K3(new l63(string, j));
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public static UbcFlowEvent G(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            String optString = jSONObject.optString("actionId");
            long optLong = jSONObject.optLong("timestamp");
            if (TextUtils.isEmpty(optString)) {
                return null;
            }
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent(optString);
            ubcFlowEvent.h(optLong);
            return ubcFlowEvent;
        }
        return (UbcFlowEvent) invokeL.objValue;
    }

    public static List<UbcFlowEvent> H(JSONArray jSONArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, jSONArray)) == null) {
            ArrayList arrayList = new ArrayList();
            if (jSONArray == null) {
                return arrayList;
            }
            for (int i = 0; i < jSONArray.length(); i++) {
                UbcFlowEvent G = G(jSONArray.optJSONObject(i));
                if (G != null) {
                    G.e("FE");
                    arrayList.add(G);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static void y(JSONObject jSONObject, hz2 hz2Var) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, jSONObject, hz2Var) == null) {
            d12 W = b62.U().W();
            int j = W instanceof h12 ? ((h12) W).j() : 0;
            r53.C(true);
            r53.r();
            HybridUbcFlow p = ms2.p(NodeJS.STARTUP_SCRIPT_NAME);
            JSONObject optJSONObject = jSONObject.optJSONObject("ext");
            nl1 nl1Var = null;
            String str2 = "0";
            if (optJSONObject != null) {
                str2 = optJSONObject.optString("hasWebView", "0");
                str = optJSONObject.optString("hasRelaunch");
                pl1 A = uk2.U().A(optJSONObject.optString("slaveId"));
                if (A instanceof nl1) {
                    nl1Var = (nl1) A;
                }
            } else {
                str = "";
            }
            if (TextUtils.equals(str2, "1")) {
                HybridUbcFlow.SubmitStrategy i = p.i();
                if (i == HybridUbcFlow.SubmitStrategy.HYBRID) {
                    p.I(HybridUbcFlow.SubmitStrategy.HYBRID_WEB);
                } else if (i == HybridUbcFlow.SubmitStrategy.RELAUNCH) {
                    p.I(HybridUbcFlow.SubmitStrategy.RELAUNCH_WEB);
                }
            }
            if (TextUtils.equals(str, "none")) {
                if (TextUtils.equals(str2, "1")) {
                    p.S();
                } else {
                    p.C(nl1Var);
                }
            }
            A(p, hz2Var, str2, nl1Var);
            JSONArray optJSONArray = jSONObject.optJSONArray("data");
            p.D("codecache", String.valueOf(j));
            p.D("slave_codecache", String.valueOf(z()));
            p.G(H(optJSONArray));
            p.n();
        }
    }

    public static int z() {
        InterceptResult invokeV;
        py1 o;
        nl1 n3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            qy1 V = uk2.U().V();
            if (V == null || (o = V.o()) == null || (n3 = o.n3()) == null) {
                return 0;
            }
            return n3.j0();
        }
        return invokeV.intValue;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0089, code lost:
        if (r2.equals("670") != false) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public hr1 I(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            char c = 0;
            q("#ubcFlowJar", false);
            hz2 a0 = hz2.a0();
            if (a0 == null) {
                return new hr1(1001, "swan app is null");
            }
            Pair<hr1, JSONObject> s = s(str);
            hr1 hr1Var = (hr1) s.first;
            if (hr1Var.isSuccess()) {
                JSONObject jSONObject = (JSONObject) s.second;
                String optString = jSONObject.optString("flowId");
                if (TextUtils.isEmpty(optString)) {
                    return new hr1(201, "empty flowId");
                }
                switch (optString.hashCode()) {
                    case 53647:
                        break;
                    case 53648:
                        if (optString.equals("671")) {
                            c = 3;
                            break;
                        }
                        c = 65535;
                        break;
                    case 55357:
                        if (optString.equals("805")) {
                            c = 1;
                            break;
                        }
                        c = 65535;
                        break;
                    case 56506:
                        if (optString.equals("967")) {
                            c = 4;
                            break;
                        }
                        c = 65535;
                        break;
                    case 46733230:
                        if (optString.equals("10360")) {
                            c = 2;
                            break;
                        }
                        c = 65535;
                        break;
                    case 1529139648:
                        if (optString.equals("renderMonitorLog")) {
                            c = 5;
                            break;
                        }
                        c = 65535;
                        break;
                    default:
                        c = 65535;
                        break;
                }
                if (c == 0) {
                    B(jSONObject, a0);
                } else if (c == 1) {
                    F(jSONObject.optJSONArray("data"));
                } else if (c == 2) {
                    cf3.a().g(jSONObject.optJSONArray("data"));
                } else if (c == 3) {
                    E(jSONObject.optJSONArray("data"));
                } else if (c == 4) {
                    D(jSONObject);
                } else if (c != 5) {
                    return new hr1(201, "unknown flowId");
                } else {
                    C(jSONObject);
                }
                return hr1.f();
            }
            return hr1Var;
        }
        return (hr1) invokeL.objValue;
    }

    @Override // com.repackage.kn1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "UbcFlowJarApi" : (String) invokeV.objValue;
    }
}
