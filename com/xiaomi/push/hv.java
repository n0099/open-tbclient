package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
/* loaded from: classes8.dex */
public class hv implements ix<hv, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public int f470a;

    /* renamed from: a  reason: collision with other field name */
    public hs f471a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f472a = new BitSet(1);

    /* renamed from: a  reason: collision with other field name */
    public List<hx> f473a;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f469a = new jn("NormalConfig");
    private static final jf a = new jf("", (byte) 8, 1);
    private static final jf b = new jf("", (byte) 15, 2);
    private static final jf c = new jf("", (byte) 8, 3);

    public int a() {
        return this.f470a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(hv hvVar) {
        int a2;
        int a3;
        int a4;
        if (getClass().equals(hvVar.getClass())) {
            int compareTo = Boolean.valueOf(m357a()).compareTo(Boolean.valueOf(hvVar.m357a()));
            if (compareTo == 0) {
                if (!m357a() || (a4 = iy.a(this.f470a, hvVar.f470a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(hvVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a3 = iy.a(this.f473a, hvVar.f473a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(hvVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a2 = iy.a(this.f471a, hvVar.f471a)) == 0) {
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
    public hs m355a() {
        return this.f471a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m356a() {
        if (this.f473a == null) {
            throw new jj("Required field 'configItems' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m486a();
        while (true) {
            jf m482a = jiVar.m482a();
            if (m482a.a == 0) {
                jiVar.f();
                if (!m357a()) {
                    throw new jj("Required field 'version' was not found in serialized data! Struct: " + toString());
                }
                m356a();
                return;
            }
            switch (m482a.f777a) {
                case 1:
                    if (m482a.a == 8) {
                        this.f470a = jiVar.m480a();
                        a(true);
                        break;
                    } else {
                        jl.a(jiVar, m482a.a);
                        break;
                    }
                case 2:
                    if (m482a.a == 15) {
                        jg m483a = jiVar.m483a();
                        this.f473a = new ArrayList(m483a.f778a);
                        for (int i = 0; i < m483a.f778a; i++) {
                            hx hxVar = new hx();
                            hxVar.a(jiVar);
                            this.f473a.add(hxVar);
                        }
                        jiVar.i();
                        break;
                    } else {
                        jl.a(jiVar, m482a.a);
                        break;
                    }
                case 3:
                    if (m482a.a == 8) {
                        this.f471a = hs.a(jiVar.m480a());
                        break;
                    } else {
                        jl.a(jiVar, m482a.a);
                        break;
                    }
                default:
                    jl.a(jiVar, m482a.a);
                    break;
            }
            jiVar.g();
        }
    }

    public void a(boolean z) {
        this.f472a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m357a() {
        return this.f472a.get(0);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m358a(hv hvVar) {
        if (hvVar != null && this.f470a == hvVar.f470a) {
            boolean b2 = b();
            boolean b3 = hvVar.b();
            if ((b2 || b3) && !(b2 && b3 && this.f473a.equals(hvVar.f473a))) {
                return false;
            }
            boolean c2 = c();
            boolean c3 = hvVar.c();
            return !(c2 || c3) || (c2 && c3 && this.f471a.equals(hvVar.f471a));
        }
        return false;
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        m356a();
        jiVar.a(f469a);
        jiVar.a(a);
        jiVar.a(this.f470a);
        jiVar.b();
        if (this.f473a != null) {
            jiVar.a(b);
            jiVar.a(new jg((byte) 12, this.f473a.size()));
            for (hx hxVar : this.f473a) {
                hxVar.b(jiVar);
            }
            jiVar.e();
            jiVar.b();
        }
        if (this.f471a != null && c()) {
            jiVar.a(c);
            jiVar.a(this.f471a.a());
            jiVar.b();
        }
        jiVar.c();
        jiVar.m490a();
    }

    public boolean b() {
        return this.f473a != null;
    }

    public boolean c() {
        return this.f471a != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hv)) {
            return m358a((hv) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("NormalConfig(");
        sb.append("version:");
        sb.append(this.f470a);
        sb.append(", ");
        sb.append("configItems:");
        if (this.f473a == null) {
            sb.append("null");
        } else {
            sb.append(this.f473a);
        }
        if (c()) {
            sb.append(", ");
            sb.append("type:");
            if (this.f471a == null) {
                sb.append("null");
            } else {
                sb.append(this.f471a);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
