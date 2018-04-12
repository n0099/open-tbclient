package com.xiaomi.xmpush.thrift;

import java.io.Serializable;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
/* loaded from: classes3.dex */
public class s implements Serializable, Cloneable, org.apache.thrift.a<s, a> {
    public static final Map<a, org.apache.thrift.meta_data.b> b;
    private static final org.apache.thrift.protocol.j c = new org.apache.thrift.protocol.j("RegisteredGeoFencing");
    private static final org.apache.thrift.protocol.b d = new org.apache.thrift.protocol.b("geoFencings", (byte) 14, 1);
    public Set<j> a;

    /* loaded from: classes3.dex */
    public enum a {
        GEO_FENCINGS(1, "geoFencings");
        
        private static final Map<String, a> b = new HashMap();
        private final short c;
        private final String d;

        static {
            Iterator it = EnumSet.allOf(a.class).iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                b.put(aVar.a(), aVar);
            }
        }

        a(short s, String str) {
            this.c = s;
            this.d = str;
        }

        public String a() {
            return this.d;
        }
    }

    static {
        EnumMap enumMap = new EnumMap(a.class);
        enumMap.put((EnumMap) a.GEO_FENCINGS, (a) new org.apache.thrift.meta_data.b("geoFencings", (byte) 1, new org.apache.thrift.meta_data.f((byte) 14, new org.apache.thrift.meta_data.g((byte) 12, j.class))));
        b = Collections.unmodifiableMap(enumMap);
        org.apache.thrift.meta_data.b.a(s.class, b);
    }

    public s a(Set<j> set) {
        this.a = set;
        return this;
    }

    public Set<j> a() {
        return this.a;
    }

    @Override // org.apache.thrift.a
    public void a(org.apache.thrift.protocol.e eVar) {
        eVar.g();
        while (true) {
            org.apache.thrift.protocol.b i = eVar.i();
            if (i.b == 0) {
                eVar.h();
                c();
                return;
            }
            switch (i.c) {
                case 1:
                    if (i.b == 14) {
                        org.apache.thrift.protocol.i o = eVar.o();
                        this.a = new HashSet(o.b * 2);
                        for (int i2 = 0; i2 < o.b; i2++) {
                            j jVar = new j();
                            jVar.a(eVar);
                            this.a.add(jVar);
                        }
                        eVar.p();
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

    public boolean a(s sVar) {
        if (sVar == null) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = sVar.b();
        return !(b2 || b3) || (b2 && b3 && this.a.equals(sVar.a));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: b */
    public int compareTo(s sVar) {
        int a2;
        if (getClass().equals(sVar.getClass())) {
            int compareTo = Boolean.valueOf(b()).compareTo(Boolean.valueOf(sVar.b()));
            if (compareTo == 0) {
                if (!b() || (a2 = org.apache.thrift.b.a(this.a, sVar.a)) == 0) {
                    return 0;
                }
                return a2;
            }
            return compareTo;
        }
        return getClass().getName().compareTo(sVar.getClass().getName());
    }

    @Override // org.apache.thrift.a
    public void b(org.apache.thrift.protocol.e eVar) {
        c();
        eVar.a(c);
        if (this.a != null) {
            eVar.a(d);
            eVar.a(new org.apache.thrift.protocol.i((byte) 12, this.a.size()));
            for (j jVar : this.a) {
                jVar.b(eVar);
            }
            eVar.f();
            eVar.b();
        }
        eVar.c();
        eVar.a();
    }

    public boolean b() {
        return this.a != null;
    }

    public void c() {
        if (this.a == null) {
            throw new org.apache.thrift.protocol.f("Required field 'geoFencings' was not present! Struct: " + toString());
        }
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof s)) {
            return a((s) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("RegisteredGeoFencing(");
        sb.append("geoFencings:");
        if (this.a == null) {
            sb.append("null");
        } else {
            sb.append(this.a);
        }
        sb.append(")");
        return sb.toString();
    }
}
