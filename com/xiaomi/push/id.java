package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes12.dex */
public class id implements ix<id, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public ib f555a;

    /* renamed from: a  reason: collision with other field name */
    public String f556a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f558a;

    /* renamed from: b  reason: collision with other field name */
    public String f559b;

    /* renamed from: c  reason: collision with other field name */
    public String f560c;

    /* renamed from: d  reason: collision with other field name */
    public String f561d;

    /* renamed from: e  reason: collision with other field name */
    public String f562e;

    /* renamed from: f  reason: collision with other field name */
    public String f563f;

    /* renamed from: g  reason: collision with other field name */
    public String f564g;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f553a = new jn("XmPushActionAckNotification");

    /* renamed from: a  reason: collision with root package name */
    private static final jf f4971a = new jf("", Constants.GZIP_CAST_TYPE, 1);
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
    private BitSet f557a = new BitSet(1);

    /* renamed from: a  reason: collision with other field name */
    public long f554a = 0;

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
            int compareTo = Boolean.valueOf(m403a()).compareTo(Boolean.valueOf(idVar.m403a()));
            if (compareTo == 0) {
                if (!m403a() || (a11 = iy.a(this.f556a, idVar.f556a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(idVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a10 = iy.a(this.f555a, idVar.f555a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(idVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a9 = iy.a(this.f559b, idVar.f559b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(idVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a8 = iy.a(this.f560c, idVar.f560c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(idVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a7 = iy.a(this.f561d, idVar.f561d)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(idVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a6 = iy.a(this.f554a, idVar.f554a)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(idVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a5 = iy.a(this.f562e, idVar.f562e)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(idVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a4 = iy.a(this.f558a, idVar.f558a)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(idVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a3 = iy.a(this.f563f, idVar.f563f)) == 0) {
                                                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(idVar.j()));
                                                                                    if (compareTo10 == 0) {
                                                                                        if (!j() || (a2 = iy.a(this.f564g, idVar.f564g)) == 0) {
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
        return this.f559b;
    }

    /* renamed from: a  reason: collision with other method in class */
    public Map<String, String> m401a() {
        return this.f558a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m402a() {
        if (this.f559b == null) {
            throw new jj("Required field 'id' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m489a();
        while (true) {
            jf m485a = jiVar.m485a();
            if (m485a.f4998a == 0) {
                jiVar.f();
                m402a();
                return;
            }
            switch (m485a.f776a) {
                case 1:
                    if (m485a.f4998a == 11) {
                        this.f556a = jiVar.m490a();
                        break;
                    } else {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    }
                case 2:
                    if (m485a.f4998a == 12) {
                        this.f555a = new ib();
                        this.f555a.a(jiVar);
                        break;
                    } else {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    }
                case 3:
                    if (m485a.f4998a == 11) {
                        this.f559b = jiVar.m490a();
                        break;
                    } else {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    }
                case 4:
                    if (m485a.f4998a == 11) {
                        this.f560c = jiVar.m490a();
                        break;
                    } else {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    }
                case 5:
                    if (m485a.f4998a == 11) {
                        this.f561d = jiVar.m490a();
                        break;
                    } else {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    }
                case 6:
                default:
                    jl.a(jiVar, m485a.f4998a);
                    break;
                case 7:
                    if (m485a.f4998a == 10) {
                        this.f554a = jiVar.m484a();
                        a(true);
                        break;
                    } else {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    }
                case 8:
                    if (m485a.f4998a == 11) {
                        this.f562e = jiVar.m490a();
                        break;
                    } else {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    }
                case 9:
                    if (m485a.f4998a == 13) {
                        jh m487a = jiVar.m487a();
                        this.f558a = new HashMap(m487a.f778a * 2);
                        for (int i2 = 0; i2 < m487a.f778a; i2++) {
                            this.f558a.put(jiVar.m490a(), jiVar.m490a());
                        }
                        jiVar.h();
                        break;
                    } else {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    }
                case 10:
                    if (m485a.f4998a == 11) {
                        this.f563f = jiVar.m490a();
                        break;
                    } else {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    }
                case 11:
                    if (m485a.f4998a == 11) {
                        this.f564g = jiVar.m490a();
                        break;
                    } else {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    }
            }
            jiVar.g();
        }
    }

    public void a(boolean z) {
        this.f557a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m403a() {
        return this.f556a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m404a(id idVar) {
        if (idVar == null) {
            return false;
        }
        boolean m403a = m403a();
        boolean m403a2 = idVar.m403a();
        if ((m403a || m403a2) && !(m403a && m403a2 && this.f556a.equals(idVar.f556a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = idVar.b();
        if ((b2 || b3) && !(b2 && b3 && this.f555a.m398a(idVar.f555a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = idVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f559b.equals(idVar.f559b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = idVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f560c.equals(idVar.f560c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = idVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f561d.equals(idVar.f561d))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = idVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f554a == idVar.f554a)) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = idVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f562e.equals(idVar.f562e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = idVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f558a.equals(idVar.f558a))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = idVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f563f.equals(idVar.f563f))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = idVar.j();
        return !(j2 || j3) || (j2 && j3 && this.f564g.equals(idVar.f564g));
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        m402a();
        jiVar.a(f553a);
        if (this.f556a != null && m403a()) {
            jiVar.a(f4971a);
            jiVar.a(this.f556a);
            jiVar.b();
        }
        if (this.f555a != null && b()) {
            jiVar.a(b);
            this.f555a.b(jiVar);
            jiVar.b();
        }
        if (this.f559b != null) {
            jiVar.a(c);
            jiVar.a(this.f559b);
            jiVar.b();
        }
        if (this.f560c != null && d()) {
            jiVar.a(d);
            jiVar.a(this.f560c);
            jiVar.b();
        }
        if (this.f561d != null && e()) {
            jiVar.a(e);
            jiVar.a(this.f561d);
            jiVar.b();
        }
        if (f()) {
            jiVar.a(f);
            jiVar.a(this.f554a);
            jiVar.b();
        }
        if (this.f562e != null && g()) {
            jiVar.a(g);
            jiVar.a(this.f562e);
            jiVar.b();
        }
        if (this.f558a != null && h()) {
            jiVar.a(h);
            jiVar.a(new jh(Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, this.f558a.size()));
            for (Map.Entry<String, String> entry : this.f558a.entrySet()) {
                jiVar.a(entry.getKey());
                jiVar.a(entry.getValue());
            }
            jiVar.d();
            jiVar.b();
        }
        if (this.f563f != null && i()) {
            jiVar.a(i);
            jiVar.a(this.f563f);
            jiVar.b();
        }
        if (this.f564g != null && j()) {
            jiVar.a(j);
            jiVar.a(this.f564g);
            jiVar.b();
        }
        jiVar.c();
        jiVar.m493a();
    }

    public boolean b() {
        return this.f555a != null;
    }

    public boolean c() {
        return this.f559b != null;
    }

    public boolean d() {
        return this.f560c != null;
    }

    public boolean e() {
        return this.f561d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof id)) {
            return m404a((id) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f557a.get(0);
    }

    public boolean g() {
        return this.f562e != null;
    }

    public boolean h() {
        return this.f558a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f563f != null;
    }

    public boolean j() {
        return this.f564g != null;
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionAckNotification(");
        boolean z2 = true;
        if (m403a()) {
            sb.append("debug:");
            if (this.f556a == null) {
                sb.append("null");
            } else {
                sb.append(this.f556a);
            }
            z2 = false;
        }
        if (b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f555a == null) {
                sb.append("null");
            } else {
                sb.append(this.f555a);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f559b == null) {
            sb.append("null");
        } else {
            sb.append(this.f559b);
        }
        if (d()) {
            sb.append(", ");
            sb.append("appId:");
            if (this.f560c == null) {
                sb.append("null");
            } else {
                sb.append(this.f560c);
            }
        }
        if (e()) {
            sb.append(", ");
            sb.append("type:");
            if (this.f561d == null) {
                sb.append("null");
            } else {
                sb.append(this.f561d);
            }
        }
        if (f()) {
            sb.append(", ");
            sb.append("errorCode:");
            sb.append(this.f554a);
        }
        if (g()) {
            sb.append(", ");
            sb.append("reason:");
            if (this.f562e == null) {
                sb.append("null");
            } else {
                sb.append(this.f562e);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("extra:");
            if (this.f558a == null) {
                sb.append("null");
            } else {
                sb.append(this.f558a);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f563f == null) {
                sb.append("null");
            } else {
                sb.append(this.f563f);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("category:");
            if (this.f564g == null) {
                sb.append("null");
            } else {
                sb.append(this.f564g);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
