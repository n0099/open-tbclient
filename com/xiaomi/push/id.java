package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class id implements ir<id, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public List<hr> f621a;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f620a = new jh("XmPushActionCustomConfig");
    private static final iz a = new iz("", (byte) 15, 1);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(id idVar) {
        int a2;
        if (getClass().equals(idVar.getClass())) {
            int compareTo = Boolean.valueOf(m414a()).compareTo(Boolean.valueOf(idVar.m414a()));
            if (compareTo == 0) {
                if (!m414a() || (a2 = is.a(this.f621a, idVar.f621a)) == 0) {
                    return 0;
                }
                return a2;
            }
            return compareTo;
        }
        return getClass().getName().compareTo(idVar.getClass().getName());
    }

    public List<hr> a() {
        return this.f621a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m413a() {
        if (this.f621a == null) {
            throw new jd("Required field 'customConfigs' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ir
    public void a(jc jcVar) {
        jcVar.m475a();
        while (true) {
            iz m471a = jcVar.m471a();
            if (m471a.a == 0) {
                jcVar.f();
                m413a();
                return;
            }
            switch (m471a.f789a) {
                case 1:
                    if (m471a.a == 15) {
                        ja m472a = jcVar.m472a();
                        this.f621a = new ArrayList(m472a.f792a);
                        for (int i = 0; i < m472a.f792a; i++) {
                            hr hrVar = new hr();
                            hrVar.a(jcVar);
                            this.f621a.add(hrVar);
                        }
                        jcVar.i();
                        break;
                    } else {
                        jf.a(jcVar, m471a.a);
                        break;
                    }
                default:
                    jf.a(jcVar, m471a.a);
                    break;
            }
            jcVar.g();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m414a() {
        return this.f621a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m415a(id idVar) {
        if (idVar == null) {
            return false;
        }
        boolean m414a = m414a();
        boolean m414a2 = idVar.m414a();
        return !(m414a || m414a2) || (m414a && m414a2 && this.f621a.equals(idVar.f621a));
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        m413a();
        jcVar.a(f620a);
        if (this.f621a != null) {
            jcVar.a(a);
            jcVar.a(new ja((byte) 12, this.f621a.size()));
            for (hr hrVar : this.f621a) {
                hrVar.b(jcVar);
            }
            jcVar.e();
            jcVar.b();
        }
        jcVar.c();
        jcVar.m479a();
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof id)) {
            return m415a((id) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionCustomConfig(");
        sb.append("customConfigs:");
        if (this.f621a == null) {
            sb.append("null");
        } else {
            sb.append(this.f621a);
        }
        sb.append(")");
        return sb.toString();
    }
}
