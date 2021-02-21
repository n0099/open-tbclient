package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes6.dex */
public class iv implements ix<iv, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f835a;

    /* renamed from: a  reason: collision with other field name */
    public ib f836a;

    /* renamed from: a  reason: collision with other field name */
    public String f837a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f838a = new BitSet(1);

    /* renamed from: b  reason: collision with other field name */
    public String f839b;

    /* renamed from: c  reason: collision with other field name */
    public String f840c;

    /* renamed from: d  reason: collision with other field name */
    public String f841d;

    /* renamed from: e  reason: collision with other field name */
    public String f842e;

    /* renamed from: f  reason: collision with other field name */
    public String f843f;

    /* renamed from: g  reason: collision with other field name */
    public String f844g;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f834a = new jn("XmPushActionUnSubscriptionResult");

    /* renamed from: a  reason: collision with root package name */
    private static final jf f14161a = new jf("", Constants.GZIP_CAST_TYPE, 1);

    /* renamed from: b  reason: collision with root package name */
    private static final jf f14162b = new jf("", (byte) 12, 2);
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
            int compareTo = Boolean.valueOf(m501a()).compareTo(Boolean.valueOf(ivVar.m501a()));
            if (compareTo == 0) {
                if (!m501a() || (a10 = iy.a(this.f837a, ivVar.f837a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m503b()).compareTo(Boolean.valueOf(ivVar.m503b()));
                    if (compareTo2 == 0) {
                        if (!m503b() || (a9 = iy.a(this.f836a, ivVar.f836a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(ivVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a8 = iy.a(this.f839b, ivVar.f839b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(ivVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a7 = iy.a(this.f840c, ivVar.f840c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(ivVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a6 = iy.a(this.f835a, ivVar.f835a)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(ivVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a5 = iy.a(this.f841d, ivVar.f841d)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ivVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a4 = iy.a(this.f842e, ivVar.f842e)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(ivVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a3 = iy.a(this.f843f, ivVar.f843f)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(ivVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a2 = iy.a(this.f844g, ivVar.f844g)) == 0) {
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
        return this.f842e;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m500a() {
        if (this.f839b == null) {
            throw new jj("Required field 'id' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m514a();
        while (true) {
            jf m510a = jiVar.m510a();
            if (m510a.f14173a == 0) {
                jiVar.f();
                m500a();
                return;
            }
            switch (m510a.f857a) {
                case 1:
                    if (m510a.f14173a != 11) {
                        jl.a(jiVar, m510a.f14173a);
                        break;
                    } else {
                        this.f837a = jiVar.m515a();
                        break;
                    }
                case 2:
                    if (m510a.f14173a != 12) {
                        jl.a(jiVar, m510a.f14173a);
                        break;
                    } else {
                        this.f836a = new ib();
                        this.f836a.a(jiVar);
                        break;
                    }
                case 3:
                    if (m510a.f14173a != 11) {
                        jl.a(jiVar, m510a.f14173a);
                        break;
                    } else {
                        this.f839b = jiVar.m515a();
                        break;
                    }
                case 4:
                    if (m510a.f14173a != 11) {
                        jl.a(jiVar, m510a.f14173a);
                        break;
                    } else {
                        this.f840c = jiVar.m515a();
                        break;
                    }
                case 5:
                default:
                    jl.a(jiVar, m510a.f14173a);
                    break;
                case 6:
                    if (m510a.f14173a != 10) {
                        jl.a(jiVar, m510a.f14173a);
                        break;
                    } else {
                        this.f835a = jiVar.m509a();
                        a(true);
                        break;
                    }
                case 7:
                    if (m510a.f14173a != 11) {
                        jl.a(jiVar, m510a.f14173a);
                        break;
                    } else {
                        this.f841d = jiVar.m515a();
                        break;
                    }
                case 8:
                    if (m510a.f14173a != 11) {
                        jl.a(jiVar, m510a.f14173a);
                        break;
                    } else {
                        this.f842e = jiVar.m515a();
                        break;
                    }
                case 9:
                    if (m510a.f14173a != 11) {
                        jl.a(jiVar, m510a.f14173a);
                        break;
                    } else {
                        this.f843f = jiVar.m515a();
                        break;
                    }
                case 10:
                    if (m510a.f14173a != 11) {
                        jl.a(jiVar, m510a.f14173a);
                        break;
                    } else {
                        this.f844g = jiVar.m515a();
                        break;
                    }
            }
            jiVar.g();
        }
    }

    public void a(boolean z) {
        this.f838a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m501a() {
        return this.f837a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m502a(iv ivVar) {
        if (ivVar == null) {
            return false;
        }
        boolean m501a = m501a();
        boolean m501a2 = ivVar.m501a();
        if ((m501a || m501a2) && !(m501a && m501a2 && this.f837a.equals(ivVar.f837a))) {
            return false;
        }
        boolean m503b = m503b();
        boolean m503b2 = ivVar.m503b();
        if ((m503b || m503b2) && !(m503b && m503b2 && this.f836a.m423a(ivVar.f836a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = ivVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f839b.equals(ivVar.f839b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = ivVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f840c.equals(ivVar.f840c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = ivVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f835a == ivVar.f835a)) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = ivVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f841d.equals(ivVar.f841d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = ivVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f842e.equals(ivVar.f842e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = ivVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f843f.equals(ivVar.f843f))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = ivVar.i();
        return !(i2 || i3) || (i2 && i3 && this.f844g.equals(ivVar.f844g));
    }

    public String b() {
        return this.f844g;
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        m500a();
        jiVar.a(f834a);
        if (this.f837a != null && m501a()) {
            jiVar.a(f14161a);
            jiVar.a(this.f837a);
            jiVar.b();
        }
        if (this.f836a != null && m503b()) {
            jiVar.a(f14162b);
            this.f836a.b(jiVar);
            jiVar.b();
        }
        if (this.f839b != null) {
            jiVar.a(c);
            jiVar.a(this.f839b);
            jiVar.b();
        }
        if (this.f840c != null && d()) {
            jiVar.a(d);
            jiVar.a(this.f840c);
            jiVar.b();
        }
        if (e()) {
            jiVar.a(e);
            jiVar.a(this.f835a);
            jiVar.b();
        }
        if (this.f841d != null && f()) {
            jiVar.a(f);
            jiVar.a(this.f841d);
            jiVar.b();
        }
        if (this.f842e != null && g()) {
            jiVar.a(g);
            jiVar.a(this.f842e);
            jiVar.b();
        }
        if (this.f843f != null && h()) {
            jiVar.a(h);
            jiVar.a(this.f843f);
            jiVar.b();
        }
        if (this.f844g != null && i()) {
            jiVar.a(i);
            jiVar.a(this.f844g);
            jiVar.b();
        }
        jiVar.c();
        jiVar.m518a();
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m503b() {
        return this.f836a != null;
    }

    public boolean c() {
        return this.f839b != null;
    }

    public boolean d() {
        return this.f840c != null;
    }

    public boolean e() {
        return this.f838a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof iv)) {
            return m502a((iv) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f841d != null;
    }

    public boolean g() {
        return this.f842e != null;
    }

    public boolean h() {
        return this.f843f != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f844g != null;
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionUnSubscriptionResult(");
        boolean z2 = true;
        if (m501a()) {
            sb.append("debug:");
            if (this.f837a == null) {
                sb.append("null");
            } else {
                sb.append(this.f837a);
            }
            z2 = false;
        }
        if (m503b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f836a == null) {
                sb.append("null");
            } else {
                sb.append(this.f836a);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f839b == null) {
            sb.append("null");
        } else {
            sb.append(this.f839b);
        }
        if (d()) {
            sb.append(", ");
            sb.append("appId:");
            if (this.f840c == null) {
                sb.append("null");
            } else {
                sb.append(this.f840c);
            }
        }
        if (e()) {
            sb.append(", ");
            sb.append("errorCode:");
            sb.append(this.f835a);
        }
        if (f()) {
            sb.append(", ");
            sb.append("reason:");
            if (this.f841d == null) {
                sb.append("null");
            } else {
                sb.append(this.f841d);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append(UrlSchemaHelper.SCHEMA_TYPE_TOPIC);
            if (this.f842e == null) {
                sb.append("null");
            } else {
                sb.append(this.f842e);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f843f == null) {
                sb.append("null");
            } else {
                sb.append(this.f843f);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("category:");
            if (this.f844g == null) {
                sb.append("null");
            } else {
                sb.append(this.f844g);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
