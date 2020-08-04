package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes9.dex */
public class ib implements ix<ib, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public String f532a;

    /* renamed from: d  reason: collision with other field name */
    public String f537d;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f530a = new jn("Target");
    private static final jf a = new jf("", (byte) 10, 1);
    private static final jf b = new jf("", Constants.GZIP_CAST_TYPE, 2);
    private static final jf c = new jf("", Constants.GZIP_CAST_TYPE, 3);
    private static final jf d = new jf("", Constants.GZIP_CAST_TYPE, 4);
    private static final jf e = new jf("", (byte) 2, 5);
    private static final jf f = new jf("", Constants.GZIP_CAST_TYPE, 7);

    /* renamed from: a  reason: collision with other field name */
    private BitSet f533a = new BitSet(2);

    /* renamed from: a  reason: collision with other field name */
    public long f531a = 5;

    /* renamed from: b  reason: collision with other field name */
    public String f535b = "xiaomi.com";

    /* renamed from: c  reason: collision with other field name */
    public String f536c = "";

    /* renamed from: a  reason: collision with other field name */
    public boolean f534a = false;

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
            int compareTo = Boolean.valueOf(m392a()).compareTo(Boolean.valueOf(ibVar.m392a()));
            if (compareTo == 0) {
                if (!m392a() || (a7 = iy.a(this.f531a, ibVar.f531a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(ibVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a6 = iy.a(this.f532a, ibVar.f532a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(ibVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a5 = iy.a(this.f535b, ibVar.f535b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(ibVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a4 = iy.a(this.f536c, ibVar.f536c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(ibVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a3 = iy.a(this.f534a, ibVar.f534a)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(ibVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a2 = iy.a(this.f537d, ibVar.f537d)) == 0) {
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
        if (this.f532a == null) {
            throw new jj("Required field 'userId' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m484a();
        while (true) {
            jf m480a = jiVar.m480a();
            if (m480a.a == 0) {
                jiVar.f();
                if (!m392a()) {
                    throw new jj("Required field 'channelId' was not found in serialized data! Struct: " + toString());
                }
                a();
                return;
            }
            switch (m480a.f783a) {
                case 1:
                    if (m480a.a != 10) {
                        jl.a(jiVar, m480a.a);
                        break;
                    } else {
                        this.f531a = jiVar.m479a();
                        a(true);
                        break;
                    }
                case 2:
                    if (m480a.a != 11) {
                        jl.a(jiVar, m480a.a);
                        break;
                    } else {
                        this.f532a = jiVar.m485a();
                        break;
                    }
                case 3:
                    if (m480a.a != 11) {
                        jl.a(jiVar, m480a.a);
                        break;
                    } else {
                        this.f535b = jiVar.m485a();
                        break;
                    }
                case 4:
                    if (m480a.a != 11) {
                        jl.a(jiVar, m480a.a);
                        break;
                    } else {
                        this.f536c = jiVar.m485a();
                        break;
                    }
                case 5:
                    if (m480a.a != 2) {
                        jl.a(jiVar, m480a.a);
                        break;
                    } else {
                        this.f534a = jiVar.m489a();
                        b(true);
                        break;
                    }
                case 6:
                default:
                    jl.a(jiVar, m480a.a);
                    break;
                case 7:
                    if (m480a.a != 11) {
                        jl.a(jiVar, m480a.a);
                        break;
                    } else {
                        this.f537d = jiVar.m485a();
                        break;
                    }
            }
            jiVar.g();
        }
    }

    public void a(boolean z) {
        this.f533a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m392a() {
        return this.f533a.get(0);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m393a(ib ibVar) {
        if (ibVar != null && this.f531a == ibVar.f531a) {
            boolean b2 = b();
            boolean b3 = ibVar.b();
            if ((b2 || b3) && !(b2 && b3 && this.f532a.equals(ibVar.f532a))) {
                return false;
            }
            boolean c2 = c();
            boolean c3 = ibVar.c();
            if ((c2 || c3) && !(c2 && c3 && this.f535b.equals(ibVar.f535b))) {
                return false;
            }
            boolean d2 = d();
            boolean d3 = ibVar.d();
            if ((d2 || d3) && !(d2 && d3 && this.f536c.equals(ibVar.f536c))) {
                return false;
            }
            boolean e2 = e();
            boolean e3 = ibVar.e();
            if ((e2 || e3) && !(e2 && e3 && this.f534a == ibVar.f534a)) {
                return false;
            }
            boolean f2 = f();
            boolean f3 = ibVar.f();
            return !(f2 || f3) || (f2 && f3 && this.f537d.equals(ibVar.f537d));
        }
        return false;
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        a();
        jiVar.a(f530a);
        jiVar.a(a);
        jiVar.a(this.f531a);
        jiVar.b();
        if (this.f532a != null) {
            jiVar.a(b);
            jiVar.a(this.f532a);
            jiVar.b();
        }
        if (this.f535b != null && c()) {
            jiVar.a(c);
            jiVar.a(this.f535b);
            jiVar.b();
        }
        if (this.f536c != null && d()) {
            jiVar.a(d);
            jiVar.a(this.f536c);
            jiVar.b();
        }
        if (e()) {
            jiVar.a(e);
            jiVar.a(this.f534a);
            jiVar.b();
        }
        if (this.f537d != null && f()) {
            jiVar.a(f);
            jiVar.a(this.f537d);
            jiVar.b();
        }
        jiVar.c();
        jiVar.m488a();
    }

    public void b(boolean z) {
        this.f533a.set(1, z);
    }

    public boolean b() {
        return this.f532a != null;
    }

    public boolean c() {
        return this.f535b != null;
    }

    public boolean d() {
        return this.f536c != null;
    }

    public boolean e() {
        return this.f533a.get(1);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ib)) {
            return m393a((ib) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f537d != null;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Target(");
        sb.append("channelId:");
        sb.append(this.f531a);
        sb.append(", ");
        sb.append("userId:");
        if (this.f532a == null) {
            sb.append("null");
        } else {
            sb.append(this.f532a);
        }
        if (c()) {
            sb.append(", ");
            sb.append("server:");
            if (this.f535b == null) {
                sb.append("null");
            } else {
                sb.append(this.f535b);
            }
        }
        if (d()) {
            sb.append(", ");
            sb.append("resource:");
            if (this.f536c == null) {
                sb.append("null");
            } else {
                sb.append(this.f536c);
            }
        }
        if (e()) {
            sb.append(", ");
            sb.append("isPreview:");
            sb.append(this.f534a);
        }
        if (f()) {
            sb.append(", ");
            sb.append("token:");
            if (this.f537d == null) {
                sb.append("null");
            } else {
                sb.append(this.f537d);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
