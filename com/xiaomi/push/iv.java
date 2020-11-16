package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes18.dex */
public class iv implements ix<iv, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f759a;

    /* renamed from: a  reason: collision with other field name */
    public ib f760a;

    /* renamed from: a  reason: collision with other field name */
    public String f761a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f762a = new BitSet(1);

    /* renamed from: b  reason: collision with other field name */
    public String f763b;

    /* renamed from: c  reason: collision with other field name */
    public String f764c;

    /* renamed from: d  reason: collision with other field name */
    public String f765d;

    /* renamed from: e  reason: collision with other field name */
    public String f766e;

    /* renamed from: f  reason: collision with other field name */
    public String f767f;

    /* renamed from: g  reason: collision with other field name */
    public String f768g;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f758a = new jn("XmPushActionUnSubscriptionResult");

    /* renamed from: a  reason: collision with root package name */
    private static final jf f4991a = new jf("", Constants.GZIP_CAST_TYPE, 1);
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
            int compareTo = Boolean.valueOf(m479a()).compareTo(Boolean.valueOf(ivVar.m479a()));
            if (compareTo == 0) {
                if (!m479a() || (a10 = iy.a(this.f761a, ivVar.f761a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m481b()).compareTo(Boolean.valueOf(ivVar.m481b()));
                    if (compareTo2 == 0) {
                        if (!m481b() || (a9 = iy.a(this.f760a, ivVar.f760a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(ivVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a8 = iy.a(this.f763b, ivVar.f763b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(ivVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a7 = iy.a(this.f764c, ivVar.f764c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(ivVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a6 = iy.a(this.f759a, ivVar.f759a)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(ivVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a5 = iy.a(this.f765d, ivVar.f765d)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ivVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a4 = iy.a(this.f766e, ivVar.f766e)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(ivVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a3 = iy.a(this.f767f, ivVar.f767f)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(ivVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a2 = iy.a(this.f768g, ivVar.f768g)) == 0) {
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
        return this.f766e;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m478a() {
        if (this.f763b == null) {
            throw new jj("Required field 'id' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m492a();
        while (true) {
            jf m488a = jiVar.m488a();
            if (m488a.f5000a == 0) {
                jiVar.f();
                m478a();
                return;
            }
            switch (m488a.f781a) {
                case 1:
                    if (m488a.f5000a != 11) {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    } else {
                        this.f761a = jiVar.m493a();
                        break;
                    }
                case 2:
                    if (m488a.f5000a != 12) {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    } else {
                        this.f760a = new ib();
                        this.f760a.a(jiVar);
                        break;
                    }
                case 3:
                    if (m488a.f5000a != 11) {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    } else {
                        this.f763b = jiVar.m493a();
                        break;
                    }
                case 4:
                    if (m488a.f5000a != 11) {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    } else {
                        this.f764c = jiVar.m493a();
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
                        this.f759a = jiVar.m487a();
                        a(true);
                        break;
                    }
                case 7:
                    if (m488a.f5000a != 11) {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    } else {
                        this.f765d = jiVar.m493a();
                        break;
                    }
                case 8:
                    if (m488a.f5000a != 11) {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    } else {
                        this.f766e = jiVar.m493a();
                        break;
                    }
                case 9:
                    if (m488a.f5000a != 11) {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    } else {
                        this.f767f = jiVar.m493a();
                        break;
                    }
                case 10:
                    if (m488a.f5000a != 11) {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    } else {
                        this.f768g = jiVar.m493a();
                        break;
                    }
            }
            jiVar.g();
        }
    }

    public void a(boolean z) {
        this.f762a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m479a() {
        return this.f761a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m480a(iv ivVar) {
        if (ivVar == null) {
            return false;
        }
        boolean m479a = m479a();
        boolean m479a2 = ivVar.m479a();
        if ((m479a || m479a2) && !(m479a && m479a2 && this.f761a.equals(ivVar.f761a))) {
            return false;
        }
        boolean m481b = m481b();
        boolean m481b2 = ivVar.m481b();
        if ((m481b || m481b2) && !(m481b && m481b2 && this.f760a.m401a(ivVar.f760a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = ivVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f763b.equals(ivVar.f763b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = ivVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f764c.equals(ivVar.f764c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = ivVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f759a == ivVar.f759a)) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = ivVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f765d.equals(ivVar.f765d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = ivVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f766e.equals(ivVar.f766e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = ivVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f767f.equals(ivVar.f767f))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = ivVar.i();
        return !(i2 || i3) || (i2 && i3 && this.f768g.equals(ivVar.f768g));
    }

    public String b() {
        return this.f768g;
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        m478a();
        jiVar.a(f758a);
        if (this.f761a != null && m479a()) {
            jiVar.a(f4991a);
            jiVar.a(this.f761a);
            jiVar.b();
        }
        if (this.f760a != null && m481b()) {
            jiVar.a(b);
            this.f760a.b(jiVar);
            jiVar.b();
        }
        if (this.f763b != null) {
            jiVar.a(c);
            jiVar.a(this.f763b);
            jiVar.b();
        }
        if (this.f764c != null && d()) {
            jiVar.a(d);
            jiVar.a(this.f764c);
            jiVar.b();
        }
        if (e()) {
            jiVar.a(e);
            jiVar.a(this.f759a);
            jiVar.b();
        }
        if (this.f765d != null && f()) {
            jiVar.a(f);
            jiVar.a(this.f765d);
            jiVar.b();
        }
        if (this.f766e != null && g()) {
            jiVar.a(g);
            jiVar.a(this.f766e);
            jiVar.b();
        }
        if (this.f767f != null && h()) {
            jiVar.a(h);
            jiVar.a(this.f767f);
            jiVar.b();
        }
        if (this.f768g != null && i()) {
            jiVar.a(i);
            jiVar.a(this.f768g);
            jiVar.b();
        }
        jiVar.c();
        jiVar.m496a();
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m481b() {
        return this.f760a != null;
    }

    public boolean c() {
        return this.f763b != null;
    }

    public boolean d() {
        return this.f764c != null;
    }

    public boolean e() {
        return this.f762a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof iv)) {
            return m480a((iv) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f765d != null;
    }

    public boolean g() {
        return this.f766e != null;
    }

    public boolean h() {
        return this.f767f != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f768g != null;
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionUnSubscriptionResult(");
        boolean z2 = true;
        if (m479a()) {
            sb.append("debug:");
            if (this.f761a == null) {
                sb.append("null");
            } else {
                sb.append(this.f761a);
            }
            z2 = false;
        }
        if (m481b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f760a == null) {
                sb.append("null");
            } else {
                sb.append(this.f760a);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f763b == null) {
            sb.append("null");
        } else {
            sb.append(this.f763b);
        }
        if (d()) {
            sb.append(", ");
            sb.append("appId:");
            if (this.f764c == null) {
                sb.append("null");
            } else {
                sb.append(this.f764c);
            }
        }
        if (e()) {
            sb.append(", ");
            sb.append("errorCode:");
            sb.append(this.f759a);
        }
        if (f()) {
            sb.append(", ");
            sb.append("reason:");
            if (this.f765d == null) {
                sb.append("null");
            } else {
                sb.append(this.f765d);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append(UrlSchemaHelper.SCHEMA_TYPE_TOPIC);
            if (this.f766e == null) {
                sb.append("null");
            } else {
                sb.append(this.f766e);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f767f == null) {
                sb.append("null");
            } else {
                sb.append(this.f767f);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("category:");
            if (this.f768g == null) {
                sb.append("null");
            } else {
                sb.append(this.f768g);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
