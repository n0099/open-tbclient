package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class iq implements ix<iq, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public ib f707a;

    /* renamed from: a  reason: collision with other field name */
    public String f708a;

    /* renamed from: a  reason: collision with other field name */
    public List<String> f709a;

    /* renamed from: b  reason: collision with other field name */
    public String f710b;

    /* renamed from: c  reason: collision with other field name */
    public String f711c;

    /* renamed from: d  reason: collision with other field name */
    public String f712d;

    /* renamed from: e  reason: collision with other field name */
    public String f713e;

    /* renamed from: f  reason: collision with other field name */
    public String f714f;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f706a = new jn("XmPushActionSubscription");
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
                if (!m456a() || (a9 = iy.a(this.f708a, iqVar.f708a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(iqVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a8 = iy.a(this.f707a, iqVar.f707a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(iqVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a7 = iy.a(this.f710b, iqVar.f710b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(iqVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a6 = iy.a(this.f711c, iqVar.f711c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(iqVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a5 = iy.a(this.f712d, iqVar.f712d)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(iqVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a4 = iy.a(this.f713e, iqVar.f713e)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(iqVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a3 = iy.a(this.f714f, iqVar.f714f)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(iqVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a2 = iy.a(this.f709a, iqVar.f709a)) == 0) {
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
        this.f710b = str;
        return this;
    }

    public void a() {
        if (this.f710b == null) {
            throw new jj("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f711c == null) {
            throw new jj("Required field 'appId' was not present! Struct: " + toString());
        }
        if (this.f712d == null) {
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
                        this.f708a = jiVar.m484a();
                        break;
                    } else {
                        jl.a(jiVar, m479a.a);
                        break;
                    }
                case 2:
                    if (m479a.a == 12) {
                        this.f707a = new ib();
                        this.f707a.a(jiVar);
                        break;
                    } else {
                        jl.a(jiVar, m479a.a);
                        break;
                    }
                case 3:
                    if (m479a.a == 11) {
                        this.f710b = jiVar.m484a();
                        break;
                    } else {
                        jl.a(jiVar, m479a.a);
                        break;
                    }
                case 4:
                    if (m479a.a == 11) {
                        this.f711c = jiVar.m484a();
                        break;
                    } else {
                        jl.a(jiVar, m479a.a);
                        break;
                    }
                case 5:
                    if (m479a.a == 11) {
                        this.f712d = jiVar.m484a();
                        break;
                    } else {
                        jl.a(jiVar, m479a.a);
                        break;
                    }
                case 6:
                    if (m479a.a == 11) {
                        this.f713e = jiVar.m484a();
                        break;
                    } else {
                        jl.a(jiVar, m479a.a);
                        break;
                    }
                case 7:
                    if (m479a.a == 11) {
                        this.f714f = jiVar.m484a();
                        break;
                    } else {
                        jl.a(jiVar, m479a.a);
                        break;
                    }
                case 8:
                    if (m479a.a == 15) {
                        jg m480a = jiVar.m480a();
                        this.f709a = new ArrayList(m480a.f784a);
                        for (int i = 0; i < m480a.f784a; i++) {
                            this.f709a.add(jiVar.m484a());
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
        return this.f708a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m457a(iq iqVar) {
        if (iqVar == null) {
            return false;
        }
        boolean m456a = m456a();
        boolean m456a2 = iqVar.m456a();
        if ((m456a || m456a2) && !(m456a && m456a2 && this.f708a.equals(iqVar.f708a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = iqVar.b();
        if ((b2 || b3) && !(b2 && b3 && this.f707a.m392a(iqVar.f707a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = iqVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f710b.equals(iqVar.f710b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = iqVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f711c.equals(iqVar.f711c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = iqVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f712d.equals(iqVar.f712d))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = iqVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f713e.equals(iqVar.f713e))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = iqVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f714f.equals(iqVar.f714f))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = iqVar.h();
        return !(h2 || h3) || (h2 && h3 && this.f709a.equals(iqVar.f709a));
    }

    public iq b(String str) {
        this.f711c = str;
        return this;
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        a();
        jiVar.a(f706a);
        if (this.f708a != null && m456a()) {
            jiVar.a(a);
            jiVar.a(this.f708a);
            jiVar.b();
        }
        if (this.f707a != null && b()) {
            jiVar.a(b);
            this.f707a.b(jiVar);
            jiVar.b();
        }
        if (this.f710b != null) {
            jiVar.a(c);
            jiVar.a(this.f710b);
            jiVar.b();
        }
        if (this.f711c != null) {
            jiVar.a(d);
            jiVar.a(this.f711c);
            jiVar.b();
        }
        if (this.f712d != null) {
            jiVar.a(e);
            jiVar.a(this.f712d);
            jiVar.b();
        }
        if (this.f713e != null && f()) {
            jiVar.a(f);
            jiVar.a(this.f713e);
            jiVar.b();
        }
        if (this.f714f != null && g()) {
            jiVar.a(g);
            jiVar.a(this.f714f);
            jiVar.b();
        }
        if (this.f709a != null && h()) {
            jiVar.a(h);
            jiVar.a(new jg(Constants.GZIP_CAST_TYPE, this.f709a.size()));
            for (String str : this.f709a) {
                jiVar.a(str);
            }
            jiVar.e();
            jiVar.b();
        }
        jiVar.c();
        jiVar.m487a();
    }

    public boolean b() {
        return this.f707a != null;
    }

    public iq c(String str) {
        this.f712d = str;
        return this;
    }

    public boolean c() {
        return this.f710b != null;
    }

    public iq d(String str) {
        this.f713e = str;
        return this;
    }

    public boolean d() {
        return this.f711c != null;
    }

    public iq e(String str) {
        this.f714f = str;
        return this;
    }

    public boolean e() {
        return this.f712d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof iq)) {
            return m457a((iq) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f713e != null;
    }

    public boolean g() {
        return this.f714f != null;
    }

    public boolean h() {
        return this.f709a != null;
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
            if (this.f708a == null) {
                sb.append("null");
            } else {
                sb.append(this.f708a);
            }
            z2 = false;
        }
        if (b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f707a == null) {
                sb.append("null");
            } else {
                sb.append(this.f707a);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f710b == null) {
            sb.append("null");
        } else {
            sb.append(this.f710b);
        }
        sb.append(", ");
        sb.append("appId:");
        if (this.f711c == null) {
            sb.append("null");
        } else {
            sb.append(this.f711c);
        }
        sb.append(", ");
        sb.append(UrlSchemaHelper.SCHEMA_TYPE_TOPIC);
        if (this.f712d == null) {
            sb.append("null");
        } else {
            sb.append(this.f712d);
        }
        if (f()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f713e == null) {
                sb.append("null");
            } else {
                sb.append(this.f713e);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("category:");
            if (this.f714f == null) {
                sb.append("null");
            } else {
                sb.append(this.f714f);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("aliases:");
            if (this.f709a == null) {
                sb.append("null");
            } else {
                sb.append(this.f709a);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
