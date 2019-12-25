package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
/* loaded from: classes5.dex */
public class ia implements ir<ia, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f591a;

    /* renamed from: a  reason: collision with other field name */
    public hv f592a;

    /* renamed from: a  reason: collision with other field name */
    public String f593a;

    /* renamed from: a  reason: collision with other field name */
    public List<String> f595a;

    /* renamed from: b  reason: collision with other field name */
    public String f597b;

    /* renamed from: c  reason: collision with other field name */
    public String f599c;

    /* renamed from: d  reason: collision with other field name */
    public String f600d;

    /* renamed from: e  reason: collision with other field name */
    public String f601e;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f590a = new jh("XmPushActionCommand");
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
    private BitSet f594a = new BitSet(3);

    /* renamed from: a  reason: collision with other field name */
    public boolean f596a = false;

    /* renamed from: b  reason: collision with other field name */
    public boolean f598b = true;

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
            int compareTo = Boolean.valueOf(m380a()).compareTo(Boolean.valueOf(iaVar.m380a()));
            if (compareTo == 0) {
                if (!m380a() || (a11 = is.a(this.f592a, iaVar.f592a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(iaVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a10 = is.a(this.f593a, iaVar.f593a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(iaVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a9 = is.a(this.f597b, iaVar.f597b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(iaVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a8 = is.a(this.f599c, iaVar.f599c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(iaVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a7 = is.a(this.f595a, iaVar.f595a)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(iaVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a6 = is.a(this.f600d, iaVar.f600d)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(iaVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a5 = is.a(this.f601e, iaVar.f601e)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(iaVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a4 = is.a(this.f596a, iaVar.f596a)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(iaVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a3 = is.a(this.f598b, iaVar.f598b)) == 0) {
                                                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(iaVar.j()));
                                                                                    if (compareTo10 == 0) {
                                                                                        if (!j() || (a2 = is.a(this.f591a, iaVar.f591a)) == 0) {
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
        this.f593a = str;
        return this;
    }

    public ia a(List<String> list) {
        this.f595a = list;
        return this;
    }

    public String a() {
        return this.f599c;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m378a() {
        if (this.f593a == null) {
            throw new jd("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f597b == null) {
            throw new jd("Required field 'appId' was not present! Struct: " + toString());
        }
        if (this.f599c == null) {
            throw new jd("Required field 'cmdName' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ir
    public void a(jc jcVar) {
        jcVar.m458a();
        while (true) {
            iz m454a = jcVar.m454a();
            if (m454a.a == 0) {
                jcVar.f();
                m378a();
                return;
            }
            switch (m454a.f793a) {
                case 2:
                    if (m454a.a == 12) {
                        this.f592a = new hv();
                        this.f592a.a(jcVar);
                        break;
                    } else {
                        jf.a(jcVar, m454a.a);
                        break;
                    }
                case 3:
                    if (m454a.a == 11) {
                        this.f593a = jcVar.m459a();
                        break;
                    } else {
                        jf.a(jcVar, m454a.a);
                        break;
                    }
                case 4:
                    if (m454a.a == 11) {
                        this.f597b = jcVar.m459a();
                        break;
                    } else {
                        jf.a(jcVar, m454a.a);
                        break;
                    }
                case 5:
                    if (m454a.a == 11) {
                        this.f599c = jcVar.m459a();
                        break;
                    } else {
                        jf.a(jcVar, m454a.a);
                        break;
                    }
                case 6:
                    if (m454a.a == 15) {
                        ja m455a = jcVar.m455a();
                        this.f595a = new ArrayList(m455a.f796a);
                        for (int i2 = 0; i2 < m455a.f796a; i2++) {
                            this.f595a.add(jcVar.m459a());
                        }
                        jcVar.i();
                        break;
                    } else {
                        jf.a(jcVar, m454a.a);
                        break;
                    }
                case 7:
                    if (m454a.a == 11) {
                        this.f600d = jcVar.m459a();
                        break;
                    } else {
                        jf.a(jcVar, m454a.a);
                        break;
                    }
                case 8:
                default:
                    jf.a(jcVar, m454a.a);
                    break;
                case 9:
                    if (m454a.a == 11) {
                        this.f601e = jcVar.m459a();
                        break;
                    } else {
                        jf.a(jcVar, m454a.a);
                        break;
                    }
                case 10:
                    if (m454a.a == 2) {
                        this.f596a = jcVar.m463a();
                        a(true);
                        break;
                    } else {
                        jf.a(jcVar, m454a.a);
                        break;
                    }
                case 11:
                    if (m454a.a == 2) {
                        this.f598b = jcVar.m463a();
                        b(true);
                        break;
                    } else {
                        jf.a(jcVar, m454a.a);
                        break;
                    }
                case 12:
                    if (m454a.a == 10) {
                        this.f591a = jcVar.m453a();
                        c(true);
                        break;
                    } else {
                        jf.a(jcVar, m454a.a);
                        break;
                    }
            }
            jcVar.g();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m379a(String str) {
        if (this.f595a == null) {
            this.f595a = new ArrayList();
        }
        this.f595a.add(str);
    }

    public void a(boolean z) {
        this.f594a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m380a() {
        return this.f592a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m381a(ia iaVar) {
        if (iaVar == null) {
            return false;
        }
        boolean m380a = m380a();
        boolean m380a2 = iaVar.m380a();
        if ((m380a || m380a2) && !(m380a && m380a2 && this.f592a.m364a(iaVar.f592a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = iaVar.b();
        if ((b2 || b3) && !(b2 && b3 && this.f593a.equals(iaVar.f593a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = iaVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f597b.equals(iaVar.f597b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = iaVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f599c.equals(iaVar.f599c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = iaVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f595a.equals(iaVar.f595a))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = iaVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f600d.equals(iaVar.f600d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = iaVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f601e.equals(iaVar.f601e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = iaVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f596a == iaVar.f596a)) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = iaVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f598b == iaVar.f598b)) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = iaVar.j();
        return !(j2 || j3) || (j2 && j3 && this.f591a == iaVar.f591a);
    }

    public ia b(String str) {
        this.f597b = str;
        return this;
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        m378a();
        jcVar.a(f590a);
        if (this.f592a != null && m380a()) {
            jcVar.a(a);
            this.f592a.b(jcVar);
            jcVar.b();
        }
        if (this.f593a != null) {
            jcVar.a(b);
            jcVar.a(this.f593a);
            jcVar.b();
        }
        if (this.f597b != null) {
            jcVar.a(c);
            jcVar.a(this.f597b);
            jcVar.b();
        }
        if (this.f599c != null) {
            jcVar.a(d);
            jcVar.a(this.f599c);
            jcVar.b();
        }
        if (this.f595a != null && e()) {
            jcVar.a(e);
            jcVar.a(new ja(Constants.GZIP_CAST_TYPE, this.f595a.size()));
            for (String str : this.f595a) {
                jcVar.a(str);
            }
            jcVar.e();
            jcVar.b();
        }
        if (this.f600d != null && f()) {
            jcVar.a(f);
            jcVar.a(this.f600d);
            jcVar.b();
        }
        if (this.f601e != null && g()) {
            jcVar.a(g);
            jcVar.a(this.f601e);
            jcVar.b();
        }
        if (h()) {
            jcVar.a(h);
            jcVar.a(this.f596a);
            jcVar.b();
        }
        if (i()) {
            jcVar.a(i);
            jcVar.a(this.f598b);
            jcVar.b();
        }
        if (j()) {
            jcVar.a(j);
            jcVar.a(this.f591a);
            jcVar.b();
        }
        jcVar.c();
        jcVar.m462a();
    }

    public void b(boolean z) {
        this.f594a.set(1, z);
    }

    public boolean b() {
        return this.f593a != null;
    }

    public ia c(String str) {
        this.f599c = str;
        return this;
    }

    public void c(boolean z) {
        this.f594a.set(2, z);
    }

    public boolean c() {
        return this.f597b != null;
    }

    public ia d(String str) {
        this.f600d = str;
        return this;
    }

    public boolean d() {
        return this.f599c != null;
    }

    public ia e(String str) {
        this.f601e = str;
        return this;
    }

    public boolean e() {
        return this.f595a != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ia)) {
            return m381a((ia) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f600d != null;
    }

    public boolean g() {
        return this.f601e != null;
    }

    public boolean h() {
        return this.f594a.get(0);
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f594a.get(1);
    }

    public boolean j() {
        return this.f594a.get(2);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionCommand(");
        boolean z = true;
        if (m380a()) {
            sb.append("target:");
            if (this.f592a == null) {
                sb.append("null");
            } else {
                sb.append(this.f592a);
            }
            z = false;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f593a == null) {
            sb.append("null");
        } else {
            sb.append(this.f593a);
        }
        sb.append(", ");
        sb.append("appId:");
        if (this.f597b == null) {
            sb.append("null");
        } else {
            sb.append(this.f597b);
        }
        sb.append(", ");
        sb.append("cmdName:");
        if (this.f599c == null) {
            sb.append("null");
        } else {
            sb.append(this.f599c);
        }
        if (e()) {
            sb.append(", ");
            sb.append("cmdArgs:");
            if (this.f595a == null) {
                sb.append("null");
            } else {
                sb.append(this.f595a);
            }
        }
        if (f()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f600d == null) {
                sb.append("null");
            } else {
                sb.append(this.f600d);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("category:");
            if (this.f601e == null) {
                sb.append("null");
            } else {
                sb.append(this.f601e);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("updateCache:");
            sb.append(this.f596a);
        }
        if (i()) {
            sb.append(", ");
            sb.append("response2Client:");
            sb.append(this.f598b);
        }
        if (j()) {
            sb.append(", ");
            sb.append("createdTs:");
            sb.append(this.f591a);
        }
        sb.append(")");
        return sb.toString();
    }
}
