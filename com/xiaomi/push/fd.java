package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class fd implements ir<fd, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public String f351a;

    /* renamed from: a  reason: collision with other field name */
    public List<fc> f352a;

    /* renamed from: b  reason: collision with other field name */
    public String f353b;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f350a = new jh("StatsEvents");
    private static final iz a = new iz("", Constants.GZIP_CAST_TYPE, 1);
    private static final iz b = new iz("", Constants.GZIP_CAST_TYPE, 2);
    private static final iz c = new iz("", (byte) 15, 3);

    public fd() {
    }

    public fd(String str, List<fc> list) {
        this();
        this.f351a = str;
        this.f352a = list;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(fd fdVar) {
        int a2;
        int a3;
        int a4;
        if (getClass().equals(fdVar.getClass())) {
            int compareTo = Boolean.valueOf(m262a()).compareTo(Boolean.valueOf(fdVar.m262a()));
            if (compareTo == 0) {
                if (!m262a() || (a4 = is.a(this.f351a, fdVar.f351a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(fdVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a3 = is.a(this.f353b, fdVar.f353b)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(fdVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a2 = is.a(this.f352a, fdVar.f352a)) == 0) {
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
        return getClass().getName().compareTo(fdVar.getClass().getName());
    }

    public fd a(String str) {
        this.f353b = str;
        return this;
    }

    public void a() {
        if (this.f351a == null) {
            throw new jd("Required field 'uuid' was not present! Struct: " + toString());
        }
        if (this.f352a == null) {
            throw new jd("Required field 'events' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ir
    public void a(jc jcVar) {
        jcVar.m467a();
        while (true) {
            iz m463a = jcVar.m463a();
            if (m463a.a == 0) {
                jcVar.f();
                a();
                return;
            }
            switch (m463a.f791a) {
                case 1:
                    if (m463a.a == 11) {
                        this.f351a = jcVar.m468a();
                        break;
                    } else {
                        jf.a(jcVar, m463a.a);
                        break;
                    }
                case 2:
                    if (m463a.a == 11) {
                        this.f353b = jcVar.m468a();
                        break;
                    } else {
                        jf.a(jcVar, m463a.a);
                        break;
                    }
                case 3:
                    if (m463a.a == 15) {
                        ja m464a = jcVar.m464a();
                        this.f352a = new ArrayList(m464a.f794a);
                        for (int i = 0; i < m464a.f794a; i++) {
                            fc fcVar = new fc();
                            fcVar.a(jcVar);
                            this.f352a.add(fcVar);
                        }
                        jcVar.i();
                        break;
                    } else {
                        jf.a(jcVar, m463a.a);
                        break;
                    }
                default:
                    jf.a(jcVar, m463a.a);
                    break;
            }
            jcVar.g();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m262a() {
        return this.f351a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m263a(fd fdVar) {
        if (fdVar == null) {
            return false;
        }
        boolean m262a = m262a();
        boolean m262a2 = fdVar.m262a();
        if ((m262a || m262a2) && !(m262a && m262a2 && this.f351a.equals(fdVar.f351a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = fdVar.b();
        if ((b2 || b3) && !(b2 && b3 && this.f353b.equals(fdVar.f353b))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = fdVar.c();
        return !(c2 || c3) || (c2 && c3 && this.f352a.equals(fdVar.f352a));
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        a();
        jcVar.a(f350a);
        if (this.f351a != null) {
            jcVar.a(a);
            jcVar.a(this.f351a);
            jcVar.b();
        }
        if (this.f353b != null && b()) {
            jcVar.a(b);
            jcVar.a(this.f353b);
            jcVar.b();
        }
        if (this.f352a != null) {
            jcVar.a(c);
            jcVar.a(new ja((byte) 12, this.f352a.size()));
            for (fc fcVar : this.f352a) {
                fcVar.b(jcVar);
            }
            jcVar.e();
            jcVar.b();
        }
        jcVar.c();
        jcVar.m471a();
    }

    public boolean b() {
        return this.f353b != null;
    }

    public boolean c() {
        return this.f352a != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof fd)) {
            return m263a((fd) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("StatsEvents(");
        sb.append("uuid:");
        if (this.f351a == null) {
            sb.append("null");
        } else {
            sb.append(this.f351a);
        }
        if (b()) {
            sb.append(", ");
            sb.append("operator:");
            if (this.f353b == null) {
                sb.append("null");
            } else {
                sb.append(this.f353b);
            }
        }
        sb.append(", ");
        sb.append("events:");
        if (this.f352a == null) {
            sb.append("null");
        } else {
            sb.append(this.f352a);
        }
        sb.append(")");
        return sb.toString();
    }
}
