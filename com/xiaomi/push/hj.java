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
    public static final iy f37732a = new iy("", (byte) 11, 1);

    /* renamed from: b  reason: collision with root package name */
    public static final iy f37733b = new iy("", (byte) 11, 2);

    /* renamed from: c  reason: collision with root package name */
    public static final iy f37734c = new iy("", (byte) 11, 3);

    /* renamed from: d  reason: collision with root package name */
    public static final iy f37735d = new iy("", (byte) 10, 4);

    /* renamed from: e  reason: collision with root package name */
    public static final iy f37736e = new iy("", (byte) 10, 5);

    /* renamed from: f  reason: collision with root package name */
    public static final iy f37737f = new iy("", (byte) 2, 6);

    /* renamed from: g  reason: collision with root package name */
    public static final iy f37738g = new iy("", (byte) 11, 7);

    /* renamed from: h  reason: collision with root package name */
    public static final iy f37739h = new iy("", (byte) 11, 8);

    /* renamed from: i  reason: collision with root package name */
    public static final iy f37740i = new iy("", (byte) 11, 9);
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
            int compareTo = Boolean.valueOf(m366a()).compareTo(Boolean.valueOf(hjVar.m366a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m366a() || (a12 = ir.a(this.f478a, hjVar.f478a)) == 0) {
                int compareTo2 = Boolean.valueOf(m368b()).compareTo(Boolean.valueOf(hjVar.m368b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!m368b() || (a11 = ir.a(this.f483b, hjVar.f483b)) == 0) {
                    int compareTo3 = Boolean.valueOf(m369c()).compareTo(Boolean.valueOf(hjVar.m369c()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!m369c() || (a10 = ir.a(this.f484c, hjVar.f484c)) == 0) {
                        int compareTo4 = Boolean.valueOf(m370d()).compareTo(Boolean.valueOf(hjVar.m370d()));
                        if (compareTo4 != 0) {
                            return compareTo4;
                        }
                        if (!m370d() || (a9 = ir.a(this.f477a, hjVar.f477a)) == 0) {
                            int compareTo5 = Boolean.valueOf(m371e()).compareTo(Boolean.valueOf(hjVar.m371e()));
                            if (compareTo5 != 0) {
                                return compareTo5;
                            }
                            if (!m371e() || (a8 = ir.a(this.f482b, hjVar.f482b)) == 0) {
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
        m365a(true);
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
    public String m362a() {
        return this.f478a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public Map<String, String> m363a() {
        return this.f480a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m364a() {
    }

    @Override // com.xiaomi.push.iq
    public void a(jb jbVar) {
        jbVar.m511a();
        while (true) {
            iy m507a = jbVar.m507a();
            byte b2 = m507a.f37969a;
            if (b2 == 0) {
                jbVar.f();
                m364a();
                return;
            }
            switch (m507a.f807a) {
                case 1:
                    if (b2 == 11) {
                        this.f478a = jbVar.m512a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 2:
                    if (b2 == 11) {
                        this.f483b = jbVar.m512a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f484c = jbVar.m512a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 4:
                    if (b2 == 10) {
                        this.f477a = jbVar.m506a();
                        m365a(true);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 5:
                    if (b2 == 10) {
                        this.f482b = jbVar.m506a();
                        b(true);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 6:
                    if (b2 == 2) {
                        this.f481a = jbVar.m516a();
                        c(true);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f485d = jbVar.m512a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 8:
                    if (b2 == 11) {
                        this.f486e = jbVar.m512a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 9:
                    if (b2 == 11) {
                        this.f487f = jbVar.m512a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 10:
                    if (b2 == 13) {
                        ja m509a = jbVar.m509a();
                        this.f480a = new HashMap(m509a.f811a * 2);
                        for (int i2 = 0; i2 < m509a.f811a; i2++) {
                            this.f480a.put(jbVar.m512a(), jbVar.m512a());
                        }
                        jbVar.h();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 11:
                    if (b2 == 11) {
                        this.f488g = jbVar.m512a();
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
    public void m365a(boolean z) {
        this.f479a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m366a() {
        return this.f478a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m367a(hj hjVar) {
        if (hjVar == null) {
            return false;
        }
        boolean m366a = m366a();
        boolean m366a2 = hjVar.m366a();
        if ((m366a || m366a2) && !(m366a && m366a2 && this.f478a.equals(hjVar.f478a))) {
            return false;
        }
        boolean m368b = m368b();
        boolean m368b2 = hjVar.m368b();
        if ((m368b || m368b2) && !(m368b && m368b2 && this.f483b.equals(hjVar.f483b))) {
            return false;
        }
        boolean m369c = m369c();
        boolean m369c2 = hjVar.m369c();
        if ((m369c || m369c2) && !(m369c && m369c2 && this.f484c.equals(hjVar.f484c))) {
            return false;
        }
        boolean m370d = m370d();
        boolean m370d2 = hjVar.m370d();
        if ((m370d || m370d2) && !(m370d && m370d2 && this.f477a == hjVar.f477a)) {
            return false;
        }
        boolean m371e = m371e();
        boolean m371e2 = hjVar.m371e();
        if ((m371e || m371e2) && !(m371e && m371e2 && this.f482b == hjVar.f482b)) {
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
        m364a();
        jbVar.a(f476a);
        if (this.f478a != null && m366a()) {
            jbVar.a(f37732a);
            jbVar.a(this.f478a);
            jbVar.b();
        }
        if (this.f483b != null && m368b()) {
            jbVar.a(f37733b);
            jbVar.a(this.f483b);
            jbVar.b();
        }
        if (this.f484c != null && m369c()) {
            jbVar.a(f37734c);
            jbVar.a(this.f484c);
            jbVar.b();
        }
        if (m370d()) {
            jbVar.a(f37735d);
            jbVar.a(this.f477a);
            jbVar.b();
        }
        if (m371e()) {
            jbVar.a(f37736e);
            jbVar.a(this.f482b);
            jbVar.b();
        }
        if (f()) {
            jbVar.a(f37737f);
            jbVar.a(this.f481a);
            jbVar.b();
        }
        if (this.f485d != null && g()) {
            jbVar.a(f37738g);
            jbVar.a(this.f485d);
            jbVar.b();
        }
        if (this.f486e != null && h()) {
            jbVar.a(f37739h);
            jbVar.a(this.f486e);
            jbVar.b();
        }
        if (this.f487f != null && i()) {
            jbVar.a(f37740i);
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
        jbVar.m515a();
    }

    public void b(boolean z) {
        this.f479a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m368b() {
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
    public boolean m369c() {
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
    public boolean m370d() {
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
    public boolean m371e() {
        return this.f479a.get(1);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hj)) {
            return m367a((hj) obj);
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
        if (m366a()) {
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
        if (m368b()) {
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
        if (m369c()) {
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
        if (m370d()) {
            if (!z) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            }
            sb.append("counter:");
            sb.append(this.f477a);
            z = false;
        }
        if (m371e()) {
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
