package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
/* loaded from: classes12.dex */
public class ih implements ix<ih, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f584a;

    /* renamed from: a  reason: collision with other field name */
    public ib f585a;

    /* renamed from: a  reason: collision with other field name */
    public String f586a;

    /* renamed from: a  reason: collision with other field name */
    public List<String> f588a;

    /* renamed from: b  reason: collision with other field name */
    public String f590b;

    /* renamed from: c  reason: collision with other field name */
    public String f591c;

    /* renamed from: d  reason: collision with other field name */
    public String f592d;

    /* renamed from: e  reason: collision with other field name */
    public String f593e;

    /* renamed from: f  reason: collision with other field name */
    public String f594f;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f583a = new jn("XmPushActionCommandResult");

    /* renamed from: a  reason: collision with root package name */
    private static final jf f4975a = new jf("", (byte) 12, 2);
    private static final jf b = new jf("", Constants.GZIP_CAST_TYPE, 3);
    private static final jf c = new jf("", Constants.GZIP_CAST_TYPE, 4);
    private static final jf d = new jf("", Constants.GZIP_CAST_TYPE, 5);
    private static final jf e = new jf("", (byte) 10, 7);
    private static final jf f = new jf("", Constants.GZIP_CAST_TYPE, 8);
    private static final jf g = new jf("", Constants.GZIP_CAST_TYPE, 9);
    private static final jf h = new jf("", (byte) 15, 10);
    private static final jf i = new jf("", Constants.GZIP_CAST_TYPE, 12);
    private static final jf j = new jf("", (byte) 2, 13);

    /* renamed from: a  reason: collision with other field name */
    private BitSet f587a = new BitSet(2);

    /* renamed from: a  reason: collision with other field name */
    public boolean f589a = true;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(ih ihVar) {
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
        if (getClass().equals(ihVar.getClass())) {
            int compareTo = Boolean.valueOf(m415a()).compareTo(Boolean.valueOf(ihVar.m415a()));
            if (compareTo == 0) {
                if (!m415a() || (a11 = iy.a(this.f585a, ihVar.f585a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m417b()).compareTo(Boolean.valueOf(ihVar.m417b()));
                    if (compareTo2 == 0) {
                        if (!m417b() || (a10 = iy.a(this.f586a, ihVar.f586a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(ihVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a9 = iy.a(this.f590b, ihVar.f590b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(ihVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a8 = iy.a(this.f591c, ihVar.f591c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(ihVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a7 = iy.a(this.f584a, ihVar.f584a)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(ihVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a6 = iy.a(this.f592d, ihVar.f592d)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ihVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a5 = iy.a(this.f593e, ihVar.f593e)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(ihVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a4 = iy.a(this.f588a, ihVar.f588a)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(ihVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a3 = iy.a(this.f594f, ihVar.f594f)) == 0) {
                                                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(ihVar.j()));
                                                                                    if (compareTo10 == 0) {
                                                                                        if (!j() || (a2 = iy.a(this.f589a, ihVar.f589a)) == 0) {
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
        return getClass().getName().compareTo(ihVar.getClass().getName());
    }

    public String a() {
        return this.f591c;
    }

    /* renamed from: a  reason: collision with other method in class */
    public List<String> m413a() {
        return this.f588a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m414a() {
        if (this.f586a == null) {
            throw new jj("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f590b == null) {
            throw new jj("Required field 'appId' was not present! Struct: " + toString());
        }
        if (this.f591c == null) {
            throw new jj("Required field 'cmdName' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m489a();
        while (true) {
            jf m485a = jiVar.m485a();
            if (m485a.f4998a == 0) {
                jiVar.f();
                if (!e()) {
                    throw new jj("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
                }
                m414a();
                return;
            }
            switch (m485a.f776a) {
                case 2:
                    if (m485a.f4998a == 12) {
                        this.f585a = new ib();
                        this.f585a.a(jiVar);
                        break;
                    } else {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    }
                case 3:
                    if (m485a.f4998a == 11) {
                        this.f586a = jiVar.m490a();
                        break;
                    } else {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    }
                case 4:
                    if (m485a.f4998a == 11) {
                        this.f590b = jiVar.m490a();
                        break;
                    } else {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    }
                case 5:
                    if (m485a.f4998a == 11) {
                        this.f591c = jiVar.m490a();
                        break;
                    } else {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    }
                case 6:
                case 11:
                default:
                    jl.a(jiVar, m485a.f4998a);
                    break;
                case 7:
                    if (m485a.f4998a == 10) {
                        this.f584a = jiVar.m484a();
                        a(true);
                        break;
                    } else {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    }
                case 8:
                    if (m485a.f4998a == 11) {
                        this.f592d = jiVar.m490a();
                        break;
                    } else {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    }
                case 9:
                    if (m485a.f4998a == 11) {
                        this.f593e = jiVar.m490a();
                        break;
                    } else {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    }
                case 10:
                    if (m485a.f4998a == 15) {
                        jg m486a = jiVar.m486a();
                        this.f588a = new ArrayList(m486a.f777a);
                        for (int i2 = 0; i2 < m486a.f777a; i2++) {
                            this.f588a.add(jiVar.m490a());
                        }
                        jiVar.i();
                        break;
                    } else {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    }
                case 12:
                    if (m485a.f4998a == 11) {
                        this.f594f = jiVar.m490a();
                        break;
                    } else {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    }
                case 13:
                    if (m485a.f4998a == 2) {
                        this.f589a = jiVar.m494a();
                        b(true);
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
        this.f587a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m415a() {
        return this.f585a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m416a(ih ihVar) {
        if (ihVar == null) {
            return false;
        }
        boolean m415a = m415a();
        boolean m415a2 = ihVar.m415a();
        if ((m415a || m415a2) && !(m415a && m415a2 && this.f585a.m398a(ihVar.f585a))) {
            return false;
        }
        boolean m417b = m417b();
        boolean m417b2 = ihVar.m417b();
        if ((m417b || m417b2) && !(m417b && m417b2 && this.f586a.equals(ihVar.f586a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = ihVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f590b.equals(ihVar.f590b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = ihVar.d();
        if (((d2 || d3) && !(d2 && d3 && this.f591c.equals(ihVar.f591c))) || this.f584a != ihVar.f584a) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = ihVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f592d.equals(ihVar.f592d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = ihVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f593e.equals(ihVar.f593e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = ihVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f588a.equals(ihVar.f588a))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = ihVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f594f.equals(ihVar.f594f))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = ihVar.j();
        return !(j2 || j3) || (j2 && j3 && this.f589a == ihVar.f589a);
    }

    public String b() {
        return this.f594f;
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        m414a();
        jiVar.a(f583a);
        if (this.f585a != null && m415a()) {
            jiVar.a(f4975a);
            this.f585a.b(jiVar);
            jiVar.b();
        }
        if (this.f586a != null) {
            jiVar.a(b);
            jiVar.a(this.f586a);
            jiVar.b();
        }
        if (this.f590b != null) {
            jiVar.a(c);
            jiVar.a(this.f590b);
            jiVar.b();
        }
        if (this.f591c != null) {
            jiVar.a(d);
            jiVar.a(this.f591c);
            jiVar.b();
        }
        jiVar.a(e);
        jiVar.a(this.f584a);
        jiVar.b();
        if (this.f592d != null && f()) {
            jiVar.a(f);
            jiVar.a(this.f592d);
            jiVar.b();
        }
        if (this.f593e != null && g()) {
            jiVar.a(g);
            jiVar.a(this.f593e);
            jiVar.b();
        }
        if (this.f588a != null && h()) {
            jiVar.a(h);
            jiVar.a(new jg(Constants.GZIP_CAST_TYPE, this.f588a.size()));
            for (String str : this.f588a) {
                jiVar.a(str);
            }
            jiVar.e();
            jiVar.b();
        }
        if (this.f594f != null && i()) {
            jiVar.a(i);
            jiVar.a(this.f594f);
            jiVar.b();
        }
        if (j()) {
            jiVar.a(j);
            jiVar.a(this.f589a);
            jiVar.b();
        }
        jiVar.c();
        jiVar.m493a();
    }

    public void b(boolean z) {
        this.f587a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m417b() {
        return this.f586a != null;
    }

    public boolean c() {
        return this.f590b != null;
    }

    public boolean d() {
        return this.f591c != null;
    }

    public boolean e() {
        return this.f587a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ih)) {
            return m416a((ih) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f592d != null;
    }

    public boolean g() {
        return this.f593e != null;
    }

    public boolean h() {
        return this.f588a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f594f != null;
    }

    public boolean j() {
        return this.f587a.get(1);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionCommandResult(");
        boolean z = true;
        if (m415a()) {
            sb.append("target:");
            if (this.f585a == null) {
                sb.append("null");
            } else {
                sb.append(this.f585a);
            }
            z = false;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f586a == null) {
            sb.append("null");
        } else {
            sb.append(this.f586a);
        }
        sb.append(", ");
        sb.append("appId:");
        if (this.f590b == null) {
            sb.append("null");
        } else {
            sb.append(this.f590b);
        }
        sb.append(", ");
        sb.append("cmdName:");
        if (this.f591c == null) {
            sb.append("null");
        } else {
            sb.append(this.f591c);
        }
        sb.append(", ");
        sb.append("errorCode:");
        sb.append(this.f584a);
        if (f()) {
            sb.append(", ");
            sb.append("reason:");
            if (this.f592d == null) {
                sb.append("null");
            } else {
                sb.append(this.f592d);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f593e == null) {
                sb.append("null");
            } else {
                sb.append(this.f593e);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("cmdArgs:");
            if (this.f588a == null) {
                sb.append("null");
            } else {
                sb.append(this.f588a);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("category:");
            if (this.f594f == null) {
                sb.append("null");
            } else {
                sb.append(this.f594f);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("response2Client:");
            sb.append(this.f589a);
        }
        sb.append(")");
        return sb.toString();
    }
}
