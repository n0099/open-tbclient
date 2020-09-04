package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes7.dex */
public class ir implements ix<ir, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f712a;

    /* renamed from: a  reason: collision with other field name */
    public ib f713a;

    /* renamed from: a  reason: collision with other field name */
    public String f714a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f715a = new BitSet(1);

    /* renamed from: b  reason: collision with other field name */
    public String f716b;

    /* renamed from: c  reason: collision with other field name */
    public String f717c;

    /* renamed from: d  reason: collision with other field name */
    public String f718d;

    /* renamed from: e  reason: collision with other field name */
    public String f719e;

    /* renamed from: f  reason: collision with other field name */
    public String f720f;

    /* renamed from: g  reason: collision with other field name */
    public String f721g;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f711a = new jn("XmPushActionSubscriptionResult");
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
            int compareTo = Boolean.valueOf(m465a()).compareTo(Boolean.valueOf(irVar.m465a()));
            if (compareTo == 0) {
                if (!m465a() || (a10 = iy.a(this.f714a, irVar.f714a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m467b()).compareTo(Boolean.valueOf(irVar.m467b()));
                    if (compareTo2 == 0) {
                        if (!m467b() || (a9 = iy.a(this.f713a, irVar.f713a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(irVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a8 = iy.a(this.f716b, irVar.f716b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(irVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a7 = iy.a(this.f717c, irVar.f717c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(irVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a6 = iy.a(this.f712a, irVar.f712a)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(irVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a5 = iy.a(this.f718d, irVar.f718d)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(irVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a4 = iy.a(this.f719e, irVar.f719e)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(irVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a3 = iy.a(this.f720f, irVar.f720f)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(irVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a2 = iy.a(this.f721g, irVar.f721g)) == 0) {
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
        return this.f719e;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m464a() {
        if (this.f716b == null) {
            throw new jj("Required field 'id' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m489a();
        while (true) {
            jf m485a = jiVar.m485a();
            if (m485a.a == 0) {
                jiVar.f();
                m464a();
                return;
            }
            switch (m485a.f779a) {
                case 1:
                    if (m485a.a != 11) {
                        jl.a(jiVar, m485a.a);
                        break;
                    } else {
                        this.f714a = jiVar.m490a();
                        break;
                    }
                case 2:
                    if (m485a.a != 12) {
                        jl.a(jiVar, m485a.a);
                        break;
                    } else {
                        this.f713a = new ib();
                        this.f713a.a(jiVar);
                        break;
                    }
                case 3:
                    if (m485a.a != 11) {
                        jl.a(jiVar, m485a.a);
                        break;
                    } else {
                        this.f716b = jiVar.m490a();
                        break;
                    }
                case 4:
                    if (m485a.a != 11) {
                        jl.a(jiVar, m485a.a);
                        break;
                    } else {
                        this.f717c = jiVar.m490a();
                        break;
                    }
                case 5:
                default:
                    jl.a(jiVar, m485a.a);
                    break;
                case 6:
                    if (m485a.a != 10) {
                        jl.a(jiVar, m485a.a);
                        break;
                    } else {
                        this.f712a = jiVar.m484a();
                        a(true);
                        break;
                    }
                case 7:
                    if (m485a.a != 11) {
                        jl.a(jiVar, m485a.a);
                        break;
                    } else {
                        this.f718d = jiVar.m490a();
                        break;
                    }
                case 8:
                    if (m485a.a != 11) {
                        jl.a(jiVar, m485a.a);
                        break;
                    } else {
                        this.f719e = jiVar.m490a();
                        break;
                    }
                case 9:
                    if (m485a.a != 11) {
                        jl.a(jiVar, m485a.a);
                        break;
                    } else {
                        this.f720f = jiVar.m490a();
                        break;
                    }
                case 10:
                    if (m485a.a != 11) {
                        jl.a(jiVar, m485a.a);
                        break;
                    } else {
                        this.f721g = jiVar.m490a();
                        break;
                    }
            }
            jiVar.g();
        }
    }

    public void a(boolean z) {
        this.f715a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m465a() {
        return this.f714a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m466a(ir irVar) {
        if (irVar == null) {
            return false;
        }
        boolean m465a = m465a();
        boolean m465a2 = irVar.m465a();
        if ((m465a || m465a2) && !(m465a && m465a2 && this.f714a.equals(irVar.f714a))) {
            return false;
        }
        boolean m467b = m467b();
        boolean m467b2 = irVar.m467b();
        if ((m467b || m467b2) && !(m467b && m467b2 && this.f713a.m398a(irVar.f713a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = irVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f716b.equals(irVar.f716b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = irVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f717c.equals(irVar.f717c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = irVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f712a == irVar.f712a)) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = irVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f718d.equals(irVar.f718d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = irVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f719e.equals(irVar.f719e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = irVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f720f.equals(irVar.f720f))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = irVar.i();
        return !(i2 || i3) || (i2 && i3 && this.f721g.equals(irVar.f721g));
    }

    public String b() {
        return this.f721g;
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        m464a();
        jiVar.a(f711a);
        if (this.f714a != null && m465a()) {
            jiVar.a(a);
            jiVar.a(this.f714a);
            jiVar.b();
        }
        if (this.f713a != null && m467b()) {
            jiVar.a(b);
            this.f713a.b(jiVar);
            jiVar.b();
        }
        if (this.f716b != null) {
            jiVar.a(c);
            jiVar.a(this.f716b);
            jiVar.b();
        }
        if (this.f717c != null && d()) {
            jiVar.a(d);
            jiVar.a(this.f717c);
            jiVar.b();
        }
        if (e()) {
            jiVar.a(e);
            jiVar.a(this.f712a);
            jiVar.b();
        }
        if (this.f718d != null && f()) {
            jiVar.a(f);
            jiVar.a(this.f718d);
            jiVar.b();
        }
        if (this.f719e != null && g()) {
            jiVar.a(g);
            jiVar.a(this.f719e);
            jiVar.b();
        }
        if (this.f720f != null && h()) {
            jiVar.a(h);
            jiVar.a(this.f720f);
            jiVar.b();
        }
        if (this.f721g != null && i()) {
            jiVar.a(i);
            jiVar.a(this.f721g);
            jiVar.b();
        }
        jiVar.c();
        jiVar.m493a();
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m467b() {
        return this.f713a != null;
    }

    public boolean c() {
        return this.f716b != null;
    }

    public boolean d() {
        return this.f717c != null;
    }

    public boolean e() {
        return this.f715a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ir)) {
            return m466a((ir) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f718d != null;
    }

    public boolean g() {
        return this.f719e != null;
    }

    public boolean h() {
        return this.f720f != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f721g != null;
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionSubscriptionResult(");
        boolean z2 = true;
        if (m465a()) {
            sb.append("debug:");
            if (this.f714a == null) {
                sb.append("null");
            } else {
                sb.append(this.f714a);
            }
            z2 = false;
        }
        if (m467b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f713a == null) {
                sb.append("null");
            } else {
                sb.append(this.f713a);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f716b == null) {
            sb.append("null");
        } else {
            sb.append(this.f716b);
        }
        if (d()) {
            sb.append(", ");
            sb.append("appId:");
            if (this.f717c == null) {
                sb.append("null");
            } else {
                sb.append(this.f717c);
            }
        }
        if (e()) {
            sb.append(", ");
            sb.append("errorCode:");
            sb.append(this.f712a);
        }
        if (f()) {
            sb.append(", ");
            sb.append("reason:");
            if (this.f718d == null) {
                sb.append("null");
            } else {
                sb.append(this.f718d);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append(UrlSchemaHelper.SCHEMA_TYPE_TOPIC);
            if (this.f719e == null) {
                sb.append("null");
            } else {
                sb.append(this.f719e);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f720f == null) {
                sb.append("null");
            } else {
                sb.append(this.f720f);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("category:");
            if (this.f721g == null) {
                sb.append("null");
            } else {
                sb.append(this.f721g);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
