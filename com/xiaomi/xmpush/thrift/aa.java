package com.xiaomi.xmpush.thrift;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public class aa implements Serializable, Cloneable, org.apache.thrift.a<aa, a> {
    public static final Map<a, org.apache.thrift.meta_data.b> l;
    private static final org.apache.thrift.protocol.j m = new org.apache.thrift.protocol.j("XmPushActionCommandResult");
    private static final org.apache.thrift.protocol.b n = new org.apache.thrift.protocol.b("debug", (byte) 11, 1);
    private static final org.apache.thrift.protocol.b o = new org.apache.thrift.protocol.b("target", (byte) 12, 2);
    private static final org.apache.thrift.protocol.b p = new org.apache.thrift.protocol.b("id", (byte) 11, 3);
    private static final org.apache.thrift.protocol.b q = new org.apache.thrift.protocol.b("appId", (byte) 11, 4);
    private static final org.apache.thrift.protocol.b r = new org.apache.thrift.protocol.b("cmdName", (byte) 11, 5);
    private static final org.apache.thrift.protocol.b s = new org.apache.thrift.protocol.b("request", (byte) 12, 6);
    private static final org.apache.thrift.protocol.b t = new org.apache.thrift.protocol.b("errorCode", (byte) 10, 7);
    private static final org.apache.thrift.protocol.b u = new org.apache.thrift.protocol.b("reason", (byte) 11, 8);
    private static final org.apache.thrift.protocol.b v = new org.apache.thrift.protocol.b("packageName", (byte) 11, 9);
    private static final org.apache.thrift.protocol.b w = new org.apache.thrift.protocol.b("cmdArgs", (byte) 15, 10);
    private static final org.apache.thrift.protocol.b x = new org.apache.thrift.protocol.b("category", (byte) 11, 12);
    public String a;
    public u b;
    public String c;
    public String d;
    public String e;
    public z f;
    public long g;
    public String h;
    public String i;
    public List<String> j;
    public String k;
    private BitSet y = new BitSet(1);

    /* loaded from: classes2.dex */
    public enum a {
        DEBUG(1, "debug"),
        TARGET(2, "target"),
        ID(3, "id"),
        APP_ID(4, "appId"),
        CMD_NAME(5, "cmdName"),
        REQUEST(6, "request"),
        ERROR_CODE(7, "errorCode"),
        REASON(8, "reason"),
        PACKAGE_NAME(9, "packageName"),
        CMD_ARGS(10, "cmdArgs"),
        CATEGORY(12, "category");
        
        private static final Map<String, a> l = new HashMap();
        private final short m;
        private final String n;

        static {
            Iterator it = EnumSet.allOf(a.class).iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                l.put(aVar.a(), aVar);
            }
        }

        a(short s, String str) {
            this.m = s;
            this.n = str;
        }

        public String a() {
            return this.n;
        }
    }

    static {
        EnumMap enumMap = new EnumMap(a.class);
        enumMap.put((EnumMap) a.DEBUG, (a) new org.apache.thrift.meta_data.b("debug", (byte) 2, new org.apache.thrift.meta_data.c((byte) 11)));
        enumMap.put((EnumMap) a.TARGET, (a) new org.apache.thrift.meta_data.b("target", (byte) 2, new org.apache.thrift.meta_data.g((byte) 12, u.class)));
        enumMap.put((EnumMap) a.ID, (a) new org.apache.thrift.meta_data.b("id", (byte) 1, new org.apache.thrift.meta_data.c((byte) 11)));
        enumMap.put((EnumMap) a.APP_ID, (a) new org.apache.thrift.meta_data.b("appId", (byte) 1, new org.apache.thrift.meta_data.c((byte) 11)));
        enumMap.put((EnumMap) a.CMD_NAME, (a) new org.apache.thrift.meta_data.b("cmdName", (byte) 1, new org.apache.thrift.meta_data.c((byte) 11)));
        enumMap.put((EnumMap) a.REQUEST, (a) new org.apache.thrift.meta_data.b("request", (byte) 2, new org.apache.thrift.meta_data.g((byte) 12, z.class)));
        enumMap.put((EnumMap) a.ERROR_CODE, (a) new org.apache.thrift.meta_data.b("errorCode", (byte) 1, new org.apache.thrift.meta_data.c((byte) 10)));
        enumMap.put((EnumMap) a.REASON, (a) new org.apache.thrift.meta_data.b("reason", (byte) 2, new org.apache.thrift.meta_data.c((byte) 11)));
        enumMap.put((EnumMap) a.PACKAGE_NAME, (a) new org.apache.thrift.meta_data.b("packageName", (byte) 2, new org.apache.thrift.meta_data.c((byte) 11)));
        enumMap.put((EnumMap) a.CMD_ARGS, (a) new org.apache.thrift.meta_data.b("cmdArgs", (byte) 2, new org.apache.thrift.meta_data.d((byte) 15, new org.apache.thrift.meta_data.c((byte) 11))));
        enumMap.put((EnumMap) a.CATEGORY, (a) new org.apache.thrift.meta_data.b("category", (byte) 2, new org.apache.thrift.meta_data.c((byte) 11)));
        l = Collections.unmodifiableMap(enumMap);
        org.apache.thrift.meta_data.b.a(aa.class, l);
    }

    @Override // org.apache.thrift.a
    public void a(org.apache.thrift.protocol.e eVar) {
        eVar.g();
        while (true) {
            org.apache.thrift.protocol.b i = eVar.i();
            if (i.b == 0) {
                eVar.h();
                if (!h()) {
                    throw new org.apache.thrift.protocol.f("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
                }
                o();
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
                    if (i.b == 12) {
                        this.f = new z();
                        this.f.a(eVar);
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    }
                case 7:
                    if (i.b == 10) {
                        this.g = eVar.u();
                        a(true);
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    }
                case 8:
                    if (i.b == 11) {
                        this.h = eVar.w();
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    }
                case 9:
                    if (i.b == 11) {
                        this.i = eVar.w();
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    }
                case 10:
                    if (i.b == 15) {
                        org.apache.thrift.protocol.c m2 = eVar.m();
                        this.j = new ArrayList(m2.b);
                        for (int i2 = 0; i2 < m2.b; i2++) {
                            this.j.add(eVar.w());
                        }
                        eVar.n();
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    }
                case 11:
                default:
                    org.apache.thrift.protocol.h.a(eVar, i.b);
                    break;
                case 12:
                    if (i.b == 11) {
                        this.k = eVar.w();
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    }
            }
            eVar.j();
        }
    }

    public void a(boolean z) {
        this.y.set(0, z);
    }

    public boolean a() {
        return this.a != null;
    }

    public boolean a(aa aaVar) {
        if (aaVar == null) {
            return false;
        }
        boolean a2 = a();
        boolean a3 = aaVar.a();
        if ((a2 || a3) && !(a2 && a3 && this.a.equals(aaVar.a))) {
            return false;
        }
        boolean b = b();
        boolean b2 = aaVar.b();
        if ((b || b2) && !(b && b2 && this.b.a(aaVar.b))) {
            return false;
        }
        boolean c = c();
        boolean c2 = aaVar.c();
        if ((c || c2) && !(c && c2 && this.c.equals(aaVar.c))) {
            return false;
        }
        boolean d = d();
        boolean d2 = aaVar.d();
        if ((d || d2) && !(d && d2 && this.d.equals(aaVar.d))) {
            return false;
        }
        boolean f = f();
        boolean f2 = aaVar.f();
        if ((f || f2) && !(f && f2 && this.e.equals(aaVar.e))) {
            return false;
        }
        boolean g = g();
        boolean g2 = aaVar.g();
        if (((g || g2) && !(g && g2 && this.f.a(aaVar.f))) || this.g != aaVar.g) {
            return false;
        }
        boolean i = i();
        boolean i2 = aaVar.i();
        if ((i || i2) && !(i && i2 && this.h.equals(aaVar.h))) {
            return false;
        }
        boolean j = j();
        boolean j2 = aaVar.j();
        if ((j || j2) && !(j && j2 && this.i.equals(aaVar.i))) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = aaVar.l();
        if ((l2 || l3) && !(l2 && l3 && this.j.equals(aaVar.j))) {
            return false;
        }
        boolean n2 = n();
        boolean n3 = aaVar.n();
        return !(n2 || n3) || (n2 && n3 && this.k.equals(aaVar.k));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: b */
    public int compareTo(aa aaVar) {
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
        if (getClass().equals(aaVar.getClass())) {
            int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(aaVar.a()));
            if (compareTo == 0) {
                if (!a() || (a12 = org.apache.thrift.b.a(this.a, aaVar.a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(aaVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a11 = org.apache.thrift.b.a(this.b, aaVar.b)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(aaVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a10 = org.apache.thrift.b.a(this.c, aaVar.c)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(aaVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a9 = org.apache.thrift.b.a(this.d, aaVar.d)) == 0) {
                                            int compareTo5 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(aaVar.f()));
                                            if (compareTo5 == 0) {
                                                if (!f() || (a8 = org.apache.thrift.b.a(this.e, aaVar.e)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(aaVar.g()));
                                                    if (compareTo6 == 0) {
                                                        if (!g() || (a7 = org.apache.thrift.b.a(this.f, aaVar.f)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(aaVar.h()));
                                                            if (compareTo7 == 0) {
                                                                if (!h() || (a6 = org.apache.thrift.b.a(this.g, aaVar.g)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(aaVar.i()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!i() || (a5 = org.apache.thrift.b.a(this.h, aaVar.h)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(aaVar.j()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!j() || (a4 = org.apache.thrift.b.a(this.i, aaVar.i)) == 0) {
                                                                                    int compareTo10 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(aaVar.l()));
                                                                                    if (compareTo10 == 0) {
                                                                                        if (!l() || (a3 = org.apache.thrift.b.a(this.j, aaVar.j)) == 0) {
                                                                                            int compareTo11 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(aaVar.n()));
                                                                                            if (compareTo11 == 0) {
                                                                                                if (!n() || (a2 = org.apache.thrift.b.a(this.k, aaVar.k)) == 0) {
                                                                                                    return 0;
                                                                                                }
                                                                                                return a2;
                                                                                            }
                                                                                            return compareTo11;
                                                                                        }
                                                                                        return a3;
                                                                                    }
                                                                                    return compareTo10;
                                                                                }
                                                                                return a4;
                                                                            }
                                                                            return compareTo9;
                                                                        }
                                                                        return a5;
                                                                    }
                                                                    return compareTo8;
                                                                }
                                                                return a6;
                                                            }
                                                            return compareTo7;
                                                        }
                                                        return a7;
                                                    }
                                                    return compareTo6;
                                                }
                                                return a8;
                                            }
                                            return compareTo5;
                                        }
                                        return a9;
                                    }
                                    return compareTo4;
                                }
                                return a10;
                            }
                            return compareTo3;
                        }
                        return a11;
                    }
                    return compareTo2;
                }
                return a12;
            }
            return compareTo;
        }
        return getClass().getName().compareTo(aaVar.getClass().getName());
    }

    @Override // org.apache.thrift.a
    public void b(org.apache.thrift.protocol.e eVar) {
        o();
        eVar.a(m);
        if (this.a != null && a()) {
            eVar.a(n);
            eVar.a(this.a);
            eVar.b();
        }
        if (this.b != null && b()) {
            eVar.a(o);
            this.b.b(eVar);
            eVar.b();
        }
        if (this.c != null) {
            eVar.a(p);
            eVar.a(this.c);
            eVar.b();
        }
        if (this.d != null) {
            eVar.a(q);
            eVar.a(this.d);
            eVar.b();
        }
        if (this.e != null) {
            eVar.a(r);
            eVar.a(this.e);
            eVar.b();
        }
        if (this.f != null && g()) {
            eVar.a(s);
            this.f.b(eVar);
            eVar.b();
        }
        eVar.a(t);
        eVar.a(this.g);
        eVar.b();
        if (this.h != null && i()) {
            eVar.a(u);
            eVar.a(this.h);
            eVar.b();
        }
        if (this.i != null && j()) {
            eVar.a(v);
            eVar.a(this.i);
            eVar.b();
        }
        if (this.j != null && l()) {
            eVar.a(w);
            eVar.a(new org.apache.thrift.protocol.c((byte) 11, this.j.size()));
            for (String str : this.j) {
                eVar.a(str);
            }
            eVar.e();
            eVar.b();
        }
        if (this.k != null && n()) {
            eVar.a(x);
            eVar.a(this.k);
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

    public String e() {
        return this.e;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof aa)) {
            return a((aa) obj);
        }
        return false;
    }

    public boolean f() {
        return this.e != null;
    }

    public boolean g() {
        return this.f != null;
    }

    public boolean h() {
        return this.y.get(0);
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

    public List<String> k() {
        return this.j;
    }

    public boolean l() {
        return this.j != null;
    }

    public String m() {
        return this.k;
    }

    public boolean n() {
        return this.k != null;
    }

    public void o() {
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
        StringBuilder sb = new StringBuilder("XmPushActionCommandResult(");
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
        if (g()) {
            sb.append(", ");
            sb.append("request:");
            if (this.f == null) {
                sb.append("null");
            } else {
                sb.append(this.f);
            }
        }
        sb.append(", ");
        sb.append("errorCode:");
        sb.append(this.g);
        if (i()) {
            sb.append(", ");
            sb.append("reason:");
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
            sb.append("cmdArgs:");
            if (this.j == null) {
                sb.append("null");
            } else {
                sb.append(this.j);
            }
        }
        if (n()) {
            sb.append(", ");
            sb.append("category:");
            if (this.k == null) {
                sb.append("null");
            } else {
                sb.append(this.k);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
