package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes3.dex */
public class ip implements ir<ip, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f768a;

    /* renamed from: a  reason: collision with other field name */
    public hv f769a;

    /* renamed from: a  reason: collision with other field name */
    public String f770a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f771a = new BitSet(1);

    /* renamed from: b  reason: collision with other field name */
    public String f772b;

    /* renamed from: c  reason: collision with other field name */
    public String f773c;

    /* renamed from: d  reason: collision with other field name */
    public String f774d;

    /* renamed from: e  reason: collision with other field name */
    public String f775e;

    /* renamed from: f  reason: collision with other field name */
    public String f776f;

    /* renamed from: g  reason: collision with other field name */
    public String f777g;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f767a = new jh("XmPushActionUnSubscriptionResult");
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
            int compareTo = Boolean.valueOf(m442a()).compareTo(Boolean.valueOf(ipVar.m442a()));
            if (compareTo == 0) {
                if (!m442a() || (a10 = is.a(this.f770a, ipVar.f770a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m444b()).compareTo(Boolean.valueOf(ipVar.m444b()));
                    if (compareTo2 == 0) {
                        if (!m444b() || (a9 = is.a(this.f769a, ipVar.f769a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(ipVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a8 = is.a(this.f772b, ipVar.f772b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(ipVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a7 = is.a(this.f773c, ipVar.f773c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(ipVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a6 = is.a(this.f768a, ipVar.f768a)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(ipVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a5 = is.a(this.f774d, ipVar.f774d)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ipVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a4 = is.a(this.f775e, ipVar.f775e)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(ipVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a3 = is.a(this.f776f, ipVar.f776f)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(ipVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a2 = is.a(this.f777g, ipVar.f777g)) == 0) {
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
        return this.f775e;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m441a() {
        if (this.f772b == null) {
            throw new jd("Required field 'id' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ir
    public void a(jc jcVar) {
        jcVar.m455a();
        while (true) {
            iz m451a = jcVar.m451a();
            if (m451a.a == 0) {
                jcVar.f();
                m441a();
                return;
            }
            switch (m451a.f788a) {
                case 1:
                    if (m451a.a != 11) {
                        jf.a(jcVar, m451a.a);
                        break;
                    } else {
                        this.f770a = jcVar.m456a();
                        break;
                    }
                case 2:
                    if (m451a.a != 12) {
                        jf.a(jcVar, m451a.a);
                        break;
                    } else {
                        this.f769a = new hv();
                        this.f769a.a(jcVar);
                        break;
                    }
                case 3:
                    if (m451a.a != 11) {
                        jf.a(jcVar, m451a.a);
                        break;
                    } else {
                        this.f772b = jcVar.m456a();
                        break;
                    }
                case 4:
                    if (m451a.a != 11) {
                        jf.a(jcVar, m451a.a);
                        break;
                    } else {
                        this.f773c = jcVar.m456a();
                        break;
                    }
                case 5:
                default:
                    jf.a(jcVar, m451a.a);
                    break;
                case 6:
                    if (m451a.a != 10) {
                        jf.a(jcVar, m451a.a);
                        break;
                    } else {
                        this.f768a = jcVar.m450a();
                        a(true);
                        break;
                    }
                case 7:
                    if (m451a.a != 11) {
                        jf.a(jcVar, m451a.a);
                        break;
                    } else {
                        this.f774d = jcVar.m456a();
                        break;
                    }
                case 8:
                    if (m451a.a != 11) {
                        jf.a(jcVar, m451a.a);
                        break;
                    } else {
                        this.f775e = jcVar.m456a();
                        break;
                    }
                case 9:
                    if (m451a.a != 11) {
                        jf.a(jcVar, m451a.a);
                        break;
                    } else {
                        this.f776f = jcVar.m456a();
                        break;
                    }
                case 10:
                    if (m451a.a != 11) {
                        jf.a(jcVar, m451a.a);
                        break;
                    } else {
                        this.f777g = jcVar.m456a();
                        break;
                    }
            }
            jcVar.g();
        }
    }

    public void a(boolean z) {
        this.f771a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m442a() {
        return this.f770a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m443a(ip ipVar) {
        if (ipVar == null) {
            return false;
        }
        boolean m442a = m442a();
        boolean m442a2 = ipVar.m442a();
        if ((m442a || m442a2) && !(m442a && m442a2 && this.f770a.equals(ipVar.f770a))) {
            return false;
        }
        boolean m444b = m444b();
        boolean m444b2 = ipVar.m444b();
        if ((m444b || m444b2) && !(m444b && m444b2 && this.f769a.m361a(ipVar.f769a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = ipVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f772b.equals(ipVar.f772b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = ipVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f773c.equals(ipVar.f773c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = ipVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f768a == ipVar.f768a)) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = ipVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f774d.equals(ipVar.f774d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = ipVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f775e.equals(ipVar.f775e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = ipVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f776f.equals(ipVar.f776f))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = ipVar.i();
        return !(i2 || i3) || (i2 && i3 && this.f777g.equals(ipVar.f777g));
    }

    public String b() {
        return this.f777g;
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        m441a();
        jcVar.a(f767a);
        if (this.f770a != null && m442a()) {
            jcVar.a(a);
            jcVar.a(this.f770a);
            jcVar.b();
        }
        if (this.f769a != null && m444b()) {
            jcVar.a(b);
            this.f769a.b(jcVar);
            jcVar.b();
        }
        if (this.f772b != null) {
            jcVar.a(c);
            jcVar.a(this.f772b);
            jcVar.b();
        }
        if (this.f773c != null && d()) {
            jcVar.a(d);
            jcVar.a(this.f773c);
            jcVar.b();
        }
        if (e()) {
            jcVar.a(e);
            jcVar.a(this.f768a);
            jcVar.b();
        }
        if (this.f774d != null && f()) {
            jcVar.a(f);
            jcVar.a(this.f774d);
            jcVar.b();
        }
        if (this.f775e != null && g()) {
            jcVar.a(g);
            jcVar.a(this.f775e);
            jcVar.b();
        }
        if (this.f776f != null && h()) {
            jcVar.a(h);
            jcVar.a(this.f776f);
            jcVar.b();
        }
        if (this.f777g != null && i()) {
            jcVar.a(i);
            jcVar.a(this.f777g);
            jcVar.b();
        }
        jcVar.c();
        jcVar.m459a();
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m444b() {
        return this.f769a != null;
    }

    public boolean c() {
        return this.f772b != null;
    }

    public boolean d() {
        return this.f773c != null;
    }

    public boolean e() {
        return this.f771a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ip)) {
            return m443a((ip) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f774d != null;
    }

    public boolean g() {
        return this.f775e != null;
    }

    public boolean h() {
        return this.f776f != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f777g != null;
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionUnSubscriptionResult(");
        boolean z2 = true;
        if (m442a()) {
            sb.append("debug:");
            if (this.f770a == null) {
                sb.append("null");
            } else {
                sb.append(this.f770a);
            }
            z2 = false;
        }
        if (m444b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f769a == null) {
                sb.append("null");
            } else {
                sb.append(this.f769a);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f772b == null) {
            sb.append("null");
        } else {
            sb.append(this.f772b);
        }
        if (d()) {
            sb.append(", ");
            sb.append("appId:");
            if (this.f773c == null) {
                sb.append("null");
            } else {
                sb.append(this.f773c);
            }
        }
        if (e()) {
            sb.append(", ");
            sb.append("errorCode:");
            sb.append(this.f768a);
        }
        if (f()) {
            sb.append(", ");
            sb.append("reason:");
            if (this.f774d == null) {
                sb.append("null");
            } else {
                sb.append(this.f774d);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append(UrlSchemaHelper.SCHEMA_TYPE_TOPIC);
            if (this.f775e == null) {
                sb.append("null");
            } else {
                sb.append(this.f775e);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f776f == null) {
                sb.append("null");
            } else {
                sb.append(this.f776f);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("category:");
            if (this.f777g == null) {
                sb.append("null");
            } else {
                sb.append(this.f777g);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
