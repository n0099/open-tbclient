package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
/* loaded from: classes6.dex */
public class hv implements ix<hv, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public int f551a;

    /* renamed from: a  reason: collision with other field name */
    public hs f552a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f553a = new BitSet(1);

    /* renamed from: a  reason: collision with other field name */
    public List<hx> f554a;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f550a = new jn("NormalConfig");

    /* renamed from: a  reason: collision with root package name */
    private static final jf f14408a = new jf("", (byte) 8, 1);

    /* renamed from: b  reason: collision with root package name */
    private static final jf f14409b = new jf("", (byte) 15, 2);
    private static final jf c = new jf("", (byte) 8, 3);

    public int a() {
        return this.f551a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(hv hvVar) {
        int a2;
        int a3;
        int a4;
        if (getClass().equals(hvVar.getClass())) {
            int compareTo = Boolean.valueOf(m390a()).compareTo(Boolean.valueOf(hvVar.m390a()));
            if (compareTo == 0) {
                if (!m390a() || (a4 = iy.a(this.f551a, hvVar.f551a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(hvVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a3 = iy.a(this.f554a, hvVar.f554a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(hvVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a2 = iy.a(this.f552a, hvVar.f552a)) == 0) {
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
    public hs m388a() {
        return this.f552a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m389a() {
        if (this.f554a == null) {
            throw new jj("Required field 'configItems' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m519a();
        while (true) {
            jf m515a = jiVar.m515a();
            if (m515a.f14471a == 0) {
                jiVar.f();
                if (!m390a()) {
                    throw new jj("Required field 'version' was not found in serialized data! Struct: " + toString());
                }
                m389a();
                return;
            }
            switch (m515a.f858a) {
                case 1:
                    if (m515a.f14471a == 8) {
                        this.f551a = jiVar.m513a();
                        a(true);
                        break;
                    } else {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    }
                case 2:
                    if (m515a.f14471a == 15) {
                        jg m516a = jiVar.m516a();
                        this.f554a = new ArrayList(m516a.f859a);
                        for (int i = 0; i < m516a.f859a; i++) {
                            hx hxVar = new hx();
                            hxVar.a(jiVar);
                            this.f554a.add(hxVar);
                        }
                        jiVar.i();
                        break;
                    } else {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    }
                case 3:
                    if (m515a.f14471a == 8) {
                        this.f552a = hs.a(jiVar.m513a());
                        break;
                    } else {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    }
                default:
                    jl.a(jiVar, m515a.f14471a);
                    break;
            }
            jiVar.g();
        }
    }

    public void a(boolean z) {
        this.f553a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m390a() {
        return this.f553a.get(0);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m391a(hv hvVar) {
        if (hvVar != null && this.f551a == hvVar.f551a) {
            boolean b2 = b();
            boolean b3 = hvVar.b();
            if ((b2 || b3) && !(b2 && b3 && this.f554a.equals(hvVar.f554a))) {
                return false;
            }
            boolean c2 = c();
            boolean c3 = hvVar.c();
            return !(c2 || c3) || (c2 && c3 && this.f552a.equals(hvVar.f552a));
        }
        return false;
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        m389a();
        jiVar.a(f550a);
        jiVar.a(f14408a);
        jiVar.a(this.f551a);
        jiVar.b();
        if (this.f554a != null) {
            jiVar.a(f14409b);
            jiVar.a(new jg((byte) 12, this.f554a.size()));
            for (hx hxVar : this.f554a) {
                hxVar.b(jiVar);
            }
            jiVar.e();
            jiVar.b();
        }
        if (this.f552a != null && c()) {
            jiVar.a(c);
            jiVar.a(this.f552a.a());
            jiVar.b();
        }
        jiVar.c();
        jiVar.m523a();
    }

    public boolean b() {
        return this.f554a != null;
    }

    public boolean c() {
        return this.f552a != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hv)) {
            return m391a((hv) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("NormalConfig(");
        sb.append("version:");
        sb.append(this.f551a);
        sb.append(", ");
        sb.append("configItems:");
        if (this.f554a == null) {
            sb.append("null");
        } else {
            sb.append(this.f554a);
        }
        if (c()) {
            sb.append(", ");
            sb.append("type:");
            if (this.f552a == null) {
                sb.append("null");
            } else {
                sb.append(this.f552a);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
