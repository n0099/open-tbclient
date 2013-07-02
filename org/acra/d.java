package org.acra;

import com.baidu.browser.explorer.BdExplorePopView;
/* loaded from: classes.dex */
public class d implements org.acra.a.a {
    private org.acra.a.a r;
    private String[] a = null;
    private String[] b = null;
    private Integer c = null;
    private ReportField[] d = null;
    private Boolean e = null;
    private Boolean f = null;
    private Integer g = null;
    private Boolean h = null;
    private String i = null;
    private String j = null;
    private String k = null;
    private String l = null;
    private Boolean m = null;
    private String[] n = null;
    private String o = null;
    private Integer p = null;
    private ReportingInteractionMode q = null;
    private Integer s = null;
    private Integer t = null;
    private Integer u = null;
    private Integer v = null;
    private Integer w = null;
    private Integer x = null;
    private Integer y = null;
    private Integer z = null;
    private Integer A = null;
    private Integer B = null;
    private Integer C = null;
    private Integer D = null;
    private String E = null;
    private Integer F = null;
    private Boolean G = null;
    private Boolean H = null;
    private String[] I = null;
    private String J = null;
    private Integer K = null;
    private String L = null;
    private Boolean M = null;

    public void a(String str) {
        this.j = str;
    }

    public void a(ReportingInteractionMode reportingInteractionMode) {
        this.q = reportingInteractionMode;
        a.b();
    }

    public void a(int i) {
        this.s = Integer.valueOf(i);
    }

    public void b(int i) {
        this.u = Integer.valueOf(i);
    }

    public void c(int i) {
        this.v = Integer.valueOf(i);
    }

    public void d(int i) {
        this.w = Integer.valueOf(i);
    }

    public void e(int i) {
        this.x = Integer.valueOf(i);
    }

    public void f(int i) {
        this.C = Integer.valueOf(i);
    }

    public d(org.acra.a.a aVar) {
        this.r = null;
        this.r = aVar;
    }

    @Override // org.acra.a.a
    public String[] a() {
        if (this.a != null) {
            return this.a;
        }
        if (this.r != null) {
            return this.r.a();
        }
        return new String[0];
    }

    @Override // org.acra.a.a
    public String[] b() {
        if (this.b != null) {
            return this.b;
        }
        if (this.r != null) {
            return this.r.b();
        }
        return new String[0];
    }

    @Override // java.lang.annotation.Annotation
    public Class annotationType() {
        return this.r.annotationType();
    }

    @Override // org.acra.a.a
    public int c() {
        if (this.c != null) {
            return this.c.intValue();
        }
        if (this.r != null) {
            return this.r.c();
        }
        return BdExplorePopView.SELECTION_TOP_DUR;
    }

    @Override // org.acra.a.a
    public ReportField[] d() {
        if (this.d != null) {
            return this.d;
        }
        if (this.r != null) {
            return this.r.d();
        }
        return new ReportField[0];
    }

    @Override // org.acra.a.a
    public boolean e() {
        if (this.e != null) {
            return this.e.booleanValue();
        }
        if (this.r != null) {
            return this.r.e();
        }
        return true;
    }

    @Override // org.acra.a.a
    public boolean f() {
        if (this.f != null) {
            return this.f.booleanValue();
        }
        if (this.r != null) {
            return this.r.f();
        }
        return true;
    }

    @Override // org.acra.a.a
    public int g() {
        if (this.g != null) {
            return this.g.intValue();
        }
        if (this.r != null) {
            return this.r.g();
        }
        return 5;
    }

    @Override // org.acra.a.a
    public boolean h() {
        if (this.h != null) {
            return this.h.booleanValue();
        }
        if (this.r != null) {
            return this.r.h();
        }
        return false;
    }

    @Override // org.acra.a.a
    public String i() {
        if (this.i != null) {
            return this.i;
        }
        if (this.r != null) {
            return this.r.i();
        }
        return "";
    }

    @Override // org.acra.a.a
    public String j() {
        if (this.j != null) {
            return this.j;
        }
        if (this.r != null) {
            return this.r.j();
        }
        return "";
    }

    @Override // org.acra.a.a
    public String k() {
        if (this.k != null) {
            return this.k;
        }
        if (this.r != null) {
            return this.r.k();
        }
        return "ACRA-NULL-STRING";
    }

    @Override // org.acra.a.a
    public String l() {
        if (this.l != null) {
            return this.l;
        }
        if (this.r != null) {
            return this.r.l();
        }
        return "ACRA-NULL-STRING";
    }

    @Override // org.acra.a.a
    public boolean m() {
        if (this.m != null) {
            return this.m.booleanValue();
        }
        if (this.r != null) {
            return this.r.m();
        }
        return false;
    }

    @Override // org.acra.a.a
    public String[] n() {
        if (this.n != null) {
            return this.n;
        }
        return this.r != null ? this.r.n() : new String[]{"-t", Integer.toString(100), "-v", "time"};
    }

    @Override // org.acra.a.a
    public String o() {
        if (this.o != null) {
            return this.o;
        }
        if (this.r != null) {
            return this.r.o();
        }
        return "";
    }

    @Override // org.acra.a.a
    public int p() {
        if (this.p != null) {
            return this.p.intValue();
        }
        if (this.r != null) {
            return this.r.p();
        }
        return 3;
    }

    @Override // org.acra.a.a
    public ReportingInteractionMode q() {
        if (this.q != null) {
            return this.q;
        }
        if (this.r != null) {
            return this.r.q();
        }
        return ReportingInteractionMode.SILENT;
    }

    @Override // org.acra.a.a
    public int r() {
        if (this.s != null) {
            return this.s.intValue();
        }
        if (this.r != null) {
            return this.r.r();
        }
        return 0;
    }

    @Override // org.acra.a.a
    public int s() {
        if (this.t != null) {
            return this.t.intValue();
        }
        if (this.r != null) {
            return this.r.s();
        }
        return 0;
    }

    @Override // org.acra.a.a
    public int t() {
        if (this.u != null) {
            return this.u.intValue();
        }
        if (this.r != null) {
            return this.r.t();
        }
        return 17301543;
    }

    @Override // org.acra.a.a
    public int u() {
        if (this.v != null) {
            return this.v.intValue();
        }
        if (this.r != null) {
            return this.r.u();
        }
        return 0;
    }

    @Override // org.acra.a.a
    public int v() {
        if (this.w != null) {
            return this.w.intValue();
        }
        if (this.r != null) {
            return this.r.v();
        }
        return 0;
    }

    @Override // org.acra.a.a
    public int w() {
        if (this.x != null) {
            return this.x.intValue();
        }
        if (this.r != null) {
            return this.r.w();
        }
        return 0;
    }

    @Override // org.acra.a.a
    public int x() {
        if (this.y != null) {
            return this.y.intValue();
        }
        if (this.r != null) {
            return this.r.x();
        }
        return 17301624;
    }

    @Override // org.acra.a.a
    public int y() {
        if (this.z != null) {
            return this.z.intValue();
        }
        if (this.r != null) {
            return this.r.y();
        }
        return 0;
    }

    @Override // org.acra.a.a
    public int z() {
        if (this.A != null) {
            return this.A.intValue();
        }
        if (this.r != null) {
            return this.r.z();
        }
        return 0;
    }

    @Override // org.acra.a.a
    public int A() {
        if (this.B != null) {
            return this.B.intValue();
        }
        if (this.r != null) {
            return this.r.A();
        }
        return 0;
    }

    @Override // org.acra.a.a
    public int B() {
        if (this.C != null) {
            return this.C.intValue();
        }
        if (this.r != null) {
            return this.r.B();
        }
        return 0;
    }

    @Override // org.acra.a.a
    public int C() {
        if (this.D != null) {
            return this.D.intValue();
        }
        if (this.r != null) {
            return this.r.C();
        }
        return 0;
    }

    @Override // org.acra.a.a
    public String D() {
        if (this.E != null) {
            return this.E;
        }
        if (this.r != null) {
            return this.r.D();
        }
        return "";
    }

    @Override // org.acra.a.a
    public int E() {
        if (this.F != null) {
            return this.F.intValue();
        }
        if (this.r != null) {
            return this.r.E();
        }
        return 5000;
    }

    @Override // org.acra.a.a
    public boolean F() {
        if (this.G != null) {
            return this.G.booleanValue();
        }
        if (this.r != null) {
            return this.r.F();
        }
        return false;
    }

    @Override // org.acra.a.a
    public boolean G() {
        if (this.H != null) {
            return this.H.booleanValue();
        }
        if (this.r != null) {
            return this.r.G();
        }
        return true;
    }

    @Override // org.acra.a.a
    public String[] H() {
        if (this.I != null) {
            return this.I;
        }
        if (this.r != null) {
            return this.r.H();
        }
        return new String[0];
    }

    @Override // org.acra.a.a
    public String I() {
        if (this.J != null) {
            return this.J;
        }
        if (this.r != null) {
            return this.r.I();
        }
        return "";
    }

    @Override // org.acra.a.a
    public int J() {
        if (this.K != null) {
            return this.K.intValue();
        }
        if (this.r != null) {
            return this.r.J();
        }
        return 100;
    }

    @Override // org.acra.a.a
    public String K() {
        if (this.L != null) {
            return this.L;
        }
        if (this.r != null) {
            return this.r.K();
        }
        return "https://docs.google.com/spreadsheet/formResponse?formkey=%s&ifq";
    }

    @Override // org.acra.a.a
    public boolean L() {
        if (this.M != null) {
            return this.M.booleanValue();
        }
        if (this.r != null) {
            return this.r.L();
        }
        return false;
    }
}
