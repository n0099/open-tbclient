package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class id implements ix<id, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public ib f637a;

    /* renamed from: a  reason: collision with other field name */
    public String f638a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f640a;

    /* renamed from: b  reason: collision with other field name */
    public String f641b;

    /* renamed from: c  reason: collision with other field name */
    public String f642c;

    /* renamed from: d  reason: collision with other field name */
    public String f643d;

    /* renamed from: e  reason: collision with other field name */
    public String f644e;

    /* renamed from: f  reason: collision with other field name */
    public String f645f;

    /* renamed from: g  reason: collision with other field name */
    public String f646g;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f635a = new jn("XmPushActionAckNotification");

    /* renamed from: a  reason: collision with root package name */
    private static final jf f14426a = new jf("", Constants.GZIP_CAST_TYPE, 1);

    /* renamed from: b  reason: collision with root package name */
    private static final jf f14427b = new jf("", (byte) 12, 2);
    private static final jf c = new jf("", Constants.GZIP_CAST_TYPE, 3);
    private static final jf d = new jf("", Constants.GZIP_CAST_TYPE, 4);
    private static final jf e = new jf("", Constants.GZIP_CAST_TYPE, 5);
    private static final jf f = new jf("", (byte) 10, 7);
    private static final jf g = new jf("", Constants.GZIP_CAST_TYPE, 8);
    private static final jf h = new jf("", (byte) 13, 9);
    private static final jf i = new jf("", Constants.GZIP_CAST_TYPE, 10);
    private static final jf j = new jf("", Constants.GZIP_CAST_TYPE, 11);

    /* renamed from: a  reason: collision with other field name */
    private BitSet f639a = new BitSet(1);

    /* renamed from: a  reason: collision with other field name */
    public long f636a = 0;

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
            int compareTo = Boolean.valueOf(m433a()).compareTo(Boolean.valueOf(idVar.m433a()));
            if (compareTo == 0) {
                if (!m433a() || (a11 = iy.a(this.f638a, idVar.f638a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(idVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a10 = iy.a(this.f637a, idVar.f637a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(idVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a9 = iy.a(this.f641b, idVar.f641b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(idVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a8 = iy.a(this.f642c, idVar.f642c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(idVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a7 = iy.a(this.f643d, idVar.f643d)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(idVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a6 = iy.a(this.f636a, idVar.f636a)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(idVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a5 = iy.a(this.f644e, idVar.f644e)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(idVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a4 = iy.a(this.f640a, idVar.f640a)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(idVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a3 = iy.a(this.f645f, idVar.f645f)) == 0) {
                                                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(idVar.j()));
                                                                                    if (compareTo10 == 0) {
                                                                                        if (!j() || (a2 = iy.a(this.f646g, idVar.f646g)) == 0) {
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
        return this.f641b;
    }

    /* renamed from: a  reason: collision with other method in class */
    public Map<String, String> m431a() {
        return this.f640a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m432a() {
        if (this.f641b == null) {
            throw new jj("Required field 'id' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m519a();
        while (true) {
            jf m515a = jiVar.m515a();
            if (m515a.f14471a == 0) {
                jiVar.f();
                m432a();
                return;
            }
            switch (m515a.f858a) {
                case 1:
                    if (m515a.f14471a == 11) {
                        this.f638a = jiVar.m520a();
                        break;
                    } else {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    }
                case 2:
                    if (m515a.f14471a == 12) {
                        this.f637a = new ib();
                        this.f637a.a(jiVar);
                        break;
                    } else {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    }
                case 3:
                    if (m515a.f14471a == 11) {
                        this.f641b = jiVar.m520a();
                        break;
                    } else {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    }
                case 4:
                    if (m515a.f14471a == 11) {
                        this.f642c = jiVar.m520a();
                        break;
                    } else {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    }
                case 5:
                    if (m515a.f14471a == 11) {
                        this.f643d = jiVar.m520a();
                        break;
                    } else {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    }
                case 6:
                default:
                    jl.a(jiVar, m515a.f14471a);
                    break;
                case 7:
                    if (m515a.f14471a == 10) {
                        this.f636a = jiVar.m514a();
                        a(true);
                        break;
                    } else {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    }
                case 8:
                    if (m515a.f14471a == 11) {
                        this.f644e = jiVar.m520a();
                        break;
                    } else {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    }
                case 9:
                    if (m515a.f14471a == 13) {
                        jh m517a = jiVar.m517a();
                        this.f640a = new HashMap(m517a.f860a * 2);
                        for (int i2 = 0; i2 < m517a.f860a; i2++) {
                            this.f640a.put(jiVar.m520a(), jiVar.m520a());
                        }
                        jiVar.h();
                        break;
                    } else {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    }
                case 10:
                    if (m515a.f14471a == 11) {
                        this.f645f = jiVar.m520a();
                        break;
                    } else {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    }
                case 11:
                    if (m515a.f14471a == 11) {
                        this.f646g = jiVar.m520a();
                        break;
                    } else {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    }
            }
            jiVar.g();
        }
    }

    public void a(boolean z) {
        this.f639a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m433a() {
        return this.f638a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m434a(id idVar) {
        if (idVar == null) {
            return false;
        }
        boolean m433a = m433a();
        boolean m433a2 = idVar.m433a();
        if ((m433a || m433a2) && !(m433a && m433a2 && this.f638a.equals(idVar.f638a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = idVar.b();
        if ((b2 || b3) && !(b2 && b3 && this.f637a.m428a(idVar.f637a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = idVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f641b.equals(idVar.f641b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = idVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f642c.equals(idVar.f642c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = idVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f643d.equals(idVar.f643d))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = idVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f636a == idVar.f636a)) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = idVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f644e.equals(idVar.f644e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = idVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f640a.equals(idVar.f640a))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = idVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f645f.equals(idVar.f645f))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = idVar.j();
        return !(j2 || j3) || (j2 && j3 && this.f646g.equals(idVar.f646g));
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        m432a();
        jiVar.a(f635a);
        if (this.f638a != null && m433a()) {
            jiVar.a(f14426a);
            jiVar.a(this.f638a);
            jiVar.b();
        }
        if (this.f637a != null && b()) {
            jiVar.a(f14427b);
            this.f637a.b(jiVar);
            jiVar.b();
        }
        if (this.f641b != null) {
            jiVar.a(c);
            jiVar.a(this.f641b);
            jiVar.b();
        }
        if (this.f642c != null && d()) {
            jiVar.a(d);
            jiVar.a(this.f642c);
            jiVar.b();
        }
        if (this.f643d != null && e()) {
            jiVar.a(e);
            jiVar.a(this.f643d);
            jiVar.b();
        }
        if (f()) {
            jiVar.a(f);
            jiVar.a(this.f636a);
            jiVar.b();
        }
        if (this.f644e != null && g()) {
            jiVar.a(g);
            jiVar.a(this.f644e);
            jiVar.b();
        }
        if (this.f640a != null && h()) {
            jiVar.a(h);
            jiVar.a(new jh(Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, this.f640a.size()));
            for (Map.Entry<String, String> entry : this.f640a.entrySet()) {
                jiVar.a(entry.getKey());
                jiVar.a(entry.getValue());
            }
            jiVar.d();
            jiVar.b();
        }
        if (this.f645f != null && i()) {
            jiVar.a(i);
            jiVar.a(this.f645f);
            jiVar.b();
        }
        if (this.f646g != null && j()) {
            jiVar.a(j);
            jiVar.a(this.f646g);
            jiVar.b();
        }
        jiVar.c();
        jiVar.m523a();
    }

    public boolean b() {
        return this.f637a != null;
    }

    public boolean c() {
        return this.f641b != null;
    }

    public boolean d() {
        return this.f642c != null;
    }

    public boolean e() {
        return this.f643d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof id)) {
            return m434a((id) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f639a.get(0);
    }

    public boolean g() {
        return this.f644e != null;
    }

    public boolean h() {
        return this.f640a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f645f != null;
    }

    public boolean j() {
        return this.f646g != null;
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionAckNotification(");
        boolean z2 = true;
        if (m433a()) {
            sb.append("debug:");
            if (this.f638a == null) {
                sb.append("null");
            } else {
                sb.append(this.f638a);
            }
            z2 = false;
        }
        if (b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f637a == null) {
                sb.append("null");
            } else {
                sb.append(this.f637a);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f641b == null) {
            sb.append("null");
        } else {
            sb.append(this.f641b);
        }
        if (d()) {
            sb.append(", ");
            sb.append("appId:");
            if (this.f642c == null) {
                sb.append("null");
            } else {
                sb.append(this.f642c);
            }
        }
        if (e()) {
            sb.append(", ");
            sb.append("type:");
            if (this.f643d == null) {
                sb.append("null");
            } else {
                sb.append(this.f643d);
            }
        }
        if (f()) {
            sb.append(", ");
            sb.append("errorCode:");
            sb.append(this.f636a);
        }
        if (g()) {
            sb.append(", ");
            sb.append("reason:");
            if (this.f644e == null) {
                sb.append("null");
            } else {
                sb.append(this.f644e);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("extra:");
            if (this.f640a == null) {
                sb.append("null");
            } else {
                sb.append(this.f640a);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f645f == null) {
                sb.append("null");
            } else {
                sb.append(this.f645f);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("category:");
            if (this.f646g == null) {
                sb.append("null");
            } else {
                sb.append(this.f646g);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
