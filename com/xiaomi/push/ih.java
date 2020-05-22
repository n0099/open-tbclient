package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
/* loaded from: classes8.dex */
public class ih implements ix<ih, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f585a;

    /* renamed from: a  reason: collision with other field name */
    public ib f586a;

    /* renamed from: a  reason: collision with other field name */
    public String f587a;

    /* renamed from: a  reason: collision with other field name */
    public List<String> f589a;

    /* renamed from: b  reason: collision with other field name */
    public String f591b;

    /* renamed from: c  reason: collision with other field name */
    public String f592c;

    /* renamed from: d  reason: collision with other field name */
    public String f593d;

    /* renamed from: e  reason: collision with other field name */
    public String f594e;

    /* renamed from: f  reason: collision with other field name */
    public String f595f;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f584a = new jn("XmPushActionCommandResult");
    private static final jf a = new jf("", (byte) 12, 2);
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
    private BitSet f588a = new BitSet(2);

    /* renamed from: a  reason: collision with other field name */
    public boolean f590a = true;

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
            int compareTo = Boolean.valueOf(m413a()).compareTo(Boolean.valueOf(ihVar.m413a()));
            if (compareTo == 0) {
                if (!m413a() || (a11 = iy.a(this.f586a, ihVar.f586a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m415b()).compareTo(Boolean.valueOf(ihVar.m415b()));
                    if (compareTo2 == 0) {
                        if (!m415b() || (a10 = iy.a(this.f587a, ihVar.f587a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(ihVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a9 = iy.a(this.f591b, ihVar.f591b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(ihVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a8 = iy.a(this.f592c, ihVar.f592c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(ihVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a7 = iy.a(this.f585a, ihVar.f585a)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(ihVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a6 = iy.a(this.f593d, ihVar.f593d)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ihVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a5 = iy.a(this.f594e, ihVar.f594e)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(ihVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a4 = iy.a(this.f589a, ihVar.f589a)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(ihVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a3 = iy.a(this.f595f, ihVar.f595f)) == 0) {
                                                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(ihVar.j()));
                                                                                    if (compareTo10 == 0) {
                                                                                        if (!j() || (a2 = iy.a(this.f590a, ihVar.f590a)) == 0) {
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
        return this.f592c;
    }

    /* renamed from: a  reason: collision with other method in class */
    public List<String> m411a() {
        return this.f589a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m412a() {
        if (this.f587a == null) {
            throw new jj("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f591b == null) {
            throw new jj("Required field 'appId' was not present! Struct: " + toString());
        }
        if (this.f592c == null) {
            throw new jj("Required field 'cmdName' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m487a();
        while (true) {
            jf m483a = jiVar.m483a();
            if (m483a.a == 0) {
                jiVar.f();
                if (!e()) {
                    throw new jj("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
                }
                m412a();
                return;
            }
            switch (m483a.f777a) {
                case 2:
                    if (m483a.a == 12) {
                        this.f586a = new ib();
                        this.f586a.a(jiVar);
                        break;
                    } else {
                        jl.a(jiVar, m483a.a);
                        break;
                    }
                case 3:
                    if (m483a.a == 11) {
                        this.f587a = jiVar.m488a();
                        break;
                    } else {
                        jl.a(jiVar, m483a.a);
                        break;
                    }
                case 4:
                    if (m483a.a == 11) {
                        this.f591b = jiVar.m488a();
                        break;
                    } else {
                        jl.a(jiVar, m483a.a);
                        break;
                    }
                case 5:
                    if (m483a.a == 11) {
                        this.f592c = jiVar.m488a();
                        break;
                    } else {
                        jl.a(jiVar, m483a.a);
                        break;
                    }
                case 6:
                case 11:
                default:
                    jl.a(jiVar, m483a.a);
                    break;
                case 7:
                    if (m483a.a == 10) {
                        this.f585a = jiVar.m482a();
                        a(true);
                        break;
                    } else {
                        jl.a(jiVar, m483a.a);
                        break;
                    }
                case 8:
                    if (m483a.a == 11) {
                        this.f593d = jiVar.m488a();
                        break;
                    } else {
                        jl.a(jiVar, m483a.a);
                        break;
                    }
                case 9:
                    if (m483a.a == 11) {
                        this.f594e = jiVar.m488a();
                        break;
                    } else {
                        jl.a(jiVar, m483a.a);
                        break;
                    }
                case 10:
                    if (m483a.a == 15) {
                        jg m484a = jiVar.m484a();
                        this.f589a = new ArrayList(m484a.f778a);
                        for (int i2 = 0; i2 < m484a.f778a; i2++) {
                            this.f589a.add(jiVar.m488a());
                        }
                        jiVar.i();
                        break;
                    } else {
                        jl.a(jiVar, m483a.a);
                        break;
                    }
                case 12:
                    if (m483a.a == 11) {
                        this.f595f = jiVar.m488a();
                        break;
                    } else {
                        jl.a(jiVar, m483a.a);
                        break;
                    }
                case 13:
                    if (m483a.a == 2) {
                        this.f590a = jiVar.m492a();
                        b(true);
                        break;
                    } else {
                        jl.a(jiVar, m483a.a);
                        break;
                    }
            }
            jiVar.g();
        }
    }

    public void a(boolean z) {
        this.f588a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m413a() {
        return this.f586a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m414a(ih ihVar) {
        if (ihVar == null) {
            return false;
        }
        boolean m413a = m413a();
        boolean m413a2 = ihVar.m413a();
        if ((m413a || m413a2) && !(m413a && m413a2 && this.f586a.m396a(ihVar.f586a))) {
            return false;
        }
        boolean m415b = m415b();
        boolean m415b2 = ihVar.m415b();
        if ((m415b || m415b2) && !(m415b && m415b2 && this.f587a.equals(ihVar.f587a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = ihVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f591b.equals(ihVar.f591b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = ihVar.d();
        if (((d2 || d3) && !(d2 && d3 && this.f592c.equals(ihVar.f592c))) || this.f585a != ihVar.f585a) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = ihVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f593d.equals(ihVar.f593d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = ihVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f594e.equals(ihVar.f594e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = ihVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f589a.equals(ihVar.f589a))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = ihVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f595f.equals(ihVar.f595f))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = ihVar.j();
        return !(j2 || j3) || (j2 && j3 && this.f590a == ihVar.f590a);
    }

    public String b() {
        return this.f595f;
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        m412a();
        jiVar.a(f584a);
        if (this.f586a != null && m413a()) {
            jiVar.a(a);
            this.f586a.b(jiVar);
            jiVar.b();
        }
        if (this.f587a != null) {
            jiVar.a(b);
            jiVar.a(this.f587a);
            jiVar.b();
        }
        if (this.f591b != null) {
            jiVar.a(c);
            jiVar.a(this.f591b);
            jiVar.b();
        }
        if (this.f592c != null) {
            jiVar.a(d);
            jiVar.a(this.f592c);
            jiVar.b();
        }
        jiVar.a(e);
        jiVar.a(this.f585a);
        jiVar.b();
        if (this.f593d != null && f()) {
            jiVar.a(f);
            jiVar.a(this.f593d);
            jiVar.b();
        }
        if (this.f594e != null && g()) {
            jiVar.a(g);
            jiVar.a(this.f594e);
            jiVar.b();
        }
        if (this.f589a != null && h()) {
            jiVar.a(h);
            jiVar.a(new jg(Constants.GZIP_CAST_TYPE, this.f589a.size()));
            for (String str : this.f589a) {
                jiVar.a(str);
            }
            jiVar.e();
            jiVar.b();
        }
        if (this.f595f != null && i()) {
            jiVar.a(i);
            jiVar.a(this.f595f);
            jiVar.b();
        }
        if (j()) {
            jiVar.a(j);
            jiVar.a(this.f590a);
            jiVar.b();
        }
        jiVar.c();
        jiVar.m491a();
    }

    public void b(boolean z) {
        this.f588a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m415b() {
        return this.f587a != null;
    }

    public boolean c() {
        return this.f591b != null;
    }

    public boolean d() {
        return this.f592c != null;
    }

    public boolean e() {
        return this.f588a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ih)) {
            return m414a((ih) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f593d != null;
    }

    public boolean g() {
        return this.f594e != null;
    }

    public boolean h() {
        return this.f589a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f595f != null;
    }

    public boolean j() {
        return this.f588a.get(1);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionCommandResult(");
        boolean z = true;
        if (m413a()) {
            sb.append("target:");
            if (this.f586a == null) {
                sb.append("null");
            } else {
                sb.append(this.f586a);
            }
            z = false;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f587a == null) {
            sb.append("null");
        } else {
            sb.append(this.f587a);
        }
        sb.append(", ");
        sb.append("appId:");
        if (this.f591b == null) {
            sb.append("null");
        } else {
            sb.append(this.f591b);
        }
        sb.append(", ");
        sb.append("cmdName:");
        if (this.f592c == null) {
            sb.append("null");
        } else {
            sb.append(this.f592c);
        }
        sb.append(", ");
        sb.append("errorCode:");
        sb.append(this.f585a);
        if (f()) {
            sb.append(", ");
            sb.append("reason:");
            if (this.f593d == null) {
                sb.append("null");
            } else {
                sb.append(this.f593d);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f594e == null) {
                sb.append("null");
            } else {
                sb.append(this.f594e);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("cmdArgs:");
            if (this.f589a == null) {
                sb.append("null");
            } else {
                sb.append(this.f589a);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("category:");
            if (this.f595f == null) {
                sb.append("null");
            } else {
                sb.append(this.f595f);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("response2Client:");
            sb.append(this.f590a);
        }
        sb.append(")");
        return sb.toString();
    }
}
