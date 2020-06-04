package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes8.dex */
public class ir implements ix<ir, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f710a;

    /* renamed from: a  reason: collision with other field name */
    public ib f711a;

    /* renamed from: a  reason: collision with other field name */
    public String f712a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f713a = new BitSet(1);

    /* renamed from: b  reason: collision with other field name */
    public String f714b;

    /* renamed from: c  reason: collision with other field name */
    public String f715c;

    /* renamed from: d  reason: collision with other field name */
    public String f716d;

    /* renamed from: e  reason: collision with other field name */
    public String f717e;

    /* renamed from: f  reason: collision with other field name */
    public String f718f;

    /* renamed from: g  reason: collision with other field name */
    public String f719g;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f709a = new jn("XmPushActionSubscriptionResult");
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
            int compareTo = Boolean.valueOf(m462a()).compareTo(Boolean.valueOf(irVar.m462a()));
            if (compareTo == 0) {
                if (!m462a() || (a10 = iy.a(this.f712a, irVar.f712a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m464b()).compareTo(Boolean.valueOf(irVar.m464b()));
                    if (compareTo2 == 0) {
                        if (!m464b() || (a9 = iy.a(this.f711a, irVar.f711a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(irVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a8 = iy.a(this.f714b, irVar.f714b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(irVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a7 = iy.a(this.f715c, irVar.f715c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(irVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a6 = iy.a(this.f710a, irVar.f710a)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(irVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a5 = iy.a(this.f716d, irVar.f716d)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(irVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a4 = iy.a(this.f717e, irVar.f717e)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(irVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a3 = iy.a(this.f718f, irVar.f718f)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(irVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a2 = iy.a(this.f719g, irVar.f719g)) == 0) {
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
        return this.f717e;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m461a() {
        if (this.f714b == null) {
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
                m461a();
                return;
            }
            switch (m482a.f777a) {
                case 1:
                    if (m482a.a != 11) {
                        jl.a(jiVar, m482a.a);
                        break;
                    } else {
                        this.f712a = jiVar.m487a();
                        break;
                    }
                case 2:
                    if (m482a.a != 12) {
                        jl.a(jiVar, m482a.a);
                        break;
                    } else {
                        this.f711a = new ib();
                        this.f711a.a(jiVar);
                        break;
                    }
                case 3:
                    if (m482a.a != 11) {
                        jl.a(jiVar, m482a.a);
                        break;
                    } else {
                        this.f714b = jiVar.m487a();
                        break;
                    }
                case 4:
                    if (m482a.a != 11) {
                        jl.a(jiVar, m482a.a);
                        break;
                    } else {
                        this.f715c = jiVar.m487a();
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
                        this.f710a = jiVar.m481a();
                        a(true);
                        break;
                    }
                case 7:
                    if (m482a.a != 11) {
                        jl.a(jiVar, m482a.a);
                        break;
                    } else {
                        this.f716d = jiVar.m487a();
                        break;
                    }
                case 8:
                    if (m482a.a != 11) {
                        jl.a(jiVar, m482a.a);
                        break;
                    } else {
                        this.f717e = jiVar.m487a();
                        break;
                    }
                case 9:
                    if (m482a.a != 11) {
                        jl.a(jiVar, m482a.a);
                        break;
                    } else {
                        this.f718f = jiVar.m487a();
                        break;
                    }
                case 10:
                    if (m482a.a != 11) {
                        jl.a(jiVar, m482a.a);
                        break;
                    } else {
                        this.f719g = jiVar.m487a();
                        break;
                    }
            }
            jiVar.g();
        }
    }

    public void a(boolean z) {
        this.f713a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m462a() {
        return this.f712a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m463a(ir irVar) {
        if (irVar == null) {
            return false;
        }
        boolean m462a = m462a();
        boolean m462a2 = irVar.m462a();
        if ((m462a || m462a2) && !(m462a && m462a2 && this.f712a.equals(irVar.f712a))) {
            return false;
        }
        boolean m464b = m464b();
        boolean m464b2 = irVar.m464b();
        if ((m464b || m464b2) && !(m464b && m464b2 && this.f711a.m395a(irVar.f711a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = irVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f714b.equals(irVar.f714b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = irVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f715c.equals(irVar.f715c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = irVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f710a == irVar.f710a)) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = irVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f716d.equals(irVar.f716d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = irVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f717e.equals(irVar.f717e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = irVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f718f.equals(irVar.f718f))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = irVar.i();
        return !(i2 || i3) || (i2 && i3 && this.f719g.equals(irVar.f719g));
    }

    public String b() {
        return this.f719g;
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        m461a();
        jiVar.a(f709a);
        if (this.f712a != null && m462a()) {
            jiVar.a(a);
            jiVar.a(this.f712a);
            jiVar.b();
        }
        if (this.f711a != null && m464b()) {
            jiVar.a(b);
            this.f711a.b(jiVar);
            jiVar.b();
        }
        if (this.f714b != null) {
            jiVar.a(c);
            jiVar.a(this.f714b);
            jiVar.b();
        }
        if (this.f715c != null && d()) {
            jiVar.a(d);
            jiVar.a(this.f715c);
            jiVar.b();
        }
        if (e()) {
            jiVar.a(e);
            jiVar.a(this.f710a);
            jiVar.b();
        }
        if (this.f716d != null && f()) {
            jiVar.a(f);
            jiVar.a(this.f716d);
            jiVar.b();
        }
        if (this.f717e != null && g()) {
            jiVar.a(g);
            jiVar.a(this.f717e);
            jiVar.b();
        }
        if (this.f718f != null && h()) {
            jiVar.a(h);
            jiVar.a(this.f718f);
            jiVar.b();
        }
        if (this.f719g != null && i()) {
            jiVar.a(i);
            jiVar.a(this.f719g);
            jiVar.b();
        }
        jiVar.c();
        jiVar.m490a();
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m464b() {
        return this.f711a != null;
    }

    public boolean c() {
        return this.f714b != null;
    }

    public boolean d() {
        return this.f715c != null;
    }

    public boolean e() {
        return this.f713a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ir)) {
            return m463a((ir) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f716d != null;
    }

    public boolean g() {
        return this.f717e != null;
    }

    public boolean h() {
        return this.f718f != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f719g != null;
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionSubscriptionResult(");
        boolean z2 = true;
        if (m462a()) {
            sb.append("debug:");
            if (this.f712a == null) {
                sb.append("null");
            } else {
                sb.append(this.f712a);
            }
            z2 = false;
        }
        if (m464b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f711a == null) {
                sb.append("null");
            } else {
                sb.append(this.f711a);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f714b == null) {
            sb.append("null");
        } else {
            sb.append(this.f714b);
        }
        if (d()) {
            sb.append(", ");
            sb.append("appId:");
            if (this.f715c == null) {
                sb.append("null");
            } else {
                sb.append(this.f715c);
            }
        }
        if (e()) {
            sb.append(", ");
            sb.append("errorCode:");
            sb.append(this.f710a);
        }
        if (f()) {
            sb.append(", ");
            sb.append("reason:");
            if (this.f716d == null) {
                sb.append("null");
            } else {
                sb.append(this.f716d);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append(UrlSchemaHelper.SCHEMA_TYPE_TOPIC);
            if (this.f717e == null) {
                sb.append("null");
            } else {
                sb.append(this.f717e);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f718f == null) {
                sb.append("null");
            } else {
                sb.append(this.f718f);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("category:");
            if (this.f719g == null) {
                sb.append("null");
            } else {
                sb.append(this.f719g);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
