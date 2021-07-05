package d.a.q0.a.a2;

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
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.a2.i;
import d.a.q0.a.f1.e.b;
import d.a.q0.a.v2.l0;
import d.a.q0.a.v2.o0;
import d.a.q0.a.v2.q0;
import java.io.File;
import java.util.Locale;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class k extends m implements d.a.q0.a.n0.l.b {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean q;
    public static final int r;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public boolean f46690f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f46691g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f46692h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f46693i;
    public int j;
    public boolean k;
    public final d.a.q0.a.a2.e l;
    public String m;
    public boolean n;
    public final boolean o;
    public PMSAppInfo p;

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HybridUbcFlow f46694e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ k f46695f;

        public a(k kVar, HybridUbcFlow hybridUbcFlow) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar, hybridUbcFlow};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46695f = kVar;
            this.f46694e = hybridUbcFlow;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                HybridUbcFlow hybridUbcFlow = this.f46694e;
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("postExec-run");
                ubcFlowEvent.a(true);
                hybridUbcFlow.C(ubcFlowEvent);
                this.f46695f.T();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Bundle f46696e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ k f46697f;

        public b(k kVar, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar, bundle};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46697f = kVar;
            this.f46696e = bundle;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Bundle bundle = new Bundle();
                Bundle bundle2 = this.f46696e;
                if (bundle2 != null) {
                    bundle.putAll(bundle2);
                }
                bundle.putInt("appFrameType", this.f46697f.Z().G());
                bundle.putString("mAppId", this.f46697f.getAppId());
                if (k.q) {
                    k.e0("updateLocalPkgWithAsyncUpdatePkg: swanAsyncUpdate -> 发送异步升级消息");
                }
                d.a.q0.a.v1.c.a e2 = d.a.q0.a.v1.c.a.e();
                d.a.q0.a.v1.c.c cVar = new d.a.q0.a.v1.c.c(17, bundle);
                cVar.j(5000L);
                e2.h(cVar);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements d.a.q0.a.h0.r.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ k f46698a;

        public c(k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46698a = kVar;
        }

        @Override // d.a.q0.a.h0.r.d
        public void a(PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSAppInfo) == null) {
                HybridUbcFlow p = d.a.q0.a.r1.h.p("startup");
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updatePkgWithPresetCheckUpdate");
                ubcFlowEvent.a(true);
                p.C(ubcFlowEvent);
                this.f46698a.S(pMSAppInfo);
                UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("updatePkgWithPresetCheckUpdateIcon");
                ubcFlowEvent2.a(true);
                p.C(ubcFlowEvent2);
            }
        }

        @Override // d.a.q0.a.h0.r.d
        public void b(PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSAppInfo) == null) {
                this.f46698a.j = 5;
                k kVar = this.f46698a;
                kVar.R("KEY_PKG_STATE", "event_pms_check_finish", kVar.j);
                HybridUbcFlow p = d.a.q0.a.r1.h.p("startup");
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updatePkgWithPresetCheck#OnSuccessStart");
                ubcFlowEvent.a(true);
                p.C(ubcFlowEvent);
                if (k.q) {
                    k.e0("预制包安装成功");
                }
                k.d0(this.f46698a.Z(), pMSAppInfo, false, false);
                this.f46698a.x0(pMSAppInfo);
                this.f46698a.u0(null);
                UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("updatePkgWithPresetCheck#OnSuccessEnd");
                ubcFlowEvent2.a(true);
                p.C(ubcFlowEvent2);
            }
        }

        @Override // d.a.q0.a.h0.r.d
        public void onFailed(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
                HybridUbcFlow p = d.a.q0.a.r1.h.p("startup");
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updatePkgWithPresetCheck#OnFailedStart");
                ubcFlowEvent.a(true);
                p.C(ubcFlowEvent);
                if (k.q) {
                    k.e0("预制包安装失败");
                }
                this.f46698a.v0();
                UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("updatePkgWithPresetCheck#OnonFailedEnd");
                ubcFlowEvent2.a(true);
                p.C(ubcFlowEvent2);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d extends d.a.q0.a.v1.a.b.c.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.f1.e.b f46699c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ k f46700d;

        public d(k kVar, d.a.q0.a.f1.e.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46700d = kVar;
            this.f46699c = bVar;
        }

        @Override // d.a.q0.a.v1.a.b.c.b, d.a.q0.a.v1.a.b.c.a
        public long a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 1000L;
            }
            return invokeV.longValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.q0.a.v1.a.b.c.b, d.a.q0.a.v1.a.b.c.c, d.a.q0.a.v1.a.b.c.a
        public void onEvent(@NonNull d.a.q0.a.v1.a.b.a.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
                Bundle a2 = bVar.a();
                k.d0(this.f46699c, this.f46700d.p, true, a2 != null ? a2.getBoolean("isDownloading", false) : false);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements d.a.q0.a.h0.m.m.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f46701a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.n.i.m.c f46702b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ HybridUbcFlow f46703c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ k f46704d;

        public e(k kVar, boolean z, d.a.q0.n.i.m.c cVar, HybridUbcFlow hybridUbcFlow) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar, Boolean.valueOf(z), cVar, hybridUbcFlow};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46704d = kVar;
            this.f46701a = z;
            this.f46702b = cVar;
            this.f46703c = hybridUbcFlow;
        }

        @Override // d.a.q0.a.h0.m.m.a
        public void a(d.a.q0.a.q2.a aVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, aVar, z) == null) {
                long a2 = aVar == null ? 0L : aVar.a();
                d.a.q0.a.e0.d.h("SwanPkgMaintainer", "mFlagDownloading reset onFinalFailed isRetry = " + this.f46701a + ",code =" + a2);
                if (this.f46701a) {
                    d.a.q0.a.j2.k.G("pkg_retry_fail", String.valueOf(a2));
                }
                if (this.f46704d.Q(this.f46702b, aVar)) {
                    return;
                }
                this.f46704d.f46691g = false;
                d.a.q0.a.a2.d.g().q("event_pkg_download_finish");
                HybridUbcFlow hybridUbcFlow = this.f46703c;
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onFinalFailedStart");
                ubcFlowEvent.a(true);
                hybridUbcFlow.C(ubcFlowEvent);
                d.a.q0.a.q2.e.a().f(aVar);
                if (z) {
                    k kVar = this.f46704d;
                    kVar.j = kVar.k ? 3 : 4;
                    k kVar2 = this.f46704d;
                    kVar2.R("KEY_PKG_STATE", "event_pms_check_finish", kVar2.j);
                    this.f46704d.t0(aVar);
                } else {
                    if (aVar != null && aVar.g() == 1020) {
                        this.f46704d.m0(aVar);
                    }
                    this.f46704d.h0(false);
                }
                HybridUbcFlow hybridUbcFlow2 = this.f46703c;
                UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onFinalFailedEnd");
                ubcFlowEvent2.a(true);
                hybridUbcFlow2.C(ubcFlowEvent2);
                if (aVar == null || aVar.g() != 2203) {
                    return;
                }
                d.a.q0.a.e0.d.h("SwanPkgMaintainer", "mRecoveryABSwitch = " + this.f46704d.o);
                if (this.f46704d.o && d.a.q0.a.n0.j.c.a().b(1) == 0) {
                    d.a.q0.a.n0.j.c.a().c();
                }
            }
        }

        @Override // d.a.q0.a.h0.m.m.a
        public void b(PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSAppInfo) == null) {
                d.a.q0.a.e0.d.h("SwanPkgMaintainer", "mFlagDownloading reset onFinalComplete isRetry = " + this.f46701a);
                if (this.f46701a) {
                    d.a.q0.a.j2.k.G("pkg_retry_success", "");
                }
                this.f46704d.f46691g = false;
                k kVar = this.f46704d;
                kVar.j = kVar.f46693i ? 2 : 0;
                k kVar2 = this.f46704d;
                kVar2.j = kVar2.k ? 1 : this.f46704d.j;
                k kVar3 = this.f46704d;
                kVar3.R("KEY_PKG_STATE", "event_pms_check_finish", kVar3.j);
                HybridUbcFlow hybridUbcFlow = this.f46703c;
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onFinalCompleteStart");
                ubcFlowEvent.a(true);
                hybridUbcFlow.C(ubcFlowEvent);
                this.f46704d.x0(pMSAppInfo);
                this.f46704d.r0(null);
                HybridUbcFlow hybridUbcFlow2 = this.f46703c;
                UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onFinalCompleteEnd");
                ubcFlowEvent2.a(true);
                hybridUbcFlow2.C(ubcFlowEvent2);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements d.a.q0.a.v2.e1.b<PMSAppInfo> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HybridUbcFlow f46705e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ k f46706f;

        public f(k kVar, HybridUbcFlow hybridUbcFlow) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar, hybridUbcFlow};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46706f = kVar;
            this.f46705e = hybridUbcFlow;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.q0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSAppInfo) == null) {
                HybridUbcFlow hybridUbcFlow = this.f46705e;
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onAppInfoReceivedStart");
                ubcFlowEvent.a(true);
                hybridUbcFlow.C(ubcFlowEvent);
                if (k.q) {
                    k.e0("onAppInfoReceived appInfo=" + pMSAppInfo);
                }
                this.f46706f.x0(pMSAppInfo);
                this.f46706f.S(pMSAppInfo);
                HybridUbcFlow hybridUbcFlow2 = this.f46705e;
                UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onAppInfoReceivedEnd");
                ubcFlowEvent2.a(true);
                hybridUbcFlow2.C(ubcFlowEvent2);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g extends d.a.q0.a.h0.m.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean I;
        public final /* synthetic */ k J;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(k kVar, d.a.q0.a.a2.e eVar, boolean z) {
            super(eVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar, eVar, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((d.a.q0.a.a2.e) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.J = kVar;
            this.I = z;
        }

        @Override // d.a.q0.a.h0.m.g, d.a.q0.a.h0.m.f, d.a.q0.n.f.g
        public void F(d.a.q0.n.o.f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
                d.a.q0.a.e0.d.h("SwanPkgMaintainer", "mFlagDownloading set onPrepareDownload isRetry = " + this.I);
                this.J.f46691g = true;
                d.a.q0.a.a2.d.g().q("event_pkg_download_start");
                super.F(fVar);
            }
        }

        @Override // d.a.q0.n.f.g, d.a.q0.n.f.d
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                d.a.q0.a.e0.d.h("SwanPkgMaintainer", "mFlagDownloading reset onTotalPkgDownloadFinish isRetry = " + this.I);
                this.J.f46691g = false;
                d.a.q0.a.a2.d.g().q("event_pkg_download_finish");
                super.b();
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.j2.p.f f46707e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f46708f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f46709g;

        public h(d.a.q0.a.j2.p.f fVar, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46707e = fVar;
            this.f46708f = str;
            this.f46709g = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                k.c0(this.f46707e, this.f46708f, this.f46709g);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.f1.e.b f46710e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f46711f;

        public i(k kVar, d.a.q0.a.f1.e.b bVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar, bVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46710e = bVar;
            this.f46711f = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f46710e.t0(this.f46711f);
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class j extends d.a.q0.a.v1.a.a.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public j() {
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

        @Override // d.a.q0.a.v1.a.a.a
        public void b(@NonNull Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
                String string = bundle.getString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID);
                boolean z = false;
                if (TextUtils.isEmpty(string)) {
                    this.f51200d.putBoolean("isDownloading", false);
                    c();
                    return;
                }
                boolean h2 = d.a.q0.n.b.h(string);
                boolean i2 = d.a.q0.n.b.i(string);
                if (d.a.q0.a.v1.a.a.a.f51196e) {
                    Log.d("MDelegate-Delegation", "isDownloading: " + h2 + ", isInQueue: " + i2);
                }
                this.f51200d.putBoolean("isDownloading", (h2 || i2) ? true : true);
                c();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(110530101, "Ld/a/q0/a/a2/k;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(110530101, "Ld/a/q0/a/a2/k;");
                return;
            }
        }
        q = d.a.q0.a.k.f49133a;
        d.a.q0.a.c1.a.Z().getSwitch("swan_pms_http_request_retry_replace_net_lib", 0);
        r = 0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(d.a.q0.a.a2.e eVar) {
        super(eVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((d.a.q0.a.a2.h) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f46690f = false;
        this.f46691g = false;
        this.f46692h = false;
        this.f46693i = false;
        this.j = -1;
        this.k = false;
        this.m = "";
        this.n = false;
        d.a.q0.a.c1.a.Z().getSwitch("swan_error_recovery", false);
        this.o = false;
        this.l = eVar;
    }

    public static String Y(Context context, d.a.q0.a.q2.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65550, null, context, aVar)) == null) ? String.format(context.getResources().getString(d.a.q0.a.h.aiapps_open_failed_detail_format), q0.D(), d.a.q0.a.m2.b.i(d.a.q0.a.g1.f.V().N(), d.a.q0.a.a2.d.g().r().l()), String.valueOf(aVar.a())) : (String) invokeLL.objValue;
    }

    public static void c0(d.a.q0.a.j2.p.f fVar, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65551, null, fVar, str, str2) == null) {
            JSONObject k = d.a.q0.a.j2.k.k(str);
            fVar.d(str2);
            fVar.b(k);
            d.a.q0.a.j2.k.onEvent(fVar);
        }
    }

    public static void d0(d.a.q0.a.f1.e.e eVar, PMSAppInfo pMSAppInfo, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65552, null, new Object[]{eVar, pMSAppInfo, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (q) {
                Log.d("SwanPkgMaintainer", "SwanPkgMaintainer#launchStatistic");
            }
            eVar.r0().putString("aiapp_extra_need_download", z ? "1" : "0");
            eVar.r0().putString("aiapp_extra_pkg_downloading", z2 ? "1" : "0");
            d.a.q0.a.j2.p.f fVar = new d.a.q0.a.j2.p.f();
            fVar.f49119a = d.a.q0.a.j2.k.m(eVar.G());
            fVar.h(eVar);
            fVar.f49120b = "launch";
            fVar.o = z ? "1" : "0";
            if (pMSAppInfo != null) {
                fVar.l = String.valueOf(pMSAppInfo.versionCode);
            }
            d.a.q0.a.r1.k.i.c.f().e(new h(fVar, eVar.W(), eVar.r0().getString(UBCCloudControlProcessor.UBC_KEY)), "launchStatistic");
        }
    }

    public static void e0(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65554, null, str) == null) && q) {
            Log.i("SwanPkgMaintainer", str);
        }
    }

    public static void k0(PMSAppInfo pMSAppInfo, Context context, d.a.q0.a.f1.e.b bVar, boolean z, String str, d.a.q0.a.q2.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65561, null, new Object[]{pMSAppInfo, context, bVar, Boolean.valueOf(z), str, aVar}) == null) || pMSAppInfo == null) {
            return;
        }
        if (!d.a.q0.a.c1.a.O().a(context, d.a.q0.a.a2.d.g().r().D(), aVar)) {
            ForbiddenInfo forbiddenInfo = new ForbiddenInfo(bVar, str, Y(context, aVar));
            forbiddenInfo.enableSlidingFlag = -1;
            d.a.q0.a.f1.d.a.k(context, z ? SwanAppErrorActivity.TYPE_PATH_FORBIDDEN : SwanAppErrorActivity.TYPE_APP_FORBIDDEN, bVar.C(), forbiddenInfo);
        }
        d.a.q0.a.j2.p.f fVar = new d.a.q0.a.j2.p.f();
        fVar.f49119a = d.a.q0.a.j2.k.m(bVar.G());
        fVar.f49120b = "launch";
        fVar.f49123e = "success";
        fVar.i(bVar);
        fVar.a("status", "2");
        fVar.d(bVar.r0().getString(UBCCloudControlProcessor.UBC_KEY));
        d.a.q0.a.j2.k.onEvent(fVar);
    }

    public final int P(@NonNull PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, pMSAppInfo)) == null) {
            int i2 = pMSAppInfo.appStatus;
            if (i2 != 0) {
                return i2;
            }
            if (TextUtils.isEmpty(pMSAppInfo.appId)) {
                return 10001;
            }
            int G = Z().G();
            int i3 = pMSAppInfo.appCategory;
            return (i3 > -1 || G == i3) ? 0 : 10002;
        }
        return invokeL.intValue;
    }

    public final boolean Q(@NonNull d.a.q0.n.i.m.c cVar, d.a.q0.a.q2.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar, aVar)) == null) {
            String appId = getAppId();
            if (aVar != null && SwanAppNetworkUtils.i(d.a.q0.a.c1.a.b()) && d.a.q0.a.f1.d.b.a.b().f(appId)) {
                d.a.q0.a.e0.d.h("SwanPkgMaintainer", "checkGetPkgResult appId=" + appId + " errCode=" + aVar.a());
                if (aVar.g() == 2101) {
                    d.a.q0.a.f1.d.b.a.b().a(appId);
                    d.a.q0.a.r1.h.p("startup").C(new UbcFlowEvent("pkg_download_retry"));
                    V(cVar, true, aVar);
                    return true;
                } else if (aVar.g() == 2205) {
                    d.a.q0.a.n0.f.c().d().u(d.a.q0.a.v2.z0.a.a(appId), true, 12);
                    d.a.q0.a.f1.d.b.a.b().a(appId);
                    d.a.q0.a.r1.h.p("startup").C(new UbcFlowEvent("pkg_download_retry"));
                    V(cVar, true, aVar);
                    return true;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final void R(String str, String str2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, str, str2, i2) == null) {
            Bundle bundle = new Bundle();
            bundle.putInt(str, i2);
            d.a.q0.a.a2.d.g().w(str2, bundle);
        }
    }

    public final void S(PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, pMSAppInfo) == null) || pMSAppInfo == null) {
            return;
        }
        i.a aVar = (i.a) ((i.a) new i.a("event_on_app_icon_update").y("mAppId", getAppId())).v("appFrameType", pMSAppInfo.appCategory);
        if (q) {
            e0("dispatchPmsInfo appCategory=" + pMSAppInfo.appCategory);
        }
        if (!TextUtils.isEmpty(pMSAppInfo.appName)) {
            if (q) {
                e0("dispatchPmsInfo appName=" + pMSAppInfo.appName);
            }
            aVar.y("app_name", pMSAppInfo.appName);
        }
        if (pMSAppInfo.versionCode > -1) {
            if (q) {
                e0("dispatchPmsInfo versionCode=" + pMSAppInfo.versionCode);
            }
            aVar.w(com.xiaomi.mipush.sdk.Constants.EXTRA_KEY_APP_VERSION_CODE, pMSAppInfo.versionCode);
        }
        if (!TextUtils.isEmpty(pMSAppInfo.iconUrl)) {
            if (q) {
                e0("dispatchPmsInfo iconUrl=" + pMSAppInfo.iconUrl);
            }
            aVar.y("app_icon_url", pMSAppInfo.iconUrl);
        }
        aVar.v("app_pay_protected", pMSAppInfo.payProtected);
        aVar.s("event_flag_force_post", true);
        A(aVar);
    }

    public final synchronized void T() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            synchronized (this) {
                this.j = 99;
                R("KEY_PKG_STATE", "event_pms_check_start", 99);
                b.a L = this.l.L();
                if (!d.a.q0.a.u1.a.a.G() && TextUtils.isEmpty(L.g0()) && ((!q || !L.m0()) && !L.o0())) {
                    String V = L.V();
                    this.m = V;
                    if (q) {
                        d.a.q0.a.f1.g.a.d(V).f("start");
                    }
                    if (d.a.q0.a.h0.n.a.a.c()) {
                        d.a.q0.a.y0.k.f.b.d("0");
                    } else {
                        d.a.q0.a.y0.k.f.b.e("1");
                    }
                    HybridUbcFlow p = d.a.q0.a.r1.h.p("startup");
                    p.B("type", "1");
                    p.A("is_updating", String.valueOf(d.a.q0.a.h0.c.b.a.a().b()));
                    p.C(new UbcFlowEvent("na_query_db_start"));
                    PMSAppInfo f0 = this.l.L().f0();
                    if (f0 == null || f0.isMaxAgeExpires()) {
                        f0 = d.a.q0.n.g.a.h().s(getAppId());
                    }
                    p.C(new UbcFlowEvent("na_query_db"));
                    boolean e2 = d.a.q0.a.f1.h.a.e(f0);
                    this.n = e2;
                    this.f46693i = (f0 == null || e2) ? false : true;
                    UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("has_local_file");
                    ubcFlowEvent.a(true);
                    p.C(ubcFlowEvent);
                    if (this.n) {
                        y0(f0, p);
                    }
                    if (!this.n && d.a.q0.a.f1.h.a.f(f0, L.e0())) {
                        y0(f0, p);
                        p0();
                    } else {
                        w0();
                    }
                    return;
                }
                h0(true);
            }
        }
    }

    public final void U(@NonNull String str, @NonNull d.a.q0.a.v1.a.b.c.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, str, bVar) == null) {
            d.a.q0.a.v1.c.e.a E = d.a.q0.a.v1.c.e.a.E();
            if (E == null) {
                d.a.q0.a.v1.a.b.a.b bVar2 = new d.a.q0.a.v1.a.b.a.b(bVar.b());
                Bundle bundle = new Bundle();
                bundle.putBoolean("isDownloading", false);
                bVar2.b(bundle);
                bVar.onEvent(bVar2);
                return;
            }
            Bundle bundle2 = new Bundle();
            bundle2.putString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, str);
            E.L(bundle2, j.class, bVar);
        }
    }

    public final void V(@NonNull d.a.q0.n.i.m.c cVar, boolean z, @Nullable d.a.q0.a.q2.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{cVar, Boolean.valueOf(z), aVar}) == null) {
            HybridUbcFlow p = d.a.q0.a.r1.h.p("startup");
            cVar.t(z ? 1L : 0L);
            g gVar = new g(this, this.l, z);
            gVar.b0(new f(this, p));
            gVar.d0(new e(this, z, cVar, p));
            gVar.K(this.k ? 2 : 1);
            if (r == 1 && z && aVar != null && aVar.g() == 2101) {
                d.a.q0.a.e0.d.h("SwanPkgMaintainer", "PMS请求失败后重试时替换网络库");
                d.a.q0.n.b.c(cVar, gVar);
                return;
            }
            d.a.q0.n.b.b(cVar, gVar);
        }
    }

    public final Context W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            SwanAppActivity x = this.l.x();
            return (x == null || x.isDestroyed()) ? d.a.q0.a.c1.a.b() : x;
        }
        return (Context) invokeV.objValue;
    }

    public final d.a.q0.a.q2.a X(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
            d.a.q0.a.q2.a aVar = new d.a.q0.a.q2.a();
            switch (i2) {
                case 10001:
                    aVar.j(10L);
                    aVar.h(2902L);
                    aVar.e("no aiapps info in database");
                    break;
                case 10002:
                    aVar.j(10L);
                    aVar.h(27L);
                    aVar.e("category not match");
                    break;
                case 10003:
                    aVar.j(10L);
                    aVar.h(2107L);
                    aVar.c("app forbiddeon");
                    break;
                case 10004:
                    aVar.j(10L);
                    aVar.h(48L);
                    aVar.c("path forbiddeon");
                    break;
            }
            return aVar;
        }
        return (d.a.q0.a.q2.a) invokeI.objValue;
    }

    public d.a.q0.a.f1.e.b Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.l.L() : (d.a.q0.a.f1.e.b) invokeV.objValue;
    }

    public synchronized boolean a0() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            synchronized (this) {
                z = this.f46690f;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public synchronized boolean b0() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            synchronized (this) {
                z = this.f46692h;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public synchronized void f0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            synchronized (this) {
                if (SwanAppProcessInfo.current().isSwanAppProcess() && this.l.f46684g && !a0() && !b0()) {
                    boolean z = true;
                    this.f46690f = true;
                    HybridUbcFlow p = d.a.q0.a.r1.h.p("startup");
                    UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("maintain_start");
                    ubcFlowEvent.a(true);
                    p.C(ubcFlowEvent);
                    if (1 != this.l.L().G()) {
                        z = false;
                    }
                    if (z || !d.a.q0.a.h0.u.g.N().c0()) {
                        q("event_on_still_maintaining");
                    }
                    if (z) {
                        j0();
                    } else {
                        T();
                    }
                }
            }
        }
    }

    public final boolean g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            HybridUbcFlow p = d.a.q0.a.r1.h.p("startup");
            PMSAppInfo pMSAppInfo = this.p;
            if (pMSAppInfo == null) {
                if (q) {
                    Log.i("SwanPkgMaintainer", "AppInfo 为空，走Server同步下载");
                }
                p.A("launch_state", String.valueOf(0));
                R("KEY_PMS_UPDATE_TYPE", "event_pms_check_start", 0);
                return true;
            } else if (pMSAppInfo.appStatus != 0) {
                if (q) {
                    Log.i("SwanPkgMaintainer", "有错误code，走Server同步下载");
                }
                this.f46693i = true;
                p.A("launch_state", String.valueOf(2));
                R("KEY_PMS_UPDATE_TYPE", "event_pms_check_start", 2);
                return true;
            } else if (pMSAppInfo.hasPendingErrCode()) {
                if (q) {
                    Log.i("SwanPkgMaintainer", "有悬而未决的的errCode要处理，走Server同步下载");
                }
                this.f46693i = true;
                p.A("launch_state", String.valueOf(2));
                R("KEY_PMS_UPDATE_TYPE", "event_pms_check_start", 2);
                return true;
            } else if (this.p.isMaxAgeExpires()) {
                if (d.a.q0.a.h0.c.b.a.a().c(getAppId())) {
                    if (q) {
                        Log.i("SwanPkgMaintainer", "MaxAge已过期，但5小时内已通过SilentUpdateManager检测无新包，id =" + getAppId());
                    }
                    p.A("launch_state", String.valueOf(3));
                    R("KEY_PMS_UPDATE_TYPE", "event_pms_check_start", 3);
                    return false;
                }
                if (q) {
                    Log.i("SwanPkgMaintainer", "本地包已过期");
                }
                R("KEY_PMS_UPDATE_TYPE", "event_pms_check_start", 1);
                p.A("launch_state", String.valueOf(1));
                this.k = true;
                return true;
            } else {
                p.A("launch_state", String.valueOf(4));
                R("KEY_PMS_UPDATE_TYPE", "event_pms_check_start", 4);
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public final synchronized void h0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            synchronized (this) {
                this.f46690f = false;
                this.f46692h = z;
                this.p = null;
                if (q) {
                    e0("notifyMaintainFinish: " + z);
                }
                A((i.a) new i.a("event_on_pkg_maintain_finish").y("mAppId", this.l.f46683f));
                if (q) {
                    d.a.q0.a.f1.g.a.d(this.m).h();
                }
                this.m = "";
            }
        }
    }

    public int i0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.j : invokeV.intValue;
    }

    public final synchronized void j0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            synchronized (this) {
                HybridUbcFlow p = d.a.q0.a.r1.h.p("startup");
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("postExec-onhold");
                ubcFlowEvent.a(true);
                p.C(ubcFlowEvent);
                d.a.q0.a.a2.d.i().post(new a(this, p));
            }
        }
    }

    public final void l0(boolean z, String str, d.a.q0.a.q2.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{Boolean.valueOf(z), str, aVar}) == null) || this.p == null) {
            return;
        }
        k0(this.p, W(), Z(), z, str, aVar);
    }

    public final void m0(d.a.q0.a.q2.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, aVar) == null) {
            d.a.q0.a.r1.h.k(aVar);
            Context W = W();
            if ((W instanceof SwanAppActivity) && !d.a.q0.a.v2.f.d((SwanAppActivity) W)) {
                if (q) {
                    Log.d("SwanPkgMaintainer", "launcher activity closed, ignore launch err");
                    return;
                }
                return;
            }
            d.a.q0.a.f1.e.b Z = Z();
            int G = Z.G();
            if (!aVar.k()) {
                d.a.q0.a.j2.p.d dVar = new d.a.q0.a.j2.p.d();
                dVar.q(d.a.q0.a.j2.k.m(G));
                dVar.p(aVar);
                dVar.m(getAppId());
                dVar.t(Z.T());
                d.a.q0.a.j2.k.L(dVar);
                aVar.m();
            }
            if (!d.a.q0.a.g1.g.a().b()) {
                if (q) {
                    Log.d("SwanPkgMaintainer", "launcher activity hide, ignore launch err and reset.");
                }
                d.a.q0.a.a2.d.g().o("flag_finish_activity", "flag_remove_task");
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("mAppId", Z.H());
            bundle.putAll(Z.C());
            d.a.q0.a.f1.d.a.f(d.a.q0.a.c1.a.b(), aVar, G, getAppId(), true, bundle);
            d.a.q0.a.j2.e.m(Z, G, aVar);
            d.a.q0.a.c1.a.g0().c(false);
        }
    }

    public boolean n0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f46691g : invokeV.booleanValue;
    }

    public final void o0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            d.a.q0.a.a1.e.M(this.l);
        }
    }

    public final void p0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            HybridUbcFlow p = d.a.q0.a.r1.h.p("startup");
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updateForIndependentPkgStart");
            ubcFlowEvent.a(true);
            p.C(ubcFlowEvent);
            if (q) {
                e0("独立分包启动，本地有包--->打开小程序，异步更新主包");
            }
            d.a.q0.a.f1.e.b Z = Z();
            String c2 = d.a.q0.a.f1.h.a.c(this.p, Z.e0());
            Z.E0(true);
            Z.U0(c2);
            Bundle bundle = new Bundle();
            bundle.putLong("pms_update_expect_pkg_ver", this.p.versionCode);
            u0(bundle);
            UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("updateForIndependentPkgEnd");
            ubcFlowEvent2.a(true);
            p.C(ubcFlowEvent2);
        }
    }

    public final boolean q0(d.a.q0.a.q2.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, aVar)) == null) {
            HybridUbcFlow p = d.a.q0.a.r1.h.p("startup");
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updateInfoWithFinalCheckStart");
            ubcFlowEvent.a(true);
            p.C(ubcFlowEvent);
            if (q) {
                e0("updateInfoWithFinalCheck: mAppInfo=" + this.p);
            }
            PMSAppInfo pMSAppInfo = this.p;
            if (pMSAppInfo == null) {
                if (aVar == null) {
                    aVar = new d.a.q0.a.q2.a();
                    aVar.j(10L);
                    aVar.h(2902L);
                    aVar.e("no pkg was installed");
                }
                d.a.q0.a.q2.e.a().f(aVar);
                m0(aVar);
                return false;
            }
            int P = P(pMSAppInfo);
            if (P != 10001 && P != 10002) {
                s0();
                if (P != 0) {
                    d.a.q0.a.q2.a X = X(10003);
                    d.a.q0.a.q2.e.a().f(X);
                    l0(false, null, X);
                    d.a.q0.a.r1.h.k(X);
                    d.a.q0.a.c1.a.g0().c(false);
                    return false;
                }
                d.a.q0.a.g1.f V = d.a.q0.a.g1.f.V();
                String e0 = r().L().e0();
                if (!TextUtils.isEmpty(e0)) {
                    if (d.a.q0.a.c2.f.g0.d.b().a(d.a.q0.a.l1.b.g(e0, V.A()))) {
                        d.a.q0.a.q2.a X2 = X(10004);
                        d.a.q0.a.q2.e.a().f(X2);
                        l0(true, d.a.q0.a.c2.f.g0.d.b().d(), X2);
                        d.a.q0.a.r1.h.k(X2);
                        d.a.q0.a.c1.a.g0().c(false);
                        return false;
                    }
                }
                return true;
            }
            if (aVar == null) {
                aVar = X(P);
            }
            d.a.q0.a.q2.e.a().f(aVar);
            m0(aVar);
            return false;
        }
        return invokeL.booleanValue;
    }

    public final boolean r0(d.a.q0.a.q2.a aVar) {
        InterceptResult invokeL;
        d.a.q0.a.n0.d d2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, aVar)) == null) {
            HybridUbcFlow p = d.a.q0.a.r1.h.p("startup");
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updateInstalledPkgWithFinalCheckStart");
            ubcFlowEvent.a(true);
            p.C(ubcFlowEvent);
            if (!q0(aVar)) {
                if (q) {
                    e0("updateInstalledPkgWithFinalCheck by null launchParams");
                }
                h0(false);
                return false;
            }
            UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("updateInfoWithFinalCheckOk");
            ubcFlowEvent2.a(true);
            p.C(ubcFlowEvent2);
            b.a L = this.l.L();
            String str = L.i0() != null ? L.i0().swanCoreVersionName : "0";
            if (q) {
                Log.d("SwanPkgMaintainer", "SwanCoreVersion target string version: " + L.j0() + " ,curSwanVersionName: " + str);
            }
            if (l0.a(L.j0(), str)) {
                d.a.q0.a.m2.b.n(L.G());
            }
            d.a.q0.a.r1.h.p("startup").A("launch_type", String.valueOf(L.i("host_launch_type")));
            if (L.G() == 0) {
                o0();
            }
            UbcFlowEvent ubcFlowEvent3 = new UbcFlowEvent("updateInstalledPkgWithFinalCheckEnd");
            ubcFlowEvent3.a(true);
            p.C(ubcFlowEvent3);
            h0(true);
            if (ProcessUtils.isMainProcess() && (d2 = d.a.q0.a.n0.f.c().d()) != null && d2.m()) {
                d2.b(getAppId());
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void s0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            b.a L = r().L();
            PMSAppInfo pMSAppInfo = this.p;
            boolean z = (pMSAppInfo == null || TextUtils.isEmpty(pMSAppInfo.appId) || !TextUtils.equals(getAppId(), this.p.appId)) ? false : true;
            if (z) {
                L.R0(this.p);
            }
            int i2 = (z && this.p.appCategory == 1) ? 1 : 0;
            if (Looper.myLooper() == Looper.getMainLooper()) {
                L.t0(i2);
            } else {
                q0.b0(new i(this, L, i2));
            }
        }
    }

    public final void t0(d.a.q0.a.q2.a aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048601, this, aVar) == null) && r0(aVar)) {
            d.a.q0.a.j2.p.d dVar = new d.a.q0.a.j2.p.d();
            dVar.p(aVar);
            dVar.r(Z());
            d.a.q0.a.j2.k.L(dVar);
        }
    }

    public final void u0(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, bundle) == null) {
            HybridUbcFlow p = d.a.q0.a.r1.h.p("startup");
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updateLocalPkgWithAsyncUpdatePkgStart");
            ubcFlowEvent.a(true);
            p.C(ubcFlowEvent);
            if (q) {
                e0("启动本地包，进程预处理-加载本地包-后台异步更新");
            }
            r0(null);
            d.a.q0.a.r1.k.i.a.k().j(new b(this, bundle));
            UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("updateLocalPkgWithAsyncUpdatePkgEnd");
            ubcFlowEvent2.a(true);
            p.C(ubcFlowEvent2);
        }
    }

    public final void v0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            d.a.q0.a.a2.d.g().q("event_pms_check_start");
            HybridUbcFlow p = d.a.q0.a.r1.h.p("startup");
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updatePkgOnPresetUnavailableStart");
            ubcFlowEvent.a(true);
            p.C(ubcFlowEvent);
            d.a.q0.a.f1.e.b Z = Z();
            if (q) {
                e0("预置包不可用");
            }
            boolean g0 = g0();
            if (q) {
                Log.i("SwanPkgMaintainer", "updatePkgOnPresetUnavailable: isNeedFetchPkg " + g0);
            }
            if (!g0) {
                if (q) {
                    e0("可以直接打开小程序，异步从Server拉取新包");
                }
                this.j = 4;
                d0(Z, this.p, false, false);
                this.j = this.k ? 3 : 4;
                u0(null);
                R("KEY_PKG_STATE", "event_pms_check_finish", this.j);
                return;
            }
            if (q) {
                e0("不能直接打开小程序，同步从Server拉取新包");
            }
            R("KEY_PKG_STATE", "event_pms_check_finish", this.j);
            U(this.l.L().H(), new d(this, Z));
            String appId = getAppId();
            d.a.q0.n.i.m.c cVar = new d.a.q0.n.i.m.c(appId, Z.G());
            cVar.d("3");
            PMSAppInfo pMSAppInfo = this.p;
            cVar.s(pMSAppInfo == null ? 0L : pMSAppInfo.versionCode);
            PMSAppInfo pMSAppInfo2 = this.p;
            cVar.n(pMSAppInfo2 != null ? pMSAppInfo2.appSign : 0L);
            String f2 = o0.f(Z.e0());
            if (!TextUtils.isEmpty(f2)) {
                if (f2.startsWith(File.separator)) {
                    f2 = f2.substring(1);
                }
                cVar.r(f2);
            }
            UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("updatePkgOnPresetUnavailableRequest");
            ubcFlowEvent2.a(true);
            p.C(ubcFlowEvent2);
            A((i.a) new i.a("event_on_still_maintaining").s(" event_params_pkg_update", this.n));
            d.a.q0.a.f1.d.b.a.b().g(appId);
            V(cVar, false, null);
            UbcFlowEvent ubcFlowEvent3 = new UbcFlowEvent("updatePkgOnPresetUnavailableReturn");
            ubcFlowEvent3.a(true);
            p.C(ubcFlowEvent3);
        }
    }

    public final void w0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            HybridUbcFlow p = d.a.q0.a.r1.h.p("startup");
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updatePkgWithPresetCheckStart");
            ubcFlowEvent.a(true);
            p.C(ubcFlowEvent);
            if (q) {
                e0(this.p == null ? "数据库或本地无主包信息，尝试加载预置包，并下载主包" : "包信息、文件都存在，尝试加载更高版本的预置包");
            }
            d.a.q0.a.h0.r.c c2 = d.a.q0.a.h0.r.f.b().c(getAppId());
            PMSAppInfo pMSAppInfo = this.p;
            long j2 = pMSAppInfo == null ? -1L : pMSAppInfo.versionCode;
            long j3 = c2 != null ? c2.f53940i : -1L;
            boolean z = j3 > j2;
            if (q) {
                e0(String.format(Locale.getDefault(), "尝试加载预制包，命中预制包=%b  currentVersion/presetVersion = %d/%d", Boolean.valueOf(z), Long.valueOf(j2), Long.valueOf(j3)));
            }
            if (!z) {
                v0();
                return;
            }
            q("event_on_still_maintaining");
            UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("updatePkgWithPresetCheckLoadPresetApp");
            ubcFlowEvent2.a(true);
            p.C(ubcFlowEvent2);
            d.a.q0.a.h0.r.f.b().e(c2, new c(this));
            UbcFlowEvent ubcFlowEvent3 = new UbcFlowEvent("updatePkgWithPresetCheckReturn");
            ubcFlowEvent3.a(true);
            p.C(ubcFlowEvent3);
        }
    }

    public final void x0(PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, pMSAppInfo) == null) {
            this.p = pMSAppInfo;
            this.l.L().a1(pMSAppInfo);
        }
    }

    public final void y0(PMSAppInfo pMSAppInfo, HybridUbcFlow hybridUbcFlow) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048606, this, pMSAppInfo, hybridUbcFlow) == null) || pMSAppInfo == null || hybridUbcFlow == null) {
            return;
        }
        x0(pMSAppInfo);
        S(this.p);
        UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("update_icon");
        ubcFlowEvent.a(true);
        hybridUbcFlow.C(ubcFlowEvent);
    }
}
