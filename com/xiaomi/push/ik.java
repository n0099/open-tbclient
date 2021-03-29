package com.xiaomi.push;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import io.flutter.plugin.common.StandardMessageCodec;
import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes7.dex */
public class ik implements iq<ik, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f742a;

    /* renamed from: a  reason: collision with other field name */
    public hu f743a;

    /* renamed from: a  reason: collision with other field name */
    public String f744a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f745a = new BitSet(1);

    /* renamed from: b  reason: collision with other field name */
    public String f746b;

    /* renamed from: c  reason: collision with other field name */
    public String f747c;

    /* renamed from: d  reason: collision with other field name */
    public String f748d;

    /* renamed from: e  reason: collision with other field name */
    public String f749e;

    /* renamed from: f  reason: collision with other field name */
    public String f750f;

    /* renamed from: g  reason: collision with other field name */
    public String f751g;

    /* renamed from: a  reason: collision with other field name */
    public static final jg f741a = new jg("XmPushActionSubscriptionResult");

    /* renamed from: a  reason: collision with root package name */
    public static final iy f40814a = new iy("", (byte) 11, 1);

    /* renamed from: b  reason: collision with root package name */
    public static final iy f40815b = new iy("", StandardMessageCodec.LIST, 2);

    /* renamed from: c  reason: collision with root package name */
    public static final iy f40816c = new iy("", (byte) 11, 3);

    /* renamed from: d  reason: collision with root package name */
    public static final iy f40817d = new iy("", (byte) 11, 4);

    /* renamed from: e  reason: collision with root package name */
    public static final iy f40818e = new iy("", (byte) 10, 6);

    /* renamed from: f  reason: collision with root package name */
    public static final iy f40819f = new iy("", (byte) 11, 7);

    /* renamed from: g  reason: collision with root package name */
    public static final iy f40820g = new iy("", (byte) 11, 8);

    /* renamed from: h  reason: collision with root package name */
    public static final iy f40821h = new iy("", (byte) 11, 9);
    public static final iy i = new iy("", (byte) 11, 10);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(ik ikVar) {
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        int a8;
        int a9;
        int a10;
        if (ik.class.equals(ikVar.getClass())) {
            int compareTo = Boolean.valueOf(m479a()).compareTo(Boolean.valueOf(ikVar.m479a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m479a() || (a10 = ir.a(this.f744a, ikVar.f744a)) == 0) {
                int compareTo2 = Boolean.valueOf(m481b()).compareTo(Boolean.valueOf(ikVar.m481b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!m481b() || (a9 = ir.a(this.f743a, ikVar.f743a)) == 0) {
                    int compareTo3 = Boolean.valueOf(m482c()).compareTo(Boolean.valueOf(ikVar.m482c()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!m482c() || (a8 = ir.a(this.f746b, ikVar.f746b)) == 0) {
                        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(ikVar.d()));
                        if (compareTo4 != 0) {
                            return compareTo4;
                        }
                        if (!d() || (a7 = ir.a(this.f747c, ikVar.f747c)) == 0) {
                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(ikVar.e()));
                            if (compareTo5 != 0) {
                                return compareTo5;
                            }
                            if (!e() || (a6 = ir.a(this.f742a, ikVar.f742a)) == 0) {
                                int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(ikVar.f()));
                                if (compareTo6 != 0) {
                                    return compareTo6;
                                }
                                if (!f() || (a5 = ir.a(this.f748d, ikVar.f748d)) == 0) {
                                    int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ikVar.g()));
                                    if (compareTo7 != 0) {
                                        return compareTo7;
                                    }
                                    if (!g() || (a4 = ir.a(this.f749e, ikVar.f749e)) == 0) {
                                        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(ikVar.h()));
                                        if (compareTo8 != 0) {
                                            return compareTo8;
                                        }
                                        if (!h() || (a3 = ir.a(this.f750f, ikVar.f750f)) == 0) {
                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(ikVar.i()));
                                            if (compareTo9 != 0) {
                                                return compareTo9;
                                            }
                                            if (!i() || (a2 = ir.a(this.f751g, ikVar.f751g)) == 0) {
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
        return ik.class.getName().compareTo(ikVar.getClass().getName());
    }

    public String a() {
        return this.f746b;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m478a() {
        if (this.f746b != null) {
            return;
        }
        throw new jc("Required field 'id' was not present! Struct: " + toString());
    }

    @Override // com.xiaomi.push.iq
    public void a(jb jbVar) {
        jbVar.m505a();
        while (true) {
            iy m501a = jbVar.m501a();
            byte b2 = m501a.f40867a;
            if (b2 == 0) {
                jbVar.f();
                m478a();
                return;
            }
            switch (m501a.f807a) {
                case 1:
                    if (b2 == 11) {
                        this.f744a = jbVar.m506a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 2:
                    if (b2 == 12) {
                        hu huVar = new hu();
                        this.f743a = huVar;
                        huVar.a(jbVar);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f746b = jbVar.m506a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f747c = jbVar.m506a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 6:
                    if (b2 == 10) {
                        this.f742a = jbVar.m500a();
                        a(true);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f748d = jbVar.m506a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 8:
                    if (b2 == 11) {
                        this.f749e = jbVar.m506a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 9:
                    if (b2 == 11) {
                        this.f750f = jbVar.m506a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 10:
                    if (b2 == 11) {
                        this.f751g = jbVar.m506a();
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
        this.f745a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m479a() {
        return this.f744a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m480a(ik ikVar) {
        if (ikVar == null) {
            return false;
        }
        boolean m479a = m479a();
        boolean m479a2 = ikVar.m479a();
        if ((m479a || m479a2) && !(m479a && m479a2 && this.f744a.equals(ikVar.f744a))) {
            return false;
        }
        boolean m481b = m481b();
        boolean m481b2 = ikVar.m481b();
        if ((m481b || m481b2) && !(m481b && m481b2 && this.f743a.m400a(ikVar.f743a))) {
            return false;
        }
        boolean m482c = m482c();
        boolean m482c2 = ikVar.m482c();
        if ((m482c || m482c2) && !(m482c && m482c2 && this.f746b.equals(ikVar.f746b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = ikVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f747c.equals(ikVar.f747c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = ikVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f742a == ikVar.f742a)) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = ikVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f748d.equals(ikVar.f748d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = ikVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f749e.equals(ikVar.f749e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = ikVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f750f.equals(ikVar.f750f))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = ikVar.i();
        if (i2 || i3) {
            return i2 && i3 && this.f751g.equals(ikVar.f751g);
        }
        return true;
    }

    public String b() {
        return this.f749e;
    }

    @Override // com.xiaomi.push.iq
    public void b(jb jbVar) {
        m478a();
        jbVar.a(f741a);
        if (this.f744a != null && m479a()) {
            jbVar.a(f40814a);
            jbVar.a(this.f744a);
            jbVar.b();
        }
        if (this.f743a != null && m481b()) {
            jbVar.a(f40815b);
            this.f743a.b(jbVar);
            jbVar.b();
        }
        if (this.f746b != null) {
            jbVar.a(f40816c);
            jbVar.a(this.f746b);
            jbVar.b();
        }
        if (this.f747c != null && d()) {
            jbVar.a(f40817d);
            jbVar.a(this.f747c);
            jbVar.b();
        }
        if (e()) {
            jbVar.a(f40818e);
            jbVar.a(this.f742a);
            jbVar.b();
        }
        if (this.f748d != null && f()) {
            jbVar.a(f40819f);
            jbVar.a(this.f748d);
            jbVar.b();
        }
        if (this.f749e != null && g()) {
            jbVar.a(f40820g);
            jbVar.a(this.f749e);
            jbVar.b();
        }
        if (this.f750f != null && h()) {
            jbVar.a(f40821h);
            jbVar.a(this.f750f);
            jbVar.b();
        }
        if (this.f751g != null && i()) {
            jbVar.a(i);
            jbVar.a(this.f751g);
            jbVar.b();
        }
        jbVar.c();
        jbVar.m509a();
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m481b() {
        return this.f743a != null;
    }

    public String c() {
        return this.f751g;
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m482c() {
        return this.f746b != null;
    }

    public boolean d() {
        return this.f747c != null;
    }

    public boolean e() {
        return this.f745a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ik)) {
            return m480a((ik) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f748d != null;
    }

    public boolean g() {
        return this.f749e != null;
    }

    public boolean h() {
        return this.f750f != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f751g != null;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionSubscriptionResult(");
        boolean z2 = false;
        if (m479a()) {
            sb.append("debug:");
            String str = this.f744a;
            if (str == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (m481b()) {
            if (!z) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            }
            sb.append("target:");
            hu huVar = this.f743a;
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
        String str2 = this.f746b;
        if (str2 == null) {
            sb.append(StringUtil.NULL_STRING);
        } else {
            sb.append(str2);
        }
        if (d()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("appId:");
            String str3 = this.f747c;
            if (str3 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str3);
            }
        }
        if (e()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("errorCode:");
            sb.append(this.f742a);
        }
        if (f()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("reason:");
            String str4 = this.f748d;
            if (str4 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str4);
            }
        }
        if (g()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append(UrlSchemaHelper.SCHEMA_TYPE_TOPIC);
            String str5 = this.f749e;
            if (str5 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str5);
            }
        }
        if (h()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("packageName:");
            String str6 = this.f750f;
            if (str6 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str6);
            }
        }
        if (i()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("category:");
            String str7 = this.f751g;
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
