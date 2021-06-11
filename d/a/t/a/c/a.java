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
    public static int f68270a = 3;

    /* renamed from: b  reason: collision with root package name */
    public static Context f68271b;

    /* renamed from: c  reason: collision with root package name */
    public static List<String> f68272c = Collections.synchronizedList(new ArrayList());

    /* renamed from: d  reason: collision with root package name */
    public static int f68273d = 0;

    /* renamed from: d.a.t.a.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C1864a implements b {

        /* renamed from: a  reason: collision with root package name */
        public static C1864a f68274a;

        /* renamed from: d.a.t.a.c.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class RunnableC1865a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f68275e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ Timer f68276f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ d f68277g;

            /* renamed from: d.a.t.a.c.a$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes2.dex */
            public class C1866a extends TimerTask {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ AtomicBoolean f68278e;

                public C1866a(AtomicBoolean atomicBoolean) {
                    this.f68278e = atomicBoolean;
                }

                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    d.a.t.a.h.e.a("DNSUrlProvider", "bddns > bdDnsIps is null");
                    d dVar = RunnableC1865a.this.f68277g;
                    if (dVar != null) {
                        dVar.a(8007, "bddns timeout :", "bddns timeout, bdDnsIps is null");
                        a.f(true);
                        b c2 = a.c(a.f68271b);
                        RunnableC1865a runnableC1865a = RunnableC1865a.this;
                        c2.b(runnableC1865a.f68275e, runnableC1865a.f68277g);
                    }
                    this.f68278e.set(true);
                }
            }

            public RunnableC1865a(C1864a c1864a, String str, Timer timer, d dVar) {
                this.f68275e = str;
                this.f68276f = timer;
                this.f68277g = dVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                d.a.t.a.h.e.a("DNSUrlProvider", "bddns > getUrlAsync in... host is " + this.f68275e);
                AtomicBoolean atomicBoolean = new AtomicBoolean(false);
                this.f68276f.schedule(new C1866a(atomicBoolean), 10000L);
                DnsHelper dnsHelper = new DnsHelper(a.f68271b);
                dnsHelper.setHttpDnsState(false, null, false, true);
                a.j(dnsHelper.getIpList(this.f68275e));
                List<String> list = a.f68272c;
                if (list == null || list.size() <= 0) {
                    return;
                }
                d.a.t.a.h.e.a("DNSUrlProvider", "bddns > bdDnsIps = " + a.f68272c);
                String str = a.f68272c.get(0);
                if (this.f68277g != null && !atomicBoolean.get()) {
                    this.f68277g.a(0, "ok", str);
                    if (a.f68272c.size() > 1) {
                        a.f68273d++;
                        a.f(false);
                    }
                }
                d.a.t.a.h.e.a("DNSUrlProvider", "bddns > return ip = " + str);
                this.f68276f.cancel();
            }
        }

        public C1864a(Context context) {
            Context unused = a.f68271b = context.getApplicationContext();
            a.i();
        }

        public static synchronized C1864a c(Context context) {
            C1864a c1864a;
            synchronized (C1864a.class) {
                if (f68274a == null) {
                    f68274a = new C1864a(context);
                }
                c1864a = f68274a;
            }
            return c1864a;
        }

        @Override // d.a.t.a.c.a.b
        public void a(String str, boolean z) {
        }

        @Override // d.a.t.a.c.a.b
        public void b(String str, d dVar) {
            try {
                d.a.t.a.h.e.d("DNSUrlProvider", "BDHttpDNSUrlProvider try to getUrlAsync");
                if (a.f68272c != null && a.f68272c.size() > 0) {
                    if (a.f68273d < a.f68272c.size()) {
                        if (dVar != null) {
                            dVar.a(0, "ok", a.f68272c.get(a.f68273d));
                            d.a.t.a.h.e.a("DNSUrlProvider", "retry bddns > return ip = " + a.f68272c.get(a.f68273d));
                        }
                        a.f68273d++;
                        return;
                    }
                    a.f(true);
                    a.c(a.f68271b).b(str, dVar);
                    return;
                }
                d.a.t.a.g.a.a(a.f68271b).b(new RunnableC1865a(this, str, new Timer(), dVar));
            } catch (Throwable unused) {
                d.a.t.a.h.e.a("DNSUrlProvider", "bddns > bdDnsIps get exception ");
                a.f(true);
                a.c(a.f68271b).b(str, dVar);
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
        public static c f68280a;

        public static synchronized b c() {
            c cVar;
            synchronized (c.class) {
                if (f68280a == null) {
                    f68280a = new c();
                }
                cVar = f68280a;
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
        public static e f68281a;

        public e(Context context) {
            Context unused = a.f68271b = context.getApplicationContext();
        }

        public static synchronized e c(Context context) {
            e eVar;
            synchronized (e.class) {
                if (f68281a == null) {
                    f68281a = new e(context);
                }
                eVar = f68281a;
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
                d.a.t.a.f.d dVar2 = new d.a.t.a.f.d(a.f68271b);
                dVar2.a(dVar);
                d.a.t.a.f.c.e(dVar2, dVar2);
            } catch (Exception unused) {
                a.f(true);
                a.c(a.f68271b).b(str, dVar);
            }
        }
    }

    public static b c(Context context) {
        f68271b = context.getApplicationContext();
        int a2 = d.a.t.a.h.c.a(context);
        if (a2 != 1 && a2 != 2) {
            if (d.a.t.a.h.f.c(context) && f68270a == 2) {
                return C1864a.c(context);
            }
            if (f68270a == 3) {
                return e.c(context);
            }
            return c.c();
        }
        f68270a = 0;
        return c.c();
    }

    public static boolean d() {
        List<String> list = f68272c;
        return list != null && f68273d <= list.size();
    }

    public static boolean e(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        return str.matches("^(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|[1-9])\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$");
    }

    public static int f(boolean z) {
        if (z) {
            int a2 = d.a.t.a.h.c.a(f68271b);
            if (a2 != 1 && a2 != 2) {
                int i2 = f68270a;
                if (i2 == 0) {
                    f68270a = 2;
                } else if (i2 == 2) {
                    f68270a = 3;
                } else if (i2 == 3) {
                    f68270a = 0;
                }
            } else {
                f68270a = 0;
            }
        }
        d.a.t.a.h.e.a("DNSUrlProvider", "try to connect ip, now policy =" + f68270a);
        return f68270a;
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
            f68273d = 0;
            f68272c.clear();
            f68270a = 3;
        } catch (Exception e2) {
            d.a.t.a.h.e.c("DNSUrlProvider", "resetBdDns exception", e2);
        }
    }

    public static void j(List<String> list) {
        f68272c.clear();
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
            int f2 = d.a.t.a.h.f.f(f68271b);
            d.a.t.a.h.e.b("DNSUrlProvider", "getIpPriority :" + f2 + ", ipv4 :" + arrayList.toString() + ", ipv6 :" + arrayList2.toString());
            if (f2 == 1) {
                f68272c.addAll(arrayList2);
            } else if (f2 == 2) {
                f68272c.addAll(arrayList2);
                f68272c.addAll(arrayList);
            } else if (f2 != 4) {
                f68272c.addAll(arrayList);
                f68272c.addAll(arrayList2);
            } else {
                f68272c.addAll(arrayList);
            }
        }
    }
}
