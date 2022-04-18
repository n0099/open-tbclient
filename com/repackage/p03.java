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
import com.baidu.swan.apps.SwanAppErrorActivity;
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
import com.kwad.v8.NodeJS;
import com.repackage.gb4;
import com.repackage.gl2;
import com.repackage.n03;
import com.repackage.wz1;
import java.io.File;
import java.util.Locale;
import java.util.Set;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public final class p03 extends r03 implements da2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean n;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean b;
    public boolean c;
    public boolean d;
    public boolean e;
    public boolean f;
    public Set<gb4.a> g;
    public int h;
    public boolean i;
    public final j03 j;
    public String k;
    public boolean l;
    public PMSAppInfo m;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(p03 p03Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p03Var};
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
                i03.J().o("flag_finish_activity", "flag_remove_task");
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gl2 a;
        public final /* synthetic */ int b;

        public b(p03 p03Var, gl2 gl2Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p03Var, gl2Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gl2Var;
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
        public final /* synthetic */ p03 b;

        public c(p03 p03Var, HybridUbcFlow hybridUbcFlow) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p03Var, hybridUbcFlow};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = p03Var;
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
                this.b.c0();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Bundle a;
        public final /* synthetic */ p03 b;

        public d(p03 p03Var, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p03Var, bundle};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = p03Var;
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
                bundle.putInt("appFrameType", this.b.i0().G());
                bundle.putString("mAppId", this.b.getAppId());
                if (p03.n) {
                    p03.o0("updateLocalPkgWithAsyncUpdatePkg: swanAsyncUpdate -> 发送异步升级消息");
                }
                zw2 e = zw2.e();
                bx2 bx2Var = new bx2(17, bundle);
                bx2Var.j(5000L);
                e.h(bx2Var);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements g62 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p03 a;

        public e(p03 p03Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p03Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = p03Var;
        }

        @Override // com.repackage.g62
        public void a(PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSAppInfo) == null) {
                HybridUbcFlow p = ot2.p(NodeJS.STARTUP_SCRIPT_NAME);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updatePkgWithPresetCheckUpdate");
                ubcFlowEvent.a(true);
                p.F(ubcFlowEvent);
                this.a.b0(pMSAppInfo);
                UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("updatePkgWithPresetCheckUpdateIcon");
                ubcFlowEvent2.a(true);
                p.F(ubcFlowEvent2);
            }
        }

        @Override // com.repackage.g62
        public void b(PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSAppInfo) == null) {
                this.a.h = 5;
                p03 p03Var = this.a;
                p03Var.a0("KEY_PKG_STATE", "event_pms_check_finish", p03Var.h);
                HybridUbcFlow p = ot2.p(NodeJS.STARTUP_SCRIPT_NAME);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updatePkgWithPresetCheck#OnSuccessStart");
                ubcFlowEvent.a(true);
                p.F(ubcFlowEvent);
                if (p03.n) {
                    p03.o0("预制包安装成功");
                }
                p03.n0(this.a.i0(), pMSAppInfo, false, false);
                this.a.L0(pMSAppInfo);
                this.a.H0(null);
                UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("updatePkgWithPresetCheck#OnSuccessEnd");
                ubcFlowEvent2.a(true);
                p.F(ubcFlowEvent2);
            }
        }

        @Override // com.repackage.g62
        public void onFailed(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
                HybridUbcFlow p = ot2.p(NodeJS.STARTUP_SCRIPT_NAME);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updatePkgWithPresetCheck#OnFailedStart");
                ubcFlowEvent.a(true);
                p.F(ubcFlowEvent);
                if (p03.n) {
                    p03.o0("预制包安装失败");
                }
                this.a.J0();
                UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("updatePkgWithPresetCheck#OnonFailedEnd");
                ubcFlowEvent2.a(true);
                p.F(ubcFlowEvent2);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f extends pw2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gl2 c;
        public final /* synthetic */ p03 d;

        public f(p03 p03Var, gl2 gl2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p03Var, gl2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = p03Var;
            this.c = gl2Var;
        }

        @Override // com.repackage.pw2, com.repackage.ow2
        public long a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 1000L;
            }
            return invokeV.longValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.pw2, com.repackage.qw2, com.repackage.ow2
        public void onEvent(@NonNull mw2 mw2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mw2Var) == null) {
                Bundle a = mw2Var.a();
                p03.n0(this.c, this.d.m, true, a != null ? a.getBoolean("isDownloading", false) : false);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g extends h32 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p03 h;

        public g(p03 p03Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p03Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.h = p03Var;
        }

        @Override // com.repackage.h32, com.repackage.c84
        public void H(pd4 pd4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pd4Var) == null) {
                this.h.c = true;
                i03.J().q("event_pkg_download_start");
                super.H(pd4Var);
            }
        }

        @Override // com.repackage.h32
        public void R(@NonNull cc3 cc3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cc3Var) == null) {
                gc3.a().f(cc3Var);
                this.h.z0(cc3Var);
                this.h.s0(false);
            }
        }

        @Override // com.repackage.h32
        public void S() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.h.c = false;
                p03.n0(this.h.i0(), this.h.m, false, false);
                p03 p03Var = this.h;
                p03Var.h = p03Var.i ? 3 : 4;
                this.h.H0(null);
                p03 p03Var2 = this.h;
                p03Var2.a0("KEY_PKG_STATE", "event_pms_check_finish", p03Var2.h);
            }
        }

        @Override // com.repackage.h32, com.repackage.c84, com.repackage.z74
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.h.c = false;
                i03.J().q("event_pkg_download_finish");
                super.b();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h implements s32 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ jb4 b;
        public final /* synthetic */ HybridUbcFlow c;
        public final /* synthetic */ p03 d;

        public h(p03 p03Var, boolean z, jb4 jb4Var, HybridUbcFlow hybridUbcFlow) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p03Var, Boolean.valueOf(z), jb4Var, hybridUbcFlow};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = p03Var;
            this.a = z;
            this.b = jb4Var;
            this.c = hybridUbcFlow;
        }

        @Override // com.repackage.s32
        public void a(cc3 cc3Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, cc3Var, z) == null) {
                long a = cc3Var == null ? 0L : cc3Var.a();
                jx1.k("SwanPkgMaintainer", "mFlagDownloading reset onFinalFailed isRetry = " + this.a + ",code =" + a);
                if (this.a) {
                    c73.L("pkg_retry_fail", String.valueOf(a));
                }
                if (this.d.Z(this.b, cc3Var)) {
                    return;
                }
                this.d.c = false;
                i03.J().q("event_pkg_download_finish");
                HybridUbcFlow hybridUbcFlow = this.c;
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onFinalFailedStart");
                ubcFlowEvent.a(true);
                hybridUbcFlow.F(ubcFlowEvent);
                gc3.a().f(cc3Var);
                if (z) {
                    p03 p03Var = this.d;
                    p03Var.h = p03Var.i ? 3 : 4;
                    p03 p03Var2 = this.d;
                    p03Var2.a0("KEY_PKG_STATE", "event_pms_check_finish", p03Var2.h);
                    this.d.G0(cc3Var);
                } else if (cc3Var != null && cc3Var.h() == 1020) {
                    this.d.z0(cc3Var);
                }
                HybridUbcFlow hybridUbcFlow2 = this.c;
                UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onFinalFailedEnd");
                ubcFlowEvent2.a(true);
                hybridUbcFlow2.F(ubcFlowEvent2);
                if (cc3Var == null || cc3Var.h() != 2203) {
                    return;
                }
                jx1.k("SwanPkgMaintainer", "recoverPlatform for errorCode 2203");
                if (h92.a().b(1) == 0) {
                    h92.a().c();
                }
            }
        }

        @Override // com.repackage.s32
        public void b(PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSAppInfo) == null) {
                jx1.k("SwanPkgMaintainer", "mFlagDownloading reset onFinalComplete isRetry = " + this.a);
                if (this.a) {
                    c73.L("pkg_retry_success", "");
                }
                this.d.c = false;
                p03 p03Var = this.d;
                p03Var.h = p03Var.e ? 2 : 0;
                p03 p03Var2 = this.d;
                p03Var2.h = p03Var2.i ? 1 : this.d.h;
                p03 p03Var3 = this.d;
                p03Var3.a0("KEY_PKG_STATE", "event_pms_check_finish", p03Var3.h);
                HybridUbcFlow hybridUbcFlow = this.c;
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onFinalCompleteStart");
                ubcFlowEvent.a(true);
                hybridUbcFlow.F(ubcFlowEvent);
                this.d.L0(pMSAppInfo);
                this.d.E0(null);
                HybridUbcFlow hybridUbcFlow2 = this.c;
                UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onFinalCompleteEnd");
                ubcFlowEvent2.a(true);
                hybridUbcFlow2.F(ubcFlowEvent2);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i implements cf3<PMSAppInfo> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HybridUbcFlow a;
        public final /* synthetic */ p03 b;

        public i(p03 p03Var, HybridUbcFlow hybridUbcFlow) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p03Var, hybridUbcFlow};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = p03Var;
            this.a = hybridUbcFlow;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.cf3
        /* renamed from: a */
        public void onCallback(PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSAppInfo) == null) {
                HybridUbcFlow hybridUbcFlow = this.a;
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onAppInfoReceivedStart");
                ubcFlowEvent.a(true);
                hybridUbcFlow.F(ubcFlowEvent);
                if (p03.n) {
                    p03.o0("onAppInfoReceived appInfo=" + pMSAppInfo);
                }
                this.b.L0(pMSAppInfo);
                this.b.b0(pMSAppInfo);
                HybridUbcFlow hybridUbcFlow2 = this.a;
                UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onAppInfoReceivedEnd");
                ubcFlowEvent2.a(true);
                hybridUbcFlow2.F(ubcFlowEvent2);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class j extends k32 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean G;
        public final /* synthetic */ p03 H;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(p03 p03Var, j03 j03Var, boolean z) {
            super(j03Var);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p03Var, j03Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((j03) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.H = p03Var;
            this.G = z;
        }

        @Override // com.repackage.k32, com.repackage.j32, com.repackage.c84
        public void H(pd4 pd4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pd4Var) == null) {
                jx1.k("SwanPkgMaintainer", "mFlagDownloading set onPrepareDownload isRetry = " + this.G);
                this.H.c = true;
                i03.J().q("event_pkg_download_start");
                super.H(pd4Var);
            }
        }

        @Override // com.repackage.c84, com.repackage.z74
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                jx1.k("SwanPkgMaintainer", "mFlagDownloading reset onTotalPkgDownloadFinish isRetry = " + this.G);
                this.H.c = false;
                i03.J().q("event_pkg_download_finish");
                super.b();
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class k implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m73 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;

        public k(m73 m73Var, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m73Var, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = m73Var;
            this.b = str;
            this.c = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                p03.m0(this.a, this.b, this.c);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class l extends jw2 {
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

        @Override // com.repackage.jw2
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
                boolean j = r74.j(string);
                boolean k = r74.k(string);
                if (jw2.e) {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755463778, "Lcom/repackage/p03;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755463778, "Lcom/repackage/p03;");
                return;
            }
        }
        n = tg1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p03(j03 j03Var) {
        super(j03Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {j03Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((m03) newInitContext.callArgs[0]);
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
        this.j = j03Var;
    }

    private Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65555, this)) == null) {
            SwanAppActivity x = this.j.x();
            return (x == null || x.isDestroyed()) ? qj2.c() : x;
        }
        return (Context) invokeV.objValue;
    }

    public static String h0(Context context, cc3 cc3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65556, null, context, cc3Var)) == null) ? String.format(context.getResources().getString(R.string.obfuscated_res_0x7f0f019b), de3.D(), o93.i(wl2.U().M(), i03.J().r().l()), String.valueOf(cc3Var.a())) : (String) invokeLL.objValue;
    }

    public static void m0(m73 m73Var, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65557, null, m73Var, str, str2) == null) {
            JSONObject k2 = c73.k(str);
            m73Var.d(str2);
            m73Var.b(k2);
            c73.onEvent(m73Var);
        }
    }

    public static void n0(jl2 jl2Var, PMSAppInfo pMSAppInfo, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65558, null, new Object[]{jl2Var, pMSAppInfo, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (n) {
                Log.d("SwanPkgMaintainer", "SwanPkgMaintainer#launchStatistic");
            }
            jl2Var.s0().putString("aiapp_extra_need_download", z ? "1" : "0");
            jl2Var.s0().putString("aiapp_extra_pkg_downloading", z2 ? "1" : "0");
            m73 m73Var = new m73();
            m73Var.a = c73.n(jl2Var.G());
            m73Var.h(jl2Var);
            m73Var.b = "launch";
            m73Var.o = z ? "1" : "0";
            if (pMSAppInfo != null) {
                m73Var.l = String.valueOf(pMSAppInfo.versionCode);
            }
            cu2.e().d(new k(m73Var, jl2Var.W(), jl2Var.s0().getString(UBCCloudControlProcessor.UBC_KEY)), "launchStatistic", true);
        }
    }

    public static void o0(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65559, null, str) == null) && n) {
            Log.i("SwanPkgMaintainer", str);
        }
    }

    public static void x0(PMSAppInfo pMSAppInfo, Context context, gl2 gl2Var, boolean z, String str, cc3 cc3Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65560, null, new Object[]{pMSAppInfo, context, gl2Var, Boolean.valueOf(z), str, cc3Var}) == null) || pMSAppInfo == null) {
            return;
        }
        ForbiddenInfo forbiddenInfo = new ForbiddenInfo(gl2Var, str, h0(context, cc3Var));
        forbiddenInfo.enableSlidingFlag = -1;
        dl2.l(context, z ? SwanAppErrorActivity.TYPE_PATH_FORBIDDEN : SwanAppErrorActivity.TYPE_APP_FORBIDDEN, cc3Var, forbiddenInfo, gl2Var.D());
        m73 m73Var = new m73();
        m73Var.a = c73.n(gl2Var.G());
        m73Var.b = "launch";
        m73Var.e = "success";
        m73Var.i(gl2Var);
        m73Var.a("status", "2");
        m73Var.d(gl2Var.s0().getString(UBCCloudControlProcessor.UBC_KEY));
        c73.onEvent(m73Var);
    }

    public boolean A0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.c : invokeV.booleanValue;
    }

    public final void B0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            fj2.O(this.j);
        }
    }

    public final void C0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            HybridUbcFlow p = ot2.p(NodeJS.STARTUP_SCRIPT_NAME);
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updateForIndependentPkgStart");
            ubcFlowEvent.a(true);
            p.F(ubcFlowEvent);
            if (n) {
                o0("独立分包启动，本地有包--->打开小程序，异步更新主包");
            }
            gl2 i0 = i0();
            String c2 = ql2.c(this.m, i0.e0());
            i0.F0(true);
            i0.V0(c2);
            Bundle bundle = new Bundle();
            bundle.putLong("pms_update_expect_pkg_ver", this.m.versionCode);
            H0(bundle);
            UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("updateForIndependentPkgEnd");
            ubcFlowEvent2.a(true);
            p.F(ubcFlowEvent2);
        }
    }

    public final int D0(cc3 cc3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, cc3Var)) == null) {
            HybridUbcFlow p = ot2.p(NodeJS.STARTUP_SCRIPT_NAME);
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updateInfoWithFinalCheckStart");
            ubcFlowEvent.a(true);
            p.F(ubcFlowEvent);
            if (n) {
                o0("updateInfoWithFinalCheck: mAppInfo=" + this.m);
            }
            PMSAppInfo pMSAppInfo = this.m;
            if (pMSAppInfo == null) {
                if (cc3Var == null) {
                    cc3Var = new cc3();
                    cc3Var.k(10L);
                    cc3Var.i(2902L);
                    cc3Var.f("no pkg was installed");
                }
                gc3.a().f(cc3Var);
                z0(cc3Var);
                return -1;
            }
            int Y = Y(pMSAppInfo);
            if (cg3.g(cc3Var, Y)) {
                return -2;
            }
            if (Y != 10001 && Y != 10002) {
                F0();
                if (Y != 0) {
                    cc3 g0 = g0(10003);
                    gc3.a().f(g0);
                    y0(false, null, g0);
                    ot2.k(g0);
                    qj2.p0().flush(false);
                    return -1;
                }
                if (!this.f) {
                    Set<gb4.a> i2 = qv2.i(this.m);
                    boolean z = i2 == null || i2.isEmpty();
                    this.f = z;
                    if (!z) {
                        cc3 cc3Var2 = new cc3();
                        cc3Var2.k(17L);
                        cc3Var2.i(2909L);
                        cc3Var2.f("dependent pkg is missing.");
                        gc3.a().f(cc3Var2);
                        z0(cc3Var2);
                        return -1;
                    }
                }
                wl2 U = wl2.U();
                String e0 = r().V().e0();
                if (!TextUtils.isEmpty(e0)) {
                    if (w23.b().a(jq2.d(e0, U.z()))) {
                        cc3 g02 = g0(10004);
                        gc3.a().f(g02);
                        y0(true, w23.b().d(), g02);
                        ot2.k(g02);
                        qj2.p0().flush(false);
                        return -1;
                    }
                }
                return 1;
            }
            if (cc3Var == null) {
                cc3Var = g0(Y);
            }
            gc3.a().f(cc3Var);
            z0(cc3Var);
            return -1;
        }
        return invokeL.intValue;
    }

    public final boolean E0(cc3 cc3Var) {
        InterceptResult invokeL;
        t82 d2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, cc3Var)) == null) {
            HybridUbcFlow p = ot2.p(NodeJS.STARTUP_SCRIPT_NAME);
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updateInstalledPkgWithFinalCheckStart");
            ubcFlowEvent.a(true);
            p.F(ubcFlowEvent);
            if (j0()) {
                return false;
            }
            int D0 = D0(cc3Var);
            if (D0 == -1) {
                jx1.i("SwanPkgMaintainer", "updateInstalledPkgWithFinalCheck by null launchParams");
                s0(false);
                return false;
            } else if (D0 == -2) {
                r0();
                return false;
            } else {
                UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("updateInfoWithFinalCheckOk");
                ubcFlowEvent2.a(true);
                p.F(ubcFlowEvent2);
                gl2.a V = this.j.V();
                SwanCoreVersion j0 = V.j0();
                String str = j0 != null ? j0.swanCoreVersionName : "0";
                if (n) {
                    Log.d("SwanPkgMaintainer", "SwanCoreVersion target string version: " + V.k0() + " ,curSwanVersionName: " + str);
                }
                if (yd3.a(V.k0(), str)) {
                    o93.n(V.G());
                }
                ot2.p(NodeJS.STARTUP_SCRIPT_NAME).D("launch_type", String.valueOf(V.i("host_launch_type")));
                if (V.G() == 0) {
                    B0();
                }
                UbcFlowEvent ubcFlowEvent3 = new UbcFlowEvent("updateInstalledPkgWithFinalCheckEnd");
                ubcFlowEvent3.a(true);
                p.F(ubcFlowEvent3);
                s0(true);
                if (ProcessUtils.isMainProcess() && (d2 = v82.c().d()) != null && d2.m()) {
                    d2.b(getAppId());
                }
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    public final void F0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            gl2.a V = r().V();
            PMSAppInfo pMSAppInfo = this.m;
            boolean z = (pMSAppInfo == null || TextUtils.isEmpty(pMSAppInfo.appId) || !TextUtils.equals(getAppId(), this.m.appId)) ? false : true;
            if (z) {
                V.S0(this.m);
            }
            PMSAppInfo pMSAppInfo2 = this.m;
            if (pMSAppInfo2 != null) {
                int i2 = (z && pMSAppInfo2.appCategory == 1) ? 1 : 0;
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    V.u0(i2);
                } else {
                    de3.e0(new b(this, V, i2));
                }
            }
        }
    }

    public final void G0(cc3 cc3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, cc3Var) == null) && E0(cc3Var)) {
            k73 k73Var = new k73();
            k73Var.p(cc3Var);
            k73Var.r(i0());
            c73.R(k73Var);
        }
    }

    public final void H0(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bundle) == null) {
            HybridUbcFlow p = ot2.p(NodeJS.STARTUP_SCRIPT_NAME);
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updateLocalPkgWithAsyncUpdatePkgStart");
            ubcFlowEvent.a(true);
            p.F(ubcFlowEvent);
            if (n) {
                o0("启动本地包，进程预处理-加载本地包-后台异步更新");
            }
            E0(null);
            bu2.j().i(new d(this, bundle));
            UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("updateLocalPkgWithAsyncUpdatePkgEnd");
            ubcFlowEvent2.a(true);
            p.F(ubcFlowEvent2);
        }
    }

    public void I0(Set<gb4.a> set) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, set) == null) {
            this.g = set;
            if (set == null || set.isEmpty()) {
                this.f = true;
            }
        }
    }

    public final void J0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            i03.J().q("event_pms_check_start");
            HybridUbcFlow p = ot2.p(NodeJS.STARTUP_SCRIPT_NAME);
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updatePkgOnPresetUnavailableStart");
            boolean z = true;
            ubcFlowEvent.a(true);
            p.F(ubcFlowEvent);
            gl2 i0 = i0();
            if (n) {
                o0("预置包不可用");
            }
            boolean q0 = q0();
            if (n) {
                Log.i("SwanPkgMaintainer", "updatePkgOnPresetUnavailable: isNeedFetchPkg " + q0);
            }
            if (!q0) {
                if (!this.f) {
                    Set<gb4.a> set = this.g;
                    if (set == null || set.isEmpty()) {
                        this.g = qv2.i(this.m);
                    }
                    Set<gb4.a> set2 = this.g;
                    if (set2 != null && !set2.isEmpty()) {
                        z = false;
                    }
                    this.f = z;
                    if (!z) {
                        f0(this.g);
                        this.g = null;
                        return;
                    }
                }
                if (n) {
                    o0("可以直接打开小程序，异步从Server拉取新包");
                }
                this.h = 4;
                n0(i0, this.m, false, false);
                this.h = this.i ? 3 : 4;
                H0(null);
                a0("KEY_PKG_STATE", "event_pms_check_finish", this.h);
                return;
            }
            if (n) {
                o0("不能直接打开小程序，同步从Server拉取新包");
            }
            a0("KEY_PKG_STATE", "event_pms_check_finish", this.h);
            d0(this.j.V().H(), new f(this, i0));
            String appId = getAppId();
            jb4 jb4Var = new jb4(appId, i0.G());
            jb4Var.d("3");
            PMSAppInfo pMSAppInfo = this.m;
            jb4Var.u(pMSAppInfo == null ? 0L : pMSAppInfo.versionCode);
            PMSAppInfo pMSAppInfo2 = this.m;
            jb4Var.o(pMSAppInfo2 != null ? pMSAppInfo2.appSign : 0L);
            String f2 = be3.f(i0.e0());
            if (!TextUtils.isEmpty(f2)) {
                if (f2.startsWith(File.separator)) {
                    f2 = f2.substring(1);
                }
                jb4Var.t(f2);
            }
            UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("updatePkgOnPresetUnavailableRequest");
            ubcFlowEvent2.a(true);
            p.F(ubcFlowEvent2);
            A((n03.a) new n03.a("event_on_still_maintaining").t(" event_params_pkg_update", this.l));
            el2.b().g(appId);
            e0(jb4Var, false, null);
            UbcFlowEvent ubcFlowEvent3 = new UbcFlowEvent("updatePkgOnPresetUnavailableReturn");
            ubcFlowEvent3.a(true);
            p.F(ubcFlowEvent3);
        }
    }

    public final void K0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            HybridUbcFlow p = ot2.p(NodeJS.STARTUP_SCRIPT_NAME);
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updatePkgWithPresetCheckStart");
            ubcFlowEvent.a(true);
            p.F(ubcFlowEvent);
            if (n) {
                o0(this.m == null ? "数据库或本地无主包信息，尝试加载预置包，并下载主包" : "包信息、文件都存在，尝试加载更高版本的预置包");
            }
            f62 c2 = i62.b().c(getAppId());
            PMSAppInfo pMSAppInfo = this.m;
            long j2 = pMSAppInfo == null ? -1L : pMSAppInfo.versionCode;
            long j3 = c2 != null ? c2.i : -1L;
            boolean z = j3 > j2;
            if (n) {
                o0(String.format(Locale.getDefault(), "尝试加载预制包，命中预制包=%b  currentVersion/presetVersion = %d/%d", Boolean.valueOf(z), Long.valueOf(j2), Long.valueOf(j3)));
            }
            if (!z) {
                J0();
                return;
            }
            q("event_on_still_maintaining");
            UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("updatePkgWithPresetCheckLoadPresetApp");
            ubcFlowEvent2.a(true);
            p.F(ubcFlowEvent2);
            i62.b().e(c2, new e(this));
            UbcFlowEvent ubcFlowEvent3 = new UbcFlowEvent("updatePkgWithPresetCheckReturn");
            ubcFlowEvent3.a(true);
            p.F(ubcFlowEvent3);
        }
    }

    public void L0(PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, pMSAppInfo) == null) {
            this.m = pMSAppInfo;
            this.j.V().c1(pMSAppInfo);
            if (j0()) {
                F0();
                t0();
            }
        }
    }

    public final void M0(PMSAppInfo pMSAppInfo, HybridUbcFlow hybridUbcFlow) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048588, this, pMSAppInfo, hybridUbcFlow) == null) || pMSAppInfo == null || hybridUbcFlow == null) {
            return;
        }
        L0(pMSAppInfo);
        b0(this.m);
        UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("update_icon");
        ubcFlowEvent.a(true);
        hybridUbcFlow.F(ubcFlowEvent);
    }

    public final int Y(@NonNull PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, pMSAppInfo)) == null) {
            int i2 = pMSAppInfo.appStatus;
            if (i2 != 0) {
                return i2;
            }
            int G = i0().G();
            int i3 = pMSAppInfo.appCategory;
            return (i3 > -1 || G == i3) ? 0 : 10002;
        }
        return invokeL.intValue;
    }

    public final boolean Z(@NonNull jb4 jb4Var, cc3 cc3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, jb4Var, cc3Var)) == null) {
            String appId = getAppId();
            if (cc3Var != null && SwanAppNetworkUtils.i(qj2.c()) && el2.b().f(appId)) {
                jx1.k("SwanPkgMaintainer", "checkGetPkgResult appId=" + appId + " errCode=" + cc3Var.a());
                if (cc3Var.h() == 2101) {
                    el2.b().a(appId);
                    ot2.p(NodeJS.STARTUP_SCRIPT_NAME).F(new UbcFlowEvent("pkg_download_retry"));
                    e0(jb4Var, true, cc3Var);
                    return true;
                } else if (cc3Var.h() == 2205) {
                    v82.c().d().u(ne3.a(appId), true, 12);
                    el2.b().a(appId);
                    ot2.p(NodeJS.STARTUP_SCRIPT_NAME).F(new UbcFlowEvent("pkg_download_retry"));
                    e0(jb4Var, true, cc3Var);
                    return true;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final void a0(String str, String str2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048591, this, str, str2, i2) == null) {
            Bundle bundle = new Bundle();
            bundle.putInt(str, i2);
            i03.J().w(str2, bundle);
        }
    }

    public final void b0(PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, pMSAppInfo) == null) || pMSAppInfo == null) {
            return;
        }
        n03.a aVar = (n03.a) ((n03.a) new n03.a("event_on_app_icon_update").z("mAppId", getAppId())).w("appFrameType", pMSAppInfo.appCategory);
        if (n) {
            o0("dispatchPmsInfo appCategory=" + pMSAppInfo.appCategory);
        }
        if (!TextUtils.isEmpty(pMSAppInfo.appName)) {
            if (n) {
                o0("dispatchPmsInfo appName=" + pMSAppInfo.appName);
            }
            aVar.z("app_name", pMSAppInfo.appName);
        }
        if (pMSAppInfo.versionCode > -1) {
            if (n) {
                o0("dispatchPmsInfo versionCode=" + pMSAppInfo.versionCode);
            }
            aVar.x(com.xiaomi.mipush.sdk.Constants.EXTRA_KEY_APP_VERSION_CODE, pMSAppInfo.versionCode);
        }
        if (!TextUtils.isEmpty(pMSAppInfo.iconUrl)) {
            if (n) {
                o0("dispatchPmsInfo iconUrl=" + pMSAppInfo.iconUrl);
            }
            aVar.z("app_icon_url", pMSAppInfo.iconUrl);
        }
        aVar.w("app_pay_protected", pMSAppInfo.payProtected);
        aVar.t("event_flag_force_post", true);
        A(aVar);
    }

    public final synchronized void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            synchronized (this) {
                this.h = 99;
                a0("KEY_PKG_STATE", "event_pms_check_start", 99);
                gl2.a V = this.j.V();
                if (!iw2.H() && TextUtils.isEmpty(V.g0()) && ((!n || !V.n0()) && !V.p0())) {
                    String V2 = V.V();
                    this.k = V2;
                    if (n) {
                        ol2.d(V2).f("start");
                    }
                    oi2.d("1");
                    HybridUbcFlow p = ot2.p(NodeJS.STARTUP_SCRIPT_NAME);
                    p.E("type", "1");
                    p.D("is_updating", String.valueOf(az1.a().b()));
                    p.F(new UbcFlowEvent("na_query_db_start"));
                    PMSAppInfo f0 = this.j.V().f0();
                    if (f0 == null || f0.isMaxAgeExpires()) {
                        f0 = e84.i().u(getAppId());
                    }
                    p.F(new UbcFlowEvent("na_query_db"));
                    boolean e2 = ql2.e(f0);
                    this.l = e2;
                    this.e = (f0 == null || e2) ? false : true;
                    UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("has_local_file");
                    ubcFlowEvent.a(true);
                    p.F(ubcFlowEvent);
                    if (this.l) {
                        M0(f0, p);
                    }
                    if (!this.l && ql2.f(f0, V.e0())) {
                        M0(f0, p);
                        C0();
                    } else {
                        K0();
                    }
                    return;
                }
                s0(true);
            }
        }
    }

    public final void d0(@NonNull String str, @NonNull pw2 pw2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048594, this, str, pw2Var) == null) {
            ex2 P = ex2.P();
            if (P == null) {
                mw2 mw2Var = new mw2(pw2Var.b());
                Bundle bundle = new Bundle();
                bundle.putBoolean("isDownloading", false);
                mw2Var.setResult(bundle);
                pw2Var.onEvent(mw2Var);
                return;
            }
            Bundle bundle2 = new Bundle();
            bundle2.putString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, str);
            P.W(bundle2, l.class, pw2Var);
        }
    }

    public final void e0(@NonNull jb4 jb4Var, boolean z, @Nullable cc3 cc3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{jb4Var, Boolean.valueOf(z), cc3Var}) == null) {
            HybridUbcFlow p = ot2.p(NodeJS.STARTUP_SCRIPT_NAME);
            jb4Var.v(z ? 1L : 0L);
            j jVar = new j(this, this.j, z);
            jVar.f0(new i(this, p));
            jVar.h0(new h(this, z, jb4Var, p));
            jVar.M(this.i ? 2 : 1);
            if (z && cc3Var != null) {
                jb4Var.p(cc3Var.h());
            }
            r74.c(jb4Var, jVar);
        }
    }

    public final void f0(Set<gb4.a> set) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, set) == null) {
            gb4 gb4Var = new gb4(set);
            gb4Var.d("3");
            g gVar = new g(this);
            gVar.M(this.i ? 2 : 1);
            r74.d(gb4Var, gVar);
        }
    }

    public final cc3 g0(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048597, this, i2)) == null) {
            cc3 cc3Var = new cc3();
            switch (i2) {
                case 10001:
                    cc3Var.k(10L);
                    cc3Var.i(2902L);
                    cc3Var.f("no aiapps info in database");
                    break;
                case 10002:
                    cc3Var.k(10L);
                    cc3Var.i(27L);
                    cc3Var.f("category not match");
                    break;
                case 10003:
                    cc3Var.k(10L);
                    cc3Var.i(2107L);
                    cc3Var.d("app forbiddeon");
                    break;
                case 10004:
                    cc3Var.k(10L);
                    cc3Var.i(48L);
                    cc3Var.d("path forbiddeon");
                    break;
            }
            return cc3Var;
        }
        return (cc3) invokeI.objValue;
    }

    public gl2 i0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.j.V() : (gl2) invokeV.objValue;
    }

    public final boolean j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? i03.J().r().V().d("property_web_mode_degrade") : invokeV.booleanValue;
    }

    public synchronized boolean k0() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            synchronized (this) {
                z = this.b;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public synchronized boolean l0() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            synchronized (this) {
                z = this.d;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public synchronized void p0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            synchronized (this) {
                if (SwanAppProcessInfo.current().isSwanAppProcess() && this.j.c && !k0() && !l0()) {
                    boolean z = true;
                    this.b = true;
                    HybridUbcFlow p = ot2.p(NodeJS.STARTUP_SCRIPT_NAME);
                    UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("maintain_start");
                    ubcFlowEvent.a(true);
                    p.F(ubcFlowEvent);
                    if (1 != this.j.V().G()) {
                        z = false;
                    }
                    if (z || !d72.U().m0()) {
                        q("event_on_still_maintaining");
                    }
                    if (z) {
                        w0();
                    } else {
                        c0();
                    }
                }
            }
        }
    }

    public final boolean q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            HybridUbcFlow p = ot2.p(NodeJS.STARTUP_SCRIPT_NAME);
            PMSAppInfo pMSAppInfo = this.m;
            if (pMSAppInfo == null) {
                if (n) {
                    Log.i("SwanPkgMaintainer", "AppInfo 为空，走Server同步下载");
                }
                p.D("launch_state", String.valueOf(0));
                a0("KEY_PMS_UPDATE_TYPE", "event_pms_check_start", 0);
                return true;
            } else if (pMSAppInfo.appStatus != 0) {
                if (n) {
                    Log.i("SwanPkgMaintainer", "有错误code，走Server同步下载");
                }
                this.e = true;
                p.D("launch_state", String.valueOf(2));
                a0("KEY_PMS_UPDATE_TYPE", "event_pms_check_start", 2);
                return true;
            } else if (pMSAppInfo.hasPendingErrCode()) {
                if (n) {
                    Log.i("SwanPkgMaintainer", "有悬而未决的的errCode要处理，走Server同步下载");
                }
                this.e = true;
                p.D("launch_state", String.valueOf(2));
                a0("KEY_PMS_UPDATE_TYPE", "event_pms_check_start", 2);
                return true;
            } else if (this.m.isMaxAgeExpires()) {
                if (az1.a().c(getAppId())) {
                    if (n) {
                        Log.i("SwanPkgMaintainer", "MaxAge已过期，但5小时内已通过SilentUpdateManager检测无新包，id =" + getAppId());
                    }
                    p.D("launch_state", String.valueOf(3));
                    a0("KEY_PMS_UPDATE_TYPE", "event_pms_check_start", 3);
                    return false;
                }
                if (n) {
                    Log.i("SwanPkgMaintainer", "本地包已过期");
                }
                a0("KEY_PMS_UPDATE_TYPE", "event_pms_check_start", 1);
                p.D("launch_state", String.valueOf(1));
                this.i = true;
                return true;
            } else {
                p.D("launch_state", String.valueOf(4));
                a0("KEY_PMS_UPDATE_TYPE", "event_pms_check_start", 4);
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public synchronized void r0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            synchronized (this) {
                u0(true, null);
            }
        }
    }

    public final synchronized void s0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048605, this, z) == null) {
            synchronized (this) {
                this.b = false;
                this.d = z;
                this.m = null;
                if (wz1.b.a()) {
                    this.j.I0(true);
                }
                if (n) {
                    o0("notifyMaintainFinish: " + z);
                }
                if (r() == i03.J().r()) {
                    A((n03.a) new n03.a("event_on_pkg_maintain_finish").z("mAppId", this.j.b));
                }
                if (n) {
                    ol2.d(this.k).h();
                }
                this.k = "";
            }
        }
    }

    public synchronized void t0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            synchronized (this) {
                u0(false, null);
            }
        }
    }

    public synchronized void u0(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048607, this, z, str) == null) {
            synchronized (this) {
                this.b = false;
                this.d = true;
                this.m = null;
                if (this.j != null) {
                    this.j.I0(true);
                    jx1.i("SwanPkgMaintainer", "swan/web, notifyWebModeStart: true");
                    n03.a aVar = (n03.a) new n03.a("event_on_web_mode_launched").z("mAppId", this.j.b);
                    if (!TextUtils.isEmpty(str)) {
                        aVar.z("property_launch_url", str);
                    }
                    A(aVar);
                    c73.V(z, str);
                }
                if (n) {
                    ol2.d(this.k).h();
                }
                this.k = "";
            }
        }
    }

    public int v0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.h : invokeV.intValue;
    }

    public final synchronized void w0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            synchronized (this) {
                HybridUbcFlow p = ot2.p(NodeJS.STARTUP_SCRIPT_NAME);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("postExec-onhold");
                ubcFlowEvent.a(true);
                p.F(ubcFlowEvent);
                i03.L().post(new c(this, p));
            }
        }
    }

    public final void y0(boolean z, String str, cc3 cc3Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048610, this, new Object[]{Boolean.valueOf(z), str, cc3Var}) == null) || this.m == null) {
            return;
        }
        x0(this.m, getContext(), i0(), z, str, cc3Var);
    }

    public final void z0(cc3 cc3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, cc3Var) == null) {
            ot2.k(cc3Var);
            Context context = getContext();
            if ((context instanceof SwanAppActivity) && !sc3.d((SwanAppActivity) context)) {
                if (n) {
                    Log.d("SwanPkgMaintainer", "launcher activity closed, ignore launch err");
                    return;
                }
                return;
            }
            gl2 i0 = i0();
            int G = i0.G();
            if (!cc3Var.l()) {
                k73 k73Var = new k73();
                k73Var.q(c73.n(G));
                k73Var.p(cc3Var);
                k73Var.m(getAppId());
                k73Var.t(i0.T());
                c73.R(k73Var);
                cc3Var.n();
            }
            if (!xl2.a().b()) {
                if (n) {
                    Log.d("SwanPkgMaintainer", "launcher activity hide, ignore launch err and reset.");
                }
                de3.e0(new a(this));
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("mAppId", i0.H());
            bundle.putAll(i0.D());
            dl2.g(qj2.c(), cc3Var, G, getAppId(), true, bundle);
            t63.m(i0, G, cc3Var);
            qj2.p0().flush(false);
        }
    }
}
