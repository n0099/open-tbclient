package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class fj implements ix<fj, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public String f334a;

    /* renamed from: a  reason: collision with other field name */
    public List<fi> f335a;

    /* renamed from: b  reason: collision with other field name */
    public String f336b;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f333a = new jn("StatsEvents");
    private static final jf a = new jf("", Constants.GZIP_CAST_TYPE, 1);
    private static final jf b = new jf("", Constants.GZIP_CAST_TYPE, 2);
    private static final jf c = new jf("", (byte) 15, 3);

    public fj() {
    }

    public fj(String str, List<fi> list) {
        this();
        this.f334a = str;
        this.f335a = list;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(fj fjVar) {
        int a2;
        int a3;
        int a4;
        if (getClass().equals(fjVar.getClass())) {
            int compareTo = Boolean.valueOf(m274a()).compareTo(Boolean.valueOf(fjVar.m274a()));
            if (compareTo == 0) {
                if (!m274a() || (a4 = iy.a(this.f334a, fjVar.f334a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(fjVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a3 = iy.a(this.f336b, fjVar.f336b)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(fjVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a2 = iy.a(this.f335a, fjVar.f335a)) == 0) {
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
        this.f336b = str;
        return this;
    }

    public void a() {
        if (this.f334a == null) {
            throw new jj("Required field 'uuid' was not present! Struct: " + toString());
        }
        if (this.f335a == null) {
            throw new jj("Required field 'events' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m485a();
        while (true) {
            jf m481a = jiVar.m481a();
            if (m481a.a == 0) {
                jiVar.f();
                a();
                return;
            }
            switch (m481a.f777a) {
                case 1:
                    if (m481a.a == 11) {
                        this.f334a = jiVar.m486a();
                        break;
                    } else {
                        jl.a(jiVar, m481a.a);
                        break;
                    }
                case 2:
                    if (m481a.a == 11) {
                        this.f336b = jiVar.m486a();
                        break;
                    } else {
                        jl.a(jiVar, m481a.a);
                        break;
                    }
                case 3:
                    if (m481a.a == 15) {
                        jg m482a = jiVar.m482a();
                        this.f335a = new ArrayList(m482a.f778a);
                        for (int i = 0; i < m482a.f778a; i++) {
                            fi fiVar = new fi();
                            fiVar.a(jiVar);
                            this.f335a.add(fiVar);
                        }
                        jiVar.i();
                        break;
                    } else {
                        jl.a(jiVar, m481a.a);
                        break;
                    }
                default:
                    jl.a(jiVar, m481a.a);
                    break;
            }
            jiVar.g();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m274a() {
        return this.f334a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m275a(fj fjVar) {
        if (fjVar == null) {
            return false;
        }
        boolean m274a = m274a();
        boolean m274a2 = fjVar.m274a();
        if ((m274a || m274a2) && !(m274a && m274a2 && this.f334a.equals(fjVar.f334a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = fjVar.b();
        if ((b2 || b3) && !(b2 && b3 && this.f336b.equals(fjVar.f336b))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = fjVar.c();
        return !(c2 || c3) || (c2 && c3 && this.f335a.equals(fjVar.f335a));
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        a();
        jiVar.a(f333a);
        if (this.f334a != null) {
            jiVar.a(a);
            jiVar.a(this.f334a);
            jiVar.b();
        }
        if (this.f336b != null && b()) {
            jiVar.a(b);
            jiVar.a(this.f336b);
            jiVar.b();
        }
        if (this.f335a != null) {
            jiVar.a(c);
            jiVar.a(new jg((byte) 12, this.f335a.size()));
            for (fi fiVar : this.f335a) {
                fiVar.b(jiVar);
            }
            jiVar.e();
            jiVar.b();
        }
        jiVar.c();
        jiVar.m489a();
    }

    public boolean b() {
        return this.f336b != null;
    }

    public boolean c() {
        return this.f335a != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof fj)) {
            return m275a((fj) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("StatsEvents(");
        sb.append("uuid:");
        if (this.f334a == null) {
            sb.append("null");
        } else {
            sb.append(this.f334a);
        }
        if (b()) {
            sb.append(", ");
            sb.append("operator:");
            if (this.f336b == null) {
                sb.append("null");
            } else {
                sb.append(this.f336b);
            }
        }
        sb.append(", ");
        sb.append("events:");
        if (this.f335a == null) {
            sb.append("null");
        } else {
            sb.append(this.f335a);
        }
        sb.append(")");
        return sb.toString();
    }
}
