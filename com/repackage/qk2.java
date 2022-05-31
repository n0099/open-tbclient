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
import com.repackage.ek2;
/* loaded from: classes6.dex */
public abstract class qk2 implements sk2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean j;
    public transient /* synthetic */ FieldHolder $fh;
    public ml1 a;
    public rz2 b;
    public String c;
    @Deprecated
    public SwanAppActivity d;
    public tk2 e;
    public FullScreenFloatView f;
    public SwanAppPropertyWindow g;
    public boolean h;
    public boolean i;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ qk2 b;

        public a(qk2 qk2Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qk2Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = qk2Var;
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
            nb3.m().l(taskId);
        }
    }

    /* loaded from: classes6.dex */
    public class b implements FullScreenFloatView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qk2 a;

        public b(qk2 qk2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qk2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qk2Var;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755377319, "Lcom/repackage/qk2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755377319, "Lcom/repackage/qk2;");
                return;
            }
        }
        j = rf1.a;
    }

    public qk2() {
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
        this.b = new rz2();
        b62.U();
        tk2 tk2Var = new tk2();
        this.e = tk2Var;
        tk2Var.h(this);
    }

    @Override // com.repackage.sk2
    public pl1 A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? b62.U().e0(str) : (pl1) invokeL.objValue;
    }

    @Override // com.repackage.sk2
    public View B(String str) {
        InterceptResult invokeL;
        ol1 u;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            pl1 A = A(str);
            if (A == null || (u = A.u()) == null) {
                return null;
            }
            return u.getCurrentWebView();
        }
        return (View) invokeL.objValue;
    }

    @Override // com.repackage.sk2
    public String C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            py1 H = H();
            return H != null ? H.s3() : "";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.repackage.sk2
    @Nullable
    public hz2 D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? hz2.L() : (hz2) invokeV.objValue;
    }

    @Override // com.repackage.sk2
    @CallSuper
    public void E(ek2 ek2Var, bi2 bi2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, ek2Var, bi2Var) == null) {
            Q();
        }
    }

    @Override // com.repackage.sk2
    public vg1 F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return null;
        }
        return (vg1) invokeV.objValue;
    }

    @Override // com.repackage.sk2
    @NonNull
    public final k73 G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            hz2 a0 = hz2.a0();
            if (a0 == null) {
                return new i73();
            }
            return a0.g0();
        }
        return (k73) invokeV.objValue;
    }

    @Override // com.repackage.sk2
    public py1 H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            qy1 T = T();
            if (T == null) {
                return null;
            }
            return T.o();
        }
        return (py1) invokeV.objValue;
    }

    @Override // com.repackage.sk2
    public void I() {
        tk2 tk2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && k() && (tk2Var = this.e) != null) {
            tk2Var.i();
        }
    }

    @Override // com.repackage.sk2
    public SwanAppPropertyWindow J(Activity activity) {
        InterceptResult invokeL;
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, activity)) == null) {
            Q();
            if (activity == null) {
                return null;
            }
            if (this.g == null && (viewGroup = (ViewGroup) activity.findViewById(R.id.obfuscated_res_0x7f09016a)) != null) {
                SwanAppPropertyWindow swanAppPropertyWindow = new SwanAppPropertyWindow(activity);
                this.g = swanAppPropertyWindow;
                swanAppPropertyWindow.setVisibility(8);
                viewGroup.addView(this.g);
            }
            return this.g;
        }
        return (SwanAppPropertyWindow) invokeL.objValue;
    }

    @Override // com.repackage.sk2
    public void K(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.c = str;
        }
    }

    @Override // com.repackage.sk2
    public yg1 L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return null;
        }
        return (yg1) invokeV.objValue;
    }

    @Override // com.repackage.sk2
    public SwanCoreVersion M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return null;
        }
        return (SwanCoreVersion) invokeV.objValue;
    }

    @Override // com.repackage.sk2
    public boolean N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            Q();
            hz2 L = hz2.L();
            ek2.a X = L != null ? L.X() : null;
            return X != null && ((j && X.n0()) || jr1.g(X) || jr1.d(X));
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.sk2
    @CallSuper
    public void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.i = true;
            tk2 tk2Var = this.e;
            if (tk2Var != null) {
                tk2Var.j();
                this.e = null;
            }
            lv2.b().d();
            U();
            kt2.e().g(gz2.J().getAppId());
            d83.u(true);
            this.d = null;
        }
    }

    @Override // com.repackage.sk2
    public yg1 P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return null;
        }
        return (yg1) invokeV.objValue;
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
        bd3.e0(new a(this, z));
    }

    @NonNull
    public Pair<Integer, Integer> S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            py1 H = H();
            if (H == null) {
                return new Pair<>(0, 0);
            }
            return H.m3();
        }
        return (Pair) invokeV.objValue;
    }

    public qy1 T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            SwanAppActivity swanAppActivity = this.d;
            if (swanAppActivity == null) {
                return null;
            }
            return swanAppActivity.getSwanAppFragmentManager();
        }
        return (qy1) invokeV.objValue;
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
            ml1 ml1Var = this.a;
            if (ml1Var != null) {
                ml1Var.G();
            }
            gw1.e();
        }
    }

    @Override // com.repackage.sk2
    public void a() {
        SwanAppActivity x;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048597, this) == null) || (x = gz2.J().x()) == null || x.isFinishing()) {
            return;
        }
        x.showLoadingView();
    }

    @Override // com.repackage.sk2
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            hz2 a0 = hz2.a0();
            if (a0 == null || a0.X() == null) {
                return null;
            }
            return ek2.m1(a0.X(), uk2.U().s());
        }
        return (String) invokeV.objValue;
    }

    @Override // com.repackage.sk2
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            this.h = true;
        }
    }

    @Override // com.repackage.sk2
    @CallSuper
    public void d(ek2 ek2Var, bi2 bi2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048600, this, ek2Var, bi2Var) == null) {
            Q();
        }
    }

    @Override // com.repackage.sk2
    @NonNull
    public wz2 e(String str, SwanAppConfigData swanAppConfigData, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048601, this, str, swanAppConfigData, str2)) == null) {
            if (swanAppConfigData != null && !TextUtils.isEmpty(str2)) {
                return this.b.b(str2, str, swanAppConfigData.e);
            }
            return f(str);
        }
        return (wz2) invokeLLL.objValue;
    }

    @Override // com.repackage.sk2
    public void exit() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            R(true);
        }
    }

    @Override // com.repackage.sk2
    @NonNull
    public wz2 f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, str)) == null) {
            SwanAppConfigData s = s();
            if (s == null) {
                if (j) {
                    Log.w("AiBaseController", "#getPageWindowConfig mConfigData=null stack=" + Log.getStackTraceString(new Exception()));
                }
                return wz2.d();
            }
            return this.b.b(z(), str, s.e);
        }
        return (wz2) invokeL.objValue;
    }

    @Override // com.repackage.sk2
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            SwanAppConfigData s = s();
            return s == null ? "" : s.f();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.repackage.sk2
    public SwanAppActivity getActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? gz2.J().x() : (SwanAppActivity) invokeV.objValue;
    }

    @Override // com.repackage.tk2.b
    public void h(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048606, this, i) == null) {
            Q();
            nb3.m().x(this.d);
            R(false);
        }
    }

    @Override // com.repackage.sk2
    public ol1 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            pl1 A = A(C());
            if (A == null) {
                return null;
            }
            return A.u();
        }
        return (ol1) invokeV.objValue;
    }

    @Override // com.repackage.sk2
    public wz2 j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048608, this, str)) == null) {
            SwanAppConfigData s = s();
            if (s == null) {
                if (j) {
                    Log.w("AiBaseController", "#obtainNewWindowConfig mConfigData=null stack=" + Log.getStackTraceString(new Exception()));
                }
                return wz2.d();
            }
            return this.b.a(z(), str, s.e);
        }
        return (wz2) invokeL.objValue;
    }

    @Override // com.repackage.sk2
    public void l(SwanAppActivity swanAppActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, swanAppActivity) == null) {
            this.d = swanAppActivity;
        }
    }

    @Override // com.repackage.sk2
    public void m(String str, h92 h92Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048610, this, str, h92Var) == null) {
            b62.U().V0(str, h92Var);
        }
    }

    @Override // com.repackage.sk2
    public FullScreenFloatView n(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048611, this, activity)) == null) {
            Q();
            if (activity == null) {
                return null;
            }
            if (this.f == null) {
                FullScreenFloatView a2 = qx2.a(activity, (ViewGroup) activity.findViewById(16908290), 2);
                this.f = a2;
                a2.setFloatButtonText(activity.getString(R.string.obfuscated_res_0x7f0f01b6));
                this.f.setFloatImageBackground(R.drawable.obfuscated_res_0x7f08015d);
                this.f.setVisibility(8);
                this.f.setDragImageListener(new b(this));
            }
            return this.f;
        }
        return (FullScreenFloatView) invokeL.objValue;
    }

    @Override // com.repackage.sk2
    public void o() {
        SwanAppActivity x;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048612, this) == null) || (x = gz2.J().x()) == null || x.isFinishing()) {
            return;
        }
        x.removeLoadingView();
    }

    @Override // com.repackage.sk2
    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            this.h = false;
        }
    }

    @Override // com.repackage.sk2
    @DebugTrace
    public ml1 q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            ml1 b2 = gw1.b();
            SwanAppActivity swanAppActivity = this.d;
            if (swanAppActivity != null) {
                b2.H((ViewGroup) swanAppActivity.findViewById(R.id.obfuscated_res_0x7f09016a));
            }
            return b2;
        }
        return (ml1) invokeV.objValue;
    }

    @Override // com.repackage.sk2
    @NonNull
    public Pair<Integer, Integer> r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            Pair<Integer, Integer> S = S();
            int intValue = ((Integer) S.first).intValue();
            int intValue2 = ((Integer) S.second).intValue();
            if (intValue == 0) {
                intValue = yc3.o(AppRuntime.getAppContext());
            }
            if (intValue2 == 0) {
                intValue2 = yc3.u(AppRuntime.getAppContext());
            }
            return new Pair<>(Integer.valueOf(intValue), Integer.valueOf(intValue2));
        }
        return (Pair) invokeV.objValue;
    }

    @Override // com.repackage.sk2
    public void registerReceiver(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048616, this, context) == null) || this.e == null) {
            return;
        }
        Q();
        this.e.c(context);
    }

    @Override // com.repackage.sk2
    public SwanAppConfigData s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            gz2 J = gz2.J();
            if (J.D()) {
                return J.r().P();
            }
            return null;
        }
        return (SwanAppConfigData) invokeV.objValue;
    }

    @Override // com.repackage.sk2
    public void t(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, intent) == null) {
            b62.U().z0(intent);
        }
    }

    @Override // com.repackage.sk2
    public void u(h92 h92Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, h92Var) == null) {
            if (!gz2.J().r().x0()) {
                b62.U().U0(h92Var);
                return;
            }
            b62.U().V0(ze3.c().h(), h92Var);
        }
    }

    @Override // com.repackage.sk2
    public void unregisterReceiver(Context context) {
        tk2 tk2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048620, this, context) == null) || (tk2Var = this.e) == null) {
            return;
        }
        tk2Var.f(context);
    }

    @Override // com.repackage.sk2
    @CallSuper
    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            Q();
            String f0 = hz2.f0();
            if (TextUtils.isEmpty(f0)) {
                return;
            }
            this.h = true;
            this.e.j();
            Bundle bundle = new Bundle();
            bundle.putString("app_id", f0);
            bundle.putInt("task_id", getActivity().getTaskId());
            xv2.e().h(new zv2(9, bundle));
            oi2.H().c(hz2.a0() == null ? "" : hz2.a0().N());
        }
    }

    @Override // com.repackage.sk2
    @CallSuper
    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            String f0 = hz2.f0();
            if (TextUtils.isEmpty(f0)) {
                return;
            }
            I();
            hz2 a0 = hz2.a0();
            if (a0 != null) {
                a0.B().H(a0.getAppId());
            }
            Bundle bundle = new Bundle();
            bundle.putString("app_id", f0);
            bundle.putInt("task_id", jd3.b().a());
            xv2.e().h(new zv2(10, bundle));
            oi2.H().a(hz2.a0() == null ? "" : hz2.a0().N());
            oi2.d().d(AppRuntime.getAppContext(), null, DownloadParams.SwanAppDownloadType.TYPE_STOP_SERVICE, null);
        }
    }

    @Override // com.repackage.sk2
    @NonNull
    public Pair<Integer, Integer> x() {
        InterceptResult invokeV;
        Window window;
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            Context appContext = AppRuntime.getAppContext();
            int n = yc3.n(appContext);
            int measuredHeight = (gz2.J().x() == null || (window = gz2.J().x().getWindow()) == null || (viewGroup = (ViewGroup) window.getDecorView().findViewById(16908290)) == null || !viewGroup.isLaidOut()) ? 0 : viewGroup.getMeasuredHeight();
            if (measuredHeight >= n) {
                return new Pair<>(Integer.valueOf(yc3.o(appContext)), Integer.valueOf(measuredHeight));
            }
            if (Build.VERSION.SDK_INT >= 28) {
                n += qc3.e(appContext);
            }
            return new Pair<>(Integer.valueOf(yc3.o(appContext)), Integer.valueOf(n));
        }
        return (Pair) invokeV.objValue;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [T, java.lang.String] */
    @Override // com.repackage.sk2
    public void y(k92 k92Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048624, this, k92Var, z) == null) {
            ls2.a("postMessage", "handleNativeMessage start.");
            if (k92Var == null) {
                return;
            }
            n92 n92Var = new n92();
            n92Var.c = k92Var.b;
            n92Var.d = z;
            if (j) {
                Log.d("AiBaseController", "handleNativeMessage data: " + k92Var.b + " ; needEncode = " + z);
            }
            m(k92Var.a, n92Var);
            ls2.a("postMessage", "handleNativeMessage end.");
        }
    }

    @Override // com.repackage.sk2
    public String z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) ? TextUtils.isEmpty(this.c) ? "" : this.c : (String) invokeV.objValue;
    }
}
