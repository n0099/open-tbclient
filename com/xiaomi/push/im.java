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
    public long f743a;

    /* renamed from: a  reason: collision with other field name */
    public hw f744a;

    /* renamed from: a  reason: collision with other field name */
    public String f745a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f746a = new BitSet(1);

    /* renamed from: b  reason: collision with other field name */
    public String f747b;

    /* renamed from: c  reason: collision with other field name */
    public String f748c;

    /* renamed from: d  reason: collision with other field name */
    public String f749d;

    /* renamed from: e  reason: collision with other field name */
    public String f750e;

    /* renamed from: f  reason: collision with other field name */
    public String f751f;

    /* renamed from: g  reason: collision with other field name */
    public String f752g;

    /* renamed from: a  reason: collision with other field name */
    public static final ji f742a = new ji("XmPushActionSubscriptionResult");
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
            int compareTo = Boolean.valueOf(m684a()).compareTo(Boolean.valueOf(imVar.m684a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m684a() || (a10 = it.a(this.f745a, imVar.f745a)) == 0) {
                int compareTo2 = Boolean.valueOf(m686b()).compareTo(Boolean.valueOf(imVar.m686b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!m686b() || (a9 = it.a(this.f744a, imVar.f744a)) == 0) {
                    int compareTo3 = Boolean.valueOf(m687c()).compareTo(Boolean.valueOf(imVar.m687c()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!m687c() || (a8 = it.a(this.f747b, imVar.f747b)) == 0) {
                        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(imVar.d()));
                        if (compareTo4 != 0) {
                            return compareTo4;
                        }
                        if (!d() || (a7 = it.a(this.f748c, imVar.f748c)) == 0) {
                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(imVar.e()));
                            if (compareTo5 != 0) {
                                return compareTo5;
                            }
                            if (!e() || (a6 = it.a(this.f743a, imVar.f743a)) == 0) {
                                int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(imVar.f()));
                                if (compareTo6 != 0) {
                                    return compareTo6;
                                }
                                if (!f() || (a5 = it.a(this.f749d, imVar.f749d)) == 0) {
                                    int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(imVar.g()));
                                    if (compareTo7 != 0) {
                                        return compareTo7;
                                    }
                                    if (!g() || (a4 = it.a(this.f750e, imVar.f750e)) == 0) {
                                        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(imVar.h()));
                                        if (compareTo8 != 0) {
                                            return compareTo8;
                                        }
                                        if (!h() || (a3 = it.a(this.f751f, imVar.f751f)) == 0) {
                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(imVar.i()));
                                            if (compareTo9 != 0) {
                                                return compareTo9;
                                            }
                                            if (!i() || (a2 = it.a(this.f752g, imVar.f752g)) == 0) {
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
        return this.f747b;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m683a() {
        if (this.f747b != null) {
            return;
        }
        throw new je("Required field 'id' was not present! Struct: " + toString());
    }

    @Override // com.xiaomi.push.is
    public void a(jd jdVar) {
        jdVar.mo710a();
        while (true) {
            ja mo706a = jdVar.mo706a();
            byte b2 = mo706a.a;
            if (b2 == 0) {
                jdVar.f();
                m683a();
                return;
            }
            switch (mo706a.f809a) {
                case 1:
                    if (b2 == 11) {
                        this.f745a = jdVar.mo711a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 2:
                    if (b2 == 12) {
                        hw hwVar = new hw();
                        this.f744a = hwVar;
                        hwVar.a(jdVar);
                        continue;
                        jdVar.g();
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f747b = jdVar.mo711a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f748c = jdVar.mo711a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 6:
                    if (b2 == 10) {
                        this.f743a = jdVar.mo705a();
                        a(true);
                        continue;
                        jdVar.g();
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f749d = jdVar.mo711a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 8:
                    if (b2 == 11) {
                        this.f750e = jdVar.mo711a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 9:
                    if (b2 == 11) {
                        this.f751f = jdVar.mo711a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 10:
                    if (b2 == 11) {
                        this.f752g = jdVar.mo711a();
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
        this.f746a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m684a() {
        return this.f745a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m685a(im imVar) {
        if (imVar == null) {
            return false;
        }
        boolean m684a = m684a();
        boolean m684a2 = imVar.m684a();
        if ((m684a || m684a2) && !(m684a && m684a2 && this.f745a.equals(imVar.f745a))) {
            return false;
        }
        boolean m686b = m686b();
        boolean m686b2 = imVar.m686b();
        if ((m686b || m686b2) && !(m686b && m686b2 && this.f744a.m606a(imVar.f744a))) {
            return false;
        }
        boolean m687c = m687c();
        boolean m687c2 = imVar.m687c();
        if ((m687c || m687c2) && !(m687c && m687c2 && this.f747b.equals(imVar.f747b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = imVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f748c.equals(imVar.f748c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = imVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f743a == imVar.f743a)) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = imVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f749d.equals(imVar.f749d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = imVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f750e.equals(imVar.f750e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = imVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f751f.equals(imVar.f751f))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = imVar.i();
        if (i2 || i3) {
            return i2 && i3 && this.f752g.equals(imVar.f752g);
        }
        return true;
    }

    public String b() {
        return this.f750e;
    }

    @Override // com.xiaomi.push.is
    public void b(jd jdVar) {
        m683a();
        jdVar.a(f742a);
        if (this.f745a != null && m684a()) {
            jdVar.a(a);
            jdVar.a(this.f745a);
            jdVar.b();
        }
        if (this.f744a != null && m686b()) {
            jdVar.a(b);
            this.f744a.b(jdVar);
            jdVar.b();
        }
        if (this.f747b != null) {
            jdVar.a(c);
            jdVar.a(this.f747b);
            jdVar.b();
        }
        if (this.f748c != null && d()) {
            jdVar.a(d);
            jdVar.a(this.f748c);
            jdVar.b();
        }
        if (e()) {
            jdVar.a(e);
            jdVar.a(this.f743a);
            jdVar.b();
        }
        if (this.f749d != null && f()) {
            jdVar.a(f);
            jdVar.a(this.f749d);
            jdVar.b();
        }
        if (this.f750e != null && g()) {
            jdVar.a(g);
            jdVar.a(this.f750e);
            jdVar.b();
        }
        if (this.f751f != null && h()) {
            jdVar.a(h);
            jdVar.a(this.f751f);
            jdVar.b();
        }
        if (this.f752g != null && i()) {
            jdVar.a(i);
            jdVar.a(this.f752g);
            jdVar.b();
        }
        jdVar.c();
        jdVar.mo714a();
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m686b() {
        return this.f744a != null;
    }

    public String c() {
        return this.f752g;
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m687c() {
        return this.f747b != null;
    }

    public boolean d() {
        return this.f748c != null;
    }

    public boolean e() {
        return this.f746a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof im)) {
            return m685a((im) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f749d != null;
    }

    public boolean g() {
        return this.f750e != null;
    }

    public boolean h() {
        return this.f751f != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f752g != null;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionSubscriptionResult(");
        boolean z2 = false;
        if (m684a()) {
            sb.append("debug:");
            String str = this.f745a;
            if (str == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (m686b()) {
            if (!z) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            }
            sb.append("target:");
            hw hwVar = this.f744a;
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
        String str2 = this.f747b;
        if (str2 == null) {
            sb.append(StringUtil.NULL_STRING);
        } else {
            sb.append(str2);
        }
        if (d()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("appId:");
            String str3 = this.f748c;
            if (str3 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str3);
            }
        }
        if (e()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("errorCode:");
            sb.append(this.f743a);
        }
        if (f()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("reason:");
            String str4 = this.f749d;
            if (str4 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str4);
            }
        }
        if (g()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append(UrlSchemaHelper.SCHEMA_TYPE_TOPIC);
            String str5 = this.f750e;
            if (str5 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str5);
            }
        }
        if (h()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("packageName:");
            String str6 = this.f751f;
            if (str6 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str6);
            }
        }
        if (i()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("category:");
            String str7 = this.f752g;
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
