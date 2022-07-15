package com.repackage;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.aop.annotation.DebugTrace;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.console.property.SwanAppPropertyWindow;
import com.baidu.swan.apps.res.ui.FullScreenFloatView;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.game.ad.downloader.model.DownloadParams;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.el2;
/* loaded from: classes7.dex */
public abstract class ql2 implements sl2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean j;
    public transient /* synthetic */ FieldHolder $fh;
    public mm1 a;
    public r03 b;
    public String c;
    @Deprecated
    public SwanAppActivity d;
    public tl2 e;
    public FullScreenFloatView f;
    public SwanAppPropertyWindow g;
    public boolean h;
    public boolean i;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ ql2 b;

        public a(ql2 ql2Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ql2Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ql2Var;
            this.a = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            SwanAppActivity swanAppActivity;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (swanAppActivity = this.b.d) == null) {
                return;
            }
            int taskId = swanAppActivity.getTaskId();
            this.b.d.finish();
            if (this.a) {
                this.b.d.overridePendingTransition(0, R.anim.obfuscated_res_0x7f010026);
            }
            nc3.m().l(taskId);
        }
    }

    /* loaded from: classes7.dex */
    public class b implements FullScreenFloatView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ql2 a;

        public b(ql2 ql2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ql2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ql2Var;
        }

        @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.c
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.c
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.q().X();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755376358, "Lcom/repackage/ql2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755376358, "Lcom/repackage/ql2;");
                return;
            }
        }
        j = rg1.a;
    }

    public ql2() {
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
        this.b = new r03();
        b72.U();
        tl2 tl2Var = new tl2();
        this.e = tl2Var;
        tl2Var.h(this);
    }

    @Override // com.repackage.sl2
    public pm1 A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? b72.U().e0(str) : (pm1) invokeL.objValue;
    }

    @Override // com.repackage.sl2
    public View B(String str) {
        InterceptResult invokeL;
        om1 t;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            pm1 A = A(str);
            if (A == null || (t = A.t()) == null) {
                return null;
            }
            return t.getCurrentWebView();
        }
        return (View) invokeL.objValue;
    }

    @Override // com.repackage.sl2
    public String C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            pz1 H = H();
            return H != null ? H.t3() : "";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.repackage.sl2
    @Nullable
    public h03 D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? h03.M() : (h03) invokeV.objValue;
    }

    @Override // com.repackage.sl2
    @CallSuper
    public void E(el2 el2Var, bj2 bj2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, el2Var, bj2Var) == null) {
            Q();
        }
    }

    @Override // com.repackage.sl2
    public vh1 F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return null;
        }
        return (vh1) invokeV.objValue;
    }

    @Override // com.repackage.sl2
    @NonNull
    public final k83 G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            h03 b0 = h03.b0();
            if (b0 == null) {
                return new i83();
            }
            return b0.h0();
        }
        return (k83) invokeV.objValue;
    }

    @Override // com.repackage.sl2
    public pz1 H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            qz1 T = T();
            if (T == null) {
                return null;
            }
            return T.o();
        }
        return (pz1) invokeV.objValue;
    }

    @Override // com.repackage.sl2
    public void I() {
        tl2 tl2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && k() && (tl2Var = this.e) != null) {
            tl2Var.i();
        }
    }

    @Override // com.repackage.sl2
    public SwanAppPropertyWindow J(Activity activity) {
        InterceptResult invokeL;
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, activity)) == null) {
            Q();
            if (activity == null) {
                return null;
            }
            if (this.g == null && (viewGroup = (ViewGroup) activity.findViewById(R.id.obfuscated_res_0x7f09016b)) != null) {
                SwanAppPropertyWindow swanAppPropertyWindow = new SwanAppPropertyWindow(activity);
                this.g = swanAppPropertyWindow;
                swanAppPropertyWindow.setVisibility(8);
                viewGroup.addView(this.g);
            }
            return this.g;
        }
        return (SwanAppPropertyWindow) invokeL.objValue;
    }

    @Override // com.repackage.sl2
    public void K(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.c = str;
        }
    }

    @Override // com.repackage.sl2
    public yh1 L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return null;
        }
        return (yh1) invokeV.objValue;
    }

    @Override // com.repackage.sl2
    public SwanCoreVersion M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return null;
        }
        return (SwanCoreVersion) invokeV.objValue;
    }

    @Override // com.repackage.sl2
    public boolean N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            Q();
            h03 M = h03.M();
            el2.a Y = M != null ? M.Y() : null;
            return Y != null && ((j && Y.n0()) || js1.g(Y) || js1.d(Y));
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.sl2
    @CallSuper
    public void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.i = true;
            tl2 tl2Var = this.e;
            if (tl2Var != null) {
                tl2Var.j();
                this.e = null;
            }
            lw2.b().d();
            U();
            ku2.e().g(g03.K().getAppId());
            d93.u(true);
            this.d = null;
        }
    }

    @Override // com.repackage.sl2
    public yh1 P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return null;
        }
        return (yh1) invokeV.objValue;
    }

    @SuppressLint({"BDThrowableCheck"})
    public void Q() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && getActivity() == null && j) {
            throw new IllegalStateException("AiBaseController: This method should be called after setActivityRef");
        }
    }

    public final void R(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048593, this, z) == null) || this.d == null) {
            return;
        }
        be3.e0(new a(this, z));
    }

    @NonNull
    public Pair<Integer, Integer> S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            pz1 H = H();
            if (H == null) {
                return new Pair<>(0, 0);
            }
            return H.n3();
        }
        return (Pair) invokeV.objValue;
    }

    public qz1 T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            SwanAppActivity swanAppActivity = this.d;
            if (swanAppActivity == null) {
                return null;
            }
            return swanAppActivity.X();
        }
        return (qz1) invokeV.objValue;
    }

    public final void U() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            FullScreenFloatView fullScreenFloatView = this.f;
            if (fullScreenFloatView != null) {
                ViewParent parent = fullScreenFloatView.getParent();
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(this.f);
                }
            }
            mm1 mm1Var = this.a;
            if (mm1Var != null) {
                mm1Var.F();
            }
            gx1.e();
        }
    }

    @Override // com.repackage.sl2
    public void a() {
        SwanAppActivity w;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048597, this) == null) || (w = g03.K().w()) == null || w.isFinishing()) {
            return;
        }
        w.z0();
    }

    @Override // com.repackage.sl2
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            h03 b0 = h03.b0();
            if (b0 == null || b0.Y() == null) {
                return null;
            }
            return el2.m1(b0.Y(), ul2.U().s());
        }
        return (String) invokeV.objValue;
    }

    @Override // com.repackage.sl2
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            this.h = true;
        }
    }

    @Override // com.repackage.sl2
    @CallSuper
    public void d(el2 el2Var, bj2 bj2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048600, this, el2Var, bj2Var) == null) {
            Q();
        }
    }

    @Override // com.repackage.sl2
    @NonNull
    public w03 e(String str, SwanAppConfigData swanAppConfigData, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048601, this, str, swanAppConfigData, str2)) == null) {
            if (swanAppConfigData != null && !TextUtils.isEmpty(str2)) {
                return this.b.b(str2, str, swanAppConfigData.e);
            }
            return f(str);
        }
        return (w03) invokeLLL.objValue;
    }

    @Override // com.repackage.sl2
    public void exit() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            R(true);
        }
    }

    @Override // com.repackage.sl2
    @NonNull
    public w03 f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, str)) == null) {
            SwanAppConfigData s = s();
            if (s == null) {
                if (j) {
                    Log.w("AiBaseController", "#getPageWindowConfig mConfigData=null stack=" + Log.getStackTraceString(new Exception()));
                }
                return w03.d();
            }
            return this.b.b(z(), str, s.e);
        }
        return (w03) invokeL.objValue;
    }

    @Override // com.repackage.sl2
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            SwanAppConfigData s = s();
            return s == null ? "" : s.f();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.repackage.sl2
    public SwanAppActivity getActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? g03.K().w() : (SwanAppActivity) invokeV.objValue;
    }

    @Override // com.repackage.tl2.b
    public void h(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048606, this, i) == null) {
            Q();
            nc3.m().x(this.d);
            R(false);
        }
    }

    @Override // com.repackage.sl2
    public om1 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            pm1 A = A(C());
            if (A == null) {
                return null;
            }
            return A.t();
        }
        return (om1) invokeV.objValue;
    }

    @Override // com.repackage.sl2
    public w03 j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048608, this, str)) == null) {
            SwanAppConfigData s = s();
            if (s == null) {
                if (j) {
                    Log.w("AiBaseController", "#obtainNewWindowConfig mConfigData=null stack=" + Log.getStackTraceString(new Exception()));
                }
                return w03.d();
            }
            return this.b.a(z(), str, s.e);
        }
        return (w03) invokeL.objValue;
    }

    @Override // com.repackage.sl2
    public void l(SwanAppActivity swanAppActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, swanAppActivity) == null) {
            this.d = swanAppActivity;
        }
    }

    @Override // com.repackage.sl2
    public void m(String str, ha2 ha2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048610, this, str, ha2Var) == null) {
            b72.U().V0(str, ha2Var);
        }
    }

    @Override // com.repackage.sl2
    public FullScreenFloatView n(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048611, this, activity)) == null) {
            Q();
            if (activity == null) {
                return null;
            }
            if (this.f == null) {
                FullScreenFloatView a2 = qy2.a(activity, (ViewGroup) activity.findViewById(16908290), 2);
                this.f = a2;
                a2.setFloatButtonText(activity.getString(R.string.obfuscated_res_0x7f0f01b8));
                this.f.setFloatImageBackground(R.drawable.obfuscated_res_0x7f08015c);
                this.f.setVisibility(8);
                this.f.setDragImageListener(new b(this));
            }
            return this.f;
        }
        return (FullScreenFloatView) invokeL.objValue;
    }

    @Override // com.repackage.sl2
    public void o() {
        SwanAppActivity w;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048612, this) == null) || (w = g03.K().w()) == null || w.isFinishing()) {
            return;
        }
        w.v0();
    }

    @Override // com.repackage.sl2
    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            this.h = false;
        }
    }

    @Override // com.repackage.sl2
    @DebugTrace
    public mm1 q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            mm1 b2 = gx1.b();
            SwanAppActivity swanAppActivity = this.d;
            if (swanAppActivity != null) {
                b2.G((ViewGroup) swanAppActivity.findViewById(R.id.obfuscated_res_0x7f09016b));
            }
            return b2;
        }
        return (mm1) invokeV.objValue;
    }

    @Override // com.repackage.sl2
    @NonNull
    public Pair<Integer, Integer> r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            Pair<Integer, Integer> S = S();
            int intValue = ((Integer) S.first).intValue();
            int intValue2 = ((Integer) S.second).intValue();
            if (intValue == 0) {
                intValue = yd3.o(AppRuntime.getAppContext());
            }
            if (intValue2 == 0) {
                intValue2 = yd3.u(AppRuntime.getAppContext());
            }
            return new Pair<>(Integer.valueOf(intValue), Integer.valueOf(intValue2));
        }
        return (Pair) invokeV.objValue;
    }

    @Override // com.repackage.sl2
    public void registerReceiver(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048616, this, context) == null) || this.e == null) {
            return;
        }
        Q();
        this.e.c(context);
    }

    @Override // com.repackage.sl2
    public SwanAppConfigData s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            g03 K = g03.K();
            if (K.E()) {
                return K.q().Q();
            }
            return null;
        }
        return (SwanAppConfigData) invokeV.objValue;
    }

    @Override // com.repackage.sl2
    public void t(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, intent) == null) {
            b72.U().z0(intent);
        }
    }

    @Override // com.repackage.sl2
    public void u(ha2 ha2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, ha2Var) == null) {
            if (!g03.K().q().y0()) {
                b72.U().U0(ha2Var);
                return;
            }
            b72.U().V0(zf3.c().h(), ha2Var);
        }
    }

    @Override // com.repackage.sl2
    public void unregisterReceiver(Context context) {
        tl2 tl2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048620, this, context) == null) || (tl2Var = this.e) == null) {
            return;
        }
        tl2Var.f(context);
    }

    @Override // com.repackage.sl2
    @CallSuper
    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            Q();
            String g0 = h03.g0();
            if (TextUtils.isEmpty(g0)) {
                return;
            }
            this.h = true;
            this.e.j();
            Bundle bundle = new Bundle();
            bundle.putString("app_id", g0);
            bundle.putInt("task_id", getActivity().getTaskId());
            xw2.e().h(new zw2(9, bundle));
            oj2.H().c(h03.b0() == null ? "" : h03.b0().O());
        }
    }

    @Override // com.repackage.sl2
    @CallSuper
    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            String g0 = h03.g0();
            if (TextUtils.isEmpty(g0)) {
                return;
            }
            I();
            h03 b0 = h03.b0();
            if (b0 != null) {
                b0.B().I(b0.getAppId());
            }
            Bundle bundle = new Bundle();
            bundle.putString("app_id", g0);
            bundle.putInt("task_id", je3.b().a());
            xw2.e().h(new zw2(10, bundle));
            oj2.H().a(h03.b0() == null ? "" : h03.b0().O());
            oj2.d().d(AppRuntime.getAppContext(), null, DownloadParams.SwanAppDownloadType.TYPE_STOP_SERVICE, null);
        }
    }

    @Override // com.repackage.sl2
    @NonNull
    public Pair<Integer, Integer> x() {
        InterceptResult invokeV;
        Window window;
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            Context appContext = AppRuntime.getAppContext();
            int n = yd3.n(appContext);
            int measuredHeight = (g03.K().w() == null || (window = g03.K().w().getWindow()) == null || (viewGroup = (ViewGroup) window.getDecorView().findViewById(16908290)) == null || !viewGroup.isLaidOut()) ? 0 : viewGroup.getMeasuredHeight();
            if (measuredHeight >= n) {
                return new Pair<>(Integer.valueOf(yd3.o(appContext)), Integer.valueOf(measuredHeight));
            }
            if (Build.VERSION.SDK_INT >= 28) {
                n += qd3.e(appContext);
            }
            return new Pair<>(Integer.valueOf(yd3.o(appContext)), Integer.valueOf(n));
        }
        return (Pair) invokeV.objValue;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [T, java.lang.String] */
    @Override // com.repackage.sl2
    public void y(ka2 ka2Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048624, this, ka2Var, z) == null) {
            lt2.a("postMessage", "handleNativeMessage start.");
            if (ka2Var == null) {
                return;
            }
            na2 na2Var = new na2();
            na2Var.c = ka2Var.b;
            na2Var.d = z;
            if (j) {
                Log.d("AiBaseController", "handleNativeMessage data: " + ka2Var.b + " ; needEncode = " + z);
            }
            m(ka2Var.a, na2Var);
            lt2.a("postMessage", "handleNativeMessage end.");
        }
    }

    @Override // com.repackage.sl2
    public String z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) ? TextUtils.isEmpty(this.c) ? "" : this.c : (String) invokeV.objValue;
    }
}
