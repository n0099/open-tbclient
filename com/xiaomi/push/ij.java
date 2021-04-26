package com.xiaomi.push;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import io.flutter.plugin.common.StandardMessageCodec;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class ij implements iq<ij, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public hu f733a;

    /* renamed from: a  reason: collision with other field name */
    public String f734a;

    /* renamed from: a  reason: collision with other field name */
    public List<String> f735a;

    /* renamed from: b  reason: collision with other field name */
    public String f736b;

    /* renamed from: c  reason: collision with other field name */
    public String f737c;

    /* renamed from: d  reason: collision with other field name */
    public String f738d;

    /* renamed from: e  reason: collision with other field name */
    public String f739e;

    /* renamed from: f  reason: collision with other field name */
    public String f740f;

    /* renamed from: a  reason: collision with other field name */
    public static final jg f732a = new jg("XmPushActionSubscription");

    /* renamed from: a  reason: collision with root package name */
    public static final iy f38730a = new iy("", (byte) 11, 1);

    /* renamed from: b  reason: collision with root package name */
    public static final iy f38731b = new iy("", StandardMessageCodec.LIST, 2);

    /* renamed from: c  reason: collision with root package name */
    public static final iy f38732c = new iy("", (byte) 11, 3);

    /* renamed from: d  reason: collision with root package name */
    public static final iy f38733d = new iy("", (byte) 11, 4);

    /* renamed from: e  reason: collision with root package name */
    public static final iy f38734e = new iy("", (byte) 11, 5);

    /* renamed from: f  reason: collision with root package name */
    public static final iy f38735f = new iy("", (byte) 11, 6);

    /* renamed from: g  reason: collision with root package name */
    public static final iy f38736g = new iy("", (byte) 11, 7);

    /* renamed from: h  reason: collision with root package name */
    public static final iy f38737h = new iy("", (byte) 15, 8);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(ij ijVar) {
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        int a8;
        int a9;
        if (ij.class.equals(ijVar.getClass())) {
            int compareTo = Boolean.valueOf(m483a()).compareTo(Boolean.valueOf(ijVar.m483a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m483a() || (a9 = ir.a(this.f734a, ijVar.f734a)) == 0) {
                int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(ijVar.b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!b() || (a8 = ir.a(this.f733a, ijVar.f733a)) == 0) {
                    int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(ijVar.c()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!c() || (a7 = ir.a(this.f736b, ijVar.f736b)) == 0) {
                        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(ijVar.d()));
                        if (compareTo4 != 0) {
                            return compareTo4;
                        }
                        if (!d() || (a6 = ir.a(this.f737c, ijVar.f737c)) == 0) {
                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(ijVar.e()));
                            if (compareTo5 != 0) {
                                return compareTo5;
                            }
                            if (!e() || (a5 = ir.a(this.f738d, ijVar.f738d)) == 0) {
                                int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(ijVar.f()));
                                if (compareTo6 != 0) {
                                    return compareTo6;
                                }
                                if (!f() || (a4 = ir.a(this.f739e, ijVar.f739e)) == 0) {
                                    int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ijVar.g()));
                                    if (compareTo7 != 0) {
                                        return compareTo7;
                                    }
                                    if (!g() || (a3 = ir.a(this.f740f, ijVar.f740f)) == 0) {
                                        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(ijVar.h()));
                                        if (compareTo8 != 0) {
                                            return compareTo8;
                                        }
                                        if (!h() || (a2 = ir.a(this.f735a, ijVar.f735a)) == 0) {
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
        return ij.class.getName().compareTo(ijVar.getClass().getName());
    }

    public ij a(String str) {
        this.f736b = str;
        return this;
    }

    public void a() {
        if (this.f736b == null) {
            throw new jc("Required field 'id' was not present! Struct: " + toString());
        } else if (this.f737c == null) {
            throw new jc("Required field 'appId' was not present! Struct: " + toString());
        } else if (this.f738d != null) {
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
                        this.f734a = jbVar.m513a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 2:
                    if (b2 == 12) {
                        hu huVar = new hu();
                        this.f733a = huVar;
                        huVar.a(jbVar);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f736b = jbVar.m513a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f737c = jbVar.m513a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 5:
                    if (b2 == 11) {
                        this.f738d = jbVar.m513a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 6:
                    if (b2 == 11) {
                        this.f739e = jbVar.m513a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f740f = jbVar.m513a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 8:
                    if (b2 == 15) {
                        iz m509a = jbVar.m509a();
                        this.f735a = new ArrayList(m509a.f808a);
                        for (int i2 = 0; i2 < m509a.f808a; i2++) {
                            this.f735a.add(jbVar.m513a());
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
    public boolean m483a() {
        return this.f734a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m484a(ij ijVar) {
        if (ijVar == null) {
            return false;
        }
        boolean m483a = m483a();
        boolean m483a2 = ijVar.m483a();
        if ((m483a || m483a2) && !(m483a && m483a2 && this.f734a.equals(ijVar.f734a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = ijVar.b();
        if ((b2 || b3) && !(b2 && b3 && this.f733a.m407a(ijVar.f733a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = ijVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f736b.equals(ijVar.f736b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = ijVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f737c.equals(ijVar.f737c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = ijVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f738d.equals(ijVar.f738d))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = ijVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f739e.equals(ijVar.f739e))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = ijVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f740f.equals(ijVar.f740f))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = ijVar.h();
        if (h2 || h3) {
            return h2 && h3 && this.f735a.equals(ijVar.f735a);
        }
        return true;
    }

    public ij b(String str) {
        this.f737c = str;
        return this;
    }

    @Override // com.xiaomi.push.iq
    public void b(jb jbVar) {
        a();
        jbVar.a(f732a);
        if (this.f734a != null && m483a()) {
            jbVar.a(f38730a);
            jbVar.a(this.f734a);
            jbVar.b();
        }
        if (this.f733a != null && b()) {
            jbVar.a(f38731b);
            this.f733a.b(jbVar);
            jbVar.b();
        }
        if (this.f736b != null) {
            jbVar.a(f38732c);
            jbVar.a(this.f736b);
            jbVar.b();
        }
        if (this.f737c != null) {
            jbVar.a(f38733d);
            jbVar.a(this.f737c);
            jbVar.b();
        }
        if (this.f738d != null) {
            jbVar.a(f38734e);
            jbVar.a(this.f738d);
            jbVar.b();
        }
        if (this.f739e != null && f()) {
            jbVar.a(f38735f);
            jbVar.a(this.f739e);
            jbVar.b();
        }
        if (this.f740f != null && g()) {
            jbVar.a(f38736g);
            jbVar.a(this.f740f);
            jbVar.b();
        }
        if (this.f735a != null && h()) {
            jbVar.a(f38737h);
            jbVar.a(new iz((byte) 11, this.f735a.size()));
            for (String str : this.f735a) {
                jbVar.a(str);
            }
            jbVar.e();
            jbVar.b();
        }
        jbVar.c();
        jbVar.m516a();
    }

    public boolean b() {
        return this.f733a != null;
    }

    public ij c(String str) {
        this.f738d = str;
        return this;
    }

    public boolean c() {
        return this.f736b != null;
    }

    public ij d(String str) {
        this.f739e = str;
        return this;
    }

    public boolean d() {
        return this.f737c != null;
    }

    public ij e(String str) {
        this.f740f = str;
        return this;
    }

    public boolean e() {
        return this.f738d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ij)) {
            return m484a((ij) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f739e != null;
    }

    public boolean g() {
        return this.f740f != null;
    }

    public boolean h() {
        return this.f735a != null;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionSubscription(");
        boolean z2 = false;
        if (m483a()) {
            sb.append("debug:");
            String str = this.f734a;
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
            hu huVar = this.f733a;
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
        String str2 = this.f736b;
        if (str2 == null) {
            sb.append(StringUtil.NULL_STRING);
        } else {
            sb.append(str2);
        }
        sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        sb.append("appId:");
        String str3 = this.f737c;
        if (str3 == null) {
            sb.append(StringUtil.NULL_STRING);
        } else {
            sb.append(str3);
        }
        sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        sb.append(UrlSchemaHelper.SCHEMA_TYPE_TOPIC);
        String str4 = this.f738d;
        if (str4 == null) {
            sb.append(StringUtil.NULL_STRING);
        } else {
            sb.append(str4);
        }
        if (f()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("packageName:");
            String str5 = this.f739e;
            if (str5 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str5);
            }
        }
        if (g()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("category:");
            String str6 = this.f740f;
            if (str6 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str6);
            }
        }
        if (h()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("aliases:");
            List<String> list = this.f735a;
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
