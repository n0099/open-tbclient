package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes6.dex */
public class ir implements ix<ir, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f791a;

    /* renamed from: a  reason: collision with other field name */
    public ib f792a;

    /* renamed from: a  reason: collision with other field name */
    public String f793a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f794a = new BitSet(1);

    /* renamed from: b  reason: collision with other field name */
    public String f795b;

    /* renamed from: c  reason: collision with other field name */
    public String f796c;

    /* renamed from: d  reason: collision with other field name */
    public String f797d;

    /* renamed from: e  reason: collision with other field name */
    public String f798e;

    /* renamed from: f  reason: collision with other field name */
    public String f799f;

    /* renamed from: g  reason: collision with other field name */
    public String f800g;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f790a = new jn("XmPushActionSubscriptionResult");

    /* renamed from: a  reason: collision with root package name */
    private static final jf f14451a = new jf("", Constants.GZIP_CAST_TYPE, 1);

    /* renamed from: b  reason: collision with root package name */
    private static final jf f14452b = new jf("", (byte) 12, 2);
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
    public int compareTo(ir irVar) {
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        int a8;
        int a9;
        int a10;
        if (getClass().equals(irVar.getClass())) {
            int compareTo = Boolean.valueOf(m495a()).compareTo(Boolean.valueOf(irVar.m495a()));
            if (compareTo == 0) {
                if (!m495a() || (a10 = iy.a(this.f793a, irVar.f793a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m497b()).compareTo(Boolean.valueOf(irVar.m497b()));
                    if (compareTo2 == 0) {
                        if (!m497b() || (a9 = iy.a(this.f792a, irVar.f792a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(irVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a8 = iy.a(this.f795b, irVar.f795b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(irVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a7 = iy.a(this.f796c, irVar.f796c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(irVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a6 = iy.a(this.f791a, irVar.f791a)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(irVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a5 = iy.a(this.f797d, irVar.f797d)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(irVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a4 = iy.a(this.f798e, irVar.f798e)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(irVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a3 = iy.a(this.f799f, irVar.f799f)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(irVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a2 = iy.a(this.f800g, irVar.f800g)) == 0) {
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
        return getClass().getName().compareTo(irVar.getClass().getName());
    }

    public String a() {
        return this.f798e;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m494a() {
        if (this.f795b == null) {
            throw new jj("Required field 'id' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m519a();
        while (true) {
            jf m515a = jiVar.m515a();
            if (m515a.f14471a == 0) {
                jiVar.f();
                m494a();
                return;
            }
            switch (m515a.f858a) {
                case 1:
                    if (m515a.f14471a != 11) {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    } else {
                        this.f793a = jiVar.m520a();
                        break;
                    }
                case 2:
                    if (m515a.f14471a != 12) {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    } else {
                        this.f792a = new ib();
                        this.f792a.a(jiVar);
                        break;
                    }
                case 3:
                    if (m515a.f14471a != 11) {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    } else {
                        this.f795b = jiVar.m520a();
                        break;
                    }
                case 4:
                    if (m515a.f14471a != 11) {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    } else {
                        this.f796c = jiVar.m520a();
                        break;
                    }
                case 5:
                default:
                    jl.a(jiVar, m515a.f14471a);
                    break;
                case 6:
                    if (m515a.f14471a != 10) {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    } else {
                        this.f791a = jiVar.m514a();
                        a(true);
                        break;
                    }
                case 7:
                    if (m515a.f14471a != 11) {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    } else {
                        this.f797d = jiVar.m520a();
                        break;
                    }
                case 8:
                    if (m515a.f14471a != 11) {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    } else {
                        this.f798e = jiVar.m520a();
                        break;
                    }
                case 9:
                    if (m515a.f14471a != 11) {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    } else {
                        this.f799f = jiVar.m520a();
                        break;
                    }
                case 10:
                    if (m515a.f14471a != 11) {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    } else {
                        this.f800g = jiVar.m520a();
                        break;
                    }
            }
            jiVar.g();
        }
    }

    public void a(boolean z) {
        this.f794a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m495a() {
        return this.f793a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m496a(ir irVar) {
        if (irVar == null) {
            return false;
        }
        boolean m495a = m495a();
        boolean m495a2 = irVar.m495a();
        if ((m495a || m495a2) && !(m495a && m495a2 && this.f793a.equals(irVar.f793a))) {
            return false;
        }
        boolean m497b = m497b();
        boolean m497b2 = irVar.m497b();
        if ((m497b || m497b2) && !(m497b && m497b2 && this.f792a.m428a(irVar.f792a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = irVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f795b.equals(irVar.f795b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = irVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f796c.equals(irVar.f796c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = irVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f791a == irVar.f791a)) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = irVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f797d.equals(irVar.f797d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = irVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f798e.equals(irVar.f798e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = irVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f799f.equals(irVar.f799f))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = irVar.i();
        return !(i2 || i3) || (i2 && i3 && this.f800g.equals(irVar.f800g));
    }

    public String b() {
        return this.f800g;
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        m494a();
        jiVar.a(f790a);
        if (this.f793a != null && m495a()) {
            jiVar.a(f14451a);
            jiVar.a(this.f793a);
            jiVar.b();
        }
        if (this.f792a != null && m497b()) {
            jiVar.a(f14452b);
            this.f792a.b(jiVar);
            jiVar.b();
        }
        if (this.f795b != null) {
            jiVar.a(c);
            jiVar.a(this.f795b);
            jiVar.b();
        }
        if (this.f796c != null && d()) {
            jiVar.a(d);
            jiVar.a(this.f796c);
            jiVar.b();
        }
        if (e()) {
            jiVar.a(e);
            jiVar.a(this.f791a);
            jiVar.b();
        }
        if (this.f797d != null && f()) {
            jiVar.a(f);
            jiVar.a(this.f797d);
            jiVar.b();
        }
        if (this.f798e != null && g()) {
            jiVar.a(g);
            jiVar.a(this.f798e);
            jiVar.b();
        }
        if (this.f799f != null && h()) {
            jiVar.a(h);
            jiVar.a(this.f799f);
            jiVar.b();
        }
        if (this.f800g != null && i()) {
            jiVar.a(i);
            jiVar.a(this.f800g);
            jiVar.b();
        }
        jiVar.c();
        jiVar.m523a();
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m497b() {
        return this.f792a != null;
    }

    public boolean c() {
        return this.f795b != null;
    }

    public boolean d() {
        return this.f796c != null;
    }

    public boolean e() {
        return this.f794a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ir)) {
            return m496a((ir) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f797d != null;
    }

    public boolean g() {
        return this.f798e != null;
    }

    public boolean h() {
        return this.f799f != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f800g != null;
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionSubscriptionResult(");
        boolean z2 = true;
        if (m495a()) {
            sb.append("debug:");
            if (this.f793a == null) {
                sb.append("null");
            } else {
                sb.append(this.f793a);
            }
            z2 = false;
        }
        if (m497b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f792a == null) {
                sb.append("null");
            } else {
                sb.append(this.f792a);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f795b == null) {
            sb.append("null");
        } else {
            sb.append(this.f795b);
        }
        if (d()) {
            sb.append(", ");
            sb.append("appId:");
            if (this.f796c == null) {
                sb.append("null");
            } else {
                sb.append(this.f796c);
            }
        }
        if (e()) {
            sb.append(", ");
            sb.append("errorCode:");
            sb.append(this.f791a);
        }
        if (f()) {
            sb.append(", ");
            sb.append("reason:");
            if (this.f797d == null) {
                sb.append("null");
            } else {
                sb.append(this.f797d);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append(UrlSchemaHelper.SCHEMA_TYPE_TOPIC);
            if (this.f798e == null) {
                sb.append("null");
            } else {
                sb.append(this.f798e);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f799f == null) {
                sb.append("null");
            } else {
                sb.append(this.f799f);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("category:");
            if (this.f800g == null) {
                sb.append("null");
            } else {
                sb.append(this.f800g);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
