package d.a.n0.a.j2;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.core.view.InputDeviceCompat;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.http.statistics.NetworkStatRecord;
import com.baidu.searchbox.ubcprocessor.UBCCloudControlProcessor;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.favordata.SwanFavorItemData;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.scheme.actions.forbidden.ForbiddenInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.paysdk.banksign.datamodel.QueryResponse;
import com.facebook.common.internal.Sets;
import d.a.n0.a.f1.e.b;
import d.a.n0.a.j2.n;
import d.a.n0.a.v2.q;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import okhttp3.HttpUrl;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class k {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f45765a;

    /* renamed from: b  reason: collision with root package name */
    public static final ExecutorService f45766b;

    /* renamed from: c  reason: collision with root package name */
    public static final Set<String> f45767c;

    /* renamed from: d  reason: collision with root package name */
    public static final CopyOnWriteArrayList<String> f45768d;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f45769e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f45770f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ long f45771g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f45772h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ int f45773i;
        public final /* synthetic */ String j;
        public final /* synthetic */ String k;
        public final /* synthetic */ String l;
        public final /* synthetic */ String m;
        public final /* synthetic */ NetworkStatRecord n;

        public a(String str, long j, long j2, int i2, int i3, String str2, String str3, String str4, String str5, NetworkStatRecord networkStatRecord) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r3;
                Object[] objArr = {str, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i2), Integer.valueOf(i3), str2, str3, str4, str5, networkStatRecord};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45769e = str;
            this.f45770f = j;
            this.f45771g = j2;
            this.f45772h = i2;
            this.f45773i = i3;
            this.j = str2;
            this.k = str3;
            this.l = str4;
            this.m = str5;
            this.n = networkStatRecord;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && SwanAppNetworkUtils.i(null)) {
                if (k.n(this.f45769e)) {
                    if (k.f45765a) {
                        Log.d("SwanAppUBCStatistic", "onRequest: ignore " + this.f45769e);
                        return;
                    }
                    return;
                }
                long j = this.f45770f - this.f45771g;
                boolean z = this.f45772h == 200;
                if (this.f45773i == 0) {
                    if (TextUtils.equals(this.j, "1")) {
                        if (z) {
                            d.a.n0.a.h0.i.i.p(this.f45769e, j);
                        } else {
                            d.a.n0.a.h0.i.i.n(this.f45769e, this.f45772h);
                        }
                    } else if (TextUtils.equals(this.j, "0")) {
                        d.a.n0.a.h0.i.i.o(this.f45769e);
                    }
                }
                if (z && j < 5000) {
                    if (k.f45765a) {
                        Log.d("SwanAppUBCStatistic", "code 200 & cost(" + (this.f45770f - this.f45771g) + ") is ok, don't report");
                        return;
                    }
                    return;
                }
                k.j(this.f45772h, this.f45769e, this.f45773i, this.k, this.l, this.m, this.j, this.f45771g, this.f45770f, this.n);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f45774e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f45775f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f45776g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f45777h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f45778i;
        public final /* synthetic */ String j;
        public final /* synthetic */ int k;

        public b(String str, int i2, String str2, String str3, String str4, String str5, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), str2, str3, str4, str5, Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45774e = str;
            this.f45775f = i2;
            this.f45776g = str2;
            this.f45777h = str3;
            this.f45778i = str4;
            this.j = str5;
            this.k = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.n0.a.j2.p.c cVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int a2 = d.a.n0.a.n1.l.a();
                if (k.f45765a) {
                    Log.d("SwanAppUBCStatistic", "get NetworkQuality: " + a2);
                }
                if (TextUtils.equals(this.f45774e, "1")) {
                    cVar = new d.a.n0.a.j2.p.c(this.f45775f, this.f45776g, this.f45777h, a2);
                } else {
                    cVar = new d.a.n0.a.j2.p.c(this.f45776g, a2, 0L, 0L);
                }
                new n.a(cVar, "downloadFile");
                if (!TextUtils.isEmpty(this.f45778i)) {
                    cVar.q(this.f45778i);
                }
                if (!TextUtils.isEmpty(this.j)) {
                    cVar.p(this.j);
                }
                cVar.f45818b = "downloadFile";
                if (d.a.n0.a.a2.e.i() != null && d.a.n0.a.a2.e.i().N() != null) {
                    cVar.f45819c = d.a.n0.a.a2.e.i().N().T();
                }
                cVar.f45822f = d.a.n0.a.a2.e.V();
                cVar.f45817a = k.m(this.k);
                JSONObject f2 = cVar.f();
                d.a.n0.a.j2.b.k("834", f2);
                d.a.n0.a.e0.d.h("SwanAppUBCStatistic", "834-downloadFile event=" + f2.toString());
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.a.j2.p.e f45779e;

        public c(d.a.n0.a.j2.p.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45779e = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.a.n0.a.j2.b.k("894", this.f45779e.f());
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.a.j2.p.b f45780e;

        public d(d.a.n0.a.j2.p.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45780e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.a.n0.a.j2.b.k("751", this.f45780e.f());
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f45781e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ForbiddenInfo f45782f;

        public e(String str, ForbiddenInfo forbiddenInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, forbiddenInfo};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45781e = str;
            this.f45782f = forbiddenInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.a.n0.a.j2.p.d dVar = new d.a.n0.a.j2.p.d();
                dVar.f45821e = this.f45781e;
                dVar.f45818b = "show";
                dVar.f45817a = "swan";
                ForbiddenInfo forbiddenInfo = this.f45782f;
                dVar.f45819c = forbiddenInfo.launchSource;
                dVar.a("path", forbiddenInfo.launchPath);
                dVar.a("appkey", this.f45782f.appId);
                d.a.n0.a.j2.b.m("1400", dVar.f());
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f45783e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f45784f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f45785g;

        public f(String str, String str2, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45783e = str;
            this.f45784f = str2;
            this.f45785g = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.n0.a.a2.e Q;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (Q = d.a.n0.a.a2.e.Q()) == null) {
                return;
            }
            b.a L = Q.L();
            String O = Q.O();
            String appId = Q.getAppId();
            d.a.n0.a.j2.p.d dVar = new d.a.n0.a.j2.p.d();
            dVar.f45818b = "login";
            dVar.f45817a = k.m(L.G());
            dVar.f45822f = appId;
            dVar.f45821e = this.f45783e;
            dVar.a("appName", O);
            dVar.a("invokeFrom", this.f45784f);
            dVar.a("scene", Integer.valueOf(this.f45785g));
            if (TextUtils.equals(this.f45783e, "show")) {
                d.a.n0.a.j2.b.i("1936", "80", dVar.f());
            } else if (TextUtils.equals(this.f45783e, "success")) {
                d.a.n0.a.j2.b.i("1936", "81", dVar.f());
            } else if (TextUtils.equals(this.f45783e, com.baidu.pass.biometrics.face.liveness.b.a.g0)) {
                d.a.n0.a.j2.b.i("1936", "82", dVar.f());
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f45786e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f45787f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f45788g;

        public g(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45786e = str;
            this.f45787f = str2;
            this.f45788g = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.a.n0.a.a2.e r = d.a.n0.a.a2.d.g().r();
                b.a L = r.L();
                String O = r.O();
                String appId = r.getAppId();
                d.a.n0.a.j2.p.d dVar = new d.a.n0.a.j2.p.d();
                dVar.f45818b = "swanLogin";
                dVar.f45817a = k.m(L.G());
                dVar.f45822f = appId;
                dVar.f45821e = this.f45786e;
                dVar.a("appName", O);
                dVar.a("loginScene", this.f45787f);
                String str = this.f45788g;
                if (str != null) {
                    dVar.a("errorInfo", str);
                }
                d.a.n0.a.j2.b.i("1936", "1936", dVar.f());
                if (k.f45765a) {
                    Log.i("SwanAppUBCStatistic", "onSwanLoginProcessStatistic: scene = " + this.f45787f + " value = " + this.f45786e + " info = " + this.f45788g);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.a.j2.p.e f45789e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.a.j2.a f45790f;

        public h(d.a.n0.a.j2.p.e eVar, d.a.n0.a.j2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45789e = eVar;
            this.f45790f = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.a.n0.a.j2.p.e eVar = this.f45789e;
                if (eVar != null) {
                    d.a.n0.a.j2.b.f(this.f45790f, eVar.f().toString());
                }
                d.a.n0.a.j2.b.c(this.f45790f);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.a.j2.p.d f45791e;

        public i(d.a.n0.a.j2.p.d dVar) {
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
            this.f45791e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (TextUtils.isEmpty(this.f45791e.g())) {
                    this.f45791e.k(d.a.n0.a.a2.d.g().r().L().V());
                }
                d.a.n0.a.j2.b.k("671", this.f45791e.f());
                d.a.n0.a.e0.d.h("SwanAppUBCStatistic", "671 event=" + this.f45791e.f().toString());
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class j implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f45792e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.a.j2.p.e f45793f;

        public j(String str, d.a.n0.a.j2.p.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45792e = str;
            this.f45793f = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.a.n0.a.j2.b.k(this.f45792e, this.f45793f.f());
            }
        }
    }

    /* renamed from: d.a.n0.a.j2.k$k  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class RunnableC0792k implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f45794e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f45795f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.a.j2.p.e f45796g;

        public RunnableC0792k(String str, String str2, d.a.n0.a.j2.p.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45794e = str;
            this.f45795f = str2;
            this.f45796g = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.a.n0.a.j2.b.i(this.f45794e, this.f45795f, this.f45796g.f());
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class l implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.a.j2.p.b f45797e;

        public l(d.a.n0.a.j2.p.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45797e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.a.n0.a.j2.b.k("751", this.f45797e.f());
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class m implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.a.j2.p.b f45798e;

        public m(d.a.n0.a.j2.p.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45798e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.a.n0.a.j2.b.k("751", this.f45798e.f());
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class n implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.a.j2.p.b f45799e;

        public n(d.a.n0.a.j2.p.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45799e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.a.n0.a.j2.b.k("751", this.f45799e.f());
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class o implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.a.j2.p.e f45800e;

        public o(d.a.n0.a.j2.p.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45800e = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f45800e.b(k.R());
                d.a.n0.a.j2.b.k("778", this.f45800e.f());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(708382305, "Ld/a/n0/a/j2/k;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(708382305, "Ld/a/n0/a/j2/k;");
                return;
            }
        }
        f45765a = d.a.n0.a.k.f45831a;
        f45766b = Executors.newSingleThreadExecutor();
        f45767c = Sets.newHashSet("hmma.baidu.com");
        CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        f45768d = copyOnWriteArrayList;
        copyOnWriteArrayList.add("https://hmma.baidu.com/mini.gif");
        f45768d.add("https://dxp.baidu.com/mini");
        CopyOnWriteArrayList<String> copyOnWriteArrayList2 = f45768d;
        copyOnWriteArrayList2.add(d.a.n0.a.d0.a.c() + "/smtapp/recordhandler/getrecordinfo");
        CopyOnWriteArrayList<String> copyOnWriteArrayList3 = f45768d;
        copyOnWriteArrayList3.add(d.a.n0.a.d0.a.d() + "/smtapp/recordhandler/getrecordinfo");
    }

    public static void A() {
        b.a L;
        Bundle P;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65537, null) == null) || !d.a.n0.a.a2.d.g().C() || (P = (L = d.a.n0.a.a2.d.g().r().L()).P()) == null || P.getLong("launch_flag_for_statistic") <= 0) {
            return;
        }
        long l2 = L.l("launch_time", 0L);
        long currentTimeMillis = System.currentTimeMillis();
        d.a.n0.a.j2.p.f fVar = new d.a.n0.a.j2.p.f();
        fVar.f45817a = m(d.a.n0.a.a2.d.g().l());
        fVar.f45822f = L.H();
        if (d.a.n0.a.u1.a.a.E(L.g0())) {
            fVar.f45819c = "remote-debug";
        } else if (d.a.n0.a.u1.a.a.C()) {
            fVar.f45819c = "local-debug";
        } else {
            fVar.f45819c = L.T();
        }
        fVar.f45818b = "launch";
        fVar.f45821e = "success";
        fVar.r = String.valueOf(currentTimeMillis - l2);
        fVar.a("status", "0");
        d.a.n0.a.j2.e.n(fVar, L.W(), L.r0().getString(UBCCloudControlProcessor.UBC_KEY));
        P.putLong("launch_flag_for_statistic", 0L);
        HybridUbcFlow d2 = d.a.n0.a.r1.h.d("startup");
        if (d2 != null) {
            if (d2.t() || d2.r()) {
                return;
            }
            d2.B("value", "na_success");
        }
    }

    public static void B(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(65538, null, z, str) == null) {
            d.a.n0.a.j2.p.e eVar = new d.a.n0.a.j2.p.e();
            if (d.a.n0.a.a2.d.g().r().e()) {
                eVar.d(d.a.n0.a.a2.d.g().r().L().r0().getString(UBCCloudControlProcessor.UBC_KEY));
            }
            eVar.f45818b = "show";
            eVar.f45819c = str;
            eVar.f45821e = z ? "success" : com.baidu.pass.biometrics.face.liveness.b.a.g0;
            eVar.f45822f = d.a.n0.a.a2.e.V();
            d.a.n0.a.r1.k.i.c.f().e(new o(eVar), "SwanAppUBCOnPagesRoute");
        }
    }

    public static void C(String str, String str2, List<String> list) {
        int i2;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, null, str, str2, list) == null) {
            if (d.a.n0.a.a2.d.g().r().e()) {
                b.a L = d.a.n0.a.a2.d.g().r().L();
                i2 = L.G();
                str3 = L.r0().getString(UBCCloudControlProcessor.UBC_KEY);
            } else {
                i2 = 0;
                str3 = "";
            }
            d.a.n0.a.j2.p.b bVar = new d.a.n0.a.j2.p.b();
            bVar.f45818b = "pay";
            bVar.f45819c = str;
            bVar.f45822f = d.a.n0.a.a2.e.V();
            bVar.f45817a = m(i2);
            try {
                JSONObject jSONObject = new JSONObject(str3);
                if (!TextUtils.isEmpty(str2)) {
                    jSONObject.put("paymenturl", str2);
                }
                if (list != null) {
                    jSONObject.put("whitelist", list);
                }
                jSONObject.put("appname", d.a.n0.a.a2.e.i().O());
                bVar.e(jSONObject);
            } catch (JSONException e2) {
                e2.printStackTrace();
                bVar.d(str3);
            }
            bVar.b(R());
            q.j(new m(bVar), "SwanAppUBCOnPay");
        }
    }

    public static void D(boolean z, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Boolean.valueOf(z), str, str2}) == null) {
            d.a.n0.a.j2.p.b bVar = new d.a.n0.a.j2.p.b();
            b.a L = d.a.n0.a.a2.d.g().r().L();
            if (d.a.n0.a.a2.d.g().r().e()) {
                bVar.d(L.r0().getString(UBCCloudControlProcessor.UBC_KEY));
            }
            bVar.f45818b = "pay";
            bVar.f45821e = z ? "success" : com.baidu.pass.biometrics.face.liveness.b.a.g0;
            bVar.f45819c = str;
            bVar.f45822f = d.a.n0.a.a2.e.V();
            bVar.f45817a = m(L.G());
            bVar.a("money", str2);
            bVar.b(R());
            q.i(new l(bVar), "SwanAppUBCOnPay");
        }
    }

    public static void E(String str, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, null, new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            d.a.n0.a.j2.p.b bVar = new d.a.n0.a.j2.p.b();
            b.a L = d.a.n0.a.a2.d.g().r().L();
            if (d.a.n0.a.a2.d.g().r().e()) {
                bVar.d(L.r0().getString(UBCCloudControlProcessor.UBC_KEY));
            }
            bVar.f45818b = "paylogin";
            bVar.f45819c = str;
            bVar.f45822f = L.I();
            bVar.f45817a = m(L.G());
            bVar.f45821e = z ? "success" : com.baidu.pass.biometrics.face.liveness.b.a.g0;
            bVar.a("nativeAppId", d.a.n0.a.c1.a.m().a());
            bVar.a("paylogin", z2 ? "1" : "0");
            d.a.n0.a.h0.g.f J = d.a.n0.a.g1.f.V().J();
            d.a.n0.a.l1.c K1 = J == null ? null : J.K1();
            if (K1 != null && !TextUtils.isEmpty(K1.g())) {
                bVar.a("page", K1.g());
            }
            bVar.b(R());
            q.i(new d(bVar), "SwanAppUBCOnPayLogin");
        }
    }

    public static void F(String str, String str2, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(AdIconUtil.BAIDU_LOGO_ID, null, str, str2, i2) == null) && d.a.n0.a.a2.d.g().r().e()) {
            b.a L = d.a.n0.a.a2.d.g().r().L();
            int G = L.G();
            d.a.n0.a.j2.p.b bVar = new d.a.n0.a.j2.p.b();
            bVar.f45818b = "payProcess";
            bVar.f45817a = m(G);
            bVar.f45819c = str;
            bVar.a("paymentProcess", str2);
            bVar.a("appid", L.H());
            bVar.a("source", L.T());
            if (L.i0() != null) {
                bVar.a("swan", L.i0().swanCoreVersionName);
            }
            if (TextUtils.equals("result", str2)) {
                if (i2 == 0) {
                    bVar.a("payResultStatus", "success");
                } else if (i2 != 2) {
                    bVar.a("payResultStatus", com.baidu.pass.biometrics.face.liveness.b.a.g0);
                } else {
                    bVar.a("payResultStatus", QueryResponse.Options.CANCEL);
                }
            }
            bVar.b(R());
            q.j(new n(bVar), "SwanAppUBCOnPayProcess");
        }
    }

    public static void G(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, str, str2) == null) {
            d.a.n0.a.j2.p.f fVar = new d.a.n0.a.j2.p.f();
            fVar.f45818b = "launch";
            fVar.f45821e = str;
            if (d.a.n0.a.a2.e.Q() != null) {
                b.a L = d.a.n0.a.a2.e.Q().L();
                fVar.f45817a = m(L.G());
                fVar.f45822f = L.H();
                fVar.f45819c = L.T();
            }
            fVar.t = str2;
            onEvent(fVar);
        }
    }

    public static void H(int i2, String str, int i3, String str2, @Nullable String str3, @Nullable String str4, String str5, long j2, long j3, @Nullable NetworkStatRecord networkStatRecord) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), str2, str3, str4, str5, Long.valueOf(j2), Long.valueOf(j3), networkStatRecord}) == null) {
            f45766b.execute(new a(str, j3, j2, i2, i3, str5, str2, str3, str4, networkStatRecord));
        }
    }

    public static void I(String str, String str2, @NonNull JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65545, null, str, str2, jSONObject) == null) {
            if (!TextUtils.equals(str, "1")) {
                if (f45765a) {
                    Log.d("SwanAppUBCStatistic", "RequestForAvatar: onRequestForAvatar: miss. requestType=" + str);
                }
            } else if (TextUtils.isEmpty(str2)) {
                if (f45765a) {
                    Log.d("SwanAppUBCStatistic", "RequestForAvatar: onRequestForAvatar: miss. url is empty");
                }
            } else {
                HttpUrl parse = HttpUrl.parse(str2);
                if (parse == null) {
                    if (f45765a) {
                        Log.d("SwanAppUBCStatistic", "RequestForAvatar: onRequestForAvatar: miss. url is illegal, url=" + str2);
                        return;
                    }
                    return;
                }
                String host = parse.host();
                if (TextUtils.isEmpty(host)) {
                    if (f45765a) {
                        Log.d("SwanAppUBCStatistic", "RequestForAvatar: onRequestForAvatar: miss. host is empty, url=" + str2);
                    }
                } else if (f45767c.contains(host)) {
                    if (f45765a) {
                        Log.d("SwanAppUBCStatistic", "RequestForAvatar: onRequestForAvatar: miss. host is ignored, host=" + host + " ,url=" + str2);
                    }
                } else {
                    if (f45765a) {
                        Log.d("SwanAppUBCStatistic", "RequestForAvatar: onRequestForAvatar: hit. url=" + str2);
                        Log.d("SwanAppUBCStatistic", "value=" + jSONObject);
                    }
                    d.a.n0.a.j2.b.i("1415", "66", jSONObject);
                }
            }
        }
    }

    public static void J(int i2, String str, int i3, String str2, long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65546, null, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), str2, Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            K(i2, str, i3, str2, null, null, j2, j3);
        }
    }

    public static void K(int i2, String str, int i3, String str2, @Nullable String str3, @Nullable String str4, long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65547, null, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), str2, str3, str4, Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            H(i2, str, i3, str2, str3, str4, "1", j2, j3, null);
        }
    }

    public static void L(d.a.n0.a.j2.p.d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65548, null, dVar) == null) || dVar == null) {
            return;
        }
        q.i(new i(dVar), "SwanAppUBCStability");
    }

    public static void M(String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65549, null, str, i2, str2) == null) {
            f45766b.execute(new f(str, str2, i2));
        }
    }

    public static void N(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65550, null, str, str2) == null) {
            O(str, str2, null);
        }
    }

    public static void O(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65551, null, str, str2, str3) == null) {
            f45766b.execute(new g(str2, str, str3));
        }
    }

    public static JSONObject P(@Nullable NetworkStatRecord networkStatRecord) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, networkStatRecord)) == null) {
            if (networkStatRecord == null) {
                return null;
            }
            long j2 = networkStatRecord.dnsEndTs;
            long j3 = networkStatRecord.dnsStartTs;
            long j4 = networkStatRecord.connTs;
            long j5 = networkStatRecord.startTs;
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("request_network_start", j5);
                jSONObject.put("request_network_conn", j4);
                jSONObject.put("request_dns_start", j3);
                jSONObject.put("request_dns_end", j2);
                jSONObject.put("request_network_response", networkStatRecord.responseTs);
                jSONObject.put("request_send_header", networkStatRecord.sendHeaderTs);
                jSONObject.put("request_receive_header", networkStatRecord.receiveHeaderTs);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("connectTime", jSONObject);
                return jSONObject2;
            } catch (JSONException e2) {
                if (f45765a) {
                    e2.printStackTrace();
                }
                return null;
            }
        }
        return (JSONObject) invokeL.objValue;
    }

    public static void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, null) == null) {
            d.a.n0.a.a2.d g2 = d.a.n0.a.a2.d.g();
            d.a.n0.a.a2.e r = g2.r();
            b.a L = r.L();
            if (g2.C() && r.i0()) {
                Bundle r0 = L.r0();
                if (r0.getLong("launch_flag_for_statistic") > 0) {
                    String valueOf = String.valueOf(System.currentTimeMillis() - r.L().s1());
                    d.a.n0.a.j2.p.f fVar = new d.a.n0.a.j2.p.f();
                    fVar.f45817a = m(L.G());
                    fVar.f45818b = "launch";
                    fVar.f45821e = QueryResponse.Options.CANCEL;
                    fVar.q = valueOf;
                    fVar.j(L);
                    fVar.d(r0.getString(UBCCloudControlProcessor.UBC_KEY));
                    fVar.b(k(L.W()));
                    onEvent(fVar);
                    d.a.n0.a.j2.p.f fVar2 = new d.a.n0.a.j2.p.f();
                    fVar2.f45817a = m(L.G());
                    fVar2.f45818b = "launch";
                    fVar2.f45821e = "realcancel";
                    fVar2.q = valueOf;
                    fVar2.j(L);
                    fVar2.b(k(L.W()));
                    fVar2.a("reason", QueryResponse.Options.CANCEL);
                    if (L.G() == 1) {
                        fVar.a("errorList", d.a.n0.a.c1.b.j().a());
                    }
                    fVar2.d(r0.getString(UBCCloudControlProcessor.UBC_KEY));
                    onEvent(fVar2);
                    r0.remove("launch_flag_for_statistic");
                }
            }
        }
    }

    public static JSONObject R() {
        InterceptResult invokeV;
        b.a N;
        JSONObject M;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) {
            d.a.n0.a.a2.e i2 = d.a.n0.a.a2.e.i();
            if (i2 == null || (N = i2.N()) == null || (M = N.M()) == null || !TextUtils.equals(M.optString("token"), "swanubc")) {
                return null;
            }
            return M;
        }
        return (JSONObject) invokeV.objValue;
    }

    public static d.a.n0.a.j2.a c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65557, null, str)) == null) ? d.a.n0.a.j2.b.a(str) : (d.a.n0.a.j2.a) invokeL.objValue;
    }

    public static void d(d.a.n0.a.j2.p.f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65558, null, fVar) == null) || fVar == null || d.a.n0.a.a2.e.i() == null || d.a.n0.a.a2.e.i().N() == null) {
            return;
        }
        b.a N = d.a.n0.a.a2.e.i().N();
        fVar.f45817a = m(N.G());
        fVar.f45822f = N.H();
        fVar.a("appkey", N.I());
        u("1032", fVar);
    }

    public static void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65559, null, str) == null) {
            d.a.n0.a.j2.p.e eVar = new d.a.n0.a.j2.p.e();
            eVar.f45817a = m(0);
            eVar.f45818b = str;
            u("956", eVar);
        }
    }

    public static void f(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65560, null, str, str2, str3) == null) {
            d.a.n0.a.j2.p.e eVar = new d.a.n0.a.j2.p.e();
            if (d.a.n0.a.a2.e.i() != null && d.a.n0.a.a2.e.i().N() != null) {
                b.a N = d.a.n0.a.a2.e.i().N();
                eVar.f45817a = m(N.G());
                eVar.f45822f = N.H();
                eVar.f45818b = str;
                eVar.f45819c = str2;
                eVar.f45821e = str3;
                eVar.a("appkey", N.I());
            }
            u("923", eVar);
        }
    }

    public static void g(d.a.n0.a.j2.p.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65561, null, eVar) == null) {
            if (d.a.n0.a.a2.e.i() != null && d.a.n0.a.a2.e.i().N() != null) {
                b.a N = d.a.n0.a.a2.e.i().N();
                eVar.f45817a = m(N.G());
                eVar.f45822f = N.H();
                eVar.f45819c = N.T();
            }
            u("936", eVar);
        }
    }

    public static void h(d.a.n0.a.j2.p.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65562, null, eVar) == null) {
            if (d.a.n0.a.a2.e.i() != null && d.a.n0.a.a2.e.i().N() != null) {
                b.a N = d.a.n0.a.a2.e.i().N();
                eVar.f45817a = m(N.G());
                eVar.f45822f = N.H();
                eVar.f45819c = N.T();
            }
            u("914", eVar);
        }
    }

    public static void i(d.a.n0.a.j2.a aVar, d.a.n0.a.j2.p.e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65563, null, aVar, eVar) == null) || aVar == null) {
            return;
        }
        q.i(new h(eVar, aVar), "SwanAppUBCEndFlow");
    }

    @WorkerThread
    public static void j(int i2, String str, int i3, String str2, @Nullable String str3, @Nullable String str4, String str5, long j2, long j3, @Nullable NetworkStatRecord networkStatRecord) {
        d.a.n0.a.j2.p.c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65564, null, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), str2, str3, str4, str5, Long.valueOf(j2), Long.valueOf(j3), networkStatRecord}) == null) {
            int a2 = d.a.n0.a.n1.l.a();
            if (f45765a) {
                Log.d("SwanAppUBCStatistic", "get NetworkQuality: " + a2);
            }
            if (TextUtils.equals(str5, "1")) {
                cVar = new d.a.n0.a.j2.p.c(i2, str, str2, a2, j2, j3);
            } else {
                cVar = new d.a.n0.a.j2.p.c(str, a2, j2, j3);
            }
            n.a aVar = new n.a(cVar, "request");
            if (!TextUtils.isEmpty(str3)) {
                cVar.q(str3);
            }
            if (!TextUtils.isEmpty(str4)) {
                cVar.p(str4);
            }
            cVar.f45818b = "request";
            d.a.n0.a.a2.e r = d.a.n0.a.a2.d.g().r();
            if (r != null && r.e()) {
                cVar.f45819c = r.L().T();
                cVar.f45820d = r.L().V();
            }
            cVar.f45822f = d.a.n0.a.a2.e.V();
            cVar.f45817a = m(i3);
            JSONObject P = P(networkStatRecord);
            aVar.f45810b = P;
            if (P != null) {
                cVar.e(P);
            }
            if (f45765a) {
                Log.d("SwanAppUBCStatistic", "Reporting: " + cVar.f());
            }
            JSONObject f2 = cVar.f();
            d.a.n0.a.j2.b.k("834", f2);
            I(cVar.m(), cVar.n(), f2);
            d.a.n0.a.e0.d.h("SwanAppUBCStatistic", "834-request event=" + f2.toString());
        }
    }

    public static JSONObject k(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65565, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            String queryParameter = Uri.parse(str).getQueryParameter("_baiduboxapp");
            if (!TextUtils.isEmpty(queryParameter)) {
                try {
                    JSONObject optJSONObject = new JSONObject(queryParameter).optJSONObject("ext");
                    if (optJSONObject != null) {
                        if (TextUtils.equals(optJSONObject.optString("token"), "swanubc")) {
                            return optJSONObject;
                        }
                    }
                } catch (JSONException e2) {
                    if (f45765a) {
                        e2.printStackTrace();
                    }
                }
            }
            return null;
        }
        return (JSONObject) invokeL.objValue;
    }

    public static String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65566, null)) == null) ? d.a.n0.a.m1.f.g() ? "1" : "0" : (String) invokeV.objValue;
    }

    public static String m(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65567, null, i2)) == null) ? i2 != 1 ? "swan" : SwanFavorItemData.SCHEME_AUTHORITY_SWAN_GAME : (String) invokeI.objValue;
    }

    public static boolean n(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65568, null, str)) == null) {
            if (f45765a) {
                Log.d("SwanAppUBCStatistic", "isIgnoreRequest: start with " + str);
            }
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            int size = f45768d.size();
            for (int i2 = 0; i2 < size; i2++) {
                String str2 = f45768d.get(i2);
                if (!TextUtils.isEmpty(str2) && str.startsWith(str2)) {
                    if (f45765a) {
                        Log.d("SwanAppUBCStatistic", "isIgnoreRequest: ignore " + str);
                        return true;
                    }
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void o(String str, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65569, null, str, str2, z) == null) {
            d.a.n0.a.j2.p.e eVar = new d.a.n0.a.j2.p.e();
            eVar.f45818b = str;
            eVar.f45821e = str2;
            eVar.f45822f = d.a.n0.a.a2.e.V();
            if (d.a.n0.a.a2.e.i() != null && d.a.n0.a.a2.e.i().N() != null) {
                b.a N = d.a.n0.a.a2.e.i().N();
                eVar.f45819c = N.T();
                eVar.f45817a = m(N.G());
            }
            if (TextUtils.equals(PrefetchEvent.STATE_CLICK, str)) {
                eVar.a("authorize", z ? "success" : com.baidu.pass.biometrics.face.liveness.b.a.g0);
            }
            q.j(new c(eVar), "SwanAppUBCOnAuthDialog");
        }
    }

    public static void onEvent(d.a.n0.a.j2.p.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65570, null, fVar) == null) {
            ExtensionCore M = d.a.n0.a.h0.u.g.N().M();
            if (M != null) {
                fVar.a("extension_ver", M.extensionCoreVersionName);
            }
            fVar.a("isReloadApp", d.a.n0.a.a2.d.g().r().L().d("launch_by_reload") ? "1" : "0");
            u("606", fVar);
        }
    }

    public static void p(int i2, d.a.n0.a.e2.c.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65571, null, i2, fVar) == null) {
            d.a.n0.a.a2.e Q = d.a.n0.a.a2.e.Q();
            if (Q == null) {
                if (f45765a) {
                    Log.e("SwanAppUBCStatistic", "onAuthorizeFailed-swanApp is null");
                    return;
                }
                return;
            }
            d.a.n0.a.j2.p.d dVar = new d.a.n0.a.j2.p.d();
            dVar.o(i2);
            dVar.r(Q.N());
            dVar.q(m(Q.l()));
            dVar.m(Q.getAppId());
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("appid", Q.getAppId());
                jSONObject.put("msg", d.a.n0.a.e2.c.d.f(i2));
                jSONObject.put(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID, Q.T().q("cur_request_id", ""));
                if (fVar != null) {
                    jSONObject.put("scope", fVar.f44327b);
                    jSONObject.put("scopeData", fVar.f44326a);
                }
            } catch (JSONException e2) {
                if (f45765a) {
                    e2.printStackTrace();
                }
            }
            dVar.e(jSONObject);
            L(dVar);
        }
    }

    @WorkerThread
    public static void q(int i2, String str, int i3, String str2, @Nullable String str3, @Nullable String str4, String str5) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65572, null, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), str2, str3, str4, str5}) == null) || i2 == 200) {
            return;
        }
        f45766b.execute(new b(str5, i2, str, str2, str3, str4, i3));
    }

    public static void r(int i2, String str, int i3, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65573, null, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), str2}) == null) {
            q(i2, str, i3, str2, null, null, "1");
        }
    }

    public static void s(int i2, String str, int i3, String str2, @Nullable String str3, @Nullable String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65574, null, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), str2, str3, str4}) == null) {
            q(i2, str, i3, str2, str3, str4, "1");
        }
    }

    public static void t(ForbiddenInfo forbiddenInfo, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65575, null, forbiddenInfo, str) == null) || forbiddenInfo == null || TextUtils.isEmpty(str)) {
            return;
        }
        f45766b.execute(new e(str, forbiddenInfo));
    }

    public static void u(String str, d.a.n0.a.j2.p.e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65576, null, str, eVar) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        d.a.n0.a.r1.k.i.c.f().e(new j(str, eVar), "SwanAppUBCOnEvent");
    }

    public static void v(String str, String str2, d.a.n0.a.j2.p.e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65577, null, str, str2, eVar) == null) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        q.i(new RunnableC0792k(str, str2, eVar), "SwanAppUbcCeresOnEvent");
    }

    public static void w(String str, int i2, String str2) {
        d.a.n0.a.a2.e Q;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(65578, null, str, i2, str2) == null) || (Q = d.a.n0.a.a2.e.Q()) == null) {
            return;
        }
        d.a.n0.a.q2.a aVar = new d.a.n0.a.q2.a();
        aVar.j(5L);
        aVar.h(50L);
        d.a.n0.a.j2.p.d dVar = new d.a.n0.a.j2.p.d();
        dVar.p(aVar);
        dVar.r(Q.L());
        dVar.q(m(Q.l()));
        dVar.m(Q.getAppId());
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appid", Q.getAppId());
            jSONObject.put("url", str);
            jSONObject.put("errcode", i2);
            jSONObject.put("msg", str2);
        } catch (JSONException e2) {
            if (f45765a) {
                e2.printStackTrace();
            }
        }
        dVar.e(jSONObject);
        L(dVar);
    }

    public static void x(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65579, null, str, i2) == null) {
            q(0, str, i2, null, null, null, "0");
        }
    }

    public static void y(String str, int i2, NetworkStatRecord networkStatRecord) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65580, null, str, i2, networkStatRecord) == null) {
            z(str, i2, networkStatRecord, 0L, 0L);
        }
    }

    public static void z(String str, int i2, NetworkStatRecord networkStatRecord, long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65581, null, new Object[]{str, Integer.valueOf(i2), networkStatRecord, Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            H(0, str, i2, null, null, null, "0", j2, j3, networkStatRecord);
        }
    }
}
