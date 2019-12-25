package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class ik implements ir<ik, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public hv f719a;

    /* renamed from: a  reason: collision with other field name */
    public String f720a;

    /* renamed from: a  reason: collision with other field name */
    public List<String> f721a;

    /* renamed from: b  reason: collision with other field name */
    public String f722b;

    /* renamed from: c  reason: collision with other field name */
    public String f723c;

    /* renamed from: d  reason: collision with other field name */
    public String f724d;

    /* renamed from: e  reason: collision with other field name */
    public String f725e;

    /* renamed from: f  reason: collision with other field name */
    public String f726f;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f718a = new jh("XmPushActionSubscription");
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
            int compareTo = Boolean.valueOf(m431a()).compareTo(Boolean.valueOf(ikVar.m431a()));
            if (compareTo == 0) {
                if (!m431a() || (a9 = is.a(this.f720a, ikVar.f720a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(ikVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a8 = is.a(this.f719a, ikVar.f719a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(ikVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a7 = is.a(this.f722b, ikVar.f722b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(ikVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a6 = is.a(this.f723c, ikVar.f723c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(ikVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a5 = is.a(this.f724d, ikVar.f724d)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(ikVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a4 = is.a(this.f725e, ikVar.f725e)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ikVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a3 = is.a(this.f726f, ikVar.f726f)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(ikVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a2 = is.a(this.f721a, ikVar.f721a)) == 0) {
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
        this.f722b = str;
        return this;
    }

    public void a() {
        if (this.f722b == null) {
            throw new jd("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f723c == null) {
            throw new jd("Required field 'appId' was not present! Struct: " + toString());
        }
        if (this.f724d == null) {
            throw new jd("Required field 'topic' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ir
    public void a(jc jcVar) {
        jcVar.m458a();
        while (true) {
            iz m454a = jcVar.m454a();
            if (m454a.a == 0) {
                jcVar.f();
                a();
                return;
            }
            switch (m454a.f793a) {
                case 1:
                    if (m454a.a == 11) {
                        this.f720a = jcVar.m459a();
                        break;
                    } else {
                        jf.a(jcVar, m454a.a);
                        break;
                    }
                case 2:
                    if (m454a.a == 12) {
                        this.f719a = new hv();
                        this.f719a.a(jcVar);
                        break;
                    } else {
                        jf.a(jcVar, m454a.a);
                        break;
                    }
                case 3:
                    if (m454a.a == 11) {
                        this.f722b = jcVar.m459a();
                        break;
                    } else {
                        jf.a(jcVar, m454a.a);
                        break;
                    }
                case 4:
                    if (m454a.a == 11) {
                        this.f723c = jcVar.m459a();
                        break;
                    } else {
                        jf.a(jcVar, m454a.a);
                        break;
                    }
                case 5:
                    if (m454a.a == 11) {
                        this.f724d = jcVar.m459a();
                        break;
                    } else {
                        jf.a(jcVar, m454a.a);
                        break;
                    }
                case 6:
                    if (m454a.a == 11) {
                        this.f725e = jcVar.m459a();
                        break;
                    } else {
                        jf.a(jcVar, m454a.a);
                        break;
                    }
                case 7:
                    if (m454a.a == 11) {
                        this.f726f = jcVar.m459a();
                        break;
                    } else {
                        jf.a(jcVar, m454a.a);
                        break;
                    }
                case 8:
                    if (m454a.a == 15) {
                        ja m455a = jcVar.m455a();
                        this.f721a = new ArrayList(m455a.f796a);
                        for (int i = 0; i < m455a.f796a; i++) {
                            this.f721a.add(jcVar.m459a());
                        }
                        jcVar.i();
                        break;
                    } else {
                        jf.a(jcVar, m454a.a);
                        break;
                    }
                default:
                    jf.a(jcVar, m454a.a);
                    break;
            }
            jcVar.g();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m431a() {
        return this.f720a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m432a(ik ikVar) {
        if (ikVar == null) {
            return false;
        }
        boolean m431a = m431a();
        boolean m431a2 = ikVar.m431a();
        if ((m431a || m431a2) && !(m431a && m431a2 && this.f720a.equals(ikVar.f720a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = ikVar.b();
        if ((b2 || b3) && !(b2 && b3 && this.f719a.m364a(ikVar.f719a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = ikVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f722b.equals(ikVar.f722b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = ikVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f723c.equals(ikVar.f723c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = ikVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f724d.equals(ikVar.f724d))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = ikVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f725e.equals(ikVar.f725e))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = ikVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f726f.equals(ikVar.f726f))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = ikVar.h();
        return !(h2 || h3) || (h2 && h3 && this.f721a.equals(ikVar.f721a));
    }

    public ik b(String str) {
        this.f723c = str;
        return this;
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        a();
        jcVar.a(f718a);
        if (this.f720a != null && m431a()) {
            jcVar.a(a);
            jcVar.a(this.f720a);
            jcVar.b();
        }
        if (this.f719a != null && b()) {
            jcVar.a(b);
            this.f719a.b(jcVar);
            jcVar.b();
        }
        if (this.f722b != null) {
            jcVar.a(c);
            jcVar.a(this.f722b);
            jcVar.b();
        }
        if (this.f723c != null) {
            jcVar.a(d);
            jcVar.a(this.f723c);
            jcVar.b();
        }
        if (this.f724d != null) {
            jcVar.a(e);
            jcVar.a(this.f724d);
            jcVar.b();
        }
        if (this.f725e != null && f()) {
            jcVar.a(f);
            jcVar.a(this.f725e);
            jcVar.b();
        }
        if (this.f726f != null && g()) {
            jcVar.a(g);
            jcVar.a(this.f726f);
            jcVar.b();
        }
        if (this.f721a != null && h()) {
            jcVar.a(h);
            jcVar.a(new ja(Constants.GZIP_CAST_TYPE, this.f721a.size()));
            for (String str : this.f721a) {
                jcVar.a(str);
            }
            jcVar.e();
            jcVar.b();
        }
        jcVar.c();
        jcVar.m462a();
    }

    public boolean b() {
        return this.f719a != null;
    }

    public ik c(String str) {
        this.f724d = str;
        return this;
    }

    public boolean c() {
        return this.f722b != null;
    }

    public ik d(String str) {
        this.f725e = str;
        return this;
    }

    public boolean d() {
        return this.f723c != null;
    }

    public ik e(String str) {
        this.f726f = str;
        return this;
    }

    public boolean e() {
        return this.f724d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ik)) {
            return m432a((ik) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f725e != null;
    }

    public boolean g() {
        return this.f726f != null;
    }

    public boolean h() {
        return this.f721a != null;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionSubscription(");
        boolean z2 = true;
        if (m431a()) {
            sb.append("debug:");
            if (this.f720a == null) {
                sb.append("null");
            } else {
                sb.append(this.f720a);
            }
            z2 = false;
        }
        if (b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f719a == null) {
                sb.append("null");
            } else {
                sb.append(this.f719a);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f722b == null) {
            sb.append("null");
        } else {
            sb.append(this.f722b);
        }
        sb.append(", ");
        sb.append("appId:");
        if (this.f723c == null) {
            sb.append("null");
        } else {
            sb.append(this.f723c);
        }
        sb.append(", ");
        sb.append(UrlSchemaHelper.SCHEMA_TYPE_TOPIC);
        if (this.f724d == null) {
            sb.append("null");
        } else {
            sb.append(this.f724d);
        }
        if (f()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f725e == null) {
                sb.append("null");
            } else {
                sb.append(this.f725e);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("category:");
            if (this.f726f == null) {
                sb.append("null");
            } else {
                sb.append(this.f726f);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("aliases:");
            if (this.f721a == null) {
                sb.append("null");
            } else {
                sb.append(this.f721a);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
