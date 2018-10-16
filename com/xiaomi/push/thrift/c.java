package com.xiaomi.push.thrift;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.thrift.meta_data.d;
import org.apache.thrift.meta_data.g;
import org.apache.thrift.protocol.e;
import org.apache.thrift.protocol.f;
import org.apache.thrift.protocol.h;
import org.apache.thrift.protocol.j;
/* loaded from: classes3.dex */
public class c implements Serializable, Cloneable, org.apache.thrift.a<c, a> {
    public static final Map<a, org.apache.thrift.meta_data.b> d;
    private static final j e = new j("StatsEvents");
    private static final org.apache.thrift.protocol.b f = new org.apache.thrift.protocol.b("uuid", (byte) 11, 1);
    private static final org.apache.thrift.protocol.b g = new org.apache.thrift.protocol.b("operator", (byte) 11, 2);
    private static final org.apache.thrift.protocol.b h = new org.apache.thrift.protocol.b("events", (byte) 15, 3);
    public String a;
    public String b;
    public List<b> c;

    /* loaded from: classes3.dex */
    public enum a {
        UUID(1, "uuid"),
        OPERATOR(2, "operator"),
        EVENTS(3, "events");
        
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
        enumMap.put((EnumMap) a.UUID, (a) new org.apache.thrift.meta_data.b("uuid", (byte) 1, new org.apache.thrift.meta_data.c((byte) 11)));
        enumMap.put((EnumMap) a.OPERATOR, (a) new org.apache.thrift.meta_data.b("operator", (byte) 2, new org.apache.thrift.meta_data.c((byte) 11)));
        enumMap.put((EnumMap) a.EVENTS, (a) new org.apache.thrift.meta_data.b("events", (byte) 1, new d((byte) 15, new g((byte) 12, b.class))));
        d = Collections.unmodifiableMap(enumMap);
        org.apache.thrift.meta_data.b.a(c.class, d);
    }

    public c() {
    }

    public c(String str, List<b> list) {
        this();
        this.a = str;
        this.c = list;
    }

    public c a(String str) {
        this.b = str;
        return this;
    }

    @Override // org.apache.thrift.a
    public void a(e eVar) {
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
                    if (i.b == 11) {
                        this.a = eVar.w();
                        break;
                    } else {
                        h.a(eVar, i.b);
                        break;
                    }
                case 2:
                    if (i.b == 11) {
                        this.b = eVar.w();
                        break;
                    } else {
                        h.a(eVar, i.b);
                        break;
                    }
                case 3:
                    if (i.b == 15) {
                        org.apache.thrift.protocol.c m = eVar.m();
                        this.c = new ArrayList(m.b);
                        for (int i2 = 0; i2 < m.b; i2++) {
                            b bVar = new b();
                            bVar.a(eVar);
                            this.c.add(bVar);
                        }
                        eVar.n();
                        break;
                    } else {
                        h.a(eVar, i.b);
                        break;
                    }
                default:
                    h.a(eVar, i.b);
                    break;
            }
            eVar.j();
        }
    }

    public boolean a() {
        return this.a != null;
    }

    public boolean a(c cVar) {
        if (cVar == null) {
            return false;
        }
        boolean a2 = a();
        boolean a3 = cVar.a();
        if ((a2 || a3) && !(a2 && a3 && this.a.equals(cVar.a))) {
            return false;
        }
        boolean b = b();
        boolean b2 = cVar.b();
        if ((b || b2) && !(b && b2 && this.b.equals(cVar.b))) {
            return false;
        }
        boolean c = c();
        boolean c2 = cVar.c();
        return !(c || c2) || (c && c2 && this.c.equals(cVar.c));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: b */
    public int compareTo(c cVar) {
        int a2;
        int a3;
        int a4;
        if (getClass().equals(cVar.getClass())) {
            int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(cVar.a()));
            if (compareTo == 0) {
                if (!a() || (a4 = org.apache.thrift.b.a(this.a, cVar.a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(cVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a3 = org.apache.thrift.b.a(this.b, cVar.b)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(cVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a2 = org.apache.thrift.b.a(this.c, cVar.c)) == 0) {
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
        return getClass().getName().compareTo(cVar.getClass().getName());
    }

    @Override // org.apache.thrift.a
    public void b(e eVar) {
        d();
        eVar.a(e);
        if (this.a != null) {
            eVar.a(f);
            eVar.a(this.a);
            eVar.b();
        }
        if (this.b != null && b()) {
            eVar.a(g);
            eVar.a(this.b);
            eVar.b();
        }
        if (this.c != null) {
            eVar.a(h);
            eVar.a(new org.apache.thrift.protocol.c((byte) 12, this.c.size()));
            for (b bVar : this.c) {
                bVar.b(eVar);
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

    public boolean c() {
        return this.c != null;
    }

    public void d() {
        if (this.a == null) {
            throw new f("Required field 'uuid' was not present! Struct: " + toString());
        }
        if (this.c == null) {
            throw new f("Required field 'events' was not present! Struct: " + toString());
        }
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof c)) {
            return a((c) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("StatsEvents(");
        sb.append("uuid:");
        if (this.a == null) {
            sb.append("null");
        } else {
            sb.append(this.a);
        }
        if (b()) {
            sb.append(", ");
            sb.append("operator:");
            if (this.b == null) {
                sb.append("null");
            } else {
                sb.append(this.b);
            }
        }
        sb.append(", ");
        sb.append("events:");
        if (this.c == null) {
            sb.append("null");
        } else {
            sb.append(this.c);
        }
        sb.append(")");
        return sb.toString();
    }
}
