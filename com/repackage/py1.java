package com.repackage;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.ubcprocessor.UBCCloudControlProcessor;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public abstract class py1 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static volatile py1 b;
    public static f73 c;
    public static Timer d;
    public static boolean e;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a extends TimerTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ py1 a;

        public a(py1 py1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {py1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = py1Var;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (py1.a) {
                    Log.d("RemoteDebugStatistic", "timer: send remote debug ubc flow");
                }
                this.a.e();
                this.a.n();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b extends py1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b() {
            super(null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((a) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // com.repackage.py1
        public void h(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || TextUtils.isEmpty(str)) {
                return;
            }
            if (py1.a) {
                Log.d("RemoteDebugStatistic", "remote-debug statistic event name is : " + str);
            }
            char c = 65535;
            int hashCode = str.hashCode();
            if (hashCode != 50335962) {
                if (hashCode != 1109597094) {
                    if (hashCode == 1158237819 && str.equals("downloadsuccess")) {
                        c = 1;
                    }
                } else if (str.equals("downloadfail")) {
                    c = 2;
                }
            } else if (str.equals("downloadstart")) {
                c = 0;
            }
            if (c == 0) {
                p(true);
                g73.d(py1.c, str, f());
            } else if (c == 1) {
                f73 f73Var = py1.c;
                if (f73Var != null) {
                    g73.b(f73Var);
                }
                n();
            } else if (c != 2) {
                f73 f73Var2 = py1.c;
                if (f73Var2 != null) {
                    g73.d(f73Var2, str, f());
                }
            } else {
                e();
                n();
            }
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    /* loaded from: classes7.dex */
    public static class c extends py1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c() {
            super(null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((a) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // com.repackage.py1
        public void h(String str) {
            SwanAppActivity w;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || TextUtils.isEmpty(str) || qy1.c()) {
                return;
            }
            if (py1.a) {
                Log.d("RemoteDebugStatistic", "remote-debug statistic event name is : " + str);
            }
            char c = 65535;
            int hashCode = str.hashCode();
            boolean z = true;
            if (hashCode != 511060680) {
                if (hashCode == 900970612 && str.equals("pageready")) {
                    c = 1;
                }
            } else if (str.equals("loadmaster")) {
                c = 0;
            }
            if (c != 0) {
                if (c != 1) {
                    f73 f73Var = py1.c;
                    if (f73Var != null) {
                        g73.d(f73Var, str, f());
                        return;
                    }
                    return;
                }
                f73 f73Var2 = py1.c;
                if (f73Var2 != null) {
                    g73.d(f73Var2, str, f());
                    e();
                    n();
                    return;
                }
                return;
            }
            if (z03.b0() != null && (w = z03.b0().w()) != null && !w.isFinishing()) {
                z = false;
            }
            p(z);
            if (!z) {
                if (py1.e) {
                    f73 f73Var3 = py1.c;
                    g73.d(f73Var3, str + "-preload", f());
                    boolean unused = py1.e = false;
                    return;
                }
                g73.d(py1.c, str, f());
                return;
            }
            f73 f73Var4 = py1.c;
            g73.d(f73Var4, str + "-destroy", f());
            boolean unused2 = py1.e = false;
        }

        public /* synthetic */ c(a aVar) {
            this();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755393687, "Lcom/repackage/py1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755393687, "Lcom/repackage/py1;");
                return;
            }
        }
        a = jh1.a;
    }

    public /* synthetic */ py1(a aVar) {
        this();
    }

    public static void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, null) == null) {
            c83 c83Var = new c83();
            c83Var.a = "swan";
            c83Var.b = "launch";
            c83Var.c = "remote-debug";
            c83Var.e = "appready";
            s73.onEvent(c83Var);
        }
    }

    public static py1 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (b == null) {
                synchronized (mm2.class) {
                    if (b == null) {
                        if (jc1.g()) {
                            b = new b(null);
                        } else {
                            b = new c(null);
                        }
                    }
                }
            }
            return b;
        }
        return (py1) invokeV.objValue;
    }

    public static void i(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65544, null, jSONArray) == null) || jSONArray == null || jSONArray.length() <= 0) {
            return;
        }
        JSONObject optJSONObject = jSONArray.optJSONObject(0);
        String optString = optJSONObject != null ? optJSONObject.optString("actionId") : "";
        if (TextUtils.isEmpty(optString) || b == null) {
            return;
        }
        b.h(optString);
    }

    public static void j(xl2 xl2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, xl2Var) == null) {
            xl2Var.s0().putString("aiapp_extra_need_download", "1");
            xl2Var.s0().putString("aiapp_extra_pkg_downloading", "0");
            xl2Var.s0().putLong("launch_flag_for_statistic", System.currentTimeMillis());
            c83 c83Var = new c83();
            c83Var.a = s73.n(xl2Var.G());
            c83Var.j(xl2Var);
            c83Var.b = "launch";
            c83Var.o = "1";
            c83Var.c = "remote-debug";
            JSONObject k = s73.k(xl2Var.W());
            c83Var.d(xl2Var.s0().getString(UBCCloudControlProcessor.UBC_KEY));
            c83Var.b(k);
            s73.onEvent(c83Var);
        }
    }

    public static void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, null) == null) {
            c83 c83Var = new c83();
            c83Var.a = "swan";
            c83Var.b = "launch";
            c83Var.c = "remote-debug";
            c83Var.e = "loadmaster";
            s73.onEvent(c83Var);
        }
    }

    public static void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, null) == null) {
            c83 c83Var = new c83();
            c83Var.a = "swan";
            c83Var.b = "launch";
            c83Var.c = "remote-debug";
            c83Var.e = "downloadstart";
            s73.onEvent(c83Var);
        }
    }

    public static void m(xl2 xl2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, null, xl2Var) == null) {
            c83 c83Var = new c83();
            c83Var.j(xl2Var);
            c83Var.a = s73.n(xl2Var.G());
            c83Var.b = "launch";
            c83Var.c = "remote-debug";
            c83Var.e = "downloadsuccess";
            s73.onEvent(c83Var);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || c == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            z03 b0 = z03.b0();
            jSONObject2.putOpt("appid", b0 == null ? "" : b0.O());
            jSONObject2.putOpt("from", "remote-debug");
            r73.a(jSONObject2);
            jSONObject.putOpt("from", "swan");
            jSONObject.putOpt("ext", jSONObject2);
        } catch (JSONException unused) {
            if (a) {
                Log.d("RemoteDebugStatistic", "page ready statistic value is invalid ");
            }
        }
        g73.f(c, jSONObject.toString());
        g73.c(c);
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("timestamp", Long.valueOf(System.currentTimeMillis()));
            } catch (JSONException e2) {
                if (a) {
                    Log.d("RemoteDebugStatistic", "add event content fail", e2);
                }
            }
            return jSONObject.toString();
        }
        return (String) invokeV.objValue;
    }

    public abstract void h(String str);

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            Timer timer = d;
            if (timer != null) {
                timer.cancel();
                d = null;
            }
            b = null;
            c = null;
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            e = true;
        }
    }

    public void p(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048581, this, z) == null) && c == null) {
            f73 c2 = s73.c("1153");
            c = c2;
            if (!z) {
                g73.d(c2, "downloadstart", f());
                g73.d(c, "downloadsuccess", f());
            }
            Timer timer = new Timer();
            d = timer;
            timer.schedule(new a(this), 40000L);
        }
    }

    public py1() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }
}
