package com.xiaomi.xmpush.thrift;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.apache.thrift.TFieldIdEnum;
/* loaded from: classes3.dex */
public class ar implements Serializable, Cloneable, org.apache.thrift.a<ar, TFieldIdEnum> {
    private static final org.apache.thrift.protocol.j i = new org.apache.thrift.protocol.j("XmPushActionUnSubscription");
    private static final org.apache.thrift.protocol.b j = new org.apache.thrift.protocol.b("", (byte) 11, 1);
    private static final org.apache.thrift.protocol.b k = new org.apache.thrift.protocol.b("", (byte) 12, 2);
    private static final org.apache.thrift.protocol.b l = new org.apache.thrift.protocol.b("", (byte) 11, 3);
    private static final org.apache.thrift.protocol.b m = new org.apache.thrift.protocol.b("", (byte) 11, 4);
    private static final org.apache.thrift.protocol.b n = new org.apache.thrift.protocol.b("", (byte) 11, 5);
    private static final org.apache.thrift.protocol.b o = new org.apache.thrift.protocol.b("", (byte) 11, 6);
    private static final org.apache.thrift.protocol.b p = new org.apache.thrift.protocol.b("", (byte) 11, 7);
    private static final org.apache.thrift.protocol.b q = new org.apache.thrift.protocol.b("", (byte) 15, 8);
    public String a;
    public x b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public List<String> h;

    public ar a(String str) {
        this.c = str;
        return this;
    }

    @Override // org.apache.thrift.a
    public void a(org.apache.thrift.protocol.e eVar) {
        eVar.g();
        while (true) {
            org.apache.thrift.protocol.b i2 = eVar.i();
            if (i2.b == 0) {
                eVar.h();
                i();
                return;
            }
            switch (i2.c) {
                case 1:
                    if (i2.b == 11) {
                        this.a = eVar.w();
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i2.b);
                        break;
                    }
                case 2:
                    if (i2.b == 12) {
                        this.b = new x();
                        this.b.a(eVar);
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i2.b);
                        break;
                    }
                case 3:
                    if (i2.b == 11) {
                        this.c = eVar.w();
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i2.b);
                        break;
                    }
                case 4:
                    if (i2.b == 11) {
                        this.d = eVar.w();
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i2.b);
                        break;
                    }
                case 5:
                    if (i2.b == 11) {
                        this.e = eVar.w();
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i2.b);
                        break;
                    }
                case 6:
                    if (i2.b == 11) {
                        this.f = eVar.w();
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i2.b);
                        break;
                    }
                case 7:
                    if (i2.b == 11) {
                        this.g = eVar.w();
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i2.b);
                        break;
                    }
                case 8:
                    if (i2.b == 15) {
                        org.apache.thrift.protocol.c m2 = eVar.m();
                        this.h = new ArrayList(m2.b);
                        for (int i3 = 0; i3 < m2.b; i3++) {
                            this.h.add(eVar.w());
                        }
                        eVar.n();
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i2.b);
                        break;
                    }
                default:
                    org.apache.thrift.protocol.h.a(eVar, i2.b);
                    break;
            }
            eVar.j();
        }
    }

    public boolean a() {
        return this.a != null;
    }

    public boolean a(ar arVar) {
        if (arVar == null) {
            return false;
        }
        boolean a = a();
        boolean a2 = arVar.a();
        if ((a || a2) && !(a && a2 && this.a.equals(arVar.a))) {
            return false;
        }
        boolean b = b();
        boolean b2 = arVar.b();
        if ((b || b2) && !(b && b2 && this.b.a(arVar.b))) {
            return false;
        }
        boolean c = c();
        boolean c2 = arVar.c();
        if ((c || c2) && !(c && c2 && this.c.equals(arVar.c))) {
            return false;
        }
        boolean d = d();
        boolean d2 = arVar.d();
        if ((d || d2) && !(d && d2 && this.d.equals(arVar.d))) {
            return false;
        }
        boolean e = e();
        boolean e2 = arVar.e();
        if ((e || e2) && !(e && e2 && this.e.equals(arVar.e))) {
            return false;
        }
        boolean f = f();
        boolean f2 = arVar.f();
        if ((f || f2) && !(f && f2 && this.f.equals(arVar.f))) {
            return false;
        }
        boolean g = g();
        boolean g2 = arVar.g();
        if ((g || g2) && !(g && g2 && this.g.equals(arVar.g))) {
            return false;
        }
        boolean h = h();
        boolean h2 = arVar.h();
        return !(h || h2) || (h && h2 && this.h.equals(arVar.h));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: b */
    public int compareTo(ar arVar) {
        int a;
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        int a8;
        if (getClass().equals(arVar.getClass())) {
            int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(arVar.a()));
            if (compareTo == 0) {
                if (!a() || (a8 = org.apache.thrift.b.a(this.a, arVar.a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(arVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a7 = org.apache.thrift.b.a(this.b, arVar.b)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(arVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a6 = org.apache.thrift.b.a(this.c, arVar.c)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(arVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a5 = org.apache.thrift.b.a(this.d, arVar.d)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(arVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a4 = org.apache.thrift.b.a(this.e, arVar.e)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(arVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a3 = org.apache.thrift.b.a(this.f, arVar.f)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(arVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a2 = org.apache.thrift.b.a(this.g, arVar.g)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(arVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a = org.apache.thrift.b.a(this.h, arVar.h)) == 0) {
                                                                            return 0;
                                                                        }
                                                                        return a;
                                                                    }
                                                                    return compareTo8;
                                                                }
                                                                return a2;
                                                            }
                                                            return compareTo7;
                                                        }
                                                        return a3;
                                                    }
                                                    return compareTo6;
                                                }
                                                return a4;
                                            }
                                            return compareTo5;
                                        }
                                        return a5;
                                    }
                                    return compareTo4;
                                }
                                return a6;
                            }
                            return compareTo3;
                        }
                        return a7;
                    }
                    return compareTo2;
                }
                return a8;
            }
            return compareTo;
        }
        return getClass().getName().compareTo(arVar.getClass().getName());
    }

    public ar b(String str) {
        this.d = str;
        return this;
    }

    @Override // org.apache.thrift.a
    public void b(org.apache.thrift.protocol.e eVar) {
        i();
        eVar.a(i);
        if (this.a != null && a()) {
            eVar.a(j);
            eVar.a(this.a);
            eVar.b();
        }
        if (this.b != null && b()) {
            eVar.a(k);
            this.b.b(eVar);
            eVar.b();
        }
        if (this.c != null) {
            eVar.a(l);
            eVar.a(this.c);
            eVar.b();
        }
        if (this.d != null) {
            eVar.a(m);
            eVar.a(this.d);
            eVar.b();
        }
        if (this.e != null) {
            eVar.a(n);
            eVar.a(this.e);
            eVar.b();
        }
        if (this.f != null && f()) {
            eVar.a(o);
            eVar.a(this.f);
            eVar.b();
        }
        if (this.g != null && g()) {
            eVar.a(p);
            eVar.a(this.g);
            eVar.b();
        }
        if (this.h != null && h()) {
            eVar.a(q);
            eVar.a(new org.apache.thrift.protocol.c((byte) 11, this.h.size()));
            for (String str : this.h) {
                eVar.a(str);
            }
            eVar.e();
            eVar.b();
        }
        eVar.c();
        eVar.a();
    }

    public boolean b() {
        return this.b != null;
    }

    public ar c(String str) {
        this.e = str;
        return this;
    }

    public boolean c() {
        return this.c != null;
    }

    public ar d(String str) {
        this.f = str;
        return this;
    }

    public boolean d() {
        return this.d != null;
    }

    public ar e(String str) {
        this.g = str;
        return this;
    }

    public boolean e() {
        return this.e != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ar)) {
            return a((ar) obj);
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

    public void i() {
        if (this.c == null) {
            throw new org.apache.thrift.protocol.f("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.d == null) {
            throw new org.apache.thrift.protocol.f("Required field 'appId' was not present! Struct: " + toString());
        }
        if (this.e == null) {
            throw new org.apache.thrift.protocol.f("Required field 'topic' was not present! Struct: " + toString());
        }
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionUnSubscription(");
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
        sb.append(", ");
        sb.append("topic:");
        if (this.e == null) {
            sb.append("null");
        } else {
            sb.append(this.e);
        }
        if (f()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f == null) {
                sb.append("null");
            } else {
                sb.append(this.f);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("category:");
            if (this.g == null) {
                sb.append("null");
            } else {
                sb.append(this.g);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("aliases:");
            if (this.h == null) {
                sb.append("null");
            } else {
                sb.append(this.h);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
