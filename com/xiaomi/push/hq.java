package com.xiaomi.push;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.tbadk.core.data.SmallTailInfo;
import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes7.dex */
public class hq implements iq<hq, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public int f508a;

    /* renamed from: a  reason: collision with other field name */
    public long f509a;

    /* renamed from: a  reason: collision with other field name */
    public String f510a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f511a = new BitSet(6);

    /* renamed from: a  reason: collision with other field name */
    public boolean f512a;

    /* renamed from: b  reason: collision with other field name */
    public int f513b;

    /* renamed from: b  reason: collision with other field name */
    public boolean f514b;

    /* renamed from: c  reason: collision with other field name */
    public int f515c;

    /* renamed from: a  reason: collision with other field name */
    public static final jg f507a = new jg("OnlineConfigItem");

    /* renamed from: a  reason: collision with root package name */
    public static final iy f37842a = new iy("", (byte) 8, 1);

    /* renamed from: b  reason: collision with root package name */
    public static final iy f37843b = new iy("", (byte) 8, 2);

    /* renamed from: c  reason: collision with root package name */
    public static final iy f37844c = new iy("", (byte) 2, 3);

    /* renamed from: d  reason: collision with root package name */
    public static final iy f37845d = new iy("", (byte) 8, 4);

    /* renamed from: e  reason: collision with root package name */
    public static final iy f37846e = new iy("", (byte) 10, 5);

    /* renamed from: f  reason: collision with root package name */
    public static final iy f37847f = new iy("", (byte) 11, 6);

    /* renamed from: g  reason: collision with root package name */
    public static final iy f37848g = new iy("", (byte) 2, 7);

    public int a() {
        return this.f508a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(hq hqVar) {
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        int a8;
        if (hq.class.equals(hqVar.getClass())) {
            int compareTo = Boolean.valueOf(m382a()).compareTo(Boolean.valueOf(hqVar.m382a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m382a() || (a8 = ir.a(this.f508a, hqVar.f508a)) == 0) {
                int compareTo2 = Boolean.valueOf(m384b()).compareTo(Boolean.valueOf(hqVar.m384b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!m384b() || (a7 = ir.a(this.f513b, hqVar.f513b)) == 0) {
                    int compareTo3 = Boolean.valueOf(m385c()).compareTo(Boolean.valueOf(hqVar.m385c()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!m385c() || (a6 = ir.a(this.f512a, hqVar.f512a)) == 0) {
                        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hqVar.d()));
                        if (compareTo4 != 0) {
                            return compareTo4;
                        }
                        if (!d() || (a5 = ir.a(this.f515c, hqVar.f515c)) == 0) {
                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hqVar.e()));
                            if (compareTo5 != 0) {
                                return compareTo5;
                            }
                            if (!e() || (a4 = ir.a(this.f509a, hqVar.f509a)) == 0) {
                                int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hqVar.f()));
                                if (compareTo6 != 0) {
                                    return compareTo6;
                                }
                                if (!f() || (a3 = ir.a(this.f510a, hqVar.f510a)) == 0) {
                                    int compareTo7 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hqVar.h()));
                                    if (compareTo7 != 0) {
                                        return compareTo7;
                                    }
                                    if (!h() || (a2 = ir.a(this.f514b, hqVar.f514b)) == 0) {
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
        return hq.class.getName().compareTo(hqVar.getClass().getName());
    }

    /* renamed from: a  reason: collision with other method in class */
    public long m379a() {
        return this.f509a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m380a() {
        return this.f510a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m381a() {
    }

    @Override // com.xiaomi.push.iq
    public void a(jb jbVar) {
        jbVar.m511a();
        while (true) {
            iy m507a = jbVar.m507a();
            byte b2 = m507a.f38040a;
            if (b2 == 0) {
                jbVar.f();
                m381a();
                return;
            }
            switch (m507a.f807a) {
                case 1:
                    if (b2 == 8) {
                        this.f508a = jbVar.m505a();
                        a(true);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 2:
                    if (b2 == 8) {
                        this.f513b = jbVar.m505a();
                        b(true);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 3:
                    if (b2 == 2) {
                        this.f512a = jbVar.m516a();
                        c(true);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 4:
                    if (b2 == 8) {
                        this.f515c = jbVar.m505a();
                        d(true);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 5:
                    if (b2 == 10) {
                        this.f509a = jbVar.m506a();
                        e(true);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 6:
                    if (b2 == 11) {
                        this.f510a = jbVar.m512a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 7:
                    if (b2 == 2) {
                        this.f514b = jbVar.m516a();
                        f(true);
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
        this.f511a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m382a() {
        return this.f511a.get(0);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m383a(hq hqVar) {
        if (hqVar == null) {
            return false;
        }
        boolean m382a = m382a();
        boolean m382a2 = hqVar.m382a();
        if ((m382a || m382a2) && !(m382a && m382a2 && this.f508a == hqVar.f508a)) {
            return false;
        }
        boolean m384b = m384b();
        boolean m384b2 = hqVar.m384b();
        if ((m384b || m384b2) && !(m384b && m384b2 && this.f513b == hqVar.f513b)) {
            return false;
        }
        boolean m385c = m385c();
        boolean m385c2 = hqVar.m385c();
        if ((m385c || m385c2) && !(m385c && m385c2 && this.f512a == hqVar.f512a)) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = hqVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f515c == hqVar.f515c)) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = hqVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f509a == hqVar.f509a)) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = hqVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f510a.equals(hqVar.f510a))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = hqVar.h();
        if (h2 || h3) {
            return h2 && h3 && this.f514b == hqVar.f514b;
        }
        return true;
    }

    public int b() {
        return this.f513b;
    }

    @Override // com.xiaomi.push.iq
    public void b(jb jbVar) {
        m381a();
        jbVar.a(f507a);
        if (m382a()) {
            jbVar.a(f37842a);
            jbVar.a(this.f508a);
            jbVar.b();
        }
        if (m384b()) {
            jbVar.a(f37843b);
            jbVar.a(this.f513b);
            jbVar.b();
        }
        if (m385c()) {
            jbVar.a(f37844c);
            jbVar.a(this.f512a);
            jbVar.b();
        }
        if (d()) {
            jbVar.a(f37845d);
            jbVar.a(this.f515c);
            jbVar.b();
        }
        if (e()) {
            jbVar.a(f37846e);
            jbVar.a(this.f509a);
            jbVar.b();
        }
        if (this.f510a != null && f()) {
            jbVar.a(f37847f);
            jbVar.a(this.f510a);
            jbVar.b();
        }
        if (h()) {
            jbVar.a(f37848g);
            jbVar.a(this.f514b);
            jbVar.b();
        }
        jbVar.c();
        jbVar.m515a();
    }

    public void b(boolean z) {
        this.f511a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m384b() {
        return this.f511a.get(1);
    }

    public int c() {
        return this.f515c;
    }

    public void c(boolean z) {
        this.f511a.set(2, z);
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m385c() {
        return this.f511a.get(2);
    }

    public void d(boolean z) {
        this.f511a.set(3, z);
    }

    public boolean d() {
        return this.f511a.get(3);
    }

    public void e(boolean z) {
        this.f511a.set(4, z);
    }

    public boolean e() {
        return this.f511a.get(4);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hq)) {
            return m383a((hq) obj);
        }
        return false;
    }

    public void f(boolean z) {
        this.f511a.set(5, z);
    }

    public boolean f() {
        return this.f510a != null;
    }

    public boolean g() {
        return this.f514b;
    }

    public boolean h() {
        return this.f511a.get(5);
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("OnlineConfigItem(");
        boolean z2 = false;
        if (m382a()) {
            sb.append("key:");
            sb.append(this.f508a);
            z = false;
        } else {
            z = true;
        }
        if (m384b()) {
            if (!z) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            }
            sb.append("type:");
            sb.append(this.f513b);
            z = false;
        }
        if (m385c()) {
            if (!z) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            }
            sb.append("clear:");
            sb.append(this.f512a);
            z = false;
        }
        if (d()) {
            if (!z) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            }
            sb.append("intValue:");
            sb.append(this.f515c);
            z = false;
        }
        if (e()) {
            if (!z) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            }
            sb.append("longValue:");
            sb.append(this.f509a);
            z = false;
        }
        if (f()) {
            if (!z) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            }
            sb.append("stringValue:");
            String str = this.f510a;
            if (str == null) {
                str = StringUtil.NULL_STRING;
            }
            sb.append(str);
        } else {
            z2 = z;
        }
        if (h()) {
            if (!z2) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            }
            sb.append("boolValue:");
            sb.append(this.f514b);
        }
        sb.append(SmallTailInfo.EMOTION_SUFFIX);
        return sb.toString();
    }
}
