package com.xiaomi.xmpush.thrift;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import org.apache.thrift.TFieldIdEnum;
/* loaded from: classes3.dex */
public class ae implements Serializable, Cloneable, org.apache.thrift.a<ae, TFieldIdEnum> {
    private static final org.apache.thrift.protocol.j k = new org.apache.thrift.protocol.j("XmPushActionCommandResult");
    private static final org.apache.thrift.protocol.b l = new org.apache.thrift.protocol.b("", (byte) 12, 2);
    private static final org.apache.thrift.protocol.b m = new org.apache.thrift.protocol.b("", Constants.GZIP_CAST_TYPE, 3);
    private static final org.apache.thrift.protocol.b n = new org.apache.thrift.protocol.b("", Constants.GZIP_CAST_TYPE, 4);
    private static final org.apache.thrift.protocol.b o = new org.apache.thrift.protocol.b("", Constants.GZIP_CAST_TYPE, 5);
    private static final org.apache.thrift.protocol.b p = new org.apache.thrift.protocol.b("", (byte) 10, 7);
    private static final org.apache.thrift.protocol.b q = new org.apache.thrift.protocol.b("", Constants.GZIP_CAST_TYPE, 8);
    private static final org.apache.thrift.protocol.b r = new org.apache.thrift.protocol.b("", Constants.GZIP_CAST_TYPE, 9);
    private static final org.apache.thrift.protocol.b s = new org.apache.thrift.protocol.b("", (byte) 15, 10);
    private static final org.apache.thrift.protocol.b t = new org.apache.thrift.protocol.b("", Constants.GZIP_CAST_TYPE, 12);
    private static final org.apache.thrift.protocol.b u = new org.apache.thrift.protocol.b("", (byte) 2, 13);
    public x a;
    public String b;
    public String c;
    public String d;
    public long e;
    public String f;
    public String g;
    public List<String> h;
    public String i;
    private BitSet v = new BitSet(2);
    public boolean j = true;

    @Override // org.apache.thrift.a
    public void a(org.apache.thrift.protocol.e eVar) {
        eVar.g();
        while (true) {
            org.apache.thrift.protocol.b i = eVar.i();
            if (i.b == 0) {
                eVar.h();
                if (!f()) {
                    throw new org.apache.thrift.protocol.f("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
                }
                n();
                return;
            }
            switch (i.c) {
                case 2:
                    if (i.b == 12) {
                        this.a = new x();
                        this.a.a(eVar);
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    }
                case 3:
                    if (i.b == 11) {
                        this.b = eVar.w();
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    }
                case 4:
                    if (i.b == 11) {
                        this.c = eVar.w();
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    }
                case 5:
                    if (i.b == 11) {
                        this.d = eVar.w();
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    }
                case 6:
                case 11:
                default:
                    org.apache.thrift.protocol.h.a(eVar, i.b);
                    break;
                case 7:
                    if (i.b == 10) {
                        this.e = eVar.u();
                        a(true);
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    }
                case 8:
                    if (i.b == 11) {
                        this.f = eVar.w();
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    }
                case 9:
                    if (i.b == 11) {
                        this.g = eVar.w();
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    }
                case 10:
                    if (i.b == 15) {
                        org.apache.thrift.protocol.c m2 = eVar.m();
                        this.h = new ArrayList(m2.b);
                        for (int i2 = 0; i2 < m2.b; i2++) {
                            this.h.add(eVar.w());
                        }
                        eVar.n();
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    }
                case 12:
                    if (i.b == 11) {
                        this.i = eVar.w();
                        break;
                    } else {
                        org.apache.thrift.protocol.h.a(eVar, i.b);
                        break;
                    }
                case 13:
                    if (i.b == 2) {
                        this.j = eVar.q();
                        b(true);
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
        this.v.set(0, z);
    }

    public boolean a() {
        return this.a != null;
    }

    public boolean a(ae aeVar) {
        if (aeVar == null) {
            return false;
        }
        boolean a = a();
        boolean a2 = aeVar.a();
        if ((a || a2) && !(a && a2 && this.a.a(aeVar.a))) {
            return false;
        }
        boolean b = b();
        boolean b2 = aeVar.b();
        if ((b || b2) && !(b && b2 && this.b.equals(aeVar.b))) {
            return false;
        }
        boolean c = c();
        boolean c2 = aeVar.c();
        if ((c || c2) && !(c && c2 && this.c.equals(aeVar.c))) {
            return false;
        }
        boolean e = e();
        boolean e2 = aeVar.e();
        if (((e || e2) && !(e && e2 && this.d.equals(aeVar.d))) || this.e != aeVar.e) {
            return false;
        }
        boolean g = g();
        boolean g2 = aeVar.g();
        if ((g || g2) && !(g && g2 && this.f.equals(aeVar.f))) {
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
        boolean l2 = l();
        boolean l3 = aeVar.l();
        if ((l2 || l3) && !(l2 && l3 && this.i.equals(aeVar.i))) {
            return false;
        }
        boolean m2 = m();
        boolean m3 = aeVar.m();
        return !(m2 || m3) || (m2 && m3 && this.j == aeVar.j);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: b */
    public int compareTo(ae aeVar) {
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
        if (getClass().equals(aeVar.getClass())) {
            int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(aeVar.a()));
            if (compareTo == 0) {
                if (!a() || (a10 = org.apache.thrift.b.a(this.a, aeVar.a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(aeVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a9 = org.apache.thrift.b.a(this.b, aeVar.b)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(aeVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a8 = org.apache.thrift.b.a(this.c, aeVar.c)) == 0) {
                                    int compareTo4 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(aeVar.e()));
                                    if (compareTo4 == 0) {
                                        if (!e() || (a7 = org.apache.thrift.b.a(this.d, aeVar.d)) == 0) {
                                            int compareTo5 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(aeVar.f()));
                                            if (compareTo5 == 0) {
                                                if (!f() || (a6 = org.apache.thrift.b.a(this.e, aeVar.e)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(aeVar.g()));
                                                    if (compareTo6 == 0) {
                                                        if (!g() || (a5 = org.apache.thrift.b.a(this.f, aeVar.f)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(aeVar.h()));
                                                            if (compareTo7 == 0) {
                                                                if (!h() || (a4 = org.apache.thrift.b.a(this.g, aeVar.g)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(aeVar.j()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!j() || (a3 = org.apache.thrift.b.a(this.h, aeVar.h)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(aeVar.l()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!l() || (a2 = org.apache.thrift.b.a(this.i, aeVar.i)) == 0) {
                                                                                    int compareTo10 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(aeVar.m()));
                                                                                    if (compareTo10 == 0) {
                                                                                        if (!m() || (a = org.apache.thrift.b.a(this.j, aeVar.j)) == 0) {
                                                                                            return 0;
                                                                                        }
                                                                                        return a;
                                                                                    }
                                                                                    return compareTo10;
                                                                                }
                                                                                return a2;
                                                                            }
                                                                            return compareTo9;
                                                                        }
                                                                        return a3;
                                                                    }
                                                                    return compareTo8;
                                                                }
                                                                return a4;
                                                            }
                                                            return compareTo7;
                                                        }
                                                        return a5;
                                                    }
                                                    return compareTo6;
                                                }
                                                return a6;
                                            }
                                            return compareTo5;
                                        }
                                        return a7;
                                    }
                                    return compareTo4;
                                }
                                return a8;
                            }
                            return compareTo3;
                        }
                        return a9;
                    }
                    return compareTo2;
                }
                return a10;
            }
            return compareTo;
        }
        return getClass().getName().compareTo(aeVar.getClass().getName());
    }

    @Override // org.apache.thrift.a
    public void b(org.apache.thrift.protocol.e eVar) {
        n();
        eVar.a(k);
        if (this.a != null && a()) {
            eVar.a(l);
            this.a.b(eVar);
            eVar.b();
        }
        if (this.b != null) {
            eVar.a(m);
            eVar.a(this.b);
            eVar.b();
        }
        if (this.c != null) {
            eVar.a(n);
            eVar.a(this.c);
            eVar.b();
        }
        if (this.d != null) {
            eVar.a(o);
            eVar.a(this.d);
            eVar.b();
        }
        eVar.a(p);
        eVar.a(this.e);
        eVar.b();
        if (this.f != null && g()) {
            eVar.a(q);
            eVar.a(this.f);
            eVar.b();
        }
        if (this.g != null && h()) {
            eVar.a(r);
            eVar.a(this.g);
            eVar.b();
        }
        if (this.h != null && j()) {
            eVar.a(s);
            eVar.a(new org.apache.thrift.protocol.c(Constants.GZIP_CAST_TYPE, this.h.size()));
            for (String str : this.h) {
                eVar.a(str);
            }
            eVar.e();
            eVar.b();
        }
        if (this.i != null && l()) {
            eVar.a(t);
            eVar.a(this.i);
            eVar.b();
        }
        if (m()) {
            eVar.a(u);
            eVar.a(this.j);
            eVar.b();
        }
        eVar.c();
        eVar.a();
    }

    public void b(boolean z) {
        this.v.set(1, z);
    }

    public boolean b() {
        return this.b != null;
    }

    public boolean c() {
        return this.c != null;
    }

    public String d() {
        return this.d;
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
        return this.v.get(0);
    }

    public boolean g() {
        return this.f != null;
    }

    public boolean h() {
        return this.g != null;
    }

    public int hashCode() {
        return 0;
    }

    public List<String> i() {
        return this.h;
    }

    public boolean j() {
        return this.h != null;
    }

    public String k() {
        return this.i;
    }

    public boolean l() {
        return this.i != null;
    }

    public boolean m() {
        return this.v.get(1);
    }

    public void n() {
        if (this.b == null) {
            throw new org.apache.thrift.protocol.f("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.c == null) {
            throw new org.apache.thrift.protocol.f("Required field 'appId' was not present! Struct: " + toString());
        }
        if (this.d == null) {
            throw new org.apache.thrift.protocol.f("Required field 'cmdName' was not present! Struct: " + toString());
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionCommandResult(");
        boolean z = true;
        if (a()) {
            sb.append("target:");
            if (this.a == null) {
                sb.append("null");
            } else {
                sb.append(this.a);
            }
            z = false;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.b == null) {
            sb.append("null");
        } else {
            sb.append(this.b);
        }
        sb.append(", ");
        sb.append("appId:");
        if (this.c == null) {
            sb.append("null");
        } else {
            sb.append(this.c);
        }
        sb.append(", ");
        sb.append("cmdName:");
        if (this.d == null) {
            sb.append("null");
        } else {
            sb.append(this.d);
        }
        sb.append(", ");
        sb.append("errorCode:");
        sb.append(this.e);
        if (g()) {
            sb.append(", ");
            sb.append("reason:");
            if (this.f == null) {
                sb.append("null");
            } else {
                sb.append(this.f);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.g == null) {
                sb.append("null");
            } else {
                sb.append(this.g);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("cmdArgs:");
            if (this.h == null) {
                sb.append("null");
            } else {
                sb.append(this.h);
            }
        }
        if (l()) {
            sb.append(", ");
            sb.append("category:");
            if (this.i == null) {
                sb.append("null");
            } else {
                sb.append(this.i);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("response2Client:");
            sb.append(this.j);
        }
        sb.append(")");
        return sb.toString();
    }
}
