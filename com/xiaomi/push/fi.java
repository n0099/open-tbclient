package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes12.dex */
public class fi implements ix<fi, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public byte f321a;

    /* renamed from: a  reason: collision with other field name */
    public int f322a;

    /* renamed from: a  reason: collision with other field name */
    public String f323a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f324a = new BitSet(6);

    /* renamed from: b  reason: collision with other field name */
    public int f325b;

    /* renamed from: b  reason: collision with other field name */
    public String f326b;

    /* renamed from: c  reason: collision with other field name */
    public int f327c;

    /* renamed from: c  reason: collision with other field name */
    public String f328c;

    /* renamed from: d  reason: collision with other field name */
    public int f329d;

    /* renamed from: d  reason: collision with other field name */
    public String f330d;

    /* renamed from: e  reason: collision with other field name */
    public int f331e;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f320a = new jn("StatsEvent");

    /* renamed from: a  reason: collision with root package name */
    private static final jf f4901a = new jf("", (byte) 3, 1);
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
            int compareTo = Boolean.valueOf(m276a()).compareTo(Boolean.valueOf(fiVar.m276a()));
            if (compareTo == 0) {
                if (!m276a() || (a11 = iy.a(this.f321a, fiVar.f321a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(fiVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a10 = iy.a(this.f322a, fiVar.f322a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(fiVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a9 = iy.a(this.f325b, fiVar.f325b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(fiVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a8 = iy.a(this.f323a, fiVar.f323a)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(fiVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a7 = iy.a(this.f326b, fiVar.f326b)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(fiVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a6 = iy.a(this.f327c, fiVar.f327c)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(fiVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a5 = iy.a(this.f328c, fiVar.f328c)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(fiVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a4 = iy.a(this.f330d, fiVar.f330d)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(fiVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a3 = iy.a(this.f329d, fiVar.f329d)) == 0) {
                                                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(fiVar.j()));
                                                                                    if (compareTo10 == 0) {
                                                                                        if (!j() || (a2 = iy.a(this.f331e, fiVar.f331e)) == 0) {
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
        this.f321a = b2;
        a(true);
        return this;
    }

    public fi a(int i2) {
        this.f322a = i2;
        b(true);
        return this;
    }

    public fi a(String str) {
        this.f323a = str;
        return this;
    }

    public void a() {
        if (this.f323a == null) {
            throw new jj("Required field 'connpt' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m489a();
        while (true) {
            jf m485a = jiVar.m485a();
            if (m485a.f4998a == 0) {
                jiVar.f();
                if (!m276a()) {
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
            switch (m485a.f776a) {
                case 1:
                    if (m485a.f4998a != 3) {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    } else {
                        this.f321a = jiVar.a();
                        a(true);
                        break;
                    }
                case 2:
                    if (m485a.f4998a != 8) {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    } else {
                        this.f322a = jiVar.m483a();
                        b(true);
                        break;
                    }
                case 3:
                    if (m485a.f4998a != 8) {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    } else {
                        this.f325b = jiVar.m483a();
                        c(true);
                        break;
                    }
                case 4:
                    if (m485a.f4998a != 11) {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    } else {
                        this.f323a = jiVar.m490a();
                        break;
                    }
                case 5:
                    if (m485a.f4998a != 11) {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    } else {
                        this.f326b = jiVar.m490a();
                        break;
                    }
                case 6:
                    if (m485a.f4998a != 8) {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    } else {
                        this.f327c = jiVar.m483a();
                        d(true);
                        break;
                    }
                case 7:
                    if (m485a.f4998a != 11) {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    } else {
                        this.f328c = jiVar.m490a();
                        break;
                    }
                case 8:
                    if (m485a.f4998a != 11) {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    } else {
                        this.f330d = jiVar.m490a();
                        break;
                    }
                case 9:
                    if (m485a.f4998a != 8) {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    } else {
                        this.f329d = jiVar.m483a();
                        e(true);
                        break;
                    }
                case 10:
                    if (m485a.f4998a != 8) {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    } else {
                        this.f331e = jiVar.m483a();
                        f(true);
                        break;
                    }
                default:
                    jl.a(jiVar, m485a.f4998a);
                    break;
            }
            jiVar.g();
        }
    }

    public void a(boolean z) {
        this.f324a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m276a() {
        return this.f324a.get(0);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m277a(fi fiVar) {
        if (fiVar != null && this.f321a == fiVar.f321a && this.f322a == fiVar.f322a && this.f325b == fiVar.f325b) {
            boolean d2 = d();
            boolean d3 = fiVar.d();
            if ((d2 || d3) && !(d2 && d3 && this.f323a.equals(fiVar.f323a))) {
                return false;
            }
            boolean e2 = e();
            boolean e3 = fiVar.e();
            if ((e2 || e3) && !(e2 && e3 && this.f326b.equals(fiVar.f326b))) {
                return false;
            }
            boolean f2 = f();
            boolean f3 = fiVar.f();
            if ((f2 || f3) && !(f2 && f3 && this.f327c == fiVar.f327c)) {
                return false;
            }
            boolean g2 = g();
            boolean g3 = fiVar.g();
            if ((g2 || g3) && !(g2 && g3 && this.f328c.equals(fiVar.f328c))) {
                return false;
            }
            boolean h2 = h();
            boolean h3 = fiVar.h();
            if ((h2 || h3) && !(h2 && h3 && this.f330d.equals(fiVar.f330d))) {
                return false;
            }
            boolean i2 = i();
            boolean i3 = fiVar.i();
            if ((i2 || i3) && !(i2 && i3 && this.f329d == fiVar.f329d)) {
                return false;
            }
            boolean j2 = j();
            boolean j3 = fiVar.j();
            return !(j2 || j3) || (j2 && j3 && this.f331e == fiVar.f331e);
        }
        return false;
    }

    public fi b(int i2) {
        this.f325b = i2;
        c(true);
        return this;
    }

    public fi b(String str) {
        this.f326b = str;
        return this;
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        a();
        jiVar.a(f320a);
        jiVar.a(f4901a);
        jiVar.a(this.f321a);
        jiVar.b();
        jiVar.a(b);
        jiVar.a(this.f322a);
        jiVar.b();
        jiVar.a(c);
        jiVar.a(this.f325b);
        jiVar.b();
        if (this.f323a != null) {
            jiVar.a(d);
            jiVar.a(this.f323a);
            jiVar.b();
        }
        if (this.f326b != null && e()) {
            jiVar.a(e);
            jiVar.a(this.f326b);
            jiVar.b();
        }
        if (f()) {
            jiVar.a(f);
            jiVar.a(this.f327c);
            jiVar.b();
        }
        if (this.f328c != null && g()) {
            jiVar.a(g);
            jiVar.a(this.f328c);
            jiVar.b();
        }
        if (this.f330d != null && h()) {
            jiVar.a(h);
            jiVar.a(this.f330d);
            jiVar.b();
        }
        if (i()) {
            jiVar.a(i);
            jiVar.a(this.f329d);
            jiVar.b();
        }
        if (j()) {
            jiVar.a(j);
            jiVar.a(this.f331e);
            jiVar.b();
        }
        jiVar.c();
        jiVar.m493a();
    }

    public void b(boolean z) {
        this.f324a.set(1, z);
    }

    public boolean b() {
        return this.f324a.get(1);
    }

    public fi c(int i2) {
        this.f327c = i2;
        d(true);
        return this;
    }

    public fi c(String str) {
        this.f328c = str;
        return this;
    }

    public void c(boolean z) {
        this.f324a.set(2, z);
    }

    public boolean c() {
        return this.f324a.get(2);
    }

    public fi d(int i2) {
        this.f329d = i2;
        e(true);
        return this;
    }

    public fi d(String str) {
        this.f330d = str;
        return this;
    }

    public void d(boolean z) {
        this.f324a.set(3, z);
    }

    public boolean d() {
        return this.f323a != null;
    }

    public void e(boolean z) {
        this.f324a.set(4, z);
    }

    public boolean e() {
        return this.f326b != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof fi)) {
            return m277a((fi) obj);
        }
        return false;
    }

    public void f(boolean z) {
        this.f324a.set(5, z);
    }

    public boolean f() {
        return this.f324a.get(3);
    }

    public boolean g() {
        return this.f328c != null;
    }

    public boolean h() {
        return this.f330d != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f324a.get(4);
    }

    public boolean j() {
        return this.f324a.get(5);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("StatsEvent(");
        sb.append("chid:");
        sb.append((int) this.f321a);
        sb.append(", ");
        sb.append("type:");
        sb.append(this.f322a);
        sb.append(", ");
        sb.append("value:");
        sb.append(this.f325b);
        sb.append(", ");
        sb.append("connpt:");
        if (this.f323a == null) {
            sb.append("null");
        } else {
            sb.append(this.f323a);
        }
        if (e()) {
            sb.append(", ");
            sb.append("host:");
            if (this.f326b == null) {
                sb.append("null");
            } else {
                sb.append(this.f326b);
            }
        }
        if (f()) {
            sb.append(", ");
            sb.append("subvalue:");
            sb.append(this.f327c);
        }
        if (g()) {
            sb.append(", ");
            sb.append("annotation:");
            if (this.f328c == null) {
                sb.append("null");
            } else {
                sb.append(this.f328c);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("user:");
            if (this.f330d == null) {
                sb.append("null");
            } else {
                sb.append(this.f330d);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("time:");
            sb.append(this.f329d);
        }
        if (j()) {
            sb.append(", ");
            sb.append("clientIp:");
            sb.append(this.f331e);
        }
        sb.append(")");
        return sb.toString();
    }
}
