package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes18.dex */
public class hz implements ix<hz, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public int f510a;

    /* renamed from: a  reason: collision with other field name */
    public long f511a;

    /* renamed from: a  reason: collision with other field name */
    public String f512a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f513a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f514a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f515a;

    /* renamed from: b  reason: collision with other field name */
    public int f516b;

    /* renamed from: b  reason: collision with other field name */
    public String f517b;

    /* renamed from: b  reason: collision with other field name */
    public Map<String, String> f518b;

    /* renamed from: c  reason: collision with other field name */
    public int f519c;

    /* renamed from: c  reason: collision with other field name */
    public String f520c;

    /* renamed from: c  reason: collision with other field name */
    public Map<String, String> f521c;

    /* renamed from: d  reason: collision with other field name */
    public String f522d;

    /* renamed from: e  reason: collision with other field name */
    public String f523e;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f509a = new jn("PushMetaInfo");

    /* renamed from: a  reason: collision with root package name */
    private static final jf f4968a = new jf("", Constants.GZIP_CAST_TYPE, 1);
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
        this.f513a = new BitSet(5);
        this.f515a = false;
    }

    public hz(hz hzVar) {
        this.f513a = new BitSet(5);
        this.f513a.clear();
        this.f513a.or(hzVar.f513a);
        if (hzVar.m383a()) {
            this.f512a = hzVar.f512a;
        }
        this.f511a = hzVar.f511a;
        if (hzVar.m389c()) {
            this.f517b = hzVar.f517b;
        }
        if (hzVar.m390d()) {
            this.f520c = hzVar.f520c;
        }
        if (hzVar.e()) {
            this.f522d = hzVar.f522d;
        }
        this.f510a = hzVar.f510a;
        if (hzVar.g()) {
            this.f523e = hzVar.f523e;
        }
        this.f516b = hzVar.f516b;
        this.f519c = hzVar.f519c;
        if (hzVar.j()) {
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, String> entry : hzVar.f514a.entrySet()) {
                hashMap.put(entry.getKey(), entry.getValue());
            }
            this.f514a = hashMap;
        }
        if (hzVar.k()) {
            HashMap hashMap2 = new HashMap();
            for (Map.Entry<String, String> entry2 : hzVar.f518b.entrySet()) {
                hashMap2.put(entry2.getKey(), entry2.getValue());
            }
            this.f518b = hashMap2;
        }
        this.f515a = hzVar.f515a;
        if (hzVar.n()) {
            HashMap hashMap3 = new HashMap();
            for (Map.Entry<String, String> entry3 : hzVar.f521c.entrySet()) {
                hashMap3.put(entry3.getKey(), entry3.getValue());
            }
            this.f521c = hashMap3;
        }
    }

    public int a() {
        return this.f510a;
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
            int compareTo = Boolean.valueOf(m383a()).compareTo(Boolean.valueOf(hzVar.m383a()));
            if (compareTo == 0) {
                if (!m383a() || (a14 = iy.a(this.f512a, hzVar.f512a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m387b()).compareTo(Boolean.valueOf(hzVar.m387b()));
                    if (compareTo2 == 0) {
                        if (!m387b() || (a13 = iy.a(this.f511a, hzVar.f511a)) == 0) {
                            int compareTo3 = Boolean.valueOf(m389c()).compareTo(Boolean.valueOf(hzVar.m389c()));
                            if (compareTo3 == 0) {
                                if (!m389c() || (a12 = iy.a(this.f517b, hzVar.f517b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(m390d()).compareTo(Boolean.valueOf(hzVar.m390d()));
                                    if (compareTo4 == 0) {
                                        if (!m390d() || (a11 = iy.a(this.f520c, hzVar.f520c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hzVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a10 = iy.a(this.f522d, hzVar.f522d)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hzVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a9 = iy.a(this.f510a, hzVar.f510a)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hzVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a8 = iy.a(this.f523e, hzVar.f523e)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hzVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a7 = iy.a(this.f516b, hzVar.f516b)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hzVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a6 = iy.a(this.f519c, hzVar.f519c)) == 0) {
                                                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(hzVar.j()));
                                                                                    if (compareTo10 == 0) {
                                                                                        if (!j() || (a5 = iy.a(this.f514a, hzVar.f514a)) == 0) {
                                                                                            int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(hzVar.k()));
                                                                                            if (compareTo11 == 0) {
                                                                                                if (!k() || (a4 = iy.a(this.f518b, hzVar.f518b)) == 0) {
                                                                                                    int compareTo12 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(hzVar.m()));
                                                                                                    if (compareTo12 == 0) {
                                                                                                        if (!m() || (a3 = iy.a(this.f515a, hzVar.f515a)) == 0) {
                                                                                                            int compareTo13 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(hzVar.n()));
                                                                                                            if (compareTo13 == 0) {
                                                                                                                if (!n() || (a2 = iy.a(this.f521c, hzVar.f521c)) == 0) {
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
    public long m378a() {
        return this.f511a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public hz m379a() {
        return new hz(this);
    }

    public hz a(int i2) {
        this.f510a = i2;
        b(true);
        return this;
    }

    public hz a(String str) {
        this.f512a = str;
        return this;
    }

    public hz a(Map<String, String> map) {
        this.f514a = map;
        return this;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m380a() {
        return this.f512a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public Map<String, String> m381a() {
        return this.f514a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m382a() {
        if (this.f512a == null) {
            throw new jj("Required field 'id' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m492a();
        while (true) {
            jf m488a = jiVar.m488a();
            if (m488a.f5000a == 0) {
                jiVar.f();
                if (!m387b()) {
                    throw new jj("Required field 'messageTs' was not found in serialized data! Struct: " + toString());
                }
                m382a();
                return;
            }
            switch (m488a.f781a) {
                case 1:
                    if (m488a.f5000a == 11) {
                        this.f512a = jiVar.m493a();
                        break;
                    } else {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    }
                case 2:
                    if (m488a.f5000a == 10) {
                        this.f511a = jiVar.m487a();
                        a(true);
                        break;
                    } else {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    }
                case 3:
                    if (m488a.f5000a == 11) {
                        this.f517b = jiVar.m493a();
                        break;
                    } else {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    }
                case 4:
                    if (m488a.f5000a == 11) {
                        this.f520c = jiVar.m493a();
                        break;
                    } else {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    }
                case 5:
                    if (m488a.f5000a == 11) {
                        this.f522d = jiVar.m493a();
                        break;
                    } else {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    }
                case 6:
                    if (m488a.f5000a == 8) {
                        this.f510a = jiVar.m486a();
                        b(true);
                        break;
                    } else {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    }
                case 7:
                    if (m488a.f5000a == 11) {
                        this.f523e = jiVar.m493a();
                        break;
                    } else {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    }
                case 8:
                    if (m488a.f5000a == 8) {
                        this.f516b = jiVar.m486a();
                        c(true);
                        break;
                    } else {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    }
                case 9:
                    if (m488a.f5000a == 8) {
                        this.f519c = jiVar.m486a();
                        d(true);
                        break;
                    } else {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    }
                case 10:
                    if (m488a.f5000a == 13) {
                        jh m490a = jiVar.m490a();
                        this.f514a = new HashMap(m490a.f783a * 2);
                        for (int i2 = 0; i2 < m490a.f783a; i2++) {
                            this.f514a.put(jiVar.m493a(), jiVar.m493a());
                        }
                        jiVar.h();
                        break;
                    } else {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    }
                case 11:
                    if (m488a.f5000a == 13) {
                        jh m490a2 = jiVar.m490a();
                        this.f518b = new HashMap(m490a2.f783a * 2);
                        for (int i3 = 0; i3 < m490a2.f783a; i3++) {
                            this.f518b.put(jiVar.m493a(), jiVar.m493a());
                        }
                        jiVar.h();
                        break;
                    } else {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    }
                case 12:
                    if (m488a.f5000a == 2) {
                        this.f515a = jiVar.m497a();
                        e(true);
                        break;
                    } else {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    }
                case 13:
                    if (m488a.f5000a == 13) {
                        jh m490a3 = jiVar.m490a();
                        this.f521c = new HashMap(m490a3.f783a * 2);
                        for (int i4 = 0; i4 < m490a3.f783a; i4++) {
                            this.f521c.put(jiVar.m493a(), jiVar.m493a());
                        }
                        jiVar.h();
                        break;
                    } else {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    }
                default:
                    jl.a(jiVar, m488a.f5000a);
                    break;
            }
            jiVar.g();
        }
    }

    public void a(String str, String str2) {
        if (this.f514a == null) {
            this.f514a = new HashMap();
        }
        this.f514a.put(str, str2);
    }

    public void a(boolean z) {
        this.f513a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m383a() {
        return this.f512a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m384a(hz hzVar) {
        if (hzVar == null) {
            return false;
        }
        boolean m383a = m383a();
        boolean m383a2 = hzVar.m383a();
        if (((m383a || m383a2) && !(m383a && m383a2 && this.f512a.equals(hzVar.f512a))) || this.f511a != hzVar.f511a) {
            return false;
        }
        boolean m389c = m389c();
        boolean m389c2 = hzVar.m389c();
        if ((m389c || m389c2) && !(m389c && m389c2 && this.f517b.equals(hzVar.f517b))) {
            return false;
        }
        boolean m390d = m390d();
        boolean m390d2 = hzVar.m390d();
        if ((m390d || m390d2) && !(m390d && m390d2 && this.f520c.equals(hzVar.f520c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = hzVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f522d.equals(hzVar.f522d))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = hzVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f510a == hzVar.f510a)) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = hzVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f523e.equals(hzVar.f523e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = hzVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f516b == hzVar.f516b)) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = hzVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f519c == hzVar.f519c)) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = hzVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f514a.equals(hzVar.f514a))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = hzVar.k();
        if ((k2 || k3) && !(k2 && k3 && this.f518b.equals(hzVar.f518b))) {
            return false;
        }
        boolean m2 = m();
        boolean m3 = hzVar.m();
        if ((m2 || m3) && !(m2 && m3 && this.f515a == hzVar.f515a)) {
            return false;
        }
        boolean n = n();
        boolean n2 = hzVar.n();
        return !(n || n2) || (n && n2 && this.f521c.equals(hzVar.f521c));
    }

    public int b() {
        return this.f516b;
    }

    public hz b(int i2) {
        this.f516b = i2;
        c(true);
        return this;
    }

    public hz b(String str) {
        this.f517b = str;
        return this;
    }

    /* renamed from: b  reason: collision with other method in class */
    public String m385b() {
        return this.f517b;
    }

    /* renamed from: b  reason: collision with other method in class */
    public Map<String, String> m386b() {
        return this.f518b;
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        m382a();
        jiVar.a(f509a);
        if (this.f512a != null) {
            jiVar.a(f4968a);
            jiVar.a(this.f512a);
            jiVar.b();
        }
        jiVar.a(b);
        jiVar.a(this.f511a);
        jiVar.b();
        if (this.f517b != null && m389c()) {
            jiVar.a(c);
            jiVar.a(this.f517b);
            jiVar.b();
        }
        if (this.f520c != null && m390d()) {
            jiVar.a(d);
            jiVar.a(this.f520c);
            jiVar.b();
        }
        if (this.f522d != null && e()) {
            jiVar.a(e);
            jiVar.a(this.f522d);
            jiVar.b();
        }
        if (f()) {
            jiVar.a(f);
            jiVar.a(this.f510a);
            jiVar.b();
        }
        if (this.f523e != null && g()) {
            jiVar.a(g);
            jiVar.a(this.f523e);
            jiVar.b();
        }
        if (h()) {
            jiVar.a(h);
            jiVar.a(this.f516b);
            jiVar.b();
        }
        if (i()) {
            jiVar.a(i);
            jiVar.a(this.f519c);
            jiVar.b();
        }
        if (this.f514a != null && j()) {
            jiVar.a(j);
            jiVar.a(new jh(Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, this.f514a.size()));
            for (Map.Entry<String, String> entry : this.f514a.entrySet()) {
                jiVar.a(entry.getKey());
                jiVar.a(entry.getValue());
            }
            jiVar.d();
            jiVar.b();
        }
        if (this.f518b != null && k()) {
            jiVar.a(k);
            jiVar.a(new jh(Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, this.f518b.size()));
            for (Map.Entry<String, String> entry2 : this.f518b.entrySet()) {
                jiVar.a(entry2.getKey());
                jiVar.a(entry2.getValue());
            }
            jiVar.d();
            jiVar.b();
        }
        if (m()) {
            jiVar.a(l);
            jiVar.a(this.f515a);
            jiVar.b();
        }
        if (this.f521c != null && n()) {
            jiVar.a(m);
            jiVar.a(new jh(Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, this.f521c.size()));
            for (Map.Entry<String, String> entry3 : this.f521c.entrySet()) {
                jiVar.a(entry3.getKey());
                jiVar.a(entry3.getValue());
            }
            jiVar.d();
            jiVar.b();
        }
        jiVar.c();
        jiVar.m496a();
    }

    public void b(String str, String str2) {
        if (this.f518b == null) {
            this.f518b = new HashMap();
        }
        this.f518b.put(str, str2);
    }

    public void b(boolean z) {
        this.f513a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m387b() {
        return this.f513a.get(0);
    }

    public int c() {
        return this.f519c;
    }

    public hz c(int i2) {
        this.f519c = i2;
        d(true);
        return this;
    }

    public hz c(String str) {
        this.f520c = str;
        return this;
    }

    /* renamed from: c  reason: collision with other method in class */
    public String m388c() {
        return this.f520c;
    }

    public void c(boolean z) {
        this.f513a.set(2, z);
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m389c() {
        return this.f517b != null;
    }

    public hz d(String str) {
        this.f522d = str;
        return this;
    }

    public String d() {
        return this.f522d;
    }

    public void d(boolean z) {
        this.f513a.set(3, z);
    }

    /* renamed from: d  reason: collision with other method in class */
    public boolean m390d() {
        return this.f520c != null;
    }

    public void e(boolean z) {
        this.f513a.set(4, z);
    }

    public boolean e() {
        return this.f522d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hz)) {
            return m384a((hz) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f513a.get(1);
    }

    public boolean g() {
        return this.f523e != null;
    }

    public boolean h() {
        return this.f513a.get(2);
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f513a.get(3);
    }

    public boolean j() {
        return this.f514a != null;
    }

    public boolean k() {
        return this.f518b != null;
    }

    public boolean l() {
        return this.f515a;
    }

    public boolean m() {
        return this.f513a.get(4);
    }

    public boolean n() {
        return this.f521c != null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("PushMetaInfo(");
        sb.append("id:");
        if (this.f512a == null) {
            sb.append("null");
        } else {
            sb.append(this.f512a);
        }
        sb.append(", ");
        sb.append("messageTs:");
        sb.append(this.f511a);
        if (m389c()) {
            sb.append(", ");
            sb.append(UrlSchemaHelper.SCHEMA_TYPE_TOPIC);
            if (this.f517b == null) {
                sb.append("null");
            } else {
                sb.append(this.f517b);
            }
        }
        if (m390d()) {
            sb.append(", ");
            sb.append("title:");
            if (this.f520c == null) {
                sb.append("null");
            } else {
                sb.append(this.f520c);
            }
        }
        if (e()) {
            sb.append(", ");
            sb.append("description:");
            if (this.f522d == null) {
                sb.append("null");
            } else {
                sb.append(this.f522d);
            }
        }
        if (f()) {
            sb.append(", ");
            sb.append("notifyType:");
            sb.append(this.f510a);
        }
        if (g()) {
            sb.append(", ");
            sb.append("url:");
            if (this.f523e == null) {
                sb.append("null");
            } else {
                sb.append(this.f523e);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("passThrough:");
            sb.append(this.f516b);
        }
        if (i()) {
            sb.append(", ");
            sb.append("notifyId:");
            sb.append(this.f519c);
        }
        if (j()) {
            sb.append(", ");
            sb.append("extra:");
            if (this.f514a == null) {
                sb.append("null");
            } else {
                sb.append(this.f514a);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("internal:");
            if (this.f518b == null) {
                sb.append("null");
            } else {
                sb.append(this.f518b);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("ignoreRegInfo:");
            sb.append(this.f515a);
        }
        if (n()) {
            sb.append(", ");
            sb.append("apsProperFields:");
            if (this.f521c == null) {
                sb.append("null");
            } else {
                sb.append(this.f521c);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
