package d.a.q0.a.g1;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.AbsoluteLayout;
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
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.f1.e.b;
import d.a.q0.a.k;
import d.a.q0.a.p.b.a.n;
import d.a.q0.a.v2.f0;
import d.a.q0.a.v2.n0;
import d.a.q0.a.v2.q0;
import d.a.q0.a.v2.x0;
/* loaded from: classes8.dex */
public abstract class b implements d {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean j;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d.a.q0.a.p.e.a f47823a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.q0.a.a2.n.b f47824b;

    /* renamed from: c  reason: collision with root package name */
    public String f47825c;
    @Deprecated

    /* renamed from: d  reason: collision with root package name */
    public SwanAppActivity f47826d;

    /* renamed from: e  reason: collision with root package name */
    public e f47827e;

    /* renamed from: f  reason: collision with root package name */
    public FullScreenFloatView f47828f;

    /* renamed from: g  reason: collision with root package name */
    public SwanAppPropertyWindow f47829g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f47830h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f47831i;

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f47832e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f47833f;

        public a(b bVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47833f = bVar;
            this.f47832e = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            SwanAppActivity swanAppActivity;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (swanAppActivity = this.f47833f.f47826d) == null) {
                return;
            }
            int taskId = swanAppActivity.getTaskId();
            this.f47833f.f47826d.finish();
            if (this.f47832e) {
                this.f47833f.f47826d.overridePendingTransition(0, d.a.q0.a.a.aiapps_slide_out_to_right_zadjustment_top);
            }
            d.a.q0.a.v2.c.m().l(taskId);
        }
    }

    /* renamed from: d.a.q0.a.g1.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0758b implements FullScreenFloatView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f47834a;

        public C0758b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47834a = bVar;
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
                this.f47834a.q().W();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(116041157, "Ld/a/q0/a/g1/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(116041157, "Ld/a/q0/a/g1/b;");
                return;
            }
        }
        j = k.f49133a;
    }

    public b() {
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
        this.f47824b = new d.a.q0.a.a2.n.b();
        d.a.q0.a.h0.u.g.N();
        e eVar = new e();
        this.f47827e = eVar;
        eVar.h(this);
    }

    @Override // d.a.q0.a.g1.d
    public String A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? TextUtils.isEmpty(this.f47825c) ? "" : this.f47825c : (String) invokeV.objValue;
    }

    @Override // d.a.q0.a.g1.d
    public d.a.q0.a.p.e.d B(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) ? d.a.q0.a.h0.u.g.N().W(str) : (d.a.q0.a.p.e.d) invokeL.objValue;
    }

    @Override // d.a.q0.a.g1.d
    public AbsoluteLayout C(String str) {
        InterceptResult invokeL;
        d.a.q0.a.p.e.c u;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            d.a.q0.a.p.e.d B = B(str);
            if (B == null || (u = B.u()) == null) {
                return null;
            }
            return u.getCurrentWebView();
        }
        return (AbsoluteLayout) invokeL.objValue;
    }

    @Override // d.a.q0.a.g1.d
    public String D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            d.a.q0.a.h0.g.f J = J();
            return J != null ? J.g3() : "";
        }
        return (String) invokeV.objValue;
    }

    @Override // d.a.q0.a.g1.d
    public void E(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, context) == null) || this.f47827e == null) {
            return;
        }
        R();
        this.f47827e.c(context);
    }

    @Override // d.a.q0.a.g1.d
    @Nullable
    public d.a.q0.a.a2.e F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? d.a.q0.a.a2.e.i() : (d.a.q0.a.a2.e) invokeV.objValue;
    }

    @Override // d.a.q0.a.g1.d
    @CallSuper
    public void G(d.a.q0.a.f1.e.b bVar, d.a.q0.a.a1.b bVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, bVar, bVar2) == null) {
            R();
        }
    }

    @Override // d.a.q0.a.g1.d
    public d.a.q0.a.p.b.a.k H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return null;
        }
        return (d.a.q0.a.p.b.a.k) invokeV.objValue;
    }

    @Override // d.a.q0.a.g1.d
    @NonNull
    public final d.a.q0.a.k2.f.d I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            d.a.q0.a.a2.e Q = d.a.q0.a.a2.e.Q();
            if (Q == null) {
                return new d.a.q0.a.k2.f.b();
            }
            return Q.W();
        }
        return (d.a.q0.a.k2.f.d) invokeV.objValue;
    }

    @Override // d.a.q0.a.g1.d
    public d.a.q0.a.h0.g.f J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            d.a.q0.a.h0.g.g U = U();
            if (U == null) {
                return null;
            }
            return U.o();
        }
        return (d.a.q0.a.h0.g.f) invokeV.objValue;
    }

    @Override // d.a.q0.a.g1.d
    public void K() {
        e eVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && j() && (eVar = this.f47827e) != null) {
            eVar.i();
        }
    }

    @Override // d.a.q0.a.g1.d
    public SwanAppPropertyWindow L(Activity activity) {
        InterceptResult invokeL;
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, activity)) == null) {
            R();
            if (activity == null) {
                return null;
            }
            if (this.f47829g == null && (viewGroup = (ViewGroup) activity.findViewById(d.a.q0.a.f.ai_apps_activity_root)) != null) {
                SwanAppPropertyWindow swanAppPropertyWindow = new SwanAppPropertyWindow(activity);
                this.f47829g = swanAppPropertyWindow;
                swanAppPropertyWindow.setVisibility(8);
                viewGroup.addView(this.f47829g);
            }
            return this.f47829g;
        }
        return (SwanAppPropertyWindow) invokeL.objValue;
    }

    @Override // d.a.q0.a.g1.d
    public n M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return null;
        }
        return (n) invokeV.objValue;
    }

    @Override // d.a.q0.a.g1.d
    public SwanCoreVersion N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return null;
        }
        return (SwanCoreVersion) invokeV.objValue;
    }

    @Override // d.a.q0.a.g1.d
    public boolean O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            R();
            d.a.q0.a.a2.e i2 = d.a.q0.a.a2.e.i();
            b.a N = i2 != null ? i2.N() : null;
            return N != null && ((j && N.m0()) || d.a.q0.a.v.a.g(N) || d.a.q0.a.v.a.d(N));
        }
        return invokeV.booleanValue;
    }

    @Override // d.a.q0.a.g1.d
    @CallSuper
    public void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.f47831i = true;
            e eVar = this.f47827e;
            if (eVar != null) {
                eVar.j();
                this.f47827e = null;
            }
            d.a.q0.a.v1.a.b.b.a.b().d();
            V();
            if (!d.a.q0.a.r1.l.e.g()) {
                d.a.q0.a.f1.c.b.c().a();
                d.a.q0.a.r1.r.a.f().b();
            }
            if (d.a.q0.a.r1.l.e.j()) {
                d.a.q0.a.r1.l.f.a.e().g(d.a.q0.a.a2.d.g().getAppId());
            } else {
                d.a.q0.a.r1.l.f.a.e().f();
                d.a.q0.a.n1.q.c.a.o();
            }
            d.a.q0.a.l2.b.u(true);
            this.f47826d = null;
        }
    }

    @Override // d.a.q0.a.g1.d
    public n Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return null;
        }
        return (n) invokeV.objValue;
    }

    public void R() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && getActivity() == null && j) {
            throw new IllegalStateException("AiBaseController: This method should be called after setActivityRef");
        }
    }

    public final void S(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048594, this, z) == null) || this.f47826d == null) {
            return;
        }
        q0.b0(new a(this, z));
    }

    @NonNull
    public Pair<Integer, Integer> T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            d.a.q0.a.h0.g.f J = J();
            if (J == null) {
                return new Pair<>(0, 0);
            }
            return J.a3();
        }
        return (Pair) invokeV.objValue;
    }

    public d.a.q0.a.h0.g.g U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            SwanAppActivity swanAppActivity = this.f47826d;
            if (swanAppActivity == null) {
                return null;
            }
            return swanAppActivity.getSwanAppFragmentManager();
        }
        return (d.a.q0.a.h0.g.g) invokeV.objValue;
    }

    public final void V() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            FullScreenFloatView fullScreenFloatView = this.f47828f;
            if (fullScreenFloatView != null) {
                ViewParent parent = fullScreenFloatView.getParent();
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(this.f47828f);
                }
            }
            d.a.q0.a.p.e.a aVar = this.f47823a;
            if (aVar != null) {
                aVar.E();
            }
            d.a.q0.a.e0.c.e();
        }
    }

    @Override // d.a.q0.a.g1.d
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            d.a.q0.a.a2.e Q = d.a.q0.a.a2.e.Q();
            if (Q == null || Q.N() == null) {
                return null;
            }
            return d.a.q0.a.f1.e.b.k1(Q.N(), f.V().s());
        }
        return (String) invokeV.objValue;
    }

    @Override // d.a.q0.a.g1.d
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            this.f47830h = true;
        }
    }

    @Override // d.a.q0.a.g1.d
    @CallSuper
    public void c(d.a.q0.a.f1.e.b bVar, d.a.q0.a.a1.b bVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048600, this, bVar, bVar2) == null) {
            R();
        }
    }

    @Override // d.a.q0.a.g1.d
    @NonNull
    public d.a.q0.a.a2.n.g d(String str, SwanAppConfigData swanAppConfigData, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048601, this, str, swanAppConfigData, str2)) == null) {
            if (swanAppConfigData != null && !TextUtils.isEmpty(str2)) {
                return this.f47824b.b(str2, str, swanAppConfigData.f11460e);
            }
            return e(str);
        }
        return (d.a.q0.a.a2.n.g) invokeLLL.objValue;
    }

    @Override // d.a.q0.a.g1.d
    @NonNull
    public d.a.q0.a.a2.n.g e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, str)) == null) {
            SwanAppConfigData s = s();
            if (s == null) {
                if (j) {
                    Log.e("AiBaseController", "mConfigData is null." + Log.getStackTraceString(new Exception()));
                }
                return d.a.q0.a.a2.n.g.d();
            }
            return this.f47824b.b(A(), str, s.f11460e);
        }
        return (d.a.q0.a.a2.n.g) invokeL.objValue;
    }

    @Override // d.a.q0.a.g1.d
    public void exit() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            S(true);
        }
    }

    @Override // d.a.q0.a.g1.d
    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            SwanAppConfigData s = s();
            return s == null ? "" : s.e();
        }
        return (String) invokeV.objValue;
    }

    @Override // d.a.q0.a.g1.e.b
    public void g(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048605, this, i2) == null) {
            R();
            d.a.q0.a.v2.c.m().x(this.f47826d);
            S(false);
        }
    }

    @Override // d.a.q0.a.g1.d
    public SwanAppActivity getActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? d.a.q0.a.a2.d.g().x() : (SwanAppActivity) invokeV.objValue;
    }

    @Override // d.a.q0.a.g1.d
    public d.a.q0.a.p.e.c h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            d.a.q0.a.p.e.d B = B(D());
            if (B == null) {
                return null;
            }
            return B.u();
        }
        return (d.a.q0.a.p.e.c) invokeV.objValue;
    }

    @Override // d.a.q0.a.g1.d
    public d.a.q0.a.a2.n.g i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048608, this, str)) == null) {
            SwanAppConfigData s = s();
            if (s == null) {
                if (j) {
                    Log.e("AiBaseController", "mConfigData is null." + Log.getStackTraceString(new Exception()));
                }
                return d.a.q0.a.a2.n.g.d();
            }
            return this.f47824b.a(A(), str, s.f11460e);
        }
        return (d.a.q0.a.a2.n.g) invokeL.objValue;
    }

    @Override // d.a.q0.a.g1.d
    public void k(Context context) {
        e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048609, this, context) == null) || (eVar = this.f47827e) == null) {
            return;
        }
        eVar.f(context);
    }

    @Override // d.a.q0.a.g1.d
    public void l(SwanAppActivity swanAppActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, swanAppActivity) == null) {
            this.f47826d = swanAppActivity;
        }
    }

    @Override // d.a.q0.a.g1.d
    public void m(String str, d.a.q0.a.o0.d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048611, this, str, aVar) == null) {
            d.a.q0.a.h0.u.g.N().I0(str, aVar);
        }
    }

    @Override // d.a.q0.a.g1.d
    public FullScreenFloatView n(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048612, this, activity)) == null) {
            R();
            if (activity == null) {
                return null;
            }
            if (this.f47828f == null) {
                FullScreenFloatView a2 = d.a.q0.a.z1.a.a.a(activity, (ViewGroup) activity.findViewById(16908290), 2);
                this.f47828f = a2;
                a2.setFloatButtonText(activity.getString(d.a.q0.a.h.aiapps_sconsole));
                this.f47828f.setFloatImageBackground(d.a.q0.a.e.aiapps_float_view_button_shape);
                this.f47828f.setVisibility(8);
                this.f47828f.setDragImageListener(new C0758b(this));
            }
            return this.f47828f;
        }
        return (FullScreenFloatView) invokeL.objValue;
    }

    @Override // d.a.q0.a.g1.d
    public void o() {
        SwanAppActivity x;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048613, this) == null) || (x = d.a.q0.a.a2.d.g().x()) == null || x.isFinishing()) {
            return;
        }
        x.removeLoadingView();
    }

    @Override // d.a.q0.a.g1.d
    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            this.f47830h = false;
        }
    }

    @Override // d.a.q0.a.g1.d
    @DebugTrace
    public d.a.q0.a.p.e.a q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            d.a.q0.a.p.e.a b2 = d.a.q0.a.e0.c.b();
            SwanAppActivity swanAppActivity = this.f47826d;
            if (swanAppActivity != null) {
                b2.H((ViewGroup) swanAppActivity.findViewById(d.a.q0.a.f.ai_apps_activity_root));
            }
            return b2;
        }
        return (d.a.q0.a.p.e.a) invokeV.objValue;
    }

    @Override // d.a.q0.a.g1.d
    @NonNull
    public Pair<Integer, Integer> r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            Pair<Integer, Integer> T = T();
            int intValue = ((Integer) T.first).intValue();
            int intValue2 = ((Integer) T.second).intValue();
            if (intValue == 0) {
                intValue = n0.o(AppRuntime.getAppContext());
            }
            if (intValue2 == 0) {
                intValue2 = n0.v(AppRuntime.getAppContext());
            }
            return new Pair<>(Integer.valueOf(intValue), Integer.valueOf(intValue2));
        }
        return (Pair) invokeV.objValue;
    }

    @Override // d.a.q0.a.g1.d
    public SwanAppConfigData s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            d.a.q0.a.a2.d g2 = d.a.q0.a.a2.d.g();
            if (g2.C()) {
                return g2.r().F();
            }
            return null;
        }
        return (SwanAppConfigData) invokeV.objValue;
    }

    @Override // d.a.q0.a.g1.d
    public void t(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, intent) == null) {
            d.a.q0.a.h0.u.g.N().p0(intent);
        }
    }

    @Override // d.a.q0.a.g1.d
    public void u() {
        SwanAppActivity x;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048619, this) == null) || (x = d.a.q0.a.a2.d.g().x()) == null || x.isFinishing()) {
            return;
        }
        x.showLoadingView();
    }

    @Override // d.a.q0.a.g1.d
    public void v(d.a.q0.a.o0.d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, aVar) == null) {
            d.a.q0.a.h0.u.g.N().H0(aVar);
        }
    }

    @Override // d.a.q0.a.g1.d
    @CallSuper
    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            R();
            String V = d.a.q0.a.a2.e.V();
            if (TextUtils.isEmpty(V)) {
                return;
            }
            this.f47830h = true;
            this.f47827e.j();
            Bundle bundle = new Bundle();
            bundle.putString("app_id", V);
            bundle.putInt("task_id", getActivity().getTaskId());
            d.a.q0.a.v1.c.a.e().h(new d.a.q0.a.v1.c.c(9, bundle));
            d.a.q0.a.c1.a.D().c(d.a.q0.a.a2.e.Q() == null ? "" : d.a.q0.a.a2.e.Q().D());
        }
    }

    @Override // d.a.q0.a.g1.d
    @CallSuper
    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            String V = d.a.q0.a.a2.e.V();
            if (TextUtils.isEmpty(V)) {
                return;
            }
            K();
            d.a.q0.a.a2.e Q = d.a.q0.a.a2.e.Q();
            if (Q != null) {
                Q.B().e(Q.getAppId());
            }
            Bundle bundle = new Bundle();
            bundle.putString("app_id", V);
            bundle.putInt("task_id", x0.b().a());
            d.a.q0.a.v1.c.a.e().h(new d.a.q0.a.v1.c.c(10, bundle));
            d.a.q0.a.c1.a.D().a(d.a.q0.a.a2.e.Q() == null ? "" : d.a.q0.a.a2.e.Q().D());
            d.a.q0.a.c1.a.c().b(AppRuntime.getAppContext(), null, DownloadParams.SwanAppDownloadType.TYPE_STOP_SERVICE, null);
        }
    }

    @Override // d.a.q0.a.g1.d
    @NonNull
    public Pair<Integer, Integer> y() {
        InterceptResult invokeV;
        Window window;
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            Context appContext = AppRuntime.getAppContext();
            int n = n0.n(appContext);
            int measuredHeight = (d.a.q0.a.a2.d.g().x() == null || (window = d.a.q0.a.a2.d.g().x().getWindow()) == null || (viewGroup = (ViewGroup) window.getDecorView().findViewById(16908290)) == null || !viewGroup.isLaidOut()) ? 0 : viewGroup.getMeasuredHeight();
            if (measuredHeight >= n) {
                return new Pair<>(Integer.valueOf(n0.o(appContext)), Integer.valueOf(measuredHeight));
            }
            if (Build.VERSION.SDK_INT >= 28) {
                n += f0.e(appContext);
            }
            return new Pair<>(Integer.valueOf(n0.o(appContext)), Integer.valueOf(n));
        }
        return (Pair) invokeV.objValue;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [T, java.lang.String] */
    @Override // d.a.q0.a.g1.d
    public void z(d.a.q0.a.o0.d.d dVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048624, this, dVar, z) == null) {
            d.a.q0.a.r1.g.a("postMessage", "handleNativeMessage start.");
            if (dVar == null) {
                return;
            }
            d.a.q0.a.o0.d.g gVar = new d.a.q0.a.o0.d.g();
            gVar.f49854c = dVar.f49846b;
            gVar.f49855d = z;
            if (j) {
                Log.d("AiBaseController", "handleNativeMessage data: " + dVar.f49846b + " ; needEncode = " + z);
            }
            m(dVar.f49845a, gVar);
            d.a.q0.a.r1.g.a("postMessage", "handleNativeMessage end.");
        }
    }
}
