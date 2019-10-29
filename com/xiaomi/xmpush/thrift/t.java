package com.xiaomi.xmpush.thrift;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import java.io.Serializable;
import java.util.BitSet;
import org.apache.thrift.TFieldIdEnum;
/* loaded from: classes3.dex */
public class t implements Serializable, Cloneable, org.apache.thrift.a<t, TFieldIdEnum> {
    public x a;
    public String b;
    public String c;
    public String d;
    public long e;
    public long f;
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;
    public u l;
    public String m;
    public String o;
    public long p;
    public String q;
    public String r;
    private static final org.apache.thrift.protocol.j s = new org.apache.thrift.protocol.j("PushMessage");
    private static final org.apache.thrift.protocol.b t = new org.apache.thrift.protocol.b("", (byte) 12, 1);
    private static final org.apache.thrift.protocol.b u = new org.apache.thrift.protocol.b("", Constants.GZIP_CAST_TYPE, 2);
    private static final org.apache.thrift.protocol.b v = new org.apache.thrift.protocol.b("", Constants.GZIP_CAST_TYPE, 3);
    private static final org.apache.thrift.protocol.b w = new org.apache.thrift.protocol.b("", Constants.GZIP_CAST_TYPE, 4);
    private static final org.apache.thrift.protocol.b x = new org.apache.thrift.protocol.b("", (byte) 10, 5);
    private static final org.apache.thrift.protocol.b y = new org.apache.thrift.protocol.b("", (byte) 10, 6);
    private static final org.apache.thrift.protocol.b z = new org.apache.thrift.protocol.b("", Constants.GZIP_CAST_TYPE, 7);
    private static final org.apache.thrift.protocol.b A = new org.apache.thrift.protocol.b("", Constants.GZIP_CAST_TYPE, 8);
    private static final org.apache.thrift.protocol.b B = new org.apache.thrift.protocol.b("", Constants.GZIP_CAST_TYPE, 9);
    private static final org.apache.thrift.protocol.b C = new org.apache.thrift.protocol.b("", Constants.GZIP_CAST_TYPE, 10);
    private static final org.apache.thrift.protocol.b D = new org.apache.thrift.protocol.b("", Constants.GZIP_CAST_TYPE, 11);
    private static final org.apache.thrift.protocol.b E = new org.apache.thrift.protocol.b("", (byte) 12, 12);
    private static final org.apache.thrift.protocol.b F = new org.apache.thrift.protocol.b("", Constants.GZIP_CAST_TYPE, 13);
    private static final org.apache.thrift.protocol.b G = new org.apache.thrift.protocol.b("", (byte) 2, 14);
    private static final org.apache.thrift.protocol.b H = new org.apache.thrift.protocol.b("", Constants.GZIP_CAST_TYPE, 15);
    private static final org.apache.thrift.protocol.b I = new org.apache.thrift.protocol.b("", (byte) 10, 16);
    private static final org.apache.thrift.protocol.b J = new org.apache.thrift.protocol.b("", Constants.GZIP_CAST_TYPE, 20);
    private static final org.apache.thrift.protocol.b K = new org.apache.thrift.protocol.b("", Constants.GZIP_CAST_TYPE, 21);
    private BitSet L = new BitSet(4);
    public boolean n = false;

    @Override // org.apache.thrift.a
    public void a(org.apache.thrift.protocol.e eVar) {
        eVar.g();
        while (true) {
            org.apache.thrift.protocol.b i = eVar.i();
            if (i.b == 0) {
                eVar.h();
                w();
                return;
            }
            switch (i.c) {
                case 1:
                    if (i.b != 12) {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    } else {
                        this.a = new x();
                        this.a.a(eVar);
                        break;
                    }
                case 2:
                    if (i.b != 11) {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    } else {
                        this.b = eVar.w();
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
                    if (i.b != 10) {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    } else {
                        this.e = eVar.u();
                        a(true);
                        break;
                    }
                case 6:
                    if (i.b != 10) {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    } else {
                        this.f = eVar.u();
                        b(true);
                        break;
                    }
                case 7:
                    if (i.b != 11) {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    } else {
                        this.g = eVar.w();
                        break;
                    }
                case 8:
                    if (i.b != 11) {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    } else {
                        this.h = eVar.w();
                        break;
                    }
                case 9:
                    if (i.b != 11) {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    } else {
                        this.i = eVar.w();
                        break;
                    }
                case 10:
                    if (i.b != 11) {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    } else {
                        this.j = eVar.w();
                        break;
                    }
                case 11:
                    if (i.b != 11) {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    } else {
                        this.k = eVar.w();
                        break;
                    }
                case 12:
                    if (i.b != 12) {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    } else {
                        this.l = new u();
                        this.l.a(eVar);
                        break;
                    }
                case 13:
                    if (i.b != 11) {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    } else {
                        this.m = eVar.w();
                        break;
                    }
                case 14:
                    if (i.b != 2) {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    } else {
                        this.n = eVar.q();
                        c(true);
                        break;
                    }
                case 15:
                    if (i.b != 11) {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    } else {
                        this.o = eVar.w();
                        break;
                    }
                case 16:
                    if (i.b != 10) {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    } else {
                        this.p = eVar.u();
                        d(true);
                        break;
                    }
                case 17:
                case 18:
                case 19:
                default:
                    org.apache.thrift.protocol.h.a(eVar, i.b);
                    break;
                case 20:
                    if (i.b != 11) {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    } else {
                        this.q = eVar.w();
                        break;
                    }
                case 21:
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

    public boolean a(t tVar) {
        if (tVar == null) {
            return false;
        }
        boolean a = a();
        boolean a2 = tVar.a();
        if ((a || a2) && !(a && a2 && this.a.a(tVar.a))) {
            return false;
        }
        boolean c = c();
        boolean c2 = tVar.c();
        if ((c || c2) && !(c && c2 && this.b.equals(tVar.b))) {
            return false;
        }
        boolean e = e();
        boolean e2 = tVar.e();
        if ((e || e2) && !(e && e2 && this.c.equals(tVar.c))) {
            return false;
        }
        boolean g = g();
        boolean g2 = tVar.g();
        if ((g || g2) && !(g && g2 && this.d.equals(tVar.d))) {
            return false;
        }
        boolean i = i();
        boolean i2 = tVar.i();
        if ((i || i2) && !(i && i2 && this.e == tVar.e)) {
            return false;
        }
        boolean j = j();
        boolean j2 = tVar.j();
        if ((j || j2) && !(j && j2 && this.f == tVar.f)) {
            return false;
        }
        boolean k = k();
        boolean k2 = tVar.k();
        if ((k || k2) && !(k && k2 && this.g.equals(tVar.g))) {
            return false;
        }
        boolean l = l();
        boolean l2 = tVar.l();
        if ((l || l2) && !(l && l2 && this.h.equals(tVar.h))) {
            return false;
        }
        boolean m = m();
        boolean m2 = tVar.m();
        if ((m || m2) && !(m && m2 && this.i.equals(tVar.i))) {
            return false;
        }
        boolean n = n();
        boolean n2 = tVar.n();
        if ((n || n2) && !(n && n2 && this.j.equals(tVar.j))) {
            return false;
        }
        boolean o = o();
        boolean o2 = tVar.o();
        if ((o || o2) && !(o && o2 && this.k.equals(tVar.k))) {
            return false;
        }
        boolean p = p();
        boolean p2 = tVar.p();
        if ((p || p2) && !(p && p2 && this.l.a(tVar.l))) {
            return false;
        }
        boolean q = q();
        boolean q2 = tVar.q();
        if ((q || q2) && !(q && q2 && this.m.equals(tVar.m))) {
            return false;
        }
        boolean r = r();
        boolean r2 = tVar.r();
        if ((r || r2) && !(r && r2 && this.n == tVar.n)) {
            return false;
        }
        boolean s2 = s();
        boolean s3 = tVar.s();
        if ((s2 || s3) && !(s2 && s3 && this.o.equals(tVar.o))) {
            return false;
        }
        boolean t2 = t();
        boolean t3 = tVar.t();
        if ((t2 || t3) && !(t2 && t3 && this.p == tVar.p)) {
            return false;
        }
        boolean u2 = u();
        boolean u3 = tVar.u();
        if ((u2 || u3) && !(u2 && u3 && this.q.equals(tVar.q))) {
            return false;
        }
        boolean v2 = v();
        boolean v3 = tVar.v();
        return !(v2 || v3) || (v2 && v3 && this.r.equals(tVar.r));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: b */
    public int compareTo(t tVar) {
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
        if (getClass().equals(tVar.getClass())) {
            int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(tVar.a()));
            if (compareTo == 0) {
                if (!a() || (a18 = org.apache.thrift.b.a(this.a, tVar.a)) == 0) {
                    int compareTo2 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(tVar.c()));
                    if (compareTo2 == 0) {
                        if (!c() || (a17 = org.apache.thrift.b.a(this.b, tVar.b)) == 0) {
                            int compareTo3 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(tVar.e()));
                            if (compareTo3 == 0) {
                                if (!e() || (a16 = org.apache.thrift.b.a(this.c, tVar.c)) == 0) {
                                    int compareTo4 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(tVar.g()));
                                    if (compareTo4 == 0) {
                                        if (!g() || (a15 = org.apache.thrift.b.a(this.d, tVar.d)) == 0) {
                                            int compareTo5 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(tVar.i()));
                                            if (compareTo5 == 0) {
                                                if (!i() || (a14 = org.apache.thrift.b.a(this.e, tVar.e)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(tVar.j()));
                                                    if (compareTo6 == 0) {
                                                        if (!j() || (a13 = org.apache.thrift.b.a(this.f, tVar.f)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(tVar.k()));
                                                            if (compareTo7 == 0) {
                                                                if (!k() || (a12 = org.apache.thrift.b.a(this.g, tVar.g)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(tVar.l()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!l() || (a11 = org.apache.thrift.b.a(this.h, tVar.h)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(tVar.m()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!m() || (a10 = org.apache.thrift.b.a(this.i, tVar.i)) == 0) {
                                                                                    int compareTo10 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(tVar.n()));
                                                                                    if (compareTo10 == 0) {
                                                                                        if (!n() || (a9 = org.apache.thrift.b.a(this.j, tVar.j)) == 0) {
                                                                                            int compareTo11 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(tVar.o()));
                                                                                            if (compareTo11 == 0) {
                                                                                                if (!o() || (a8 = org.apache.thrift.b.a(this.k, tVar.k)) == 0) {
                                                                                                    int compareTo12 = Boolean.valueOf(p()).compareTo(Boolean.valueOf(tVar.p()));
                                                                                                    if (compareTo12 == 0) {
                                                                                                        if (!p() || (a7 = org.apache.thrift.b.a(this.l, tVar.l)) == 0) {
                                                                                                            int compareTo13 = Boolean.valueOf(q()).compareTo(Boolean.valueOf(tVar.q()));
                                                                                                            if (compareTo13 == 0) {
                                                                                                                if (!q() || (a6 = org.apache.thrift.b.a(this.m, tVar.m)) == 0) {
                                                                                                                    int compareTo14 = Boolean.valueOf(r()).compareTo(Boolean.valueOf(tVar.r()));
                                                                                                                    if (compareTo14 == 0) {
                                                                                                                        if (!r() || (a5 = org.apache.thrift.b.a(this.n, tVar.n)) == 0) {
                                                                                                                            int compareTo15 = Boolean.valueOf(s()).compareTo(Boolean.valueOf(tVar.s()));
                                                                                                                            if (compareTo15 == 0) {
                                                                                                                                if (!s() || (a4 = org.apache.thrift.b.a(this.o, tVar.o)) == 0) {
                                                                                                                                    int compareTo16 = Boolean.valueOf(t()).compareTo(Boolean.valueOf(tVar.t()));
                                                                                                                                    if (compareTo16 == 0) {
                                                                                                                                        if (!t() || (a3 = org.apache.thrift.b.a(this.p, tVar.p)) == 0) {
                                                                                                                                            int compareTo17 = Boolean.valueOf(u()).compareTo(Boolean.valueOf(tVar.u()));
                                                                                                                                            if (compareTo17 == 0) {
                                                                                                                                                if (!u() || (a2 = org.apache.thrift.b.a(this.q, tVar.q)) == 0) {
                                                                                                                                                    int compareTo18 = Boolean.valueOf(v()).compareTo(Boolean.valueOf(tVar.v()));
                                                                                                                                                    if (compareTo18 == 0) {
                                                                                                                                                        if (!v() || (a = org.apache.thrift.b.a(this.r, tVar.r)) == 0) {
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
        return getClass().getName().compareTo(tVar.getClass().getName());
    }

    public String b() {
        return this.b;
    }

    @Override // org.apache.thrift.a
    public void b(org.apache.thrift.protocol.e eVar) {
        w();
        eVar.a(s);
        if (this.a != null && a()) {
            eVar.a(t);
            this.a.b(eVar);
            eVar.b();
        }
        if (this.b != null) {
            eVar.a(u);
            eVar.a(this.b);
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
        if (i()) {
            eVar.a(x);
            eVar.a(this.e);
            eVar.b();
        }
        if (j()) {
            eVar.a(y);
            eVar.a(this.f);
            eVar.b();
        }
        if (this.g != null && k()) {
            eVar.a(z);
            eVar.a(this.g);
            eVar.b();
        }
        if (this.h != null && l()) {
            eVar.a(A);
            eVar.a(this.h);
            eVar.b();
        }
        if (this.i != null && m()) {
            eVar.a(B);
            eVar.a(this.i);
            eVar.b();
        }
        if (this.j != null && n()) {
            eVar.a(C);
            eVar.a(this.j);
            eVar.b();
        }
        if (this.k != null && o()) {
            eVar.a(D);
            eVar.a(this.k);
            eVar.b();
        }
        if (this.l != null && p()) {
            eVar.a(E);
            this.l.b(eVar);
            eVar.b();
        }
        if (this.m != null && q()) {
            eVar.a(F);
            eVar.a(this.m);
            eVar.b();
        }
        if (r()) {
            eVar.a(G);
            eVar.a(this.n);
            eVar.b();
        }
        if (this.o != null && s()) {
            eVar.a(H);
            eVar.a(this.o);
            eVar.b();
        }
        if (t()) {
            eVar.a(I);
            eVar.a(this.p);
            eVar.b();
        }
        if (this.q != null && u()) {
            eVar.a(J);
            eVar.a(this.q);
            eVar.b();
        }
        if (this.r != null && v()) {
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

    public void c(boolean z2) {
        this.L.set(2, z2);
    }

    public boolean c() {
        return this.b != null;
    }

    public String d() {
        return this.c;
    }

    public void d(boolean z2) {
        this.L.set(3, z2);
    }

    public boolean e() {
        return this.c != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof t)) {
            return a((t) obj);
        }
        return false;
    }

    public String f() {
        return this.d;
    }

    public boolean g() {
        return this.d != null;
    }

    public long h() {
        return this.e;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.L.get(0);
    }

    public boolean j() {
        return this.L.get(1);
    }

    public boolean k() {
        return this.g != null;
    }

    public boolean l() {
        return this.h != null;
    }

    public boolean m() {
        return this.i != null;
    }

    public boolean n() {
        return this.j != null;
    }

    public boolean o() {
        return this.k != null;
    }

    public boolean p() {
        return this.l != null;
    }

    public boolean q() {
        return this.m != null;
    }

    public boolean r() {
        return this.L.get(2);
    }

    public boolean s() {
        return this.o != null;
    }

    public boolean t() {
        return this.L.get(3);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("PushMessage(");
        boolean z2 = true;
        if (a()) {
            sb.append("to:");
            if (this.a == null) {
                sb.append("null");
            } else {
                sb.append(this.a);
            }
            z2 = false;
        }
        if (!z2) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.b == null) {
            sb.append("null");
        } else {
            sb.append(this.b);
        }
        sb.append(", ");
        sb.append("appId:");
        if (this.c == null) {
            sb.append("null");
        } else {
            sb.append(this.c);
        }
        sb.append(", ");
        sb.append("payload:");
        if (this.d == null) {
            sb.append("null");
        } else {
            sb.append(this.d);
        }
        if (i()) {
            sb.append(", ");
            sb.append("createAt:");
            sb.append(this.e);
        }
        if (j()) {
            sb.append(", ");
            sb.append("ttl:");
            sb.append(this.f);
        }
        if (k()) {
            sb.append(", ");
            sb.append("collapseKey:");
            if (this.g == null) {
                sb.append("null");
            } else {
                sb.append(this.g);
            }
        }
        if (l()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.h == null) {
                sb.append("null");
            } else {
                sb.append(this.h);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("regId:");
            if (this.i == null) {
                sb.append("null");
            } else {
                sb.append(this.i);
            }
        }
        if (n()) {
            sb.append(", ");
            sb.append("category:");
            if (this.j == null) {
                sb.append("null");
            } else {
                sb.append(this.j);
            }
        }
        if (o()) {
            sb.append(", ");
            sb.append(UrlSchemaHelper.SCHEMA_TYPE_TOPIC);
            if (this.k == null) {
                sb.append("null");
            } else {
                sb.append(this.k);
            }
        }
        if (p()) {
            sb.append(", ");
            sb.append("metaInfo:");
            if (this.l == null) {
                sb.append("null");
            } else {
                sb.append(this.l);
            }
        }
        if (q()) {
            sb.append(", ");
            sb.append("aliasName:");
            if (this.m == null) {
                sb.append("null");
            } else {
                sb.append(this.m);
            }
        }
        if (r()) {
            sb.append(", ");
            sb.append("isOnline:");
            sb.append(this.n);
        }
        if (s()) {
            sb.append(", ");
            sb.append("userAccount:");
            if (this.o == null) {
                sb.append("null");
            } else {
                sb.append(this.o);
            }
        }
        if (t()) {
            sb.append(", ");
            sb.append("miid:");
            sb.append(this.p);
        }
        if (u()) {
            sb.append(", ");
            sb.append("imeiMd5:");
            if (this.q == null) {
                sb.append("null");
            } else {
                sb.append(this.q);
            }
        }
        if (v()) {
            sb.append(", ");
            sb.append("deviceId:");
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
        return this.q != null;
    }

    public boolean v() {
        return this.r != null;
    }

    public void w() {
        if (this.b == null) {
            throw new org.apache.thrift.protocol.f("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.c == null) {
            throw new org.apache.thrift.protocol.f("Required field 'appId' was not present! Struct: " + toString());
        }
        if (this.d == null) {
            throw new org.apache.thrift.protocol.f("Required field 'payload' was not present! Struct: " + toString());
        }
    }
}
