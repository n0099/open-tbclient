package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class ik implements ix<ik, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public List<hv> f609a;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f608a = new jn("XmPushActionNormalConfig");
    private static final jf a = new jf("", (byte) 15, 1);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(ik ikVar) {
        int a2;
        if (getClass().equals(ikVar.getClass())) {
            int compareTo = Boolean.valueOf(m427a()).compareTo(Boolean.valueOf(ikVar.m427a()));
            if (compareTo == 0) {
                if (!m427a() || (a2 = iy.a(this.f609a, ikVar.f609a)) == 0) {
                    return 0;
                }
                return a2;
            }
            return compareTo;
        }
        return getClass().getName().compareTo(ikVar.getClass().getName());
    }

    public List<hv> a() {
        return this.f609a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m426a() {
        if (this.f609a == null) {
            throw new jj("Required field 'normalConfigs' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m485a();
        while (true) {
            jf m481a = jiVar.m481a();
            if (m481a.a == 0) {
                jiVar.f();
                m426a();
                return;
            }
            switch (m481a.f777a) {
                case 1:
                    if (m481a.a == 15) {
                        jg m482a = jiVar.m482a();
                        this.f609a = new ArrayList(m482a.f778a);
                        for (int i = 0; i < m482a.f778a; i++) {
                            hv hvVar = new hv();
                            hvVar.a(jiVar);
                            this.f609a.add(hvVar);
                        }
                        jiVar.i();
                        break;
                    } else {
                        jl.a(jiVar, m481a.a);
                        break;
                    }
                default:
                    jl.a(jiVar, m481a.a);
                    break;
            }
            jiVar.g();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m427a() {
        return this.f609a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m428a(ik ikVar) {
        if (ikVar == null) {
            return false;
        }
        boolean m427a = m427a();
        boolean m427a2 = ikVar.m427a();
        return !(m427a || m427a2) || (m427a && m427a2 && this.f609a.equals(ikVar.f609a));
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        m426a();
        jiVar.a(f608a);
        if (this.f609a != null) {
            jiVar.a(a);
            jiVar.a(new jg((byte) 12, this.f609a.size()));
            for (hv hvVar : this.f609a) {
                hvVar.b(jiVar);
            }
            jiVar.e();
            jiVar.b();
        }
        jiVar.c();
        jiVar.m489a();
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ik)) {
            return m428a((ik) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionNormalConfig(");
        sb.append("normalConfigs:");
        if (this.f609a == null) {
            sb.append("null");
        } else {
            sb.append(this.f609a);
        }
        sb.append(")");
        return sb.toString();
    }
}
