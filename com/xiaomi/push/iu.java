package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes18.dex */
public class iu implements ix<iu, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public ib f750a;

    /* renamed from: a  reason: collision with other field name */
    public String f751a;

    /* renamed from: a  reason: collision with other field name */
    public List<String> f752a;

    /* renamed from: b  reason: collision with other field name */
    public String f753b;

    /* renamed from: c  reason: collision with other field name */
    public String f754c;

    /* renamed from: d  reason: collision with other field name */
    public String f755d;

    /* renamed from: e  reason: collision with other field name */
    public String f756e;

    /* renamed from: f  reason: collision with other field name */
    public String f757f;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f749a = new jn("XmPushActionUnSubscription");

    /* renamed from: a  reason: collision with root package name */
    private static final jf f4990a = new jf("", Constants.GZIP_CAST_TYPE, 1);
    private static final jf b = new jf("", (byte) 12, 2);
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
            int compareTo = Boolean.valueOf(m476a()).compareTo(Boolean.valueOf(iuVar.m476a()));
            if (compareTo == 0) {
                if (!m476a() || (a9 = iy.a(this.f751a, iuVar.f751a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(iuVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a8 = iy.a(this.f750a, iuVar.f750a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(iuVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a7 = iy.a(this.f753b, iuVar.f753b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(iuVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a6 = iy.a(this.f754c, iuVar.f754c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(iuVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a5 = iy.a(this.f755d, iuVar.f755d)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(iuVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a4 = iy.a(this.f756e, iuVar.f756e)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(iuVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a3 = iy.a(this.f757f, iuVar.f757f)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(iuVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a2 = iy.a(this.f752a, iuVar.f752a)) == 0) {
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
        this.f753b = str;
        return this;
    }

    public void a() {
        if (this.f753b == null) {
            throw new jj("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f754c == null) {
            throw new jj("Required field 'appId' was not present! Struct: " + toString());
        }
        if (this.f755d == null) {
            throw new jj("Required field 'topic' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m492a();
        while (true) {
            jf m488a = jiVar.m488a();
            if (m488a.f5000a == 0) {
                jiVar.f();
                a();
                return;
            }
            switch (m488a.f781a) {
                case 1:
                    if (m488a.f5000a == 11) {
                        this.f751a = jiVar.m493a();
                        break;
                    } else {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    }
                case 2:
                    if (m488a.f5000a == 12) {
                        this.f750a = new ib();
                        this.f750a.a(jiVar);
                        break;
                    } else {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    }
                case 3:
                    if (m488a.f5000a == 11) {
                        this.f753b = jiVar.m493a();
                        break;
                    } else {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    }
                case 4:
                    if (m488a.f5000a == 11) {
                        this.f754c = jiVar.m493a();
                        break;
                    } else {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    }
                case 5:
                    if (m488a.f5000a == 11) {
                        this.f755d = jiVar.m493a();
                        break;
                    } else {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    }
                case 6:
                    if (m488a.f5000a == 11) {
                        this.f756e = jiVar.m493a();
                        break;
                    } else {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    }
                case 7:
                    if (m488a.f5000a == 11) {
                        this.f757f = jiVar.m493a();
                        break;
                    } else {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    }
                case 8:
                    if (m488a.f5000a == 15) {
                        jg m489a = jiVar.m489a();
                        this.f752a = new ArrayList(m489a.f782a);
                        for (int i = 0; i < m489a.f782a; i++) {
                            this.f752a.add(jiVar.m493a());
                        }
                        jiVar.i();
                        break;
                    } else {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    }
                default:
                    jl.a(jiVar, m488a.f5000a);
                    break;
            }
            jiVar.g();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m476a() {
        return this.f751a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m477a(iu iuVar) {
        if (iuVar == null) {
            return false;
        }
        boolean m476a = m476a();
        boolean m476a2 = iuVar.m476a();
        if ((m476a || m476a2) && !(m476a && m476a2 && this.f751a.equals(iuVar.f751a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = iuVar.b();
        if ((b2 || b3) && !(b2 && b3 && this.f750a.m401a(iuVar.f750a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = iuVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f753b.equals(iuVar.f753b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = iuVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f754c.equals(iuVar.f754c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = iuVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f755d.equals(iuVar.f755d))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = iuVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f756e.equals(iuVar.f756e))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = iuVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f757f.equals(iuVar.f757f))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = iuVar.h();
        return !(h2 || h3) || (h2 && h3 && this.f752a.equals(iuVar.f752a));
    }

    public iu b(String str) {
        this.f754c = str;
        return this;
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        a();
        jiVar.a(f749a);
        if (this.f751a != null && m476a()) {
            jiVar.a(f4990a);
            jiVar.a(this.f751a);
            jiVar.b();
        }
        if (this.f750a != null && b()) {
            jiVar.a(b);
            this.f750a.b(jiVar);
            jiVar.b();
        }
        if (this.f753b != null) {
            jiVar.a(c);
            jiVar.a(this.f753b);
            jiVar.b();
        }
        if (this.f754c != null) {
            jiVar.a(d);
            jiVar.a(this.f754c);
            jiVar.b();
        }
        if (this.f755d != null) {
            jiVar.a(e);
            jiVar.a(this.f755d);
            jiVar.b();
        }
        if (this.f756e != null && f()) {
            jiVar.a(f);
            jiVar.a(this.f756e);
            jiVar.b();
        }
        if (this.f757f != null && g()) {
            jiVar.a(g);
            jiVar.a(this.f757f);
            jiVar.b();
        }
        if (this.f752a != null && h()) {
            jiVar.a(h);
            jiVar.a(new jg(Constants.GZIP_CAST_TYPE, this.f752a.size()));
            for (String str : this.f752a) {
                jiVar.a(str);
            }
            jiVar.e();
            jiVar.b();
        }
        jiVar.c();
        jiVar.m496a();
    }

    public boolean b() {
        return this.f750a != null;
    }

    public iu c(String str) {
        this.f755d = str;
        return this;
    }

    public boolean c() {
        return this.f753b != null;
    }

    public iu d(String str) {
        this.f756e = str;
        return this;
    }

    public boolean d() {
        return this.f754c != null;
    }

    public iu e(String str) {
        this.f757f = str;
        return this;
    }

    public boolean e() {
        return this.f755d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof iu)) {
            return m477a((iu) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f756e != null;
    }

    public boolean g() {
        return this.f757f != null;
    }

    public boolean h() {
        return this.f752a != null;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionUnSubscription(");
        boolean z2 = true;
        if (m476a()) {
            sb.append("debug:");
            if (this.f751a == null) {
                sb.append("null");
            } else {
                sb.append(this.f751a);
            }
            z2 = false;
        }
        if (b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f750a == null) {
                sb.append("null");
            } else {
                sb.append(this.f750a);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f753b == null) {
            sb.append("null");
        } else {
            sb.append(this.f753b);
        }
        sb.append(", ");
        sb.append("appId:");
        if (this.f754c == null) {
            sb.append("null");
        } else {
            sb.append(this.f754c);
        }
        sb.append(", ");
        sb.append(UrlSchemaHelper.SCHEMA_TYPE_TOPIC);
        if (this.f755d == null) {
            sb.append("null");
        } else {
            sb.append(this.f755d);
        }
        if (f()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f756e == null) {
                sb.append("null");
            } else {
                sb.append(this.f756e);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("category:");
            if (this.f757f == null) {
                sb.append("null");
            } else {
                sb.append(this.f757f);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("aliases:");
            if (this.f752a == null) {
                sb.append("null");
            } else {
                sb.append(this.f752a);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
