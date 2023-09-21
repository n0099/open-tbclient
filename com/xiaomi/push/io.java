package com.xiaomi.push;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes10.dex */
public class io implements is<io, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f772a;

    /* renamed from: a  reason: collision with other field name */
    public hw f773a;

    /* renamed from: a  reason: collision with other field name */
    public String f774a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f775a = new BitSet(3);

    /* renamed from: b  reason: collision with other field name */
    public long f776b;

    /* renamed from: b  reason: collision with other field name */
    public String f777b;

    /* renamed from: c  reason: collision with other field name */
    public long f778c;

    /* renamed from: c  reason: collision with other field name */
    public String f779c;

    /* renamed from: d  reason: collision with other field name */
    public String f780d;

    /* renamed from: e  reason: collision with other field name */
    public String f781e;

    /* renamed from: a  reason: collision with other field name */
    public static final ji f771a = new ji("XmPushActionUnRegistrationResult");
    public static final ja a = new ja("", Constants.GZIP_CAST_TYPE, 1);
    public static final ja b = new ja("", (byte) 12, 2);
    public static final ja c = new ja("", Constants.GZIP_CAST_TYPE, 3);
    public static final ja d = new ja("", Constants.GZIP_CAST_TYPE, 4);
    public static final ja e = new ja("", (byte) 10, 6);
    public static final ja f = new ja("", Constants.GZIP_CAST_TYPE, 7);
    public static final ja g = new ja("", Constants.GZIP_CAST_TYPE, 8);
    public static final ja h = new ja("", (byte) 10, 9);
    public static final ja i = new ja("", (byte) 10, 10);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(io ioVar) {
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        int a8;
        int a9;
        int a10;
        if (io.class.equals(ioVar.getClass())) {
            int compareTo = Boolean.valueOf(m684a()).compareTo(Boolean.valueOf(ioVar.m684a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m684a() || (a10 = it.a(this.f774a, ioVar.f774a)) == 0) {
                int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(ioVar.b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!b() || (a9 = it.a(this.f773a, ioVar.f773a)) == 0) {
                    int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(ioVar.c()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!c() || (a8 = it.a(this.f777b, ioVar.f777b)) == 0) {
                        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(ioVar.d()));
                        if (compareTo4 != 0) {
                            return compareTo4;
                        }
                        if (!d() || (a7 = it.a(this.f779c, ioVar.f779c)) == 0) {
                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(ioVar.e()));
                            if (compareTo5 != 0) {
                                return compareTo5;
                            }
                            if (!e() || (a6 = it.a(this.f772a, ioVar.f772a)) == 0) {
                                int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(ioVar.f()));
                                if (compareTo6 != 0) {
                                    return compareTo6;
                                }
                                if (!f() || (a5 = it.a(this.f780d, ioVar.f780d)) == 0) {
                                    int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ioVar.g()));
                                    if (compareTo7 != 0) {
                                        return compareTo7;
                                    }
                                    if (!g() || (a4 = it.a(this.f781e, ioVar.f781e)) == 0) {
                                        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(ioVar.h()));
                                        if (compareTo8 != 0) {
                                            return compareTo8;
                                        }
                                        if (!h() || (a3 = it.a(this.f776b, ioVar.f776b)) == 0) {
                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(ioVar.i()));
                                            if (compareTo9 != 0) {
                                                return compareTo9;
                                            }
                                            if (!i() || (a2 = it.a(this.f778c, ioVar.f778c)) == 0) {
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
        return io.class.getName().compareTo(ioVar.getClass().getName());
    }

    public String a() {
        return this.f781e;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m683a() {
        if (this.f777b == null) {
            throw new je("Required field 'id' was not present! Struct: " + toString());
        } else if (this.f779c != null) {
        } else {
            throw new je("Required field 'appId' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.is
    public void a(jd jdVar) {
        jdVar.mo703a();
        while (true) {
            ja mo699a = jdVar.mo699a();
            byte b2 = mo699a.a;
            if (b2 == 0) {
                jdVar.f();
                if (e()) {
                    m683a();
                    return;
                }
                throw new je("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
            }
            switch (mo699a.f813a) {
                case 1:
                    if (b2 == 11) {
                        this.f774a = jdVar.mo704a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 2:
                    if (b2 == 12) {
                        hw hwVar = new hw();
                        this.f773a = hwVar;
                        hwVar.a(jdVar);
                        continue;
                        jdVar.g();
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f777b = jdVar.mo704a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f779c = jdVar.mo704a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 6:
                    if (b2 == 10) {
                        this.f772a = jdVar.mo698a();
                        a(true);
                        continue;
                        jdVar.g();
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f780d = jdVar.mo704a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 8:
                    if (b2 == 11) {
                        this.f781e = jdVar.mo704a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 9:
                    if (b2 == 10) {
                        this.f776b = jdVar.mo698a();
                        b(true);
                        continue;
                        jdVar.g();
                    }
                    break;
                case 10:
                    if (b2 == 10) {
                        this.f778c = jdVar.mo698a();
                        c(true);
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
        this.f775a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m684a() {
        return this.f774a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m685a(io ioVar) {
        if (ioVar == null) {
            return false;
        }
        boolean m684a = m684a();
        boolean m684a2 = ioVar.m684a();
        if ((m684a || m684a2) && !(m684a && m684a2 && this.f774a.equals(ioVar.f774a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = ioVar.b();
        if ((b2 || b3) && !(b2 && b3 && this.f773a.m599a(ioVar.f773a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = ioVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f777b.equals(ioVar.f777b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = ioVar.d();
        if (((d2 || d3) && !(d2 && d3 && this.f779c.equals(ioVar.f779c))) || this.f772a != ioVar.f772a) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = ioVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f780d.equals(ioVar.f780d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = ioVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f781e.equals(ioVar.f781e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = ioVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f776b == ioVar.f776b)) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = ioVar.i();
        if (i2 || i3) {
            return i2 && i3 && this.f778c == ioVar.f778c;
        }
        return true;
    }

    @Override // com.xiaomi.push.is
    public void b(jd jdVar) {
        m683a();
        jdVar.a(f771a);
        if (this.f774a != null && m684a()) {
            jdVar.a(a);
            jdVar.a(this.f774a);
            jdVar.b();
        }
        if (this.f773a != null && b()) {
            jdVar.a(b);
            this.f773a.b(jdVar);
            jdVar.b();
        }
        if (this.f777b != null) {
            jdVar.a(c);
            jdVar.a(this.f777b);
            jdVar.b();
        }
        if (this.f779c != null) {
            jdVar.a(d);
            jdVar.a(this.f779c);
            jdVar.b();
        }
        jdVar.a(e);
        jdVar.a(this.f772a);
        jdVar.b();
        if (this.f780d != null && f()) {
            jdVar.a(f);
            jdVar.a(this.f780d);
            jdVar.b();
        }
        if (this.f781e != null && g()) {
            jdVar.a(g);
            jdVar.a(this.f781e);
            jdVar.b();
        }
        if (h()) {
            jdVar.a(h);
            jdVar.a(this.f776b);
            jdVar.b();
        }
        if (i()) {
            jdVar.a(i);
            jdVar.a(this.f778c);
            jdVar.b();
        }
        jdVar.c();
        jdVar.mo707a();
    }

    public void b(boolean z) {
        this.f775a.set(1, z);
    }

    public boolean b() {
        return this.f773a != null;
    }

    public void c(boolean z) {
        this.f775a.set(2, z);
    }

    public boolean c() {
        return this.f777b != null;
    }

    public boolean d() {
        return this.f779c != null;
    }

    public boolean e() {
        return this.f775a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof io)) {
            return m685a((io) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f780d != null;
    }

    public boolean g() {
        return this.f781e != null;
    }

    public boolean h() {
        return this.f775a.get(1);
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f775a.get(2);
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionUnRegistrationResult(");
        boolean z2 = false;
        if (m684a()) {
            sb.append("debug:");
            String str = this.f774a;
            if (str == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (b()) {
            if (!z) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            }
            sb.append("target:");
            hw hwVar = this.f773a;
            if (hwVar == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(hwVar);
            }
        } else {
            z2 = z;
        }
        if (!z2) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        }
        sb.append("id:");
        String str2 = this.f777b;
        if (str2 == null) {
            sb.append(StringUtil.NULL_STRING);
        } else {
            sb.append(str2);
        }
        sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        sb.append("appId:");
        String str3 = this.f779c;
        if (str3 == null) {
            sb.append(StringUtil.NULL_STRING);
        } else {
            sb.append(str3);
        }
        sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        sb.append("errorCode:");
        sb.append(this.f772a);
        if (f()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("reason:");
            String str4 = this.f780d;
            if (str4 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str4);
            }
        }
        if (g()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("packageName:");
            String str5 = this.f781e;
            if (str5 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str5);
            }
        }
        if (h()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("unRegisteredAt:");
            sb.append(this.f776b);
        }
        if (i()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("costTime:");
            sb.append(this.f778c);
        }
        sb.append(SmallTailInfo.EMOTION_SUFFIX);
        return sb.toString();
    }
}
