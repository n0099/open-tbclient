package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes8.dex */
public class im implements ir<im, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f735a;

    /* renamed from: a  reason: collision with other field name */
    public hv f736a;

    /* renamed from: a  reason: collision with other field name */
    public String f737a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f738a = new BitSet(2);

    /* renamed from: a  reason: collision with other field name */
    public boolean f739a = true;

    /* renamed from: b  reason: collision with other field name */
    public String f740b;

    /* renamed from: c  reason: collision with other field name */
    public String f741c;

    /* renamed from: d  reason: collision with other field name */
    public String f742d;

    /* renamed from: e  reason: collision with other field name */
    public String f743e;

    /* renamed from: f  reason: collision with other field name */
    public String f744f;

    /* renamed from: g  reason: collision with other field name */
    public String f745g;

    /* renamed from: h  reason: collision with other field name */
    public String f746h;

    /* renamed from: i  reason: collision with other field name */
    public String f747i;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f734a = new jh("XmPushActionUnRegistration");
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
            int compareTo = Boolean.valueOf(m454a()).compareTo(Boolean.valueOf(imVar.m454a()));
            if (compareTo == 0) {
                if (!m454a() || (a13 = is.a(this.f737a, imVar.f737a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(imVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a12 = is.a(this.f736a, imVar.f736a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(imVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a11 = is.a(this.f740b, imVar.f740b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(imVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a10 = is.a(this.f741c, imVar.f741c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(imVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a9 = is.a(this.f742d, imVar.f742d)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(imVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a8 = is.a(this.f743e, imVar.f743e)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(imVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a7 = is.a(this.f744f, imVar.f744f)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(imVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a6 = is.a(this.f745g, imVar.f745g)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(imVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a5 = is.a(this.f746h, imVar.f746h)) == 0) {
                                                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(imVar.j()));
                                                                                    if (compareTo10 == 0) {
                                                                                        if (!j() || (a4 = is.a(this.f747i, imVar.f747i)) == 0) {
                                                                                            int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(imVar.k()));
                                                                                            if (compareTo11 == 0) {
                                                                                                if (!k() || (a3 = is.a(this.f739a, imVar.f739a)) == 0) {
                                                                                                    int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(imVar.l()));
                                                                                                    if (compareTo12 == 0) {
                                                                                                        if (!l() || (a2 = is.a(this.f735a, imVar.f735a)) == 0) {
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
        this.f740b = str;
        return this;
    }

    public void a() {
        if (this.f740b == null) {
            throw new jd("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f741c == null) {
            throw new jd("Required field 'appId' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ir
    public void a(jc jcVar) {
        jcVar.m475a();
        while (true) {
            iz m471a = jcVar.m471a();
            if (m471a.a == 0) {
                jcVar.f();
                a();
                return;
            }
            switch (m471a.f789a) {
                case 1:
                    if (m471a.a != 11) {
                        jf.a(jcVar, m471a.a);
                        break;
                    } else {
                        this.f737a = jcVar.m476a();
                        break;
                    }
                case 2:
                    if (m471a.a != 12) {
                        jf.a(jcVar, m471a.a);
                        break;
                    } else {
                        this.f736a = new hv();
                        this.f736a.a(jcVar);
                        break;
                    }
                case 3:
                    if (m471a.a != 11) {
                        jf.a(jcVar, m471a.a);
                        break;
                    } else {
                        this.f740b = jcVar.m476a();
                        break;
                    }
                case 4:
                    if (m471a.a != 11) {
                        jf.a(jcVar, m471a.a);
                        break;
                    } else {
                        this.f741c = jcVar.m476a();
                        break;
                    }
                case 5:
                    if (m471a.a != 11) {
                        jf.a(jcVar, m471a.a);
                        break;
                    } else {
                        this.f742d = jcVar.m476a();
                        break;
                    }
                case 6:
                    if (m471a.a != 11) {
                        jf.a(jcVar, m471a.a);
                        break;
                    } else {
                        this.f743e = jcVar.m476a();
                        break;
                    }
                case 7:
                    if (m471a.a != 11) {
                        jf.a(jcVar, m471a.a);
                        break;
                    } else {
                        this.f744f = jcVar.m476a();
                        break;
                    }
                case 8:
                    if (m471a.a != 11) {
                        jf.a(jcVar, m471a.a);
                        break;
                    } else {
                        this.f745g = jcVar.m476a();
                        break;
                    }
                case 9:
                    if (m471a.a != 11) {
                        jf.a(jcVar, m471a.a);
                        break;
                    } else {
                        this.f746h = jcVar.m476a();
                        break;
                    }
                case 10:
                    if (m471a.a != 11) {
                        jf.a(jcVar, m471a.a);
                        break;
                    } else {
                        this.f747i = jcVar.m476a();
                        break;
                    }
                case 11:
                    if (m471a.a != 2) {
                        jf.a(jcVar, m471a.a);
                        break;
                    } else {
                        this.f739a = jcVar.m480a();
                        a(true);
                        break;
                    }
                case 12:
                    if (m471a.a != 10) {
                        jf.a(jcVar, m471a.a);
                        break;
                    } else {
                        this.f735a = jcVar.m470a();
                        b(true);
                        break;
                    }
                default:
                    jf.a(jcVar, m471a.a);
                    break;
            }
            jcVar.g();
        }
    }

    public void a(boolean z) {
        this.f738a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m454a() {
        return this.f737a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m455a(im imVar) {
        if (imVar == null) {
            return false;
        }
        boolean m454a = m454a();
        boolean m454a2 = imVar.m454a();
        if ((m454a || m454a2) && !(m454a && m454a2 && this.f737a.equals(imVar.f737a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = imVar.b();
        if ((b2 || b3) && !(b2 && b3 && this.f736a.m381a(imVar.f736a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = imVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f740b.equals(imVar.f740b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = imVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f741c.equals(imVar.f741c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = imVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f742d.equals(imVar.f742d))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = imVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f743e.equals(imVar.f743e))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = imVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f744f.equals(imVar.f744f))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = imVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f745g.equals(imVar.f745g))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = imVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f746h.equals(imVar.f746h))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = imVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f747i.equals(imVar.f747i))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = imVar.k();
        if ((k2 || k3) && !(k2 && k3 && this.f739a == imVar.f739a)) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = imVar.l();
        return !(l2 || l3) || (l2 && l3 && this.f735a == imVar.f735a);
    }

    public im b(String str) {
        this.f741c = str;
        return this;
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        a();
        jcVar.a(f734a);
        if (this.f737a != null && m454a()) {
            jcVar.a(a);
            jcVar.a(this.f737a);
            jcVar.b();
        }
        if (this.f736a != null && b()) {
            jcVar.a(b);
            this.f736a.b(jcVar);
            jcVar.b();
        }
        if (this.f740b != null) {
            jcVar.a(c);
            jcVar.a(this.f740b);
            jcVar.b();
        }
        if (this.f741c != null) {
            jcVar.a(d);
            jcVar.a(this.f741c);
            jcVar.b();
        }
        if (this.f742d != null && e()) {
            jcVar.a(e);
            jcVar.a(this.f742d);
            jcVar.b();
        }
        if (this.f743e != null && f()) {
            jcVar.a(f);
            jcVar.a(this.f743e);
            jcVar.b();
        }
        if (this.f744f != null && g()) {
            jcVar.a(g);
            jcVar.a(this.f744f);
            jcVar.b();
        }
        if (this.f745g != null && h()) {
            jcVar.a(h);
            jcVar.a(this.f745g);
            jcVar.b();
        }
        if (this.f746h != null && i()) {
            jcVar.a(i);
            jcVar.a(this.f746h);
            jcVar.b();
        }
        if (this.f747i != null && j()) {
            jcVar.a(j);
            jcVar.a(this.f747i);
            jcVar.b();
        }
        if (k()) {
            jcVar.a(k);
            jcVar.a(this.f739a);
            jcVar.b();
        }
        if (l()) {
            jcVar.a(l);
            jcVar.a(this.f735a);
            jcVar.b();
        }
        jcVar.c();
        jcVar.m479a();
    }

    public void b(boolean z) {
        this.f738a.set(1, z);
    }

    public boolean b() {
        return this.f736a != null;
    }

    public im c(String str) {
        this.f742d = str;
        return this;
    }

    public boolean c() {
        return this.f740b != null;
    }

    public im d(String str) {
        this.f744f = str;
        return this;
    }

    public boolean d() {
        return this.f741c != null;
    }

    public im e(String str) {
        this.f745g = str;
        return this;
    }

    public boolean e() {
        return this.f742d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof im)) {
            return m455a((im) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f743e != null;
    }

    public boolean g() {
        return this.f744f != null;
    }

    public boolean h() {
        return this.f745g != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f746h != null;
    }

    public boolean j() {
        return this.f747i != null;
    }

    public boolean k() {
        return this.f738a.get(0);
    }

    public boolean l() {
        return this.f738a.get(1);
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionUnRegistration(");
        boolean z2 = true;
        if (m454a()) {
            sb.append("debug:");
            if (this.f737a == null) {
                sb.append("null");
            } else {
                sb.append(this.f737a);
            }
            z2 = false;
        }
        if (b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f736a == null) {
                sb.append("null");
            } else {
                sb.append(this.f736a);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f740b == null) {
            sb.append("null");
        } else {
            sb.append(this.f740b);
        }
        sb.append(", ");
        sb.append("appId:");
        if (this.f741c == null) {
            sb.append("null");
        } else {
            sb.append(this.f741c);
        }
        if (e()) {
            sb.append(", ");
            sb.append("regId:");
            if (this.f742d == null) {
                sb.append("null");
            } else {
                sb.append(this.f742d);
            }
        }
        if (f()) {
            sb.append(", ");
            sb.append("appVersion:");
            if (this.f743e == null) {
                sb.append("null");
            } else {
                sb.append(this.f743e);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f744f == null) {
                sb.append("null");
            } else {
                sb.append(this.f744f);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("token:");
            if (this.f745g == null) {
                sb.append("null");
            } else {
                sb.append(this.f745g);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("deviceId:");
            if (this.f746h == null) {
                sb.append("null");
            } else {
                sb.append(this.f746h);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("aliasName:");
            if (this.f747i == null) {
                sb.append("null");
            } else {
                sb.append(this.f747i);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("needAck:");
            sb.append(this.f739a);
        }
        if (l()) {
            sb.append(", ");
            sb.append("createdTs:");
            sb.append(this.f735a);
        }
        sb.append(")");
        return sb.toString();
    }
}
