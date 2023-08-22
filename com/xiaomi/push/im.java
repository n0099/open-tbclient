package com.xiaomi.push;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes10.dex */
public class im implements is<im, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f748a;

    /* renamed from: a  reason: collision with other field name */
    public hw f749a;

    /* renamed from: a  reason: collision with other field name */
    public String f750a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f751a = new BitSet(1);

    /* renamed from: b  reason: collision with other field name */
    public String f752b;

    /* renamed from: c  reason: collision with other field name */
    public String f753c;

    /* renamed from: d  reason: collision with other field name */
    public String f754d;

    /* renamed from: e  reason: collision with other field name */
    public String f755e;

    /* renamed from: f  reason: collision with other field name */
    public String f756f;

    /* renamed from: g  reason: collision with other field name */
    public String f757g;

    /* renamed from: a  reason: collision with other field name */
    public static final ji f747a = new ji("XmPushActionSubscriptionResult");
    public static final ja a = new ja("", Constants.GZIP_CAST_TYPE, 1);
    public static final ja b = new ja("", (byte) 12, 2);
    public static final ja c = new ja("", Constants.GZIP_CAST_TYPE, 3);
    public static final ja d = new ja("", Constants.GZIP_CAST_TYPE, 4);
    public static final ja e = new ja("", (byte) 10, 6);
    public static final ja f = new ja("", Constants.GZIP_CAST_TYPE, 7);
    public static final ja g = new ja("", Constants.GZIP_CAST_TYPE, 8);
    public static final ja h = new ja("", Constants.GZIP_CAST_TYPE, 9);
    public static final ja i = new ja("", Constants.GZIP_CAST_TYPE, 10);

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
            int compareTo = Boolean.valueOf(m674a()).compareTo(Boolean.valueOf(imVar.m674a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m674a() || (a10 = it.a(this.f750a, imVar.f750a)) == 0) {
                int compareTo2 = Boolean.valueOf(m676b()).compareTo(Boolean.valueOf(imVar.m676b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!m676b() || (a9 = it.a(this.f749a, imVar.f749a)) == 0) {
                    int compareTo3 = Boolean.valueOf(m677c()).compareTo(Boolean.valueOf(imVar.m677c()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!m677c() || (a8 = it.a(this.f752b, imVar.f752b)) == 0) {
                        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(imVar.d()));
                        if (compareTo4 != 0) {
                            return compareTo4;
                        }
                        if (!d() || (a7 = it.a(this.f753c, imVar.f753c)) == 0) {
                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(imVar.e()));
                            if (compareTo5 != 0) {
                                return compareTo5;
                            }
                            if (!e() || (a6 = it.a(this.f748a, imVar.f748a)) == 0) {
                                int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(imVar.f()));
                                if (compareTo6 != 0) {
                                    return compareTo6;
                                }
                                if (!f() || (a5 = it.a(this.f754d, imVar.f754d)) == 0) {
                                    int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(imVar.g()));
                                    if (compareTo7 != 0) {
                                        return compareTo7;
                                    }
                                    if (!g() || (a4 = it.a(this.f755e, imVar.f755e)) == 0) {
                                        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(imVar.h()));
                                        if (compareTo8 != 0) {
                                            return compareTo8;
                                        }
                                        if (!h() || (a3 = it.a(this.f756f, imVar.f756f)) == 0) {
                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(imVar.i()));
                                            if (compareTo9 != 0) {
                                                return compareTo9;
                                            }
                                            if (!i() || (a2 = it.a(this.f757g, imVar.f757g)) == 0) {
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
        return this.f752b;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m673a() {
        if (this.f752b != null) {
            return;
        }
        throw new je("Required field 'id' was not present! Struct: " + toString());
    }

    @Override // com.xiaomi.push.is
    public void a(jd jdVar) {
        jdVar.mo700a();
        while (true) {
            ja mo696a = jdVar.mo696a();
            byte b2 = mo696a.a;
            if (b2 == 0) {
                jdVar.f();
                m673a();
                return;
            }
            switch (mo696a.f814a) {
                case 1:
                    if (b2 == 11) {
                        this.f750a = jdVar.mo701a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 2:
                    if (b2 == 12) {
                        hw hwVar = new hw();
                        this.f749a = hwVar;
                        hwVar.a(jdVar);
                        continue;
                        jdVar.g();
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f752b = jdVar.mo701a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f753c = jdVar.mo701a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 6:
                    if (b2 == 10) {
                        this.f748a = jdVar.mo695a();
                        a(true);
                        continue;
                        jdVar.g();
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f754d = jdVar.mo701a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 8:
                    if (b2 == 11) {
                        this.f755e = jdVar.mo701a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 9:
                    if (b2 == 11) {
                        this.f756f = jdVar.mo701a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 10:
                    if (b2 == 11) {
                        this.f757g = jdVar.mo701a();
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
        this.f751a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m674a() {
        return this.f750a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m675a(im imVar) {
        if (imVar == null) {
            return false;
        }
        boolean m674a = m674a();
        boolean m674a2 = imVar.m674a();
        if ((m674a || m674a2) && !(m674a && m674a2 && this.f750a.equals(imVar.f750a))) {
            return false;
        }
        boolean m676b = m676b();
        boolean m676b2 = imVar.m676b();
        if ((m676b || m676b2) && !(m676b && m676b2 && this.f749a.m596a(imVar.f749a))) {
            return false;
        }
        boolean m677c = m677c();
        boolean m677c2 = imVar.m677c();
        if ((m677c || m677c2) && !(m677c && m677c2 && this.f752b.equals(imVar.f752b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = imVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f753c.equals(imVar.f753c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = imVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f748a == imVar.f748a)) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = imVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f754d.equals(imVar.f754d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = imVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f755e.equals(imVar.f755e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = imVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f756f.equals(imVar.f756f))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = imVar.i();
        if (i2 || i3) {
            return i2 && i3 && this.f757g.equals(imVar.f757g);
        }
        return true;
    }

    public String b() {
        return this.f755e;
    }

    @Override // com.xiaomi.push.is
    public void b(jd jdVar) {
        m673a();
        jdVar.a(f747a);
        if (this.f750a != null && m674a()) {
            jdVar.a(a);
            jdVar.a(this.f750a);
            jdVar.b();
        }
        if (this.f749a != null && m676b()) {
            jdVar.a(b);
            this.f749a.b(jdVar);
            jdVar.b();
        }
        if (this.f752b != null) {
            jdVar.a(c);
            jdVar.a(this.f752b);
            jdVar.b();
        }
        if (this.f753c != null && d()) {
            jdVar.a(d);
            jdVar.a(this.f753c);
            jdVar.b();
        }
        if (e()) {
            jdVar.a(e);
            jdVar.a(this.f748a);
            jdVar.b();
        }
        if (this.f754d != null && f()) {
            jdVar.a(f);
            jdVar.a(this.f754d);
            jdVar.b();
        }
        if (this.f755e != null && g()) {
            jdVar.a(g);
            jdVar.a(this.f755e);
            jdVar.b();
        }
        if (this.f756f != null && h()) {
            jdVar.a(h);
            jdVar.a(this.f756f);
            jdVar.b();
        }
        if (this.f757g != null && i()) {
            jdVar.a(i);
            jdVar.a(this.f757g);
            jdVar.b();
        }
        jdVar.c();
        jdVar.mo704a();
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m676b() {
        return this.f749a != null;
    }

    public String c() {
        return this.f757g;
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m677c() {
        return this.f752b != null;
    }

    public boolean d() {
        return this.f753c != null;
    }

    public boolean e() {
        return this.f751a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof im)) {
            return m675a((im) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f754d != null;
    }

    public boolean g() {
        return this.f755e != null;
    }

    public boolean h() {
        return this.f756f != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f757g != null;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionSubscriptionResult(");
        boolean z2 = false;
        if (m674a()) {
            sb.append("debug:");
            String str = this.f750a;
            if (str == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (m676b()) {
            if (!z) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            }
            sb.append("target:");
            hw hwVar = this.f749a;
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
        String str2 = this.f752b;
        if (str2 == null) {
            sb.append(StringUtil.NULL_STRING);
        } else {
            sb.append(str2);
        }
        if (d()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("appId:");
            String str3 = this.f753c;
            if (str3 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str3);
            }
        }
        if (e()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("errorCode:");
            sb.append(this.f748a);
        }
        if (f()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("reason:");
            String str4 = this.f754d;
            if (str4 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str4);
            }
        }
        if (g()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append(UrlSchemaHelper.SCHEMA_TYPE_TOPIC);
            String str5 = this.f755e;
            if (str5 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str5);
            }
        }
        if (h()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("packageName:");
            String str6 = this.f756f;
            if (str6 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str6);
            }
        }
        if (i()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("category:");
            String str7 = this.f757g;
            if (str7 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str7);
            }
        }
        sb.append(SmallTailInfo.EMOTION_SUFFIX);
        return sb.toString();
    }
}
