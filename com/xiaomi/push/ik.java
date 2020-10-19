package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes12.dex */
public class ik implements ix<ik, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public List<hv> f611a;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f610a = new jn("XmPushActionNormalConfig");

    /* renamed from: a  reason: collision with root package name */
    private static final jf f4980a = new jf("", (byte) 15, 1);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(ik ikVar) {
        int a2;
        if (getClass().equals(ikVar.getClass())) {
            int compareTo = Boolean.valueOf(m432a()).compareTo(Boolean.valueOf(ikVar.m432a()));
            if (compareTo == 0) {
                if (!m432a() || (a2 = iy.a(this.f611a, ikVar.f611a)) == 0) {
                    return 0;
                }
                return a2;
            }
            return compareTo;
        }
        return getClass().getName().compareTo(ikVar.getClass().getName());
    }

    public List<hv> a() {
        return this.f611a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m431a() {
        if (this.f611a == null) {
            throw new jj("Required field 'normalConfigs' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m490a();
        while (true) {
            jf m486a = jiVar.m486a();
            if (m486a.f5000a == 0) {
                jiVar.f();
                m431a();
                return;
            }
            switch (m486a.f779a) {
                case 1:
                    if (m486a.f5000a == 15) {
                        jg m487a = jiVar.m487a();
                        this.f611a = new ArrayList(m487a.f780a);
                        for (int i = 0; i < m487a.f780a; i++) {
                            hv hvVar = new hv();
                            hvVar.a(jiVar);
                            this.f611a.add(hvVar);
                        }
                        jiVar.i();
                        break;
                    } else {
                        jl.a(jiVar, m486a.f5000a);
                        break;
                    }
                default:
                    jl.a(jiVar, m486a.f5000a);
                    break;
            }
            jiVar.g();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m432a() {
        return this.f611a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m433a(ik ikVar) {
        if (ikVar == null) {
            return false;
        }
        boolean m432a = m432a();
        boolean m432a2 = ikVar.m432a();
        return !(m432a || m432a2) || (m432a && m432a2 && this.f611a.equals(ikVar.f611a));
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        m431a();
        jiVar.a(f610a);
        if (this.f611a != null) {
            jiVar.a(f4980a);
            jiVar.a(new jg((byte) 12, this.f611a.size()));
            for (hv hvVar : this.f611a) {
                hvVar.b(jiVar);
            }
            jiVar.e();
            jiVar.b();
        }
        jiVar.c();
        jiVar.m494a();
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ik)) {
            return m433a((ik) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionNormalConfig(");
        sb.append("normalConfigs:");
        if (this.f611a == null) {
            sb.append("null");
        } else {
            sb.append(this.f611a);
        }
        sb.append(")");
        return sb.toString();
    }
}
