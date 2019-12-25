package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class hz implements ir<hz, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public List<ho> f588a;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f587a = new jh("XmPushActionCollectData");
    private static final iz a = new iz("", (byte) 15, 1);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(hz hzVar) {
        int a2;
        if (getClass().equals(hzVar.getClass())) {
            int compareTo = Boolean.valueOf(m373a()).compareTo(Boolean.valueOf(hzVar.m373a()));
            if (compareTo == 0) {
                if (!m373a() || (a2 = is.a(this.f588a, hzVar.f588a)) == 0) {
                    return 0;
                }
                return a2;
            }
            return compareTo;
        }
        return getClass().getName().compareTo(hzVar.getClass().getName());
    }

    public hz a(List<ho> list) {
        this.f588a = list;
        return this;
    }

    public void a() {
        if (this.f588a == null) {
            throw new jd("Required field 'dataCollectionItems' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ir
    public void a(jc jcVar) {
        jcVar.m458a();
        while (true) {
            iz m454a = jcVar.m454a();
            if (m454a.a == 0) {
                jcVar.f();
                a();
                return;
            }
            switch (m454a.f793a) {
                case 1:
                    if (m454a.a == 15) {
                        ja m455a = jcVar.m455a();
                        this.f588a = new ArrayList(m455a.f796a);
                        for (int i = 0; i < m455a.f796a; i++) {
                            ho hoVar = new ho();
                            hoVar.a(jcVar);
                            this.f588a.add(hoVar);
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
    public boolean m373a() {
        return this.f588a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m374a(hz hzVar) {
        if (hzVar == null) {
            return false;
        }
        boolean m373a = m373a();
        boolean m373a2 = hzVar.m373a();
        return !(m373a || m373a2) || (m373a && m373a2 && this.f588a.equals(hzVar.f588a));
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        a();
        jcVar.a(f587a);
        if (this.f588a != null) {
            jcVar.a(a);
            jcVar.a(new ja((byte) 12, this.f588a.size()));
            for (ho hoVar : this.f588a) {
                hoVar.b(jcVar);
            }
            jcVar.e();
            jcVar.b();
        }
        jcVar.c();
        jcVar.m462a();
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hz)) {
            return m374a((hz) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionCollectData(");
        sb.append("dataCollectionItems:");
        if (this.f588a == null) {
            sb.append("null");
        } else {
            sb.append(this.f588a);
        }
        sb.append(")");
        return sb.toString();
    }
}
