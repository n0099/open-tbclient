package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes8.dex */
public class ir implements ix<ir, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f717a;

    /* renamed from: a  reason: collision with other field name */
    public ib f718a;

    /* renamed from: a  reason: collision with other field name */
    public String f719a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f720a = new BitSet(1);

    /* renamed from: b  reason: collision with other field name */
    public String f721b;

    /* renamed from: c  reason: collision with other field name */
    public String f722c;

    /* renamed from: d  reason: collision with other field name */
    public String f723d;

    /* renamed from: e  reason: collision with other field name */
    public String f724e;

    /* renamed from: f  reason: collision with other field name */
    public String f725f;

    /* renamed from: g  reason: collision with other field name */
    public String f726g;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f716a = new jn("XmPushActionSubscriptionResult");
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
            int compareTo = Boolean.valueOf(m459a()).compareTo(Boolean.valueOf(irVar.m459a()));
            if (compareTo == 0) {
                if (!m459a() || (a10 = iy.a(this.f719a, irVar.f719a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m461b()).compareTo(Boolean.valueOf(irVar.m461b()));
                    if (compareTo2 == 0) {
                        if (!m461b() || (a9 = iy.a(this.f718a, irVar.f718a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(irVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a8 = iy.a(this.f721b, irVar.f721b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(irVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a7 = iy.a(this.f722c, irVar.f722c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(irVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a6 = iy.a(this.f717a, irVar.f717a)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(irVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a5 = iy.a(this.f723d, irVar.f723d)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(irVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a4 = iy.a(this.f724e, irVar.f724e)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(irVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a3 = iy.a(this.f725f, irVar.f725f)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(irVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a2 = iy.a(this.f726g, irVar.f726g)) == 0) {
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
        return this.f724e;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m458a() {
        if (this.f721b == null) {
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
                m458a();
                return;
            }
            switch (m479a.f784a) {
                case 1:
                    if (m479a.a != 11) {
                        jl.a(jiVar, m479a.a);
                        break;
                    } else {
                        this.f719a = jiVar.m484a();
                        break;
                    }
                case 2:
                    if (m479a.a != 12) {
                        jl.a(jiVar, m479a.a);
                        break;
                    } else {
                        this.f718a = new ib();
                        this.f718a.a(jiVar);
                        break;
                    }
                case 3:
                    if (m479a.a != 11) {
                        jl.a(jiVar, m479a.a);
                        break;
                    } else {
                        this.f721b = jiVar.m484a();
                        break;
                    }
                case 4:
                    if (m479a.a != 11) {
                        jl.a(jiVar, m479a.a);
                        break;
                    } else {
                        this.f722c = jiVar.m484a();
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
                        this.f717a = jiVar.m478a();
                        a(true);
                        break;
                    }
                case 7:
                    if (m479a.a != 11) {
                        jl.a(jiVar, m479a.a);
                        break;
                    } else {
                        this.f723d = jiVar.m484a();
                        break;
                    }
                case 8:
                    if (m479a.a != 11) {
                        jl.a(jiVar, m479a.a);
                        break;
                    } else {
                        this.f724e = jiVar.m484a();
                        break;
                    }
                case 9:
                    if (m479a.a != 11) {
                        jl.a(jiVar, m479a.a);
                        break;
                    } else {
                        this.f725f = jiVar.m484a();
                        break;
                    }
                case 10:
                    if (m479a.a != 11) {
                        jl.a(jiVar, m479a.a);
                        break;
                    } else {
                        this.f726g = jiVar.m484a();
                        break;
                    }
            }
            jiVar.g();
        }
    }

    public void a(boolean z) {
        this.f720a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m459a() {
        return this.f719a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m460a(ir irVar) {
        if (irVar == null) {
            return false;
        }
        boolean m459a = m459a();
        boolean m459a2 = irVar.m459a();
        if ((m459a || m459a2) && !(m459a && m459a2 && this.f719a.equals(irVar.f719a))) {
            return false;
        }
        boolean m461b = m461b();
        boolean m461b2 = irVar.m461b();
        if ((m461b || m461b2) && !(m461b && m461b2 && this.f718a.m392a(irVar.f718a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = irVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f721b.equals(irVar.f721b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = irVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f722c.equals(irVar.f722c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = irVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f717a == irVar.f717a)) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = irVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f723d.equals(irVar.f723d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = irVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f724e.equals(irVar.f724e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = irVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f725f.equals(irVar.f725f))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = irVar.i();
        return !(i2 || i3) || (i2 && i3 && this.f726g.equals(irVar.f726g));
    }

    public String b() {
        return this.f726g;
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        m458a();
        jiVar.a(f716a);
        if (this.f719a != null && m459a()) {
            jiVar.a(a);
            jiVar.a(this.f719a);
            jiVar.b();
        }
        if (this.f718a != null && m461b()) {
            jiVar.a(b);
            this.f718a.b(jiVar);
            jiVar.b();
        }
        if (this.f721b != null) {
            jiVar.a(c);
            jiVar.a(this.f721b);
            jiVar.b();
        }
        if (this.f722c != null && d()) {
            jiVar.a(d);
            jiVar.a(this.f722c);
            jiVar.b();
        }
        if (e()) {
            jiVar.a(e);
            jiVar.a(this.f717a);
            jiVar.b();
        }
        if (this.f723d != null && f()) {
            jiVar.a(f);
            jiVar.a(this.f723d);
            jiVar.b();
        }
        if (this.f724e != null && g()) {
            jiVar.a(g);
            jiVar.a(this.f724e);
            jiVar.b();
        }
        if (this.f725f != null && h()) {
            jiVar.a(h);
            jiVar.a(this.f725f);
            jiVar.b();
        }
        if (this.f726g != null && i()) {
            jiVar.a(i);
            jiVar.a(this.f726g);
            jiVar.b();
        }
        jiVar.c();
        jiVar.m487a();
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m461b() {
        return this.f718a != null;
    }

    public boolean c() {
        return this.f721b != null;
    }

    public boolean d() {
        return this.f722c != null;
    }

    public boolean e() {
        return this.f720a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ir)) {
            return m460a((ir) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f723d != null;
    }

    public boolean g() {
        return this.f724e != null;
    }

    public boolean h() {
        return this.f725f != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f726g != null;
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionSubscriptionResult(");
        boolean z2 = true;
        if (m459a()) {
            sb.append("debug:");
            if (this.f719a == null) {
                sb.append("null");
            } else {
                sb.append(this.f719a);
            }
            z2 = false;
        }
        if (m461b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f718a == null) {
                sb.append("null");
            } else {
                sb.append(this.f718a);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f721b == null) {
            sb.append("null");
        } else {
            sb.append(this.f721b);
        }
        if (d()) {
            sb.append(", ");
            sb.append("appId:");
            if (this.f722c == null) {
                sb.append("null");
            } else {
                sb.append(this.f722c);
            }
        }
        if (e()) {
            sb.append(", ");
            sb.append("errorCode:");
            sb.append(this.f717a);
        }
        if (f()) {
            sb.append(", ");
            sb.append("reason:");
            if (this.f723d == null) {
                sb.append("null");
            } else {
                sb.append(this.f723d);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append(UrlSchemaHelper.SCHEMA_TYPE_TOPIC);
            if (this.f724e == null) {
                sb.append("null");
            } else {
                sb.append(this.f724e);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f725f == null) {
                sb.append("null");
            } else {
                sb.append(this.f725f);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("category:");
            if (this.f726g == null) {
                sb.append("null");
            } else {
                sb.append(this.f726g);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
