package d.b.g0.a.r1;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.mobstat.Config;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.ubcprocessor.UBCCloudControlProcessor;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.SwanAppErrorActivity;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.apps.scheme.actions.forbidden.ForbiddenInfo;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.xiaomi.mipush.sdk.Constants;
import d.b.g0.a.i2.i0;
import d.b.g0.a.i2.k0;
import d.b.g0.a.r1.i;
import d.b.g0.a.y0.e.b;
import java.io.File;
import java.util.Locale;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class k extends m implements d.b.g0.a.j0.j.b {
    public static final boolean p = d.b.g0.a.k.f45050a;

    /* renamed from: f  reason: collision with root package name */
    public boolean f45745f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f45746g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f45747h;
    public boolean i;
    public int j;
    public boolean k;
    public final d.b.g0.a.r1.e l;
    public String m;
    public boolean n;
    public PMSAppInfo o;

    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HybridUbcFlow f45748e;

        public a(HybridUbcFlow hybridUbcFlow) {
            this.f45748e = hybridUbcFlow;
        }

        @Override // java.lang.Runnable
        public void run() {
            HybridUbcFlow hybridUbcFlow = this.f45748e;
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("postExec-run");
            ubcFlowEvent.a(true);
            hybridUbcFlow.A(ubcFlowEvent);
            k.this.O();
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Bundle f45750e;

        public b(Bundle bundle) {
            this.f45750e = bundle;
        }

        @Override // java.lang.Runnable
        public void run() {
            Bundle bundle = new Bundle();
            Bundle bundle2 = this.f45750e;
            if (bundle2 != null) {
                bundle.putAll(bundle2);
            }
            bundle.putInt("appFrameType", k.this.S().F());
            bundle.putString("mAppId", k.this.getAppId());
            if (k.p) {
                k.X("updateLocalPkgWithAsyncUpdatePkg: swanAsyncUpdate -> 发送异步升级消息");
            }
            d.b.g0.a.n1.c.a e2 = d.b.g0.a.n1.c.a.e();
            d.b.g0.a.n1.c.c cVar = new d.b.g0.a.n1.c.c(17, bundle);
            cVar.j(5000L);
            e2.h(cVar);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements d.b.g0.a.e0.t.d {
        public c() {
        }

        @Override // d.b.g0.a.e0.t.d
        public void a(PMSAppInfo pMSAppInfo) {
            HybridUbcFlow o = d.b.g0.a.j1.i.o("startup");
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updatePkgWithPresetCheckUpdate");
            ubcFlowEvent.a(true);
            o.A(ubcFlowEvent);
            k.this.N(pMSAppInfo);
            UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("updatePkgWithPresetCheckUpdateIcon");
            ubcFlowEvent2.a(true);
            o.A(ubcFlowEvent2);
        }

        @Override // d.b.g0.a.e0.t.d
        public void b(PMSAppInfo pMSAppInfo) {
            k.this.j = 5;
            k kVar = k.this;
            kVar.M("KEY_PKG_STATE", "event_pms_check_finish", kVar.j);
            HybridUbcFlow o = d.b.g0.a.j1.i.o("startup");
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updatePkgWithPresetCheck#OnSuccessStart");
            ubcFlowEvent.a(true);
            o.A(ubcFlowEvent);
            if (k.p) {
                k.X("预制包安装成功");
            }
            k.W(k.this.S(), pMSAppInfo, false, false, true);
            k.this.p0(pMSAppInfo);
            k.this.m0(null);
            UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("updatePkgWithPresetCheck#OnSuccessEnd");
            ubcFlowEvent2.a(true);
            o.A(ubcFlowEvent2);
        }

        @Override // d.b.g0.a.e0.t.d
        public void onFailed(int i) {
            HybridUbcFlow o = d.b.g0.a.j1.i.o("startup");
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updatePkgWithPresetCheck#OnFailedStart");
            ubcFlowEvent.a(true);
            o.A(ubcFlowEvent);
            if (k.p) {
                k.X("预制包安装失败");
            }
            k.this.n0();
            UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("updatePkgWithPresetCheck#OnonFailedEnd");
            ubcFlowEvent2.a(true);
            o.A(ubcFlowEvent2);
        }
    }

    /* loaded from: classes3.dex */
    public class d extends d.b.g0.a.n1.a.b.c.b {

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.y0.e.b f45753c;

        public d(d.b.g0.a.y0.e.b bVar) {
            this.f45753c = bVar;
        }

        @Override // d.b.g0.a.n1.a.b.c.b, d.b.g0.a.n1.a.b.c.a
        public long a() {
            return 1000L;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.n1.a.b.c.b, d.b.g0.a.n1.a.b.c.c, d.b.g0.a.n1.a.b.c.a
        public void onEvent(@NonNull d.b.g0.a.n1.a.b.a.b bVar) {
            Bundle a2 = bVar.a();
            k.W(this.f45753c, k.this.o, true, a2 != null ? a2.getBoolean("isDownloading", false) : false, false);
        }
    }

    /* loaded from: classes3.dex */
    public class e implements d.b.g0.a.e0.p.m.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ HybridUbcFlow f45755a;

        public e(HybridUbcFlow hybridUbcFlow) {
            this.f45755a = hybridUbcFlow;
        }

        @Override // d.b.g0.a.e0.p.m.a
        public void a(d.b.g0.a.f2.a aVar, boolean z) {
            if (k.p) {
                k.X("mFlagDownloading reset onFinalFailed");
            }
            k.this.f45746g = false;
            d.b.g0.a.r1.d.e().r("event_pkg_download_finish");
            HybridUbcFlow hybridUbcFlow = this.f45755a;
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onFinalFailedStart");
            ubcFlowEvent.a(true);
            hybridUbcFlow.A(ubcFlowEvent);
            if (k.p) {
                k.X("onFinalFailed");
            }
            d.b.g0.a.f2.e.a().f(aVar);
            if (z) {
                k kVar = k.this;
                kVar.j = kVar.k ? 3 : 4;
                k kVar2 = k.this;
                kVar2.M("KEY_PKG_STATE", "event_pms_check_finish", kVar2.j);
                k.this.l0(aVar);
            } else {
                if (aVar != null && aVar.g() == 1020) {
                    k.this.e0(aVar);
                }
                k.this.a0(false);
            }
            HybridUbcFlow hybridUbcFlow2 = this.f45755a;
            UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onFinalFailedEnd");
            ubcFlowEvent2.a(true);
            hybridUbcFlow2.A(ubcFlowEvent2);
        }

        @Override // d.b.g0.a.e0.p.m.a
        public void b(PMSAppInfo pMSAppInfo) {
            if (k.p) {
                k.X("mFlagDownloading reset onFinalComplete");
            }
            k.this.f45746g = false;
            k kVar = k.this;
            kVar.j = kVar.i ? 2 : 0;
            k kVar2 = k.this;
            kVar2.j = kVar2.k ? 1 : k.this.j;
            k kVar3 = k.this;
            kVar3.M("KEY_PKG_STATE", "event_pms_check_finish", kVar3.j);
            HybridUbcFlow hybridUbcFlow = this.f45755a;
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onFinalCompleteStart");
            ubcFlowEvent.a(true);
            hybridUbcFlow.A(ubcFlowEvent);
            if (k.p) {
                k.X("onFinalComplete");
            }
            k.this.p0(pMSAppInfo);
            k.this.j0(null);
            HybridUbcFlow hybridUbcFlow2 = this.f45755a;
            UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onFinalCompleteEnd");
            ubcFlowEvent2.a(true);
            hybridUbcFlow2.A(ubcFlowEvent2);
        }
    }

    /* loaded from: classes3.dex */
    public class f implements d.b.g0.a.i2.u0.b<PMSAppInfo> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HybridUbcFlow f45757e;

        public f(HybridUbcFlow hybridUbcFlow) {
            this.f45757e = hybridUbcFlow;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(PMSAppInfo pMSAppInfo) {
            HybridUbcFlow hybridUbcFlow = this.f45757e;
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onAppInfoReceivedStart");
            ubcFlowEvent.a(true);
            hybridUbcFlow.A(ubcFlowEvent);
            if (k.p) {
                k.X("onAppInfoReceived appInfo=" + pMSAppInfo);
            }
            k.this.p0(pMSAppInfo);
            k.this.N(pMSAppInfo);
            HybridUbcFlow hybridUbcFlow2 = this.f45757e;
            UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onAppInfoReceivedEnd");
            ubcFlowEvent2.a(true);
            hybridUbcFlow2.A(ubcFlowEvent2);
        }
    }

    /* loaded from: classes3.dex */
    public class g extends d.b.g0.a.e0.p.g {
        public g(d.b.g0.a.r1.e eVar) {
            super(eVar);
        }

        @Override // d.b.g0.a.e0.p.g, d.b.g0.a.e0.p.f, d.b.g0.l.h.g
        public void G(d.b.g0.l.r.f fVar) {
            if (k.p) {
                k.X("mFlagDownloading set onPrepareDownload");
            }
            k.this.f45746g = true;
            d.b.g0.a.r1.d.e().r("event_pkg_download_start");
            super.G(fVar);
        }

        @Override // d.b.g0.l.h.g, d.b.g0.l.h.d
        public void h() {
            if (k.p) {
                k.X("mFlagDownloading reset onTotalPkgDownloadFinish");
            }
            k.this.f45746g = false;
            d.b.g0.a.r1.d.e().r("event_pkg_download_finish");
            super.h();
        }
    }

    /* loaded from: classes3.dex */
    public static class h implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.z1.k.f f45759e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f45760f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f45761g;

        public h(d.b.g0.a.z1.k.f fVar, String str, String str2) {
            this.f45759e = fVar;
            this.f45760f = str;
            this.f45761g = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            k.V(this.f45759e, this.f45760f, this.f45761g);
        }
    }

    /* loaded from: classes3.dex */
    public class i implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.y0.e.b f45762e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f45763f;

        public i(k kVar, d.b.g0.a.y0.e.b bVar, int i) {
            this.f45762e = bVar;
            this.f45763f = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f45762e.p0(this.f45763f);
        }
    }

    /* loaded from: classes3.dex */
    public static class j extends d.b.g0.a.n1.a.a.a {
        @Override // d.b.g0.a.n1.a.a.a
        public void b(@NonNull Bundle bundle) {
            String string = bundle.getString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID);
            boolean z = false;
            if (TextUtils.isEmpty(string)) {
                this.f45339d.putBoolean("isDownloading", false);
                c();
                return;
            }
            boolean f2 = d.b.g0.l.c.f(string);
            boolean g2 = d.b.g0.l.c.g(string);
            if (d.b.g0.a.n1.a.a.a.f45335e) {
                Log.d("MDelegate-Delegation", "isDownloading: " + f2 + ", isInQueue: " + g2);
            }
            this.f45339d.putBoolean("isDownloading", (f2 || g2) ? true : true);
            c();
        }
    }

    public k(d.b.g0.a.r1.e eVar) {
        super(eVar);
        this.f45745f = false;
        this.f45746g = false;
        this.f45747h = false;
        this.i = false;
        this.j = -1;
        this.k = false;
        this.m = "";
        this.n = false;
        this.l = eVar;
    }

    public static void V(d.b.g0.a.z1.k.f fVar, String str, String str2) {
        JSONObject l = d.b.g0.a.z1.h.l(str);
        fVar.d(str2);
        fVar.b(l);
        d.b.g0.a.z1.h.onEvent(fVar);
    }

    public static void W(d.b.g0.a.y0.e.e eVar, PMSAppInfo pMSAppInfo, boolean z, boolean z2, boolean z3) {
        if (p) {
            Log.d("SwanPkgMaintainer", "SwanPkgMaintainer#launchStatistic");
        }
        eVar.n0().putString("aiapp_extra_need_download", z ? "1" : "0");
        eVar.n0().putString("aiapp_extra_preset_pkg", z3 ? "1" : "0");
        eVar.n0().putString("aiapp_extra_pkg_downloading", z2 ? "1" : "0");
        d.b.g0.a.z1.k.f fVar = new d.b.g0.a.z1.k.f();
        fVar.f47250a = d.b.g0.a.z1.h.n(eVar.F());
        fVar.h(eVar);
        fVar.f47251b = Config.LAUNCH;
        fVar.n = z ? "1" : "0";
        fVar.p = z3 ? "1" : "0";
        fVar.o = z2 ? "1" : "0";
        long k = eVar.k("launch_interval", -1L);
        if (k >= 0 && k <= 5000) {
            fVar.a("launchInterval", Long.valueOf(k));
        }
        if (pMSAppInfo != null) {
            fVar.k = String.valueOf(pMSAppInfo.versionCode);
        }
        ExecutorUtilsExt.postOnElastic(new h(fVar, eVar.V(), eVar.n0().getString(UBCCloudControlProcessor.UBC_KEY)), "launchStatistic", 2);
    }

    public static void X(String str) {
        if (p) {
            Log.i("SwanPkgMaintainer", str);
        }
    }

    public final int L(@NonNull PMSAppInfo pMSAppInfo) {
        int i2 = pMSAppInfo.appStatus;
        if (i2 != 0) {
            return i2;
        }
        if (TextUtils.isEmpty(pMSAppInfo.appId)) {
            return 10001;
        }
        int F = S().F();
        int i3 = pMSAppInfo.appCategory;
        return (i3 > -1 || F == i3) ? 0 : 10002;
    }

    public final void M(String str, String str2, int i2) {
        Bundle bundle = new Bundle();
        bundle.putInt(str, i2);
        d.b.g0.a.r1.d.e().l(str2, bundle);
    }

    public final void N(PMSAppInfo pMSAppInfo) {
        if (pMSAppInfo != null) {
            i.a aVar = (i.a) ((i.a) new i.a("event_on_app_icon_update").w("mAppId", getAppId())).t("appFrameType", pMSAppInfo.appCategory);
            if (p) {
                X("dispatchPmsInfo appCategory=" + pMSAppInfo.appCategory);
            }
            if (!TextUtils.isEmpty(pMSAppInfo.appName)) {
                if (p) {
                    X("dispatchPmsInfo appName=" + pMSAppInfo.appName);
                }
                aVar.w(DpStatConstants.KEY_APP_NAME, pMSAppInfo.appName);
            }
            if (pMSAppInfo.versionCode > -1) {
                if (p) {
                    X("dispatchPmsInfo versionCode=" + pMSAppInfo.versionCode);
                }
                aVar.u(Constants.EXTRA_KEY_APP_VERSION_CODE, pMSAppInfo.versionCode);
            }
            if (!TextUtils.isEmpty(pMSAppInfo.iconUrl)) {
                if (p) {
                    X("dispatchPmsInfo iconUrl=" + pMSAppInfo.iconUrl);
                }
                aVar.w("app_icon_url", pMSAppInfo.iconUrl);
            }
            aVar.q("event_flag_force_post", true);
            t(aVar);
        }
    }

    public final synchronized void O() {
        this.j = 99;
        M("KEY_PKG_STATE", "event_pms_check_start", 99);
        b.a J = this.l.J();
        if (!d.b.g0.a.m1.a.a.C() && TextUtils.isEmpty(J.d0()) && (!p || !J.j0())) {
            String U = J.U();
            this.m = U;
            if (p) {
                d.b.g0.a.y0.g.a.d(U).f(IntentConfig.START);
            }
            d.b.g0.a.s0.k.f.b.d("1");
            HybridUbcFlow o = d.b.g0.a.j1.i.o("startup");
            o.z("type", "1");
            o.y("is_updating", String.valueOf(d.b.g0.a.e0.h.b.a.a().b()));
            o.A(new UbcFlowEvent("na_query_db_start"));
            PMSAppInfo c0 = this.l.J().c0();
            if (c0 == null || c0.l()) {
                c0 = d.b.g0.l.i.a.h().r(getAppId());
            }
            o.A(new UbcFlowEvent("na_query_db"));
            boolean e2 = d.b.g0.a.y0.h.a.e(c0);
            this.n = e2;
            this.i = (c0 == null || e2) ? false : true;
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("has_local_file");
            ubcFlowEvent.a(true);
            o.A(ubcFlowEvent);
            if (this.n) {
                p0(c0);
                N(this.o);
                UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("update_icon");
                ubcFlowEvent2.a(true);
                o.A(ubcFlowEvent2);
            }
            if (!this.n && d.b.g0.a.y0.h.a.f(this.o, J.b0())) {
                h0();
            } else {
                o0();
            }
            return;
        }
        a0(true);
    }

    public final void P(@NonNull String str, @NonNull d.b.g0.a.n1.a.b.c.b bVar) {
        d.b.g0.a.n1.c.e.a C = d.b.g0.a.n1.c.e.a.C();
        if (C == null) {
            d.b.g0.a.n1.a.b.a.b bVar2 = new d.b.g0.a.n1.a.b.a.b(bVar.b());
            Bundle bundle = new Bundle();
            bundle.putBoolean("isDownloading", false);
            bVar2.b(bundle);
            bVar.onEvent(bVar2);
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, str);
        C.J(bundle2, j.class, bVar);
    }

    public final Context Q() {
        SwanAppActivity n = this.l.n();
        return (n == null || n.isDestroyed()) ? d.b.g0.a.w0.a.c() : n;
    }

    public final d.b.g0.a.f2.a R(int i2) {
        d.b.g0.a.f2.a aVar = new d.b.g0.a.f2.a();
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

    public d.b.g0.a.y0.e.b S() {
        return this.l.J();
    }

    public synchronized boolean T() {
        return this.f45745f;
    }

    public synchronized boolean U() {
        return this.f45747h;
    }

    public synchronized void Y() {
        if (SwanAppProcessInfo.current().isSwanAppProcess() && this.l.f45740g && !T() && !U()) {
            boolean z = true;
            this.f45745f = true;
            HybridUbcFlow o = d.b.g0.a.j1.i.o("startup");
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("maintain_start");
            ubcFlowEvent.a(true);
            o.A(ubcFlowEvent);
            if (1 != this.l.J().F()) {
                z = false;
            }
            if (z || !d.b.g0.a.e0.w.d.L().a0()) {
                r("event_on_still_maintaining");
            }
            if (z) {
                c0();
            } else {
                O();
            }
        }
    }

    public final boolean Z() {
        HybridUbcFlow o = d.b.g0.a.j1.i.o("startup");
        PMSAppInfo pMSAppInfo = this.o;
        if (pMSAppInfo == null) {
            if (p) {
                Log.i("SwanPkgMaintainer", "AppInfo 为空，走Server同步下载");
            }
            o.y("launch_state", String.valueOf(0));
            M("KEY_PMS_UPDATE_TYPE", "event_pms_check_start", 0);
            return true;
        } else if (pMSAppInfo.appStatus != 0) {
            if (p) {
                Log.i("SwanPkgMaintainer", "有错误code，走Server同步下载");
            }
            this.i = true;
            o.y("launch_state", String.valueOf(2));
            M("KEY_PMS_UPDATE_TYPE", "event_pms_check_start", 2);
            return true;
        } else if (pMSAppInfo.j()) {
            if (p) {
                Log.i("SwanPkgMaintainer", "有悬而未决的的errCode要处理，走Server同步下载");
            }
            this.i = true;
            o.y("launch_state", String.valueOf(2));
            M("KEY_PMS_UPDATE_TYPE", "event_pms_check_start", 2);
            return true;
        } else if (this.o.l()) {
            if (d.b.g0.a.e0.h.b.a.a().c(getAppId())) {
                if (p) {
                    Log.i("SwanPkgMaintainer", "MaxAge已过期，但5小时内已通过SilentUpdateManager检测无新包，id =" + getAppId());
                }
                o.y("launch_state", String.valueOf(3));
                M("KEY_PMS_UPDATE_TYPE", "event_pms_check_start", 3);
                return false;
            }
            if (p) {
                Log.i("SwanPkgMaintainer", "本地包已过期");
            }
            M("KEY_PMS_UPDATE_TYPE", "event_pms_check_start", 1);
            o.y("launch_state", String.valueOf(1));
            this.k = true;
            return true;
        } else {
            o.y("launch_state", String.valueOf(4));
            M("KEY_PMS_UPDATE_TYPE", "event_pms_check_start", 4);
            return false;
        }
    }

    public final synchronized void a0(boolean z) {
        this.f45745f = false;
        this.f45747h = z;
        this.o = null;
        if (p) {
            X("notifyMaintainFinish: " + z);
        }
        t((i.a) new i.a("event_on_pkg_maintain_finish").w("mAppId", this.l.f45739f));
        if (p) {
            d.b.g0.a.y0.g.a.d(this.m).h();
        }
        this.m = "";
    }

    public int b0() {
        return this.j;
    }

    public final synchronized void c0() {
        HybridUbcFlow o = d.b.g0.a.j1.i.o("startup");
        UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("postExec-onhold");
        ubcFlowEvent.a(true);
        o.A(ubcFlowEvent);
        d.b.g0.a.r1.d.g().post(new a(o));
    }

    public final void d0(boolean z, String str, d.b.g0.a.f2.a aVar) {
        if (this.o == null) {
            return;
        }
        Context Q = Q();
        d.b.g0.a.r1.e O = d.b.g0.a.r1.e.O();
        if (O != null) {
            String format = String.format(Q.getResources().getString(d.b.g0.a.h.aiapps_open_failed_detail_format), k0.z(), d.b.g0.a.b2.b.g(d.b.g0.a.z0.f.V().L(), O.L().F()), String.valueOf(aVar.a()));
            if (!d.b.g0.a.w0.a.E().a(Q, O.B(), aVar)) {
                Intent intent = new Intent();
                intent.putExtra("pms_db_info_onload", this.o);
                intent.putExtra(SwanAppErrorActivity.KEY_SWAN_ERROR_TYPE, z ? SwanAppErrorActivity.TYPE_PATH_FORBIDDEN : SwanAppErrorActivity.TYPE_APP_FORBIDDEN);
                ForbiddenInfo forbiddenInfo = new ForbiddenInfo(S(), str, format);
                forbiddenInfo.enableSlidingFlag = -1;
                intent.putExtra(SwanAppErrorActivity.KEY_ERROR_FORBIDDEN_INFO, forbiddenInfo);
                intent.setComponent(new ComponentName(Q, SwanAppErrorActivity.class));
                if (!(Q instanceof Activity)) {
                    intent.addFlags(268435456);
                }
                Q.startActivity(intent);
            }
        }
        d.b.g0.a.z1.k.f fVar = new d.b.g0.a.z1.k.f();
        d.b.g0.a.y0.e.b S = S();
        fVar.f47250a = d.b.g0.a.z1.h.n(S.F());
        fVar.f47251b = Config.LAUNCH;
        fVar.f47253d = "success";
        fVar.i(S);
        fVar.a("status", "2");
        fVar.d(S.n0().getString(UBCCloudControlProcessor.UBC_KEY));
        d.b.g0.a.z1.h.onEvent(fVar);
    }

    public final void e0(d.b.g0.a.f2.a aVar) {
        d.b.g0.a.j1.i.j(aVar);
        Context Q = Q();
        if ((Q instanceof SwanAppActivity) && ((SwanAppActivity) Q).isDestroyed()) {
            if (p) {
                Log.d("SwanPkgMaintainer", "launcher activity closed, ignore launch err");
                return;
            }
            return;
        }
        d.b.g0.a.y0.e.b S = S();
        int F = S.F();
        d.b.g0.a.y0.d.a.f(d.b.g0.a.w0.a.c(), aVar, F, getAppId(), true);
        d.b.g0.a.z1.k.f fVar = new d.b.g0.a.z1.k.f();
        fVar.f47250a = d.b.g0.a.z1.h.n(F);
        fVar.f47251b = Config.LAUNCH;
        fVar.f47253d = "fail";
        fVar.a("errcode", String.valueOf(aVar.a()));
        fVar.a("msg", aVar.f().toString());
        fVar.h(S);
        fVar.d(S.n0().getString(UBCCloudControlProcessor.UBC_KEY));
        fVar.b(d.b.g0.a.z1.h.l(S.V()));
        d.b.g0.a.z1.h.onEvent(fVar);
        if (!aVar.k()) {
            d.b.g0.a.z1.k.d dVar = new d.b.g0.a.z1.k.d();
            dVar.q(d.b.g0.a.z1.h.n(F));
            dVar.p(aVar);
            dVar.m(getAppId());
            dVar.t(S.S());
            d.b.g0.a.z1.h.H(dVar);
            aVar.m();
        }
        d.b.g0.a.w0.a.U().a(false);
    }

    public boolean f0() {
        return this.f45746g;
    }

    public final void g0() {
        d.b.g0.a.u0.d.w(this.l);
    }

    public final void h0() {
        HybridUbcFlow o = d.b.g0.a.j1.i.o("startup");
        UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updateForIndependentPkgStart");
        ubcFlowEvent.a(true);
        o.A(ubcFlowEvent);
        if (p) {
            X("独立分包启动，本地有包--->打开小程序，异步更新主包");
        }
        d.b.g0.a.y0.e.b S = S();
        String c2 = d.b.g0.a.y0.h.a.c(this.o, S.b0());
        S.A0(true);
        S.N0(c2);
        Bundle bundle = new Bundle();
        bundle.putLong("pms_update_expect_pkg_ver", this.o.versionCode);
        m0(bundle);
        UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("updateForIndependentPkgEnd");
        ubcFlowEvent2.a(true);
        o.A(ubcFlowEvent2);
    }

    public final boolean i0(d.b.g0.a.f2.a aVar) {
        HybridUbcFlow o = d.b.g0.a.j1.i.o("startup");
        UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updateInfoWithFinalCheckStart");
        ubcFlowEvent.a(true);
        o.A(ubcFlowEvent);
        if (p) {
            X("updateInfoWithFinalCheck: mAppInfo=" + this.o);
        }
        PMSAppInfo pMSAppInfo = this.o;
        if (pMSAppInfo == null) {
            if (aVar == null) {
                aVar = new d.b.g0.a.f2.a();
                aVar.j(10L);
                aVar.h(2902L);
                aVar.e("no pkg was installed");
            }
            d.b.g0.a.f2.e.a().f(aVar);
            e0(aVar);
            return false;
        }
        int L = L(pMSAppInfo);
        if (L != 10001 && L != 10002) {
            k0();
            if (L != 0) {
                d.b.g0.a.f2.a R = R(10003);
                d.b.g0.a.f2.e.a().f(R);
                d0(false, null, R);
                d.b.g0.a.j1.i.j(R);
                d.b.g0.a.w0.a.U().a(false);
                return false;
            }
            if (d.b.g0.a.t1.k.g0.a.c().b(s().J().b0())) {
                d.b.g0.a.f2.a R2 = R(10004);
                d.b.g0.a.f2.e.a().f(R2);
                d0(true, d.b.g0.a.t1.k.g0.a.c().e(), R2);
                d.b.g0.a.j1.i.j(R2);
                d.b.g0.a.w0.a.U().a(false);
                return false;
            }
            return true;
        }
        if (aVar == null) {
            aVar = R(L);
        }
        d.b.g0.a.f2.e.a().f(aVar);
        e0(aVar);
        return false;
    }

    public final boolean j0(d.b.g0.a.f2.a aVar) {
        HybridUbcFlow o = d.b.g0.a.j1.i.o("startup");
        UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updateInstalledPkgWithFinalCheckStart");
        ubcFlowEvent.a(true);
        o.A(ubcFlowEvent);
        if (!i0(aVar)) {
            if (p) {
                X("updateInstalledPkgWithFinalCheck by null launchParams");
            }
            a0(false);
            return false;
        }
        UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("updateInfoWithFinalCheckOk");
        ubcFlowEvent2.a(true);
        o.A(ubcFlowEvent2);
        b.a J = this.l.J();
        long h2 = d.b.g0.a.b2.b.h(J.g0());
        long j2 = J.f0() != null ? J.f0().swanCoreVersion : 0L;
        if (p) {
            Log.d("SwanPkgMaintainer", "SwanCoreVersion target string version: " + J.g0() + " targetSwanVersion: " + h2 + " ,curSwanVersion: " + j2);
        }
        if (h2 > j2) {
            d.b.g0.a.b2.b.l(J.F());
        }
        d.b.g0.a.j1.i.o("startup").y("launch_type", String.valueOf(d.b.g0.a.h2.a.a()));
        if (J.F() == 0) {
            g0();
        }
        UbcFlowEvent ubcFlowEvent3 = new UbcFlowEvent("updateInstalledPkgWithFinalCheckEnd");
        ubcFlowEvent3.a(true);
        o.A(ubcFlowEvent3);
        a0(true);
        d.b.g0.a.j0.c d2 = d.b.g0.a.j0.e.c().d();
        if (d2 != null && d2.m()) {
            d2.b(getAppId());
        }
        return true;
    }

    public final void k0() {
        b.a J = s().J();
        PMSAppInfo pMSAppInfo = this.o;
        boolean z = (pMSAppInfo == null || TextUtils.isEmpty(pMSAppInfo.appId) || !TextUtils.equals(getAppId(), this.o.appId)) ? false : true;
        if (z) {
            J.K0(this.o);
        }
        int i2 = (z && this.o.appCategory == 1) ? 1 : 0;
        if (Looper.myLooper() == Looper.getMainLooper()) {
            J.p0(i2);
        } else {
            k0.X(new i(this, J, i2));
        }
    }

    public final void l0(d.b.g0.a.f2.a aVar) {
        if (j0(aVar)) {
            d.b.g0.a.z1.k.d dVar = new d.b.g0.a.z1.k.d();
            dVar.p(aVar);
            dVar.r(S());
            d.b.g0.a.z1.h.H(dVar);
        }
    }

    public final void m0(Bundle bundle) {
        HybridUbcFlow o = d.b.g0.a.j1.i.o("startup");
        UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updateLocalPkgWithAsyncUpdatePkgStart");
        ubcFlowEvent.a(true);
        o.A(ubcFlowEvent);
        if (p) {
            X("启动本地包，进程预处理-加载本地包-后台异步更新");
        }
        j0(null);
        d.b.g0.a.r1.d.g().post(new b(bundle));
        UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("updateLocalPkgWithAsyncUpdatePkgEnd");
        ubcFlowEvent2.a(true);
        o.A(ubcFlowEvent2);
    }

    public final void n0() {
        d.b.g0.a.r1.d.e().r("event_pms_check_start");
        HybridUbcFlow o = d.b.g0.a.j1.i.o("startup");
        UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updatePkgOnPresetUnavailableStart");
        ubcFlowEvent.a(true);
        o.A(ubcFlowEvent);
        d.b.g0.a.y0.e.b S = S();
        if (p) {
            X("预置包不可用");
        }
        boolean Z = Z();
        if (p) {
            Log.i("SwanPkgMaintainer", "updatePkgOnPresetUnavailable: isNeedFetchPkg " + Z);
        }
        if (!Z) {
            if (p) {
                X("可以直接打开小程序，异步从Server拉取新包");
            }
            this.j = 4;
            W(S, this.o, false, false, false);
            this.j = this.k ? 3 : 4;
            m0(null);
            M("KEY_PKG_STATE", "event_pms_check_finish", this.j);
            return;
        }
        if (p) {
            X("不能直接打开小程序，同步从Server拉取新包");
        }
        M("KEY_PKG_STATE", "event_pms_check_finish", this.j);
        P(this.l.J().G(), new d(S));
        d.b.g0.l.l.k.c cVar = new d.b.g0.l.l.k.c(getAppId(), S.F());
        cVar.d("3");
        PMSAppInfo pMSAppInfo = this.o;
        cVar.r(pMSAppInfo == null ? 0L : pMSAppInfo.versionCode);
        PMSAppInfo pMSAppInfo2 = this.o;
        cVar.m(pMSAppInfo2 != null ? pMSAppInfo2.appSign : 0L);
        String d2 = i0.d(S.b0());
        if (!TextUtils.isEmpty(d2)) {
            if (d2.startsWith(File.separator)) {
                d2 = d2.substring(1);
            }
            cVar.q(d2);
        }
        UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("updatePkgOnPresetUnavailableRequest");
        ubcFlowEvent2.a(true);
        o.A(ubcFlowEvent2);
        t((i.a) new i.a("event_on_still_maintaining").q(" event_params_pkg_update", this.n));
        g gVar = new g(this.l);
        gVar.c0(new f(o));
        gVar.e0(new e(o));
        gVar.L(this.k ? 2 : 1);
        d.b.g0.l.c.a(cVar, gVar);
        UbcFlowEvent ubcFlowEvent3 = new UbcFlowEvent("updatePkgOnPresetUnavailableReturn");
        ubcFlowEvent3.a(true);
        o.A(ubcFlowEvent3);
    }

    public final void o0() {
        HybridUbcFlow o = d.b.g0.a.j1.i.o("startup");
        UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updatePkgWithPresetCheckStart");
        ubcFlowEvent.a(true);
        o.A(ubcFlowEvent);
        if (p) {
            X(this.o == null ? "数据库或本地无主包信息，尝试加载预置包，并下载主包" : "包信息、文件都存在，尝试加载更高版本的预置包");
        }
        d.b.g0.a.e0.t.c c2 = d.b.g0.a.e0.t.f.b().c(getAppId());
        PMSAppInfo pMSAppInfo = this.o;
        long j2 = pMSAppInfo == null ? -1L : pMSAppInfo.versionCode;
        long j3 = c2 != null ? c2.i : -1L;
        boolean z = j3 > j2;
        if (p) {
            X(String.format(Locale.getDefault(), "尝试加载预制包，命中预制包=%b  currentVersion/presetVersion = %d/%d", Boolean.valueOf(z), Long.valueOf(j2), Long.valueOf(j3)));
        }
        if (!z) {
            n0();
            return;
        }
        r("event_on_still_maintaining");
        UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("updatePkgWithPresetCheckLoadPresetApp");
        ubcFlowEvent2.a(true);
        o.A(ubcFlowEvent2);
        d.b.g0.a.e0.t.f.b().e(c2, new c());
        UbcFlowEvent ubcFlowEvent3 = new UbcFlowEvent("updatePkgWithPresetCheckReturn");
        ubcFlowEvent3.a(true);
        o.A(ubcFlowEvent3);
    }

    public final void p0(PMSAppInfo pMSAppInfo) {
        this.o = pMSAppInfo;
        this.l.J().T0(pMSAppInfo);
    }
}
