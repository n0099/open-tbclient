package d.a.q0.a.u.e.j;

import android.os.Build;
import android.util.Log;
import android.webkit.ValueCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.searchbox.v8engine.V8NetFunctionTable;
import com.baidu.searchbox.v8engine.net.NetRequest;
import com.baidu.searchbox.v8engine.net.NetRequestSettings;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.a2.n.c;
import d.a.q0.a.j2.c;
import d.a.q0.a.k;
import d.a.q0.a.v2.j;
import d.a.q0.a.v2.q;
/* loaded from: classes8.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f50969a;

    /* renamed from: b  reason: collision with root package name */
    public static int f50970b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static class a implements ValueCallback<Long> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ V8Engine f50971a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ NetRequest f50972b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f50973c;

        public a(V8Engine v8Engine, NetRequest netRequest, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v8Engine, netRequest, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50971a = v8Engine;
            this.f50972b = netRequest;
            this.f50973c = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.webkit.ValueCallback
        /* renamed from: a */
        public void onReceiveValue(Long l) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, l) == null) {
                boolean netRequest = this.f50971a.setNetRequest(this.f50972b);
                if (netRequest) {
                    int unused = d.f50970b = 1;
                } else {
                    if (this.f50973c) {
                        d.d();
                        d.a.q0.a.e0.d.h("ChromeNetManager", "[ERROR] swan chromeNet config fail!!!");
                    }
                    int unused2 = d.f50970b = 0;
                }
                d.f(netRequest);
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.b bVar = new c.b(10016);
                bVar.l(Build.MODEL);
                bVar.h(Build.BRAND);
                bVar.m();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2111708455, "Ld/a/q0/a/u/e/j/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2111708455, "Ld/a/q0/a/u/e/j/d;");
                return;
            }
        }
        f50969a = k.f49133a;
        f50970b = -1;
    }

    public static boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f50970b == -1) {
                f50970b = j.a() ? 1 : 0;
            }
            return f50970b == 1;
        }
        return invokeV.booleanValue;
    }

    public static void c(@NonNull V8Engine v8Engine) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, v8Engine) == null) {
            if (!b()) {
                d.a.q0.a.e0.d.h("ChromeNetManager", "Not Used ChromeNet");
                return;
            }
            NetRequest netRequest = new NetRequest();
            NetRequestSettings netRequestSettings = new NetRequestSettings();
            netRequestSettings.mTimeout = 60000;
            netRequestSettings.mShouldNeverClearReferer = true;
            netRequestSettings.mLoadDoNotSendCookies = true;
            netRequest.setRequestInterceptor(new c());
            netRequest.setRedirectInterceptor(new i());
            netRequest.addObserver(new e());
            netRequest.setNetRequestSettings(netRequestSettings);
            boolean e2 = e();
            f50970b = e2 ? 1 : 0;
            V8NetFunctionTable.addOnCronetThreadInitializedListener(new a(v8Engine, netRequest, e2));
        }
    }

    public static void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65540, null) == null) {
            q.e().execute(new b());
        }
    }

    public static boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) ? d.a.q0.a.k2.g.h.a().getBoolean("key_chrome_net_last_usage_enabled", false) : invokeV.booleanValue;
    }

    public static void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(AdIconUtil.BAIDU_LOGO_ID, null, z) == null) {
            d.a.q0.a.k2.g.h.a().putBoolean("key_chrome_net_last_usage_enabled", z);
        }
    }

    public static void g(@Nullable SwanAppConfigData swanAppConfigData) {
        c.a aVar;
        int i2;
        d.a.q0.a.h0.l.a P;
        NetRequest n0;
        NetRequestSettings netRequestSettings;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65543, null, swanAppConfigData) == null) || !b() || swanAppConfigData == null || (aVar = swanAppConfigData.f11463h) == null || (i2 = aVar.f46720b) <= 0 || (P = d.a.q0.a.h0.u.g.N().P()) == null || !(P.g() instanceof d.a.q0.a.l0.a) || (n0 = ((d.a.q0.a.l0.a) P.g()).n0()) == null || (netRequestSettings = n0.getNetRequestSettings()) == null) {
            return;
        }
        netRequestSettings.mTimeout = i2;
        if (f50969a) {
            Log.d("ChromeNetManager", "settings.mTimeout=" + i2);
        }
    }
}
