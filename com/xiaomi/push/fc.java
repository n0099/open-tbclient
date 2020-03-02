package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes8.dex */
public class fc implements ir<fc, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public byte f336a;

    /* renamed from: a  reason: collision with other field name */
    public int f337a;

    /* renamed from: a  reason: collision with other field name */
    public String f338a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f339a = new BitSet(6);

    /* renamed from: b  reason: collision with other field name */
    public int f340b;

    /* renamed from: b  reason: collision with other field name */
    public String f341b;

    /* renamed from: c  reason: collision with other field name */
    public int f342c;

    /* renamed from: c  reason: collision with other field name */
    public String f343c;

    /* renamed from: d  reason: collision with other field name */
    public int f344d;

    /* renamed from: d  reason: collision with other field name */
    public String f345d;

    /* renamed from: e  reason: collision with other field name */
    public int f346e;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f335a = new jh("StatsEvent");
    private static final iz a = new iz("", (byte) 3, 1);
    private static final iz b = new iz("", (byte) 8, 2);
    private static final iz c = new iz("", (byte) 8, 3);
    private static final iz d = new iz("", Constants.GZIP_CAST_TYPE, 4);
    private static final iz e = new iz("", Constants.GZIP_CAST_TYPE, 5);
    private static final iz f = new iz("", (byte) 8, 6);
    private static final iz g = new iz("", Constants.GZIP_CAST_TYPE, 7);
    private static final iz h = new iz("", Constants.GZIP_CAST_TYPE, 8);
    private static final iz i = new iz("", (byte) 8, 9);
    private static final iz j = new iz("", (byte) 8, 10);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(fc fcVar) {
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        int a8;
        int a9;
        int a10;
        int a11;
        if (getClass().equals(fcVar.getClass())) {
            int compareTo = Boolean.valueOf(m265a()).compareTo(Boolean.valueOf(fcVar.m265a()));
            if (compareTo == 0) {
                if (!m265a() || (a11 = is.a(this.f336a, fcVar.f336a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(fcVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a10 = is.a(this.f337a, fcVar.f337a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(fcVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a9 = is.a(this.f340b, fcVar.f340b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(fcVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a8 = is.a(this.f338a, fcVar.f338a)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(fcVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a7 = is.a(this.f341b, fcVar.f341b)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(fcVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a6 = is.a(this.f342c, fcVar.f342c)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(fcVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a5 = is.a(this.f343c, fcVar.f343c)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(fcVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a4 = is.a(this.f345d, fcVar.f345d)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(fcVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a3 = is.a(this.f344d, fcVar.f344d)) == 0) {
                                                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(fcVar.j()));
                                                                                    if (compareTo10 == 0) {
                                                                                        if (!j() || (a2 = is.a(this.f346e, fcVar.f346e)) == 0) {
                                                                                            return 0;
                                                                                        }
                                                                                        return a2;
                                                                                    }
                                                                                    return compareTo10;
                                                                                }
                                                                                return a3;
                                                                            }
                                                                            return compareTo9;
                                                                        }
                                                                        return a4;
                                                                    }
                                                                    return compareTo8;
                                                                }
                                                                return a5;
                                                            }
                                                            return compareTo7;
                                                        }
                                                        return a6;
                                                    }
                                                    return compareTo6;
                                                }
                                                return a7;
                                            }
                                            return compareTo5;
                                        }
                                        return a8;
                                    }
                                    return compareTo4;
                                }
                                return a9;
                            }
                            return compareTo3;
                        }
                        return a10;
                    }
                    return compareTo2;
                }
                return a11;
            }
            return compareTo;
        }
        return getClass().getName().compareTo(fcVar.getClass().getName());
    }

    public fc a(byte b2) {
        this.f336a = b2;
        a(true);
        return this;
    }

    public fc a(int i2) {
        this.f337a = i2;
        b(true);
        return this;
    }

    public fc a(String str) {
        this.f338a = str;
        return this;
    }

    public void a() {
        if (this.f338a == null) {
            throw new jd("Required field 'connpt' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ir
    public void a(jc jcVar) {
        jcVar.m472a();
        while (true) {
            iz m468a = jcVar.m468a();
            if (m468a.a == 0) {
                jcVar.f();
                if (!m265a()) {
                    throw new jd("Required field 'chid' was not found in serialized data! Struct: " + toString());
                }
                if (!b()) {
                    throw new jd("Required field 'type' was not found in serialized data! Struct: " + toString());
                }
                if (!c()) {
                    throw new jd("Required field 'value' was not found in serialized data! Struct: " + toString());
                }
                a();
                return;
            }
            switch (m468a.f788a) {
                case 1:
                    if (m468a.a != 3) {
                        jf.a(jcVar, m468a.a);
                        break;
                    } else {
                        this.f336a = jcVar.a();
                        a(true);
                        break;
                    }
                case 2:
                    if (m468a.a != 8) {
                        jf.a(jcVar, m468a.a);
                        break;
                    } else {
                        this.f337a = jcVar.m466a();
                        b(true);
                        break;
                    }
                case 3:
                    if (m468a.a != 8) {
                        jf.a(jcVar, m468a.a);
                        break;
                    } else {
                        this.f340b = jcVar.m466a();
                        c(true);
                        break;
                    }
                case 4:
                    if (m468a.a != 11) {
                        jf.a(jcVar, m468a.a);
                        break;
                    } else {
                        this.f338a = jcVar.m473a();
                        break;
                    }
                case 5:
                    if (m468a.a != 11) {
                        jf.a(jcVar, m468a.a);
                        break;
                    } else {
                        this.f341b = jcVar.m473a();
                        break;
                    }
                case 6:
                    if (m468a.a != 8) {
                        jf.a(jcVar, m468a.a);
                        break;
                    } else {
                        this.f342c = jcVar.m466a();
                        d(true);
                        break;
                    }
                case 7:
                    if (m468a.a != 11) {
                        jf.a(jcVar, m468a.a);
                        break;
                    } else {
                        this.f343c = jcVar.m473a();
                        break;
                    }
                case 8:
                    if (m468a.a != 11) {
                        jf.a(jcVar, m468a.a);
                        break;
                    } else {
                        this.f345d = jcVar.m473a();
                        break;
                    }
                case 9:
                    if (m468a.a != 8) {
                        jf.a(jcVar, m468a.a);
                        break;
                    } else {
                        this.f344d = jcVar.m466a();
                        e(true);
                        break;
                    }
                case 10:
                    if (m468a.a != 8) {
                        jf.a(jcVar, m468a.a);
                        break;
                    } else {
                        this.f346e = jcVar.m466a();
                        f(true);
                        break;
                    }
                default:
                    jf.a(jcVar, m468a.a);
                    break;
            }
            jcVar.g();
        }
    }

    public void a(boolean z) {
        this.f339a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m265a() {
        return this.f339a.get(0);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m266a(fc fcVar) {
        if (fcVar != null && this.f336a == fcVar.f336a && this.f337a == fcVar.f337a && this.f340b == fcVar.f340b) {
            boolean d2 = d();
            boolean d3 = fcVar.d();
            if ((d2 || d3) && !(d2 && d3 && this.f338a.equals(fcVar.f338a))) {
                return false;
            }
            boolean e2 = e();
            boolean e3 = fcVar.e();
            if ((e2 || e3) && !(e2 && e3 && this.f341b.equals(fcVar.f341b))) {
                return false;
            }
            boolean f2 = f();
            boolean f3 = fcVar.f();
            if ((f2 || f3) && !(f2 && f3 && this.f342c == fcVar.f342c)) {
                return false;
            }
            boolean g2 = g();
            boolean g3 = fcVar.g();
            if ((g2 || g3) && !(g2 && g3 && this.f343c.equals(fcVar.f343c))) {
                return false;
            }
            boolean h2 = h();
            boolean h3 = fcVar.h();
            if ((h2 || h3) && !(h2 && h3 && this.f345d.equals(fcVar.f345d))) {
                return false;
            }
            boolean i2 = i();
            boolean i3 = fcVar.i();
            if ((i2 || i3) && !(i2 && i3 && this.f344d == fcVar.f344d)) {
                return false;
            }
            boolean j2 = j();
            boolean j3 = fcVar.j();
            return !(j2 || j3) || (j2 && j3 && this.f346e == fcVar.f346e);
        }
        return false;
    }

    public fc b(int i2) {
        this.f340b = i2;
        c(true);
        return this;
    }

    public fc b(String str) {
        this.f341b = str;
        return this;
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        a();
        jcVar.a(f335a);
        jcVar.a(a);
        jcVar.a(this.f336a);
        jcVar.b();
        jcVar.a(b);
        jcVar.a(this.f337a);
        jcVar.b();
        jcVar.a(c);
        jcVar.a(this.f340b);
        jcVar.b();
        if (this.f338a != null) {
            jcVar.a(d);
            jcVar.a(this.f338a);
            jcVar.b();
        }
        if (this.f341b != null && e()) {
            jcVar.a(e);
            jcVar.a(this.f341b);
            jcVar.b();
        }
        if (f()) {
            jcVar.a(f);
            jcVar.a(this.f342c);
            jcVar.b();
        }
        if (this.f343c != null && g()) {
            jcVar.a(g);
            jcVar.a(this.f343c);
            jcVar.b();
        }
        if (this.f345d != null && h()) {
            jcVar.a(h);
            jcVar.a(this.f345d);
            jcVar.b();
        }
        if (i()) {
            jcVar.a(i);
            jcVar.a(this.f344d);
            jcVar.b();
        }
        if (j()) {
            jcVar.a(j);
            jcVar.a(this.f346e);
            jcVar.b();
        }
        jcVar.c();
        jcVar.m476a();
    }

    public void b(boolean z) {
        this.f339a.set(1, z);
    }

    public boolean b() {
        return this.f339a.get(1);
    }

    public fc c(int i2) {
        this.f342c = i2;
        d(true);
        return this;
    }

    public fc c(String str) {
        this.f343c = str;
        return this;
    }

    public void c(boolean z) {
        this.f339a.set(2, z);
    }

    public boolean c() {
        return this.f339a.get(2);
    }

    public fc d(int i2) {
        this.f344d = i2;
        e(true);
        return this;
    }

    public fc d(String str) {
        this.f345d = str;
        return this;
    }

    public void d(boolean z) {
        this.f339a.set(3, z);
    }

    public boolean d() {
        return this.f338a != null;
    }

    public void e(boolean z) {
        this.f339a.set(4, z);
    }

    public boolean e() {
        return this.f341b != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof fc)) {
            return m266a((fc) obj);
        }
        return false;
    }

    public void f(boolean z) {
        this.f339a.set(5, z);
    }

    public boolean f() {
        return this.f339a.get(3);
    }

    public boolean g() {
        return this.f343c != null;
    }

    public boolean h() {
        return this.f345d != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f339a.get(4);
    }

    public boolean j() {
        return this.f339a.get(5);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("StatsEvent(");
        sb.append("chid:");
        sb.append((int) this.f336a);
        sb.append(", ");
        sb.append("type:");
        sb.append(this.f337a);
        sb.append(", ");
        sb.append("value:");
        sb.append(this.f340b);
        sb.append(", ");
        sb.append("connpt:");
        if (this.f338a == null) {
            sb.append("null");
        } else {
            sb.append(this.f338a);
        }
        if (e()) {
            sb.append(", ");
            sb.append("host:");
            if (this.f341b == null) {
                sb.append("null");
            } else {
                sb.append(this.f341b);
            }
        }
        if (f()) {
            sb.append(", ");
            sb.append("subvalue:");
            sb.append(this.f342c);
        }
        if (g()) {
            sb.append(", ");
            sb.append("annotation:");
            if (this.f343c == null) {
                sb.append("null");
            } else {
                sb.append(this.f343c);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("user:");
            if (this.f345d == null) {
                sb.append("null");
            } else {
                sb.append(this.f345d);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("time:");
            sb.append(this.f344d);
        }
        if (j()) {
            sb.append(", ");
            sb.append("clientIp:");
            sb.append(this.f346e);
        }
        sb.append(")");
        return sb.toString();
    }
}
