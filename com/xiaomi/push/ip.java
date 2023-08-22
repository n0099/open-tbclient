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
    public hw f784a;

    /* renamed from: a  reason: collision with other field name */
    public String f785a;

    /* renamed from: a  reason: collision with other field name */
    public List<String> f786a;

    /* renamed from: b  reason: collision with other field name */
    public String f787b;

    /* renamed from: c  reason: collision with other field name */
    public String f788c;

    /* renamed from: d  reason: collision with other field name */
    public String f789d;

    /* renamed from: e  reason: collision with other field name */
    public String f790e;

    /* renamed from: f  reason: collision with other field name */
    public String f791f;

    /* renamed from: a  reason: collision with other field name */
    public static final ji f783a = new ji("XmPushActionUnSubscription");
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
            int compareTo = Boolean.valueOf(m683a()).compareTo(Boolean.valueOf(ipVar.m683a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m683a() || (a9 = it.a(this.f785a, ipVar.f785a)) == 0) {
                int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(ipVar.b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!b() || (a8 = it.a(this.f784a, ipVar.f784a)) == 0) {
                    int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(ipVar.c()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!c() || (a7 = it.a(this.f787b, ipVar.f787b)) == 0) {
                        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(ipVar.d()));
                        if (compareTo4 != 0) {
                            return compareTo4;
                        }
                        if (!d() || (a6 = it.a(this.f788c, ipVar.f788c)) == 0) {
                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(ipVar.e()));
                            if (compareTo5 != 0) {
                                return compareTo5;
                            }
                            if (!e() || (a5 = it.a(this.f789d, ipVar.f789d)) == 0) {
                                int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(ipVar.f()));
                                if (compareTo6 != 0) {
                                    return compareTo6;
                                }
                                if (!f() || (a4 = it.a(this.f790e, ipVar.f790e)) == 0) {
                                    int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ipVar.g()));
                                    if (compareTo7 != 0) {
                                        return compareTo7;
                                    }
                                    if (!g() || (a3 = it.a(this.f791f, ipVar.f791f)) == 0) {
                                        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(ipVar.h()));
                                        if (compareTo8 != 0) {
                                            return compareTo8;
                                        }
                                        if (!h() || (a2 = it.a(this.f786a, ipVar.f786a)) == 0) {
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
        this.f787b = str;
        return this;
    }

    public void a() {
        if (this.f787b == null) {
            throw new je("Required field 'id' was not present! Struct: " + toString());
        } else if (this.f788c == null) {
            throw new je("Required field 'appId' was not present! Struct: " + toString());
        } else if (this.f789d != null) {
        } else {
            throw new je("Required field 'topic' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.is
    public void a(jd jdVar) {
        jdVar.mo700a();
        while (true) {
            ja mo696a = jdVar.mo696a();
            byte b2 = mo696a.a;
            if (b2 == 0) {
                jdVar.f();
                a();
                return;
            }
            switch (mo696a.f814a) {
                case 1:
                    if (b2 == 11) {
                        this.f785a = jdVar.mo701a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 2:
                    if (b2 == 12) {
                        hw hwVar = new hw();
                        this.f784a = hwVar;
                        hwVar.a(jdVar);
                        continue;
                        jdVar.g();
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f787b = jdVar.mo701a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f788c = jdVar.mo701a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 5:
                    if (b2 == 11) {
                        this.f789d = jdVar.mo701a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 6:
                    if (b2 == 11) {
                        this.f790e = jdVar.mo701a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f791f = jdVar.mo701a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 8:
                    if (b2 == 15) {
                        jb mo697a = jdVar.mo697a();
                        this.f786a = new ArrayList(mo697a.f815a);
                        for (int i = 0; i < mo697a.f815a; i++) {
                            this.f786a.add(jdVar.mo701a());
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
    public boolean m683a() {
        return this.f785a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m684a(ip ipVar) {
        if (ipVar == null) {
            return false;
        }
        boolean m683a = m683a();
        boolean m683a2 = ipVar.m683a();
        if ((m683a || m683a2) && !(m683a && m683a2 && this.f785a.equals(ipVar.f785a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = ipVar.b();
        if ((b2 || b3) && !(b2 && b3 && this.f784a.m596a(ipVar.f784a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = ipVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f787b.equals(ipVar.f787b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = ipVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f788c.equals(ipVar.f788c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = ipVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f789d.equals(ipVar.f789d))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = ipVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f790e.equals(ipVar.f790e))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = ipVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f791f.equals(ipVar.f791f))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = ipVar.h();
        if (h2 || h3) {
            return h2 && h3 && this.f786a.equals(ipVar.f786a);
        }
        return true;
    }

    public ip b(String str) {
        this.f788c = str;
        return this;
    }

    @Override // com.xiaomi.push.is
    public void b(jd jdVar) {
        a();
        jdVar.a(f783a);
        if (this.f785a != null && m683a()) {
            jdVar.a(a);
            jdVar.a(this.f785a);
            jdVar.b();
        }
        if (this.f784a != null && b()) {
            jdVar.a(b);
            this.f784a.b(jdVar);
            jdVar.b();
        }
        if (this.f787b != null) {
            jdVar.a(c);
            jdVar.a(this.f787b);
            jdVar.b();
        }
        if (this.f788c != null) {
            jdVar.a(d);
            jdVar.a(this.f788c);
            jdVar.b();
        }
        if (this.f789d != null) {
            jdVar.a(e);
            jdVar.a(this.f789d);
            jdVar.b();
        }
        if (this.f790e != null && f()) {
            jdVar.a(f);
            jdVar.a(this.f790e);
            jdVar.b();
        }
        if (this.f791f != null && g()) {
            jdVar.a(g);
            jdVar.a(this.f791f);
            jdVar.b();
        }
        if (this.f786a != null && h()) {
            jdVar.a(h);
            jdVar.a(new jb(Constants.GZIP_CAST_TYPE, this.f786a.size()));
            for (String str : this.f786a) {
                jdVar.a(str);
            }
            jdVar.e();
            jdVar.b();
        }
        jdVar.c();
        jdVar.mo704a();
    }

    public boolean b() {
        return this.f784a != null;
    }

    public ip c(String str) {
        this.f789d = str;
        return this;
    }

    public boolean c() {
        return this.f787b != null;
    }

    public ip d(String str) {
        this.f790e = str;
        return this;
    }

    public boolean d() {
        return this.f788c != null;
    }

    public ip e(String str) {
        this.f791f = str;
        return this;
    }

    public boolean e() {
        return this.f789d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ip)) {
            return m684a((ip) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f790e != null;
    }

    public boolean g() {
        return this.f791f != null;
    }

    public boolean h() {
        return this.f786a != null;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionUnSubscription(");
        boolean z2 = false;
        if (m683a()) {
            sb.append("debug:");
            String str = this.f785a;
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
            hw hwVar = this.f784a;
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
        String str2 = this.f787b;
        if (str2 == null) {
            sb.append(StringUtil.NULL_STRING);
        } else {
            sb.append(str2);
        }
        sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        sb.append("appId:");
        String str3 = this.f788c;
        if (str3 == null) {
            sb.append(StringUtil.NULL_STRING);
        } else {
            sb.append(str3);
        }
        sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        sb.append(UrlSchemaHelper.SCHEMA_TYPE_TOPIC);
        String str4 = this.f789d;
        if (str4 == null) {
            sb.append(StringUtil.NULL_STRING);
        } else {
            sb.append(str4);
        }
        if (f()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("packageName:");
            String str5 = this.f790e;
            if (str5 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str5);
            }
        }
        if (g()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("category:");
            String str6 = this.f791f;
            if (str6 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str6);
            }
        }
        if (h()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("aliases:");
            List<String> list = this.f786a;
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
