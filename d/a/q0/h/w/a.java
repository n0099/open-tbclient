package d.a.q0.h.w;

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
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.f;
import d.a.q0.a.f1.e.b;
import d.a.q0.a.h0.g.g;
import d.a.q0.a.k;
import d.a.q0.a.p.b.a.n;
import d.a.q0.a.v2.q0;
import d.a.q0.h.f.h;
import d.a.q0.h.f.i;
import d.a.q0.h.s.a;
import java.io.File;
@Service
/* loaded from: classes8.dex */
public class a extends d.a.q0.a.g1.b {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean o;
    public transient /* synthetic */ FieldHolder $fh;
    public String k;
    public d.a.q0.h.r.b l;
    public Runnable m;
    public d.a.q0.h.x.a n;

    /* renamed from: d.a.q0.h.w.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1174a implements d.a.q0.a.a1.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.a1.b f53640a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.f1.e.b f53641b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f53642c;

        /* renamed from: d.a.q0.h.w.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class RunnableC1175a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.q0.a.a1.a f53643e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f53644f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ C1174a f53645g;

            public RunnableC1175a(C1174a c1174a, d.a.q0.a.a1.a aVar, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c1174a, aVar, Integer.valueOf(i2)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f53645g = c1174a;
                this.f53643e = aVar;
                this.f53644f = i2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f53645g.f53642c.f47831i) {
                    return;
                }
                a.c cVar = (a.c) this.f53643e;
                if (this.f53644f != 0 || cVar == null) {
                    return;
                }
                C1174a c1174a = this.f53645g;
                if (c1174a.f53640a == null) {
                    return;
                }
                if (c1174a.f53641b.l0()) {
                    if (!d.a.q0.h.f.d.m().n()) {
                        d.a.q0.a.e0.b.c(false);
                        this.f53645g.f53641b.y0(false);
                    } else {
                        a aVar = this.f53645g.f53642c;
                        aVar.n(aVar.f47826d).setVisibility(0);
                        this.f53645g.f53642c.q().I(this.f53645g.f53642c.f47828f);
                        d.a.q0.a.e0.a.b(true);
                        d.a.q0.a.e0.d.g("GamesControllerImpl", "init sConsole for devHook");
                    }
                }
                this.f53645g.f53642c.l.c(cVar, this.f53645g.f53642c.f47826d);
                this.f53645g.f53642c.k = cVar.f53602a;
                this.f53645g.f53640a.a(0, cVar);
                this.f53645g.f53642c.f0(cVar.f53604c);
                d.a.q0.h.i0.a.b().e(cVar.f53604c);
            }
        }

        public C1174a(a aVar, d.a.q0.a.a1.b bVar, d.a.q0.a.f1.e.b bVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, bVar, bVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53642c = aVar;
            this.f53640a = bVar;
            this.f53641b = bVar2;
        }

        @Override // d.a.q0.a.a1.b
        public void a(int i2, d.a.q0.a.a1.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, aVar) == null) {
                q0.a0(this.f53642c.m);
                this.f53642c.m = new RunnableC1175a(this, aVar, i2);
                q0.d0(this.f53642c.m);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1035907556, "Ld/a/q0/h/w/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1035907556, "Ld/a/q0/h/w/a;");
                return;
            }
        }
        o = k.f49133a;
    }

    public a() {
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
        this.l = new d.a.q0.h.r.b();
        this.n = new d.a.q0.h.x.a();
    }

    @Override // d.a.q0.a.g1.b, d.a.q0.a.g1.d
    public String A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? TextUtils.isEmpty(this.k) ? "" : this.k : (String) invokeV.objValue;
    }

    @Override // d.a.q0.a.g1.b, d.a.q0.a.g1.d
    public void G(d.a.q0.a.f1.e.b bVar, d.a.q0.a.a1.b bVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, bVar2) == null) {
            super.G(bVar, bVar2);
            if (o) {
                Log.d("GamesControllerImpl", "asyncLoadSwanApp swanCoreVersion: " + bVar.i0());
            }
            d.a.q0.h.s.a.c(bVar, new C1174a(this, bVar2, bVar));
            d.a.q0.h.o.c.m().I(bVar);
            d.a.q0.h.o.c.m().G(bVar);
            if (o) {
                Log.d("GamesControllerImpl", "SwanGameCoreRuntime preloadCoreRuntime by asyncLoadSwanApp");
            }
            d.a.q0.h.o.c.m().z(null);
        }
    }

    @Override // d.a.q0.a.g1.b, d.a.q0.a.g1.d
    public d.a.q0.a.p.b.a.k H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.n : (d.a.q0.a.p.b.a.k) invokeV.objValue;
    }

    @Override // d.a.q0.a.g1.b, d.a.q0.a.g1.d
    public SwanAppPropertyWindow L(Activity activity) {
        InterceptResult invokeL;
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, activity)) == null) {
            if (activity == null) {
                return null;
            }
            if (this.f47829g == null && (viewGroup = (ViewGroup) activity.findViewById(f.ai_apps_activity_root)) != null) {
                SwanAppPropertyWindow swanAppPropertyWindow = new SwanAppPropertyWindow(activity);
                this.f47829g = swanAppPropertyWindow;
                swanAppPropertyWindow.setVisibility(8);
                viewGroup.addView(this.f47829g);
            }
            return this.f47829g;
        }
        return (SwanAppPropertyWindow) invokeL.objValue;
    }

    @Override // d.a.q0.a.g1.b, d.a.q0.a.g1.d
    public n M() {
        InterceptResult invokeV;
        d.a.q0.h.n.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            g U = U();
            if (U == null || (aVar = (d.a.q0.h.n.a) U.n(d.a.q0.h.n.a.class)) == null) {
                return null;
            }
            return aVar.k3();
        }
        return (n) invokeV.objValue;
    }

    @Override // d.a.q0.a.g1.b, d.a.q0.a.g1.d
    public SwanCoreVersion N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? d.a.q0.h.o.c.m().s() : (SwanCoreVersion) invokeV.objValue;
    }

    @Override // d.a.q0.a.g1.b, d.a.q0.a.g1.d
    public void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.P();
            d.a.q0.h.o.c.C();
            d.a.q0.h.a0.b.f53048a.a().d(new JsObject());
            d.a.q0.t.d.j(d.a.q0.a.r0.n.n() + File.separator + "tmp");
        }
    }

    @Override // d.a.q0.a.g1.b, d.a.q0.a.g1.d
    public n Q() {
        InterceptResult invokeV;
        d.a.q0.h.n.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            g U = U();
            if (U == null || (aVar = (d.a.q0.h.n.a) U.n(d.a.q0.h.n.a.class)) == null) {
                return null;
            }
            return aVar.i3();
        }
        return (n) invokeV.objValue;
    }

    @Override // d.a.q0.a.g1.b
    @NonNull
    public Pair<Integer, Integer> T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? r() : (Pair) invokeV.objValue;
    }

    public final void f0(d.a.q0.h.c0.a.a aVar) {
        d.a.q0.a.a2.e F;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, aVar) == null) || (F = F()) == null) {
            return;
        }
        F.u0(aVar);
    }

    @Override // d.a.q0.a.g1.d
    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f47830h : invokeV.booleanValue;
    }

    @Override // d.a.q0.a.g1.b, d.a.q0.a.g1.d
    public FullScreenFloatView n(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, activity)) == null) {
            super.n(activity);
            this.f47828f.setAutoAttachEnable(false);
            return this.f47828f;
        }
        return (FullScreenFloatView) invokeL.objValue;
    }

    @Override // d.a.q0.a.g1.b, d.a.q0.a.g1.d
    public d.a.q0.a.p.e.a q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (this.f47823a == null) {
                this.f47823a = new h(AppRuntime.getAppContext());
                i.h(true);
            }
            this.f47823a.H((ViewGroup) this.f47826d.findViewById(16908290));
            return this.f47823a;
        }
        return (d.a.q0.a.p.e.a) invokeV.objValue;
    }

    @Override // d.a.q0.a.g1.b, d.a.q0.a.g1.d
    @NonNull
    public Pair<Integer, Integer> r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? y() : (Pair) invokeV.objValue;
    }

    @Override // d.a.q0.a.g1.b, d.a.q0.a.g1.d
    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.w();
            SwanAppActivity swanAppActivity = this.f47826d;
            if (swanAppActivity != null && swanAppActivity.getLaunchInfo() != null) {
                b.a launchInfo = this.f47826d.getLaunchInfo();
                d.a.q0.a.j2.p.f fVar = new d.a.q0.a.j2.p.f();
                fVar.f49119a = d.a.q0.a.j2.k.m(1);
                fVar.f49124f = launchInfo.H();
                fVar.f49121c = launchInfo.T();
                fVar.f49120b = "show";
                fVar.d(launchInfo.r0().getString(UBCCloudControlProcessor.UBC_KEY));
                fVar.b(d.a.q0.a.j2.k.k(launchInfo.W()));
                d.a.q0.a.j2.k.onEvent(fVar);
            }
            d.a.q0.a.i1.b.h(true);
            d.a.q0.h.a0.b.f53048a.a().j();
        }
    }

    @Override // d.a.q0.a.g1.b, d.a.q0.a.g1.d
    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.x();
            d.a.q0.a.i1.b.h(false);
            d.a.q0.h.a0.b.f53048a.a().f();
        }
    }

    @Override // d.a.q0.a.g1.b, d.a.q0.a.g1.d
    @NonNull
    public Pair<Integer, Integer> y() {
        InterceptResult invokeV;
        int i2;
        int i3;
        View decorView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            SwanAppActivity swanAppActivity = this.f47826d;
            if (swanAppActivity == null) {
                return super.y();
            }
            Window window = swanAppActivity.getWindow();
            boolean z = false;
            if (window == null || (decorView = window.getDecorView()) == null) {
                i2 = 0;
                i3 = 0;
            } else {
                i3 = decorView.getWidth();
                i2 = decorView.getHeight();
            }
            Display defaultDisplay = this.f47826d.getWindowManager().getDefaultDisplay();
            if (i3 == 0 || i2 == 0) {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                defaultDisplay.getRealMetrics(displayMetrics);
                i3 = displayMetrics.widthPixels;
                i2 = displayMetrics.heightPixels;
            }
            if (this.f47826d.isLandScape() == ((defaultDisplay.getRotation() == 1 || defaultDisplay.getRotation() == 3) ? true : true)) {
                int i4 = i3;
                i3 = i2;
                i2 = i4;
            }
            if (o) {
                Log.d("GamesControllerImpl", "getCurScreenSize width:" + i2 + ",height:" + i3);
            }
            return new Pair<>(Integer.valueOf(i2), Integer.valueOf(i3));
        }
        return (Pair) invokeV.objValue;
    }
}
