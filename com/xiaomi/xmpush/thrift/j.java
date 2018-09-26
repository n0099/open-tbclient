package com.xiaomi.xmpush.thrift;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public class j implements Serializable, Cloneable, org.apache.thrift.a<j, a> {
    public static final Map<a, org.apache.thrift.meta_data.b> k;
    private static final org.apache.thrift.protocol.j l = new org.apache.thrift.protocol.j("GeoFencing");
    private static final org.apache.thrift.protocol.b m = new org.apache.thrift.protocol.b("id", (byte) 11, 1);
    private static final org.apache.thrift.protocol.b n = new org.apache.thrift.protocol.b("name", (byte) 11, 2);
    private static final org.apache.thrift.protocol.b o = new org.apache.thrift.protocol.b("appId", (byte) 10, 3);
    private static final org.apache.thrift.protocol.b p = new org.apache.thrift.protocol.b("packageName", (byte) 11, 4);
    private static final org.apache.thrift.protocol.b q = new org.apache.thrift.protocol.b("createTime", (byte) 10, 5);
    private static final org.apache.thrift.protocol.b r = new org.apache.thrift.protocol.b("type", (byte) 8, 6);
    private static final org.apache.thrift.protocol.b s = new org.apache.thrift.protocol.b("circleCenter", (byte) 12, 7);
    private static final org.apache.thrift.protocol.b t = new org.apache.thrift.protocol.b("circleRadius", (byte) 4, 9);
    private static final org.apache.thrift.protocol.b u = new org.apache.thrift.protocol.b("polygonPoints", (byte) 15, 10);
    private static final org.apache.thrift.protocol.b v = new org.apache.thrift.protocol.b("coordinateProvider", (byte) 8, 11);
    public String a;
    public String b;
    public long c;
    public String d;
    public long e;
    public k f;
    public l g;
    public double h;
    public List<l> i;
    public h j;
    private BitSet w = new BitSet(3);

    /* loaded from: classes3.dex */
    public enum a {
        ID(1, "id"),
        NAME(2, "name"),
        APP_ID(3, "appId"),
        PACKAGE_NAME(4, "packageName"),
        CREATE_TIME(5, "createTime"),
        TYPE(6, "type"),
        CIRCLE_CENTER(7, "circleCenter"),
        CIRCLE_RADIUS(9, "circleRadius"),
        POLYGON_POINTS(10, "polygonPoints"),
        COORDINATE_PROVIDER(11, "coordinateProvider");
        
        private static final Map<String, a> k = new HashMap();
        private final short l;
        private final String m;

        static {
            Iterator it = EnumSet.allOf(a.class).iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                k.put(aVar.a(), aVar);
            }
        }

        a(short s, String str) {
            this.l = s;
            this.m = str;
        }

        public String a() {
            return this.m;
        }
    }

    static {
        EnumMap enumMap = new EnumMap(a.class);
        enumMap.put((EnumMap) a.ID, (a) new org.apache.thrift.meta_data.b("id", (byte) 1, new org.apache.thrift.meta_data.c((byte) 11)));
        enumMap.put((EnumMap) a.NAME, (a) new org.apache.thrift.meta_data.b("name", (byte) 1, new org.apache.thrift.meta_data.c((byte) 11)));
        enumMap.put((EnumMap) a.APP_ID, (a) new org.apache.thrift.meta_data.b("appId", (byte) 1, new org.apache.thrift.meta_data.c((byte) 10)));
        enumMap.put((EnumMap) a.PACKAGE_NAME, (a) new org.apache.thrift.meta_data.b("packageName", (byte) 1, new org.apache.thrift.meta_data.c((byte) 11)));
        enumMap.put((EnumMap) a.CREATE_TIME, (a) new org.apache.thrift.meta_data.b("createTime", (byte) 1, new org.apache.thrift.meta_data.c((byte) 10)));
        enumMap.put((EnumMap) a.TYPE, (a) new org.apache.thrift.meta_data.b("type", (byte) 1, new org.apache.thrift.meta_data.a((byte) 16, k.class)));
        enumMap.put((EnumMap) a.CIRCLE_CENTER, (a) new org.apache.thrift.meta_data.b("circleCenter", (byte) 2, new org.apache.thrift.meta_data.g((byte) 12, l.class)));
        enumMap.put((EnumMap) a.CIRCLE_RADIUS, (a) new org.apache.thrift.meta_data.b("circleRadius", (byte) 2, new org.apache.thrift.meta_data.c((byte) 4)));
        enumMap.put((EnumMap) a.POLYGON_POINTS, (a) new org.apache.thrift.meta_data.b("polygonPoints", (byte) 2, new org.apache.thrift.meta_data.d((byte) 15, new org.apache.thrift.meta_data.g((byte) 12, l.class))));
        enumMap.put((EnumMap) a.COORDINATE_PROVIDER, (a) new org.apache.thrift.meta_data.b("coordinateProvider", (byte) 1, new org.apache.thrift.meta_data.a((byte) 16, h.class)));
        k = Collections.unmodifiableMap(enumMap);
        org.apache.thrift.meta_data.b.a(j.class, k);
    }

    public j a(double d) {
        this.h = d;
        c(true);
        return this;
    }

    public j a(long j) {
        this.c = j;
        a(true);
        return this;
    }

    public j a(h hVar) {
        this.j = hVar;
        return this;
    }

    public j a(k kVar) {
        this.f = kVar;
        return this;
    }

    public j a(l lVar) {
        this.g = lVar;
        return this;
    }

    public j a(String str) {
        this.a = str;
        return this;
    }

    public j a(List<l> list) {
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
                        this.f = k.a(eVar.t());
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    }
                case 7:
                    if (i.b == 12) {
                        this.g = new l();
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
                            l lVar = new l();
                            lVar.a(eVar);
                            this.i.add(lVar);
                        }
                        eVar.n();
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    }
                case 11:
                    if (i.b == 8) {
                        this.j = h.a(eVar.t());
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
        this.w.set(0, z);
    }

    public boolean a(j jVar) {
        if (jVar == null) {
            return false;
        }
        boolean b = b();
        boolean b2 = jVar.b();
        if ((b || b2) && !(b && b2 && this.a.equals(jVar.a))) {
            return false;
        }
        boolean d = d();
        boolean d2 = jVar.d();
        if (((d || d2) && !(d && d2 && this.b.equals(jVar.b))) || this.c != jVar.c) {
            return false;
        }
        boolean h = h();
        boolean h2 = jVar.h();
        if (((h || h2) && !(h && h2 && this.d.equals(jVar.d))) || this.e != jVar.e) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = jVar.l();
        if ((l2 || l3) && !(l2 && l3 && this.f.equals(jVar.f))) {
            return false;
        }
        boolean n2 = n();
        boolean n3 = jVar.n();
        if ((n2 || n3) && !(n2 && n3 && this.g.a(jVar.g))) {
            return false;
        }
        boolean p2 = p();
        boolean p3 = jVar.p();
        if ((p2 || p3) && !(p2 && p3 && this.h == jVar.h)) {
            return false;
        }
        boolean r2 = r();
        boolean r3 = jVar.r();
        if ((r2 || r3) && !(r2 && r3 && this.i.equals(jVar.i))) {
            return false;
        }
        boolean t2 = t();
        boolean t3 = jVar.t();
        return !(t2 || t3) || (t2 && t3 && this.j.equals(jVar.j));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: b */
    public int compareTo(j jVar) {
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
        if (getClass().equals(jVar.getClass())) {
            int compareTo = Boolean.valueOf(b()).compareTo(Boolean.valueOf(jVar.b()));
            if (compareTo == 0) {
                if (!b() || (a11 = org.apache.thrift.b.a(this.a, jVar.a)) == 0) {
                    int compareTo2 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(jVar.d()));
                    if (compareTo2 == 0) {
                        if (!d() || (a10 = org.apache.thrift.b.a(this.b, jVar.b)) == 0) {
                            int compareTo3 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(jVar.f()));
                            if (compareTo3 == 0) {
                                if (!f() || (a9 = org.apache.thrift.b.a(this.c, jVar.c)) == 0) {
                                    int compareTo4 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(jVar.h()));
                                    if (compareTo4 == 0) {
                                        if (!h() || (a8 = org.apache.thrift.b.a(this.d, jVar.d)) == 0) {
                                            int compareTo5 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(jVar.j()));
                                            if (compareTo5 == 0) {
                                                if (!j() || (a7 = org.apache.thrift.b.a(this.e, jVar.e)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(jVar.l()));
                                                    if (compareTo6 == 0) {
                                                        if (!l() || (a6 = org.apache.thrift.b.a(this.f, jVar.f)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(jVar.n()));
                                                            if (compareTo7 == 0) {
                                                                if (!n() || (a5 = org.apache.thrift.b.a(this.g, jVar.g)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(p()).compareTo(Boolean.valueOf(jVar.p()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!p() || (a4 = org.apache.thrift.b.a(this.h, jVar.h)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(r()).compareTo(Boolean.valueOf(jVar.r()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!r() || (a3 = org.apache.thrift.b.a(this.i, jVar.i)) == 0) {
                                                                                    int compareTo10 = Boolean.valueOf(t()).compareTo(Boolean.valueOf(jVar.t()));
                                                                                    if (compareTo10 == 0) {
                                                                                        if (!t() || (a2 = org.apache.thrift.b.a(this.j, jVar.j)) == 0) {
                                                                                            return 0;
                                                                                        }
                                                                                        return a2;
                                                                                    }
                                                                                    return compareTo10;
                                                                                }
                                                                                return a3;
                                                                            }
                                                                            return compareTo9;
                                                                        }
                                                                        return a4;
                                                                    }
                                                                    return compareTo8;
                                                                }
                                                                return a5;
                                                            }
                                                            return compareTo7;
                                                        }
                                                        return a6;
                                                    }
                                                    return compareTo6;
                                                }
                                                return a7;
                                            }
                                            return compareTo5;
                                        }
                                        return a8;
                                    }
                                    return compareTo4;
                                }
                                return a9;
                            }
                            return compareTo3;
                        }
                        return a10;
                    }
                    return compareTo2;
                }
                return a11;
            }
            return compareTo;
        }
        return getClass().getName().compareTo(jVar.getClass().getName());
    }

    public j b(long j) {
        this.e = j;
        b(true);
        return this;
    }

    public j b(String str) {
        this.b = str;
        return this;
    }

    @Override // org.apache.thrift.a
    public void b(org.apache.thrift.protocol.e eVar) {
        u();
        eVar.a(l);
        if (this.a != null) {
            eVar.a(m);
            eVar.a(this.a);
            eVar.b();
        }
        if (this.b != null) {
            eVar.a(n);
            eVar.a(this.b);
            eVar.b();
        }
        eVar.a(o);
        eVar.a(this.c);
        eVar.b();
        if (this.d != null) {
            eVar.a(p);
            eVar.a(this.d);
            eVar.b();
        }
        eVar.a(q);
        eVar.a(this.e);
        eVar.b();
        if (this.f != null) {
            eVar.a(r);
            eVar.a(this.f.a());
            eVar.b();
        }
        if (this.g != null && n()) {
            eVar.a(s);
            this.g.b(eVar);
            eVar.b();
        }
        if (p()) {
            eVar.a(t);
            eVar.a(this.h);
            eVar.b();
        }
        if (this.i != null && r()) {
            eVar.a(u);
            eVar.a(new org.apache.thrift.protocol.c((byte) 12, this.i.size()));
            for (l lVar : this.i) {
                lVar.b(eVar);
            }
            eVar.e();
            eVar.b();
        }
        if (this.j != null) {
            eVar.a(v);
            eVar.a(this.j.a());
            eVar.b();
        }
        eVar.c();
        eVar.a();
    }

    public void b(boolean z) {
        this.w.set(1, z);
    }

    public boolean b() {
        return this.a != null;
    }

    public j c(String str) {
        this.d = str;
        return this;
    }

    public String c() {
        return this.b;
    }

    public void c(boolean z) {
        this.w.set(2, z);
    }

    public boolean d() {
        return this.b != null;
    }

    public long e() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof j)) {
            return a((j) obj);
        }
        return false;
    }

    public boolean f() {
        return this.w.get(0);
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
        return this.w.get(1);
    }

    public k k() {
        return this.f;
    }

    public boolean l() {
        return this.f != null;
    }

    public l m() {
        return this.g;
    }

    public boolean n() {
        return this.g != null;
    }

    public double o() {
        return this.h;
    }

    public boolean p() {
        return this.w.get(2);
    }

    public List<l> q() {
        return this.i;
    }

    public boolean r() {
        return this.i != null;
    }

    public h s() {
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
