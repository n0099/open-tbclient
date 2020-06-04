package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes8.dex */
public class iv implements ix<iv, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f755a;

    /* renamed from: a  reason: collision with other field name */
    public ib f756a;

    /* renamed from: a  reason: collision with other field name */
    public String f757a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f758a = new BitSet(1);

    /* renamed from: b  reason: collision with other field name */
    public String f759b;

    /* renamed from: c  reason: collision with other field name */
    public String f760c;

    /* renamed from: d  reason: collision with other field name */
    public String f761d;

    /* renamed from: e  reason: collision with other field name */
    public String f762e;

    /* renamed from: f  reason: collision with other field name */
    public String f763f;

    /* renamed from: g  reason: collision with other field name */
    public String f764g;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f754a = new jn("XmPushActionUnSubscriptionResult");
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
            int compareTo = Boolean.valueOf(m473a()).compareTo(Boolean.valueOf(ivVar.m473a()));
            if (compareTo == 0) {
                if (!m473a() || (a10 = iy.a(this.f757a, ivVar.f757a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m475b()).compareTo(Boolean.valueOf(ivVar.m475b()));
                    if (compareTo2 == 0) {
                        if (!m475b() || (a9 = iy.a(this.f756a, ivVar.f756a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(ivVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a8 = iy.a(this.f759b, ivVar.f759b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(ivVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a7 = iy.a(this.f760c, ivVar.f760c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(ivVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a6 = iy.a(this.f755a, ivVar.f755a)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(ivVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a5 = iy.a(this.f761d, ivVar.f761d)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ivVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a4 = iy.a(this.f762e, ivVar.f762e)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(ivVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a3 = iy.a(this.f763f, ivVar.f763f)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(ivVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a2 = iy.a(this.f764g, ivVar.f764g)) == 0) {
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
        return this.f762e;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m472a() {
        if (this.f759b == null) {
            throw new jj("Required field 'id' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m486a();
        while (true) {
            jf m482a = jiVar.m482a();
            if (m482a.a == 0) {
                jiVar.f();
                m472a();
                return;
            }
            switch (m482a.f777a) {
                case 1:
                    if (m482a.a != 11) {
                        jl.a(jiVar, m482a.a);
                        break;
                    } else {
                        this.f757a = jiVar.m487a();
                        break;
                    }
                case 2:
                    if (m482a.a != 12) {
                        jl.a(jiVar, m482a.a);
                        break;
                    } else {
                        this.f756a = new ib();
                        this.f756a.a(jiVar);
                        break;
                    }
                case 3:
                    if (m482a.a != 11) {
                        jl.a(jiVar, m482a.a);
                        break;
                    } else {
                        this.f759b = jiVar.m487a();
                        break;
                    }
                case 4:
                    if (m482a.a != 11) {
                        jl.a(jiVar, m482a.a);
                        break;
                    } else {
                        this.f760c = jiVar.m487a();
                        break;
                    }
                case 5:
                default:
                    jl.a(jiVar, m482a.a);
                    break;
                case 6:
                    if (m482a.a != 10) {
                        jl.a(jiVar, m482a.a);
                        break;
                    } else {
                        this.f755a = jiVar.m481a();
                        a(true);
                        break;
                    }
                case 7:
                    if (m482a.a != 11) {
                        jl.a(jiVar, m482a.a);
                        break;
                    } else {
                        this.f761d = jiVar.m487a();
                        break;
                    }
                case 8:
                    if (m482a.a != 11) {
                        jl.a(jiVar, m482a.a);
                        break;
                    } else {
                        this.f762e = jiVar.m487a();
                        break;
                    }
                case 9:
                    if (m482a.a != 11) {
                        jl.a(jiVar, m482a.a);
                        break;
                    } else {
                        this.f763f = jiVar.m487a();
                        break;
                    }
                case 10:
                    if (m482a.a != 11) {
                        jl.a(jiVar, m482a.a);
                        break;
                    } else {
                        this.f764g = jiVar.m487a();
                        break;
                    }
            }
            jiVar.g();
        }
    }

    public void a(boolean z) {
        this.f758a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m473a() {
        return this.f757a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m474a(iv ivVar) {
        if (ivVar == null) {
            return false;
        }
        boolean m473a = m473a();
        boolean m473a2 = ivVar.m473a();
        if ((m473a || m473a2) && !(m473a && m473a2 && this.f757a.equals(ivVar.f757a))) {
            return false;
        }
        boolean m475b = m475b();
        boolean m475b2 = ivVar.m475b();
        if ((m475b || m475b2) && !(m475b && m475b2 && this.f756a.m395a(ivVar.f756a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = ivVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f759b.equals(ivVar.f759b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = ivVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f760c.equals(ivVar.f760c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = ivVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f755a == ivVar.f755a)) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = ivVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f761d.equals(ivVar.f761d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = ivVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f762e.equals(ivVar.f762e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = ivVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f763f.equals(ivVar.f763f))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = ivVar.i();
        return !(i2 || i3) || (i2 && i3 && this.f764g.equals(ivVar.f764g));
    }

    public String b() {
        return this.f764g;
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        m472a();
        jiVar.a(f754a);
        if (this.f757a != null && m473a()) {
            jiVar.a(a);
            jiVar.a(this.f757a);
            jiVar.b();
        }
        if (this.f756a != null && m475b()) {
            jiVar.a(b);
            this.f756a.b(jiVar);
            jiVar.b();
        }
        if (this.f759b != null) {
            jiVar.a(c);
            jiVar.a(this.f759b);
            jiVar.b();
        }
        if (this.f760c != null && d()) {
            jiVar.a(d);
            jiVar.a(this.f760c);
            jiVar.b();
        }
        if (e()) {
            jiVar.a(e);
            jiVar.a(this.f755a);
            jiVar.b();
        }
        if (this.f761d != null && f()) {
            jiVar.a(f);
            jiVar.a(this.f761d);
            jiVar.b();
        }
        if (this.f762e != null && g()) {
            jiVar.a(g);
            jiVar.a(this.f762e);
            jiVar.b();
        }
        if (this.f763f != null && h()) {
            jiVar.a(h);
            jiVar.a(this.f763f);
            jiVar.b();
        }
        if (this.f764g != null && i()) {
            jiVar.a(i);
            jiVar.a(this.f764g);
            jiVar.b();
        }
        jiVar.c();
        jiVar.m490a();
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m475b() {
        return this.f756a != null;
    }

    public boolean c() {
        return this.f759b != null;
    }

    public boolean d() {
        return this.f760c != null;
    }

    public boolean e() {
        return this.f758a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof iv)) {
            return m474a((iv) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f761d != null;
    }

    public boolean g() {
        return this.f762e != null;
    }

    public boolean h() {
        return this.f763f != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f764g != null;
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionUnSubscriptionResult(");
        boolean z2 = true;
        if (m473a()) {
            sb.append("debug:");
            if (this.f757a == null) {
                sb.append("null");
            } else {
                sb.append(this.f757a);
            }
            z2 = false;
        }
        if (m475b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f756a == null) {
                sb.append("null");
            } else {
                sb.append(this.f756a);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f759b == null) {
            sb.append("null");
        } else {
            sb.append(this.f759b);
        }
        if (d()) {
            sb.append(", ");
            sb.append("appId:");
            if (this.f760c == null) {
                sb.append("null");
            } else {
                sb.append(this.f760c);
            }
        }
        if (e()) {
            sb.append(", ");
            sb.append("errorCode:");
            sb.append(this.f755a);
        }
        if (f()) {
            sb.append(", ");
            sb.append("reason:");
            if (this.f761d == null) {
                sb.append("null");
            } else {
                sb.append(this.f761d);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append(UrlSchemaHelper.SCHEMA_TYPE_TOPIC);
            if (this.f762e == null) {
                sb.append("null");
            } else {
                sb.append(this.f762e);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f763f == null) {
                sb.append("null");
            } else {
                sb.append(this.f763f);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("category:");
            if (this.f764g == null) {
                sb.append("null");
            } else {
                sb.append(this.f764g);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
