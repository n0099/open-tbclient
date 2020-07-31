package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class fj implements ix<fj, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public String f337a;

    /* renamed from: a  reason: collision with other field name */
    public List<fi> f338a;

    /* renamed from: b  reason: collision with other field name */
    public String f339b;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f336a = new jn("StatsEvents");
    private static final jf a = new jf("", Constants.GZIP_CAST_TYPE, 1);
    private static final jf b = new jf("", Constants.GZIP_CAST_TYPE, 2);
    private static final jf c = new jf("", (byte) 15, 3);

    public fj() {
    }

    public fj(String str, List<fi> list) {
        this();
        this.f337a = str;
        this.f338a = list;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(fj fjVar) {
        int a2;
        int a3;
        int a4;
        if (getClass().equals(fjVar.getClass())) {
            int compareTo = Boolean.valueOf(m273a()).compareTo(Boolean.valueOf(fjVar.m273a()));
            if (compareTo == 0) {
                if (!m273a() || (a4 = iy.a(this.f337a, fjVar.f337a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(fjVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a3 = iy.a(this.f339b, fjVar.f339b)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(fjVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a2 = iy.a(this.f338a, fjVar.f338a)) == 0) {
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
        this.f339b = str;
        return this;
    }

    public void a() {
        if (this.f337a == null) {
            throw new jj("Required field 'uuid' was not present! Struct: " + toString());
        }
        if (this.f338a == null) {
            throw new jj("Required field 'events' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m484a();
        while (true) {
            jf m480a = jiVar.m480a();
            if (m480a.a == 0) {
                jiVar.f();
                a();
                return;
            }
            switch (m480a.f780a) {
                case 1:
                    if (m480a.a == 11) {
                        this.f337a = jiVar.m485a();
                        break;
                    } else {
                        jl.a(jiVar, m480a.a);
                        break;
                    }
                case 2:
                    if (m480a.a == 11) {
                        this.f339b = jiVar.m485a();
                        break;
                    } else {
                        jl.a(jiVar, m480a.a);
                        break;
                    }
                case 3:
                    if (m480a.a == 15) {
                        jg m481a = jiVar.m481a();
                        this.f338a = new ArrayList(m481a.f781a);
                        for (int i = 0; i < m481a.f781a; i++) {
                            fi fiVar = new fi();
                            fiVar.a(jiVar);
                            this.f338a.add(fiVar);
                        }
                        jiVar.i();
                        break;
                    } else {
                        jl.a(jiVar, m480a.a);
                        break;
                    }
                default:
                    jl.a(jiVar, m480a.a);
                    break;
            }
            jiVar.g();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m273a() {
        return this.f337a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m274a(fj fjVar) {
        if (fjVar == null) {
            return false;
        }
        boolean m273a = m273a();
        boolean m273a2 = fjVar.m273a();
        if ((m273a || m273a2) && !(m273a && m273a2 && this.f337a.equals(fjVar.f337a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = fjVar.b();
        if ((b2 || b3) && !(b2 && b3 && this.f339b.equals(fjVar.f339b))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = fjVar.c();
        return !(c2 || c3) || (c2 && c3 && this.f338a.equals(fjVar.f338a));
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        a();
        jiVar.a(f336a);
        if (this.f337a != null) {
            jiVar.a(a);
            jiVar.a(this.f337a);
            jiVar.b();
        }
        if (this.f339b != null && b()) {
            jiVar.a(b);
            jiVar.a(this.f339b);
            jiVar.b();
        }
        if (this.f338a != null) {
            jiVar.a(c);
            jiVar.a(new jg((byte) 12, this.f338a.size()));
            for (fi fiVar : this.f338a) {
                fiVar.b(jiVar);
            }
            jiVar.e();
            jiVar.b();
        }
        jiVar.c();
        jiVar.m488a();
    }

    public boolean b() {
        return this.f339b != null;
    }

    public boolean c() {
        return this.f338a != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof fj)) {
            return m274a((fj) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("StatsEvents(");
        sb.append("uuid:");
        if (this.f337a == null) {
            sb.append("null");
        } else {
            sb.append(this.f337a);
        }
        if (b()) {
            sb.append(", ");
            sb.append("operator:");
            if (this.f339b == null) {
                sb.append("null");
            } else {
                sb.append(this.f339b);
            }
        }
        sb.append(", ");
        sb.append("events:");
        if (this.f338a == null) {
            sb.append("null");
        } else {
            sb.append(this.f338a);
        }
        sb.append(")");
        return sb.toString();
    }
}
