package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes12.dex */
public class iu implements ix<iu, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public ib f745a;

    /* renamed from: a  reason: collision with other field name */
    public String f746a;

    /* renamed from: a  reason: collision with other field name */
    public List<String> f747a;

    /* renamed from: b  reason: collision with other field name */
    public String f748b;

    /* renamed from: c  reason: collision with other field name */
    public String f749c;

    /* renamed from: d  reason: collision with other field name */
    public String f750d;

    /* renamed from: e  reason: collision with other field name */
    public String f751e;

    /* renamed from: f  reason: collision with other field name */
    public String f752f;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f744a = new jn("XmPushActionUnSubscription");

    /* renamed from: a  reason: collision with root package name */
    private static final jf f4988a = new jf("", Constants.GZIP_CAST_TYPE, 1);
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
            int compareTo = Boolean.valueOf(m473a()).compareTo(Boolean.valueOf(iuVar.m473a()));
            if (compareTo == 0) {
                if (!m473a() || (a9 = iy.a(this.f746a, iuVar.f746a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(iuVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a8 = iy.a(this.f745a, iuVar.f745a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(iuVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a7 = iy.a(this.f748b, iuVar.f748b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(iuVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a6 = iy.a(this.f749c, iuVar.f749c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(iuVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a5 = iy.a(this.f750d, iuVar.f750d)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(iuVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a4 = iy.a(this.f751e, iuVar.f751e)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(iuVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a3 = iy.a(this.f752f, iuVar.f752f)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(iuVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a2 = iy.a(this.f747a, iuVar.f747a)) == 0) {
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
        this.f748b = str;
        return this;
    }

    public void a() {
        if (this.f748b == null) {
            throw new jj("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f749c == null) {
            throw new jj("Required field 'appId' was not present! Struct: " + toString());
        }
        if (this.f750d == null) {
            throw new jj("Required field 'topic' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m489a();
        while (true) {
            jf m485a = jiVar.m485a();
            if (m485a.f4998a == 0) {
                jiVar.f();
                a();
                return;
            }
            switch (m485a.f776a) {
                case 1:
                    if (m485a.f4998a == 11) {
                        this.f746a = jiVar.m490a();
                        break;
                    } else {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    }
                case 2:
                    if (m485a.f4998a == 12) {
                        this.f745a = new ib();
                        this.f745a.a(jiVar);
                        break;
                    } else {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    }
                case 3:
                    if (m485a.f4998a == 11) {
                        this.f748b = jiVar.m490a();
                        break;
                    } else {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    }
                case 4:
                    if (m485a.f4998a == 11) {
                        this.f749c = jiVar.m490a();
                        break;
                    } else {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    }
                case 5:
                    if (m485a.f4998a == 11) {
                        this.f750d = jiVar.m490a();
                        break;
                    } else {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    }
                case 6:
                    if (m485a.f4998a == 11) {
                        this.f751e = jiVar.m490a();
                        break;
                    } else {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    }
                case 7:
                    if (m485a.f4998a == 11) {
                        this.f752f = jiVar.m490a();
                        break;
                    } else {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    }
                case 8:
                    if (m485a.f4998a == 15) {
                        jg m486a = jiVar.m486a();
                        this.f747a = new ArrayList(m486a.f777a);
                        for (int i = 0; i < m486a.f777a; i++) {
                            this.f747a.add(jiVar.m490a());
                        }
                        jiVar.i();
                        break;
                    } else {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    }
                default:
                    jl.a(jiVar, m485a.f4998a);
                    break;
            }
            jiVar.g();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m473a() {
        return this.f746a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m474a(iu iuVar) {
        if (iuVar == null) {
            return false;
        }
        boolean m473a = m473a();
        boolean m473a2 = iuVar.m473a();
        if ((m473a || m473a2) && !(m473a && m473a2 && this.f746a.equals(iuVar.f746a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = iuVar.b();
        if ((b2 || b3) && !(b2 && b3 && this.f745a.m398a(iuVar.f745a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = iuVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f748b.equals(iuVar.f748b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = iuVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f749c.equals(iuVar.f749c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = iuVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f750d.equals(iuVar.f750d))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = iuVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f751e.equals(iuVar.f751e))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = iuVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f752f.equals(iuVar.f752f))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = iuVar.h();
        return !(h2 || h3) || (h2 && h3 && this.f747a.equals(iuVar.f747a));
    }

    public iu b(String str) {
        this.f749c = str;
        return this;
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        a();
        jiVar.a(f744a);
        if (this.f746a != null && m473a()) {
            jiVar.a(f4988a);
            jiVar.a(this.f746a);
            jiVar.b();
        }
        if (this.f745a != null && b()) {
            jiVar.a(b);
            this.f745a.b(jiVar);
            jiVar.b();
        }
        if (this.f748b != null) {
            jiVar.a(c);
            jiVar.a(this.f748b);
            jiVar.b();
        }
        if (this.f749c != null) {
            jiVar.a(d);
            jiVar.a(this.f749c);
            jiVar.b();
        }
        if (this.f750d != null) {
            jiVar.a(e);
            jiVar.a(this.f750d);
            jiVar.b();
        }
        if (this.f751e != null && f()) {
            jiVar.a(f);
            jiVar.a(this.f751e);
            jiVar.b();
        }
        if (this.f752f != null && g()) {
            jiVar.a(g);
            jiVar.a(this.f752f);
            jiVar.b();
        }
        if (this.f747a != null && h()) {
            jiVar.a(h);
            jiVar.a(new jg(Constants.GZIP_CAST_TYPE, this.f747a.size()));
            for (String str : this.f747a) {
                jiVar.a(str);
            }
            jiVar.e();
            jiVar.b();
        }
        jiVar.c();
        jiVar.m493a();
    }

    public boolean b() {
        return this.f745a != null;
    }

    public iu c(String str) {
        this.f750d = str;
        return this;
    }

    public boolean c() {
        return this.f748b != null;
    }

    public iu d(String str) {
        this.f751e = str;
        return this;
    }

    public boolean d() {
        return this.f749c != null;
    }

    public iu e(String str) {
        this.f752f = str;
        return this;
    }

    public boolean e() {
        return this.f750d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof iu)) {
            return m474a((iu) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f751e != null;
    }

    public boolean g() {
        return this.f752f != null;
    }

    public boolean h() {
        return this.f747a != null;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionUnSubscription(");
        boolean z2 = true;
        if (m473a()) {
            sb.append("debug:");
            if (this.f746a == null) {
                sb.append("null");
            } else {
                sb.append(this.f746a);
            }
            z2 = false;
        }
        if (b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f745a == null) {
                sb.append("null");
            } else {
                sb.append(this.f745a);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f748b == null) {
            sb.append("null");
        } else {
            sb.append(this.f748b);
        }
        sb.append(", ");
        sb.append("appId:");
        if (this.f749c == null) {
            sb.append("null");
        } else {
            sb.append(this.f749c);
        }
        sb.append(", ");
        sb.append(UrlSchemaHelper.SCHEMA_TYPE_TOPIC);
        if (this.f750d == null) {
            sb.append("null");
        } else {
            sb.append(this.f750d);
        }
        if (f()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f751e == null) {
                sb.append("null");
            } else {
                sb.append(this.f751e);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("category:");
            if (this.f752f == null) {
                sb.append("null");
            } else {
                sb.append(this.f752f);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("aliases:");
            if (this.f747a == null) {
                sb.append("null");
            } else {
                sb.append(this.f747a);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
