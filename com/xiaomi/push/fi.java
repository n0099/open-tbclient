package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes6.dex */
public class fi implements ix<fi, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public byte f402a;

    /* renamed from: a  reason: collision with other field name */
    public int f403a;

    /* renamed from: a  reason: collision with other field name */
    public String f404a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f405a = new BitSet(6);

    /* renamed from: b  reason: collision with other field name */
    public int f406b;

    /* renamed from: b  reason: collision with other field name */
    public String f407b;

    /* renamed from: c  reason: collision with other field name */
    public int f408c;

    /* renamed from: c  reason: collision with other field name */
    public String f409c;

    /* renamed from: d  reason: collision with other field name */
    public int f410d;

    /* renamed from: d  reason: collision with other field name */
    public String f411d;

    /* renamed from: e  reason: collision with other field name */
    public int f412e;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f401a = new jn("StatsEvent");

    /* renamed from: a  reason: collision with root package name */
    private static final jf f14014a = new jf("", (byte) 3, 1);

    /* renamed from: b  reason: collision with root package name */
    private static final jf f14015b = new jf("", (byte) 8, 2);
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
            int compareTo = Boolean.valueOf(m302a()).compareTo(Boolean.valueOf(fiVar.m302a()));
            if (compareTo == 0) {
                if (!m302a() || (a11 = iy.a(this.f402a, fiVar.f402a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(fiVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a10 = iy.a(this.f403a, fiVar.f403a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(fiVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a9 = iy.a(this.f406b, fiVar.f406b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(fiVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a8 = iy.a(this.f404a, fiVar.f404a)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(fiVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a7 = iy.a(this.f407b, fiVar.f407b)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(fiVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a6 = iy.a(this.f408c, fiVar.f408c)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(fiVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a5 = iy.a(this.f409c, fiVar.f409c)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(fiVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a4 = iy.a(this.f411d, fiVar.f411d)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(fiVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a3 = iy.a(this.f410d, fiVar.f410d)) == 0) {
                                                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(fiVar.j()));
                                                                                    if (compareTo10 == 0) {
                                                                                        if (!j() || (a2 = iy.a(this.f412e, fiVar.f412e)) == 0) {
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
        this.f402a = b2;
        a(true);
        return this;
    }

    public fi a(int i2) {
        this.f403a = i2;
        b(true);
        return this;
    }

    public fi a(String str) {
        this.f404a = str;
        return this;
    }

    public void a() {
        if (this.f404a == null) {
            throw new jj("Required field 'connpt' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m515a();
        while (true) {
            jf m511a = jiVar.m511a();
            if (m511a.f14171a == 0) {
                jiVar.f();
                if (!m302a()) {
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
            switch (m511a.f857a) {
                case 1:
                    if (m511a.f14171a != 3) {
                        jl.a(jiVar, m511a.f14171a);
                        break;
                    } else {
                        this.f402a = jiVar.a();
                        a(true);
                        break;
                    }
                case 2:
                    if (m511a.f14171a != 8) {
                        jl.a(jiVar, m511a.f14171a);
                        break;
                    } else {
                        this.f403a = jiVar.m509a();
                        b(true);
                        break;
                    }
                case 3:
                    if (m511a.f14171a != 8) {
                        jl.a(jiVar, m511a.f14171a);
                        break;
                    } else {
                        this.f406b = jiVar.m509a();
                        c(true);
                        break;
                    }
                case 4:
                    if (m511a.f14171a != 11) {
                        jl.a(jiVar, m511a.f14171a);
                        break;
                    } else {
                        this.f404a = jiVar.m516a();
                        break;
                    }
                case 5:
                    if (m511a.f14171a != 11) {
                        jl.a(jiVar, m511a.f14171a);
                        break;
                    } else {
                        this.f407b = jiVar.m516a();
                        break;
                    }
                case 6:
                    if (m511a.f14171a != 8) {
                        jl.a(jiVar, m511a.f14171a);
                        break;
                    } else {
                        this.f408c = jiVar.m509a();
                        d(true);
                        break;
                    }
                case 7:
                    if (m511a.f14171a != 11) {
                        jl.a(jiVar, m511a.f14171a);
                        break;
                    } else {
                        this.f409c = jiVar.m516a();
                        break;
                    }
                case 8:
                    if (m511a.f14171a != 11) {
                        jl.a(jiVar, m511a.f14171a);
                        break;
                    } else {
                        this.f411d = jiVar.m516a();
                        break;
                    }
                case 9:
                    if (m511a.f14171a != 8) {
                        jl.a(jiVar, m511a.f14171a);
                        break;
                    } else {
                        this.f410d = jiVar.m509a();
                        e(true);
                        break;
                    }
                case 10:
                    if (m511a.f14171a != 8) {
                        jl.a(jiVar, m511a.f14171a);
                        break;
                    } else {
                        this.f412e = jiVar.m509a();
                        f(true);
                        break;
                    }
                default:
                    jl.a(jiVar, m511a.f14171a);
                    break;
            }
            jiVar.g();
        }
    }

    public void a(boolean z) {
        this.f405a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m302a() {
        return this.f405a.get(0);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m303a(fi fiVar) {
        if (fiVar != null && this.f402a == fiVar.f402a && this.f403a == fiVar.f403a && this.f406b == fiVar.f406b) {
            boolean d2 = d();
            boolean d3 = fiVar.d();
            if ((d2 || d3) && !(d2 && d3 && this.f404a.equals(fiVar.f404a))) {
                return false;
            }
            boolean e2 = e();
            boolean e3 = fiVar.e();
            if ((e2 || e3) && !(e2 && e3 && this.f407b.equals(fiVar.f407b))) {
                return false;
            }
            boolean f2 = f();
            boolean f3 = fiVar.f();
            if ((f2 || f3) && !(f2 && f3 && this.f408c == fiVar.f408c)) {
                return false;
            }
            boolean g2 = g();
            boolean g3 = fiVar.g();
            if ((g2 || g3) && !(g2 && g3 && this.f409c.equals(fiVar.f409c))) {
                return false;
            }
            boolean h2 = h();
            boolean h3 = fiVar.h();
            if ((h2 || h3) && !(h2 && h3 && this.f411d.equals(fiVar.f411d))) {
                return false;
            }
            boolean i2 = i();
            boolean i3 = fiVar.i();
            if ((i2 || i3) && !(i2 && i3 && this.f410d == fiVar.f410d)) {
                return false;
            }
            boolean j2 = j();
            boolean j3 = fiVar.j();
            return !(j2 || j3) || (j2 && j3 && this.f412e == fiVar.f412e);
        }
        return false;
    }

    public fi b(int i2) {
        this.f406b = i2;
        c(true);
        return this;
    }

    public fi b(String str) {
        this.f407b = str;
        return this;
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        a();
        jiVar.a(f401a);
        jiVar.a(f14014a);
        jiVar.a(this.f402a);
        jiVar.b();
        jiVar.a(f14015b);
        jiVar.a(this.f403a);
        jiVar.b();
        jiVar.a(c);
        jiVar.a(this.f406b);
        jiVar.b();
        if (this.f404a != null) {
            jiVar.a(d);
            jiVar.a(this.f404a);
            jiVar.b();
        }
        if (this.f407b != null && e()) {
            jiVar.a(e);
            jiVar.a(this.f407b);
            jiVar.b();
        }
        if (f()) {
            jiVar.a(f);
            jiVar.a(this.f408c);
            jiVar.b();
        }
        if (this.f409c != null && g()) {
            jiVar.a(g);
            jiVar.a(this.f409c);
            jiVar.b();
        }
        if (this.f411d != null && h()) {
            jiVar.a(h);
            jiVar.a(this.f411d);
            jiVar.b();
        }
        if (i()) {
            jiVar.a(i);
            jiVar.a(this.f410d);
            jiVar.b();
        }
        if (j()) {
            jiVar.a(j);
            jiVar.a(this.f412e);
            jiVar.b();
        }
        jiVar.c();
        jiVar.m519a();
    }

    public void b(boolean z) {
        this.f405a.set(1, z);
    }

    public boolean b() {
        return this.f405a.get(1);
    }

    public fi c(int i2) {
        this.f408c = i2;
        d(true);
        return this;
    }

    public fi c(String str) {
        this.f409c = str;
        return this;
    }

    public void c(boolean z) {
        this.f405a.set(2, z);
    }

    public boolean c() {
        return this.f405a.get(2);
    }

    public fi d(int i2) {
        this.f410d = i2;
        e(true);
        return this;
    }

    public fi d(String str) {
        this.f411d = str;
        return this;
    }

    public void d(boolean z) {
        this.f405a.set(3, z);
    }

    public boolean d() {
        return this.f404a != null;
    }

    public void e(boolean z) {
        this.f405a.set(4, z);
    }

    public boolean e() {
        return this.f407b != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof fi)) {
            return m303a((fi) obj);
        }
        return false;
    }

    public void f(boolean z) {
        this.f405a.set(5, z);
    }

    public boolean f() {
        return this.f405a.get(3);
    }

    public boolean g() {
        return this.f409c != null;
    }

    public boolean h() {
        return this.f411d != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f405a.get(4);
    }

    public boolean j() {
        return this.f405a.get(5);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("StatsEvent(");
        sb.append("chid:");
        sb.append((int) this.f402a);
        sb.append(", ");
        sb.append("type:");
        sb.append(this.f403a);
        sb.append(", ");
        sb.append("value:");
        sb.append(this.f406b);
        sb.append(", ");
        sb.append("connpt:");
        if (this.f404a == null) {
            sb.append("null");
        } else {
            sb.append(this.f404a);
        }
        if (e()) {
            sb.append(", ");
            sb.append("host:");
            if (this.f407b == null) {
                sb.append("null");
            } else {
                sb.append(this.f407b);
            }
        }
        if (f()) {
            sb.append(", ");
            sb.append("subvalue:");
            sb.append(this.f408c);
        }
        if (g()) {
            sb.append(", ");
            sb.append("annotation:");
            if (this.f409c == null) {
                sb.append("null");
            } else {
                sb.append(this.f409c);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("user:");
            if (this.f411d == null) {
                sb.append("null");
            } else {
                sb.append(this.f411d);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("time:");
            sb.append(this.f410d);
        }
        if (j()) {
            sb.append(", ");
            sb.append("clientIp:");
            sb.append(this.f412e);
        }
        sb.append(")");
        return sb.toString();
    }
}
