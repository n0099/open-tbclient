package com.xiaomi.push.thrift;

import java.io.Serializable;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.apache.thrift.protocol.e;
import org.apache.thrift.protocol.f;
import org.apache.thrift.protocol.h;
import org.apache.thrift.protocol.j;
/* loaded from: classes3.dex */
public class b implements Serializable, Cloneable, org.apache.thrift.a<b, a> {
    public static final Map<a, org.apache.thrift.meta_data.b> k;
    private static final j l = new j("StatsEvent");
    private static final org.apache.thrift.protocol.b m = new org.apache.thrift.protocol.b("chid", (byte) 3, 1);
    private static final org.apache.thrift.protocol.b n = new org.apache.thrift.protocol.b("type", (byte) 8, 2);
    private static final org.apache.thrift.protocol.b o = new org.apache.thrift.protocol.b("value", (byte) 8, 3);
    private static final org.apache.thrift.protocol.b p = new org.apache.thrift.protocol.b("connpt", (byte) 11, 4);
    private static final org.apache.thrift.protocol.b q = new org.apache.thrift.protocol.b("host", (byte) 11, 5);
    private static final org.apache.thrift.protocol.b r = new org.apache.thrift.protocol.b("subvalue", (byte) 8, 6);
    private static final org.apache.thrift.protocol.b s = new org.apache.thrift.protocol.b("annotation", (byte) 11, 7);
    private static final org.apache.thrift.protocol.b t = new org.apache.thrift.protocol.b("user", (byte) 11, 8);
    private static final org.apache.thrift.protocol.b u = new org.apache.thrift.protocol.b("time", (byte) 8, 9);
    private static final org.apache.thrift.protocol.b v = new org.apache.thrift.protocol.b("clientIp", (byte) 8, 10);
    public byte a;
    public int b;
    public int c;
    public String d;
    public String e;
    public int f;
    public String g;
    public String h;
    public int i;
    public int j;
    private BitSet w = new BitSet(6);

    /* loaded from: classes3.dex */
    public enum a {
        CHID(1, "chid"),
        TYPE(2, "type"),
        VALUE(3, "value"),
        CONNPT(4, "connpt"),
        HOST(5, "host"),
        SUBVALUE(6, "subvalue"),
        ANNOTATION(7, "annotation"),
        USER(8, "user"),
        TIME(9, "time"),
        CLIENT_IP(10, "clientIp");
        
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
        enumMap.put((EnumMap) a.CHID, (a) new org.apache.thrift.meta_data.b("chid", (byte) 1, new org.apache.thrift.meta_data.c((byte) 3)));
        enumMap.put((EnumMap) a.TYPE, (a) new org.apache.thrift.meta_data.b("type", (byte) 1, new org.apache.thrift.meta_data.c((byte) 8)));
        enumMap.put((EnumMap) a.VALUE, (a) new org.apache.thrift.meta_data.b("value", (byte) 1, new org.apache.thrift.meta_data.c((byte) 8)));
        enumMap.put((EnumMap) a.CONNPT, (a) new org.apache.thrift.meta_data.b("connpt", (byte) 1, new org.apache.thrift.meta_data.c((byte) 11)));
        enumMap.put((EnumMap) a.HOST, (a) new org.apache.thrift.meta_data.b("host", (byte) 2, new org.apache.thrift.meta_data.c((byte) 11)));
        enumMap.put((EnumMap) a.SUBVALUE, (a) new org.apache.thrift.meta_data.b("subvalue", (byte) 2, new org.apache.thrift.meta_data.c((byte) 8)));
        enumMap.put((EnumMap) a.ANNOTATION, (a) new org.apache.thrift.meta_data.b("annotation", (byte) 2, new org.apache.thrift.meta_data.c((byte) 11)));
        enumMap.put((EnumMap) a.USER, (a) new org.apache.thrift.meta_data.b("user", (byte) 2, new org.apache.thrift.meta_data.c((byte) 11)));
        enumMap.put((EnumMap) a.TIME, (a) new org.apache.thrift.meta_data.b("time", (byte) 2, new org.apache.thrift.meta_data.c((byte) 8)));
        enumMap.put((EnumMap) a.CLIENT_IP, (a) new org.apache.thrift.meta_data.b("clientIp", (byte) 2, new org.apache.thrift.meta_data.c((byte) 8)));
        k = Collections.unmodifiableMap(enumMap);
        org.apache.thrift.meta_data.b.a(b.class, k);
    }

    public b a(byte b) {
        this.a = b;
        a(true);
        return this;
    }

    public b a(int i) {
        this.b = i;
        b(true);
        return this;
    }

    public b a(String str) {
        this.d = str;
        return this;
    }

    @Override // org.apache.thrift.a
    public void a(e eVar) {
        eVar.g();
        while (true) {
            org.apache.thrift.protocol.b i = eVar.i();
            if (i.b == 0) {
                eVar.h();
                if (!a()) {
                    throw new f("Required field 'chid' was not found in serialized data! Struct: " + toString());
                }
                if (!b()) {
                    throw new f("Required field 'type' was not found in serialized data! Struct: " + toString());
                }
                if (!c()) {
                    throw new f("Required field 'value' was not found in serialized data! Struct: " + toString());
                }
                k();
                return;
            }
            switch (i.c) {
                case 1:
                    if (i.b != 3) {
                        h.a(eVar, i.b);
                        break;
                    } else {
                        this.a = eVar.r();
                        a(true);
                        break;
                    }
                case 2:
                    if (i.b != 8) {
                        h.a(eVar, i.b);
                        break;
                    } else {
                        this.b = eVar.t();
                        b(true);
                        break;
                    }
                case 3:
                    if (i.b != 8) {
                        h.a(eVar, i.b);
                        break;
                    } else {
                        this.c = eVar.t();
                        c(true);
                        break;
                    }
                case 4:
                    if (i.b != 11) {
                        h.a(eVar, i.b);
                        break;
                    } else {
                        this.d = eVar.w();
                        break;
                    }
                case 5:
                    if (i.b != 11) {
                        h.a(eVar, i.b);
                        break;
                    } else {
                        this.e = eVar.w();
                        break;
                    }
                case 6:
                    if (i.b != 8) {
                        h.a(eVar, i.b);
                        break;
                    } else {
                        this.f = eVar.t();
                        d(true);
                        break;
                    }
                case 7:
                    if (i.b != 11) {
                        h.a(eVar, i.b);
                        break;
                    } else {
                        this.g = eVar.w();
                        break;
                    }
                case 8:
                    if (i.b != 11) {
                        h.a(eVar, i.b);
                        break;
                    } else {
                        this.h = eVar.w();
                        break;
                    }
                case 9:
                    if (i.b != 8) {
                        h.a(eVar, i.b);
                        break;
                    } else {
                        this.i = eVar.t();
                        e(true);
                        break;
                    }
                case 10:
                    if (i.b != 8) {
                        h.a(eVar, i.b);
                        break;
                    } else {
                        this.j = eVar.t();
                        f(true);
                        break;
                    }
                default:
                    h.a(eVar, i.b);
                    break;
            }
            eVar.j();
        }
    }

    public void a(boolean z) {
        this.w.set(0, z);
    }

    public boolean a() {
        return this.w.get(0);
    }

    public boolean a(b bVar) {
        if (bVar != null && this.a == bVar.a && this.b == bVar.b && this.c == bVar.c) {
            boolean d = d();
            boolean d2 = bVar.d();
            if ((d || d2) && !(d && d2 && this.d.equals(bVar.d))) {
                return false;
            }
            boolean e = e();
            boolean e2 = bVar.e();
            if ((e || e2) && !(e && e2 && this.e.equals(bVar.e))) {
                return false;
            }
            boolean f = f();
            boolean f2 = bVar.f();
            if ((f || f2) && !(f && f2 && this.f == bVar.f)) {
                return false;
            }
            boolean g = g();
            boolean g2 = bVar.g();
            if ((g || g2) && !(g && g2 && this.g.equals(bVar.g))) {
                return false;
            }
            boolean h = h();
            boolean h2 = bVar.h();
            if ((h || h2) && !(h && h2 && this.h.equals(bVar.h))) {
                return false;
            }
            boolean i = i();
            boolean i2 = bVar.i();
            if ((i || i2) && !(i && i2 && this.i == bVar.i)) {
                return false;
            }
            boolean j = j();
            boolean j2 = bVar.j();
            return !(j || j2) || (j && j2 && this.j == bVar.j);
        }
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: b */
    public int compareTo(b bVar) {
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
        if (getClass().equals(bVar.getClass())) {
            int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(bVar.a()));
            if (compareTo == 0) {
                if (!a() || (a11 = org.apache.thrift.b.a(this.a, bVar.a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(bVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a10 = org.apache.thrift.b.a(this.b, bVar.b)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(bVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a9 = org.apache.thrift.b.a(this.c, bVar.c)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(bVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a8 = org.apache.thrift.b.a(this.d, bVar.d)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(bVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a7 = org.apache.thrift.b.a(this.e, bVar.e)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(bVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a6 = org.apache.thrift.b.a(this.f, bVar.f)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(bVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a5 = org.apache.thrift.b.a(this.g, bVar.g)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(bVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a4 = org.apache.thrift.b.a(this.h, bVar.h)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(bVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a3 = org.apache.thrift.b.a(this.i, bVar.i)) == 0) {
                                                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(bVar.j()));
                                                                                    if (compareTo10 == 0) {
                                                                                        if (!j() || (a2 = org.apache.thrift.b.a(this.j, bVar.j)) == 0) {
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
        return getClass().getName().compareTo(bVar.getClass().getName());
    }

    public b b(int i) {
        this.c = i;
        c(true);
        return this;
    }

    public b b(String str) {
        this.e = str;
        return this;
    }

    @Override // org.apache.thrift.a
    public void b(e eVar) {
        k();
        eVar.a(l);
        eVar.a(m);
        eVar.a(this.a);
        eVar.b();
        eVar.a(n);
        eVar.a(this.b);
        eVar.b();
        eVar.a(o);
        eVar.a(this.c);
        eVar.b();
        if (this.d != null) {
            eVar.a(p);
            eVar.a(this.d);
            eVar.b();
        }
        if (this.e != null && e()) {
            eVar.a(q);
            eVar.a(this.e);
            eVar.b();
        }
        if (f()) {
            eVar.a(r);
            eVar.a(this.f);
            eVar.b();
        }
        if (this.g != null && g()) {
            eVar.a(s);
            eVar.a(this.g);
            eVar.b();
        }
        if (this.h != null && h()) {
            eVar.a(t);
            eVar.a(this.h);
            eVar.b();
        }
        if (i()) {
            eVar.a(u);
            eVar.a(this.i);
            eVar.b();
        }
        if (j()) {
            eVar.a(v);
            eVar.a(this.j);
            eVar.b();
        }
        eVar.c();
        eVar.a();
    }

    public void b(boolean z) {
        this.w.set(1, z);
    }

    public boolean b() {
        return this.w.get(1);
    }

    public b c(int i) {
        this.f = i;
        d(true);
        return this;
    }

    public b c(String str) {
        this.g = str;
        return this;
    }

    public void c(boolean z) {
        this.w.set(2, z);
    }

    public boolean c() {
        return this.w.get(2);
    }

    public b d(int i) {
        this.i = i;
        e(true);
        return this;
    }

    public b d(String str) {
        this.h = str;
        return this;
    }

    public void d(boolean z) {
        this.w.set(3, z);
    }

    public boolean d() {
        return this.d != null;
    }

    public b e(int i) {
        this.j = i;
        f(true);
        return this;
    }

    public void e(boolean z) {
        this.w.set(4, z);
    }

    public boolean e() {
        return this.e != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof b)) {
            return a((b) obj);
        }
        return false;
    }

    public void f(boolean z) {
        this.w.set(5, z);
    }

    public boolean f() {
        return this.w.get(3);
    }

    public boolean g() {
        return this.g != null;
    }

    public boolean h() {
        return this.h != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.w.get(4);
    }

    public boolean j() {
        return this.w.get(5);
    }

    public void k() {
        if (this.d == null) {
            throw new f("Required field 'connpt' was not present! Struct: " + toString());
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("StatsEvent(");
        sb.append("chid:");
        sb.append((int) this.a);
        sb.append(", ");
        sb.append("type:");
        sb.append(this.b);
        sb.append(", ");
        sb.append("value:");
        sb.append(this.c);
        sb.append(", ");
        sb.append("connpt:");
        if (this.d == null) {
            sb.append("null");
        } else {
            sb.append(this.d);
        }
        if (e()) {
            sb.append(", ");
            sb.append("host:");
            if (this.e == null) {
                sb.append("null");
            } else {
                sb.append(this.e);
            }
        }
        if (f()) {
            sb.append(", ");
            sb.append("subvalue:");
            sb.append(this.f);
        }
        if (g()) {
            sb.append(", ");
            sb.append("annotation:");
            if (this.g == null) {
                sb.append("null");
            } else {
                sb.append(this.g);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("user:");
            if (this.h == null) {
                sb.append("null");
            } else {
                sb.append(this.h);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("time:");
            sb.append(this.i);
        }
        if (j()) {
            sb.append(", ");
            sb.append("clientIp:");
            sb.append(this.j);
        }
        sb.append(")");
        return sb.toString();
    }
}
