package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class ij implements ix<ij, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public List<hx> f687a;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f686a = new jn("XmPushActionCustomConfig");

    /* renamed from: a  reason: collision with root package name */
    private static final jf f14436a = new jf("", (byte) 15, 1);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(ij ijVar) {
        int a2;
        if (getClass().equals(ijVar.getClass())) {
            int compareTo = Boolean.valueOf(m447a()).compareTo(Boolean.valueOf(ijVar.m447a()));
            if (compareTo == 0) {
                if (!m447a() || (a2 = iy.a(this.f687a, ijVar.f687a)) == 0) {
                    return 0;
                }
                return a2;
            }
            return compareTo;
        }
        return getClass().getName().compareTo(ijVar.getClass().getName());
    }

    public List<hx> a() {
        return this.f687a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m446a() {
        if (this.f687a == null) {
            throw new jj("Required field 'customConfigs' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m508a();
        while (true) {
            jf m504a = jiVar.m504a();
            if (m504a.f14470a == 0) {
                jiVar.f();
                m446a();
                return;
            }
            switch (m504a.f857a) {
                case 1:
                    if (m504a.f14470a == 15) {
                        jg m505a = jiVar.m505a();
                        this.f687a = new ArrayList(m505a.f858a);
                        for (int i = 0; i < m505a.f858a; i++) {
                            hx hxVar = new hx();
                            hxVar.a(jiVar);
                            this.f687a.add(hxVar);
                        }
                        jiVar.i();
                        break;
                    } else {
                        jl.a(jiVar, m504a.f14470a);
                        break;
                    }
                default:
                    jl.a(jiVar, m504a.f14470a);
                    break;
            }
            jiVar.g();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m447a() {
        return this.f687a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m448a(ij ijVar) {
        if (ijVar == null) {
            return false;
        }
        boolean m447a = m447a();
        boolean m447a2 = ijVar.m447a();
        return !(m447a || m447a2) || (m447a && m447a2 && this.f687a.equals(ijVar.f687a));
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        m446a();
        jiVar.a(f686a);
        if (this.f687a != null) {
            jiVar.a(f14436a);
            jiVar.a(new jg((byte) 12, this.f687a.size()));
            for (hx hxVar : this.f687a) {
                hxVar.b(jiVar);
            }
            jiVar.e();
            jiVar.b();
        }
        jiVar.c();
        jiVar.m512a();
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ij)) {
            return m448a((ij) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionCustomConfig(");
        sb.append("customConfigs:");
        if (this.f687a == null) {
            sb.append("null");
        } else {
            sb.append(this.f687a);
        }
        sb.append(")");
        return sb.toString();
    }
}
