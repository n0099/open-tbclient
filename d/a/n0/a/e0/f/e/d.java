package d.a.n0.a.e0.f.e;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.ubcprocessor.UBCCloudControlProcessor;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.n0.a.j2.p.f;
import d.a.n0.a.k;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public abstract class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f44079a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile d f44080b;

    /* renamed from: c  reason: collision with root package name */
    public static d.a.n0.a.j2.a f44081c;

    /* renamed from: d  reason: collision with root package name */
    public static Timer f44082d;

    /* renamed from: e  reason: collision with root package name */
    public static boolean f44083e;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a extends TimerTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f44084e;

        public a(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f44084e = dVar;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (d.f44079a) {
                    Log.d("RemoteDebugStatistic", "timer: send remote debug ubc flow");
                }
                this.f44084e.e();
                this.f44084e.n();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b extends d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b() {
            super(null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((a) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // d.a.n0.a.e0.f.e.d
        public void h(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || TextUtils.isEmpty(str)) {
                return;
            }
            if (d.f44079a) {
                Log.d("RemoteDebugStatistic", "remote-debug statistic event name is : " + str);
            }
            char c2 = 65535;
            int hashCode = str.hashCode();
            if (hashCode != 50335962) {
                if (hashCode != 1109597094) {
                    if (hashCode == 1158237819 && str.equals("downloadsuccess")) {
                        c2 = 1;
                    }
                } else if (str.equals("downloadfail")) {
                    c2 = 2;
                }
            } else if (str.equals("downloadstart")) {
                c2 = 0;
            }
            if (c2 == 0) {
                p(true);
                d.a.n0.a.j2.b.d(d.f44081c, str, f());
            } else if (c2 == 1) {
                d.a.n0.a.j2.a aVar = d.f44081c;
                if (aVar != null) {
                    d.a.n0.a.j2.b.b(aVar);
                }
                n();
            } else if (c2 != 2) {
                d.a.n0.a.j2.a aVar2 = d.f44081c;
                if (aVar2 != null) {
                    d.a.n0.a.j2.b.d(aVar2, str, f());
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
    public static class c extends d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c() {
            super(null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((a) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // d.a.n0.a.e0.f.e.d
        public void h(String str) {
            SwanAppActivity x;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || TextUtils.isEmpty(str) || e.c()) {
                return;
            }
            if (d.f44079a) {
                Log.d("RemoteDebugStatistic", "remote-debug statistic event name is : " + str);
            }
            char c2 = 65535;
            int hashCode = str.hashCode();
            boolean z = true;
            if (hashCode != 511060680) {
                if (hashCode == 900970612 && str.equals("pageready")) {
                    c2 = 1;
                }
            } else if (str.equals("loadmaster")) {
                c2 = 0;
            }
            if (c2 != 0) {
                if (c2 != 1) {
                    d.a.n0.a.j2.a aVar = d.f44081c;
                    if (aVar != null) {
                        d.a.n0.a.j2.b.d(aVar, str, f());
                        return;
                    }
                    return;
                }
                d.a.n0.a.j2.a aVar2 = d.f44081c;
                if (aVar2 != null) {
                    d.a.n0.a.j2.b.d(aVar2, str, f());
                    e();
                    n();
                    return;
                }
                return;
            }
            if (d.a.n0.a.a2.e.Q() != null && (x = d.a.n0.a.a2.e.Q().x()) != null && !x.isFinishing()) {
                z = false;
            }
            p(z);
            if (!z) {
                if (d.f44083e) {
                    d.a.n0.a.j2.a aVar3 = d.f44081c;
                    d.a.n0.a.j2.b.d(aVar3, str + "-preload", f());
                    boolean unused = d.f44083e = false;
                    return;
                }
                d.a.n0.a.j2.b.d(d.f44081c, str, f());
                return;
            }
            d.a.n0.a.j2.a aVar4 = d.f44081c;
            d.a.n0.a.j2.b.d(aVar4, str + "-destroy", f());
            boolean unused2 = d.f44083e = false;
        }

        public /* synthetic */ c(a aVar) {
            this();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1916650040, "Ld/a/n0/a/e0/f/e/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1916650040, "Ld/a/n0/a/e0/f/e/d;");
                return;
            }
        }
        f44079a = k.f45831a;
    }

    public /* synthetic */ d(a aVar) {
        this();
    }

    public static void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null) == null) {
            f fVar = new f();
            fVar.f45817a = "swan";
            fVar.f45818b = "launch";
            fVar.f45819c = "remote-debug";
            fVar.f45821e = "appready";
            d.a.n0.a.j2.k.onEvent(fVar);
        }
    }

    public static d g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (f44080b == null) {
                synchronized (d.a.n0.a.g1.f.class) {
                    if (f44080b == null) {
                        if (d.a.g0.b.a.a.g()) {
                            f44080b = new b(null);
                        } else {
                            f44080b = new c(null);
                        }
                    }
                }
            }
            return f44080b;
        }
        return (d) invokeV.objValue;
    }

    public static void i(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65544, null, jSONArray) == null) || jSONArray == null || jSONArray.length() <= 0) {
            return;
        }
        JSONObject optJSONObject = jSONArray.optJSONObject(0);
        String optString = optJSONObject != null ? optJSONObject.optString("actionId") : "";
        if (TextUtils.isEmpty(optString) || f44080b == null) {
            return;
        }
        f44080b.h(optString);
    }

    public static void j(d.a.n0.a.f1.e.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, cVar) == null) {
            cVar.r0().putString("aiapp_extra_need_download", "1");
            cVar.r0().putString("aiapp_extra_pkg_downloading", "0");
            cVar.r0().putLong("launch_flag_for_statistic", System.currentTimeMillis());
            f fVar = new f();
            fVar.f45817a = d.a.n0.a.j2.k.m(cVar.G());
            fVar.j(cVar);
            fVar.f45818b = "launch";
            fVar.o = "1";
            fVar.f45819c = "remote-debug";
            JSONObject k = d.a.n0.a.j2.k.k(cVar.W());
            fVar.d(cVar.r0().getString(UBCCloudControlProcessor.UBC_KEY));
            fVar.b(k);
            d.a.n0.a.j2.k.onEvent(fVar);
        }
    }

    public static void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, null) == null) {
            f fVar = new f();
            fVar.f45817a = "swan";
            fVar.f45818b = "launch";
            fVar.f45819c = "remote-debug";
            fVar.f45821e = "loadmaster";
            d.a.n0.a.j2.k.onEvent(fVar);
        }
    }

    public static void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, null) == null) {
            f fVar = new f();
            fVar.f45817a = "swan";
            fVar.f45818b = "launch";
            fVar.f45819c = "remote-debug";
            fVar.f45821e = "downloadstart";
            d.a.n0.a.j2.k.onEvent(fVar);
        }
    }

    public static void m(d.a.n0.a.f1.e.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, null, cVar) == null) {
            f fVar = new f();
            fVar.j(cVar);
            fVar.f45817a = d.a.n0.a.j2.k.m(cVar.G());
            fVar.f45818b = "launch";
            fVar.f45819c = "remote-debug";
            fVar.f45821e = "downloadsuccess";
            d.a.n0.a.j2.k.onEvent(fVar);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || f44081c == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            d.a.n0.a.a2.e Q = d.a.n0.a.a2.e.Q();
            jSONObject2.putOpt("appid", Q == null ? "" : Q.D());
            jSONObject2.putOpt("from", "remote-debug");
            jSONObject.putOpt("from", "swan");
            jSONObject.putOpt("ext", jSONObject2);
        } catch (JSONException unused) {
            if (f44079a) {
                Log.d("RemoteDebugStatistic", "page ready statistic value is invalid ");
            }
        }
        d.a.n0.a.j2.b.f(f44081c, jSONObject.toString());
        d.a.n0.a.j2.b.c(f44081c);
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("timestamp", Long.valueOf(System.currentTimeMillis()));
            } catch (JSONException e2) {
                if (f44079a) {
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
            Timer timer = f44082d;
            if (timer != null) {
                timer.cancel();
                f44082d = null;
            }
            f44080b = null;
            f44081c = null;
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            f44083e = true;
        }
    }

    public void p(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048581, this, z) == null) && f44081c == null) {
            d.a.n0.a.j2.a c2 = d.a.n0.a.j2.k.c("1153");
            f44081c = c2;
            if (!z) {
                d.a.n0.a.j2.b.d(c2, "downloadstart", f());
                d.a.n0.a.j2.b.d(f44081c, "downloadsuccess", f());
            }
            Timer timer = new Timer();
            f44082d = timer;
            timer.schedule(new a(this), 40000L);
        }
    }

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }
}
