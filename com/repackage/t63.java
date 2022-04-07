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
import com.repackage.gl2;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class t63 {
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

    /* loaded from: classes7.dex */
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

    /* loaded from: classes7.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m73 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;

        public b(m73 m73Var, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m73Var, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = m73Var;
            this.b = str;
            this.c = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.b(c73.k(this.b));
                this.a.d(this.c);
                c73.onEvent(this.a);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m73 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;

        public c(m73 m73Var, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m73Var, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = m73Var;
            this.b = str;
            this.c = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.d(this.b);
                this.a.b(c73.k(this.c));
                c73.onEvent(this.a);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m73 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;

        public d(m73 m73Var, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m73Var, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = m73Var;
            this.b = str;
            this.c = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.b(c73.k(this.b));
                this.a.d(this.c);
                c73.onEvent(this.a);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class e implements cf3<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m73 a;

        public e(m73 m73Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m73Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = m73Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.cf3
        /* renamed from: a */
        public void onCallback(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
                this.a.a(GrowthConstant.UBC_VALUE_TYPE_DEVICE_INFO, jSONObject);
                c73.onEvent(this.a);
                jx1.k("SwanAppLaunchUbc", jSONObject.toString());
                qj2.p0().flush(false);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755338848, "Lcom/repackage/t63;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755338848, "Lcom/repackage/t63;");
                return;
            }
        }
        a = tg1.a;
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
            synchronized (t63.class) {
                c = z;
            }
        }
    }

    public static synchronized void B(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65538, null, z) == null) {
            synchronized (t63.class) {
                d = z;
            }
        }
    }

    public static synchronized void C(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65539, null, z) == null) {
            synchronized (t63.class) {
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
        sz1 V;
        pm1 n3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65543, null) == null) || (V = wl2.U().V()) == null) {
            return;
        }
        pz1 m = V.m();
        if (!(m instanceof rz1) || (n3 = ((rz1) m).n3()) == null) {
            return;
        }
        i = n3.c();
    }

    public static void H() {
        HybridUbcFlow d2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65544, null) == null) || (d2 = ot2.d(NodeJS.STARTUP_SCRIPT_NAME)) == null) {
            return;
        }
        if (d2.w() || d2.t()) {
            return;
        }
        d2.E("value", "fe_success");
    }

    public static void a(an1 an1Var) {
        j03 L;
        gl2.a V;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65545, null, an1Var) == null) || f() || g() || an1Var == null || (L = j03.L()) == null || (V = L.V()) == null) {
            return;
        }
        if (a) {
            Log.d("SwanAppLaunchUbc", "real start handle arrival report ");
        }
        A(true);
        B(true);
        c(V, an1Var.b, "0", an1Var.c, b(an1Var.g), false);
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

    public static void c(gl2.a aVar, long j, String str, long j2, String str2, boolean z) {
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

    public static void d(@NonNull gl2.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, null, aVar) == null) {
            E(true);
            m73 m73Var = new m73();
            m73Var.a = c73.n(0);
            m73Var.b = "launch";
            m73Var.e = "narendersuccess";
            m73Var.h(aVar);
            cu2.e().d(new d(m73Var, aVar.W(), aVar.s0().getString(UBCCloudControlProcessor.UBC_KEY)), "handleNaRenderSuccess", true);
        }
    }

    public static synchronized boolean e() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) {
            synchronized (t63.class) {
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

    public static void k(gl2.a aVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65555, null, aVar, str) == null) {
            l(aVar, str, System.currentTimeMillis(), null);
        }
    }

    public static void l(gl2.a aVar, String str, long j, JSONObject jSONObject) {
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
        m73 m73Var = new m73();
        m73Var.a = c73.n(aVar.G());
        m73Var.f = H;
        if (ay1.d()) {
            m73Var.c = "remote-debug";
        } else if (iw2.D()) {
            m73Var.c = "local-debug";
        } else {
            m73Var.c = aVar.T();
        }
        m73Var.b = "launch";
        m73Var.e = str;
        m73Var.a("arrivetime", String.valueOf(j2));
        if (jSONObject != null) {
            m73Var.e(jSONObject);
        }
        Bundle P = aVar.P();
        if (P != null) {
            m73Var.d(P.getString(UBCCloudControlProcessor.UBC_KEY));
        }
        m73Var.b(c73.k(aVar.W()));
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
        c73.onEvent(m73Var);
    }

    public static void m(@NonNull gl2 gl2Var, int i2, @NonNull cc3 cc3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65557, null, gl2Var, i2, cc3Var) == null) {
            m73 m73Var = new m73();
            m73Var.a = c73.n(i2);
            m73Var.b = "launch";
            m73Var.e = com.baidu.pass.biometrics.face.liveness.b.a.g0;
            m73Var.a("errcode", String.valueOf(cc3Var.a()));
            m73Var.a("msg", cc3Var.g().toString());
            m73Var.h(gl2Var);
            m73Var.d(gl2Var.s0().getString(UBCCloudControlProcessor.UBC_KEY));
            m73Var.b(c73.k(gl2Var.W()));
            zc3.d(gl2Var, new e(m73Var));
        }
    }

    public static void n(m73 m73Var, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65558, null, m73Var, str, str2) == null) {
            cu2.e().d(new c(m73Var, str2, str), "onLaunchSuccessUBC", true);
        }
    }

    public static void o(gl2.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65559, null, aVar) == null) || aVar == null || f) {
            return;
        }
        D(true);
        k(aVar, "naarrsuccess");
    }

    public static void p(gl2.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65560, null, aVar) == null) {
            if (a) {
                Log.d("SwanAppLaunchUbc", "handle relaunch arrival");
            }
            wq2.e(i);
            if (!i()) {
                d(aVar);
            }
            if (f() || g()) {
                return;
            }
            c(aVar, -1L, "1", -1L, "1", true);
        }
    }

    public static void q(gl2.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65561, null, aVar) == null) || aVar == null || g()) {
            return;
        }
        B(true);
        k(aVar, "arrivecancel");
    }

    public static void r() {
        j03 L;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65562, null) == null) || (L = j03.L()) == null) {
            return;
        }
        s(L.V());
    }

    public static void s(gl2 gl2Var) {
        Bundle P;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65563, null, gl2Var) == null) || gl2Var == null || !e() || (P = gl2Var.P()) == null) {
            return;
        }
        long j = P.getLong("page_display_flag_for_statistic");
        long l = gl2Var.l("launch_time", 0L);
        long currentTimeMillis = System.currentTimeMillis();
        if (j > 0) {
            m73 m73Var = new m73();
            m73Var.a = c73.n(gl2Var.G());
            m73Var.f = gl2Var.H();
            m73Var.c = gl2Var.T();
            m73Var.b = "launch";
            m73Var.e = "realsuccess";
            m73Var.r = String.valueOf(currentTimeMillis - l);
            m73Var.d(P.getString(UBCCloudControlProcessor.UBC_KEY));
            c73.onEvent(m73Var);
            de3.e0(new a(P));
            H();
        }
    }

    public static void t(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65564, null, str) == null) && g) {
            Log.d("SwanAppLaunchUbc", "handle record slave id case relaunch");
            wq2.e(str);
            g = false;
        }
    }

    public static void u(String str, gl2.a aVar) {
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

    public static void v(@NonNull gl2 gl2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65566, null, gl2Var) == null) {
            m73 m73Var = new m73();
            m73Var.a = c73.n(0);
            m73Var.f = gl2Var.H();
            m73Var.c = gl2Var.T();
            m73Var.b = "show";
            cu2.e().d(new b(m73Var, gl2Var.W(), gl2Var.s0().getString(UBCCloudControlProcessor.UBC_KEY)), "onShow606", true);
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
