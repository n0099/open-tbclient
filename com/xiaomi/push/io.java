package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes6.dex */
public class io implements ix<io, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f758a;

    /* renamed from: a  reason: collision with other field name */
    public ib f759a;

    /* renamed from: a  reason: collision with other field name */
    public String f760a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f761a = new BitSet(1);

    /* renamed from: b  reason: collision with other field name */
    public String f762b;

    /* renamed from: c  reason: collision with other field name */
    public String f763c;

    /* renamed from: d  reason: collision with other field name */
    public String f764d;

    /* renamed from: e  reason: collision with other field name */
    public String f765e;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f757a = new jn("XmPushActionSendFeedbackResult");

    /* renamed from: a  reason: collision with root package name */
    private static final jf f14145a = new jf("", Constants.GZIP_CAST_TYPE, 1);

    /* renamed from: b  reason: collision with root package name */
    private static final jf f14146b = new jf("", (byte) 12, 2);
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
            int compareTo = Boolean.valueOf(m477a()).compareTo(Boolean.valueOf(ioVar.m477a()));
            if (compareTo == 0) {
                if (!m477a() || (a8 = iy.a(this.f760a, ioVar.f760a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(ioVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a7 = iy.a(this.f759a, ioVar.f759a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(ioVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a6 = iy.a(this.f762b, ioVar.f762b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(ioVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a5 = iy.a(this.f763c, ioVar.f763c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(ioVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a4 = iy.a(this.f758a, ioVar.f758a)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(ioVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a3 = iy.a(this.f764d, ioVar.f764d)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ioVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a2 = iy.a(this.f765e, ioVar.f765e)) == 0) {
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
        if (this.f762b == null) {
            throw new jj("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f763c == null) {
            throw new jj("Required field 'appId' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m515a();
        while (true) {
            jf m511a = jiVar.m511a();
            if (m511a.f14171a == 0) {
                jiVar.f();
                if (!e()) {
                    throw new jj("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
                }
                a();
                return;
            }
            switch (m511a.f857a) {
                case 1:
                    if (m511a.f14171a != 11) {
                        jl.a(jiVar, m511a.f14171a);
                        break;
                    } else {
                        this.f760a = jiVar.m516a();
                        break;
                    }
                case 2:
                    if (m511a.f14171a != 12) {
                        jl.a(jiVar, m511a.f14171a);
                        break;
                    } else {
                        this.f759a = new ib();
                        this.f759a.a(jiVar);
                        break;
                    }
                case 3:
                    if (m511a.f14171a != 11) {
                        jl.a(jiVar, m511a.f14171a);
                        break;
                    } else {
                        this.f762b = jiVar.m516a();
                        break;
                    }
                case 4:
                    if (m511a.f14171a != 11) {
                        jl.a(jiVar, m511a.f14171a);
                        break;
                    } else {
                        this.f763c = jiVar.m516a();
                        break;
                    }
                case 5:
                default:
                    jl.a(jiVar, m511a.f14171a);
                    break;
                case 6:
                    if (m511a.f14171a != 10) {
                        jl.a(jiVar, m511a.f14171a);
                        break;
                    } else {
                        this.f758a = jiVar.m510a();
                        a(true);
                        break;
                    }
                case 7:
                    if (m511a.f14171a != 11) {
                        jl.a(jiVar, m511a.f14171a);
                        break;
                    } else {
                        this.f764d = jiVar.m516a();
                        break;
                    }
                case 8:
                    if (m511a.f14171a != 11) {
                        jl.a(jiVar, m511a.f14171a);
                        break;
                    } else {
                        this.f765e = jiVar.m516a();
                        break;
                    }
            }
            jiVar.g();
        }
    }

    public void a(boolean z) {
        this.f761a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m477a() {
        return this.f760a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m478a(io ioVar) {
        if (ioVar == null) {
            return false;
        }
        boolean m477a = m477a();
        boolean m477a2 = ioVar.m477a();
        if ((m477a || m477a2) && !(m477a && m477a2 && this.f760a.equals(ioVar.f760a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = ioVar.b();
        if ((b2 || b3) && !(b2 && b3 && this.f759a.m424a(ioVar.f759a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = ioVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f762b.equals(ioVar.f762b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = ioVar.d();
        if (((d2 || d3) && !(d2 && d3 && this.f763c.equals(ioVar.f763c))) || this.f758a != ioVar.f758a) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = ioVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f764d.equals(ioVar.f764d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = ioVar.g();
        return !(g2 || g3) || (g2 && g3 && this.f765e.equals(ioVar.f765e));
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        a();
        jiVar.a(f757a);
        if (this.f760a != null && m477a()) {
            jiVar.a(f14145a);
            jiVar.a(this.f760a);
            jiVar.b();
        }
        if (this.f759a != null && b()) {
            jiVar.a(f14146b);
            this.f759a.b(jiVar);
            jiVar.b();
        }
        if (this.f762b != null) {
            jiVar.a(c);
            jiVar.a(this.f762b);
            jiVar.b();
        }
        if (this.f763c != null) {
            jiVar.a(d);
            jiVar.a(this.f763c);
            jiVar.b();
        }
        jiVar.a(e);
        jiVar.a(this.f758a);
        jiVar.b();
        if (this.f764d != null && f()) {
            jiVar.a(f);
            jiVar.a(this.f764d);
            jiVar.b();
        }
        if (this.f765e != null && g()) {
            jiVar.a(g);
            jiVar.a(this.f765e);
            jiVar.b();
        }
        jiVar.c();
        jiVar.m519a();
    }

    public boolean b() {
        return this.f759a != null;
    }

    public boolean c() {
        return this.f762b != null;
    }

    public boolean d() {
        return this.f763c != null;
    }

    public boolean e() {
        return this.f761a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof io)) {
            return m478a((io) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f764d != null;
    }

    public boolean g() {
        return this.f765e != null;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionSendFeedbackResult(");
        boolean z2 = true;
        if (m477a()) {
            sb.append("debug:");
            if (this.f760a == null) {
                sb.append("null");
            } else {
                sb.append(this.f760a);
            }
            z2 = false;
        }
        if (b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f759a == null) {
                sb.append("null");
            } else {
                sb.append(this.f759a);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f762b == null) {
            sb.append("null");
        } else {
            sb.append(this.f762b);
        }
        sb.append(", ");
        sb.append("appId:");
        if (this.f763c == null) {
            sb.append("null");
        } else {
            sb.append(this.f763c);
        }
        sb.append(", ");
        sb.append("errorCode:");
        sb.append(this.f758a);
        if (f()) {
            sb.append(", ");
            sb.append("reason:");
            if (this.f764d == null) {
                sb.append("null");
            } else {
                sb.append(this.f764d);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("category:");
            if (this.f765e == null) {
                sb.append("null");
            } else {
                sb.append(this.f765e);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
