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
import com.repackage.aa4;
import com.repackage.yb4;
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
public class nk2 implements g84 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Set a;
        public final /* synthetic */ ad4 b;

        /* renamed from: com.repackage.nk2$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0538a extends t32 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ AtomicInteger a;
            public final /* synthetic */ a b;

            public C0538a(a aVar, AtomicInteger atomicInteger) {
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

            @Override // com.repackage.t32
            public void d() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.get() == 0) {
                    bd4.a().c(this.b.b);
                }
            }

            @Override // com.repackage.t32
            public void f(r94 r94Var) {
                int i;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, r94Var) == null) {
                    super.f(r94Var);
                    if (r94Var == null || (i = r94Var.a) == 1010 || i == 1015) {
                        return;
                    }
                    this.a.incrementAndGet();
                }
            }

            @Override // com.repackage.t32
            public void h() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.a.get() == 0) {
                    bd4.a().c(this.b.b);
                }
            }
        }

        public a(nk2 nk2Var, Set set, ad4 ad4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nk2Var, set, ad4Var};
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
            this.b = ad4Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ArrayList arrayList = new ArrayList();
                AtomicInteger atomicInteger = new AtomicInteger(0);
                for (String str : this.a) {
                    if (!TextUtils.isEmpty(str)) {
                        arrayList.add(new yb4.a(str, 0));
                    }
                }
                if (arrayList.isEmpty()) {
                    return;
                }
                pz1.b(arrayList, "3", new C0538a(this, atomicInteger));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h93 a;
        public final /* synthetic */ JSONObject b;

        public b(nk2 nk2Var, h93 h93Var, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nk2Var, h93Var, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = h93Var;
            this.b = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                vs2.g().q(this.a, this.b);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements l22<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ y94 a;

        public c(nk2 nk2Var, y94 y94Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nk2Var, y94Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = y94Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.l22
        /* renamed from: b */
        public void a(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bool) == null) {
                rw2.b("download plugin result = " + bool);
                sw2.b(this.a.g);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755466692, "Lcom/repackage/nk2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755466692, "Lcom/repackage/nk2;");
                return;
            }
        }
        boolean z = jh1.a;
    }

    public nk2() {
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

    @Override // com.repackage.g84
    public hb4 A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? gk2.r0() : (hb4) invokeV.objValue;
    }

    @Override // com.repackage.g84
    public int B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? yw2.t() : invokeV.intValue;
    }

    @Override // com.repackage.g84
    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            ye3.k().m();
        }
    }

    @Override // com.repackage.g84
    public void D(mc4 mc4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, mc4Var) == null) || mc4Var == null) {
            return;
        }
        try {
            JSONObject b2 = mc4Var.b();
            JSONArray a2 = mc4Var.a();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("threshold", b2.optInt("threshold"));
            jSONObject.put("timeup", b2.optInt("timeup"));
            jSONObject.put("item", a2.toString());
            if (z03.v) {
                Log.d(Node.TAG, "ceres adapted config " + jSONObject);
            }
            pg4 pg4Var = new pg4("0", jSONObject);
            pg4Var.e();
            mg4.f().o(pg4Var);
        } catch (JSONException e) {
            if (z03.v) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.repackage.g84
    public String E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? gk2.o().q() : (String) invokeV.objValue;
    }

    @Override // com.repackage.g84
    public int F(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048581, this, str, i)) == null) {
            gk2.g0().getSwitch(str, i);
            return i;
        }
        return invokeLI.intValue;
    }

    @Override // com.repackage.g84
    public void G(String str, String str2, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048582, this, str, str2, th) == null) {
            zx1.l(str, str2, th);
        }
    }

    @Override // com.repackage.g84
    public void H(ad4 ad4Var) {
        Set<String> b2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, ad4Var) == null) || ad4Var == null || (b2 = ad4Var.b()) == null || b2.size() <= 0) {
            return;
        }
        ExecutorUtilsExt.postOnElastic(new a(this, b2, ad4Var), "preloadPkg", 2);
    }

    @Override // com.repackage.g84
    public String I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? vx1.m() : (String) invokeV.objValue;
    }

    @Override // com.repackage.g84
    public String J(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) ? ea3.h(i) : (String) invokeI.objValue;
    }

    @Override // com.repackage.g84
    public void K(String str, String str2, String str3, int i, JSONObject jSONObject, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{str, str2, str3, Integer.valueOf(i), jSONObject, Boolean.valueOf(z)}) == null) {
            e83.d(str, str2, str3, i, jSONObject, z);
        }
    }

    @Override // com.repackage.g84
    public void L(String str, String str2, String str3, @Nullable Throwable th, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{str, str2, str3, th, Boolean.valueOf(z)}) == null) {
            zx1.e(str, str2, str3, th, z);
        }
    }

    @Override // com.repackage.g84
    public ga4 M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? y03.K().N() : (ga4) invokeV.objValue;
    }

    @Override // com.repackage.g84
    public float a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? gk2.m().a() : invokeV.floatValue;
    }

    @Override // com.repackage.g84
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? kh1.a() : (String) invokeV.objValue;
    }

    @Override // com.repackage.g84
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? gk2.n().a() : (String) invokeV.objValue;
    }

    @Override // com.repackage.g84
    public void d(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, bArr) == null) {
            gk2.e().d(bArr);
        }
    }

    @Override // com.repackage.g84
    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? jh4.b(AppRuntime.getAppContext()).a() : (String) invokeV.objValue;
    }

    @Override // com.repackage.g84
    public CookieManager f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? gk2.q().a() : (CookieManager) invokeV.objValue;
    }

    @Override // com.repackage.g84
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? gk2.h0().i(AppRuntime.getAppContext()) : (String) invokeV.objValue;
    }

    @Override // com.repackage.g84
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? te3.D() : (String) invokeV.objValue;
    }

    @Override // com.repackage.g84
    public zg4 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? n93.b("swan_app_pms_sp") : (zg4) invokeV.objValue;
    }

    @Override // com.repackage.g84
    public long j(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048598, this, i)) == null) ? ib2.d(i) : invokeI.longValue;
    }

    @Override // com.repackage.g84
    public void k(JSONArray jSONArray, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048599, this, jSONArray, str, str2) == null) {
            m33.b().n(jSONArray, str, str2);
        }
    }

    @Override // com.repackage.g84
    public List<q94> l(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048600, this, str, j)) == null) ? gw2.e(str, j) : (List) invokeLJ.objValue;
    }

    @Override // com.repackage.g84
    public void m(String str, String str2, aa4.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048601, this, str, str2, cVar) == null) {
            gk2.e().f(str, str2, cVar);
        }
    }

    @Override // com.repackage.g84
    public ga4 n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? new l42(y03.K()) : (ga4) invokeV.objValue;
    }

    @Override // com.repackage.g84
    public boolean o(boolean z, @NonNull JSONArray jSONArray) {
        InterceptResult invokeZL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZL = interceptable.invokeZL(1048603, this, z, jSONArray)) == null) ? new kf3(z).c(jSONArray) : invokeZL.booleanValue;
    }

    @Override // com.repackage.g84
    public void p(String str, JSONObject jSONObject, w94 w94Var, List<x94> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048604, this, str, jSONObject, w94Var, list) == null) {
            dr2.g(str, jSONObject, w94Var, list);
        }
    }

    @Override // com.repackage.g84
    public String q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? gk2.g0().k() : (String) invokeV.objValue;
    }

    @Override // com.repackage.g84
    public boolean r(@Nullable y94 y94Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, y94Var)) == null) {
            File g = gw2.g(y94Var);
            return g != null && g.exists();
        }
        return invokeL.booleanValue;
    }

    @Override // com.repackage.g84
    public void s(PMSAppInfo pMSAppInfo, JSONObject jSONObject, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048607, this, pMSAppInfo, jSONObject, z) == null) {
            if (pMSAppInfo == null) {
                if (z03.v) {
                    Log.e("SwanAppUpdateManager", "pms app info is null");
                    return;
                }
                return;
            }
            String str = pMSAppInfo.appKey;
            if (!TextUtils.isEmpty(str) && jSONObject != null) {
                int i = pMSAppInfo.type;
                h93 b2 = n93.b(h83.u(str, i));
                b2.putBoolean("swan_service_update_degraded", z);
                zx1.k("SwanAppUpdateManager", "update async appKey = " + str + " ; type = " + i + " ; serviceDegraded = " + z);
                td3.l(new b(this, b2, jSONObject), "parseAccreditList");
            } else if (z03.v) {
                Log.e("SwanAppUpdateManager", "appKey = " + str + " is empty or accredit list is null");
            }
        }
    }

    @Override // com.repackage.g84
    public void t(pd4 pd4Var, fe4 fe4Var) {
        Collection<y94> collection;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048608, this, pd4Var, fe4Var) == null) || pd4Var == null || (collection = pd4Var.e) == null || fe4Var == null) {
            return;
        }
        for (y94 y94Var : collection) {
            fw2 fw2Var = new fw2(y94Var.g, y94Var.j, y94Var.i, new c(this, y94Var));
            pd4 pd4Var2 = new pd4();
            pd4Var2.e = new ArrayList();
            fe4 fe4Var2 = new fe4();
            qd4.b(y94Var, fe4Var2);
            fw2Var.G(fe4Var2);
            pd4Var2.e.clear();
            pd4Var2.e.add(y94Var);
            ia4.e(pd4Var2, fw2Var);
        }
    }

    @Override // com.repackage.g84
    public String u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? zu2.b() : (String) invokeV.objValue;
    }

    @Override // com.repackage.g84
    public String v(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048610, this, i)) == null) ? ib2.e(i) : (String) invokeI.objValue;
    }

    @Override // com.repackage.g84
    public long w(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048611, this, i)) == null) ? ea3.f(i) : invokeI.longValue;
    }

    @Override // com.repackage.g84
    public boolean x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            rw2.c("线下调试需要禁用BDTLS");
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.g84
    public void y(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048613, this, str, str2) == null) {
            zx1.k(str, str2);
        }
    }

    @Override // com.repackage.g84
    public void z(String str, String str2, String str3, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048614, this, new Object[]{str, str2, str3, Boolean.valueOf(z)}) == null) {
            zx1.j(str, str2, str3, z);
        }
    }
}
