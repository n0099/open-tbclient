package com.xiaomi.xmpush.thrift;

import java.io.Serializable;
import java.util.BitSet;
import org.apache.thrift.TFieldIdEnum;
/* loaded from: classes3.dex */
public class l implements Serializable, Cloneable, org.apache.thrift.a<l, TFieldIdEnum> {
    private static final org.apache.thrift.protocol.j e = new org.apache.thrift.protocol.j("GPS");
    private static final org.apache.thrift.protocol.b f = new org.apache.thrift.protocol.b("", (byte) 12, 1);
    private static final org.apache.thrift.protocol.b g = new org.apache.thrift.protocol.b("", (byte) 11, 2);
    private static final org.apache.thrift.protocol.b h = new org.apache.thrift.protocol.b("", (byte) 10, 3);
    private static final org.apache.thrift.protocol.b i = new org.apache.thrift.protocol.b("", (byte) 4, 4);
    public o a;
    public String b;
    public long c;
    public double d;
    private BitSet j = new BitSet(2);

    public l a(double d) {
        this.d = d;
        b(true);
        return this;
    }

    public l a(long j) {
        this.c = j;
        a(true);
        return this;
    }

    public l a(o oVar) {
        this.a = oVar;
        return this;
    }

    public l a(String str) {
        this.b = str;
        return this;
    }

    @Override // org.apache.thrift.a
    public void a(org.apache.thrift.protocol.e eVar) {
        eVar.g();
        while (true) {
            org.apache.thrift.protocol.b i2 = eVar.i();
            if (i2.b == 0) {
                eVar.h();
                e();
                return;
            }
            switch (i2.c) {
                case 1:
                    if (i2.b != 12) {
                        org.apache.thrift.protocol.h.a(eVar, i2.b);
                        break;
                    } else {
                        this.a = new o();
                        this.a.a(eVar);
                        break;
                    }
                case 2:
                    if (i2.b != 11) {
                        org.apache.thrift.protocol.h.a(eVar, i2.b);
                        break;
                    } else {
                        this.b = eVar.w();
                        break;
                    }
                case 3:
                    if (i2.b != 10) {
                        org.apache.thrift.protocol.h.a(eVar, i2.b);
                        break;
                    } else {
                        this.c = eVar.u();
                        a(true);
                        break;
                    }
                case 4:
                    if (i2.b != 4) {
                        org.apache.thrift.protocol.h.a(eVar, i2.b);
                        break;
                    } else {
                        this.d = eVar.v();
                        b(true);
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
        this.j.set(0, z);
    }

    public boolean a() {
        return this.a != null;
    }

    public boolean a(l lVar) {
        if (lVar == null) {
            return false;
        }
        boolean a = a();
        boolean a2 = lVar.a();
        if ((a || a2) && !(a && a2 && this.a.a(lVar.a))) {
            return false;
        }
        boolean b = b();
        boolean b2 = lVar.b();
        if ((b || b2) && !(b && b2 && this.b.equals(lVar.b))) {
            return false;
        }
        boolean c = c();
        boolean c2 = lVar.c();
        if ((c || c2) && !(c && c2 && this.c == lVar.c)) {
            return false;
        }
        boolean d = d();
        boolean d2 = lVar.d();
        return !(d || d2) || (d && d2 && this.d == lVar.d);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: b */
    public int compareTo(l lVar) {
        int a;
        int a2;
        int a3;
        int a4;
        if (getClass().equals(lVar.getClass())) {
            int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(lVar.a()));
            if (compareTo == 0) {
                if (!a() || (a4 = org.apache.thrift.b.a(this.a, lVar.a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(lVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a3 = org.apache.thrift.b.a(this.b, lVar.b)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(lVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a2 = org.apache.thrift.b.a(this.c, lVar.c)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(lVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a = org.apache.thrift.b.a(this.d, lVar.d)) == 0) {
                                            return 0;
                                        }
                                        return a;
                                    }
                                    return compareTo4;
                                }
                                return a2;
                            }
                            return compareTo3;
                        }
                        return a3;
                    }
                    return compareTo2;
                }
                return a4;
            }
            return compareTo;
        }
        return getClass().getName().compareTo(lVar.getClass().getName());
    }

    @Override // org.apache.thrift.a
    public void b(org.apache.thrift.protocol.e eVar) {
        e();
        eVar.a(e);
        if (this.a != null) {
            eVar.a(f);
            this.a.b(eVar);
            eVar.b();
        }
        if (this.b != null && b()) {
            eVar.a(g);
            eVar.a(this.b);
            eVar.b();
        }
        if (c()) {
            eVar.a(h);
            eVar.a(this.c);
            eVar.b();
        }
        if (d()) {
            eVar.a(i);
            eVar.a(this.d);
            eVar.b();
        }
        eVar.c();
        eVar.a();
    }

    public void b(boolean z) {
        this.j.set(1, z);
    }

    public boolean b() {
        return this.b != null;
    }

    public boolean c() {
        return this.j.get(0);
    }

    public boolean d() {
        return this.j.get(1);
    }

    public void e() {
        if (this.a == null) {
            throw new org.apache.thrift.protocol.f("Required field 'location' was not present! Struct: " + toString());
        }
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof l)) {
            return a((l) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("GPS(");
        sb.append("location:");
        if (this.a == null) {
            sb.append("null");
        } else {
            sb.append(this.a);
        }
        if (b()) {
            sb.append(", ");
            sb.append("provider:");
            if (this.b == null) {
                sb.append("null");
            } else {
                sb.append(this.b);
            }
        }
        if (c()) {
            sb.append(", ");
            sb.append("period:");
            sb.append(this.c);
        }
        if (d()) {
            sb.append(", ");
            sb.append("accuracy:");
            sb.append(this.d);
        }
        sb.append(")");
        return sb.toString();
    }
}
