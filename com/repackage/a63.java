package com.repackage;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.core.view.InputDeviceCompat;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import com.baidu.searchbox.http.statistics.NetworkStatRecord;
import com.baidu.searchbox.pms.constants.PmsConstant;
import com.baidu.searchbox.ubcprocessor.UBCCloudControlProcessor;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.favordata.SwanFavorItemData;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.scheme.actions.forbidden.ForbiddenInfo;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.util.GameCenterCoreUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.Sets;
import com.kwad.v8.NodeJS;
import com.repackage.d63;
import com.repackage.ek2;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import okhttp3.HttpUrl;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class a63 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static final ExecutorService b;
    public static Object c;
    public static final Set<String> d;
    public static final CopyOnWriteArrayList<String> e;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j63 a;

        public a(j63 j63Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j63Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j63Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.b(a63.Z());
                o53.k("778", this.a.f());
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ long b;
        public final /* synthetic */ long c;
        public final /* synthetic */ int d;
        public final /* synthetic */ int e;
        public final /* synthetic */ String f;
        public final /* synthetic */ String g;
        public final /* synthetic */ String h;
        public final /* synthetic */ String i;
        public final /* synthetic */ String j;
        public final /* synthetic */ NetworkStatRecord k;

        public b(String str, long j, long j2, int i, int i2, String str2, String str3, String str4, String str5, String str6, NetworkStatRecord networkStatRecord) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r3;
                Object[] objArr = {str, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i), Integer.valueOf(i2), str2, str3, str4, str5, str6, networkStatRecord};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.b = j;
            this.c = j2;
            this.d = i;
            this.e = i2;
            this.f = str2;
            this.g = str3;
            this.h = str4;
            this.i = str5;
            this.j = str6;
            this.k = networkStatRecord;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && SwanAppNetworkUtils.i(null)) {
                if (a63.o(this.a)) {
                    if (a63.a) {
                        Log.d("SwanAppUBCStatistic", "onRequest: ignore " + this.a);
                        return;
                    }
                    return;
                }
                long j = this.b - this.c;
                boolean z = this.d == 200;
                if (this.e == 0) {
                    if (TextUtils.equals(this.f, "1")) {
                        if (z) {
                            yz1.d().e(xz1.c(this.a, this.c, this.b, this.d, this.g));
                        } else {
                            yz1.d().e(xz1.a(this.a, this.c, this.b, this.d, this.g));
                        }
                    } else if (TextUtils.equals(this.f, "0")) {
                        yz1.d().e(xz1.b(this.a, this.c, this.g));
                    }
                }
                if (z && j < 5000) {
                    if (a63.a) {
                        Log.d("SwanAppUBCStatistic", "code 200 & cost(" + (this.b - this.c) + ") is ok, don't report");
                        return;
                    }
                    return;
                }
                a63.j(this.d, this.a, this.e, this.h, this.i, this.j, this.f, this.c, this.b, this.k);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ int b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;
        public final /* synthetic */ int g;

        public c(String str, int i, String str2, String str3, String str4, String str5, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i), str2, str3, str4, str5, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.b = i;
            this.c = str2;
            this.d = str3;
            this.e = str4;
            this.f = str5;
            this.g = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            h63 h63Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int b = uq2.b();
                if (a63.a) {
                    Log.d("SwanAppUBCStatistic", "get NetworkQuality: " + b);
                }
                if (TextUtils.equals(this.a, "1")) {
                    h63Var = new h63(this.b, this.c, this.d, b);
                } else {
                    h63Var = new h63(this.c, b, 0L, 0L);
                }
                new d63.a(h63Var, "downloadFile");
                if (!TextUtils.isEmpty(this.e)) {
                    h63Var.r(this.e);
                }
                if (!TextUtils.isEmpty(this.f)) {
                    h63Var.q(this.f);
                }
                h63Var.b = "downloadFile";
                if (hz2.L() != null && hz2.L().X() != null) {
                    h63Var.c = hz2.L().X().T();
                }
                h63Var.f = hz2.f0();
                h63Var.a = a63.n(this.g);
                JSONObject f = h63Var.f();
                o53.k("834", f);
                hw1.k("SwanAppUBCStatistic", "834-downloadFile event=" + f.toString());
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j63 a;

        public d(j63 j63Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j63Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j63Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                o53.k("894", this.a.f());
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g63 a;

        public e(g63 g63Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g63Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g63Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                o53.k("751", this.a.f());
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ ForbiddenInfo b;

        public f(String str, ForbiddenInfo forbiddenInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, forbiddenInfo};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.b = forbiddenInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                i63 i63Var = new i63();
                i63Var.e = this.a;
                i63Var.b = "show";
                i63Var.a = "swan";
                ForbiddenInfo forbiddenInfo = this.b;
                i63Var.c = forbiddenInfo.launchSource;
                i63Var.a("path", forbiddenInfo.launchPath);
                i63Var.a("appkey", this.b.appId);
                o53.m("1400", i63Var.f());
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ int c;
        public final /* synthetic */ Exception d;

        public g(String str, String str2, int i, Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, Integer.valueOf(i), exc};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.b = str2;
            this.c = i;
            this.d = exc;
        }

        @Override // java.lang.Runnable
        public void run() {
            hz2 a0;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (a0 = hz2.a0()) == null) {
                return;
            }
            ek2.a V = a0.V();
            String Y = a0.Y();
            String appId = a0.getAppId();
            i63 i63Var = new i63();
            i63Var.b = "login";
            i63Var.a = a63.n(V.G());
            i63Var.f = appId;
            i63Var.e = this.a;
            i63Var.a("appName", Y);
            i63Var.a("invokeFrom", this.b);
            i63Var.a("scene", Integer.valueOf(this.c));
            JSONObject f = i63Var.f();
            if (TextUtils.equals(this.a, "show")) {
                hw1.j("SwanAppUBCStatistic", "1936", "登录展示 event=" + f, false);
                o53.i("1936", "80", f);
            } else if (TextUtils.equals(this.a, "success")) {
                hw1.j("SwanAppUBCStatistic", "1936", "登录成功 event=" + f, false);
                o53.i("1936", "81", f);
            } else if (TextUtils.equals(this.a, com.baidu.pass.biometrics.face.liveness.b.a.g0) || TextUtils.equals(this.a, "check_fail")) {
                hw1.e("SwanAppUBCStatistic", "1936", "登录失败 event=" + f, this.d, false);
                o53.i("1936", "82", f);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ boolean d;
        public final /* synthetic */ Exception e;
        public final /* synthetic */ boolean f;

        public h(String str, String str2, String str3, boolean z, Exception exc, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, str3, Boolean.valueOf(z), exc, Boolean.valueOf(z2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.b = str2;
            this.c = str3;
            this.d = z;
            this.e = exc;
            this.f = z2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                hz2 r = gz2.J().r();
                ek2.a V = r.V();
                String Y = r.Y();
                String appId = r.getAppId();
                i63 i63Var = new i63();
                i63Var.b = "swanLogin";
                i63Var.a = a63.n(V.G());
                i63Var.f = appId;
                i63Var.e = this.a;
                i63Var.a("appName", Y);
                i63Var.a("loginScene", this.b);
                String str = this.c;
                if (str != null) {
                    i63Var.a("errorInfo", str);
                }
                JSONObject f = i63Var.f();
                if (this.d) {
                    hw1.p("SwanAppUBCStatistic", "1936", "登录取消打点 event=" + f, this.e, false);
                } else if (this.f) {
                    hw1.e("SwanAppUBCStatistic", "1936", "登录失败打点 event=" + f, this.e, false);
                } else {
                    hw1.j("SwanAppUBCStatistic", "1936", "登录数据打点 event=" + f, false);
                }
                o53.i("1936", "1936", f);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;

        public i(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.b = str2;
            this.c = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                j63 j63Var = new j63();
                j63Var.a = a63.n(gz2.J().r().l());
                String str = this.a;
                j63Var.b = str;
                j63Var.g = this.b;
                if (TextUtils.equals(str, "click")) {
                    j63Var.e = this.c;
                }
                j63Var.f = gz2.J().getAppId();
                j63Var.a("source", gz2.J().r().V().T());
                j63Var.a("mode", "normal");
                j63Var.a("from", "login");
                JSONObject f = j63Var.f();
                if (a63.a) {
                    Log.d("SwanAppUBCStatistic", "staticLoginResult: event = " + f);
                }
                o53.k("1936", f);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class j implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;

        public j(int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (a63.c) {
                    try {
                        a63.c.wait(this.a);
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class k implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j63 a;
        public final /* synthetic */ n53 b;

        public k(j63 j63Var, n53 n53Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j63Var, n53Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j63Var;
            this.b = n53Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                j63 j63Var = this.a;
                if (j63Var != null) {
                    o53.f(this.b, j63Var.f().toString());
                }
                o53.c(this.b);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class l implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ String b;

        public l(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                i63 i63Var = new i63();
                i63Var.a = a63.n(gz2.J().r().l());
                i63Var.f = gz2.J().getAppId();
                i63Var.a("type", Integer.valueOf(this.a ? 1 : 2));
                i63Var.a("errorCode", Long.valueOf(ze3.c().g()));
                i63Var.a("degradeUrl", this.b);
                i63Var.a("appid", gz2.J().getAppId());
                i63Var.a("hostname", oi2.n().a());
                i63Var.a("_swebfr", af3.e());
                o53.i("3863", "3863", i63Var.f());
                if (this.a) {
                    ab3 ab3Var = new ab3();
                    ab3Var.k(1L);
                    ab3Var.i(2108L);
                    eb3.a().f(ab3Var);
                    i63 i63Var2 = new i63();
                    i63Var2.p(ab3Var);
                    i63Var2.r(gz2.J().r().V());
                    i63Var2.q(a63.n(gz2.J().l()));
                    i63Var2.m(gz2.J().getAppId());
                    a63.R(i63Var2);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class m implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i63 a;
        public final /* synthetic */ long b;
        public final /* synthetic */ Exception c;

        public m(i63 i63Var, long j, Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i63Var, Long.valueOf(j), exc};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i63Var;
            this.b = j;
            this.c = exc;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (TextUtils.isEmpty(this.a.g())) {
                    this.a.k(gz2.J().r().V().V());
                }
                JSONObject f = this.a.f();
                hw1.e("SwanAppUBCStatistic", "671", "稳定性打点 since=" + vb3.e(new Date(this.b), "yyyy-MM-dd HH:mm:ss.SSS") + " event=" + f, this.c, false);
                o53.k("671", f);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class n implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j63 a;
        public final /* synthetic */ String b;

        public n(j63 j63Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j63Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j63Var;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                JSONObject f = this.a.f();
                o53.k(this.b, f);
                if (GameCenterCoreUtils.REF_TYPE_FROM_GAMECENTER.equals(this.b)) {
                    y53.a().b(f.toString());
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class o implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ j63 c;

        public o(String str, String str2, j63 j63Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, j63Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.b = str2;
            this.c = j63Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                o53.i(this.a, this.b, this.c.f());
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class p implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g63 a;

        public p(g63 g63Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g63Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g63Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                o53.k("751", this.a.f());
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class q implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g63 a;

        public q(g63 g63Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g63Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g63Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                o53.k("751", this.a.f());
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class r implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g63 a;

        public r(g63 g63Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g63Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g63Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                o53.k("751", this.a.f());
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class s implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g63 a;

        public s(g63 g63Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g63Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g63Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                o53.k("751", this.a.f());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755904877, "Lcom/repackage/a63;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755904877, "Lcom/repackage/a63;");
                return;
            }
        }
        a = rf1.a;
        b = Executors.newSingleThreadExecutor();
        c = new Object();
        d = Sets.newHashSet("hmma.baidu.com");
        CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        e = copyOnWriteArrayList;
        copyOnWriteArrayList.add("https://hmma.baidu.com/mini.gif");
        e.add("https://dxp.baidu.com/mini");
        CopyOnWriteArrayList<String> copyOnWriteArrayList2 = e;
        copyOnWriteArrayList2.add(bw1.c() + "/smtapp/recordhandler/getrecordinfo");
        CopyOnWriteArrayList<String> copyOnWriteArrayList3 = e;
        copyOnWriteArrayList3.add(bw1.b() + "/smtapp/recordhandler/getrecordinfo");
    }

    public static void A(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65537, null, str, i2) == null) {
            t(0, str, i2, null, null, null, "0");
        }
    }

    public static void B(String str, int i2, NetworkStatRecord networkStatRecord) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65538, null, str, i2, networkStatRecord) == null) {
            C(str, i2, networkStatRecord, 0L, 0L, "");
        }
    }

    public static void C(String str, int i2, NetworkStatRecord networkStatRecord, long j2, long j3, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{str, Integer.valueOf(i2), networkStatRecord, Long.valueOf(j2), Long.valueOf(j3), str2}) == null) {
            M(0, str, i2, null, null, null, "0", j2, j3, networkStatRecord, str2);
        }
    }

    public static void D(String str, int i2, NetworkStatRecord networkStatRecord, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, i2, networkStatRecord, str2) == null) {
            C(str, i2, networkStatRecord, 0L, 0L, str2);
        }
    }

    public static void E() {
        ek2.a V;
        Bundle P;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65541, null) == null) || !gz2.J().D() || (P = (V = gz2.J().r().V()).P()) == null || P.getLong("launch_flag_for_statistic") <= 0) {
            return;
        }
        long l2 = V.l("launch_time", 0L);
        long currentTimeMillis = System.currentTimeMillis();
        k63 k63Var = new k63();
        k63Var.a = n(gz2.J().l());
        k63Var.f = V.H();
        if (gv2.F(V.g0())) {
            k63Var.c = "remote-debug";
        } else if (gv2.D()) {
            k63Var.c = "local-debug";
        } else {
            k63Var.c = V.T();
        }
        k63Var.b = "launch";
        k63Var.e = "success";
        k63Var.r = String.valueOf(currentTimeMillis - l2);
        k63Var.a("status", "0");
        r53.n(k63Var, V.W(), V.s0().getString(UBCCloudControlProcessor.UBC_KEY));
        P.putLong("launch_flag_for_statistic", 0L);
        HybridUbcFlow d2 = ms2.d(NodeJS.STARTUP_SCRIPT_NAME);
        if (d2 != null) {
            if (d2.w() || d2.t()) {
                return;
            }
            d2.E("value", "na_success");
        }
    }

    public static void F(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(65542, null, z, str) == null) {
            j63 j63Var = new j63();
            if (gz2.J().r().H()) {
                j63Var.d(gz2.J().r().V().s0().getString(UBCCloudControlProcessor.UBC_KEY));
            }
            j63Var.b = "show";
            j63Var.c = str;
            j63Var.e = z ? "success" : com.baidu.pass.biometrics.face.liveness.b.a.g0;
            j63Var.f = hz2.f0();
            at2.e().d(new a(j63Var), "SwanAppUBCOnPagesRoute", true);
        }
    }

    public static void G(String str, String str2, List<String> list) {
        int i2;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65543, null, str, str2, list) == null) {
            if (gz2.J().r().H()) {
                ek2.a V = gz2.J().r().V();
                i2 = V.G();
                str3 = V.s0().getString(UBCCloudControlProcessor.UBC_KEY);
            } else {
                i2 = 0;
                str3 = "";
            }
            g63 g63Var = new g63();
            g63Var.b = TiebaStatic.DQPay.TYPE_VALUE;
            g63Var.c = str;
            g63Var.f = hz2.f0();
            g63Var.a = n(i2);
            try {
                JSONObject jSONObject = new JSONObject(str3);
                if (!TextUtils.isEmpty(str2)) {
                    jSONObject.put("paymenturl", str2);
                }
                if (list != null) {
                    jSONObject.put("whitelist", list);
                }
                jSONObject.put("appname", hz2.L().Y());
                g63Var.e(jSONObject);
            } catch (JSONException e2) {
                e2.printStackTrace();
                g63Var.d(str3);
            }
            g63Var.b(Z());
            bc3.k(new q(g63Var), "SwanAppUBCOnPay");
        }
    }

    public static void H(boolean z, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{Boolean.valueOf(z), str, str2}) == null) {
            g63 g63Var = new g63();
            ek2.a V = gz2.J().r().V();
            if (gz2.J().r().H()) {
                g63Var.d(V.s0().getString(UBCCloudControlProcessor.UBC_KEY));
            }
            g63Var.b = TiebaStatic.DQPay.TYPE_VALUE;
            g63Var.e = z ? "success" : com.baidu.pass.biometrics.face.liveness.b.a.g0;
            g63Var.c = str;
            g63Var.f = hz2.f0();
            g63Var.a = n(V.G());
            g63Var.a("money", str2);
            g63Var.b(Z());
            bc3.j(new p(g63Var), "SwanAppUBCOnPay");
        }
    }

    public static void I(String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(65545, null, str, str2, str3, str4) == null) && gz2.J().r().H()) {
            ek2.a V = gz2.J().r().V();
            int G = V.G();
            g63 g63Var = new g63();
            g63Var.b = "paykey";
            g63Var.a = n(G);
            g63Var.c = str;
            g63Var.e = str4;
            g63Var.a("appid", V.H());
            g63Var.a("money", str2);
            g63Var.a("source", V.T());
            g63Var.a("pmappkey", str3);
            bc3.k(new s(g63Var), "SwanAppUBCOnPayChecked");
        }
    }

    public static void J(String str, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65546, null, new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            g63 g63Var = new g63();
            ek2.a V = gz2.J().r().V();
            if (gz2.J().r().H()) {
                g63Var.d(V.s0().getString(UBCCloudControlProcessor.UBC_KEY));
            }
            g63Var.b = "paylogin";
            g63Var.c = str;
            g63Var.f = V.I();
            g63Var.a = n(V.G());
            g63Var.e = z ? "success" : com.baidu.pass.biometrics.face.liveness.b.a.g0;
            g63Var.a("nativeAppId", oi2.n().a());
            g63Var.a("paylogin", z2 ? "1" : "0");
            py1 H = uk2.U().H();
            ip2 M1 = H == null ? null : H.M1();
            if (M1 != null && !TextUtils.isEmpty(M1.i())) {
                g63Var.a("page", M1.i());
            }
            g63Var.b(Z());
            bc3.j(new e(g63Var), "SwanAppUBCOnPayLogin");
        }
    }

    public static void K(String str, String str2, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(65547, null, str, str2, i2) == null) && gz2.J().r().H()) {
            ek2.a V = gz2.J().r().V();
            int G = V.G();
            g63 g63Var = new g63();
            g63Var.b = "payProcess";
            g63Var.a = n(G);
            g63Var.c = str;
            g63Var.a("paymentProcess", str2);
            g63Var.a("appid", V.H());
            g63Var.a("source", V.T());
            if (V.j0() != null) {
                g63Var.a("swan", V.j0().swanCoreVersionName);
            }
            if (TextUtils.equals("result", str2)) {
                if (i2 == 0) {
                    g63Var.a("payResultStatus", "success");
                } else if (i2 != 2) {
                    g63Var.a("payResultStatus", com.baidu.pass.biometrics.face.liveness.b.a.g0);
                } else {
                    g63Var.a("payResultStatus", "cancel");
                }
            }
            g63Var.b(Z());
            bc3.k(new r(g63Var), "SwanAppUBCOnPayProcess");
        }
    }

    public static void L(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65548, null, str, str2) == null) {
            k63 k63Var = new k63();
            k63Var.b = "launch";
            k63Var.e = str;
            if (hz2.a0() != null) {
                ek2.a V = hz2.a0().V();
                k63Var.a = n(V.G());
                k63Var.f = V.H();
                k63Var.c = V.T();
            }
            k63Var.t = str2;
            onEvent(k63Var);
        }
    }

    public static void M(int i2, String str, int i3, String str2, @Nullable String str3, @Nullable String str4, String str5, long j2, long j3, @Nullable NetworkStatRecord networkStatRecord, @NonNull String str6) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65549, null, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), str2, str3, str4, str5, Long.valueOf(j2), Long.valueOf(j3), networkStatRecord, str6}) == null) {
            b.execute(new b(str, j3, j2, i2, i3, str5, str6, str2, str3, str4, networkStatRecord));
        }
    }

    public static void N(String str, String str2, @NonNull JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65550, null, str, str2, jSONObject) == null) {
            if (!TextUtils.equals(str, "1")) {
                if (a) {
                    Log.d("SwanAppUBCStatistic", "RequestForAvatar: onRequestForAvatar: miss. requestType=" + str);
                }
            } else if (TextUtils.isEmpty(str2)) {
                if (a) {
                    Log.d("SwanAppUBCStatistic", "RequestForAvatar: onRequestForAvatar: miss. url is empty");
                }
            } else {
                HttpUrl parse = HttpUrl.parse(str2);
                if (parse == null) {
                    if (a) {
                        Log.d("SwanAppUBCStatistic", "RequestForAvatar: onRequestForAvatar: miss. url is illegal, url=" + str2);
                        return;
                    }
                    return;
                }
                String host = parse.host();
                if (TextUtils.isEmpty(host)) {
                    if (a) {
                        Log.d("SwanAppUBCStatistic", "RequestForAvatar: onRequestForAvatar: miss. host is empty, url=" + str2);
                    }
                } else if (d.contains(host)) {
                    if (a) {
                        Log.d("SwanAppUBCStatistic", "RequestForAvatar: onRequestForAvatar: miss. host is ignored, host=" + host + " ,url=" + str2);
                    }
                } else {
                    if (a) {
                        Log.d("SwanAppUBCStatistic", "RequestForAvatar: onRequestForAvatar: hit. url=" + str2 + " value=" + jSONObject);
                    }
                    o53.i("1415", "66", jSONObject);
                }
            }
        }
    }

    public static void O(int i2, String str, int i3, String str2, long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65551, null, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), str2, Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            Q(i2, str, i3, str2, null, null, j2, j3, "");
        }
    }

    public static void P(int i2, String str, int i3, String str2, long j2, long j3, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65552, null, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), str2, Long.valueOf(j2), Long.valueOf(j3), str3}) == null) {
            Q(i2, str, i3, str2, null, null, j2, j3, str3);
        }
    }

    public static void Q(int i2, String str, int i3, String str2, @Nullable String str3, @Nullable String str4, long j2, long j3, @NonNull String str5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65553, null, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), str2, str3, str4, Long.valueOf(j2), Long.valueOf(j3), str5}) == null) {
            M(i2, str, i3, str2, str3, str4, "1", j2, j3, null, str5);
        }
    }

    public static void R(i63 i63Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65554, null, i63Var) == null) || i63Var == null) {
            return;
        }
        bc3.j(new m(i63Var, System.currentTimeMillis(), new Exception("stack")), "SwanAppUBCStability");
    }

    public static void S(String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65555, null, str, i2, str2) == null) {
            b.execute(new g(str, str2, i2, TextUtils.equals(str, com.baidu.pass.biometrics.face.liveness.b.a.g0) ? new Exception("stack") : null));
        }
    }

    public static void T(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65556, null, str, str2) == null) {
            U(str, str2, null);
        }
    }

    public static void U(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65557, null, str, str2, str3) == null) {
            boolean equals = TextUtils.equals(str2, "cancel");
            boolean equals2 = TextUtils.equals(str2, com.baidu.pass.biometrics.face.liveness.b.a.g0);
            b.execute(new h(str2, str, str3, equals, (equals || equals2) ? new Exception("stack") : null, equals2));
        }
    }

    public static void V(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(65558, null, z, str) == null) {
            b.execute(new l(z, str));
        }
    }

    public static void W(String str, String str2) {
        String str3;
        String str4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65559, null, str, str2) == null) {
            j63 j63Var = new j63();
            hz2 a0 = hz2.a0();
            String str5 = "";
            if (a0 != null) {
                str5 = n(a0.l());
                str4 = a0.N();
                str3 = a0.V().T();
            } else {
                str3 = "";
                str4 = str3;
            }
            j63Var.a = str5;
            j63Var.b = AlbumActivityConfig.FROM_WEB_VIEW;
            j63Var.c = str3;
            j63Var.a("appkey", str4);
            j63Var.a("url", str);
            j63Var.a("browser", str2);
            y("3320", "96", j63Var);
            if (a) {
                Log.d("SwanAppUBCStatistic", "onWebViewHistoryChange: " + String.format("ubcId=%s && ceresId=%s , content:%s ", "3320", "96", j63Var.f()));
            }
        }
    }

    public static JSONObject X(@Nullable NetworkStatRecord networkStatRecord) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65560, null, networkStatRecord)) == null) {
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
                if (a) {
                    e2.printStackTrace();
                }
                return null;
            }
        }
        return (JSONObject) invokeL.objValue;
    }

    public static void Y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65561, null) == null) {
            gz2 J = gz2.J();
            hz2 r2 = J.r();
            ek2.a V = r2.V();
            if (J.D() && r2.r0()) {
                Bundle s0 = V.s0();
                if (s0.getLong("launch_flag_for_statistic") > 0) {
                    String valueOf = String.valueOf(System.currentTimeMillis() - r2.V().u1());
                    k63 k63Var = new k63();
                    k63Var.a = n(V.G());
                    k63Var.b = "launch";
                    k63Var.e = "cancel";
                    k63Var.q = valueOf;
                    k63Var.j(V);
                    k63Var.d(s0.getString(UBCCloudControlProcessor.UBC_KEY));
                    k63Var.b(k(V.W()));
                    onEvent(k63Var);
                    k63 k63Var2 = new k63();
                    k63Var2.a = n(V.G());
                    k63Var2.b = "launch";
                    k63Var2.e = "realcancel";
                    k63Var2.q = valueOf;
                    k63Var2.j(V);
                    k63Var2.b(k(V.W()));
                    k63Var2.a("reason", "cancel");
                    if (V.G() == 1) {
                        k63Var.a("errorList", pi2.j().a());
                    }
                    k63Var2.d(s0.getString(UBCCloudControlProcessor.UBC_KEY));
                    onEvent(k63Var2);
                    s0.remove("launch_flag_for_statistic");
                }
            }
        }
    }

    public static JSONObject Z() {
        InterceptResult invokeV;
        ek2.a X;
        JSONObject M;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65562, null)) == null) {
            hz2 L = hz2.L();
            if (L == null || (X = L.X()) == null || (M = X.M()) == null || !TextUtils.equals(M.optString("token"), "swanubc")) {
                return null;
            }
            return M;
        }
        return (JSONObject) invokeV.objValue;
    }

    public static void a0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65564, null, i2) == null) {
            b.execute(new j(i2));
        }
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [com.repackage.a63.j.run():void] */
    public static /* synthetic */ boolean b() {
        return a;
    }

    public static n53 c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65566, null, str)) == null) ? o53.a(str) : (n53) invokeL.objValue;
    }

    public static void d(k63 k63Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65567, null, k63Var) == null) || k63Var == null || hz2.L() == null || hz2.L().X() == null) {
            return;
        }
        ek2.a X = hz2.L().X();
        k63Var.a = n(X.G());
        k63Var.f = X.H();
        k63Var.a("appkey", X.I());
        x("1032", k63Var);
    }

    public static void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65568, null, str) == null) {
            j63 j63Var = new j63();
            j63Var.a = n(0);
            j63Var.b = str;
            x("956", j63Var);
        }
    }

    public static void f(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65569, null, str, str2, str3) == null) {
            j63 j63Var = new j63();
            if (hz2.L() != null && hz2.L().X() != null) {
                ek2.a X = hz2.L().X();
                j63Var.a = n(X.G());
                j63Var.f = X.H();
                j63Var.b = str;
                j63Var.c = str2;
                j63Var.e = str3;
                j63Var.a("appkey", X.I());
            }
            x("923", j63Var);
        }
    }

    public static void g(j63 j63Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65570, null, j63Var) == null) {
            if (hz2.L() != null && hz2.L().X() != null) {
                ek2.a X = hz2.L().X();
                j63Var.a = n(X.G());
                j63Var.f = X.H();
                j63Var.c = X.T();
            }
            x("936", j63Var);
        }
    }

    public static void h(j63 j63Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65571, null, j63Var) == null) {
            if (hz2.L() != null && hz2.L().X() != null) {
                ek2.a X = hz2.L().X();
                j63Var.a = n(X.G());
                j63Var.f = X.H();
                j63Var.c = X.T();
            }
            x("914", j63Var);
        }
    }

    public static void i(n53 n53Var, j63 j63Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65572, null, n53Var, j63Var) == null) || n53Var == null) {
            return;
        }
        bc3.j(new k(j63Var, n53Var), "SwanAppUBCEndFlow");
    }

    @WorkerThread
    public static void j(int i2, String str, int i3, String str2, @Nullable String str3, @Nullable String str4, String str5, long j2, long j3, @Nullable NetworkStatRecord networkStatRecord) {
        h63 h63Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65573, null, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), str2, str3, str4, str5, Long.valueOf(j2), Long.valueOf(j3), networkStatRecord}) == null) {
            int b2 = uq2.b();
            if (a) {
                Log.d("SwanAppUBCStatistic", "get NetworkQuality: " + b2);
            }
            if (TextUtils.equals(str5, "1")) {
                h63Var = new h63(i2, str, str2, b2, j2, j3);
            } else {
                h63Var = new h63(str, b2, j2, j3);
            }
            d63.a aVar = new d63.a(h63Var, "request");
            if (!TextUtils.isEmpty(str3)) {
                h63Var.r(str3);
            }
            if (!TextUtils.isEmpty(str4)) {
                h63Var.q(str4);
            }
            h63Var.b = "request";
            hz2 r2 = gz2.J().r();
            if (r2 != null && r2.H()) {
                h63Var.c = r2.V().T();
                h63Var.d = r2.V().V();
            }
            h63Var.f = hz2.f0();
            h63Var.a = n(i3);
            JSONObject X = X(networkStatRecord);
            aVar.b = X;
            if (X != null) {
                h63Var.e(X);
            }
            if (a) {
                Log.d("SwanAppUBCStatistic", "Reporting: " + h63Var.f());
            }
            JSONObject f2 = h63Var.f();
            if (h63Var.o()) {
                hw1.j("SwanAppUBCStatistic", "834", "网络请求成功打点 event=" + f2, false);
            } else {
                hw1.e("SwanAppUBCStatistic", "834", "网络请求失败打点 event=" + f2, null, false);
            }
            o53.k("834", f2);
            N(h63Var.m(), h63Var.n(), f2);
        }
    }

    public static JSONObject k(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65574, null, str)) == null) {
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
                    if (a) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(65575, null)) == null) ? up2.g() ? "1" : "0" : (String) invokeV.objValue;
    }

    @NonNull
    public static String m(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65576, null, str, str2)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("url", str);
                jSONObject.put(PmsConstant.Statistic.STATISTIC_ERRMSG, str2);
            } catch (JSONException e2) {
                if (a) {
                    e2.printStackTrace();
                }
            }
            return jSONObject.toString();
        }
        return (String) invokeLL.objValue;
    }

    public static String n(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65577, null, i2)) == null) ? i2 != 1 ? "swan" : SwanFavorItemData.SCHEME_AUTHORITY_SWAN_GAME : (String) invokeI.objValue;
    }

    public static boolean o(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65578, null, str)) == null) {
            if (a) {
                Log.d("SwanAppUBCStatistic", "isIgnoreRequest: start with " + str);
            }
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            int size = e.size();
            for (int i2 = 0; i2 < size; i2++) {
                String str2 = e.get(i2);
                if (!TextUtils.isEmpty(str2) && str.startsWith(str2)) {
                    if (a) {
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

    public static void onEvent(k63 k63Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65579, null, k63Var) == null) {
            ExtensionCore T = b62.U().T();
            if (T != null) {
                k63Var.a("extension_ver", T.extensionCoreVersionName);
            }
            k63Var.a("isReloadApp", gz2.J().r().V().d("launch_by_reload") ? "1" : "0");
            JSONObject jSONObject = new JSONObject();
            hc3.f(jSONObject, "static", Float.valueOf(oi2.m().a()));
            k63Var.a("device_score", jSONObject.toString());
            x(GameCenterCoreUtils.REF_TYPE_FROM_GAMECENTER, k63Var);
        }
    }

    public static void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65580, null) == null) {
            synchronized (c) {
                try {
                    c.notifyAll();
                }
            }
        }
    }

    public static void q(String str, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65581, null, str, str2, z) == null) {
            j63 j63Var = new j63();
            j63Var.b = str;
            j63Var.e = str2;
            j63Var.f = hz2.f0();
            if (hz2.L() != null && hz2.L().X() != null) {
                ek2.a X = hz2.L().X();
                j63Var.c = X.T();
                j63Var.a = n(X.G());
            }
            if (TextUtils.equals("click", str)) {
                j63Var.a("authorize", z ? "success" : com.baidu.pass.biometrics.face.liveness.b.a.g0);
            }
            bc3.k(new d(j63Var), "SwanAppUBCOnAuthDialog");
        }
    }

    public static void r(int i2, h43 h43Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65582, null, i2, h43Var) == null) {
            hz2 a0 = hz2.a0();
            if (a0 == null) {
                if (a) {
                    Log.e("SwanAppUBCStatistic", "onAuthorizeFailed-swanApp is null");
                    return;
                }
                return;
            }
            i63 i63Var = new i63();
            i63Var.o(i2);
            i63Var.r(a0.X());
            i63Var.q(n(a0.l()));
            i63Var.m(a0.getAppId());
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("appid", a0.getAppId());
                jSONObject.put("msg", f43.f(i2));
                jSONObject.put(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID, a0.d0().q("cur_request_id", ""));
                if (h43Var != null) {
                    jSONObject.put("scope", h43Var.b);
                    jSONObject.put("scopeData", h43Var.a);
                }
            } catch (JSONException e2) {
                if (a) {
                    e2.printStackTrace();
                }
            }
            i63Var.e(jSONObject);
            R(i63Var);
        }
    }

    public static void s(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65583, null, str, str2, str3) == null) {
            b.execute(new i(str, str2, str3));
        }
    }

    @WorkerThread
    public static void t(int i2, String str, int i3, String str2, @Nullable String str3, @Nullable String str4, String str5) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65584, null, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), str2, str3, str4, str5}) == null) || i2 == 200) {
            return;
        }
        b.execute(new c(str5, i2, str, str2, str3, str4, i3));
    }

    public static void u(int i2, String str, int i3, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65585, null, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), str2}) == null) {
            t(i2, str, i3, str2, null, null, "1");
        }
    }

    public static void v(int i2, String str, int i3, String str2, @Nullable String str3, @Nullable String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65586, null, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), str2, str3, str4}) == null) {
            t(i2, str, i3, str2, str3, str4, "1");
        }
    }

    public static void w(ForbiddenInfo forbiddenInfo, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65587, null, forbiddenInfo, str) == null) || forbiddenInfo == null || TextUtils.isEmpty(str)) {
            return;
        }
        b.execute(new f(str, forbiddenInfo));
    }

    public static void x(String str, j63 j63Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65588, null, str, j63Var) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        at2.e().d(new n(j63Var, str), "SwanAppUBCOnEvent", true);
    }

    public static void y(String str, String str2, j63 j63Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65589, null, str, str2, j63Var) == null) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        bc3.j(new o(str, str2, j63Var), "SwanAppUbcCeresOnEvent");
    }

    public static void z(String str, int i2, String str2) {
        hz2 a0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(65590, null, str, i2, str2) == null) || (a0 = hz2.a0()) == null) {
            return;
        }
        ab3 ab3Var = new ab3();
        ab3Var.k(5L);
        ab3Var.i(50L);
        i63 i63Var = new i63();
        i63Var.p(ab3Var);
        i63Var.r(a0.V());
        i63Var.q(n(a0.l()));
        i63Var.m(a0.getAppId());
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appid", a0.getAppId());
            jSONObject.put("url", str);
            jSONObject.put("errcode", i2);
            jSONObject.put("msg", str2);
        } catch (JSONException e2) {
            if (a) {
                e2.printStackTrace();
            }
        }
        i63Var.e(jSONObject);
        R(i63Var);
    }
}
