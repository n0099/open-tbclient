package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class fj implements ix<fj, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public String f335a;

    /* renamed from: a  reason: collision with other field name */
    public List<fi> f336a;

    /* renamed from: b  reason: collision with other field name */
    public String f337b;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f334a = new jn("StatsEvents");

    /* renamed from: a  reason: collision with root package name */
    private static final jf f8367a = new jf("", Constants.GZIP_CAST_TYPE, 1);
    private static final jf b = new jf("", Constants.GZIP_CAST_TYPE, 2);
    private static final jf c = new jf("", (byte) 15, 3);

    public fj() {
    }

    public fj(String str, List<fi> list) {
        this();
        this.f335a = str;
        this.f336a = list;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(fj fjVar) {
        int a2;
        int a3;
        int a4;
        if (getClass().equals(fjVar.getClass())) {
            int compareTo = Boolean.valueOf(m282a()).compareTo(Boolean.valueOf(fjVar.m282a()));
            if (compareTo == 0) {
                if (!m282a() || (a4 = iy.a(this.f335a, fjVar.f335a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(fjVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a3 = iy.a(this.f337b, fjVar.f337b)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(fjVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a2 = iy.a(this.f336a, fjVar.f336a)) == 0) {
                                    return 0;
                                }
                                return a2;
                            }
                            return compareTo3;
                        }
                        return a3;
                    }
                    return compareTo2;
                }
                return a4;
            }
            return compareTo;
        }
        return getClass().getName().compareTo(fjVar.getClass().getName());
    }

    public fj a(String str) {
        this.f337b = str;
        return this;
    }

    public void a() {
        if (this.f335a == null) {
            throw new jj("Required field 'uuid' was not present! Struct: " + toString());
        }
        if (this.f336a == null) {
            throw new jj("Required field 'events' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m493a();
        while (true) {
            jf m489a = jiVar.m489a();
            if (m489a.f8463a == 0) {
                jiVar.f();
                a();
                return;
            }
            switch (m489a.f778a) {
                case 1:
                    if (m489a.f8463a == 11) {
                        this.f335a = jiVar.m494a();
                        break;
                    } else {
                        jl.a(jiVar, m489a.f8463a);
                        break;
                    }
                case 2:
                    if (m489a.f8463a == 11) {
                        this.f337b = jiVar.m494a();
                        break;
                    } else {
                        jl.a(jiVar, m489a.f8463a);
                        break;
                    }
                case 3:
                    if (m489a.f8463a == 15) {
                        jg m490a = jiVar.m490a();
                        this.f336a = new ArrayList(m490a.f779a);
                        for (int i = 0; i < m490a.f779a; i++) {
                            fi fiVar = new fi();
                            fiVar.a(jiVar);
                            this.f336a.add(fiVar);
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
    public boolean m282a() {
        return this.f335a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m283a(fj fjVar) {
        if (fjVar == null) {
            return false;
        }
        boolean m282a = m282a();
        boolean m282a2 = fjVar.m282a();
        if ((m282a || m282a2) && !(m282a && m282a2 && this.f335a.equals(fjVar.f335a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = fjVar.b();
        if ((b2 || b3) && !(b2 && b3 && this.f337b.equals(fjVar.f337b))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = fjVar.c();
        return !(c2 || c3) || (c2 && c3 && this.f336a.equals(fjVar.f336a));
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        a();
        jiVar.a(f334a);
        if (this.f335a != null) {
            jiVar.a(f8367a);
            jiVar.a(this.f335a);
            jiVar.b();
        }
        if (this.f337b != null && b()) {
            jiVar.a(b);
            jiVar.a(this.f337b);
            jiVar.b();
        }
        if (this.f336a != null) {
            jiVar.a(c);
            jiVar.a(new jg((byte) 12, this.f336a.size()));
            for (fi fiVar : this.f336a) {
                fiVar.b(jiVar);
            }
            jiVar.e();
            jiVar.b();
        }
        jiVar.c();
        jiVar.m497a();
    }

    public boolean b() {
        return this.f337b != null;
    }

    public boolean c() {
        return this.f336a != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof fj)) {
            return m283a((fj) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("StatsEvents(");
        sb.append("uuid:");
        if (this.f335a == null) {
            sb.append("null");
        } else {
            sb.append(this.f335a);
        }
        if (b()) {
            sb.append(", ");
            sb.append("operator:");
            if (this.f337b == null) {
                sb.append("null");
            } else {
                sb.append(this.f337b);
            }
        }
        sb.append(", ");
        sb.append("events:");
        if (this.f336a == null) {
            sb.append("null");
        } else {
            sb.append(this.f336a);
        }
        sb.append(")");
        return sb.toString();
    }
}
