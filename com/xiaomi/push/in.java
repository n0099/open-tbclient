package com.xiaomi.push;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import io.flutter.plugin.common.StandardMessageCodec;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class in implements iq<in, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public hu f778a;

    /* renamed from: a  reason: collision with other field name */
    public String f779a;

    /* renamed from: a  reason: collision with other field name */
    public List<String> f780a;

    /* renamed from: b  reason: collision with other field name */
    public String f781b;

    /* renamed from: c  reason: collision with other field name */
    public String f782c;

    /* renamed from: d  reason: collision with other field name */
    public String f783d;

    /* renamed from: e  reason: collision with other field name */
    public String f784e;

    /* renamed from: f  reason: collision with other field name */
    public String f785f;

    /* renamed from: a  reason: collision with other field name */
    public static final jg f777a = new jg("XmPushActionUnSubscription");

    /* renamed from: a  reason: collision with root package name */
    public static final iy f38765a = new iy("", (byte) 11, 1);

    /* renamed from: b  reason: collision with root package name */
    public static final iy f38766b = new iy("", StandardMessageCodec.LIST, 2);

    /* renamed from: c  reason: collision with root package name */
    public static final iy f38767c = new iy("", (byte) 11, 3);

    /* renamed from: d  reason: collision with root package name */
    public static final iy f38768d = new iy("", (byte) 11, 4);

    /* renamed from: e  reason: collision with root package name */
    public static final iy f38769e = new iy("", (byte) 11, 5);

    /* renamed from: f  reason: collision with root package name */
    public static final iy f38770f = new iy("", (byte) 11, 6);

    /* renamed from: g  reason: collision with root package name */
    public static final iy f38771g = new iy("", (byte) 11, 7);

    /* renamed from: h  reason: collision with root package name */
    public static final iy f38772h = new iy("", (byte) 15, 8);

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
        if (in.class.equals(inVar.getClass())) {
            int compareTo = Boolean.valueOf(m495a()).compareTo(Boolean.valueOf(inVar.m495a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m495a() || (a9 = ir.a(this.f779a, inVar.f779a)) == 0) {
                int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(inVar.b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!b() || (a8 = ir.a(this.f778a, inVar.f778a)) == 0) {
                    int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(inVar.c()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!c() || (a7 = ir.a(this.f781b, inVar.f781b)) == 0) {
                        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(inVar.d()));
                        if (compareTo4 != 0) {
                            return compareTo4;
                        }
                        if (!d() || (a6 = ir.a(this.f782c, inVar.f782c)) == 0) {
                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(inVar.e()));
                            if (compareTo5 != 0) {
                                return compareTo5;
                            }
                            if (!e() || (a5 = ir.a(this.f783d, inVar.f783d)) == 0) {
                                int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(inVar.f()));
                                if (compareTo6 != 0) {
                                    return compareTo6;
                                }
                                if (!f() || (a4 = ir.a(this.f784e, inVar.f784e)) == 0) {
                                    int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(inVar.g()));
                                    if (compareTo7 != 0) {
                                        return compareTo7;
                                    }
                                    if (!g() || (a3 = ir.a(this.f785f, inVar.f785f)) == 0) {
                                        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(inVar.h()));
                                        if (compareTo8 != 0) {
                                            return compareTo8;
                                        }
                                        if (!h() || (a2 = ir.a(this.f780a, inVar.f780a)) == 0) {
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
        return in.class.getName().compareTo(inVar.getClass().getName());
    }

    public in a(String str) {
        this.f781b = str;
        return this;
    }

    public void a() {
        if (this.f781b == null) {
            throw new jc("Required field 'id' was not present! Struct: " + toString());
        } else if (this.f782c == null) {
            throw new jc("Required field 'appId' was not present! Struct: " + toString());
        } else if (this.f783d != null) {
        } else {
            throw new jc("Required field 'topic' was not present! Struct: " + toString());
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
                a();
                return;
            }
            switch (m508a.f807a) {
                case 1:
                    if (b2 == 11) {
                        this.f779a = jbVar.m513a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 2:
                    if (b2 == 12) {
                        hu huVar = new hu();
                        this.f778a = huVar;
                        huVar.a(jbVar);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f781b = jbVar.m513a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f782c = jbVar.m513a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 5:
                    if (b2 == 11) {
                        this.f783d = jbVar.m513a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 6:
                    if (b2 == 11) {
                        this.f784e = jbVar.m513a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f785f = jbVar.m513a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 8:
                    if (b2 == 15) {
                        iz m509a = jbVar.m509a();
                        this.f780a = new ArrayList(m509a.f808a);
                        for (int i2 = 0; i2 < m509a.f808a; i2++) {
                            this.f780a.add(jbVar.m513a());
                        }
                        jbVar.i();
                        continue;
                        jbVar.g();
                    }
                    break;
            }
            je.a(jbVar, b2);
            jbVar.g();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m495a() {
        return this.f779a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m496a(in inVar) {
        if (inVar == null) {
            return false;
        }
        boolean m495a = m495a();
        boolean m495a2 = inVar.m495a();
        if ((m495a || m495a2) && !(m495a && m495a2 && this.f779a.equals(inVar.f779a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = inVar.b();
        if ((b2 || b3) && !(b2 && b3 && this.f778a.m407a(inVar.f778a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = inVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f781b.equals(inVar.f781b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = inVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f782c.equals(inVar.f782c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = inVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f783d.equals(inVar.f783d))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = inVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f784e.equals(inVar.f784e))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = inVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f785f.equals(inVar.f785f))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = inVar.h();
        if (h2 || h3) {
            return h2 && h3 && this.f780a.equals(inVar.f780a);
        }
        return true;
    }

    public in b(String str) {
        this.f782c = str;
        return this;
    }

    @Override // com.xiaomi.push.iq
    public void b(jb jbVar) {
        a();
        jbVar.a(f777a);
        if (this.f779a != null && m495a()) {
            jbVar.a(f38765a);
            jbVar.a(this.f779a);
            jbVar.b();
        }
        if (this.f778a != null && b()) {
            jbVar.a(f38766b);
            this.f778a.b(jbVar);
            jbVar.b();
        }
        if (this.f781b != null) {
            jbVar.a(f38767c);
            jbVar.a(this.f781b);
            jbVar.b();
        }
        if (this.f782c != null) {
            jbVar.a(f38768d);
            jbVar.a(this.f782c);
            jbVar.b();
        }
        if (this.f783d != null) {
            jbVar.a(f38769e);
            jbVar.a(this.f783d);
            jbVar.b();
        }
        if (this.f784e != null && f()) {
            jbVar.a(f38770f);
            jbVar.a(this.f784e);
            jbVar.b();
        }
        if (this.f785f != null && g()) {
            jbVar.a(f38771g);
            jbVar.a(this.f785f);
            jbVar.b();
        }
        if (this.f780a != null && h()) {
            jbVar.a(f38772h);
            jbVar.a(new iz((byte) 11, this.f780a.size()));
            for (String str : this.f780a) {
                jbVar.a(str);
            }
            jbVar.e();
            jbVar.b();
        }
        jbVar.c();
        jbVar.m516a();
    }

    public boolean b() {
        return this.f778a != null;
    }

    public in c(String str) {
        this.f783d = str;
        return this;
    }

    public boolean c() {
        return this.f781b != null;
    }

    public in d(String str) {
        this.f784e = str;
        return this;
    }

    public boolean d() {
        return this.f782c != null;
    }

    public in e(String str) {
        this.f785f = str;
        return this;
    }

    public boolean e() {
        return this.f783d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof in)) {
            return m496a((in) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f784e != null;
    }

    public boolean g() {
        return this.f785f != null;
    }

    public boolean h() {
        return this.f780a != null;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionUnSubscription(");
        boolean z2 = false;
        if (m495a()) {
            sb.append("debug:");
            String str = this.f779a;
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
            hu huVar = this.f778a;
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
        String str2 = this.f781b;
        if (str2 == null) {
            sb.append(StringUtil.NULL_STRING);
        } else {
            sb.append(str2);
        }
        sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        sb.append("appId:");
        String str3 = this.f782c;
        if (str3 == null) {
            sb.append(StringUtil.NULL_STRING);
        } else {
            sb.append(str3);
        }
        sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        sb.append(UrlSchemaHelper.SCHEMA_TYPE_TOPIC);
        String str4 = this.f783d;
        if (str4 == null) {
            sb.append(StringUtil.NULL_STRING);
        } else {
            sb.append(str4);
        }
        if (f()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("packageName:");
            String str5 = this.f784e;
            if (str5 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str5);
            }
        }
        if (g()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("category:");
            String str6 = this.f785f;
            if (str6 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str6);
            }
        }
        if (h()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("aliases:");
            List<String> list = this.f780a;
            if (list == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(list);
            }
        }
        sb.append(SmallTailInfo.EMOTION_SUFFIX);
        return sb.toString();
    }
}
