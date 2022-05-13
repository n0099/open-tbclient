package com.repackage;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.http.cookie.CookieManager;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.swan.pms.node.Node;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.tb4;
import com.repackage.v94;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
@Singleton
@Service
/* loaded from: classes6.dex */
public class ik2 implements b84 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Set a;
        public final /* synthetic */ vc4 b;

        /* renamed from: com.repackage.ik2$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0433a extends o32 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ AtomicInteger a;
            public final /* synthetic */ a b;

            public C0433a(a aVar, AtomicInteger atomicInteger) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, atomicInteger};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = aVar;
                this.a = atomicInteger;
            }

            @Override // com.repackage.o32
            public void d() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.get() == 0) {
                    wc4.a().c(this.b.b);
                }
            }

            @Override // com.repackage.o32
            public void f(m94 m94Var) {
                int i;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, m94Var) == null) {
                    super.f(m94Var);
                    if (m94Var == null || (i = m94Var.a) == 1010 || i == 1015) {
                        return;
                    }
                    this.a.incrementAndGet();
                }
            }

            @Override // com.repackage.o32
            public void h() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.a.get() == 0) {
                    wc4.a().c(this.b.b);
                }
            }
        }

        public a(ik2 ik2Var, Set set, vc4 vc4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ik2Var, set, vc4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = set;
            this.b = vc4Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ArrayList arrayList = new ArrayList();
                AtomicInteger atomicInteger = new AtomicInteger(0);
                for (String str : this.a) {
                    if (!TextUtils.isEmpty(str)) {
                        arrayList.add(new tb4.a(str, 0));
                    }
                }
                if (arrayList.isEmpty()) {
                    return;
                }
                kz1.b(arrayList, "3", new C0433a(this, atomicInteger));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c93 a;
        public final /* synthetic */ JSONObject b;

        public b(ik2 ik2Var, c93 c93Var, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ik2Var, c93Var, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = c93Var;
            this.b = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                qs2.g().q(this.a, this.b);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements g22<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t94 a;

        public c(ik2 ik2Var, t94 t94Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ik2Var, t94Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t94Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.g22
        /* renamed from: b */
        public void a(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bool) == null) {
                mw2.b("download plugin result = " + bool);
                nw2.b(this.a.g);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755615647, "Lcom/repackage/ik2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755615647, "Lcom/repackage/ik2;");
                return;
            }
        }
        boolean z = eh1.a;
    }

    public ik2() {
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

    @Override // com.repackage.b84
    public cb4 A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? bk2.r0() : (cb4) invokeV.objValue;
    }

    @Override // com.repackage.b84
    public int B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? tw2.t() : invokeV.intValue;
    }

    @Override // com.repackage.b84
    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            te3.j().l();
        }
    }

    @Override // com.repackage.b84
    public void D(hc4 hc4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, hc4Var) == null) || hc4Var == null) {
            return;
        }
        try {
            JSONObject b2 = hc4Var.b();
            JSONArray a2 = hc4Var.a();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("threshold", b2.optInt("threshold"));
            jSONObject.put("timeup", b2.optInt("timeup"));
            jSONObject.put("item", a2.toString());
            if (u03.v) {
                Log.d(Node.TAG, "ceres adapted config " + jSONObject);
            }
            lg4 lg4Var = new lg4("0", jSONObject);
            lg4Var.e();
            ig4.f().o(lg4Var);
        } catch (JSONException e) {
            if (u03.v) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.repackage.b84
    public String E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? bk2.o().q() : (String) invokeV.objValue;
    }

    @Override // com.repackage.b84
    public int F(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048581, this, str, i)) == null) {
            bk2.g0().getSwitch(str, i);
            return i;
        }
        return invokeLI.intValue;
    }

    @Override // com.repackage.b84
    public void G(String str, String str2, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048582, this, str, str2, th) == null) {
            ux1.l(str, str2, th);
        }
    }

    @Override // com.repackage.b84
    public void H(vc4 vc4Var) {
        Set<String> b2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, vc4Var) == null) || vc4Var == null || (b2 = vc4Var.b()) == null || b2.size() <= 0) {
            return;
        }
        ExecutorUtilsExt.postOnElastic(new a(this, b2, vc4Var), "preloadPkg", 2);
    }

    @Override // com.repackage.b84
    public String I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? qx1.m() : (String) invokeV.objValue;
    }

    @Override // com.repackage.b84
    public String J(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) ? z93.h(i) : (String) invokeI.objValue;
    }

    @Override // com.repackage.b84
    public void K(String str, String str2, String str3, int i, JSONObject jSONObject, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{str, str2, str3, Integer.valueOf(i), jSONObject, Boolean.valueOf(z)}) == null) {
            z73.d(str, str2, str3, i, jSONObject, z);
        }
    }

    @Override // com.repackage.b84
    public void L(String str, String str2, String str3, @Nullable Throwable th, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{str, str2, str3, th, Boolean.valueOf(z)}) == null) {
            ux1.e(str, str2, str3, th, z);
        }
    }

    @Override // com.repackage.b84
    public ba4 M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? t03.J().M() : (ba4) invokeV.objValue;
    }

    @Override // com.repackage.b84
    public float a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? bk2.m().a() : invokeV.floatValue;
    }

    @Override // com.repackage.b84
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? fh1.a() : (String) invokeV.objValue;
    }

    @Override // com.repackage.b84
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? bk2.n().a() : (String) invokeV.objValue;
    }

    @Override // com.repackage.b84
    public void d(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, bArr) == null) {
            bk2.e().d(bArr);
        }
    }

    @Override // com.repackage.b84
    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? fh4.b(AppRuntime.getAppContext()).a() : (String) invokeV.objValue;
    }

    @Override // com.repackage.b84
    public CookieManager f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? bk2.q().a() : (CookieManager) invokeV.objValue;
    }

    @Override // com.repackage.b84
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? bk2.h0().i(AppRuntime.getAppContext()) : (String) invokeV.objValue;
    }

    @Override // com.repackage.b84
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? oe3.D() : (String) invokeV.objValue;
    }

    @Override // com.repackage.b84
    public vg4 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? i93.b("swan_app_pms_sp") : (vg4) invokeV.objValue;
    }

    @Override // com.repackage.b84
    public long j(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048598, this, i)) == null) ? db2.d(i) : invokeI.longValue;
    }

    @Override // com.repackage.b84
    public void k(JSONArray jSONArray, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048599, this, jSONArray, str, str2) == null) {
            h33.b().n(jSONArray, str, str2);
        }
    }

    @Override // com.repackage.b84
    public List<l94> l(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048600, this, str, j)) == null) ? bw2.e(str, j) : (List) invokeLJ.objValue;
    }

    @Override // com.repackage.b84
    public void m(String str, String str2, v94.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048601, this, str, str2, cVar) == null) {
            bk2.e().f(str, str2, cVar);
        }
    }

    @Override // com.repackage.b84
    public ba4 n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? new g42(t03.J()) : (ba4) invokeV.objValue;
    }

    @Override // com.repackage.b84
    public boolean o(boolean z, @NonNull JSONArray jSONArray) {
        InterceptResult invokeZL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZL = interceptable.invokeZL(1048603, this, z, jSONArray)) == null) ? new ff3(z).c(jSONArray) : invokeZL.booleanValue;
    }

    @Override // com.repackage.b84
    public void p(String str, JSONObject jSONObject, r94 r94Var, List<s94> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048604, this, str, jSONObject, r94Var, list) == null) {
            yq2.g(str, jSONObject, r94Var, list);
        }
    }

    @Override // com.repackage.b84
    public String q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? bk2.g0().k() : (String) invokeV.objValue;
    }

    @Override // com.repackage.b84
    public boolean r(@Nullable t94 t94Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, t94Var)) == null) {
            File g = bw2.g(t94Var);
            return g != null && g.exists();
        }
        return invokeL.booleanValue;
    }

    @Override // com.repackage.b84
    public void s(PMSAppInfo pMSAppInfo, JSONObject jSONObject, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048607, this, pMSAppInfo, jSONObject, z) == null) {
            if (pMSAppInfo == null) {
                if (u03.v) {
                    Log.e("SwanAppUpdateManager", "pms app info is null");
                    return;
                }
                return;
            }
            String str = pMSAppInfo.appKey;
            if (!TextUtils.isEmpty(str) && jSONObject != null) {
                int i = pMSAppInfo.type;
                c93 b2 = i93.b(c83.u(str, i));
                b2.putBoolean("swan_service_update_degraded", z);
                ux1.k("SwanAppUpdateManager", "update async appKey = " + str + " ; type = " + i + " ; serviceDegraded = " + z);
                od3.l(new b(this, b2, jSONObject), "parseAccreditList");
            } else if (u03.v) {
                Log.e("SwanAppUpdateManager", "appKey = " + str + " is empty or accredit list is null");
            }
        }
    }

    @Override // com.repackage.b84
    public void t(kd4 kd4Var, ae4 ae4Var) {
        Collection<t94> collection;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048608, this, kd4Var, ae4Var) == null) || kd4Var == null || (collection = kd4Var.e) == null || ae4Var == null) {
            return;
        }
        for (t94 t94Var : collection) {
            aw2 aw2Var = new aw2(t94Var.g, t94Var.j, t94Var.i, new c(this, t94Var));
            kd4 kd4Var2 = new kd4();
            kd4Var2.e = new ArrayList();
            ae4 ae4Var2 = new ae4();
            ld4.b(t94Var, ae4Var2);
            aw2Var.H(ae4Var2);
            kd4Var2.e.clear();
            kd4Var2.e.add(t94Var);
            da4.e(kd4Var2, aw2Var);
        }
    }

    @Override // com.repackage.b84
    public String u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? uu2.b() : (String) invokeV.objValue;
    }

    @Override // com.repackage.b84
    public String v(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048610, this, i)) == null) ? db2.e(i) : (String) invokeI.objValue;
    }

    @Override // com.repackage.b84
    public long w(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048611, this, i)) == null) ? z93.f(i) : invokeI.longValue;
    }

    @Override // com.repackage.b84
    public boolean x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            mw2.c("线下调试需要禁用BDTLS");
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.b84
    public void y(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048613, this, str, str2) == null) {
            ux1.k(str, str2);
        }
    }

    @Override // com.repackage.b84
    public void z(String str, String str2, String str3, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048614, this, new Object[]{str, str2, str3, Boolean.valueOf(z)}) == null) {
            ux1.j(str, str2, str3, z);
        }
    }
}
