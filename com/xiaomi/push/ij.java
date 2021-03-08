package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class ij implements ix<ij, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public List<hx> f608a;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f607a = new jn("XmPushActionCustomConfig");

    /* renamed from: a  reason: collision with root package name */
    private static final jf f8442a = new jf("", (byte) 15, 1);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(ij ijVar) {
        int a2;
        if (getClass().equals(ijVar.getClass())) {
            int compareTo = Boolean.valueOf(m432a()).compareTo(Boolean.valueOf(ijVar.m432a()));
            if (compareTo == 0) {
                if (!m432a() || (a2 = iy.a(this.f608a, ijVar.f608a)) == 0) {
                    return 0;
                }
                return a2;
            }
            return compareTo;
        }
        return getClass().getName().compareTo(ijVar.getClass().getName());
    }

    public List<hx> a() {
        return this.f608a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m431a() {
        if (this.f608a == null) {
            throw new jj("Required field 'customConfigs' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m493a();
        while (true) {
            jf m489a = jiVar.m489a();
            if (m489a.f8463a == 0) {
                jiVar.f();
                m431a();
                return;
            }
            switch (m489a.f778a) {
                case 1:
                    if (m489a.f8463a == 15) {
                        jg m490a = jiVar.m490a();
                        this.f608a = new ArrayList(m490a.f779a);
                        for (int i = 0; i < m490a.f779a; i++) {
                            hx hxVar = new hx();
                            hxVar.a(jiVar);
                            this.f608a.add(hxVar);
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
    public boolean m432a() {
        return this.f608a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m433a(ij ijVar) {
        if (ijVar == null) {
            return false;
        }
        boolean m432a = m432a();
        boolean m432a2 = ijVar.m432a();
        return !(m432a || m432a2) || (m432a && m432a2 && this.f608a.equals(ijVar.f608a));
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        m431a();
        jiVar.a(f607a);
        if (this.f608a != null) {
            jiVar.a(f8442a);
            jiVar.a(new jg((byte) 12, this.f608a.size()));
            for (hx hxVar : this.f608a) {
                hxVar.b(jiVar);
            }
            jiVar.e();
            jiVar.b();
        }
        jiVar.c();
        jiVar.m497a();
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ij)) {
            return m433a((ij) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionCustomConfig(");
        sb.append("customConfigs:");
        if (this.f608a == null) {
            sb.append("null");
        } else {
            sb.append(this.f608a);
        }
        sb.append(")");
        return sb.toString();
    }
}
