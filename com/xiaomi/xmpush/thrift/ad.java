package com.xiaomi.xmpush.thrift;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import org.apache.thrift.TFieldIdEnum;
/* loaded from: classes3.dex */
public class ad implements Serializable, Cloneable, org.apache.thrift.a<ad, TFieldIdEnum> {
    private static final org.apache.thrift.protocol.j k = new org.apache.thrift.protocol.j("XmPushActionCommand");
    private static final org.apache.thrift.protocol.b l = new org.apache.thrift.protocol.b("", (byte) 12, 2);
    private static final org.apache.thrift.protocol.b m = new org.apache.thrift.protocol.b("", (byte) 11, 3);
    private static final org.apache.thrift.protocol.b n = new org.apache.thrift.protocol.b("", (byte) 11, 4);
    private static final org.apache.thrift.protocol.b o = new org.apache.thrift.protocol.b("", (byte) 11, 5);
    private static final org.apache.thrift.protocol.b p = new org.apache.thrift.protocol.b("", (byte) 15, 6);
    private static final org.apache.thrift.protocol.b q = new org.apache.thrift.protocol.b("", (byte) 11, 7);
    private static final org.apache.thrift.protocol.b r = new org.apache.thrift.protocol.b("", (byte) 11, 9);
    private static final org.apache.thrift.protocol.b s = new org.apache.thrift.protocol.b("", (byte) 2, 10);
    private static final org.apache.thrift.protocol.b t = new org.apache.thrift.protocol.b("", (byte) 2, 11);
    private static final org.apache.thrift.protocol.b u = new org.apache.thrift.protocol.b("", (byte) 10, 12);
    public x a;
    public String b;
    public String c;
    public String d;
    public List<String> e;
    public String f;
    public String g;
    public long j;
    private BitSet v = new BitSet(3);
    public boolean h = false;
    public boolean i = true;

    public ad a(String str) {
        this.b = str;
        return this;
    }

    public ad a(List<String> list) {
        this.e = list;
        return this;
    }

    @Override // org.apache.thrift.a
    public void a(org.apache.thrift.protocol.e eVar) {
        eVar.g();
        while (true) {
            org.apache.thrift.protocol.b i = eVar.i();
            if (i.b == 0) {
                eVar.h();
                l();
                return;
            }
            switch (i.c) {
                case 2:
                    if (i.b == 12) {
                        this.a = new x();
                        this.a.a(eVar);
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    }
                case 3:
                    if (i.b == 11) {
                        this.b = eVar.w();
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    }
                case 4:
                    if (i.b == 11) {
                        this.c = eVar.w();
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    }
                case 5:
                    if (i.b == 11) {
                        this.d = eVar.w();
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    }
                case 6:
                    if (i.b == 15) {
                        org.apache.thrift.protocol.c m2 = eVar.m();
                        this.e = new ArrayList(m2.b);
                        for (int i2 = 0; i2 < m2.b; i2++) {
                            this.e.add(eVar.w());
                        }
                        eVar.n();
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    }
                case 7:
                    if (i.b == 11) {
                        this.f = eVar.w();
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    }
                case 8:
                default:
                    org.apache.thrift.protocol.h.a(eVar, i.b);
                    break;
                case 9:
                    if (i.b == 11) {
                        this.g = eVar.w();
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    }
                case 10:
                    if (i.b == 2) {
                        this.h = eVar.q();
                        a(true);
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    }
                case 11:
                    if (i.b == 2) {
                        this.i = eVar.q();
                        b(true);
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    }
                case 12:
                    if (i.b == 10) {
                        this.j = eVar.u();
                        c(true);
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

    public boolean a(ad adVar) {
        if (adVar == null) {
            return false;
        }
        boolean a = a();
        boolean a2 = adVar.a();
        if ((a || a2) && !(a && a2 && this.a.a(adVar.a))) {
            return false;
        }
        boolean b = b();
        boolean b2 = adVar.b();
        if ((b || b2) && !(b && b2 && this.b.equals(adVar.b))) {
            return false;
        }
        boolean c = c();
        boolean c2 = adVar.c();
        if ((c || c2) && !(c && c2 && this.c.equals(adVar.c))) {
            return false;
        }
        boolean e = e();
        boolean e2 = adVar.e();
        if ((e || e2) && !(e && e2 && this.d.equals(adVar.d))) {
            return false;
        }
        boolean f = f();
        boolean f2 = adVar.f();
        if ((f || f2) && !(f && f2 && this.e.equals(adVar.e))) {
            return false;
        }
        boolean g = g();
        boolean g2 = adVar.g();
        if ((g || g2) && !(g && g2 && this.f.equals(adVar.f))) {
            return false;
        }
        boolean h = h();
        boolean h2 = adVar.h();
        if ((h || h2) && !(h && h2 && this.g.equals(adVar.g))) {
            return false;
        }
        boolean i = i();
        boolean i2 = adVar.i();
        if ((i || i2) && !(i && i2 && this.h == adVar.h)) {
            return false;
        }
        boolean j = j();
        boolean j2 = adVar.j();
        if ((j || j2) && !(j && j2 && this.i == adVar.i)) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = adVar.k();
        return !(k2 || k3) || (k2 && k3 && this.j == adVar.j);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: b */
    public int compareTo(ad adVar) {
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
        if (getClass().equals(adVar.getClass())) {
            int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(adVar.a()));
            if (compareTo == 0) {
                if (!a() || (a10 = org.apache.thrift.b.a(this.a, adVar.a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(adVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a9 = org.apache.thrift.b.a(this.b, adVar.b)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(adVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a8 = org.apache.thrift.b.a(this.c, adVar.c)) == 0) {
                                    int compareTo4 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(adVar.e()));
                                    if (compareTo4 == 0) {
                                        if (!e() || (a7 = org.apache.thrift.b.a(this.d, adVar.d)) == 0) {
                                            int compareTo5 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(adVar.f()));
                                            if (compareTo5 == 0) {
                                                if (!f() || (a6 = org.apache.thrift.b.a(this.e, adVar.e)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(adVar.g()));
                                                    if (compareTo6 == 0) {
                                                        if (!g() || (a5 = org.apache.thrift.b.a(this.f, adVar.f)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(adVar.h()));
                                                            if (compareTo7 == 0) {
                                                                if (!h() || (a4 = org.apache.thrift.b.a(this.g, adVar.g)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(adVar.i()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!i() || (a3 = org.apache.thrift.b.a(this.h, adVar.h)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(adVar.j()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!j() || (a2 = org.apache.thrift.b.a(this.i, adVar.i)) == 0) {
                                                                                    int compareTo10 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(adVar.k()));
                                                                                    if (compareTo10 == 0) {
                                                                                        if (!k() || (a = org.apache.thrift.b.a(this.j, adVar.j)) == 0) {
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
        return getClass().getName().compareTo(adVar.getClass().getName());
    }

    public ad b(String str) {
        this.c = str;
        return this;
    }

    @Override // org.apache.thrift.a
    public void b(org.apache.thrift.protocol.e eVar) {
        l();
        eVar.a(k);
        if (this.a != null && a()) {
            eVar.a(l);
            this.a.b(eVar);
            eVar.b();
        }
        if (this.b != null) {
            eVar.a(m);
            eVar.a(this.b);
            eVar.b();
        }
        if (this.c != null) {
            eVar.a(n);
            eVar.a(this.c);
            eVar.b();
        }
        if (this.d != null) {
            eVar.a(o);
            eVar.a(this.d);
            eVar.b();
        }
        if (this.e != null && f()) {
            eVar.a(p);
            eVar.a(new org.apache.thrift.protocol.c((byte) 11, this.e.size()));
            for (String str : this.e) {
                eVar.a(str);
            }
            eVar.e();
            eVar.b();
        }
        if (this.f != null && g()) {
            eVar.a(q);
            eVar.a(this.f);
            eVar.b();
        }
        if (this.g != null && h()) {
            eVar.a(r);
            eVar.a(this.g);
            eVar.b();
        }
        if (i()) {
            eVar.a(s);
            eVar.a(this.h);
            eVar.b();
        }
        if (j()) {
            eVar.a(t);
            eVar.a(this.i);
            eVar.b();
        }
        if (k()) {
            eVar.a(u);
            eVar.a(this.j);
            eVar.b();
        }
        eVar.c();
        eVar.a();
    }

    public void b(boolean z) {
        this.v.set(1, z);
    }

    public boolean b() {
        return this.b != null;
    }

    public ad c(String str) {
        this.d = str;
        return this;
    }

    public void c(boolean z) {
        this.v.set(2, z);
    }

    public boolean c() {
        return this.c != null;
    }

    public String d() {
        return this.d;
    }

    public void d(String str) {
        if (this.e == null) {
            this.e = new ArrayList();
        }
        this.e.add(str);
    }

    public ad e(String str) {
        this.f = str;
        return this;
    }

    public boolean e() {
        return this.d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ad)) {
            return a((ad) obj);
        }
        return false;
    }

    public ad f(String str) {
        this.g = str;
        return this;
    }

    public boolean f() {
        return this.e != null;
    }

    public boolean g() {
        return this.f != null;
    }

    public boolean h() {
        return this.g != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.v.get(0);
    }

    public boolean j() {
        return this.v.get(1);
    }

    public boolean k() {
        return this.v.get(2);
    }

    public void l() {
        if (this.b == null) {
            throw new org.apache.thrift.protocol.f("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.c == null) {
            throw new org.apache.thrift.protocol.f("Required field 'appId' was not present! Struct: " + toString());
        }
        if (this.d == null) {
            throw new org.apache.thrift.protocol.f("Required field 'cmdName' was not present! Struct: " + toString());
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionCommand(");
        boolean z = true;
        if (a()) {
            sb.append("target:");
            if (this.a == null) {
                sb.append("null");
            } else {
                sb.append(this.a);
            }
            z = false;
        }
        if (!z) {
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
        sb.append("cmdName:");
        if (this.d == null) {
            sb.append("null");
        } else {
            sb.append(this.d);
        }
        if (f()) {
            sb.append(", ");
            sb.append("cmdArgs:");
            if (this.e == null) {
                sb.append("null");
            } else {
                sb.append(this.e);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f == null) {
                sb.append("null");
            } else {
                sb.append(this.f);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("category:");
            if (this.g == null) {
                sb.append("null");
            } else {
                sb.append(this.g);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("updateCache:");
            sb.append(this.h);
        }
        if (j()) {
            sb.append(", ");
            sb.append("response2Client:");
            sb.append(this.i);
        }
        if (k()) {
            sb.append(", ");
            sb.append("createdTs:");
            sb.append(this.j);
        }
        sb.append(")");
        return sb.toString();
    }
}
