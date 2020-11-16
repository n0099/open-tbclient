package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes18.dex */
public class it implements ix<it, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f739a;

    /* renamed from: a  reason: collision with other field name */
    public ib f740a;

    /* renamed from: a  reason: collision with other field name */
    public String f741a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f742a = new BitSet(3);

    /* renamed from: b  reason: collision with other field name */
    public long f743b;

    /* renamed from: b  reason: collision with other field name */
    public String f744b;

    /* renamed from: c  reason: collision with other field name */
    public long f745c;

    /* renamed from: c  reason: collision with other field name */
    public String f746c;

    /* renamed from: d  reason: collision with other field name */
    public String f747d;

    /* renamed from: e  reason: collision with other field name */
    public String f748e;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f738a = new jn("XmPushActionUnRegistrationResult");

    /* renamed from: a  reason: collision with root package name */
    private static final jf f4989a = new jf("", Constants.GZIP_CAST_TYPE, 1);
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
            int compareTo = Boolean.valueOf(m474a()).compareTo(Boolean.valueOf(itVar.m474a()));
            if (compareTo == 0) {
                if (!m474a() || (a10 = iy.a(this.f741a, itVar.f741a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(itVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a9 = iy.a(this.f740a, itVar.f740a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(itVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a8 = iy.a(this.f744b, itVar.f744b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(itVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a7 = iy.a(this.f746c, itVar.f746c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(itVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a6 = iy.a(this.f739a, itVar.f739a)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(itVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a5 = iy.a(this.f747d, itVar.f747d)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(itVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a4 = iy.a(this.f748e, itVar.f748e)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(itVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a3 = iy.a(this.f743b, itVar.f743b)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(itVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a2 = iy.a(this.f745c, itVar.f745c)) == 0) {
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
        return this.f748e;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m473a() {
        if (this.f744b == null) {
            throw new jj("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f746c == null) {
            throw new jj("Required field 'appId' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m492a();
        while (true) {
            jf m488a = jiVar.m488a();
            if (m488a.f5000a == 0) {
                jiVar.f();
                if (!e()) {
                    throw new jj("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
                }
                m473a();
                return;
            }
            switch (m488a.f781a) {
                case 1:
                    if (m488a.f5000a != 11) {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    } else {
                        this.f741a = jiVar.m493a();
                        break;
                    }
                case 2:
                    if (m488a.f5000a != 12) {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    } else {
                        this.f740a = new ib();
                        this.f740a.a(jiVar);
                        break;
                    }
                case 3:
                    if (m488a.f5000a != 11) {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    } else {
                        this.f744b = jiVar.m493a();
                        break;
                    }
                case 4:
                    if (m488a.f5000a != 11) {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    } else {
                        this.f746c = jiVar.m493a();
                        break;
                    }
                case 5:
                default:
                    jl.a(jiVar, m488a.f5000a);
                    break;
                case 6:
                    if (m488a.f5000a != 10) {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    } else {
                        this.f739a = jiVar.m487a();
                        a(true);
                        break;
                    }
                case 7:
                    if (m488a.f5000a != 11) {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    } else {
                        this.f747d = jiVar.m493a();
                        break;
                    }
                case 8:
                    if (m488a.f5000a != 11) {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    } else {
                        this.f748e = jiVar.m493a();
                        break;
                    }
                case 9:
                    if (m488a.f5000a != 10) {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    } else {
                        this.f743b = jiVar.m487a();
                        b(true);
                        break;
                    }
                case 10:
                    if (m488a.f5000a != 10) {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    } else {
                        this.f745c = jiVar.m487a();
                        c(true);
                        break;
                    }
            }
            jiVar.g();
        }
    }

    public void a(boolean z) {
        this.f742a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m474a() {
        return this.f741a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m475a(it itVar) {
        if (itVar == null) {
            return false;
        }
        boolean m474a = m474a();
        boolean m474a2 = itVar.m474a();
        if ((m474a || m474a2) && !(m474a && m474a2 && this.f741a.equals(itVar.f741a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = itVar.b();
        if ((b2 || b3) && !(b2 && b3 && this.f740a.m401a(itVar.f740a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = itVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f744b.equals(itVar.f744b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = itVar.d();
        if (((d2 || d3) && !(d2 && d3 && this.f746c.equals(itVar.f746c))) || this.f739a != itVar.f739a) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = itVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f747d.equals(itVar.f747d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = itVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f748e.equals(itVar.f748e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = itVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f743b == itVar.f743b)) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = itVar.i();
        return !(i2 || i3) || (i2 && i3 && this.f745c == itVar.f745c);
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        m473a();
        jiVar.a(f738a);
        if (this.f741a != null && m474a()) {
            jiVar.a(f4989a);
            jiVar.a(this.f741a);
            jiVar.b();
        }
        if (this.f740a != null && b()) {
            jiVar.a(b);
            this.f740a.b(jiVar);
            jiVar.b();
        }
        if (this.f744b != null) {
            jiVar.a(c);
            jiVar.a(this.f744b);
            jiVar.b();
        }
        if (this.f746c != null) {
            jiVar.a(d);
            jiVar.a(this.f746c);
            jiVar.b();
        }
        jiVar.a(e);
        jiVar.a(this.f739a);
        jiVar.b();
        if (this.f747d != null && f()) {
            jiVar.a(f);
            jiVar.a(this.f747d);
            jiVar.b();
        }
        if (this.f748e != null && g()) {
            jiVar.a(g);
            jiVar.a(this.f748e);
            jiVar.b();
        }
        if (h()) {
            jiVar.a(h);
            jiVar.a(this.f743b);
            jiVar.b();
        }
        if (i()) {
            jiVar.a(i);
            jiVar.a(this.f745c);
            jiVar.b();
        }
        jiVar.c();
        jiVar.m496a();
    }

    public void b(boolean z) {
        this.f742a.set(1, z);
    }

    public boolean b() {
        return this.f740a != null;
    }

    public void c(boolean z) {
        this.f742a.set(2, z);
    }

    public boolean c() {
        return this.f744b != null;
    }

    public boolean d() {
        return this.f746c != null;
    }

    public boolean e() {
        return this.f742a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof it)) {
            return m475a((it) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f747d != null;
    }

    public boolean g() {
        return this.f748e != null;
    }

    public boolean h() {
        return this.f742a.get(1);
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f742a.get(2);
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionUnRegistrationResult(");
        boolean z2 = true;
        if (m474a()) {
            sb.append("debug:");
            if (this.f741a == null) {
                sb.append("null");
            } else {
                sb.append(this.f741a);
            }
            z2 = false;
        }
        if (b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f740a == null) {
                sb.append("null");
            } else {
                sb.append(this.f740a);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f744b == null) {
            sb.append("null");
        } else {
            sb.append(this.f744b);
        }
        sb.append(", ");
        sb.append("appId:");
        if (this.f746c == null) {
            sb.append("null");
        } else {
            sb.append(this.f746c);
        }
        sb.append(", ");
        sb.append("errorCode:");
        sb.append(this.f739a);
        if (f()) {
            sb.append(", ");
            sb.append("reason:");
            if (this.f747d == null) {
                sb.append("null");
            } else {
                sb.append(this.f747d);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f748e == null) {
                sb.append("null");
            } else {
                sb.append(this.f748e);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("unRegisteredAt:");
            sb.append(this.f743b);
        }
        if (i()) {
            sb.append(", ");
            sb.append("costTime:");
            sb.append(this.f745c);
        }
        sb.append(")");
        return sb.toString();
    }
}
