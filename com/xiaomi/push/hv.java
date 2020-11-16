package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
/* loaded from: classes18.dex */
public class hv implements ix<hv, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public int f474a;

    /* renamed from: a  reason: collision with other field name */
    public hs f475a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f476a = new BitSet(1);

    /* renamed from: a  reason: collision with other field name */
    public List<hx> f477a;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f473a = new jn("NormalConfig");

    /* renamed from: a  reason: collision with root package name */
    private static final jf f4964a = new jf("", (byte) 8, 1);
    private static final jf b = new jf("", (byte) 15, 2);
    private static final jf c = new jf("", (byte) 8, 3);

    public int a() {
        return this.f474a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(hv hvVar) {
        int a2;
        int a3;
        int a4;
        if (getClass().equals(hvVar.getClass())) {
            int compareTo = Boolean.valueOf(m363a()).compareTo(Boolean.valueOf(hvVar.m363a()));
            if (compareTo == 0) {
                if (!m363a() || (a4 = iy.a(this.f474a, hvVar.f474a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(hvVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a3 = iy.a(this.f477a, hvVar.f477a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(hvVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a2 = iy.a(this.f475a, hvVar.f475a)) == 0) {
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
    public hs m361a() {
        return this.f475a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m362a() {
        if (this.f477a == null) {
            throw new jj("Required field 'configItems' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m492a();
        while (true) {
            jf m488a = jiVar.m488a();
            if (m488a.f5000a == 0) {
                jiVar.f();
                if (!m363a()) {
                    throw new jj("Required field 'version' was not found in serialized data! Struct: " + toString());
                }
                m362a();
                return;
            }
            switch (m488a.f781a) {
                case 1:
                    if (m488a.f5000a == 8) {
                        this.f474a = jiVar.m486a();
                        a(true);
                        break;
                    } else {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    }
                case 2:
                    if (m488a.f5000a == 15) {
                        jg m489a = jiVar.m489a();
                        this.f477a = new ArrayList(m489a.f782a);
                        for (int i = 0; i < m489a.f782a; i++) {
                            hx hxVar = new hx();
                            hxVar.a(jiVar);
                            this.f477a.add(hxVar);
                        }
                        jiVar.i();
                        break;
                    } else {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    }
                case 3:
                    if (m488a.f5000a == 8) {
                        this.f475a = hs.a(jiVar.m486a());
                        break;
                    } else {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    }
                default:
                    jl.a(jiVar, m488a.f5000a);
                    break;
            }
            jiVar.g();
        }
    }

    public void a(boolean z) {
        this.f476a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m363a() {
        return this.f476a.get(0);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m364a(hv hvVar) {
        if (hvVar != null && this.f474a == hvVar.f474a) {
            boolean b2 = b();
            boolean b3 = hvVar.b();
            if ((b2 || b3) && !(b2 && b3 && this.f477a.equals(hvVar.f477a))) {
                return false;
            }
            boolean c2 = c();
            boolean c3 = hvVar.c();
            return !(c2 || c3) || (c2 && c3 && this.f475a.equals(hvVar.f475a));
        }
        return false;
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        m362a();
        jiVar.a(f473a);
        jiVar.a(f4964a);
        jiVar.a(this.f474a);
        jiVar.b();
        if (this.f477a != null) {
            jiVar.a(b);
            jiVar.a(new jg((byte) 12, this.f477a.size()));
            for (hx hxVar : this.f477a) {
                hxVar.b(jiVar);
            }
            jiVar.e();
            jiVar.b();
        }
        if (this.f475a != null && c()) {
            jiVar.a(c);
            jiVar.a(this.f475a.a());
            jiVar.b();
        }
        jiVar.c();
        jiVar.m496a();
    }

    public boolean b() {
        return this.f477a != null;
    }

    public boolean c() {
        return this.f475a != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hv)) {
            return m364a((hv) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("NormalConfig(");
        sb.append("version:");
        sb.append(this.f474a);
        sb.append(", ");
        sb.append("configItems:");
        if (this.f477a == null) {
            sb.append("null");
        } else {
            sb.append(this.f477a);
        }
        if (c()) {
            sb.append(", ");
            sb.append("type:");
            if (this.f475a == null) {
                sb.append("null");
            } else {
                sb.append(this.f475a);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
