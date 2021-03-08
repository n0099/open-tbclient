package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class ik implements ix<ik, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public List<hv> f610a;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f609a = new jn("XmPushActionNormalConfig");

    /* renamed from: a  reason: collision with root package name */
    private static final jf f8443a = new jf("", (byte) 15, 1);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(ik ikVar) {
        int a2;
        if (getClass().equals(ikVar.getClass())) {
            int compareTo = Boolean.valueOf(m435a()).compareTo(Boolean.valueOf(ikVar.m435a()));
            if (compareTo == 0) {
                if (!m435a() || (a2 = iy.a(this.f610a, ikVar.f610a)) == 0) {
                    return 0;
                }
                return a2;
            }
            return compareTo;
        }
        return getClass().getName().compareTo(ikVar.getClass().getName());
    }

    public List<hv> a() {
        return this.f610a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m434a() {
        if (this.f610a == null) {
            throw new jj("Required field 'normalConfigs' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m493a();
        while (true) {
            jf m489a = jiVar.m489a();
            if (m489a.f8463a == 0) {
                jiVar.f();
                m434a();
                return;
            }
            switch (m489a.f778a) {
                case 1:
                    if (m489a.f8463a == 15) {
                        jg m490a = jiVar.m490a();
                        this.f610a = new ArrayList(m490a.f779a);
                        for (int i = 0; i < m490a.f779a; i++) {
                            hv hvVar = new hv();
                            hvVar.a(jiVar);
                            this.f610a.add(hvVar);
                        }
                        jiVar.i();
                        break;
                    } else {
                        jl.a(jiVar, m489a.f8463a);
                        break;
                    }
                default:
                    jl.a(jiVar, m489a.f8463a);
                    break;
            }
            jiVar.g();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m435a() {
        return this.f610a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m436a(ik ikVar) {
        if (ikVar == null) {
            return false;
        }
        boolean m435a = m435a();
        boolean m435a2 = ikVar.m435a();
        return !(m435a || m435a2) || (m435a && m435a2 && this.f610a.equals(ikVar.f610a));
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        m434a();
        jiVar.a(f609a);
        if (this.f610a != null) {
            jiVar.a(f8443a);
            jiVar.a(new jg((byte) 12, this.f610a.size()));
            for (hv hvVar : this.f610a) {
                hvVar.b(jiVar);
            }
            jiVar.e();
            jiVar.b();
        }
        jiVar.c();
        jiVar.m497a();
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ik)) {
            return m436a((ik) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionNormalConfig(");
        sb.append("normalConfigs:");
        if (this.f610a == null) {
            sb.append("null");
        } else {
            sb.append(this.f610a);
        }
        sb.append(")");
        return sb.toString();
    }
}
