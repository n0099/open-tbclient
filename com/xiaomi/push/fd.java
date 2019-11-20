package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class fd implements ir<fd, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public String f348a;

    /* renamed from: a  reason: collision with other field name */
    public List<fc> f349a;

    /* renamed from: b  reason: collision with other field name */
    public String f350b;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f347a = new jh("StatsEvents");
    private static final iz a = new iz("", Constants.GZIP_CAST_TYPE, 1);
    private static final iz b = new iz("", Constants.GZIP_CAST_TYPE, 2);
    private static final iz c = new iz("", (byte) 15, 3);

    public fd() {
    }

    public fd(String str, List<fc> list) {
        this();
        this.f348a = str;
        this.f349a = list;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(fd fdVar) {
        int a2;
        int a3;
        int a4;
        if (getClass().equals(fdVar.getClass())) {
            int compareTo = Boolean.valueOf(m250a()).compareTo(Boolean.valueOf(fdVar.m250a()));
            if (compareTo == 0) {
                if (!m250a() || (a4 = is.a(this.f348a, fdVar.f348a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(fdVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a3 = is.a(this.f350b, fdVar.f350b)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(fdVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a2 = is.a(this.f349a, fdVar.f349a)) == 0) {
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
        this.f350b = str;
        return this;
    }

    public void a() {
        if (this.f348a == null) {
            throw new jd("Required field 'uuid' was not present! Struct: " + toString());
        }
        if (this.f349a == null) {
            throw new jd("Required field 'events' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ir
    public void a(jc jcVar) {
        jcVar.m455a();
        while (true) {
            iz m451a = jcVar.m451a();
            if (m451a.a == 0) {
                jcVar.f();
                a();
                return;
            }
            switch (m451a.f788a) {
                case 1:
                    if (m451a.a == 11) {
                        this.f348a = jcVar.m456a();
                        break;
                    } else {
                        jf.a(jcVar, m451a.a);
                        break;
                    }
                case 2:
                    if (m451a.a == 11) {
                        this.f350b = jcVar.m456a();
                        break;
                    } else {
                        jf.a(jcVar, m451a.a);
                        break;
                    }
                case 3:
                    if (m451a.a == 15) {
                        ja m452a = jcVar.m452a();
                        this.f349a = new ArrayList(m452a.f791a);
                        for (int i = 0; i < m452a.f791a; i++) {
                            fc fcVar = new fc();
                            fcVar.a(jcVar);
                            this.f349a.add(fcVar);
                        }
                        jcVar.i();
                        break;
                    } else {
                        jf.a(jcVar, m451a.a);
                        break;
                    }
                default:
                    jf.a(jcVar, m451a.a);
                    break;
            }
            jcVar.g();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m250a() {
        return this.f348a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m251a(fd fdVar) {
        if (fdVar == null) {
            return false;
        }
        boolean m250a = m250a();
        boolean m250a2 = fdVar.m250a();
        if ((m250a || m250a2) && !(m250a && m250a2 && this.f348a.equals(fdVar.f348a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = fdVar.b();
        if ((b2 || b3) && !(b2 && b3 && this.f350b.equals(fdVar.f350b))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = fdVar.c();
        return !(c2 || c3) || (c2 && c3 && this.f349a.equals(fdVar.f349a));
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        a();
        jcVar.a(f347a);
        if (this.f348a != null) {
            jcVar.a(a);
            jcVar.a(this.f348a);
            jcVar.b();
        }
        if (this.f350b != null && b()) {
            jcVar.a(b);
            jcVar.a(this.f350b);
            jcVar.b();
        }
        if (this.f349a != null) {
            jcVar.a(c);
            jcVar.a(new ja((byte) 12, this.f349a.size()));
            for (fc fcVar : this.f349a) {
                fcVar.b(jcVar);
            }
            jcVar.e();
            jcVar.b();
        }
        jcVar.c();
        jcVar.m459a();
    }

    public boolean b() {
        return this.f350b != null;
    }

    public boolean c() {
        return this.f349a != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof fd)) {
            return m251a((fd) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("StatsEvents(");
        sb.append("uuid:");
        if (this.f348a == null) {
            sb.append("null");
        } else {
            sb.append(this.f348a);
        }
        if (b()) {
            sb.append(", ");
            sb.append("operator:");
            if (this.f350b == null) {
                sb.append("null");
            } else {
                sb.append(this.f350b);
            }
        }
        sb.append(", ");
        sb.append("events:");
        if (this.f349a == null) {
            sb.append("null");
        } else {
            sb.append(this.f349a);
        }
        sb.append(")");
        return sb.toString();
    }
}
