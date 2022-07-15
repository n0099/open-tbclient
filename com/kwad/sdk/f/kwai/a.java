package com.kwad.sdk.f.kwai;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.NetworkMonitor;
import com.kwad.sdk.core.response.model.HttpDnsInfo;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.kwai.d;
import com.kwad.sdk.service.kwai.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes5.dex */
public final class a {
    public static int a = -1;
    public static volatile boolean b;
    public static c j;
    public static HandlerThread k;
    public static Handler l;
    public static List<HttpDnsInfo.IpInfo> c = new ArrayList();
    public static List<HttpDnsInfo.IpInfo> d = new ArrayList();
    public static List<HttpDnsInfo.IpInfo> e = new ArrayList();
    public static List<c> f = new ArrayList();
    public static List<c> g = new ArrayList();
    public static PriorityBlockingQueue<c> h = new PriorityBlockingQueue<>();
    public static AtomicInteger i = new AtomicInteger(0);
    public static volatile boolean m = false;
    public static float n = -1.0f;
    public static float o = -1.0f;
    public static float p = -1.0f;
    public static int q = 0;
    public static volatile boolean r = false;
    public static volatile boolean s = false;
    public static NetworkMonitor.a t = new NetworkMonitor.a() { // from class: com.kwad.sdk.f.kwai.a.1
        @Override // com.kwad.sdk.core.NetworkMonitor.a
        public final void a(NetworkMonitor.NetworkState networkState) {
            com.kwad.sdk.core.d.b.a("IpDirect_Helper", "*********onNetworkChange");
            if (!a.s) {
                boolean unused = a.s = true;
                return;
            }
            boolean unused2 = a.r = true;
            com.kwad.sdk.core.d.b.a("IpDirect_Helper", "*********onNetworkChange sHasNetChanged true");
        }
    };
    public static Runnable u = new Runnable() { // from class: com.kwad.sdk.f.kwai.a.3
        @Override // java.lang.Runnable
        public final void run() {
            a.m();
        }
    };

    public static String a() {
        c cVar = j;
        return cVar != null ? cVar.b() : "";
    }

    @Nullable
    public static String a(String str) {
        String str2;
        if (!b) {
            str2 = "getIpByHost return by sIpDirectEnable false";
        } else if (b(str)) {
            str2 = "isHostInvalid:false ：" + str;
        } else if (t()) {
            String a2 = a();
            com.kwad.sdk.core.d.b.a("IpDirect_Helper", "getIpByHost ip:" + a2);
            return a2;
        } else {
            str2 = "canUseIpDirect:false";
        }
        com.kwad.sdk.core.d.b.a("IpDirect_Helper", str2);
        return "";
    }

    public static void a(HttpDnsInfo httpDnsInfo) {
        if (httpDnsInfo == null) {
            return;
        }
        f fVar = (f) ServiceProvider.a(f.class);
        if (fVar == null) {
            com.kwad.sdk.core.d.b.d("IpDirect_Helper", "sdkConfigProvider == null");
            return;
        }
        boolean p2 = fVar.p();
        b = p2;
        com.kwad.sdk.core.d.b.a("IpDirect_Helper", "isEnable:" + p2);
        if (p2) {
            com.kwad.sdk.core.d.b.a("IpDirect_Helper", httpDnsInfo.toString());
            List<HttpDnsInfo.IpInfo> list = httpDnsInfo.recommendList;
            c = list;
            d = httpDnsInfo.backUpList;
            e = httpDnsInfo.otherList;
            if (list.isEmpty() && d.isEmpty() && e.isEmpty()) {
                com.kwad.sdk.core.d.b.d("IpDirect_Helper", "HttpDnsInfo is empty");
                return;
            }
            k();
            l();
        }
    }

    public static void a(List<HttpDnsInfo.IpInfo> list) {
        a(list, f);
        if (f.isEmpty()) {
            return;
        }
        float f2 = 0.0f;
        for (c cVar : f) {
            f2 += cVar.d();
        }
        n = f2 / f.size();
    }

    public static void a(List<HttpDnsInfo.IpInfo> list, List<c> list2) {
        if (list == null) {
            return;
        }
        for (HttpDnsInfo.IpInfo ipInfo : list) {
            if (ipInfo != null && !TextUtils.isEmpty(ipInfo.ip)) {
                com.kwad.sdk.core.d.b.a("IpDirect_Helper", ipInfo.toString());
                c a2 = b.a(ipInfo.ip, a);
                a2.a(ipInfo.weight);
                if (a2.c() && a2.d() < a) {
                    list2.add(a2);
                }
            }
        }
    }

    public static float b() {
        return n;
    }

    public static void b(List<HttpDnsInfo.IpInfo> list) {
        a(list, g);
        if (g.isEmpty()) {
            return;
        }
        int i2 = 0;
        float f2 = 0.0f;
        for (c cVar : g) {
            i2 += cVar.e();
            f2 += cVar.e() * cVar.d();
        }
        if (i2 != 0) {
            o = f2 / i2;
        }
    }

    public static boolean b(String str) {
        boolean z = !TextUtils.equals("https://" + str, com.kwad.sdk.b.a());
        if (z) {
            com.kwad.sdk.core.d.b.a("IpDirect_Helper", "非核心域名 current host:" + com.kwad.sdk.b.a() + "try direct host:https://" + str);
        }
        return z;
    }

    public static float c() {
        return o;
    }

    public static float d() {
        return p;
    }

    public static int e() {
        return q;
    }

    public static void f() {
        c cVar;
        Handler handler;
        if (!b || (cVar = j) == null || TextUtils.isEmpty(cVar.b()) || (handler = l) == null) {
            return;
        }
        handler.obtainMessage(2).sendToTarget();
    }

    public static void g() {
        u();
        v();
        w();
        q = 0;
        n();
        m();
    }

    public static void k() {
        if (k != null) {
            return;
        }
        HandlerThread handlerThread = new HandlerThread("IpDirectHelper");
        k = handlerThread;
        handlerThread.start();
        l = new Handler(k.getLooper()) { // from class: com.kwad.sdk.f.kwai.a.2
            @Override // android.os.Handler
            public final void handleMessage(@NonNull Message message) {
                int i2 = message.what;
                if (i2 == 1) {
                    a.m();
                    a.n();
                } else if (i2 != 2) {
                } else {
                    a.g();
                }
            }
        };
        d dVar = (d) ServiceProvider.a(d.class);
        if (dVar != null) {
            NetworkMonitor.a().a(dVar.a(), t);
        }
    }

    public static void l() {
        Handler handler;
        if (m || (handler = l) == null) {
            return;
        }
        handler.obtainMessage(1).sendToTarget();
    }

    public static void m() {
        s();
        List<HttpDnsInfo.IpInfo> list = c;
        List<HttpDnsInfo.IpInfo> list2 = d;
        p();
        if (m) {
            com.kwad.sdk.core.d.b.a("IpDirect_Helper", "is picking return");
            return;
        }
        com.kwad.sdk.core.d.b.a("IpDirect_Helper", "start pick");
        m = true;
        a(list);
        b(list2);
        if (f.isEmpty() && g.isEmpty()) {
            f fVar = (f) ServiceProvider.a(f.class);
            if (fVar == null) {
                m = false;
                return;
            } else if (!fVar.q()) {
                com.kwad.sdk.core.d.b.a("IpDirect_Helper", "isIpPreferEnable:false");
                m = false;
                return;
            } else {
                q();
            }
        }
        m = false;
        com.kwad.sdk.core.d.b.a("IpDirect_Helper", "end pick");
    }

    public static void n() {
        if (o()) {
            return;
        }
        r();
    }

    public static boolean o() {
        List<c> list = f;
        List<c> list2 = g;
        if (!list.isEmpty()) {
            j = list.get(new Random().nextInt(list.size()));
            com.kwad.sdk.core.d.b.a("IpDirect_Helper", "set from recommend:" + j);
            q = 1;
            return true;
        }
        int i2 = 0;
        if (list2.isEmpty()) {
            return false;
        }
        Random random = new Random();
        int i3 = 0;
        for (c cVar : list2) {
            i3 += cVar.e();
        }
        int nextInt = random.nextInt(i3);
        int i4 = 0;
        while (true) {
            if (i4 >= list2.size()) {
                break;
            }
            nextInt -= list2.get(i4).e();
            if (nextInt < 0) {
                i2 = i4;
                break;
            }
            i4++;
        }
        j = list2.get(i2);
        com.kwad.sdk.core.d.b.a("IpDirect_Helper", "set from backUp:" + j);
        q = 2;
        return true;
    }

    public static void p() {
        f.clear();
        g.clear();
        h.clear();
    }

    public static void q() {
        List<HttpDnsInfo.IpInfo> list = e;
        if (list.isEmpty()) {
            return;
        }
        for (HttpDnsInfo.IpInfo ipInfo : list) {
            if (ipInfo != null && !TextUtils.isEmpty(ipInfo.ip)) {
                c a2 = b.a(ipInfo.ip, a);
                if (a2.c()) {
                    h.offer(a2);
                }
            }
        }
        c peek = h.peek();
        if (peek != null) {
            p = peek.d();
        }
    }

    public static void r() {
        if (h.isEmpty()) {
            return;
        }
        c peek = h.peek();
        if (peek.d() < a) {
            j = peek;
            com.kwad.sdk.core.d.b.a("IpDirect_Helper", "set from Other:" + j);
            q = 3;
        }
    }

    public static void s() {
        if (a == -1) {
            f fVar = (f) ServiceProvider.a(f.class);
            if (fVar != null) {
                a = fVar.r();
            } else {
                a = 200;
            }
        }
    }

    public static boolean t() {
        if (r) {
            com.kwad.sdk.core.d.b.a("IpDirect_Helper", "sHasNetChanged direct can not use");
            return false;
        }
        int i2 = i.get();
        com.kwad.sdk.core.d.b.a("IpDirect_Helper", "value:" + i2);
        return i2 <= 3;
    }

    public static void u() {
        i.getAndIncrement();
        com.kwad.sdk.core.d.b.a("IpDirect_Helper", "addFailedTimes:" + i.intValue());
    }

    public static void v() {
        HttpDnsInfo.IpInfo ipInfo;
        HttpDnsInfo.IpInfo ipInfo2;
        c cVar = j;
        String b2 = cVar == null ? "" : cVar.b();
        if (TextUtils.isEmpty(b2)) {
            return;
        }
        Iterator<HttpDnsInfo.IpInfo> it = c.iterator();
        while (true) {
            ipInfo = null;
            if (!it.hasNext()) {
                ipInfo2 = null;
                break;
            }
            ipInfo2 = it.next();
            if (ipInfo2 != null && TextUtils.equals(b2, ipInfo2.ip)) {
                break;
            }
        }
        if (ipInfo2 != null) {
            c.remove(ipInfo2);
            ipInfo2 = null;
        }
        Iterator<HttpDnsInfo.IpInfo> it2 = d.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            HttpDnsInfo.IpInfo next = it2.next();
            if (next != null && TextUtils.equals(b2, next.ip)) {
                ipInfo2 = next;
                break;
            }
        }
        if (ipInfo2 != null) {
            d.remove(ipInfo2);
        } else {
            ipInfo = ipInfo2;
        }
        Iterator<HttpDnsInfo.IpInfo> it3 = e.iterator();
        while (true) {
            if (!it3.hasNext()) {
                break;
            }
            HttpDnsInfo.IpInfo next2 = it3.next();
            if (next2 != null && TextUtils.equals(b2, next2.ip)) {
                ipInfo = next2;
                break;
            }
        }
        if (ipInfo != null) {
            e.remove(ipInfo);
        }
    }

    public static void w() {
        c cVar;
        if (j == null) {
            return;
        }
        List<c> list = f;
        if (list != null && !list.isEmpty() && f.contains(j)) {
            f.remove(j);
            com.kwad.sdk.core.d.b.a("IpDirect_Helper", "sRecommendEntityList remove:" + j);
        }
        List<c> list2 = g;
        if (list2 != null && !list2.isEmpty()) {
            if (g.contains(j)) {
                g.remove(j);
                com.kwad.sdk.core.d.b.a("IpDirect_Helper", "sBackUpIpEntityList remove:" + j);
            }
            Iterator<c> it = g.iterator();
            while (true) {
                if (!it.hasNext()) {
                    cVar = null;
                    break;
                }
                cVar = it.next();
                if (cVar != null && TextUtils.equals(cVar.b(), j.b())) {
                    com.kwad.sdk.core.d.b.a("IpDirect_Helper", "set removeEntity:" + cVar.b());
                    break;
                }
            }
            if (cVar != null) {
                g.remove(cVar);
                com.kwad.sdk.core.d.b.a("IpDirect_Helper", "sBackUpIpEntityList remove removeEntity:" + cVar);
            }
        }
        c peek = h.peek();
        if (peek != null && peek == j) {
            h.poll();
        }
        j = null;
    }
}
