package com.xiaomi.push;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.tbadk.core.data.SmallTailInfo;
import io.flutter.plugin.common.StandardMessageCodec;
import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes7.dex */
public class im implements iq<im, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f767a;

    /* renamed from: a  reason: collision with other field name */
    public hu f768a;

    /* renamed from: a  reason: collision with other field name */
    public String f769a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f770a = new BitSet(3);

    /* renamed from: b  reason: collision with other field name */
    public long f771b;

    /* renamed from: b  reason: collision with other field name */
    public String f772b;

    /* renamed from: c  reason: collision with other field name */
    public long f773c;

    /* renamed from: c  reason: collision with other field name */
    public String f774c;

    /* renamed from: d  reason: collision with other field name */
    public String f775d;

    /* renamed from: e  reason: collision with other field name */
    public String f776e;

    /* renamed from: a  reason: collision with other field name */
    public static final jg f766a = new jg("XmPushActionUnRegistrationResult");

    /* renamed from: a  reason: collision with root package name */
    public static final iy f38756a = new iy("", (byte) 11, 1);

    /* renamed from: b  reason: collision with root package name */
    public static final iy f38757b = new iy("", StandardMessageCodec.LIST, 2);

    /* renamed from: c  reason: collision with root package name */
    public static final iy f38758c = new iy("", (byte) 11, 3);

    /* renamed from: d  reason: collision with root package name */
    public static final iy f38759d = new iy("", (byte) 11, 4);

    /* renamed from: e  reason: collision with root package name */
    public static final iy f38760e = new iy("", (byte) 10, 6);

    /* renamed from: f  reason: collision with root package name */
    public static final iy f38761f = new iy("", (byte) 11, 7);

    /* renamed from: g  reason: collision with root package name */
    public static final iy f38762g = new iy("", (byte) 11, 8);

    /* renamed from: h  reason: collision with root package name */
    public static final iy f38763h = new iy("", (byte) 10, 9);

    /* renamed from: i  reason: collision with root package name */
    public static final iy f38764i = new iy("", (byte) 10, 10);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(im imVar) {
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        int a8;
        int a9;
        int a10;
        if (im.class.equals(imVar.getClass())) {
            int compareTo = Boolean.valueOf(m493a()).compareTo(Boolean.valueOf(imVar.m493a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m493a() || (a10 = ir.a(this.f769a, imVar.f769a)) == 0) {
                int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(imVar.b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!b() || (a9 = ir.a(this.f768a, imVar.f768a)) == 0) {
                    int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(imVar.c()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!c() || (a8 = ir.a(this.f772b, imVar.f772b)) == 0) {
                        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(imVar.d()));
                        if (compareTo4 != 0) {
                            return compareTo4;
                        }
                        if (!d() || (a7 = ir.a(this.f774c, imVar.f774c)) == 0) {
                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(imVar.e()));
                            if (compareTo5 != 0) {
                                return compareTo5;
                            }
                            if (!e() || (a6 = ir.a(this.f767a, imVar.f767a)) == 0) {
                                int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(imVar.f()));
                                if (compareTo6 != 0) {
                                    return compareTo6;
                                }
                                if (!f() || (a5 = ir.a(this.f775d, imVar.f775d)) == 0) {
                                    int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(imVar.g()));
                                    if (compareTo7 != 0) {
                                        return compareTo7;
                                    }
                                    if (!g() || (a4 = ir.a(this.f776e, imVar.f776e)) == 0) {
                                        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(imVar.h()));
                                        if (compareTo8 != 0) {
                                            return compareTo8;
                                        }
                                        if (!h() || (a3 = ir.a(this.f771b, imVar.f771b)) == 0) {
                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(imVar.i()));
                                            if (compareTo9 != 0) {
                                                return compareTo9;
                                            }
                                            if (!i() || (a2 = ir.a(this.f773c, imVar.f773c)) == 0) {
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
        return im.class.getName().compareTo(imVar.getClass().getName());
    }

    public String a() {
        return this.f776e;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m492a() {
        if (this.f772b == null) {
            throw new jc("Required field 'id' was not present! Struct: " + toString());
        } else if (this.f774c != null) {
        } else {
            throw new jc("Required field 'appId' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.iq
    public void a(jb jbVar) {
        jbVar.m512a();
        while (true) {
            iy m508a = jbVar.m508a();
            byte b2 = m508a.f38795a;
            if (b2 == 0) {
                jbVar.f();
                if (e()) {
                    m492a();
                    return;
                }
                throw new jc("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
            }
            switch (m508a.f807a) {
                case 1:
                    if (b2 == 11) {
                        this.f769a = jbVar.m513a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 2:
                    if (b2 == 12) {
                        hu huVar = new hu();
                        this.f768a = huVar;
                        huVar.a(jbVar);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f772b = jbVar.m513a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f774c = jbVar.m513a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 6:
                    if (b2 == 10) {
                        this.f767a = jbVar.m507a();
                        a(true);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f775d = jbVar.m513a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 8:
                    if (b2 == 11) {
                        this.f776e = jbVar.m513a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 9:
                    if (b2 == 10) {
                        this.f771b = jbVar.m507a();
                        b(true);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 10:
                    if (b2 == 10) {
                        this.f773c = jbVar.m507a();
                        c(true);
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
        this.f770a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m493a() {
        return this.f769a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m494a(im imVar) {
        if (imVar == null) {
            return false;
        }
        boolean m493a = m493a();
        boolean m493a2 = imVar.m493a();
        if ((m493a || m493a2) && !(m493a && m493a2 && this.f769a.equals(imVar.f769a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = imVar.b();
        if ((b2 || b3) && !(b2 && b3 && this.f768a.m407a(imVar.f768a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = imVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f772b.equals(imVar.f772b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = imVar.d();
        if (((d2 || d3) && !(d2 && d3 && this.f774c.equals(imVar.f774c))) || this.f767a != imVar.f767a) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = imVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f775d.equals(imVar.f775d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = imVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f776e.equals(imVar.f776e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = imVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f771b == imVar.f771b)) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = imVar.i();
        if (i2 || i3) {
            return i2 && i3 && this.f773c == imVar.f773c;
        }
        return true;
    }

    @Override // com.xiaomi.push.iq
    public void b(jb jbVar) {
        m492a();
        jbVar.a(f766a);
        if (this.f769a != null && m493a()) {
            jbVar.a(f38756a);
            jbVar.a(this.f769a);
            jbVar.b();
        }
        if (this.f768a != null && b()) {
            jbVar.a(f38757b);
            this.f768a.b(jbVar);
            jbVar.b();
        }
        if (this.f772b != null) {
            jbVar.a(f38758c);
            jbVar.a(this.f772b);
            jbVar.b();
        }
        if (this.f774c != null) {
            jbVar.a(f38759d);
            jbVar.a(this.f774c);
            jbVar.b();
        }
        jbVar.a(f38760e);
        jbVar.a(this.f767a);
        jbVar.b();
        if (this.f775d != null && f()) {
            jbVar.a(f38761f);
            jbVar.a(this.f775d);
            jbVar.b();
        }
        if (this.f776e != null && g()) {
            jbVar.a(f38762g);
            jbVar.a(this.f776e);
            jbVar.b();
        }
        if (h()) {
            jbVar.a(f38763h);
            jbVar.a(this.f771b);
            jbVar.b();
        }
        if (i()) {
            jbVar.a(f38764i);
            jbVar.a(this.f773c);
            jbVar.b();
        }
        jbVar.c();
        jbVar.m516a();
    }

    public void b(boolean z) {
        this.f770a.set(1, z);
    }

    public boolean b() {
        return this.f768a != null;
    }

    public void c(boolean z) {
        this.f770a.set(2, z);
    }

    public boolean c() {
        return this.f772b != null;
    }

    public boolean d() {
        return this.f774c != null;
    }

    public boolean e() {
        return this.f770a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof im)) {
            return m494a((im) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f775d != null;
    }

    public boolean g() {
        return this.f776e != null;
    }

    public boolean h() {
        return this.f770a.get(1);
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f770a.get(2);
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionUnRegistrationResult(");
        boolean z2 = false;
        if (m493a()) {
            sb.append("debug:");
            String str = this.f769a;
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
            hu huVar = this.f768a;
            if (huVar == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(huVar);
            }
        } else {
            z2 = z;
        }
        if (!z2) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        }
        sb.append("id:");
        String str2 = this.f772b;
        if (str2 == null) {
            sb.append(StringUtil.NULL_STRING);
        } else {
            sb.append(str2);
        }
        sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        sb.append("appId:");
        String str3 = this.f774c;
        if (str3 == null) {
            sb.append(StringUtil.NULL_STRING);
        } else {
            sb.append(str3);
        }
        sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        sb.append("errorCode:");
        sb.append(this.f767a);
        if (f()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("reason:");
            String str4 = this.f775d;
            if (str4 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str4);
            }
        }
        if (g()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("packageName:");
            String str5 = this.f776e;
            if (str5 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str5);
            }
        }
        if (h()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("unRegisteredAt:");
            sb.append(this.f771b);
        }
        if (i()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("costTime:");
            sb.append(this.f773c);
        }
        sb.append(SmallTailInfo.EMOTION_SUFFIX);
        return sb.toString();
    }
}
