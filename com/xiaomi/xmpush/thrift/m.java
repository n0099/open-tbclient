package com.xiaomi.xmpush.thrift;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public class m implements Serializable, Cloneable, org.apache.thrift.a<m, a> {
    public static final Map<a, org.apache.thrift.meta_data.b> d;
    private static final org.apache.thrift.protocol.j e = new org.apache.thrift.protocol.j("LocationInfo");
    private static final org.apache.thrift.protocol.b f = new org.apache.thrift.protocol.b("wifiList", (byte) 15, 1);
    private static final org.apache.thrift.protocol.b g = new org.apache.thrift.protocol.b("cellList", (byte) 15, 2);
    private static final org.apache.thrift.protocol.b h = new org.apache.thrift.protocol.b("gps", (byte) 12, 3);
    public List<v> a;
    public List<b> b;
    public i c;

    /* loaded from: classes3.dex */
    public enum a {
        WIFI_LIST(1, "wifiList"),
        CELL_LIST(2, "cellList"),
        GPS(3, "gps");
        
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
        enumMap.put((EnumMap) a.WIFI_LIST, (a) new org.apache.thrift.meta_data.b("wifiList", (byte) 2, new org.apache.thrift.meta_data.d((byte) 15, new org.apache.thrift.meta_data.g((byte) 12, v.class))));
        enumMap.put((EnumMap) a.CELL_LIST, (a) new org.apache.thrift.meta_data.b("cellList", (byte) 2, new org.apache.thrift.meta_data.d((byte) 15, new org.apache.thrift.meta_data.g((byte) 12, b.class))));
        enumMap.put((EnumMap) a.GPS, (a) new org.apache.thrift.meta_data.b("gps", (byte) 2, new org.apache.thrift.meta_data.g((byte) 12, i.class)));
        d = Collections.unmodifiableMap(enumMap);
        org.apache.thrift.meta_data.b.a(m.class, d);
    }

    public m a(i iVar) {
        this.c = iVar;
        return this;
    }

    public m a(List<v> list) {
        this.a = list;
        return this;
    }

    @Override // org.apache.thrift.a
    public void a(org.apache.thrift.protocol.e eVar) {
        eVar.g();
        while (true) {
            org.apache.thrift.protocol.b i = eVar.i();
            if (i.b == 0) {
                eVar.h();
                d();
                return;
            }
            switch (i.c) {
                case 1:
                    if (i.b == 15) {
                        org.apache.thrift.protocol.c m = eVar.m();
                        this.a = new ArrayList(m.b);
                        for (int i2 = 0; i2 < m.b; i2++) {
                            v vVar = new v();
                            vVar.a(eVar);
                            this.a.add(vVar);
                        }
                        eVar.n();
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    }
                case 2:
                    if (i.b == 15) {
                        org.apache.thrift.protocol.c m2 = eVar.m();
                        this.b = new ArrayList(m2.b);
                        for (int i3 = 0; i3 < m2.b; i3++) {
                            b bVar = new b();
                            bVar.a(eVar);
                            this.b.add(bVar);
                        }
                        eVar.n();
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    }
                case 3:
                    if (i.b == 12) {
                        this.c = new i();
                        this.c.a(eVar);
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

    public boolean a() {
        return this.a != null;
    }

    public boolean a(m mVar) {
        if (mVar == null) {
            return false;
        }
        boolean a2 = a();
        boolean a3 = mVar.a();
        if ((a2 || a3) && !(a2 && a3 && this.a.equals(mVar.a))) {
            return false;
        }
        boolean b = b();
        boolean b2 = mVar.b();
        if ((b || b2) && !(b && b2 && this.b.equals(mVar.b))) {
            return false;
        }
        boolean c = c();
        boolean c2 = mVar.c();
        return !(c || c2) || (c && c2 && this.c.a(mVar.c));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: b */
    public int compareTo(m mVar) {
        int a2;
        int a3;
        int a4;
        if (getClass().equals(mVar.getClass())) {
            int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(mVar.a()));
            if (compareTo == 0) {
                if (!a() || (a4 = org.apache.thrift.b.a(this.a, mVar.a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(mVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a3 = org.apache.thrift.b.a(this.b, mVar.b)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(mVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a2 = org.apache.thrift.b.a(this.c, mVar.c)) == 0) {
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
        return getClass().getName().compareTo(mVar.getClass().getName());
    }

    public m b(List<b> list) {
        this.b = list;
        return this;
    }

    @Override // org.apache.thrift.a
    public void b(org.apache.thrift.protocol.e eVar) {
        d();
        eVar.a(e);
        if (this.a != null && a()) {
            eVar.a(f);
            eVar.a(new org.apache.thrift.protocol.c((byte) 12, this.a.size()));
            for (v vVar : this.a) {
                vVar.b(eVar);
            }
            eVar.e();
            eVar.b();
        }
        if (this.b != null && b()) {
            eVar.a(g);
            eVar.a(new org.apache.thrift.protocol.c((byte) 12, this.b.size()));
            for (b bVar : this.b) {
                bVar.b(eVar);
            }
            eVar.e();
            eVar.b();
        }
        if (this.c != null && c()) {
            eVar.a(h);
            this.c.b(eVar);
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

    public void d() {
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof m)) {
            return a((m) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("LocationInfo(");
        boolean z2 = true;
        if (a()) {
            sb.append("wifiList:");
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
            sb.append("cellList:");
            if (this.b == null) {
                sb.append("null");
            } else {
                sb.append(this.b);
            }
        } else {
            z = z2;
        }
        if (c()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("gps:");
            if (this.c == null) {
                sb.append("null");
            } else {
                sb.append(this.c);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
