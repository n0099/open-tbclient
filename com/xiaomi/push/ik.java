package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class ik implements ir<ik, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public hv f714a;

    /* renamed from: a  reason: collision with other field name */
    public String f715a;

    /* renamed from: a  reason: collision with other field name */
    public List<String> f716a;

    /* renamed from: b  reason: collision with other field name */
    public String f717b;

    /* renamed from: c  reason: collision with other field name */
    public String f718c;

    /* renamed from: d  reason: collision with other field name */
    public String f719d;

    /* renamed from: e  reason: collision with other field name */
    public String f720e;

    /* renamed from: f  reason: collision with other field name */
    public String f721f;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f713a = new jh("XmPushActionSubscription");
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
            int compareTo = Boolean.valueOf(m443a()).compareTo(Boolean.valueOf(ikVar.m443a()));
            if (compareTo == 0) {
                if (!m443a() || (a9 = is.a(this.f715a, ikVar.f715a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(ikVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a8 = is.a(this.f714a, ikVar.f714a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(ikVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a7 = is.a(this.f717b, ikVar.f717b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(ikVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a6 = is.a(this.f718c, ikVar.f718c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(ikVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a5 = is.a(this.f719d, ikVar.f719d)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(ikVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a4 = is.a(this.f720e, ikVar.f720e)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ikVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a3 = is.a(this.f721f, ikVar.f721f)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(ikVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a2 = is.a(this.f716a, ikVar.f716a)) == 0) {
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
        this.f717b = str;
        return this;
    }

    public void a() {
        if (this.f717b == null) {
            throw new jd("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f718c == null) {
            throw new jd("Required field 'appId' was not present! Struct: " + toString());
        }
        if (this.f719d == null) {
            throw new jd("Required field 'topic' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ir
    public void a(jc jcVar) {
        jcVar.m470a();
        while (true) {
            iz m466a = jcVar.m466a();
            if (m466a.a == 0) {
                jcVar.f();
                a();
                return;
            }
            switch (m466a.f788a) {
                case 1:
                    if (m466a.a == 11) {
                        this.f715a = jcVar.m471a();
                        break;
                    } else {
                        jf.a(jcVar, m466a.a);
                        break;
                    }
                case 2:
                    if (m466a.a == 12) {
                        this.f714a = new hv();
                        this.f714a.a(jcVar);
                        break;
                    } else {
                        jf.a(jcVar, m466a.a);
                        break;
                    }
                case 3:
                    if (m466a.a == 11) {
                        this.f717b = jcVar.m471a();
                        break;
                    } else {
                        jf.a(jcVar, m466a.a);
                        break;
                    }
                case 4:
                    if (m466a.a == 11) {
                        this.f718c = jcVar.m471a();
                        break;
                    } else {
                        jf.a(jcVar, m466a.a);
                        break;
                    }
                case 5:
                    if (m466a.a == 11) {
                        this.f719d = jcVar.m471a();
                        break;
                    } else {
                        jf.a(jcVar, m466a.a);
                        break;
                    }
                case 6:
                    if (m466a.a == 11) {
                        this.f720e = jcVar.m471a();
                        break;
                    } else {
                        jf.a(jcVar, m466a.a);
                        break;
                    }
                case 7:
                    if (m466a.a == 11) {
                        this.f721f = jcVar.m471a();
                        break;
                    } else {
                        jf.a(jcVar, m466a.a);
                        break;
                    }
                case 8:
                    if (m466a.a == 15) {
                        ja m467a = jcVar.m467a();
                        this.f716a = new ArrayList(m467a.f791a);
                        for (int i = 0; i < m467a.f791a; i++) {
                            this.f716a.add(jcVar.m471a());
                        }
                        jcVar.i();
                        break;
                    } else {
                        jf.a(jcVar, m466a.a);
                        break;
                    }
                default:
                    jf.a(jcVar, m466a.a);
                    break;
            }
            jcVar.g();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m443a() {
        return this.f715a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m444a(ik ikVar) {
        if (ikVar == null) {
            return false;
        }
        boolean m443a = m443a();
        boolean m443a2 = ikVar.m443a();
        if ((m443a || m443a2) && !(m443a && m443a2 && this.f715a.equals(ikVar.f715a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = ikVar.b();
        if ((b2 || b3) && !(b2 && b3 && this.f714a.m376a(ikVar.f714a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = ikVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f717b.equals(ikVar.f717b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = ikVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f718c.equals(ikVar.f718c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = ikVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f719d.equals(ikVar.f719d))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = ikVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f720e.equals(ikVar.f720e))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = ikVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f721f.equals(ikVar.f721f))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = ikVar.h();
        return !(h2 || h3) || (h2 && h3 && this.f716a.equals(ikVar.f716a));
    }

    public ik b(String str) {
        this.f718c = str;
        return this;
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        a();
        jcVar.a(f713a);
        if (this.f715a != null && m443a()) {
            jcVar.a(a);
            jcVar.a(this.f715a);
            jcVar.b();
        }
        if (this.f714a != null && b()) {
            jcVar.a(b);
            this.f714a.b(jcVar);
            jcVar.b();
        }
        if (this.f717b != null) {
            jcVar.a(c);
            jcVar.a(this.f717b);
            jcVar.b();
        }
        if (this.f718c != null) {
            jcVar.a(d);
            jcVar.a(this.f718c);
            jcVar.b();
        }
        if (this.f719d != null) {
            jcVar.a(e);
            jcVar.a(this.f719d);
            jcVar.b();
        }
        if (this.f720e != null && f()) {
            jcVar.a(f);
            jcVar.a(this.f720e);
            jcVar.b();
        }
        if (this.f721f != null && g()) {
            jcVar.a(g);
            jcVar.a(this.f721f);
            jcVar.b();
        }
        if (this.f716a != null && h()) {
            jcVar.a(h);
            jcVar.a(new ja(Constants.GZIP_CAST_TYPE, this.f716a.size()));
            for (String str : this.f716a) {
                jcVar.a(str);
            }
            jcVar.e();
            jcVar.b();
        }
        jcVar.c();
        jcVar.m474a();
    }

    public boolean b() {
        return this.f714a != null;
    }

    public ik c(String str) {
        this.f719d = str;
        return this;
    }

    public boolean c() {
        return this.f717b != null;
    }

    public ik d(String str) {
        this.f720e = str;
        return this;
    }

    public boolean d() {
        return this.f718c != null;
    }

    public ik e(String str) {
        this.f721f = str;
        return this;
    }

    public boolean e() {
        return this.f719d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ik)) {
            return m444a((ik) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f720e != null;
    }

    public boolean g() {
        return this.f721f != null;
    }

    public boolean h() {
        return this.f716a != null;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionSubscription(");
        boolean z2 = true;
        if (m443a()) {
            sb.append("debug:");
            if (this.f715a == null) {
                sb.append("null");
            } else {
                sb.append(this.f715a);
            }
            z2 = false;
        }
        if (b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f714a == null) {
                sb.append("null");
            } else {
                sb.append(this.f714a);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f717b == null) {
            sb.append("null");
        } else {
            sb.append(this.f717b);
        }
        sb.append(", ");
        sb.append("appId:");
        if (this.f718c == null) {
            sb.append("null");
        } else {
            sb.append(this.f718c);
        }
        sb.append(", ");
        sb.append(UrlSchemaHelper.SCHEMA_TYPE_TOPIC);
        if (this.f719d == null) {
            sb.append("null");
        } else {
            sb.append(this.f719d);
        }
        if (f()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f720e == null) {
                sb.append("null");
            } else {
                sb.append(this.f720e);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("category:");
            if (this.f721f == null) {
                sb.append("null");
            } else {
                sb.append(this.f721f);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("aliases:");
            if (this.f716a == null) {
                sb.append("null");
            } else {
                sb.append(this.f716a);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
