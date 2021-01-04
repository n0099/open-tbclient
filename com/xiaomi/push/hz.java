package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class hz implements ix<hz, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public int f586a;

    /* renamed from: a  reason: collision with other field name */
    public long f587a;

    /* renamed from: a  reason: collision with other field name */
    public String f588a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f589a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f590a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f591a;

    /* renamed from: b  reason: collision with other field name */
    public int f592b;

    /* renamed from: b  reason: collision with other field name */
    public String f593b;

    /* renamed from: b  reason: collision with other field name */
    public Map<String, String> f594b;

    /* renamed from: c  reason: collision with other field name */
    public int f595c;

    /* renamed from: c  reason: collision with other field name */
    public String f596c;

    /* renamed from: c  reason: collision with other field name */
    public Map<String, String> f597c;

    /* renamed from: d  reason: collision with other field name */
    public String f598d;

    /* renamed from: e  reason: collision with other field name */
    public String f599e;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f585a = new jn("PushMetaInfo");

    /* renamed from: a  reason: collision with root package name */
    private static final jf f14415a = new jf("", Constants.GZIP_CAST_TYPE, 1);

    /* renamed from: b  reason: collision with root package name */
    private static final jf f14416b = new jf("", (byte) 10, 2);
    private static final jf c = new jf("", Constants.GZIP_CAST_TYPE, 3);
    private static final jf d = new jf("", Constants.GZIP_CAST_TYPE, 4);
    private static final jf e = new jf("", Constants.GZIP_CAST_TYPE, 5);
    private static final jf f = new jf("", (byte) 8, 6);
    private static final jf g = new jf("", Constants.GZIP_CAST_TYPE, 7);
    private static final jf h = new jf("", (byte) 8, 8);
    private static final jf i = new jf("", (byte) 8, 9);
    private static final jf j = new jf("", (byte) 13, 10);
    private static final jf k = new jf("", (byte) 13, 11);
    private static final jf l = new jf("", (byte) 2, 12);
    private static final jf m = new jf("", (byte) 13, 13);

    public hz() {
        this.f589a = new BitSet(5);
        this.f591a = false;
    }

    public hz(hz hzVar) {
        this.f589a = new BitSet(5);
        this.f589a.clear();
        this.f589a.or(hzVar.f589a);
        if (hzVar.m399a()) {
            this.f588a = hzVar.f588a;
        }
        this.f587a = hzVar.f587a;
        if (hzVar.m405c()) {
            this.f593b = hzVar.f593b;
        }
        if (hzVar.m406d()) {
            this.f596c = hzVar.f596c;
        }
        if (hzVar.e()) {
            this.f598d = hzVar.f598d;
        }
        this.f586a = hzVar.f586a;
        if (hzVar.g()) {
            this.f599e = hzVar.f599e;
        }
        this.f592b = hzVar.f592b;
        this.f595c = hzVar.f595c;
        if (hzVar.j()) {
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, String> entry : hzVar.f590a.entrySet()) {
                hashMap.put(entry.getKey(), entry.getValue());
            }
            this.f590a = hashMap;
        }
        if (hzVar.k()) {
            HashMap hashMap2 = new HashMap();
            for (Map.Entry<String, String> entry2 : hzVar.f594b.entrySet()) {
                hashMap2.put(entry2.getKey(), entry2.getValue());
            }
            this.f594b = hashMap2;
        }
        this.f591a = hzVar.f591a;
        if (hzVar.n()) {
            HashMap hashMap3 = new HashMap();
            for (Map.Entry<String, String> entry3 : hzVar.f597c.entrySet()) {
                hashMap3.put(entry3.getKey(), entry3.getValue());
            }
            this.f597c = hashMap3;
        }
    }

    public int a() {
        return this.f586a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(hz hzVar) {
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
        int a13;
        int a14;
        if (getClass().equals(hzVar.getClass())) {
            int compareTo = Boolean.valueOf(m399a()).compareTo(Boolean.valueOf(hzVar.m399a()));
            if (compareTo == 0) {
                if (!m399a() || (a14 = iy.a(this.f588a, hzVar.f588a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m403b()).compareTo(Boolean.valueOf(hzVar.m403b()));
                    if (compareTo2 == 0) {
                        if (!m403b() || (a13 = iy.a(this.f587a, hzVar.f587a)) == 0) {
                            int compareTo3 = Boolean.valueOf(m405c()).compareTo(Boolean.valueOf(hzVar.m405c()));
                            if (compareTo3 == 0) {
                                if (!m405c() || (a12 = iy.a(this.f593b, hzVar.f593b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(m406d()).compareTo(Boolean.valueOf(hzVar.m406d()));
                                    if (compareTo4 == 0) {
                                        if (!m406d() || (a11 = iy.a(this.f596c, hzVar.f596c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hzVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a10 = iy.a(this.f598d, hzVar.f598d)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hzVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a9 = iy.a(this.f586a, hzVar.f586a)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hzVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a8 = iy.a(this.f599e, hzVar.f599e)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hzVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a7 = iy.a(this.f592b, hzVar.f592b)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hzVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a6 = iy.a(this.f595c, hzVar.f595c)) == 0) {
                                                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(hzVar.j()));
                                                                                    if (compareTo10 == 0) {
                                                                                        if (!j() || (a5 = iy.a(this.f590a, hzVar.f590a)) == 0) {
                                                                                            int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(hzVar.k()));
                                                                                            if (compareTo11 == 0) {
                                                                                                if (!k() || (a4 = iy.a(this.f594b, hzVar.f594b)) == 0) {
                                                                                                    int compareTo12 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(hzVar.m()));
                                                                                                    if (compareTo12 == 0) {
                                                                                                        if (!m() || (a3 = iy.a(this.f591a, hzVar.f591a)) == 0) {
                                                                                                            int compareTo13 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(hzVar.n()));
                                                                                                            if (compareTo13 == 0) {
                                                                                                                if (!n() || (a2 = iy.a(this.f597c, hzVar.f597c)) == 0) {
                                                                                                                    return 0;
                                                                                                                }
                                                                                                                return a2;
                                                                                                            }
                                                                                                            return compareTo13;
                                                                                                        }
                                                                                                        return a3;
                                                                                                    }
                                                                                                    return compareTo12;
                                                                                                }
                                                                                                return a4;
                                                                                            }
                                                                                            return compareTo11;
                                                                                        }
                                                                                        return a5;
                                                                                    }
                                                                                    return compareTo10;
                                                                                }
                                                                                return a6;
                                                                            }
                                                                            return compareTo9;
                                                                        }
                                                                        return a7;
                                                                    }
                                                                    return compareTo8;
                                                                }
                                                                return a8;
                                                            }
                                                            return compareTo7;
                                                        }
                                                        return a9;
                                                    }
                                                    return compareTo6;
                                                }
                                                return a10;
                                            }
                                            return compareTo5;
                                        }
                                        return a11;
                                    }
                                    return compareTo4;
                                }
                                return a12;
                            }
                            return compareTo3;
                        }
                        return a13;
                    }
                    return compareTo2;
                }
                return a14;
            }
            return compareTo;
        }
        return getClass().getName().compareTo(hzVar.getClass().getName());
    }

    /* renamed from: a  reason: collision with other method in class */
    public long m394a() {
        return this.f587a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public hz m395a() {
        return new hz(this);
    }

    public hz a(int i2) {
        this.f586a = i2;
        b(true);
        return this;
    }

    public hz a(String str) {
        this.f588a = str;
        return this;
    }

    public hz a(Map<String, String> map) {
        this.f590a = map;
        return this;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m396a() {
        return this.f588a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public Map<String, String> m397a() {
        return this.f590a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m398a() {
        if (this.f588a == null) {
            throw new jj("Required field 'id' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m508a();
        while (true) {
            jf m504a = jiVar.m504a();
            if (m504a.f14470a == 0) {
                jiVar.f();
                if (!m403b()) {
                    throw new jj("Required field 'messageTs' was not found in serialized data! Struct: " + toString());
                }
                m398a();
                return;
            }
            switch (m504a.f857a) {
                case 1:
                    if (m504a.f14470a == 11) {
                        this.f588a = jiVar.m509a();
                        break;
                    } else {
                        jl.a(jiVar, m504a.f14470a);
                        break;
                    }
                case 2:
                    if (m504a.f14470a == 10) {
                        this.f587a = jiVar.m503a();
                        a(true);
                        break;
                    } else {
                        jl.a(jiVar, m504a.f14470a);
                        break;
                    }
                case 3:
                    if (m504a.f14470a == 11) {
                        this.f593b = jiVar.m509a();
                        break;
                    } else {
                        jl.a(jiVar, m504a.f14470a);
                        break;
                    }
                case 4:
                    if (m504a.f14470a == 11) {
                        this.f596c = jiVar.m509a();
                        break;
                    } else {
                        jl.a(jiVar, m504a.f14470a);
                        break;
                    }
                case 5:
                    if (m504a.f14470a == 11) {
                        this.f598d = jiVar.m509a();
                        break;
                    } else {
                        jl.a(jiVar, m504a.f14470a);
                        break;
                    }
                case 6:
                    if (m504a.f14470a == 8) {
                        this.f586a = jiVar.m502a();
                        b(true);
                        break;
                    } else {
                        jl.a(jiVar, m504a.f14470a);
                        break;
                    }
                case 7:
                    if (m504a.f14470a == 11) {
                        this.f599e = jiVar.m509a();
                        break;
                    } else {
                        jl.a(jiVar, m504a.f14470a);
                        break;
                    }
                case 8:
                    if (m504a.f14470a == 8) {
                        this.f592b = jiVar.m502a();
                        c(true);
                        break;
                    } else {
                        jl.a(jiVar, m504a.f14470a);
                        break;
                    }
                case 9:
                    if (m504a.f14470a == 8) {
                        this.f595c = jiVar.m502a();
                        d(true);
                        break;
                    } else {
                        jl.a(jiVar, m504a.f14470a);
                        break;
                    }
                case 10:
                    if (m504a.f14470a == 13) {
                        jh m506a = jiVar.m506a();
                        this.f590a = new HashMap(m506a.f859a * 2);
                        for (int i2 = 0; i2 < m506a.f859a; i2++) {
                            this.f590a.put(jiVar.m509a(), jiVar.m509a());
                        }
                        jiVar.h();
                        break;
                    } else {
                        jl.a(jiVar, m504a.f14470a);
                        break;
                    }
                case 11:
                    if (m504a.f14470a == 13) {
                        jh m506a2 = jiVar.m506a();
                        this.f594b = new HashMap(m506a2.f859a * 2);
                        for (int i3 = 0; i3 < m506a2.f859a; i3++) {
                            this.f594b.put(jiVar.m509a(), jiVar.m509a());
                        }
                        jiVar.h();
                        break;
                    } else {
                        jl.a(jiVar, m504a.f14470a);
                        break;
                    }
                case 12:
                    if (m504a.f14470a == 2) {
                        this.f591a = jiVar.m513a();
                        e(true);
                        break;
                    } else {
                        jl.a(jiVar, m504a.f14470a);
                        break;
                    }
                case 13:
                    if (m504a.f14470a == 13) {
                        jh m506a3 = jiVar.m506a();
                        this.f597c = new HashMap(m506a3.f859a * 2);
                        for (int i4 = 0; i4 < m506a3.f859a; i4++) {
                            this.f597c.put(jiVar.m509a(), jiVar.m509a());
                        }
                        jiVar.h();
                        break;
                    } else {
                        jl.a(jiVar, m504a.f14470a);
                        break;
                    }
                default:
                    jl.a(jiVar, m504a.f14470a);
                    break;
            }
            jiVar.g();
        }
    }

    public void a(String str, String str2) {
        if (this.f590a == null) {
            this.f590a = new HashMap();
        }
        this.f590a.put(str, str2);
    }

    public void a(boolean z) {
        this.f589a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m399a() {
        return this.f588a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m400a(hz hzVar) {
        if (hzVar == null) {
            return false;
        }
        boolean m399a = m399a();
        boolean m399a2 = hzVar.m399a();
        if (((m399a || m399a2) && !(m399a && m399a2 && this.f588a.equals(hzVar.f588a))) || this.f587a != hzVar.f587a) {
            return false;
        }
        boolean m405c = m405c();
        boolean m405c2 = hzVar.m405c();
        if ((m405c || m405c2) && !(m405c && m405c2 && this.f593b.equals(hzVar.f593b))) {
            return false;
        }
        boolean m406d = m406d();
        boolean m406d2 = hzVar.m406d();
        if ((m406d || m406d2) && !(m406d && m406d2 && this.f596c.equals(hzVar.f596c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = hzVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f598d.equals(hzVar.f598d))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = hzVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f586a == hzVar.f586a)) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = hzVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f599e.equals(hzVar.f599e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = hzVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f592b == hzVar.f592b)) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = hzVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f595c == hzVar.f595c)) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = hzVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f590a.equals(hzVar.f590a))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = hzVar.k();
        if ((k2 || k3) && !(k2 && k3 && this.f594b.equals(hzVar.f594b))) {
            return false;
        }
        boolean m2 = m();
        boolean m3 = hzVar.m();
        if ((m2 || m3) && !(m2 && m3 && this.f591a == hzVar.f591a)) {
            return false;
        }
        boolean n = n();
        boolean n2 = hzVar.n();
        return !(n || n2) || (n && n2 && this.f597c.equals(hzVar.f597c));
    }

    public int b() {
        return this.f592b;
    }

    public hz b(int i2) {
        this.f592b = i2;
        c(true);
        return this;
    }

    public hz b(String str) {
        this.f593b = str;
        return this;
    }

    /* renamed from: b  reason: collision with other method in class */
    public String m401b() {
        return this.f593b;
    }

    /* renamed from: b  reason: collision with other method in class */
    public Map<String, String> m402b() {
        return this.f594b;
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        m398a();
        jiVar.a(f585a);
        if (this.f588a != null) {
            jiVar.a(f14415a);
            jiVar.a(this.f588a);
            jiVar.b();
        }
        jiVar.a(f14416b);
        jiVar.a(this.f587a);
        jiVar.b();
        if (this.f593b != null && m405c()) {
            jiVar.a(c);
            jiVar.a(this.f593b);
            jiVar.b();
        }
        if (this.f596c != null && m406d()) {
            jiVar.a(d);
            jiVar.a(this.f596c);
            jiVar.b();
        }
        if (this.f598d != null && e()) {
            jiVar.a(e);
            jiVar.a(this.f598d);
            jiVar.b();
        }
        if (f()) {
            jiVar.a(f);
            jiVar.a(this.f586a);
            jiVar.b();
        }
        if (this.f599e != null && g()) {
            jiVar.a(g);
            jiVar.a(this.f599e);
            jiVar.b();
        }
        if (h()) {
            jiVar.a(h);
            jiVar.a(this.f592b);
            jiVar.b();
        }
        if (i()) {
            jiVar.a(i);
            jiVar.a(this.f595c);
            jiVar.b();
        }
        if (this.f590a != null && j()) {
            jiVar.a(j);
            jiVar.a(new jh(Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, this.f590a.size()));
            for (Map.Entry<String, String> entry : this.f590a.entrySet()) {
                jiVar.a(entry.getKey());
                jiVar.a(entry.getValue());
            }
            jiVar.d();
            jiVar.b();
        }
        if (this.f594b != null && k()) {
            jiVar.a(k);
            jiVar.a(new jh(Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, this.f594b.size()));
            for (Map.Entry<String, String> entry2 : this.f594b.entrySet()) {
                jiVar.a(entry2.getKey());
                jiVar.a(entry2.getValue());
            }
            jiVar.d();
            jiVar.b();
        }
        if (m()) {
            jiVar.a(l);
            jiVar.a(this.f591a);
            jiVar.b();
        }
        if (this.f597c != null && n()) {
            jiVar.a(m);
            jiVar.a(new jh(Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, this.f597c.size()));
            for (Map.Entry<String, String> entry3 : this.f597c.entrySet()) {
                jiVar.a(entry3.getKey());
                jiVar.a(entry3.getValue());
            }
            jiVar.d();
            jiVar.b();
        }
        jiVar.c();
        jiVar.m512a();
    }

    public void b(String str, String str2) {
        if (this.f594b == null) {
            this.f594b = new HashMap();
        }
        this.f594b.put(str, str2);
    }

    public void b(boolean z) {
        this.f589a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m403b() {
        return this.f589a.get(0);
    }

    public int c() {
        return this.f595c;
    }

    public hz c(int i2) {
        this.f595c = i2;
        d(true);
        return this;
    }

    public hz c(String str) {
        this.f596c = str;
        return this;
    }

    /* renamed from: c  reason: collision with other method in class */
    public String m404c() {
        return this.f596c;
    }

    public void c(boolean z) {
        this.f589a.set(2, z);
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m405c() {
        return this.f593b != null;
    }

    public hz d(String str) {
        this.f598d = str;
        return this;
    }

    public String d() {
        return this.f598d;
    }

    public void d(boolean z) {
        this.f589a.set(3, z);
    }

    /* renamed from: d  reason: collision with other method in class */
    public boolean m406d() {
        return this.f596c != null;
    }

    public void e(boolean z) {
        this.f589a.set(4, z);
    }

    public boolean e() {
        return this.f598d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hz)) {
            return m400a((hz) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f589a.get(1);
    }

    public boolean g() {
        return this.f599e != null;
    }

    public boolean h() {
        return this.f589a.get(2);
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f589a.get(3);
    }

    public boolean j() {
        return this.f590a != null;
    }

    public boolean k() {
        return this.f594b != null;
    }

    public boolean l() {
        return this.f591a;
    }

    public boolean m() {
        return this.f589a.get(4);
    }

    public boolean n() {
        return this.f597c != null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("PushMetaInfo(");
        sb.append("id:");
        if (this.f588a == null) {
            sb.append("null");
        } else {
            sb.append(this.f588a);
        }
        sb.append(", ");
        sb.append("messageTs:");
        sb.append(this.f587a);
        if (m405c()) {
            sb.append(", ");
            sb.append(UrlSchemaHelper.SCHEMA_TYPE_TOPIC);
            if (this.f593b == null) {
                sb.append("null");
            } else {
                sb.append(this.f593b);
            }
        }
        if (m406d()) {
            sb.append(", ");
            sb.append("title:");
            if (this.f596c == null) {
                sb.append("null");
            } else {
                sb.append(this.f596c);
            }
        }
        if (e()) {
            sb.append(", ");
            sb.append("description:");
            if (this.f598d == null) {
                sb.append("null");
            } else {
                sb.append(this.f598d);
            }
        }
        if (f()) {
            sb.append(", ");
            sb.append("notifyType:");
            sb.append(this.f586a);
        }
        if (g()) {
            sb.append(", ");
            sb.append("url:");
            if (this.f599e == null) {
                sb.append("null");
            } else {
                sb.append(this.f599e);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("passThrough:");
            sb.append(this.f592b);
        }
        if (i()) {
            sb.append(", ");
            sb.append("notifyId:");
            sb.append(this.f595c);
        }
        if (j()) {
            sb.append(", ");
            sb.append("extra:");
            if (this.f590a == null) {
                sb.append("null");
            } else {
                sb.append(this.f590a);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append(com.baidu.android.imsdk.retrieve.Constants.PATH_INTERNAL);
            if (this.f594b == null) {
                sb.append("null");
            } else {
                sb.append(this.f594b);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("ignoreRegInfo:");
            sb.append(this.f591a);
        }
        if (n()) {
            sb.append(", ");
            sb.append("apsProperFields:");
            if (this.f597c == null) {
                sb.append("null");
            } else {
                sb.append(this.f597c);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
