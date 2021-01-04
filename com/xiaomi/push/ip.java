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
    public hy f767a;

    /* renamed from: a  reason: collision with other field name */
    public ib f768a;

    /* renamed from: a  reason: collision with other field name */
    public String f769a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f771a;

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

    /* renamed from: h  reason: collision with other field name */
    public String f779h;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f766a = new jn("XmPushActionSendMessage");

    /* renamed from: a  reason: collision with root package name */
    private static final jf f14446a = new jf("", Constants.GZIP_CAST_TYPE, 1);

    /* renamed from: b  reason: collision with root package name */
    private static final jf f14447b = new jf("", (byte) 12, 2);
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
    private BitSet f770a = new BitSet(1);

    /* renamed from: a  reason: collision with other field name */
    public boolean f772a = true;

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
            int compareTo = Boolean.valueOf(m474a()).compareTo(Boolean.valueOf(ipVar.m474a()));
            if (compareTo == 0) {
                if (!m474a() || (a13 = iy.a(this.f769a, ipVar.f769a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m476b()).compareTo(Boolean.valueOf(ipVar.m476b()));
                    if (compareTo2 == 0) {
                        if (!m476b() || (a12 = iy.a(this.f768a, ipVar.f768a)) == 0) {
                            int compareTo3 = Boolean.valueOf(m477c()).compareTo(Boolean.valueOf(ipVar.m477c()));
                            if (compareTo3 == 0) {
                                if (!m477c() || (a11 = iy.a(this.f773b, ipVar.f773b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(m478d()).compareTo(Boolean.valueOf(ipVar.m478d()));
                                    if (compareTo4 == 0) {
                                        if (!m478d() || (a10 = iy.a(this.f774c, ipVar.f774c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(m479e()).compareTo(Boolean.valueOf(ipVar.m479e()));
                                            if (compareTo5 == 0) {
                                                if (!m479e() || (a9 = iy.a(this.f775d, ipVar.f775d)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(m480f()).compareTo(Boolean.valueOf(ipVar.m480f()));
                                                    if (compareTo6 == 0) {
                                                        if (!m480f() || (a8 = iy.a(this.f776e, ipVar.f776e)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ipVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a7 = iy.a(this.f777f, ipVar.f777f)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(ipVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a6 = iy.a(this.f767a, ipVar.f767a)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(ipVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a5 = iy.a(this.f772a, ipVar.f772a)) == 0) {
                                                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(ipVar.j()));
                                                                                    if (compareTo10 == 0) {
                                                                                        if (!j() || (a4 = iy.a(this.f771a, ipVar.f771a)) == 0) {
                                                                                            int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(ipVar.k()));
                                                                                            if (compareTo11 == 0) {
                                                                                                if (!k() || (a3 = iy.a(this.f778g, ipVar.f778g)) == 0) {
                                                                                                    int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(ipVar.l()));
                                                                                                    if (compareTo12 == 0) {
                                                                                                        if (!l() || (a2 = iy.a(this.f779h, ipVar.f779h)) == 0) {
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
        return this.f767a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m472a() {
        return this.f773b;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m473a() {
        if (this.f773b == null) {
            throw new jj("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f774c == null) {
            throw new jj("Required field 'appId' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m508a();
        while (true) {
            jf m504a = jiVar.m504a();
            if (m504a.f14470a == 0) {
                jiVar.f();
                m473a();
                return;
            }
            switch (m504a.f857a) {
                case 1:
                    if (m504a.f14470a == 11) {
                        this.f769a = jiVar.m509a();
                        break;
                    } else {
                        jl.a(jiVar, m504a.f14470a);
                        break;
                    }
                case 2:
                    if (m504a.f14470a == 12) {
                        this.f768a = new ib();
                        this.f768a.a(jiVar);
                        break;
                    } else {
                        jl.a(jiVar, m504a.f14470a);
                        break;
                    }
                case 3:
                    if (m504a.f14470a == 11) {
                        this.f773b = jiVar.m509a();
                        break;
                    } else {
                        jl.a(jiVar, m504a.f14470a);
                        break;
                    }
                case 4:
                    if (m504a.f14470a == 11) {
                        this.f774c = jiVar.m509a();
                        break;
                    } else {
                        jl.a(jiVar, m504a.f14470a);
                        break;
                    }
                case 5:
                    if (m504a.f14470a == 11) {
                        this.f775d = jiVar.m509a();
                        break;
                    } else {
                        jl.a(jiVar, m504a.f14470a);
                        break;
                    }
                case 6:
                    if (m504a.f14470a == 11) {
                        this.f776e = jiVar.m509a();
                        break;
                    } else {
                        jl.a(jiVar, m504a.f14470a);
                        break;
                    }
                case 7:
                    if (m504a.f14470a == 11) {
                        this.f777f = jiVar.m509a();
                        break;
                    } else {
                        jl.a(jiVar, m504a.f14470a);
                        break;
                    }
                case 8:
                    if (m504a.f14470a == 12) {
                        this.f767a = new hy();
                        this.f767a.a(jiVar);
                        break;
                    } else {
                        jl.a(jiVar, m504a.f14470a);
                        break;
                    }
                case 9:
                    if (m504a.f14470a == 2) {
                        this.f772a = jiVar.m513a();
                        a(true);
                        break;
                    } else {
                        jl.a(jiVar, m504a.f14470a);
                        break;
                    }
                case 10:
                    if (m504a.f14470a == 13) {
                        jh m506a = jiVar.m506a();
                        this.f771a = new HashMap(m506a.f859a * 2);
                        for (int i2 = 0; i2 < m506a.f859a; i2++) {
                            this.f771a.put(jiVar.m509a(), jiVar.m509a());
                        }
                        jiVar.h();
                        break;
                    } else {
                        jl.a(jiVar, m504a.f14470a);
                        break;
                    }
                case 11:
                    if (m504a.f14470a == 11) {
                        this.f778g = jiVar.m509a();
                        break;
                    } else {
                        jl.a(jiVar, m504a.f14470a);
                        break;
                    }
                case 12:
                    if (m504a.f14470a == 11) {
                        this.f779h = jiVar.m509a();
                        break;
                    } else {
                        jl.a(jiVar, m504a.f14470a);
                        break;
                    }
                default:
                    jl.a(jiVar, m504a.f14470a);
                    break;
            }
            jiVar.g();
        }
    }

    public void a(boolean z) {
        this.f770a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m474a() {
        return this.f769a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m475a(ip ipVar) {
        if (ipVar == null) {
            return false;
        }
        boolean m474a = m474a();
        boolean m474a2 = ipVar.m474a();
        if ((m474a || m474a2) && !(m474a && m474a2 && this.f769a.equals(ipVar.f769a))) {
            return false;
        }
        boolean m476b = m476b();
        boolean m476b2 = ipVar.m476b();
        if ((m476b || m476b2) && !(m476b && m476b2 && this.f768a.m417a(ipVar.f768a))) {
            return false;
        }
        boolean m477c = m477c();
        boolean m477c2 = ipVar.m477c();
        if ((m477c || m477c2) && !(m477c && m477c2 && this.f773b.equals(ipVar.f773b))) {
            return false;
        }
        boolean m478d = m478d();
        boolean m478d2 = ipVar.m478d();
        if ((m478d || m478d2) && !(m478d && m478d2 && this.f774c.equals(ipVar.f774c))) {
            return false;
        }
        boolean m479e = m479e();
        boolean m479e2 = ipVar.m479e();
        if ((m479e || m479e2) && !(m479e && m479e2 && this.f775d.equals(ipVar.f775d))) {
            return false;
        }
        boolean m480f = m480f();
        boolean m480f2 = ipVar.m480f();
        if ((m480f || m480f2) && !(m480f && m480f2 && this.f776e.equals(ipVar.f776e))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = ipVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f777f.equals(ipVar.f777f))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = ipVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f767a.m391a(ipVar.f767a))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = ipVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f772a == ipVar.f772a)) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = ipVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f771a.equals(ipVar.f771a))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = ipVar.k();
        if ((k2 || k3) && !(k2 && k3 && this.f778g.equals(ipVar.f778g))) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = ipVar.l();
        return !(l2 || l3) || (l2 && l3 && this.f779h.equals(ipVar.f779h));
    }

    public String b() {
        return this.f774c;
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        m473a();
        jiVar.a(f766a);
        if (this.f769a != null && m474a()) {
            jiVar.a(f14446a);
            jiVar.a(this.f769a);
            jiVar.b();
        }
        if (this.f768a != null && m476b()) {
            jiVar.a(f14447b);
            this.f768a.b(jiVar);
            jiVar.b();
        }
        if (this.f773b != null) {
            jiVar.a(c);
            jiVar.a(this.f773b);
            jiVar.b();
        }
        if (this.f774c != null) {
            jiVar.a(d);
            jiVar.a(this.f774c);
            jiVar.b();
        }
        if (this.f775d != null && m479e()) {
            jiVar.a(e);
            jiVar.a(this.f775d);
            jiVar.b();
        }
        if (this.f776e != null && m480f()) {
            jiVar.a(f);
            jiVar.a(this.f776e);
            jiVar.b();
        }
        if (this.f777f != null && g()) {
            jiVar.a(g);
            jiVar.a(this.f777f);
            jiVar.b();
        }
        if (this.f767a != null && h()) {
            jiVar.a(h);
            this.f767a.b(jiVar);
            jiVar.b();
        }
        if (i()) {
            jiVar.a(i);
            jiVar.a(this.f772a);
            jiVar.b();
        }
        if (this.f771a != null && j()) {
            jiVar.a(j);
            jiVar.a(new jh(Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, this.f771a.size()));
            for (Map.Entry<String, String> entry : this.f771a.entrySet()) {
                jiVar.a(entry.getKey());
                jiVar.a(entry.getValue());
            }
            jiVar.d();
            jiVar.b();
        }
        if (this.f778g != null && k()) {
            jiVar.a(k);
            jiVar.a(this.f778g);
            jiVar.b();
        }
        if (this.f779h != null && l()) {
            jiVar.a(l);
            jiVar.a(this.f779h);
            jiVar.b();
        }
        jiVar.c();
        jiVar.m512a();
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m476b() {
        return this.f768a != null;
    }

    public String c() {
        return this.f776e;
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m477c() {
        return this.f773b != null;
    }

    public String d() {
        return this.f777f;
    }

    /* renamed from: d  reason: collision with other method in class */
    public boolean m478d() {
        return this.f774c != null;
    }

    public String e() {
        return this.f778g;
    }

    /* renamed from: e  reason: collision with other method in class */
    public boolean m479e() {
        return this.f775d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ip)) {
            return m475a((ip) obj);
        }
        return false;
    }

    public String f() {
        return this.f779h;
    }

    /* renamed from: f  reason: collision with other method in class */
    public boolean m480f() {
        return this.f776e != null;
    }

    public boolean g() {
        return this.f777f != null;
    }

    public boolean h() {
        return this.f767a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f770a.get(0);
    }

    public boolean j() {
        return this.f771a != null;
    }

    public boolean k() {
        return this.f778g != null;
    }

    public boolean l() {
        return this.f779h != null;
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionSendMessage(");
        boolean z2 = true;
        if (m474a()) {
            sb.append("debug:");
            if (this.f769a == null) {
                sb.append("null");
            } else {
                sb.append(this.f769a);
            }
            z2 = false;
        }
        if (m476b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f768a == null) {
                sb.append("null");
            } else {
                sb.append(this.f768a);
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
        sb.append(", ");
        sb.append("appId:");
        if (this.f774c == null) {
            sb.append("null");
        } else {
            sb.append(this.f774c);
        }
        if (m479e()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f775d == null) {
                sb.append("null");
            } else {
                sb.append(this.f775d);
            }
        }
        if (m480f()) {
            sb.append(", ");
            sb.append(UrlSchemaHelper.SCHEMA_TYPE_TOPIC);
            if (this.f776e == null) {
                sb.append("null");
            } else {
                sb.append(this.f776e);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("aliasName:");
            if (this.f777f == null) {
                sb.append("null");
            } else {
                sb.append(this.f777f);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("message:");
            if (this.f767a == null) {
                sb.append("null");
            } else {
                sb.append(this.f767a);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("needAck:");
            sb.append(this.f772a);
        }
        if (j()) {
            sb.append(", ");
            sb.append("params:");
            if (this.f771a == null) {
                sb.append("null");
            } else {
                sb.append(this.f771a);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("category:");
            if (this.f778g == null) {
                sb.append("null");
            } else {
                sb.append(this.f778g);
            }
        }
        if (l()) {
            sb.append(", ");
            sb.append("userAccount:");
            if (this.f779h == null) {
                sb.append("null");
            } else {
                sb.append(this.f779h);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
