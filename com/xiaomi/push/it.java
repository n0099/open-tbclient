package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes8.dex */
public class it implements ix<it, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f742a;

    /* renamed from: a  reason: collision with other field name */
    public ib f743a;

    /* renamed from: a  reason: collision with other field name */
    public String f744a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f745a = new BitSet(3);

    /* renamed from: b  reason: collision with other field name */
    public long f746b;

    /* renamed from: b  reason: collision with other field name */
    public String f747b;

    /* renamed from: c  reason: collision with other field name */
    public long f748c;

    /* renamed from: c  reason: collision with other field name */
    public String f749c;

    /* renamed from: d  reason: collision with other field name */
    public String f750d;

    /* renamed from: e  reason: collision with other field name */
    public String f751e;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f741a = new jn("XmPushActionUnRegistrationResult");
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
            int compareTo = Boolean.valueOf(m465a()).compareTo(Boolean.valueOf(itVar.m465a()));
            if (compareTo == 0) {
                if (!m465a() || (a10 = iy.a(this.f744a, itVar.f744a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(itVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a9 = iy.a(this.f743a, itVar.f743a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(itVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a8 = iy.a(this.f747b, itVar.f747b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(itVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a7 = iy.a(this.f749c, itVar.f749c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(itVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a6 = iy.a(this.f742a, itVar.f742a)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(itVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a5 = iy.a(this.f750d, itVar.f750d)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(itVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a4 = iy.a(this.f751e, itVar.f751e)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(itVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a3 = iy.a(this.f746b, itVar.f746b)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(itVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a2 = iy.a(this.f748c, itVar.f748c)) == 0) {
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
        return this.f751e;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m464a() {
        if (this.f747b == null) {
            throw new jj("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f749c == null) {
            throw new jj("Required field 'appId' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m483a();
        while (true) {
            jf m479a = jiVar.m479a();
            if (m479a.a == 0) {
                jiVar.f();
                if (!e()) {
                    throw new jj("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
                }
                m464a();
                return;
            }
            switch (m479a.f784a) {
                case 1:
                    if (m479a.a != 11) {
                        jl.a(jiVar, m479a.a);
                        break;
                    } else {
                        this.f744a = jiVar.m484a();
                        break;
                    }
                case 2:
                    if (m479a.a != 12) {
                        jl.a(jiVar, m479a.a);
                        break;
                    } else {
                        this.f743a = new ib();
                        this.f743a.a(jiVar);
                        break;
                    }
                case 3:
                    if (m479a.a != 11) {
                        jl.a(jiVar, m479a.a);
                        break;
                    } else {
                        this.f747b = jiVar.m484a();
                        break;
                    }
                case 4:
                    if (m479a.a != 11) {
                        jl.a(jiVar, m479a.a);
                        break;
                    } else {
                        this.f749c = jiVar.m484a();
                        break;
                    }
                case 5:
                default:
                    jl.a(jiVar, m479a.a);
                    break;
                case 6:
                    if (m479a.a != 10) {
                        jl.a(jiVar, m479a.a);
                        break;
                    } else {
                        this.f742a = jiVar.m478a();
                        a(true);
                        break;
                    }
                case 7:
                    if (m479a.a != 11) {
                        jl.a(jiVar, m479a.a);
                        break;
                    } else {
                        this.f750d = jiVar.m484a();
                        break;
                    }
                case 8:
                    if (m479a.a != 11) {
                        jl.a(jiVar, m479a.a);
                        break;
                    } else {
                        this.f751e = jiVar.m484a();
                        break;
                    }
                case 9:
                    if (m479a.a != 10) {
                        jl.a(jiVar, m479a.a);
                        break;
                    } else {
                        this.f746b = jiVar.m478a();
                        b(true);
                        break;
                    }
                case 10:
                    if (m479a.a != 10) {
                        jl.a(jiVar, m479a.a);
                        break;
                    } else {
                        this.f748c = jiVar.m478a();
                        c(true);
                        break;
                    }
            }
            jiVar.g();
        }
    }

    public void a(boolean z) {
        this.f745a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m465a() {
        return this.f744a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m466a(it itVar) {
        if (itVar == null) {
            return false;
        }
        boolean m465a = m465a();
        boolean m465a2 = itVar.m465a();
        if ((m465a || m465a2) && !(m465a && m465a2 && this.f744a.equals(itVar.f744a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = itVar.b();
        if ((b2 || b3) && !(b2 && b3 && this.f743a.m392a(itVar.f743a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = itVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f747b.equals(itVar.f747b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = itVar.d();
        if (((d2 || d3) && !(d2 && d3 && this.f749c.equals(itVar.f749c))) || this.f742a != itVar.f742a) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = itVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f750d.equals(itVar.f750d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = itVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f751e.equals(itVar.f751e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = itVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f746b == itVar.f746b)) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = itVar.i();
        return !(i2 || i3) || (i2 && i3 && this.f748c == itVar.f748c);
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        m464a();
        jiVar.a(f741a);
        if (this.f744a != null && m465a()) {
            jiVar.a(a);
            jiVar.a(this.f744a);
            jiVar.b();
        }
        if (this.f743a != null && b()) {
            jiVar.a(b);
            this.f743a.b(jiVar);
            jiVar.b();
        }
        if (this.f747b != null) {
            jiVar.a(c);
            jiVar.a(this.f747b);
            jiVar.b();
        }
        if (this.f749c != null) {
            jiVar.a(d);
            jiVar.a(this.f749c);
            jiVar.b();
        }
        jiVar.a(e);
        jiVar.a(this.f742a);
        jiVar.b();
        if (this.f750d != null && f()) {
            jiVar.a(f);
            jiVar.a(this.f750d);
            jiVar.b();
        }
        if (this.f751e != null && g()) {
            jiVar.a(g);
            jiVar.a(this.f751e);
            jiVar.b();
        }
        if (h()) {
            jiVar.a(h);
            jiVar.a(this.f746b);
            jiVar.b();
        }
        if (i()) {
            jiVar.a(i);
            jiVar.a(this.f748c);
            jiVar.b();
        }
        jiVar.c();
        jiVar.m487a();
    }

    public void b(boolean z) {
        this.f745a.set(1, z);
    }

    public boolean b() {
        return this.f743a != null;
    }

    public void c(boolean z) {
        this.f745a.set(2, z);
    }

    public boolean c() {
        return this.f747b != null;
    }

    public boolean d() {
        return this.f749c != null;
    }

    public boolean e() {
        return this.f745a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof it)) {
            return m466a((it) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f750d != null;
    }

    public boolean g() {
        return this.f751e != null;
    }

    public boolean h() {
        return this.f745a.get(1);
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f745a.get(2);
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionUnRegistrationResult(");
        boolean z2 = true;
        if (m465a()) {
            sb.append("debug:");
            if (this.f744a == null) {
                sb.append("null");
            } else {
                sb.append(this.f744a);
            }
            z2 = false;
        }
        if (b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f743a == null) {
                sb.append("null");
            } else {
                sb.append(this.f743a);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f747b == null) {
            sb.append("null");
        } else {
            sb.append(this.f747b);
        }
        sb.append(", ");
        sb.append("appId:");
        if (this.f749c == null) {
            sb.append("null");
        } else {
            sb.append(this.f749c);
        }
        sb.append(", ");
        sb.append("errorCode:");
        sb.append(this.f742a);
        if (f()) {
            sb.append(", ");
            sb.append("reason:");
            if (this.f750d == null) {
                sb.append("null");
            } else {
                sb.append(this.f750d);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f751e == null) {
                sb.append("null");
            } else {
                sb.append(this.f751e);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("unRegisteredAt:");
            sb.append(this.f746b);
        }
        if (i()) {
            sb.append(", ");
            sb.append("costTime:");
            sb.append(this.f748c);
        }
        sb.append(")");
        return sb.toString();
    }
}
