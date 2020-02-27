package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class fd implements ir<fd, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public String f349a;

    /* renamed from: a  reason: collision with other field name */
    public List<fc> f350a;

    /* renamed from: b  reason: collision with other field name */
    public String f351b;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f348a = new jh("StatsEvents");
    private static final iz a = new iz("", Constants.GZIP_CAST_TYPE, 1);
    private static final iz b = new iz("", Constants.GZIP_CAST_TYPE, 2);
    private static final iz c = new iz("", (byte) 15, 3);

    public fd() {
    }

    public fd(String str, List<fc> list) {
        this();
        this.f349a = str;
        this.f350a = list;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(fd fdVar) {
        int a2;
        int a3;
        int a4;
        if (getClass().equals(fdVar.getClass())) {
            int compareTo = Boolean.valueOf(m267a()).compareTo(Boolean.valueOf(fdVar.m267a()));
            if (compareTo == 0) {
                if (!m267a() || (a4 = is.a(this.f349a, fdVar.f349a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(fdVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a3 = is.a(this.f351b, fdVar.f351b)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(fdVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a2 = is.a(this.f350a, fdVar.f350a)) == 0) {
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
        this.f351b = str;
        return this;
    }

    public void a() {
        if (this.f349a == null) {
            throw new jd("Required field 'uuid' was not present! Struct: " + toString());
        }
        if (this.f350a == null) {
            throw new jd("Required field 'events' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ir
    public void a(jc jcVar) {
        jcVar.m472a();
        while (true) {
            iz m468a = jcVar.m468a();
            if (m468a.a == 0) {
                jcVar.f();
                a();
                return;
            }
            switch (m468a.f789a) {
                case 1:
                    if (m468a.a == 11) {
                        this.f349a = jcVar.m473a();
                        break;
                    } else {
                        jf.a(jcVar, m468a.a);
                        break;
                    }
                case 2:
                    if (m468a.a == 11) {
                        this.f351b = jcVar.m473a();
                        break;
                    } else {
                        jf.a(jcVar, m468a.a);
                        break;
                    }
                case 3:
                    if (m468a.a == 15) {
                        ja m469a = jcVar.m469a();
                        this.f350a = new ArrayList(m469a.f792a);
                        for (int i = 0; i < m469a.f792a; i++) {
                            fc fcVar = new fc();
                            fcVar.a(jcVar);
                            this.f350a.add(fcVar);
                        }
                        jcVar.i();
                        break;
                    } else {
                        jf.a(jcVar, m468a.a);
                        break;
                    }
                default:
                    jf.a(jcVar, m468a.a);
                    break;
            }
            jcVar.g();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m267a() {
        return this.f349a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m268a(fd fdVar) {
        if (fdVar == null) {
            return false;
        }
        boolean m267a = m267a();
        boolean m267a2 = fdVar.m267a();
        if ((m267a || m267a2) && !(m267a && m267a2 && this.f349a.equals(fdVar.f349a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = fdVar.b();
        if ((b2 || b3) && !(b2 && b3 && this.f351b.equals(fdVar.f351b))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = fdVar.c();
        return !(c2 || c3) || (c2 && c3 && this.f350a.equals(fdVar.f350a));
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        a();
        jcVar.a(f348a);
        if (this.f349a != null) {
            jcVar.a(a);
            jcVar.a(this.f349a);
            jcVar.b();
        }
        if (this.f351b != null && b()) {
            jcVar.a(b);
            jcVar.a(this.f351b);
            jcVar.b();
        }
        if (this.f350a != null) {
            jcVar.a(c);
            jcVar.a(new ja((byte) 12, this.f350a.size()));
            for (fc fcVar : this.f350a) {
                fcVar.b(jcVar);
            }
            jcVar.e();
            jcVar.b();
        }
        jcVar.c();
        jcVar.m476a();
    }

    public boolean b() {
        return this.f351b != null;
    }

    public boolean c() {
        return this.f350a != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof fd)) {
            return m268a((fd) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("StatsEvents(");
        sb.append("uuid:");
        if (this.f349a == null) {
            sb.append("null");
        } else {
            sb.append(this.f349a);
        }
        if (b()) {
            sb.append(", ");
            sb.append("operator:");
            if (this.f351b == null) {
                sb.append("null");
            } else {
                sb.append(this.f351b);
            }
        }
        sb.append(", ");
        sb.append("events:");
        if (this.f350a == null) {
            sb.append("null");
        } else {
            sb.append(this.f350a);
        }
        sb.append(")");
        return sb.toString();
    }
}
