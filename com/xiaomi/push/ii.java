package com.xiaomi.push;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import io.flutter.plugin.common.StandardMessageCodec;
import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes7.dex */
public class ii implements iq<ii, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public hr f719a;

    /* renamed from: a  reason: collision with other field name */
    public hu f720a;

    /* renamed from: a  reason: collision with other field name */
    public String f721a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f723a;

    /* renamed from: b  reason: collision with other field name */
    public String f725b;

    /* renamed from: c  reason: collision with other field name */
    public String f726c;

    /* renamed from: d  reason: collision with other field name */
    public String f727d;

    /* renamed from: e  reason: collision with other field name */
    public String f728e;

    /* renamed from: f  reason: collision with other field name */
    public String f729f;

    /* renamed from: g  reason: collision with other field name */
    public String f730g;

    /* renamed from: h  reason: collision with other field name */
    public String f731h;

    /* renamed from: a  reason: collision with other field name */
    public static final jg f718a = new jg("XmPushActionSendMessage");

    /* renamed from: a  reason: collision with root package name */
    public static final iy f41677a = new iy("", (byte) 11, 1);

    /* renamed from: b  reason: collision with root package name */
    public static final iy f41678b = new iy("", StandardMessageCodec.LIST, 2);

    /* renamed from: c  reason: collision with root package name */
    public static final iy f41679c = new iy("", (byte) 11, 3);

    /* renamed from: d  reason: collision with root package name */
    public static final iy f41680d = new iy("", (byte) 11, 4);

    /* renamed from: e  reason: collision with root package name */
    public static final iy f41681e = new iy("", (byte) 11, 5);

    /* renamed from: f  reason: collision with root package name */
    public static final iy f41682f = new iy("", (byte) 11, 6);

    /* renamed from: g  reason: collision with root package name */
    public static final iy f41683g = new iy("", (byte) 11, 7);

    /* renamed from: h  reason: collision with root package name */
    public static final iy f41684h = new iy("", StandardMessageCodec.LIST, 8);

    /* renamed from: i  reason: collision with root package name */
    public static final iy f41685i = new iy("", (byte) 2, 9);
    public static final iy j = new iy("", (byte) 13, 10);
    public static final iy k = new iy("", (byte) 11, 11);
    public static final iy l = new iy("", (byte) 11, 12);

    /* renamed from: a  reason: collision with other field name */
    public BitSet f722a = new BitSet(1);

    /* renamed from: a  reason: collision with other field name */
    public boolean f724a = true;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(ii iiVar) {
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
        if (ii.class.equals(iiVar.getClass())) {
            int compareTo = Boolean.valueOf(m474a()).compareTo(Boolean.valueOf(iiVar.m474a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m474a() || (a13 = ir.a(this.f721a, iiVar.f721a)) == 0) {
                int compareTo2 = Boolean.valueOf(m476b()).compareTo(Boolean.valueOf(iiVar.m476b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!m476b() || (a12 = ir.a(this.f720a, iiVar.f720a)) == 0) {
                    int compareTo3 = Boolean.valueOf(m477c()).compareTo(Boolean.valueOf(iiVar.m477c()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!m477c() || (a11 = ir.a(this.f725b, iiVar.f725b)) == 0) {
                        int compareTo4 = Boolean.valueOf(m478d()).compareTo(Boolean.valueOf(iiVar.m478d()));
                        if (compareTo4 != 0) {
                            return compareTo4;
                        }
                        if (!m478d() || (a10 = ir.a(this.f726c, iiVar.f726c)) == 0) {
                            int compareTo5 = Boolean.valueOf(m479e()).compareTo(Boolean.valueOf(iiVar.m479e()));
                            if (compareTo5 != 0) {
                                return compareTo5;
                            }
                            if (!m479e() || (a9 = ir.a(this.f727d, iiVar.f727d)) == 0) {
                                int compareTo6 = Boolean.valueOf(m480f()).compareTo(Boolean.valueOf(iiVar.m480f()));
                                if (compareTo6 != 0) {
                                    return compareTo6;
                                }
                                if (!m480f() || (a8 = ir.a(this.f728e, iiVar.f728e)) == 0) {
                                    int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(iiVar.g()));
                                    if (compareTo7 != 0) {
                                        return compareTo7;
                                    }
                                    if (!g() || (a7 = ir.a(this.f729f, iiVar.f729f)) == 0) {
                                        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(iiVar.h()));
                                        if (compareTo8 != 0) {
                                            return compareTo8;
                                        }
                                        if (!h() || (a6 = ir.a(this.f719a, iiVar.f719a)) == 0) {
                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(iiVar.i()));
                                            if (compareTo9 != 0) {
                                                return compareTo9;
                                            }
                                            if (!i() || (a5 = ir.a(this.f724a, iiVar.f724a)) == 0) {
                                                int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(iiVar.j()));
                                                if (compareTo10 != 0) {
                                                    return compareTo10;
                                                }
                                                if (!j() || (a4 = ir.a(this.f723a, iiVar.f723a)) == 0) {
                                                    int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(iiVar.k()));
                                                    if (compareTo11 != 0) {
                                                        return compareTo11;
                                                    }
                                                    if (!k() || (a3 = ir.a(this.f730g, iiVar.f730g)) == 0) {
                                                        int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(iiVar.l()));
                                                        if (compareTo12 != 0) {
                                                            return compareTo12;
                                                        }
                                                        if (!l() || (a2 = ir.a(this.f731h, iiVar.f731h)) == 0) {
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
        return ii.class.getName().compareTo(iiVar.getClass().getName());
    }

    public hr a() {
        return this.f719a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m472a() {
        return this.f725b;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m473a() {
        if (this.f725b == null) {
            throw new jc("Required field 'id' was not present! Struct: " + toString());
        } else if (this.f726c != null) {
        } else {
            throw new jc("Required field 'appId' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.iq
    public void a(jb jbVar) {
        jbVar.m510a();
        while (true) {
            iy m506a = jbVar.m506a();
            byte b2 = m506a.f41751a;
            if (b2 == 0) {
                jbVar.f();
                m473a();
                return;
            }
            switch (m506a.f807a) {
                case 1:
                    if (b2 == 11) {
                        this.f721a = jbVar.m511a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 2:
                    if (b2 == 12) {
                        hu huVar = new hu();
                        this.f720a = huVar;
                        huVar.a(jbVar);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f725b = jbVar.m511a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f726c = jbVar.m511a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 5:
                    if (b2 == 11) {
                        this.f727d = jbVar.m511a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 6:
                    if (b2 == 11) {
                        this.f728e = jbVar.m511a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f729f = jbVar.m511a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 8:
                    if (b2 == 12) {
                        hr hrVar = new hr();
                        this.f719a = hrVar;
                        hrVar.a(jbVar);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 9:
                    if (b2 == 2) {
                        this.f724a = jbVar.m515a();
                        a(true);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 10:
                    if (b2 == 13) {
                        ja m508a = jbVar.m508a();
                        this.f723a = new HashMap(m508a.f811a * 2);
                        for (int i2 = 0; i2 < m508a.f811a; i2++) {
                            this.f723a.put(jbVar.m511a(), jbVar.m511a());
                        }
                        jbVar.h();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 11:
                    if (b2 == 11) {
                        this.f730g = jbVar.m511a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 12:
                    if (b2 == 11) {
                        this.f731h = jbVar.m511a();
                        continue;
                        jbVar.g();
                    }
                    break;
            }
            je.a(jbVar, b2);
            jbVar.g();
        }
    }

    public void a(boolean z) {
        this.f722a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m474a() {
        return this.f721a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m475a(ii iiVar) {
        if (iiVar == null) {
            return false;
        }
        boolean m474a = m474a();
        boolean m474a2 = iiVar.m474a();
        if ((m474a || m474a2) && !(m474a && m474a2 && this.f721a.equals(iiVar.f721a))) {
            return false;
        }
        boolean m476b = m476b();
        boolean m476b2 = iiVar.m476b();
        if ((m476b || m476b2) && !(m476b && m476b2 && this.f720a.m405a(iiVar.f720a))) {
            return false;
        }
        boolean m477c = m477c();
        boolean m477c2 = iiVar.m477c();
        if ((m477c || m477c2) && !(m477c && m477c2 && this.f725b.equals(iiVar.f725b))) {
            return false;
        }
        boolean m478d = m478d();
        boolean m478d2 = iiVar.m478d();
        if ((m478d || m478d2) && !(m478d && m478d2 && this.f726c.equals(iiVar.f726c))) {
            return false;
        }
        boolean m479e = m479e();
        boolean m479e2 = iiVar.m479e();
        if ((m479e || m479e2) && !(m479e && m479e2 && this.f727d.equals(iiVar.f727d))) {
            return false;
        }
        boolean m480f = m480f();
        boolean m480f2 = iiVar.m480f();
        if ((m480f || m480f2) && !(m480f && m480f2 && this.f728e.equals(iiVar.f728e))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = iiVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f729f.equals(iiVar.f729f))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = iiVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f719a.m388a(iiVar.f719a))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = iiVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f724a == iiVar.f724a)) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = iiVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f723a.equals(iiVar.f723a))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = iiVar.k();
        if ((k2 || k3) && !(k2 && k3 && this.f730g.equals(iiVar.f730g))) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = iiVar.l();
        if (l2 || l3) {
            return l2 && l3 && this.f731h.equals(iiVar.f731h);
        }
        return true;
    }

    public String b() {
        return this.f726c;
    }

    @Override // com.xiaomi.push.iq
    public void b(jb jbVar) {
        m473a();
        jbVar.a(f718a);
        if (this.f721a != null && m474a()) {
            jbVar.a(f41677a);
            jbVar.a(this.f721a);
            jbVar.b();
        }
        if (this.f720a != null && m476b()) {
            jbVar.a(f41678b);
            this.f720a.b(jbVar);
            jbVar.b();
        }
        if (this.f725b != null) {
            jbVar.a(f41679c);
            jbVar.a(this.f725b);
            jbVar.b();
        }
        if (this.f726c != null) {
            jbVar.a(f41680d);
            jbVar.a(this.f726c);
            jbVar.b();
        }
        if (this.f727d != null && m479e()) {
            jbVar.a(f41681e);
            jbVar.a(this.f727d);
            jbVar.b();
        }
        if (this.f728e != null && m480f()) {
            jbVar.a(f41682f);
            jbVar.a(this.f728e);
            jbVar.b();
        }
        if (this.f729f != null && g()) {
            jbVar.a(f41683g);
            jbVar.a(this.f729f);
            jbVar.b();
        }
        if (this.f719a != null && h()) {
            jbVar.a(f41684h);
            this.f719a.b(jbVar);
            jbVar.b();
        }
        if (i()) {
            jbVar.a(f41685i);
            jbVar.a(this.f724a);
            jbVar.b();
        }
        if (this.f723a != null && j()) {
            jbVar.a(j);
            jbVar.a(new ja((byte) 11, (byte) 11, this.f723a.size()));
            for (Map.Entry<String, String> entry : this.f723a.entrySet()) {
                jbVar.a(entry.getKey());
                jbVar.a(entry.getValue());
            }
            jbVar.d();
            jbVar.b();
        }
        if (this.f730g != null && k()) {
            jbVar.a(k);
            jbVar.a(this.f730g);
            jbVar.b();
        }
        if (this.f731h != null && l()) {
            jbVar.a(l);
            jbVar.a(this.f731h);
            jbVar.b();
        }
        jbVar.c();
        jbVar.m514a();
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m476b() {
        return this.f720a != null;
    }

    public String c() {
        return this.f728e;
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m477c() {
        return this.f725b != null;
    }

    public String d() {
        return this.f729f;
    }

    /* renamed from: d  reason: collision with other method in class */
    public boolean m478d() {
        return this.f726c != null;
    }

    public String e() {
        return this.f730g;
    }

    /* renamed from: e  reason: collision with other method in class */
    public boolean m479e() {
        return this.f727d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ii)) {
            return m475a((ii) obj);
        }
        return false;
    }

    public String f() {
        return this.f731h;
    }

    /* renamed from: f  reason: collision with other method in class */
    public boolean m480f() {
        return this.f728e != null;
    }

    public boolean g() {
        return this.f729f != null;
    }

    public boolean h() {
        return this.f719a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f722a.get(0);
    }

    public boolean j() {
        return this.f723a != null;
    }

    public boolean k() {
        return this.f730g != null;
    }

    public boolean l() {
        return this.f731h != null;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionSendMessage(");
        boolean z2 = false;
        if (m474a()) {
            sb.append("debug:");
            String str = this.f721a;
            if (str == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (m476b()) {
            if (!z) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            }
            sb.append("target:");
            hu huVar = this.f720a;
            if (huVar == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(huVar);
            }
        } else {
            z2 = z;
        }
        if (!z2) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        }
        sb.append("id:");
        String str2 = this.f725b;
        if (str2 == null) {
            sb.append(StringUtil.NULL_STRING);
        } else {
            sb.append(str2);
        }
        sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        sb.append("appId:");
        String str3 = this.f726c;
        if (str3 == null) {
            sb.append(StringUtil.NULL_STRING);
        } else {
            sb.append(str3);
        }
        if (m479e()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("packageName:");
            String str4 = this.f727d;
            if (str4 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str4);
            }
        }
        if (m480f()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append(UrlSchemaHelper.SCHEMA_TYPE_TOPIC);
            String str5 = this.f728e;
            if (str5 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str5);
            }
        }
        if (g()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("aliasName:");
            String str6 = this.f729f;
            if (str6 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str6);
            }
        }
        if (h()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("message:");
            hr hrVar = this.f719a;
            if (hrVar == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(hrVar);
            }
        }
        if (i()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("needAck:");
            sb.append(this.f724a);
        }
        if (j()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("params:");
            Map<String, String> map = this.f723a;
            if (map == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(map);
            }
        }
        if (k()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("category:");
            String str7 = this.f730g;
            if (str7 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str7);
            }
        }
        if (l()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("userAccount:");
            String str8 = this.f731h;
            if (str8 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str8);
            }
        }
        sb.append(SmallTailInfo.EMOTION_SUFFIX);
        return sb.toString();
    }
}
