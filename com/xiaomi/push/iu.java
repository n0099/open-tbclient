package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class iu implements ix<iu, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public ib f752a;

    /* renamed from: a  reason: collision with other field name */
    public String f753a;

    /* renamed from: a  reason: collision with other field name */
    public List<String> f754a;

    /* renamed from: b  reason: collision with other field name */
    public String f755b;

    /* renamed from: c  reason: collision with other field name */
    public String f756c;

    /* renamed from: d  reason: collision with other field name */
    public String f757d;

    /* renamed from: e  reason: collision with other field name */
    public String f758e;

    /* renamed from: f  reason: collision with other field name */
    public String f759f;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f751a = new jn("XmPushActionUnSubscription");
    private static final jf a = new jf("", Constants.GZIP_CAST_TYPE, 1);
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
            int compareTo = Boolean.valueOf(m467a()).compareTo(Boolean.valueOf(iuVar.m467a()));
            if (compareTo == 0) {
                if (!m467a() || (a9 = iy.a(this.f753a, iuVar.f753a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(iuVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a8 = iy.a(this.f752a, iuVar.f752a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(iuVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a7 = iy.a(this.f755b, iuVar.f755b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(iuVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a6 = iy.a(this.f756c, iuVar.f756c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(iuVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a5 = iy.a(this.f757d, iuVar.f757d)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(iuVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a4 = iy.a(this.f758e, iuVar.f758e)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(iuVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a3 = iy.a(this.f759f, iuVar.f759f)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(iuVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a2 = iy.a(this.f754a, iuVar.f754a)) == 0) {
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
        this.f755b = str;
        return this;
    }

    public void a() {
        if (this.f755b == null) {
            throw new jj("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f756c == null) {
            throw new jj("Required field 'appId' was not present! Struct: " + toString());
        }
        if (this.f757d == null) {
            throw new jj("Required field 'topic' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m483a();
        while (true) {
            jf m479a = jiVar.m479a();
            if (m479a.a == 0) {
                jiVar.f();
                a();
                return;
            }
            switch (m479a.f783a) {
                case 1:
                    if (m479a.a == 11) {
                        this.f753a = jiVar.m484a();
                        break;
                    } else {
                        jl.a(jiVar, m479a.a);
                        break;
                    }
                case 2:
                    if (m479a.a == 12) {
                        this.f752a = new ib();
                        this.f752a.a(jiVar);
                        break;
                    } else {
                        jl.a(jiVar, m479a.a);
                        break;
                    }
                case 3:
                    if (m479a.a == 11) {
                        this.f755b = jiVar.m484a();
                        break;
                    } else {
                        jl.a(jiVar, m479a.a);
                        break;
                    }
                case 4:
                    if (m479a.a == 11) {
                        this.f756c = jiVar.m484a();
                        break;
                    } else {
                        jl.a(jiVar, m479a.a);
                        break;
                    }
                case 5:
                    if (m479a.a == 11) {
                        this.f757d = jiVar.m484a();
                        break;
                    } else {
                        jl.a(jiVar, m479a.a);
                        break;
                    }
                case 6:
                    if (m479a.a == 11) {
                        this.f758e = jiVar.m484a();
                        break;
                    } else {
                        jl.a(jiVar, m479a.a);
                        break;
                    }
                case 7:
                    if (m479a.a == 11) {
                        this.f759f = jiVar.m484a();
                        break;
                    } else {
                        jl.a(jiVar, m479a.a);
                        break;
                    }
                case 8:
                    if (m479a.a == 15) {
                        jg m480a = jiVar.m480a();
                        this.f754a = new ArrayList(m480a.f784a);
                        for (int i = 0; i < m480a.f784a; i++) {
                            this.f754a.add(jiVar.m484a());
                        }
                        jiVar.i();
                        break;
                    } else {
                        jl.a(jiVar, m479a.a);
                        break;
                    }
                default:
                    jl.a(jiVar, m479a.a);
                    break;
            }
            jiVar.g();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m467a() {
        return this.f753a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m468a(iu iuVar) {
        if (iuVar == null) {
            return false;
        }
        boolean m467a = m467a();
        boolean m467a2 = iuVar.m467a();
        if ((m467a || m467a2) && !(m467a && m467a2 && this.f753a.equals(iuVar.f753a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = iuVar.b();
        if ((b2 || b3) && !(b2 && b3 && this.f752a.m392a(iuVar.f752a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = iuVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f755b.equals(iuVar.f755b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = iuVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f756c.equals(iuVar.f756c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = iuVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f757d.equals(iuVar.f757d))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = iuVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f758e.equals(iuVar.f758e))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = iuVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f759f.equals(iuVar.f759f))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = iuVar.h();
        return !(h2 || h3) || (h2 && h3 && this.f754a.equals(iuVar.f754a));
    }

    public iu b(String str) {
        this.f756c = str;
        return this;
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        a();
        jiVar.a(f751a);
        if (this.f753a != null && m467a()) {
            jiVar.a(a);
            jiVar.a(this.f753a);
            jiVar.b();
        }
        if (this.f752a != null && b()) {
            jiVar.a(b);
            this.f752a.b(jiVar);
            jiVar.b();
        }
        if (this.f755b != null) {
            jiVar.a(c);
            jiVar.a(this.f755b);
            jiVar.b();
        }
        if (this.f756c != null) {
            jiVar.a(d);
            jiVar.a(this.f756c);
            jiVar.b();
        }
        if (this.f757d != null) {
            jiVar.a(e);
            jiVar.a(this.f757d);
            jiVar.b();
        }
        if (this.f758e != null && f()) {
            jiVar.a(f);
            jiVar.a(this.f758e);
            jiVar.b();
        }
        if (this.f759f != null && g()) {
            jiVar.a(g);
            jiVar.a(this.f759f);
            jiVar.b();
        }
        if (this.f754a != null && h()) {
            jiVar.a(h);
            jiVar.a(new jg(Constants.GZIP_CAST_TYPE, this.f754a.size()));
            for (String str : this.f754a) {
                jiVar.a(str);
            }
            jiVar.e();
            jiVar.b();
        }
        jiVar.c();
        jiVar.m487a();
    }

    public boolean b() {
        return this.f752a != null;
    }

    public iu c(String str) {
        this.f757d = str;
        return this;
    }

    public boolean c() {
        return this.f755b != null;
    }

    public iu d(String str) {
        this.f758e = str;
        return this;
    }

    public boolean d() {
        return this.f756c != null;
    }

    public iu e(String str) {
        this.f759f = str;
        return this;
    }

    public boolean e() {
        return this.f757d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof iu)) {
            return m468a((iu) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f758e != null;
    }

    public boolean g() {
        return this.f759f != null;
    }

    public boolean h() {
        return this.f754a != null;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionUnSubscription(");
        boolean z2 = true;
        if (m467a()) {
            sb.append("debug:");
            if (this.f753a == null) {
                sb.append("null");
            } else {
                sb.append(this.f753a);
            }
            z2 = false;
        }
        if (b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f752a == null) {
                sb.append("null");
            } else {
                sb.append(this.f752a);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f755b == null) {
            sb.append("null");
        } else {
            sb.append(this.f755b);
        }
        sb.append(", ");
        sb.append("appId:");
        if (this.f756c == null) {
            sb.append("null");
        } else {
            sb.append(this.f756c);
        }
        sb.append(", ");
        sb.append(UrlSchemaHelper.SCHEMA_TYPE_TOPIC);
        if (this.f757d == null) {
            sb.append("null");
        } else {
            sb.append(this.f757d);
        }
        if (f()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f758e == null) {
                sb.append("null");
            } else {
                sb.append(this.f758e);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("category:");
            if (this.f759f == null) {
                sb.append("null");
            } else {
                sb.append(this.f759f);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("aliases:");
            if (this.f754a == null) {
                sb.append("null");
            } else {
                sb.append(this.f754a);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
