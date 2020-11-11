package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.BitSet;
/* loaded from: classes12.dex */
public class ii implements ix<ii, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public hm f598a;

    /* renamed from: a  reason: collision with other field name */
    public hz f599a;

    /* renamed from: a  reason: collision with other field name */
    public ib f600a;

    /* renamed from: a  reason: collision with other field name */
    public String f601a;

    /* renamed from: a  reason: collision with other field name */
    public ByteBuffer f602a;

    /* renamed from: b  reason: collision with other field name */
    public String f605b;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f597a = new jn("XmPushActionContainer");

    /* renamed from: a  reason: collision with root package name */
    private static final jf f4978a = new jf("", (byte) 8, 1);
    private static final jf b = new jf("", (byte) 2, 2);
    private static final jf c = new jf("", (byte) 2, 3);
    private static final jf d = new jf("", Constants.GZIP_CAST_TYPE, 4);
    private static final jf e = new jf("", Constants.GZIP_CAST_TYPE, 5);
    private static final jf f = new jf("", Constants.GZIP_CAST_TYPE, 6);
    private static final jf g = new jf("", (byte) 12, 7);
    private static final jf h = new jf("", (byte) 12, 8);

    /* renamed from: a  reason: collision with other field name */
    private BitSet f603a = new BitSet(2);

    /* renamed from: a  reason: collision with other field name */
    public boolean f604a = true;

    /* renamed from: b  reason: collision with other field name */
    public boolean f606b = true;

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
            int compareTo = Boolean.valueOf(m422a()).compareTo(Boolean.valueOf(iiVar.m422a()));
            if (compareTo == 0) {
                if (!m422a() || (a9 = iy.a(this.f598a, iiVar.f598a)) == 0) {
                    int compareTo2 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(iiVar.c()));
                    if (compareTo2 == 0) {
                        if (!c() || (a8 = iy.a(this.f604a, iiVar.f604a)) == 0) {
                            int compareTo3 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(iiVar.d()));
                            if (compareTo3 == 0) {
                                if (!d() || (a7 = iy.a(this.f606b, iiVar.f606b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(iiVar.e()));
                                    if (compareTo4 == 0) {
                                        if (!e() || (a6 = iy.a(this.f602a, iiVar.f602a)) == 0) {
                                            int compareTo5 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(iiVar.f()));
                                            if (compareTo5 == 0) {
                                                if (!f() || (a5 = iy.a(this.f601a, iiVar.f601a)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(iiVar.g()));
                                                    if (compareTo6 == 0) {
                                                        if (!g() || (a4 = iy.a(this.f605b, iiVar.f605b)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(iiVar.h()));
                                                            if (compareTo7 == 0) {
                                                                if (!h() || (a3 = iy.a(this.f600a, iiVar.f600a)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(iiVar.i()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!i() || (a2 = iy.a(this.f599a, iiVar.f599a)) == 0) {
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
        return this.f598a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public hz m418a() {
        return this.f599a;
    }

    public ii a(hm hmVar) {
        this.f598a = hmVar;
        return this;
    }

    public ii a(hz hzVar) {
        this.f599a = hzVar;
        return this;
    }

    public ii a(ib ibVar) {
        this.f600a = ibVar;
        return this;
    }

    public ii a(String str) {
        this.f601a = str;
        return this;
    }

    public ii a(ByteBuffer byteBuffer) {
        this.f602a = byteBuffer;
        return this;
    }

    public ii a(boolean z) {
        this.f604a = z;
        m421a(true);
        return this;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m419a() {
        return this.f601a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m420a() {
        if (this.f598a == null) {
            throw new jj("Required field 'action' was not present! Struct: " + toString());
        }
        if (this.f602a == null) {
            throw new jj("Required field 'pushAction' was not present! Struct: " + toString());
        }
        if (this.f600a == null) {
            throw new jj("Required field 'target' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m489a();
        while (true) {
            jf m485a = jiVar.m485a();
            if (m485a.f5000a == 0) {
                jiVar.f();
                if (!c()) {
                    throw new jj("Required field 'encryptAction' was not found in serialized data! Struct: " + toString());
                }
                if (!d()) {
                    throw new jj("Required field 'isRequest' was not found in serialized data! Struct: " + toString());
                }
                m420a();
                return;
            }
            switch (m485a.f778a) {
                case 1:
                    if (m485a.f5000a != 8) {
                        jl.a(jiVar, m485a.f5000a);
                        break;
                    } else {
                        this.f598a = hm.a(jiVar.m483a());
                        break;
                    }
                case 2:
                    if (m485a.f5000a != 2) {
                        jl.a(jiVar, m485a.f5000a);
                        break;
                    } else {
                        this.f604a = jiVar.m494a();
                        m421a(true);
                        break;
                    }
                case 3:
                    if (m485a.f5000a != 2) {
                        jl.a(jiVar, m485a.f5000a);
                        break;
                    } else {
                        this.f606b = jiVar.m494a();
                        m425b(true);
                        break;
                    }
                case 4:
                    if (m485a.f5000a != 11) {
                        jl.a(jiVar, m485a.f5000a);
                        break;
                    } else {
                        this.f602a = jiVar.m491a();
                        break;
                    }
                case 5:
                    if (m485a.f5000a != 11) {
                        jl.a(jiVar, m485a.f5000a);
                        break;
                    } else {
                        this.f601a = jiVar.m490a();
                        break;
                    }
                case 6:
                    if (m485a.f5000a != 11) {
                        jl.a(jiVar, m485a.f5000a);
                        break;
                    } else {
                        this.f605b = jiVar.m490a();
                        break;
                    }
                case 7:
                    if (m485a.f5000a != 12) {
                        jl.a(jiVar, m485a.f5000a);
                        break;
                    } else {
                        this.f600a = new ib();
                        this.f600a.a(jiVar);
                        break;
                    }
                case 8:
                    if (m485a.f5000a != 12) {
                        jl.a(jiVar, m485a.f5000a);
                        break;
                    } else {
                        this.f599a = new hz();
                        this.f599a.a(jiVar);
                        break;
                    }
                default:
                    jl.a(jiVar, m485a.f5000a);
                    break;
            }
            jiVar.g();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m421a(boolean z) {
        this.f603a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m422a() {
        return this.f598a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m423a(ii iiVar) {
        if (iiVar == null) {
            return false;
        }
        boolean m422a = m422a();
        boolean m422a2 = iiVar.m422a();
        if (((!m422a && !m422a2) || (m422a && m422a2 && this.f598a.equals(iiVar.f598a))) && this.f604a == iiVar.f604a && this.f606b == iiVar.f606b) {
            boolean e2 = e();
            boolean e3 = iiVar.e();
            if ((e2 || e3) && !(e2 && e3 && this.f602a.equals(iiVar.f602a))) {
                return false;
            }
            boolean f2 = f();
            boolean f3 = iiVar.f();
            if ((f2 || f3) && !(f2 && f3 && this.f601a.equals(iiVar.f601a))) {
                return false;
            }
            boolean g2 = g();
            boolean g3 = iiVar.g();
            if ((g2 || g3) && !(g2 && g3 && this.f605b.equals(iiVar.f605b))) {
                return false;
            }
            boolean h2 = h();
            boolean h3 = iiVar.h();
            if ((h2 || h3) && !(h2 && h3 && this.f600a.m398a(iiVar.f600a))) {
                return false;
            }
            boolean i = i();
            boolean i2 = iiVar.i();
            return !(i || i2) || (i && i2 && this.f599a.m381a(iiVar.f599a));
        }
        return false;
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m424a() {
        a(iy.a(this.f602a));
        return this.f602a.array();
    }

    public ii b(String str) {
        this.f605b = str;
        return this;
    }

    public ii b(boolean z) {
        this.f606b = z;
        m425b(true);
        return this;
    }

    public String b() {
        return this.f605b;
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        m420a();
        jiVar.a(f597a);
        if (this.f598a != null) {
            jiVar.a(f4978a);
            jiVar.a(this.f598a.a());
            jiVar.b();
        }
        jiVar.a(b);
        jiVar.a(this.f604a);
        jiVar.b();
        jiVar.a(c);
        jiVar.a(this.f606b);
        jiVar.b();
        if (this.f602a != null) {
            jiVar.a(d);
            jiVar.a(this.f602a);
            jiVar.b();
        }
        if (this.f601a != null && f()) {
            jiVar.a(e);
            jiVar.a(this.f601a);
            jiVar.b();
        }
        if (this.f605b != null && g()) {
            jiVar.a(f);
            jiVar.a(this.f605b);
            jiVar.b();
        }
        if (this.f600a != null) {
            jiVar.a(g);
            this.f600a.b(jiVar);
            jiVar.b();
        }
        if (this.f599a != null && i()) {
            jiVar.a(h);
            this.f599a.b(jiVar);
            jiVar.b();
        }
        jiVar.c();
        jiVar.m493a();
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m425b(boolean z) {
        this.f603a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m426b() {
        return this.f604a;
    }

    public boolean c() {
        return this.f603a.get(0);
    }

    public boolean d() {
        return this.f603a.get(1);
    }

    public boolean e() {
        return this.f602a != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ii)) {
            return m423a((ii) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f601a != null;
    }

    public boolean g() {
        return this.f605b != null;
    }

    public boolean h() {
        return this.f600a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f599a != null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionContainer(");
        sb.append("action:");
        if (this.f598a == null) {
            sb.append("null");
        } else {
            sb.append(this.f598a);
        }
        sb.append(", ");
        sb.append("encryptAction:");
        sb.append(this.f604a);
        sb.append(", ");
        sb.append("isRequest:");
        sb.append(this.f606b);
        sb.append(", ");
        sb.append("pushAction:");
        if (this.f602a == null) {
            sb.append("null");
        } else {
            iy.a(this.f602a, sb);
        }
        if (f()) {
            sb.append(", ");
            sb.append("appid:");
            if (this.f601a == null) {
                sb.append("null");
            } else {
                sb.append(this.f601a);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f605b == null) {
                sb.append("null");
            } else {
                sb.append(this.f605b);
            }
        }
        sb.append(", ");
        sb.append("target:");
        if (this.f600a == null) {
            sb.append("null");
        } else {
            sb.append(this.f600a);
        }
        if (i()) {
            sb.append(", ");
            sb.append("metaInfo:");
            if (this.f599a == null) {
                sb.append("null");
            } else {
                sb.append(this.f599a);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
