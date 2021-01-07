package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes6.dex */
public class iv implements ix<iv, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f836a;

    /* renamed from: a  reason: collision with other field name */
    public ib f837a;

    /* renamed from: a  reason: collision with other field name */
    public String f838a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f839a = new BitSet(1);

    /* renamed from: b  reason: collision with other field name */
    public String f840b;

    /* renamed from: c  reason: collision with other field name */
    public String f841c;

    /* renamed from: d  reason: collision with other field name */
    public String f842d;

    /* renamed from: e  reason: collision with other field name */
    public String f843e;

    /* renamed from: f  reason: collision with other field name */
    public String f844f;

    /* renamed from: g  reason: collision with other field name */
    public String f845g;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f835a = new jn("XmPushActionUnSubscriptionResult");

    /* renamed from: a  reason: collision with root package name */
    private static final jf f14459a = new jf("", Constants.GZIP_CAST_TYPE, 1);

    /* renamed from: b  reason: collision with root package name */
    private static final jf f14460b = new jf("", (byte) 12, 2);
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
            int compareTo = Boolean.valueOf(m506a()).compareTo(Boolean.valueOf(ivVar.m506a()));
            if (compareTo == 0) {
                if (!m506a() || (a10 = iy.a(this.f838a, ivVar.f838a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m508b()).compareTo(Boolean.valueOf(ivVar.m508b()));
                    if (compareTo2 == 0) {
                        if (!m508b() || (a9 = iy.a(this.f837a, ivVar.f837a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(ivVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a8 = iy.a(this.f840b, ivVar.f840b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(ivVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a7 = iy.a(this.f841c, ivVar.f841c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(ivVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a6 = iy.a(this.f836a, ivVar.f836a)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(ivVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a5 = iy.a(this.f842d, ivVar.f842d)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ivVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a4 = iy.a(this.f843e, ivVar.f843e)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(ivVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a3 = iy.a(this.f844f, ivVar.f844f)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(ivVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a2 = iy.a(this.f845g, ivVar.f845g)) == 0) {
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
        return this.f843e;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m505a() {
        if (this.f840b == null) {
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
                m505a();
                return;
            }
            switch (m515a.f858a) {
                case 1:
                    if (m515a.f14471a != 11) {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    } else {
                        this.f838a = jiVar.m520a();
                        break;
                    }
                case 2:
                    if (m515a.f14471a != 12) {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    } else {
                        this.f837a = new ib();
                        this.f837a.a(jiVar);
                        break;
                    }
                case 3:
                    if (m515a.f14471a != 11) {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    } else {
                        this.f840b = jiVar.m520a();
                        break;
                    }
                case 4:
                    if (m515a.f14471a != 11) {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    } else {
                        this.f841c = jiVar.m520a();
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
                        this.f836a = jiVar.m514a();
                        a(true);
                        break;
                    }
                case 7:
                    if (m515a.f14471a != 11) {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    } else {
                        this.f842d = jiVar.m520a();
                        break;
                    }
                case 8:
                    if (m515a.f14471a != 11) {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    } else {
                        this.f843e = jiVar.m520a();
                        break;
                    }
                case 9:
                    if (m515a.f14471a != 11) {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    } else {
                        this.f844f = jiVar.m520a();
                        break;
                    }
                case 10:
                    if (m515a.f14471a != 11) {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    } else {
                        this.f845g = jiVar.m520a();
                        break;
                    }
            }
            jiVar.g();
        }
    }

    public void a(boolean z) {
        this.f839a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m506a() {
        return this.f838a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m507a(iv ivVar) {
        if (ivVar == null) {
            return false;
        }
        boolean m506a = m506a();
        boolean m506a2 = ivVar.m506a();
        if ((m506a || m506a2) && !(m506a && m506a2 && this.f838a.equals(ivVar.f838a))) {
            return false;
        }
        boolean m508b = m508b();
        boolean m508b2 = ivVar.m508b();
        if ((m508b || m508b2) && !(m508b && m508b2 && this.f837a.m428a(ivVar.f837a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = ivVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f840b.equals(ivVar.f840b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = ivVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f841c.equals(ivVar.f841c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = ivVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f836a == ivVar.f836a)) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = ivVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f842d.equals(ivVar.f842d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = ivVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f843e.equals(ivVar.f843e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = ivVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f844f.equals(ivVar.f844f))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = ivVar.i();
        return !(i2 || i3) || (i2 && i3 && this.f845g.equals(ivVar.f845g));
    }

    public String b() {
        return this.f845g;
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        m505a();
        jiVar.a(f835a);
        if (this.f838a != null && m506a()) {
            jiVar.a(f14459a);
            jiVar.a(this.f838a);
            jiVar.b();
        }
        if (this.f837a != null && m508b()) {
            jiVar.a(f14460b);
            this.f837a.b(jiVar);
            jiVar.b();
        }
        if (this.f840b != null) {
            jiVar.a(c);
            jiVar.a(this.f840b);
            jiVar.b();
        }
        if (this.f841c != null && d()) {
            jiVar.a(d);
            jiVar.a(this.f841c);
            jiVar.b();
        }
        if (e()) {
            jiVar.a(e);
            jiVar.a(this.f836a);
            jiVar.b();
        }
        if (this.f842d != null && f()) {
            jiVar.a(f);
            jiVar.a(this.f842d);
            jiVar.b();
        }
        if (this.f843e != null && g()) {
            jiVar.a(g);
            jiVar.a(this.f843e);
            jiVar.b();
        }
        if (this.f844f != null && h()) {
            jiVar.a(h);
            jiVar.a(this.f844f);
            jiVar.b();
        }
        if (this.f845g != null && i()) {
            jiVar.a(i);
            jiVar.a(this.f845g);
            jiVar.b();
        }
        jiVar.c();
        jiVar.m523a();
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m508b() {
        return this.f837a != null;
    }

    public boolean c() {
        return this.f840b != null;
    }

    public boolean d() {
        return this.f841c != null;
    }

    public boolean e() {
        return this.f839a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof iv)) {
            return m507a((iv) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f842d != null;
    }

    public boolean g() {
        return this.f843e != null;
    }

    public boolean h() {
        return this.f844f != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f845g != null;
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionUnSubscriptionResult(");
        boolean z2 = true;
        if (m506a()) {
            sb.append("debug:");
            if (this.f838a == null) {
                sb.append("null");
            } else {
                sb.append(this.f838a);
            }
            z2 = false;
        }
        if (m508b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f837a == null) {
                sb.append("null");
            } else {
                sb.append(this.f837a);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f840b == null) {
            sb.append("null");
        } else {
            sb.append(this.f840b);
        }
        if (d()) {
            sb.append(", ");
            sb.append("appId:");
            if (this.f841c == null) {
                sb.append("null");
            } else {
                sb.append(this.f841c);
            }
        }
        if (e()) {
            sb.append(", ");
            sb.append("errorCode:");
            sb.append(this.f836a);
        }
        if (f()) {
            sb.append(", ");
            sb.append("reason:");
            if (this.f842d == null) {
                sb.append("null");
            } else {
                sb.append(this.f842d);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append(UrlSchemaHelper.SCHEMA_TYPE_TOPIC);
            if (this.f843e == null) {
                sb.append("null");
            } else {
                sb.append(this.f843e);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f844f == null) {
                sb.append("null");
            } else {
                sb.append(this.f844f);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("category:");
            if (this.f845g == null) {
                sb.append("null");
            } else {
                sb.append(this.f845g);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
