package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class ht implements ir<ht, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public int f523a;

    /* renamed from: a  reason: collision with other field name */
    public long f524a;

    /* renamed from: a  reason: collision with other field name */
    public String f525a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f526a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f527a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f528a;

    /* renamed from: b  reason: collision with other field name */
    public int f529b;

    /* renamed from: b  reason: collision with other field name */
    public String f530b;

    /* renamed from: b  reason: collision with other field name */
    public Map<String, String> f531b;

    /* renamed from: c  reason: collision with other field name */
    public int f532c;

    /* renamed from: c  reason: collision with other field name */
    public String f533c;

    /* renamed from: c  reason: collision with other field name */
    public Map<String, String> f534c;

    /* renamed from: d  reason: collision with other field name */
    public String f535d;

    /* renamed from: e  reason: collision with other field name */
    public String f536e;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f522a = new jh("PushMetaInfo");
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
        this.f526a = new BitSet(5);
        this.f528a = false;
    }

    public ht(ht htVar) {
        this.f526a = new BitSet(5);
        this.f526a.clear();
        this.f526a.or(htVar.f526a);
        if (htVar.m364a()) {
            this.f525a = htVar.f525a;
        }
        this.f524a = htVar.f524a;
        if (htVar.m370c()) {
            this.f530b = htVar.f530b;
        }
        if (htVar.m371d()) {
            this.f533c = htVar.f533c;
        }
        if (htVar.e()) {
            this.f535d = htVar.f535d;
        }
        this.f523a = htVar.f523a;
        if (htVar.g()) {
            this.f536e = htVar.f536e;
        }
        this.f529b = htVar.f529b;
        this.f532c = htVar.f532c;
        if (htVar.j()) {
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, String> entry : htVar.f527a.entrySet()) {
                hashMap.put(entry.getKey(), entry.getValue());
            }
            this.f527a = hashMap;
        }
        if (htVar.k()) {
            HashMap hashMap2 = new HashMap();
            for (Map.Entry<String, String> entry2 : htVar.f531b.entrySet()) {
                hashMap2.put(entry2.getKey(), entry2.getValue());
            }
            this.f531b = hashMap2;
        }
        this.f528a = htVar.f528a;
        if (htVar.n()) {
            HashMap hashMap3 = new HashMap();
            for (Map.Entry<String, String> entry3 : htVar.f534c.entrySet()) {
                hashMap3.put(entry3.getKey(), entry3.getValue());
            }
            this.f534c = hashMap3;
        }
    }

    public int a() {
        return this.f523a;
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
            int compareTo = Boolean.valueOf(m364a()).compareTo(Boolean.valueOf(htVar.m364a()));
            if (compareTo == 0) {
                if (!m364a() || (a14 = is.a(this.f525a, htVar.f525a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m368b()).compareTo(Boolean.valueOf(htVar.m368b()));
                    if (compareTo2 == 0) {
                        if (!m368b() || (a13 = is.a(this.f524a, htVar.f524a)) == 0) {
                            int compareTo3 = Boolean.valueOf(m370c()).compareTo(Boolean.valueOf(htVar.m370c()));
                            if (compareTo3 == 0) {
                                if (!m370c() || (a12 = is.a(this.f530b, htVar.f530b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(m371d()).compareTo(Boolean.valueOf(htVar.m371d()));
                                    if (compareTo4 == 0) {
                                        if (!m371d() || (a11 = is.a(this.f533c, htVar.f533c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(htVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a10 = is.a(this.f535d, htVar.f535d)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(htVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a9 = is.a(this.f523a, htVar.f523a)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(htVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a8 = is.a(this.f536e, htVar.f536e)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(htVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a7 = is.a(this.f529b, htVar.f529b)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(htVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a6 = is.a(this.f532c, htVar.f532c)) == 0) {
                                                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(htVar.j()));
                                                                                    if (compareTo10 == 0) {
                                                                                        if (!j() || (a5 = is.a(this.f527a, htVar.f527a)) == 0) {
                                                                                            int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(htVar.k()));
                                                                                            if (compareTo11 == 0) {
                                                                                                if (!k() || (a4 = is.a(this.f531b, htVar.f531b)) == 0) {
                                                                                                    int compareTo12 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(htVar.m()));
                                                                                                    if (compareTo12 == 0) {
                                                                                                        if (!m() || (a3 = is.a(this.f528a, htVar.f528a)) == 0) {
                                                                                                            int compareTo13 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(htVar.n()));
                                                                                                            if (compareTo13 == 0) {
                                                                                                                if (!n() || (a2 = is.a(this.f534c, htVar.f534c)) == 0) {
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
    public long m359a() {
        return this.f524a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public ht m360a() {
        return new ht(this);
    }

    public ht a(int i2) {
        this.f523a = i2;
        b(true);
        return this;
    }

    public ht a(String str) {
        this.f525a = str;
        return this;
    }

    public ht a(Map<String, String> map) {
        this.f527a = map;
        return this;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m361a() {
        return this.f525a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public Map<String, String> m362a() {
        return this.f527a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m363a() {
        if (this.f525a == null) {
            throw new jd("Required field 'id' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ir
    public void a(jc jcVar) {
        jcVar.m467a();
        while (true) {
            iz m463a = jcVar.m463a();
            if (m463a.a == 0) {
                jcVar.f();
                if (!m368b()) {
                    throw new jd("Required field 'messageTs' was not found in serialized data! Struct: " + toString());
                }
                m363a();
                return;
            }
            switch (m463a.f791a) {
                case 1:
                    if (m463a.a == 11) {
                        this.f525a = jcVar.m468a();
                        break;
                    } else {
                        jf.a(jcVar, m463a.a);
                        break;
                    }
                case 2:
                    if (m463a.a == 10) {
                        this.f524a = jcVar.m462a();
                        a(true);
                        break;
                    } else {
                        jf.a(jcVar, m463a.a);
                        break;
                    }
                case 3:
                    if (m463a.a == 11) {
                        this.f530b = jcVar.m468a();
                        break;
                    } else {
                        jf.a(jcVar, m463a.a);
                        break;
                    }
                case 4:
                    if (m463a.a == 11) {
                        this.f533c = jcVar.m468a();
                        break;
                    } else {
                        jf.a(jcVar, m463a.a);
                        break;
                    }
                case 5:
                    if (m463a.a == 11) {
                        this.f535d = jcVar.m468a();
                        break;
                    } else {
                        jf.a(jcVar, m463a.a);
                        break;
                    }
                case 6:
                    if (m463a.a == 8) {
                        this.f523a = jcVar.m461a();
                        b(true);
                        break;
                    } else {
                        jf.a(jcVar, m463a.a);
                        break;
                    }
                case 7:
                    if (m463a.a == 11) {
                        this.f536e = jcVar.m468a();
                        break;
                    } else {
                        jf.a(jcVar, m463a.a);
                        break;
                    }
                case 8:
                    if (m463a.a == 8) {
                        this.f529b = jcVar.m461a();
                        c(true);
                        break;
                    } else {
                        jf.a(jcVar, m463a.a);
                        break;
                    }
                case 9:
                    if (m463a.a == 8) {
                        this.f532c = jcVar.m461a();
                        d(true);
                        break;
                    } else {
                        jf.a(jcVar, m463a.a);
                        break;
                    }
                case 10:
                    if (m463a.a == 13) {
                        jb m465a = jcVar.m465a();
                        this.f527a = new HashMap(m465a.f795a * 2);
                        for (int i2 = 0; i2 < m465a.f795a; i2++) {
                            this.f527a.put(jcVar.m468a(), jcVar.m468a());
                        }
                        jcVar.h();
                        break;
                    } else {
                        jf.a(jcVar, m463a.a);
                        break;
                    }
                case 11:
                    if (m463a.a == 13) {
                        jb m465a2 = jcVar.m465a();
                        this.f531b = new HashMap(m465a2.f795a * 2);
                        for (int i3 = 0; i3 < m465a2.f795a; i3++) {
                            this.f531b.put(jcVar.m468a(), jcVar.m468a());
                        }
                        jcVar.h();
                        break;
                    } else {
                        jf.a(jcVar, m463a.a);
                        break;
                    }
                case 12:
                    if (m463a.a == 2) {
                        this.f528a = jcVar.m472a();
                        e(true);
                        break;
                    } else {
                        jf.a(jcVar, m463a.a);
                        break;
                    }
                case 13:
                    if (m463a.a == 13) {
                        jb m465a3 = jcVar.m465a();
                        this.f534c = new HashMap(m465a3.f795a * 2);
                        for (int i4 = 0; i4 < m465a3.f795a; i4++) {
                            this.f534c.put(jcVar.m468a(), jcVar.m468a());
                        }
                        jcVar.h();
                        break;
                    } else {
                        jf.a(jcVar, m463a.a);
                        break;
                    }
                default:
                    jf.a(jcVar, m463a.a);
                    break;
            }
            jcVar.g();
        }
    }

    public void a(String str, String str2) {
        if (this.f527a == null) {
            this.f527a = new HashMap();
        }
        this.f527a.put(str, str2);
    }

    public void a(boolean z) {
        this.f526a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m364a() {
        return this.f525a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m365a(ht htVar) {
        if (htVar == null) {
            return false;
        }
        boolean m364a = m364a();
        boolean m364a2 = htVar.m364a();
        if (((m364a || m364a2) && !(m364a && m364a2 && this.f525a.equals(htVar.f525a))) || this.f524a != htVar.f524a) {
            return false;
        }
        boolean m370c = m370c();
        boolean m370c2 = htVar.m370c();
        if ((m370c || m370c2) && !(m370c && m370c2 && this.f530b.equals(htVar.f530b))) {
            return false;
        }
        boolean m371d = m371d();
        boolean m371d2 = htVar.m371d();
        if ((m371d || m371d2) && !(m371d && m371d2 && this.f533c.equals(htVar.f533c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = htVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f535d.equals(htVar.f535d))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = htVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f523a == htVar.f523a)) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = htVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f536e.equals(htVar.f536e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = htVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f529b == htVar.f529b)) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = htVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f532c == htVar.f532c)) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = htVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f527a.equals(htVar.f527a))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = htVar.k();
        if ((k2 || k3) && !(k2 && k3 && this.f531b.equals(htVar.f531b))) {
            return false;
        }
        boolean m2 = m();
        boolean m3 = htVar.m();
        if ((m2 || m3) && !(m2 && m3 && this.f528a == htVar.f528a)) {
            return false;
        }
        boolean n = n();
        boolean n2 = htVar.n();
        return !(n || n2) || (n && n2 && this.f534c.equals(htVar.f534c));
    }

    public int b() {
        return this.f529b;
    }

    public ht b(int i2) {
        this.f529b = i2;
        c(true);
        return this;
    }

    public ht b(String str) {
        this.f530b = str;
        return this;
    }

    /* renamed from: b  reason: collision with other method in class */
    public String m366b() {
        return this.f530b;
    }

    /* renamed from: b  reason: collision with other method in class */
    public Map<String, String> m367b() {
        return this.f531b;
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        m363a();
        jcVar.a(f522a);
        if (this.f525a != null) {
            jcVar.a(a);
            jcVar.a(this.f525a);
            jcVar.b();
        }
        jcVar.a(b);
        jcVar.a(this.f524a);
        jcVar.b();
        if (this.f530b != null && m370c()) {
            jcVar.a(c);
            jcVar.a(this.f530b);
            jcVar.b();
        }
        if (this.f533c != null && m371d()) {
            jcVar.a(d);
            jcVar.a(this.f533c);
            jcVar.b();
        }
        if (this.f535d != null && e()) {
            jcVar.a(e);
            jcVar.a(this.f535d);
            jcVar.b();
        }
        if (f()) {
            jcVar.a(f);
            jcVar.a(this.f523a);
            jcVar.b();
        }
        if (this.f536e != null && g()) {
            jcVar.a(g);
            jcVar.a(this.f536e);
            jcVar.b();
        }
        if (h()) {
            jcVar.a(h);
            jcVar.a(this.f529b);
            jcVar.b();
        }
        if (i()) {
            jcVar.a(i);
            jcVar.a(this.f532c);
            jcVar.b();
        }
        if (this.f527a != null && j()) {
            jcVar.a(j);
            jcVar.a(new jb(Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, this.f527a.size()));
            for (Map.Entry<String, String> entry : this.f527a.entrySet()) {
                jcVar.a(entry.getKey());
                jcVar.a(entry.getValue());
            }
            jcVar.d();
            jcVar.b();
        }
        if (this.f531b != null && k()) {
            jcVar.a(k);
            jcVar.a(new jb(Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, this.f531b.size()));
            for (Map.Entry<String, String> entry2 : this.f531b.entrySet()) {
                jcVar.a(entry2.getKey());
                jcVar.a(entry2.getValue());
            }
            jcVar.d();
            jcVar.b();
        }
        if (m()) {
            jcVar.a(l);
            jcVar.a(this.f528a);
            jcVar.b();
        }
        if (this.f534c != null && n()) {
            jcVar.a(m);
            jcVar.a(new jb(Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, this.f534c.size()));
            for (Map.Entry<String, String> entry3 : this.f534c.entrySet()) {
                jcVar.a(entry3.getKey());
                jcVar.a(entry3.getValue());
            }
            jcVar.d();
            jcVar.b();
        }
        jcVar.c();
        jcVar.m471a();
    }

    public void b(String str, String str2) {
        if (this.f531b == null) {
            this.f531b = new HashMap();
        }
        this.f531b.put(str, str2);
    }

    public void b(boolean z) {
        this.f526a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m368b() {
        return this.f526a.get(0);
    }

    public int c() {
        return this.f532c;
    }

    public ht c(int i2) {
        this.f532c = i2;
        d(true);
        return this;
    }

    public ht c(String str) {
        this.f533c = str;
        return this;
    }

    /* renamed from: c  reason: collision with other method in class */
    public String m369c() {
        return this.f533c;
    }

    public void c(boolean z) {
        this.f526a.set(2, z);
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m370c() {
        return this.f530b != null;
    }

    public ht d(String str) {
        this.f535d = str;
        return this;
    }

    public String d() {
        return this.f535d;
    }

    public void d(boolean z) {
        this.f526a.set(3, z);
    }

    /* renamed from: d  reason: collision with other method in class */
    public boolean m371d() {
        return this.f533c != null;
    }

    public void e(boolean z) {
        this.f526a.set(4, z);
    }

    public boolean e() {
        return this.f535d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ht)) {
            return m365a((ht) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f526a.get(1);
    }

    public boolean g() {
        return this.f536e != null;
    }

    public boolean h() {
        return this.f526a.get(2);
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f526a.get(3);
    }

    public boolean j() {
        return this.f527a != null;
    }

    public boolean k() {
        return this.f531b != null;
    }

    public boolean l() {
        return this.f528a;
    }

    public boolean m() {
        return this.f526a.get(4);
    }

    public boolean n() {
        return this.f534c != null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("PushMetaInfo(");
        sb.append("id:");
        if (this.f525a == null) {
            sb.append("null");
        } else {
            sb.append(this.f525a);
        }
        sb.append(", ");
        sb.append("messageTs:");
        sb.append(this.f524a);
        if (m370c()) {
            sb.append(", ");
            sb.append(UrlSchemaHelper.SCHEMA_TYPE_TOPIC);
            if (this.f530b == null) {
                sb.append("null");
            } else {
                sb.append(this.f530b);
            }
        }
        if (m371d()) {
            sb.append(", ");
            sb.append("title:");
            if (this.f533c == null) {
                sb.append("null");
            } else {
                sb.append(this.f533c);
            }
        }
        if (e()) {
            sb.append(", ");
            sb.append("description:");
            if (this.f535d == null) {
                sb.append("null");
            } else {
                sb.append(this.f535d);
            }
        }
        if (f()) {
            sb.append(", ");
            sb.append("notifyType:");
            sb.append(this.f523a);
        }
        if (g()) {
            sb.append(", ");
            sb.append("url:");
            if (this.f536e == null) {
                sb.append("null");
            } else {
                sb.append(this.f536e);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("passThrough:");
            sb.append(this.f529b);
        }
        if (i()) {
            sb.append(", ");
            sb.append("notifyId:");
            sb.append(this.f532c);
        }
        if (j()) {
            sb.append(", ");
            sb.append("extra:");
            if (this.f527a == null) {
                sb.append("null");
            } else {
                sb.append(this.f527a);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("internal:");
            if (this.f531b == null) {
                sb.append("null");
            } else {
                sb.append(this.f531b);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("ignoreRegInfo:");
            sb.append(this.f528a);
        }
        if (n()) {
            sb.append(", ");
            sb.append("apsProperFields:");
            if (this.f534c == null) {
                sb.append("null");
            } else {
                sb.append(this.f534c);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
