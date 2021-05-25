package d.a.t.a.c;

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
    public static int f64552a = 3;

    /* renamed from: b  reason: collision with root package name */
    public static Context f64553b;

    /* renamed from: c  reason: collision with root package name */
    public static List<String> f64554c = Collections.synchronizedList(new ArrayList());

    /* renamed from: d  reason: collision with root package name */
    public static int f64555d = 0;

    /* renamed from: d.a.t.a.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C1806a implements b {

        /* renamed from: a  reason: collision with root package name */
        public static C1806a f64556a;

        /* renamed from: d.a.t.a.c.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class RunnableC1807a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f64557e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ Timer f64558f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ d f64559g;

            /* renamed from: d.a.t.a.c.a$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes2.dex */
            public class C1808a extends TimerTask {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ AtomicBoolean f64560e;

                public C1808a(AtomicBoolean atomicBoolean) {
                    this.f64560e = atomicBoolean;
                }

                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    d.a.t.a.h.e.a("DNSUrlProvider", "bddns > bdDnsIps is null");
                    d dVar = RunnableC1807a.this.f64559g;
                    if (dVar != null) {
                        dVar.a(8007, "bddns timeout :", "bddns timeout, bdDnsIps is null");
                        a.f(true);
                        b c2 = a.c(a.f64553b);
                        RunnableC1807a runnableC1807a = RunnableC1807a.this;
                        c2.b(runnableC1807a.f64557e, runnableC1807a.f64559g);
                    }
                    this.f64560e.set(true);
                }
            }

            public RunnableC1807a(C1806a c1806a, String str, Timer timer, d dVar) {
                this.f64557e = str;
                this.f64558f = timer;
                this.f64559g = dVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                d.a.t.a.h.e.a("DNSUrlProvider", "bddns > getUrlAsync in... host is " + this.f64557e);
                AtomicBoolean atomicBoolean = new AtomicBoolean(false);
                this.f64558f.schedule(new C1808a(atomicBoolean), 10000L);
                DnsHelper dnsHelper = new DnsHelper(a.f64553b);
                dnsHelper.setHttpDnsState(false, null, false, true);
                a.j(dnsHelper.getIpList(this.f64557e));
                List<String> list = a.f64554c;
                if (list == null || list.size() <= 0) {
                    return;
                }
                d.a.t.a.h.e.a("DNSUrlProvider", "bddns > bdDnsIps = " + a.f64554c);
                String str = a.f64554c.get(0);
                if (this.f64559g != null && !atomicBoolean.get()) {
                    this.f64559g.a(0, "ok", str);
                    if (a.f64554c.size() > 1) {
                        a.f64555d++;
                        a.f(false);
                    }
                }
                d.a.t.a.h.e.a("DNSUrlProvider", "bddns > return ip = " + str);
                this.f64558f.cancel();
            }
        }

        public C1806a(Context context) {
            Context unused = a.f64553b = context.getApplicationContext();
            a.i();
        }

        public static synchronized C1806a c(Context context) {
            C1806a c1806a;
            synchronized (C1806a.class) {
                if (f64556a == null) {
                    f64556a = new C1806a(context);
                }
                c1806a = f64556a;
            }
            return c1806a;
        }

        @Override // d.a.t.a.c.a.b
        public void a(String str, boolean z) {
        }

        @Override // d.a.t.a.c.a.b
        public void b(String str, d dVar) {
            try {
                d.a.t.a.h.e.d("DNSUrlProvider", "BDHttpDNSUrlProvider try to getUrlAsync");
                if (a.f64554c != null && a.f64554c.size() > 0) {
                    if (a.f64555d < a.f64554c.size()) {
                        if (dVar != null) {
                            dVar.a(0, "ok", a.f64554c.get(a.f64555d));
                            d.a.t.a.h.e.a("DNSUrlProvider", "retry bddns > return ip = " + a.f64554c.get(a.f64555d));
                        }
                        a.f64555d++;
                        return;
                    }
                    a.f(true);
                    a.c(a.f64553b).b(str, dVar);
                    return;
                }
                d.a.t.a.g.a.a(a.f64553b).b(new RunnableC1807a(this, str, new Timer(), dVar));
            } catch (Throwable unused) {
                d.a.t.a.h.e.a("DNSUrlProvider", "bddns > bdDnsIps get exception ");
                a.f(true);
                a.c(a.f64553b).b(str, dVar);
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
        public static c f64562a;

        public static synchronized b c() {
            c cVar;
            synchronized (c.class) {
                if (f64562a == null) {
                    f64562a = new c();
                }
                cVar = f64562a;
            }
            return cVar;
        }

        @Override // d.a.t.a.c.a.b
        public void a(String str, boolean z) {
        }

        @Override // d.a.t.a.c.a.b
        public void b(String str, d dVar) {
            d.a.t.a.h.e.d("DNSUrlProvider", "DefaultUrlProvider try to getUrlAsync");
            if (dVar != null) {
                a.i();
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
        public static e f64563a;

        public e(Context context) {
            Context unused = a.f64553b = context.getApplicationContext();
        }

        public static synchronized e c(Context context) {
            e eVar;
            synchronized (e.class) {
                if (f64563a == null) {
                    f64563a = new e(context);
                }
                eVar = f64563a;
            }
            return eVar;
        }

        @Override // d.a.t.a.c.a.b
        public void a(String str, boolean z) {
        }

        @Override // d.a.t.a.c.a.b
        public void b(String str, d dVar) {
            d.a.t.a.h.e.a("DNSUrlProvider", "will getLCPHttpDnsAddress......");
            try {
                d.a.t.a.f.d dVar2 = new d.a.t.a.f.d(a.f64553b);
                dVar2.a(dVar);
                d.a.t.a.f.c.e(dVar2, dVar2);
            } catch (Exception unused) {
                a.f(true);
                a.c(a.f64553b).b(str, dVar);
            }
        }
    }

    public static b c(Context context) {
        f64553b = context.getApplicationContext();
        int a2 = d.a.t.a.h.c.a(context);
        if (a2 != 1 && a2 != 2) {
            if (d.a.t.a.h.f.c(context) && f64552a == 2) {
                return C1806a.c(context);
            }
            if (f64552a == 3) {
                return e.c(context);
            }
            return c.c();
        }
        f64552a = 0;
        return c.c();
    }

    public static boolean d() {
        List<String> list = f64554c;
        return list != null && f64555d <= list.size();
    }

    public static boolean e(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        return str.matches("^(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|[1-9])\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$");
    }

    public static int f(boolean z) {
        if (z) {
            int a2 = d.a.t.a.h.c.a(f64553b);
            if (a2 != 1 && a2 != 2) {
                int i2 = f64552a;
                if (i2 == 0) {
                    f64552a = 2;
                } else if (i2 == 2) {
                    f64552a = 3;
                } else if (i2 == 3) {
                    f64552a = 0;
                }
            } else {
                f64552a = 0;
            }
        }
        d.a.t.a.h.e.a("DNSUrlProvider", "try to connect ip, now policy =" + f64552a);
        return f64552a;
    }

    public static void g(Context context, String str) {
        h(context, str, true);
    }

    public static void h(Context context, String str, boolean z) {
        i();
        c.c().a(str, true);
    }

    public static void i() {
        try {
            f64555d = 0;
            f64554c.clear();
            f64552a = 3;
        } catch (Exception e2) {
            d.a.t.a.h.e.c("DNSUrlProvider", "resetBdDns exception", e2);
        }
    }

    public static void j(List<String> list) {
        f64554c.clear();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (list != null && !list.isEmpty()) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                if (e(list.get(i2))) {
                    arrayList.add(list.get(i2));
                } else {
                    arrayList2.add(list.get(i2));
                }
            }
        }
        if (arrayList.size() + arrayList2.size() > 0) {
            int f2 = d.a.t.a.h.f.f(f64553b);
            d.a.t.a.h.e.b("DNSUrlProvider", "getIpPriority :" + f2 + ", ipv4 :" + arrayList.toString() + ", ipv6 :" + arrayList2.toString());
            if (f2 == 1) {
                f64554c.addAll(arrayList2);
            } else if (f2 == 2) {
                f64554c.addAll(arrayList2);
                f64554c.addAll(arrayList);
            } else if (f2 != 4) {
                f64554c.addAll(arrayList);
                f64554c.addAll(arrayList2);
            } else {
                f64554c.addAll(arrayList);
            }
        }
    }
}
