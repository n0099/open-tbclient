package com.xiaomi.push;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes10.dex */
public class ez implements is<ez, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public byte f336a;

    /* renamed from: a  reason: collision with other field name */
    public int f337a;

    /* renamed from: a  reason: collision with other field name */
    public String f338a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f339a = new BitSet(6);

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
    public static final ji f335a = new ji("StatsEvent");
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
            int compareTo = Boolean.valueOf(m478a()).compareTo(Boolean.valueOf(ezVar.m478a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m478a() || (a11 = it.a(this.f336a, ezVar.f336a)) == 0) {
                int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(ezVar.b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!b() || (a10 = it.a(this.f337a, ezVar.f337a)) == 0) {
                    int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(ezVar.c()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!c() || (a9 = it.a(this.f340b, ezVar.f340b)) == 0) {
                        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(ezVar.d()));
                        if (compareTo4 != 0) {
                            return compareTo4;
                        }
                        if (!d() || (a8 = it.a(this.f338a, ezVar.f338a)) == 0) {
                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(ezVar.e()));
                            if (compareTo5 != 0) {
                                return compareTo5;
                            }
                            if (!e() || (a7 = it.a(this.f341b, ezVar.f341b)) == 0) {
                                int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(ezVar.f()));
                                if (compareTo6 != 0) {
                                    return compareTo6;
                                }
                                if (!f() || (a6 = it.a(this.f342c, ezVar.f342c)) == 0) {
                                    int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ezVar.g()));
                                    if (compareTo7 != 0) {
                                        return compareTo7;
                                    }
                                    if (!g() || (a5 = it.a(this.f343c, ezVar.f343c)) == 0) {
                                        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(ezVar.h()));
                                        if (compareTo8 != 0) {
                                            return compareTo8;
                                        }
                                        if (!h() || (a4 = it.a(this.f345d, ezVar.f345d)) == 0) {
                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(ezVar.i()));
                                            if (compareTo9 != 0) {
                                                return compareTo9;
                                            }
                                            if (!i() || (a3 = it.a(this.f344d, ezVar.f344d)) == 0) {
                                                int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(ezVar.j()));
                                                if (compareTo10 != 0) {
                                                    return compareTo10;
                                                }
                                                if (!j() || (a2 = it.a(this.f346e, ezVar.f346e)) == 0) {
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
        this.f336a = b2;
        a(true);
        return this;
    }

    public ez a(int i2) {
        this.f337a = i2;
        b(true);
        return this;
    }

    public ez a(String str) {
        this.f338a = str;
        return this;
    }

    public void a() {
        if (this.f338a != null) {
            return;
        }
        throw new je("Required field 'connpt' was not present! Struct: " + toString());
    }

    @Override // com.xiaomi.push.is
    public void a(jd jdVar) {
        jdVar.mo710a();
        while (true) {
            ja mo706a = jdVar.mo706a();
            byte b2 = mo706a.a;
            if (b2 == 0) {
                jdVar.f();
                if (!m478a()) {
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
            switch (mo706a.f809a) {
                case 1:
                    if (b2 == 3) {
                        this.f336a = jdVar.a();
                        a(true);
                        continue;
                        jdVar.g();
                    }
                    break;
                case 2:
                    if (b2 == 8) {
                        this.f337a = jdVar.mo704a();
                        b(true);
                        continue;
                        jdVar.g();
                    }
                    break;
                case 3:
                    if (b2 == 8) {
                        this.f340b = jdVar.mo704a();
                        c(true);
                        continue;
                        jdVar.g();
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f338a = jdVar.mo711a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 5:
                    if (b2 == 11) {
                        this.f341b = jdVar.mo711a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 6:
                    if (b2 == 8) {
                        this.f342c = jdVar.mo704a();
                        d(true);
                        continue;
                        jdVar.g();
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f343c = jdVar.mo711a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 8:
                    if (b2 == 11) {
                        this.f345d = jdVar.mo711a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 9:
                    if (b2 == 8) {
                        this.f344d = jdVar.mo704a();
                        e(true);
                        continue;
                        jdVar.g();
                    }
                    break;
                case 10:
                    if (b2 == 8) {
                        this.f346e = jdVar.mo704a();
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
        this.f339a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m478a() {
        return this.f339a.get(0);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m479a(ez ezVar) {
        if (ezVar != null && this.f336a == ezVar.f336a && this.f337a == ezVar.f337a && this.f340b == ezVar.f340b) {
            boolean d2 = d();
            boolean d3 = ezVar.d();
            if ((d2 || d3) && !(d2 && d3 && this.f338a.equals(ezVar.f338a))) {
                return false;
            }
            boolean e2 = e();
            boolean e3 = ezVar.e();
            if ((e2 || e3) && !(e2 && e3 && this.f341b.equals(ezVar.f341b))) {
                return false;
            }
            boolean f2 = f();
            boolean f3 = ezVar.f();
            if ((f2 || f3) && !(f2 && f3 && this.f342c == ezVar.f342c)) {
                return false;
            }
            boolean g2 = g();
            boolean g3 = ezVar.g();
            if ((g2 || g3) && !(g2 && g3 && this.f343c.equals(ezVar.f343c))) {
                return false;
            }
            boolean h2 = h();
            boolean h3 = ezVar.h();
            if ((h2 || h3) && !(h2 && h3 && this.f345d.equals(ezVar.f345d))) {
                return false;
            }
            boolean i2 = i();
            boolean i3 = ezVar.i();
            if ((i2 || i3) && !(i2 && i3 && this.f344d == ezVar.f344d)) {
                return false;
            }
            boolean j2 = j();
            boolean j3 = ezVar.j();
            if (j2 || j3) {
                return j2 && j3 && this.f346e == ezVar.f346e;
            }
            return true;
        }
        return false;
    }

    public ez b(int i2) {
        this.f340b = i2;
        c(true);
        return this;
    }

    public ez b(String str) {
        this.f341b = str;
        return this;
    }

    @Override // com.xiaomi.push.is
    public void b(jd jdVar) {
        a();
        jdVar.a(f335a);
        jdVar.a(a);
        jdVar.a(this.f336a);
        jdVar.b();
        jdVar.a(b);
        jdVar.mo715a(this.f337a);
        jdVar.b();
        jdVar.a(c);
        jdVar.mo715a(this.f340b);
        jdVar.b();
        if (this.f338a != null) {
            jdVar.a(d);
            jdVar.a(this.f338a);
            jdVar.b();
        }
        if (this.f341b != null && e()) {
            jdVar.a(e);
            jdVar.a(this.f341b);
            jdVar.b();
        }
        if (f()) {
            jdVar.a(f);
            jdVar.mo715a(this.f342c);
            jdVar.b();
        }
        if (this.f343c != null && g()) {
            jdVar.a(g);
            jdVar.a(this.f343c);
            jdVar.b();
        }
        if (this.f345d != null && h()) {
            jdVar.a(h);
            jdVar.a(this.f345d);
            jdVar.b();
        }
        if (i()) {
            jdVar.a(i);
            jdVar.mo715a(this.f344d);
            jdVar.b();
        }
        if (j()) {
            jdVar.a(j);
            jdVar.mo715a(this.f346e);
            jdVar.b();
        }
        jdVar.c();
        jdVar.mo714a();
    }

    public void b(boolean z) {
        this.f339a.set(1, z);
    }

    public boolean b() {
        return this.f339a.get(1);
    }

    public ez c(int i2) {
        this.f342c = i2;
        d(true);
        return this;
    }

    public ez c(String str) {
        this.f343c = str;
        return this;
    }

    public void c(boolean z) {
        this.f339a.set(2, z);
    }

    public boolean c() {
        return this.f339a.get(2);
    }

    public ez d(int i2) {
        this.f344d = i2;
        e(true);
        return this;
    }

    public ez d(String str) {
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
        if (obj != null && (obj instanceof ez)) {
            return m479a((ez) obj);
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
        sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        sb.append("type:");
        sb.append(this.f337a);
        sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        sb.append("value:");
        sb.append(this.f340b);
        sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        sb.append("connpt:");
        String str = this.f338a;
        if (str == null) {
            sb.append(StringUtil.NULL_STRING);
        } else {
            sb.append(str);
        }
        if (e()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("host:");
            String str2 = this.f341b;
            if (str2 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str2);
            }
        }
        if (f()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("subvalue:");
            sb.append(this.f342c);
        }
        if (g()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("annotation:");
            String str3 = this.f343c;
            if (str3 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str3);
            }
        }
        if (h()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("user:");
            String str4 = this.f345d;
            if (str4 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str4);
            }
        }
        if (i()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("time:");
            sb.append(this.f344d);
        }
        if (j()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("clientIp:");
            sb.append(this.f346e);
        }
        sb.append(SmallTailInfo.EMOTION_SUFFIX);
        return sb.toString();
    }
}
