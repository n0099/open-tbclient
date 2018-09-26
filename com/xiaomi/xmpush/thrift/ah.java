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
public class ah implements Serializable, Cloneable, org.apache.thrift.a<ah, a> {
    public static final Map<a, org.apache.thrift.meta_data.b> g;
    private static final org.apache.thrift.protocol.j h = new org.apache.thrift.protocol.j("XmPushActionSendFeedback");
    private static final org.apache.thrift.protocol.b i = new org.apache.thrift.protocol.b("debug", (byte) 11, 1);
    private static final org.apache.thrift.protocol.b j = new org.apache.thrift.protocol.b(BaiduRimConstants.ACTION_TARGET, (byte) 12, 2);
    private static final org.apache.thrift.protocol.b k = new org.apache.thrift.protocol.b("id", (byte) 11, 3);
    private static final org.apache.thrift.protocol.b l = new org.apache.thrift.protocol.b("appId", (byte) 11, 4);
    private static final org.apache.thrift.protocol.b m = new org.apache.thrift.protocol.b("feedbacks", (byte) 13, 5);
    private static final org.apache.thrift.protocol.b n = new org.apache.thrift.protocol.b("category", (byte) 11, 6);
    public String a;
    public u b;
    public String c;
    public String d;
    public Map<String, String> e;
    public String f;

    /* loaded from: classes3.dex */
    public enum a {
        DEBUG(1, "debug"),
        TARGET(2, BaiduRimConstants.ACTION_TARGET),
        ID(3, "id"),
        APP_ID(4, "appId"),
        FEEDBACKS(5, "feedbacks"),
        CATEGORY(6, "category");
        
        private static final Map<String, a> g = new HashMap();
        private final short h;
        private final String i;

        static {
            Iterator it = EnumSet.allOf(a.class).iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                g.put(aVar.a(), aVar);
            }
        }

        a(short s, String str) {
            this.h = s;
            this.i = str;
        }

        public String a() {
            return this.i;
        }
    }

    static {
        EnumMap enumMap = new EnumMap(a.class);
        enumMap.put((EnumMap) a.DEBUG, (a) new org.apache.thrift.meta_data.b("debug", (byte) 2, new org.apache.thrift.meta_data.c((byte) 11)));
        enumMap.put((EnumMap) a.TARGET, (a) new org.apache.thrift.meta_data.b(BaiduRimConstants.ACTION_TARGET, (byte) 2, new org.apache.thrift.meta_data.g((byte) 12, u.class)));
        enumMap.put((EnumMap) a.ID, (a) new org.apache.thrift.meta_data.b("id", (byte) 1, new org.apache.thrift.meta_data.c((byte) 11)));
        enumMap.put((EnumMap) a.APP_ID, (a) new org.apache.thrift.meta_data.b("appId", (byte) 1, new org.apache.thrift.meta_data.c((byte) 11)));
        enumMap.put((EnumMap) a.FEEDBACKS, (a) new org.apache.thrift.meta_data.b("feedbacks", (byte) 2, new org.apache.thrift.meta_data.e((byte) 13, new org.apache.thrift.meta_data.c((byte) 11), new org.apache.thrift.meta_data.c((byte) 11))));
        enumMap.put((EnumMap) a.CATEGORY, (a) new org.apache.thrift.meta_data.b("category", (byte) 2, new org.apache.thrift.meta_data.c((byte) 11)));
        g = Collections.unmodifiableMap(enumMap);
        org.apache.thrift.meta_data.b.a(ah.class, g);
    }

    @Override // org.apache.thrift.a
    public void a(org.apache.thrift.protocol.e eVar) {
        eVar.g();
        while (true) {
            org.apache.thrift.protocol.b i2 = eVar.i();
            if (i2.b == 0) {
                eVar.h();
                g();
                return;
            }
            switch (i2.c) {
                case 1:
                    if (i2.b == 11) {
                        this.a = eVar.w();
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i2.b);
                        break;
                    }
                case 2:
                    if (i2.b == 12) {
                        this.b = new u();
                        this.b.a(eVar);
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i2.b);
                        break;
                    }
                case 3:
                    if (i2.b == 11) {
                        this.c = eVar.w();
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i2.b);
                        break;
                    }
                case 4:
                    if (i2.b == 11) {
                        this.d = eVar.w();
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i2.b);
                        break;
                    }
                case 5:
                    if (i2.b == 13) {
                        org.apache.thrift.protocol.d k2 = eVar.k();
                        this.e = new HashMap(k2.c * 2);
                        for (int i3 = 0; i3 < k2.c; i3++) {
                            this.e.put(eVar.w(), eVar.w());
                        }
                        eVar.l();
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i2.b);
                        break;
                    }
                case 6:
                    if (i2.b == 11) {
                        this.f = eVar.w();
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i2.b);
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

    public boolean a(ah ahVar) {
        if (ahVar == null) {
            return false;
        }
        boolean a2 = a();
        boolean a3 = ahVar.a();
        if ((a2 || a3) && !(a2 && a3 && this.a.equals(ahVar.a))) {
            return false;
        }
        boolean b = b();
        boolean b2 = ahVar.b();
        if ((b || b2) && !(b && b2 && this.b.a(ahVar.b))) {
            return false;
        }
        boolean c = c();
        boolean c2 = ahVar.c();
        if ((c || c2) && !(c && c2 && this.c.equals(ahVar.c))) {
            return false;
        }
        boolean d = d();
        boolean d2 = ahVar.d();
        if ((d || d2) && !(d && d2 && this.d.equals(ahVar.d))) {
            return false;
        }
        boolean e = e();
        boolean e2 = ahVar.e();
        if ((e || e2) && !(e && e2 && this.e.equals(ahVar.e))) {
            return false;
        }
        boolean f = f();
        boolean f2 = ahVar.f();
        return !(f || f2) || (f && f2 && this.f.equals(ahVar.f));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: b */
    public int compareTo(ah ahVar) {
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        if (getClass().equals(ahVar.getClass())) {
            int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(ahVar.a()));
            if (compareTo == 0) {
                if (!a() || (a7 = org.apache.thrift.b.a(this.a, ahVar.a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(ahVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a6 = org.apache.thrift.b.a(this.b, ahVar.b)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(ahVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a5 = org.apache.thrift.b.a(this.c, ahVar.c)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(ahVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a4 = org.apache.thrift.b.a(this.d, ahVar.d)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(ahVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a3 = org.apache.thrift.b.a(this.e, ahVar.e)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(ahVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a2 = org.apache.thrift.b.a(this.f, ahVar.f)) == 0) {
                                                            return 0;
                                                        }
                                                        return a2;
                                                    }
                                                    return compareTo6;
                                                }
                                                return a3;
                                            }
                                            return compareTo5;
                                        }
                                        return a4;
                                    }
                                    return compareTo4;
                                }
                                return a5;
                            }
                            return compareTo3;
                        }
                        return a6;
                    }
                    return compareTo2;
                }
                return a7;
            }
            return compareTo;
        }
        return getClass().getName().compareTo(ahVar.getClass().getName());
    }

    @Override // org.apache.thrift.a
    public void b(org.apache.thrift.protocol.e eVar) {
        g();
        eVar.a(h);
        if (this.a != null && a()) {
            eVar.a(i);
            eVar.a(this.a);
            eVar.b();
        }
        if (this.b != null && b()) {
            eVar.a(j);
            this.b.b(eVar);
            eVar.b();
        }
        if (this.c != null) {
            eVar.a(k);
            eVar.a(this.c);
            eVar.b();
        }
        if (this.d != null) {
            eVar.a(l);
            eVar.a(this.d);
            eVar.b();
        }
        if (this.e != null && e()) {
            eVar.a(m);
            eVar.a(new org.apache.thrift.protocol.d((byte) 11, (byte) 11, this.e.size()));
            for (Map.Entry<String, String> entry : this.e.entrySet()) {
                eVar.a(entry.getKey());
                eVar.a(entry.getValue());
            }
            eVar.d();
            eVar.b();
        }
        if (this.f != null && f()) {
            eVar.a(n);
            eVar.a(this.f);
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

    public boolean d() {
        return this.d != null;
    }

    public boolean e() {
        return this.e != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ah)) {
            return a((ah) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f != null;
    }

    public void g() {
        if (this.c == null) {
            throw new org.apache.thrift.protocol.f("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.d == null) {
            throw new org.apache.thrift.protocol.f("Required field 'appId' was not present! Struct: " + toString());
        }
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionSendFeedback(");
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
            sb.append("feedbacks:");
            if (this.e == null) {
                sb.append("null");
            } else {
                sb.append(this.e);
            }
        }
        if (f()) {
            sb.append(", ");
            sb.append("category:");
            if (this.f == null) {
                sb.append("null");
            } else {
                sb.append(this.f);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
