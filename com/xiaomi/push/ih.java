package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
/* loaded from: classes6.dex */
public class ih implements ix<ih, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f665a;

    /* renamed from: a  reason: collision with other field name */
    public ib f666a;

    /* renamed from: a  reason: collision with other field name */
    public String f667a;

    /* renamed from: a  reason: collision with other field name */
    public List<String> f669a;

    /* renamed from: b  reason: collision with other field name */
    public String f671b;

    /* renamed from: c  reason: collision with other field name */
    public String f672c;

    /* renamed from: d  reason: collision with other field name */
    public String f673d;

    /* renamed from: e  reason: collision with other field name */
    public String f674e;

    /* renamed from: f  reason: collision with other field name */
    public String f675f;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f664a = new jn("XmPushActionCommandResult");

    /* renamed from: a  reason: collision with root package name */
    private static final jf f14135a = new jf("", (byte) 12, 2);

    /* renamed from: b  reason: collision with root package name */
    private static final jf f14136b = new jf("", Constants.GZIP_CAST_TYPE, 3);
    private static final jf c = new jf("", Constants.GZIP_CAST_TYPE, 4);
    private static final jf d = new jf("", Constants.GZIP_CAST_TYPE, 5);
    private static final jf e = new jf("", (byte) 10, 7);
    private static final jf f = new jf("", Constants.GZIP_CAST_TYPE, 8);
    private static final jf g = new jf("", Constants.GZIP_CAST_TYPE, 9);
    private static final jf h = new jf("", (byte) 15, 10);
    private static final jf i = new jf("", Constants.GZIP_CAST_TYPE, 12);
    private static final jf j = new jf("", (byte) 2, 13);

    /* renamed from: a  reason: collision with other field name */
    private BitSet f668a = new BitSet(2);

    /* renamed from: a  reason: collision with other field name */
    public boolean f670a = true;

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
            int compareTo = Boolean.valueOf(m441a()).compareTo(Boolean.valueOf(ihVar.m441a()));
            if (compareTo == 0) {
                if (!m441a() || (a11 = iy.a(this.f666a, ihVar.f666a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m443b()).compareTo(Boolean.valueOf(ihVar.m443b()));
                    if (compareTo2 == 0) {
                        if (!m443b() || (a10 = iy.a(this.f667a, ihVar.f667a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(ihVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a9 = iy.a(this.f671b, ihVar.f671b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(ihVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a8 = iy.a(this.f672c, ihVar.f672c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(ihVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a7 = iy.a(this.f665a, ihVar.f665a)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(ihVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a6 = iy.a(this.f673d, ihVar.f673d)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ihVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a5 = iy.a(this.f674e, ihVar.f674e)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(ihVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a4 = iy.a(this.f669a, ihVar.f669a)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(ihVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a3 = iy.a(this.f675f, ihVar.f675f)) == 0) {
                                                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(ihVar.j()));
                                                                                    if (compareTo10 == 0) {
                                                                                        if (!j() || (a2 = iy.a(this.f670a, ihVar.f670a)) == 0) {
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
        return this.f672c;
    }

    /* renamed from: a  reason: collision with other method in class */
    public List<String> m439a() {
        return this.f669a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m440a() {
        if (this.f667a == null) {
            throw new jj("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f671b == null) {
            throw new jj("Required field 'appId' was not present! Struct: " + toString());
        }
        if (this.f672c == null) {
            throw new jj("Required field 'cmdName' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m515a();
        while (true) {
            jf m511a = jiVar.m511a();
            if (m511a.f14173a == 0) {
                jiVar.f();
                if (!e()) {
                    throw new jj("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
                }
                m440a();
                return;
            }
            switch (m511a.f857a) {
                case 2:
                    if (m511a.f14173a == 12) {
                        this.f666a = new ib();
                        this.f666a.a(jiVar);
                        break;
                    } else {
                        jl.a(jiVar, m511a.f14173a);
                        break;
                    }
                case 3:
                    if (m511a.f14173a == 11) {
                        this.f667a = jiVar.m516a();
                        break;
                    } else {
                        jl.a(jiVar, m511a.f14173a);
                        break;
                    }
                case 4:
                    if (m511a.f14173a == 11) {
                        this.f671b = jiVar.m516a();
                        break;
                    } else {
                        jl.a(jiVar, m511a.f14173a);
                        break;
                    }
                case 5:
                    if (m511a.f14173a == 11) {
                        this.f672c = jiVar.m516a();
                        break;
                    } else {
                        jl.a(jiVar, m511a.f14173a);
                        break;
                    }
                case 6:
                case 11:
                default:
                    jl.a(jiVar, m511a.f14173a);
                    break;
                case 7:
                    if (m511a.f14173a == 10) {
                        this.f665a = jiVar.m510a();
                        a(true);
                        break;
                    } else {
                        jl.a(jiVar, m511a.f14173a);
                        break;
                    }
                case 8:
                    if (m511a.f14173a == 11) {
                        this.f673d = jiVar.m516a();
                        break;
                    } else {
                        jl.a(jiVar, m511a.f14173a);
                        break;
                    }
                case 9:
                    if (m511a.f14173a == 11) {
                        this.f674e = jiVar.m516a();
                        break;
                    } else {
                        jl.a(jiVar, m511a.f14173a);
                        break;
                    }
                case 10:
                    if (m511a.f14173a == 15) {
                        jg m512a = jiVar.m512a();
                        this.f669a = new ArrayList(m512a.f858a);
                        for (int i2 = 0; i2 < m512a.f858a; i2++) {
                            this.f669a.add(jiVar.m516a());
                        }
                        jiVar.i();
                        break;
                    } else {
                        jl.a(jiVar, m511a.f14173a);
                        break;
                    }
                case 12:
                    if (m511a.f14173a == 11) {
                        this.f675f = jiVar.m516a();
                        break;
                    } else {
                        jl.a(jiVar, m511a.f14173a);
                        break;
                    }
                case 13:
                    if (m511a.f14173a == 2) {
                        this.f670a = jiVar.m520a();
                        b(true);
                        break;
                    } else {
                        jl.a(jiVar, m511a.f14173a);
                        break;
                    }
            }
            jiVar.g();
        }
    }

    public void a(boolean z) {
        this.f668a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m441a() {
        return this.f666a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m442a(ih ihVar) {
        if (ihVar == null) {
            return false;
        }
        boolean m441a = m441a();
        boolean m441a2 = ihVar.m441a();
        if ((m441a || m441a2) && !(m441a && m441a2 && this.f666a.m424a(ihVar.f666a))) {
            return false;
        }
        boolean m443b = m443b();
        boolean m443b2 = ihVar.m443b();
        if ((m443b || m443b2) && !(m443b && m443b2 && this.f667a.equals(ihVar.f667a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = ihVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f671b.equals(ihVar.f671b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = ihVar.d();
        if (((d2 || d3) && !(d2 && d3 && this.f672c.equals(ihVar.f672c))) || this.f665a != ihVar.f665a) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = ihVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f673d.equals(ihVar.f673d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = ihVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f674e.equals(ihVar.f674e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = ihVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f669a.equals(ihVar.f669a))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = ihVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f675f.equals(ihVar.f675f))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = ihVar.j();
        return !(j2 || j3) || (j2 && j3 && this.f670a == ihVar.f670a);
    }

    public String b() {
        return this.f675f;
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        m440a();
        jiVar.a(f664a);
        if (this.f666a != null && m441a()) {
            jiVar.a(f14135a);
            this.f666a.b(jiVar);
            jiVar.b();
        }
        if (this.f667a != null) {
            jiVar.a(f14136b);
            jiVar.a(this.f667a);
            jiVar.b();
        }
        if (this.f671b != null) {
            jiVar.a(c);
            jiVar.a(this.f671b);
            jiVar.b();
        }
        if (this.f672c != null) {
            jiVar.a(d);
            jiVar.a(this.f672c);
            jiVar.b();
        }
        jiVar.a(e);
        jiVar.a(this.f665a);
        jiVar.b();
        if (this.f673d != null && f()) {
            jiVar.a(f);
            jiVar.a(this.f673d);
            jiVar.b();
        }
        if (this.f674e != null && g()) {
            jiVar.a(g);
            jiVar.a(this.f674e);
            jiVar.b();
        }
        if (this.f669a != null && h()) {
            jiVar.a(h);
            jiVar.a(new jg(Constants.GZIP_CAST_TYPE, this.f669a.size()));
            for (String str : this.f669a) {
                jiVar.a(str);
            }
            jiVar.e();
            jiVar.b();
        }
        if (this.f675f != null && i()) {
            jiVar.a(i);
            jiVar.a(this.f675f);
            jiVar.b();
        }
        if (j()) {
            jiVar.a(j);
            jiVar.a(this.f670a);
            jiVar.b();
        }
        jiVar.c();
        jiVar.m519a();
    }

    public void b(boolean z) {
        this.f668a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m443b() {
        return this.f667a != null;
    }

    public boolean c() {
        return this.f671b != null;
    }

    public boolean d() {
        return this.f672c != null;
    }

    public boolean e() {
        return this.f668a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ih)) {
            return m442a((ih) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f673d != null;
    }

    public boolean g() {
        return this.f674e != null;
    }

    public boolean h() {
        return this.f669a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f675f != null;
    }

    public boolean j() {
        return this.f668a.get(1);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionCommandResult(");
        boolean z = true;
        if (m441a()) {
            sb.append("target:");
            if (this.f666a == null) {
                sb.append("null");
            } else {
                sb.append(this.f666a);
            }
            z = false;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f667a == null) {
            sb.append("null");
        } else {
            sb.append(this.f667a);
        }
        sb.append(", ");
        sb.append("appId:");
        if (this.f671b == null) {
            sb.append("null");
        } else {
            sb.append(this.f671b);
        }
        sb.append(", ");
        sb.append("cmdName:");
        if (this.f672c == null) {
            sb.append("null");
        } else {
            sb.append(this.f672c);
        }
        sb.append(", ");
        sb.append("errorCode:");
        sb.append(this.f665a);
        if (f()) {
            sb.append(", ");
            sb.append("reason:");
            if (this.f673d == null) {
                sb.append("null");
            } else {
                sb.append(this.f673d);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f674e == null) {
                sb.append("null");
            } else {
                sb.append(this.f674e);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("cmdArgs:");
            if (this.f669a == null) {
                sb.append("null");
            } else {
                sb.append(this.f669a);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("category:");
            if (this.f675f == null) {
                sb.append("null");
            } else {
                sb.append(this.f675f);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("response2Client:");
            sb.append(this.f670a);
        }
        sb.append(")");
        return sb.toString();
    }
}
