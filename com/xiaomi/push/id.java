package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes18.dex */
public class id implements ix<id, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public ib f560a;

    /* renamed from: a  reason: collision with other field name */
    public String f561a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f563a;

    /* renamed from: b  reason: collision with other field name */
    public String f564b;

    /* renamed from: c  reason: collision with other field name */
    public String f565c;

    /* renamed from: d  reason: collision with other field name */
    public String f566d;

    /* renamed from: e  reason: collision with other field name */
    public String f567e;

    /* renamed from: f  reason: collision with other field name */
    public String f568f;

    /* renamed from: g  reason: collision with other field name */
    public String f569g;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f558a = new jn("XmPushActionAckNotification");

    /* renamed from: a  reason: collision with root package name */
    private static final jf f4973a = new jf("", Constants.GZIP_CAST_TYPE, 1);
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
    private BitSet f562a = new BitSet(1);

    /* renamed from: a  reason: collision with other field name */
    public long f559a = 0;

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
            int compareTo = Boolean.valueOf(m406a()).compareTo(Boolean.valueOf(idVar.m406a()));
            if (compareTo == 0) {
                if (!m406a() || (a11 = iy.a(this.f561a, idVar.f561a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(idVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a10 = iy.a(this.f560a, idVar.f560a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(idVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a9 = iy.a(this.f564b, idVar.f564b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(idVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a8 = iy.a(this.f565c, idVar.f565c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(idVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a7 = iy.a(this.f566d, idVar.f566d)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(idVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a6 = iy.a(this.f559a, idVar.f559a)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(idVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a5 = iy.a(this.f567e, idVar.f567e)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(idVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a4 = iy.a(this.f563a, idVar.f563a)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(idVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a3 = iy.a(this.f568f, idVar.f568f)) == 0) {
                                                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(idVar.j()));
                                                                                    if (compareTo10 == 0) {
                                                                                        if (!j() || (a2 = iy.a(this.f569g, idVar.f569g)) == 0) {
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
        return this.f564b;
    }

    /* renamed from: a  reason: collision with other method in class */
    public Map<String, String> m404a() {
        return this.f563a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m405a() {
        if (this.f564b == null) {
            throw new jj("Required field 'id' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m492a();
        while (true) {
            jf m488a = jiVar.m488a();
            if (m488a.f5000a == 0) {
                jiVar.f();
                m405a();
                return;
            }
            switch (m488a.f781a) {
                case 1:
                    if (m488a.f5000a == 11) {
                        this.f561a = jiVar.m493a();
                        break;
                    } else {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    }
                case 2:
                    if (m488a.f5000a == 12) {
                        this.f560a = new ib();
                        this.f560a.a(jiVar);
                        break;
                    } else {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    }
                case 3:
                    if (m488a.f5000a == 11) {
                        this.f564b = jiVar.m493a();
                        break;
                    } else {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    }
                case 4:
                    if (m488a.f5000a == 11) {
                        this.f565c = jiVar.m493a();
                        break;
                    } else {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    }
                case 5:
                    if (m488a.f5000a == 11) {
                        this.f566d = jiVar.m493a();
                        break;
                    } else {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    }
                case 6:
                default:
                    jl.a(jiVar, m488a.f5000a);
                    break;
                case 7:
                    if (m488a.f5000a == 10) {
                        this.f559a = jiVar.m487a();
                        a(true);
                        break;
                    } else {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    }
                case 8:
                    if (m488a.f5000a == 11) {
                        this.f567e = jiVar.m493a();
                        break;
                    } else {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    }
                case 9:
                    if (m488a.f5000a == 13) {
                        jh m490a = jiVar.m490a();
                        this.f563a = new HashMap(m490a.f783a * 2);
                        for (int i2 = 0; i2 < m490a.f783a; i2++) {
                            this.f563a.put(jiVar.m493a(), jiVar.m493a());
                        }
                        jiVar.h();
                        break;
                    } else {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    }
                case 10:
                    if (m488a.f5000a == 11) {
                        this.f568f = jiVar.m493a();
                        break;
                    } else {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    }
                case 11:
                    if (m488a.f5000a == 11) {
                        this.f569g = jiVar.m493a();
                        break;
                    } else {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    }
            }
            jiVar.g();
        }
    }

    public void a(boolean z) {
        this.f562a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m406a() {
        return this.f561a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m407a(id idVar) {
        if (idVar == null) {
            return false;
        }
        boolean m406a = m406a();
        boolean m406a2 = idVar.m406a();
        if ((m406a || m406a2) && !(m406a && m406a2 && this.f561a.equals(idVar.f561a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = idVar.b();
        if ((b2 || b3) && !(b2 && b3 && this.f560a.m401a(idVar.f560a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = idVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f564b.equals(idVar.f564b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = idVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f565c.equals(idVar.f565c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = idVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f566d.equals(idVar.f566d))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = idVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f559a == idVar.f559a)) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = idVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f567e.equals(idVar.f567e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = idVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f563a.equals(idVar.f563a))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = idVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f568f.equals(idVar.f568f))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = idVar.j();
        return !(j2 || j3) || (j2 && j3 && this.f569g.equals(idVar.f569g));
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        m405a();
        jiVar.a(f558a);
        if (this.f561a != null && m406a()) {
            jiVar.a(f4973a);
            jiVar.a(this.f561a);
            jiVar.b();
        }
        if (this.f560a != null && b()) {
            jiVar.a(b);
            this.f560a.b(jiVar);
            jiVar.b();
        }
        if (this.f564b != null) {
            jiVar.a(c);
            jiVar.a(this.f564b);
            jiVar.b();
        }
        if (this.f565c != null && d()) {
            jiVar.a(d);
            jiVar.a(this.f565c);
            jiVar.b();
        }
        if (this.f566d != null && e()) {
            jiVar.a(e);
            jiVar.a(this.f566d);
            jiVar.b();
        }
        if (f()) {
            jiVar.a(f);
            jiVar.a(this.f559a);
            jiVar.b();
        }
        if (this.f567e != null && g()) {
            jiVar.a(g);
            jiVar.a(this.f567e);
            jiVar.b();
        }
        if (this.f563a != null && h()) {
            jiVar.a(h);
            jiVar.a(new jh(Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, this.f563a.size()));
            for (Map.Entry<String, String> entry : this.f563a.entrySet()) {
                jiVar.a(entry.getKey());
                jiVar.a(entry.getValue());
            }
            jiVar.d();
            jiVar.b();
        }
        if (this.f568f != null && i()) {
            jiVar.a(i);
            jiVar.a(this.f568f);
            jiVar.b();
        }
        if (this.f569g != null && j()) {
            jiVar.a(j);
            jiVar.a(this.f569g);
            jiVar.b();
        }
        jiVar.c();
        jiVar.m496a();
    }

    public boolean b() {
        return this.f560a != null;
    }

    public boolean c() {
        return this.f564b != null;
    }

    public boolean d() {
        return this.f565c != null;
    }

    public boolean e() {
        return this.f566d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof id)) {
            return m407a((id) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f562a.get(0);
    }

    public boolean g() {
        return this.f567e != null;
    }

    public boolean h() {
        return this.f563a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f568f != null;
    }

    public boolean j() {
        return this.f569g != null;
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionAckNotification(");
        boolean z2 = true;
        if (m406a()) {
            sb.append("debug:");
            if (this.f561a == null) {
                sb.append("null");
            } else {
                sb.append(this.f561a);
            }
            z2 = false;
        }
        if (b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f560a == null) {
                sb.append("null");
            } else {
                sb.append(this.f560a);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f564b == null) {
            sb.append("null");
        } else {
            sb.append(this.f564b);
        }
        if (d()) {
            sb.append(", ");
            sb.append("appId:");
            if (this.f565c == null) {
                sb.append("null");
            } else {
                sb.append(this.f565c);
            }
        }
        if (e()) {
            sb.append(", ");
            sb.append("type:");
            if (this.f566d == null) {
                sb.append("null");
            } else {
                sb.append(this.f566d);
            }
        }
        if (f()) {
            sb.append(", ");
            sb.append("errorCode:");
            sb.append(this.f559a);
        }
        if (g()) {
            sb.append(", ");
            sb.append("reason:");
            if (this.f567e == null) {
                sb.append("null");
            } else {
                sb.append(this.f567e);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("extra:");
            if (this.f563a == null) {
                sb.append("null");
            } else {
                sb.append(this.f563a);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f568f == null) {
                sb.append("null");
            } else {
                sb.append(this.f568f);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("category:");
            if (this.f569g == null) {
                sb.append("null");
            } else {
                sb.append(this.f569g);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
