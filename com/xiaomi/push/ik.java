package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes12.dex */
public class ik implements ix<ik, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public List<hv> f608a;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f607a = new jn("XmPushActionNormalConfig");

    /* renamed from: a  reason: collision with root package name */
    private static final jf f4978a = new jf("", (byte) 15, 1);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(ik ikVar) {
        int a2;
        if (getClass().equals(ikVar.getClass())) {
            int compareTo = Boolean.valueOf(m431a()).compareTo(Boolean.valueOf(ikVar.m431a()));
            if (compareTo == 0) {
                if (!m431a() || (a2 = iy.a(this.f608a, ikVar.f608a)) == 0) {
                    return 0;
                }
                return a2;
            }
            return compareTo;
        }
        return getClass().getName().compareTo(ikVar.getClass().getName());
    }

    public List<hv> a() {
        return this.f608a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m430a() {
        if (this.f608a == null) {
            throw new jj("Required field 'normalConfigs' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m489a();
        while (true) {
            jf m485a = jiVar.m485a();
            if (m485a.f4998a == 0) {
                jiVar.f();
                m430a();
                return;
            }
            switch (m485a.f776a) {
                case 1:
                    if (m485a.f4998a == 15) {
                        jg m486a = jiVar.m486a();
                        this.f608a = new ArrayList(m486a.f777a);
                        for (int i = 0; i < m486a.f777a; i++) {
                            hv hvVar = new hv();
                            hvVar.a(jiVar);
                            this.f608a.add(hvVar);
                        }
                        jiVar.i();
                        break;
                    } else {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    }
                default:
                    jl.a(jiVar, m485a.f4998a);
                    break;
            }
            jiVar.g();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m431a() {
        return this.f608a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m432a(ik ikVar) {
        if (ikVar == null) {
            return false;
        }
        boolean m431a = m431a();
        boolean m431a2 = ikVar.m431a();
        return !(m431a || m431a2) || (m431a && m431a2 && this.f608a.equals(ikVar.f608a));
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        m430a();
        jiVar.a(f607a);
        if (this.f608a != null) {
            jiVar.a(f4978a);
            jiVar.a(new jg((byte) 12, this.f608a.size()));
            for (hv hvVar : this.f608a) {
                hvVar.b(jiVar);
            }
            jiVar.e();
            jiVar.b();
        }
        jiVar.c();
        jiVar.m493a();
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ik)) {
            return m432a((ik) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionNormalConfig(");
        sb.append("normalConfigs:");
        if (this.f608a == null) {
            sb.append("null");
        } else {
            sb.append(this.f608a);
        }
        sb.append(")");
        return sb.toString();
    }
}
