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
/* loaded from: classes6.dex */
public abstract class ky1 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static volatile ky1 b;
    public static a73 c;
    public static Timer d;
    public static boolean e;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a extends TimerTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ky1 a;

        public a(ky1 ky1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ky1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ky1Var;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (ky1.a) {
                    Log.d("RemoteDebugStatistic", "timer: send remote debug ubc flow");
                }
                this.a.e();
                this.a.n();
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b extends ky1 {
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

        @Override // com.repackage.ky1
        public void h(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || TextUtils.isEmpty(str)) {
                return;
            }
            if (ky1.a) {
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
                b73.d(ky1.c, str, f());
            } else if (c == 1) {
                a73 a73Var = ky1.c;
                if (a73Var != null) {
                    b73.b(a73Var);
                }
                n();
            } else if (c != 2) {
                a73 a73Var2 = ky1.c;
                if (a73Var2 != null) {
                    b73.d(a73Var2, str, f());
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

    /* loaded from: classes6.dex */
    public static class c extends ky1 {
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

        @Override // com.repackage.ky1
        public void h(String str) {
            SwanAppActivity x;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || TextUtils.isEmpty(str) || ly1.c()) {
                return;
            }
            if (ky1.a) {
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
                    a73 a73Var = ky1.c;
                    if (a73Var != null) {
                        b73.d(a73Var, str, f());
                        return;
                    }
                    return;
                }
                a73 a73Var2 = ky1.c;
                if (a73Var2 != null) {
                    b73.d(a73Var2, str, f());
                    e();
                    n();
                    return;
                }
                return;
            }
            if (u03.a0() != null && (x = u03.a0().x()) != null && !x.isFinishing()) {
                z = false;
            }
            p(z);
            if (!z) {
                if (ky1.e) {
                    a73 a73Var3 = ky1.c;
                    b73.d(a73Var3, str + "-preload", f());
                    boolean unused = ky1.e = false;
                    return;
                }
                b73.d(ky1.c, str, f());
                return;
            }
            a73 a73Var4 = ky1.c;
            b73.d(a73Var4, str + "-destroy", f());
            boolean unused2 = ky1.e = false;
        }

        public /* synthetic */ c(a aVar) {
            this();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755542642, "Lcom/repackage/ky1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755542642, "Lcom/repackage/ky1;");
                return;
            }
        }
        a = eh1.a;
    }

    public /* synthetic */ ky1(a aVar) {
        this();
    }

    public static void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, null) == null) {
            x73 x73Var = new x73();
            x73Var.a = "swan";
            x73Var.b = "launch";
            x73Var.c = "remote-debug";
            x73Var.e = "appready";
            n73.onEvent(x73Var);
        }
    }

    public static ky1 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (b == null) {
                synchronized (hm2.class) {
                    if (b == null) {
                        if (fc1.g()) {
                            b = new b(null);
                        } else {
                            b = new c(null);
                        }
                    }
                }
            }
            return b;
        }
        return (ky1) invokeV.objValue;
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

    public static void j(sl2 sl2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, sl2Var) == null) {
            sl2Var.s0().putString("aiapp_extra_need_download", "1");
            sl2Var.s0().putString("aiapp_extra_pkg_downloading", "0");
            sl2Var.s0().putLong("launch_flag_for_statistic", System.currentTimeMillis());
            x73 x73Var = new x73();
            x73Var.a = n73.n(sl2Var.G());
            x73Var.j(sl2Var);
            x73Var.b = "launch";
            x73Var.o = "1";
            x73Var.c = "remote-debug";
            JSONObject k = n73.k(sl2Var.W());
            x73Var.d(sl2Var.s0().getString(UBCCloudControlProcessor.UBC_KEY));
            x73Var.b(k);
            n73.onEvent(x73Var);
        }
    }

    public static void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, null) == null) {
            x73 x73Var = new x73();
            x73Var.a = "swan";
            x73Var.b = "launch";
            x73Var.c = "remote-debug";
            x73Var.e = "loadmaster";
            n73.onEvent(x73Var);
        }
    }

    public static void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, null) == null) {
            x73 x73Var = new x73();
            x73Var.a = "swan";
            x73Var.b = "launch";
            x73Var.c = "remote-debug";
            x73Var.e = "downloadstart";
            n73.onEvent(x73Var);
        }
    }

    public static void m(sl2 sl2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, null, sl2Var) == null) {
            x73 x73Var = new x73();
            x73Var.j(sl2Var);
            x73Var.a = n73.n(sl2Var.G());
            x73Var.b = "launch";
            x73Var.c = "remote-debug";
            x73Var.e = "downloadsuccess";
            n73.onEvent(x73Var);
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
            u03 a0 = u03.a0();
            jSONObject2.putOpt("appid", a0 == null ? "" : a0.N());
            jSONObject2.putOpt("from", "remote-debug");
            m73.a(jSONObject2);
            jSONObject.putOpt("from", "swan");
            jSONObject.putOpt("ext", jSONObject2);
        } catch (JSONException unused) {
            if (a) {
                Log.d("RemoteDebugStatistic", "page ready statistic value is invalid ");
            }
        }
        b73.f(c, jSONObject.toString());
        b73.c(c);
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
            a73 c2 = n73.c("1153");
            c = c2;
            if (!z) {
                b73.d(c2, "downloadstart", f());
                b73.d(c, "downloadsuccess", f());
            }
            Timer timer = new Timer();
            d = timer;
            timer.schedule(new a(this), 40000L);
        }
    }

    public ky1() {
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
