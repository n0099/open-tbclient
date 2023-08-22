package com.xiaomi.push;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes10.dex */
public class ez implements is<ez, Object>, Serializable, Cloneable {

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
    public static final ji f340a = new ji("StatsEvent");
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
            int compareTo = Boolean.valueOf(m468a()).compareTo(Boolean.valueOf(ezVar.m468a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m468a() || (a11 = it.a(this.f341a, ezVar.f341a)) == 0) {
                int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(ezVar.b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!b() || (a10 = it.a(this.f342a, ezVar.f342a)) == 0) {
                    int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(ezVar.c()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!c() || (a9 = it.a(this.f345b, ezVar.f345b)) == 0) {
                        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(ezVar.d()));
                        if (compareTo4 != 0) {
                            return compareTo4;
                        }
                        if (!d() || (a8 = it.a(this.f343a, ezVar.f343a)) == 0) {
                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(ezVar.e()));
                            if (compareTo5 != 0) {
                                return compareTo5;
                            }
                            if (!e() || (a7 = it.a(this.f346b, ezVar.f346b)) == 0) {
                                int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(ezVar.f()));
                                if (compareTo6 != 0) {
                                    return compareTo6;
                                }
                                if (!f() || (a6 = it.a(this.f347c, ezVar.f347c)) == 0) {
                                    int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ezVar.g()));
                                    if (compareTo7 != 0) {
                                        return compareTo7;
                                    }
                                    if (!g() || (a5 = it.a(this.f348c, ezVar.f348c)) == 0) {
                                        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(ezVar.h()));
                                        if (compareTo8 != 0) {
                                            return compareTo8;
                                        }
                                        if (!h() || (a4 = it.a(this.f350d, ezVar.f350d)) == 0) {
                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(ezVar.i()));
                                            if (compareTo9 != 0) {
                                                return compareTo9;
                                            }
                                            if (!i() || (a3 = it.a(this.f349d, ezVar.f349d)) == 0) {
                                                int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(ezVar.j()));
                                                if (compareTo10 != 0) {
                                                    return compareTo10;
                                                }
                                                if (!j() || (a2 = it.a(this.f351e, ezVar.f351e)) == 0) {
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
        this.f341a = b2;
        a(true);
        return this;
    }

    public ez a(int i2) {
        this.f342a = i2;
        b(true);
        return this;
    }

    public ez a(String str) {
        this.f343a = str;
        return this;
    }

    public void a() {
        if (this.f343a != null) {
            return;
        }
        throw new je("Required field 'connpt' was not present! Struct: " + toString());
    }

    @Override // com.xiaomi.push.is
    public void a(jd jdVar) {
        jdVar.mo700a();
        while (true) {
            ja mo696a = jdVar.mo696a();
            byte b2 = mo696a.a;
            if (b2 == 0) {
                jdVar.f();
                if (!m468a()) {
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
            switch (mo696a.f814a) {
                case 1:
                    if (b2 == 3) {
                        this.f341a = jdVar.a();
                        a(true);
                        continue;
                        jdVar.g();
                    }
                    break;
                case 2:
                    if (b2 == 8) {
                        this.f342a = jdVar.mo694a();
                        b(true);
                        continue;
                        jdVar.g();
                    }
                    break;
                case 3:
                    if (b2 == 8) {
                        this.f345b = jdVar.mo694a();
                        c(true);
                        continue;
                        jdVar.g();
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f343a = jdVar.mo701a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 5:
                    if (b2 == 11) {
                        this.f346b = jdVar.mo701a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 6:
                    if (b2 == 8) {
                        this.f347c = jdVar.mo694a();
                        d(true);
                        continue;
                        jdVar.g();
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f348c = jdVar.mo701a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 8:
                    if (b2 == 11) {
                        this.f350d = jdVar.mo701a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 9:
                    if (b2 == 8) {
                        this.f349d = jdVar.mo694a();
                        e(true);
                        continue;
                        jdVar.g();
                    }
                    break;
                case 10:
                    if (b2 == 8) {
                        this.f351e = jdVar.mo694a();
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
        this.f344a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m468a() {
        return this.f344a.get(0);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m469a(ez ezVar) {
        if (ezVar != null && this.f341a == ezVar.f341a && this.f342a == ezVar.f342a && this.f345b == ezVar.f345b) {
            boolean d2 = d();
            boolean d3 = ezVar.d();
            if ((d2 || d3) && !(d2 && d3 && this.f343a.equals(ezVar.f343a))) {
                return false;
            }
            boolean e2 = e();
            boolean e3 = ezVar.e();
            if ((e2 || e3) && !(e2 && e3 && this.f346b.equals(ezVar.f346b))) {
                return false;
            }
            boolean f2 = f();
            boolean f3 = ezVar.f();
            if ((f2 || f3) && !(f2 && f3 && this.f347c == ezVar.f347c)) {
                return false;
            }
            boolean g2 = g();
            boolean g3 = ezVar.g();
            if ((g2 || g3) && !(g2 && g3 && this.f348c.equals(ezVar.f348c))) {
                return false;
            }
            boolean h2 = h();
            boolean h3 = ezVar.h();
            if ((h2 || h3) && !(h2 && h3 && this.f350d.equals(ezVar.f350d))) {
                return false;
            }
            boolean i2 = i();
            boolean i3 = ezVar.i();
            if ((i2 || i3) && !(i2 && i3 && this.f349d == ezVar.f349d)) {
                return false;
            }
            boolean j2 = j();
            boolean j3 = ezVar.j();
            if (j2 || j3) {
                return j2 && j3 && this.f351e == ezVar.f351e;
            }
            return true;
        }
        return false;
    }

    public ez b(int i2) {
        this.f345b = i2;
        c(true);
        return this;
    }

    public ez b(String str) {
        this.f346b = str;
        return this;
    }

    @Override // com.xiaomi.push.is
    public void b(jd jdVar) {
        a();
        jdVar.a(f340a);
        jdVar.a(a);
        jdVar.a(this.f341a);
        jdVar.b();
        jdVar.a(b);
        jdVar.mo705a(this.f342a);
        jdVar.b();
        jdVar.a(c);
        jdVar.mo705a(this.f345b);
        jdVar.b();
        if (this.f343a != null) {
            jdVar.a(d);
            jdVar.a(this.f343a);
            jdVar.b();
        }
        if (this.f346b != null && e()) {
            jdVar.a(e);
            jdVar.a(this.f346b);
            jdVar.b();
        }
        if (f()) {
            jdVar.a(f);
            jdVar.mo705a(this.f347c);
            jdVar.b();
        }
        if (this.f348c != null && g()) {
            jdVar.a(g);
            jdVar.a(this.f348c);
            jdVar.b();
        }
        if (this.f350d != null && h()) {
            jdVar.a(h);
            jdVar.a(this.f350d);
            jdVar.b();
        }
        if (i()) {
            jdVar.a(i);
            jdVar.mo705a(this.f349d);
            jdVar.b();
        }
        if (j()) {
            jdVar.a(j);
            jdVar.mo705a(this.f351e);
            jdVar.b();
        }
        jdVar.c();
        jdVar.mo704a();
    }

    public void b(boolean z) {
        this.f344a.set(1, z);
    }

    public boolean b() {
        return this.f344a.get(1);
    }

    public ez c(int i2) {
        this.f347c = i2;
        d(true);
        return this;
    }

    public ez c(String str) {
        this.f348c = str;
        return this;
    }

    public void c(boolean z) {
        this.f344a.set(2, z);
    }

    public boolean c() {
        return this.f344a.get(2);
    }

    public ez d(int i2) {
        this.f349d = i2;
        e(true);
        return this;
    }

    public ez d(String str) {
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
        if (obj != null && (obj instanceof ez)) {
            return m469a((ez) obj);
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
