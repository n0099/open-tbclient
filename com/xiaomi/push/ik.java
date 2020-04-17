package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class ik implements ir<ik, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public hv f715a;

    /* renamed from: a  reason: collision with other field name */
    public String f716a;

    /* renamed from: a  reason: collision with other field name */
    public List<String> f717a;

    /* renamed from: b  reason: collision with other field name */
    public String f718b;

    /* renamed from: c  reason: collision with other field name */
    public String f719c;

    /* renamed from: d  reason: collision with other field name */
    public String f720d;

    /* renamed from: e  reason: collision with other field name */
    public String f721e;

    /* renamed from: f  reason: collision with other field name */
    public String f722f;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f714a = new jh("XmPushActionSubscription");
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
            int compareTo = Boolean.valueOf(m448a()).compareTo(Boolean.valueOf(ikVar.m448a()));
            if (compareTo == 0) {
                if (!m448a() || (a9 = is.a(this.f716a, ikVar.f716a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(ikVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a8 = is.a(this.f715a, ikVar.f715a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(ikVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a7 = is.a(this.f718b, ikVar.f718b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(ikVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a6 = is.a(this.f719c, ikVar.f719c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(ikVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a5 = is.a(this.f720d, ikVar.f720d)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(ikVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a4 = is.a(this.f721e, ikVar.f721e)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ikVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a3 = is.a(this.f722f, ikVar.f722f)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(ikVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a2 = is.a(this.f717a, ikVar.f717a)) == 0) {
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
        this.f718b = str;
        return this;
    }

    public void a() {
        if (this.f718b == null) {
            throw new jd("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f719c == null) {
            throw new jd("Required field 'appId' was not present! Struct: " + toString());
        }
        if (this.f720d == null) {
            throw new jd("Required field 'topic' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ir
    public void a(jc jcVar) {
        jcVar.m475a();
        while (true) {
            iz m471a = jcVar.m471a();
            if (m471a.a == 0) {
                jcVar.f();
                a();
                return;
            }
            switch (m471a.f789a) {
                case 1:
                    if (m471a.a == 11) {
                        this.f716a = jcVar.m476a();
                        break;
                    } else {
                        jf.a(jcVar, m471a.a);
                        break;
                    }
                case 2:
                    if (m471a.a == 12) {
                        this.f715a = new hv();
                        this.f715a.a(jcVar);
                        break;
                    } else {
                        jf.a(jcVar, m471a.a);
                        break;
                    }
                case 3:
                    if (m471a.a == 11) {
                        this.f718b = jcVar.m476a();
                        break;
                    } else {
                        jf.a(jcVar, m471a.a);
                        break;
                    }
                case 4:
                    if (m471a.a == 11) {
                        this.f719c = jcVar.m476a();
                        break;
                    } else {
                        jf.a(jcVar, m471a.a);
                        break;
                    }
                case 5:
                    if (m471a.a == 11) {
                        this.f720d = jcVar.m476a();
                        break;
                    } else {
                        jf.a(jcVar, m471a.a);
                        break;
                    }
                case 6:
                    if (m471a.a == 11) {
                        this.f721e = jcVar.m476a();
                        break;
                    } else {
                        jf.a(jcVar, m471a.a);
                        break;
                    }
                case 7:
                    if (m471a.a == 11) {
                        this.f722f = jcVar.m476a();
                        break;
                    } else {
                        jf.a(jcVar, m471a.a);
                        break;
                    }
                case 8:
                    if (m471a.a == 15) {
                        ja m472a = jcVar.m472a();
                        this.f717a = new ArrayList(m472a.f792a);
                        for (int i = 0; i < m472a.f792a; i++) {
                            this.f717a.add(jcVar.m476a());
                        }
                        jcVar.i();
                        break;
                    } else {
                        jf.a(jcVar, m471a.a);
                        break;
                    }
                default:
                    jf.a(jcVar, m471a.a);
                    break;
            }
            jcVar.g();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m448a() {
        return this.f716a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m449a(ik ikVar) {
        if (ikVar == null) {
            return false;
        }
        boolean m448a = m448a();
        boolean m448a2 = ikVar.m448a();
        if ((m448a || m448a2) && !(m448a && m448a2 && this.f716a.equals(ikVar.f716a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = ikVar.b();
        if ((b2 || b3) && !(b2 && b3 && this.f715a.m381a(ikVar.f715a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = ikVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f718b.equals(ikVar.f718b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = ikVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f719c.equals(ikVar.f719c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = ikVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f720d.equals(ikVar.f720d))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = ikVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f721e.equals(ikVar.f721e))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = ikVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f722f.equals(ikVar.f722f))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = ikVar.h();
        return !(h2 || h3) || (h2 && h3 && this.f717a.equals(ikVar.f717a));
    }

    public ik b(String str) {
        this.f719c = str;
        return this;
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        a();
        jcVar.a(f714a);
        if (this.f716a != null && m448a()) {
            jcVar.a(a);
            jcVar.a(this.f716a);
            jcVar.b();
        }
        if (this.f715a != null && b()) {
            jcVar.a(b);
            this.f715a.b(jcVar);
            jcVar.b();
        }
        if (this.f718b != null) {
            jcVar.a(c);
            jcVar.a(this.f718b);
            jcVar.b();
        }
        if (this.f719c != null) {
            jcVar.a(d);
            jcVar.a(this.f719c);
            jcVar.b();
        }
        if (this.f720d != null) {
            jcVar.a(e);
            jcVar.a(this.f720d);
            jcVar.b();
        }
        if (this.f721e != null && f()) {
            jcVar.a(f);
            jcVar.a(this.f721e);
            jcVar.b();
        }
        if (this.f722f != null && g()) {
            jcVar.a(g);
            jcVar.a(this.f722f);
            jcVar.b();
        }
        if (this.f717a != null && h()) {
            jcVar.a(h);
            jcVar.a(new ja(Constants.GZIP_CAST_TYPE, this.f717a.size()));
            for (String str : this.f717a) {
                jcVar.a(str);
            }
            jcVar.e();
            jcVar.b();
        }
        jcVar.c();
        jcVar.m479a();
    }

    public boolean b() {
        return this.f715a != null;
    }

    public ik c(String str) {
        this.f720d = str;
        return this;
    }

    public boolean c() {
        return this.f718b != null;
    }

    public ik d(String str) {
        this.f721e = str;
        return this;
    }

    public boolean d() {
        return this.f719c != null;
    }

    public ik e(String str) {
        this.f722f = str;
        return this;
    }

    public boolean e() {
        return this.f720d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ik)) {
            return m449a((ik) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f721e != null;
    }

    public boolean g() {
        return this.f722f != null;
    }

    public boolean h() {
        return this.f717a != null;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionSubscription(");
        boolean z2 = true;
        if (m448a()) {
            sb.append("debug:");
            if (this.f716a == null) {
                sb.append("null");
            } else {
                sb.append(this.f716a);
            }
            z2 = false;
        }
        if (b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f715a == null) {
                sb.append("null");
            } else {
                sb.append(this.f715a);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f718b == null) {
            sb.append("null");
        } else {
            sb.append(this.f718b);
        }
        sb.append(", ");
        sb.append("appId:");
        if (this.f719c == null) {
            sb.append("null");
        } else {
            sb.append(this.f719c);
        }
        sb.append(", ");
        sb.append(UrlSchemaHelper.SCHEMA_TYPE_TOPIC);
        if (this.f720d == null) {
            sb.append("null");
        } else {
            sb.append(this.f720d);
        }
        if (f()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f721e == null) {
                sb.append("null");
            } else {
                sb.append(this.f721e);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("category:");
            if (this.f722f == null) {
                sb.append("null");
            } else {
                sb.append(this.f722f);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("aliases:");
            if (this.f717a == null) {
                sb.append("null");
            } else {
                sb.append(this.f717a);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
