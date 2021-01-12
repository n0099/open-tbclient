package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.BitSet;
/* loaded from: classes6.dex */
public class ii implements ix<ii, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public hm f677a;

    /* renamed from: a  reason: collision with other field name */
    public hz f678a;

    /* renamed from: a  reason: collision with other field name */
    public ib f679a;

    /* renamed from: a  reason: collision with other field name */
    public String f680a;

    /* renamed from: a  reason: collision with other field name */
    public ByteBuffer f681a;

    /* renamed from: b  reason: collision with other field name */
    public String f684b;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f676a = new jn("XmPushActionContainer");

    /* renamed from: a  reason: collision with root package name */
    private static final jf f14135a = new jf("", (byte) 8, 1);

    /* renamed from: b  reason: collision with root package name */
    private static final jf f14136b = new jf("", (byte) 2, 2);
    private static final jf c = new jf("", (byte) 2, 3);
    private static final jf d = new jf("", Constants.GZIP_CAST_TYPE, 4);
    private static final jf e = new jf("", Constants.GZIP_CAST_TYPE, 5);
    private static final jf f = new jf("", Constants.GZIP_CAST_TYPE, 6);
    private static final jf g = new jf("", (byte) 12, 7);
    private static final jf h = new jf("", (byte) 12, 8);

    /* renamed from: a  reason: collision with other field name */
    private BitSet f682a = new BitSet(2);

    /* renamed from: a  reason: collision with other field name */
    public boolean f683a = true;

    /* renamed from: b  reason: collision with other field name */
    public boolean f685b = true;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(ii iiVar) {
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        int a8;
        int a9;
        if (getClass().equals(iiVar.getClass())) {
            int compareTo = Boolean.valueOf(m448a()).compareTo(Boolean.valueOf(iiVar.m448a()));
            if (compareTo == 0) {
                if (!m448a() || (a9 = iy.a(this.f677a, iiVar.f677a)) == 0) {
                    int compareTo2 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(iiVar.c()));
                    if (compareTo2 == 0) {
                        if (!c() || (a8 = iy.a(this.f683a, iiVar.f683a)) == 0) {
                            int compareTo3 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(iiVar.d()));
                            if (compareTo3 == 0) {
                                if (!d() || (a7 = iy.a(this.f685b, iiVar.f685b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(iiVar.e()));
                                    if (compareTo4 == 0) {
                                        if (!e() || (a6 = iy.a(this.f681a, iiVar.f681a)) == 0) {
                                            int compareTo5 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(iiVar.f()));
                                            if (compareTo5 == 0) {
                                                if (!f() || (a5 = iy.a(this.f680a, iiVar.f680a)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(iiVar.g()));
                                                    if (compareTo6 == 0) {
                                                        if (!g() || (a4 = iy.a(this.f684b, iiVar.f684b)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(iiVar.h()));
                                                            if (compareTo7 == 0) {
                                                                if (!h() || (a3 = iy.a(this.f679a, iiVar.f679a)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(iiVar.i()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!i() || (a2 = iy.a(this.f678a, iiVar.f678a)) == 0) {
                                                                            return 0;
                                                                        }
                                                                        return a2;
                                                                    }
                                                                    return compareTo8;
                                                                }
                                                                return a3;
                                                            }
                                                            return compareTo7;
                                                        }
                                                        return a4;
                                                    }
                                                    return compareTo6;
                                                }
                                                return a5;
                                            }
                                            return compareTo5;
                                        }
                                        return a6;
                                    }
                                    return compareTo4;
                                }
                                return a7;
                            }
                            return compareTo3;
                        }
                        return a8;
                    }
                    return compareTo2;
                }
                return a9;
            }
            return compareTo;
        }
        return getClass().getName().compareTo(iiVar.getClass().getName());
    }

    public hm a() {
        return this.f677a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public hz m444a() {
        return this.f678a;
    }

    public ii a(hm hmVar) {
        this.f677a = hmVar;
        return this;
    }

    public ii a(hz hzVar) {
        this.f678a = hzVar;
        return this;
    }

    public ii a(ib ibVar) {
        this.f679a = ibVar;
        return this;
    }

    public ii a(String str) {
        this.f680a = str;
        return this;
    }

    public ii a(ByteBuffer byteBuffer) {
        this.f681a = byteBuffer;
        return this;
    }

    public ii a(boolean z) {
        this.f683a = z;
        m447a(true);
        return this;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m445a() {
        return this.f680a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m446a() {
        if (this.f677a == null) {
            throw new jj("Required field 'action' was not present! Struct: " + toString());
        }
        if (this.f681a == null) {
            throw new jj("Required field 'pushAction' was not present! Struct: " + toString());
        }
        if (this.f679a == null) {
            throw new jj("Required field 'target' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m515a();
        while (true) {
            jf m511a = jiVar.m511a();
            if (m511a.f14171a == 0) {
                jiVar.f();
                if (!c()) {
                    throw new jj("Required field 'encryptAction' was not found in serialized data! Struct: " + toString());
                }
                if (!d()) {
                    throw new jj("Required field 'isRequest' was not found in serialized data! Struct: " + toString());
                }
                m446a();
                return;
            }
            switch (m511a.f857a) {
                case 1:
                    if (m511a.f14171a != 8) {
                        jl.a(jiVar, m511a.f14171a);
                        break;
                    } else {
                        this.f677a = hm.a(jiVar.m509a());
                        break;
                    }
                case 2:
                    if (m511a.f14171a != 2) {
                        jl.a(jiVar, m511a.f14171a);
                        break;
                    } else {
                        this.f683a = jiVar.m520a();
                        m447a(true);
                        break;
                    }
                case 3:
                    if (m511a.f14171a != 2) {
                        jl.a(jiVar, m511a.f14171a);
                        break;
                    } else {
                        this.f685b = jiVar.m520a();
                        m451b(true);
                        break;
                    }
                case 4:
                    if (m511a.f14171a != 11) {
                        jl.a(jiVar, m511a.f14171a);
                        break;
                    } else {
                        this.f681a = jiVar.m517a();
                        break;
                    }
                case 5:
                    if (m511a.f14171a != 11) {
                        jl.a(jiVar, m511a.f14171a);
                        break;
                    } else {
                        this.f680a = jiVar.m516a();
                        break;
                    }
                case 6:
                    if (m511a.f14171a != 11) {
                        jl.a(jiVar, m511a.f14171a);
                        break;
                    } else {
                        this.f684b = jiVar.m516a();
                        break;
                    }
                case 7:
                    if (m511a.f14171a != 12) {
                        jl.a(jiVar, m511a.f14171a);
                        break;
                    } else {
                        this.f679a = new ib();
                        this.f679a.a(jiVar);
                        break;
                    }
                case 8:
                    if (m511a.f14171a != 12) {
                        jl.a(jiVar, m511a.f14171a);
                        break;
                    } else {
                        this.f678a = new hz();
                        this.f678a.a(jiVar);
                        break;
                    }
                default:
                    jl.a(jiVar, m511a.f14171a);
                    break;
            }
            jiVar.g();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m447a(boolean z) {
        this.f682a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m448a() {
        return this.f677a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m449a(ii iiVar) {
        if (iiVar == null) {
            return false;
        }
        boolean m448a = m448a();
        boolean m448a2 = iiVar.m448a();
        if (((!m448a && !m448a2) || (m448a && m448a2 && this.f677a.equals(iiVar.f677a))) && this.f683a == iiVar.f683a && this.f685b == iiVar.f685b) {
            boolean e2 = e();
            boolean e3 = iiVar.e();
            if ((e2 || e3) && !(e2 && e3 && this.f681a.equals(iiVar.f681a))) {
                return false;
            }
            boolean f2 = f();
            boolean f3 = iiVar.f();
            if ((f2 || f3) && !(f2 && f3 && this.f680a.equals(iiVar.f680a))) {
                return false;
            }
            boolean g2 = g();
            boolean g3 = iiVar.g();
            if ((g2 || g3) && !(g2 && g3 && this.f684b.equals(iiVar.f684b))) {
                return false;
            }
            boolean h2 = h();
            boolean h3 = iiVar.h();
            if ((h2 || h3) && !(h2 && h3 && this.f679a.m424a(iiVar.f679a))) {
                return false;
            }
            boolean i = i();
            boolean i2 = iiVar.i();
            return !(i || i2) || (i && i2 && this.f678a.m407a(iiVar.f678a));
        }
        return false;
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m450a() {
        a(iy.a(this.f681a));
        return this.f681a.array();
    }

    public ii b(String str) {
        this.f684b = str;
        return this;
    }

    public ii b(boolean z) {
        this.f685b = z;
        m451b(true);
        return this;
    }

    public String b() {
        return this.f684b;
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        m446a();
        jiVar.a(f676a);
        if (this.f677a != null) {
            jiVar.a(f14135a);
            jiVar.a(this.f677a.a());
            jiVar.b();
        }
        jiVar.a(f14136b);
        jiVar.a(this.f683a);
        jiVar.b();
        jiVar.a(c);
        jiVar.a(this.f685b);
        jiVar.b();
        if (this.f681a != null) {
            jiVar.a(d);
            jiVar.a(this.f681a);
            jiVar.b();
        }
        if (this.f680a != null && f()) {
            jiVar.a(e);
            jiVar.a(this.f680a);
            jiVar.b();
        }
        if (this.f684b != null && g()) {
            jiVar.a(f);
            jiVar.a(this.f684b);
            jiVar.b();
        }
        if (this.f679a != null) {
            jiVar.a(g);
            this.f679a.b(jiVar);
            jiVar.b();
        }
        if (this.f678a != null && i()) {
            jiVar.a(h);
            this.f678a.b(jiVar);
            jiVar.b();
        }
        jiVar.c();
        jiVar.m519a();
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m451b(boolean z) {
        this.f682a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m452b() {
        return this.f683a;
    }

    public boolean c() {
        return this.f682a.get(0);
    }

    public boolean d() {
        return this.f682a.get(1);
    }

    public boolean e() {
        return this.f681a != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ii)) {
            return m449a((ii) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f680a != null;
    }

    public boolean g() {
        return this.f684b != null;
    }

    public boolean h() {
        return this.f679a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f678a != null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionContainer(");
        sb.append("action:");
        if (this.f677a == null) {
            sb.append("null");
        } else {
            sb.append(this.f677a);
        }
        sb.append(", ");
        sb.append("encryptAction:");
        sb.append(this.f683a);
        sb.append(", ");
        sb.append("isRequest:");
        sb.append(this.f685b);
        sb.append(", ");
        sb.append("pushAction:");
        if (this.f681a == null) {
            sb.append("null");
        } else {
            iy.a(this.f681a, sb);
        }
        if (f()) {
            sb.append(", ");
            sb.append("appid:");
            if (this.f680a == null) {
                sb.append("null");
            } else {
                sb.append(this.f680a);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f684b == null) {
                sb.append("null");
            } else {
                sb.append(this.f684b);
            }
        }
        sb.append(", ");
        sb.append("target:");
        if (this.f679a == null) {
            sb.append("null");
        } else {
            sb.append(this.f679a);
        }
        if (i()) {
            sb.append(", ");
            sb.append("metaInfo:");
            if (this.f678a == null) {
                sb.append("null");
            } else {
                sb.append(this.f678a);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
