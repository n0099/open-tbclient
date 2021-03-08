package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes5.dex */
public class fi implements ix<fi, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public byte f323a;

    /* renamed from: a  reason: collision with other field name */
    public int f324a;

    /* renamed from: a  reason: collision with other field name */
    public String f325a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f326a = new BitSet(6);

    /* renamed from: b  reason: collision with other field name */
    public int f327b;

    /* renamed from: b  reason: collision with other field name */
    public String f328b;

    /* renamed from: c  reason: collision with other field name */
    public int f329c;

    /* renamed from: c  reason: collision with other field name */
    public String f330c;

    /* renamed from: d  reason: collision with other field name */
    public int f331d;

    /* renamed from: d  reason: collision with other field name */
    public String f332d;

    /* renamed from: e  reason: collision with other field name */
    public int f333e;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f322a = new jn("StatsEvent");

    /* renamed from: a  reason: collision with root package name */
    private static final jf f8366a = new jf("", (byte) 3, 1);
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
            int compareTo = Boolean.valueOf(m280a()).compareTo(Boolean.valueOf(fiVar.m280a()));
            if (compareTo == 0) {
                if (!m280a() || (a11 = iy.a(this.f323a, fiVar.f323a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(fiVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a10 = iy.a(this.f324a, fiVar.f324a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(fiVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a9 = iy.a(this.f327b, fiVar.f327b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(fiVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a8 = iy.a(this.f325a, fiVar.f325a)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(fiVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a7 = iy.a(this.f328b, fiVar.f328b)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(fiVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a6 = iy.a(this.f329c, fiVar.f329c)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(fiVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a5 = iy.a(this.f330c, fiVar.f330c)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(fiVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a4 = iy.a(this.f332d, fiVar.f332d)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(fiVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a3 = iy.a(this.f331d, fiVar.f331d)) == 0) {
                                                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(fiVar.j()));
                                                                                    if (compareTo10 == 0) {
                                                                                        if (!j() || (a2 = iy.a(this.f333e, fiVar.f333e)) == 0) {
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
        this.f323a = b2;
        a(true);
        return this;
    }

    public fi a(int i2) {
        this.f324a = i2;
        b(true);
        return this;
    }

    public fi a(String str) {
        this.f325a = str;
        return this;
    }

    public void a() {
        if (this.f325a == null) {
            throw new jj("Required field 'connpt' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m493a();
        while (true) {
            jf m489a = jiVar.m489a();
            if (m489a.f8463a == 0) {
                jiVar.f();
                if (!m280a()) {
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
            switch (m489a.f778a) {
                case 1:
                    if (m489a.f8463a != 3) {
                        jl.a(jiVar, m489a.f8463a);
                        break;
                    } else {
                        this.f323a = jiVar.a();
                        a(true);
                        break;
                    }
                case 2:
                    if (m489a.f8463a != 8) {
                        jl.a(jiVar, m489a.f8463a);
                        break;
                    } else {
                        this.f324a = jiVar.m487a();
                        b(true);
                        break;
                    }
                case 3:
                    if (m489a.f8463a != 8) {
                        jl.a(jiVar, m489a.f8463a);
                        break;
                    } else {
                        this.f327b = jiVar.m487a();
                        c(true);
                        break;
                    }
                case 4:
                    if (m489a.f8463a != 11) {
                        jl.a(jiVar, m489a.f8463a);
                        break;
                    } else {
                        this.f325a = jiVar.m494a();
                        break;
                    }
                case 5:
                    if (m489a.f8463a != 11) {
                        jl.a(jiVar, m489a.f8463a);
                        break;
                    } else {
                        this.f328b = jiVar.m494a();
                        break;
                    }
                case 6:
                    if (m489a.f8463a != 8) {
                        jl.a(jiVar, m489a.f8463a);
                        break;
                    } else {
                        this.f329c = jiVar.m487a();
                        d(true);
                        break;
                    }
                case 7:
                    if (m489a.f8463a != 11) {
                        jl.a(jiVar, m489a.f8463a);
                        break;
                    } else {
                        this.f330c = jiVar.m494a();
                        break;
                    }
                case 8:
                    if (m489a.f8463a != 11) {
                        jl.a(jiVar, m489a.f8463a);
                        break;
                    } else {
                        this.f332d = jiVar.m494a();
                        break;
                    }
                case 9:
                    if (m489a.f8463a != 8) {
                        jl.a(jiVar, m489a.f8463a);
                        break;
                    } else {
                        this.f331d = jiVar.m487a();
                        e(true);
                        break;
                    }
                case 10:
                    if (m489a.f8463a != 8) {
                        jl.a(jiVar, m489a.f8463a);
                        break;
                    } else {
                        this.f333e = jiVar.m487a();
                        f(true);
                        break;
                    }
                default:
                    jl.a(jiVar, m489a.f8463a);
                    break;
            }
            jiVar.g();
        }
    }

    public void a(boolean z) {
        this.f326a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m280a() {
        return this.f326a.get(0);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m281a(fi fiVar) {
        if (fiVar != null && this.f323a == fiVar.f323a && this.f324a == fiVar.f324a && this.f327b == fiVar.f327b) {
            boolean d2 = d();
            boolean d3 = fiVar.d();
            if ((d2 || d3) && !(d2 && d3 && this.f325a.equals(fiVar.f325a))) {
                return false;
            }
            boolean e2 = e();
            boolean e3 = fiVar.e();
            if ((e2 || e3) && !(e2 && e3 && this.f328b.equals(fiVar.f328b))) {
                return false;
            }
            boolean f2 = f();
            boolean f3 = fiVar.f();
            if ((f2 || f3) && !(f2 && f3 && this.f329c == fiVar.f329c)) {
                return false;
            }
            boolean g2 = g();
            boolean g3 = fiVar.g();
            if ((g2 || g3) && !(g2 && g3 && this.f330c.equals(fiVar.f330c))) {
                return false;
            }
            boolean h2 = h();
            boolean h3 = fiVar.h();
            if ((h2 || h3) && !(h2 && h3 && this.f332d.equals(fiVar.f332d))) {
                return false;
            }
            boolean i2 = i();
            boolean i3 = fiVar.i();
            if ((i2 || i3) && !(i2 && i3 && this.f331d == fiVar.f331d)) {
                return false;
            }
            boolean j2 = j();
            boolean j3 = fiVar.j();
            return !(j2 || j3) || (j2 && j3 && this.f333e == fiVar.f333e);
        }
        return false;
    }

    public fi b(int i2) {
        this.f327b = i2;
        c(true);
        return this;
    }

    public fi b(String str) {
        this.f328b = str;
        return this;
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        a();
        jiVar.a(f322a);
        jiVar.a(f8366a);
        jiVar.a(this.f323a);
        jiVar.b();
        jiVar.a(b);
        jiVar.a(this.f324a);
        jiVar.b();
        jiVar.a(c);
        jiVar.a(this.f327b);
        jiVar.b();
        if (this.f325a != null) {
            jiVar.a(d);
            jiVar.a(this.f325a);
            jiVar.b();
        }
        if (this.f328b != null && e()) {
            jiVar.a(e);
            jiVar.a(this.f328b);
            jiVar.b();
        }
        if (f()) {
            jiVar.a(f);
            jiVar.a(this.f329c);
            jiVar.b();
        }
        if (this.f330c != null && g()) {
            jiVar.a(g);
            jiVar.a(this.f330c);
            jiVar.b();
        }
        if (this.f332d != null && h()) {
            jiVar.a(h);
            jiVar.a(this.f332d);
            jiVar.b();
        }
        if (i()) {
            jiVar.a(i);
            jiVar.a(this.f331d);
            jiVar.b();
        }
        if (j()) {
            jiVar.a(j);
            jiVar.a(this.f333e);
            jiVar.b();
        }
        jiVar.c();
        jiVar.m497a();
    }

    public void b(boolean z) {
        this.f326a.set(1, z);
    }

    public boolean b() {
        return this.f326a.get(1);
    }

    public fi c(int i2) {
        this.f329c = i2;
        d(true);
        return this;
    }

    public fi c(String str) {
        this.f330c = str;
        return this;
    }

    public void c(boolean z) {
        this.f326a.set(2, z);
    }

    public boolean c() {
        return this.f326a.get(2);
    }

    public fi d(int i2) {
        this.f331d = i2;
        e(true);
        return this;
    }

    public fi d(String str) {
        this.f332d = str;
        return this;
    }

    public void d(boolean z) {
        this.f326a.set(3, z);
    }

    public boolean d() {
        return this.f325a != null;
    }

    public void e(boolean z) {
        this.f326a.set(4, z);
    }

    public boolean e() {
        return this.f328b != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof fi)) {
            return m281a((fi) obj);
        }
        return false;
    }

    public void f(boolean z) {
        this.f326a.set(5, z);
    }

    public boolean f() {
        return this.f326a.get(3);
    }

    public boolean g() {
        return this.f330c != null;
    }

    public boolean h() {
        return this.f332d != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f326a.get(4);
    }

    public boolean j() {
        return this.f326a.get(5);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("StatsEvent(");
        sb.append("chid:");
        sb.append((int) this.f323a);
        sb.append(", ");
        sb.append("type:");
        sb.append(this.f324a);
        sb.append(", ");
        sb.append("value:");
        sb.append(this.f327b);
        sb.append(", ");
        sb.append("connpt:");
        if (this.f325a == null) {
            sb.append("null");
        } else {
            sb.append(this.f325a);
        }
        if (e()) {
            sb.append(", ");
            sb.append("host:");
            if (this.f328b == null) {
                sb.append("null");
            } else {
                sb.append(this.f328b);
            }
        }
        if (f()) {
            sb.append(", ");
            sb.append("subvalue:");
            sb.append(this.f329c);
        }
        if (g()) {
            sb.append(", ");
            sb.append("annotation:");
            if (this.f330c == null) {
                sb.append("null");
            } else {
                sb.append(this.f330c);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("user:");
            if (this.f332d == null) {
                sb.append("null");
            } else {
                sb.append(this.f332d);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("time:");
            sb.append(this.f331d);
        }
        if (j()) {
            sb.append(", ");
            sb.append("clientIp:");
            sb.append(this.f333e);
        }
        sb.append(")");
        return sb.toString();
    }
}
