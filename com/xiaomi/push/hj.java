package com.xiaomi.push;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.searchbox.v8engine.WebGLImageLoader;
import com.baidu.tbadk.core.data.SmallTailInfo;
import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes7.dex */
public class hj implements iq<hj, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f477a;

    /* renamed from: a  reason: collision with other field name */
    public String f478a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f479a = new BitSet(3);

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f480a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f481a;

    /* renamed from: b  reason: collision with other field name */
    public long f482b;

    /* renamed from: b  reason: collision with other field name */
    public String f483b;

    /* renamed from: c  reason: collision with other field name */
    public String f484c;

    /* renamed from: d  reason: collision with other field name */
    public String f485d;

    /* renamed from: e  reason: collision with other field name */
    public String f486e;

    /* renamed from: f  reason: collision with other field name */
    public String f487f;

    /* renamed from: g  reason: collision with other field name */
    public String f488g;

    /* renamed from: a  reason: collision with other field name */
    public static final jg f476a = new jg("ClientUploadDataItem");

    /* renamed from: a  reason: collision with root package name */
    public static final iy f38558a = new iy("", (byte) 11, 1);

    /* renamed from: b  reason: collision with root package name */
    public static final iy f38559b = new iy("", (byte) 11, 2);

    /* renamed from: c  reason: collision with root package name */
    public static final iy f38560c = new iy("", (byte) 11, 3);

    /* renamed from: d  reason: collision with root package name */
    public static final iy f38561d = new iy("", (byte) 10, 4);

    /* renamed from: e  reason: collision with root package name */
    public static final iy f38562e = new iy("", (byte) 10, 5);

    /* renamed from: f  reason: collision with root package name */
    public static final iy f38563f = new iy("", (byte) 2, 6);

    /* renamed from: g  reason: collision with root package name */
    public static final iy f38564g = new iy("", (byte) 11, 7);

    /* renamed from: h  reason: collision with root package name */
    public static final iy f38565h = new iy("", (byte) 11, 8);

    /* renamed from: i  reason: collision with root package name */
    public static final iy f38566i = new iy("", (byte) 11, 9);
    public static final iy j = new iy("", (byte) 13, 10);
    public static final iy k = new iy("", (byte) 11, 11);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(hj hjVar) {
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
        int a12;
        if (hj.class.equals(hjVar.getClass())) {
            int compareTo = Boolean.valueOf(m367a()).compareTo(Boolean.valueOf(hjVar.m367a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m367a() || (a12 = ir.a(this.f478a, hjVar.f478a)) == 0) {
                int compareTo2 = Boolean.valueOf(m369b()).compareTo(Boolean.valueOf(hjVar.m369b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!m369b() || (a11 = ir.a(this.f483b, hjVar.f483b)) == 0) {
                    int compareTo3 = Boolean.valueOf(m370c()).compareTo(Boolean.valueOf(hjVar.m370c()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!m370c() || (a10 = ir.a(this.f484c, hjVar.f484c)) == 0) {
                        int compareTo4 = Boolean.valueOf(m371d()).compareTo(Boolean.valueOf(hjVar.m371d()));
                        if (compareTo4 != 0) {
                            return compareTo4;
                        }
                        if (!m371d() || (a9 = ir.a(this.f477a, hjVar.f477a)) == 0) {
                            int compareTo5 = Boolean.valueOf(m372e()).compareTo(Boolean.valueOf(hjVar.m372e()));
                            if (compareTo5 != 0) {
                                return compareTo5;
                            }
                            if (!m372e() || (a8 = ir.a(this.f482b, hjVar.f482b)) == 0) {
                                int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hjVar.f()));
                                if (compareTo6 != 0) {
                                    return compareTo6;
                                }
                                if (!f() || (a7 = ir.a(this.f481a, hjVar.f481a)) == 0) {
                                    int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hjVar.g()));
                                    if (compareTo7 != 0) {
                                        return compareTo7;
                                    }
                                    if (!g() || (a6 = ir.a(this.f485d, hjVar.f485d)) == 0) {
                                        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hjVar.h()));
                                        if (compareTo8 != 0) {
                                            return compareTo8;
                                        }
                                        if (!h() || (a5 = ir.a(this.f486e, hjVar.f486e)) == 0) {
                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hjVar.i()));
                                            if (compareTo9 != 0) {
                                                return compareTo9;
                                            }
                                            if (!i() || (a4 = ir.a(this.f487f, hjVar.f487f)) == 0) {
                                                int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(hjVar.j()));
                                                if (compareTo10 != 0) {
                                                    return compareTo10;
                                                }
                                                if (!j() || (a3 = ir.a(this.f480a, hjVar.f480a)) == 0) {
                                                    int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(hjVar.k()));
                                                    if (compareTo11 != 0) {
                                                        return compareTo11;
                                                    }
                                                    if (!k() || (a2 = ir.a(this.f488g, hjVar.f488g)) == 0) {
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
            return a12;
        }
        return hj.class.getName().compareTo(hjVar.getClass().getName());
    }

    public long a() {
        return this.f482b;
    }

    public hj a(long j2) {
        this.f477a = j2;
        m366a(true);
        return this;
    }

    public hj a(String str) {
        this.f478a = str;
        return this;
    }

    public hj a(Map<String, String> map) {
        this.f480a = map;
        return this;
    }

    public hj a(boolean z) {
        this.f481a = z;
        c(true);
        return this;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m363a() {
        return this.f478a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public Map<String, String> m364a() {
        return this.f480a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m365a() {
    }

    @Override // com.xiaomi.push.iq
    public void a(jb jbVar) {
        jbVar.m512a();
        while (true) {
            iy m508a = jbVar.m508a();
            byte b2 = m508a.f38795a;
            if (b2 == 0) {
                jbVar.f();
                m365a();
                return;
            }
            switch (m508a.f807a) {
                case 1:
                    if (b2 == 11) {
                        this.f478a = jbVar.m513a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 2:
                    if (b2 == 11) {
                        this.f483b = jbVar.m513a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f484c = jbVar.m513a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 4:
                    if (b2 == 10) {
                        this.f477a = jbVar.m507a();
                        m366a(true);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 5:
                    if (b2 == 10) {
                        this.f482b = jbVar.m507a();
                        b(true);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 6:
                    if (b2 == 2) {
                        this.f481a = jbVar.m517a();
                        c(true);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f485d = jbVar.m513a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 8:
                    if (b2 == 11) {
                        this.f486e = jbVar.m513a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 9:
                    if (b2 == 11) {
                        this.f487f = jbVar.m513a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 10:
                    if (b2 == 13) {
                        ja m510a = jbVar.m510a();
                        this.f480a = new HashMap(m510a.f811a * 2);
                        for (int i2 = 0; i2 < m510a.f811a; i2++) {
                            this.f480a.put(jbVar.m513a(), jbVar.m513a());
                        }
                        jbVar.h();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 11:
                    if (b2 == 11) {
                        this.f488g = jbVar.m513a();
                        continue;
                        jbVar.g();
                    }
                    break;
            }
            je.a(jbVar, b2);
            jbVar.g();
        }
    }

    public void a(String str, String str2) {
        if (this.f480a == null) {
            this.f480a = new HashMap();
        }
        this.f480a.put(str, str2);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m366a(boolean z) {
        this.f479a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m367a() {
        return this.f478a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m368a(hj hjVar) {
        if (hjVar == null) {
            return false;
        }
        boolean m367a = m367a();
        boolean m367a2 = hjVar.m367a();
        if ((m367a || m367a2) && !(m367a && m367a2 && this.f478a.equals(hjVar.f478a))) {
            return false;
        }
        boolean m369b = m369b();
        boolean m369b2 = hjVar.m369b();
        if ((m369b || m369b2) && !(m369b && m369b2 && this.f483b.equals(hjVar.f483b))) {
            return false;
        }
        boolean m370c = m370c();
        boolean m370c2 = hjVar.m370c();
        if ((m370c || m370c2) && !(m370c && m370c2 && this.f484c.equals(hjVar.f484c))) {
            return false;
        }
        boolean m371d = m371d();
        boolean m371d2 = hjVar.m371d();
        if ((m371d || m371d2) && !(m371d && m371d2 && this.f477a == hjVar.f477a)) {
            return false;
        }
        boolean m372e = m372e();
        boolean m372e2 = hjVar.m372e();
        if ((m372e || m372e2) && !(m372e && m372e2 && this.f482b == hjVar.f482b)) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = hjVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f481a == hjVar.f481a)) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = hjVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f485d.equals(hjVar.f485d))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = hjVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f486e.equals(hjVar.f486e))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = hjVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f487f.equals(hjVar.f487f))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = hjVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f480a.equals(hjVar.f480a))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = hjVar.k();
        if (k2 || k3) {
            return k2 && k3 && this.f488g.equals(hjVar.f488g);
        }
        return true;
    }

    public hj b(long j2) {
        this.f482b = j2;
        b(true);
        return this;
    }

    public hj b(String str) {
        this.f483b = str;
        return this;
    }

    public String b() {
        return this.f484c;
    }

    @Override // com.xiaomi.push.iq
    public void b(jb jbVar) {
        m365a();
        jbVar.a(f476a);
        if (this.f478a != null && m367a()) {
            jbVar.a(f38558a);
            jbVar.a(this.f478a);
            jbVar.b();
        }
        if (this.f483b != null && m369b()) {
            jbVar.a(f38559b);
            jbVar.a(this.f483b);
            jbVar.b();
        }
        if (this.f484c != null && m370c()) {
            jbVar.a(f38560c);
            jbVar.a(this.f484c);
            jbVar.b();
        }
        if (m371d()) {
            jbVar.a(f38561d);
            jbVar.a(this.f477a);
            jbVar.b();
        }
        if (m372e()) {
            jbVar.a(f38562e);
            jbVar.a(this.f482b);
            jbVar.b();
        }
        if (f()) {
            jbVar.a(f38563f);
            jbVar.a(this.f481a);
            jbVar.b();
        }
        if (this.f485d != null && g()) {
            jbVar.a(f38564g);
            jbVar.a(this.f485d);
            jbVar.b();
        }
        if (this.f486e != null && h()) {
            jbVar.a(f38565h);
            jbVar.a(this.f486e);
            jbVar.b();
        }
        if (this.f487f != null && i()) {
            jbVar.a(f38566i);
            jbVar.a(this.f487f);
            jbVar.b();
        }
        if (this.f480a != null && j()) {
            jbVar.a(j);
            jbVar.a(new ja((byte) 11, (byte) 11, this.f480a.size()));
            for (Map.Entry<String, String> entry : this.f480a.entrySet()) {
                jbVar.a(entry.getKey());
                jbVar.a(entry.getValue());
            }
            jbVar.d();
            jbVar.b();
        }
        if (this.f488g != null && k()) {
            jbVar.a(k);
            jbVar.a(this.f488g);
            jbVar.b();
        }
        jbVar.c();
        jbVar.m516a();
    }

    public void b(boolean z) {
        this.f479a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m369b() {
        return this.f483b != null;
    }

    public hj c(String str) {
        this.f484c = str;
        return this;
    }

    public String c() {
        return this.f486e;
    }

    public void c(boolean z) {
        this.f479a.set(2, z);
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m370c() {
        return this.f484c != null;
    }

    public hj d(String str) {
        this.f485d = str;
        return this;
    }

    public String d() {
        return this.f487f;
    }

    /* renamed from: d  reason: collision with other method in class */
    public boolean m371d() {
        return this.f479a.get(0);
    }

    public hj e(String str) {
        this.f486e = str;
        return this;
    }

    public String e() {
        return this.f488g;
    }

    /* renamed from: e  reason: collision with other method in class */
    public boolean m372e() {
        return this.f479a.get(1);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hj)) {
            return m368a((hj) obj);
        }
        return false;
    }

    public hj f(String str) {
        this.f487f = str;
        return this;
    }

    public boolean f() {
        return this.f479a.get(2);
    }

    public hj g(String str) {
        this.f488g = str;
        return this;
    }

    public boolean g() {
        return this.f485d != null;
    }

    public boolean h() {
        return this.f486e != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f487f != null;
    }

    public boolean j() {
        return this.f480a != null;
    }

    public boolean k() {
        return this.f488g != null;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("ClientUploadDataItem(");
        boolean z2 = false;
        if (m367a()) {
            sb.append("channel:");
            String str = this.f478a;
            if (str == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (m369b()) {
            if (!z) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            }
            sb.append(WebGLImageLoader.DATA_URL);
            String str2 = this.f483b;
            if (str2 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str2);
            }
            z = false;
        }
        if (m370c()) {
            if (!z) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            }
            sb.append("name:");
            String str3 = this.f484c;
            if (str3 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str3);
            }
            z = false;
        }
        if (m371d()) {
            if (!z) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            }
            sb.append("counter:");
            sb.append(this.f477a);
            z = false;
        }
        if (m372e()) {
            if (!z) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            }
            sb.append("timestamp:");
            sb.append(this.f482b);
            z = false;
        }
        if (f()) {
            if (!z) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            }
            sb.append("fromSdk:");
            sb.append(this.f481a);
            z = false;
        }
        if (g()) {
            if (!z) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            }
            sb.append("category:");
            String str4 = this.f485d;
            if (str4 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str4);
            }
            z = false;
        }
        if (h()) {
            if (!z) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            }
            sb.append("sourcePackage:");
            String str5 = this.f486e;
            if (str5 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str5);
            }
            z = false;
        }
        if (i()) {
            if (!z) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            }
            sb.append("id:");
            String str6 = this.f487f;
            if (str6 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str6);
            }
            z = false;
        }
        if (j()) {
            if (!z) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            }
            sb.append("extra:");
            Map<String, String> map = this.f480a;
            if (map == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(map);
            }
        } else {
            z2 = z;
        }
        if (k()) {
            if (!z2) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            }
            sb.append("pkgName:");
            String str7 = this.f488g;
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
