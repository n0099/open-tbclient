package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes18.dex */
public class ik implements ix<ik, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public List<hv> f613a;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f612a = new jn("XmPushActionNormalConfig");

    /* renamed from: a  reason: collision with root package name */
    private static final jf f4980a = new jf("", (byte) 15, 1);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(ik ikVar) {
        int a2;
        if (getClass().equals(ikVar.getClass())) {
            int compareTo = Boolean.valueOf(m434a()).compareTo(Boolean.valueOf(ikVar.m434a()));
            if (compareTo == 0) {
                if (!m434a() || (a2 = iy.a(this.f613a, ikVar.f613a)) == 0) {
                    return 0;
                }
                return a2;
            }
            return compareTo;
        }
        return getClass().getName().compareTo(ikVar.getClass().getName());
    }

    public List<hv> a() {
        return this.f613a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m433a() {
        if (this.f613a == null) {
            throw new jj("Required field 'normalConfigs' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m492a();
        while (true) {
            jf m488a = jiVar.m488a();
            if (m488a.f5000a == 0) {
                jiVar.f();
                m433a();
                return;
            }
            switch (m488a.f781a) {
                case 1:
                    if (m488a.f5000a == 15) {
                        jg m489a = jiVar.m489a();
                        this.f613a = new ArrayList(m489a.f782a);
                        for (int i = 0; i < m489a.f782a; i++) {
                            hv hvVar = new hv();
                            hvVar.a(jiVar);
                            this.f613a.add(hvVar);
                        }
                        jiVar.i();
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

    /* renamed from: a  reason: collision with other method in class */
    public boolean m434a() {
        return this.f613a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m435a(ik ikVar) {
        if (ikVar == null) {
            return false;
        }
        boolean m434a = m434a();
        boolean m434a2 = ikVar.m434a();
        return !(m434a || m434a2) || (m434a && m434a2 && this.f613a.equals(ikVar.f613a));
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        m433a();
        jiVar.a(f612a);
        if (this.f613a != null) {
            jiVar.a(f4980a);
            jiVar.a(new jg((byte) 12, this.f613a.size()));
            for (hv hvVar : this.f613a) {
                hvVar.b(jiVar);
            }
            jiVar.e();
            jiVar.b();
        }
        jiVar.c();
        jiVar.m496a();
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ik)) {
            return m435a((ik) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionNormalConfig(");
        sb.append("normalConfigs:");
        if (this.f613a == null) {
            sb.append("null");
        } else {
            sb.append(this.f613a);
        }
        sb.append(")");
        return sb.toString();
    }
}
