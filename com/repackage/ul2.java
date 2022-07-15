package com.repackage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.util.Pair;
import android.view.View;
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
import com.repackage.tl2;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes7.dex */
public final class ul2 implements tl2.b {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public static AtomicLong c;
    public static final Lock d;
    public static volatile ul2 e;
    public transient /* synthetic */ FieldHolder $fh;
    public sl2 a;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public class b extends ql2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(ul2 ul2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ul2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.ql2
        public void Q() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                super.Q();
            }
        }

        @Override // com.repackage.sl2
        public boolean k() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.h : invokeV.booleanValue;
        }

        public /* synthetic */ b(ul2 ul2Var, a aVar) {
            this(ul2Var);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755257194, "Lcom/repackage/ul2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755257194, "Lcom/repackage/ul2;");
                return;
            }
        }
        b = rg1.a;
        c = new AtomicLong(0L);
        d = new ReentrantLock();
    }

    public ul2() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new b(this, null);
    }

    public static ul2 U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            d.lock();
            try {
                if (e == null) {
                    e = new ul2();
                }
                return e;
            } finally {
                d.unlock();
            }
        }
        return (ul2) invokeV.objValue;
    }

    public static void b0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            d.lock();
            try {
                if (e == null) {
                    return;
                }
                if (e.a != null) {
                    e.a.O();
                }
                e = null;
            } finally {
                d.unlock();
            }
        }
    }

    public pm1 A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? this.a.A(str) : (pm1) invokeL.objValue;
    }

    public View B(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) ? this.a.B(str) : (View) invokeL.objValue;
    }

    public String C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a.C() : (String) invokeV.objValue;
    }

    @Nullable
    public h03 D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.a.D() : (h03) invokeV.objValue;
    }

    public void E(el2 el2Var, bj2 bj2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, el2Var, bj2Var) == null) {
            this.a.E(el2Var, bj2Var);
        }
    }

    public vh1 F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.a.F() : (vh1) invokeV.objValue;
    }

    public k83 G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.a.G() : (k83) invokeV.objValue;
    }

    public pz1 H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.a.H() : (pz1) invokeV.objValue;
    }

    public SwanAppPropertyWindow J(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, activity)) == null) ? this.a.J(activity) : (SwanAppPropertyWindow) invokeL.objValue;
    }

    public void K(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.a.K(str);
        }
    }

    public SwanCoreVersion M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.a.M() : (SwanCoreVersion) invokeV.objValue;
    }

    public boolean N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.a.N() : invokeV.booleanValue;
    }

    public void Q(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048588, this, i) == null) || Z()) {
            return;
        }
        if (i == 0) {
            this.a = new rl2();
        } else if (i != 1) {
        } else {
            this.a = pj2.a();
        }
    }

    public void R() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            long decrementAndGet = c.decrementAndGet();
            SwanAppActivity w = g03.K().w();
            if (decrementAndGet <= 0 && w != null && w.e0()) {
                this.a.I();
            }
            if (b) {
                StringBuilder sb = new StringBuilder();
                sb.append("decrementBgThreadAliveCount: count = ");
                sb.append(decrementAndGet);
                sb.append("isBackground = ");
                sb.append(w != null && w.e0());
                Log.i("SwanAppController", sb.toString());
            }
        }
    }

    public long S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? c.get() : invokeV.longValue;
    }

    public String T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? be3.n().e() : (String) invokeV.objValue;
    }

    @Nullable
    public qz1 V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            SwanAppActivity activity = U().getActivity();
            if (activity == null) {
                return null;
            }
            return activity.X();
        }
        return (qz1) invokeV.objValue;
    }

    public yh1 W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.a.P() : (yh1) invokeV.objValue;
    }

    public yh1 X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.a.L() : (yh1) invokeV.objValue;
    }

    public boolean Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? Z() && this.a.getActivity() != null : invokeV.booleanValue;
    }

    public boolean Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            sl2 sl2Var = this.a;
            return (sl2Var == null || (sl2Var instanceof b)) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            this.a.a();
        }
    }

    public void a0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            long incrementAndGet = c.incrementAndGet();
            if (b) {
                Log.i("SwanAppController", "incrementBgThreadAliveCount: " + incrementAndGet);
            }
        }
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.a.b() : (String) invokeV.objValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            this.a.c();
        }
    }

    public void d(el2 el2Var, bj2 bj2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048601, this, el2Var, bj2Var) == null) {
            this.a.d(el2Var, bj2Var);
        }
    }

    @NonNull
    public w03 e(String str, SwanAppConfigData swanAppConfigData, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048602, this, str, swanAppConfigData, str2)) == null) ? this.a.e(str, swanAppConfigData, str2) : (w03) invokeLLL.objValue;
    }

    public void exit() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            this.a.exit();
        }
    }

    @NonNull
    public w03 f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, str)) == null) ? this.a.f(str) : (w03) invokeL.objValue;
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.a.g() : (String) invokeV.objValue;
    }

    public SwanAppActivity getActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.a.getActivity() : (SwanAppActivity) invokeV.objValue;
    }

    @Override // com.repackage.tl2.b
    public void h(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048607, this, i) == null) {
            this.a.h(i);
        }
    }

    public om1 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.a.i() : (om1) invokeV.objValue;
    }

    public w03 j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048609, this, str)) == null) ? this.a.j(str) : (w03) invokeL.objValue;
    }

    public void l(SwanAppActivity swanAppActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, swanAppActivity) == null) {
            if (swanAppActivity != null && !Z()) {
                Q(swanAppActivity.R());
            }
            if (Z()) {
                this.a.l(swanAppActivity);
            }
        }
    }

    public void m(String str, ha2 ha2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048611, this, str, ha2Var) == null) {
            this.a.m(str, ha2Var);
        }
    }

    public FullScreenFloatView n(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048612, this, activity)) == null) ? this.a.n(activity) : (FullScreenFloatView) invokeL.objValue;
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            this.a.o();
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            this.a.p();
        }
    }

    @DebugTrace
    public mm1 q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? this.a.q() : (mm1) invokeV.objValue;
    }

    @NonNull
    public Pair<Integer, Integer> r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? this.a.r() : (Pair) invokeV.objValue;
    }

    public void registerReceiver(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, context) == null) {
            this.a.registerReceiver(context);
        }
    }

    public SwanAppConfigData s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) ? this.a.s() : (SwanAppConfigData) invokeV.objValue;
    }

    public void t(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, intent) == null) {
            this.a.t(intent);
        }
    }

    public void u(ha2 ha2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, ha2Var) == null) {
            this.a.u(ha2Var);
        }
    }

    public void unregisterReceiver(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, context) == null) {
            this.a.unregisterReceiver(context);
        }
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            this.a.v();
        }
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
            this.a.w();
        }
    }

    @NonNull
    public Pair<Integer, Integer> x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) ? this.a.x() : (Pair) invokeV.objValue;
    }

    public void y(ka2 ka2Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048625, this, ka2Var, z) == null) {
            this.a.y(ka2Var, z);
        }
    }

    public String z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) ? this.a.z() : (String) invokeV.objValue;
    }
}
