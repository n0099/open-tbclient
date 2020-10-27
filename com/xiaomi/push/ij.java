package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes12.dex */
public class ij implements ix<ij, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public List<hx> f606a;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f605a = new jn("XmPushActionCustomConfig");

    /* renamed from: a  reason: collision with root package name */
    private static final jf f4977a = new jf("", (byte) 15, 1);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(ij ijVar) {
        int a2;
        if (getClass().equals(ijVar.getClass())) {
            int compareTo = Boolean.valueOf(m428a()).compareTo(Boolean.valueOf(ijVar.m428a()));
            if (compareTo == 0) {
                if (!m428a() || (a2 = iy.a(this.f606a, ijVar.f606a)) == 0) {
                    return 0;
                }
                return a2;
            }
            return compareTo;
        }
        return getClass().getName().compareTo(ijVar.getClass().getName());
    }

    public List<hx> a() {
        return this.f606a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m427a() {
        if (this.f606a == null) {
            throw new jj("Required field 'customConfigs' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m489a();
        while (true) {
            jf m485a = jiVar.m485a();
            if (m485a.f4998a == 0) {
                jiVar.f();
                m427a();
                return;
            }
            switch (m485a.f776a) {
                case 1:
                    if (m485a.f4998a == 15) {
                        jg m486a = jiVar.m486a();
                        this.f606a = new ArrayList(m486a.f777a);
                        for (int i = 0; i < m486a.f777a; i++) {
                            hx hxVar = new hx();
                            hxVar.a(jiVar);
                            this.f606a.add(hxVar);
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
    public boolean m428a() {
        return this.f606a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m429a(ij ijVar) {
        if (ijVar == null) {
            return false;
        }
        boolean m428a = m428a();
        boolean m428a2 = ijVar.m428a();
        return !(m428a || m428a2) || (m428a && m428a2 && this.f606a.equals(ijVar.f606a));
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        m427a();
        jiVar.a(f605a);
        if (this.f606a != null) {
            jiVar.a(f4977a);
            jiVar.a(new jg((byte) 12, this.f606a.size()));
            for (hx hxVar : this.f606a) {
                hxVar.b(jiVar);
            }
            jiVar.e();
            jiVar.b();
        }
        jiVar.c();
        jiVar.m493a();
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ij)) {
            return m429a((ij) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionCustomConfig(");
        sb.append("customConfigs:");
        if (this.f606a == null) {
            sb.append("null");
        } else {
            sb.append(this.f606a);
        }
        sb.append(")");
        return sb.toString();
    }
}
