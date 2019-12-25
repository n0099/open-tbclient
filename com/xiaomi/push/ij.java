package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public class ij implements ir<ij, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public hs f705a;

    /* renamed from: a  reason: collision with other field name */
    public hv f706a;

    /* renamed from: a  reason: collision with other field name */
    public String f707a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f709a;

    /* renamed from: b  reason: collision with other field name */
    public String f711b;

    /* renamed from: c  reason: collision with other field name */
    public String f712c;

    /* renamed from: d  reason: collision with other field name */
    public String f713d;

    /* renamed from: e  reason: collision with other field name */
    public String f714e;

    /* renamed from: f  reason: collision with other field name */
    public String f715f;

    /* renamed from: g  reason: collision with other field name */
    public String f716g;

    /* renamed from: h  reason: collision with other field name */
    public String f717h;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f704a = new jh("XmPushActionSendMessage");
    private static final iz a = new iz("", Constants.GZIP_CAST_TYPE, 1);
    private static final iz b = new iz("", (byte) 12, 2);
    private static final iz c = new iz("", Constants.GZIP_CAST_TYPE, 3);
    private static final iz d = new iz("", Constants.GZIP_CAST_TYPE, 4);
    private static final iz e = new iz("", Constants.GZIP_CAST_TYPE, 5);
    private static final iz f = new iz("", Constants.GZIP_CAST_TYPE, 6);
    private static final iz g = new iz("", Constants.GZIP_CAST_TYPE, 7);
    private static final iz h = new iz("", (byte) 12, 8);
    private static final iz i = new iz("", (byte) 2, 9);
    private static final iz j = new iz("", (byte) 13, 10);
    private static final iz k = new iz("", Constants.GZIP_CAST_TYPE, 11);
    private static final iz l = new iz("", Constants.GZIP_CAST_TYPE, 12);

    /* renamed from: a  reason: collision with other field name */
    private BitSet f708a = new BitSet(1);

    /* renamed from: a  reason: collision with other field name */
    public boolean f710a = true;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(ij ijVar) {
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
        if (getClass().equals(ijVar.getClass())) {
            int compareTo = Boolean.valueOf(m424a()).compareTo(Boolean.valueOf(ijVar.m424a()));
            if (compareTo == 0) {
                if (!m424a() || (a13 = is.a(this.f707a, ijVar.f707a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m426b()).compareTo(Boolean.valueOf(ijVar.m426b()));
                    if (compareTo2 == 0) {
                        if (!m426b() || (a12 = is.a(this.f706a, ijVar.f706a)) == 0) {
                            int compareTo3 = Boolean.valueOf(m427c()).compareTo(Boolean.valueOf(ijVar.m427c()));
                            if (compareTo3 == 0) {
                                if (!m427c() || (a11 = is.a(this.f711b, ijVar.f711b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(m428d()).compareTo(Boolean.valueOf(ijVar.m428d()));
                                    if (compareTo4 == 0) {
                                        if (!m428d() || (a10 = is.a(this.f712c, ijVar.f712c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(m429e()).compareTo(Boolean.valueOf(ijVar.m429e()));
                                            if (compareTo5 == 0) {
                                                if (!m429e() || (a9 = is.a(this.f713d, ijVar.f713d)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(m430f()).compareTo(Boolean.valueOf(ijVar.m430f()));
                                                    if (compareTo6 == 0) {
                                                        if (!m430f() || (a8 = is.a(this.f714e, ijVar.f714e)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ijVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a7 = is.a(this.f715f, ijVar.f715f)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(ijVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a6 = is.a(this.f705a, ijVar.f705a)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(ijVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a5 = is.a(this.f710a, ijVar.f710a)) == 0) {
                                                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(ijVar.j()));
                                                                                    if (compareTo10 == 0) {
                                                                                        if (!j() || (a4 = is.a(this.f709a, ijVar.f709a)) == 0) {
                                                                                            int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(ijVar.k()));
                                                                                            if (compareTo11 == 0) {
                                                                                                if (!k() || (a3 = is.a(this.f716g, ijVar.f716g)) == 0) {
                                                                                                    int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(ijVar.l()));
                                                                                                    if (compareTo12 == 0) {
                                                                                                        if (!l() || (a2 = is.a(this.f717h, ijVar.f717h)) == 0) {
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
        return getClass().getName().compareTo(ijVar.getClass().getName());
    }

    public hs a() {
        return this.f705a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m422a() {
        return this.f711b;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m423a() {
        if (this.f711b == null) {
            throw new jd("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f712c == null) {
            throw new jd("Required field 'appId' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ir
    public void a(jc jcVar) {
        jcVar.m458a();
        while (true) {
            iz m454a = jcVar.m454a();
            if (m454a.a == 0) {
                jcVar.f();
                m423a();
                return;
            }
            switch (m454a.f793a) {
                case 1:
                    if (m454a.a == 11) {
                        this.f707a = jcVar.m459a();
                        break;
                    } else {
                        jf.a(jcVar, m454a.a);
                        break;
                    }
                case 2:
                    if (m454a.a == 12) {
                        this.f706a = new hv();
                        this.f706a.a(jcVar);
                        break;
                    } else {
                        jf.a(jcVar, m454a.a);
                        break;
                    }
                case 3:
                    if (m454a.a == 11) {
                        this.f711b = jcVar.m459a();
                        break;
                    } else {
                        jf.a(jcVar, m454a.a);
                        break;
                    }
                case 4:
                    if (m454a.a == 11) {
                        this.f712c = jcVar.m459a();
                        break;
                    } else {
                        jf.a(jcVar, m454a.a);
                        break;
                    }
                case 5:
                    if (m454a.a == 11) {
                        this.f713d = jcVar.m459a();
                        break;
                    } else {
                        jf.a(jcVar, m454a.a);
                        break;
                    }
                case 6:
                    if (m454a.a == 11) {
                        this.f714e = jcVar.m459a();
                        break;
                    } else {
                        jf.a(jcVar, m454a.a);
                        break;
                    }
                case 7:
                    if (m454a.a == 11) {
                        this.f715f = jcVar.m459a();
                        break;
                    } else {
                        jf.a(jcVar, m454a.a);
                        break;
                    }
                case 8:
                    if (m454a.a == 12) {
                        this.f705a = new hs();
                        this.f705a.a(jcVar);
                        break;
                    } else {
                        jf.a(jcVar, m454a.a);
                        break;
                    }
                case 9:
                    if (m454a.a == 2) {
                        this.f710a = jcVar.m463a();
                        a(true);
                        break;
                    } else {
                        jf.a(jcVar, m454a.a);
                        break;
                    }
                case 10:
                    if (m454a.a == 13) {
                        jb m456a = jcVar.m456a();
                        this.f709a = new HashMap(m456a.f797a * 2);
                        for (int i2 = 0; i2 < m456a.f797a; i2++) {
                            this.f709a.put(jcVar.m459a(), jcVar.m459a());
                        }
                        jcVar.h();
                        break;
                    } else {
                        jf.a(jcVar, m454a.a);
                        break;
                    }
                case 11:
                    if (m454a.a == 11) {
                        this.f716g = jcVar.m459a();
                        break;
                    } else {
                        jf.a(jcVar, m454a.a);
                        break;
                    }
                case 12:
                    if (m454a.a == 11) {
                        this.f717h = jcVar.m459a();
                        break;
                    } else {
                        jf.a(jcVar, m454a.a);
                        break;
                    }
                default:
                    jf.a(jcVar, m454a.a);
                    break;
            }
            jcVar.g();
        }
    }

    public void a(boolean z) {
        this.f708a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m424a() {
        return this.f707a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m425a(ij ijVar) {
        if (ijVar == null) {
            return false;
        }
        boolean m424a = m424a();
        boolean m424a2 = ijVar.m424a();
        if ((m424a || m424a2) && !(m424a && m424a2 && this.f707a.equals(ijVar.f707a))) {
            return false;
        }
        boolean m426b = m426b();
        boolean m426b2 = ijVar.m426b();
        if ((m426b || m426b2) && !(m426b && m426b2 && this.f706a.m364a(ijVar.f706a))) {
            return false;
        }
        boolean m427c = m427c();
        boolean m427c2 = ijVar.m427c();
        if ((m427c || m427c2) && !(m427c && m427c2 && this.f711b.equals(ijVar.f711b))) {
            return false;
        }
        boolean m428d = m428d();
        boolean m428d2 = ijVar.m428d();
        if ((m428d || m428d2) && !(m428d && m428d2 && this.f712c.equals(ijVar.f712c))) {
            return false;
        }
        boolean m429e = m429e();
        boolean m429e2 = ijVar.m429e();
        if ((m429e || m429e2) && !(m429e && m429e2 && this.f713d.equals(ijVar.f713d))) {
            return false;
        }
        boolean m430f = m430f();
        boolean m430f2 = ijVar.m430f();
        if ((m430f || m430f2) && !(m430f && m430f2 && this.f714e.equals(ijVar.f714e))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = ijVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f715f.equals(ijVar.f715f))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = ijVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f705a.m347a(ijVar.f705a))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = ijVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f710a == ijVar.f710a)) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = ijVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f709a.equals(ijVar.f709a))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = ijVar.k();
        if ((k2 || k3) && !(k2 && k3 && this.f716g.equals(ijVar.f716g))) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = ijVar.l();
        return !(l2 || l3) || (l2 && l3 && this.f717h.equals(ijVar.f717h));
    }

    public String b() {
        return this.f712c;
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        m423a();
        jcVar.a(f704a);
        if (this.f707a != null && m424a()) {
            jcVar.a(a);
            jcVar.a(this.f707a);
            jcVar.b();
        }
        if (this.f706a != null && m426b()) {
            jcVar.a(b);
            this.f706a.b(jcVar);
            jcVar.b();
        }
        if (this.f711b != null) {
            jcVar.a(c);
            jcVar.a(this.f711b);
            jcVar.b();
        }
        if (this.f712c != null) {
            jcVar.a(d);
            jcVar.a(this.f712c);
            jcVar.b();
        }
        if (this.f713d != null && m429e()) {
            jcVar.a(e);
            jcVar.a(this.f713d);
            jcVar.b();
        }
        if (this.f714e != null && m430f()) {
            jcVar.a(f);
            jcVar.a(this.f714e);
            jcVar.b();
        }
        if (this.f715f != null && g()) {
            jcVar.a(g);
            jcVar.a(this.f715f);
            jcVar.b();
        }
        if (this.f705a != null && h()) {
            jcVar.a(h);
            this.f705a.b(jcVar);
            jcVar.b();
        }
        if (i()) {
            jcVar.a(i);
            jcVar.a(this.f710a);
            jcVar.b();
        }
        if (this.f709a != null && j()) {
            jcVar.a(j);
            jcVar.a(new jb(Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, this.f709a.size()));
            for (Map.Entry<String, String> entry : this.f709a.entrySet()) {
                jcVar.a(entry.getKey());
                jcVar.a(entry.getValue());
            }
            jcVar.d();
            jcVar.b();
        }
        if (this.f716g != null && k()) {
            jcVar.a(k);
            jcVar.a(this.f716g);
            jcVar.b();
        }
        if (this.f717h != null && l()) {
            jcVar.a(l);
            jcVar.a(this.f717h);
            jcVar.b();
        }
        jcVar.c();
        jcVar.m462a();
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m426b() {
        return this.f706a != null;
    }

    public String c() {
        return this.f714e;
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m427c() {
        return this.f711b != null;
    }

    public String d() {
        return this.f715f;
    }

    /* renamed from: d  reason: collision with other method in class */
    public boolean m428d() {
        return this.f712c != null;
    }

    public String e() {
        return this.f716g;
    }

    /* renamed from: e  reason: collision with other method in class */
    public boolean m429e() {
        return this.f713d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ij)) {
            return m425a((ij) obj);
        }
        return false;
    }

    public String f() {
        return this.f717h;
    }

    /* renamed from: f  reason: collision with other method in class */
    public boolean m430f() {
        return this.f714e != null;
    }

    public boolean g() {
        return this.f715f != null;
    }

    public boolean h() {
        return this.f705a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f708a.get(0);
    }

    public boolean j() {
        return this.f709a != null;
    }

    public boolean k() {
        return this.f716g != null;
    }

    public boolean l() {
        return this.f717h != null;
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionSendMessage(");
        boolean z2 = true;
        if (m424a()) {
            sb.append("debug:");
            if (this.f707a == null) {
                sb.append("null");
            } else {
                sb.append(this.f707a);
            }
            z2 = false;
        }
        if (m426b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f706a == null) {
                sb.append("null");
            } else {
                sb.append(this.f706a);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f711b == null) {
            sb.append("null");
        } else {
            sb.append(this.f711b);
        }
        sb.append(", ");
        sb.append("appId:");
        if (this.f712c == null) {
            sb.append("null");
        } else {
            sb.append(this.f712c);
        }
        if (m429e()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f713d == null) {
                sb.append("null");
            } else {
                sb.append(this.f713d);
            }
        }
        if (m430f()) {
            sb.append(", ");
            sb.append(UrlSchemaHelper.SCHEMA_TYPE_TOPIC);
            if (this.f714e == null) {
                sb.append("null");
            } else {
                sb.append(this.f714e);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("aliasName:");
            if (this.f715f == null) {
                sb.append("null");
            } else {
                sb.append(this.f715f);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("message:");
            if (this.f705a == null) {
                sb.append("null");
            } else {
                sb.append(this.f705a);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("needAck:");
            sb.append(this.f710a);
        }
        if (j()) {
            sb.append(", ");
            sb.append("params:");
            if (this.f709a == null) {
                sb.append("null");
            } else {
                sb.append(this.f709a);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("category:");
            if (this.f716g == null) {
                sb.append("null");
            } else {
                sb.append(this.f716g);
            }
        }
        if (l()) {
            sb.append(", ");
            sb.append("userAccount:");
            if (this.f717h == null) {
                sb.append("null");
            } else {
                sb.append(this.f717h);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
