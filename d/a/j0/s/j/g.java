package d.a.j0.s.j;

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
import d.a.j0.s.j.a;
import d.a.j0.s.j.d;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public class g {
    public static g l;

    /* renamed from: a  reason: collision with root package name */
    public int f50672a;

    /* renamed from: b  reason: collision with root package name */
    public int f50673b = 0;

    /* renamed from: c  reason: collision with root package name */
    public boolean f50674c = false;

    /* renamed from: d  reason: collision with root package name */
    public boolean f50675d = false;

    /* renamed from: e  reason: collision with root package name */
    public List<String> f50676e = null;

    /* renamed from: f  reason: collision with root package name */
    public boolean f50677f = false;

    /* renamed from: g  reason: collision with root package name */
    public final Object f50678g = new Object();

    /* renamed from: h  reason: collision with root package name */
    public List<String> f50679h = new ArrayList();

    /* renamed from: i  reason: collision with root package name */
    public boolean f50680i = false;
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
                    if (g.this.f50679h == null || g.this.f50679h.isEmpty()) {
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
                    if (g.this.f50672a >= 5) {
                        BdSocketLinkService.setAvailable(false);
                        g.this.B();
                    }
                } else if (g.this.f50672a >= 5) {
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
                if (g.this.f50672a > 0) {
                    g.this.f50680i = false;
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
            } else if (g.this.f50672a >= 5) {
                d.a.c.c.e.c.i.a("RetryIpListManager", 0, 0, "retry_iplist_succ", 0, "URL-" + d.a.c.c.e.c.h.d());
                d.a.j0.s.j.a.f().l(d.a.c.c.e.c.h.d());
                d.a.j0.s.j.a.f().k();
            }
            g.this.f50672a = 0;
        }
    }

    /* loaded from: classes3.dex */
    public class b implements BDHttpDns.a {
        public b() {
        }

        @Override // com.baidu.bdhttpdns.BDHttpDns.a
        public void a(BDHttpDnsResult bDHttpDnsResult) {
            ArrayList<String> a2;
            g.this.f50680i = false;
            g.this.j = bDHttpDnsResult;
            if (bDHttpDnsResult == null || (a2 = bDHttpDnsResult.a()) == null || a2.isEmpty()) {
                return;
            }
            synchronized (g.this.f50678g) {
                g.this.f50679h = a2;
            }
            g.this.a();
        }
    }

    /* loaded from: classes3.dex */
    public class c implements a.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f50683a;

        public c(String str) {
            this.f50683a = str;
        }

        @Override // d.a.j0.s.j.a.b
        public void a() {
            g.this.f50673b = 0;
            g.this.f50676e = d.a.j0.s.j.a.f().g();
            if (g.this.f50676e != null) {
                g.this.A(this.f50683a);
            } else {
                g.this.f50677f = false;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements d.c {

        /* loaded from: classes3.dex */
        public class a implements a.b {
            public a() {
            }

            @Override // d.a.j0.s.j.a.b
            public void a() {
                g.this.f50673b = 0;
                g.this.f50676e = d.a.j0.s.j.a.f().g();
                if (g.this.f50676e != null) {
                    g.this.A("change ip to reconnect with DNS' failed.");
                } else {
                    g.this.f50677f = false;
                }
            }
        }

        public d() {
        }

        @Override // d.a.j0.s.j.d.c
        public void a(boolean z) {
            d.a.j0.s.j.b.e().a(z ? 2 : 1);
            if (z) {
                g.this.f50676e = d.a.j0.s.j.a.f().g();
                if (g.this.f50676e != null) {
                    g.this.A("change ip to reconnect with DNS' failed.");
                    return;
                } else {
                    d.a.j0.s.j.a.f().m(new a());
                    return;
                }
            }
            g.this.f50677f = false;
            g.this.D();
        }
    }

    public static /* synthetic */ int d(g gVar) {
        int i2 = gVar.f50672a;
        gVar.f50672a = i2 + 1;
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
            if (!d.a.j0.s.j.a.f().i()) {
                d.a.j0.s.j.a.f().m(new c(str));
            }
            d.a.c.c.e.c.h.h(TiebaIMConfig.url);
            BdSocketLinkService.setAvailable(false);
            D();
        } else if (u(x) == null) {
            D();
        } else {
            this.f50677f = false;
            BdSocketLinkService.stopReConnStrategy("change ip and stop to restart to reconnet.");
            d.a.c.c.e.c.h.h(x);
            BdSocketLinkService.init();
            BdSocketLinkService.startService(true, str);
            this.f50674c = true;
            this.f50673b++;
        }
    }

    public final void B() {
        NoNetworkView.f();
        this.f50673b = 0;
        this.f50680i = false;
    }

    public final void C() {
        if (this.f50677f) {
            return;
        }
        this.f50677f = true;
        if (this.f50674c) {
            this.f50674c = false;
            d.a.j0.s.j.b.e().d(TiebaIMConfig.url);
        }
        d.a.j0.s.j.b.e().b();
        if (!this.f50675d) {
            new d.a.j0.s.j.d("www.baidu.com", new d());
            this.f50675d = true;
            return;
        }
        A("change ip to reconnect with DNS' failed.");
    }

    public final void D() {
        NoNetworkView.f();
        this.f50675d = false;
        this.f50673b = 0;
        this.f50677f = false;
        this.f50674c = false;
    }

    public final void a() {
        synchronized (this.f50678g) {
            if (this.f50679h != null && !this.f50679h.isEmpty()) {
                String remove = this.f50679h.remove(0);
                if (!TextUtils.isEmpty(remove)) {
                    d.a.c.c.e.c.h.h("ws://" + remove + ":" + v(TiebaIMConfig.url));
                    BdSocketLinkService.init();
                }
            }
        }
    }

    public final void w() {
        if (this.f50680i) {
            return;
        }
        try {
            String u = u(TiebaIMConfig.url);
            if (d.a.c.e.p.k.isEmpty(u)) {
                B();
                return;
            }
            this.f50680i = true;
            BDHttpDns.j(BdBaseApplication.getInst().getApplicationContext()).c(u, new b());
        } catch (Exception e2) {
            BdLog.e(e2);
        }
    }

    public final String x() {
        int i2;
        List<String> list = this.f50676e;
        if (list == null || (i2 = this.f50673b) <= -1 || i2 >= list.size()) {
            return null;
        }
        return d.a.j0.s.j.a.f().g().get(this.f50673b);
    }

    public void z() {
        d.a.c.e.r.h.j().c(this.k);
    }
}
