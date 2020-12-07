package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes18.dex */
public class ik implements ix<ik, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public List<hv> f611a;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f610a = new jn("XmPushActionNormalConfig");

    /* renamed from: a  reason: collision with root package name */
    private static final jf f4750a = new jf("", (byte) 15, 1);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(ik ikVar) {
        int a2;
        if (getClass().equals(ikVar.getClass())) {
            int compareTo = Boolean.valueOf(m424a()).compareTo(Boolean.valueOf(ikVar.m424a()));
            if (compareTo == 0) {
                if (!m424a() || (a2 = iy.a(this.f611a, ikVar.f611a)) == 0) {
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
    public void m423a() {
        if (this.f611a == null) {
            throw new jj("Required field 'normalConfigs' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m482a();
        while (true) {
            jf m478a = jiVar.m478a();
            if (m478a.f4770a == 0) {
                jiVar.f();
                m423a();
                return;
            }
            switch (m478a.f779a) {
                case 1:
                    if (m478a.f4770a == 15) {
                        jg m479a = jiVar.m479a();
                        this.f611a = new ArrayList(m479a.f780a);
                        for (int i = 0; i < m479a.f780a; i++) {
                            hv hvVar = new hv();
                            hvVar.a(jiVar);
                            this.f611a.add(hvVar);
                        }
                        jiVar.i();
                        break;
                    } else {
                        jl.a(jiVar, m478a.f4770a);
                        break;
                    }
                default:
                    jl.a(jiVar, m478a.f4770a);
                    break;
            }
            jiVar.g();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m424a() {
        return this.f611a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m425a(ik ikVar) {
        if (ikVar == null) {
            return false;
        }
        boolean m424a = m424a();
        boolean m424a2 = ikVar.m424a();
        return !(m424a || m424a2) || (m424a && m424a2 && this.f611a.equals(ikVar.f611a));
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        m423a();
        jiVar.a(f610a);
        if (this.f611a != null) {
            jiVar.a(f4750a);
            jiVar.a(new jg((byte) 12, this.f611a.size()));
            for (hv hvVar : this.f611a) {
                hvVar.b(jiVar);
            }
            jiVar.e();
            jiVar.b();
        }
        jiVar.c();
        jiVar.m486a();
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ik)) {
            return m425a((ik) obj);
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
