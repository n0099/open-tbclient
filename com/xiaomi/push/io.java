package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class io implements ir<io, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public hv f763a;

    /* renamed from: a  reason: collision with other field name */
    public String f764a;

    /* renamed from: a  reason: collision with other field name */
    public List<String> f765a;

    /* renamed from: b  reason: collision with other field name */
    public String f766b;

    /* renamed from: c  reason: collision with other field name */
    public String f767c;

    /* renamed from: d  reason: collision with other field name */
    public String f768d;

    /* renamed from: e  reason: collision with other field name */
    public String f769e;

    /* renamed from: f  reason: collision with other field name */
    public String f770f;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f762a = new jh("XmPushActionUnSubscription");
    private static final iz a = new iz("", Constants.GZIP_CAST_TYPE, 1);
    private static final iz b = new iz("", (byte) 12, 2);
    private static final iz c = new iz("", Constants.GZIP_CAST_TYPE, 3);
    private static final iz d = new iz("", Constants.GZIP_CAST_TYPE, 4);
    private static final iz e = new iz("", Constants.GZIP_CAST_TYPE, 5);
    private static final iz f = new iz("", Constants.GZIP_CAST_TYPE, 6);
    private static final iz g = new iz("", Constants.GZIP_CAST_TYPE, 7);
    private static final iz h = new iz("", (byte) 15, 8);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(io ioVar) {
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        int a8;
        int a9;
        if (getClass().equals(ioVar.getClass())) {
            int compareTo = Boolean.valueOf(m451a()).compareTo(Boolean.valueOf(ioVar.m451a()));
            if (compareTo == 0) {
                if (!m451a() || (a9 = is.a(this.f764a, ioVar.f764a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(ioVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a8 = is.a(this.f763a, ioVar.f763a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(ioVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a7 = is.a(this.f766b, ioVar.f766b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(ioVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a6 = is.a(this.f767c, ioVar.f767c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(ioVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a5 = is.a(this.f768d, ioVar.f768d)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(ioVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a4 = is.a(this.f769e, ioVar.f769e)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ioVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a3 = is.a(this.f770f, ioVar.f770f)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(ioVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a2 = is.a(this.f765a, ioVar.f765a)) == 0) {
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
        return getClass().getName().compareTo(ioVar.getClass().getName());
    }

    public io a(String str) {
        this.f766b = str;
        return this;
    }

    public void a() {
        if (this.f766b == null) {
            throw new jd("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f767c == null) {
            throw new jd("Required field 'appId' was not present! Struct: " + toString());
        }
        if (this.f768d == null) {
            throw new jd("Required field 'topic' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ir
    public void a(jc jcVar) {
        jcVar.m467a();
        while (true) {
            iz m463a = jcVar.m463a();
            if (m463a.a == 0) {
                jcVar.f();
                a();
                return;
            }
            switch (m463a.f792a) {
                case 1:
                    if (m463a.a == 11) {
                        this.f764a = jcVar.m468a();
                        break;
                    } else {
                        jf.a(jcVar, m463a.a);
                        break;
                    }
                case 2:
                    if (m463a.a == 12) {
                        this.f763a = new hv();
                        this.f763a.a(jcVar);
                        break;
                    } else {
                        jf.a(jcVar, m463a.a);
                        break;
                    }
                case 3:
                    if (m463a.a == 11) {
                        this.f766b = jcVar.m468a();
                        break;
                    } else {
                        jf.a(jcVar, m463a.a);
                        break;
                    }
                case 4:
                    if (m463a.a == 11) {
                        this.f767c = jcVar.m468a();
                        break;
                    } else {
                        jf.a(jcVar, m463a.a);
                        break;
                    }
                case 5:
                    if (m463a.a == 11) {
                        this.f768d = jcVar.m468a();
                        break;
                    } else {
                        jf.a(jcVar, m463a.a);
                        break;
                    }
                case 6:
                    if (m463a.a == 11) {
                        this.f769e = jcVar.m468a();
                        break;
                    } else {
                        jf.a(jcVar, m463a.a);
                        break;
                    }
                case 7:
                    if (m463a.a == 11) {
                        this.f770f = jcVar.m468a();
                        break;
                    } else {
                        jf.a(jcVar, m463a.a);
                        break;
                    }
                case 8:
                    if (m463a.a == 15) {
                        ja m464a = jcVar.m464a();
                        this.f765a = new ArrayList(m464a.f795a);
                        for (int i = 0; i < m464a.f795a; i++) {
                            this.f765a.add(jcVar.m468a());
                        }
                        jcVar.i();
                        break;
                    } else {
                        jf.a(jcVar, m463a.a);
                        break;
                    }
                default:
                    jf.a(jcVar, m463a.a);
                    break;
            }
            jcVar.g();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m451a() {
        return this.f764a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m452a(io ioVar) {
        if (ioVar == null) {
            return false;
        }
        boolean m451a = m451a();
        boolean m451a2 = ioVar.m451a();
        if ((m451a || m451a2) && !(m451a && m451a2 && this.f764a.equals(ioVar.f764a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = ioVar.b();
        if ((b2 || b3) && !(b2 && b3 && this.f763a.m373a(ioVar.f763a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = ioVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f766b.equals(ioVar.f766b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = ioVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f767c.equals(ioVar.f767c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = ioVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f768d.equals(ioVar.f768d))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = ioVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f769e.equals(ioVar.f769e))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = ioVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f770f.equals(ioVar.f770f))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = ioVar.h();
        return !(h2 || h3) || (h2 && h3 && this.f765a.equals(ioVar.f765a));
    }

    public io b(String str) {
        this.f767c = str;
        return this;
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        a();
        jcVar.a(f762a);
        if (this.f764a != null && m451a()) {
            jcVar.a(a);
            jcVar.a(this.f764a);
            jcVar.b();
        }
        if (this.f763a != null && b()) {
            jcVar.a(b);
            this.f763a.b(jcVar);
            jcVar.b();
        }
        if (this.f766b != null) {
            jcVar.a(c);
            jcVar.a(this.f766b);
            jcVar.b();
        }
        if (this.f767c != null) {
            jcVar.a(d);
            jcVar.a(this.f767c);
            jcVar.b();
        }
        if (this.f768d != null) {
            jcVar.a(e);
            jcVar.a(this.f768d);
            jcVar.b();
        }
        if (this.f769e != null && f()) {
            jcVar.a(f);
            jcVar.a(this.f769e);
            jcVar.b();
        }
        if (this.f770f != null && g()) {
            jcVar.a(g);
            jcVar.a(this.f770f);
            jcVar.b();
        }
        if (this.f765a != null && h()) {
            jcVar.a(h);
            jcVar.a(new ja(Constants.GZIP_CAST_TYPE, this.f765a.size()));
            for (String str : this.f765a) {
                jcVar.a(str);
            }
            jcVar.e();
            jcVar.b();
        }
        jcVar.c();
        jcVar.m471a();
    }

    public boolean b() {
        return this.f763a != null;
    }

    public io c(String str) {
        this.f768d = str;
        return this;
    }

    public boolean c() {
        return this.f766b != null;
    }

    public io d(String str) {
        this.f769e = str;
        return this;
    }

    public boolean d() {
        return this.f767c != null;
    }

    public io e(String str) {
        this.f770f = str;
        return this;
    }

    public boolean e() {
        return this.f768d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof io)) {
            return m452a((io) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f769e != null;
    }

    public boolean g() {
        return this.f770f != null;
    }

    public boolean h() {
        return this.f765a != null;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionUnSubscription(");
        boolean z2 = true;
        if (m451a()) {
            sb.append("debug:");
            if (this.f764a == null) {
                sb.append("null");
            } else {
                sb.append(this.f764a);
            }
            z2 = false;
        }
        if (b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f763a == null) {
                sb.append("null");
            } else {
                sb.append(this.f763a);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f766b == null) {
            sb.append("null");
        } else {
            sb.append(this.f766b);
        }
        sb.append(", ");
        sb.append("appId:");
        if (this.f767c == null) {
            sb.append("null");
        } else {
            sb.append(this.f767c);
        }
        sb.append(", ");
        sb.append(UrlSchemaHelper.SCHEMA_TYPE_TOPIC);
        if (this.f768d == null) {
            sb.append("null");
        } else {
            sb.append(this.f768d);
        }
        if (f()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f769e == null) {
                sb.append("null");
            } else {
                sb.append(this.f769e);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("category:");
            if (this.f770f == null) {
                sb.append("null");
            } else {
                sb.append(this.f770f);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("aliases:");
            if (this.f765a == null) {
                sb.append("null");
            } else {
                sb.append(this.f765a);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
