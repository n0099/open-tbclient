package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class ik implements ix<ik, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public List<hv> f690a;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f689a = new jn("XmPushActionNormalConfig");

    /* renamed from: a  reason: collision with root package name */
    private static final jf f14438a = new jf("", (byte) 15, 1);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(ik ikVar) {
        int a2;
        if (getClass().equals(ikVar.getClass())) {
            int compareTo = Boolean.valueOf(m461a()).compareTo(Boolean.valueOf(ikVar.m461a()));
            if (compareTo == 0) {
                if (!m461a() || (a2 = iy.a(this.f690a, ikVar.f690a)) == 0) {
                    return 0;
                }
                return a2;
            }
            return compareTo;
        }
        return getClass().getName().compareTo(ikVar.getClass().getName());
    }

    public List<hv> a() {
        return this.f690a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m460a() {
        if (this.f690a == null) {
            throw new jj("Required field 'normalConfigs' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m519a();
        while (true) {
            jf m515a = jiVar.m515a();
            if (m515a.f14471a == 0) {
                jiVar.f();
                m460a();
                return;
            }
            switch (m515a.f858a) {
                case 1:
                    if (m515a.f14471a == 15) {
                        jg m516a = jiVar.m516a();
                        this.f690a = new ArrayList(m516a.f859a);
                        for (int i = 0; i < m516a.f859a; i++) {
                            hv hvVar = new hv();
                            hvVar.a(jiVar);
                            this.f690a.add(hvVar);
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
    public boolean m461a() {
        return this.f690a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m462a(ik ikVar) {
        if (ikVar == null) {
            return false;
        }
        boolean m461a = m461a();
        boolean m461a2 = ikVar.m461a();
        return !(m461a || m461a2) || (m461a && m461a2 && this.f690a.equals(ikVar.f690a));
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        m460a();
        jiVar.a(f689a);
        if (this.f690a != null) {
            jiVar.a(f14438a);
            jiVar.a(new jg((byte) 12, this.f690a.size()));
            for (hv hvVar : this.f690a) {
                hvVar.b(jiVar);
            }
            jiVar.e();
            jiVar.b();
        }
        jiVar.c();
        jiVar.m523a();
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ik)) {
            return m462a((ik) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionNormalConfig(");
        sb.append("normalConfigs:");
        if (this.f690a == null) {
            sb.append("null");
        } else {
            sb.append(this.f690a);
        }
        sb.append(")");
        return sb.toString();
    }
}
