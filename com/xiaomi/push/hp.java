package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes18.dex */
public class hp implements ix<hp, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public List<hq> f448a;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f447a = new jn("ClientUploadData");

    /* renamed from: a  reason: collision with root package name */
    private static final jf f4958a = new jf("", (byte) 15, 1);

    public int a() {
        if (this.f448a == null) {
            return 0;
        }
        return this.f448a.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(hp hpVar) {
        int a2;
        if (getClass().equals(hpVar.getClass())) {
            int compareTo = Boolean.valueOf(m347a()).compareTo(Boolean.valueOf(hpVar.m347a()));
            if (compareTo == 0) {
                if (!m347a() || (a2 = iy.a(this.f448a, hpVar.f448a)) == 0) {
                    return 0;
                }
                return a2;
            }
            return compareTo;
        }
        return getClass().getName().compareTo(hpVar.getClass().getName());
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m346a() {
        if (this.f448a == null) {
            throw new jj("Required field 'uploadDataItems' was not present! Struct: " + toString());
        }
    }

    public void a(hq hqVar) {
        if (this.f448a == null) {
            this.f448a = new ArrayList();
        }
        this.f448a.add(hqVar);
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m492a();
        while (true) {
            jf m488a = jiVar.m488a();
            if (m488a.f5000a == 0) {
                jiVar.f();
                m346a();
                return;
            }
            switch (m488a.f781a) {
                case 1:
                    if (m488a.f5000a == 15) {
                        jg m489a = jiVar.m489a();
                        this.f448a = new ArrayList(m489a.f782a);
                        for (int i = 0; i < m489a.f782a; i++) {
                            hq hqVar = new hq();
                            hqVar.a(jiVar);
                            this.f448a.add(hqVar);
                        }
                        jiVar.i();
                        break;
                    } else {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    }
                default:
                    jl.a(jiVar, m488a.f5000a);
                    break;
            }
            jiVar.g();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m347a() {
        return this.f448a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m348a(hp hpVar) {
        if (hpVar == null) {
            return false;
        }
        boolean m347a = m347a();
        boolean m347a2 = hpVar.m347a();
        return !(m347a || m347a2) || (m347a && m347a2 && this.f448a.equals(hpVar.f448a));
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        m346a();
        jiVar.a(f447a);
        if (this.f448a != null) {
            jiVar.a(f4958a);
            jiVar.a(new jg((byte) 12, this.f448a.size()));
            for (hq hqVar : this.f448a) {
                hqVar.b(jiVar);
            }
            jiVar.e();
            jiVar.b();
        }
        jiVar.c();
        jiVar.m496a();
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hp)) {
            return m348a((hp) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ClientUploadData(");
        sb.append("uploadDataItems:");
        if (this.f448a == null) {
            sb.append("null");
        } else {
            sb.append(this.f448a);
        }
        sb.append(")");
        return sb.toString();
    }
}
