package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes12.dex */
public class fj implements ix<fj, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public String f333a;

    /* renamed from: a  reason: collision with other field name */
    public List<fi> f334a;

    /* renamed from: b  reason: collision with other field name */
    public String f335b;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f332a = new jn("StatsEvents");

    /* renamed from: a  reason: collision with root package name */
    private static final jf f4902a = new jf("", Constants.GZIP_CAST_TYPE, 1);
    private static final jf b = new jf("", Constants.GZIP_CAST_TYPE, 2);
    private static final jf c = new jf("", (byte) 15, 3);

    public fj() {
    }

    public fj(String str, List<fi> list) {
        this();
        this.f333a = str;
        this.f334a = list;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(fj fjVar) {
        int a2;
        int a3;
        int a4;
        if (getClass().equals(fjVar.getClass())) {
            int compareTo = Boolean.valueOf(m278a()).compareTo(Boolean.valueOf(fjVar.m278a()));
            if (compareTo == 0) {
                if (!m278a() || (a4 = iy.a(this.f333a, fjVar.f333a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(fjVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a3 = iy.a(this.f335b, fjVar.f335b)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(fjVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a2 = iy.a(this.f334a, fjVar.f334a)) == 0) {
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
        this.f335b = str;
        return this;
    }

    public void a() {
        if (this.f333a == null) {
            throw new jj("Required field 'uuid' was not present! Struct: " + toString());
        }
        if (this.f334a == null) {
            throw new jj("Required field 'events' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m489a();
        while (true) {
            jf m485a = jiVar.m485a();
            if (m485a.f4998a == 0) {
                jiVar.f();
                a();
                return;
            }
            switch (m485a.f776a) {
                case 1:
                    if (m485a.f4998a == 11) {
                        this.f333a = jiVar.m490a();
                        break;
                    } else {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    }
                case 2:
                    if (m485a.f4998a == 11) {
                        this.f335b = jiVar.m490a();
                        break;
                    } else {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    }
                case 3:
                    if (m485a.f4998a == 15) {
                        jg m486a = jiVar.m486a();
                        this.f334a = new ArrayList(m486a.f777a);
                        for (int i = 0; i < m486a.f777a; i++) {
                            fi fiVar = new fi();
                            fiVar.a(jiVar);
                            this.f334a.add(fiVar);
                        }
                        jiVar.i();
                        break;
                    } else {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    }
                default:
                    jl.a(jiVar, m485a.f4998a);
                    break;
            }
            jiVar.g();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m278a() {
        return this.f333a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m279a(fj fjVar) {
        if (fjVar == null) {
            return false;
        }
        boolean m278a = m278a();
        boolean m278a2 = fjVar.m278a();
        if ((m278a || m278a2) && !(m278a && m278a2 && this.f333a.equals(fjVar.f333a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = fjVar.b();
        if ((b2 || b3) && !(b2 && b3 && this.f335b.equals(fjVar.f335b))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = fjVar.c();
        return !(c2 || c3) || (c2 && c3 && this.f334a.equals(fjVar.f334a));
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        a();
        jiVar.a(f332a);
        if (this.f333a != null) {
            jiVar.a(f4902a);
            jiVar.a(this.f333a);
            jiVar.b();
        }
        if (this.f335b != null && b()) {
            jiVar.a(b);
            jiVar.a(this.f335b);
            jiVar.b();
        }
        if (this.f334a != null) {
            jiVar.a(c);
            jiVar.a(new jg((byte) 12, this.f334a.size()));
            for (fi fiVar : this.f334a) {
                fiVar.b(jiVar);
            }
            jiVar.e();
            jiVar.b();
        }
        jiVar.c();
        jiVar.m493a();
    }

    public boolean b() {
        return this.f335b != null;
    }

    public boolean c() {
        return this.f334a != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof fj)) {
            return m279a((fj) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("StatsEvents(");
        sb.append("uuid:");
        if (this.f333a == null) {
            sb.append("null");
        } else {
            sb.append(this.f333a);
        }
        if (b()) {
            sb.append(", ");
            sb.append("operator:");
            if (this.f335b == null) {
                sb.append("null");
            } else {
                sb.append(this.f335b);
            }
        }
        sb.append(", ");
        sb.append("events:");
        if (this.f334a == null) {
            sb.append("null");
        } else {
            sb.append(this.f334a);
        }
        sb.append(")");
        return sb.toString();
    }
}
