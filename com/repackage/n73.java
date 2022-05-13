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
import com.repackage.q73;
import com.repackage.rl2;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import okhttp3.HttpUrl;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public final class n73 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static final ExecutorService b;
    public static Object c;
    public static final Set<String> d;
    public static final CopyOnWriteArrayList<String> e;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ w73 a;

        public a(w73 w73Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w73Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = w73Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.b(n73.Z());
                b73.k("778", this.a.f());
            }
        }
    }

    /* loaded from: classes6.dex */
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
                if (n73.o(this.a)) {
                    if (n73.a) {
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
                            l12.d().e(k12.c(this.a, this.c, this.b, this.d, this.g));
                        } else {
                            l12.d().e(k12.a(this.a, this.c, this.b, this.d, this.g));
                        }
                    } else if (TextUtils.equals(this.f, "0")) {
                        l12.d().e(k12.b(this.a, this.c, this.g));
                    }
                }
                if (z && j < 5000) {
                    if (n73.a) {
                        Log.d("SwanAppUBCStatistic", "code 200 & cost(" + (this.b - this.c) + ") is ok, don't report");
                        return;
                    }
                    return;
                }
                n73.j(this.d, this.a, this.e, this.h, this.i, this.j, this.f, this.c, this.b, this.k);
            }
        }
    }

    /* loaded from: classes6.dex */
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
            u73 u73Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int b = hs2.b();
                if (n73.a) {
                    Log.d("SwanAppUBCStatistic", "get NetworkQuality: " + b);
                }
                if (TextUtils.equals(this.a, "1")) {
                    u73Var = new u73(this.b, this.c, this.d, b);
                } else {
                    u73Var = new u73(this.c, b, 0L, 0L);
                }
                new q73.a(u73Var, "downloadFile");
                if (!TextUtils.isEmpty(this.e)) {
                    u73Var.r(this.e);
                }
                if (!TextUtils.isEmpty(this.f)) {
                    u73Var.q(this.f);
                }
                u73Var.b = "downloadFile";
                if (u03.L() != null && u03.L().X() != null) {
                    u73Var.c = u03.L().X().T();
                }
                u73Var.f = u03.f0();
                u73Var.a = n73.n(this.g);
                JSONObject f = u73Var.f();
                b73.k("834", f);
                ux1.k("SwanAppUBCStatistic", "834-downloadFile event=" + f.toString());
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ w73 a;

        public d(w73 w73Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w73Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = w73Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b73.k("894", this.a.f());
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t73 a;

        public e(t73 t73Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t73Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t73Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b73.k("751", this.a.f());
            }
        }
    }

    /* loaded from: classes6.dex */
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
                v73 v73Var = new v73();
                v73Var.e = this.a;
                v73Var.b = "show";
                v73Var.a = "swan";
                ForbiddenInfo forbiddenInfo = this.b;
                v73Var.c = forbiddenInfo.launchSource;
                v73Var.a("path", forbiddenInfo.launchPath);
                v73Var.a("appkey", this.b.appId);
                b73.m("1400", v73Var.f());
            }
        }
    }

    /* loaded from: classes6.dex */
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
            u03 a0;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (a0 = u03.a0()) == null) {
                return;
            }
            rl2.a V = a0.V();
            String Y = a0.Y();
            String appId = a0.getAppId();
            v73 v73Var = new v73();
            v73Var.b = "login";
            v73Var.a = n73.n(V.G());
            v73Var.f = appId;
            v73Var.e = this.a;
            v73Var.a("appName", Y);
            v73Var.a("invokeFrom", this.b);
            v73Var.a("scene", Integer.valueOf(this.c));
            JSONObject f = v73Var.f();
            if (TextUtils.equals(this.a, "show")) {
                ux1.j("SwanAppUBCStatistic", "1936", "登录展示 event=" + f, false);
                b73.i("1936", "80", f);
            } else if (TextUtils.equals(this.a, "success")) {
                ux1.j("SwanAppUBCStatistic", "1936", "登录成功 event=" + f, false);
                b73.i("1936", "81", f);
            } else if (TextUtils.equals(this.a, com.baidu.pass.biometrics.face.liveness.b.a.g0) || TextUtils.equals(this.a, "check_fail")) {
                ux1.e("SwanAppUBCStatistic", "1936", "登录失败 event=" + f, this.d, false);
                b73.i("1936", "82", f);
            }
        }
    }

    /* loaded from: classes6.dex */
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
                u03 r = t03.J().r();
                rl2.a V = r.V();
                String Y = r.Y();
                String appId = r.getAppId();
                v73 v73Var = new v73();
                v73Var.b = "swanLogin";
                v73Var.a = n73.n(V.G());
                v73Var.f = appId;
                v73Var.e = this.a;
                v73Var.a("appName", Y);
                v73Var.a("loginScene", this.b);
                String str = this.c;
                if (str != null) {
                    v73Var.a("errorInfo", str);
                }
                JSONObject f = v73Var.f();
                if (this.d) {
                    ux1.p("SwanAppUBCStatistic", "1936", "登录取消打点 event=" + f, this.e, false);
                } else if (this.f) {
                    ux1.e("SwanAppUBCStatistic", "1936", "登录失败打点 event=" + f, this.e, false);
                } else {
                    ux1.j("SwanAppUBCStatistic", "1936", "登录数据打点 event=" + f, false);
                }
                b73.i("1936", "1936", f);
            }
        }
    }

    /* loaded from: classes6.dex */
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
                w73 w73Var = new w73();
                w73Var.a = n73.n(t03.J().r().l());
                String str = this.a;
                w73Var.b = str;
                w73Var.g = this.b;
                if (TextUtils.equals(str, "click")) {
                    w73Var.e = this.c;
                }
                w73Var.f = t03.J().getAppId();
                w73Var.a("source", t03.J().r().V().T());
                w73Var.a("mode", "normal");
                w73Var.a("from", "login");
                JSONObject f = w73Var.f();
                if (n73.a) {
                    Log.d("SwanAppUBCStatistic", "staticLoginResult: event = " + f);
                }
                b73.k("1936", f);
            }
        }
    }

    /* loaded from: classes6.dex */
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
                synchronized (n73.c) {
                    try {
                        n73.c.wait(this.a);
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class k implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ w73 a;
        public final /* synthetic */ a73 b;

        public k(w73 w73Var, a73 a73Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w73Var, a73Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = w73Var;
            this.b = a73Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                w73 w73Var = this.a;
                if (w73Var != null) {
                    b73.f(this.b, w73Var.f().toString());
                }
                b73.c(this.b);
            }
        }
    }

    /* loaded from: classes6.dex */
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
                v73 v73Var = new v73();
                v73Var.a = n73.n(t03.J().r().l());
                v73Var.f = t03.J().getAppId();
                v73Var.a("type", Integer.valueOf(this.a ? 1 : 2));
                v73Var.a("errorCode", Long.valueOf(mg3.c().g()));
                v73Var.a("degradeUrl", this.b);
                v73Var.a("appid", t03.J().getAppId());
                v73Var.a("hostname", bk2.n().a());
                v73Var.a("_swebfr", ng3.e());
                b73.i("3863", "3863", v73Var.f());
                if (this.a) {
                    nc3 nc3Var = new nc3();
                    nc3Var.k(1L);
                    nc3Var.i(2108L);
                    rc3.a().f(nc3Var);
                    v73 v73Var2 = new v73();
                    v73Var2.p(nc3Var);
                    v73Var2.r(t03.J().r().V());
                    v73Var2.q(n73.n(t03.J().l()));
                    v73Var2.m(t03.J().getAppId());
                    n73.R(v73Var2);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class m implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v73 a;
        public final /* synthetic */ long b;
        public final /* synthetic */ Exception c;

        public m(v73 v73Var, long j, Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v73Var, Long.valueOf(j), exc};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = v73Var;
            this.b = j;
            this.c = exc;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (TextUtils.isEmpty(this.a.g())) {
                    this.a.k(t03.J().r().V().V());
                }
                JSONObject f = this.a.f();
                ux1.e("SwanAppUBCStatistic", "671", "稳定性打点 since=" + id3.e(new Date(this.b), "yyyy-MM-dd HH:mm:ss.SSS") + " event=" + f, this.c, false);
                b73.k("671", f);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class n implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ w73 a;
        public final /* synthetic */ String b;

        public n(w73 w73Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w73Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = w73Var;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                JSONObject f = this.a.f();
                b73.k(this.b, f);
                if (GameCenterCoreUtils.REF_TYPE_FROM_GAMECENTER.equals(this.b)) {
                    l73.a().b(f.toString());
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class o implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ w73 c;

        public o(String str, String str2, w73 w73Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, w73Var};
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
            this.c = w73Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b73.i(this.a, this.b, this.c.f());
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class p implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t73 a;

        public p(t73 t73Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t73Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t73Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b73.k("751", this.a.f());
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class q implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t73 a;

        public q(t73 t73Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t73Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t73Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b73.k("751", this.a.f());
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class r implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t73 a;

        public r(t73 t73Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t73Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t73Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b73.k("751", this.a.f());
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class s implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t73 a;

        public s(t73 t73Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t73Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t73Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b73.k("751", this.a.f());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755516633, "Lcom/repackage/n73;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755516633, "Lcom/repackage/n73;");
                return;
            }
        }
        a = eh1.a;
        b = Executors.newSingleThreadExecutor();
        c = new Object();
        d = Sets.newHashSet("hmma.baidu.com");
        CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        e = copyOnWriteArrayList;
        copyOnWriteArrayList.add("https://hmma.baidu.com/mini.gif");
        e.add("https://dxp.baidu.com/mini");
        CopyOnWriteArrayList<String> copyOnWriteArrayList2 = e;
        copyOnWriteArrayList2.add(ox1.c() + "/smtapp/recordhandler/getrecordinfo");
        CopyOnWriteArrayList<String> copyOnWriteArrayList3 = e;
        copyOnWriteArrayList3.add(ox1.b() + "/smtapp/recordhandler/getrecordinfo");
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
        rl2.a V;
        Bundle P;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65541, null) == null) || !t03.J().D() || (P = (V = t03.J().r().V()).P()) == null || P.getLong("launch_flag_for_statistic") <= 0) {
            return;
        }
        long l2 = V.l("launch_time", 0L);
        long currentTimeMillis = System.currentTimeMillis();
        x73 x73Var = new x73();
        x73Var.a = n(t03.J().l());
        x73Var.f = V.H();
        if (tw2.F(V.g0())) {
            x73Var.c = "remote-debug";
        } else if (tw2.D()) {
            x73Var.c = "local-debug";
        } else {
            x73Var.c = V.T();
        }
        x73Var.b = "launch";
        x73Var.e = "success";
        x73Var.r = String.valueOf(currentTimeMillis - l2);
        x73Var.a("status", "0");
        e73.n(x73Var, V.W(), V.s0().getString(UBCCloudControlProcessor.UBC_KEY));
        P.putLong("launch_flag_for_statistic", 0L);
        HybridUbcFlow d2 = zt2.d(NodeJS.STARTUP_SCRIPT_NAME);
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
            w73 w73Var = new w73();
            if (t03.J().r().H()) {
                w73Var.d(t03.J().r().V().s0().getString(UBCCloudControlProcessor.UBC_KEY));
            }
            w73Var.b = "show";
            w73Var.c = str;
            w73Var.e = z ? "success" : com.baidu.pass.biometrics.face.liveness.b.a.g0;
            w73Var.f = u03.f0();
            nu2.e().d(new a(w73Var), "SwanAppUBCOnPagesRoute", true);
        }
    }

    public static void G(String str, String str2, List<String> list) {
        int i2;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65543, null, str, str2, list) == null) {
            if (t03.J().r().H()) {
                rl2.a V = t03.J().r().V();
                i2 = V.G();
                str3 = V.s0().getString(UBCCloudControlProcessor.UBC_KEY);
            } else {
                i2 = 0;
                str3 = "";
            }
            t73 t73Var = new t73();
            t73Var.b = TiebaStatic.DQPay.TYPE_VALUE;
            t73Var.c = str;
            t73Var.f = u03.f0();
            t73Var.a = n(i2);
            try {
                JSONObject jSONObject = new JSONObject(str3);
                if (!TextUtils.isEmpty(str2)) {
                    jSONObject.put("paymenturl", str2);
                }
                if (list != null) {
                    jSONObject.put("whitelist", list);
                }
                jSONObject.put("appname", u03.L().Y());
                t73Var.e(jSONObject);
            } catch (JSONException e2) {
                e2.printStackTrace();
                t73Var.d(str3);
            }
            t73Var.b(Z());
            od3.k(new q(t73Var), "SwanAppUBCOnPay");
        }
    }

    public static void H(boolean z, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{Boolean.valueOf(z), str, str2}) == null) {
            t73 t73Var = new t73();
            rl2.a V = t03.J().r().V();
            if (t03.J().r().H()) {
                t73Var.d(V.s0().getString(UBCCloudControlProcessor.UBC_KEY));
            }
            t73Var.b = TiebaStatic.DQPay.TYPE_VALUE;
            t73Var.e = z ? "success" : com.baidu.pass.biometrics.face.liveness.b.a.g0;
            t73Var.c = str;
            t73Var.f = u03.f0();
            t73Var.a = n(V.G());
            t73Var.a("money", str2);
            t73Var.b(Z());
            od3.j(new p(t73Var), "SwanAppUBCOnPay");
        }
    }

    public static void I(String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(65545, null, str, str2, str3, str4) == null) && t03.J().r().H()) {
            rl2.a V = t03.J().r().V();
            int G = V.G();
            t73 t73Var = new t73();
            t73Var.b = "paykey";
            t73Var.a = n(G);
            t73Var.c = str;
            t73Var.e = str4;
            t73Var.a("appid", V.H());
            t73Var.a("money", str2);
            t73Var.a("source", V.T());
            t73Var.a("pmappkey", str3);
            od3.k(new s(t73Var), "SwanAppUBCOnPayChecked");
        }
    }

    public static void J(String str, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65546, null, new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            t73 t73Var = new t73();
            rl2.a V = t03.J().r().V();
            if (t03.J().r().H()) {
                t73Var.d(V.s0().getString(UBCCloudControlProcessor.UBC_KEY));
            }
            t73Var.b = "paylogin";
            t73Var.c = str;
            t73Var.f = V.I();
            t73Var.a = n(V.G());
            t73Var.e = z ? "success" : com.baidu.pass.biometrics.face.liveness.b.a.g0;
            t73Var.a("nativeAppId", bk2.n().a());
            t73Var.a("paylogin", z2 ? "1" : "0");
            c02 H = hm2.U().H();
            vq2 M1 = H == null ? null : H.M1();
            if (M1 != null && !TextUtils.isEmpty(M1.i())) {
                t73Var.a("page", M1.i());
            }
            t73Var.b(Z());
            od3.j(new e(t73Var), "SwanAppUBCOnPayLogin");
        }
    }

    public static void K(String str, String str2, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(65547, null, str, str2, i2) == null) && t03.J().r().H()) {
            rl2.a V = t03.J().r().V();
            int G = V.G();
            t73 t73Var = new t73();
            t73Var.b = "payProcess";
            t73Var.a = n(G);
            t73Var.c = str;
            t73Var.a("paymentProcess", str2);
            t73Var.a("appid", V.H());
            t73Var.a("source", V.T());
            if (V.j0() != null) {
                t73Var.a("swan", V.j0().swanCoreVersionName);
            }
            if (TextUtils.equals("result", str2)) {
                if (i2 == 0) {
                    t73Var.a("payResultStatus", "success");
                } else if (i2 != 2) {
                    t73Var.a("payResultStatus", com.baidu.pass.biometrics.face.liveness.b.a.g0);
                } else {
                    t73Var.a("payResultStatus", "cancel");
                }
            }
            t73Var.b(Z());
            od3.k(new r(t73Var), "SwanAppUBCOnPayProcess");
        }
    }

    public static void L(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65548, null, str, str2) == null) {
            x73 x73Var = new x73();
            x73Var.b = "launch";
            x73Var.e = str;
            if (u03.a0() != null) {
                rl2.a V = u03.a0().V();
                x73Var.a = n(V.G());
                x73Var.f = V.H();
                x73Var.c = V.T();
            }
            x73Var.t = str2;
            onEvent(x73Var);
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
                    b73.i("1415", "66", jSONObject);
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

    public static void R(v73 v73Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65554, null, v73Var) == null) || v73Var == null) {
            return;
        }
        od3.j(new m(v73Var, System.currentTimeMillis(), new Exception("stack")), "SwanAppUBCStability");
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
            w73 w73Var = new w73();
            u03 a0 = u03.a0();
            String str5 = "";
            if (a0 != null) {
                str5 = n(a0.l());
                str4 = a0.N();
                str3 = a0.V().T();
            } else {
                str3 = "";
                str4 = str3;
            }
            w73Var.a = str5;
            w73Var.b = AlbumActivityConfig.FROM_WEB_VIEW;
            w73Var.c = str3;
            w73Var.a("appkey", str4);
            w73Var.a("url", str);
            w73Var.a("browser", str2);
            y("3320", "96", w73Var);
            if (a) {
                Log.d("SwanAppUBCStatistic", "onWebViewHistoryChange: " + String.format("ubcId=%s && ceresId=%s , content:%s ", "3320", "96", w73Var.f()));
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
            t03 J = t03.J();
            u03 r2 = J.r();
            rl2.a V = r2.V();
            if (J.D() && r2.r0()) {
                Bundle s0 = V.s0();
                if (s0.getLong("launch_flag_for_statistic") > 0) {
                    String valueOf = String.valueOf(System.currentTimeMillis() - r2.V().u1());
                    x73 x73Var = new x73();
                    x73Var.a = n(V.G());
                    x73Var.b = "launch";
                    x73Var.e = "cancel";
                    x73Var.q = valueOf;
                    x73Var.j(V);
                    x73Var.d(s0.getString(UBCCloudControlProcessor.UBC_KEY));
                    x73Var.b(k(V.W()));
                    onEvent(x73Var);
                    x73 x73Var2 = new x73();
                    x73Var2.a = n(V.G());
                    x73Var2.b = "launch";
                    x73Var2.e = "realcancel";
                    x73Var2.q = valueOf;
                    x73Var2.j(V);
                    x73Var2.b(k(V.W()));
                    x73Var2.a("reason", "cancel");
                    if (V.G() == 1) {
                        x73Var.a("errorList", ck2.j().a());
                    }
                    x73Var2.d(s0.getString(UBCCloudControlProcessor.UBC_KEY));
                    onEvent(x73Var2);
                    s0.remove("launch_flag_for_statistic");
                }
            }
        }
    }

    public static JSONObject Z() {
        InterceptResult invokeV;
        rl2.a X;
        JSONObject M;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65562, null)) == null) {
            u03 L = u03.L();
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
    /* JADX DEBUG: Method not inlined, still used in: [com.repackage.n73.j.run():void] */
    public static /* synthetic */ boolean b() {
        return a;
    }

    public static a73 c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65566, null, str)) == null) ? b73.a(str) : (a73) invokeL.objValue;
    }

    public static void d(x73 x73Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65567, null, x73Var) == null) || x73Var == null || u03.L() == null || u03.L().X() == null) {
            return;
        }
        rl2.a X = u03.L().X();
        x73Var.a = n(X.G());
        x73Var.f = X.H();
        x73Var.a("appkey", X.I());
        x("1032", x73Var);
    }

    public static void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65568, null, str) == null) {
            w73 w73Var = new w73();
            w73Var.a = n(0);
            w73Var.b = str;
            x("956", w73Var);
        }
    }

    public static void f(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65569, null, str, str2, str3) == null) {
            w73 w73Var = new w73();
            if (u03.L() != null && u03.L().X() != null) {
                rl2.a X = u03.L().X();
                w73Var.a = n(X.G());
                w73Var.f = X.H();
                w73Var.b = str;
                w73Var.c = str2;
                w73Var.e = str3;
                w73Var.a("appkey", X.I());
            }
            x("923", w73Var);
        }
    }

    public static void g(w73 w73Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65570, null, w73Var) == null) {
            if (u03.L() != null && u03.L().X() != null) {
                rl2.a X = u03.L().X();
                w73Var.a = n(X.G());
                w73Var.f = X.H();
                w73Var.c = X.T();
            }
            x("936", w73Var);
        }
    }

    public static void h(w73 w73Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65571, null, w73Var) == null) {
            if (u03.L() != null && u03.L().X() != null) {
                rl2.a X = u03.L().X();
                w73Var.a = n(X.G());
                w73Var.f = X.H();
                w73Var.c = X.T();
            }
            x("914", w73Var);
        }
    }

    public static void i(a73 a73Var, w73 w73Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65572, null, a73Var, w73Var) == null) || a73Var == null) {
            return;
        }
        od3.j(new k(w73Var, a73Var), "SwanAppUBCEndFlow");
    }

    @WorkerThread
    public static void j(int i2, String str, int i3, String str2, @Nullable String str3, @Nullable String str4, String str5, long j2, long j3, @Nullable NetworkStatRecord networkStatRecord) {
        u73 u73Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65573, null, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), str2, str3, str4, str5, Long.valueOf(j2), Long.valueOf(j3), networkStatRecord}) == null) {
            int b2 = hs2.b();
            if (a) {
                Log.d("SwanAppUBCStatistic", "get NetworkQuality: " + b2);
            }
            if (TextUtils.equals(str5, "1")) {
                u73Var = new u73(i2, str, str2, b2, j2, j3);
            } else {
                u73Var = new u73(str, b2, j2, j3);
            }
            q73.a aVar = new q73.a(u73Var, "request");
            if (!TextUtils.isEmpty(str3)) {
                u73Var.r(str3);
            }
            if (!TextUtils.isEmpty(str4)) {
                u73Var.q(str4);
            }
            u73Var.b = "request";
            u03 r2 = t03.J().r();
            if (r2 != null && r2.H()) {
                u73Var.c = r2.V().T();
                u73Var.d = r2.V().V();
            }
            u73Var.f = u03.f0();
            u73Var.a = n(i3);
            JSONObject X = X(networkStatRecord);
            aVar.b = X;
            if (X != null) {
                u73Var.e(X);
            }
            if (a) {
                Log.d("SwanAppUBCStatistic", "Reporting: " + u73Var.f());
            }
            JSONObject f2 = u73Var.f();
            if (u73Var.o()) {
                ux1.j("SwanAppUBCStatistic", "834", "网络请求成功打点 event=" + f2, false);
            } else {
                ux1.e("SwanAppUBCStatistic", "834", "网络请求失败打点 event=" + f2, null, false);
            }
            b73.k("834", f2);
            N(u73Var.m(), u73Var.n(), f2);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(65575, null)) == null) ? hr2.g() ? "1" : "0" : (String) invokeV.objValue;
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

    public static void onEvent(x73 x73Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65579, null, x73Var) == null) {
            ExtensionCore T = o72.U().T();
            if (T != null) {
                x73Var.a("extension_ver", T.extensionCoreVersionName);
            }
            x73Var.a("isReloadApp", t03.J().r().V().d("launch_by_reload") ? "1" : "0");
            JSONObject jSONObject = new JSONObject();
            ud3.f(jSONObject, "static", Float.valueOf(bk2.m().a()));
            x73Var.a("device_score", jSONObject.toString());
            x(GameCenterCoreUtils.REF_TYPE_FROM_GAMECENTER, x73Var);
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
            w73 w73Var = new w73();
            w73Var.b = str;
            w73Var.e = str2;
            w73Var.f = u03.f0();
            if (u03.L() != null && u03.L().X() != null) {
                rl2.a X = u03.L().X();
                w73Var.c = X.T();
                w73Var.a = n(X.G());
            }
            if (TextUtils.equals("click", str)) {
                w73Var.a("authorize", z ? "success" : com.baidu.pass.biometrics.face.liveness.b.a.g0);
            }
            od3.k(new d(w73Var), "SwanAppUBCOnAuthDialog");
        }
    }

    public static void r(int i2, u53 u53Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65582, null, i2, u53Var) == null) {
            u03 a0 = u03.a0();
            if (a0 == null) {
                if (a) {
                    Log.e("SwanAppUBCStatistic", "onAuthorizeFailed-swanApp is null");
                    return;
                }
                return;
            }
            v73 v73Var = new v73();
            v73Var.o(i2);
            v73Var.r(a0.X());
            v73Var.q(n(a0.l()));
            v73Var.m(a0.getAppId());
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("appid", a0.getAppId());
                jSONObject.put("msg", s53.f(i2));
                jSONObject.put(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID, a0.d0().q("cur_request_id", ""));
                if (u53Var != null) {
                    jSONObject.put("scope", u53Var.b);
                    jSONObject.put("scopeData", u53Var.a);
                }
            } catch (JSONException e2) {
                if (a) {
                    e2.printStackTrace();
                }
            }
            v73Var.e(jSONObject);
            R(v73Var);
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

    public static void x(String str, w73 w73Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65588, null, str, w73Var) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        nu2.e().d(new n(w73Var, str), "SwanAppUBCOnEvent", true);
    }

    public static void y(String str, String str2, w73 w73Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65589, null, str, str2, w73Var) == null) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        od3.j(new o(str, str2, w73Var), "SwanAppUbcCeresOnEvent");
    }

    public static void z(String str, int i2, String str2) {
        u03 a0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(65590, null, str, i2, str2) == null) || (a0 = u03.a0()) == null) {
            return;
        }
        nc3 nc3Var = new nc3();
        nc3Var.k(5L);
        nc3Var.i(50L);
        v73 v73Var = new v73();
        v73Var.p(nc3Var);
        v73Var.r(a0.V());
        v73Var.q(n(a0.l()));
        v73Var.m(a0.getAppId());
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
        v73Var.e(jSONObject);
        R(v73Var);
    }
}
