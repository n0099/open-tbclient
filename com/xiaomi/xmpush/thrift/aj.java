package com.xiaomi.xmpush.thrift;

import com.baidu.android.pushservice.PushConstants;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import java.io.Serializable;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes2.dex */
public class aj implements Serializable, Cloneable, org.apache.thrift.a<aj, a> {
    public static final Map<a, org.apache.thrift.meta_data.b> m;
    private static final org.apache.thrift.protocol.j n = new org.apache.thrift.protocol.j("XmPushActionSendMessage");
    private static final org.apache.thrift.protocol.b o = new org.apache.thrift.protocol.b("debug", (byte) 11, 1);
    private static final org.apache.thrift.protocol.b p = new org.apache.thrift.protocol.b("target", (byte) 12, 2);
    private static final org.apache.thrift.protocol.b q = new org.apache.thrift.protocol.b("id", (byte) 11, 3);
    private static final org.apache.thrift.protocol.b r = new org.apache.thrift.protocol.b("appId", (byte) 11, 4);
    private static final org.apache.thrift.protocol.b s = new org.apache.thrift.protocol.b("packageName", (byte) 11, 5);
    private static final org.apache.thrift.protocol.b t = new org.apache.thrift.protocol.b("topic", (byte) 11, 6);
    private static final org.apache.thrift.protocol.b u = new org.apache.thrift.protocol.b("aliasName", (byte) 11, 7);
    private static final org.apache.thrift.protocol.b v = new org.apache.thrift.protocol.b(PushConstants.EXTRA_PUSH_MESSAGE, (byte) 12, 8);
    private static final org.apache.thrift.protocol.b w = new org.apache.thrift.protocol.b("needAck", (byte) 2, 9);
    private static final org.apache.thrift.protocol.b x = new org.apache.thrift.protocol.b(LegoListActivityConfig.PARAMS, (byte) 13, 10);
    private static final org.apache.thrift.protocol.b y = new org.apache.thrift.protocol.b("category", (byte) 11, 11);
    private static final org.apache.thrift.protocol.b z = new org.apache.thrift.protocol.b("userAccount", (byte) 11, 12);
    public String a;
    public u b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public q h;
    public Map<String, String> j;
    public String k;
    public String l;
    private BitSet A = new BitSet(1);
    public boolean i = true;

    /* loaded from: classes2.dex */
    public enum a {
        DEBUG(1, "debug"),
        TARGET(2, "target"),
        ID(3, "id"),
        APP_ID(4, "appId"),
        PACKAGE_NAME(5, "packageName"),
        TOPIC(6, "topic"),
        ALIAS_NAME(7, "aliasName"),
        MESSAGE(8, PushConstants.EXTRA_PUSH_MESSAGE),
        NEED_ACK(9, "needAck"),
        PARAMS(10, LegoListActivityConfig.PARAMS),
        CATEGORY(11, "category"),
        USER_ACCOUNT(12, "userAccount");
        
        private static final Map<String, a> m = new HashMap();
        private final short n;
        private final String o;

        static {
            Iterator it = EnumSet.allOf(a.class).iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                m.put(aVar.a(), aVar);
            }
        }

        a(short s, String str) {
            this.n = s;
            this.o = str;
        }

        public String a() {
            return this.o;
        }
    }

    static {
        EnumMap enumMap = new EnumMap(a.class);
        enumMap.put((EnumMap) a.DEBUG, (a) new org.apache.thrift.meta_data.b("debug", (byte) 2, new org.apache.thrift.meta_data.c((byte) 11)));
        enumMap.put((EnumMap) a.TARGET, (a) new org.apache.thrift.meta_data.b("target", (byte) 2, new org.apache.thrift.meta_data.g((byte) 12, u.class)));
        enumMap.put((EnumMap) a.ID, (a) new org.apache.thrift.meta_data.b("id", (byte) 1, new org.apache.thrift.meta_data.c((byte) 11)));
        enumMap.put((EnumMap) a.APP_ID, (a) new org.apache.thrift.meta_data.b("appId", (byte) 1, new org.apache.thrift.meta_data.c((byte) 11)));
        enumMap.put((EnumMap) a.PACKAGE_NAME, (a) new org.apache.thrift.meta_data.b("packageName", (byte) 2, new org.apache.thrift.meta_data.c((byte) 11)));
        enumMap.put((EnumMap) a.TOPIC, (a) new org.apache.thrift.meta_data.b("topic", (byte) 2, new org.apache.thrift.meta_data.c((byte) 11)));
        enumMap.put((EnumMap) a.ALIAS_NAME, (a) new org.apache.thrift.meta_data.b("aliasName", (byte) 2, new org.apache.thrift.meta_data.c((byte) 11)));
        enumMap.put((EnumMap) a.MESSAGE, (a) new org.apache.thrift.meta_data.b(PushConstants.EXTRA_PUSH_MESSAGE, (byte) 2, new org.apache.thrift.meta_data.g((byte) 12, q.class)));
        enumMap.put((EnumMap) a.NEED_ACK, (a) new org.apache.thrift.meta_data.b("needAck", (byte) 2, new org.apache.thrift.meta_data.c((byte) 2)));
        enumMap.put((EnumMap) a.PARAMS, (a) new org.apache.thrift.meta_data.b(LegoListActivityConfig.PARAMS, (byte) 2, new org.apache.thrift.meta_data.e((byte) 13, new org.apache.thrift.meta_data.c((byte) 11), new org.apache.thrift.meta_data.c((byte) 11))));
        enumMap.put((EnumMap) a.CATEGORY, (a) new org.apache.thrift.meta_data.b("category", (byte) 2, new org.apache.thrift.meta_data.c((byte) 11)));
        enumMap.put((EnumMap) a.USER_ACCOUNT, (a) new org.apache.thrift.meta_data.b("userAccount", (byte) 2, new org.apache.thrift.meta_data.c((byte) 11)));
        m = Collections.unmodifiableMap(enumMap);
        org.apache.thrift.meta_data.b.a(aj.class, m);
    }

    @Override // org.apache.thrift.a
    public void a(org.apache.thrift.protocol.e eVar) {
        eVar.g();
        while (true) {
            org.apache.thrift.protocol.b i = eVar.i();
            if (i.b == 0) {
                eVar.h();
                t();
                return;
            }
            switch (i.c) {
                case 1:
                    if (i.b == 11) {
                        this.a = eVar.w();
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    }
                case 2:
                    if (i.b == 12) {
                        this.b = new u();
                        this.b.a(eVar);
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    }
                case 3:
                    if (i.b == 11) {
                        this.c = eVar.w();
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    }
                case 4:
                    if (i.b == 11) {
                        this.d = eVar.w();
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    }
                case 5:
                    if (i.b == 11) {
                        this.e = eVar.w();
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    }
                case 6:
                    if (i.b == 11) {
                        this.f = eVar.w();
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    }
                case 7:
                    if (i.b == 11) {
                        this.g = eVar.w();
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    }
                case 8:
                    if (i.b == 12) {
                        this.h = new q();
                        this.h.a(eVar);
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    }
                case 9:
                    if (i.b == 2) {
                        this.i = eVar.q();
                        a(true);
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    }
                case 10:
                    if (i.b == 13) {
                        org.apache.thrift.protocol.d k = eVar.k();
                        this.j = new HashMap(k.c * 2);
                        for (int i2 = 0; i2 < k.c; i2++) {
                            this.j.put(eVar.w(), eVar.w());
                        }
                        eVar.l();
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    }
                case 11:
                    if (i.b == 11) {
                        this.k = eVar.w();
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    }
                case 12:
                    if (i.b == 11) {
                        this.l = eVar.w();
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

    public void a(boolean z2) {
        this.A.set(0, z2);
    }

    public boolean a() {
        return this.a != null;
    }

    public boolean a(aj ajVar) {
        if (ajVar == null) {
            return false;
        }
        boolean a2 = a();
        boolean a3 = ajVar.a();
        if ((a2 || a3) && !(a2 && a3 && this.a.equals(ajVar.a))) {
            return false;
        }
        boolean b = b();
        boolean b2 = ajVar.b();
        if ((b || b2) && !(b && b2 && this.b.a(ajVar.b))) {
            return false;
        }
        boolean d = d();
        boolean d2 = ajVar.d();
        if ((d || d2) && !(d && d2 && this.c.equals(ajVar.c))) {
            return false;
        }
        boolean f = f();
        boolean f2 = ajVar.f();
        if ((f || f2) && !(f && f2 && this.d.equals(ajVar.d))) {
            return false;
        }
        boolean g = g();
        boolean g2 = ajVar.g();
        if ((g || g2) && !(g && g2 && this.e.equals(ajVar.e))) {
            return false;
        }
        boolean i = i();
        boolean i2 = ajVar.i();
        if ((i || i2) && !(i && i2 && this.f.equals(ajVar.f))) {
            return false;
        }
        boolean k = k();
        boolean k2 = ajVar.k();
        if ((k || k2) && !(k && k2 && this.g.equals(ajVar.g))) {
            return false;
        }
        boolean m2 = m();
        boolean m3 = ajVar.m();
        if ((m2 || m3) && !(m2 && m3 && this.h.a(ajVar.h))) {
            return false;
        }
        boolean n2 = n();
        boolean n3 = ajVar.n();
        if ((n2 || n3) && !(n2 && n3 && this.i == ajVar.i)) {
            return false;
        }
        boolean o2 = o();
        boolean o3 = ajVar.o();
        if ((o2 || o3) && !(o2 && o3 && this.j.equals(ajVar.j))) {
            return false;
        }
        boolean q2 = q();
        boolean q3 = ajVar.q();
        if ((q2 || q3) && !(q2 && q3 && this.k.equals(ajVar.k))) {
            return false;
        }
        boolean s2 = s();
        boolean s3 = ajVar.s();
        return !(s2 || s3) || (s2 && s3 && this.l.equals(ajVar.l));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: b */
    public int compareTo(aj ajVar) {
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
        int a12;
        int a13;
        if (getClass().equals(ajVar.getClass())) {
            int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(ajVar.a()));
            if (compareTo == 0) {
                if (!a() || (a13 = org.apache.thrift.b.a(this.a, ajVar.a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(ajVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a12 = org.apache.thrift.b.a(this.b, ajVar.b)) == 0) {
                            int compareTo3 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(ajVar.d()));
                            if (compareTo3 == 0) {
                                if (!d() || (a11 = org.apache.thrift.b.a(this.c, ajVar.c)) == 0) {
                                    int compareTo4 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(ajVar.f()));
                                    if (compareTo4 == 0) {
                                        if (!f() || (a10 = org.apache.thrift.b.a(this.d, ajVar.d)) == 0) {
                                            int compareTo5 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ajVar.g()));
                                            if (compareTo5 == 0) {
                                                if (!g() || (a9 = org.apache.thrift.b.a(this.e, ajVar.e)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(ajVar.i()));
                                                    if (compareTo6 == 0) {
                                                        if (!i() || (a8 = org.apache.thrift.b.a(this.f, ajVar.f)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(ajVar.k()));
                                                            if (compareTo7 == 0) {
                                                                if (!k() || (a7 = org.apache.thrift.b.a(this.g, ajVar.g)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(ajVar.m()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!m() || (a6 = org.apache.thrift.b.a(this.h, ajVar.h)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(ajVar.n()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!n() || (a5 = org.apache.thrift.b.a(this.i, ajVar.i)) == 0) {
                                                                                    int compareTo10 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(ajVar.o()));
                                                                                    if (compareTo10 == 0) {
                                                                                        if (!o() || (a4 = org.apache.thrift.b.a(this.j, ajVar.j)) == 0) {
                                                                                            int compareTo11 = Boolean.valueOf(q()).compareTo(Boolean.valueOf(ajVar.q()));
                                                                                            if (compareTo11 == 0) {
                                                                                                if (!q() || (a3 = org.apache.thrift.b.a(this.k, ajVar.k)) == 0) {
                                                                                                    int compareTo12 = Boolean.valueOf(s()).compareTo(Boolean.valueOf(ajVar.s()));
                                                                                                    if (compareTo12 == 0) {
                                                                                                        if (!s() || (a2 = org.apache.thrift.b.a(this.l, ajVar.l)) == 0) {
                                                                                                            return 0;
                                                                                                        }
                                                                                                        return a2;
                                                                                                    }
                                                                                                    return compareTo12;
                                                                                                }
                                                                                                return a3;
                                                                                            }
                                                                                            return compareTo11;
                                                                                        }
                                                                                        return a4;
                                                                                    }
                                                                                    return compareTo10;
                                                                                }
                                                                                return a5;
                                                                            }
                                                                            return compareTo9;
                                                                        }
                                                                        return a6;
                                                                    }
                                                                    return compareTo8;
                                                                }
                                                                return a7;
                                                            }
                                                            return compareTo7;
                                                        }
                                                        return a8;
                                                    }
                                                    return compareTo6;
                                                }
                                                return a9;
                                            }
                                            return compareTo5;
                                        }
                                        return a10;
                                    }
                                    return compareTo4;
                                }
                                return a11;
                            }
                            return compareTo3;
                        }
                        return a12;
                    }
                    return compareTo2;
                }
                return a13;
            }
            return compareTo;
        }
        return getClass().getName().compareTo(ajVar.getClass().getName());
    }

    @Override // org.apache.thrift.a
    public void b(org.apache.thrift.protocol.e eVar) {
        t();
        eVar.a(n);
        if (this.a != null && a()) {
            eVar.a(o);
            eVar.a(this.a);
            eVar.b();
        }
        if (this.b != null && b()) {
            eVar.a(p);
            this.b.b(eVar);
            eVar.b();
        }
        if (this.c != null) {
            eVar.a(q);
            eVar.a(this.c);
            eVar.b();
        }
        if (this.d != null) {
            eVar.a(r);
            eVar.a(this.d);
            eVar.b();
        }
        if (this.e != null && g()) {
            eVar.a(s);
            eVar.a(this.e);
            eVar.b();
        }
        if (this.f != null && i()) {
            eVar.a(t);
            eVar.a(this.f);
            eVar.b();
        }
        if (this.g != null && k()) {
            eVar.a(u);
            eVar.a(this.g);
            eVar.b();
        }
        if (this.h != null && m()) {
            eVar.a(v);
            this.h.b(eVar);
            eVar.b();
        }
        if (n()) {
            eVar.a(w);
            eVar.a(this.i);
            eVar.b();
        }
        if (this.j != null && o()) {
            eVar.a(x);
            eVar.a(new org.apache.thrift.protocol.d((byte) 11, (byte) 11, this.j.size()));
            for (Map.Entry<String, String> entry : this.j.entrySet()) {
                eVar.a(entry.getKey());
                eVar.a(entry.getValue());
            }
            eVar.d();
            eVar.b();
        }
        if (this.k != null && q()) {
            eVar.a(y);
            eVar.a(this.k);
            eVar.b();
        }
        if (this.l != null && s()) {
            eVar.a(z);
            eVar.a(this.l);
            eVar.b();
        }
        eVar.c();
        eVar.a();
    }

    public boolean b() {
        return this.b != null;
    }

    public String c() {
        return this.c;
    }

    public boolean d() {
        return this.c != null;
    }

    public String e() {
        return this.d;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof aj)) {
            return a((aj) obj);
        }
        return false;
    }

    public boolean f() {
        return this.d != null;
    }

    public boolean g() {
        return this.e != null;
    }

    public String h() {
        return this.f;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f != null;
    }

    public String j() {
        return this.g;
    }

    public boolean k() {
        return this.g != null;
    }

    public q l() {
        return this.h;
    }

    public boolean m() {
        return this.h != null;
    }

    public boolean n() {
        return this.A.get(0);
    }

    public boolean o() {
        return this.j != null;
    }

    public String p() {
        return this.k;
    }

    public boolean q() {
        return this.k != null;
    }

    public String r() {
        return this.l;
    }

    public boolean s() {
        return this.l != null;
    }

    public void t() {
        if (this.c == null) {
            throw new org.apache.thrift.protocol.f("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.d == null) {
            throw new org.apache.thrift.protocol.f("Required field 'appId' was not present! Struct: " + toString());
        }
    }

    public String toString() {
        boolean z2 = false;
        StringBuilder sb = new StringBuilder("XmPushActionSendMessage(");
        boolean z3 = true;
        if (a()) {
            sb.append("debug:");
            if (this.a == null) {
                sb.append("null");
            } else {
                sb.append(this.a);
            }
            z3 = false;
        }
        if (b()) {
            if (!z3) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.b == null) {
                sb.append("null");
            } else {
                sb.append(this.b);
            }
        } else {
            z2 = z3;
        }
        if (!z2) {
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
        if (g()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.e == null) {
                sb.append("null");
            } else {
                sb.append(this.e);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("topic:");
            if (this.f == null) {
                sb.append("null");
            } else {
                sb.append(this.f);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("aliasName:");
            if (this.g == null) {
                sb.append("null");
            } else {
                sb.append(this.g);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("message:");
            if (this.h == null) {
                sb.append("null");
            } else {
                sb.append(this.h);
            }
        }
        if (n()) {
            sb.append(", ");
            sb.append("needAck:");
            sb.append(this.i);
        }
        if (o()) {
            sb.append(", ");
            sb.append("params:");
            if (this.j == null) {
                sb.append("null");
            } else {
                sb.append(this.j);
            }
        }
        if (q()) {
            sb.append(", ");
            sb.append("category:");
            if (this.k == null) {
                sb.append("null");
            } else {
                sb.append(this.k);
            }
        }
        if (s()) {
            sb.append(", ");
            sb.append("userAccount:");
            if (this.l == null) {
                sb.append("null");
            } else {
                sb.append(this.l);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
