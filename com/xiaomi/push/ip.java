package com.xiaomi.push;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class ip implements is<ip, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public hw f779a;

    /* renamed from: a  reason: collision with other field name */
    public String f780a;

    /* renamed from: a  reason: collision with other field name */
    public List<String> f781a;

    /* renamed from: b  reason: collision with other field name */
    public String f782b;

    /* renamed from: c  reason: collision with other field name */
    public String f783c;

    /* renamed from: d  reason: collision with other field name */
    public String f784d;

    /* renamed from: e  reason: collision with other field name */
    public String f785e;

    /* renamed from: f  reason: collision with other field name */
    public String f786f;

    /* renamed from: a  reason: collision with other field name */
    public static final ji f778a = new ji("XmPushActionUnSubscription");
    public static final ja a = new ja("", Constants.GZIP_CAST_TYPE, 1);
    public static final ja b = new ja("", (byte) 12, 2);
    public static final ja c = new ja("", Constants.GZIP_CAST_TYPE, 3);
    public static final ja d = new ja("", Constants.GZIP_CAST_TYPE, 4);
    public static final ja e = new ja("", Constants.GZIP_CAST_TYPE, 5);
    public static final ja f = new ja("", Constants.GZIP_CAST_TYPE, 6);
    public static final ja g = new ja("", Constants.GZIP_CAST_TYPE, 7);
    public static final ja h = new ja("", (byte) 15, 8);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(ip ipVar) {
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        int a8;
        int a9;
        if (ip.class.equals(ipVar.getClass())) {
            int compareTo = Boolean.valueOf(m693a()).compareTo(Boolean.valueOf(ipVar.m693a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m693a() || (a9 = it.a(this.f780a, ipVar.f780a)) == 0) {
                int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(ipVar.b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!b() || (a8 = it.a(this.f779a, ipVar.f779a)) == 0) {
                    int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(ipVar.c()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!c() || (a7 = it.a(this.f782b, ipVar.f782b)) == 0) {
                        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(ipVar.d()));
                        if (compareTo4 != 0) {
                            return compareTo4;
                        }
                        if (!d() || (a6 = it.a(this.f783c, ipVar.f783c)) == 0) {
                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(ipVar.e()));
                            if (compareTo5 != 0) {
                                return compareTo5;
                            }
                            if (!e() || (a5 = it.a(this.f784d, ipVar.f784d)) == 0) {
                                int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(ipVar.f()));
                                if (compareTo6 != 0) {
                                    return compareTo6;
                                }
                                if (!f() || (a4 = it.a(this.f785e, ipVar.f785e)) == 0) {
                                    int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ipVar.g()));
                                    if (compareTo7 != 0) {
                                        return compareTo7;
                                    }
                                    if (!g() || (a3 = it.a(this.f786f, ipVar.f786f)) == 0) {
                                        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(ipVar.h()));
                                        if (compareTo8 != 0) {
                                            return compareTo8;
                                        }
                                        if (!h() || (a2 = it.a(this.f781a, ipVar.f781a)) == 0) {
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
        return ip.class.getName().compareTo(ipVar.getClass().getName());
    }

    public ip a(String str) {
        this.f782b = str;
        return this;
    }

    public void a() {
        if (this.f782b == null) {
            throw new je("Required field 'id' was not present! Struct: " + toString());
        } else if (this.f783c == null) {
            throw new je("Required field 'appId' was not present! Struct: " + toString());
        } else if (this.f784d != null) {
        } else {
            throw new je("Required field 'topic' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.is
    public void a(jd jdVar) {
        jdVar.mo710a();
        while (true) {
            ja mo706a = jdVar.mo706a();
            byte b2 = mo706a.a;
            if (b2 == 0) {
                jdVar.f();
                a();
                return;
            }
            switch (mo706a.f809a) {
                case 1:
                    if (b2 == 11) {
                        this.f780a = jdVar.mo711a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 2:
                    if (b2 == 12) {
                        hw hwVar = new hw();
                        this.f779a = hwVar;
                        hwVar.a(jdVar);
                        continue;
                        jdVar.g();
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f782b = jdVar.mo711a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f783c = jdVar.mo711a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 5:
                    if (b2 == 11) {
                        this.f784d = jdVar.mo711a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 6:
                    if (b2 == 11) {
                        this.f785e = jdVar.mo711a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f786f = jdVar.mo711a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 8:
                    if (b2 == 15) {
                        jb mo707a = jdVar.mo707a();
                        this.f781a = new ArrayList(mo707a.f810a);
                        for (int i = 0; i < mo707a.f810a; i++) {
                            this.f781a.add(jdVar.mo711a());
                        }
                        jdVar.i();
                        continue;
                        jdVar.g();
                    }
                    break;
            }
            jg.a(jdVar, b2);
            jdVar.g();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m693a() {
        return this.f780a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m694a(ip ipVar) {
        if (ipVar == null) {
            return false;
        }
        boolean m693a = m693a();
        boolean m693a2 = ipVar.m693a();
        if ((m693a || m693a2) && !(m693a && m693a2 && this.f780a.equals(ipVar.f780a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = ipVar.b();
        if ((b2 || b3) && !(b2 && b3 && this.f779a.m606a(ipVar.f779a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = ipVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f782b.equals(ipVar.f782b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = ipVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f783c.equals(ipVar.f783c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = ipVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f784d.equals(ipVar.f784d))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = ipVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f785e.equals(ipVar.f785e))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = ipVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f786f.equals(ipVar.f786f))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = ipVar.h();
        if (h2 || h3) {
            return h2 && h3 && this.f781a.equals(ipVar.f781a);
        }
        return true;
    }

    public ip b(String str) {
        this.f783c = str;
        return this;
    }

    @Override // com.xiaomi.push.is
    public void b(jd jdVar) {
        a();
        jdVar.a(f778a);
        if (this.f780a != null && m693a()) {
            jdVar.a(a);
            jdVar.a(this.f780a);
            jdVar.b();
        }
        if (this.f779a != null && b()) {
            jdVar.a(b);
            this.f779a.b(jdVar);
            jdVar.b();
        }
        if (this.f782b != null) {
            jdVar.a(c);
            jdVar.a(this.f782b);
            jdVar.b();
        }
        if (this.f783c != null) {
            jdVar.a(d);
            jdVar.a(this.f783c);
            jdVar.b();
        }
        if (this.f784d != null) {
            jdVar.a(e);
            jdVar.a(this.f784d);
            jdVar.b();
        }
        if (this.f785e != null && f()) {
            jdVar.a(f);
            jdVar.a(this.f785e);
            jdVar.b();
        }
        if (this.f786f != null && g()) {
            jdVar.a(g);
            jdVar.a(this.f786f);
            jdVar.b();
        }
        if (this.f781a != null && h()) {
            jdVar.a(h);
            jdVar.a(new jb(Constants.GZIP_CAST_TYPE, this.f781a.size()));
            for (String str : this.f781a) {
                jdVar.a(str);
            }
            jdVar.e();
            jdVar.b();
        }
        jdVar.c();
        jdVar.mo714a();
    }

    public boolean b() {
        return this.f779a != null;
    }

    public ip c(String str) {
        this.f784d = str;
        return this;
    }

    public boolean c() {
        return this.f782b != null;
    }

    public ip d(String str) {
        this.f785e = str;
        return this;
    }

    public boolean d() {
        return this.f783c != null;
    }

    public ip e(String str) {
        this.f786f = str;
        return this;
    }

    public boolean e() {
        return this.f784d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ip)) {
            return m694a((ip) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f785e != null;
    }

    public boolean g() {
        return this.f786f != null;
    }

    public boolean h() {
        return this.f781a != null;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionUnSubscription(");
        boolean z2 = false;
        if (m693a()) {
            sb.append("debug:");
            String str = this.f780a;
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
            hw hwVar = this.f779a;
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
        String str2 = this.f782b;
        if (str2 == null) {
            sb.append(StringUtil.NULL_STRING);
        } else {
            sb.append(str2);
        }
        sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        sb.append("appId:");
        String str3 = this.f783c;
        if (str3 == null) {
            sb.append(StringUtil.NULL_STRING);
        } else {
            sb.append(str3);
        }
        sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        sb.append(UrlSchemaHelper.SCHEMA_TYPE_TOPIC);
        String str4 = this.f784d;
        if (str4 == null) {
            sb.append(StringUtil.NULL_STRING);
        } else {
            sb.append(str4);
        }
        if (f()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("packageName:");
            String str5 = this.f785e;
            if (str5 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str5);
            }
        }
        if (g()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("category:");
            String str6 = this.f786f;
            if (str6 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str6);
            }
        }
        if (h()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("aliases:");
            List<String> list = this.f781a;
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
