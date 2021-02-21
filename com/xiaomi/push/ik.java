package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class ik implements ix<ik, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public List<hv> f689a;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f688a = new jn("XmPushActionNormalConfig");

    /* renamed from: a  reason: collision with root package name */
    private static final jf f14140a = new jf("", (byte) 15, 1);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(ik ikVar) {
        int a2;
        if (getClass().equals(ikVar.getClass())) {
            int compareTo = Boolean.valueOf(m456a()).compareTo(Boolean.valueOf(ikVar.m456a()));
            if (compareTo == 0) {
                if (!m456a() || (a2 = iy.a(this.f689a, ikVar.f689a)) == 0) {
                    return 0;
                }
                return a2;
            }
            return compareTo;
        }
        return getClass().getName().compareTo(ikVar.getClass().getName());
    }

    public List<hv> a() {
        return this.f689a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m455a() {
        if (this.f689a == null) {
            throw new jj("Required field 'normalConfigs' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m514a();
        while (true) {
            jf m510a = jiVar.m510a();
            if (m510a.f14173a == 0) {
                jiVar.f();
                m455a();
                return;
            }
            switch (m510a.f857a) {
                case 1:
                    if (m510a.f14173a == 15) {
                        jg m511a = jiVar.m511a();
                        this.f689a = new ArrayList(m511a.f858a);
                        for (int i = 0; i < m511a.f858a; i++) {
                            hv hvVar = new hv();
                            hvVar.a(jiVar);
                            this.f689a.add(hvVar);
                        }
                        jiVar.i();
                        break;
                    } else {
                        jl.a(jiVar, m510a.f14173a);
                        break;
                    }
                default:
                    jl.a(jiVar, m510a.f14173a);
                    break;
            }
            jiVar.g();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m456a() {
        return this.f689a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m457a(ik ikVar) {
        if (ikVar == null) {
            return false;
        }
        boolean m456a = m456a();
        boolean m456a2 = ikVar.m456a();
        return !(m456a || m456a2) || (m456a && m456a2 && this.f689a.equals(ikVar.f689a));
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        m455a();
        jiVar.a(f688a);
        if (this.f689a != null) {
            jiVar.a(f14140a);
            jiVar.a(new jg((byte) 12, this.f689a.size()));
            for (hv hvVar : this.f689a) {
                hvVar.b(jiVar);
            }
            jiVar.e();
            jiVar.b();
        }
        jiVar.c();
        jiVar.m518a();
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ik)) {
            return m457a((ik) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionNormalConfig(");
        sb.append("normalConfigs:");
        if (this.f689a == null) {
            sb.append("null");
        } else {
            sb.append(this.f689a);
        }
        sb.append(")");
        return sb.toString();
    }
}
