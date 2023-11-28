package com.xiaomi.push;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes10.dex */
public class iq implements is<iq, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f788a;

    /* renamed from: a  reason: collision with other field name */
    public hw f789a;

    /* renamed from: a  reason: collision with other field name */
    public String f790a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f791a = new BitSet(1);

    /* renamed from: b  reason: collision with other field name */
    public String f792b;

    /* renamed from: c  reason: collision with other field name */
    public String f793c;

    /* renamed from: d  reason: collision with other field name */
    public String f794d;

    /* renamed from: e  reason: collision with other field name */
    public String f795e;

    /* renamed from: f  reason: collision with other field name */
    public String f796f;

    /* renamed from: g  reason: collision with other field name */
    public String f797g;

    /* renamed from: a  reason: collision with other field name */
    public static final ji f787a = new ji("XmPushActionUnSubscriptionResult");
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
    public int compareTo(iq iqVar) {
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        int a8;
        int a9;
        int a10;
        if (iq.class.equals(iqVar.getClass())) {
            int compareTo = Boolean.valueOf(m696a()).compareTo(Boolean.valueOf(iqVar.m696a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m696a() || (a10 = it.a(this.f790a, iqVar.f790a)) == 0) {
                int compareTo2 = Boolean.valueOf(m698b()).compareTo(Boolean.valueOf(iqVar.m698b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!m698b() || (a9 = it.a(this.f789a, iqVar.f789a)) == 0) {
                    int compareTo3 = Boolean.valueOf(m699c()).compareTo(Boolean.valueOf(iqVar.m699c()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!m699c() || (a8 = it.a(this.f792b, iqVar.f792b)) == 0) {
                        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(iqVar.d()));
                        if (compareTo4 != 0) {
                            return compareTo4;
                        }
                        if (!d() || (a7 = it.a(this.f793c, iqVar.f793c)) == 0) {
                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(iqVar.e()));
                            if (compareTo5 != 0) {
                                return compareTo5;
                            }
                            if (!e() || (a6 = it.a(this.f788a, iqVar.f788a)) == 0) {
                                int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(iqVar.f()));
                                if (compareTo6 != 0) {
                                    return compareTo6;
                                }
                                if (!f() || (a5 = it.a(this.f794d, iqVar.f794d)) == 0) {
                                    int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(iqVar.g()));
                                    if (compareTo7 != 0) {
                                        return compareTo7;
                                    }
                                    if (!g() || (a4 = it.a(this.f795e, iqVar.f795e)) == 0) {
                                        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(iqVar.h()));
                                        if (compareTo8 != 0) {
                                            return compareTo8;
                                        }
                                        if (!h() || (a3 = it.a(this.f796f, iqVar.f796f)) == 0) {
                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(iqVar.i()));
                                            if (compareTo9 != 0) {
                                                return compareTo9;
                                            }
                                            if (!i() || (a2 = it.a(this.f797g, iqVar.f797g)) == 0) {
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
        return iq.class.getName().compareTo(iqVar.getClass().getName());
    }

    public String a() {
        return this.f792b;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m695a() {
        if (this.f792b != null) {
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
                m695a();
                return;
            }
            switch (mo706a.f809a) {
                case 1:
                    if (b2 == 11) {
                        this.f790a = jdVar.mo711a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 2:
                    if (b2 == 12) {
                        hw hwVar = new hw();
                        this.f789a = hwVar;
                        hwVar.a(jdVar);
                        continue;
                        jdVar.g();
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f792b = jdVar.mo711a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f793c = jdVar.mo711a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 6:
                    if (b2 == 10) {
                        this.f788a = jdVar.mo705a();
                        a(true);
                        continue;
                        jdVar.g();
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f794d = jdVar.mo711a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 8:
                    if (b2 == 11) {
                        this.f795e = jdVar.mo711a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 9:
                    if (b2 == 11) {
                        this.f796f = jdVar.mo711a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 10:
                    if (b2 == 11) {
                        this.f797g = jdVar.mo711a();
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
        this.f791a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m696a() {
        return this.f790a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m697a(iq iqVar) {
        if (iqVar == null) {
            return false;
        }
        boolean m696a = m696a();
        boolean m696a2 = iqVar.m696a();
        if ((m696a || m696a2) && !(m696a && m696a2 && this.f790a.equals(iqVar.f790a))) {
            return false;
        }
        boolean m698b = m698b();
        boolean m698b2 = iqVar.m698b();
        if ((m698b || m698b2) && !(m698b && m698b2 && this.f789a.m606a(iqVar.f789a))) {
            return false;
        }
        boolean m699c = m699c();
        boolean m699c2 = iqVar.m699c();
        if ((m699c || m699c2) && !(m699c && m699c2 && this.f792b.equals(iqVar.f792b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = iqVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f793c.equals(iqVar.f793c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = iqVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f788a == iqVar.f788a)) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = iqVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f794d.equals(iqVar.f794d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = iqVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f795e.equals(iqVar.f795e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = iqVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f796f.equals(iqVar.f796f))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = iqVar.i();
        if (i2 || i3) {
            return i2 && i3 && this.f797g.equals(iqVar.f797g);
        }
        return true;
    }

    public String b() {
        return this.f795e;
    }

    @Override // com.xiaomi.push.is
    public void b(jd jdVar) {
        m695a();
        jdVar.a(f787a);
        if (this.f790a != null && m696a()) {
            jdVar.a(a);
            jdVar.a(this.f790a);
            jdVar.b();
        }
        if (this.f789a != null && m698b()) {
            jdVar.a(b);
            this.f789a.b(jdVar);
            jdVar.b();
        }
        if (this.f792b != null) {
            jdVar.a(c);
            jdVar.a(this.f792b);
            jdVar.b();
        }
        if (this.f793c != null && d()) {
            jdVar.a(d);
            jdVar.a(this.f793c);
            jdVar.b();
        }
        if (e()) {
            jdVar.a(e);
            jdVar.a(this.f788a);
            jdVar.b();
        }
        if (this.f794d != null && f()) {
            jdVar.a(f);
            jdVar.a(this.f794d);
            jdVar.b();
        }
        if (this.f795e != null && g()) {
            jdVar.a(g);
            jdVar.a(this.f795e);
            jdVar.b();
        }
        if (this.f796f != null && h()) {
            jdVar.a(h);
            jdVar.a(this.f796f);
            jdVar.b();
        }
        if (this.f797g != null && i()) {
            jdVar.a(i);
            jdVar.a(this.f797g);
            jdVar.b();
        }
        jdVar.c();
        jdVar.mo714a();
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m698b() {
        return this.f789a != null;
    }

    public String c() {
        return this.f797g;
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m699c() {
        return this.f792b != null;
    }

    public boolean d() {
        return this.f793c != null;
    }

    public boolean e() {
        return this.f791a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof iq)) {
            return m697a((iq) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f794d != null;
    }

    public boolean g() {
        return this.f795e != null;
    }

    public boolean h() {
        return this.f796f != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f797g != null;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionUnSubscriptionResult(");
        boolean z2 = false;
        if (m696a()) {
            sb.append("debug:");
            String str = this.f790a;
            if (str == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (m698b()) {
            if (!z) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            }
            sb.append("target:");
            hw hwVar = this.f789a;
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
        String str2 = this.f792b;
        if (str2 == null) {
            sb.append(StringUtil.NULL_STRING);
        } else {
            sb.append(str2);
        }
        if (d()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("appId:");
            String str3 = this.f793c;
            if (str3 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str3);
            }
        }
        if (e()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("errorCode:");
            sb.append(this.f788a);
        }
        if (f()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("reason:");
            String str4 = this.f794d;
            if (str4 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str4);
            }
        }
        if (g()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append(UrlSchemaHelper.SCHEMA_TYPE_TOPIC);
            String str5 = this.f795e;
            if (str5 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str5);
            }
        }
        if (h()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("packageName:");
            String str6 = this.f796f;
            if (str6 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str6);
            }
        }
        if (i()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("category:");
            String str7 = this.f797g;
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
