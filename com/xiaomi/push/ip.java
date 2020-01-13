package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes6.dex */
public class ip implements ir<ip, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f771a;

    /* renamed from: a  reason: collision with other field name */
    public hv f772a;

    /* renamed from: a  reason: collision with other field name */
    public String f773a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f774a = new BitSet(1);

    /* renamed from: b  reason: collision with other field name */
    public String f775b;

    /* renamed from: c  reason: collision with other field name */
    public String f776c;

    /* renamed from: d  reason: collision with other field name */
    public String f777d;

    /* renamed from: e  reason: collision with other field name */
    public String f778e;

    /* renamed from: f  reason: collision with other field name */
    public String f779f;

    /* renamed from: g  reason: collision with other field name */
    public String f780g;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f770a = new jh("XmPushActionUnSubscriptionResult");
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
                if (!m454a() || (a10 = is.a(this.f773a, ipVar.f773a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m456b()).compareTo(Boolean.valueOf(ipVar.m456b()));
                    if (compareTo2 == 0) {
                        if (!m456b() || (a9 = is.a(this.f772a, ipVar.f772a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(ipVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a8 = is.a(this.f775b, ipVar.f775b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(ipVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a7 = is.a(this.f776c, ipVar.f776c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(ipVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a6 = is.a(this.f771a, ipVar.f771a)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(ipVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a5 = is.a(this.f777d, ipVar.f777d)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ipVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a4 = is.a(this.f778e, ipVar.f778e)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(ipVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a3 = is.a(this.f779f, ipVar.f779f)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(ipVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a2 = is.a(this.f780g, ipVar.f780g)) == 0) {
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
        return this.f778e;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m453a() {
        if (this.f775b == null) {
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
            switch (m463a.f791a) {
                case 1:
                    if (m463a.a != 11) {
                        jf.a(jcVar, m463a.a);
                        break;
                    } else {
                        this.f773a = jcVar.m468a();
                        break;
                    }
                case 2:
                    if (m463a.a != 12) {
                        jf.a(jcVar, m463a.a);
                        break;
                    } else {
                        this.f772a = new hv();
                        this.f772a.a(jcVar);
                        break;
                    }
                case 3:
                    if (m463a.a != 11) {
                        jf.a(jcVar, m463a.a);
                        break;
                    } else {
                        this.f775b = jcVar.m468a();
                        break;
                    }
                case 4:
                    if (m463a.a != 11) {
                        jf.a(jcVar, m463a.a);
                        break;
                    } else {
                        this.f776c = jcVar.m468a();
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
                        this.f771a = jcVar.m462a();
                        a(true);
                        break;
                    }
                case 7:
                    if (m463a.a != 11) {
                        jf.a(jcVar, m463a.a);
                        break;
                    } else {
                        this.f777d = jcVar.m468a();
                        break;
                    }
                case 8:
                    if (m463a.a != 11) {
                        jf.a(jcVar, m463a.a);
                        break;
                    } else {
                        this.f778e = jcVar.m468a();
                        break;
                    }
                case 9:
                    if (m463a.a != 11) {
                        jf.a(jcVar, m463a.a);
                        break;
                    } else {
                        this.f779f = jcVar.m468a();
                        break;
                    }
                case 10:
                    if (m463a.a != 11) {
                        jf.a(jcVar, m463a.a);
                        break;
                    } else {
                        this.f780g = jcVar.m468a();
                        break;
                    }
            }
            jcVar.g();
        }
    }

    public void a(boolean z) {
        this.f774a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m454a() {
        return this.f773a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m455a(ip ipVar) {
        if (ipVar == null) {
            return false;
        }
        boolean m454a = m454a();
        boolean m454a2 = ipVar.m454a();
        if ((m454a || m454a2) && !(m454a && m454a2 && this.f773a.equals(ipVar.f773a))) {
            return false;
        }
        boolean m456b = m456b();
        boolean m456b2 = ipVar.m456b();
        if ((m456b || m456b2) && !(m456b && m456b2 && this.f772a.m373a(ipVar.f772a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = ipVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f775b.equals(ipVar.f775b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = ipVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f776c.equals(ipVar.f776c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = ipVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f771a == ipVar.f771a)) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = ipVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f777d.equals(ipVar.f777d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = ipVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f778e.equals(ipVar.f778e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = ipVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f779f.equals(ipVar.f779f))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = ipVar.i();
        return !(i2 || i3) || (i2 && i3 && this.f780g.equals(ipVar.f780g));
    }

    public String b() {
        return this.f780g;
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        m453a();
        jcVar.a(f770a);
        if (this.f773a != null && m454a()) {
            jcVar.a(a);
            jcVar.a(this.f773a);
            jcVar.b();
        }
        if (this.f772a != null && m456b()) {
            jcVar.a(b);
            this.f772a.b(jcVar);
            jcVar.b();
        }
        if (this.f775b != null) {
            jcVar.a(c);
            jcVar.a(this.f775b);
            jcVar.b();
        }
        if (this.f776c != null && d()) {
            jcVar.a(d);
            jcVar.a(this.f776c);
            jcVar.b();
        }
        if (e()) {
            jcVar.a(e);
            jcVar.a(this.f771a);
            jcVar.b();
        }
        if (this.f777d != null && f()) {
            jcVar.a(f);
            jcVar.a(this.f777d);
            jcVar.b();
        }
        if (this.f778e != null && g()) {
            jcVar.a(g);
            jcVar.a(this.f778e);
            jcVar.b();
        }
        if (this.f779f != null && h()) {
            jcVar.a(h);
            jcVar.a(this.f779f);
            jcVar.b();
        }
        if (this.f780g != null && i()) {
            jcVar.a(i);
            jcVar.a(this.f780g);
            jcVar.b();
        }
        jcVar.c();
        jcVar.m471a();
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m456b() {
        return this.f772a != null;
    }

    public boolean c() {
        return this.f775b != null;
    }

    public boolean d() {
        return this.f776c != null;
    }

    public boolean e() {
        return this.f774a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ip)) {
            return m455a((ip) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f777d != null;
    }

    public boolean g() {
        return this.f778e != null;
    }

    public boolean h() {
        return this.f779f != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f780g != null;
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionUnSubscriptionResult(");
        boolean z2 = true;
        if (m454a()) {
            sb.append("debug:");
            if (this.f773a == null) {
                sb.append("null");
            } else {
                sb.append(this.f773a);
            }
            z2 = false;
        }
        if (m456b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f772a == null) {
                sb.append("null");
            } else {
                sb.append(this.f772a);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f775b == null) {
            sb.append("null");
        } else {
            sb.append(this.f775b);
        }
        if (d()) {
            sb.append(", ");
            sb.append("appId:");
            if (this.f776c == null) {
                sb.append("null");
            } else {
                sb.append(this.f776c);
            }
        }
        if (e()) {
            sb.append(", ");
            sb.append("errorCode:");
            sb.append(this.f771a);
        }
        if (f()) {
            sb.append(", ");
            sb.append("reason:");
            if (this.f777d == null) {
                sb.append("null");
            } else {
                sb.append(this.f777d);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append(UrlSchemaHelper.SCHEMA_TYPE_TOPIC);
            if (this.f778e == null) {
                sb.append("null");
            } else {
                sb.append(this.f778e);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f779f == null) {
                sb.append("null");
            } else {
                sb.append(this.f779f);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("category:");
            if (this.f780g == null) {
                sb.append("null");
            } else {
                sb.append(this.f780g);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
