package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes12.dex */
public class iv implements ix<iv, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f757a;

    /* renamed from: a  reason: collision with other field name */
    public ib f758a;

    /* renamed from: a  reason: collision with other field name */
    public String f759a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f760a = new BitSet(1);

    /* renamed from: b  reason: collision with other field name */
    public String f761b;

    /* renamed from: c  reason: collision with other field name */
    public String f762c;

    /* renamed from: d  reason: collision with other field name */
    public String f763d;

    /* renamed from: e  reason: collision with other field name */
    public String f764e;

    /* renamed from: f  reason: collision with other field name */
    public String f765f;

    /* renamed from: g  reason: collision with other field name */
    public String f766g;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f756a = new jn("XmPushActionUnSubscriptionResult");

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
            int compareTo = Boolean.valueOf(m477a()).compareTo(Boolean.valueOf(ivVar.m477a()));
            if (compareTo == 0) {
                if (!m477a() || (a10 = iy.a(this.f759a, ivVar.f759a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m479b()).compareTo(Boolean.valueOf(ivVar.m479b()));
                    if (compareTo2 == 0) {
                        if (!m479b() || (a9 = iy.a(this.f758a, ivVar.f758a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(ivVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a8 = iy.a(this.f761b, ivVar.f761b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(ivVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a7 = iy.a(this.f762c, ivVar.f762c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(ivVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a6 = iy.a(this.f757a, ivVar.f757a)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(ivVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a5 = iy.a(this.f763d, ivVar.f763d)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ivVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a4 = iy.a(this.f764e, ivVar.f764e)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(ivVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a3 = iy.a(this.f765f, ivVar.f765f)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(ivVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a2 = iy.a(this.f766g, ivVar.f766g)) == 0) {
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
        return this.f764e;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m476a() {
        if (this.f761b == null) {
            throw new jj("Required field 'id' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m490a();
        while (true) {
            jf m486a = jiVar.m486a();
            if (m486a.f5000a == 0) {
                jiVar.f();
                m476a();
                return;
            }
            switch (m486a.f779a) {
                case 1:
                    if (m486a.f5000a != 11) {
                        jl.a(jiVar, m486a.f5000a);
                        break;
                    } else {
                        this.f759a = jiVar.m491a();
                        break;
                    }
                case 2:
                    if (m486a.f5000a != 12) {
                        jl.a(jiVar, m486a.f5000a);
                        break;
                    } else {
                        this.f758a = new ib();
                        this.f758a.a(jiVar);
                        break;
                    }
                case 3:
                    if (m486a.f5000a != 11) {
                        jl.a(jiVar, m486a.f5000a);
                        break;
                    } else {
                        this.f761b = jiVar.m491a();
                        break;
                    }
                case 4:
                    if (m486a.f5000a != 11) {
                        jl.a(jiVar, m486a.f5000a);
                        break;
                    } else {
                        this.f762c = jiVar.m491a();
                        break;
                    }
                case 5:
                default:
                    jl.a(jiVar, m486a.f5000a);
                    break;
                case 6:
                    if (m486a.f5000a != 10) {
                        jl.a(jiVar, m486a.f5000a);
                        break;
                    } else {
                        this.f757a = jiVar.m485a();
                        a(true);
                        break;
                    }
                case 7:
                    if (m486a.f5000a != 11) {
                        jl.a(jiVar, m486a.f5000a);
                        break;
                    } else {
                        this.f763d = jiVar.m491a();
                        break;
                    }
                case 8:
                    if (m486a.f5000a != 11) {
                        jl.a(jiVar, m486a.f5000a);
                        break;
                    } else {
                        this.f764e = jiVar.m491a();
                        break;
                    }
                case 9:
                    if (m486a.f5000a != 11) {
                        jl.a(jiVar, m486a.f5000a);
                        break;
                    } else {
                        this.f765f = jiVar.m491a();
                        break;
                    }
                case 10:
                    if (m486a.f5000a != 11) {
                        jl.a(jiVar, m486a.f5000a);
                        break;
                    } else {
                        this.f766g = jiVar.m491a();
                        break;
                    }
            }
            jiVar.g();
        }
    }

    public void a(boolean z) {
        this.f760a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m477a() {
        return this.f759a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m478a(iv ivVar) {
        if (ivVar == null) {
            return false;
        }
        boolean m477a = m477a();
        boolean m477a2 = ivVar.m477a();
        if ((m477a || m477a2) && !(m477a && m477a2 && this.f759a.equals(ivVar.f759a))) {
            return false;
        }
        boolean m479b = m479b();
        boolean m479b2 = ivVar.m479b();
        if ((m479b || m479b2) && !(m479b && m479b2 && this.f758a.m399a(ivVar.f758a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = ivVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f761b.equals(ivVar.f761b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = ivVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f762c.equals(ivVar.f762c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = ivVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f757a == ivVar.f757a)) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = ivVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f763d.equals(ivVar.f763d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = ivVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f764e.equals(ivVar.f764e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = ivVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f765f.equals(ivVar.f765f))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = ivVar.i();
        return !(i2 || i3) || (i2 && i3 && this.f766g.equals(ivVar.f766g));
    }

    public String b() {
        return this.f766g;
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        m476a();
        jiVar.a(f756a);
        if (this.f759a != null && m477a()) {
            jiVar.a(f4991a);
            jiVar.a(this.f759a);
            jiVar.b();
        }
        if (this.f758a != null && m479b()) {
            jiVar.a(b);
            this.f758a.b(jiVar);
            jiVar.b();
        }
        if (this.f761b != null) {
            jiVar.a(c);
            jiVar.a(this.f761b);
            jiVar.b();
        }
        if (this.f762c != null && d()) {
            jiVar.a(d);
            jiVar.a(this.f762c);
            jiVar.b();
        }
        if (e()) {
            jiVar.a(e);
            jiVar.a(this.f757a);
            jiVar.b();
        }
        if (this.f763d != null && f()) {
            jiVar.a(f);
            jiVar.a(this.f763d);
            jiVar.b();
        }
        if (this.f764e != null && g()) {
            jiVar.a(g);
            jiVar.a(this.f764e);
            jiVar.b();
        }
        if (this.f765f != null && h()) {
            jiVar.a(h);
            jiVar.a(this.f765f);
            jiVar.b();
        }
        if (this.f766g != null && i()) {
            jiVar.a(i);
            jiVar.a(this.f766g);
            jiVar.b();
        }
        jiVar.c();
        jiVar.m494a();
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m479b() {
        return this.f758a != null;
    }

    public boolean c() {
        return this.f761b != null;
    }

    public boolean d() {
        return this.f762c != null;
    }

    public boolean e() {
        return this.f760a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof iv)) {
            return m478a((iv) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f763d != null;
    }

    public boolean g() {
        return this.f764e != null;
    }

    public boolean h() {
        return this.f765f != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f766g != null;
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionUnSubscriptionResult(");
        boolean z2 = true;
        if (m477a()) {
            sb.append("debug:");
            if (this.f759a == null) {
                sb.append("null");
            } else {
                sb.append(this.f759a);
            }
            z2 = false;
        }
        if (m479b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f758a == null) {
                sb.append("null");
            } else {
                sb.append(this.f758a);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f761b == null) {
            sb.append("null");
        } else {
            sb.append(this.f761b);
        }
        if (d()) {
            sb.append(", ");
            sb.append("appId:");
            if (this.f762c == null) {
                sb.append("null");
            } else {
                sb.append(this.f762c);
            }
        }
        if (e()) {
            sb.append(", ");
            sb.append("errorCode:");
            sb.append(this.f757a);
        }
        if (f()) {
            sb.append(", ");
            sb.append("reason:");
            if (this.f763d == null) {
                sb.append("null");
            } else {
                sb.append(this.f763d);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append(UrlSchemaHelper.SCHEMA_TYPE_TOPIC);
            if (this.f764e == null) {
                sb.append("null");
            } else {
                sb.append(this.f764e);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f765f == null) {
                sb.append("null");
            } else {
                sb.append(this.f765f);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("category:");
            if (this.f766g == null) {
                sb.append("null");
            } else {
                sb.append(this.f766g);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
