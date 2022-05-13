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
import com.repackage.jx3;
import com.repackage.rl2;
import java.io.File;
@Service
/* loaded from: classes7.dex */
public class sy3 extends dm2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean o;
    public transient /* synthetic */ FieldHolder $fh;
    public String k;
    public ix3 l;
    public Runnable m;
    public xy3 n;

    /* loaded from: classes7.dex */
    public class a implements oj2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oj2 a;
        public final /* synthetic */ rl2 b;
        public final /* synthetic */ sy3 c;

        /* renamed from: com.repackage.sy3$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class RunnableC0521a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ nj2 a;
            public final /* synthetic */ int b;
            public final /* synthetic */ a c;

            public RunnableC0521a(a aVar, nj2 nj2Var, int i) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, nj2Var, Integer.valueOf(i)};
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
                this.a = nj2Var;
                this.b = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.c.c.i) {
                    return;
                }
                jx3.c cVar = (jx3.c) this.a;
                if (this.b != 0 || cVar == null) {
                    return;
                }
                a aVar = this.c;
                if (aVar.a == null) {
                    return;
                }
                if (aVar.b.m0()) {
                    if (!kv3.m().n()) {
                        sx1.c(false);
                        this.c.b.z0(false);
                    } else {
                        sy3 sy3Var = this.c.c;
                        sy3Var.n(sy3Var.d).setVisibility(0);
                        this.c.c.q().I(this.c.c.f);
                        rx1.b(true);
                        ux1.i("GamesControllerImpl", "init sConsole for devHook");
                    }
                }
                this.c.c.l.c(cVar, this.c.c.d);
                this.c.c.k = cVar.a;
                this.c.a.a(0, cVar);
                this.c.c.e0(cVar.c);
                g24.b().e(cVar.c);
            }
        }

        public a(sy3 sy3Var, oj2 oj2Var, rl2 rl2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sy3Var, oj2Var, rl2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = sy3Var;
            this.a = oj2Var;
            this.b = rl2Var;
        }

        @Override // com.repackage.oj2
        public void a(int i, nj2 nj2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, nj2Var) == null) {
                oe3.d0(this.c.m);
                this.c.m = new RunnableC0521a(this, nj2Var, i);
                oe3.g0(this.c.m);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755304252, "Lcom/repackage/sy3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755304252, "Lcom/repackage/sy3;");
                return;
            }
        }
        o = eh1.a;
    }

    public sy3() {
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
        this.l = new ix3();
        this.n = new xy3();
    }

    @Override // com.repackage.dm2, com.repackage.fm2
    public void E(rl2 rl2Var, oj2 oj2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, rl2Var, oj2Var) == null) {
            super.E(rl2Var, oj2Var);
            if (o) {
                Log.d("GamesControllerImpl", "asyncLoadSwanApp swanCoreVersion: " + rl2Var.j0());
            }
            jx3.c(rl2Var, new a(this, oj2Var, rl2Var));
            tw3.m().I(rl2Var);
            tw3.m().G(rl2Var);
            if (o) {
                Log.d("GamesControllerImpl", "SwanGameCoreRuntime preloadCoreRuntime by asyncLoadSwanApp");
            }
            tw3.m().z(null);
        }
    }

    @Override // com.repackage.dm2, com.repackage.fm2
    public ii1 F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.n : (ii1) invokeV.objValue;
    }

    @Override // com.repackage.dm2, com.repackage.fm2
    public SwanAppPropertyWindow J(Activity activity) {
        InterceptResult invokeL;
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, activity)) == null) {
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

    @Override // com.repackage.dm2, com.repackage.fm2
    public li1 L() {
        InterceptResult invokeV;
        qw3 qw3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            d02 T = T();
            if (T == null || (qw3Var = (qw3) T.n(qw3.class)) == null) {
                return null;
            }
            return qw3Var.x3();
        }
        return (li1) invokeV.objValue;
    }

    @Override // com.repackage.dm2, com.repackage.fm2
    public SwanCoreVersion M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? tw3.m().s() : (SwanCoreVersion) invokeV.objValue;
    }

    @Override // com.repackage.dm2, com.repackage.fm2
    public void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.O();
            tw3.C();
            j04.a.a().d(new JsObject());
            xg4.k(ed2.p() + File.separator + "tmp");
        }
    }

    @Override // com.repackage.dm2, com.repackage.fm2
    public li1 P() {
        InterceptResult invokeV;
        qw3 qw3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            d02 T = T();
            if (T == null || (qw3Var = (qw3) T.n(qw3.class)) == null) {
                return null;
            }
            return qw3Var.v3();
        }
        return (li1) invokeV.objValue;
    }

    @Override // com.repackage.dm2
    @NonNull
    public Pair<Integer, Integer> S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? r() : (Pair) invokeV.objValue;
    }

    public final void e0(n04 n04Var) {
        u03 D;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, n04Var) == null) || (D = D()) == null) {
            return;
        }
        D.G0(n04Var);
    }

    @Override // com.repackage.fm2
    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.h : invokeV.booleanValue;
    }

    @Override // com.repackage.dm2, com.repackage.fm2
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

    @Override // com.repackage.dm2, com.repackage.fm2
    public zm1 q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (this.a == null) {
                this.a = new ov3(AppRuntime.getAppContext());
                pv3.h(true);
            }
            this.a.H((ViewGroup) this.d.findViewById(16908290));
            return this.a;
        }
        return (zm1) invokeV.objValue;
    }

    @Override // com.repackage.dm2, com.repackage.fm2
    @NonNull
    public Pair<Integer, Integer> r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? x() : (Pair) invokeV.objValue;
    }

    @Override // com.repackage.dm2, com.repackage.fm2
    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.v();
            SwanAppActivity swanAppActivity = this.d;
            if (swanAppActivity != null && swanAppActivity.getLaunchInfo() != null) {
                rl2.a launchInfo = this.d.getLaunchInfo();
                x73 x73Var = new x73();
                x73Var.a = n73.n(1);
                x73Var.f = launchInfo.H();
                x73Var.c = launchInfo.T();
                x73Var.b = "show";
                x73Var.d(launchInfo.s0().getString(UBCCloudControlProcessor.UBC_KEY));
                x73Var.b(n73.k(launchInfo.W()));
                n73.onEvent(x73Var);
            }
            tn2.h(true);
            j04.a.a().j();
        }
    }

    @Override // com.repackage.dm2, com.repackage.fm2
    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.w();
            tn2.h(false);
            j04.a.a().f();
        }
    }

    @Override // com.repackage.dm2, com.repackage.fm2
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

    @Override // com.repackage.dm2, com.repackage.fm2
    public String z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? TextUtils.isEmpty(this.k) ? "" : this.k : (String) invokeV.objValue;
    }
}
