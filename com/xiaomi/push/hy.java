package com.xiaomi.push;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes10.dex */
public class hy implements is<hy, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public hw f583a;

    /* renamed from: a  reason: collision with other field name */
    public String f584a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f586a;

    /* renamed from: b  reason: collision with other field name */
    public String f587b;

    /* renamed from: c  reason: collision with other field name */
    public String f588c;

    /* renamed from: d  reason: collision with other field name */
    public String f589d;

    /* renamed from: e  reason: collision with other field name */
    public String f590e;

    /* renamed from: f  reason: collision with other field name */
    public String f591f;

    /* renamed from: g  reason: collision with other field name */
    public String f592g;

    /* renamed from: a  reason: collision with other field name */
    public static final ji f581a = new ji("XmPushActionAckNotification");
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
    public BitSet f585a = new BitSet(1);

    /* renamed from: a  reason: collision with other field name */
    public long f582a = 0;

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
            int compareTo = Boolean.valueOf(m611a()).compareTo(Boolean.valueOf(hyVar.m611a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m611a() || (a11 = it.a(this.f584a, hyVar.f584a)) == 0) {
                int compareTo2 = Boolean.valueOf(m613b()).compareTo(Boolean.valueOf(hyVar.m613b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!m613b() || (a10 = it.a(this.f583a, hyVar.f583a)) == 0) {
                    int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(hyVar.c()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!c() || (a9 = it.a(this.f587b, hyVar.f587b)) == 0) {
                        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hyVar.d()));
                        if (compareTo4 != 0) {
                            return compareTo4;
                        }
                        if (!d() || (a8 = it.a(this.f588c, hyVar.f588c)) == 0) {
                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hyVar.e()));
                            if (compareTo5 != 0) {
                                return compareTo5;
                            }
                            if (!e() || (a7 = it.a(this.f589d, hyVar.f589d)) == 0) {
                                int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hyVar.f()));
                                if (compareTo6 != 0) {
                                    return compareTo6;
                                }
                                if (!f() || (a6 = it.a(this.f582a, hyVar.f582a)) == 0) {
                                    int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hyVar.g()));
                                    if (compareTo7 != 0) {
                                        return compareTo7;
                                    }
                                    if (!g() || (a5 = it.a(this.f590e, hyVar.f590e)) == 0) {
                                        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hyVar.h()));
                                        if (compareTo8 != 0) {
                                            return compareTo8;
                                        }
                                        if (!h() || (a4 = it.a(this.f586a, hyVar.f586a)) == 0) {
                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hyVar.i()));
                                            if (compareTo9 != 0) {
                                                return compareTo9;
                                            }
                                            if (!i() || (a3 = it.a(this.f591f, hyVar.f591f)) == 0) {
                                                int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(hyVar.j()));
                                                if (compareTo10 != 0) {
                                                    return compareTo10;
                                                }
                                                if (!j() || (a2 = it.a(this.f592g, hyVar.f592g)) == 0) {
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
        this.f582a = j2;
        a(true);
        return this;
    }

    public hy a(hw hwVar) {
        this.f583a = hwVar;
        return this;
    }

    public hy a(String str) {
        this.f587b = str;
        return this;
    }

    public String a() {
        return this.f587b;
    }

    /* renamed from: a  reason: collision with other method in class */
    public Map<String, String> m609a() {
        return this.f586a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m610a() {
        if (this.f587b != null) {
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
                m610a();
                return;
            }
            switch (mo706a.f809a) {
                case 1:
                    if (b2 == 11) {
                        this.f584a = jdVar.mo711a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 2:
                    if (b2 == 12) {
                        hw hwVar = new hw();
                        this.f583a = hwVar;
                        hwVar.a(jdVar);
                        continue;
                        jdVar.g();
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f587b = jdVar.mo711a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f588c = jdVar.mo711a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 5:
                    if (b2 == 11) {
                        this.f589d = jdVar.mo711a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 7:
                    if (b2 == 10) {
                        this.f582a = jdVar.mo705a();
                        a(true);
                        continue;
                        jdVar.g();
                    }
                    break;
                case 8:
                    if (b2 == 11) {
                        this.f590e = jdVar.mo711a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 9:
                    if (b2 == 13) {
                        jc mo708a = jdVar.mo708a();
                        this.f586a = new HashMap(mo708a.f811a * 2);
                        for (int i2 = 0; i2 < mo708a.f811a; i2++) {
                            this.f586a.put(jdVar.mo711a(), jdVar.mo711a());
                        }
                        jdVar.h();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 10:
                    if (b2 == 11) {
                        this.f591f = jdVar.mo711a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 11:
                    if (b2 == 11) {
                        this.f592g = jdVar.mo711a();
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
        this.f585a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m611a() {
        return this.f584a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m612a(hy hyVar) {
        if (hyVar == null) {
            return false;
        }
        boolean m611a = m611a();
        boolean m611a2 = hyVar.m611a();
        if ((m611a || m611a2) && !(m611a && m611a2 && this.f584a.equals(hyVar.f584a))) {
            return false;
        }
        boolean m613b = m613b();
        boolean m613b2 = hyVar.m613b();
        if ((m613b || m613b2) && !(m613b && m613b2 && this.f583a.m606a(hyVar.f583a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = hyVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f587b.equals(hyVar.f587b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = hyVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f588c.equals(hyVar.f588c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = hyVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f589d.equals(hyVar.f589d))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = hyVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f582a == hyVar.f582a)) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = hyVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f590e.equals(hyVar.f590e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = hyVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f586a.equals(hyVar.f586a))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = hyVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f591f.equals(hyVar.f591f))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = hyVar.j();
        if (j2 || j3) {
            return j2 && j3 && this.f592g.equals(hyVar.f592g);
        }
        return true;
    }

    public hy b(String str) {
        this.f588c = str;
        return this;
    }

    public String b() {
        return this.f589d;
    }

    @Override // com.xiaomi.push.is
    public void b(jd jdVar) {
        m610a();
        jdVar.a(f581a);
        if (this.f584a != null && m611a()) {
            jdVar.a(a);
            jdVar.a(this.f584a);
            jdVar.b();
        }
        if (this.f583a != null && m613b()) {
            jdVar.a(b);
            this.f583a.b(jdVar);
            jdVar.b();
        }
        if (this.f587b != null) {
            jdVar.a(c);
            jdVar.a(this.f587b);
            jdVar.b();
        }
        if (this.f588c != null && d()) {
            jdVar.a(d);
            jdVar.a(this.f588c);
            jdVar.b();
        }
        if (this.f589d != null && e()) {
            jdVar.a(e);
            jdVar.a(this.f589d);
            jdVar.b();
        }
        if (f()) {
            jdVar.a(f);
            jdVar.a(this.f582a);
            jdVar.b();
        }
        if (this.f590e != null && g()) {
            jdVar.a(g);
            jdVar.a(this.f590e);
            jdVar.b();
        }
        if (this.f586a != null && h()) {
            jdVar.a(h);
            jdVar.a(new jc(Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, this.f586a.size()));
            for (Map.Entry<String, String> entry : this.f586a.entrySet()) {
                jdVar.a(entry.getKey());
                jdVar.a(entry.getValue());
            }
            jdVar.d();
            jdVar.b();
        }
        if (this.f591f != null && i()) {
            jdVar.a(i);
            jdVar.a(this.f591f);
            jdVar.b();
        }
        if (this.f592g != null && j()) {
            jdVar.a(j);
            jdVar.a(this.f592g);
            jdVar.b();
        }
        jdVar.c();
        jdVar.mo714a();
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m613b() {
        return this.f583a != null;
    }

    public hy c(String str) {
        this.f589d = str;
        return this;
    }

    public boolean c() {
        return this.f587b != null;
    }

    public hy d(String str) {
        this.f590e = str;
        return this;
    }

    public boolean d() {
        return this.f588c != null;
    }

    public hy e(String str) {
        this.f591f = str;
        return this;
    }

    public boolean e() {
        return this.f589d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hy)) {
            return m612a((hy) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f585a.get(0);
    }

    public boolean g() {
        return this.f590e != null;
    }

    public boolean h() {
        return this.f586a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f591f != null;
    }

    public boolean j() {
        return this.f592g != null;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionAckNotification(");
        boolean z2 = false;
        if (m611a()) {
            sb.append("debug:");
            String str = this.f584a;
            if (str == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (m613b()) {
            if (!z) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            }
            sb.append("target:");
            hw hwVar = this.f583a;
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
        String str2 = this.f587b;
        if (str2 == null) {
            sb.append(StringUtil.NULL_STRING);
        } else {
            sb.append(str2);
        }
        if (d()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("appId:");
            String str3 = this.f588c;
            if (str3 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str3);
            }
        }
        if (e()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("type:");
            String str4 = this.f589d;
            if (str4 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str4);
            }
        }
        if (f()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("errorCode:");
            sb.append(this.f582a);
        }
        if (g()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("reason:");
            String str5 = this.f590e;
            if (str5 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str5);
            }
        }
        if (h()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("extra:");
            Map<String, String> map = this.f586a;
            if (map == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(map);
            }
        }
        if (i()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("packageName:");
            String str6 = this.f591f;
            if (str6 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str6);
            }
        }
        if (j()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("category:");
            String str7 = this.f592g;
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
