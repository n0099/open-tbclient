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
    public int f587a;

    /* renamed from: a  reason: collision with other field name */
    public long f588a;

    /* renamed from: a  reason: collision with other field name */
    public String f589a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f590a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f591a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f592a;

    /* renamed from: b  reason: collision with other field name */
    public int f593b;

    /* renamed from: b  reason: collision with other field name */
    public String f594b;

    /* renamed from: b  reason: collision with other field name */
    public Map<String, String> f595b;

    /* renamed from: c  reason: collision with other field name */
    public int f596c;

    /* renamed from: c  reason: collision with other field name */
    public String f597c;

    /* renamed from: c  reason: collision with other field name */
    public Map<String, String> f598c;

    /* renamed from: d  reason: collision with other field name */
    public String f599d;

    /* renamed from: e  reason: collision with other field name */
    public String f600e;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f586a = new jn("PushMetaInfo");

    /* renamed from: a  reason: collision with root package name */
    private static final jf f14416a = new jf("", Constants.GZIP_CAST_TYPE, 1);

    /* renamed from: b  reason: collision with root package name */
    private static final jf f14417b = new jf("", (byte) 10, 2);
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
        this.f590a = new BitSet(5);
        this.f592a = false;
    }

    public hz(hz hzVar) {
        this.f590a = new BitSet(5);
        this.f590a.clear();
        this.f590a.or(hzVar.f590a);
        if (hzVar.m410a()) {
            this.f589a = hzVar.f589a;
        }
        this.f588a = hzVar.f588a;
        if (hzVar.m416c()) {
            this.f594b = hzVar.f594b;
        }
        if (hzVar.m417d()) {
            this.f597c = hzVar.f597c;
        }
        if (hzVar.e()) {
            this.f599d = hzVar.f599d;
        }
        this.f587a = hzVar.f587a;
        if (hzVar.g()) {
            this.f600e = hzVar.f600e;
        }
        this.f593b = hzVar.f593b;
        this.f596c = hzVar.f596c;
        if (hzVar.j()) {
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, String> entry : hzVar.f591a.entrySet()) {
                hashMap.put(entry.getKey(), entry.getValue());
            }
            this.f591a = hashMap;
        }
        if (hzVar.k()) {
            HashMap hashMap2 = new HashMap();
            for (Map.Entry<String, String> entry2 : hzVar.f595b.entrySet()) {
                hashMap2.put(entry2.getKey(), entry2.getValue());
            }
            this.f595b = hashMap2;
        }
        this.f592a = hzVar.f592a;
        if (hzVar.n()) {
            HashMap hashMap3 = new HashMap();
            for (Map.Entry<String, String> entry3 : hzVar.f598c.entrySet()) {
                hashMap3.put(entry3.getKey(), entry3.getValue());
            }
            this.f598c = hashMap3;
        }
    }

    public int a() {
        return this.f587a;
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
            int compareTo = Boolean.valueOf(m410a()).compareTo(Boolean.valueOf(hzVar.m410a()));
            if (compareTo == 0) {
                if (!m410a() || (a14 = iy.a(this.f589a, hzVar.f589a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m414b()).compareTo(Boolean.valueOf(hzVar.m414b()));
                    if (compareTo2 == 0) {
                        if (!m414b() || (a13 = iy.a(this.f588a, hzVar.f588a)) == 0) {
                            int compareTo3 = Boolean.valueOf(m416c()).compareTo(Boolean.valueOf(hzVar.m416c()));
                            if (compareTo3 == 0) {
                                if (!m416c() || (a12 = iy.a(this.f594b, hzVar.f594b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(m417d()).compareTo(Boolean.valueOf(hzVar.m417d()));
                                    if (compareTo4 == 0) {
                                        if (!m417d() || (a11 = iy.a(this.f597c, hzVar.f597c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hzVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a10 = iy.a(this.f599d, hzVar.f599d)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hzVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a9 = iy.a(this.f587a, hzVar.f587a)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hzVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a8 = iy.a(this.f600e, hzVar.f600e)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hzVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a7 = iy.a(this.f593b, hzVar.f593b)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hzVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a6 = iy.a(this.f596c, hzVar.f596c)) == 0) {
                                                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(hzVar.j()));
                                                                                    if (compareTo10 == 0) {
                                                                                        if (!j() || (a5 = iy.a(this.f591a, hzVar.f591a)) == 0) {
                                                                                            int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(hzVar.k()));
                                                                                            if (compareTo11 == 0) {
                                                                                                if (!k() || (a4 = iy.a(this.f595b, hzVar.f595b)) == 0) {
                                                                                                    int compareTo12 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(hzVar.m()));
                                                                                                    if (compareTo12 == 0) {
                                                                                                        if (!m() || (a3 = iy.a(this.f592a, hzVar.f592a)) == 0) {
                                                                                                            int compareTo13 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(hzVar.n()));
                                                                                                            if (compareTo13 == 0) {
                                                                                                                if (!n() || (a2 = iy.a(this.f598c, hzVar.f598c)) == 0) {
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
    public long m405a() {
        return this.f588a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public hz m406a() {
        return new hz(this);
    }

    public hz a(int i2) {
        this.f587a = i2;
        b(true);
        return this;
    }

    public hz a(String str) {
        this.f589a = str;
        return this;
    }

    public hz a(Map<String, String> map) {
        this.f591a = map;
        return this;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m407a() {
        return this.f589a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public Map<String, String> m408a() {
        return this.f591a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m409a() {
        if (this.f589a == null) {
            throw new jj("Required field 'id' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m519a();
        while (true) {
            jf m515a = jiVar.m515a();
            if (m515a.f14471a == 0) {
                jiVar.f();
                if (!m414b()) {
                    throw new jj("Required field 'messageTs' was not found in serialized data! Struct: " + toString());
                }
                m409a();
                return;
            }
            switch (m515a.f858a) {
                case 1:
                    if (m515a.f14471a == 11) {
                        this.f589a = jiVar.m520a();
                        break;
                    } else {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    }
                case 2:
                    if (m515a.f14471a == 10) {
                        this.f588a = jiVar.m514a();
                        a(true);
                        break;
                    } else {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    }
                case 3:
                    if (m515a.f14471a == 11) {
                        this.f594b = jiVar.m520a();
                        break;
                    } else {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    }
                case 4:
                    if (m515a.f14471a == 11) {
                        this.f597c = jiVar.m520a();
                        break;
                    } else {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    }
                case 5:
                    if (m515a.f14471a == 11) {
                        this.f599d = jiVar.m520a();
                        break;
                    } else {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    }
                case 6:
                    if (m515a.f14471a == 8) {
                        this.f587a = jiVar.m513a();
                        b(true);
                        break;
                    } else {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    }
                case 7:
                    if (m515a.f14471a == 11) {
                        this.f600e = jiVar.m520a();
                        break;
                    } else {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    }
                case 8:
                    if (m515a.f14471a == 8) {
                        this.f593b = jiVar.m513a();
                        c(true);
                        break;
                    } else {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    }
                case 9:
                    if (m515a.f14471a == 8) {
                        this.f596c = jiVar.m513a();
                        d(true);
                        break;
                    } else {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    }
                case 10:
                    if (m515a.f14471a == 13) {
                        jh m517a = jiVar.m517a();
                        this.f591a = new HashMap(m517a.f860a * 2);
                        for (int i2 = 0; i2 < m517a.f860a; i2++) {
                            this.f591a.put(jiVar.m520a(), jiVar.m520a());
                        }
                        jiVar.h();
                        break;
                    } else {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    }
                case 11:
                    if (m515a.f14471a == 13) {
                        jh m517a2 = jiVar.m517a();
                        this.f595b = new HashMap(m517a2.f860a * 2);
                        for (int i3 = 0; i3 < m517a2.f860a; i3++) {
                            this.f595b.put(jiVar.m520a(), jiVar.m520a());
                        }
                        jiVar.h();
                        break;
                    } else {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    }
                case 12:
                    if (m515a.f14471a == 2) {
                        this.f592a = jiVar.m524a();
                        e(true);
                        break;
                    } else {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    }
                case 13:
                    if (m515a.f14471a == 13) {
                        jh m517a3 = jiVar.m517a();
                        this.f598c = new HashMap(m517a3.f860a * 2);
                        for (int i4 = 0; i4 < m517a3.f860a; i4++) {
                            this.f598c.put(jiVar.m520a(), jiVar.m520a());
                        }
                        jiVar.h();
                        break;
                    } else {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    }
                default:
                    jl.a(jiVar, m515a.f14471a);
                    break;
            }
            jiVar.g();
        }
    }

    public void a(String str, String str2) {
        if (this.f591a == null) {
            this.f591a = new HashMap();
        }
        this.f591a.put(str, str2);
    }

    public void a(boolean z) {
        this.f590a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m410a() {
        return this.f589a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m411a(hz hzVar) {
        if (hzVar == null) {
            return false;
        }
        boolean m410a = m410a();
        boolean m410a2 = hzVar.m410a();
        if (((m410a || m410a2) && !(m410a && m410a2 && this.f589a.equals(hzVar.f589a))) || this.f588a != hzVar.f588a) {
            return false;
        }
        boolean m416c = m416c();
        boolean m416c2 = hzVar.m416c();
        if ((m416c || m416c2) && !(m416c && m416c2 && this.f594b.equals(hzVar.f594b))) {
            return false;
        }
        boolean m417d = m417d();
        boolean m417d2 = hzVar.m417d();
        if ((m417d || m417d2) && !(m417d && m417d2 && this.f597c.equals(hzVar.f597c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = hzVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f599d.equals(hzVar.f599d))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = hzVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f587a == hzVar.f587a)) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = hzVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f600e.equals(hzVar.f600e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = hzVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f593b == hzVar.f593b)) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = hzVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f596c == hzVar.f596c)) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = hzVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f591a.equals(hzVar.f591a))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = hzVar.k();
        if ((k2 || k3) && !(k2 && k3 && this.f595b.equals(hzVar.f595b))) {
            return false;
        }
        boolean m2 = m();
        boolean m3 = hzVar.m();
        if ((m2 || m3) && !(m2 && m3 && this.f592a == hzVar.f592a)) {
            return false;
        }
        boolean n = n();
        boolean n2 = hzVar.n();
        return !(n || n2) || (n && n2 && this.f598c.equals(hzVar.f598c));
    }

    public int b() {
        return this.f593b;
    }

    public hz b(int i2) {
        this.f593b = i2;
        c(true);
        return this;
    }

    public hz b(String str) {
        this.f594b = str;
        return this;
    }

    /* renamed from: b  reason: collision with other method in class */
    public String m412b() {
        return this.f594b;
    }

    /* renamed from: b  reason: collision with other method in class */
    public Map<String, String> m413b() {
        return this.f595b;
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        m409a();
        jiVar.a(f586a);
        if (this.f589a != null) {
            jiVar.a(f14416a);
            jiVar.a(this.f589a);
            jiVar.b();
        }
        jiVar.a(f14417b);
        jiVar.a(this.f588a);
        jiVar.b();
        if (this.f594b != null && m416c()) {
            jiVar.a(c);
            jiVar.a(this.f594b);
            jiVar.b();
        }
        if (this.f597c != null && m417d()) {
            jiVar.a(d);
            jiVar.a(this.f597c);
            jiVar.b();
        }
        if (this.f599d != null && e()) {
            jiVar.a(e);
            jiVar.a(this.f599d);
            jiVar.b();
        }
        if (f()) {
            jiVar.a(f);
            jiVar.a(this.f587a);
            jiVar.b();
        }
        if (this.f600e != null && g()) {
            jiVar.a(g);
            jiVar.a(this.f600e);
            jiVar.b();
        }
        if (h()) {
            jiVar.a(h);
            jiVar.a(this.f593b);
            jiVar.b();
        }
        if (i()) {
            jiVar.a(i);
            jiVar.a(this.f596c);
            jiVar.b();
        }
        if (this.f591a != null && j()) {
            jiVar.a(j);
            jiVar.a(new jh(Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, this.f591a.size()));
            for (Map.Entry<String, String> entry : this.f591a.entrySet()) {
                jiVar.a(entry.getKey());
                jiVar.a(entry.getValue());
            }
            jiVar.d();
            jiVar.b();
        }
        if (this.f595b != null && k()) {
            jiVar.a(k);
            jiVar.a(new jh(Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, this.f595b.size()));
            for (Map.Entry<String, String> entry2 : this.f595b.entrySet()) {
                jiVar.a(entry2.getKey());
                jiVar.a(entry2.getValue());
            }
            jiVar.d();
            jiVar.b();
        }
        if (m()) {
            jiVar.a(l);
            jiVar.a(this.f592a);
            jiVar.b();
        }
        if (this.f598c != null && n()) {
            jiVar.a(m);
            jiVar.a(new jh(Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, this.f598c.size()));
            for (Map.Entry<String, String> entry3 : this.f598c.entrySet()) {
                jiVar.a(entry3.getKey());
                jiVar.a(entry3.getValue());
            }
            jiVar.d();
            jiVar.b();
        }
        jiVar.c();
        jiVar.m523a();
    }

    public void b(String str, String str2) {
        if (this.f595b == null) {
            this.f595b = new HashMap();
        }
        this.f595b.put(str, str2);
    }

    public void b(boolean z) {
        this.f590a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m414b() {
        return this.f590a.get(0);
    }

    public int c() {
        return this.f596c;
    }

    public hz c(int i2) {
        this.f596c = i2;
        d(true);
        return this;
    }

    public hz c(String str) {
        this.f597c = str;
        return this;
    }

    /* renamed from: c  reason: collision with other method in class */
    public String m415c() {
        return this.f597c;
    }

    public void c(boolean z) {
        this.f590a.set(2, z);
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m416c() {
        return this.f594b != null;
    }

    public hz d(String str) {
        this.f599d = str;
        return this;
    }

    public String d() {
        return this.f599d;
    }

    public void d(boolean z) {
        this.f590a.set(3, z);
    }

    /* renamed from: d  reason: collision with other method in class */
    public boolean m417d() {
        return this.f597c != null;
    }

    public void e(boolean z) {
        this.f590a.set(4, z);
    }

    public boolean e() {
        return this.f599d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hz)) {
            return m411a((hz) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f590a.get(1);
    }

    public boolean g() {
        return this.f600e != null;
    }

    public boolean h() {
        return this.f590a.get(2);
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f590a.get(3);
    }

    public boolean j() {
        return this.f591a != null;
    }

    public boolean k() {
        return this.f595b != null;
    }

    public boolean l() {
        return this.f592a;
    }

    public boolean m() {
        return this.f590a.get(4);
    }

    public boolean n() {
        return this.f598c != null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("PushMetaInfo(");
        sb.append("id:");
        if (this.f589a == null) {
            sb.append("null");
        } else {
            sb.append(this.f589a);
        }
        sb.append(", ");
        sb.append("messageTs:");
        sb.append(this.f588a);
        if (m416c()) {
            sb.append(", ");
            sb.append(UrlSchemaHelper.SCHEMA_TYPE_TOPIC);
            if (this.f594b == null) {
                sb.append("null");
            } else {
                sb.append(this.f594b);
            }
        }
        if (m417d()) {
            sb.append(", ");
            sb.append("title:");
            if (this.f597c == null) {
                sb.append("null");
            } else {
                sb.append(this.f597c);
            }
        }
        if (e()) {
            sb.append(", ");
            sb.append("description:");
            if (this.f599d == null) {
                sb.append("null");
            } else {
                sb.append(this.f599d);
            }
        }
        if (f()) {
            sb.append(", ");
            sb.append("notifyType:");
            sb.append(this.f587a);
        }
        if (g()) {
            sb.append(", ");
            sb.append("url:");
            if (this.f600e == null) {
                sb.append("null");
            } else {
                sb.append(this.f600e);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("passThrough:");
            sb.append(this.f593b);
        }
        if (i()) {
            sb.append(", ");
            sb.append("notifyId:");
            sb.append(this.f596c);
        }
        if (j()) {
            sb.append(", ");
            sb.append("extra:");
            if (this.f591a == null) {
                sb.append("null");
            } else {
                sb.append(this.f591a);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append(com.baidu.android.imsdk.retrieve.Constants.PATH_INTERNAL);
            if (this.f595b == null) {
                sb.append("null");
            } else {
                sb.append(this.f595b);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("ignoreRegInfo:");
            sb.append(this.f592a);
        }
        if (n()) {
            sb.append(", ");
            sb.append("apsProperFields:");
            if (this.f598c == null) {
                sb.append("null");
            } else {
                sb.append(this.f598c);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
