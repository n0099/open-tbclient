package d.b.g0.a.z1;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.http.statistics.NetworkStatRecord;
import com.baidu.searchbox.ubcprocessor.UBCCloudControlProcessor;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.favordata.SwanFavorItemData;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.statistic.search.SearchFlowEvent;
import com.baidu.wallet.paysdk.banksign.datamodel.QueryResponse;
import com.facebook.common.internal.Sets;
import d.b.g0.a.i2.p;
import d.b.g0.a.y0.e.b;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import okhttp3.HttpUrl;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class h {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f47215a = d.b.g0.a.k.f45050a;

    /* renamed from: b  reason: collision with root package name */
    public static final Set<String> f47216b = Sets.newHashSet("hmma.baidu.com");

    /* renamed from: c  reason: collision with root package name */
    public static final CopyOnWriteArrayList<String> f47217c;

    /* loaded from: classes3.dex */
    public static class a extends d.b.g0.a.n1.a.b.c.b {

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f47218c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f47219d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f47220e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f47221f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f47222g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f47223h;
        public final /* synthetic */ int i;

        /* renamed from: d.b.g0.a.z1.h$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0894a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.b.g0.a.z1.k.c f47224e;

            public RunnableC0894a(a aVar, d.b.g0.a.z1.k.c cVar) {
                this.f47224e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                JSONObject f2 = this.f47224e.f();
                d.b.g0.a.z1.b.j("834", f2);
                d.b.g0.a.c0.c.h("SwanAppUBCStatistic", "834-downloadFile event=" + f2.toString());
            }
        }

        public a(String str, int i, String str2, String str3, String str4, String str5, int i2) {
            this.f47218c = str;
            this.f47219d = i;
            this.f47220e = str2;
            this.f47221f = str3;
            this.f47222g = str4;
            this.f47223h = str5;
            this.i = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.n1.a.b.c.b, d.b.g0.a.n1.a.b.c.c, d.b.g0.a.n1.a.b.c.a
        public void onEvent(@NonNull d.b.g0.a.n1.a.b.a.b bVar) {
            d.b.g0.a.z1.k.c cVar;
            int i = bVar.a() != null ? bVar.a().getInt("net_quality") : -1;
            if (h.f47215a) {
                Log.d("SwanAppUBCStatistic", "get NetworkQuality: " + i);
            }
            if (TextUtils.equals(this.f47218c, "1")) {
                cVar = new d.b.g0.a.z1.k.c(this.f47219d, this.f47220e, this.f47221f, i);
            } else {
                cVar = new d.b.g0.a.z1.k.c(this.f47220e, i);
            }
            if (!TextUtils.isEmpty(this.f47222g)) {
                cVar.o(this.f47222g);
            }
            if (!TextUtils.isEmpty(this.f47223h)) {
                cVar.n(this.f47223h);
            }
            cVar.f47251b = "downloadFile";
            if (d.b.g0.a.r1.e.y() != null && d.b.g0.a.r1.e.y().L() != null) {
                cVar.f47252c = d.b.g0.a.r1.e.y().L().S();
            }
            cVar.f47254e = d.b.g0.a.r1.e.T();
            cVar.f47250a = h.n(this.i);
            p.j(new RunnableC0894a(this, cVar), "SwanAppDownloadFile");
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.z1.k.e f47225e;

        public b(d.b.g0.a.z1.k.e eVar) {
            this.f47225e = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.b.g0.a.z1.b.j("894", this.f47225e.f());
        }
    }

    /* loaded from: classes3.dex */
    public static class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.z1.k.b f47226e;

        public c(d.b.g0.a.z1.k.b bVar) {
            this.f47226e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.b.g0.a.z1.b.j("751", this.f47226e.f());
        }
    }

    /* loaded from: classes3.dex */
    public static class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.z1.k.e f47227e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.z1.a f47228f;

        public d(d.b.g0.a.z1.k.e eVar, d.b.g0.a.z1.a aVar) {
            this.f47227e = eVar;
            this.f47228f = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.b.g0.a.z1.k.e eVar = this.f47227e;
            if (eVar != null) {
                d.b.g0.a.z1.b.f(this.f47228f, eVar.f().toString());
            }
            d.b.g0.a.z1.b.c(this.f47228f);
        }
    }

    /* loaded from: classes3.dex */
    public static class e implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.z1.k.d f47229e;

        public e(d.b.g0.a.z1.k.d dVar) {
            this.f47229e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (TextUtils.isEmpty(this.f47229e.g())) {
                this.f47229e.k(d.b.g0.a.r1.d.e().s().J().U());
            }
            d.b.g0.a.z1.b.j("671", this.f47229e.f());
            d.b.g0.a.c0.c.h("SwanAppUBCStatistic", "671 event=" + this.f47229e.f().toString());
        }
    }

    /* loaded from: classes3.dex */
    public static class f implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f47230e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.z1.k.e f47231f;

        public f(String str, d.b.g0.a.z1.k.e eVar) {
            this.f47230e = str;
            this.f47231f = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.b.g0.a.z1.b.j(this.f47230e, this.f47231f.f());
        }
    }

    /* loaded from: classes3.dex */
    public static class g implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f47232e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f47233f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.z1.k.e f47234g;

        public g(String str, String str2, d.b.g0.a.z1.k.e eVar) {
            this.f47232e = str;
            this.f47233f = str2;
            this.f47234g = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.b.g0.a.z1.b.h(this.f47232e, this.f47233f, this.f47234g.f());
        }
    }

    /* renamed from: d.b.g0.a.z1.h$h  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class RunnableC0895h implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.z1.k.b f47235e;

        public RunnableC0895h(d.b.g0.a.z1.k.b bVar) {
            this.f47235e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.b.g0.a.z1.b.j("751", this.f47235e.f());
        }
    }

    /* loaded from: classes3.dex */
    public static class i implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.z1.k.b f47236e;

        public i(d.b.g0.a.z1.k.b bVar) {
            this.f47236e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.b.g0.a.z1.b.j("751", this.f47236e.f());
        }
    }

    /* loaded from: classes3.dex */
    public static class j implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.z1.k.e f47237e;

        public j(d.b.g0.a.z1.k.e eVar) {
            this.f47237e = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f47237e.b(h.K());
            d.b.g0.a.z1.b.j("778", this.f47237e.f());
        }
    }

    /* loaded from: classes3.dex */
    public static class k extends d.b.g0.a.n1.a.b.c.b {

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f47238c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f47239d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f47240e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f47241f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ long f47242g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ long f47243h;
        public final /* synthetic */ String i;
        public final /* synthetic */ String j;
        public final /* synthetic */ int k;
        public final /* synthetic */ NetworkStatRecord l;

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.b.g0.a.z1.k.c f47244e;

            public a(k kVar, d.b.g0.a.z1.k.c cVar) {
                this.f47244e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (h.f47215a) {
                    Log.d("SwanAppUBCStatistic", "Reporting: " + this.f47244e.f());
                }
                JSONObject f2 = this.f47244e.f();
                d.b.g0.a.z1.b.j("834", f2);
                h.E(this.f47244e.l(), this.f47244e.m(), f2);
                d.b.g0.a.c0.c.h("SwanAppUBCStatistic", "834-request event=" + f2.toString());
            }
        }

        public k(String str, int i, String str2, String str3, long j, long j2, String str4, String str5, int i2, NetworkStatRecord networkStatRecord) {
            this.f47238c = str;
            this.f47239d = i;
            this.f47240e = str2;
            this.f47241f = str3;
            this.f47242g = j;
            this.f47243h = j2;
            this.i = str4;
            this.j = str5;
            this.k = i2;
            this.l = networkStatRecord;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.n1.a.b.c.b, d.b.g0.a.n1.a.b.c.c, d.b.g0.a.n1.a.b.c.a
        public void onEvent(@NonNull d.b.g0.a.n1.a.b.a.b bVar) {
            d.b.g0.a.z1.k.c cVar;
            int i = bVar.a() != null ? bVar.a().getInt("net_quality") : -1;
            if (h.f47215a) {
                Log.d("SwanAppUBCStatistic", "get NetworkQuality: " + i);
            }
            if (TextUtils.equals(this.f47238c, "1")) {
                cVar = new d.b.g0.a.z1.k.c(this.f47239d, this.f47240e, this.f47241f, i, this.f47242g, this.f47243h);
            } else {
                cVar = new d.b.g0.a.z1.k.c(this.f47240e, i);
            }
            if (!TextUtils.isEmpty(this.i)) {
                cVar.o(this.i);
            }
            if (!TextUtils.isEmpty(this.j)) {
                cVar.n(this.j);
            }
            cVar.f47251b = "request";
            if (d.b.g0.a.r1.d.e().s().d()) {
                cVar.f47252c = d.b.g0.a.r1.d.e().s().J().S();
            }
            cVar.f47254e = d.b.g0.a.r1.e.T();
            cVar.f47250a = h.n(this.k);
            JSONObject I = h.I(this.l);
            if (I != null) {
                cVar.e(I);
            }
            p.j(new a(this, cVar), "SwanAppUBCRequest");
        }
    }

    static {
        CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        f47217c = copyOnWriteArrayList;
        copyOnWriteArrayList.add("https://hmma.baidu.com/mini.gif");
        f47217c.add("https://dxp.baidu.com/mini");
        f47217c.add("https://mbd.baidu.com/smtapp/recordhandler/getrecordinfo");
    }

    public static void A(String str, String str2, ArrayList<String> arrayList) {
        int i2;
        String str3;
        if (d.b.g0.a.r1.d.e().s().d()) {
            b.a J = d.b.g0.a.r1.d.e().s().J();
            i2 = J.F();
            str3 = J.n0().getString(UBCCloudControlProcessor.UBC_KEY);
        } else {
            i2 = 0;
            str3 = "";
        }
        d.b.g0.a.z1.k.b bVar = new d.b.g0.a.z1.k.b();
        bVar.f47251b = "pay";
        bVar.f47252c = str;
        bVar.f47254e = d.b.g0.a.r1.e.T();
        bVar.f47250a = n(i2);
        try {
            JSONObject jSONObject = new JSONObject(str3);
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put("paymenturl", str2);
            }
            if (arrayList != null) {
                jSONObject.put("whitelist", arrayList);
            }
            jSONObject.put("appname", d.b.g0.a.r1.e.y().M());
            bVar.e(jSONObject);
        } catch (JSONException e2) {
            e2.printStackTrace();
            bVar.d(str3);
        }
        bVar.b(K());
        p.k(new i(bVar), "SwanAppUBCOnPay");
    }

    public static void B(boolean z, String str, String str2, int i2) {
        d.b.g0.a.z1.k.b bVar = new d.b.g0.a.z1.k.b();
        b.a J = d.b.g0.a.r1.d.e().s().J();
        if (d.b.g0.a.r1.d.e().s().d()) {
            bVar.d(J.n0().getString(UBCCloudControlProcessor.UBC_KEY));
        }
        bVar.f47251b = "pay";
        bVar.f47253d = z ? "success" : "fail";
        bVar.f47252c = str;
        bVar.f47254e = d.b.g0.a.r1.e.T();
        bVar.f47250a = n(i2);
        bVar.a("money", str2);
        bVar.b(K());
        p.j(new RunnableC0895h(bVar), "SwanAppUBCOnPay");
    }

    public static void C(String str, boolean z, boolean z2) {
        d.b.g0.a.z1.k.b bVar = new d.b.g0.a.z1.k.b();
        b.a J = d.b.g0.a.r1.d.e().s().J();
        if (d.b.g0.a.r1.d.e().s().d()) {
            bVar.d(J.n0().getString(UBCCloudControlProcessor.UBC_KEY));
        }
        bVar.f47251b = "paylogin";
        bVar.f47252c = str;
        bVar.f47254e = J.H();
        bVar.f47250a = n(J.F());
        bVar.f47253d = z ? "success" : "fail";
        bVar.a("nativeAppId", d.b.g0.a.w0.a.k().g());
        bVar.a("paylogin", z2 ? "1" : "0");
        d.b.g0.a.e0.l.e A = d.b.g0.a.z0.f.V().A();
        d.b.g0.a.e1.c G1 = A == null ? null : A.G1();
        if (G1 != null && !TextUtils.isEmpty(G1.g())) {
            bVar.a("page", G1.g());
        }
        bVar.b(K());
        p.j(new c(bVar), "SwanAppUBCOnPayLogin");
    }

    public static void D(int i2, String str, int i3, String str2, @Nullable String str3, @Nullable String str4, String str5, long j2, long j3, @Nullable NetworkStatRecord networkStatRecord) {
        if (SwanAppNetworkUtils.h(null)) {
            if (o(str)) {
                if (f47215a) {
                    Log.d("SwanAppUBCStatistic", "onRequest: ignore " + str);
                    return;
                }
                return;
            }
            long j4 = j3 - j2;
            boolean z = i2 == 200;
            if (i3 == 0) {
                if (TextUtils.equals(str5, "1")) {
                    if (z) {
                        d.b.g0.a.e0.f.i(str, j4);
                    } else {
                        d.b.g0.a.e0.f.g(str, i2);
                    }
                } else if (TextUtils.equals(str5, "0")) {
                    d.b.g0.a.e0.f.h(str);
                }
            }
            if (z && j4 < 5000) {
                if (f47215a) {
                    Log.d("SwanAppUBCStatistic", "code 200 & cost(" + j4 + ") is ok, don't report");
                    return;
                }
                return;
            }
            d.b.g0.a.n1.c.e.a.C().J(null, d.b.g0.g.w.d.class, new k(str5, i2, str, str2, j2, j3, str3, str4, i3, networkStatRecord));
        }
    }

    public static void E(String str, String str2, @NonNull JSONObject jSONObject) {
        if (!TextUtils.equals(str, "1")) {
            if (f47215a) {
                Log.d("SwanAppUBCStatistic", "RequestForAvatar: onRequestForAvatar: miss. requestType=" + str);
            }
        } else if (TextUtils.isEmpty(str2)) {
            if (f47215a) {
                Log.d("SwanAppUBCStatistic", "RequestForAvatar: onRequestForAvatar: miss. url is empty");
            }
        } else {
            HttpUrl parse = HttpUrl.parse(str2);
            if (parse == null) {
                if (f47215a) {
                    Log.d("SwanAppUBCStatistic", "RequestForAvatar: onRequestForAvatar: miss. url is illegal, url=" + str2);
                    return;
                }
                return;
            }
            String host = parse.host();
            if (TextUtils.isEmpty(host)) {
                if (f47215a) {
                    Log.d("SwanAppUBCStatistic", "RequestForAvatar: onRequestForAvatar: miss. host is empty, url=" + str2);
                }
            } else if (f47216b.contains(host)) {
                if (f47215a) {
                    Log.d("SwanAppUBCStatistic", "RequestForAvatar: onRequestForAvatar: miss. host is ignored, host=" + host + " ,url=" + str2);
                }
            } else {
                if (f47215a) {
                    Log.d("SwanAppUBCStatistic", "RequestForAvatar: onRequestForAvatar: hit. url=" + str2);
                    Log.d("SwanAppUBCStatistic", "value=" + jSONObject);
                }
                d.b.g0.a.z1.b.h("1415", "66", jSONObject);
            }
        }
    }

    public static void F(int i2, String str, int i3, String str2, long j2, long j3) {
        G(i2, str, i3, str2, null, null, j2, j3);
    }

    public static void G(int i2, String str, int i3, String str2, @Nullable String str3, @Nullable String str4, long j2, long j3) {
        D(i2, str, i3, str2, str3, str4, "1", j2, j3, null);
    }

    public static void H(d.b.g0.a.z1.k.d dVar) {
        if (dVar == null) {
            return;
        }
        p.j(new e(dVar), "SwanAppUBCStability");
    }

    public static JSONObject I(@Nullable NetworkStatRecord networkStatRecord) {
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
            if (f47215a) {
                e2.printStackTrace();
            }
            return null;
        }
    }

    public static void J() {
        d.b.g0.a.r1.d e2 = d.b.g0.a.r1.d.e();
        d.b.g0.a.r1.e s = e2.s();
        b.a J = s.J();
        if (e2.x() && s.e0()) {
            Bundle n0 = J.n0();
            if (n0.getLong("launch_flag_for_statistic") > 0) {
                String valueOf = String.valueOf(System.currentTimeMillis() - s.J().l1());
                d.b.g0.a.z1.k.f fVar = new d.b.g0.a.z1.k.f();
                fVar.f47250a = n(J.F());
                fVar.f47251b = Config.LAUNCH;
                fVar.f47253d = QueryResponse.Options.CANCEL;
                fVar.r = valueOf;
                fVar.j(J);
                fVar.d(n0.getString(UBCCloudControlProcessor.UBC_KEY));
                fVar.b(l(J.V()));
                onEvent(fVar);
                d.b.g0.a.z1.k.f fVar2 = new d.b.g0.a.z1.k.f();
                fVar2.f47250a = n(J.F());
                fVar2.f47251b = Config.LAUNCH;
                fVar2.f47253d = "realcancel";
                fVar2.r = valueOf;
                fVar2.j(J);
                fVar2.b(l(J.V()));
                fVar2.a("reason", QueryResponse.Options.CANCEL);
                if (J.F() == 1) {
                    fVar.a("errorList", d.b.g0.g.c0.b.c().d());
                }
                fVar2.d(n0.getString(UBCCloudControlProcessor.UBC_KEY));
                onEvent(fVar2);
                n0.remove("launch_flag_for_statistic");
            }
            d.b.g0.a.z1.l.b.a(new SearchFlowEvent("nreach", System.currentTimeMillis(), "custom_return", "", SearchFlowEvent.EventType.END));
        }
    }

    public static JSONObject K() {
        b.a L;
        JSONObject L2;
        d.b.g0.a.r1.e y = d.b.g0.a.r1.e.y();
        if (y == null || (L = y.L()) == null || (L2 = L.L()) == null || !TextUtils.equals(L2.optString("token"), "swanubc")) {
            return null;
        }
        return L2;
    }

    public static d.b.g0.a.z1.a e(String str) {
        return d.b.g0.a.z1.b.a(str);
    }

    public static void f(d.b.g0.a.z1.k.f fVar) {
        if (fVar == null || d.b.g0.a.r1.e.y() == null || d.b.g0.a.r1.e.y().L() == null) {
            return;
        }
        b.a L = d.b.g0.a.r1.e.y().L();
        fVar.f47250a = n(L.F());
        fVar.f47254e = L.G();
        fVar.a("appkey", L.H());
        u("1032", fVar);
    }

    public static void g(String str) {
        d.b.g0.a.z1.k.e eVar = new d.b.g0.a.z1.k.e();
        eVar.f47250a = n(0);
        eVar.f47251b = str;
        u("956", eVar);
    }

    public static void h(String str, String str2, String str3) {
        d.b.g0.a.z1.k.e eVar = new d.b.g0.a.z1.k.e();
        if (d.b.g0.a.r1.e.y() != null && d.b.g0.a.r1.e.y().L() != null) {
            b.a L = d.b.g0.a.r1.e.y().L();
            eVar.f47250a = n(L.F());
            eVar.f47254e = L.G();
            eVar.f47251b = str;
            eVar.f47252c = str2;
            eVar.f47253d = str3;
            eVar.a("appkey", L.H());
        }
        u("923", eVar);
    }

    public static void i(d.b.g0.a.z1.k.e eVar) {
        if (d.b.g0.a.r1.e.y() != null && d.b.g0.a.r1.e.y().L() != null) {
            b.a L = d.b.g0.a.r1.e.y().L();
            eVar.f47250a = n(L.F());
            eVar.f47254e = L.G();
            eVar.f47252c = L.S();
        }
        u("936", eVar);
    }

    public static void j(d.b.g0.a.z1.k.e eVar) {
        if (d.b.g0.a.r1.e.y() != null && d.b.g0.a.r1.e.y().L() != null) {
            b.a L = d.b.g0.a.r1.e.y().L();
            eVar.f47250a = n(L.F());
            eVar.f47254e = L.G();
            eVar.f47252c = L.S();
        }
        u("914", eVar);
    }

    public static void k(d.b.g0.a.z1.a aVar, d.b.g0.a.z1.k.e eVar) {
        if (aVar == null) {
            return;
        }
        p.j(new d(eVar, aVar), "SwanAppUBCEndFlow");
    }

    public static JSONObject l(String str) {
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
                if (f47215a) {
                    e2.printStackTrace();
                }
            }
        }
        return null;
    }

    public static String m() {
        return d.b.g0.a.f1.e.g() ? "1" : "0";
    }

    public static String n(int i2) {
        return i2 != 1 ? "swan" : SwanFavorItemData.SCHEME_AUTHORITY_SWAN_GAME;
    }

    public static boolean o(String str) {
        if (f47215a) {
            Log.d("SwanAppUBCStatistic", "isIgnoreRequest: start with " + str);
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        int size = f47217c.size();
        for (int i2 = 0; i2 < size; i2++) {
            String str2 = f47217c.get(i2);
            if (!TextUtils.isEmpty(str2) && str.startsWith(str2)) {
                if (f47215a) {
                    Log.d("SwanAppUBCStatistic", "isIgnoreRequest: ignore " + str);
                    return true;
                }
                return true;
            }
        }
        return false;
    }

    public static void onEvent(d.b.g0.a.z1.k.f fVar) {
        ExtensionCore K = d.b.g0.a.e0.w.d.L().K();
        if (K != null) {
            fVar.a("extension_ver", K.extensionCoreVersionName);
        }
        u("606", fVar);
    }

    public static void p(String str, String str2, boolean z) {
        d.b.g0.a.z1.k.e eVar = new d.b.g0.a.z1.k.e();
        eVar.f47251b = str;
        eVar.f47253d = str2;
        eVar.f47254e = d.b.g0.a.r1.e.T();
        if (d.b.g0.a.r1.e.y() != null && d.b.g0.a.r1.e.y().L() != null) {
            b.a L = d.b.g0.a.r1.e.y().L();
            eVar.f47252c = L.S();
            eVar.f47250a = n(L.F());
        }
        if (TextUtils.equals(PrefetchEvent.STATE_CLICK, str)) {
            eVar.a("authorize", z ? "success" : "fail");
        }
        p.k(new b(eVar), "SwanAppUBCOnAuthDialog");
    }

    public static void q(int i2, d.b.g0.a.v1.c.e eVar) {
        d.b.g0.a.r1.e O = d.b.g0.a.r1.e.O();
        if (O == null) {
            if (f47215a) {
                Log.e("SwanAppUBCStatistic", "onAuthorizeFailed-swanApp is null");
                return;
            }
            return;
        }
        d.b.g0.a.z1.k.d dVar = new d.b.g0.a.z1.k.d();
        dVar.o(i2);
        dVar.r(O.L());
        dVar.q(n(O.h()));
        dVar.m(O.getAppId());
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appid", O.getAppId());
            jSONObject.put("msg", d.b.g0.a.v1.c.c.f(i2));
            jSONObject.put(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID, O.R().p("cur_request_id", ""));
            if (eVar != null) {
                jSONObject.put("scope", eVar.f46768b);
                jSONObject.put("scopeData", eVar.f46767a);
            }
        } catch (JSONException e2) {
            if (f47215a) {
                e2.printStackTrace();
            }
        }
        dVar.e(jSONObject);
        H(dVar);
    }

    public static void r(int i2, String str, int i3, String str2, @Nullable String str3, @Nullable String str4, String str5) {
        if (i2 == 200) {
            return;
        }
        d.b.g0.a.n1.c.e.a.C().J(null, d.b.g0.g.w.d.class, new a(str5, i2, str, str2, str3, str4, i3));
    }

    public static void s(int i2, String str, int i3, String str2) {
        r(i2, str, i3, str2, null, null, "1");
    }

    public static void t(int i2, String str, int i3, String str2, @Nullable String str3, @Nullable String str4) {
        r(i2, str, i3, str2, str3, str4, "1");
    }

    public static void u(String str, d.b.g0.a.z1.k.e eVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        p.j(new f(str, eVar), "SwanAppUBCOnEvent");
    }

    public static void v(String str, String str2, d.b.g0.a.z1.k.e eVar) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        p.j(new g(str, str2, eVar), "SwanAppUbcCeresOnEvent");
    }

    public static void w(String str, int i2) {
        r(0, str, i2, null, null, null, "0");
    }

    public static void x(String str, int i2, NetworkStatRecord networkStatRecord) {
        D(0, str, i2, null, null, null, "0", 0L, 0L, networkStatRecord);
    }

    public static void y() {
        b.a J;
        Bundle O;
        if (d.b.g0.a.r1.d.e().x() && (O = (J = d.b.g0.a.r1.d.e().s().J()).O()) != null && O.getLong("launch_flag_for_statistic") > 0) {
            long k2 = J.k("launch_time", 0L);
            long currentTimeMillis = System.currentTimeMillis();
            d.b.g0.a.z1.k.f fVar = new d.b.g0.a.z1.k.f();
            fVar.f47250a = n(d.b.g0.a.r1.d.e().h());
            fVar.f47254e = J.G();
            if (d.b.g0.a.m1.a.a.B(J.d0())) {
                fVar.f47252c = "remote-debug";
            } else {
                fVar.f47252c = J.S();
            }
            fVar.f47251b = Config.LAUNCH;
            fVar.f47253d = "success";
            fVar.s = String.valueOf(currentTimeMillis - k2);
            fVar.a("status", "0");
            d.b.g0.a.z1.e.k(fVar, J.V(), J.n0().getString(UBCCloudControlProcessor.UBC_KEY));
            O.putLong("launch_flag_for_statistic", 0L);
            HybridUbcFlow d2 = d.b.g0.a.j1.i.d("startup");
            if (d2 != null) {
                if (d2.s() || d2.q()) {
                    return;
                }
                d2.z("value", "na_success");
            }
        }
    }

    public static void z(boolean z, String str) {
        d.b.g0.a.z1.k.e eVar = new d.b.g0.a.z1.k.e();
        if (d.b.g0.a.r1.d.e().s().d()) {
            eVar.d(d.b.g0.a.r1.d.e().s().J().n0().getString(UBCCloudControlProcessor.UBC_KEY));
        }
        eVar.f47251b = "show";
        eVar.f47252c = str;
        eVar.f47253d = z ? "success" : "fail";
        eVar.f47254e = d.b.g0.a.r1.e.T();
        p.k(new j(eVar), "SwanAppUBCOnPagesRoute");
    }
}
