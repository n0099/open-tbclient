package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
/* loaded from: classes6.dex */
public class ia implements ir<ia, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f590a;

    /* renamed from: a  reason: collision with other field name */
    public hv f591a;

    /* renamed from: a  reason: collision with other field name */
    public String f592a;

    /* renamed from: a  reason: collision with other field name */
    public List<String> f594a;

    /* renamed from: b  reason: collision with other field name */
    public String f596b;

    /* renamed from: c  reason: collision with other field name */
    public String f598c;

    /* renamed from: d  reason: collision with other field name */
    public String f599d;

    /* renamed from: e  reason: collision with other field name */
    public String f600e;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f589a = new jh("XmPushActionCommand");
    private static final iz a = new iz("", (byte) 12, 2);
    private static final iz b = new iz("", Constants.GZIP_CAST_TYPE, 3);
    private static final iz c = new iz("", Constants.GZIP_CAST_TYPE, 4);
    private static final iz d = new iz("", Constants.GZIP_CAST_TYPE, 5);
    private static final iz e = new iz("", (byte) 15, 6);
    private static final iz f = new iz("", Constants.GZIP_CAST_TYPE, 7);
    private static final iz g = new iz("", Constants.GZIP_CAST_TYPE, 9);
    private static final iz h = new iz("", (byte) 2, 10);
    private static final iz i = new iz("", (byte) 2, 11);
    private static final iz j = new iz("", (byte) 10, 12);

    /* renamed from: a  reason: collision with other field name */
    private BitSet f593a = new BitSet(3);

    /* renamed from: a  reason: collision with other field name */
    public boolean f595a = false;

    /* renamed from: b  reason: collision with other field name */
    public boolean f597b = true;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(ia iaVar) {
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
        if (getClass().equals(iaVar.getClass())) {
            int compareTo = Boolean.valueOf(m389a()).compareTo(Boolean.valueOf(iaVar.m389a()));
            if (compareTo == 0) {
                if (!m389a() || (a11 = is.a(this.f591a, iaVar.f591a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(iaVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a10 = is.a(this.f592a, iaVar.f592a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(iaVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a9 = is.a(this.f596b, iaVar.f596b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(iaVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a8 = is.a(this.f598c, iaVar.f598c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(iaVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a7 = is.a(this.f594a, iaVar.f594a)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(iaVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a6 = is.a(this.f599d, iaVar.f599d)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(iaVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a5 = is.a(this.f600e, iaVar.f600e)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(iaVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a4 = is.a(this.f595a, iaVar.f595a)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(iaVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a3 = is.a(this.f597b, iaVar.f597b)) == 0) {
                                                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(iaVar.j()));
                                                                                    if (compareTo10 == 0) {
                                                                                        if (!j() || (a2 = is.a(this.f590a, iaVar.f590a)) == 0) {
                                                                                            return 0;
                                                                                        }
                                                                                        return a2;
                                                                                    }
                                                                                    return compareTo10;
                                                                                }
                                                                                return a3;
                                                                            }
                                                                            return compareTo9;
                                                                        }
                                                                        return a4;
                                                                    }
                                                                    return compareTo8;
                                                                }
                                                                return a5;
                                                            }
                                                            return compareTo7;
                                                        }
                                                        return a6;
                                                    }
                                                    return compareTo6;
                                                }
                                                return a7;
                                            }
                                            return compareTo5;
                                        }
                                        return a8;
                                    }
                                    return compareTo4;
                                }
                                return a9;
                            }
                            return compareTo3;
                        }
                        return a10;
                    }
                    return compareTo2;
                }
                return a11;
            }
            return compareTo;
        }
        return getClass().getName().compareTo(iaVar.getClass().getName());
    }

    public ia a(String str) {
        this.f592a = str;
        return this;
    }

    public ia a(List<String> list) {
        this.f594a = list;
        return this;
    }

    public String a() {
        return this.f598c;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m387a() {
        if (this.f592a == null) {
            throw new jd("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f596b == null) {
            throw new jd("Required field 'appId' was not present! Struct: " + toString());
        }
        if (this.f598c == null) {
            throw new jd("Required field 'cmdName' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ir
    public void a(jc jcVar) {
        jcVar.m467a();
        while (true) {
            iz m463a = jcVar.m463a();
            if (m463a.a == 0) {
                jcVar.f();
                m387a();
                return;
            }
            switch (m463a.f792a) {
                case 2:
                    if (m463a.a == 12) {
                        this.f591a = new hv();
                        this.f591a.a(jcVar);
                        break;
                    } else {
                        jf.a(jcVar, m463a.a);
                        break;
                    }
                case 3:
                    if (m463a.a == 11) {
                        this.f592a = jcVar.m468a();
                        break;
                    } else {
                        jf.a(jcVar, m463a.a);
                        break;
                    }
                case 4:
                    if (m463a.a == 11) {
                        this.f596b = jcVar.m468a();
                        break;
                    } else {
                        jf.a(jcVar, m463a.a);
                        break;
                    }
                case 5:
                    if (m463a.a == 11) {
                        this.f598c = jcVar.m468a();
                        break;
                    } else {
                        jf.a(jcVar, m463a.a);
                        break;
                    }
                case 6:
                    if (m463a.a == 15) {
                        ja m464a = jcVar.m464a();
                        this.f594a = new ArrayList(m464a.f795a);
                        for (int i2 = 0; i2 < m464a.f795a; i2++) {
                            this.f594a.add(jcVar.m468a());
                        }
                        jcVar.i();
                        break;
                    } else {
                        jf.a(jcVar, m463a.a);
                        break;
                    }
                case 7:
                    if (m463a.a == 11) {
                        this.f599d = jcVar.m468a();
                        break;
                    } else {
                        jf.a(jcVar, m463a.a);
                        break;
                    }
                case 8:
                default:
                    jf.a(jcVar, m463a.a);
                    break;
                case 9:
                    if (m463a.a == 11) {
                        this.f600e = jcVar.m468a();
                        break;
                    } else {
                        jf.a(jcVar, m463a.a);
                        break;
                    }
                case 10:
                    if (m463a.a == 2) {
                        this.f595a = jcVar.m472a();
                        a(true);
                        break;
                    } else {
                        jf.a(jcVar, m463a.a);
                        break;
                    }
                case 11:
                    if (m463a.a == 2) {
                        this.f597b = jcVar.m472a();
                        b(true);
                        break;
                    } else {
                        jf.a(jcVar, m463a.a);
                        break;
                    }
                case 12:
                    if (m463a.a == 10) {
                        this.f590a = jcVar.m462a();
                        c(true);
                        break;
                    } else {
                        jf.a(jcVar, m463a.a);
                        break;
                    }
            }
            jcVar.g();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m388a(String str) {
        if (this.f594a == null) {
            this.f594a = new ArrayList();
        }
        this.f594a.add(str);
    }

    public void a(boolean z) {
        this.f593a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m389a() {
        return this.f591a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m390a(ia iaVar) {
        if (iaVar == null) {
            return false;
        }
        boolean m389a = m389a();
        boolean m389a2 = iaVar.m389a();
        if ((m389a || m389a2) && !(m389a && m389a2 && this.f591a.m373a(iaVar.f591a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = iaVar.b();
        if ((b2 || b3) && !(b2 && b3 && this.f592a.equals(iaVar.f592a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = iaVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f596b.equals(iaVar.f596b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = iaVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f598c.equals(iaVar.f598c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = iaVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f594a.equals(iaVar.f594a))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = iaVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f599d.equals(iaVar.f599d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = iaVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f600e.equals(iaVar.f600e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = iaVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f595a == iaVar.f595a)) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = iaVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f597b == iaVar.f597b)) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = iaVar.j();
        return !(j2 || j3) || (j2 && j3 && this.f590a == iaVar.f590a);
    }

    public ia b(String str) {
        this.f596b = str;
        return this;
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        m387a();
        jcVar.a(f589a);
        if (this.f591a != null && m389a()) {
            jcVar.a(a);
            this.f591a.b(jcVar);
            jcVar.b();
        }
        if (this.f592a != null) {
            jcVar.a(b);
            jcVar.a(this.f592a);
            jcVar.b();
        }
        if (this.f596b != null) {
            jcVar.a(c);
            jcVar.a(this.f596b);
            jcVar.b();
        }
        if (this.f598c != null) {
            jcVar.a(d);
            jcVar.a(this.f598c);
            jcVar.b();
        }
        if (this.f594a != null && e()) {
            jcVar.a(e);
            jcVar.a(new ja(Constants.GZIP_CAST_TYPE, this.f594a.size()));
            for (String str : this.f594a) {
                jcVar.a(str);
            }
            jcVar.e();
            jcVar.b();
        }
        if (this.f599d != null && f()) {
            jcVar.a(f);
            jcVar.a(this.f599d);
            jcVar.b();
        }
        if (this.f600e != null && g()) {
            jcVar.a(g);
            jcVar.a(this.f600e);
            jcVar.b();
        }
        if (h()) {
            jcVar.a(h);
            jcVar.a(this.f595a);
            jcVar.b();
        }
        if (i()) {
            jcVar.a(i);
            jcVar.a(this.f597b);
            jcVar.b();
        }
        if (j()) {
            jcVar.a(j);
            jcVar.a(this.f590a);
            jcVar.b();
        }
        jcVar.c();
        jcVar.m471a();
    }

    public void b(boolean z) {
        this.f593a.set(1, z);
    }

    public boolean b() {
        return this.f592a != null;
    }

    public ia c(String str) {
        this.f598c = str;
        return this;
    }

    public void c(boolean z) {
        this.f593a.set(2, z);
    }

    public boolean c() {
        return this.f596b != null;
    }

    public ia d(String str) {
        this.f599d = str;
        return this;
    }

    public boolean d() {
        return this.f598c != null;
    }

    public ia e(String str) {
        this.f600e = str;
        return this;
    }

    public boolean e() {
        return this.f594a != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ia)) {
            return m390a((ia) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f599d != null;
    }

    public boolean g() {
        return this.f600e != null;
    }

    public boolean h() {
        return this.f593a.get(0);
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f593a.get(1);
    }

    public boolean j() {
        return this.f593a.get(2);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionCommand(");
        boolean z = true;
        if (m389a()) {
            sb.append("target:");
            if (this.f591a == null) {
                sb.append("null");
            } else {
                sb.append(this.f591a);
            }
            z = false;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f592a == null) {
            sb.append("null");
        } else {
            sb.append(this.f592a);
        }
        sb.append(", ");
        sb.append("appId:");
        if (this.f596b == null) {
            sb.append("null");
        } else {
            sb.append(this.f596b);
        }
        sb.append(", ");
        sb.append("cmdName:");
        if (this.f598c == null) {
            sb.append("null");
        } else {
            sb.append(this.f598c);
        }
        if (e()) {
            sb.append(", ");
            sb.append("cmdArgs:");
            if (this.f594a == null) {
                sb.append("null");
            } else {
                sb.append(this.f594a);
            }
        }
        if (f()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f599d == null) {
                sb.append("null");
            } else {
                sb.append(this.f599d);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("category:");
            if (this.f600e == null) {
                sb.append("null");
            } else {
                sb.append(this.f600e);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("updateCache:");
            sb.append(this.f595a);
        }
        if (i()) {
            sb.append(", ");
            sb.append("response2Client:");
            sb.append(this.f597b);
        }
        if (j()) {
            sb.append(", ");
            sb.append("createdTs:");
            sb.append(this.f590a);
        }
        sb.append(")");
        return sb.toString();
    }
}
