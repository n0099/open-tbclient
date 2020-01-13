package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class ie implements ir<ie, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public List<hp> f625a;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f624a = new jh("XmPushActionNormalConfig");
    private static final iz a = new iz("", (byte) 15, 1);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(ie ieVar) {
        int a2;
        if (getClass().equals(ieVar.getClass())) {
            int compareTo = Boolean.valueOf(m409a()).compareTo(Boolean.valueOf(ieVar.m409a()));
            if (compareTo == 0) {
                if (!m409a() || (a2 = is.a(this.f625a, ieVar.f625a)) == 0) {
                    return 0;
                }
                return a2;
            }
            return compareTo;
        }
        return getClass().getName().compareTo(ieVar.getClass().getName());
    }

    public List<hp> a() {
        return this.f625a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m408a() {
        if (this.f625a == null) {
            throw new jd("Required field 'normalConfigs' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ir
    public void a(jc jcVar) {
        jcVar.m467a();
        while (true) {
            iz m463a = jcVar.m463a();
            if (m463a.a == 0) {
                jcVar.f();
                m408a();
                return;
            }
            switch (m463a.f791a) {
                case 1:
                    if (m463a.a == 15) {
                        ja m464a = jcVar.m464a();
                        this.f625a = new ArrayList(m464a.f794a);
                        for (int i = 0; i < m464a.f794a; i++) {
                            hp hpVar = new hp();
                            hpVar.a(jcVar);
                            this.f625a.add(hpVar);
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
    public boolean m409a() {
        return this.f625a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m410a(ie ieVar) {
        if (ieVar == null) {
            return false;
        }
        boolean m409a = m409a();
        boolean m409a2 = ieVar.m409a();
        return !(m409a || m409a2) || (m409a && m409a2 && this.f625a.equals(ieVar.f625a));
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        m408a();
        jcVar.a(f624a);
        if (this.f625a != null) {
            jcVar.a(a);
            jcVar.a(new ja((byte) 12, this.f625a.size()));
            for (hp hpVar : this.f625a) {
                hpVar.b(jcVar);
            }
            jcVar.e();
            jcVar.b();
        }
        jcVar.c();
        jcVar.m471a();
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ie)) {
            return m410a((ie) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionNormalConfig(");
        sb.append("normalConfigs:");
        if (this.f625a == null) {
            sb.append("null");
        } else {
            sb.append(this.f625a);
        }
        sb.append(")");
        return sb.toString();
    }
}
