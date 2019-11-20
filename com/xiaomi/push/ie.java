package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class ie implements ir<ie, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public List<hp> f622a;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f621a = new jh("XmPushActionNormalConfig");
    private static final iz a = new iz("", (byte) 15, 1);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(ie ieVar) {
        int a2;
        if (getClass().equals(ieVar.getClass())) {
            int compareTo = Boolean.valueOf(m397a()).compareTo(Boolean.valueOf(ieVar.m397a()));
            if (compareTo == 0) {
                if (!m397a() || (a2 = is.a(this.f622a, ieVar.f622a)) == 0) {
                    return 0;
                }
                return a2;
            }
            return compareTo;
        }
        return getClass().getName().compareTo(ieVar.getClass().getName());
    }

    public List<hp> a() {
        return this.f622a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m396a() {
        if (this.f622a == null) {
            throw new jd("Required field 'normalConfigs' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ir
    public void a(jc jcVar) {
        jcVar.m455a();
        while (true) {
            iz m451a = jcVar.m451a();
            if (m451a.a == 0) {
                jcVar.f();
                m396a();
                return;
            }
            switch (m451a.f788a) {
                case 1:
                    if (m451a.a == 15) {
                        ja m452a = jcVar.m452a();
                        this.f622a = new ArrayList(m452a.f791a);
                        for (int i = 0; i < m452a.f791a; i++) {
                            hp hpVar = new hp();
                            hpVar.a(jcVar);
                            this.f622a.add(hpVar);
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
    public boolean m397a() {
        return this.f622a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m398a(ie ieVar) {
        if (ieVar == null) {
            return false;
        }
        boolean m397a = m397a();
        boolean m397a2 = ieVar.m397a();
        return !(m397a || m397a2) || (m397a && m397a2 && this.f622a.equals(ieVar.f622a));
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        m396a();
        jcVar.a(f621a);
        if (this.f622a != null) {
            jcVar.a(a);
            jcVar.a(new ja((byte) 12, this.f622a.size()));
            for (hp hpVar : this.f622a) {
                hpVar.b(jcVar);
            }
            jcVar.e();
            jcVar.b();
        }
        jcVar.c();
        jcVar.m459a();
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ie)) {
            return m398a((ie) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionNormalConfig(");
        sb.append("normalConfigs:");
        if (this.f622a == null) {
            sb.append("null");
        } else {
            sb.append(this.f622a);
        }
        sb.append(")");
        return sb.toString();
    }
}
