package com.xiaomi.xmpush.thrift;

import com.baidu.fsg.base.BaiduRimConstants;
import com.baidu.idl.authority.BuildConfig;
import com.sina.weibo.sdk.component.WidgetRequestParam;
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
public class z implements Serializable, Cloneable, org.apache.thrift.a<z, a> {
    public static final Map<a, org.apache.thrift.meta_data.b> i;
    private static final org.apache.thrift.protocol.j j = new org.apache.thrift.protocol.j("XmPushActionCommand");
    private static final org.apache.thrift.protocol.b k = new org.apache.thrift.protocol.b(BuildConfig.BUILD_TYPE, (byte) 11, 1);
    private static final org.apache.thrift.protocol.b l = new org.apache.thrift.protocol.b(BaiduRimConstants.ACTION_TARGET, (byte) 12, 2);
    private static final org.apache.thrift.protocol.b m = new org.apache.thrift.protocol.b("id", (byte) 11, 3);
    private static final org.apache.thrift.protocol.b n = new org.apache.thrift.protocol.b("appId", (byte) 11, 4);
    private static final org.apache.thrift.protocol.b o = new org.apache.thrift.protocol.b("cmdName", (byte) 11, 5);
    private static final org.apache.thrift.protocol.b p = new org.apache.thrift.protocol.b("cmdArgs", (byte) 15, 6);
    private static final org.apache.thrift.protocol.b q = new org.apache.thrift.protocol.b("packageName", (byte) 11, 7);
    private static final org.apache.thrift.protocol.b r = new org.apache.thrift.protocol.b(WidgetRequestParam.REQ_PARAM_COMMENT_CATEGORY, (byte) 11, 9);
    public String a;
    public u b;
    public String c;
    public String d;
    public String e;
    public List<String> f;
    public String g;
    public String h;

    /* loaded from: classes3.dex */
    public enum a {
        DEBUG(1, BuildConfig.BUILD_TYPE),
        TARGET(2, BaiduRimConstants.ACTION_TARGET),
        ID(3, "id"),
        APP_ID(4, "appId"),
        CMD_NAME(5, "cmdName"),
        CMD_ARGS(6, "cmdArgs"),
        PACKAGE_NAME(7, "packageName"),
        CATEGORY(9, WidgetRequestParam.REQ_PARAM_COMMENT_CATEGORY);
        
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
        enumMap.put((EnumMap) a.DEBUG, (a) new org.apache.thrift.meta_data.b(BuildConfig.BUILD_TYPE, (byte) 2, new org.apache.thrift.meta_data.c((byte) 11)));
        enumMap.put((EnumMap) a.TARGET, (a) new org.apache.thrift.meta_data.b(BaiduRimConstants.ACTION_TARGET, (byte) 2, new org.apache.thrift.meta_data.g((byte) 12, u.class)));
        enumMap.put((EnumMap) a.ID, (a) new org.apache.thrift.meta_data.b("id", (byte) 1, new org.apache.thrift.meta_data.c((byte) 11)));
        enumMap.put((EnumMap) a.APP_ID, (a) new org.apache.thrift.meta_data.b("appId", (byte) 1, new org.apache.thrift.meta_data.c((byte) 11)));
        enumMap.put((EnumMap) a.CMD_NAME, (a) new org.apache.thrift.meta_data.b("cmdName", (byte) 1, new org.apache.thrift.meta_data.c((byte) 11)));
        enumMap.put((EnumMap) a.CMD_ARGS, (a) new org.apache.thrift.meta_data.b("cmdArgs", (byte) 2, new org.apache.thrift.meta_data.d((byte) 15, new org.apache.thrift.meta_data.c((byte) 11))));
        enumMap.put((EnumMap) a.PACKAGE_NAME, (a) new org.apache.thrift.meta_data.b("packageName", (byte) 2, new org.apache.thrift.meta_data.c((byte) 11)));
        enumMap.put((EnumMap) a.CATEGORY, (a) new org.apache.thrift.meta_data.b(WidgetRequestParam.REQ_PARAM_COMMENT_CATEGORY, (byte) 2, new org.apache.thrift.meta_data.c((byte) 11)));
        i = Collections.unmodifiableMap(enumMap);
        org.apache.thrift.meta_data.b.a(z.class, i);
    }

    public z a(String str) {
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
                i();
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
                    if (i2.b == 11) {
                        this.e = eVar.w();
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i2.b);
                        break;
                    }
                case 6:
                    if (i2.b == 15) {
                        org.apache.thrift.protocol.c m2 = eVar.m();
                        this.f = new ArrayList(m2.b);
                        for (int i3 = 0; i3 < m2.b; i3++) {
                            this.f.add(eVar.w());
                        }
                        eVar.n();
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i2.b);
                        break;
                    }
                case 7:
                    if (i2.b == 11) {
                        this.g = eVar.w();
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i2.b);
                        break;
                    }
                case 8:
                default:
                    org.apache.thrift.protocol.h.a(eVar, i2.b);
                    break;
                case 9:
                    if (i2.b == 11) {
                        this.h = eVar.w();
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i2.b);
                        break;
                    }
            }
            eVar.j();
        }
    }

    public boolean a() {
        return this.a != null;
    }

    public boolean a(z zVar) {
        if (zVar == null) {
            return false;
        }
        boolean a2 = a();
        boolean a3 = zVar.a();
        if ((a2 || a3) && !(a2 && a3 && this.a.equals(zVar.a))) {
            return false;
        }
        boolean b = b();
        boolean b2 = zVar.b();
        if ((b || b2) && !(b && b2 && this.b.a(zVar.b))) {
            return false;
        }
        boolean c = c();
        boolean c2 = zVar.c();
        if ((c || c2) && !(c && c2 && this.c.equals(zVar.c))) {
            return false;
        }
        boolean d = d();
        boolean d2 = zVar.d();
        if ((d || d2) && !(d && d2 && this.d.equals(zVar.d))) {
            return false;
        }
        boolean e = e();
        boolean e2 = zVar.e();
        if ((e || e2) && !(e && e2 && this.e.equals(zVar.e))) {
            return false;
        }
        boolean f = f();
        boolean f2 = zVar.f();
        if ((f || f2) && !(f && f2 && this.f.equals(zVar.f))) {
            return false;
        }
        boolean g = g();
        boolean g2 = zVar.g();
        if ((g || g2) && !(g && g2 && this.g.equals(zVar.g))) {
            return false;
        }
        boolean h = h();
        boolean h2 = zVar.h();
        return !(h || h2) || (h && h2 && this.h.equals(zVar.h));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: b */
    public int compareTo(z zVar) {
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        int a8;
        int a9;
        if (getClass().equals(zVar.getClass())) {
            int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(zVar.a()));
            if (compareTo == 0) {
                if (!a() || (a9 = org.apache.thrift.b.a(this.a, zVar.a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(zVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a8 = org.apache.thrift.b.a(this.b, zVar.b)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(zVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a7 = org.apache.thrift.b.a(this.c, zVar.c)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(zVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a6 = org.apache.thrift.b.a(this.d, zVar.d)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(zVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a5 = org.apache.thrift.b.a(this.e, zVar.e)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(zVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a4 = org.apache.thrift.b.a(this.f, zVar.f)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(zVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a3 = org.apache.thrift.b.a(this.g, zVar.g)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(zVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a2 = org.apache.thrift.b.a(this.h, zVar.h)) == 0) {
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
        return getClass().getName().compareTo(zVar.getClass().getName());
    }

    public z b(String str) {
        this.d = str;
        return this;
    }

    @Override // org.apache.thrift.a
    public void b(org.apache.thrift.protocol.e eVar) {
        i();
        eVar.a(j);
        if (this.a != null && a()) {
            eVar.a(k);
            eVar.a(this.a);
            eVar.b();
        }
        if (this.b != null && b()) {
            eVar.a(l);
            this.b.b(eVar);
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
        if (this.e != null) {
            eVar.a(o);
            eVar.a(this.e);
            eVar.b();
        }
        if (this.f != null && f()) {
            eVar.a(p);
            eVar.a(new org.apache.thrift.protocol.c((byte) 11, this.f.size()));
            for (String str : this.f) {
                eVar.a(str);
            }
            eVar.e();
            eVar.b();
        }
        if (this.g != null && g()) {
            eVar.a(q);
            eVar.a(this.g);
            eVar.b();
        }
        if (this.h != null && h()) {
            eVar.a(r);
            eVar.a(this.h);
            eVar.b();
        }
        eVar.c();
        eVar.a();
    }

    public boolean b() {
        return this.b != null;
    }

    public z c(String str) {
        this.e = str;
        return this;
    }

    public boolean c() {
        return this.c != null;
    }

    public void d(String str) {
        if (this.f == null) {
            this.f = new ArrayList();
        }
        this.f.add(str);
    }

    public boolean d() {
        return this.d != null;
    }

    public z e(String str) {
        this.g = str;
        return this;
    }

    public boolean e() {
        return this.e != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof z)) {
            return a((z) obj);
        }
        return false;
    }

    public z f(String str) {
        this.h = str;
        return this;
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

    public void i() {
        if (this.c == null) {
            throw new org.apache.thrift.protocol.f("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.d == null) {
            throw new org.apache.thrift.protocol.f("Required field 'appId' was not present! Struct: " + toString());
        }
        if (this.e == null) {
            throw new org.apache.thrift.protocol.f("Required field 'cmdName' was not present! Struct: " + toString());
        }
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionCommand(");
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
        sb.append("cmdName:");
        if (this.e == null) {
            sb.append("null");
        } else {
            sb.append(this.e);
        }
        if (f()) {
            sb.append(", ");
            sb.append("cmdArgs:");
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
            sb.append("category:");
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
