package d.a.n0.a.h0.u;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.apps.core.turbo.PreloadState;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebView;
import d.a.n0.a.a1.e;
import d.a.n0.a.h0.o.i.a;
import d.a.n0.a.h0.p.a;
import d.a.n0.a.j2.c;
import d.a.n0.a.p.d.l1;
import d.a.n0.a.v2.o0;
import d.a.n0.a.v2.q0;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class g implements d.a.n0.a.g1.h {
    public static /* synthetic */ Interceptable $ic;
    public static boolean A;
    public static final boolean B;
    public static int C;
    public static final boolean v;
    public static volatile g w;
    public static int x;
    public static boolean y;
    public static PreloadState z;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public SwanCoreVersion f45259a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public ExtensionCore f45260b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.n0.a.h0.f.d.b f45261c;

    /* renamed from: d  reason: collision with root package name */
    public List<q> f45262d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.n0.a.h0.l.g.b<d.a.n0.a.h0.l.g.a> f45263e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.n0.a.h0.l.a f45264f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f45265g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.n0.a.p.e.b f45266h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f45267i;
    public boolean j;
    public boolean k;
    public final HashMap<String, d.a.n0.a.p.e.d> l;
    public LinkedList<d.a.n0.a.o0.d.a> m;
    public final Object n;
    public final String o;
    public String p;
    public q q;
    public l1 r;
    public d.a.n0.a.p.e.h s;
    public volatile boolean t;
    public boolean u;

    /* loaded from: classes7.dex */
    public static class a extends q {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: d.a.n0.a.h0.u.g$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class RunnableC0768a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public RunnableC0768a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
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
                    g.A0(false);
                }
            }
        }

        public a() {
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

        @Override // d.a.n0.a.h0.u.g.q
        public void b(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, gVar) == null) {
                boolean z = !TextUtils.isEmpty(d.a.n0.a.a2.d.g().getAppId());
                d.a.n0.a.e0.d.h("SwanAppCoreRuntime", "sReleaseCallback:isSwanAppRunning" + z);
                if (z) {
                    return;
                }
                d.a.n0.a.a2.d.g().z().M(15);
                q0.b0(new RunnableC0768a(this));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements d.a.n0.a.h0.l.g.d<d.a.n0.a.h0.l.g.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
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
        @Override // d.a.n0.a.h0.l.g.d
        /* renamed from: b */
        public void a(boolean z, d.a.n0.a.h0.l.g.a aVar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z, aVar) == null) && z) {
                d.a.n0.a.r1.h.p("startup").A("prefetch_env", "1");
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements d.a.n0.a.h0.l.g.j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f45268a;

        public c(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45268a = gVar;
        }

        @Override // d.a.n0.a.h0.l.g.j
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.a.n0.a.r1.h.p("preload").C(new UbcFlowEvent("na_pre_load_master_ok"));
                synchronized (this.f45268a.n) {
                    this.f45268a.f45265g = true;
                    this.f45268a.I();
                    this.f45268a.l0();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d extends d.a.n0.a.h0.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f45269a;

        public d(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45269a = gVar;
        }

        @Override // d.a.n0.a.h0.b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                d.a.n0.a.e0.d.h("SwanAppCoreRuntime", "prepareMaster finish. url: " + str);
                d.a.n0.a.r1.h.p("preload").C(new UbcFlowEvent("na_pre_load_master_ok"));
                synchronized (this.f45269a.n) {
                    this.f45269a.f45265g = true;
                    this.f45269a.I();
                    this.f45269a.l0();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e extends d.a.n0.a.h0.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f45270a;

        public e(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45270a = gVar;
        }

        @Override // d.a.n0.a.h0.b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                d.a.n0.a.e0.d.h("SwanAppCoreRuntime", "prepareSlave finish. url: " + str);
                d.a.n0.a.r1.h.p("preload").C(new UbcFlowEvent("na_pre_load_slave_ok"));
                this.f45270a.f45267i = true;
                this.f45270a.l0();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements d.a.n0.a.v2.e1.b<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f45271e;

        public f(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45271e = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                this.f45271e.G0(s.h(bool));
            }
        }
    }

    /* renamed from: d.a.n0.a.h0.u.g$g  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class RunnableC0769g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.a.v2.e1.b f45272e;

        public RunnableC0769g(g gVar, d.a.n0.a.v2.e1.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45272e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean a2 = d.a.n0.a.c1.a.l0().a();
                if (g.v) {
                    Log.i("SwanAppCoreRuntime", "checkRuntimeRetry: isLowDevice " + a2);
                }
                d.a.n0.a.v2.e1.b bVar = this.f45272e;
                if (bVar != null) {
                    bVar.onCallback(Boolean.FALSE);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public h(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
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
                d.a.n0.a.v2.j.i();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i extends q {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ g f45273e;

            public a(i iVar, g gVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {iVar, gVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f45273e = gVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f45273e.P0();
                }
            }
        }

        public i(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // d.a.n0.a.h0.u.g.q
        public void b(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, gVar) == null) {
                if (g.v) {
                    d.a.n0.q.d.b().e();
                    d.a.n0.a.z1.b.f.e f2 = d.a.n0.a.z1.b.f.e.f(g.K(), d.a.n0.a.h.aiapps_preloadCoreRuntime_end);
                    f2.l(1);
                    f2.F();
                    Log.d("SwanAppCoreRuntime", "PrepareStatusCallback onReady.");
                }
                q0.X(new a(this, gVar));
                if (g.v) {
                    Log.i("SwanAppCoreRuntime", "onReady: successfully.");
                }
                d.a.n0.a.v1.c.e.a.E().M(14);
            }
        }

        @NonNull
        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return "prepare " + super.toString();
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class j extends q {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public j(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // d.a.n0.a.h0.u.g.q
        public void b(g gVar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, gVar) == null) && g.v) {
                Log.i("SwanAppCoreRuntime", "onReady: retry successfully.");
            }
        }

        @NonNull
        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return HttpRetryStrategyDataParse.DOWNFLOW_RETRY_REQUEST_PARAM + super.toString();
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class k extends q {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.a.f1.e.b f45274e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e.g f45275f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ g f45276g;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ g f45277e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ k f45278f;

            public a(k kVar, g gVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {kVar, gVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f45278f = kVar;
                this.f45277e = gVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f45277e.j) {
                    return;
                }
                d.a.n0.a.r1.h.p("startup").C(new UbcFlowEvent("na_pre_load_ok"));
                d.a.n0.a.i2.a.d().i("na_pre_load_ok");
                d.a.n0.a.r1.h.h("preload", "startup");
                k kVar = this.f45278f;
                kVar.f45276g.j0(this.f45277e, kVar.f45274e, kVar.f45275f);
                d.a.n0.a.r1.h.j(this.f45278f.f45274e, false);
            }
        }

        public k(g gVar, d.a.n0.a.f1.e.b bVar, e.g gVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, bVar, gVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45276g = gVar;
            this.f45274e = bVar;
            this.f45275f = gVar2;
        }

        @Override // d.a.n0.a.h0.u.g.q
        public void b(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, gVar) == null) {
                q0.b0(new a(this, gVar));
            }
        }

        @NonNull
        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return "startFirstPage " + super.toString();
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class l implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.a.a2.e f45279e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ g f45280f;

        public l(g gVar, d.a.n0.a.a2.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45280f = gVar;
            this.f45279e = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f45280f.f45266h == null) {
                    d.a.n0.a.h0.u.b.c(11);
                    return;
                }
                if (a.C0762a.b()) {
                    z = true;
                } else {
                    String c2 = d.a.n0.a.c2.f.p0.c.c(d.a.n0.a.g1.f.V(), this.f45279e.N(), this.f45279e.F());
                    SwanAppConfigData F = this.f45279e.F();
                    String g2 = F != null ? F.g(c2) : null;
                    boolean equals = FlutterActivityLaunchConfigs.DEFAULT_DART_ENTRYPOINT.equals(g2);
                    int i2 = 0;
                    if (g2 == null) {
                        i2 = 12;
                    } else if (!equals) {
                        i2 = 13;
                    }
                    if (i2 != 0) {
                        d.a.n0.a.h0.u.b.c(i2);
                    }
                    z = equals;
                }
                if (z && this.f45279e.F() != null) {
                    d.a.n0.a.h0.p.b.c().b(g.B ? ((d.a.n0.a.h0.l.g.a) this.f45280f.f45263e.e(this.f45279e.L().f0())).i() : this.f45280f.f45264f, this.f45280f.f45266h, this.f45279e.N(), this.f45279e.F(), null, true);
                } else if (this.f45279e.F() == null) {
                    d.a.n0.a.h0.u.b.c(15);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class m implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public m(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
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
                HybridUbcFlow p = d.a.n0.a.r1.h.p("preload");
                d.a.n0.a.e0.d.h("SwanAppCoreRuntime", "getMemoryInfo scene=preload_start_mem");
                p.A("preload_start_mem", d.a.n0.a.e0.g.d.b().c(g.C));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class n implements d.a.n0.a.h0.f.d.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f45281a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ g f45282b;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ n f45283e;

            public a(n nVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {nVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f45283e = nVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (g.v) {
                        Log.d("SwanAppCoreRuntime", "prepareRuntime addBlinkInitListener do prepare. isReleased: " + this.f45283e.f45282b.j);
                    }
                    if (this.f45283e.f45282b.j) {
                        if (g.v) {
                            Log.d("SwanAppCoreRuntime", Log.getStackTraceString(new Exception("runtime object is release.")));
                            return;
                        }
                        return;
                    }
                    this.f45283e.f45282b.R0();
                    this.f45283e.f45282b.Q0();
                    if (this.f45283e.f45282b.f45259a == null) {
                        PreloadState unused = g.z = PreloadState.LOAD_FAILED;
                        this.f45283e.f45282b.Z();
                        return;
                    }
                    n nVar = this.f45283e;
                    nVar.f45282b.u0(nVar.f45281a);
                    this.f45283e.f45282b.z0();
                }
            }
        }

        public n(g gVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45282b = gVar;
            this.f45281a = z;
        }

        @Override // d.a.n0.a.h0.f.d.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (g.v) {
                    Log.d("SwanAppCoreRuntime", "prepareRuntime addBlinkInitListener blink loaded.");
                }
                d.a.n0.a.r1.h.p("preload").C(new UbcFlowEvent("na_pre_load_blink_init_ok"));
                q0.b0(new a(this));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class o implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public o(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
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
                HybridUbcFlow p = d.a.n0.a.r1.h.p("preload");
                d.a.n0.a.e0.d.h("SwanAppCoreRuntime", "getMemoryInfo scene=preload_end_mem");
                p.A("preload_end_mem", d.a.n0.a.e0.g.d.b().c(g.C));
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class p {
        public static /* synthetic */ Interceptable $ic = null;

        /* renamed from: a  reason: collision with root package name */
        public static int f45284a = -1;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1218740595, "Ld/a/n0/a/h0/u/g$p;")) == null) {
                return;
            }
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1218740595, "Ld/a/n0/a/h0/u/g$p;");
            }
        }

        public static int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
                d.a.n0.a.c1.a.Z().getSwitch("swan_core_runtime_high_end_timeout", 6000);
                if (g.v) {
                    Log.i("SwanAppCoreRuntime", "getHighDeviceTimeout: 6000");
                }
                return 6000;
            }
            return invokeV.intValue;
        }

        public static int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
                d.a.n0.a.c1.a.Z().getSwitch("swan_core_runtime_low_end_timeout", 8000);
                if (g.v) {
                    Log.i("SwanAppCoreRuntime", "getLowDeviceTimeout: timeoutMs 8000");
                }
                return 8000;
            }
            return invokeV.intValue;
        }

        public static int c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                if (f45284a < 0) {
                    d.a.n0.a.c1.a.Z().getSwitch("swan_core_runtime_delayed_retry_switch", 0);
                    f45284a = 0;
                }
                return f45284a;
            }
            return invokeV.intValue;
        }

        public static int d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
                d.a.n0.a.c1.a.Z().getSwitch("swan_core_runtime_retry_process_timeout", 8000);
                if (g.v) {
                    Log.i("SwanAppCoreRuntime", "getRetryProcessTimeout: 8000");
                }
                return 8000;
            }
            return invokeV.intValue;
        }

        public static boolean e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) {
                boolean z = c() > 0;
                d.a.n0.a.e0.d.h("SwanAppCoreRuntime", "isEnable: " + z);
                return z;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public static abstract class q implements d.a.n0.a.v2.e1.b<g> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public q() {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, gVar) == null) {
                b(gVar);
            }
        }

        public abstract void b(g gVar);
    }

    /* loaded from: classes7.dex */
    public static class r extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public r(Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? hasMessages(1002) : invokeV.booleanValue;
        }

        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? hasMessages(1001) : invokeV.booleanValue;
        }

        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                removeCallbacksAndMessages(null);
                removeCallbacks(s.f45290f);
                removeCallbacks(s.f45291g);
            }
        }

        public void d(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
                sendEmptyMessageDelayed(1001, i2);
            }
        }

        @Override // android.os.Handler
        public void dispatchMessage(@NonNull Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, message) == null) {
                int i2 = message.what;
                if (i2 == 1001) {
                    s.f45290f.run();
                } else if (i2 == 1002) {
                    s.f45291g.run();
                }
            }
        }

        public void e(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
                sendEmptyMessageDelayed(1002, i2);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class s {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final int f45285a;

        /* renamed from: b  reason: collision with root package name */
        public static final int f45286b;

        /* renamed from: c  reason: collision with root package name */
        public static int f45287c;

        /* renamed from: d  reason: collision with root package name */
        public static int f45288d;

        /* renamed from: e  reason: collision with root package name */
        public static r f45289e;

        /* renamed from: f  reason: collision with root package name */
        public static final Runnable f45290f;

        /* renamed from: g  reason: collision with root package name */
        public static final Runnable f45291g;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes7.dex */
        public static class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a() {
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
                    if (!g.w.c0()) {
                        boolean z = true;
                        if (s.f45288d < 1) {
                            if (!((s.f45289e == null || !s.f45289e.a()) ? false : false)) {
                                if (s.f45289e == null) {
                                    r unused = s.f45289e = new r(d.a.n0.a.a2.d.g().getMainLooper());
                                }
                                s.f45289e.e(p.d());
                            }
                            d.a.n0.a.e0.d.h("SwanAppCoreRuntime", "start retry runtime.");
                            g.C0();
                            d.a.n0.a.q2.a aVar = new d.a.n0.a.q2.a();
                            aVar.j(5L);
                            aVar.h(49L);
                            aVar.e("start retry");
                            s.j(aVar);
                            return;
                        }
                        d.a.n0.a.e0.d.h("SwanAppCoreRuntime", "checkAndRetry: over max retry count, return.");
                        return;
                    }
                    d.a.n0.a.e0.d.h("SwanAppCoreRuntime", "checkAndRetry: runtimeReady is true, return.");
                }
            }
        }

        /* loaded from: classes7.dex */
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
                    if (!g.w.c0()) {
                        if (s.f45288d >= 1) {
                            d.a.n0.a.e0.d.h("SwanAppCoreRuntime", "isMasterReady:" + g.w.b0() + ",isSlaveReady:" + g.w.d0());
                            d.a.n0.a.q2.a aVar = new d.a.n0.a.q2.a();
                            aVar.j(5L);
                            aVar.h(49L);
                            aVar.e("retry timeout");
                            s.j(aVar);
                            if (d.a.n0.a.g1.g.a().b()) {
                                d.a.n0.a.f1.d.a.d(g.K(), aVar, 0, d.a.n0.a.a2.d.g().getAppId());
                                d.a.n0.a.j2.e.m(d.a.n0.a.a2.d.g().r().L(), 0, aVar);
                                d.a.n0.a.c1.a.g0().c(false);
                            }
                            d.a.n0.a.v2.f.j(d.a.n0.a.a2.d.g().x());
                            return;
                        }
                        return;
                    }
                    d.a.n0.a.e0.d.h("SwanAppCoreRuntime", "Retry: successfully.");
                }
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1218740688, "Ld/a/n0/a/h0/u/g$s;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1218740688, "Ld/a/n0/a/h0/u/g$s;");
                    return;
                }
            }
            f45285a = p.b();
            f45286b = p.a();
            f45287c = 0;
            f45288d = 0;
            f45290f = new a();
            f45291g = new b();
        }

        public static CopyOnWriteArrayList<q> g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? new CopyOnWriteArrayList<>(g.w.f45262d) : (CopyOnWriteArrayList) invokeV.objValue;
        }

        public static int h(Boolean bool) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, bool)) == null) ? bool.booleanValue() ? f45285a : f45286b : invokeL.intValue;
        }

        public static void i() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65545, null) == null) {
                f45288d++;
                d.a.n0.a.e0.d.h("SwanAppCoreRuntime", "incrementRetryTimes: retry times " + f45288d);
            }
        }

        public static void j(d.a.n0.a.q2.a aVar) {
            d.a.n0.a.a2.e r;
            int l;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(65546, null, aVar) == null) && (r = d.a.n0.a.a2.d.g().r()) != null && (l = r.l()) == 0) {
                d.a.n0.a.j2.p.d dVar = new d.a.n0.a.j2.p.d();
                dVar.p(aVar);
                dVar.r(r.N());
                dVar.q(d.a.n0.a.j2.k.m(l));
                dVar.m(d.a.n0.a.a2.e.V());
                d.a.n0.a.j2.k.L(dVar);
            }
        }

        public static void k() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65547, null) == null) {
                f45288d = f45287c;
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class t {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static boolean f45292a;

        /* renamed from: b  reason: collision with root package name */
        public static boolean f45293b;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1218740719, "Ld/a/n0/a/h0/u/g$t;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1218740719, "Ld/a/n0/a/h0/u/g$t;");
                    return;
                }
            }
            boolean A = d.a.n0.a.c1.a.Z().A();
            f45292a = A;
            f45293b = A;
        }

        public static String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getString("aiapps_v8_master_switch", "AB") : (String) invokeV.objValue;
        }

        public static String b(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) ? i2 == 1 ? "V8" : i2 == 0 ? WebView.LOGTAG : "AB" : (String) invokeI.objValue;
        }

        public static boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                if (g.v) {
                    String a2 = a();
                    char c2 = 65535;
                    int hashCode = a2.hashCode();
                    if (hashCode != -1406842887) {
                        if (hashCode != 2081) {
                            if (hashCode == 2722 && a2.equals("V8")) {
                                c2 = 0;
                            }
                        } else if (a2.equals("AB")) {
                            c2 = 2;
                        }
                    } else if (a2.equals(WebView.LOGTAG)) {
                        c2 = 1;
                    }
                    if (c2 == 0) {
                        return true;
                    }
                    if (c2 == 1) {
                        return false;
                    }
                }
                return f45293b;
            }
            return invokeV.booleanValue;
        }

        public static boolean d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
                String a2 = a();
                if (a2.equals("V8")) {
                    return true;
                }
                if (a2.equals("AB")) {
                    return d.a.n0.a.c1.a.Z().A();
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public static void e(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str) == null) {
                PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).edit().putString("aiapps_v8_master_switch", str).apply();
            }
        }

        public static void f() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null) == null) {
                f45293b = f45292a;
            }
        }

        public static void g(Intent intent) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(65543, null, intent) == null) && intent != null && intent.hasExtra("bundle_key_v8_ab")) {
                f45292a = intent.getBooleanExtra("bundle_key_v8_ab", f45292a);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(318586303, "Ld/a/n0/a/h0/u/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(318586303, "Ld/a/n0/a/h0/u/g;");
                return;
            }
        }
        v = d.a.n0.a.k.f45831a;
        x = 10150;
        y = false;
        z = PreloadState.UNKNOWN;
        A = false;
        B = d.a.n0.a.h0.o.e.a.f();
        C = -1;
    }

    public g() {
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
        this.f45262d = new CopyOnWriteArrayList();
        this.m = new LinkedList<>();
        this.n = new Object();
        this.o = UUID.randomUUID().toString();
        this.t = false;
        this.u = false;
        d.a.n0.a.g1.i.e(this);
        this.l = new HashMap<>();
        this.r = new d.a.n0.a.p.e.j.b();
        this.s = d.a.n0.a.p.e.j.c.a().b().a();
        if (B) {
            this.f45263e = new d.a.n0.a.h0.l.g.m();
        }
    }

    public static synchronized void A0(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65539, null, z2) == null) {
            synchronized (g.class) {
                d.a.n0.a.e0.d.h("SwanAppCoreRuntime", "release");
                B0(z2, false);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v2, resolved type: d.a.n0.a.h0.u.g */
    /* JADX WARN: Multi-variable type inference failed */
    public static synchronized void B0(boolean z2, boolean z3) {
        CopyOnWriteArrayList copyOnWriteArrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, null, new Object[]{Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            synchronized (g.class) {
                if (v) {
                    Log.d("SwanAppCoreRuntime", "release");
                }
                if (w == null) {
                    return;
                }
                z = PreloadState.UNKNOWN;
                w.j = true;
                w.q = null;
                y = false;
                if (z3) {
                    s.i();
                    copyOnWriteArrayList = s.g();
                } else {
                    copyOnWriteArrayList = null;
                }
                if (w.f45261c != null) {
                    w.s.a(w.f45261c);
                }
                d.a.n0.a.u.e.p.g.e();
                d.a.n0.a.m2.c.a.c();
                F0();
                d.a.n0.a.g1.i.f(w);
                w = null;
                d.a.n0.a.h0.p.b.c().d();
                A = z2;
                N().q0(null, copyOnWriteArrayList);
            }
        }
    }

    public static synchronized void C0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, null) == null) {
            synchronized (g.class) {
                d.a.n0.a.e0.d.h("SwanAppCoreRuntime", "releaseAndRetry");
                B0(false, true);
            }
        }
    }

    public static synchronized void D0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, null) == null) {
            synchronized (g.class) {
                d.a.n0.a.e0.d.h("SwanAppCoreRuntime", "releaseForCoreUpdate");
                if (v) {
                    Log.d("SwanAppCoreRuntime", "releaseForCoreUpdate:ReleaseRuntimeWaitMaster:true.");
                }
                if (w != null && !w.b0()) {
                    if (w.q == null) {
                        w.q = new a();
                    }
                    w.v0(w.q);
                    return;
                }
                d.a.n0.a.a2.d.g().z().M(15);
                A0(false);
            }
        }
    }

    public static void E0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, null) == null) {
            if (B) {
                if (w.f45263e != null) {
                    w.f45263e.reset();
                }
            } else if (w.f45264f != null) {
                if (w.f45264f instanceof d.a.n0.a.h0.l.e) {
                    w.f45264f.destroy();
                }
                w.f45264f = null;
            }
        }
    }

    public static void F0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, null) == null) {
            if (w.l != null) {
                for (d.a.n0.a.p.e.d dVar : ((HashMap) w.l.clone()).values()) {
                    if (dVar != null) {
                        dVar.destroy();
                    }
                }
            }
            E0();
            if (w.f45266h != null) {
                w.f45266h = null;
            }
        }
    }

    public static Context K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) ? AppRuntime.getAppContext() : (Context) invokeV.objValue;
    }

    public static g N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) {
            if (w == null) {
                synchronized (g.class) {
                    if (w == null) {
                        w = new g();
                    }
                }
            }
            return w;
        }
        return (g) invokeV.objValue;
    }

    public static int r0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65564, null)) == null) ? s0().statsCode(A) : invokeV.intValue;
    }

    public static PreloadState s0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65566, null)) == null) ? z : (PreloadState) invokeV.objValue;
    }

    public final String E(String str, boolean z2) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048576, this, str, z2)) == null) {
            String str2 = z2 ? "slave" : "master";
            if (!TextUtils.isEmpty(str)) {
                d.a.n0.a.h0.a.b(str, "<title>", "        <script type=\"text/javascript\" src=\"file:///sdcard/socket.io.js\"></script>\n        <script type=\"text/javascript\" src=\"file:///sdcard/" + str2 + "_socket.js\"></script>");
            }
            return str;
        }
        return (String) invokeLZ.objValue;
    }

    public final void F() {
        d.a.n0.a.h0.l.g.b<d.a.n0.a.h0.l.g.a> bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (bVar = this.f45263e) == null || z == PreloadState.LOADED) {
            return;
        }
        bVar.b(new b(this));
    }

    public final boolean G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (d.a.n0.a.e0.f.e.e.d() || d.a.n0.a.c1.a.n().K() || d.a.n0.a.n0.k.c.f46277d.w() || !i0()) {
                return false;
            }
            return t.c() && new File(R()).exists();
        }
        return invokeV.booleanValue;
    }

    public final void G0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            d.a.n0.a.e0.d.h("SwanAppCoreRuntime", "resetAndPostRunnable");
            if (s.f45289e == null) {
                r unused = s.f45289e = new r(d.a.n0.a.a2.d.g().getMainLooper());
            }
            s.f45289e.c();
            s.f45289e.d(i2);
        }
    }

    public void H(boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048580, this, z2) == null) && p.e()) {
            if (!d.a.n0.a.a2.d.g().r().m0()) {
                boolean z3 = s.f45289e != null && s.f45289e.b();
                if (!z2 && z3) {
                    if (v) {
                        Log.i("SwanAppCoreRuntime", "checkRuntimeRetry: isReuse " + z2 + ", return.");
                        Log.i("SwanAppCoreRuntime", "checkRuntimeRetry: isRunning " + z3 + ", return.");
                    }
                } else if (c0()) {
                    if (v) {
                        Log.i("SwanAppCoreRuntime", "checkRuntimeRetry: runtime ready, return.");
                    }
                } else {
                    L(new f(this));
                }
            } else if (v) {
                Log.i("SwanAppCoreRuntime", "checkRuntimeRetry: is game frame, return.");
            }
        }
    }

    public void H0(d.a.n0.a.o0.d.a aVar) {
        d.a.n0.a.h0.f.a g2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) {
            if (aVar == null) {
                if (v) {
                    throw new IllegalArgumentException("message must be non-null.");
                }
                return;
            }
            synchronized (this.n) {
                if (!this.f45265g) {
                    if (v) {
                        Log.e("SwanAppCoreRuntime", Log.getStackTraceString(new Exception("message:" + aVar.f46533a)));
                    }
                    this.m.add(aVar);
                    return;
                }
                if (B) {
                    if (!this.f45263e.g()) {
                        this.f45263e.d(aVar);
                        return;
                    } else if (this.f45263e.a() == 0) {
                        return;
                    } else {
                        g2 = ((d.a.n0.a.h0.l.g.a) this.f45263e.a()).i().g();
                    }
                } else {
                    d.a.n0.a.h0.l.a aVar2 = this.f45264f;
                    if (aVar2 == null) {
                        return;
                    }
                    g2 = aVar2.g();
                }
                if (v) {
                    Log.d("SwanAppCoreRuntime", "master dispatch msg:" + aVar.f46533a);
                }
                d.a.n0.a.o0.a.a(g2, aVar);
            }
        }
    }

    public final void I() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.m.isEmpty()) {
            return;
        }
        Iterator<d.a.n0.a.o0.d.a> it = this.m.iterator();
        while (it.hasNext()) {
            d.a.n0.a.o0.d.a next = it.next();
            if (v) {
                Log.d("SwanAppCoreRuntime", "dispatchPendingEvents event: " + next.f46533a);
            }
            H0(next);
        }
        this.m.clear();
    }

    public void I0(String str, d.a.n0.a.o0.d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, str, aVar) == null) {
            if (d.a.n0.a.h0.l.g.e.a(str)) {
                H0(aVar);
            } else if (d.a.n0.a.h0.k.a.a(str)) {
                d.a.n0.a.o0.a.a(d.a.n0.a.e0.f.d.f.k().l(), aVar);
            } else {
                d.a.n0.a.p.e.d dVar = this.l.get(str);
                if (dVar == null) {
                    if (v) {
                        Log.e("SwanAppCoreRuntime", "can't find view manager. webviewId: " + str + " message: " + aVar);
                        return;
                    }
                    return;
                }
                d.a.n0.a.o0.a.a(dVar.u(), aVar);
            }
        }
    }

    public final void J(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            Bundle bundle = new Bundle();
            bundle.putInt("KEY_PRELOAD_STATE", z.statsCode(A));
            d.a.n0.a.a2.d.g().w(str, bundle);
        }
    }

    public void J0(@NonNull d.a.n0.a.a2.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, eVar) == null) {
            q0.b0(new l(this, eVar));
        }
    }

    public void K0(ExtensionCore extensionCore) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, extensionCore) == null) {
            if (extensionCore != null && extensionCore.isAvailable()) {
                if (v) {
                    Log.d("SwanAppCoreRuntime", "setExtensionCore before. extension core: " + this.f45260b);
                }
                this.f45260b = extensionCore;
                if (v) {
                    Log.d("SwanAppCoreRuntime", "setExtensionCore after. extension core: " + this.f45260b);
                }
            } else if (v) {
                StringBuilder sb = new StringBuilder();
                sb.append("setExtensionCore extensionCore is invalid: ");
                Object obj = extensionCore;
                if (extensionCore == null) {
                    obj = " null";
                }
                sb.append(obj);
                Log.w("SwanAppCoreRuntime", sb.toString());
            }
        }
    }

    public final void L(d.a.n0.a.v2.e1.b<Boolean> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bVar) == null) {
            d.a.n0.a.v2.q.j(new RunnableC0769g(this, bVar), "SWAN_DEVICE_PERFORMANCE_CHECK");
        }
    }

    public void L0(SwanCoreVersion swanCoreVersion) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, swanCoreVersion) == null) {
            if (swanCoreVersion != null && swanCoreVersion.isAvailable()) {
                if (v) {
                    Log.d("SwanAppCoreRuntime", "setSwanCoreVersion before. swan core: " + this.f45259a);
                }
                this.f45259a = swanCoreVersion;
                if (v) {
                    Log.d("SwanAppCoreRuntime", "setSwanCoreVersion after. swan core: " + this.f45259a);
                }
            } else if (v) {
                Log.e("SwanAppCoreRuntime", Log.getStackTraceString(new Exception("setSwanCoreVersion failed.")));
                Log.e("SwanAppCoreRuntime", "setSwanCoreVersion swanCoreVersion is invalid: " + swanCoreVersion);
            }
        }
    }

    @Nullable
    public ExtensionCore M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f45260b : (ExtensionCore) invokeV.objValue;
    }

    public void M0(d.a.n0.a.f1.e.b bVar, e.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, bVar, gVar) == null) {
            if (v) {
                Log.d("SwanAppCoreRuntime", "startFirstPage cur swanCoreVersion: " + this.f45259a);
                Log.d("SwanAppCoreRuntime", "startFirstPage launchInfo coreVersion: " + bVar.i0());
            }
            O0(bVar);
            N0(bVar);
            d.a.n0.a.r1.h.o().C(new UbcFlowEvent("na_pre_load_check"));
            d.a.n0.a.i2.a.d().i("na_pre_load_check");
            v0(new k(this, bVar, gVar));
        }
    }

    public void N0(d.a.n0.a.f1.e.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, bVar) == null) {
            ExtensionCore extensionCore = this.f45260b;
            if (extensionCore != null) {
                bVar.B0(extensionCore);
            } else {
                this.f45260b = bVar.O();
            }
        }
    }

    @NonNull
    public HashMap<String, d.a.n0.a.p.e.d> O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.l : (HashMap) invokeV.objValue;
    }

    public void O0(d.a.n0.a.f1.e.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, bVar) == null) {
            SwanCoreVersion swanCoreVersion = this.f45259a;
            if (swanCoreVersion != null) {
                bVar.X0(swanCoreVersion);
            } else {
                this.f45259a = bVar.i0();
            }
        }
    }

    public d.a.n0.a.h0.l.a P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (B) {
                if (this.f45263e.g()) {
                    return ((d.a.n0.a.h0.l.g.a) this.f45263e.a()).i();
                }
                return null;
            }
            return this.f45264f;
        }
        return (d.a.n0.a.h0.l.a) invokeV.objValue;
    }

    public final void P0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            if (this.t) {
                if (v) {
                    Log.i("SwanAppCoreRuntime", "Cancel preload additional slave, already tried");
                    return;
                }
                return;
            }
            boolean z2 = true;
            this.t = true;
            d.a.n0.a.a2.d g2 = d.a.n0.a.a2.d.g();
            z2 = (g2 == null || !g2.C()) ? false : false;
            boolean y2 = d.a.n0.a.c1.a.Z().y();
            if (!z2 && y2) {
                if (v) {
                    Log.i("SwanAppCoreRuntime", "Start preload additional slave manager");
                }
                d.a.n0.a.h0.t.a.l(K());
            } else if (v) {
                Log.i("SwanAppCoreRuntime", "Can't preload additional slave manager, isOccupied: " + z2 + ", ab: " + y2);
            }
        }
    }

    public String Q() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            R0();
            if (h0()) {
                str = R();
            } else {
                str = this.f45259a.swanCorePath + File.separator + "master/master.html";
            }
            if (d.a.n0.a.h0.a.d()) {
                E(str, false);
            } else if (d.a.n0.a.e0.f.e.e.d()) {
                d.a.n0.a.e0.f.e.d.k();
                d.a.n0.a.e0.f.e.d.g().h("loadmaster");
                return d.a.n0.a.e0.f.e.e.a();
            } else {
                d.a.n0.a.h0.a.g(str);
            }
            return o0.w(str);
        }
        return (String) invokeV.objValue;
    }

    public final void Q0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            ExtensionCore extensionCore = this.f45260b;
            if (extensionCore == null || !extensionCore.isAvailable()) {
                d.a.n0.a.e0.d.h("SwanAppCoreRuntime", "updateExtensionCoreIfNeeded: ExtensionCore is invalid");
                K0(d.a.n0.a.p0.b.c(0));
            }
        }
    }

    public String R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            if (TextUtils.isEmpty(U())) {
                return "";
            }
            return U() + "runtime/index.js";
        }
        return (String) invokeV.objValue;
    }

    public final void R0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            SwanCoreVersion swanCoreVersion = this.f45259a;
            if (swanCoreVersion == null || !swanCoreVersion.isAvailable()) {
                d.a.n0.a.e0.d.h("SwanAppCoreRuntime", Log.getStackTraceString(new Exception("mSwanCoreVersion is invalid:" + this.f45259a)));
                L0(d.a.n0.a.m2.b.g(0));
            }
        }
    }

    public String S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.o : (String) invokeV.objValue;
    }

    public void S0(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z2) == null) {
            this.k = z2;
        }
    }

    @Nullable
    public String T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            R0();
            if (this.f45259a == null) {
                return null;
            }
            String str = this.f45259a.swanCorePath + File.separator + "slaves/slaves.html";
            if (d.a.n0.a.h0.a.d()) {
                E(str, true);
            } else if (d.a.n0.a.e0.f.e.e.d()) {
                return d.a.n0.a.e0.f.e.e.b();
            } else {
                d.a.n0.a.h0.a.g(str);
            }
            return o0.w(str);
        }
        return (String) invokeV.objValue;
    }

    public String U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            if (this.f45259a == null) {
                return "";
            }
            return this.f45259a.swanCorePath + File.separator;
        }
        return (String) invokeV.objValue;
    }

    public SwanCoreVersion V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.f45259a : (SwanCoreVersion) invokeV.objValue;
    }

    public d.a.n0.a.p.e.d W(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, str)) == null) {
            if (this.l.isEmpty() || TextUtils.isEmpty(str)) {
                return null;
            }
            return this.l.get(str);
        }
        return (d.a.n0.a.p.e.d) invokeL.objValue;
    }

    public l1 X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.r : (l1) invokeV.objValue;
    }

    @Nullable
    public String Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            a0();
            return this.p;
        }
        return (String) invokeV.objValue;
    }

    public final void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            synchronized (this.n) {
                this.f45265g = false;
                if (B) {
                    this.f45263e.reset();
                } else {
                    this.f45264f = null;
                }
            }
            this.f45267i = false;
            this.f45266h = null;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("swanjs version", d.a.n0.a.m2.f.a.e(0));
                jSONObject.put("system model", Build.MODEL);
                jSONObject.put("is V8", h0());
                jSONObject.put("in main", ProcessUtils.isMainProcess());
                SwanCoreVersion g2 = d.a.n0.a.m2.b.g(0);
                jSONObject.put("swan app core", g2 == null ? StringUtil.NULL_STRING : Long.valueOf(g2.swanCoreVersionCode));
                SwanCoreVersion g3 = d.a.n0.a.m2.b.g(1);
                jSONObject.put("swan game core", g3 == null ? StringUtil.NULL_STRING : Long.valueOf(g3.swanCoreVersionCode));
            } catch (JSONException e2) {
                if (v) {
                    e2.printStackTrace();
                }
            }
            c.b bVar = new c.b(10001);
            bVar.h(d.a.n0.a.a2.e.i() == null ? "null appKey" : d.a.n0.a.a2.e.i().D());
            bVar.i(jSONObject.toString());
            bVar.m();
        }
    }

    @Override // d.a.n0.a.g1.h
    public void a(d.a.n0.a.p.e.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, dVar) == null) {
        }
    }

    public final void a0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048610, this) == null) && TextUtils.isEmpty(this.p)) {
            d.a.n0.a.p.e.b bVar = this.f45266h;
            this.p = bVar != null ? bVar.a() : "";
            d.a.n0.a.e0.d.h("SwanAppCoreRuntime", "initWebViewUa ua: " + this.p);
        }
    }

    @Override // d.a.n0.a.g1.h
    public void b(d.a.n0.a.p.e.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, dVar) == null) {
            String b2 = dVar.b();
            this.l.remove(b2);
            if (dVar instanceof d.a.n0.a.p.e.b) {
                HashMap hashMap = new HashMap();
                hashMap.put("lcType", "onUnload");
                hashMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, b2);
                H0(new d.a.n0.a.o0.d.c(hashMap));
                d.a.n0.a.e0.d.g("SwanApp", "onUnload");
            }
            d.a.n0.a.z1.b.d.a.a();
        }
    }

    public boolean b0() {
        InterceptResult invokeV;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            synchronized (this.n) {
                z2 = this.f45265g;
            }
            return z2;
        }
        return invokeV.booleanValue;
    }

    @Override // d.a.n0.a.g1.h
    public void c(d.a.n0.a.p.e.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, dVar) == null) {
        }
    }

    public boolean c0() {
        InterceptResult invokeV;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            synchronized (this.n) {
                z2 = this.f45265g && this.f45267i;
            }
            return z2;
        }
        return invokeV.booleanValue;
    }

    @Override // d.a.n0.a.g1.h
    public void d(d.a.n0.a.p.e.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, dVar) == null) {
            this.l.put(dVar.b(), dVar);
        }
    }

    public boolean d0() {
        InterceptResult invokeV;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            synchronized (this.n) {
                z2 = this.f45267i;
            }
            return z2;
        }
        return invokeV.booleanValue;
    }

    public final boolean e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            long currentTimeMillis = v ? System.currentTimeMillis() : 0L;
            SwanCoreVersion swanCoreVersion = this.f45259a;
            boolean z2 = swanCoreVersion != null && swanCoreVersion.isAvailable();
            ExtensionCore extensionCore = this.f45260b;
            if (extensionCore != null && extensionCore.extensionCoreVersionCode != 0) {
                z2 &= extensionCore.isAvailable();
            }
            if (v) {
                long currentTimeMillis2 = System.currentTimeMillis();
                Log.d("SwanAppCoreRuntime", "isSwanAvailable cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms");
            }
            return z2;
        }
        return invokeV.booleanValue;
    }

    public boolean f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) ? this.k : invokeV.booleanValue;
    }

    public boolean g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) ? this.u : invokeV.booleanValue;
    }

    public boolean h0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            if (B) {
                return this.f45263e.i();
            }
            return this.f45264f instanceof d.a.n0.a.h0.l.e;
        }
        return invokeV.booleanValue;
    }

    public boolean i0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            if (d.a.n0.a.c1.a.n0().d() || d.a.n0.a.h2.d.a() == null) {
                return true;
            }
            boolean exists = new File(d.a.n0.a.h2.d.a()).exists();
            if (v) {
                Log.d("V8LoadChecker", "is v8 load success: " + exists);
            }
            return exists;
        }
        return invokeV.booleanValue;
    }

    public final void j0(g gVar, d.a.n0.a.f1.e.b bVar, e.g gVar2) {
        d.a.n0.a.h0.l.a aVar;
        d.a.n0.a.p.e.b bVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048622, this, gVar, bVar, gVar2) == null) {
            if (B) {
                d.a.n0.a.h0.l.g.b<d.a.n0.a.h0.l.g.a> bVar3 = gVar.f45263e;
                aVar = bVar3.h() ? ((d.a.n0.a.h0.l.g.a) bVar3.e(bVar.f0())).i() : null;
            } else {
                aVar = gVar.f45264f;
            }
            if (aVar != null && (bVar2 = gVar.f45266h) != null) {
                d.a.n0.a.c2.f.p0.c.e(aVar, bVar2, bVar, gVar2);
                gVar.f45266h = null;
            } else if (v) {
                StringBuilder sb = new StringBuilder();
                sb.append("startFirstPage mMasterManager ");
                sb.append(gVar.f45264f != null);
                sb.append(" startFirstPage mSlaveManager ");
                sb.append(gVar.f45266h != null);
                Log.e("SwanAppCoreRuntime", sb.toString());
            }
        }
    }

    public final void k0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048623, this) == null) || this.f45262d.isEmpty()) {
            return;
        }
        F();
        z = PreloadState.LOADED;
        s.k();
        J("event_preload_finish");
        d.a.n0.a.r1.h.p("preload").C(new UbcFlowEvent("na_pre_load_end"));
        d.a.n0.a.h0.l.g.n.a.i().q();
        for (q qVar : this.f45262d) {
            if (qVar != null) {
                if (v) {
                    Log.i("SwanAppCoreRuntime", "onReady result: " + qVar.toString());
                }
                qVar.onCallback(this);
            }
        }
        this.f45262d.clear();
    }

    public final void l0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048624, this) == null) && !this.f45262d.isEmpty() && c0()) {
            k0();
            if (d.a.n0.a.a2.d.g().r().c0()) {
                return;
            }
            d.a.n0.a.v2.q.j(new o(this), "SwanMemory");
        }
    }

    public void m0(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048625, this, z2) == null) {
            boolean f2 = B ? this.f45263e.f() : this.f45264f != null;
            if (z2 && !this.f45265g && f2) {
                if (v) {
                    Log.d("SwanAppCoreRuntime", "onJSLoaded -- master");
                }
                d.a.n0.a.r1.h.p("preload").C(new UbcFlowEvent("na_pre_load_master_js_ok"));
                synchronized (this.n) {
                    this.f45265g = true;
                    I();
                    l0();
                }
            } else if (z2 || this.f45266h == null || this.f45267i) {
            } else {
                if (v) {
                    Log.d("SwanAppCoreRuntime", "onJSLoaded -- slave");
                }
                d.a.n0.a.r1.h.p("preload").C(new UbcFlowEvent("na_pre_load_slave_js_ok"));
                this.f45267i = true;
                l0();
            }
        }
    }

    public void n0(PrefetchEvent prefetchEvent, PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048626, this, prefetchEvent, pMSAppInfo) == null) && B) {
            if (pMSAppInfo != null && TextUtils.equals(prefetchEvent.appId, pMSAppInfo.appId)) {
                if (c0() && e0()) {
                    d.a.n0.a.p.e.b bVar = this.f45266h;
                    if (bVar != null) {
                        prefetchEvent.isT7Available = bVar.L();
                    } else {
                        prefetchEvent.isT7Available = f0();
                    }
                    PrefetchEvent.c createMessage = PrefetchEvent.createMessage(prefetchEvent, pMSAppInfo);
                    String str = prefetchEvent.pageUrl;
                    Map<String, String> h2 = createMessage.h();
                    String str2 = h2 != null ? h2.get("pageRoutePath") : null;
                    if (!TextUtils.isEmpty(str2)) {
                        str = str2;
                    }
                    if (!d.a.n0.a.a1.e.C(prefetchEvent.appPath, str)) {
                        if (v) {
                            Log.w("SwanAppCoreRuntime", "page path - " + str + " not exit");
                            return;
                        }
                        return;
                    }
                    if (createMessage.i()) {
                        d.a.n0.a.e0.c.d();
                        d.a.n0.a.e0.d.l(PrefetchEvent.MODULE, "start prefetch");
                    }
                    this.f45263e.c(createMessage, pMSAppInfo);
                    o0(prefetchEvent);
                    if (v) {
                        String str3 = this.f45259a.swanCoreVersionName;
                        Log.i("SwanAppCoreRuntime", "swan-core version - " + str3);
                        Log.i("SwanAppCoreRuntime", "swan-core support preload ,fire a preload event");
                    }
                }
            } else if (v) {
                Log.w("SwanAppCoreRuntime", "prefetch appId not equals current app info's appId");
            }
        }
    }

    public final void o0(PrefetchEvent prefetchEvent) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048627, this, prefetchEvent) == null) && d.a.n0.a.h0.o.e.a.l()) {
            d.a.n0.a.p.e.b bVar = this.f45266h;
            if (bVar != null && d0()) {
                d.a.n0.a.e0.d.l(PrefetchEvent.MODULE, "start prefetch slave");
                long j2 = 0;
                if (v) {
                    j2 = System.currentTimeMillis();
                    Log.d("SwanAppCoreRuntime", "prefetch slave start");
                }
                d.a.n0.a.a2.e r2 = d.a.n0.a.a2.d.g().r();
                if (r2 == null) {
                    return;
                }
                a.C0761a b2 = d.a.n0.a.h0.o.i.a.a(bVar, prefetchEvent, r2).b();
                I0(bVar.b(), b2);
                if (v) {
                    Log.d("SwanAppCoreRuntime", "prefetch slave end");
                    long currentTimeMillis = System.currentTimeMillis();
                    Log.d("SwanAppCoreRuntime", "prefetch slave cost - " + (currentTimeMillis - j2) + "ms");
                }
                d.a.n0.a.e0.d.l(PrefetchEvent.MODULE, "prefetch slave finish:" + b2.toString());
            } else if (v) {
                Log.d("SwanAppCoreRuntime", "slave is not ready can not prefetch");
            }
        }
    }

    public void p0(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048628, this, intent) == null) {
            q0(intent, null);
        }
    }

    public final void q0(Intent intent, CopyOnWriteArrayList<q> copyOnWriteArrayList) {
        SwanCoreVersion swanCoreVersion;
        ExtensionCore extensionCore;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048629, this, intent, copyOnWriteArrayList) == null) {
            d.a.n0.a.r1.k.g.a.c().f();
            d.a.n0.a.r1.k.i.b.e().g();
            if (c0()) {
                d.a.n0.a.e0.d.h("SwanAppCoreRuntime", "preloadCoreRuntime runtime is ready.");
                return;
            }
            boolean z2 = true;
            y = true;
            d.a.n0.a.e0.d.h("SwanAppCoreRuntime", "preloadCoreRuntime start.");
            J("event_preload_start");
            if (intent == null) {
                swanCoreVersion = d.a.n0.a.m2.b.g(0);
                extensionCore = d.a.n0.a.p0.b.c(0);
            } else {
                intent.setExtrasClassLoader(SwanCoreVersion.class.getClassLoader());
                d.a.n0.a.c1.a.f().g(intent.getIntExtra("bundle_key_preload_switch", x));
                C = intent.getIntExtra("bundle_key_main_pid", C);
                swanCoreVersion = (SwanCoreVersion) intent.getParcelableExtra("bundle_key_swan_core");
                extensionCore = (ExtensionCore) intent.getParcelableExtra("bundle_key_extension_core");
            }
            if (swanCoreVersion == null) {
                J("event_preload_error");
                d.a.n0.a.e0.d.i("SwanAppCoreRuntime", "preloadCoreRuntime", new Exception("version is invalid"));
                return;
            }
            L0(swanCoreVersion);
            if (extensionCore == null) {
                d.a.n0.a.e0.d.h("SwanAppCoreRuntime", "preloadCoreRuntime with null extensionCore");
            }
            K0(extensionCore);
            t.f();
            d.a.n0.a.v2.q.j(new h(this), "prepare ab description");
            if (G()) {
                d.a.n0.a.h2.f c2 = d.a.n0.a.h2.d.c();
                if (!c2.b() && !c2.a()) {
                    J("event_preload_error");
                    return;
                }
            }
            if (!((copyOnWriteArrayList == null || copyOnWriteArrayList.size() <= 0) ? false : false)) {
                w0();
            } else {
                x0(copyOnWriteArrayList);
            }
            d.a.n0.a.e0.d.h("SwanAppCoreRuntime", "preloadCoreRuntime end.");
        }
    }

    public d.a.n0.a.h0.l.a t0(boolean z2, d.a.n0.a.h0.b bVar) {
        InterceptResult invokeZL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZL = interceptable.invokeZL(1048630, this, z2, bVar)) == null) {
            d.a.n0.a.h0.l.a e2 = this.r.e(K(), z2 ? 1 : 0);
            d.a.n0.a.r1.h.p("preload").C(new UbcFlowEvent("na_pre_load_master_created"));
            e2.loadUrl(Q());
            e2.c(bVar);
            return e2;
        }
        return (d.a.n0.a.h0.l.a) invokeZL.objValue;
    }

    public final void u0(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048631, this, z2) == null) {
            synchronized (this.n) {
                boolean f2 = B ? this.f45263e.f() : this.f45264f != null;
                if (!this.f45265g && !f2) {
                    d.a.n0.a.e0.d.h("SwanAppCoreRuntime", "prepareMaster start.");
                    d.a.n0.a.r1.h.p("preload").C(new UbcFlowEvent("na_pre_load_master_start"));
                    if (B) {
                        this.f45263e.j(z2, new c(this));
                        return;
                    }
                    this.f45264f = this.r.e(K(), z2 ? 1 : 0);
                    d.a.n0.a.r1.h.p("preload").C(new UbcFlowEvent("na_pre_load_master_created"));
                    this.f45264f.loadUrl(Q());
                    this.f45264f.c(new d(this));
                }
            }
        }
    }

    public void v0(q qVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048632, this, qVar) == null) {
            d.a.n0.a.r1.k.g.a.c().f();
            d.a.n0.a.r1.k.i.b.e().g();
            if (qVar != null && !this.f45262d.contains(qVar)) {
                this.f45262d.add(qVar);
            }
            boolean c0 = c0();
            d.a.n0.a.r1.h.o().A("preload", c0 ? "1" : "0");
            d.a.n0.a.e0.d.h("SwanAppCoreRuntime", "prepareRuntime preload = " + c0);
            if (c0) {
                k0();
                return;
            }
            z = PreloadState.LOADING;
            d.a.n0.a.r1.h.p("preload").C(new UbcFlowEvent("na_pre_load_start"));
            if (!d.a.n0.a.a2.d.g().r().c0()) {
                d.a.n0.a.v2.q.j(new m(this), "SwanMemory");
            }
            R0();
            boolean G = G();
            this.u = G;
            if (G) {
                d.a.n0.a.h2.f c2 = d.a.n0.a.h2.d.c();
                if (!c2.b() && c2.a()) {
                    this.u = false;
                }
            }
            boolean z2 = this.u;
            d.a.n0.a.e0.d.h("SwanAppCoreRuntime", "mIsUseV8Master:" + this.u);
            if (this.u) {
                u0(true);
            }
            if (this.f45261c == null) {
                this.f45261c = new n(this, z2);
                if (v) {
                    Log.d("SwanAppCoreRuntime", "prepareRuntime addBlinkInitListener.");
                }
                this.s.b(this.f45261c);
            }
        }
    }

    public final void w0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048633, this) == null) {
            v0(new i(this));
        }
    }

    public final void x0(CopyOnWriteArrayList<q> copyOnWriteArrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048634, this, copyOnWriteArrayList) == null) {
            if (this.f45262d == null) {
                this.f45262d = new CopyOnWriteArrayList();
            }
            Iterator<q> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                q next = it.next();
                if (!this.f45262d.contains(next)) {
                    this.f45262d.add(next);
                }
            }
            v0(new j(this));
        }
    }

    public d.a.n0.a.p.e.b y0(Context context, d.a.n0.a.h0.b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048635, this, context, bVar)) == null) {
            try {
                d.a.n0.a.p.e.b f2 = this.r.f(context);
                d.a.n0.a.r1.h.p("preload").C(new UbcFlowEvent("na_pre_load_slave_created"));
                String T = T();
                if (T != null) {
                    d.a.n0.a.a2.e Q = d.a.n0.a.a2.e.Q();
                    if (Q != null && !TextUtils.isEmpty(Q.D())) {
                        T = Uri.parse(T).buildUpon().appendQueryParameter(PrefetchEvent.EVENT_KEY_APP_PATH, d.a.n0.a.a1.e.v(Q.D(), Q.Z(), false, null, null).getAbsolutePath()).toString();
                        if (!T.endsWith(File.separator)) {
                            T = T + File.separator;
                        }
                    }
                    f2.loadUrl(T);
                }
                d.a.n0.a.e0.d.h("SwanAppCoreRuntime", "prepareSlave loadUrl " + T);
                f2.c(bVar);
                return f2;
            } catch (NullPointerException e2) {
                d.a.n0.a.h0.a.e(context);
                throw e2;
            }
        }
        return (d.a.n0.a.p.e.b) invokeLL.objValue;
    }

    public final void z0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048636, this) == null) && !this.f45267i && this.f45266h == null) {
            if (v) {
                Log.d("SwanAppCoreRuntime", "prepareSlave start.");
            }
            d.a.n0.a.r1.h.p("preload").C(new UbcFlowEvent("na_pre_load_slave_start"));
            this.f45266h = y0(K(), new e(this));
            a0();
        }
    }
}
