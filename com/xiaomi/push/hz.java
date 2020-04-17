package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class hz implements ir<hz, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public List<ho> f584a;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f583a = new jh("XmPushActionCollectData");
    private static final iz a = new iz("", (byte) 15, 1);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(hz hzVar) {
        int a2;
        if (getClass().equals(hzVar.getClass())) {
            int compareTo = Boolean.valueOf(m390a()).compareTo(Boolean.valueOf(hzVar.m390a()));
            if (compareTo == 0) {
                if (!m390a() || (a2 = is.a(this.f584a, hzVar.f584a)) == 0) {
                    return 0;
                }
                return a2;
            }
            return compareTo;
        }
        return getClass().getName().compareTo(hzVar.getClass().getName());
    }

    public hz a(List<ho> list) {
        this.f584a = list;
        return this;
    }

    public void a() {
        if (this.f584a == null) {
            throw new jd("Required field 'dataCollectionItems' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ir
    public void a(jc jcVar) {
        jcVar.m475a();
        while (true) {
            iz m471a = jcVar.m471a();
            if (m471a.a == 0) {
                jcVar.f();
                a();
                return;
            }
            switch (m471a.f789a) {
                case 1:
                    if (m471a.a == 15) {
                        ja m472a = jcVar.m472a();
                        this.f584a = new ArrayList(m472a.f792a);
                        for (int i = 0; i < m472a.f792a; i++) {
                            ho hoVar = new ho();
                            hoVar.a(jcVar);
                            this.f584a.add(hoVar);
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
    public boolean m390a() {
        return this.f584a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m391a(hz hzVar) {
        if (hzVar == null) {
            return false;
        }
        boolean m390a = m390a();
        boolean m390a2 = hzVar.m390a();
        return !(m390a || m390a2) || (m390a && m390a2 && this.f584a.equals(hzVar.f584a));
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        a();
        jcVar.a(f583a);
        if (this.f584a != null) {
            jcVar.a(a);
            jcVar.a(new ja((byte) 12, this.f584a.size()));
            for (ho hoVar : this.f584a) {
                hoVar.b(jcVar);
            }
            jcVar.e();
            jcVar.b();
        }
        jcVar.c();
        jcVar.m479a();
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hz)) {
            return m391a((hz) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionCollectData(");
        sb.append("dataCollectionItems:");
        if (this.f584a == null) {
            sb.append("null");
        } else {
            sb.append(this.f584a);
        }
        sb.append(")");
        return sb.toString();
    }
}
