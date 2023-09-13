package com.xiaomi.push;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes10.dex */
public class in implements is<in, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f758a;

    /* renamed from: a  reason: collision with other field name */
    public hw f759a;

    /* renamed from: a  reason: collision with other field name */
    public String f760a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f761a = new BitSet(2);

    /* renamed from: a  reason: collision with other field name */
    public boolean f762a = true;

    /* renamed from: b  reason: collision with other field name */
    public String f763b;

    /* renamed from: c  reason: collision with other field name */
    public String f764c;

    /* renamed from: d  reason: collision with other field name */
    public String f765d;

    /* renamed from: e  reason: collision with other field name */
    public String f766e;

    /* renamed from: f  reason: collision with other field name */
    public String f767f;

    /* renamed from: g  reason: collision with other field name */
    public String f768g;

    /* renamed from: h  reason: collision with other field name */
    public String f769h;

    /* renamed from: i  reason: collision with other field name */
    public String f770i;

    /* renamed from: a  reason: collision with other field name */
    public static final ji f757a = new ji("XmPushActionUnRegistration");
    public static final ja a = new ja("", Constants.GZIP_CAST_TYPE, 1);
    public static final ja b = new ja("", (byte) 12, 2);
    public static final ja c = new ja("", Constants.GZIP_CAST_TYPE, 3);
    public static final ja d = new ja("", Constants.GZIP_CAST_TYPE, 4);
    public static final ja e = new ja("", Constants.GZIP_CAST_TYPE, 5);
    public static final ja f = new ja("", Constants.GZIP_CAST_TYPE, 6);
    public static final ja g = new ja("", Constants.GZIP_CAST_TYPE, 7);
    public static final ja h = new ja("", Constants.GZIP_CAST_TYPE, 8);
    public static final ja i = new ja("", Constants.GZIP_CAST_TYPE, 9);
    public static final ja j = new ja("", Constants.GZIP_CAST_TYPE, 10);
    public static final ja k = new ja("", (byte) 2, 11);
    public static final ja l = new ja("", (byte) 10, 12);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(in inVar) {
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
        if (in.class.equals(inVar.getClass())) {
            int compareTo = Boolean.valueOf(m679a()).compareTo(Boolean.valueOf(inVar.m679a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m679a() || (a13 = it.a(this.f760a, inVar.f760a)) == 0) {
                int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(inVar.b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!b() || (a12 = it.a(this.f759a, inVar.f759a)) == 0) {
                    int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(inVar.c()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!c() || (a11 = it.a(this.f763b, inVar.f763b)) == 0) {
                        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(inVar.d()));
                        if (compareTo4 != 0) {
                            return compareTo4;
                        }
                        if (!d() || (a10 = it.a(this.f764c, inVar.f764c)) == 0) {
                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(inVar.e()));
                            if (compareTo5 != 0) {
                                return compareTo5;
                            }
                            if (!e() || (a9 = it.a(this.f765d, inVar.f765d)) == 0) {
                                int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(inVar.f()));
                                if (compareTo6 != 0) {
                                    return compareTo6;
                                }
                                if (!f() || (a8 = it.a(this.f766e, inVar.f766e)) == 0) {
                                    int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(inVar.g()));
                                    if (compareTo7 != 0) {
                                        return compareTo7;
                                    }
                                    if (!g() || (a7 = it.a(this.f767f, inVar.f767f)) == 0) {
                                        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(inVar.h()));
                                        if (compareTo8 != 0) {
                                            return compareTo8;
                                        }
                                        if (!h() || (a6 = it.a(this.f768g, inVar.f768g)) == 0) {
                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(inVar.i()));
                                            if (compareTo9 != 0) {
                                                return compareTo9;
                                            }
                                            if (!i() || (a5 = it.a(this.f769h, inVar.f769h)) == 0) {
                                                int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(inVar.j()));
                                                if (compareTo10 != 0) {
                                                    return compareTo10;
                                                }
                                                if (!j() || (a4 = it.a(this.f770i, inVar.f770i)) == 0) {
                                                    int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(inVar.k()));
                                                    if (compareTo11 != 0) {
                                                        return compareTo11;
                                                    }
                                                    if (!k() || (a3 = it.a(this.f762a, inVar.f762a)) == 0) {
                                                        int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(inVar.l()));
                                                        if (compareTo12 != 0) {
                                                            return compareTo12;
                                                        }
                                                        if (!l() || (a2 = it.a(this.f758a, inVar.f758a)) == 0) {
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
        return in.class.getName().compareTo(inVar.getClass().getName());
    }

    public in a(String str) {
        this.f763b = str;
        return this;
    }

    public void a() {
        if (this.f763b == null) {
            throw new je("Required field 'id' was not present! Struct: " + toString());
        } else if (this.f764c != null) {
        } else {
            throw new je("Required field 'appId' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.is
    public void a(jd jdVar) {
        jdVar.mo701a();
        while (true) {
            ja mo697a = jdVar.mo697a();
            byte b2 = mo697a.a;
            if (b2 == 0) {
                jdVar.f();
                a();
                return;
            }
            switch (mo697a.f813a) {
                case 1:
                    if (b2 == 11) {
                        this.f760a = jdVar.mo702a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 2:
                    if (b2 == 12) {
                        hw hwVar = new hw();
                        this.f759a = hwVar;
                        hwVar.a(jdVar);
                        continue;
                        jdVar.g();
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f763b = jdVar.mo702a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f764c = jdVar.mo702a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 5:
                    if (b2 == 11) {
                        this.f765d = jdVar.mo702a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 6:
                    if (b2 == 11) {
                        this.f766e = jdVar.mo702a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f767f = jdVar.mo702a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 8:
                    if (b2 == 11) {
                        this.f768g = jdVar.mo702a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 9:
                    if (b2 == 11) {
                        this.f769h = jdVar.mo702a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 10:
                    if (b2 == 11) {
                        this.f770i = jdVar.mo702a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 11:
                    if (b2 == 2) {
                        this.f762a = jdVar.mo707a();
                        a(true);
                        continue;
                        jdVar.g();
                    }
                    break;
                case 12:
                    if (b2 == 10) {
                        this.f758a = jdVar.mo696a();
                        b(true);
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
        this.f761a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m679a() {
        return this.f760a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m680a(in inVar) {
        if (inVar == null) {
            return false;
        }
        boolean m679a = m679a();
        boolean m679a2 = inVar.m679a();
        if ((m679a || m679a2) && !(m679a && m679a2 && this.f760a.equals(inVar.f760a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = inVar.b();
        if ((b2 || b3) && !(b2 && b3 && this.f759a.m597a(inVar.f759a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = inVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f763b.equals(inVar.f763b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = inVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f764c.equals(inVar.f764c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = inVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f765d.equals(inVar.f765d))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = inVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f766e.equals(inVar.f766e))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = inVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f767f.equals(inVar.f767f))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = inVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f768g.equals(inVar.f768g))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = inVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f769h.equals(inVar.f769h))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = inVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f770i.equals(inVar.f770i))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = inVar.k();
        if ((k2 || k3) && !(k2 && k3 && this.f762a == inVar.f762a)) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = inVar.l();
        if (l2 || l3) {
            return l2 && l3 && this.f758a == inVar.f758a;
        }
        return true;
    }

    public in b(String str) {
        this.f764c = str;
        return this;
    }

    @Override // com.xiaomi.push.is
    public void b(jd jdVar) {
        a();
        jdVar.a(f757a);
        if (this.f760a != null && m679a()) {
            jdVar.a(a);
            jdVar.a(this.f760a);
            jdVar.b();
        }
        if (this.f759a != null && b()) {
            jdVar.a(b);
            this.f759a.b(jdVar);
            jdVar.b();
        }
        if (this.f763b != null) {
            jdVar.a(c);
            jdVar.a(this.f763b);
            jdVar.b();
        }
        if (this.f764c != null) {
            jdVar.a(d);
            jdVar.a(this.f764c);
            jdVar.b();
        }
        if (this.f765d != null && e()) {
            jdVar.a(e);
            jdVar.a(this.f765d);
            jdVar.b();
        }
        if (this.f766e != null && f()) {
            jdVar.a(f);
            jdVar.a(this.f766e);
            jdVar.b();
        }
        if (this.f767f != null && g()) {
            jdVar.a(g);
            jdVar.a(this.f767f);
            jdVar.b();
        }
        if (this.f768g != null && h()) {
            jdVar.a(h);
            jdVar.a(this.f768g);
            jdVar.b();
        }
        if (this.f769h != null && i()) {
            jdVar.a(i);
            jdVar.a(this.f769h);
            jdVar.b();
        }
        if (this.f770i != null && j()) {
            jdVar.a(j);
            jdVar.a(this.f770i);
            jdVar.b();
        }
        if (k()) {
            jdVar.a(k);
            jdVar.a(this.f762a);
            jdVar.b();
        }
        if (l()) {
            jdVar.a(l);
            jdVar.a(this.f758a);
            jdVar.b();
        }
        jdVar.c();
        jdVar.mo705a();
    }

    public void b(boolean z) {
        this.f761a.set(1, z);
    }

    public boolean b() {
        return this.f759a != null;
    }

    public in c(String str) {
        this.f765d = str;
        return this;
    }

    public boolean c() {
        return this.f763b != null;
    }

    public in d(String str) {
        this.f767f = str;
        return this;
    }

    public boolean d() {
        return this.f764c != null;
    }

    public in e(String str) {
        this.f768g = str;
        return this;
    }

    public boolean e() {
        return this.f765d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof in)) {
            return m680a((in) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f766e != null;
    }

    public boolean g() {
        return this.f767f != null;
    }

    public boolean h() {
        return this.f768g != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f769h != null;
    }

    public boolean j() {
        return this.f770i != null;
    }

    public boolean k() {
        return this.f761a.get(0);
    }

    public boolean l() {
        return this.f761a.get(1);
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionUnRegistration(");
        boolean z2 = false;
        if (m679a()) {
            sb.append("debug:");
            String str = this.f760a;
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
            hw hwVar = this.f759a;
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
        String str2 = this.f763b;
        if (str2 == null) {
            sb.append(StringUtil.NULL_STRING);
        } else {
            sb.append(str2);
        }
        sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        sb.append("appId:");
        String str3 = this.f764c;
        if (str3 == null) {
            sb.append(StringUtil.NULL_STRING);
        } else {
            sb.append(str3);
        }
        if (e()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("regId:");
            String str4 = this.f765d;
            if (str4 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str4);
            }
        }
        if (f()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("appVersion:");
            String str5 = this.f766e;
            if (str5 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str5);
            }
        }
        if (g()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("packageName:");
            String str6 = this.f767f;
            if (str6 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str6);
            }
        }
        if (h()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("token:");
            String str7 = this.f768g;
            if (str7 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str7);
            }
        }
        if (i()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("deviceId:");
            String str8 = this.f769h;
            if (str8 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str8);
            }
        }
        if (j()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("aliasName:");
            String str9 = this.f770i;
            if (str9 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str9);
            }
        }
        if (k()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("needAck:");
            sb.append(this.f762a);
        }
        if (l()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("createdTs:");
            sb.append(this.f758a);
        }
        sb.append(SmallTailInfo.EMOTION_SUFFIX);
        return sb.toString();
    }
}
