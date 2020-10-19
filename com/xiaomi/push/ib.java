package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes12.dex */
public class ib implements ix<ib, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public String f528a;

    /* renamed from: d  reason: collision with other field name */
    public String f533d;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f526a = new jn("Target");

    /* renamed from: a  reason: collision with root package name */
    private static final jf f4971a = new jf("", (byte) 10, 1);
    private static final jf b = new jf("", Constants.GZIP_CAST_TYPE, 2);
    private static final jf c = new jf("", Constants.GZIP_CAST_TYPE, 3);
    private static final jf d = new jf("", Constants.GZIP_CAST_TYPE, 4);
    private static final jf e = new jf("", (byte) 2, 5);
    private static final jf f = new jf("", Constants.GZIP_CAST_TYPE, 7);

    /* renamed from: a  reason: collision with other field name */
    private BitSet f529a = new BitSet(2);

    /* renamed from: a  reason: collision with other field name */
    public long f527a = 5;

    /* renamed from: b  reason: collision with other field name */
    public String f531b = "xiaomi.com";

    /* renamed from: c  reason: collision with other field name */
    public String f532c = "";

    /* renamed from: a  reason: collision with other field name */
    public boolean f530a = false;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(ib ibVar) {
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        if (getClass().equals(ibVar.getClass())) {
            int compareTo = Boolean.valueOf(m398a()).compareTo(Boolean.valueOf(ibVar.m398a()));
            if (compareTo == 0) {
                if (!m398a() || (a7 = iy.a(this.f527a, ibVar.f527a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(ibVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a6 = iy.a(this.f528a, ibVar.f528a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(ibVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a5 = iy.a(this.f531b, ibVar.f531b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(ibVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a4 = iy.a(this.f532c, ibVar.f532c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(ibVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a3 = iy.a(this.f530a, ibVar.f530a)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(ibVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a2 = iy.a(this.f533d, ibVar.f533d)) == 0) {
                                                            return 0;
                                                        }
                                                        return a2;
                                                    }
                                                    return compareTo6;
                                                }
                                                return a3;
                                            }
                                            return compareTo5;
                                        }
                                        return a4;
                                    }
                                    return compareTo4;
                                }
                                return a5;
                            }
                            return compareTo3;
                        }
                        return a6;
                    }
                    return compareTo2;
                }
                return a7;
            }
            return compareTo;
        }
        return getClass().getName().compareTo(ibVar.getClass().getName());
    }

    public void a() {
        if (this.f528a == null) {
            throw new jj("Required field 'userId' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m490a();
        while (true) {
            jf m486a = jiVar.m486a();
            if (m486a.f5000a == 0) {
                jiVar.f();
                if (!m398a()) {
                    throw new jj("Required field 'channelId' was not found in serialized data! Struct: " + toString());
                }
                a();
                return;
            }
            switch (m486a.f779a) {
                case 1:
                    if (m486a.f5000a != 10) {
                        jl.a(jiVar, m486a.f5000a);
                        break;
                    } else {
                        this.f527a = jiVar.m485a();
                        a(true);
                        break;
                    }
                case 2:
                    if (m486a.f5000a != 11) {
                        jl.a(jiVar, m486a.f5000a);
                        break;
                    } else {
                        this.f528a = jiVar.m491a();
                        break;
                    }
                case 3:
                    if (m486a.f5000a != 11) {
                        jl.a(jiVar, m486a.f5000a);
                        break;
                    } else {
                        this.f531b = jiVar.m491a();
                        break;
                    }
                case 4:
                    if (m486a.f5000a != 11) {
                        jl.a(jiVar, m486a.f5000a);
                        break;
                    } else {
                        this.f532c = jiVar.m491a();
                        break;
                    }
                case 5:
                    if (m486a.f5000a != 2) {
                        jl.a(jiVar, m486a.f5000a);
                        break;
                    } else {
                        this.f530a = jiVar.m495a();
                        b(true);
                        break;
                    }
                case 6:
                default:
                    jl.a(jiVar, m486a.f5000a);
                    break;
                case 7:
                    if (m486a.f5000a != 11) {
                        jl.a(jiVar, m486a.f5000a);
                        break;
                    } else {
                        this.f533d = jiVar.m491a();
                        break;
                    }
            }
            jiVar.g();
        }
    }

    public void a(boolean z) {
        this.f529a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m398a() {
        return this.f529a.get(0);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m399a(ib ibVar) {
        if (ibVar != null && this.f527a == ibVar.f527a) {
            boolean b2 = b();
            boolean b3 = ibVar.b();
            if ((b2 || b3) && !(b2 && b3 && this.f528a.equals(ibVar.f528a))) {
                return false;
            }
            boolean c2 = c();
            boolean c3 = ibVar.c();
            if ((c2 || c3) && !(c2 && c3 && this.f531b.equals(ibVar.f531b))) {
                return false;
            }
            boolean d2 = d();
            boolean d3 = ibVar.d();
            if ((d2 || d3) && !(d2 && d3 && this.f532c.equals(ibVar.f532c))) {
                return false;
            }
            boolean e2 = e();
            boolean e3 = ibVar.e();
            if ((e2 || e3) && !(e2 && e3 && this.f530a == ibVar.f530a)) {
                return false;
            }
            boolean f2 = f();
            boolean f3 = ibVar.f();
            return !(f2 || f3) || (f2 && f3 && this.f533d.equals(ibVar.f533d));
        }
        return false;
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        a();
        jiVar.a(f526a);
        jiVar.a(f4971a);
        jiVar.a(this.f527a);
        jiVar.b();
        if (this.f528a != null) {
            jiVar.a(b);
            jiVar.a(this.f528a);
            jiVar.b();
        }
        if (this.f531b != null && c()) {
            jiVar.a(c);
            jiVar.a(this.f531b);
            jiVar.b();
        }
        if (this.f532c != null && d()) {
            jiVar.a(d);
            jiVar.a(this.f532c);
            jiVar.b();
        }
        if (e()) {
            jiVar.a(e);
            jiVar.a(this.f530a);
            jiVar.b();
        }
        if (this.f533d != null && f()) {
            jiVar.a(f);
            jiVar.a(this.f533d);
            jiVar.b();
        }
        jiVar.c();
        jiVar.m494a();
    }

    public void b(boolean z) {
        this.f529a.set(1, z);
    }

    public boolean b() {
        return this.f528a != null;
    }

    public boolean c() {
        return this.f531b != null;
    }

    public boolean d() {
        return this.f532c != null;
    }

    public boolean e() {
        return this.f529a.get(1);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ib)) {
            return m399a((ib) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f533d != null;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Target(");
        sb.append("channelId:");
        sb.append(this.f527a);
        sb.append(", ");
        sb.append("userId:");
        if (this.f528a == null) {
            sb.append("null");
        } else {
            sb.append(this.f528a);
        }
        if (c()) {
            sb.append(", ");
            sb.append("server:");
            if (this.f531b == null) {
                sb.append("null");
            } else {
                sb.append(this.f531b);
            }
        }
        if (d()) {
            sb.append(", ");
            sb.append("resource:");
            if (this.f532c == null) {
                sb.append("null");
            } else {
                sb.append(this.f532c);
            }
        }
        if (e()) {
            sb.append(", ");
            sb.append("isPreview:");
            sb.append(this.f530a);
        }
        if (f()) {
            sb.append(", ");
            sb.append("token:");
            if (this.f533d == null) {
                sb.append("null");
            } else {
                sb.append(this.f533d);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
