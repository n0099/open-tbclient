package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes8.dex */
public class io implements ix<io, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f684a;

    /* renamed from: a  reason: collision with other field name */
    public ib f685a;

    /* renamed from: a  reason: collision with other field name */
    public String f686a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f687a = new BitSet(1);

    /* renamed from: b  reason: collision with other field name */
    public String f688b;

    /* renamed from: c  reason: collision with other field name */
    public String f689c;

    /* renamed from: d  reason: collision with other field name */
    public String f690d;

    /* renamed from: e  reason: collision with other field name */
    public String f691e;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f683a = new jn("XmPushActionSendFeedbackResult");
    private static final jf a = new jf("", Constants.GZIP_CAST_TYPE, 1);
    private static final jf b = new jf("", (byte) 12, 2);
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
            int compareTo = Boolean.valueOf(m445a()).compareTo(Boolean.valueOf(ioVar.m445a()));
            if (compareTo == 0) {
                if (!m445a() || (a8 = iy.a(this.f686a, ioVar.f686a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(ioVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a7 = iy.a(this.f685a, ioVar.f685a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(ioVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a6 = iy.a(this.f688b, ioVar.f688b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(ioVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a5 = iy.a(this.f689c, ioVar.f689c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(ioVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a4 = iy.a(this.f684a, ioVar.f684a)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(ioVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a3 = iy.a(this.f690d, ioVar.f690d)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ioVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a2 = iy.a(this.f691e, ioVar.f691e)) == 0) {
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
        if (this.f688b == null) {
            throw new jj("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f689c == null) {
            throw new jj("Required field 'appId' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m483a();
        while (true) {
            jf m479a = jiVar.m479a();
            if (m479a.a == 0) {
                jiVar.f();
                if (!e()) {
                    throw new jj("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
                }
                a();
                return;
            }
            switch (m479a.f783a) {
                case 1:
                    if (m479a.a != 11) {
                        jl.a(jiVar, m479a.a);
                        break;
                    } else {
                        this.f686a = jiVar.m484a();
                        break;
                    }
                case 2:
                    if (m479a.a != 12) {
                        jl.a(jiVar, m479a.a);
                        break;
                    } else {
                        this.f685a = new ib();
                        this.f685a.a(jiVar);
                        break;
                    }
                case 3:
                    if (m479a.a != 11) {
                        jl.a(jiVar, m479a.a);
                        break;
                    } else {
                        this.f688b = jiVar.m484a();
                        break;
                    }
                case 4:
                    if (m479a.a != 11) {
                        jl.a(jiVar, m479a.a);
                        break;
                    } else {
                        this.f689c = jiVar.m484a();
                        break;
                    }
                case 5:
                default:
                    jl.a(jiVar, m479a.a);
                    break;
                case 6:
                    if (m479a.a != 10) {
                        jl.a(jiVar, m479a.a);
                        break;
                    } else {
                        this.f684a = jiVar.m478a();
                        a(true);
                        break;
                    }
                case 7:
                    if (m479a.a != 11) {
                        jl.a(jiVar, m479a.a);
                        break;
                    } else {
                        this.f690d = jiVar.m484a();
                        break;
                    }
                case 8:
                    if (m479a.a != 11) {
                        jl.a(jiVar, m479a.a);
                        break;
                    } else {
                        this.f691e = jiVar.m484a();
                        break;
                    }
            }
            jiVar.g();
        }
    }

    public void a(boolean z) {
        this.f687a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m445a() {
        return this.f686a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m446a(io ioVar) {
        if (ioVar == null) {
            return false;
        }
        boolean m445a = m445a();
        boolean m445a2 = ioVar.m445a();
        if ((m445a || m445a2) && !(m445a && m445a2 && this.f686a.equals(ioVar.f686a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = ioVar.b();
        if ((b2 || b3) && !(b2 && b3 && this.f685a.m392a(ioVar.f685a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = ioVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f688b.equals(ioVar.f688b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = ioVar.d();
        if (((d2 || d3) && !(d2 && d3 && this.f689c.equals(ioVar.f689c))) || this.f684a != ioVar.f684a) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = ioVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f690d.equals(ioVar.f690d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = ioVar.g();
        return !(g2 || g3) || (g2 && g3 && this.f691e.equals(ioVar.f691e));
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        a();
        jiVar.a(f683a);
        if (this.f686a != null && m445a()) {
            jiVar.a(a);
            jiVar.a(this.f686a);
            jiVar.b();
        }
        if (this.f685a != null && b()) {
            jiVar.a(b);
            this.f685a.b(jiVar);
            jiVar.b();
        }
        if (this.f688b != null) {
            jiVar.a(c);
            jiVar.a(this.f688b);
            jiVar.b();
        }
        if (this.f689c != null) {
            jiVar.a(d);
            jiVar.a(this.f689c);
            jiVar.b();
        }
        jiVar.a(e);
        jiVar.a(this.f684a);
        jiVar.b();
        if (this.f690d != null && f()) {
            jiVar.a(f);
            jiVar.a(this.f690d);
            jiVar.b();
        }
        if (this.f691e != null && g()) {
            jiVar.a(g);
            jiVar.a(this.f691e);
            jiVar.b();
        }
        jiVar.c();
        jiVar.m487a();
    }

    public boolean b() {
        return this.f685a != null;
    }

    public boolean c() {
        return this.f688b != null;
    }

    public boolean d() {
        return this.f689c != null;
    }

    public boolean e() {
        return this.f687a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof io)) {
            return m446a((io) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f690d != null;
    }

    public boolean g() {
        return this.f691e != null;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionSendFeedbackResult(");
        boolean z2 = true;
        if (m445a()) {
            sb.append("debug:");
            if (this.f686a == null) {
                sb.append("null");
            } else {
                sb.append(this.f686a);
            }
            z2 = false;
        }
        if (b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f685a == null) {
                sb.append("null");
            } else {
                sb.append(this.f685a);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f688b == null) {
            sb.append("null");
        } else {
            sb.append(this.f688b);
        }
        sb.append(", ");
        sb.append("appId:");
        if (this.f689c == null) {
            sb.append("null");
        } else {
            sb.append(this.f689c);
        }
        sb.append(", ");
        sb.append("errorCode:");
        sb.append(this.f684a);
        if (f()) {
            sb.append(", ");
            sb.append("reason:");
            if (this.f690d == null) {
                sb.append("null");
            } else {
                sb.append(this.f690d);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("category:");
            if (this.f691e == null) {
                sb.append("null");
            } else {
                sb.append(this.f691e);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
