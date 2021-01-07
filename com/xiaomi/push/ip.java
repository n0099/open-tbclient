package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class ip implements ix<ip, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public hy f768a;

    /* renamed from: a  reason: collision with other field name */
    public ib f769a;

    /* renamed from: a  reason: collision with other field name */
    public String f770a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f772a;

    /* renamed from: b  reason: collision with other field name */
    public String f774b;

    /* renamed from: c  reason: collision with other field name */
    public String f775c;

    /* renamed from: d  reason: collision with other field name */
    public String f776d;

    /* renamed from: e  reason: collision with other field name */
    public String f777e;

    /* renamed from: f  reason: collision with other field name */
    public String f778f;

    /* renamed from: g  reason: collision with other field name */
    public String f779g;

    /* renamed from: h  reason: collision with other field name */
    public String f780h;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f767a = new jn("XmPushActionSendMessage");

    /* renamed from: a  reason: collision with root package name */
    private static final jf f14447a = new jf("", Constants.GZIP_CAST_TYPE, 1);

    /* renamed from: b  reason: collision with root package name */
    private static final jf f14448b = new jf("", (byte) 12, 2);
    private static final jf c = new jf("", Constants.GZIP_CAST_TYPE, 3);
    private static final jf d = new jf("", Constants.GZIP_CAST_TYPE, 4);
    private static final jf e = new jf("", Constants.GZIP_CAST_TYPE, 5);
    private static final jf f = new jf("", Constants.GZIP_CAST_TYPE, 6);
    private static final jf g = new jf("", Constants.GZIP_CAST_TYPE, 7);
    private static final jf h = new jf("", (byte) 12, 8);
    private static final jf i = new jf("", (byte) 2, 9);
    private static final jf j = new jf("", (byte) 13, 10);
    private static final jf k = new jf("", Constants.GZIP_CAST_TYPE, 11);
    private static final jf l = new jf("", Constants.GZIP_CAST_TYPE, 12);

    /* renamed from: a  reason: collision with other field name */
    private BitSet f771a = new BitSet(1);

    /* renamed from: a  reason: collision with other field name */
    public boolean f773a = true;

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
        int a11;
        int a12;
        int a13;
        if (getClass().equals(ipVar.getClass())) {
            int compareTo = Boolean.valueOf(m485a()).compareTo(Boolean.valueOf(ipVar.m485a()));
            if (compareTo == 0) {
                if (!m485a() || (a13 = iy.a(this.f770a, ipVar.f770a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m487b()).compareTo(Boolean.valueOf(ipVar.m487b()));
                    if (compareTo2 == 0) {
                        if (!m487b() || (a12 = iy.a(this.f769a, ipVar.f769a)) == 0) {
                            int compareTo3 = Boolean.valueOf(m488c()).compareTo(Boolean.valueOf(ipVar.m488c()));
                            if (compareTo3 == 0) {
                                if (!m488c() || (a11 = iy.a(this.f774b, ipVar.f774b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(m489d()).compareTo(Boolean.valueOf(ipVar.m489d()));
                                    if (compareTo4 == 0) {
                                        if (!m489d() || (a10 = iy.a(this.f775c, ipVar.f775c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(m490e()).compareTo(Boolean.valueOf(ipVar.m490e()));
                                            if (compareTo5 == 0) {
                                                if (!m490e() || (a9 = iy.a(this.f776d, ipVar.f776d)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(m491f()).compareTo(Boolean.valueOf(ipVar.m491f()));
                                                    if (compareTo6 == 0) {
                                                        if (!m491f() || (a8 = iy.a(this.f777e, ipVar.f777e)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ipVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a7 = iy.a(this.f778f, ipVar.f778f)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(ipVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a6 = iy.a(this.f768a, ipVar.f768a)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(ipVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a5 = iy.a(this.f773a, ipVar.f773a)) == 0) {
                                                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(ipVar.j()));
                                                                                    if (compareTo10 == 0) {
                                                                                        if (!j() || (a4 = iy.a(this.f772a, ipVar.f772a)) == 0) {
                                                                                            int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(ipVar.k()));
                                                                                            if (compareTo11 == 0) {
                                                                                                if (!k() || (a3 = iy.a(this.f779g, ipVar.f779g)) == 0) {
                                                                                                    int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(ipVar.l()));
                                                                                                    if (compareTo12 == 0) {
                                                                                                        if (!l() || (a2 = iy.a(this.f780h, ipVar.f780h)) == 0) {
                                                                                                            return 0;
                                                                                                        }
                                                                                                        return a2;
                                                                                                    }
                                                                                                    return compareTo12;
                                                                                                }
                                                                                                return a3;
                                                                                            }
                                                                                            return compareTo11;
                                                                                        }
                                                                                        return a4;
                                                                                    }
                                                                                    return compareTo10;
                                                                                }
                                                                                return a5;
                                                                            }
                                                                            return compareTo9;
                                                                        }
                                                                        return a6;
                                                                    }
                                                                    return compareTo8;
                                                                }
                                                                return a7;
                                                            }
                                                            return compareTo7;
                                                        }
                                                        return a8;
                                                    }
                                                    return compareTo6;
                                                }
                                                return a9;
                                            }
                                            return compareTo5;
                                        }
                                        return a10;
                                    }
                                    return compareTo4;
                                }
                                return a11;
                            }
                            return compareTo3;
                        }
                        return a12;
                    }
                    return compareTo2;
                }
                return a13;
            }
            return compareTo;
        }
        return getClass().getName().compareTo(ipVar.getClass().getName());
    }

    public hy a() {
        return this.f768a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m483a() {
        return this.f774b;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m484a() {
        if (this.f774b == null) {
            throw new jj("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f775c == null) {
            throw new jj("Required field 'appId' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m519a();
        while (true) {
            jf m515a = jiVar.m515a();
            if (m515a.f14471a == 0) {
                jiVar.f();
                m484a();
                return;
            }
            switch (m515a.f858a) {
                case 1:
                    if (m515a.f14471a == 11) {
                        this.f770a = jiVar.m520a();
                        break;
                    } else {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    }
                case 2:
                    if (m515a.f14471a == 12) {
                        this.f769a = new ib();
                        this.f769a.a(jiVar);
                        break;
                    } else {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    }
                case 3:
                    if (m515a.f14471a == 11) {
                        this.f774b = jiVar.m520a();
                        break;
                    } else {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    }
                case 4:
                    if (m515a.f14471a == 11) {
                        this.f775c = jiVar.m520a();
                        break;
                    } else {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    }
                case 5:
                    if (m515a.f14471a == 11) {
                        this.f776d = jiVar.m520a();
                        break;
                    } else {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    }
                case 6:
                    if (m515a.f14471a == 11) {
                        this.f777e = jiVar.m520a();
                        break;
                    } else {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    }
                case 7:
                    if (m515a.f14471a == 11) {
                        this.f778f = jiVar.m520a();
                        break;
                    } else {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    }
                case 8:
                    if (m515a.f14471a == 12) {
                        this.f768a = new hy();
                        this.f768a.a(jiVar);
                        break;
                    } else {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    }
                case 9:
                    if (m515a.f14471a == 2) {
                        this.f773a = jiVar.m524a();
                        a(true);
                        break;
                    } else {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    }
                case 10:
                    if (m515a.f14471a == 13) {
                        jh m517a = jiVar.m517a();
                        this.f772a = new HashMap(m517a.f860a * 2);
                        for (int i2 = 0; i2 < m517a.f860a; i2++) {
                            this.f772a.put(jiVar.m520a(), jiVar.m520a());
                        }
                        jiVar.h();
                        break;
                    } else {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    }
                case 11:
                    if (m515a.f14471a == 11) {
                        this.f779g = jiVar.m520a();
                        break;
                    } else {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    }
                case 12:
                    if (m515a.f14471a == 11) {
                        this.f780h = jiVar.m520a();
                        break;
                    } else {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    }
                default:
                    jl.a(jiVar, m515a.f14471a);
                    break;
            }
            jiVar.g();
        }
    }

    public void a(boolean z) {
        this.f771a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m485a() {
        return this.f770a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m486a(ip ipVar) {
        if (ipVar == null) {
            return false;
        }
        boolean m485a = m485a();
        boolean m485a2 = ipVar.m485a();
        if ((m485a || m485a2) && !(m485a && m485a2 && this.f770a.equals(ipVar.f770a))) {
            return false;
        }
        boolean m487b = m487b();
        boolean m487b2 = ipVar.m487b();
        if ((m487b || m487b2) && !(m487b && m487b2 && this.f769a.m428a(ipVar.f769a))) {
            return false;
        }
        boolean m488c = m488c();
        boolean m488c2 = ipVar.m488c();
        if ((m488c || m488c2) && !(m488c && m488c2 && this.f774b.equals(ipVar.f774b))) {
            return false;
        }
        boolean m489d = m489d();
        boolean m489d2 = ipVar.m489d();
        if ((m489d || m489d2) && !(m489d && m489d2 && this.f775c.equals(ipVar.f775c))) {
            return false;
        }
        boolean m490e = m490e();
        boolean m490e2 = ipVar.m490e();
        if ((m490e || m490e2) && !(m490e && m490e2 && this.f776d.equals(ipVar.f776d))) {
            return false;
        }
        boolean m491f = m491f();
        boolean m491f2 = ipVar.m491f();
        if ((m491f || m491f2) && !(m491f && m491f2 && this.f777e.equals(ipVar.f777e))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = ipVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f778f.equals(ipVar.f778f))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = ipVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f768a.m402a(ipVar.f768a))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = ipVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f773a == ipVar.f773a)) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = ipVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f772a.equals(ipVar.f772a))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = ipVar.k();
        if ((k2 || k3) && !(k2 && k3 && this.f779g.equals(ipVar.f779g))) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = ipVar.l();
        return !(l2 || l3) || (l2 && l3 && this.f780h.equals(ipVar.f780h));
    }

    public String b() {
        return this.f775c;
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        m484a();
        jiVar.a(f767a);
        if (this.f770a != null && m485a()) {
            jiVar.a(f14447a);
            jiVar.a(this.f770a);
            jiVar.b();
        }
        if (this.f769a != null && m487b()) {
            jiVar.a(f14448b);
            this.f769a.b(jiVar);
            jiVar.b();
        }
        if (this.f774b != null) {
            jiVar.a(c);
            jiVar.a(this.f774b);
            jiVar.b();
        }
        if (this.f775c != null) {
            jiVar.a(d);
            jiVar.a(this.f775c);
            jiVar.b();
        }
        if (this.f776d != null && m490e()) {
            jiVar.a(e);
            jiVar.a(this.f776d);
            jiVar.b();
        }
        if (this.f777e != null && m491f()) {
            jiVar.a(f);
            jiVar.a(this.f777e);
            jiVar.b();
        }
        if (this.f778f != null && g()) {
            jiVar.a(g);
            jiVar.a(this.f778f);
            jiVar.b();
        }
        if (this.f768a != null && h()) {
            jiVar.a(h);
            this.f768a.b(jiVar);
            jiVar.b();
        }
        if (i()) {
            jiVar.a(i);
            jiVar.a(this.f773a);
            jiVar.b();
        }
        if (this.f772a != null && j()) {
            jiVar.a(j);
            jiVar.a(new jh(Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, this.f772a.size()));
            for (Map.Entry<String, String> entry : this.f772a.entrySet()) {
                jiVar.a(entry.getKey());
                jiVar.a(entry.getValue());
            }
            jiVar.d();
            jiVar.b();
        }
        if (this.f779g != null && k()) {
            jiVar.a(k);
            jiVar.a(this.f779g);
            jiVar.b();
        }
        if (this.f780h != null && l()) {
            jiVar.a(l);
            jiVar.a(this.f780h);
            jiVar.b();
        }
        jiVar.c();
        jiVar.m523a();
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m487b() {
        return this.f769a != null;
    }

    public String c() {
        return this.f777e;
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m488c() {
        return this.f774b != null;
    }

    public String d() {
        return this.f778f;
    }

    /* renamed from: d  reason: collision with other method in class */
    public boolean m489d() {
        return this.f775c != null;
    }

    public String e() {
        return this.f779g;
    }

    /* renamed from: e  reason: collision with other method in class */
    public boolean m490e() {
        return this.f776d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ip)) {
            return m486a((ip) obj);
        }
        return false;
    }

    public String f() {
        return this.f780h;
    }

    /* renamed from: f  reason: collision with other method in class */
    public boolean m491f() {
        return this.f777e != null;
    }

    public boolean g() {
        return this.f778f != null;
    }

    public boolean h() {
        return this.f768a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f771a.get(0);
    }

    public boolean j() {
        return this.f772a != null;
    }

    public boolean k() {
        return this.f779g != null;
    }

    public boolean l() {
        return this.f780h != null;
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionSendMessage(");
        boolean z2 = true;
        if (m485a()) {
            sb.append("debug:");
            if (this.f770a == null) {
                sb.append("null");
            } else {
                sb.append(this.f770a);
            }
            z2 = false;
        }
        if (m487b()) {
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
        if (this.f774b == null) {
            sb.append("null");
        } else {
            sb.append(this.f774b);
        }
        sb.append(", ");
        sb.append("appId:");
        if (this.f775c == null) {
            sb.append("null");
        } else {
            sb.append(this.f775c);
        }
        if (m490e()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f776d == null) {
                sb.append("null");
            } else {
                sb.append(this.f776d);
            }
        }
        if (m491f()) {
            sb.append(", ");
            sb.append(UrlSchemaHelper.SCHEMA_TYPE_TOPIC);
            if (this.f777e == null) {
                sb.append("null");
            } else {
                sb.append(this.f777e);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("aliasName:");
            if (this.f778f == null) {
                sb.append("null");
            } else {
                sb.append(this.f778f);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("message:");
            if (this.f768a == null) {
                sb.append("null");
            } else {
                sb.append(this.f768a);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("needAck:");
            sb.append(this.f773a);
        }
        if (j()) {
            sb.append(", ");
            sb.append("params:");
            if (this.f772a == null) {
                sb.append("null");
            } else {
                sb.append(this.f772a);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("category:");
            if (this.f779g == null) {
                sb.append("null");
            } else {
                sb.append(this.f779g);
            }
        }
        if (l()) {
            sb.append(", ");
            sb.append("userAccount:");
            if (this.f780h == null) {
                sb.append("null");
            } else {
                sb.append(this.f780h);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
