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
    public static int f64554a = 3;

    /* renamed from: b  reason: collision with root package name */
    public static Context f64555b;

    /* renamed from: c  reason: collision with root package name */
    public static List<String> f64556c = Collections.synchronizedList(new ArrayList());

    /* renamed from: d  reason: collision with root package name */
    public static int f64557d = 0;

    /* renamed from: d.a.s.a.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C1800a implements b {

        /* renamed from: a  reason: collision with root package name */
        public static C1800a f64558a;

        /* renamed from: d.a.s.a.c.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class RunnableC1801a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f64559e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ Timer f64560f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ d f64561g;

            /* renamed from: d.a.s.a.c.a$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes2.dex */
            public class C1802a extends TimerTask {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ AtomicBoolean f64562e;

                public C1802a(AtomicBoolean atomicBoolean) {
                    this.f64562e = atomicBoolean;
                }

                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    d.a.s.a.g.d.a("DNSUrlProvider", "bddns > bdDnsIps is null");
                    d.a.s.a.a.d.w(a.f64555b, "11N_3", "BDDNS timeout");
                    d dVar = RunnableC1801a.this.f64561g;
                    if (dVar != null) {
                        dVar.a(8007, "bddns timeout :", "bddns timeout, bdDnsIps is null");
                        a.g(true);
                        b d2 = a.d(a.f64555b);
                        RunnableC1801a runnableC1801a = RunnableC1801a.this;
                        d2.b(runnableC1801a.f64559e, runnableC1801a.f64561g);
                    }
                    this.f64562e.set(true);
                }
            }

            public RunnableC1801a(C1800a c1800a, String str, Timer timer, d dVar) {
                this.f64559e = str;
                this.f64560f = timer;
                this.f64561g = dVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                d.a.s.a.g.d.a("DNSUrlProvider", "bddns > getUrlAsync in... host is " + this.f64559e);
                AtomicBoolean atomicBoolean = new AtomicBoolean(false);
                this.f64560f.schedule(new C1802a(atomicBoolean), 10000L);
                DnsHelper dnsHelper = new DnsHelper(a.f64555b);
                dnsHelper.setHttpDnsState(false, null, false, true);
                a.k(dnsHelper.getIpList(this.f64559e));
                d.a.s.a.a.d.w(a.f64555b, "11N_1", "BDDNS get ips");
                List<String> list = a.f64556c;
                if (list == null || list.size() <= 0) {
                    return;
                }
                d.a.s.a.g.d.a("DNSUrlProvider", "bddns > bdDnsIps = " + a.f64556c);
                String str = a.f64556c.get(0);
                d.a.s.a.a.d.w(a.f64555b, "11Y", "BDDNS success");
                if (this.f64561g != null && !atomicBoolean.get()) {
                    this.f64561g.a(0, "ok", str);
                    if (a.f64556c.size() > 1) {
                        a.f64557d++;
                        a.g(false);
                    }
                }
                d.a.s.a.g.d.a("DNSUrlProvider", "bddns > return ip = " + str);
                this.f64560f.cancel();
            }
        }

        public C1800a(Context context) {
            Context unused = a.f64555b = context.getApplicationContext();
            a.j();
        }

        public static synchronized C1800a c(Context context) {
            C1800a c1800a;
            synchronized (C1800a.class) {
                if (f64558a == null) {
                    f64558a = new C1800a(context);
                }
                c1800a = f64558a;
            }
            return c1800a;
        }

        @Override // d.a.s.a.c.a.b
        public void a(String str, boolean z) {
        }

        @Override // d.a.s.a.c.a.b
        public void b(String str, d dVar) {
            try {
                d.a.s.a.g.d.d("DNSUrlProvider", "BDHttpDNSUrlProvider try to getUrlAsync");
                if (a.f64556c == null || a.f64556c.size() <= 0) {
                    d.a.s.a.a.d.w(a.f64555b, "11N", "BDDNS begin");
                    d.a.s.a.f.a.a(a.f64555b).b(new RunnableC1801a(this, str, new Timer(), dVar));
                } else if (a.f64557d < a.f64556c.size()) {
                    d.a.s.a.a.d.w(a.f64555b, "11Y", "BDDNS retry success");
                    if (dVar != null) {
                        dVar.a(0, "ok", a.f64556c.get(a.f64557d));
                        d.a.s.a.g.d.a("DNSUrlProvider", "retry bddns > return ip = " + a.f64556c.get(a.f64557d));
                    }
                    a.f64557d++;
                } else {
                    a.g(true);
                    a.d(a.f64555b).b(str, dVar);
                }
            } catch (Throwable unused) {
                d.a.s.a.a.d.w(a.f64555b, "11N_2", "BDDNS exception, HTTPDNS begin");
                d.a.s.a.g.d.a("DNSUrlProvider", "bddns > bdDnsIps get exception ");
                a.g(true);
                a.d(a.f64555b).b(str, dVar);
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
        public static c f64564a;

        public static synchronized b c() {
            c cVar;
            synchronized (c.class) {
                if (f64564a == null) {
                    f64564a = new c();
                }
                cVar = f64564a;
            }
            return cVar;
        }

        @Override // d.a.s.a.c.a.b
        public void a(String str, boolean z) {
        }

        @Override // d.a.s.a.c.a.b
        public void b(String str, d dVar) {
            d.a.s.a.g.d.d("DNSUrlProvider", "DefaultUrlProvider try to getUrlAsync");
            d.a.s.a.a.d.w(a.f64555b, "12N", "DefaultUrlProvider begin");
            if (dVar != null) {
                a.j();
                d.a.s.a.a.d.w(a.f64555b, "12Y", "DefaultUrlProvider begin");
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
        public static e f64565a;

        public e(Context context) {
            Context unused = a.f64555b = context.getApplicationContext();
        }

        public static synchronized e c(Context context) {
            e eVar;
            synchronized (e.class) {
                if (f64565a == null) {
                    f64565a = new e(context);
                }
                eVar = f64565a;
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
                d.a.s.a.e.d dVar2 = new d.a.s.a.e.d(a.f64555b);
                dVar2.a(dVar);
                d.a.s.a.e.c.e(dVar2, dVar2);
            } catch (Exception unused) {
                a.g(true);
                a.d(a.f64555b).b(str, dVar);
            }
        }
    }

    public static int c() {
        return f64554a;
    }

    public static b d(Context context) {
        f64555b = context.getApplicationContext();
        int a2 = d.a.s.a.g.b.a(context);
        if (a2 != 1 && a2 != 2) {
            if (d.a.s.a.g.e.c(context) && f64554a == 2) {
                return C1800a.c(context);
            }
            if (f64554a == 3) {
                return e.c(context);
            }
            return c.c();
        }
        f64554a = 0;
        return c.c();
    }

    public static boolean e() {
        List<String> list = f64556c;
        return list != null && f64557d <= list.size();
    }

    public static boolean f(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        return str.matches("^(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|[1-9])\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$");
    }

    public static int g(boolean z) {
        if (z) {
            int a2 = d.a.s.a.g.b.a(f64555b);
            if (a2 != 1 && a2 != 2) {
                int i2 = f64554a;
                if (i2 == 0) {
                    f64554a = 2;
                } else if (i2 == 2) {
                    f64554a = 3;
                } else if (i2 == 3) {
                    f64554a = 0;
                }
            } else {
                f64554a = 0;
            }
        }
        d.a.s.a.g.d.a("DNSUrlProvider", "try to connect ip, now policy =" + f64554a);
        return f64554a;
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
            f64557d = 0;
            f64556c.clear();
            f64554a = 3;
        } catch (Exception e2) {
            d.a.s.a.g.d.c("DNSUrlProvider", "resetBdDns exception", e2);
        }
    }

    public static void k(List<String> list) {
        f64556c.clear();
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
            int f2 = d.a.s.a.g.e.f(f64555b);
            d.a.s.a.g.d.b("DNSUrlProvider", "getIpPriority :" + f2 + ", ipv4 :" + arrayList.toString() + ", ipv6 :" + arrayList2.toString());
            if (f2 == 1) {
                f64556c.addAll(arrayList2);
            } else if (f2 == 2) {
                f64556c.addAll(arrayList2);
                f64556c.addAll(arrayList);
            } else if (f2 != 4) {
                f64556c.addAll(arrayList);
                f64556c.addAll(arrayList2);
            } else {
                f64556c.addAll(arrayList);
            }
        }
    }
}
