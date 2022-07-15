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
import com.repackage.el2;
import com.repackage.ww3;
import java.io.File;
@Service
/* loaded from: classes6.dex */
public class fy3 extends ql2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean o;
    public transient /* synthetic */ FieldHolder $fh;
    public String k;
    public vw3 l;
    public Runnable m;
    public ky3 n;

    /* loaded from: classes6.dex */
    public class a implements bj2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bj2 a;
        public final /* synthetic */ el2 b;
        public final /* synthetic */ fy3 c;

        /* renamed from: com.repackage.fy3$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class RunnableC0642a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ aj2 a;
            public final /* synthetic */ int b;
            public final /* synthetic */ a c;

            public RunnableC0642a(a aVar, aj2 aj2Var, int i) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, aj2Var, Integer.valueOf(i)};
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
                this.a = aj2Var;
                this.b = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.c.c.i) {
                    return;
                }
                ww3.c cVar = (ww3.c) this.a;
                if (this.b != 0 || cVar == null) {
                    return;
                }
                a aVar = this.c;
                if (aVar.a == null) {
                    return;
                }
                if (aVar.b.m0()) {
                    if (!xu3.m().n()) {
                        fx1.c(false);
                        this.c.b.z0(false);
                    } else {
                        fy3 fy3Var = this.c.c;
                        fy3Var.n(fy3Var.d).setVisibility(0);
                        this.c.c.q().H(this.c.c.f);
                        ex1.b(true);
                        hx1.i("GamesControllerImpl", "init sConsole for devHook");
                    }
                }
                this.c.c.l.c(cVar, this.c.c.d);
                this.c.c.k = cVar.a;
                this.c.a.a(0, cVar);
                this.c.c.e0(cVar.c);
                t14.b().e(cVar.c);
            }
        }

        public a(fy3 fy3Var, bj2 bj2Var, el2 el2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fy3Var, bj2Var, el2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = fy3Var;
            this.a = bj2Var;
            this.b = el2Var;
        }

        @Override // com.repackage.bj2
        public void a(int i, aj2 aj2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, aj2Var) == null) {
                be3.d0(this.c.m);
                this.c.m = new RunnableC0642a(this, aj2Var, i);
                be3.g0(this.c.m);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755691535, "Lcom/repackage/fy3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755691535, "Lcom/repackage/fy3;");
                return;
            }
        }
        o = rg1.a;
    }

    public fy3() {
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
        this.l = new vw3();
        this.n = new ky3();
    }

    @Override // com.repackage.ql2, com.repackage.sl2
    public void E(el2 el2Var, bj2 bj2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, el2Var, bj2Var) == null) {
            super.E(el2Var, bj2Var);
            if (o) {
                Log.d("GamesControllerImpl", "asyncLoadSwanApp swanCoreVersion: " + el2Var.j0());
            }
            ww3.c(el2Var, new a(this, bj2Var, el2Var));
            gw3.m().I(el2Var);
            gw3.m().G(el2Var);
            if (o) {
                Log.d("GamesControllerImpl", "SwanGameCoreRuntime preloadCoreRuntime by asyncLoadSwanApp");
            }
            gw3.m().z(null);
        }
    }

    @Override // com.repackage.ql2, com.repackage.sl2
    public vh1 F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.n : (vh1) invokeV.objValue;
    }

    @Override // com.repackage.ql2, com.repackage.sl2
    public SwanAppPropertyWindow J(Activity activity) {
        InterceptResult invokeL;
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, activity)) == null) {
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

    @Override // com.repackage.ql2, com.repackage.sl2
    public yh1 L() {
        InterceptResult invokeV;
        dw3 dw3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            qz1 T = T();
            if (T == null || (dw3Var = (dw3) T.n(dw3.class)) == null) {
                return null;
            }
            return dw3Var.y3();
        }
        return (yh1) invokeV.objValue;
    }

    @Override // com.repackage.ql2, com.repackage.sl2
    public SwanCoreVersion M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? gw3.m().s() : (SwanCoreVersion) invokeV.objValue;
    }

    @Override // com.repackage.ql2, com.repackage.sl2
    public void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.O();
            gw3.C();
            wz3.a.a().d(new JsObject());
            jg4.k(rc2.p() + File.separator + "tmp");
        }
    }

    @Override // com.repackage.ql2, com.repackage.sl2
    public yh1 P() {
        InterceptResult invokeV;
        dw3 dw3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            qz1 T = T();
            if (T == null || (dw3Var = (dw3) T.n(dw3.class)) == null) {
                return null;
            }
            return dw3Var.w3();
        }
        return (yh1) invokeV.objValue;
    }

    @Override // com.repackage.ql2
    @NonNull
    public Pair<Integer, Integer> S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? r() : (Pair) invokeV.objValue;
    }

    public final void e0(a04 a04Var) {
        h03 D;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, a04Var) == null) || (D = D()) == null) {
            return;
        }
        D.H0(a04Var);
    }

    @Override // com.repackage.sl2
    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.h : invokeV.booleanValue;
    }

    @Override // com.repackage.ql2, com.repackage.sl2
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

    @Override // com.repackage.ql2, com.repackage.sl2
    public mm1 q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (this.a == null) {
                this.a = new bv3(AppRuntime.getAppContext());
                cv3.h(true);
            }
            this.a.G((ViewGroup) this.d.findViewById(16908290));
            return this.a;
        }
        return (mm1) invokeV.objValue;
    }

    @Override // com.repackage.ql2, com.repackage.sl2
    @NonNull
    public Pair<Integer, Integer> r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? x() : (Pair) invokeV.objValue;
    }

    @Override // com.repackage.ql2, com.repackage.sl2
    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.v();
            SwanAppActivity swanAppActivity = this.d;
            if (swanAppActivity != null && swanAppActivity.S() != null) {
                el2.a S = this.d.S();
                k73 k73Var = new k73();
                k73Var.a = a73.n(1);
                k73Var.f = S.H();
                k73Var.c = S.T();
                k73Var.b = "show";
                k73Var.d(S.s0().getString(UBCCloudControlProcessor.UBC_KEY));
                k73Var.b(a73.k(S.W()));
                a73.onEvent(k73Var);
            }
            gn2.h(true);
            wz3.a.a().j();
        }
    }

    @Override // com.repackage.ql2, com.repackage.sl2
    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.w();
            gn2.h(false);
            wz3.a.a().f();
        }
    }

    @Override // com.repackage.ql2, com.repackage.sl2
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

    @Override // com.repackage.ql2, com.repackage.sl2
    public String z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? TextUtils.isEmpty(this.k) ? "" : this.k : (String) invokeV.objValue;
    }
}
