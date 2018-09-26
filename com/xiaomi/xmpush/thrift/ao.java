package com.xiaomi.xmpush.thrift;

import com.baidu.fsg.base.BaiduRimConstants;
import java.io.Serializable;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes3.dex */
public class ao implements Serializable, Cloneable, org.apache.thrift.a<ao, a> {
    public static final Map<a, org.apache.thrift.meta_data.b> h;
    private static final org.apache.thrift.protocol.j i = new org.apache.thrift.protocol.j("XmPushActionUnSubscription");
    private static final org.apache.thrift.protocol.b j = new org.apache.thrift.protocol.b("debug", (byte) 11, 1);
    private static final org.apache.thrift.protocol.b k = new org.apache.thrift.protocol.b(BaiduRimConstants.ACTION_TARGET, (byte) 12, 2);
    private static final org.apache.thrift.protocol.b l = new org.apache.thrift.protocol.b("id", (byte) 11, 3);
    private static final org.apache.thrift.protocol.b m = new org.apache.thrift.protocol.b("appId", (byte) 11, 4);
    private static final org.apache.thrift.protocol.b n = new org.apache.thrift.protocol.b("topic", (byte) 11, 5);
    private static final org.apache.thrift.protocol.b o = new org.apache.thrift.protocol.b("packageName", (byte) 11, 6);
    private static final org.apache.thrift.protocol.b p = new org.apache.thrift.protocol.b("category", (byte) 11, 7);
    public String a;
    public u b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;

    /* loaded from: classes3.dex */
    public enum a {
        DEBUG(1, "debug"),
        TARGET(2, BaiduRimConstants.ACTION_TARGET),
        ID(3, "id"),
        APP_ID(4, "appId"),
        TOPIC(5, "topic"),
        PACKAGE_NAME(6, "packageName"),
        CATEGORY(7, "category");
        
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
        enumMap.put((EnumMap) a.DEBUG, (a) new org.apache.thrift.meta_data.b("debug", (byte) 2, new org.apache.thrift.meta_data.c((byte) 11)));
        enumMap.put((EnumMap) a.TARGET, (a) new org.apache.thrift.meta_data.b(BaiduRimConstants.ACTION_TARGET, (byte) 2, new org.apache.thrift.meta_data.g((byte) 12, u.class)));
        enumMap.put((EnumMap) a.ID, (a) new org.apache.thrift.meta_data.b("id", (byte) 1, new org.apache.thrift.meta_data.c((byte) 11)));
        enumMap.put((EnumMap) a.APP_ID, (a) new org.apache.thrift.meta_data.b("appId", (byte) 1, new org.apache.thrift.meta_data.c((byte) 11)));
        enumMap.put((EnumMap) a.TOPIC, (a) new org.apache.thrift.meta_data.b("topic", (byte) 1, new org.apache.thrift.meta_data.c((byte) 11)));
        enumMap.put((EnumMap) a.PACKAGE_NAME, (a) new org.apache.thrift.meta_data.b("packageName", (byte) 2, new org.apache.thrift.meta_data.c((byte) 11)));
        enumMap.put((EnumMap) a.CATEGORY, (a) new org.apache.thrift.meta_data.b("category", (byte) 2, new org.apache.thrift.meta_data.c((byte) 11)));
        h = Collections.unmodifiableMap(enumMap);
        org.apache.thrift.meta_data.b.a(ao.class, h);
    }

    public ao a(String str) {
        this.c = str;
        return this;
    }

    @Override // org.apache.thrift.a
    public void a(org.apache.thrift.protocol.e eVar) {
        eVar.g();
        while (true) {
            org.apache.thrift.protocol.b i2 = eVar.i();
            if (i2.b == 0) {
                eVar.h();
                h();
                return;
            }
            switch (i2.c) {
                case 1:
                    if (i2.b != 11) {
                        org.apache.thrift.protocol.h.a(eVar, i2.b);
                        break;
                    } else {
                        this.a = eVar.w();
                        break;
                    }
                case 2:
                    if (i2.b != 12) {
                        org.apache.thrift.protocol.h.a(eVar, i2.b);
                        break;
                    } else {
                        this.b = new u();
                        this.b.a(eVar);
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
                    if (i2.b != 11) {
                        org.apache.thrift.protocol.h.a(eVar, i2.b);
                        break;
                    } else {
                        this.e = eVar.w();
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
                    if (i2.b != 11) {
                        org.apache.thrift.protocol.h.a(eVar, i2.b);
                        break;
                    } else {
                        this.g = eVar.w();
                        break;
                    }
                default:
                    org.apache.thrift.protocol.h.a(eVar, i2.b);
                    break;
            }
            eVar.j();
        }
    }

    public boolean a() {
        return this.a != null;
    }

    public boolean a(ao aoVar) {
        if (aoVar == null) {
            return false;
        }
        boolean a2 = a();
        boolean a3 = aoVar.a();
        if ((a2 || a3) && !(a2 && a3 && this.a.equals(aoVar.a))) {
            return false;
        }
        boolean b = b();
        boolean b2 = aoVar.b();
        if ((b || b2) && !(b && b2 && this.b.a(aoVar.b))) {
            return false;
        }
        boolean c = c();
        boolean c2 = aoVar.c();
        if ((c || c2) && !(c && c2 && this.c.equals(aoVar.c))) {
            return false;
        }
        boolean d = d();
        boolean d2 = aoVar.d();
        if ((d || d2) && !(d && d2 && this.d.equals(aoVar.d))) {
            return false;
        }
        boolean e = e();
        boolean e2 = aoVar.e();
        if ((e || e2) && !(e && e2 && this.e.equals(aoVar.e))) {
            return false;
        }
        boolean f = f();
        boolean f2 = aoVar.f();
        if ((f || f2) && !(f && f2 && this.f.equals(aoVar.f))) {
            return false;
        }
        boolean g = g();
        boolean g2 = aoVar.g();
        return !(g || g2) || (g && g2 && this.g.equals(aoVar.g));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: b */
    public int compareTo(ao aoVar) {
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        int a8;
        if (getClass().equals(aoVar.getClass())) {
            int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(aoVar.a()));
            if (compareTo == 0) {
                if (!a() || (a8 = org.apache.thrift.b.a(this.a, aoVar.a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(aoVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a7 = org.apache.thrift.b.a(this.b, aoVar.b)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(aoVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a6 = org.apache.thrift.b.a(this.c, aoVar.c)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(aoVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a5 = org.apache.thrift.b.a(this.d, aoVar.d)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(aoVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a4 = org.apache.thrift.b.a(this.e, aoVar.e)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(aoVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a3 = org.apache.thrift.b.a(this.f, aoVar.f)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(aoVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a2 = org.apache.thrift.b.a(this.g, aoVar.g)) == 0) {
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
        return getClass().getName().compareTo(aoVar.getClass().getName());
    }

    public ao b(String str) {
        this.d = str;
        return this;
    }

    @Override // org.apache.thrift.a
    public void b(org.apache.thrift.protocol.e eVar) {
        h();
        eVar.a(i);
        if (this.a != null && a()) {
            eVar.a(j);
            eVar.a(this.a);
            eVar.b();
        }
        if (this.b != null && b()) {
            eVar.a(k);
            this.b.b(eVar);
            eVar.b();
        }
        if (this.c != null) {
            eVar.a(l);
            eVar.a(this.c);
            eVar.b();
        }
        if (this.d != null) {
            eVar.a(m);
            eVar.a(this.d);
            eVar.b();
        }
        if (this.e != null) {
            eVar.a(n);
            eVar.a(this.e);
            eVar.b();
        }
        if (this.f != null && f()) {
            eVar.a(o);
            eVar.a(this.f);
            eVar.b();
        }
        if (this.g != null && g()) {
            eVar.a(p);
            eVar.a(this.g);
            eVar.b();
        }
        eVar.c();
        eVar.a();
    }

    public boolean b() {
        return this.b != null;
    }

    public ao c(String str) {
        this.e = str;
        return this;
    }

    public boolean c() {
        return this.c != null;
    }

    public ao d(String str) {
        this.f = str;
        return this;
    }

    public boolean d() {
        return this.d != null;
    }

    public ao e(String str) {
        this.g = str;
        return this;
    }

    public boolean e() {
        return this.e != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ao)) {
            return a((ao) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f != null;
    }

    public boolean g() {
        return this.g != null;
    }

    public void h() {
        if (this.c == null) {
            throw new org.apache.thrift.protocol.f("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.d == null) {
            throw new org.apache.thrift.protocol.f("Required field 'appId' was not present! Struct: " + toString());
        }
        if (this.e == null) {
            throw new org.apache.thrift.protocol.f("Required field 'topic' was not present! Struct: " + toString());
        }
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionUnSubscription(");
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
        sb.append(", ");
        sb.append("topic:");
        if (this.e == null) {
            sb.append("null");
        } else {
            sb.append(this.e);
        }
        if (f()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f == null) {
                sb.append("null");
            } else {
                sb.append(this.f);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("category:");
            if (this.g == null) {
                sb.append("null");
            } else {
                sb.append(this.g);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
