package com.xiaomi.xmpush.thrift;

import java.io.Serializable;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes3.dex */
public class r implements Serializable, Cloneable, org.apache.thrift.a<r, a> {
    public static final Map<a, org.apache.thrift.meta_data.b> m;
    private static final org.apache.thrift.protocol.j n = new org.apache.thrift.protocol.j("PushMetaInfo");
    private static final org.apache.thrift.protocol.b o = new org.apache.thrift.protocol.b("id", (byte) 11, 1);
    private static final org.apache.thrift.protocol.b p = new org.apache.thrift.protocol.b("messageTs", (byte) 10, 2);
    private static final org.apache.thrift.protocol.b q = new org.apache.thrift.protocol.b("topic", (byte) 11, 3);
    private static final org.apache.thrift.protocol.b r = new org.apache.thrift.protocol.b("title", (byte) 11, 4);
    private static final org.apache.thrift.protocol.b s = new org.apache.thrift.protocol.b("description", (byte) 11, 5);
    private static final org.apache.thrift.protocol.b t = new org.apache.thrift.protocol.b("notifyType", (byte) 8, 6);
    private static final org.apache.thrift.protocol.b u = new org.apache.thrift.protocol.b("url", (byte) 11, 7);
    private static final org.apache.thrift.protocol.b v = new org.apache.thrift.protocol.b("passThrough", (byte) 8, 8);
    private static final org.apache.thrift.protocol.b w = new org.apache.thrift.protocol.b("notifyId", (byte) 8, 9);
    private static final org.apache.thrift.protocol.b x = new org.apache.thrift.protocol.b("extra", (byte) 13, 10);
    private static final org.apache.thrift.protocol.b y = new org.apache.thrift.protocol.b("internal", (byte) 13, 11);
    private static final org.apache.thrift.protocol.b z = new org.apache.thrift.protocol.b("ignoreRegInfo", (byte) 2, 12);
    private BitSet A;
    public String a;
    public long b;
    public String c;
    public String d;
    public String e;
    public int f;
    public String g;
    public int h;
    public int i;
    public Map<String, String> j;
    public Map<String, String> k;
    public boolean l;

    /* loaded from: classes3.dex */
    public enum a {
        ID(1, "id"),
        MESSAGE_TS(2, "messageTs"),
        TOPIC(3, "topic"),
        TITLE(4, "title"),
        DESCRIPTION(5, "description"),
        NOTIFY_TYPE(6, "notifyType"),
        URL(7, "url"),
        PASS_THROUGH(8, "passThrough"),
        NOTIFY_ID(9, "notifyId"),
        EXTRA(10, "extra"),
        INTERNAL(11, "internal"),
        IGNORE_REG_INFO(12, "ignoreRegInfo");
        
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
        enumMap.put((EnumMap) a.ID, (a) new org.apache.thrift.meta_data.b("id", (byte) 1, new org.apache.thrift.meta_data.c((byte) 11)));
        enumMap.put((EnumMap) a.MESSAGE_TS, (a) new org.apache.thrift.meta_data.b("messageTs", (byte) 1, new org.apache.thrift.meta_data.c((byte) 10)));
        enumMap.put((EnumMap) a.TOPIC, (a) new org.apache.thrift.meta_data.b("topic", (byte) 2, new org.apache.thrift.meta_data.c((byte) 11)));
        enumMap.put((EnumMap) a.TITLE, (a) new org.apache.thrift.meta_data.b("title", (byte) 2, new org.apache.thrift.meta_data.c((byte) 11)));
        enumMap.put((EnumMap) a.DESCRIPTION, (a) new org.apache.thrift.meta_data.b("description", (byte) 2, new org.apache.thrift.meta_data.c((byte) 11)));
        enumMap.put((EnumMap) a.NOTIFY_TYPE, (a) new org.apache.thrift.meta_data.b("notifyType", (byte) 2, new org.apache.thrift.meta_data.c((byte) 8)));
        enumMap.put((EnumMap) a.URL, (a) new org.apache.thrift.meta_data.b("url", (byte) 2, new org.apache.thrift.meta_data.c((byte) 11)));
        enumMap.put((EnumMap) a.PASS_THROUGH, (a) new org.apache.thrift.meta_data.b("passThrough", (byte) 2, new org.apache.thrift.meta_data.c((byte) 8)));
        enumMap.put((EnumMap) a.NOTIFY_ID, (a) new org.apache.thrift.meta_data.b("notifyId", (byte) 2, new org.apache.thrift.meta_data.c((byte) 8)));
        enumMap.put((EnumMap) a.EXTRA, (a) new org.apache.thrift.meta_data.b("extra", (byte) 2, new org.apache.thrift.meta_data.e((byte) 13, new org.apache.thrift.meta_data.c((byte) 11), new org.apache.thrift.meta_data.c((byte) 11))));
        enumMap.put((EnumMap) a.INTERNAL, (a) new org.apache.thrift.meta_data.b("internal", (byte) 2, new org.apache.thrift.meta_data.e((byte) 13, new org.apache.thrift.meta_data.c((byte) 11), new org.apache.thrift.meta_data.c((byte) 11))));
        enumMap.put((EnumMap) a.IGNORE_REG_INFO, (a) new org.apache.thrift.meta_data.b("ignoreRegInfo", (byte) 2, new org.apache.thrift.meta_data.c((byte) 2)));
        m = Collections.unmodifiableMap(enumMap);
        org.apache.thrift.meta_data.b.a(r.class, m);
    }

    public r() {
        this.A = new BitSet(5);
        this.l = false;
    }

    public r(r rVar) {
        this.A = new BitSet(5);
        this.A.clear();
        this.A.or(rVar.A);
        if (rVar.c()) {
            this.a = rVar.a;
        }
        this.b = rVar.b;
        if (rVar.g()) {
            this.c = rVar.c;
        }
        if (rVar.i()) {
            this.d = rVar.d;
        }
        if (rVar.k()) {
            this.e = rVar.e;
        }
        this.f = rVar.f;
        if (rVar.n()) {
            this.g = rVar.g;
        }
        this.h = rVar.h;
        this.i = rVar.i;
        if (rVar.t()) {
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, String> entry : rVar.j.entrySet()) {
                hashMap.put(entry.getKey(), entry.getValue());
            }
            this.j = hashMap;
        }
        if (rVar.u()) {
            HashMap hashMap2 = new HashMap();
            for (Map.Entry<String, String> entry2 : rVar.k.entrySet()) {
                hashMap2.put(entry2.getKey(), entry2.getValue());
            }
            this.k = hashMap2;
        }
        this.l = rVar.l;
    }

    public r a() {
        return new r(this);
    }

    public r a(int i) {
        this.f = i;
        b(true);
        return this;
    }

    public r a(String str) {
        this.a = str;
        return this;
    }

    public r a(Map<String, String> map) {
        this.j = map;
        return this;
    }

    public void a(String str, String str2) {
        if (this.j == null) {
            this.j = new HashMap();
        }
        this.j.put(str, str2);
    }

    @Override // org.apache.thrift.a
    public void a(org.apache.thrift.protocol.e eVar) {
        eVar.g();
        while (true) {
            org.apache.thrift.protocol.b i = eVar.i();
            if (i.b == 0) {
                eVar.h();
                if (!e()) {
                    throw new org.apache.thrift.protocol.f("Required field 'messageTs' was not found in serialized data! Struct: " + toString());
                }
                x();
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
                    if (i.b == 10) {
                        this.b = eVar.u();
                        a(true);
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
                    if (i.b == 8) {
                        this.f = eVar.t();
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
                    if (i.b == 8) {
                        this.h = eVar.t();
                        c(true);
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    }
                case 9:
                    if (i.b == 8) {
                        this.i = eVar.t();
                        d(true);
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
                    if (i.b == 13) {
                        org.apache.thrift.protocol.d k2 = eVar.k();
                        this.k = new HashMap(k2.c * 2);
                        for (int i3 = 0; i3 < k2.c; i3++) {
                            this.k.put(eVar.w(), eVar.w());
                        }
                        eVar.l();
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    }
                case 12:
                    if (i.b == 2) {
                        this.l = eVar.q();
                        e(true);
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

    public boolean a(r rVar) {
        if (rVar == null) {
            return false;
        }
        boolean c = c();
        boolean c2 = rVar.c();
        if (((c || c2) && !(c && c2 && this.a.equals(rVar.a))) || this.b != rVar.b) {
            return false;
        }
        boolean g = g();
        boolean g2 = rVar.g();
        if ((g || g2) && !(g && g2 && this.c.equals(rVar.c))) {
            return false;
        }
        boolean i = i();
        boolean i2 = rVar.i();
        if ((i || i2) && !(i && i2 && this.d.equals(rVar.d))) {
            return false;
        }
        boolean k = k();
        boolean k2 = rVar.k();
        if ((k || k2) && !(k && k2 && this.e.equals(rVar.e))) {
            return false;
        }
        boolean m2 = m();
        boolean m3 = rVar.m();
        if ((m2 || m3) && !(m2 && m3 && this.f == rVar.f)) {
            return false;
        }
        boolean n2 = n();
        boolean n3 = rVar.n();
        if ((n2 || n3) && !(n2 && n3 && this.g.equals(rVar.g))) {
            return false;
        }
        boolean p2 = p();
        boolean p3 = rVar.p();
        if ((p2 || p3) && !(p2 && p3 && this.h == rVar.h)) {
            return false;
        }
        boolean r2 = r();
        boolean r3 = rVar.r();
        if ((r2 || r3) && !(r2 && r3 && this.i == rVar.i)) {
            return false;
        }
        boolean t2 = t();
        boolean t3 = rVar.t();
        if ((t2 || t3) && !(t2 && t3 && this.j.equals(rVar.j))) {
            return false;
        }
        boolean u2 = u();
        boolean u3 = rVar.u();
        if ((u2 || u3) && !(u2 && u3 && this.k.equals(rVar.k))) {
            return false;
        }
        boolean w2 = w();
        boolean w3 = rVar.w();
        return !(w2 || w3) || (w2 && w3 && this.l == rVar.l);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: b */
    public int compareTo(r rVar) {
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
        if (getClass().equals(rVar.getClass())) {
            int compareTo = Boolean.valueOf(c()).compareTo(Boolean.valueOf(rVar.c()));
            if (compareTo == 0) {
                if (!c() || (a13 = org.apache.thrift.b.a(this.a, rVar.a)) == 0) {
                    int compareTo2 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(rVar.e()));
                    if (compareTo2 == 0) {
                        if (!e() || (a12 = org.apache.thrift.b.a(this.b, rVar.b)) == 0) {
                            int compareTo3 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(rVar.g()));
                            if (compareTo3 == 0) {
                                if (!g() || (a11 = org.apache.thrift.b.a(this.c, rVar.c)) == 0) {
                                    int compareTo4 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(rVar.i()));
                                    if (compareTo4 == 0) {
                                        if (!i() || (a10 = org.apache.thrift.b.a(this.d, rVar.d)) == 0) {
                                            int compareTo5 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(rVar.k()));
                                            if (compareTo5 == 0) {
                                                if (!k() || (a9 = org.apache.thrift.b.a(this.e, rVar.e)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(rVar.m()));
                                                    if (compareTo6 == 0) {
                                                        if (!m() || (a8 = org.apache.thrift.b.a(this.f, rVar.f)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(rVar.n()));
                                                            if (compareTo7 == 0) {
                                                                if (!n() || (a7 = org.apache.thrift.b.a(this.g, rVar.g)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(p()).compareTo(Boolean.valueOf(rVar.p()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!p() || (a6 = org.apache.thrift.b.a(this.h, rVar.h)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(r()).compareTo(Boolean.valueOf(rVar.r()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!r() || (a5 = org.apache.thrift.b.a(this.i, rVar.i)) == 0) {
                                                                                    int compareTo10 = Boolean.valueOf(t()).compareTo(Boolean.valueOf(rVar.t()));
                                                                                    if (compareTo10 == 0) {
                                                                                        if (!t() || (a4 = org.apache.thrift.b.a(this.j, rVar.j)) == 0) {
                                                                                            int compareTo11 = Boolean.valueOf(u()).compareTo(Boolean.valueOf(rVar.u()));
                                                                                            if (compareTo11 == 0) {
                                                                                                if (!u() || (a3 = org.apache.thrift.b.a(this.k, rVar.k)) == 0) {
                                                                                                    int compareTo12 = Boolean.valueOf(w()).compareTo(Boolean.valueOf(rVar.w()));
                                                                                                    if (compareTo12 == 0) {
                                                                                                        if (!w() || (a2 = org.apache.thrift.b.a(this.l, rVar.l)) == 0) {
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
        return getClass().getName().compareTo(rVar.getClass().getName());
    }

    public r b(int i) {
        this.h = i;
        c(true);
        return this;
    }

    public r b(String str) {
        this.c = str;
        return this;
    }

    public String b() {
        return this.a;
    }

    @Override // org.apache.thrift.a
    public void b(org.apache.thrift.protocol.e eVar) {
        x();
        eVar.a(n);
        if (this.a != null) {
            eVar.a(o);
            eVar.a(this.a);
            eVar.b();
        }
        eVar.a(p);
        eVar.a(this.b);
        eVar.b();
        if (this.c != null && g()) {
            eVar.a(q);
            eVar.a(this.c);
            eVar.b();
        }
        if (this.d != null && i()) {
            eVar.a(r);
            eVar.a(this.d);
            eVar.b();
        }
        if (this.e != null && k()) {
            eVar.a(s);
            eVar.a(this.e);
            eVar.b();
        }
        if (m()) {
            eVar.a(t);
            eVar.a(this.f);
            eVar.b();
        }
        if (this.g != null && n()) {
            eVar.a(u);
            eVar.a(this.g);
            eVar.b();
        }
        if (p()) {
            eVar.a(v);
            eVar.a(this.h);
            eVar.b();
        }
        if (r()) {
            eVar.a(w);
            eVar.a(this.i);
            eVar.b();
        }
        if (this.j != null && t()) {
            eVar.a(x);
            eVar.a(new org.apache.thrift.protocol.d((byte) 11, (byte) 11, this.j.size()));
            for (Map.Entry<String, String> entry : this.j.entrySet()) {
                eVar.a(entry.getKey());
                eVar.a(entry.getValue());
            }
            eVar.d();
            eVar.b();
        }
        if (this.k != null && u()) {
            eVar.a(y);
            eVar.a(new org.apache.thrift.protocol.d((byte) 11, (byte) 11, this.k.size()));
            for (Map.Entry<String, String> entry2 : this.k.entrySet()) {
                eVar.a(entry2.getKey());
                eVar.a(entry2.getValue());
            }
            eVar.d();
            eVar.b();
        }
        if (w()) {
            eVar.a(z);
            eVar.a(this.l);
            eVar.b();
        }
        eVar.c();
        eVar.a();
    }

    public void b(boolean z2) {
        this.A.set(1, z2);
    }

    public r c(int i) {
        this.i = i;
        d(true);
        return this;
    }

    public r c(String str) {
        this.d = str;
        return this;
    }

    public void c(boolean z2) {
        this.A.set(2, z2);
    }

    public boolean c() {
        return this.a != null;
    }

    public long d() {
        return this.b;
    }

    public r d(String str) {
        this.e = str;
        return this;
    }

    public void d(boolean z2) {
        this.A.set(3, z2);
    }

    public void e(boolean z2) {
        this.A.set(4, z2);
    }

    public boolean e() {
        return this.A.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof r)) {
            return a((r) obj);
        }
        return false;
    }

    public String f() {
        return this.c;
    }

    public boolean g() {
        return this.c != null;
    }

    public String h() {
        return this.d;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.d != null;
    }

    public String j() {
        return this.e;
    }

    public boolean k() {
        return this.e != null;
    }

    public int l() {
        return this.f;
    }

    public boolean m() {
        return this.A.get(1);
    }

    public boolean n() {
        return this.g != null;
    }

    public int o() {
        return this.h;
    }

    public boolean p() {
        return this.A.get(2);
    }

    public int q() {
        return this.i;
    }

    public boolean r() {
        return this.A.get(3);
    }

    public Map<String, String> s() {
        return this.j;
    }

    public boolean t() {
        return this.j != null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("PushMetaInfo(");
        sb.append("id:");
        if (this.a == null) {
            sb.append("null");
        } else {
            sb.append(this.a);
        }
        sb.append(", ");
        sb.append("messageTs:");
        sb.append(this.b);
        if (g()) {
            sb.append(", ");
            sb.append("topic:");
            if (this.c == null) {
                sb.append("null");
            } else {
                sb.append(this.c);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("title:");
            if (this.d == null) {
                sb.append("null");
            } else {
                sb.append(this.d);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("description:");
            if (this.e == null) {
                sb.append("null");
            } else {
                sb.append(this.e);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("notifyType:");
            sb.append(this.f);
        }
        if (n()) {
            sb.append(", ");
            sb.append("url:");
            if (this.g == null) {
                sb.append("null");
            } else {
                sb.append(this.g);
            }
        }
        if (p()) {
            sb.append(", ");
            sb.append("passThrough:");
            sb.append(this.h);
        }
        if (r()) {
            sb.append(", ");
            sb.append("notifyId:");
            sb.append(this.i);
        }
        if (t()) {
            sb.append(", ");
            sb.append("extra:");
            if (this.j == null) {
                sb.append("null");
            } else {
                sb.append(this.j);
            }
        }
        if (u()) {
            sb.append(", ");
            sb.append("internal:");
            if (this.k == null) {
                sb.append("null");
            } else {
                sb.append(this.k);
            }
        }
        if (w()) {
            sb.append(", ");
            sb.append("ignoreRegInfo:");
            sb.append(this.l);
        }
        sb.append(")");
        return sb.toString();
    }

    public boolean u() {
        return this.k != null;
    }

    public boolean v() {
        return this.l;
    }

    public boolean w() {
        return this.A.get(4);
    }

    public void x() {
        if (this.a == null) {
            throw new org.apache.thrift.protocol.f("Required field 'id' was not present! Struct: " + toString());
        }
    }
}
