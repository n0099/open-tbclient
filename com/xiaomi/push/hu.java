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
    public int f535a;

    /* renamed from: a  reason: collision with other field name */
    public long f536a;

    /* renamed from: a  reason: collision with other field name */
    public String f537a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f538a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f539a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f540a;

    /* renamed from: b  reason: collision with other field name */
    public int f541b;

    /* renamed from: b  reason: collision with other field name */
    public String f542b;

    /* renamed from: b  reason: collision with other field name */
    public Map<String, String> f543b;

    /* renamed from: c  reason: collision with other field name */
    public int f544c;

    /* renamed from: c  reason: collision with other field name */
    public String f545c;

    /* renamed from: c  reason: collision with other field name */
    public Map<String, String> f546c;

    /* renamed from: d  reason: collision with other field name */
    public String f547d;

    /* renamed from: e  reason: collision with other field name */
    public String f548e;

    /* renamed from: a  reason: collision with other field name */
    public static final ji f534a = new ji("PushMetaInfo");
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
        this.f538a = new BitSet(5);
        this.f540a = false;
    }

    public hu(hu huVar) {
        BitSet bitSet = new BitSet(5);
        this.f538a = bitSet;
        bitSet.clear();
        this.f538a.or(huVar.f538a);
        if (huVar.m597a()) {
            this.f537a = huVar.f537a;
        }
        this.f536a = huVar.f536a;
        if (huVar.m603c()) {
            this.f542b = huVar.f542b;
        }
        if (huVar.m604d()) {
            this.f545c = huVar.f545c;
        }
        if (huVar.e()) {
            this.f547d = huVar.f547d;
        }
        this.f535a = huVar.f535a;
        if (huVar.g()) {
            this.f548e = huVar.f548e;
        }
        this.f541b = huVar.f541b;
        this.f544c = huVar.f544c;
        if (huVar.j()) {
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, String> entry : huVar.f539a.entrySet()) {
                hashMap.put(entry.getKey(), entry.getValue());
            }
            this.f539a = hashMap;
        }
        if (huVar.k()) {
            HashMap hashMap2 = new HashMap();
            for (Map.Entry<String, String> entry2 : huVar.f543b.entrySet()) {
                hashMap2.put(entry2.getKey(), entry2.getValue());
            }
            this.f543b = hashMap2;
        }
        this.f540a = huVar.f540a;
        if (huVar.n()) {
            HashMap hashMap3 = new HashMap();
            for (Map.Entry<String, String> entry3 : huVar.f546c.entrySet()) {
                hashMap3.put(entry3.getKey(), entry3.getValue());
            }
            this.f546c = hashMap3;
        }
    }

    public int a() {
        return this.f535a;
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
            int compareTo = Boolean.valueOf(m597a()).compareTo(Boolean.valueOf(huVar.m597a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m597a() || (a14 = it.a(this.f537a, huVar.f537a)) == 0) {
                int compareTo2 = Boolean.valueOf(m601b()).compareTo(Boolean.valueOf(huVar.m601b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!m601b() || (a13 = it.a(this.f536a, huVar.f536a)) == 0) {
                    int compareTo3 = Boolean.valueOf(m603c()).compareTo(Boolean.valueOf(huVar.m603c()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!m603c() || (a12 = it.a(this.f542b, huVar.f542b)) == 0) {
                        int compareTo4 = Boolean.valueOf(m604d()).compareTo(Boolean.valueOf(huVar.m604d()));
                        if (compareTo4 != 0) {
                            return compareTo4;
                        }
                        if (!m604d() || (a11 = it.a(this.f545c, huVar.f545c)) == 0) {
                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(huVar.e()));
                            if (compareTo5 != 0) {
                                return compareTo5;
                            }
                            if (!e() || (a10 = it.a(this.f547d, huVar.f547d)) == 0) {
                                int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(huVar.f()));
                                if (compareTo6 != 0) {
                                    return compareTo6;
                                }
                                if (!f() || (a9 = it.a(this.f535a, huVar.f535a)) == 0) {
                                    int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(huVar.g()));
                                    if (compareTo7 != 0) {
                                        return compareTo7;
                                    }
                                    if (!g() || (a8 = it.a(this.f548e, huVar.f548e)) == 0) {
                                        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(huVar.h()));
                                        if (compareTo8 != 0) {
                                            return compareTo8;
                                        }
                                        if (!h() || (a7 = it.a(this.f541b, huVar.f541b)) == 0) {
                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(huVar.i()));
                                            if (compareTo9 != 0) {
                                                return compareTo9;
                                            }
                                            if (!i() || (a6 = it.a(this.f544c, huVar.f544c)) == 0) {
                                                int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(huVar.j()));
                                                if (compareTo10 != 0) {
                                                    return compareTo10;
                                                }
                                                if (!j() || (a5 = it.a(this.f539a, huVar.f539a)) == 0) {
                                                    int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(huVar.k()));
                                                    if (compareTo11 != 0) {
                                                        return compareTo11;
                                                    }
                                                    if (!k() || (a4 = it.a(this.f543b, huVar.f543b)) == 0) {
                                                        int compareTo12 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(huVar.m()));
                                                        if (compareTo12 != 0) {
                                                            return compareTo12;
                                                        }
                                                        if (!m() || (a3 = it.a(this.f540a, huVar.f540a)) == 0) {
                                                            int compareTo13 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(huVar.n()));
                                                            if (compareTo13 != 0) {
                                                                return compareTo13;
                                                            }
                                                            if (!n() || (a2 = it.a(this.f546c, huVar.f546c)) == 0) {
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
    public long m592a() {
        return this.f536a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public hu m593a() {
        return new hu(this);
    }

    public hu a(int i2) {
        this.f535a = i2;
        b(true);
        return this;
    }

    public hu a(String str) {
        this.f537a = str;
        return this;
    }

    public hu a(Map<String, String> map) {
        this.f539a = map;
        return this;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m594a() {
        return this.f537a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public Map<String, String> m595a() {
        return this.f539a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m596a() {
        if (this.f537a != null) {
            return;
        }
        throw new je("Required field 'id' was not present! Struct: " + toString());
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.xiaomi.push.is
    public void a(jd jdVar) {
        jdVar.mo710a();
        while (true) {
            ja mo706a = jdVar.mo706a();
            byte b2 = mo706a.a;
            if (b2 == 0) {
                jdVar.f();
                if (m601b()) {
                    m596a();
                    return;
                }
                throw new je("Required field 'messageTs' was not found in serialized data! Struct: " + toString());
            }
            int i2 = 0;
            switch (mo706a.f809a) {
                case 1:
                    if (b2 == 11) {
                        this.f537a = jdVar.mo711a();
                        break;
                    }
                    jg.a(jdVar, b2);
                    break;
                case 2:
                    if (b2 == 10) {
                        this.f536a = jdVar.mo705a();
                        a(true);
                        break;
                    }
                    jg.a(jdVar, b2);
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f542b = jdVar.mo711a();
                        break;
                    }
                    jg.a(jdVar, b2);
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f545c = jdVar.mo711a();
                        break;
                    }
                    jg.a(jdVar, b2);
                    break;
                case 5:
                    if (b2 == 11) {
                        this.f547d = jdVar.mo711a();
                        break;
                    }
                    jg.a(jdVar, b2);
                    break;
                case 6:
                    if (b2 == 8) {
                        this.f535a = jdVar.mo704a();
                        b(true);
                        break;
                    }
                    jg.a(jdVar, b2);
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f548e = jdVar.mo711a();
                        break;
                    }
                    jg.a(jdVar, b2);
                    break;
                case 8:
                    if (b2 == 8) {
                        this.f541b = jdVar.mo704a();
                        c(true);
                        break;
                    }
                    jg.a(jdVar, b2);
                    break;
                case 9:
                    if (b2 == 8) {
                        this.f544c = jdVar.mo704a();
                        d(true);
                        break;
                    }
                    jg.a(jdVar, b2);
                    break;
                case 10:
                    if (b2 == 13) {
                        jc mo708a = jdVar.mo708a();
                        this.f539a = new HashMap(mo708a.f811a * 2);
                        while (i2 < mo708a.f811a) {
                            this.f539a.put(jdVar.mo711a(), jdVar.mo711a());
                            i2++;
                        }
                        jdVar.h();
                        break;
                    }
                    jg.a(jdVar, b2);
                    break;
                case 11:
                    if (b2 == 13) {
                        jc mo708a2 = jdVar.mo708a();
                        this.f543b = new HashMap(mo708a2.f811a * 2);
                        while (i2 < mo708a2.f811a) {
                            this.f543b.put(jdVar.mo711a(), jdVar.mo711a());
                            i2++;
                        }
                        jdVar.h();
                        break;
                    }
                    jg.a(jdVar, b2);
                    break;
                case 12:
                    if (b2 == 2) {
                        this.f540a = jdVar.mo716a();
                        e(true);
                        break;
                    }
                    jg.a(jdVar, b2);
                    break;
                case 13:
                    if (b2 == 13) {
                        jc mo708a3 = jdVar.mo708a();
                        this.f546c = new HashMap(mo708a3.f811a * 2);
                        while (i2 < mo708a3.f811a) {
                            this.f546c.put(jdVar.mo711a(), jdVar.mo711a());
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
        if (this.f539a == null) {
            this.f539a = new HashMap();
        }
        this.f539a.put(str, str2);
    }

    public void a(boolean z) {
        this.f538a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m597a() {
        return this.f537a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m598a(hu huVar) {
        if (huVar == null) {
            return false;
        }
        boolean m597a = m597a();
        boolean m597a2 = huVar.m597a();
        if (((m597a || m597a2) && !(m597a && m597a2 && this.f537a.equals(huVar.f537a))) || this.f536a != huVar.f536a) {
            return false;
        }
        boolean m603c = m603c();
        boolean m603c2 = huVar.m603c();
        if ((m603c || m603c2) && !(m603c && m603c2 && this.f542b.equals(huVar.f542b))) {
            return false;
        }
        boolean m604d = m604d();
        boolean m604d2 = huVar.m604d();
        if ((m604d || m604d2) && !(m604d && m604d2 && this.f545c.equals(huVar.f545c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = huVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f547d.equals(huVar.f547d))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = huVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f535a == huVar.f535a)) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = huVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f548e.equals(huVar.f548e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = huVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f541b == huVar.f541b)) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = huVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f544c == huVar.f544c)) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = huVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f539a.equals(huVar.f539a))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = huVar.k();
        if ((k2 || k3) && !(k2 && k3 && this.f543b.equals(huVar.f543b))) {
            return false;
        }
        boolean m2 = m();
        boolean m3 = huVar.m();
        if ((m2 || m3) && !(m2 && m3 && this.f540a == huVar.f540a)) {
            return false;
        }
        boolean n = n();
        boolean n2 = huVar.n();
        if (n || n2) {
            return n && n2 && this.f546c.equals(huVar.f546c);
        }
        return true;
    }

    public int b() {
        return this.f541b;
    }

    public hu b(int i2) {
        this.f541b = i2;
        c(true);
        return this;
    }

    public hu b(String str) {
        this.f542b = str;
        return this;
    }

    /* renamed from: b  reason: collision with other method in class */
    public String m599b() {
        return this.f542b;
    }

    /* renamed from: b  reason: collision with other method in class */
    public Map<String, String> m600b() {
        return this.f543b;
    }

    @Override // com.xiaomi.push.is
    public void b(jd jdVar) {
        m596a();
        jdVar.a(f534a);
        if (this.f537a != null) {
            jdVar.a(a);
            jdVar.a(this.f537a);
            jdVar.b();
        }
        jdVar.a(b);
        jdVar.a(this.f536a);
        jdVar.b();
        if (this.f542b != null && m603c()) {
            jdVar.a(c);
            jdVar.a(this.f542b);
            jdVar.b();
        }
        if (this.f545c != null && m604d()) {
            jdVar.a(d);
            jdVar.a(this.f545c);
            jdVar.b();
        }
        if (this.f547d != null && e()) {
            jdVar.a(e);
            jdVar.a(this.f547d);
            jdVar.b();
        }
        if (f()) {
            jdVar.a(f);
            jdVar.mo715a(this.f535a);
            jdVar.b();
        }
        if (this.f548e != null && g()) {
            jdVar.a(g);
            jdVar.a(this.f548e);
            jdVar.b();
        }
        if (h()) {
            jdVar.a(h);
            jdVar.mo715a(this.f541b);
            jdVar.b();
        }
        if (i()) {
            jdVar.a(i);
            jdVar.mo715a(this.f544c);
            jdVar.b();
        }
        if (this.f539a != null && j()) {
            jdVar.a(j);
            jdVar.a(new jc(Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, this.f539a.size()));
            for (Map.Entry<String, String> entry : this.f539a.entrySet()) {
                jdVar.a(entry.getKey());
                jdVar.a(entry.getValue());
            }
            jdVar.d();
            jdVar.b();
        }
        if (this.f543b != null && k()) {
            jdVar.a(k);
            jdVar.a(new jc(Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, this.f543b.size()));
            for (Map.Entry<String, String> entry2 : this.f543b.entrySet()) {
                jdVar.a(entry2.getKey());
                jdVar.a(entry2.getValue());
            }
            jdVar.d();
            jdVar.b();
        }
        if (m()) {
            jdVar.a(l);
            jdVar.a(this.f540a);
            jdVar.b();
        }
        if (this.f546c != null && n()) {
            jdVar.a(m);
            jdVar.a(new jc(Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, this.f546c.size()));
            for (Map.Entry<String, String> entry3 : this.f546c.entrySet()) {
                jdVar.a(entry3.getKey());
                jdVar.a(entry3.getValue());
            }
            jdVar.d();
            jdVar.b();
        }
        jdVar.c();
        jdVar.mo714a();
    }

    public void b(String str, String str2) {
        if (this.f543b == null) {
            this.f543b = new HashMap();
        }
        this.f543b.put(str, str2);
    }

    public void b(boolean z) {
        this.f538a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m601b() {
        return this.f538a.get(0);
    }

    public int c() {
        return this.f544c;
    }

    public hu c(int i2) {
        this.f544c = i2;
        d(true);
        return this;
    }

    public hu c(String str) {
        this.f545c = str;
        return this;
    }

    /* renamed from: c  reason: collision with other method in class */
    public String m602c() {
        return this.f545c;
    }

    public void c(boolean z) {
        this.f538a.set(2, z);
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m603c() {
        return this.f542b != null;
    }

    public hu d(String str) {
        this.f547d = str;
        return this;
    }

    public String d() {
        return this.f547d;
    }

    public void d(boolean z) {
        this.f538a.set(3, z);
    }

    /* renamed from: d  reason: collision with other method in class */
    public boolean m604d() {
        return this.f545c != null;
    }

    public void e(boolean z) {
        this.f538a.set(4, z);
    }

    public boolean e() {
        return this.f547d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hu)) {
            return m598a((hu) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f538a.get(1);
    }

    public boolean g() {
        return this.f548e != null;
    }

    public boolean h() {
        return this.f538a.get(2);
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f538a.get(3);
    }

    public boolean j() {
        return this.f539a != null;
    }

    public boolean k() {
        return this.f543b != null;
    }

    public boolean l() {
        return this.f540a;
    }

    public boolean m() {
        return this.f538a.get(4);
    }

    public boolean n() {
        return this.f546c != null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("PushMetaInfo(");
        sb.append("id:");
        String str = this.f537a;
        if (str == null) {
            sb.append(StringUtil.NULL_STRING);
        } else {
            sb.append(com.xiaomi.push.service.bd.a(str));
        }
        sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        sb.append("messageTs:");
        sb.append(this.f536a);
        if (m603c()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append(UrlSchemaHelper.SCHEMA_TYPE_TOPIC);
            String str2 = this.f542b;
            if (str2 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str2);
            }
        }
        if (m604d()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("title:");
            String str3 = this.f545c;
            if (str3 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str3);
            }
        }
        if (e()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("description:");
            String str4 = this.f547d;
            if (str4 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str4);
            }
        }
        if (f()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("notifyType:");
            sb.append(this.f535a);
        }
        if (g()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append(HttpRetryStatistic.RETRY_URL);
            String str5 = this.f548e;
            if (str5 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str5);
            }
        }
        if (h()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("passThrough:");
            sb.append(this.f541b);
        }
        if (i()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("notifyId:");
            sb.append(this.f544c);
        }
        if (j()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("extra:");
            Map<String, String> map = this.f539a;
            if (map == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(map);
            }
        }
        if (k()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("internal:");
            Map<String, String> map2 = this.f543b;
            if (map2 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(map2);
            }
        }
        if (m()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("ignoreRegInfo:");
            sb.append(this.f540a);
        }
        if (n()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("apsProperFields:");
            Map<String, String> map3 = this.f546c;
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
