package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes12.dex */
public class ip implements ix<ip, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public hy f686a;

    /* renamed from: a  reason: collision with other field name */
    public ib f687a;

    /* renamed from: a  reason: collision with other field name */
    public String f688a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f690a;

    /* renamed from: b  reason: collision with other field name */
    public String f692b;

    /* renamed from: c  reason: collision with other field name */
    public String f693c;

    /* renamed from: d  reason: collision with other field name */
    public String f694d;

    /* renamed from: e  reason: collision with other field name */
    public String f695e;

    /* renamed from: f  reason: collision with other field name */
    public String f696f;

    /* renamed from: g  reason: collision with other field name */
    public String f697g;

    /* renamed from: h  reason: collision with other field name */
    public String f698h;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f685a = new jn("XmPushActionSendMessage");

    /* renamed from: a  reason: collision with root package name */
    private static final jf f4983a = new jf("", Constants.GZIP_CAST_TYPE, 1);
    private static final jf b = new jf("", (byte) 12, 2);
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
    private BitSet f689a = new BitSet(1);

    /* renamed from: a  reason: collision with other field name */
    public boolean f691a = true;

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
            int compareTo = Boolean.valueOf(m455a()).compareTo(Boolean.valueOf(ipVar.m455a()));
            if (compareTo == 0) {
                if (!m455a() || (a13 = iy.a(this.f688a, ipVar.f688a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m457b()).compareTo(Boolean.valueOf(ipVar.m457b()));
                    if (compareTo2 == 0) {
                        if (!m457b() || (a12 = iy.a(this.f687a, ipVar.f687a)) == 0) {
                            int compareTo3 = Boolean.valueOf(m458c()).compareTo(Boolean.valueOf(ipVar.m458c()));
                            if (compareTo3 == 0) {
                                if (!m458c() || (a11 = iy.a(this.f692b, ipVar.f692b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(m459d()).compareTo(Boolean.valueOf(ipVar.m459d()));
                                    if (compareTo4 == 0) {
                                        if (!m459d() || (a10 = iy.a(this.f693c, ipVar.f693c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(m460e()).compareTo(Boolean.valueOf(ipVar.m460e()));
                                            if (compareTo5 == 0) {
                                                if (!m460e() || (a9 = iy.a(this.f694d, ipVar.f694d)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(m461f()).compareTo(Boolean.valueOf(ipVar.m461f()));
                                                    if (compareTo6 == 0) {
                                                        if (!m461f() || (a8 = iy.a(this.f695e, ipVar.f695e)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ipVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a7 = iy.a(this.f696f, ipVar.f696f)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(ipVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a6 = iy.a(this.f686a, ipVar.f686a)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(ipVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a5 = iy.a(this.f691a, ipVar.f691a)) == 0) {
                                                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(ipVar.j()));
                                                                                    if (compareTo10 == 0) {
                                                                                        if (!j() || (a4 = iy.a(this.f690a, ipVar.f690a)) == 0) {
                                                                                            int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(ipVar.k()));
                                                                                            if (compareTo11 == 0) {
                                                                                                if (!k() || (a3 = iy.a(this.f697g, ipVar.f697g)) == 0) {
                                                                                                    int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(ipVar.l()));
                                                                                                    if (compareTo12 == 0) {
                                                                                                        if (!l() || (a2 = iy.a(this.f698h, ipVar.f698h)) == 0) {
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
        return this.f686a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m453a() {
        return this.f692b;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m454a() {
        if (this.f692b == null) {
            throw new jj("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f693c == null) {
            throw new jj("Required field 'appId' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m489a();
        while (true) {
            jf m485a = jiVar.m485a();
            if (m485a.f4998a == 0) {
                jiVar.f();
                m454a();
                return;
            }
            switch (m485a.f776a) {
                case 1:
                    if (m485a.f4998a == 11) {
                        this.f688a = jiVar.m490a();
                        break;
                    } else {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    }
                case 2:
                    if (m485a.f4998a == 12) {
                        this.f687a = new ib();
                        this.f687a.a(jiVar);
                        break;
                    } else {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    }
                case 3:
                    if (m485a.f4998a == 11) {
                        this.f692b = jiVar.m490a();
                        break;
                    } else {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    }
                case 4:
                    if (m485a.f4998a == 11) {
                        this.f693c = jiVar.m490a();
                        break;
                    } else {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    }
                case 5:
                    if (m485a.f4998a == 11) {
                        this.f694d = jiVar.m490a();
                        break;
                    } else {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    }
                case 6:
                    if (m485a.f4998a == 11) {
                        this.f695e = jiVar.m490a();
                        break;
                    } else {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    }
                case 7:
                    if (m485a.f4998a == 11) {
                        this.f696f = jiVar.m490a();
                        break;
                    } else {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    }
                case 8:
                    if (m485a.f4998a == 12) {
                        this.f686a = new hy();
                        this.f686a.a(jiVar);
                        break;
                    } else {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    }
                case 9:
                    if (m485a.f4998a == 2) {
                        this.f691a = jiVar.m494a();
                        a(true);
                        break;
                    } else {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    }
                case 10:
                    if (m485a.f4998a == 13) {
                        jh m487a = jiVar.m487a();
                        this.f690a = new HashMap(m487a.f778a * 2);
                        for (int i2 = 0; i2 < m487a.f778a; i2++) {
                            this.f690a.put(jiVar.m490a(), jiVar.m490a());
                        }
                        jiVar.h();
                        break;
                    } else {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    }
                case 11:
                    if (m485a.f4998a == 11) {
                        this.f697g = jiVar.m490a();
                        break;
                    } else {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    }
                case 12:
                    if (m485a.f4998a == 11) {
                        this.f698h = jiVar.m490a();
                        break;
                    } else {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    }
                default:
                    jl.a(jiVar, m485a.f4998a);
                    break;
            }
            jiVar.g();
        }
    }

    public void a(boolean z) {
        this.f689a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m455a() {
        return this.f688a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m456a(ip ipVar) {
        if (ipVar == null) {
            return false;
        }
        boolean m455a = m455a();
        boolean m455a2 = ipVar.m455a();
        if ((m455a || m455a2) && !(m455a && m455a2 && this.f688a.equals(ipVar.f688a))) {
            return false;
        }
        boolean m457b = m457b();
        boolean m457b2 = ipVar.m457b();
        if ((m457b || m457b2) && !(m457b && m457b2 && this.f687a.m398a(ipVar.f687a))) {
            return false;
        }
        boolean m458c = m458c();
        boolean m458c2 = ipVar.m458c();
        if ((m458c || m458c2) && !(m458c && m458c2 && this.f692b.equals(ipVar.f692b))) {
            return false;
        }
        boolean m459d = m459d();
        boolean m459d2 = ipVar.m459d();
        if ((m459d || m459d2) && !(m459d && m459d2 && this.f693c.equals(ipVar.f693c))) {
            return false;
        }
        boolean m460e = m460e();
        boolean m460e2 = ipVar.m460e();
        if ((m460e || m460e2) && !(m460e && m460e2 && this.f694d.equals(ipVar.f694d))) {
            return false;
        }
        boolean m461f = m461f();
        boolean m461f2 = ipVar.m461f();
        if ((m461f || m461f2) && !(m461f && m461f2 && this.f695e.equals(ipVar.f695e))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = ipVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f696f.equals(ipVar.f696f))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = ipVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f686a.m372a(ipVar.f686a))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = ipVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f691a == ipVar.f691a)) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = ipVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f690a.equals(ipVar.f690a))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = ipVar.k();
        if ((k2 || k3) && !(k2 && k3 && this.f697g.equals(ipVar.f697g))) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = ipVar.l();
        return !(l2 || l3) || (l2 && l3 && this.f698h.equals(ipVar.f698h));
    }

    public String b() {
        return this.f693c;
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        m454a();
        jiVar.a(f685a);
        if (this.f688a != null && m455a()) {
            jiVar.a(f4983a);
            jiVar.a(this.f688a);
            jiVar.b();
        }
        if (this.f687a != null && m457b()) {
            jiVar.a(b);
            this.f687a.b(jiVar);
            jiVar.b();
        }
        if (this.f692b != null) {
            jiVar.a(c);
            jiVar.a(this.f692b);
            jiVar.b();
        }
        if (this.f693c != null) {
            jiVar.a(d);
            jiVar.a(this.f693c);
            jiVar.b();
        }
        if (this.f694d != null && m460e()) {
            jiVar.a(e);
            jiVar.a(this.f694d);
            jiVar.b();
        }
        if (this.f695e != null && m461f()) {
            jiVar.a(f);
            jiVar.a(this.f695e);
            jiVar.b();
        }
        if (this.f696f != null && g()) {
            jiVar.a(g);
            jiVar.a(this.f696f);
            jiVar.b();
        }
        if (this.f686a != null && h()) {
            jiVar.a(h);
            this.f686a.b(jiVar);
            jiVar.b();
        }
        if (i()) {
            jiVar.a(i);
            jiVar.a(this.f691a);
            jiVar.b();
        }
        if (this.f690a != null && j()) {
            jiVar.a(j);
            jiVar.a(new jh(Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, this.f690a.size()));
            for (Map.Entry<String, String> entry : this.f690a.entrySet()) {
                jiVar.a(entry.getKey());
                jiVar.a(entry.getValue());
            }
            jiVar.d();
            jiVar.b();
        }
        if (this.f697g != null && k()) {
            jiVar.a(k);
            jiVar.a(this.f697g);
            jiVar.b();
        }
        if (this.f698h != null && l()) {
            jiVar.a(l);
            jiVar.a(this.f698h);
            jiVar.b();
        }
        jiVar.c();
        jiVar.m493a();
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m457b() {
        return this.f687a != null;
    }

    public String c() {
        return this.f695e;
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m458c() {
        return this.f692b != null;
    }

    public String d() {
        return this.f696f;
    }

    /* renamed from: d  reason: collision with other method in class */
    public boolean m459d() {
        return this.f693c != null;
    }

    public String e() {
        return this.f697g;
    }

    /* renamed from: e  reason: collision with other method in class */
    public boolean m460e() {
        return this.f694d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ip)) {
            return m456a((ip) obj);
        }
        return false;
    }

    public String f() {
        return this.f698h;
    }

    /* renamed from: f  reason: collision with other method in class */
    public boolean m461f() {
        return this.f695e != null;
    }

    public boolean g() {
        return this.f696f != null;
    }

    public boolean h() {
        return this.f686a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f689a.get(0);
    }

    public boolean j() {
        return this.f690a != null;
    }

    public boolean k() {
        return this.f697g != null;
    }

    public boolean l() {
        return this.f698h != null;
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionSendMessage(");
        boolean z2 = true;
        if (m455a()) {
            sb.append("debug:");
            if (this.f688a == null) {
                sb.append("null");
            } else {
                sb.append(this.f688a);
            }
            z2 = false;
        }
        if (m457b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f687a == null) {
                sb.append("null");
            } else {
                sb.append(this.f687a);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f692b == null) {
            sb.append("null");
        } else {
            sb.append(this.f692b);
        }
        sb.append(", ");
        sb.append("appId:");
        if (this.f693c == null) {
            sb.append("null");
        } else {
            sb.append(this.f693c);
        }
        if (m460e()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f694d == null) {
                sb.append("null");
            } else {
                sb.append(this.f694d);
            }
        }
        if (m461f()) {
            sb.append(", ");
            sb.append(UrlSchemaHelper.SCHEMA_TYPE_TOPIC);
            if (this.f695e == null) {
                sb.append("null");
            } else {
                sb.append(this.f695e);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("aliasName:");
            if (this.f696f == null) {
                sb.append("null");
            } else {
                sb.append(this.f696f);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("message:");
            if (this.f686a == null) {
                sb.append("null");
            } else {
                sb.append(this.f686a);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("needAck:");
            sb.append(this.f691a);
        }
        if (j()) {
            sb.append(", ");
            sb.append("params:");
            if (this.f690a == null) {
                sb.append("null");
            } else {
                sb.append(this.f690a);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("category:");
            if (this.f697g == null) {
                sb.append("null");
            } else {
                sb.append(this.f697g);
            }
        }
        if (l()) {
            sb.append(", ");
            sb.append("userAccount:");
            if (this.f698h == null) {
                sb.append("null");
            } else {
                sb.append(this.f698h);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
