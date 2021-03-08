package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class hp implements ix<hp, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public List<hq> f445a;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f444a = new jn("ClientUploadData");

    /* renamed from: a  reason: collision with root package name */
    private static final jf f8421a = new jf("", (byte) 15, 1);

    public int a() {
        if (this.f445a == null) {
            return 0;
        }
        return this.f445a.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(hp hpVar) {
        int a2;
        if (getClass().equals(hpVar.getClass())) {
            int compareTo = Boolean.valueOf(m348a()).compareTo(Boolean.valueOf(hpVar.m348a()));
            if (compareTo == 0) {
                if (!m348a() || (a2 = iy.a(this.f445a, hpVar.f445a)) == 0) {
                    return 0;
                }
                return a2;
            }
            return compareTo;
        }
        return getClass().getName().compareTo(hpVar.getClass().getName());
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m347a() {
        if (this.f445a == null) {
            throw new jj("Required field 'uploadDataItems' was not present! Struct: " + toString());
        }
    }

    public void a(hq hqVar) {
        if (this.f445a == null) {
            this.f445a = new ArrayList();
        }
        this.f445a.add(hqVar);
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m493a();
        while (true) {
            jf m489a = jiVar.m489a();
            if (m489a.f8463a == 0) {
                jiVar.f();
                m347a();
                return;
            }
            switch (m489a.f778a) {
                case 1:
                    if (m489a.f8463a == 15) {
                        jg m490a = jiVar.m490a();
                        this.f445a = new ArrayList(m490a.f779a);
                        for (int i = 0; i < m490a.f779a; i++) {
                            hq hqVar = new hq();
                            hqVar.a(jiVar);
                            this.f445a.add(hqVar);
                        }
                        jiVar.i();
                        break;
                    } else {
                        jl.a(jiVar, m489a.f8463a);
                        break;
                    }
                default:
                    jl.a(jiVar, m489a.f8463a);
                    break;
            }
            jiVar.g();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m348a() {
        return this.f445a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m349a(hp hpVar) {
        if (hpVar == null) {
            return false;
        }
        boolean m348a = m348a();
        boolean m348a2 = hpVar.m348a();
        return !(m348a || m348a2) || (m348a && m348a2 && this.f445a.equals(hpVar.f445a));
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        m347a();
        jiVar.a(f444a);
        if (this.f445a != null) {
            jiVar.a(f8421a);
            jiVar.a(new jg((byte) 12, this.f445a.size()));
            for (hq hqVar : this.f445a) {
                hqVar.b(jiVar);
            }
            jiVar.e();
            jiVar.b();
        }
        jiVar.c();
        jiVar.m497a();
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hp)) {
            return m349a((hp) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ClientUploadData(");
        sb.append("uploadDataItems:");
        if (this.f445a == null) {
            sb.append("null");
        } else {
            sb.append(this.f445a);
        }
        sb.append(")");
        return sb.toString();
    }
}
