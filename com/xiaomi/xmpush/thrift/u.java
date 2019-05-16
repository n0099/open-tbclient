package com.xiaomi.xmpush.thrift;

import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
import org.apache.thrift.TFieldIdEnum;
/* loaded from: classes3.dex */
public class u implements Serializable, Cloneable, org.apache.thrift.a<u, TFieldIdEnum> {
    private BitSet B;
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
    public Map<String, String> m;
    private static final org.apache.thrift.protocol.j n = new org.apache.thrift.protocol.j("PushMetaInfo");
    private static final org.apache.thrift.protocol.b o = new org.apache.thrift.protocol.b("", (byte) 11, 1);
    private static final org.apache.thrift.protocol.b p = new org.apache.thrift.protocol.b("", (byte) 10, 2);
    private static final org.apache.thrift.protocol.b q = new org.apache.thrift.protocol.b("", (byte) 11, 3);
    private static final org.apache.thrift.protocol.b r = new org.apache.thrift.protocol.b("", (byte) 11, 4);
    private static final org.apache.thrift.protocol.b s = new org.apache.thrift.protocol.b("", (byte) 11, 5);
    private static final org.apache.thrift.protocol.b t = new org.apache.thrift.protocol.b("", (byte) 8, 6);
    private static final org.apache.thrift.protocol.b u = new org.apache.thrift.protocol.b("", (byte) 11, 7);
    private static final org.apache.thrift.protocol.b v = new org.apache.thrift.protocol.b("", (byte) 8, 8);
    private static final org.apache.thrift.protocol.b w = new org.apache.thrift.protocol.b("", (byte) 8, 9);
    private static final org.apache.thrift.protocol.b x = new org.apache.thrift.protocol.b("", (byte) 13, 10);
    private static final org.apache.thrift.protocol.b y = new org.apache.thrift.protocol.b("", (byte) 13, 11);
    private static final org.apache.thrift.protocol.b z = new org.apache.thrift.protocol.b("", (byte) 2, 12);
    private static final org.apache.thrift.protocol.b A = new org.apache.thrift.protocol.b("", (byte) 13, 13);

    public u() {
        this.B = new BitSet(5);
        this.l = false;
    }

    public u(u uVar) {
        this.B = new BitSet(5);
        this.B.clear();
        this.B.or(uVar.B);
        if (uVar.c()) {
            this.a = uVar.a;
        }
        this.b = uVar.b;
        if (uVar.g()) {
            this.c = uVar.c;
        }
        if (uVar.i()) {
            this.d = uVar.d;
        }
        if (uVar.k()) {
            this.e = uVar.e;
        }
        this.f = uVar.f;
        if (uVar.n()) {
            this.g = uVar.g;
        }
        this.h = uVar.h;
        this.i = uVar.i;
        if (uVar.t()) {
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, String> entry : uVar.j.entrySet()) {
                hashMap.put(entry.getKey(), entry.getValue());
            }
            this.j = hashMap;
        }
        if (uVar.v()) {
            HashMap hashMap2 = new HashMap();
            for (Map.Entry<String, String> entry2 : uVar.k.entrySet()) {
                hashMap2.put(entry2.getKey(), entry2.getValue());
            }
            this.k = hashMap2;
        }
        this.l = uVar.l;
        if (uVar.y()) {
            HashMap hashMap3 = new HashMap();
            for (Map.Entry<String, String> entry3 : uVar.m.entrySet()) {
                hashMap3.put(entry3.getKey(), entry3.getValue());
            }
            this.m = hashMap3;
        }
    }

    public u a() {
        return new u(this);
    }

    public u a(int i) {
        this.f = i;
        b(true);
        return this;
    }

    public u a(String str) {
        this.a = str;
        return this;
    }

    public u a(Map<String, String> map) {
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
                z();
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
                case 13:
                    if (i.b == 13) {
                        org.apache.thrift.protocol.d k3 = eVar.k();
                        this.m = new HashMap(k3.c * 2);
                        for (int i4 = 0; i4 < k3.c; i4++) {
                            this.m.put(eVar.w(), eVar.w());
                        }
                        eVar.l();
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
        this.B.set(0, z2);
    }

    public boolean a(u uVar) {
        if (uVar == null) {
            return false;
        }
        boolean c = c();
        boolean c2 = uVar.c();
        if (((c || c2) && !(c && c2 && this.a.equals(uVar.a))) || this.b != uVar.b) {
            return false;
        }
        boolean g = g();
        boolean g2 = uVar.g();
        if ((g || g2) && !(g && g2 && this.c.equals(uVar.c))) {
            return false;
        }
        boolean i = i();
        boolean i2 = uVar.i();
        if ((i || i2) && !(i && i2 && this.d.equals(uVar.d))) {
            return false;
        }
        boolean k = k();
        boolean k2 = uVar.k();
        if ((k || k2) && !(k && k2 && this.e.equals(uVar.e))) {
            return false;
        }
        boolean m = m();
        boolean m2 = uVar.m();
        if ((m || m2) && !(m && m2 && this.f == uVar.f)) {
            return false;
        }
        boolean n2 = n();
        boolean n3 = uVar.n();
        if ((n2 || n3) && !(n2 && n3 && this.g.equals(uVar.g))) {
            return false;
        }
        boolean p2 = p();
        boolean p3 = uVar.p();
        if ((p2 || p3) && !(p2 && p3 && this.h == uVar.h)) {
            return false;
        }
        boolean r2 = r();
        boolean r3 = uVar.r();
        if ((r2 || r3) && !(r2 && r3 && this.i == uVar.i)) {
            return false;
        }
        boolean t2 = t();
        boolean t3 = uVar.t();
        if ((t2 || t3) && !(t2 && t3 && this.j.equals(uVar.j))) {
            return false;
        }
        boolean v2 = v();
        boolean v3 = uVar.v();
        if ((v2 || v3) && !(v2 && v3 && this.k.equals(uVar.k))) {
            return false;
        }
        boolean x2 = x();
        boolean x3 = uVar.x();
        if ((x2 || x3) && !(x2 && x3 && this.l == uVar.l)) {
            return false;
        }
        boolean y2 = y();
        boolean y3 = uVar.y();
        return !(y2 || y3) || (y2 && y3 && this.m.equals(uVar.m));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: b */
    public int compareTo(u uVar) {
        int a;
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
        if (getClass().equals(uVar.getClass())) {
            int compareTo = Boolean.valueOf(c()).compareTo(Boolean.valueOf(uVar.c()));
            if (compareTo == 0) {
                if (!c() || (a13 = org.apache.thrift.b.a(this.a, uVar.a)) == 0) {
                    int compareTo2 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(uVar.e()));
                    if (compareTo2 == 0) {
                        if (!e() || (a12 = org.apache.thrift.b.a(this.b, uVar.b)) == 0) {
                            int compareTo3 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(uVar.g()));
                            if (compareTo3 == 0) {
                                if (!g() || (a11 = org.apache.thrift.b.a(this.c, uVar.c)) == 0) {
                                    int compareTo4 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(uVar.i()));
                                    if (compareTo4 == 0) {
                                        if (!i() || (a10 = org.apache.thrift.b.a(this.d, uVar.d)) == 0) {
                                            int compareTo5 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(uVar.k()));
                                            if (compareTo5 == 0) {
                                                if (!k() || (a9 = org.apache.thrift.b.a(this.e, uVar.e)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(uVar.m()));
                                                    if (compareTo6 == 0) {
                                                        if (!m() || (a8 = org.apache.thrift.b.a(this.f, uVar.f)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(uVar.n()));
                                                            if (compareTo7 == 0) {
                                                                if (!n() || (a7 = org.apache.thrift.b.a(this.g, uVar.g)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(p()).compareTo(Boolean.valueOf(uVar.p()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!p() || (a6 = org.apache.thrift.b.a(this.h, uVar.h)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(r()).compareTo(Boolean.valueOf(uVar.r()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!r() || (a5 = org.apache.thrift.b.a(this.i, uVar.i)) == 0) {
                                                                                    int compareTo10 = Boolean.valueOf(t()).compareTo(Boolean.valueOf(uVar.t()));
                                                                                    if (compareTo10 == 0) {
                                                                                        if (!t() || (a4 = org.apache.thrift.b.a(this.j, uVar.j)) == 0) {
                                                                                            int compareTo11 = Boolean.valueOf(v()).compareTo(Boolean.valueOf(uVar.v()));
                                                                                            if (compareTo11 == 0) {
                                                                                                if (!v() || (a3 = org.apache.thrift.b.a(this.k, uVar.k)) == 0) {
                                                                                                    int compareTo12 = Boolean.valueOf(x()).compareTo(Boolean.valueOf(uVar.x()));
                                                                                                    if (compareTo12 == 0) {
                                                                                                        if (!x() || (a2 = org.apache.thrift.b.a(this.l, uVar.l)) == 0) {
                                                                                                            int compareTo13 = Boolean.valueOf(y()).compareTo(Boolean.valueOf(uVar.y()));
                                                                                                            if (compareTo13 == 0) {
                                                                                                                if (!y() || (a = org.apache.thrift.b.a(this.m, uVar.m)) == 0) {
                                                                                                                    return 0;
                                                                                                                }
                                                                                                                return a;
                                                                                                            }
                                                                                                            return compareTo13;
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
        return getClass().getName().compareTo(uVar.getClass().getName());
    }

    public u b(int i) {
        this.h = i;
        c(true);
        return this;
    }

    public u b(String str) {
        this.c = str;
        return this;
    }

    public String b() {
        return this.a;
    }

    public void b(String str, String str2) {
        if (this.k == null) {
            this.k = new HashMap();
        }
        this.k.put(str, str2);
    }

    @Override // org.apache.thrift.a
    public void b(org.apache.thrift.protocol.e eVar) {
        z();
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
        if (this.k != null && v()) {
            eVar.a(y);
            eVar.a(new org.apache.thrift.protocol.d((byte) 11, (byte) 11, this.k.size()));
            for (Map.Entry<String, String> entry2 : this.k.entrySet()) {
                eVar.a(entry2.getKey());
                eVar.a(entry2.getValue());
            }
            eVar.d();
            eVar.b();
        }
        if (x()) {
            eVar.a(z);
            eVar.a(this.l);
            eVar.b();
        }
        if (this.m != null && y()) {
            eVar.a(A);
            eVar.a(new org.apache.thrift.protocol.d((byte) 11, (byte) 11, this.m.size()));
            for (Map.Entry<String, String> entry3 : this.m.entrySet()) {
                eVar.a(entry3.getKey());
                eVar.a(entry3.getValue());
            }
            eVar.d();
            eVar.b();
        }
        eVar.c();
        eVar.a();
    }

    public void b(boolean z2) {
        this.B.set(1, z2);
    }

    public u c(int i) {
        this.i = i;
        d(true);
        return this;
    }

    public u c(String str) {
        this.d = str;
        return this;
    }

    public void c(boolean z2) {
        this.B.set(2, z2);
    }

    public boolean c() {
        return this.a != null;
    }

    public long d() {
        return this.b;
    }

    public u d(String str) {
        this.e = str;
        return this;
    }

    public void d(boolean z2) {
        this.B.set(3, z2);
    }

    public void e(boolean z2) {
        this.B.set(4, z2);
    }

    public boolean e() {
        return this.B.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof u)) {
            return a((u) obj);
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
        return this.B.get(1);
    }

    public boolean n() {
        return this.g != null;
    }

    public int o() {
        return this.h;
    }

    public boolean p() {
        return this.B.get(2);
    }

    public int q() {
        return this.i;
    }

    public boolean r() {
        return this.B.get(3);
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
        if (v()) {
            sb.append(", ");
            sb.append("internal:");
            if (this.k == null) {
                sb.append("null");
            } else {
                sb.append(this.k);
            }
        }
        if (x()) {
            sb.append(", ");
            sb.append("ignoreRegInfo:");
            sb.append(this.l);
        }
        if (y()) {
            sb.append(", ");
            sb.append("apsProperFields:");
            if (this.m == null) {
                sb.append("null");
            } else {
                sb.append(this.m);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    public Map<String, String> u() {
        return this.k;
    }

    public boolean v() {
        return this.k != null;
    }

    public boolean w() {
        return this.l;
    }

    public boolean x() {
        return this.B.get(4);
    }

    public boolean y() {
        return this.m != null;
    }

    public void z() {
        if (this.a == null) {
            throw new org.apache.thrift.protocol.f("Required field 'id' was not present! Struct: " + toString());
        }
    }
}
