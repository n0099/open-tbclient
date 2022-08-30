package com.kwad.sdk.ip.direct;

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
/* loaded from: classes7.dex */
public final class a {
    public static int aiD = -1;
    public static volatile boolean aiE;
    public static c aiM;
    public static HandlerThread aiN;
    public static Handler aiO;
    public static List<HttpDnsInfo.IpInfo> aiF = new ArrayList();
    public static List<HttpDnsInfo.IpInfo> aiG = new ArrayList();
    public static List<HttpDnsInfo.IpInfo> aiH = new ArrayList();
    public static List<c> aiI = new ArrayList();
    public static List<c> aiJ = new ArrayList();
    public static PriorityBlockingQueue<c> aiK = new PriorityBlockingQueue<>();
    public static AtomicInteger aiL = new AtomicInteger(0);
    public static volatile boolean aiP = false;
    public static float aiQ = -1.0f;
    public static float aiR = -1.0f;
    public static float aiS = -1.0f;
    public static int aiT = 0;
    public static volatile boolean aiU = false;
    public static volatile boolean aiV = false;
    public static NetworkMonitor.a aiW = new NetworkMonitor.a() { // from class: com.kwad.sdk.ip.direct.a.1
        @Override // com.kwad.sdk.core.NetworkMonitor.a
        public final void a(NetworkMonitor.NetworkState networkState) {
            com.kwad.sdk.core.e.b.d("IpDirect_Helper", "*********onNetworkChange");
            if (!a.aiV) {
                boolean unused = a.aiV = true;
                return;
            }
            boolean unused2 = a.aiU = true;
            com.kwad.sdk.core.e.b.d("IpDirect_Helper", "*********onNetworkChange sHasNetChanged true");
        }
    };
    public static Runnable aiX = new Runnable() { // from class: com.kwad.sdk.ip.direct.a.3
        @Override // java.lang.Runnable
        public final void run() {
            a.xw();
        }
    };

    public static void a(HttpDnsInfo httpDnsInfo) {
        if (httpDnsInfo == null) {
            return;
        }
        f fVar = (f) ServiceProvider.get(f.class);
        if (fVar == null) {
            com.kwad.sdk.core.e.b.w("IpDirect_Helper", "sdkConfigProvider == null");
            return;
        }
        boolean lK = fVar.lK();
        aiE = lK;
        com.kwad.sdk.core.e.b.d("IpDirect_Helper", "isEnable:" + lK);
        if (lK) {
            com.kwad.sdk.core.e.b.d("IpDirect_Helper", httpDnsInfo.toString());
            List<HttpDnsInfo.IpInfo> list = httpDnsInfo.recommendList;
            aiF = list;
            aiG = httpDnsInfo.backUpList;
            aiH = httpDnsInfo.otherList;
            if (list.isEmpty() && aiG.isEmpty() && aiH.isEmpty()) {
                com.kwad.sdk.core.e.b.w("IpDirect_Helper", "HttpDnsInfo is empty");
                return;
            }
            init();
            xr();
        }
    }

    public static void clear() {
        aiI.clear();
        aiJ.clear();
        aiK.clear();
    }

    public static void d(List<HttpDnsInfo.IpInfo> list, List<c> list2) {
        if (list == null) {
            return;
        }
        for (HttpDnsInfo.IpInfo ipInfo : list) {
            if (ipInfo != null && !TextUtils.isEmpty(ipInfo.ip)) {
                com.kwad.sdk.core.e.b.d("IpDirect_Helper", ipInfo.toString());
                c d = b.d(ipInfo.ip, aiD);
                d.bf(ipInfo.weight);
                if (d.isSuccess() && d.xO() < aiD) {
                    list2.add(d);
                }
            }
        }
    }

    @Nullable
    public static String dj(String str) {
        String str2;
        if (!aiE) {
            str2 = "getIpByHost return by sIpDirectEnable false";
        } else if (dk(str)) {
            str2 = "isHostInvalid:false ：" + str;
        } else if (xC()) {
            String xs = xs();
            com.kwad.sdk.core.e.b.d("IpDirect_Helper", "getIpByHost ip:" + xs);
            return xs;
        } else {
            str2 = "canUseIpDirect:false";
        }
        com.kwad.sdk.core.e.b.d("IpDirect_Helper", str2);
        return "";
    }

    public static boolean dk(String str) {
        boolean z = !TextUtils.equals("https://" + str, com.kwad.sdk.b.qJ());
        if (z) {
            com.kwad.sdk.core.e.b.d("IpDirect_Helper", "非核心域名 current host:" + com.kwad.sdk.b.qJ() + "try direct host:https://" + str);
        }
        return z;
    }

    public static int getType() {
        return aiT;
    }

    public static void init() {
        if (aiN != null) {
            return;
        }
        HandlerThread handlerThread = new HandlerThread("IpDirectHelper");
        aiN = handlerThread;
        handlerThread.start();
        aiO = new Handler(aiN.getLooper()) { // from class: com.kwad.sdk.ip.direct.a.2
            @Override // android.os.Handler
            public final void handleMessage(@NonNull Message message) {
                int i = message.what;
                if (i == 1) {
                    a.xw();
                    a.xx();
                } else if (i != 2) {
                } else {
                    a.xF();
                }
            }
        };
        d dVar = (d) ServiceProvider.get(d.class);
        if (dVar != null) {
            NetworkMonitor.getInstance().a(dVar.getContext(), aiW);
        }
    }

    public static void v(List<HttpDnsInfo.IpInfo> list) {
        d(list, aiI);
        if (aiI.isEmpty()) {
            return;
        }
        float f = 0.0f;
        for (c cVar : aiI) {
            f += cVar.xO();
        }
        aiQ = f / aiI.size();
    }

    public static void w(List<HttpDnsInfo.IpInfo> list) {
        d(list, aiJ);
        if (aiJ.isEmpty()) {
            return;
        }
        int i = 0;
        float f = 0.0f;
        for (c cVar : aiJ) {
            i += cVar.getWeight();
            f += cVar.getWeight() * cVar.xO();
        }
        if (i != 0) {
            aiR = f / i;
        }
    }

    public static void xA() {
        if (aiK.isEmpty()) {
            return;
        }
        c peek = aiK.peek();
        if (peek.xO() < aiD) {
            aiM = peek;
            com.kwad.sdk.core.e.b.d("IpDirect_Helper", "set from Other:" + aiM);
            aiT = 3;
        }
    }

    public static void xB() {
        if (aiD == -1) {
            f fVar = (f) ServiceProvider.get(f.class);
            if (fVar != null) {
                aiD = fVar.lM();
            } else {
                aiD = 200;
            }
        }
    }

    public static boolean xC() {
        if (aiU) {
            com.kwad.sdk.core.e.b.d("IpDirect_Helper", "sHasNetChanged direct can not use");
            return false;
        }
        int i = aiL.get();
        com.kwad.sdk.core.e.b.d("IpDirect_Helper", "value:" + i);
        return i <= 3;
    }

    public static void xD() {
        aiL.getAndIncrement();
        com.kwad.sdk.core.e.b.d("IpDirect_Helper", "addFailedTimes:" + aiL.intValue());
    }

    public static void xE() {
        c cVar;
        Handler handler;
        if (!aiE || (cVar = aiM) == null || TextUtils.isEmpty(cVar.getIp()) || (handler = aiO) == null) {
            return;
        }
        handler.obtainMessage(2).sendToTarget();
    }

    public static void xF() {
        xD();
        xG();
        xH();
        aiT = 0;
        xx();
        xw();
    }

    public static void xG() {
        HttpDnsInfo.IpInfo ipInfo;
        HttpDnsInfo.IpInfo ipInfo2;
        c cVar = aiM;
        String ip = cVar == null ? "" : cVar.getIp();
        if (TextUtils.isEmpty(ip)) {
            return;
        }
        Iterator<HttpDnsInfo.IpInfo> it = aiF.iterator();
        while (true) {
            ipInfo = null;
            if (!it.hasNext()) {
                ipInfo2 = null;
                break;
            }
            ipInfo2 = it.next();
            if (ipInfo2 != null && TextUtils.equals(ip, ipInfo2.ip)) {
                break;
            }
        }
        if (ipInfo2 != null) {
            aiF.remove(ipInfo2);
            ipInfo2 = null;
        }
        Iterator<HttpDnsInfo.IpInfo> it2 = aiG.iterator();
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
            aiG.remove(ipInfo2);
        } else {
            ipInfo = ipInfo2;
        }
        Iterator<HttpDnsInfo.IpInfo> it3 = aiH.iterator();
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
            aiH.remove(ipInfo);
        }
    }

    public static void xH() {
        c cVar;
        if (aiM == null) {
            return;
        }
        List<c> list = aiI;
        if (list != null && !list.isEmpty() && aiI.contains(aiM)) {
            aiI.remove(aiM);
            com.kwad.sdk.core.e.b.d("IpDirect_Helper", "sRecommendEntityList remove:" + aiM);
        }
        List<c> list2 = aiJ;
        if (list2 != null && !list2.isEmpty()) {
            if (aiJ.contains(aiM)) {
                aiJ.remove(aiM);
                com.kwad.sdk.core.e.b.d("IpDirect_Helper", "sBackUpIpEntityList remove:" + aiM);
            }
            Iterator<c> it = aiJ.iterator();
            while (true) {
                if (!it.hasNext()) {
                    cVar = null;
                    break;
                }
                cVar = it.next();
                if (cVar != null && TextUtils.equals(cVar.getIp(), aiM.getIp())) {
                    com.kwad.sdk.core.e.b.d("IpDirect_Helper", "set removeEntity:" + cVar.getIp());
                    break;
                }
            }
            if (cVar != null) {
                aiJ.remove(cVar);
                com.kwad.sdk.core.e.b.d("IpDirect_Helper", "sBackUpIpEntityList remove removeEntity:" + cVar);
            }
        }
        c peek = aiK.peek();
        if (peek != null && peek == aiM) {
            aiK.poll();
        }
        aiM = null;
    }

    public static void xr() {
        Handler handler;
        if (aiP || (handler = aiO) == null) {
            return;
        }
        handler.obtainMessage(1).sendToTarget();
    }

    public static String xs() {
        c cVar = aiM;
        return cVar != null ? cVar.getIp() : "";
    }

    public static float xt() {
        return aiQ;
    }

    public static float xu() {
        return aiR;
    }

    public static float xv() {
        return aiS;
    }

    public static void xw() {
        xB();
        List<HttpDnsInfo.IpInfo> list = aiF;
        List<HttpDnsInfo.IpInfo> list2 = aiG;
        clear();
        if (aiP) {
            com.kwad.sdk.core.e.b.d("IpDirect_Helper", "is picking return");
            return;
        }
        com.kwad.sdk.core.e.b.d("IpDirect_Helper", "start pick");
        aiP = true;
        v(list);
        w(list2);
        if (aiI.isEmpty() && aiJ.isEmpty()) {
            f fVar = (f) ServiceProvider.get(f.class);
            if (fVar == null) {
                aiP = false;
                return;
            } else if (!fVar.lL()) {
                com.kwad.sdk.core.e.b.d("IpDirect_Helper", "isIpPreferEnable:false");
                aiP = false;
                return;
            } else {
                xz();
            }
        }
        aiP = false;
        com.kwad.sdk.core.e.b.d("IpDirect_Helper", "end pick");
    }

    public static void xx() {
        if (xy()) {
            return;
        }
        xA();
    }

    public static boolean xy() {
        List<c> list = aiI;
        List<c> list2 = aiJ;
        if (!list.isEmpty()) {
            aiM = list.get(new Random().nextInt(list.size()));
            com.kwad.sdk.core.e.b.d("IpDirect_Helper", "set from recommend:" + aiM);
            aiT = 1;
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
        aiM = list2.get(i);
        com.kwad.sdk.core.e.b.d("IpDirect_Helper", "set from backUp:" + aiM);
        aiT = 2;
        return true;
    }

    public static void xz() {
        List<HttpDnsInfo.IpInfo> list = aiH;
        if (list.isEmpty()) {
            return;
        }
        for (HttpDnsInfo.IpInfo ipInfo : list) {
            if (ipInfo != null && !TextUtils.isEmpty(ipInfo.ip)) {
                c d = b.d(ipInfo.ip, aiD);
                if (d.isSuccess()) {
                    aiK.offer(d);
                }
            }
        }
        c peek = aiK.peek();
        if (peek != null) {
            aiS = peek.xO();
        }
    }
}
