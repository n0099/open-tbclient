package com.repackage;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.searchbox.ubcprocessor.UBCCloudControlProcessor;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.apps.scheme.actions.forbidden.ForbiddenInfo;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.eb4;
import com.repackage.el2;
import com.repackage.l03;
import com.repackage.uz1;
import java.io.File;
import java.util.Locale;
import java.util.Set;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public final class n03 extends p03 implements ba2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean n;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean b;
    public boolean c;
    public boolean d;
    public boolean e;
    public boolean f;
    public Set<eb4.a> g;
    public int h;
    public boolean i;
    public final h03 j;
    public String k;
    public boolean l;
    public PMSAppInfo m;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(n03 n03Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n03Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                g03.K().n("flag_finish_activity", "flag_remove_task");
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ el2 a;
        public final /* synthetic */ int b;

        public b(n03 n03Var, el2 el2Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n03Var, el2Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = el2Var;
            this.b = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.u0(this.b);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HybridUbcFlow a;
        public final /* synthetic */ n03 b;

        public c(n03 n03Var, HybridUbcFlow hybridUbcFlow) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n03Var, hybridUbcFlow};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = n03Var;
            this.a = hybridUbcFlow;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                HybridUbcFlow hybridUbcFlow = this.a;
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("postExec-run");
                ubcFlowEvent.a(true);
                hybridUbcFlow.F(ubcFlowEvent);
                this.b.d0();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Bundle a;
        public final /* synthetic */ n03 b;

        public d(n03 n03Var, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n03Var, bundle};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = n03Var;
            this.a = bundle;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Bundle bundle = new Bundle();
                Bundle bundle2 = this.a;
                if (bundle2 != null) {
                    bundle.putAll(bundle2);
                }
                bundle.putInt("appFrameType", this.b.j0().G());
                bundle.putString("mAppId", this.b.getAppId());
                if (n03.n) {
                    n03.p0("updateLocalPkgWithAsyncUpdatePkg: swanAsyncUpdate -> 发送异步升级消息");
                }
                xw2 e = xw2.e();
                zw2 zw2Var = new zw2(17, bundle);
                zw2Var.j(5000L);
                e.h(zw2Var);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements e62 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n03 a;

        public e(n03 n03Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n03Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = n03Var;
        }

        @Override // com.repackage.e62
        public void a(PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSAppInfo) == null) {
                HybridUbcFlow p = mt2.p("startup");
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updatePkgWithPresetCheckUpdate");
                ubcFlowEvent.a(true);
                p.F(ubcFlowEvent);
                this.a.c0(pMSAppInfo);
                UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("updatePkgWithPresetCheckUpdateIcon");
                ubcFlowEvent2.a(true);
                p.F(ubcFlowEvent2);
            }
        }

        @Override // com.repackage.e62
        public void b(PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSAppInfo) == null) {
                this.a.h = 5;
                n03 n03Var = this.a;
                n03Var.b0("KEY_PKG_STATE", "event_pms_check_finish", n03Var.h);
                HybridUbcFlow p = mt2.p("startup");
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updatePkgWithPresetCheck#OnSuccessStart");
                ubcFlowEvent.a(true);
                p.F(ubcFlowEvent);
                if (n03.n) {
                    n03.p0("预制包安装成功");
                }
                n03.o0(this.a.j0(), pMSAppInfo, false, false);
                this.a.M0(pMSAppInfo);
                this.a.I0(null);
                UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("updatePkgWithPresetCheck#OnSuccessEnd");
                ubcFlowEvent2.a(true);
                p.F(ubcFlowEvent2);
            }
        }

        @Override // com.repackage.e62
        public void onFailed(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
                HybridUbcFlow p = mt2.p("startup");
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updatePkgWithPresetCheck#OnFailedStart");
                ubcFlowEvent.a(true);
                p.F(ubcFlowEvent);
                if (n03.n) {
                    n03.p0("预制包安装失败");
                }
                this.a.K0();
                UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("updatePkgWithPresetCheck#OnonFailedEnd");
                ubcFlowEvent2.a(true);
                p.F(ubcFlowEvent2);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f extends nw2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ el2 c;
        public final /* synthetic */ n03 d;

        public f(n03 n03Var, el2 el2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n03Var, el2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = n03Var;
            this.c = el2Var;
        }

        @Override // com.repackage.nw2, com.repackage.mw2
        public long a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 1000L;
            }
            return invokeV.longValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.nw2, com.repackage.ow2, com.repackage.mw2
        public void onEvent(@NonNull kw2 kw2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, kw2Var) == null) {
                Bundle a = kw2Var.a();
                n03.o0(this.c, this.d.m, true, a != null ? a.getBoolean("isDownloading", false) : false);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g extends f32 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n03 h;

        public g(n03 n03Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n03Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.h = n03Var;
        }

        @Override // com.repackage.f32, com.repackage.a84
        public void G(nd4 nd4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nd4Var) == null) {
                this.h.c = true;
                g03.K().p("event_pkg_download_start");
                super.G(nd4Var);
            }
        }

        @Override // com.repackage.f32
        public void Q(@NonNull ac3 ac3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ac3Var) == null) {
                ec3.a().f(ac3Var);
                this.h.A0(ac3Var);
                this.h.t0(false);
            }
        }

        @Override // com.repackage.f32
        public void R() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.h.c = false;
                n03.o0(this.h.j0(), this.h.m, false, false);
                n03 n03Var = this.h;
                n03Var.h = n03Var.i ? 3 : 4;
                this.h.I0(null);
                n03 n03Var2 = this.h;
                n03Var2.b0("KEY_PKG_STATE", "event_pms_check_finish", n03Var2.h);
            }
        }

        @Override // com.repackage.f32, com.repackage.a84, com.repackage.x74
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.h.c = false;
                g03.K().p("event_pkg_download_finish");
                super.b();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h implements q32 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ hb4 b;
        public final /* synthetic */ HybridUbcFlow c;
        public final /* synthetic */ n03 d;

        public h(n03 n03Var, boolean z, hb4 hb4Var, HybridUbcFlow hybridUbcFlow) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n03Var, Boolean.valueOf(z), hb4Var, hybridUbcFlow};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = n03Var;
            this.a = z;
            this.b = hb4Var;
            this.c = hybridUbcFlow;
        }

        @Override // com.repackage.q32
        public void a(ac3 ac3Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, ac3Var, z) == null) {
                long a = ac3Var == null ? 0L : ac3Var.a();
                hx1.k("SwanPkgMaintainer", "mFlagDownloading reset onFinalFailed isRetry = " + this.a + ",code =" + a);
                if (this.a) {
                    a73.L("pkg_retry_fail", String.valueOf(a));
                }
                if (this.d.a0(this.b, ac3Var)) {
                    return;
                }
                this.d.c = false;
                g03.K().p("event_pkg_download_finish");
                HybridUbcFlow hybridUbcFlow = this.c;
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onFinalFailedStart");
                ubcFlowEvent.a(true);
                hybridUbcFlow.F(ubcFlowEvent);
                ec3.a().f(ac3Var);
                if (z) {
                    n03 n03Var = this.d;
                    n03Var.h = n03Var.i ? 3 : 4;
                    n03 n03Var2 = this.d;
                    n03Var2.b0("KEY_PKG_STATE", "event_pms_check_finish", n03Var2.h);
                    this.d.H0(ac3Var);
                } else if (ac3Var != null && ac3Var.h() == 1020) {
                    this.d.A0(ac3Var);
                }
                HybridUbcFlow hybridUbcFlow2 = this.c;
                UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onFinalFailedEnd");
                ubcFlowEvent2.a(true);
                hybridUbcFlow2.F(ubcFlowEvent2);
                if (ac3Var == null || ac3Var.h() != 2203) {
                    return;
                }
                hx1.k("SwanPkgMaintainer", "recoverPlatform for errorCode 2203");
                if (f92.a().b(1) == 0) {
                    f92.a().c();
                }
            }
        }

        @Override // com.repackage.q32
        public void b(PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSAppInfo) == null) {
                hx1.k("SwanPkgMaintainer", "mFlagDownloading reset onFinalComplete isRetry = " + this.a);
                if (this.a) {
                    a73.L("pkg_retry_success", "");
                }
                this.d.c = false;
                n03 n03Var = this.d;
                n03Var.h = n03Var.e ? 2 : 0;
                n03 n03Var2 = this.d;
                n03Var2.h = n03Var2.i ? 1 : this.d.h;
                n03 n03Var3 = this.d;
                n03Var3.b0("KEY_PKG_STATE", "event_pms_check_finish", n03Var3.h);
                HybridUbcFlow hybridUbcFlow = this.c;
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onFinalCompleteStart");
                ubcFlowEvent.a(true);
                hybridUbcFlow.F(ubcFlowEvent);
                this.d.M0(pMSAppInfo);
                this.d.F0(null);
                HybridUbcFlow hybridUbcFlow2 = this.c;
                UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onFinalCompleteEnd");
                ubcFlowEvent2.a(true);
                hybridUbcFlow2.F(ubcFlowEvent2);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i implements af3<PMSAppInfo> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HybridUbcFlow a;
        public final /* synthetic */ n03 b;

        public i(n03 n03Var, HybridUbcFlow hybridUbcFlow) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n03Var, hybridUbcFlow};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = n03Var;
            this.a = hybridUbcFlow;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.af3
        /* renamed from: b */
        public void a(PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSAppInfo) == null) {
                HybridUbcFlow hybridUbcFlow = this.a;
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onAppInfoReceivedStart");
                ubcFlowEvent.a(true);
                hybridUbcFlow.F(ubcFlowEvent);
                if (n03.n) {
                    n03.p0("onAppInfoReceived appInfo=" + pMSAppInfo);
                }
                this.b.M0(pMSAppInfo);
                this.b.c0(pMSAppInfo);
                HybridUbcFlow hybridUbcFlow2 = this.a;
                UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onAppInfoReceivedEnd");
                ubcFlowEvent2.a(true);
                hybridUbcFlow2.F(ubcFlowEvent2);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class j extends i32 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean G;
        public final /* synthetic */ n03 H;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(n03 n03Var, h03 h03Var, boolean z) {
            super(h03Var);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n03Var, h03Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((h03) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.H = n03Var;
            this.G = z;
        }

        @Override // com.repackage.i32, com.repackage.h32, com.repackage.a84
        public void G(nd4 nd4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nd4Var) == null) {
                hx1.k("SwanPkgMaintainer", "mFlagDownloading set onPrepareDownload isRetry = " + this.G);
                this.H.c = true;
                g03.K().p("event_pkg_download_start");
                super.G(nd4Var);
            }
        }

        @Override // com.repackage.a84, com.repackage.x74
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                hx1.k("SwanPkgMaintainer", "mFlagDownloading reset onTotalPkgDownloadFinish isRetry = " + this.G);
                this.H.c = false;
                g03.K().p("event_pkg_download_finish");
                super.b();
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class k implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k73 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;

        public k(k73 k73Var, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k73Var, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = k73Var;
            this.b = str;
            this.c = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                n03.n0(this.a, this.b, this.c);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class l extends hw2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public l() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.hw2
        public void b(@NonNull Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
                String string = bundle.getString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID);
                boolean z = false;
                if (TextUtils.isEmpty(string)) {
                    this.d.putBoolean("isDownloading", false);
                    c();
                    return;
                }
                boolean j = p74.j(string);
                boolean k = p74.k(string);
                if (hw2.e) {
                    Log.d("MDelegate-Delegation", "isDownloading: " + j + ", isInQueue: " + k);
                }
                this.d.putBoolean("isDownloading", (j || k) ? true : true);
                c();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755523360, "Lcom/repackage/n03;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755523360, "Lcom/repackage/n03;");
                return;
            }
        }
        n = rg1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n03(h03 h03Var) {
        super(h03Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {h03Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((k03) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = false;
        this.c = false;
        this.d = false;
        this.e = false;
        this.f = false;
        this.h = -1;
        this.i = false;
        this.k = "";
        this.l = false;
        this.j = h03Var;
    }

    private Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65555, this)) == null) {
            SwanAppActivity w = this.j.w();
            return (w == null || w.isDestroyed()) ? oj2.c() : w;
        }
        return (Context) invokeV.objValue;
    }

    public static String i0(Context context, ac3 ac3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65556, null, context, ac3Var)) == null) ? String.format(context.getResources().getString(R.string.obfuscated_res_0x7f0f01a0), be3.D(), m93.i(ul2.U().M(), g03.K().q().k()), String.valueOf(ac3Var.a())) : (String) invokeLL.objValue;
    }

    public static void n0(k73 k73Var, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65557, null, k73Var, str, str2) == null) {
            JSONObject k2 = a73.k(str);
            k73Var.d(str2);
            k73Var.b(k2);
            a73.onEvent(k73Var);
        }
    }

    public static void o0(hl2 hl2Var, PMSAppInfo pMSAppInfo, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65558, null, new Object[]{hl2Var, pMSAppInfo, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (n) {
                Log.d("SwanPkgMaintainer", "SwanPkgMaintainer#launchStatistic");
            }
            hl2Var.s0().putString("aiapp_extra_need_download", z ? "1" : "0");
            hl2Var.s0().putString("aiapp_extra_pkg_downloading", z2 ? "1" : "0");
            k73 k73Var = new k73();
            k73Var.a = a73.n(hl2Var.G());
            k73Var.h(hl2Var);
            k73Var.b = "launch";
            k73Var.o = z ? "1" : "0";
            if (pMSAppInfo != null) {
                k73Var.l = String.valueOf(pMSAppInfo.versionCode);
            }
            au2.e().d(new k(k73Var, hl2Var.W(), hl2Var.s0().getString(UBCCloudControlProcessor.UBC_KEY)), "launchStatistic", true);
        }
    }

    public static void p0(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65559, null, str) == null) && n) {
            Log.i("SwanPkgMaintainer", str);
        }
    }

    public static void y0(PMSAppInfo pMSAppInfo, Context context, el2 el2Var, boolean z, String str, ac3 ac3Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65560, null, new Object[]{pMSAppInfo, context, el2Var, Boolean.valueOf(z), str, ac3Var}) == null) || pMSAppInfo == null) {
            return;
        }
        ForbiddenInfo forbiddenInfo = new ForbiddenInfo(el2Var, str, i0(context, ac3Var));
        forbiddenInfo.enableSlidingFlag = -1;
        bl2.l(context, z ? "type_path_forbidden" : "type_app_forbidden", ac3Var, forbiddenInfo, el2Var.D());
        k73 k73Var = new k73();
        k73Var.a = a73.n(el2Var.G());
        k73Var.b = "launch";
        k73Var.e = "success";
        k73Var.i(el2Var);
        k73Var.a("status", "2");
        k73Var.d(el2Var.s0().getString(UBCCloudControlProcessor.UBC_KEY));
        a73.onEvent(k73Var);
    }

    public final void A0(ac3 ac3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, ac3Var) == null) {
            mt2.k(ac3Var);
            Context context = getContext();
            if ((context instanceof SwanAppActivity) && !qc3.d((SwanAppActivity) context)) {
                if (n) {
                    Log.d("SwanPkgMaintainer", "launcher activity closed, ignore launch err");
                    return;
                }
                return;
            }
            el2 j0 = j0();
            int G = j0.G();
            if (!ac3Var.l()) {
                i73 i73Var = new i73();
                i73Var.q(a73.n(G));
                i73Var.p(ac3Var);
                i73Var.m(getAppId());
                i73Var.t(j0.T());
                a73.R(i73Var);
                ac3Var.n();
            }
            if (!vl2.a().b()) {
                if (n) {
                    Log.d("SwanPkgMaintainer", "launcher activity hide, ignore launch err and reset.");
                }
                be3.e0(new a(this));
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("mAppId", j0.H());
            bundle.putAll(j0.D());
            bl2.g(oj2.c(), ac3Var, G, getAppId(), true, bundle);
            r63.m(j0, G, ac3Var);
            oj2.p0().flush(false);
        }
    }

    public boolean B0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.c : invokeV.booleanValue;
    }

    public final void C0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            dj2.O(this.j);
        }
    }

    public final void D0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            HybridUbcFlow p = mt2.p("startup");
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updateForIndependentPkgStart");
            ubcFlowEvent.a(true);
            p.F(ubcFlowEvent);
            if (n) {
                p0("独立分包启动，本地有包--->打开小程序，异步更新主包");
            }
            el2 j0 = j0();
            String c2 = ol2.c(this.m, j0.e0());
            j0.F0(true);
            j0.V0(c2);
            Bundle bundle = new Bundle();
            bundle.putLong("pms_update_expect_pkg_ver", this.m.versionCode);
            I0(bundle);
            UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("updateForIndependentPkgEnd");
            ubcFlowEvent2.a(true);
            p.F(ubcFlowEvent2);
        }
    }

    public final int E0(ac3 ac3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, ac3Var)) == null) {
            HybridUbcFlow p = mt2.p("startup");
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updateInfoWithFinalCheckStart");
            ubcFlowEvent.a(true);
            p.F(ubcFlowEvent);
            if (n) {
                p0("updateInfoWithFinalCheck: mAppInfo=" + this.m);
            }
            PMSAppInfo pMSAppInfo = this.m;
            if (pMSAppInfo == null) {
                if (ac3Var == null) {
                    ac3Var = new ac3();
                    ac3Var.k(10L);
                    ac3Var.i(2902L);
                    ac3Var.f("no pkg was installed");
                }
                ec3.a().f(ac3Var);
                A0(ac3Var);
                return -1;
            }
            int Z = Z(pMSAppInfo);
            if (ag3.g(ac3Var, Z)) {
                return -2;
            }
            if (Z != 10001 && Z != 10002) {
                G0();
                if (Z != 0) {
                    ac3 h0 = h0(10003);
                    ec3.a().f(h0);
                    z0(false, null, h0);
                    mt2.k(h0);
                    oj2.p0().flush(false);
                    return -1;
                }
                if (!this.f) {
                    Set<eb4.a> i2 = ov2.i(this.m);
                    boolean z = i2 == null || i2.isEmpty();
                    this.f = z;
                    if (!z) {
                        ac3 ac3Var2 = new ac3();
                        ac3Var2.k(17L);
                        ac3Var2.i(2909L);
                        ac3Var2.f("dependent pkg is missing.");
                        ec3.a().f(ac3Var2);
                        A0(ac3Var2);
                        return -1;
                    }
                }
                ul2 U = ul2.U();
                String e0 = q().W().e0();
                if (!TextUtils.isEmpty(e0)) {
                    if (u23.b().a(hq2.d(e0, U.z()))) {
                        ac3 h02 = h0(10004);
                        ec3.a().f(h02);
                        z0(true, u23.b().d(), h02);
                        mt2.k(h02);
                        oj2.p0().flush(false);
                        return -1;
                    }
                }
                return 1;
            }
            if (ac3Var == null) {
                ac3Var = h0(Z);
            }
            ec3.a().f(ac3Var);
            A0(ac3Var);
            return -1;
        }
        return invokeL.intValue;
    }

    public final boolean F0(ac3 ac3Var) {
        InterceptResult invokeL;
        r82 d2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, ac3Var)) == null) {
            HybridUbcFlow p = mt2.p("startup");
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updateInstalledPkgWithFinalCheckStart");
            ubcFlowEvent.a(true);
            p.F(ubcFlowEvent);
            if (k0()) {
                return false;
            }
            int E0 = E0(ac3Var);
            if (E0 == -1) {
                hx1.i("SwanPkgMaintainer", "updateInstalledPkgWithFinalCheck by null launchParams");
                t0(false);
                return false;
            } else if (E0 == -2) {
                s0();
                return false;
            } else {
                UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("updateInfoWithFinalCheckOk");
                ubcFlowEvent2.a(true);
                p.F(ubcFlowEvent2);
                el2.a W = this.j.W();
                SwanCoreVersion j0 = W.j0();
                String str = j0 != null ? j0.swanCoreVersionName : "0";
                if (n) {
                    Log.d("SwanPkgMaintainer", "SwanCoreVersion target string version: " + W.k0() + " ,curSwanVersionName: " + str);
                }
                if (wd3.a(W.k0(), str)) {
                    m93.n(W.G());
                }
                mt2.p("startup").D("launch_type", String.valueOf(W.i("host_launch_type")));
                if (W.G() == 0) {
                    C0();
                }
                UbcFlowEvent ubcFlowEvent3 = new UbcFlowEvent("updateInstalledPkgWithFinalCheckEnd");
                ubcFlowEvent3.a(true);
                p.F(ubcFlowEvent3);
                t0(true);
                if (ProcessUtils.isMainProcess() && (d2 = t82.c().d()) != null && d2.m()) {
                    d2.b(getAppId());
                }
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    public final void G0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            el2.a W = q().W();
            PMSAppInfo pMSAppInfo = this.m;
            boolean z = (pMSAppInfo == null || TextUtils.isEmpty(pMSAppInfo.appId) || !TextUtils.equals(getAppId(), this.m.appId)) ? false : true;
            if (z) {
                W.S0(this.m);
            }
            PMSAppInfo pMSAppInfo2 = this.m;
            if (pMSAppInfo2 != null) {
                int i2 = (z && pMSAppInfo2.appCategory == 1) ? 1 : 0;
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    W.u0(i2);
                } else {
                    be3.e0(new b(this, W, i2));
                }
            }
        }
    }

    public final void H0(ac3 ac3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, ac3Var) == null) && F0(ac3Var)) {
            i73 i73Var = new i73();
            i73Var.p(ac3Var);
            i73Var.r(j0());
            a73.R(i73Var);
        }
    }

    public final void I0(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle) == null) {
            HybridUbcFlow p = mt2.p("startup");
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updateLocalPkgWithAsyncUpdatePkgStart");
            ubcFlowEvent.a(true);
            p.F(ubcFlowEvent);
            if (n) {
                p0("启动本地包，进程预处理-加载本地包-后台异步更新");
            }
            F0(null);
            zt2.j().i(new d(this, bundle));
            UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("updateLocalPkgWithAsyncUpdatePkgEnd");
            ubcFlowEvent2.a(true);
            p.F(ubcFlowEvent2);
        }
    }

    public void J0(Set<eb4.a> set) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, set) == null) {
            this.g = set;
            if (set == null || set.isEmpty()) {
                this.f = true;
            }
        }
    }

    public final void K0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            g03.K().p("event_pms_check_start");
            HybridUbcFlow p = mt2.p("startup");
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updatePkgOnPresetUnavailableStart");
            boolean z = true;
            ubcFlowEvent.a(true);
            p.F(ubcFlowEvent);
            el2 j0 = j0();
            if (n) {
                p0("预置包不可用");
            }
            boolean r0 = r0();
            if (n) {
                Log.i("SwanPkgMaintainer", "updatePkgOnPresetUnavailable: isNeedFetchPkg " + r0);
            }
            if (!r0) {
                if (!this.f) {
                    Set<eb4.a> set = this.g;
                    if (set == null || set.isEmpty()) {
                        this.g = ov2.i(this.m);
                    }
                    Set<eb4.a> set2 = this.g;
                    if (set2 != null && !set2.isEmpty()) {
                        z = false;
                    }
                    this.f = z;
                    if (!z) {
                        g0(this.g);
                        this.g = null;
                        return;
                    }
                }
                if (n) {
                    p0("可以直接打开小程序，异步从Server拉取新包");
                }
                this.h = 4;
                o0(j0, this.m, false, false);
                this.h = this.i ? 3 : 4;
                I0(null);
                b0("KEY_PKG_STATE", "event_pms_check_finish", this.h);
                return;
            }
            if (n) {
                p0("不能直接打开小程序，同步从Server拉取新包");
            }
            b0("KEY_PKG_STATE", "event_pms_check_finish", this.h);
            e0(this.j.W().H(), new f(this, j0));
            String appId = getAppId();
            hb4 hb4Var = new hb4(appId, j0.G());
            hb4Var.d("3");
            PMSAppInfo pMSAppInfo = this.m;
            hb4Var.u(pMSAppInfo == null ? 0L : pMSAppInfo.versionCode);
            PMSAppInfo pMSAppInfo2 = this.m;
            hb4Var.o(pMSAppInfo2 != null ? pMSAppInfo2.appSign : 0L);
            String f2 = zd3.f(j0.e0());
            if (!TextUtils.isEmpty(f2)) {
                if (f2.startsWith(File.separator)) {
                    f2 = f2.substring(1);
                }
                hb4Var.t(f2);
            }
            UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("updatePkgOnPresetUnavailableRequest");
            ubcFlowEvent2.a(true);
            p.F(ubcFlowEvent2);
            A((l03.a) new l03.a("event_on_still_maintaining").t(" event_params_pkg_update", this.l));
            cl2.b().g(appId);
            f0(hb4Var, false, null);
            UbcFlowEvent ubcFlowEvent3 = new UbcFlowEvent("updatePkgOnPresetUnavailableReturn");
            ubcFlowEvent3.a(true);
            p.F(ubcFlowEvent3);
        }
    }

    public final void L0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            HybridUbcFlow p = mt2.p("startup");
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updatePkgWithPresetCheckStart");
            ubcFlowEvent.a(true);
            p.F(ubcFlowEvent);
            if (n) {
                p0(this.m == null ? "数据库或本地无主包信息，尝试加载预置包，并下载主包" : "包信息、文件都存在，尝试加载更高版本的预置包");
            }
            d62 c2 = g62.b().c(getAppId());
            PMSAppInfo pMSAppInfo = this.m;
            long j2 = pMSAppInfo == null ? -1L : pMSAppInfo.versionCode;
            long j3 = c2 != null ? c2.i : -1L;
            boolean z = j3 > j2;
            if (n) {
                p0(String.format(Locale.getDefault(), "尝试加载预制包，命中预制包=%b  currentVersion/presetVersion = %d/%d", Boolean.valueOf(z), Long.valueOf(j2), Long.valueOf(j3)));
            }
            if (!z) {
                K0();
                return;
            }
            p("event_on_still_maintaining");
            UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("updatePkgWithPresetCheckLoadPresetApp");
            ubcFlowEvent2.a(true);
            p.F(ubcFlowEvent2);
            g62.b().e(c2, new e(this));
            UbcFlowEvent ubcFlowEvent3 = new UbcFlowEvent("updatePkgWithPresetCheckReturn");
            ubcFlowEvent3.a(true);
            p.F(ubcFlowEvent3);
        }
    }

    public void M0(PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, pMSAppInfo) == null) {
            this.m = pMSAppInfo;
            this.j.W().c1(pMSAppInfo);
            if (k0()) {
                G0();
                u0();
            }
        }
    }

    public final void N0(PMSAppInfo pMSAppInfo, HybridUbcFlow hybridUbcFlow) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048589, this, pMSAppInfo, hybridUbcFlow) == null) || pMSAppInfo == null || hybridUbcFlow == null) {
            return;
        }
        M0(pMSAppInfo);
        c0(this.m);
        UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("update_icon");
        ubcFlowEvent.a(true);
        hybridUbcFlow.F(ubcFlowEvent);
    }

    public final int Z(@NonNull PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, pMSAppInfo)) == null) {
            int i2 = pMSAppInfo.appStatus;
            if (i2 != 0) {
                return i2;
            }
            int G = j0().G();
            int i3 = pMSAppInfo.appCategory;
            return (i3 > -1 || G == i3) ? 0 : 10002;
        }
        return invokeL.intValue;
    }

    public final boolean a0(@NonNull hb4 hb4Var, ac3 ac3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, hb4Var, ac3Var)) == null) {
            String appId = getAppId();
            if (ac3Var != null && SwanAppNetworkUtils.i(oj2.c()) && cl2.b().f(appId)) {
                hx1.k("SwanPkgMaintainer", "checkGetPkgResult appId=" + appId + " errCode=" + ac3Var.a());
                if (ac3Var.h() == 2101) {
                    cl2.b().a(appId);
                    mt2.p("startup").F(new UbcFlowEvent("pkg_download_retry"));
                    f0(hb4Var, true, ac3Var);
                    return true;
                } else if (ac3Var.h() == 2205) {
                    t82.c().d().u(le3.a(appId), true, 12);
                    cl2.b().a(appId);
                    mt2.p("startup").F(new UbcFlowEvent("pkg_download_retry"));
                    f0(hb4Var, true, ac3Var);
                    return true;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final void b0(String str, String str2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048592, this, str, str2, i2) == null) {
            Bundle bundle = new Bundle();
            bundle.putInt(str, i2);
            g03.K().v(str2, bundle);
        }
    }

    public final void c0(PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048593, this, pMSAppInfo) == null) || pMSAppInfo == null) {
            return;
        }
        l03.a aVar = (l03.a) ((l03.a) new l03.a("event_on_app_icon_update").z("mAppId", getAppId())).w("appFrameType", pMSAppInfo.appCategory);
        if (n) {
            p0("dispatchPmsInfo appCategory=" + pMSAppInfo.appCategory);
        }
        if (!TextUtils.isEmpty(pMSAppInfo.appName)) {
            if (n) {
                p0("dispatchPmsInfo appName=" + pMSAppInfo.appName);
            }
            aVar.z("app_name", pMSAppInfo.appName);
        }
        if (pMSAppInfo.versionCode > -1) {
            if (n) {
                p0("dispatchPmsInfo versionCode=" + pMSAppInfo.versionCode);
            }
            aVar.x(com.xiaomi.mipush.sdk.Constants.EXTRA_KEY_APP_VERSION_CODE, pMSAppInfo.versionCode);
        }
        if (!TextUtils.isEmpty(pMSAppInfo.iconUrl)) {
            if (n) {
                p0("dispatchPmsInfo iconUrl=" + pMSAppInfo.iconUrl);
            }
            aVar.z("app_icon_url", pMSAppInfo.iconUrl);
        }
        aVar.w("app_pay_protected", pMSAppInfo.payProtected);
        aVar.t("event_flag_force_post", true);
        A(aVar);
    }

    public final synchronized void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            synchronized (this) {
                this.h = 99;
                b0("KEY_PKG_STATE", "event_pms_check_start", 99);
                el2.a W = this.j.W();
                if (!gw2.H() && TextUtils.isEmpty(W.g0()) && ((!n || !W.n0()) && !W.p0())) {
                    String V = W.V();
                    this.k = V;
                    if (n) {
                        ml2.d(V).f("start");
                    }
                    mi2.d("1");
                    HybridUbcFlow p = mt2.p("startup");
                    p.E("type", "1");
                    p.D("is_updating", String.valueOf(yy1.a().b()));
                    p.F(new UbcFlowEvent("na_query_db_start"));
                    PMSAppInfo f0 = this.j.W().f0();
                    if (f0 == null || f0.isMaxAgeExpires()) {
                        f0 = c84.i().u(getAppId());
                    }
                    p.F(new UbcFlowEvent("na_query_db"));
                    boolean e2 = ol2.e(f0);
                    this.l = e2;
                    this.e = (f0 == null || e2) ? false : true;
                    UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("has_local_file");
                    ubcFlowEvent.a(true);
                    p.F(ubcFlowEvent);
                    if (this.l) {
                        N0(f0, p);
                    }
                    if (!this.l && ol2.f(f0, W.e0())) {
                        N0(f0, p);
                        D0();
                    } else {
                        L0();
                    }
                    return;
                }
                t0(true);
            }
        }
    }

    public final void e0(@NonNull String str, @NonNull nw2 nw2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048595, this, str, nw2Var) == null) {
            cx2 Q = cx2.Q();
            if (Q == null) {
                kw2 kw2Var = new kw2(nw2Var.b());
                Bundle bundle = new Bundle();
                bundle.putBoolean("isDownloading", false);
                kw2Var.setResult(bundle);
                nw2Var.onEvent(kw2Var);
                return;
            }
            Bundle bundle2 = new Bundle();
            bundle2.putString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, str);
            Q.X(bundle2, l.class, nw2Var);
        }
    }

    public final void f0(@NonNull hb4 hb4Var, boolean z, @Nullable ac3 ac3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{hb4Var, Boolean.valueOf(z), ac3Var}) == null) {
            HybridUbcFlow p = mt2.p("startup");
            hb4Var.v(z ? 1L : 0L);
            j jVar = new j(this, this.j, z);
            jVar.e0(new i(this, p));
            jVar.g0(new h(this, z, hb4Var, p));
            jVar.L(this.i ? 2 : 1);
            if (z && ac3Var != null) {
                hb4Var.p(ac3Var.h());
            }
            p74.c(hb4Var, jVar);
        }
    }

    public final void g0(Set<eb4.a> set) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, set) == null) {
            eb4 eb4Var = new eb4(set);
            eb4Var.d("3");
            g gVar = new g(this);
            gVar.L(this.i ? 2 : 1);
            p74.d(eb4Var, gVar);
        }
    }

    public final ac3 h0(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048598, this, i2)) == null) {
            ac3 ac3Var = new ac3();
            switch (i2) {
                case 10001:
                    ac3Var.k(10L);
                    ac3Var.i(2902L);
                    ac3Var.f("no aiapps info in database");
                    break;
                case 10002:
                    ac3Var.k(10L);
                    ac3Var.i(27L);
                    ac3Var.f("category not match");
                    break;
                case 10003:
                    ac3Var.k(10L);
                    ac3Var.i(2107L);
                    ac3Var.d("app forbiddeon");
                    break;
                case 10004:
                    ac3Var.k(10L);
                    ac3Var.i(48L);
                    ac3Var.d("path forbiddeon");
                    break;
            }
            return ac3Var;
        }
        return (ac3) invokeI.objValue;
    }

    public el2 j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.j.W() : (el2) invokeV.objValue;
    }

    public final boolean k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? g03.K().q().W().d("property_web_mode_degrade") : invokeV.booleanValue;
    }

    public synchronized boolean l0() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            synchronized (this) {
                z = this.b;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public synchronized boolean m0() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            synchronized (this) {
                z = this.d;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public synchronized void q0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            synchronized (this) {
                if (SwanAppProcessInfo.current().isSwanAppProcess() && this.j.c && !l0() && !m0()) {
                    boolean z = true;
                    this.b = true;
                    HybridUbcFlow p = mt2.p("startup");
                    UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("maintain_start");
                    ubcFlowEvent.a(true);
                    p.F(ubcFlowEvent);
                    if (1 != this.j.W().G()) {
                        z = false;
                    }
                    if (z || !b72.U().m0()) {
                        p("event_on_still_maintaining");
                    }
                    if (z) {
                        x0();
                    } else {
                        d0();
                    }
                }
            }
        }
    }

    public final boolean r0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            HybridUbcFlow p = mt2.p("startup");
            PMSAppInfo pMSAppInfo = this.m;
            if (pMSAppInfo == null) {
                if (n) {
                    Log.i("SwanPkgMaintainer", "AppInfo 为空，走Server同步下载");
                }
                p.D("launch_state", String.valueOf(0));
                b0("KEY_PMS_UPDATE_TYPE", "event_pms_check_start", 0);
                return true;
            } else if (pMSAppInfo.appStatus != 0) {
                if (n) {
                    Log.i("SwanPkgMaintainer", "有错误code，走Server同步下载");
                }
                this.e = true;
                p.D("launch_state", String.valueOf(2));
                b0("KEY_PMS_UPDATE_TYPE", "event_pms_check_start", 2);
                return true;
            } else if (pMSAppInfo.hasPendingErrCode()) {
                if (n) {
                    Log.i("SwanPkgMaintainer", "有悬而未决的的errCode要处理，走Server同步下载");
                }
                this.e = true;
                p.D("launch_state", String.valueOf(2));
                b0("KEY_PMS_UPDATE_TYPE", "event_pms_check_start", 2);
                return true;
            } else if (this.m.isMaxAgeExpires()) {
                if (yy1.a().c(getAppId())) {
                    if (n) {
                        Log.i("SwanPkgMaintainer", "MaxAge已过期，但5小时内已通过SilentUpdateManager检测无新包，id =" + getAppId());
                    }
                    p.D("launch_state", String.valueOf(3));
                    b0("KEY_PMS_UPDATE_TYPE", "event_pms_check_start", 3);
                    return false;
                }
                if (n) {
                    Log.i("SwanPkgMaintainer", "本地包已过期");
                }
                b0("KEY_PMS_UPDATE_TYPE", "event_pms_check_start", 1);
                p.D("launch_state", String.valueOf(1));
                this.i = true;
                return true;
            } else {
                p.D("launch_state", String.valueOf(4));
                b0("KEY_PMS_UPDATE_TYPE", "event_pms_check_start", 4);
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public synchronized void s0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            synchronized (this) {
                v0(true, null);
            }
        }
    }

    public final synchronized void t0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048606, this, z) == null) {
            synchronized (this) {
                this.b = false;
                this.d = z;
                this.m = null;
                if (uz1.b.a()) {
                    this.j.J0(true);
                }
                if (n) {
                    p0("notifyMaintainFinish: " + z);
                }
                if (q() == g03.K().q()) {
                    A((l03.a) new l03.a("event_on_pkg_maintain_finish").z("mAppId", this.j.b));
                }
                if (n) {
                    ml2.d(this.k).h();
                }
                this.k = "";
            }
        }
    }

    public synchronized void u0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            synchronized (this) {
                v0(false, null);
            }
        }
    }

    public synchronized void v0(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048608, this, z, str) == null) {
            synchronized (this) {
                this.b = false;
                this.d = true;
                this.m = null;
                if (this.j != null) {
                    this.j.J0(true);
                    hx1.i("SwanPkgMaintainer", "swan/web, notifyWebModeStart: true");
                    l03.a aVar = (l03.a) new l03.a("event_on_web_mode_launched").z("mAppId", this.j.b);
                    if (!TextUtils.isEmpty(str)) {
                        aVar.z("property_launch_url", str);
                    }
                    A(aVar);
                    a73.V(z, str);
                }
                if (n) {
                    ml2.d(this.k).h();
                }
                this.k = "";
            }
        }
    }

    public int w0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.h : invokeV.intValue;
    }

    public final synchronized void x0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            synchronized (this) {
                HybridUbcFlow p = mt2.p("startup");
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("postExec-onhold");
                ubcFlowEvent.a(true);
                p.F(ubcFlowEvent);
                g03.M().post(new c(this, p));
            }
        }
    }

    public final void z0(boolean z, String str, ac3 ac3Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048611, this, new Object[]{Boolean.valueOf(z), str, ac3Var}) == null) || this.m == null) {
            return;
        }
        y0(this.m, getContext(), j0(), z, str, ac3Var);
    }
}
