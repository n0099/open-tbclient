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
public class ae implements Serializable, Cloneable, org.apache.thrift.a<ae, a> {
    public static final Map<a, org.apache.thrift.meta_data.b> l;
    private static final org.apache.thrift.protocol.j m = new org.apache.thrift.protocol.j("XmPushActionNotification");
    private static final org.apache.thrift.protocol.b n = new org.apache.thrift.protocol.b("debug", (byte) 11, 1);
    private static final org.apache.thrift.protocol.b o = new org.apache.thrift.protocol.b("target", (byte) 12, 2);
    private static final org.apache.thrift.protocol.b p = new org.apache.thrift.protocol.b("id", (byte) 11, 3);
    private static final org.apache.thrift.protocol.b q = new org.apache.thrift.protocol.b("appId", (byte) 11, 4);
    private static final org.apache.thrift.protocol.b r = new org.apache.thrift.protocol.b("type", (byte) 11, 5);
    private static final org.apache.thrift.protocol.b s = new org.apache.thrift.protocol.b("requireAck", (byte) 2, 6);
    private static final org.apache.thrift.protocol.b t = new org.apache.thrift.protocol.b("payload", (byte) 11, 7);
    private static final org.apache.thrift.protocol.b u = new org.apache.thrift.protocol.b("extra", (byte) 13, 8);
    private static final org.apache.thrift.protocol.b v = new org.apache.thrift.protocol.b("packageName", (byte) 11, 9);
    private static final org.apache.thrift.protocol.b w = new org.apache.thrift.protocol.b("category", (byte) 11, 10);
    private static final org.apache.thrift.protocol.b x = new org.apache.thrift.protocol.b("binaryExtra", (byte) 11, 14);
    public String a;
    public u b;
    public String c;
    public String d;
    public String e;
    public boolean f;
    public String g;
    public Map<String, String> h;
    public String i;
    public String j;
    public ByteBuffer k;
    private BitSet y;

    /* loaded from: classes3.dex */
    public enum a {
        DEBUG(1, "debug"),
        TARGET(2, "target"),
        ID(3, "id"),
        APP_ID(4, "appId"),
        TYPE(5, "type"),
        REQUIRE_ACK(6, "requireAck"),
        PAYLOAD(7, "payload"),
        EXTRA(8, "extra"),
        PACKAGE_NAME(9, "packageName"),
        CATEGORY(10, "category"),
        BINARY_EXTRA(14, "binaryExtra");
        
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
        enumMap.put((EnumMap) a.APP_ID, (a) new org.apache.thrift.meta_data.b("appId", (byte) 2, new org.apache.thrift.meta_data.c((byte) 11)));
        enumMap.put((EnumMap) a.TYPE, (a) new org.apache.thrift.meta_data.b("type", (byte) 2, new org.apache.thrift.meta_data.c((byte) 11)));
        enumMap.put((EnumMap) a.REQUIRE_ACK, (a) new org.apache.thrift.meta_data.b("requireAck", (byte) 1, new org.apache.thrift.meta_data.c((byte) 2)));
        enumMap.put((EnumMap) a.PAYLOAD, (a) new org.apache.thrift.meta_data.b("payload", (byte) 2, new org.apache.thrift.meta_data.c((byte) 11)));
        enumMap.put((EnumMap) a.EXTRA, (a) new org.apache.thrift.meta_data.b("extra", (byte) 2, new org.apache.thrift.meta_data.e((byte) 13, new org.apache.thrift.meta_data.c((byte) 11), new org.apache.thrift.meta_data.c((byte) 11))));
        enumMap.put((EnumMap) a.PACKAGE_NAME, (a) new org.apache.thrift.meta_data.b("packageName", (byte) 2, new org.apache.thrift.meta_data.c((byte) 11)));
        enumMap.put((EnumMap) a.CATEGORY, (a) new org.apache.thrift.meta_data.b("category", (byte) 2, new org.apache.thrift.meta_data.c((byte) 11)));
        enumMap.put((EnumMap) a.BINARY_EXTRA, (a) new org.apache.thrift.meta_data.b("binaryExtra", (byte) 2, new org.apache.thrift.meta_data.c((byte) 11)));
        l = Collections.unmodifiableMap(enumMap);
        org.apache.thrift.meta_data.b.a(ae.class, l);
    }

    public ae() {
        this.y = new BitSet(1);
        this.f = true;
    }

    public ae(String str, boolean z) {
        this();
        this.c = str;
        this.f = z;
        b(true);
    }

    public ae a(String str) {
        this.c = str;
        return this;
    }

    public ae a(ByteBuffer byteBuffer) {
        this.k = byteBuffer;
        return this;
    }

    public ae a(Map<String, String> map) {
        this.h = map;
        return this;
    }

    public ae a(boolean z) {
        this.f = z;
        b(true);
        return this;
    }

    public ae a(byte[] bArr) {
        a(ByteBuffer.wrap(bArr));
        return this;
    }

    public void a(String str, String str2) {
        if (this.h == null) {
            this.h = new HashMap();
        }
        this.h.put(str, str2);
    }

    @Override // org.apache.thrift.a
    public void a(org.apache.thrift.protocol.e eVar) {
        eVar.g();
        while (true) {
            org.apache.thrift.protocol.b i = eVar.i();
            if (i.b == 0) {
                eVar.h();
                if (!g()) {
                    throw new org.apache.thrift.protocol.f("Required field 'requireAck' was not found in serialized data! Struct: " + toString());
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
                    if (i.b == 2) {
                        this.f = eVar.q();
                        b(true);
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
                    if (i.b == 13) {
                        org.apache.thrift.protocol.d k = eVar.k();
                        this.h = new HashMap(k.c * 2);
                        for (int i2 = 0; i2 < k.c; i2++) {
                            this.h.put(eVar.w(), eVar.w());
                        }
                        eVar.l();
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
                    if (i.b == 11) {
                        this.j = eVar.w();
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    }
                case 11:
                case 12:
                case 13:
                default:
                    org.apache.thrift.protocol.h.a(eVar, i.b);
                    break;
                case 14:
                    if (i.b == 11) {
                        this.k = eVar.x();
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    }
            }
            eVar.j();
        }
    }

    public boolean a() {
        return this.a != null;
    }

    public boolean a(ae aeVar) {
        if (aeVar == null) {
            return false;
        }
        boolean a2 = a();
        boolean a3 = aeVar.a();
        if ((a2 || a3) && !(a2 && a3 && this.a.equals(aeVar.a))) {
            return false;
        }
        boolean b = b();
        boolean b2 = aeVar.b();
        if ((b || b2) && !(b && b2 && this.b.a(aeVar.b))) {
            return false;
        }
        boolean d = d();
        boolean d2 = aeVar.d();
        if ((d || d2) && !(d && d2 && this.c.equals(aeVar.c))) {
            return false;
        }
        boolean e = e();
        boolean e2 = aeVar.e();
        if ((e || e2) && !(e && e2 && this.d.equals(aeVar.d))) {
            return false;
        }
        boolean f = f();
        boolean f2 = aeVar.f();
        if (((f || f2) && !(f && f2 && this.e.equals(aeVar.e))) || this.f != aeVar.f) {
            return false;
        }
        boolean h = h();
        boolean h2 = aeVar.h();
        if ((h || h2) && !(h && h2 && this.g.equals(aeVar.g))) {
            return false;
        }
        boolean j = j();
        boolean j2 = aeVar.j();
        if ((j || j2) && !(j && j2 && this.h.equals(aeVar.h))) {
            return false;
        }
        boolean k = k();
        boolean k2 = aeVar.k();
        if ((k || k2) && !(k && k2 && this.i.equals(aeVar.i))) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = aeVar.l();
        if ((l2 || l3) && !(l2 && l3 && this.j.equals(aeVar.j))) {
            return false;
        }
        boolean n2 = n();
        boolean n3 = aeVar.n();
        return !(n2 || n3) || (n2 && n3 && this.k.equals(aeVar.k));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: b */
    public int compareTo(ae aeVar) {
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
        if (getClass().equals(aeVar.getClass())) {
            int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(aeVar.a()));
            if (compareTo == 0) {
                if (!a() || (a12 = org.apache.thrift.b.a(this.a, aeVar.a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(aeVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a11 = org.apache.thrift.b.a(this.b, aeVar.b)) == 0) {
                            int compareTo3 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(aeVar.d()));
                            if (compareTo3 == 0) {
                                if (!d() || (a10 = org.apache.thrift.b.a(this.c, aeVar.c)) == 0) {
                                    int compareTo4 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(aeVar.e()));
                                    if (compareTo4 == 0) {
                                        if (!e() || (a9 = org.apache.thrift.b.a(this.d, aeVar.d)) == 0) {
                                            int compareTo5 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(aeVar.f()));
                                            if (compareTo5 == 0) {
                                                if (!f() || (a8 = org.apache.thrift.b.a(this.e, aeVar.e)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(aeVar.g()));
                                                    if (compareTo6 == 0) {
                                                        if (!g() || (a7 = org.apache.thrift.b.a(this.f, aeVar.f)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(aeVar.h()));
                                                            if (compareTo7 == 0) {
                                                                if (!h() || (a6 = org.apache.thrift.b.a(this.g, aeVar.g)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(aeVar.j()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!j() || (a5 = org.apache.thrift.b.a(this.h, aeVar.h)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(aeVar.k()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!k() || (a4 = org.apache.thrift.b.a(this.i, aeVar.i)) == 0) {
                                                                                    int compareTo10 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(aeVar.l()));
                                                                                    if (compareTo10 == 0) {
                                                                                        if (!l() || (a3 = org.apache.thrift.b.a(this.j, aeVar.j)) == 0) {
                                                                                            int compareTo11 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(aeVar.n()));
                                                                                            if (compareTo11 == 0) {
                                                                                                if (!n() || (a2 = org.apache.thrift.b.a(this.k, aeVar.k)) == 0) {
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
        return getClass().getName().compareTo(aeVar.getClass().getName());
    }

    public ae b(String str) {
        this.d = str;
        return this;
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
        if (this.d != null && e()) {
            eVar.a(q);
            eVar.a(this.d);
            eVar.b();
        }
        if (this.e != null && f()) {
            eVar.a(r);
            eVar.a(this.e);
            eVar.b();
        }
        eVar.a(s);
        eVar.a(this.f);
        eVar.b();
        if (this.g != null && h()) {
            eVar.a(t);
            eVar.a(this.g);
            eVar.b();
        }
        if (this.h != null && j()) {
            eVar.a(u);
            eVar.a(new org.apache.thrift.protocol.d((byte) 11, (byte) 11, this.h.size()));
            for (Map.Entry<String, String> entry : this.h.entrySet()) {
                eVar.a(entry.getKey());
                eVar.a(entry.getValue());
            }
            eVar.d();
            eVar.b();
        }
        if (this.i != null && k()) {
            eVar.a(v);
            eVar.a(this.i);
            eVar.b();
        }
        if (this.j != null && l()) {
            eVar.a(w);
            eVar.a(this.j);
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

    public void b(boolean z) {
        this.y.set(0, z);
    }

    public boolean b() {
        return this.b != null;
    }

    public ae c(String str) {
        this.e = str;
        return this;
    }

    public String c() {
        return this.c;
    }

    public ae d(String str) {
        this.i = str;
        return this;
    }

    public boolean d() {
        return this.c != null;
    }

    public boolean e() {
        return this.d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ae)) {
            return a((ae) obj);
        }
        return false;
    }

    public boolean f() {
        return this.e != null;
    }

    public boolean g() {
        return this.y.get(0);
    }

    public boolean h() {
        return this.g != null;
    }

    public int hashCode() {
        return 0;
    }

    public Map<String, String> i() {
        return this.h;
    }

    public boolean j() {
        return this.h != null;
    }

    public boolean k() {
        return this.i != null;
    }

    public boolean l() {
        return this.j != null;
    }

    public byte[] m() {
        a(org.apache.thrift.b.c(this.k));
        return this.k.array();
    }

    public boolean n() {
        return this.k != null;
    }

    public void o() {
        if (this.c == null) {
            throw new org.apache.thrift.protocol.f("Required field 'id' was not present! Struct: " + toString());
        }
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionNotification(");
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
        if (e()) {
            sb.append(", ");
            sb.append("appId:");
            if (this.d == null) {
                sb.append("null");
            } else {
                sb.append(this.d);
            }
        }
        if (f()) {
            sb.append(", ");
            sb.append("type:");
            if (this.e == null) {
                sb.append("null");
            } else {
                sb.append(this.e);
            }
        }
        sb.append(", ");
        sb.append("requireAck:");
        sb.append(this.f);
        if (h()) {
            sb.append(", ");
            sb.append("payload:");
            if (this.g == null) {
                sb.append("null");
            } else {
                sb.append(this.g);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("extra:");
            if (this.h == null) {
                sb.append("null");
            } else {
                sb.append(this.h);
            }
        }
        if (k()) {
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
        if (n()) {
            sb.append(", ");
            sb.append("binaryExtra:");
            if (this.k == null) {
                sb.append("null");
            } else {
                org.apache.thrift.b.a(this.k, sb);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
