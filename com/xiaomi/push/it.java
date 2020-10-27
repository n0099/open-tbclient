package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes12.dex */
public class it implements ix<it, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f734a;

    /* renamed from: a  reason: collision with other field name */
    public ib f735a;

    /* renamed from: a  reason: collision with other field name */
    public String f736a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f737a = new BitSet(3);

    /* renamed from: b  reason: collision with other field name */
    public long f738b;

    /* renamed from: b  reason: collision with other field name */
    public String f739b;

    /* renamed from: c  reason: collision with other field name */
    public long f740c;

    /* renamed from: c  reason: collision with other field name */
    public String f741c;

    /* renamed from: d  reason: collision with other field name */
    public String f742d;

    /* renamed from: e  reason: collision with other field name */
    public String f743e;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f733a = new jn("XmPushActionUnRegistrationResult");

    /* renamed from: a  reason: collision with root package name */
    private static final jf f4987a = new jf("", Constants.GZIP_CAST_TYPE, 1);
    private static final jf b = new jf("", (byte) 12, 2);
    private static final jf c = new jf("", Constants.GZIP_CAST_TYPE, 3);
    private static final jf d = new jf("", Constants.GZIP_CAST_TYPE, 4);
    private static final jf e = new jf("", (byte) 10, 6);
    private static final jf f = new jf("", Constants.GZIP_CAST_TYPE, 7);
    private static final jf g = new jf("", Constants.GZIP_CAST_TYPE, 8);
    private static final jf h = new jf("", (byte) 10, 9);
    private static final jf i = new jf("", (byte) 10, 10);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(it itVar) {
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        int a8;
        int a9;
        int a10;
        if (getClass().equals(itVar.getClass())) {
            int compareTo = Boolean.valueOf(m471a()).compareTo(Boolean.valueOf(itVar.m471a()));
            if (compareTo == 0) {
                if (!m471a() || (a10 = iy.a(this.f736a, itVar.f736a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(itVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a9 = iy.a(this.f735a, itVar.f735a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(itVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a8 = iy.a(this.f739b, itVar.f739b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(itVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a7 = iy.a(this.f741c, itVar.f741c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(itVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a6 = iy.a(this.f734a, itVar.f734a)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(itVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a5 = iy.a(this.f742d, itVar.f742d)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(itVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a4 = iy.a(this.f743e, itVar.f743e)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(itVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a3 = iy.a(this.f738b, itVar.f738b)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(itVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a2 = iy.a(this.f740c, itVar.f740c)) == 0) {
                                                                                    return 0;
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
        return getClass().getName().compareTo(itVar.getClass().getName());
    }

    public String a() {
        return this.f743e;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m470a() {
        if (this.f739b == null) {
            throw new jj("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f741c == null) {
            throw new jj("Required field 'appId' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m489a();
        while (true) {
            jf m485a = jiVar.m485a();
            if (m485a.f4998a == 0) {
                jiVar.f();
                if (!e()) {
                    throw new jj("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
                }
                m470a();
                return;
            }
            switch (m485a.f776a) {
                case 1:
                    if (m485a.f4998a != 11) {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    } else {
                        this.f736a = jiVar.m490a();
                        break;
                    }
                case 2:
                    if (m485a.f4998a != 12) {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    } else {
                        this.f735a = new ib();
                        this.f735a.a(jiVar);
                        break;
                    }
                case 3:
                    if (m485a.f4998a != 11) {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    } else {
                        this.f739b = jiVar.m490a();
                        break;
                    }
                case 4:
                    if (m485a.f4998a != 11) {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    } else {
                        this.f741c = jiVar.m490a();
                        break;
                    }
                case 5:
                default:
                    jl.a(jiVar, m485a.f4998a);
                    break;
                case 6:
                    if (m485a.f4998a != 10) {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    } else {
                        this.f734a = jiVar.m484a();
                        a(true);
                        break;
                    }
                case 7:
                    if (m485a.f4998a != 11) {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    } else {
                        this.f742d = jiVar.m490a();
                        break;
                    }
                case 8:
                    if (m485a.f4998a != 11) {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    } else {
                        this.f743e = jiVar.m490a();
                        break;
                    }
                case 9:
                    if (m485a.f4998a != 10) {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    } else {
                        this.f738b = jiVar.m484a();
                        b(true);
                        break;
                    }
                case 10:
                    if (m485a.f4998a != 10) {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    } else {
                        this.f740c = jiVar.m484a();
                        c(true);
                        break;
                    }
            }
            jiVar.g();
        }
    }

    public void a(boolean z) {
        this.f737a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m471a() {
        return this.f736a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m472a(it itVar) {
        if (itVar == null) {
            return false;
        }
        boolean m471a = m471a();
        boolean m471a2 = itVar.m471a();
        if ((m471a || m471a2) && !(m471a && m471a2 && this.f736a.equals(itVar.f736a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = itVar.b();
        if ((b2 || b3) && !(b2 && b3 && this.f735a.m398a(itVar.f735a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = itVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f739b.equals(itVar.f739b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = itVar.d();
        if (((d2 || d3) && !(d2 && d3 && this.f741c.equals(itVar.f741c))) || this.f734a != itVar.f734a) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = itVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f742d.equals(itVar.f742d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = itVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f743e.equals(itVar.f743e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = itVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f738b == itVar.f738b)) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = itVar.i();
        return !(i2 || i3) || (i2 && i3 && this.f740c == itVar.f740c);
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        m470a();
        jiVar.a(f733a);
        if (this.f736a != null && m471a()) {
            jiVar.a(f4987a);
            jiVar.a(this.f736a);
            jiVar.b();
        }
        if (this.f735a != null && b()) {
            jiVar.a(b);
            this.f735a.b(jiVar);
            jiVar.b();
        }
        if (this.f739b != null) {
            jiVar.a(c);
            jiVar.a(this.f739b);
            jiVar.b();
        }
        if (this.f741c != null) {
            jiVar.a(d);
            jiVar.a(this.f741c);
            jiVar.b();
        }
        jiVar.a(e);
        jiVar.a(this.f734a);
        jiVar.b();
        if (this.f742d != null && f()) {
            jiVar.a(f);
            jiVar.a(this.f742d);
            jiVar.b();
        }
        if (this.f743e != null && g()) {
            jiVar.a(g);
            jiVar.a(this.f743e);
            jiVar.b();
        }
        if (h()) {
            jiVar.a(h);
            jiVar.a(this.f738b);
            jiVar.b();
        }
        if (i()) {
            jiVar.a(i);
            jiVar.a(this.f740c);
            jiVar.b();
        }
        jiVar.c();
        jiVar.m493a();
    }

    public void b(boolean z) {
        this.f737a.set(1, z);
    }

    public boolean b() {
        return this.f735a != null;
    }

    public void c(boolean z) {
        this.f737a.set(2, z);
    }

    public boolean c() {
        return this.f739b != null;
    }

    public boolean d() {
        return this.f741c != null;
    }

    public boolean e() {
        return this.f737a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof it)) {
            return m472a((it) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f742d != null;
    }

    public boolean g() {
        return this.f743e != null;
    }

    public boolean h() {
        return this.f737a.get(1);
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f737a.get(2);
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionUnRegistrationResult(");
        boolean z2 = true;
        if (m471a()) {
            sb.append("debug:");
            if (this.f736a == null) {
                sb.append("null");
            } else {
                sb.append(this.f736a);
            }
            z2 = false;
        }
        if (b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f735a == null) {
                sb.append("null");
            } else {
                sb.append(this.f735a);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f739b == null) {
            sb.append("null");
        } else {
            sb.append(this.f739b);
        }
        sb.append(", ");
        sb.append("appId:");
        if (this.f741c == null) {
            sb.append("null");
        } else {
            sb.append(this.f741c);
        }
        sb.append(", ");
        sb.append("errorCode:");
        sb.append(this.f734a);
        if (f()) {
            sb.append(", ");
            sb.append("reason:");
            if (this.f742d == null) {
                sb.append("null");
            } else {
                sb.append(this.f742d);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f743e == null) {
                sb.append("null");
            } else {
                sb.append(this.f743e);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("unRegisteredAt:");
            sb.append(this.f738b);
        }
        if (i()) {
            sb.append(", ");
            sb.append("costTime:");
            sb.append(this.f740c);
        }
        sb.append(")");
        return sb.toString();
    }
}
