package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes12.dex */
public class ij implements ix<ij, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public List<hx> f609a;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f608a = new jn("XmPushActionCustomConfig");

    /* renamed from: a  reason: collision with root package name */
    private static final jf f4979a = new jf("", (byte) 15, 1);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(ij ijVar) {
        int a2;
        if (getClass().equals(ijVar.getClass())) {
            int compareTo = Boolean.valueOf(m429a()).compareTo(Boolean.valueOf(ijVar.m429a()));
            if (compareTo == 0) {
                if (!m429a() || (a2 = iy.a(this.f609a, ijVar.f609a)) == 0) {
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
    public void m428a() {
        if (this.f609a == null) {
            throw new jj("Required field 'customConfigs' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m490a();
        while (true) {
            jf m486a = jiVar.m486a();
            if (m486a.f5000a == 0) {
                jiVar.f();
                m428a();
                return;
            }
            switch (m486a.f779a) {
                case 1:
                    if (m486a.f5000a == 15) {
                        jg m487a = jiVar.m487a();
                        this.f609a = new ArrayList(m487a.f780a);
                        for (int i = 0; i < m487a.f780a; i++) {
                            hx hxVar = new hx();
                            hxVar.a(jiVar);
                            this.f609a.add(hxVar);
                        }
                        jiVar.i();
                        break;
                    } else {
                        jl.a(jiVar, m486a.f5000a);
                        break;
                    }
                default:
                    jl.a(jiVar, m486a.f5000a);
                    break;
            }
            jiVar.g();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m429a() {
        return this.f609a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m430a(ij ijVar) {
        if (ijVar == null) {
            return false;
        }
        boolean m429a = m429a();
        boolean m429a2 = ijVar.m429a();
        return !(m429a || m429a2) || (m429a && m429a2 && this.f609a.equals(ijVar.f609a));
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        m428a();
        jiVar.a(f608a);
        if (this.f609a != null) {
            jiVar.a(f4979a);
            jiVar.a(new jg((byte) 12, this.f609a.size()));
            for (hx hxVar : this.f609a) {
                hxVar.b(jiVar);
            }
            jiVar.e();
            jiVar.b();
        }
        jiVar.c();
        jiVar.m494a();
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ij)) {
            return m430a((ij) obj);
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
