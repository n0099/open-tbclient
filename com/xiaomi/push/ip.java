package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes6.dex */
public class ip implements ir<ip, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f772a;

    /* renamed from: a  reason: collision with other field name */
    public hv f773a;

    /* renamed from: a  reason: collision with other field name */
    public String f774a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f775a = new BitSet(1);

    /* renamed from: b  reason: collision with other field name */
    public String f776b;

    /* renamed from: c  reason: collision with other field name */
    public String f777c;

    /* renamed from: d  reason: collision with other field name */
    public String f778d;

    /* renamed from: e  reason: collision with other field name */
    public String f779e;

    /* renamed from: f  reason: collision with other field name */
    public String f780f;

    /* renamed from: g  reason: collision with other field name */
    public String f781g;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f771a = new jh("XmPushActionUnSubscriptionResult");
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
            int compareTo = Boolean.valueOf(m454a()).compareTo(Boolean.valueOf(ipVar.m454a()));
            if (compareTo == 0) {
                if (!m454a() || (a10 = is.a(this.f774a, ipVar.f774a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m456b()).compareTo(Boolean.valueOf(ipVar.m456b()));
                    if (compareTo2 == 0) {
                        if (!m456b() || (a9 = is.a(this.f773a, ipVar.f773a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(ipVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a8 = is.a(this.f776b, ipVar.f776b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(ipVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a7 = is.a(this.f777c, ipVar.f777c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(ipVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a6 = is.a(this.f772a, ipVar.f772a)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(ipVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a5 = is.a(this.f778d, ipVar.f778d)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ipVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a4 = is.a(this.f779e, ipVar.f779e)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(ipVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a3 = is.a(this.f780f, ipVar.f780f)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(ipVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a2 = is.a(this.f781g, ipVar.f781g)) == 0) {
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
        return this.f779e;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m453a() {
        if (this.f776b == null) {
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
                m453a();
                return;
            }
            switch (m463a.f792a) {
                case 1:
                    if (m463a.a != 11) {
                        jf.a(jcVar, m463a.a);
                        break;
                    } else {
                        this.f774a = jcVar.m468a();
                        break;
                    }
                case 2:
                    if (m463a.a != 12) {
                        jf.a(jcVar, m463a.a);
                        break;
                    } else {
                        this.f773a = new hv();
                        this.f773a.a(jcVar);
                        break;
                    }
                case 3:
                    if (m463a.a != 11) {
                        jf.a(jcVar, m463a.a);
                        break;
                    } else {
                        this.f776b = jcVar.m468a();
                        break;
                    }
                case 4:
                    if (m463a.a != 11) {
                        jf.a(jcVar, m463a.a);
                        break;
                    } else {
                        this.f777c = jcVar.m468a();
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
                        this.f772a = jcVar.m462a();
                        a(true);
                        break;
                    }
                case 7:
                    if (m463a.a != 11) {
                        jf.a(jcVar, m463a.a);
                        break;
                    } else {
                        this.f778d = jcVar.m468a();
                        break;
                    }
                case 8:
                    if (m463a.a != 11) {
                        jf.a(jcVar, m463a.a);
                        break;
                    } else {
                        this.f779e = jcVar.m468a();
                        break;
                    }
                case 9:
                    if (m463a.a != 11) {
                        jf.a(jcVar, m463a.a);
                        break;
                    } else {
                        this.f780f = jcVar.m468a();
                        break;
                    }
                case 10:
                    if (m463a.a != 11) {
                        jf.a(jcVar, m463a.a);
                        break;
                    } else {
                        this.f781g = jcVar.m468a();
                        break;
                    }
            }
            jcVar.g();
        }
    }

    public void a(boolean z) {
        this.f775a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m454a() {
        return this.f774a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m455a(ip ipVar) {
        if (ipVar == null) {
            return false;
        }
        boolean m454a = m454a();
        boolean m454a2 = ipVar.m454a();
        if ((m454a || m454a2) && !(m454a && m454a2 && this.f774a.equals(ipVar.f774a))) {
            return false;
        }
        boolean m456b = m456b();
        boolean m456b2 = ipVar.m456b();
        if ((m456b || m456b2) && !(m456b && m456b2 && this.f773a.m373a(ipVar.f773a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = ipVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f776b.equals(ipVar.f776b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = ipVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f777c.equals(ipVar.f777c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = ipVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f772a == ipVar.f772a)) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = ipVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f778d.equals(ipVar.f778d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = ipVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f779e.equals(ipVar.f779e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = ipVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f780f.equals(ipVar.f780f))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = ipVar.i();
        return !(i2 || i3) || (i2 && i3 && this.f781g.equals(ipVar.f781g));
    }

    public String b() {
        return this.f781g;
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        m453a();
        jcVar.a(f771a);
        if (this.f774a != null && m454a()) {
            jcVar.a(a);
            jcVar.a(this.f774a);
            jcVar.b();
        }
        if (this.f773a != null && m456b()) {
            jcVar.a(b);
            this.f773a.b(jcVar);
            jcVar.b();
        }
        if (this.f776b != null) {
            jcVar.a(c);
            jcVar.a(this.f776b);
            jcVar.b();
        }
        if (this.f777c != null && d()) {
            jcVar.a(d);
            jcVar.a(this.f777c);
            jcVar.b();
        }
        if (e()) {
            jcVar.a(e);
            jcVar.a(this.f772a);
            jcVar.b();
        }
        if (this.f778d != null && f()) {
            jcVar.a(f);
            jcVar.a(this.f778d);
            jcVar.b();
        }
        if (this.f779e != null && g()) {
            jcVar.a(g);
            jcVar.a(this.f779e);
            jcVar.b();
        }
        if (this.f780f != null && h()) {
            jcVar.a(h);
            jcVar.a(this.f780f);
            jcVar.b();
        }
        if (this.f781g != null && i()) {
            jcVar.a(i);
            jcVar.a(this.f781g);
            jcVar.b();
        }
        jcVar.c();
        jcVar.m471a();
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m456b() {
        return this.f773a != null;
    }

    public boolean c() {
        return this.f776b != null;
    }

    public boolean d() {
        return this.f777c != null;
    }

    public boolean e() {
        return this.f775a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ip)) {
            return m455a((ip) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f778d != null;
    }

    public boolean g() {
        return this.f779e != null;
    }

    public boolean h() {
        return this.f780f != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f781g != null;
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionUnSubscriptionResult(");
        boolean z2 = true;
        if (m454a()) {
            sb.append("debug:");
            if (this.f774a == null) {
                sb.append("null");
            } else {
                sb.append(this.f774a);
            }
            z2 = false;
        }
        if (m456b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f773a == null) {
                sb.append("null");
            } else {
                sb.append(this.f773a);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f776b == null) {
            sb.append("null");
        } else {
            sb.append(this.f776b);
        }
        if (d()) {
            sb.append(", ");
            sb.append("appId:");
            if (this.f777c == null) {
                sb.append("null");
            } else {
                sb.append(this.f777c);
            }
        }
        if (e()) {
            sb.append(", ");
            sb.append("errorCode:");
            sb.append(this.f772a);
        }
        if (f()) {
            sb.append(", ");
            sb.append("reason:");
            if (this.f778d == null) {
                sb.append("null");
            } else {
                sb.append(this.f778d);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append(UrlSchemaHelper.SCHEMA_TYPE_TOPIC);
            if (this.f779e == null) {
                sb.append("null");
            } else {
                sb.append(this.f779e);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f780f == null) {
                sb.append("null");
            } else {
                sb.append(this.f780f);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("category:");
            if (this.f781g == null) {
                sb.append("null");
            } else {
                sb.append(this.f781g);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
