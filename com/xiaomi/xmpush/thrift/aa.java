package com.xiaomi.xmpush.thrift;

import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
import org.apache.thrift.TFieldIdEnum;
/* loaded from: classes3.dex */
public class aa implements Serializable, Cloneable, org.apache.thrift.a<aa, TFieldIdEnum> {
    private static final org.apache.thrift.protocol.j k = new org.apache.thrift.protocol.j("XmPushActionAckNotification");
    private static final org.apache.thrift.protocol.b l = new org.apache.thrift.protocol.b("", (byte) 11, 1);
    private static final org.apache.thrift.protocol.b m = new org.apache.thrift.protocol.b("", (byte) 12, 2);
    private static final org.apache.thrift.protocol.b n = new org.apache.thrift.protocol.b("", (byte) 11, 3);
    private static final org.apache.thrift.protocol.b o = new org.apache.thrift.protocol.b("", (byte) 11, 4);
    private static final org.apache.thrift.protocol.b p = new org.apache.thrift.protocol.b("", (byte) 11, 5);
    private static final org.apache.thrift.protocol.b q = new org.apache.thrift.protocol.b("", (byte) 10, 7);
    private static final org.apache.thrift.protocol.b r = new org.apache.thrift.protocol.b("", (byte) 11, 8);
    private static final org.apache.thrift.protocol.b s = new org.apache.thrift.protocol.b("", (byte) 13, 9);
    private static final org.apache.thrift.protocol.b t = new org.apache.thrift.protocol.b("", (byte) 11, 10);
    private static final org.apache.thrift.protocol.b u = new org.apache.thrift.protocol.b("", (byte) 11, 11);
    public String a;
    public x b;
    public String c;
    public String d;
    public String e;
    public String g;
    public Map<String, String> h;
    public String i;
    public String j;
    private BitSet v = new BitSet(1);
    public long f = 0;

    @Override // org.apache.thrift.a
    public void a(org.apache.thrift.protocol.e eVar) {
        eVar.g();
        while (true) {
            org.apache.thrift.protocol.b i = eVar.i();
            if (i.b == 0) {
                eVar.h();
                m();
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
                default:
                    org.apache.thrift.protocol.h.a(eVar, i.b);
                    break;
                case 7:
                    if (i.b == 10) {
                        this.f = eVar.u();
                        a(true);
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    }
                case 8:
                    if (i.b == 11) {
                        this.g = eVar.w();
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    }
                case 9:
                    if (i.b == 13) {
                        org.apache.thrift.protocol.d k2 = eVar.k();
                        this.h = new HashMap(k2.c * 2);
                        for (int i2 = 0; i2 < k2.c; i2++) {
                            this.h.put(eVar.w(), eVar.w());
                        }
                        eVar.l();
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    }
                case 10:
                    if (i.b == 11) {
                        this.i = eVar.w();
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    }
                case 11:
                    if (i.b == 11) {
                        this.j = eVar.w();
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    }
            }
            eVar.j();
        }
    }

    public void a(boolean z) {
        this.v.set(0, z);
    }

    public boolean a() {
        return this.a != null;
    }

    public boolean a(aa aaVar) {
        if (aaVar == null) {
            return false;
        }
        boolean a = a();
        boolean a2 = aaVar.a();
        if ((a || a2) && !(a && a2 && this.a.equals(aaVar.a))) {
            return false;
        }
        boolean b = b();
        boolean b2 = aaVar.b();
        if ((b || b2) && !(b && b2 && this.b.a(aaVar.b))) {
            return false;
        }
        boolean d = d();
        boolean d2 = aaVar.d();
        if ((d || d2) && !(d && d2 && this.c.equals(aaVar.c))) {
            return false;
        }
        boolean e = e();
        boolean e2 = aaVar.e();
        if ((e || e2) && !(e && e2 && this.d.equals(aaVar.d))) {
            return false;
        }
        boolean f = f();
        boolean f2 = aaVar.f();
        if ((f || f2) && !(f && f2 && this.e.equals(aaVar.e))) {
            return false;
        }
        boolean g = g();
        boolean g2 = aaVar.g();
        if ((g || g2) && !(g && g2 && this.f == aaVar.f)) {
            return false;
        }
        boolean h = h();
        boolean h2 = aaVar.h();
        if ((h || h2) && !(h && h2 && this.g.equals(aaVar.g))) {
            return false;
        }
        boolean j = j();
        boolean j2 = aaVar.j();
        if ((j || j2) && !(j && j2 && this.h.equals(aaVar.h))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = aaVar.k();
        if ((k2 || k3) && !(k2 && k3 && this.i.equals(aaVar.i))) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = aaVar.l();
        return !(l2 || l3) || (l2 && l3 && this.j.equals(aaVar.j));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: b */
    public int compareTo(aa aaVar) {
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
        if (getClass().equals(aaVar.getClass())) {
            int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(aaVar.a()));
            if (compareTo == 0) {
                if (!a() || (a10 = org.apache.thrift.b.a(this.a, aaVar.a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(aaVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a9 = org.apache.thrift.b.a(this.b, aaVar.b)) == 0) {
                            int compareTo3 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(aaVar.d()));
                            if (compareTo3 == 0) {
                                if (!d() || (a8 = org.apache.thrift.b.a(this.c, aaVar.c)) == 0) {
                                    int compareTo4 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(aaVar.e()));
                                    if (compareTo4 == 0) {
                                        if (!e() || (a7 = org.apache.thrift.b.a(this.d, aaVar.d)) == 0) {
                                            int compareTo5 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(aaVar.f()));
                                            if (compareTo5 == 0) {
                                                if (!f() || (a6 = org.apache.thrift.b.a(this.e, aaVar.e)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(aaVar.g()));
                                                    if (compareTo6 == 0) {
                                                        if (!g() || (a5 = org.apache.thrift.b.a(this.f, aaVar.f)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(aaVar.h()));
                                                            if (compareTo7 == 0) {
                                                                if (!h() || (a4 = org.apache.thrift.b.a(this.g, aaVar.g)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(aaVar.j()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!j() || (a3 = org.apache.thrift.b.a(this.h, aaVar.h)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(aaVar.k()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!k() || (a2 = org.apache.thrift.b.a(this.i, aaVar.i)) == 0) {
                                                                                    int compareTo10 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(aaVar.l()));
                                                                                    if (compareTo10 == 0) {
                                                                                        if (!l() || (a = org.apache.thrift.b.a(this.j, aaVar.j)) == 0) {
                                                                                            return 0;
                                                                                        }
                                                                                        return a;
                                                                                    }
                                                                                    return compareTo10;
                                                                                }
                                                                                return a2;
                                                                            }
                                                                            return compareTo9;
                                                                        }
                                                                        return a3;
                                                                    }
                                                                    return compareTo8;
                                                                }
                                                                return a4;
                                                            }
                                                            return compareTo7;
                                                        }
                                                        return a5;
                                                    }
                                                    return compareTo6;
                                                }
                                                return a6;
                                            }
                                            return compareTo5;
                                        }
                                        return a7;
                                    }
                                    return compareTo4;
                                }
                                return a8;
                            }
                            return compareTo3;
                        }
                        return a9;
                    }
                    return compareTo2;
                }
                return a10;
            }
            return compareTo;
        }
        return getClass().getName().compareTo(aaVar.getClass().getName());
    }

    @Override // org.apache.thrift.a
    public void b(org.apache.thrift.protocol.e eVar) {
        m();
        eVar.a(k);
        if (this.a != null && a()) {
            eVar.a(l);
            eVar.a(this.a);
            eVar.b();
        }
        if (this.b != null && b()) {
            eVar.a(m);
            this.b.b(eVar);
            eVar.b();
        }
        if (this.c != null) {
            eVar.a(n);
            eVar.a(this.c);
            eVar.b();
        }
        if (this.d != null && e()) {
            eVar.a(o);
            eVar.a(this.d);
            eVar.b();
        }
        if (this.e != null && f()) {
            eVar.a(p);
            eVar.a(this.e);
            eVar.b();
        }
        if (g()) {
            eVar.a(q);
            eVar.a(this.f);
            eVar.b();
        }
        if (this.g != null && h()) {
            eVar.a(r);
            eVar.a(this.g);
            eVar.b();
        }
        if (this.h != null && j()) {
            eVar.a(s);
            eVar.a(new org.apache.thrift.protocol.d((byte) 11, (byte) 11, this.h.size()));
            for (Map.Entry<String, String> entry : this.h.entrySet()) {
                eVar.a(entry.getKey());
                eVar.a(entry.getValue());
            }
            eVar.d();
            eVar.b();
        }
        if (this.i != null && k()) {
            eVar.a(t);
            eVar.a(this.i);
            eVar.b();
        }
        if (this.j != null && l()) {
            eVar.a(u);
            eVar.a(this.j);
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

    public boolean e() {
        return this.d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof aa)) {
            return a((aa) obj);
        }
        return false;
    }

    public boolean f() {
        return this.e != null;
    }

    public boolean g() {
        return this.v.get(0);
    }

    public boolean h() {
        return this.g != null;
    }

    public int hashCode() {
        return 0;
    }

    public Map<String, String> i() {
        return this.h;
    }

    public boolean j() {
        return this.h != null;
    }

    public boolean k() {
        return this.i != null;
    }

    public boolean l() {
        return this.j != null;
    }

    public void m() {
        if (this.c == null) {
            throw new org.apache.thrift.protocol.f("Required field 'id' was not present! Struct: " + toString());
        }
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionAckNotification(");
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
        if (e()) {
            sb.append(", ");
            sb.append("appId:");
            if (this.d == null) {
                sb.append("null");
            } else {
                sb.append(this.d);
            }
        }
        if (f()) {
            sb.append(", ");
            sb.append("type:");
            if (this.e == null) {
                sb.append("null");
            } else {
                sb.append(this.e);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("errorCode:");
            sb.append(this.f);
        }
        if (h()) {
            sb.append(", ");
            sb.append("reason:");
            if (this.g == null) {
                sb.append("null");
            } else {
                sb.append(this.g);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("extra:");
            if (this.h == null) {
                sb.append("null");
            } else {
                sb.append(this.h);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.i == null) {
                sb.append("null");
            } else {
                sb.append(this.i);
            }
        }
        if (l()) {
            sb.append(", ");
            sb.append("category:");
            if (this.j == null) {
                sb.append("null");
            } else {
                sb.append(this.j);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
