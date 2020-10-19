package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes12.dex */
public class hz implements ix<hz, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public int f508a;

    /* renamed from: a  reason: collision with other field name */
    public long f509a;

    /* renamed from: a  reason: collision with other field name */
    public String f510a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f511a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f512a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f513a;

    /* renamed from: b  reason: collision with other field name */
    public int f514b;

    /* renamed from: b  reason: collision with other field name */
    public String f515b;

    /* renamed from: b  reason: collision with other field name */
    public Map<String, String> f516b;

    /* renamed from: c  reason: collision with other field name */
    public int f517c;

    /* renamed from: c  reason: collision with other field name */
    public String f518c;

    /* renamed from: c  reason: collision with other field name */
    public Map<String, String> f519c;

    /* renamed from: d  reason: collision with other field name */
    public String f520d;

    /* renamed from: e  reason: collision with other field name */
    public String f521e;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f507a = new jn("PushMetaInfo");

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
        this.f511a = new BitSet(5);
        this.f513a = false;
    }

    public hz(hz hzVar) {
        this.f511a = new BitSet(5);
        this.f511a.clear();
        this.f511a.or(hzVar.f511a);
        if (hzVar.m381a()) {
            this.f510a = hzVar.f510a;
        }
        this.f509a = hzVar.f509a;
        if (hzVar.m387c()) {
            this.f515b = hzVar.f515b;
        }
        if (hzVar.m388d()) {
            this.f518c = hzVar.f518c;
        }
        if (hzVar.e()) {
            this.f520d = hzVar.f520d;
        }
        this.f508a = hzVar.f508a;
        if (hzVar.g()) {
            this.f521e = hzVar.f521e;
        }
        this.f514b = hzVar.f514b;
        this.f517c = hzVar.f517c;
        if (hzVar.j()) {
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, String> entry : hzVar.f512a.entrySet()) {
                hashMap.put(entry.getKey(), entry.getValue());
            }
            this.f512a = hashMap;
        }
        if (hzVar.k()) {
            HashMap hashMap2 = new HashMap();
            for (Map.Entry<String, String> entry2 : hzVar.f516b.entrySet()) {
                hashMap2.put(entry2.getKey(), entry2.getValue());
            }
            this.f516b = hashMap2;
        }
        this.f513a = hzVar.f513a;
        if (hzVar.n()) {
            HashMap hashMap3 = new HashMap();
            for (Map.Entry<String, String> entry3 : hzVar.f519c.entrySet()) {
                hashMap3.put(entry3.getKey(), entry3.getValue());
            }
            this.f519c = hashMap3;
        }
    }

    public int a() {
        return this.f508a;
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
            int compareTo = Boolean.valueOf(m381a()).compareTo(Boolean.valueOf(hzVar.m381a()));
            if (compareTo == 0) {
                if (!m381a() || (a14 = iy.a(this.f510a, hzVar.f510a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m385b()).compareTo(Boolean.valueOf(hzVar.m385b()));
                    if (compareTo2 == 0) {
                        if (!m385b() || (a13 = iy.a(this.f509a, hzVar.f509a)) == 0) {
                            int compareTo3 = Boolean.valueOf(m387c()).compareTo(Boolean.valueOf(hzVar.m387c()));
                            if (compareTo3 == 0) {
                                if (!m387c() || (a12 = iy.a(this.f515b, hzVar.f515b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(m388d()).compareTo(Boolean.valueOf(hzVar.m388d()));
                                    if (compareTo4 == 0) {
                                        if (!m388d() || (a11 = iy.a(this.f518c, hzVar.f518c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hzVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a10 = iy.a(this.f520d, hzVar.f520d)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hzVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a9 = iy.a(this.f508a, hzVar.f508a)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hzVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a8 = iy.a(this.f521e, hzVar.f521e)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hzVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a7 = iy.a(this.f514b, hzVar.f514b)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hzVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a6 = iy.a(this.f517c, hzVar.f517c)) == 0) {
                                                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(hzVar.j()));
                                                                                    if (compareTo10 == 0) {
                                                                                        if (!j() || (a5 = iy.a(this.f512a, hzVar.f512a)) == 0) {
                                                                                            int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(hzVar.k()));
                                                                                            if (compareTo11 == 0) {
                                                                                                if (!k() || (a4 = iy.a(this.f516b, hzVar.f516b)) == 0) {
                                                                                                    int compareTo12 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(hzVar.m()));
                                                                                                    if (compareTo12 == 0) {
                                                                                                        if (!m() || (a3 = iy.a(this.f513a, hzVar.f513a)) == 0) {
                                                                                                            int compareTo13 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(hzVar.n()));
                                                                                                            if (compareTo13 == 0) {
                                                                                                                if (!n() || (a2 = iy.a(this.f519c, hzVar.f519c)) == 0) {
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
    public long m376a() {
        return this.f509a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public hz m377a() {
        return new hz(this);
    }

    public hz a(int i2) {
        this.f508a = i2;
        b(true);
        return this;
    }

    public hz a(String str) {
        this.f510a = str;
        return this;
    }

    public hz a(Map<String, String> map) {
        this.f512a = map;
        return this;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m378a() {
        return this.f510a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public Map<String, String> m379a() {
        return this.f512a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m380a() {
        if (this.f510a == null) {
            throw new jj("Required field 'id' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m490a();
        while (true) {
            jf m486a = jiVar.m486a();
            if (m486a.f5000a == 0) {
                jiVar.f();
                if (!m385b()) {
                    throw new jj("Required field 'messageTs' was not found in serialized data! Struct: " + toString());
                }
                m380a();
                return;
            }
            switch (m486a.f779a) {
                case 1:
                    if (m486a.f5000a == 11) {
                        this.f510a = jiVar.m491a();
                        break;
                    } else {
                        jl.a(jiVar, m486a.f5000a);
                        break;
                    }
                case 2:
                    if (m486a.f5000a == 10) {
                        this.f509a = jiVar.m485a();
                        a(true);
                        break;
                    } else {
                        jl.a(jiVar, m486a.f5000a);
                        break;
                    }
                case 3:
                    if (m486a.f5000a == 11) {
                        this.f515b = jiVar.m491a();
                        break;
                    } else {
                        jl.a(jiVar, m486a.f5000a);
                        break;
                    }
                case 4:
                    if (m486a.f5000a == 11) {
                        this.f518c = jiVar.m491a();
                        break;
                    } else {
                        jl.a(jiVar, m486a.f5000a);
                        break;
                    }
                case 5:
                    if (m486a.f5000a == 11) {
                        this.f520d = jiVar.m491a();
                        break;
                    } else {
                        jl.a(jiVar, m486a.f5000a);
                        break;
                    }
                case 6:
                    if (m486a.f5000a == 8) {
                        this.f508a = jiVar.m484a();
                        b(true);
                        break;
                    } else {
                        jl.a(jiVar, m486a.f5000a);
                        break;
                    }
                case 7:
                    if (m486a.f5000a == 11) {
                        this.f521e = jiVar.m491a();
                        break;
                    } else {
                        jl.a(jiVar, m486a.f5000a);
                        break;
                    }
                case 8:
                    if (m486a.f5000a == 8) {
                        this.f514b = jiVar.m484a();
                        c(true);
                        break;
                    } else {
                        jl.a(jiVar, m486a.f5000a);
                        break;
                    }
                case 9:
                    if (m486a.f5000a == 8) {
                        this.f517c = jiVar.m484a();
                        d(true);
                        break;
                    } else {
                        jl.a(jiVar, m486a.f5000a);
                        break;
                    }
                case 10:
                    if (m486a.f5000a == 13) {
                        jh m488a = jiVar.m488a();
                        this.f512a = new HashMap(m488a.f781a * 2);
                        for (int i2 = 0; i2 < m488a.f781a; i2++) {
                            this.f512a.put(jiVar.m491a(), jiVar.m491a());
                        }
                        jiVar.h();
                        break;
                    } else {
                        jl.a(jiVar, m486a.f5000a);
                        break;
                    }
                case 11:
                    if (m486a.f5000a == 13) {
                        jh m488a2 = jiVar.m488a();
                        this.f516b = new HashMap(m488a2.f781a * 2);
                        for (int i3 = 0; i3 < m488a2.f781a; i3++) {
                            this.f516b.put(jiVar.m491a(), jiVar.m491a());
                        }
                        jiVar.h();
                        break;
                    } else {
                        jl.a(jiVar, m486a.f5000a);
                        break;
                    }
                case 12:
                    if (m486a.f5000a == 2) {
                        this.f513a = jiVar.m495a();
                        e(true);
                        break;
                    } else {
                        jl.a(jiVar, m486a.f5000a);
                        break;
                    }
                case 13:
                    if (m486a.f5000a == 13) {
                        jh m488a3 = jiVar.m488a();
                        this.f519c = new HashMap(m488a3.f781a * 2);
                        for (int i4 = 0; i4 < m488a3.f781a; i4++) {
                            this.f519c.put(jiVar.m491a(), jiVar.m491a());
                        }
                        jiVar.h();
                        break;
                    } else {
                        jl.a(jiVar, m486a.f5000a);
                        break;
                    }
                default:
                    jl.a(jiVar, m486a.f5000a);
                    break;
            }
            jiVar.g();
        }
    }

    public void a(String str, String str2) {
        if (this.f512a == null) {
            this.f512a = new HashMap();
        }
        this.f512a.put(str, str2);
    }

    public void a(boolean z) {
        this.f511a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m381a() {
        return this.f510a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m382a(hz hzVar) {
        if (hzVar == null) {
            return false;
        }
        boolean m381a = m381a();
        boolean m381a2 = hzVar.m381a();
        if (((m381a || m381a2) && !(m381a && m381a2 && this.f510a.equals(hzVar.f510a))) || this.f509a != hzVar.f509a) {
            return false;
        }
        boolean m387c = m387c();
        boolean m387c2 = hzVar.m387c();
        if ((m387c || m387c2) && !(m387c && m387c2 && this.f515b.equals(hzVar.f515b))) {
            return false;
        }
        boolean m388d = m388d();
        boolean m388d2 = hzVar.m388d();
        if ((m388d || m388d2) && !(m388d && m388d2 && this.f518c.equals(hzVar.f518c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = hzVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f520d.equals(hzVar.f520d))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = hzVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f508a == hzVar.f508a)) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = hzVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f521e.equals(hzVar.f521e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = hzVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f514b == hzVar.f514b)) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = hzVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f517c == hzVar.f517c)) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = hzVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f512a.equals(hzVar.f512a))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = hzVar.k();
        if ((k2 || k3) && !(k2 && k3 && this.f516b.equals(hzVar.f516b))) {
            return false;
        }
        boolean m2 = m();
        boolean m3 = hzVar.m();
        if ((m2 || m3) && !(m2 && m3 && this.f513a == hzVar.f513a)) {
            return false;
        }
        boolean n = n();
        boolean n2 = hzVar.n();
        return !(n || n2) || (n && n2 && this.f519c.equals(hzVar.f519c));
    }

    public int b() {
        return this.f514b;
    }

    public hz b(int i2) {
        this.f514b = i2;
        c(true);
        return this;
    }

    public hz b(String str) {
        this.f515b = str;
        return this;
    }

    /* renamed from: b  reason: collision with other method in class */
    public String m383b() {
        return this.f515b;
    }

    /* renamed from: b  reason: collision with other method in class */
    public Map<String, String> m384b() {
        return this.f516b;
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        m380a();
        jiVar.a(f507a);
        if (this.f510a != null) {
            jiVar.a(f4968a);
            jiVar.a(this.f510a);
            jiVar.b();
        }
        jiVar.a(b);
        jiVar.a(this.f509a);
        jiVar.b();
        if (this.f515b != null && m387c()) {
            jiVar.a(c);
            jiVar.a(this.f515b);
            jiVar.b();
        }
        if (this.f518c != null && m388d()) {
            jiVar.a(d);
            jiVar.a(this.f518c);
            jiVar.b();
        }
        if (this.f520d != null && e()) {
            jiVar.a(e);
            jiVar.a(this.f520d);
            jiVar.b();
        }
        if (f()) {
            jiVar.a(f);
            jiVar.a(this.f508a);
            jiVar.b();
        }
        if (this.f521e != null && g()) {
            jiVar.a(g);
            jiVar.a(this.f521e);
            jiVar.b();
        }
        if (h()) {
            jiVar.a(h);
            jiVar.a(this.f514b);
            jiVar.b();
        }
        if (i()) {
            jiVar.a(i);
            jiVar.a(this.f517c);
            jiVar.b();
        }
        if (this.f512a != null && j()) {
            jiVar.a(j);
            jiVar.a(new jh(Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, this.f512a.size()));
            for (Map.Entry<String, String> entry : this.f512a.entrySet()) {
                jiVar.a(entry.getKey());
                jiVar.a(entry.getValue());
            }
            jiVar.d();
            jiVar.b();
        }
        if (this.f516b != null && k()) {
            jiVar.a(k);
            jiVar.a(new jh(Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, this.f516b.size()));
            for (Map.Entry<String, String> entry2 : this.f516b.entrySet()) {
                jiVar.a(entry2.getKey());
                jiVar.a(entry2.getValue());
            }
            jiVar.d();
            jiVar.b();
        }
        if (m()) {
            jiVar.a(l);
            jiVar.a(this.f513a);
            jiVar.b();
        }
        if (this.f519c != null && n()) {
            jiVar.a(m);
            jiVar.a(new jh(Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, this.f519c.size()));
            for (Map.Entry<String, String> entry3 : this.f519c.entrySet()) {
                jiVar.a(entry3.getKey());
                jiVar.a(entry3.getValue());
            }
            jiVar.d();
            jiVar.b();
        }
        jiVar.c();
        jiVar.m494a();
    }

    public void b(String str, String str2) {
        if (this.f516b == null) {
            this.f516b = new HashMap();
        }
        this.f516b.put(str, str2);
    }

    public void b(boolean z) {
        this.f511a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m385b() {
        return this.f511a.get(0);
    }

    public int c() {
        return this.f517c;
    }

    public hz c(int i2) {
        this.f517c = i2;
        d(true);
        return this;
    }

    public hz c(String str) {
        this.f518c = str;
        return this;
    }

    /* renamed from: c  reason: collision with other method in class */
    public String m386c() {
        return this.f518c;
    }

    public void c(boolean z) {
        this.f511a.set(2, z);
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m387c() {
        return this.f515b != null;
    }

    public hz d(String str) {
        this.f520d = str;
        return this;
    }

    public String d() {
        return this.f520d;
    }

    public void d(boolean z) {
        this.f511a.set(3, z);
    }

    /* renamed from: d  reason: collision with other method in class */
    public boolean m388d() {
        return this.f518c != null;
    }

    public void e(boolean z) {
        this.f511a.set(4, z);
    }

    public boolean e() {
        return this.f520d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hz)) {
            return m382a((hz) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f511a.get(1);
    }

    public boolean g() {
        return this.f521e != null;
    }

    public boolean h() {
        return this.f511a.get(2);
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f511a.get(3);
    }

    public boolean j() {
        return this.f512a != null;
    }

    public boolean k() {
        return this.f516b != null;
    }

    public boolean l() {
        return this.f513a;
    }

    public boolean m() {
        return this.f511a.get(4);
    }

    public boolean n() {
        return this.f519c != null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("PushMetaInfo(");
        sb.append("id:");
        if (this.f510a == null) {
            sb.append("null");
        } else {
            sb.append(this.f510a);
        }
        sb.append(", ");
        sb.append("messageTs:");
        sb.append(this.f509a);
        if (m387c()) {
            sb.append(", ");
            sb.append(UrlSchemaHelper.SCHEMA_TYPE_TOPIC);
            if (this.f515b == null) {
                sb.append("null");
            } else {
                sb.append(this.f515b);
            }
        }
        if (m388d()) {
            sb.append(", ");
            sb.append("title:");
            if (this.f518c == null) {
                sb.append("null");
            } else {
                sb.append(this.f518c);
            }
        }
        if (e()) {
            sb.append(", ");
            sb.append("description:");
            if (this.f520d == null) {
                sb.append("null");
            } else {
                sb.append(this.f520d);
            }
        }
        if (f()) {
            sb.append(", ");
            sb.append("notifyType:");
            sb.append(this.f508a);
        }
        if (g()) {
            sb.append(", ");
            sb.append("url:");
            if (this.f521e == null) {
                sb.append("null");
            } else {
                sb.append(this.f521e);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("passThrough:");
            sb.append(this.f514b);
        }
        if (i()) {
            sb.append(", ");
            sb.append("notifyId:");
            sb.append(this.f517c);
        }
        if (j()) {
            sb.append(", ");
            sb.append("extra:");
            if (this.f512a == null) {
                sb.append("null");
            } else {
                sb.append(this.f512a);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("internal:");
            if (this.f516b == null) {
                sb.append("null");
            } else {
                sb.append(this.f516b);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("ignoreRegInfo:");
            sb.append(this.f513a);
        }
        if (n()) {
            sb.append(", ");
            sb.append("apsProperFields:");
            if (this.f519c == null) {
                sb.append("null");
            } else {
                sb.append(this.f519c);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
