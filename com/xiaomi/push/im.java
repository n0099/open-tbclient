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
    public long f747a;

    /* renamed from: a  reason: collision with other field name */
    public hw f748a;

    /* renamed from: a  reason: collision with other field name */
    public String f749a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f750a = new BitSet(1);

    /* renamed from: b  reason: collision with other field name */
    public String f751b;

    /* renamed from: c  reason: collision with other field name */
    public String f752c;

    /* renamed from: d  reason: collision with other field name */
    public String f753d;

    /* renamed from: e  reason: collision with other field name */
    public String f754e;

    /* renamed from: f  reason: collision with other field name */
    public String f755f;

    /* renamed from: g  reason: collision with other field name */
    public String f756g;

    /* renamed from: a  reason: collision with other field name */
    public static final ji f746a = new ji("XmPushActionSubscriptionResult");
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
            int compareTo = Boolean.valueOf(m672a()).compareTo(Boolean.valueOf(imVar.m672a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m672a() || (a10 = it.a(this.f749a, imVar.f749a)) == 0) {
                int compareTo2 = Boolean.valueOf(m674b()).compareTo(Boolean.valueOf(imVar.m674b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!m674b() || (a9 = it.a(this.f748a, imVar.f748a)) == 0) {
                    int compareTo3 = Boolean.valueOf(m675c()).compareTo(Boolean.valueOf(imVar.m675c()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!m675c() || (a8 = it.a(this.f751b, imVar.f751b)) == 0) {
                        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(imVar.d()));
                        if (compareTo4 != 0) {
                            return compareTo4;
                        }
                        if (!d() || (a7 = it.a(this.f752c, imVar.f752c)) == 0) {
                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(imVar.e()));
                            if (compareTo5 != 0) {
                                return compareTo5;
                            }
                            if (!e() || (a6 = it.a(this.f747a, imVar.f747a)) == 0) {
                                int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(imVar.f()));
                                if (compareTo6 != 0) {
                                    return compareTo6;
                                }
                                if (!f() || (a5 = it.a(this.f753d, imVar.f753d)) == 0) {
                                    int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(imVar.g()));
                                    if (compareTo7 != 0) {
                                        return compareTo7;
                                    }
                                    if (!g() || (a4 = it.a(this.f754e, imVar.f754e)) == 0) {
                                        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(imVar.h()));
                                        if (compareTo8 != 0) {
                                            return compareTo8;
                                        }
                                        if (!h() || (a3 = it.a(this.f755f, imVar.f755f)) == 0) {
                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(imVar.i()));
                                            if (compareTo9 != 0) {
                                                return compareTo9;
                                            }
                                            if (!i() || (a2 = it.a(this.f756g, imVar.f756g)) == 0) {
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
        return this.f751b;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m671a() {
        if (this.f751b != null) {
            return;
        }
        throw new je("Required field 'id' was not present! Struct: " + toString());
    }

    @Override // com.xiaomi.push.is
    public void a(jd jdVar) {
        jdVar.mo698a();
        while (true) {
            ja mo694a = jdVar.mo694a();
            byte b2 = mo694a.a;
            if (b2 == 0) {
                jdVar.f();
                m671a();
                return;
            }
            switch (mo694a.f813a) {
                case 1:
                    if (b2 == 11) {
                        this.f749a = jdVar.mo699a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 2:
                    if (b2 == 12) {
                        hw hwVar = new hw();
                        this.f748a = hwVar;
                        hwVar.a(jdVar);
                        continue;
                        jdVar.g();
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f751b = jdVar.mo699a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f752c = jdVar.mo699a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 6:
                    if (b2 == 10) {
                        this.f747a = jdVar.mo693a();
                        a(true);
                        continue;
                        jdVar.g();
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f753d = jdVar.mo699a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 8:
                    if (b2 == 11) {
                        this.f754e = jdVar.mo699a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 9:
                    if (b2 == 11) {
                        this.f755f = jdVar.mo699a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 10:
                    if (b2 == 11) {
                        this.f756g = jdVar.mo699a();
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
        this.f750a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m672a() {
        return this.f749a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m673a(im imVar) {
        if (imVar == null) {
            return false;
        }
        boolean m672a = m672a();
        boolean m672a2 = imVar.m672a();
        if ((m672a || m672a2) && !(m672a && m672a2 && this.f749a.equals(imVar.f749a))) {
            return false;
        }
        boolean m674b = m674b();
        boolean m674b2 = imVar.m674b();
        if ((m674b || m674b2) && !(m674b && m674b2 && this.f748a.m594a(imVar.f748a))) {
            return false;
        }
        boolean m675c = m675c();
        boolean m675c2 = imVar.m675c();
        if ((m675c || m675c2) && !(m675c && m675c2 && this.f751b.equals(imVar.f751b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = imVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f752c.equals(imVar.f752c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = imVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f747a == imVar.f747a)) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = imVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f753d.equals(imVar.f753d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = imVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f754e.equals(imVar.f754e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = imVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f755f.equals(imVar.f755f))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = imVar.i();
        if (i2 || i3) {
            return i2 && i3 && this.f756g.equals(imVar.f756g);
        }
        return true;
    }

    public String b() {
        return this.f754e;
    }

    @Override // com.xiaomi.push.is
    public void b(jd jdVar) {
        m671a();
        jdVar.a(f746a);
        if (this.f749a != null && m672a()) {
            jdVar.a(a);
            jdVar.a(this.f749a);
            jdVar.b();
        }
        if (this.f748a != null && m674b()) {
            jdVar.a(b);
            this.f748a.b(jdVar);
            jdVar.b();
        }
        if (this.f751b != null) {
            jdVar.a(c);
            jdVar.a(this.f751b);
            jdVar.b();
        }
        if (this.f752c != null && d()) {
            jdVar.a(d);
            jdVar.a(this.f752c);
            jdVar.b();
        }
        if (e()) {
            jdVar.a(e);
            jdVar.a(this.f747a);
            jdVar.b();
        }
        if (this.f753d != null && f()) {
            jdVar.a(f);
            jdVar.a(this.f753d);
            jdVar.b();
        }
        if (this.f754e != null && g()) {
            jdVar.a(g);
            jdVar.a(this.f754e);
            jdVar.b();
        }
        if (this.f755f != null && h()) {
            jdVar.a(h);
            jdVar.a(this.f755f);
            jdVar.b();
        }
        if (this.f756g != null && i()) {
            jdVar.a(i);
            jdVar.a(this.f756g);
            jdVar.b();
        }
        jdVar.c();
        jdVar.mo702a();
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m674b() {
        return this.f748a != null;
    }

    public String c() {
        return this.f756g;
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m675c() {
        return this.f751b != null;
    }

    public boolean d() {
        return this.f752c != null;
    }

    public boolean e() {
        return this.f750a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof im)) {
            return m673a((im) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f753d != null;
    }

    public boolean g() {
        return this.f754e != null;
    }

    public boolean h() {
        return this.f755f != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f756g != null;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionSubscriptionResult(");
        boolean z2 = false;
        if (m672a()) {
            sb.append("debug:");
            String str = this.f749a;
            if (str == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (m674b()) {
            if (!z) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            }
            sb.append("target:");
            hw hwVar = this.f748a;
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
        String str2 = this.f751b;
        if (str2 == null) {
            sb.append(StringUtil.NULL_STRING);
        } else {
            sb.append(str2);
        }
        if (d()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("appId:");
            String str3 = this.f752c;
            if (str3 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str3);
            }
        }
        if (e()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("errorCode:");
            sb.append(this.f747a);
        }
        if (f()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("reason:");
            String str4 = this.f753d;
            if (str4 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str4);
            }
        }
        if (g()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append(UrlSchemaHelper.SCHEMA_TYPE_TOPIC);
            String str5 = this.f754e;
            if (str5 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str5);
            }
        }
        if (h()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("packageName:");
            String str6 = this.f755f;
            if (str6 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str6);
            }
        }
        if (i()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("category:");
            String str7 = this.f756g;
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
