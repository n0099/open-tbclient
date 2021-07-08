package d.a.n0.a.t0.f;

import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.alipay.sdk.widget.j;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Autowired;
import com.baidu.pyramid.annotation.Inject;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.n0.a.a1.e;
import d.a.n0.a.f1.e.b;
import d.a.n0.a.g1.g;
import d.a.n0.a.h0.g.g;
import d.a.n0.a.h0.i.i;
import d.a.n0.a.h0.m.h;
import d.a.n0.a.k;
import d.a.n0.a.v0.c;
import d.a.n0.a.v1.c.e.a;
import d.a.n0.a.v2.l0;
import d.a.n0.a.v2.w;
import d.a.n0.a.v2.x0;
import java.util.HashMap;
import org.json.JSONObject;
@Autowired
/* loaded from: classes7.dex */
public class a extends d.a.n0.a.t0.c {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean v;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d.a.n0.a.t0.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class RunnableC0891a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f47357e;

        public RunnableC0891a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47357e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && d.a.n0.a.v2.f.d(this.f47357e.f47343f)) {
                d.a.n0.a.d2.d.g();
                d.a.n0.a.g1.f.V().E(this.f47357e.f47343f);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
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
                d.a.n0.a.n1.q.a.g().y();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements d.a.n0.a.h0.j.b<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f47358a;

        public c(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47358a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.a.h0.j.b
        /* renamed from: b */
        public void a(Boolean bool) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bool) == null) && this.f47358a.f47343f != null && bool.booleanValue()) {
                this.f47358a.f47343f.onBackPressed();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements c.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f47359a;

        public d(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47359a = aVar;
        }

        @Override // d.a.n0.a.v0.c.b
        public void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f47359a.f47343f == null) {
                return;
            }
            this.f47359a.f47343f.moveTaskToBack(true);
            x0.b().e(1);
        }
    }

    /* loaded from: classes7.dex */
    public class e implements a.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f47360a;

        public e(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47360a = aVar;
        }

        @Override // d.a.n0.a.v1.c.e.a.c
        public boolean a(Message message) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, message)) == null) {
                int i2 = message.what;
                if (i2 == 100) {
                    d.a.n0.a.v1.c.a.e().h(new d.a.n0.a.v1.c.c(4));
                    this.f47360a.G0();
                    this.f47360a.c1();
                    d.a.n0.a.a2.d.g().t();
                    return true;
                } else if (i2 == 127) {
                    int c2 = d.a.n0.a.j1.e.b.c();
                    int a2 = d.a.n0.a.j1.e.b.a(c2);
                    if (!d.a.n0.a.j1.e.b.e()) {
                        d.a.n0.a.j1.e.a.a(Integer.valueOf(c2), String.valueOf(a2));
                    }
                    return true;
                } else if (i2 == 129) {
                    int p = d.a.n0.a.v2.c.m().p();
                    d.a.n0.a.e0.d.g("SwanAppFrame", "resetCore: client receive msg topTaskId = " + p);
                    if (this.f47360a.f47343f != null && this.f47360a.f47343f.isBackground() && p != -1 && this.f47360a.f47343f.getTaskId() != p) {
                        d.a.n0.a.e0.d.g("SwanAppFrame", "resetCore: purgeSwanApp");
                        d.a.n0.a.a2.d.g().t();
                    }
                    return true;
                } else if (i2 == 102) {
                    boolean a3 = d.a.n0.a.c1.a.H().a();
                    d.a.n0.a.c1.a.H().d(a3);
                    if (this.f47360a.f47343f != null) {
                        this.f47360a.f47343f.onNightModeCoverChanged(a3, false);
                    }
                    return true;
                } else if (i2 == 103) {
                    d.a.n0.a.a2.e i3 = d.a.n0.a.a2.e.i();
                    if (i3 != null) {
                        i3.T().i();
                        d.a.n0.a.n1.q.a.g().v();
                    }
                    this.f47360a.G0();
                    this.f47360a.b1();
                    return true;
                } else if (i2 == 106) {
                    d.a.n0.a.a2.d.g().t();
                    return true;
                } else if (i2 != 107) {
                    switch (i2) {
                        case 123:
                            d.a.n0.a.v2.c.r(message);
                            return true;
                        case 124:
                            d.a.n0.a.v2.c.q(message);
                            return true;
                        case 125:
                            d.a.n0.a.v1.c.d.a.b(message);
                            return true;
                        default:
                            return false;
                    }
                } else {
                    h.a(message);
                    return true;
                }
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public f() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                d.a.n0.a.l2.b.u(false);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1916718464, "Ld/a/n0/a/t0/f/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1916718464, "Ld/a/n0/a/t0/f/a;");
                return;
            }
        }
        v = k.f45831a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(SwanAppActivity swanAppActivity, String str) {
        super(swanAppActivity, str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {swanAppActivity, str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((SwanAppActivity) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // d.a.n0.a.t0.c
    @NonNull
    public a.c Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new e(this) : (a.c) invokeV.objValue;
    }

    @Override // d.a.n0.a.t0.c
    public void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            a0(1);
        }
    }

    @Override // d.a.n0.a.t0.c
    public void a0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            d.a.n0.a.e0.d.g("SwanApp", "onBackPressed back stack count:" + this.f47344g.k());
            e1(i2);
            d.a.n0.a.h0.g.d m = this.f47344g.m();
            if (m == null || !m.K()) {
                if (T()) {
                    d.a.n0.a.a2.e i3 = d.a.n0.a.a2.e.i();
                    if (i3 != null) {
                        i3.E().E();
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put("lcType", "onClose");
                    hashMap.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, d.a.n0.a.a2.e.V());
                    d.a.n0.a.g1.f.V().v(new d.a.n0.a.o0.d.c(hashMap));
                    d.a.n0.a.e0.d.g("SwanAppFrame", j.f2033c);
                    g.a().d(false);
                    return;
                }
                d.a.n0.a.v2.g.a(R(), this.f47343f);
                g.b i4 = this.f47344g.i("navigateBack");
                i4.n(d.a.n0.a.h0.g.g.f44710i, d.a.n0.a.h0.g.g.f44709h);
                i4.g();
                i4.a();
            }
        }
    }

    @Override // d.a.n0.a.t0.c
    public void b0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f47343f.setRequestedOrientation(1);
            d.a.n0.a.v2.f.a(this.f47343f);
            if (d.a.n0.a.h0.a.d()) {
                WebView.setWebContentsDebuggingEnabled(true);
            }
            d.a.n0.a.i2.a.d().a();
            d.a.n0.a.i2.a.d().i("frame_create");
            d.a.n0.a.m1.g.f().n(true);
            d.a.n0.a.m1.g.f().p();
            n1();
            i1();
            V8Engine.setCrashKeyValue("app_title", O().K());
        }
    }

    public final void b1() {
        f h1;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (h1 = h1()) == null) {
            return;
        }
        h1.a();
    }

    public final void c1() {
        f h1;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (h1 = h1()) == null) {
            return;
        }
        h1.b();
    }

    @Override // d.a.n0.a.t0.c
    public void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            d.a.n0.a.d2.d.j();
            d.a.n0.a.d2.d.h();
            d.a.n0.a.m1.g.f().q();
            d.a.n0.a.c1.a.U().a();
            d.a.n0.a.g1.f.V().k(this.f47343f);
            d.a.n0.a.n2.h.b.n();
        }
    }

    public final boolean d1(d.a.n0.a.f1.e.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, bVar)) == null) {
            if (bVar != null && !d.a.n0.a.u1.a.a.A(bVar)) {
                if (bVar.G() != 0) {
                    if (v) {
                        Log.i("SwanAppFrame", "checkSyncLegal error: games category");
                    }
                    return false;
                }
                SwanAppConfigData F = d.a.n0.a.a2.d.g().r().F();
                if (F == null) {
                    if (v) {
                        Log.i("SwanAppFrame", "checkSyncLegal error : none configData");
                    }
                    return false;
                } else if (!e.C0629e.i(bVar.H(), bVar.u1()).exists()) {
                    if (v) {
                        Log.i("SwanAppFrame", "checkSyncLegal error : unzip foldr is not exist");
                    }
                    return false;
                } else {
                    return !d.a.n0.a.c2.f.p0.g.p(bVar, F);
                }
            }
            if (v) {
                Log.i("SwanAppFrame", "checkSyncLegal error: info is null or debug model");
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void e1(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            String str = i2 != 2 ? i2 != 3 ? "virtual" : "gesture" : PrefetchEvent.STATE_CLICK;
            d.a.n0.a.j2.p.e eVar = new d.a.n0.a.j2.p.e();
            eVar.f45821e = j.j;
            d.a.n0.a.h0.g.g gVar = this.f47344g;
            boolean z = true;
            eVar.f45823g = (gVar == null || gVar.k() <= 1) ? false : false ? "1" : "0";
            eVar.f45818b = str;
            d.a.n0.a.j2.d.a(eVar, O());
            d.a.n0.a.j2.d.c(eVar);
        }
    }

    @Override // d.a.n0.a.t0.c
    public void f0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
        }
    }

    public final c.b f1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? new d(this) : (c.b) invokeV.objValue;
    }

    @Override // d.a.n0.a.t0.c
    public boolean g0(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048587, this, i2, keyEvent)) == null) {
            if (i2 == 4) {
                if (d.a.n0.a.v0.a.b().c()) {
                    d.a.n0.a.v0.a.b().f(this.f47343f, new c(this));
                    return true;
                }
                d.a.n0.a.h0.g.g gVar = this.f47344g;
                if (gVar != null && gVar.k() == 1) {
                    d.a.n0.a.v0.b bVar = new d.a.n0.a.v0.b();
                    bVar.h();
                    if (bVar.k()) {
                        d.a.n0.a.v0.c.c().j(this.f47343f, bVar.f(), bVar.e(), bVar, f1());
                        return true;
                    }
                    d.a.n0.a.m1.g.f().i();
                }
            }
            return super.g0(i2, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    public final String g1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? d.a.n0.a.f1.e.b.k1(O(), d.a.n0.a.g1.f.V().s()) : (String) invokeV.objValue;
    }

    @Override // d.a.n0.a.t0.c
    public void h0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.h0();
            if (d.a.n0.a.h0.u.g.N().P() != null) {
                d.a.n0.a.h0.u.g.N().P().e(this.f47343f);
            }
        }
    }

    @Inject(force = false)
    public final f h1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? new f() : (f) invokeV.objValue;
    }

    public final void i1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            d.a.n0.a.j2.e.z();
            if (C()) {
                k1();
                b.a O = O();
                if (d1(O)) {
                    if (v) {
                        Log.i("SwanAppFrame", "start load aiapps sync ");
                    }
                    d.a.n0.a.g1.f.V().c(O, null);
                    return;
                }
                if (v) {
                    Log.i("SwanAppFrame", "start load aiapps async ");
                }
                d.a.n0.a.g1.f.V().G(O, null);
            }
        }
    }

    @Override // d.a.n0.a.t0.c
    public void j0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
        }
    }

    public final boolean j1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            d.a.n0.a.a2.d g2 = d.a.n0.a.a2.d.g();
            if (g2.C()) {
                b.a N = g2.r().N();
                String T = N.T();
                String U = N.U();
                if (TextUtils.isEmpty(N.T()) || TextUtils.equals(T, U)) {
                    return false;
                }
                d.a.n0.a.a2.g J = r().J();
                if (J.b(N.T())) {
                    return !J.c(T, Boolean.FALSE).booleanValue();
                }
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void k1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            b.a O = O();
            if (v) {
                Log.d("SwanAppFrame", "tryReleaseInvalidCoreRuntime");
            }
            if (O == null) {
                if (v) {
                    Log.e("SwanAppFrame", "tryReleaseInvalidCoreRuntime: mLaunchInfo == null");
                }
            } else if (l0.f(O.a0())) {
                d.a.n0.a.h0.u.g.A0(true);
            } else {
                SwanCoreVersion i0 = O.i0();
                ExtensionCore M = d.a.n0.a.h0.u.g.N().M();
                ExtensionCore O2 = O.O();
                boolean z = false;
                boolean z2 = i0 != null && l0.f(i0.swanCoreVersionName) && d.a.n0.a.f1.e.a.a(O.S());
                if (M != null && O2 != null && M.extensionCoreVersionCode < O2.extensionCoreVersionCode && d.a.n0.a.f1.e.a.b(O.S())) {
                    z = true;
                }
                if (z2 || z) {
                    if (v) {
                        Log.d("SwanAppFrame", "预加载的swan-core或Extension版本过低时释放并重新加载");
                    }
                    d.a.n0.a.h0.u.g.A0(true);
                }
            }
        }
    }

    @Override // d.a.n0.a.a2.m, d.a.n0.a.a2.h
    public int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // d.a.n0.a.t0.c
    public void l0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            ExecutorUtilsExt.postOnElastic(new RunnableC0891a(this), "registerScreenshotEvent", 2);
        }
    }

    public final void l1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048597, this) == null) && j1()) {
            d.a.n0.a.r1.k.i.b.e().f(new b(this), "tryUpdateAsync");
        }
    }

    @Override // d.a.n0.a.t0.c
    public void m0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
        }
    }

    public final String m1(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, str)) == null) {
            b.a O = O();
            return (TextUtils.isEmpty(str) && O != null && W(O.H())) ? d.a.n0.a.g1.f.V().f() : str;
        }
        return (String) invokeL.objValue;
    }

    public final void n1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            b.a O = O();
            if (v) {
                Log.d("SwanAppFrame", "updateInvalidSwanCore cur swanCore: " + O.i0());
            }
            if (O.i0() == null || !O.i0().isAvailable()) {
                if (v) {
                    Log.d("SwanAppFrame", "updateInvalidSwanCore start.");
                }
                O.X0(d.a.n0.a.m2.b.g(0));
                if (v) {
                    Log.d("SwanAppFrame", "updateInvalidSwanCore end. new swan core: " + O.i0());
                }
            }
        }
    }

    @Override // d.a.n0.a.t0.c
    public void o0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            d.a.n0.a.r1.h.o().C(new UbcFlowEvent("frame_start_end"));
            d.a.n0.a.i2.a.d().i("frame_start_end");
        }
    }

    @Override // d.a.n0.a.t0.c
    public void q0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
        }
    }

    @Override // d.a.n0.a.t0.c
    public void s0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
        }
    }

    @Override // d.a.n0.a.t0.c
    public void u0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048604, this, i2) == null) {
            super.u0(i2);
            d.a.n0.a.n2.h.b.m(i2);
        }
    }

    @Override // d.a.n0.a.t0.c
    public void v0(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048605, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            d.a.n0.a.e0.d.g("SwanApp", "onUpdate isLaunch=" + z + ";isRelaunch=" + z2);
            String g1 = g1();
            JSONObject d2 = w.d(O().n("_naExtParams"));
            if (v) {
                Log.d("SwanAppFrame", "onNewIntent launchPage : " + g1);
            }
            String m1 = m1(g1);
            if (z) {
                d.a.n0.a.j2.e.w();
                d.a.n0.a.m1.g.f().n(z2);
                HybridUbcFlow p = d.a.n0.a.r1.h.p("startup");
                b.a O = O();
                if (z2) {
                    if (v) {
                        Log.d("SwanAppFrame", "onRelaunch launchPage : " + m1);
                    }
                    d.a.n0.a.h0.q.b.g().p(O.H(), true);
                    d.a.n0.a.j2.j.c(2);
                    d.a.n0.a.n2.h.b.o();
                    if (!TextUtils.isEmpty(m1)) {
                        if (d2.optString("_naScene", "").equals("message")) {
                            d.a.n0.a.c2.f.p0.a.f("backtohome", "message", m1);
                        } else {
                            boolean i2 = d.a.n0.a.c2.f.p0.a.i(m1);
                            d.a.n0.a.j2.e.u(m1, O);
                            i.h(i2);
                            p.F(HybridUbcFlow.SubmitStrategy.RELAUNCH);
                            p.B("type", "2");
                            boolean a2 = d.a.n0.a.c2.f.g0.d.b().a(d.a.n0.a.l1.b.g(m1, d.a.n0.a.g1.f.V().A()));
                            d.a.n0.a.c2.f.p0.a.f("backtohome", a2 ? "message" : "relaunch", m1);
                            if (i2 && !a2) {
                                d.a.n0.a.c2.f.p0.a.q("reLaunch");
                                d.a.n0.a.u.f.a.d().i();
                                if (d.a.n0.a.h0.n.a.a.c()) {
                                    d.a.n0.a.y0.k.f.b.d("0");
                                } else {
                                    d.a.n0.a.y0.k.f.b.e("2");
                                }
                            } else if (d.a.n0.a.h0.n.a.a.c()) {
                                d.a.n0.a.y0.k.f.b.d("0");
                            } else {
                                d.a.n0.a.y0.k.f.b.e("3");
                            }
                        }
                    } else if (d.a.n0.a.k2.d.a()) {
                        d.a.n0.a.c2.f.p0.a.f("backtohome", "relaunch", d.a.n0.a.g1.f.V().f());
                    } else {
                        d.a.n0.a.m1.g.f().o();
                        d.a.n0.a.m1.g.f().n(false);
                        i.h(false);
                        p.F(HybridUbcFlow.SubmitStrategy.NA_ONLY);
                        p.B("type", "3");
                        if (d.a.n0.a.h0.n.a.a.c()) {
                            d.a.n0.a.y0.k.f.b.d("0");
                        } else {
                            d.a.n0.a.y0.k.f.b.e("3");
                        }
                        d.a.n0.a.j2.e.s(O);
                        d.a.n0.a.j2.e.p(O);
                    }
                    if (P().hasResumed()) {
                        UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("na_page_show");
                        ubcFlowEvent.d(UbcFlowEvent.RecordType.UPDATE_RECENT);
                        p.C(ubcFlowEvent);
                        d.a.n0.a.i2.a.d().i("na_page_show");
                    }
                    d.a.n0.a.i2.a.d().i("frame_new_intent");
                    d.a.n0.a.a2.e r = d.a.n0.a.a2.d.g().r();
                    r.T().j();
                    r.j().a();
                    if (v) {
                        Log.d("SwanAppFrame", "hot start: hit prelink");
                        Log.d("SwanPrelink", "hot start: hit prelink");
                    }
                    r.F();
                    if (v) {
                        d.a.n0.a.h0.q.b.g().o();
                    }
                    d.a.n0.a.j2.k.A();
                } else {
                    p.F(HybridUbcFlow.SubmitStrategy.HYBRID);
                }
                l1();
            }
        }
    }
}
