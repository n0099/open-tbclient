package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.BitSet;
/* loaded from: classes8.dex */
public class ii implements ix<ii, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public hm f597a;

    /* renamed from: a  reason: collision with other field name */
    public hz f598a;

    /* renamed from: a  reason: collision with other field name */
    public ib f599a;

    /* renamed from: a  reason: collision with other field name */
    public String f600a;

    /* renamed from: a  reason: collision with other field name */
    public ByteBuffer f601a;

    /* renamed from: b  reason: collision with other field name */
    public String f604b;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f596a = new jn("XmPushActionContainer");
    private static final jf a = new jf("", (byte) 8, 1);
    private static final jf b = new jf("", (byte) 2, 2);
    private static final jf c = new jf("", (byte) 2, 3);
    private static final jf d = new jf("", Constants.GZIP_CAST_TYPE, 4);
    private static final jf e = new jf("", Constants.GZIP_CAST_TYPE, 5);
    private static final jf f = new jf("", Constants.GZIP_CAST_TYPE, 6);
    private static final jf g = new jf("", (byte) 12, 7);
    private static final jf h = new jf("", (byte) 12, 8);

    /* renamed from: a  reason: collision with other field name */
    private BitSet f602a = new BitSet(2);

    /* renamed from: a  reason: collision with other field name */
    public boolean f603a = true;

    /* renamed from: b  reason: collision with other field name */
    public boolean f605b = true;

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
            int compareTo = Boolean.valueOf(m420a()).compareTo(Boolean.valueOf(iiVar.m420a()));
            if (compareTo == 0) {
                if (!m420a() || (a9 = iy.a(this.f597a, iiVar.f597a)) == 0) {
                    int compareTo2 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(iiVar.c()));
                    if (compareTo2 == 0) {
                        if (!c() || (a8 = iy.a(this.f603a, iiVar.f603a)) == 0) {
                            int compareTo3 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(iiVar.d()));
                            if (compareTo3 == 0) {
                                if (!d() || (a7 = iy.a(this.f605b, iiVar.f605b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(iiVar.e()));
                                    if (compareTo4 == 0) {
                                        if (!e() || (a6 = iy.a(this.f601a, iiVar.f601a)) == 0) {
                                            int compareTo5 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(iiVar.f()));
                                            if (compareTo5 == 0) {
                                                if (!f() || (a5 = iy.a(this.f600a, iiVar.f600a)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(iiVar.g()));
                                                    if (compareTo6 == 0) {
                                                        if (!g() || (a4 = iy.a(this.f604b, iiVar.f604b)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(iiVar.h()));
                                                            if (compareTo7 == 0) {
                                                                if (!h() || (a3 = iy.a(this.f599a, iiVar.f599a)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(iiVar.i()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!i() || (a2 = iy.a(this.f598a, iiVar.f598a)) == 0) {
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
        return this.f597a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public hz m416a() {
        return this.f598a;
    }

    public ii a(hm hmVar) {
        this.f597a = hmVar;
        return this;
    }

    public ii a(hz hzVar) {
        this.f598a = hzVar;
        return this;
    }

    public ii a(ib ibVar) {
        this.f599a = ibVar;
        return this;
    }

    public ii a(String str) {
        this.f600a = str;
        return this;
    }

    public ii a(ByteBuffer byteBuffer) {
        this.f601a = byteBuffer;
        return this;
    }

    public ii a(boolean z) {
        this.f603a = z;
        m419a(true);
        return this;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m417a() {
        return this.f600a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m418a() {
        if (this.f597a == null) {
            throw new jj("Required field 'action' was not present! Struct: " + toString());
        }
        if (this.f601a == null) {
            throw new jj("Required field 'pushAction' was not present! Struct: " + toString());
        }
        if (this.f599a == null) {
            throw new jj("Required field 'target' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m487a();
        while (true) {
            jf m483a = jiVar.m483a();
            if (m483a.a == 0) {
                jiVar.f();
                if (!c()) {
                    throw new jj("Required field 'encryptAction' was not found in serialized data! Struct: " + toString());
                }
                if (!d()) {
                    throw new jj("Required field 'isRequest' was not found in serialized data! Struct: " + toString());
                }
                m418a();
                return;
            }
            switch (m483a.f777a) {
                case 1:
                    if (m483a.a != 8) {
                        jl.a(jiVar, m483a.a);
                        break;
                    } else {
                        this.f597a = hm.a(jiVar.m481a());
                        break;
                    }
                case 2:
                    if (m483a.a != 2) {
                        jl.a(jiVar, m483a.a);
                        break;
                    } else {
                        this.f603a = jiVar.m492a();
                        m419a(true);
                        break;
                    }
                case 3:
                    if (m483a.a != 2) {
                        jl.a(jiVar, m483a.a);
                        break;
                    } else {
                        this.f605b = jiVar.m492a();
                        m423b(true);
                        break;
                    }
                case 4:
                    if (m483a.a != 11) {
                        jl.a(jiVar, m483a.a);
                        break;
                    } else {
                        this.f601a = jiVar.m489a();
                        break;
                    }
                case 5:
                    if (m483a.a != 11) {
                        jl.a(jiVar, m483a.a);
                        break;
                    } else {
                        this.f600a = jiVar.m488a();
                        break;
                    }
                case 6:
                    if (m483a.a != 11) {
                        jl.a(jiVar, m483a.a);
                        break;
                    } else {
                        this.f604b = jiVar.m488a();
                        break;
                    }
                case 7:
                    if (m483a.a != 12) {
                        jl.a(jiVar, m483a.a);
                        break;
                    } else {
                        this.f599a = new ib();
                        this.f599a.a(jiVar);
                        break;
                    }
                case 8:
                    if (m483a.a != 12) {
                        jl.a(jiVar, m483a.a);
                        break;
                    } else {
                        this.f598a = new hz();
                        this.f598a.a(jiVar);
                        break;
                    }
                default:
                    jl.a(jiVar, m483a.a);
                    break;
            }
            jiVar.g();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m419a(boolean z) {
        this.f602a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m420a() {
        return this.f597a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m421a(ii iiVar) {
        if (iiVar == null) {
            return false;
        }
        boolean m420a = m420a();
        boolean m420a2 = iiVar.m420a();
        if (((!m420a && !m420a2) || (m420a && m420a2 && this.f597a.equals(iiVar.f597a))) && this.f603a == iiVar.f603a && this.f605b == iiVar.f605b) {
            boolean e2 = e();
            boolean e3 = iiVar.e();
            if ((e2 || e3) && !(e2 && e3 && this.f601a.equals(iiVar.f601a))) {
                return false;
            }
            boolean f2 = f();
            boolean f3 = iiVar.f();
            if ((f2 || f3) && !(f2 && f3 && this.f600a.equals(iiVar.f600a))) {
                return false;
            }
            boolean g2 = g();
            boolean g3 = iiVar.g();
            if ((g2 || g3) && !(g2 && g3 && this.f604b.equals(iiVar.f604b))) {
                return false;
            }
            boolean h2 = h();
            boolean h3 = iiVar.h();
            if ((h2 || h3) && !(h2 && h3 && this.f599a.m396a(iiVar.f599a))) {
                return false;
            }
            boolean i = i();
            boolean i2 = iiVar.i();
            return !(i || i2) || (i && i2 && this.f598a.m379a(iiVar.f598a));
        }
        return false;
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m422a() {
        a(iy.a(this.f601a));
        return this.f601a.array();
    }

    public ii b(String str) {
        this.f604b = str;
        return this;
    }

    public ii b(boolean z) {
        this.f605b = z;
        m423b(true);
        return this;
    }

    public String b() {
        return this.f604b;
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        m418a();
        jiVar.a(f596a);
        if (this.f597a != null) {
            jiVar.a(a);
            jiVar.a(this.f597a.a());
            jiVar.b();
        }
        jiVar.a(b);
        jiVar.a(this.f603a);
        jiVar.b();
        jiVar.a(c);
        jiVar.a(this.f605b);
        jiVar.b();
        if (this.f601a != null) {
            jiVar.a(d);
            jiVar.a(this.f601a);
            jiVar.b();
        }
        if (this.f600a != null && f()) {
            jiVar.a(e);
            jiVar.a(this.f600a);
            jiVar.b();
        }
        if (this.f604b != null && g()) {
            jiVar.a(f);
            jiVar.a(this.f604b);
            jiVar.b();
        }
        if (this.f599a != null) {
            jiVar.a(g);
            this.f599a.b(jiVar);
            jiVar.b();
        }
        if (this.f598a != null && i()) {
            jiVar.a(h);
            this.f598a.b(jiVar);
            jiVar.b();
        }
        jiVar.c();
        jiVar.m491a();
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m423b(boolean z) {
        this.f602a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m424b() {
        return this.f603a;
    }

    public boolean c() {
        return this.f602a.get(0);
    }

    public boolean d() {
        return this.f602a.get(1);
    }

    public boolean e() {
        return this.f601a != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ii)) {
            return m421a((ii) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f600a != null;
    }

    public boolean g() {
        return this.f604b != null;
    }

    public boolean h() {
        return this.f599a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f598a != null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionContainer(");
        sb.append("action:");
        if (this.f597a == null) {
            sb.append("null");
        } else {
            sb.append(this.f597a);
        }
        sb.append(", ");
        sb.append("encryptAction:");
        sb.append(this.f603a);
        sb.append(", ");
        sb.append("isRequest:");
        sb.append(this.f605b);
        sb.append(", ");
        sb.append("pushAction:");
        if (this.f601a == null) {
            sb.append("null");
        } else {
            iy.a(this.f601a, sb);
        }
        if (f()) {
            sb.append(", ");
            sb.append("appid:");
            if (this.f600a == null) {
                sb.append("null");
            } else {
                sb.append(this.f600a);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f604b == null) {
                sb.append("null");
            } else {
                sb.append(this.f604b);
            }
        }
        sb.append(", ");
        sb.append("target:");
        if (this.f599a == null) {
            sb.append("null");
        } else {
            sb.append(this.f599a);
        }
        if (i()) {
            sb.append(", ");
            sb.append("metaInfo:");
            if (this.f598a == null) {
                sb.append("null");
            } else {
                sb.append(this.f598a);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
