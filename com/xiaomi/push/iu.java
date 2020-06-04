package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class iu implements ix<iu, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public ib f746a;

    /* renamed from: a  reason: collision with other field name */
    public String f747a;

    /* renamed from: a  reason: collision with other field name */
    public List<String> f748a;

    /* renamed from: b  reason: collision with other field name */
    public String f749b;

    /* renamed from: c  reason: collision with other field name */
    public String f750c;

    /* renamed from: d  reason: collision with other field name */
    public String f751d;

    /* renamed from: e  reason: collision with other field name */
    public String f752e;

    /* renamed from: f  reason: collision with other field name */
    public String f753f;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f745a = new jn("XmPushActionUnSubscription");
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
            int compareTo = Boolean.valueOf(m470a()).compareTo(Boolean.valueOf(iuVar.m470a()));
            if (compareTo == 0) {
                if (!m470a() || (a9 = iy.a(this.f747a, iuVar.f747a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(iuVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a8 = iy.a(this.f746a, iuVar.f746a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(iuVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a7 = iy.a(this.f749b, iuVar.f749b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(iuVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a6 = iy.a(this.f750c, iuVar.f750c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(iuVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a5 = iy.a(this.f751d, iuVar.f751d)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(iuVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a4 = iy.a(this.f752e, iuVar.f752e)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(iuVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a3 = iy.a(this.f753f, iuVar.f753f)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(iuVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a2 = iy.a(this.f748a, iuVar.f748a)) == 0) {
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
        this.f749b = str;
        return this;
    }

    public void a() {
        if (this.f749b == null) {
            throw new jj("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f750c == null) {
            throw new jj("Required field 'appId' was not present! Struct: " + toString());
        }
        if (this.f751d == null) {
            throw new jj("Required field 'topic' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m486a();
        while (true) {
            jf m482a = jiVar.m482a();
            if (m482a.a == 0) {
                jiVar.f();
                a();
                return;
            }
            switch (m482a.f777a) {
                case 1:
                    if (m482a.a == 11) {
                        this.f747a = jiVar.m487a();
                        break;
                    } else {
                        jl.a(jiVar, m482a.a);
                        break;
                    }
                case 2:
                    if (m482a.a == 12) {
                        this.f746a = new ib();
                        this.f746a.a(jiVar);
                        break;
                    } else {
                        jl.a(jiVar, m482a.a);
                        break;
                    }
                case 3:
                    if (m482a.a == 11) {
                        this.f749b = jiVar.m487a();
                        break;
                    } else {
                        jl.a(jiVar, m482a.a);
                        break;
                    }
                case 4:
                    if (m482a.a == 11) {
                        this.f750c = jiVar.m487a();
                        break;
                    } else {
                        jl.a(jiVar, m482a.a);
                        break;
                    }
                case 5:
                    if (m482a.a == 11) {
                        this.f751d = jiVar.m487a();
                        break;
                    } else {
                        jl.a(jiVar, m482a.a);
                        break;
                    }
                case 6:
                    if (m482a.a == 11) {
                        this.f752e = jiVar.m487a();
                        break;
                    } else {
                        jl.a(jiVar, m482a.a);
                        break;
                    }
                case 7:
                    if (m482a.a == 11) {
                        this.f753f = jiVar.m487a();
                        break;
                    } else {
                        jl.a(jiVar, m482a.a);
                        break;
                    }
                case 8:
                    if (m482a.a == 15) {
                        jg m483a = jiVar.m483a();
                        this.f748a = new ArrayList(m483a.f778a);
                        for (int i = 0; i < m483a.f778a; i++) {
                            this.f748a.add(jiVar.m487a());
                        }
                        jiVar.i();
                        break;
                    } else {
                        jl.a(jiVar, m482a.a);
                        break;
                    }
                default:
                    jl.a(jiVar, m482a.a);
                    break;
            }
            jiVar.g();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m470a() {
        return this.f747a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m471a(iu iuVar) {
        if (iuVar == null) {
            return false;
        }
        boolean m470a = m470a();
        boolean m470a2 = iuVar.m470a();
        if ((m470a || m470a2) && !(m470a && m470a2 && this.f747a.equals(iuVar.f747a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = iuVar.b();
        if ((b2 || b3) && !(b2 && b3 && this.f746a.m395a(iuVar.f746a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = iuVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f749b.equals(iuVar.f749b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = iuVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f750c.equals(iuVar.f750c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = iuVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f751d.equals(iuVar.f751d))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = iuVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f752e.equals(iuVar.f752e))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = iuVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f753f.equals(iuVar.f753f))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = iuVar.h();
        return !(h2 || h3) || (h2 && h3 && this.f748a.equals(iuVar.f748a));
    }

    public iu b(String str) {
        this.f750c = str;
        return this;
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        a();
        jiVar.a(f745a);
        if (this.f747a != null && m470a()) {
            jiVar.a(a);
            jiVar.a(this.f747a);
            jiVar.b();
        }
        if (this.f746a != null && b()) {
            jiVar.a(b);
            this.f746a.b(jiVar);
            jiVar.b();
        }
        if (this.f749b != null) {
            jiVar.a(c);
            jiVar.a(this.f749b);
            jiVar.b();
        }
        if (this.f750c != null) {
            jiVar.a(d);
            jiVar.a(this.f750c);
            jiVar.b();
        }
        if (this.f751d != null) {
            jiVar.a(e);
            jiVar.a(this.f751d);
            jiVar.b();
        }
        if (this.f752e != null && f()) {
            jiVar.a(f);
            jiVar.a(this.f752e);
            jiVar.b();
        }
        if (this.f753f != null && g()) {
            jiVar.a(g);
            jiVar.a(this.f753f);
            jiVar.b();
        }
        if (this.f748a != null && h()) {
            jiVar.a(h);
            jiVar.a(new jg(Constants.GZIP_CAST_TYPE, this.f748a.size()));
            for (String str : this.f748a) {
                jiVar.a(str);
            }
            jiVar.e();
            jiVar.b();
        }
        jiVar.c();
        jiVar.m490a();
    }

    public boolean b() {
        return this.f746a != null;
    }

    public iu c(String str) {
        this.f751d = str;
        return this;
    }

    public boolean c() {
        return this.f749b != null;
    }

    public iu d(String str) {
        this.f752e = str;
        return this;
    }

    public boolean d() {
        return this.f750c != null;
    }

    public iu e(String str) {
        this.f753f = str;
        return this;
    }

    public boolean e() {
        return this.f751d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof iu)) {
            return m471a((iu) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f752e != null;
    }

    public boolean g() {
        return this.f753f != null;
    }

    public boolean h() {
        return this.f748a != null;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionUnSubscription(");
        boolean z2 = true;
        if (m470a()) {
            sb.append("debug:");
            if (this.f747a == null) {
                sb.append("null");
            } else {
                sb.append(this.f747a);
            }
            z2 = false;
        }
        if (b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f746a == null) {
                sb.append("null");
            } else {
                sb.append(this.f746a);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f749b == null) {
            sb.append("null");
        } else {
            sb.append(this.f749b);
        }
        sb.append(", ");
        sb.append("appId:");
        if (this.f750c == null) {
            sb.append("null");
        } else {
            sb.append(this.f750c);
        }
        sb.append(", ");
        sb.append(UrlSchemaHelper.SCHEMA_TYPE_TOPIC);
        if (this.f751d == null) {
            sb.append("null");
        } else {
            sb.append(this.f751d);
        }
        if (f()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f752e == null) {
                sb.append("null");
            } else {
                sb.append(this.f752e);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("category:");
            if (this.f753f == null) {
                sb.append("null");
            } else {
                sb.append(this.f753f);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("aliases:");
            if (this.f748a == null) {
                sb.append("null");
            } else {
                sb.append(this.f748a);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
