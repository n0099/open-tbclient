package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class fj implements ix<fj, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public String f415a;

    /* renamed from: a  reason: collision with other field name */
    public List<fi> f416a;

    /* renamed from: b  reason: collision with other field name */
    public String f417b;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f414a = new jn("StatsEvents");

    /* renamed from: a  reason: collision with root package name */
    private static final jf f14316a = new jf("", Constants.GZIP_CAST_TYPE, 1);

    /* renamed from: b  reason: collision with root package name */
    private static final jf f14317b = new jf("", Constants.GZIP_CAST_TYPE, 2);
    private static final jf c = new jf("", (byte) 15, 3);

    public fj() {
    }

    public fj(String str, List<fi> list) {
        this();
        this.f415a = str;
        this.f416a = list;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(fj fjVar) {
        int a2;
        int a3;
        int a4;
        if (getClass().equals(fjVar.getClass())) {
            int compareTo = Boolean.valueOf(m308a()).compareTo(Boolean.valueOf(fjVar.m308a()));
            if (compareTo == 0) {
                if (!m308a() || (a4 = iy.a(this.f415a, fjVar.f415a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(fjVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a3 = iy.a(this.f417b, fjVar.f417b)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(fjVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a2 = iy.a(this.f416a, fjVar.f416a)) == 0) {
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
        this.f417b = str;
        return this;
    }

    public void a() {
        if (this.f415a == null) {
            throw new jj("Required field 'uuid' was not present! Struct: " + toString());
        }
        if (this.f416a == null) {
            throw new jj("Required field 'events' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m519a();
        while (true) {
            jf m515a = jiVar.m515a();
            if (m515a.f14471a == 0) {
                jiVar.f();
                a();
                return;
            }
            switch (m515a.f858a) {
                case 1:
                    if (m515a.f14471a == 11) {
                        this.f415a = jiVar.m520a();
                        break;
                    } else {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    }
                case 2:
                    if (m515a.f14471a == 11) {
                        this.f417b = jiVar.m520a();
                        break;
                    } else {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    }
                case 3:
                    if (m515a.f14471a == 15) {
                        jg m516a = jiVar.m516a();
                        this.f416a = new ArrayList(m516a.f859a);
                        for (int i = 0; i < m516a.f859a; i++) {
                            fi fiVar = new fi();
                            fiVar.a(jiVar);
                            this.f416a.add(fiVar);
                        }
                        jiVar.i();
                        break;
                    } else {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    }
                default:
                    jl.a(jiVar, m515a.f14471a);
                    break;
            }
            jiVar.g();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m308a() {
        return this.f415a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m309a(fj fjVar) {
        if (fjVar == null) {
            return false;
        }
        boolean m308a = m308a();
        boolean m308a2 = fjVar.m308a();
        if ((m308a || m308a2) && !(m308a && m308a2 && this.f415a.equals(fjVar.f415a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = fjVar.b();
        if ((b2 || b3) && !(b2 && b3 && this.f417b.equals(fjVar.f417b))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = fjVar.c();
        return !(c2 || c3) || (c2 && c3 && this.f416a.equals(fjVar.f416a));
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        a();
        jiVar.a(f414a);
        if (this.f415a != null) {
            jiVar.a(f14316a);
            jiVar.a(this.f415a);
            jiVar.b();
        }
        if (this.f417b != null && b()) {
            jiVar.a(f14317b);
            jiVar.a(this.f417b);
            jiVar.b();
        }
        if (this.f416a != null) {
            jiVar.a(c);
            jiVar.a(new jg((byte) 12, this.f416a.size()));
            for (fi fiVar : this.f416a) {
                fiVar.b(jiVar);
            }
            jiVar.e();
            jiVar.b();
        }
        jiVar.c();
        jiVar.m523a();
    }

    public boolean b() {
        return this.f417b != null;
    }

    public boolean c() {
        return this.f416a != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof fj)) {
            return m309a((fj) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("StatsEvents(");
        sb.append("uuid:");
        if (this.f415a == null) {
            sb.append("null");
        } else {
            sb.append(this.f415a);
        }
        if (b()) {
            sb.append(", ");
            sb.append("operator:");
            if (this.f417b == null) {
                sb.append("null");
            } else {
                sb.append(this.f417b);
            }
        }
        sb.append(", ");
        sb.append("events:");
        if (this.f416a == null) {
            sb.append("null");
        } else {
            sb.append(this.f416a);
        }
        sb.append(")");
        return sb.toString();
    }
}
