package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class ht implements ir<ht, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public int f520a;

    /* renamed from: a  reason: collision with other field name */
    public long f521a;

    /* renamed from: a  reason: collision with other field name */
    public String f522a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f523a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f524a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f525a;

    /* renamed from: b  reason: collision with other field name */
    public int f526b;

    /* renamed from: b  reason: collision with other field name */
    public String f527b;

    /* renamed from: b  reason: collision with other field name */
    public Map<String, String> f528b;

    /* renamed from: c  reason: collision with other field name */
    public int f529c;

    /* renamed from: c  reason: collision with other field name */
    public String f530c;

    /* renamed from: c  reason: collision with other field name */
    public Map<String, String> f531c;

    /* renamed from: d  reason: collision with other field name */
    public String f532d;

    /* renamed from: e  reason: collision with other field name */
    public String f533e;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f519a = new jh("PushMetaInfo");
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
        this.f523a = new BitSet(5);
        this.f525a = false;
    }

    public ht(ht htVar) {
        this.f523a = new BitSet(5);
        this.f523a.clear();
        this.f523a.or(htVar.f523a);
        if (htVar.m352a()) {
            this.f522a = htVar.f522a;
        }
        this.f521a = htVar.f521a;
        if (htVar.m358c()) {
            this.f527b = htVar.f527b;
        }
        if (htVar.m359d()) {
            this.f530c = htVar.f530c;
        }
        if (htVar.e()) {
            this.f532d = htVar.f532d;
        }
        this.f520a = htVar.f520a;
        if (htVar.g()) {
            this.f533e = htVar.f533e;
        }
        this.f526b = htVar.f526b;
        this.f529c = htVar.f529c;
        if (htVar.j()) {
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, String> entry : htVar.f524a.entrySet()) {
                hashMap.put(entry.getKey(), entry.getValue());
            }
            this.f524a = hashMap;
        }
        if (htVar.k()) {
            HashMap hashMap2 = new HashMap();
            for (Map.Entry<String, String> entry2 : htVar.f528b.entrySet()) {
                hashMap2.put(entry2.getKey(), entry2.getValue());
            }
            this.f528b = hashMap2;
        }
        this.f525a = htVar.f525a;
        if (htVar.n()) {
            HashMap hashMap3 = new HashMap();
            for (Map.Entry<String, String> entry3 : htVar.f531c.entrySet()) {
                hashMap3.put(entry3.getKey(), entry3.getValue());
            }
            this.f531c = hashMap3;
        }
    }

    public int a() {
        return this.f520a;
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
            int compareTo = Boolean.valueOf(m352a()).compareTo(Boolean.valueOf(htVar.m352a()));
            if (compareTo == 0) {
                if (!m352a() || (a14 = is.a(this.f522a, htVar.f522a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m356b()).compareTo(Boolean.valueOf(htVar.m356b()));
                    if (compareTo2 == 0) {
                        if (!m356b() || (a13 = is.a(this.f521a, htVar.f521a)) == 0) {
                            int compareTo3 = Boolean.valueOf(m358c()).compareTo(Boolean.valueOf(htVar.m358c()));
                            if (compareTo3 == 0) {
                                if (!m358c() || (a12 = is.a(this.f527b, htVar.f527b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(m359d()).compareTo(Boolean.valueOf(htVar.m359d()));
                                    if (compareTo4 == 0) {
                                        if (!m359d() || (a11 = is.a(this.f530c, htVar.f530c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(htVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a10 = is.a(this.f532d, htVar.f532d)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(htVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a9 = is.a(this.f520a, htVar.f520a)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(htVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a8 = is.a(this.f533e, htVar.f533e)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(htVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a7 = is.a(this.f526b, htVar.f526b)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(htVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a6 = is.a(this.f529c, htVar.f529c)) == 0) {
                                                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(htVar.j()));
                                                                                    if (compareTo10 == 0) {
                                                                                        if (!j() || (a5 = is.a(this.f524a, htVar.f524a)) == 0) {
                                                                                            int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(htVar.k()));
                                                                                            if (compareTo11 == 0) {
                                                                                                if (!k() || (a4 = is.a(this.f528b, htVar.f528b)) == 0) {
                                                                                                    int compareTo12 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(htVar.m()));
                                                                                                    if (compareTo12 == 0) {
                                                                                                        if (!m() || (a3 = is.a(this.f525a, htVar.f525a)) == 0) {
                                                                                                            int compareTo13 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(htVar.n()));
                                                                                                            if (compareTo13 == 0) {
                                                                                                                if (!n() || (a2 = is.a(this.f531c, htVar.f531c)) == 0) {
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
    public long m347a() {
        return this.f521a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public ht m348a() {
        return new ht(this);
    }

    public ht a(int i2) {
        this.f520a = i2;
        b(true);
        return this;
    }

    public ht a(String str) {
        this.f522a = str;
        return this;
    }

    public ht a(Map<String, String> map) {
        this.f524a = map;
        return this;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m349a() {
        return this.f522a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public Map<String, String> m350a() {
        return this.f524a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m351a() {
        if (this.f522a == null) {
            throw new jd("Required field 'id' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ir
    public void a(jc jcVar) {
        jcVar.m455a();
        while (true) {
            iz m451a = jcVar.m451a();
            if (m451a.a == 0) {
                jcVar.f();
                if (!m356b()) {
                    throw new jd("Required field 'messageTs' was not found in serialized data! Struct: " + toString());
                }
                m351a();
                return;
            }
            switch (m451a.f788a) {
                case 1:
                    if (m451a.a == 11) {
                        this.f522a = jcVar.m456a();
                        break;
                    } else {
                        jf.a(jcVar, m451a.a);
                        break;
                    }
                case 2:
                    if (m451a.a == 10) {
                        this.f521a = jcVar.m450a();
                        a(true);
                        break;
                    } else {
                        jf.a(jcVar, m451a.a);
                        break;
                    }
                case 3:
                    if (m451a.a == 11) {
                        this.f527b = jcVar.m456a();
                        break;
                    } else {
                        jf.a(jcVar, m451a.a);
                        break;
                    }
                case 4:
                    if (m451a.a == 11) {
                        this.f530c = jcVar.m456a();
                        break;
                    } else {
                        jf.a(jcVar, m451a.a);
                        break;
                    }
                case 5:
                    if (m451a.a == 11) {
                        this.f532d = jcVar.m456a();
                        break;
                    } else {
                        jf.a(jcVar, m451a.a);
                        break;
                    }
                case 6:
                    if (m451a.a == 8) {
                        this.f520a = jcVar.m449a();
                        b(true);
                        break;
                    } else {
                        jf.a(jcVar, m451a.a);
                        break;
                    }
                case 7:
                    if (m451a.a == 11) {
                        this.f533e = jcVar.m456a();
                        break;
                    } else {
                        jf.a(jcVar, m451a.a);
                        break;
                    }
                case 8:
                    if (m451a.a == 8) {
                        this.f526b = jcVar.m449a();
                        c(true);
                        break;
                    } else {
                        jf.a(jcVar, m451a.a);
                        break;
                    }
                case 9:
                    if (m451a.a == 8) {
                        this.f529c = jcVar.m449a();
                        d(true);
                        break;
                    } else {
                        jf.a(jcVar, m451a.a);
                        break;
                    }
                case 10:
                    if (m451a.a == 13) {
                        jb m453a = jcVar.m453a();
                        this.f524a = new HashMap(m453a.f792a * 2);
                        for (int i2 = 0; i2 < m453a.f792a; i2++) {
                            this.f524a.put(jcVar.m456a(), jcVar.m456a());
                        }
                        jcVar.h();
                        break;
                    } else {
                        jf.a(jcVar, m451a.a);
                        break;
                    }
                case 11:
                    if (m451a.a == 13) {
                        jb m453a2 = jcVar.m453a();
                        this.f528b = new HashMap(m453a2.f792a * 2);
                        for (int i3 = 0; i3 < m453a2.f792a; i3++) {
                            this.f528b.put(jcVar.m456a(), jcVar.m456a());
                        }
                        jcVar.h();
                        break;
                    } else {
                        jf.a(jcVar, m451a.a);
                        break;
                    }
                case 12:
                    if (m451a.a == 2) {
                        this.f525a = jcVar.m460a();
                        e(true);
                        break;
                    } else {
                        jf.a(jcVar, m451a.a);
                        break;
                    }
                case 13:
                    if (m451a.a == 13) {
                        jb m453a3 = jcVar.m453a();
                        this.f531c = new HashMap(m453a3.f792a * 2);
                        for (int i4 = 0; i4 < m453a3.f792a; i4++) {
                            this.f531c.put(jcVar.m456a(), jcVar.m456a());
                        }
                        jcVar.h();
                        break;
                    } else {
                        jf.a(jcVar, m451a.a);
                        break;
                    }
                default:
                    jf.a(jcVar, m451a.a);
                    break;
            }
            jcVar.g();
        }
    }

    public void a(String str, String str2) {
        if (this.f524a == null) {
            this.f524a = new HashMap();
        }
        this.f524a.put(str, str2);
    }

    public void a(boolean z) {
        this.f523a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m352a() {
        return this.f522a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m353a(ht htVar) {
        if (htVar == null) {
            return false;
        }
        boolean m352a = m352a();
        boolean m352a2 = htVar.m352a();
        if (((m352a || m352a2) && !(m352a && m352a2 && this.f522a.equals(htVar.f522a))) || this.f521a != htVar.f521a) {
            return false;
        }
        boolean m358c = m358c();
        boolean m358c2 = htVar.m358c();
        if ((m358c || m358c2) && !(m358c && m358c2 && this.f527b.equals(htVar.f527b))) {
            return false;
        }
        boolean m359d = m359d();
        boolean m359d2 = htVar.m359d();
        if ((m359d || m359d2) && !(m359d && m359d2 && this.f530c.equals(htVar.f530c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = htVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f532d.equals(htVar.f532d))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = htVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f520a == htVar.f520a)) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = htVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f533e.equals(htVar.f533e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = htVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f526b == htVar.f526b)) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = htVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f529c == htVar.f529c)) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = htVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f524a.equals(htVar.f524a))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = htVar.k();
        if ((k2 || k3) && !(k2 && k3 && this.f528b.equals(htVar.f528b))) {
            return false;
        }
        boolean m2 = m();
        boolean m3 = htVar.m();
        if ((m2 || m3) && !(m2 && m3 && this.f525a == htVar.f525a)) {
            return false;
        }
        boolean n = n();
        boolean n2 = htVar.n();
        return !(n || n2) || (n && n2 && this.f531c.equals(htVar.f531c));
    }

    public int b() {
        return this.f526b;
    }

    public ht b(int i2) {
        this.f526b = i2;
        c(true);
        return this;
    }

    public ht b(String str) {
        this.f527b = str;
        return this;
    }

    /* renamed from: b  reason: collision with other method in class */
    public String m354b() {
        return this.f527b;
    }

    /* renamed from: b  reason: collision with other method in class */
    public Map<String, String> m355b() {
        return this.f528b;
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        m351a();
        jcVar.a(f519a);
        if (this.f522a != null) {
            jcVar.a(a);
            jcVar.a(this.f522a);
            jcVar.b();
        }
        jcVar.a(b);
        jcVar.a(this.f521a);
        jcVar.b();
        if (this.f527b != null && m358c()) {
            jcVar.a(c);
            jcVar.a(this.f527b);
            jcVar.b();
        }
        if (this.f530c != null && m359d()) {
            jcVar.a(d);
            jcVar.a(this.f530c);
            jcVar.b();
        }
        if (this.f532d != null && e()) {
            jcVar.a(e);
            jcVar.a(this.f532d);
            jcVar.b();
        }
        if (f()) {
            jcVar.a(f);
            jcVar.a(this.f520a);
            jcVar.b();
        }
        if (this.f533e != null && g()) {
            jcVar.a(g);
            jcVar.a(this.f533e);
            jcVar.b();
        }
        if (h()) {
            jcVar.a(h);
            jcVar.a(this.f526b);
            jcVar.b();
        }
        if (i()) {
            jcVar.a(i);
            jcVar.a(this.f529c);
            jcVar.b();
        }
        if (this.f524a != null && j()) {
            jcVar.a(j);
            jcVar.a(new jb(Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, this.f524a.size()));
            for (Map.Entry<String, String> entry : this.f524a.entrySet()) {
                jcVar.a(entry.getKey());
                jcVar.a(entry.getValue());
            }
            jcVar.d();
            jcVar.b();
        }
        if (this.f528b != null && k()) {
            jcVar.a(k);
            jcVar.a(new jb(Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, this.f528b.size()));
            for (Map.Entry<String, String> entry2 : this.f528b.entrySet()) {
                jcVar.a(entry2.getKey());
                jcVar.a(entry2.getValue());
            }
            jcVar.d();
            jcVar.b();
        }
        if (m()) {
            jcVar.a(l);
            jcVar.a(this.f525a);
            jcVar.b();
        }
        if (this.f531c != null && n()) {
            jcVar.a(m);
            jcVar.a(new jb(Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, this.f531c.size()));
            for (Map.Entry<String, String> entry3 : this.f531c.entrySet()) {
                jcVar.a(entry3.getKey());
                jcVar.a(entry3.getValue());
            }
            jcVar.d();
            jcVar.b();
        }
        jcVar.c();
        jcVar.m459a();
    }

    public void b(String str, String str2) {
        if (this.f528b == null) {
            this.f528b = new HashMap();
        }
        this.f528b.put(str, str2);
    }

    public void b(boolean z) {
        this.f523a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m356b() {
        return this.f523a.get(0);
    }

    public int c() {
        return this.f529c;
    }

    public ht c(int i2) {
        this.f529c = i2;
        d(true);
        return this;
    }

    public ht c(String str) {
        this.f530c = str;
        return this;
    }

    /* renamed from: c  reason: collision with other method in class */
    public String m357c() {
        return this.f530c;
    }

    public void c(boolean z) {
        this.f523a.set(2, z);
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m358c() {
        return this.f527b != null;
    }

    public ht d(String str) {
        this.f532d = str;
        return this;
    }

    public String d() {
        return this.f532d;
    }

    public void d(boolean z) {
        this.f523a.set(3, z);
    }

    /* renamed from: d  reason: collision with other method in class */
    public boolean m359d() {
        return this.f530c != null;
    }

    public void e(boolean z) {
        this.f523a.set(4, z);
    }

    public boolean e() {
        return this.f532d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ht)) {
            return m353a((ht) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f523a.get(1);
    }

    public boolean g() {
        return this.f533e != null;
    }

    public boolean h() {
        return this.f523a.get(2);
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f523a.get(3);
    }

    public boolean j() {
        return this.f524a != null;
    }

    public boolean k() {
        return this.f528b != null;
    }

    public boolean l() {
        return this.f525a;
    }

    public boolean m() {
        return this.f523a.get(4);
    }

    public boolean n() {
        return this.f531c != null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("PushMetaInfo(");
        sb.append("id:");
        if (this.f522a == null) {
            sb.append("null");
        } else {
            sb.append(this.f522a);
        }
        sb.append(", ");
        sb.append("messageTs:");
        sb.append(this.f521a);
        if (m358c()) {
            sb.append(", ");
            sb.append(UrlSchemaHelper.SCHEMA_TYPE_TOPIC);
            if (this.f527b == null) {
                sb.append("null");
            } else {
                sb.append(this.f527b);
            }
        }
        if (m359d()) {
            sb.append(", ");
            sb.append("title:");
            if (this.f530c == null) {
                sb.append("null");
            } else {
                sb.append(this.f530c);
            }
        }
        if (e()) {
            sb.append(", ");
            sb.append("description:");
            if (this.f532d == null) {
                sb.append("null");
            } else {
                sb.append(this.f532d);
            }
        }
        if (f()) {
            sb.append(", ");
            sb.append("notifyType:");
            sb.append(this.f520a);
        }
        if (g()) {
            sb.append(", ");
            sb.append("url:");
            if (this.f533e == null) {
                sb.append("null");
            } else {
                sb.append(this.f533e);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("passThrough:");
            sb.append(this.f526b);
        }
        if (i()) {
            sb.append(", ");
            sb.append("notifyId:");
            sb.append(this.f529c);
        }
        if (j()) {
            sb.append(", ");
            sb.append("extra:");
            if (this.f524a == null) {
                sb.append("null");
            } else {
                sb.append(this.f524a);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("internal:");
            if (this.f528b == null) {
                sb.append("null");
            } else {
                sb.append(this.f528b);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("ignoreRegInfo:");
            sb.append(this.f525a);
        }
        if (n()) {
            sb.append(", ");
            sb.append("apsProperFields:");
            if (this.f531c == null) {
                sb.append("null");
            } else {
                sb.append(this.f531c);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
