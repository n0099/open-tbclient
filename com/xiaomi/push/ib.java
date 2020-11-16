package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes18.dex */
public class ib implements ix<ib, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public String f530a;

    /* renamed from: d  reason: collision with other field name */
    public String f535d;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f528a = new jn("Target");

    /* renamed from: a  reason: collision with root package name */
    private static final jf f4971a = new jf("", (byte) 10, 1);
    private static final jf b = new jf("", Constants.GZIP_CAST_TYPE, 2);
    private static final jf c = new jf("", Constants.GZIP_CAST_TYPE, 3);
    private static final jf d = new jf("", Constants.GZIP_CAST_TYPE, 4);
    private static final jf e = new jf("", (byte) 2, 5);
    private static final jf f = new jf("", Constants.GZIP_CAST_TYPE, 7);

    /* renamed from: a  reason: collision with other field name */
    private BitSet f531a = new BitSet(2);

    /* renamed from: a  reason: collision with other field name */
    public long f529a = 5;

    /* renamed from: b  reason: collision with other field name */
    public String f533b = "xiaomi.com";

    /* renamed from: c  reason: collision with other field name */
    public String f534c = "";

    /* renamed from: a  reason: collision with other field name */
    public boolean f532a = false;

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
            int compareTo = Boolean.valueOf(m400a()).compareTo(Boolean.valueOf(ibVar.m400a()));
            if (compareTo == 0) {
                if (!m400a() || (a7 = iy.a(this.f529a, ibVar.f529a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(ibVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a6 = iy.a(this.f530a, ibVar.f530a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(ibVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a5 = iy.a(this.f533b, ibVar.f533b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(ibVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a4 = iy.a(this.f534c, ibVar.f534c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(ibVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a3 = iy.a(this.f532a, ibVar.f532a)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(ibVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a2 = iy.a(this.f535d, ibVar.f535d)) == 0) {
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
        if (this.f530a == null) {
            throw new jj("Required field 'userId' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m492a();
        while (true) {
            jf m488a = jiVar.m488a();
            if (m488a.f5000a == 0) {
                jiVar.f();
                if (!m400a()) {
                    throw new jj("Required field 'channelId' was not found in serialized data! Struct: " + toString());
                }
                a();
                return;
            }
            switch (m488a.f781a) {
                case 1:
                    if (m488a.f5000a != 10) {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    } else {
                        this.f529a = jiVar.m487a();
                        a(true);
                        break;
                    }
                case 2:
                    if (m488a.f5000a != 11) {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    } else {
                        this.f530a = jiVar.m493a();
                        break;
                    }
                case 3:
                    if (m488a.f5000a != 11) {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    } else {
                        this.f533b = jiVar.m493a();
                        break;
                    }
                case 4:
                    if (m488a.f5000a != 11) {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    } else {
                        this.f534c = jiVar.m493a();
                        break;
                    }
                case 5:
                    if (m488a.f5000a != 2) {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    } else {
                        this.f532a = jiVar.m497a();
                        b(true);
                        break;
                    }
                case 6:
                default:
                    jl.a(jiVar, m488a.f5000a);
                    break;
                case 7:
                    if (m488a.f5000a != 11) {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    } else {
                        this.f535d = jiVar.m493a();
                        break;
                    }
            }
            jiVar.g();
        }
    }

    public void a(boolean z) {
        this.f531a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m400a() {
        return this.f531a.get(0);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m401a(ib ibVar) {
        if (ibVar != null && this.f529a == ibVar.f529a) {
            boolean b2 = b();
            boolean b3 = ibVar.b();
            if ((b2 || b3) && !(b2 && b3 && this.f530a.equals(ibVar.f530a))) {
                return false;
            }
            boolean c2 = c();
            boolean c3 = ibVar.c();
            if ((c2 || c3) && !(c2 && c3 && this.f533b.equals(ibVar.f533b))) {
                return false;
            }
            boolean d2 = d();
            boolean d3 = ibVar.d();
            if ((d2 || d3) && !(d2 && d3 && this.f534c.equals(ibVar.f534c))) {
                return false;
            }
            boolean e2 = e();
            boolean e3 = ibVar.e();
            if ((e2 || e3) && !(e2 && e3 && this.f532a == ibVar.f532a)) {
                return false;
            }
            boolean f2 = f();
            boolean f3 = ibVar.f();
            return !(f2 || f3) || (f2 && f3 && this.f535d.equals(ibVar.f535d));
        }
        return false;
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        a();
        jiVar.a(f528a);
        jiVar.a(f4971a);
        jiVar.a(this.f529a);
        jiVar.b();
        if (this.f530a != null) {
            jiVar.a(b);
            jiVar.a(this.f530a);
            jiVar.b();
        }
        if (this.f533b != null && c()) {
            jiVar.a(c);
            jiVar.a(this.f533b);
            jiVar.b();
        }
        if (this.f534c != null && d()) {
            jiVar.a(d);
            jiVar.a(this.f534c);
            jiVar.b();
        }
        if (e()) {
            jiVar.a(e);
            jiVar.a(this.f532a);
            jiVar.b();
        }
        if (this.f535d != null && f()) {
            jiVar.a(f);
            jiVar.a(this.f535d);
            jiVar.b();
        }
        jiVar.c();
        jiVar.m496a();
    }

    public void b(boolean z) {
        this.f531a.set(1, z);
    }

    public boolean b() {
        return this.f530a != null;
    }

    public boolean c() {
        return this.f533b != null;
    }

    public boolean d() {
        return this.f534c != null;
    }

    public boolean e() {
        return this.f531a.get(1);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ib)) {
            return m401a((ib) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f535d != null;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Target(");
        sb.append("channelId:");
        sb.append(this.f529a);
        sb.append(", ");
        sb.append("userId:");
        if (this.f530a == null) {
            sb.append("null");
        } else {
            sb.append(this.f530a);
        }
        if (c()) {
            sb.append(", ");
            sb.append("server:");
            if (this.f533b == null) {
                sb.append("null");
            } else {
                sb.append(this.f533b);
            }
        }
        if (d()) {
            sb.append(", ");
            sb.append("resource:");
            if (this.f534c == null) {
                sb.append("null");
            } else {
                sb.append(this.f534c);
            }
        }
        if (e()) {
            sb.append(", ");
            sb.append("isPreview:");
            sb.append(this.f532a);
        }
        if (f()) {
            sb.append(", ");
            sb.append("token:");
            if (this.f535d == null) {
                sb.append("null");
            } else {
                sb.append(this.f535d);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
