package com.xiaomi.xmpush.thrift;

import java.io.Serializable;
import java.util.BitSet;
import org.apache.thrift.TFieldIdEnum;
/* loaded from: classes3.dex */
public class s implements Serializable, Cloneable, org.apache.thrift.a<s, TFieldIdEnum> {
    private static final org.apache.thrift.protocol.j h = new org.apache.thrift.protocol.j("OnlineConfigItem");
    private static final org.apache.thrift.protocol.b i = new org.apache.thrift.protocol.b("", (byte) 8, 1);
    private static final org.apache.thrift.protocol.b j = new org.apache.thrift.protocol.b("", (byte) 8, 2);
    private static final org.apache.thrift.protocol.b k = new org.apache.thrift.protocol.b("", (byte) 2, 3);
    private static final org.apache.thrift.protocol.b l = new org.apache.thrift.protocol.b("", (byte) 8, 4);
    private static final org.apache.thrift.protocol.b m = new org.apache.thrift.protocol.b("", (byte) 10, 5);
    private static final org.apache.thrift.protocol.b n = new org.apache.thrift.protocol.b("", (byte) 11, 6);
    private static final org.apache.thrift.protocol.b o = new org.apache.thrift.protocol.b("", (byte) 2, 7);
    public int a;
    public int b;
    public boolean c;
    public int d;
    public long e;
    public String f;
    public boolean g;
    private BitSet p = new BitSet(6);

    public int a() {
        return this.a;
    }

    @Override // org.apache.thrift.a
    public void a(org.apache.thrift.protocol.e eVar) {
        eVar.g();
        while (true) {
            org.apache.thrift.protocol.b i2 = eVar.i();
            if (i2.b == 0) {
                eVar.h();
                n();
                return;
            }
            switch (i2.c) {
                case 1:
                    if (i2.b != 8) {
                        org.apache.thrift.protocol.h.a(eVar, i2.b);
                        break;
                    } else {
                        this.a = eVar.t();
                        a(true);
                        break;
                    }
                case 2:
                    if (i2.b != 8) {
                        org.apache.thrift.protocol.h.a(eVar, i2.b);
                        break;
                    } else {
                        this.b = eVar.t();
                        b(true);
                        break;
                    }
                case 3:
                    if (i2.b != 2) {
                        org.apache.thrift.protocol.h.a(eVar, i2.b);
                        break;
                    } else {
                        this.c = eVar.q();
                        c(true);
                        break;
                    }
                case 4:
                    if (i2.b != 8) {
                        org.apache.thrift.protocol.h.a(eVar, i2.b);
                        break;
                    } else {
                        this.d = eVar.t();
                        d(true);
                        break;
                    }
                case 5:
                    if (i2.b != 10) {
                        org.apache.thrift.protocol.h.a(eVar, i2.b);
                        break;
                    } else {
                        this.e = eVar.u();
                        e(true);
                        break;
                    }
                case 6:
                    if (i2.b != 11) {
                        org.apache.thrift.protocol.h.a(eVar, i2.b);
                        break;
                    } else {
                        this.f = eVar.w();
                        break;
                    }
                case 7:
                    if (i2.b != 2) {
                        org.apache.thrift.protocol.h.a(eVar, i2.b);
                        break;
                    } else {
                        this.g = eVar.q();
                        f(true);
                        break;
                    }
                default:
                    org.apache.thrift.protocol.h.a(eVar, i2.b);
                    break;
            }
            eVar.j();
        }
    }

    public void a(boolean z) {
        this.p.set(0, z);
    }

    public boolean a(s sVar) {
        if (sVar == null) {
            return false;
        }
        boolean b = b();
        boolean b2 = sVar.b();
        if ((b || b2) && !(b && b2 && this.a == sVar.a)) {
            return false;
        }
        boolean d = d();
        boolean d2 = sVar.d();
        if ((d || d2) && !(d && d2 && this.b == sVar.b)) {
            return false;
        }
        boolean e = e();
        boolean e2 = sVar.e();
        if ((e || e2) && !(e && e2 && this.c == sVar.c)) {
            return false;
        }
        boolean g = g();
        boolean g2 = sVar.g();
        if ((g || g2) && !(g && g2 && this.d == sVar.d)) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = sVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.e == sVar.e)) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = sVar.k();
        if ((k2 || k3) && !(k2 && k3 && this.f.equals(sVar.f))) {
            return false;
        }
        boolean m2 = m();
        boolean m3 = sVar.m();
        return !(m2 || m3) || (m2 && m3 && this.g == sVar.g);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: b */
    public int compareTo(s sVar) {
        int a;
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        if (getClass().equals(sVar.getClass())) {
            int compareTo = Boolean.valueOf(b()).compareTo(Boolean.valueOf(sVar.b()));
            if (compareTo == 0) {
                if (!b() || (a7 = org.apache.thrift.b.a(this.a, sVar.a)) == 0) {
                    int compareTo2 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(sVar.d()));
                    if (compareTo2 == 0) {
                        if (!d() || (a6 = org.apache.thrift.b.a(this.b, sVar.b)) == 0) {
                            int compareTo3 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(sVar.e()));
                            if (compareTo3 == 0) {
                                if (!e() || (a5 = org.apache.thrift.b.a(this.c, sVar.c)) == 0) {
                                    int compareTo4 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(sVar.g()));
                                    if (compareTo4 == 0) {
                                        if (!g() || (a4 = org.apache.thrift.b.a(this.d, sVar.d)) == 0) {
                                            int compareTo5 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(sVar.i()));
                                            if (compareTo5 == 0) {
                                                if (!i() || (a3 = org.apache.thrift.b.a(this.e, sVar.e)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(sVar.k()));
                                                    if (compareTo6 == 0) {
                                                        if (!k() || (a2 = org.apache.thrift.b.a(this.f, sVar.f)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(sVar.m()));
                                                            if (compareTo7 == 0) {
                                                                if (!m() || (a = org.apache.thrift.b.a(this.g, sVar.g)) == 0) {
                                                                    return 0;
                                                                }
                                                                return a;
                                                            }
                                                            return compareTo7;
                                                        }
                                                        return a2;
                                                    }
                                                    return compareTo6;
                                                }
                                                return a3;
                                            }
                                            return compareTo5;
                                        }
                                        return a4;
                                    }
                                    return compareTo4;
                                }
                                return a5;
                            }
                            return compareTo3;
                        }
                        return a6;
                    }
                    return compareTo2;
                }
                return a7;
            }
            return compareTo;
        }
        return getClass().getName().compareTo(sVar.getClass().getName());
    }

    @Override // org.apache.thrift.a
    public void b(org.apache.thrift.protocol.e eVar) {
        n();
        eVar.a(h);
        if (b()) {
            eVar.a(i);
            eVar.a(this.a);
            eVar.b();
        }
        if (d()) {
            eVar.a(j);
            eVar.a(this.b);
            eVar.b();
        }
        if (e()) {
            eVar.a(k);
            eVar.a(this.c);
            eVar.b();
        }
        if (g()) {
            eVar.a(l);
            eVar.a(this.d);
            eVar.b();
        }
        if (i()) {
            eVar.a(m);
            eVar.a(this.e);
            eVar.b();
        }
        if (this.f != null && k()) {
            eVar.a(n);
            eVar.a(this.f);
            eVar.b();
        }
        if (m()) {
            eVar.a(o);
            eVar.a(this.g);
            eVar.b();
        }
        eVar.c();
        eVar.a();
    }

    public void b(boolean z) {
        this.p.set(1, z);
    }

    public boolean b() {
        return this.p.get(0);
    }

    public int c() {
        return this.b;
    }

    public void c(boolean z) {
        this.p.set(2, z);
    }

    public void d(boolean z) {
        this.p.set(3, z);
    }

    public boolean d() {
        return this.p.get(1);
    }

    public void e(boolean z) {
        this.p.set(4, z);
    }

    public boolean e() {
        return this.p.get(2);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof s)) {
            return a((s) obj);
        }
        return false;
    }

    public int f() {
        return this.d;
    }

    public void f(boolean z) {
        this.p.set(5, z);
    }

    public boolean g() {
        return this.p.get(3);
    }

    public long h() {
        return this.e;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.p.get(4);
    }

    public String j() {
        return this.f;
    }

    public boolean k() {
        return this.f != null;
    }

    public boolean l() {
        return this.g;
    }

    public boolean m() {
        return this.p.get(5);
    }

    public void n() {
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("OnlineConfigItem(");
        boolean z2 = true;
        if (b()) {
            sb.append("key:");
            sb.append(this.a);
            z2 = false;
        }
        if (d()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("type:");
            sb.append(this.b);
            z2 = false;
        }
        if (e()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("clear:");
            sb.append(this.c);
            z2 = false;
        }
        if (g()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("intValue:");
            sb.append(this.d);
            z2 = false;
        }
        if (i()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("longValue:");
            sb.append(this.e);
            z2 = false;
        }
        if (k()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("stringValue:");
            if (this.f == null) {
                sb.append("null");
            } else {
                sb.append(this.f);
            }
        } else {
            z = z2;
        }
        if (m()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("boolValue:");
            sb.append(this.g);
        }
        sb.append(")");
        return sb.toString();
    }
}
