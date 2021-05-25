package d.a.l0.a.j2;

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
import d.a.l0.a.f1.e.b;
import d.a.l0.a.j2.n;
import d.a.l0.a.v2.q;
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
    public static final boolean f43133a = d.a.l0.a.k.f43199a;

    /* renamed from: b  reason: collision with root package name */
    public static final ExecutorService f43134b = Executors.newSingleThreadExecutor();

    /* renamed from: c  reason: collision with root package name */
    public static final Set<String> f43135c = Sets.newHashSet("hmma.baidu.com");

    /* renamed from: d  reason: collision with root package name */
    public static final CopyOnWriteArrayList<String> f43136d;

    /* loaded from: classes3.dex */
    public static class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f43137e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f43138f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ long f43139g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f43140h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ int f43141i;
        public final /* synthetic */ String j;
        public final /* synthetic */ String k;
        public final /* synthetic */ String l;
        public final /* synthetic */ String m;
        public final /* synthetic */ NetworkStatRecord n;

        public a(String str, long j, long j2, int i2, int i3, String str2, String str3, String str4, String str5, NetworkStatRecord networkStatRecord) {
            this.f43137e = str;
            this.f43138f = j;
            this.f43139g = j2;
            this.f43140h = i2;
            this.f43141i = i3;
            this.j = str2;
            this.k = str3;
            this.l = str4;
            this.m = str5;
            this.n = networkStatRecord;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (SwanAppNetworkUtils.i(null)) {
                if (k.n(this.f43137e)) {
                    if (k.f43133a) {
                        Log.d("SwanAppUBCStatistic", "onRequest: ignore " + this.f43137e);
                        return;
                    }
                    return;
                }
                long j = this.f43138f - this.f43139g;
                boolean z = this.f43140h == 200;
                if (this.f43141i == 0) {
                    if (TextUtils.equals(this.j, "1")) {
                        if (z) {
                            d.a.l0.a.h0.i.i.p(this.f43137e, j);
                        } else {
                            d.a.l0.a.h0.i.i.n(this.f43137e, this.f43140h);
                        }
                    } else if (TextUtils.equals(this.j, "0")) {
                        d.a.l0.a.h0.i.i.o(this.f43137e);
                    }
                }
                if (z && j < 5000) {
                    if (k.f43133a) {
                        Log.d("SwanAppUBCStatistic", "code 200 & cost(" + (this.f43138f - this.f43139g) + ") is ok, don't report");
                        return;
                    }
                    return;
                }
                k.j(this.f43140h, this.f43137e, this.f43141i, this.k, this.l, this.m, this.j, this.f43139g, this.f43138f, this.n);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f43142e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f43143f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f43144g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f43145h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f43146i;
        public final /* synthetic */ String j;
        public final /* synthetic */ int k;

        public b(String str, int i2, String str2, String str3, String str4, String str5, int i3) {
            this.f43142e = str;
            this.f43143f = i2;
            this.f43144g = str2;
            this.f43145h = str3;
            this.f43146i = str4;
            this.j = str5;
            this.k = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.l0.a.j2.p.c cVar;
            int a2 = d.a.l0.a.n1.l.a();
            if (k.f43133a) {
                Log.d("SwanAppUBCStatistic", "get NetworkQuality: " + a2);
            }
            if (TextUtils.equals(this.f43142e, "1")) {
                cVar = new d.a.l0.a.j2.p.c(this.f43143f, this.f43144g, this.f43145h, a2);
            } else {
                cVar = new d.a.l0.a.j2.p.c(this.f43144g, a2, 0L, 0L);
            }
            new n.a(cVar, "downloadFile");
            if (!TextUtils.isEmpty(this.f43146i)) {
                cVar.q(this.f43146i);
            }
            if (!TextUtils.isEmpty(this.j)) {
                cVar.p(this.j);
            }
            cVar.f43186b = "downloadFile";
            if (d.a.l0.a.a2.e.i() != null && d.a.l0.a.a2.e.i().N() != null) {
                cVar.f43187c = d.a.l0.a.a2.e.i().N().T();
            }
            cVar.f43190f = d.a.l0.a.a2.e.V();
            cVar.f43185a = k.m(this.k);
            JSONObject f2 = cVar.f();
            d.a.l0.a.j2.b.k("834", f2);
            d.a.l0.a.e0.d.h("SwanAppUBCStatistic", "834-downloadFile event=" + f2.toString());
        }
    }

    /* loaded from: classes3.dex */
    public static class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.j2.p.e f43147e;

        public c(d.a.l0.a.j2.p.e eVar) {
            this.f43147e = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.l0.a.j2.b.k("894", this.f43147e.f());
        }
    }

    /* loaded from: classes3.dex */
    public static class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.j2.p.b f43148e;

        public d(d.a.l0.a.j2.p.b bVar) {
            this.f43148e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.l0.a.j2.b.k("751", this.f43148e.f());
        }
    }

    /* loaded from: classes3.dex */
    public static class e implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f43149e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ForbiddenInfo f43150f;

        public e(String str, ForbiddenInfo forbiddenInfo) {
            this.f43149e = str;
            this.f43150f = forbiddenInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.l0.a.j2.p.d dVar = new d.a.l0.a.j2.p.d();
            dVar.f43189e = this.f43149e;
            dVar.f43186b = "show";
            dVar.f43185a = "swan";
            ForbiddenInfo forbiddenInfo = this.f43150f;
            dVar.f43187c = forbiddenInfo.launchSource;
            dVar.a("path", forbiddenInfo.launchPath);
            dVar.a("appkey", this.f43150f.appId);
            d.a.l0.a.j2.b.m("1400", dVar.f());
        }
    }

    /* loaded from: classes3.dex */
    public static class f implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f43151e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f43152f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f43153g;

        public f(String str, String str2, int i2) {
            this.f43151e = str;
            this.f43152f = str2;
            this.f43153g = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.l0.a.a2.e Q = d.a.l0.a.a2.e.Q();
            if (Q == null) {
                return;
            }
            b.a L = Q.L();
            String O = Q.O();
            String appId = Q.getAppId();
            d.a.l0.a.j2.p.d dVar = new d.a.l0.a.j2.p.d();
            dVar.f43186b = "login";
            dVar.f43185a = k.m(L.G());
            dVar.f43190f = appId;
            dVar.f43189e = this.f43151e;
            dVar.a("appName", O);
            dVar.a("invokeFrom", this.f43152f);
            dVar.a("scene", Integer.valueOf(this.f43153g));
            if (TextUtils.equals(this.f43151e, "show")) {
                d.a.l0.a.j2.b.i("1936", "80", dVar.f());
            } else if (TextUtils.equals(this.f43151e, "success")) {
                d.a.l0.a.j2.b.i("1936", "81", dVar.f());
            } else if (TextUtils.equals(this.f43151e, "fail")) {
                d.a.l0.a.j2.b.i("1936", "82", dVar.f());
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class g implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f43154e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f43155f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f43156g;

        public g(String str, String str2, String str3) {
            this.f43154e = str;
            this.f43155f = str2;
            this.f43156g = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.l0.a.a2.e r = d.a.l0.a.a2.d.g().r();
            b.a L = r.L();
            String O = r.O();
            String appId = r.getAppId();
            d.a.l0.a.j2.p.d dVar = new d.a.l0.a.j2.p.d();
            dVar.f43186b = "swanLogin";
            dVar.f43185a = k.m(L.G());
            dVar.f43190f = appId;
            dVar.f43189e = this.f43154e;
            dVar.a("appName", O);
            dVar.a("loginScene", this.f43155f);
            String str = this.f43156g;
            if (str != null) {
                dVar.a("errorInfo", str);
            }
            d.a.l0.a.j2.b.i("1936", "1936", dVar.f());
            if (k.f43133a) {
                Log.i("SwanAppUBCStatistic", "onSwanLoginProcessStatistic: scene = " + this.f43155f + " value = " + this.f43154e + " info = " + this.f43156g);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class h implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.j2.p.e f43157e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.j2.a f43158f;

        public h(d.a.l0.a.j2.p.e eVar, d.a.l0.a.j2.a aVar) {
            this.f43157e = eVar;
            this.f43158f = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.l0.a.j2.p.e eVar = this.f43157e;
            if (eVar != null) {
                d.a.l0.a.j2.b.f(this.f43158f, eVar.f().toString());
            }
            d.a.l0.a.j2.b.c(this.f43158f);
        }
    }

    /* loaded from: classes3.dex */
    public static class i implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.j2.p.d f43159e;

        public i(d.a.l0.a.j2.p.d dVar) {
            this.f43159e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (TextUtils.isEmpty(this.f43159e.g())) {
                this.f43159e.k(d.a.l0.a.a2.d.g().r().L().V());
            }
            d.a.l0.a.j2.b.k("671", this.f43159e.f());
            d.a.l0.a.e0.d.h("SwanAppUBCStatistic", "671 event=" + this.f43159e.f().toString());
        }
    }

    /* loaded from: classes3.dex */
    public static class j implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f43160e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.j2.p.e f43161f;

        public j(String str, d.a.l0.a.j2.p.e eVar) {
            this.f43160e = str;
            this.f43161f = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.l0.a.j2.b.k(this.f43160e, this.f43161f.f());
        }
    }

    /* renamed from: d.a.l0.a.j2.k$k  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class RunnableC0724k implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f43162e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f43163f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.j2.p.e f43164g;

        public RunnableC0724k(String str, String str2, d.a.l0.a.j2.p.e eVar) {
            this.f43162e = str;
            this.f43163f = str2;
            this.f43164g = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.l0.a.j2.b.i(this.f43162e, this.f43163f, this.f43164g.f());
        }
    }

    /* loaded from: classes3.dex */
    public static class l implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.j2.p.b f43165e;

        public l(d.a.l0.a.j2.p.b bVar) {
            this.f43165e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.l0.a.j2.b.k("751", this.f43165e.f());
        }
    }

    /* loaded from: classes3.dex */
    public static class m implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.j2.p.b f43166e;

        public m(d.a.l0.a.j2.p.b bVar) {
            this.f43166e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.l0.a.j2.b.k("751", this.f43166e.f());
        }
    }

    /* loaded from: classes3.dex */
    public static class n implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.j2.p.b f43167e;

        public n(d.a.l0.a.j2.p.b bVar) {
            this.f43167e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.l0.a.j2.b.k("751", this.f43167e.f());
        }
    }

    /* loaded from: classes3.dex */
    public static class o implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.j2.p.e f43168e;

        public o(d.a.l0.a.j2.p.e eVar) {
            this.f43168e = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f43168e.b(k.R());
            d.a.l0.a.j2.b.k("778", this.f43168e.f());
        }
    }

    static {
        CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        f43136d = copyOnWriteArrayList;
        copyOnWriteArrayList.add("https://hmma.baidu.com/mini.gif");
        f43136d.add("https://dxp.baidu.com/mini");
        f43136d.add(d.a.l0.a.d0.a.c() + "/smtapp/recordhandler/getrecordinfo");
        f43136d.add(d.a.l0.a.d0.a.d() + "/smtapp/recordhandler/getrecordinfo");
    }

    public static void A() {
        b.a L;
        Bundle P;
        if (d.a.l0.a.a2.d.g().C() && (P = (L = d.a.l0.a.a2.d.g().r().L()).P()) != null && P.getLong("launch_flag_for_statistic") > 0) {
            long l2 = L.l("launch_time", 0L);
            long currentTimeMillis = System.currentTimeMillis();
            d.a.l0.a.j2.p.f fVar = new d.a.l0.a.j2.p.f();
            fVar.f43185a = m(d.a.l0.a.a2.d.g().l());
            fVar.f43190f = L.H();
            if (d.a.l0.a.u1.a.a.E(L.g0())) {
                fVar.f43187c = "remote-debug";
            } else if (d.a.l0.a.u1.a.a.C()) {
                fVar.f43187c = "local-debug";
            } else {
                fVar.f43187c = L.T();
            }
            fVar.f43186b = "launch";
            fVar.f43189e = "success";
            fVar.r = String.valueOf(currentTimeMillis - l2);
            fVar.a("status", "0");
            d.a.l0.a.j2.e.n(fVar, L.W(), L.r0().getString(UBCCloudControlProcessor.UBC_KEY));
            P.putLong("launch_flag_for_statistic", 0L);
            HybridUbcFlow d2 = d.a.l0.a.r1.h.d("startup");
            if (d2 != null) {
                if (d2.t() || d2.r()) {
                    return;
                }
                d2.B("value", "na_success");
            }
        }
    }

    public static void B(boolean z, String str) {
        d.a.l0.a.j2.p.e eVar = new d.a.l0.a.j2.p.e();
        if (d.a.l0.a.a2.d.g().r().e()) {
            eVar.d(d.a.l0.a.a2.d.g().r().L().r0().getString(UBCCloudControlProcessor.UBC_KEY));
        }
        eVar.f43186b = "show";
        eVar.f43187c = str;
        eVar.f43189e = z ? "success" : "fail";
        eVar.f43190f = d.a.l0.a.a2.e.V();
        d.a.l0.a.r1.k.i.c.f().e(new o(eVar), "SwanAppUBCOnPagesRoute");
    }

    public static void C(String str, String str2, List<String> list) {
        int i2;
        String str3;
        if (d.a.l0.a.a2.d.g().r().e()) {
            b.a L = d.a.l0.a.a2.d.g().r().L();
            i2 = L.G();
            str3 = L.r0().getString(UBCCloudControlProcessor.UBC_KEY);
        } else {
            i2 = 0;
            str3 = "";
        }
        d.a.l0.a.j2.p.b bVar = new d.a.l0.a.j2.p.b();
        bVar.f43186b = "pay";
        bVar.f43187c = str;
        bVar.f43190f = d.a.l0.a.a2.e.V();
        bVar.f43185a = m(i2);
        try {
            JSONObject jSONObject = new JSONObject(str3);
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put("paymenturl", str2);
            }
            if (list != null) {
                jSONObject.put("whitelist", list);
            }
            jSONObject.put("appname", d.a.l0.a.a2.e.i().O());
            bVar.e(jSONObject);
        } catch (JSONException e2) {
            e2.printStackTrace();
            bVar.d(str3);
        }
        bVar.b(R());
        q.j(new m(bVar), "SwanAppUBCOnPay");
    }

    public static void D(boolean z, String str, String str2) {
        d.a.l0.a.j2.p.b bVar = new d.a.l0.a.j2.p.b();
        b.a L = d.a.l0.a.a2.d.g().r().L();
        if (d.a.l0.a.a2.d.g().r().e()) {
            bVar.d(L.r0().getString(UBCCloudControlProcessor.UBC_KEY));
        }
        bVar.f43186b = "pay";
        bVar.f43189e = z ? "success" : "fail";
        bVar.f43187c = str;
        bVar.f43190f = d.a.l0.a.a2.e.V();
        bVar.f43185a = m(L.G());
        bVar.a("money", str2);
        bVar.b(R());
        q.i(new l(bVar), "SwanAppUBCOnPay");
    }

    public static void E(String str, boolean z, boolean z2) {
        d.a.l0.a.j2.p.b bVar = new d.a.l0.a.j2.p.b();
        b.a L = d.a.l0.a.a2.d.g().r().L();
        if (d.a.l0.a.a2.d.g().r().e()) {
            bVar.d(L.r0().getString(UBCCloudControlProcessor.UBC_KEY));
        }
        bVar.f43186b = "paylogin";
        bVar.f43187c = str;
        bVar.f43190f = L.I();
        bVar.f43185a = m(L.G());
        bVar.f43189e = z ? "success" : "fail";
        bVar.a("nativeAppId", d.a.l0.a.c1.a.m().a());
        bVar.a("paylogin", z2 ? "1" : "0");
        d.a.l0.a.h0.g.f J = d.a.l0.a.g1.f.V().J();
        d.a.l0.a.l1.c K1 = J == null ? null : J.K1();
        if (K1 != null && !TextUtils.isEmpty(K1.g())) {
            bVar.a("page", K1.g());
        }
        bVar.b(R());
        q.i(new d(bVar), "SwanAppUBCOnPayLogin");
    }

    public static void F(String str, String str2, int i2) {
        if (d.a.l0.a.a2.d.g().r().e()) {
            b.a L = d.a.l0.a.a2.d.g().r().L();
            int G = L.G();
            d.a.l0.a.j2.p.b bVar = new d.a.l0.a.j2.p.b();
            bVar.f43186b = "payProcess";
            bVar.f43185a = m(G);
            bVar.f43187c = str;
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
                    bVar.a("payResultStatus", "fail");
                } else {
                    bVar.a("payResultStatus", QueryResponse.Options.CANCEL);
                }
            }
            bVar.b(R());
            q.j(new n(bVar), "SwanAppUBCOnPayProcess");
        }
    }

    public static void G(String str, String str2) {
        d.a.l0.a.j2.p.f fVar = new d.a.l0.a.j2.p.f();
        fVar.f43186b = "launch";
        fVar.f43189e = str;
        if (d.a.l0.a.a2.e.Q() != null) {
            b.a L = d.a.l0.a.a2.e.Q().L();
            fVar.f43185a = m(L.G());
            fVar.f43190f = L.H();
            fVar.f43187c = L.T();
        }
        fVar.t = str2;
        onEvent(fVar);
    }

    public static void H(int i2, String str, int i3, String str2, @Nullable String str3, @Nullable String str4, String str5, long j2, long j3, @Nullable NetworkStatRecord networkStatRecord) {
        f43134b.execute(new a(str, j3, j2, i2, i3, str5, str2, str3, str4, networkStatRecord));
    }

    public static void I(String str, String str2, @NonNull JSONObject jSONObject) {
        if (!TextUtils.equals(str, "1")) {
            if (f43133a) {
                Log.d("SwanAppUBCStatistic", "RequestForAvatar: onRequestForAvatar: miss. requestType=" + str);
            }
        } else if (TextUtils.isEmpty(str2)) {
            if (f43133a) {
                Log.d("SwanAppUBCStatistic", "RequestForAvatar: onRequestForAvatar: miss. url is empty");
            }
        } else {
            HttpUrl parse = HttpUrl.parse(str2);
            if (parse == null) {
                if (f43133a) {
                    Log.d("SwanAppUBCStatistic", "RequestForAvatar: onRequestForAvatar: miss. url is illegal, url=" + str2);
                    return;
                }
                return;
            }
            String host = parse.host();
            if (TextUtils.isEmpty(host)) {
                if (f43133a) {
                    Log.d("SwanAppUBCStatistic", "RequestForAvatar: onRequestForAvatar: miss. host is empty, url=" + str2);
                }
            } else if (f43135c.contains(host)) {
                if (f43133a) {
                    Log.d("SwanAppUBCStatistic", "RequestForAvatar: onRequestForAvatar: miss. host is ignored, host=" + host + " ,url=" + str2);
                }
            } else {
                if (f43133a) {
                    Log.d("SwanAppUBCStatistic", "RequestForAvatar: onRequestForAvatar: hit. url=" + str2);
                    Log.d("SwanAppUBCStatistic", "value=" + jSONObject);
                }
                d.a.l0.a.j2.b.i("1415", "66", jSONObject);
            }
        }
    }

    public static void J(int i2, String str, int i3, String str2, long j2, long j3) {
        K(i2, str, i3, str2, null, null, j2, j3);
    }

    public static void K(int i2, String str, int i3, String str2, @Nullable String str3, @Nullable String str4, long j2, long j3) {
        H(i2, str, i3, str2, str3, str4, "1", j2, j3, null);
    }

    public static void L(d.a.l0.a.j2.p.d dVar) {
        if (dVar == null) {
            return;
        }
        q.i(new i(dVar), "SwanAppUBCStability");
    }

    public static void M(String str, int i2, String str2) {
        f43134b.execute(new f(str, str2, i2));
    }

    public static void N(String str, String str2) {
        O(str, str2, null);
    }

    public static void O(String str, String str2, String str3) {
        f43134b.execute(new g(str2, str, str3));
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
            if (f43133a) {
                e2.printStackTrace();
            }
            return null;
        }
    }

    public static void Q() {
        d.a.l0.a.a2.d g2 = d.a.l0.a.a2.d.g();
        d.a.l0.a.a2.e r = g2.r();
        b.a L = r.L();
        if (g2.C() && r.i0()) {
            Bundle r0 = L.r0();
            if (r0.getLong("launch_flag_for_statistic") > 0) {
                String valueOf = String.valueOf(System.currentTimeMillis() - r.L().s1());
                d.a.l0.a.j2.p.f fVar = new d.a.l0.a.j2.p.f();
                fVar.f43185a = m(L.G());
                fVar.f43186b = "launch";
                fVar.f43189e = QueryResponse.Options.CANCEL;
                fVar.q = valueOf;
                fVar.j(L);
                fVar.d(r0.getString(UBCCloudControlProcessor.UBC_KEY));
                fVar.b(k(L.W()));
                onEvent(fVar);
                d.a.l0.a.j2.p.f fVar2 = new d.a.l0.a.j2.p.f();
                fVar2.f43185a = m(L.G());
                fVar2.f43186b = "launch";
                fVar2.f43189e = "realcancel";
                fVar2.q = valueOf;
                fVar2.j(L);
                fVar2.b(k(L.W()));
                fVar2.a("reason", QueryResponse.Options.CANCEL);
                if (L.G() == 1) {
                    fVar.a("errorList", d.a.l0.a.c1.b.j().a());
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
        d.a.l0.a.a2.e i2 = d.a.l0.a.a2.e.i();
        if (i2 == null || (N = i2.N()) == null || (M = N.M()) == null || !TextUtils.equals(M.optString("token"), "swanubc")) {
            return null;
        }
        return M;
    }

    public static d.a.l0.a.j2.a c(String str) {
        return d.a.l0.a.j2.b.a(str);
    }

    public static void d(d.a.l0.a.j2.p.f fVar) {
        if (fVar == null || d.a.l0.a.a2.e.i() == null || d.a.l0.a.a2.e.i().N() == null) {
            return;
        }
        b.a N = d.a.l0.a.a2.e.i().N();
        fVar.f43185a = m(N.G());
        fVar.f43190f = N.H();
        fVar.a("appkey", N.I());
        u("1032", fVar);
    }

    public static void e(String str) {
        d.a.l0.a.j2.p.e eVar = new d.a.l0.a.j2.p.e();
        eVar.f43185a = m(0);
        eVar.f43186b = str;
        u("956", eVar);
    }

    public static void f(String str, String str2, String str3) {
        d.a.l0.a.j2.p.e eVar = new d.a.l0.a.j2.p.e();
        if (d.a.l0.a.a2.e.i() != null && d.a.l0.a.a2.e.i().N() != null) {
            b.a N = d.a.l0.a.a2.e.i().N();
            eVar.f43185a = m(N.G());
            eVar.f43190f = N.H();
            eVar.f43186b = str;
            eVar.f43187c = str2;
            eVar.f43189e = str3;
            eVar.a("appkey", N.I());
        }
        u("923", eVar);
    }

    public static void g(d.a.l0.a.j2.p.e eVar) {
        if (d.a.l0.a.a2.e.i() != null && d.a.l0.a.a2.e.i().N() != null) {
            b.a N = d.a.l0.a.a2.e.i().N();
            eVar.f43185a = m(N.G());
            eVar.f43190f = N.H();
            eVar.f43187c = N.T();
        }
        u("936", eVar);
    }

    public static void h(d.a.l0.a.j2.p.e eVar) {
        if (d.a.l0.a.a2.e.i() != null && d.a.l0.a.a2.e.i().N() != null) {
            b.a N = d.a.l0.a.a2.e.i().N();
            eVar.f43185a = m(N.G());
            eVar.f43190f = N.H();
            eVar.f43187c = N.T();
        }
        u("914", eVar);
    }

    public static void i(d.a.l0.a.j2.a aVar, d.a.l0.a.j2.p.e eVar) {
        if (aVar == null) {
            return;
        }
        q.i(new h(eVar, aVar), "SwanAppUBCEndFlow");
    }

    @WorkerThread
    public static void j(int i2, String str, int i3, String str2, @Nullable String str3, @Nullable String str4, String str5, long j2, long j3, @Nullable NetworkStatRecord networkStatRecord) {
        d.a.l0.a.j2.p.c cVar;
        int a2 = d.a.l0.a.n1.l.a();
        if (f43133a) {
            Log.d("SwanAppUBCStatistic", "get NetworkQuality: " + a2);
        }
        if (TextUtils.equals(str5, "1")) {
            cVar = new d.a.l0.a.j2.p.c(i2, str, str2, a2, j2, j3);
        } else {
            cVar = new d.a.l0.a.j2.p.c(str, a2, j2, j3);
        }
        n.a aVar = new n.a(cVar, "request");
        if (!TextUtils.isEmpty(str3)) {
            cVar.q(str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            cVar.p(str4);
        }
        cVar.f43186b = "request";
        d.a.l0.a.a2.e r = d.a.l0.a.a2.d.g().r();
        if (r != null && r.e()) {
            cVar.f43187c = r.L().T();
            cVar.f43188d = r.L().V();
        }
        cVar.f43190f = d.a.l0.a.a2.e.V();
        cVar.f43185a = m(i3);
        JSONObject P = P(networkStatRecord);
        aVar.f43178b = P;
        if (P != null) {
            cVar.e(P);
        }
        if (f43133a) {
            Log.d("SwanAppUBCStatistic", "Reporting: " + cVar.f());
        }
        JSONObject f2 = cVar.f();
        d.a.l0.a.j2.b.k("834", f2);
        I(cVar.m(), cVar.n(), f2);
        d.a.l0.a.e0.d.h("SwanAppUBCStatistic", "834-request event=" + f2.toString());
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
                if (f43133a) {
                    e2.printStackTrace();
                }
            }
        }
        return null;
    }

    public static String l() {
        return d.a.l0.a.m1.f.g() ? "1" : "0";
    }

    public static String m(int i2) {
        return i2 != 1 ? "swan" : SwanFavorItemData.SCHEME_AUTHORITY_SWAN_GAME;
    }

    public static boolean n(String str) {
        if (f43133a) {
            Log.d("SwanAppUBCStatistic", "isIgnoreRequest: start with " + str);
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        int size = f43136d.size();
        for (int i2 = 0; i2 < size; i2++) {
            String str2 = f43136d.get(i2);
            if (!TextUtils.isEmpty(str2) && str.startsWith(str2)) {
                if (f43133a) {
                    Log.d("SwanAppUBCStatistic", "isIgnoreRequest: ignore " + str);
                    return true;
                }
                return true;
            }
        }
        return false;
    }

    public static void o(String str, String str2, boolean z) {
        d.a.l0.a.j2.p.e eVar = new d.a.l0.a.j2.p.e();
        eVar.f43186b = str;
        eVar.f43189e = str2;
        eVar.f43190f = d.a.l0.a.a2.e.V();
        if (d.a.l0.a.a2.e.i() != null && d.a.l0.a.a2.e.i().N() != null) {
            b.a N = d.a.l0.a.a2.e.i().N();
            eVar.f43187c = N.T();
            eVar.f43185a = m(N.G());
        }
        if (TextUtils.equals(PrefetchEvent.STATE_CLICK, str)) {
            eVar.a("authorize", z ? "success" : "fail");
        }
        q.j(new c(eVar), "SwanAppUBCOnAuthDialog");
    }

    public static void onEvent(d.a.l0.a.j2.p.f fVar) {
        ExtensionCore M = d.a.l0.a.h0.u.g.N().M();
        if (M != null) {
            fVar.a("extension_ver", M.extensionCoreVersionName);
        }
        fVar.a("isReloadApp", d.a.l0.a.a2.d.g().r().L().d("launch_by_reload") ? "1" : "0");
        u("606", fVar);
    }

    public static void p(int i2, d.a.l0.a.e2.c.f fVar) {
        d.a.l0.a.a2.e Q = d.a.l0.a.a2.e.Q();
        if (Q == null) {
            if (f43133a) {
                Log.e("SwanAppUBCStatistic", "onAuthorizeFailed-swanApp is null");
                return;
            }
            return;
        }
        d.a.l0.a.j2.p.d dVar = new d.a.l0.a.j2.p.d();
        dVar.o(i2);
        dVar.r(Q.N());
        dVar.q(m(Q.l()));
        dVar.m(Q.getAppId());
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appid", Q.getAppId());
            jSONObject.put("msg", d.a.l0.a.e2.c.d.f(i2));
            jSONObject.put(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID, Q.T().q("cur_request_id", ""));
            if (fVar != null) {
                jSONObject.put("scope", fVar.f41695b);
                jSONObject.put("scopeData", fVar.f41694a);
            }
        } catch (JSONException e2) {
            if (f43133a) {
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
        f43134b.execute(new b(str5, i2, str, str2, str3, str4, i3));
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
        f43134b.execute(new e(str, forbiddenInfo));
    }

    public static void u(String str, d.a.l0.a.j2.p.e eVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        d.a.l0.a.r1.k.i.c.f().e(new j(str, eVar), "SwanAppUBCOnEvent");
    }

    public static void v(String str, String str2, d.a.l0.a.j2.p.e eVar) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        q.i(new RunnableC0724k(str, str2, eVar), "SwanAppUbcCeresOnEvent");
    }

    public static void w(String str, int i2, String str2) {
        d.a.l0.a.a2.e Q = d.a.l0.a.a2.e.Q();
        if (Q == null) {
            return;
        }
        d.a.l0.a.q2.a aVar = new d.a.l0.a.q2.a();
        aVar.j(5L);
        aVar.h(50L);
        d.a.l0.a.j2.p.d dVar = new d.a.l0.a.j2.p.d();
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
            if (f43133a) {
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
