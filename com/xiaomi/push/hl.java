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
    public long f475a;

    /* renamed from: a  reason: collision with other field name */
    public String f476a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f477a = new BitSet(3);

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f478a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f479a;

    /* renamed from: b  reason: collision with other field name */
    public long f480b;

    /* renamed from: b  reason: collision with other field name */
    public String f481b;

    /* renamed from: c  reason: collision with other field name */
    public String f482c;

    /* renamed from: d  reason: collision with other field name */
    public String f483d;

    /* renamed from: e  reason: collision with other field name */
    public String f484e;

    /* renamed from: f  reason: collision with other field name */
    public String f485f;

    /* renamed from: g  reason: collision with other field name */
    public String f486g;

    /* renamed from: a  reason: collision with other field name */
    public static final ji f474a = new ji("ClientUploadDataItem");
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
            int compareTo = Boolean.valueOf(m566a()).compareTo(Boolean.valueOf(hlVar.m566a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m566a() || (a12 = it.a(this.f476a, hlVar.f476a)) == 0) {
                int compareTo2 = Boolean.valueOf(m568b()).compareTo(Boolean.valueOf(hlVar.m568b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!m568b() || (a11 = it.a(this.f481b, hlVar.f481b)) == 0) {
                    int compareTo3 = Boolean.valueOf(m569c()).compareTo(Boolean.valueOf(hlVar.m569c()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!m569c() || (a10 = it.a(this.f482c, hlVar.f482c)) == 0) {
                        int compareTo4 = Boolean.valueOf(m570d()).compareTo(Boolean.valueOf(hlVar.m570d()));
                        if (compareTo4 != 0) {
                            return compareTo4;
                        }
                        if (!m570d() || (a9 = it.a(this.f475a, hlVar.f475a)) == 0) {
                            int compareTo5 = Boolean.valueOf(m571e()).compareTo(Boolean.valueOf(hlVar.m571e()));
                            if (compareTo5 != 0) {
                                return compareTo5;
                            }
                            if (!m571e() || (a8 = it.a(this.f480b, hlVar.f480b)) == 0) {
                                int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hlVar.f()));
                                if (compareTo6 != 0) {
                                    return compareTo6;
                                }
                                if (!f() || (a7 = it.a(this.f479a, hlVar.f479a)) == 0) {
                                    int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hlVar.g()));
                                    if (compareTo7 != 0) {
                                        return compareTo7;
                                    }
                                    if (!g() || (a6 = it.a(this.f483d, hlVar.f483d)) == 0) {
                                        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hlVar.h()));
                                        if (compareTo8 != 0) {
                                            return compareTo8;
                                        }
                                        if (!h() || (a5 = it.a(this.f484e, hlVar.f484e)) == 0) {
                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hlVar.i()));
                                            if (compareTo9 != 0) {
                                                return compareTo9;
                                            }
                                            if (!i() || (a4 = it.a(this.f485f, hlVar.f485f)) == 0) {
                                                int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(hlVar.j()));
                                                if (compareTo10 != 0) {
                                                    return compareTo10;
                                                }
                                                if (!j() || (a3 = it.a(this.f478a, hlVar.f478a)) == 0) {
                                                    int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(hlVar.k()));
                                                    if (compareTo11 != 0) {
                                                        return compareTo11;
                                                    }
                                                    if (!k() || (a2 = it.a(this.f486g, hlVar.f486g)) == 0) {
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
        return this.f480b;
    }

    public hl a(long j2) {
        this.f475a = j2;
        m565a(true);
        return this;
    }

    public hl a(String str) {
        this.f476a = str;
        return this;
    }

    public hl a(Map<String, String> map) {
        this.f478a = map;
        return this;
    }

    public hl a(boolean z) {
        this.f479a = z;
        c(true);
        return this;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m562a() {
        return this.f476a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public Map<String, String> m563a() {
        return this.f478a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m564a() {
    }

    @Override // com.xiaomi.push.is
    public void a(jd jdVar) {
        jdVar.mo710a();
        while (true) {
            ja mo706a = jdVar.mo706a();
            byte b2 = mo706a.a;
            if (b2 == 0) {
                jdVar.f();
                m564a();
                return;
            }
            switch (mo706a.f809a) {
                case 1:
                    if (b2 == 11) {
                        this.f476a = jdVar.mo711a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 2:
                    if (b2 == 11) {
                        this.f481b = jdVar.mo711a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f482c = jdVar.mo711a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 4:
                    if (b2 == 10) {
                        this.f475a = jdVar.mo705a();
                        m565a(true);
                        continue;
                        jdVar.g();
                    }
                    break;
                case 5:
                    if (b2 == 10) {
                        this.f480b = jdVar.mo705a();
                        b(true);
                        continue;
                        jdVar.g();
                    }
                    break;
                case 6:
                    if (b2 == 2) {
                        this.f479a = jdVar.mo716a();
                        c(true);
                        continue;
                        jdVar.g();
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f483d = jdVar.mo711a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 8:
                    if (b2 == 11) {
                        this.f484e = jdVar.mo711a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 9:
                    if (b2 == 11) {
                        this.f485f = jdVar.mo711a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 10:
                    if (b2 == 13) {
                        jc mo708a = jdVar.mo708a();
                        this.f478a = new HashMap(mo708a.f811a * 2);
                        for (int i2 = 0; i2 < mo708a.f811a; i2++) {
                            this.f478a.put(jdVar.mo711a(), jdVar.mo711a());
                        }
                        jdVar.h();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 11:
                    if (b2 == 11) {
                        this.f486g = jdVar.mo711a();
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
        if (this.f478a == null) {
            this.f478a = new HashMap();
        }
        this.f478a.put(str, str2);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m565a(boolean z) {
        this.f477a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m566a() {
        return this.f476a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m567a(hl hlVar) {
        if (hlVar == null) {
            return false;
        }
        boolean m566a = m566a();
        boolean m566a2 = hlVar.m566a();
        if ((m566a || m566a2) && !(m566a && m566a2 && this.f476a.equals(hlVar.f476a))) {
            return false;
        }
        boolean m568b = m568b();
        boolean m568b2 = hlVar.m568b();
        if ((m568b || m568b2) && !(m568b && m568b2 && this.f481b.equals(hlVar.f481b))) {
            return false;
        }
        boolean m569c = m569c();
        boolean m569c2 = hlVar.m569c();
        if ((m569c || m569c2) && !(m569c && m569c2 && this.f482c.equals(hlVar.f482c))) {
            return false;
        }
        boolean m570d = m570d();
        boolean m570d2 = hlVar.m570d();
        if ((m570d || m570d2) && !(m570d && m570d2 && this.f475a == hlVar.f475a)) {
            return false;
        }
        boolean m571e = m571e();
        boolean m571e2 = hlVar.m571e();
        if ((m571e || m571e2) && !(m571e && m571e2 && this.f480b == hlVar.f480b)) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = hlVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f479a == hlVar.f479a)) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = hlVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f483d.equals(hlVar.f483d))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = hlVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f484e.equals(hlVar.f484e))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = hlVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f485f.equals(hlVar.f485f))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = hlVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f478a.equals(hlVar.f478a))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = hlVar.k();
        if (k2 || k3) {
            return k2 && k3 && this.f486g.equals(hlVar.f486g);
        }
        return true;
    }

    public hl b(long j2) {
        this.f480b = j2;
        b(true);
        return this;
    }

    public hl b(String str) {
        this.f481b = str;
        return this;
    }

    public String b() {
        return this.f482c;
    }

    @Override // com.xiaomi.push.is
    public void b(jd jdVar) {
        m564a();
        jdVar.a(f474a);
        if (this.f476a != null && m566a()) {
            jdVar.a(a);
            jdVar.a(this.f476a);
            jdVar.b();
        }
        if (this.f481b != null && m568b()) {
            jdVar.a(b);
            jdVar.a(this.f481b);
            jdVar.b();
        }
        if (this.f482c != null && m569c()) {
            jdVar.a(c);
            jdVar.a(this.f482c);
            jdVar.b();
        }
        if (m570d()) {
            jdVar.a(d);
            jdVar.a(this.f475a);
            jdVar.b();
        }
        if (m571e()) {
            jdVar.a(e);
            jdVar.a(this.f480b);
            jdVar.b();
        }
        if (f()) {
            jdVar.a(f);
            jdVar.a(this.f479a);
            jdVar.b();
        }
        if (this.f483d != null && g()) {
            jdVar.a(g);
            jdVar.a(this.f483d);
            jdVar.b();
        }
        if (this.f484e != null && h()) {
            jdVar.a(h);
            jdVar.a(this.f484e);
            jdVar.b();
        }
        if (this.f485f != null && i()) {
            jdVar.a(i);
            jdVar.a(this.f485f);
            jdVar.b();
        }
        if (this.f478a != null && j()) {
            jdVar.a(j);
            jdVar.a(new jc(Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, this.f478a.size()));
            for (Map.Entry<String, String> entry : this.f478a.entrySet()) {
                jdVar.a(entry.getKey());
                jdVar.a(entry.getValue());
            }
            jdVar.d();
            jdVar.b();
        }
        if (this.f486g != null && k()) {
            jdVar.a(k);
            jdVar.a(this.f486g);
            jdVar.b();
        }
        jdVar.c();
        jdVar.mo714a();
    }

    public void b(boolean z) {
        this.f477a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m568b() {
        return this.f481b != null;
    }

    public hl c(String str) {
        this.f482c = str;
        return this;
    }

    public String c() {
        return this.f484e;
    }

    public void c(boolean z) {
        this.f477a.set(2, z);
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m569c() {
        return this.f482c != null;
    }

    public hl d(String str) {
        this.f483d = str;
        return this;
    }

    public String d() {
        return this.f485f;
    }

    /* renamed from: d  reason: collision with other method in class */
    public boolean m570d() {
        return this.f477a.get(0);
    }

    public hl e(String str) {
        this.f484e = str;
        return this;
    }

    public String e() {
        return this.f486g;
    }

    /* renamed from: e  reason: collision with other method in class */
    public boolean m571e() {
        return this.f477a.get(1);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hl)) {
            return m567a((hl) obj);
        }
        return false;
    }

    public hl f(String str) {
        this.f485f = str;
        return this;
    }

    public boolean f() {
        return this.f477a.get(2);
    }

    public hl g(String str) {
        this.f486g = str;
        return this;
    }

    public boolean g() {
        return this.f483d != null;
    }

    public boolean h() {
        return this.f484e != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f485f != null;
    }

    public boolean j() {
        return this.f478a != null;
    }

    public boolean k() {
        return this.f486g != null;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("ClientUploadDataItem(");
        boolean z2 = false;
        if (m566a()) {
            sb.append("channel:");
            String str = this.f476a;
            if (str == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (m568b()) {
            if (!z) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            }
            sb.append(WebGLImageLoader.DATA_URL);
            String str2 = this.f481b;
            if (str2 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str2);
            }
            z = false;
        }
        if (m569c()) {
            if (!z) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            }
            sb.append("name:");
            String str3 = this.f482c;
            if (str3 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str3);
            }
            z = false;
        }
        if (m570d()) {
            if (!z) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            }
            sb.append("counter:");
            sb.append(this.f475a);
            z = false;
        }
        if (m571e()) {
            if (!z) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            }
            sb.append("timestamp:");
            sb.append(this.f480b);
            z = false;
        }
        if (f()) {
            if (!z) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            }
            sb.append("fromSdk:");
            sb.append(this.f479a);
            z = false;
        }
        if (g()) {
            if (!z) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            }
            sb.append("category:");
            String str4 = this.f483d;
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
            String str5 = this.f484e;
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
            String str6 = this.f485f;
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
            Map<String, String> map = this.f478a;
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
            String str7 = this.f486g;
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
