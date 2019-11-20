package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
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
            int compareTo = Boolean.valueOf(m394a()).compareTo(Boolean.valueOf(idVar.m394a()));
            if (compareTo == 0) {
                if (!m394a() || (a2 = is.a(this.f620a, idVar.f620a)) == 0) {
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
    public void m393a() {
        if (this.f620a == null) {
            throw new jd("Required field 'customConfigs' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ir
    public void a(jc jcVar) {
        jcVar.m455a();
        while (true) {
            iz m451a = jcVar.m451a();
            if (m451a.a == 0) {
                jcVar.f();
                m393a();
                return;
            }
            switch (m451a.f788a) {
                case 1:
                    if (m451a.a == 15) {
                        ja m452a = jcVar.m452a();
                        this.f620a = new ArrayList(m452a.f791a);
                        for (int i = 0; i < m452a.f791a; i++) {
                            hr hrVar = new hr();
                            hrVar.a(jcVar);
                            this.f620a.add(hrVar);
                        }
                        jcVar.i();
                        break;
                    } else {
                        jf.a(jcVar, m451a.a);
                        break;
                    }
                default:
                    jf.a(jcVar, m451a.a);
                    break;
            }
            jcVar.g();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m394a() {
        return this.f620a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m395a(id idVar) {
        if (idVar == null) {
            return false;
        }
        boolean m394a = m394a();
        boolean m394a2 = idVar.m394a();
        return !(m394a || m394a2) || (m394a && m394a2 && this.f620a.equals(idVar.f620a));
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        m393a();
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
        jcVar.m459a();
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof id)) {
            return m395a((id) obj);
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
