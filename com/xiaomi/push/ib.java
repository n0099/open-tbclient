package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes8.dex */
public class ib implements ix<ib, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public String f533a;

    /* renamed from: d  reason: collision with other field name */
    public String f538d;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f531a = new jn("Target");
    private static final jf a = new jf("", (byte) 10, 1);
    private static final jf b = new jf("", Constants.GZIP_CAST_TYPE, 2);
    private static final jf c = new jf("", Constants.GZIP_CAST_TYPE, 3);
    private static final jf d = new jf("", Constants.GZIP_CAST_TYPE, 4);
    private static final jf e = new jf("", (byte) 2, 5);
    private static final jf f = new jf("", Constants.GZIP_CAST_TYPE, 7);

    /* renamed from: a  reason: collision with other field name */
    private BitSet f534a = new BitSet(2);

    /* renamed from: a  reason: collision with other field name */
    public long f532a = 5;

    /* renamed from: b  reason: collision with other field name */
    public String f536b = "xiaomi.com";

    /* renamed from: c  reason: collision with other field name */
    public String f537c = "";

    /* renamed from: a  reason: collision with other field name */
    public boolean f535a = false;

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
            int compareTo = Boolean.valueOf(m391a()).compareTo(Boolean.valueOf(ibVar.m391a()));
            if (compareTo == 0) {
                if (!m391a() || (a7 = iy.a(this.f532a, ibVar.f532a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(ibVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a6 = iy.a(this.f533a, ibVar.f533a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(ibVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a5 = iy.a(this.f536b, ibVar.f536b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(ibVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a4 = iy.a(this.f537c, ibVar.f537c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(ibVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a3 = iy.a(this.f535a, ibVar.f535a)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(ibVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a2 = iy.a(this.f538d, ibVar.f538d)) == 0) {
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
        if (this.f533a == null) {
            throw new jj("Required field 'userId' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m483a();
        while (true) {
            jf m479a = jiVar.m479a();
            if (m479a.a == 0) {
                jiVar.f();
                if (!m391a()) {
                    throw new jj("Required field 'channelId' was not found in serialized data! Struct: " + toString());
                }
                a();
                return;
            }
            switch (m479a.f784a) {
                case 1:
                    if (m479a.a != 10) {
                        jl.a(jiVar, m479a.a);
                        break;
                    } else {
                        this.f532a = jiVar.m478a();
                        a(true);
                        break;
                    }
                case 2:
                    if (m479a.a != 11) {
                        jl.a(jiVar, m479a.a);
                        break;
                    } else {
                        this.f533a = jiVar.m484a();
                        break;
                    }
                case 3:
                    if (m479a.a != 11) {
                        jl.a(jiVar, m479a.a);
                        break;
                    } else {
                        this.f536b = jiVar.m484a();
                        break;
                    }
                case 4:
                    if (m479a.a != 11) {
                        jl.a(jiVar, m479a.a);
                        break;
                    } else {
                        this.f537c = jiVar.m484a();
                        break;
                    }
                case 5:
                    if (m479a.a != 2) {
                        jl.a(jiVar, m479a.a);
                        break;
                    } else {
                        this.f535a = jiVar.m488a();
                        b(true);
                        break;
                    }
                case 6:
                default:
                    jl.a(jiVar, m479a.a);
                    break;
                case 7:
                    if (m479a.a != 11) {
                        jl.a(jiVar, m479a.a);
                        break;
                    } else {
                        this.f538d = jiVar.m484a();
                        break;
                    }
            }
            jiVar.g();
        }
    }

    public void a(boolean z) {
        this.f534a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m391a() {
        return this.f534a.get(0);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m392a(ib ibVar) {
        if (ibVar != null && this.f532a == ibVar.f532a) {
            boolean b2 = b();
            boolean b3 = ibVar.b();
            if ((b2 || b3) && !(b2 && b3 && this.f533a.equals(ibVar.f533a))) {
                return false;
            }
            boolean c2 = c();
            boolean c3 = ibVar.c();
            if ((c2 || c3) && !(c2 && c3 && this.f536b.equals(ibVar.f536b))) {
                return false;
            }
            boolean d2 = d();
            boolean d3 = ibVar.d();
            if ((d2 || d3) && !(d2 && d3 && this.f537c.equals(ibVar.f537c))) {
                return false;
            }
            boolean e2 = e();
            boolean e3 = ibVar.e();
            if ((e2 || e3) && !(e2 && e3 && this.f535a == ibVar.f535a)) {
                return false;
            }
            boolean f2 = f();
            boolean f3 = ibVar.f();
            return !(f2 || f3) || (f2 && f3 && this.f538d.equals(ibVar.f538d));
        }
        return false;
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        a();
        jiVar.a(f531a);
        jiVar.a(a);
        jiVar.a(this.f532a);
        jiVar.b();
        if (this.f533a != null) {
            jiVar.a(b);
            jiVar.a(this.f533a);
            jiVar.b();
        }
        if (this.f536b != null && c()) {
            jiVar.a(c);
            jiVar.a(this.f536b);
            jiVar.b();
        }
        if (this.f537c != null && d()) {
            jiVar.a(d);
            jiVar.a(this.f537c);
            jiVar.b();
        }
        if (e()) {
            jiVar.a(e);
            jiVar.a(this.f535a);
            jiVar.b();
        }
        if (this.f538d != null && f()) {
            jiVar.a(f);
            jiVar.a(this.f538d);
            jiVar.b();
        }
        jiVar.c();
        jiVar.m487a();
    }

    public void b(boolean z) {
        this.f534a.set(1, z);
    }

    public boolean b() {
        return this.f533a != null;
    }

    public boolean c() {
        return this.f536b != null;
    }

    public boolean d() {
        return this.f537c != null;
    }

    public boolean e() {
        return this.f534a.get(1);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ib)) {
            return m392a((ib) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f538d != null;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Target(");
        sb.append("channelId:");
        sb.append(this.f532a);
        sb.append(", ");
        sb.append("userId:");
        if (this.f533a == null) {
            sb.append("null");
        } else {
            sb.append(this.f533a);
        }
        if (c()) {
            sb.append(", ");
            sb.append("server:");
            if (this.f536b == null) {
                sb.append("null");
            } else {
                sb.append(this.f536b);
            }
        }
        if (d()) {
            sb.append(", ");
            sb.append("resource:");
            if (this.f537c == null) {
                sb.append("null");
            } else {
                sb.append(this.f537c);
            }
        }
        if (e()) {
            sb.append(", ");
            sb.append("isPreview:");
            sb.append(this.f535a);
        }
        if (f()) {
            sb.append(", ");
            sb.append("token:");
            if (this.f538d == null) {
                sb.append("null");
            } else {
                sb.append(this.f538d);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
