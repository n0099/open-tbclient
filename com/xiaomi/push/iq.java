package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class iq implements ix<iq, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public ib f704a;

    /* renamed from: a  reason: collision with other field name */
    public String f705a;

    /* renamed from: a  reason: collision with other field name */
    public List<String> f706a;

    /* renamed from: b  reason: collision with other field name */
    public String f707b;

    /* renamed from: c  reason: collision with other field name */
    public String f708c;

    /* renamed from: d  reason: collision with other field name */
    public String f709d;

    /* renamed from: e  reason: collision with other field name */
    public String f710e;

    /* renamed from: f  reason: collision with other field name */
    public String f711f;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f703a = new jn("XmPushActionSubscription");
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
            int compareTo = Boolean.valueOf(m462a()).compareTo(Boolean.valueOf(iqVar.m462a()));
            if (compareTo == 0) {
                if (!m462a() || (a9 = iy.a(this.f705a, iqVar.f705a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(iqVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a8 = iy.a(this.f704a, iqVar.f704a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(iqVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a7 = iy.a(this.f707b, iqVar.f707b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(iqVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a6 = iy.a(this.f708c, iqVar.f708c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(iqVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a5 = iy.a(this.f709d, iqVar.f709d)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(iqVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a4 = iy.a(this.f710e, iqVar.f710e)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(iqVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a3 = iy.a(this.f711f, iqVar.f711f)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(iqVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a2 = iy.a(this.f706a, iqVar.f706a)) == 0) {
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
        this.f707b = str;
        return this;
    }

    public void a() {
        if (this.f707b == null) {
            throw new jj("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f708c == null) {
            throw new jj("Required field 'appId' was not present! Struct: " + toString());
        }
        if (this.f709d == null) {
            throw new jj("Required field 'topic' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m489a();
        while (true) {
            jf m485a = jiVar.m485a();
            if (m485a.a == 0) {
                jiVar.f();
                a();
                return;
            }
            switch (m485a.f780a) {
                case 1:
                    if (m485a.a == 11) {
                        this.f705a = jiVar.m490a();
                        break;
                    } else {
                        jl.a(jiVar, m485a.a);
                        break;
                    }
                case 2:
                    if (m485a.a == 12) {
                        this.f704a = new ib();
                        this.f704a.a(jiVar);
                        break;
                    } else {
                        jl.a(jiVar, m485a.a);
                        break;
                    }
                case 3:
                    if (m485a.a == 11) {
                        this.f707b = jiVar.m490a();
                        break;
                    } else {
                        jl.a(jiVar, m485a.a);
                        break;
                    }
                case 4:
                    if (m485a.a == 11) {
                        this.f708c = jiVar.m490a();
                        break;
                    } else {
                        jl.a(jiVar, m485a.a);
                        break;
                    }
                case 5:
                    if (m485a.a == 11) {
                        this.f709d = jiVar.m490a();
                        break;
                    } else {
                        jl.a(jiVar, m485a.a);
                        break;
                    }
                case 6:
                    if (m485a.a == 11) {
                        this.f710e = jiVar.m490a();
                        break;
                    } else {
                        jl.a(jiVar, m485a.a);
                        break;
                    }
                case 7:
                    if (m485a.a == 11) {
                        this.f711f = jiVar.m490a();
                        break;
                    } else {
                        jl.a(jiVar, m485a.a);
                        break;
                    }
                case 8:
                    if (m485a.a == 15) {
                        jg m486a = jiVar.m486a();
                        this.f706a = new ArrayList(m486a.f781a);
                        for (int i = 0; i < m486a.f781a; i++) {
                            this.f706a.add(jiVar.m490a());
                        }
                        jiVar.i();
                        break;
                    } else {
                        jl.a(jiVar, m485a.a);
                        break;
                    }
                default:
                    jl.a(jiVar, m485a.a);
                    break;
            }
            jiVar.g();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m462a() {
        return this.f705a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m463a(iq iqVar) {
        if (iqVar == null) {
            return false;
        }
        boolean m462a = m462a();
        boolean m462a2 = iqVar.m462a();
        if ((m462a || m462a2) && !(m462a && m462a2 && this.f705a.equals(iqVar.f705a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = iqVar.b();
        if ((b2 || b3) && !(b2 && b3 && this.f704a.m398a(iqVar.f704a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = iqVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f707b.equals(iqVar.f707b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = iqVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f708c.equals(iqVar.f708c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = iqVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f709d.equals(iqVar.f709d))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = iqVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f710e.equals(iqVar.f710e))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = iqVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f711f.equals(iqVar.f711f))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = iqVar.h();
        return !(h2 || h3) || (h2 && h3 && this.f706a.equals(iqVar.f706a));
    }

    public iq b(String str) {
        this.f708c = str;
        return this;
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        a();
        jiVar.a(f703a);
        if (this.f705a != null && m462a()) {
            jiVar.a(a);
            jiVar.a(this.f705a);
            jiVar.b();
        }
        if (this.f704a != null && b()) {
            jiVar.a(b);
            this.f704a.b(jiVar);
            jiVar.b();
        }
        if (this.f707b != null) {
            jiVar.a(c);
            jiVar.a(this.f707b);
            jiVar.b();
        }
        if (this.f708c != null) {
            jiVar.a(d);
            jiVar.a(this.f708c);
            jiVar.b();
        }
        if (this.f709d != null) {
            jiVar.a(e);
            jiVar.a(this.f709d);
            jiVar.b();
        }
        if (this.f710e != null && f()) {
            jiVar.a(f);
            jiVar.a(this.f710e);
            jiVar.b();
        }
        if (this.f711f != null && g()) {
            jiVar.a(g);
            jiVar.a(this.f711f);
            jiVar.b();
        }
        if (this.f706a != null && h()) {
            jiVar.a(h);
            jiVar.a(new jg(Constants.GZIP_CAST_TYPE, this.f706a.size()));
            for (String str : this.f706a) {
                jiVar.a(str);
            }
            jiVar.e();
            jiVar.b();
        }
        jiVar.c();
        jiVar.m493a();
    }

    public boolean b() {
        return this.f704a != null;
    }

    public iq c(String str) {
        this.f709d = str;
        return this;
    }

    public boolean c() {
        return this.f707b != null;
    }

    public iq d(String str) {
        this.f710e = str;
        return this;
    }

    public boolean d() {
        return this.f708c != null;
    }

    public iq e(String str) {
        this.f711f = str;
        return this;
    }

    public boolean e() {
        return this.f709d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof iq)) {
            return m463a((iq) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f710e != null;
    }

    public boolean g() {
        return this.f711f != null;
    }

    public boolean h() {
        return this.f706a != null;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionSubscription(");
        boolean z2 = true;
        if (m462a()) {
            sb.append("debug:");
            if (this.f705a == null) {
                sb.append("null");
            } else {
                sb.append(this.f705a);
            }
            z2 = false;
        }
        if (b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f704a == null) {
                sb.append("null");
            } else {
                sb.append(this.f704a);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f707b == null) {
            sb.append("null");
        } else {
            sb.append(this.f707b);
        }
        sb.append(", ");
        sb.append("appId:");
        if (this.f708c == null) {
            sb.append("null");
        } else {
            sb.append(this.f708c);
        }
        sb.append(", ");
        sb.append(UrlSchemaHelper.SCHEMA_TYPE_TOPIC);
        if (this.f709d == null) {
            sb.append("null");
        } else {
            sb.append(this.f709d);
        }
        if (f()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f710e == null) {
                sb.append("null");
            } else {
                sb.append(this.f710e);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("category:");
            if (this.f711f == null) {
                sb.append("null");
            } else {
                sb.append(this.f711f);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("aliases:");
            if (this.f706a == null) {
                sb.append("null");
            } else {
                sb.append(this.f706a);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
