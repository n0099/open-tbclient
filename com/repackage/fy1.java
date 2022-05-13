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
import com.repackage.qj2;
import com.repackage.rl2;
import java.io.File;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class fy1 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean f;
    public static volatile fy1 g;
    public transient /* synthetic */ FieldHolder $fh;
    public p22 a;
    public volatile boolean b;
    public volatile boolean c;
    public volatile boolean d;
    public volatile boolean e;

    /* loaded from: classes6.dex */
    public class a implements m82 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rl2 a;
        public final /* synthetic */ q22 b;
        public final /* synthetic */ an1 c;
        public final /* synthetic */ qj2.g d;
        public final /* synthetic */ fy1 e;

        public a(fy1 fy1Var, rl2 rl2Var, q22 q22Var, an1 an1Var, qj2.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fy1Var, rl2Var, q22Var, an1Var, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = fy1Var;
            this.a = rl2Var;
            this.b = q22Var;
            this.c = an1Var;
            this.d = gVar;
        }

        @Override // com.repackage.m82
        public void a(c82 c82Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, c82Var) == null) {
                this.e.d = true;
                dy1.e().f("loaddebug");
                ux1.k("LocalDebugger", "prepareDaemon finish.");
                va2 j = this.e.j(this.a);
                this.e.t(j);
                if (fy1.f) {
                    Log.d("LocalDebugger", "debugInitMsg - " + j.s().toString());
                }
                this.e.n(this.b, this.c, this.a, this.d);
                this.e.p(this.b, this.c, this.a, this.d);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements ValueCallback<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q22 a;
        public final /* synthetic */ an1 b;
        public final /* synthetic */ rl2 c;
        public final /* synthetic */ qj2.g d;
        public final /* synthetic */ fy1 e;

        public b(fy1 fy1Var, q22 q22Var, an1 an1Var, rl2 rl2Var, qj2.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fy1Var, q22Var, an1Var, rl2Var, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = fy1Var;
            this.a = q22Var;
            this.b = an1Var;
            this.c = rl2Var;
            this.d = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.webkit.ValueCallback
        /* renamed from: a */
        public void onReceiveValue(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (fy1.f) {
                    Log.d("LocalDebugger", "master onReceiveValue: " + str);
                }
                this.e.b = true;
                this.e.u(this.a, this.b, this.c, this.d);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q22 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ ValueCallback c;

        public c(fy1 fy1Var, q22 q22Var, String str, ValueCallback valueCallback) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fy1Var, q22Var, str, valueCallback};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = q22Var;
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

    /* loaded from: classes6.dex */
    public class d implements ValueCallback<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d(fy1 fy1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fy1Var};
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && fy1.f) {
                Log.d("LocalDebugger", "slave onReceiveValue: " + str);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ an1 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ ValueCallback c;

        public e(fy1 fy1Var, an1 an1Var, String str, ValueCallback valueCallback) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fy1Var, an1Var, str, valueCallback};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = an1Var;
            this.b = str;
            this.c = valueCallback;
        }

        /* JADX WARN: Type inference failed for: r0v3, types: [com.repackage.bn1] */
        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.u().evaluateJavascript(this.b, this.c);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements ValueCallback<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q22 a;
        public final /* synthetic */ an1 b;
        public final /* synthetic */ rl2 c;
        public final /* synthetic */ qj2.g d;
        public final /* synthetic */ fy1 e;

        public f(fy1 fy1Var, q22 q22Var, an1 an1Var, rl2 rl2Var, qj2.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fy1Var, q22Var, an1Var, rl2Var, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = fy1Var;
            this.a = q22Var;
            this.b = an1Var;
            this.c = rl2Var;
            this.d = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.webkit.ValueCallback
        /* renamed from: a */
        public void onReceiveValue(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (fy1.f) {
                    Log.d("LocalDebugger", "slave onReceiveValue: " + str);
                }
                this.e.c = true;
                this.e.u(this.a, this.b, this.c, this.d);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q22 a;
        public final /* synthetic */ an1 b;
        public final /* synthetic */ rl2 c;
        public final /* synthetic */ qj2.g d;

        public g(fy1 fy1Var, q22 q22Var, an1 an1Var, rl2 rl2Var, qj2.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fy1Var, q22Var, an1Var, rl2Var, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = q22Var;
            this.b = an1Var;
            this.c = rl2Var;
            this.d = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                f43.a(this.a, this.b, this.c, this.d);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755691597, "Lcom/repackage/fy1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755691597, "Lcom/repackage/fy1;");
                return;
            }
        }
        f = eh1.a;
    }

    public fy1() {
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

    public static fy1 k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            if (g == null) {
                synchronized (fy1.class) {
                    if (g == null) {
                        g = new fy1();
                    }
                }
            }
            return g;
        }
        return (fy1) invokeV.objValue;
    }

    public final va2 j(@NonNull rl2<rl2.a> rl2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, rl2Var)) == null) {
            HashMap hashMap = new HashMap();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", "debugInit");
                jSONObject.put("host", rl2Var.X());
                jSONObject.put("wsServerPort", rl2Var.Y());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            hashMap.put("message", jSONObject.toString());
            return new va2("message", hashMap);
        }
        return (va2) invokeL.objValue;
    }

    public c82 l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            p22 p22Var = this.a;
            if (p22Var != null) {
                return p22Var.a();
            }
            return null;
        }
        return (c82) invokeV.objValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.e : invokeV.booleanValue;
    }

    public final void n(q22 q22Var, an1<?> an1Var, rl2<rl2.a> rl2Var, qj2.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048579, this, q22Var, an1Var, rl2Var, gVar) == null) {
            if (q22Var != null && q22Var.h() != null) {
                oe3.a0(new c(this, q22Var, xg4.E(new File(by1.e())), new b(this, q22Var, an1Var, rl2Var, gVar)));
            } else {
                ux1.k("LocalDebugger", "loadMasterDebugJs - master or js container is null");
            }
        }
    }

    public void o(an1<?> an1Var, ValueCallback<String> valueCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, an1Var, valueCallback) == null) {
            if (an1Var != null && an1Var.u() != null) {
                String E = xg4.E(new File(by1.f()));
                if (valueCallback == null) {
                    valueCallback = new d(this);
                }
                oe3.a0(new e(this, an1Var, E, valueCallback));
                return;
            }
            ux1.k("LocalDebugger", "loadSlaveDebugJs - slave or WebView is null");
        }
    }

    public final void p(q22 q22Var, an1<?> an1Var, rl2<rl2.a> rl2Var, qj2.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048581, this, q22Var, an1Var, rl2Var, gVar) == null) {
            o(an1Var, new f(this, q22Var, an1Var, rl2Var, gVar));
        }
    }

    public void q(q22 q22Var, an1<?> an1Var, rl2<rl2.a> rl2Var, qj2.g gVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(1048582, this, q22Var, an1Var, rl2Var, gVar) == null) && o72.U().q0()) {
            ux1.k("LocalDebugger", "prepareDaemon start.");
            if (this.e && this.d && this.a != null) {
                n(q22Var, an1Var, rl2Var, gVar);
                p(q22Var, an1Var, rl2Var, gVar);
                return;
            }
            p22 d2 = o72.U().f0().d();
            this.a = d2;
            d2.c(new a(this, rl2Var, q22Var, an1Var, gVar));
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            ux1.k("LocalDebugger", "releaseLocalDebugger");
            p22 p22Var = this.a;
            if (p22Var != null) {
                p22Var.b();
                this.a = null;
            }
            g = null;
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            ux1.k("LocalDebugger", "resetMasterAndSlaveStatus");
            this.e = true;
            this.b = false;
            this.c = false;
        }
    }

    public final void t(ua2 ua2Var) {
        p22 p22Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, ua2Var) == null) || (p22Var = this.a) == null) {
            return;
        }
        qa2.a(p22Var.a(), ua2Var);
    }

    public final synchronized void u(q22 q22Var, an1<?> an1Var, rl2<rl2.a> rl2Var, qj2.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048586, this, q22Var, an1Var, rl2Var, gVar) == null) {
            synchronized (this) {
                if (this.b && this.c) {
                    ux1.k("LocalDebugger", "startFirstPage");
                    oe3.a0(new g(this, q22Var, an1Var, rl2Var, gVar));
                }
            }
        }
    }
}
