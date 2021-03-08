package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public class hz implements ix<hz, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public int f507a;

    /* renamed from: a  reason: collision with other field name */
    public long f508a;

    /* renamed from: a  reason: collision with other field name */
    public String f509a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f510a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f511a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f512a;

    /* renamed from: b  reason: collision with other field name */
    public int f513b;

    /* renamed from: b  reason: collision with other field name */
    public String f514b;

    /* renamed from: b  reason: collision with other field name */
    public Map<String, String> f515b;

    /* renamed from: c  reason: collision with other field name */
    public int f516c;

    /* renamed from: c  reason: collision with other field name */
    public String f517c;

    /* renamed from: c  reason: collision with other field name */
    public Map<String, String> f518c;

    /* renamed from: d  reason: collision with other field name */
    public String f519d;

    /* renamed from: e  reason: collision with other field name */
    public String f520e;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f506a = new jn("PushMetaInfo");

    /* renamed from: a  reason: collision with root package name */
    private static final jf f8431a = new jf("", Constants.GZIP_CAST_TYPE, 1);
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
        this.f510a = new BitSet(5);
        this.f512a = false;
    }

    public hz(hz hzVar) {
        this.f510a = new BitSet(5);
        this.f510a.clear();
        this.f510a.or(hzVar.f510a);
        if (hzVar.m384a()) {
            this.f509a = hzVar.f509a;
        }
        this.f508a = hzVar.f508a;
        if (hzVar.m390c()) {
            this.f514b = hzVar.f514b;
        }
        if (hzVar.m391d()) {
            this.f517c = hzVar.f517c;
        }
        if (hzVar.e()) {
            this.f519d = hzVar.f519d;
        }
        this.f507a = hzVar.f507a;
        if (hzVar.g()) {
            this.f520e = hzVar.f520e;
        }
        this.f513b = hzVar.f513b;
        this.f516c = hzVar.f516c;
        if (hzVar.j()) {
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, String> entry : hzVar.f511a.entrySet()) {
                hashMap.put(entry.getKey(), entry.getValue());
            }
            this.f511a = hashMap;
        }
        if (hzVar.k()) {
            HashMap hashMap2 = new HashMap();
            for (Map.Entry<String, String> entry2 : hzVar.f515b.entrySet()) {
                hashMap2.put(entry2.getKey(), entry2.getValue());
            }
            this.f515b = hashMap2;
        }
        this.f512a = hzVar.f512a;
        if (hzVar.n()) {
            HashMap hashMap3 = new HashMap();
            for (Map.Entry<String, String> entry3 : hzVar.f518c.entrySet()) {
                hashMap3.put(entry3.getKey(), entry3.getValue());
            }
            this.f518c = hashMap3;
        }
    }

    public int a() {
        return this.f507a;
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
            int compareTo = Boolean.valueOf(m384a()).compareTo(Boolean.valueOf(hzVar.m384a()));
            if (compareTo == 0) {
                if (!m384a() || (a14 = iy.a(this.f509a, hzVar.f509a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m388b()).compareTo(Boolean.valueOf(hzVar.m388b()));
                    if (compareTo2 == 0) {
                        if (!m388b() || (a13 = iy.a(this.f508a, hzVar.f508a)) == 0) {
                            int compareTo3 = Boolean.valueOf(m390c()).compareTo(Boolean.valueOf(hzVar.m390c()));
                            if (compareTo3 == 0) {
                                if (!m390c() || (a12 = iy.a(this.f514b, hzVar.f514b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(m391d()).compareTo(Boolean.valueOf(hzVar.m391d()));
                                    if (compareTo4 == 0) {
                                        if (!m391d() || (a11 = iy.a(this.f517c, hzVar.f517c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hzVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a10 = iy.a(this.f519d, hzVar.f519d)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hzVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a9 = iy.a(this.f507a, hzVar.f507a)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hzVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a8 = iy.a(this.f520e, hzVar.f520e)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hzVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a7 = iy.a(this.f513b, hzVar.f513b)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hzVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a6 = iy.a(this.f516c, hzVar.f516c)) == 0) {
                                                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(hzVar.j()));
                                                                                    if (compareTo10 == 0) {
                                                                                        if (!j() || (a5 = iy.a(this.f511a, hzVar.f511a)) == 0) {
                                                                                            int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(hzVar.k()));
                                                                                            if (compareTo11 == 0) {
                                                                                                if (!k() || (a4 = iy.a(this.f515b, hzVar.f515b)) == 0) {
                                                                                                    int compareTo12 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(hzVar.m()));
                                                                                                    if (compareTo12 == 0) {
                                                                                                        if (!m() || (a3 = iy.a(this.f512a, hzVar.f512a)) == 0) {
                                                                                                            int compareTo13 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(hzVar.n()));
                                                                                                            if (compareTo13 == 0) {
                                                                                                                if (!n() || (a2 = iy.a(this.f518c, hzVar.f518c)) == 0) {
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
    public long m379a() {
        return this.f508a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public hz m380a() {
        return new hz(this);
    }

    public hz a(int i2) {
        this.f507a = i2;
        b(true);
        return this;
    }

    public hz a(String str) {
        this.f509a = str;
        return this;
    }

    public hz a(Map<String, String> map) {
        this.f511a = map;
        return this;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m381a() {
        return this.f509a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public Map<String, String> m382a() {
        return this.f511a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m383a() {
        if (this.f509a == null) {
            throw new jj("Required field 'id' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m493a();
        while (true) {
            jf m489a = jiVar.m489a();
            if (m489a.f8463a == 0) {
                jiVar.f();
                if (!m388b()) {
                    throw new jj("Required field 'messageTs' was not found in serialized data! Struct: " + toString());
                }
                m383a();
                return;
            }
            switch (m489a.f778a) {
                case 1:
                    if (m489a.f8463a == 11) {
                        this.f509a = jiVar.m494a();
                        break;
                    } else {
                        jl.a(jiVar, m489a.f8463a);
                        break;
                    }
                case 2:
                    if (m489a.f8463a == 10) {
                        this.f508a = jiVar.m488a();
                        a(true);
                        break;
                    } else {
                        jl.a(jiVar, m489a.f8463a);
                        break;
                    }
                case 3:
                    if (m489a.f8463a == 11) {
                        this.f514b = jiVar.m494a();
                        break;
                    } else {
                        jl.a(jiVar, m489a.f8463a);
                        break;
                    }
                case 4:
                    if (m489a.f8463a == 11) {
                        this.f517c = jiVar.m494a();
                        break;
                    } else {
                        jl.a(jiVar, m489a.f8463a);
                        break;
                    }
                case 5:
                    if (m489a.f8463a == 11) {
                        this.f519d = jiVar.m494a();
                        break;
                    } else {
                        jl.a(jiVar, m489a.f8463a);
                        break;
                    }
                case 6:
                    if (m489a.f8463a == 8) {
                        this.f507a = jiVar.m487a();
                        b(true);
                        break;
                    } else {
                        jl.a(jiVar, m489a.f8463a);
                        break;
                    }
                case 7:
                    if (m489a.f8463a == 11) {
                        this.f520e = jiVar.m494a();
                        break;
                    } else {
                        jl.a(jiVar, m489a.f8463a);
                        break;
                    }
                case 8:
                    if (m489a.f8463a == 8) {
                        this.f513b = jiVar.m487a();
                        c(true);
                        break;
                    } else {
                        jl.a(jiVar, m489a.f8463a);
                        break;
                    }
                case 9:
                    if (m489a.f8463a == 8) {
                        this.f516c = jiVar.m487a();
                        d(true);
                        break;
                    } else {
                        jl.a(jiVar, m489a.f8463a);
                        break;
                    }
                case 10:
                    if (m489a.f8463a == 13) {
                        jh m491a = jiVar.m491a();
                        this.f511a = new HashMap(m491a.f780a * 2);
                        for (int i2 = 0; i2 < m491a.f780a; i2++) {
                            this.f511a.put(jiVar.m494a(), jiVar.m494a());
                        }
                        jiVar.h();
                        break;
                    } else {
                        jl.a(jiVar, m489a.f8463a);
                        break;
                    }
                case 11:
                    if (m489a.f8463a == 13) {
                        jh m491a2 = jiVar.m491a();
                        this.f515b = new HashMap(m491a2.f780a * 2);
                        for (int i3 = 0; i3 < m491a2.f780a; i3++) {
                            this.f515b.put(jiVar.m494a(), jiVar.m494a());
                        }
                        jiVar.h();
                        break;
                    } else {
                        jl.a(jiVar, m489a.f8463a);
                        break;
                    }
                case 12:
                    if (m489a.f8463a == 2) {
                        this.f512a = jiVar.m498a();
                        e(true);
                        break;
                    } else {
                        jl.a(jiVar, m489a.f8463a);
                        break;
                    }
                case 13:
                    if (m489a.f8463a == 13) {
                        jh m491a3 = jiVar.m491a();
                        this.f518c = new HashMap(m491a3.f780a * 2);
                        for (int i4 = 0; i4 < m491a3.f780a; i4++) {
                            this.f518c.put(jiVar.m494a(), jiVar.m494a());
                        }
                        jiVar.h();
                        break;
                    } else {
                        jl.a(jiVar, m489a.f8463a);
                        break;
                    }
                default:
                    jl.a(jiVar, m489a.f8463a);
                    break;
            }
            jiVar.g();
        }
    }

    public void a(String str, String str2) {
        if (this.f511a == null) {
            this.f511a = new HashMap();
        }
        this.f511a.put(str, str2);
    }

    public void a(boolean z) {
        this.f510a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m384a() {
        return this.f509a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m385a(hz hzVar) {
        if (hzVar == null) {
            return false;
        }
        boolean m384a = m384a();
        boolean m384a2 = hzVar.m384a();
        if (((m384a || m384a2) && !(m384a && m384a2 && this.f509a.equals(hzVar.f509a))) || this.f508a != hzVar.f508a) {
            return false;
        }
        boolean m390c = m390c();
        boolean m390c2 = hzVar.m390c();
        if ((m390c || m390c2) && !(m390c && m390c2 && this.f514b.equals(hzVar.f514b))) {
            return false;
        }
        boolean m391d = m391d();
        boolean m391d2 = hzVar.m391d();
        if ((m391d || m391d2) && !(m391d && m391d2 && this.f517c.equals(hzVar.f517c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = hzVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f519d.equals(hzVar.f519d))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = hzVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f507a == hzVar.f507a)) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = hzVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f520e.equals(hzVar.f520e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = hzVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f513b == hzVar.f513b)) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = hzVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f516c == hzVar.f516c)) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = hzVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f511a.equals(hzVar.f511a))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = hzVar.k();
        if ((k2 || k3) && !(k2 && k3 && this.f515b.equals(hzVar.f515b))) {
            return false;
        }
        boolean m2 = m();
        boolean m3 = hzVar.m();
        if ((m2 || m3) && !(m2 && m3 && this.f512a == hzVar.f512a)) {
            return false;
        }
        boolean n = n();
        boolean n2 = hzVar.n();
        return !(n || n2) || (n && n2 && this.f518c.equals(hzVar.f518c));
    }

    public int b() {
        return this.f513b;
    }

    public hz b(int i2) {
        this.f513b = i2;
        c(true);
        return this;
    }

    public hz b(String str) {
        this.f514b = str;
        return this;
    }

    /* renamed from: b  reason: collision with other method in class */
    public String m386b() {
        return this.f514b;
    }

    /* renamed from: b  reason: collision with other method in class */
    public Map<String, String> m387b() {
        return this.f515b;
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        m383a();
        jiVar.a(f506a);
        if (this.f509a != null) {
            jiVar.a(f8431a);
            jiVar.a(this.f509a);
            jiVar.b();
        }
        jiVar.a(b);
        jiVar.a(this.f508a);
        jiVar.b();
        if (this.f514b != null && m390c()) {
            jiVar.a(c);
            jiVar.a(this.f514b);
            jiVar.b();
        }
        if (this.f517c != null && m391d()) {
            jiVar.a(d);
            jiVar.a(this.f517c);
            jiVar.b();
        }
        if (this.f519d != null && e()) {
            jiVar.a(e);
            jiVar.a(this.f519d);
            jiVar.b();
        }
        if (f()) {
            jiVar.a(f);
            jiVar.a(this.f507a);
            jiVar.b();
        }
        if (this.f520e != null && g()) {
            jiVar.a(g);
            jiVar.a(this.f520e);
            jiVar.b();
        }
        if (h()) {
            jiVar.a(h);
            jiVar.a(this.f513b);
            jiVar.b();
        }
        if (i()) {
            jiVar.a(i);
            jiVar.a(this.f516c);
            jiVar.b();
        }
        if (this.f511a != null && j()) {
            jiVar.a(j);
            jiVar.a(new jh(Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, this.f511a.size()));
            for (Map.Entry<String, String> entry : this.f511a.entrySet()) {
                jiVar.a(entry.getKey());
                jiVar.a(entry.getValue());
            }
            jiVar.d();
            jiVar.b();
        }
        if (this.f515b != null && k()) {
            jiVar.a(k);
            jiVar.a(new jh(Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, this.f515b.size()));
            for (Map.Entry<String, String> entry2 : this.f515b.entrySet()) {
                jiVar.a(entry2.getKey());
                jiVar.a(entry2.getValue());
            }
            jiVar.d();
            jiVar.b();
        }
        if (m()) {
            jiVar.a(l);
            jiVar.a(this.f512a);
            jiVar.b();
        }
        if (this.f518c != null && n()) {
            jiVar.a(m);
            jiVar.a(new jh(Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, this.f518c.size()));
            for (Map.Entry<String, String> entry3 : this.f518c.entrySet()) {
                jiVar.a(entry3.getKey());
                jiVar.a(entry3.getValue());
            }
            jiVar.d();
            jiVar.b();
        }
        jiVar.c();
        jiVar.m497a();
    }

    public void b(String str, String str2) {
        if (this.f515b == null) {
            this.f515b = new HashMap();
        }
        this.f515b.put(str, str2);
    }

    public void b(boolean z) {
        this.f510a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m388b() {
        return this.f510a.get(0);
    }

    public int c() {
        return this.f516c;
    }

    public hz c(int i2) {
        this.f516c = i2;
        d(true);
        return this;
    }

    public hz c(String str) {
        this.f517c = str;
        return this;
    }

    /* renamed from: c  reason: collision with other method in class */
    public String m389c() {
        return this.f517c;
    }

    public void c(boolean z) {
        this.f510a.set(2, z);
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m390c() {
        return this.f514b != null;
    }

    public hz d(String str) {
        this.f519d = str;
        return this;
    }

    public String d() {
        return this.f519d;
    }

    public void d(boolean z) {
        this.f510a.set(3, z);
    }

    /* renamed from: d  reason: collision with other method in class */
    public boolean m391d() {
        return this.f517c != null;
    }

    public void e(boolean z) {
        this.f510a.set(4, z);
    }

    public boolean e() {
        return this.f519d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hz)) {
            return m385a((hz) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f510a.get(1);
    }

    public boolean g() {
        return this.f520e != null;
    }

    public boolean h() {
        return this.f510a.get(2);
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f510a.get(3);
    }

    public boolean j() {
        return this.f511a != null;
    }

    public boolean k() {
        return this.f515b != null;
    }

    public boolean l() {
        return this.f512a;
    }

    public boolean m() {
        return this.f510a.get(4);
    }

    public boolean n() {
        return this.f518c != null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("PushMetaInfo(");
        sb.append("id:");
        if (this.f509a == null) {
            sb.append("null");
        } else {
            sb.append(this.f509a);
        }
        sb.append(", ");
        sb.append("messageTs:");
        sb.append(this.f508a);
        if (m390c()) {
            sb.append(", ");
            sb.append(UrlSchemaHelper.SCHEMA_TYPE_TOPIC);
            if (this.f514b == null) {
                sb.append("null");
            } else {
                sb.append(this.f514b);
            }
        }
        if (m391d()) {
            sb.append(", ");
            sb.append("title:");
            if (this.f517c == null) {
                sb.append("null");
            } else {
                sb.append(this.f517c);
            }
        }
        if (e()) {
            sb.append(", ");
            sb.append("description:");
            if (this.f519d == null) {
                sb.append("null");
            } else {
                sb.append(this.f519d);
            }
        }
        if (f()) {
            sb.append(", ");
            sb.append("notifyType:");
            sb.append(this.f507a);
        }
        if (g()) {
            sb.append(", ");
            sb.append("url:");
            if (this.f520e == null) {
                sb.append("null");
            } else {
                sb.append(this.f520e);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("passThrough:");
            sb.append(this.f513b);
        }
        if (i()) {
            sb.append(", ");
            sb.append("notifyId:");
            sb.append(this.f516c);
        }
        if (j()) {
            sb.append(", ");
            sb.append("extra:");
            if (this.f511a == null) {
                sb.append("null");
            } else {
                sb.append(this.f511a);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append(com.baidu.android.imsdk.retrieve.Constants.PATH_INTERNAL);
            if (this.f515b == null) {
                sb.append("null");
            } else {
                sb.append(this.f515b);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("ignoreRegInfo:");
            sb.append(this.f512a);
        }
        if (n()) {
            sb.append(", ");
            sb.append("apsProperFields:");
            if (this.f518c == null) {
                sb.append("null");
            } else {
                sb.append(this.f518c);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
