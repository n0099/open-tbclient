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
    public static int f68352a = 3;

    /* renamed from: b  reason: collision with root package name */
    public static Context f68353b;

    /* renamed from: c  reason: collision with root package name */
    public static List<String> f68354c = Collections.synchronizedList(new ArrayList());

    /* renamed from: d  reason: collision with root package name */
    public static int f68355d = 0;

    /* renamed from: d.a.t.a.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C1867a implements b {

        /* renamed from: a  reason: collision with root package name */
        public static C1867a f68356a;

        /* renamed from: d.a.t.a.c.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class RunnableC1868a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f68357e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ Timer f68358f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ d f68359g;

            /* renamed from: d.a.t.a.c.a$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes2.dex */
            public class C1869a extends TimerTask {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ AtomicBoolean f68360e;

                public C1869a(AtomicBoolean atomicBoolean) {
                    this.f68360e = atomicBoolean;
                }

                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    d.a.t.a.h.e.a("DNSUrlProvider", "bddns > bdDnsIps is null");
                    d dVar = RunnableC1868a.this.f68359g;
                    if (dVar != null) {
                        dVar.a(8007, "bddns timeout :", "bddns timeout, bdDnsIps is null");
                        a.f(true);
                        b c2 = a.c(a.f68353b);
                        RunnableC1868a runnableC1868a = RunnableC1868a.this;
                        c2.b(runnableC1868a.f68357e, runnableC1868a.f68359g);
                    }
                    this.f68360e.set(true);
                }
            }

            public RunnableC1868a(C1867a c1867a, String str, Timer timer, d dVar) {
                this.f68357e = str;
                this.f68358f = timer;
                this.f68359g = dVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                d.a.t.a.h.e.a("DNSUrlProvider", "bddns > getUrlAsync in... host is " + this.f68357e);
                AtomicBoolean atomicBoolean = new AtomicBoolean(false);
                this.f68358f.schedule(new C1869a(atomicBoolean), 10000L);
                DnsHelper dnsHelper = new DnsHelper(a.f68353b);
                dnsHelper.setHttpDnsState(false, null, false, true);
                a.j(dnsHelper.getIpList(this.f68357e));
                List<String> list = a.f68354c;
                if (list == null || list.size() <= 0) {
                    return;
                }
                d.a.t.a.h.e.a("DNSUrlProvider", "bddns > bdDnsIps = " + a.f68354c);
                String str = a.f68354c.get(0);
                if (this.f68359g != null && !atomicBoolean.get()) {
                    this.f68359g.a(0, "ok", str);
                    if (a.f68354c.size() > 1) {
                        a.f68355d++;
                        a.f(false);
                    }
                }
                d.a.t.a.h.e.a("DNSUrlProvider", "bddns > return ip = " + str);
                this.f68358f.cancel();
            }
        }

        public C1867a(Context context) {
            Context unused = a.f68353b = context.getApplicationContext();
            a.i();
        }

        public static synchronized C1867a c(Context context) {
            C1867a c1867a;
            synchronized (C1867a.class) {
                if (f68356a == null) {
                    f68356a = new C1867a(context);
                }
                c1867a = f68356a;
            }
            return c1867a;
        }

        @Override // d.a.t.a.c.a.b
        public void a(String str, boolean z) {
        }

        @Override // d.a.t.a.c.a.b
        public void b(String str, d dVar) {
            try {
                d.a.t.a.h.e.d("DNSUrlProvider", "BDHttpDNSUrlProvider try to getUrlAsync");
                if (a.f68354c != null && a.f68354c.size() > 0) {
                    if (a.f68355d < a.f68354c.size()) {
                        if (dVar != null) {
                            dVar.a(0, "ok", a.f68354c.get(a.f68355d));
                            d.a.t.a.h.e.a("DNSUrlProvider", "retry bddns > return ip = " + a.f68354c.get(a.f68355d));
                        }
                        a.f68355d++;
                        return;
                    }
                    a.f(true);
                    a.c(a.f68353b).b(str, dVar);
                    return;
                }
                d.a.t.a.g.a.a(a.f68353b).b(new RunnableC1868a(this, str, new Timer(), dVar));
            } catch (Throwable unused) {
                d.a.t.a.h.e.a("DNSUrlProvider", "bddns > bdDnsIps get exception ");
                a.f(true);
                a.c(a.f68353b).b(str, dVar);
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
        public static c f68362a;

        public static synchronized b c() {
            c cVar;
            synchronized (c.class) {
                if (f68362a == null) {
                    f68362a = new c();
                }
                cVar = f68362a;
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
        public static e f68363a;

        public e(Context context) {
            Context unused = a.f68353b = context.getApplicationContext();
        }

        public static synchronized e c(Context context) {
            e eVar;
            synchronized (e.class) {
                if (f68363a == null) {
                    f68363a = new e(context);
                }
                eVar = f68363a;
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
                d.a.t.a.f.d dVar2 = new d.a.t.a.f.d(a.f68353b);
                dVar2.a(dVar);
                d.a.t.a.f.c.e(dVar2, dVar2);
            } catch (Exception unused) {
                a.f(true);
                a.c(a.f68353b).b(str, dVar);
            }
        }
    }

    public static b c(Context context) {
        f68353b = context.getApplicationContext();
        int a2 = d.a.t.a.h.c.a(context);
        if (a2 != 1 && a2 != 2) {
            if (d.a.t.a.h.f.c(context) && f68352a == 2) {
                return C1867a.c(context);
            }
            if (f68352a == 3) {
                return e.c(context);
            }
            return c.c();
        }
        f68352a = 0;
        return c.c();
    }

    public static boolean d() {
        List<String> list = f68354c;
        return list != null && f68355d <= list.size();
    }

    public static boolean e(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        return str.matches("^(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|[1-9])\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$");
    }

    public static int f(boolean z) {
        if (z) {
            int a2 = d.a.t.a.h.c.a(f68353b);
            if (a2 != 1 && a2 != 2) {
                int i2 = f68352a;
                if (i2 == 0) {
                    f68352a = 2;
                } else if (i2 == 2) {
                    f68352a = 3;
                } else if (i2 == 3) {
                    f68352a = 0;
                }
            } else {
                f68352a = 0;
            }
        }
        d.a.t.a.h.e.a("DNSUrlProvider", "try to connect ip, now policy =" + f68352a);
        return f68352a;
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
            f68355d = 0;
            f68354c.clear();
            f68352a = 3;
        } catch (Exception e2) {
            d.a.t.a.h.e.c("DNSUrlProvider", "resetBdDns exception", e2);
        }
    }

    public static void j(List<String> list) {
        f68354c.clear();
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
            int f2 = d.a.t.a.h.f.f(f68353b);
            d.a.t.a.h.e.b("DNSUrlProvider", "getIpPriority :" + f2 + ", ipv4 :" + arrayList.toString() + ", ipv6 :" + arrayList2.toString());
            if (f2 == 1) {
                f68354c.addAll(arrayList2);
            } else if (f2 == 2) {
                f68354c.addAll(arrayList2);
                f68354c.addAll(arrayList);
            } else if (f2 != 4) {
                f68354c.addAll(arrayList);
                f68354c.addAll(arrayList2);
            } else {
                f68354c.addAll(arrayList);
            }
        }
    }
}
