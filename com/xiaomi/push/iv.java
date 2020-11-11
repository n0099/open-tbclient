package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes12.dex */
public class iv implements ix<iv, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f756a;

    /* renamed from: a  reason: collision with other field name */
    public ib f757a;

    /* renamed from: a  reason: collision with other field name */
    public String f758a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f759a = new BitSet(1);

    /* renamed from: b  reason: collision with other field name */
    public String f760b;

    /* renamed from: c  reason: collision with other field name */
    public String f761c;

    /* renamed from: d  reason: collision with other field name */
    public String f762d;

    /* renamed from: e  reason: collision with other field name */
    public String f763e;

    /* renamed from: f  reason: collision with other field name */
    public String f764f;

    /* renamed from: g  reason: collision with other field name */
    public String f765g;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f755a = new jn("XmPushActionUnSubscriptionResult");

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
            int compareTo = Boolean.valueOf(m476a()).compareTo(Boolean.valueOf(ivVar.m476a()));
            if (compareTo == 0) {
                if (!m476a() || (a10 = iy.a(this.f758a, ivVar.f758a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m478b()).compareTo(Boolean.valueOf(ivVar.m478b()));
                    if (compareTo2 == 0) {
                        if (!m478b() || (a9 = iy.a(this.f757a, ivVar.f757a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(ivVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a8 = iy.a(this.f760b, ivVar.f760b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(ivVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a7 = iy.a(this.f761c, ivVar.f761c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(ivVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a6 = iy.a(this.f756a, ivVar.f756a)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(ivVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a5 = iy.a(this.f762d, ivVar.f762d)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ivVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a4 = iy.a(this.f763e, ivVar.f763e)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(ivVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a3 = iy.a(this.f764f, ivVar.f764f)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(ivVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a2 = iy.a(this.f765g, ivVar.f765g)) == 0) {
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
        return this.f763e;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m475a() {
        if (this.f760b == null) {
            throw new jj("Required field 'id' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m489a();
        while (true) {
            jf m485a = jiVar.m485a();
            if (m485a.f5000a == 0) {
                jiVar.f();
                m475a();
                return;
            }
            switch (m485a.f778a) {
                case 1:
                    if (m485a.f5000a != 11) {
                        jl.a(jiVar, m485a.f5000a);
                        break;
                    } else {
                        this.f758a = jiVar.m490a();
                        break;
                    }
                case 2:
                    if (m485a.f5000a != 12) {
                        jl.a(jiVar, m485a.f5000a);
                        break;
                    } else {
                        this.f757a = new ib();
                        this.f757a.a(jiVar);
                        break;
                    }
                case 3:
                    if (m485a.f5000a != 11) {
                        jl.a(jiVar, m485a.f5000a);
                        break;
                    } else {
                        this.f760b = jiVar.m490a();
                        break;
                    }
                case 4:
                    if (m485a.f5000a != 11) {
                        jl.a(jiVar, m485a.f5000a);
                        break;
                    } else {
                        this.f761c = jiVar.m490a();
                        break;
                    }
                case 5:
                default:
                    jl.a(jiVar, m485a.f5000a);
                    break;
                case 6:
                    if (m485a.f5000a != 10) {
                        jl.a(jiVar, m485a.f5000a);
                        break;
                    } else {
                        this.f756a = jiVar.m484a();
                        a(true);
                        break;
                    }
                case 7:
                    if (m485a.f5000a != 11) {
                        jl.a(jiVar, m485a.f5000a);
                        break;
                    } else {
                        this.f762d = jiVar.m490a();
                        break;
                    }
                case 8:
                    if (m485a.f5000a != 11) {
                        jl.a(jiVar, m485a.f5000a);
                        break;
                    } else {
                        this.f763e = jiVar.m490a();
                        break;
                    }
                case 9:
                    if (m485a.f5000a != 11) {
                        jl.a(jiVar, m485a.f5000a);
                        break;
                    } else {
                        this.f764f = jiVar.m490a();
                        break;
                    }
                case 10:
                    if (m485a.f5000a != 11) {
                        jl.a(jiVar, m485a.f5000a);
                        break;
                    } else {
                        this.f765g = jiVar.m490a();
                        break;
                    }
            }
            jiVar.g();
        }
    }

    public void a(boolean z) {
        this.f759a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m476a() {
        return this.f758a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m477a(iv ivVar) {
        if (ivVar == null) {
            return false;
        }
        boolean m476a = m476a();
        boolean m476a2 = ivVar.m476a();
        if ((m476a || m476a2) && !(m476a && m476a2 && this.f758a.equals(ivVar.f758a))) {
            return false;
        }
        boolean m478b = m478b();
        boolean m478b2 = ivVar.m478b();
        if ((m478b || m478b2) && !(m478b && m478b2 && this.f757a.m398a(ivVar.f757a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = ivVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f760b.equals(ivVar.f760b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = ivVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f761c.equals(ivVar.f761c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = ivVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f756a == ivVar.f756a)) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = ivVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f762d.equals(ivVar.f762d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = ivVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f763e.equals(ivVar.f763e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = ivVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f764f.equals(ivVar.f764f))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = ivVar.i();
        return !(i2 || i3) || (i2 && i3 && this.f765g.equals(ivVar.f765g));
    }

    public String b() {
        return this.f765g;
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        m475a();
        jiVar.a(f755a);
        if (this.f758a != null && m476a()) {
            jiVar.a(f4991a);
            jiVar.a(this.f758a);
            jiVar.b();
        }
        if (this.f757a != null && m478b()) {
            jiVar.a(b);
            this.f757a.b(jiVar);
            jiVar.b();
        }
        if (this.f760b != null) {
            jiVar.a(c);
            jiVar.a(this.f760b);
            jiVar.b();
        }
        if (this.f761c != null && d()) {
            jiVar.a(d);
            jiVar.a(this.f761c);
            jiVar.b();
        }
        if (e()) {
            jiVar.a(e);
            jiVar.a(this.f756a);
            jiVar.b();
        }
        if (this.f762d != null && f()) {
            jiVar.a(f);
            jiVar.a(this.f762d);
            jiVar.b();
        }
        if (this.f763e != null && g()) {
            jiVar.a(g);
            jiVar.a(this.f763e);
            jiVar.b();
        }
        if (this.f764f != null && h()) {
            jiVar.a(h);
            jiVar.a(this.f764f);
            jiVar.b();
        }
        if (this.f765g != null && i()) {
            jiVar.a(i);
            jiVar.a(this.f765g);
            jiVar.b();
        }
        jiVar.c();
        jiVar.m493a();
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m478b() {
        return this.f757a != null;
    }

    public boolean c() {
        return this.f760b != null;
    }

    public boolean d() {
        return this.f761c != null;
    }

    public boolean e() {
        return this.f759a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof iv)) {
            return m477a((iv) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f762d != null;
    }

    public boolean g() {
        return this.f763e != null;
    }

    public boolean h() {
        return this.f764f != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f765g != null;
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionUnSubscriptionResult(");
        boolean z2 = true;
        if (m476a()) {
            sb.append("debug:");
            if (this.f758a == null) {
                sb.append("null");
            } else {
                sb.append(this.f758a);
            }
            z2 = false;
        }
        if (m478b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f757a == null) {
                sb.append("null");
            } else {
                sb.append(this.f757a);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f760b == null) {
            sb.append("null");
        } else {
            sb.append(this.f760b);
        }
        if (d()) {
            sb.append(", ");
            sb.append("appId:");
            if (this.f761c == null) {
                sb.append("null");
            } else {
                sb.append(this.f761c);
            }
        }
        if (e()) {
            sb.append(", ");
            sb.append("errorCode:");
            sb.append(this.f756a);
        }
        if (f()) {
            sb.append(", ");
            sb.append("reason:");
            if (this.f762d == null) {
                sb.append("null");
            } else {
                sb.append(this.f762d);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append(UrlSchemaHelper.SCHEMA_TYPE_TOPIC);
            if (this.f763e == null) {
                sb.append("null");
            } else {
                sb.append(this.f763e);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f764f == null) {
                sb.append("null");
            } else {
                sb.append(this.f764f);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("category:");
            if (this.f765g == null) {
                sb.append("null");
            } else {
                sb.append(this.f765g);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
