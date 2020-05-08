package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class ij implements ix<ij, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public List<hx> f607a;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f606a = new jn("XmPushActionCustomConfig");
    private static final jf a = new jf("", (byte) 15, 1);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(ij ijVar) {
        int a2;
        if (getClass().equals(ijVar.getClass())) {
            int compareTo = Boolean.valueOf(m424a()).compareTo(Boolean.valueOf(ijVar.m424a()));
            if (compareTo == 0) {
                if (!m424a() || (a2 = iy.a(this.f607a, ijVar.f607a)) == 0) {
                    return 0;
                }
                return a2;
            }
            return compareTo;
        }
        return getClass().getName().compareTo(ijVar.getClass().getName());
    }

    public List<hx> a() {
        return this.f607a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m423a() {
        if (this.f607a == null) {
            throw new jj("Required field 'customConfigs' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m485a();
        while (true) {
            jf m481a = jiVar.m481a();
            if (m481a.a == 0) {
                jiVar.f();
                m423a();
                return;
            }
            switch (m481a.f777a) {
                case 1:
                    if (m481a.a == 15) {
                        jg m482a = jiVar.m482a();
                        this.f607a = new ArrayList(m482a.f778a);
                        for (int i = 0; i < m482a.f778a; i++) {
                            hx hxVar = new hx();
                            hxVar.a(jiVar);
                            this.f607a.add(hxVar);
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
    public boolean m424a() {
        return this.f607a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m425a(ij ijVar) {
        if (ijVar == null) {
            return false;
        }
        boolean m424a = m424a();
        boolean m424a2 = ijVar.m424a();
        return !(m424a || m424a2) || (m424a && m424a2 && this.f607a.equals(ijVar.f607a));
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        m423a();
        jiVar.a(f606a);
        if (this.f607a != null) {
            jiVar.a(a);
            jiVar.a(new jg((byte) 12, this.f607a.size()));
            for (hx hxVar : this.f607a) {
                hxVar.b(jiVar);
            }
            jiVar.e();
            jiVar.b();
        }
        jiVar.c();
        jiVar.m489a();
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ij)) {
            return m425a((ij) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionCustomConfig(");
        sb.append("customConfigs:");
        if (this.f607a == null) {
            sb.append("null");
        } else {
            sb.append(this.f607a);
        }
        sb.append(")");
        return sb.toString();
    }
}
