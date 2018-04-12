package com.xiaomi.xmpush.thrift;

import java.io.Serializable;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes3.dex */
public class q implements Serializable, Cloneable, org.apache.thrift.a<q, a> {
    public static final Map<a, org.apache.thrift.meta_data.b> i;
    private static final org.apache.thrift.protocol.j j = new org.apache.thrift.protocol.j("PushMessage");
    private static final org.apache.thrift.protocol.b k = new org.apache.thrift.protocol.b("to", (byte) 12, 1);
    private static final org.apache.thrift.protocol.b l = new org.apache.thrift.protocol.b("id", (byte) 11, 2);
    private static final org.apache.thrift.protocol.b m = new org.apache.thrift.protocol.b("appId", (byte) 11, 3);
    private static final org.apache.thrift.protocol.b n = new org.apache.thrift.protocol.b("payload", (byte) 11, 4);
    private static final org.apache.thrift.protocol.b o = new org.apache.thrift.protocol.b("createAt", (byte) 10, 5);
    private static final org.apache.thrift.protocol.b p = new org.apache.thrift.protocol.b("ttl", (byte) 10, 6);
    private static final org.apache.thrift.protocol.b q = new org.apache.thrift.protocol.b("collapseKey", (byte) 11, 7);
    private static final org.apache.thrift.protocol.b r = new org.apache.thrift.protocol.b("packageName", (byte) 11, 8);
    public u a;
    public String b;
    public String c;
    public String d;
    public long e;
    public long f;
    public String g;
    public String h;
    private BitSet s = new BitSet(2);

    /* loaded from: classes3.dex */
    public enum a {
        TO(1, "to"),
        ID(2, "id"),
        APP_ID(3, "appId"),
        PAYLOAD(4, "payload"),
        CREATE_AT(5, "createAt"),
        TTL(6, "ttl"),
        COLLAPSE_KEY(7, "collapseKey"),
        PACKAGE_NAME(8, "packageName");
        
        private static final Map<String, a> i = new HashMap();
        private final short j;
        private final String k;

        static {
            Iterator it = EnumSet.allOf(a.class).iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                i.put(aVar.a(), aVar);
            }
        }

        a(short s, String str) {
            this.j = s;
            this.k = str;
        }

        public String a() {
            return this.k;
        }
    }

    static {
        EnumMap enumMap = new EnumMap(a.class);
        enumMap.put((EnumMap) a.TO, (a) new org.apache.thrift.meta_data.b("to", (byte) 2, new org.apache.thrift.meta_data.g((byte) 12, u.class)));
        enumMap.put((EnumMap) a.ID, (a) new org.apache.thrift.meta_data.b("id", (byte) 1, new org.apache.thrift.meta_data.c((byte) 11)));
        enumMap.put((EnumMap) a.APP_ID, (a) new org.apache.thrift.meta_data.b("appId", (byte) 1, new org.apache.thrift.meta_data.c((byte) 11)));
        enumMap.put((EnumMap) a.PAYLOAD, (a) new org.apache.thrift.meta_data.b("payload", (byte) 1, new org.apache.thrift.meta_data.c((byte) 11)));
        enumMap.put((EnumMap) a.CREATE_AT, (a) new org.apache.thrift.meta_data.b("createAt", (byte) 2, new org.apache.thrift.meta_data.c((byte) 10)));
        enumMap.put((EnumMap) a.TTL, (a) new org.apache.thrift.meta_data.b("ttl", (byte) 2, new org.apache.thrift.meta_data.c((byte) 10)));
        enumMap.put((EnumMap) a.COLLAPSE_KEY, (a) new org.apache.thrift.meta_data.b("collapseKey", (byte) 2, new org.apache.thrift.meta_data.c((byte) 11)));
        enumMap.put((EnumMap) a.PACKAGE_NAME, (a) new org.apache.thrift.meta_data.b("packageName", (byte) 2, new org.apache.thrift.meta_data.c((byte) 11)));
        i = Collections.unmodifiableMap(enumMap);
        org.apache.thrift.meta_data.b.a(q.class, i);
    }

    @Override // org.apache.thrift.a
    public void a(org.apache.thrift.protocol.e eVar) {
        eVar.g();
        while (true) {
            org.apache.thrift.protocol.b i2 = eVar.i();
            if (i2.b == 0) {
                eVar.h();
                m();
                return;
            }
            switch (i2.c) {
                case 1:
                    if (i2.b != 12) {
                        org.apache.thrift.protocol.h.a(eVar, i2.b);
                        break;
                    } else {
                        this.a = new u();
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
                    if (i2.b != 11) {
                        org.apache.thrift.protocol.h.a(eVar, i2.b);
                        break;
                    } else {
                        this.c = eVar.w();
                        break;
                    }
                case 4:
                    if (i2.b != 11) {
                        org.apache.thrift.protocol.h.a(eVar, i2.b);
                        break;
                    } else {
                        this.d = eVar.w();
                        break;
                    }
                case 5:
                    if (i2.b != 10) {
                        org.apache.thrift.protocol.h.a(eVar, i2.b);
                        break;
                    } else {
                        this.e = eVar.u();
                        a(true);
                        break;
                    }
                case 6:
                    if (i2.b != 10) {
                        org.apache.thrift.protocol.h.a(eVar, i2.b);
                        break;
                    } else {
                        this.f = eVar.u();
                        b(true);
                        break;
                    }
                case 7:
                    if (i2.b != 11) {
                        org.apache.thrift.protocol.h.a(eVar, i2.b);
                        break;
                    } else {
                        this.g = eVar.w();
                        break;
                    }
                case 8:
                    if (i2.b != 11) {
                        org.apache.thrift.protocol.h.a(eVar, i2.b);
                        break;
                    } else {
                        this.h = eVar.w();
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
        this.s.set(0, z);
    }

    public boolean a() {
        return this.a != null;
    }

    public boolean a(q qVar) {
        if (qVar == null) {
            return false;
        }
        boolean a2 = a();
        boolean a3 = qVar.a();
        if ((a2 || a3) && !(a2 && a3 && this.a.a(qVar.a))) {
            return false;
        }
        boolean c = c();
        boolean c2 = qVar.c();
        if ((c || c2) && !(c && c2 && this.b.equals(qVar.b))) {
            return false;
        }
        boolean e = e();
        boolean e2 = qVar.e();
        if ((e || e2) && !(e && e2 && this.c.equals(qVar.c))) {
            return false;
        }
        boolean g = g();
        boolean g2 = qVar.g();
        if ((g || g2) && !(g && g2 && this.d.equals(qVar.d))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = qVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.e == qVar.e)) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = qVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f == qVar.f)) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = qVar.k();
        if ((k2 || k3) && !(k2 && k3 && this.g.equals(qVar.g))) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = qVar.l();
        return !(l2 || l3) || (l2 && l3 && this.h.equals(qVar.h));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: b */
    public int compareTo(q qVar) {
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        int a8;
        int a9;
        if (getClass().equals(qVar.getClass())) {
            int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(qVar.a()));
            if (compareTo == 0) {
                if (!a() || (a9 = org.apache.thrift.b.a(this.a, qVar.a)) == 0) {
                    int compareTo2 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(qVar.c()));
                    if (compareTo2 == 0) {
                        if (!c() || (a8 = org.apache.thrift.b.a(this.b, qVar.b)) == 0) {
                            int compareTo3 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(qVar.e()));
                            if (compareTo3 == 0) {
                                if (!e() || (a7 = org.apache.thrift.b.a(this.c, qVar.c)) == 0) {
                                    int compareTo4 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(qVar.g()));
                                    if (compareTo4 == 0) {
                                        if (!g() || (a6 = org.apache.thrift.b.a(this.d, qVar.d)) == 0) {
                                            int compareTo5 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(qVar.i()));
                                            if (compareTo5 == 0) {
                                                if (!i() || (a5 = org.apache.thrift.b.a(this.e, qVar.e)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(qVar.j()));
                                                    if (compareTo6 == 0) {
                                                        if (!j() || (a4 = org.apache.thrift.b.a(this.f, qVar.f)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(qVar.k()));
                                                            if (compareTo7 == 0) {
                                                                if (!k() || (a3 = org.apache.thrift.b.a(this.g, qVar.g)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(qVar.l()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!l() || (a2 = org.apache.thrift.b.a(this.h, qVar.h)) == 0) {
                                                                            return 0;
                                                                        }
                                                                        return a2;
                                                                    }
                                                                    return compareTo8;
                                                                }
                                                                return a3;
                                                            }
                                                            return compareTo7;
                                                        }
                                                        return a4;
                                                    }
                                                    return compareTo6;
                                                }
                                                return a5;
                                            }
                                            return compareTo5;
                                        }
                                        return a6;
                                    }
                                    return compareTo4;
                                }
                                return a7;
                            }
                            return compareTo3;
                        }
                        return a8;
                    }
                    return compareTo2;
                }
                return a9;
            }
            return compareTo;
        }
        return getClass().getName().compareTo(qVar.getClass().getName());
    }

    public String b() {
        return this.b;
    }

    @Override // org.apache.thrift.a
    public void b(org.apache.thrift.protocol.e eVar) {
        m();
        eVar.a(j);
        if (this.a != null && a()) {
            eVar.a(k);
            this.a.b(eVar);
            eVar.b();
        }
        if (this.b != null) {
            eVar.a(l);
            eVar.a(this.b);
            eVar.b();
        }
        if (this.c != null) {
            eVar.a(m);
            eVar.a(this.c);
            eVar.b();
        }
        if (this.d != null) {
            eVar.a(n);
            eVar.a(this.d);
            eVar.b();
        }
        if (i()) {
            eVar.a(o);
            eVar.a(this.e);
            eVar.b();
        }
        if (j()) {
            eVar.a(p);
            eVar.a(this.f);
            eVar.b();
        }
        if (this.g != null && k()) {
            eVar.a(q);
            eVar.a(this.g);
            eVar.b();
        }
        if (this.h != null && l()) {
            eVar.a(r);
            eVar.a(this.h);
            eVar.b();
        }
        eVar.c();
        eVar.a();
    }

    public void b(boolean z) {
        this.s.set(1, z);
    }

    public boolean c() {
        return this.b != null;
    }

    public String d() {
        return this.c;
    }

    public boolean e() {
        return this.c != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof q)) {
            return a((q) obj);
        }
        return false;
    }

    public String f() {
        return this.d;
    }

    public boolean g() {
        return this.d != null;
    }

    public long h() {
        return this.e;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.s.get(0);
    }

    public boolean j() {
        return this.s.get(1);
    }

    public boolean k() {
        return this.g != null;
    }

    public boolean l() {
        return this.h != null;
    }

    public void m() {
        if (this.b == null) {
            throw new org.apache.thrift.protocol.f("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.c == null) {
            throw new org.apache.thrift.protocol.f("Required field 'appId' was not present! Struct: " + toString());
        }
        if (this.d == null) {
            throw new org.apache.thrift.protocol.f("Required field 'payload' was not present! Struct: " + toString());
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("PushMessage(");
        boolean z = true;
        if (a()) {
            sb.append("to:");
            if (this.a == null) {
                sb.append("null");
            } else {
                sb.append(this.a);
            }
            z = false;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.b == null) {
            sb.append("null");
        } else {
            sb.append(this.b);
        }
        sb.append(", ");
        sb.append("appId:");
        if (this.c == null) {
            sb.append("null");
        } else {
            sb.append(this.c);
        }
        sb.append(", ");
        sb.append("payload:");
        if (this.d == null) {
            sb.append("null");
        } else {
            sb.append(this.d);
        }
        if (i()) {
            sb.append(", ");
            sb.append("createAt:");
            sb.append(this.e);
        }
        if (j()) {
            sb.append(", ");
            sb.append("ttl:");
            sb.append(this.f);
        }
        if (k()) {
            sb.append(", ");
            sb.append("collapseKey:");
            if (this.g == null) {
                sb.append("null");
            } else {
                sb.append(this.g);
            }
        }
        if (l()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.h == null) {
                sb.append("null");
            } else {
                sb.append(this.h);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
