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
public class n implements Serializable, Cloneable, org.apache.thrift.a<n, a> {
    public static final Map<a, org.apache.thrift.meta_data.b> d;
    private static final org.apache.thrift.protocol.j e = new org.apache.thrift.protocol.j("NormalConfig");
    private static final org.apache.thrift.protocol.b f = new org.apache.thrift.protocol.b("version", (byte) 8, 1);
    private static final org.apache.thrift.protocol.b g = new org.apache.thrift.protocol.b("configItems", (byte) 15, 2);
    private static final org.apache.thrift.protocol.b h = new org.apache.thrift.protocol.b("type", (byte) 8, 3);
    public int a;
    public List<p> b;
    public f c;
    private BitSet i = new BitSet(1);

    /* loaded from: classes3.dex */
    public enum a {
        VERSION(1, "version"),
        CONFIG_ITEMS(2, "configItems"),
        TYPE(3, "type");
        
        private static final Map<String, a> d = new HashMap();
        private final short e;
        private final String f;

        static {
            Iterator it = EnumSet.allOf(a.class).iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                d.put(aVar.a(), aVar);
            }
        }

        a(short s, String str) {
            this.e = s;
            this.f = str;
        }

        public String a() {
            return this.f;
        }
    }

    static {
        EnumMap enumMap = new EnumMap(a.class);
        enumMap.put((EnumMap) a.VERSION, (a) new org.apache.thrift.meta_data.b("version", (byte) 1, new org.apache.thrift.meta_data.c((byte) 8)));
        enumMap.put((EnumMap) a.CONFIG_ITEMS, (a) new org.apache.thrift.meta_data.b("configItems", (byte) 1, new org.apache.thrift.meta_data.d((byte) 15, new org.apache.thrift.meta_data.g((byte) 12, p.class))));
        enumMap.put((EnumMap) a.TYPE, (a) new org.apache.thrift.meta_data.b("type", (byte) 1, new org.apache.thrift.meta_data.a((byte) 16, f.class)));
        d = Collections.unmodifiableMap(enumMap);
        org.apache.thrift.meta_data.b.a(n.class, d);
    }

    public int a() {
        return this.a;
    }

    @Override // org.apache.thrift.a
    public void a(org.apache.thrift.protocol.e eVar) {
        eVar.g();
        while (true) {
            org.apache.thrift.protocol.b i = eVar.i();
            if (i.b == 0) {
                eVar.h();
                if (!b()) {
                    throw new org.apache.thrift.protocol.f("Required field 'version' was not found in serialized data! Struct: " + toString());
                }
                f();
                return;
            }
            switch (i.c) {
                case 1:
                    if (i.b == 8) {
                        this.a = eVar.t();
                        a(true);
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    }
                case 2:
                    if (i.b == 15) {
                        org.apache.thrift.protocol.c m = eVar.m();
                        this.b = new ArrayList(m.b);
                        for (int i2 = 0; i2 < m.b; i2++) {
                            p pVar = new p();
                            pVar.a(eVar);
                            this.b.add(pVar);
                        }
                        eVar.n();
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    }
                case 3:
                    if (i.b == 8) {
                        this.c = f.a(eVar.t());
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

    public void a(boolean z) {
        this.i.set(0, z);
    }

    public boolean a(n nVar) {
        if (nVar != null && this.a == nVar.a) {
            boolean c = c();
            boolean c2 = nVar.c();
            if ((c || c2) && !(c && c2 && this.b.equals(nVar.b))) {
                return false;
            }
            boolean e2 = e();
            boolean e3 = nVar.e();
            return !(e2 || e3) || (e2 && e3 && this.c.equals(nVar.c));
        }
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: b */
    public int compareTo(n nVar) {
        int a2;
        int a3;
        int a4;
        if (getClass().equals(nVar.getClass())) {
            int compareTo = Boolean.valueOf(b()).compareTo(Boolean.valueOf(nVar.b()));
            if (compareTo == 0) {
                if (!b() || (a4 = org.apache.thrift.b.a(this.a, nVar.a)) == 0) {
                    int compareTo2 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(nVar.c()));
                    if (compareTo2 == 0) {
                        if (!c() || (a3 = org.apache.thrift.b.a(this.b, nVar.b)) == 0) {
                            int compareTo3 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(nVar.e()));
                            if (compareTo3 == 0) {
                                if (!e() || (a2 = org.apache.thrift.b.a(this.c, nVar.c)) == 0) {
                                    return 0;
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
        return getClass().getName().compareTo(nVar.getClass().getName());
    }

    @Override // org.apache.thrift.a
    public void b(org.apache.thrift.protocol.e eVar) {
        f();
        eVar.a(e);
        eVar.a(f);
        eVar.a(this.a);
        eVar.b();
        if (this.b != null) {
            eVar.a(g);
            eVar.a(new org.apache.thrift.protocol.c((byte) 12, this.b.size()));
            for (p pVar : this.b) {
                pVar.b(eVar);
            }
            eVar.e();
            eVar.b();
        }
        if (this.c != null) {
            eVar.a(h);
            eVar.a(this.c.a());
            eVar.b();
        }
        eVar.c();
        eVar.a();
    }

    public boolean b() {
        return this.i.get(0);
    }

    public boolean c() {
        return this.b != null;
    }

    public f d() {
        return this.c;
    }

    public boolean e() {
        return this.c != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof n)) {
            return a((n) obj);
        }
        return false;
    }

    public void f() {
        if (this.b == null) {
            throw new org.apache.thrift.protocol.f("Required field 'configItems' was not present! Struct: " + toString());
        }
        if (this.c == null) {
            throw new org.apache.thrift.protocol.f("Required field 'type' was not present! Struct: " + toString());
        }
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("NormalConfig(");
        sb.append("version:");
        sb.append(this.a);
        sb.append(", ");
        sb.append("configItems:");
        if (this.b == null) {
            sb.append("null");
        } else {
            sb.append(this.b);
        }
        sb.append(", ");
        sb.append("type:");
        if (this.c == null) {
            sb.append("null");
        } else {
            sb.append(this.c);
        }
        sb.append(")");
        return sb.toString();
    }
}
