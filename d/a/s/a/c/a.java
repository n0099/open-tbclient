package d.a.s.a.c;

import android.content.Context;
import com.baidu.searchbox.dns.DnsHelper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static int f63867a = 3;

    /* renamed from: b  reason: collision with root package name */
    public static Context f63868b;

    /* renamed from: c  reason: collision with root package name */
    public static List<String> f63869c = Collections.synchronizedList(new ArrayList());

    /* renamed from: d  reason: collision with root package name */
    public static int f63870d = 0;

    /* renamed from: d.a.s.a.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C1736a implements b {

        /* renamed from: a  reason: collision with root package name */
        public static C1736a f63871a;

        /* renamed from: d.a.s.a.c.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class RunnableC1737a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f63872e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ Timer f63873f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ d f63874g;

            /* renamed from: d.a.s.a.c.a$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes2.dex */
            public class C1738a extends TimerTask {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ AtomicBoolean f63875e;

                public C1738a(AtomicBoolean atomicBoolean) {
                    this.f63875e = atomicBoolean;
                }

                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    d.a.s.a.g.d.a("DNSUrlProvider", "bddns > bdDnsIps is null");
                    d.a.s.a.a.d.w(a.f63868b, "11N_3", "BDDNS timeout");
                    d dVar = RunnableC1737a.this.f63874g;
                    if (dVar != null) {
                        dVar.a(8007, "bddns timeout :", "bddns timeout, bdDnsIps is null");
                        a.g(true);
                        b d2 = a.d(a.f63868b);
                        RunnableC1737a runnableC1737a = RunnableC1737a.this;
                        d2.b(runnableC1737a.f63872e, runnableC1737a.f63874g);
                    }
                    this.f63875e.set(true);
                }
            }

            public RunnableC1737a(C1736a c1736a, String str, Timer timer, d dVar) {
                this.f63872e = str;
                this.f63873f = timer;
                this.f63874g = dVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                d.a.s.a.g.d.a("DNSUrlProvider", "bddns > getUrlAsync in... host is " + this.f63872e);
                AtomicBoolean atomicBoolean = new AtomicBoolean(false);
                this.f63873f.schedule(new C1738a(atomicBoolean), 10000L);
                DnsHelper dnsHelper = new DnsHelper(a.f63868b);
                dnsHelper.setHttpDnsState(false, null, false, true);
                a.k(dnsHelper.getIpList(this.f63872e));
                d.a.s.a.a.d.w(a.f63868b, "11N_1", "BDDNS get ips");
                List<String> list = a.f63869c;
                if (list == null || list.size() <= 0) {
                    return;
                }
                d.a.s.a.g.d.a("DNSUrlProvider", "bddns > bdDnsIps = " + a.f63869c);
                String str = a.f63869c.get(0);
                d.a.s.a.a.d.w(a.f63868b, "11Y", "BDDNS success");
                if (this.f63874g != null && !atomicBoolean.get()) {
                    this.f63874g.a(0, "ok", str);
                    if (a.f63869c.size() > 1) {
                        a.f63870d++;
                        a.g(false);
                    }
                }
                d.a.s.a.g.d.a("DNSUrlProvider", "bddns > return ip = " + str);
                this.f63873f.cancel();
            }
        }

        public C1736a(Context context) {
            Context unused = a.f63868b = context.getApplicationContext();
            a.j();
        }

        public static synchronized C1736a c(Context context) {
            C1736a c1736a;
            synchronized (C1736a.class) {
                if (f63871a == null) {
                    f63871a = new C1736a(context);
                }
                c1736a = f63871a;
            }
            return c1736a;
        }

        @Override // d.a.s.a.c.a.b
        public void a(String str, boolean z) {
        }

        @Override // d.a.s.a.c.a.b
        public void b(String str, d dVar) {
            try {
                d.a.s.a.g.d.d("DNSUrlProvider", "BDHttpDNSUrlProvider try to getUrlAsync");
                if (a.f63869c == null || a.f63869c.size() <= 0) {
                    d.a.s.a.a.d.w(a.f63868b, "11N", "BDDNS begin");
                    d.a.s.a.f.a.a(a.f63868b).b(new RunnableC1737a(this, str, new Timer(), dVar));
                } else if (a.f63870d < a.f63869c.size()) {
                    d.a.s.a.a.d.w(a.f63868b, "11Y", "BDDNS retry success");
                    if (dVar != null) {
                        dVar.a(0, "ok", a.f63869c.get(a.f63870d));
                        d.a.s.a.g.d.a("DNSUrlProvider", "retry bddns > return ip = " + a.f63869c.get(a.f63870d));
                    }
                    a.f63870d++;
                } else {
                    a.g(true);
                    a.d(a.f63868b).b(str, dVar);
                }
            } catch (Throwable unused) {
                d.a.s.a.a.d.w(a.f63868b, "11N_2", "BDDNS exception, HTTPDNS begin");
                d.a.s.a.g.d.a("DNSUrlProvider", "bddns > bdDnsIps get exception ");
                a.g(true);
                a.d(a.f63868b).b(str, dVar);
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface b {
        void a(String str, boolean z);

        void b(String str, d dVar);
    }

    /* loaded from: classes2.dex */
    public static class c implements b {

        /* renamed from: a  reason: collision with root package name */
        public static c f63877a;

        public static synchronized b c() {
            c cVar;
            synchronized (c.class) {
                if (f63877a == null) {
                    f63877a = new c();
                }
                cVar = f63877a;
            }
            return cVar;
        }

        @Override // d.a.s.a.c.a.b
        public void a(String str, boolean z) {
        }

        @Override // d.a.s.a.c.a.b
        public void b(String str, d dVar) {
            d.a.s.a.g.d.d("DNSUrlProvider", "DefaultUrlProvider try to getUrlAsync");
            d.a.s.a.a.d.w(a.f63868b, "12N", "DefaultUrlProvider begin");
            if (dVar != null) {
                a.j();
                d.a.s.a.a.d.w(a.f63868b, "12Y", "DefaultUrlProvider begin");
                dVar.a(0, "ok", str);
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface d {
        void a(int i2, String str, String str2);
    }

    /* loaded from: classes2.dex */
    public static class e implements b {

        /* renamed from: a  reason: collision with root package name */
        public static e f63878a;

        public e(Context context) {
            Context unused = a.f63868b = context.getApplicationContext();
        }

        public static synchronized e c(Context context) {
            e eVar;
            synchronized (e.class) {
                if (f63878a == null) {
                    f63878a = new e(context);
                }
                eVar = f63878a;
            }
            return eVar;
        }

        @Override // d.a.s.a.c.a.b
        public void a(String str, boolean z) {
        }

        @Override // d.a.s.a.c.a.b
        public void b(String str, d dVar) {
            d.a.s.a.g.d.a("DNSUrlProvider", "will getLCPHttpDnsAddress......");
            try {
                d.a.s.a.e.d dVar2 = new d.a.s.a.e.d(a.f63868b);
                dVar2.a(dVar);
                d.a.s.a.e.c.e(dVar2, dVar2);
            } catch (Exception unused) {
                a.g(true);
                a.d(a.f63868b).b(str, dVar);
            }
        }
    }

    public static int c() {
        return f63867a;
    }

    public static b d(Context context) {
        f63868b = context.getApplicationContext();
        int a2 = d.a.s.a.g.b.a(context);
        if (a2 != 1 && a2 != 2) {
            if (d.a.s.a.g.e.c(context) && f63867a == 2) {
                return C1736a.c(context);
            }
            if (f63867a == 3) {
                return e.c(context);
            }
            return c.c();
        }
        f63867a = 0;
        return c.c();
    }

    public static boolean e() {
        List<String> list = f63869c;
        return list != null && f63870d <= list.size();
    }

    public static boolean f(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        return str.matches("^(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|[1-9])\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$");
    }

    public static int g(boolean z) {
        if (z) {
            int a2 = d.a.s.a.g.b.a(f63868b);
            if (a2 != 1 && a2 != 2) {
                int i2 = f63867a;
                if (i2 == 0) {
                    f63867a = 2;
                } else if (i2 == 2) {
                    f63867a = 3;
                } else if (i2 == 3) {
                    f63867a = 0;
                }
            } else {
                f63867a = 0;
            }
        }
        d.a.s.a.g.d.a("DNSUrlProvider", "try to connect ip, now policy =" + f63867a);
        return f63867a;
    }

    public static void h(Context context, String str) {
        i(context, str, true);
    }

    public static void i(Context context, String str, boolean z) {
        j();
        c.c().a(str, true);
    }

    public static void j() {
        try {
            f63870d = 0;
            f63869c.clear();
            f63867a = 3;
        } catch (Exception e2) {
            d.a.s.a.g.d.c("DNSUrlProvider", "resetBdDns exception", e2);
        }
    }

    public static void k(List<String> list) {
        f63869c.clear();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (list != null && !list.isEmpty()) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                if (f(list.get(i2))) {
                    arrayList.add(list.get(i2));
                } else {
                    arrayList2.add(list.get(i2));
                }
            }
        }
        if (arrayList.size() + arrayList2.size() > 0) {
            int f2 = d.a.s.a.g.e.f(f63868b);
            d.a.s.a.g.d.b("DNSUrlProvider", "getIpPriority :" + f2 + ", ipv4 :" + arrayList.toString() + ", ipv6 :" + arrayList2.toString());
            if (f2 == 1) {
                f63869c.addAll(arrayList2);
            } else if (f2 == 2) {
                f63869c.addAll(arrayList2);
                f63869c.addAll(arrayList);
            } else if (f2 != 4) {
                f63869c.addAll(arrayList);
                f63869c.addAll(arrayList2);
            } else {
                f63869c.addAll(arrayList);
            }
        }
    }
}
