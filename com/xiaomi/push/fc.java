package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes6.dex */
public class fc implements ir<fc, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public byte f340a;

    /* renamed from: a  reason: collision with other field name */
    public int f341a;

    /* renamed from: a  reason: collision with other field name */
    public String f342a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f343a = new BitSet(6);

    /* renamed from: b  reason: collision with other field name */
    public int f344b;

    /* renamed from: b  reason: collision with other field name */
    public String f345b;

    /* renamed from: c  reason: collision with other field name */
    public int f346c;

    /* renamed from: c  reason: collision with other field name */
    public String f347c;

    /* renamed from: d  reason: collision with other field name */
    public int f348d;

    /* renamed from: d  reason: collision with other field name */
    public String f349d;

    /* renamed from: e  reason: collision with other field name */
    public int f350e;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f339a = new jh("StatsEvent");
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
            int compareTo = Boolean.valueOf(m260a()).compareTo(Boolean.valueOf(fcVar.m260a()));
            if (compareTo == 0) {
                if (!m260a() || (a11 = is.a(this.f340a, fcVar.f340a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(fcVar.b()));
                    if (compareTo2 == 0) {
                        if (!b() || (a10 = is.a(this.f341a, fcVar.f341a)) == 0) {
                            int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(fcVar.c()));
                            if (compareTo3 == 0) {
                                if (!c() || (a9 = is.a(this.f344b, fcVar.f344b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(fcVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a8 = is.a(this.f342a, fcVar.f342a)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(fcVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a7 = is.a(this.f345b, fcVar.f345b)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(fcVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a6 = is.a(this.f346c, fcVar.f346c)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(fcVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a5 = is.a(this.f347c, fcVar.f347c)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(fcVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a4 = is.a(this.f349d, fcVar.f349d)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(fcVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a3 = is.a(this.f348d, fcVar.f348d)) == 0) {
                                                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(fcVar.j()));
                                                                                    if (compareTo10 == 0) {
                                                                                        if (!j() || (a2 = is.a(this.f350e, fcVar.f350e)) == 0) {
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
        this.f340a = b2;
        a(true);
        return this;
    }

    public fc a(int i2) {
        this.f341a = i2;
        b(true);
        return this;
    }

    public fc a(String str) {
        this.f342a = str;
        return this;
    }

    public void a() {
        if (this.f342a == null) {
            throw new jd("Required field 'connpt' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ir
    public void a(jc jcVar) {
        jcVar.m467a();
        while (true) {
            iz m463a = jcVar.m463a();
            if (m463a.a == 0) {
                jcVar.f();
                if (!m260a()) {
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
            switch (m463a.f792a) {
                case 1:
                    if (m463a.a != 3) {
                        jf.a(jcVar, m463a.a);
                        break;
                    } else {
                        this.f340a = jcVar.a();
                        a(true);
                        break;
                    }
                case 2:
                    if (m463a.a != 8) {
                        jf.a(jcVar, m463a.a);
                        break;
                    } else {
                        this.f341a = jcVar.m461a();
                        b(true);
                        break;
                    }
                case 3:
                    if (m463a.a != 8) {
                        jf.a(jcVar, m463a.a);
                        break;
                    } else {
                        this.f344b = jcVar.m461a();
                        c(true);
                        break;
                    }
                case 4:
                    if (m463a.a != 11) {
                        jf.a(jcVar, m463a.a);
                        break;
                    } else {
                        this.f342a = jcVar.m468a();
                        break;
                    }
                case 5:
                    if (m463a.a != 11) {
                        jf.a(jcVar, m463a.a);
                        break;
                    } else {
                        this.f345b = jcVar.m468a();
                        break;
                    }
                case 6:
                    if (m463a.a != 8) {
                        jf.a(jcVar, m463a.a);
                        break;
                    } else {
                        this.f346c = jcVar.m461a();
                        d(true);
                        break;
                    }
                case 7:
                    if (m463a.a != 11) {
                        jf.a(jcVar, m463a.a);
                        break;
                    } else {
                        this.f347c = jcVar.m468a();
                        break;
                    }
                case 8:
                    if (m463a.a != 11) {
                        jf.a(jcVar, m463a.a);
                        break;
                    } else {
                        this.f349d = jcVar.m468a();
                        break;
                    }
                case 9:
                    if (m463a.a != 8) {
                        jf.a(jcVar, m463a.a);
                        break;
                    } else {
                        this.f348d = jcVar.m461a();
                        e(true);
                        break;
                    }
                case 10:
                    if (m463a.a != 8) {
                        jf.a(jcVar, m463a.a);
                        break;
                    } else {
                        this.f350e = jcVar.m461a();
                        f(true);
                        break;
                    }
                default:
                    jf.a(jcVar, m463a.a);
                    break;
            }
            jcVar.g();
        }
    }

    public void a(boolean z) {
        this.f343a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m260a() {
        return this.f343a.get(0);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m261a(fc fcVar) {
        if (fcVar != null && this.f340a == fcVar.f340a && this.f341a == fcVar.f341a && this.f344b == fcVar.f344b) {
            boolean d2 = d();
            boolean d3 = fcVar.d();
            if ((d2 || d3) && !(d2 && d3 && this.f342a.equals(fcVar.f342a))) {
                return false;
            }
            boolean e2 = e();
            boolean e3 = fcVar.e();
            if ((e2 || e3) && !(e2 && e3 && this.f345b.equals(fcVar.f345b))) {
                return false;
            }
            boolean f2 = f();
            boolean f3 = fcVar.f();
            if ((f2 || f3) && !(f2 && f3 && this.f346c == fcVar.f346c)) {
                return false;
            }
            boolean g2 = g();
            boolean g3 = fcVar.g();
            if ((g2 || g3) && !(g2 && g3 && this.f347c.equals(fcVar.f347c))) {
                return false;
            }
            boolean h2 = h();
            boolean h3 = fcVar.h();
            if ((h2 || h3) && !(h2 && h3 && this.f349d.equals(fcVar.f349d))) {
                return false;
            }
            boolean i2 = i();
            boolean i3 = fcVar.i();
            if ((i2 || i3) && !(i2 && i3 && this.f348d == fcVar.f348d)) {
                return false;
            }
            boolean j2 = j();
            boolean j3 = fcVar.j();
            return !(j2 || j3) || (j2 && j3 && this.f350e == fcVar.f350e);
        }
        return false;
    }

    public fc b(int i2) {
        this.f344b = i2;
        c(true);
        return this;
    }

    public fc b(String str) {
        this.f345b = str;
        return this;
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        a();
        jcVar.a(f339a);
        jcVar.a(a);
        jcVar.a(this.f340a);
        jcVar.b();
        jcVar.a(b);
        jcVar.a(this.f341a);
        jcVar.b();
        jcVar.a(c);
        jcVar.a(this.f344b);
        jcVar.b();
        if (this.f342a != null) {
            jcVar.a(d);
            jcVar.a(this.f342a);
            jcVar.b();
        }
        if (this.f345b != null && e()) {
            jcVar.a(e);
            jcVar.a(this.f345b);
            jcVar.b();
        }
        if (f()) {
            jcVar.a(f);
            jcVar.a(this.f346c);
            jcVar.b();
        }
        if (this.f347c != null && g()) {
            jcVar.a(g);
            jcVar.a(this.f347c);
            jcVar.b();
        }
        if (this.f349d != null && h()) {
            jcVar.a(h);
            jcVar.a(this.f349d);
            jcVar.b();
        }
        if (i()) {
            jcVar.a(i);
            jcVar.a(this.f348d);
            jcVar.b();
        }
        if (j()) {
            jcVar.a(j);
            jcVar.a(this.f350e);
            jcVar.b();
        }
        jcVar.c();
        jcVar.m471a();
    }

    public void b(boolean z) {
        this.f343a.set(1, z);
    }

    public boolean b() {
        return this.f343a.get(1);
    }

    public fc c(int i2) {
        this.f346c = i2;
        d(true);
        return this;
    }

    public fc c(String str) {
        this.f347c = str;
        return this;
    }

    public void c(boolean z) {
        this.f343a.set(2, z);
    }

    public boolean c() {
        return this.f343a.get(2);
    }

    public fc d(int i2) {
        this.f348d = i2;
        e(true);
        return this;
    }

    public fc d(String str) {
        this.f349d = str;
        return this;
    }

    public void d(boolean z) {
        this.f343a.set(3, z);
    }

    public boolean d() {
        return this.f342a != null;
    }

    public void e(boolean z) {
        this.f343a.set(4, z);
    }

    public boolean e() {
        return this.f345b != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof fc)) {
            return m261a((fc) obj);
        }
        return false;
    }

    public void f(boolean z) {
        this.f343a.set(5, z);
    }

    public boolean f() {
        return this.f343a.get(3);
    }

    public boolean g() {
        return this.f347c != null;
    }

    public boolean h() {
        return this.f349d != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f343a.get(4);
    }

    public boolean j() {
        return this.f343a.get(5);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("StatsEvent(");
        sb.append("chid:");
        sb.append((int) this.f340a);
        sb.append(", ");
        sb.append("type:");
        sb.append(this.f341a);
        sb.append(", ");
        sb.append("value:");
        sb.append(this.f344b);
        sb.append(", ");
        sb.append("connpt:");
        if (this.f342a == null) {
            sb.append("null");
        } else {
            sb.append(this.f342a);
        }
        if (e()) {
            sb.append(", ");
            sb.append("host:");
            if (this.f345b == null) {
                sb.append("null");
            } else {
                sb.append(this.f345b);
            }
        }
        if (f()) {
            sb.append(", ");
            sb.append("subvalue:");
            sb.append(this.f346c);
        }
        if (g()) {
            sb.append(", ");
            sb.append("annotation:");
            if (this.f347c == null) {
                sb.append("null");
            } else {
                sb.append(this.f347c);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("user:");
            if (this.f349d == null) {
                sb.append("null");
            } else {
                sb.append(this.f349d);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("time:");
            sb.append(this.f348d);
        }
        if (j()) {
            sb.append(", ");
            sb.append("clientIp:");
            sb.append(this.f350e);
        }
        sb.append(")");
        return sb.toString();
    }
}
