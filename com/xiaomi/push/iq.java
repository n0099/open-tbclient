package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class iq implements ix<iq, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public ib f708a;

    /* renamed from: a  reason: collision with other field name */
    public String f709a;

    /* renamed from: a  reason: collision with other field name */
    public List<String> f710a;

    /* renamed from: b  reason: collision with other field name */
    public String f711b;

    /* renamed from: c  reason: collision with other field name */
    public String f712c;

    /* renamed from: d  reason: collision with other field name */
    public String f713d;

    /* renamed from: e  reason: collision with other field name */
    public String f714e;

    /* renamed from: f  reason: collision with other field name */
    public String f715f;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f707a = new jn("XmPushActionSubscription");
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
            int compareTo = Boolean.valueOf(m456a()).compareTo(Boolean.valueOf(iqVar.m456a()));
            if (compareTo == 0) {
                if (!m456a() || (a9 = iy.a(this.f709a, iqVar.f709a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(iqVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a8 = iy.a(this.f708a, iqVar.f708a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(iqVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a7 = iy.a(this.f711b, iqVar.f711b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(iqVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a6 = iy.a(this.f712c, iqVar.f712c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(iqVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a5 = iy.a(this.f713d, iqVar.f713d)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(iqVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a4 = iy.a(this.f714e, iqVar.f714e)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(iqVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a3 = iy.a(this.f715f, iqVar.f715f)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(iqVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a2 = iy.a(this.f710a, iqVar.f710a)) == 0) {
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
        this.f711b = str;
        return this;
    }

    public void a() {
        if (this.f711b == null) {
            throw new jj("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f712c == null) {
            throw new jj("Required field 'appId' was not present! Struct: " + toString());
        }
        if (this.f713d == null) {
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
            switch (m479a.f784a) {
                case 1:
                    if (m479a.a == 11) {
                        this.f709a = jiVar.m484a();
                        break;
                    } else {
                        jl.a(jiVar, m479a.a);
                        break;
                    }
                case 2:
                    if (m479a.a == 12) {
                        this.f708a = new ib();
                        this.f708a.a(jiVar);
                        break;
                    } else {
                        jl.a(jiVar, m479a.a);
                        break;
                    }
                case 3:
                    if (m479a.a == 11) {
                        this.f711b = jiVar.m484a();
                        break;
                    } else {
                        jl.a(jiVar, m479a.a);
                        break;
                    }
                case 4:
                    if (m479a.a == 11) {
                        this.f712c = jiVar.m484a();
                        break;
                    } else {
                        jl.a(jiVar, m479a.a);
                        break;
                    }
                case 5:
                    if (m479a.a == 11) {
                        this.f713d = jiVar.m484a();
                        break;
                    } else {
                        jl.a(jiVar, m479a.a);
                        break;
                    }
                case 6:
                    if (m479a.a == 11) {
                        this.f714e = jiVar.m484a();
                        break;
                    } else {
                        jl.a(jiVar, m479a.a);
                        break;
                    }
                case 7:
                    if (m479a.a == 11) {
                        this.f715f = jiVar.m484a();
                        break;
                    } else {
                        jl.a(jiVar, m479a.a);
                        break;
                    }
                case 8:
                    if (m479a.a == 15) {
                        jg m480a = jiVar.m480a();
                        this.f710a = new ArrayList(m480a.f785a);
                        for (int i = 0; i < m480a.f785a; i++) {
                            this.f710a.add(jiVar.m484a());
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
    public boolean m456a() {
        return this.f709a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m457a(iq iqVar) {
        if (iqVar == null) {
            return false;
        }
        boolean m456a = m456a();
        boolean m456a2 = iqVar.m456a();
        if ((m456a || m456a2) && !(m456a && m456a2 && this.f709a.equals(iqVar.f709a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = iqVar.b();
        if ((b2 || b3) && !(b2 && b3 && this.f708a.m392a(iqVar.f708a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = iqVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f711b.equals(iqVar.f711b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = iqVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f712c.equals(iqVar.f712c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = iqVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f713d.equals(iqVar.f713d))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = iqVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f714e.equals(iqVar.f714e))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = iqVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f715f.equals(iqVar.f715f))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = iqVar.h();
        return !(h2 || h3) || (h2 && h3 && this.f710a.equals(iqVar.f710a));
    }

    public iq b(String str) {
        this.f712c = str;
        return this;
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        a();
        jiVar.a(f707a);
        if (this.f709a != null && m456a()) {
            jiVar.a(a);
            jiVar.a(this.f709a);
            jiVar.b();
        }
        if (this.f708a != null && b()) {
            jiVar.a(b);
            this.f708a.b(jiVar);
            jiVar.b();
        }
        if (this.f711b != null) {
            jiVar.a(c);
            jiVar.a(this.f711b);
            jiVar.b();
        }
        if (this.f712c != null) {
            jiVar.a(d);
            jiVar.a(this.f712c);
            jiVar.b();
        }
        if (this.f713d != null) {
            jiVar.a(e);
            jiVar.a(this.f713d);
            jiVar.b();
        }
        if (this.f714e != null && f()) {
            jiVar.a(f);
            jiVar.a(this.f714e);
            jiVar.b();
        }
        if (this.f715f != null && g()) {
            jiVar.a(g);
            jiVar.a(this.f715f);
            jiVar.b();
        }
        if (this.f710a != null && h()) {
            jiVar.a(h);
            jiVar.a(new jg(Constants.GZIP_CAST_TYPE, this.f710a.size()));
            for (String str : this.f710a) {
                jiVar.a(str);
            }
            jiVar.e();
            jiVar.b();
        }
        jiVar.c();
        jiVar.m487a();
    }

    public boolean b() {
        return this.f708a != null;
    }

    public iq c(String str) {
        this.f713d = str;
        return this;
    }

    public boolean c() {
        return this.f711b != null;
    }

    public iq d(String str) {
        this.f714e = str;
        return this;
    }

    public boolean d() {
        return this.f712c != null;
    }

    public iq e(String str) {
        this.f715f = str;
        return this;
    }

    public boolean e() {
        return this.f713d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof iq)) {
            return m457a((iq) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f714e != null;
    }

    public boolean g() {
        return this.f715f != null;
    }

    public boolean h() {
        return this.f710a != null;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionSubscription(");
        boolean z2 = true;
        if (m456a()) {
            sb.append("debug:");
            if (this.f709a == null) {
                sb.append("null");
            } else {
                sb.append(this.f709a);
            }
            z2 = false;
        }
        if (b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f708a == null) {
                sb.append("null");
            } else {
                sb.append(this.f708a);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f711b == null) {
            sb.append("null");
        } else {
            sb.append(this.f711b);
        }
        sb.append(", ");
        sb.append("appId:");
        if (this.f712c == null) {
            sb.append("null");
        } else {
            sb.append(this.f712c);
        }
        sb.append(", ");
        sb.append(UrlSchemaHelper.SCHEMA_TYPE_TOPIC);
        if (this.f713d == null) {
            sb.append("null");
        } else {
            sb.append(this.f713d);
        }
        if (f()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f714e == null) {
                sb.append("null");
            } else {
                sb.append(this.f714e);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("category:");
            if (this.f715f == null) {
                sb.append("null");
            } else {
                sb.append(this.f715f);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("aliases:");
            if (this.f710a == null) {
                sb.append("null");
            } else {
                sb.append(this.f710a);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
