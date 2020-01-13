package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class hz implements ir<hz, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public List<ho> f586a;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f585a = new jh("XmPushActionCollectData");
    private static final iz a = new iz("", (byte) 15, 1);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(hz hzVar) {
        int a2;
        if (getClass().equals(hzVar.getClass())) {
            int compareTo = Boolean.valueOf(m382a()).compareTo(Boolean.valueOf(hzVar.m382a()));
            if (compareTo == 0) {
                if (!m382a() || (a2 = is.a(this.f586a, hzVar.f586a)) == 0) {
                    return 0;
                }
                return a2;
            }
            return compareTo;
        }
        return getClass().getName().compareTo(hzVar.getClass().getName());
    }

    public hz a(List<ho> list) {
        this.f586a = list;
        return this;
    }

    public void a() {
        if (this.f586a == null) {
            throw new jd("Required field 'dataCollectionItems' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ir
    public void a(jc jcVar) {
        jcVar.m467a();
        while (true) {
            iz m463a = jcVar.m463a();
            if (m463a.a == 0) {
                jcVar.f();
                a();
                return;
            }
            switch (m463a.f791a) {
                case 1:
                    if (m463a.a == 15) {
                        ja m464a = jcVar.m464a();
                        this.f586a = new ArrayList(m464a.f794a);
                        for (int i = 0; i < m464a.f794a; i++) {
                            ho hoVar = new ho();
                            hoVar.a(jcVar);
                            this.f586a.add(hoVar);
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
    public boolean m382a() {
        return this.f586a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m383a(hz hzVar) {
        if (hzVar == null) {
            return false;
        }
        boolean m382a = m382a();
        boolean m382a2 = hzVar.m382a();
        return !(m382a || m382a2) || (m382a && m382a2 && this.f586a.equals(hzVar.f586a));
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        a();
        jcVar.a(f585a);
        if (this.f586a != null) {
            jcVar.a(a);
            jcVar.a(new ja((byte) 12, this.f586a.size()));
            for (ho hoVar : this.f586a) {
                hoVar.b(jcVar);
            }
            jcVar.e();
            jcVar.b();
        }
        jcVar.c();
        jcVar.m471a();
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hz)) {
            return m383a((hz) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionCollectData(");
        sb.append("dataCollectionItems:");
        if (this.f586a == null) {
            sb.append("null");
        } else {
            sb.append(this.f586a);
        }
        sb.append(")");
        return sb.toString();
    }
}
