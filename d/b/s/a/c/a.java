package d.b.s.a.c;

import android.content.Context;
import com.baidu.searchbox.dns.DnsHelper;
import com.baidu.searchbox.dns.statistics.HttpDNSStat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static int f64586a = 3;

    /* renamed from: b  reason: collision with root package name */
    public static Context f64587b;

    /* renamed from: c  reason: collision with root package name */
    public static List<String> f64588c = Collections.synchronizedList(new ArrayList());

    /* renamed from: d  reason: collision with root package name */
    public static int f64589d = 0;

    /* renamed from: d.b.s.a.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C1766a implements b {

        /* renamed from: a  reason: collision with root package name */
        public static C1766a f64590a;

        /* renamed from: d.b.s.a.c.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class RunnableC1767a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f64591e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ Timer f64592f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ d f64593g;

            /* renamed from: d.b.s.a.c.a$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes2.dex */
            public class C1768a extends TimerTask {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ AtomicBoolean f64594e;

                public C1768a(AtomicBoolean atomicBoolean) {
                    this.f64594e = atomicBoolean;
                }

                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    d.b.s.a.g.d.a("DNSUrlProvider", "bddns > bdDnsIps is null");
                    d.b.s.a.a.d.w(a.f64587b, "11N_3", "BDDNS timeout");
                    d dVar = RunnableC1767a.this.f64593g;
                    if (dVar != null) {
                        dVar.a(8007, "bddns timeout :", "bddns timeout, bdDnsIps is null");
                        a.g(true);
                        b d2 = a.d(a.f64587b);
                        RunnableC1767a runnableC1767a = RunnableC1767a.this;
                        d2.b(runnableC1767a.f64591e, runnableC1767a.f64593g);
                    }
                    this.f64594e.set(true);
                }
            }

            public RunnableC1767a(C1766a c1766a, String str, Timer timer, d dVar) {
                this.f64591e = str;
                this.f64592f = timer;
                this.f64593g = dVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                d.b.s.a.g.d.a("DNSUrlProvider", "bddns > getUrlAsync in... host is " + this.f64591e);
                AtomicBoolean atomicBoolean = new AtomicBoolean(false);
                this.f64592f.schedule(new C1768a(atomicBoolean), 10000L);
                DnsHelper dnsHelper = new DnsHelper(a.f64587b);
                dnsHelper.setHttpDnsState(false, (HttpDNSStat) null, false, true);
                a.k(dnsHelper.getIpList(this.f64591e));
                d.b.s.a.a.d.w(a.f64587b, "11N_1", "BDDNS get ips");
                List<String> list = a.f64588c;
                if (list == null || list.size() <= 0) {
                    return;
                }
                d.b.s.a.g.d.a("DNSUrlProvider", "bddns > bdDnsIps = " + a.f64588c);
                String str = a.f64588c.get(0);
                d.b.s.a.a.d.w(a.f64587b, "11Y", "BDDNS success");
                if (this.f64593g != null && !atomicBoolean.get()) {
                    this.f64593g.a(0, "ok", str);
                    if (a.f64588c.size() > 1) {
                        a.f64589d++;
                        a.g(false);
                    }
                }
                d.b.s.a.g.d.a("DNSUrlProvider", "bddns > return ip = " + str);
                this.f64592f.cancel();
            }
        }

        public C1766a(Context context) {
            Context unused = a.f64587b = context.getApplicationContext();
            a.j();
        }

        public static synchronized C1766a c(Context context) {
            C1766a c1766a;
            synchronized (C1766a.class) {
                if (f64590a == null) {
                    f64590a = new C1766a(context);
                }
                c1766a = f64590a;
            }
            return c1766a;
        }

        @Override // d.b.s.a.c.a.b
        public void a(String str, boolean z) {
        }

        @Override // d.b.s.a.c.a.b
        public void b(String str, d dVar) {
            try {
                d.b.s.a.g.d.d("DNSUrlProvider", "BDHttpDNSUrlProvider try to getUrlAsync");
                if (a.f64588c == null || a.f64588c.size() <= 0) {
                    d.b.s.a.a.d.w(a.f64587b, "11N", "BDDNS begin");
                    d.b.s.a.f.a.a(a.f64587b).b(new RunnableC1767a(this, str, new Timer(), dVar));
                } else if (a.f64589d < a.f64588c.size()) {
                    d.b.s.a.a.d.w(a.f64587b, "11Y", "BDDNS retry success");
                    if (dVar != null) {
                        dVar.a(0, "ok", a.f64588c.get(a.f64589d));
                        d.b.s.a.g.d.a("DNSUrlProvider", "retry bddns > return ip = " + a.f64588c.get(a.f64589d));
                    }
                    a.f64589d++;
                } else {
                    a.g(true);
                    a.d(a.f64587b).b(str, dVar);
                }
            } catch (Throwable unused) {
                d.b.s.a.a.d.w(a.f64587b, "11N_2", "BDDNS exception, HTTPDNS begin");
                d.b.s.a.g.d.a("DNSUrlProvider", "bddns > bdDnsIps get exception ");
                a.g(true);
                a.d(a.f64587b).b(str, dVar);
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
        public static c f64596a;

        public static synchronized b c() {
            c cVar;
            synchronized (c.class) {
                if (f64596a == null) {
                    f64596a = new c();
                }
                cVar = f64596a;
            }
            return cVar;
        }

        @Override // d.b.s.a.c.a.b
        public void a(String str, boolean z) {
        }

        @Override // d.b.s.a.c.a.b
        public void b(String str, d dVar) {
            d.b.s.a.g.d.d("DNSUrlProvider", "DefaultUrlProvider try to getUrlAsync");
            d.b.s.a.a.d.w(a.f64587b, "12N", "DefaultUrlProvider begin");
            if (dVar != null) {
                a.j();
                d.b.s.a.a.d.w(a.f64587b, "12Y", "DefaultUrlProvider begin");
                dVar.a(0, "ok", str);
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface d {
        void a(int i, String str, String str2);
    }

    /* loaded from: classes2.dex */
    public static class e implements b {

        /* renamed from: a  reason: collision with root package name */
        public static e f64597a;

        public e(Context context) {
            Context unused = a.f64587b = context.getApplicationContext();
        }

        public static synchronized e c(Context context) {
            e eVar;
            synchronized (e.class) {
                if (f64597a == null) {
                    f64597a = new e(context);
                }
                eVar = f64597a;
            }
            return eVar;
        }

        @Override // d.b.s.a.c.a.b
        public void a(String str, boolean z) {
        }

        @Override // d.b.s.a.c.a.b
        public void b(String str, d dVar) {
            d.b.s.a.g.d.a("DNSUrlProvider", "will getLCPHttpDnsAddress......");
            try {
                d.b.s.a.e.d dVar2 = new d.b.s.a.e.d(a.f64587b);
                dVar2.a(dVar);
                d.b.s.a.e.c.e(dVar2, dVar2);
            } catch (Exception unused) {
                a.g(true);
                a.d(a.f64587b).b(str, dVar);
            }
        }
    }

    public static int c() {
        return f64586a;
    }

    public static b d(Context context) {
        f64587b = context.getApplicationContext();
        int a2 = d.b.s.a.g.b.a(context);
        if (a2 != 1 && a2 != 2) {
            if (d.b.s.a.g.e.c(context) && f64586a == 2) {
                return C1766a.c(context);
            }
            if (f64586a == 3) {
                return e.c(context);
            }
            return c.c();
        }
        f64586a = 0;
        return c.c();
    }

    public static boolean e() {
        List<String> list = f64588c;
        return list != null && f64589d <= list.size();
    }

    public static boolean f(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        return str.matches("^(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|[1-9])\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$");
    }

    public static int g(boolean z) {
        if (z) {
            int a2 = d.b.s.a.g.b.a(f64587b);
            if (a2 != 1 && a2 != 2) {
                int i = f64586a;
                if (i == 0) {
                    f64586a = 2;
                } else if (i == 2) {
                    f64586a = 3;
                } else if (i == 3) {
                    f64586a = 0;
                }
            } else {
                f64586a = 0;
            }
        }
        d.b.s.a.g.d.a("DNSUrlProvider", "try to connect ip, now policy =" + f64586a);
        return f64586a;
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
            f64589d = 0;
            f64588c.clear();
            f64586a = 3;
        } catch (Exception e2) {
            d.b.s.a.g.d.c("DNSUrlProvider", "resetBdDns exception", e2);
        }
    }

    public static void k(List<String> list) {
        f64588c.clear();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (list != null && !list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                if (f(list.get(i))) {
                    arrayList.add(list.get(i));
                } else {
                    arrayList2.add(list.get(i));
                }
            }
        }
        if (arrayList.size() + arrayList2.size() > 0) {
            int f2 = d.b.s.a.g.e.f(f64587b);
            d.b.s.a.g.d.b("DNSUrlProvider", "getIpPriority :" + f2 + ", ipv4 :" + arrayList.toString() + ", ipv6 :" + arrayList2.toString());
            if (f2 == 1) {
                f64588c.addAll(arrayList2);
            } else if (f2 == 2) {
                f64588c.addAll(arrayList2);
                f64588c.addAll(arrayList);
            } else if (f2 != 4) {
                f64588c.addAll(arrayList);
                f64588c.addAll(arrayList2);
            } else {
                f64588c.addAll(arrayList);
            }
        }
    }
}
