package com.xiaomi.xmpush.thrift;

import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
import org.apache.thrift.TFieldIdEnum;
/* loaded from: classes3.dex */
public class am implements Serializable, Cloneable, org.apache.thrift.a<am, TFieldIdEnum> {
    private static final org.apache.thrift.protocol.j m = new org.apache.thrift.protocol.j("XmPushActionSendMessage");
    private static final org.apache.thrift.protocol.b n = new org.apache.thrift.protocol.b("", (byte) 11, 1);
    private static final org.apache.thrift.protocol.b o = new org.apache.thrift.protocol.b("", (byte) 12, 2);
    private static final org.apache.thrift.protocol.b p = new org.apache.thrift.protocol.b("", (byte) 11, 3);
    private static final org.apache.thrift.protocol.b q = new org.apache.thrift.protocol.b("", (byte) 11, 4);
    private static final org.apache.thrift.protocol.b r = new org.apache.thrift.protocol.b("", (byte) 11, 5);
    private static final org.apache.thrift.protocol.b s = new org.apache.thrift.protocol.b("", (byte) 11, 6);
    private static final org.apache.thrift.protocol.b t = new org.apache.thrift.protocol.b("", (byte) 11, 7);
    private static final org.apache.thrift.protocol.b u = new org.apache.thrift.protocol.b("", (byte) 12, 8);
    private static final org.apache.thrift.protocol.b v = new org.apache.thrift.protocol.b("", (byte) 2, 9);
    private static final org.apache.thrift.protocol.b w = new org.apache.thrift.protocol.b("", (byte) 13, 10);
    private static final org.apache.thrift.protocol.b x = new org.apache.thrift.protocol.b("", (byte) 11, 11);
    private static final org.apache.thrift.protocol.b y = new org.apache.thrift.protocol.b("", (byte) 11, 12);
    public String a;
    public x b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public t h;
    public Map<String, String> j;
    public String k;
    public String l;
    private BitSet z = new BitSet(1);
    public boolean i = true;

    @Override // org.apache.thrift.a
    public void a(org.apache.thrift.protocol.e eVar) {
        eVar.g();
        while (true) {
            org.apache.thrift.protocol.b i = eVar.i();
            if (i.b == 0) {
                eVar.h();
                t();
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
                    if (i.b == 12) {
                        this.h = new t();
                        this.h.a(eVar);
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    }
                case 9:
                    if (i.b == 2) {
                        this.i = eVar.q();
                        a(true);
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    }
                case 10:
                    if (i.b == 13) {
                        org.apache.thrift.protocol.d k = eVar.k();
                        this.j = new HashMap(k.c * 2);
                        for (int i2 = 0; i2 < k.c; i2++) {
                            this.j.put(eVar.w(), eVar.w());
                        }
                        eVar.l();
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
                default:
                    org.apache.thrift.protocol.h.a(eVar, i.b);
                    break;
            }
            eVar.j();
        }
    }

    public void a(boolean z) {
        this.z.set(0, z);
    }

    public boolean a() {
        return this.a != null;
    }

    public boolean a(am amVar) {
        if (amVar == null) {
            return false;
        }
        boolean a = a();
        boolean a2 = amVar.a();
        if ((a || a2) && !(a && a2 && this.a.equals(amVar.a))) {
            return false;
        }
        boolean b = b();
        boolean b2 = amVar.b();
        if ((b || b2) && !(b && b2 && this.b.a(amVar.b))) {
            return false;
        }
        boolean d = d();
        boolean d2 = amVar.d();
        if ((d || d2) && !(d && d2 && this.c.equals(amVar.c))) {
            return false;
        }
        boolean f = f();
        boolean f2 = amVar.f();
        if ((f || f2) && !(f && f2 && this.d.equals(amVar.d))) {
            return false;
        }
        boolean g = g();
        boolean g2 = amVar.g();
        if ((g || g2) && !(g && g2 && this.e.equals(amVar.e))) {
            return false;
        }
        boolean i = i();
        boolean i2 = amVar.i();
        if ((i || i2) && !(i && i2 && this.f.equals(amVar.f))) {
            return false;
        }
        boolean k = k();
        boolean k2 = amVar.k();
        if ((k || k2) && !(k && k2 && this.g.equals(amVar.g))) {
            return false;
        }
        boolean m2 = m();
        boolean m3 = amVar.m();
        if ((m2 || m3) && !(m2 && m3 && this.h.a(amVar.h))) {
            return false;
        }
        boolean n2 = n();
        boolean n3 = amVar.n();
        if ((n2 || n3) && !(n2 && n3 && this.i == amVar.i)) {
            return false;
        }
        boolean o2 = o();
        boolean o3 = amVar.o();
        if ((o2 || o3) && !(o2 && o3 && this.j.equals(amVar.j))) {
            return false;
        }
        boolean q2 = q();
        boolean q3 = amVar.q();
        if ((q2 || q3) && !(q2 && q3 && this.k.equals(amVar.k))) {
            return false;
        }
        boolean s2 = s();
        boolean s3 = amVar.s();
        return !(s2 || s3) || (s2 && s3 && this.l.equals(amVar.l));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: b */
    public int compareTo(am amVar) {
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
        if (getClass().equals(amVar.getClass())) {
            int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(amVar.a()));
            if (compareTo == 0) {
                if (!a() || (a12 = org.apache.thrift.b.a(this.a, amVar.a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(amVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a11 = org.apache.thrift.b.a(this.b, amVar.b)) == 0) {
                            int compareTo3 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(amVar.d()));
                            if (compareTo3 == 0) {
                                if (!d() || (a10 = org.apache.thrift.b.a(this.c, amVar.c)) == 0) {
                                    int compareTo4 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(amVar.f()));
                                    if (compareTo4 == 0) {
                                        if (!f() || (a9 = org.apache.thrift.b.a(this.d, amVar.d)) == 0) {
                                            int compareTo5 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(amVar.g()));
                                            if (compareTo5 == 0) {
                                                if (!g() || (a8 = org.apache.thrift.b.a(this.e, amVar.e)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(amVar.i()));
                                                    if (compareTo6 == 0) {
                                                        if (!i() || (a7 = org.apache.thrift.b.a(this.f, amVar.f)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(amVar.k()));
                                                            if (compareTo7 == 0) {
                                                                if (!k() || (a6 = org.apache.thrift.b.a(this.g, amVar.g)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(amVar.m()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!m() || (a5 = org.apache.thrift.b.a(this.h, amVar.h)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(amVar.n()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!n() || (a4 = org.apache.thrift.b.a(this.i, amVar.i)) == 0) {
                                                                                    int compareTo10 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(amVar.o()));
                                                                                    if (compareTo10 == 0) {
                                                                                        if (!o() || (a3 = org.apache.thrift.b.a(this.j, amVar.j)) == 0) {
                                                                                            int compareTo11 = Boolean.valueOf(q()).compareTo(Boolean.valueOf(amVar.q()));
                                                                                            if (compareTo11 == 0) {
                                                                                                if (!q() || (a2 = org.apache.thrift.b.a(this.k, amVar.k)) == 0) {
                                                                                                    int compareTo12 = Boolean.valueOf(s()).compareTo(Boolean.valueOf(amVar.s()));
                                                                                                    if (compareTo12 == 0) {
                                                                                                        if (!s() || (a = org.apache.thrift.b.a(this.l, amVar.l)) == 0) {
                                                                                                            return 0;
                                                                                                        }
                                                                                                        return a;
                                                                                                    }
                                                                                                    return compareTo12;
                                                                                                }
                                                                                                return a2;
                                                                                            }
                                                                                            return compareTo11;
                                                                                        }
                                                                                        return a3;
                                                                                    }
                                                                                    return compareTo10;
                                                                                }
                                                                                return a4;
                                                                            }
                                                                            return compareTo9;
                                                                        }
                                                                        return a5;
                                                                    }
                                                                    return compareTo8;
                                                                }
                                                                return a6;
                                                            }
                                                            return compareTo7;
                                                        }
                                                        return a7;
                                                    }
                                                    return compareTo6;
                                                }
                                                return a8;
                                            }
                                            return compareTo5;
                                        }
                                        return a9;
                                    }
                                    return compareTo4;
                                }
                                return a10;
                            }
                            return compareTo3;
                        }
                        return a11;
                    }
                    return compareTo2;
                }
                return a12;
            }
            return compareTo;
        }
        return getClass().getName().compareTo(amVar.getClass().getName());
    }

    @Override // org.apache.thrift.a
    public void b(org.apache.thrift.protocol.e eVar) {
        t();
        eVar.a(m);
        if (this.a != null && a()) {
            eVar.a(n);
            eVar.a(this.a);
            eVar.b();
        }
        if (this.b != null && b()) {
            eVar.a(o);
            this.b.b(eVar);
            eVar.b();
        }
        if (this.c != null) {
            eVar.a(p);
            eVar.a(this.c);
            eVar.b();
        }
        if (this.d != null) {
            eVar.a(q);
            eVar.a(this.d);
            eVar.b();
        }
        if (this.e != null && g()) {
            eVar.a(r);
            eVar.a(this.e);
            eVar.b();
        }
        if (this.f != null && i()) {
            eVar.a(s);
            eVar.a(this.f);
            eVar.b();
        }
        if (this.g != null && k()) {
            eVar.a(t);
            eVar.a(this.g);
            eVar.b();
        }
        if (this.h != null && m()) {
            eVar.a(u);
            this.h.b(eVar);
            eVar.b();
        }
        if (n()) {
            eVar.a(v);
            eVar.a(this.i);
            eVar.b();
        }
        if (this.j != null && o()) {
            eVar.a(w);
            eVar.a(new org.apache.thrift.protocol.d((byte) 11, (byte) 11, this.j.size()));
            for (Map.Entry<String, String> entry : this.j.entrySet()) {
                eVar.a(entry.getKey());
                eVar.a(entry.getValue());
            }
            eVar.d();
            eVar.b();
        }
        if (this.k != null && q()) {
            eVar.a(x);
            eVar.a(this.k);
            eVar.b();
        }
        if (this.l != null && s()) {
            eVar.a(y);
            eVar.a(this.l);
            eVar.b();
        }
        eVar.c();
        eVar.a();
    }

    public boolean b() {
        return this.b != null;
    }

    public String c() {
        return this.c;
    }

    public boolean d() {
        return this.c != null;
    }

    public String e() {
        return this.d;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof am)) {
            return a((am) obj);
        }
        return false;
    }

    public boolean f() {
        return this.d != null;
    }

    public boolean g() {
        return this.e != null;
    }

    public String h() {
        return this.f;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f != null;
    }

    public String j() {
        return this.g;
    }

    public boolean k() {
        return this.g != null;
    }

    public t l() {
        return this.h;
    }

    public boolean m() {
        return this.h != null;
    }

    public boolean n() {
        return this.z.get(0);
    }

    public boolean o() {
        return this.j != null;
    }

    public String p() {
        return this.k;
    }

    public boolean q() {
        return this.k != null;
    }

    public String r() {
        return this.l;
    }

    public boolean s() {
        return this.l != null;
    }

    public void t() {
        if (this.c == null) {
            throw new org.apache.thrift.protocol.f("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.d == null) {
            throw new org.apache.thrift.protocol.f("Required field 'appId' was not present! Struct: " + toString());
        }
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionSendMessage(");
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
            sb.append("packageName:");
            if (this.e == null) {
                sb.append("null");
            } else {
                sb.append(this.e);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("topic:");
            if (this.f == null) {
                sb.append("null");
            } else {
                sb.append(this.f);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("aliasName:");
            if (this.g == null) {
                sb.append("null");
            } else {
                sb.append(this.g);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("message:");
            if (this.h == null) {
                sb.append("null");
            } else {
                sb.append(this.h);
            }
        }
        if (n()) {
            sb.append(", ");
            sb.append("needAck:");
            sb.append(this.i);
        }
        if (o()) {
            sb.append(", ");
            sb.append("params:");
            if (this.j == null) {
                sb.append("null");
            } else {
                sb.append(this.j);
            }
        }
        if (q()) {
            sb.append(", ");
            sb.append("category:");
            if (this.k == null) {
                sb.append("null");
            } else {
                sb.append(this.k);
            }
        }
        if (s()) {
            sb.append(", ");
            sb.append("userAccount:");
            if (this.l == null) {
                sb.append("null");
            } else {
                sb.append(this.l);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
