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
import com.repackage.gb4;
import com.repackage.i94;
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
public class vj2 implements o74 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Set a;
        public final /* synthetic */ ic4 b;

        /* renamed from: com.repackage.vj2$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C0748a extends b32 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ AtomicInteger a;
            public final /* synthetic */ a b;

            public C0748a(a aVar, AtomicInteger atomicInteger) {
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

            @Override // com.repackage.b32
            public void d() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.get() == 0) {
                    jc4.a().c(this.b.b);
                }
            }

            @Override // com.repackage.b32
            public void f(z84 z84Var) {
                int i;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z84Var) == null) {
                    super.f(z84Var);
                    if (z84Var == null || (i = z84Var.a) == 1010 || i == 1015) {
                        return;
                    }
                    this.a.incrementAndGet();
                }
            }

            @Override // com.repackage.b32
            public void h() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.a.get() == 0) {
                    jc4.a().c(this.b.b);
                }
            }
        }

        public a(vj2 vj2Var, Set set, ic4 ic4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vj2Var, set, ic4Var};
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
            this.b = ic4Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ArrayList arrayList = new ArrayList();
                AtomicInteger atomicInteger = new AtomicInteger(0);
                for (String str : this.a) {
                    if (!TextUtils.isEmpty(str)) {
                        arrayList.add(new gb4.a(str, 0));
                    }
                }
                if (arrayList.isEmpty()) {
                    return;
                }
                xy1.b(arrayList, "3", new C0748a(this, atomicInteger));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p83 a;
        public final /* synthetic */ JSONObject b;

        public b(vj2 vj2Var, p83 p83Var, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vj2Var, p83Var, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = p83Var;
            this.b = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ds2.g().q(this.a, this.b);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements t12<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g94 a;

        public c(vj2 vj2Var, g94 g94Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vj2Var, g94Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g94Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.t12
        /* renamed from: b */
        public void a(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bool) == null) {
                zv2.b("download plugin result = " + bool);
                aw2.b(this.a.g);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755229325, "Lcom/repackage/vj2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755229325, "Lcom/repackage/vj2;");
                return;
            }
        }
        boolean z = rg1.a;
    }

    public vj2() {
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

    @Override // com.repackage.o74
    public pa4 A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? oj2.r0() : (pa4) invokeV.objValue;
    }

    @Override // com.repackage.o74
    public int B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? gw2.t() : invokeV.intValue;
    }

    @Override // com.repackage.o74
    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            ge3.k().m();
        }
    }

    @Override // com.repackage.o74
    public void D(ub4 ub4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, ub4Var) == null) || ub4Var == null) {
            return;
        }
        try {
            JSONObject b2 = ub4Var.b();
            JSONArray a2 = ub4Var.a();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("threshold", b2.optInt("threshold"));
            jSONObject.put("timeup", b2.optInt("timeup"));
            jSONObject.put("item", a2.toString());
            if (h03.v) {
                Log.d(Node.TAG, "ceres adapted config " + jSONObject);
            }
            xf4 xf4Var = new xf4("0", jSONObject);
            xf4Var.e();
            uf4.f().o(xf4Var);
        } catch (JSONException e) {
            if (h03.v) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.repackage.o74
    public String E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? oj2.o().q() : (String) invokeV.objValue;
    }

    @Override // com.repackage.o74
    public int F(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048581, this, str, i)) == null) {
            oj2.g0().getSwitch(str, i);
            return i;
        }
        return invokeLI.intValue;
    }

    @Override // com.repackage.o74
    public void G(String str, String str2, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048582, this, str, str2, th) == null) {
            hx1.l(str, str2, th);
        }
    }

    @Override // com.repackage.o74
    public void H(ic4 ic4Var) {
        Set<String> b2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, ic4Var) == null) || ic4Var == null || (b2 = ic4Var.b()) == null || b2.size() <= 0) {
            return;
        }
        ExecutorUtilsExt.postOnElastic(new a(this, b2, ic4Var), "preloadPkg", 2);
    }

    @Override // com.repackage.o74
    public String I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? dx1.m() : (String) invokeV.objValue;
    }

    @Override // com.repackage.o74
    public String J(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) ? m93.h(i) : (String) invokeI.objValue;
    }

    @Override // com.repackage.o74
    public void K(String str, String str2, String str3, int i, JSONObject jSONObject, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{str, str2, str3, Integer.valueOf(i), jSONObject, Boolean.valueOf(z)}) == null) {
            m73.d(str, str2, str3, i, jSONObject, z);
        }
    }

    @Override // com.repackage.o74
    public void L(String str, String str2, String str3, @Nullable Throwable th, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{str, str2, str3, th, Boolean.valueOf(z)}) == null) {
            hx1.e(str, str2, str3, th, z);
        }
    }

    @Override // com.repackage.o74
    public o94 M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? g03.K().N() : (o94) invokeV.objValue;
    }

    @Override // com.repackage.o74
    public float a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? oj2.m().a() : invokeV.floatValue;
    }

    @Override // com.repackage.o74
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? sg1.a() : (String) invokeV.objValue;
    }

    @Override // com.repackage.o74
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? oj2.n().a() : (String) invokeV.objValue;
    }

    @Override // com.repackage.o74
    public void d(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, bArr) == null) {
            oj2.e().d(bArr);
        }
    }

    @Override // com.repackage.o74
    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? rg4.b(AppRuntime.getAppContext()).a() : (String) invokeV.objValue;
    }

    @Override // com.repackage.o74
    public CookieManager f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? oj2.q().a() : (CookieManager) invokeV.objValue;
    }

    @Override // com.repackage.o74
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? oj2.h0().i(AppRuntime.getAppContext()) : (String) invokeV.objValue;
    }

    @Override // com.repackage.o74
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? be3.D() : (String) invokeV.objValue;
    }

    @Override // com.repackage.o74
    public hg4 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? v83.b("swan_app_pms_sp") : (hg4) invokeV.objValue;
    }

    @Override // com.repackage.o74
    public long j(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048598, this, i)) == null) ? qa2.d(i) : invokeI.longValue;
    }

    @Override // com.repackage.o74
    public void k(JSONArray jSONArray, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048599, this, jSONArray, str, str2) == null) {
            u23.b().n(jSONArray, str, str2);
        }
    }

    @Override // com.repackage.o74
    public List<y84> l(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048600, this, str, j)) == null) ? ov2.e(str, j) : (List) invokeLJ.objValue;
    }

    @Override // com.repackage.o74
    public void m(String str, String str2, i94.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048601, this, str, str2, cVar) == null) {
            oj2.e().f(str, str2, cVar);
        }
    }

    @Override // com.repackage.o74
    public o94 n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? new t32(g03.K()) : (o94) invokeV.objValue;
    }

    @Override // com.repackage.o74
    public boolean o(boolean z, @NonNull JSONArray jSONArray) {
        InterceptResult invokeZL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZL = interceptable.invokeZL(1048603, this, z, jSONArray)) == null) ? new se3(z).c(jSONArray) : invokeZL.booleanValue;
    }

    @Override // com.repackage.o74
    public void p(String str, JSONObject jSONObject, e94 e94Var, List<f94> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048604, this, str, jSONObject, e94Var, list) == null) {
            lq2.g(str, jSONObject, e94Var, list);
        }
    }

    @Override // com.repackage.o74
    public String q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? oj2.g0().k() : (String) invokeV.objValue;
    }

    @Override // com.repackage.o74
    public boolean r(@Nullable g94 g94Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, g94Var)) == null) {
            File g = ov2.g(g94Var);
            return g != null && g.exists();
        }
        return invokeL.booleanValue;
    }

    @Override // com.repackage.o74
    public void s(PMSAppInfo pMSAppInfo, JSONObject jSONObject, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048607, this, pMSAppInfo, jSONObject, z) == null) {
            if (pMSAppInfo == null) {
                if (h03.v) {
                    Log.e("SwanAppUpdateManager", "pms app info is null");
                    return;
                }
                return;
            }
            String str = pMSAppInfo.appKey;
            if (!TextUtils.isEmpty(str) && jSONObject != null) {
                int i = pMSAppInfo.type;
                p83 b2 = v83.b(p73.u(str, i));
                b2.putBoolean("swan_service_update_degraded", z);
                hx1.k("SwanAppUpdateManager", "update async appKey = " + str + " ; type = " + i + " ; serviceDegraded = " + z);
                bd3.l(new b(this, b2, jSONObject), "parseAccreditList");
            } else if (h03.v) {
                Log.e("SwanAppUpdateManager", "appKey = " + str + " is empty or accredit list is null");
            }
        }
    }

    @Override // com.repackage.o74
    public void t(xc4 xc4Var, nd4 nd4Var) {
        Collection<g94> collection;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048608, this, xc4Var, nd4Var) == null) || xc4Var == null || (collection = xc4Var.e) == null || nd4Var == null) {
            return;
        }
        for (g94 g94Var : collection) {
            nv2 nv2Var = new nv2(g94Var.g, g94Var.j, g94Var.i, new c(this, g94Var));
            xc4 xc4Var2 = new xc4();
            xc4Var2.e = new ArrayList();
            nd4 nd4Var2 = new nd4();
            yc4.b(g94Var, nd4Var2);
            nv2Var.G(nd4Var2);
            xc4Var2.e.clear();
            xc4Var2.e.add(g94Var);
            q94.e(xc4Var2, nv2Var);
        }
    }

    @Override // com.repackage.o74
    public String u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? hu2.b() : (String) invokeV.objValue;
    }

    @Override // com.repackage.o74
    public String v(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048610, this, i)) == null) ? qa2.e(i) : (String) invokeI.objValue;
    }

    @Override // com.repackage.o74
    public long w(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048611, this, i)) == null) ? m93.f(i) : invokeI.longValue;
    }

    @Override // com.repackage.o74
    public boolean x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            zv2.c("线下调试需要禁用BDTLS");
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.o74
    public void y(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048613, this, str, str2) == null) {
            hx1.k(str, str2);
        }
    }

    @Override // com.repackage.o74
    public void z(String str, String str2, String str3, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048614, this, new Object[]{str, str2, str3, Boolean.valueOf(z)}) == null) {
            hx1.j(str, str2, str3, z);
        }
    }
}
