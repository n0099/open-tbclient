package d.a.q0.a.g1;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.util.Pair;
import android.widget.AbsoluteLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.aop.annotation.DebugTrace;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.console.property.SwanAppPropertyWindow;
import com.baidu.swan.apps.res.ui.FullScreenFloatView;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.g1.e;
import d.a.q0.a.k;
import d.a.q0.a.p.b.a.n;
import d.a.q0.a.v2.q0;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes8.dex */
public final class f implements e.b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f47856b;

    /* renamed from: c  reason: collision with root package name */
    public static AtomicLong f47857c;

    /* renamed from: d  reason: collision with root package name */
    public static volatile f f47858d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d f47859a;

    /* loaded from: classes8.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes8.dex */
    public class b extends d.a.q0.a.g1.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // d.a.q0.a.g1.b
        public void R() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                super.R();
            }
        }

        @Override // d.a.q0.a.g1.d
        public boolean j() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f47830h : invokeV.booleanValue;
        }

        public /* synthetic */ b(f fVar, a aVar) {
            this(fVar);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(116041281, "Ld/a/q0/a/g1/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(116041281, "Ld/a/q0/a/g1/f;");
                return;
            }
        }
        f47856b = k.f49133a;
        f47857c = new AtomicLong(0L);
    }

    public f() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f47859a = new b(this, null);
    }

    public static f V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f47858d == null) {
                synchronized (f.class) {
                    if (f47858d == null) {
                        f47858d = new f();
                    }
                }
            }
            return f47858d;
        }
        return (f) invokeV.objValue;
    }

    public static synchronized void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            synchronized (f.class) {
                if (f47858d == null) {
                    return;
                }
                if (f47858d.f47859a != null) {
                    f47858d.f47859a.P();
                }
                f47858d = null;
            }
        }
    }

    public String A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f47859a.A() : (String) invokeV.objValue;
    }

    public d.a.q0.a.p.e.d B(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) ? this.f47859a.B(str) : (d.a.q0.a.p.e.d) invokeL.objValue;
    }

    public AbsoluteLayout C(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) ? this.f47859a.C(str) : (AbsoluteLayout) invokeL.objValue;
    }

    public String D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f47859a.D() : (String) invokeV.objValue;
    }

    public void E(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, context) == null) {
            this.f47859a.E(context);
        }
    }

    @Nullable
    public d.a.q0.a.a2.e F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f47859a.F() : (d.a.q0.a.a2.e) invokeV.objValue;
    }

    public void G(d.a.q0.a.f1.e.b bVar, d.a.q0.a.a1.b bVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, bVar, bVar2) == null) {
            this.f47859a.G(bVar, bVar2);
        }
    }

    public d.a.q0.a.p.b.a.k H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f47859a.H() : (d.a.q0.a.p.b.a.k) invokeV.objValue;
    }

    public d.a.q0.a.k2.f.d I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f47859a.I() : (d.a.q0.a.k2.f.d) invokeV.objValue;
    }

    public d.a.q0.a.h0.g.f J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f47859a.J() : (d.a.q0.a.h0.g.f) invokeV.objValue;
    }

    public SwanAppPropertyWindow L(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, activity)) == null) ? this.f47859a.L(activity) : (SwanAppPropertyWindow) invokeL.objValue;
    }

    public SwanCoreVersion N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f47859a.N() : (SwanCoreVersion) invokeV.objValue;
    }

    public boolean O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f47859a.O() : invokeV.booleanValue;
    }

    public void R(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048589, this, i2) == null) || a0()) {
            return;
        }
        if (i2 == 0) {
            this.f47859a = new c();
        } else if (i2 != 1) {
        } else {
            this.f47859a = d.a.q0.a.c1.b.a();
        }
    }

    public void S() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            long decrementAndGet = f47857c.decrementAndGet();
            SwanAppActivity x = d.a.q0.a.a2.d.g().x();
            if (decrementAndGet <= 0 && x != null && x.isBackground()) {
                this.f47859a.K();
            }
            if (f47856b) {
                StringBuilder sb = new StringBuilder();
                sb.append("decrementBgThreadAliveCount: count = ");
                sb.append(decrementAndGet);
                sb.append("isBackground = ");
                sb.append(x != null && x.isBackground());
                Log.i("SwanAppController", sb.toString());
            }
        }
    }

    public long T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? f47857c.get() : invokeV.longValue;
    }

    public String U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? q0.n().h() : (String) invokeV.objValue;
    }

    @Nullable
    public d.a.q0.a.h0.g.g W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            SwanAppActivity activity = V().getActivity();
            if (activity == null) {
                return null;
            }
            return activity.getSwanAppFragmentManager();
        }
        return (d.a.q0.a.h0.g.g) invokeV.objValue;
    }

    public n X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f47859a.Q() : (n) invokeV.objValue;
    }

    public n Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f47859a.M() : (n) invokeV.objValue;
    }

    public boolean Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? a0() && this.f47859a.getActivity() != null : invokeV.booleanValue;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.f47859a.a() : (String) invokeV.objValue;
    }

    public boolean a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            d dVar = this.f47859a;
            return (dVar == null || (dVar instanceof b)) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            this.f47859a.b();
        }
    }

    public void b0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            long incrementAndGet = f47857c.incrementAndGet();
            if (f47856b) {
                Log.i("SwanAppController", "incrementBgThreadAliveCount: " + incrementAndGet);
            }
        }
    }

    public void c(d.a.q0.a.f1.e.b bVar, d.a.q0.a.a1.b bVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048601, this, bVar, bVar2) == null) {
            this.f47859a.c(bVar, bVar2);
        }
    }

    @NonNull
    public d.a.q0.a.a2.n.g d(String str, SwanAppConfigData swanAppConfigData, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048602, this, str, swanAppConfigData, str2)) == null) ? this.f47859a.d(str, swanAppConfigData, str2) : (d.a.q0.a.a2.n.g) invokeLLL.objValue;
    }

    @NonNull
    public d.a.q0.a.a2.n.g e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, str)) == null) ? this.f47859a.e(str) : (d.a.q0.a.a2.n.g) invokeL.objValue;
    }

    public void exit() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            this.f47859a.exit();
        }
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.f47859a.f() : (String) invokeV.objValue;
    }

    @Override // d.a.q0.a.g1.e.b
    public void g(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048606, this, i2) == null) {
            this.f47859a.g(i2);
        }
    }

    public SwanAppActivity getActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.f47859a.getActivity() : (SwanAppActivity) invokeV.objValue;
    }

    public d.a.q0.a.p.e.c h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.f47859a.h() : (d.a.q0.a.p.e.c) invokeV.objValue;
    }

    public d.a.q0.a.a2.n.g i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048609, this, str)) == null) ? this.f47859a.i(str) : (d.a.q0.a.a2.n.g) invokeL.objValue;
    }

    public void k(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, context) == null) {
            this.f47859a.k(context);
        }
    }

    public void l(SwanAppActivity swanAppActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, swanAppActivity) == null) {
            if (swanAppActivity != null && !a0()) {
                R(swanAppActivity.getFrameType());
            }
            if (a0()) {
                this.f47859a.l(swanAppActivity);
            }
        }
    }

    public void m(String str, d.a.q0.a.o0.d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048612, this, str, aVar) == null) {
            this.f47859a.m(str, aVar);
        }
    }

    public FullScreenFloatView n(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048613, this, activity)) == null) ? this.f47859a.n(activity) : (FullScreenFloatView) invokeL.objValue;
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            this.f47859a.o();
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            this.f47859a.p();
        }
    }

    @DebugTrace
    public d.a.q0.a.p.e.a q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? this.f47859a.q() : (d.a.q0.a.p.e.a) invokeV.objValue;
    }

    @NonNull
    public Pair<Integer, Integer> r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) ? this.f47859a.r() : (Pair) invokeV.objValue;
    }

    public SwanAppConfigData s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) ? this.f47859a.s() : (SwanAppConfigData) invokeV.objValue;
    }

    public void t(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, intent) == null) {
            this.f47859a.t(intent);
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            this.f47859a.u();
        }
    }

    public void v(d.a.q0.a.o0.d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, aVar) == null) {
            this.f47859a.v(aVar);
        }
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            this.f47859a.w();
        }
    }

    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
            this.f47859a.x();
        }
    }

    @NonNull
    public Pair<Integer, Integer> y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) ? this.f47859a.y() : (Pair) invokeV.objValue;
    }

    public void z(d.a.q0.a.o0.d.d dVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048625, this, dVar, z) == null) {
            this.f47859a.z(dVar, z);
        }
    }
}
