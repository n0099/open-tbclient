package com.xiaomi.push;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.tbadk.core.data.SmallTailInfo;
import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes7.dex */
public class ex implements iq<ex, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public byte f341a;

    /* renamed from: a  reason: collision with other field name */
    public int f342a;

    /* renamed from: a  reason: collision with other field name */
    public String f343a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f344a = new BitSet(6);

    /* renamed from: b  reason: collision with other field name */
    public int f345b;

    /* renamed from: b  reason: collision with other field name */
    public String f346b;

    /* renamed from: c  reason: collision with other field name */
    public int f347c;

    /* renamed from: c  reason: collision with other field name */
    public String f348c;

    /* renamed from: d  reason: collision with other field name */
    public int f349d;

    /* renamed from: d  reason: collision with other field name */
    public String f350d;

    /* renamed from: e  reason: collision with other field name */
    public int f351e;

    /* renamed from: a  reason: collision with other field name */
    public static final jg f340a = new jg("StatsEvent");

    /* renamed from: a  reason: collision with root package name */
    public static final iy f41337a = new iy("", (byte) 3, 1);

    /* renamed from: b  reason: collision with root package name */
    public static final iy f41338b = new iy("", (byte) 8, 2);

    /* renamed from: c  reason: collision with root package name */
    public static final iy f41339c = new iy("", (byte) 8, 3);

    /* renamed from: d  reason: collision with root package name */
    public static final iy f41340d = new iy("", (byte) 11, 4);

    /* renamed from: e  reason: collision with root package name */
    public static final iy f41341e = new iy("", (byte) 11, 5);

    /* renamed from: f  reason: collision with root package name */
    public static final iy f41342f = new iy("", (byte) 8, 6);

    /* renamed from: g  reason: collision with root package name */
    public static final iy f41343g = new iy("", (byte) 11, 7);

    /* renamed from: h  reason: collision with root package name */
    public static final iy f41344h = new iy("", (byte) 11, 8);

    /* renamed from: i  reason: collision with root package name */
    public static final iy f41345i = new iy("", (byte) 8, 9);
    public static final iy j = new iy("", (byte) 8, 10);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(ex exVar) {
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
        if (ex.class.equals(exVar.getClass())) {
            int compareTo = Boolean.valueOf(m284a()).compareTo(Boolean.valueOf(exVar.m284a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m284a() || (a11 = ir.a(this.f341a, exVar.f341a)) == 0) {
                int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(exVar.b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!b() || (a10 = ir.a(this.f342a, exVar.f342a)) == 0) {
                    int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(exVar.c()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!c() || (a9 = ir.a(this.f345b, exVar.f345b)) == 0) {
                        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(exVar.d()));
                        if (compareTo4 != 0) {
                            return compareTo4;
                        }
                        if (!d() || (a8 = ir.a(this.f343a, exVar.f343a)) == 0) {
                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(exVar.e()));
                            if (compareTo5 != 0) {
                                return compareTo5;
                            }
                            if (!e() || (a7 = ir.a(this.f346b, exVar.f346b)) == 0) {
                                int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(exVar.f()));
                                if (compareTo6 != 0) {
                                    return compareTo6;
                                }
                                if (!f() || (a6 = ir.a(this.f347c, exVar.f347c)) == 0) {
                                    int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(exVar.g()));
                                    if (compareTo7 != 0) {
                                        return compareTo7;
                                    }
                                    if (!g() || (a5 = ir.a(this.f348c, exVar.f348c)) == 0) {
                                        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(exVar.h()));
                                        if (compareTo8 != 0) {
                                            return compareTo8;
                                        }
                                        if (!h() || (a4 = ir.a(this.f350d, exVar.f350d)) == 0) {
                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(exVar.i()));
                                            if (compareTo9 != 0) {
                                                return compareTo9;
                                            }
                                            if (!i() || (a3 = ir.a(this.f349d, exVar.f349d)) == 0) {
                                                int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(exVar.j()));
                                                if (compareTo10 != 0) {
                                                    return compareTo10;
                                                }
                                                if (!j() || (a2 = ir.a(this.f351e, exVar.f351e)) == 0) {
                                                    return 0;
                                                }
                                                return a2;
                                            }
                                            return a3;
                                        }
                                        return a4;
                                    }
                                    return a5;
                                }
                                return a6;
                            }
                            return a7;
                        }
                        return a8;
                    }
                    return a9;
                }
                return a10;
            }
            return a11;
        }
        return ex.class.getName().compareTo(exVar.getClass().getName());
    }

    public ex a(byte b2) {
        this.f341a = b2;
        a(true);
        return this;
    }

    public ex a(int i2) {
        this.f342a = i2;
        b(true);
        return this;
    }

    public ex a(String str) {
        this.f343a = str;
        return this;
    }

    public void a() {
        if (this.f343a != null) {
            return;
        }
        throw new jc("Required field 'connpt' was not present! Struct: " + toString());
    }

    @Override // com.xiaomi.push.iq
    public void a(jb jbVar) {
        jbVar.m510a();
        while (true) {
            iy m506a = jbVar.m506a();
            byte b2 = m506a.f41751a;
            if (b2 == 0) {
                jbVar.f();
                if (!m284a()) {
                    throw new jc("Required field 'chid' was not found in serialized data! Struct: " + toString());
                } else if (!b()) {
                    throw new jc("Required field 'type' was not found in serialized data! Struct: " + toString());
                } else if (c()) {
                    a();
                    return;
                } else {
                    throw new jc("Required field 'value' was not found in serialized data! Struct: " + toString());
                }
            }
            switch (m506a.f807a) {
                case 1:
                    if (b2 == 3) {
                        this.f341a = jbVar.a();
                        a(true);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 2:
                    if (b2 == 8) {
                        this.f342a = jbVar.m504a();
                        b(true);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 3:
                    if (b2 == 8) {
                        this.f345b = jbVar.m504a();
                        c(true);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f343a = jbVar.m511a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 5:
                    if (b2 == 11) {
                        this.f346b = jbVar.m511a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 6:
                    if (b2 == 8) {
                        this.f347c = jbVar.m504a();
                        d(true);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f348c = jbVar.m511a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 8:
                    if (b2 == 11) {
                        this.f350d = jbVar.m511a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 9:
                    if (b2 == 8) {
                        this.f349d = jbVar.m504a();
                        e(true);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 10:
                    if (b2 == 8) {
                        this.f351e = jbVar.m504a();
                        f(true);
                        continue;
                        jbVar.g();
                    }
                    break;
            }
            je.a(jbVar, b2);
            jbVar.g();
        }
    }

    public void a(boolean z) {
        this.f344a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m284a() {
        return this.f344a.get(0);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m285a(ex exVar) {
        if (exVar != null && this.f341a == exVar.f341a && this.f342a == exVar.f342a && this.f345b == exVar.f345b) {
            boolean d2 = d();
            boolean d3 = exVar.d();
            if ((d2 || d3) && !(d2 && d3 && this.f343a.equals(exVar.f343a))) {
                return false;
            }
            boolean e2 = e();
            boolean e3 = exVar.e();
            if ((e2 || e3) && !(e2 && e3 && this.f346b.equals(exVar.f346b))) {
                return false;
            }
            boolean f2 = f();
            boolean f3 = exVar.f();
            if ((f2 || f3) && !(f2 && f3 && this.f347c == exVar.f347c)) {
                return false;
            }
            boolean g2 = g();
            boolean g3 = exVar.g();
            if ((g2 || g3) && !(g2 && g3 && this.f348c.equals(exVar.f348c))) {
                return false;
            }
            boolean h2 = h();
            boolean h3 = exVar.h();
            if ((h2 || h3) && !(h2 && h3 && this.f350d.equals(exVar.f350d))) {
                return false;
            }
            boolean i2 = i();
            boolean i3 = exVar.i();
            if ((i2 || i3) && !(i2 && i3 && this.f349d == exVar.f349d)) {
                return false;
            }
            boolean j2 = j();
            boolean j3 = exVar.j();
            if (j2 || j3) {
                return j2 && j3 && this.f351e == exVar.f351e;
            }
            return true;
        }
        return false;
    }

    public ex b(int i2) {
        this.f345b = i2;
        c(true);
        return this;
    }

    public ex b(String str) {
        this.f346b = str;
        return this;
    }

    @Override // com.xiaomi.push.iq
    public void b(jb jbVar) {
        a();
        jbVar.a(f340a);
        jbVar.a(f41337a);
        jbVar.a(this.f341a);
        jbVar.b();
        jbVar.a(f41338b);
        jbVar.a(this.f342a);
        jbVar.b();
        jbVar.a(f41339c);
        jbVar.a(this.f345b);
        jbVar.b();
        if (this.f343a != null) {
            jbVar.a(f41340d);
            jbVar.a(this.f343a);
            jbVar.b();
        }
        if (this.f346b != null && e()) {
            jbVar.a(f41341e);
            jbVar.a(this.f346b);
            jbVar.b();
        }
        if (f()) {
            jbVar.a(f41342f);
            jbVar.a(this.f347c);
            jbVar.b();
        }
        if (this.f348c != null && g()) {
            jbVar.a(f41343g);
            jbVar.a(this.f348c);
            jbVar.b();
        }
        if (this.f350d != null && h()) {
            jbVar.a(f41344h);
            jbVar.a(this.f350d);
            jbVar.b();
        }
        if (i()) {
            jbVar.a(f41345i);
            jbVar.a(this.f349d);
            jbVar.b();
        }
        if (j()) {
            jbVar.a(j);
            jbVar.a(this.f351e);
            jbVar.b();
        }
        jbVar.c();
        jbVar.m514a();
    }

    public void b(boolean z) {
        this.f344a.set(1, z);
    }

    public boolean b() {
        return this.f344a.get(1);
    }

    public ex c(int i2) {
        this.f347c = i2;
        d(true);
        return this;
    }

    public ex c(String str) {
        this.f348c = str;
        return this;
    }

    public void c(boolean z) {
        this.f344a.set(2, z);
    }

    public boolean c() {
        return this.f344a.get(2);
    }

    public ex d(int i2) {
        this.f349d = i2;
        e(true);
        return this;
    }

    public ex d(String str) {
        this.f350d = str;
        return this;
    }

    public void d(boolean z) {
        this.f344a.set(3, z);
    }

    public boolean d() {
        return this.f343a != null;
    }

    public void e(boolean z) {
        this.f344a.set(4, z);
    }

    public boolean e() {
        return this.f346b != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ex)) {
            return m285a((ex) obj);
        }
        return false;
    }

    public void f(boolean z) {
        this.f344a.set(5, z);
    }

    public boolean f() {
        return this.f344a.get(3);
    }

    public boolean g() {
        return this.f348c != null;
    }

    public boolean h() {
        return this.f350d != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f344a.get(4);
    }

    public boolean j() {
        return this.f344a.get(5);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("StatsEvent(");
        sb.append("chid:");
        sb.append((int) this.f341a);
        sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        sb.append("type:");
        sb.append(this.f342a);
        sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        sb.append("value:");
        sb.append(this.f345b);
        sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        sb.append("connpt:");
        String str = this.f343a;
        if (str == null) {
            sb.append(StringUtil.NULL_STRING);
        } else {
            sb.append(str);
        }
        if (e()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("host:");
            String str2 = this.f346b;
            if (str2 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str2);
            }
        }
        if (f()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("subvalue:");
            sb.append(this.f347c);
        }
        if (g()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("annotation:");
            String str3 = this.f348c;
            if (str3 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str3);
            }
        }
        if (h()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("user:");
            String str4 = this.f350d;
            if (str4 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str4);
            }
        }
        if (i()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("time:");
            sb.append(this.f349d);
        }
        if (j()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("clientIp:");
            sb.append(this.f351e);
        }
        sb.append(SmallTailInfo.EMOTION_SUFFIX);
        return sb.toString();
    }
}
