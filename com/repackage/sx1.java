package com.repackage;

import android.util.Log;
import android.webkit.ValueCallback;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.dj2;
import com.repackage.el2;
import java.io.File;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class sx1 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean f;
    public static volatile sx1 g;
    public transient /* synthetic */ FieldHolder $fh;
    public c22 a;
    public volatile boolean b;
    public volatile boolean c;
    public volatile boolean d;
    public volatile boolean e;

    /* loaded from: classes7.dex */
    public class a implements z72 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ el2 a;
        public final /* synthetic */ d22 b;
        public final /* synthetic */ nm1 c;
        public final /* synthetic */ dj2.g d;
        public final /* synthetic */ sx1 e;

        public a(sx1 sx1Var, el2 el2Var, d22 d22Var, nm1 nm1Var, dj2.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sx1Var, el2Var, d22Var, nm1Var, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = sx1Var;
            this.a = el2Var;
            this.b = d22Var;
            this.c = nm1Var;
            this.d = gVar;
        }

        @Override // com.repackage.z72
        public void a(p72 p72Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, p72Var) == null) {
                this.e.d = true;
                qx1.e().f("loaddebug");
                hx1.k("LocalDebugger", "prepareDaemon finish.");
                ia2 j = this.e.j(this.a);
                this.e.t(j);
                if (sx1.f) {
                    Log.d("LocalDebugger", "debugInitMsg - " + j.s().toString());
                }
                this.e.n(this.b, this.c, this.a, this.d);
                this.e.p(this.b, this.c, this.a, this.d);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements ValueCallback<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d22 a;
        public final /* synthetic */ nm1 b;
        public final /* synthetic */ el2 c;
        public final /* synthetic */ dj2.g d;
        public final /* synthetic */ sx1 e;

        public b(sx1 sx1Var, d22 d22Var, nm1 nm1Var, el2 el2Var, dj2.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sx1Var, d22Var, nm1Var, el2Var, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = sx1Var;
            this.a = d22Var;
            this.b = nm1Var;
            this.c = el2Var;
            this.d = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.webkit.ValueCallback
        /* renamed from: a */
        public void onReceiveValue(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (sx1.f) {
                    Log.d("LocalDebugger", "master onReceiveValue: " + str);
                }
                this.e.b = true;
                this.e.u(this.a, this.b, this.c, this.d);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d22 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ ValueCallback c;

        public c(sx1 sx1Var, d22 d22Var, String str, ValueCallback valueCallback) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sx1Var, d22Var, str, valueCallback};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = d22Var;
            this.b = str;
            this.c = valueCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.g().evaluateJavascript(this.b, this.c);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements ValueCallback<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d(sx1 sx1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sx1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && sx1.f) {
                Log.d("LocalDebugger", "slave onReceiveValue: " + str);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nm1 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ ValueCallback c;

        public e(sx1 sx1Var, nm1 nm1Var, String str, ValueCallback valueCallback) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sx1Var, nm1Var, str, valueCallback};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nm1Var;
            this.b = str;
            this.c = valueCallback;
        }

        /* JADX WARN: Type inference failed for: r0v3, types: [com.repackage.om1] */
        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.t().evaluateJavascript(this.b, this.c);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements ValueCallback<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d22 a;
        public final /* synthetic */ nm1 b;
        public final /* synthetic */ el2 c;
        public final /* synthetic */ dj2.g d;
        public final /* synthetic */ sx1 e;

        public f(sx1 sx1Var, d22 d22Var, nm1 nm1Var, el2 el2Var, dj2.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sx1Var, d22Var, nm1Var, el2Var, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = sx1Var;
            this.a = d22Var;
            this.b = nm1Var;
            this.c = el2Var;
            this.d = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.webkit.ValueCallback
        /* renamed from: a */
        public void onReceiveValue(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (sx1.f) {
                    Log.d("LocalDebugger", "slave onReceiveValue: " + str);
                }
                this.e.c = true;
                this.e.u(this.a, this.b, this.c, this.d);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d22 a;
        public final /* synthetic */ nm1 b;
        public final /* synthetic */ el2 c;
        public final /* synthetic */ dj2.g d;

        public g(sx1 sx1Var, d22 d22Var, nm1 nm1Var, el2 el2Var, dj2.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sx1Var, d22Var, nm1Var, el2Var, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = d22Var;
            this.b = nm1Var;
            this.c = el2Var;
            this.d = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                s33.a(this.a, this.b, this.c, this.d);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755305275, "Lcom/repackage/sx1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755305275, "Lcom/repackage/sx1;");
                return;
            }
        }
        f = rg1.a;
    }

    public sx1() {
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
        this.b = false;
        this.c = false;
        this.d = false;
        this.e = false;
    }

    public static sx1 k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            if (g == null) {
                synchronized (sx1.class) {
                    if (g == null) {
                        g = new sx1();
                    }
                }
            }
            return g;
        }
        return (sx1) invokeV.objValue;
    }

    public final ia2 j(@NonNull el2<el2.a> el2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, el2Var)) == null) {
            HashMap hashMap = new HashMap();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", "debugInit");
                jSONObject.put("host", el2Var.X());
                jSONObject.put("wsServerPort", el2Var.Y());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            hashMap.put("message", jSONObject.toString());
            return new ia2("message", hashMap);
        }
        return (ia2) invokeL.objValue;
    }

    public p72 l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            c22 c22Var = this.a;
            if (c22Var != null) {
                return c22Var.a();
            }
            return null;
        }
        return (p72) invokeV.objValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.e : invokeV.booleanValue;
    }

    public final void n(d22 d22Var, nm1<?> nm1Var, el2<el2.a> el2Var, dj2.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048579, this, d22Var, nm1Var, el2Var, gVar) == null) {
            if (d22Var != null && d22Var.g() != null) {
                be3.a0(new c(this, d22Var, jg4.E(new File(ox1.e())), new b(this, d22Var, nm1Var, el2Var, gVar)));
            } else {
                hx1.k("LocalDebugger", "loadMasterDebugJs - master or js container is null");
            }
        }
    }

    public void o(nm1<?> nm1Var, ValueCallback<String> valueCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, nm1Var, valueCallback) == null) {
            if (nm1Var != null && nm1Var.t() != null) {
                String E = jg4.E(new File(ox1.f()));
                if (valueCallback == null) {
                    valueCallback = new d(this);
                }
                be3.a0(new e(this, nm1Var, E, valueCallback));
                return;
            }
            hx1.k("LocalDebugger", "loadSlaveDebugJs - slave or WebView is null");
        }
    }

    public final void p(d22 d22Var, nm1<?> nm1Var, el2<el2.a> el2Var, dj2.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048581, this, d22Var, nm1Var, el2Var, gVar) == null) {
            o(nm1Var, new f(this, d22Var, nm1Var, el2Var, gVar));
        }
    }

    public void q(d22 d22Var, nm1<?> nm1Var, el2<el2.a> el2Var, dj2.g gVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(1048582, this, d22Var, nm1Var, el2Var, gVar) == null) && b72.U().q0()) {
            hx1.k("LocalDebugger", "prepareDaemon start.");
            if (this.e && this.d && this.a != null) {
                n(d22Var, nm1Var, el2Var, gVar);
                p(d22Var, nm1Var, el2Var, gVar);
                return;
            }
            c22 d2 = b72.U().f0().d();
            this.a = d2;
            d2.c(new a(this, el2Var, d22Var, nm1Var, gVar));
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            hx1.k("LocalDebugger", "releaseLocalDebugger");
            c22 c22Var = this.a;
            if (c22Var != null) {
                c22Var.b();
                this.a = null;
            }
            g = null;
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            hx1.k("LocalDebugger", "resetMasterAndSlaveStatus");
            this.e = true;
            this.b = false;
            this.c = false;
        }
    }

    public final void t(ha2 ha2Var) {
        c22 c22Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, ha2Var) == null) || (c22Var = this.a) == null) {
            return;
        }
        da2.a(c22Var.a(), ha2Var);
    }

    public final synchronized void u(d22 d22Var, nm1<?> nm1Var, el2<el2.a> el2Var, dj2.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048586, this, d22Var, nm1Var, el2Var, gVar) == null) {
            synchronized (this) {
                if (this.b && this.c) {
                    hx1.k("LocalDebugger", "startFirstPage");
                    be3.a0(new g(this, d22Var, nm1Var, el2Var, gVar));
                }
            }
        }
    }
}
