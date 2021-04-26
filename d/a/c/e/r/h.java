package d.a.c.e.r;

import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.webSocket.WebSocketException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class h {

    /* renamed from: h  reason: collision with root package name */
    public static h f40055h;

    /* renamed from: c  reason: collision with root package name */
    public String[] f40058c;

    /* renamed from: g  reason: collision with root package name */
    public g f40062g;

    /* renamed from: a  reason: collision with root package name */
    public String f40056a = null;

    /* renamed from: b  reason: collision with root package name */
    public List<BasicNameValuePair> f40057b = null;

    /* renamed from: d  reason: collision with root package name */
    public String f40059d = null;

    /* renamed from: e  reason: collision with root package name */
    public i f40060e = null;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<g> f40061f = new ArrayList<>();

    /* loaded from: classes.dex */
    public class a implements g {
        public a() {
        }

        @Override // d.a.c.e.r.g
        public void a(String str) {
            Iterator it = h.this.f40061f.iterator();
            while (it.hasNext()) {
                ((g) it.next()).a(str);
            }
        }

        @Override // d.a.c.e.r.g
        public void b(int i2, String str) {
            h.this.f40060e = null;
            Iterator it = h.this.f40061f.iterator();
            while (it.hasNext()) {
                ((g) it.next()).b(i2, str);
            }
        }

        @Override // d.a.c.e.r.g
        public void c(c cVar) {
            Iterator it = h.this.f40061f.iterator();
            while (it.hasNext()) {
                ((g) it.next()).c(cVar);
            }
        }

        @Override // d.a.c.e.r.g
        public void d(byte[] bArr) {
            Iterator it = h.this.f40061f.iterator();
            while (it.hasNext()) {
                ((g) it.next()).d(bArr);
            }
        }

        @Override // d.a.c.e.r.g
        public void e() {
            Iterator it = h.this.f40061f.iterator();
            while (it.hasNext()) {
                ((g) it.next()).e();
            }
        }

        @Override // d.a.c.e.r.g
        public void f(k kVar) {
            Iterator it = h.this.f40061f.iterator();
            while (it.hasNext()) {
                ((g) it.next()).f(kVar);
            }
        }

        @Override // d.a.c.e.r.g
        public void g(int i2, c cVar) {
            if (cVar != null) {
                cVar.a(i2);
            }
        }

        @Override // d.a.c.e.r.g
        public void h(c cVar) {
            if (cVar != null) {
                cVar.c();
            }
        }

        @Override // d.a.c.e.r.g
        public void i(c cVar) {
            if (cVar != null) {
                cVar.b();
            }
        }

        @Override // d.a.c.e.r.g
        public void onOpen(Map<String, String> map) {
            Iterator it = h.this.f40061f.iterator();
            while (it.hasNext()) {
                ((g) it.next()).onOpen(map);
            }
        }
    }

    public h() {
        this.f40062g = null;
        this.f40062g = new a();
    }

    public static h j() {
        if (f40055h == null) {
            synchronized (h.class) {
                if (f40055h == null) {
                    f40055h = new h();
                }
            }
        }
        return f40055h;
    }

    public boolean c(g gVar) {
        if (gVar != null) {
            synchronized (h.class) {
                if (this.f40061f.contains(gVar)) {
                    return false;
                }
                return this.f40061f.add(gVar);
            }
        }
        return false;
    }

    public void d() {
        i iVar = this.f40060e;
        if (iVar != null) {
            iVar.o();
        }
    }

    public void e() {
        i iVar = this.f40060e;
        if (iVar != null) {
            iVar.p();
        }
    }

    public void f(int i2, String str) {
        i iVar = this.f40060e;
        if (iVar != null) {
            this.f40060e = null;
            iVar.q(i2, str);
            if (this.f40060e != null) {
                BdLog.e("close is opened and thread is leaded!!!");
                this.f40060e = null;
            }
        }
    }

    public long g() {
        i iVar = this.f40060e;
        if (iVar != null) {
            return iVar.z();
        }
        return -1L;
    }

    public long h() {
        i iVar = this.f40060e;
        if (iVar != null) {
            return iVar.A();
        }
        return -1L;
    }

    public long i() {
        i iVar = this.f40060e;
        if (iVar != null) {
            return iVar.v();
        }
        return -1L;
    }

    public boolean k() {
        if (t()) {
            d.a.c.e.p.l.d();
        }
        i iVar = this.f40060e;
        return (iVar == null || !iVar.E() || this.f40060e.F()) ? false : true;
    }

    public boolean l() {
        if (t()) {
            d.a.c.e.p.l.d();
        }
        i iVar = this.f40060e;
        return iVar != null && iVar.E();
    }

    public String m() {
        i iVar = this.f40060e;
        if (iVar != null) {
            return iVar.w();
        }
        return null;
    }

    public String n() {
        i iVar = this.f40060e;
        if (iVar != null) {
            return iVar.x();
        }
        return null;
    }

    public String o() {
        i iVar = this.f40060e;
        if (iVar != null) {
            return iVar.B();
        }
        return null;
    }

    public long p() {
        i iVar = this.f40060e;
        if (iVar != null) {
            return iVar.y();
        }
        return -1L;
    }

    public String q() {
        return this.f40056a;
    }

    public void r(String str, String str2, String[] strArr, List<BasicNameValuePair> list) {
        this.f40056a = str;
        this.f40059d = str2;
        this.f40058c = strArr;
        this.f40057b = list;
        t();
    }

    public boolean s() {
        if (t()) {
            d.a.c.e.p.l.d();
        }
        i iVar = this.f40060e;
        return iVar != null && iVar.C();
    }

    public final boolean t() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public boolean u() {
        if (t()) {
            d.a.c.e.p.l.d();
        }
        i iVar = this.f40060e;
        if (iVar != null) {
            if (!iVar.C() && !this.f40060e.E()) {
                this.f40060e.q(1, null);
                this.f40060e = null;
            } else {
                t();
                return true;
            }
        }
        this.f40060e = new i();
        try {
            d0 d0Var = new d0();
            d0Var.j(this.f40059d);
            this.f40060e.r(this.f40056a, this.f40058c, this.f40062g, d0Var, this.f40057b);
            return true;
        } catch (WebSocketException unused) {
            this.f40060e = null;
            return false;
        }
    }

    public synchronized boolean v(c cVar) {
        if (cVar == null) {
            return false;
        }
        d.a.c.e.p.l.d();
        if (this.f40060e != null) {
            return this.f40060e.I(cVar);
        }
        if (cVar != null) {
            cVar.a(1);
        }
        return false;
    }
}
