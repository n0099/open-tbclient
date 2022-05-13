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
import com.repackage.rl2;
/* loaded from: classes5.dex */
public abstract class dm2 implements fm2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean j;
    public transient /* synthetic */ FieldHolder $fh;
    public zm1 a;
    public e13 b;
    public String c;
    @Deprecated
    public SwanAppActivity d;
    public gm2 e;
    public FullScreenFloatView f;
    public SwanAppPropertyWindow g;
    public boolean h;
    public boolean i;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ dm2 b;

        public a(dm2 dm2Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dm2Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = dm2Var;
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
            ad3.m().l(taskId);
        }
    }

    /* loaded from: classes5.dex */
    public class b implements FullScreenFloatView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dm2 a;

        public b(dm2 dm2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dm2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dm2Var;
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
                this.a.q().Y();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755762680, "Lcom/repackage/dm2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755762680, "Lcom/repackage/dm2;");
                return;
            }
        }
        j = eh1.a;
    }

    public dm2() {
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
        this.b = new e13();
        o72.U();
        gm2 gm2Var = new gm2();
        this.e = gm2Var;
        gm2Var.h(this);
    }

    @Override // com.repackage.fm2
    public cn1 A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? o72.U().e0(str) : (cn1) invokeL.objValue;
    }

    @Override // com.repackage.fm2
    public View B(String str) {
        InterceptResult invokeL;
        bn1 u;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            cn1 A = A(str);
            if (A == null || (u = A.u()) == null) {
                return null;
            }
            return u.getCurrentWebView();
        }
        return (View) invokeL.objValue;
    }

    @Override // com.repackage.fm2
    public String C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            c02 H = H();
            return H != null ? H.s3() : "";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.repackage.fm2
    @Nullable
    public u03 D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? u03.L() : (u03) invokeV.objValue;
    }

    @Override // com.repackage.fm2
    @CallSuper
    public void E(rl2 rl2Var, oj2 oj2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, rl2Var, oj2Var) == null) {
            Q();
        }
    }

    @Override // com.repackage.fm2
    public ii1 F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return null;
        }
        return (ii1) invokeV.objValue;
    }

    @Override // com.repackage.fm2
    @NonNull
    public final x83 G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            u03 a0 = u03.a0();
            if (a0 == null) {
                return new v83();
            }
            return a0.g0();
        }
        return (x83) invokeV.objValue;
    }

    @Override // com.repackage.fm2
    public c02 H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            d02 T = T();
            if (T == null) {
                return null;
            }
            return T.o();
        }
        return (c02) invokeV.objValue;
    }

    @Override // com.repackage.fm2
    public void I() {
        gm2 gm2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && k() && (gm2Var = this.e) != null) {
            gm2Var.i();
        }
    }

    @Override // com.repackage.fm2
    public SwanAppPropertyWindow J(Activity activity) {
        InterceptResult invokeL;
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, activity)) == null) {
            Q();
            if (activity == null) {
                return null;
            }
            if (this.g == null && (viewGroup = (ViewGroup) activity.findViewById(R.id.obfuscated_res_0x7f09016d)) != null) {
                SwanAppPropertyWindow swanAppPropertyWindow = new SwanAppPropertyWindow(activity);
                this.g = swanAppPropertyWindow;
                swanAppPropertyWindow.setVisibility(8);
                viewGroup.addView(this.g);
            }
            return this.g;
        }
        return (SwanAppPropertyWindow) invokeL.objValue;
    }

    @Override // com.repackage.fm2
    public void K(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.c = str;
        }
    }

    @Override // com.repackage.fm2
    public li1 L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return null;
        }
        return (li1) invokeV.objValue;
    }

    @Override // com.repackage.fm2
    public SwanCoreVersion M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return null;
        }
        return (SwanCoreVersion) invokeV.objValue;
    }

    @Override // com.repackage.fm2
    public boolean N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            Q();
            u03 L = u03.L();
            rl2.a X = L != null ? L.X() : null;
            return X != null && ((j && X.n0()) || ws1.g(X) || ws1.d(X));
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.fm2
    @CallSuper
    public void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.i = true;
            gm2 gm2Var = this.e;
            if (gm2Var != null) {
                gm2Var.j();
                this.e = null;
            }
            yw2.b().d();
            U();
            xu2.e().g(t03.J().getAppId());
            q93.u(true);
            this.d = null;
        }
    }

    @Override // com.repackage.fm2
    public li1 P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return null;
        }
        return (li1) invokeV.objValue;
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
        oe3.e0(new a(this, z));
    }

    @NonNull
    public Pair<Integer, Integer> S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            c02 H = H();
            if (H == null) {
                return new Pair<>(0, 0);
            }
            return H.m3();
        }
        return (Pair) invokeV.objValue;
    }

    public d02 T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            SwanAppActivity swanAppActivity = this.d;
            if (swanAppActivity == null) {
                return null;
            }
            return swanAppActivity.getSwanAppFragmentManager();
        }
        return (d02) invokeV.objValue;
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
            zm1 zm1Var = this.a;
            if (zm1Var != null) {
                zm1Var.G();
            }
            tx1.e();
        }
    }

    @Override // com.repackage.fm2
    public void a() {
        SwanAppActivity x;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048597, this) == null) || (x = t03.J().x()) == null || x.isFinishing()) {
            return;
        }
        x.showLoadingView();
    }

    @Override // com.repackage.fm2
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            u03 a0 = u03.a0();
            if (a0 == null || a0.X() == null) {
                return null;
            }
            return rl2.m1(a0.X(), hm2.U().s());
        }
        return (String) invokeV.objValue;
    }

    @Override // com.repackage.fm2
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            this.h = true;
        }
    }

    @Override // com.repackage.fm2
    @CallSuper
    public void d(rl2 rl2Var, oj2 oj2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048600, this, rl2Var, oj2Var) == null) {
            Q();
        }
    }

    @Override // com.repackage.fm2
    @NonNull
    public j13 e(String str, SwanAppConfigData swanAppConfigData, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048601, this, str, swanAppConfigData, str2)) == null) {
            if (swanAppConfigData != null && !TextUtils.isEmpty(str2)) {
                return this.b.b(str2, str, swanAppConfigData.e);
            }
            return f(str);
        }
        return (j13) invokeLLL.objValue;
    }

    @Override // com.repackage.fm2
    public void exit() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            R(true);
        }
    }

    @Override // com.repackage.fm2
    @NonNull
    public j13 f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, str)) == null) {
            SwanAppConfigData s = s();
            if (s == null) {
                if (j) {
                    Log.w("AiBaseController", "#getPageWindowConfig mConfigData=null stack=" + Log.getStackTraceString(new Exception()));
                }
                return j13.d();
            }
            return this.b.b(z(), str, s.e);
        }
        return (j13) invokeL.objValue;
    }

    @Override // com.repackage.fm2
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            SwanAppConfigData s = s();
            return s == null ? "" : s.f();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.repackage.fm2
    public SwanAppActivity getActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? t03.J().x() : (SwanAppActivity) invokeV.objValue;
    }

    @Override // com.repackage.gm2.b
    public void h(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048606, this, i) == null) {
            Q();
            ad3.m().x(this.d);
            R(false);
        }
    }

    @Override // com.repackage.fm2
    public bn1 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            cn1 A = A(C());
            if (A == null) {
                return null;
            }
            return A.u();
        }
        return (bn1) invokeV.objValue;
    }

    @Override // com.repackage.fm2
    public j13 j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048608, this, str)) == null) {
            SwanAppConfigData s = s();
            if (s == null) {
                if (j) {
                    Log.w("AiBaseController", "#obtainNewWindowConfig mConfigData=null stack=" + Log.getStackTraceString(new Exception()));
                }
                return j13.d();
            }
            return this.b.a(z(), str, s.e);
        }
        return (j13) invokeL.objValue;
    }

    @Override // com.repackage.fm2
    public void l(SwanAppActivity swanAppActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, swanAppActivity) == null) {
            this.d = swanAppActivity;
        }
    }

    @Override // com.repackage.fm2
    public void m(String str, ua2 ua2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048610, this, str, ua2Var) == null) {
            o72.U().V0(str, ua2Var);
        }
    }

    @Override // com.repackage.fm2
    public FullScreenFloatView n(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048611, this, activity)) == null) {
            Q();
            if (activity == null) {
                return null;
            }
            if (this.f == null) {
                FullScreenFloatView a2 = dz2.a(activity, (ViewGroup) activity.findViewById(16908290), 2);
                this.f = a2;
                a2.setFloatButtonText(activity.getString(R.string.obfuscated_res_0x7f0f01b5));
                this.f.setFloatImageBackground(R.drawable.obfuscated_res_0x7f08015d);
                this.f.setVisibility(8);
                this.f.setDragImageListener(new b(this));
            }
            return this.f;
        }
        return (FullScreenFloatView) invokeL.objValue;
    }

    @Override // com.repackage.fm2
    public void o() {
        SwanAppActivity x;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048612, this) == null) || (x = t03.J().x()) == null || x.isFinishing()) {
            return;
        }
        x.removeLoadingView();
    }

    @Override // com.repackage.fm2
    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            this.h = false;
        }
    }

    @Override // com.repackage.fm2
    @DebugTrace
    public zm1 q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            zm1 b2 = tx1.b();
            SwanAppActivity swanAppActivity = this.d;
            if (swanAppActivity != null) {
                b2.H((ViewGroup) swanAppActivity.findViewById(R.id.obfuscated_res_0x7f09016d));
            }
            return b2;
        }
        return (zm1) invokeV.objValue;
    }

    @Override // com.repackage.fm2
    @NonNull
    public Pair<Integer, Integer> r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            Pair<Integer, Integer> S = S();
            int intValue = ((Integer) S.first).intValue();
            int intValue2 = ((Integer) S.second).intValue();
            if (intValue == 0) {
                intValue = le3.o(AppRuntime.getAppContext());
            }
            if (intValue2 == 0) {
                intValue2 = le3.u(AppRuntime.getAppContext());
            }
            return new Pair<>(Integer.valueOf(intValue), Integer.valueOf(intValue2));
        }
        return (Pair) invokeV.objValue;
    }

    @Override // com.repackage.fm2
    public void registerReceiver(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048616, this, context) == null) || this.e == null) {
            return;
        }
        Q();
        this.e.c(context);
    }

    @Override // com.repackage.fm2
    public SwanAppConfigData s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            t03 J = t03.J();
            if (J.D()) {
                return J.r().P();
            }
            return null;
        }
        return (SwanAppConfigData) invokeV.objValue;
    }

    @Override // com.repackage.fm2
    public void t(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, intent) == null) {
            o72.U().z0(intent);
        }
    }

    @Override // com.repackage.fm2
    public void u(ua2 ua2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, ua2Var) == null) {
            if (!t03.J().r().x0()) {
                o72.U().U0(ua2Var);
                return;
            }
            o72.U().V0(mg3.c().h(), ua2Var);
        }
    }

    @Override // com.repackage.fm2
    public void unregisterReceiver(Context context) {
        gm2 gm2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048620, this, context) == null) || (gm2Var = this.e) == null) {
            return;
        }
        gm2Var.f(context);
    }

    @Override // com.repackage.fm2
    @CallSuper
    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            Q();
            String f0 = u03.f0();
            if (TextUtils.isEmpty(f0)) {
                return;
            }
            this.h = true;
            this.e.j();
            Bundle bundle = new Bundle();
            bundle.putString("app_id", f0);
            bundle.putInt("task_id", getActivity().getTaskId());
            kx2.e().h(new mx2(9, bundle));
            bk2.H().c(u03.a0() == null ? "" : u03.a0().N());
        }
    }

    @Override // com.repackage.fm2
    @CallSuper
    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            String f0 = u03.f0();
            if (TextUtils.isEmpty(f0)) {
                return;
            }
            I();
            u03 a0 = u03.a0();
            if (a0 != null) {
                a0.B().H(a0.getAppId());
            }
            Bundle bundle = new Bundle();
            bundle.putString("app_id", f0);
            bundle.putInt("task_id", we3.b().a());
            kx2.e().h(new mx2(10, bundle));
            bk2.H().a(u03.a0() == null ? "" : u03.a0().N());
            bk2.d().d(AppRuntime.getAppContext(), null, DownloadParams.SwanAppDownloadType.TYPE_STOP_SERVICE, null);
        }
    }

    @Override // com.repackage.fm2
    @NonNull
    public Pair<Integer, Integer> x() {
        InterceptResult invokeV;
        Window window;
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            Context appContext = AppRuntime.getAppContext();
            int n = le3.n(appContext);
            int measuredHeight = (t03.J().x() == null || (window = t03.J().x().getWindow()) == null || (viewGroup = (ViewGroup) window.getDecorView().findViewById(16908290)) == null || !viewGroup.isLaidOut()) ? 0 : viewGroup.getMeasuredHeight();
            if (measuredHeight >= n) {
                return new Pair<>(Integer.valueOf(le3.o(appContext)), Integer.valueOf(measuredHeight));
            }
            if (Build.VERSION.SDK_INT >= 28) {
                n += de3.e(appContext);
            }
            return new Pair<>(Integer.valueOf(le3.o(appContext)), Integer.valueOf(n));
        }
        return (Pair) invokeV.objValue;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [T, java.lang.String] */
    @Override // com.repackage.fm2
    public void y(xa2 xa2Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048624, this, xa2Var, z) == null) {
            yt2.a("postMessage", "handleNativeMessage start.");
            if (xa2Var == null) {
                return;
            }
            ab2 ab2Var = new ab2();
            ab2Var.c = xa2Var.b;
            ab2Var.d = z;
            if (j) {
                Log.d("AiBaseController", "handleNativeMessage data: " + xa2Var.b + " ; needEncode = " + z);
            }
            m(xa2Var.a, ab2Var);
            yt2.a("postMessage", "handleNativeMessage end.");
        }
    }

    @Override // com.repackage.fm2
    public String z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) ? TextUtils.isEmpty(this.c) ? "" : this.c : (String) invokeV.objValue;
    }
}
