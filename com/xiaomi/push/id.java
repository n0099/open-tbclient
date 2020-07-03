package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes8.dex */
public class id implements ix<id, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public ib f562a;

    /* renamed from: a  reason: collision with other field name */
    public String f563a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f565a;

    /* renamed from: b  reason: collision with other field name */
    public String f566b;

    /* renamed from: c  reason: collision with other field name */
    public String f567c;

    /* renamed from: d  reason: collision with other field name */
    public String f568d;

    /* renamed from: e  reason: collision with other field name */
    public String f569e;

    /* renamed from: f  reason: collision with other field name */
    public String f570f;

    /* renamed from: g  reason: collision with other field name */
    public String f571g;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f560a = new jn("XmPushActionAckNotification");
    private static final jf a = new jf("", Constants.GZIP_CAST_TYPE, 1);
    private static final jf b = new jf("", (byte) 12, 2);
    private static final jf c = new jf("", Constants.GZIP_CAST_TYPE, 3);
    private static final jf d = new jf("", Constants.GZIP_CAST_TYPE, 4);
    private static final jf e = new jf("", Constants.GZIP_CAST_TYPE, 5);
    private static final jf f = new jf("", (byte) 10, 7);
    private static final jf g = new jf("", Constants.GZIP_CAST_TYPE, 8);
    private static final jf h = new jf("", (byte) 13, 9);
    private static final jf i = new jf("", Constants.GZIP_CAST_TYPE, 10);
    private static final jf j = new jf("", Constants.GZIP_CAST_TYPE, 11);

    /* renamed from: a  reason: collision with other field name */
    private BitSet f564a = new BitSet(1);

    /* renamed from: a  reason: collision with other field name */
    public long f561a = 0;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(id idVar) {
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
        if (getClass().equals(idVar.getClass())) {
            int compareTo = Boolean.valueOf(m397a()).compareTo(Boolean.valueOf(idVar.m397a()));
            if (compareTo == 0) {
                if (!m397a() || (a11 = iy.a(this.f563a, idVar.f563a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(idVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a10 = iy.a(this.f562a, idVar.f562a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(idVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a9 = iy.a(this.f566b, idVar.f566b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(idVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a8 = iy.a(this.f567c, idVar.f567c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(idVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a7 = iy.a(this.f568d, idVar.f568d)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(idVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a6 = iy.a(this.f561a, idVar.f561a)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(idVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a5 = iy.a(this.f569e, idVar.f569e)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(idVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a4 = iy.a(this.f565a, idVar.f565a)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(idVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a3 = iy.a(this.f570f, idVar.f570f)) == 0) {
                                                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(idVar.j()));
                                                                                    if (compareTo10 == 0) {
                                                                                        if (!j() || (a2 = iy.a(this.f571g, idVar.f571g)) == 0) {
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
        return getClass().getName().compareTo(idVar.getClass().getName());
    }

    public String a() {
        return this.f566b;
    }

    /* renamed from: a  reason: collision with other method in class */
    public Map<String, String> m395a() {
        return this.f565a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m396a() {
        if (this.f566b == null) {
            throw new jj("Required field 'id' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m483a();
        while (true) {
            jf m479a = jiVar.m479a();
            if (m479a.a == 0) {
                jiVar.f();
                m396a();
                return;
            }
            switch (m479a.f783a) {
                case 1:
                    if (m479a.a == 11) {
                        this.f563a = jiVar.m484a();
                        break;
                    } else {
                        jl.a(jiVar, m479a.a);
                        break;
                    }
                case 2:
                    if (m479a.a == 12) {
                        this.f562a = new ib();
                        this.f562a.a(jiVar);
                        break;
                    } else {
                        jl.a(jiVar, m479a.a);
                        break;
                    }
                case 3:
                    if (m479a.a == 11) {
                        this.f566b = jiVar.m484a();
                        break;
                    } else {
                        jl.a(jiVar, m479a.a);
                        break;
                    }
                case 4:
                    if (m479a.a == 11) {
                        this.f567c = jiVar.m484a();
                        break;
                    } else {
                        jl.a(jiVar, m479a.a);
                        break;
                    }
                case 5:
                    if (m479a.a == 11) {
                        this.f568d = jiVar.m484a();
                        break;
                    } else {
                        jl.a(jiVar, m479a.a);
                        break;
                    }
                case 6:
                default:
                    jl.a(jiVar, m479a.a);
                    break;
                case 7:
                    if (m479a.a == 10) {
                        this.f561a = jiVar.m478a();
                        a(true);
                        break;
                    } else {
                        jl.a(jiVar, m479a.a);
                        break;
                    }
                case 8:
                    if (m479a.a == 11) {
                        this.f569e = jiVar.m484a();
                        break;
                    } else {
                        jl.a(jiVar, m479a.a);
                        break;
                    }
                case 9:
                    if (m479a.a == 13) {
                        jh m481a = jiVar.m481a();
                        this.f565a = new HashMap(m481a.f785a * 2);
                        for (int i2 = 0; i2 < m481a.f785a; i2++) {
                            this.f565a.put(jiVar.m484a(), jiVar.m484a());
                        }
                        jiVar.h();
                        break;
                    } else {
                        jl.a(jiVar, m479a.a);
                        break;
                    }
                case 10:
                    if (m479a.a == 11) {
                        this.f570f = jiVar.m484a();
                        break;
                    } else {
                        jl.a(jiVar, m479a.a);
                        break;
                    }
                case 11:
                    if (m479a.a == 11) {
                        this.f571g = jiVar.m484a();
                        break;
                    } else {
                        jl.a(jiVar, m479a.a);
                        break;
                    }
            }
            jiVar.g();
        }
    }

    public void a(boolean z) {
        this.f564a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m397a() {
        return this.f563a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m398a(id idVar) {
        if (idVar == null) {
            return false;
        }
        boolean m397a = m397a();
        boolean m397a2 = idVar.m397a();
        if ((m397a || m397a2) && !(m397a && m397a2 && this.f563a.equals(idVar.f563a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = idVar.b();
        if ((b2 || b3) && !(b2 && b3 && this.f562a.m392a(idVar.f562a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = idVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f566b.equals(idVar.f566b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = idVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f567c.equals(idVar.f567c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = idVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f568d.equals(idVar.f568d))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = idVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f561a == idVar.f561a)) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = idVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f569e.equals(idVar.f569e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = idVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f565a.equals(idVar.f565a))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = idVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f570f.equals(idVar.f570f))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = idVar.j();
        return !(j2 || j3) || (j2 && j3 && this.f571g.equals(idVar.f571g));
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        m396a();
        jiVar.a(f560a);
        if (this.f563a != null && m397a()) {
            jiVar.a(a);
            jiVar.a(this.f563a);
            jiVar.b();
        }
        if (this.f562a != null && b()) {
            jiVar.a(b);
            this.f562a.b(jiVar);
            jiVar.b();
        }
        if (this.f566b != null) {
            jiVar.a(c);
            jiVar.a(this.f566b);
            jiVar.b();
        }
        if (this.f567c != null && d()) {
            jiVar.a(d);
            jiVar.a(this.f567c);
            jiVar.b();
        }
        if (this.f568d != null && e()) {
            jiVar.a(e);
            jiVar.a(this.f568d);
            jiVar.b();
        }
        if (f()) {
            jiVar.a(f);
            jiVar.a(this.f561a);
            jiVar.b();
        }
        if (this.f569e != null && g()) {
            jiVar.a(g);
            jiVar.a(this.f569e);
            jiVar.b();
        }
        if (this.f565a != null && h()) {
            jiVar.a(h);
            jiVar.a(new jh(Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, this.f565a.size()));
            for (Map.Entry<String, String> entry : this.f565a.entrySet()) {
                jiVar.a(entry.getKey());
                jiVar.a(entry.getValue());
            }
            jiVar.d();
            jiVar.b();
        }
        if (this.f570f != null && i()) {
            jiVar.a(i);
            jiVar.a(this.f570f);
            jiVar.b();
        }
        if (this.f571g != null && j()) {
            jiVar.a(j);
            jiVar.a(this.f571g);
            jiVar.b();
        }
        jiVar.c();
        jiVar.m487a();
    }

    public boolean b() {
        return this.f562a != null;
    }

    public boolean c() {
        return this.f566b != null;
    }

    public boolean d() {
        return this.f567c != null;
    }

    public boolean e() {
        return this.f568d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof id)) {
            return m398a((id) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f564a.get(0);
    }

    public boolean g() {
        return this.f569e != null;
    }

    public boolean h() {
        return this.f565a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f570f != null;
    }

    public boolean j() {
        return this.f571g != null;
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionAckNotification(");
        boolean z2 = true;
        if (m397a()) {
            sb.append("debug:");
            if (this.f563a == null) {
                sb.append("null");
            } else {
                sb.append(this.f563a);
            }
            z2 = false;
        }
        if (b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f562a == null) {
                sb.append("null");
            } else {
                sb.append(this.f562a);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f566b == null) {
            sb.append("null");
        } else {
            sb.append(this.f566b);
        }
        if (d()) {
            sb.append(", ");
            sb.append("appId:");
            if (this.f567c == null) {
                sb.append("null");
            } else {
                sb.append(this.f567c);
            }
        }
        if (e()) {
            sb.append(", ");
            sb.append("type:");
            if (this.f568d == null) {
                sb.append("null");
            } else {
                sb.append(this.f568d);
            }
        }
        if (f()) {
            sb.append(", ");
            sb.append("errorCode:");
            sb.append(this.f561a);
        }
        if (g()) {
            sb.append(", ");
            sb.append("reason:");
            if (this.f569e == null) {
                sb.append("null");
            } else {
                sb.append(this.f569e);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("extra:");
            if (this.f565a == null) {
                sb.append("null");
            } else {
                sb.append(this.f565a);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f570f == null) {
                sb.append("null");
            } else {
                sb.append(this.f570f);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("category:");
            if (this.f571g == null) {
                sb.append("null");
            } else {
                sb.append(this.f571g);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
