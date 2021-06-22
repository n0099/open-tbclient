package d.a.m0.a.a2;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.xiaomi.mipush.sdk.Constants;
import d.a.m0.a.a2.i;
import d.a.m0.a.f1.e.b;
import d.a.m0.a.v2.l0;
import d.a.m0.a.v2.o0;
import d.a.m0.a.v2.q0;
import java.io.File;
import java.util.Locale;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class k extends m implements d.a.m0.a.n0.l.b {
    public static final boolean q = d.a.m0.a.k.f46983a;
    public static final int r;

    /* renamed from: f  reason: collision with root package name */
    public boolean f44540f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f44541g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f44542h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f44543i;
    public int j;
    public boolean k;
    public final d.a.m0.a.a2.e l;
    public String m;
    public boolean n;
    public final boolean o;
    public PMSAppInfo p;

    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HybridUbcFlow f44544e;

        public a(HybridUbcFlow hybridUbcFlow) {
            this.f44544e = hybridUbcFlow;
        }

        @Override // java.lang.Runnable
        public void run() {
            HybridUbcFlow hybridUbcFlow = this.f44544e;
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("postExec-run");
            ubcFlowEvent.a(true);
            hybridUbcFlow.C(ubcFlowEvent);
            k.this.T();
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Bundle f44546e;

        public b(Bundle bundle) {
            this.f44546e = bundle;
        }

        @Override // java.lang.Runnable
        public void run() {
            Bundle bundle = new Bundle();
            Bundle bundle2 = this.f44546e;
            if (bundle2 != null) {
                bundle.putAll(bundle2);
            }
            bundle.putInt("appFrameType", k.this.Z().G());
            bundle.putString("mAppId", k.this.getAppId());
            if (k.q) {
                k.e0("updateLocalPkgWithAsyncUpdatePkg: swanAsyncUpdate -> 发送异步升级消息");
            }
            d.a.m0.a.v1.c.a e2 = d.a.m0.a.v1.c.a.e();
            d.a.m0.a.v1.c.c cVar = new d.a.m0.a.v1.c.c(17, bundle);
            cVar.j(5000L);
            e2.h(cVar);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements d.a.m0.a.h0.r.d {
        public c() {
        }

        @Override // d.a.m0.a.h0.r.d
        public void a(PMSAppInfo pMSAppInfo) {
            HybridUbcFlow p = d.a.m0.a.r1.h.p("startup");
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updatePkgWithPresetCheckUpdate");
            ubcFlowEvent.a(true);
            p.C(ubcFlowEvent);
            k.this.S(pMSAppInfo);
            UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("updatePkgWithPresetCheckUpdateIcon");
            ubcFlowEvent2.a(true);
            p.C(ubcFlowEvent2);
        }

        @Override // d.a.m0.a.h0.r.d
        public void b(PMSAppInfo pMSAppInfo) {
            k.this.j = 5;
            k kVar = k.this;
            kVar.R("KEY_PKG_STATE", "event_pms_check_finish", kVar.j);
            HybridUbcFlow p = d.a.m0.a.r1.h.p("startup");
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updatePkgWithPresetCheck#OnSuccessStart");
            ubcFlowEvent.a(true);
            p.C(ubcFlowEvent);
            if (k.q) {
                k.e0("预制包安装成功");
            }
            k.d0(k.this.Z(), pMSAppInfo, false, false);
            k.this.x0(pMSAppInfo);
            k.this.u0(null);
            UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("updatePkgWithPresetCheck#OnSuccessEnd");
            ubcFlowEvent2.a(true);
            p.C(ubcFlowEvent2);
        }

        @Override // d.a.m0.a.h0.r.d
        public void onFailed(int i2) {
            HybridUbcFlow p = d.a.m0.a.r1.h.p("startup");
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updatePkgWithPresetCheck#OnFailedStart");
            ubcFlowEvent.a(true);
            p.C(ubcFlowEvent);
            if (k.q) {
                k.e0("预制包安装失败");
            }
            k.this.v0();
            UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("updatePkgWithPresetCheck#OnonFailedEnd");
            ubcFlowEvent2.a(true);
            p.C(ubcFlowEvent2);
        }
    }

    /* loaded from: classes3.dex */
    public class d extends d.a.m0.a.v1.a.b.c.b {

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.f1.e.b f44549c;

        public d(d.a.m0.a.f1.e.b bVar) {
            this.f44549c = bVar;
        }

        @Override // d.a.m0.a.v1.a.b.c.b, d.a.m0.a.v1.a.b.c.a
        public long a() {
            return 1000L;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.a.v1.a.b.c.b, d.a.m0.a.v1.a.b.c.c, d.a.m0.a.v1.a.b.c.a
        public void onEvent(@NonNull d.a.m0.a.v1.a.b.a.b bVar) {
            Bundle a2 = bVar.a();
            k.d0(this.f44549c, k.this.p, true, a2 != null ? a2.getBoolean("isDownloading", false) : false);
        }
    }

    /* loaded from: classes3.dex */
    public class e implements d.a.m0.a.h0.m.m.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f44551a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.n.i.m.c f44552b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ HybridUbcFlow f44553c;

        public e(boolean z, d.a.m0.n.i.m.c cVar, HybridUbcFlow hybridUbcFlow) {
            this.f44551a = z;
            this.f44552b = cVar;
            this.f44553c = hybridUbcFlow;
        }

        @Override // d.a.m0.a.h0.m.m.a
        public void a(d.a.m0.a.q2.a aVar, boolean z) {
            long a2 = aVar == null ? 0L : aVar.a();
            d.a.m0.a.e0.d.h("SwanPkgMaintainer", "mFlagDownloading reset onFinalFailed isRetry = " + this.f44551a + ",code =" + a2);
            if (this.f44551a) {
                d.a.m0.a.j2.k.G("pkg_retry_fail", String.valueOf(a2));
            }
            if (k.this.Q(this.f44552b, aVar)) {
                return;
            }
            k.this.f44541g = false;
            d.a.m0.a.a2.d.g().q("event_pkg_download_finish");
            HybridUbcFlow hybridUbcFlow = this.f44553c;
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onFinalFailedStart");
            ubcFlowEvent.a(true);
            hybridUbcFlow.C(ubcFlowEvent);
            d.a.m0.a.q2.e.a().f(aVar);
            if (z) {
                k kVar = k.this;
                kVar.j = kVar.k ? 3 : 4;
                k kVar2 = k.this;
                kVar2.R("KEY_PKG_STATE", "event_pms_check_finish", kVar2.j);
                k.this.t0(aVar);
            } else {
                if (aVar != null && aVar.g() == 1020) {
                    k.this.m0(aVar);
                }
                k.this.h0(false);
            }
            HybridUbcFlow hybridUbcFlow2 = this.f44553c;
            UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onFinalFailedEnd");
            ubcFlowEvent2.a(true);
            hybridUbcFlow2.C(ubcFlowEvent2);
            if (aVar == null || aVar.g() != 2203) {
                return;
            }
            d.a.m0.a.e0.d.h("SwanPkgMaintainer", "mRecoveryABSwitch = " + k.this.o);
            if (k.this.o && d.a.m0.a.n0.j.c.a().b(1) == 0) {
                d.a.m0.a.n0.j.c.a().c();
            }
        }

        @Override // d.a.m0.a.h0.m.m.a
        public void b(PMSAppInfo pMSAppInfo) {
            d.a.m0.a.e0.d.h("SwanPkgMaintainer", "mFlagDownloading reset onFinalComplete isRetry = " + this.f44551a);
            if (this.f44551a) {
                d.a.m0.a.j2.k.G("pkg_retry_success", "");
            }
            k.this.f44541g = false;
            k kVar = k.this;
            kVar.j = kVar.f44543i ? 2 : 0;
            k kVar2 = k.this;
            kVar2.j = kVar2.k ? 1 : k.this.j;
            k kVar3 = k.this;
            kVar3.R("KEY_PKG_STATE", "event_pms_check_finish", kVar3.j);
            HybridUbcFlow hybridUbcFlow = this.f44553c;
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onFinalCompleteStart");
            ubcFlowEvent.a(true);
            hybridUbcFlow.C(ubcFlowEvent);
            k.this.x0(pMSAppInfo);
            k.this.r0(null);
            HybridUbcFlow hybridUbcFlow2 = this.f44553c;
            UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onFinalCompleteEnd");
            ubcFlowEvent2.a(true);
            hybridUbcFlow2.C(ubcFlowEvent2);
        }
    }

    /* loaded from: classes3.dex */
    public class f implements d.a.m0.a.v2.e1.b<PMSAppInfo> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HybridUbcFlow f44555e;

        public f(HybridUbcFlow hybridUbcFlow) {
            this.f44555e = hybridUbcFlow;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(PMSAppInfo pMSAppInfo) {
            HybridUbcFlow hybridUbcFlow = this.f44555e;
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onAppInfoReceivedStart");
            ubcFlowEvent.a(true);
            hybridUbcFlow.C(ubcFlowEvent);
            if (k.q) {
                k.e0("onAppInfoReceived appInfo=" + pMSAppInfo);
            }
            k.this.x0(pMSAppInfo);
            k.this.S(pMSAppInfo);
            HybridUbcFlow hybridUbcFlow2 = this.f44555e;
            UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onAppInfoReceivedEnd");
            ubcFlowEvent2.a(true);
            hybridUbcFlow2.C(ubcFlowEvent2);
        }
    }

    /* loaded from: classes3.dex */
    public class g extends d.a.m0.a.h0.m.g {
        public final /* synthetic */ boolean I;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(d.a.m0.a.a2.e eVar, boolean z) {
            super(eVar);
            this.I = z;
        }

        @Override // d.a.m0.a.h0.m.g, d.a.m0.a.h0.m.f, d.a.m0.n.f.g
        public void F(d.a.m0.n.o.f fVar) {
            d.a.m0.a.e0.d.h("SwanPkgMaintainer", "mFlagDownloading set onPrepareDownload isRetry = " + this.I);
            k.this.f44541g = true;
            d.a.m0.a.a2.d.g().q("event_pkg_download_start");
            super.F(fVar);
        }

        @Override // d.a.m0.n.f.g, d.a.m0.n.f.d
        public void b() {
            d.a.m0.a.e0.d.h("SwanPkgMaintainer", "mFlagDownloading reset onTotalPkgDownloadFinish isRetry = " + this.I);
            k.this.f44541g = false;
            d.a.m0.a.a2.d.g().q("event_pkg_download_finish");
            super.b();
        }
    }

    /* loaded from: classes3.dex */
    public static class h implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.j2.p.f f44557e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f44558f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f44559g;

        public h(d.a.m0.a.j2.p.f fVar, String str, String str2) {
            this.f44557e = fVar;
            this.f44558f = str;
            this.f44559g = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            k.c0(this.f44557e, this.f44558f, this.f44559g);
        }
    }

    /* loaded from: classes3.dex */
    public class i implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.f1.e.b f44560e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f44561f;

        public i(k kVar, d.a.m0.a.f1.e.b bVar, int i2) {
            this.f44560e = bVar;
            this.f44561f = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f44560e.t0(this.f44561f);
        }
    }

    /* loaded from: classes3.dex */
    public static class j extends d.a.m0.a.v1.a.a.a {
        @Override // d.a.m0.a.v1.a.a.a
        public void b(@NonNull Bundle bundle) {
            String string = bundle.getString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID);
            boolean z = false;
            if (TextUtils.isEmpty(string)) {
                this.f49054d.putBoolean("isDownloading", false);
                c();
                return;
            }
            boolean h2 = d.a.m0.n.b.h(string);
            boolean i2 = d.a.m0.n.b.i(string);
            if (d.a.m0.a.v1.a.a.a.f49050e) {
                Log.d("MDelegate-Delegation", "isDownloading: " + h2 + ", isInQueue: " + i2);
            }
            this.f49054d.putBoolean("isDownloading", (h2 || i2) ? true : true);
            c();
        }
    }

    static {
        d.a.m0.a.c1.a.Z().getSwitch("swan_pms_http_request_retry_replace_net_lib", 0);
        r = 0;
    }

    public k(d.a.m0.a.a2.e eVar) {
        super(eVar);
        this.f44540f = false;
        this.f44541g = false;
        this.f44542h = false;
        this.f44543i = false;
        this.j = -1;
        this.k = false;
        this.m = "";
        this.n = false;
        d.a.m0.a.c1.a.Z().getSwitch("swan_error_recovery", false);
        this.o = false;
        this.l = eVar;
    }

    public static String Y(Context context, d.a.m0.a.q2.a aVar) {
        return String.format(context.getResources().getString(d.a.m0.a.h.aiapps_open_failed_detail_format), q0.D(), d.a.m0.a.m2.b.i(d.a.m0.a.g1.f.V().N(), d.a.m0.a.a2.d.g().r().l()), String.valueOf(aVar.a()));
    }

    public static void c0(d.a.m0.a.j2.p.f fVar, String str, String str2) {
        JSONObject k = d.a.m0.a.j2.k.k(str);
        fVar.d(str2);
        fVar.b(k);
        d.a.m0.a.j2.k.onEvent(fVar);
    }

    public static void d0(d.a.m0.a.f1.e.e eVar, PMSAppInfo pMSAppInfo, boolean z, boolean z2) {
        if (q) {
            Log.d("SwanPkgMaintainer", "SwanPkgMaintainer#launchStatistic");
        }
        eVar.r0().putString("aiapp_extra_need_download", z ? "1" : "0");
        eVar.r0().putString("aiapp_extra_pkg_downloading", z2 ? "1" : "0");
        d.a.m0.a.j2.p.f fVar = new d.a.m0.a.j2.p.f();
        fVar.f46969a = d.a.m0.a.j2.k.m(eVar.G());
        fVar.h(eVar);
        fVar.f46970b = "launch";
        fVar.o = z ? "1" : "0";
        if (pMSAppInfo != null) {
            fVar.l = String.valueOf(pMSAppInfo.versionCode);
        }
        d.a.m0.a.r1.k.i.c.f().e(new h(fVar, eVar.W(), eVar.r0().getString(UBCCloudControlProcessor.UBC_KEY)), "launchStatistic");
    }

    public static void e0(String str) {
        if (q) {
            Log.i("SwanPkgMaintainer", str);
        }
    }

    public static void k0(PMSAppInfo pMSAppInfo, Context context, d.a.m0.a.f1.e.b bVar, boolean z, String str, d.a.m0.a.q2.a aVar) {
        if (pMSAppInfo == null) {
            return;
        }
        if (!d.a.m0.a.c1.a.O().a(context, d.a.m0.a.a2.d.g().r().D(), aVar)) {
            ForbiddenInfo forbiddenInfo = new ForbiddenInfo(bVar, str, Y(context, aVar));
            forbiddenInfo.enableSlidingFlag = -1;
            d.a.m0.a.f1.d.a.k(context, z ? SwanAppErrorActivity.TYPE_PATH_FORBIDDEN : SwanAppErrorActivity.TYPE_APP_FORBIDDEN, bVar.C(), forbiddenInfo);
        }
        d.a.m0.a.j2.p.f fVar = new d.a.m0.a.j2.p.f();
        fVar.f46969a = d.a.m0.a.j2.k.m(bVar.G());
        fVar.f46970b = "launch";
        fVar.f46973e = "success";
        fVar.i(bVar);
        fVar.a("status", "2");
        fVar.d(bVar.r0().getString(UBCCloudControlProcessor.UBC_KEY));
        d.a.m0.a.j2.k.onEvent(fVar);
    }

    public final int P(@NonNull PMSAppInfo pMSAppInfo) {
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

    public final boolean Q(@NonNull d.a.m0.n.i.m.c cVar, d.a.m0.a.q2.a aVar) {
        String appId = getAppId();
        if (aVar != null && SwanAppNetworkUtils.i(d.a.m0.a.c1.a.b()) && d.a.m0.a.f1.d.b.a.b().f(appId)) {
            d.a.m0.a.e0.d.h("SwanPkgMaintainer", "checkGetPkgResult appId=" + appId + " errCode=" + aVar.a());
            if (aVar.g() == 2101) {
                d.a.m0.a.f1.d.b.a.b().a(appId);
                d.a.m0.a.r1.h.p("startup").C(new UbcFlowEvent("pkg_download_retry"));
                V(cVar, true, aVar);
                return true;
            } else if (aVar.g() == 2205) {
                d.a.m0.a.n0.f.c().d().u(d.a.m0.a.v2.z0.a.a(appId), true, 12);
                d.a.m0.a.f1.d.b.a.b().a(appId);
                d.a.m0.a.r1.h.p("startup").C(new UbcFlowEvent("pkg_download_retry"));
                V(cVar, true, aVar);
                return true;
            }
        }
        return false;
    }

    public final void R(String str, String str2, int i2) {
        Bundle bundle = new Bundle();
        bundle.putInt(str, i2);
        d.a.m0.a.a2.d.g().w(str2, bundle);
    }

    public final void S(PMSAppInfo pMSAppInfo) {
        if (pMSAppInfo != null) {
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
                aVar.w(Constants.EXTRA_KEY_APP_VERSION_CODE, pMSAppInfo.versionCode);
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
    }

    public final synchronized void T() {
        this.j = 99;
        R("KEY_PKG_STATE", "event_pms_check_start", 99);
        b.a L = this.l.L();
        if (!d.a.m0.a.u1.a.a.G() && TextUtils.isEmpty(L.g0()) && ((!q || !L.m0()) && !L.o0())) {
            String V = L.V();
            this.m = V;
            if (q) {
                d.a.m0.a.f1.g.a.d(V).f(IntentConfig.START);
            }
            if (d.a.m0.a.h0.n.a.a.c()) {
                d.a.m0.a.y0.k.f.b.d("0");
            } else {
                d.a.m0.a.y0.k.f.b.e("1");
            }
            HybridUbcFlow p = d.a.m0.a.r1.h.p("startup");
            p.B("type", "1");
            p.A("is_updating", String.valueOf(d.a.m0.a.h0.c.b.a.a().b()));
            p.C(new UbcFlowEvent("na_query_db_start"));
            PMSAppInfo f0 = this.l.L().f0();
            if (f0 == null || f0.m()) {
                f0 = d.a.m0.n.g.a.h().s(getAppId());
            }
            p.C(new UbcFlowEvent("na_query_db"));
            boolean e2 = d.a.m0.a.f1.h.a.e(f0);
            this.n = e2;
            this.f44543i = (f0 == null || e2) ? false : true;
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("has_local_file");
            ubcFlowEvent.a(true);
            p.C(ubcFlowEvent);
            if (this.n) {
                y0(f0, p);
            }
            if (!this.n && d.a.m0.a.f1.h.a.f(f0, L.e0())) {
                y0(f0, p);
                p0();
            } else {
                w0();
            }
            return;
        }
        h0(true);
    }

    public final void U(@NonNull String str, @NonNull d.a.m0.a.v1.a.b.c.b bVar) {
        d.a.m0.a.v1.c.e.a E = d.a.m0.a.v1.c.e.a.E();
        if (E == null) {
            d.a.m0.a.v1.a.b.a.b bVar2 = new d.a.m0.a.v1.a.b.a.b(bVar.b());
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

    public final void V(@NonNull d.a.m0.n.i.m.c cVar, boolean z, @Nullable d.a.m0.a.q2.a aVar) {
        HybridUbcFlow p = d.a.m0.a.r1.h.p("startup");
        cVar.t(z ? 1L : 0L);
        g gVar = new g(this.l, z);
        gVar.b0(new f(p));
        gVar.d0(new e(z, cVar, p));
        gVar.K(this.k ? 2 : 1);
        if (r == 1 && z && aVar != null && aVar.g() == 2101) {
            d.a.m0.a.e0.d.h("SwanPkgMaintainer", "PMS请求失败后重试时替换网络库");
            d.a.m0.n.b.c(cVar, gVar);
            return;
        }
        d.a.m0.n.b.b(cVar, gVar);
    }

    public final Context W() {
        SwanAppActivity x = this.l.x();
        return (x == null || x.isDestroyed()) ? d.a.m0.a.c1.a.b() : x;
    }

    public final d.a.m0.a.q2.a X(int i2) {
        d.a.m0.a.q2.a aVar = new d.a.m0.a.q2.a();
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

    public d.a.m0.a.f1.e.b Z() {
        return this.l.L();
    }

    public synchronized boolean a0() {
        return this.f44540f;
    }

    public synchronized boolean b0() {
        return this.f44542h;
    }

    public synchronized void f0() {
        if (SwanAppProcessInfo.current().isSwanAppProcess() && this.l.f44534g && !a0() && !b0()) {
            boolean z = true;
            this.f44540f = true;
            HybridUbcFlow p = d.a.m0.a.r1.h.p("startup");
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("maintain_start");
            ubcFlowEvent.a(true);
            p.C(ubcFlowEvent);
            if (1 != this.l.L().G()) {
                z = false;
            }
            if (z || !d.a.m0.a.h0.u.g.N().c0()) {
                q("event_on_still_maintaining");
            }
            if (z) {
                j0();
            } else {
                T();
            }
        }
    }

    public final boolean g0() {
        HybridUbcFlow p = d.a.m0.a.r1.h.p("startup");
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
            this.f44543i = true;
            p.A("launch_state", String.valueOf(2));
            R("KEY_PMS_UPDATE_TYPE", "event_pms_check_start", 2);
            return true;
        } else if (pMSAppInfo.j()) {
            if (q) {
                Log.i("SwanPkgMaintainer", "有悬而未决的的errCode要处理，走Server同步下载");
            }
            this.f44543i = true;
            p.A("launch_state", String.valueOf(2));
            R("KEY_PMS_UPDATE_TYPE", "event_pms_check_start", 2);
            return true;
        } else if (this.p.m()) {
            if (d.a.m0.a.h0.c.b.a.a().c(getAppId())) {
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

    public final synchronized void h0(boolean z) {
        this.f44540f = false;
        this.f44542h = z;
        this.p = null;
        if (q) {
            e0("notifyMaintainFinish: " + z);
        }
        A((i.a) new i.a("event_on_pkg_maintain_finish").y("mAppId", this.l.f44533f));
        if (q) {
            d.a.m0.a.f1.g.a.d(this.m).h();
        }
        this.m = "";
    }

    public int i0() {
        return this.j;
    }

    public final synchronized void j0() {
        HybridUbcFlow p = d.a.m0.a.r1.h.p("startup");
        UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("postExec-onhold");
        ubcFlowEvent.a(true);
        p.C(ubcFlowEvent);
        d.a.m0.a.a2.d.i().post(new a(p));
    }

    public final void l0(boolean z, String str, d.a.m0.a.q2.a aVar) {
        if (this.p == null) {
            return;
        }
        d.a.m0.a.f1.e.b Z = Z();
        k0(this.p, W(), Z, z, str, aVar);
    }

    public final void m0(d.a.m0.a.q2.a aVar) {
        d.a.m0.a.r1.h.k(aVar);
        Context W = W();
        if ((W instanceof SwanAppActivity) && !d.a.m0.a.v2.f.d((SwanAppActivity) W)) {
            if (q) {
                Log.d("SwanPkgMaintainer", "launcher activity closed, ignore launch err");
                return;
            }
            return;
        }
        d.a.m0.a.f1.e.b Z = Z();
        int G = Z.G();
        if (!aVar.k()) {
            d.a.m0.a.j2.p.d dVar = new d.a.m0.a.j2.p.d();
            dVar.q(d.a.m0.a.j2.k.m(G));
            dVar.p(aVar);
            dVar.m(getAppId());
            dVar.t(Z.T());
            d.a.m0.a.j2.k.L(dVar);
            aVar.m();
        }
        if (!d.a.m0.a.g1.g.a().b()) {
            if (q) {
                Log.d("SwanPkgMaintainer", "launcher activity hide, ignore launch err and reset.");
            }
            d.a.m0.a.a2.d.g().o("flag_finish_activity", "flag_remove_task");
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("mAppId", Z.H());
        bundle.putAll(Z.C());
        d.a.m0.a.f1.d.a.f(d.a.m0.a.c1.a.b(), aVar, G, getAppId(), true, bundle);
        d.a.m0.a.j2.e.m(Z, G, aVar);
        d.a.m0.a.c1.a.g0().c(false);
    }

    public boolean n0() {
        return this.f44541g;
    }

    public final void o0() {
        d.a.m0.a.a1.e.M(this.l);
    }

    public final void p0() {
        HybridUbcFlow p = d.a.m0.a.r1.h.p("startup");
        UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updateForIndependentPkgStart");
        ubcFlowEvent.a(true);
        p.C(ubcFlowEvent);
        if (q) {
            e0("独立分包启动，本地有包--->打开小程序，异步更新主包");
        }
        d.a.m0.a.f1.e.b Z = Z();
        String c2 = d.a.m0.a.f1.h.a.c(this.p, Z.e0());
        Z.E0(true);
        Z.U0(c2);
        Bundle bundle = new Bundle();
        bundle.putLong("pms_update_expect_pkg_ver", this.p.versionCode);
        u0(bundle);
        UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("updateForIndependentPkgEnd");
        ubcFlowEvent2.a(true);
        p.C(ubcFlowEvent2);
    }

    public final boolean q0(d.a.m0.a.q2.a aVar) {
        HybridUbcFlow p = d.a.m0.a.r1.h.p("startup");
        UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updateInfoWithFinalCheckStart");
        ubcFlowEvent.a(true);
        p.C(ubcFlowEvent);
        if (q) {
            e0("updateInfoWithFinalCheck: mAppInfo=" + this.p);
        }
        PMSAppInfo pMSAppInfo = this.p;
        if (pMSAppInfo == null) {
            if (aVar == null) {
                aVar = new d.a.m0.a.q2.a();
                aVar.j(10L);
                aVar.h(2902L);
                aVar.e("no pkg was installed");
            }
            d.a.m0.a.q2.e.a().f(aVar);
            m0(aVar);
            return false;
        }
        int P = P(pMSAppInfo);
        if (P != 10001 && P != 10002) {
            s0();
            if (P != 0) {
                d.a.m0.a.q2.a X = X(10003);
                d.a.m0.a.q2.e.a().f(X);
                l0(false, null, X);
                d.a.m0.a.r1.h.k(X);
                d.a.m0.a.c1.a.g0().c(false);
                return false;
            }
            d.a.m0.a.g1.f V = d.a.m0.a.g1.f.V();
            String e0 = r().L().e0();
            if (!TextUtils.isEmpty(e0)) {
                if (d.a.m0.a.c2.f.g0.d.b().a(d.a.m0.a.l1.b.e(e0, V.A()))) {
                    d.a.m0.a.q2.a X2 = X(10004);
                    d.a.m0.a.q2.e.a().f(X2);
                    l0(true, d.a.m0.a.c2.f.g0.d.b().d(), X2);
                    d.a.m0.a.r1.h.k(X2);
                    d.a.m0.a.c1.a.g0().c(false);
                    return false;
                }
            }
            return true;
        }
        if (aVar == null) {
            aVar = X(P);
        }
        d.a.m0.a.q2.e.a().f(aVar);
        m0(aVar);
        return false;
    }

    public final boolean r0(d.a.m0.a.q2.a aVar) {
        d.a.m0.a.n0.d d2;
        HybridUbcFlow p = d.a.m0.a.r1.h.p("startup");
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
            d.a.m0.a.m2.b.n(L.G());
        }
        d.a.m0.a.r1.h.p("startup").A("launch_type", String.valueOf(L.i("host_launch_type")));
        if (L.G() == 0) {
            o0();
        }
        UbcFlowEvent ubcFlowEvent3 = new UbcFlowEvent("updateInstalledPkgWithFinalCheckEnd");
        ubcFlowEvent3.a(true);
        p.C(ubcFlowEvent3);
        h0(true);
        if (ProcessUtils.isMainProcess() && (d2 = d.a.m0.a.n0.f.c().d()) != null && d2.m()) {
            d2.b(getAppId());
        }
        return true;
    }

    public final void s0() {
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

    public final void t0(d.a.m0.a.q2.a aVar) {
        if (r0(aVar)) {
            d.a.m0.a.j2.p.d dVar = new d.a.m0.a.j2.p.d();
            dVar.p(aVar);
            dVar.r(Z());
            d.a.m0.a.j2.k.L(dVar);
        }
    }

    public final void u0(Bundle bundle) {
        HybridUbcFlow p = d.a.m0.a.r1.h.p("startup");
        UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updateLocalPkgWithAsyncUpdatePkgStart");
        ubcFlowEvent.a(true);
        p.C(ubcFlowEvent);
        if (q) {
            e0("启动本地包，进程预处理-加载本地包-后台异步更新");
        }
        r0(null);
        d.a.m0.a.r1.k.i.a.k().j(new b(bundle));
        UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("updateLocalPkgWithAsyncUpdatePkgEnd");
        ubcFlowEvent2.a(true);
        p.C(ubcFlowEvent2);
    }

    public final void v0() {
        d.a.m0.a.a2.d.g().q("event_pms_check_start");
        HybridUbcFlow p = d.a.m0.a.r1.h.p("startup");
        UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updatePkgOnPresetUnavailableStart");
        ubcFlowEvent.a(true);
        p.C(ubcFlowEvent);
        d.a.m0.a.f1.e.b Z = Z();
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
        U(this.l.L().H(), new d(Z));
        String appId = getAppId();
        d.a.m0.n.i.m.c cVar = new d.a.m0.n.i.m.c(appId, Z.G());
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
        d.a.m0.a.f1.d.b.a.b().g(appId);
        V(cVar, false, null);
        UbcFlowEvent ubcFlowEvent3 = new UbcFlowEvent("updatePkgOnPresetUnavailableReturn");
        ubcFlowEvent3.a(true);
        p.C(ubcFlowEvent3);
    }

    public final void w0() {
        HybridUbcFlow p = d.a.m0.a.r1.h.p("startup");
        UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updatePkgWithPresetCheckStart");
        ubcFlowEvent.a(true);
        p.C(ubcFlowEvent);
        if (q) {
            e0(this.p == null ? "数据库或本地无主包信息，尝试加载预置包，并下载主包" : "包信息、文件都存在，尝试加载更高版本的预置包");
        }
        d.a.m0.a.h0.r.c c2 = d.a.m0.a.h0.r.f.b().c(getAppId());
        PMSAppInfo pMSAppInfo = this.p;
        long j2 = pMSAppInfo == null ? -1L : pMSAppInfo.versionCode;
        long j3 = c2 != null ? c2.f51796i : -1L;
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
        d.a.m0.a.h0.r.f.b().e(c2, new c());
        UbcFlowEvent ubcFlowEvent3 = new UbcFlowEvent("updatePkgWithPresetCheckReturn");
        ubcFlowEvent3.a(true);
        p.C(ubcFlowEvent3);
    }

    public final void x0(PMSAppInfo pMSAppInfo) {
        this.p = pMSAppInfo;
        this.l.L().a1(pMSAppInfo);
    }

    public final void y0(PMSAppInfo pMSAppInfo, HybridUbcFlow hybridUbcFlow) {
        if (pMSAppInfo == null || hybridUbcFlow == null) {
            return;
        }
        x0(pMSAppInfo);
        S(this.p);
        UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("update_icon");
        ubcFlowEvent.a(true);
        hybridUbcFlow.C(ubcFlowEvent);
    }
}
