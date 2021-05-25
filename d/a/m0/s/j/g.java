package d.a.m0.s.j;

import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.bdhttpdns.BDHttpDns;
import com.baidu.bdhttpdns.BDHttpDnsResult;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.switchs.UseHttpdnsSdkSwitch;
import d.a.c.e.p.j;
import d.a.c.e.r.k;
import d.a.m0.s.j.a;
import d.a.m0.s.j.d;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public class g {
    public static g l;

    /* renamed from: a  reason: collision with root package name */
    public int f50745a;

    /* renamed from: b  reason: collision with root package name */
    public int f50746b = 0;

    /* renamed from: c  reason: collision with root package name */
    public boolean f50747c = false;

    /* renamed from: d  reason: collision with root package name */
    public boolean f50748d = false;

    /* renamed from: e  reason: collision with root package name */
    public List<String> f50749e = null;

    /* renamed from: f  reason: collision with root package name */
    public boolean f50750f = false;

    /* renamed from: g  reason: collision with root package name */
    public final Object f50751g = new Object();

    /* renamed from: h  reason: collision with root package name */
    public List<String> f50752h = new ArrayList();

    /* renamed from: i  reason: collision with root package name */
    public boolean f50753i = false;
    public BDHttpDnsResult j = null;
    public final d.a.c.e.r.g k = new a();

    /* loaded from: classes3.dex */
    public class a implements d.a.c.e.r.g {
        public a() {
        }

        @Override // d.a.c.e.r.g
        public void a(String str) {
        }

        @Override // d.a.c.e.r.g
        public void b(int i2, String str) {
            if ((i2 == 2 || i2 == 9) && j.z()) {
                g.d(g.this);
                if (UseHttpdnsSdkSwitch.isOn()) {
                    if (g.this.f50752h == null || g.this.f50752h.isEmpty()) {
                        g.this.w();
                    } else {
                        g.this.a();
                    }
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("retryiplist_");
                    stringBuffer.append(d.a.c.c.e.c.h.d());
                    if (g.this.j != null) {
                        stringBuffer.append("-dnsResolveIp_");
                        stringBuffer.append(g.this.j.a());
                        stringBuffer.append("-dnsResolveType_");
                        stringBuffer.append(g.this.j.d());
                        stringBuffer.append("-dnsResolveStatus_");
                        stringBuffer.append(g.this.j.c());
                    }
                    d.a.c.c.e.c.i.a("RetryIpListManager", 0, 0, "retry_iplist", 0, stringBuffer.toString());
                    if (g.this.f50745a >= 5) {
                        BdSocketLinkService.setAvailable(false);
                        g.this.B();
                    }
                } else if (g.this.f50745a >= 5) {
                    d.a.c.c.e.c.i.a("RetryIpListManager", 0, 0, "retry_iplist", 0, "retryiplist_" + d.a.c.c.e.c.h.d());
                    g.this.C();
                }
            }
        }

        @Override // d.a.c.e.r.g
        public void c(d.a.c.e.r.c cVar) {
        }

        @Override // d.a.c.e.r.g
        public void d(byte[] bArr) {
        }

        @Override // d.a.c.e.r.g
        public void e() {
        }

        @Override // d.a.c.e.r.g
        public void f(k kVar) {
        }

        @Override // d.a.c.e.r.g
        public void g(int i2, d.a.c.e.r.c cVar) {
        }

        @Override // d.a.c.e.r.g
        public void h(d.a.c.e.r.c cVar) {
        }

        @Override // d.a.c.e.r.g
        public void i(d.a.c.e.r.c cVar) {
        }

        @Override // d.a.c.e.r.g
        public void onOpen(Map<String, String> map) {
            if (UseHttpdnsSdkSwitch.isOn()) {
                if (g.this.f50745a > 0) {
                    g.this.f50753i = false;
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("URL_");
                    stringBuffer.append(d.a.c.c.e.c.h.d());
                    if (g.this.j != null) {
                        stringBuffer.append("-dnsResolveIp_");
                        stringBuffer.append(g.this.j.a());
                        stringBuffer.append("-dnsResolveType_");
                        stringBuffer.append(g.this.j.d());
                        stringBuffer.append("-dnsResolveStatus_");
                        stringBuffer.append(g.this.j.c());
                    }
                    d.a.c.c.e.c.i.a("RetryIpListManager", 0, 0, "retry_iplist_succ", 0, stringBuffer.toString());
                }
            } else if (g.this.f50745a >= 5) {
                d.a.c.c.e.c.i.a("RetryIpListManager", 0, 0, "retry_iplist_succ", 0, "URL-" + d.a.c.c.e.c.h.d());
                d.a.m0.s.j.a.f().l(d.a.c.c.e.c.h.d());
                d.a.m0.s.j.a.f().k();
            }
            g.this.f50745a = 0;
        }
    }

    /* loaded from: classes3.dex */
    public class b implements BDHttpDns.a {
        public b() {
        }

        @Override // com.baidu.bdhttpdns.BDHttpDns.a
        public void a(BDHttpDnsResult bDHttpDnsResult) {
            ArrayList<String> a2;
            g.this.f50753i = false;
            g.this.j = bDHttpDnsResult;
            if (bDHttpDnsResult == null || (a2 = bDHttpDnsResult.a()) == null || a2.isEmpty()) {
                return;
            }
            synchronized (g.this.f50751g) {
                g.this.f50752h = a2;
            }
            g.this.a();
        }
    }

    /* loaded from: classes3.dex */
    public class c implements a.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f50756a;

        public c(String str) {
            this.f50756a = str;
        }

        @Override // d.a.m0.s.j.a.b
        public void a() {
            g.this.f50746b = 0;
            g.this.f50749e = d.a.m0.s.j.a.f().g();
            if (g.this.f50749e != null) {
                g.this.A(this.f50756a);
            } else {
                g.this.f50750f = false;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements d.c {

        /* loaded from: classes3.dex */
        public class a implements a.b {
            public a() {
            }

            @Override // d.a.m0.s.j.a.b
            public void a() {
                g.this.f50746b = 0;
                g.this.f50749e = d.a.m0.s.j.a.f().g();
                if (g.this.f50749e != null) {
                    g.this.A("change ip to reconnect with DNS' failed.");
                } else {
                    g.this.f50750f = false;
                }
            }
        }

        public d() {
        }

        @Override // d.a.m0.s.j.d.c
        public void a(boolean z) {
            d.a.m0.s.j.b.e().a(z ? 2 : 1);
            if (z) {
                g.this.f50749e = d.a.m0.s.j.a.f().g();
                if (g.this.f50749e != null) {
                    g.this.A("change ip to reconnect with DNS' failed.");
                    return;
                } else {
                    d.a.m0.s.j.a.f().m(new a());
                    return;
                }
            }
            g.this.f50750f = false;
            g.this.D();
        }
    }

    public static /* synthetic */ int d(g gVar) {
        int i2 = gVar.f50745a;
        gVar.f50745a = i2 + 1;
        return i2;
    }

    public static String u(String str) {
        int lastIndexOf;
        if (str != null && (lastIndexOf = str.lastIndexOf(":")) >= 5) {
            try {
                return str.substring(5, lastIndexOf);
            } catch (Exception unused) {
                return null;
            }
        }
        return null;
    }

    public static String v(String str) {
        int lastIndexOf;
        if (str != null && (lastIndexOf = str.lastIndexOf(":")) >= 5) {
            try {
                return str.substring(lastIndexOf + 1);
            } catch (Exception unused) {
                return null;
            }
        }
        return null;
    }

    public static synchronized g y() {
        g gVar;
        synchronized (g.class) {
            if (l == null) {
                synchronized (g.class) {
                    if (l == null) {
                        l = new g();
                    }
                }
            }
            gVar = l;
        }
        return gVar;
    }

    public final void A(String str) {
        String x = x();
        if (x == null) {
            if (!d.a.m0.s.j.a.f().i()) {
                d.a.m0.s.j.a.f().m(new c(str));
            }
            d.a.c.c.e.c.h.h(TiebaIMConfig.url);
            BdSocketLinkService.setAvailable(false);
            D();
        } else if (u(x) == null) {
            D();
        } else {
            this.f50750f = false;
            BdSocketLinkService.stopReConnStrategy("change ip and stop to restart to reconnet.");
            d.a.c.c.e.c.h.h(x);
            BdSocketLinkService.init();
            BdSocketLinkService.startService(true, str);
            this.f50747c = true;
            this.f50746b++;
        }
    }

    public final void B() {
        NoNetworkView.f();
        this.f50746b = 0;
        this.f50753i = false;
    }

    public final void C() {
        if (this.f50750f) {
            return;
        }
        this.f50750f = true;
        if (this.f50747c) {
            this.f50747c = false;
            d.a.m0.s.j.b.e().d(TiebaIMConfig.url);
        }
        d.a.m0.s.j.b.e().b();
        if (!this.f50748d) {
            new d.a.m0.s.j.d("www.baidu.com", new d());
            this.f50748d = true;
            return;
        }
        A("change ip to reconnect with DNS' failed.");
    }

    public final void D() {
        NoNetworkView.f();
        this.f50748d = false;
        this.f50746b = 0;
        this.f50750f = false;
        this.f50747c = false;
    }

    public final void a() {
        synchronized (this.f50751g) {
            if (this.f50752h != null && !this.f50752h.isEmpty()) {
                String remove = this.f50752h.remove(0);
                if (!TextUtils.isEmpty(remove)) {
                    d.a.c.c.e.c.h.h("ws://" + remove + ":" + v(TiebaIMConfig.url));
                    BdSocketLinkService.init();
                }
            }
        }
    }

    public final void w() {
        if (this.f50753i) {
            return;
        }
        try {
            String u = u(TiebaIMConfig.url);
            if (d.a.c.e.p.k.isEmpty(u)) {
                B();
                return;
            }
            this.f50753i = true;
            BDHttpDns.j(BdBaseApplication.getInst().getApplicationContext()).c(u, new b());
        } catch (Exception e2) {
            BdLog.e(e2);
        }
    }

    public final String x() {
        int i2;
        List<String> list = this.f50749e;
        if (list == null || (i2 = this.f50746b) <= -1 || i2 >= list.size()) {
            return null;
        }
        return d.a.m0.s.j.a.f().g().get(this.f50746b);
    }

    public void z() {
        d.a.c.e.r.h.j().c(this.k);
    }
}
