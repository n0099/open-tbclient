package com.repackage;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.datacollector.growth.utils.GrowthConstant;
import com.baidu.searchbox.ubcprocessor.UBCCloudControlProcessor;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.v8.NodeJS;
import com.repackage.rl2;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class e73 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static volatile boolean b;
    public static volatile boolean c;
    public static volatile boolean d;
    public static volatile boolean e;
    public static volatile boolean f;
    public static volatile boolean g;
    public static HashMap<String, String> h;
    public static String i;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Bundle a;

        public a(Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bundle};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bundle;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.remove("page_display_flag_for_statistic");
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ x73 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;

        public b(x73 x73Var, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x73Var, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = x73Var;
            this.b = str;
            this.c = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.b(n73.k(this.b));
                this.a.d(this.c);
                n73.onEvent(this.a);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ x73 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;

        public c(x73 x73Var, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x73Var, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = x73Var;
            this.b = str;
            this.c = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.d(this.b);
                this.a.b(n73.k(this.c));
                n73.onEvent(this.a);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ x73 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;

        public d(x73 x73Var, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x73Var, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = x73Var;
            this.b = str;
            this.c = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.b(n73.k(this.b));
                this.a.d(this.c);
                n73.onEvent(this.a);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class e implements nf3<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ x73 a;

        public e(x73 x73Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x73Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = x73Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.nf3
        /* renamed from: a */
        public void onCallback(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
                this.a.a(GrowthConstant.UBC_VALUE_TYPE_DEVICE_INFO, jSONObject);
                n73.onEvent(this.a);
                ux1.k("SwanAppLaunchUbc", jSONObject.toString());
                bk2.p0().flush(false);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755784752, "Lcom/repackage/e73;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755784752, "Lcom/repackage/e73;");
                return;
            }
        }
        a = eh1.a;
        b = false;
        c = false;
        d = false;
        e = false;
        f = false;
        g = false;
    }

    public static synchronized void A(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65537, null, z) == null) {
            synchronized (e73.class) {
                c = z;
            }
        }
    }

    public static synchronized void B(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65538, null, z) == null) {
            synchronized (e73.class) {
                d = z;
            }
        }
    }

    public static synchronized void C(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65539, null, z) == null) {
            synchronized (e73.class) {
                b = z;
            }
        }
    }

    public static void D(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TRACKBALL, null, z) == null) {
            f = z;
        }
    }

    public static void E(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65541, null, z) == null) {
            e = z;
        }
    }

    public static void F(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65542, null, str, str2) == null) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        if (h == null) {
            h = new HashMap<>();
        }
        h.put(str, str2);
    }

    public static void G() {
        d02 V;
        an1 n3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65543, null) == null) || (V = hm2.U().V()) == null) {
            return;
        }
        a02 m = V.m();
        if (!(m instanceof c02) || (n3 = ((c02) m).n3()) == null) {
            return;
        }
        i = n3.c();
    }

    public static void H() {
        HybridUbcFlow d2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65544, null) == null) || (d2 = zt2.d(NodeJS.STARTUP_SCRIPT_NAME)) == null) {
            return;
        }
        if (d2.w() || d2.t()) {
            return;
        }
        d2.E("value", "fe_success");
    }

    public static void a(ln1 ln1Var) {
        u03 L;
        rl2.a V;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65545, null, ln1Var) == null) || f() || g() || ln1Var == null || (L = u03.L()) == null || (V = L.V()) == null) {
            return;
        }
        if (a) {
            Log.d("SwanAppLaunchUbc", "real start handle arrival report ");
        }
        A(true);
        B(true);
        c(V, ln1Var.b, "0", ln1Var.c, b(ln1Var.g), false);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static String b(String str) {
        InterceptResult invokeL;
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, str)) == null) {
            switch (str.hashCode()) {
                case 48:
                    if (str.equals("0")) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 49:
                    if (str.equals("1")) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 50:
                    if (str.equals("2")) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 51:
                    if (str.equals("3")) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            return c2 != 1 ? c2 != 2 ? c2 != 3 ? "0" : "4" : "3" : "2";
        }
        return (String) invokeL.objValue;
    }

    public static void c(rl2.a aVar, long j, String str, long j2, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65547, null, new Object[]{aVar, Long.valueOf(j), str, Long.valueOf(j2), str2, Boolean.valueOf(z)}) == null) || aVar == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        A(true);
        if (z || j > 0) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("valuetype", str);
            } catch (JSONException e2) {
                if (a) {
                    e2.printStackTrace();
                }
            }
            l(aVar, "arrivesuccess", j, jSONObject);
        }
        if (z || j2 > 0) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("valuetype", str2);
            } catch (JSONException e3) {
                if (a) {
                    e3.printStackTrace();
                }
            }
            l(aVar, "fmparrsuccess", j2, jSONObject2);
        }
    }

    public static void d(@NonNull rl2.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, null, aVar) == null) {
            E(true);
            x73 x73Var = new x73();
            x73Var.a = n73.n(0);
            x73Var.b = "launch";
            x73Var.e = "narendersuccess";
            x73Var.h(aVar);
            nu2.e().d(new d(x73Var, aVar.W(), aVar.s0().getString(UBCCloudControlProcessor.UBC_KEY)), "handleNaRenderSuccess", true);
        }
    }

    public static synchronized boolean e() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) {
            synchronized (e73.class) {
                z = b;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public static boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) ? c : invokeV.booleanValue;
    }

    public static boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) ? d : invokeV.booleanValue;
    }

    public static boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65552, null)) == null) ? f : invokeV.booleanValue;
    }

    public static boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65553, null)) == null) ? e : invokeV.booleanValue;
    }

    public static boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) ? g : invokeV.booleanValue;
    }

    public static void k(rl2.a aVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65555, null, aVar, str) == null) {
            l(aVar, str, System.currentTimeMillis(), null);
        }
    }

    public static void l(rl2.a aVar, String str, long j, JSONObject jSONObject) {
        String H;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65556, null, new Object[]{aVar, str, Long.valueOf(j), jSONObject}) == null) || (H = aVar.H()) == null || aVar == null) {
            return;
        }
        long j2 = 0;
        if (j != -1) {
            long l = aVar.l("launch_time", 0L);
            if (j <= 0) {
                j = System.currentTimeMillis();
            }
            j2 = j - l;
        }
        x73 x73Var = new x73();
        x73Var.a = n73.n(aVar.G());
        x73Var.f = H;
        if (ly1.d()) {
            x73Var.c = "remote-debug";
        } else if (tw2.D()) {
            x73Var.c = "local-debug";
        } else {
            x73Var.c = aVar.T();
        }
        x73Var.b = "launch";
        x73Var.e = str;
        x73Var.a("arrivetime", String.valueOf(j2));
        if (jSONObject != null) {
            x73Var.e(jSONObject);
        }
        Bundle P = aVar.P();
        if (P != null) {
            x73Var.d(P.getString(UBCCloudControlProcessor.UBC_KEY));
        }
        x73Var.b(n73.k(aVar.W()));
        if (a) {
            StringBuilder sb = new StringBuilder();
            sb.append("handle record arrival event, arrivalValue ");
            sb.append(str);
            sb.append(" arrive time : ");
            sb.append(j2);
            sb.append(" extJson :");
            sb.append(jSONObject == null ? "" : jSONObject.toString());
            Log.d("SwanAppLaunchUbc", sb.toString());
        }
        n73.onEvent(x73Var);
    }

    public static void m(@NonNull rl2 rl2Var, int i2, @NonNull nc3 nc3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65557, null, rl2Var, i2, nc3Var) == null) {
            x73 x73Var = new x73();
            x73Var.a = n73.n(i2);
            x73Var.b = "launch";
            x73Var.e = com.baidu.pass.biometrics.face.liveness.b.a.g0;
            x73Var.a("errcode", String.valueOf(nc3Var.a()));
            x73Var.a("msg", nc3Var.g().toString());
            x73Var.h(rl2Var);
            x73Var.d(rl2Var.s0().getString(UBCCloudControlProcessor.UBC_KEY));
            x73Var.b(n73.k(rl2Var.W()));
            kd3.d(rl2Var, new e(x73Var));
        }
    }

    public static void n(x73 x73Var, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65558, null, x73Var, str, str2) == null) {
            nu2.e().d(new c(x73Var, str2, str), "onLaunchSuccessUBC", true);
        }
    }

    public static void o(rl2.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65559, null, aVar) == null) || aVar == null || f) {
            return;
        }
        D(true);
        k(aVar, "naarrsuccess");
    }

    public static void p(rl2.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65560, null, aVar) == null) {
            if (a) {
                Log.d("SwanAppLaunchUbc", "handle relaunch arrival");
            }
            hr2.e(i);
            if (!i()) {
                d(aVar);
            }
            if (f() || g()) {
                return;
            }
            c(aVar, -1L, "1", -1L, "1", true);
        }
    }

    public static void q(rl2.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65561, null, aVar) == null) || aVar == null || g()) {
            return;
        }
        B(true);
        k(aVar, "arrivecancel");
    }

    public static void r() {
        u03 L;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65562, null) == null) || (L = u03.L()) == null) {
            return;
        }
        s(L.V());
    }

    public static void s(rl2 rl2Var) {
        Bundle P;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65563, null, rl2Var) == null) || rl2Var == null || !e() || (P = rl2Var.P()) == null) {
            return;
        }
        long j = P.getLong("page_display_flag_for_statistic");
        long l = rl2Var.l("launch_time", 0L);
        long currentTimeMillis = System.currentTimeMillis();
        if (j > 0) {
            x73 x73Var = new x73();
            x73Var.a = n73.n(rl2Var.G());
            x73Var.f = rl2Var.H();
            x73Var.c = rl2Var.T();
            x73Var.b = "launch";
            x73Var.e = "realsuccess";
            x73Var.r = String.valueOf(currentTimeMillis - l);
            x73Var.d(P.getString(UBCCloudControlProcessor.UBC_KEY));
            n73.onEvent(x73Var);
            oe3.e0(new a(P));
            H();
        }
    }

    public static void t(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65564, null, str) == null) && g) {
            Log.d("SwanAppLaunchUbc", "handle record slave id case relaunch");
            hr2.e(str);
            g = false;
        }
    }

    public static void u(String str, rl2.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65565, null, str, aVar) == null) {
            HashMap<String, String> hashMap = h;
            String str2 = hashMap != null ? hashMap.get(i) : "";
            if (a) {
                StringBuilder sb = new StringBuilder();
                sb.append("handle relaunch , launchPage : ");
                sb.append(str);
                sb.append(" lastSlavePath ：");
                sb.append(str2 != null ? str2 : "");
                Log.d("SwanAppLaunchUbc", sb.toString());
            }
            if (TextUtils.equals(str, str2)) {
                p(aVar);
                return;
            }
            x();
            g = true;
        }
    }

    public static void v(@NonNull rl2 rl2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65566, null, rl2Var) == null) {
            x73 x73Var = new x73();
            x73Var.a = n73.n(0);
            x73Var.f = rl2Var.H();
            x73Var.c = rl2Var.T();
            x73Var.b = "show";
            nu2.e().d(new b(x73Var, rl2Var.W(), rl2Var.s0().getString(UBCCloudControlProcessor.UBC_KEY)), "onShow606", true);
        }
    }

    public static void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65567, null) == null) {
            B(false);
        }
    }

    public static void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65568, null) == null) {
            A(false);
        }
    }

    public static void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65569, null) == null) {
            C(false);
        }
    }

    public static void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65570, null) == null) {
            y();
            D(false);
            x();
            w();
            E(false);
        }
    }
}
