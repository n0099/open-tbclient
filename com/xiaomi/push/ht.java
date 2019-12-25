package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public class ht implements ir<ht, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public int f525a;

    /* renamed from: a  reason: collision with other field name */
    public long f526a;

    /* renamed from: a  reason: collision with other field name */
    public String f527a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f528a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f529a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f530a;

    /* renamed from: b  reason: collision with other field name */
    public int f531b;

    /* renamed from: b  reason: collision with other field name */
    public String f532b;

    /* renamed from: b  reason: collision with other field name */
    public Map<String, String> f533b;

    /* renamed from: c  reason: collision with other field name */
    public int f534c;

    /* renamed from: c  reason: collision with other field name */
    public String f535c;

    /* renamed from: c  reason: collision with other field name */
    public Map<String, String> f536c;

    /* renamed from: d  reason: collision with other field name */
    public String f537d;

    /* renamed from: e  reason: collision with other field name */
    public String f538e;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f524a = new jh("PushMetaInfo");
    private static final iz a = new iz("", Constants.GZIP_CAST_TYPE, 1);
    private static final iz b = new iz("", (byte) 10, 2);
    private static final iz c = new iz("", Constants.GZIP_CAST_TYPE, 3);
    private static final iz d = new iz("", Constants.GZIP_CAST_TYPE, 4);
    private static final iz e = new iz("", Constants.GZIP_CAST_TYPE, 5);
    private static final iz f = new iz("", (byte) 8, 6);
    private static final iz g = new iz("", Constants.GZIP_CAST_TYPE, 7);
    private static final iz h = new iz("", (byte) 8, 8);
    private static final iz i = new iz("", (byte) 8, 9);
    private static final iz j = new iz("", (byte) 13, 10);
    private static final iz k = new iz("", (byte) 13, 11);
    private static final iz l = new iz("", (byte) 2, 12);
    private static final iz m = new iz("", (byte) 13, 13);

    public ht() {
        this.f528a = new BitSet(5);
        this.f530a = false;
    }

    public ht(ht htVar) {
        this.f528a = new BitSet(5);
        this.f528a.clear();
        this.f528a.or(htVar.f528a);
        if (htVar.m355a()) {
            this.f527a = htVar.f527a;
        }
        this.f526a = htVar.f526a;
        if (htVar.m361c()) {
            this.f532b = htVar.f532b;
        }
        if (htVar.m362d()) {
            this.f535c = htVar.f535c;
        }
        if (htVar.e()) {
            this.f537d = htVar.f537d;
        }
        this.f525a = htVar.f525a;
        if (htVar.g()) {
            this.f538e = htVar.f538e;
        }
        this.f531b = htVar.f531b;
        this.f534c = htVar.f534c;
        if (htVar.j()) {
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, String> entry : htVar.f529a.entrySet()) {
                hashMap.put(entry.getKey(), entry.getValue());
            }
            this.f529a = hashMap;
        }
        if (htVar.k()) {
            HashMap hashMap2 = new HashMap();
            for (Map.Entry<String, String> entry2 : htVar.f533b.entrySet()) {
                hashMap2.put(entry2.getKey(), entry2.getValue());
            }
            this.f533b = hashMap2;
        }
        this.f530a = htVar.f530a;
        if (htVar.n()) {
            HashMap hashMap3 = new HashMap();
            for (Map.Entry<String, String> entry3 : htVar.f536c.entrySet()) {
                hashMap3.put(entry3.getKey(), entry3.getValue());
            }
            this.f536c = hashMap3;
        }
    }

    public int a() {
        return this.f525a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(ht htVar) {
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
        if (getClass().equals(htVar.getClass())) {
            int compareTo = Boolean.valueOf(m355a()).compareTo(Boolean.valueOf(htVar.m355a()));
            if (compareTo == 0) {
                if (!m355a() || (a14 = is.a(this.f527a, htVar.f527a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m359b()).compareTo(Boolean.valueOf(htVar.m359b()));
                    if (compareTo2 == 0) {
                        if (!m359b() || (a13 = is.a(this.f526a, htVar.f526a)) == 0) {
                            int compareTo3 = Boolean.valueOf(m361c()).compareTo(Boolean.valueOf(htVar.m361c()));
                            if (compareTo3 == 0) {
                                if (!m361c() || (a12 = is.a(this.f532b, htVar.f532b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(m362d()).compareTo(Boolean.valueOf(htVar.m362d()));
                                    if (compareTo4 == 0) {
                                        if (!m362d() || (a11 = is.a(this.f535c, htVar.f535c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(htVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a10 = is.a(this.f537d, htVar.f537d)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(htVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a9 = is.a(this.f525a, htVar.f525a)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(htVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a8 = is.a(this.f538e, htVar.f538e)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(htVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a7 = is.a(this.f531b, htVar.f531b)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(htVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a6 = is.a(this.f534c, htVar.f534c)) == 0) {
                                                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(htVar.j()));
                                                                                    if (compareTo10 == 0) {
                                                                                        if (!j() || (a5 = is.a(this.f529a, htVar.f529a)) == 0) {
                                                                                            int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(htVar.k()));
                                                                                            if (compareTo11 == 0) {
                                                                                                if (!k() || (a4 = is.a(this.f533b, htVar.f533b)) == 0) {
                                                                                                    int compareTo12 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(htVar.m()));
                                                                                                    if (compareTo12 == 0) {
                                                                                                        if (!m() || (a3 = is.a(this.f530a, htVar.f530a)) == 0) {
                                                                                                            int compareTo13 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(htVar.n()));
                                                                                                            if (compareTo13 == 0) {
                                                                                                                if (!n() || (a2 = is.a(this.f536c, htVar.f536c)) == 0) {
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
        return getClass().getName().compareTo(htVar.getClass().getName());
    }

    /* renamed from: a  reason: collision with other method in class */
    public long m350a() {
        return this.f526a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public ht m351a() {
        return new ht(this);
    }

    public ht a(int i2) {
        this.f525a = i2;
        b(true);
        return this;
    }

    public ht a(String str) {
        this.f527a = str;
        return this;
    }

    public ht a(Map<String, String> map) {
        this.f529a = map;
        return this;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m352a() {
        return this.f527a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public Map<String, String> m353a() {
        return this.f529a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m354a() {
        if (this.f527a == null) {
            throw new jd("Required field 'id' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ir
    public void a(jc jcVar) {
        jcVar.m458a();
        while (true) {
            iz m454a = jcVar.m454a();
            if (m454a.a == 0) {
                jcVar.f();
                if (!m359b()) {
                    throw new jd("Required field 'messageTs' was not found in serialized data! Struct: " + toString());
                }
                m354a();
                return;
            }
            switch (m454a.f793a) {
                case 1:
                    if (m454a.a == 11) {
                        this.f527a = jcVar.m459a();
                        break;
                    } else {
                        jf.a(jcVar, m454a.a);
                        break;
                    }
                case 2:
                    if (m454a.a == 10) {
                        this.f526a = jcVar.m453a();
                        a(true);
                        break;
                    } else {
                        jf.a(jcVar, m454a.a);
                        break;
                    }
                case 3:
                    if (m454a.a == 11) {
                        this.f532b = jcVar.m459a();
                        break;
                    } else {
                        jf.a(jcVar, m454a.a);
                        break;
                    }
                case 4:
                    if (m454a.a == 11) {
                        this.f535c = jcVar.m459a();
                        break;
                    } else {
                        jf.a(jcVar, m454a.a);
                        break;
                    }
                case 5:
                    if (m454a.a == 11) {
                        this.f537d = jcVar.m459a();
                        break;
                    } else {
                        jf.a(jcVar, m454a.a);
                        break;
                    }
                case 6:
                    if (m454a.a == 8) {
                        this.f525a = jcVar.m452a();
                        b(true);
                        break;
                    } else {
                        jf.a(jcVar, m454a.a);
                        break;
                    }
                case 7:
                    if (m454a.a == 11) {
                        this.f538e = jcVar.m459a();
                        break;
                    } else {
                        jf.a(jcVar, m454a.a);
                        break;
                    }
                case 8:
                    if (m454a.a == 8) {
                        this.f531b = jcVar.m452a();
                        c(true);
                        break;
                    } else {
                        jf.a(jcVar, m454a.a);
                        break;
                    }
                case 9:
                    if (m454a.a == 8) {
                        this.f534c = jcVar.m452a();
                        d(true);
                        break;
                    } else {
                        jf.a(jcVar, m454a.a);
                        break;
                    }
                case 10:
                    if (m454a.a == 13) {
                        jb m456a = jcVar.m456a();
                        this.f529a = new HashMap(m456a.f797a * 2);
                        for (int i2 = 0; i2 < m456a.f797a; i2++) {
                            this.f529a.put(jcVar.m459a(), jcVar.m459a());
                        }
                        jcVar.h();
                        break;
                    } else {
                        jf.a(jcVar, m454a.a);
                        break;
                    }
                case 11:
                    if (m454a.a == 13) {
                        jb m456a2 = jcVar.m456a();
                        this.f533b = new HashMap(m456a2.f797a * 2);
                        for (int i3 = 0; i3 < m456a2.f797a; i3++) {
                            this.f533b.put(jcVar.m459a(), jcVar.m459a());
                        }
                        jcVar.h();
                        break;
                    } else {
                        jf.a(jcVar, m454a.a);
                        break;
                    }
                case 12:
                    if (m454a.a == 2) {
                        this.f530a = jcVar.m463a();
                        e(true);
                        break;
                    } else {
                        jf.a(jcVar, m454a.a);
                        break;
                    }
                case 13:
                    if (m454a.a == 13) {
                        jb m456a3 = jcVar.m456a();
                        this.f536c = new HashMap(m456a3.f797a * 2);
                        for (int i4 = 0; i4 < m456a3.f797a; i4++) {
                            this.f536c.put(jcVar.m459a(), jcVar.m459a());
                        }
                        jcVar.h();
                        break;
                    } else {
                        jf.a(jcVar, m454a.a);
                        break;
                    }
                default:
                    jf.a(jcVar, m454a.a);
                    break;
            }
            jcVar.g();
        }
    }

    public void a(String str, String str2) {
        if (this.f529a == null) {
            this.f529a = new HashMap();
        }
        this.f529a.put(str, str2);
    }

    public void a(boolean z) {
        this.f528a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m355a() {
        return this.f527a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m356a(ht htVar) {
        if (htVar == null) {
            return false;
        }
        boolean m355a = m355a();
        boolean m355a2 = htVar.m355a();
        if (((m355a || m355a2) && !(m355a && m355a2 && this.f527a.equals(htVar.f527a))) || this.f526a != htVar.f526a) {
            return false;
        }
        boolean m361c = m361c();
        boolean m361c2 = htVar.m361c();
        if ((m361c || m361c2) && !(m361c && m361c2 && this.f532b.equals(htVar.f532b))) {
            return false;
        }
        boolean m362d = m362d();
        boolean m362d2 = htVar.m362d();
        if ((m362d || m362d2) && !(m362d && m362d2 && this.f535c.equals(htVar.f535c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = htVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f537d.equals(htVar.f537d))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = htVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f525a == htVar.f525a)) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = htVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f538e.equals(htVar.f538e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = htVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f531b == htVar.f531b)) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = htVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f534c == htVar.f534c)) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = htVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f529a.equals(htVar.f529a))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = htVar.k();
        if ((k2 || k3) && !(k2 && k3 && this.f533b.equals(htVar.f533b))) {
            return false;
        }
        boolean m2 = m();
        boolean m3 = htVar.m();
        if ((m2 || m3) && !(m2 && m3 && this.f530a == htVar.f530a)) {
            return false;
        }
        boolean n = n();
        boolean n2 = htVar.n();
        return !(n || n2) || (n && n2 && this.f536c.equals(htVar.f536c));
    }

    public int b() {
        return this.f531b;
    }

    public ht b(int i2) {
        this.f531b = i2;
        c(true);
        return this;
    }

    public ht b(String str) {
        this.f532b = str;
        return this;
    }

    /* renamed from: b  reason: collision with other method in class */
    public String m357b() {
        return this.f532b;
    }

    /* renamed from: b  reason: collision with other method in class */
    public Map<String, String> m358b() {
        return this.f533b;
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        m354a();
        jcVar.a(f524a);
        if (this.f527a != null) {
            jcVar.a(a);
            jcVar.a(this.f527a);
            jcVar.b();
        }
        jcVar.a(b);
        jcVar.a(this.f526a);
        jcVar.b();
        if (this.f532b != null && m361c()) {
            jcVar.a(c);
            jcVar.a(this.f532b);
            jcVar.b();
        }
        if (this.f535c != null && m362d()) {
            jcVar.a(d);
            jcVar.a(this.f535c);
            jcVar.b();
        }
        if (this.f537d != null && e()) {
            jcVar.a(e);
            jcVar.a(this.f537d);
            jcVar.b();
        }
        if (f()) {
            jcVar.a(f);
            jcVar.a(this.f525a);
            jcVar.b();
        }
        if (this.f538e != null && g()) {
            jcVar.a(g);
            jcVar.a(this.f538e);
            jcVar.b();
        }
        if (h()) {
            jcVar.a(h);
            jcVar.a(this.f531b);
            jcVar.b();
        }
        if (i()) {
            jcVar.a(i);
            jcVar.a(this.f534c);
            jcVar.b();
        }
        if (this.f529a != null && j()) {
            jcVar.a(j);
            jcVar.a(new jb(Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, this.f529a.size()));
            for (Map.Entry<String, String> entry : this.f529a.entrySet()) {
                jcVar.a(entry.getKey());
                jcVar.a(entry.getValue());
            }
            jcVar.d();
            jcVar.b();
        }
        if (this.f533b != null && k()) {
            jcVar.a(k);
            jcVar.a(new jb(Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, this.f533b.size()));
            for (Map.Entry<String, String> entry2 : this.f533b.entrySet()) {
                jcVar.a(entry2.getKey());
                jcVar.a(entry2.getValue());
            }
            jcVar.d();
            jcVar.b();
        }
        if (m()) {
            jcVar.a(l);
            jcVar.a(this.f530a);
            jcVar.b();
        }
        if (this.f536c != null && n()) {
            jcVar.a(m);
            jcVar.a(new jb(Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, this.f536c.size()));
            for (Map.Entry<String, String> entry3 : this.f536c.entrySet()) {
                jcVar.a(entry3.getKey());
                jcVar.a(entry3.getValue());
            }
            jcVar.d();
            jcVar.b();
        }
        jcVar.c();
        jcVar.m462a();
    }

    public void b(String str, String str2) {
        if (this.f533b == null) {
            this.f533b = new HashMap();
        }
        this.f533b.put(str, str2);
    }

    public void b(boolean z) {
        this.f528a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m359b() {
        return this.f528a.get(0);
    }

    public int c() {
        return this.f534c;
    }

    public ht c(int i2) {
        this.f534c = i2;
        d(true);
        return this;
    }

    public ht c(String str) {
        this.f535c = str;
        return this;
    }

    /* renamed from: c  reason: collision with other method in class */
    public String m360c() {
        return this.f535c;
    }

    public void c(boolean z) {
        this.f528a.set(2, z);
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m361c() {
        return this.f532b != null;
    }

    public ht d(String str) {
        this.f537d = str;
        return this;
    }

    public String d() {
        return this.f537d;
    }

    public void d(boolean z) {
        this.f528a.set(3, z);
    }

    /* renamed from: d  reason: collision with other method in class */
    public boolean m362d() {
        return this.f535c != null;
    }

    public void e(boolean z) {
        this.f528a.set(4, z);
    }

    public boolean e() {
        return this.f537d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ht)) {
            return m356a((ht) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f528a.get(1);
    }

    public boolean g() {
        return this.f538e != null;
    }

    public boolean h() {
        return this.f528a.get(2);
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f528a.get(3);
    }

    public boolean j() {
        return this.f529a != null;
    }

    public boolean k() {
        return this.f533b != null;
    }

    public boolean l() {
        return this.f530a;
    }

    public boolean m() {
        return this.f528a.get(4);
    }

    public boolean n() {
        return this.f536c != null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("PushMetaInfo(");
        sb.append("id:");
        if (this.f527a == null) {
            sb.append("null");
        } else {
            sb.append(this.f527a);
        }
        sb.append(", ");
        sb.append("messageTs:");
        sb.append(this.f526a);
        if (m361c()) {
            sb.append(", ");
            sb.append(UrlSchemaHelper.SCHEMA_TYPE_TOPIC);
            if (this.f532b == null) {
                sb.append("null");
            } else {
                sb.append(this.f532b);
            }
        }
        if (m362d()) {
            sb.append(", ");
            sb.append("title:");
            if (this.f535c == null) {
                sb.append("null");
            } else {
                sb.append(this.f535c);
            }
        }
        if (e()) {
            sb.append(", ");
            sb.append("description:");
            if (this.f537d == null) {
                sb.append("null");
            } else {
                sb.append(this.f537d);
            }
        }
        if (f()) {
            sb.append(", ");
            sb.append("notifyType:");
            sb.append(this.f525a);
        }
        if (g()) {
            sb.append(", ");
            sb.append("url:");
            if (this.f538e == null) {
                sb.append("null");
            } else {
                sb.append(this.f538e);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("passThrough:");
            sb.append(this.f531b);
        }
        if (i()) {
            sb.append(", ");
            sb.append("notifyId:");
            sb.append(this.f534c);
        }
        if (j()) {
            sb.append(", ");
            sb.append("extra:");
            if (this.f529a == null) {
                sb.append("null");
            } else {
                sb.append(this.f529a);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("internal:");
            if (this.f533b == null) {
                sb.append("null");
            } else {
                sb.append(this.f533b);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("ignoreRegInfo:");
            sb.append(this.f530a);
        }
        if (n()) {
            sb.append(", ");
            sb.append("apsProperFields:");
            if (this.f536c == null) {
                sb.append("null");
            } else {
                sb.append(this.f536c);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
