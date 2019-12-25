package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class fd implements ir<fd, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public String f353a;

    /* renamed from: a  reason: collision with other field name */
    public List<fc> f354a;

    /* renamed from: b  reason: collision with other field name */
    public String f355b;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f352a = new jh("StatsEvents");
    private static final iz a = new iz("", Constants.GZIP_CAST_TYPE, 1);
    private static final iz b = new iz("", Constants.GZIP_CAST_TYPE, 2);
    private static final iz c = new iz("", (byte) 15, 3);

    public fd() {
    }

    public fd(String str, List<fc> list) {
        this();
        this.f353a = str;
        this.f354a = list;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(fd fdVar) {
        int a2;
        int a3;
        int a4;
        if (getClass().equals(fdVar.getClass())) {
            int compareTo = Boolean.valueOf(m253a()).compareTo(Boolean.valueOf(fdVar.m253a()));
            if (compareTo == 0) {
                if (!m253a() || (a4 = is.a(this.f353a, fdVar.f353a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(fdVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a3 = is.a(this.f355b, fdVar.f355b)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(fdVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a2 = is.a(this.f354a, fdVar.f354a)) == 0) {
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
        this.f355b = str;
        return this;
    }

    public void a() {
        if (this.f353a == null) {
            throw new jd("Required field 'uuid' was not present! Struct: " + toString());
        }
        if (this.f354a == null) {
            throw new jd("Required field 'events' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ir
    public void a(jc jcVar) {
        jcVar.m458a();
        while (true) {
            iz m454a = jcVar.m454a();
            if (m454a.a == 0) {
                jcVar.f();
                a();
                return;
            }
            switch (m454a.f793a) {
                case 1:
                    if (m454a.a == 11) {
                        this.f353a = jcVar.m459a();
                        break;
                    } else {
                        jf.a(jcVar, m454a.a);
                        break;
                    }
                case 2:
                    if (m454a.a == 11) {
                        this.f355b = jcVar.m459a();
                        break;
                    } else {
                        jf.a(jcVar, m454a.a);
                        break;
                    }
                case 3:
                    if (m454a.a == 15) {
                        ja m455a = jcVar.m455a();
                        this.f354a = new ArrayList(m455a.f796a);
                        for (int i = 0; i < m455a.f796a; i++) {
                            fc fcVar = new fc();
                            fcVar.a(jcVar);
                            this.f354a.add(fcVar);
                        }
                        jcVar.i();
                        break;
                    } else {
                        jf.a(jcVar, m454a.a);
                        break;
                    }
                default:
                    jf.a(jcVar, m454a.a);
                    break;
            }
            jcVar.g();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m253a() {
        return this.f353a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m254a(fd fdVar) {
        if (fdVar == null) {
            return false;
        }
        boolean m253a = m253a();
        boolean m253a2 = fdVar.m253a();
        if ((m253a || m253a2) && !(m253a && m253a2 && this.f353a.equals(fdVar.f353a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = fdVar.b();
        if ((b2 || b3) && !(b2 && b3 && this.f355b.equals(fdVar.f355b))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = fdVar.c();
        return !(c2 || c3) || (c2 && c3 && this.f354a.equals(fdVar.f354a));
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        a();
        jcVar.a(f352a);
        if (this.f353a != null) {
            jcVar.a(a);
            jcVar.a(this.f353a);
            jcVar.b();
        }
        if (this.f355b != null && b()) {
            jcVar.a(b);
            jcVar.a(this.f355b);
            jcVar.b();
        }
        if (this.f354a != null) {
            jcVar.a(c);
            jcVar.a(new ja((byte) 12, this.f354a.size()));
            for (fc fcVar : this.f354a) {
                fcVar.b(jcVar);
            }
            jcVar.e();
            jcVar.b();
        }
        jcVar.c();
        jcVar.m462a();
    }

    public boolean b() {
        return this.f355b != null;
    }

    public boolean c() {
        return this.f354a != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof fd)) {
            return m254a((fd) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("StatsEvents(");
        sb.append("uuid:");
        if (this.f353a == null) {
            sb.append("null");
        } else {
            sb.append(this.f353a);
        }
        if (b()) {
            sb.append(", ");
            sb.append("operator:");
            if (this.f355b == null) {
                sb.append("null");
            } else {
                sb.append(this.f355b);
            }
        }
        sb.append(", ");
        sb.append("events:");
        if (this.f354a == null) {
            sb.append("null");
        } else {
            sb.append(this.f354a);
        }
        sb.append(")");
        return sb.toString();
    }
}
