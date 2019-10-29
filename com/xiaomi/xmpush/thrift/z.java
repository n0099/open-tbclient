package com.xiaomi.xmpush.thrift;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
import org.apache.thrift.TFieldIdEnum;
/* loaded from: classes3.dex */
public class z implements Serializable, Cloneable, org.apache.thrift.a<z, TFieldIdEnum> {
    public String a;
    public x b;
    public String c;
    public String d;
    public long e;
    public String f;
    public String g;
    public am h;
    public String i;
    public String j;
    public String l;
    public String m;
    public String n;
    public short o;
    public short p;
    public String q;
    public String r;
    public int s;
    public Map<String, String> t;
    private static final org.apache.thrift.protocol.j u = new org.apache.thrift.protocol.j("XmPushActionAckMessage");
    private static final org.apache.thrift.protocol.b v = new org.apache.thrift.protocol.b("", Constants.GZIP_CAST_TYPE, 1);
    private static final org.apache.thrift.protocol.b w = new org.apache.thrift.protocol.b("", (byte) 12, 2);
    private static final org.apache.thrift.protocol.b x = new org.apache.thrift.protocol.b("", Constants.GZIP_CAST_TYPE, 3);
    private static final org.apache.thrift.protocol.b y = new org.apache.thrift.protocol.b("", Constants.GZIP_CAST_TYPE, 4);
    private static final org.apache.thrift.protocol.b z = new org.apache.thrift.protocol.b("", (byte) 10, 5);
    private static final org.apache.thrift.protocol.b A = new org.apache.thrift.protocol.b("", Constants.GZIP_CAST_TYPE, 6);
    private static final org.apache.thrift.protocol.b B = new org.apache.thrift.protocol.b("", Constants.GZIP_CAST_TYPE, 7);
    private static final org.apache.thrift.protocol.b C = new org.apache.thrift.protocol.b("", (byte) 12, 8);
    private static final org.apache.thrift.protocol.b D = new org.apache.thrift.protocol.b("", Constants.GZIP_CAST_TYPE, 9);
    private static final org.apache.thrift.protocol.b E = new org.apache.thrift.protocol.b("", Constants.GZIP_CAST_TYPE, 10);
    private static final org.apache.thrift.protocol.b F = new org.apache.thrift.protocol.b("", (byte) 2, 11);
    private static final org.apache.thrift.protocol.b G = new org.apache.thrift.protocol.b("", Constants.GZIP_CAST_TYPE, 12);
    private static final org.apache.thrift.protocol.b H = new org.apache.thrift.protocol.b("", Constants.GZIP_CAST_TYPE, 13);
    private static final org.apache.thrift.protocol.b I = new org.apache.thrift.protocol.b("", Constants.GZIP_CAST_TYPE, 14);
    private static final org.apache.thrift.protocol.b J = new org.apache.thrift.protocol.b("", (byte) 6, 15);
    private static final org.apache.thrift.protocol.b K = new org.apache.thrift.protocol.b("", (byte) 6, 16);
    private static final org.apache.thrift.protocol.b L = new org.apache.thrift.protocol.b("", Constants.GZIP_CAST_TYPE, 20);
    private static final org.apache.thrift.protocol.b M = new org.apache.thrift.protocol.b("", Constants.GZIP_CAST_TYPE, 21);
    private static final org.apache.thrift.protocol.b N = new org.apache.thrift.protocol.b("", (byte) 8, 22);
    private static final org.apache.thrift.protocol.b O = new org.apache.thrift.protocol.b("", (byte) 13, 23);
    private BitSet P = new BitSet(5);
    public boolean k = false;

    public z a(long j) {
        this.e = j;
        a(true);
        return this;
    }

    public z a(String str) {
        this.c = str;
        return this;
    }

    public z a(short s) {
        this.o = s;
        c(true);
        return this;
    }

    @Override // org.apache.thrift.a
    public void a(org.apache.thrift.protocol.e eVar) {
        eVar.g();
        while (true) {
            org.apache.thrift.protocol.b i = eVar.i();
            if (i.b == 0) {
                eVar.h();
                if (!e()) {
                    throw new org.apache.thrift.protocol.f("Required field 'messageTs' was not found in serialized data! Struct: " + toString());
                }
                u();
                return;
            }
            switch (i.c) {
                case 1:
                    if (i.b == 11) {
                        this.a = eVar.w();
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    }
                case 2:
                    if (i.b == 12) {
                        this.b = new x();
                        this.b.a(eVar);
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    }
                case 3:
                    if (i.b == 11) {
                        this.c = eVar.w();
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    }
                case 4:
                    if (i.b == 11) {
                        this.d = eVar.w();
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    }
                case 5:
                    if (i.b == 10) {
                        this.e = eVar.u();
                        a(true);
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    }
                case 6:
                    if (i.b == 11) {
                        this.f = eVar.w();
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    }
                case 7:
                    if (i.b == 11) {
                        this.g = eVar.w();
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    }
                case 8:
                    if (i.b == 12) {
                        this.h = new am();
                        this.h.a(eVar);
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    }
                case 9:
                    if (i.b == 11) {
                        this.i = eVar.w();
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    }
                case 10:
                    if (i.b == 11) {
                        this.j = eVar.w();
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    }
                case 11:
                    if (i.b == 2) {
                        this.k = eVar.q();
                        b(true);
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    }
                case 12:
                    if (i.b == 11) {
                        this.l = eVar.w();
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    }
                case 13:
                    if (i.b == 11) {
                        this.m = eVar.w();
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    }
                case 14:
                    if (i.b == 11) {
                        this.n = eVar.w();
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    }
                case 15:
                    if (i.b == 6) {
                        this.o = eVar.s();
                        c(true);
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    }
                case 16:
                    if (i.b == 6) {
                        this.p = eVar.s();
                        d(true);
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    }
                case 17:
                case 18:
                case 19:
                default:
                    org.apache.thrift.protocol.h.a(eVar, i.b);
                    break;
                case 20:
                    if (i.b == 11) {
                        this.q = eVar.w();
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    }
                case 21:
                    if (i.b == 11) {
                        this.r = eVar.w();
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    }
                case 22:
                    if (i.b == 8) {
                        this.s = eVar.t();
                        e(true);
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    }
                case 23:
                    if (i.b == 13) {
                        org.apache.thrift.protocol.d k = eVar.k();
                        this.t = new HashMap(k.c * 2);
                        for (int i2 = 0; i2 < k.c; i2++) {
                            this.t.put(eVar.w(), eVar.w());
                        }
                        eVar.l();
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    }
            }
            eVar.j();
        }
    }

    public void a(boolean z2) {
        this.P.set(0, z2);
    }

    public boolean a() {
        return this.a != null;
    }

    public boolean a(z zVar) {
        if (zVar == null) {
            return false;
        }
        boolean a = a();
        boolean a2 = zVar.a();
        if ((a || a2) && !(a && a2 && this.a.equals(zVar.a))) {
            return false;
        }
        boolean b = b();
        boolean b2 = zVar.b();
        if ((b || b2) && !(b && b2 && this.b.a(zVar.b))) {
            return false;
        }
        boolean c = c();
        boolean c2 = zVar.c();
        if ((c || c2) && !(c && c2 && this.c.equals(zVar.c))) {
            return false;
        }
        boolean d = d();
        boolean d2 = zVar.d();
        if (((d || d2) && !(d && d2 && this.d.equals(zVar.d))) || this.e != zVar.e) {
            return false;
        }
        boolean f = f();
        boolean f2 = zVar.f();
        if ((f || f2) && !(f && f2 && this.f.equals(zVar.f))) {
            return false;
        }
        boolean g = g();
        boolean g2 = zVar.g();
        if ((g || g2) && !(g && g2 && this.g.equals(zVar.g))) {
            return false;
        }
        boolean h = h();
        boolean h2 = zVar.h();
        if ((h || h2) && !(h && h2 && this.h.a(zVar.h))) {
            return false;
        }
        boolean i = i();
        boolean i2 = zVar.i();
        if ((i || i2) && !(i && i2 && this.i.equals(zVar.i))) {
            return false;
        }
        boolean j = j();
        boolean j2 = zVar.j();
        if ((j || j2) && !(j && j2 && this.j.equals(zVar.j))) {
            return false;
        }
        boolean k = k();
        boolean k2 = zVar.k();
        if ((k || k2) && !(k && k2 && this.k == zVar.k)) {
            return false;
        }
        boolean l = l();
        boolean l2 = zVar.l();
        if ((l || l2) && !(l && l2 && this.l.equals(zVar.l))) {
            return false;
        }
        boolean m = m();
        boolean m2 = zVar.m();
        if ((m || m2) && !(m && m2 && this.m.equals(zVar.m))) {
            return false;
        }
        boolean n = n();
        boolean n2 = zVar.n();
        if ((n || n2) && !(n && n2 && this.n.equals(zVar.n))) {
            return false;
        }
        boolean o = o();
        boolean o2 = zVar.o();
        if ((o || o2) && !(o && o2 && this.o == zVar.o)) {
            return false;
        }
        boolean p = p();
        boolean p2 = zVar.p();
        if ((p || p2) && !(p && p2 && this.p == zVar.p)) {
            return false;
        }
        boolean q = q();
        boolean q2 = zVar.q();
        if ((q || q2) && !(q && q2 && this.q.equals(zVar.q))) {
            return false;
        }
        boolean r = r();
        boolean r2 = zVar.r();
        if ((r || r2) && !(r && r2 && this.r.equals(zVar.r))) {
            return false;
        }
        boolean s = s();
        boolean s2 = zVar.s();
        if ((s || s2) && !(s && s2 && this.s == zVar.s)) {
            return false;
        }
        boolean t = t();
        boolean t2 = zVar.t();
        return !(t || t2) || (t && t2 && this.t.equals(zVar.t));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: b */
    public int compareTo(z zVar) {
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
        int a19;
        int a20;
        if (getClass().equals(zVar.getClass())) {
            int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(zVar.a()));
            if (compareTo == 0) {
                if (!a() || (a20 = org.apache.thrift.b.a(this.a, zVar.a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(zVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a19 = org.apache.thrift.b.a(this.b, zVar.b)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(zVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a18 = org.apache.thrift.b.a(this.c, zVar.c)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(zVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a17 = org.apache.thrift.b.a(this.d, zVar.d)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(zVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a16 = org.apache.thrift.b.a(this.e, zVar.e)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(zVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a15 = org.apache.thrift.b.a(this.f, zVar.f)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(zVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a14 = org.apache.thrift.b.a(this.g, zVar.g)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(zVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a13 = org.apache.thrift.b.a(this.h, zVar.h)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(zVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a12 = org.apache.thrift.b.a(this.i, zVar.i)) == 0) {
                                                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(zVar.j()));
                                                                                    if (compareTo10 == 0) {
                                                                                        if (!j() || (a11 = org.apache.thrift.b.a(this.j, zVar.j)) == 0) {
                                                                                            int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(zVar.k()));
                                                                                            if (compareTo11 == 0) {
                                                                                                if (!k() || (a10 = org.apache.thrift.b.a(this.k, zVar.k)) == 0) {
                                                                                                    int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(zVar.l()));
                                                                                                    if (compareTo12 == 0) {
                                                                                                        if (!l() || (a9 = org.apache.thrift.b.a(this.l, zVar.l)) == 0) {
                                                                                                            int compareTo13 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(zVar.m()));
                                                                                                            if (compareTo13 == 0) {
                                                                                                                if (!m() || (a8 = org.apache.thrift.b.a(this.m, zVar.m)) == 0) {
                                                                                                                    int compareTo14 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(zVar.n()));
                                                                                                                    if (compareTo14 == 0) {
                                                                                                                        if (!n() || (a7 = org.apache.thrift.b.a(this.n, zVar.n)) == 0) {
                                                                                                                            int compareTo15 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(zVar.o()));
                                                                                                                            if (compareTo15 == 0) {
                                                                                                                                if (!o() || (a6 = org.apache.thrift.b.a(this.o, zVar.o)) == 0) {
                                                                                                                                    int compareTo16 = Boolean.valueOf(p()).compareTo(Boolean.valueOf(zVar.p()));
                                                                                                                                    if (compareTo16 == 0) {
                                                                                                                                        if (!p() || (a5 = org.apache.thrift.b.a(this.p, zVar.p)) == 0) {
                                                                                                                                            int compareTo17 = Boolean.valueOf(q()).compareTo(Boolean.valueOf(zVar.q()));
                                                                                                                                            if (compareTo17 == 0) {
                                                                                                                                                if (!q() || (a4 = org.apache.thrift.b.a(this.q, zVar.q)) == 0) {
                                                                                                                                                    int compareTo18 = Boolean.valueOf(r()).compareTo(Boolean.valueOf(zVar.r()));
                                                                                                                                                    if (compareTo18 == 0) {
                                                                                                                                                        if (!r() || (a3 = org.apache.thrift.b.a(this.r, zVar.r)) == 0) {
                                                                                                                                                            int compareTo19 = Boolean.valueOf(s()).compareTo(Boolean.valueOf(zVar.s()));
                                                                                                                                                            if (compareTo19 == 0) {
                                                                                                                                                                if (!s() || (a2 = org.apache.thrift.b.a(this.s, zVar.s)) == 0) {
                                                                                                                                                                    int compareTo20 = Boolean.valueOf(t()).compareTo(Boolean.valueOf(zVar.t()));
                                                                                                                                                                    if (compareTo20 == 0) {
                                                                                                                                                                        if (!t() || (a = org.apache.thrift.b.a(this.t, zVar.t)) == 0) {
                                                                                                                                                                            return 0;
                                                                                                                                                                        }
                                                                                                                                                                        return a;
                                                                                                                                                                    }
                                                                                                                                                                    return compareTo20;
                                                                                                                                                                }
                                                                                                                                                                return a2;
                                                                                                                                                            }
                                                                                                                                                            return compareTo19;
                                                                                                                                                        }
                                                                                                                                                        return a3;
                                                                                                                                                    }
                                                                                                                                                    return compareTo18;
                                                                                                                                                }
                                                                                                                                                return a4;
                                                                                                                                            }
                                                                                                                                            return compareTo17;
                                                                                                                                        }
                                                                                                                                        return a5;
                                                                                                                                    }
                                                                                                                                    return compareTo16;
                                                                                                                                }
                                                                                                                                return a6;
                                                                                                                            }
                                                                                                                            return compareTo15;
                                                                                                                        }
                                                                                                                        return a7;
                                                                                                                    }
                                                                                                                    return compareTo14;
                                                                                                                }
                                                                                                                return a8;
                                                                                                            }
                                                                                                            return compareTo13;
                                                                                                        }
                                                                                                        return a9;
                                                                                                    }
                                                                                                    return compareTo12;
                                                                                                }
                                                                                                return a10;
                                                                                            }
                                                                                            return compareTo11;
                                                                                        }
                                                                                        return a11;
                                                                                    }
                                                                                    return compareTo10;
                                                                                }
                                                                                return a12;
                                                                            }
                                                                            return compareTo9;
                                                                        }
                                                                        return a13;
                                                                    }
                                                                    return compareTo8;
                                                                }
                                                                return a14;
                                                            }
                                                            return compareTo7;
                                                        }
                                                        return a15;
                                                    }
                                                    return compareTo6;
                                                }
                                                return a16;
                                            }
                                            return compareTo5;
                                        }
                                        return a17;
                                    }
                                    return compareTo4;
                                }
                                return a18;
                            }
                            return compareTo3;
                        }
                        return a19;
                    }
                    return compareTo2;
                }
                return a20;
            }
            return compareTo;
        }
        return getClass().getName().compareTo(zVar.getClass().getName());
    }

    public z b(String str) {
        this.d = str;
        return this;
    }

    public z b(short s) {
        this.p = s;
        d(true);
        return this;
    }

    @Override // org.apache.thrift.a
    public void b(org.apache.thrift.protocol.e eVar) {
        u();
        eVar.a(u);
        if (this.a != null && a()) {
            eVar.a(v);
            eVar.a(this.a);
            eVar.b();
        }
        if (this.b != null && b()) {
            eVar.a(w);
            this.b.b(eVar);
            eVar.b();
        }
        if (this.c != null) {
            eVar.a(x);
            eVar.a(this.c);
            eVar.b();
        }
        if (this.d != null) {
            eVar.a(y);
            eVar.a(this.d);
            eVar.b();
        }
        eVar.a(z);
        eVar.a(this.e);
        eVar.b();
        if (this.f != null && f()) {
            eVar.a(A);
            eVar.a(this.f);
            eVar.b();
        }
        if (this.g != null && g()) {
            eVar.a(B);
            eVar.a(this.g);
            eVar.b();
        }
        if (this.h != null && h()) {
            eVar.a(C);
            this.h.b(eVar);
            eVar.b();
        }
        if (this.i != null && i()) {
            eVar.a(D);
            eVar.a(this.i);
            eVar.b();
        }
        if (this.j != null && j()) {
            eVar.a(E);
            eVar.a(this.j);
            eVar.b();
        }
        if (k()) {
            eVar.a(F);
            eVar.a(this.k);
            eVar.b();
        }
        if (this.l != null && l()) {
            eVar.a(G);
            eVar.a(this.l);
            eVar.b();
        }
        if (this.m != null && m()) {
            eVar.a(H);
            eVar.a(this.m);
            eVar.b();
        }
        if (this.n != null && n()) {
            eVar.a(I);
            eVar.a(this.n);
            eVar.b();
        }
        if (o()) {
            eVar.a(J);
            eVar.a(this.o);
            eVar.b();
        }
        if (p()) {
            eVar.a(K);
            eVar.a(this.p);
            eVar.b();
        }
        if (this.q != null && q()) {
            eVar.a(L);
            eVar.a(this.q);
            eVar.b();
        }
        if (this.r != null && r()) {
            eVar.a(M);
            eVar.a(this.r);
            eVar.b();
        }
        if (s()) {
            eVar.a(N);
            eVar.a(this.s);
            eVar.b();
        }
        if (this.t != null && t()) {
            eVar.a(O);
            eVar.a(new org.apache.thrift.protocol.d(Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, this.t.size()));
            for (Map.Entry<String, String> entry : this.t.entrySet()) {
                eVar.a(entry.getKey());
                eVar.a(entry.getValue());
            }
            eVar.d();
            eVar.b();
        }
        eVar.c();
        eVar.a();
    }

    public void b(boolean z2) {
        this.P.set(1, z2);
    }

    public boolean b() {
        return this.b != null;
    }

    public z c(String str) {
        this.f = str;
        return this;
    }

    public void c(boolean z2) {
        this.P.set(2, z2);
    }

    public boolean c() {
        return this.c != null;
    }

    public z d(String str) {
        this.g = str;
        return this;
    }

    public void d(boolean z2) {
        this.P.set(3, z2);
    }

    public boolean d() {
        return this.d != null;
    }

    public void e(boolean z2) {
        this.P.set(4, z2);
    }

    public boolean e() {
        return this.P.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof z)) {
            return a((z) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f != null;
    }

    public boolean g() {
        return this.g != null;
    }

    public boolean h() {
        return this.h != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.i != null;
    }

    public boolean j() {
        return this.j != null;
    }

    public boolean k() {
        return this.P.get(1);
    }

    public boolean l() {
        return this.l != null;
    }

    public boolean m() {
        return this.m != null;
    }

    public boolean n() {
        return this.n != null;
    }

    public boolean o() {
        return this.P.get(2);
    }

    public boolean p() {
        return this.P.get(3);
    }

    public boolean q() {
        return this.q != null;
    }

    public boolean r() {
        return this.r != null;
    }

    public boolean s() {
        return this.P.get(4);
    }

    public boolean t() {
        return this.t != null;
    }

    public String toString() {
        boolean z2 = false;
        StringBuilder sb = new StringBuilder("XmPushActionAckMessage(");
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
        sb.append("messageTs:");
        sb.append(this.e);
        if (f()) {
            sb.append(", ");
            sb.append(UrlSchemaHelper.SCHEMA_TYPE_TOPIC);
            if (this.f == null) {
                sb.append("null");
            } else {
                sb.append(this.f);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("aliasName:");
            if (this.g == null) {
                sb.append("null");
            } else {
                sb.append(this.g);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("request:");
            if (this.h == null) {
                sb.append("null");
            } else {
                sb.append(this.h);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.i == null) {
                sb.append("null");
            } else {
                sb.append(this.i);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("category:");
            if (this.j == null) {
                sb.append("null");
            } else {
                sb.append(this.j);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("isOnline:");
            sb.append(this.k);
        }
        if (l()) {
            sb.append(", ");
            sb.append("regId:");
            if (this.l == null) {
                sb.append("null");
            } else {
                sb.append(this.l);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("callbackUrl:");
            if (this.m == null) {
                sb.append("null");
            } else {
                sb.append(this.m);
            }
        }
        if (n()) {
            sb.append(", ");
            sb.append("userAccount:");
            if (this.n == null) {
                sb.append("null");
            } else {
                sb.append(this.n);
            }
        }
        if (o()) {
            sb.append(", ");
            sb.append("deviceStatus:");
            sb.append((int) this.o);
        }
        if (p()) {
            sb.append(", ");
            sb.append("geoMsgStatus:");
            sb.append((int) this.p);
        }
        if (q()) {
            sb.append(", ");
            sb.append("imeiMd5:");
            if (this.q == null) {
                sb.append("null");
            } else {
                sb.append(this.q);
            }
        }
        if (r()) {
            sb.append(", ");
            sb.append("deviceId:");
            if (this.r == null) {
                sb.append("null");
            } else {
                sb.append(this.r);
            }
        }
        if (s()) {
            sb.append(", ");
            sb.append("passThrough:");
            sb.append(this.s);
        }
        if (t()) {
            sb.append(", ");
            sb.append("extra:");
            if (this.t == null) {
                sb.append("null");
            } else {
                sb.append(this.t);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    public void u() {
        if (this.c == null) {
            throw new org.apache.thrift.protocol.f("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.d == null) {
            throw new org.apache.thrift.protocol.f("Required field 'appId' was not present! Struct: " + toString());
        }
    }
}
