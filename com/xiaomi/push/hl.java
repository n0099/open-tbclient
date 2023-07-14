package com.xiaomi.push;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.WebGLImageLoader;
import com.baidu.tbadk.core.data.SmallTailInfo;
import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes10.dex */
public class hl implements is<hl, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f479a;

    /* renamed from: a  reason: collision with other field name */
    public String f480a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f481a = new BitSet(3);

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f482a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f483a;

    /* renamed from: b  reason: collision with other field name */
    public long f484b;

    /* renamed from: b  reason: collision with other field name */
    public String f485b;

    /* renamed from: c  reason: collision with other field name */
    public String f486c;

    /* renamed from: d  reason: collision with other field name */
    public String f487d;

    /* renamed from: e  reason: collision with other field name */
    public String f488e;

    /* renamed from: f  reason: collision with other field name */
    public String f489f;

    /* renamed from: g  reason: collision with other field name */
    public String f490g;

    /* renamed from: a  reason: collision with other field name */
    public static final ji f478a = new ji("ClientUploadDataItem");
    public static final ja a = new ja("", Constants.GZIP_CAST_TYPE, 1);
    public static final ja b = new ja("", Constants.GZIP_CAST_TYPE, 2);
    public static final ja c = new ja("", Constants.GZIP_CAST_TYPE, 3);
    public static final ja d = new ja("", (byte) 10, 4);
    public static final ja e = new ja("", (byte) 10, 5);
    public static final ja f = new ja("", (byte) 2, 6);
    public static final ja g = new ja("", Constants.GZIP_CAST_TYPE, 7);
    public static final ja h = new ja("", Constants.GZIP_CAST_TYPE, 8);
    public static final ja i = new ja("", Constants.GZIP_CAST_TYPE, 9);
    public static final ja j = new ja("", (byte) 13, 10);
    public static final ja k = new ja("", Constants.GZIP_CAST_TYPE, 11);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(hl hlVar) {
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
        if (hl.class.equals(hlVar.getClass())) {
            int compareTo = Boolean.valueOf(m553a()).compareTo(Boolean.valueOf(hlVar.m553a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m553a() || (a12 = it.a(this.f480a, hlVar.f480a)) == 0) {
                int compareTo2 = Boolean.valueOf(m555b()).compareTo(Boolean.valueOf(hlVar.m555b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!m555b() || (a11 = it.a(this.f485b, hlVar.f485b)) == 0) {
                    int compareTo3 = Boolean.valueOf(m556c()).compareTo(Boolean.valueOf(hlVar.m556c()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!m556c() || (a10 = it.a(this.f486c, hlVar.f486c)) == 0) {
                        int compareTo4 = Boolean.valueOf(m557d()).compareTo(Boolean.valueOf(hlVar.m557d()));
                        if (compareTo4 != 0) {
                            return compareTo4;
                        }
                        if (!m557d() || (a9 = it.a(this.f479a, hlVar.f479a)) == 0) {
                            int compareTo5 = Boolean.valueOf(m558e()).compareTo(Boolean.valueOf(hlVar.m558e()));
                            if (compareTo5 != 0) {
                                return compareTo5;
                            }
                            if (!m558e() || (a8 = it.a(this.f484b, hlVar.f484b)) == 0) {
                                int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hlVar.f()));
                                if (compareTo6 != 0) {
                                    return compareTo6;
                                }
                                if (!f() || (a7 = it.a(this.f483a, hlVar.f483a)) == 0) {
                                    int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hlVar.g()));
                                    if (compareTo7 != 0) {
                                        return compareTo7;
                                    }
                                    if (!g() || (a6 = it.a(this.f487d, hlVar.f487d)) == 0) {
                                        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hlVar.h()));
                                        if (compareTo8 != 0) {
                                            return compareTo8;
                                        }
                                        if (!h() || (a5 = it.a(this.f488e, hlVar.f488e)) == 0) {
                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hlVar.i()));
                                            if (compareTo9 != 0) {
                                                return compareTo9;
                                            }
                                            if (!i() || (a4 = it.a(this.f489f, hlVar.f489f)) == 0) {
                                                int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(hlVar.j()));
                                                if (compareTo10 != 0) {
                                                    return compareTo10;
                                                }
                                                if (!j() || (a3 = it.a(this.f482a, hlVar.f482a)) == 0) {
                                                    int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(hlVar.k()));
                                                    if (compareTo11 != 0) {
                                                        return compareTo11;
                                                    }
                                                    if (!k() || (a2 = it.a(this.f490g, hlVar.f490g)) == 0) {
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
        return hl.class.getName().compareTo(hlVar.getClass().getName());
    }

    public long a() {
        return this.f484b;
    }

    public hl a(long j2) {
        this.f479a = j2;
        m552a(true);
        return this;
    }

    public hl a(String str) {
        this.f480a = str;
        return this;
    }

    public hl a(Map<String, String> map) {
        this.f482a = map;
        return this;
    }

    public hl a(boolean z) {
        this.f483a = z;
        c(true);
        return this;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m549a() {
        return this.f480a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public Map<String, String> m550a() {
        return this.f482a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m551a() {
    }

    @Override // com.xiaomi.push.is
    public void a(jd jdVar) {
        jdVar.mo697a();
        while (true) {
            ja mo693a = jdVar.mo693a();
            byte b2 = mo693a.a;
            if (b2 == 0) {
                jdVar.f();
                m551a();
                return;
            }
            switch (mo693a.f813a) {
                case 1:
                    if (b2 == 11) {
                        this.f480a = jdVar.mo698a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 2:
                    if (b2 == 11) {
                        this.f485b = jdVar.mo698a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f486c = jdVar.mo698a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 4:
                    if (b2 == 10) {
                        this.f479a = jdVar.mo692a();
                        m552a(true);
                        continue;
                        jdVar.g();
                    }
                    break;
                case 5:
                    if (b2 == 10) {
                        this.f484b = jdVar.mo692a();
                        b(true);
                        continue;
                        jdVar.g();
                    }
                    break;
                case 6:
                    if (b2 == 2) {
                        this.f483a = jdVar.mo703a();
                        c(true);
                        continue;
                        jdVar.g();
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f487d = jdVar.mo698a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 8:
                    if (b2 == 11) {
                        this.f488e = jdVar.mo698a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 9:
                    if (b2 == 11) {
                        this.f489f = jdVar.mo698a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 10:
                    if (b2 == 13) {
                        jc mo695a = jdVar.mo695a();
                        this.f482a = new HashMap(mo695a.f815a * 2);
                        for (int i2 = 0; i2 < mo695a.f815a; i2++) {
                            this.f482a.put(jdVar.mo698a(), jdVar.mo698a());
                        }
                        jdVar.h();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 11:
                    if (b2 == 11) {
                        this.f490g = jdVar.mo698a();
                        continue;
                        jdVar.g();
                    }
                    break;
            }
            jg.a(jdVar, b2);
            jdVar.g();
        }
    }

    public void a(String str, String str2) {
        if (this.f482a == null) {
            this.f482a = new HashMap();
        }
        this.f482a.put(str, str2);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m552a(boolean z) {
        this.f481a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m553a() {
        return this.f480a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m554a(hl hlVar) {
        if (hlVar == null) {
            return false;
        }
        boolean m553a = m553a();
        boolean m553a2 = hlVar.m553a();
        if ((m553a || m553a2) && !(m553a && m553a2 && this.f480a.equals(hlVar.f480a))) {
            return false;
        }
        boolean m555b = m555b();
        boolean m555b2 = hlVar.m555b();
        if ((m555b || m555b2) && !(m555b && m555b2 && this.f485b.equals(hlVar.f485b))) {
            return false;
        }
        boolean m556c = m556c();
        boolean m556c2 = hlVar.m556c();
        if ((m556c || m556c2) && !(m556c && m556c2 && this.f486c.equals(hlVar.f486c))) {
            return false;
        }
        boolean m557d = m557d();
        boolean m557d2 = hlVar.m557d();
        if ((m557d || m557d2) && !(m557d && m557d2 && this.f479a == hlVar.f479a)) {
            return false;
        }
        boolean m558e = m558e();
        boolean m558e2 = hlVar.m558e();
        if ((m558e || m558e2) && !(m558e && m558e2 && this.f484b == hlVar.f484b)) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = hlVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f483a == hlVar.f483a)) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = hlVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f487d.equals(hlVar.f487d))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = hlVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f488e.equals(hlVar.f488e))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = hlVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f489f.equals(hlVar.f489f))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = hlVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f482a.equals(hlVar.f482a))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = hlVar.k();
        if (k2 || k3) {
            return k2 && k3 && this.f490g.equals(hlVar.f490g);
        }
        return true;
    }

    public hl b(long j2) {
        this.f484b = j2;
        b(true);
        return this;
    }

    public hl b(String str) {
        this.f485b = str;
        return this;
    }

    public String b() {
        return this.f486c;
    }

    @Override // com.xiaomi.push.is
    public void b(jd jdVar) {
        m551a();
        jdVar.a(f478a);
        if (this.f480a != null && m553a()) {
            jdVar.a(a);
            jdVar.a(this.f480a);
            jdVar.b();
        }
        if (this.f485b != null && m555b()) {
            jdVar.a(b);
            jdVar.a(this.f485b);
            jdVar.b();
        }
        if (this.f486c != null && m556c()) {
            jdVar.a(c);
            jdVar.a(this.f486c);
            jdVar.b();
        }
        if (m557d()) {
            jdVar.a(d);
            jdVar.a(this.f479a);
            jdVar.b();
        }
        if (m558e()) {
            jdVar.a(e);
            jdVar.a(this.f484b);
            jdVar.b();
        }
        if (f()) {
            jdVar.a(f);
            jdVar.a(this.f483a);
            jdVar.b();
        }
        if (this.f487d != null && g()) {
            jdVar.a(g);
            jdVar.a(this.f487d);
            jdVar.b();
        }
        if (this.f488e != null && h()) {
            jdVar.a(h);
            jdVar.a(this.f488e);
            jdVar.b();
        }
        if (this.f489f != null && i()) {
            jdVar.a(i);
            jdVar.a(this.f489f);
            jdVar.b();
        }
        if (this.f482a != null && j()) {
            jdVar.a(j);
            jdVar.a(new jc(Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, this.f482a.size()));
            for (Map.Entry<String, String> entry : this.f482a.entrySet()) {
                jdVar.a(entry.getKey());
                jdVar.a(entry.getValue());
            }
            jdVar.d();
            jdVar.b();
        }
        if (this.f490g != null && k()) {
            jdVar.a(k);
            jdVar.a(this.f490g);
            jdVar.b();
        }
        jdVar.c();
        jdVar.mo701a();
    }

    public void b(boolean z) {
        this.f481a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m555b() {
        return this.f485b != null;
    }

    public hl c(String str) {
        this.f486c = str;
        return this;
    }

    public String c() {
        return this.f488e;
    }

    public void c(boolean z) {
        this.f481a.set(2, z);
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m556c() {
        return this.f486c != null;
    }

    public hl d(String str) {
        this.f487d = str;
        return this;
    }

    public String d() {
        return this.f489f;
    }

    /* renamed from: d  reason: collision with other method in class */
    public boolean m557d() {
        return this.f481a.get(0);
    }

    public hl e(String str) {
        this.f488e = str;
        return this;
    }

    public String e() {
        return this.f490g;
    }

    /* renamed from: e  reason: collision with other method in class */
    public boolean m558e() {
        return this.f481a.get(1);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hl)) {
            return m554a((hl) obj);
        }
        return false;
    }

    public hl f(String str) {
        this.f489f = str;
        return this;
    }

    public boolean f() {
        return this.f481a.get(2);
    }

    public hl g(String str) {
        this.f490g = str;
        return this;
    }

    public boolean g() {
        return this.f487d != null;
    }

    public boolean h() {
        return this.f488e != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f489f != null;
    }

    public boolean j() {
        return this.f482a != null;
    }

    public boolean k() {
        return this.f490g != null;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("ClientUploadDataItem(");
        boolean z2 = false;
        if (m553a()) {
            sb.append("channel:");
            String str = this.f480a;
            if (str == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (m555b()) {
            if (!z) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            }
            sb.append(WebGLImageLoader.DATA_URL);
            String str2 = this.f485b;
            if (str2 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str2);
            }
            z = false;
        }
        if (m556c()) {
            if (!z) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            }
            sb.append("name:");
            String str3 = this.f486c;
            if (str3 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str3);
            }
            z = false;
        }
        if (m557d()) {
            if (!z) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            }
            sb.append("counter:");
            sb.append(this.f479a);
            z = false;
        }
        if (m558e()) {
            if (!z) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            }
            sb.append("timestamp:");
            sb.append(this.f484b);
            z = false;
        }
        if (f()) {
            if (!z) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            }
            sb.append("fromSdk:");
            sb.append(this.f483a);
            z = false;
        }
        if (g()) {
            if (!z) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            }
            sb.append("category:");
            String str4 = this.f487d;
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
            String str5 = this.f488e;
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
            String str6 = this.f489f;
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
            Map<String, String> map = this.f482a;
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
            String str7 = this.f490g;
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
