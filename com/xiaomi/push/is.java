package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes6.dex */
public class is implements ix<is, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f801a;

    /* renamed from: a  reason: collision with other field name */
    public ib f802a;

    /* renamed from: a  reason: collision with other field name */
    public String f803a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f804a = new BitSet(2);

    /* renamed from: a  reason: collision with other field name */
    public boolean f805a = true;

    /* renamed from: b  reason: collision with other field name */
    public String f806b;

    /* renamed from: c  reason: collision with other field name */
    public String f807c;

    /* renamed from: d  reason: collision with other field name */
    public String f808d;

    /* renamed from: e  reason: collision with other field name */
    public String f809e;

    /* renamed from: f  reason: collision with other field name */
    public String f810f;

    /* renamed from: g  reason: collision with other field name */
    public String f811g;

    /* renamed from: h  reason: collision with other field name */
    public String f812h;

    /* renamed from: i  reason: collision with other field name */
    public String f813i;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f800a = new jn("XmPushActionUnRegistration");

    /* renamed from: a  reason: collision with root package name */
    private static final jf f14153a = new jf("", Constants.GZIP_CAST_TYPE, 1);

    /* renamed from: b  reason: collision with root package name */
    private static final jf f14154b = new jf("", (byte) 12, 2);
    private static final jf c = new jf("", Constants.GZIP_CAST_TYPE, 3);
    private static final jf d = new jf("", Constants.GZIP_CAST_TYPE, 4);
    private static final jf e = new jf("", Constants.GZIP_CAST_TYPE, 5);
    private static final jf f = new jf("", Constants.GZIP_CAST_TYPE, 6);
    private static final jf g = new jf("", Constants.GZIP_CAST_TYPE, 7);
    private static final jf h = new jf("", Constants.GZIP_CAST_TYPE, 8);
    private static final jf i = new jf("", Constants.GZIP_CAST_TYPE, 9);
    private static final jf j = new jf("", Constants.GZIP_CAST_TYPE, 10);
    private static final jf k = new jf("", (byte) 2, 11);
    private static final jf l = new jf("", (byte) 10, 12);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(is isVar) {
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
        if (getClass().equals(isVar.getClass())) {
            int compareTo = Boolean.valueOf(m494a()).compareTo(Boolean.valueOf(isVar.m494a()));
            if (compareTo == 0) {
                if (!m494a() || (a13 = iy.a(this.f803a, isVar.f803a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(isVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a12 = iy.a(this.f802a, isVar.f802a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(isVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a11 = iy.a(this.f806b, isVar.f806b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(isVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a10 = iy.a(this.f807c, isVar.f807c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(isVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a9 = iy.a(this.f808d, isVar.f808d)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(isVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a8 = iy.a(this.f809e, isVar.f809e)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(isVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a7 = iy.a(this.f810f, isVar.f810f)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(isVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a6 = iy.a(this.f811g, isVar.f811g)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(isVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a5 = iy.a(this.f812h, isVar.f812h)) == 0) {
                                                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(isVar.j()));
                                                                                    if (compareTo10 == 0) {
                                                                                        if (!j() || (a4 = iy.a(this.f813i, isVar.f813i)) == 0) {
                                                                                            int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(isVar.k()));
                                                                                            if (compareTo11 == 0) {
                                                                                                if (!k() || (a3 = iy.a(this.f805a, isVar.f805a)) == 0) {
                                                                                                    int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(isVar.l()));
                                                                                                    if (compareTo12 == 0) {
                                                                                                        if (!l() || (a2 = iy.a(this.f801a, isVar.f801a)) == 0) {
                                                                                                            return 0;
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
        return getClass().getName().compareTo(isVar.getClass().getName());
    }

    public is a(String str) {
        this.f806b = str;
        return this;
    }

    public void a() {
        if (this.f806b == null) {
            throw new jj("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f807c == null) {
            throw new jj("Required field 'appId' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m515a();
        while (true) {
            jf m511a = jiVar.m511a();
            if (m511a.f14171a == 0) {
                jiVar.f();
                a();
                return;
            }
            switch (m511a.f857a) {
                case 1:
                    if (m511a.f14171a != 11) {
                        jl.a(jiVar, m511a.f14171a);
                        break;
                    } else {
                        this.f803a = jiVar.m516a();
                        break;
                    }
                case 2:
                    if (m511a.f14171a != 12) {
                        jl.a(jiVar, m511a.f14171a);
                        break;
                    } else {
                        this.f802a = new ib();
                        this.f802a.a(jiVar);
                        break;
                    }
                case 3:
                    if (m511a.f14171a != 11) {
                        jl.a(jiVar, m511a.f14171a);
                        break;
                    } else {
                        this.f806b = jiVar.m516a();
                        break;
                    }
                case 4:
                    if (m511a.f14171a != 11) {
                        jl.a(jiVar, m511a.f14171a);
                        break;
                    } else {
                        this.f807c = jiVar.m516a();
                        break;
                    }
                case 5:
                    if (m511a.f14171a != 11) {
                        jl.a(jiVar, m511a.f14171a);
                        break;
                    } else {
                        this.f808d = jiVar.m516a();
                        break;
                    }
                case 6:
                    if (m511a.f14171a != 11) {
                        jl.a(jiVar, m511a.f14171a);
                        break;
                    } else {
                        this.f809e = jiVar.m516a();
                        break;
                    }
                case 7:
                    if (m511a.f14171a != 11) {
                        jl.a(jiVar, m511a.f14171a);
                        break;
                    } else {
                        this.f810f = jiVar.m516a();
                        break;
                    }
                case 8:
                    if (m511a.f14171a != 11) {
                        jl.a(jiVar, m511a.f14171a);
                        break;
                    } else {
                        this.f811g = jiVar.m516a();
                        break;
                    }
                case 9:
                    if (m511a.f14171a != 11) {
                        jl.a(jiVar, m511a.f14171a);
                        break;
                    } else {
                        this.f812h = jiVar.m516a();
                        break;
                    }
                case 10:
                    if (m511a.f14171a != 11) {
                        jl.a(jiVar, m511a.f14171a);
                        break;
                    } else {
                        this.f813i = jiVar.m516a();
                        break;
                    }
                case 11:
                    if (m511a.f14171a != 2) {
                        jl.a(jiVar, m511a.f14171a);
                        break;
                    } else {
                        this.f805a = jiVar.m520a();
                        a(true);
                        break;
                    }
                case 12:
                    if (m511a.f14171a != 10) {
                        jl.a(jiVar, m511a.f14171a);
                        break;
                    } else {
                        this.f801a = jiVar.m510a();
                        b(true);
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
        this.f804a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m494a() {
        return this.f803a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m495a(is isVar) {
        if (isVar == null) {
            return false;
        }
        boolean m494a = m494a();
        boolean m494a2 = isVar.m494a();
        if ((m494a || m494a2) && !(m494a && m494a2 && this.f803a.equals(isVar.f803a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = isVar.b();
        if ((b2 || b3) && !(b2 && b3 && this.f802a.m424a(isVar.f802a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = isVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f806b.equals(isVar.f806b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = isVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f807c.equals(isVar.f807c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = isVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f808d.equals(isVar.f808d))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = isVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f809e.equals(isVar.f809e))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = isVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f810f.equals(isVar.f810f))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = isVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f811g.equals(isVar.f811g))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = isVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f812h.equals(isVar.f812h))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = isVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f813i.equals(isVar.f813i))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = isVar.k();
        if ((k2 || k3) && !(k2 && k3 && this.f805a == isVar.f805a)) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = isVar.l();
        return !(l2 || l3) || (l2 && l3 && this.f801a == isVar.f801a);
    }

    public is b(String str) {
        this.f807c = str;
        return this;
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        a();
        jiVar.a(f800a);
        if (this.f803a != null && m494a()) {
            jiVar.a(f14153a);
            jiVar.a(this.f803a);
            jiVar.b();
        }
        if (this.f802a != null && b()) {
            jiVar.a(f14154b);
            this.f802a.b(jiVar);
            jiVar.b();
        }
        if (this.f806b != null) {
            jiVar.a(c);
            jiVar.a(this.f806b);
            jiVar.b();
        }
        if (this.f807c != null) {
            jiVar.a(d);
            jiVar.a(this.f807c);
            jiVar.b();
        }
        if (this.f808d != null && e()) {
            jiVar.a(e);
            jiVar.a(this.f808d);
            jiVar.b();
        }
        if (this.f809e != null && f()) {
            jiVar.a(f);
            jiVar.a(this.f809e);
            jiVar.b();
        }
        if (this.f810f != null && g()) {
            jiVar.a(g);
            jiVar.a(this.f810f);
            jiVar.b();
        }
        if (this.f811g != null && h()) {
            jiVar.a(h);
            jiVar.a(this.f811g);
            jiVar.b();
        }
        if (this.f812h != null && i()) {
            jiVar.a(i);
            jiVar.a(this.f812h);
            jiVar.b();
        }
        if (this.f813i != null && j()) {
            jiVar.a(j);
            jiVar.a(this.f813i);
            jiVar.b();
        }
        if (k()) {
            jiVar.a(k);
            jiVar.a(this.f805a);
            jiVar.b();
        }
        if (l()) {
            jiVar.a(l);
            jiVar.a(this.f801a);
            jiVar.b();
        }
        jiVar.c();
        jiVar.m519a();
    }

    public void b(boolean z) {
        this.f804a.set(1, z);
    }

    public boolean b() {
        return this.f802a != null;
    }

    public is c(String str) {
        this.f808d = str;
        return this;
    }

    public boolean c() {
        return this.f806b != null;
    }

    public is d(String str) {
        this.f810f = str;
        return this;
    }

    public boolean d() {
        return this.f807c != null;
    }

    public is e(String str) {
        this.f811g = str;
        return this;
    }

    public boolean e() {
        return this.f808d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof is)) {
            return m495a((is) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f809e != null;
    }

    public boolean g() {
        return this.f810f != null;
    }

    public boolean h() {
        return this.f811g != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f812h != null;
    }

    public boolean j() {
        return this.f813i != null;
    }

    public boolean k() {
        return this.f804a.get(0);
    }

    public boolean l() {
        return this.f804a.get(1);
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionUnRegistration(");
        boolean z2 = true;
        if (m494a()) {
            sb.append("debug:");
            if (this.f803a == null) {
                sb.append("null");
            } else {
                sb.append(this.f803a);
            }
            z2 = false;
        }
        if (b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f802a == null) {
                sb.append("null");
            } else {
                sb.append(this.f802a);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f806b == null) {
            sb.append("null");
        } else {
            sb.append(this.f806b);
        }
        sb.append(", ");
        sb.append("appId:");
        if (this.f807c == null) {
            sb.append("null");
        } else {
            sb.append(this.f807c);
        }
        if (e()) {
            sb.append(", ");
            sb.append("regId:");
            if (this.f808d == null) {
                sb.append("null");
            } else {
                sb.append(this.f808d);
            }
        }
        if (f()) {
            sb.append(", ");
            sb.append("appVersion:");
            if (this.f809e == null) {
                sb.append("null");
            } else {
                sb.append(this.f809e);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f810f == null) {
                sb.append("null");
            } else {
                sb.append(this.f810f);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("token:");
            if (this.f811g == null) {
                sb.append("null");
            } else {
                sb.append(this.f811g);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("deviceId:");
            if (this.f812h == null) {
                sb.append("null");
            } else {
                sb.append(this.f812h);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("aliasName:");
            if (this.f813i == null) {
                sb.append("null");
            } else {
                sb.append(this.f813i);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("needAck:");
            sb.append(this.f805a);
        }
        if (l()) {
            sb.append(", ");
            sb.append("createdTs:");
            sb.append(this.f801a);
        }
        sb.append(")");
        return sb.toString();
    }
}
