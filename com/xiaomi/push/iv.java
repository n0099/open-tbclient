package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes9.dex */
public class iv implements ix<iv, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f761a;

    /* renamed from: a  reason: collision with other field name */
    public ib f762a;

    /* renamed from: a  reason: collision with other field name */
    public String f763a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f764a = new BitSet(1);

    /* renamed from: b  reason: collision with other field name */
    public String f765b;

    /* renamed from: c  reason: collision with other field name */
    public String f766c;

    /* renamed from: d  reason: collision with other field name */
    public String f767d;

    /* renamed from: e  reason: collision with other field name */
    public String f768e;

    /* renamed from: f  reason: collision with other field name */
    public String f769f;

    /* renamed from: g  reason: collision with other field name */
    public String f770g;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f760a = new jn("XmPushActionUnSubscriptionResult");
    private static final jf a = new jf("", Constants.GZIP_CAST_TYPE, 1);
    private static final jf b = new jf("", (byte) 12, 2);
    private static final jf c = new jf("", Constants.GZIP_CAST_TYPE, 3);
    private static final jf d = new jf("", Constants.GZIP_CAST_TYPE, 4);
    private static final jf e = new jf("", (byte) 10, 6);
    private static final jf f = new jf("", Constants.GZIP_CAST_TYPE, 7);
    private static final jf g = new jf("", Constants.GZIP_CAST_TYPE, 8);
    private static final jf h = new jf("", Constants.GZIP_CAST_TYPE, 9);
    private static final jf i = new jf("", Constants.GZIP_CAST_TYPE, 10);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(iv ivVar) {
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        int a8;
        int a9;
        int a10;
        if (getClass().equals(ivVar.getClass())) {
            int compareTo = Boolean.valueOf(m471a()).compareTo(Boolean.valueOf(ivVar.m471a()));
            if (compareTo == 0) {
                if (!m471a() || (a10 = iy.a(this.f763a, ivVar.f763a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m473b()).compareTo(Boolean.valueOf(ivVar.m473b()));
                    if (compareTo2 == 0) {
                        if (!m473b() || (a9 = iy.a(this.f762a, ivVar.f762a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(ivVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a8 = iy.a(this.f765b, ivVar.f765b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(ivVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a7 = iy.a(this.f766c, ivVar.f766c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(ivVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a6 = iy.a(this.f761a, ivVar.f761a)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(ivVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a5 = iy.a(this.f767d, ivVar.f767d)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ivVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a4 = iy.a(this.f768e, ivVar.f768e)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(ivVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a3 = iy.a(this.f769f, ivVar.f769f)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(ivVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a2 = iy.a(this.f770g, ivVar.f770g)) == 0) {
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
        return getClass().getName().compareTo(ivVar.getClass().getName());
    }

    public String a() {
        return this.f768e;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m470a() {
        if (this.f765b == null) {
            throw new jj("Required field 'id' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m484a();
        while (true) {
            jf m480a = jiVar.m480a();
            if (m480a.a == 0) {
                jiVar.f();
                m470a();
                return;
            }
            switch (m480a.f783a) {
                case 1:
                    if (m480a.a != 11) {
                        jl.a(jiVar, m480a.a);
                        break;
                    } else {
                        this.f763a = jiVar.m485a();
                        break;
                    }
                case 2:
                    if (m480a.a != 12) {
                        jl.a(jiVar, m480a.a);
                        break;
                    } else {
                        this.f762a = new ib();
                        this.f762a.a(jiVar);
                        break;
                    }
                case 3:
                    if (m480a.a != 11) {
                        jl.a(jiVar, m480a.a);
                        break;
                    } else {
                        this.f765b = jiVar.m485a();
                        break;
                    }
                case 4:
                    if (m480a.a != 11) {
                        jl.a(jiVar, m480a.a);
                        break;
                    } else {
                        this.f766c = jiVar.m485a();
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
                        this.f761a = jiVar.m479a();
                        a(true);
                        break;
                    }
                case 7:
                    if (m480a.a != 11) {
                        jl.a(jiVar, m480a.a);
                        break;
                    } else {
                        this.f767d = jiVar.m485a();
                        break;
                    }
                case 8:
                    if (m480a.a != 11) {
                        jl.a(jiVar, m480a.a);
                        break;
                    } else {
                        this.f768e = jiVar.m485a();
                        break;
                    }
                case 9:
                    if (m480a.a != 11) {
                        jl.a(jiVar, m480a.a);
                        break;
                    } else {
                        this.f769f = jiVar.m485a();
                        break;
                    }
                case 10:
                    if (m480a.a != 11) {
                        jl.a(jiVar, m480a.a);
                        break;
                    } else {
                        this.f770g = jiVar.m485a();
                        break;
                    }
            }
            jiVar.g();
        }
    }

    public void a(boolean z) {
        this.f764a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m471a() {
        return this.f763a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m472a(iv ivVar) {
        if (ivVar == null) {
            return false;
        }
        boolean m471a = m471a();
        boolean m471a2 = ivVar.m471a();
        if ((m471a || m471a2) && !(m471a && m471a2 && this.f763a.equals(ivVar.f763a))) {
            return false;
        }
        boolean m473b = m473b();
        boolean m473b2 = ivVar.m473b();
        if ((m473b || m473b2) && !(m473b && m473b2 && this.f762a.m393a(ivVar.f762a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = ivVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f765b.equals(ivVar.f765b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = ivVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f766c.equals(ivVar.f766c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = ivVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f761a == ivVar.f761a)) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = ivVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f767d.equals(ivVar.f767d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = ivVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f768e.equals(ivVar.f768e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = ivVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f769f.equals(ivVar.f769f))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = ivVar.i();
        return !(i2 || i3) || (i2 && i3 && this.f770g.equals(ivVar.f770g));
    }

    public String b() {
        return this.f770g;
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        m470a();
        jiVar.a(f760a);
        if (this.f763a != null && m471a()) {
            jiVar.a(a);
            jiVar.a(this.f763a);
            jiVar.b();
        }
        if (this.f762a != null && m473b()) {
            jiVar.a(b);
            this.f762a.b(jiVar);
            jiVar.b();
        }
        if (this.f765b != null) {
            jiVar.a(c);
            jiVar.a(this.f765b);
            jiVar.b();
        }
        if (this.f766c != null && d()) {
            jiVar.a(d);
            jiVar.a(this.f766c);
            jiVar.b();
        }
        if (e()) {
            jiVar.a(e);
            jiVar.a(this.f761a);
            jiVar.b();
        }
        if (this.f767d != null && f()) {
            jiVar.a(f);
            jiVar.a(this.f767d);
            jiVar.b();
        }
        if (this.f768e != null && g()) {
            jiVar.a(g);
            jiVar.a(this.f768e);
            jiVar.b();
        }
        if (this.f769f != null && h()) {
            jiVar.a(h);
            jiVar.a(this.f769f);
            jiVar.b();
        }
        if (this.f770g != null && i()) {
            jiVar.a(i);
            jiVar.a(this.f770g);
            jiVar.b();
        }
        jiVar.c();
        jiVar.m488a();
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m473b() {
        return this.f762a != null;
    }

    public boolean c() {
        return this.f765b != null;
    }

    public boolean d() {
        return this.f766c != null;
    }

    public boolean e() {
        return this.f764a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof iv)) {
            return m472a((iv) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f767d != null;
    }

    public boolean g() {
        return this.f768e != null;
    }

    public boolean h() {
        return this.f769f != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f770g != null;
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionUnSubscriptionResult(");
        boolean z2 = true;
        if (m471a()) {
            sb.append("debug:");
            if (this.f763a == null) {
                sb.append("null");
            } else {
                sb.append(this.f763a);
            }
            z2 = false;
        }
        if (m473b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f762a == null) {
                sb.append("null");
            } else {
                sb.append(this.f762a);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f765b == null) {
            sb.append("null");
        } else {
            sb.append(this.f765b);
        }
        if (d()) {
            sb.append(", ");
            sb.append("appId:");
            if (this.f766c == null) {
                sb.append("null");
            } else {
                sb.append(this.f766c);
            }
        }
        if (e()) {
            sb.append(", ");
            sb.append("errorCode:");
            sb.append(this.f761a);
        }
        if (f()) {
            sb.append(", ");
            sb.append("reason:");
            if (this.f767d == null) {
                sb.append("null");
            } else {
                sb.append(this.f767d);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append(UrlSchemaHelper.SCHEMA_TYPE_TOPIC);
            if (this.f768e == null) {
                sb.append("null");
            } else {
                sb.append(this.f768e);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f769f == null) {
                sb.append("null");
            } else {
                sb.append(this.f769f);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("category:");
            if (this.f770g == null) {
                sb.append("null");
            } else {
                sb.append(this.f770g);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
