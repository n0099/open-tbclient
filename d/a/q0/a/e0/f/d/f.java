package d.a.q0.a.e0.f.d;

import android.util.Log;
import android.webkit.ValueCallback;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.container.NgWebView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.a1.e;
import d.a.q0.a.f1.e.b;
import d.a.q0.a.k;
import d.a.q0.a.l0.j;
import d.a.q0.a.v2.q0;
import java.io.File;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f47324f;

    /* renamed from: g  reason: collision with root package name */
    public static volatile f f47325g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d.a.q0.a.h0.k.f f47326a;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f47327b;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f47328c;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f47329d;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f47330e;

    /* loaded from: classes8.dex */
    public class a implements j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.f1.e.b f47331a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.h0.l.a f47332b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.p.e.b f47333c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ e.g f47334d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f47335e;

        public a(f fVar, d.a.q0.a.f1.e.b bVar, d.a.q0.a.h0.l.a aVar, d.a.q0.a.p.e.b bVar2, e.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, bVar, aVar, bVar2, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47335e = fVar;
            this.f47331a = bVar;
            this.f47332b = aVar;
            this.f47333c = bVar2;
            this.f47334d = gVar;
        }

        @Override // d.a.q0.a.l0.j
        public void a(d.a.q0.a.l0.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f47335e.f47329d = true;
                d.a.q0.a.e0.f.d.d.e().f("loaddebug");
                d.a.q0.a.e0.d.h("LocalDebugger", "prepareDaemon finish.");
                d.a.q0.a.o0.d.b j = this.f47335e.j(this.f47331a);
                this.f47335e.t(j);
                if (f.f47324f) {
                    Log.d("LocalDebugger", "debugInitMsg - " + j.g().toString());
                }
                this.f47335e.n(this.f47332b, this.f47333c, this.f47331a, this.f47334d);
                this.f47335e.p(this.f47332b, this.f47333c, this.f47331a, this.f47334d);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements ValueCallback<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.h0.l.a f47336a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.p.e.b f47337b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.f1.e.b f47338c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ e.g f47339d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f47340e;

        public b(f fVar, d.a.q0.a.h0.l.a aVar, d.a.q0.a.p.e.b bVar, d.a.q0.a.f1.e.b bVar2, e.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, aVar, bVar, bVar2, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47340e = fVar;
            this.f47336a = aVar;
            this.f47337b = bVar;
            this.f47338c = bVar2;
            this.f47339d = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.webkit.ValueCallback
        /* renamed from: a */
        public void onReceiveValue(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (f.f47324f) {
                    Log.d("LocalDebugger", "master onReceiveValue: " + str);
                }
                this.f47340e.f47327b = true;
                this.f47340e.u(this.f47336a, this.f47337b, this.f47338c, this.f47339d);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.h0.l.a f47341e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f47342f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ ValueCallback f47343g;

        public c(f fVar, d.a.q0.a.h0.l.a aVar, String str, ValueCallback valueCallback) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, aVar, str, valueCallback};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47341e = aVar;
            this.f47342f = str;
            this.f47343g = valueCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f47341e.g().evaluateJavascript(this.f47342f, this.f47343g);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements ValueCallback<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.webkit.ValueCallback
        /* renamed from: a */
        public void onReceiveValue(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && f.f47324f) {
                Log.d("LocalDebugger", "slave onReceiveValue: " + str);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.p.e.b f47344e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f47345f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ ValueCallback f47346g;

        public e(f fVar, d.a.q0.a.p.e.b bVar, String str, ValueCallback valueCallback) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, bVar, str, valueCallback};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47344e = bVar;
            this.f47345f = str;
            this.f47346g = valueCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ((NgWebView) this.f47344e.u()).evaluateJavascript(this.f47345f, this.f47346g);
            }
        }
    }

    /* renamed from: d.a.q0.a.e0.f.d.f$f  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0718f implements ValueCallback<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.h0.l.a f47347a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.p.e.b f47348b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.f1.e.b f47349c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ e.g f47350d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f47351e;

        public C0718f(f fVar, d.a.q0.a.h0.l.a aVar, d.a.q0.a.p.e.b bVar, d.a.q0.a.f1.e.b bVar2, e.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, aVar, bVar, bVar2, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47351e = fVar;
            this.f47347a = aVar;
            this.f47348b = bVar;
            this.f47349c = bVar2;
            this.f47350d = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.webkit.ValueCallback
        /* renamed from: a */
        public void onReceiveValue(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (f.f47324f) {
                    Log.d("LocalDebugger", "slave onReceiveValue: " + str);
                }
                this.f47351e.f47328c = true;
                this.f47351e.u(this.f47347a, this.f47348b, this.f47349c, this.f47350d);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.h0.l.a f47352e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.p.e.b f47353f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.f1.e.b f47354g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ e.g f47355h;

        public g(f fVar, d.a.q0.a.h0.l.a aVar, d.a.q0.a.p.e.b bVar, d.a.q0.a.f1.e.b bVar2, e.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, aVar, bVar, bVar2, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47352e = aVar;
            this.f47353f = bVar;
            this.f47354g = bVar2;
            this.f47355h = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.a.q0.a.c2.f.p0.c.a(this.f47352e, this.f47353f, this.f47354g, this.f47355h);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(399944436, "Ld/a/q0/a/e0/f/d/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(399944436, "Ld/a/q0/a/e0/f/d/f;");
                return;
            }
        }
        f47324f = k.f49133a;
    }

    public f() {
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
        this.f47327b = false;
        this.f47328c = false;
        this.f47329d = false;
        this.f47330e = false;
    }

    public static f k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            if (f47325g == null) {
                synchronized (f.class) {
                    if (f47325g == null) {
                        f47325g = new f();
                    }
                }
            }
            return f47325g;
        }
        return (f) invokeV.objValue;
    }

    public final d.a.q0.a.o0.d.b j(@NonNull d.a.q0.a.f1.e.b<b.a> bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bVar)) == null) {
            HashMap hashMap = new HashMap();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", "debugInit");
                jSONObject.put("host", bVar.X());
                jSONObject.put("wsServerPort", bVar.Y());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            hashMap.put("message", jSONObject.toString());
            return new d.a.q0.a.o0.d.b("message", hashMap);
        }
        return (d.a.q0.a.o0.d.b) invokeL.objValue;
    }

    public d.a.q0.a.l0.a l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            d.a.q0.a.h0.k.f fVar = this.f47326a;
            if (fVar != null) {
                return fVar.a();
            }
            return null;
        }
        return (d.a.q0.a.l0.a) invokeV.objValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f47330e : invokeV.booleanValue;
    }

    public final void n(d.a.q0.a.h0.l.a aVar, d.a.q0.a.p.e.b<NgWebView> bVar, d.a.q0.a.f1.e.b<b.a> bVar2, e.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048579, this, aVar, bVar, bVar2, gVar) == null) {
            if (aVar != null && aVar.g() != null) {
                q0.X(new c(this, aVar, d.a.q0.t.d.D(new File(d.a.q0.a.e0.f.d.b.e())), new b(this, aVar, bVar, bVar2, gVar)));
            } else {
                d.a.q0.a.e0.d.h("LocalDebugger", "loadMasterDebugJs - master or js container is null");
            }
        }
    }

    public void o(d.a.q0.a.p.e.b<NgWebView> bVar, ValueCallback<String> valueCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, bVar, valueCallback) == null) {
            if (bVar != null && bVar.u() != null) {
                String D = d.a.q0.t.d.D(new File(d.a.q0.a.e0.f.d.b.f()));
                if (valueCallback == null) {
                    valueCallback = new d(this);
                }
                q0.X(new e(this, bVar, D, valueCallback));
                return;
            }
            d.a.q0.a.e0.d.h("LocalDebugger", "loadSlaveDebugJs - slave or WebView is null");
        }
    }

    public final void p(d.a.q0.a.h0.l.a aVar, d.a.q0.a.p.e.b<NgWebView> bVar, d.a.q0.a.f1.e.b<b.a> bVar2, e.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048581, this, aVar, bVar, bVar2, gVar) == null) {
            o(bVar, new C0718f(this, aVar, bVar, bVar2, gVar));
        }
    }

    public void q(d.a.q0.a.h0.l.a aVar, d.a.q0.a.p.e.b<NgWebView> bVar, d.a.q0.a.f1.e.b<b.a> bVar2, e.g gVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(1048582, this, aVar, bVar, bVar2, gVar) == null) && d.a.q0.a.h0.u.g.N().g0()) {
            d.a.q0.a.e0.d.h("LocalDebugger", "prepareDaemon start.");
            if (this.f47330e && this.f47329d && this.f47326a != null) {
                n(aVar, bVar, bVar2, gVar);
                p(aVar, bVar, bVar2, gVar);
                return;
            }
            d.a.q0.a.h0.k.f b2 = d.a.q0.a.h0.u.g.N().X().b();
            this.f47326a = b2;
            b2.c(new a(this, bVar2, aVar, bVar, gVar));
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            d.a.q0.a.e0.d.h("LocalDebugger", "releaseLocalDebugger");
            d.a.q0.a.h0.k.f fVar = this.f47326a;
            if (fVar != null) {
                fVar.b();
                this.f47326a = null;
            }
            f47325g = null;
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            d.a.q0.a.e0.d.h("LocalDebugger", "resetMasterAndSlaveStatus");
            this.f47330e = true;
            this.f47327b = false;
            this.f47328c = false;
        }
    }

    public final void t(d.a.q0.a.o0.d.a aVar) {
        d.a.q0.a.h0.k.f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, aVar) == null) || (fVar = this.f47326a) == null) {
            return;
        }
        d.a.q0.a.o0.a.a(fVar.a(), aVar);
    }

    public final synchronized void u(d.a.q0.a.h0.l.a aVar, d.a.q0.a.p.e.b<NgWebView> bVar, d.a.q0.a.f1.e.b<b.a> bVar2, e.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048586, this, aVar, bVar, bVar2, gVar) == null) {
            synchronized (this) {
                if (this.f47327b && this.f47328c) {
                    d.a.q0.a.e0.d.h("LocalDebugger", "startFirstPage");
                    q0.X(new g(this, aVar, bVar, bVar2, gVar));
                }
            }
        }
    }
}
