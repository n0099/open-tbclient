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
import com.repackage.ek2;
import com.repackage.wv3;
import java.io.File;
@Service
/* loaded from: classes6.dex */
public class fx3 extends qk2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean o;
    public transient /* synthetic */ FieldHolder $fh;
    public String k;
    public vv3 l;
    public Runnable m;
    public kx3 n;

    /* loaded from: classes6.dex */
    public class a implements bi2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bi2 a;
        public final /* synthetic */ ek2 b;
        public final /* synthetic */ fx3 c;

        /* renamed from: com.repackage.fx3$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class RunnableC0429a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ai2 a;
            public final /* synthetic */ int b;
            public final /* synthetic */ a c;

            public RunnableC0429a(a aVar, ai2 ai2Var, int i) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, ai2Var, Integer.valueOf(i)};
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
                this.a = ai2Var;
                this.b = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.c.c.i) {
                    return;
                }
                wv3.c cVar = (wv3.c) this.a;
                if (this.b != 0 || cVar == null) {
                    return;
                }
                a aVar = this.c;
                if (aVar.a == null) {
                    return;
                }
                if (aVar.b.m0()) {
                    if (!xt3.m().n()) {
                        fw1.c(false);
                        this.c.b.z0(false);
                    } else {
                        fx3 fx3Var = this.c.c;
                        fx3Var.n(fx3Var.d).setVisibility(0);
                        this.c.c.q().I(this.c.c.f);
                        ew1.b(true);
                        hw1.i("GamesControllerImpl", "init sConsole for devHook");
                    }
                }
                this.c.c.l.c(cVar, this.c.c.d);
                this.c.c.k = cVar.a;
                this.c.a.a(0, cVar);
                this.c.c.e0(cVar.c);
                t04.b().e(cVar.c);
            }
        }

        public a(fx3 fx3Var, bi2 bi2Var, ek2 ek2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fx3Var, bi2Var, ek2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = fx3Var;
            this.a = bi2Var;
            this.b = ek2Var;
        }

        @Override // com.repackage.bi2
        public void a(int i, ai2 ai2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, ai2Var) == null) {
                bd3.d0(this.c.m);
                this.c.m = new RunnableC0429a(this, ai2Var, i);
                bd3.g0(this.c.m);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755692496, "Lcom/repackage/fx3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755692496, "Lcom/repackage/fx3;");
                return;
            }
        }
        o = rf1.a;
    }

    public fx3() {
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
        this.l = new vv3();
        this.n = new kx3();
    }

    @Override // com.repackage.qk2, com.repackage.sk2
    public void E(ek2 ek2Var, bi2 bi2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, ek2Var, bi2Var) == null) {
            super.E(ek2Var, bi2Var);
            if (o) {
                Log.d("GamesControllerImpl", "asyncLoadSwanApp swanCoreVersion: " + ek2Var.j0());
            }
            wv3.c(ek2Var, new a(this, bi2Var, ek2Var));
            gv3.m().I(ek2Var);
            gv3.m().G(ek2Var);
            if (o) {
                Log.d("GamesControllerImpl", "SwanGameCoreRuntime preloadCoreRuntime by asyncLoadSwanApp");
            }
            gv3.m().z(null);
        }
    }

    @Override // com.repackage.qk2, com.repackage.sk2
    public vg1 F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.n : (vg1) invokeV.objValue;
    }

    @Override // com.repackage.qk2, com.repackage.sk2
    public SwanAppPropertyWindow J(Activity activity) {
        InterceptResult invokeL;
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, activity)) == null) {
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

    @Override // com.repackage.qk2, com.repackage.sk2
    public yg1 L() {
        InterceptResult invokeV;
        dv3 dv3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            qy1 T = T();
            if (T == null || (dv3Var = (dv3) T.n(dv3.class)) == null) {
                return null;
            }
            return dv3Var.x3();
        }
        return (yg1) invokeV.objValue;
    }

    @Override // com.repackage.qk2, com.repackage.sk2
    public SwanCoreVersion M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? gv3.m().s() : (SwanCoreVersion) invokeV.objValue;
    }

    @Override // com.repackage.qk2, com.repackage.sk2
    public void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.O();
            gv3.C();
            wy3.a.a().d(new JsObject());
            kf4.k(rb2.p() + File.separator + "tmp");
        }
    }

    @Override // com.repackage.qk2, com.repackage.sk2
    public yg1 P() {
        InterceptResult invokeV;
        dv3 dv3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            qy1 T = T();
            if (T == null || (dv3Var = (dv3) T.n(dv3.class)) == null) {
                return null;
            }
            return dv3Var.v3();
        }
        return (yg1) invokeV.objValue;
    }

    @Override // com.repackage.qk2
    @NonNull
    public Pair<Integer, Integer> S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? r() : (Pair) invokeV.objValue;
    }

    public final void e0(az3 az3Var) {
        hz2 D;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, az3Var) == null) || (D = D()) == null) {
            return;
        }
        D.G0(az3Var);
    }

    @Override // com.repackage.sk2
    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.h : invokeV.booleanValue;
    }

    @Override // com.repackage.qk2, com.repackage.sk2
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

    @Override // com.repackage.qk2, com.repackage.sk2
    public ml1 q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (this.a == null) {
                this.a = new bu3(AppRuntime.getAppContext());
                cu3.h(true);
            }
            this.a.H((ViewGroup) this.d.findViewById(16908290));
            return this.a;
        }
        return (ml1) invokeV.objValue;
    }

    @Override // com.repackage.qk2, com.repackage.sk2
    @NonNull
    public Pair<Integer, Integer> r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? x() : (Pair) invokeV.objValue;
    }

    @Override // com.repackage.qk2, com.repackage.sk2
    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.v();
            SwanAppActivity swanAppActivity = this.d;
            if (swanAppActivity != null && swanAppActivity.getLaunchInfo() != null) {
                ek2.a launchInfo = this.d.getLaunchInfo();
                k63 k63Var = new k63();
                k63Var.a = a63.n(1);
                k63Var.f = launchInfo.H();
                k63Var.c = launchInfo.T();
                k63Var.b = "show";
                k63Var.d(launchInfo.s0().getString(UBCCloudControlProcessor.UBC_KEY));
                k63Var.b(a63.k(launchInfo.W()));
                a63.onEvent(k63Var);
            }
            gm2.h(true);
            wy3.a.a().j();
        }
    }

    @Override // com.repackage.qk2, com.repackage.sk2
    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.w();
            gm2.h(false);
            wy3.a.a().f();
        }
    }

    @Override // com.repackage.qk2, com.repackage.sk2
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
            if (this.d.isLandScape() == ((defaultDisplay.getRotation() == 1 || defaultDisplay.getRotation() == 3) ? true : true)) {
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

    @Override // com.repackage.qk2, com.repackage.sk2
    public String z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? TextUtils.isEmpty(this.k) ? "" : this.k : (String) invokeV.objValue;
    }
}
