package com.xiaomi.xmpush.thrift;

import com.baidu.ar.constants.HttpConstants;
import com.sina.weibo.sdk.component.WidgetRequestParam;
import java.io.Serializable;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes3.dex */
public class d implements Serializable, Cloneable, org.apache.thrift.a<d, a> {
    public static final Map<a, org.apache.thrift.meta_data.b> h;
    private static final org.apache.thrift.protocol.j i = new org.apache.thrift.protocol.j("ClientUploadDataItem");
    private static final org.apache.thrift.protocol.b j = new org.apache.thrift.protocol.b("channel", (byte) 11, 1);
    private static final org.apache.thrift.protocol.b k = new org.apache.thrift.protocol.b("data", (byte) 11, 2);
    private static final org.apache.thrift.protocol.b l = new org.apache.thrift.protocol.b("name", (byte) 11, 3);
    private static final org.apache.thrift.protocol.b m = new org.apache.thrift.protocol.b("counter", (byte) 10, 4);
    private static final org.apache.thrift.protocol.b n = new org.apache.thrift.protocol.b(HttpConstants.TIMESTAMP, (byte) 10, 5);
    private static final org.apache.thrift.protocol.b o = new org.apache.thrift.protocol.b("fromSdk", (byte) 2, 6);
    private static final org.apache.thrift.protocol.b p = new org.apache.thrift.protocol.b(WidgetRequestParam.REQ_PARAM_COMMENT_CATEGORY, (byte) 11, 7);
    public String a;
    public String b;
    public String c;
    public long d;
    public long e;
    public boolean f;
    public String g;
    private BitSet q = new BitSet(3);

    /* loaded from: classes3.dex */
    public enum a {
        CHANNEL(1, "channel"),
        DATA(2, "data"),
        NAME(3, "name"),
        COUNTER(4, "counter"),
        TIMESTAMP(5, HttpConstants.TIMESTAMP),
        FROM_SDK(6, "fromSdk"),
        CATEGORY(7, WidgetRequestParam.REQ_PARAM_COMMENT_CATEGORY);
        
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
        enumMap.put((EnumMap) a.CHANNEL, (a) new org.apache.thrift.meta_data.b("channel", (byte) 2, new org.apache.thrift.meta_data.c((byte) 11)));
        enumMap.put((EnumMap) a.DATA, (a) new org.apache.thrift.meta_data.b("data", (byte) 2, new org.apache.thrift.meta_data.c((byte) 11)));
        enumMap.put((EnumMap) a.NAME, (a) new org.apache.thrift.meta_data.b("name", (byte) 2, new org.apache.thrift.meta_data.c((byte) 11)));
        enumMap.put((EnumMap) a.COUNTER, (a) new org.apache.thrift.meta_data.b("counter", (byte) 2, new org.apache.thrift.meta_data.c((byte) 10)));
        enumMap.put((EnumMap) a.TIMESTAMP, (a) new org.apache.thrift.meta_data.b(HttpConstants.TIMESTAMP, (byte) 2, new org.apache.thrift.meta_data.c((byte) 10)));
        enumMap.put((EnumMap) a.FROM_SDK, (a) new org.apache.thrift.meta_data.b("fromSdk", (byte) 2, new org.apache.thrift.meta_data.c((byte) 2)));
        enumMap.put((EnumMap) a.CATEGORY, (a) new org.apache.thrift.meta_data.b(WidgetRequestParam.REQ_PARAM_COMMENT_CATEGORY, (byte) 2, new org.apache.thrift.meta_data.c((byte) 11)));
        h = Collections.unmodifiableMap(enumMap);
        org.apache.thrift.meta_data.b.a(d.class, h);
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
                    if (i2.b != 10) {
                        org.apache.thrift.protocol.h.a(eVar, i2.b);
                        break;
                    } else {
                        this.d = eVar.u();
                        a(true);
                        break;
                    }
                case 5:
                    if (i2.b != 10) {
                        org.apache.thrift.protocol.h.a(eVar, i2.b);
                        break;
                    } else {
                        this.e = eVar.u();
                        b(true);
                        break;
                    }
                case 6:
                    if (i2.b != 2) {
                        org.apache.thrift.protocol.h.a(eVar, i2.b);
                        break;
                    } else {
                        this.f = eVar.q();
                        c(true);
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

    public void a(boolean z) {
        this.q.set(0, z);
    }

    public boolean a() {
        return this.a != null;
    }

    public boolean a(d dVar) {
        if (dVar == null) {
            return false;
        }
        boolean a2 = a();
        boolean a3 = dVar.a();
        if ((a2 || a3) && !(a2 && a3 && this.a.equals(dVar.a))) {
            return false;
        }
        boolean b = b();
        boolean b2 = dVar.b();
        if ((b || b2) && !(b && b2 && this.b.equals(dVar.b))) {
            return false;
        }
        boolean c = c();
        boolean c2 = dVar.c();
        if ((c || c2) && !(c && c2 && this.c.equals(dVar.c))) {
            return false;
        }
        boolean d = d();
        boolean d2 = dVar.d();
        if ((d || d2) && !(d && d2 && this.d == dVar.d)) {
            return false;
        }
        boolean e = e();
        boolean e2 = dVar.e();
        if ((e || e2) && !(e && e2 && this.e == dVar.e)) {
            return false;
        }
        boolean f = f();
        boolean f2 = dVar.f();
        if ((f || f2) && !(f && f2 && this.f == dVar.f)) {
            return false;
        }
        boolean g = g();
        boolean g2 = dVar.g();
        return !(g || g2) || (g && g2 && this.g.equals(dVar.g));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: b */
    public int compareTo(d dVar) {
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        int a8;
        if (getClass().equals(dVar.getClass())) {
            int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(dVar.a()));
            if (compareTo == 0) {
                if (!a() || (a8 = org.apache.thrift.b.a(this.a, dVar.a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(dVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a7 = org.apache.thrift.b.a(this.b, dVar.b)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(dVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a6 = org.apache.thrift.b.a(this.c, dVar.c)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(dVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a5 = org.apache.thrift.b.a(this.d, dVar.d)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(dVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a4 = org.apache.thrift.b.a(this.e, dVar.e)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(dVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a3 = org.apache.thrift.b.a(this.f, dVar.f)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(dVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a2 = org.apache.thrift.b.a(this.g, dVar.g)) == 0) {
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
        return getClass().getName().compareTo(dVar.getClass().getName());
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
            eVar.a(this.b);
            eVar.b();
        }
        if (this.c != null && c()) {
            eVar.a(l);
            eVar.a(this.c);
            eVar.b();
        }
        if (d()) {
            eVar.a(m);
            eVar.a(this.d);
            eVar.b();
        }
        if (e()) {
            eVar.a(n);
            eVar.a(this.e);
            eVar.b();
        }
        if (f()) {
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

    public void b(boolean z) {
        this.q.set(1, z);
    }

    public boolean b() {
        return this.b != null;
    }

    public void c(boolean z) {
        this.q.set(2, z);
    }

    public boolean c() {
        return this.c != null;
    }

    public boolean d() {
        return this.q.get(0);
    }

    public boolean e() {
        return this.q.get(1);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof d)) {
            return a((d) obj);
        }
        return false;
    }

    public boolean f() {
        return this.q.get(2);
    }

    public boolean g() {
        return this.g != null;
    }

    public void h() {
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("ClientUploadDataItem(");
        boolean z2 = true;
        if (a()) {
            sb.append("channel:");
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
            sb.append("data:");
            if (this.b == null) {
                sb.append("null");
            } else {
                sb.append(this.b);
            }
            z2 = false;
        }
        if (c()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("name:");
            if (this.c == null) {
                sb.append("null");
            } else {
                sb.append(this.c);
            }
            z2 = false;
        }
        if (d()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("counter:");
            sb.append(this.d);
            z2 = false;
        }
        if (e()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("timestamp:");
            sb.append(this.e);
            z2 = false;
        }
        if (f()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("fromSdk:");
            sb.append(this.f);
        } else {
            z = z2;
        }
        if (g()) {
            if (!z) {
                sb.append(", ");
            }
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
