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
    public int f506a;

    /* renamed from: a  reason: collision with other field name */
    public long f507a;

    /* renamed from: a  reason: collision with other field name */
    public String f508a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f509a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f510a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f511a;

    /* renamed from: b  reason: collision with other field name */
    public int f512b;

    /* renamed from: b  reason: collision with other field name */
    public String f513b;

    /* renamed from: b  reason: collision with other field name */
    public Map<String, String> f514b;

    /* renamed from: c  reason: collision with other field name */
    public int f515c;

    /* renamed from: c  reason: collision with other field name */
    public String f516c;

    /* renamed from: c  reason: collision with other field name */
    public Map<String, String> f517c;

    /* renamed from: d  reason: collision with other field name */
    public String f518d;

    /* renamed from: e  reason: collision with other field name */
    public String f519e;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f505a = new jn("PushMetaInfo");
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
        this.f509a = new BitSet(5);
        this.f511a = false;
    }

    public hz(hz hzVar) {
        this.f509a = new BitSet(5);
        this.f509a.clear();
        this.f509a.or(hzVar.f509a);
        if (hzVar.m378a()) {
            this.f508a = hzVar.f508a;
        }
        this.f507a = hzVar.f507a;
        if (hzVar.m384c()) {
            this.f513b = hzVar.f513b;
        }
        if (hzVar.m385d()) {
            this.f516c = hzVar.f516c;
        }
        if (hzVar.e()) {
            this.f518d = hzVar.f518d;
        }
        this.f506a = hzVar.f506a;
        if (hzVar.g()) {
            this.f519e = hzVar.f519e;
        }
        this.f512b = hzVar.f512b;
        this.f515c = hzVar.f515c;
        if (hzVar.j()) {
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, String> entry : hzVar.f510a.entrySet()) {
                hashMap.put(entry.getKey(), entry.getValue());
            }
            this.f510a = hashMap;
        }
        if (hzVar.k()) {
            HashMap hashMap2 = new HashMap();
            for (Map.Entry<String, String> entry2 : hzVar.f514b.entrySet()) {
                hashMap2.put(entry2.getKey(), entry2.getValue());
            }
            this.f514b = hashMap2;
        }
        this.f511a = hzVar.f511a;
        if (hzVar.n()) {
            HashMap hashMap3 = new HashMap();
            for (Map.Entry<String, String> entry3 : hzVar.f517c.entrySet()) {
                hashMap3.put(entry3.getKey(), entry3.getValue());
            }
            this.f517c = hashMap3;
        }
    }

    public int a() {
        return this.f506a;
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
            int compareTo = Boolean.valueOf(m378a()).compareTo(Boolean.valueOf(hzVar.m378a()));
            if (compareTo == 0) {
                if (!m378a() || (a14 = iy.a(this.f508a, hzVar.f508a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m382b()).compareTo(Boolean.valueOf(hzVar.m382b()));
                    if (compareTo2 == 0) {
                        if (!m382b() || (a13 = iy.a(this.f507a, hzVar.f507a)) == 0) {
                            int compareTo3 = Boolean.valueOf(m384c()).compareTo(Boolean.valueOf(hzVar.m384c()));
                            if (compareTo3 == 0) {
                                if (!m384c() || (a12 = iy.a(this.f513b, hzVar.f513b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(m385d()).compareTo(Boolean.valueOf(hzVar.m385d()));
                                    if (compareTo4 == 0) {
                                        if (!m385d() || (a11 = iy.a(this.f516c, hzVar.f516c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hzVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a10 = iy.a(this.f518d, hzVar.f518d)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hzVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a9 = iy.a(this.f506a, hzVar.f506a)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hzVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a8 = iy.a(this.f519e, hzVar.f519e)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hzVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a7 = iy.a(this.f512b, hzVar.f512b)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hzVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a6 = iy.a(this.f515c, hzVar.f515c)) == 0) {
                                                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(hzVar.j()));
                                                                                    if (compareTo10 == 0) {
                                                                                        if (!j() || (a5 = iy.a(this.f510a, hzVar.f510a)) == 0) {
                                                                                            int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(hzVar.k()));
                                                                                            if (compareTo11 == 0) {
                                                                                                if (!k() || (a4 = iy.a(this.f514b, hzVar.f514b)) == 0) {
                                                                                                    int compareTo12 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(hzVar.m()));
                                                                                                    if (compareTo12 == 0) {
                                                                                                        if (!m() || (a3 = iy.a(this.f511a, hzVar.f511a)) == 0) {
                                                                                                            int compareTo13 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(hzVar.n()));
                                                                                                            if (compareTo13 == 0) {
                                                                                                                if (!n() || (a2 = iy.a(this.f517c, hzVar.f517c)) == 0) {
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
    public long m373a() {
        return this.f507a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public hz m374a() {
        return new hz(this);
    }

    public hz a(int i2) {
        this.f506a = i2;
        b(true);
        return this;
    }

    public hz a(String str) {
        this.f508a = str;
        return this;
    }

    public hz a(Map<String, String> map) {
        this.f510a = map;
        return this;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m375a() {
        return this.f508a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public Map<String, String> m376a() {
        return this.f510a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m377a() {
        if (this.f508a == null) {
            throw new jj("Required field 'id' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m487a();
        while (true) {
            jf m483a = jiVar.m483a();
            if (m483a.a == 0) {
                jiVar.f();
                if (!m382b()) {
                    throw new jj("Required field 'messageTs' was not found in serialized data! Struct: " + toString());
                }
                m377a();
                return;
            }
            switch (m483a.f777a) {
                case 1:
                    if (m483a.a == 11) {
                        this.f508a = jiVar.m488a();
                        break;
                    } else {
                        jl.a(jiVar, m483a.a);
                        break;
                    }
                case 2:
                    if (m483a.a == 10) {
                        this.f507a = jiVar.m482a();
                        a(true);
                        break;
                    } else {
                        jl.a(jiVar, m483a.a);
                        break;
                    }
                case 3:
                    if (m483a.a == 11) {
                        this.f513b = jiVar.m488a();
                        break;
                    } else {
                        jl.a(jiVar, m483a.a);
                        break;
                    }
                case 4:
                    if (m483a.a == 11) {
                        this.f516c = jiVar.m488a();
                        break;
                    } else {
                        jl.a(jiVar, m483a.a);
                        break;
                    }
                case 5:
                    if (m483a.a == 11) {
                        this.f518d = jiVar.m488a();
                        break;
                    } else {
                        jl.a(jiVar, m483a.a);
                        break;
                    }
                case 6:
                    if (m483a.a == 8) {
                        this.f506a = jiVar.m481a();
                        b(true);
                        break;
                    } else {
                        jl.a(jiVar, m483a.a);
                        break;
                    }
                case 7:
                    if (m483a.a == 11) {
                        this.f519e = jiVar.m488a();
                        break;
                    } else {
                        jl.a(jiVar, m483a.a);
                        break;
                    }
                case 8:
                    if (m483a.a == 8) {
                        this.f512b = jiVar.m481a();
                        c(true);
                        break;
                    } else {
                        jl.a(jiVar, m483a.a);
                        break;
                    }
                case 9:
                    if (m483a.a == 8) {
                        this.f515c = jiVar.m481a();
                        d(true);
                        break;
                    } else {
                        jl.a(jiVar, m483a.a);
                        break;
                    }
                case 10:
                    if (m483a.a == 13) {
                        jh m485a = jiVar.m485a();
                        this.f510a = new HashMap(m485a.f779a * 2);
                        for (int i2 = 0; i2 < m485a.f779a; i2++) {
                            this.f510a.put(jiVar.m488a(), jiVar.m488a());
                        }
                        jiVar.h();
                        break;
                    } else {
                        jl.a(jiVar, m483a.a);
                        break;
                    }
                case 11:
                    if (m483a.a == 13) {
                        jh m485a2 = jiVar.m485a();
                        this.f514b = new HashMap(m485a2.f779a * 2);
                        for (int i3 = 0; i3 < m485a2.f779a; i3++) {
                            this.f514b.put(jiVar.m488a(), jiVar.m488a());
                        }
                        jiVar.h();
                        break;
                    } else {
                        jl.a(jiVar, m483a.a);
                        break;
                    }
                case 12:
                    if (m483a.a == 2) {
                        this.f511a = jiVar.m492a();
                        e(true);
                        break;
                    } else {
                        jl.a(jiVar, m483a.a);
                        break;
                    }
                case 13:
                    if (m483a.a == 13) {
                        jh m485a3 = jiVar.m485a();
                        this.f517c = new HashMap(m485a3.f779a * 2);
                        for (int i4 = 0; i4 < m485a3.f779a; i4++) {
                            this.f517c.put(jiVar.m488a(), jiVar.m488a());
                        }
                        jiVar.h();
                        break;
                    } else {
                        jl.a(jiVar, m483a.a);
                        break;
                    }
                default:
                    jl.a(jiVar, m483a.a);
                    break;
            }
            jiVar.g();
        }
    }

    public void a(String str, String str2) {
        if (this.f510a == null) {
            this.f510a = new HashMap();
        }
        this.f510a.put(str, str2);
    }

    public void a(boolean z) {
        this.f509a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m378a() {
        return this.f508a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m379a(hz hzVar) {
        if (hzVar == null) {
            return false;
        }
        boolean m378a = m378a();
        boolean m378a2 = hzVar.m378a();
        if (((m378a || m378a2) && !(m378a && m378a2 && this.f508a.equals(hzVar.f508a))) || this.f507a != hzVar.f507a) {
            return false;
        }
        boolean m384c = m384c();
        boolean m384c2 = hzVar.m384c();
        if ((m384c || m384c2) && !(m384c && m384c2 && this.f513b.equals(hzVar.f513b))) {
            return false;
        }
        boolean m385d = m385d();
        boolean m385d2 = hzVar.m385d();
        if ((m385d || m385d2) && !(m385d && m385d2 && this.f516c.equals(hzVar.f516c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = hzVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f518d.equals(hzVar.f518d))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = hzVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f506a == hzVar.f506a)) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = hzVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f519e.equals(hzVar.f519e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = hzVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f512b == hzVar.f512b)) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = hzVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f515c == hzVar.f515c)) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = hzVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f510a.equals(hzVar.f510a))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = hzVar.k();
        if ((k2 || k3) && !(k2 && k3 && this.f514b.equals(hzVar.f514b))) {
            return false;
        }
        boolean m2 = m();
        boolean m3 = hzVar.m();
        if ((m2 || m3) && !(m2 && m3 && this.f511a == hzVar.f511a)) {
            return false;
        }
        boolean n = n();
        boolean n2 = hzVar.n();
        return !(n || n2) || (n && n2 && this.f517c.equals(hzVar.f517c));
    }

    public int b() {
        return this.f512b;
    }

    public hz b(int i2) {
        this.f512b = i2;
        c(true);
        return this;
    }

    public hz b(String str) {
        this.f513b = str;
        return this;
    }

    /* renamed from: b  reason: collision with other method in class */
    public String m380b() {
        return this.f513b;
    }

    /* renamed from: b  reason: collision with other method in class */
    public Map<String, String> m381b() {
        return this.f514b;
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        m377a();
        jiVar.a(f505a);
        if (this.f508a != null) {
            jiVar.a(a);
            jiVar.a(this.f508a);
            jiVar.b();
        }
        jiVar.a(b);
        jiVar.a(this.f507a);
        jiVar.b();
        if (this.f513b != null && m384c()) {
            jiVar.a(c);
            jiVar.a(this.f513b);
            jiVar.b();
        }
        if (this.f516c != null && m385d()) {
            jiVar.a(d);
            jiVar.a(this.f516c);
            jiVar.b();
        }
        if (this.f518d != null && e()) {
            jiVar.a(e);
            jiVar.a(this.f518d);
            jiVar.b();
        }
        if (f()) {
            jiVar.a(f);
            jiVar.a(this.f506a);
            jiVar.b();
        }
        if (this.f519e != null && g()) {
            jiVar.a(g);
            jiVar.a(this.f519e);
            jiVar.b();
        }
        if (h()) {
            jiVar.a(h);
            jiVar.a(this.f512b);
            jiVar.b();
        }
        if (i()) {
            jiVar.a(i);
            jiVar.a(this.f515c);
            jiVar.b();
        }
        if (this.f510a != null && j()) {
            jiVar.a(j);
            jiVar.a(new jh(Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, this.f510a.size()));
            for (Map.Entry<String, String> entry : this.f510a.entrySet()) {
                jiVar.a(entry.getKey());
                jiVar.a(entry.getValue());
            }
            jiVar.d();
            jiVar.b();
        }
        if (this.f514b != null && k()) {
            jiVar.a(k);
            jiVar.a(new jh(Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, this.f514b.size()));
            for (Map.Entry<String, String> entry2 : this.f514b.entrySet()) {
                jiVar.a(entry2.getKey());
                jiVar.a(entry2.getValue());
            }
            jiVar.d();
            jiVar.b();
        }
        if (m()) {
            jiVar.a(l);
            jiVar.a(this.f511a);
            jiVar.b();
        }
        if (this.f517c != null && n()) {
            jiVar.a(m);
            jiVar.a(new jh(Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, this.f517c.size()));
            for (Map.Entry<String, String> entry3 : this.f517c.entrySet()) {
                jiVar.a(entry3.getKey());
                jiVar.a(entry3.getValue());
            }
            jiVar.d();
            jiVar.b();
        }
        jiVar.c();
        jiVar.m491a();
    }

    public void b(String str, String str2) {
        if (this.f514b == null) {
            this.f514b = new HashMap();
        }
        this.f514b.put(str, str2);
    }

    public void b(boolean z) {
        this.f509a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m382b() {
        return this.f509a.get(0);
    }

    public int c() {
        return this.f515c;
    }

    public hz c(int i2) {
        this.f515c = i2;
        d(true);
        return this;
    }

    public hz c(String str) {
        this.f516c = str;
        return this;
    }

    /* renamed from: c  reason: collision with other method in class */
    public String m383c() {
        return this.f516c;
    }

    public void c(boolean z) {
        this.f509a.set(2, z);
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m384c() {
        return this.f513b != null;
    }

    public hz d(String str) {
        this.f518d = str;
        return this;
    }

    public String d() {
        return this.f518d;
    }

    public void d(boolean z) {
        this.f509a.set(3, z);
    }

    /* renamed from: d  reason: collision with other method in class */
    public boolean m385d() {
        return this.f516c != null;
    }

    public void e(boolean z) {
        this.f509a.set(4, z);
    }

    public boolean e() {
        return this.f518d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hz)) {
            return m379a((hz) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f509a.get(1);
    }

    public boolean g() {
        return this.f519e != null;
    }

    public boolean h() {
        return this.f509a.get(2);
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f509a.get(3);
    }

    public boolean j() {
        return this.f510a != null;
    }

    public boolean k() {
        return this.f514b != null;
    }

    public boolean l() {
        return this.f511a;
    }

    public boolean m() {
        return this.f509a.get(4);
    }

    public boolean n() {
        return this.f517c != null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("PushMetaInfo(");
        sb.append("id:");
        if (this.f508a == null) {
            sb.append("null");
        } else {
            sb.append(this.f508a);
        }
        sb.append(", ");
        sb.append("messageTs:");
        sb.append(this.f507a);
        if (m384c()) {
            sb.append(", ");
            sb.append(UrlSchemaHelper.SCHEMA_TYPE_TOPIC);
            if (this.f513b == null) {
                sb.append("null");
            } else {
                sb.append(this.f513b);
            }
        }
        if (m385d()) {
            sb.append(", ");
            sb.append("title:");
            if (this.f516c == null) {
                sb.append("null");
            } else {
                sb.append(this.f516c);
            }
        }
        if (e()) {
            sb.append(", ");
            sb.append("description:");
            if (this.f518d == null) {
                sb.append("null");
            } else {
                sb.append(this.f518d);
            }
        }
        if (f()) {
            sb.append(", ");
            sb.append("notifyType:");
            sb.append(this.f506a);
        }
        if (g()) {
            sb.append(", ");
            sb.append("url:");
            if (this.f519e == null) {
                sb.append("null");
            } else {
                sb.append(this.f519e);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("passThrough:");
            sb.append(this.f512b);
        }
        if (i()) {
            sb.append(", ");
            sb.append("notifyId:");
            sb.append(this.f515c);
        }
        if (j()) {
            sb.append(", ");
            sb.append("extra:");
            if (this.f510a == null) {
                sb.append("null");
            } else {
                sb.append(this.f510a);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("internal:");
            if (this.f514b == null) {
                sb.append("null");
            } else {
                sb.append(this.f514b);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("ignoreRegInfo:");
            sb.append(this.f511a);
        }
        if (n()) {
            sb.append(", ");
            sb.append("apsProperFields:");
            if (this.f517c == null) {
                sb.append("null");
            } else {
                sb.append(this.f517c);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
