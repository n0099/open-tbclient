package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes6.dex */
public class il implements ir<il, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f726a;

    /* renamed from: a  reason: collision with other field name */
    public hv f727a;

    /* renamed from: a  reason: collision with other field name */
    public String f728a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f729a = new BitSet(1);

    /* renamed from: b  reason: collision with other field name */
    public String f730b;

    /* renamed from: c  reason: collision with other field name */
    public String f731c;

    /* renamed from: d  reason: collision with other field name */
    public String f732d;

    /* renamed from: e  reason: collision with other field name */
    public String f733e;

    /* renamed from: f  reason: collision with other field name */
    public String f734f;

    /* renamed from: g  reason: collision with other field name */
    public String f735g;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f725a = new jh("XmPushActionSubscriptionResult");
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
                if (!m443a() || (a10 = is.a(this.f728a, ilVar.f728a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m445b()).compareTo(Boolean.valueOf(ilVar.m445b()));
                    if (compareTo2 == 0) {
                        if (!m445b() || (a9 = is.a(this.f727a, ilVar.f727a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(ilVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a8 = is.a(this.f730b, ilVar.f730b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(ilVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a7 = is.a(this.f731c, ilVar.f731c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(ilVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a6 = is.a(this.f726a, ilVar.f726a)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(ilVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a5 = is.a(this.f732d, ilVar.f732d)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ilVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a4 = is.a(this.f733e, ilVar.f733e)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(ilVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a3 = is.a(this.f734f, ilVar.f734f)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(ilVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a2 = is.a(this.f735g, ilVar.f735g)) == 0) {
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
        return this.f733e;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m442a() {
        if (this.f730b == null) {
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
            switch (m463a.f791a) {
                case 1:
                    if (m463a.a != 11) {
                        jf.a(jcVar, m463a.a);
                        break;
                    } else {
                        this.f728a = jcVar.m468a();
                        break;
                    }
                case 2:
                    if (m463a.a != 12) {
                        jf.a(jcVar, m463a.a);
                        break;
                    } else {
                        this.f727a = new hv();
                        this.f727a.a(jcVar);
                        break;
                    }
                case 3:
                    if (m463a.a != 11) {
                        jf.a(jcVar, m463a.a);
                        break;
                    } else {
                        this.f730b = jcVar.m468a();
                        break;
                    }
                case 4:
                    if (m463a.a != 11) {
                        jf.a(jcVar, m463a.a);
                        break;
                    } else {
                        this.f731c = jcVar.m468a();
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
                        this.f726a = jcVar.m462a();
                        a(true);
                        break;
                    }
                case 7:
                    if (m463a.a != 11) {
                        jf.a(jcVar, m463a.a);
                        break;
                    } else {
                        this.f732d = jcVar.m468a();
                        break;
                    }
                case 8:
                    if (m463a.a != 11) {
                        jf.a(jcVar, m463a.a);
                        break;
                    } else {
                        this.f733e = jcVar.m468a();
                        break;
                    }
                case 9:
                    if (m463a.a != 11) {
                        jf.a(jcVar, m463a.a);
                        break;
                    } else {
                        this.f734f = jcVar.m468a();
                        break;
                    }
                case 10:
                    if (m463a.a != 11) {
                        jf.a(jcVar, m463a.a);
                        break;
                    } else {
                        this.f735g = jcVar.m468a();
                        break;
                    }
            }
            jcVar.g();
        }
    }

    public void a(boolean z) {
        this.f729a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m443a() {
        return this.f728a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m444a(il ilVar) {
        if (ilVar == null) {
            return false;
        }
        boolean m443a = m443a();
        boolean m443a2 = ilVar.m443a();
        if ((m443a || m443a2) && !(m443a && m443a2 && this.f728a.equals(ilVar.f728a))) {
            return false;
        }
        boolean m445b = m445b();
        boolean m445b2 = ilVar.m445b();
        if ((m445b || m445b2) && !(m445b && m445b2 && this.f727a.m373a(ilVar.f727a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = ilVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f730b.equals(ilVar.f730b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = ilVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f731c.equals(ilVar.f731c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = ilVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f726a == ilVar.f726a)) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = ilVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f732d.equals(ilVar.f732d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = ilVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f733e.equals(ilVar.f733e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = ilVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f734f.equals(ilVar.f734f))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = ilVar.i();
        return !(i2 || i3) || (i2 && i3 && this.f735g.equals(ilVar.f735g));
    }

    public String b() {
        return this.f735g;
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        m442a();
        jcVar.a(f725a);
        if (this.f728a != null && m443a()) {
            jcVar.a(a);
            jcVar.a(this.f728a);
            jcVar.b();
        }
        if (this.f727a != null && m445b()) {
            jcVar.a(b);
            this.f727a.b(jcVar);
            jcVar.b();
        }
        if (this.f730b != null) {
            jcVar.a(c);
            jcVar.a(this.f730b);
            jcVar.b();
        }
        if (this.f731c != null && d()) {
            jcVar.a(d);
            jcVar.a(this.f731c);
            jcVar.b();
        }
        if (e()) {
            jcVar.a(e);
            jcVar.a(this.f726a);
            jcVar.b();
        }
        if (this.f732d != null && f()) {
            jcVar.a(f);
            jcVar.a(this.f732d);
            jcVar.b();
        }
        if (this.f733e != null && g()) {
            jcVar.a(g);
            jcVar.a(this.f733e);
            jcVar.b();
        }
        if (this.f734f != null && h()) {
            jcVar.a(h);
            jcVar.a(this.f734f);
            jcVar.b();
        }
        if (this.f735g != null && i()) {
            jcVar.a(i);
            jcVar.a(this.f735g);
            jcVar.b();
        }
        jcVar.c();
        jcVar.m471a();
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m445b() {
        return this.f727a != null;
    }

    public boolean c() {
        return this.f730b != null;
    }

    public boolean d() {
        return this.f731c != null;
    }

    public boolean e() {
        return this.f729a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof il)) {
            return m444a((il) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f732d != null;
    }

    public boolean g() {
        return this.f733e != null;
    }

    public boolean h() {
        return this.f734f != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f735g != null;
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionSubscriptionResult(");
        boolean z2 = true;
        if (m443a()) {
            sb.append("debug:");
            if (this.f728a == null) {
                sb.append("null");
            } else {
                sb.append(this.f728a);
            }
            z2 = false;
        }
        if (m445b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f727a == null) {
                sb.append("null");
            } else {
                sb.append(this.f727a);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f730b == null) {
            sb.append("null");
        } else {
            sb.append(this.f730b);
        }
        if (d()) {
            sb.append(", ");
            sb.append("appId:");
            if (this.f731c == null) {
                sb.append("null");
            } else {
                sb.append(this.f731c);
            }
        }
        if (e()) {
            sb.append(", ");
            sb.append("errorCode:");
            sb.append(this.f726a);
        }
        if (f()) {
            sb.append(", ");
            sb.append("reason:");
            if (this.f732d == null) {
                sb.append("null");
            } else {
                sb.append(this.f732d);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append(UrlSchemaHelper.SCHEMA_TYPE_TOPIC);
            if (this.f733e == null) {
                sb.append("null");
            } else {
                sb.append(this.f733e);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f734f == null) {
                sb.append("null");
            } else {
                sb.append(this.f734f);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("category:");
            if (this.f735g == null) {
                sb.append("null");
            } else {
                sb.append(this.f735g);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
