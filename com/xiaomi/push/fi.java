package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes9.dex */
public class fi implements ix<fi, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public byte f325a;

    /* renamed from: a  reason: collision with other field name */
    public int f326a;

    /* renamed from: a  reason: collision with other field name */
    public String f327a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f328a = new BitSet(6);

    /* renamed from: b  reason: collision with other field name */
    public int f329b;

    /* renamed from: b  reason: collision with other field name */
    public String f330b;

    /* renamed from: c  reason: collision with other field name */
    public int f331c;

    /* renamed from: c  reason: collision with other field name */
    public String f332c;

    /* renamed from: d  reason: collision with other field name */
    public int f333d;

    /* renamed from: d  reason: collision with other field name */
    public String f334d;

    /* renamed from: e  reason: collision with other field name */
    public int f335e;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f324a = new jn("StatsEvent");
    private static final jf a = new jf("", (byte) 3, 1);
    private static final jf b = new jf("", (byte) 8, 2);
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
            int compareTo = Boolean.valueOf(m271a()).compareTo(Boolean.valueOf(fiVar.m271a()));
            if (compareTo == 0) {
                if (!m271a() || (a11 = iy.a(this.f325a, fiVar.f325a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(fiVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a10 = iy.a(this.f326a, fiVar.f326a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(fiVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a9 = iy.a(this.f329b, fiVar.f329b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(fiVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a8 = iy.a(this.f327a, fiVar.f327a)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(fiVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a7 = iy.a(this.f330b, fiVar.f330b)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(fiVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a6 = iy.a(this.f331c, fiVar.f331c)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(fiVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a5 = iy.a(this.f332c, fiVar.f332c)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(fiVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a4 = iy.a(this.f334d, fiVar.f334d)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(fiVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a3 = iy.a(this.f333d, fiVar.f333d)) == 0) {
                                                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(fiVar.j()));
                                                                                    if (compareTo10 == 0) {
                                                                                        if (!j() || (a2 = iy.a(this.f335e, fiVar.f335e)) == 0) {
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
        this.f325a = b2;
        a(true);
        return this;
    }

    public fi a(int i2) {
        this.f326a = i2;
        b(true);
        return this;
    }

    public fi a(String str) {
        this.f327a = str;
        return this;
    }

    public void a() {
        if (this.f327a == null) {
            throw new jj("Required field 'connpt' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m484a();
        while (true) {
            jf m480a = jiVar.m480a();
            if (m480a.a == 0) {
                jiVar.f();
                if (!m271a()) {
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
            switch (m480a.f780a) {
                case 1:
                    if (m480a.a != 3) {
                        jl.a(jiVar, m480a.a);
                        break;
                    } else {
                        this.f325a = jiVar.a();
                        a(true);
                        break;
                    }
                case 2:
                    if (m480a.a != 8) {
                        jl.a(jiVar, m480a.a);
                        break;
                    } else {
                        this.f326a = jiVar.m478a();
                        b(true);
                        break;
                    }
                case 3:
                    if (m480a.a != 8) {
                        jl.a(jiVar, m480a.a);
                        break;
                    } else {
                        this.f329b = jiVar.m478a();
                        c(true);
                        break;
                    }
                case 4:
                    if (m480a.a != 11) {
                        jl.a(jiVar, m480a.a);
                        break;
                    } else {
                        this.f327a = jiVar.m485a();
                        break;
                    }
                case 5:
                    if (m480a.a != 11) {
                        jl.a(jiVar, m480a.a);
                        break;
                    } else {
                        this.f330b = jiVar.m485a();
                        break;
                    }
                case 6:
                    if (m480a.a != 8) {
                        jl.a(jiVar, m480a.a);
                        break;
                    } else {
                        this.f331c = jiVar.m478a();
                        d(true);
                        break;
                    }
                case 7:
                    if (m480a.a != 11) {
                        jl.a(jiVar, m480a.a);
                        break;
                    } else {
                        this.f332c = jiVar.m485a();
                        break;
                    }
                case 8:
                    if (m480a.a != 11) {
                        jl.a(jiVar, m480a.a);
                        break;
                    } else {
                        this.f334d = jiVar.m485a();
                        break;
                    }
                case 9:
                    if (m480a.a != 8) {
                        jl.a(jiVar, m480a.a);
                        break;
                    } else {
                        this.f333d = jiVar.m478a();
                        e(true);
                        break;
                    }
                case 10:
                    if (m480a.a != 8) {
                        jl.a(jiVar, m480a.a);
                        break;
                    } else {
                        this.f335e = jiVar.m478a();
                        f(true);
                        break;
                    }
                default:
                    jl.a(jiVar, m480a.a);
                    break;
            }
            jiVar.g();
        }
    }

    public void a(boolean z) {
        this.f328a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m271a() {
        return this.f328a.get(0);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m272a(fi fiVar) {
        if (fiVar != null && this.f325a == fiVar.f325a && this.f326a == fiVar.f326a && this.f329b == fiVar.f329b) {
            boolean d2 = d();
            boolean d3 = fiVar.d();
            if ((d2 || d3) && !(d2 && d3 && this.f327a.equals(fiVar.f327a))) {
                return false;
            }
            boolean e2 = e();
            boolean e3 = fiVar.e();
            if ((e2 || e3) && !(e2 && e3 && this.f330b.equals(fiVar.f330b))) {
                return false;
            }
            boolean f2 = f();
            boolean f3 = fiVar.f();
            if ((f2 || f3) && !(f2 && f3 && this.f331c == fiVar.f331c)) {
                return false;
            }
            boolean g2 = g();
            boolean g3 = fiVar.g();
            if ((g2 || g3) && !(g2 && g3 && this.f332c.equals(fiVar.f332c))) {
                return false;
            }
            boolean h2 = h();
            boolean h3 = fiVar.h();
            if ((h2 || h3) && !(h2 && h3 && this.f334d.equals(fiVar.f334d))) {
                return false;
            }
            boolean i2 = i();
            boolean i3 = fiVar.i();
            if ((i2 || i3) && !(i2 && i3 && this.f333d == fiVar.f333d)) {
                return false;
            }
            boolean j2 = j();
            boolean j3 = fiVar.j();
            return !(j2 || j3) || (j2 && j3 && this.f335e == fiVar.f335e);
        }
        return false;
    }

    public fi b(int i2) {
        this.f329b = i2;
        c(true);
        return this;
    }

    public fi b(String str) {
        this.f330b = str;
        return this;
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        a();
        jiVar.a(f324a);
        jiVar.a(a);
        jiVar.a(this.f325a);
        jiVar.b();
        jiVar.a(b);
        jiVar.a(this.f326a);
        jiVar.b();
        jiVar.a(c);
        jiVar.a(this.f329b);
        jiVar.b();
        if (this.f327a != null) {
            jiVar.a(d);
            jiVar.a(this.f327a);
            jiVar.b();
        }
        if (this.f330b != null && e()) {
            jiVar.a(e);
            jiVar.a(this.f330b);
            jiVar.b();
        }
        if (f()) {
            jiVar.a(f);
            jiVar.a(this.f331c);
            jiVar.b();
        }
        if (this.f332c != null && g()) {
            jiVar.a(g);
            jiVar.a(this.f332c);
            jiVar.b();
        }
        if (this.f334d != null && h()) {
            jiVar.a(h);
            jiVar.a(this.f334d);
            jiVar.b();
        }
        if (i()) {
            jiVar.a(i);
            jiVar.a(this.f333d);
            jiVar.b();
        }
        if (j()) {
            jiVar.a(j);
            jiVar.a(this.f335e);
            jiVar.b();
        }
        jiVar.c();
        jiVar.m488a();
    }

    public void b(boolean z) {
        this.f328a.set(1, z);
    }

    public boolean b() {
        return this.f328a.get(1);
    }

    public fi c(int i2) {
        this.f331c = i2;
        d(true);
        return this;
    }

    public fi c(String str) {
        this.f332c = str;
        return this;
    }

    public void c(boolean z) {
        this.f328a.set(2, z);
    }

    public boolean c() {
        return this.f328a.get(2);
    }

    public fi d(int i2) {
        this.f333d = i2;
        e(true);
        return this;
    }

    public fi d(String str) {
        this.f334d = str;
        return this;
    }

    public void d(boolean z) {
        this.f328a.set(3, z);
    }

    public boolean d() {
        return this.f327a != null;
    }

    public void e(boolean z) {
        this.f328a.set(4, z);
    }

    public boolean e() {
        return this.f330b != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof fi)) {
            return m272a((fi) obj);
        }
        return false;
    }

    public void f(boolean z) {
        this.f328a.set(5, z);
    }

    public boolean f() {
        return this.f328a.get(3);
    }

    public boolean g() {
        return this.f332c != null;
    }

    public boolean h() {
        return this.f334d != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f328a.get(4);
    }

    public boolean j() {
        return this.f328a.get(5);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("StatsEvent(");
        sb.append("chid:");
        sb.append((int) this.f325a);
        sb.append(", ");
        sb.append("type:");
        sb.append(this.f326a);
        sb.append(", ");
        sb.append("value:");
        sb.append(this.f329b);
        sb.append(", ");
        sb.append("connpt:");
        if (this.f327a == null) {
            sb.append("null");
        } else {
            sb.append(this.f327a);
        }
        if (e()) {
            sb.append(", ");
            sb.append("host:");
            if (this.f330b == null) {
                sb.append("null");
            } else {
                sb.append(this.f330b);
            }
        }
        if (f()) {
            sb.append(", ");
            sb.append("subvalue:");
            sb.append(this.f331c);
        }
        if (g()) {
            sb.append(", ");
            sb.append("annotation:");
            if (this.f332c == null) {
                sb.append("null");
            } else {
                sb.append(this.f332c);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("user:");
            if (this.f334d == null) {
                sb.append("null");
            } else {
                sb.append(this.f334d);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("time:");
            sb.append(this.f333d);
        }
        if (j()) {
            sb.append(", ");
            sb.append("clientIp:");
            sb.append(this.f335e);
        }
        sb.append(")");
        return sb.toString();
    }
}
