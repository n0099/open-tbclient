package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class fj implements ix<fj, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public String f341a;

    /* renamed from: a  reason: collision with other field name */
    public List<fi> f342a;

    /* renamed from: b  reason: collision with other field name */
    public String f343b;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f340a = new jn("StatsEvents");
    private static final jf a = new jf("", Constants.GZIP_CAST_TYPE, 1);
    private static final jf b = new jf("", Constants.GZIP_CAST_TYPE, 2);
    private static final jf c = new jf("", (byte) 15, 3);

    public fj() {
    }

    public fj(String str, List<fi> list) {
        this();
        this.f341a = str;
        this.f342a = list;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(fj fjVar) {
        int a2;
        int a3;
        int a4;
        if (getClass().equals(fjVar.getClass())) {
            int compareTo = Boolean.valueOf(m272a()).compareTo(Boolean.valueOf(fjVar.m272a()));
            if (compareTo == 0) {
                if (!m272a() || (a4 = iy.a(this.f341a, fjVar.f341a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(fjVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a3 = iy.a(this.f343b, fjVar.f343b)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(fjVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a2 = iy.a(this.f342a, fjVar.f342a)) == 0) {
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
        this.f343b = str;
        return this;
    }

    public void a() {
        if (this.f341a == null) {
            throw new jj("Required field 'uuid' was not present! Struct: " + toString());
        }
        if (this.f342a == null) {
            throw new jj("Required field 'events' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m483a();
        while (true) {
            jf m479a = jiVar.m479a();
            if (m479a.a == 0) {
                jiVar.f();
                a();
                return;
            }
            switch (m479a.f784a) {
                case 1:
                    if (m479a.a == 11) {
                        this.f341a = jiVar.m484a();
                        break;
                    } else {
                        jl.a(jiVar, m479a.a);
                        break;
                    }
                case 2:
                    if (m479a.a == 11) {
                        this.f343b = jiVar.m484a();
                        break;
                    } else {
                        jl.a(jiVar, m479a.a);
                        break;
                    }
                case 3:
                    if (m479a.a == 15) {
                        jg m480a = jiVar.m480a();
                        this.f342a = new ArrayList(m480a.f785a);
                        for (int i = 0; i < m480a.f785a; i++) {
                            fi fiVar = new fi();
                            fiVar.a(jiVar);
                            this.f342a.add(fiVar);
                        }
                        jiVar.i();
                        break;
                    } else {
                        jl.a(jiVar, m479a.a);
                        break;
                    }
                default:
                    jl.a(jiVar, m479a.a);
                    break;
            }
            jiVar.g();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m272a() {
        return this.f341a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m273a(fj fjVar) {
        if (fjVar == null) {
            return false;
        }
        boolean m272a = m272a();
        boolean m272a2 = fjVar.m272a();
        if ((m272a || m272a2) && !(m272a && m272a2 && this.f341a.equals(fjVar.f341a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = fjVar.b();
        if ((b2 || b3) && !(b2 && b3 && this.f343b.equals(fjVar.f343b))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = fjVar.c();
        return !(c2 || c3) || (c2 && c3 && this.f342a.equals(fjVar.f342a));
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        a();
        jiVar.a(f340a);
        if (this.f341a != null) {
            jiVar.a(a);
            jiVar.a(this.f341a);
            jiVar.b();
        }
        if (this.f343b != null && b()) {
            jiVar.a(b);
            jiVar.a(this.f343b);
            jiVar.b();
        }
        if (this.f342a != null) {
            jiVar.a(c);
            jiVar.a(new jg((byte) 12, this.f342a.size()));
            for (fi fiVar : this.f342a) {
                fiVar.b(jiVar);
            }
            jiVar.e();
            jiVar.b();
        }
        jiVar.c();
        jiVar.m487a();
    }

    public boolean b() {
        return this.f343b != null;
    }

    public boolean c() {
        return this.f342a != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof fj)) {
            return m273a((fj) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("StatsEvents(");
        sb.append("uuid:");
        if (this.f341a == null) {
            sb.append("null");
        } else {
            sb.append(this.f341a);
        }
        if (b()) {
            sb.append(", ");
            sb.append("operator:");
            if (this.f343b == null) {
                sb.append("null");
            } else {
                sb.append(this.f343b);
            }
        }
        sb.append(", ");
        sb.append("events:");
        if (this.f342a == null) {
            sb.append("null");
        } else {
            sb.append(this.f342a);
        }
        sb.append(")");
        return sb.toString();
    }
}
