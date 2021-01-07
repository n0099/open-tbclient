package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class iq implements ix<iq, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public ib f782a;

    /* renamed from: a  reason: collision with other field name */
    public String f783a;

    /* renamed from: a  reason: collision with other field name */
    public List<String> f784a;

    /* renamed from: b  reason: collision with other field name */
    public String f785b;

    /* renamed from: c  reason: collision with other field name */
    public String f786c;

    /* renamed from: d  reason: collision with other field name */
    public String f787d;

    /* renamed from: e  reason: collision with other field name */
    public String f788e;

    /* renamed from: f  reason: collision with other field name */
    public String f789f;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f781a = new jn("XmPushActionSubscription");

    /* renamed from: a  reason: collision with root package name */
    private static final jf f14449a = new jf("", Constants.GZIP_CAST_TYPE, 1);

    /* renamed from: b  reason: collision with root package name */
    private static final jf f14450b = new jf("", (byte) 12, 2);
    private static final jf c = new jf("", Constants.GZIP_CAST_TYPE, 3);
    private static final jf d = new jf("", Constants.GZIP_CAST_TYPE, 4);
    private static final jf e = new jf("", Constants.GZIP_CAST_TYPE, 5);
    private static final jf f = new jf("", Constants.GZIP_CAST_TYPE, 6);
    private static final jf g = new jf("", Constants.GZIP_CAST_TYPE, 7);
    private static final jf h = new jf("", (byte) 15, 8);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(iq iqVar) {
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        int a8;
        int a9;
        if (getClass().equals(iqVar.getClass())) {
            int compareTo = Boolean.valueOf(m492a()).compareTo(Boolean.valueOf(iqVar.m492a()));
            if (compareTo == 0) {
                if (!m492a() || (a9 = iy.a(this.f783a, iqVar.f783a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(iqVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a8 = iy.a(this.f782a, iqVar.f782a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(iqVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a7 = iy.a(this.f785b, iqVar.f785b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(iqVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a6 = iy.a(this.f786c, iqVar.f786c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(iqVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a5 = iy.a(this.f787d, iqVar.f787d)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(iqVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a4 = iy.a(this.f788e, iqVar.f788e)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(iqVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a3 = iy.a(this.f789f, iqVar.f789f)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(iqVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a2 = iy.a(this.f784a, iqVar.f784a)) == 0) {
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
        return getClass().getName().compareTo(iqVar.getClass().getName());
    }

    public iq a(String str) {
        this.f785b = str;
        return this;
    }

    public void a() {
        if (this.f785b == null) {
            throw new jj("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f786c == null) {
            throw new jj("Required field 'appId' was not present! Struct: " + toString());
        }
        if (this.f787d == null) {
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
                        this.f783a = jiVar.m520a();
                        break;
                    } else {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    }
                case 2:
                    if (m515a.f14471a == 12) {
                        this.f782a = new ib();
                        this.f782a.a(jiVar);
                        break;
                    } else {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    }
                case 3:
                    if (m515a.f14471a == 11) {
                        this.f785b = jiVar.m520a();
                        break;
                    } else {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    }
                case 4:
                    if (m515a.f14471a == 11) {
                        this.f786c = jiVar.m520a();
                        break;
                    } else {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    }
                case 5:
                    if (m515a.f14471a == 11) {
                        this.f787d = jiVar.m520a();
                        break;
                    } else {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    }
                case 6:
                    if (m515a.f14471a == 11) {
                        this.f788e = jiVar.m520a();
                        break;
                    } else {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    }
                case 7:
                    if (m515a.f14471a == 11) {
                        this.f789f = jiVar.m520a();
                        break;
                    } else {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    }
                case 8:
                    if (m515a.f14471a == 15) {
                        jg m516a = jiVar.m516a();
                        this.f784a = new ArrayList(m516a.f859a);
                        for (int i = 0; i < m516a.f859a; i++) {
                            this.f784a.add(jiVar.m520a());
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
    public boolean m492a() {
        return this.f783a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m493a(iq iqVar) {
        if (iqVar == null) {
            return false;
        }
        boolean m492a = m492a();
        boolean m492a2 = iqVar.m492a();
        if ((m492a || m492a2) && !(m492a && m492a2 && this.f783a.equals(iqVar.f783a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = iqVar.b();
        if ((b2 || b3) && !(b2 && b3 && this.f782a.m428a(iqVar.f782a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = iqVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f785b.equals(iqVar.f785b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = iqVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f786c.equals(iqVar.f786c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = iqVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f787d.equals(iqVar.f787d))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = iqVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f788e.equals(iqVar.f788e))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = iqVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f789f.equals(iqVar.f789f))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = iqVar.h();
        return !(h2 || h3) || (h2 && h3 && this.f784a.equals(iqVar.f784a));
    }

    public iq b(String str) {
        this.f786c = str;
        return this;
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        a();
        jiVar.a(f781a);
        if (this.f783a != null && m492a()) {
            jiVar.a(f14449a);
            jiVar.a(this.f783a);
            jiVar.b();
        }
        if (this.f782a != null && b()) {
            jiVar.a(f14450b);
            this.f782a.b(jiVar);
            jiVar.b();
        }
        if (this.f785b != null) {
            jiVar.a(c);
            jiVar.a(this.f785b);
            jiVar.b();
        }
        if (this.f786c != null) {
            jiVar.a(d);
            jiVar.a(this.f786c);
            jiVar.b();
        }
        if (this.f787d != null) {
            jiVar.a(e);
            jiVar.a(this.f787d);
            jiVar.b();
        }
        if (this.f788e != null && f()) {
            jiVar.a(f);
            jiVar.a(this.f788e);
            jiVar.b();
        }
        if (this.f789f != null && g()) {
            jiVar.a(g);
            jiVar.a(this.f789f);
            jiVar.b();
        }
        if (this.f784a != null && h()) {
            jiVar.a(h);
            jiVar.a(new jg(Constants.GZIP_CAST_TYPE, this.f784a.size()));
            for (String str : this.f784a) {
                jiVar.a(str);
            }
            jiVar.e();
            jiVar.b();
        }
        jiVar.c();
        jiVar.m523a();
    }

    public boolean b() {
        return this.f782a != null;
    }

    public iq c(String str) {
        this.f787d = str;
        return this;
    }

    public boolean c() {
        return this.f785b != null;
    }

    public iq d(String str) {
        this.f788e = str;
        return this;
    }

    public boolean d() {
        return this.f786c != null;
    }

    public iq e(String str) {
        this.f789f = str;
        return this;
    }

    public boolean e() {
        return this.f787d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof iq)) {
            return m493a((iq) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f788e != null;
    }

    public boolean g() {
        return this.f789f != null;
    }

    public boolean h() {
        return this.f784a != null;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionSubscription(");
        boolean z2 = true;
        if (m492a()) {
            sb.append("debug:");
            if (this.f783a == null) {
                sb.append("null");
            } else {
                sb.append(this.f783a);
            }
            z2 = false;
        }
        if (b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f782a == null) {
                sb.append("null");
            } else {
                sb.append(this.f782a);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f785b == null) {
            sb.append("null");
        } else {
            sb.append(this.f785b);
        }
        sb.append(", ");
        sb.append("appId:");
        if (this.f786c == null) {
            sb.append("null");
        } else {
            sb.append(this.f786c);
        }
        sb.append(", ");
        sb.append(UrlSchemaHelper.SCHEMA_TYPE_TOPIC);
        if (this.f787d == null) {
            sb.append("null");
        } else {
            sb.append(this.f787d);
        }
        if (f()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f788e == null) {
                sb.append("null");
            } else {
                sb.append(this.f788e);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("category:");
            if (this.f789f == null) {
                sb.append("null");
            } else {
                sb.append(this.f789f);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("aliases:");
            if (this.f784a == null) {
                sb.append("null");
            } else {
                sb.append(this.f784a);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
