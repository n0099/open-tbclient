package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes12.dex */
public class hp implements ix<hp, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public List<hq> f446a;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f445a = new jn("ClientUploadData");

    /* renamed from: a  reason: collision with root package name */
    private static final jf f4958a = new jf("", (byte) 15, 1);

    public int a() {
        if (this.f446a == null) {
            return 0;
        }
        return this.f446a.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(hp hpVar) {
        int a2;
        if (getClass().equals(hpVar.getClass())) {
            int compareTo = Boolean.valueOf(m345a()).compareTo(Boolean.valueOf(hpVar.m345a()));
            if (compareTo == 0) {
                if (!m345a() || (a2 = iy.a(this.f446a, hpVar.f446a)) == 0) {
                    return 0;
                }
                return a2;
            }
            return compareTo;
        }
        return getClass().getName().compareTo(hpVar.getClass().getName());
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m344a() {
        if (this.f446a == null) {
            throw new jj("Required field 'uploadDataItems' was not present! Struct: " + toString());
        }
    }

    public void a(hq hqVar) {
        if (this.f446a == null) {
            this.f446a = new ArrayList();
        }
        this.f446a.add(hqVar);
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m490a();
        while (true) {
            jf m486a = jiVar.m486a();
            if (m486a.f5000a == 0) {
                jiVar.f();
                m344a();
                return;
            }
            switch (m486a.f779a) {
                case 1:
                    if (m486a.f5000a == 15) {
                        jg m487a = jiVar.m487a();
                        this.f446a = new ArrayList(m487a.f780a);
                        for (int i = 0; i < m487a.f780a; i++) {
                            hq hqVar = new hq();
                            hqVar.a(jiVar);
                            this.f446a.add(hqVar);
                        }
                        jiVar.i();
                        break;
                    } else {
                        jl.a(jiVar, m486a.f5000a);
                        break;
                    }
                default:
                    jl.a(jiVar, m486a.f5000a);
                    break;
            }
            jiVar.g();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m345a() {
        return this.f446a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m346a(hp hpVar) {
        if (hpVar == null) {
            return false;
        }
        boolean m345a = m345a();
        boolean m345a2 = hpVar.m345a();
        return !(m345a || m345a2) || (m345a && m345a2 && this.f446a.equals(hpVar.f446a));
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        m344a();
        jiVar.a(f445a);
        if (this.f446a != null) {
            jiVar.a(f4958a);
            jiVar.a(new jg((byte) 12, this.f446a.size()));
            for (hq hqVar : this.f446a) {
                hqVar.b(jiVar);
            }
            jiVar.e();
            jiVar.b();
        }
        jiVar.c();
        jiVar.m494a();
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hp)) {
            return m346a((hp) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ClientUploadData(");
        sb.append("uploadDataItems:");
        if (this.f446a == null) {
            sb.append("null");
        } else {
            sb.append(this.f446a);
        }
        sb.append(")");
        return sb.toString();
    }
}
