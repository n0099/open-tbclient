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
    public int f505a;

    /* renamed from: a  reason: collision with other field name */
    public long f506a;

    /* renamed from: a  reason: collision with other field name */
    public String f507a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f508a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f509a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f510a;

    /* renamed from: b  reason: collision with other field name */
    public int f511b;

    /* renamed from: b  reason: collision with other field name */
    public String f512b;

    /* renamed from: b  reason: collision with other field name */
    public Map<String, String> f513b;

    /* renamed from: c  reason: collision with other field name */
    public int f514c;

    /* renamed from: c  reason: collision with other field name */
    public String f515c;

    /* renamed from: c  reason: collision with other field name */
    public Map<String, String> f516c;

    /* renamed from: d  reason: collision with other field name */
    public String f517d;

    /* renamed from: e  reason: collision with other field name */
    public String f518e;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f504a = new jn("PushMetaInfo");

    /* renamed from: a  reason: collision with root package name */
    private static final jf f4966a = new jf("", Constants.GZIP_CAST_TYPE, 1);
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
        this.f508a = new BitSet(5);
        this.f510a = false;
    }

    public hz(hz hzVar) {
        this.f508a = new BitSet(5);
        this.f508a.clear();
        this.f508a.or(hzVar.f508a);
        if (hzVar.m380a()) {
            this.f507a = hzVar.f507a;
        }
        this.f506a = hzVar.f506a;
        if (hzVar.m386c()) {
            this.f512b = hzVar.f512b;
        }
        if (hzVar.m387d()) {
            this.f515c = hzVar.f515c;
        }
        if (hzVar.e()) {
            this.f517d = hzVar.f517d;
        }
        this.f505a = hzVar.f505a;
        if (hzVar.g()) {
            this.f518e = hzVar.f518e;
        }
        this.f511b = hzVar.f511b;
        this.f514c = hzVar.f514c;
        if (hzVar.j()) {
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, String> entry : hzVar.f509a.entrySet()) {
                hashMap.put(entry.getKey(), entry.getValue());
            }
            this.f509a = hashMap;
        }
        if (hzVar.k()) {
            HashMap hashMap2 = new HashMap();
            for (Map.Entry<String, String> entry2 : hzVar.f513b.entrySet()) {
                hashMap2.put(entry2.getKey(), entry2.getValue());
            }
            this.f513b = hashMap2;
        }
        this.f510a = hzVar.f510a;
        if (hzVar.n()) {
            HashMap hashMap3 = new HashMap();
            for (Map.Entry<String, String> entry3 : hzVar.f516c.entrySet()) {
                hashMap3.put(entry3.getKey(), entry3.getValue());
            }
            this.f516c = hashMap3;
        }
    }

    public int a() {
        return this.f505a;
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
            int compareTo = Boolean.valueOf(m380a()).compareTo(Boolean.valueOf(hzVar.m380a()));
            if (compareTo == 0) {
                if (!m380a() || (a14 = iy.a(this.f507a, hzVar.f507a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m384b()).compareTo(Boolean.valueOf(hzVar.m384b()));
                    if (compareTo2 == 0) {
                        if (!m384b() || (a13 = iy.a(this.f506a, hzVar.f506a)) == 0) {
                            int compareTo3 = Boolean.valueOf(m386c()).compareTo(Boolean.valueOf(hzVar.m386c()));
                            if (compareTo3 == 0) {
                                if (!m386c() || (a12 = iy.a(this.f512b, hzVar.f512b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(m387d()).compareTo(Boolean.valueOf(hzVar.m387d()));
                                    if (compareTo4 == 0) {
                                        if (!m387d() || (a11 = iy.a(this.f515c, hzVar.f515c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hzVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a10 = iy.a(this.f517d, hzVar.f517d)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hzVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a9 = iy.a(this.f505a, hzVar.f505a)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hzVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a8 = iy.a(this.f518e, hzVar.f518e)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hzVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a7 = iy.a(this.f511b, hzVar.f511b)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hzVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a6 = iy.a(this.f514c, hzVar.f514c)) == 0) {
                                                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(hzVar.j()));
                                                                                    if (compareTo10 == 0) {
                                                                                        if (!j() || (a5 = iy.a(this.f509a, hzVar.f509a)) == 0) {
                                                                                            int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(hzVar.k()));
                                                                                            if (compareTo11 == 0) {
                                                                                                if (!k() || (a4 = iy.a(this.f513b, hzVar.f513b)) == 0) {
                                                                                                    int compareTo12 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(hzVar.m()));
                                                                                                    if (compareTo12 == 0) {
                                                                                                        if (!m() || (a3 = iy.a(this.f510a, hzVar.f510a)) == 0) {
                                                                                                            int compareTo13 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(hzVar.n()));
                                                                                                            if (compareTo13 == 0) {
                                                                                                                if (!n() || (a2 = iy.a(this.f516c, hzVar.f516c)) == 0) {
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
    public long m375a() {
        return this.f506a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public hz m376a() {
        return new hz(this);
    }

    public hz a(int i2) {
        this.f505a = i2;
        b(true);
        return this;
    }

    public hz a(String str) {
        this.f507a = str;
        return this;
    }

    public hz a(Map<String, String> map) {
        this.f509a = map;
        return this;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m377a() {
        return this.f507a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public Map<String, String> m378a() {
        return this.f509a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m379a() {
        if (this.f507a == null) {
            throw new jj("Required field 'id' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m489a();
        while (true) {
            jf m485a = jiVar.m485a();
            if (m485a.f4998a == 0) {
                jiVar.f();
                if (!m384b()) {
                    throw new jj("Required field 'messageTs' was not found in serialized data! Struct: " + toString());
                }
                m379a();
                return;
            }
            switch (m485a.f776a) {
                case 1:
                    if (m485a.f4998a == 11) {
                        this.f507a = jiVar.m490a();
                        break;
                    } else {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    }
                case 2:
                    if (m485a.f4998a == 10) {
                        this.f506a = jiVar.m484a();
                        a(true);
                        break;
                    } else {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    }
                case 3:
                    if (m485a.f4998a == 11) {
                        this.f512b = jiVar.m490a();
                        break;
                    } else {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    }
                case 4:
                    if (m485a.f4998a == 11) {
                        this.f515c = jiVar.m490a();
                        break;
                    } else {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    }
                case 5:
                    if (m485a.f4998a == 11) {
                        this.f517d = jiVar.m490a();
                        break;
                    } else {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    }
                case 6:
                    if (m485a.f4998a == 8) {
                        this.f505a = jiVar.m483a();
                        b(true);
                        break;
                    } else {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    }
                case 7:
                    if (m485a.f4998a == 11) {
                        this.f518e = jiVar.m490a();
                        break;
                    } else {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    }
                case 8:
                    if (m485a.f4998a == 8) {
                        this.f511b = jiVar.m483a();
                        c(true);
                        break;
                    } else {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    }
                case 9:
                    if (m485a.f4998a == 8) {
                        this.f514c = jiVar.m483a();
                        d(true);
                        break;
                    } else {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    }
                case 10:
                    if (m485a.f4998a == 13) {
                        jh m487a = jiVar.m487a();
                        this.f509a = new HashMap(m487a.f778a * 2);
                        for (int i2 = 0; i2 < m487a.f778a; i2++) {
                            this.f509a.put(jiVar.m490a(), jiVar.m490a());
                        }
                        jiVar.h();
                        break;
                    } else {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    }
                case 11:
                    if (m485a.f4998a == 13) {
                        jh m487a2 = jiVar.m487a();
                        this.f513b = new HashMap(m487a2.f778a * 2);
                        for (int i3 = 0; i3 < m487a2.f778a; i3++) {
                            this.f513b.put(jiVar.m490a(), jiVar.m490a());
                        }
                        jiVar.h();
                        break;
                    } else {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    }
                case 12:
                    if (m485a.f4998a == 2) {
                        this.f510a = jiVar.m494a();
                        e(true);
                        break;
                    } else {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    }
                case 13:
                    if (m485a.f4998a == 13) {
                        jh m487a3 = jiVar.m487a();
                        this.f516c = new HashMap(m487a3.f778a * 2);
                        for (int i4 = 0; i4 < m487a3.f778a; i4++) {
                            this.f516c.put(jiVar.m490a(), jiVar.m490a());
                        }
                        jiVar.h();
                        break;
                    } else {
                        jl.a(jiVar, m485a.f4998a);
                        break;
                    }
                default:
                    jl.a(jiVar, m485a.f4998a);
                    break;
            }
            jiVar.g();
        }
    }

    public void a(String str, String str2) {
        if (this.f509a == null) {
            this.f509a = new HashMap();
        }
        this.f509a.put(str, str2);
    }

    public void a(boolean z) {
        this.f508a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m380a() {
        return this.f507a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m381a(hz hzVar) {
        if (hzVar == null) {
            return false;
        }
        boolean m380a = m380a();
        boolean m380a2 = hzVar.m380a();
        if (((m380a || m380a2) && !(m380a && m380a2 && this.f507a.equals(hzVar.f507a))) || this.f506a != hzVar.f506a) {
            return false;
        }
        boolean m386c = m386c();
        boolean m386c2 = hzVar.m386c();
        if ((m386c || m386c2) && !(m386c && m386c2 && this.f512b.equals(hzVar.f512b))) {
            return false;
        }
        boolean m387d = m387d();
        boolean m387d2 = hzVar.m387d();
        if ((m387d || m387d2) && !(m387d && m387d2 && this.f515c.equals(hzVar.f515c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = hzVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f517d.equals(hzVar.f517d))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = hzVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f505a == hzVar.f505a)) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = hzVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f518e.equals(hzVar.f518e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = hzVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f511b == hzVar.f511b)) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = hzVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f514c == hzVar.f514c)) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = hzVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f509a.equals(hzVar.f509a))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = hzVar.k();
        if ((k2 || k3) && !(k2 && k3 && this.f513b.equals(hzVar.f513b))) {
            return false;
        }
        boolean m2 = m();
        boolean m3 = hzVar.m();
        if ((m2 || m3) && !(m2 && m3 && this.f510a == hzVar.f510a)) {
            return false;
        }
        boolean n = n();
        boolean n2 = hzVar.n();
        return !(n || n2) || (n && n2 && this.f516c.equals(hzVar.f516c));
    }

    public int b() {
        return this.f511b;
    }

    public hz b(int i2) {
        this.f511b = i2;
        c(true);
        return this;
    }

    public hz b(String str) {
        this.f512b = str;
        return this;
    }

    /* renamed from: b  reason: collision with other method in class */
    public String m382b() {
        return this.f512b;
    }

    /* renamed from: b  reason: collision with other method in class */
    public Map<String, String> m383b() {
        return this.f513b;
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        m379a();
        jiVar.a(f504a);
        if (this.f507a != null) {
            jiVar.a(f4966a);
            jiVar.a(this.f507a);
            jiVar.b();
        }
        jiVar.a(b);
        jiVar.a(this.f506a);
        jiVar.b();
        if (this.f512b != null && m386c()) {
            jiVar.a(c);
            jiVar.a(this.f512b);
            jiVar.b();
        }
        if (this.f515c != null && m387d()) {
            jiVar.a(d);
            jiVar.a(this.f515c);
            jiVar.b();
        }
        if (this.f517d != null && e()) {
            jiVar.a(e);
            jiVar.a(this.f517d);
            jiVar.b();
        }
        if (f()) {
            jiVar.a(f);
            jiVar.a(this.f505a);
            jiVar.b();
        }
        if (this.f518e != null && g()) {
            jiVar.a(g);
            jiVar.a(this.f518e);
            jiVar.b();
        }
        if (h()) {
            jiVar.a(h);
            jiVar.a(this.f511b);
            jiVar.b();
        }
        if (i()) {
            jiVar.a(i);
            jiVar.a(this.f514c);
            jiVar.b();
        }
        if (this.f509a != null && j()) {
            jiVar.a(j);
            jiVar.a(new jh(Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, this.f509a.size()));
            for (Map.Entry<String, String> entry : this.f509a.entrySet()) {
                jiVar.a(entry.getKey());
                jiVar.a(entry.getValue());
            }
            jiVar.d();
            jiVar.b();
        }
        if (this.f513b != null && k()) {
            jiVar.a(k);
            jiVar.a(new jh(Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, this.f513b.size()));
            for (Map.Entry<String, String> entry2 : this.f513b.entrySet()) {
                jiVar.a(entry2.getKey());
                jiVar.a(entry2.getValue());
            }
            jiVar.d();
            jiVar.b();
        }
        if (m()) {
            jiVar.a(l);
            jiVar.a(this.f510a);
            jiVar.b();
        }
        if (this.f516c != null && n()) {
            jiVar.a(m);
            jiVar.a(new jh(Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, this.f516c.size()));
            for (Map.Entry<String, String> entry3 : this.f516c.entrySet()) {
                jiVar.a(entry3.getKey());
                jiVar.a(entry3.getValue());
            }
            jiVar.d();
            jiVar.b();
        }
        jiVar.c();
        jiVar.m493a();
    }

    public void b(String str, String str2) {
        if (this.f513b == null) {
            this.f513b = new HashMap();
        }
        this.f513b.put(str, str2);
    }

    public void b(boolean z) {
        this.f508a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m384b() {
        return this.f508a.get(0);
    }

    public int c() {
        return this.f514c;
    }

    public hz c(int i2) {
        this.f514c = i2;
        d(true);
        return this;
    }

    public hz c(String str) {
        this.f515c = str;
        return this;
    }

    /* renamed from: c  reason: collision with other method in class */
    public String m385c() {
        return this.f515c;
    }

    public void c(boolean z) {
        this.f508a.set(2, z);
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m386c() {
        return this.f512b != null;
    }

    public hz d(String str) {
        this.f517d = str;
        return this;
    }

    public String d() {
        return this.f517d;
    }

    public void d(boolean z) {
        this.f508a.set(3, z);
    }

    /* renamed from: d  reason: collision with other method in class */
    public boolean m387d() {
        return this.f515c != null;
    }

    public void e(boolean z) {
        this.f508a.set(4, z);
    }

    public boolean e() {
        return this.f517d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hz)) {
            return m381a((hz) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f508a.get(1);
    }

    public boolean g() {
        return this.f518e != null;
    }

    public boolean h() {
        return this.f508a.get(2);
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f508a.get(3);
    }

    public boolean j() {
        return this.f509a != null;
    }

    public boolean k() {
        return this.f513b != null;
    }

    public boolean l() {
        return this.f510a;
    }

    public boolean m() {
        return this.f508a.get(4);
    }

    public boolean n() {
        return this.f516c != null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("PushMetaInfo(");
        sb.append("id:");
        if (this.f507a == null) {
            sb.append("null");
        } else {
            sb.append(this.f507a);
        }
        sb.append(", ");
        sb.append("messageTs:");
        sb.append(this.f506a);
        if (m386c()) {
            sb.append(", ");
            sb.append(UrlSchemaHelper.SCHEMA_TYPE_TOPIC);
            if (this.f512b == null) {
                sb.append("null");
            } else {
                sb.append(this.f512b);
            }
        }
        if (m387d()) {
            sb.append(", ");
            sb.append("title:");
            if (this.f515c == null) {
                sb.append("null");
            } else {
                sb.append(this.f515c);
            }
        }
        if (e()) {
            sb.append(", ");
            sb.append("description:");
            if (this.f517d == null) {
                sb.append("null");
            } else {
                sb.append(this.f517d);
            }
        }
        if (f()) {
            sb.append(", ");
            sb.append("notifyType:");
            sb.append(this.f505a);
        }
        if (g()) {
            sb.append(", ");
            sb.append("url:");
            if (this.f518e == null) {
                sb.append("null");
            } else {
                sb.append(this.f518e);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("passThrough:");
            sb.append(this.f511b);
        }
        if (i()) {
            sb.append(", ");
            sb.append("notifyId:");
            sb.append(this.f514c);
        }
        if (j()) {
            sb.append(", ");
            sb.append("extra:");
            if (this.f509a == null) {
                sb.append("null");
            } else {
                sb.append(this.f509a);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("internal:");
            if (this.f513b == null) {
                sb.append("null");
            } else {
                sb.append(this.f513b);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("ignoreRegInfo:");
            sb.append(this.f510a);
        }
        if (n()) {
            sb.append(", ");
            sb.append("apsProperFields:");
            if (this.f516c == null) {
                sb.append("null");
            } else {
                sb.append(this.f516c);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
