package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes8.dex */
public class ip implements ir<ip, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f769a;

    /* renamed from: a  reason: collision with other field name */
    public hv f770a;

    /* renamed from: a  reason: collision with other field name */
    public String f771a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f772a = new BitSet(1);

    /* renamed from: b  reason: collision with other field name */
    public String f773b;

    /* renamed from: c  reason: collision with other field name */
    public String f774c;

    /* renamed from: d  reason: collision with other field name */
    public String f775d;

    /* renamed from: e  reason: collision with other field name */
    public String f776e;

    /* renamed from: f  reason: collision with other field name */
    public String f777f;

    /* renamed from: g  reason: collision with other field name */
    public String f778g;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f768a = new jh("XmPushActionUnSubscriptionResult");
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
            int compareTo = Boolean.valueOf(m459a()).compareTo(Boolean.valueOf(ipVar.m459a()));
            if (compareTo == 0) {
                if (!m459a() || (a10 = is.a(this.f771a, ipVar.f771a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m461b()).compareTo(Boolean.valueOf(ipVar.m461b()));
                    if (compareTo2 == 0) {
                        if (!m461b() || (a9 = is.a(this.f770a, ipVar.f770a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(ipVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a8 = is.a(this.f773b, ipVar.f773b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(ipVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a7 = is.a(this.f774c, ipVar.f774c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(ipVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a6 = is.a(this.f769a, ipVar.f769a)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(ipVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a5 = is.a(this.f775d, ipVar.f775d)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ipVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a4 = is.a(this.f776e, ipVar.f776e)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(ipVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a3 = is.a(this.f777f, ipVar.f777f)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(ipVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a2 = is.a(this.f778g, ipVar.f778g)) == 0) {
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
        return this.f776e;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m458a() {
        if (this.f773b == null) {
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
                m458a();
                return;
            }
            switch (m468a.f789a) {
                case 1:
                    if (m468a.a != 11) {
                        jf.a(jcVar, m468a.a);
                        break;
                    } else {
                        this.f771a = jcVar.m473a();
                        break;
                    }
                case 2:
                    if (m468a.a != 12) {
                        jf.a(jcVar, m468a.a);
                        break;
                    } else {
                        this.f770a = new hv();
                        this.f770a.a(jcVar);
                        break;
                    }
                case 3:
                    if (m468a.a != 11) {
                        jf.a(jcVar, m468a.a);
                        break;
                    } else {
                        this.f773b = jcVar.m473a();
                        break;
                    }
                case 4:
                    if (m468a.a != 11) {
                        jf.a(jcVar, m468a.a);
                        break;
                    } else {
                        this.f774c = jcVar.m473a();
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
                        this.f769a = jcVar.m467a();
                        a(true);
                        break;
                    }
                case 7:
                    if (m468a.a != 11) {
                        jf.a(jcVar, m468a.a);
                        break;
                    } else {
                        this.f775d = jcVar.m473a();
                        break;
                    }
                case 8:
                    if (m468a.a != 11) {
                        jf.a(jcVar, m468a.a);
                        break;
                    } else {
                        this.f776e = jcVar.m473a();
                        break;
                    }
                case 9:
                    if (m468a.a != 11) {
                        jf.a(jcVar, m468a.a);
                        break;
                    } else {
                        this.f777f = jcVar.m473a();
                        break;
                    }
                case 10:
                    if (m468a.a != 11) {
                        jf.a(jcVar, m468a.a);
                        break;
                    } else {
                        this.f778g = jcVar.m473a();
                        break;
                    }
            }
            jcVar.g();
        }
    }

    public void a(boolean z) {
        this.f772a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m459a() {
        return this.f771a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m460a(ip ipVar) {
        if (ipVar == null) {
            return false;
        }
        boolean m459a = m459a();
        boolean m459a2 = ipVar.m459a();
        if ((m459a || m459a2) && !(m459a && m459a2 && this.f771a.equals(ipVar.f771a))) {
            return false;
        }
        boolean m461b = m461b();
        boolean m461b2 = ipVar.m461b();
        if ((m461b || m461b2) && !(m461b && m461b2 && this.f770a.m378a(ipVar.f770a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = ipVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f773b.equals(ipVar.f773b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = ipVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f774c.equals(ipVar.f774c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = ipVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f769a == ipVar.f769a)) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = ipVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f775d.equals(ipVar.f775d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = ipVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f776e.equals(ipVar.f776e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = ipVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f777f.equals(ipVar.f777f))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = ipVar.i();
        return !(i2 || i3) || (i2 && i3 && this.f778g.equals(ipVar.f778g));
    }

    public String b() {
        return this.f778g;
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        m458a();
        jcVar.a(f768a);
        if (this.f771a != null && m459a()) {
            jcVar.a(a);
            jcVar.a(this.f771a);
            jcVar.b();
        }
        if (this.f770a != null && m461b()) {
            jcVar.a(b);
            this.f770a.b(jcVar);
            jcVar.b();
        }
        if (this.f773b != null) {
            jcVar.a(c);
            jcVar.a(this.f773b);
            jcVar.b();
        }
        if (this.f774c != null && d()) {
            jcVar.a(d);
            jcVar.a(this.f774c);
            jcVar.b();
        }
        if (e()) {
            jcVar.a(e);
            jcVar.a(this.f769a);
            jcVar.b();
        }
        if (this.f775d != null && f()) {
            jcVar.a(f);
            jcVar.a(this.f775d);
            jcVar.b();
        }
        if (this.f776e != null && g()) {
            jcVar.a(g);
            jcVar.a(this.f776e);
            jcVar.b();
        }
        if (this.f777f != null && h()) {
            jcVar.a(h);
            jcVar.a(this.f777f);
            jcVar.b();
        }
        if (this.f778g != null && i()) {
            jcVar.a(i);
            jcVar.a(this.f778g);
            jcVar.b();
        }
        jcVar.c();
        jcVar.m476a();
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m461b() {
        return this.f770a != null;
    }

    public boolean c() {
        return this.f773b != null;
    }

    public boolean d() {
        return this.f774c != null;
    }

    public boolean e() {
        return this.f772a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ip)) {
            return m460a((ip) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f775d != null;
    }

    public boolean g() {
        return this.f776e != null;
    }

    public boolean h() {
        return this.f777f != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f778g != null;
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionUnSubscriptionResult(");
        boolean z2 = true;
        if (m459a()) {
            sb.append("debug:");
            if (this.f771a == null) {
                sb.append("null");
            } else {
                sb.append(this.f771a);
            }
            z2 = false;
        }
        if (m461b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f770a == null) {
                sb.append("null");
            } else {
                sb.append(this.f770a);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f773b == null) {
            sb.append("null");
        } else {
            sb.append(this.f773b);
        }
        if (d()) {
            sb.append(", ");
            sb.append("appId:");
            if (this.f774c == null) {
                sb.append("null");
            } else {
                sb.append(this.f774c);
            }
        }
        if (e()) {
            sb.append(", ");
            sb.append("errorCode:");
            sb.append(this.f769a);
        }
        if (f()) {
            sb.append(", ");
            sb.append("reason:");
            if (this.f775d == null) {
                sb.append("null");
            } else {
                sb.append(this.f775d);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append(UrlSchemaHelper.SCHEMA_TYPE_TOPIC);
            if (this.f776e == null) {
                sb.append("null");
            } else {
                sb.append(this.f776e);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f777f == null) {
                sb.append("null");
            } else {
                sb.append(this.f777f);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("category:");
            if (this.f778g == null) {
                sb.append("null");
            } else {
                sb.append(this.f778g);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
