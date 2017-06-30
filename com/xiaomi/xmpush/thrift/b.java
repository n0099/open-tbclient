package com.xiaomi.xmpush.thrift;

import java.io.Serializable;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes2.dex */
public class b implements Serializable, Cloneable, org.apache.thrift.a<b, a> {
    public static final Map<a, org.apache.thrift.meta_data.b> c;
    private static final org.apache.thrift.protocol.j d = new org.apache.thrift.protocol.j("Cellular");
    private static final org.apache.thrift.protocol.b e = new org.apache.thrift.protocol.b("id", (byte) 8, 1);
    private static final org.apache.thrift.protocol.b f = new org.apache.thrift.protocol.b("signalStrength", (byte) 8, 2);
    public int a;
    public int b;
    private BitSet g = new BitSet(2);

    /* loaded from: classes2.dex */
    public enum a {
        ID(1, "id"),
        SIGNAL_STRENGTH(2, "signalStrength");
        
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
        enumMap.put((EnumMap) a.ID, (a) new org.apache.thrift.meta_data.b("id", (byte) 1, new org.apache.thrift.meta_data.c((byte) 8)));
        enumMap.put((EnumMap) a.SIGNAL_STRENGTH, (a) new org.apache.thrift.meta_data.b("signalStrength", (byte) 1, new org.apache.thrift.meta_data.c((byte) 8)));
        c = Collections.unmodifiableMap(enumMap);
        org.apache.thrift.meta_data.b.a(b.class, c);
    }

    public b a(int i) {
        this.a = i;
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
                if (!a()) {
                    throw new org.apache.thrift.protocol.f("Required field 'id' was not found in serialized data! Struct: " + toString());
                }
                if (!b()) {
                    throw new org.apache.thrift.protocol.f("Required field 'signalStrength' was not found in serialized data! Struct: " + toString());
                }
                c();
                return;
            }
            switch (i.c) {
                case 1:
                    if (i.b != 8) {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    } else {
                        this.a = eVar.t();
                        a(true);
                        break;
                    }
                case 2:
                    if (i.b != 8) {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    } else {
                        this.b = eVar.t();
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

    public boolean a() {
        return this.g.get(0);
    }

    public boolean a(b bVar) {
        return bVar != null && this.a == bVar.a && this.b == bVar.b;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: b */
    public int compareTo(b bVar) {
        int a2;
        int a3;
        if (getClass().equals(bVar.getClass())) {
            int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(bVar.a()));
            if (compareTo == 0) {
                if (!a() || (a3 = org.apache.thrift.b.a(this.a, bVar.a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(bVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a2 = org.apache.thrift.b.a(this.b, bVar.b)) == 0) {
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
        return getClass().getName().compareTo(bVar.getClass().getName());
    }

    public b b(int i) {
        this.b = i;
        b(true);
        return this;
    }

    @Override // org.apache.thrift.a
    public void b(org.apache.thrift.protocol.e eVar) {
        c();
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
        return this.g.get(1);
    }

    public void c() {
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof b)) {
            return a((b) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        return "Cellular(id:" + this.a + ", signalStrength:" + this.b + ")";
    }
}
