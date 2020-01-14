package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes6.dex */
public class il implements ir<il, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f727a;

    /* renamed from: a  reason: collision with other field name */
    public hv f728a;

    /* renamed from: a  reason: collision with other field name */
    public String f729a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f730a = new BitSet(1);

    /* renamed from: b  reason: collision with other field name */
    public String f731b;

    /* renamed from: c  reason: collision with other field name */
    public String f732c;

    /* renamed from: d  reason: collision with other field name */
    public String f733d;

    /* renamed from: e  reason: collision with other field name */
    public String f734e;

    /* renamed from: f  reason: collision with other field name */
    public String f735f;

    /* renamed from: g  reason: collision with other field name */
    public String f736g;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f726a = new jh("XmPushActionSubscriptionResult");
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
            int compareTo = Boolean.valueOf(m443a()).compareTo(Boolean.valueOf(ilVar.m443a()));
            if (compareTo == 0) {
                if (!m443a() || (a10 = is.a(this.f729a, ilVar.f729a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m445b()).compareTo(Boolean.valueOf(ilVar.m445b()));
                    if (compareTo2 == 0) {
                        if (!m445b() || (a9 = is.a(this.f728a, ilVar.f728a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(ilVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a8 = is.a(this.f731b, ilVar.f731b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(ilVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a7 = is.a(this.f732c, ilVar.f732c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(ilVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a6 = is.a(this.f727a, ilVar.f727a)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(ilVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a5 = is.a(this.f733d, ilVar.f733d)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ilVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a4 = is.a(this.f734e, ilVar.f734e)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(ilVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a3 = is.a(this.f735f, ilVar.f735f)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(ilVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a2 = is.a(this.f736g, ilVar.f736g)) == 0) {
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
        return this.f734e;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m442a() {
        if (this.f731b == null) {
            throw new jd("Required field 'id' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ir
    public void a(jc jcVar) {
        jcVar.m467a();
        while (true) {
            iz m463a = jcVar.m463a();
            if (m463a.a == 0) {
                jcVar.f();
                m442a();
                return;
            }
            switch (m463a.f792a) {
                case 1:
                    if (m463a.a != 11) {
                        jf.a(jcVar, m463a.a);
                        break;
                    } else {
                        this.f729a = jcVar.m468a();
                        break;
                    }
                case 2:
                    if (m463a.a != 12) {
                        jf.a(jcVar, m463a.a);
                        break;
                    } else {
                        this.f728a = new hv();
                        this.f728a.a(jcVar);
                        break;
                    }
                case 3:
                    if (m463a.a != 11) {
                        jf.a(jcVar, m463a.a);
                        break;
                    } else {
                        this.f731b = jcVar.m468a();
                        break;
                    }
                case 4:
                    if (m463a.a != 11) {
                        jf.a(jcVar, m463a.a);
                        break;
                    } else {
                        this.f732c = jcVar.m468a();
                        break;
                    }
                case 5:
                default:
                    jf.a(jcVar, m463a.a);
                    break;
                case 6:
                    if (m463a.a != 10) {
                        jf.a(jcVar, m463a.a);
                        break;
                    } else {
                        this.f727a = jcVar.m462a();
                        a(true);
                        break;
                    }
                case 7:
                    if (m463a.a != 11) {
                        jf.a(jcVar, m463a.a);
                        break;
                    } else {
                        this.f733d = jcVar.m468a();
                        break;
                    }
                case 8:
                    if (m463a.a != 11) {
                        jf.a(jcVar, m463a.a);
                        break;
                    } else {
                        this.f734e = jcVar.m468a();
                        break;
                    }
                case 9:
                    if (m463a.a != 11) {
                        jf.a(jcVar, m463a.a);
                        break;
                    } else {
                        this.f735f = jcVar.m468a();
                        break;
                    }
                case 10:
                    if (m463a.a != 11) {
                        jf.a(jcVar, m463a.a);
                        break;
                    } else {
                        this.f736g = jcVar.m468a();
                        break;
                    }
            }
            jcVar.g();
        }
    }

    public void a(boolean z) {
        this.f730a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m443a() {
        return this.f729a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m444a(il ilVar) {
        if (ilVar == null) {
            return false;
        }
        boolean m443a = m443a();
        boolean m443a2 = ilVar.m443a();
        if ((m443a || m443a2) && !(m443a && m443a2 && this.f729a.equals(ilVar.f729a))) {
            return false;
        }
        boolean m445b = m445b();
        boolean m445b2 = ilVar.m445b();
        if ((m445b || m445b2) && !(m445b && m445b2 && this.f728a.m373a(ilVar.f728a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = ilVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f731b.equals(ilVar.f731b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = ilVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f732c.equals(ilVar.f732c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = ilVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f727a == ilVar.f727a)) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = ilVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f733d.equals(ilVar.f733d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = ilVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f734e.equals(ilVar.f734e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = ilVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f735f.equals(ilVar.f735f))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = ilVar.i();
        return !(i2 || i3) || (i2 && i3 && this.f736g.equals(ilVar.f736g));
    }

    public String b() {
        return this.f736g;
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        m442a();
        jcVar.a(f726a);
        if (this.f729a != null && m443a()) {
            jcVar.a(a);
            jcVar.a(this.f729a);
            jcVar.b();
        }
        if (this.f728a != null && m445b()) {
            jcVar.a(b);
            this.f728a.b(jcVar);
            jcVar.b();
        }
        if (this.f731b != null) {
            jcVar.a(c);
            jcVar.a(this.f731b);
            jcVar.b();
        }
        if (this.f732c != null && d()) {
            jcVar.a(d);
            jcVar.a(this.f732c);
            jcVar.b();
        }
        if (e()) {
            jcVar.a(e);
            jcVar.a(this.f727a);
            jcVar.b();
        }
        if (this.f733d != null && f()) {
            jcVar.a(f);
            jcVar.a(this.f733d);
            jcVar.b();
        }
        if (this.f734e != null && g()) {
            jcVar.a(g);
            jcVar.a(this.f734e);
            jcVar.b();
        }
        if (this.f735f != null && h()) {
            jcVar.a(h);
            jcVar.a(this.f735f);
            jcVar.b();
        }
        if (this.f736g != null && i()) {
            jcVar.a(i);
            jcVar.a(this.f736g);
            jcVar.b();
        }
        jcVar.c();
        jcVar.m471a();
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m445b() {
        return this.f728a != null;
    }

    public boolean c() {
        return this.f731b != null;
    }

    public boolean d() {
        return this.f732c != null;
    }

    public boolean e() {
        return this.f730a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof il)) {
            return m444a((il) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f733d != null;
    }

    public boolean g() {
        return this.f734e != null;
    }

    public boolean h() {
        return this.f735f != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f736g != null;
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionSubscriptionResult(");
        boolean z2 = true;
        if (m443a()) {
            sb.append("debug:");
            if (this.f729a == null) {
                sb.append("null");
            } else {
                sb.append(this.f729a);
            }
            z2 = false;
        }
        if (m445b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f728a == null) {
                sb.append("null");
            } else {
                sb.append(this.f728a);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f731b == null) {
            sb.append("null");
        } else {
            sb.append(this.f731b);
        }
        if (d()) {
            sb.append(", ");
            sb.append("appId:");
            if (this.f732c == null) {
                sb.append("null");
            } else {
                sb.append(this.f732c);
            }
        }
        if (e()) {
            sb.append(", ");
            sb.append("errorCode:");
            sb.append(this.f727a);
        }
        if (f()) {
            sb.append(", ");
            sb.append("reason:");
            if (this.f733d == null) {
                sb.append("null");
            } else {
                sb.append(this.f733d);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append(UrlSchemaHelper.SCHEMA_TYPE_TOPIC);
            if (this.f734e == null) {
                sb.append("null");
            } else {
                sb.append(this.f734e);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f735f == null) {
                sb.append("null");
            } else {
                sb.append(this.f735f);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("category:");
            if (this.f736g == null) {
                sb.append("null");
            } else {
                sb.append(this.f736g);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
