package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes5.dex */
public class io implements ix<io, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f679a;

    /* renamed from: a  reason: collision with other field name */
    public ib f680a;

    /* renamed from: a  reason: collision with other field name */
    public String f681a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f682a = new BitSet(1);

    /* renamed from: b  reason: collision with other field name */
    public String f683b;

    /* renamed from: c  reason: collision with other field name */
    public String f684c;

    /* renamed from: d  reason: collision with other field name */
    public String f685d;

    /* renamed from: e  reason: collision with other field name */
    public String f686e;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f678a = new jn("XmPushActionSendFeedbackResult");

    /* renamed from: a  reason: collision with root package name */
    private static final jf f8447a = new jf("", Constants.GZIP_CAST_TYPE, 1);
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
            int compareTo = Boolean.valueOf(m455a()).compareTo(Boolean.valueOf(ioVar.m455a()));
            if (compareTo == 0) {
                if (!m455a() || (a8 = iy.a(this.f681a, ioVar.f681a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(ioVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a7 = iy.a(this.f680a, ioVar.f680a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(ioVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a6 = iy.a(this.f683b, ioVar.f683b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(ioVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a5 = iy.a(this.f684c, ioVar.f684c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(ioVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a4 = iy.a(this.f679a, ioVar.f679a)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(ioVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a3 = iy.a(this.f685d, ioVar.f685d)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ioVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a2 = iy.a(this.f686e, ioVar.f686e)) == 0) {
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
        if (this.f683b == null) {
            throw new jj("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f684c == null) {
            throw new jj("Required field 'appId' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m493a();
        while (true) {
            jf m489a = jiVar.m489a();
            if (m489a.f8463a == 0) {
                jiVar.f();
                if (!e()) {
                    throw new jj("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
                }
                a();
                return;
            }
            switch (m489a.f778a) {
                case 1:
                    if (m489a.f8463a != 11) {
                        jl.a(jiVar, m489a.f8463a);
                        break;
                    } else {
                        this.f681a = jiVar.m494a();
                        break;
                    }
                case 2:
                    if (m489a.f8463a != 12) {
                        jl.a(jiVar, m489a.f8463a);
                        break;
                    } else {
                        this.f680a = new ib();
                        this.f680a.a(jiVar);
                        break;
                    }
                case 3:
                    if (m489a.f8463a != 11) {
                        jl.a(jiVar, m489a.f8463a);
                        break;
                    } else {
                        this.f683b = jiVar.m494a();
                        break;
                    }
                case 4:
                    if (m489a.f8463a != 11) {
                        jl.a(jiVar, m489a.f8463a);
                        break;
                    } else {
                        this.f684c = jiVar.m494a();
                        break;
                    }
                case 5:
                default:
                    jl.a(jiVar, m489a.f8463a);
                    break;
                case 6:
                    if (m489a.f8463a != 10) {
                        jl.a(jiVar, m489a.f8463a);
                        break;
                    } else {
                        this.f679a = jiVar.m488a();
                        a(true);
                        break;
                    }
                case 7:
                    if (m489a.f8463a != 11) {
                        jl.a(jiVar, m489a.f8463a);
                        break;
                    } else {
                        this.f685d = jiVar.m494a();
                        break;
                    }
                case 8:
                    if (m489a.f8463a != 11) {
                        jl.a(jiVar, m489a.f8463a);
                        break;
                    } else {
                        this.f686e = jiVar.m494a();
                        break;
                    }
            }
            jiVar.g();
        }
    }

    public void a(boolean z) {
        this.f682a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m455a() {
        return this.f681a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m456a(io ioVar) {
        if (ioVar == null) {
            return false;
        }
        boolean m455a = m455a();
        boolean m455a2 = ioVar.m455a();
        if ((m455a || m455a2) && !(m455a && m455a2 && this.f681a.equals(ioVar.f681a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = ioVar.b();
        if ((b2 || b3) && !(b2 && b3 && this.f680a.m402a(ioVar.f680a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = ioVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f683b.equals(ioVar.f683b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = ioVar.d();
        if (((d2 || d3) && !(d2 && d3 && this.f684c.equals(ioVar.f684c))) || this.f679a != ioVar.f679a) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = ioVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f685d.equals(ioVar.f685d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = ioVar.g();
        return !(g2 || g3) || (g2 && g3 && this.f686e.equals(ioVar.f686e));
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        a();
        jiVar.a(f678a);
        if (this.f681a != null && m455a()) {
            jiVar.a(f8447a);
            jiVar.a(this.f681a);
            jiVar.b();
        }
        if (this.f680a != null && b()) {
            jiVar.a(b);
            this.f680a.b(jiVar);
            jiVar.b();
        }
        if (this.f683b != null) {
            jiVar.a(c);
            jiVar.a(this.f683b);
            jiVar.b();
        }
        if (this.f684c != null) {
            jiVar.a(d);
            jiVar.a(this.f684c);
            jiVar.b();
        }
        jiVar.a(e);
        jiVar.a(this.f679a);
        jiVar.b();
        if (this.f685d != null && f()) {
            jiVar.a(f);
            jiVar.a(this.f685d);
            jiVar.b();
        }
        if (this.f686e != null && g()) {
            jiVar.a(g);
            jiVar.a(this.f686e);
            jiVar.b();
        }
        jiVar.c();
        jiVar.m497a();
    }

    public boolean b() {
        return this.f680a != null;
    }

    public boolean c() {
        return this.f683b != null;
    }

    public boolean d() {
        return this.f684c != null;
    }

    public boolean e() {
        return this.f682a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof io)) {
            return m456a((io) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f685d != null;
    }

    public boolean g() {
        return this.f686e != null;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionSendFeedbackResult(");
        boolean z2 = true;
        if (m455a()) {
            sb.append("debug:");
            if (this.f681a == null) {
                sb.append("null");
            } else {
                sb.append(this.f681a);
            }
            z2 = false;
        }
        if (b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f680a == null) {
                sb.append("null");
            } else {
                sb.append(this.f680a);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f683b == null) {
            sb.append("null");
        } else {
            sb.append(this.f683b);
        }
        sb.append(", ");
        sb.append("appId:");
        if (this.f684c == null) {
            sb.append("null");
        } else {
            sb.append(this.f684c);
        }
        sb.append(", ");
        sb.append("errorCode:");
        sb.append(this.f679a);
        if (f()) {
            sb.append(", ");
            sb.append("reason:");
            if (this.f685d == null) {
                sb.append("null");
            } else {
                sb.append(this.f685d);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("category:");
            if (this.f686e == null) {
                sb.append("null");
            } else {
                sb.append(this.f686e);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
