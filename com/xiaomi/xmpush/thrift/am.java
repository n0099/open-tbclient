package com.xiaomi.xmpush.thrift;

import java.io.Serializable;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes3.dex */
public class am implements Serializable, Cloneable, org.apache.thrift.a<am, a> {
    public static final Map<a, org.apache.thrift.meta_data.b> k;
    private static final org.apache.thrift.protocol.j l = new org.apache.thrift.protocol.j("XmPushActionUnRegistration");
    private static final org.apache.thrift.protocol.b m = new org.apache.thrift.protocol.b("debug", (byte) 11, 1);
    private static final org.apache.thrift.protocol.b n = new org.apache.thrift.protocol.b("target", (byte) 12, 2);
    private static final org.apache.thrift.protocol.b o = new org.apache.thrift.protocol.b("id", (byte) 11, 3);
    private static final org.apache.thrift.protocol.b p = new org.apache.thrift.protocol.b("appId", (byte) 11, 4);
    private static final org.apache.thrift.protocol.b q = new org.apache.thrift.protocol.b("regId", (byte) 11, 5);
    private static final org.apache.thrift.protocol.b r = new org.apache.thrift.protocol.b("appVersion", (byte) 11, 6);
    private static final org.apache.thrift.protocol.b s = new org.apache.thrift.protocol.b("packageName", (byte) 11, 7);
    private static final org.apache.thrift.protocol.b t = new org.apache.thrift.protocol.b("token", (byte) 11, 8);
    private static final org.apache.thrift.protocol.b u = new org.apache.thrift.protocol.b("deviceId", (byte) 11, 9);
    private static final org.apache.thrift.protocol.b v = new org.apache.thrift.protocol.b("aliasName", (byte) 11, 10);
    public String a;
    public u b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;

    /* loaded from: classes3.dex */
    public enum a {
        DEBUG(1, "debug"),
        TARGET(2, "target"),
        ID(3, "id"),
        APP_ID(4, "appId"),
        REG_ID(5, "regId"),
        APP_VERSION(6, "appVersion"),
        PACKAGE_NAME(7, "packageName"),
        TOKEN(8, "token"),
        DEVICE_ID(9, "deviceId"),
        ALIAS_NAME(10, "aliasName");
        
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
        enumMap.put((EnumMap) a.DEBUG, (a) new org.apache.thrift.meta_data.b("debug", (byte) 2, new org.apache.thrift.meta_data.c((byte) 11)));
        enumMap.put((EnumMap) a.TARGET, (a) new org.apache.thrift.meta_data.b("target", (byte) 2, new org.apache.thrift.meta_data.g((byte) 12, u.class)));
        enumMap.put((EnumMap) a.ID, (a) new org.apache.thrift.meta_data.b("id", (byte) 1, new org.apache.thrift.meta_data.c((byte) 11)));
        enumMap.put((EnumMap) a.APP_ID, (a) new org.apache.thrift.meta_data.b("appId", (byte) 1, new org.apache.thrift.meta_data.c((byte) 11)));
        enumMap.put((EnumMap) a.REG_ID, (a) new org.apache.thrift.meta_data.b("regId", (byte) 2, new org.apache.thrift.meta_data.c((byte) 11)));
        enumMap.put((EnumMap) a.APP_VERSION, (a) new org.apache.thrift.meta_data.b("appVersion", (byte) 2, new org.apache.thrift.meta_data.c((byte) 11)));
        enumMap.put((EnumMap) a.PACKAGE_NAME, (a) new org.apache.thrift.meta_data.b("packageName", (byte) 2, new org.apache.thrift.meta_data.c((byte) 11)));
        enumMap.put((EnumMap) a.TOKEN, (a) new org.apache.thrift.meta_data.b("token", (byte) 2, new org.apache.thrift.meta_data.c((byte) 11)));
        enumMap.put((EnumMap) a.DEVICE_ID, (a) new org.apache.thrift.meta_data.b("deviceId", (byte) 2, new org.apache.thrift.meta_data.c((byte) 11)));
        enumMap.put((EnumMap) a.ALIAS_NAME, (a) new org.apache.thrift.meta_data.b("aliasName", (byte) 2, new org.apache.thrift.meta_data.c((byte) 11)));
        k = Collections.unmodifiableMap(enumMap);
        org.apache.thrift.meta_data.b.a(am.class, k);
    }

    public am a(String str) {
        this.c = str;
        return this;
    }

    @Override // org.apache.thrift.a
    public void a(org.apache.thrift.protocol.e eVar) {
        eVar.g();
        while (true) {
            org.apache.thrift.protocol.b i = eVar.i();
            if (i.b == 0) {
                eVar.h();
                k();
                return;
            }
            switch (i.c) {
                case 1:
                    if (i.b != 11) {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    } else {
                        this.a = eVar.w();
                        break;
                    }
                case 2:
                    if (i.b != 12) {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    } else {
                        this.b = new u();
                        this.b.a(eVar);
                        break;
                    }
                case 3:
                    if (i.b != 11) {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    } else {
                        this.c = eVar.w();
                        break;
                    }
                case 4:
                    if (i.b != 11) {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    } else {
                        this.d = eVar.w();
                        break;
                    }
                case 5:
                    if (i.b != 11) {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    } else {
                        this.e = eVar.w();
                        break;
                    }
                case 6:
                    if (i.b != 11) {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    } else {
                        this.f = eVar.w();
                        break;
                    }
                case 7:
                    if (i.b != 11) {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    } else {
                        this.g = eVar.w();
                        break;
                    }
                case 8:
                    if (i.b != 11) {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    } else {
                        this.h = eVar.w();
                        break;
                    }
                case 9:
                    if (i.b != 11) {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    } else {
                        this.i = eVar.w();
                        break;
                    }
                case 10:
                    if (i.b != 11) {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    } else {
                        this.j = eVar.w();
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

    public boolean a(am amVar) {
        if (amVar == null) {
            return false;
        }
        boolean a2 = a();
        boolean a3 = amVar.a();
        if ((a2 || a3) && !(a2 && a3 && this.a.equals(amVar.a))) {
            return false;
        }
        boolean b = b();
        boolean b2 = amVar.b();
        if ((b || b2) && !(b && b2 && this.b.a(amVar.b))) {
            return false;
        }
        boolean c = c();
        boolean c2 = amVar.c();
        if ((c || c2) && !(c && c2 && this.c.equals(amVar.c))) {
            return false;
        }
        boolean d = d();
        boolean d2 = amVar.d();
        if ((d || d2) && !(d && d2 && this.d.equals(amVar.d))) {
            return false;
        }
        boolean e = e();
        boolean e2 = amVar.e();
        if ((e || e2) && !(e && e2 && this.e.equals(amVar.e))) {
            return false;
        }
        boolean f = f();
        boolean f2 = amVar.f();
        if ((f || f2) && !(f && f2 && this.f.equals(amVar.f))) {
            return false;
        }
        boolean g = g();
        boolean g2 = amVar.g();
        if ((g || g2) && !(g && g2 && this.g.equals(amVar.g))) {
            return false;
        }
        boolean h = h();
        boolean h2 = amVar.h();
        if ((h || h2) && !(h && h2 && this.h.equals(amVar.h))) {
            return false;
        }
        boolean i = i();
        boolean i2 = amVar.i();
        if ((i || i2) && !(i && i2 && this.i.equals(amVar.i))) {
            return false;
        }
        boolean j = j();
        boolean j2 = amVar.j();
        return !(j || j2) || (j && j2 && this.j.equals(amVar.j));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: b */
    public int compareTo(am amVar) {
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
        if (getClass().equals(amVar.getClass())) {
            int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(amVar.a()));
            if (compareTo == 0) {
                if (!a() || (a11 = org.apache.thrift.b.a(this.a, amVar.a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(amVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a10 = org.apache.thrift.b.a(this.b, amVar.b)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(amVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a9 = org.apache.thrift.b.a(this.c, amVar.c)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(amVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a8 = org.apache.thrift.b.a(this.d, amVar.d)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(amVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a7 = org.apache.thrift.b.a(this.e, amVar.e)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(amVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a6 = org.apache.thrift.b.a(this.f, amVar.f)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(amVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a5 = org.apache.thrift.b.a(this.g, amVar.g)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(amVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a4 = org.apache.thrift.b.a(this.h, amVar.h)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(amVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a3 = org.apache.thrift.b.a(this.i, amVar.i)) == 0) {
                                                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(amVar.j()));
                                                                                    if (compareTo10 == 0) {
                                                                                        if (!j() || (a2 = org.apache.thrift.b.a(this.j, amVar.j)) == 0) {
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
        return getClass().getName().compareTo(amVar.getClass().getName());
    }

    public am b(String str) {
        this.d = str;
        return this;
    }

    @Override // org.apache.thrift.a
    public void b(org.apache.thrift.protocol.e eVar) {
        k();
        eVar.a(l);
        if (this.a != null && a()) {
            eVar.a(m);
            eVar.a(this.a);
            eVar.b();
        }
        if (this.b != null && b()) {
            eVar.a(n);
            this.b.b(eVar);
            eVar.b();
        }
        if (this.c != null) {
            eVar.a(o);
            eVar.a(this.c);
            eVar.b();
        }
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
        if (this.f != null && f()) {
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
        if (this.i != null && i()) {
            eVar.a(u);
            eVar.a(this.i);
            eVar.b();
        }
        if (this.j != null && j()) {
            eVar.a(v);
            eVar.a(this.j);
            eVar.b();
        }
        eVar.c();
        eVar.a();
    }

    public boolean b() {
        return this.b != null;
    }

    public am c(String str) {
        this.e = str;
        return this;
    }

    public boolean c() {
        return this.c != null;
    }

    public am d(String str) {
        this.g = str;
        return this;
    }

    public boolean d() {
        return this.d != null;
    }

    public am e(String str) {
        this.h = str;
        return this;
    }

    public boolean e() {
        return this.e != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof am)) {
            return a((am) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f != null;
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
        return this.i != null;
    }

    public boolean j() {
        return this.j != null;
    }

    public void k() {
        if (this.c == null) {
            throw new org.apache.thrift.protocol.f("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.d == null) {
            throw new org.apache.thrift.protocol.f("Required field 'appId' was not present! Struct: " + toString());
        }
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionUnRegistration(");
        boolean z2 = true;
        if (a()) {
            sb.append("debug:");
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
            sb.append("target:");
            if (this.b == null) {
                sb.append("null");
            } else {
                sb.append(this.b);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.c == null) {
            sb.append("null");
        } else {
            sb.append(this.c);
        }
        sb.append(", ");
        sb.append("appId:");
        if (this.d == null) {
            sb.append("null");
        } else {
            sb.append(this.d);
        }
        if (e()) {
            sb.append(", ");
            sb.append("regId:");
            if (this.e == null) {
                sb.append("null");
            } else {
                sb.append(this.e);
            }
        }
        if (f()) {
            sb.append(", ");
            sb.append("appVersion:");
            if (this.f == null) {
                sb.append("null");
            } else {
                sb.append(this.f);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.g == null) {
                sb.append("null");
            } else {
                sb.append(this.g);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("token:");
            if (this.h == null) {
                sb.append("null");
            } else {
                sb.append(this.h);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("deviceId:");
            if (this.i == null) {
                sb.append("null");
            } else {
                sb.append(this.i);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("aliasName:");
            if (this.j == null) {
                sb.append("null");
            } else {
                sb.append(this.j);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
