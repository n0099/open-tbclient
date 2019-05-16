package com.xiaomi.xmpush.thrift;

import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
import org.apache.thrift.TFieldIdEnum;
/* loaded from: classes3.dex */
public class f implements Serializable, Cloneable, org.apache.thrift.a<f, TFieldIdEnum> {
    private static final org.apache.thrift.protocol.j l = new org.apache.thrift.protocol.j("ClientUploadDataItem");
    private static final org.apache.thrift.protocol.b m = new org.apache.thrift.protocol.b("", (byte) 11, 1);
    private static final org.apache.thrift.protocol.b n = new org.apache.thrift.protocol.b("", (byte) 11, 2);
    private static final org.apache.thrift.protocol.b o = new org.apache.thrift.protocol.b("", (byte) 11, 3);
    private static final org.apache.thrift.protocol.b p = new org.apache.thrift.protocol.b("", (byte) 10, 4);
    private static final org.apache.thrift.protocol.b q = new org.apache.thrift.protocol.b("", (byte) 10, 5);
    private static final org.apache.thrift.protocol.b r = new org.apache.thrift.protocol.b("", (byte) 2, 6);
    private static final org.apache.thrift.protocol.b s = new org.apache.thrift.protocol.b("", (byte) 11, 7);
    private static final org.apache.thrift.protocol.b t = new org.apache.thrift.protocol.b("", (byte) 11, 8);
    private static final org.apache.thrift.protocol.b u = new org.apache.thrift.protocol.b("", (byte) 11, 9);
    private static final org.apache.thrift.protocol.b v = new org.apache.thrift.protocol.b("", (byte) 13, 10);
    private static final org.apache.thrift.protocol.b w = new org.apache.thrift.protocol.b("", (byte) 11, 11);
    public String a;
    public String b;
    public String c;
    public long d;
    public long e;
    public boolean f;
    public String g;
    public String h;
    public String i;
    public Map<String, String> j;
    public String k;
    private BitSet x = new BitSet(3);

    public f a(long j) {
        this.d = j;
        a(true);
        return this;
    }

    public f a(String str) {
        this.a = str;
        return this;
    }

    public String a() {
        return this.a;
    }

    @Override // org.apache.thrift.a
    public void a(org.apache.thrift.protocol.e eVar) {
        eVar.g();
        while (true) {
            org.apache.thrift.protocol.b i = eVar.i();
            if (i.b == 0) {
                eVar.h();
                r();
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
                    if (i.b == 11) {
                        this.b = eVar.w();
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
                    if (i.b == 10) {
                        this.d = eVar.u();
                        a(true);
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    }
                case 5:
                    if (i.b == 10) {
                        this.e = eVar.u();
                        b(true);
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    }
                case 6:
                    if (i.b == 2) {
                        this.f = eVar.q();
                        d(true);
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
                default:
                    org.apache.thrift.protocol.h.a(eVar, i.b);
                    break;
            }
            eVar.j();
        }
    }

    public void a(boolean z) {
        this.x.set(0, z);
    }

    public boolean a(f fVar) {
        if (fVar == null) {
            return false;
        }
        boolean b = b();
        boolean b2 = fVar.b();
        if ((b || b2) && !(b && b2 && this.a.equals(fVar.a))) {
            return false;
        }
        boolean c = c();
        boolean c2 = fVar.c();
        if ((c || c2) && !(c && c2 && this.b.equals(fVar.b))) {
            return false;
        }
        boolean e = e();
        boolean e2 = fVar.e();
        if ((e || e2) && !(e && e2 && this.c.equals(fVar.c))) {
            return false;
        }
        boolean f = f();
        boolean f2 = fVar.f();
        if ((f || f2) && !(f && f2 && this.d == fVar.d)) {
            return false;
        }
        boolean h = h();
        boolean h2 = fVar.h();
        if ((h || h2) && !(h && h2 && this.e == fVar.e)) {
            return false;
        }
        boolean i = i();
        boolean i2 = fVar.i();
        if ((i || i2) && !(i && i2 && this.f == fVar.f)) {
            return false;
        }
        boolean j = j();
        boolean j2 = fVar.j();
        if ((j || j2) && !(j && j2 && this.g.equals(fVar.g))) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = fVar.l();
        if ((l2 || l3) && !(l2 && l3 && this.h.equals(fVar.h))) {
            return false;
        }
        boolean n2 = n();
        boolean n3 = fVar.n();
        if ((n2 || n3) && !(n2 && n3 && this.i.equals(fVar.i))) {
            return false;
        }
        boolean o2 = o();
        boolean o3 = fVar.o();
        if ((o2 || o3) && !(o2 && o3 && this.j.equals(fVar.j))) {
            return false;
        }
        boolean q2 = q();
        boolean q3 = fVar.q();
        return !(q2 || q3) || (q2 && q3 && this.k.equals(fVar.k));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: b */
    public int compareTo(f fVar) {
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
        if (getClass().equals(fVar.getClass())) {
            int compareTo = Boolean.valueOf(b()).compareTo(Boolean.valueOf(fVar.b()));
            if (compareTo == 0) {
                if (!b() || (a11 = org.apache.thrift.b.a(this.a, fVar.a)) == 0) {
                    int compareTo2 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(fVar.c()));
                    if (compareTo2 == 0) {
                        if (!c() || (a10 = org.apache.thrift.b.a(this.b, fVar.b)) == 0) {
                            int compareTo3 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(fVar.e()));
                            if (compareTo3 == 0) {
                                if (!e() || (a9 = org.apache.thrift.b.a(this.c, fVar.c)) == 0) {
                                    int compareTo4 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(fVar.f()));
                                    if (compareTo4 == 0) {
                                        if (!f() || (a8 = org.apache.thrift.b.a(this.d, fVar.d)) == 0) {
                                            int compareTo5 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(fVar.h()));
                                            if (compareTo5 == 0) {
                                                if (!h() || (a7 = org.apache.thrift.b.a(this.e, fVar.e)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(fVar.i()));
                                                    if (compareTo6 == 0) {
                                                        if (!i() || (a6 = org.apache.thrift.b.a(this.f, fVar.f)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(fVar.j()));
                                                            if (compareTo7 == 0) {
                                                                if (!j() || (a5 = org.apache.thrift.b.a(this.g, fVar.g)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(fVar.l()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!l() || (a4 = org.apache.thrift.b.a(this.h, fVar.h)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(fVar.n()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!n() || (a3 = org.apache.thrift.b.a(this.i, fVar.i)) == 0) {
                                                                                    int compareTo10 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(fVar.o()));
                                                                                    if (compareTo10 == 0) {
                                                                                        if (!o() || (a2 = org.apache.thrift.b.a(this.j, fVar.j)) == 0) {
                                                                                            int compareTo11 = Boolean.valueOf(q()).compareTo(Boolean.valueOf(fVar.q()));
                                                                                            if (compareTo11 == 0) {
                                                                                                if (!q() || (a = org.apache.thrift.b.a(this.k, fVar.k)) == 0) {
                                                                                                    return 0;
                                                                                                }
                                                                                                return a;
                                                                                            }
                                                                                            return compareTo11;
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
        return getClass().getName().compareTo(fVar.getClass().getName());
    }

    public f b(long j) {
        this.e = j;
        b(true);
        return this;
    }

    public f b(String str) {
        this.b = str;
        return this;
    }

    @Override // org.apache.thrift.a
    public void b(org.apache.thrift.protocol.e eVar) {
        r();
        eVar.a(l);
        if (this.a != null && b()) {
            eVar.a(m);
            eVar.a(this.a);
            eVar.b();
        }
        if (this.b != null && c()) {
            eVar.a(n);
            eVar.a(this.b);
            eVar.b();
        }
        if (this.c != null && e()) {
            eVar.a(o);
            eVar.a(this.c);
            eVar.b();
        }
        if (f()) {
            eVar.a(p);
            eVar.a(this.d);
            eVar.b();
        }
        if (h()) {
            eVar.a(q);
            eVar.a(this.e);
            eVar.b();
        }
        if (i()) {
            eVar.a(r);
            eVar.a(this.f);
            eVar.b();
        }
        if (this.g != null && j()) {
            eVar.a(s);
            eVar.a(this.g);
            eVar.b();
        }
        if (this.h != null && l()) {
            eVar.a(t);
            eVar.a(this.h);
            eVar.b();
        }
        if (this.i != null && n()) {
            eVar.a(u);
            eVar.a(this.i);
            eVar.b();
        }
        if (this.j != null && o()) {
            eVar.a(v);
            eVar.a(new org.apache.thrift.protocol.d((byte) 11, (byte) 11, this.j.size()));
            for (Map.Entry<String, String> entry : this.j.entrySet()) {
                eVar.a(entry.getKey());
                eVar.a(entry.getValue());
            }
            eVar.d();
            eVar.b();
        }
        if (this.k != null && q()) {
            eVar.a(w);
            eVar.a(this.k);
            eVar.b();
        }
        eVar.c();
        eVar.a();
    }

    public void b(boolean z) {
        this.x.set(1, z);
    }

    public boolean b() {
        return this.a != null;
    }

    public f c(String str) {
        this.c = str;
        return this;
    }

    public f c(boolean z) {
        this.f = z;
        d(true);
        return this;
    }

    public boolean c() {
        return this.b != null;
    }

    public f d(String str) {
        this.g = str;
        return this;
    }

    public String d() {
        return this.c;
    }

    public void d(boolean z) {
        this.x.set(2, z);
    }

    public f e(String str) {
        this.h = str;
        return this;
    }

    public boolean e() {
        return this.c != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof f)) {
            return a((f) obj);
        }
        return false;
    }

    public f f(String str) {
        this.i = str;
        return this;
    }

    public boolean f() {
        return this.x.get(0);
    }

    public long g() {
        return this.e;
    }

    public f g(String str) {
        this.k = str;
        return this;
    }

    public boolean h() {
        return this.x.get(1);
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.x.get(2);
    }

    public boolean j() {
        return this.g != null;
    }

    public String k() {
        return this.h;
    }

    public boolean l() {
        return this.h != null;
    }

    public String m() {
        return this.i;
    }

    public boolean n() {
        return this.i != null;
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

    public void r() {
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("ClientUploadDataItem(");
        boolean z2 = true;
        if (b()) {
            sb.append("channel:");
            if (this.a == null) {
                sb.append("null");
            } else {
                sb.append(this.a);
            }
            z2 = false;
        }
        if (c()) {
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
        if (e()) {
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
        if (f()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("counter:");
            sb.append(this.d);
            z2 = false;
        }
        if (h()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("timestamp:");
            sb.append(this.e);
            z2 = false;
        }
        if (i()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("fromSdk:");
            sb.append(this.f);
            z2 = false;
        }
        if (j()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("category:");
            if (this.g == null) {
                sb.append("null");
            } else {
                sb.append(this.g);
            }
            z2 = false;
        }
        if (l()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("sourcePackage:");
            if (this.h == null) {
                sb.append("null");
            } else {
                sb.append(this.h);
            }
            z2 = false;
        }
        if (n()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("id:");
            if (this.i == null) {
                sb.append("null");
            } else {
                sb.append(this.i);
            }
            z2 = false;
        }
        if (o()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("extra:");
            if (this.j == null) {
                sb.append("null");
            } else {
                sb.append(this.j);
            }
        } else {
            z = z2;
        }
        if (q()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("pkgName:");
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
