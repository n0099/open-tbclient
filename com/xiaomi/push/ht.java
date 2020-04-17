package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes8.dex */
public class ht implements ir<ht, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public int f521a;

    /* renamed from: a  reason: collision with other field name */
    public long f522a;

    /* renamed from: a  reason: collision with other field name */
    public String f523a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f524a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f525a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f526a;

    /* renamed from: b  reason: collision with other field name */
    public int f527b;

    /* renamed from: b  reason: collision with other field name */
    public String f528b;

    /* renamed from: b  reason: collision with other field name */
    public Map<String, String> f529b;

    /* renamed from: c  reason: collision with other field name */
    public int f530c;

    /* renamed from: c  reason: collision with other field name */
    public String f531c;

    /* renamed from: c  reason: collision with other field name */
    public Map<String, String> f532c;

    /* renamed from: d  reason: collision with other field name */
    public String f533d;

    /* renamed from: e  reason: collision with other field name */
    public String f534e;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f520a = new jh("PushMetaInfo");
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
        this.f524a = new BitSet(5);
        this.f526a = false;
    }

    public ht(ht htVar) {
        this.f524a = new BitSet(5);
        this.f524a.clear();
        this.f524a.or(htVar.f524a);
        if (htVar.m372a()) {
            this.f523a = htVar.f523a;
        }
        this.f522a = htVar.f522a;
        if (htVar.m378c()) {
            this.f528b = htVar.f528b;
        }
        if (htVar.m379d()) {
            this.f531c = htVar.f531c;
        }
        if (htVar.e()) {
            this.f533d = htVar.f533d;
        }
        this.f521a = htVar.f521a;
        if (htVar.g()) {
            this.f534e = htVar.f534e;
        }
        this.f527b = htVar.f527b;
        this.f530c = htVar.f530c;
        if (htVar.j()) {
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, String> entry : htVar.f525a.entrySet()) {
                hashMap.put(entry.getKey(), entry.getValue());
            }
            this.f525a = hashMap;
        }
        if (htVar.k()) {
            HashMap hashMap2 = new HashMap();
            for (Map.Entry<String, String> entry2 : htVar.f529b.entrySet()) {
                hashMap2.put(entry2.getKey(), entry2.getValue());
            }
            this.f529b = hashMap2;
        }
        this.f526a = htVar.f526a;
        if (htVar.n()) {
            HashMap hashMap3 = new HashMap();
            for (Map.Entry<String, String> entry3 : htVar.f532c.entrySet()) {
                hashMap3.put(entry3.getKey(), entry3.getValue());
            }
            this.f532c = hashMap3;
        }
    }

    public int a() {
        return this.f521a;
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
            int compareTo = Boolean.valueOf(m372a()).compareTo(Boolean.valueOf(htVar.m372a()));
            if (compareTo == 0) {
                if (!m372a() || (a14 = is.a(this.f523a, htVar.f523a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m376b()).compareTo(Boolean.valueOf(htVar.m376b()));
                    if (compareTo2 == 0) {
                        if (!m376b() || (a13 = is.a(this.f522a, htVar.f522a)) == 0) {
                            int compareTo3 = Boolean.valueOf(m378c()).compareTo(Boolean.valueOf(htVar.m378c()));
                            if (compareTo3 == 0) {
                                if (!m378c() || (a12 = is.a(this.f528b, htVar.f528b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(m379d()).compareTo(Boolean.valueOf(htVar.m379d()));
                                    if (compareTo4 == 0) {
                                        if (!m379d() || (a11 = is.a(this.f531c, htVar.f531c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(htVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a10 = is.a(this.f533d, htVar.f533d)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(htVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a9 = is.a(this.f521a, htVar.f521a)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(htVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a8 = is.a(this.f534e, htVar.f534e)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(htVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a7 = is.a(this.f527b, htVar.f527b)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(htVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a6 = is.a(this.f530c, htVar.f530c)) == 0) {
                                                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(htVar.j()));
                                                                                    if (compareTo10 == 0) {
                                                                                        if (!j() || (a5 = is.a(this.f525a, htVar.f525a)) == 0) {
                                                                                            int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(htVar.k()));
                                                                                            if (compareTo11 == 0) {
                                                                                                if (!k() || (a4 = is.a(this.f529b, htVar.f529b)) == 0) {
                                                                                                    int compareTo12 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(htVar.m()));
                                                                                                    if (compareTo12 == 0) {
                                                                                                        if (!m() || (a3 = is.a(this.f526a, htVar.f526a)) == 0) {
                                                                                                            int compareTo13 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(htVar.n()));
                                                                                                            if (compareTo13 == 0) {
                                                                                                                if (!n() || (a2 = is.a(this.f532c, htVar.f532c)) == 0) {
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
    public long m367a() {
        return this.f522a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public ht m368a() {
        return new ht(this);
    }

    public ht a(int i2) {
        this.f521a = i2;
        b(true);
        return this;
    }

    public ht a(String str) {
        this.f523a = str;
        return this;
    }

    public ht a(Map<String, String> map) {
        this.f525a = map;
        return this;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m369a() {
        return this.f523a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public Map<String, String> m370a() {
        return this.f525a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m371a() {
        if (this.f523a == null) {
            throw new jd("Required field 'id' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ir
    public void a(jc jcVar) {
        jcVar.m475a();
        while (true) {
            iz m471a = jcVar.m471a();
            if (m471a.a == 0) {
                jcVar.f();
                if (!m376b()) {
                    throw new jd("Required field 'messageTs' was not found in serialized data! Struct: " + toString());
                }
                m371a();
                return;
            }
            switch (m471a.f789a) {
                case 1:
                    if (m471a.a == 11) {
                        this.f523a = jcVar.m476a();
                        break;
                    } else {
                        jf.a(jcVar, m471a.a);
                        break;
                    }
                case 2:
                    if (m471a.a == 10) {
                        this.f522a = jcVar.m470a();
                        a(true);
                        break;
                    } else {
                        jf.a(jcVar, m471a.a);
                        break;
                    }
                case 3:
                    if (m471a.a == 11) {
                        this.f528b = jcVar.m476a();
                        break;
                    } else {
                        jf.a(jcVar, m471a.a);
                        break;
                    }
                case 4:
                    if (m471a.a == 11) {
                        this.f531c = jcVar.m476a();
                        break;
                    } else {
                        jf.a(jcVar, m471a.a);
                        break;
                    }
                case 5:
                    if (m471a.a == 11) {
                        this.f533d = jcVar.m476a();
                        break;
                    } else {
                        jf.a(jcVar, m471a.a);
                        break;
                    }
                case 6:
                    if (m471a.a == 8) {
                        this.f521a = jcVar.m469a();
                        b(true);
                        break;
                    } else {
                        jf.a(jcVar, m471a.a);
                        break;
                    }
                case 7:
                    if (m471a.a == 11) {
                        this.f534e = jcVar.m476a();
                        break;
                    } else {
                        jf.a(jcVar, m471a.a);
                        break;
                    }
                case 8:
                    if (m471a.a == 8) {
                        this.f527b = jcVar.m469a();
                        c(true);
                        break;
                    } else {
                        jf.a(jcVar, m471a.a);
                        break;
                    }
                case 9:
                    if (m471a.a == 8) {
                        this.f530c = jcVar.m469a();
                        d(true);
                        break;
                    } else {
                        jf.a(jcVar, m471a.a);
                        break;
                    }
                case 10:
                    if (m471a.a == 13) {
                        jb m473a = jcVar.m473a();
                        this.f525a = new HashMap(m473a.f793a * 2);
                        for (int i2 = 0; i2 < m473a.f793a; i2++) {
                            this.f525a.put(jcVar.m476a(), jcVar.m476a());
                        }
                        jcVar.h();
                        break;
                    } else {
                        jf.a(jcVar, m471a.a);
                        break;
                    }
                case 11:
                    if (m471a.a == 13) {
                        jb m473a2 = jcVar.m473a();
                        this.f529b = new HashMap(m473a2.f793a * 2);
                        for (int i3 = 0; i3 < m473a2.f793a; i3++) {
                            this.f529b.put(jcVar.m476a(), jcVar.m476a());
                        }
                        jcVar.h();
                        break;
                    } else {
                        jf.a(jcVar, m471a.a);
                        break;
                    }
                case 12:
                    if (m471a.a == 2) {
                        this.f526a = jcVar.m480a();
                        e(true);
                        break;
                    } else {
                        jf.a(jcVar, m471a.a);
                        break;
                    }
                case 13:
                    if (m471a.a == 13) {
                        jb m473a3 = jcVar.m473a();
                        this.f532c = new HashMap(m473a3.f793a * 2);
                        for (int i4 = 0; i4 < m473a3.f793a; i4++) {
                            this.f532c.put(jcVar.m476a(), jcVar.m476a());
                        }
                        jcVar.h();
                        break;
                    } else {
                        jf.a(jcVar, m471a.a);
                        break;
                    }
                default:
                    jf.a(jcVar, m471a.a);
                    break;
            }
            jcVar.g();
        }
    }

    public void a(String str, String str2) {
        if (this.f525a == null) {
            this.f525a = new HashMap();
        }
        this.f525a.put(str, str2);
    }

    public void a(boolean z) {
        this.f524a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m372a() {
        return this.f523a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m373a(ht htVar) {
        if (htVar == null) {
            return false;
        }
        boolean m372a = m372a();
        boolean m372a2 = htVar.m372a();
        if (((m372a || m372a2) && !(m372a && m372a2 && this.f523a.equals(htVar.f523a))) || this.f522a != htVar.f522a) {
            return false;
        }
        boolean m378c = m378c();
        boolean m378c2 = htVar.m378c();
        if ((m378c || m378c2) && !(m378c && m378c2 && this.f528b.equals(htVar.f528b))) {
            return false;
        }
        boolean m379d = m379d();
        boolean m379d2 = htVar.m379d();
        if ((m379d || m379d2) && !(m379d && m379d2 && this.f531c.equals(htVar.f531c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = htVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f533d.equals(htVar.f533d))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = htVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f521a == htVar.f521a)) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = htVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f534e.equals(htVar.f534e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = htVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f527b == htVar.f527b)) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = htVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f530c == htVar.f530c)) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = htVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f525a.equals(htVar.f525a))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = htVar.k();
        if ((k2 || k3) && !(k2 && k3 && this.f529b.equals(htVar.f529b))) {
            return false;
        }
        boolean m2 = m();
        boolean m3 = htVar.m();
        if ((m2 || m3) && !(m2 && m3 && this.f526a == htVar.f526a)) {
            return false;
        }
        boolean n = n();
        boolean n2 = htVar.n();
        return !(n || n2) || (n && n2 && this.f532c.equals(htVar.f532c));
    }

    public int b() {
        return this.f527b;
    }

    public ht b(int i2) {
        this.f527b = i2;
        c(true);
        return this;
    }

    public ht b(String str) {
        this.f528b = str;
        return this;
    }

    /* renamed from: b  reason: collision with other method in class */
    public String m374b() {
        return this.f528b;
    }

    /* renamed from: b  reason: collision with other method in class */
    public Map<String, String> m375b() {
        return this.f529b;
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        m371a();
        jcVar.a(f520a);
        if (this.f523a != null) {
            jcVar.a(a);
            jcVar.a(this.f523a);
            jcVar.b();
        }
        jcVar.a(b);
        jcVar.a(this.f522a);
        jcVar.b();
        if (this.f528b != null && m378c()) {
            jcVar.a(c);
            jcVar.a(this.f528b);
            jcVar.b();
        }
        if (this.f531c != null && m379d()) {
            jcVar.a(d);
            jcVar.a(this.f531c);
            jcVar.b();
        }
        if (this.f533d != null && e()) {
            jcVar.a(e);
            jcVar.a(this.f533d);
            jcVar.b();
        }
        if (f()) {
            jcVar.a(f);
            jcVar.a(this.f521a);
            jcVar.b();
        }
        if (this.f534e != null && g()) {
            jcVar.a(g);
            jcVar.a(this.f534e);
            jcVar.b();
        }
        if (h()) {
            jcVar.a(h);
            jcVar.a(this.f527b);
            jcVar.b();
        }
        if (i()) {
            jcVar.a(i);
            jcVar.a(this.f530c);
            jcVar.b();
        }
        if (this.f525a != null && j()) {
            jcVar.a(j);
            jcVar.a(new jb(Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, this.f525a.size()));
            for (Map.Entry<String, String> entry : this.f525a.entrySet()) {
                jcVar.a(entry.getKey());
                jcVar.a(entry.getValue());
            }
            jcVar.d();
            jcVar.b();
        }
        if (this.f529b != null && k()) {
            jcVar.a(k);
            jcVar.a(new jb(Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, this.f529b.size()));
            for (Map.Entry<String, String> entry2 : this.f529b.entrySet()) {
                jcVar.a(entry2.getKey());
                jcVar.a(entry2.getValue());
            }
            jcVar.d();
            jcVar.b();
        }
        if (m()) {
            jcVar.a(l);
            jcVar.a(this.f526a);
            jcVar.b();
        }
        if (this.f532c != null && n()) {
            jcVar.a(m);
            jcVar.a(new jb(Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, this.f532c.size()));
            for (Map.Entry<String, String> entry3 : this.f532c.entrySet()) {
                jcVar.a(entry3.getKey());
                jcVar.a(entry3.getValue());
            }
            jcVar.d();
            jcVar.b();
        }
        jcVar.c();
        jcVar.m479a();
    }

    public void b(String str, String str2) {
        if (this.f529b == null) {
            this.f529b = new HashMap();
        }
        this.f529b.put(str, str2);
    }

    public void b(boolean z) {
        this.f524a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m376b() {
        return this.f524a.get(0);
    }

    public int c() {
        return this.f530c;
    }

    public ht c(int i2) {
        this.f530c = i2;
        d(true);
        return this;
    }

    public ht c(String str) {
        this.f531c = str;
        return this;
    }

    /* renamed from: c  reason: collision with other method in class */
    public String m377c() {
        return this.f531c;
    }

    public void c(boolean z) {
        this.f524a.set(2, z);
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m378c() {
        return this.f528b != null;
    }

    public ht d(String str) {
        this.f533d = str;
        return this;
    }

    public String d() {
        return this.f533d;
    }

    public void d(boolean z) {
        this.f524a.set(3, z);
    }

    /* renamed from: d  reason: collision with other method in class */
    public boolean m379d() {
        return this.f531c != null;
    }

    public void e(boolean z) {
        this.f524a.set(4, z);
    }

    public boolean e() {
        return this.f533d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ht)) {
            return m373a((ht) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f524a.get(1);
    }

    public boolean g() {
        return this.f534e != null;
    }

    public boolean h() {
        return this.f524a.get(2);
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f524a.get(3);
    }

    public boolean j() {
        return this.f525a != null;
    }

    public boolean k() {
        return this.f529b != null;
    }

    public boolean l() {
        return this.f526a;
    }

    public boolean m() {
        return this.f524a.get(4);
    }

    public boolean n() {
        return this.f532c != null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("PushMetaInfo(");
        sb.append("id:");
        if (this.f523a == null) {
            sb.append("null");
        } else {
            sb.append(this.f523a);
        }
        sb.append(", ");
        sb.append("messageTs:");
        sb.append(this.f522a);
        if (m378c()) {
            sb.append(", ");
            sb.append(UrlSchemaHelper.SCHEMA_TYPE_TOPIC);
            if (this.f528b == null) {
                sb.append("null");
            } else {
                sb.append(this.f528b);
            }
        }
        if (m379d()) {
            sb.append(", ");
            sb.append("title:");
            if (this.f531c == null) {
                sb.append("null");
            } else {
                sb.append(this.f531c);
            }
        }
        if (e()) {
            sb.append(", ");
            sb.append("description:");
            if (this.f533d == null) {
                sb.append("null");
            } else {
                sb.append(this.f533d);
            }
        }
        if (f()) {
            sb.append(", ");
            sb.append("notifyType:");
            sb.append(this.f521a);
        }
        if (g()) {
            sb.append(", ");
            sb.append("url:");
            if (this.f534e == null) {
                sb.append("null");
            } else {
                sb.append(this.f534e);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("passThrough:");
            sb.append(this.f527b);
        }
        if (i()) {
            sb.append(", ");
            sb.append("notifyId:");
            sb.append(this.f530c);
        }
        if (j()) {
            sb.append(", ");
            sb.append("extra:");
            if (this.f525a == null) {
                sb.append("null");
            } else {
                sb.append(this.f525a);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("internal:");
            if (this.f529b == null) {
                sb.append("null");
            } else {
                sb.append(this.f529b);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("ignoreRegInfo:");
            sb.append(this.f526a);
        }
        if (n()) {
            sb.append(", ");
            sb.append("apsProperFields:");
            if (this.f532c == null) {
                sb.append("null");
            } else {
                sb.append(this.f532c);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
