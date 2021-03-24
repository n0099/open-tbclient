package d.b.b.e.r;

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
    public static h f42102h;

    /* renamed from: c  reason: collision with root package name */
    public String[] f42105c;

    /* renamed from: g  reason: collision with root package name */
    public g f42109g;

    /* renamed from: a  reason: collision with root package name */
    public String f42103a = null;

    /* renamed from: b  reason: collision with root package name */
    public List<BasicNameValuePair> f42104b = null;

    /* renamed from: d  reason: collision with root package name */
    public String f42106d = null;

    /* renamed from: e  reason: collision with root package name */
    public i f42107e = null;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<g> f42108f = new ArrayList<>();

    /* loaded from: classes.dex */
    public class a implements g {
        public a() {
        }

        @Override // d.b.b.e.r.g
        public void a(int i, String str) {
            h.this.f42107e = null;
            Iterator it = h.this.f42108f.iterator();
            while (it.hasNext()) {
                ((g) it.next()).a(i, str);
            }
        }

        @Override // d.b.b.e.r.g
        public void b(c cVar) {
            Iterator it = h.this.f42108f.iterator();
            while (it.hasNext()) {
                ((g) it.next()).b(cVar);
            }
        }

        @Override // d.b.b.e.r.g
        public void c(String str) {
            Iterator it = h.this.f42108f.iterator();
            while (it.hasNext()) {
                ((g) it.next()).c(str);
            }
        }

        @Override // d.b.b.e.r.g
        public void d(byte[] bArr) {
            Iterator it = h.this.f42108f.iterator();
            while (it.hasNext()) {
                ((g) it.next()).d(bArr);
            }
        }

        @Override // d.b.b.e.r.g
        public void e(int i, c cVar) {
            if (cVar != null) {
                cVar.a(i);
            }
        }

        @Override // d.b.b.e.r.g
        public void f(c cVar) {
            if (cVar != null) {
                cVar.c();
            }
        }

        @Override // d.b.b.e.r.g
        public void g() {
            Iterator it = h.this.f42108f.iterator();
            while (it.hasNext()) {
                ((g) it.next()).g();
            }
        }

        @Override // d.b.b.e.r.g
        public void h(k kVar) {
            Iterator it = h.this.f42108f.iterator();
            while (it.hasNext()) {
                ((g) it.next()).h(kVar);
            }
        }

        @Override // d.b.b.e.r.g
        public void i(c cVar) {
            if (cVar != null) {
                cVar.b();
            }
        }

        @Override // d.b.b.e.r.g
        public void onOpen(Map<String, String> map) {
            Iterator it = h.this.f42108f.iterator();
            while (it.hasNext()) {
                ((g) it.next()).onOpen(map);
            }
        }
    }

    public h() {
        this.f42109g = null;
        this.f42109g = new a();
    }

    public static h j() {
        if (f42102h == null) {
            synchronized (h.class) {
                if (f42102h == null) {
                    f42102h = new h();
                }
            }
        }
        return f42102h;
    }

    public boolean c(g gVar) {
        if (gVar != null) {
            synchronized (h.class) {
                if (this.f42108f.contains(gVar)) {
                    return false;
                }
                return this.f42108f.add(gVar);
            }
        }
        return false;
    }

    public void d() {
        i iVar = this.f42107e;
        if (iVar != null) {
            iVar.o();
        }
    }

    public void e() {
        i iVar = this.f42107e;
        if (iVar != null) {
            iVar.p();
        }
    }

    public void f(int i, String str) {
        i iVar = this.f42107e;
        if (iVar != null) {
            this.f42107e = null;
            iVar.q(i, str);
            if (this.f42107e != null) {
                BdLog.e("close is opened and thread is leaded!!!");
                this.f42107e = null;
            }
        }
    }

    public long g() {
        i iVar = this.f42107e;
        if (iVar != null) {
            return iVar.z();
        }
        return -1L;
    }

    public long h() {
        i iVar = this.f42107e;
        if (iVar != null) {
            return iVar.A();
        }
        return -1L;
    }

    public long i() {
        i iVar = this.f42107e;
        if (iVar != null) {
            return iVar.v();
        }
        return -1L;
    }

    public boolean k() {
        if (t()) {
            d.b.b.e.p.l.d();
        }
        i iVar = this.f42107e;
        return (iVar == null || !iVar.E() || this.f42107e.F()) ? false : true;
    }

    public boolean l() {
        if (t()) {
            d.b.b.e.p.l.d();
        }
        i iVar = this.f42107e;
        return iVar != null && iVar.E();
    }

    public String m() {
        i iVar = this.f42107e;
        if (iVar != null) {
            return iVar.w();
        }
        return null;
    }

    public String n() {
        i iVar = this.f42107e;
        if (iVar != null) {
            return iVar.x();
        }
        return null;
    }

    public String o() {
        i iVar = this.f42107e;
        if (iVar != null) {
            return iVar.B();
        }
        return null;
    }

    public long p() {
        i iVar = this.f42107e;
        if (iVar != null) {
            return iVar.y();
        }
        return -1L;
    }

    public String q() {
        return this.f42103a;
    }

    public void r(String str, String str2, String[] strArr, List<BasicNameValuePair> list) {
        this.f42103a = str;
        this.f42106d = str2;
        this.f42105c = strArr;
        this.f42104b = list;
        t();
    }

    public boolean s() {
        if (t()) {
            d.b.b.e.p.l.d();
        }
        i iVar = this.f42107e;
        return iVar != null && iVar.C();
    }

    public final boolean t() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public boolean u() {
        if (t()) {
            d.b.b.e.p.l.d();
        }
        i iVar = this.f42107e;
        if (iVar != null) {
            if (!iVar.C() && !this.f42107e.E()) {
                this.f42107e.q(1, null);
                this.f42107e = null;
            } else {
                t();
                return true;
            }
        }
        this.f42107e = new i();
        try {
            d0 d0Var = new d0();
            d0Var.j(this.f42106d);
            this.f42107e.r(this.f42103a, this.f42105c, this.f42109g, d0Var, this.f42104b);
            return true;
        } catch (WebSocketException unused) {
            this.f42107e = null;
            return false;
        }
    }

    public synchronized boolean v(c cVar) {
        if (cVar == null) {
            return false;
        }
        d.b.b.e.p.l.d();
        if (this.f42107e != null) {
            return this.f42107e.I(cVar);
        }
        if (cVar != null) {
            cVar.a(1);
        }
        return false;
    }
}
