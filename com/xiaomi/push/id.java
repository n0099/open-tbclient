package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class id implements ir<id, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public List<hr> f624a;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f623a = new jh("XmPushActionCustomConfig");
    private static final iz a = new iz("", (byte) 15, 1);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(id idVar) {
        int a2;
        if (getClass().equals(idVar.getClass())) {
            int compareTo = Boolean.valueOf(m406a()).compareTo(Boolean.valueOf(idVar.m406a()));
            if (compareTo == 0) {
                if (!m406a() || (a2 = is.a(this.f624a, idVar.f624a)) == 0) {
                    return 0;
                }
                return a2;
            }
            return compareTo;
        }
        return getClass().getName().compareTo(idVar.getClass().getName());
    }

    public List<hr> a() {
        return this.f624a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m405a() {
        if (this.f624a == null) {
            throw new jd("Required field 'customConfigs' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ir
    public void a(jc jcVar) {
        jcVar.m467a();
        while (true) {
            iz m463a = jcVar.m463a();
            if (m463a.a == 0) {
                jcVar.f();
                m405a();
                return;
            }
            switch (m463a.f792a) {
                case 1:
                    if (m463a.a == 15) {
                        ja m464a = jcVar.m464a();
                        this.f624a = new ArrayList(m464a.f795a);
                        for (int i = 0; i < m464a.f795a; i++) {
                            hr hrVar = new hr();
                            hrVar.a(jcVar);
                            this.f624a.add(hrVar);
                        }
                        jcVar.i();
                        break;
                    } else {
                        jf.a(jcVar, m463a.a);
                        break;
                    }
                default:
                    jf.a(jcVar, m463a.a);
                    break;
            }
            jcVar.g();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m406a() {
        return this.f624a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m407a(id idVar) {
        if (idVar == null) {
            return false;
        }
        boolean m406a = m406a();
        boolean m406a2 = idVar.m406a();
        return !(m406a || m406a2) || (m406a && m406a2 && this.f624a.equals(idVar.f624a));
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        m405a();
        jcVar.a(f623a);
        if (this.f624a != null) {
            jcVar.a(a);
            jcVar.a(new ja((byte) 12, this.f624a.size()));
            for (hr hrVar : this.f624a) {
                hrVar.b(jcVar);
            }
            jcVar.e();
            jcVar.b();
        }
        jcVar.c();
        jcVar.m471a();
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof id)) {
            return m407a((id) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionCustomConfig(");
        sb.append("customConfigs:");
        if (this.f624a == null) {
            sb.append("null");
        } else {
            sb.append(this.f624a);
        }
        sb.append(")");
        return sb.toString();
    }
}
