package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes8.dex */
public class hz implements ix<hz, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public int f512a;

    /* renamed from: a  reason: collision with other field name */
    public long f513a;

    /* renamed from: a  reason: collision with other field name */
    public String f514a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f515a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f516a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f517a;

    /* renamed from: b  reason: collision with other field name */
    public int f518b;

    /* renamed from: b  reason: collision with other field name */
    public String f519b;

    /* renamed from: b  reason: collision with other field name */
    public Map<String, String> f520b;

    /* renamed from: c  reason: collision with other field name */
    public int f521c;

    /* renamed from: c  reason: collision with other field name */
    public String f522c;

    /* renamed from: c  reason: collision with other field name */
    public Map<String, String> f523c;

    /* renamed from: d  reason: collision with other field name */
    public String f524d;

    /* renamed from: e  reason: collision with other field name */
    public String f525e;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f511a = new jn("PushMetaInfo");
    private static final jf a = new jf("", Constants.GZIP_CAST_TYPE, 1);
    private static final jf b = new jf("", (byte) 10, 2);
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
        this.f515a = new BitSet(5);
        this.f517a = false;
    }

    public hz(hz hzVar) {
        this.f515a = new BitSet(5);
        this.f515a.clear();
        this.f515a.or(hzVar.f515a);
        if (hzVar.m374a()) {
            this.f514a = hzVar.f514a;
        }
        this.f513a = hzVar.f513a;
        if (hzVar.m380c()) {
            this.f519b = hzVar.f519b;
        }
        if (hzVar.m381d()) {
            this.f522c = hzVar.f522c;
        }
        if (hzVar.e()) {
            this.f524d = hzVar.f524d;
        }
        this.f512a = hzVar.f512a;
        if (hzVar.g()) {
            this.f525e = hzVar.f525e;
        }
        this.f518b = hzVar.f518b;
        this.f521c = hzVar.f521c;
        if (hzVar.j()) {
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, String> entry : hzVar.f516a.entrySet()) {
                hashMap.put(entry.getKey(), entry.getValue());
            }
            this.f516a = hashMap;
        }
        if (hzVar.k()) {
            HashMap hashMap2 = new HashMap();
            for (Map.Entry<String, String> entry2 : hzVar.f520b.entrySet()) {
                hashMap2.put(entry2.getKey(), entry2.getValue());
            }
            this.f520b = hashMap2;
        }
        this.f517a = hzVar.f517a;
        if (hzVar.n()) {
            HashMap hashMap3 = new HashMap();
            for (Map.Entry<String, String> entry3 : hzVar.f523c.entrySet()) {
                hashMap3.put(entry3.getKey(), entry3.getValue());
            }
            this.f523c = hashMap3;
        }
    }

    public int a() {
        return this.f512a;
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
            int compareTo = Boolean.valueOf(m374a()).compareTo(Boolean.valueOf(hzVar.m374a()));
            if (compareTo == 0) {
                if (!m374a() || (a14 = iy.a(this.f514a, hzVar.f514a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m378b()).compareTo(Boolean.valueOf(hzVar.m378b()));
                    if (compareTo2 == 0) {
                        if (!m378b() || (a13 = iy.a(this.f513a, hzVar.f513a)) == 0) {
                            int compareTo3 = Boolean.valueOf(m380c()).compareTo(Boolean.valueOf(hzVar.m380c()));
                            if (compareTo3 == 0) {
                                if (!m380c() || (a12 = iy.a(this.f519b, hzVar.f519b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(m381d()).compareTo(Boolean.valueOf(hzVar.m381d()));
                                    if (compareTo4 == 0) {
                                        if (!m381d() || (a11 = iy.a(this.f522c, hzVar.f522c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hzVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a10 = iy.a(this.f524d, hzVar.f524d)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hzVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a9 = iy.a(this.f512a, hzVar.f512a)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hzVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a8 = iy.a(this.f525e, hzVar.f525e)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hzVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a7 = iy.a(this.f518b, hzVar.f518b)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hzVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a6 = iy.a(this.f521c, hzVar.f521c)) == 0) {
                                                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(hzVar.j()));
                                                                                    if (compareTo10 == 0) {
                                                                                        if (!j() || (a5 = iy.a(this.f516a, hzVar.f516a)) == 0) {
                                                                                            int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(hzVar.k()));
                                                                                            if (compareTo11 == 0) {
                                                                                                if (!k() || (a4 = iy.a(this.f520b, hzVar.f520b)) == 0) {
                                                                                                    int compareTo12 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(hzVar.m()));
                                                                                                    if (compareTo12 == 0) {
                                                                                                        if (!m() || (a3 = iy.a(this.f517a, hzVar.f517a)) == 0) {
                                                                                                            int compareTo13 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(hzVar.n()));
                                                                                                            if (compareTo13 == 0) {
                                                                                                                if (!n() || (a2 = iy.a(this.f523c, hzVar.f523c)) == 0) {
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
    public long m369a() {
        return this.f513a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public hz m370a() {
        return new hz(this);
    }

    public hz a(int i2) {
        this.f512a = i2;
        b(true);
        return this;
    }

    public hz a(String str) {
        this.f514a = str;
        return this;
    }

    public hz a(Map<String, String> map) {
        this.f516a = map;
        return this;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m371a() {
        return this.f514a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public Map<String, String> m372a() {
        return this.f516a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m373a() {
        if (this.f514a == null) {
            throw new jj("Required field 'id' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m483a();
        while (true) {
            jf m479a = jiVar.m479a();
            if (m479a.a == 0) {
                jiVar.f();
                if (!m378b()) {
                    throw new jj("Required field 'messageTs' was not found in serialized data! Struct: " + toString());
                }
                m373a();
                return;
            }
            switch (m479a.f783a) {
                case 1:
                    if (m479a.a == 11) {
                        this.f514a = jiVar.m484a();
                        break;
                    } else {
                        jl.a(jiVar, m479a.a);
                        break;
                    }
                case 2:
                    if (m479a.a == 10) {
                        this.f513a = jiVar.m478a();
                        a(true);
                        break;
                    } else {
                        jl.a(jiVar, m479a.a);
                        break;
                    }
                case 3:
                    if (m479a.a == 11) {
                        this.f519b = jiVar.m484a();
                        break;
                    } else {
                        jl.a(jiVar, m479a.a);
                        break;
                    }
                case 4:
                    if (m479a.a == 11) {
                        this.f522c = jiVar.m484a();
                        break;
                    } else {
                        jl.a(jiVar, m479a.a);
                        break;
                    }
                case 5:
                    if (m479a.a == 11) {
                        this.f524d = jiVar.m484a();
                        break;
                    } else {
                        jl.a(jiVar, m479a.a);
                        break;
                    }
                case 6:
                    if (m479a.a == 8) {
                        this.f512a = jiVar.m477a();
                        b(true);
                        break;
                    } else {
                        jl.a(jiVar, m479a.a);
                        break;
                    }
                case 7:
                    if (m479a.a == 11) {
                        this.f525e = jiVar.m484a();
                        break;
                    } else {
                        jl.a(jiVar, m479a.a);
                        break;
                    }
                case 8:
                    if (m479a.a == 8) {
                        this.f518b = jiVar.m477a();
                        c(true);
                        break;
                    } else {
                        jl.a(jiVar, m479a.a);
                        break;
                    }
                case 9:
                    if (m479a.a == 8) {
                        this.f521c = jiVar.m477a();
                        d(true);
                        break;
                    } else {
                        jl.a(jiVar, m479a.a);
                        break;
                    }
                case 10:
                    if (m479a.a == 13) {
                        jh m481a = jiVar.m481a();
                        this.f516a = new HashMap(m481a.f785a * 2);
                        for (int i2 = 0; i2 < m481a.f785a; i2++) {
                            this.f516a.put(jiVar.m484a(), jiVar.m484a());
                        }
                        jiVar.h();
                        break;
                    } else {
                        jl.a(jiVar, m479a.a);
                        break;
                    }
                case 11:
                    if (m479a.a == 13) {
                        jh m481a2 = jiVar.m481a();
                        this.f520b = new HashMap(m481a2.f785a * 2);
                        for (int i3 = 0; i3 < m481a2.f785a; i3++) {
                            this.f520b.put(jiVar.m484a(), jiVar.m484a());
                        }
                        jiVar.h();
                        break;
                    } else {
                        jl.a(jiVar, m479a.a);
                        break;
                    }
                case 12:
                    if (m479a.a == 2) {
                        this.f517a = jiVar.m488a();
                        e(true);
                        break;
                    } else {
                        jl.a(jiVar, m479a.a);
                        break;
                    }
                case 13:
                    if (m479a.a == 13) {
                        jh m481a3 = jiVar.m481a();
                        this.f523c = new HashMap(m481a3.f785a * 2);
                        for (int i4 = 0; i4 < m481a3.f785a; i4++) {
                            this.f523c.put(jiVar.m484a(), jiVar.m484a());
                        }
                        jiVar.h();
                        break;
                    } else {
                        jl.a(jiVar, m479a.a);
                        break;
                    }
                default:
                    jl.a(jiVar, m479a.a);
                    break;
            }
            jiVar.g();
        }
    }

    public void a(String str, String str2) {
        if (this.f516a == null) {
            this.f516a = new HashMap();
        }
        this.f516a.put(str, str2);
    }

    public void a(boolean z) {
        this.f515a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m374a() {
        return this.f514a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m375a(hz hzVar) {
        if (hzVar == null) {
            return false;
        }
        boolean m374a = m374a();
        boolean m374a2 = hzVar.m374a();
        if (((m374a || m374a2) && !(m374a && m374a2 && this.f514a.equals(hzVar.f514a))) || this.f513a != hzVar.f513a) {
            return false;
        }
        boolean m380c = m380c();
        boolean m380c2 = hzVar.m380c();
        if ((m380c || m380c2) && !(m380c && m380c2 && this.f519b.equals(hzVar.f519b))) {
            return false;
        }
        boolean m381d = m381d();
        boolean m381d2 = hzVar.m381d();
        if ((m381d || m381d2) && !(m381d && m381d2 && this.f522c.equals(hzVar.f522c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = hzVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f524d.equals(hzVar.f524d))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = hzVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f512a == hzVar.f512a)) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = hzVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f525e.equals(hzVar.f525e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = hzVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f518b == hzVar.f518b)) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = hzVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f521c == hzVar.f521c)) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = hzVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f516a.equals(hzVar.f516a))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = hzVar.k();
        if ((k2 || k3) && !(k2 && k3 && this.f520b.equals(hzVar.f520b))) {
            return false;
        }
        boolean m2 = m();
        boolean m3 = hzVar.m();
        if ((m2 || m3) && !(m2 && m3 && this.f517a == hzVar.f517a)) {
            return false;
        }
        boolean n = n();
        boolean n2 = hzVar.n();
        return !(n || n2) || (n && n2 && this.f523c.equals(hzVar.f523c));
    }

    public int b() {
        return this.f518b;
    }

    public hz b(int i2) {
        this.f518b = i2;
        c(true);
        return this;
    }

    public hz b(String str) {
        this.f519b = str;
        return this;
    }

    /* renamed from: b  reason: collision with other method in class */
    public String m376b() {
        return this.f519b;
    }

    /* renamed from: b  reason: collision with other method in class */
    public Map<String, String> m377b() {
        return this.f520b;
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        m373a();
        jiVar.a(f511a);
        if (this.f514a != null) {
            jiVar.a(a);
            jiVar.a(this.f514a);
            jiVar.b();
        }
        jiVar.a(b);
        jiVar.a(this.f513a);
        jiVar.b();
        if (this.f519b != null && m380c()) {
            jiVar.a(c);
            jiVar.a(this.f519b);
            jiVar.b();
        }
        if (this.f522c != null && m381d()) {
            jiVar.a(d);
            jiVar.a(this.f522c);
            jiVar.b();
        }
        if (this.f524d != null && e()) {
            jiVar.a(e);
            jiVar.a(this.f524d);
            jiVar.b();
        }
        if (f()) {
            jiVar.a(f);
            jiVar.a(this.f512a);
            jiVar.b();
        }
        if (this.f525e != null && g()) {
            jiVar.a(g);
            jiVar.a(this.f525e);
            jiVar.b();
        }
        if (h()) {
            jiVar.a(h);
            jiVar.a(this.f518b);
            jiVar.b();
        }
        if (i()) {
            jiVar.a(i);
            jiVar.a(this.f521c);
            jiVar.b();
        }
        if (this.f516a != null && j()) {
            jiVar.a(j);
            jiVar.a(new jh(Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, this.f516a.size()));
            for (Map.Entry<String, String> entry : this.f516a.entrySet()) {
                jiVar.a(entry.getKey());
                jiVar.a(entry.getValue());
            }
            jiVar.d();
            jiVar.b();
        }
        if (this.f520b != null && k()) {
            jiVar.a(k);
            jiVar.a(new jh(Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, this.f520b.size()));
            for (Map.Entry<String, String> entry2 : this.f520b.entrySet()) {
                jiVar.a(entry2.getKey());
                jiVar.a(entry2.getValue());
            }
            jiVar.d();
            jiVar.b();
        }
        if (m()) {
            jiVar.a(l);
            jiVar.a(this.f517a);
            jiVar.b();
        }
        if (this.f523c != null && n()) {
            jiVar.a(m);
            jiVar.a(new jh(Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, this.f523c.size()));
            for (Map.Entry<String, String> entry3 : this.f523c.entrySet()) {
                jiVar.a(entry3.getKey());
                jiVar.a(entry3.getValue());
            }
            jiVar.d();
            jiVar.b();
        }
        jiVar.c();
        jiVar.m487a();
    }

    public void b(String str, String str2) {
        if (this.f520b == null) {
            this.f520b = new HashMap();
        }
        this.f520b.put(str, str2);
    }

    public void b(boolean z) {
        this.f515a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m378b() {
        return this.f515a.get(0);
    }

    public int c() {
        return this.f521c;
    }

    public hz c(int i2) {
        this.f521c = i2;
        d(true);
        return this;
    }

    public hz c(String str) {
        this.f522c = str;
        return this;
    }

    /* renamed from: c  reason: collision with other method in class */
    public String m379c() {
        return this.f522c;
    }

    public void c(boolean z) {
        this.f515a.set(2, z);
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m380c() {
        return this.f519b != null;
    }

    public hz d(String str) {
        this.f524d = str;
        return this;
    }

    public String d() {
        return this.f524d;
    }

    public void d(boolean z) {
        this.f515a.set(3, z);
    }

    /* renamed from: d  reason: collision with other method in class */
    public boolean m381d() {
        return this.f522c != null;
    }

    public void e(boolean z) {
        this.f515a.set(4, z);
    }

    public boolean e() {
        return this.f524d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hz)) {
            return m375a((hz) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f515a.get(1);
    }

    public boolean g() {
        return this.f525e != null;
    }

    public boolean h() {
        return this.f515a.get(2);
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f515a.get(3);
    }

    public boolean j() {
        return this.f516a != null;
    }

    public boolean k() {
        return this.f520b != null;
    }

    public boolean l() {
        return this.f517a;
    }

    public boolean m() {
        return this.f515a.get(4);
    }

    public boolean n() {
        return this.f523c != null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("PushMetaInfo(");
        sb.append("id:");
        if (this.f514a == null) {
            sb.append("null");
        } else {
            sb.append(this.f514a);
        }
        sb.append(", ");
        sb.append("messageTs:");
        sb.append(this.f513a);
        if (m380c()) {
            sb.append(", ");
            sb.append(UrlSchemaHelper.SCHEMA_TYPE_TOPIC);
            if (this.f519b == null) {
                sb.append("null");
            } else {
                sb.append(this.f519b);
            }
        }
        if (m381d()) {
            sb.append(", ");
            sb.append("title:");
            if (this.f522c == null) {
                sb.append("null");
            } else {
                sb.append(this.f522c);
            }
        }
        if (e()) {
            sb.append(", ");
            sb.append("description:");
            if (this.f524d == null) {
                sb.append("null");
            } else {
                sb.append(this.f524d);
            }
        }
        if (f()) {
            sb.append(", ");
            sb.append("notifyType:");
            sb.append(this.f512a);
        }
        if (g()) {
            sb.append(", ");
            sb.append("url:");
            if (this.f525e == null) {
                sb.append("null");
            } else {
                sb.append(this.f525e);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("passThrough:");
            sb.append(this.f518b);
        }
        if (i()) {
            sb.append(", ");
            sb.append("notifyId:");
            sb.append(this.f521c);
        }
        if (j()) {
            sb.append(", ");
            sb.append("extra:");
            if (this.f516a == null) {
                sb.append("null");
            } else {
                sb.append(this.f516a);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("internal:");
            if (this.f520b == null) {
                sb.append("null");
            } else {
                sb.append(this.f520b);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("ignoreRegInfo:");
            sb.append(this.f517a);
        }
        if (n()) {
            sb.append(", ");
            sb.append("apsProperFields:");
            if (this.f523c == null) {
                sb.append("null");
            } else {
                sb.append(this.f523c);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
