package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes8.dex */
public class id implements ix<id, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public ib f563a;

    /* renamed from: a  reason: collision with other field name */
    public String f564a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f566a;

    /* renamed from: b  reason: collision with other field name */
    public String f567b;

    /* renamed from: c  reason: collision with other field name */
    public String f568c;

    /* renamed from: d  reason: collision with other field name */
    public String f569d;

    /* renamed from: e  reason: collision with other field name */
    public String f570e;

    /* renamed from: f  reason: collision with other field name */
    public String f571f;

    /* renamed from: g  reason: collision with other field name */
    public String f572g;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f561a = new jn("XmPushActionAckNotification");
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
    private BitSet f565a = new BitSet(1);

    /* renamed from: a  reason: collision with other field name */
    public long f562a = 0;

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
                if (!m397a() || (a11 = iy.a(this.f564a, idVar.f564a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(idVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a10 = iy.a(this.f563a, idVar.f563a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(idVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a9 = iy.a(this.f567b, idVar.f567b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(idVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a8 = iy.a(this.f568c, idVar.f568c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(idVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a7 = iy.a(this.f569d, idVar.f569d)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(idVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a6 = iy.a(this.f562a, idVar.f562a)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(idVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a5 = iy.a(this.f570e, idVar.f570e)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(idVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a4 = iy.a(this.f566a, idVar.f566a)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(idVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a3 = iy.a(this.f571f, idVar.f571f)) == 0) {
                                                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(idVar.j()));
                                                                                    if (compareTo10 == 0) {
                                                                                        if (!j() || (a2 = iy.a(this.f572g, idVar.f572g)) == 0) {
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
        return this.f567b;
    }

    /* renamed from: a  reason: collision with other method in class */
    public Map<String, String> m395a() {
        return this.f566a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m396a() {
        if (this.f567b == null) {
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
            switch (m479a.f784a) {
                case 1:
                    if (m479a.a == 11) {
                        this.f564a = jiVar.m484a();
                        break;
                    } else {
                        jl.a(jiVar, m479a.a);
                        break;
                    }
                case 2:
                    if (m479a.a == 12) {
                        this.f563a = new ib();
                        this.f563a.a(jiVar);
                        break;
                    } else {
                        jl.a(jiVar, m479a.a);
                        break;
                    }
                case 3:
                    if (m479a.a == 11) {
                        this.f567b = jiVar.m484a();
                        break;
                    } else {
                        jl.a(jiVar, m479a.a);
                        break;
                    }
                case 4:
                    if (m479a.a == 11) {
                        this.f568c = jiVar.m484a();
                        break;
                    } else {
                        jl.a(jiVar, m479a.a);
                        break;
                    }
                case 5:
                    if (m479a.a == 11) {
                        this.f569d = jiVar.m484a();
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
                        this.f562a = jiVar.m478a();
                        a(true);
                        break;
                    } else {
                        jl.a(jiVar, m479a.a);
                        break;
                    }
                case 8:
                    if (m479a.a == 11) {
                        this.f570e = jiVar.m484a();
                        break;
                    } else {
                        jl.a(jiVar, m479a.a);
                        break;
                    }
                case 9:
                    if (m479a.a == 13) {
                        jh m481a = jiVar.m481a();
                        this.f566a = new HashMap(m481a.f786a * 2);
                        for (int i2 = 0; i2 < m481a.f786a; i2++) {
                            this.f566a.put(jiVar.m484a(), jiVar.m484a());
                        }
                        jiVar.h();
                        break;
                    } else {
                        jl.a(jiVar, m479a.a);
                        break;
                    }
                case 10:
                    if (m479a.a == 11) {
                        this.f571f = jiVar.m484a();
                        break;
                    } else {
                        jl.a(jiVar, m479a.a);
                        break;
                    }
                case 11:
                    if (m479a.a == 11) {
                        this.f572g = jiVar.m484a();
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
        this.f565a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m397a() {
        return this.f564a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m398a(id idVar) {
        if (idVar == null) {
            return false;
        }
        boolean m397a = m397a();
        boolean m397a2 = idVar.m397a();
        if ((m397a || m397a2) && !(m397a && m397a2 && this.f564a.equals(idVar.f564a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = idVar.b();
        if ((b2 || b3) && !(b2 && b3 && this.f563a.m392a(idVar.f563a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = idVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f567b.equals(idVar.f567b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = idVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f568c.equals(idVar.f568c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = idVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f569d.equals(idVar.f569d))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = idVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f562a == idVar.f562a)) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = idVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f570e.equals(idVar.f570e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = idVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f566a.equals(idVar.f566a))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = idVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f571f.equals(idVar.f571f))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = idVar.j();
        return !(j2 || j3) || (j2 && j3 && this.f572g.equals(idVar.f572g));
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        m396a();
        jiVar.a(f561a);
        if (this.f564a != null && m397a()) {
            jiVar.a(a);
            jiVar.a(this.f564a);
            jiVar.b();
        }
        if (this.f563a != null && b()) {
            jiVar.a(b);
            this.f563a.b(jiVar);
            jiVar.b();
        }
        if (this.f567b != null) {
            jiVar.a(c);
            jiVar.a(this.f567b);
            jiVar.b();
        }
        if (this.f568c != null && d()) {
            jiVar.a(d);
            jiVar.a(this.f568c);
            jiVar.b();
        }
        if (this.f569d != null && e()) {
            jiVar.a(e);
            jiVar.a(this.f569d);
            jiVar.b();
        }
        if (f()) {
            jiVar.a(f);
            jiVar.a(this.f562a);
            jiVar.b();
        }
        if (this.f570e != null && g()) {
            jiVar.a(g);
            jiVar.a(this.f570e);
            jiVar.b();
        }
        if (this.f566a != null && h()) {
            jiVar.a(h);
            jiVar.a(new jh(Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, this.f566a.size()));
            for (Map.Entry<String, String> entry : this.f566a.entrySet()) {
                jiVar.a(entry.getKey());
                jiVar.a(entry.getValue());
            }
            jiVar.d();
            jiVar.b();
        }
        if (this.f571f != null && i()) {
            jiVar.a(i);
            jiVar.a(this.f571f);
            jiVar.b();
        }
        if (this.f572g != null && j()) {
            jiVar.a(j);
            jiVar.a(this.f572g);
            jiVar.b();
        }
        jiVar.c();
        jiVar.m487a();
    }

    public boolean b() {
        return this.f563a != null;
    }

    public boolean c() {
        return this.f567b != null;
    }

    public boolean d() {
        return this.f568c != null;
    }

    public boolean e() {
        return this.f569d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof id)) {
            return m398a((id) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f565a.get(0);
    }

    public boolean g() {
        return this.f570e != null;
    }

    public boolean h() {
        return this.f566a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f571f != null;
    }

    public boolean j() {
        return this.f572g != null;
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionAckNotification(");
        boolean z2 = true;
        if (m397a()) {
            sb.append("debug:");
            if (this.f564a == null) {
                sb.append("null");
            } else {
                sb.append(this.f564a);
            }
            z2 = false;
        }
        if (b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f563a == null) {
                sb.append("null");
            } else {
                sb.append(this.f563a);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f567b == null) {
            sb.append("null");
        } else {
            sb.append(this.f567b);
        }
        if (d()) {
            sb.append(", ");
            sb.append("appId:");
            if (this.f568c == null) {
                sb.append("null");
            } else {
                sb.append(this.f568c);
            }
        }
        if (e()) {
            sb.append(", ");
            sb.append("type:");
            if (this.f569d == null) {
                sb.append("null");
            } else {
                sb.append(this.f569d);
            }
        }
        if (f()) {
            sb.append(", ");
            sb.append("errorCode:");
            sb.append(this.f562a);
        }
        if (g()) {
            sb.append(", ");
            sb.append("reason:");
            if (this.f570e == null) {
                sb.append("null");
            } else {
                sb.append(this.f570e);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("extra:");
            if (this.f566a == null) {
                sb.append("null");
            } else {
                sb.append(this.f566a);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f571f == null) {
                sb.append("null");
            } else {
                sb.append(this.f571f);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("category:");
            if (this.f572g == null) {
                sb.append("null");
            } else {
                sb.append(this.f572g);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
