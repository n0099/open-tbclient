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
import com.repackage.hb4;
import com.repackage.j94;
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
/* loaded from: classes7.dex */
public class wj2 implements p74 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Set a;
        public final /* synthetic */ jc4 b;

        /* renamed from: com.repackage.wj2$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C0605a extends c32 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ AtomicInteger a;
            public final /* synthetic */ a b;

            public C0605a(a aVar, AtomicInteger atomicInteger) {
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

            @Override // com.repackage.c32
            public void d() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.get() == 0) {
                    kc4.a().c(this.b.b);
                }
            }

            @Override // com.repackage.c32
            public void f(a94 a94Var) {
                int i;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, a94Var) == null) {
                    super.f(a94Var);
                    if (a94Var == null || (i = a94Var.a) == 1010 || i == 1015) {
                        return;
                    }
                    this.a.incrementAndGet();
                }
            }

            @Override // com.repackage.c32
            public void h() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.a.get() == 0) {
                    kc4.a().c(this.b.b);
                }
            }
        }

        public a(wj2 wj2Var, Set set, jc4 jc4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wj2Var, set, jc4Var};
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
            this.b = jc4Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ArrayList arrayList = new ArrayList();
                AtomicInteger atomicInteger = new AtomicInteger(0);
                for (String str : this.a) {
                    if (!TextUtils.isEmpty(str)) {
                        arrayList.add(new hb4.a(str, 0));
                    }
                }
                if (arrayList.isEmpty()) {
                    return;
                }
                yy1.b(arrayList, "3", new C0605a(this, atomicInteger));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q83 a;
        public final /* synthetic */ JSONObject b;

        public b(wj2 wj2Var, q83 q83Var, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wj2Var, q83Var, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = q83Var;
            this.b = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                es2.g().q(this.a, this.b);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements u12<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h94 a;

        public c(wj2 wj2Var, h94 h94Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wj2Var, h94Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = h94Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.u12
        /* renamed from: b */
        public void a(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bool) == null) {
                aw2.b("download plugin result = " + bool);
                bw2.b(this.a.g);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755199534, "Lcom/repackage/wj2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755199534, "Lcom/repackage/wj2;");
                return;
            }
        }
        boolean z = sg1.a;
    }

    public wj2() {
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

    @Override // com.repackage.p74
    public qa4 A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? pj2.r0() : (qa4) invokeV.objValue;
    }

    @Override // com.repackage.p74
    public int B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? hw2.t() : invokeV.intValue;
    }

    @Override // com.repackage.p74
    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            he3.k().m();
        }
    }

    @Override // com.repackage.p74
    public void D(vb4 vb4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, vb4Var) == null) || vb4Var == null) {
            return;
        }
        try {
            JSONObject b2 = vb4Var.b();
            JSONArray a2 = vb4Var.a();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("threshold", b2.optInt("threshold"));
            jSONObject.put("timeup", b2.optInt("timeup"));
            jSONObject.put("item", a2.toString());
            if (i03.v) {
                Log.d(Node.TAG, "ceres adapted config " + jSONObject);
            }
            yf4 yf4Var = new yf4("0", jSONObject);
            yf4Var.e();
            vf4.f().o(yf4Var);
        } catch (JSONException e) {
            if (i03.v) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.repackage.p74
    public String E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? pj2.o().q() : (String) invokeV.objValue;
    }

    @Override // com.repackage.p74
    public int F(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048581, this, str, i)) == null) {
            pj2.g0().getSwitch(str, i);
            return i;
        }
        return invokeLI.intValue;
    }

    @Override // com.repackage.p74
    public void G(String str, String str2, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048582, this, str, str2, th) == null) {
            ix1.l(str, str2, th);
        }
    }

    @Override // com.repackage.p74
    public void H(jc4 jc4Var) {
        Set<String> b2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, jc4Var) == null) || jc4Var == null || (b2 = jc4Var.b()) == null || b2.size() <= 0) {
            return;
        }
        ExecutorUtilsExt.postOnElastic(new a(this, b2, jc4Var), "preloadPkg", 2);
    }

    @Override // com.repackage.p74
    public String I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? ex1.m() : (String) invokeV.objValue;
    }

    @Override // com.repackage.p74
    public String J(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) ? n93.h(i) : (String) invokeI.objValue;
    }

    @Override // com.repackage.p74
    public void K(String str, String str2, String str3, int i, JSONObject jSONObject, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{str, str2, str3, Integer.valueOf(i), jSONObject, Boolean.valueOf(z)}) == null) {
            n73.d(str, str2, str3, i, jSONObject, z);
        }
    }

    @Override // com.repackage.p74
    public void L(String str, String str2, String str3, @Nullable Throwable th, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{str, str2, str3, th, Boolean.valueOf(z)}) == null) {
            ix1.e(str, str2, str3, th, z);
        }
    }

    @Override // com.repackage.p74
    public p94 M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? h03.K().N() : (p94) invokeV.objValue;
    }

    @Override // com.repackage.p74
    public float a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? pj2.m().a() : invokeV.floatValue;
    }

    @Override // com.repackage.p74
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? tg1.a() : (String) invokeV.objValue;
    }

    @Override // com.repackage.p74
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? pj2.n().a() : (String) invokeV.objValue;
    }

    @Override // com.repackage.p74
    public void d(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, bArr) == null) {
            pj2.e().d(bArr);
        }
    }

    @Override // com.repackage.p74
    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? sg4.b(AppRuntime.getAppContext()).a() : (String) invokeV.objValue;
    }

    @Override // com.repackage.p74
    public CookieManager f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? pj2.q().a() : (CookieManager) invokeV.objValue;
    }

    @Override // com.repackage.p74
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? pj2.h0().i(AppRuntime.getAppContext()) : (String) invokeV.objValue;
    }

    @Override // com.repackage.p74
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? ce3.D() : (String) invokeV.objValue;
    }

    @Override // com.repackage.p74
    public ig4 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? w83.b("swan_app_pms_sp") : (ig4) invokeV.objValue;
    }

    @Override // com.repackage.p74
    public long j(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048598, this, i)) == null) ? ra2.d(i) : invokeI.longValue;
    }

    @Override // com.repackage.p74
    public void k(JSONArray jSONArray, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048599, this, jSONArray, str, str2) == null) {
            v23.b().n(jSONArray, str, str2);
        }
    }

    @Override // com.repackage.p74
    public List<z84> l(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048600, this, str, j)) == null) ? pv2.e(str, j) : (List) invokeLJ.objValue;
    }

    @Override // com.repackage.p74
    public void m(String str, String str2, j94.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048601, this, str, str2, cVar) == null) {
            pj2.e().f(str, str2, cVar);
        }
    }

    @Override // com.repackage.p74
    public p94 n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? new u32(h03.K()) : (p94) invokeV.objValue;
    }

    @Override // com.repackage.p74
    public boolean o(boolean z, @NonNull JSONArray jSONArray) {
        InterceptResult invokeZL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZL = interceptable.invokeZL(1048603, this, z, jSONArray)) == null) ? new te3(z).c(jSONArray) : invokeZL.booleanValue;
    }

    @Override // com.repackage.p74
    public void p(String str, JSONObject jSONObject, f94 f94Var, List<g94> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048604, this, str, jSONObject, f94Var, list) == null) {
            mq2.g(str, jSONObject, f94Var, list);
        }
    }

    @Override // com.repackage.p74
    public String q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? pj2.g0().k() : (String) invokeV.objValue;
    }

    @Override // com.repackage.p74
    public boolean r(@Nullable h94 h94Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, h94Var)) == null) {
            File g = pv2.g(h94Var);
            return g != null && g.exists();
        }
        return invokeL.booleanValue;
    }

    @Override // com.repackage.p74
    public void s(PMSAppInfo pMSAppInfo, JSONObject jSONObject, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048607, this, pMSAppInfo, jSONObject, z) == null) {
            if (pMSAppInfo == null) {
                if (i03.v) {
                    Log.e("SwanAppUpdateManager", "pms app info is null");
                    return;
                }
                return;
            }
            String str = pMSAppInfo.appKey;
            if (!TextUtils.isEmpty(str) && jSONObject != null) {
                int i = pMSAppInfo.type;
                q83 b2 = w83.b(q73.u(str, i));
                b2.putBoolean("swan_service_update_degraded", z);
                ix1.k("SwanAppUpdateManager", "update async appKey = " + str + " ; type = " + i + " ; serviceDegraded = " + z);
                cd3.l(new b(this, b2, jSONObject), "parseAccreditList");
            } else if (i03.v) {
                Log.e("SwanAppUpdateManager", "appKey = " + str + " is empty or accredit list is null");
            }
        }
    }

    @Override // com.repackage.p74
    public void t(yc4 yc4Var, od4 od4Var) {
        Collection<h94> collection;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048608, this, yc4Var, od4Var) == null) || yc4Var == null || (collection = yc4Var.e) == null || od4Var == null) {
            return;
        }
        for (h94 h94Var : collection) {
            ov2 ov2Var = new ov2(h94Var.g, h94Var.j, h94Var.i, new c(this, h94Var));
            yc4 yc4Var2 = new yc4();
            yc4Var2.e = new ArrayList();
            od4 od4Var2 = new od4();
            zc4.b(h94Var, od4Var2);
            ov2Var.G(od4Var2);
            yc4Var2.e.clear();
            yc4Var2.e.add(h94Var);
            r94.e(yc4Var2, ov2Var);
        }
    }

    @Override // com.repackage.p74
    public String u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? iu2.b() : (String) invokeV.objValue;
    }

    @Override // com.repackage.p74
    public String v(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048610, this, i)) == null) ? ra2.e(i) : (String) invokeI.objValue;
    }

    @Override // com.repackage.p74
    public long w(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048611, this, i)) == null) ? n93.f(i) : invokeI.longValue;
    }

    @Override // com.repackage.p74
    public boolean x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            aw2.c("线下调试需要禁用BDTLS");
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.p74
    public void y(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048613, this, str, str2) == null) {
            ix1.k(str, str2);
        }
    }

    @Override // com.repackage.p74
    public void z(String str, String str2, String str3, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048614, this, new Object[]{str, str2, str3, Boolean.valueOf(z)}) == null) {
            ix1.j(str, str2, str3, z);
        }
    }
}
