package d.b.r.a.c;

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
    public static int f65281a = 3;

    /* renamed from: b  reason: collision with root package name */
    public static Context f65282b;

    /* renamed from: c  reason: collision with root package name */
    public static List<String> f65283c = Collections.synchronizedList(new ArrayList());

    /* renamed from: d  reason: collision with root package name */
    public static int f65284d = 0;

    /* renamed from: d.b.r.a.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C1779a implements b {

        /* renamed from: a  reason: collision with root package name */
        public static C1779a f65285a;

        /* renamed from: d.b.r.a.c.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class RunnableC1780a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f65286e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ Timer f65287f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ d f65288g;

            /* renamed from: d.b.r.a.c.a$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes2.dex */
            public class C1781a extends TimerTask {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ AtomicBoolean f65289e;

                public C1781a(AtomicBoolean atomicBoolean) {
                    this.f65289e = atomicBoolean;
                }

                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    d.b.r.a.g.d.a("DNSUrlProvider", "bddns > bdDnsIps is null");
                    d.b.r.a.a.d.w(a.f65282b, "11N_3", "BDDNS timeout");
                    d dVar = RunnableC1780a.this.f65288g;
                    if (dVar != null) {
                        dVar.a(8007, "bddns timeout :", "bddns timeout, bdDnsIps is null");
                        a.g(true);
                        b d2 = a.d(a.f65282b);
                        RunnableC1780a runnableC1780a = RunnableC1780a.this;
                        d2.b(runnableC1780a.f65286e, runnableC1780a.f65288g);
                    }
                    this.f65289e.set(true);
                }
            }

            public RunnableC1780a(C1779a c1779a, String str, Timer timer, d dVar) {
                this.f65286e = str;
                this.f65287f = timer;
                this.f65288g = dVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                d.b.r.a.g.d.a("DNSUrlProvider", "bddns > getUrlAsync in... host is " + this.f65286e);
                AtomicBoolean atomicBoolean = new AtomicBoolean(false);
                this.f65287f.schedule(new C1781a(atomicBoolean), 10000L);
                DnsHelper dnsHelper = new DnsHelper(a.f65282b);
                dnsHelper.setHttpDnsState(false, (HttpDNSStat) null, false, true);
                a.k(dnsHelper.getIpList(this.f65286e));
                d.b.r.a.a.d.w(a.f65282b, "11N_1", "BDDNS get ips");
                List<String> list = a.f65283c;
                if (list == null || list.size() <= 0) {
                    return;
                }
                d.b.r.a.g.d.a("DNSUrlProvider", "bddns > bdDnsIps = " + a.f65283c);
                String str = a.f65283c.get(0);
                d.b.r.a.a.d.w(a.f65282b, "11Y", "BDDNS success");
                if (this.f65288g != null && !atomicBoolean.get()) {
                    this.f65288g.a(0, "ok", str);
                    if (a.f65283c.size() > 1) {
                        a.f65284d++;
                        a.g(false);
                    }
                }
                d.b.r.a.g.d.a("DNSUrlProvider", "bddns > return ip = " + str);
                this.f65287f.cancel();
            }
        }

        public C1779a(Context context) {
            Context unused = a.f65282b = context.getApplicationContext();
            a.j();
        }

        public static synchronized C1779a c(Context context) {
            C1779a c1779a;
            synchronized (C1779a.class) {
                if (f65285a == null) {
                    f65285a = new C1779a(context);
                }
                c1779a = f65285a;
            }
            return c1779a;
        }

        @Override // d.b.r.a.c.a.b
        public void a(String str, boolean z) {
        }

        @Override // d.b.r.a.c.a.b
        public void b(String str, d dVar) {
            try {
                d.b.r.a.g.d.d("DNSUrlProvider", "BDHttpDNSUrlProvider try to getUrlAsync");
                if (a.f65283c == null || a.f65283c.size() <= 0) {
                    d.b.r.a.a.d.w(a.f65282b, "11N", "BDDNS begin");
                    d.b.r.a.f.a.a(a.f65282b).b(new RunnableC1780a(this, str, new Timer(), dVar));
                } else if (a.f65284d < a.f65283c.size()) {
                    d.b.r.a.a.d.w(a.f65282b, "11Y", "BDDNS retry success");
                    if (dVar != null) {
                        dVar.a(0, "ok", a.f65283c.get(a.f65284d));
                        d.b.r.a.g.d.a("DNSUrlProvider", "retry bddns > return ip = " + a.f65283c.get(a.f65284d));
                    }
                    a.f65284d++;
                } else {
                    a.g(true);
                    a.d(a.f65282b).b(str, dVar);
                }
            } catch (Throwable unused) {
                d.b.r.a.a.d.w(a.f65282b, "11N_2", "BDDNS exception, HTTPDNS begin");
                d.b.r.a.g.d.a("DNSUrlProvider", "bddns > bdDnsIps get exception ");
                a.g(true);
                a.d(a.f65282b).b(str, dVar);
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
        public static c f65291a;

        public static synchronized b c() {
            c cVar;
            synchronized (c.class) {
                if (f65291a == null) {
                    f65291a = new c();
                }
                cVar = f65291a;
            }
            return cVar;
        }

        @Override // d.b.r.a.c.a.b
        public void a(String str, boolean z) {
        }

        @Override // d.b.r.a.c.a.b
        public void b(String str, d dVar) {
            d.b.r.a.g.d.d("DNSUrlProvider", "DefaultUrlProvider try to getUrlAsync");
            d.b.r.a.a.d.w(a.f65282b, "12N", "DefaultUrlProvider begin");
            if (dVar != null) {
                a.j();
                d.b.r.a.a.d.w(a.f65282b, "12Y", "DefaultUrlProvider begin");
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
        public static e f65292a;

        public e(Context context) {
            Context unused = a.f65282b = context.getApplicationContext();
        }

        public static synchronized e c(Context context) {
            e eVar;
            synchronized (e.class) {
                if (f65292a == null) {
                    f65292a = new e(context);
                }
                eVar = f65292a;
            }
            return eVar;
        }

        @Override // d.b.r.a.c.a.b
        public void a(String str, boolean z) {
        }

        @Override // d.b.r.a.c.a.b
        public void b(String str, d dVar) {
            d.b.r.a.g.d.a("DNSUrlProvider", "will getLCPHttpDnsAddress......");
            try {
                d.b.r.a.e.d dVar2 = new d.b.r.a.e.d(a.f65282b);
                dVar2.a(dVar);
                d.b.r.a.e.c.e(dVar2, dVar2);
            } catch (Exception unused) {
                a.g(true);
                a.d(a.f65282b).b(str, dVar);
            }
        }
    }

    public static int c() {
        return f65281a;
    }

    public static b d(Context context) {
        f65282b = context.getApplicationContext();
        int a2 = d.b.r.a.g.b.a(context);
        if (a2 != 1 && a2 != 2) {
            if (d.b.r.a.g.e.c(context) && f65281a == 2) {
                return C1779a.c(context);
            }
            if (f65281a == 3) {
                return e.c(context);
            }
            return c.c();
        }
        f65281a = 0;
        return c.c();
    }

    public static boolean e() {
        List<String> list = f65283c;
        return list != null && f65284d <= list.size();
    }

    public static boolean f(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        return str.matches("^(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|[1-9])\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$");
    }

    public static int g(boolean z) {
        if (z) {
            int a2 = d.b.r.a.g.b.a(f65282b);
            if (a2 != 1 && a2 != 2) {
                int i = f65281a;
                if (i == 0) {
                    f65281a = 2;
                } else if (i == 2) {
                    f65281a = 3;
                } else if (i == 3) {
                    f65281a = 0;
                }
            } else {
                f65281a = 0;
            }
        }
        d.b.r.a.g.d.a("DNSUrlProvider", "try to connect ip, now policy =" + f65281a);
        return f65281a;
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
            f65284d = 0;
            f65283c.clear();
            f65281a = 3;
        } catch (Exception e2) {
            d.b.r.a.g.d.c("DNSUrlProvider", "resetBdDns exception", e2);
        }
    }

    public static void k(List<String> list) {
        f65283c.clear();
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
            int f2 = d.b.r.a.g.e.f(f65282b);
            d.b.r.a.g.d.b("DNSUrlProvider", "getIpPriority :" + f2 + ", ipv4 :" + arrayList.toString() + ", ipv6 :" + arrayList2.toString());
            if (f2 == 1) {
                f65283c.addAll(arrayList2);
            } else if (f2 == 2) {
                f65283c.addAll(arrayList2);
                f65283c.addAll(arrayList);
            } else if (f2 != 4) {
                f65283c.addAll(arrayList);
                f65283c.addAll(arrayList2);
            } else {
                f65283c.addAll(arrayList);
            }
        }
    }
}
