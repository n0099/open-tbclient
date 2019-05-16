package com.xiaomi.xmpush.thrift;

import java.io.Serializable;
import java.util.BitSet;
import org.apache.thrift.TFieldIdEnum;
/* loaded from: classes3.dex */
public class as implements Serializable, Cloneable, org.apache.thrift.a<as, TFieldIdEnum> {
    private static final org.apache.thrift.protocol.j j = new org.apache.thrift.protocol.j("XmPushActionUnSubscriptionResult");
    private static final org.apache.thrift.protocol.b k = new org.apache.thrift.protocol.b("", (byte) 11, 1);
    private static final org.apache.thrift.protocol.b l = new org.apache.thrift.protocol.b("", (byte) 12, 2);
    private static final org.apache.thrift.protocol.b m = new org.apache.thrift.protocol.b("", (byte) 11, 3);
    private static final org.apache.thrift.protocol.b n = new org.apache.thrift.protocol.b("", (byte) 11, 4);
    private static final org.apache.thrift.protocol.b o = new org.apache.thrift.protocol.b("", (byte) 10, 6);
    private static final org.apache.thrift.protocol.b p = new org.apache.thrift.protocol.b("", (byte) 11, 7);
    private static final org.apache.thrift.protocol.b q = new org.apache.thrift.protocol.b("", (byte) 11, 8);
    private static final org.apache.thrift.protocol.b r = new org.apache.thrift.protocol.b("", (byte) 11, 9);
    private static final org.apache.thrift.protocol.b s = new org.apache.thrift.protocol.b("", (byte) 11, 10);
    public String a;
    public x b;
    public String c;
    public String d;
    public long e;
    public String f;
    public String g;
    public String h;
    public String i;
    private BitSet t = new BitSet(1);

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
            }
            eVar.j();
        }
    }

    public void a(boolean z) {
        this.t.set(0, z);
    }

    public boolean a() {
        return this.a != null;
    }

    public boolean a(as asVar) {
        if (asVar == null) {
            return false;
        }
        boolean a = a();
        boolean a2 = asVar.a();
        if ((a || a2) && !(a && a2 && this.a.equals(asVar.a))) {
            return false;
        }
        boolean b = b();
        boolean b2 = asVar.b();
        if ((b || b2) && !(b && b2 && this.b.a(asVar.b))) {
            return false;
        }
        boolean c = c();
        boolean c2 = asVar.c();
        if ((c || c2) && !(c && c2 && this.c.equals(asVar.c))) {
            return false;
        }
        boolean d = d();
        boolean d2 = asVar.d();
        if ((d || d2) && !(d && d2 && this.d.equals(asVar.d))) {
            return false;
        }
        boolean e = e();
        boolean e2 = asVar.e();
        if ((e || e2) && !(e && e2 && this.e == asVar.e)) {
            return false;
        }
        boolean f = f();
        boolean f2 = asVar.f();
        if ((f || f2) && !(f && f2 && this.f.equals(asVar.f))) {
            return false;
        }
        boolean h = h();
        boolean h2 = asVar.h();
        if ((h || h2) && !(h && h2 && this.g.equals(asVar.g))) {
            return false;
        }
        boolean i = i();
        boolean i2 = asVar.i();
        if ((i || i2) && !(i && i2 && this.h.equals(asVar.h))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = asVar.k();
        return !(k2 || k3) || (k2 && k3 && this.i.equals(asVar.i));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: b */
    public int compareTo(as asVar) {
        int a;
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        int a8;
        int a9;
        if (getClass().equals(asVar.getClass())) {
            int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(asVar.a()));
            if (compareTo == 0) {
                if (!a() || (a9 = org.apache.thrift.b.a(this.a, asVar.a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(asVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a8 = org.apache.thrift.b.a(this.b, asVar.b)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(asVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a7 = org.apache.thrift.b.a(this.c, asVar.c)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(asVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a6 = org.apache.thrift.b.a(this.d, asVar.d)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(asVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a5 = org.apache.thrift.b.a(this.e, asVar.e)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(asVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a4 = org.apache.thrift.b.a(this.f, asVar.f)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(asVar.h()));
                                                            if (compareTo7 == 0) {
                                                                if (!h() || (a3 = org.apache.thrift.b.a(this.g, asVar.g)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(asVar.i()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!i() || (a2 = org.apache.thrift.b.a(this.h, asVar.h)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(asVar.k()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!k() || (a = org.apache.thrift.b.a(this.i, asVar.i)) == 0) {
                                                                                    return 0;
                                                                                }
                                                                                return a;
                                                                            }
                                                                            return compareTo9;
                                                                        }
                                                                        return a2;
                                                                    }
                                                                    return compareTo8;
                                                                }
                                                                return a3;
                                                            }
                                                            return compareTo7;
                                                        }
                                                        return a4;
                                                    }
                                                    return compareTo6;
                                                }
                                                return a5;
                                            }
                                            return compareTo5;
                                        }
                                        return a6;
                                    }
                                    return compareTo4;
                                }
                                return a7;
                            }
                            return compareTo3;
                        }
                        return a8;
                    }
                    return compareTo2;
                }
                return a9;
            }
            return compareTo;
        }
        return getClass().getName().compareTo(asVar.getClass().getName());
    }

    @Override // org.apache.thrift.a
    public void b(org.apache.thrift.protocol.e eVar) {
        l();
        eVar.a(j);
        if (this.a != null && a()) {
            eVar.a(k);
            eVar.a(this.a);
            eVar.b();
        }
        if (this.b != null && b()) {
            eVar.a(l);
            this.b.b(eVar);
            eVar.b();
        }
        if (this.c != null) {
            eVar.a(m);
            eVar.a(this.c);
            eVar.b();
        }
        if (this.d != null && d()) {
            eVar.a(n);
            eVar.a(this.d);
            eVar.b();
        }
        if (e()) {
            eVar.a(o);
            eVar.a(this.e);
            eVar.b();
        }
        if (this.f != null && f()) {
            eVar.a(p);
            eVar.a(this.f);
            eVar.b();
        }
        if (this.g != null && h()) {
            eVar.a(q);
            eVar.a(this.g);
            eVar.b();
        }
        if (this.h != null && i()) {
            eVar.a(r);
            eVar.a(this.h);
            eVar.b();
        }
        if (this.i != null && k()) {
            eVar.a(s);
            eVar.a(this.i);
            eVar.b();
        }
        eVar.c();
        eVar.a();
    }

    public boolean b() {
        return this.b != null;
    }

    public boolean c() {
        return this.c != null;
    }

    public boolean d() {
        return this.d != null;
    }

    public boolean e() {
        return this.t.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof as)) {
            return a((as) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f != null;
    }

    public String g() {
        return this.g;
    }

    public boolean h() {
        return this.g != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.h != null;
    }

    public String j() {
        return this.i;
    }

    public boolean k() {
        return this.i != null;
    }

    public void l() {
        if (this.c == null) {
            throw new org.apache.thrift.protocol.f("Required field 'id' was not present! Struct: " + toString());
        }
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionUnSubscriptionResult(");
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
        if (d()) {
            sb.append(", ");
            sb.append("appId:");
            if (this.d == null) {
                sb.append("null");
            } else {
                sb.append(this.d);
            }
        }
        if (e()) {
            sb.append(", ");
            sb.append("errorCode:");
            sb.append(this.e);
        }
        if (f()) {
            sb.append(", ");
            sb.append("reason:");
            if (this.f == null) {
                sb.append("null");
            } else {
                sb.append(this.f);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("topic:");
            if (this.g == null) {
                sb.append("null");
            } else {
                sb.append(this.g);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.h == null) {
                sb.append("null");
            } else {
                sb.append(this.h);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("category:");
            if (this.i == null) {
                sb.append("null");
            } else {
                sb.append(this.i);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
