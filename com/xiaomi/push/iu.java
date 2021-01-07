package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class iu implements ix<iu, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public ib f827a;

    /* renamed from: a  reason: collision with other field name */
    public String f828a;

    /* renamed from: a  reason: collision with other field name */
    public List<String> f829a;

    /* renamed from: b  reason: collision with other field name */
    public String f830b;

    /* renamed from: c  reason: collision with other field name */
    public String f831c;

    /* renamed from: d  reason: collision with other field name */
    public String f832d;

    /* renamed from: e  reason: collision with other field name */
    public String f833e;

    /* renamed from: f  reason: collision with other field name */
    public String f834f;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f826a = new jn("XmPushActionUnSubscription");

    /* renamed from: a  reason: collision with root package name */
    private static final jf f14457a = new jf("", Constants.GZIP_CAST_TYPE, 1);

    /* renamed from: b  reason: collision with root package name */
    private static final jf f14458b = new jf("", (byte) 12, 2);
    private static final jf c = new jf("", Constants.GZIP_CAST_TYPE, 3);
    private static final jf d = new jf("", Constants.GZIP_CAST_TYPE, 4);
    private static final jf e = new jf("", Constants.GZIP_CAST_TYPE, 5);
    private static final jf f = new jf("", Constants.GZIP_CAST_TYPE, 6);
    private static final jf g = new jf("", Constants.GZIP_CAST_TYPE, 7);
    private static final jf h = new jf("", (byte) 15, 8);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(iu iuVar) {
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        int a8;
        int a9;
        if (getClass().equals(iuVar.getClass())) {
            int compareTo = Boolean.valueOf(m503a()).compareTo(Boolean.valueOf(iuVar.m503a()));
            if (compareTo == 0) {
                if (!m503a() || (a9 = iy.a(this.f828a, iuVar.f828a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(iuVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a8 = iy.a(this.f827a, iuVar.f827a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(iuVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a7 = iy.a(this.f830b, iuVar.f830b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(iuVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a6 = iy.a(this.f831c, iuVar.f831c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(iuVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a5 = iy.a(this.f832d, iuVar.f832d)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(iuVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a4 = iy.a(this.f833e, iuVar.f833e)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(iuVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a3 = iy.a(this.f834f, iuVar.f834f)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(iuVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a2 = iy.a(this.f829a, iuVar.f829a)) == 0) {
                                                                            return 0;
                                                                        }
                                                                        return a2;
                                                                    }
                                                                    return compareTo8;
                                                                }
                                                                return a3;
                                                            }
                                                            return compareTo7;
                                                        }
                                                        return a4;
                                                    }
                                                    return compareTo6;
                                                }
                                                return a5;
                                            }
                                            return compareTo5;
                                        }
                                        return a6;
                                    }
                                    return compareTo4;
                                }
                                return a7;
                            }
                            return compareTo3;
                        }
                        return a8;
                    }
                    return compareTo2;
                }
                return a9;
            }
            return compareTo;
        }
        return getClass().getName().compareTo(iuVar.getClass().getName());
    }

    public iu a(String str) {
        this.f830b = str;
        return this;
    }

    public void a() {
        if (this.f830b == null) {
            throw new jj("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f831c == null) {
            throw new jj("Required field 'appId' was not present! Struct: " + toString());
        }
        if (this.f832d == null) {
            throw new jj("Required field 'topic' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m519a();
        while (true) {
            jf m515a = jiVar.m515a();
            if (m515a.f14471a == 0) {
                jiVar.f();
                a();
                return;
            }
            switch (m515a.f858a) {
                case 1:
                    if (m515a.f14471a == 11) {
                        this.f828a = jiVar.m520a();
                        break;
                    } else {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    }
                case 2:
                    if (m515a.f14471a == 12) {
                        this.f827a = new ib();
                        this.f827a.a(jiVar);
                        break;
                    } else {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    }
                case 3:
                    if (m515a.f14471a == 11) {
                        this.f830b = jiVar.m520a();
                        break;
                    } else {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    }
                case 4:
                    if (m515a.f14471a == 11) {
                        this.f831c = jiVar.m520a();
                        break;
                    } else {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    }
                case 5:
                    if (m515a.f14471a == 11) {
                        this.f832d = jiVar.m520a();
                        break;
                    } else {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    }
                case 6:
                    if (m515a.f14471a == 11) {
                        this.f833e = jiVar.m520a();
                        break;
                    } else {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    }
                case 7:
                    if (m515a.f14471a == 11) {
                        this.f834f = jiVar.m520a();
                        break;
                    } else {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    }
                case 8:
                    if (m515a.f14471a == 15) {
                        jg m516a = jiVar.m516a();
                        this.f829a = new ArrayList(m516a.f859a);
                        for (int i = 0; i < m516a.f859a; i++) {
                            this.f829a.add(jiVar.m520a());
                        }
                        jiVar.i();
                        break;
                    } else {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    }
                default:
                    jl.a(jiVar, m515a.f14471a);
                    break;
            }
            jiVar.g();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m503a() {
        return this.f828a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m504a(iu iuVar) {
        if (iuVar == null) {
            return false;
        }
        boolean m503a = m503a();
        boolean m503a2 = iuVar.m503a();
        if ((m503a || m503a2) && !(m503a && m503a2 && this.f828a.equals(iuVar.f828a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = iuVar.b();
        if ((b2 || b3) && !(b2 && b3 && this.f827a.m428a(iuVar.f827a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = iuVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f830b.equals(iuVar.f830b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = iuVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f831c.equals(iuVar.f831c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = iuVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f832d.equals(iuVar.f832d))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = iuVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f833e.equals(iuVar.f833e))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = iuVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f834f.equals(iuVar.f834f))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = iuVar.h();
        return !(h2 || h3) || (h2 && h3 && this.f829a.equals(iuVar.f829a));
    }

    public iu b(String str) {
        this.f831c = str;
        return this;
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        a();
        jiVar.a(f826a);
        if (this.f828a != null && m503a()) {
            jiVar.a(f14457a);
            jiVar.a(this.f828a);
            jiVar.b();
        }
        if (this.f827a != null && b()) {
            jiVar.a(f14458b);
            this.f827a.b(jiVar);
            jiVar.b();
        }
        if (this.f830b != null) {
            jiVar.a(c);
            jiVar.a(this.f830b);
            jiVar.b();
        }
        if (this.f831c != null) {
            jiVar.a(d);
            jiVar.a(this.f831c);
            jiVar.b();
        }
        if (this.f832d != null) {
            jiVar.a(e);
            jiVar.a(this.f832d);
            jiVar.b();
        }
        if (this.f833e != null && f()) {
            jiVar.a(f);
            jiVar.a(this.f833e);
            jiVar.b();
        }
        if (this.f834f != null && g()) {
            jiVar.a(g);
            jiVar.a(this.f834f);
            jiVar.b();
        }
        if (this.f829a != null && h()) {
            jiVar.a(h);
            jiVar.a(new jg(Constants.GZIP_CAST_TYPE, this.f829a.size()));
            for (String str : this.f829a) {
                jiVar.a(str);
            }
            jiVar.e();
            jiVar.b();
        }
        jiVar.c();
        jiVar.m523a();
    }

    public boolean b() {
        return this.f827a != null;
    }

    public iu c(String str) {
        this.f832d = str;
        return this;
    }

    public boolean c() {
        return this.f830b != null;
    }

    public iu d(String str) {
        this.f833e = str;
        return this;
    }

    public boolean d() {
        return this.f831c != null;
    }

    public iu e(String str) {
        this.f834f = str;
        return this;
    }

    public boolean e() {
        return this.f832d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof iu)) {
            return m504a((iu) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f833e != null;
    }

    public boolean g() {
        return this.f834f != null;
    }

    public boolean h() {
        return this.f829a != null;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionUnSubscription(");
        boolean z2 = true;
        if (m503a()) {
            sb.append("debug:");
            if (this.f828a == null) {
                sb.append("null");
            } else {
                sb.append(this.f828a);
            }
            z2 = false;
        }
        if (b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f827a == null) {
                sb.append("null");
            } else {
                sb.append(this.f827a);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f830b == null) {
            sb.append("null");
        } else {
            sb.append(this.f830b);
        }
        sb.append(", ");
        sb.append("appId:");
        if (this.f831c == null) {
            sb.append("null");
        } else {
            sb.append(this.f831c);
        }
        sb.append(", ");
        sb.append(UrlSchemaHelper.SCHEMA_TYPE_TOPIC);
        if (this.f832d == null) {
            sb.append("null");
        } else {
            sb.append(this.f832d);
        }
        if (f()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f833e == null) {
                sb.append("null");
            } else {
                sb.append(this.f833e);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("category:");
            if (this.f834f == null) {
                sb.append("null");
            } else {
                sb.append(this.f834f);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("aliases:");
            if (this.f829a == null) {
                sb.append("null");
            } else {
                sb.append(this.f829a);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
