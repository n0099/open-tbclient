package d.a.m0.a.j2;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import com.baidu.searchbox.http.statistics.NetworkStatRecord;
import com.baidu.searchbox.ubcprocessor.UBCCloudControlProcessor;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.favordata.SwanFavorItemData;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.scheme.actions.forbidden.ForbiddenInfo;
import com.baidu.wallet.paysdk.banksign.datamodel.QueryResponse;
import com.facebook.common.internal.Sets;
import d.a.m0.a.f1.e.b;
import d.a.m0.a.j2.n;
import d.a.m0.a.v2.q;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import okhttp3.HttpUrl;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class k {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f46917a = d.a.m0.a.k.f46983a;

    /* renamed from: b  reason: collision with root package name */
    public static final ExecutorService f46918b = Executors.newSingleThreadExecutor();

    /* renamed from: c  reason: collision with root package name */
    public static final Set<String> f46919c = Sets.newHashSet("hmma.baidu.com");

    /* renamed from: d  reason: collision with root package name */
    public static final CopyOnWriteArrayList<String> f46920d;

    /* loaded from: classes3.dex */
    public static class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f46921e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f46922f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ long f46923g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f46924h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ int f46925i;
        public final /* synthetic */ String j;
        public final /* synthetic */ String k;
        public final /* synthetic */ String l;
        public final /* synthetic */ String m;
        public final /* synthetic */ NetworkStatRecord n;

        public a(String str, long j, long j2, int i2, int i3, String str2, String str3, String str4, String str5, NetworkStatRecord networkStatRecord) {
            this.f46921e = str;
            this.f46922f = j;
            this.f46923g = j2;
            this.f46924h = i2;
            this.f46925i = i3;
            this.j = str2;
            this.k = str3;
            this.l = str4;
            this.m = str5;
            this.n = networkStatRecord;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (SwanAppNetworkUtils.i(null)) {
                if (k.n(this.f46921e)) {
                    if (k.f46917a) {
                        Log.d("SwanAppUBCStatistic", "onRequest: ignore " + this.f46921e);
                        return;
                    }
                    return;
                }
                long j = this.f46922f - this.f46923g;
                boolean z = this.f46924h == 200;
                if (this.f46925i == 0) {
                    if (TextUtils.equals(this.j, "1")) {
                        if (z) {
                            d.a.m0.a.h0.i.i.p(this.f46921e, j);
                        } else {
                            d.a.m0.a.h0.i.i.n(this.f46921e, this.f46924h);
                        }
                    } else if (TextUtils.equals(this.j, "0")) {
                        d.a.m0.a.h0.i.i.o(this.f46921e);
                    }
                }
                if (z && j < 5000) {
                    if (k.f46917a) {
                        Log.d("SwanAppUBCStatistic", "code 200 & cost(" + (this.f46922f - this.f46923g) + ") is ok, don't report");
                        return;
                    }
                    return;
                }
                k.j(this.f46924h, this.f46921e, this.f46925i, this.k, this.l, this.m, this.j, this.f46923g, this.f46922f, this.n);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f46926e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f46927f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f46928g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f46929h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f46930i;
        public final /* synthetic */ String j;
        public final /* synthetic */ int k;

        public b(String str, int i2, String str2, String str3, String str4, String str5, int i3) {
            this.f46926e = str;
            this.f46927f = i2;
            this.f46928g = str2;
            this.f46929h = str3;
            this.f46930i = str4;
            this.j = str5;
            this.k = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.m0.a.j2.p.c cVar;
            int a2 = d.a.m0.a.n1.l.a();
            if (k.f46917a) {
                Log.d("SwanAppUBCStatistic", "get NetworkQuality: " + a2);
            }
            if (TextUtils.equals(this.f46926e, "1")) {
                cVar = new d.a.m0.a.j2.p.c(this.f46927f, this.f46928g, this.f46929h, a2);
            } else {
                cVar = new d.a.m0.a.j2.p.c(this.f46928g, a2, 0L, 0L);
            }
            new n.a(cVar, "downloadFile");
            if (!TextUtils.isEmpty(this.f46930i)) {
                cVar.q(this.f46930i);
            }
            if (!TextUtils.isEmpty(this.j)) {
                cVar.p(this.j);
            }
            cVar.f46970b = "downloadFile";
            if (d.a.m0.a.a2.e.i() != null && d.a.m0.a.a2.e.i().N() != null) {
                cVar.f46971c = d.a.m0.a.a2.e.i().N().T();
            }
            cVar.f46974f = d.a.m0.a.a2.e.V();
            cVar.f46969a = k.m(this.k);
            JSONObject f2 = cVar.f();
            d.a.m0.a.j2.b.k("834", f2);
            d.a.m0.a.e0.d.h("SwanAppUBCStatistic", "834-downloadFile event=" + f2.toString());
        }
    }

    /* loaded from: classes3.dex */
    public static class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.j2.p.e f46931e;

        public c(d.a.m0.a.j2.p.e eVar) {
            this.f46931e = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.m0.a.j2.b.k("894", this.f46931e.f());
        }
    }

    /* loaded from: classes3.dex */
    public static class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.j2.p.b f46932e;

        public d(d.a.m0.a.j2.p.b bVar) {
            this.f46932e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.m0.a.j2.b.k("751", this.f46932e.f());
        }
    }

    /* loaded from: classes3.dex */
    public static class e implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f46933e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ForbiddenInfo f46934f;

        public e(String str, ForbiddenInfo forbiddenInfo) {
            this.f46933e = str;
            this.f46934f = forbiddenInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.m0.a.j2.p.d dVar = new d.a.m0.a.j2.p.d();
            dVar.f46973e = this.f46933e;
            dVar.f46970b = "show";
            dVar.f46969a = "swan";
            ForbiddenInfo forbiddenInfo = this.f46934f;
            dVar.f46971c = forbiddenInfo.launchSource;
            dVar.a("path", forbiddenInfo.launchPath);
            dVar.a("appkey", this.f46934f.appId);
            d.a.m0.a.j2.b.m("1400", dVar.f());
        }
    }

    /* loaded from: classes3.dex */
    public static class f implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f46935e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f46936f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f46937g;

        public f(String str, String str2, int i2) {
            this.f46935e = str;
            this.f46936f = str2;
            this.f46937g = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.m0.a.a2.e Q = d.a.m0.a.a2.e.Q();
            if (Q == null) {
                return;
            }
            b.a L = Q.L();
            String O = Q.O();
            String appId = Q.getAppId();
            d.a.m0.a.j2.p.d dVar = new d.a.m0.a.j2.p.d();
            dVar.f46970b = "login";
            dVar.f46969a = k.m(L.G());
            dVar.f46974f = appId;
            dVar.f46973e = this.f46935e;
            dVar.a("appName", O);
            dVar.a("invokeFrom", this.f46936f);
            dVar.a("scene", Integer.valueOf(this.f46937g));
            if (TextUtils.equals(this.f46935e, "show")) {
                d.a.m0.a.j2.b.i("1936", "80", dVar.f());
            } else if (TextUtils.equals(this.f46935e, "success")) {
                d.a.m0.a.j2.b.i("1936", "81", dVar.f());
            } else if (TextUtils.equals(this.f46935e, com.baidu.pass.biometrics.face.liveness.b.a.g0)) {
                d.a.m0.a.j2.b.i("1936", "82", dVar.f());
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class g implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f46938e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f46939f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f46940g;

        public g(String str, String str2, String str3) {
            this.f46938e = str;
            this.f46939f = str2;
            this.f46940g = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.m0.a.a2.e r = d.a.m0.a.a2.d.g().r();
            b.a L = r.L();
            String O = r.O();
            String appId = r.getAppId();
            d.a.m0.a.j2.p.d dVar = new d.a.m0.a.j2.p.d();
            dVar.f46970b = "swanLogin";
            dVar.f46969a = k.m(L.G());
            dVar.f46974f = appId;
            dVar.f46973e = this.f46938e;
            dVar.a("appName", O);
            dVar.a("loginScene", this.f46939f);
            String str = this.f46940g;
            if (str != null) {
                dVar.a("errorInfo", str);
            }
            d.a.m0.a.j2.b.i("1936", "1936", dVar.f());
            if (k.f46917a) {
                Log.i("SwanAppUBCStatistic", "onSwanLoginProcessStatistic: scene = " + this.f46939f + " value = " + this.f46938e + " info = " + this.f46940g);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class h implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.j2.p.e f46941e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.j2.a f46942f;

        public h(d.a.m0.a.j2.p.e eVar, d.a.m0.a.j2.a aVar) {
            this.f46941e = eVar;
            this.f46942f = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.m0.a.j2.p.e eVar = this.f46941e;
            if (eVar != null) {
                d.a.m0.a.j2.b.f(this.f46942f, eVar.f().toString());
            }
            d.a.m0.a.j2.b.c(this.f46942f);
        }
    }

    /* loaded from: classes3.dex */
    public static class i implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.j2.p.d f46943e;

        public i(d.a.m0.a.j2.p.d dVar) {
            this.f46943e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (TextUtils.isEmpty(this.f46943e.g())) {
                this.f46943e.k(d.a.m0.a.a2.d.g().r().L().V());
            }
            d.a.m0.a.j2.b.k("671", this.f46943e.f());
            d.a.m0.a.e0.d.h("SwanAppUBCStatistic", "671 event=" + this.f46943e.f().toString());
        }
    }

    /* loaded from: classes3.dex */
    public static class j implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f46944e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.j2.p.e f46945f;

        public j(String str, d.a.m0.a.j2.p.e eVar) {
            this.f46944e = str;
            this.f46945f = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.m0.a.j2.b.k(this.f46944e, this.f46945f.f());
        }
    }

    /* renamed from: d.a.m0.a.j2.k$k  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class RunnableC0783k implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f46946e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f46947f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.j2.p.e f46948g;

        public RunnableC0783k(String str, String str2, d.a.m0.a.j2.p.e eVar) {
            this.f46946e = str;
            this.f46947f = str2;
            this.f46948g = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.m0.a.j2.b.i(this.f46946e, this.f46947f, this.f46948g.f());
        }
    }

    /* loaded from: classes3.dex */
    public static class l implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.j2.p.b f46949e;

        public l(d.a.m0.a.j2.p.b bVar) {
            this.f46949e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.m0.a.j2.b.k("751", this.f46949e.f());
        }
    }

    /* loaded from: classes3.dex */
    public static class m implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.j2.p.b f46950e;

        public m(d.a.m0.a.j2.p.b bVar) {
            this.f46950e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.m0.a.j2.b.k("751", this.f46950e.f());
        }
    }

    /* loaded from: classes3.dex */
    public static class n implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.j2.p.b f46951e;

        public n(d.a.m0.a.j2.p.b bVar) {
            this.f46951e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.m0.a.j2.b.k("751", this.f46951e.f());
        }
    }

    /* loaded from: classes3.dex */
    public static class o implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.j2.p.e f46952e;

        public o(d.a.m0.a.j2.p.e eVar) {
            this.f46952e = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f46952e.b(k.R());
            d.a.m0.a.j2.b.k("778", this.f46952e.f());
        }
    }

    static {
        CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        f46920d = copyOnWriteArrayList;
        copyOnWriteArrayList.add("https://hmma.baidu.com/mini.gif");
        f46920d.add("https://dxp.baidu.com/mini");
        f46920d.add(d.a.m0.a.d0.a.c() + "/smtapp/recordhandler/getrecordinfo");
        f46920d.add(d.a.m0.a.d0.a.d() + "/smtapp/recordhandler/getrecordinfo");
    }

    public static void A() {
        b.a L;
        Bundle P;
        if (d.a.m0.a.a2.d.g().C() && (P = (L = d.a.m0.a.a2.d.g().r().L()).P()) != null && P.getLong("launch_flag_for_statistic") > 0) {
            long l2 = L.l("launch_time", 0L);
            long currentTimeMillis = System.currentTimeMillis();
            d.a.m0.a.j2.p.f fVar = new d.a.m0.a.j2.p.f();
            fVar.f46969a = m(d.a.m0.a.a2.d.g().l());
            fVar.f46974f = L.H();
            if (d.a.m0.a.u1.a.a.E(L.g0())) {
                fVar.f46971c = "remote-debug";
            } else if (d.a.m0.a.u1.a.a.C()) {
                fVar.f46971c = "local-debug";
            } else {
                fVar.f46971c = L.T();
            }
            fVar.f46970b = "launch";
            fVar.f46973e = "success";
            fVar.r = String.valueOf(currentTimeMillis - l2);
            fVar.a("status", "0");
            d.a.m0.a.j2.e.n(fVar, L.W(), L.r0().getString(UBCCloudControlProcessor.UBC_KEY));
            P.putLong("launch_flag_for_statistic", 0L);
            HybridUbcFlow d2 = d.a.m0.a.r1.h.d("startup");
            if (d2 != null) {
                if (d2.t() || d2.r()) {
                    return;
                }
                d2.B("value", "na_success");
            }
        }
    }

    public static void B(boolean z, String str) {
        d.a.m0.a.j2.p.e eVar = new d.a.m0.a.j2.p.e();
        if (d.a.m0.a.a2.d.g().r().e()) {
            eVar.d(d.a.m0.a.a2.d.g().r().L().r0().getString(UBCCloudControlProcessor.UBC_KEY));
        }
        eVar.f46970b = "show";
        eVar.f46971c = str;
        eVar.f46973e = z ? "success" : com.baidu.pass.biometrics.face.liveness.b.a.g0;
        eVar.f46974f = d.a.m0.a.a2.e.V();
        d.a.m0.a.r1.k.i.c.f().e(new o(eVar), "SwanAppUBCOnPagesRoute");
    }

    public static void C(String str, String str2, List<String> list) {
        int i2;
        String str3;
        if (d.a.m0.a.a2.d.g().r().e()) {
            b.a L = d.a.m0.a.a2.d.g().r().L();
            i2 = L.G();
            str3 = L.r0().getString(UBCCloudControlProcessor.UBC_KEY);
        } else {
            i2 = 0;
            str3 = "";
        }
        d.a.m0.a.j2.p.b bVar = new d.a.m0.a.j2.p.b();
        bVar.f46970b = "pay";
        bVar.f46971c = str;
        bVar.f46974f = d.a.m0.a.a2.e.V();
        bVar.f46969a = m(i2);
        try {
            JSONObject jSONObject = new JSONObject(str3);
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put("paymenturl", str2);
            }
            if (list != null) {
                jSONObject.put("whitelist", list);
            }
            jSONObject.put("appname", d.a.m0.a.a2.e.i().O());
            bVar.e(jSONObject);
        } catch (JSONException e2) {
            e2.printStackTrace();
            bVar.d(str3);
        }
        bVar.b(R());
        q.j(new m(bVar), "SwanAppUBCOnPay");
    }

    public static void D(boolean z, String str, String str2) {
        d.a.m0.a.j2.p.b bVar = new d.a.m0.a.j2.p.b();
        b.a L = d.a.m0.a.a2.d.g().r().L();
        if (d.a.m0.a.a2.d.g().r().e()) {
            bVar.d(L.r0().getString(UBCCloudControlProcessor.UBC_KEY));
        }
        bVar.f46970b = "pay";
        bVar.f46973e = z ? "success" : com.baidu.pass.biometrics.face.liveness.b.a.g0;
        bVar.f46971c = str;
        bVar.f46974f = d.a.m0.a.a2.e.V();
        bVar.f46969a = m(L.G());
        bVar.a("money", str2);
        bVar.b(R());
        q.i(new l(bVar), "SwanAppUBCOnPay");
    }

    public static void E(String str, boolean z, boolean z2) {
        d.a.m0.a.j2.p.b bVar = new d.a.m0.a.j2.p.b();
        b.a L = d.a.m0.a.a2.d.g().r().L();
        if (d.a.m0.a.a2.d.g().r().e()) {
            bVar.d(L.r0().getString(UBCCloudControlProcessor.UBC_KEY));
        }
        bVar.f46970b = "paylogin";
        bVar.f46971c = str;
        bVar.f46974f = L.I();
        bVar.f46969a = m(L.G());
        bVar.f46973e = z ? "success" : com.baidu.pass.biometrics.face.liveness.b.a.g0;
        bVar.a("nativeAppId", d.a.m0.a.c1.a.m().a());
        bVar.a("paylogin", z2 ? "1" : "0");
        d.a.m0.a.h0.g.f J = d.a.m0.a.g1.f.V().J();
        d.a.m0.a.l1.c K1 = J == null ? null : J.K1();
        if (K1 != null && !TextUtils.isEmpty(K1.g())) {
            bVar.a("page", K1.g());
        }
        bVar.b(R());
        q.i(new d(bVar), "SwanAppUBCOnPayLogin");
    }

    public static void F(String str, String str2, int i2) {
        if (d.a.m0.a.a2.d.g().r().e()) {
            b.a L = d.a.m0.a.a2.d.g().r().L();
            int G = L.G();
            d.a.m0.a.j2.p.b bVar = new d.a.m0.a.j2.p.b();
            bVar.f46970b = "payProcess";
            bVar.f46969a = m(G);
            bVar.f46971c = str;
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
        d.a.m0.a.j2.p.f fVar = new d.a.m0.a.j2.p.f();
        fVar.f46970b = "launch";
        fVar.f46973e = str;
        if (d.a.m0.a.a2.e.Q() != null) {
            b.a L = d.a.m0.a.a2.e.Q().L();
            fVar.f46969a = m(L.G());
            fVar.f46974f = L.H();
            fVar.f46971c = L.T();
        }
        fVar.t = str2;
        onEvent(fVar);
    }

    public static void H(int i2, String str, int i3, String str2, @Nullable String str3, @Nullable String str4, String str5, long j2, long j3, @Nullable NetworkStatRecord networkStatRecord) {
        f46918b.execute(new a(str, j3, j2, i2, i3, str5, str2, str3, str4, networkStatRecord));
    }

    public static void I(String str, String str2, @NonNull JSONObject jSONObject) {
        if (!TextUtils.equals(str, "1")) {
            if (f46917a) {
                Log.d("SwanAppUBCStatistic", "RequestForAvatar: onRequestForAvatar: miss. requestType=" + str);
            }
        } else if (TextUtils.isEmpty(str2)) {
            if (f46917a) {
                Log.d("SwanAppUBCStatistic", "RequestForAvatar: onRequestForAvatar: miss. url is empty");
            }
        } else {
            HttpUrl parse = HttpUrl.parse(str2);
            if (parse == null) {
                if (f46917a) {
                    Log.d("SwanAppUBCStatistic", "RequestForAvatar: onRequestForAvatar: miss. url is illegal, url=" + str2);
                    return;
                }
                return;
            }
            String host = parse.host();
            if (TextUtils.isEmpty(host)) {
                if (f46917a) {
                    Log.d("SwanAppUBCStatistic", "RequestForAvatar: onRequestForAvatar: miss. host is empty, url=" + str2);
                }
            } else if (f46919c.contains(host)) {
                if (f46917a) {
                    Log.d("SwanAppUBCStatistic", "RequestForAvatar: onRequestForAvatar: miss. host is ignored, host=" + host + " ,url=" + str2);
                }
            } else {
                if (f46917a) {
                    Log.d("SwanAppUBCStatistic", "RequestForAvatar: onRequestForAvatar: hit. url=" + str2);
                    Log.d("SwanAppUBCStatistic", "value=" + jSONObject);
                }
                d.a.m0.a.j2.b.i("1415", "66", jSONObject);
            }
        }
    }

    public static void J(int i2, String str, int i3, String str2, long j2, long j3) {
        K(i2, str, i3, str2, null, null, j2, j3);
    }

    public static void K(int i2, String str, int i3, String str2, @Nullable String str3, @Nullable String str4, long j2, long j3) {
        H(i2, str, i3, str2, str3, str4, "1", j2, j3, null);
    }

    public static void L(d.a.m0.a.j2.p.d dVar) {
        if (dVar == null) {
            return;
        }
        q.i(new i(dVar), "SwanAppUBCStability");
    }

    public static void M(String str, int i2, String str2) {
        f46918b.execute(new f(str, str2, i2));
    }

    public static void N(String str, String str2) {
        O(str, str2, null);
    }

    public static void O(String str, String str2, String str3) {
        f46918b.execute(new g(str2, str, str3));
    }

    public static JSONObject P(@Nullable NetworkStatRecord networkStatRecord) {
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
            if (f46917a) {
                e2.printStackTrace();
            }
            return null;
        }
    }

    public static void Q() {
        d.a.m0.a.a2.d g2 = d.a.m0.a.a2.d.g();
        d.a.m0.a.a2.e r = g2.r();
        b.a L = r.L();
        if (g2.C() && r.i0()) {
            Bundle r0 = L.r0();
            if (r0.getLong("launch_flag_for_statistic") > 0) {
                String valueOf = String.valueOf(System.currentTimeMillis() - r.L().s1());
                d.a.m0.a.j2.p.f fVar = new d.a.m0.a.j2.p.f();
                fVar.f46969a = m(L.G());
                fVar.f46970b = "launch";
                fVar.f46973e = QueryResponse.Options.CANCEL;
                fVar.q = valueOf;
                fVar.j(L);
                fVar.d(r0.getString(UBCCloudControlProcessor.UBC_KEY));
                fVar.b(k(L.W()));
                onEvent(fVar);
                d.a.m0.a.j2.p.f fVar2 = new d.a.m0.a.j2.p.f();
                fVar2.f46969a = m(L.G());
                fVar2.f46970b = "launch";
                fVar2.f46973e = "realcancel";
                fVar2.q = valueOf;
                fVar2.j(L);
                fVar2.b(k(L.W()));
                fVar2.a("reason", QueryResponse.Options.CANCEL);
                if (L.G() == 1) {
                    fVar.a("errorList", d.a.m0.a.c1.b.j().a());
                }
                fVar2.d(r0.getString(UBCCloudControlProcessor.UBC_KEY));
                onEvent(fVar2);
                r0.remove("launch_flag_for_statistic");
            }
        }
    }

    public static JSONObject R() {
        b.a N;
        JSONObject M;
        d.a.m0.a.a2.e i2 = d.a.m0.a.a2.e.i();
        if (i2 == null || (N = i2.N()) == null || (M = N.M()) == null || !TextUtils.equals(M.optString("token"), "swanubc")) {
            return null;
        }
        return M;
    }

    public static d.a.m0.a.j2.a c(String str) {
        return d.a.m0.a.j2.b.a(str);
    }

    public static void d(d.a.m0.a.j2.p.f fVar) {
        if (fVar == null || d.a.m0.a.a2.e.i() == null || d.a.m0.a.a2.e.i().N() == null) {
            return;
        }
        b.a N = d.a.m0.a.a2.e.i().N();
        fVar.f46969a = m(N.G());
        fVar.f46974f = N.H();
        fVar.a("appkey", N.I());
        u("1032", fVar);
    }

    public static void e(String str) {
        d.a.m0.a.j2.p.e eVar = new d.a.m0.a.j2.p.e();
        eVar.f46969a = m(0);
        eVar.f46970b = str;
        u("956", eVar);
    }

    public static void f(String str, String str2, String str3) {
        d.a.m0.a.j2.p.e eVar = new d.a.m0.a.j2.p.e();
        if (d.a.m0.a.a2.e.i() != null && d.a.m0.a.a2.e.i().N() != null) {
            b.a N = d.a.m0.a.a2.e.i().N();
            eVar.f46969a = m(N.G());
            eVar.f46974f = N.H();
            eVar.f46970b = str;
            eVar.f46971c = str2;
            eVar.f46973e = str3;
            eVar.a("appkey", N.I());
        }
        u("923", eVar);
    }

    public static void g(d.a.m0.a.j2.p.e eVar) {
        if (d.a.m0.a.a2.e.i() != null && d.a.m0.a.a2.e.i().N() != null) {
            b.a N = d.a.m0.a.a2.e.i().N();
            eVar.f46969a = m(N.G());
            eVar.f46974f = N.H();
            eVar.f46971c = N.T();
        }
        u("936", eVar);
    }

    public static void h(d.a.m0.a.j2.p.e eVar) {
        if (d.a.m0.a.a2.e.i() != null && d.a.m0.a.a2.e.i().N() != null) {
            b.a N = d.a.m0.a.a2.e.i().N();
            eVar.f46969a = m(N.G());
            eVar.f46974f = N.H();
            eVar.f46971c = N.T();
        }
        u("914", eVar);
    }

    public static void i(d.a.m0.a.j2.a aVar, d.a.m0.a.j2.p.e eVar) {
        if (aVar == null) {
            return;
        }
        q.i(new h(eVar, aVar), "SwanAppUBCEndFlow");
    }

    @WorkerThread
    public static void j(int i2, String str, int i3, String str2, @Nullable String str3, @Nullable String str4, String str5, long j2, long j3, @Nullable NetworkStatRecord networkStatRecord) {
        d.a.m0.a.j2.p.c cVar;
        int a2 = d.a.m0.a.n1.l.a();
        if (f46917a) {
            Log.d("SwanAppUBCStatistic", "get NetworkQuality: " + a2);
        }
        if (TextUtils.equals(str5, "1")) {
            cVar = new d.a.m0.a.j2.p.c(i2, str, str2, a2, j2, j3);
        } else {
            cVar = new d.a.m0.a.j2.p.c(str, a2, j2, j3);
        }
        n.a aVar = new n.a(cVar, "request");
        if (!TextUtils.isEmpty(str3)) {
            cVar.q(str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            cVar.p(str4);
        }
        cVar.f46970b = "request";
        d.a.m0.a.a2.e r = d.a.m0.a.a2.d.g().r();
        if (r != null && r.e()) {
            cVar.f46971c = r.L().T();
            cVar.f46972d = r.L().V();
        }
        cVar.f46974f = d.a.m0.a.a2.e.V();
        cVar.f46969a = m(i3);
        JSONObject P = P(networkStatRecord);
        aVar.f46962b = P;
        if (P != null) {
            cVar.e(P);
        }
        if (f46917a) {
            Log.d("SwanAppUBCStatistic", "Reporting: " + cVar.f());
        }
        JSONObject f2 = cVar.f();
        d.a.m0.a.j2.b.k("834", f2);
        I(cVar.m(), cVar.n(), f2);
        d.a.m0.a.e0.d.h("SwanAppUBCStatistic", "834-request event=" + f2.toString());
    }

    public static JSONObject k(String str) {
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
                if (f46917a) {
                    e2.printStackTrace();
                }
            }
        }
        return null;
    }

    public static String l() {
        return d.a.m0.a.m1.f.g() ? "1" : "0";
    }

    public static String m(int i2) {
        return i2 != 1 ? "swan" : SwanFavorItemData.SCHEME_AUTHORITY_SWAN_GAME;
    }

    public static boolean n(String str) {
        if (f46917a) {
            Log.d("SwanAppUBCStatistic", "isIgnoreRequest: start with " + str);
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        int size = f46920d.size();
        for (int i2 = 0; i2 < size; i2++) {
            String str2 = f46920d.get(i2);
            if (!TextUtils.isEmpty(str2) && str.startsWith(str2)) {
                if (f46917a) {
                    Log.d("SwanAppUBCStatistic", "isIgnoreRequest: ignore " + str);
                    return true;
                }
                return true;
            }
        }
        return false;
    }

    public static void o(String str, String str2, boolean z) {
        d.a.m0.a.j2.p.e eVar = new d.a.m0.a.j2.p.e();
        eVar.f46970b = str;
        eVar.f46973e = str2;
        eVar.f46974f = d.a.m0.a.a2.e.V();
        if (d.a.m0.a.a2.e.i() != null && d.a.m0.a.a2.e.i().N() != null) {
            b.a N = d.a.m0.a.a2.e.i().N();
            eVar.f46971c = N.T();
            eVar.f46969a = m(N.G());
        }
        if (TextUtils.equals(PrefetchEvent.STATE_CLICK, str)) {
            eVar.a("authorize", z ? "success" : com.baidu.pass.biometrics.face.liveness.b.a.g0);
        }
        q.j(new c(eVar), "SwanAppUBCOnAuthDialog");
    }

    public static void onEvent(d.a.m0.a.j2.p.f fVar) {
        ExtensionCore M = d.a.m0.a.h0.u.g.N().M();
        if (M != null) {
            fVar.a("extension_ver", M.extensionCoreVersionName);
        }
        fVar.a("isReloadApp", d.a.m0.a.a2.d.g().r().L().d("launch_by_reload") ? "1" : "0");
        u("606", fVar);
    }

    public static void p(int i2, d.a.m0.a.e2.c.f fVar) {
        d.a.m0.a.a2.e Q = d.a.m0.a.a2.e.Q();
        if (Q == null) {
            if (f46917a) {
                Log.e("SwanAppUBCStatistic", "onAuthorizeFailed-swanApp is null");
                return;
            }
            return;
        }
        d.a.m0.a.j2.p.d dVar = new d.a.m0.a.j2.p.d();
        dVar.o(i2);
        dVar.r(Q.N());
        dVar.q(m(Q.l()));
        dVar.m(Q.getAppId());
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appid", Q.getAppId());
            jSONObject.put("msg", d.a.m0.a.e2.c.d.f(i2));
            jSONObject.put(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID, Q.T().q("cur_request_id", ""));
            if (fVar != null) {
                jSONObject.put("scope", fVar.f45479b);
                jSONObject.put("scopeData", fVar.f45478a);
            }
        } catch (JSONException e2) {
            if (f46917a) {
                e2.printStackTrace();
            }
        }
        dVar.e(jSONObject);
        L(dVar);
    }

    @WorkerThread
    public static void q(int i2, String str, int i3, String str2, @Nullable String str3, @Nullable String str4, String str5) {
        if (i2 == 200) {
            return;
        }
        f46918b.execute(new b(str5, i2, str, str2, str3, str4, i3));
    }

    public static void r(int i2, String str, int i3, String str2) {
        q(i2, str, i3, str2, null, null, "1");
    }

    public static void s(int i2, String str, int i3, String str2, @Nullable String str3, @Nullable String str4) {
        q(i2, str, i3, str2, str3, str4, "1");
    }

    public static void t(ForbiddenInfo forbiddenInfo, String str) {
        if (forbiddenInfo == null || TextUtils.isEmpty(str)) {
            return;
        }
        f46918b.execute(new e(str, forbiddenInfo));
    }

    public static void u(String str, d.a.m0.a.j2.p.e eVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        d.a.m0.a.r1.k.i.c.f().e(new j(str, eVar), "SwanAppUBCOnEvent");
    }

    public static void v(String str, String str2, d.a.m0.a.j2.p.e eVar) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        q.i(new RunnableC0783k(str, str2, eVar), "SwanAppUbcCeresOnEvent");
    }

    public static void w(String str, int i2, String str2) {
        d.a.m0.a.a2.e Q = d.a.m0.a.a2.e.Q();
        if (Q == null) {
            return;
        }
        d.a.m0.a.q2.a aVar = new d.a.m0.a.q2.a();
        aVar.j(5L);
        aVar.h(50L);
        d.a.m0.a.j2.p.d dVar = new d.a.m0.a.j2.p.d();
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
            if (f46917a) {
                e2.printStackTrace();
            }
        }
        dVar.e(jSONObject);
        L(dVar);
    }

    public static void x(String str, int i2) {
        q(0, str, i2, null, null, null, "0");
    }

    public static void y(String str, int i2, NetworkStatRecord networkStatRecord) {
        z(str, i2, networkStatRecord, 0L, 0L);
    }

    public static void z(String str, int i2, NetworkStatRecord networkStatRecord, long j2, long j3) {
        H(0, str, i2, null, null, null, "0", j2, j3, networkStatRecord);
    }
}
