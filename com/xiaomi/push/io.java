package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes6.dex */
public class io implements ix<io, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f759a;

    /* renamed from: a  reason: collision with other field name */
    public ib f760a;

    /* renamed from: a  reason: collision with other field name */
    public String f761a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f762a = new BitSet(1);

    /* renamed from: b  reason: collision with other field name */
    public String f763b;

    /* renamed from: c  reason: collision with other field name */
    public String f764c;

    /* renamed from: d  reason: collision with other field name */
    public String f765d;

    /* renamed from: e  reason: collision with other field name */
    public String f766e;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f758a = new jn("XmPushActionSendFeedbackResult");

    /* renamed from: a  reason: collision with root package name */
    private static final jf f14445a = new jf("", Constants.GZIP_CAST_TYPE, 1);

    /* renamed from: b  reason: collision with root package name */
    private static final jf f14446b = new jf("", (byte) 12, 2);
    private static final jf c = new jf("", Constants.GZIP_CAST_TYPE, 3);
    private static final jf d = new jf("", Constants.GZIP_CAST_TYPE, 4);
    private static final jf e = new jf("", (byte) 10, 6);
    private static final jf f = new jf("", Constants.GZIP_CAST_TYPE, 7);
    private static final jf g = new jf("", Constants.GZIP_CAST_TYPE, 8);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(io ioVar) {
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        int a8;
        if (getClass().equals(ioVar.getClass())) {
            int compareTo = Boolean.valueOf(m481a()).compareTo(Boolean.valueOf(ioVar.m481a()));
            if (compareTo == 0) {
                if (!m481a() || (a8 = iy.a(this.f761a, ioVar.f761a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(ioVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a7 = iy.a(this.f760a, ioVar.f760a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(ioVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a6 = iy.a(this.f763b, ioVar.f763b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(ioVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a5 = iy.a(this.f764c, ioVar.f764c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(ioVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a4 = iy.a(this.f759a, ioVar.f759a)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(ioVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a3 = iy.a(this.f765d, ioVar.f765d)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ioVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a2 = iy.a(this.f766e, ioVar.f766e)) == 0) {
                                                                    return 0;
                                                                }
                                                                return a2;
                                                            }
                                                            return compareTo7;
                                                        }
                                                        return a3;
                                                    }
                                                    return compareTo6;
                                                }
                                                return a4;
                                            }
                                            return compareTo5;
                                        }
                                        return a5;
                                    }
                                    return compareTo4;
                                }
                                return a6;
                            }
                            return compareTo3;
                        }
                        return a7;
                    }
                    return compareTo2;
                }
                return a8;
            }
            return compareTo;
        }
        return getClass().getName().compareTo(ioVar.getClass().getName());
    }

    public void a() {
        if (this.f763b == null) {
            throw new jj("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f764c == null) {
            throw new jj("Required field 'appId' was not present! Struct: " + toString());
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
                a();
                return;
            }
            switch (m515a.f858a) {
                case 1:
                    if (m515a.f14471a != 11) {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    } else {
                        this.f761a = jiVar.m520a();
                        break;
                    }
                case 2:
                    if (m515a.f14471a != 12) {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    } else {
                        this.f760a = new ib();
                        this.f760a.a(jiVar);
                        break;
                    }
                case 3:
                    if (m515a.f14471a != 11) {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    } else {
                        this.f763b = jiVar.m520a();
                        break;
                    }
                case 4:
                    if (m515a.f14471a != 11) {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    } else {
                        this.f764c = jiVar.m520a();
                        break;
                    }
                case 5:
                default:
                    jl.a(jiVar, m515a.f14471a);
                    break;
                case 6:
                    if (m515a.f14471a != 10) {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    } else {
                        this.f759a = jiVar.m514a();
                        a(true);
                        break;
                    }
                case 7:
                    if (m515a.f14471a != 11) {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    } else {
                        this.f765d = jiVar.m520a();
                        break;
                    }
                case 8:
                    if (m515a.f14471a != 11) {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    } else {
                        this.f766e = jiVar.m520a();
                        break;
                    }
            }
            jiVar.g();
        }
    }

    public void a(boolean z) {
        this.f762a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m481a() {
        return this.f761a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m482a(io ioVar) {
        if (ioVar == null) {
            return false;
        }
        boolean m481a = m481a();
        boolean m481a2 = ioVar.m481a();
        if ((m481a || m481a2) && !(m481a && m481a2 && this.f761a.equals(ioVar.f761a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = ioVar.b();
        if ((b2 || b3) && !(b2 && b3 && this.f760a.m428a(ioVar.f760a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = ioVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f763b.equals(ioVar.f763b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = ioVar.d();
        if (((d2 || d3) && !(d2 && d3 && this.f764c.equals(ioVar.f764c))) || this.f759a != ioVar.f759a) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = ioVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f765d.equals(ioVar.f765d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = ioVar.g();
        return !(g2 || g3) || (g2 && g3 && this.f766e.equals(ioVar.f766e));
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        a();
        jiVar.a(f758a);
        if (this.f761a != null && m481a()) {
            jiVar.a(f14445a);
            jiVar.a(this.f761a);
            jiVar.b();
        }
        if (this.f760a != null && b()) {
            jiVar.a(f14446b);
            this.f760a.b(jiVar);
            jiVar.b();
        }
        if (this.f763b != null) {
            jiVar.a(c);
            jiVar.a(this.f763b);
            jiVar.b();
        }
        if (this.f764c != null) {
            jiVar.a(d);
            jiVar.a(this.f764c);
            jiVar.b();
        }
        jiVar.a(e);
        jiVar.a(this.f759a);
        jiVar.b();
        if (this.f765d != null && f()) {
            jiVar.a(f);
            jiVar.a(this.f765d);
            jiVar.b();
        }
        if (this.f766e != null && g()) {
            jiVar.a(g);
            jiVar.a(this.f766e);
            jiVar.b();
        }
        jiVar.c();
        jiVar.m523a();
    }

    public boolean b() {
        return this.f760a != null;
    }

    public boolean c() {
        return this.f763b != null;
    }

    public boolean d() {
        return this.f764c != null;
    }

    public boolean e() {
        return this.f762a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof io)) {
            return m482a((io) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f765d != null;
    }

    public boolean g() {
        return this.f766e != null;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionSendFeedbackResult(");
        boolean z2 = true;
        if (m481a()) {
            sb.append("debug:");
            if (this.f761a == null) {
                sb.append("null");
            } else {
                sb.append(this.f761a);
            }
            z2 = false;
        }
        if (b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f760a == null) {
                sb.append("null");
            } else {
                sb.append(this.f760a);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f763b == null) {
            sb.append("null");
        } else {
            sb.append(this.f763b);
        }
        sb.append(", ");
        sb.append("appId:");
        if (this.f764c == null) {
            sb.append("null");
        } else {
            sb.append(this.f764c);
        }
        sb.append(", ");
        sb.append("errorCode:");
        sb.append(this.f759a);
        if (f()) {
            sb.append(", ");
            sb.append("reason:");
            if (this.f765d == null) {
                sb.append("null");
            } else {
                sb.append(this.f765d);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("category:");
            if (this.f766e == null) {
                sb.append("null");
            } else {
                sb.append(this.f766e);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
