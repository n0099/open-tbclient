package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes6.dex */
public class fi implements ix<fi, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public byte f403a;

    /* renamed from: a  reason: collision with other field name */
    public int f404a;

    /* renamed from: a  reason: collision with other field name */
    public String f405a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f406a = new BitSet(6);

    /* renamed from: b  reason: collision with other field name */
    public int f407b;

    /* renamed from: b  reason: collision with other field name */
    public String f408b;

    /* renamed from: c  reason: collision with other field name */
    public int f409c;

    /* renamed from: c  reason: collision with other field name */
    public String f410c;

    /* renamed from: d  reason: collision with other field name */
    public int f411d;

    /* renamed from: d  reason: collision with other field name */
    public String f412d;

    /* renamed from: e  reason: collision with other field name */
    public int f413e;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f402a = new jn("StatsEvent");

    /* renamed from: a  reason: collision with root package name */
    private static final jf f14314a = new jf("", (byte) 3, 1);

    /* renamed from: b  reason: collision with root package name */
    private static final jf f14315b = new jf("", (byte) 8, 2);
    private static final jf c = new jf("", (byte) 8, 3);
    private static final jf d = new jf("", Constants.GZIP_CAST_TYPE, 4);
    private static final jf e = new jf("", Constants.GZIP_CAST_TYPE, 5);
    private static final jf f = new jf("", (byte) 8, 6);
    private static final jf g = new jf("", Constants.GZIP_CAST_TYPE, 7);
    private static final jf h = new jf("", Constants.GZIP_CAST_TYPE, 8);
    private static final jf i = new jf("", (byte) 8, 9);
    private static final jf j = new jf("", (byte) 8, 10);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(fi fiVar) {
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
        if (getClass().equals(fiVar.getClass())) {
            int compareTo = Boolean.valueOf(m306a()).compareTo(Boolean.valueOf(fiVar.m306a()));
            if (compareTo == 0) {
                if (!m306a() || (a11 = iy.a(this.f403a, fiVar.f403a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(fiVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a10 = iy.a(this.f404a, fiVar.f404a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(fiVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a9 = iy.a(this.f407b, fiVar.f407b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(fiVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a8 = iy.a(this.f405a, fiVar.f405a)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(fiVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a7 = iy.a(this.f408b, fiVar.f408b)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(fiVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a6 = iy.a(this.f409c, fiVar.f409c)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(fiVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a5 = iy.a(this.f410c, fiVar.f410c)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(fiVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a4 = iy.a(this.f412d, fiVar.f412d)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(fiVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a3 = iy.a(this.f411d, fiVar.f411d)) == 0) {
                                                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(fiVar.j()));
                                                                                    if (compareTo10 == 0) {
                                                                                        if (!j() || (a2 = iy.a(this.f413e, fiVar.f413e)) == 0) {
                                                                                            return 0;
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
        return getClass().getName().compareTo(fiVar.getClass().getName());
    }

    public fi a(byte b2) {
        this.f403a = b2;
        a(true);
        return this;
    }

    public fi a(int i2) {
        this.f404a = i2;
        b(true);
        return this;
    }

    public fi a(String str) {
        this.f405a = str;
        return this;
    }

    public void a() {
        if (this.f405a == null) {
            throw new jj("Required field 'connpt' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m519a();
        while (true) {
            jf m515a = jiVar.m515a();
            if (m515a.f14471a == 0) {
                jiVar.f();
                if (!m306a()) {
                    throw new jj("Required field 'chid' was not found in serialized data! Struct: " + toString());
                }
                if (!b()) {
                    throw new jj("Required field 'type' was not found in serialized data! Struct: " + toString());
                }
                if (!c()) {
                    throw new jj("Required field 'value' was not found in serialized data! Struct: " + toString());
                }
                a();
                return;
            }
            switch (m515a.f858a) {
                case 1:
                    if (m515a.f14471a != 3) {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    } else {
                        this.f403a = jiVar.a();
                        a(true);
                        break;
                    }
                case 2:
                    if (m515a.f14471a != 8) {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    } else {
                        this.f404a = jiVar.m513a();
                        b(true);
                        break;
                    }
                case 3:
                    if (m515a.f14471a != 8) {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    } else {
                        this.f407b = jiVar.m513a();
                        c(true);
                        break;
                    }
                case 4:
                    if (m515a.f14471a != 11) {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    } else {
                        this.f405a = jiVar.m520a();
                        break;
                    }
                case 5:
                    if (m515a.f14471a != 11) {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    } else {
                        this.f408b = jiVar.m520a();
                        break;
                    }
                case 6:
                    if (m515a.f14471a != 8) {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    } else {
                        this.f409c = jiVar.m513a();
                        d(true);
                        break;
                    }
                case 7:
                    if (m515a.f14471a != 11) {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    } else {
                        this.f410c = jiVar.m520a();
                        break;
                    }
                case 8:
                    if (m515a.f14471a != 11) {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    } else {
                        this.f412d = jiVar.m520a();
                        break;
                    }
                case 9:
                    if (m515a.f14471a != 8) {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    } else {
                        this.f411d = jiVar.m513a();
                        e(true);
                        break;
                    }
                case 10:
                    if (m515a.f14471a != 8) {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    } else {
                        this.f413e = jiVar.m513a();
                        f(true);
                        break;
                    }
                default:
                    jl.a(jiVar, m515a.f14471a);
                    break;
            }
            jiVar.g();
        }
    }

    public void a(boolean z) {
        this.f406a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m306a() {
        return this.f406a.get(0);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m307a(fi fiVar) {
        if (fiVar != null && this.f403a == fiVar.f403a && this.f404a == fiVar.f404a && this.f407b == fiVar.f407b) {
            boolean d2 = d();
            boolean d3 = fiVar.d();
            if ((d2 || d3) && !(d2 && d3 && this.f405a.equals(fiVar.f405a))) {
                return false;
            }
            boolean e2 = e();
            boolean e3 = fiVar.e();
            if ((e2 || e3) && !(e2 && e3 && this.f408b.equals(fiVar.f408b))) {
                return false;
            }
            boolean f2 = f();
            boolean f3 = fiVar.f();
            if ((f2 || f3) && !(f2 && f3 && this.f409c == fiVar.f409c)) {
                return false;
            }
            boolean g2 = g();
            boolean g3 = fiVar.g();
            if ((g2 || g3) && !(g2 && g3 && this.f410c.equals(fiVar.f410c))) {
                return false;
            }
            boolean h2 = h();
            boolean h3 = fiVar.h();
            if ((h2 || h3) && !(h2 && h3 && this.f412d.equals(fiVar.f412d))) {
                return false;
            }
            boolean i2 = i();
            boolean i3 = fiVar.i();
            if ((i2 || i3) && !(i2 && i3 && this.f411d == fiVar.f411d)) {
                return false;
            }
            boolean j2 = j();
            boolean j3 = fiVar.j();
            return !(j2 || j3) || (j2 && j3 && this.f413e == fiVar.f413e);
        }
        return false;
    }

    public fi b(int i2) {
        this.f407b = i2;
        c(true);
        return this;
    }

    public fi b(String str) {
        this.f408b = str;
        return this;
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        a();
        jiVar.a(f402a);
        jiVar.a(f14314a);
        jiVar.a(this.f403a);
        jiVar.b();
        jiVar.a(f14315b);
        jiVar.a(this.f404a);
        jiVar.b();
        jiVar.a(c);
        jiVar.a(this.f407b);
        jiVar.b();
        if (this.f405a != null) {
            jiVar.a(d);
            jiVar.a(this.f405a);
            jiVar.b();
        }
        if (this.f408b != null && e()) {
            jiVar.a(e);
            jiVar.a(this.f408b);
            jiVar.b();
        }
        if (f()) {
            jiVar.a(f);
            jiVar.a(this.f409c);
            jiVar.b();
        }
        if (this.f410c != null && g()) {
            jiVar.a(g);
            jiVar.a(this.f410c);
            jiVar.b();
        }
        if (this.f412d != null && h()) {
            jiVar.a(h);
            jiVar.a(this.f412d);
            jiVar.b();
        }
        if (i()) {
            jiVar.a(i);
            jiVar.a(this.f411d);
            jiVar.b();
        }
        if (j()) {
            jiVar.a(j);
            jiVar.a(this.f413e);
            jiVar.b();
        }
        jiVar.c();
        jiVar.m523a();
    }

    public void b(boolean z) {
        this.f406a.set(1, z);
    }

    public boolean b() {
        return this.f406a.get(1);
    }

    public fi c(int i2) {
        this.f409c = i2;
        d(true);
        return this;
    }

    public fi c(String str) {
        this.f410c = str;
        return this;
    }

    public void c(boolean z) {
        this.f406a.set(2, z);
    }

    public boolean c() {
        return this.f406a.get(2);
    }

    public fi d(int i2) {
        this.f411d = i2;
        e(true);
        return this;
    }

    public fi d(String str) {
        this.f412d = str;
        return this;
    }

    public void d(boolean z) {
        this.f406a.set(3, z);
    }

    public boolean d() {
        return this.f405a != null;
    }

    public void e(boolean z) {
        this.f406a.set(4, z);
    }

    public boolean e() {
        return this.f408b != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof fi)) {
            return m307a((fi) obj);
        }
        return false;
    }

    public void f(boolean z) {
        this.f406a.set(5, z);
    }

    public boolean f() {
        return this.f406a.get(3);
    }

    public boolean g() {
        return this.f410c != null;
    }

    public boolean h() {
        return this.f412d != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f406a.get(4);
    }

    public boolean j() {
        return this.f406a.get(5);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("StatsEvent(");
        sb.append("chid:");
        sb.append((int) this.f403a);
        sb.append(", ");
        sb.append("type:");
        sb.append(this.f404a);
        sb.append(", ");
        sb.append("value:");
        sb.append(this.f407b);
        sb.append(", ");
        sb.append("connpt:");
        if (this.f405a == null) {
            sb.append("null");
        } else {
            sb.append(this.f405a);
        }
        if (e()) {
            sb.append(", ");
            sb.append("host:");
            if (this.f408b == null) {
                sb.append("null");
            } else {
                sb.append(this.f408b);
            }
        }
        if (f()) {
            sb.append(", ");
            sb.append("subvalue:");
            sb.append(this.f409c);
        }
        if (g()) {
            sb.append(", ");
            sb.append("annotation:");
            if (this.f410c == null) {
                sb.append("null");
            } else {
                sb.append(this.f410c);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("user:");
            if (this.f412d == null) {
                sb.append("null");
            } else {
                sb.append(this.f412d);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("time:");
            sb.append(this.f411d);
        }
        if (j()) {
            sb.append(", ");
            sb.append("clientIp:");
            sb.append(this.f413e);
        }
        sb.append(")");
        return sb.toString();
    }
}
