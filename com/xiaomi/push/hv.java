package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
/* loaded from: classes9.dex */
public class hv implements ix<hv, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public int f471a;

    /* renamed from: a  reason: collision with other field name */
    public hs f472a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f473a = new BitSet(1);

    /* renamed from: a  reason: collision with other field name */
    public List<hx> f474a;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f470a = new jn("NormalConfig");
    private static final jf a = new jf("", (byte) 8, 1);
    private static final jf b = new jf("", (byte) 15, 2);
    private static final jf c = new jf("", (byte) 8, 3);

    public int a() {
        return this.f471a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(hv hvVar) {
        int a2;
        int a3;
        int a4;
        if (getClass().equals(hvVar.getClass())) {
            int compareTo = Boolean.valueOf(m360a()).compareTo(Boolean.valueOf(hvVar.m360a()));
            if (compareTo == 0) {
                if (!m360a() || (a4 = iy.a(this.f471a, hvVar.f471a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(hvVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a3 = iy.a(this.f474a, hvVar.f474a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(hvVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a2 = iy.a(this.f472a, hvVar.f472a)) == 0) {
                                    return 0;
                                }
                                return a2;
                            }
                            return compareTo3;
                        }
                        return a3;
                    }
                    return compareTo2;
                }
                return a4;
            }
            return compareTo;
        }
        return getClass().getName().compareTo(hvVar.getClass().getName());
    }

    /* renamed from: a  reason: collision with other method in class */
    public hs m358a() {
        return this.f472a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m359a() {
        if (this.f474a == null) {
            throw new jj("Required field 'configItems' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m489a();
        while (true) {
            jf m485a = jiVar.m485a();
            if (m485a.a == 0) {
                jiVar.f();
                if (!m360a()) {
                    throw new jj("Required field 'version' was not found in serialized data! Struct: " + toString());
                }
                m359a();
                return;
            }
            switch (m485a.f778a) {
                case 1:
                    if (m485a.a == 8) {
                        this.f471a = jiVar.m483a();
                        a(true);
                        break;
                    } else {
                        jl.a(jiVar, m485a.a);
                        break;
                    }
                case 2:
                    if (m485a.a == 15) {
                        jg m486a = jiVar.m486a();
                        this.f474a = new ArrayList(m486a.f779a);
                        for (int i = 0; i < m486a.f779a; i++) {
                            hx hxVar = new hx();
                            hxVar.a(jiVar);
                            this.f474a.add(hxVar);
                        }
                        jiVar.i();
                        break;
                    } else {
                        jl.a(jiVar, m485a.a);
                        break;
                    }
                case 3:
                    if (m485a.a == 8) {
                        this.f472a = hs.a(jiVar.m483a());
                        break;
                    } else {
                        jl.a(jiVar, m485a.a);
                        break;
                    }
                default:
                    jl.a(jiVar, m485a.a);
                    break;
            }
            jiVar.g();
        }
    }

    public void a(boolean z) {
        this.f473a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m360a() {
        return this.f473a.get(0);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m361a(hv hvVar) {
        if (hvVar != null && this.f471a == hvVar.f471a) {
            boolean b2 = b();
            boolean b3 = hvVar.b();
            if ((b2 || b3) && !(b2 && b3 && this.f474a.equals(hvVar.f474a))) {
                return false;
            }
            boolean c2 = c();
            boolean c3 = hvVar.c();
            return !(c2 || c3) || (c2 && c3 && this.f472a.equals(hvVar.f472a));
        }
        return false;
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        m359a();
        jiVar.a(f470a);
        jiVar.a(a);
        jiVar.a(this.f471a);
        jiVar.b();
        if (this.f474a != null) {
            jiVar.a(b);
            jiVar.a(new jg((byte) 12, this.f474a.size()));
            for (hx hxVar : this.f474a) {
                hxVar.b(jiVar);
            }
            jiVar.e();
            jiVar.b();
        }
        if (this.f472a != null && c()) {
            jiVar.a(c);
            jiVar.a(this.f472a.a());
            jiVar.b();
        }
        jiVar.c();
        jiVar.m493a();
    }

    public boolean b() {
        return this.f474a != null;
    }

    public boolean c() {
        return this.f472a != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hv)) {
            return m361a((hv) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("NormalConfig(");
        sb.append("version:");
        sb.append(this.f471a);
        sb.append(", ");
        sb.append("configItems:");
        if (this.f474a == null) {
            sb.append("null");
        } else {
            sb.append(this.f474a);
        }
        if (c()) {
            sb.append(", ");
            sb.append("type:");
            if (this.f472a == null) {
                sb.append("null");
            } else {
                sb.append(this.f472a);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
