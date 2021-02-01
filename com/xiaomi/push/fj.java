package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class fj implements ix<fj, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public String f414a;

    /* renamed from: a  reason: collision with other field name */
    public List<fi> f415a;

    /* renamed from: b  reason: collision with other field name */
    public String f416b;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f413a = new jn("StatsEvents");

    /* renamed from: a  reason: collision with root package name */
    private static final jf f14018a = new jf("", Constants.GZIP_CAST_TYPE, 1);

    /* renamed from: b  reason: collision with root package name */
    private static final jf f14019b = new jf("", Constants.GZIP_CAST_TYPE, 2);
    private static final jf c = new jf("", (byte) 15, 3);

    public fj() {
    }

    public fj(String str, List<fi> list) {
        this();
        this.f414a = str;
        this.f415a = list;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(fj fjVar) {
        int a2;
        int a3;
        int a4;
        if (getClass().equals(fjVar.getClass())) {
            int compareTo = Boolean.valueOf(m304a()).compareTo(Boolean.valueOf(fjVar.m304a()));
            if (compareTo == 0) {
                if (!m304a() || (a4 = iy.a(this.f414a, fjVar.f414a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(fjVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a3 = iy.a(this.f416b, fjVar.f416b)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(fjVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a2 = iy.a(this.f415a, fjVar.f415a)) == 0) {
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
        this.f416b = str;
        return this;
    }

    public void a() {
        if (this.f414a == null) {
            throw new jj("Required field 'uuid' was not present! Struct: " + toString());
        }
        if (this.f415a == null) {
            throw new jj("Required field 'events' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m515a();
        while (true) {
            jf m511a = jiVar.m511a();
            if (m511a.f14173a == 0) {
                jiVar.f();
                a();
                return;
            }
            switch (m511a.f857a) {
                case 1:
                    if (m511a.f14173a == 11) {
                        this.f414a = jiVar.m516a();
                        break;
                    } else {
                        jl.a(jiVar, m511a.f14173a);
                        break;
                    }
                case 2:
                    if (m511a.f14173a == 11) {
                        this.f416b = jiVar.m516a();
                        break;
                    } else {
                        jl.a(jiVar, m511a.f14173a);
                        break;
                    }
                case 3:
                    if (m511a.f14173a == 15) {
                        jg m512a = jiVar.m512a();
                        this.f415a = new ArrayList(m512a.f858a);
                        for (int i = 0; i < m512a.f858a; i++) {
                            fi fiVar = new fi();
                            fiVar.a(jiVar);
                            this.f415a.add(fiVar);
                        }
                        jiVar.i();
                        break;
                    } else {
                        jl.a(jiVar, m511a.f14173a);
                        break;
                    }
                default:
                    jl.a(jiVar, m511a.f14173a);
                    break;
            }
            jiVar.g();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m304a() {
        return this.f414a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m305a(fj fjVar) {
        if (fjVar == null) {
            return false;
        }
        boolean m304a = m304a();
        boolean m304a2 = fjVar.m304a();
        if ((m304a || m304a2) && !(m304a && m304a2 && this.f414a.equals(fjVar.f414a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = fjVar.b();
        if ((b2 || b3) && !(b2 && b3 && this.f416b.equals(fjVar.f416b))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = fjVar.c();
        return !(c2 || c3) || (c2 && c3 && this.f415a.equals(fjVar.f415a));
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        a();
        jiVar.a(f413a);
        if (this.f414a != null) {
            jiVar.a(f14018a);
            jiVar.a(this.f414a);
            jiVar.b();
        }
        if (this.f416b != null && b()) {
            jiVar.a(f14019b);
            jiVar.a(this.f416b);
            jiVar.b();
        }
        if (this.f415a != null) {
            jiVar.a(c);
            jiVar.a(new jg((byte) 12, this.f415a.size()));
            for (fi fiVar : this.f415a) {
                fiVar.b(jiVar);
            }
            jiVar.e();
            jiVar.b();
        }
        jiVar.c();
        jiVar.m519a();
    }

    public boolean b() {
        return this.f416b != null;
    }

    public boolean c() {
        return this.f415a != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof fj)) {
            return m305a((fj) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("StatsEvents(");
        sb.append("uuid:");
        if (this.f414a == null) {
            sb.append("null");
        } else {
            sb.append(this.f414a);
        }
        if (b()) {
            sb.append(", ");
            sb.append("operator:");
            if (this.f416b == null) {
                sb.append("null");
            } else {
                sb.append(this.f416b);
            }
        }
        sb.append(", ");
        sb.append("events:");
        if (this.f415a == null) {
            sb.append("null");
        } else {
            sb.append(this.f415a);
        }
        sb.append(")");
        return sb.toString();
    }
}
