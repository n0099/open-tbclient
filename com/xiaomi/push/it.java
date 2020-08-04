package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes9.dex */
public class it implements ix<it, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f741a;

    /* renamed from: a  reason: collision with other field name */
    public ib f742a;

    /* renamed from: a  reason: collision with other field name */
    public String f743a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f744a = new BitSet(3);

    /* renamed from: b  reason: collision with other field name */
    public long f745b;

    /* renamed from: b  reason: collision with other field name */
    public String f746b;

    /* renamed from: c  reason: collision with other field name */
    public long f747c;

    /* renamed from: c  reason: collision with other field name */
    public String f748c;

    /* renamed from: d  reason: collision with other field name */
    public String f749d;

    /* renamed from: e  reason: collision with other field name */
    public String f750e;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f740a = new jn("XmPushActionUnRegistrationResult");
    private static final jf a = new jf("", Constants.GZIP_CAST_TYPE, 1);
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
            int compareTo = Boolean.valueOf(m466a()).compareTo(Boolean.valueOf(itVar.m466a()));
            if (compareTo == 0) {
                if (!m466a() || (a10 = iy.a(this.f743a, itVar.f743a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(itVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a9 = iy.a(this.f742a, itVar.f742a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(itVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a8 = iy.a(this.f746b, itVar.f746b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(itVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a7 = iy.a(this.f748c, itVar.f748c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(itVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a6 = iy.a(this.f741a, itVar.f741a)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(itVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a5 = iy.a(this.f749d, itVar.f749d)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(itVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a4 = iy.a(this.f750e, itVar.f750e)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(itVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a3 = iy.a(this.f745b, itVar.f745b)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(itVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a2 = iy.a(this.f747c, itVar.f747c)) == 0) {
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
        return this.f750e;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m465a() {
        if (this.f746b == null) {
            throw new jj("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f748c == null) {
            throw new jj("Required field 'appId' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m484a();
        while (true) {
            jf m480a = jiVar.m480a();
            if (m480a.a == 0) {
                jiVar.f();
                if (!e()) {
                    throw new jj("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
                }
                m465a();
                return;
            }
            switch (m480a.f783a) {
                case 1:
                    if (m480a.a != 11) {
                        jl.a(jiVar, m480a.a);
                        break;
                    } else {
                        this.f743a = jiVar.m485a();
                        break;
                    }
                case 2:
                    if (m480a.a != 12) {
                        jl.a(jiVar, m480a.a);
                        break;
                    } else {
                        this.f742a = new ib();
                        this.f742a.a(jiVar);
                        break;
                    }
                case 3:
                    if (m480a.a != 11) {
                        jl.a(jiVar, m480a.a);
                        break;
                    } else {
                        this.f746b = jiVar.m485a();
                        break;
                    }
                case 4:
                    if (m480a.a != 11) {
                        jl.a(jiVar, m480a.a);
                        break;
                    } else {
                        this.f748c = jiVar.m485a();
                        break;
                    }
                case 5:
                default:
                    jl.a(jiVar, m480a.a);
                    break;
                case 6:
                    if (m480a.a != 10) {
                        jl.a(jiVar, m480a.a);
                        break;
                    } else {
                        this.f741a = jiVar.m479a();
                        a(true);
                        break;
                    }
                case 7:
                    if (m480a.a != 11) {
                        jl.a(jiVar, m480a.a);
                        break;
                    } else {
                        this.f749d = jiVar.m485a();
                        break;
                    }
                case 8:
                    if (m480a.a != 11) {
                        jl.a(jiVar, m480a.a);
                        break;
                    } else {
                        this.f750e = jiVar.m485a();
                        break;
                    }
                case 9:
                    if (m480a.a != 10) {
                        jl.a(jiVar, m480a.a);
                        break;
                    } else {
                        this.f745b = jiVar.m479a();
                        b(true);
                        break;
                    }
                case 10:
                    if (m480a.a != 10) {
                        jl.a(jiVar, m480a.a);
                        break;
                    } else {
                        this.f747c = jiVar.m479a();
                        c(true);
                        break;
                    }
            }
            jiVar.g();
        }
    }

    public void a(boolean z) {
        this.f744a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m466a() {
        return this.f743a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m467a(it itVar) {
        if (itVar == null) {
            return false;
        }
        boolean m466a = m466a();
        boolean m466a2 = itVar.m466a();
        if ((m466a || m466a2) && !(m466a && m466a2 && this.f743a.equals(itVar.f743a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = itVar.b();
        if ((b2 || b3) && !(b2 && b3 && this.f742a.m393a(itVar.f742a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = itVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f746b.equals(itVar.f746b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = itVar.d();
        if (((d2 || d3) && !(d2 && d3 && this.f748c.equals(itVar.f748c))) || this.f741a != itVar.f741a) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = itVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f749d.equals(itVar.f749d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = itVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f750e.equals(itVar.f750e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = itVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f745b == itVar.f745b)) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = itVar.i();
        return !(i2 || i3) || (i2 && i3 && this.f747c == itVar.f747c);
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        m465a();
        jiVar.a(f740a);
        if (this.f743a != null && m466a()) {
            jiVar.a(a);
            jiVar.a(this.f743a);
            jiVar.b();
        }
        if (this.f742a != null && b()) {
            jiVar.a(b);
            this.f742a.b(jiVar);
            jiVar.b();
        }
        if (this.f746b != null) {
            jiVar.a(c);
            jiVar.a(this.f746b);
            jiVar.b();
        }
        if (this.f748c != null) {
            jiVar.a(d);
            jiVar.a(this.f748c);
            jiVar.b();
        }
        jiVar.a(e);
        jiVar.a(this.f741a);
        jiVar.b();
        if (this.f749d != null && f()) {
            jiVar.a(f);
            jiVar.a(this.f749d);
            jiVar.b();
        }
        if (this.f750e != null && g()) {
            jiVar.a(g);
            jiVar.a(this.f750e);
            jiVar.b();
        }
        if (h()) {
            jiVar.a(h);
            jiVar.a(this.f745b);
            jiVar.b();
        }
        if (i()) {
            jiVar.a(i);
            jiVar.a(this.f747c);
            jiVar.b();
        }
        jiVar.c();
        jiVar.m488a();
    }

    public void b(boolean z) {
        this.f744a.set(1, z);
    }

    public boolean b() {
        return this.f742a != null;
    }

    public void c(boolean z) {
        this.f744a.set(2, z);
    }

    public boolean c() {
        return this.f746b != null;
    }

    public boolean d() {
        return this.f748c != null;
    }

    public boolean e() {
        return this.f744a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof it)) {
            return m467a((it) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f749d != null;
    }

    public boolean g() {
        return this.f750e != null;
    }

    public boolean h() {
        return this.f744a.get(1);
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f744a.get(2);
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionUnRegistrationResult(");
        boolean z2 = true;
        if (m466a()) {
            sb.append("debug:");
            if (this.f743a == null) {
                sb.append("null");
            } else {
                sb.append(this.f743a);
            }
            z2 = false;
        }
        if (b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f742a == null) {
                sb.append("null");
            } else {
                sb.append(this.f742a);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f746b == null) {
            sb.append("null");
        } else {
            sb.append(this.f746b);
        }
        sb.append(", ");
        sb.append("appId:");
        if (this.f748c == null) {
            sb.append("null");
        } else {
            sb.append(this.f748c);
        }
        sb.append(", ");
        sb.append("errorCode:");
        sb.append(this.f741a);
        if (f()) {
            sb.append(", ");
            sb.append("reason:");
            if (this.f749d == null) {
                sb.append("null");
            } else {
                sb.append(this.f749d);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f750e == null) {
                sb.append("null");
            } else {
                sb.append(this.f750e);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("unRegisteredAt:");
            sb.append(this.f745b);
        }
        if (i()) {
            sb.append(", ");
            sb.append("costTime:");
            sb.append(this.f747c);
        }
        sb.append(")");
        return sb.toString();
    }
}
