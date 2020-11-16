package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes18.dex */
public class iq implements ix<iq, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public ib f705a;

    /* renamed from: a  reason: collision with other field name */
    public String f706a;

    /* renamed from: a  reason: collision with other field name */
    public List<String> f707a;

    /* renamed from: b  reason: collision with other field name */
    public String f708b;

    /* renamed from: c  reason: collision with other field name */
    public String f709c;

    /* renamed from: d  reason: collision with other field name */
    public String f710d;

    /* renamed from: e  reason: collision with other field name */
    public String f711e;

    /* renamed from: f  reason: collision with other field name */
    public String f712f;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f704a = new jn("XmPushActionSubscription");

    /* renamed from: a  reason: collision with root package name */
    private static final jf f4986a = new jf("", Constants.GZIP_CAST_TYPE, 1);
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
            int compareTo = Boolean.valueOf(m465a()).compareTo(Boolean.valueOf(iqVar.m465a()));
            if (compareTo == 0) {
                if (!m465a() || (a9 = iy.a(this.f706a, iqVar.f706a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(iqVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a8 = iy.a(this.f705a, iqVar.f705a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(iqVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a7 = iy.a(this.f708b, iqVar.f708b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(iqVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a6 = iy.a(this.f709c, iqVar.f709c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(iqVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a5 = iy.a(this.f710d, iqVar.f710d)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(iqVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a4 = iy.a(this.f711e, iqVar.f711e)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(iqVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a3 = iy.a(this.f712f, iqVar.f712f)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(iqVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a2 = iy.a(this.f707a, iqVar.f707a)) == 0) {
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
        this.f708b = str;
        return this;
    }

    public void a() {
        if (this.f708b == null) {
            throw new jj("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f709c == null) {
            throw new jj("Required field 'appId' was not present! Struct: " + toString());
        }
        if (this.f710d == null) {
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
                        this.f706a = jiVar.m493a();
                        break;
                    } else {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    }
                case 2:
                    if (m488a.f5000a == 12) {
                        this.f705a = new ib();
                        this.f705a.a(jiVar);
                        break;
                    } else {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    }
                case 3:
                    if (m488a.f5000a == 11) {
                        this.f708b = jiVar.m493a();
                        break;
                    } else {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    }
                case 4:
                    if (m488a.f5000a == 11) {
                        this.f709c = jiVar.m493a();
                        break;
                    } else {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    }
                case 5:
                    if (m488a.f5000a == 11) {
                        this.f710d = jiVar.m493a();
                        break;
                    } else {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    }
                case 6:
                    if (m488a.f5000a == 11) {
                        this.f711e = jiVar.m493a();
                        break;
                    } else {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    }
                case 7:
                    if (m488a.f5000a == 11) {
                        this.f712f = jiVar.m493a();
                        break;
                    } else {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    }
                case 8:
                    if (m488a.f5000a == 15) {
                        jg m489a = jiVar.m489a();
                        this.f707a = new ArrayList(m489a.f782a);
                        for (int i = 0; i < m489a.f782a; i++) {
                            this.f707a.add(jiVar.m493a());
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
    public boolean m465a() {
        return this.f706a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m466a(iq iqVar) {
        if (iqVar == null) {
            return false;
        }
        boolean m465a = m465a();
        boolean m465a2 = iqVar.m465a();
        if ((m465a || m465a2) && !(m465a && m465a2 && this.f706a.equals(iqVar.f706a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = iqVar.b();
        if ((b2 || b3) && !(b2 && b3 && this.f705a.m401a(iqVar.f705a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = iqVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f708b.equals(iqVar.f708b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = iqVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f709c.equals(iqVar.f709c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = iqVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f710d.equals(iqVar.f710d))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = iqVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f711e.equals(iqVar.f711e))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = iqVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f712f.equals(iqVar.f712f))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = iqVar.h();
        return !(h2 || h3) || (h2 && h3 && this.f707a.equals(iqVar.f707a));
    }

    public iq b(String str) {
        this.f709c = str;
        return this;
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        a();
        jiVar.a(f704a);
        if (this.f706a != null && m465a()) {
            jiVar.a(f4986a);
            jiVar.a(this.f706a);
            jiVar.b();
        }
        if (this.f705a != null && b()) {
            jiVar.a(b);
            this.f705a.b(jiVar);
            jiVar.b();
        }
        if (this.f708b != null) {
            jiVar.a(c);
            jiVar.a(this.f708b);
            jiVar.b();
        }
        if (this.f709c != null) {
            jiVar.a(d);
            jiVar.a(this.f709c);
            jiVar.b();
        }
        if (this.f710d != null) {
            jiVar.a(e);
            jiVar.a(this.f710d);
            jiVar.b();
        }
        if (this.f711e != null && f()) {
            jiVar.a(f);
            jiVar.a(this.f711e);
            jiVar.b();
        }
        if (this.f712f != null && g()) {
            jiVar.a(g);
            jiVar.a(this.f712f);
            jiVar.b();
        }
        if (this.f707a != null && h()) {
            jiVar.a(h);
            jiVar.a(new jg(Constants.GZIP_CAST_TYPE, this.f707a.size()));
            for (String str : this.f707a) {
                jiVar.a(str);
            }
            jiVar.e();
            jiVar.b();
        }
        jiVar.c();
        jiVar.m496a();
    }

    public boolean b() {
        return this.f705a != null;
    }

    public iq c(String str) {
        this.f710d = str;
        return this;
    }

    public boolean c() {
        return this.f708b != null;
    }

    public iq d(String str) {
        this.f711e = str;
        return this;
    }

    public boolean d() {
        return this.f709c != null;
    }

    public iq e(String str) {
        this.f712f = str;
        return this;
    }

    public boolean e() {
        return this.f710d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof iq)) {
            return m466a((iq) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f711e != null;
    }

    public boolean g() {
        return this.f712f != null;
    }

    public boolean h() {
        return this.f707a != null;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionSubscription(");
        boolean z2 = true;
        if (m465a()) {
            sb.append("debug:");
            if (this.f706a == null) {
                sb.append("null");
            } else {
                sb.append(this.f706a);
            }
            z2 = false;
        }
        if (b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f705a == null) {
                sb.append("null");
            } else {
                sb.append(this.f705a);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f708b == null) {
            sb.append("null");
        } else {
            sb.append(this.f708b);
        }
        sb.append(", ");
        sb.append("appId:");
        if (this.f709c == null) {
            sb.append("null");
        } else {
            sb.append(this.f709c);
        }
        sb.append(", ");
        sb.append(UrlSchemaHelper.SCHEMA_TYPE_TOPIC);
        if (this.f710d == null) {
            sb.append("null");
        } else {
            sb.append(this.f710d);
        }
        if (f()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f711e == null) {
                sb.append("null");
            } else {
                sb.append(this.f711e);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("category:");
            if (this.f712f == null) {
                sb.append("null");
            } else {
                sb.append(this.f712f);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("aliases:");
            if (this.f707a == null) {
                sb.append("null");
            } else {
                sb.append(this.f707a);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
