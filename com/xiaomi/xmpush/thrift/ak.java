package com.xiaomi.xmpush.thrift;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.util.BitSet;
import org.apache.thrift.TFieldIdEnum;
/* loaded from: classes3.dex */
public class ak implements Serializable, Cloneable, org.apache.thrift.a<ak, TFieldIdEnum> {
    private BitSet L = new BitSet(5);
    public String a;
    public x b;
    public String c;
    public String d;
    public long e;
    public String f;
    public String g;
    public String h;
    public String i;
    public long j;
    public String k;
    public String l;
    public long m;
    public String n;
    public int o;
    public String p;
    public int q;
    public String r;
    private static final org.apache.thrift.protocol.j s = new org.apache.thrift.protocol.j("XmPushActionRegistrationResult");
    private static final org.apache.thrift.protocol.b t = new org.apache.thrift.protocol.b("", Constants.GZIP_CAST_TYPE, 1);
    private static final org.apache.thrift.protocol.b u = new org.apache.thrift.protocol.b("", (byte) 12, 2);
    private static final org.apache.thrift.protocol.b v = new org.apache.thrift.protocol.b("", Constants.GZIP_CAST_TYPE, 3);
    private static final org.apache.thrift.protocol.b w = new org.apache.thrift.protocol.b("", Constants.GZIP_CAST_TYPE, 4);
    private static final org.apache.thrift.protocol.b x = new org.apache.thrift.protocol.b("", (byte) 10, 6);
    private static final org.apache.thrift.protocol.b y = new org.apache.thrift.protocol.b("", Constants.GZIP_CAST_TYPE, 7);
    private static final org.apache.thrift.protocol.b z = new org.apache.thrift.protocol.b("", Constants.GZIP_CAST_TYPE, 8);
    private static final org.apache.thrift.protocol.b A = new org.apache.thrift.protocol.b("", Constants.GZIP_CAST_TYPE, 9);
    private static final org.apache.thrift.protocol.b B = new org.apache.thrift.protocol.b("", Constants.GZIP_CAST_TYPE, 10);
    private static final org.apache.thrift.protocol.b C = new org.apache.thrift.protocol.b("", (byte) 10, 11);
    private static final org.apache.thrift.protocol.b D = new org.apache.thrift.protocol.b("", Constants.GZIP_CAST_TYPE, 12);
    private static final org.apache.thrift.protocol.b E = new org.apache.thrift.protocol.b("", Constants.GZIP_CAST_TYPE, 13);
    private static final org.apache.thrift.protocol.b F = new org.apache.thrift.protocol.b("", (byte) 10, 14);
    private static final org.apache.thrift.protocol.b G = new org.apache.thrift.protocol.b("", Constants.GZIP_CAST_TYPE, 15);
    private static final org.apache.thrift.protocol.b H = new org.apache.thrift.protocol.b("", (byte) 8, 16);
    private static final org.apache.thrift.protocol.b I = new org.apache.thrift.protocol.b("", Constants.GZIP_CAST_TYPE, 17);
    private static final org.apache.thrift.protocol.b J = new org.apache.thrift.protocol.b("", (byte) 8, 18);
    private static final org.apache.thrift.protocol.b K = new org.apache.thrift.protocol.b("", Constants.GZIP_CAST_TYPE, 19);

    @Override // org.apache.thrift.a
    public void a(org.apache.thrift.protocol.e eVar) {
        eVar.g();
        while (true) {
            org.apache.thrift.protocol.b i = eVar.i();
            if (i.b == 0) {
                eVar.h();
                if (!g()) {
                    throw new org.apache.thrift.protocol.f("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
                }
                v();
                return;
            }
            switch (i.c) {
                case 1:
                    if (i.b != 11) {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    } else {
                        this.a = eVar.w();
                        break;
                    }
                case 2:
                    if (i.b != 12) {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    } else {
                        this.b = new x();
                        this.b.a(eVar);
                        break;
                    }
                case 3:
                    if (i.b != 11) {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    } else {
                        this.c = eVar.w();
                        break;
                    }
                case 4:
                    if (i.b != 11) {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    } else {
                        this.d = eVar.w();
                        break;
                    }
                case 5:
                default:
                    org.apache.thrift.protocol.h.a(eVar, i.b);
                    break;
                case 6:
                    if (i.b != 10) {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    } else {
                        this.e = eVar.u();
                        a(true);
                        break;
                    }
                case 7:
                    if (i.b != 11) {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    } else {
                        this.f = eVar.w();
                        break;
                    }
                case 8:
                    if (i.b != 11) {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    } else {
                        this.g = eVar.w();
                        break;
                    }
                case 9:
                    if (i.b != 11) {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    } else {
                        this.h = eVar.w();
                        break;
                    }
                case 10:
                    if (i.b != 11) {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    } else {
                        this.i = eVar.w();
                        break;
                    }
                case 11:
                    if (i.b != 10) {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    } else {
                        this.j = eVar.u();
                        b(true);
                        break;
                    }
                case 12:
                    if (i.b != 11) {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    } else {
                        this.k = eVar.w();
                        break;
                    }
                case 13:
                    if (i.b != 11) {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    } else {
                        this.l = eVar.w();
                        break;
                    }
                case 14:
                    if (i.b != 10) {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    } else {
                        this.m = eVar.u();
                        c(true);
                        break;
                    }
                case 15:
                    if (i.b != 11) {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    } else {
                        this.n = eVar.w();
                        break;
                    }
                case 16:
                    if (i.b != 8) {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    } else {
                        this.o = eVar.t();
                        d(true);
                        break;
                    }
                case 17:
                    if (i.b != 11) {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    } else {
                        this.p = eVar.w();
                        break;
                    }
                case 18:
                    if (i.b != 8) {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    } else {
                        this.q = eVar.t();
                        e(true);
                        break;
                    }
                case 19:
                    if (i.b != 11) {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    } else {
                        this.r = eVar.w();
                        break;
                    }
            }
            eVar.j();
        }
    }

    public void a(boolean z2) {
        this.L.set(0, z2);
    }

    public boolean a() {
        return this.a != null;
    }

    public boolean a(ak akVar) {
        if (akVar == null) {
            return false;
        }
        boolean a = a();
        boolean a2 = akVar.a();
        if ((a || a2) && !(a && a2 && this.a.equals(akVar.a))) {
            return false;
        }
        boolean b = b();
        boolean b2 = akVar.b();
        if ((b || b2) && !(b && b2 && this.b.a(akVar.b))) {
            return false;
        }
        boolean d = d();
        boolean d2 = akVar.d();
        if ((d || d2) && !(d && d2 && this.c.equals(akVar.c))) {
            return false;
        }
        boolean e = e();
        boolean e2 = akVar.e();
        if (((e || e2) && !(e && e2 && this.d.equals(akVar.d))) || this.e != akVar.e) {
            return false;
        }
        boolean h = h();
        boolean h2 = akVar.h();
        if ((h || h2) && !(h && h2 && this.f.equals(akVar.f))) {
            return false;
        }
        boolean i = i();
        boolean i2 = akVar.i();
        if ((i || i2) && !(i && i2 && this.g.equals(akVar.g))) {
            return false;
        }
        boolean j = j();
        boolean j2 = akVar.j();
        if ((j || j2) && !(j && j2 && this.h.equals(akVar.h))) {
            return false;
        }
        boolean l = l();
        boolean l2 = akVar.l();
        if ((l || l2) && !(l && l2 && this.i.equals(akVar.i))) {
            return false;
        }
        boolean m = m();
        boolean m2 = akVar.m();
        if ((m || m2) && !(m && m2 && this.j == akVar.j)) {
            return false;
        }
        boolean n = n();
        boolean n2 = akVar.n();
        if ((n || n2) && !(n && n2 && this.k.equals(akVar.k))) {
            return false;
        }
        boolean o = o();
        boolean o2 = akVar.o();
        if ((o || o2) && !(o && o2 && this.l.equals(akVar.l))) {
            return false;
        }
        boolean p = p();
        boolean p2 = akVar.p();
        if ((p || p2) && !(p && p2 && this.m == akVar.m)) {
            return false;
        }
        boolean q = q();
        boolean q2 = akVar.q();
        if ((q || q2) && !(q && q2 && this.n.equals(akVar.n))) {
            return false;
        }
        boolean r = r();
        boolean r2 = akVar.r();
        if ((r || r2) && !(r && r2 && this.o == akVar.o)) {
            return false;
        }
        boolean s2 = s();
        boolean s3 = akVar.s();
        if ((s2 || s3) && !(s2 && s3 && this.p.equals(akVar.p))) {
            return false;
        }
        boolean t2 = t();
        boolean t3 = akVar.t();
        if ((t2 || t3) && !(t2 && t3 && this.q == akVar.q)) {
            return false;
        }
        boolean u2 = u();
        boolean u3 = akVar.u();
        return !(u2 || u3) || (u2 && u3 && this.r.equals(akVar.r));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: b */
    public int compareTo(ak akVar) {
        int a;
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        int a8;
        int a9;
        int a10;
        int a11;
        int a12;
        int a13;
        int a14;
        int a15;
        int a16;
        int a17;
        int a18;
        if (getClass().equals(akVar.getClass())) {
            int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(akVar.a()));
            if (compareTo == 0) {
                if (!a() || (a18 = org.apache.thrift.b.a(this.a, akVar.a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(akVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a17 = org.apache.thrift.b.a(this.b, akVar.b)) == 0) {
                            int compareTo3 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(akVar.d()));
                            if (compareTo3 == 0) {
                                if (!d() || (a16 = org.apache.thrift.b.a(this.c, akVar.c)) == 0) {
                                    int compareTo4 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(akVar.e()));
                                    if (compareTo4 == 0) {
                                        if (!e() || (a15 = org.apache.thrift.b.a(this.d, akVar.d)) == 0) {
                                            int compareTo5 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(akVar.g()));
                                            if (compareTo5 == 0) {
                                                if (!g() || (a14 = org.apache.thrift.b.a(this.e, akVar.e)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(akVar.h()));
                                                    if (compareTo6 == 0) {
                                                        if (!h() || (a13 = org.apache.thrift.b.a(this.f, akVar.f)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(akVar.i()));
                                                            if (compareTo7 == 0) {
                                                                if (!i() || (a12 = org.apache.thrift.b.a(this.g, akVar.g)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(akVar.j()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!j() || (a11 = org.apache.thrift.b.a(this.h, akVar.h)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(akVar.l()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!l() || (a10 = org.apache.thrift.b.a(this.i, akVar.i)) == 0) {
                                                                                    int compareTo10 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(akVar.m()));
                                                                                    if (compareTo10 == 0) {
                                                                                        if (!m() || (a9 = org.apache.thrift.b.a(this.j, akVar.j)) == 0) {
                                                                                            int compareTo11 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(akVar.n()));
                                                                                            if (compareTo11 == 0) {
                                                                                                if (!n() || (a8 = org.apache.thrift.b.a(this.k, akVar.k)) == 0) {
                                                                                                    int compareTo12 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(akVar.o()));
                                                                                                    if (compareTo12 == 0) {
                                                                                                        if (!o() || (a7 = org.apache.thrift.b.a(this.l, akVar.l)) == 0) {
                                                                                                            int compareTo13 = Boolean.valueOf(p()).compareTo(Boolean.valueOf(akVar.p()));
                                                                                                            if (compareTo13 == 0) {
                                                                                                                if (!p() || (a6 = org.apache.thrift.b.a(this.m, akVar.m)) == 0) {
                                                                                                                    int compareTo14 = Boolean.valueOf(q()).compareTo(Boolean.valueOf(akVar.q()));
                                                                                                                    if (compareTo14 == 0) {
                                                                                                                        if (!q() || (a5 = org.apache.thrift.b.a(this.n, akVar.n)) == 0) {
                                                                                                                            int compareTo15 = Boolean.valueOf(r()).compareTo(Boolean.valueOf(akVar.r()));
                                                                                                                            if (compareTo15 == 0) {
                                                                                                                                if (!r() || (a4 = org.apache.thrift.b.a(this.o, akVar.o)) == 0) {
                                                                                                                                    int compareTo16 = Boolean.valueOf(s()).compareTo(Boolean.valueOf(akVar.s()));
                                                                                                                                    if (compareTo16 == 0) {
                                                                                                                                        if (!s() || (a3 = org.apache.thrift.b.a(this.p, akVar.p)) == 0) {
                                                                                                                                            int compareTo17 = Boolean.valueOf(t()).compareTo(Boolean.valueOf(akVar.t()));
                                                                                                                                            if (compareTo17 == 0) {
                                                                                                                                                if (!t() || (a2 = org.apache.thrift.b.a(this.q, akVar.q)) == 0) {
                                                                                                                                                    int compareTo18 = Boolean.valueOf(u()).compareTo(Boolean.valueOf(akVar.u()));
                                                                                                                                                    if (compareTo18 == 0) {
                                                                                                                                                        if (!u() || (a = org.apache.thrift.b.a(this.r, akVar.r)) == 0) {
                                                                                                                                                            return 0;
                                                                                                                                                        }
                                                                                                                                                        return a;
                                                                                                                                                    }
                                                                                                                                                    return compareTo18;
                                                                                                                                                }
                                                                                                                                                return a2;
                                                                                                                                            }
                                                                                                                                            return compareTo17;
                                                                                                                                        }
                                                                                                                                        return a3;
                                                                                                                                    }
                                                                                                                                    return compareTo16;
                                                                                                                                }
                                                                                                                                return a4;
                                                                                                                            }
                                                                                                                            return compareTo15;
                                                                                                                        }
                                                                                                                        return a5;
                                                                                                                    }
                                                                                                                    return compareTo14;
                                                                                                                }
                                                                                                                return a6;
                                                                                                            }
                                                                                                            return compareTo13;
                                                                                                        }
                                                                                                        return a7;
                                                                                                    }
                                                                                                    return compareTo12;
                                                                                                }
                                                                                                return a8;
                                                                                            }
                                                                                            return compareTo11;
                                                                                        }
                                                                                        return a9;
                                                                                    }
                                                                                    return compareTo10;
                                                                                }
                                                                                return a10;
                                                                            }
                                                                            return compareTo9;
                                                                        }
                                                                        return a11;
                                                                    }
                                                                    return compareTo8;
                                                                }
                                                                return a12;
                                                            }
                                                            return compareTo7;
                                                        }
                                                        return a13;
                                                    }
                                                    return compareTo6;
                                                }
                                                return a14;
                                            }
                                            return compareTo5;
                                        }
                                        return a15;
                                    }
                                    return compareTo4;
                                }
                                return a16;
                            }
                            return compareTo3;
                        }
                        return a17;
                    }
                    return compareTo2;
                }
                return a18;
            }
            return compareTo;
        }
        return getClass().getName().compareTo(akVar.getClass().getName());
    }

    @Override // org.apache.thrift.a
    public void b(org.apache.thrift.protocol.e eVar) {
        v();
        eVar.a(s);
        if (this.a != null && a()) {
            eVar.a(t);
            eVar.a(this.a);
            eVar.b();
        }
        if (this.b != null && b()) {
            eVar.a(u);
            this.b.b(eVar);
            eVar.b();
        }
        if (this.c != null) {
            eVar.a(v);
            eVar.a(this.c);
            eVar.b();
        }
        if (this.d != null) {
            eVar.a(w);
            eVar.a(this.d);
            eVar.b();
        }
        eVar.a(x);
        eVar.a(this.e);
        eVar.b();
        if (this.f != null && h()) {
            eVar.a(y);
            eVar.a(this.f);
            eVar.b();
        }
        if (this.g != null && i()) {
            eVar.a(z);
            eVar.a(this.g);
            eVar.b();
        }
        if (this.h != null && j()) {
            eVar.a(A);
            eVar.a(this.h);
            eVar.b();
        }
        if (this.i != null && l()) {
            eVar.a(B);
            eVar.a(this.i);
            eVar.b();
        }
        if (m()) {
            eVar.a(C);
            eVar.a(this.j);
            eVar.b();
        }
        if (this.k != null && n()) {
            eVar.a(D);
            eVar.a(this.k);
            eVar.b();
        }
        if (this.l != null && o()) {
            eVar.a(E);
            eVar.a(this.l);
            eVar.b();
        }
        if (p()) {
            eVar.a(F);
            eVar.a(this.m);
            eVar.b();
        }
        if (this.n != null && q()) {
            eVar.a(G);
            eVar.a(this.n);
            eVar.b();
        }
        if (r()) {
            eVar.a(H);
            eVar.a(this.o);
            eVar.b();
        }
        if (this.p != null && s()) {
            eVar.a(I);
            eVar.a(this.p);
            eVar.b();
        }
        if (t()) {
            eVar.a(J);
            eVar.a(this.q);
            eVar.b();
        }
        if (this.r != null && u()) {
            eVar.a(K);
            eVar.a(this.r);
            eVar.b();
        }
        eVar.c();
        eVar.a();
    }

    public void b(boolean z2) {
        this.L.set(1, z2);
    }

    public boolean b() {
        return this.b != null;
    }

    public String c() {
        return this.c;
    }

    public void c(boolean z2) {
        this.L.set(2, z2);
    }

    public void d(boolean z2) {
        this.L.set(3, z2);
    }

    public boolean d() {
        return this.c != null;
    }

    public void e(boolean z2) {
        this.L.set(4, z2);
    }

    public boolean e() {
        return this.d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ak)) {
            return a((ak) obj);
        }
        return false;
    }

    public long f() {
        return this.e;
    }

    public boolean g() {
        return this.L.get(0);
    }

    public boolean h() {
        return this.f != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.g != null;
    }

    public boolean j() {
        return this.h != null;
    }

    public String k() {
        return this.i;
    }

    public boolean l() {
        return this.i != null;
    }

    public boolean m() {
        return this.L.get(1);
    }

    public boolean n() {
        return this.k != null;
    }

    public boolean o() {
        return this.l != null;
    }

    public boolean p() {
        return this.L.get(2);
    }

    public boolean q() {
        return this.n != null;
    }

    public boolean r() {
        return this.L.get(3);
    }

    public boolean s() {
        return this.p != null;
    }

    public boolean t() {
        return this.L.get(4);
    }

    public String toString() {
        boolean z2 = false;
        StringBuilder sb = new StringBuilder("XmPushActionRegistrationResult(");
        boolean z3 = true;
        if (a()) {
            sb.append("debug:");
            if (this.a == null) {
                sb.append("null");
            } else {
                sb.append(this.a);
            }
            z3 = false;
        }
        if (b()) {
            if (!z3) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.b == null) {
                sb.append("null");
            } else {
                sb.append(this.b);
            }
        } else {
            z2 = z3;
        }
        if (!z2) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.c == null) {
            sb.append("null");
        } else {
            sb.append(this.c);
        }
        sb.append(", ");
        sb.append("appId:");
        if (this.d == null) {
            sb.append("null");
        } else {
            sb.append(this.d);
        }
        sb.append(", ");
        sb.append("errorCode:");
        sb.append(this.e);
        if (h()) {
            sb.append(", ");
            sb.append("reason:");
            if (this.f == null) {
                sb.append("null");
            } else {
                sb.append(this.f);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("regId:");
            if (this.g == null) {
                sb.append("null");
            } else {
                sb.append(this.g);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("regSecret:");
            if (this.h == null) {
                sb.append("null");
            } else {
                sb.append(this.h);
            }
        }
        if (l()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.i == null) {
                sb.append("null");
            } else {
                sb.append(this.i);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("registeredAt:");
            sb.append(this.j);
        }
        if (n()) {
            sb.append(", ");
            sb.append("aliasName:");
            if (this.k == null) {
                sb.append("null");
            } else {
                sb.append(this.k);
            }
        }
        if (o()) {
            sb.append(", ");
            sb.append("clientId:");
            if (this.l == null) {
                sb.append("null");
            } else {
                sb.append(this.l);
            }
        }
        if (p()) {
            sb.append(", ");
            sb.append("costTime:");
            sb.append(this.m);
        }
        if (q()) {
            sb.append(", ");
            sb.append("appVersion:");
            if (this.n == null) {
                sb.append("null");
            } else {
                sb.append(this.n);
            }
        }
        if (r()) {
            sb.append(", ");
            sb.append("pushSdkVersionCode:");
            sb.append(this.o);
        }
        if (s()) {
            sb.append(", ");
            sb.append("hybridPushEndpoint:");
            if (this.p == null) {
                sb.append("null");
            } else {
                sb.append(this.p);
            }
        }
        if (t()) {
            sb.append(", ");
            sb.append("appVersionCode:");
            sb.append(this.q);
        }
        if (u()) {
            sb.append(", ");
            sb.append("region:");
            if (this.r == null) {
                sb.append("null");
            } else {
                sb.append(this.r);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    public boolean u() {
        return this.r != null;
    }

    public void v() {
        if (this.c == null) {
            throw new org.apache.thrift.protocol.f("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.d == null) {
            throw new org.apache.thrift.protocol.f("Required field 'appId' was not present! Struct: " + toString());
        }
    }
}
