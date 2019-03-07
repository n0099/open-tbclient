package com.xiaomi.xmpush.thrift;

import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes3.dex */
public class ab implements Serializable, Cloneable, org.apache.thrift.a<ab, a> {
    public static final Map<a, org.apache.thrift.meta_data.b> i;
    private static final org.apache.thrift.protocol.j j = new org.apache.thrift.protocol.j("XmPushActionContainer");
    private static final org.apache.thrift.protocol.b k = new org.apache.thrift.protocol.b("action", (byte) 8, 1);
    private static final org.apache.thrift.protocol.b l = new org.apache.thrift.protocol.b("encryptAction", (byte) 2, 2);
    private static final org.apache.thrift.protocol.b m = new org.apache.thrift.protocol.b("isRequest", (byte) 2, 3);
    private static final org.apache.thrift.protocol.b n = new org.apache.thrift.protocol.b("pushAction", (byte) 11, 4);
    private static final org.apache.thrift.protocol.b o = new org.apache.thrift.protocol.b("appid", (byte) 11, 5);
    private static final org.apache.thrift.protocol.b p = new org.apache.thrift.protocol.b("packageName", (byte) 11, 6);
    private static final org.apache.thrift.protocol.b q = new org.apache.thrift.protocol.b("target", (byte) 12, 7);
    private static final org.apache.thrift.protocol.b r = new org.apache.thrift.protocol.b("metaInfo", (byte) 12, 8);
    public com.xiaomi.xmpush.thrift.a a;
    public ByteBuffer d;
    public String e;
    public String f;
    public u g;
    public r h;
    private BitSet s = new BitSet(2);
    public boolean b = true;
    public boolean c = true;

    /* loaded from: classes3.dex */
    public enum a {
        ACTION(1, "action"),
        ENCRYPT_ACTION(2, "encryptAction"),
        IS_REQUEST(3, "isRequest"),
        PUSH_ACTION(4, "pushAction"),
        APPID(5, "appid"),
        PACKAGE_NAME(6, "packageName"),
        TARGET(7, "target"),
        META_INFO(8, "metaInfo");
        
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
        enumMap.put((EnumMap) a.ACTION, (a) new org.apache.thrift.meta_data.b("action", (byte) 1, new org.apache.thrift.meta_data.a((byte) 16, com.xiaomi.xmpush.thrift.a.class)));
        enumMap.put((EnumMap) a.ENCRYPT_ACTION, (a) new org.apache.thrift.meta_data.b("encryptAction", (byte) 1, new org.apache.thrift.meta_data.c((byte) 2)));
        enumMap.put((EnumMap) a.IS_REQUEST, (a) new org.apache.thrift.meta_data.b("isRequest", (byte) 1, new org.apache.thrift.meta_data.c((byte) 2)));
        enumMap.put((EnumMap) a.PUSH_ACTION, (a) new org.apache.thrift.meta_data.b("pushAction", (byte) 1, new org.apache.thrift.meta_data.c((byte) 11)));
        enumMap.put((EnumMap) a.APPID, (a) new org.apache.thrift.meta_data.b("appid", (byte) 2, new org.apache.thrift.meta_data.c((byte) 11)));
        enumMap.put((EnumMap) a.PACKAGE_NAME, (a) new org.apache.thrift.meta_data.b("packageName", (byte) 2, new org.apache.thrift.meta_data.c((byte) 11)));
        enumMap.put((EnumMap) a.TARGET, (a) new org.apache.thrift.meta_data.b("target", (byte) 1, new org.apache.thrift.meta_data.g((byte) 12, u.class)));
        enumMap.put((EnumMap) a.META_INFO, (a) new org.apache.thrift.meta_data.b("metaInfo", (byte) 2, new org.apache.thrift.meta_data.g((byte) 12, r.class)));
        i = Collections.unmodifiableMap(enumMap);
        org.apache.thrift.meta_data.b.a(ab.class, i);
    }

    public com.xiaomi.xmpush.thrift.a a() {
        return this.a;
    }

    public ab a(com.xiaomi.xmpush.thrift.a aVar) {
        this.a = aVar;
        return this;
    }

    public ab a(r rVar) {
        this.h = rVar;
        return this;
    }

    public ab a(u uVar) {
        this.g = uVar;
        return this;
    }

    public ab a(String str) {
        this.e = str;
        return this;
    }

    public ab a(ByteBuffer byteBuffer) {
        this.d = byteBuffer;
        return this;
    }

    public ab a(boolean z) {
        this.b = z;
        b(true);
        return this;
    }

    @Override // org.apache.thrift.a
    public void a(org.apache.thrift.protocol.e eVar) {
        eVar.g();
        while (true) {
            org.apache.thrift.protocol.b i2 = eVar.i();
            if (i2.b == 0) {
                eVar.h();
                if (!d()) {
                    throw new org.apache.thrift.protocol.f("Required field 'encryptAction' was not found in serialized data! Struct: " + toString());
                }
                if (!e()) {
                    throw new org.apache.thrift.protocol.f("Required field 'isRequest' was not found in serialized data! Struct: " + toString());
                }
                o();
                return;
            }
            switch (i2.c) {
                case 1:
                    if (i2.b != 8) {
                        org.apache.thrift.protocol.h.a(eVar, i2.b);
                        break;
                    } else {
                        this.a = com.xiaomi.xmpush.thrift.a.a(eVar.t());
                        break;
                    }
                case 2:
                    if (i2.b != 2) {
                        org.apache.thrift.protocol.h.a(eVar, i2.b);
                        break;
                    } else {
                        this.b = eVar.q();
                        b(true);
                        break;
                    }
                case 3:
                    if (i2.b != 2) {
                        org.apache.thrift.protocol.h.a(eVar, i2.b);
                        break;
                    } else {
                        this.c = eVar.q();
                        d(true);
                        break;
                    }
                case 4:
                    if (i2.b != 11) {
                        org.apache.thrift.protocol.h.a(eVar, i2.b);
                        break;
                    } else {
                        this.d = eVar.x();
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
                    if (i2.b != 12) {
                        org.apache.thrift.protocol.h.a(eVar, i2.b);
                        break;
                    } else {
                        this.g = new u();
                        this.g.a(eVar);
                        break;
                    }
                case 8:
                    if (i2.b != 12) {
                        org.apache.thrift.protocol.h.a(eVar, i2.b);
                        break;
                    } else {
                        this.h = new r();
                        this.h.a(eVar);
                        break;
                    }
                default:
                    org.apache.thrift.protocol.h.a(eVar, i2.b);
                    break;
            }
            eVar.j();
        }
    }

    public boolean a(ab abVar) {
        if (abVar == null) {
            return false;
        }
        boolean b = b();
        boolean b2 = abVar.b();
        if (((!b && !b2) || (b && b2 && this.a.equals(abVar.a))) && this.b == abVar.b && this.c == abVar.c) {
            boolean g = g();
            boolean g2 = abVar.g();
            if ((g || g2) && !(g && g2 && this.d.equals(abVar.d))) {
                return false;
            }
            boolean i2 = i();
            boolean i3 = abVar.i();
            if ((i2 || i3) && !(i2 && i3 && this.e.equals(abVar.e))) {
                return false;
            }
            boolean k2 = k();
            boolean k3 = abVar.k();
            if ((k2 || k3) && !(k2 && k3 && this.f.equals(abVar.f))) {
                return false;
            }
            boolean l2 = l();
            boolean l3 = abVar.l();
            if ((l2 || l3) && !(l2 && l3 && this.g.a(abVar.g))) {
                return false;
            }
            boolean n2 = n();
            boolean n3 = abVar.n();
            return !(n2 || n3) || (n2 && n3 && this.h.a(abVar.h));
        }
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: b */
    public int compareTo(ab abVar) {
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        int a8;
        int a9;
        if (getClass().equals(abVar.getClass())) {
            int compareTo = Boolean.valueOf(b()).compareTo(Boolean.valueOf(abVar.b()));
            if (compareTo == 0) {
                if (!b() || (a9 = org.apache.thrift.b.a(this.a, abVar.a)) == 0) {
                    int compareTo2 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(abVar.d()));
                    if (compareTo2 == 0) {
                        if (!d() || (a8 = org.apache.thrift.b.a(this.b, abVar.b)) == 0) {
                            int compareTo3 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(abVar.e()));
                            if (compareTo3 == 0) {
                                if (!e() || (a7 = org.apache.thrift.b.a(this.c, abVar.c)) == 0) {
                                    int compareTo4 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(abVar.g()));
                                    if (compareTo4 == 0) {
                                        if (!g() || (a6 = org.apache.thrift.b.a(this.d, abVar.d)) == 0) {
                                            int compareTo5 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(abVar.i()));
                                            if (compareTo5 == 0) {
                                                if (!i() || (a5 = org.apache.thrift.b.a(this.e, abVar.e)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(abVar.k()));
                                                    if (compareTo6 == 0) {
                                                        if (!k() || (a4 = org.apache.thrift.b.a(this.f, abVar.f)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(abVar.l()));
                                                            if (compareTo7 == 0) {
                                                                if (!l() || (a3 = org.apache.thrift.b.a(this.g, abVar.g)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(abVar.n()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!n() || (a2 = org.apache.thrift.b.a(this.h, abVar.h)) == 0) {
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
        return getClass().getName().compareTo(abVar.getClass().getName());
    }

    public ab b(String str) {
        this.f = str;
        return this;
    }

    @Override // org.apache.thrift.a
    public void b(org.apache.thrift.protocol.e eVar) {
        o();
        eVar.a(j);
        if (this.a != null) {
            eVar.a(k);
            eVar.a(this.a.a());
            eVar.b();
        }
        eVar.a(l);
        eVar.a(this.b);
        eVar.b();
        eVar.a(m);
        eVar.a(this.c);
        eVar.b();
        if (this.d != null) {
            eVar.a(n);
            eVar.a(this.d);
            eVar.b();
        }
        if (this.e != null && i()) {
            eVar.a(o);
            eVar.a(this.e);
            eVar.b();
        }
        if (this.f != null && k()) {
            eVar.a(p);
            eVar.a(this.f);
            eVar.b();
        }
        if (this.g != null) {
            eVar.a(q);
            this.g.b(eVar);
            eVar.b();
        }
        if (this.h != null && n()) {
            eVar.a(r);
            this.h.b(eVar);
            eVar.b();
        }
        eVar.c();
        eVar.a();
    }

    public void b(boolean z) {
        this.s.set(0, z);
    }

    public boolean b() {
        return this.a != null;
    }

    public ab c(boolean z) {
        this.c = z;
        d(true);
        return this;
    }

    public boolean c() {
        return this.b;
    }

    public void d(boolean z) {
        this.s.set(1, z);
    }

    public boolean d() {
        return this.s.get(0);
    }

    public boolean e() {
        return this.s.get(1);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ab)) {
            return a((ab) obj);
        }
        return false;
    }

    public byte[] f() {
        a(org.apache.thrift.b.c(this.d));
        return this.d.array();
    }

    public boolean g() {
        return this.d != null;
    }

    public String h() {
        return this.e;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.e != null;
    }

    public String j() {
        return this.f;
    }

    public boolean k() {
        return this.f != null;
    }

    public boolean l() {
        return this.g != null;
    }

    public r m() {
        return this.h;
    }

    public boolean n() {
        return this.h != null;
    }

    public void o() {
        if (this.a == null) {
            throw new org.apache.thrift.protocol.f("Required field 'action' was not present! Struct: " + toString());
        }
        if (this.d == null) {
            throw new org.apache.thrift.protocol.f("Required field 'pushAction' was not present! Struct: " + toString());
        }
        if (this.g == null) {
            throw new org.apache.thrift.protocol.f("Required field 'target' was not present! Struct: " + toString());
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionContainer(");
        sb.append("action:");
        if (this.a == null) {
            sb.append("null");
        } else {
            sb.append(this.a);
        }
        sb.append(", ");
        sb.append("encryptAction:");
        sb.append(this.b);
        sb.append(", ");
        sb.append("isRequest:");
        sb.append(this.c);
        sb.append(", ");
        sb.append("pushAction:");
        if (this.d == null) {
            sb.append("null");
        } else {
            org.apache.thrift.b.a(this.d, sb);
        }
        if (i()) {
            sb.append(", ");
            sb.append("appid:");
            if (this.e == null) {
                sb.append("null");
            } else {
                sb.append(this.e);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f == null) {
                sb.append("null");
            } else {
                sb.append(this.f);
            }
        }
        sb.append(", ");
        sb.append("target:");
        if (this.g == null) {
            sb.append("null");
        } else {
            sb.append(this.g);
        }
        if (n()) {
            sb.append(", ");
            sb.append("metaInfo:");
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
