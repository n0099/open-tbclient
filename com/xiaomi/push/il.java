package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes5.dex */
public class il implements ir<il, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f728a;

    /* renamed from: a  reason: collision with other field name */
    public hv f729a;

    /* renamed from: a  reason: collision with other field name */
    public String f730a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f731a = new BitSet(1);

    /* renamed from: b  reason: collision with other field name */
    public String f732b;

    /* renamed from: c  reason: collision with other field name */
    public String f733c;

    /* renamed from: d  reason: collision with other field name */
    public String f734d;

    /* renamed from: e  reason: collision with other field name */
    public String f735e;

    /* renamed from: f  reason: collision with other field name */
    public String f736f;

    /* renamed from: g  reason: collision with other field name */
    public String f737g;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f727a = new jh("XmPushActionSubscriptionResult");
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
            int compareTo = Boolean.valueOf(m434a()).compareTo(Boolean.valueOf(ilVar.m434a()));
            if (compareTo == 0) {
                if (!m434a() || (a10 = is.a(this.f730a, ilVar.f730a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m436b()).compareTo(Boolean.valueOf(ilVar.m436b()));
                    if (compareTo2 == 0) {
                        if (!m436b() || (a9 = is.a(this.f729a, ilVar.f729a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(ilVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a8 = is.a(this.f732b, ilVar.f732b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(ilVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a7 = is.a(this.f733c, ilVar.f733c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(ilVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a6 = is.a(this.f728a, ilVar.f728a)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(ilVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a5 = is.a(this.f734d, ilVar.f734d)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ilVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a4 = is.a(this.f735e, ilVar.f735e)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(ilVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a3 = is.a(this.f736f, ilVar.f736f)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(ilVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a2 = is.a(this.f737g, ilVar.f737g)) == 0) {
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
        return this.f735e;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m433a() {
        if (this.f732b == null) {
            throw new jd("Required field 'id' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ir
    public void a(jc jcVar) {
        jcVar.m458a();
        while (true) {
            iz m454a = jcVar.m454a();
            if (m454a.a == 0) {
                jcVar.f();
                m433a();
                return;
            }
            switch (m454a.f793a) {
                case 1:
                    if (m454a.a != 11) {
                        jf.a(jcVar, m454a.a);
                        break;
                    } else {
                        this.f730a = jcVar.m459a();
                        break;
                    }
                case 2:
                    if (m454a.a != 12) {
                        jf.a(jcVar, m454a.a);
                        break;
                    } else {
                        this.f729a = new hv();
                        this.f729a.a(jcVar);
                        break;
                    }
                case 3:
                    if (m454a.a != 11) {
                        jf.a(jcVar, m454a.a);
                        break;
                    } else {
                        this.f732b = jcVar.m459a();
                        break;
                    }
                case 4:
                    if (m454a.a != 11) {
                        jf.a(jcVar, m454a.a);
                        break;
                    } else {
                        this.f733c = jcVar.m459a();
                        break;
                    }
                case 5:
                default:
                    jf.a(jcVar, m454a.a);
                    break;
                case 6:
                    if (m454a.a != 10) {
                        jf.a(jcVar, m454a.a);
                        break;
                    } else {
                        this.f728a = jcVar.m453a();
                        a(true);
                        break;
                    }
                case 7:
                    if (m454a.a != 11) {
                        jf.a(jcVar, m454a.a);
                        break;
                    } else {
                        this.f734d = jcVar.m459a();
                        break;
                    }
                case 8:
                    if (m454a.a != 11) {
                        jf.a(jcVar, m454a.a);
                        break;
                    } else {
                        this.f735e = jcVar.m459a();
                        break;
                    }
                case 9:
                    if (m454a.a != 11) {
                        jf.a(jcVar, m454a.a);
                        break;
                    } else {
                        this.f736f = jcVar.m459a();
                        break;
                    }
                case 10:
                    if (m454a.a != 11) {
                        jf.a(jcVar, m454a.a);
                        break;
                    } else {
                        this.f737g = jcVar.m459a();
                        break;
                    }
            }
            jcVar.g();
        }
    }

    public void a(boolean z) {
        this.f731a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m434a() {
        return this.f730a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m435a(il ilVar) {
        if (ilVar == null) {
            return false;
        }
        boolean m434a = m434a();
        boolean m434a2 = ilVar.m434a();
        if ((m434a || m434a2) && !(m434a && m434a2 && this.f730a.equals(ilVar.f730a))) {
            return false;
        }
        boolean m436b = m436b();
        boolean m436b2 = ilVar.m436b();
        if ((m436b || m436b2) && !(m436b && m436b2 && this.f729a.m364a(ilVar.f729a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = ilVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f732b.equals(ilVar.f732b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = ilVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f733c.equals(ilVar.f733c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = ilVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f728a == ilVar.f728a)) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = ilVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f734d.equals(ilVar.f734d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = ilVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f735e.equals(ilVar.f735e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = ilVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f736f.equals(ilVar.f736f))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = ilVar.i();
        return !(i2 || i3) || (i2 && i3 && this.f737g.equals(ilVar.f737g));
    }

    public String b() {
        return this.f737g;
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        m433a();
        jcVar.a(f727a);
        if (this.f730a != null && m434a()) {
            jcVar.a(a);
            jcVar.a(this.f730a);
            jcVar.b();
        }
        if (this.f729a != null && m436b()) {
            jcVar.a(b);
            this.f729a.b(jcVar);
            jcVar.b();
        }
        if (this.f732b != null) {
            jcVar.a(c);
            jcVar.a(this.f732b);
            jcVar.b();
        }
        if (this.f733c != null && d()) {
            jcVar.a(d);
            jcVar.a(this.f733c);
            jcVar.b();
        }
        if (e()) {
            jcVar.a(e);
            jcVar.a(this.f728a);
            jcVar.b();
        }
        if (this.f734d != null && f()) {
            jcVar.a(f);
            jcVar.a(this.f734d);
            jcVar.b();
        }
        if (this.f735e != null && g()) {
            jcVar.a(g);
            jcVar.a(this.f735e);
            jcVar.b();
        }
        if (this.f736f != null && h()) {
            jcVar.a(h);
            jcVar.a(this.f736f);
            jcVar.b();
        }
        if (this.f737g != null && i()) {
            jcVar.a(i);
            jcVar.a(this.f737g);
            jcVar.b();
        }
        jcVar.c();
        jcVar.m462a();
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m436b() {
        return this.f729a != null;
    }

    public boolean c() {
        return this.f732b != null;
    }

    public boolean d() {
        return this.f733c != null;
    }

    public boolean e() {
        return this.f731a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof il)) {
            return m435a((il) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f734d != null;
    }

    public boolean g() {
        return this.f735e != null;
    }

    public boolean h() {
        return this.f736f != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f737g != null;
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionSubscriptionResult(");
        boolean z2 = true;
        if (m434a()) {
            sb.append("debug:");
            if (this.f730a == null) {
                sb.append("null");
            } else {
                sb.append(this.f730a);
            }
            z2 = false;
        }
        if (m436b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f729a == null) {
                sb.append("null");
            } else {
                sb.append(this.f729a);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f732b == null) {
            sb.append("null");
        } else {
            sb.append(this.f732b);
        }
        if (d()) {
            sb.append(", ");
            sb.append("appId:");
            if (this.f733c == null) {
                sb.append("null");
            } else {
                sb.append(this.f733c);
            }
        }
        if (e()) {
            sb.append(", ");
            sb.append("errorCode:");
            sb.append(this.f728a);
        }
        if (f()) {
            sb.append(", ");
            sb.append("reason:");
            if (this.f734d == null) {
                sb.append("null");
            } else {
                sb.append(this.f734d);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append(UrlSchemaHelper.SCHEMA_TYPE_TOPIC);
            if (this.f735e == null) {
                sb.append("null");
            } else {
                sb.append(this.f735e);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f736f == null) {
                sb.append("null");
            } else {
                sb.append(this.f736f);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("category:");
            if (this.f737g == null) {
                sb.append("null");
            } else {
                sb.append(this.f737g);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
