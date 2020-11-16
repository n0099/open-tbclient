package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes18.dex */
public class ij implements ix<ij, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public List<hx> f611a;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f610a = new jn("XmPushActionCustomConfig");

    /* renamed from: a  reason: collision with root package name */
    private static final jf f4979a = new jf("", (byte) 15, 1);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(ij ijVar) {
        int a2;
        if (getClass().equals(ijVar.getClass())) {
            int compareTo = Boolean.valueOf(m431a()).compareTo(Boolean.valueOf(ijVar.m431a()));
            if (compareTo == 0) {
                if (!m431a() || (a2 = iy.a(this.f611a, ijVar.f611a)) == 0) {
                    return 0;
                }
                return a2;
            }
            return compareTo;
        }
        return getClass().getName().compareTo(ijVar.getClass().getName());
    }

    public List<hx> a() {
        return this.f611a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m430a() {
        if (this.f611a == null) {
            throw new jj("Required field 'customConfigs' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m492a();
        while (true) {
            jf m488a = jiVar.m488a();
            if (m488a.f5000a == 0) {
                jiVar.f();
                m430a();
                return;
            }
            switch (m488a.f781a) {
                case 1:
                    if (m488a.f5000a == 15) {
                        jg m489a = jiVar.m489a();
                        this.f611a = new ArrayList(m489a.f782a);
                        for (int i = 0; i < m489a.f782a; i++) {
                            hx hxVar = new hx();
                            hxVar.a(jiVar);
                            this.f611a.add(hxVar);
                        }
                        jiVar.i();
                        break;
                    } else {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    }
                default:
                    jl.a(jiVar, m488a.f5000a);
                    break;
            }
            jiVar.g();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m431a() {
        return this.f611a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m432a(ij ijVar) {
        if (ijVar == null) {
            return false;
        }
        boolean m431a = m431a();
        boolean m431a2 = ijVar.m431a();
        return !(m431a || m431a2) || (m431a && m431a2 && this.f611a.equals(ijVar.f611a));
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        m430a();
        jiVar.a(f610a);
        if (this.f611a != null) {
            jiVar.a(f4979a);
            jiVar.a(new jg((byte) 12, this.f611a.size()));
            for (hx hxVar : this.f611a) {
                hxVar.b(jiVar);
            }
            jiVar.e();
            jiVar.b();
        }
        jiVar.c();
        jiVar.m496a();
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ij)) {
            return m432a((ij) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionCustomConfig(");
        sb.append("customConfigs:");
        if (this.f611a == null) {
            sb.append("null");
        } else {
            sb.append(this.f611a);
        }
        sb.append(")");
        return sb.toString();
    }
}
