package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes8.dex */
public class il implements ir<il, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f724a;

    /* renamed from: a  reason: collision with other field name */
    public hv f725a;

    /* renamed from: a  reason: collision with other field name */
    public String f726a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f727a = new BitSet(1);

    /* renamed from: b  reason: collision with other field name */
    public String f728b;

    /* renamed from: c  reason: collision with other field name */
    public String f729c;

    /* renamed from: d  reason: collision with other field name */
    public String f730d;

    /* renamed from: e  reason: collision with other field name */
    public String f731e;

    /* renamed from: f  reason: collision with other field name */
    public String f732f;

    /* renamed from: g  reason: collision with other field name */
    public String f733g;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f723a = new jh("XmPushActionSubscriptionResult");
    private static final iz a = new iz("", Constants.GZIP_CAST_TYPE, 1);
    private static final iz b = new iz("", (byte) 12, 2);
    private static final iz c = new iz("", Constants.GZIP_CAST_TYPE, 3);
    private static final iz d = new iz("", Constants.GZIP_CAST_TYPE, 4);
    private static final iz e = new iz("", (byte) 10, 6);
    private static final iz f = new iz("", Constants.GZIP_CAST_TYPE, 7);
    private static final iz g = new iz("", Constants.GZIP_CAST_TYPE, 8);
    private static final iz h = new iz("", Constants.GZIP_CAST_TYPE, 9);
    private static final iz i = new iz("", Constants.GZIP_CAST_TYPE, 10);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(il ilVar) {
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        int a8;
        int a9;
        int a10;
        if (getClass().equals(ilVar.getClass())) {
            int compareTo = Boolean.valueOf(m448a()).compareTo(Boolean.valueOf(ilVar.m448a()));
            if (compareTo == 0) {
                if (!m448a() || (a10 = is.a(this.f726a, ilVar.f726a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m450b()).compareTo(Boolean.valueOf(ilVar.m450b()));
                    if (compareTo2 == 0) {
                        if (!m450b() || (a9 = is.a(this.f725a, ilVar.f725a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(ilVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a8 = is.a(this.f728b, ilVar.f728b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(ilVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a7 = is.a(this.f729c, ilVar.f729c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(ilVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a6 = is.a(this.f724a, ilVar.f724a)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(ilVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a5 = is.a(this.f730d, ilVar.f730d)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ilVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a4 = is.a(this.f731e, ilVar.f731e)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(ilVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a3 = is.a(this.f732f, ilVar.f732f)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(ilVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a2 = is.a(this.f733g, ilVar.f733g)) == 0) {
                                                                                    return 0;
                                                                                }
                                                                                return a2;
                                                                            }
                                                                            return compareTo9;
                                                                        }
                                                                        return a3;
                                                                    }
                                                                    return compareTo8;
                                                                }
                                                                return a4;
                                                            }
                                                            return compareTo7;
                                                        }
                                                        return a5;
                                                    }
                                                    return compareTo6;
                                                }
                                                return a6;
                                            }
                                            return compareTo5;
                                        }
                                        return a7;
                                    }
                                    return compareTo4;
                                }
                                return a8;
                            }
                            return compareTo3;
                        }
                        return a9;
                    }
                    return compareTo2;
                }
                return a10;
            }
            return compareTo;
        }
        return getClass().getName().compareTo(ilVar.getClass().getName());
    }

    public String a() {
        return this.f731e;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m447a() {
        if (this.f728b == null) {
            throw new jd("Required field 'id' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ir
    public void a(jc jcVar) {
        jcVar.m472a();
        while (true) {
            iz m468a = jcVar.m468a();
            if (m468a.a == 0) {
                jcVar.f();
                m447a();
                return;
            }
            switch (m468a.f789a) {
                case 1:
                    if (m468a.a != 11) {
                        jf.a(jcVar, m468a.a);
                        break;
                    } else {
                        this.f726a = jcVar.m473a();
                        break;
                    }
                case 2:
                    if (m468a.a != 12) {
                        jf.a(jcVar, m468a.a);
                        break;
                    } else {
                        this.f725a = new hv();
                        this.f725a.a(jcVar);
                        break;
                    }
                case 3:
                    if (m468a.a != 11) {
                        jf.a(jcVar, m468a.a);
                        break;
                    } else {
                        this.f728b = jcVar.m473a();
                        break;
                    }
                case 4:
                    if (m468a.a != 11) {
                        jf.a(jcVar, m468a.a);
                        break;
                    } else {
                        this.f729c = jcVar.m473a();
                        break;
                    }
                case 5:
                default:
                    jf.a(jcVar, m468a.a);
                    break;
                case 6:
                    if (m468a.a != 10) {
                        jf.a(jcVar, m468a.a);
                        break;
                    } else {
                        this.f724a = jcVar.m467a();
                        a(true);
                        break;
                    }
                case 7:
                    if (m468a.a != 11) {
                        jf.a(jcVar, m468a.a);
                        break;
                    } else {
                        this.f730d = jcVar.m473a();
                        break;
                    }
                case 8:
                    if (m468a.a != 11) {
                        jf.a(jcVar, m468a.a);
                        break;
                    } else {
                        this.f731e = jcVar.m473a();
                        break;
                    }
                case 9:
                    if (m468a.a != 11) {
                        jf.a(jcVar, m468a.a);
                        break;
                    } else {
                        this.f732f = jcVar.m473a();
                        break;
                    }
                case 10:
                    if (m468a.a != 11) {
                        jf.a(jcVar, m468a.a);
                        break;
                    } else {
                        this.f733g = jcVar.m473a();
                        break;
                    }
            }
            jcVar.g();
        }
    }

    public void a(boolean z) {
        this.f727a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m448a() {
        return this.f726a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m449a(il ilVar) {
        if (ilVar == null) {
            return false;
        }
        boolean m448a = m448a();
        boolean m448a2 = ilVar.m448a();
        if ((m448a || m448a2) && !(m448a && m448a2 && this.f726a.equals(ilVar.f726a))) {
            return false;
        }
        boolean m450b = m450b();
        boolean m450b2 = ilVar.m450b();
        if ((m450b || m450b2) && !(m450b && m450b2 && this.f725a.m378a(ilVar.f725a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = ilVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f728b.equals(ilVar.f728b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = ilVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f729c.equals(ilVar.f729c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = ilVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f724a == ilVar.f724a)) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = ilVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f730d.equals(ilVar.f730d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = ilVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f731e.equals(ilVar.f731e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = ilVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f732f.equals(ilVar.f732f))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = ilVar.i();
        return !(i2 || i3) || (i2 && i3 && this.f733g.equals(ilVar.f733g));
    }

    public String b() {
        return this.f733g;
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        m447a();
        jcVar.a(f723a);
        if (this.f726a != null && m448a()) {
            jcVar.a(a);
            jcVar.a(this.f726a);
            jcVar.b();
        }
        if (this.f725a != null && m450b()) {
            jcVar.a(b);
            this.f725a.b(jcVar);
            jcVar.b();
        }
        if (this.f728b != null) {
            jcVar.a(c);
            jcVar.a(this.f728b);
            jcVar.b();
        }
        if (this.f729c != null && d()) {
            jcVar.a(d);
            jcVar.a(this.f729c);
            jcVar.b();
        }
        if (e()) {
            jcVar.a(e);
            jcVar.a(this.f724a);
            jcVar.b();
        }
        if (this.f730d != null && f()) {
            jcVar.a(f);
            jcVar.a(this.f730d);
            jcVar.b();
        }
        if (this.f731e != null && g()) {
            jcVar.a(g);
            jcVar.a(this.f731e);
            jcVar.b();
        }
        if (this.f732f != null && h()) {
            jcVar.a(h);
            jcVar.a(this.f732f);
            jcVar.b();
        }
        if (this.f733g != null && i()) {
            jcVar.a(i);
            jcVar.a(this.f733g);
            jcVar.b();
        }
        jcVar.c();
        jcVar.m476a();
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m450b() {
        return this.f725a != null;
    }

    public boolean c() {
        return this.f728b != null;
    }

    public boolean d() {
        return this.f729c != null;
    }

    public boolean e() {
        return this.f727a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof il)) {
            return m449a((il) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f730d != null;
    }

    public boolean g() {
        return this.f731e != null;
    }

    public boolean h() {
        return this.f732f != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f733g != null;
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionSubscriptionResult(");
        boolean z2 = true;
        if (m448a()) {
            sb.append("debug:");
            if (this.f726a == null) {
                sb.append("null");
            } else {
                sb.append(this.f726a);
            }
            z2 = false;
        }
        if (m450b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f725a == null) {
                sb.append("null");
            } else {
                sb.append(this.f725a);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f728b == null) {
            sb.append("null");
        } else {
            sb.append(this.f728b);
        }
        if (d()) {
            sb.append(", ");
            sb.append("appId:");
            if (this.f729c == null) {
                sb.append("null");
            } else {
                sb.append(this.f729c);
            }
        }
        if (e()) {
            sb.append(", ");
            sb.append("errorCode:");
            sb.append(this.f724a);
        }
        if (f()) {
            sb.append(", ");
            sb.append("reason:");
            if (this.f730d == null) {
                sb.append("null");
            } else {
                sb.append(this.f730d);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append(UrlSchemaHelper.SCHEMA_TYPE_TOPIC);
            if (this.f731e == null) {
                sb.append("null");
            } else {
                sb.append(this.f731e);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f732f == null) {
                sb.append("null");
            } else {
                sb.append(this.f732f);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("category:");
            if (this.f733g == null) {
                sb.append("null");
            } else {
                sb.append(this.f733g);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
