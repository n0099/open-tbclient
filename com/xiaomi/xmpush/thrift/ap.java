package com.xiaomi.xmpush.thrift;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.util.BitSet;
import org.apache.thrift.TFieldIdEnum;
/* loaded from: classes3.dex */
public class ap implements Serializable, Cloneable, org.apache.thrift.a<ap, TFieldIdEnum> {
    private static final org.apache.thrift.protocol.j m = new org.apache.thrift.protocol.j("XmPushActionUnRegistration");
    private static final org.apache.thrift.protocol.b n = new org.apache.thrift.protocol.b("", Constants.GZIP_CAST_TYPE, 1);
    private static final org.apache.thrift.protocol.b o = new org.apache.thrift.protocol.b("", (byte) 12, 2);
    private static final org.apache.thrift.protocol.b p = new org.apache.thrift.protocol.b("", Constants.GZIP_CAST_TYPE, 3);
    private static final org.apache.thrift.protocol.b q = new org.apache.thrift.protocol.b("", Constants.GZIP_CAST_TYPE, 4);
    private static final org.apache.thrift.protocol.b r = new org.apache.thrift.protocol.b("", Constants.GZIP_CAST_TYPE, 5);
    private static final org.apache.thrift.protocol.b s = new org.apache.thrift.protocol.b("", Constants.GZIP_CAST_TYPE, 6);
    private static final org.apache.thrift.protocol.b t = new org.apache.thrift.protocol.b("", Constants.GZIP_CAST_TYPE, 7);
    private static final org.apache.thrift.protocol.b u = new org.apache.thrift.protocol.b("", Constants.GZIP_CAST_TYPE, 8);
    private static final org.apache.thrift.protocol.b v = new org.apache.thrift.protocol.b("", Constants.GZIP_CAST_TYPE, 9);
    private static final org.apache.thrift.protocol.b w = new org.apache.thrift.protocol.b("", Constants.GZIP_CAST_TYPE, 10);
    private static final org.apache.thrift.protocol.b x = new org.apache.thrift.protocol.b("", (byte) 2, 11);
    private static final org.apache.thrift.protocol.b y = new org.apache.thrift.protocol.b("", (byte) 10, 12);
    public String a;
    public x b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public long l;
    private BitSet z = new BitSet(2);
    public boolean k = true;

    public ap a(String str) {
        this.c = str;
        return this;
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
                        this.b = new x();
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
                    if (i.b != 11) {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    } else {
                        this.e = eVar.w();
                        break;
                    }
                case 6:
                    if (i.b != 11) {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    } else {
                        this.f = eVar.w();
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
                case 11:
                    if (i.b != 2) {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    } else {
                        this.k = eVar.q();
                        a(true);
                        break;
                    }
                case 12:
                    if (i.b != 10) {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    } else {
                        this.l = eVar.u();
                        b(true);
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
        this.z.set(0, z);
    }

    public boolean a() {
        return this.a != null;
    }

    public boolean a(ap apVar) {
        if (apVar == null) {
            return false;
        }
        boolean a = a();
        boolean a2 = apVar.a();
        if ((a || a2) && !(a && a2 && this.a.equals(apVar.a))) {
            return false;
        }
        boolean b = b();
        boolean b2 = apVar.b();
        if ((b || b2) && !(b && b2 && this.b.a(apVar.b))) {
            return false;
        }
        boolean c = c();
        boolean c2 = apVar.c();
        if ((c || c2) && !(c && c2 && this.c.equals(apVar.c))) {
            return false;
        }
        boolean d = d();
        boolean d2 = apVar.d();
        if ((d || d2) && !(d && d2 && this.d.equals(apVar.d))) {
            return false;
        }
        boolean e = e();
        boolean e2 = apVar.e();
        if ((e || e2) && !(e && e2 && this.e.equals(apVar.e))) {
            return false;
        }
        boolean f = f();
        boolean f2 = apVar.f();
        if ((f || f2) && !(f && f2 && this.f.equals(apVar.f))) {
            return false;
        }
        boolean g = g();
        boolean g2 = apVar.g();
        if ((g || g2) && !(g && g2 && this.g.equals(apVar.g))) {
            return false;
        }
        boolean h = h();
        boolean h2 = apVar.h();
        if ((h || h2) && !(h && h2 && this.h.equals(apVar.h))) {
            return false;
        }
        boolean i = i();
        boolean i2 = apVar.i();
        if ((i || i2) && !(i && i2 && this.i.equals(apVar.i))) {
            return false;
        }
        boolean j = j();
        boolean j2 = apVar.j();
        if ((j || j2) && !(j && j2 && this.j.equals(apVar.j))) {
            return false;
        }
        boolean k = k();
        boolean k2 = apVar.k();
        if ((k || k2) && !(k && k2 && this.k == apVar.k)) {
            return false;
        }
        boolean l = l();
        boolean l2 = apVar.l();
        return !(l || l2) || (l && l2 && this.l == apVar.l);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: b */
    public int compareTo(ap apVar) {
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
        if (getClass().equals(apVar.getClass())) {
            int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(apVar.a()));
            if (compareTo == 0) {
                if (!a() || (a12 = org.apache.thrift.b.a(this.a, apVar.a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(apVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a11 = org.apache.thrift.b.a(this.b, apVar.b)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(apVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a10 = org.apache.thrift.b.a(this.c, apVar.c)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(apVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a9 = org.apache.thrift.b.a(this.d, apVar.d)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(apVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a8 = org.apache.thrift.b.a(this.e, apVar.e)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(apVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a7 = org.apache.thrift.b.a(this.f, apVar.f)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(apVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a6 = org.apache.thrift.b.a(this.g, apVar.g)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(apVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a5 = org.apache.thrift.b.a(this.h, apVar.h)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(apVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a4 = org.apache.thrift.b.a(this.i, apVar.i)) == 0) {
                                                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(apVar.j()));
                                                                                    if (compareTo10 == 0) {
                                                                                        if (!j() || (a3 = org.apache.thrift.b.a(this.j, apVar.j)) == 0) {
                                                                                            int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(apVar.k()));
                                                                                            if (compareTo11 == 0) {
                                                                                                if (!k() || (a2 = org.apache.thrift.b.a(this.k, apVar.k)) == 0) {
                                                                                                    int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(apVar.l()));
                                                                                                    if (compareTo12 == 0) {
                                                                                                        if (!l() || (a = org.apache.thrift.b.a(this.l, apVar.l)) == 0) {
                                                                                                            return 0;
                                                                                                        }
                                                                                                        return a;
                                                                                                    }
                                                                                                    return compareTo12;
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
        return getClass().getName().compareTo(apVar.getClass().getName());
    }

    public ap b(String str) {
        this.d = str;
        return this;
    }

    @Override // org.apache.thrift.a
    public void b(org.apache.thrift.protocol.e eVar) {
        m();
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
        if (this.e != null && e()) {
            eVar.a(r);
            eVar.a(this.e);
            eVar.b();
        }
        if (this.f != null && f()) {
            eVar.a(s);
            eVar.a(this.f);
            eVar.b();
        }
        if (this.g != null && g()) {
            eVar.a(t);
            eVar.a(this.g);
            eVar.b();
        }
        if (this.h != null && h()) {
            eVar.a(u);
            eVar.a(this.h);
            eVar.b();
        }
        if (this.i != null && i()) {
            eVar.a(v);
            eVar.a(this.i);
            eVar.b();
        }
        if (this.j != null && j()) {
            eVar.a(w);
            eVar.a(this.j);
            eVar.b();
        }
        if (k()) {
            eVar.a(x);
            eVar.a(this.k);
            eVar.b();
        }
        if (l()) {
            eVar.a(y);
            eVar.a(this.l);
            eVar.b();
        }
        eVar.c();
        eVar.a();
    }

    public void b(boolean z) {
        this.z.set(1, z);
    }

    public boolean b() {
        return this.b != null;
    }

    public ap c(String str) {
        this.e = str;
        return this;
    }

    public boolean c() {
        return this.c != null;
    }

    public ap d(String str) {
        this.g = str;
        return this;
    }

    public boolean d() {
        return this.d != null;
    }

    public ap e(String str) {
        this.h = str;
        return this;
    }

    public boolean e() {
        return this.e != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ap)) {
            return a((ap) obj);
        }
        return false;
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

    public boolean i() {
        return this.i != null;
    }

    public boolean j() {
        return this.j != null;
    }

    public boolean k() {
        return this.z.get(0);
    }

    public boolean l() {
        return this.z.get(1);
    }

    public void m() {
        if (this.c == null) {
            throw new org.apache.thrift.protocol.f("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.d == null) {
            throw new org.apache.thrift.protocol.f("Required field 'appId' was not present! Struct: " + toString());
        }
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionUnRegistration(");
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
        if (e()) {
            sb.append(", ");
            sb.append("regId:");
            if (this.e == null) {
                sb.append("null");
            } else {
                sb.append(this.e);
            }
        }
        if (f()) {
            sb.append(", ");
            sb.append("appVersion:");
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
            sb.append("token:");
            if (this.h == null) {
                sb.append("null");
            } else {
                sb.append(this.h);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("deviceId:");
            if (this.i == null) {
                sb.append("null");
            } else {
                sb.append(this.i);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("aliasName:");
            if (this.j == null) {
                sb.append("null");
            } else {
                sb.append(this.j);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("needAck:");
            sb.append(this.k);
        }
        if (l()) {
            sb.append(", ");
            sb.append("createdTs:");
            sb.append(this.l);
        }
        sb.append(")");
        return sb.toString();
    }
}
