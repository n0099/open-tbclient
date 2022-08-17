package com.repackage;

import android.app.Activity;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.Pair;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.ubcprocessor.UBCCloudControlProcessor;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.console.property.SwanAppPropertyWindow;
import com.baidu.swan.apps.res.ui.FullScreenFloatView;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ox3;
import com.repackage.wl2;
import java.io.File;
@Service
/* loaded from: classes7.dex */
public class xy3 extends im2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean o;
    public transient /* synthetic */ FieldHolder $fh;
    public String k;
    public nx3 l;
    public Runnable m;
    public cz3 n;

    /* loaded from: classes7.dex */
    public class a implements tj2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tj2 a;
        public final /* synthetic */ wl2 b;
        public final /* synthetic */ xy3 c;

        /* renamed from: com.repackage.xy3$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class RunnableC0629a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ sj2 a;
            public final /* synthetic */ int b;
            public final /* synthetic */ a c;

            public RunnableC0629a(a aVar, sj2 sj2Var, int i) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, sj2Var, Integer.valueOf(i)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.c = aVar;
                this.a = sj2Var;
                this.b = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.c.c.i) {
                    return;
                }
                ox3.c cVar = (ox3.c) this.a;
                if (this.b != 0 || cVar == null) {
                    return;
                }
                a aVar = this.c;
                if (aVar.a == null) {
                    return;
                }
                if (aVar.b.m0()) {
                    if (!pv3.m().n()) {
                        xx1.c(false);
                        this.c.b.z0(false);
                    } else {
                        xy3 xy3Var = this.c.c;
                        xy3Var.n(xy3Var.d).setVisibility(0);
                        this.c.c.q().F(this.c.c.f);
                        wx1.b(true);
                        zx1.i("GamesControllerImpl", "init sConsole for devHook");
                    }
                }
                this.c.c.l.c(cVar, this.c.c.d);
                this.c.c.k = cVar.a;
                this.c.a.a(0, cVar);
                this.c.c.e0(cVar.c);
                l24.b().e(cVar.c);
            }
        }

        public a(xy3 xy3Var, tj2 tj2Var, wl2 wl2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xy3Var, tj2Var, wl2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = xy3Var;
            this.a = tj2Var;
            this.b = wl2Var;
        }

        @Override // com.repackage.tj2
        public void a(int i, sj2 sj2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, sj2Var) == null) {
                te3.d0(this.c.m);
                this.c.m = new RunnableC0629a(this, sj2Var, i);
                te3.g0(this.c.m);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755155297, "Lcom/repackage/xy3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755155297, "Lcom/repackage/xy3;");
                return;
            }
        }
        o = jh1.a;
    }

    public xy3() {
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
        this.l = new nx3();
        this.n = new cz3();
    }

    @Override // com.repackage.im2, com.repackage.km2
    public void E(wl2 wl2Var, tj2 tj2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, wl2Var, tj2Var) == null) {
            super.E(wl2Var, tj2Var);
            if (o) {
                Log.d("GamesControllerImpl", "asyncLoadSwanApp swanCoreVersion: " + wl2Var.j0());
            }
            ox3.c(wl2Var, new a(this, tj2Var, wl2Var));
            yw3.m().I(wl2Var);
            yw3.m().G(wl2Var);
            if (o) {
                Log.d("GamesControllerImpl", "SwanGameCoreRuntime preloadCoreRuntime by asyncLoadSwanApp");
            }
            yw3.m().z(null);
        }
    }

    @Override // com.repackage.im2, com.repackage.km2
    public ni1 F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.n : (ni1) invokeV.objValue;
    }

    @Override // com.repackage.im2, com.repackage.km2
    public SwanAppPropertyWindow J(Activity activity) {
        InterceptResult invokeL;
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, activity)) == null) {
            if (activity == null) {
                return null;
            }
            if (this.g == null && (viewGroup = (ViewGroup) activity.findViewById(R.id.obfuscated_res_0x7f090171)) != null) {
                SwanAppPropertyWindow swanAppPropertyWindow = new SwanAppPropertyWindow(activity);
                this.g = swanAppPropertyWindow;
                swanAppPropertyWindow.setVisibility(8);
                viewGroup.addView(this.g);
            }
            return this.g;
        }
        return (SwanAppPropertyWindow) invokeL.objValue;
    }

    @Override // com.repackage.im2, com.repackage.km2
    public qi1 L() {
        InterceptResult invokeV;
        vw3 vw3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            i02 T = T();
            if (T == null || (vw3Var = (vw3) T.n(vw3.class)) == null) {
                return null;
            }
            return vw3Var.y3();
        }
        return (qi1) invokeV.objValue;
    }

    @Override // com.repackage.im2, com.repackage.km2
    public SwanCoreVersion M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? yw3.m().s() : (SwanCoreVersion) invokeV.objValue;
    }

    @Override // com.repackage.im2, com.repackage.km2
    public void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.O();
            yw3.C();
            o04.a.a().d(new JsObject());
            bh4.k(jd2.p() + File.separator + "tmp");
        }
    }

    @Override // com.repackage.im2, com.repackage.km2
    public qi1 P() {
        InterceptResult invokeV;
        vw3 vw3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            i02 T = T();
            if (T == null || (vw3Var = (vw3) T.n(vw3.class)) == null) {
                return null;
            }
            return vw3Var.w3();
        }
        return (qi1) invokeV.objValue;
    }

    @Override // com.repackage.im2
    @NonNull
    public Pair<Integer, Integer> S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? r() : (Pair) invokeV.objValue;
    }

    public final void e0(s04 s04Var) {
        z03 D;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, s04Var) == null) || (D = D()) == null) {
            return;
        }
        D.H0(s04Var);
    }

    @Override // com.repackage.km2
    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.h : invokeV.booleanValue;
    }

    @Override // com.repackage.im2, com.repackage.km2
    public FullScreenFloatView n(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, activity)) == null) {
            super.n(activity);
            this.f.setAutoAttachEnable(false);
            return this.f;
        }
        return (FullScreenFloatView) invokeL.objValue;
    }

    @Override // com.repackage.im2, com.repackage.km2
    public en1 q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (this.a == null) {
                this.a = new tv3(AppRuntime.getAppContext());
                uv3.h(true);
            }
            this.a.E((ViewGroup) this.d.findViewById(16908290));
            return this.a;
        }
        return (en1) invokeV.objValue;
    }

    @Override // com.repackage.im2, com.repackage.km2
    @NonNull
    public Pair<Integer, Integer> r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? x() : (Pair) invokeV.objValue;
    }

    @Override // com.repackage.im2, com.repackage.km2
    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.v();
            SwanAppActivity swanAppActivity = this.d;
            if (swanAppActivity != null && swanAppActivity.S() != null) {
                wl2.a S = this.d.S();
                c83 c83Var = new c83();
                c83Var.a = s73.n(1);
                c83Var.f = S.H();
                c83Var.c = S.T();
                c83Var.b = "show";
                c83Var.d(S.s0().getString(UBCCloudControlProcessor.UBC_KEY));
                c83Var.b(s73.k(S.W()));
                s73.onEvent(c83Var);
            }
            yn2.h(true);
            o04.a.a().j();
        }
    }

    @Override // com.repackage.im2, com.repackage.km2
    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.w();
            yn2.h(false);
            o04.a.a().f();
        }
    }

    @Override // com.repackage.im2, com.repackage.km2
    @NonNull
    public Pair<Integer, Integer> x() {
        InterceptResult invokeV;
        int i;
        int i2;
        View decorView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            SwanAppActivity swanAppActivity = this.d;
            if (swanAppActivity == null) {
                return super.x();
            }
            Window window = swanAppActivity.getWindow();
            boolean z = false;
            if (window == null || (decorView = window.getDecorView()) == null) {
                i = 0;
                i2 = 0;
            } else {
                i2 = decorView.getWidth();
                i = decorView.getHeight();
            }
            Display defaultDisplay = this.d.getWindowManager().getDefaultDisplay();
            if (i2 == 0 || i == 0) {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                defaultDisplay.getRealMetrics(displayMetrics);
                i2 = displayMetrics.widthPixels;
                i = displayMetrics.heightPixels;
            }
            if (this.d.i0() == ((defaultDisplay.getRotation() == 1 || defaultDisplay.getRotation() == 3) ? true : true)) {
                int i3 = i2;
                i2 = i;
                i = i3;
            }
            if (o) {
                Log.d("GamesControllerImpl", "getCurScreenSize width:" + i + ",height:" + i2);
            }
            return new Pair<>(Integer.valueOf(i), Integer.valueOf(i2));
        }
        return (Pair) invokeV.objValue;
    }

    @Override // com.repackage.im2, com.repackage.km2
    public String z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? TextUtils.isEmpty(this.k) ? "" : this.k : (String) invokeV.objValue;
    }
}
