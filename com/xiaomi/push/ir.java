package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes18.dex */
public class ir implements ix<ir, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f714a;

    /* renamed from: a  reason: collision with other field name */
    public ib f715a;

    /* renamed from: a  reason: collision with other field name */
    public String f716a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f717a = new BitSet(1);

    /* renamed from: b  reason: collision with other field name */
    public String f718b;

    /* renamed from: c  reason: collision with other field name */
    public String f719c;

    /* renamed from: d  reason: collision with other field name */
    public String f720d;

    /* renamed from: e  reason: collision with other field name */
    public String f721e;

    /* renamed from: f  reason: collision with other field name */
    public String f722f;

    /* renamed from: g  reason: collision with other field name */
    public String f723g;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f713a = new jn("XmPushActionSubscriptionResult");

    /* renamed from: a  reason: collision with root package name */
    private static final jf f4987a = new jf("", Constants.GZIP_CAST_TYPE, 1);
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
            int compareTo = Boolean.valueOf(m468a()).compareTo(Boolean.valueOf(irVar.m468a()));
            if (compareTo == 0) {
                if (!m468a() || (a10 = iy.a(this.f716a, irVar.f716a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m470b()).compareTo(Boolean.valueOf(irVar.m470b()));
                    if (compareTo2 == 0) {
                        if (!m470b() || (a9 = iy.a(this.f715a, irVar.f715a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(irVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a8 = iy.a(this.f718b, irVar.f718b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(irVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a7 = iy.a(this.f719c, irVar.f719c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(irVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a6 = iy.a(this.f714a, irVar.f714a)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(irVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a5 = iy.a(this.f720d, irVar.f720d)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(irVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a4 = iy.a(this.f721e, irVar.f721e)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(irVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a3 = iy.a(this.f722f, irVar.f722f)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(irVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a2 = iy.a(this.f723g, irVar.f723g)) == 0) {
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
        return this.f721e;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m467a() {
        if (this.f718b == null) {
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
                m467a();
                return;
            }
            switch (m488a.f781a) {
                case 1:
                    if (m488a.f5000a != 11) {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    } else {
                        this.f716a = jiVar.m493a();
                        break;
                    }
                case 2:
                    if (m488a.f5000a != 12) {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    } else {
                        this.f715a = new ib();
                        this.f715a.a(jiVar);
                        break;
                    }
                case 3:
                    if (m488a.f5000a != 11) {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    } else {
                        this.f718b = jiVar.m493a();
                        break;
                    }
                case 4:
                    if (m488a.f5000a != 11) {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    } else {
                        this.f719c = jiVar.m493a();
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
                        this.f714a = jiVar.m487a();
                        a(true);
                        break;
                    }
                case 7:
                    if (m488a.f5000a != 11) {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    } else {
                        this.f720d = jiVar.m493a();
                        break;
                    }
                case 8:
                    if (m488a.f5000a != 11) {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    } else {
                        this.f721e = jiVar.m493a();
                        break;
                    }
                case 9:
                    if (m488a.f5000a != 11) {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    } else {
                        this.f722f = jiVar.m493a();
                        break;
                    }
                case 10:
                    if (m488a.f5000a != 11) {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    } else {
                        this.f723g = jiVar.m493a();
                        break;
                    }
            }
            jiVar.g();
        }
    }

    public void a(boolean z) {
        this.f717a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m468a() {
        return this.f716a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m469a(ir irVar) {
        if (irVar == null) {
            return false;
        }
        boolean m468a = m468a();
        boolean m468a2 = irVar.m468a();
        if ((m468a || m468a2) && !(m468a && m468a2 && this.f716a.equals(irVar.f716a))) {
            return false;
        }
        boolean m470b = m470b();
        boolean m470b2 = irVar.m470b();
        if ((m470b || m470b2) && !(m470b && m470b2 && this.f715a.m401a(irVar.f715a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = irVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f718b.equals(irVar.f718b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = irVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f719c.equals(irVar.f719c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = irVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f714a == irVar.f714a)) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = irVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f720d.equals(irVar.f720d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = irVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f721e.equals(irVar.f721e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = irVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f722f.equals(irVar.f722f))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = irVar.i();
        return !(i2 || i3) || (i2 && i3 && this.f723g.equals(irVar.f723g));
    }

    public String b() {
        return this.f723g;
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        m467a();
        jiVar.a(f713a);
        if (this.f716a != null && m468a()) {
            jiVar.a(f4987a);
            jiVar.a(this.f716a);
            jiVar.b();
        }
        if (this.f715a != null && m470b()) {
            jiVar.a(b);
            this.f715a.b(jiVar);
            jiVar.b();
        }
        if (this.f718b != null) {
            jiVar.a(c);
            jiVar.a(this.f718b);
            jiVar.b();
        }
        if (this.f719c != null && d()) {
            jiVar.a(d);
            jiVar.a(this.f719c);
            jiVar.b();
        }
        if (e()) {
            jiVar.a(e);
            jiVar.a(this.f714a);
            jiVar.b();
        }
        if (this.f720d != null && f()) {
            jiVar.a(f);
            jiVar.a(this.f720d);
            jiVar.b();
        }
        if (this.f721e != null && g()) {
            jiVar.a(g);
            jiVar.a(this.f721e);
            jiVar.b();
        }
        if (this.f722f != null && h()) {
            jiVar.a(h);
            jiVar.a(this.f722f);
            jiVar.b();
        }
        if (this.f723g != null && i()) {
            jiVar.a(i);
            jiVar.a(this.f723g);
            jiVar.b();
        }
        jiVar.c();
        jiVar.m496a();
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m470b() {
        return this.f715a != null;
    }

    public boolean c() {
        return this.f718b != null;
    }

    public boolean d() {
        return this.f719c != null;
    }

    public boolean e() {
        return this.f717a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ir)) {
            return m469a((ir) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f720d != null;
    }

    public boolean g() {
        return this.f721e != null;
    }

    public boolean h() {
        return this.f722f != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f723g != null;
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionSubscriptionResult(");
        boolean z2 = true;
        if (m468a()) {
            sb.append("debug:");
            if (this.f716a == null) {
                sb.append("null");
            } else {
                sb.append(this.f716a);
            }
            z2 = false;
        }
        if (m470b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f715a == null) {
                sb.append("null");
            } else {
                sb.append(this.f715a);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f718b == null) {
            sb.append("null");
        } else {
            sb.append(this.f718b);
        }
        if (d()) {
            sb.append(", ");
            sb.append("appId:");
            if (this.f719c == null) {
                sb.append("null");
            } else {
                sb.append(this.f719c);
            }
        }
        if (e()) {
            sb.append(", ");
            sb.append("errorCode:");
            sb.append(this.f714a);
        }
        if (f()) {
            sb.append(", ");
            sb.append("reason:");
            if (this.f720d == null) {
                sb.append("null");
            } else {
                sb.append(this.f720d);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append(UrlSchemaHelper.SCHEMA_TYPE_TOPIC);
            if (this.f721e == null) {
                sb.append("null");
            } else {
                sb.append(this.f721e);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f722f == null) {
                sb.append("null");
            } else {
                sb.append(this.f722f);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("category:");
            if (this.f723g == null) {
                sb.append("null");
            } else {
                sb.append(this.f723g);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
