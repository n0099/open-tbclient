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
    public int f540a;

    /* renamed from: a  reason: collision with other field name */
    public long f541a;

    /* renamed from: a  reason: collision with other field name */
    public String f542a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f543a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f544a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f545a;

    /* renamed from: b  reason: collision with other field name */
    public int f546b;

    /* renamed from: b  reason: collision with other field name */
    public String f547b;

    /* renamed from: b  reason: collision with other field name */
    public Map<String, String> f548b;

    /* renamed from: c  reason: collision with other field name */
    public int f549c;

    /* renamed from: c  reason: collision with other field name */
    public String f550c;

    /* renamed from: c  reason: collision with other field name */
    public Map<String, String> f551c;

    /* renamed from: d  reason: collision with other field name */
    public String f552d;

    /* renamed from: e  reason: collision with other field name */
    public String f553e;

    /* renamed from: a  reason: collision with other field name */
    public static final ji f539a = new ji("PushMetaInfo");
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
        this.f543a = new BitSet(5);
        this.f545a = false;
    }

    public hu(hu huVar) {
        BitSet bitSet = new BitSet(5);
        this.f543a = bitSet;
        bitSet.clear();
        this.f543a.or(huVar.f543a);
        if (huVar.m587a()) {
            this.f542a = huVar.f542a;
        }
        this.f541a = huVar.f541a;
        if (huVar.m593c()) {
            this.f547b = huVar.f547b;
        }
        if (huVar.m594d()) {
            this.f550c = huVar.f550c;
        }
        if (huVar.e()) {
            this.f552d = huVar.f552d;
        }
        this.f540a = huVar.f540a;
        if (huVar.g()) {
            this.f553e = huVar.f553e;
        }
        this.f546b = huVar.f546b;
        this.f549c = huVar.f549c;
        if (huVar.j()) {
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, String> entry : huVar.f544a.entrySet()) {
                hashMap.put(entry.getKey(), entry.getValue());
            }
            this.f544a = hashMap;
        }
        if (huVar.k()) {
            HashMap hashMap2 = new HashMap();
            for (Map.Entry<String, String> entry2 : huVar.f548b.entrySet()) {
                hashMap2.put(entry2.getKey(), entry2.getValue());
            }
            this.f548b = hashMap2;
        }
        this.f545a = huVar.f545a;
        if (huVar.n()) {
            HashMap hashMap3 = new HashMap();
            for (Map.Entry<String, String> entry3 : huVar.f551c.entrySet()) {
                hashMap3.put(entry3.getKey(), entry3.getValue());
            }
            this.f551c = hashMap3;
        }
    }

    public int a() {
        return this.f540a;
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
            int compareTo = Boolean.valueOf(m587a()).compareTo(Boolean.valueOf(huVar.m587a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m587a() || (a14 = it.a(this.f542a, huVar.f542a)) == 0) {
                int compareTo2 = Boolean.valueOf(m591b()).compareTo(Boolean.valueOf(huVar.m591b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!m591b() || (a13 = it.a(this.f541a, huVar.f541a)) == 0) {
                    int compareTo3 = Boolean.valueOf(m593c()).compareTo(Boolean.valueOf(huVar.m593c()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!m593c() || (a12 = it.a(this.f547b, huVar.f547b)) == 0) {
                        int compareTo4 = Boolean.valueOf(m594d()).compareTo(Boolean.valueOf(huVar.m594d()));
                        if (compareTo4 != 0) {
                            return compareTo4;
                        }
                        if (!m594d() || (a11 = it.a(this.f550c, huVar.f550c)) == 0) {
                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(huVar.e()));
                            if (compareTo5 != 0) {
                                return compareTo5;
                            }
                            if (!e() || (a10 = it.a(this.f552d, huVar.f552d)) == 0) {
                                int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(huVar.f()));
                                if (compareTo6 != 0) {
                                    return compareTo6;
                                }
                                if (!f() || (a9 = it.a(this.f540a, huVar.f540a)) == 0) {
                                    int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(huVar.g()));
                                    if (compareTo7 != 0) {
                                        return compareTo7;
                                    }
                                    if (!g() || (a8 = it.a(this.f553e, huVar.f553e)) == 0) {
                                        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(huVar.h()));
                                        if (compareTo8 != 0) {
                                            return compareTo8;
                                        }
                                        if (!h() || (a7 = it.a(this.f546b, huVar.f546b)) == 0) {
                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(huVar.i()));
                                            if (compareTo9 != 0) {
                                                return compareTo9;
                                            }
                                            if (!i() || (a6 = it.a(this.f549c, huVar.f549c)) == 0) {
                                                int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(huVar.j()));
                                                if (compareTo10 != 0) {
                                                    return compareTo10;
                                                }
                                                if (!j() || (a5 = it.a(this.f544a, huVar.f544a)) == 0) {
                                                    int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(huVar.k()));
                                                    if (compareTo11 != 0) {
                                                        return compareTo11;
                                                    }
                                                    if (!k() || (a4 = it.a(this.f548b, huVar.f548b)) == 0) {
                                                        int compareTo12 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(huVar.m()));
                                                        if (compareTo12 != 0) {
                                                            return compareTo12;
                                                        }
                                                        if (!m() || (a3 = it.a(this.f545a, huVar.f545a)) == 0) {
                                                            int compareTo13 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(huVar.n()));
                                                            if (compareTo13 != 0) {
                                                                return compareTo13;
                                                            }
                                                            if (!n() || (a2 = it.a(this.f551c, huVar.f551c)) == 0) {
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
    public long m582a() {
        return this.f541a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public hu m583a() {
        return new hu(this);
    }

    public hu a(int i2) {
        this.f540a = i2;
        b(true);
        return this;
    }

    public hu a(String str) {
        this.f542a = str;
        return this;
    }

    public hu a(Map<String, String> map) {
        this.f544a = map;
        return this;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m584a() {
        return this.f542a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public Map<String, String> m585a() {
        return this.f544a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m586a() {
        if (this.f542a != null) {
            return;
        }
        throw new je("Required field 'id' was not present! Struct: " + toString());
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.xiaomi.push.is
    public void a(jd jdVar) {
        jdVar.mo700a();
        while (true) {
            ja mo696a = jdVar.mo696a();
            byte b2 = mo696a.a;
            if (b2 == 0) {
                jdVar.f();
                if (m591b()) {
                    m586a();
                    return;
                }
                throw new je("Required field 'messageTs' was not found in serialized data! Struct: " + toString());
            }
            int i2 = 0;
            switch (mo696a.f814a) {
                case 1:
                    if (b2 == 11) {
                        this.f542a = jdVar.mo701a();
                        break;
                    }
                    jg.a(jdVar, b2);
                    break;
                case 2:
                    if (b2 == 10) {
                        this.f541a = jdVar.mo695a();
                        a(true);
                        break;
                    }
                    jg.a(jdVar, b2);
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f547b = jdVar.mo701a();
                        break;
                    }
                    jg.a(jdVar, b2);
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f550c = jdVar.mo701a();
                        break;
                    }
                    jg.a(jdVar, b2);
                    break;
                case 5:
                    if (b2 == 11) {
                        this.f552d = jdVar.mo701a();
                        break;
                    }
                    jg.a(jdVar, b2);
                    break;
                case 6:
                    if (b2 == 8) {
                        this.f540a = jdVar.mo694a();
                        b(true);
                        break;
                    }
                    jg.a(jdVar, b2);
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f553e = jdVar.mo701a();
                        break;
                    }
                    jg.a(jdVar, b2);
                    break;
                case 8:
                    if (b2 == 8) {
                        this.f546b = jdVar.mo694a();
                        c(true);
                        break;
                    }
                    jg.a(jdVar, b2);
                    break;
                case 9:
                    if (b2 == 8) {
                        this.f549c = jdVar.mo694a();
                        d(true);
                        break;
                    }
                    jg.a(jdVar, b2);
                    break;
                case 10:
                    if (b2 == 13) {
                        jc mo698a = jdVar.mo698a();
                        this.f544a = new HashMap(mo698a.f816a * 2);
                        while (i2 < mo698a.f816a) {
                            this.f544a.put(jdVar.mo701a(), jdVar.mo701a());
                            i2++;
                        }
                        jdVar.h();
                        break;
                    }
                    jg.a(jdVar, b2);
                    break;
                case 11:
                    if (b2 == 13) {
                        jc mo698a2 = jdVar.mo698a();
                        this.f548b = new HashMap(mo698a2.f816a * 2);
                        while (i2 < mo698a2.f816a) {
                            this.f548b.put(jdVar.mo701a(), jdVar.mo701a());
                            i2++;
                        }
                        jdVar.h();
                        break;
                    }
                    jg.a(jdVar, b2);
                    break;
                case 12:
                    if (b2 == 2) {
                        this.f545a = jdVar.mo706a();
                        e(true);
                        break;
                    }
                    jg.a(jdVar, b2);
                    break;
                case 13:
                    if (b2 == 13) {
                        jc mo698a3 = jdVar.mo698a();
                        this.f551c = new HashMap(mo698a3.f816a * 2);
                        while (i2 < mo698a3.f816a) {
                            this.f551c.put(jdVar.mo701a(), jdVar.mo701a());
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
        if (this.f544a == null) {
            this.f544a = new HashMap();
        }
        this.f544a.put(str, str2);
    }

    public void a(boolean z) {
        this.f543a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m587a() {
        return this.f542a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m588a(hu huVar) {
        if (huVar == null) {
            return false;
        }
        boolean m587a = m587a();
        boolean m587a2 = huVar.m587a();
        if (((m587a || m587a2) && !(m587a && m587a2 && this.f542a.equals(huVar.f542a))) || this.f541a != huVar.f541a) {
            return false;
        }
        boolean m593c = m593c();
        boolean m593c2 = huVar.m593c();
        if ((m593c || m593c2) && !(m593c && m593c2 && this.f547b.equals(huVar.f547b))) {
            return false;
        }
        boolean m594d = m594d();
        boolean m594d2 = huVar.m594d();
        if ((m594d || m594d2) && !(m594d && m594d2 && this.f550c.equals(huVar.f550c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = huVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f552d.equals(huVar.f552d))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = huVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f540a == huVar.f540a)) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = huVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f553e.equals(huVar.f553e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = huVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f546b == huVar.f546b)) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = huVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f549c == huVar.f549c)) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = huVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f544a.equals(huVar.f544a))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = huVar.k();
        if ((k2 || k3) && !(k2 && k3 && this.f548b.equals(huVar.f548b))) {
            return false;
        }
        boolean m2 = m();
        boolean m3 = huVar.m();
        if ((m2 || m3) && !(m2 && m3 && this.f545a == huVar.f545a)) {
            return false;
        }
        boolean n = n();
        boolean n2 = huVar.n();
        if (n || n2) {
            return n && n2 && this.f551c.equals(huVar.f551c);
        }
        return true;
    }

    public int b() {
        return this.f546b;
    }

    public hu b(int i2) {
        this.f546b = i2;
        c(true);
        return this;
    }

    public hu b(String str) {
        this.f547b = str;
        return this;
    }

    /* renamed from: b  reason: collision with other method in class */
    public String m589b() {
        return this.f547b;
    }

    /* renamed from: b  reason: collision with other method in class */
    public Map<String, String> m590b() {
        return this.f548b;
    }

    @Override // com.xiaomi.push.is
    public void b(jd jdVar) {
        m586a();
        jdVar.a(f539a);
        if (this.f542a != null) {
            jdVar.a(a);
            jdVar.a(this.f542a);
            jdVar.b();
        }
        jdVar.a(b);
        jdVar.a(this.f541a);
        jdVar.b();
        if (this.f547b != null && m593c()) {
            jdVar.a(c);
            jdVar.a(this.f547b);
            jdVar.b();
        }
        if (this.f550c != null && m594d()) {
            jdVar.a(d);
            jdVar.a(this.f550c);
            jdVar.b();
        }
        if (this.f552d != null && e()) {
            jdVar.a(e);
            jdVar.a(this.f552d);
            jdVar.b();
        }
        if (f()) {
            jdVar.a(f);
            jdVar.mo705a(this.f540a);
            jdVar.b();
        }
        if (this.f553e != null && g()) {
            jdVar.a(g);
            jdVar.a(this.f553e);
            jdVar.b();
        }
        if (h()) {
            jdVar.a(h);
            jdVar.mo705a(this.f546b);
            jdVar.b();
        }
        if (i()) {
            jdVar.a(i);
            jdVar.mo705a(this.f549c);
            jdVar.b();
        }
        if (this.f544a != null && j()) {
            jdVar.a(j);
            jdVar.a(new jc(Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, this.f544a.size()));
            for (Map.Entry<String, String> entry : this.f544a.entrySet()) {
                jdVar.a(entry.getKey());
                jdVar.a(entry.getValue());
            }
            jdVar.d();
            jdVar.b();
        }
        if (this.f548b != null && k()) {
            jdVar.a(k);
            jdVar.a(new jc(Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, this.f548b.size()));
            for (Map.Entry<String, String> entry2 : this.f548b.entrySet()) {
                jdVar.a(entry2.getKey());
                jdVar.a(entry2.getValue());
            }
            jdVar.d();
            jdVar.b();
        }
        if (m()) {
            jdVar.a(l);
            jdVar.a(this.f545a);
            jdVar.b();
        }
        if (this.f551c != null && n()) {
            jdVar.a(m);
            jdVar.a(new jc(Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, this.f551c.size()));
            for (Map.Entry<String, String> entry3 : this.f551c.entrySet()) {
                jdVar.a(entry3.getKey());
                jdVar.a(entry3.getValue());
            }
            jdVar.d();
            jdVar.b();
        }
        jdVar.c();
        jdVar.mo704a();
    }

    public void b(String str, String str2) {
        if (this.f548b == null) {
            this.f548b = new HashMap();
        }
        this.f548b.put(str, str2);
    }

    public void b(boolean z) {
        this.f543a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m591b() {
        return this.f543a.get(0);
    }

    public int c() {
        return this.f549c;
    }

    public hu c(int i2) {
        this.f549c = i2;
        d(true);
        return this;
    }

    public hu c(String str) {
        this.f550c = str;
        return this;
    }

    /* renamed from: c  reason: collision with other method in class */
    public String m592c() {
        return this.f550c;
    }

    public void c(boolean z) {
        this.f543a.set(2, z);
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m593c() {
        return this.f547b != null;
    }

    public hu d(String str) {
        this.f552d = str;
        return this;
    }

    public String d() {
        return this.f552d;
    }

    public void d(boolean z) {
        this.f543a.set(3, z);
    }

    /* renamed from: d  reason: collision with other method in class */
    public boolean m594d() {
        return this.f550c != null;
    }

    public void e(boolean z) {
        this.f543a.set(4, z);
    }

    public boolean e() {
        return this.f552d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hu)) {
            return m588a((hu) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f543a.get(1);
    }

    public boolean g() {
        return this.f553e != null;
    }

    public boolean h() {
        return this.f543a.get(2);
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f543a.get(3);
    }

    public boolean j() {
        return this.f544a != null;
    }

    public boolean k() {
        return this.f548b != null;
    }

    public boolean l() {
        return this.f545a;
    }

    public boolean m() {
        return this.f543a.get(4);
    }

    public boolean n() {
        return this.f551c != null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("PushMetaInfo(");
        sb.append("id:");
        String str = this.f542a;
        if (str == null) {
            sb.append(StringUtil.NULL_STRING);
        } else {
            sb.append(com.xiaomi.push.service.bd.a(str));
        }
        sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        sb.append("messageTs:");
        sb.append(this.f541a);
        if (m593c()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append(UrlSchemaHelper.SCHEMA_TYPE_TOPIC);
            String str2 = this.f547b;
            if (str2 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str2);
            }
        }
        if (m594d()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("title:");
            String str3 = this.f550c;
            if (str3 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str3);
            }
        }
        if (e()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("description:");
            String str4 = this.f552d;
            if (str4 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str4);
            }
        }
        if (f()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("notifyType:");
            sb.append(this.f540a);
        }
        if (g()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append(HttpRetryStatistic.RETRY_URL);
            String str5 = this.f553e;
            if (str5 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str5);
            }
        }
        if (h()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("passThrough:");
            sb.append(this.f546b);
        }
        if (i()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("notifyId:");
            sb.append(this.f549c);
        }
        if (j()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("extra:");
            Map<String, String> map = this.f544a;
            if (map == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(map);
            }
        }
        if (k()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("internal:");
            Map<String, String> map2 = this.f548b;
            if (map2 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(map2);
            }
        }
        if (m()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("ignoreRegInfo:");
            sb.append(this.f545a);
        }
        if (n()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("apsProperFields:");
            Map<String, String> map3 = this.f551c;
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
