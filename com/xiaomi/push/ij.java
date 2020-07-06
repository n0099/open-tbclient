package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class ij implements ix<ij, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public List<hx> f614a;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f613a = new jn("XmPushActionCustomConfig");
    private static final jf a = new jf("", (byte) 15, 1);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(ij ijVar) {
        int a2;
        if (getClass().equals(ijVar.getClass())) {
            int compareTo = Boolean.valueOf(m422a()).compareTo(Boolean.valueOf(ijVar.m422a()));
            if (compareTo == 0) {
                if (!m422a() || (a2 = iy.a(this.f614a, ijVar.f614a)) == 0) {
                    return 0;
                }
                return a2;
            }
            return compareTo;
        }
        return getClass().getName().compareTo(ijVar.getClass().getName());
    }

    public List<hx> a() {
        return this.f614a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m421a() {
        if (this.f614a == null) {
            throw new jj("Required field 'customConfigs' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m483a();
        while (true) {
            jf m479a = jiVar.m479a();
            if (m479a.a == 0) {
                jiVar.f();
                m421a();
                return;
            }
            switch (m479a.f784a) {
                case 1:
                    if (m479a.a == 15) {
                        jg m480a = jiVar.m480a();
                        this.f614a = new ArrayList(m480a.f785a);
                        for (int i = 0; i < m480a.f785a; i++) {
                            hx hxVar = new hx();
                            hxVar.a(jiVar);
                            this.f614a.add(hxVar);
                        }
                        jiVar.i();
                        break;
                    } else {
                        jl.a(jiVar, m479a.a);
                        break;
                    }
                default:
                    jl.a(jiVar, m479a.a);
                    break;
            }
            jiVar.g();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m422a() {
        return this.f614a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m423a(ij ijVar) {
        if (ijVar == null) {
            return false;
        }
        boolean m422a = m422a();
        boolean m422a2 = ijVar.m422a();
        return !(m422a || m422a2) || (m422a && m422a2 && this.f614a.equals(ijVar.f614a));
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        m421a();
        jiVar.a(f613a);
        if (this.f614a != null) {
            jiVar.a(a);
            jiVar.a(new jg((byte) 12, this.f614a.size()));
            for (hx hxVar : this.f614a) {
                hxVar.b(jiVar);
            }
            jiVar.e();
            jiVar.b();
        }
        jiVar.c();
        jiVar.m487a();
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ij)) {
            return m423a((ij) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionCustomConfig(");
        sb.append("customConfigs:");
        if (this.f614a == null) {
            sb.append("null");
        } else {
            sb.append(this.f614a);
        }
        sb.append(")");
        return sb.toString();
    }
}
