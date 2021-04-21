package com.xiaomi.push;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import io.flutter.plugin.common.StandardMessageCodec;
import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes7.dex */
public class io implements iq<io, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f787a;

    /* renamed from: a  reason: collision with other field name */
    public hu f788a;

    /* renamed from: a  reason: collision with other field name */
    public String f789a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f790a = new BitSet(1);

    /* renamed from: b  reason: collision with other field name */
    public String f791b;

    /* renamed from: c  reason: collision with other field name */
    public String f792c;

    /* renamed from: d  reason: collision with other field name */
    public String f793d;

    /* renamed from: e  reason: collision with other field name */
    public String f794e;

    /* renamed from: f  reason: collision with other field name */
    public String f795f;

    /* renamed from: g  reason: collision with other field name */
    public String f796g;

    /* renamed from: a  reason: collision with other field name */
    public static final jg f786a = new jg("XmPushActionUnSubscriptionResult");

    /* renamed from: a  reason: collision with root package name */
    public static final iy f41230a = new iy("", (byte) 11, 1);

    /* renamed from: b  reason: collision with root package name */
    public static final iy f41231b = new iy("", StandardMessageCodec.LIST, 2);

    /* renamed from: c  reason: collision with root package name */
    public static final iy f41232c = new iy("", (byte) 11, 3);

    /* renamed from: d  reason: collision with root package name */
    public static final iy f41233d = new iy("", (byte) 11, 4);

    /* renamed from: e  reason: collision with root package name */
    public static final iy f41234e = new iy("", (byte) 10, 6);

    /* renamed from: f  reason: collision with root package name */
    public static final iy f41235f = new iy("", (byte) 11, 7);

    /* renamed from: g  reason: collision with root package name */
    public static final iy f41236g = new iy("", (byte) 11, 8);

    /* renamed from: h  reason: collision with root package name */
    public static final iy f41237h = new iy("", (byte) 11, 9);
    public static final iy i = new iy("", (byte) 11, 10);

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
            int compareTo = Boolean.valueOf(m495a()).compareTo(Boolean.valueOf(ioVar.m495a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m495a() || (a10 = ir.a(this.f789a, ioVar.f789a)) == 0) {
                int compareTo2 = Boolean.valueOf(m497b()).compareTo(Boolean.valueOf(ioVar.m497b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!m497b() || (a9 = ir.a(this.f788a, ioVar.f788a)) == 0) {
                    int compareTo3 = Boolean.valueOf(m498c()).compareTo(Boolean.valueOf(ioVar.m498c()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!m498c() || (a8 = ir.a(this.f791b, ioVar.f791b)) == 0) {
                        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(ioVar.d()));
                        if (compareTo4 != 0) {
                            return compareTo4;
                        }
                        if (!d() || (a7 = ir.a(this.f792c, ioVar.f792c)) == 0) {
                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(ioVar.e()));
                            if (compareTo5 != 0) {
                                return compareTo5;
                            }
                            if (!e() || (a6 = ir.a(this.f787a, ioVar.f787a)) == 0) {
                                int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(ioVar.f()));
                                if (compareTo6 != 0) {
                                    return compareTo6;
                                }
                                if (!f() || (a5 = ir.a(this.f793d, ioVar.f793d)) == 0) {
                                    int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ioVar.g()));
                                    if (compareTo7 != 0) {
                                        return compareTo7;
                                    }
                                    if (!g() || (a4 = ir.a(this.f794e, ioVar.f794e)) == 0) {
                                        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(ioVar.h()));
                                        if (compareTo8 != 0) {
                                            return compareTo8;
                                        }
                                        if (!h() || (a3 = ir.a(this.f795f, ioVar.f795f)) == 0) {
                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(ioVar.i()));
                                            if (compareTo9 != 0) {
                                                return compareTo9;
                                            }
                                            if (!i() || (a2 = ir.a(this.f796g, ioVar.f796g)) == 0) {
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
        return this.f791b;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m494a() {
        if (this.f791b != null) {
            return;
        }
        throw new jc("Required field 'id' was not present! Struct: " + toString());
    }

    @Override // com.xiaomi.push.iq
    public void a(jb jbVar) {
        jbVar.m509a();
        while (true) {
            iy m505a = jbVar.m505a();
            byte b2 = m505a.f41251a;
            if (b2 == 0) {
                jbVar.f();
                m494a();
                return;
            }
            switch (m505a.f807a) {
                case 1:
                    if (b2 == 11) {
                        this.f789a = jbVar.m510a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 2:
                    if (b2 == 12) {
                        hu huVar = new hu();
                        this.f788a = huVar;
                        huVar.a(jbVar);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f791b = jbVar.m510a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f792c = jbVar.m510a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 6:
                    if (b2 == 10) {
                        this.f787a = jbVar.m504a();
                        a(true);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f793d = jbVar.m510a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 8:
                    if (b2 == 11) {
                        this.f794e = jbVar.m510a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 9:
                    if (b2 == 11) {
                        this.f795f = jbVar.m510a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 10:
                    if (b2 == 11) {
                        this.f796g = jbVar.m510a();
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
        this.f790a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m495a() {
        return this.f789a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m496a(io ioVar) {
        if (ioVar == null) {
            return false;
        }
        boolean m495a = m495a();
        boolean m495a2 = ioVar.m495a();
        if ((m495a || m495a2) && !(m495a && m495a2 && this.f789a.equals(ioVar.f789a))) {
            return false;
        }
        boolean m497b = m497b();
        boolean m497b2 = ioVar.m497b();
        if ((m497b || m497b2) && !(m497b && m497b2 && this.f788a.m404a(ioVar.f788a))) {
            return false;
        }
        boolean m498c = m498c();
        boolean m498c2 = ioVar.m498c();
        if ((m498c || m498c2) && !(m498c && m498c2 && this.f791b.equals(ioVar.f791b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = ioVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f792c.equals(ioVar.f792c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = ioVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f787a == ioVar.f787a)) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = ioVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f793d.equals(ioVar.f793d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = ioVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f794e.equals(ioVar.f794e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = ioVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f795f.equals(ioVar.f795f))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = ioVar.i();
        if (i2 || i3) {
            return i2 && i3 && this.f796g.equals(ioVar.f796g);
        }
        return true;
    }

    public String b() {
        return this.f794e;
    }

    @Override // com.xiaomi.push.iq
    public void b(jb jbVar) {
        m494a();
        jbVar.a(f786a);
        if (this.f789a != null && m495a()) {
            jbVar.a(f41230a);
            jbVar.a(this.f789a);
            jbVar.b();
        }
        if (this.f788a != null && m497b()) {
            jbVar.a(f41231b);
            this.f788a.b(jbVar);
            jbVar.b();
        }
        if (this.f791b != null) {
            jbVar.a(f41232c);
            jbVar.a(this.f791b);
            jbVar.b();
        }
        if (this.f792c != null && d()) {
            jbVar.a(f41233d);
            jbVar.a(this.f792c);
            jbVar.b();
        }
        if (e()) {
            jbVar.a(f41234e);
            jbVar.a(this.f787a);
            jbVar.b();
        }
        if (this.f793d != null && f()) {
            jbVar.a(f41235f);
            jbVar.a(this.f793d);
            jbVar.b();
        }
        if (this.f794e != null && g()) {
            jbVar.a(f41236g);
            jbVar.a(this.f794e);
            jbVar.b();
        }
        if (this.f795f != null && h()) {
            jbVar.a(f41237h);
            jbVar.a(this.f795f);
            jbVar.b();
        }
        if (this.f796g != null && i()) {
            jbVar.a(i);
            jbVar.a(this.f796g);
            jbVar.b();
        }
        jbVar.c();
        jbVar.m513a();
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m497b() {
        return this.f788a != null;
    }

    public String c() {
        return this.f796g;
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m498c() {
        return this.f791b != null;
    }

    public boolean d() {
        return this.f792c != null;
    }

    public boolean e() {
        return this.f790a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof io)) {
            return m496a((io) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f793d != null;
    }

    public boolean g() {
        return this.f794e != null;
    }

    public boolean h() {
        return this.f795f != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f796g != null;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionUnSubscriptionResult(");
        boolean z2 = false;
        if (m495a()) {
            sb.append("debug:");
            String str = this.f789a;
            if (str == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (m497b()) {
            if (!z) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            }
            sb.append("target:");
            hu huVar = this.f788a;
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
        String str2 = this.f791b;
        if (str2 == null) {
            sb.append(StringUtil.NULL_STRING);
        } else {
            sb.append(str2);
        }
        if (d()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("appId:");
            String str3 = this.f792c;
            if (str3 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str3);
            }
        }
        if (e()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("errorCode:");
            sb.append(this.f787a);
        }
        if (f()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("reason:");
            String str4 = this.f793d;
            if (str4 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str4);
            }
        }
        if (g()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append(UrlSchemaHelper.SCHEMA_TYPE_TOPIC);
            String str5 = this.f794e;
            if (str5 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str5);
            }
        }
        if (h()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("packageName:");
            String str6 = this.f795f;
            if (str6 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str6);
            }
        }
        if (i()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("category:");
            String str7 = this.f796g;
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
