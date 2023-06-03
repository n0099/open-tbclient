package com.xiaomi.push;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.retry.HttpRetryStatistic;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes10.dex */
public class hu implements is<hu, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public int f539a;

    /* renamed from: a  reason: collision with other field name */
    public long f540a;

    /* renamed from: a  reason: collision with other field name */
    public String f541a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f542a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f543a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f544a;

    /* renamed from: b  reason: collision with other field name */
    public int f545b;

    /* renamed from: b  reason: collision with other field name */
    public String f546b;

    /* renamed from: b  reason: collision with other field name */
    public Map<String, String> f547b;

    /* renamed from: c  reason: collision with other field name */
    public int f548c;

    /* renamed from: c  reason: collision with other field name */
    public String f549c;

    /* renamed from: c  reason: collision with other field name */
    public Map<String, String> f550c;

    /* renamed from: d  reason: collision with other field name */
    public String f551d;

    /* renamed from: e  reason: collision with other field name */
    public String f552e;

    /* renamed from: a  reason: collision with other field name */
    public static final ji f538a = new ji("PushMetaInfo");
    public static final ja a = new ja("", Constants.GZIP_CAST_TYPE, 1);
    public static final ja b = new ja("", (byte) 10, 2);
    public static final ja c = new ja("", Constants.GZIP_CAST_TYPE, 3);
    public static final ja d = new ja("", Constants.GZIP_CAST_TYPE, 4);
    public static final ja e = new ja("", Constants.GZIP_CAST_TYPE, 5);
    public static final ja f = new ja("", (byte) 8, 6);
    public static final ja g = new ja("", Constants.GZIP_CAST_TYPE, 7);
    public static final ja h = new ja("", (byte) 8, 8);
    public static final ja i = new ja("", (byte) 8, 9);
    public static final ja j = new ja("", (byte) 13, 10);
    public static final ja k = new ja("", (byte) 13, 11);
    public static final ja l = new ja("", (byte) 2, 12);
    public static final ja m = new ja("", (byte) 13, 13);

    public hu() {
        this.f542a = new BitSet(5);
        this.f544a = false;
    }

    public hu(hu huVar) {
        BitSet bitSet = new BitSet(5);
        this.f542a = bitSet;
        bitSet.clear();
        this.f542a.or(huVar.f542a);
        if (huVar.m582a()) {
            this.f541a = huVar.f541a;
        }
        this.f540a = huVar.f540a;
        if (huVar.m588c()) {
            this.f546b = huVar.f546b;
        }
        if (huVar.m589d()) {
            this.f549c = huVar.f549c;
        }
        if (huVar.e()) {
            this.f551d = huVar.f551d;
        }
        this.f539a = huVar.f539a;
        if (huVar.g()) {
            this.f552e = huVar.f552e;
        }
        this.f545b = huVar.f545b;
        this.f548c = huVar.f548c;
        if (huVar.j()) {
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, String> entry : huVar.f543a.entrySet()) {
                hashMap.put(entry.getKey(), entry.getValue());
            }
            this.f543a = hashMap;
        }
        if (huVar.k()) {
            HashMap hashMap2 = new HashMap();
            for (Map.Entry<String, String> entry2 : huVar.f547b.entrySet()) {
                hashMap2.put(entry2.getKey(), entry2.getValue());
            }
            this.f547b = hashMap2;
        }
        this.f544a = huVar.f544a;
        if (huVar.n()) {
            HashMap hashMap3 = new HashMap();
            for (Map.Entry<String, String> entry3 : huVar.f550c.entrySet()) {
                hashMap3.put(entry3.getKey(), entry3.getValue());
            }
            this.f550c = hashMap3;
        }
    }

    public int a() {
        return this.f539a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(hu huVar) {
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
        if (hu.class.equals(huVar.getClass())) {
            int compareTo = Boolean.valueOf(m582a()).compareTo(Boolean.valueOf(huVar.m582a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m582a() || (a14 = it.a(this.f541a, huVar.f541a)) == 0) {
                int compareTo2 = Boolean.valueOf(m586b()).compareTo(Boolean.valueOf(huVar.m586b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!m586b() || (a13 = it.a(this.f540a, huVar.f540a)) == 0) {
                    int compareTo3 = Boolean.valueOf(m588c()).compareTo(Boolean.valueOf(huVar.m588c()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!m588c() || (a12 = it.a(this.f546b, huVar.f546b)) == 0) {
                        int compareTo4 = Boolean.valueOf(m589d()).compareTo(Boolean.valueOf(huVar.m589d()));
                        if (compareTo4 != 0) {
                            return compareTo4;
                        }
                        if (!m589d() || (a11 = it.a(this.f549c, huVar.f549c)) == 0) {
                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(huVar.e()));
                            if (compareTo5 != 0) {
                                return compareTo5;
                            }
                            if (!e() || (a10 = it.a(this.f551d, huVar.f551d)) == 0) {
                                int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(huVar.f()));
                                if (compareTo6 != 0) {
                                    return compareTo6;
                                }
                                if (!f() || (a9 = it.a(this.f539a, huVar.f539a)) == 0) {
                                    int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(huVar.g()));
                                    if (compareTo7 != 0) {
                                        return compareTo7;
                                    }
                                    if (!g() || (a8 = it.a(this.f552e, huVar.f552e)) == 0) {
                                        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(huVar.h()));
                                        if (compareTo8 != 0) {
                                            return compareTo8;
                                        }
                                        if (!h() || (a7 = it.a(this.f545b, huVar.f545b)) == 0) {
                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(huVar.i()));
                                            if (compareTo9 != 0) {
                                                return compareTo9;
                                            }
                                            if (!i() || (a6 = it.a(this.f548c, huVar.f548c)) == 0) {
                                                int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(huVar.j()));
                                                if (compareTo10 != 0) {
                                                    return compareTo10;
                                                }
                                                if (!j() || (a5 = it.a(this.f543a, huVar.f543a)) == 0) {
                                                    int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(huVar.k()));
                                                    if (compareTo11 != 0) {
                                                        return compareTo11;
                                                    }
                                                    if (!k() || (a4 = it.a(this.f547b, huVar.f547b)) == 0) {
                                                        int compareTo12 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(huVar.m()));
                                                        if (compareTo12 != 0) {
                                                            return compareTo12;
                                                        }
                                                        if (!m() || (a3 = it.a(this.f544a, huVar.f544a)) == 0) {
                                                            int compareTo13 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(huVar.n()));
                                                            if (compareTo13 != 0) {
                                                                return compareTo13;
                                                            }
                                                            if (!n() || (a2 = it.a(this.f550c, huVar.f550c)) == 0) {
                                                                return 0;
                                                            }
                                                            return a2;
                                                        }
                                                        return a3;
                                                    }
                                                    return a4;
                                                }
                                                return a5;
                                            }
                                            return a6;
                                        }
                                        return a7;
                                    }
                                    return a8;
                                }
                                return a9;
                            }
                            return a10;
                        }
                        return a11;
                    }
                    return a12;
                }
                return a13;
            }
            return a14;
        }
        return hu.class.getName().compareTo(huVar.getClass().getName());
    }

    /* renamed from: a  reason: collision with other method in class */
    public long m577a() {
        return this.f540a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public hu m578a() {
        return new hu(this);
    }

    public hu a(int i2) {
        this.f539a = i2;
        b(true);
        return this;
    }

    public hu a(String str) {
        this.f541a = str;
        return this;
    }

    public hu a(Map<String, String> map) {
        this.f543a = map;
        return this;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m579a() {
        return this.f541a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public Map<String, String> m580a() {
        return this.f543a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m581a() {
        if (this.f541a != null) {
            return;
        }
        throw new je("Required field 'id' was not present! Struct: " + toString());
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.xiaomi.push.is
    public void a(jd jdVar) {
        jdVar.mo695a();
        while (true) {
            ja mo691a = jdVar.mo691a();
            byte b2 = mo691a.a;
            if (b2 == 0) {
                jdVar.f();
                if (m586b()) {
                    m581a();
                    return;
                }
                throw new je("Required field 'messageTs' was not found in serialized data! Struct: " + toString());
            }
            int i2 = 0;
            switch (mo691a.f813a) {
                case 1:
                    if (b2 == 11) {
                        this.f541a = jdVar.mo696a();
                        break;
                    }
                    jg.a(jdVar, b2);
                    break;
                case 2:
                    if (b2 == 10) {
                        this.f540a = jdVar.mo690a();
                        a(true);
                        break;
                    }
                    jg.a(jdVar, b2);
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f546b = jdVar.mo696a();
                        break;
                    }
                    jg.a(jdVar, b2);
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f549c = jdVar.mo696a();
                        break;
                    }
                    jg.a(jdVar, b2);
                    break;
                case 5:
                    if (b2 == 11) {
                        this.f551d = jdVar.mo696a();
                        break;
                    }
                    jg.a(jdVar, b2);
                    break;
                case 6:
                    if (b2 == 8) {
                        this.f539a = jdVar.mo689a();
                        b(true);
                        break;
                    }
                    jg.a(jdVar, b2);
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f552e = jdVar.mo696a();
                        break;
                    }
                    jg.a(jdVar, b2);
                    break;
                case 8:
                    if (b2 == 8) {
                        this.f545b = jdVar.mo689a();
                        c(true);
                        break;
                    }
                    jg.a(jdVar, b2);
                    break;
                case 9:
                    if (b2 == 8) {
                        this.f548c = jdVar.mo689a();
                        d(true);
                        break;
                    }
                    jg.a(jdVar, b2);
                    break;
                case 10:
                    if (b2 == 13) {
                        jc mo693a = jdVar.mo693a();
                        this.f543a = new HashMap(mo693a.f815a * 2);
                        while (i2 < mo693a.f815a) {
                            this.f543a.put(jdVar.mo696a(), jdVar.mo696a());
                            i2++;
                        }
                        jdVar.h();
                        break;
                    }
                    jg.a(jdVar, b2);
                    break;
                case 11:
                    if (b2 == 13) {
                        jc mo693a2 = jdVar.mo693a();
                        this.f547b = new HashMap(mo693a2.f815a * 2);
                        while (i2 < mo693a2.f815a) {
                            this.f547b.put(jdVar.mo696a(), jdVar.mo696a());
                            i2++;
                        }
                        jdVar.h();
                        break;
                    }
                    jg.a(jdVar, b2);
                    break;
                case 12:
                    if (b2 == 2) {
                        this.f544a = jdVar.mo701a();
                        e(true);
                        break;
                    }
                    jg.a(jdVar, b2);
                    break;
                case 13:
                    if (b2 == 13) {
                        jc mo693a3 = jdVar.mo693a();
                        this.f550c = new HashMap(mo693a3.f815a * 2);
                        while (i2 < mo693a3.f815a) {
                            this.f550c.put(jdVar.mo696a(), jdVar.mo696a());
                            i2++;
                        }
                        jdVar.h();
                        break;
                    }
                    jg.a(jdVar, b2);
                    break;
                default:
                    jg.a(jdVar, b2);
                    break;
            }
            jdVar.g();
        }
    }

    public void a(String str, String str2) {
        if (this.f543a == null) {
            this.f543a = new HashMap();
        }
        this.f543a.put(str, str2);
    }

    public void a(boolean z) {
        this.f542a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m582a() {
        return this.f541a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m583a(hu huVar) {
        if (huVar == null) {
            return false;
        }
        boolean m582a = m582a();
        boolean m582a2 = huVar.m582a();
        if (((m582a || m582a2) && !(m582a && m582a2 && this.f541a.equals(huVar.f541a))) || this.f540a != huVar.f540a) {
            return false;
        }
        boolean m588c = m588c();
        boolean m588c2 = huVar.m588c();
        if ((m588c || m588c2) && !(m588c && m588c2 && this.f546b.equals(huVar.f546b))) {
            return false;
        }
        boolean m589d = m589d();
        boolean m589d2 = huVar.m589d();
        if ((m589d || m589d2) && !(m589d && m589d2 && this.f549c.equals(huVar.f549c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = huVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f551d.equals(huVar.f551d))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = huVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f539a == huVar.f539a)) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = huVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f552e.equals(huVar.f552e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = huVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f545b == huVar.f545b)) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = huVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f548c == huVar.f548c)) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = huVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f543a.equals(huVar.f543a))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = huVar.k();
        if ((k2 || k3) && !(k2 && k3 && this.f547b.equals(huVar.f547b))) {
            return false;
        }
        boolean m2 = m();
        boolean m3 = huVar.m();
        if ((m2 || m3) && !(m2 && m3 && this.f544a == huVar.f544a)) {
            return false;
        }
        boolean n = n();
        boolean n2 = huVar.n();
        if (n || n2) {
            return n && n2 && this.f550c.equals(huVar.f550c);
        }
        return true;
    }

    public int b() {
        return this.f545b;
    }

    public hu b(int i2) {
        this.f545b = i2;
        c(true);
        return this;
    }

    public hu b(String str) {
        this.f546b = str;
        return this;
    }

    /* renamed from: b  reason: collision with other method in class */
    public String m584b() {
        return this.f546b;
    }

    /* renamed from: b  reason: collision with other method in class */
    public Map<String, String> m585b() {
        return this.f547b;
    }

    @Override // com.xiaomi.push.is
    public void b(jd jdVar) {
        m581a();
        jdVar.a(f538a);
        if (this.f541a != null) {
            jdVar.a(a);
            jdVar.a(this.f541a);
            jdVar.b();
        }
        jdVar.a(b);
        jdVar.a(this.f540a);
        jdVar.b();
        if (this.f546b != null && m588c()) {
            jdVar.a(c);
            jdVar.a(this.f546b);
            jdVar.b();
        }
        if (this.f549c != null && m589d()) {
            jdVar.a(d);
            jdVar.a(this.f549c);
            jdVar.b();
        }
        if (this.f551d != null && e()) {
            jdVar.a(e);
            jdVar.a(this.f551d);
            jdVar.b();
        }
        if (f()) {
            jdVar.a(f);
            jdVar.mo700a(this.f539a);
            jdVar.b();
        }
        if (this.f552e != null && g()) {
            jdVar.a(g);
            jdVar.a(this.f552e);
            jdVar.b();
        }
        if (h()) {
            jdVar.a(h);
            jdVar.mo700a(this.f545b);
            jdVar.b();
        }
        if (i()) {
            jdVar.a(i);
            jdVar.mo700a(this.f548c);
            jdVar.b();
        }
        if (this.f543a != null && j()) {
            jdVar.a(j);
            jdVar.a(new jc(Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, this.f543a.size()));
            for (Map.Entry<String, String> entry : this.f543a.entrySet()) {
                jdVar.a(entry.getKey());
                jdVar.a(entry.getValue());
            }
            jdVar.d();
            jdVar.b();
        }
        if (this.f547b != null && k()) {
            jdVar.a(k);
            jdVar.a(new jc(Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, this.f547b.size()));
            for (Map.Entry<String, String> entry2 : this.f547b.entrySet()) {
                jdVar.a(entry2.getKey());
                jdVar.a(entry2.getValue());
            }
            jdVar.d();
            jdVar.b();
        }
        if (m()) {
            jdVar.a(l);
            jdVar.a(this.f544a);
            jdVar.b();
        }
        if (this.f550c != null && n()) {
            jdVar.a(m);
            jdVar.a(new jc(Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, this.f550c.size()));
            for (Map.Entry<String, String> entry3 : this.f550c.entrySet()) {
                jdVar.a(entry3.getKey());
                jdVar.a(entry3.getValue());
            }
            jdVar.d();
            jdVar.b();
        }
        jdVar.c();
        jdVar.mo699a();
    }

    public void b(String str, String str2) {
        if (this.f547b == null) {
            this.f547b = new HashMap();
        }
        this.f547b.put(str, str2);
    }

    public void b(boolean z) {
        this.f542a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m586b() {
        return this.f542a.get(0);
    }

    public int c() {
        return this.f548c;
    }

    public hu c(int i2) {
        this.f548c = i2;
        d(true);
        return this;
    }

    public hu c(String str) {
        this.f549c = str;
        return this;
    }

    /* renamed from: c  reason: collision with other method in class */
    public String m587c() {
        return this.f549c;
    }

    public void c(boolean z) {
        this.f542a.set(2, z);
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m588c() {
        return this.f546b != null;
    }

    public hu d(String str) {
        this.f551d = str;
        return this;
    }

    public String d() {
        return this.f551d;
    }

    public void d(boolean z) {
        this.f542a.set(3, z);
    }

    /* renamed from: d  reason: collision with other method in class */
    public boolean m589d() {
        return this.f549c != null;
    }

    public void e(boolean z) {
        this.f542a.set(4, z);
    }

    public boolean e() {
        return this.f551d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hu)) {
            return m583a((hu) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f542a.get(1);
    }

    public boolean g() {
        return this.f552e != null;
    }

    public boolean h() {
        return this.f542a.get(2);
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f542a.get(3);
    }

    public boolean j() {
        return this.f543a != null;
    }

    public boolean k() {
        return this.f547b != null;
    }

    public boolean l() {
        return this.f544a;
    }

    public boolean m() {
        return this.f542a.get(4);
    }

    public boolean n() {
        return this.f550c != null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("PushMetaInfo(");
        sb.append("id:");
        String str = this.f541a;
        if (str == null) {
            sb.append(StringUtil.NULL_STRING);
        } else {
            sb.append(com.xiaomi.push.service.bd.a(str));
        }
        sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        sb.append("messageTs:");
        sb.append(this.f540a);
        if (m588c()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append(UrlSchemaHelper.SCHEMA_TYPE_TOPIC);
            String str2 = this.f546b;
            if (str2 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str2);
            }
        }
        if (m589d()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("title:");
            String str3 = this.f549c;
            if (str3 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str3);
            }
        }
        if (e()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("description:");
            String str4 = this.f551d;
            if (str4 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str4);
            }
        }
        if (f()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("notifyType:");
            sb.append(this.f539a);
        }
        if (g()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append(HttpRetryStatistic.RETRY_URL);
            String str5 = this.f552e;
            if (str5 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str5);
            }
        }
        if (h()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("passThrough:");
            sb.append(this.f545b);
        }
        if (i()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("notifyId:");
            sb.append(this.f548c);
        }
        if (j()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("extra:");
            Map<String, String> map = this.f543a;
            if (map == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(map);
            }
        }
        if (k()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("internal:");
            Map<String, String> map2 = this.f547b;
            if (map2 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(map2);
            }
        }
        if (m()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("ignoreRegInfo:");
            sb.append(this.f544a);
        }
        if (n()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("apsProperFields:");
            Map<String, String> map3 = this.f550c;
            if (map3 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(map3);
            }
        }
        sb.append(SmallTailInfo.EMOTION_SUFFIX);
        return sb.toString();
    }
}
