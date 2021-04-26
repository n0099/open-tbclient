package d.a.h0.a.z1;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
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
import d.a.h0.a.i2.p;
import d.a.h0.a.y0.e.b;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import okhttp3.HttpUrl;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class h {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f45373a = d.a.h0.a.k.f43101a;

    /* renamed from: b  reason: collision with root package name */
    public static final Set<String> f45374b = Sets.newHashSet("hmma.baidu.com");

    /* renamed from: c  reason: collision with root package name */
    public static final CopyOnWriteArrayList<String> f45375c;

    /* loaded from: classes3.dex */
    public static class a extends d.a.h0.a.n1.a.b.c.b {

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f45376c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f45377d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f45378e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f45379f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f45380g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f45381h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ int f45382i;

        /* renamed from: d.a.h0.a.z1.h$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0866a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.h0.a.z1.k.c f45383e;

            public RunnableC0866a(a aVar, d.a.h0.a.z1.k.c cVar) {
                this.f45383e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                JSONObject f2 = this.f45383e.f();
                d.a.h0.a.z1.b.j("834", f2);
                d.a.h0.a.c0.c.h("SwanAppUBCStatistic", "834-downloadFile event=" + f2.toString());
            }
        }

        public a(String str, int i2, String str2, String str3, String str4, String str5, int i3) {
            this.f45376c = str;
            this.f45377d = i2;
            this.f45378e = str2;
            this.f45379f = str3;
            this.f45380g = str4;
            this.f45381h = str5;
            this.f45382i = i3;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.a.n1.a.b.c.b, d.a.h0.a.n1.a.b.c.c, d.a.h0.a.n1.a.b.c.a
        public void onEvent(@NonNull d.a.h0.a.n1.a.b.a.b bVar) {
            d.a.h0.a.z1.k.c cVar;
            int i2 = bVar.a() != null ? bVar.a().getInt("net_quality") : -1;
            if (h.f45373a) {
                Log.d("SwanAppUBCStatistic", "get NetworkQuality: " + i2);
            }
            if (TextUtils.equals(this.f45376c, "1")) {
                cVar = new d.a.h0.a.z1.k.c(this.f45377d, this.f45378e, this.f45379f, i2);
            } else {
                cVar = new d.a.h0.a.z1.k.c(this.f45378e, i2);
            }
            if (!TextUtils.isEmpty(this.f45380g)) {
                cVar.o(this.f45380g);
            }
            if (!TextUtils.isEmpty(this.f45381h)) {
                cVar.n(this.f45381h);
            }
            cVar.f45412b = "downloadFile";
            if (d.a.h0.a.r1.e.h() != null && d.a.h0.a.r1.e.h().L() != null) {
                cVar.f45413c = d.a.h0.a.r1.e.h().L().S();
            }
            cVar.f45415e = d.a.h0.a.r1.e.T();
            cVar.f45411a = h.n(this.f45382i);
            p.j(new RunnableC0866a(this, cVar), "SwanAppDownloadFile");
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.z1.k.e f45384e;

        public b(d.a.h0.a.z1.k.e eVar) {
            this.f45384e = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.h0.a.z1.b.j("894", this.f45384e.f());
        }
    }

    /* loaded from: classes3.dex */
    public static class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.z1.k.b f45385e;

        public c(d.a.h0.a.z1.k.b bVar) {
            this.f45385e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.h0.a.z1.b.j("751", this.f45385e.f());
        }
    }

    /* loaded from: classes3.dex */
    public static class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.z1.k.e f45386e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.z1.a f45387f;

        public d(d.a.h0.a.z1.k.e eVar, d.a.h0.a.z1.a aVar) {
            this.f45386e = eVar;
            this.f45387f = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.h0.a.z1.k.e eVar = this.f45386e;
            if (eVar != null) {
                d.a.h0.a.z1.b.f(this.f45387f, eVar.f().toString());
            }
            d.a.h0.a.z1.b.c(this.f45387f);
        }
    }

    /* loaded from: classes3.dex */
    public static class e implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.z1.k.d f45388e;

        public e(d.a.h0.a.z1.k.d dVar) {
            this.f45388e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (TextUtils.isEmpty(this.f45388e.g())) {
                this.f45388e.k(d.a.h0.a.r1.d.e().p().J().U());
            }
            d.a.h0.a.z1.b.j("671", this.f45388e.f());
            d.a.h0.a.c0.c.h("SwanAppUBCStatistic", "671 event=" + this.f45388e.f().toString());
        }
    }

    /* loaded from: classes3.dex */
    public static class f implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f45389e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.z1.k.e f45390f;

        public f(String str, d.a.h0.a.z1.k.e eVar) {
            this.f45389e = str;
            this.f45390f = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.h0.a.z1.b.j(this.f45389e, this.f45390f.f());
        }
    }

    /* loaded from: classes3.dex */
    public static class g implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f45391e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f45392f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.z1.k.e f45393g;

        public g(String str, String str2, d.a.h0.a.z1.k.e eVar) {
            this.f45391e = str;
            this.f45392f = str2;
            this.f45393g = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.h0.a.z1.b.h(this.f45391e, this.f45392f, this.f45393g.f());
        }
    }

    /* renamed from: d.a.h0.a.z1.h$h  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class RunnableC0867h implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.z1.k.b f45394e;

        public RunnableC0867h(d.a.h0.a.z1.k.b bVar) {
            this.f45394e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.h0.a.z1.b.j("751", this.f45394e.f());
        }
    }

    /* loaded from: classes3.dex */
    public static class i implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.z1.k.b f45395e;

        public i(d.a.h0.a.z1.k.b bVar) {
            this.f45395e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.h0.a.z1.b.j("751", this.f45395e.f());
        }
    }

    /* loaded from: classes3.dex */
    public static class j implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.z1.k.e f45396e;

        public j(d.a.h0.a.z1.k.e eVar) {
            this.f45396e = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f45396e.b(h.K());
            d.a.h0.a.z1.b.j("778", this.f45396e.f());
        }
    }

    /* loaded from: classes3.dex */
    public static class k extends d.a.h0.a.n1.a.b.c.b {

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f45397c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f45398d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f45399e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f45400f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ long f45401g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ long f45402h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f45403i;
        public final /* synthetic */ String j;
        public final /* synthetic */ int k;
        public final /* synthetic */ NetworkStatRecord l;

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.h0.a.z1.k.c f45404e;

            public a(k kVar, d.a.h0.a.z1.k.c cVar) {
                this.f45404e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (h.f45373a) {
                    Log.d("SwanAppUBCStatistic", "Reporting: " + this.f45404e.f());
                }
                JSONObject f2 = this.f45404e.f();
                d.a.h0.a.z1.b.j("834", f2);
                h.E(this.f45404e.l(), this.f45404e.m(), f2);
                d.a.h0.a.c0.c.h("SwanAppUBCStatistic", "834-request event=" + f2.toString());
            }
        }

        public k(String str, int i2, String str2, String str3, long j, long j2, String str4, String str5, int i3, NetworkStatRecord networkStatRecord) {
            this.f45397c = str;
            this.f45398d = i2;
            this.f45399e = str2;
            this.f45400f = str3;
            this.f45401g = j;
            this.f45402h = j2;
            this.f45403i = str4;
            this.j = str5;
            this.k = i3;
            this.l = networkStatRecord;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.a.n1.a.b.c.b, d.a.h0.a.n1.a.b.c.c, d.a.h0.a.n1.a.b.c.a
        public void onEvent(@NonNull d.a.h0.a.n1.a.b.a.b bVar) {
            d.a.h0.a.z1.k.c cVar;
            int i2 = bVar.a() != null ? bVar.a().getInt("net_quality") : -1;
            if (h.f45373a) {
                Log.d("SwanAppUBCStatistic", "get NetworkQuality: " + i2);
            }
            if (TextUtils.equals(this.f45397c, "1")) {
                cVar = new d.a.h0.a.z1.k.c(this.f45398d, this.f45399e, this.f45400f, i2, this.f45401g, this.f45402h);
            } else {
                cVar = new d.a.h0.a.z1.k.c(this.f45399e, i2);
            }
            if (!TextUtils.isEmpty(this.f45403i)) {
                cVar.o(this.f45403i);
            }
            if (!TextUtils.isEmpty(this.j)) {
                cVar.n(this.j);
            }
            cVar.f45412b = "request";
            if (d.a.h0.a.r1.d.e().p().d()) {
                cVar.f45413c = d.a.h0.a.r1.d.e().p().J().S();
            }
            cVar.f45415e = d.a.h0.a.r1.e.T();
            cVar.f45411a = h.n(this.k);
            JSONObject I = h.I(this.l);
            if (I != null) {
                cVar.e(I);
            }
            p.j(new a(this, cVar), "SwanAppUBCRequest");
        }
    }

    static {
        CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        f45375c = copyOnWriteArrayList;
        copyOnWriteArrayList.add("https://hmma.baidu.com/mini.gif");
        f45375c.add("https://dxp.baidu.com/mini");
        f45375c.add("https://mbd.baidu.com/smtapp/recordhandler/getrecordinfo");
    }

    public static void A(String str, String str2, ArrayList<String> arrayList) {
        int i2;
        String str3;
        if (d.a.h0.a.r1.d.e().p().d()) {
            b.a J = d.a.h0.a.r1.d.e().p().J();
            i2 = J.F();
            str3 = J.n0().getString(UBCCloudControlProcessor.UBC_KEY);
        } else {
            i2 = 0;
            str3 = "";
        }
        d.a.h0.a.z1.k.b bVar = new d.a.h0.a.z1.k.b();
        bVar.f45412b = "pay";
        bVar.f45413c = str;
        bVar.f45415e = d.a.h0.a.r1.e.T();
        bVar.f45411a = n(i2);
        try {
            JSONObject jSONObject = new JSONObject(str3);
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put("paymenturl", str2);
            }
            if (arrayList != null) {
                jSONObject.put("whitelist", arrayList);
            }
            jSONObject.put("appname", d.a.h0.a.r1.e.h().M());
            bVar.e(jSONObject);
        } catch (JSONException e2) {
            e2.printStackTrace();
            bVar.d(str3);
        }
        bVar.b(K());
        p.k(new i(bVar), "SwanAppUBCOnPay");
    }

    public static void B(boolean z, String str, String str2, int i2) {
        d.a.h0.a.z1.k.b bVar = new d.a.h0.a.z1.k.b();
        b.a J = d.a.h0.a.r1.d.e().p().J();
        if (d.a.h0.a.r1.d.e().p().d()) {
            bVar.d(J.n0().getString(UBCCloudControlProcessor.UBC_KEY));
        }
        bVar.f45412b = "pay";
        bVar.f45414d = z ? "success" : "fail";
        bVar.f45413c = str;
        bVar.f45415e = d.a.h0.a.r1.e.T();
        bVar.f45411a = n(i2);
        bVar.a("money", str2);
        bVar.b(K());
        p.j(new RunnableC0867h(bVar), "SwanAppUBCOnPay");
    }

    public static void C(String str, boolean z, boolean z2) {
        d.a.h0.a.z1.k.b bVar = new d.a.h0.a.z1.k.b();
        b.a J = d.a.h0.a.r1.d.e().p().J();
        if (d.a.h0.a.r1.d.e().p().d()) {
            bVar.d(J.n0().getString(UBCCloudControlProcessor.UBC_KEY));
        }
        bVar.f45412b = "paylogin";
        bVar.f45413c = str;
        bVar.f45415e = J.H();
        bVar.f45411a = n(J.F());
        bVar.f45414d = z ? "success" : "fail";
        bVar.a("nativeAppId", d.a.h0.a.w0.a.k().f());
        bVar.a("paylogin", z2 ? "1" : "0");
        d.a.h0.a.e0.l.e J2 = d.a.h0.a.z0.f.V().J();
        d.a.h0.a.e1.c F1 = J2 == null ? null : J2.F1();
        if (F1 != null && !TextUtils.isEmpty(F1.g())) {
            bVar.a("page", F1.g());
        }
        bVar.b(K());
        p.j(new c(bVar), "SwanAppUBCOnPayLogin");
    }

    public static void D(int i2, String str, int i3, String str2, @Nullable String str3, @Nullable String str4, String str5, long j2, long j3, @Nullable NetworkStatRecord networkStatRecord) {
        if (SwanAppNetworkUtils.h(null)) {
            if (o(str)) {
                if (f45373a) {
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
                        d.a.h0.a.e0.f.i(str, j4);
                    } else {
                        d.a.h0.a.e0.f.g(str, i2);
                    }
                } else if (TextUtils.equals(str5, "0")) {
                    d.a.h0.a.e0.f.h(str);
                }
            }
            if (z && j4 < 5000) {
                if (f45373a) {
                    Log.d("SwanAppUBCStatistic", "code 200 & cost(" + j4 + ") is ok, don't report");
                    return;
                }
                return;
            }
            d.a.h0.a.n1.c.e.a.C().J(null, d.a.h0.g.w.d.class, new k(str5, i2, str, str2, j2, j3, str3, str4, i3, networkStatRecord));
        }
    }

    public static void E(String str, String str2, @NonNull JSONObject jSONObject) {
        if (!TextUtils.equals(str, "1")) {
            if (f45373a) {
                Log.d("SwanAppUBCStatistic", "RequestForAvatar: onRequestForAvatar: miss. requestType=" + str);
            }
        } else if (TextUtils.isEmpty(str2)) {
            if (f45373a) {
                Log.d("SwanAppUBCStatistic", "RequestForAvatar: onRequestForAvatar: miss. url is empty");
            }
        } else {
            HttpUrl parse = HttpUrl.parse(str2);
            if (parse == null) {
                if (f45373a) {
                    Log.d("SwanAppUBCStatistic", "RequestForAvatar: onRequestForAvatar: miss. url is illegal, url=" + str2);
                    return;
                }
                return;
            }
            String host = parse.host();
            if (TextUtils.isEmpty(host)) {
                if (f45373a) {
                    Log.d("SwanAppUBCStatistic", "RequestForAvatar: onRequestForAvatar: miss. host is empty, url=" + str2);
                }
            } else if (f45374b.contains(host)) {
                if (f45373a) {
                    Log.d("SwanAppUBCStatistic", "RequestForAvatar: onRequestForAvatar: miss. host is ignored, host=" + host + " ,url=" + str2);
                }
            } else {
                if (f45373a) {
                    Log.d("SwanAppUBCStatistic", "RequestForAvatar: onRequestForAvatar: hit. url=" + str2);
                    Log.d("SwanAppUBCStatistic", "value=" + jSONObject);
                }
                d.a.h0.a.z1.b.h("1415", "66", jSONObject);
            }
        }
    }

    public static void F(int i2, String str, int i3, String str2, long j2, long j3) {
        G(i2, str, i3, str2, null, null, j2, j3);
    }

    public static void G(int i2, String str, int i3, String str2, @Nullable String str3, @Nullable String str4, long j2, long j3) {
        D(i2, str, i3, str2, str3, str4, "1", j2, j3, null);
    }

    public static void H(d.a.h0.a.z1.k.d dVar) {
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
            if (f45373a) {
                e2.printStackTrace();
            }
            return null;
        }
    }

    public static void J() {
        d.a.h0.a.r1.d e2 = d.a.h0.a.r1.d.e();
        d.a.h0.a.r1.e p = e2.p();
        b.a J = p.J();
        if (e2.z() && p.e0()) {
            Bundle n0 = J.n0();
            if (n0.getLong("launch_flag_for_statistic") > 0) {
                String valueOf = String.valueOf(System.currentTimeMillis() - p.J().l1());
                d.a.h0.a.z1.k.f fVar = new d.a.h0.a.z1.k.f();
                fVar.f45411a = n(J.F());
                fVar.f45412b = "launch";
                fVar.f45414d = QueryResponse.Options.CANCEL;
                fVar.r = valueOf;
                fVar.j(J);
                fVar.d(n0.getString(UBCCloudControlProcessor.UBC_KEY));
                fVar.b(l(J.V()));
                onEvent(fVar);
                d.a.h0.a.z1.k.f fVar2 = new d.a.h0.a.z1.k.f();
                fVar2.f45411a = n(J.F());
                fVar2.f45412b = "launch";
                fVar2.f45414d = "realcancel";
                fVar2.r = valueOf;
                fVar2.j(J);
                fVar2.b(l(J.V()));
                fVar2.a("reason", QueryResponse.Options.CANCEL);
                if (J.F() == 1) {
                    fVar.a("errorList", d.a.h0.g.c0.b.c().d());
                }
                fVar2.d(n0.getString(UBCCloudControlProcessor.UBC_KEY));
                onEvent(fVar2);
                n0.remove("launch_flag_for_statistic");
            }
            d.a.h0.a.z1.l.b.a(new SearchFlowEvent("nreach", System.currentTimeMillis(), "custom_return", "", SearchFlowEvent.EventType.END));
        }
    }

    public static JSONObject K() {
        b.a L;
        JSONObject L2;
        d.a.h0.a.r1.e h2 = d.a.h0.a.r1.e.h();
        if (h2 == null || (L = h2.L()) == null || (L2 = L.L()) == null || !TextUtils.equals(L2.optString("token"), "swanubc")) {
            return null;
        }
        return L2;
    }

    public static d.a.h0.a.z1.a e(String str) {
        return d.a.h0.a.z1.b.a(str);
    }

    public static void f(d.a.h0.a.z1.k.f fVar) {
        if (fVar == null || d.a.h0.a.r1.e.h() == null || d.a.h0.a.r1.e.h().L() == null) {
            return;
        }
        b.a L = d.a.h0.a.r1.e.h().L();
        fVar.f45411a = n(L.F());
        fVar.f45415e = L.G();
        fVar.a("appkey", L.H());
        u("1032", fVar);
    }

    public static void g(String str) {
        d.a.h0.a.z1.k.e eVar = new d.a.h0.a.z1.k.e();
        eVar.f45411a = n(0);
        eVar.f45412b = str;
        u("956", eVar);
    }

    public static void h(String str, String str2, String str3) {
        d.a.h0.a.z1.k.e eVar = new d.a.h0.a.z1.k.e();
        if (d.a.h0.a.r1.e.h() != null && d.a.h0.a.r1.e.h().L() != null) {
            b.a L = d.a.h0.a.r1.e.h().L();
            eVar.f45411a = n(L.F());
            eVar.f45415e = L.G();
            eVar.f45412b = str;
            eVar.f45413c = str2;
            eVar.f45414d = str3;
            eVar.a("appkey", L.H());
        }
        u("923", eVar);
    }

    public static void i(d.a.h0.a.z1.k.e eVar) {
        if (d.a.h0.a.r1.e.h() != null && d.a.h0.a.r1.e.h().L() != null) {
            b.a L = d.a.h0.a.r1.e.h().L();
            eVar.f45411a = n(L.F());
            eVar.f45415e = L.G();
            eVar.f45413c = L.S();
        }
        u("936", eVar);
    }

    public static void j(d.a.h0.a.z1.k.e eVar) {
        if (d.a.h0.a.r1.e.h() != null && d.a.h0.a.r1.e.h().L() != null) {
            b.a L = d.a.h0.a.r1.e.h().L();
            eVar.f45411a = n(L.F());
            eVar.f45415e = L.G();
            eVar.f45413c = L.S();
        }
        u("914", eVar);
    }

    public static void k(d.a.h0.a.z1.a aVar, d.a.h0.a.z1.k.e eVar) {
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
                if (f45373a) {
                    e2.printStackTrace();
                }
            }
        }
        return null;
    }

    public static String m() {
        return d.a.h0.a.f1.e.g() ? "1" : "0";
    }

    public static String n(int i2) {
        return i2 != 1 ? "swan" : SwanFavorItemData.SCHEME_AUTHORITY_SWAN_GAME;
    }

    public static boolean o(String str) {
        if (f45373a) {
            Log.d("SwanAppUBCStatistic", "isIgnoreRequest: start with " + str);
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        int size = f45375c.size();
        for (int i2 = 0; i2 < size; i2++) {
            String str2 = f45375c.get(i2);
            if (!TextUtils.isEmpty(str2) && str.startsWith(str2)) {
                if (f45373a) {
                    Log.d("SwanAppUBCStatistic", "isIgnoreRequest: ignore " + str);
                    return true;
                }
                return true;
            }
        }
        return false;
    }

    public static void onEvent(d.a.h0.a.z1.k.f fVar) {
        ExtensionCore K = d.a.h0.a.e0.w.d.L().K();
        if (K != null) {
            fVar.a("extension_ver", K.extensionCoreVersionName);
        }
        u("606", fVar);
    }

    public static void p(String str, String str2, boolean z) {
        d.a.h0.a.z1.k.e eVar = new d.a.h0.a.z1.k.e();
        eVar.f45412b = str;
        eVar.f45414d = str2;
        eVar.f45415e = d.a.h0.a.r1.e.T();
        if (d.a.h0.a.r1.e.h() != null && d.a.h0.a.r1.e.h().L() != null) {
            b.a L = d.a.h0.a.r1.e.h().L();
            eVar.f45413c = L.S();
            eVar.f45411a = n(L.F());
        }
        if (TextUtils.equals(PrefetchEvent.STATE_CLICK, str)) {
            eVar.a("authorize", z ? "success" : "fail");
        }
        p.k(new b(eVar), "SwanAppUBCOnAuthDialog");
    }

    public static void q(int i2, d.a.h0.a.v1.c.e eVar) {
        d.a.h0.a.r1.e O = d.a.h0.a.r1.e.O();
        if (O == null) {
            if (f45373a) {
                Log.e("SwanAppUBCStatistic", "onAuthorizeFailed-swanApp is null");
                return;
            }
            return;
        }
        d.a.h0.a.z1.k.d dVar = new d.a.h0.a.z1.k.d();
        dVar.o(i2);
        dVar.r(O.L());
        dVar.q(n(O.j()));
        dVar.m(O.getAppId());
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appid", O.getAppId());
            jSONObject.put("msg", d.a.h0.a.v1.c.c.f(i2));
            jSONObject.put(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID, O.R().p("cur_request_id", ""));
            if (eVar != null) {
                jSONObject.put("scope", eVar.f44911b);
                jSONObject.put("scopeData", eVar.f44910a);
            }
        } catch (JSONException e2) {
            if (f45373a) {
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
        d.a.h0.a.n1.c.e.a.C().J(null, d.a.h0.g.w.d.class, new a(str5, i2, str, str2, str3, str4, i3));
    }

    public static void s(int i2, String str, int i3, String str2) {
        r(i2, str, i3, str2, null, null, "1");
    }

    public static void t(int i2, String str, int i3, String str2, @Nullable String str3, @Nullable String str4) {
        r(i2, str, i3, str2, str3, str4, "1");
    }

    public static void u(String str, d.a.h0.a.z1.k.e eVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        p.j(new f(str, eVar), "SwanAppUBCOnEvent");
    }

    public static void v(String str, String str2, d.a.h0.a.z1.k.e eVar) {
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
        if (d.a.h0.a.r1.d.e().z() && (O = (J = d.a.h0.a.r1.d.e().p().J()).O()) != null && O.getLong("launch_flag_for_statistic") > 0) {
            long k2 = J.k("launch_time", 0L);
            long currentTimeMillis = System.currentTimeMillis();
            d.a.h0.a.z1.k.f fVar = new d.a.h0.a.z1.k.f();
            fVar.f45411a = n(d.a.h0.a.r1.d.e().j());
            fVar.f45415e = J.G();
            if (d.a.h0.a.m1.a.a.B(J.d0())) {
                fVar.f45413c = "remote-debug";
            } else {
                fVar.f45413c = J.S();
            }
            fVar.f45412b = "launch";
            fVar.f45414d = "success";
            fVar.s = String.valueOf(currentTimeMillis - k2);
            fVar.a("status", "0");
            d.a.h0.a.z1.e.k(fVar, J.V(), J.n0().getString(UBCCloudControlProcessor.UBC_KEY));
            O.putLong("launch_flag_for_statistic", 0L);
            HybridUbcFlow d2 = d.a.h0.a.j1.i.d("startup");
            if (d2 != null) {
                if (d2.s() || d2.q()) {
                    return;
                }
                d2.z("value", "na_success");
            }
        }
    }

    public static void z(boolean z, String str) {
        d.a.h0.a.z1.k.e eVar = new d.a.h0.a.z1.k.e();
        if (d.a.h0.a.r1.d.e().p().d()) {
            eVar.d(d.a.h0.a.r1.d.e().p().J().n0().getString(UBCCloudControlProcessor.UBC_KEY));
        }
        eVar.f45412b = "show";
        eVar.f45413c = str;
        eVar.f45414d = z ? "success" : "fail";
        eVar.f45415e = d.a.h0.a.r1.e.T();
        p.k(new j(eVar), "SwanAppUBCOnPagesRoute");
    }
}
