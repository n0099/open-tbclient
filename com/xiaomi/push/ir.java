package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes5.dex */
public class ir implements ix<ir, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f711a;

    /* renamed from: a  reason: collision with other field name */
    public ib f712a;

    /* renamed from: a  reason: collision with other field name */
    public String f713a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f714a = new BitSet(1);

    /* renamed from: b  reason: collision with other field name */
    public String f715b;

    /* renamed from: c  reason: collision with other field name */
    public String f716c;

    /* renamed from: d  reason: collision with other field name */
    public String f717d;

    /* renamed from: e  reason: collision with other field name */
    public String f718e;

    /* renamed from: f  reason: collision with other field name */
    public String f719f;

    /* renamed from: g  reason: collision with other field name */
    public String f720g;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f710a = new jn("XmPushActionSubscriptionResult");

    /* renamed from: a  reason: collision with root package name */
    private static final jf f8450a = new jf("", Constants.GZIP_CAST_TYPE, 1);
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
            int compareTo = Boolean.valueOf(m469a()).compareTo(Boolean.valueOf(irVar.m469a()));
            if (compareTo == 0) {
                if (!m469a() || (a10 = iy.a(this.f713a, irVar.f713a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m471b()).compareTo(Boolean.valueOf(irVar.m471b()));
                    if (compareTo2 == 0) {
                        if (!m471b() || (a9 = iy.a(this.f712a, irVar.f712a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(irVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a8 = iy.a(this.f715b, irVar.f715b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(irVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a7 = iy.a(this.f716c, irVar.f716c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(irVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a6 = iy.a(this.f711a, irVar.f711a)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(irVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a5 = iy.a(this.f717d, irVar.f717d)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(irVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a4 = iy.a(this.f718e, irVar.f718e)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(irVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a3 = iy.a(this.f719f, irVar.f719f)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(irVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a2 = iy.a(this.f720g, irVar.f720g)) == 0) {
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
        return this.f718e;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m468a() {
        if (this.f715b == null) {
            throw new jj("Required field 'id' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m493a();
        while (true) {
            jf m489a = jiVar.m489a();
            if (m489a.f8463a == 0) {
                jiVar.f();
                m468a();
                return;
            }
            switch (m489a.f778a) {
                case 1:
                    if (m489a.f8463a != 11) {
                        jl.a(jiVar, m489a.f8463a);
                        break;
                    } else {
                        this.f713a = jiVar.m494a();
                        break;
                    }
                case 2:
                    if (m489a.f8463a != 12) {
                        jl.a(jiVar, m489a.f8463a);
                        break;
                    } else {
                        this.f712a = new ib();
                        this.f712a.a(jiVar);
                        break;
                    }
                case 3:
                    if (m489a.f8463a != 11) {
                        jl.a(jiVar, m489a.f8463a);
                        break;
                    } else {
                        this.f715b = jiVar.m494a();
                        break;
                    }
                case 4:
                    if (m489a.f8463a != 11) {
                        jl.a(jiVar, m489a.f8463a);
                        break;
                    } else {
                        this.f716c = jiVar.m494a();
                        break;
                    }
                case 5:
                default:
                    jl.a(jiVar, m489a.f8463a);
                    break;
                case 6:
                    if (m489a.f8463a != 10) {
                        jl.a(jiVar, m489a.f8463a);
                        break;
                    } else {
                        this.f711a = jiVar.m488a();
                        a(true);
                        break;
                    }
                case 7:
                    if (m489a.f8463a != 11) {
                        jl.a(jiVar, m489a.f8463a);
                        break;
                    } else {
                        this.f717d = jiVar.m494a();
                        break;
                    }
                case 8:
                    if (m489a.f8463a != 11) {
                        jl.a(jiVar, m489a.f8463a);
                        break;
                    } else {
                        this.f718e = jiVar.m494a();
                        break;
                    }
                case 9:
                    if (m489a.f8463a != 11) {
                        jl.a(jiVar, m489a.f8463a);
                        break;
                    } else {
                        this.f719f = jiVar.m494a();
                        break;
                    }
                case 10:
                    if (m489a.f8463a != 11) {
                        jl.a(jiVar, m489a.f8463a);
                        break;
                    } else {
                        this.f720g = jiVar.m494a();
                        break;
                    }
            }
            jiVar.g();
        }
    }

    public void a(boolean z) {
        this.f714a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m469a() {
        return this.f713a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m470a(ir irVar) {
        if (irVar == null) {
            return false;
        }
        boolean m469a = m469a();
        boolean m469a2 = irVar.m469a();
        if ((m469a || m469a2) && !(m469a && m469a2 && this.f713a.equals(irVar.f713a))) {
            return false;
        }
        boolean m471b = m471b();
        boolean m471b2 = irVar.m471b();
        if ((m471b || m471b2) && !(m471b && m471b2 && this.f712a.m402a(irVar.f712a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = irVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f715b.equals(irVar.f715b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = irVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f716c.equals(irVar.f716c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = irVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f711a == irVar.f711a)) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = irVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f717d.equals(irVar.f717d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = irVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f718e.equals(irVar.f718e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = irVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f719f.equals(irVar.f719f))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = irVar.i();
        return !(i2 || i3) || (i2 && i3 && this.f720g.equals(irVar.f720g));
    }

    public String b() {
        return this.f720g;
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        m468a();
        jiVar.a(f710a);
        if (this.f713a != null && m469a()) {
            jiVar.a(f8450a);
            jiVar.a(this.f713a);
            jiVar.b();
        }
        if (this.f712a != null && m471b()) {
            jiVar.a(b);
            this.f712a.b(jiVar);
            jiVar.b();
        }
        if (this.f715b != null) {
            jiVar.a(c);
            jiVar.a(this.f715b);
            jiVar.b();
        }
        if (this.f716c != null && d()) {
            jiVar.a(d);
            jiVar.a(this.f716c);
            jiVar.b();
        }
        if (e()) {
            jiVar.a(e);
            jiVar.a(this.f711a);
            jiVar.b();
        }
        if (this.f717d != null && f()) {
            jiVar.a(f);
            jiVar.a(this.f717d);
            jiVar.b();
        }
        if (this.f718e != null && g()) {
            jiVar.a(g);
            jiVar.a(this.f718e);
            jiVar.b();
        }
        if (this.f719f != null && h()) {
            jiVar.a(h);
            jiVar.a(this.f719f);
            jiVar.b();
        }
        if (this.f720g != null && i()) {
            jiVar.a(i);
            jiVar.a(this.f720g);
            jiVar.b();
        }
        jiVar.c();
        jiVar.m497a();
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m471b() {
        return this.f712a != null;
    }

    public boolean c() {
        return this.f715b != null;
    }

    public boolean d() {
        return this.f716c != null;
    }

    public boolean e() {
        return this.f714a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ir)) {
            return m470a((ir) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f717d != null;
    }

    public boolean g() {
        return this.f718e != null;
    }

    public boolean h() {
        return this.f719f != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f720g != null;
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionSubscriptionResult(");
        boolean z2 = true;
        if (m469a()) {
            sb.append("debug:");
            if (this.f713a == null) {
                sb.append("null");
            } else {
                sb.append(this.f713a);
            }
            z2 = false;
        }
        if (m471b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f712a == null) {
                sb.append("null");
            } else {
                sb.append(this.f712a);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f715b == null) {
            sb.append("null");
        } else {
            sb.append(this.f715b);
        }
        if (d()) {
            sb.append(", ");
            sb.append("appId:");
            if (this.f716c == null) {
                sb.append("null");
            } else {
                sb.append(this.f716c);
            }
        }
        if (e()) {
            sb.append(", ");
            sb.append("errorCode:");
            sb.append(this.f711a);
        }
        if (f()) {
            sb.append(", ");
            sb.append("reason:");
            if (this.f717d == null) {
                sb.append("null");
            } else {
                sb.append(this.f717d);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append(UrlSchemaHelper.SCHEMA_TYPE_TOPIC);
            if (this.f718e == null) {
                sb.append("null");
            } else {
                sb.append(this.f718e);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f719f == null) {
                sb.append("null");
            } else {
                sb.append(this.f719f);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("category:");
            if (this.f720g == null) {
                sb.append("null");
            } else {
                sb.append(this.f720g);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
