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
    public static h f38964h;

    /* renamed from: c  reason: collision with root package name */
    public String[] f38967c;

    /* renamed from: g  reason: collision with root package name */
    public g f38971g;

    /* renamed from: a  reason: collision with root package name */
    public String f38965a = null;

    /* renamed from: b  reason: collision with root package name */
    public List<BasicNameValuePair> f38966b = null;

    /* renamed from: d  reason: collision with root package name */
    public String f38968d = null;

    /* renamed from: e  reason: collision with root package name */
    public i f38969e = null;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<g> f38970f = new ArrayList<>();

    /* loaded from: classes.dex */
    public class a implements g {
        public a() {
        }

        @Override // d.a.c.e.r.g
        public void a(String str) {
            Iterator it = h.this.f38970f.iterator();
            while (it.hasNext()) {
                ((g) it.next()).a(str);
            }
        }

        @Override // d.a.c.e.r.g
        public void b(int i2, String str) {
            h.this.f38969e = null;
            Iterator it = h.this.f38970f.iterator();
            while (it.hasNext()) {
                ((g) it.next()).b(i2, str);
            }
        }

        @Override // d.a.c.e.r.g
        public void c(c cVar) {
            Iterator it = h.this.f38970f.iterator();
            while (it.hasNext()) {
                ((g) it.next()).c(cVar);
            }
        }

        @Override // d.a.c.e.r.g
        public void d(byte[] bArr) {
            Iterator it = h.this.f38970f.iterator();
            while (it.hasNext()) {
                ((g) it.next()).d(bArr);
            }
        }

        @Override // d.a.c.e.r.g
        public void e() {
            Iterator it = h.this.f38970f.iterator();
            while (it.hasNext()) {
                ((g) it.next()).e();
            }
        }

        @Override // d.a.c.e.r.g
        public void f(k kVar) {
            Iterator it = h.this.f38970f.iterator();
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
            Iterator it = h.this.f38970f.iterator();
            while (it.hasNext()) {
                ((g) it.next()).onOpen(map);
            }
        }
    }

    public h() {
        this.f38971g = null;
        this.f38971g = new a();
    }

    public static h j() {
        if (f38964h == null) {
            synchronized (h.class) {
                if (f38964h == null) {
                    f38964h = new h();
                }
            }
        }
        return f38964h;
    }

    public boolean c(g gVar) {
        if (gVar != null) {
            synchronized (h.class) {
                if (this.f38970f.contains(gVar)) {
                    return false;
                }
                return this.f38970f.add(gVar);
            }
        }
        return false;
    }

    public void d() {
        i iVar = this.f38969e;
        if (iVar != null) {
            iVar.o();
        }
    }

    public void e() {
        i iVar = this.f38969e;
        if (iVar != null) {
            iVar.p();
        }
    }

    public void f(int i2, String str) {
        i iVar = this.f38969e;
        if (iVar != null) {
            this.f38969e = null;
            iVar.q(i2, str);
            if (this.f38969e != null) {
                BdLog.e("close is opened and thread is leaded!!!");
                this.f38969e = null;
            }
        }
    }

    public long g() {
        i iVar = this.f38969e;
        if (iVar != null) {
            return iVar.z();
        }
        return -1L;
    }

    public long h() {
        i iVar = this.f38969e;
        if (iVar != null) {
            return iVar.A();
        }
        return -1L;
    }

    public long i() {
        i iVar = this.f38969e;
        if (iVar != null) {
            return iVar.v();
        }
        return -1L;
    }

    public boolean k() {
        if (t()) {
            d.a.c.e.p.l.d();
        }
        i iVar = this.f38969e;
        return (iVar == null || !iVar.E() || this.f38969e.F()) ? false : true;
    }

    public boolean l() {
        if (t()) {
            d.a.c.e.p.l.d();
        }
        i iVar = this.f38969e;
        return iVar != null && iVar.E();
    }

    public String m() {
        i iVar = this.f38969e;
        if (iVar != null) {
            return iVar.w();
        }
        return null;
    }

    public String n() {
        i iVar = this.f38969e;
        if (iVar != null) {
            return iVar.x();
        }
        return null;
    }

    public String o() {
        i iVar = this.f38969e;
        if (iVar != null) {
            return iVar.B();
        }
        return null;
    }

    public long p() {
        i iVar = this.f38969e;
        if (iVar != null) {
            return iVar.y();
        }
        return -1L;
    }

    public String q() {
        return this.f38965a;
    }

    public void r(String str, String str2, String[] strArr, List<BasicNameValuePair> list) {
        this.f38965a = str;
        this.f38968d = str2;
        this.f38967c = strArr;
        this.f38966b = list;
        t();
    }

    public boolean s() {
        if (t()) {
            d.a.c.e.p.l.d();
        }
        i iVar = this.f38969e;
        return iVar != null && iVar.C();
    }

    public final boolean t() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public boolean u() {
        if (t()) {
            d.a.c.e.p.l.d();
        }
        i iVar = this.f38969e;
        if (iVar != null) {
            if (!iVar.C() && !this.f38969e.E()) {
                this.f38969e.q(1, null);
                this.f38969e = null;
            } else {
                t();
                return true;
            }
        }
        this.f38969e = new i();
        try {
            d0 d0Var = new d0();
            d0Var.j(this.f38968d);
            this.f38969e.r(this.f38965a, this.f38967c, this.f38971g, d0Var, this.f38966b);
            return true;
        } catch (WebSocketException unused) {
            this.f38969e = null;
            return false;
        }
    }

    public synchronized boolean v(c cVar) {
        if (cVar == null) {
            return false;
        }
        d.a.c.e.p.l.d();
        if (this.f38969e != null) {
            return this.f38969e.I(cVar);
        }
        if (cVar != null) {
            cVar.a(1);
        }
        return false;
    }
}
