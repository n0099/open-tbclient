package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class ij implements ir<ij, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public hs f703a;

    /* renamed from: a  reason: collision with other field name */
    public hv f704a;

    /* renamed from: a  reason: collision with other field name */
    public String f705a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f707a;

    /* renamed from: b  reason: collision with other field name */
    public String f709b;

    /* renamed from: c  reason: collision with other field name */
    public String f710c;

    /* renamed from: d  reason: collision with other field name */
    public String f711d;

    /* renamed from: e  reason: collision with other field name */
    public String f712e;

    /* renamed from: f  reason: collision with other field name */
    public String f713f;

    /* renamed from: g  reason: collision with other field name */
    public String f714g;

    /* renamed from: h  reason: collision with other field name */
    public String f715h;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f702a = new jh("XmPushActionSendMessage");
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
    private BitSet f706a = new BitSet(1);

    /* renamed from: a  reason: collision with other field name */
    public boolean f708a = true;

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
            int compareTo = Boolean.valueOf(m433a()).compareTo(Boolean.valueOf(ijVar.m433a()));
            if (compareTo == 0) {
                if (!m433a() || (a13 = is.a(this.f705a, ijVar.f705a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m435b()).compareTo(Boolean.valueOf(ijVar.m435b()));
                    if (compareTo2 == 0) {
                        if (!m435b() || (a12 = is.a(this.f704a, ijVar.f704a)) == 0) {
                            int compareTo3 = Boolean.valueOf(m436c()).compareTo(Boolean.valueOf(ijVar.m436c()));
                            if (compareTo3 == 0) {
                                if (!m436c() || (a11 = is.a(this.f709b, ijVar.f709b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(m437d()).compareTo(Boolean.valueOf(ijVar.m437d()));
                                    if (compareTo4 == 0) {
                                        if (!m437d() || (a10 = is.a(this.f710c, ijVar.f710c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(m438e()).compareTo(Boolean.valueOf(ijVar.m438e()));
                                            if (compareTo5 == 0) {
                                                if (!m438e() || (a9 = is.a(this.f711d, ijVar.f711d)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(m439f()).compareTo(Boolean.valueOf(ijVar.m439f()));
                                                    if (compareTo6 == 0) {
                                                        if (!m439f() || (a8 = is.a(this.f712e, ijVar.f712e)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ijVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a7 = is.a(this.f713f, ijVar.f713f)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(ijVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a6 = is.a(this.f703a, ijVar.f703a)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(ijVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a5 = is.a(this.f708a, ijVar.f708a)) == 0) {
                                                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(ijVar.j()));
                                                                                    if (compareTo10 == 0) {
                                                                                        if (!j() || (a4 = is.a(this.f707a, ijVar.f707a)) == 0) {
                                                                                            int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(ijVar.k()));
                                                                                            if (compareTo11 == 0) {
                                                                                                if (!k() || (a3 = is.a(this.f714g, ijVar.f714g)) == 0) {
                                                                                                    int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(ijVar.l()));
                                                                                                    if (compareTo12 == 0) {
                                                                                                        if (!l() || (a2 = is.a(this.f715h, ijVar.f715h)) == 0) {
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
        return this.f703a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m431a() {
        return this.f709b;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m432a() {
        if (this.f709b == null) {
            throw new jd("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f710c == null) {
            throw new jd("Required field 'appId' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ir
    public void a(jc jcVar) {
        jcVar.m467a();
        while (true) {
            iz m463a = jcVar.m463a();
            if (m463a.a == 0) {
                jcVar.f();
                m432a();
                return;
            }
            switch (m463a.f791a) {
                case 1:
                    if (m463a.a == 11) {
                        this.f705a = jcVar.m468a();
                        break;
                    } else {
                        jf.a(jcVar, m463a.a);
                        break;
                    }
                case 2:
                    if (m463a.a == 12) {
                        this.f704a = new hv();
                        this.f704a.a(jcVar);
                        break;
                    } else {
                        jf.a(jcVar, m463a.a);
                        break;
                    }
                case 3:
                    if (m463a.a == 11) {
                        this.f709b = jcVar.m468a();
                        break;
                    } else {
                        jf.a(jcVar, m463a.a);
                        break;
                    }
                case 4:
                    if (m463a.a == 11) {
                        this.f710c = jcVar.m468a();
                        break;
                    } else {
                        jf.a(jcVar, m463a.a);
                        break;
                    }
                case 5:
                    if (m463a.a == 11) {
                        this.f711d = jcVar.m468a();
                        break;
                    } else {
                        jf.a(jcVar, m463a.a);
                        break;
                    }
                case 6:
                    if (m463a.a == 11) {
                        this.f712e = jcVar.m468a();
                        break;
                    } else {
                        jf.a(jcVar, m463a.a);
                        break;
                    }
                case 7:
                    if (m463a.a == 11) {
                        this.f713f = jcVar.m468a();
                        break;
                    } else {
                        jf.a(jcVar, m463a.a);
                        break;
                    }
                case 8:
                    if (m463a.a == 12) {
                        this.f703a = new hs();
                        this.f703a.a(jcVar);
                        break;
                    } else {
                        jf.a(jcVar, m463a.a);
                        break;
                    }
                case 9:
                    if (m463a.a == 2) {
                        this.f708a = jcVar.m472a();
                        a(true);
                        break;
                    } else {
                        jf.a(jcVar, m463a.a);
                        break;
                    }
                case 10:
                    if (m463a.a == 13) {
                        jb m465a = jcVar.m465a();
                        this.f707a = new HashMap(m465a.f795a * 2);
                        for (int i2 = 0; i2 < m465a.f795a; i2++) {
                            this.f707a.put(jcVar.m468a(), jcVar.m468a());
                        }
                        jcVar.h();
                        break;
                    } else {
                        jf.a(jcVar, m463a.a);
                        break;
                    }
                case 11:
                    if (m463a.a == 11) {
                        this.f714g = jcVar.m468a();
                        break;
                    } else {
                        jf.a(jcVar, m463a.a);
                        break;
                    }
                case 12:
                    if (m463a.a == 11) {
                        this.f715h = jcVar.m468a();
                        break;
                    } else {
                        jf.a(jcVar, m463a.a);
                        break;
                    }
                default:
                    jf.a(jcVar, m463a.a);
                    break;
            }
            jcVar.g();
        }
    }

    public void a(boolean z) {
        this.f706a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m433a() {
        return this.f705a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m434a(ij ijVar) {
        if (ijVar == null) {
            return false;
        }
        boolean m433a = m433a();
        boolean m433a2 = ijVar.m433a();
        if ((m433a || m433a2) && !(m433a && m433a2 && this.f705a.equals(ijVar.f705a))) {
            return false;
        }
        boolean m435b = m435b();
        boolean m435b2 = ijVar.m435b();
        if ((m435b || m435b2) && !(m435b && m435b2 && this.f704a.m373a(ijVar.f704a))) {
            return false;
        }
        boolean m436c = m436c();
        boolean m436c2 = ijVar.m436c();
        if ((m436c || m436c2) && !(m436c && m436c2 && this.f709b.equals(ijVar.f709b))) {
            return false;
        }
        boolean m437d = m437d();
        boolean m437d2 = ijVar.m437d();
        if ((m437d || m437d2) && !(m437d && m437d2 && this.f710c.equals(ijVar.f710c))) {
            return false;
        }
        boolean m438e = m438e();
        boolean m438e2 = ijVar.m438e();
        if ((m438e || m438e2) && !(m438e && m438e2 && this.f711d.equals(ijVar.f711d))) {
            return false;
        }
        boolean m439f = m439f();
        boolean m439f2 = ijVar.m439f();
        if ((m439f || m439f2) && !(m439f && m439f2 && this.f712e.equals(ijVar.f712e))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = ijVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f713f.equals(ijVar.f713f))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = ijVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f703a.m356a(ijVar.f703a))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = ijVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f708a == ijVar.f708a)) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = ijVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f707a.equals(ijVar.f707a))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = ijVar.k();
        if ((k2 || k3) && !(k2 && k3 && this.f714g.equals(ijVar.f714g))) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = ijVar.l();
        return !(l2 || l3) || (l2 && l3 && this.f715h.equals(ijVar.f715h));
    }

    public String b() {
        return this.f710c;
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        m432a();
        jcVar.a(f702a);
        if (this.f705a != null && m433a()) {
            jcVar.a(a);
            jcVar.a(this.f705a);
            jcVar.b();
        }
        if (this.f704a != null && m435b()) {
            jcVar.a(b);
            this.f704a.b(jcVar);
            jcVar.b();
        }
        if (this.f709b != null) {
            jcVar.a(c);
            jcVar.a(this.f709b);
            jcVar.b();
        }
        if (this.f710c != null) {
            jcVar.a(d);
            jcVar.a(this.f710c);
            jcVar.b();
        }
        if (this.f711d != null && m438e()) {
            jcVar.a(e);
            jcVar.a(this.f711d);
            jcVar.b();
        }
        if (this.f712e != null && m439f()) {
            jcVar.a(f);
            jcVar.a(this.f712e);
            jcVar.b();
        }
        if (this.f713f != null && g()) {
            jcVar.a(g);
            jcVar.a(this.f713f);
            jcVar.b();
        }
        if (this.f703a != null && h()) {
            jcVar.a(h);
            this.f703a.b(jcVar);
            jcVar.b();
        }
        if (i()) {
            jcVar.a(i);
            jcVar.a(this.f708a);
            jcVar.b();
        }
        if (this.f707a != null && j()) {
            jcVar.a(j);
            jcVar.a(new jb(Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, this.f707a.size()));
            for (Map.Entry<String, String> entry : this.f707a.entrySet()) {
                jcVar.a(entry.getKey());
                jcVar.a(entry.getValue());
            }
            jcVar.d();
            jcVar.b();
        }
        if (this.f714g != null && k()) {
            jcVar.a(k);
            jcVar.a(this.f714g);
            jcVar.b();
        }
        if (this.f715h != null && l()) {
            jcVar.a(l);
            jcVar.a(this.f715h);
            jcVar.b();
        }
        jcVar.c();
        jcVar.m471a();
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m435b() {
        return this.f704a != null;
    }

    public String c() {
        return this.f712e;
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m436c() {
        return this.f709b != null;
    }

    public String d() {
        return this.f713f;
    }

    /* renamed from: d  reason: collision with other method in class */
    public boolean m437d() {
        return this.f710c != null;
    }

    public String e() {
        return this.f714g;
    }

    /* renamed from: e  reason: collision with other method in class */
    public boolean m438e() {
        return this.f711d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ij)) {
            return m434a((ij) obj);
        }
        return false;
    }

    public String f() {
        return this.f715h;
    }

    /* renamed from: f  reason: collision with other method in class */
    public boolean m439f() {
        return this.f712e != null;
    }

    public boolean g() {
        return this.f713f != null;
    }

    public boolean h() {
        return this.f703a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f706a.get(0);
    }

    public boolean j() {
        return this.f707a != null;
    }

    public boolean k() {
        return this.f714g != null;
    }

    public boolean l() {
        return this.f715h != null;
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionSendMessage(");
        boolean z2 = true;
        if (m433a()) {
            sb.append("debug:");
            if (this.f705a == null) {
                sb.append("null");
            } else {
                sb.append(this.f705a);
            }
            z2 = false;
        }
        if (m435b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f704a == null) {
                sb.append("null");
            } else {
                sb.append(this.f704a);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f709b == null) {
            sb.append("null");
        } else {
            sb.append(this.f709b);
        }
        sb.append(", ");
        sb.append("appId:");
        if (this.f710c == null) {
            sb.append("null");
        } else {
            sb.append(this.f710c);
        }
        if (m438e()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f711d == null) {
                sb.append("null");
            } else {
                sb.append(this.f711d);
            }
        }
        if (m439f()) {
            sb.append(", ");
            sb.append(UrlSchemaHelper.SCHEMA_TYPE_TOPIC);
            if (this.f712e == null) {
                sb.append("null");
            } else {
                sb.append(this.f712e);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("aliasName:");
            if (this.f713f == null) {
                sb.append("null");
            } else {
                sb.append(this.f713f);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("message:");
            if (this.f703a == null) {
                sb.append("null");
            } else {
                sb.append(this.f703a);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("needAck:");
            sb.append(this.f708a);
        }
        if (j()) {
            sb.append(", ");
            sb.append("params:");
            if (this.f707a == null) {
                sb.append("null");
            } else {
                sb.append(this.f707a);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("category:");
            if (this.f714g == null) {
                sb.append("null");
            } else {
                sb.append(this.f714g);
            }
        }
        if (l()) {
            sb.append(", ");
            sb.append("userAccount:");
            if (this.f715h == null) {
                sb.append("null");
            } else {
                sb.append(this.f715h);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
