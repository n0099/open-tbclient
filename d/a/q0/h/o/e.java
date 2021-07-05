package d.a.q0.h.o;

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
import d.a.q0.a.k;
import d.a.q0.a.l0.f;
import d.a.q0.a.l0.g;
import d.a.q0.a.r1.h;
import d.a.q0.h.r.a;
import d.a.q0.h.s.a;
import java.io.File;
import java.io.IOException;
/* loaded from: classes8.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f53452h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d.a.q0.a.l0.a f53453a;

    /* renamed from: b  reason: collision with root package name */
    public DuMixGameSurfaceView f53454b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.q0.a.y.a f53455c;

    /* renamed from: d  reason: collision with root package name */
    public InterfaceC1156e f53456d;

    /* renamed from: e  reason: collision with root package name */
    public String f53457e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f53458f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f53459g;

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f53460e;

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
            this.f53460e = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f53460e.r();
                this.f53460e.s();
                this.f53460e.u();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.c f53461e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Runnable f53462f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ e f53463g;

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
            this.f53463g = eVar;
            this.f53461e = cVar;
            this.f53462f = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (e.f53452h) {
                    Log.d("SwanGameV8Master", "SwanGameCoreRuntime JSThread run event start");
                }
                d.a.q0.h.c0.a.a aVar = this.f53461e.f53604c;
                d.a.q0.h.r.a aVar2 = aVar == null ? null : aVar.f53189f;
                a.C1168a f2 = d.a.q0.h.r.a.f(aVar2);
                if (f2.b()) {
                    SwanInspectorEndpoint.v().r(aVar2, this.f53463g.f53453a, f2, this.f53462f);
                    return;
                }
                SwanInspectorEndpoint.v().w(f2);
                this.f53462f.run();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements V8ThreadDelegatePolicy {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public DuMixGameSurfaceView f53464b;

        /* loaded from: classes8.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ V8Engine f53465e;

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
                this.f53465e = v8Engine;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (e.f53452h) {
                        Log.d("SwanGameV8Master", "startEngineInternal");
                    }
                    this.f53465e.startEngineInternal();
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
            this.f53464b = duMixGameSurfaceView;
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void doDelegateRunnable(Runnable runnable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, runnable) == null) {
                this.f53464b.t(runnable);
            }
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void doDelegateRunnableDirectly(Runnable runnable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, runnable) == null) {
                this.f53464b.w(runnable);
            }
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public Thread getThread() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f53464b.getThread() : (Thread) invokeV.objValue;
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void shutdown() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.f53464b.l();
            }
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void startV8Engine(V8Engine v8Engine) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, v8Engine) == null) {
                if (e.f53452h) {
                    Log.d("SwanGameV8Master", "startV8Engine");
                }
                this.f53464b.w(new a(this, v8Engine));
            }
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void doDelegateRunnable(Runnable runnable, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, runnable, j) == null) {
                this.f53464b.u(runnable, j);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d extends d.a.q0.a.l0.n.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f53466a;

        /* renamed from: b  reason: collision with root package name */
        public String f53467b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ e f53468c;

        /* loaded from: classes8.dex */
        public class a implements V8EngineConfiguration.JSCacheCallback {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d f53469a;

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
                this.f53469a = dVar;
            }

            @Override // com.baidu.searchbox.v8engine.V8EngineConfiguration.JSCacheCallback
            public void onCacheResult(V8EngineConfiguration.CacheInfo cacheInfo) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, cacheInfo) == null) {
                    this.f53469a.f(cacheInfo);
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
            this.f53468c = eVar;
            this.f53466a = str;
            this.f53467b = str2;
        }

        @Override // d.a.q0.a.l0.n.b
        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f53467b : (String) invokeV.objValue;
        }

        @Override // d.a.q0.a.l0.n.a, d.a.q0.a.l0.n.b
        public V8EngineConfiguration.CodeCacheSetting b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? d.a.q0.h.e.c.a("gameframe", getInitBasePath()) : (V8EngineConfiguration.CodeCacheSetting) invokeV.objValue;
        }

        @Override // d.a.q0.a.l0.n.a, d.a.q0.a.l0.n.b
        public void c(d.a.q0.a.l0.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
                h.p("preload").C(new UbcFlowEvent("na_load_swan_game_js_end"));
                if (this.f53468c.f53456d != null) {
                    this.f53468c.f53456d.a(aVar);
                }
            }
        }

        @Override // d.a.q0.a.l0.n.a, d.a.q0.a.l0.n.b
        public void d(d.a.q0.a.l0.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
                this.f53468c.f53455c.b(aVar, d.a.q0.a.c1.a.b());
                new d.a.q0.h.d.a().a(aVar, d.a.q0.a.c1.a.b());
                aVar.B0(new a(this));
                h.p("preload").C(new UbcFlowEvent("na_load_swan_game_js_start"));
            }
        }

        public final void f(V8EngineConfiguration.CacheInfo cacheInfo) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048580, this, cacheInfo) == null) || cacheInfo == null) {
                return;
            }
            if (e.f53452h) {
                Log.d("SwanGameV8Master", "onCacheResult cached:" + cacheInfo.cached + " ,jsPath: " + cacheInfo.jsPath);
            }
            if (!cacheInfo.cached || TextUtils.isEmpty(cacheInfo.jsPath)) {
                return;
            }
            File file = new File(cacheInfo.jsPath);
            try {
                if (TextUtils.isEmpty(getInitBasePath()) || !file.getCanonicalPath().startsWith(new File(getInitBasePath()).getCanonicalPath())) {
                    if (!TextUtils.isEmpty(this.f53468c.f53457e) && file.getCanonicalPath().startsWith(new File(this.f53468c.f53457e).getCanonicalPath())) {
                        this.f53468c.f53459g = true;
                    }
                } else {
                    this.f53468c.f53458f = true;
                }
            } catch (IOException e2) {
                if (e.f53452h) {
                    e2.printStackTrace();
                }
            }
        }

        @Override // d.a.q0.a.l0.n.b
        public String getInitBasePath() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f53466a : (String) invokeV.objValue;
        }
    }

    /* renamed from: d.a.q0.h.o.e$e  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC1156e {
        void a(d.a.q0.a.l0.a aVar);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1035669352, "Ld/a/q0/h/o/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1035669352, "Ld/a/q0/h/o/e;");
                return;
            }
        }
        f53452h = k.f49133a;
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
        this.f53455c = new d.a.q0.a.y.a();
        q(str, str2);
    }

    public void k(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, activity) == null) {
            this.f53455c.a(activity);
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
            if (f53452h) {
                Log.d("SwanGameV8Master", "SwanGameCoreRuntime finish engine");
            }
            this.f53453a.k0();
            if (this.f53454b.isAttachedToWindow()) {
                return;
            }
            if (f53452h) {
                Log.d("SwanGameV8Master", "SwanGameCoreRuntime finish surfaceView");
            }
            this.f53454b.p();
        }
    }

    public int n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? d.a.q0.h.e.c.b(this.f53458f, this.f53459g) : invokeV.intValue;
    }

    public d.a.q0.a.l0.a o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f53453a : (d.a.q0.a.l0.a) invokeV.objValue;
    }

    public DuMixGameSurfaceView p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f53454b : (DuMixGameSurfaceView) invokeV.objValue;
    }

    public final void q(@NonNull String str, @NonNull String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, str, str2) == null) {
            DuMixGameSurfaceView a2 = d.a.q0.h.q.b.b().a(AppRuntime.getAppContext());
            this.f53454b = a2;
            a2.setRenderMode(1);
            d.a.q0.a.l0.a c2 = f.c(l(), new d(this, str, str2), new c(this, this.f53454b));
            this.f53453a = c2;
            c2.D0(d.a.q0.a.c1.a.b());
            this.f53454b.setV8Engine(this.f53453a);
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f53454b.x();
            this.f53453a.F0(new d.a.q0.a.l0.m.d());
            this.f53453a.H0();
            this.f53453a.E0();
            this.f53453a.C0(d.a.q0.h.e.c.a("gamejs", this.f53457e));
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && f53452h && d.a.q0.a.u1.a.a.f() && new File(d.a.q0.h.h.b.b(), d.a.q0.h.h.b.d()).exists()) {
            this.f53453a.b0(d.a.q0.h.h.b.b().getAbsolutePath(), d.a.q0.h.h.b.d());
        }
    }

    public void t(a.c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, cVar) == null) || cVar == null || TextUtils.isEmpty(cVar.f53602a)) {
            return;
        }
        this.f53457e = cVar.f53602a;
        a aVar = new a(this);
        if (f53452h) {
            Log.d("SwanGameV8Master", "SwanGameCoreRuntime loadAppJs run event");
        }
        this.f53453a.runOnJSThread(new b(this, cVar, aVar));
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (f53452h) {
                Log.d("SwanGameV8Master", "SwanGameCoreRuntime load index.js start.");
            }
            HybridUbcFlow p = h.p("startup");
            p.F(HybridUbcFlow.SubmitStrategy.NA_ONLY);
            p.C(new UbcFlowEvent("na_load_index_js_start"));
            this.f53453a.F(new d.a.q0.h.w.c());
            this.f53453a.b0(this.f53457e, "index.js");
            this.f53453a.F(new d.a.q0.h.w.d());
            h.p("startup").C(new UbcFlowEvent("na_load_index_js_end"));
            if (f53452h) {
                Log.d("SwanGameV8Master", "SwanGameCoreRuntime load index.js end.");
            }
            this.f53453a.y0();
            this.f53454b.o();
        }
    }

    public void v(InterfaceC1156e interfaceC1156e) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, interfaceC1156e) == null) {
            this.f53456d = interfaceC1156e;
        }
    }
}
