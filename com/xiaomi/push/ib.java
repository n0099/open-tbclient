package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes6.dex */
public class ib implements ix<ib, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public String f606a;

    /* renamed from: d  reason: collision with other field name */
    public String f611d;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f604a = new jn("Target");

    /* renamed from: a  reason: collision with root package name */
    private static final jf f14122a = new jf("", (byte) 10, 1);

    /* renamed from: b  reason: collision with root package name */
    private static final jf f14123b = new jf("", Constants.GZIP_CAST_TYPE, 2);
    private static final jf c = new jf("", Constants.GZIP_CAST_TYPE, 3);
    private static final jf d = new jf("", Constants.GZIP_CAST_TYPE, 4);
    private static final jf e = new jf("", (byte) 2, 5);
    private static final jf f = new jf("", Constants.GZIP_CAST_TYPE, 7);

    /* renamed from: a  reason: collision with other field name */
    private BitSet f607a = new BitSet(2);

    /* renamed from: a  reason: collision with other field name */
    public long f605a = 5;

    /* renamed from: b  reason: collision with other field name */
    public String f609b = "xiaomi.com";

    /* renamed from: c  reason: collision with other field name */
    public String f610c = "";

    /* renamed from: a  reason: collision with other field name */
    public boolean f608a = false;

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
            int compareTo = Boolean.valueOf(m423a()).compareTo(Boolean.valueOf(ibVar.m423a()));
            if (compareTo == 0) {
                if (!m423a() || (a7 = iy.a(this.f605a, ibVar.f605a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(ibVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a6 = iy.a(this.f606a, ibVar.f606a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(ibVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a5 = iy.a(this.f609b, ibVar.f609b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(ibVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a4 = iy.a(this.f610c, ibVar.f610c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(ibVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a3 = iy.a(this.f608a, ibVar.f608a)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(ibVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a2 = iy.a(this.f611d, ibVar.f611d)) == 0) {
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
        if (this.f606a == null) {
            throw new jj("Required field 'userId' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m515a();
        while (true) {
            jf m511a = jiVar.m511a();
            if (m511a.f14171a == 0) {
                jiVar.f();
                if (!m423a()) {
                    throw new jj("Required field 'channelId' was not found in serialized data! Struct: " + toString());
                }
                a();
                return;
            }
            switch (m511a.f857a) {
                case 1:
                    if (m511a.f14171a != 10) {
                        jl.a(jiVar, m511a.f14171a);
                        break;
                    } else {
                        this.f605a = jiVar.m510a();
                        a(true);
                        break;
                    }
                case 2:
                    if (m511a.f14171a != 11) {
                        jl.a(jiVar, m511a.f14171a);
                        break;
                    } else {
                        this.f606a = jiVar.m516a();
                        break;
                    }
                case 3:
                    if (m511a.f14171a != 11) {
                        jl.a(jiVar, m511a.f14171a);
                        break;
                    } else {
                        this.f609b = jiVar.m516a();
                        break;
                    }
                case 4:
                    if (m511a.f14171a != 11) {
                        jl.a(jiVar, m511a.f14171a);
                        break;
                    } else {
                        this.f610c = jiVar.m516a();
                        break;
                    }
                case 5:
                    if (m511a.f14171a != 2) {
                        jl.a(jiVar, m511a.f14171a);
                        break;
                    } else {
                        this.f608a = jiVar.m520a();
                        b(true);
                        break;
                    }
                case 6:
                default:
                    jl.a(jiVar, m511a.f14171a);
                    break;
                case 7:
                    if (m511a.f14171a != 11) {
                        jl.a(jiVar, m511a.f14171a);
                        break;
                    } else {
                        this.f611d = jiVar.m516a();
                        break;
                    }
            }
            jiVar.g();
        }
    }

    public void a(boolean z) {
        this.f607a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m423a() {
        return this.f607a.get(0);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m424a(ib ibVar) {
        if (ibVar != null && this.f605a == ibVar.f605a) {
            boolean b2 = b();
            boolean b3 = ibVar.b();
            if ((b2 || b3) && !(b2 && b3 && this.f606a.equals(ibVar.f606a))) {
                return false;
            }
            boolean c2 = c();
            boolean c3 = ibVar.c();
            if ((c2 || c3) && !(c2 && c3 && this.f609b.equals(ibVar.f609b))) {
                return false;
            }
            boolean d2 = d();
            boolean d3 = ibVar.d();
            if ((d2 || d3) && !(d2 && d3 && this.f610c.equals(ibVar.f610c))) {
                return false;
            }
            boolean e2 = e();
            boolean e3 = ibVar.e();
            if ((e2 || e3) && !(e2 && e3 && this.f608a == ibVar.f608a)) {
                return false;
            }
            boolean f2 = f();
            boolean f3 = ibVar.f();
            return !(f2 || f3) || (f2 && f3 && this.f611d.equals(ibVar.f611d));
        }
        return false;
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        a();
        jiVar.a(f604a);
        jiVar.a(f14122a);
        jiVar.a(this.f605a);
        jiVar.b();
        if (this.f606a != null) {
            jiVar.a(f14123b);
            jiVar.a(this.f606a);
            jiVar.b();
        }
        if (this.f609b != null && c()) {
            jiVar.a(c);
            jiVar.a(this.f609b);
            jiVar.b();
        }
        if (this.f610c != null && d()) {
            jiVar.a(d);
            jiVar.a(this.f610c);
            jiVar.b();
        }
        if (e()) {
            jiVar.a(e);
            jiVar.a(this.f608a);
            jiVar.b();
        }
        if (this.f611d != null && f()) {
            jiVar.a(f);
            jiVar.a(this.f611d);
            jiVar.b();
        }
        jiVar.c();
        jiVar.m519a();
    }

    public void b(boolean z) {
        this.f607a.set(1, z);
    }

    public boolean b() {
        return this.f606a != null;
    }

    public boolean c() {
        return this.f609b != null;
    }

    public boolean d() {
        return this.f610c != null;
    }

    public boolean e() {
        return this.f607a.get(1);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ib)) {
            return m424a((ib) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f611d != null;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Target(");
        sb.append("channelId:");
        sb.append(this.f605a);
        sb.append(", ");
        sb.append("userId:");
        if (this.f606a == null) {
            sb.append("null");
        } else {
            sb.append(this.f606a);
        }
        if (c()) {
            sb.append(", ");
            sb.append("server:");
            if (this.f609b == null) {
                sb.append("null");
            } else {
                sb.append(this.f609b);
            }
        }
        if (d()) {
            sb.append(", ");
            sb.append("resource:");
            if (this.f610c == null) {
                sb.append("null");
            } else {
                sb.append(this.f610c);
            }
        }
        if (e()) {
            sb.append(", ");
            sb.append("isPreview:");
            sb.append(this.f608a);
        }
        if (f()) {
            sb.append(", ");
            sb.append("token:");
            if (this.f611d == null) {
                sb.append("null");
            } else {
                sb.append(this.f611d);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
