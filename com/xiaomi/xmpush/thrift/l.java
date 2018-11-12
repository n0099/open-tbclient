package com.xiaomi.xmpush.thrift;

import com.baidu.searchbox.ng.ai.apps.impl.map.model.element.CoordinateModel;
import java.io.Serializable;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes3.dex */
public class l implements Serializable, Cloneable, org.apache.thrift.a<l, a> {
    public static final Map<a, org.apache.thrift.meta_data.b> c;
    private static final org.apache.thrift.protocol.j d = new org.apache.thrift.protocol.j("Location");
    private static final org.apache.thrift.protocol.b e = new org.apache.thrift.protocol.b(CoordinateModel.LONGITUDE, (byte) 4, 1);
    private static final org.apache.thrift.protocol.b f = new org.apache.thrift.protocol.b(CoordinateModel.LATITUDE, (byte) 4, 2);
    public double a;
    public double b;
    private BitSet g = new BitSet(2);

    /* loaded from: classes3.dex */
    public enum a {
        LONGITUDE(1, CoordinateModel.LONGITUDE),
        LATITUDE(2, CoordinateModel.LATITUDE);
        
        private static final Map<String, a> c = new HashMap();
        private final short d;
        private final String e;

        static {
            Iterator it = EnumSet.allOf(a.class).iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                c.put(aVar.a(), aVar);
            }
        }

        a(short s, String str) {
            this.d = s;
            this.e = str;
        }

        public String a() {
            return this.e;
        }
    }

    static {
        EnumMap enumMap = new EnumMap(a.class);
        enumMap.put((EnumMap) a.LONGITUDE, (a) new org.apache.thrift.meta_data.b(CoordinateModel.LONGITUDE, (byte) 1, new org.apache.thrift.meta_data.c((byte) 4)));
        enumMap.put((EnumMap) a.LATITUDE, (a) new org.apache.thrift.meta_data.b(CoordinateModel.LATITUDE, (byte) 1, new org.apache.thrift.meta_data.c((byte) 4)));
        c = Collections.unmodifiableMap(enumMap);
        org.apache.thrift.meta_data.b.a(l.class, c);
    }

    public double a() {
        return this.a;
    }

    public l a(double d2) {
        this.a = d2;
        a(true);
        return this;
    }

    @Override // org.apache.thrift.a
    public void a(org.apache.thrift.protocol.e eVar) {
        eVar.g();
        while (true) {
            org.apache.thrift.protocol.b i = eVar.i();
            if (i.b == 0) {
                eVar.h();
                if (!b()) {
                    throw new org.apache.thrift.protocol.f("Required field 'longitude' was not found in serialized data! Struct: " + toString());
                }
                if (!d()) {
                    throw new org.apache.thrift.protocol.f("Required field 'latitude' was not found in serialized data! Struct: " + toString());
                }
                e();
                return;
            }
            switch (i.c) {
                case 1:
                    if (i.b != 4) {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    } else {
                        this.a = eVar.v();
                        a(true);
                        break;
                    }
                case 2:
                    if (i.b != 4) {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    } else {
                        this.b = eVar.v();
                        b(true);
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
        this.g.set(0, z);
    }

    public boolean a(l lVar) {
        return lVar != null && this.a == lVar.a && this.b == lVar.b;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: b */
    public int compareTo(l lVar) {
        int a2;
        int a3;
        if (getClass().equals(lVar.getClass())) {
            int compareTo = Boolean.valueOf(b()).compareTo(Boolean.valueOf(lVar.b()));
            if (compareTo == 0) {
                if (!b() || (a3 = org.apache.thrift.b.a(this.a, lVar.a)) == 0) {
                    int compareTo2 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(lVar.d()));
                    if (compareTo2 == 0) {
                        if (!d() || (a2 = org.apache.thrift.b.a(this.b, lVar.b)) == 0) {
                            return 0;
                        }
                        return a2;
                    }
                    return compareTo2;
                }
                return a3;
            }
            return compareTo;
        }
        return getClass().getName().compareTo(lVar.getClass().getName());
    }

    public l b(double d2) {
        this.b = d2;
        b(true);
        return this;
    }

    @Override // org.apache.thrift.a
    public void b(org.apache.thrift.protocol.e eVar) {
        e();
        eVar.a(d);
        eVar.a(e);
        eVar.a(this.a);
        eVar.b();
        eVar.a(f);
        eVar.a(this.b);
        eVar.b();
        eVar.c();
        eVar.a();
    }

    public void b(boolean z) {
        this.g.set(1, z);
    }

    public boolean b() {
        return this.g.get(0);
    }

    public double c() {
        return this.b;
    }

    public boolean d() {
        return this.g.get(1);
    }

    public void e() {
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
        return "Location(longitude:" + this.a + ", latitude:" + this.b + ")";
    }
}
