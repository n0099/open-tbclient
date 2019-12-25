package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class id implements ir<id, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public List<hr> f625a;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f624a = new jh("XmPushActionCustomConfig");
    private static final iz a = new iz("", (byte) 15, 1);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(id idVar) {
        int a2;
        if (getClass().equals(idVar.getClass())) {
            int compareTo = Boolean.valueOf(m397a()).compareTo(Boolean.valueOf(idVar.m397a()));
            if (compareTo == 0) {
                if (!m397a() || (a2 = is.a(this.f625a, idVar.f625a)) == 0) {
                    return 0;
                }
                return a2;
            }
            return compareTo;
        }
        return getClass().getName().compareTo(idVar.getClass().getName());
    }

    public List<hr> a() {
        return this.f625a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m396a() {
        if (this.f625a == null) {
            throw new jd("Required field 'customConfigs' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ir
    public void a(jc jcVar) {
        jcVar.m458a();
        while (true) {
            iz m454a = jcVar.m454a();
            if (m454a.a == 0) {
                jcVar.f();
                m396a();
                return;
            }
            switch (m454a.f793a) {
                case 1:
                    if (m454a.a == 15) {
                        ja m455a = jcVar.m455a();
                        this.f625a = new ArrayList(m455a.f796a);
                        for (int i = 0; i < m455a.f796a; i++) {
                            hr hrVar = new hr();
                            hrVar.a(jcVar);
                            this.f625a.add(hrVar);
                        }
                        jcVar.i();
                        break;
                    } else {
                        jf.a(jcVar, m454a.a);
                        break;
                    }
                default:
                    jf.a(jcVar, m454a.a);
                    break;
            }
            jcVar.g();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m397a() {
        return this.f625a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m398a(id idVar) {
        if (idVar == null) {
            return false;
        }
        boolean m397a = m397a();
        boolean m397a2 = idVar.m397a();
        return !(m397a || m397a2) || (m397a && m397a2 && this.f625a.equals(idVar.f625a));
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        m396a();
        jcVar.a(f624a);
        if (this.f625a != null) {
            jcVar.a(a);
            jcVar.a(new ja((byte) 12, this.f625a.size()));
            for (hr hrVar : this.f625a) {
                hrVar.b(jcVar);
            }
            jcVar.e();
            jcVar.b();
        }
        jcVar.c();
        jcVar.m462a();
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof id)) {
            return m398a((id) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionCustomConfig(");
        sb.append("customConfigs:");
        if (this.f625a == null) {
            sb.append("null");
        } else {
            sb.append(this.f625a);
        }
        sb.append(")");
        return sb.toString();
    }
}
