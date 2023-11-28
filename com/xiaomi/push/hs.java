package com.xiaomi.push;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes10.dex */
public class hs implements is<hs, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public int f506a;

    /* renamed from: a  reason: collision with other field name */
    public long f507a;

    /* renamed from: a  reason: collision with other field name */
    public String f508a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f509a = new BitSet(6);

    /* renamed from: a  reason: collision with other field name */
    public boolean f510a;

    /* renamed from: b  reason: collision with other field name */
    public int f511b;

    /* renamed from: b  reason: collision with other field name */
    public boolean f512b;

    /* renamed from: c  reason: collision with other field name */
    public int f513c;

    /* renamed from: a  reason: collision with other field name */
    public static final ji f505a = new ji("OnlineConfigItem");
    public static final ja a = new ja("", (byte) 8, 1);
    public static final ja b = new ja("", (byte) 8, 2);
    public static final ja c = new ja("", (byte) 2, 3);
    public static final ja d = new ja("", (byte) 8, 4);
    public static final ja e = new ja("", (byte) 10, 5);
    public static final ja f = new ja("", Constants.GZIP_CAST_TYPE, 6);
    public static final ja g = new ja("", (byte) 2, 7);

    public int a() {
        return this.f506a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(hs hsVar) {
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        int a8;
        if (hs.class.equals(hsVar.getClass())) {
            int compareTo = Boolean.valueOf(m582a()).compareTo(Boolean.valueOf(hsVar.m582a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m582a() || (a8 = it.a(this.f506a, hsVar.f506a)) == 0) {
                int compareTo2 = Boolean.valueOf(m584b()).compareTo(Boolean.valueOf(hsVar.m584b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!m584b() || (a7 = it.a(this.f511b, hsVar.f511b)) == 0) {
                    int compareTo3 = Boolean.valueOf(m585c()).compareTo(Boolean.valueOf(hsVar.m585c()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!m585c() || (a6 = it.a(this.f510a, hsVar.f510a)) == 0) {
                        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hsVar.d()));
                        if (compareTo4 != 0) {
                            return compareTo4;
                        }
                        if (!d() || (a5 = it.a(this.f513c, hsVar.f513c)) == 0) {
                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hsVar.e()));
                            if (compareTo5 != 0) {
                                return compareTo5;
                            }
                            if (!e() || (a4 = it.a(this.f507a, hsVar.f507a)) == 0) {
                                int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hsVar.f()));
                                if (compareTo6 != 0) {
                                    return compareTo6;
                                }
                                if (!f() || (a3 = it.a(this.f508a, hsVar.f508a)) == 0) {
                                    int compareTo7 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hsVar.h()));
                                    if (compareTo7 != 0) {
                                        return compareTo7;
                                    }
                                    if (!h() || (a2 = it.a(this.f512b, hsVar.f512b)) == 0) {
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
        return hs.class.getName().compareTo(hsVar.getClass().getName());
    }

    /* renamed from: a  reason: collision with other method in class */
    public long m579a() {
        return this.f507a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m580a() {
        return this.f508a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m581a() {
    }

    @Override // com.xiaomi.push.is
    public void a(jd jdVar) {
        jdVar.mo710a();
        while (true) {
            ja mo706a = jdVar.mo706a();
            byte b2 = mo706a.a;
            if (b2 == 0) {
                jdVar.f();
                m581a();
                return;
            }
            switch (mo706a.f809a) {
                case 1:
                    if (b2 == 8) {
                        this.f506a = jdVar.mo704a();
                        a(true);
                        continue;
                        jdVar.g();
                    }
                    break;
                case 2:
                    if (b2 == 8) {
                        this.f511b = jdVar.mo704a();
                        b(true);
                        continue;
                        jdVar.g();
                    }
                    break;
                case 3:
                    if (b2 == 2) {
                        this.f510a = jdVar.mo716a();
                        c(true);
                        continue;
                        jdVar.g();
                    }
                    break;
                case 4:
                    if (b2 == 8) {
                        this.f513c = jdVar.mo704a();
                        d(true);
                        continue;
                        jdVar.g();
                    }
                    break;
                case 5:
                    if (b2 == 10) {
                        this.f507a = jdVar.mo705a();
                        e(true);
                        continue;
                        jdVar.g();
                    }
                    break;
                case 6:
                    if (b2 == 11) {
                        this.f508a = jdVar.mo711a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 7:
                    if (b2 == 2) {
                        this.f512b = jdVar.mo716a();
                        f(true);
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
        this.f509a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m582a() {
        return this.f509a.get(0);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m583a(hs hsVar) {
        if (hsVar == null) {
            return false;
        }
        boolean m582a = m582a();
        boolean m582a2 = hsVar.m582a();
        if ((m582a || m582a2) && !(m582a && m582a2 && this.f506a == hsVar.f506a)) {
            return false;
        }
        boolean m584b = m584b();
        boolean m584b2 = hsVar.m584b();
        if ((m584b || m584b2) && !(m584b && m584b2 && this.f511b == hsVar.f511b)) {
            return false;
        }
        boolean m585c = m585c();
        boolean m585c2 = hsVar.m585c();
        if ((m585c || m585c2) && !(m585c && m585c2 && this.f510a == hsVar.f510a)) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = hsVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f513c == hsVar.f513c)) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = hsVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f507a == hsVar.f507a)) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = hsVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f508a.equals(hsVar.f508a))) {
            return false;
        }
        boolean h = h();
        boolean h2 = hsVar.h();
        if (h || h2) {
            return h && h2 && this.f512b == hsVar.f512b;
        }
        return true;
    }

    public int b() {
        return this.f511b;
    }

    @Override // com.xiaomi.push.is
    public void b(jd jdVar) {
        m581a();
        jdVar.a(f505a);
        if (m582a()) {
            jdVar.a(a);
            jdVar.mo715a(this.f506a);
            jdVar.b();
        }
        if (m584b()) {
            jdVar.a(b);
            jdVar.mo715a(this.f511b);
            jdVar.b();
        }
        if (m585c()) {
            jdVar.a(c);
            jdVar.a(this.f510a);
            jdVar.b();
        }
        if (d()) {
            jdVar.a(d);
            jdVar.mo715a(this.f513c);
            jdVar.b();
        }
        if (e()) {
            jdVar.a(e);
            jdVar.a(this.f507a);
            jdVar.b();
        }
        if (this.f508a != null && f()) {
            jdVar.a(f);
            jdVar.a(this.f508a);
            jdVar.b();
        }
        if (h()) {
            jdVar.a(g);
            jdVar.a(this.f512b);
            jdVar.b();
        }
        jdVar.c();
        jdVar.mo714a();
    }

    public void b(boolean z) {
        this.f509a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m584b() {
        return this.f509a.get(1);
    }

    public int c() {
        return this.f513c;
    }

    public void c(boolean z) {
        this.f509a.set(2, z);
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m585c() {
        return this.f509a.get(2);
    }

    public void d(boolean z) {
        this.f509a.set(3, z);
    }

    public boolean d() {
        return this.f509a.get(3);
    }

    public void e(boolean z) {
        this.f509a.set(4, z);
    }

    public boolean e() {
        return this.f509a.get(4);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hs)) {
            return m583a((hs) obj);
        }
        return false;
    }

    public void f(boolean z) {
        this.f509a.set(5, z);
    }

    public boolean f() {
        return this.f508a != null;
    }

    public boolean g() {
        return this.f512b;
    }

    public boolean h() {
        return this.f509a.get(5);
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("OnlineConfigItem(");
        boolean z2 = false;
        if (m582a()) {
            sb.append("key:");
            sb.append(this.f506a);
            z = false;
        } else {
            z = true;
        }
        if (m584b()) {
            if (!z) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            }
            sb.append("type:");
            sb.append(this.f511b);
            z = false;
        }
        if (m585c()) {
            if (!z) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            }
            sb.append("clear:");
            sb.append(this.f510a);
            z = false;
        }
        if (d()) {
            if (!z) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            }
            sb.append("intValue:");
            sb.append(this.f513c);
            z = false;
        }
        if (e()) {
            if (!z) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            }
            sb.append("longValue:");
            sb.append(this.f507a);
            z = false;
        }
        if (f()) {
            if (!z) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            }
            sb.append("stringValue:");
            String str = this.f508a;
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
            sb.append(this.f512b);
        }
        sb.append(SmallTailInfo.EMOTION_SUFFIX);
        return sb.toString();
    }
}
