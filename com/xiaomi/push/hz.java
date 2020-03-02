package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class hz implements ir<hz, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public List<ho> f583a;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f582a = new jh("XmPushActionCollectData");
    private static final iz a = new iz("", (byte) 15, 1);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(hz hzVar) {
        int a2;
        if (getClass().equals(hzVar.getClass())) {
            int compareTo = Boolean.valueOf(m387a()).compareTo(Boolean.valueOf(hzVar.m387a()));
            if (compareTo == 0) {
                if (!m387a() || (a2 = is.a(this.f583a, hzVar.f583a)) == 0) {
                    return 0;
                }
                return a2;
            }
            return compareTo;
        }
        return getClass().getName().compareTo(hzVar.getClass().getName());
    }

    public hz a(List<ho> list) {
        this.f583a = list;
        return this;
    }

    public void a() {
        if (this.f583a == null) {
            throw new jd("Required field 'dataCollectionItems' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ir
    public void a(jc jcVar) {
        jcVar.m472a();
        while (true) {
            iz m468a = jcVar.m468a();
            if (m468a.a == 0) {
                jcVar.f();
                a();
                return;
            }
            switch (m468a.f788a) {
                case 1:
                    if (m468a.a == 15) {
                        ja m469a = jcVar.m469a();
                        this.f583a = new ArrayList(m469a.f791a);
                        for (int i = 0; i < m469a.f791a; i++) {
                            ho hoVar = new ho();
                            hoVar.a(jcVar);
                            this.f583a.add(hoVar);
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
    public boolean m387a() {
        return this.f583a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m388a(hz hzVar) {
        if (hzVar == null) {
            return false;
        }
        boolean m387a = m387a();
        boolean m387a2 = hzVar.m387a();
        return !(m387a || m387a2) || (m387a && m387a2 && this.f583a.equals(hzVar.f583a));
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        a();
        jcVar.a(f582a);
        if (this.f583a != null) {
            jcVar.a(a);
            jcVar.a(new ja((byte) 12, this.f583a.size()));
            for (ho hoVar : this.f583a) {
                hoVar.b(jcVar);
            }
            jcVar.e();
            jcVar.b();
        }
        jcVar.c();
        jcVar.m476a();
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hz)) {
            return m388a((hz) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionCollectData(");
        sb.append("dataCollectionItems:");
        if (this.f583a == null) {
            sb.append("null");
        } else {
            sb.append(this.f583a);
        }
        sb.append(")");
        return sb.toString();
    }
}
