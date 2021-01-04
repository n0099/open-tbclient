package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes6.dex */
public class ir implements ix<ir, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f790a;

    /* renamed from: a  reason: collision with other field name */
    public ib f791a;

    /* renamed from: a  reason: collision with other field name */
    public String f792a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f793a = new BitSet(1);

    /* renamed from: b  reason: collision with other field name */
    public String f794b;

    /* renamed from: c  reason: collision with other field name */
    public String f795c;

    /* renamed from: d  reason: collision with other field name */
    public String f796d;

    /* renamed from: e  reason: collision with other field name */
    public String f797e;

    /* renamed from: f  reason: collision with other field name */
    public String f798f;

    /* renamed from: g  reason: collision with other field name */
    public String f799g;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f789a = new jn("XmPushActionSubscriptionResult");

    /* renamed from: a  reason: collision with root package name */
    private static final jf f14450a = new jf("", Constants.GZIP_CAST_TYPE, 1);

    /* renamed from: b  reason: collision with root package name */
    private static final jf f14451b = new jf("", (byte) 12, 2);
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
            int compareTo = Boolean.valueOf(m484a()).compareTo(Boolean.valueOf(irVar.m484a()));
            if (compareTo == 0) {
                if (!m484a() || (a10 = iy.a(this.f792a, irVar.f792a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m486b()).compareTo(Boolean.valueOf(irVar.m486b()));
                    if (compareTo2 == 0) {
                        if (!m486b() || (a9 = iy.a(this.f791a, irVar.f791a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(irVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a8 = iy.a(this.f794b, irVar.f794b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(irVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a7 = iy.a(this.f795c, irVar.f795c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(irVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a6 = iy.a(this.f790a, irVar.f790a)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(irVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a5 = iy.a(this.f796d, irVar.f796d)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(irVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a4 = iy.a(this.f797e, irVar.f797e)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(irVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a3 = iy.a(this.f798f, irVar.f798f)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(irVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a2 = iy.a(this.f799g, irVar.f799g)) == 0) {
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
        return this.f797e;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m483a() {
        if (this.f794b == null) {
            throw new jj("Required field 'id' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m508a();
        while (true) {
            jf m504a = jiVar.m504a();
            if (m504a.f14470a == 0) {
                jiVar.f();
                m483a();
                return;
            }
            switch (m504a.f857a) {
                case 1:
                    if (m504a.f14470a != 11) {
                        jl.a(jiVar, m504a.f14470a);
                        break;
                    } else {
                        this.f792a = jiVar.m509a();
                        break;
                    }
                case 2:
                    if (m504a.f14470a != 12) {
                        jl.a(jiVar, m504a.f14470a);
                        break;
                    } else {
                        this.f791a = new ib();
                        this.f791a.a(jiVar);
                        break;
                    }
                case 3:
                    if (m504a.f14470a != 11) {
                        jl.a(jiVar, m504a.f14470a);
                        break;
                    } else {
                        this.f794b = jiVar.m509a();
                        break;
                    }
                case 4:
                    if (m504a.f14470a != 11) {
                        jl.a(jiVar, m504a.f14470a);
                        break;
                    } else {
                        this.f795c = jiVar.m509a();
                        break;
                    }
                case 5:
                default:
                    jl.a(jiVar, m504a.f14470a);
                    break;
                case 6:
                    if (m504a.f14470a != 10) {
                        jl.a(jiVar, m504a.f14470a);
                        break;
                    } else {
                        this.f790a = jiVar.m503a();
                        a(true);
                        break;
                    }
                case 7:
                    if (m504a.f14470a != 11) {
                        jl.a(jiVar, m504a.f14470a);
                        break;
                    } else {
                        this.f796d = jiVar.m509a();
                        break;
                    }
                case 8:
                    if (m504a.f14470a != 11) {
                        jl.a(jiVar, m504a.f14470a);
                        break;
                    } else {
                        this.f797e = jiVar.m509a();
                        break;
                    }
                case 9:
                    if (m504a.f14470a != 11) {
                        jl.a(jiVar, m504a.f14470a);
                        break;
                    } else {
                        this.f798f = jiVar.m509a();
                        break;
                    }
                case 10:
                    if (m504a.f14470a != 11) {
                        jl.a(jiVar, m504a.f14470a);
                        break;
                    } else {
                        this.f799g = jiVar.m509a();
                        break;
                    }
            }
            jiVar.g();
        }
    }

    public void a(boolean z) {
        this.f793a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m484a() {
        return this.f792a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m485a(ir irVar) {
        if (irVar == null) {
            return false;
        }
        boolean m484a = m484a();
        boolean m484a2 = irVar.m484a();
        if ((m484a || m484a2) && !(m484a && m484a2 && this.f792a.equals(irVar.f792a))) {
            return false;
        }
        boolean m486b = m486b();
        boolean m486b2 = irVar.m486b();
        if ((m486b || m486b2) && !(m486b && m486b2 && this.f791a.m417a(irVar.f791a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = irVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f794b.equals(irVar.f794b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = irVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f795c.equals(irVar.f795c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = irVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f790a == irVar.f790a)) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = irVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f796d.equals(irVar.f796d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = irVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f797e.equals(irVar.f797e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = irVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f798f.equals(irVar.f798f))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = irVar.i();
        return !(i2 || i3) || (i2 && i3 && this.f799g.equals(irVar.f799g));
    }

    public String b() {
        return this.f799g;
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        m483a();
        jiVar.a(f789a);
        if (this.f792a != null && m484a()) {
            jiVar.a(f14450a);
            jiVar.a(this.f792a);
            jiVar.b();
        }
        if (this.f791a != null && m486b()) {
            jiVar.a(f14451b);
            this.f791a.b(jiVar);
            jiVar.b();
        }
        if (this.f794b != null) {
            jiVar.a(c);
            jiVar.a(this.f794b);
            jiVar.b();
        }
        if (this.f795c != null && d()) {
            jiVar.a(d);
            jiVar.a(this.f795c);
            jiVar.b();
        }
        if (e()) {
            jiVar.a(e);
            jiVar.a(this.f790a);
            jiVar.b();
        }
        if (this.f796d != null && f()) {
            jiVar.a(f);
            jiVar.a(this.f796d);
            jiVar.b();
        }
        if (this.f797e != null && g()) {
            jiVar.a(g);
            jiVar.a(this.f797e);
            jiVar.b();
        }
        if (this.f798f != null && h()) {
            jiVar.a(h);
            jiVar.a(this.f798f);
            jiVar.b();
        }
        if (this.f799g != null && i()) {
            jiVar.a(i);
            jiVar.a(this.f799g);
            jiVar.b();
        }
        jiVar.c();
        jiVar.m512a();
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m486b() {
        return this.f791a != null;
    }

    public boolean c() {
        return this.f794b != null;
    }

    public boolean d() {
        return this.f795c != null;
    }

    public boolean e() {
        return this.f793a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ir)) {
            return m485a((ir) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f796d != null;
    }

    public boolean g() {
        return this.f797e != null;
    }

    public boolean h() {
        return this.f798f != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f799g != null;
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionSubscriptionResult(");
        boolean z2 = true;
        if (m484a()) {
            sb.append("debug:");
            if (this.f792a == null) {
                sb.append("null");
            } else {
                sb.append(this.f792a);
            }
            z2 = false;
        }
        if (m486b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f791a == null) {
                sb.append("null");
            } else {
                sb.append(this.f791a);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f794b == null) {
            sb.append("null");
        } else {
            sb.append(this.f794b);
        }
        if (d()) {
            sb.append(", ");
            sb.append("appId:");
            if (this.f795c == null) {
                sb.append("null");
            } else {
                sb.append(this.f795c);
            }
        }
        if (e()) {
            sb.append(", ");
            sb.append("errorCode:");
            sb.append(this.f790a);
        }
        if (f()) {
            sb.append(", ");
            sb.append("reason:");
            if (this.f796d == null) {
                sb.append("null");
            } else {
                sb.append(this.f796d);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append(UrlSchemaHelper.SCHEMA_TYPE_TOPIC);
            if (this.f797e == null) {
                sb.append("null");
            } else {
                sb.append(this.f797e);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f798f == null) {
                sb.append("null");
            } else {
                sb.append(this.f798f);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("category:");
            if (this.f799g == null) {
                sb.append("null");
            } else {
                sb.append(this.f799g);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
