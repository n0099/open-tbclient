package com.kwad.sdk.ip.direct;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.NetworkMonitor;
import com.kwad.sdk.core.response.model.HttpDnsInfo;
import com.kwad.sdk.g;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.f;
import com.kwad.sdk.service.a.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes10.dex */
public final class a {
    public static int aGX = -1;
    public static volatile boolean aGY;
    public static c aHg;
    public static HandlerThread aHh;
    public static Handler aHi;
    public static List<HttpDnsInfo.IpInfo> aGZ = new ArrayList();
    public static List<HttpDnsInfo.IpInfo> aHa = new ArrayList();
    public static List<HttpDnsInfo.IpInfo> aHb = new ArrayList();
    public static List<c> aHc = new ArrayList();
    public static List<c> aHd = new ArrayList();
    public static PriorityBlockingQueue<c> aHe = new PriorityBlockingQueue<>();
    public static AtomicInteger aHf = new AtomicInteger(0);
    public static volatile boolean aHj = false;
    public static float aHk = -1.0f;
    public static float aHl = -1.0f;
    public static float aHm = -1.0f;
    public static int aHn = 0;
    public static volatile boolean aHo = false;
    public static volatile boolean aHp = false;
    public static NetworkMonitor.a aHq = new NetworkMonitor.a() { // from class: com.kwad.sdk.ip.direct.a.1
        @Override // com.kwad.sdk.core.NetworkMonitor.a
        public final void a(NetworkMonitor.NetworkState networkState) {
            com.kwad.sdk.core.e.c.d("IpDirect_Helper", "*********onNetworkChange");
            if (a.aHp) {
                a.access$102(true);
                com.kwad.sdk.core.e.c.d("IpDirect_Helper", "*********onNetworkChange sHasNetChanged true");
                return;
            }
            a.access$002(true);
        }
    };
    public static Runnable aHr = new Runnable() { // from class: com.kwad.sdk.ip.direct.a.3
        @Override // java.lang.Runnable
        public final void run() {
            a.Hr();
        }
    };

    public static void Hr() {
        Hw();
        List<HttpDnsInfo.IpInfo> list = aGZ;
        List<HttpDnsInfo.IpInfo> list2 = aHa;
        clear();
        if (aHj) {
            com.kwad.sdk.core.e.c.d("IpDirect_Helper", "is picking return");
            return;
        }
        com.kwad.sdk.core.e.c.d("IpDirect_Helper", "start pick");
        aHj = true;
        E(list);
        F(list2);
        if (aHc.isEmpty() && aHd.isEmpty()) {
            h hVar = (h) ServiceProvider.get(h.class);
            if (hVar == null) {
                aHj = false;
                return;
            } else if (!hVar.yv()) {
                com.kwad.sdk.core.e.c.d("IpDirect_Helper", "isIpPreferEnable:false");
                aHj = false;
                return;
            } else {
                Hu();
            }
        }
        aHj = false;
        com.kwad.sdk.core.e.c.d("IpDirect_Helper", "end pick");
    }

    public static void Hu() {
        List<HttpDnsInfo.IpInfo> list = aHb;
        if (!list.isEmpty()) {
            for (HttpDnsInfo.IpInfo ipInfo : list) {
                if (ipInfo != null && !TextUtils.isEmpty(ipInfo.ip)) {
                    c d = b.d(ipInfo.ip, aGX);
                    if (d.isSuccess()) {
                        aHe.offer(d);
                    }
                }
            }
            c peek = aHe.peek();
            if (peek != null) {
                aHm = peek.HI();
            }
        }
    }

    public static void E(List<HttpDnsInfo.IpInfo> list) {
        b(list, aHc);
        if (!aHc.isEmpty()) {
            float f = 0.0f;
            for (c cVar : aHc) {
                f += cVar.HI();
            }
            aHk = f / aHc.size();
        }
    }

    public static /* synthetic */ boolean access$002(boolean z) {
        aHp = true;
        return true;
    }

    public static /* synthetic */ boolean access$102(boolean z) {
        aHo = true;
        return true;
    }

    public static void F(List<HttpDnsInfo.IpInfo> list) {
        b(list, aHd);
        if (aHd.isEmpty()) {
            return;
        }
        int i = 0;
        float f = 0.0f;
        for (c cVar : aHd) {
            i += cVar.getWeight();
            f += cVar.getWeight() * cVar.HI();
        }
        if (i != 0) {
            aHl = f / i;
        }
    }

    public static boolean fp(String str) {
        boolean z = !TextUtils.equals("https://" + str, g.xK());
        if (z) {
            com.kwad.sdk.core.e.c.d("IpDirect_Helper", "非核心域名 current host:" + g.xK() + "try direct host:https://" + str);
        }
        return z;
    }

    public static void HA() {
        Hy();
        HB();
        HC();
        aHn = 0;
        Hs();
        Hr();
    }

    public static void Hm() {
        Handler handler;
        if (!aHj && (handler = aHi) != null) {
            handler.obtainMessage(1).sendToTarget();
        }
    }

    public static String Hn() {
        c cVar = aHg;
        if (cVar != null) {
            return cVar.getIp();
        }
        return "";
    }

    public static float Ho() {
        return aHk;
    }

    public static float Hp() {
        return aHl;
    }

    public static float Hq() {
        return aHm;
    }

    public static void Hs() {
        if (!Ht()) {
            Hv();
        }
    }

    public static void Hw() {
        if (aGX == -1) {
            h hVar = (h) ServiceProvider.get(h.class);
            if (hVar != null) {
                aGX = hVar.yw();
            } else {
                aGX = 200;
            }
        }
    }

    public static boolean Hx() {
        if (aHo) {
            com.kwad.sdk.core.e.c.d("IpDirect_Helper", "sHasNetChanged direct can not use");
            return false;
        }
        int i = aHf.get();
        com.kwad.sdk.core.e.c.d("IpDirect_Helper", "value:" + i);
        if (i > 3) {
            return false;
        }
        return true;
    }

    public static void Hy() {
        aHf.getAndIncrement();
        com.kwad.sdk.core.e.c.d("IpDirect_Helper", "addFailedTimes:" + aHf.intValue());
    }

    public static void Hz() {
        c cVar;
        Handler handler;
        if (aGY && (cVar = aHg) != null && !TextUtils.isEmpty(cVar.getIp()) && (handler = aHi) != null) {
            handler.obtainMessage(2).sendToTarget();
        }
    }

    public static void clear() {
        aHc.clear();
        aHd.clear();
        aHe.clear();
    }

    public static int getType() {
        return aHn;
    }

    public static void HB() {
        String ip;
        HttpDnsInfo.IpInfo ipInfo;
        HttpDnsInfo.IpInfo ipInfo2;
        c cVar = aHg;
        if (cVar == null) {
            ip = "";
        } else {
            ip = cVar.getIp();
        }
        if (TextUtils.isEmpty(ip)) {
            return;
        }
        Iterator<HttpDnsInfo.IpInfo> it = aGZ.iterator();
        while (true) {
            ipInfo = null;
            if (it.hasNext()) {
                ipInfo2 = it.next();
                if (ipInfo2 != null && TextUtils.equals(ip, ipInfo2.ip)) {
                    break;
                }
            } else {
                ipInfo2 = null;
                break;
            }
        }
        if (ipInfo2 != null) {
            aGZ.remove(ipInfo2);
            ipInfo2 = null;
        }
        Iterator<HttpDnsInfo.IpInfo> it2 = aHa.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            HttpDnsInfo.IpInfo next = it2.next();
            if (next != null && TextUtils.equals(ip, next.ip)) {
                ipInfo2 = next;
                break;
            }
        }
        if (ipInfo2 != null) {
            aHa.remove(ipInfo2);
        } else {
            ipInfo = ipInfo2;
        }
        Iterator<HttpDnsInfo.IpInfo> it3 = aHb.iterator();
        while (true) {
            if (!it3.hasNext()) {
                break;
            }
            HttpDnsInfo.IpInfo next2 = it3.next();
            if (next2 != null && TextUtils.equals(ip, next2.ip)) {
                ipInfo = next2;
                break;
            }
        }
        if (ipInfo != null) {
            aHb.remove(ipInfo);
        }
    }

    public static void HC() {
        c cVar;
        if (aHg == null) {
            return;
        }
        List<c> list = aHc;
        if (list != null && !list.isEmpty() && aHc.contains(aHg)) {
            aHc.remove(aHg);
            com.kwad.sdk.core.e.c.d("IpDirect_Helper", "sRecommendEntityList remove:" + aHg);
        }
        List<c> list2 = aHd;
        if (list2 != null && !list2.isEmpty()) {
            if (aHd.contains(aHg)) {
                aHd.remove(aHg);
                com.kwad.sdk.core.e.c.d("IpDirect_Helper", "sBackUpIpEntityList remove:" + aHg);
            }
            Iterator<c> it = aHd.iterator();
            while (true) {
                if (it.hasNext()) {
                    cVar = it.next();
                    if (cVar != null && TextUtils.equals(cVar.getIp(), aHg.getIp())) {
                        com.kwad.sdk.core.e.c.d("IpDirect_Helper", "set removeEntity:" + cVar.getIp());
                        break;
                    }
                } else {
                    cVar = null;
                    break;
                }
            }
            if (cVar != null) {
                aHd.remove(cVar);
                com.kwad.sdk.core.e.c.d("IpDirect_Helper", "sBackUpIpEntityList remove removeEntity:" + cVar);
            }
        }
        c peek = aHe.peek();
        if (peek != null && peek == aHg) {
            aHe.poll();
        }
        aHg = null;
    }

    public static boolean Ht() {
        List<c> list = aHc;
        List<c> list2 = aHd;
        if (!list.isEmpty()) {
            aHg = list.get(new Random().nextInt(list.size()));
            com.kwad.sdk.core.e.c.d("IpDirect_Helper", "set from recommend:" + aHg);
            aHn = 1;
            return true;
        }
        int i = 0;
        if (list2.isEmpty()) {
            return false;
        }
        Random random = new Random();
        int i2 = 0;
        for (c cVar : list2) {
            i2 += cVar.getWeight();
        }
        int nextInt = random.nextInt(i2);
        int i3 = 0;
        while (true) {
            if (i3 >= list2.size()) {
                break;
            }
            nextInt -= list2.get(i3).getWeight();
            if (nextInt < 0) {
                i = i3;
                break;
            }
            i3++;
        }
        aHg = list2.get(i);
        com.kwad.sdk.core.e.c.d("IpDirect_Helper", "set from backUp:" + aHg);
        aHn = 2;
        return true;
    }

    public static void Hv() {
        if (aHe.isEmpty()) {
            return;
        }
        c peek = aHe.peek();
        if (peek.HI() < aGX) {
            aHg = peek;
            com.kwad.sdk.core.e.c.d("IpDirect_Helper", "set from Other:" + aHg);
            aHn = 3;
        }
    }

    public static void init() {
        if (aHh != null) {
            return;
        }
        HandlerThread handlerThread = new HandlerThread("IpDirectHelper");
        aHh = handlerThread;
        handlerThread.start();
        aHi = new Handler(aHh.getLooper()) { // from class: com.kwad.sdk.ip.direct.a.2
            @Override // android.os.Handler
            public final void handleMessage(@NonNull Message message) {
                int i = message.what;
                if (i != 1) {
                    if (i == 2) {
                        a.HA();
                        return;
                    }
                    return;
                }
                a.Hr();
                a.Hs();
            }
        };
        f fVar = (f) ServiceProvider.get(f.class);
        if (fVar != null) {
            NetworkMonitor.getInstance().a(fVar.getContext(), aHq);
        }
    }

    public static void a(HttpDnsInfo httpDnsInfo) {
        if (httpDnsInfo == null) {
            return;
        }
        h hVar = (h) ServiceProvider.get(h.class);
        if (hVar == null) {
            com.kwad.sdk.core.e.c.w("IpDirect_Helper", "sdkConfigProvider == null");
            return;
        }
        boolean yu = hVar.yu();
        aGY = yu;
        com.kwad.sdk.core.e.c.d("IpDirect_Helper", "isEnable:" + yu);
        if (!yu) {
            return;
        }
        com.kwad.sdk.core.e.c.d("IpDirect_Helper", httpDnsInfo.toString());
        List<HttpDnsInfo.IpInfo> list = httpDnsInfo.recommendList;
        aGZ = list;
        aHa = httpDnsInfo.backUpList;
        aHb = httpDnsInfo.otherList;
        if (list.isEmpty() && aHa.isEmpty() && aHb.isEmpty()) {
            com.kwad.sdk.core.e.c.w("IpDirect_Helper", "HttpDnsInfo is empty");
            return;
        }
        init();
        Hm();
    }

    public static void b(List<HttpDnsInfo.IpInfo> list, List<c> list2) {
        if (list == null) {
            return;
        }
        for (HttpDnsInfo.IpInfo ipInfo : list) {
            if (ipInfo != null && !TextUtils.isEmpty(ipInfo.ip)) {
                com.kwad.sdk.core.e.c.d("IpDirect_Helper", ipInfo.toString());
                c d = b.d(ipInfo.ip, aGX);
                d.dd(ipInfo.weight);
                if (d.isSuccess() && d.HI() < aGX) {
                    list2.add(d);
                }
            }
        }
    }

    @Nullable
    public static String fo(String str) {
        if (!aGY) {
            com.kwad.sdk.core.e.c.d("IpDirect_Helper", "getIpByHost return by sIpDirectEnable false");
            return "";
        } else if (fp(str)) {
            com.kwad.sdk.core.e.c.d("IpDirect_Helper", "isHostInvalid:false ：" + str);
            return "";
        } else if (!Hx()) {
            com.kwad.sdk.core.e.c.d("IpDirect_Helper", "canUseIpDirect:false");
            return "";
        } else {
            String Hn = Hn();
            com.kwad.sdk.core.e.c.d("IpDirect_Helper", "getIpByHost ip:" + Hn);
            return Hn;
        }
    }
}
