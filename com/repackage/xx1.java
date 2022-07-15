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
public abstract class xx1 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static volatile xx1 b;
    public static n63 c;
    public static Timer d;
    public static boolean e;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a extends TimerTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xx1 a;

        public a(xx1 xx1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xx1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xx1Var;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (xx1.a) {
                    Log.d("RemoteDebugStatistic", "timer: send remote debug ubc flow");
                }
                this.a.e();
                this.a.n();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b extends xx1 {
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

        @Override // com.repackage.xx1
        public void h(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || TextUtils.isEmpty(str)) {
                return;
            }
            if (xx1.a) {
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
                o63.d(xx1.c, str, f());
            } else if (c == 1) {
                n63 n63Var = xx1.c;
                if (n63Var != null) {
                    o63.b(n63Var);
                }
                n();
            } else if (c != 2) {
                n63 n63Var2 = xx1.c;
                if (n63Var2 != null) {
                    o63.d(n63Var2, str, f());
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
    public static class c extends xx1 {
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

        @Override // com.repackage.xx1
        public void h(String str) {
            SwanAppActivity w;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || TextUtils.isEmpty(str) || yx1.c()) {
                return;
            }
            if (xx1.a) {
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
                    n63 n63Var = xx1.c;
                    if (n63Var != null) {
                        o63.d(n63Var, str, f());
                        return;
                    }
                    return;
                }
                n63 n63Var2 = xx1.c;
                if (n63Var2 != null) {
                    o63.d(n63Var2, str, f());
                    e();
                    n();
                    return;
                }
                return;
            }
            if (h03.b0() != null && (w = h03.b0().w()) != null && !w.isFinishing()) {
                z = false;
            }
            p(z);
            if (!z) {
                if (xx1.e) {
                    n63 n63Var3 = xx1.c;
                    o63.d(n63Var3, str + "-preload", f());
                    boolean unused = xx1.e = false;
                    return;
                }
                o63.d(xx1.c, str, f());
                return;
            }
            n63 n63Var4 = xx1.c;
            o63.d(n63Var4, str + "-destroy", f());
            boolean unused2 = xx1.e = false;
        }

        public /* synthetic */ c(a aVar) {
            this();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755156320, "Lcom/repackage/xx1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755156320, "Lcom/repackage/xx1;");
                return;
            }
        }
        a = rg1.a;
    }

    public /* synthetic */ xx1(a aVar) {
        this();
    }

    public static void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, null) == null) {
            k73 k73Var = new k73();
            k73Var.a = "swan";
            k73Var.b = "launch";
            k73Var.c = "remote-debug";
            k73Var.e = "appready";
            a73.onEvent(k73Var);
        }
    }

    public static xx1 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (b == null) {
                synchronized (ul2.class) {
                    if (b == null) {
                        if (sb1.g()) {
                            b = new b(null);
                        } else {
                            b = new c(null);
                        }
                    }
                }
            }
            return b;
        }
        return (xx1) invokeV.objValue;
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

    public static void j(fl2 fl2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, fl2Var) == null) {
            fl2Var.s0().putString("aiapp_extra_need_download", "1");
            fl2Var.s0().putString("aiapp_extra_pkg_downloading", "0");
            fl2Var.s0().putLong("launch_flag_for_statistic", System.currentTimeMillis());
            k73 k73Var = new k73();
            k73Var.a = a73.n(fl2Var.G());
            k73Var.j(fl2Var);
            k73Var.b = "launch";
            k73Var.o = "1";
            k73Var.c = "remote-debug";
            JSONObject k = a73.k(fl2Var.W());
            k73Var.d(fl2Var.s0().getString(UBCCloudControlProcessor.UBC_KEY));
            k73Var.b(k);
            a73.onEvent(k73Var);
        }
    }

    public static void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, null) == null) {
            k73 k73Var = new k73();
            k73Var.a = "swan";
            k73Var.b = "launch";
            k73Var.c = "remote-debug";
            k73Var.e = "loadmaster";
            a73.onEvent(k73Var);
        }
    }

    public static void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, null) == null) {
            k73 k73Var = new k73();
            k73Var.a = "swan";
            k73Var.b = "launch";
            k73Var.c = "remote-debug";
            k73Var.e = "downloadstart";
            a73.onEvent(k73Var);
        }
    }

    public static void m(fl2 fl2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, null, fl2Var) == null) {
            k73 k73Var = new k73();
            k73Var.j(fl2Var);
            k73Var.a = a73.n(fl2Var.G());
            k73Var.b = "launch";
            k73Var.c = "remote-debug";
            k73Var.e = "downloadsuccess";
            a73.onEvent(k73Var);
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
            h03 b0 = h03.b0();
            jSONObject2.putOpt("appid", b0 == null ? "" : b0.O());
            jSONObject2.putOpt("from", "remote-debug");
            z63.a(jSONObject2);
            jSONObject.putOpt("from", "swan");
            jSONObject.putOpt("ext", jSONObject2);
        } catch (JSONException unused) {
            if (a) {
                Log.d("RemoteDebugStatistic", "page ready statistic value is invalid ");
            }
        }
        o63.f(c, jSONObject.toString());
        o63.c(c);
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
            n63 c2 = a73.c("1153");
            c = c2;
            if (!z) {
                o63.d(c2, "downloadstart", f());
                o63.d(c, "downloadsuccess", f());
            }
            Timer timer = new Timer();
            d = timer;
            timer.schedule(new a(this), 40000L);
        }
    }

    public xx1() {
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
