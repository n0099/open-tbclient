package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class ik implements ir<ik, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public hv f718a;

    /* renamed from: a  reason: collision with other field name */
    public String f719a;

    /* renamed from: a  reason: collision with other field name */
    public List<String> f720a;

    /* renamed from: b  reason: collision with other field name */
    public String f721b;

    /* renamed from: c  reason: collision with other field name */
    public String f722c;

    /* renamed from: d  reason: collision with other field name */
    public String f723d;

    /* renamed from: e  reason: collision with other field name */
    public String f724e;

    /* renamed from: f  reason: collision with other field name */
    public String f725f;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f717a = new jh("XmPushActionSubscription");
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
    public int compareTo(ik ikVar) {
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        int a8;
        int a9;
        if (getClass().equals(ikVar.getClass())) {
            int compareTo = Boolean.valueOf(m440a()).compareTo(Boolean.valueOf(ikVar.m440a()));
            if (compareTo == 0) {
                if (!m440a() || (a9 = is.a(this.f719a, ikVar.f719a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(ikVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a8 = is.a(this.f718a, ikVar.f718a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(ikVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a7 = is.a(this.f721b, ikVar.f721b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(ikVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a6 = is.a(this.f722c, ikVar.f722c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(ikVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a5 = is.a(this.f723d, ikVar.f723d)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(ikVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a4 = is.a(this.f724e, ikVar.f724e)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ikVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a3 = is.a(this.f725f, ikVar.f725f)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(ikVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a2 = is.a(this.f720a, ikVar.f720a)) == 0) {
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
        return getClass().getName().compareTo(ikVar.getClass().getName());
    }

    public ik a(String str) {
        this.f721b = str;
        return this;
    }

    public void a() {
        if (this.f721b == null) {
            throw new jd("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f722c == null) {
            throw new jd("Required field 'appId' was not present! Struct: " + toString());
        }
        if (this.f723d == null) {
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
                        this.f719a = jcVar.m468a();
                        break;
                    } else {
                        jf.a(jcVar, m463a.a);
                        break;
                    }
                case 2:
                    if (m463a.a == 12) {
                        this.f718a = new hv();
                        this.f718a.a(jcVar);
                        break;
                    } else {
                        jf.a(jcVar, m463a.a);
                        break;
                    }
                case 3:
                    if (m463a.a == 11) {
                        this.f721b = jcVar.m468a();
                        break;
                    } else {
                        jf.a(jcVar, m463a.a);
                        break;
                    }
                case 4:
                    if (m463a.a == 11) {
                        this.f722c = jcVar.m468a();
                        break;
                    } else {
                        jf.a(jcVar, m463a.a);
                        break;
                    }
                case 5:
                    if (m463a.a == 11) {
                        this.f723d = jcVar.m468a();
                        break;
                    } else {
                        jf.a(jcVar, m463a.a);
                        break;
                    }
                case 6:
                    if (m463a.a == 11) {
                        this.f724e = jcVar.m468a();
                        break;
                    } else {
                        jf.a(jcVar, m463a.a);
                        break;
                    }
                case 7:
                    if (m463a.a == 11) {
                        this.f725f = jcVar.m468a();
                        break;
                    } else {
                        jf.a(jcVar, m463a.a);
                        break;
                    }
                case 8:
                    if (m463a.a == 15) {
                        ja m464a = jcVar.m464a();
                        this.f720a = new ArrayList(m464a.f795a);
                        for (int i = 0; i < m464a.f795a; i++) {
                            this.f720a.add(jcVar.m468a());
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
    public boolean m440a() {
        return this.f719a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m441a(ik ikVar) {
        if (ikVar == null) {
            return false;
        }
        boolean m440a = m440a();
        boolean m440a2 = ikVar.m440a();
        if ((m440a || m440a2) && !(m440a && m440a2 && this.f719a.equals(ikVar.f719a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = ikVar.b();
        if ((b2 || b3) && !(b2 && b3 && this.f718a.m373a(ikVar.f718a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = ikVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f721b.equals(ikVar.f721b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = ikVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f722c.equals(ikVar.f722c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = ikVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f723d.equals(ikVar.f723d))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = ikVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f724e.equals(ikVar.f724e))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = ikVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f725f.equals(ikVar.f725f))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = ikVar.h();
        return !(h2 || h3) || (h2 && h3 && this.f720a.equals(ikVar.f720a));
    }

    public ik b(String str) {
        this.f722c = str;
        return this;
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        a();
        jcVar.a(f717a);
        if (this.f719a != null && m440a()) {
            jcVar.a(a);
            jcVar.a(this.f719a);
            jcVar.b();
        }
        if (this.f718a != null && b()) {
            jcVar.a(b);
            this.f718a.b(jcVar);
            jcVar.b();
        }
        if (this.f721b != null) {
            jcVar.a(c);
            jcVar.a(this.f721b);
            jcVar.b();
        }
        if (this.f722c != null) {
            jcVar.a(d);
            jcVar.a(this.f722c);
            jcVar.b();
        }
        if (this.f723d != null) {
            jcVar.a(e);
            jcVar.a(this.f723d);
            jcVar.b();
        }
        if (this.f724e != null && f()) {
            jcVar.a(f);
            jcVar.a(this.f724e);
            jcVar.b();
        }
        if (this.f725f != null && g()) {
            jcVar.a(g);
            jcVar.a(this.f725f);
            jcVar.b();
        }
        if (this.f720a != null && h()) {
            jcVar.a(h);
            jcVar.a(new ja(Constants.GZIP_CAST_TYPE, this.f720a.size()));
            for (String str : this.f720a) {
                jcVar.a(str);
            }
            jcVar.e();
            jcVar.b();
        }
        jcVar.c();
        jcVar.m471a();
    }

    public boolean b() {
        return this.f718a != null;
    }

    public ik c(String str) {
        this.f723d = str;
        return this;
    }

    public boolean c() {
        return this.f721b != null;
    }

    public ik d(String str) {
        this.f724e = str;
        return this;
    }

    public boolean d() {
        return this.f722c != null;
    }

    public ik e(String str) {
        this.f725f = str;
        return this;
    }

    public boolean e() {
        return this.f723d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ik)) {
            return m441a((ik) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f724e != null;
    }

    public boolean g() {
        return this.f725f != null;
    }

    public boolean h() {
        return this.f720a != null;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionSubscription(");
        boolean z2 = true;
        if (m440a()) {
            sb.append("debug:");
            if (this.f719a == null) {
                sb.append("null");
            } else {
                sb.append(this.f719a);
            }
            z2 = false;
        }
        if (b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f718a == null) {
                sb.append("null");
            } else {
                sb.append(this.f718a);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f721b == null) {
            sb.append("null");
        } else {
            sb.append(this.f721b);
        }
        sb.append(", ");
        sb.append("appId:");
        if (this.f722c == null) {
            sb.append("null");
        } else {
            sb.append(this.f722c);
        }
        sb.append(", ");
        sb.append(UrlSchemaHelper.SCHEMA_TYPE_TOPIC);
        if (this.f723d == null) {
            sb.append("null");
        } else {
            sb.append(this.f723d);
        }
        if (f()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f724e == null) {
                sb.append("null");
            } else {
                sb.append(this.f724e);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("category:");
            if (this.f725f == null) {
                sb.append("null");
            } else {
                sb.append(this.f725f);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("aliases:");
            if (this.f720a == null) {
                sb.append("null");
            } else {
                sb.append(this.f720a);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
