package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class id implements ir<id, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public List<hr> f620a;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f619a = new jh("XmPushActionCustomConfig");
    private static final iz a = new iz("", (byte) 15, 1);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(id idVar) {
        int a2;
        if (getClass().equals(idVar.getClass())) {
            int compareTo = Boolean.valueOf(m411a()).compareTo(Boolean.valueOf(idVar.m411a()));
            if (compareTo == 0) {
                if (!m411a() || (a2 = is.a(this.f620a, idVar.f620a)) == 0) {
                    return 0;
                }
                return a2;
            }
            return compareTo;
        }
        return getClass().getName().compareTo(idVar.getClass().getName());
    }

    public List<hr> a() {
        return this.f620a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m410a() {
        if (this.f620a == null) {
            throw new jd("Required field 'customConfigs' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ir
    public void a(jc jcVar) {
        jcVar.m472a();
        while (true) {
            iz m468a = jcVar.m468a();
            if (m468a.a == 0) {
                jcVar.f();
                m410a();
                return;
            }
            switch (m468a.f788a) {
                case 1:
                    if (m468a.a == 15) {
                        ja m469a = jcVar.m469a();
                        this.f620a = new ArrayList(m469a.f791a);
                        for (int i = 0; i < m469a.f791a; i++) {
                            hr hrVar = new hr();
                            hrVar.a(jcVar);
                            this.f620a.add(hrVar);
                        }
                        jcVar.i();
                        break;
                    } else {
                        jf.a(jcVar, m468a.a);
                        break;
                    }
                default:
                    jf.a(jcVar, m468a.a);
                    break;
            }
            jcVar.g();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m411a() {
        return this.f620a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m412a(id idVar) {
        if (idVar == null) {
            return false;
        }
        boolean m411a = m411a();
        boolean m411a2 = idVar.m411a();
        return !(m411a || m411a2) || (m411a && m411a2 && this.f620a.equals(idVar.f620a));
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        m410a();
        jcVar.a(f619a);
        if (this.f620a != null) {
            jcVar.a(a);
            jcVar.a(new ja((byte) 12, this.f620a.size()));
            for (hr hrVar : this.f620a) {
                hrVar.b(jcVar);
            }
            jcVar.e();
            jcVar.b();
        }
        jcVar.c();
        jcVar.m476a();
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof id)) {
            return m412a((id) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionCustomConfig(");
        sb.append("customConfigs:");
        if (this.f620a == null) {
            sb.append("null");
        } else {
            sb.append(this.f620a);
        }
        sb.append(")");
        return sb.toString();
    }
}
