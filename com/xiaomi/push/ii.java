package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.BitSet;
/* loaded from: classes6.dex */
public class ii implements ix<ii, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public hm f678a;

    /* renamed from: a  reason: collision with other field name */
    public hz f679a;

    /* renamed from: a  reason: collision with other field name */
    public ib f680a;

    /* renamed from: a  reason: collision with other field name */
    public String f681a;

    /* renamed from: a  reason: collision with other field name */
    public ByteBuffer f682a;

    /* renamed from: b  reason: collision with other field name */
    public String f685b;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f677a = new jn("XmPushActionContainer");

    /* renamed from: a  reason: collision with root package name */
    private static final jf f14435a = new jf("", (byte) 8, 1);

    /* renamed from: b  reason: collision with root package name */
    private static final jf f14436b = new jf("", (byte) 2, 2);
    private static final jf c = new jf("", (byte) 2, 3);
    private static final jf d = new jf("", Constants.GZIP_CAST_TYPE, 4);
    private static final jf e = new jf("", Constants.GZIP_CAST_TYPE, 5);
    private static final jf f = new jf("", Constants.GZIP_CAST_TYPE, 6);
    private static final jf g = new jf("", (byte) 12, 7);
    private static final jf h = new jf("", (byte) 12, 8);

    /* renamed from: a  reason: collision with other field name */
    private BitSet f683a = new BitSet(2);

    /* renamed from: a  reason: collision with other field name */
    public boolean f684a = true;

    /* renamed from: b  reason: collision with other field name */
    public boolean f686b = true;

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
            int compareTo = Boolean.valueOf(m452a()).compareTo(Boolean.valueOf(iiVar.m452a()));
            if (compareTo == 0) {
                if (!m452a() || (a9 = iy.a(this.f678a, iiVar.f678a)) == 0) {
                    int compareTo2 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(iiVar.c()));
                    if (compareTo2 == 0) {
                        if (!c() || (a8 = iy.a(this.f684a, iiVar.f684a)) == 0) {
                            int compareTo3 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(iiVar.d()));
                            if (compareTo3 == 0) {
                                if (!d() || (a7 = iy.a(this.f686b, iiVar.f686b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(iiVar.e()));
                                    if (compareTo4 == 0) {
                                        if (!e() || (a6 = iy.a(this.f682a, iiVar.f682a)) == 0) {
                                            int compareTo5 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(iiVar.f()));
                                            if (compareTo5 == 0) {
                                                if (!f() || (a5 = iy.a(this.f681a, iiVar.f681a)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(iiVar.g()));
                                                    if (compareTo6 == 0) {
                                                        if (!g() || (a4 = iy.a(this.f685b, iiVar.f685b)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(iiVar.h()));
                                                            if (compareTo7 == 0) {
                                                                if (!h() || (a3 = iy.a(this.f680a, iiVar.f680a)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(iiVar.i()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!i() || (a2 = iy.a(this.f679a, iiVar.f679a)) == 0) {
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
        return this.f678a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public hz m448a() {
        return this.f679a;
    }

    public ii a(hm hmVar) {
        this.f678a = hmVar;
        return this;
    }

    public ii a(hz hzVar) {
        this.f679a = hzVar;
        return this;
    }

    public ii a(ib ibVar) {
        this.f680a = ibVar;
        return this;
    }

    public ii a(String str) {
        this.f681a = str;
        return this;
    }

    public ii a(ByteBuffer byteBuffer) {
        this.f682a = byteBuffer;
        return this;
    }

    public ii a(boolean z) {
        this.f684a = z;
        m451a(true);
        return this;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m449a() {
        return this.f681a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m450a() {
        if (this.f678a == null) {
            throw new jj("Required field 'action' was not present! Struct: " + toString());
        }
        if (this.f682a == null) {
            throw new jj("Required field 'pushAction' was not present! Struct: " + toString());
        }
        if (this.f680a == null) {
            throw new jj("Required field 'target' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m519a();
        while (true) {
            jf m515a = jiVar.m515a();
            if (m515a.f14471a == 0) {
                jiVar.f();
                if (!c()) {
                    throw new jj("Required field 'encryptAction' was not found in serialized data! Struct: " + toString());
                }
                if (!d()) {
                    throw new jj("Required field 'isRequest' was not found in serialized data! Struct: " + toString());
                }
                m450a();
                return;
            }
            switch (m515a.f858a) {
                case 1:
                    if (m515a.f14471a != 8) {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    } else {
                        this.f678a = hm.a(jiVar.m513a());
                        break;
                    }
                case 2:
                    if (m515a.f14471a != 2) {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    } else {
                        this.f684a = jiVar.m524a();
                        m451a(true);
                        break;
                    }
                case 3:
                    if (m515a.f14471a != 2) {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    } else {
                        this.f686b = jiVar.m524a();
                        m455b(true);
                        break;
                    }
                case 4:
                    if (m515a.f14471a != 11) {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    } else {
                        this.f682a = jiVar.m521a();
                        break;
                    }
                case 5:
                    if (m515a.f14471a != 11) {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    } else {
                        this.f681a = jiVar.m520a();
                        break;
                    }
                case 6:
                    if (m515a.f14471a != 11) {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    } else {
                        this.f685b = jiVar.m520a();
                        break;
                    }
                case 7:
                    if (m515a.f14471a != 12) {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    } else {
                        this.f680a = new ib();
                        this.f680a.a(jiVar);
                        break;
                    }
                case 8:
                    if (m515a.f14471a != 12) {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    } else {
                        this.f679a = new hz();
                        this.f679a.a(jiVar);
                        break;
                    }
                default:
                    jl.a(jiVar, m515a.f14471a);
                    break;
            }
            jiVar.g();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m451a(boolean z) {
        this.f683a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m452a() {
        return this.f678a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m453a(ii iiVar) {
        if (iiVar == null) {
            return false;
        }
        boolean m452a = m452a();
        boolean m452a2 = iiVar.m452a();
        if (((!m452a && !m452a2) || (m452a && m452a2 && this.f678a.equals(iiVar.f678a))) && this.f684a == iiVar.f684a && this.f686b == iiVar.f686b) {
            boolean e2 = e();
            boolean e3 = iiVar.e();
            if ((e2 || e3) && !(e2 && e3 && this.f682a.equals(iiVar.f682a))) {
                return false;
            }
            boolean f2 = f();
            boolean f3 = iiVar.f();
            if ((f2 || f3) && !(f2 && f3 && this.f681a.equals(iiVar.f681a))) {
                return false;
            }
            boolean g2 = g();
            boolean g3 = iiVar.g();
            if ((g2 || g3) && !(g2 && g3 && this.f685b.equals(iiVar.f685b))) {
                return false;
            }
            boolean h2 = h();
            boolean h3 = iiVar.h();
            if ((h2 || h3) && !(h2 && h3 && this.f680a.m428a(iiVar.f680a))) {
                return false;
            }
            boolean i = i();
            boolean i2 = iiVar.i();
            return !(i || i2) || (i && i2 && this.f679a.m411a(iiVar.f679a));
        }
        return false;
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m454a() {
        a(iy.a(this.f682a));
        return this.f682a.array();
    }

    public ii b(String str) {
        this.f685b = str;
        return this;
    }

    public ii b(boolean z) {
        this.f686b = z;
        m455b(true);
        return this;
    }

    public String b() {
        return this.f685b;
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        m450a();
        jiVar.a(f677a);
        if (this.f678a != null) {
            jiVar.a(f14435a);
            jiVar.a(this.f678a.a());
            jiVar.b();
        }
        jiVar.a(f14436b);
        jiVar.a(this.f684a);
        jiVar.b();
        jiVar.a(c);
        jiVar.a(this.f686b);
        jiVar.b();
        if (this.f682a != null) {
            jiVar.a(d);
            jiVar.a(this.f682a);
            jiVar.b();
        }
        if (this.f681a != null && f()) {
            jiVar.a(e);
            jiVar.a(this.f681a);
            jiVar.b();
        }
        if (this.f685b != null && g()) {
            jiVar.a(f);
            jiVar.a(this.f685b);
            jiVar.b();
        }
        if (this.f680a != null) {
            jiVar.a(g);
            this.f680a.b(jiVar);
            jiVar.b();
        }
        if (this.f679a != null && i()) {
            jiVar.a(h);
            this.f679a.b(jiVar);
            jiVar.b();
        }
        jiVar.c();
        jiVar.m523a();
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m455b(boolean z) {
        this.f683a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m456b() {
        return this.f684a;
    }

    public boolean c() {
        return this.f683a.get(0);
    }

    public boolean d() {
        return this.f683a.get(1);
    }

    public boolean e() {
        return this.f682a != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ii)) {
            return m453a((ii) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f681a != null;
    }

    public boolean g() {
        return this.f685b != null;
    }

    public boolean h() {
        return this.f680a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f679a != null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionContainer(");
        sb.append("action:");
        if (this.f678a == null) {
            sb.append("null");
        } else {
            sb.append(this.f678a);
        }
        sb.append(", ");
        sb.append("encryptAction:");
        sb.append(this.f684a);
        sb.append(", ");
        sb.append("isRequest:");
        sb.append(this.f686b);
        sb.append(", ");
        sb.append("pushAction:");
        if (this.f682a == null) {
            sb.append("null");
        } else {
            iy.a(this.f682a, sb);
        }
        if (f()) {
            sb.append(", ");
            sb.append("appid:");
            if (this.f681a == null) {
                sb.append("null");
            } else {
                sb.append(this.f681a);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f685b == null) {
                sb.append("null");
            } else {
                sb.append(this.f685b);
            }
        }
        sb.append(", ");
        sb.append("target:");
        if (this.f680a == null) {
            sb.append("null");
        } else {
            sb.append(this.f680a);
        }
        if (i()) {
            sb.append(", ");
            sb.append("metaInfo:");
            if (this.f679a == null) {
                sb.append("null");
            } else {
                sb.append(this.f679a);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
