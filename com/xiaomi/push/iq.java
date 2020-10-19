package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes12.dex */
public class iq implements ix<iq, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public ib f703a;

    /* renamed from: a  reason: collision with other field name */
    public String f704a;

    /* renamed from: a  reason: collision with other field name */
    public List<String> f705a;

    /* renamed from: b  reason: collision with other field name */
    public String f706b;

    /* renamed from: c  reason: collision with other field name */
    public String f707c;

    /* renamed from: d  reason: collision with other field name */
    public String f708d;

    /* renamed from: e  reason: collision with other field name */
    public String f709e;

    /* renamed from: f  reason: collision with other field name */
    public String f710f;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f702a = new jn("XmPushActionSubscription");

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
            int compareTo = Boolean.valueOf(m463a()).compareTo(Boolean.valueOf(iqVar.m463a()));
            if (compareTo == 0) {
                if (!m463a() || (a9 = iy.a(this.f704a, iqVar.f704a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(iqVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a8 = iy.a(this.f703a, iqVar.f703a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(iqVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a7 = iy.a(this.f706b, iqVar.f706b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(iqVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a6 = iy.a(this.f707c, iqVar.f707c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(iqVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a5 = iy.a(this.f708d, iqVar.f708d)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(iqVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a4 = iy.a(this.f709e, iqVar.f709e)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(iqVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a3 = iy.a(this.f710f, iqVar.f710f)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(iqVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a2 = iy.a(this.f705a, iqVar.f705a)) == 0) {
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
        this.f706b = str;
        return this;
    }

    public void a() {
        if (this.f706b == null) {
            throw new jj("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f707c == null) {
            throw new jj("Required field 'appId' was not present! Struct: " + toString());
        }
        if (this.f708d == null) {
            throw new jj("Required field 'topic' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m490a();
        while (true) {
            jf m486a = jiVar.m486a();
            if (m486a.f5000a == 0) {
                jiVar.f();
                a();
                return;
            }
            switch (m486a.f779a) {
                case 1:
                    if (m486a.f5000a == 11) {
                        this.f704a = jiVar.m491a();
                        break;
                    } else {
                        jl.a(jiVar, m486a.f5000a);
                        break;
                    }
                case 2:
                    if (m486a.f5000a == 12) {
                        this.f703a = new ib();
                        this.f703a.a(jiVar);
                        break;
                    } else {
                        jl.a(jiVar, m486a.f5000a);
                        break;
                    }
                case 3:
                    if (m486a.f5000a == 11) {
                        this.f706b = jiVar.m491a();
                        break;
                    } else {
                        jl.a(jiVar, m486a.f5000a);
                        break;
                    }
                case 4:
                    if (m486a.f5000a == 11) {
                        this.f707c = jiVar.m491a();
                        break;
                    } else {
                        jl.a(jiVar, m486a.f5000a);
                        break;
                    }
                case 5:
                    if (m486a.f5000a == 11) {
                        this.f708d = jiVar.m491a();
                        break;
                    } else {
                        jl.a(jiVar, m486a.f5000a);
                        break;
                    }
                case 6:
                    if (m486a.f5000a == 11) {
                        this.f709e = jiVar.m491a();
                        break;
                    } else {
                        jl.a(jiVar, m486a.f5000a);
                        break;
                    }
                case 7:
                    if (m486a.f5000a == 11) {
                        this.f710f = jiVar.m491a();
                        break;
                    } else {
                        jl.a(jiVar, m486a.f5000a);
                        break;
                    }
                case 8:
                    if (m486a.f5000a == 15) {
                        jg m487a = jiVar.m487a();
                        this.f705a = new ArrayList(m487a.f780a);
                        for (int i = 0; i < m487a.f780a; i++) {
                            this.f705a.add(jiVar.m491a());
                        }
                        jiVar.i();
                        break;
                    } else {
                        jl.a(jiVar, m486a.f5000a);
                        break;
                    }
                default:
                    jl.a(jiVar, m486a.f5000a);
                    break;
            }
            jiVar.g();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m463a() {
        return this.f704a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m464a(iq iqVar) {
        if (iqVar == null) {
            return false;
        }
        boolean m463a = m463a();
        boolean m463a2 = iqVar.m463a();
        if ((m463a || m463a2) && !(m463a && m463a2 && this.f704a.equals(iqVar.f704a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = iqVar.b();
        if ((b2 || b3) && !(b2 && b3 && this.f703a.m399a(iqVar.f703a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = iqVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f706b.equals(iqVar.f706b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = iqVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f707c.equals(iqVar.f707c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = iqVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f708d.equals(iqVar.f708d))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = iqVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f709e.equals(iqVar.f709e))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = iqVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f710f.equals(iqVar.f710f))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = iqVar.h();
        return !(h2 || h3) || (h2 && h3 && this.f705a.equals(iqVar.f705a));
    }

    public iq b(String str) {
        this.f707c = str;
        return this;
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        a();
        jiVar.a(f702a);
        if (this.f704a != null && m463a()) {
            jiVar.a(f4986a);
            jiVar.a(this.f704a);
            jiVar.b();
        }
        if (this.f703a != null && b()) {
            jiVar.a(b);
            this.f703a.b(jiVar);
            jiVar.b();
        }
        if (this.f706b != null) {
            jiVar.a(c);
            jiVar.a(this.f706b);
            jiVar.b();
        }
        if (this.f707c != null) {
            jiVar.a(d);
            jiVar.a(this.f707c);
            jiVar.b();
        }
        if (this.f708d != null) {
            jiVar.a(e);
            jiVar.a(this.f708d);
            jiVar.b();
        }
        if (this.f709e != null && f()) {
            jiVar.a(f);
            jiVar.a(this.f709e);
            jiVar.b();
        }
        if (this.f710f != null && g()) {
            jiVar.a(g);
            jiVar.a(this.f710f);
            jiVar.b();
        }
        if (this.f705a != null && h()) {
            jiVar.a(h);
            jiVar.a(new jg(Constants.GZIP_CAST_TYPE, this.f705a.size()));
            for (String str : this.f705a) {
                jiVar.a(str);
            }
            jiVar.e();
            jiVar.b();
        }
        jiVar.c();
        jiVar.m494a();
    }

    public boolean b() {
        return this.f703a != null;
    }

    public iq c(String str) {
        this.f708d = str;
        return this;
    }

    public boolean c() {
        return this.f706b != null;
    }

    public iq d(String str) {
        this.f709e = str;
        return this;
    }

    public boolean d() {
        return this.f707c != null;
    }

    public iq e(String str) {
        this.f710f = str;
        return this;
    }

    public boolean e() {
        return this.f708d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof iq)) {
            return m464a((iq) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f709e != null;
    }

    public boolean g() {
        return this.f710f != null;
    }

    public boolean h() {
        return this.f705a != null;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionSubscription(");
        boolean z2 = true;
        if (m463a()) {
            sb.append("debug:");
            if (this.f704a == null) {
                sb.append("null");
            } else {
                sb.append(this.f704a);
            }
            z2 = false;
        }
        if (b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f703a == null) {
                sb.append("null");
            } else {
                sb.append(this.f703a);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f706b == null) {
            sb.append("null");
        } else {
            sb.append(this.f706b);
        }
        sb.append(", ");
        sb.append("appId:");
        if (this.f707c == null) {
            sb.append("null");
        } else {
            sb.append(this.f707c);
        }
        sb.append(", ");
        sb.append(UrlSchemaHelper.SCHEMA_TYPE_TOPIC);
        if (this.f708d == null) {
            sb.append("null");
        } else {
            sb.append(this.f708d);
        }
        if (f()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f709e == null) {
                sb.append("null");
            } else {
                sb.append(this.f709e);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("category:");
            if (this.f710f == null) {
                sb.append("null");
            } else {
                sb.append(this.f710f);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("aliases:");
            if (this.f705a == null) {
                sb.append("null");
            } else {
                sb.append(this.f705a);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
