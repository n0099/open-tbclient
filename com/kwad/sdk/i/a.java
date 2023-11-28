package com.kwad.sdk.i;

import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ay;
import com.kwad.sdk.utils.g;
import com.kwad.sdk.utils.y;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
/* loaded from: classes10.dex */
public final class a {
    public static List<String> aHN;
    public static volatile boolean aHO;

    @KsJson
    /* loaded from: classes10.dex */
    public static class b extends com.kwad.sdk.core.response.a.a {
        public long aHQ;
        public long aHR;
        public long aHS;
        public String aHT;
        public String aHU;
        public String sdkVersion;
        public String stage;
    }

    @KsJson
    /* renamed from: com.kwad.sdk.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0721a extends com.kwad.sdk.commercial.d.a {
        public List<b> aHP;

        public C0721a(List<b> list) {
            this.aHP = list;
        }
    }

    public static void HN() {
        List<b> HP = HP();
        if (!HP.isEmpty()) {
            com.kwad.sdk.core.e.c.d("DynamicRunMonitor", "monitorInfoList:" + HP);
            com.kwad.sdk.commercial.a.o(new C0721a(HP));
        }
        aHO = true;
        HO();
    }

    public static void HO() {
        List<String> list = aHN;
        if (list == null) {
            return;
        }
        for (String str : list) {
            fr(str);
        }
        aHN.clear();
    }

    public static void report() {
        g.schedule(new ay() { // from class: com.kwad.sdk.i.a.1
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                a.HN();
            }
        }, 1L, TimeUnit.SECONDS);
    }

    /* loaded from: classes10.dex */
    public static class c {
        public String aHT;
        public String aHU;
        public String sdkVersion;
        public String stage;

        public static String a(c cVar) {
            return "exit&" + cVar.aHT + "&" + cVar.stage + "&" + cVar.aHU + "&" + cVar.sdkVersion;
        }

        public static c ft(String str) {
            String[] split = str.split("&");
            c cVar = new c();
            cVar.aHT = split[1];
            cVar.stage = split[2];
            cVar.aHU = split[3];
            cVar.sdkVersion = split[4];
            return cVar;
        }

        public static String c(String str, String str2, String str3, String str4) {
            return str + "&" + str2 + "&" + str3 + "&" + str4 + "&" + KsAdSDKImpl.get().getSDKVersion();
        }
    }

    public static List<b> HP() {
        long j;
        long j2;
        ArrayList arrayList = new ArrayList();
        Map<String, ?> al = y.al(ServiceProvider.getContext(), "dynamic_monitor_info");
        if (al == null) {
            return arrayList;
        }
        for (String str : al.keySet()) {
            if (str.startsWith("enter")) {
                Object obj = al.get(str);
                long j3 = 0;
                if (obj instanceof Long) {
                    j = ((Long) obj).longValue();
                } else {
                    j = 0;
                }
                c ft = c.ft(str);
                String a = c.a(ft);
                Object obj2 = al.get(a);
                if (obj2 instanceof Long) {
                    j2 = ((Long) obj2).longValue();
                } else {
                    j2 = 0;
                }
                long j4 = j - j2;
                if (j4 > 0) {
                    j3 = j4;
                }
                b bVar = new b();
                bVar.aHQ = j;
                bVar.aHR = j3;
                bVar.aHS = j4;
                bVar.aHT = ft.aHT;
                bVar.stage = ft.stage;
                bVar.aHU = ft.aHU;
                bVar.sdkVersion = ft.sdkVersion;
                arrayList.add(bVar);
                y.as("dynamic_monitor_info", str);
                y.as("dynamic_monitor_info", a);
            }
        }
        return arrayList;
    }

    public static void ai(String str, String str2) {
        f(str, str2, "other");
    }

    public static void aj(String str, String str2) {
        g(str, str2, "other");
    }

    public static void b(String str, String str2, String str3, String str4) {
        try {
            String c2 = c.c(str, str2, str3, str4);
            if (!aHO) {
                fs(c2);
            } else {
                fr(c2);
            }
        } catch (Throwable th) {
            com.kwad.components.core.d.a.b(th);
        }
    }

    public static void f(String str, String str2, String str3) {
        b("enter", str, str2, str3);
    }

    public static void g(String str, String str2, String str3) {
        b("exit", str, str2, str3);
    }

    public static synchronized void fr(String str) {
        synchronized (a.class) {
            long b2 = y.b("dynamic_monitor_info", str, 0L);
            com.kwad.sdk.core.e.c.d("DynamicRunMonitor", "increaseLocalCount: " + str + "--lastCount:" + b2);
            y.a("dynamic_monitor_info", str, b2 + 1);
        }
    }

    public static void fs(String str) {
        if (aHN == null) {
            aHN = new CopyOnWriteArrayList();
        }
        com.kwad.sdk.core.e.c.d("DynamicRunMonitor", "saveToCache: " + str);
        aHN.add(str);
    }
}
