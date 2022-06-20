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
import com.repackage.pk2;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class dr1 extends rq1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ JSONObject a;
        public final /* synthetic */ sz2 b;

        public a(JSONObject jSONObject, sz2 sz2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jSONObject, sz2Var};
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
            this.b = sz2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                dr1.y(this.a, this.b);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ HybridUbcFlow b;
        public final /* synthetic */ yl1 c;

        public b(String str, HybridUbcFlow hybridUbcFlow, yl1 yl1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, hybridUbcFlow, yl1Var};
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
            this.c = yl1Var;
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
    public dr1(@NonNull tn1 tn1Var) {
        super(tn1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tn1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((tn1) newInitContext.callArgs[0]);
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
    public static void A(HybridUbcFlow hybridUbcFlow, sz2 sz2Var, String str, @Nullable yl1 yl1Var) {
        long j;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(65537, null, hybridUbcFlow, sz2Var, str, yl1Var) == null) || hybridUbcFlow == null || sz2Var == null) {
            return;
        }
        if (!m62.U().p0()) {
            if (TextUtils.equals(str, "1")) {
                hybridUbcFlow.S();
                return;
            } else {
                hybridUbcFlow.C(yl1Var);
                return;
            }
        }
        long I = zi2.g0().I();
        if (I <= 0) {
            return;
        }
        pk2.a Y = sz2Var.Y();
        boolean z = false;
        if (Y != null) {
            long currentTimeMillis = System.currentTimeMillis() - Y.N();
            if (currentTimeMillis < I) {
                j = I - currentTimeMillis;
                if (z) {
                    if (j <= 0) {
                        return;
                    }
                    mc3.c(new b(str, hybridUbcFlow, yl1Var), "waitFcp", j, TimeUnit.MILLISECONDS);
                    return;
                } else if (TextUtils.equals(str, "1")) {
                    hybridUbcFlow.S();
                    return;
                } else {
                    hybridUbcFlow.C(yl1Var);
                    return;
                }
            }
            z = true;
        }
        j = 0;
        if (z) {
        }
    }

    public static void B(JSONObject jSONObject, sz2 sz2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, jSONObject, sz2Var) == null) {
            ExecutorUtilsExt.postOnElastic(new a(jSONObject, sz2Var), "handlePerformMsg", 2);
        }
    }

    public static void C(JSONObject jSONObject) {
        JSONArray optJSONArray;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, null, jSONObject) == null) || (optJSONArray = jSONObject.optJSONArray("data")) == null || optJSONArray.length() < 1) {
            return;
        }
        zs2.e().c(optJSONArray.optJSONObject(0));
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
        HybridUbcFlow q = xs2.q("route", optString);
        if (TextUtils.equals(optJSONObject.optString("hasWebView"), "1")) {
            q.I(HybridUbcFlow.SubmitStrategy.ROUTE_WEB);
        }
        q.G(H(jSONObject.optJSONArray("data")));
        q.n();
        am1 A = fl2.U().A(optJSONObject.optString("slaveId"));
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
            sw1.k("UbcFlowJarApi", sb.toString());
            if (jSONArray == null || jSONArray.length() == 0) {
                return;
            }
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                try {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    if (TextUtils.equals(jSONObject.optString("type"), "feTraceError")) {
                        s53.d().h(jSONObject);
                    } else {
                        s53.d().k(jSONObject);
                    }
                } catch (JSONException unused) {
                }
            }
        }
    }

    public static void F(JSONArray jSONArray) {
        az1 H;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65542, null, jSONArray) == null) || (H = fl2.U().H()) == null) {
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
                H.L3(new w63(string, j));
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

    public static void y(JSONObject jSONObject, sz2 sz2Var) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, jSONObject, sz2Var) == null) {
            o12 W = m62.U().W();
            int j = W instanceof s12 ? ((s12) W).j() : 0;
            c63.C(true);
            c63.r();
            HybridUbcFlow p = xs2.p(NodeJS.STARTUP_SCRIPT_NAME);
            JSONObject optJSONObject = jSONObject.optJSONObject("ext");
            yl1 yl1Var = null;
            String str2 = "0";
            if (optJSONObject != null) {
                str2 = optJSONObject.optString("hasWebView", "0");
                str = optJSONObject.optString("hasRelaunch");
                am1 A = fl2.U().A(optJSONObject.optString("slaveId"));
                if (A instanceof yl1) {
                    yl1Var = (yl1) A;
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
                    p.C(yl1Var);
                }
            }
            A(p, sz2Var, str2, yl1Var);
            JSONArray optJSONArray = jSONObject.optJSONArray("data");
            p.D("codecache", String.valueOf(j));
            p.D("slave_codecache", String.valueOf(z()));
            p.G(H(optJSONArray));
            p.n();
        }
    }

    public static int z() {
        InterceptResult invokeV;
        az1 o;
        yl1 o3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            bz1 V = fl2.U().V();
            if (V == null || (o = V.o()) == null || (o3 = o.o3()) == null) {
                return 0;
            }
            return o3.i0();
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
    public sr1 I(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            char c = 0;
            q("#ubcFlowJar", false);
            sz2 b0 = sz2.b0();
            if (b0 == null) {
                return new sr1(1001, "swan app is null");
            }
            Pair<sr1, JSONObject> s = s(str);
            sr1 sr1Var = (sr1) s.first;
            if (sr1Var.isSuccess()) {
                JSONObject jSONObject = (JSONObject) s.second;
                String optString = jSONObject.optString("flowId");
                if (TextUtils.isEmpty(optString)) {
                    return new sr1(201, "empty flowId");
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
                    B(jSONObject, b0);
                } else if (c == 1) {
                    F(jSONObject.optJSONArray("data"));
                } else if (c == 2) {
                    nf3.a().g(jSONObject.optJSONArray("data"));
                } else if (c == 3) {
                    E(jSONObject.optJSONArray("data"));
                } else if (c == 4) {
                    D(jSONObject);
                } else if (c != 5) {
                    return new sr1(201, "unknown flowId");
                } else {
                    C(jSONObject);
                }
                return sr1.f();
            }
            return sr1Var;
        }
        return (sr1) invokeL.objValue;
    }

    @Override // com.repackage.vn1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "UbcFlowJarApi" : (String) invokeV.objValue;
    }
}
