package com.xiaomi.xmpush.thrift;

import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
import org.apache.thrift.TFieldIdEnum;
/* loaded from: classes3.dex */
public class ai implements Serializable, Cloneable, org.apache.thrift.a<ai, TFieldIdEnum> {
    private BitSet F;
    public String a;
    public x b;
    public String c;
    public String d;
    public String e;
    public boolean f;
    public String g;
    public Map<String, String> h;
    public String i;
    public String j;
    public String k;
    public String l;
    public ByteBuffer m;
    public long n;
    public boolean o;
    private static final org.apache.thrift.protocol.j p = new org.apache.thrift.protocol.j("XmPushActionNotification");
    private static final org.apache.thrift.protocol.b q = new org.apache.thrift.protocol.b("", (byte) 11, 1);
    private static final org.apache.thrift.protocol.b r = new org.apache.thrift.protocol.b("", (byte) 12, 2);
    private static final org.apache.thrift.protocol.b s = new org.apache.thrift.protocol.b("", (byte) 11, 3);
    private static final org.apache.thrift.protocol.b t = new org.apache.thrift.protocol.b("", (byte) 11, 4);
    private static final org.apache.thrift.protocol.b u = new org.apache.thrift.protocol.b("", (byte) 11, 5);
    private static final org.apache.thrift.protocol.b v = new org.apache.thrift.protocol.b("", (byte) 2, 6);
    private static final org.apache.thrift.protocol.b w = new org.apache.thrift.protocol.b("", (byte) 11, 7);
    private static final org.apache.thrift.protocol.b x = new org.apache.thrift.protocol.b("", (byte) 13, 8);
    private static final org.apache.thrift.protocol.b y = new org.apache.thrift.protocol.b("", (byte) 11, 9);
    private static final org.apache.thrift.protocol.b z = new org.apache.thrift.protocol.b("", (byte) 11, 10);
    private static final org.apache.thrift.protocol.b A = new org.apache.thrift.protocol.b("", (byte) 11, 12);
    private static final org.apache.thrift.protocol.b B = new org.apache.thrift.protocol.b("", (byte) 11, 13);
    private static final org.apache.thrift.protocol.b C = new org.apache.thrift.protocol.b("", (byte) 11, 14);
    private static final org.apache.thrift.protocol.b D = new org.apache.thrift.protocol.b("", (byte) 10, 15);
    private static final org.apache.thrift.protocol.b E = new org.apache.thrift.protocol.b("", (byte) 2, 20);

    public ai() {
        this.F = new BitSet(3);
        this.f = true;
        this.o = false;
    }

    public ai(String str, boolean z2) {
        this();
        this.c = str;
        this.f = z2;
        b(true);
    }

    public ai a(String str) {
        this.c = str;
        return this;
    }

    public ai a(ByteBuffer byteBuffer) {
        this.m = byteBuffer;
        return this;
    }

    public ai a(Map<String, String> map) {
        this.h = map;
        return this;
    }

    public ai a(boolean z2) {
        this.f = z2;
        b(true);
        return this;
    }

    public ai a(byte[] bArr) {
        a(ByteBuffer.wrap(bArr));
        return this;
    }

    public void a(String str, String str2) {
        if (this.h == null) {
            this.h = new HashMap();
        }
        this.h.put(str, str2);
    }

    @Override // org.apache.thrift.a
    public void a(org.apache.thrift.protocol.e eVar) {
        eVar.g();
        while (true) {
            org.apache.thrift.protocol.b i = eVar.i();
            if (i.b == 0) {
                eVar.h();
                if (!h()) {
                    throw new org.apache.thrift.protocol.f("Required field 'requireAck' was not found in serialized data! Struct: " + toString());
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
                    if (i.b == 11) {
                        this.e = eVar.w();
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    }
                case 6:
                    if (i.b == 2) {
                        this.f = eVar.q();
                        b(true);
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
                    if (i.b == 13) {
                        org.apache.thrift.protocol.d k = eVar.k();
                        this.h = new HashMap(k.c * 2);
                        for (int i2 = 0; i2 < k.c; i2++) {
                            this.h.put(eVar.w(), eVar.w());
                        }
                        eVar.l();
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
                case 16:
                case 17:
                case 18:
                case 19:
                default:
                    org.apache.thrift.protocol.h.a(eVar, i.b);
                    break;
                case 12:
                    if (i.b == 11) {
                        this.k = eVar.w();
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    }
                case 13:
                    if (i.b == 11) {
                        this.l = eVar.w();
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    }
                case 14:
                    if (i.b == 11) {
                        this.m = eVar.x();
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    }
                case 15:
                    if (i.b == 10) {
                        this.n = eVar.u();
                        c(true);
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    }
                case 20:
                    if (i.b == 2) {
                        this.o = eVar.q();
                        d(true);
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    }
            }
            eVar.j();
        }
    }

    public boolean a() {
        return this.a != null;
    }

    public boolean a(ai aiVar) {
        if (aiVar == null) {
            return false;
        }
        boolean a = a();
        boolean a2 = aiVar.a();
        if ((a || a2) && !(a && a2 && this.a.equals(aiVar.a))) {
            return false;
        }
        boolean b = b();
        boolean b2 = aiVar.b();
        if ((b || b2) && !(b && b2 && this.b.a(aiVar.b))) {
            return false;
        }
        boolean d = d();
        boolean d2 = aiVar.d();
        if ((d || d2) && !(d && d2 && this.c.equals(aiVar.c))) {
            return false;
        }
        boolean f = f();
        boolean f2 = aiVar.f();
        if ((f || f2) && !(f && f2 && this.d.equals(aiVar.d))) {
            return false;
        }
        boolean g = g();
        boolean g2 = aiVar.g();
        if (((g || g2) && !(g && g2 && this.e.equals(aiVar.e))) || this.f != aiVar.f) {
            return false;
        }
        boolean i = i();
        boolean i2 = aiVar.i();
        if ((i || i2) && !(i && i2 && this.g.equals(aiVar.g))) {
            return false;
        }
        boolean k = k();
        boolean k2 = aiVar.k();
        if ((k || k2) && !(k && k2 && this.h.equals(aiVar.h))) {
            return false;
        }
        boolean m = m();
        boolean m2 = aiVar.m();
        if ((m || m2) && !(m && m2 && this.i.equals(aiVar.i))) {
            return false;
        }
        boolean n = n();
        boolean n2 = aiVar.n();
        if ((n || n2) && !(n && n2 && this.j.equals(aiVar.j))) {
            return false;
        }
        boolean o = o();
        boolean o2 = aiVar.o();
        if ((o || o2) && !(o && o2 && this.k.equals(aiVar.k))) {
            return false;
        }
        boolean p2 = p();
        boolean p3 = aiVar.p();
        if ((p2 || p3) && !(p2 && p3 && this.l.equals(aiVar.l))) {
            return false;
        }
        boolean r2 = r();
        boolean r3 = aiVar.r();
        if ((r2 || r3) && !(r2 && r3 && this.m.equals(aiVar.m))) {
            return false;
        }
        boolean s2 = s();
        boolean s3 = aiVar.s();
        if ((s2 || s3) && !(s2 && s3 && this.n == aiVar.n)) {
            return false;
        }
        boolean t2 = t();
        boolean t3 = aiVar.t();
        return !(t2 || t3) || (t2 && t3 && this.o == aiVar.o);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: b */
    public int compareTo(ai aiVar) {
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
        if (getClass().equals(aiVar.getClass())) {
            int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(aiVar.a()));
            if (compareTo == 0) {
                if (!a() || (a15 = org.apache.thrift.b.a(this.a, aiVar.a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(aiVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a14 = org.apache.thrift.b.a(this.b, aiVar.b)) == 0) {
                            int compareTo3 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(aiVar.d()));
                            if (compareTo3 == 0) {
                                if (!d() || (a13 = org.apache.thrift.b.a(this.c, aiVar.c)) == 0) {
                                    int compareTo4 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(aiVar.f()));
                                    if (compareTo4 == 0) {
                                        if (!f() || (a12 = org.apache.thrift.b.a(this.d, aiVar.d)) == 0) {
                                            int compareTo5 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(aiVar.g()));
                                            if (compareTo5 == 0) {
                                                if (!g() || (a11 = org.apache.thrift.b.a(this.e, aiVar.e)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(aiVar.h()));
                                                    if (compareTo6 == 0) {
                                                        if (!h() || (a10 = org.apache.thrift.b.a(this.f, aiVar.f)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(aiVar.i()));
                                                            if (compareTo7 == 0) {
                                                                if (!i() || (a9 = org.apache.thrift.b.a(this.g, aiVar.g)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(aiVar.k()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!k() || (a8 = org.apache.thrift.b.a(this.h, aiVar.h)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(aiVar.m()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!m() || (a7 = org.apache.thrift.b.a(this.i, aiVar.i)) == 0) {
                                                                                    int compareTo10 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(aiVar.n()));
                                                                                    if (compareTo10 == 0) {
                                                                                        if (!n() || (a6 = org.apache.thrift.b.a(this.j, aiVar.j)) == 0) {
                                                                                            int compareTo11 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(aiVar.o()));
                                                                                            if (compareTo11 == 0) {
                                                                                                if (!o() || (a5 = org.apache.thrift.b.a(this.k, aiVar.k)) == 0) {
                                                                                                    int compareTo12 = Boolean.valueOf(p()).compareTo(Boolean.valueOf(aiVar.p()));
                                                                                                    if (compareTo12 == 0) {
                                                                                                        if (!p() || (a4 = org.apache.thrift.b.a(this.l, aiVar.l)) == 0) {
                                                                                                            int compareTo13 = Boolean.valueOf(r()).compareTo(Boolean.valueOf(aiVar.r()));
                                                                                                            if (compareTo13 == 0) {
                                                                                                                if (!r() || (a3 = org.apache.thrift.b.a(this.m, aiVar.m)) == 0) {
                                                                                                                    int compareTo14 = Boolean.valueOf(s()).compareTo(Boolean.valueOf(aiVar.s()));
                                                                                                                    if (compareTo14 == 0) {
                                                                                                                        if (!s() || (a2 = org.apache.thrift.b.a(this.n, aiVar.n)) == 0) {
                                                                                                                            int compareTo15 = Boolean.valueOf(t()).compareTo(Boolean.valueOf(aiVar.t()));
                                                                                                                            if (compareTo15 == 0) {
                                                                                                                                if (!t() || (a = org.apache.thrift.b.a(this.o, aiVar.o)) == 0) {
                                                                                                                                    return 0;
                                                                                                                                }
                                                                                                                                return a;
                                                                                                                            }
                                                                                                                            return compareTo15;
                                                                                                                        }
                                                                                                                        return a2;
                                                                                                                    }
                                                                                                                    return compareTo14;
                                                                                                                }
                                                                                                                return a3;
                                                                                                            }
                                                                                                            return compareTo13;
                                                                                                        }
                                                                                                        return a4;
                                                                                                    }
                                                                                                    return compareTo12;
                                                                                                }
                                                                                                return a5;
                                                                                            }
                                                                                            return compareTo11;
                                                                                        }
                                                                                        return a6;
                                                                                    }
                                                                                    return compareTo10;
                                                                                }
                                                                                return a7;
                                                                            }
                                                                            return compareTo9;
                                                                        }
                                                                        return a8;
                                                                    }
                                                                    return compareTo8;
                                                                }
                                                                return a9;
                                                            }
                                                            return compareTo7;
                                                        }
                                                        return a10;
                                                    }
                                                    return compareTo6;
                                                }
                                                return a11;
                                            }
                                            return compareTo5;
                                        }
                                        return a12;
                                    }
                                    return compareTo4;
                                }
                                return a13;
                            }
                            return compareTo3;
                        }
                        return a14;
                    }
                    return compareTo2;
                }
                return a15;
            }
            return compareTo;
        }
        return getClass().getName().compareTo(aiVar.getClass().getName());
    }

    public ai b(String str) {
        this.d = str;
        return this;
    }

    @Override // org.apache.thrift.a
    public void b(org.apache.thrift.protocol.e eVar) {
        u();
        eVar.a(p);
        if (this.a != null && a()) {
            eVar.a(q);
            eVar.a(this.a);
            eVar.b();
        }
        if (this.b != null && b()) {
            eVar.a(r);
            this.b.b(eVar);
            eVar.b();
        }
        if (this.c != null) {
            eVar.a(s);
            eVar.a(this.c);
            eVar.b();
        }
        if (this.d != null && f()) {
            eVar.a(t);
            eVar.a(this.d);
            eVar.b();
        }
        if (this.e != null && g()) {
            eVar.a(u);
            eVar.a(this.e);
            eVar.b();
        }
        eVar.a(v);
        eVar.a(this.f);
        eVar.b();
        if (this.g != null && i()) {
            eVar.a(w);
            eVar.a(this.g);
            eVar.b();
        }
        if (this.h != null && k()) {
            eVar.a(x);
            eVar.a(new org.apache.thrift.protocol.d((byte) 11, (byte) 11, this.h.size()));
            for (Map.Entry<String, String> entry : this.h.entrySet()) {
                eVar.a(entry.getKey());
                eVar.a(entry.getValue());
            }
            eVar.d();
            eVar.b();
        }
        if (this.i != null && m()) {
            eVar.a(y);
            eVar.a(this.i);
            eVar.b();
        }
        if (this.j != null && n()) {
            eVar.a(z);
            eVar.a(this.j);
            eVar.b();
        }
        if (this.k != null && o()) {
            eVar.a(A);
            eVar.a(this.k);
            eVar.b();
        }
        if (this.l != null && p()) {
            eVar.a(B);
            eVar.a(this.l);
            eVar.b();
        }
        if (this.m != null && r()) {
            eVar.a(C);
            eVar.a(this.m);
            eVar.b();
        }
        if (s()) {
            eVar.a(D);
            eVar.a(this.n);
            eVar.b();
        }
        if (t()) {
            eVar.a(E);
            eVar.a(this.o);
            eVar.b();
        }
        eVar.c();
        eVar.a();
    }

    public void b(boolean z2) {
        this.F.set(0, z2);
    }

    public boolean b() {
        return this.b != null;
    }

    public ai c(String str) {
        this.e = str;
        return this;
    }

    public String c() {
        return this.c;
    }

    public void c(boolean z2) {
        this.F.set(1, z2);
    }

    public ai d(String str) {
        this.i = str;
        return this;
    }

    public void d(boolean z2) {
        this.F.set(2, z2);
    }

    public boolean d() {
        return this.c != null;
    }

    public String e() {
        return this.d;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ai)) {
            return a((ai) obj);
        }
        return false;
    }

    public boolean f() {
        return this.d != null;
    }

    public boolean g() {
        return this.e != null;
    }

    public boolean h() {
        return this.F.get(0);
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.g != null;
    }

    public Map<String, String> j() {
        return this.h;
    }

    public boolean k() {
        return this.h != null;
    }

    public String l() {
        return this.i;
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

    public byte[] q() {
        a(org.apache.thrift.b.c(this.m));
        return this.m.array();
    }

    public boolean r() {
        return this.m != null;
    }

    public boolean s() {
        return this.F.get(1);
    }

    public boolean t() {
        return this.F.get(2);
    }

    public String toString() {
        boolean z2 = false;
        StringBuilder sb = new StringBuilder("XmPushActionNotification(");
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
        if (f()) {
            sb.append(", ");
            sb.append("appId:");
            if (this.d == null) {
                sb.append("null");
            } else {
                sb.append(this.d);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("type:");
            if (this.e == null) {
                sb.append("null");
            } else {
                sb.append(this.e);
            }
        }
        sb.append(", ");
        sb.append("requireAck:");
        sb.append(this.f);
        if (i()) {
            sb.append(", ");
            sb.append("payload:");
            if (this.g == null) {
                sb.append("null");
            } else {
                sb.append(this.g);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("extra:");
            if (this.h == null) {
                sb.append("null");
            } else {
                sb.append(this.h);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("packageName:");
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
            sb.append("regId:");
            if (this.k == null) {
                sb.append("null");
            } else {
                sb.append(this.k);
            }
        }
        if (p()) {
            sb.append(", ");
            sb.append("aliasName:");
            if (this.l == null) {
                sb.append("null");
            } else {
                sb.append(this.l);
            }
        }
        if (r()) {
            sb.append(", ");
            sb.append("binaryExtra:");
            if (this.m == null) {
                sb.append("null");
            } else {
                org.apache.thrift.b.a(this.m, sb);
            }
        }
        if (s()) {
            sb.append(", ");
            sb.append("createdTs:");
            sb.append(this.n);
        }
        if (t()) {
            sb.append(", ");
            sb.append("alreadyLogClickInXmq:");
            sb.append(this.o);
        }
        sb.append(")");
        return sb.toString();
    }

    public void u() {
        if (this.c == null) {
            throw new org.apache.thrift.protocol.f("Required field 'id' was not present! Struct: " + toString());
        }
    }
}
