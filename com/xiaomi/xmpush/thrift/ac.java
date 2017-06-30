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
/* loaded from: classes2.dex */
public class ac implements Serializable, Cloneable, org.apache.thrift.a<ac, a> {
    public static final Map<a, org.apache.thrift.meta_data.b> b;
    private static final org.apache.thrift.protocol.j c = new org.apache.thrift.protocol.j("XmPushActionCustomConfig");
    private static final org.apache.thrift.protocol.b d = new org.apache.thrift.protocol.b("customConfigs", (byte) 15, 1);
    public List<p> a;

    /* loaded from: classes2.dex */
    public enum a {
        CUSTOM_CONFIGS(1, "customConfigs");
        
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
        enumMap.put((EnumMap) a.CUSTOM_CONFIGS, (a) new org.apache.thrift.meta_data.b("customConfigs", (byte) 1, new org.apache.thrift.meta_data.d((byte) 15, new org.apache.thrift.meta_data.g((byte) 12, p.class))));
        b = Collections.unmodifiableMap(enumMap);
        org.apache.thrift.meta_data.b.a(ac.class, b);
    }

    public List<p> a() {
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
                    if (i.b == 15) {
                        org.apache.thrift.protocol.c m = eVar.m();
                        this.a = new ArrayList(m.b);
                        for (int i2 = 0; i2 < m.b; i2++) {
                            p pVar = new p();
                            pVar.a(eVar);
                            this.a.add(pVar);
                        }
                        eVar.n();
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

    public boolean a(ac acVar) {
        if (acVar == null) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = acVar.b();
        return !(b2 || b3) || (b2 && b3 && this.a.equals(acVar.a));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: b */
    public int compareTo(ac acVar) {
        int a2;
        if (getClass().equals(acVar.getClass())) {
            int compareTo = Boolean.valueOf(b()).compareTo(Boolean.valueOf(acVar.b()));
            if (compareTo == 0) {
                if (!b() || (a2 = org.apache.thrift.b.a(this.a, acVar.a)) == 0) {
                    return 0;
                }
                return a2;
            }
            return compareTo;
        }
        return getClass().getName().compareTo(acVar.getClass().getName());
    }

    @Override // org.apache.thrift.a
    public void b(org.apache.thrift.protocol.e eVar) {
        c();
        eVar.a(c);
        if (this.a != null) {
            eVar.a(d);
            eVar.a(new org.apache.thrift.protocol.c((byte) 12, this.a.size()));
            for (p pVar : this.a) {
                pVar.b(eVar);
            }
            eVar.e();
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
            throw new org.apache.thrift.protocol.f("Required field 'customConfigs' was not present! Struct: " + toString());
        }
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ac)) {
            return a((ac) obj);
        }
        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionCustomConfig(");
        sb.append("customConfigs:");
        if (this.a == null) {
            sb.append("null");
        } else {
            sb.append(this.a);
        }
        sb.append(")");
        return sb.toString();
    }
}
