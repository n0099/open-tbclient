package com.xiaomi.push;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes8.dex */
public class hy implements is<hy, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public hw f587a;

    /* renamed from: a  reason: collision with other field name */
    public String f588a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f590a;

    /* renamed from: b  reason: collision with other field name */
    public String f591b;

    /* renamed from: c  reason: collision with other field name */
    public String f592c;

    /* renamed from: d  reason: collision with other field name */
    public String f593d;

    /* renamed from: e  reason: collision with other field name */
    public String f594e;

    /* renamed from: f  reason: collision with other field name */
    public String f595f;

    /* renamed from: g  reason: collision with other field name */
    public String f596g;

    /* renamed from: a  reason: collision with other field name */
    public static final ji f585a = new ji("XmPushActionAckNotification");
    public static final ja a = new ja("", Constants.GZIP_CAST_TYPE, 1);
    public static final ja b = new ja("", (byte) 12, 2);
    public static final ja c = new ja("", Constants.GZIP_CAST_TYPE, 3);
    public static final ja d = new ja("", Constants.GZIP_CAST_TYPE, 4);
    public static final ja e = new ja("", Constants.GZIP_CAST_TYPE, 5);
    public static final ja f = new ja("", (byte) 10, 7);
    public static final ja g = new ja("", Constants.GZIP_CAST_TYPE, 8);
    public static final ja h = new ja("", (byte) 13, 9);
    public static final ja i = new ja("", Constants.GZIP_CAST_TYPE, 10);
    public static final ja j = new ja("", Constants.GZIP_CAST_TYPE, 11);

    /* renamed from: a  reason: collision with other field name */
    public BitSet f589a = new BitSet(1);

    /* renamed from: a  reason: collision with other field name */
    public long f586a = 0;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(hy hyVar) {
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        int a8;
        int a9;
        int a10;
        int a11;
        if (hy.class.equals(hyVar.getClass())) {
            int compareTo = Boolean.valueOf(m522a()).compareTo(Boolean.valueOf(hyVar.m522a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m522a() || (a11 = it.a(this.f588a, hyVar.f588a)) == 0) {
                int compareTo2 = Boolean.valueOf(m524b()).compareTo(Boolean.valueOf(hyVar.m524b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!m524b() || (a10 = it.a(this.f587a, hyVar.f587a)) == 0) {
                    int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(hyVar.c()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!c() || (a9 = it.a(this.f591b, hyVar.f591b)) == 0) {
                        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hyVar.d()));
                        if (compareTo4 != 0) {
                            return compareTo4;
                        }
                        if (!d() || (a8 = it.a(this.f592c, hyVar.f592c)) == 0) {
                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hyVar.e()));
                            if (compareTo5 != 0) {
                                return compareTo5;
                            }
                            if (!e() || (a7 = it.a(this.f593d, hyVar.f593d)) == 0) {
                                int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hyVar.f()));
                                if (compareTo6 != 0) {
                                    return compareTo6;
                                }
                                if (!f() || (a6 = it.a(this.f586a, hyVar.f586a)) == 0) {
                                    int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hyVar.g()));
                                    if (compareTo7 != 0) {
                                        return compareTo7;
                                    }
                                    if (!g() || (a5 = it.a(this.f594e, hyVar.f594e)) == 0) {
                                        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hyVar.h()));
                                        if (compareTo8 != 0) {
                                            return compareTo8;
                                        }
                                        if (!h() || (a4 = it.a(this.f590a, hyVar.f590a)) == 0) {
                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hyVar.i()));
                                            if (compareTo9 != 0) {
                                                return compareTo9;
                                            }
                                            if (!i() || (a3 = it.a(this.f595f, hyVar.f595f)) == 0) {
                                                int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(hyVar.j()));
                                                if (compareTo10 != 0) {
                                                    return compareTo10;
                                                }
                                                if (!j() || (a2 = it.a(this.f596g, hyVar.f596g)) == 0) {
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
            return a11;
        }
        return hy.class.getName().compareTo(hyVar.getClass().getName());
    }

    public hy a(long j2) {
        this.f586a = j2;
        a(true);
        return this;
    }

    public hy a(hw hwVar) {
        this.f587a = hwVar;
        return this;
    }

    public hy a(String str) {
        this.f591b = str;
        return this;
    }

    public String a() {
        return this.f591b;
    }

    /* renamed from: a  reason: collision with other method in class */
    public Map<String, String> m520a() {
        return this.f590a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m521a() {
        if (this.f591b != null) {
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
                m521a();
                return;
            }
            switch (mo617a.f813a) {
                case 1:
                    if (b2 == 11) {
                        this.f588a = jdVar.mo622a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 2:
                    if (b2 == 12) {
                        hw hwVar = new hw();
                        this.f587a = hwVar;
                        hwVar.a(jdVar);
                        continue;
                        jdVar.g();
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f591b = jdVar.mo622a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f592c = jdVar.mo622a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 5:
                    if (b2 == 11) {
                        this.f593d = jdVar.mo622a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 7:
                    if (b2 == 10) {
                        this.f586a = jdVar.mo616a();
                        a(true);
                        continue;
                        jdVar.g();
                    }
                    break;
                case 8:
                    if (b2 == 11) {
                        this.f594e = jdVar.mo622a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 9:
                    if (b2 == 13) {
                        jc mo619a = jdVar.mo619a();
                        this.f590a = new HashMap(mo619a.f815a * 2);
                        for (int i2 = 0; i2 < mo619a.f815a; i2++) {
                            this.f590a.put(jdVar.mo622a(), jdVar.mo622a());
                        }
                        jdVar.h();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 10:
                    if (b2 == 11) {
                        this.f595f = jdVar.mo622a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 11:
                    if (b2 == 11) {
                        this.f596g = jdVar.mo622a();
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
        this.f589a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m522a() {
        return this.f588a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m523a(hy hyVar) {
        if (hyVar == null) {
            return false;
        }
        boolean m522a = m522a();
        boolean m522a2 = hyVar.m522a();
        if ((m522a || m522a2) && !(m522a && m522a2 && this.f588a.equals(hyVar.f588a))) {
            return false;
        }
        boolean m524b = m524b();
        boolean m524b2 = hyVar.m524b();
        if ((m524b || m524b2) && !(m524b && m524b2 && this.f587a.m517a(hyVar.f587a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = hyVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f591b.equals(hyVar.f591b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = hyVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f592c.equals(hyVar.f592c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = hyVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f593d.equals(hyVar.f593d))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = hyVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f586a == hyVar.f586a)) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = hyVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f594e.equals(hyVar.f594e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = hyVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f590a.equals(hyVar.f590a))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = hyVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f595f.equals(hyVar.f595f))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = hyVar.j();
        if (j2 || j3) {
            return j2 && j3 && this.f596g.equals(hyVar.f596g);
        }
        return true;
    }

    public hy b(String str) {
        this.f592c = str;
        return this;
    }

    public String b() {
        return this.f593d;
    }

    @Override // com.xiaomi.push.is
    public void b(jd jdVar) {
        m521a();
        jdVar.a(f585a);
        if (this.f588a != null && m522a()) {
            jdVar.a(a);
            jdVar.a(this.f588a);
            jdVar.b();
        }
        if (this.f587a != null && m524b()) {
            jdVar.a(b);
            this.f587a.b(jdVar);
            jdVar.b();
        }
        if (this.f591b != null) {
            jdVar.a(c);
            jdVar.a(this.f591b);
            jdVar.b();
        }
        if (this.f592c != null && d()) {
            jdVar.a(d);
            jdVar.a(this.f592c);
            jdVar.b();
        }
        if (this.f593d != null && e()) {
            jdVar.a(e);
            jdVar.a(this.f593d);
            jdVar.b();
        }
        if (f()) {
            jdVar.a(f);
            jdVar.a(this.f586a);
            jdVar.b();
        }
        if (this.f594e != null && g()) {
            jdVar.a(g);
            jdVar.a(this.f594e);
            jdVar.b();
        }
        if (this.f590a != null && h()) {
            jdVar.a(h);
            jdVar.a(new jc(Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, this.f590a.size()));
            for (Map.Entry<String, String> entry : this.f590a.entrySet()) {
                jdVar.a(entry.getKey());
                jdVar.a(entry.getValue());
            }
            jdVar.d();
            jdVar.b();
        }
        if (this.f595f != null && i()) {
            jdVar.a(i);
            jdVar.a(this.f595f);
            jdVar.b();
        }
        if (this.f596g != null && j()) {
            jdVar.a(j);
            jdVar.a(this.f596g);
            jdVar.b();
        }
        jdVar.c();
        jdVar.mo625a();
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m524b() {
        return this.f587a != null;
    }

    public hy c(String str) {
        this.f593d = str;
        return this;
    }

    public boolean c() {
        return this.f591b != null;
    }

    public hy d(String str) {
        this.f594e = str;
        return this;
    }

    public boolean d() {
        return this.f592c != null;
    }

    public hy e(String str) {
        this.f595f = str;
        return this;
    }

    public boolean e() {
        return this.f593d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hy)) {
            return m523a((hy) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f589a.get(0);
    }

    public boolean g() {
        return this.f594e != null;
    }

    public boolean h() {
        return this.f590a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f595f != null;
    }

    public boolean j() {
        return this.f596g != null;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionAckNotification(");
        boolean z2 = false;
        if (m522a()) {
            sb.append("debug:");
            String str = this.f588a;
            if (str == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (m524b()) {
            if (!z) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            }
            sb.append("target:");
            hw hwVar = this.f587a;
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
        String str2 = this.f591b;
        if (str2 == null) {
            sb.append(StringUtil.NULL_STRING);
        } else {
            sb.append(str2);
        }
        if (d()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("appId:");
            String str3 = this.f592c;
            if (str3 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str3);
            }
        }
        if (e()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("type:");
            String str4 = this.f593d;
            if (str4 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str4);
            }
        }
        if (f()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("errorCode:");
            sb.append(this.f586a);
        }
        if (g()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("reason:");
            String str5 = this.f594e;
            if (str5 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str5);
            }
        }
        if (h()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("extra:");
            Map<String, String> map = this.f590a;
            if (map == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(map);
            }
        }
        if (i()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("packageName:");
            String str6 = this.f595f;
            if (str6 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str6);
            }
        }
        if (j()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("category:");
            String str7 = this.f596g;
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
