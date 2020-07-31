package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes9.dex */
public class hz implements ix<hz, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public int f509a;

    /* renamed from: a  reason: collision with other field name */
    public long f510a;

    /* renamed from: a  reason: collision with other field name */
    public String f511a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f512a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f513a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f514a;

    /* renamed from: b  reason: collision with other field name */
    public int f515b;

    /* renamed from: b  reason: collision with other field name */
    public String f516b;

    /* renamed from: b  reason: collision with other field name */
    public Map<String, String> f517b;

    /* renamed from: c  reason: collision with other field name */
    public int f518c;

    /* renamed from: c  reason: collision with other field name */
    public String f519c;

    /* renamed from: c  reason: collision with other field name */
    public Map<String, String> f520c;

    /* renamed from: d  reason: collision with other field name */
    public String f521d;

    /* renamed from: e  reason: collision with other field name */
    public String f522e;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f508a = new jn("PushMetaInfo");
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
        this.f512a = new BitSet(5);
        this.f514a = false;
    }

    public hz(hz hzVar) {
        this.f512a = new BitSet(5);
        this.f512a.clear();
        this.f512a.or(hzVar.f512a);
        if (hzVar.m375a()) {
            this.f511a = hzVar.f511a;
        }
        this.f510a = hzVar.f510a;
        if (hzVar.m381c()) {
            this.f516b = hzVar.f516b;
        }
        if (hzVar.m382d()) {
            this.f519c = hzVar.f519c;
        }
        if (hzVar.e()) {
            this.f521d = hzVar.f521d;
        }
        this.f509a = hzVar.f509a;
        if (hzVar.g()) {
            this.f522e = hzVar.f522e;
        }
        this.f515b = hzVar.f515b;
        this.f518c = hzVar.f518c;
        if (hzVar.j()) {
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, String> entry : hzVar.f513a.entrySet()) {
                hashMap.put(entry.getKey(), entry.getValue());
            }
            this.f513a = hashMap;
        }
        if (hzVar.k()) {
            HashMap hashMap2 = new HashMap();
            for (Map.Entry<String, String> entry2 : hzVar.f517b.entrySet()) {
                hashMap2.put(entry2.getKey(), entry2.getValue());
            }
            this.f517b = hashMap2;
        }
        this.f514a = hzVar.f514a;
        if (hzVar.n()) {
            HashMap hashMap3 = new HashMap();
            for (Map.Entry<String, String> entry3 : hzVar.f520c.entrySet()) {
                hashMap3.put(entry3.getKey(), entry3.getValue());
            }
            this.f520c = hashMap3;
        }
    }

    public int a() {
        return this.f509a;
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
            int compareTo = Boolean.valueOf(m375a()).compareTo(Boolean.valueOf(hzVar.m375a()));
            if (compareTo == 0) {
                if (!m375a() || (a14 = iy.a(this.f511a, hzVar.f511a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m379b()).compareTo(Boolean.valueOf(hzVar.m379b()));
                    if (compareTo2 == 0) {
                        if (!m379b() || (a13 = iy.a(this.f510a, hzVar.f510a)) == 0) {
                            int compareTo3 = Boolean.valueOf(m381c()).compareTo(Boolean.valueOf(hzVar.m381c()));
                            if (compareTo3 == 0) {
                                if (!m381c() || (a12 = iy.a(this.f516b, hzVar.f516b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(m382d()).compareTo(Boolean.valueOf(hzVar.m382d()));
                                    if (compareTo4 == 0) {
                                        if (!m382d() || (a11 = iy.a(this.f519c, hzVar.f519c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hzVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a10 = iy.a(this.f521d, hzVar.f521d)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hzVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a9 = iy.a(this.f509a, hzVar.f509a)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hzVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a8 = iy.a(this.f522e, hzVar.f522e)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hzVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a7 = iy.a(this.f515b, hzVar.f515b)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hzVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a6 = iy.a(this.f518c, hzVar.f518c)) == 0) {
                                                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(hzVar.j()));
                                                                                    if (compareTo10 == 0) {
                                                                                        if (!j() || (a5 = iy.a(this.f513a, hzVar.f513a)) == 0) {
                                                                                            int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(hzVar.k()));
                                                                                            if (compareTo11 == 0) {
                                                                                                if (!k() || (a4 = iy.a(this.f517b, hzVar.f517b)) == 0) {
                                                                                                    int compareTo12 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(hzVar.m()));
                                                                                                    if (compareTo12 == 0) {
                                                                                                        if (!m() || (a3 = iy.a(this.f514a, hzVar.f514a)) == 0) {
                                                                                                            int compareTo13 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(hzVar.n()));
                                                                                                            if (compareTo13 == 0) {
                                                                                                                if (!n() || (a2 = iy.a(this.f520c, hzVar.f520c)) == 0) {
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
    public long m370a() {
        return this.f510a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public hz m371a() {
        return new hz(this);
    }

    public hz a(int i2) {
        this.f509a = i2;
        b(true);
        return this;
    }

    public hz a(String str) {
        this.f511a = str;
        return this;
    }

    public hz a(Map<String, String> map) {
        this.f513a = map;
        return this;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m372a() {
        return this.f511a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public Map<String, String> m373a() {
        return this.f513a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m374a() {
        if (this.f511a == null) {
            throw new jj("Required field 'id' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m484a();
        while (true) {
            jf m480a = jiVar.m480a();
            if (m480a.a == 0) {
                jiVar.f();
                if (!m379b()) {
                    throw new jj("Required field 'messageTs' was not found in serialized data! Struct: " + toString());
                }
                m374a();
                return;
            }
            switch (m480a.f780a) {
                case 1:
                    if (m480a.a == 11) {
                        this.f511a = jiVar.m485a();
                        break;
                    } else {
                        jl.a(jiVar, m480a.a);
                        break;
                    }
                case 2:
                    if (m480a.a == 10) {
                        this.f510a = jiVar.m479a();
                        a(true);
                        break;
                    } else {
                        jl.a(jiVar, m480a.a);
                        break;
                    }
                case 3:
                    if (m480a.a == 11) {
                        this.f516b = jiVar.m485a();
                        break;
                    } else {
                        jl.a(jiVar, m480a.a);
                        break;
                    }
                case 4:
                    if (m480a.a == 11) {
                        this.f519c = jiVar.m485a();
                        break;
                    } else {
                        jl.a(jiVar, m480a.a);
                        break;
                    }
                case 5:
                    if (m480a.a == 11) {
                        this.f521d = jiVar.m485a();
                        break;
                    } else {
                        jl.a(jiVar, m480a.a);
                        break;
                    }
                case 6:
                    if (m480a.a == 8) {
                        this.f509a = jiVar.m478a();
                        b(true);
                        break;
                    } else {
                        jl.a(jiVar, m480a.a);
                        break;
                    }
                case 7:
                    if (m480a.a == 11) {
                        this.f522e = jiVar.m485a();
                        break;
                    } else {
                        jl.a(jiVar, m480a.a);
                        break;
                    }
                case 8:
                    if (m480a.a == 8) {
                        this.f515b = jiVar.m478a();
                        c(true);
                        break;
                    } else {
                        jl.a(jiVar, m480a.a);
                        break;
                    }
                case 9:
                    if (m480a.a == 8) {
                        this.f518c = jiVar.m478a();
                        d(true);
                        break;
                    } else {
                        jl.a(jiVar, m480a.a);
                        break;
                    }
                case 10:
                    if (m480a.a == 13) {
                        jh m482a = jiVar.m482a();
                        this.f513a = new HashMap(m482a.f782a * 2);
                        for (int i2 = 0; i2 < m482a.f782a; i2++) {
                            this.f513a.put(jiVar.m485a(), jiVar.m485a());
                        }
                        jiVar.h();
                        break;
                    } else {
                        jl.a(jiVar, m480a.a);
                        break;
                    }
                case 11:
                    if (m480a.a == 13) {
                        jh m482a2 = jiVar.m482a();
                        this.f517b = new HashMap(m482a2.f782a * 2);
                        for (int i3 = 0; i3 < m482a2.f782a; i3++) {
                            this.f517b.put(jiVar.m485a(), jiVar.m485a());
                        }
                        jiVar.h();
                        break;
                    } else {
                        jl.a(jiVar, m480a.a);
                        break;
                    }
                case 12:
                    if (m480a.a == 2) {
                        this.f514a = jiVar.m489a();
                        e(true);
                        break;
                    } else {
                        jl.a(jiVar, m480a.a);
                        break;
                    }
                case 13:
                    if (m480a.a == 13) {
                        jh m482a3 = jiVar.m482a();
                        this.f520c = new HashMap(m482a3.f782a * 2);
                        for (int i4 = 0; i4 < m482a3.f782a; i4++) {
                            this.f520c.put(jiVar.m485a(), jiVar.m485a());
                        }
                        jiVar.h();
                        break;
                    } else {
                        jl.a(jiVar, m480a.a);
                        break;
                    }
                default:
                    jl.a(jiVar, m480a.a);
                    break;
            }
            jiVar.g();
        }
    }

    public void a(String str, String str2) {
        if (this.f513a == null) {
            this.f513a = new HashMap();
        }
        this.f513a.put(str, str2);
    }

    public void a(boolean z) {
        this.f512a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m375a() {
        return this.f511a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m376a(hz hzVar) {
        if (hzVar == null) {
            return false;
        }
        boolean m375a = m375a();
        boolean m375a2 = hzVar.m375a();
        if (((m375a || m375a2) && !(m375a && m375a2 && this.f511a.equals(hzVar.f511a))) || this.f510a != hzVar.f510a) {
            return false;
        }
        boolean m381c = m381c();
        boolean m381c2 = hzVar.m381c();
        if ((m381c || m381c2) && !(m381c && m381c2 && this.f516b.equals(hzVar.f516b))) {
            return false;
        }
        boolean m382d = m382d();
        boolean m382d2 = hzVar.m382d();
        if ((m382d || m382d2) && !(m382d && m382d2 && this.f519c.equals(hzVar.f519c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = hzVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f521d.equals(hzVar.f521d))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = hzVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f509a == hzVar.f509a)) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = hzVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f522e.equals(hzVar.f522e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = hzVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f515b == hzVar.f515b)) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = hzVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f518c == hzVar.f518c)) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = hzVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f513a.equals(hzVar.f513a))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = hzVar.k();
        if ((k2 || k3) && !(k2 && k3 && this.f517b.equals(hzVar.f517b))) {
            return false;
        }
        boolean m2 = m();
        boolean m3 = hzVar.m();
        if ((m2 || m3) && !(m2 && m3 && this.f514a == hzVar.f514a)) {
            return false;
        }
        boolean n = n();
        boolean n2 = hzVar.n();
        return !(n || n2) || (n && n2 && this.f520c.equals(hzVar.f520c));
    }

    public int b() {
        return this.f515b;
    }

    public hz b(int i2) {
        this.f515b = i2;
        c(true);
        return this;
    }

    public hz b(String str) {
        this.f516b = str;
        return this;
    }

    /* renamed from: b  reason: collision with other method in class */
    public String m377b() {
        return this.f516b;
    }

    /* renamed from: b  reason: collision with other method in class */
    public Map<String, String> m378b() {
        return this.f517b;
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        m374a();
        jiVar.a(f508a);
        if (this.f511a != null) {
            jiVar.a(a);
            jiVar.a(this.f511a);
            jiVar.b();
        }
        jiVar.a(b);
        jiVar.a(this.f510a);
        jiVar.b();
        if (this.f516b != null && m381c()) {
            jiVar.a(c);
            jiVar.a(this.f516b);
            jiVar.b();
        }
        if (this.f519c != null && m382d()) {
            jiVar.a(d);
            jiVar.a(this.f519c);
            jiVar.b();
        }
        if (this.f521d != null && e()) {
            jiVar.a(e);
            jiVar.a(this.f521d);
            jiVar.b();
        }
        if (f()) {
            jiVar.a(f);
            jiVar.a(this.f509a);
            jiVar.b();
        }
        if (this.f522e != null && g()) {
            jiVar.a(g);
            jiVar.a(this.f522e);
            jiVar.b();
        }
        if (h()) {
            jiVar.a(h);
            jiVar.a(this.f515b);
            jiVar.b();
        }
        if (i()) {
            jiVar.a(i);
            jiVar.a(this.f518c);
            jiVar.b();
        }
        if (this.f513a != null && j()) {
            jiVar.a(j);
            jiVar.a(new jh(Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, this.f513a.size()));
            for (Map.Entry<String, String> entry : this.f513a.entrySet()) {
                jiVar.a(entry.getKey());
                jiVar.a(entry.getValue());
            }
            jiVar.d();
            jiVar.b();
        }
        if (this.f517b != null && k()) {
            jiVar.a(k);
            jiVar.a(new jh(Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, this.f517b.size()));
            for (Map.Entry<String, String> entry2 : this.f517b.entrySet()) {
                jiVar.a(entry2.getKey());
                jiVar.a(entry2.getValue());
            }
            jiVar.d();
            jiVar.b();
        }
        if (m()) {
            jiVar.a(l);
            jiVar.a(this.f514a);
            jiVar.b();
        }
        if (this.f520c != null && n()) {
            jiVar.a(m);
            jiVar.a(new jh(Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, this.f520c.size()));
            for (Map.Entry<String, String> entry3 : this.f520c.entrySet()) {
                jiVar.a(entry3.getKey());
                jiVar.a(entry3.getValue());
            }
            jiVar.d();
            jiVar.b();
        }
        jiVar.c();
        jiVar.m488a();
    }

    public void b(String str, String str2) {
        if (this.f517b == null) {
            this.f517b = new HashMap();
        }
        this.f517b.put(str, str2);
    }

    public void b(boolean z) {
        this.f512a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m379b() {
        return this.f512a.get(0);
    }

    public int c() {
        return this.f518c;
    }

    public hz c(int i2) {
        this.f518c = i2;
        d(true);
        return this;
    }

    public hz c(String str) {
        this.f519c = str;
        return this;
    }

    /* renamed from: c  reason: collision with other method in class */
    public String m380c() {
        return this.f519c;
    }

    public void c(boolean z) {
        this.f512a.set(2, z);
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m381c() {
        return this.f516b != null;
    }

    public hz d(String str) {
        this.f521d = str;
        return this;
    }

    public String d() {
        return this.f521d;
    }

    public void d(boolean z) {
        this.f512a.set(3, z);
    }

    /* renamed from: d  reason: collision with other method in class */
    public boolean m382d() {
        return this.f519c != null;
    }

    public void e(boolean z) {
        this.f512a.set(4, z);
    }

    public boolean e() {
        return this.f521d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hz)) {
            return m376a((hz) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f512a.get(1);
    }

    public boolean g() {
        return this.f522e != null;
    }

    public boolean h() {
        return this.f512a.get(2);
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f512a.get(3);
    }

    public boolean j() {
        return this.f513a != null;
    }

    public boolean k() {
        return this.f517b != null;
    }

    public boolean l() {
        return this.f514a;
    }

    public boolean m() {
        return this.f512a.get(4);
    }

    public boolean n() {
        return this.f520c != null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("PushMetaInfo(");
        sb.append("id:");
        if (this.f511a == null) {
            sb.append("null");
        } else {
            sb.append(this.f511a);
        }
        sb.append(", ");
        sb.append("messageTs:");
        sb.append(this.f510a);
        if (m381c()) {
            sb.append(", ");
            sb.append(UrlSchemaHelper.SCHEMA_TYPE_TOPIC);
            if (this.f516b == null) {
                sb.append("null");
            } else {
                sb.append(this.f516b);
            }
        }
        if (m382d()) {
            sb.append(", ");
            sb.append("title:");
            if (this.f519c == null) {
                sb.append("null");
            } else {
                sb.append(this.f519c);
            }
        }
        if (e()) {
            sb.append(", ");
            sb.append("description:");
            if (this.f521d == null) {
                sb.append("null");
            } else {
                sb.append(this.f521d);
            }
        }
        if (f()) {
            sb.append(", ");
            sb.append("notifyType:");
            sb.append(this.f509a);
        }
        if (g()) {
            sb.append(", ");
            sb.append("url:");
            if (this.f522e == null) {
                sb.append("null");
            } else {
                sb.append(this.f522e);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("passThrough:");
            sb.append(this.f515b);
        }
        if (i()) {
            sb.append(", ");
            sb.append("notifyId:");
            sb.append(this.f518c);
        }
        if (j()) {
            sb.append(", ");
            sb.append("extra:");
            if (this.f513a == null) {
                sb.append("null");
            } else {
                sb.append(this.f513a);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("internal:");
            if (this.f517b == null) {
                sb.append("null");
            } else {
                sb.append(this.f517b);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("ignoreRegInfo:");
            sb.append(this.f514a);
        }
        if (n()) {
            sb.append(", ");
            sb.append("apsProperFields:");
            if (this.f520c == null) {
                sb.append("null");
            } else {
                sb.append(this.f520c);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
