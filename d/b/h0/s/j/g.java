package d.b.h0.s.j;

import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.bdhttpdns.BDHttpDns;
import com.baidu.bdhttpdns.BDHttpDnsResult;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.switchs.UseHttpdnsSdkSwitch;
import d.b.b.e.p.j;
import d.b.b.e.r.k;
import d.b.h0.s.j.a;
import d.b.h0.s.j.d;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public class g {
    public static g l;

    /* renamed from: a  reason: collision with root package name */
    public int f51434a;

    /* renamed from: b  reason: collision with root package name */
    public int f51435b = 0;

    /* renamed from: c  reason: collision with root package name */
    public boolean f51436c = false;

    /* renamed from: d  reason: collision with root package name */
    public boolean f51437d = false;

    /* renamed from: e  reason: collision with root package name */
    public List<String> f51438e = null;

    /* renamed from: f  reason: collision with root package name */
    public boolean f51439f = false;

    /* renamed from: g  reason: collision with root package name */
    public final Object f51440g = new Object();

    /* renamed from: h  reason: collision with root package name */
    public List<String> f51441h = new ArrayList();
    public boolean i = false;
    public BDHttpDnsResult j = null;
    public final d.b.b.e.r.g k = new a();

    /* loaded from: classes3.dex */
    public class a implements d.b.b.e.r.g {
        public a() {
        }

        @Override // d.b.b.e.r.g
        public void a(int i, String str) {
            if ((i == 2 || i == 9) && j.z()) {
                g.d(g.this);
                if (UseHttpdnsSdkSwitch.isOn()) {
                    if (g.this.f51441h == null || g.this.f51441h.isEmpty()) {
                        g.this.w();
                    } else {
                        g.this.a();
                    }
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("retryiplist_");
                    stringBuffer.append(d.b.b.c.e.c.h.d());
                    if (g.this.j != null) {
                        stringBuffer.append("-dnsResolveIp_");
                        stringBuffer.append(g.this.j.a());
                        stringBuffer.append("-dnsResolveType_");
                        stringBuffer.append(g.this.j.d());
                        stringBuffer.append("-dnsResolveStatus_");
                        stringBuffer.append(g.this.j.c());
                    }
                    d.b.b.c.e.c.i.a("RetryIpListManager", 0, 0, "retry_iplist", 0, stringBuffer.toString());
                    if (g.this.f51434a >= 5) {
                        BdSocketLinkService.setAvailable(false);
                        g.this.B();
                    }
                } else if (g.this.f51434a >= 5) {
                    d.b.b.c.e.c.i.a("RetryIpListManager", 0, 0, "retry_iplist", 0, "retryiplist_" + d.b.b.c.e.c.h.d());
                    g.this.C();
                }
            }
        }

        @Override // d.b.b.e.r.g
        public void b(d.b.b.e.r.c cVar) {
        }

        @Override // d.b.b.e.r.g
        public void c(String str) {
        }

        @Override // d.b.b.e.r.g
        public void d(byte[] bArr) {
        }

        @Override // d.b.b.e.r.g
        public void e(int i, d.b.b.e.r.c cVar) {
        }

        @Override // d.b.b.e.r.g
        public void f(d.b.b.e.r.c cVar) {
        }

        @Override // d.b.b.e.r.g
        public void g() {
        }

        @Override // d.b.b.e.r.g
        public void h(k kVar) {
        }

        @Override // d.b.b.e.r.g
        public void i(d.b.b.e.r.c cVar) {
        }

        @Override // d.b.b.e.r.g
        public void onOpen(Map<String, String> map) {
            if (UseHttpdnsSdkSwitch.isOn()) {
                if (g.this.f51434a > 0) {
                    g.this.i = false;
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("URL_");
                    stringBuffer.append(d.b.b.c.e.c.h.d());
                    if (g.this.j != null) {
                        stringBuffer.append("-dnsResolveIp_");
                        stringBuffer.append(g.this.j.a());
                        stringBuffer.append("-dnsResolveType_");
                        stringBuffer.append(g.this.j.d());
                        stringBuffer.append("-dnsResolveStatus_");
                        stringBuffer.append(g.this.j.c());
                    }
                    d.b.b.c.e.c.i.a("RetryIpListManager", 0, 0, "retry_iplist_succ", 0, stringBuffer.toString());
                }
            } else if (g.this.f51434a >= 5) {
                d.b.b.c.e.c.i.a("RetryIpListManager", 0, 0, "retry_iplist_succ", 0, "URL-" + d.b.b.c.e.c.h.d());
                d.b.h0.s.j.a.f().l(d.b.b.c.e.c.h.d());
                d.b.h0.s.j.a.f().k();
            }
            g.this.f51434a = 0;
        }
    }

    /* loaded from: classes3.dex */
    public class b implements BDHttpDns.a {
        public b() {
        }

        @Override // com.baidu.bdhttpdns.BDHttpDns.a
        public void a(BDHttpDnsResult bDHttpDnsResult) {
            ArrayList<String> a2;
            g.this.i = false;
            g.this.j = bDHttpDnsResult;
            if (bDHttpDnsResult == null || (a2 = bDHttpDnsResult.a()) == null || a2.isEmpty()) {
                return;
            }
            synchronized (g.this.f51440g) {
                g.this.f51441h = a2;
            }
            g.this.a();
        }
    }

    /* loaded from: classes3.dex */
    public class c implements a.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f51444a;

        public c(String str) {
            this.f51444a = str;
        }

        @Override // d.b.h0.s.j.a.b
        public void a() {
            g.this.f51435b = 0;
            g.this.f51438e = d.b.h0.s.j.a.f().g();
            if (g.this.f51438e != null) {
                g.this.A(this.f51444a);
            } else {
                g.this.f51439f = false;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements d.c {

        /* loaded from: classes3.dex */
        public class a implements a.b {
            public a() {
            }

            @Override // d.b.h0.s.j.a.b
            public void a() {
                g.this.f51435b = 0;
                g.this.f51438e = d.b.h0.s.j.a.f().g();
                if (g.this.f51438e != null) {
                    g.this.A("change ip to reconnect with DNS' failed.");
                } else {
                    g.this.f51439f = false;
                }
            }
        }

        public d() {
        }

        @Override // d.b.h0.s.j.d.c
        public void a(boolean z) {
            d.b.h0.s.j.b.e().a(z ? 2 : 1);
            if (z) {
                g.this.f51438e = d.b.h0.s.j.a.f().g();
                if (g.this.f51438e != null) {
                    g.this.A("change ip to reconnect with DNS' failed.");
                    return;
                } else {
                    d.b.h0.s.j.a.f().m(new a());
                    return;
                }
            }
            g.this.f51439f = false;
            g.this.D();
        }
    }

    public static /* synthetic */ int d(g gVar) {
        int i = gVar.f51434a;
        gVar.f51434a = i + 1;
        return i;
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
            if (!d.b.h0.s.j.a.f().i()) {
                d.b.h0.s.j.a.f().m(new c(str));
            }
            d.b.b.c.e.c.h.h(TiebaIMConfig.url);
            BdSocketLinkService.setAvailable(false);
            D();
        } else if (u(x) == null) {
            D();
        } else {
            this.f51439f = false;
            BdSocketLinkService.stopReConnStrategy("change ip and stop to restart to reconnet.");
            d.b.b.c.e.c.h.h(x);
            BdSocketLinkService.init();
            BdSocketLinkService.startService(true, str);
            this.f51436c = true;
            this.f51435b++;
        }
    }

    public final void B() {
        NoNetworkView.f();
        this.f51435b = 0;
        this.i = false;
    }

    public final void C() {
        if (this.f51439f) {
            return;
        }
        this.f51439f = true;
        if (this.f51436c) {
            this.f51436c = false;
            d.b.h0.s.j.b.e().d(TiebaIMConfig.url);
        }
        d.b.h0.s.j.b.e().b();
        if (!this.f51437d) {
            new d.b.h0.s.j.d("www.baidu.com", new d());
            this.f51437d = true;
            return;
        }
        A("change ip to reconnect with DNS' failed.");
    }

    public final void D() {
        NoNetworkView.f();
        this.f51437d = false;
        this.f51435b = 0;
        this.f51439f = false;
        this.f51436c = false;
    }

    public final void a() {
        synchronized (this.f51440g) {
            if (this.f51441h != null && !this.f51441h.isEmpty()) {
                String remove = this.f51441h.remove(0);
                if (!TextUtils.isEmpty(remove)) {
                    d.b.b.c.e.c.h.h("ws://" + remove + ":" + v(TiebaIMConfig.url));
                    BdSocketLinkService.init();
                }
            }
        }
    }

    public final void w() {
        if (this.i) {
            return;
        }
        try {
            String u = u(TiebaIMConfig.url);
            if (d.b.b.e.p.k.isEmpty(u)) {
                B();
                return;
            }
            this.i = true;
            BDHttpDns.j(BdBaseApplication.getInst().getApplicationContext()).c(u, new b());
        } catch (Exception e2) {
            BdLog.e(e2);
        }
    }

    public final String x() {
        int i;
        List<String> list = this.f51438e;
        if (list == null || (i = this.f51435b) <= -1 || i >= list.size()) {
            return null;
        }
        return d.b.h0.s.j.a.f().g().get(this.f51435b);
    }

    public void z() {
        d.b.b.e.r.h.j().c(this.k);
    }
}
