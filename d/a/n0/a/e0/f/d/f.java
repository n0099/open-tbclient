package d.a.n0.a.e0.f.d;

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
import d.a.n0.a.a1.e;
import d.a.n0.a.f1.e.b;
import d.a.n0.a.k;
import d.a.n0.a.l0.j;
import d.a.n0.a.v2.q0;
import java.io.File;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f44022f;

    /* renamed from: g  reason: collision with root package name */
    public static volatile f f44023g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d.a.n0.a.h0.k.f f44024a;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f44025b;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f44026c;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f44027d;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f44028e;

    /* loaded from: classes7.dex */
    public class a implements j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.a.f1.e.b f44029a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.a.h0.l.a f44030b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.a.p.e.b f44031c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ e.g f44032d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f44033e;

        public a(f fVar, d.a.n0.a.f1.e.b bVar, d.a.n0.a.h0.l.a aVar, d.a.n0.a.p.e.b bVar2, e.g gVar) {
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
            this.f44033e = fVar;
            this.f44029a = bVar;
            this.f44030b = aVar;
            this.f44031c = bVar2;
            this.f44032d = gVar;
        }

        @Override // d.a.n0.a.l0.j
        public void a(d.a.n0.a.l0.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f44033e.f44027d = true;
                d.a.n0.a.e0.f.d.d.e().f("loaddebug");
                d.a.n0.a.e0.d.h("LocalDebugger", "prepareDaemon finish.");
                d.a.n0.a.o0.d.b j = this.f44033e.j(this.f44029a);
                this.f44033e.t(j);
                if (f.f44022f) {
                    Log.d("LocalDebugger", "debugInitMsg - " + j.g().toString());
                }
                this.f44033e.n(this.f44030b, this.f44031c, this.f44029a, this.f44032d);
                this.f44033e.p(this.f44030b, this.f44031c, this.f44029a, this.f44032d);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements ValueCallback<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.a.h0.l.a f44034a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.a.p.e.b f44035b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.a.f1.e.b f44036c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ e.g f44037d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f44038e;

        public b(f fVar, d.a.n0.a.h0.l.a aVar, d.a.n0.a.p.e.b bVar, d.a.n0.a.f1.e.b bVar2, e.g gVar) {
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
            this.f44038e = fVar;
            this.f44034a = aVar;
            this.f44035b = bVar;
            this.f44036c = bVar2;
            this.f44037d = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.webkit.ValueCallback
        /* renamed from: a */
        public void onReceiveValue(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (f.f44022f) {
                    Log.d("LocalDebugger", "master onReceiveValue: " + str);
                }
                this.f44038e.f44025b = true;
                this.f44038e.u(this.f44034a, this.f44035b, this.f44036c, this.f44037d);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.a.h0.l.a f44039e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f44040f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ ValueCallback f44041g;

        public c(f fVar, d.a.n0.a.h0.l.a aVar, String str, ValueCallback valueCallback) {
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
            this.f44039e = aVar;
            this.f44040f = str;
            this.f44041g = valueCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f44039e.g().evaluateJavascript(this.f44040f, this.f44041g);
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && f.f44022f) {
                Log.d("LocalDebugger", "slave onReceiveValue: " + str);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.a.p.e.b f44042e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f44043f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ ValueCallback f44044g;

        public e(f fVar, d.a.n0.a.p.e.b bVar, String str, ValueCallback valueCallback) {
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
            this.f44042e = bVar;
            this.f44043f = str;
            this.f44044g = valueCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ((NgWebView) this.f44042e.u()).evaluateJavascript(this.f44043f, this.f44044g);
            }
        }
    }

    /* renamed from: d.a.n0.a.e0.f.d.f$f  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0667f implements ValueCallback<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.a.h0.l.a f44045a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.a.p.e.b f44046b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.a.f1.e.b f44047c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ e.g f44048d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f44049e;

        public C0667f(f fVar, d.a.n0.a.h0.l.a aVar, d.a.n0.a.p.e.b bVar, d.a.n0.a.f1.e.b bVar2, e.g gVar) {
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
            this.f44049e = fVar;
            this.f44045a = aVar;
            this.f44046b = bVar;
            this.f44047c = bVar2;
            this.f44048d = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.webkit.ValueCallback
        /* renamed from: a */
        public void onReceiveValue(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (f.f44022f) {
                    Log.d("LocalDebugger", "slave onReceiveValue: " + str);
                }
                this.f44049e.f44026c = true;
                this.f44049e.u(this.f44045a, this.f44046b, this.f44047c, this.f44048d);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.a.h0.l.a f44050e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.a.p.e.b f44051f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.a.f1.e.b f44052g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ e.g f44053h;

        public g(f fVar, d.a.n0.a.h0.l.a aVar, d.a.n0.a.p.e.b bVar, d.a.n0.a.f1.e.b bVar2, e.g gVar) {
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
            this.f44050e = aVar;
            this.f44051f = bVar;
            this.f44052g = bVar2;
            this.f44053h = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.a.n0.a.c2.f.p0.c.a(this.f44050e, this.f44051f, this.f44052g, this.f44053h);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1916620311, "Ld/a/n0/a/e0/f/d/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1916620311, "Ld/a/n0/a/e0/f/d/f;");
                return;
            }
        }
        f44022f = k.f45831a;
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
        this.f44025b = false;
        this.f44026c = false;
        this.f44027d = false;
        this.f44028e = false;
    }

    public static f k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            if (f44023g == null) {
                synchronized (f.class) {
                    if (f44023g == null) {
                        f44023g = new f();
                    }
                }
            }
            return f44023g;
        }
        return (f) invokeV.objValue;
    }

    public final d.a.n0.a.o0.d.b j(@NonNull d.a.n0.a.f1.e.b<b.a> bVar) {
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
            return new d.a.n0.a.o0.d.b("message", hashMap);
        }
        return (d.a.n0.a.o0.d.b) invokeL.objValue;
    }

    public d.a.n0.a.l0.a l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            d.a.n0.a.h0.k.f fVar = this.f44024a;
            if (fVar != null) {
                return fVar.a();
            }
            return null;
        }
        return (d.a.n0.a.l0.a) invokeV.objValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f44028e : invokeV.booleanValue;
    }

    public final void n(d.a.n0.a.h0.l.a aVar, d.a.n0.a.p.e.b<NgWebView> bVar, d.a.n0.a.f1.e.b<b.a> bVar2, e.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048579, this, aVar, bVar, bVar2, gVar) == null) {
            if (aVar != null && aVar.g() != null) {
                q0.X(new c(this, aVar, d.a.n0.t.d.D(new File(d.a.n0.a.e0.f.d.b.e())), new b(this, aVar, bVar, bVar2, gVar)));
            } else {
                d.a.n0.a.e0.d.h("LocalDebugger", "loadMasterDebugJs - master or js container is null");
            }
        }
    }

    public void o(d.a.n0.a.p.e.b<NgWebView> bVar, ValueCallback<String> valueCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, bVar, valueCallback) == null) {
            if (bVar != null && bVar.u() != null) {
                String D = d.a.n0.t.d.D(new File(d.a.n0.a.e0.f.d.b.f()));
                if (valueCallback == null) {
                    valueCallback = new d(this);
                }
                q0.X(new e(this, bVar, D, valueCallback));
                return;
            }
            d.a.n0.a.e0.d.h("LocalDebugger", "loadSlaveDebugJs - slave or WebView is null");
        }
    }

    public final void p(d.a.n0.a.h0.l.a aVar, d.a.n0.a.p.e.b<NgWebView> bVar, d.a.n0.a.f1.e.b<b.a> bVar2, e.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048581, this, aVar, bVar, bVar2, gVar) == null) {
            o(bVar, new C0667f(this, aVar, bVar, bVar2, gVar));
        }
    }

    public void q(d.a.n0.a.h0.l.a aVar, d.a.n0.a.p.e.b<NgWebView> bVar, d.a.n0.a.f1.e.b<b.a> bVar2, e.g gVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(1048582, this, aVar, bVar, bVar2, gVar) == null) && d.a.n0.a.h0.u.g.N().g0()) {
            d.a.n0.a.e0.d.h("LocalDebugger", "prepareDaemon start.");
            if (this.f44028e && this.f44027d && this.f44024a != null) {
                n(aVar, bVar, bVar2, gVar);
                p(aVar, bVar, bVar2, gVar);
                return;
            }
            d.a.n0.a.h0.k.f b2 = d.a.n0.a.h0.u.g.N().X().b();
            this.f44024a = b2;
            b2.c(new a(this, bVar2, aVar, bVar, gVar));
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            d.a.n0.a.e0.d.h("LocalDebugger", "releaseLocalDebugger");
            d.a.n0.a.h0.k.f fVar = this.f44024a;
            if (fVar != null) {
                fVar.b();
                this.f44024a = null;
            }
            f44023g = null;
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            d.a.n0.a.e0.d.h("LocalDebugger", "resetMasterAndSlaveStatus");
            this.f44028e = true;
            this.f44025b = false;
            this.f44026c = false;
        }
    }

    public final void t(d.a.n0.a.o0.d.a aVar) {
        d.a.n0.a.h0.k.f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, aVar) == null) || (fVar = this.f44024a) == null) {
            return;
        }
        d.a.n0.a.o0.a.a(fVar.a(), aVar);
    }

    public final synchronized void u(d.a.n0.a.h0.l.a aVar, d.a.n0.a.p.e.b<NgWebView> bVar, d.a.n0.a.f1.e.b<b.a> bVar2, e.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048586, this, aVar, bVar, bVar2, gVar) == null) {
            synchronized (this) {
                if (this.f44025b && this.f44026c) {
                    d.a.n0.a.e0.d.h("LocalDebugger", "startFirstPage");
                    q0.X(new g(this, aVar, bVar, bVar2, gVar));
                }
            }
        }
    }
}
