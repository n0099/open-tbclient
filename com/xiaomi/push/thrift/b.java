package com.xiaomi.push.thrift;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.util.BitSet;
import org.apache.thrift.TFieldIdEnum;
import org.apache.thrift.protocol.e;
import org.apache.thrift.protocol.f;
import org.apache.thrift.protocol.h;
import org.apache.thrift.protocol.j;
/* loaded from: classes3.dex */
public class b implements Serializable, Cloneable, org.apache.thrift.a<b, TFieldIdEnum> {
    private static final j k = new j("StatsEvent");
    private static final org.apache.thrift.protocol.b l = new org.apache.thrift.protocol.b("", (byte) 3, 1);
    private static final org.apache.thrift.protocol.b m = new org.apache.thrift.protocol.b("", (byte) 8, 2);
    private static final org.apache.thrift.protocol.b n = new org.apache.thrift.protocol.b("", (byte) 8, 3);
    private static final org.apache.thrift.protocol.b o = new org.apache.thrift.protocol.b("", Constants.GZIP_CAST_TYPE, 4);
    private static final org.apache.thrift.protocol.b p = new org.apache.thrift.protocol.b("", Constants.GZIP_CAST_TYPE, 5);
    private static final org.apache.thrift.protocol.b q = new org.apache.thrift.protocol.b("", (byte) 8, 6);
    private static final org.apache.thrift.protocol.b r = new org.apache.thrift.protocol.b("", Constants.GZIP_CAST_TYPE, 7);
    private static final org.apache.thrift.protocol.b s = new org.apache.thrift.protocol.b("", Constants.GZIP_CAST_TYPE, 8);
    private static final org.apache.thrift.protocol.b t = new org.apache.thrift.protocol.b("", (byte) 8, 9);
    private static final org.apache.thrift.protocol.b u = new org.apache.thrift.protocol.b("", (byte) 8, 10);
    public byte a;
    public int b;
    public int c;
    public String d;
    public String e;
    public int f;
    public String g;
    public String h;
    public int i;
    public int j;
    private BitSet v = new BitSet(6);

    public b a(byte b) {
        this.a = b;
        a(true);
        return this;
    }

    public b a(int i) {
        this.b = i;
        b(true);
        return this;
    }

    public b a(String str) {
        this.d = str;
        return this;
    }

    @Override // org.apache.thrift.a
    public void a(e eVar) {
        eVar.g();
        while (true) {
            org.apache.thrift.protocol.b i = eVar.i();
            if (i.b == 0) {
                eVar.h();
                if (!a()) {
                    throw new f("Required field 'chid' was not found in serialized data! Struct: " + toString());
                }
                if (!b()) {
                    throw new f("Required field 'type' was not found in serialized data! Struct: " + toString());
                }
                if (!c()) {
                    throw new f("Required field 'value' was not found in serialized data! Struct: " + toString());
                }
                k();
                return;
            }
            switch (i.c) {
                case 1:
                    if (i.b != 3) {
                        h.a(eVar, i.b);
                        break;
                    } else {
                        this.a = eVar.r();
                        a(true);
                        break;
                    }
                case 2:
                    if (i.b != 8) {
                        h.a(eVar, i.b);
                        break;
                    } else {
                        this.b = eVar.t();
                        b(true);
                        break;
                    }
                case 3:
                    if (i.b != 8) {
                        h.a(eVar, i.b);
                        break;
                    } else {
                        this.c = eVar.t();
                        c(true);
                        break;
                    }
                case 4:
                    if (i.b != 11) {
                        h.a(eVar, i.b);
                        break;
                    } else {
                        this.d = eVar.w();
                        break;
                    }
                case 5:
                    if (i.b != 11) {
                        h.a(eVar, i.b);
                        break;
                    } else {
                        this.e = eVar.w();
                        break;
                    }
                case 6:
                    if (i.b != 8) {
                        h.a(eVar, i.b);
                        break;
                    } else {
                        this.f = eVar.t();
                        d(true);
                        break;
                    }
                case 7:
                    if (i.b != 11) {
                        h.a(eVar, i.b);
                        break;
                    } else {
                        this.g = eVar.w();
                        break;
                    }
                case 8:
                    if (i.b != 11) {
                        h.a(eVar, i.b);
                        break;
                    } else {
                        this.h = eVar.w();
                        break;
                    }
                case 9:
                    if (i.b != 8) {
                        h.a(eVar, i.b);
                        break;
                    } else {
                        this.i = eVar.t();
                        e(true);
                        break;
                    }
                case 10:
                    if (i.b != 8) {
                        h.a(eVar, i.b);
                        break;
                    } else {
                        this.j = eVar.t();
                        f(true);
                        break;
                    }
                default:
                    h.a(eVar, i.b);
                    break;
            }
            eVar.j();
        }
    }

    public void a(boolean z) {
        this.v.set(0, z);
    }

    public boolean a() {
        return this.v.get(0);
    }

    public boolean a(b bVar) {
        if (bVar != null && this.a == bVar.a && this.b == bVar.b && this.c == bVar.c) {
            boolean d = d();
            boolean d2 = bVar.d();
            if ((d || d2) && !(d && d2 && this.d.equals(bVar.d))) {
                return false;
            }
            boolean e = e();
            boolean e2 = bVar.e();
            if ((e || e2) && !(e && e2 && this.e.equals(bVar.e))) {
                return false;
            }
            boolean f = f();
            boolean f2 = bVar.f();
            if ((f || f2) && !(f && f2 && this.f == bVar.f)) {
                return false;
            }
            boolean g = g();
            boolean g2 = bVar.g();
            if ((g || g2) && !(g && g2 && this.g.equals(bVar.g))) {
                return false;
            }
            boolean h = h();
            boolean h2 = bVar.h();
            if ((h || h2) && !(h && h2 && this.h.equals(bVar.h))) {
                return false;
            }
            boolean i = i();
            boolean i2 = bVar.i();
            if ((i || i2) && !(i && i2 && this.i == bVar.i)) {
                return false;
            }
            boolean j = j();
            boolean j2 = bVar.j();
            return !(j || j2) || (j && j2 && this.j == bVar.j);
        }
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: b */
    public int compareTo(b bVar) {
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
        if (getClass().equals(bVar.getClass())) {
            int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(bVar.a()));
            if (compareTo == 0) {
                if (!a() || (a10 = org.apache.thrift.b.a(this.a, bVar.a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(bVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a9 = org.apache.thrift.b.a(this.b, bVar.b)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(bVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a8 = org.apache.thrift.b.a(this.c, bVar.c)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(bVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a7 = org.apache.thrift.b.a(this.d, bVar.d)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(bVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a6 = org.apache.thrift.b.a(this.e, bVar.e)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(bVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a5 = org.apache.thrift.b.a(this.f, bVar.f)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(bVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a4 = org.apache.thrift.b.a(this.g, bVar.g)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(bVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a3 = org.apache.thrift.b.a(this.h, bVar.h)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(bVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a2 = org.apache.thrift.b.a(this.i, bVar.i)) == 0) {
                                                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(bVar.j()));
                                                                                    if (compareTo10 == 0) {
                                                                                        if (!j() || (a = org.apache.thrift.b.a(this.j, bVar.j)) == 0) {
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
        return getClass().getName().compareTo(bVar.getClass().getName());
    }

    public b b(int i) {
        this.c = i;
        c(true);
        return this;
    }

    public b b(String str) {
        this.e = str;
        return this;
    }

    @Override // org.apache.thrift.a
    public void b(e eVar) {
        k();
        eVar.a(k);
        eVar.a(l);
        eVar.a(this.a);
        eVar.b();
        eVar.a(m);
        eVar.a(this.b);
        eVar.b();
        eVar.a(n);
        eVar.a(this.c);
        eVar.b();
        if (this.d != null) {
            eVar.a(o);
            eVar.a(this.d);
            eVar.b();
        }
        if (this.e != null && e()) {
            eVar.a(p);
            eVar.a(this.e);
            eVar.b();
        }
        if (f()) {
            eVar.a(q);
            eVar.a(this.f);
            eVar.b();
        }
        if (this.g != null && g()) {
            eVar.a(r);
            eVar.a(this.g);
            eVar.b();
        }
        if (this.h != null && h()) {
            eVar.a(s);
            eVar.a(this.h);
            eVar.b();
        }
        if (i()) {
            eVar.a(t);
            eVar.a(this.i);
            eVar.b();
        }
        if (j()) {
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
        return this.v.get(1);
    }

    public b c(int i) {
        this.f = i;
        d(true);
        return this;
    }

    public b c(String str) {
        this.g = str;
        return this;
    }

    public void c(boolean z) {
        this.v.set(2, z);
    }

    public boolean c() {
        return this.v.get(2);
    }

    public b d(int i) {
        this.i = i;
        e(true);
        return this;
    }

    public b d(String str) {
        this.h = str;
        return this;
    }

    public void d(boolean z) {
        this.v.set(3, z);
    }

    public boolean d() {
        return this.d != null;
    }

    public void e(boolean z) {
        this.v.set(4, z);
    }

    public boolean e() {
        return this.e != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof b)) {
            return a((b) obj);
        }
        return false;
    }

    public void f(boolean z) {
        this.v.set(5, z);
    }

    public boolean f() {
        return this.v.get(3);
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
        return this.v.get(4);
    }

    public boolean j() {
        return this.v.get(5);
    }

    public void k() {
        if (this.d == null) {
            throw new f("Required field 'connpt' was not present! Struct: " + toString());
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("StatsEvent(");
        sb.append("chid:");
        sb.append((int) this.a);
        sb.append(", ");
        sb.append("type:");
        sb.append(this.b);
        sb.append(", ");
        sb.append("value:");
        sb.append(this.c);
        sb.append(", ");
        sb.append("connpt:");
        if (this.d == null) {
            sb.append("null");
        } else {
            sb.append(this.d);
        }
        if (e()) {
            sb.append(", ");
            sb.append("host:");
            if (this.e == null) {
                sb.append("null");
            } else {
                sb.append(this.e);
            }
        }
        if (f()) {
            sb.append(", ");
            sb.append("subvalue:");
            sb.append(this.f);
        }
        if (g()) {
            sb.append(", ");
            sb.append("annotation:");
            if (this.g == null) {
                sb.append("null");
            } else {
                sb.append(this.g);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("user:");
            if (this.h == null) {
                sb.append("null");
            } else {
                sb.append(this.h);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("time:");
            sb.append(this.i);
        }
        if (j()) {
            sb.append(", ");
            sb.append("clientIp:");
            sb.append(this.j);
        }
        sb.append(")");
        return sb.toString();
    }
}
