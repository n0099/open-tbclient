package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes18.dex */
public class fj implements ix<fj, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public String f338a;

    /* renamed from: a  reason: collision with other field name */
    public List<fi> f339a;

    /* renamed from: b  reason: collision with other field name */
    public String f340b;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f337a = new jn("StatsEvents");

    /* renamed from: a  reason: collision with root package name */
    private static final jf f4904a = new jf("", Constants.GZIP_CAST_TYPE, 1);
    private static final jf b = new jf("", Constants.GZIP_CAST_TYPE, 2);
    private static final jf c = new jf("", (byte) 15, 3);

    public fj() {
    }

    public fj(String str, List<fi> list) {
        this();
        this.f338a = str;
        this.f339a = list;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(fj fjVar) {
        int a2;
        int a3;
        int a4;
        if (getClass().equals(fjVar.getClass())) {
            int compareTo = Boolean.valueOf(m281a()).compareTo(Boolean.valueOf(fjVar.m281a()));
            if (compareTo == 0) {
                if (!m281a() || (a4 = iy.a(this.f338a, fjVar.f338a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(fjVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a3 = iy.a(this.f340b, fjVar.f340b)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(fjVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a2 = iy.a(this.f339a, fjVar.f339a)) == 0) {
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
        this.f340b = str;
        return this;
    }

    public void a() {
        if (this.f338a == null) {
            throw new jj("Required field 'uuid' was not present! Struct: " + toString());
        }
        if (this.f339a == null) {
            throw new jj("Required field 'events' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m492a();
        while (true) {
            jf m488a = jiVar.m488a();
            if (m488a.f5000a == 0) {
                jiVar.f();
                a();
                return;
            }
            switch (m488a.f781a) {
                case 1:
                    if (m488a.f5000a == 11) {
                        this.f338a = jiVar.m493a();
                        break;
                    } else {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    }
                case 2:
                    if (m488a.f5000a == 11) {
                        this.f340b = jiVar.m493a();
                        break;
                    } else {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    }
                case 3:
                    if (m488a.f5000a == 15) {
                        jg m489a = jiVar.m489a();
                        this.f339a = new ArrayList(m489a.f782a);
                        for (int i = 0; i < m489a.f782a; i++) {
                            fi fiVar = new fi();
                            fiVar.a(jiVar);
                            this.f339a.add(fiVar);
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
    public boolean m281a() {
        return this.f338a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m282a(fj fjVar) {
        if (fjVar == null) {
            return false;
        }
        boolean m281a = m281a();
        boolean m281a2 = fjVar.m281a();
        if ((m281a || m281a2) && !(m281a && m281a2 && this.f338a.equals(fjVar.f338a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = fjVar.b();
        if ((b2 || b3) && !(b2 && b3 && this.f340b.equals(fjVar.f340b))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = fjVar.c();
        return !(c2 || c3) || (c2 && c3 && this.f339a.equals(fjVar.f339a));
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        a();
        jiVar.a(f337a);
        if (this.f338a != null) {
            jiVar.a(f4904a);
            jiVar.a(this.f338a);
            jiVar.b();
        }
        if (this.f340b != null && b()) {
            jiVar.a(b);
            jiVar.a(this.f340b);
            jiVar.b();
        }
        if (this.f339a != null) {
            jiVar.a(c);
            jiVar.a(new jg((byte) 12, this.f339a.size()));
            for (fi fiVar : this.f339a) {
                fiVar.b(jiVar);
            }
            jiVar.e();
            jiVar.b();
        }
        jiVar.c();
        jiVar.m496a();
    }

    public boolean b() {
        return this.f340b != null;
    }

    public boolean c() {
        return this.f339a != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof fj)) {
            return m282a((fj) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("StatsEvents(");
        sb.append("uuid:");
        if (this.f338a == null) {
            sb.append("null");
        } else {
            sb.append(this.f338a);
        }
        if (b()) {
            sb.append(", ");
            sb.append("operator:");
            if (this.f340b == null) {
                sb.append("null");
            } else {
                sb.append(this.f340b);
            }
        }
        sb.append(", ");
        sb.append("events:");
        if (this.f339a == null) {
            sb.append("null");
        } else {
            sb.append(this.f339a);
        }
        sb.append(")");
        return sb.toString();
    }
}
