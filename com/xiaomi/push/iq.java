package com.xiaomi.push;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes9.dex */
public class iq implements is<iq, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f792a;

    /* renamed from: a  reason: collision with other field name */
    public hw f793a;

    /* renamed from: a  reason: collision with other field name */
    public String f794a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f795a = new BitSet(1);

    /* renamed from: b  reason: collision with other field name */
    public String f796b;

    /* renamed from: c  reason: collision with other field name */
    public String f797c;

    /* renamed from: d  reason: collision with other field name */
    public String f798d;

    /* renamed from: e  reason: collision with other field name */
    public String f799e;

    /* renamed from: f  reason: collision with other field name */
    public String f800f;

    /* renamed from: g  reason: collision with other field name */
    public String f801g;

    /* renamed from: a  reason: collision with other field name */
    public static final ji f791a = new ji("XmPushActionUnSubscriptionResult");
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
            int compareTo = Boolean.valueOf(m607a()).compareTo(Boolean.valueOf(iqVar.m607a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m607a() || (a10 = it.a(this.f794a, iqVar.f794a)) == 0) {
                int compareTo2 = Boolean.valueOf(m609b()).compareTo(Boolean.valueOf(iqVar.m609b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!m609b() || (a9 = it.a(this.f793a, iqVar.f793a)) == 0) {
                    int compareTo3 = Boolean.valueOf(m610c()).compareTo(Boolean.valueOf(iqVar.m610c()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!m610c() || (a8 = it.a(this.f796b, iqVar.f796b)) == 0) {
                        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(iqVar.d()));
                        if (compareTo4 != 0) {
                            return compareTo4;
                        }
                        if (!d() || (a7 = it.a(this.f797c, iqVar.f797c)) == 0) {
                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(iqVar.e()));
                            if (compareTo5 != 0) {
                                return compareTo5;
                            }
                            if (!e() || (a6 = it.a(this.f792a, iqVar.f792a)) == 0) {
                                int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(iqVar.f()));
                                if (compareTo6 != 0) {
                                    return compareTo6;
                                }
                                if (!f() || (a5 = it.a(this.f798d, iqVar.f798d)) == 0) {
                                    int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(iqVar.g()));
                                    if (compareTo7 != 0) {
                                        return compareTo7;
                                    }
                                    if (!g() || (a4 = it.a(this.f799e, iqVar.f799e)) == 0) {
                                        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(iqVar.h()));
                                        if (compareTo8 != 0) {
                                            return compareTo8;
                                        }
                                        if (!h() || (a3 = it.a(this.f800f, iqVar.f800f)) == 0) {
                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(iqVar.i()));
                                            if (compareTo9 != 0) {
                                                return compareTo9;
                                            }
                                            if (!i() || (a2 = it.a(this.f801g, iqVar.f801g)) == 0) {
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
        return this.f796b;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m606a() {
        if (this.f796b != null) {
            return;
        }
        throw new je("Required field 'id' was not present! Struct: " + toString());
    }

    @Override // com.xiaomi.push.is
    public void a(jd jdVar) {
        jdVar.mo621a();
        while (true) {
            ja mo617a = jdVar.mo617a();
            byte b2 = mo617a.a;
            if (b2 == 0) {
                jdVar.f();
                m606a();
                return;
            }
            switch (mo617a.f813a) {
                case 1:
                    if (b2 == 11) {
                        this.f794a = jdVar.mo622a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 2:
                    if (b2 == 12) {
                        hw hwVar = new hw();
                        this.f793a = hwVar;
                        hwVar.a(jdVar);
                        continue;
                        jdVar.g();
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f796b = jdVar.mo622a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f797c = jdVar.mo622a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 6:
                    if (b2 == 10) {
                        this.f792a = jdVar.mo616a();
                        a(true);
                        continue;
                        jdVar.g();
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f798d = jdVar.mo622a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 8:
                    if (b2 == 11) {
                        this.f799e = jdVar.mo622a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 9:
                    if (b2 == 11) {
                        this.f800f = jdVar.mo622a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 10:
                    if (b2 == 11) {
                        this.f801g = jdVar.mo622a();
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
        this.f795a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m607a() {
        return this.f794a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m608a(iq iqVar) {
        if (iqVar == null) {
            return false;
        }
        boolean m607a = m607a();
        boolean m607a2 = iqVar.m607a();
        if ((m607a || m607a2) && !(m607a && m607a2 && this.f794a.equals(iqVar.f794a))) {
            return false;
        }
        boolean m609b = m609b();
        boolean m609b2 = iqVar.m609b();
        if ((m609b || m609b2) && !(m609b && m609b2 && this.f793a.m517a(iqVar.f793a))) {
            return false;
        }
        boolean m610c = m610c();
        boolean m610c2 = iqVar.m610c();
        if ((m610c || m610c2) && !(m610c && m610c2 && this.f796b.equals(iqVar.f796b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = iqVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f797c.equals(iqVar.f797c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = iqVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f792a == iqVar.f792a)) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = iqVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f798d.equals(iqVar.f798d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = iqVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f799e.equals(iqVar.f799e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = iqVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f800f.equals(iqVar.f800f))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = iqVar.i();
        if (i2 || i3) {
            return i2 && i3 && this.f801g.equals(iqVar.f801g);
        }
        return true;
    }

    public String b() {
        return this.f799e;
    }

    @Override // com.xiaomi.push.is
    public void b(jd jdVar) {
        m606a();
        jdVar.a(f791a);
        if (this.f794a != null && m607a()) {
            jdVar.a(a);
            jdVar.a(this.f794a);
            jdVar.b();
        }
        if (this.f793a != null && m609b()) {
            jdVar.a(b);
            this.f793a.b(jdVar);
            jdVar.b();
        }
        if (this.f796b != null) {
            jdVar.a(c);
            jdVar.a(this.f796b);
            jdVar.b();
        }
        if (this.f797c != null && d()) {
            jdVar.a(d);
            jdVar.a(this.f797c);
            jdVar.b();
        }
        if (e()) {
            jdVar.a(e);
            jdVar.a(this.f792a);
            jdVar.b();
        }
        if (this.f798d != null && f()) {
            jdVar.a(f);
            jdVar.a(this.f798d);
            jdVar.b();
        }
        if (this.f799e != null && g()) {
            jdVar.a(g);
            jdVar.a(this.f799e);
            jdVar.b();
        }
        if (this.f800f != null && h()) {
            jdVar.a(h);
            jdVar.a(this.f800f);
            jdVar.b();
        }
        if (this.f801g != null && i()) {
            jdVar.a(i);
            jdVar.a(this.f801g);
            jdVar.b();
        }
        jdVar.c();
        jdVar.mo625a();
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m609b() {
        return this.f793a != null;
    }

    public String c() {
        return this.f801g;
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m610c() {
        return this.f796b != null;
    }

    public boolean d() {
        return this.f797c != null;
    }

    public boolean e() {
        return this.f795a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof iq)) {
            return m608a((iq) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f798d != null;
    }

    public boolean g() {
        return this.f799e != null;
    }

    public boolean h() {
        return this.f800f != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f801g != null;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionUnSubscriptionResult(");
        boolean z2 = false;
        if (m607a()) {
            sb.append("debug:");
            String str = this.f794a;
            if (str == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (m609b()) {
            if (!z) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            }
            sb.append("target:");
            hw hwVar = this.f793a;
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
        String str2 = this.f796b;
        if (str2 == null) {
            sb.append(StringUtil.NULL_STRING);
        } else {
            sb.append(str2);
        }
        if (d()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("appId:");
            String str3 = this.f797c;
            if (str3 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str3);
            }
        }
        if (e()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("errorCode:");
            sb.append(this.f792a);
        }
        if (f()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("reason:");
            String str4 = this.f798d;
            if (str4 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str4);
            }
        }
        if (g()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append(UrlSchemaHelper.SCHEMA_TYPE_TOPIC);
            String str5 = this.f799e;
            if (str5 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str5);
            }
        }
        if (h()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("packageName:");
            String str6 = this.f800f;
            if (str6 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str6);
            }
        }
        if (i()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("category:");
            String str7 = this.f801g;
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
