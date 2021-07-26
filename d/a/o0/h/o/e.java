package d.a.o0.h.o;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.searchbox.v8engine.V8EngineConfiguration;
import com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.games.glsurface.DuMixGameSurfaceView;
import com.baidu.swan.games.inspector.SwanInspectorEndpoint;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.k;
import d.a.o0.a.l0.f;
import d.a.o0.a.l0.g;
import d.a.o0.a.r1.h;
import d.a.o0.h.r.a;
import d.a.o0.h.s.a;
import java.io.File;
import java.io.IOException;
/* loaded from: classes7.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f50654h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d.a.o0.a.l0.a f50655a;

    /* renamed from: b  reason: collision with root package name */
    public DuMixGameSurfaceView f50656b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.o0.a.y.a f50657c;

    /* renamed from: d  reason: collision with root package name */
    public InterfaceC1114e f50658d;

    /* renamed from: e  reason: collision with root package name */
    public String f50659e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f50660f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f50661g;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f50662e;

        public a(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50662e = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f50662e.r();
                this.f50662e.s();
                this.f50662e.u();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.c f50663e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Runnable f50664f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ e f50665g;

        public b(e eVar, a.c cVar, Runnable runnable) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, cVar, runnable};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50665g = eVar;
            this.f50663e = cVar;
            this.f50664f = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (e.f50654h) {
                    Log.d("SwanGameV8Master", "SwanGameCoreRuntime JSThread run event start");
                }
                d.a.o0.h.c0.a.a aVar = this.f50663e.f50806c;
                d.a.o0.h.r.a aVar2 = aVar == null ? null : aVar.f50391f;
                a.C1126a f2 = d.a.o0.h.r.a.f(aVar2);
                if (f2.b()) {
                    SwanInspectorEndpoint.v().r(aVar2, this.f50665g.f50655a, f2, this.f50664f);
                    return;
                }
                SwanInspectorEndpoint.v().w(f2);
                this.f50664f.run();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements V8ThreadDelegatePolicy {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public DuMixGameSurfaceView f50666b;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ V8Engine f50667e;

            public a(c cVar, V8Engine v8Engine) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, v8Engine};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f50667e = v8Engine;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (e.f50654h) {
                        Log.d("SwanGameV8Master", "startEngineInternal");
                    }
                    this.f50667e.startEngineInternal();
                }
            }
        }

        public c(e eVar, DuMixGameSurfaceView duMixGameSurfaceView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, duMixGameSurfaceView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50666b = duMixGameSurfaceView;
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void doDelegateRunnable(Runnable runnable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, runnable) == null) {
                this.f50666b.t(runnable);
            }
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void doDelegateRunnableDirectly(Runnable runnable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, runnable) == null) {
                this.f50666b.w(runnable);
            }
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public Thread getThread() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f50666b.getThread() : (Thread) invokeV.objValue;
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void shutdown() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.f50666b.l();
            }
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void startV8Engine(V8Engine v8Engine) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, v8Engine) == null) {
                if (e.f50654h) {
                    Log.d("SwanGameV8Master", "startV8Engine");
                }
                this.f50666b.w(new a(this, v8Engine));
            }
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void doDelegateRunnable(Runnable runnable, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, runnable, j) == null) {
                this.f50666b.u(runnable, j);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d extends d.a.o0.a.l0.n.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f50668a;

        /* renamed from: b  reason: collision with root package name */
        public String f50669b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ e f50670c;

        /* loaded from: classes7.dex */
        public class a implements V8EngineConfiguration.JSCacheCallback {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d f50671a;

            public a(d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f50671a = dVar;
            }

            @Override // com.baidu.searchbox.v8engine.V8EngineConfiguration.JSCacheCallback
            public void onCacheResult(V8EngineConfiguration.CacheInfo cacheInfo) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, cacheInfo) == null) {
                    this.f50671a.f(cacheInfo);
                }
            }
        }

        public d(@NonNull e eVar, @NonNull String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50670c = eVar;
            this.f50668a = str;
            this.f50669b = str2;
        }

        @Override // d.a.o0.a.l0.n.b
        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f50669b : (String) invokeV.objValue;
        }

        @Override // d.a.o0.a.l0.n.a, d.a.o0.a.l0.n.b
        public V8EngineConfiguration.CodeCacheSetting b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? d.a.o0.h.e.c.a("gameframe", getInitBasePath()) : (V8EngineConfiguration.CodeCacheSetting) invokeV.objValue;
        }

        @Override // d.a.o0.a.l0.n.a, d.a.o0.a.l0.n.b
        public void c(d.a.o0.a.l0.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
                h.p("preload").C(new UbcFlowEvent("na_load_swan_game_js_end"));
                if (this.f50670c.f50658d != null) {
                    this.f50670c.f50658d.a(aVar);
                }
            }
        }

        @Override // d.a.o0.a.l0.n.a, d.a.o0.a.l0.n.b
        public void d(d.a.o0.a.l0.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
                this.f50670c.f50657c.b(aVar, d.a.o0.a.c1.a.b());
                new d.a.o0.h.d.a().a(aVar, d.a.o0.a.c1.a.b());
                aVar.B0(new a(this));
                h.p("preload").C(new UbcFlowEvent("na_load_swan_game_js_start"));
            }
        }

        public final void f(V8EngineConfiguration.CacheInfo cacheInfo) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048580, this, cacheInfo) == null) || cacheInfo == null) {
                return;
            }
            if (e.f50654h) {
                Log.d("SwanGameV8Master", "onCacheResult cached:" + cacheInfo.cached + " ,jsPath: " + cacheInfo.jsPath);
            }
            if (!cacheInfo.cached || TextUtils.isEmpty(cacheInfo.jsPath)) {
                return;
            }
            File file = new File(cacheInfo.jsPath);
            try {
                if (TextUtils.isEmpty(getInitBasePath()) || !file.getCanonicalPath().startsWith(new File(getInitBasePath()).getCanonicalPath())) {
                    if (!TextUtils.isEmpty(this.f50670c.f50659e) && file.getCanonicalPath().startsWith(new File(this.f50670c.f50659e).getCanonicalPath())) {
                        this.f50670c.f50661g = true;
                    }
                } else {
                    this.f50670c.f50660f = true;
                }
            } catch (IOException e2) {
                if (e.f50654h) {
                    e2.printStackTrace();
                }
            }
        }

        @Override // d.a.o0.a.l0.n.b
        public String getInitBasePath() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f50668a : (String) invokeV.objValue;
        }
    }

    /* renamed from: d.a.o0.h.o.e$e  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC1114e {
        void a(d.a.o0.a.l0.a aVar);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(355610982, "Ld/a/o0/h/o/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(355610982, "Ld/a/o0/h/o/e;");
                return;
            }
        }
        f50654h = k.f46335a;
    }

    public e(@NonNull String str, @NonNull String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f50657c = new d.a.o0.a.y.a();
        q(str, str2);
    }

    public void k(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, activity) == null) {
            this.f50657c.a(activity);
        }
    }

    public final g l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            g.b bVar = new g.b();
            bVar.c(2);
            bVar.b("master");
            return bVar.a();
        }
        return (g) invokeV.objValue;
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (f50654h) {
                Log.d("SwanGameV8Master", "SwanGameCoreRuntime finish engine");
            }
            this.f50655a.h0();
            if (this.f50656b.isAttachedToWindow()) {
                return;
            }
            if (f50654h) {
                Log.d("SwanGameV8Master", "SwanGameCoreRuntime finish surfaceView");
            }
            this.f50656b.p();
        }
    }

    public int n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? d.a.o0.h.e.c.b(this.f50660f, this.f50661g) : invokeV.intValue;
    }

    public d.a.o0.a.l0.a o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f50655a : (d.a.o0.a.l0.a) invokeV.objValue;
    }

    public DuMixGameSurfaceView p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f50656b : (DuMixGameSurfaceView) invokeV.objValue;
    }

    public final void q(@NonNull String str, @NonNull String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, str, str2) == null) {
            DuMixGameSurfaceView a2 = d.a.o0.h.q.b.b().a(AppRuntime.getAppContext());
            this.f50656b = a2;
            a2.setRenderMode(1);
            d.a.o0.a.l0.a c2 = f.c(l(), new d(this, str, str2), new c(this, this.f50656b));
            this.f50655a = c2;
            c2.D0(d.a.o0.a.c1.a.b());
            this.f50656b.setV8Engine(this.f50655a);
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f50656b.x();
            this.f50655a.F0(new d.a.o0.a.l0.m.d());
            this.f50655a.H0();
            this.f50655a.E0();
            this.f50655a.C0(d.a.o0.h.e.c.a("gamejs", this.f50659e));
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && f50654h && d.a.o0.a.u1.a.a.f() && new File(d.a.o0.h.h.b.b(), d.a.o0.h.h.b.d()).exists()) {
            this.f50655a.b0(d.a.o0.h.h.b.b().getAbsolutePath(), d.a.o0.h.h.b.d());
        }
    }

    public void t(a.c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, cVar) == null) || cVar == null || TextUtils.isEmpty(cVar.f50804a)) {
            return;
        }
        this.f50659e = cVar.f50804a;
        a aVar = new a(this);
        if (f50654h) {
            Log.d("SwanGameV8Master", "SwanGameCoreRuntime loadAppJs run event");
        }
        this.f50655a.runOnJSThread(new b(this, cVar, aVar));
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (f50654h) {
                Log.d("SwanGameV8Master", "SwanGameCoreRuntime load index.js start.");
            }
            HybridUbcFlow p = h.p("startup");
            p.F(HybridUbcFlow.SubmitStrategy.NA_ONLY);
            p.C(new UbcFlowEvent("na_load_index_js_start"));
            this.f50655a.F(new d.a.o0.h.w.c());
            this.f50655a.b0(this.f50659e, "index.js");
            this.f50655a.F(new d.a.o0.h.w.d());
            h.p("startup").C(new UbcFlowEvent("na_load_index_js_end"));
            if (f50654h) {
                Log.d("SwanGameV8Master", "SwanGameCoreRuntime load index.js end.");
            }
            this.f50655a.y0();
            this.f50656b.o();
        }
    }

    public void v(InterfaceC1114e interfaceC1114e) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, interfaceC1114e) == null) {
            this.f50658d = interfaceC1114e;
        }
    }
}
