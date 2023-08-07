package com.xiaomi.push;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes10.dex */
public class ez implements is<ez, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public byte f340a;

    /* renamed from: a  reason: collision with other field name */
    public int f341a;

    /* renamed from: a  reason: collision with other field name */
    public String f342a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f343a = new BitSet(6);

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
    public static final ji f339a = new ji("StatsEvent");
    public static final ja a = new ja("", (byte) 3, 1);
    public static final ja b = new ja("", (byte) 8, 2);
    public static final ja c = new ja("", (byte) 8, 3);
    public static final ja d = new ja("", Constants.GZIP_CAST_TYPE, 4);
    public static final ja e = new ja("", Constants.GZIP_CAST_TYPE, 5);
    public static final ja f = new ja("", (byte) 8, 6);
    public static final ja g = new ja("", Constants.GZIP_CAST_TYPE, 7);
    public static final ja h = new ja("", Constants.GZIP_CAST_TYPE, 8);
    public static final ja i = new ja("", (byte) 8, 9);
    public static final ja j = new ja("", (byte) 8, 10);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(ez ezVar) {
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
        if (ez.class.equals(ezVar.getClass())) {
            int compareTo = Boolean.valueOf(m466a()).compareTo(Boolean.valueOf(ezVar.m466a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m466a() || (a11 = it.a(this.f340a, ezVar.f340a)) == 0) {
                int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(ezVar.b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!b() || (a10 = it.a(this.f341a, ezVar.f341a)) == 0) {
                    int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(ezVar.c()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!c() || (a9 = it.a(this.f344b, ezVar.f344b)) == 0) {
                        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(ezVar.d()));
                        if (compareTo4 != 0) {
                            return compareTo4;
                        }
                        if (!d() || (a8 = it.a(this.f342a, ezVar.f342a)) == 0) {
                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(ezVar.e()));
                            if (compareTo5 != 0) {
                                return compareTo5;
                            }
                            if (!e() || (a7 = it.a(this.f345b, ezVar.f345b)) == 0) {
                                int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(ezVar.f()));
                                if (compareTo6 != 0) {
                                    return compareTo6;
                                }
                                if (!f() || (a6 = it.a(this.f346c, ezVar.f346c)) == 0) {
                                    int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ezVar.g()));
                                    if (compareTo7 != 0) {
                                        return compareTo7;
                                    }
                                    if (!g() || (a5 = it.a(this.f347c, ezVar.f347c)) == 0) {
                                        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(ezVar.h()));
                                        if (compareTo8 != 0) {
                                            return compareTo8;
                                        }
                                        if (!h() || (a4 = it.a(this.f349d, ezVar.f349d)) == 0) {
                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(ezVar.i()));
                                            if (compareTo9 != 0) {
                                                return compareTo9;
                                            }
                                            if (!i() || (a3 = it.a(this.f348d, ezVar.f348d)) == 0) {
                                                int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(ezVar.j()));
                                                if (compareTo10 != 0) {
                                                    return compareTo10;
                                                }
                                                if (!j() || (a2 = it.a(this.f350e, ezVar.f350e)) == 0) {
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
        return ez.class.getName().compareTo(ezVar.getClass().getName());
    }

    public ez a(byte b2) {
        this.f340a = b2;
        a(true);
        return this;
    }

    public ez a(int i2) {
        this.f341a = i2;
        b(true);
        return this;
    }

    public ez a(String str) {
        this.f342a = str;
        return this;
    }

    public void a() {
        if (this.f342a != null) {
            return;
        }
        throw new je("Required field 'connpt' was not present! Struct: " + toString());
    }

    @Override // com.xiaomi.push.is
    public void a(jd jdVar) {
        jdVar.mo698a();
        while (true) {
            ja mo694a = jdVar.mo694a();
            byte b2 = mo694a.a;
            if (b2 == 0) {
                jdVar.f();
                if (!m466a()) {
                    throw new je("Required field 'chid' was not found in serialized data! Struct: " + toString());
                } else if (!b()) {
                    throw new je("Required field 'type' was not found in serialized data! Struct: " + toString());
                } else if (c()) {
                    a();
                    return;
                } else {
                    throw new je("Required field 'value' was not found in serialized data! Struct: " + toString());
                }
            }
            switch (mo694a.f813a) {
                case 1:
                    if (b2 == 3) {
                        this.f340a = jdVar.a();
                        a(true);
                        continue;
                        jdVar.g();
                    }
                    break;
                case 2:
                    if (b2 == 8) {
                        this.f341a = jdVar.mo692a();
                        b(true);
                        continue;
                        jdVar.g();
                    }
                    break;
                case 3:
                    if (b2 == 8) {
                        this.f344b = jdVar.mo692a();
                        c(true);
                        continue;
                        jdVar.g();
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f342a = jdVar.mo699a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 5:
                    if (b2 == 11) {
                        this.f345b = jdVar.mo699a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 6:
                    if (b2 == 8) {
                        this.f346c = jdVar.mo692a();
                        d(true);
                        continue;
                        jdVar.g();
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f347c = jdVar.mo699a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 8:
                    if (b2 == 11) {
                        this.f349d = jdVar.mo699a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 9:
                    if (b2 == 8) {
                        this.f348d = jdVar.mo692a();
                        e(true);
                        continue;
                        jdVar.g();
                    }
                    break;
                case 10:
                    if (b2 == 8) {
                        this.f350e = jdVar.mo692a();
                        f(true);
                        continue;
                        jdVar.g();
                    }
                    break;
            }
            jg.a(jdVar, b2);
            jdVar.g();
        }
    }

    public void a(boolean z) {
        this.f343a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m466a() {
        return this.f343a.get(0);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m467a(ez ezVar) {
        if (ezVar != null && this.f340a == ezVar.f340a && this.f341a == ezVar.f341a && this.f344b == ezVar.f344b) {
            boolean d2 = d();
            boolean d3 = ezVar.d();
            if ((d2 || d3) && !(d2 && d3 && this.f342a.equals(ezVar.f342a))) {
                return false;
            }
            boolean e2 = e();
            boolean e3 = ezVar.e();
            if ((e2 || e3) && !(e2 && e3 && this.f345b.equals(ezVar.f345b))) {
                return false;
            }
            boolean f2 = f();
            boolean f3 = ezVar.f();
            if ((f2 || f3) && !(f2 && f3 && this.f346c == ezVar.f346c)) {
                return false;
            }
            boolean g2 = g();
            boolean g3 = ezVar.g();
            if ((g2 || g3) && !(g2 && g3 && this.f347c.equals(ezVar.f347c))) {
                return false;
            }
            boolean h2 = h();
            boolean h3 = ezVar.h();
            if ((h2 || h3) && !(h2 && h3 && this.f349d.equals(ezVar.f349d))) {
                return false;
            }
            boolean i2 = i();
            boolean i3 = ezVar.i();
            if ((i2 || i3) && !(i2 && i3 && this.f348d == ezVar.f348d)) {
                return false;
            }
            boolean j2 = j();
            boolean j3 = ezVar.j();
            if (j2 || j3) {
                return j2 && j3 && this.f350e == ezVar.f350e;
            }
            return true;
        }
        return false;
    }

    public ez b(int i2) {
        this.f344b = i2;
        c(true);
        return this;
    }

    public ez b(String str) {
        this.f345b = str;
        return this;
    }

    @Override // com.xiaomi.push.is
    public void b(jd jdVar) {
        a();
        jdVar.a(f339a);
        jdVar.a(a);
        jdVar.a(this.f340a);
        jdVar.b();
        jdVar.a(b);
        jdVar.mo703a(this.f341a);
        jdVar.b();
        jdVar.a(c);
        jdVar.mo703a(this.f344b);
        jdVar.b();
        if (this.f342a != null) {
            jdVar.a(d);
            jdVar.a(this.f342a);
            jdVar.b();
        }
        if (this.f345b != null && e()) {
            jdVar.a(e);
            jdVar.a(this.f345b);
            jdVar.b();
        }
        if (f()) {
            jdVar.a(f);
            jdVar.mo703a(this.f346c);
            jdVar.b();
        }
        if (this.f347c != null && g()) {
            jdVar.a(g);
            jdVar.a(this.f347c);
            jdVar.b();
        }
        if (this.f349d != null && h()) {
            jdVar.a(h);
            jdVar.a(this.f349d);
            jdVar.b();
        }
        if (i()) {
            jdVar.a(i);
            jdVar.mo703a(this.f348d);
            jdVar.b();
        }
        if (j()) {
            jdVar.a(j);
            jdVar.mo703a(this.f350e);
            jdVar.b();
        }
        jdVar.c();
        jdVar.mo702a();
    }

    public void b(boolean z) {
        this.f343a.set(1, z);
    }

    public boolean b() {
        return this.f343a.get(1);
    }

    public ez c(int i2) {
        this.f346c = i2;
        d(true);
        return this;
    }

    public ez c(String str) {
        this.f347c = str;
        return this;
    }

    public void c(boolean z) {
        this.f343a.set(2, z);
    }

    public boolean c() {
        return this.f343a.get(2);
    }

    public ez d(int i2) {
        this.f348d = i2;
        e(true);
        return this;
    }

    public ez d(String str) {
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
        if (obj != null && (obj instanceof ez)) {
            return m467a((ez) obj);
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
        sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        sb.append("type:");
        sb.append(this.f341a);
        sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        sb.append("value:");
        sb.append(this.f344b);
        sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        sb.append("connpt:");
        String str = this.f342a;
        if (str == null) {
            sb.append(StringUtil.NULL_STRING);
        } else {
            sb.append(str);
        }
        if (e()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("host:");
            String str2 = this.f345b;
            if (str2 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str2);
            }
        }
        if (f()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("subvalue:");
            sb.append(this.f346c);
        }
        if (g()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("annotation:");
            String str3 = this.f347c;
            if (str3 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str3);
            }
        }
        if (h()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("user:");
            String str4 = this.f349d;
            if (str4 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str4);
            }
        }
        if (i()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("time:");
            sb.append(this.f348d);
        }
        if (j()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("clientIp:");
            sb.append(this.f350e);
        }
        sb.append(SmallTailInfo.EMOTION_SUFFIX);
        return sb.toString();
    }
}
