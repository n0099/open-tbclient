package d.a.o0.a.u.e.p;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.mobads.container.util.AdIconUtil;
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
import d.a.o0.a.f1.e.b;
import d.a.o0.a.r1.j;
import d.a.o0.a.v2.q;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class h extends d.a.o0.a.u.c.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JSONObject f48337e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.a.a2.e f48338f;

        public a(JSONObject jSONObject, d.a.o0.a.a2.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jSONObject, eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48337e = jSONObject;
            this.f48338f = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (d.a.o0.a.u.c.d.f47942c) {
                    Log.d("Api-UbcFlowJar", "handlePerformMsg in thread pool");
                }
                h.s(this.f48337e, this.f48338f);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f48339e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ HybridUbcFlow f48340f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.a.p.e.b f48341g;

        public b(String str, HybridUbcFlow hybridUbcFlow, d.a.o0.a.p.e.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, hybridUbcFlow, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48339e = str;
            this.f48340f = hybridUbcFlow;
            this.f48341g = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (TextUtils.equals(this.f48339e, "1")) {
                    this.f48340f.P();
                } else {
                    this.f48340f.z(this.f48341g);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(@NonNull d.a.o0.a.u.c.b bVar) {
        super(bVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((d.a.o0.a.u.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static List<UbcFlowEvent> A(JSONArray jSONArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONArray)) == null) {
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                UbcFlowEvent z = z(jSONArray.optJSONObject(i2));
                if (z != null) {
                    z.e("FE");
                    arrayList.add(z);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static void s(JSONObject jSONObject, d.a.o0.a.a2.e eVar) {
        int i2;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, jSONObject, eVar) == null) {
            d.a.o0.a.h0.l.a P = d.a.o0.a.h0.u.g.N().P();
            if (P instanceof d.a.o0.a.h0.l.e) {
                i2 = ((d.a.o0.a.h0.l.e) P).k();
                if (d.a.o0.a.u.c.d.f47942c) {
                    Log.d("Api-UbcFlowJar", "ID_PERFORMANCED_FLOW CodeCache status: " + i2);
                }
            } else {
                i2 = 0;
            }
            d.a.o0.a.j2.e.C(true);
            d.a.o0.a.j2.e.r();
            HybridUbcFlow p = d.a.o0.a.r1.h.p("startup");
            JSONObject optJSONObject = jSONObject.optJSONObject("ext");
            d.a.o0.a.p.e.b bVar = null;
            String str2 = "0";
            if (optJSONObject != null) {
                str2 = optJSONObject.optString("hasWebView", "0");
                str = optJSONObject.optString("hasRelaunch");
                d.a.o0.a.p.e.d B = d.a.o0.a.g1.f.V().B(optJSONObject.optString("slaveId"));
                if (B instanceof d.a.o0.a.p.e.b) {
                    bVar = (d.a.o0.a.p.e.b) B;
                }
            } else {
                str = "";
            }
            if (TextUtils.equals(str2, "1")) {
                HybridUbcFlow.SubmitStrategy h2 = p.h();
                if (h2 == HybridUbcFlow.SubmitStrategy.HYBRID) {
                    p.F(HybridUbcFlow.SubmitStrategy.HYBRID_WEB);
                } else if (h2 == HybridUbcFlow.SubmitStrategy.RELAUNCH) {
                    p.F(HybridUbcFlow.SubmitStrategy.RELAUNCH_WEB);
                }
            }
            if (TextUtils.equals(str, "none")) {
                if (TextUtils.equals(str2, "1")) {
                    p.P();
                } else {
                    p.z(bVar);
                }
            }
            t(p, eVar, str2, bVar);
            JSONArray optJSONArray = jSONObject.optJSONArray("data");
            p.A("codecache", String.valueOf(i2));
            p.D(A(optJSONArray));
            p.l();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x005b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void t(HybridUbcFlow hybridUbcFlow, d.a.o0.a.a2.e eVar, String str, @Nullable d.a.o0.a.p.e.b bVar) {
        long j;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, hybridUbcFlow, eVar, str, bVar) == null) || hybridUbcFlow == null || eVar == null) {
            return;
        }
        if (!d.a.o0.a.h0.u.g.N().f0()) {
            if (TextUtils.equals(str, "1")) {
                hybridUbcFlow.P();
                return;
            } else {
                hybridUbcFlow.z(bVar);
                return;
            }
        }
        long K = d.a.o0.a.c1.a.Z().K();
        if (K <= 0) {
            return;
        }
        b.a N = eVar.N();
        boolean z = false;
        if (N != null) {
            long currentTimeMillis = System.currentTimeMillis() - N.N();
            if (currentTimeMillis < K) {
                j = K - currentTimeMillis;
                if (z) {
                    if (j <= 0) {
                        return;
                    }
                    q.c(new b(str, hybridUbcFlow, bVar), "waitFcp", j, TimeUnit.MILLISECONDS);
                    return;
                } else if (TextUtils.equals(str, "1")) {
                    hybridUbcFlow.P();
                    return;
                } else {
                    hybridUbcFlow.z(bVar);
                    return;
                }
            }
            z = true;
        }
        j = 0;
        if (z) {
        }
    }

    public static void u(JSONObject jSONObject, d.a.o0.a.a2.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, jSONObject, eVar) == null) {
            ExecutorUtilsExt.postOnElastic(new a(jSONObject, eVar), "handlePerformMsg", 2);
        }
    }

    public static void v(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, jSONObject) == null) {
            if (d.a.o0.a.u.c.d.f47942c) {
                Log.d("Api-UbcFlowJar", "upload swan app render log");
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("data");
            if (optJSONArray != null && optJSONArray.length() >= 1) {
                j.e().c(optJSONArray.optJSONObject(0));
            } else if (d.a.o0.a.u.c.d.f47942c) {
                Log.d("Api-UbcFlowJar", "Render monitor log is null");
            }
        }
    }

    public static void w(JSONObject jSONObject) {
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65543, null, jSONObject) == null) || jSONObject == null || (optJSONObject = jSONObject.optJSONObject("ext")) == null) {
            return;
        }
        String optString = optJSONObject.optString("routeId");
        if (TextUtils.isEmpty(optString)) {
            return;
        }
        HybridUbcFlow q = d.a.o0.a.r1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, optString);
        if (TextUtils.equals(optJSONObject.optString("hasWebView"), "1")) {
            q.F(HybridUbcFlow.SubmitStrategy.ROUTE_WEB);
        }
        q.D(A(jSONObject.optJSONArray("data")));
        q.l();
        d.a.o0.a.p.e.d B = d.a.o0.a.g1.f.V().B(optJSONObject.optString("slaveId"));
        if (B instanceof SwanAppSlaveManager) {
            ((SwanAppSlaveManager) B).h1();
        }
    }

    public static void x(@Nullable JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, jSONArray) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("FlowJarAction-671: ");
            sb.append(jSONArray == null ? StringUtil.NULL_STRING : jSONArray);
            d.a.o0.a.e0.d.h("Api-UbcFlowJar", sb.toString());
            if (jSONArray == null || jSONArray.length() == 0) {
                return;
            }
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                try {
                    JSONObject jSONObject = jSONArray.getJSONObject(i2);
                    if (TextUtils.equals(jSONObject.optString("type"), "feTraceError")) {
                        d.a.o0.a.i2.a.d().h(jSONObject);
                    } else {
                        d.a.o0.a.i2.a.d().k(jSONObject);
                    }
                } catch (JSONException e2) {
                    if (d.a.o0.a.u.c.d.f47942c) {
                        Log.w("Api-UbcFlowJar", "FlowJarAction-671: " + Log.getStackTraceString(e2));
                    }
                }
            }
        }
    }

    public static void y(JSONArray jSONArray) {
        d.a.o0.a.h0.g.f J;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65545, null, jSONArray) == null) || (J = d.a.o0.a.g1.f.V().J()) == null) {
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
                    } catch (NumberFormatException e2) {
                        e2.printStackTrace();
                    }
                }
                J.y3(new d.a.o0.a.j2.p.g(string, j));
            }
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
    }

    public static UbcFlowEvent z(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, jSONObject)) == null) {
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

    public d.a.o0.a.u.h.b B(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (d.a.o0.a.u.c.d.f47942c) {
                Log.d("Api-UbcFlowJar", "start handle ubc");
            }
            d.a.o0.a.a2.e i2 = d.a.o0.a.a2.e.i();
            if (i2 == null) {
                return new d.a.o0.a.u.h.b(1001, "swan app is null");
            }
            Pair<d.a.o0.a.u.h.b, JSONObject> b2 = d.a.o0.a.u.i.b.b("Api-UbcFlowJar", str);
            d.a.o0.a.u.h.b bVar = (d.a.o0.a.u.h.b) b2.first;
            if (!bVar.isSuccess()) {
                if (d.a.o0.a.u.c.d.f47942c) {
                    d.a.o0.a.e0.d.b("Api-UbcFlowJar", "parse fail");
                }
                return bVar;
            }
            JSONObject jSONObject = (JSONObject) b2.second;
            String optString = jSONObject.optString("flowId");
            if (TextUtils.isEmpty(optString)) {
                return new d.a.o0.a.u.h.b(201, "empty flowId");
            }
            char c2 = 65535;
            switch (optString.hashCode()) {
                case 53647:
                    if (optString.equals("670")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 53648:
                    if (optString.equals("671")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 55357:
                    if (optString.equals("805")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 56506:
                    if (optString.equals("967")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 1529139648:
                    if (optString.equals("renderMonitorLog")) {
                        c2 = 4;
                        break;
                    }
                    break;
            }
            if (c2 == 0) {
                u(jSONObject, i2);
            } else if (c2 == 1) {
                y(jSONObject.optJSONArray("data"));
            } else if (c2 == 2) {
                x(jSONObject.optJSONArray("data"));
            } else if (c2 == 3) {
                w(jSONObject);
            } else if (c2 != 4) {
                return new d.a.o0.a.u.h.b(201, "unknown flowId");
            } else {
                v(jSONObject);
            }
            return new d.a.o0.a.u.h.b(0);
        }
        return (d.a.o0.a.u.h.b) invokeL.objValue;
    }
}
