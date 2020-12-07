package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes18.dex */
public class ij implements ix<ij, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public List<hx> f609a;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f608a = new jn("XmPushActionCustomConfig");

    /* renamed from: a  reason: collision with root package name */
    private static final jf f4749a = new jf("", (byte) 15, 1);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(ij ijVar) {
        int a2;
        if (getClass().equals(ijVar.getClass())) {
            int compareTo = Boolean.valueOf(m421a()).compareTo(Boolean.valueOf(ijVar.m421a()));
            if (compareTo == 0) {
                if (!m421a() || (a2 = iy.a(this.f609a, ijVar.f609a)) == 0) {
                    return 0;
                }
                return a2;
            }
            return compareTo;
        }
        return getClass().getName().compareTo(ijVar.getClass().getName());
    }

    public List<hx> a() {
        return this.f609a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m420a() {
        if (this.f609a == null) {
            throw new jj("Required field 'customConfigs' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m482a();
        while (true) {
            jf m478a = jiVar.m478a();
            if (m478a.f4770a == 0) {
                jiVar.f();
                m420a();
                return;
            }
            switch (m478a.f779a) {
                case 1:
                    if (m478a.f4770a == 15) {
                        jg m479a = jiVar.m479a();
                        this.f609a = new ArrayList(m479a.f780a);
                        for (int i = 0; i < m479a.f780a; i++) {
                            hx hxVar = new hx();
                            hxVar.a(jiVar);
                            this.f609a.add(hxVar);
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
    public boolean m421a() {
        return this.f609a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m422a(ij ijVar) {
        if (ijVar == null) {
            return false;
        }
        boolean m421a = m421a();
        boolean m421a2 = ijVar.m421a();
        return !(m421a || m421a2) || (m421a && m421a2 && this.f609a.equals(ijVar.f609a));
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        m420a();
        jiVar.a(f608a);
        if (this.f609a != null) {
            jiVar.a(f4749a);
            jiVar.a(new jg((byte) 12, this.f609a.size()));
            for (hx hxVar : this.f609a) {
                hxVar.b(jiVar);
            }
            jiVar.e();
            jiVar.b();
        }
        jiVar.c();
        jiVar.m486a();
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ij)) {
            return m422a((ij) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionCustomConfig(");
        sb.append("customConfigs:");
        if (this.f609a == null) {
            sb.append("null");
        } else {
            sb.append(this.f609a);
        }
        sb.append(")");
        return sb.toString();
    }
}
