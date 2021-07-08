package d.a.n0.a.a2;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.extcore.cores.SwanAppCores;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.n0.a.a2.i;
import d.a.n0.a.f1.e.b;
import d.a.n0.a.v2.q0;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes7.dex */
public class e extends m {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean y;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public final String f43381f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f43382g;

    /* renamed from: h  reason: collision with root package name */
    public SwanAppConfigData f43383h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.n0.a.a2.n.a f43384i;
    public d.a.n0.a.k2.c j;
    public d.a.n0.a.k2.f.d k;
    public d.a.n0.a.e2.a l;
    public d.a.n0.a.m.b m;
    public d.a.n0.a.n1.j n;
    public HttpManager o;
    public d.a.n0.a.b2.a.a p;
    public d.a.n0.a.i1.c.c q;
    public d.a.n0.a.n1.k r;
    public g s;
    public Map<String, String> t;
    public final k u;
    public final b.a v;
    public boolean w;
    public String x;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(700070430, "Ld/a/n0/a/a2/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(700070430, "Ld/a/n0/a/a2/e;");
                return;
            }
        }
        y = d.a.n0.a.k.f45831a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(h hVar, String str) {
        super(hVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {hVar, str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((h) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.u = new k(this);
        this.v = new b.a();
        boolean z = false;
        this.w = false;
        str = str == null ? "" : str;
        this.f43381f = str;
        z = (!TextUtils.isEmpty(str) || TextUtils.equals(this.f43381f, "swan_id_unknown")) ? true : true;
        this.f43382g = z;
        if (z) {
            d.a.n0.a.b2.a.a aVar = new d.a.n0.a.b2.a.a();
            this.p = aVar;
            aVar.f(this.f43381f);
        }
        d.a.n0.a.e0.d.h("SwanApp", "new SwanApp id = " + this.f43381f + StringUtil.ARRAY_ELEMENT_SEPARATOR + Log.getStackTraceString(new RuntimeException("SwanApp log")));
    }

    public static e Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            d g2 = d.g();
            if (g2.C()) {
                return g2.r();
            }
            return null;
        }
        return (e) invokeV.objValue;
    }

    @Deprecated
    public static String V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? d.g().getAppId() : (String) invokeV.objValue;
    }

    @Deprecated
    public static e i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? Q() : (e) invokeV.objValue;
    }

    @Override // d.a.n0.a.a2.m, d.a.n0.a.a2.h
    public void A(i.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            super.A((i.a) aVar.D(H()));
        }
    }

    @Override // d.a.n0.a.a2.m, d.a.n0.a.a2.h
    public boolean C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f43382g : invokeV.booleanValue;
    }

    public String D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? L().I() : (String) invokeV.objValue;
    }

    public d.a.n0.a.i1.c.c E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.q == null) {
                this.q = new d.a.n0.a.i1.c.c(this);
            }
            return this.q;
        }
        return (d.a.n0.a.i1.c.c) invokeV.objValue;
    }

    public SwanAppConfigData F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f43383h : (SwanAppConfigData) invokeV.objValue;
    }

    public String G(String str) {
        InterceptResult invokeL;
        SwanAppConfigData.k kVar;
        Map<String, String> map;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            SwanAppConfigData swanAppConfigData = this.f43383h;
            if (swanAppConfigData == null || (kVar = swanAppConfigData.f11476d) == null || (map = kVar.f11514a) == null) {
                return null;
            }
            return map.get(str);
        }
        return (String) invokeL.objValue;
    }

    public final Bundle H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            Bundle bundle = new Bundle();
            bundle.putString("mAppId", this.f43381f);
            return bundle;
        }
        return (Bundle) invokeV.objValue;
    }

    public d.a.n0.a.a2.n.a I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f43384i : (d.a.n0.a.a2.n.a) invokeV.objValue;
    }

    @NonNull
    public g J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.s == null) {
                this.s = new g(this);
            }
            return this.s;
        }
        return (g) invokeV.objValue;
    }

    public String K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            b.a L = L();
            return L != null ? h(L.t1()) : "0";
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    public b.a L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.v : (b.a) invokeV.objValue;
    }

    @Nullable
    public String M(String str) {
        InterceptResult invokeL;
        Map<String, String> map;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
            if (TextUtils.isEmpty(str) || (map = this.t) == null) {
                return null;
            }
            return map.get(str);
        }
        return (String) invokeL.objValue;
    }

    @NonNull
    @Deprecated
    public b.a N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? L() : (b.a) invokeV.objValue;
    }

    public String O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? L().K() : (String) invokeV.objValue;
    }

    public synchronized d.a.n0.a.n1.j P() {
        InterceptResult invokeV;
        d.a.n0.a.n1.j jVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            synchronized (this) {
                if (this.n == null) {
                    this.n = new d.a.n0.a.n1.j(this);
                }
                jVar = this.n;
            }
            return jVar;
        }
        return (d.a.n0.a.n1.j) invokeV.objValue;
    }

    public String R(String str) {
        InterceptResult invokeL;
        SwanAppConfigData.j jVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, str)) == null) {
            SwanAppConfigData swanAppConfigData = this.f43383h;
            if (swanAppConfigData == null || (jVar = swanAppConfigData.f11475c) == null || jVar.f11510c == null) {
                return null;
            }
            return this.f43383h.f11475c.f11510c.get(d.a.n0.a.c2.f.p0.j.b(str));
        }
        return (String) invokeL.objValue;
    }

    public String S(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, str)) == null) {
            SwanAppConfigData swanAppConfigData = this.f43383h;
            return swanAppConfigData != null ? swanAppConfigData.g(str) : "";
        }
        return (String) invokeL.objValue;
    }

    @NonNull
    public d.a.n0.a.e2.a T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (this.l == null) {
                this.l = new d.a.n0.a.e2.a(this);
            }
            return this.l;
        }
        return (d.a.n0.a.e2.a) invokeV.objValue;
    }

    public d.a.n0.a.k2.c U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.j == null) {
                this.j = new d.a.n0.a.k2.c(this);
            }
            return this.j;
        }
        return (d.a.n0.a.k2.c) invokeV.objValue;
    }

    public d.a.n0.a.k2.f.d W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            if (this.k == null) {
                if (m0()) {
                    this.k = new d.a.n0.a.r0.l();
                } else {
                    this.k = new d.a.n0.a.k2.f.f();
                }
            }
            return this.k;
        }
        return (d.a.n0.a.k2.f.d) invokeV.objValue;
    }

    public synchronized HttpManager X() {
        InterceptResult invokeV;
        HttpManager httpManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            synchronized (this) {
                if (this.o == null) {
                    this.o = d.a.n0.a.c1.b.l().b();
                }
                httpManager = this.o;
            }
            return httpManager;
        }
        return (HttpManager) invokeV.objValue;
    }

    public String Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.x : (String) invokeV.objValue;
    }

    public String Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? L().u1() : (String) invokeV.objValue;
    }

    public d.a.n0.a.b2.a.a a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            if (this.p == null) {
                this.p = new d.a.n0.a.b2.a.a();
            }
            return this.p;
        }
        return (d.a.n0.a.b2.a.a) invokeV.objValue;
    }

    public d.a.n0.a.n1.k b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            if (this.r == null) {
                this.r = new d.a.n0.a.n1.k();
            }
            return this.r;
        }
        return (d.a.n0.a.n1.k) invokeV.objValue;
    }

    public boolean c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            d.a.n0.a.e0.d.h("SwanApp", "SwanAppActivity isAppHasLaunch:" + this.x);
            return h.g0.contains(this.x);
        }
        return invokeV.booleanValue;
    }

    public boolean d0() {
        InterceptResult invokeV;
        d.a.n0.a.t0.c frame;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            if (d.a.n0.a.h0.o.e.a.f()) {
                SwanAppActivity x = x();
                if (x == null || x.isFinishing() || x.isDestroyed() || (frame = x.getFrame()) == null) {
                    return true;
                }
                return !frame.P().hasStarted();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.f43382g && this.u.b0() && l() > -1 : invokeV.booleanValue;
    }

    public boolean e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? g0(d.a.n0.a.g1.f.V().U()) : invokeV.booleanValue;
    }

    public e f(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048605, this, z)) == null) {
            this.w = z;
            q("event_first_action_launched");
            return this;
        }
        return (e) invokeZ.objValue;
    }

    public boolean f0() {
        InterceptResult invokeV;
        d.a.n0.a.t0.c frame;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            SwanAppActivity x = x();
            if (x == null || (frame = x.getFrame()) == null) {
                return false;
            }
            return frame.P().hasCreated();
        }
        return invokeV.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.w : invokeV.booleanValue;
    }

    public boolean g0(String str) {
        InterceptResult invokeL;
        SwanAppConfigData swanAppConfigData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048608, this, str)) == null) {
            if (TextUtils.isEmpty(str) || (swanAppConfigData = this.f43383h) == null) {
                return false;
            }
            return swanAppConfigData.n(str);
        }
        return invokeL.booleanValue;
    }

    @Override // d.a.n0.a.a2.m, d.a.n0.a.a2.h
    public String getAppId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.f43381f : (String) invokeV.objValue;
    }

    public final String h(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048610, this, i2)) == null) {
            if (i2 == 0) {
                b.a aVar = this.v;
                String v1 = aVar != null ? aVar.v1() : "";
                if (TextUtils.isEmpty(v1)) {
                    v1 = Z();
                }
                String f2 = q0.f(v1);
                Object[] objArr = new Object[1];
                objArr[0] = TextUtils.isEmpty(f2) ? " version is empty " : f2;
                d.a.n0.a.e0.d.a("SwanApp", objArr);
                return f2;
            }
            return "0";
        }
        return (String) invokeI.objValue;
    }

    public boolean h0(String str) {
        InterceptResult invokeL;
        SwanAppConfigData swanAppConfigData;
        SwanAppConfigData.d dVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048611, this, str)) == null) {
            if (TextUtils.isEmpty(str) || (swanAppConfigData = this.f43383h) == null || (dVar = swanAppConfigData.f11474b) == null) {
                return false;
            }
            return dVar.c(str);
        }
        return invokeL.booleanValue;
    }

    public boolean i0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.u.a0() : invokeV.booleanValue;
    }

    public d.a.n0.a.m.b j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            if (this.m == null) {
                this.m = new d.a.n0.a.m.b(this);
            }
            return this.m;
        }
        return (d.a.n0.a.m.b) invokeV.objValue;
    }

    public boolean j0(String str) {
        InterceptResult invokeL;
        SwanAppConfigData swanAppConfigData;
        SwanAppConfigData.j jVar;
        Map<String, Boolean> map;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048614, this, str)) == null) {
            if (TextUtils.isEmpty(str) || (swanAppConfigData = this.f43383h) == null || (jVar = swanAppConfigData.f11475c) == null || (map = jVar.f11509b) == null || !map.containsKey(str)) {
                return false;
            }
            if (y) {
                Log.i("SwanApp", "内存中查询分包是否存在信息");
            }
            return this.f43383h.f11475c.f11509b.get(str).booleanValue();
        }
        return invokeL.booleanValue;
    }

    @Deprecated
    public Activity k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? x() : (Activity) invokeV.objValue;
    }

    public boolean k0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048616, this, str)) == null) ? new File(d.a.n0.a.g1.f.V().A(), str).exists() : invokeL.booleanValue;
    }

    @Override // d.a.n0.a.a2.m, d.a.n0.a.a2.h
    public int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            if (this.f43382g) {
                return L().G();
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public boolean l0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048618, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return d.a.n0.n.g.a.h().m(this.f43381f, Z(), str);
        }
        return invokeL.booleanValue;
    }

    public boolean m0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) ? L().G() == 1 : invokeV.booleanValue;
    }

    @Override // d.a.n0.a.a2.m, d.a.n0.a.a2.h
    public SwanAppCores n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            SwanAppCores swanAppCores = new SwanAppCores();
            swanAppCores.setSwanCoreVersion(L().i0());
            swanAppCores.setExtensionCore(L().O());
            return swanAppCores;
        }
        return (SwanAppCores) invokeV.objValue;
    }

    public boolean n0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) ? TextUtils.equals("update_tag_by_app_launch", this.x) : invokeV.booleanValue;
    }

    public void o0(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, activity) == null) {
            T().w(activity);
        }
    }

    public String p0(String... strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048623, this, strArr)) == null) {
            if (y) {
                Log.d("SwanApp", "——> release client Id " + this.f43381f);
            }
            SwanAppActivity x = x();
            if (x != null && !x.isDestroyed() && !x.isFinishing() && x.hasActivedFrame()) {
                x.reset(strArr);
            }
            d.a.n0.a.g1.f.c0();
            g gVar = this.s;
            if (gVar != null) {
                gVar.g();
            }
            d.a.n0.t.d.j(d.a.n0.a.k2.b.x(this.f43381f));
            d.a.n0.a.i1.c.c cVar = this.q;
            if (cVar != null) {
                cVar.E();
            }
            d.a.n0.a.b2.a.a aVar = this.p;
            if (aVar != null) {
                aVar.g();
            }
            d.a.n0.a.n1.k kVar = this.r;
            if (kVar != null) {
                kVar.d();
            }
            this.j = null;
            this.l = null;
            this.o = null;
            this.w = false;
            return this.f43381f;
        }
        return (String) invokeL.objValue;
    }

    @Override // d.a.n0.a.a2.m, d.a.n0.a.a2.h
    public void q(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, str) == null) {
            w(str, H());
        }
    }

    public boolean q0(Bundle bundle, String str, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048625, this, bundle, str, z)) == null) {
            boolean contains = h.g0.contains(str);
            b.a L = L();
            HybridUbcFlow p = d.a.n0.a.r1.h.p("startup");
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("swan_app_update_info_start");
            ubcFlowEvent.a(true);
            p.C(ubcFlowEvent);
            if (TextUtils.equals("update_tag_by_activity_on_new_intent", str) && this.u.b0() && f0()) {
                if (L.c("swanCoreVersion")) {
                    bundle.remove("swanCoreVersion");
                    bundle.remove("extensionCore");
                }
                if (L.c("pms_db_info_onload")) {
                    bundle.remove("pms_db_info_onload");
                }
            }
            bundle.putBoolean("launch_by_reload", TextUtils.equals("update_tag_by_activity_on_relaunch", str));
            L.D(bundle);
            UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("swan_app_update_info_end");
            ubcFlowEvent2.a(true);
            p.C(ubcFlowEvent2);
            if (z) {
                q("event_on_app_occupied");
            }
            if (this.f43382g && !this.u.b0() && !this.u.a0()) {
                UbcFlowEvent ubcFlowEvent3 = new UbcFlowEvent("swan_app_maintain_start");
                ubcFlowEvent3.a(true);
                p.C(ubcFlowEvent3);
                this.u.f0();
                UbcFlowEvent ubcFlowEvent4 = new UbcFlowEvent("swan_app_maintain_return");
                ubcFlowEvent4.a(true);
                p.C(ubcFlowEvent4);
                return true;
            }
            if (this.u.b0() && contains) {
                k.d0(L, L.f0(), false, false);
            }
            return this.u.a0();
        }
        return invokeLLZ.booleanValue;
    }

    @Override // d.a.n0.a.a2.m, d.a.n0.a.a2.h
    public e r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) ? this : (e) invokeV.objValue;
    }

    public int r0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) ? this.u.i0() : invokeV.intValue;
    }

    public boolean s0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) ? this.u.n0() : invokeV.booleanValue;
    }

    @Override // d.a.n0.a.a2.m, d.a.n0.a.a2.h
    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048629, this) == null) {
            T().l();
            U().d(true);
        }
    }

    public void t0(SwanAppConfigData swanAppConfigData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048630, this, swanAppConfigData) == null) {
            this.f43383h = swanAppConfigData;
        }
    }

    public void u0(d.a.n0.a.a2.n.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048631, this, aVar) == null) {
            this.f43384i = aVar;
        }
    }

    public void v0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048632, this, str) == null) {
            this.x = str;
            d.a.n0.a.e0.d.h("SwanApp", "SwanAppActivity setUpdateTag:" + this.x);
        }
    }

    @Override // d.a.n0.a.a2.m, d.a.n0.a.a2.h
    public void w(String str, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048633, this, str, bundle) == null) {
            if (bundle == null) {
                bundle = H();
            } else {
                bundle.putAll(H());
            }
            super.w(str, bundle);
        }
    }

    public d.a.n0.a.f1.e.b w0(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048634, this, bundle)) == null) {
            b.a L = L();
            L.D(bundle);
            return L;
        }
        return (d.a.n0.a.f1.e.b) invokeL.objValue;
    }

    public void x0(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048635, this, str, str2) == null) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        if (this.t == null) {
            this.t = new HashMap();
        }
        if (y) {
            Log.d("SwanApp", "update initData, page: " + str2 + " initDta : " + str);
        }
        this.t.put(str2, str);
    }

    public void y0(String str, boolean z) {
        SwanAppConfigData swanAppConfigData;
        SwanAppConfigData.j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048636, this, str, z) == null) || TextUtils.isEmpty(str) || (swanAppConfigData = this.f43383h) == null || (jVar = swanAppConfigData.f11475c) == null || jVar.f11509b == null) {
            return;
        }
        if (y) {
            Log.i("SwanApp", "更新内存缓存信息: " + str + ": " + z);
        }
        this.f43383h.f11475c.f11509b.put(str, Boolean.valueOf(z));
    }
}
