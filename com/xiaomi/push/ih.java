package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
/* loaded from: classes6.dex */
public class ih implements ix<ih, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f666a;

    /* renamed from: a  reason: collision with other field name */
    public ib f667a;

    /* renamed from: a  reason: collision with other field name */
    public String f668a;

    /* renamed from: a  reason: collision with other field name */
    public List<String> f670a;

    /* renamed from: b  reason: collision with other field name */
    public String f672b;

    /* renamed from: c  reason: collision with other field name */
    public String f673c;

    /* renamed from: d  reason: collision with other field name */
    public String f674d;

    /* renamed from: e  reason: collision with other field name */
    public String f675e;

    /* renamed from: f  reason: collision with other field name */
    public String f676f;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f665a = new jn("XmPushActionCommandResult");

    /* renamed from: a  reason: collision with root package name */
    private static final jf f14433a = new jf("", (byte) 12, 2);

    /* renamed from: b  reason: collision with root package name */
    private static final jf f14434b = new jf("", Constants.GZIP_CAST_TYPE, 3);
    private static final jf c = new jf("", Constants.GZIP_CAST_TYPE, 4);
    private static final jf d = new jf("", Constants.GZIP_CAST_TYPE, 5);
    private static final jf e = new jf("", (byte) 10, 7);
    private static final jf f = new jf("", Constants.GZIP_CAST_TYPE, 8);
    private static final jf g = new jf("", Constants.GZIP_CAST_TYPE, 9);
    private static final jf h = new jf("", (byte) 15, 10);
    private static final jf i = new jf("", Constants.GZIP_CAST_TYPE, 12);
    private static final jf j = new jf("", (byte) 2, 13);

    /* renamed from: a  reason: collision with other field name */
    private BitSet f669a = new BitSet(2);

    /* renamed from: a  reason: collision with other field name */
    public boolean f671a = true;

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
            int compareTo = Boolean.valueOf(m445a()).compareTo(Boolean.valueOf(ihVar.m445a()));
            if (compareTo == 0) {
                if (!m445a() || (a11 = iy.a(this.f667a, ihVar.f667a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m447b()).compareTo(Boolean.valueOf(ihVar.m447b()));
                    if (compareTo2 == 0) {
                        if (!m447b() || (a10 = iy.a(this.f668a, ihVar.f668a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(ihVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a9 = iy.a(this.f672b, ihVar.f672b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(ihVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a8 = iy.a(this.f673c, ihVar.f673c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(ihVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a7 = iy.a(this.f666a, ihVar.f666a)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(ihVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a6 = iy.a(this.f674d, ihVar.f674d)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ihVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a5 = iy.a(this.f675e, ihVar.f675e)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(ihVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a4 = iy.a(this.f670a, ihVar.f670a)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(ihVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a3 = iy.a(this.f676f, ihVar.f676f)) == 0) {
                                                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(ihVar.j()));
                                                                                    if (compareTo10 == 0) {
                                                                                        if (!j() || (a2 = iy.a(this.f671a, ihVar.f671a)) == 0) {
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
        return this.f673c;
    }

    /* renamed from: a  reason: collision with other method in class */
    public List<String> m443a() {
        return this.f670a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m444a() {
        if (this.f668a == null) {
            throw new jj("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f672b == null) {
            throw new jj("Required field 'appId' was not present! Struct: " + toString());
        }
        if (this.f673c == null) {
            throw new jj("Required field 'cmdName' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m519a();
        while (true) {
            jf m515a = jiVar.m515a();
            if (m515a.f14471a == 0) {
                jiVar.f();
                if (!e()) {
                    throw new jj("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
                }
                m444a();
                return;
            }
            switch (m515a.f858a) {
                case 2:
                    if (m515a.f14471a == 12) {
                        this.f667a = new ib();
                        this.f667a.a(jiVar);
                        break;
                    } else {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    }
                case 3:
                    if (m515a.f14471a == 11) {
                        this.f668a = jiVar.m520a();
                        break;
                    } else {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    }
                case 4:
                    if (m515a.f14471a == 11) {
                        this.f672b = jiVar.m520a();
                        break;
                    } else {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    }
                case 5:
                    if (m515a.f14471a == 11) {
                        this.f673c = jiVar.m520a();
                        break;
                    } else {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    }
                case 6:
                case 11:
                default:
                    jl.a(jiVar, m515a.f14471a);
                    break;
                case 7:
                    if (m515a.f14471a == 10) {
                        this.f666a = jiVar.m514a();
                        a(true);
                        break;
                    } else {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    }
                case 8:
                    if (m515a.f14471a == 11) {
                        this.f674d = jiVar.m520a();
                        break;
                    } else {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    }
                case 9:
                    if (m515a.f14471a == 11) {
                        this.f675e = jiVar.m520a();
                        break;
                    } else {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    }
                case 10:
                    if (m515a.f14471a == 15) {
                        jg m516a = jiVar.m516a();
                        this.f670a = new ArrayList(m516a.f859a);
                        for (int i2 = 0; i2 < m516a.f859a; i2++) {
                            this.f670a.add(jiVar.m520a());
                        }
                        jiVar.i();
                        break;
                    } else {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    }
                case 12:
                    if (m515a.f14471a == 11) {
                        this.f676f = jiVar.m520a();
                        break;
                    } else {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    }
                case 13:
                    if (m515a.f14471a == 2) {
                        this.f671a = jiVar.m524a();
                        b(true);
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
        this.f669a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m445a() {
        return this.f667a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m446a(ih ihVar) {
        if (ihVar == null) {
            return false;
        }
        boolean m445a = m445a();
        boolean m445a2 = ihVar.m445a();
        if ((m445a || m445a2) && !(m445a && m445a2 && this.f667a.m428a(ihVar.f667a))) {
            return false;
        }
        boolean m447b = m447b();
        boolean m447b2 = ihVar.m447b();
        if ((m447b || m447b2) && !(m447b && m447b2 && this.f668a.equals(ihVar.f668a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = ihVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f672b.equals(ihVar.f672b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = ihVar.d();
        if (((d2 || d3) && !(d2 && d3 && this.f673c.equals(ihVar.f673c))) || this.f666a != ihVar.f666a) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = ihVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f674d.equals(ihVar.f674d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = ihVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f675e.equals(ihVar.f675e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = ihVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f670a.equals(ihVar.f670a))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = ihVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f676f.equals(ihVar.f676f))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = ihVar.j();
        return !(j2 || j3) || (j2 && j3 && this.f671a == ihVar.f671a);
    }

    public String b() {
        return this.f676f;
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        m444a();
        jiVar.a(f665a);
        if (this.f667a != null && m445a()) {
            jiVar.a(f14433a);
            this.f667a.b(jiVar);
            jiVar.b();
        }
        if (this.f668a != null) {
            jiVar.a(f14434b);
            jiVar.a(this.f668a);
            jiVar.b();
        }
        if (this.f672b != null) {
            jiVar.a(c);
            jiVar.a(this.f672b);
            jiVar.b();
        }
        if (this.f673c != null) {
            jiVar.a(d);
            jiVar.a(this.f673c);
            jiVar.b();
        }
        jiVar.a(e);
        jiVar.a(this.f666a);
        jiVar.b();
        if (this.f674d != null && f()) {
            jiVar.a(f);
            jiVar.a(this.f674d);
            jiVar.b();
        }
        if (this.f675e != null && g()) {
            jiVar.a(g);
            jiVar.a(this.f675e);
            jiVar.b();
        }
        if (this.f670a != null && h()) {
            jiVar.a(h);
            jiVar.a(new jg(Constants.GZIP_CAST_TYPE, this.f670a.size()));
            for (String str : this.f670a) {
                jiVar.a(str);
            }
            jiVar.e();
            jiVar.b();
        }
        if (this.f676f != null && i()) {
            jiVar.a(i);
            jiVar.a(this.f676f);
            jiVar.b();
        }
        if (j()) {
            jiVar.a(j);
            jiVar.a(this.f671a);
            jiVar.b();
        }
        jiVar.c();
        jiVar.m523a();
    }

    public void b(boolean z) {
        this.f669a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m447b() {
        return this.f668a != null;
    }

    public boolean c() {
        return this.f672b != null;
    }

    public boolean d() {
        return this.f673c != null;
    }

    public boolean e() {
        return this.f669a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ih)) {
            return m446a((ih) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f674d != null;
    }

    public boolean g() {
        return this.f675e != null;
    }

    public boolean h() {
        return this.f670a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f676f != null;
    }

    public boolean j() {
        return this.f669a.get(1);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionCommandResult(");
        boolean z = true;
        if (m445a()) {
            sb.append("target:");
            if (this.f667a == null) {
                sb.append("null");
            } else {
                sb.append(this.f667a);
            }
            z = false;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f668a == null) {
            sb.append("null");
        } else {
            sb.append(this.f668a);
        }
        sb.append(", ");
        sb.append("appId:");
        if (this.f672b == null) {
            sb.append("null");
        } else {
            sb.append(this.f672b);
        }
        sb.append(", ");
        sb.append("cmdName:");
        if (this.f673c == null) {
            sb.append("null");
        } else {
            sb.append(this.f673c);
        }
        sb.append(", ");
        sb.append("errorCode:");
        sb.append(this.f666a);
        if (f()) {
            sb.append(", ");
            sb.append("reason:");
            if (this.f674d == null) {
                sb.append("null");
            } else {
                sb.append(this.f674d);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f675e == null) {
                sb.append("null");
            } else {
                sb.append(this.f675e);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("cmdArgs:");
            if (this.f670a == null) {
                sb.append("null");
            } else {
                sb.append(this.f670a);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("category:");
            if (this.f676f == null) {
                sb.append("null");
            } else {
                sb.append(this.f676f);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("response2Client:");
            sb.append(this.f671a);
        }
        sb.append(")");
        return sb.toString();
    }
}
