package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class ij implements ix<ij, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public List<hx> f610a;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f609a = new jn("XmPushActionCustomConfig");
    private static final jf a = new jf("", (byte) 15, 1);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(ij ijVar) {
        int a2;
        if (getClass().equals(ijVar.getClass())) {
            int compareTo = Boolean.valueOf(m423a()).compareTo(Boolean.valueOf(ijVar.m423a()));
            if (compareTo == 0) {
                if (!m423a() || (a2 = iy.a(this.f610a, ijVar.f610a)) == 0) {
                    return 0;
                }
                return a2;
            }
            return compareTo;
        }
        return getClass().getName().compareTo(ijVar.getClass().getName());
    }

    public List<hx> a() {
        return this.f610a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m422a() {
        if (this.f610a == null) {
            throw new jj("Required field 'customConfigs' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m484a();
        while (true) {
            jf m480a = jiVar.m480a();
            if (m480a.a == 0) {
                jiVar.f();
                m422a();
                return;
            }
            switch (m480a.f780a) {
                case 1:
                    if (m480a.a == 15) {
                        jg m481a = jiVar.m481a();
                        this.f610a = new ArrayList(m481a.f781a);
                        for (int i = 0; i < m481a.f781a; i++) {
                            hx hxVar = new hx();
                            hxVar.a(jiVar);
                            this.f610a.add(hxVar);
                        }
                        jiVar.i();
                        break;
                    } else {
                        jl.a(jiVar, m480a.a);
                        break;
                    }
                default:
                    jl.a(jiVar, m480a.a);
                    break;
            }
            jiVar.g();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m423a() {
        return this.f610a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m424a(ij ijVar) {
        if (ijVar == null) {
            return false;
        }
        boolean m423a = m423a();
        boolean m423a2 = ijVar.m423a();
        return !(m423a || m423a2) || (m423a && m423a2 && this.f610a.equals(ijVar.f610a));
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        m422a();
        jiVar.a(f609a);
        if (this.f610a != null) {
            jiVar.a(a);
            jiVar.a(new jg((byte) 12, this.f610a.size()));
            for (hx hxVar : this.f610a) {
                hxVar.b(jiVar);
            }
            jiVar.e();
            jiVar.b();
        }
        jiVar.c();
        jiVar.m488a();
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ij)) {
            return m424a((ij) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionCustomConfig(");
        sb.append("customConfigs:");
        if (this.f610a == null) {
            sb.append("null");
        } else {
            sb.append(this.f610a);
        }
        sb.append(")");
        return sb.toString();
    }
}
