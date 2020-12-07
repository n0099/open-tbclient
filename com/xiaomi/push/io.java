package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes18.dex */
public class io implements ix<io, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f680a;

    /* renamed from: a  reason: collision with other field name */
    public ib f681a;

    /* renamed from: a  reason: collision with other field name */
    public String f682a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f683a = new BitSet(1);

    /* renamed from: b  reason: collision with other field name */
    public String f684b;

    /* renamed from: c  reason: collision with other field name */
    public String f685c;

    /* renamed from: d  reason: collision with other field name */
    public String f686d;

    /* renamed from: e  reason: collision with other field name */
    public String f687e;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f679a = new jn("XmPushActionSendFeedbackResult");

    /* renamed from: a  reason: collision with root package name */
    private static final jf f4754a = new jf("", Constants.GZIP_CAST_TYPE, 1);
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
            int compareTo = Boolean.valueOf(m444a()).compareTo(Boolean.valueOf(ioVar.m444a()));
            if (compareTo == 0) {
                if (!m444a() || (a8 = iy.a(this.f682a, ioVar.f682a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(ioVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a7 = iy.a(this.f681a, ioVar.f681a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(ioVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a6 = iy.a(this.f684b, ioVar.f684b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(ioVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a5 = iy.a(this.f685c, ioVar.f685c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(ioVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a4 = iy.a(this.f680a, ioVar.f680a)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(ioVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a3 = iy.a(this.f686d, ioVar.f686d)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ioVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a2 = iy.a(this.f687e, ioVar.f687e)) == 0) {
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
        if (this.f684b == null) {
            throw new jj("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f685c == null) {
            throw new jj("Required field 'appId' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m482a();
        while (true) {
            jf m478a = jiVar.m478a();
            if (m478a.f4770a == 0) {
                jiVar.f();
                if (!e()) {
                    throw new jj("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
                }
                a();
                return;
            }
            switch (m478a.f779a) {
                case 1:
                    if (m478a.f4770a != 11) {
                        jl.a(jiVar, m478a.f4770a);
                        break;
                    } else {
                        this.f682a = jiVar.m483a();
                        break;
                    }
                case 2:
                    if (m478a.f4770a != 12) {
                        jl.a(jiVar, m478a.f4770a);
                        break;
                    } else {
                        this.f681a = new ib();
                        this.f681a.a(jiVar);
                        break;
                    }
                case 3:
                    if (m478a.f4770a != 11) {
                        jl.a(jiVar, m478a.f4770a);
                        break;
                    } else {
                        this.f684b = jiVar.m483a();
                        break;
                    }
                case 4:
                    if (m478a.f4770a != 11) {
                        jl.a(jiVar, m478a.f4770a);
                        break;
                    } else {
                        this.f685c = jiVar.m483a();
                        break;
                    }
                case 5:
                default:
                    jl.a(jiVar, m478a.f4770a);
                    break;
                case 6:
                    if (m478a.f4770a != 10) {
                        jl.a(jiVar, m478a.f4770a);
                        break;
                    } else {
                        this.f680a = jiVar.m477a();
                        a(true);
                        break;
                    }
                case 7:
                    if (m478a.f4770a != 11) {
                        jl.a(jiVar, m478a.f4770a);
                        break;
                    } else {
                        this.f686d = jiVar.m483a();
                        break;
                    }
                case 8:
                    if (m478a.f4770a != 11) {
                        jl.a(jiVar, m478a.f4770a);
                        break;
                    } else {
                        this.f687e = jiVar.m483a();
                        break;
                    }
            }
            jiVar.g();
        }
    }

    public void a(boolean z) {
        this.f683a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m444a() {
        return this.f682a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m445a(io ioVar) {
        if (ioVar == null) {
            return false;
        }
        boolean m444a = m444a();
        boolean m444a2 = ioVar.m444a();
        if ((m444a || m444a2) && !(m444a && m444a2 && this.f682a.equals(ioVar.f682a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = ioVar.b();
        if ((b2 || b3) && !(b2 && b3 && this.f681a.m391a(ioVar.f681a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = ioVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f684b.equals(ioVar.f684b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = ioVar.d();
        if (((d2 || d3) && !(d2 && d3 && this.f685c.equals(ioVar.f685c))) || this.f680a != ioVar.f680a) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = ioVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f686d.equals(ioVar.f686d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = ioVar.g();
        return !(g2 || g3) || (g2 && g3 && this.f687e.equals(ioVar.f687e));
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        a();
        jiVar.a(f679a);
        if (this.f682a != null && m444a()) {
            jiVar.a(f4754a);
            jiVar.a(this.f682a);
            jiVar.b();
        }
        if (this.f681a != null && b()) {
            jiVar.a(b);
            this.f681a.b(jiVar);
            jiVar.b();
        }
        if (this.f684b != null) {
            jiVar.a(c);
            jiVar.a(this.f684b);
            jiVar.b();
        }
        if (this.f685c != null) {
            jiVar.a(d);
            jiVar.a(this.f685c);
            jiVar.b();
        }
        jiVar.a(e);
        jiVar.a(this.f680a);
        jiVar.b();
        if (this.f686d != null && f()) {
            jiVar.a(f);
            jiVar.a(this.f686d);
            jiVar.b();
        }
        if (this.f687e != null && g()) {
            jiVar.a(g);
            jiVar.a(this.f687e);
            jiVar.b();
        }
        jiVar.c();
        jiVar.m486a();
    }

    public boolean b() {
        return this.f681a != null;
    }

    public boolean c() {
        return this.f684b != null;
    }

    public boolean d() {
        return this.f685c != null;
    }

    public boolean e() {
        return this.f683a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof io)) {
            return m445a((io) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f686d != null;
    }

    public boolean g() {
        return this.f687e != null;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionSendFeedbackResult(");
        boolean z2 = true;
        if (m444a()) {
            sb.append("debug:");
            if (this.f682a == null) {
                sb.append("null");
            } else {
                sb.append(this.f682a);
            }
            z2 = false;
        }
        if (b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f681a == null) {
                sb.append("null");
            } else {
                sb.append(this.f681a);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f684b == null) {
            sb.append("null");
        } else {
            sb.append(this.f684b);
        }
        sb.append(", ");
        sb.append("appId:");
        if (this.f685c == null) {
            sb.append("null");
        } else {
            sb.append(this.f685c);
        }
        sb.append(", ");
        sb.append("errorCode:");
        sb.append(this.f680a);
        if (f()) {
            sb.append(", ");
            sb.append("reason:");
            if (this.f686d == null) {
                sb.append("null");
            } else {
                sb.append(this.f686d);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("category:");
            if (this.f687e == null) {
                sb.append("null");
            } else {
                sb.append(this.f687e);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
