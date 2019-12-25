package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes5.dex */
public class ip implements ir<ip, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f773a;

    /* renamed from: a  reason: collision with other field name */
    public hv f774a;

    /* renamed from: a  reason: collision with other field name */
    public String f775a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f776a = new BitSet(1);

    /* renamed from: b  reason: collision with other field name */
    public String f777b;

    /* renamed from: c  reason: collision with other field name */
    public String f778c;

    /* renamed from: d  reason: collision with other field name */
    public String f779d;

    /* renamed from: e  reason: collision with other field name */
    public String f780e;

    /* renamed from: f  reason: collision with other field name */
    public String f781f;

    /* renamed from: g  reason: collision with other field name */
    public String f782g;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f772a = new jh("XmPushActionUnSubscriptionResult");
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
    public int compareTo(ip ipVar) {
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        int a8;
        int a9;
        int a10;
        if (getClass().equals(ipVar.getClass())) {
            int compareTo = Boolean.valueOf(m445a()).compareTo(Boolean.valueOf(ipVar.m445a()));
            if (compareTo == 0) {
                if (!m445a() || (a10 = is.a(this.f775a, ipVar.f775a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m447b()).compareTo(Boolean.valueOf(ipVar.m447b()));
                    if (compareTo2 == 0) {
                        if (!m447b() || (a9 = is.a(this.f774a, ipVar.f774a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(ipVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a8 = is.a(this.f777b, ipVar.f777b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(ipVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a7 = is.a(this.f778c, ipVar.f778c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(ipVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a6 = is.a(this.f773a, ipVar.f773a)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(ipVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a5 = is.a(this.f779d, ipVar.f779d)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ipVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a4 = is.a(this.f780e, ipVar.f780e)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(ipVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a3 = is.a(this.f781f, ipVar.f781f)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(ipVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a2 = is.a(this.f782g, ipVar.f782g)) == 0) {
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
        return getClass().getName().compareTo(ipVar.getClass().getName());
    }

    public String a() {
        return this.f780e;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m444a() {
        if (this.f777b == null) {
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
                m444a();
                return;
            }
            switch (m454a.f793a) {
                case 1:
                    if (m454a.a != 11) {
                        jf.a(jcVar, m454a.a);
                        break;
                    } else {
                        this.f775a = jcVar.m459a();
                        break;
                    }
                case 2:
                    if (m454a.a != 12) {
                        jf.a(jcVar, m454a.a);
                        break;
                    } else {
                        this.f774a = new hv();
                        this.f774a.a(jcVar);
                        break;
                    }
                case 3:
                    if (m454a.a != 11) {
                        jf.a(jcVar, m454a.a);
                        break;
                    } else {
                        this.f777b = jcVar.m459a();
                        break;
                    }
                case 4:
                    if (m454a.a != 11) {
                        jf.a(jcVar, m454a.a);
                        break;
                    } else {
                        this.f778c = jcVar.m459a();
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
                        this.f773a = jcVar.m453a();
                        a(true);
                        break;
                    }
                case 7:
                    if (m454a.a != 11) {
                        jf.a(jcVar, m454a.a);
                        break;
                    } else {
                        this.f779d = jcVar.m459a();
                        break;
                    }
                case 8:
                    if (m454a.a != 11) {
                        jf.a(jcVar, m454a.a);
                        break;
                    } else {
                        this.f780e = jcVar.m459a();
                        break;
                    }
                case 9:
                    if (m454a.a != 11) {
                        jf.a(jcVar, m454a.a);
                        break;
                    } else {
                        this.f781f = jcVar.m459a();
                        break;
                    }
                case 10:
                    if (m454a.a != 11) {
                        jf.a(jcVar, m454a.a);
                        break;
                    } else {
                        this.f782g = jcVar.m459a();
                        break;
                    }
            }
            jcVar.g();
        }
    }

    public void a(boolean z) {
        this.f776a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m445a() {
        return this.f775a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m446a(ip ipVar) {
        if (ipVar == null) {
            return false;
        }
        boolean m445a = m445a();
        boolean m445a2 = ipVar.m445a();
        if ((m445a || m445a2) && !(m445a && m445a2 && this.f775a.equals(ipVar.f775a))) {
            return false;
        }
        boolean m447b = m447b();
        boolean m447b2 = ipVar.m447b();
        if ((m447b || m447b2) && !(m447b && m447b2 && this.f774a.m364a(ipVar.f774a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = ipVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f777b.equals(ipVar.f777b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = ipVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f778c.equals(ipVar.f778c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = ipVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f773a == ipVar.f773a)) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = ipVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f779d.equals(ipVar.f779d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = ipVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f780e.equals(ipVar.f780e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = ipVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f781f.equals(ipVar.f781f))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = ipVar.i();
        return !(i2 || i3) || (i2 && i3 && this.f782g.equals(ipVar.f782g));
    }

    public String b() {
        return this.f782g;
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        m444a();
        jcVar.a(f772a);
        if (this.f775a != null && m445a()) {
            jcVar.a(a);
            jcVar.a(this.f775a);
            jcVar.b();
        }
        if (this.f774a != null && m447b()) {
            jcVar.a(b);
            this.f774a.b(jcVar);
            jcVar.b();
        }
        if (this.f777b != null) {
            jcVar.a(c);
            jcVar.a(this.f777b);
            jcVar.b();
        }
        if (this.f778c != null && d()) {
            jcVar.a(d);
            jcVar.a(this.f778c);
            jcVar.b();
        }
        if (e()) {
            jcVar.a(e);
            jcVar.a(this.f773a);
            jcVar.b();
        }
        if (this.f779d != null && f()) {
            jcVar.a(f);
            jcVar.a(this.f779d);
            jcVar.b();
        }
        if (this.f780e != null && g()) {
            jcVar.a(g);
            jcVar.a(this.f780e);
            jcVar.b();
        }
        if (this.f781f != null && h()) {
            jcVar.a(h);
            jcVar.a(this.f781f);
            jcVar.b();
        }
        if (this.f782g != null && i()) {
            jcVar.a(i);
            jcVar.a(this.f782g);
            jcVar.b();
        }
        jcVar.c();
        jcVar.m462a();
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m447b() {
        return this.f774a != null;
    }

    public boolean c() {
        return this.f777b != null;
    }

    public boolean d() {
        return this.f778c != null;
    }

    public boolean e() {
        return this.f776a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ip)) {
            return m446a((ip) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f779d != null;
    }

    public boolean g() {
        return this.f780e != null;
    }

    public boolean h() {
        return this.f781f != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f782g != null;
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionUnSubscriptionResult(");
        boolean z2 = true;
        if (m445a()) {
            sb.append("debug:");
            if (this.f775a == null) {
                sb.append("null");
            } else {
                sb.append(this.f775a);
            }
            z2 = false;
        }
        if (m447b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f774a == null) {
                sb.append("null");
            } else {
                sb.append(this.f774a);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f777b == null) {
            sb.append("null");
        } else {
            sb.append(this.f777b);
        }
        if (d()) {
            sb.append(", ");
            sb.append("appId:");
            if (this.f778c == null) {
                sb.append("null");
            } else {
                sb.append(this.f778c);
            }
        }
        if (e()) {
            sb.append(", ");
            sb.append("errorCode:");
            sb.append(this.f773a);
        }
        if (f()) {
            sb.append(", ");
            sb.append("reason:");
            if (this.f779d == null) {
                sb.append("null");
            } else {
                sb.append(this.f779d);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append(UrlSchemaHelper.SCHEMA_TYPE_TOPIC);
            if (this.f780e == null) {
                sb.append("null");
            } else {
                sb.append(this.f780e);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f781f == null) {
                sb.append("null");
            } else {
                sb.append(this.f781f);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("category:");
            if (this.f782g == null) {
                sb.append("null");
            } else {
                sb.append(this.f782g);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
