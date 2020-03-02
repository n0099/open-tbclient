package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes8.dex */
public class il implements ir<il, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f723a;

    /* renamed from: a  reason: collision with other field name */
    public hv f724a;

    /* renamed from: a  reason: collision with other field name */
    public String f725a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f726a = new BitSet(1);

    /* renamed from: b  reason: collision with other field name */
    public String f727b;

    /* renamed from: c  reason: collision with other field name */
    public String f728c;

    /* renamed from: d  reason: collision with other field name */
    public String f729d;

    /* renamed from: e  reason: collision with other field name */
    public String f730e;

    /* renamed from: f  reason: collision with other field name */
    public String f731f;

    /* renamed from: g  reason: collision with other field name */
    public String f732g;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f722a = new jh("XmPushActionSubscriptionResult");
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
                if (!m448a() || (a10 = is.a(this.f725a, ilVar.f725a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m450b()).compareTo(Boolean.valueOf(ilVar.m450b()));
                    if (compareTo2 == 0) {
                        if (!m450b() || (a9 = is.a(this.f724a, ilVar.f724a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(ilVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a8 = is.a(this.f727b, ilVar.f727b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(ilVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a7 = is.a(this.f728c, ilVar.f728c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(ilVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a6 = is.a(this.f723a, ilVar.f723a)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(ilVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a5 = is.a(this.f729d, ilVar.f729d)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ilVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a4 = is.a(this.f730e, ilVar.f730e)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(ilVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a3 = is.a(this.f731f, ilVar.f731f)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(ilVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a2 = is.a(this.f732g, ilVar.f732g)) == 0) {
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
        return this.f730e;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m447a() {
        if (this.f727b == null) {
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
            switch (m468a.f788a) {
                case 1:
                    if (m468a.a != 11) {
                        jf.a(jcVar, m468a.a);
                        break;
                    } else {
                        this.f725a = jcVar.m473a();
                        break;
                    }
                case 2:
                    if (m468a.a != 12) {
                        jf.a(jcVar, m468a.a);
                        break;
                    } else {
                        this.f724a = new hv();
                        this.f724a.a(jcVar);
                        break;
                    }
                case 3:
                    if (m468a.a != 11) {
                        jf.a(jcVar, m468a.a);
                        break;
                    } else {
                        this.f727b = jcVar.m473a();
                        break;
                    }
                case 4:
                    if (m468a.a != 11) {
                        jf.a(jcVar, m468a.a);
                        break;
                    } else {
                        this.f728c = jcVar.m473a();
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
                        this.f723a = jcVar.m467a();
                        a(true);
                        break;
                    }
                case 7:
                    if (m468a.a != 11) {
                        jf.a(jcVar, m468a.a);
                        break;
                    } else {
                        this.f729d = jcVar.m473a();
                        break;
                    }
                case 8:
                    if (m468a.a != 11) {
                        jf.a(jcVar, m468a.a);
                        break;
                    } else {
                        this.f730e = jcVar.m473a();
                        break;
                    }
                case 9:
                    if (m468a.a != 11) {
                        jf.a(jcVar, m468a.a);
                        break;
                    } else {
                        this.f731f = jcVar.m473a();
                        break;
                    }
                case 10:
                    if (m468a.a != 11) {
                        jf.a(jcVar, m468a.a);
                        break;
                    } else {
                        this.f732g = jcVar.m473a();
                        break;
                    }
            }
            jcVar.g();
        }
    }

    public void a(boolean z) {
        this.f726a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m448a() {
        return this.f725a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m449a(il ilVar) {
        if (ilVar == null) {
            return false;
        }
        boolean m448a = m448a();
        boolean m448a2 = ilVar.m448a();
        if ((m448a || m448a2) && !(m448a && m448a2 && this.f725a.equals(ilVar.f725a))) {
            return false;
        }
        boolean m450b = m450b();
        boolean m450b2 = ilVar.m450b();
        if ((m450b || m450b2) && !(m450b && m450b2 && this.f724a.m378a(ilVar.f724a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = ilVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f727b.equals(ilVar.f727b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = ilVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f728c.equals(ilVar.f728c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = ilVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f723a == ilVar.f723a)) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = ilVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f729d.equals(ilVar.f729d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = ilVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f730e.equals(ilVar.f730e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = ilVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f731f.equals(ilVar.f731f))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = ilVar.i();
        return !(i2 || i3) || (i2 && i3 && this.f732g.equals(ilVar.f732g));
    }

    public String b() {
        return this.f732g;
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        m447a();
        jcVar.a(f722a);
        if (this.f725a != null && m448a()) {
            jcVar.a(a);
            jcVar.a(this.f725a);
            jcVar.b();
        }
        if (this.f724a != null && m450b()) {
            jcVar.a(b);
            this.f724a.b(jcVar);
            jcVar.b();
        }
        if (this.f727b != null) {
            jcVar.a(c);
            jcVar.a(this.f727b);
            jcVar.b();
        }
        if (this.f728c != null && d()) {
            jcVar.a(d);
            jcVar.a(this.f728c);
            jcVar.b();
        }
        if (e()) {
            jcVar.a(e);
            jcVar.a(this.f723a);
            jcVar.b();
        }
        if (this.f729d != null && f()) {
            jcVar.a(f);
            jcVar.a(this.f729d);
            jcVar.b();
        }
        if (this.f730e != null && g()) {
            jcVar.a(g);
            jcVar.a(this.f730e);
            jcVar.b();
        }
        if (this.f731f != null && h()) {
            jcVar.a(h);
            jcVar.a(this.f731f);
            jcVar.b();
        }
        if (this.f732g != null && i()) {
            jcVar.a(i);
            jcVar.a(this.f732g);
            jcVar.b();
        }
        jcVar.c();
        jcVar.m476a();
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m450b() {
        return this.f724a != null;
    }

    public boolean c() {
        return this.f727b != null;
    }

    public boolean d() {
        return this.f728c != null;
    }

    public boolean e() {
        return this.f726a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof il)) {
            return m449a((il) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f729d != null;
    }

    public boolean g() {
        return this.f730e != null;
    }

    public boolean h() {
        return this.f731f != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f732g != null;
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionSubscriptionResult(");
        boolean z2 = true;
        if (m448a()) {
            sb.append("debug:");
            if (this.f725a == null) {
                sb.append("null");
            } else {
                sb.append(this.f725a);
            }
            z2 = false;
        }
        if (m450b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f724a == null) {
                sb.append("null");
            } else {
                sb.append(this.f724a);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f727b == null) {
            sb.append("null");
        } else {
            sb.append(this.f727b);
        }
        if (d()) {
            sb.append(", ");
            sb.append("appId:");
            if (this.f728c == null) {
                sb.append("null");
            } else {
                sb.append(this.f728c);
            }
        }
        if (e()) {
            sb.append(", ");
            sb.append("errorCode:");
            sb.append(this.f723a);
        }
        if (f()) {
            sb.append(", ");
            sb.append("reason:");
            if (this.f729d == null) {
                sb.append("null");
            } else {
                sb.append(this.f729d);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append(UrlSchemaHelper.SCHEMA_TYPE_TOPIC);
            if (this.f730e == null) {
                sb.append("null");
            } else {
                sb.append(this.f730e);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f731f == null) {
                sb.append("null");
            } else {
                sb.append(this.f731f);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("category:");
            if (this.f732g == null) {
                sb.append("null");
            } else {
                sb.append(this.f732g);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
