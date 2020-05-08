package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes8.dex */
public class io implements ix<io, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f678a;

    /* renamed from: a  reason: collision with other field name */
    public ib f679a;

    /* renamed from: a  reason: collision with other field name */
    public String f680a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f681a = new BitSet(1);

    /* renamed from: b  reason: collision with other field name */
    public String f682b;

    /* renamed from: c  reason: collision with other field name */
    public String f683c;

    /* renamed from: d  reason: collision with other field name */
    public String f684d;

    /* renamed from: e  reason: collision with other field name */
    public String f685e;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f677a = new jn("XmPushActionSendFeedbackResult");
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
            int compareTo = Boolean.valueOf(m447a()).compareTo(Boolean.valueOf(ioVar.m447a()));
            if (compareTo == 0) {
                if (!m447a() || (a8 = iy.a(this.f680a, ioVar.f680a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(ioVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a7 = iy.a(this.f679a, ioVar.f679a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(ioVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a6 = iy.a(this.f682b, ioVar.f682b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(ioVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a5 = iy.a(this.f683c, ioVar.f683c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(ioVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a4 = iy.a(this.f678a, ioVar.f678a)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(ioVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a3 = iy.a(this.f684d, ioVar.f684d)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ioVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a2 = iy.a(this.f685e, ioVar.f685e)) == 0) {
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
        if (this.f682b == null) {
            throw new jj("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f683c == null) {
            throw new jj("Required field 'appId' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m485a();
        while (true) {
            jf m481a = jiVar.m481a();
            if (m481a.a == 0) {
                jiVar.f();
                if (!e()) {
                    throw new jj("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
                }
                a();
                return;
            }
            switch (m481a.f777a) {
                case 1:
                    if (m481a.a != 11) {
                        jl.a(jiVar, m481a.a);
                        break;
                    } else {
                        this.f680a = jiVar.m486a();
                        break;
                    }
                case 2:
                    if (m481a.a != 12) {
                        jl.a(jiVar, m481a.a);
                        break;
                    } else {
                        this.f679a = new ib();
                        this.f679a.a(jiVar);
                        break;
                    }
                case 3:
                    if (m481a.a != 11) {
                        jl.a(jiVar, m481a.a);
                        break;
                    } else {
                        this.f682b = jiVar.m486a();
                        break;
                    }
                case 4:
                    if (m481a.a != 11) {
                        jl.a(jiVar, m481a.a);
                        break;
                    } else {
                        this.f683c = jiVar.m486a();
                        break;
                    }
                case 5:
                default:
                    jl.a(jiVar, m481a.a);
                    break;
                case 6:
                    if (m481a.a != 10) {
                        jl.a(jiVar, m481a.a);
                        break;
                    } else {
                        this.f678a = jiVar.m480a();
                        a(true);
                        break;
                    }
                case 7:
                    if (m481a.a != 11) {
                        jl.a(jiVar, m481a.a);
                        break;
                    } else {
                        this.f684d = jiVar.m486a();
                        break;
                    }
                case 8:
                    if (m481a.a != 11) {
                        jl.a(jiVar, m481a.a);
                        break;
                    } else {
                        this.f685e = jiVar.m486a();
                        break;
                    }
            }
            jiVar.g();
        }
    }

    public void a(boolean z) {
        this.f681a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m447a() {
        return this.f680a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m448a(io ioVar) {
        if (ioVar == null) {
            return false;
        }
        boolean m447a = m447a();
        boolean m447a2 = ioVar.m447a();
        if ((m447a || m447a2) && !(m447a && m447a2 && this.f680a.equals(ioVar.f680a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = ioVar.b();
        if ((b2 || b3) && !(b2 && b3 && this.f679a.m394a(ioVar.f679a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = ioVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f682b.equals(ioVar.f682b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = ioVar.d();
        if (((d2 || d3) && !(d2 && d3 && this.f683c.equals(ioVar.f683c))) || this.f678a != ioVar.f678a) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = ioVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f684d.equals(ioVar.f684d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = ioVar.g();
        return !(g2 || g3) || (g2 && g3 && this.f685e.equals(ioVar.f685e));
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        a();
        jiVar.a(f677a);
        if (this.f680a != null && m447a()) {
            jiVar.a(a);
            jiVar.a(this.f680a);
            jiVar.b();
        }
        if (this.f679a != null && b()) {
            jiVar.a(b);
            this.f679a.b(jiVar);
            jiVar.b();
        }
        if (this.f682b != null) {
            jiVar.a(c);
            jiVar.a(this.f682b);
            jiVar.b();
        }
        if (this.f683c != null) {
            jiVar.a(d);
            jiVar.a(this.f683c);
            jiVar.b();
        }
        jiVar.a(e);
        jiVar.a(this.f678a);
        jiVar.b();
        if (this.f684d != null && f()) {
            jiVar.a(f);
            jiVar.a(this.f684d);
            jiVar.b();
        }
        if (this.f685e != null && g()) {
            jiVar.a(g);
            jiVar.a(this.f685e);
            jiVar.b();
        }
        jiVar.c();
        jiVar.m489a();
    }

    public boolean b() {
        return this.f679a != null;
    }

    public boolean c() {
        return this.f682b != null;
    }

    public boolean d() {
        return this.f683c != null;
    }

    public boolean e() {
        return this.f681a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof io)) {
            return m448a((io) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f684d != null;
    }

    public boolean g() {
        return this.f685e != null;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionSendFeedbackResult(");
        boolean z2 = true;
        if (m447a()) {
            sb.append("debug:");
            if (this.f680a == null) {
                sb.append("null");
            } else {
                sb.append(this.f680a);
            }
            z2 = false;
        }
        if (b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f679a == null) {
                sb.append("null");
            } else {
                sb.append(this.f679a);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f682b == null) {
            sb.append("null");
        } else {
            sb.append(this.f682b);
        }
        sb.append(", ");
        sb.append("appId:");
        if (this.f683c == null) {
            sb.append("null");
        } else {
            sb.append(this.f683c);
        }
        sb.append(", ");
        sb.append("errorCode:");
        sb.append(this.f678a);
        if (f()) {
            sb.append(", ");
            sb.append("reason:");
            if (this.f684d == null) {
                sb.append("null");
            } else {
                sb.append(this.f684d);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("category:");
            if (this.f685e == null) {
                sb.append("null");
            } else {
                sb.append(this.f685e);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
