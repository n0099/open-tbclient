package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes12.dex */
public class io implements ix<io, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f677a;

    /* renamed from: a  reason: collision with other field name */
    public ib f678a;

    /* renamed from: a  reason: collision with other field name */
    public String f679a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f680a = new BitSet(1);

    /* renamed from: b  reason: collision with other field name */
    public String f681b;

    /* renamed from: c  reason: collision with other field name */
    public String f682c;

    /* renamed from: d  reason: collision with other field name */
    public String f683d;

    /* renamed from: e  reason: collision with other field name */
    public String f684e;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f676a = new jn("XmPushActionSendFeedbackResult");

    /* renamed from: a  reason: collision with root package name */
    private static final jf f4982a = new jf("", Constants.GZIP_CAST_TYPE, 1);
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
            int compareTo = Boolean.valueOf(m451a()).compareTo(Boolean.valueOf(ioVar.m451a()));
            if (compareTo == 0) {
                if (!m451a() || (a8 = iy.a(this.f679a, ioVar.f679a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(ioVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a7 = iy.a(this.f678a, ioVar.f678a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(ioVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a6 = iy.a(this.f681b, ioVar.f681b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(ioVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a5 = iy.a(this.f682c, ioVar.f682c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(ioVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a4 = iy.a(this.f677a, ioVar.f677a)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(ioVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a3 = iy.a(this.f683d, ioVar.f683d)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ioVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a2 = iy.a(this.f684e, ioVar.f684e)) == 0) {
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
        if (this.f681b == null) {
            throw new jj("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f682c == null) {
            throw new jj("Required field 'appId' was not present! Struct: " + toString());
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
                a();
                return;
            }
            switch (m485a.f776a) {
                case 1:
                    if (m485a.f4998a != 11) {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    } else {
                        this.f679a = jiVar.m490a();
                        break;
                    }
                case 2:
                    if (m485a.f4998a != 12) {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    } else {
                        this.f678a = new ib();
                        this.f678a.a(jiVar);
                        break;
                    }
                case 3:
                    if (m485a.f4998a != 11) {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    } else {
                        this.f681b = jiVar.m490a();
                        break;
                    }
                case 4:
                    if (m485a.f4998a != 11) {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    } else {
                        this.f682c = jiVar.m490a();
                        break;
                    }
                case 5:
                default:
                    jl.a(jiVar, m485a.f4998a);
                    break;
                case 6:
                    if (m485a.f4998a != 10) {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    } else {
                        this.f677a = jiVar.m484a();
                        a(true);
                        break;
                    }
                case 7:
                    if (m485a.f4998a != 11) {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    } else {
                        this.f683d = jiVar.m490a();
                        break;
                    }
                case 8:
                    if (m485a.f4998a != 11) {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    } else {
                        this.f684e = jiVar.m490a();
                        break;
                    }
            }
            jiVar.g();
        }
    }

    public void a(boolean z) {
        this.f680a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m451a() {
        return this.f679a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m452a(io ioVar) {
        if (ioVar == null) {
            return false;
        }
        boolean m451a = m451a();
        boolean m451a2 = ioVar.m451a();
        if ((m451a || m451a2) && !(m451a && m451a2 && this.f679a.equals(ioVar.f679a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = ioVar.b();
        if ((b2 || b3) && !(b2 && b3 && this.f678a.m398a(ioVar.f678a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = ioVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f681b.equals(ioVar.f681b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = ioVar.d();
        if (((d2 || d3) && !(d2 && d3 && this.f682c.equals(ioVar.f682c))) || this.f677a != ioVar.f677a) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = ioVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f683d.equals(ioVar.f683d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = ioVar.g();
        return !(g2 || g3) || (g2 && g3 && this.f684e.equals(ioVar.f684e));
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        a();
        jiVar.a(f676a);
        if (this.f679a != null && m451a()) {
            jiVar.a(f4982a);
            jiVar.a(this.f679a);
            jiVar.b();
        }
        if (this.f678a != null && b()) {
            jiVar.a(b);
            this.f678a.b(jiVar);
            jiVar.b();
        }
        if (this.f681b != null) {
            jiVar.a(c);
            jiVar.a(this.f681b);
            jiVar.b();
        }
        if (this.f682c != null) {
            jiVar.a(d);
            jiVar.a(this.f682c);
            jiVar.b();
        }
        jiVar.a(e);
        jiVar.a(this.f677a);
        jiVar.b();
        if (this.f683d != null && f()) {
            jiVar.a(f);
            jiVar.a(this.f683d);
            jiVar.b();
        }
        if (this.f684e != null && g()) {
            jiVar.a(g);
            jiVar.a(this.f684e);
            jiVar.b();
        }
        jiVar.c();
        jiVar.m493a();
    }

    public boolean b() {
        return this.f678a != null;
    }

    public boolean c() {
        return this.f681b != null;
    }

    public boolean d() {
        return this.f682c != null;
    }

    public boolean e() {
        return this.f680a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof io)) {
            return m452a((io) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f683d != null;
    }

    public boolean g() {
        return this.f684e != null;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionSendFeedbackResult(");
        boolean z2 = true;
        if (m451a()) {
            sb.append("debug:");
            if (this.f679a == null) {
                sb.append("null");
            } else {
                sb.append(this.f679a);
            }
            z2 = false;
        }
        if (b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f678a == null) {
                sb.append("null");
            } else {
                sb.append(this.f678a);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f681b == null) {
            sb.append("null");
        } else {
            sb.append(this.f681b);
        }
        sb.append(", ");
        sb.append("appId:");
        if (this.f682c == null) {
            sb.append("null");
        } else {
            sb.append(this.f682c);
        }
        sb.append(", ");
        sb.append("errorCode:");
        sb.append(this.f677a);
        if (f()) {
            sb.append(", ");
            sb.append("reason:");
            if (this.f683d == null) {
                sb.append("null");
            } else {
                sb.append(this.f683d);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("category:");
            if (this.f684e == null) {
                sb.append("null");
            } else {
                sb.append(this.f684e);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
