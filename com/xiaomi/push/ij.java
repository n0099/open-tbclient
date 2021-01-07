package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class ij implements ix<ij, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public List<hx> f688a;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f687a = new jn("XmPushActionCustomConfig");

    /* renamed from: a  reason: collision with root package name */
    private static final jf f14437a = new jf("", (byte) 15, 1);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(ij ijVar) {
        int a2;
        if (getClass().equals(ijVar.getClass())) {
            int compareTo = Boolean.valueOf(m458a()).compareTo(Boolean.valueOf(ijVar.m458a()));
            if (compareTo == 0) {
                if (!m458a() || (a2 = iy.a(this.f688a, ijVar.f688a)) == 0) {
                    return 0;
                }
                return a2;
            }
            return compareTo;
        }
        return getClass().getName().compareTo(ijVar.getClass().getName());
    }

    public List<hx> a() {
        return this.f688a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m457a() {
        if (this.f688a == null) {
            throw new jj("Required field 'customConfigs' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m519a();
        while (true) {
            jf m515a = jiVar.m515a();
            if (m515a.f14471a == 0) {
                jiVar.f();
                m457a();
                return;
            }
            switch (m515a.f858a) {
                case 1:
                    if (m515a.f14471a == 15) {
                        jg m516a = jiVar.m516a();
                        this.f688a = new ArrayList(m516a.f859a);
                        for (int i = 0; i < m516a.f859a; i++) {
                            hx hxVar = new hx();
                            hxVar.a(jiVar);
                            this.f688a.add(hxVar);
                        }
                        jiVar.i();
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

    /* renamed from: a  reason: collision with other method in class */
    public boolean m458a() {
        return this.f688a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m459a(ij ijVar) {
        if (ijVar == null) {
            return false;
        }
        boolean m458a = m458a();
        boolean m458a2 = ijVar.m458a();
        return !(m458a || m458a2) || (m458a && m458a2 && this.f688a.equals(ijVar.f688a));
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        m457a();
        jiVar.a(f687a);
        if (this.f688a != null) {
            jiVar.a(f14437a);
            jiVar.a(new jg((byte) 12, this.f688a.size()));
            for (hx hxVar : this.f688a) {
                hxVar.b(jiVar);
            }
            jiVar.e();
            jiVar.b();
        }
        jiVar.c();
        jiVar.m523a();
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ij)) {
            return m459a((ij) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionCustomConfig(");
        sb.append("customConfigs:");
        if (this.f688a == null) {
            sb.append("null");
        } else {
            sb.append(this.f688a);
        }
        sb.append(")");
        return sb.toString();
    }
}
