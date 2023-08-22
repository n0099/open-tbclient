package com.xiaomi.push;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes10.dex */
public class hs implements is<hs, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public int f511a;

    /* renamed from: a  reason: collision with other field name */
    public long f512a;

    /* renamed from: a  reason: collision with other field name */
    public String f513a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f514a = new BitSet(6);

    /* renamed from: a  reason: collision with other field name */
    public boolean f515a;

    /* renamed from: b  reason: collision with other field name */
    public int f516b;

    /* renamed from: b  reason: collision with other field name */
    public boolean f517b;

    /* renamed from: c  reason: collision with other field name */
    public int f518c;

    /* renamed from: a  reason: collision with other field name */
    public static final ji f510a = new ji("OnlineConfigItem");
    public static final ja a = new ja("", (byte) 8, 1);
    public static final ja b = new ja("", (byte) 8, 2);
    public static final ja c = new ja("", (byte) 2, 3);
    public static final ja d = new ja("", (byte) 8, 4);
    public static final ja e = new ja("", (byte) 10, 5);
    public static final ja f = new ja("", Constants.GZIP_CAST_TYPE, 6);
    public static final ja g = new ja("", (byte) 2, 7);

    public int a() {
        return this.f511a;
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
            int compareTo = Boolean.valueOf(m572a()).compareTo(Boolean.valueOf(hsVar.m572a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m572a() || (a8 = it.a(this.f511a, hsVar.f511a)) == 0) {
                int compareTo2 = Boolean.valueOf(m574b()).compareTo(Boolean.valueOf(hsVar.m574b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!m574b() || (a7 = it.a(this.f516b, hsVar.f516b)) == 0) {
                    int compareTo3 = Boolean.valueOf(m575c()).compareTo(Boolean.valueOf(hsVar.m575c()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!m575c() || (a6 = it.a(this.f515a, hsVar.f515a)) == 0) {
                        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hsVar.d()));
                        if (compareTo4 != 0) {
                            return compareTo4;
                        }
                        if (!d() || (a5 = it.a(this.f518c, hsVar.f518c)) == 0) {
                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hsVar.e()));
                            if (compareTo5 != 0) {
                                return compareTo5;
                            }
                            if (!e() || (a4 = it.a(this.f512a, hsVar.f512a)) == 0) {
                                int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hsVar.f()));
                                if (compareTo6 != 0) {
                                    return compareTo6;
                                }
                                if (!f() || (a3 = it.a(this.f513a, hsVar.f513a)) == 0) {
                                    int compareTo7 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hsVar.h()));
                                    if (compareTo7 != 0) {
                                        return compareTo7;
                                    }
                                    if (!h() || (a2 = it.a(this.f517b, hsVar.f517b)) == 0) {
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
    public long m569a() {
        return this.f512a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m570a() {
        return this.f513a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m571a() {
    }

    @Override // com.xiaomi.push.is
    public void a(jd jdVar) {
        jdVar.mo700a();
        while (true) {
            ja mo696a = jdVar.mo696a();
            byte b2 = mo696a.a;
            if (b2 == 0) {
                jdVar.f();
                m571a();
                return;
            }
            switch (mo696a.f814a) {
                case 1:
                    if (b2 == 8) {
                        this.f511a = jdVar.mo694a();
                        a(true);
                        continue;
                        jdVar.g();
                    }
                    break;
                case 2:
                    if (b2 == 8) {
                        this.f516b = jdVar.mo694a();
                        b(true);
                        continue;
                        jdVar.g();
                    }
                    break;
                case 3:
                    if (b2 == 2) {
                        this.f515a = jdVar.mo706a();
                        c(true);
                        continue;
                        jdVar.g();
                    }
                    break;
                case 4:
                    if (b2 == 8) {
                        this.f518c = jdVar.mo694a();
                        d(true);
                        continue;
                        jdVar.g();
                    }
                    break;
                case 5:
                    if (b2 == 10) {
                        this.f512a = jdVar.mo695a();
                        e(true);
                        continue;
                        jdVar.g();
                    }
                    break;
                case 6:
                    if (b2 == 11) {
                        this.f513a = jdVar.mo701a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 7:
                    if (b2 == 2) {
                        this.f517b = jdVar.mo706a();
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
        this.f514a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m572a() {
        return this.f514a.get(0);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m573a(hs hsVar) {
        if (hsVar == null) {
            return false;
        }
        boolean m572a = m572a();
        boolean m572a2 = hsVar.m572a();
        if ((m572a || m572a2) && !(m572a && m572a2 && this.f511a == hsVar.f511a)) {
            return false;
        }
        boolean m574b = m574b();
        boolean m574b2 = hsVar.m574b();
        if ((m574b || m574b2) && !(m574b && m574b2 && this.f516b == hsVar.f516b)) {
            return false;
        }
        boolean m575c = m575c();
        boolean m575c2 = hsVar.m575c();
        if ((m575c || m575c2) && !(m575c && m575c2 && this.f515a == hsVar.f515a)) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = hsVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f518c == hsVar.f518c)) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = hsVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f512a == hsVar.f512a)) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = hsVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f513a.equals(hsVar.f513a))) {
            return false;
        }
        boolean h = h();
        boolean h2 = hsVar.h();
        if (h || h2) {
            return h && h2 && this.f517b == hsVar.f517b;
        }
        return true;
    }

    public int b() {
        return this.f516b;
    }

    @Override // com.xiaomi.push.is
    public void b(jd jdVar) {
        m571a();
        jdVar.a(f510a);
        if (m572a()) {
            jdVar.a(a);
            jdVar.mo705a(this.f511a);
            jdVar.b();
        }
        if (m574b()) {
            jdVar.a(b);
            jdVar.mo705a(this.f516b);
            jdVar.b();
        }
        if (m575c()) {
            jdVar.a(c);
            jdVar.a(this.f515a);
            jdVar.b();
        }
        if (d()) {
            jdVar.a(d);
            jdVar.mo705a(this.f518c);
            jdVar.b();
        }
        if (e()) {
            jdVar.a(e);
            jdVar.a(this.f512a);
            jdVar.b();
        }
        if (this.f513a != null && f()) {
            jdVar.a(f);
            jdVar.a(this.f513a);
            jdVar.b();
        }
        if (h()) {
            jdVar.a(g);
            jdVar.a(this.f517b);
            jdVar.b();
        }
        jdVar.c();
        jdVar.mo704a();
    }

    public void b(boolean z) {
        this.f514a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m574b() {
        return this.f514a.get(1);
    }

    public int c() {
        return this.f518c;
    }

    public void c(boolean z) {
        this.f514a.set(2, z);
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m575c() {
        return this.f514a.get(2);
    }

    public void d(boolean z) {
        this.f514a.set(3, z);
    }

    public boolean d() {
        return this.f514a.get(3);
    }

    public void e(boolean z) {
        this.f514a.set(4, z);
    }

    public boolean e() {
        return this.f514a.get(4);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hs)) {
            return m573a((hs) obj);
        }
        return false;
    }

    public void f(boolean z) {
        this.f514a.set(5, z);
    }

    public boolean f() {
        return this.f513a != null;
    }

    public boolean g() {
        return this.f517b;
    }

    public boolean h() {
        return this.f514a.get(5);
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("OnlineConfigItem(");
        boolean z2 = false;
        if (m572a()) {
            sb.append("key:");
            sb.append(this.f511a);
            z = false;
        } else {
            z = true;
        }
        if (m574b()) {
            if (!z) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            }
            sb.append("type:");
            sb.append(this.f516b);
            z = false;
        }
        if (m575c()) {
            if (!z) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            }
            sb.append("clear:");
            sb.append(this.f515a);
            z = false;
        }
        if (d()) {
            if (!z) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            }
            sb.append("intValue:");
            sb.append(this.f518c);
            z = false;
        }
        if (e()) {
            if (!z) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            }
            sb.append("longValue:");
            sb.append(this.f512a);
            z = false;
        }
        if (f()) {
            if (!z) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            }
            sb.append("stringValue:");
            String str = this.f513a;
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
            sb.append(this.f517b);
        }
        sb.append(SmallTailInfo.EMOTION_SUFFIX);
        return sb.toString();
    }
}
