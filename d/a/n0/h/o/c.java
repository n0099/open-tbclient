package d.a.n0.h.o;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.alibaba.fastjson.asm.Label;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.SwanAppErrorActivity;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.games.glsurface.DuMixGameSurfaceView;
import com.baidu.tieba.service.AsInstallService;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.n0.a.h0.g.g;
import d.a.n0.a.k;
import d.a.n0.a.r1.h;
import d.a.n0.a.v2.q0;
import d.a.n0.f.g;
import d.a.n0.h.o.e;
import d.a.n0.h.s.a;
import java.io.File;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes7.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean j;
    public static volatile c k;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f50134a;

    /* renamed from: b  reason: collision with root package name */
    public final Object f50135b;

    /* renamed from: c  reason: collision with root package name */
    public SwanCoreVersion f50136c;

    /* renamed from: d  reason: collision with root package name */
    public ExtensionCore f50137d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.n0.h.o.e f50138e;

    /* renamed from: f  reason: collision with root package name */
    public List<f> f50139f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f50140g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f50141h;

    /* renamed from: i  reason: collision with root package name */
    public String f50142i;

    /* loaded from: classes7.dex */
    public class a implements f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // d.a.n0.h.o.c.f
        public void onReady() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && c.j) {
                d.a.n0.a.z1.b.f.e f2 = d.a.n0.a.z1.b.f.e.f(AppRuntime.getAppContext(), g.aiapps_game_preload_core_runtime_end);
                f2.l(1);
                f2.F();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Intent addFlags = new Intent().putExtra(SwanAppErrorActivity.KEY_SWAN_ERROR_TYPE, SwanAppErrorActivity.TYPE_LOAD_V8_FAILED).setComponent(new ComponentName(AppRuntime.getAppContext(), SwanAppErrorActivity.class)).addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
                if (d.a.n0.a.a2.e.i() != null) {
                    d.a.n0.a.v2.f.j(d.a.n0.a.a2.e.i().x());
                }
                AppRuntime.getAppContext().startActivity(addFlags);
            }
        }
    }

    /* renamed from: d.a.n0.h.o.c$c  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1104c implements f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.c f50143a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f50144b;

        /* renamed from: d.a.n0.h.o.c$c$a */
        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ C1104c f50145e;

            public a(C1104c c1104c) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c1104c};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f50145e = c1104c;
            }

            @Override // java.lang.Runnable
            public void run() {
                SwanAppActivity activity;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f50145e.f50144b.f50141h || this.f50145e.f50144b.f50138e == null || (activity = d.a.n0.a.g1.f.V().getActivity()) == null || activity.isFinishing() || activity.getSwanAppFragmentManager() == null) {
                    return;
                }
                if (c.j) {
                    Log.d("SwanGameCoreRuntime", "loadAppJs start: " + this.f50145e.f50144b.f50142i);
                }
                this.f50145e.f50144b.f50138e.k(activity);
                this.f50145e.f50144b.f50138e.t(this.f50145e.f50143a);
                if (this.f50145e.f50144b.v()) {
                    this.f50145e.f50144b.F(activity);
                }
            }
        }

        public C1104c(c cVar, a.c cVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, cVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50144b = cVar;
            this.f50143a = cVar2;
        }

        @Override // d.a.n0.h.o.c.f
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                h.p("startup").C(new UbcFlowEvent("na_prepare_runtime_end"));
                q0.b0(new a(this));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements e.InterfaceC1105e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f50146a;

        public d(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50146a = cVar;
        }

        @Override // d.a.n0.h.o.e.InterfaceC1105e
        public void a(d.a.n0.a.l0.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                if (c.j) {
                    Log.d("SwanGameCoreRuntime", "prepareMaster end.");
                }
                synchronized (this.f50146a.f50135b) {
                    this.f50146a.f50140g = true;
                    this.f50146a.w();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public e(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Toast.makeText(AppRuntime.getAppContext(), g.aiapps_debug_game_core_package_error, 1).show();
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface f {
        void onReady();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2131901913, "Ld/a/n0/h/o/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2131901913, "Ld/a/n0/h/o/c;");
                return;
            }
        }
        j = k.f45831a;
    }

    public c() {
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
        this.f50134a = -1;
        this.f50135b = new Object();
        this.f50139f = new CopyOnWriteArrayList();
    }

    public static synchronized void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            synchronized (c.class) {
                if (j) {
                    Log.d("SwanGameCoreRuntime", "release");
                }
                if (k == null) {
                    return;
                }
                k.f50141h = true;
                if (k.f50138e != null) {
                    k.f50138e.m();
                }
                k = null;
                m().y();
            }
        }
    }

    public static c m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            if (k == null) {
                synchronized (c.class) {
                    if (k == null) {
                        k = new c();
                    }
                }
            }
            return k;
        }
        return (c) invokeV.objValue;
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this.f50135b) {
                if (!this.f50140g && this.f50138e == null) {
                    K();
                    J();
                    String l = l();
                    if (TextUtils.isEmpty(l) || this.f50141h) {
                        return;
                    }
                    if (j) {
                        Log.d("SwanGameCoreRuntime", "prepareMaster start: " + l);
                    }
                    d.a.n0.h.o.e eVar = new d.a.n0.h.o.e(l, "swan-game.js");
                    this.f50138e = eVar;
                    eVar.v(new d(this));
                }
            }
        }
    }

    public void B(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar) == null) {
            if (j) {
                Log.d("SwanGameCoreRuntime", "prepareRuntime");
            }
            if (fVar != null && !this.f50139f.contains(fVar)) {
                this.f50139f.add(fVar);
            }
            if (u()) {
                w();
            } else {
                A();
            }
        }
    }

    public void D(ExtensionCore extensionCore) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, extensionCore) == null) {
            if (extensionCore != null && extensionCore.isAvailable()) {
                if (j) {
                    Log.d("SwanGameCoreRuntime", "setExtensionCore: " + this.f50137d);
                }
                this.f50137d = extensionCore;
            } else if (j) {
                StringBuilder sb = new StringBuilder();
                sb.append("setExtensionCore invalid: ");
                Object obj = extensionCore;
                if (extensionCore == null) {
                    obj = " null";
                }
                sb.append(obj);
                Log.w("SwanGameCoreRuntime", sb.toString());
            }
        }
    }

    public final void E(SwanCoreVersion swanCoreVersion) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, swanCoreVersion) == null) && swanCoreVersion != null && swanCoreVersion.isAvailable()) {
            this.f50136c = swanCoreVersion;
            if (j) {
                Log.d("SwanGameCoreRuntime", "setSwanCoreVersion: " + this.f50136c);
            }
        }
    }

    public void F(SwanAppActivity swanAppActivity) {
        d.a.n0.a.h0.g.g swanAppFragmentManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, swanAppActivity) == null) || swanAppActivity == null || swanAppActivity.isFinishing() || (swanAppFragmentManager = swanAppActivity.getSwanAppFragmentManager()) == null) {
            return;
        }
        g.b h2 = swanAppFragmentManager.h();
        h2.n(0, 0);
        h2.f();
        h2.j(d.a.n0.h.n.a.s3());
        h2.b();
    }

    public void G(d.a.n0.a.f1.e.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            ExtensionCore extensionCore = this.f50137d;
            if (extensionCore != null) {
                bVar.B0(extensionCore);
            } else {
                this.f50137d = bVar.O();
            }
        }
    }

    public void H() {
        d.a.n0.h.o.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (eVar = this.f50138e) == null) {
            return;
        }
        eVar.o().E0();
    }

    public void I(d.a.n0.a.f1.e.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bVar) == null) {
            K();
            SwanCoreVersion swanCoreVersion = this.f50136c;
            if (swanCoreVersion != null) {
                bVar.X0(swanCoreVersion);
            }
            if (j) {
                Log.d("SwanGameCoreRuntime", "syncSwanCore mSwanCoreVersion: " + this.f50136c);
            }
        }
    }

    public final void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            ExtensionCore extensionCore = this.f50137d;
            if (extensionCore == null || !extensionCore.isAvailable()) {
                if (j) {
                    Log.w("SwanGameCoreRuntime", "updateExtensionCoreIfNeeded: ExtensionCore is invalid");
                }
                D(d.a.n0.a.p0.b.c(1));
            }
        }
    }

    public final void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            SwanCoreVersion swanCoreVersion = this.f50136c;
            if (swanCoreVersion == null || !swanCoreVersion.isAvailable()) {
                E(o());
            }
        }
    }

    public void h(Activity activity) {
        d.a.n0.h.o.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, activity) == null) || (eVar = this.f50138e) == null) {
            return;
        }
        eVar.k(activity);
    }

    public void i(JSEvent jSEvent) {
        d.a.n0.h.o.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, jSEvent) == null) || (eVar = this.f50138e) == null) {
            return;
        }
        eVar.o().F(jSEvent);
    }

    public int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            d.a.n0.h.o.e eVar = this.f50138e;
            if (eVar != null) {
                return eVar.n();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Nullable
    public ExtensionCore k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f50137d : (ExtensionCore) invokeV.objValue;
    }

    public final String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            SwanCoreVersion swanCoreVersion = this.f50136c;
            return (swanCoreVersion == null || !swanCoreVersion.isAvailable()) ? "" : this.f50136c.swanCorePath;
        }
        return (String) invokeV.objValue;
    }

    public d.a.n0.a.l0.a n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            d.a.n0.h.o.e eVar = this.f50138e;
            if (eVar != null) {
                return eVar.o();
            }
            return null;
        }
        return (d.a.n0.a.l0.a) invokeV.objValue;
    }

    public final SwanCoreVersion o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (d.a.n0.h.p.a.c.a(AsInstallService.SCHEME_PACKAGE_ADDED)) {
                if (TextUtils.isEmpty(this.f50142i)) {
                    return null;
                }
                if (!new File(this.f50142i, "swan-game.js").exists()) {
                    q0.b0(new e(this));
                    return d.a.n0.a.m2.b.g(1);
                }
                SwanCoreVersion swanCoreVersion = new SwanCoreVersion();
                swanCoreVersion.swanCorePath = this.f50142i;
                swanCoreVersion.swanCoreType = 2;
                return swanCoreVersion;
            } else if (!d.a.n0.h.p.a.c.a("normal") && !d.a.n0.a.u1.a.a.h()) {
                return d.a.n0.a.m2.b.g(1);
            } else {
                SwanCoreVersion swanCoreVersion2 = new SwanCoreVersion();
                swanCoreVersion2.swanCorePath = d.a.n0.h.p.a.b.b().getAbsolutePath();
                swanCoreVersion2.swanCoreType = 2;
                if (j) {
                    Log.d("SwanGameCoreRuntime", "getPreGameCoreVersion DebugSwanGameCoreMode");
                }
                return swanCoreVersion2;
            }
        }
        return (SwanCoreVersion) invokeV.objValue;
    }

    public final int p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (this.f50134a < 0) {
                d.a.n0.a.c1.a.Z().getSwitch("swan_game_preload", 0);
                this.f50134a = 0;
            }
            if (j) {
                Log.d("SwanGameCoreRuntime", "getPreLoadABSwitch:" + this.f50134a);
            }
            return this.f50134a;
        }
        return invokeV.intValue;
    }

    public boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            d.a.n0.a.c1.a.Z().getSwitch("swan_game_startup_improvement", false);
            if (j) {
                Log.d("SwanGameCoreRuntime", "getPushFragmentABSwitch:false");
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public DuMixGameSurfaceView r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            d.a.n0.h.o.e eVar = this.f50138e;
            if (eVar != null) {
                return eVar.p();
            }
            return null;
        }
        return (DuMixGameSurfaceView) invokeV.objValue;
    }

    public SwanCoreVersion s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f50136c : (SwanCoreVersion) invokeV.objValue;
    }

    public final boolean t(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, intent)) == null) {
            int p = p();
            if (p != 1) {
                return p == 2 && intent == null;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean u() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            synchronized (this.f50135b) {
                z = this.f50140g && this.f50138e != null;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public boolean v() {
        InterceptResult invokeV;
        DuMixGameSurfaceView r;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? (this.f50141h || (r = r()) == null || r.getParent() != null) ? false : true : invokeV.booleanValue;
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048600, this) == null) || this.f50141h || this.f50139f.isEmpty() || !u()) {
            return;
        }
        for (f fVar : this.f50139f) {
            if (fVar != null) {
                fVar.onReady();
            }
        }
        this.f50139f.clear();
    }

    public void x(a.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, cVar) == null) {
            if (j) {
                Log.d("SwanGameCoreRuntime", "onAppReady");
            }
            if (cVar == null || TextUtils.isEmpty(cVar.f50300a)) {
                return;
            }
            this.f50142i = cVar.f50300a;
            h.p("startup").A("preload", u() ? "1" : "0");
            h.p("startup").C(new UbcFlowEvent("na_prepare_runtime_start"));
            boolean b2 = d.a.n0.a.h2.d.c().b();
            boolean b3 = d.a.n0.a.h2.d.b();
            if (b2 && b3) {
                B(new C1104c(this, cVar));
                if (this.f50138e != null) {
                    d.a.n0.h.y.e.b.b().f(this.f50138e.o(), cVar);
                    return;
                }
                return;
            }
            if (d.a.n0.a.a2.e.i() != null) {
                d.a.n0.a.j2.p.d dVar = new d.a.n0.a.j2.p.d();
                dVar.q(d.a.n0.a.j2.k.m(1));
                dVar.r(d.a.n0.a.a2.e.i().N());
                dVar.l("gameCoreRuntime", "loadv8Failed");
                d.a.n0.a.j2.k.L(dVar);
            }
            q0.b0(new b(this));
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            if (j) {
                Log.d("SwanGameCoreRuntime", "preloadCoreRuntime by release");
            }
            z(null);
        }
    }

    public void z(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, intent) == null) {
            if (j) {
                String stringExtra = intent != null ? intent.getStringExtra("bundle_key_preload_preload_scene") : null;
                Log.d("SwanGameCoreRuntime", "preloadCoreRuntime preloadScene:" + stringExtra);
            }
            if (!u() && t(intent)) {
                boolean b2 = d.a.n0.a.h2.d.c().b();
                boolean b3 = d.a.n0.a.h2.d.b();
                if (b2 && b3) {
                    B(new a(this));
                }
            }
        }
    }
}
