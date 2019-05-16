package com.xiaomi.xmpush.thrift;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import org.apache.thrift.TFieldIdEnum;
/* loaded from: classes3.dex */
public class m implements Serializable, Cloneable, org.apache.thrift.a<m, TFieldIdEnum> {
    private static final org.apache.thrift.protocol.j k = new org.apache.thrift.protocol.j("GeoFencing");
    private static final org.apache.thrift.protocol.b l = new org.apache.thrift.protocol.b("", (byte) 11, 1);
    private static final org.apache.thrift.protocol.b m = new org.apache.thrift.protocol.b("", (byte) 11, 2);
    private static final org.apache.thrift.protocol.b n = new org.apache.thrift.protocol.b("", (byte) 10, 3);
    private static final org.apache.thrift.protocol.b o = new org.apache.thrift.protocol.b("", (byte) 11, 4);
    private static final org.apache.thrift.protocol.b p = new org.apache.thrift.protocol.b("", (byte) 10, 5);
    private static final org.apache.thrift.protocol.b q = new org.apache.thrift.protocol.b("", (byte) 8, 6);
    private static final org.apache.thrift.protocol.b r = new org.apache.thrift.protocol.b("", (byte) 12, 7);
    private static final org.apache.thrift.protocol.b s = new org.apache.thrift.protocol.b("", (byte) 4, 9);
    private static final org.apache.thrift.protocol.b t = new org.apache.thrift.protocol.b("", (byte) 15, 10);
    private static final org.apache.thrift.protocol.b u = new org.apache.thrift.protocol.b("", (byte) 8, 11);
    public String a;
    public String b;
    public long c;
    public String d;
    public long e;
    public n f;
    public o g;
    public double h;
    public List<o> i;
    public j j;
    private BitSet v = new BitSet(3);

    public m a(double d) {
        this.h = d;
        c(true);
        return this;
    }

    public m a(long j) {
        this.c = j;
        a(true);
        return this;
    }

    public m a(j jVar) {
        this.j = jVar;
        return this;
    }

    public m a(n nVar) {
        this.f = nVar;
        return this;
    }

    public m a(o oVar) {
        this.g = oVar;
        return this;
    }

    public m a(String str) {
        this.a = str;
        return this;
    }

    public m a(List<o> list) {
        this.i = list;
        return this;
    }

    public String a() {
        return this.a;
    }

    @Override // org.apache.thrift.a
    public void a(org.apache.thrift.protocol.e eVar) {
        eVar.g();
        while (true) {
            org.apache.thrift.protocol.b i = eVar.i();
            if (i.b == 0) {
                eVar.h();
                if (!f()) {
                    throw new org.apache.thrift.protocol.f("Required field 'appId' was not found in serialized data! Struct: " + toString());
                }
                if (!j()) {
                    throw new org.apache.thrift.protocol.f("Required field 'createTime' was not found in serialized data! Struct: " + toString());
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
                    if (i.b == 11) {
                        this.b = eVar.w();
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    }
                case 3:
                    if (i.b == 10) {
                        this.c = eVar.u();
                        a(true);
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
                        b(true);
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    }
                case 6:
                    if (i.b == 8) {
                        this.f = n.a(eVar.t());
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    }
                case 7:
                    if (i.b == 12) {
                        this.g = new o();
                        this.g.a(eVar);
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
                    if (i.b == 4) {
                        this.h = eVar.v();
                        c(true);
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    }
                case 10:
                    if (i.b == 15) {
                        org.apache.thrift.protocol.c m2 = eVar.m();
                        this.i = new ArrayList(m2.b);
                        for (int i2 = 0; i2 < m2.b; i2++) {
                            o oVar = new o();
                            oVar.a(eVar);
                            this.i.add(oVar);
                        }
                        eVar.n();
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    }
                case 11:
                    if (i.b == 8) {
                        this.j = j.a(eVar.t());
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

    public boolean a(m mVar) {
        if (mVar == null) {
            return false;
        }
        boolean b = b();
        boolean b2 = mVar.b();
        if ((b || b2) && !(b && b2 && this.a.equals(mVar.a))) {
            return false;
        }
        boolean d = d();
        boolean d2 = mVar.d();
        if (((d || d2) && !(d && d2 && this.b.equals(mVar.b))) || this.c != mVar.c) {
            return false;
        }
        boolean h = h();
        boolean h2 = mVar.h();
        if (((h || h2) && !(h && h2 && this.d.equals(mVar.d))) || this.e != mVar.e) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = mVar.l();
        if ((l2 || l3) && !(l2 && l3 && this.f.equals(mVar.f))) {
            return false;
        }
        boolean n2 = n();
        boolean n3 = mVar.n();
        if ((n2 || n3) && !(n2 && n3 && this.g.a(mVar.g))) {
            return false;
        }
        boolean p2 = p();
        boolean p3 = mVar.p();
        if ((p2 || p3) && !(p2 && p3 && this.h == mVar.h)) {
            return false;
        }
        boolean r2 = r();
        boolean r3 = mVar.r();
        if ((r2 || r3) && !(r2 && r3 && this.i.equals(mVar.i))) {
            return false;
        }
        boolean t2 = t();
        boolean t3 = mVar.t();
        return !(t2 || t3) || (t2 && t3 && this.j.equals(mVar.j));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: b */
    public int compareTo(m mVar) {
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
        if (getClass().equals(mVar.getClass())) {
            int compareTo = Boolean.valueOf(b()).compareTo(Boolean.valueOf(mVar.b()));
            if (compareTo == 0) {
                if (!b() || (a10 = org.apache.thrift.b.a(this.a, mVar.a)) == 0) {
                    int compareTo2 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(mVar.d()));
                    if (compareTo2 == 0) {
                        if (!d() || (a9 = org.apache.thrift.b.a(this.b, mVar.b)) == 0) {
                            int compareTo3 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(mVar.f()));
                            if (compareTo3 == 0) {
                                if (!f() || (a8 = org.apache.thrift.b.a(this.c, mVar.c)) == 0) {
                                    int compareTo4 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(mVar.h()));
                                    if (compareTo4 == 0) {
                                        if (!h() || (a7 = org.apache.thrift.b.a(this.d, mVar.d)) == 0) {
                                            int compareTo5 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(mVar.j()));
                                            if (compareTo5 == 0) {
                                                if (!j() || (a6 = org.apache.thrift.b.a(this.e, mVar.e)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(mVar.l()));
                                                    if (compareTo6 == 0) {
                                                        if (!l() || (a5 = org.apache.thrift.b.a(this.f, mVar.f)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(mVar.n()));
                                                            if (compareTo7 == 0) {
                                                                if (!n() || (a4 = org.apache.thrift.b.a(this.g, mVar.g)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(p()).compareTo(Boolean.valueOf(mVar.p()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!p() || (a3 = org.apache.thrift.b.a(this.h, mVar.h)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(r()).compareTo(Boolean.valueOf(mVar.r()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!r() || (a2 = org.apache.thrift.b.a(this.i, mVar.i)) == 0) {
                                                                                    int compareTo10 = Boolean.valueOf(t()).compareTo(Boolean.valueOf(mVar.t()));
                                                                                    if (compareTo10 == 0) {
                                                                                        if (!t() || (a = org.apache.thrift.b.a(this.j, mVar.j)) == 0) {
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
        return getClass().getName().compareTo(mVar.getClass().getName());
    }

    public m b(long j) {
        this.e = j;
        b(true);
        return this;
    }

    public m b(String str) {
        this.b = str;
        return this;
    }

    @Override // org.apache.thrift.a
    public void b(org.apache.thrift.protocol.e eVar) {
        u();
        eVar.a(k);
        if (this.a != null) {
            eVar.a(l);
            eVar.a(this.a);
            eVar.b();
        }
        if (this.b != null) {
            eVar.a(m);
            eVar.a(this.b);
            eVar.b();
        }
        eVar.a(n);
        eVar.a(this.c);
        eVar.b();
        if (this.d != null) {
            eVar.a(o);
            eVar.a(this.d);
            eVar.b();
        }
        eVar.a(p);
        eVar.a(this.e);
        eVar.b();
        if (this.f != null) {
            eVar.a(q);
            eVar.a(this.f.a());
            eVar.b();
        }
        if (this.g != null && n()) {
            eVar.a(r);
            this.g.b(eVar);
            eVar.b();
        }
        if (p()) {
            eVar.a(s);
            eVar.a(this.h);
            eVar.b();
        }
        if (this.i != null && r()) {
            eVar.a(t);
            eVar.a(new org.apache.thrift.protocol.c((byte) 12, this.i.size()));
            for (o oVar : this.i) {
                oVar.b(eVar);
            }
            eVar.e();
            eVar.b();
        }
        if (this.j != null) {
            eVar.a(u);
            eVar.a(this.j.a());
            eVar.b();
        }
        eVar.c();
        eVar.a();
    }

    public void b(boolean z) {
        this.v.set(1, z);
    }

    public boolean b() {
        return this.a != null;
    }

    public m c(String str) {
        this.d = str;
        return this;
    }

    public String c() {
        return this.b;
    }

    public void c(boolean z) {
        this.v.set(2, z);
    }

    public boolean d() {
        return this.b != null;
    }

    public long e() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof m)) {
            return a((m) obj);
        }
        return false;
    }

    public boolean f() {
        return this.v.get(0);
    }

    public String g() {
        return this.d;
    }

    public boolean h() {
        return this.d != null;
    }

    public int hashCode() {
        return 0;
    }

    public long i() {
        return this.e;
    }

    public boolean j() {
        return this.v.get(1);
    }

    public n k() {
        return this.f;
    }

    public boolean l() {
        return this.f != null;
    }

    public o m() {
        return this.g;
    }

    public boolean n() {
        return this.g != null;
    }

    public double o() {
        return this.h;
    }

    public boolean p() {
        return this.v.get(2);
    }

    public List<o> q() {
        return this.i;
    }

    public boolean r() {
        return this.i != null;
    }

    public j s() {
        return this.j;
    }

    public boolean t() {
        return this.j != null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("GeoFencing(");
        sb.append("id:");
        if (this.a == null) {
            sb.append("null");
        } else {
            sb.append(this.a);
        }
        sb.append(", ");
        sb.append("name:");
        if (this.b == null) {
            sb.append("null");
        } else {
            sb.append(this.b);
        }
        sb.append(", ");
        sb.append("appId:");
        sb.append(this.c);
        sb.append(", ");
        sb.append("packageName:");
        if (this.d == null) {
            sb.append("null");
        } else {
            sb.append(this.d);
        }
        sb.append(", ");
        sb.append("createTime:");
        sb.append(this.e);
        sb.append(", ");
        sb.append("type:");
        if (this.f == null) {
            sb.append("null");
        } else {
            sb.append(this.f);
        }
        if (n()) {
            sb.append(", ");
            sb.append("circleCenter:");
            if (this.g == null) {
                sb.append("null");
            } else {
                sb.append(this.g);
            }
        }
        if (p()) {
            sb.append(", ");
            sb.append("circleRadius:");
            sb.append(this.h);
        }
        if (r()) {
            sb.append(", ");
            sb.append("polygonPoints:");
            if (this.i == null) {
                sb.append("null");
            } else {
                sb.append(this.i);
            }
        }
        sb.append(", ");
        sb.append("coordinateProvider:");
        if (this.j == null) {
            sb.append("null");
        } else {
            sb.append(this.j);
        }
        sb.append(")");
        return sb.toString();
    }

    public void u() {
        if (this.a == null) {
            throw new org.apache.thrift.protocol.f("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.b == null) {
            throw new org.apache.thrift.protocol.f("Required field 'name' was not present! Struct: " + toString());
        }
        if (this.d == null) {
            throw new org.apache.thrift.protocol.f("Required field 'packageName' was not present! Struct: " + toString());
        }
        if (this.f == null) {
            throw new org.apache.thrift.protocol.f("Required field 'type' was not present! Struct: " + toString());
        }
        if (this.j == null) {
            throw new org.apache.thrift.protocol.f("Required field 'coordinateProvider' was not present! Struct: " + toString());
        }
    }
}
