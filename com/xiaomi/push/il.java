package com.xiaomi.push;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.tbadk.core.data.SmallTailInfo;
import io.flutter.plugin.common.StandardMessageCodec;
import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes7.dex */
public class il implements iq<il, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f753a;

    /* renamed from: a  reason: collision with other field name */
    public hu f754a;

    /* renamed from: a  reason: collision with other field name */
    public String f755a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f756a = new BitSet(2);

    /* renamed from: a  reason: collision with other field name */
    public boolean f757a = true;

    /* renamed from: b  reason: collision with other field name */
    public String f758b;

    /* renamed from: c  reason: collision with other field name */
    public String f759c;

    /* renamed from: d  reason: collision with other field name */
    public String f760d;

    /* renamed from: e  reason: collision with other field name */
    public String f761e;

    /* renamed from: f  reason: collision with other field name */
    public String f762f;

    /* renamed from: g  reason: collision with other field name */
    public String f763g;

    /* renamed from: h  reason: collision with other field name */
    public String f764h;

    /* renamed from: i  reason: collision with other field name */
    public String f765i;

    /* renamed from: a  reason: collision with other field name */
    public static final jg f752a = new jg("XmPushActionUnRegistration");

    /* renamed from: a  reason: collision with root package name */
    public static final iy f41703a = new iy("", (byte) 11, 1);

    /* renamed from: b  reason: collision with root package name */
    public static final iy f41704b = new iy("", StandardMessageCodec.LIST, 2);

    /* renamed from: c  reason: collision with root package name */
    public static final iy f41705c = new iy("", (byte) 11, 3);

    /* renamed from: d  reason: collision with root package name */
    public static final iy f41706d = new iy("", (byte) 11, 4);

    /* renamed from: e  reason: collision with root package name */
    public static final iy f41707e = new iy("", (byte) 11, 5);

    /* renamed from: f  reason: collision with root package name */
    public static final iy f41708f = new iy("", (byte) 11, 6);

    /* renamed from: g  reason: collision with root package name */
    public static final iy f41709g = new iy("", (byte) 11, 7);

    /* renamed from: h  reason: collision with root package name */
    public static final iy f41710h = new iy("", (byte) 11, 8);

    /* renamed from: i  reason: collision with root package name */
    public static final iy f41711i = new iy("", (byte) 11, 9);
    public static final iy j = new iy("", (byte) 11, 10);
    public static final iy k = new iy("", (byte) 2, 11);
    public static final iy l = new iy("", (byte) 10, 12);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(il ilVar) {
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
        int a12;
        int a13;
        if (il.class.equals(ilVar.getClass())) {
            int compareTo = Boolean.valueOf(m488a()).compareTo(Boolean.valueOf(ilVar.m488a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m488a() || (a13 = ir.a(this.f755a, ilVar.f755a)) == 0) {
                int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(ilVar.b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!b() || (a12 = ir.a(this.f754a, ilVar.f754a)) == 0) {
                    int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(ilVar.c()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!c() || (a11 = ir.a(this.f758b, ilVar.f758b)) == 0) {
                        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(ilVar.d()));
                        if (compareTo4 != 0) {
                            return compareTo4;
                        }
                        if (!d() || (a10 = ir.a(this.f759c, ilVar.f759c)) == 0) {
                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(ilVar.e()));
                            if (compareTo5 != 0) {
                                return compareTo5;
                            }
                            if (!e() || (a9 = ir.a(this.f760d, ilVar.f760d)) == 0) {
                                int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(ilVar.f()));
                                if (compareTo6 != 0) {
                                    return compareTo6;
                                }
                                if (!f() || (a8 = ir.a(this.f761e, ilVar.f761e)) == 0) {
                                    int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ilVar.g()));
                                    if (compareTo7 != 0) {
                                        return compareTo7;
                                    }
                                    if (!g() || (a7 = ir.a(this.f762f, ilVar.f762f)) == 0) {
                                        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(ilVar.h()));
                                        if (compareTo8 != 0) {
                                            return compareTo8;
                                        }
                                        if (!h() || (a6 = ir.a(this.f763g, ilVar.f763g)) == 0) {
                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(ilVar.i()));
                                            if (compareTo9 != 0) {
                                                return compareTo9;
                                            }
                                            if (!i() || (a5 = ir.a(this.f764h, ilVar.f764h)) == 0) {
                                                int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(ilVar.j()));
                                                if (compareTo10 != 0) {
                                                    return compareTo10;
                                                }
                                                if (!j() || (a4 = ir.a(this.f765i, ilVar.f765i)) == 0) {
                                                    int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(ilVar.k()));
                                                    if (compareTo11 != 0) {
                                                        return compareTo11;
                                                    }
                                                    if (!k() || (a3 = ir.a(this.f757a, ilVar.f757a)) == 0) {
                                                        int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(ilVar.l()));
                                                        if (compareTo12 != 0) {
                                                            return compareTo12;
                                                        }
                                                        if (!l() || (a2 = ir.a(this.f753a, ilVar.f753a)) == 0) {
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
                return a12;
            }
            return a13;
        }
        return il.class.getName().compareTo(ilVar.getClass().getName());
    }

    public il a(String str) {
        this.f758b = str;
        return this;
    }

    public void a() {
        if (this.f758b == null) {
            throw new jc("Required field 'id' was not present! Struct: " + toString());
        } else if (this.f759c != null) {
        } else {
            throw new jc("Required field 'appId' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.iq
    public void a(jb jbVar) {
        jbVar.m510a();
        while (true) {
            iy m506a = jbVar.m506a();
            byte b2 = m506a.f41751a;
            if (b2 == 0) {
                jbVar.f();
                a();
                return;
            }
            switch (m506a.f807a) {
                case 1:
                    if (b2 == 11) {
                        this.f755a = jbVar.m511a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 2:
                    if (b2 == 12) {
                        hu huVar = new hu();
                        this.f754a = huVar;
                        huVar.a(jbVar);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f758b = jbVar.m511a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f759c = jbVar.m511a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 5:
                    if (b2 == 11) {
                        this.f760d = jbVar.m511a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 6:
                    if (b2 == 11) {
                        this.f761e = jbVar.m511a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f762f = jbVar.m511a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 8:
                    if (b2 == 11) {
                        this.f763g = jbVar.m511a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 9:
                    if (b2 == 11) {
                        this.f764h = jbVar.m511a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 10:
                    if (b2 == 11) {
                        this.f765i = jbVar.m511a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 11:
                    if (b2 == 2) {
                        this.f757a = jbVar.m515a();
                        a(true);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 12:
                    if (b2 == 10) {
                        this.f753a = jbVar.m505a();
                        b(true);
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
        this.f756a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m488a() {
        return this.f755a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m489a(il ilVar) {
        if (ilVar == null) {
            return false;
        }
        boolean m488a = m488a();
        boolean m488a2 = ilVar.m488a();
        if ((m488a || m488a2) && !(m488a && m488a2 && this.f755a.equals(ilVar.f755a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = ilVar.b();
        if ((b2 || b3) && !(b2 && b3 && this.f754a.m405a(ilVar.f754a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = ilVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f758b.equals(ilVar.f758b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = ilVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f759c.equals(ilVar.f759c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = ilVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f760d.equals(ilVar.f760d))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = ilVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f761e.equals(ilVar.f761e))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = ilVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f762f.equals(ilVar.f762f))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = ilVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f763g.equals(ilVar.f763g))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = ilVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f764h.equals(ilVar.f764h))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = ilVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f765i.equals(ilVar.f765i))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = ilVar.k();
        if ((k2 || k3) && !(k2 && k3 && this.f757a == ilVar.f757a)) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = ilVar.l();
        if (l2 || l3) {
            return l2 && l3 && this.f753a == ilVar.f753a;
        }
        return true;
    }

    public il b(String str) {
        this.f759c = str;
        return this;
    }

    @Override // com.xiaomi.push.iq
    public void b(jb jbVar) {
        a();
        jbVar.a(f752a);
        if (this.f755a != null && m488a()) {
            jbVar.a(f41703a);
            jbVar.a(this.f755a);
            jbVar.b();
        }
        if (this.f754a != null && b()) {
            jbVar.a(f41704b);
            this.f754a.b(jbVar);
            jbVar.b();
        }
        if (this.f758b != null) {
            jbVar.a(f41705c);
            jbVar.a(this.f758b);
            jbVar.b();
        }
        if (this.f759c != null) {
            jbVar.a(f41706d);
            jbVar.a(this.f759c);
            jbVar.b();
        }
        if (this.f760d != null && e()) {
            jbVar.a(f41707e);
            jbVar.a(this.f760d);
            jbVar.b();
        }
        if (this.f761e != null && f()) {
            jbVar.a(f41708f);
            jbVar.a(this.f761e);
            jbVar.b();
        }
        if (this.f762f != null && g()) {
            jbVar.a(f41709g);
            jbVar.a(this.f762f);
            jbVar.b();
        }
        if (this.f763g != null && h()) {
            jbVar.a(f41710h);
            jbVar.a(this.f763g);
            jbVar.b();
        }
        if (this.f764h != null && i()) {
            jbVar.a(f41711i);
            jbVar.a(this.f764h);
            jbVar.b();
        }
        if (this.f765i != null && j()) {
            jbVar.a(j);
            jbVar.a(this.f765i);
            jbVar.b();
        }
        if (k()) {
            jbVar.a(k);
            jbVar.a(this.f757a);
            jbVar.b();
        }
        if (l()) {
            jbVar.a(l);
            jbVar.a(this.f753a);
            jbVar.b();
        }
        jbVar.c();
        jbVar.m514a();
    }

    public void b(boolean z) {
        this.f756a.set(1, z);
    }

    public boolean b() {
        return this.f754a != null;
    }

    public il c(String str) {
        this.f760d = str;
        return this;
    }

    public boolean c() {
        return this.f758b != null;
    }

    public il d(String str) {
        this.f762f = str;
        return this;
    }

    public boolean d() {
        return this.f759c != null;
    }

    public il e(String str) {
        this.f763g = str;
        return this;
    }

    public boolean e() {
        return this.f760d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof il)) {
            return m489a((il) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f761e != null;
    }

    public boolean g() {
        return this.f762f != null;
    }

    public boolean h() {
        return this.f763g != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f764h != null;
    }

    public boolean j() {
        return this.f765i != null;
    }

    public boolean k() {
        return this.f756a.get(0);
    }

    public boolean l() {
        return this.f756a.get(1);
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionUnRegistration(");
        boolean z2 = false;
        if (m488a()) {
            sb.append("debug:");
            String str = this.f755a;
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
            hu huVar = this.f754a;
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
        String str2 = this.f758b;
        if (str2 == null) {
            sb.append(StringUtil.NULL_STRING);
        } else {
            sb.append(str2);
        }
        sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        sb.append("appId:");
        String str3 = this.f759c;
        if (str3 == null) {
            sb.append(StringUtil.NULL_STRING);
        } else {
            sb.append(str3);
        }
        if (e()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("regId:");
            String str4 = this.f760d;
            if (str4 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str4);
            }
        }
        if (f()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("appVersion:");
            String str5 = this.f761e;
            if (str5 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str5);
            }
        }
        if (g()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("packageName:");
            String str6 = this.f762f;
            if (str6 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str6);
            }
        }
        if (h()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("token:");
            String str7 = this.f763g;
            if (str7 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str7);
            }
        }
        if (i()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("deviceId:");
            String str8 = this.f764h;
            if (str8 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str8);
            }
        }
        if (j()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("aliasName:");
            String str9 = this.f765i;
            if (str9 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str9);
            }
        }
        if (k()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("needAck:");
            sb.append(this.f757a);
        }
        if (l()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("createdTs:");
            sb.append(this.f753a);
        }
        sb.append(SmallTailInfo.EMOTION_SUFFIX);
        return sb.toString();
    }
}
