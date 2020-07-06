package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes8.dex */
public class iv implements ix<iv, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f762a;

    /* renamed from: a  reason: collision with other field name */
    public ib f763a;

    /* renamed from: a  reason: collision with other field name */
    public String f764a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f765a = new BitSet(1);

    /* renamed from: b  reason: collision with other field name */
    public String f766b;

    /* renamed from: c  reason: collision with other field name */
    public String f767c;

    /* renamed from: d  reason: collision with other field name */
    public String f768d;

    /* renamed from: e  reason: collision with other field name */
    public String f769e;

    /* renamed from: f  reason: collision with other field name */
    public String f770f;

    /* renamed from: g  reason: collision with other field name */
    public String f771g;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f761a = new jn("XmPushActionUnSubscriptionResult");
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
            int compareTo = Boolean.valueOf(m470a()).compareTo(Boolean.valueOf(ivVar.m470a()));
            if (compareTo == 0) {
                if (!m470a() || (a10 = iy.a(this.f764a, ivVar.f764a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m472b()).compareTo(Boolean.valueOf(ivVar.m472b()));
                    if (compareTo2 == 0) {
                        if (!m472b() || (a9 = iy.a(this.f763a, ivVar.f763a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(ivVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a8 = iy.a(this.f766b, ivVar.f766b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(ivVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a7 = iy.a(this.f767c, ivVar.f767c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(ivVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a6 = iy.a(this.f762a, ivVar.f762a)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(ivVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a5 = iy.a(this.f768d, ivVar.f768d)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ivVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a4 = iy.a(this.f769e, ivVar.f769e)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(ivVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a3 = iy.a(this.f770f, ivVar.f770f)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(ivVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a2 = iy.a(this.f771g, ivVar.f771g)) == 0) {
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
        return this.f769e;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m469a() {
        if (this.f766b == null) {
            throw new jj("Required field 'id' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m483a();
        while (true) {
            jf m479a = jiVar.m479a();
            if (m479a.a == 0) {
                jiVar.f();
                m469a();
                return;
            }
            switch (m479a.f784a) {
                case 1:
                    if (m479a.a != 11) {
                        jl.a(jiVar, m479a.a);
                        break;
                    } else {
                        this.f764a = jiVar.m484a();
                        break;
                    }
                case 2:
                    if (m479a.a != 12) {
                        jl.a(jiVar, m479a.a);
                        break;
                    } else {
                        this.f763a = new ib();
                        this.f763a.a(jiVar);
                        break;
                    }
                case 3:
                    if (m479a.a != 11) {
                        jl.a(jiVar, m479a.a);
                        break;
                    } else {
                        this.f766b = jiVar.m484a();
                        break;
                    }
                case 4:
                    if (m479a.a != 11) {
                        jl.a(jiVar, m479a.a);
                        break;
                    } else {
                        this.f767c = jiVar.m484a();
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
                        this.f762a = jiVar.m478a();
                        a(true);
                        break;
                    }
                case 7:
                    if (m479a.a != 11) {
                        jl.a(jiVar, m479a.a);
                        break;
                    } else {
                        this.f768d = jiVar.m484a();
                        break;
                    }
                case 8:
                    if (m479a.a != 11) {
                        jl.a(jiVar, m479a.a);
                        break;
                    } else {
                        this.f769e = jiVar.m484a();
                        break;
                    }
                case 9:
                    if (m479a.a != 11) {
                        jl.a(jiVar, m479a.a);
                        break;
                    } else {
                        this.f770f = jiVar.m484a();
                        break;
                    }
                case 10:
                    if (m479a.a != 11) {
                        jl.a(jiVar, m479a.a);
                        break;
                    } else {
                        this.f771g = jiVar.m484a();
                        break;
                    }
            }
            jiVar.g();
        }
    }

    public void a(boolean z) {
        this.f765a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m470a() {
        return this.f764a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m471a(iv ivVar) {
        if (ivVar == null) {
            return false;
        }
        boolean m470a = m470a();
        boolean m470a2 = ivVar.m470a();
        if ((m470a || m470a2) && !(m470a && m470a2 && this.f764a.equals(ivVar.f764a))) {
            return false;
        }
        boolean m472b = m472b();
        boolean m472b2 = ivVar.m472b();
        if ((m472b || m472b2) && !(m472b && m472b2 && this.f763a.m392a(ivVar.f763a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = ivVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f766b.equals(ivVar.f766b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = ivVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f767c.equals(ivVar.f767c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = ivVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f762a == ivVar.f762a)) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = ivVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f768d.equals(ivVar.f768d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = ivVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f769e.equals(ivVar.f769e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = ivVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f770f.equals(ivVar.f770f))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = ivVar.i();
        return !(i2 || i3) || (i2 && i3 && this.f771g.equals(ivVar.f771g));
    }

    public String b() {
        return this.f771g;
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        m469a();
        jiVar.a(f761a);
        if (this.f764a != null && m470a()) {
            jiVar.a(a);
            jiVar.a(this.f764a);
            jiVar.b();
        }
        if (this.f763a != null && m472b()) {
            jiVar.a(b);
            this.f763a.b(jiVar);
            jiVar.b();
        }
        if (this.f766b != null) {
            jiVar.a(c);
            jiVar.a(this.f766b);
            jiVar.b();
        }
        if (this.f767c != null && d()) {
            jiVar.a(d);
            jiVar.a(this.f767c);
            jiVar.b();
        }
        if (e()) {
            jiVar.a(e);
            jiVar.a(this.f762a);
            jiVar.b();
        }
        if (this.f768d != null && f()) {
            jiVar.a(f);
            jiVar.a(this.f768d);
            jiVar.b();
        }
        if (this.f769e != null && g()) {
            jiVar.a(g);
            jiVar.a(this.f769e);
            jiVar.b();
        }
        if (this.f770f != null && h()) {
            jiVar.a(h);
            jiVar.a(this.f770f);
            jiVar.b();
        }
        if (this.f771g != null && i()) {
            jiVar.a(i);
            jiVar.a(this.f771g);
            jiVar.b();
        }
        jiVar.c();
        jiVar.m487a();
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m472b() {
        return this.f763a != null;
    }

    public boolean c() {
        return this.f766b != null;
    }

    public boolean d() {
        return this.f767c != null;
    }

    public boolean e() {
        return this.f765a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof iv)) {
            return m471a((iv) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f768d != null;
    }

    public boolean g() {
        return this.f769e != null;
    }

    public boolean h() {
        return this.f770f != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f771g != null;
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionUnSubscriptionResult(");
        boolean z2 = true;
        if (m470a()) {
            sb.append("debug:");
            if (this.f764a == null) {
                sb.append("null");
            } else {
                sb.append(this.f764a);
            }
            z2 = false;
        }
        if (m472b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f763a == null) {
                sb.append("null");
            } else {
                sb.append(this.f763a);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f766b == null) {
            sb.append("null");
        } else {
            sb.append(this.f766b);
        }
        if (d()) {
            sb.append(", ");
            sb.append("appId:");
            if (this.f767c == null) {
                sb.append("null");
            } else {
                sb.append(this.f767c);
            }
        }
        if (e()) {
            sb.append(", ");
            sb.append("errorCode:");
            sb.append(this.f762a);
        }
        if (f()) {
            sb.append(", ");
            sb.append("reason:");
            if (this.f768d == null) {
                sb.append("null");
            } else {
                sb.append(this.f768d);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append(UrlSchemaHelper.SCHEMA_TYPE_TOPIC);
            if (this.f769e == null) {
                sb.append("null");
            } else {
                sb.append(this.f769e);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f770f == null) {
                sb.append("null");
            } else {
                sb.append(this.f770f);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("category:");
            if (this.f771g == null) {
                sb.append("null");
            } else {
                sb.append(this.f771g);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
