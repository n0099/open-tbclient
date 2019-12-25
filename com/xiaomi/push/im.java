package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes5.dex */
public class im implements ir<im, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f739a;

    /* renamed from: a  reason: collision with other field name */
    public hv f740a;

    /* renamed from: a  reason: collision with other field name */
    public String f741a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f742a = new BitSet(2);

    /* renamed from: a  reason: collision with other field name */
    public boolean f743a = true;

    /* renamed from: b  reason: collision with other field name */
    public String f744b;

    /* renamed from: c  reason: collision with other field name */
    public String f745c;

    /* renamed from: d  reason: collision with other field name */
    public String f746d;

    /* renamed from: e  reason: collision with other field name */
    public String f747e;

    /* renamed from: f  reason: collision with other field name */
    public String f748f;

    /* renamed from: g  reason: collision with other field name */
    public String f749g;

    /* renamed from: h  reason: collision with other field name */
    public String f750h;

    /* renamed from: i  reason: collision with other field name */
    public String f751i;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f738a = new jh("XmPushActionUnRegistration");
    private static final iz a = new iz("", Constants.GZIP_CAST_TYPE, 1);
    private static final iz b = new iz("", (byte) 12, 2);
    private static final iz c = new iz("", Constants.GZIP_CAST_TYPE, 3);
    private static final iz d = new iz("", Constants.GZIP_CAST_TYPE, 4);
    private static final iz e = new iz("", Constants.GZIP_CAST_TYPE, 5);
    private static final iz f = new iz("", Constants.GZIP_CAST_TYPE, 6);
    private static final iz g = new iz("", Constants.GZIP_CAST_TYPE, 7);
    private static final iz h = new iz("", Constants.GZIP_CAST_TYPE, 8);
    private static final iz i = new iz("", Constants.GZIP_CAST_TYPE, 9);
    private static final iz j = new iz("", Constants.GZIP_CAST_TYPE, 10);
    private static final iz k = new iz("", (byte) 2, 11);
    private static final iz l = new iz("", (byte) 10, 12);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(im imVar) {
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
        if (getClass().equals(imVar.getClass())) {
            int compareTo = Boolean.valueOf(m437a()).compareTo(Boolean.valueOf(imVar.m437a()));
            if (compareTo == 0) {
                if (!m437a() || (a13 = is.a(this.f741a, imVar.f741a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(imVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a12 = is.a(this.f740a, imVar.f740a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(imVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a11 = is.a(this.f744b, imVar.f744b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(imVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a10 = is.a(this.f745c, imVar.f745c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(imVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a9 = is.a(this.f746d, imVar.f746d)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(imVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a8 = is.a(this.f747e, imVar.f747e)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(imVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a7 = is.a(this.f748f, imVar.f748f)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(imVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a6 = is.a(this.f749g, imVar.f749g)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(imVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a5 = is.a(this.f750h, imVar.f750h)) == 0) {
                                                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(imVar.j()));
                                                                                    if (compareTo10 == 0) {
                                                                                        if (!j() || (a4 = is.a(this.f751i, imVar.f751i)) == 0) {
                                                                                            int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(imVar.k()));
                                                                                            if (compareTo11 == 0) {
                                                                                                if (!k() || (a3 = is.a(this.f743a, imVar.f743a)) == 0) {
                                                                                                    int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(imVar.l()));
                                                                                                    if (compareTo12 == 0) {
                                                                                                        if (!l() || (a2 = is.a(this.f739a, imVar.f739a)) == 0) {
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
        return getClass().getName().compareTo(imVar.getClass().getName());
    }

    public im a(String str) {
        this.f744b = str;
        return this;
    }

    public void a() {
        if (this.f744b == null) {
            throw new jd("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f745c == null) {
            throw new jd("Required field 'appId' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ir
    public void a(jc jcVar) {
        jcVar.m458a();
        while (true) {
            iz m454a = jcVar.m454a();
            if (m454a.a == 0) {
                jcVar.f();
                a();
                return;
            }
            switch (m454a.f793a) {
                case 1:
                    if (m454a.a != 11) {
                        jf.a(jcVar, m454a.a);
                        break;
                    } else {
                        this.f741a = jcVar.m459a();
                        break;
                    }
                case 2:
                    if (m454a.a != 12) {
                        jf.a(jcVar, m454a.a);
                        break;
                    } else {
                        this.f740a = new hv();
                        this.f740a.a(jcVar);
                        break;
                    }
                case 3:
                    if (m454a.a != 11) {
                        jf.a(jcVar, m454a.a);
                        break;
                    } else {
                        this.f744b = jcVar.m459a();
                        break;
                    }
                case 4:
                    if (m454a.a != 11) {
                        jf.a(jcVar, m454a.a);
                        break;
                    } else {
                        this.f745c = jcVar.m459a();
                        break;
                    }
                case 5:
                    if (m454a.a != 11) {
                        jf.a(jcVar, m454a.a);
                        break;
                    } else {
                        this.f746d = jcVar.m459a();
                        break;
                    }
                case 6:
                    if (m454a.a != 11) {
                        jf.a(jcVar, m454a.a);
                        break;
                    } else {
                        this.f747e = jcVar.m459a();
                        break;
                    }
                case 7:
                    if (m454a.a != 11) {
                        jf.a(jcVar, m454a.a);
                        break;
                    } else {
                        this.f748f = jcVar.m459a();
                        break;
                    }
                case 8:
                    if (m454a.a != 11) {
                        jf.a(jcVar, m454a.a);
                        break;
                    } else {
                        this.f749g = jcVar.m459a();
                        break;
                    }
                case 9:
                    if (m454a.a != 11) {
                        jf.a(jcVar, m454a.a);
                        break;
                    } else {
                        this.f750h = jcVar.m459a();
                        break;
                    }
                case 10:
                    if (m454a.a != 11) {
                        jf.a(jcVar, m454a.a);
                        break;
                    } else {
                        this.f751i = jcVar.m459a();
                        break;
                    }
                case 11:
                    if (m454a.a != 2) {
                        jf.a(jcVar, m454a.a);
                        break;
                    } else {
                        this.f743a = jcVar.m463a();
                        a(true);
                        break;
                    }
                case 12:
                    if (m454a.a != 10) {
                        jf.a(jcVar, m454a.a);
                        break;
                    } else {
                        this.f739a = jcVar.m453a();
                        b(true);
                        break;
                    }
                default:
                    jf.a(jcVar, m454a.a);
                    break;
            }
            jcVar.g();
        }
    }

    public void a(boolean z) {
        this.f742a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m437a() {
        return this.f741a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m438a(im imVar) {
        if (imVar == null) {
            return false;
        }
        boolean m437a = m437a();
        boolean m437a2 = imVar.m437a();
        if ((m437a || m437a2) && !(m437a && m437a2 && this.f741a.equals(imVar.f741a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = imVar.b();
        if ((b2 || b3) && !(b2 && b3 && this.f740a.m364a(imVar.f740a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = imVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f744b.equals(imVar.f744b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = imVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f745c.equals(imVar.f745c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = imVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f746d.equals(imVar.f746d))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = imVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f747e.equals(imVar.f747e))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = imVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f748f.equals(imVar.f748f))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = imVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f749g.equals(imVar.f749g))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = imVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f750h.equals(imVar.f750h))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = imVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f751i.equals(imVar.f751i))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = imVar.k();
        if ((k2 || k3) && !(k2 && k3 && this.f743a == imVar.f743a)) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = imVar.l();
        return !(l2 || l3) || (l2 && l3 && this.f739a == imVar.f739a);
    }

    public im b(String str) {
        this.f745c = str;
        return this;
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        a();
        jcVar.a(f738a);
        if (this.f741a != null && m437a()) {
            jcVar.a(a);
            jcVar.a(this.f741a);
            jcVar.b();
        }
        if (this.f740a != null && b()) {
            jcVar.a(b);
            this.f740a.b(jcVar);
            jcVar.b();
        }
        if (this.f744b != null) {
            jcVar.a(c);
            jcVar.a(this.f744b);
            jcVar.b();
        }
        if (this.f745c != null) {
            jcVar.a(d);
            jcVar.a(this.f745c);
            jcVar.b();
        }
        if (this.f746d != null && e()) {
            jcVar.a(e);
            jcVar.a(this.f746d);
            jcVar.b();
        }
        if (this.f747e != null && f()) {
            jcVar.a(f);
            jcVar.a(this.f747e);
            jcVar.b();
        }
        if (this.f748f != null && g()) {
            jcVar.a(g);
            jcVar.a(this.f748f);
            jcVar.b();
        }
        if (this.f749g != null && h()) {
            jcVar.a(h);
            jcVar.a(this.f749g);
            jcVar.b();
        }
        if (this.f750h != null && i()) {
            jcVar.a(i);
            jcVar.a(this.f750h);
            jcVar.b();
        }
        if (this.f751i != null && j()) {
            jcVar.a(j);
            jcVar.a(this.f751i);
            jcVar.b();
        }
        if (k()) {
            jcVar.a(k);
            jcVar.a(this.f743a);
            jcVar.b();
        }
        if (l()) {
            jcVar.a(l);
            jcVar.a(this.f739a);
            jcVar.b();
        }
        jcVar.c();
        jcVar.m462a();
    }

    public void b(boolean z) {
        this.f742a.set(1, z);
    }

    public boolean b() {
        return this.f740a != null;
    }

    public im c(String str) {
        this.f746d = str;
        return this;
    }

    public boolean c() {
        return this.f744b != null;
    }

    public im d(String str) {
        this.f748f = str;
        return this;
    }

    public boolean d() {
        return this.f745c != null;
    }

    public im e(String str) {
        this.f749g = str;
        return this;
    }

    public boolean e() {
        return this.f746d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof im)) {
            return m438a((im) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f747e != null;
    }

    public boolean g() {
        return this.f748f != null;
    }

    public boolean h() {
        return this.f749g != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f750h != null;
    }

    public boolean j() {
        return this.f751i != null;
    }

    public boolean k() {
        return this.f742a.get(0);
    }

    public boolean l() {
        return this.f742a.get(1);
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionUnRegistration(");
        boolean z2 = true;
        if (m437a()) {
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
        if (this.f745c == null) {
            sb.append("null");
        } else {
            sb.append(this.f745c);
        }
        if (e()) {
            sb.append(", ");
            sb.append("regId:");
            if (this.f746d == null) {
                sb.append("null");
            } else {
                sb.append(this.f746d);
            }
        }
        if (f()) {
            sb.append(", ");
            sb.append("appVersion:");
            if (this.f747e == null) {
                sb.append("null");
            } else {
                sb.append(this.f747e);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f748f == null) {
                sb.append("null");
            } else {
                sb.append(this.f748f);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("token:");
            if (this.f749g == null) {
                sb.append("null");
            } else {
                sb.append(this.f749g);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("deviceId:");
            if (this.f750h == null) {
                sb.append("null");
            } else {
                sb.append(this.f750h);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("aliasName:");
            if (this.f751i == null) {
                sb.append("null");
            } else {
                sb.append(this.f751i);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("needAck:");
            sb.append(this.f743a);
        }
        if (l()) {
            sb.append(", ");
            sb.append("createdTs:");
            sb.append(this.f739a);
        }
        sb.append(")");
        return sb.toString();
    }
}
