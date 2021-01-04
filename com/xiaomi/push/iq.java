package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class iq implements ix<iq, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public ib f781a;

    /* renamed from: a  reason: collision with other field name */
    public String f782a;

    /* renamed from: a  reason: collision with other field name */
    public List<String> f783a;

    /* renamed from: b  reason: collision with other field name */
    public String f784b;

    /* renamed from: c  reason: collision with other field name */
    public String f785c;

    /* renamed from: d  reason: collision with other field name */
    public String f786d;

    /* renamed from: e  reason: collision with other field name */
    public String f787e;

    /* renamed from: f  reason: collision with other field name */
    public String f788f;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f780a = new jn("XmPushActionSubscription");

    /* renamed from: a  reason: collision with root package name */
    private static final jf f14448a = new jf("", Constants.GZIP_CAST_TYPE, 1);

    /* renamed from: b  reason: collision with root package name */
    private static final jf f14449b = new jf("", (byte) 12, 2);
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
            int compareTo = Boolean.valueOf(m481a()).compareTo(Boolean.valueOf(iqVar.m481a()));
            if (compareTo == 0) {
                if (!m481a() || (a9 = iy.a(this.f782a, iqVar.f782a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(iqVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a8 = iy.a(this.f781a, iqVar.f781a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(iqVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a7 = iy.a(this.f784b, iqVar.f784b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(iqVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a6 = iy.a(this.f785c, iqVar.f785c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(iqVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a5 = iy.a(this.f786d, iqVar.f786d)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(iqVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a4 = iy.a(this.f787e, iqVar.f787e)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(iqVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a3 = iy.a(this.f788f, iqVar.f788f)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(iqVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a2 = iy.a(this.f783a, iqVar.f783a)) == 0) {
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
        this.f784b = str;
        return this;
    }

    public void a() {
        if (this.f784b == null) {
            throw new jj("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f785c == null) {
            throw new jj("Required field 'appId' was not present! Struct: " + toString());
        }
        if (this.f786d == null) {
            throw new jj("Required field 'topic' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m508a();
        while (true) {
            jf m504a = jiVar.m504a();
            if (m504a.f14470a == 0) {
                jiVar.f();
                a();
                return;
            }
            switch (m504a.f857a) {
                case 1:
                    if (m504a.f14470a == 11) {
                        this.f782a = jiVar.m509a();
                        break;
                    } else {
                        jl.a(jiVar, m504a.f14470a);
                        break;
                    }
                case 2:
                    if (m504a.f14470a == 12) {
                        this.f781a = new ib();
                        this.f781a.a(jiVar);
                        break;
                    } else {
                        jl.a(jiVar, m504a.f14470a);
                        break;
                    }
                case 3:
                    if (m504a.f14470a == 11) {
                        this.f784b = jiVar.m509a();
                        break;
                    } else {
                        jl.a(jiVar, m504a.f14470a);
                        break;
                    }
                case 4:
                    if (m504a.f14470a == 11) {
                        this.f785c = jiVar.m509a();
                        break;
                    } else {
                        jl.a(jiVar, m504a.f14470a);
                        break;
                    }
                case 5:
                    if (m504a.f14470a == 11) {
                        this.f786d = jiVar.m509a();
                        break;
                    } else {
                        jl.a(jiVar, m504a.f14470a);
                        break;
                    }
                case 6:
                    if (m504a.f14470a == 11) {
                        this.f787e = jiVar.m509a();
                        break;
                    } else {
                        jl.a(jiVar, m504a.f14470a);
                        break;
                    }
                case 7:
                    if (m504a.f14470a == 11) {
                        this.f788f = jiVar.m509a();
                        break;
                    } else {
                        jl.a(jiVar, m504a.f14470a);
                        break;
                    }
                case 8:
                    if (m504a.f14470a == 15) {
                        jg m505a = jiVar.m505a();
                        this.f783a = new ArrayList(m505a.f858a);
                        for (int i = 0; i < m505a.f858a; i++) {
                            this.f783a.add(jiVar.m509a());
                        }
                        jiVar.i();
                        break;
                    } else {
                        jl.a(jiVar, m504a.f14470a);
                        break;
                    }
                default:
                    jl.a(jiVar, m504a.f14470a);
                    break;
            }
            jiVar.g();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m481a() {
        return this.f782a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m482a(iq iqVar) {
        if (iqVar == null) {
            return false;
        }
        boolean m481a = m481a();
        boolean m481a2 = iqVar.m481a();
        if ((m481a || m481a2) && !(m481a && m481a2 && this.f782a.equals(iqVar.f782a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = iqVar.b();
        if ((b2 || b3) && !(b2 && b3 && this.f781a.m417a(iqVar.f781a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = iqVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f784b.equals(iqVar.f784b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = iqVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f785c.equals(iqVar.f785c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = iqVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f786d.equals(iqVar.f786d))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = iqVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f787e.equals(iqVar.f787e))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = iqVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f788f.equals(iqVar.f788f))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = iqVar.h();
        return !(h2 || h3) || (h2 && h3 && this.f783a.equals(iqVar.f783a));
    }

    public iq b(String str) {
        this.f785c = str;
        return this;
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        a();
        jiVar.a(f780a);
        if (this.f782a != null && m481a()) {
            jiVar.a(f14448a);
            jiVar.a(this.f782a);
            jiVar.b();
        }
        if (this.f781a != null && b()) {
            jiVar.a(f14449b);
            this.f781a.b(jiVar);
            jiVar.b();
        }
        if (this.f784b != null) {
            jiVar.a(c);
            jiVar.a(this.f784b);
            jiVar.b();
        }
        if (this.f785c != null) {
            jiVar.a(d);
            jiVar.a(this.f785c);
            jiVar.b();
        }
        if (this.f786d != null) {
            jiVar.a(e);
            jiVar.a(this.f786d);
            jiVar.b();
        }
        if (this.f787e != null && f()) {
            jiVar.a(f);
            jiVar.a(this.f787e);
            jiVar.b();
        }
        if (this.f788f != null && g()) {
            jiVar.a(g);
            jiVar.a(this.f788f);
            jiVar.b();
        }
        if (this.f783a != null && h()) {
            jiVar.a(h);
            jiVar.a(new jg(Constants.GZIP_CAST_TYPE, this.f783a.size()));
            for (String str : this.f783a) {
                jiVar.a(str);
            }
            jiVar.e();
            jiVar.b();
        }
        jiVar.c();
        jiVar.m512a();
    }

    public boolean b() {
        return this.f781a != null;
    }

    public iq c(String str) {
        this.f786d = str;
        return this;
    }

    public boolean c() {
        return this.f784b != null;
    }

    public iq d(String str) {
        this.f787e = str;
        return this;
    }

    public boolean d() {
        return this.f785c != null;
    }

    public iq e(String str) {
        this.f788f = str;
        return this;
    }

    public boolean e() {
        return this.f786d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof iq)) {
            return m482a((iq) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f787e != null;
    }

    public boolean g() {
        return this.f788f != null;
    }

    public boolean h() {
        return this.f783a != null;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionSubscription(");
        boolean z2 = true;
        if (m481a()) {
            sb.append("debug:");
            if (this.f782a == null) {
                sb.append("null");
            } else {
                sb.append(this.f782a);
            }
            z2 = false;
        }
        if (b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f781a == null) {
                sb.append("null");
            } else {
                sb.append(this.f781a);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f784b == null) {
            sb.append("null");
        } else {
            sb.append(this.f784b);
        }
        sb.append(", ");
        sb.append("appId:");
        if (this.f785c == null) {
            sb.append("null");
        } else {
            sb.append(this.f785c);
        }
        sb.append(", ");
        sb.append(UrlSchemaHelper.SCHEMA_TYPE_TOPIC);
        if (this.f786d == null) {
            sb.append("null");
        } else {
            sb.append(this.f786d);
        }
        if (f()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f787e == null) {
                sb.append("null");
            } else {
                sb.append(this.f787e);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("category:");
            if (this.f788f == null) {
                sb.append("null");
            } else {
                sb.append(this.f788f);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("aliases:");
            if (this.f783a == null) {
                sb.append("null");
            } else {
                sb.append(this.f783a);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
