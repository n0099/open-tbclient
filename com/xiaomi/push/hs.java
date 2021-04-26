package com.xiaomi.push;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.retrieve.Constants;
import com.baidu.down.retry.HttpRetryStatistic;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes7.dex */
public class hs implements iq<hs, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public int f537a;

    /* renamed from: a  reason: collision with other field name */
    public long f538a;

    /* renamed from: a  reason: collision with other field name */
    public String f539a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f540a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f541a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f542a;

    /* renamed from: b  reason: collision with other field name */
    public int f543b;

    /* renamed from: b  reason: collision with other field name */
    public String f544b;

    /* renamed from: b  reason: collision with other field name */
    public Map<String, String> f545b;

    /* renamed from: c  reason: collision with other field name */
    public int f546c;

    /* renamed from: c  reason: collision with other field name */
    public String f547c;

    /* renamed from: c  reason: collision with other field name */
    public Map<String, String> f548c;

    /* renamed from: d  reason: collision with other field name */
    public String f549d;

    /* renamed from: e  reason: collision with other field name */
    public String f550e;

    /* renamed from: a  reason: collision with other field name */
    public static final jg f536a = new jg("PushMetaInfo");

    /* renamed from: a  reason: collision with root package name */
    public static final iy f38613a = new iy("", (byte) 11, 1);

    /* renamed from: b  reason: collision with root package name */
    public static final iy f38614b = new iy("", (byte) 10, 2);

    /* renamed from: c  reason: collision with root package name */
    public static final iy f38615c = new iy("", (byte) 11, 3);

    /* renamed from: d  reason: collision with root package name */
    public static final iy f38616d = new iy("", (byte) 11, 4);

    /* renamed from: e  reason: collision with root package name */
    public static final iy f38617e = new iy("", (byte) 11, 5);

    /* renamed from: f  reason: collision with root package name */
    public static final iy f38618f = new iy("", (byte) 8, 6);

    /* renamed from: g  reason: collision with root package name */
    public static final iy f38619g = new iy("", (byte) 11, 7);

    /* renamed from: h  reason: collision with root package name */
    public static final iy f38620h = new iy("", (byte) 8, 8);

    /* renamed from: i  reason: collision with root package name */
    public static final iy f38621i = new iy("", (byte) 8, 9);
    public static final iy j = new iy("", (byte) 13, 10);
    public static final iy k = new iy("", (byte) 13, 11);
    public static final iy l = new iy("", (byte) 2, 12);
    public static final iy m = new iy("", (byte) 13, 13);

    public hs() {
        this.f540a = new BitSet(5);
        this.f542a = false;
    }

    public hs(hs hsVar) {
        BitSet bitSet = new BitSet(5);
        this.f540a = bitSet;
        bitSet.clear();
        this.f540a.or(hsVar.f540a);
        if (hsVar.m398a()) {
            this.f539a = hsVar.f539a;
        }
        this.f538a = hsVar.f538a;
        if (hsVar.m404c()) {
            this.f544b = hsVar.f544b;
        }
        if (hsVar.m405d()) {
            this.f547c = hsVar.f547c;
        }
        if (hsVar.e()) {
            this.f549d = hsVar.f549d;
        }
        this.f537a = hsVar.f537a;
        if (hsVar.g()) {
            this.f550e = hsVar.f550e;
        }
        this.f543b = hsVar.f543b;
        this.f546c = hsVar.f546c;
        if (hsVar.j()) {
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, String> entry : hsVar.f541a.entrySet()) {
                hashMap.put(entry.getKey(), entry.getValue());
            }
            this.f541a = hashMap;
        }
        if (hsVar.k()) {
            HashMap hashMap2 = new HashMap();
            for (Map.Entry<String, String> entry2 : hsVar.f545b.entrySet()) {
                hashMap2.put(entry2.getKey(), entry2.getValue());
            }
            this.f545b = hashMap2;
        }
        this.f542a = hsVar.f542a;
        if (hsVar.n()) {
            HashMap hashMap3 = new HashMap();
            for (Map.Entry<String, String> entry3 : hsVar.f548c.entrySet()) {
                hashMap3.put(entry3.getKey(), entry3.getValue());
            }
            this.f548c = hashMap3;
        }
    }

    public int a() {
        return this.f537a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(hs hsVar) {
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
        if (hs.class.equals(hsVar.getClass())) {
            int compareTo = Boolean.valueOf(m398a()).compareTo(Boolean.valueOf(hsVar.m398a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m398a() || (a14 = ir.a(this.f539a, hsVar.f539a)) == 0) {
                int compareTo2 = Boolean.valueOf(m402b()).compareTo(Boolean.valueOf(hsVar.m402b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!m402b() || (a13 = ir.a(this.f538a, hsVar.f538a)) == 0) {
                    int compareTo3 = Boolean.valueOf(m404c()).compareTo(Boolean.valueOf(hsVar.m404c()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!m404c() || (a12 = ir.a(this.f544b, hsVar.f544b)) == 0) {
                        int compareTo4 = Boolean.valueOf(m405d()).compareTo(Boolean.valueOf(hsVar.m405d()));
                        if (compareTo4 != 0) {
                            return compareTo4;
                        }
                        if (!m405d() || (a11 = ir.a(this.f547c, hsVar.f547c)) == 0) {
                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hsVar.e()));
                            if (compareTo5 != 0) {
                                return compareTo5;
                            }
                            if (!e() || (a10 = ir.a(this.f549d, hsVar.f549d)) == 0) {
                                int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hsVar.f()));
                                if (compareTo6 != 0) {
                                    return compareTo6;
                                }
                                if (!f() || (a9 = ir.a(this.f537a, hsVar.f537a)) == 0) {
                                    int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hsVar.g()));
                                    if (compareTo7 != 0) {
                                        return compareTo7;
                                    }
                                    if (!g() || (a8 = ir.a(this.f550e, hsVar.f550e)) == 0) {
                                        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hsVar.h()));
                                        if (compareTo8 != 0) {
                                            return compareTo8;
                                        }
                                        if (!h() || (a7 = ir.a(this.f543b, hsVar.f543b)) == 0) {
                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hsVar.i()));
                                            if (compareTo9 != 0) {
                                                return compareTo9;
                                            }
                                            if (!i() || (a6 = ir.a(this.f546c, hsVar.f546c)) == 0) {
                                                int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(hsVar.j()));
                                                if (compareTo10 != 0) {
                                                    return compareTo10;
                                                }
                                                if (!j() || (a5 = ir.a(this.f541a, hsVar.f541a)) == 0) {
                                                    int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(hsVar.k()));
                                                    if (compareTo11 != 0) {
                                                        return compareTo11;
                                                    }
                                                    if (!k() || (a4 = ir.a(this.f545b, hsVar.f545b)) == 0) {
                                                        int compareTo12 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(hsVar.m()));
                                                        if (compareTo12 != 0) {
                                                            return compareTo12;
                                                        }
                                                        if (!m() || (a3 = ir.a(this.f542a, hsVar.f542a)) == 0) {
                                                            int compareTo13 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(hsVar.n()));
                                                            if (compareTo13 != 0) {
                                                                return compareTo13;
                                                            }
                                                            if (!n() || (a2 = ir.a(this.f548c, hsVar.f548c)) == 0) {
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
        return hs.class.getName().compareTo(hsVar.getClass().getName());
    }

    /* renamed from: a  reason: collision with other method in class */
    public long m393a() {
        return this.f538a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public hs m394a() {
        return new hs(this);
    }

    public hs a(int i2) {
        this.f537a = i2;
        b(true);
        return this;
    }

    public hs a(String str) {
        this.f539a = str;
        return this;
    }

    public hs a(Map<String, String> map) {
        this.f541a = map;
        return this;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m395a() {
        return this.f539a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public Map<String, String> m396a() {
        return this.f541a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m397a() {
        if (this.f539a != null) {
            return;
        }
        throw new jc("Required field 'id' was not present! Struct: " + toString());
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.xiaomi.push.iq
    public void a(jb jbVar) {
        jbVar.m512a();
        while (true) {
            iy m508a = jbVar.m508a();
            byte b2 = m508a.f38795a;
            if (b2 == 0) {
                jbVar.f();
                if (m402b()) {
                    m397a();
                    return;
                }
                throw new jc("Required field 'messageTs' was not found in serialized data! Struct: " + toString());
            }
            int i2 = 0;
            switch (m508a.f807a) {
                case 1:
                    if (b2 == 11) {
                        this.f539a = jbVar.m513a();
                        break;
                    }
                    je.a(jbVar, b2);
                    break;
                case 2:
                    if (b2 == 10) {
                        this.f538a = jbVar.m507a();
                        a(true);
                        break;
                    }
                    je.a(jbVar, b2);
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f544b = jbVar.m513a();
                        break;
                    }
                    je.a(jbVar, b2);
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f547c = jbVar.m513a();
                        break;
                    }
                    je.a(jbVar, b2);
                    break;
                case 5:
                    if (b2 == 11) {
                        this.f549d = jbVar.m513a();
                        break;
                    }
                    je.a(jbVar, b2);
                    break;
                case 6:
                    if (b2 == 8) {
                        this.f537a = jbVar.m506a();
                        b(true);
                        break;
                    }
                    je.a(jbVar, b2);
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f550e = jbVar.m513a();
                        break;
                    }
                    je.a(jbVar, b2);
                    break;
                case 8:
                    if (b2 == 8) {
                        this.f543b = jbVar.m506a();
                        c(true);
                        break;
                    }
                    je.a(jbVar, b2);
                    break;
                case 9:
                    if (b2 == 8) {
                        this.f546c = jbVar.m506a();
                        d(true);
                        break;
                    }
                    je.a(jbVar, b2);
                    break;
                case 10:
                    if (b2 == 13) {
                        ja m510a = jbVar.m510a();
                        this.f541a = new HashMap(m510a.f811a * 2);
                        while (i2 < m510a.f811a) {
                            this.f541a.put(jbVar.m513a(), jbVar.m513a());
                            i2++;
                        }
                        jbVar.h();
                        break;
                    }
                    je.a(jbVar, b2);
                    break;
                case 11:
                    if (b2 == 13) {
                        ja m510a2 = jbVar.m510a();
                        this.f545b = new HashMap(m510a2.f811a * 2);
                        while (i2 < m510a2.f811a) {
                            this.f545b.put(jbVar.m513a(), jbVar.m513a());
                            i2++;
                        }
                        jbVar.h();
                        break;
                    }
                    je.a(jbVar, b2);
                    break;
                case 12:
                    if (b2 == 2) {
                        this.f542a = jbVar.m517a();
                        e(true);
                        break;
                    }
                    je.a(jbVar, b2);
                    break;
                case 13:
                    if (b2 == 13) {
                        ja m510a3 = jbVar.m510a();
                        this.f548c = new HashMap(m510a3.f811a * 2);
                        while (i2 < m510a3.f811a) {
                            this.f548c.put(jbVar.m513a(), jbVar.m513a());
                            i2++;
                        }
                        jbVar.h();
                        break;
                    }
                    je.a(jbVar, b2);
                    break;
                default:
                    je.a(jbVar, b2);
                    break;
            }
            jbVar.g();
        }
    }

    public void a(String str, String str2) {
        if (this.f541a == null) {
            this.f541a = new HashMap();
        }
        this.f541a.put(str, str2);
    }

    public void a(boolean z) {
        this.f540a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m398a() {
        return this.f539a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m399a(hs hsVar) {
        if (hsVar == null) {
            return false;
        }
        boolean m398a = m398a();
        boolean m398a2 = hsVar.m398a();
        if (((m398a || m398a2) && !(m398a && m398a2 && this.f539a.equals(hsVar.f539a))) || this.f538a != hsVar.f538a) {
            return false;
        }
        boolean m404c = m404c();
        boolean m404c2 = hsVar.m404c();
        if ((m404c || m404c2) && !(m404c && m404c2 && this.f544b.equals(hsVar.f544b))) {
            return false;
        }
        boolean m405d = m405d();
        boolean m405d2 = hsVar.m405d();
        if ((m405d || m405d2) && !(m405d && m405d2 && this.f547c.equals(hsVar.f547c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = hsVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f549d.equals(hsVar.f549d))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = hsVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f537a == hsVar.f537a)) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = hsVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f550e.equals(hsVar.f550e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = hsVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f543b == hsVar.f543b)) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = hsVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f546c == hsVar.f546c)) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = hsVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f541a.equals(hsVar.f541a))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = hsVar.k();
        if ((k2 || k3) && !(k2 && k3 && this.f545b.equals(hsVar.f545b))) {
            return false;
        }
        boolean m2 = m();
        boolean m3 = hsVar.m();
        if ((m2 || m3) && !(m2 && m3 && this.f542a == hsVar.f542a)) {
            return false;
        }
        boolean n = n();
        boolean n2 = hsVar.n();
        if (n || n2) {
            return n && n2 && this.f548c.equals(hsVar.f548c);
        }
        return true;
    }

    public int b() {
        return this.f543b;
    }

    public hs b(int i2) {
        this.f543b = i2;
        c(true);
        return this;
    }

    public hs b(String str) {
        this.f544b = str;
        return this;
    }

    /* renamed from: b  reason: collision with other method in class */
    public String m400b() {
        return this.f544b;
    }

    /* renamed from: b  reason: collision with other method in class */
    public Map<String, String> m401b() {
        return this.f545b;
    }

    @Override // com.xiaomi.push.iq
    public void b(jb jbVar) {
        m397a();
        jbVar.a(f536a);
        if (this.f539a != null) {
            jbVar.a(f38613a);
            jbVar.a(this.f539a);
            jbVar.b();
        }
        jbVar.a(f38614b);
        jbVar.a(this.f538a);
        jbVar.b();
        if (this.f544b != null && m404c()) {
            jbVar.a(f38615c);
            jbVar.a(this.f544b);
            jbVar.b();
        }
        if (this.f547c != null && m405d()) {
            jbVar.a(f38616d);
            jbVar.a(this.f547c);
            jbVar.b();
        }
        if (this.f549d != null && e()) {
            jbVar.a(f38617e);
            jbVar.a(this.f549d);
            jbVar.b();
        }
        if (f()) {
            jbVar.a(f38618f);
            jbVar.a(this.f537a);
            jbVar.b();
        }
        if (this.f550e != null && g()) {
            jbVar.a(f38619g);
            jbVar.a(this.f550e);
            jbVar.b();
        }
        if (h()) {
            jbVar.a(f38620h);
            jbVar.a(this.f543b);
            jbVar.b();
        }
        if (i()) {
            jbVar.a(f38621i);
            jbVar.a(this.f546c);
            jbVar.b();
        }
        if (this.f541a != null && j()) {
            jbVar.a(j);
            jbVar.a(new ja((byte) 11, (byte) 11, this.f541a.size()));
            for (Map.Entry<String, String> entry : this.f541a.entrySet()) {
                jbVar.a(entry.getKey());
                jbVar.a(entry.getValue());
            }
            jbVar.d();
            jbVar.b();
        }
        if (this.f545b != null && k()) {
            jbVar.a(k);
            jbVar.a(new ja((byte) 11, (byte) 11, this.f545b.size()));
            for (Map.Entry<String, String> entry2 : this.f545b.entrySet()) {
                jbVar.a(entry2.getKey());
                jbVar.a(entry2.getValue());
            }
            jbVar.d();
            jbVar.b();
        }
        if (m()) {
            jbVar.a(l);
            jbVar.a(this.f542a);
            jbVar.b();
        }
        if (this.f548c != null && n()) {
            jbVar.a(m);
            jbVar.a(new ja((byte) 11, (byte) 11, this.f548c.size()));
            for (Map.Entry<String, String> entry3 : this.f548c.entrySet()) {
                jbVar.a(entry3.getKey());
                jbVar.a(entry3.getValue());
            }
            jbVar.d();
            jbVar.b();
        }
        jbVar.c();
        jbVar.m516a();
    }

    public void b(String str, String str2) {
        if (this.f545b == null) {
            this.f545b = new HashMap();
        }
        this.f545b.put(str, str2);
    }

    public void b(boolean z) {
        this.f540a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m402b() {
        return this.f540a.get(0);
    }

    public int c() {
        return this.f546c;
    }

    public hs c(int i2) {
        this.f546c = i2;
        d(true);
        return this;
    }

    public hs c(String str) {
        this.f547c = str;
        return this;
    }

    /* renamed from: c  reason: collision with other method in class */
    public String m403c() {
        return this.f547c;
    }

    public void c(boolean z) {
        this.f540a.set(2, z);
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m404c() {
        return this.f544b != null;
    }

    public hs d(String str) {
        this.f549d = str;
        return this;
    }

    public String d() {
        return this.f549d;
    }

    public void d(boolean z) {
        this.f540a.set(3, z);
    }

    /* renamed from: d  reason: collision with other method in class */
    public boolean m405d() {
        return this.f547c != null;
    }

    public void e(boolean z) {
        this.f540a.set(4, z);
    }

    public boolean e() {
        return this.f549d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hs)) {
            return m399a((hs) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f540a.get(1);
    }

    public boolean g() {
        return this.f550e != null;
    }

    public boolean h() {
        return this.f540a.get(2);
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f540a.get(3);
    }

    public boolean j() {
        return this.f541a != null;
    }

    public boolean k() {
        return this.f545b != null;
    }

    public boolean l() {
        return this.f542a;
    }

    public boolean m() {
        return this.f540a.get(4);
    }

    public boolean n() {
        return this.f548c != null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("PushMetaInfo(");
        sb.append("id:");
        String str = this.f539a;
        if (str == null) {
            sb.append(StringUtil.NULL_STRING);
        } else {
            sb.append(str);
        }
        sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        sb.append("messageTs:");
        sb.append(this.f538a);
        if (m404c()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append(UrlSchemaHelper.SCHEMA_TYPE_TOPIC);
            String str2 = this.f544b;
            if (str2 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str2);
            }
        }
        if (m405d()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("title:");
            String str3 = this.f547c;
            if (str3 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str3);
            }
        }
        if (e()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("description:");
            String str4 = this.f549d;
            if (str4 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str4);
            }
        }
        if (f()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("notifyType:");
            sb.append(this.f537a);
        }
        if (g()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append(HttpRetryStatistic.RETRY_URL);
            String str5 = this.f550e;
            if (str5 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str5);
            }
        }
        if (h()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("passThrough:");
            sb.append(this.f543b);
        }
        if (i()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("notifyId:");
            sb.append(this.f546c);
        }
        if (j()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("extra:");
            Map<String, String> map = this.f541a;
            if (map == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(map);
            }
        }
        if (k()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append(Constants.PATH_INTERNAL);
            Map<String, String> map2 = this.f545b;
            if (map2 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(map2);
            }
        }
        if (m()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("ignoreRegInfo:");
            sb.append(this.f542a);
        }
        if (n()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("apsProperFields:");
            Map<String, String> map3 = this.f548c;
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
