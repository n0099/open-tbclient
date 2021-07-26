package d.a.o0.a.e0.f.d;

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
import d.a.o0.a.a1.e;
import d.a.o0.a.f1.e.b;
import d.a.o0.a.k;
import d.a.o0.a.l0.j;
import d.a.o0.a.v2.q0;
import java.io.File;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f44526f;

    /* renamed from: g  reason: collision with root package name */
    public static volatile f f44527g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d.a.o0.a.h0.k.f f44528a;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f44529b;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f44530c;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f44531d;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f44532e;

    /* loaded from: classes7.dex */
    public class a implements j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.a.f1.e.b f44533a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.a.h0.l.a f44534b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.a.p.e.b f44535c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ e.g f44536d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f44537e;

        public a(f fVar, d.a.o0.a.f1.e.b bVar, d.a.o0.a.h0.l.a aVar, d.a.o0.a.p.e.b bVar2, e.g gVar) {
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
            this.f44537e = fVar;
            this.f44533a = bVar;
            this.f44534b = aVar;
            this.f44535c = bVar2;
            this.f44536d = gVar;
        }

        @Override // d.a.o0.a.l0.j
        public void a(d.a.o0.a.l0.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f44537e.f44531d = true;
                d.a.o0.a.e0.f.d.d.e().f("loaddebug");
                d.a.o0.a.e0.d.h("LocalDebugger", "prepareDaemon finish.");
                d.a.o0.a.o0.d.b j = this.f44537e.j(this.f44533a);
                this.f44537e.t(j);
                if (f.f44526f) {
                    Log.d("LocalDebugger", "debugInitMsg - " + j.g().toString());
                }
                this.f44537e.n(this.f44534b, this.f44535c, this.f44533a, this.f44536d);
                this.f44537e.p(this.f44534b, this.f44535c, this.f44533a, this.f44536d);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements ValueCallback<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.a.h0.l.a f44538a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.a.p.e.b f44539b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.a.f1.e.b f44540c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ e.g f44541d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f44542e;

        public b(f fVar, d.a.o0.a.h0.l.a aVar, d.a.o0.a.p.e.b bVar, d.a.o0.a.f1.e.b bVar2, e.g gVar) {
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
            this.f44542e = fVar;
            this.f44538a = aVar;
            this.f44539b = bVar;
            this.f44540c = bVar2;
            this.f44541d = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.webkit.ValueCallback
        /* renamed from: a */
        public void onReceiveValue(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (f.f44526f) {
                    Log.d("LocalDebugger", "master onReceiveValue: " + str);
                }
                this.f44542e.f44529b = true;
                this.f44542e.u(this.f44538a, this.f44539b, this.f44540c, this.f44541d);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.a.h0.l.a f44543e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f44544f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ ValueCallback f44545g;

        public c(f fVar, d.a.o0.a.h0.l.a aVar, String str, ValueCallback valueCallback) {
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
            this.f44543e = aVar;
            this.f44544f = str;
            this.f44545g = valueCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f44543e.g().evaluateJavascript(this.f44544f, this.f44545g);
            }
        }
    }

    /* loaded from: classes7.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && f.f44526f) {
                Log.d("LocalDebugger", "slave onReceiveValue: " + str);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.a.p.e.b f44546e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f44547f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ ValueCallback f44548g;

        public e(f fVar, d.a.o0.a.p.e.b bVar, String str, ValueCallback valueCallback) {
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
            this.f44546e = bVar;
            this.f44547f = str;
            this.f44548g = valueCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ((NgWebView) this.f44546e.u()).evaluateJavascript(this.f44547f, this.f44548g);
            }
        }
    }

    /* renamed from: d.a.o0.a.e0.f.d.f$f  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0676f implements ValueCallback<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.a.h0.l.a f44549a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.a.p.e.b f44550b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.a.f1.e.b f44551c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ e.g f44552d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f44553e;

        public C0676f(f fVar, d.a.o0.a.h0.l.a aVar, d.a.o0.a.p.e.b bVar, d.a.o0.a.f1.e.b bVar2, e.g gVar) {
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
            this.f44553e = fVar;
            this.f44549a = aVar;
            this.f44550b = bVar;
            this.f44551c = bVar2;
            this.f44552d = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.webkit.ValueCallback
        /* renamed from: a */
        public void onReceiveValue(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (f.f44526f) {
                    Log.d("LocalDebugger", "slave onReceiveValue: " + str);
                }
                this.f44553e.f44530c = true;
                this.f44553e.u(this.f44549a, this.f44550b, this.f44551c, this.f44552d);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.a.h0.l.a f44554e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.a.p.e.b f44555f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.a.f1.e.b f44556g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ e.g f44557h;

        public g(f fVar, d.a.o0.a.h0.l.a aVar, d.a.o0.a.p.e.b bVar, d.a.o0.a.f1.e.b bVar2, e.g gVar) {
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
            this.f44554e = aVar;
            this.f44555f = bVar;
            this.f44556g = bVar2;
            this.f44557h = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.a.o0.a.c2.f.p0.c.a(this.f44554e, this.f44555f, this.f44556g, this.f44557h);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1411061686, "Ld/a/o0/a/e0/f/d/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1411061686, "Ld/a/o0/a/e0/f/d/f;");
                return;
            }
        }
        f44526f = k.f46335a;
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
        this.f44529b = false;
        this.f44530c = false;
        this.f44531d = false;
        this.f44532e = false;
    }

    public static f k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            if (f44527g == null) {
                synchronized (f.class) {
                    if (f44527g == null) {
                        f44527g = new f();
                    }
                }
            }
            return f44527g;
        }
        return (f) invokeV.objValue;
    }

    public final d.a.o0.a.o0.d.b j(@NonNull d.a.o0.a.f1.e.b<b.a> bVar) {
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
            return new d.a.o0.a.o0.d.b("message", hashMap);
        }
        return (d.a.o0.a.o0.d.b) invokeL.objValue;
    }

    public d.a.o0.a.l0.a l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            d.a.o0.a.h0.k.f fVar = this.f44528a;
            if (fVar != null) {
                return fVar.a();
            }
            return null;
        }
        return (d.a.o0.a.l0.a) invokeV.objValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f44532e : invokeV.booleanValue;
    }

    public final void n(d.a.o0.a.h0.l.a aVar, d.a.o0.a.p.e.b<NgWebView> bVar, d.a.o0.a.f1.e.b<b.a> bVar2, e.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048579, this, aVar, bVar, bVar2, gVar) == null) {
            if (aVar != null && aVar.g() != null) {
                q0.X(new c(this, aVar, d.a.o0.t.d.D(new File(d.a.o0.a.e0.f.d.b.e())), new b(this, aVar, bVar, bVar2, gVar)));
            } else {
                d.a.o0.a.e0.d.h("LocalDebugger", "loadMasterDebugJs - master or js container is null");
            }
        }
    }

    public void o(d.a.o0.a.p.e.b<NgWebView> bVar, ValueCallback<String> valueCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, bVar, valueCallback) == null) {
            if (bVar != null && bVar.u() != null) {
                String D = d.a.o0.t.d.D(new File(d.a.o0.a.e0.f.d.b.f()));
                if (valueCallback == null) {
                    valueCallback = new d(this);
                }
                q0.X(new e(this, bVar, D, valueCallback));
                return;
            }
            d.a.o0.a.e0.d.h("LocalDebugger", "loadSlaveDebugJs - slave or WebView is null");
        }
    }

    public final void p(d.a.o0.a.h0.l.a aVar, d.a.o0.a.p.e.b<NgWebView> bVar, d.a.o0.a.f1.e.b<b.a> bVar2, e.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048581, this, aVar, bVar, bVar2, gVar) == null) {
            o(bVar, new C0676f(this, aVar, bVar, bVar2, gVar));
        }
    }

    public void q(d.a.o0.a.h0.l.a aVar, d.a.o0.a.p.e.b<NgWebView> bVar, d.a.o0.a.f1.e.b<b.a> bVar2, e.g gVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(1048582, this, aVar, bVar, bVar2, gVar) == null) && d.a.o0.a.h0.u.g.N().g0()) {
            d.a.o0.a.e0.d.h("LocalDebugger", "prepareDaemon start.");
            if (this.f44532e && this.f44531d && this.f44528a != null) {
                n(aVar, bVar, bVar2, gVar);
                p(aVar, bVar, bVar2, gVar);
                return;
            }
            d.a.o0.a.h0.k.f b2 = d.a.o0.a.h0.u.g.N().X().b();
            this.f44528a = b2;
            b2.c(new a(this, bVar2, aVar, bVar, gVar));
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            d.a.o0.a.e0.d.h("LocalDebugger", "releaseLocalDebugger");
            d.a.o0.a.h0.k.f fVar = this.f44528a;
            if (fVar != null) {
                fVar.b();
                this.f44528a = null;
            }
            f44527g = null;
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            d.a.o0.a.e0.d.h("LocalDebugger", "resetMasterAndSlaveStatus");
            this.f44532e = true;
            this.f44529b = false;
            this.f44530c = false;
        }
    }

    public final void t(d.a.o0.a.o0.d.a aVar) {
        d.a.o0.a.h0.k.f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, aVar) == null) || (fVar = this.f44528a) == null) {
            return;
        }
        d.a.o0.a.o0.a.a(fVar.a(), aVar);
    }

    public final synchronized void u(d.a.o0.a.h0.l.a aVar, d.a.o0.a.p.e.b<NgWebView> bVar, d.a.o0.a.f1.e.b<b.a> bVar2, e.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048586, this, aVar, bVar, bVar2, gVar) == null) {
            synchronized (this) {
                if (this.f44529b && this.f44530c) {
                    d.a.o0.a.e0.d.h("LocalDebugger", "startFirstPage");
                    q0.X(new g(this, aVar, bVar, bVar2, gVar));
                }
            }
        }
    }
}
