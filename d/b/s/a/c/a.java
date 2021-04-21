package d.b.s.a.c;

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
    public static int f65545a = 3;

    /* renamed from: b  reason: collision with root package name */
    public static Context f65546b;

    /* renamed from: c  reason: collision with root package name */
    public static List<String> f65547c = Collections.synchronizedList(new ArrayList());

    /* renamed from: d  reason: collision with root package name */
    public static int f65548d = 0;

    /* renamed from: d.b.s.a.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C1798a implements b {

        /* renamed from: a  reason: collision with root package name */
        public static C1798a f65549a;

        /* renamed from: d.b.s.a.c.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class RunnableC1799a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f65550e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ Timer f65551f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ d f65552g;

            /* renamed from: d.b.s.a.c.a$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes2.dex */
            public class C1800a extends TimerTask {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ AtomicBoolean f65553e;

                public C1800a(AtomicBoolean atomicBoolean) {
                    this.f65553e = atomicBoolean;
                }

                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    d.b.s.a.g.d.a("DNSUrlProvider", "bddns > bdDnsIps is null");
                    d.b.s.a.a.d.w(a.f65546b, "11N_3", "BDDNS timeout");
                    d dVar = RunnableC1799a.this.f65552g;
                    if (dVar != null) {
                        dVar.a(8007, "bddns timeout :", "bddns timeout, bdDnsIps is null");
                        a.g(true);
                        b d2 = a.d(a.f65546b);
                        RunnableC1799a runnableC1799a = RunnableC1799a.this;
                        d2.b(runnableC1799a.f65550e, runnableC1799a.f65552g);
                    }
                    this.f65553e.set(true);
                }
            }

            public RunnableC1799a(C1798a c1798a, String str, Timer timer, d dVar) {
                this.f65550e = str;
                this.f65551f = timer;
                this.f65552g = dVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                d.b.s.a.g.d.a("DNSUrlProvider", "bddns > getUrlAsync in... host is " + this.f65550e);
                AtomicBoolean atomicBoolean = new AtomicBoolean(false);
                this.f65551f.schedule(new C1800a(atomicBoolean), 10000L);
                DnsHelper dnsHelper = new DnsHelper(a.f65546b);
                dnsHelper.setHttpDnsState(false, null, false, true);
                a.k(dnsHelper.getIpList(this.f65550e));
                d.b.s.a.a.d.w(a.f65546b, "11N_1", "BDDNS get ips");
                List<String> list = a.f65547c;
                if (list == null || list.size() <= 0) {
                    return;
                }
                d.b.s.a.g.d.a("DNSUrlProvider", "bddns > bdDnsIps = " + a.f65547c);
                String str = a.f65547c.get(0);
                d.b.s.a.a.d.w(a.f65546b, "11Y", "BDDNS success");
                if (this.f65552g != null && !atomicBoolean.get()) {
                    this.f65552g.a(0, "ok", str);
                    if (a.f65547c.size() > 1) {
                        a.f65548d++;
                        a.g(false);
                    }
                }
                d.b.s.a.g.d.a("DNSUrlProvider", "bddns > return ip = " + str);
                this.f65551f.cancel();
            }
        }

        public C1798a(Context context) {
            Context unused = a.f65546b = context.getApplicationContext();
            a.j();
        }

        public static synchronized C1798a c(Context context) {
            C1798a c1798a;
            synchronized (C1798a.class) {
                if (f65549a == null) {
                    f65549a = new C1798a(context);
                }
                c1798a = f65549a;
            }
            return c1798a;
        }

        @Override // d.b.s.a.c.a.b
        public void a(String str, boolean z) {
        }

        @Override // d.b.s.a.c.a.b
        public void b(String str, d dVar) {
            try {
                d.b.s.a.g.d.d("DNSUrlProvider", "BDHttpDNSUrlProvider try to getUrlAsync");
                if (a.f65547c == null || a.f65547c.size() <= 0) {
                    d.b.s.a.a.d.w(a.f65546b, "11N", "BDDNS begin");
                    d.b.s.a.f.a.a(a.f65546b).b(new RunnableC1799a(this, str, new Timer(), dVar));
                } else if (a.f65548d < a.f65547c.size()) {
                    d.b.s.a.a.d.w(a.f65546b, "11Y", "BDDNS retry success");
                    if (dVar != null) {
                        dVar.a(0, "ok", a.f65547c.get(a.f65548d));
                        d.b.s.a.g.d.a("DNSUrlProvider", "retry bddns > return ip = " + a.f65547c.get(a.f65548d));
                    }
                    a.f65548d++;
                } else {
                    a.g(true);
                    a.d(a.f65546b).b(str, dVar);
                }
            } catch (Throwable unused) {
                d.b.s.a.a.d.w(a.f65546b, "11N_2", "BDDNS exception, HTTPDNS begin");
                d.b.s.a.g.d.a("DNSUrlProvider", "bddns > bdDnsIps get exception ");
                a.g(true);
                a.d(a.f65546b).b(str, dVar);
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
        public static c f65555a;

        public static synchronized b c() {
            c cVar;
            synchronized (c.class) {
                if (f65555a == null) {
                    f65555a = new c();
                }
                cVar = f65555a;
            }
            return cVar;
        }

        @Override // d.b.s.a.c.a.b
        public void a(String str, boolean z) {
        }

        @Override // d.b.s.a.c.a.b
        public void b(String str, d dVar) {
            d.b.s.a.g.d.d("DNSUrlProvider", "DefaultUrlProvider try to getUrlAsync");
            d.b.s.a.a.d.w(a.f65546b, "12N", "DefaultUrlProvider begin");
            if (dVar != null) {
                a.j();
                d.b.s.a.a.d.w(a.f65546b, "12Y", "DefaultUrlProvider begin");
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
        public static e f65556a;

        public e(Context context) {
            Context unused = a.f65546b = context.getApplicationContext();
        }

        public static synchronized e c(Context context) {
            e eVar;
            synchronized (e.class) {
                if (f65556a == null) {
                    f65556a = new e(context);
                }
                eVar = f65556a;
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
                d.b.s.a.e.d dVar2 = new d.b.s.a.e.d(a.f65546b);
                dVar2.a(dVar);
                d.b.s.a.e.c.e(dVar2, dVar2);
            } catch (Exception unused) {
                a.g(true);
                a.d(a.f65546b).b(str, dVar);
            }
        }
    }

    public static int c() {
        return f65545a;
    }

    public static b d(Context context) {
        f65546b = context.getApplicationContext();
        int a2 = d.b.s.a.g.b.a(context);
        if (a2 != 1 && a2 != 2) {
            if (d.b.s.a.g.e.c(context) && f65545a == 2) {
                return C1798a.c(context);
            }
            if (f65545a == 3) {
                return e.c(context);
            }
            return c.c();
        }
        f65545a = 0;
        return c.c();
    }

    public static boolean e() {
        List<String> list = f65547c;
        return list != null && f65548d <= list.size();
    }

    public static boolean f(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        return str.matches("^(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|[1-9])\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$");
    }

    public static int g(boolean z) {
        if (z) {
            int a2 = d.b.s.a.g.b.a(f65546b);
            if (a2 != 1 && a2 != 2) {
                int i = f65545a;
                if (i == 0) {
                    f65545a = 2;
                } else if (i == 2) {
                    f65545a = 3;
                } else if (i == 3) {
                    f65545a = 0;
                }
            } else {
                f65545a = 0;
            }
        }
        d.b.s.a.g.d.a("DNSUrlProvider", "try to connect ip, now policy =" + f65545a);
        return f65545a;
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
            f65548d = 0;
            f65547c.clear();
            f65545a = 3;
        } catch (Exception e2) {
            d.b.s.a.g.d.c("DNSUrlProvider", "resetBdDns exception", e2);
        }
    }

    public static void k(List<String> list) {
        f65547c.clear();
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
            int f2 = d.b.s.a.g.e.f(f65546b);
            d.b.s.a.g.d.b("DNSUrlProvider", "getIpPriority :" + f2 + ", ipv4 :" + arrayList.toString() + ", ipv6 :" + arrayList2.toString());
            if (f2 == 1) {
                f65547c.addAll(arrayList2);
            } else if (f2 == 2) {
                f65547c.addAll(arrayList2);
                f65547c.addAll(arrayList);
            } else if (f2 != 4) {
                f65547c.addAll(arrayList);
                f65547c.addAll(arrayList2);
            } else {
                f65547c.addAll(arrayList);
            }
        }
    }
}
