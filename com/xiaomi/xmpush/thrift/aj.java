package com.xiaomi.xmpush.thrift;

import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
import org.apache.thrift.TFieldIdEnum;
/* loaded from: classes3.dex */
public class aj implements Serializable, Cloneable, org.apache.thrift.a<aj, TFieldIdEnum> {
    private static final org.apache.thrift.protocol.j C = new org.apache.thrift.protocol.j("XmPushActionRegistration");
    private static final org.apache.thrift.protocol.b D = new org.apache.thrift.protocol.b("", (byte) 11, 1);
    private static final org.apache.thrift.protocol.b E = new org.apache.thrift.protocol.b("", (byte) 12, 2);
    private static final org.apache.thrift.protocol.b F = new org.apache.thrift.protocol.b("", (byte) 11, 3);
    private static final org.apache.thrift.protocol.b G = new org.apache.thrift.protocol.b("", (byte) 11, 4);
    private static final org.apache.thrift.protocol.b H = new org.apache.thrift.protocol.b("", (byte) 11, 5);
    private static final org.apache.thrift.protocol.b I = new org.apache.thrift.protocol.b("", (byte) 11, 6);
    private static final org.apache.thrift.protocol.b J = new org.apache.thrift.protocol.b("", (byte) 11, 7);
    private static final org.apache.thrift.protocol.b K = new org.apache.thrift.protocol.b("", (byte) 11, 8);
    private static final org.apache.thrift.protocol.b L = new org.apache.thrift.protocol.b("", (byte) 11, 9);
    private static final org.apache.thrift.protocol.b M = new org.apache.thrift.protocol.b("", (byte) 11, 10);
    private static final org.apache.thrift.protocol.b N = new org.apache.thrift.protocol.b("", (byte) 11, 11);
    private static final org.apache.thrift.protocol.b O = new org.apache.thrift.protocol.b("", (byte) 11, 12);
    private static final org.apache.thrift.protocol.b P = new org.apache.thrift.protocol.b("", (byte) 8, 13);
    private static final org.apache.thrift.protocol.b Q = new org.apache.thrift.protocol.b("", (byte) 8, 14);
    private static final org.apache.thrift.protocol.b R = new org.apache.thrift.protocol.b("", (byte) 11, 15);
    private static final org.apache.thrift.protocol.b S = new org.apache.thrift.protocol.b("", (byte) 11, 16);
    private static final org.apache.thrift.protocol.b T = new org.apache.thrift.protocol.b("", (byte) 11, 17);
    private static final org.apache.thrift.protocol.b U = new org.apache.thrift.protocol.b("", (byte) 11, 18);
    private static final org.apache.thrift.protocol.b V = new org.apache.thrift.protocol.b("", (byte) 8, 19);
    private static final org.apache.thrift.protocol.b W = new org.apache.thrift.protocol.b("", (byte) 8, 20);
    private static final org.apache.thrift.protocol.b X = new org.apache.thrift.protocol.b("", (byte) 2, 21);
    private static final org.apache.thrift.protocol.b Y = new org.apache.thrift.protocol.b("", (byte) 10, 22);
    private static final org.apache.thrift.protocol.b Z = new org.apache.thrift.protocol.b("", (byte) 10, 23);
    private static final org.apache.thrift.protocol.b aa = new org.apache.thrift.protocol.b("", (byte) 11, 24);
    private static final org.apache.thrift.protocol.b ab = new org.apache.thrift.protocol.b("", (byte) 11, 25);
    private static final org.apache.thrift.protocol.b ac = new org.apache.thrift.protocol.b("", (byte) 13, 100);
    private static final org.apache.thrift.protocol.b ad = new org.apache.thrift.protocol.b("", (byte) 2, 101);
    private static final org.apache.thrift.protocol.b ae = new org.apache.thrift.protocol.b("", (byte) 11, 102);
    public String B;
    public String a;
    public x b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;
    public String l;
    public int m;
    public int n;
    public String o;
    public String p;
    public String q;
    public String r;
    public int s;
    public w t;
    public long v;
    public long w;
    public String x;
    public String y;
    public Map<String, String> z;
    private BitSet af = new BitSet(7);
    public boolean u = true;
    public boolean A = false;

    public boolean A() {
        return this.x != null;
    }

    public boolean B() {
        return this.y != null;
    }

    public boolean C() {
        return this.z != null;
    }

    public boolean D() {
        return this.af.get(6);
    }

    public boolean E() {
        return this.B != null;
    }

    public void F() {
        if (this.c == null) {
            throw new org.apache.thrift.protocol.f("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.d == null) {
            throw new org.apache.thrift.protocol.f("Required field 'appId' was not present! Struct: " + toString());
        }
        if (this.g == null) {
            throw new org.apache.thrift.protocol.f("Required field 'token' was not present! Struct: " + toString());
        }
    }

    public aj a(int i) {
        this.m = i;
        a(true);
        return this;
    }

    public aj a(w wVar) {
        this.t = wVar;
        return this;
    }

    public aj a(String str) {
        this.c = str;
        return this;
    }

    @Override // org.apache.thrift.a
    public void a(org.apache.thrift.protocol.e eVar) {
        eVar.g();
        while (true) {
            org.apache.thrift.protocol.b i = eVar.i();
            if (i.b == 0) {
                eVar.h();
                F();
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
                    if (i.b == 11) {
                        this.e = eVar.w();
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
                    if (i.b == 11) {
                        this.h = eVar.w();
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
                    if (i.b == 11) {
                        this.k = eVar.w();
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
                    if (i.b == 8) {
                        this.m = eVar.t();
                        a(true);
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    }
                case 14:
                    if (i.b == 8) {
                        this.n = eVar.t();
                        b(true);
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    }
                case 15:
                    if (i.b == 11) {
                        this.o = eVar.w();
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    }
                case 16:
                    if (i.b == 11) {
                        this.p = eVar.w();
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    }
                case 17:
                    if (i.b == 11) {
                        this.q = eVar.w();
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    }
                case 18:
                    if (i.b == 11) {
                        this.r = eVar.w();
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    }
                case 19:
                    if (i.b == 8) {
                        this.s = eVar.t();
                        c(true);
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    }
                case 20:
                    if (i.b == 8) {
                        this.t = w.a(eVar.t());
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    }
                case 21:
                    if (i.b == 2) {
                        this.u = eVar.q();
                        d(true);
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    }
                case 22:
                    if (i.b == 10) {
                        this.v = eVar.u();
                        e(true);
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    }
                case 23:
                    if (i.b == 10) {
                        this.w = eVar.u();
                        f(true);
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    }
                case 24:
                    if (i.b == 11) {
                        this.x = eVar.w();
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    }
                case 25:
                    if (i.b == 11) {
                        this.y = eVar.w();
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    }
                case 100:
                    if (i.b == 13) {
                        org.apache.thrift.protocol.d k = eVar.k();
                        this.z = new HashMap(k.c * 2);
                        for (int i2 = 0; i2 < k.c; i2++) {
                            this.z.put(eVar.w(), eVar.w());
                        }
                        eVar.l();
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    }
                case 101:
                    if (i.b == 2) {
                        this.A = eVar.q();
                        g(true);
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    }
                case 102:
                    if (i.b == 11) {
                        this.B = eVar.w();
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    }
                default:
                    org.apache.thrift.protocol.h.a(eVar, i.b);
                    break;
            }
            eVar.j();
        }
    }

    public void a(boolean z) {
        this.af.set(0, z);
    }

    public boolean a() {
        return this.a != null;
    }

    public boolean a(aj ajVar) {
        if (ajVar == null) {
            return false;
        }
        boolean a = a();
        boolean a2 = ajVar.a();
        if ((a || a2) && !(a && a2 && this.a.equals(ajVar.a))) {
            return false;
        }
        boolean b = b();
        boolean b2 = ajVar.b();
        if ((b || b2) && !(b && b2 && this.b.a(ajVar.b))) {
            return false;
        }
        boolean d = d();
        boolean d2 = ajVar.d();
        if ((d || d2) && !(d && d2 && this.c.equals(ajVar.c))) {
            return false;
        }
        boolean f = f();
        boolean f2 = ajVar.f();
        if ((f || f2) && !(f && f2 && this.d.equals(ajVar.d))) {
            return false;
        }
        boolean g = g();
        boolean g2 = ajVar.g();
        if ((g || g2) && !(g && g2 && this.e.equals(ajVar.e))) {
            return false;
        }
        boolean h = h();
        boolean h2 = ajVar.h();
        if ((h || h2) && !(h && h2 && this.f.equals(ajVar.f))) {
            return false;
        }
        boolean j = j();
        boolean j2 = ajVar.j();
        if ((j || j2) && !(j && j2 && this.g.equals(ajVar.g))) {
            return false;
        }
        boolean k = k();
        boolean k2 = ajVar.k();
        if ((k || k2) && !(k && k2 && this.h.equals(ajVar.h))) {
            return false;
        }
        boolean l = l();
        boolean l2 = ajVar.l();
        if ((l || l2) && !(l && l2 && this.i.equals(ajVar.i))) {
            return false;
        }
        boolean m = m();
        boolean m2 = ajVar.m();
        if ((m || m2) && !(m && m2 && this.j.equals(ajVar.j))) {
            return false;
        }
        boolean n = n();
        boolean n2 = ajVar.n();
        if ((n || n2) && !(n && n2 && this.k.equals(ajVar.k))) {
            return false;
        }
        boolean o = o();
        boolean o2 = ajVar.o();
        if ((o || o2) && !(o && o2 && this.l.equals(ajVar.l))) {
            return false;
        }
        boolean p = p();
        boolean p2 = ajVar.p();
        if ((p || p2) && !(p && p2 && this.m == ajVar.m)) {
            return false;
        }
        boolean q = q();
        boolean q2 = ajVar.q();
        if ((q || q2) && !(q && q2 && this.n == ajVar.n)) {
            return false;
        }
        boolean r = r();
        boolean r2 = ajVar.r();
        if ((r || r2) && !(r && r2 && this.o.equals(ajVar.o))) {
            return false;
        }
        boolean s = s();
        boolean s2 = ajVar.s();
        if ((s || s2) && !(s && s2 && this.p.equals(ajVar.p))) {
            return false;
        }
        boolean t = t();
        boolean t2 = ajVar.t();
        if ((t || t2) && !(t && t2 && this.q.equals(ajVar.q))) {
            return false;
        }
        boolean u = u();
        boolean u2 = ajVar.u();
        if ((u || u2) && !(u && u2 && this.r.equals(ajVar.r))) {
            return false;
        }
        boolean v = v();
        boolean v2 = ajVar.v();
        if ((v || v2) && !(v && v2 && this.s == ajVar.s)) {
            return false;
        }
        boolean w = w();
        boolean w2 = ajVar.w();
        if ((w || w2) && !(w && w2 && this.t.equals(ajVar.t))) {
            return false;
        }
        boolean x = x();
        boolean x2 = ajVar.x();
        if ((x || x2) && !(x && x2 && this.u == ajVar.u)) {
            return false;
        }
        boolean y = y();
        boolean y2 = ajVar.y();
        if ((y || y2) && !(y && y2 && this.v == ajVar.v)) {
            return false;
        }
        boolean z = z();
        boolean z2 = ajVar.z();
        if ((z || z2) && !(z && z2 && this.w == ajVar.w)) {
            return false;
        }
        boolean A = A();
        boolean A2 = ajVar.A();
        if ((A || A2) && !(A && A2 && this.x.equals(ajVar.x))) {
            return false;
        }
        boolean B = B();
        boolean B2 = ajVar.B();
        if ((B || B2) && !(B && B2 && this.y.equals(ajVar.y))) {
            return false;
        }
        boolean C2 = C();
        boolean C3 = ajVar.C();
        if ((C2 || C3) && !(C2 && C3 && this.z.equals(ajVar.z))) {
            return false;
        }
        boolean D2 = D();
        boolean D3 = ajVar.D();
        if ((D2 || D3) && !(D2 && D3 && this.A == ajVar.A)) {
            return false;
        }
        boolean E2 = E();
        boolean E3 = ajVar.E();
        return !(E2 || E3) || (E2 && E3 && this.B.equals(ajVar.B));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: b */
    public int compareTo(aj ajVar) {
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
        int a21;
        int a22;
        int a23;
        int a24;
        int a25;
        int a26;
        int a27;
        int a28;
        if (getClass().equals(ajVar.getClass())) {
            int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(ajVar.a()));
            if (compareTo == 0) {
                if (!a() || (a28 = org.apache.thrift.b.a(this.a, ajVar.a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(ajVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a27 = org.apache.thrift.b.a(this.b, ajVar.b)) == 0) {
                            int compareTo3 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(ajVar.d()));
                            if (compareTo3 == 0) {
                                if (!d() || (a26 = org.apache.thrift.b.a(this.c, ajVar.c)) == 0) {
                                    int compareTo4 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(ajVar.f()));
                                    if (compareTo4 == 0) {
                                        if (!f() || (a25 = org.apache.thrift.b.a(this.d, ajVar.d)) == 0) {
                                            int compareTo5 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ajVar.g()));
                                            if (compareTo5 == 0) {
                                                if (!g() || (a24 = org.apache.thrift.b.a(this.e, ajVar.e)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(ajVar.h()));
                                                    if (compareTo6 == 0) {
                                                        if (!h() || (a23 = org.apache.thrift.b.a(this.f, ajVar.f)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(ajVar.j()));
                                                            if (compareTo7 == 0) {
                                                                if (!j() || (a22 = org.apache.thrift.b.a(this.g, ajVar.g)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(ajVar.k()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!k() || (a21 = org.apache.thrift.b.a(this.h, ajVar.h)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(ajVar.l()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!l() || (a20 = org.apache.thrift.b.a(this.i, ajVar.i)) == 0) {
                                                                                    int compareTo10 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(ajVar.m()));
                                                                                    if (compareTo10 == 0) {
                                                                                        if (!m() || (a19 = org.apache.thrift.b.a(this.j, ajVar.j)) == 0) {
                                                                                            int compareTo11 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(ajVar.n()));
                                                                                            if (compareTo11 == 0) {
                                                                                                if (!n() || (a18 = org.apache.thrift.b.a(this.k, ajVar.k)) == 0) {
                                                                                                    int compareTo12 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(ajVar.o()));
                                                                                                    if (compareTo12 == 0) {
                                                                                                        if (!o() || (a17 = org.apache.thrift.b.a(this.l, ajVar.l)) == 0) {
                                                                                                            int compareTo13 = Boolean.valueOf(p()).compareTo(Boolean.valueOf(ajVar.p()));
                                                                                                            if (compareTo13 == 0) {
                                                                                                                if (!p() || (a16 = org.apache.thrift.b.a(this.m, ajVar.m)) == 0) {
                                                                                                                    int compareTo14 = Boolean.valueOf(q()).compareTo(Boolean.valueOf(ajVar.q()));
                                                                                                                    if (compareTo14 == 0) {
                                                                                                                        if (!q() || (a15 = org.apache.thrift.b.a(this.n, ajVar.n)) == 0) {
                                                                                                                            int compareTo15 = Boolean.valueOf(r()).compareTo(Boolean.valueOf(ajVar.r()));
                                                                                                                            if (compareTo15 == 0) {
                                                                                                                                if (!r() || (a14 = org.apache.thrift.b.a(this.o, ajVar.o)) == 0) {
                                                                                                                                    int compareTo16 = Boolean.valueOf(s()).compareTo(Boolean.valueOf(ajVar.s()));
                                                                                                                                    if (compareTo16 == 0) {
                                                                                                                                        if (!s() || (a13 = org.apache.thrift.b.a(this.p, ajVar.p)) == 0) {
                                                                                                                                            int compareTo17 = Boolean.valueOf(t()).compareTo(Boolean.valueOf(ajVar.t()));
                                                                                                                                            if (compareTo17 == 0) {
                                                                                                                                                if (!t() || (a12 = org.apache.thrift.b.a(this.q, ajVar.q)) == 0) {
                                                                                                                                                    int compareTo18 = Boolean.valueOf(u()).compareTo(Boolean.valueOf(ajVar.u()));
                                                                                                                                                    if (compareTo18 == 0) {
                                                                                                                                                        if (!u() || (a11 = org.apache.thrift.b.a(this.r, ajVar.r)) == 0) {
                                                                                                                                                            int compareTo19 = Boolean.valueOf(v()).compareTo(Boolean.valueOf(ajVar.v()));
                                                                                                                                                            if (compareTo19 == 0) {
                                                                                                                                                                if (!v() || (a10 = org.apache.thrift.b.a(this.s, ajVar.s)) == 0) {
                                                                                                                                                                    int compareTo20 = Boolean.valueOf(w()).compareTo(Boolean.valueOf(ajVar.w()));
                                                                                                                                                                    if (compareTo20 == 0) {
                                                                                                                                                                        if (!w() || (a9 = org.apache.thrift.b.a(this.t, ajVar.t)) == 0) {
                                                                                                                                                                            int compareTo21 = Boolean.valueOf(x()).compareTo(Boolean.valueOf(ajVar.x()));
                                                                                                                                                                            if (compareTo21 == 0) {
                                                                                                                                                                                if (!x() || (a8 = org.apache.thrift.b.a(this.u, ajVar.u)) == 0) {
                                                                                                                                                                                    int compareTo22 = Boolean.valueOf(y()).compareTo(Boolean.valueOf(ajVar.y()));
                                                                                                                                                                                    if (compareTo22 == 0) {
                                                                                                                                                                                        if (!y() || (a7 = org.apache.thrift.b.a(this.v, ajVar.v)) == 0) {
                                                                                                                                                                                            int compareTo23 = Boolean.valueOf(z()).compareTo(Boolean.valueOf(ajVar.z()));
                                                                                                                                                                                            if (compareTo23 == 0) {
                                                                                                                                                                                                if (!z() || (a6 = org.apache.thrift.b.a(this.w, ajVar.w)) == 0) {
                                                                                                                                                                                                    int compareTo24 = Boolean.valueOf(A()).compareTo(Boolean.valueOf(ajVar.A()));
                                                                                                                                                                                                    if (compareTo24 == 0) {
                                                                                                                                                                                                        if (!A() || (a5 = org.apache.thrift.b.a(this.x, ajVar.x)) == 0) {
                                                                                                                                                                                                            int compareTo25 = Boolean.valueOf(B()).compareTo(Boolean.valueOf(ajVar.B()));
                                                                                                                                                                                                            if (compareTo25 == 0) {
                                                                                                                                                                                                                if (!B() || (a4 = org.apache.thrift.b.a(this.y, ajVar.y)) == 0) {
                                                                                                                                                                                                                    int compareTo26 = Boolean.valueOf(C()).compareTo(Boolean.valueOf(ajVar.C()));
                                                                                                                                                                                                                    if (compareTo26 == 0) {
                                                                                                                                                                                                                        if (!C() || (a3 = org.apache.thrift.b.a(this.z, ajVar.z)) == 0) {
                                                                                                                                                                                                                            int compareTo27 = Boolean.valueOf(D()).compareTo(Boolean.valueOf(ajVar.D()));
                                                                                                                                                                                                                            if (compareTo27 == 0) {
                                                                                                                                                                                                                                if (!D() || (a2 = org.apache.thrift.b.a(this.A, ajVar.A)) == 0) {
                                                                                                                                                                                                                                    int compareTo28 = Boolean.valueOf(E()).compareTo(Boolean.valueOf(ajVar.E()));
                                                                                                                                                                                                                                    if (compareTo28 == 0) {
                                                                                                                                                                                                                                        if (!E() || (a = org.apache.thrift.b.a(this.B, ajVar.B)) == 0) {
                                                                                                                                                                                                                                            return 0;
                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                        return a;
                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                    return compareTo28;
                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                return a2;
                                                                                                                                                                                                                            }
                                                                                                                                                                                                                            return compareTo27;
                                                                                                                                                                                                                        }
                                                                                                                                                                                                                        return a3;
                                                                                                                                                                                                                    }
                                                                                                                                                                                                                    return compareTo26;
                                                                                                                                                                                                                }
                                                                                                                                                                                                                return a4;
                                                                                                                                                                                                            }
                                                                                                                                                                                                            return compareTo25;
                                                                                                                                                                                                        }
                                                                                                                                                                                                        return a5;
                                                                                                                                                                                                    }
                                                                                                                                                                                                    return compareTo24;
                                                                                                                                                                                                }
                                                                                                                                                                                                return a6;
                                                                                                                                                                                            }
                                                                                                                                                                                            return compareTo23;
                                                                                                                                                                                        }
                                                                                                                                                                                        return a7;
                                                                                                                                                                                    }
                                                                                                                                                                                    return compareTo22;
                                                                                                                                                                                }
                                                                                                                                                                                return a8;
                                                                                                                                                                            }
                                                                                                                                                                            return compareTo21;
                                                                                                                                                                        }
                                                                                                                                                                        return a9;
                                                                                                                                                                    }
                                                                                                                                                                    return compareTo20;
                                                                                                                                                                }
                                                                                                                                                                return a10;
                                                                                                                                                            }
                                                                                                                                                            return compareTo19;
                                                                                                                                                        }
                                                                                                                                                        return a11;
                                                                                                                                                    }
                                                                                                                                                    return compareTo18;
                                                                                                                                                }
                                                                                                                                                return a12;
                                                                                                                                            }
                                                                                                                                            return compareTo17;
                                                                                                                                        }
                                                                                                                                        return a13;
                                                                                                                                    }
                                                                                                                                    return compareTo16;
                                                                                                                                }
                                                                                                                                return a14;
                                                                                                                            }
                                                                                                                            return compareTo15;
                                                                                                                        }
                                                                                                                        return a15;
                                                                                                                    }
                                                                                                                    return compareTo14;
                                                                                                                }
                                                                                                                return a16;
                                                                                                            }
                                                                                                            return compareTo13;
                                                                                                        }
                                                                                                        return a17;
                                                                                                    }
                                                                                                    return compareTo12;
                                                                                                }
                                                                                                return a18;
                                                                                            }
                                                                                            return compareTo11;
                                                                                        }
                                                                                        return a19;
                                                                                    }
                                                                                    return compareTo10;
                                                                                }
                                                                                return a20;
                                                                            }
                                                                            return compareTo9;
                                                                        }
                                                                        return a21;
                                                                    }
                                                                    return compareTo8;
                                                                }
                                                                return a22;
                                                            }
                                                            return compareTo7;
                                                        }
                                                        return a23;
                                                    }
                                                    return compareTo6;
                                                }
                                                return a24;
                                            }
                                            return compareTo5;
                                        }
                                        return a25;
                                    }
                                    return compareTo4;
                                }
                                return a26;
                            }
                            return compareTo3;
                        }
                        return a27;
                    }
                    return compareTo2;
                }
                return a28;
            }
            return compareTo;
        }
        return getClass().getName().compareTo(ajVar.getClass().getName());
    }

    public aj b(int i) {
        this.n = i;
        b(true);
        return this;
    }

    public aj b(String str) {
        this.d = str;
        return this;
    }

    @Override // org.apache.thrift.a
    public void b(org.apache.thrift.protocol.e eVar) {
        F();
        eVar.a(C);
        if (this.a != null && a()) {
            eVar.a(D);
            eVar.a(this.a);
            eVar.b();
        }
        if (this.b != null && b()) {
            eVar.a(E);
            this.b.b(eVar);
            eVar.b();
        }
        if (this.c != null) {
            eVar.a(F);
            eVar.a(this.c);
            eVar.b();
        }
        if (this.d != null) {
            eVar.a(G);
            eVar.a(this.d);
            eVar.b();
        }
        if (this.e != null && g()) {
            eVar.a(H);
            eVar.a(this.e);
            eVar.b();
        }
        if (this.f != null && h()) {
            eVar.a(I);
            eVar.a(this.f);
            eVar.b();
        }
        if (this.g != null) {
            eVar.a(J);
            eVar.a(this.g);
            eVar.b();
        }
        if (this.h != null && k()) {
            eVar.a(K);
            eVar.a(this.h);
            eVar.b();
        }
        if (this.i != null && l()) {
            eVar.a(L);
            eVar.a(this.i);
            eVar.b();
        }
        if (this.j != null && m()) {
            eVar.a(M);
            eVar.a(this.j);
            eVar.b();
        }
        if (this.k != null && n()) {
            eVar.a(N);
            eVar.a(this.k);
            eVar.b();
        }
        if (this.l != null && o()) {
            eVar.a(O);
            eVar.a(this.l);
            eVar.b();
        }
        if (p()) {
            eVar.a(P);
            eVar.a(this.m);
            eVar.b();
        }
        if (q()) {
            eVar.a(Q);
            eVar.a(this.n);
            eVar.b();
        }
        if (this.o != null && r()) {
            eVar.a(R);
            eVar.a(this.o);
            eVar.b();
        }
        if (this.p != null && s()) {
            eVar.a(S);
            eVar.a(this.p);
            eVar.b();
        }
        if (this.q != null && t()) {
            eVar.a(T);
            eVar.a(this.q);
            eVar.b();
        }
        if (this.r != null && u()) {
            eVar.a(U);
            eVar.a(this.r);
            eVar.b();
        }
        if (v()) {
            eVar.a(V);
            eVar.a(this.s);
            eVar.b();
        }
        if (this.t != null && w()) {
            eVar.a(W);
            eVar.a(this.t.a());
            eVar.b();
        }
        if (x()) {
            eVar.a(X);
            eVar.a(this.u);
            eVar.b();
        }
        if (y()) {
            eVar.a(Y);
            eVar.a(this.v);
            eVar.b();
        }
        if (z()) {
            eVar.a(Z);
            eVar.a(this.w);
            eVar.b();
        }
        if (this.x != null && A()) {
            eVar.a(aa);
            eVar.a(this.x);
            eVar.b();
        }
        if (this.y != null && B()) {
            eVar.a(ab);
            eVar.a(this.y);
            eVar.b();
        }
        if (this.z != null && C()) {
            eVar.a(ac);
            eVar.a(new org.apache.thrift.protocol.d((byte) 11, (byte) 11, this.z.size()));
            for (Map.Entry<String, String> entry : this.z.entrySet()) {
                eVar.a(entry.getKey());
                eVar.a(entry.getValue());
            }
            eVar.d();
            eVar.b();
        }
        if (D()) {
            eVar.a(ad);
            eVar.a(this.A);
            eVar.b();
        }
        if (this.B != null && E()) {
            eVar.a(ae);
            eVar.a(this.B);
            eVar.b();
        }
        eVar.c();
        eVar.a();
    }

    public void b(boolean z) {
        this.af.set(1, z);
    }

    public boolean b() {
        return this.b != null;
    }

    public aj c(int i) {
        this.s = i;
        c(true);
        return this;
    }

    public aj c(String str) {
        this.e = str;
        return this;
    }

    public String c() {
        return this.c;
    }

    public void c(boolean z) {
        this.af.set(2, z);
    }

    public aj d(String str) {
        this.f = str;
        return this;
    }

    public void d(boolean z) {
        this.af.set(3, z);
    }

    public boolean d() {
        return this.c != null;
    }

    public aj e(String str) {
        this.g = str;
        return this;
    }

    public String e() {
        return this.d;
    }

    public void e(boolean z) {
        this.af.set(4, z);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof aj)) {
            return a((aj) obj);
        }
        return false;
    }

    public aj f(String str) {
        this.h = str;
        return this;
    }

    public void f(boolean z) {
        this.af.set(5, z);
    }

    public boolean f() {
        return this.d != null;
    }

    public aj g(String str) {
        this.l = str;
        return this;
    }

    public void g(boolean z) {
        this.af.set(6, z);
    }

    public boolean g() {
        return this.e != null;
    }

    public aj h(String str) {
        this.o = str;
        return this;
    }

    public boolean h() {
        return this.f != null;
    }

    public int hashCode() {
        return 0;
    }

    public aj i(String str) {
        this.p = str;
        return this;
    }

    public String i() {
        return this.g;
    }

    public aj j(String str) {
        this.q = str;
        return this;
    }

    public boolean j() {
        return this.g != null;
    }

    public aj k(String str) {
        this.r = str;
        return this;
    }

    public boolean k() {
        return this.h != null;
    }

    public boolean l() {
        return this.i != null;
    }

    public boolean m() {
        return this.j != null;
    }

    public boolean n() {
        return this.k != null;
    }

    public boolean o() {
        return this.l != null;
    }

    public boolean p() {
        return this.af.get(0);
    }

    public boolean q() {
        return this.af.get(1);
    }

    public boolean r() {
        return this.o != null;
    }

    public boolean s() {
        return this.p != null;
    }

    public boolean t() {
        return this.q != null;
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionRegistration(");
        boolean z2 = true;
        if (a()) {
            sb.append("debug:");
            if (this.a == null) {
                sb.append("null");
            } else {
                sb.append(this.a);
            }
            z2 = false;
        }
        if (b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.b == null) {
                sb.append("null");
            } else {
                sb.append(this.b);
            }
        } else {
            z = z2;
        }
        if (!z) {
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
        if (g()) {
            sb.append(", ");
            sb.append("appVersion:");
            if (this.e == null) {
                sb.append("null");
            } else {
                sb.append(this.e);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f == null) {
                sb.append("null");
            } else {
                sb.append(this.f);
            }
        }
        sb.append(", ");
        sb.append("token:");
        if (this.g == null) {
            sb.append("null");
        } else {
            sb.append(this.g);
        }
        if (k()) {
            sb.append(", ");
            sb.append("deviceId:");
            if (this.h == null) {
                sb.append("null");
            } else {
                sb.append(this.h);
            }
        }
        if (l()) {
            sb.append(", ");
            sb.append("aliasName:");
            if (this.i == null) {
                sb.append("null");
            } else {
                sb.append(this.i);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("sdkVersion:");
            if (this.j == null) {
                sb.append("null");
            } else {
                sb.append(this.j);
            }
        }
        if (n()) {
            sb.append(", ");
            sb.append("regId:");
            if (this.k == null) {
                sb.append("null");
            } else {
                sb.append(this.k);
            }
        }
        if (o()) {
            sb.append(", ");
            sb.append("pushSdkVersionName:");
            if (this.l == null) {
                sb.append("null");
            } else {
                sb.append(this.l);
            }
        }
        if (p()) {
            sb.append(", ");
            sb.append("pushSdkVersionCode:");
            sb.append(this.m);
        }
        if (q()) {
            sb.append(", ");
            sb.append("appVersionCode:");
            sb.append(this.n);
        }
        if (r()) {
            sb.append(", ");
            sb.append("androidId:");
            if (this.o == null) {
                sb.append("null");
            } else {
                sb.append(this.o);
            }
        }
        if (s()) {
            sb.append(", ");
            sb.append("imei:");
            if (this.p == null) {
                sb.append("null");
            } else {
                sb.append(this.p);
            }
        }
        if (t()) {
            sb.append(", ");
            sb.append("serial:");
            if (this.q == null) {
                sb.append("null");
            } else {
                sb.append(this.q);
            }
        }
        if (u()) {
            sb.append(", ");
            sb.append("imeiMd5:");
            if (this.r == null) {
                sb.append("null");
            } else {
                sb.append(this.r);
            }
        }
        if (v()) {
            sb.append(", ");
            sb.append("spaceId:");
            sb.append(this.s);
        }
        if (w()) {
            sb.append(", ");
            sb.append("reason:");
            if (this.t == null) {
                sb.append("null");
            } else {
                sb.append(this.t);
            }
        }
        if (x()) {
            sb.append(", ");
            sb.append("validateToken:");
            sb.append(this.u);
        }
        if (y()) {
            sb.append(", ");
            sb.append("miid:");
            sb.append(this.v);
        }
        if (z()) {
            sb.append(", ");
            sb.append("createdTs:");
            sb.append(this.w);
        }
        if (A()) {
            sb.append(", ");
            sb.append("subImei:");
            if (this.x == null) {
                sb.append("null");
            } else {
                sb.append(this.x);
            }
        }
        if (B()) {
            sb.append(", ");
            sb.append("subImeiMd5:");
            if (this.y == null) {
                sb.append("null");
            } else {
                sb.append(this.y);
            }
        }
        if (C()) {
            sb.append(", ");
            sb.append("connectionAttrs:");
            if (this.z == null) {
                sb.append("null");
            } else {
                sb.append(this.z);
            }
        }
        if (D()) {
            sb.append(", ");
            sb.append("cleanOldRegInfo:");
            sb.append(this.A);
        }
        if (E()) {
            sb.append(", ");
            sb.append("oldRegId:");
            if (this.B == null) {
                sb.append("null");
            } else {
                sb.append(this.B);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    public boolean u() {
        return this.r != null;
    }

    public boolean v() {
        return this.af.get(2);
    }

    public boolean w() {
        return this.t != null;
    }

    public boolean x() {
        return this.af.get(3);
    }

    public boolean y() {
        return this.af.get(4);
    }

    public boolean z() {
        return this.af.get(5);
    }
}
