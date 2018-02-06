package com.xiaomi.xmpush.thrift;

import com.baidu.fsg.base.BaiduRimConstants;
import com.baidu.idl.authority.BuildConfig;
import com.sina.weibo.sdk.component.WidgetRequestParam;
import java.io.Serializable;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes2.dex */
public class al implements Serializable, Cloneable, org.apache.thrift.a<al, a> {
    public static final Map<a, org.apache.thrift.meta_data.b> k;
    private static final org.apache.thrift.protocol.j l = new org.apache.thrift.protocol.j("XmPushActionSubscriptionResult");
    private static final org.apache.thrift.protocol.b m = new org.apache.thrift.protocol.b(BuildConfig.BUILD_TYPE, (byte) 11, 1);
    private static final org.apache.thrift.protocol.b n = new org.apache.thrift.protocol.b(BaiduRimConstants.ACTION_TARGET, (byte) 12, 2);
    private static final org.apache.thrift.protocol.b o = new org.apache.thrift.protocol.b("id", (byte) 11, 3);
    private static final org.apache.thrift.protocol.b p = new org.apache.thrift.protocol.b("appId", (byte) 11, 4);
    private static final org.apache.thrift.protocol.b q = new org.apache.thrift.protocol.b("request", (byte) 12, 5);
    private static final org.apache.thrift.protocol.b r = new org.apache.thrift.protocol.b("errorCode", (byte) 10, 6);
    private static final org.apache.thrift.protocol.b s = new org.apache.thrift.protocol.b("reason", (byte) 11, 7);
    private static final org.apache.thrift.protocol.b t = new org.apache.thrift.protocol.b("topic", (byte) 11, 8);
    private static final org.apache.thrift.protocol.b u = new org.apache.thrift.protocol.b("packageName", (byte) 11, 9);
    private static final org.apache.thrift.protocol.b v = new org.apache.thrift.protocol.b(WidgetRequestParam.REQ_PARAM_COMMENT_CATEGORY, (byte) 11, 10);
    public String a;
    public u b;
    public String c;
    public String d;
    public ak e;
    public long f;
    public String g;
    public String h;
    public String i;
    public String j;
    private BitSet w = new BitSet(1);

    /* loaded from: classes2.dex */
    public enum a {
        DEBUG(1, BuildConfig.BUILD_TYPE),
        TARGET(2, BaiduRimConstants.ACTION_TARGET),
        ID(3, "id"),
        APP_ID(4, "appId"),
        REQUEST(5, "request"),
        ERROR_CODE(6, "errorCode"),
        REASON(7, "reason"),
        TOPIC(8, "topic"),
        PACKAGE_NAME(9, "packageName"),
        CATEGORY(10, WidgetRequestParam.REQ_PARAM_COMMENT_CATEGORY);
        
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
        enumMap.put((EnumMap) a.DEBUG, (a) new org.apache.thrift.meta_data.b(BuildConfig.BUILD_TYPE, (byte) 2, new org.apache.thrift.meta_data.c((byte) 11)));
        enumMap.put((EnumMap) a.TARGET, (a) new org.apache.thrift.meta_data.b(BaiduRimConstants.ACTION_TARGET, (byte) 2, new org.apache.thrift.meta_data.g((byte) 12, u.class)));
        enumMap.put((EnumMap) a.ID, (a) new org.apache.thrift.meta_data.b("id", (byte) 1, new org.apache.thrift.meta_data.c((byte) 11)));
        enumMap.put((EnumMap) a.APP_ID, (a) new org.apache.thrift.meta_data.b("appId", (byte) 2, new org.apache.thrift.meta_data.c((byte) 11)));
        enumMap.put((EnumMap) a.REQUEST, (a) new org.apache.thrift.meta_data.b("request", (byte) 2, new org.apache.thrift.meta_data.g((byte) 12, ak.class)));
        enumMap.put((EnumMap) a.ERROR_CODE, (a) new org.apache.thrift.meta_data.b("errorCode", (byte) 2, new org.apache.thrift.meta_data.c((byte) 10)));
        enumMap.put((EnumMap) a.REASON, (a) new org.apache.thrift.meta_data.b("reason", (byte) 2, new org.apache.thrift.meta_data.c((byte) 11)));
        enumMap.put((EnumMap) a.TOPIC, (a) new org.apache.thrift.meta_data.b("topic", (byte) 2, new org.apache.thrift.meta_data.c((byte) 11)));
        enumMap.put((EnumMap) a.PACKAGE_NAME, (a) new org.apache.thrift.meta_data.b("packageName", (byte) 2, new org.apache.thrift.meta_data.c((byte) 11)));
        enumMap.put((EnumMap) a.CATEGORY, (a) new org.apache.thrift.meta_data.b(WidgetRequestParam.REQ_PARAM_COMMENT_CATEGORY, (byte) 2, new org.apache.thrift.meta_data.c((byte) 11)));
        k = Collections.unmodifiableMap(enumMap);
        org.apache.thrift.meta_data.b.a(al.class, k);
    }

    @Override // org.apache.thrift.a
    public void a(org.apache.thrift.protocol.e eVar) {
        eVar.g();
        while (true) {
            org.apache.thrift.protocol.b i = eVar.i();
            if (i.b == 0) {
                eVar.h();
                m();
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
                    if (i.b != 12) {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    } else {
                        this.e = new ak();
                        this.e.a(eVar);
                        break;
                    }
                case 6:
                    if (i.b != 10) {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    } else {
                        this.f = eVar.u();
                        a(true);
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

    public void a(boolean z) {
        this.w.set(0, z);
    }

    public boolean a() {
        return this.a != null;
    }

    public boolean a(al alVar) {
        if (alVar == null) {
            return false;
        }
        boolean a2 = a();
        boolean a3 = alVar.a();
        if ((a2 || a3) && !(a2 && a3 && this.a.equals(alVar.a))) {
            return false;
        }
        boolean b = b();
        boolean b2 = alVar.b();
        if ((b || b2) && !(b && b2 && this.b.a(alVar.b))) {
            return false;
        }
        boolean c = c();
        boolean c2 = alVar.c();
        if ((c || c2) && !(c && c2 && this.c.equals(alVar.c))) {
            return false;
        }
        boolean d = d();
        boolean d2 = alVar.d();
        if ((d || d2) && !(d && d2 && this.d.equals(alVar.d))) {
            return false;
        }
        boolean e = e();
        boolean e2 = alVar.e();
        if ((e || e2) && !(e && e2 && this.e.a(alVar.e))) {
            return false;
        }
        boolean f = f();
        boolean f2 = alVar.f();
        if ((f || f2) && !(f && f2 && this.f == alVar.f)) {
            return false;
        }
        boolean g = g();
        boolean g2 = alVar.g();
        if ((g || g2) && !(g && g2 && this.g.equals(alVar.g))) {
            return false;
        }
        boolean i = i();
        boolean i2 = alVar.i();
        if ((i || i2) && !(i && i2 && this.h.equals(alVar.h))) {
            return false;
        }
        boolean j = j();
        boolean j2 = alVar.j();
        if ((j || j2) && !(j && j2 && this.i.equals(alVar.i))) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = alVar.l();
        return !(l2 || l3) || (l2 && l3 && this.j.equals(alVar.j));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: b */
    public int compareTo(al alVar) {
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
        if (getClass().equals(alVar.getClass())) {
            int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(alVar.a()));
            if (compareTo == 0) {
                if (!a() || (a11 = org.apache.thrift.b.a(this.a, alVar.a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(alVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a10 = org.apache.thrift.b.a(this.b, alVar.b)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(alVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a9 = org.apache.thrift.b.a(this.c, alVar.c)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(alVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a8 = org.apache.thrift.b.a(this.d, alVar.d)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(alVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a7 = org.apache.thrift.b.a(this.e, alVar.e)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(alVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a6 = org.apache.thrift.b.a(this.f, alVar.f)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(alVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a5 = org.apache.thrift.b.a(this.g, alVar.g)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(alVar.i()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!i() || (a4 = org.apache.thrift.b.a(this.h, alVar.h)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(alVar.j()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!j() || (a3 = org.apache.thrift.b.a(this.i, alVar.i)) == 0) {
                                                                                    int compareTo10 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(alVar.l()));
                                                                                    if (compareTo10 == 0) {
                                                                                        if (!l() || (a2 = org.apache.thrift.b.a(this.j, alVar.j)) == 0) {
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
        return getClass().getName().compareTo(alVar.getClass().getName());
    }

    @Override // org.apache.thrift.a
    public void b(org.apache.thrift.protocol.e eVar) {
        m();
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
        if (this.d != null && d()) {
            eVar.a(p);
            eVar.a(this.d);
            eVar.b();
        }
        if (this.e != null && e()) {
            eVar.a(q);
            this.e.b(eVar);
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
        if (this.h != null && i()) {
            eVar.a(t);
            eVar.a(this.h);
            eVar.b();
        }
        if (this.i != null && j()) {
            eVar.a(u);
            eVar.a(this.i);
            eVar.b();
        }
        if (this.j != null && l()) {
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
        if (obj != null && (obj instanceof al)) {
            return a((al) obj);
        }
        return false;
    }

    public boolean f() {
        return this.w.get(0);
    }

    public boolean g() {
        return this.g != null;
    }

    public String h() {
        return this.h;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.h != null;
    }

    public boolean j() {
        return this.i != null;
    }

    public String k() {
        return this.j;
    }

    public boolean l() {
        return this.j != null;
    }

    public void m() {
        if (this.c == null) {
            throw new org.apache.thrift.protocol.f("Required field 'id' was not present! Struct: " + toString());
        }
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionSubscriptionResult(");
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
        if (d()) {
            sb.append(", ");
            sb.append("appId:");
            if (this.d == null) {
                sb.append("null");
            } else {
                sb.append(this.d);
            }
        }
        if (e()) {
            sb.append(", ");
            sb.append("request:");
            if (this.e == null) {
                sb.append("null");
            } else {
                sb.append(this.e);
            }
        }
        if (f()) {
            sb.append(", ");
            sb.append("errorCode:");
            sb.append(this.f);
        }
        if (g()) {
            sb.append(", ");
            sb.append("reason:");
            if (this.g == null) {
                sb.append("null");
            } else {
                sb.append(this.g);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("topic:");
            if (this.h == null) {
                sb.append("null");
            } else {
                sb.append(this.h);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.i == null) {
                sb.append("null");
            } else {
                sb.append(this.i);
            }
        }
        if (l()) {
            sb.append(", ");
            sb.append("category:");
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
