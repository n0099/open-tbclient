package com.xiaomi.xmpush.thrift;

import com.baidu.fsg.base.armor.RimArmor;
import java.io.Serializable;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes2.dex */
public class p implements Serializable, Cloneable, org.apache.thrift.a<p, a> {
    public static final Map<a, org.apache.thrift.meta_data.b> h;
    private static final org.apache.thrift.protocol.j i = new org.apache.thrift.protocol.j("OnlineConfigItem");
    private static final org.apache.thrift.protocol.b j = new org.apache.thrift.protocol.b(RimArmor.KEY, (byte) 8, 1);
    private static final org.apache.thrift.protocol.b k = new org.apache.thrift.protocol.b("type", (byte) 8, 2);
    private static final org.apache.thrift.protocol.b l = new org.apache.thrift.protocol.b("clear", (byte) 2, 3);
    private static final org.apache.thrift.protocol.b m = new org.apache.thrift.protocol.b("intValue", (byte) 8, 4);
    private static final org.apache.thrift.protocol.b n = new org.apache.thrift.protocol.b("longValue", (byte) 10, 5);
    private static final org.apache.thrift.protocol.b o = new org.apache.thrift.protocol.b("stringValue", (byte) 11, 6);
    private static final org.apache.thrift.protocol.b p = new org.apache.thrift.protocol.b("boolValue", (byte) 2, 7);
    public int a;
    public int b;
    public boolean c;
    public int d;
    public long e;
    public String f;
    public boolean g;
    private BitSet q = new BitSet(6);

    /* loaded from: classes2.dex */
    public enum a {
        KEY(1, RimArmor.KEY),
        TYPE(2, "type"),
        CLEAR(3, "clear"),
        INT_VALUE(4, "intValue"),
        LONG_VALUE(5, "longValue"),
        STRING_VALUE(6, "stringValue"),
        BOOL_VALUE(7, "boolValue");
        
        private static final Map<String, a> h = new HashMap();
        private final short i;
        private final String j;

        static {
            Iterator it = EnumSet.allOf(a.class).iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                h.put(aVar.a(), aVar);
            }
        }

        a(short s, String str) {
            this.i = s;
            this.j = str;
        }

        public String a() {
            return this.j;
        }
    }

    static {
        EnumMap enumMap = new EnumMap(a.class);
        enumMap.put((EnumMap) a.KEY, (a) new org.apache.thrift.meta_data.b(RimArmor.KEY, (byte) 2, new org.apache.thrift.meta_data.c((byte) 8)));
        enumMap.put((EnumMap) a.TYPE, (a) new org.apache.thrift.meta_data.b("type", (byte) 2, new org.apache.thrift.meta_data.c((byte) 8)));
        enumMap.put((EnumMap) a.CLEAR, (a) new org.apache.thrift.meta_data.b("clear", (byte) 2, new org.apache.thrift.meta_data.c((byte) 2)));
        enumMap.put((EnumMap) a.INT_VALUE, (a) new org.apache.thrift.meta_data.b("intValue", (byte) 2, new org.apache.thrift.meta_data.c((byte) 8)));
        enumMap.put((EnumMap) a.LONG_VALUE, (a) new org.apache.thrift.meta_data.b("longValue", (byte) 2, new org.apache.thrift.meta_data.c((byte) 10)));
        enumMap.put((EnumMap) a.STRING_VALUE, (a) new org.apache.thrift.meta_data.b("stringValue", (byte) 2, new org.apache.thrift.meta_data.c((byte) 11)));
        enumMap.put((EnumMap) a.BOOL_VALUE, (a) new org.apache.thrift.meta_data.b("boolValue", (byte) 2, new org.apache.thrift.meta_data.c((byte) 2)));
        h = Collections.unmodifiableMap(enumMap);
        org.apache.thrift.meta_data.b.a(p.class, h);
    }

    public int a() {
        return this.a;
    }

    @Override // org.apache.thrift.a
    public void a(org.apache.thrift.protocol.e eVar) {
        eVar.g();
        while (true) {
            org.apache.thrift.protocol.b i2 = eVar.i();
            if (i2.b == 0) {
                eVar.h();
                n();
                return;
            }
            switch (i2.c) {
                case 1:
                    if (i2.b != 8) {
                        org.apache.thrift.protocol.h.a(eVar, i2.b);
                        break;
                    } else {
                        this.a = eVar.t();
                        a(true);
                        break;
                    }
                case 2:
                    if (i2.b != 8) {
                        org.apache.thrift.protocol.h.a(eVar, i2.b);
                        break;
                    } else {
                        this.b = eVar.t();
                        b(true);
                        break;
                    }
                case 3:
                    if (i2.b != 2) {
                        org.apache.thrift.protocol.h.a(eVar, i2.b);
                        break;
                    } else {
                        this.c = eVar.q();
                        c(true);
                        break;
                    }
                case 4:
                    if (i2.b != 8) {
                        org.apache.thrift.protocol.h.a(eVar, i2.b);
                        break;
                    } else {
                        this.d = eVar.t();
                        d(true);
                        break;
                    }
                case 5:
                    if (i2.b != 10) {
                        org.apache.thrift.protocol.h.a(eVar, i2.b);
                        break;
                    } else {
                        this.e = eVar.u();
                        e(true);
                        break;
                    }
                case 6:
                    if (i2.b != 11) {
                        org.apache.thrift.protocol.h.a(eVar, i2.b);
                        break;
                    } else {
                        this.f = eVar.w();
                        break;
                    }
                case 7:
                    if (i2.b != 2) {
                        org.apache.thrift.protocol.h.a(eVar, i2.b);
                        break;
                    } else {
                        this.g = eVar.q();
                        f(true);
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
        this.q.set(0, z);
    }

    public boolean a(p pVar) {
        if (pVar == null) {
            return false;
        }
        boolean b = b();
        boolean b2 = pVar.b();
        if ((b || b2) && !(b && b2 && this.a == pVar.a)) {
            return false;
        }
        boolean d = d();
        boolean d2 = pVar.d();
        if ((d || d2) && !(d && d2 && this.b == pVar.b)) {
            return false;
        }
        boolean e = e();
        boolean e2 = pVar.e();
        if ((e || e2) && !(e && e2 && this.c == pVar.c)) {
            return false;
        }
        boolean g = g();
        boolean g2 = pVar.g();
        if ((g || g2) && !(g && g2 && this.d == pVar.d)) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = pVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.e == pVar.e)) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = pVar.k();
        if ((k2 || k3) && !(k2 && k3 && this.f.equals(pVar.f))) {
            return false;
        }
        boolean m2 = m();
        boolean m3 = pVar.m();
        return !(m2 || m3) || (m2 && m3 && this.g == pVar.g);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: b */
    public int compareTo(p pVar) {
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        int a8;
        if (getClass().equals(pVar.getClass())) {
            int compareTo = Boolean.valueOf(b()).compareTo(Boolean.valueOf(pVar.b()));
            if (compareTo == 0) {
                if (!b() || (a8 = org.apache.thrift.b.a(this.a, pVar.a)) == 0) {
                    int compareTo2 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(pVar.d()));
                    if (compareTo2 == 0) {
                        if (!d() || (a7 = org.apache.thrift.b.a(this.b, pVar.b)) == 0) {
                            int compareTo3 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(pVar.e()));
                            if (compareTo3 == 0) {
                                if (!e() || (a6 = org.apache.thrift.b.a(this.c, pVar.c)) == 0) {
                                    int compareTo4 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(pVar.g()));
                                    if (compareTo4 == 0) {
                                        if (!g() || (a5 = org.apache.thrift.b.a(this.d, pVar.d)) == 0) {
                                            int compareTo5 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(pVar.i()));
                                            if (compareTo5 == 0) {
                                                if (!i() || (a4 = org.apache.thrift.b.a(this.e, pVar.e)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(pVar.k()));
                                                    if (compareTo6 == 0) {
                                                        if (!k() || (a3 = org.apache.thrift.b.a(this.f, pVar.f)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(pVar.m()));
                                                            if (compareTo7 == 0) {
                                                                if (!m() || (a2 = org.apache.thrift.b.a(this.g, pVar.g)) == 0) {
                                                                    return 0;
                                                                }
                                                                return a2;
                                                            }
                                                            return compareTo7;
                                                        }
                                                        return a3;
                                                    }
                                                    return compareTo6;
                                                }
                                                return a4;
                                            }
                                            return compareTo5;
                                        }
                                        return a5;
                                    }
                                    return compareTo4;
                                }
                                return a6;
                            }
                            return compareTo3;
                        }
                        return a7;
                    }
                    return compareTo2;
                }
                return a8;
            }
            return compareTo;
        }
        return getClass().getName().compareTo(pVar.getClass().getName());
    }

    @Override // org.apache.thrift.a
    public void b(org.apache.thrift.protocol.e eVar) {
        n();
        eVar.a(i);
        if (b()) {
            eVar.a(j);
            eVar.a(this.a);
            eVar.b();
        }
        if (d()) {
            eVar.a(k);
            eVar.a(this.b);
            eVar.b();
        }
        if (e()) {
            eVar.a(l);
            eVar.a(this.c);
            eVar.b();
        }
        if (g()) {
            eVar.a(m);
            eVar.a(this.d);
            eVar.b();
        }
        if (i()) {
            eVar.a(n);
            eVar.a(this.e);
            eVar.b();
        }
        if (this.f != null && k()) {
            eVar.a(o);
            eVar.a(this.f);
            eVar.b();
        }
        if (m()) {
            eVar.a(p);
            eVar.a(this.g);
            eVar.b();
        }
        eVar.c();
        eVar.a();
    }

    public void b(boolean z) {
        this.q.set(1, z);
    }

    public boolean b() {
        return this.q.get(0);
    }

    public int c() {
        return this.b;
    }

    public void c(boolean z) {
        this.q.set(2, z);
    }

    public void d(boolean z) {
        this.q.set(3, z);
    }

    public boolean d() {
        return this.q.get(1);
    }

    public void e(boolean z) {
        this.q.set(4, z);
    }

    public boolean e() {
        return this.q.get(2);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof p)) {
            return a((p) obj);
        }
        return false;
    }

    public int f() {
        return this.d;
    }

    public void f(boolean z) {
        this.q.set(5, z);
    }

    public boolean g() {
        return this.q.get(3);
    }

    public long h() {
        return this.e;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.q.get(4);
    }

    public String j() {
        return this.f;
    }

    public boolean k() {
        return this.f != null;
    }

    public boolean l() {
        return this.g;
    }

    public boolean m() {
        return this.q.get(5);
    }

    public void n() {
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("OnlineConfigItem(");
        boolean z2 = true;
        if (b()) {
            sb.append("key:");
            sb.append(this.a);
            z2 = false;
        }
        if (d()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("type:");
            sb.append(this.b);
            z2 = false;
        }
        if (e()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("clear:");
            sb.append(this.c);
            z2 = false;
        }
        if (g()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("intValue:");
            sb.append(this.d);
            z2 = false;
        }
        if (i()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("longValue:");
            sb.append(this.e);
            z2 = false;
        }
        if (k()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("stringValue:");
            if (this.f == null) {
                sb.append("null");
            } else {
                sb.append(this.f);
            }
        } else {
            z = z2;
        }
        if (m()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("boolValue:");
            sb.append(this.g);
        }
        sb.append(")");
        return sb.toString();
    }
}
