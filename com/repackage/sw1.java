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
import com.repackage.di2;
import com.repackage.ek2;
import java.io.File;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class sw1 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean f;
    public static volatile sw1 g;
    public transient /* synthetic */ FieldHolder $fh;
    public c12 a;
    public volatile boolean b;
    public volatile boolean c;
    public volatile boolean d;
    public volatile boolean e;

    /* loaded from: classes7.dex */
    public class a implements z62 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ek2 a;
        public final /* synthetic */ d12 b;
        public final /* synthetic */ nl1 c;
        public final /* synthetic */ di2.g d;
        public final /* synthetic */ sw1 e;

        public a(sw1 sw1Var, ek2 ek2Var, d12 d12Var, nl1 nl1Var, di2.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sw1Var, ek2Var, d12Var, nl1Var, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = sw1Var;
            this.a = ek2Var;
            this.b = d12Var;
            this.c = nl1Var;
            this.d = gVar;
        }

        @Override // com.repackage.z62
        public void a(p62 p62Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, p62Var) == null) {
                this.e.d = true;
                qw1.e().f("loaddebug");
                hw1.k("LocalDebugger", "prepareDaemon finish.");
                i92 j = this.e.j(this.a);
                this.e.t(j);
                if (sw1.f) {
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
        public final /* synthetic */ d12 a;
        public final /* synthetic */ nl1 b;
        public final /* synthetic */ ek2 c;
        public final /* synthetic */ di2.g d;
        public final /* synthetic */ sw1 e;

        public b(sw1 sw1Var, d12 d12Var, nl1 nl1Var, ek2 ek2Var, di2.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sw1Var, d12Var, nl1Var, ek2Var, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = sw1Var;
            this.a = d12Var;
            this.b = nl1Var;
            this.c = ek2Var;
            this.d = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.webkit.ValueCallback
        /* renamed from: a */
        public void onReceiveValue(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (sw1.f) {
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
        public final /* synthetic */ d12 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ ValueCallback c;

        public c(sw1 sw1Var, d12 d12Var, String str, ValueCallback valueCallback) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sw1Var, d12Var, str, valueCallback};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = d12Var;
            this.b = str;
            this.c = valueCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.h().evaluateJavascript(this.b, this.c);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements ValueCallback<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d(sw1 sw1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sw1Var};
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && sw1.f) {
                Log.d("LocalDebugger", "slave onReceiveValue: " + str);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nl1 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ ValueCallback c;

        public e(sw1 sw1Var, nl1 nl1Var, String str, ValueCallback valueCallback) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sw1Var, nl1Var, str, valueCallback};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nl1Var;
            this.b = str;
            this.c = valueCallback;
        }

        /* JADX WARN: Type inference failed for: r0v3, types: [com.repackage.ol1] */
        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.u().evaluateJavascript(this.b, this.c);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements ValueCallback<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d12 a;
        public final /* synthetic */ nl1 b;
        public final /* synthetic */ ek2 c;
        public final /* synthetic */ di2.g d;
        public final /* synthetic */ sw1 e;

        public f(sw1 sw1Var, d12 d12Var, nl1 nl1Var, ek2 ek2Var, di2.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sw1Var, d12Var, nl1Var, ek2Var, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = sw1Var;
            this.a = d12Var;
            this.b = nl1Var;
            this.c = ek2Var;
            this.d = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.webkit.ValueCallback
        /* renamed from: a */
        public void onReceiveValue(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (sw1.f) {
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
        public final /* synthetic */ d12 a;
        public final /* synthetic */ nl1 b;
        public final /* synthetic */ ek2 c;
        public final /* synthetic */ di2.g d;

        public g(sw1 sw1Var, d12 d12Var, nl1 nl1Var, ek2 ek2Var, di2.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sw1Var, d12Var, nl1Var, ek2Var, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = d12Var;
            this.b = nl1Var;
            this.c = ek2Var;
            this.d = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                s23.a(this.a, this.b, this.c, this.d);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755306236, "Lcom/repackage/sw1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755306236, "Lcom/repackage/sw1;");
                return;
            }
        }
        f = rf1.a;
    }

    public sw1() {
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

    public static sw1 k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            if (g == null) {
                synchronized (sw1.class) {
                    if (g == null) {
                        g = new sw1();
                    }
                }
            }
            return g;
        }
        return (sw1) invokeV.objValue;
    }

    public final i92 j(@NonNull ek2<ek2.a> ek2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, ek2Var)) == null) {
            HashMap hashMap = new HashMap();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", "debugInit");
                jSONObject.put("host", ek2Var.X());
                jSONObject.put("wsServerPort", ek2Var.Y());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            hashMap.put("message", jSONObject.toString());
            return new i92("message", hashMap);
        }
        return (i92) invokeL.objValue;
    }

    public p62 l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            c12 c12Var = this.a;
            if (c12Var != null) {
                return c12Var.a();
            }
            return null;
        }
        return (p62) invokeV.objValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.e : invokeV.booleanValue;
    }

    public final void n(d12 d12Var, nl1<?> nl1Var, ek2<ek2.a> ek2Var, di2.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048579, this, d12Var, nl1Var, ek2Var, gVar) == null) {
            if (d12Var != null && d12Var.h() != null) {
                bd3.a0(new c(this, d12Var, kf4.E(new File(ow1.e())), new b(this, d12Var, nl1Var, ek2Var, gVar)));
            } else {
                hw1.k("LocalDebugger", "loadMasterDebugJs - master or js container is null");
            }
        }
    }

    public void o(nl1<?> nl1Var, ValueCallback<String> valueCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, nl1Var, valueCallback) == null) {
            if (nl1Var != null && nl1Var.u() != null) {
                String E = kf4.E(new File(ow1.f()));
                if (valueCallback == null) {
                    valueCallback = new d(this);
                }
                bd3.a0(new e(this, nl1Var, E, valueCallback));
                return;
            }
            hw1.k("LocalDebugger", "loadSlaveDebugJs - slave or WebView is null");
        }
    }

    public final void p(d12 d12Var, nl1<?> nl1Var, ek2<ek2.a> ek2Var, di2.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048581, this, d12Var, nl1Var, ek2Var, gVar) == null) {
            o(nl1Var, new f(this, d12Var, nl1Var, ek2Var, gVar));
        }
    }

    public void q(d12 d12Var, nl1<?> nl1Var, ek2<ek2.a> ek2Var, di2.g gVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(1048582, this, d12Var, nl1Var, ek2Var, gVar) == null) && b62.U().q0()) {
            hw1.k("LocalDebugger", "prepareDaemon start.");
            if (this.e && this.d && this.a != null) {
                n(d12Var, nl1Var, ek2Var, gVar);
                p(d12Var, nl1Var, ek2Var, gVar);
                return;
            }
            c12 d2 = b62.U().f0().d();
            this.a = d2;
            d2.c(new a(this, ek2Var, d12Var, nl1Var, gVar));
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            hw1.k("LocalDebugger", "releaseLocalDebugger");
            c12 c12Var = this.a;
            if (c12Var != null) {
                c12Var.b();
                this.a = null;
            }
            g = null;
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            hw1.k("LocalDebugger", "resetMasterAndSlaveStatus");
            this.e = true;
            this.b = false;
            this.c = false;
        }
    }

    public final void t(h92 h92Var) {
        c12 c12Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, h92Var) == null) || (c12Var = this.a) == null) {
            return;
        }
        d92.a(c12Var.a(), h92Var);
    }

    public final synchronized void u(d12 d12Var, nl1<?> nl1Var, ek2<ek2.a> ek2Var, di2.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048586, this, d12Var, nl1Var, ek2Var, gVar) == null) {
            synchronized (this) {
                if (this.b && this.c) {
                    hw1.k("LocalDebugger", "startFirstPage");
                    bd3.a0(new g(this, d12Var, nl1Var, ek2Var, gVar));
                }
            }
        }
    }
}
