package com.xiaomi.push;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes10.dex */
public class ik implements is<ik, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public ht f724a;

    /* renamed from: a  reason: collision with other field name */
    public hw f725a;

    /* renamed from: a  reason: collision with other field name */
    public String f726a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f728a;

    /* renamed from: b  reason: collision with other field name */
    public String f730b;

    /* renamed from: c  reason: collision with other field name */
    public String f731c;

    /* renamed from: d  reason: collision with other field name */
    public String f732d;

    /* renamed from: e  reason: collision with other field name */
    public String f733e;

    /* renamed from: f  reason: collision with other field name */
    public String f734f;

    /* renamed from: g  reason: collision with other field name */
    public String f735g;

    /* renamed from: h  reason: collision with other field name */
    public String f736h;

    /* renamed from: a  reason: collision with other field name */
    public static final ji f723a = new ji("XmPushActionSendMessage");
    public static final ja a = new ja("", Constants.GZIP_CAST_TYPE, 1);
    public static final ja b = new ja("", (byte) 12, 2);
    public static final ja c = new ja("", Constants.GZIP_CAST_TYPE, 3);
    public static final ja d = new ja("", Constants.GZIP_CAST_TYPE, 4);
    public static final ja e = new ja("", Constants.GZIP_CAST_TYPE, 5);
    public static final ja f = new ja("", Constants.GZIP_CAST_TYPE, 6);
    public static final ja g = new ja("", Constants.GZIP_CAST_TYPE, 7);
    public static final ja h = new ja("", (byte) 12, 8);
    public static final ja i = new ja("", (byte) 2, 9);
    public static final ja j = new ja("", (byte) 13, 10);
    public static final ja k = new ja("", Constants.GZIP_CAST_TYPE, 11);
    public static final ja l = new ja("", Constants.GZIP_CAST_TYPE, 12);

    /* renamed from: a  reason: collision with other field name */
    public BitSet f727a = new BitSet(1);

    /* renamed from: a  reason: collision with other field name */
    public boolean f729a = true;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(ik ikVar) {
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
        if (ik.class.equals(ikVar.getClass())) {
            int compareTo = Boolean.valueOf(m670a()).compareTo(Boolean.valueOf(ikVar.m670a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m670a() || (a13 = it.a(this.f726a, ikVar.f726a)) == 0) {
                int compareTo2 = Boolean.valueOf(m672b()).compareTo(Boolean.valueOf(ikVar.m672b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!m672b() || (a12 = it.a(this.f725a, ikVar.f725a)) == 0) {
                    int compareTo3 = Boolean.valueOf(m673c()).compareTo(Boolean.valueOf(ikVar.m673c()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!m673c() || (a11 = it.a(this.f730b, ikVar.f730b)) == 0) {
                        int compareTo4 = Boolean.valueOf(m674d()).compareTo(Boolean.valueOf(ikVar.m674d()));
                        if (compareTo4 != 0) {
                            return compareTo4;
                        }
                        if (!m674d() || (a10 = it.a(this.f731c, ikVar.f731c)) == 0) {
                            int compareTo5 = Boolean.valueOf(m675e()).compareTo(Boolean.valueOf(ikVar.m675e()));
                            if (compareTo5 != 0) {
                                return compareTo5;
                            }
                            if (!m675e() || (a9 = it.a(this.f732d, ikVar.f732d)) == 0) {
                                int compareTo6 = Boolean.valueOf(m676f()).compareTo(Boolean.valueOf(ikVar.m676f()));
                                if (compareTo6 != 0) {
                                    return compareTo6;
                                }
                                if (!m676f() || (a8 = it.a(this.f733e, ikVar.f733e)) == 0) {
                                    int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ikVar.g()));
                                    if (compareTo7 != 0) {
                                        return compareTo7;
                                    }
                                    if (!g() || (a7 = it.a(this.f734f, ikVar.f734f)) == 0) {
                                        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(ikVar.h()));
                                        if (compareTo8 != 0) {
                                            return compareTo8;
                                        }
                                        if (!h() || (a6 = it.a(this.f724a, ikVar.f724a)) == 0) {
                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(ikVar.i()));
                                            if (compareTo9 != 0) {
                                                return compareTo9;
                                            }
                                            if (!i() || (a5 = it.a(this.f729a, ikVar.f729a)) == 0) {
                                                int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(ikVar.j()));
                                                if (compareTo10 != 0) {
                                                    return compareTo10;
                                                }
                                                if (!j() || (a4 = it.a(this.f728a, ikVar.f728a)) == 0) {
                                                    int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(ikVar.k()));
                                                    if (compareTo11 != 0) {
                                                        return compareTo11;
                                                    }
                                                    if (!k() || (a3 = it.a(this.f735g, ikVar.f735g)) == 0) {
                                                        int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(ikVar.l()));
                                                        if (compareTo12 != 0) {
                                                            return compareTo12;
                                                        }
                                                        if (!l() || (a2 = it.a(this.f736h, ikVar.f736h)) == 0) {
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
        return ik.class.getName().compareTo(ikVar.getClass().getName());
    }

    public ht a() {
        return this.f724a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m668a() {
        return this.f730b;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m669a() {
        if (this.f730b == null) {
            throw new je("Required field 'id' was not present! Struct: " + toString());
        } else if (this.f731c != null) {
        } else {
            throw new je("Required field 'appId' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.is
    public void a(jd jdVar) {
        jdVar.mo706a();
        while (true) {
            ja mo702a = jdVar.mo702a();
            byte b2 = mo702a.a;
            if (b2 == 0) {
                jdVar.f();
                m669a();
                return;
            }
            switch (mo702a.f813a) {
                case 1:
                    if (b2 == 11) {
                        this.f726a = jdVar.mo707a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 2:
                    if (b2 == 12) {
                        hw hwVar = new hw();
                        this.f725a = hwVar;
                        hwVar.a(jdVar);
                        continue;
                        jdVar.g();
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f730b = jdVar.mo707a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f731c = jdVar.mo707a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 5:
                    if (b2 == 11) {
                        this.f732d = jdVar.mo707a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 6:
                    if (b2 == 11) {
                        this.f733e = jdVar.mo707a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f734f = jdVar.mo707a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 8:
                    if (b2 == 12) {
                        ht htVar = new ht();
                        this.f724a = htVar;
                        htVar.a(jdVar);
                        continue;
                        jdVar.g();
                    }
                    break;
                case 9:
                    if (b2 == 2) {
                        this.f729a = jdVar.mo712a();
                        a(true);
                        continue;
                        jdVar.g();
                    }
                    break;
                case 10:
                    if (b2 == 13) {
                        jc mo704a = jdVar.mo704a();
                        this.f728a = new HashMap(mo704a.f815a * 2);
                        for (int i2 = 0; i2 < mo704a.f815a; i2++) {
                            this.f728a.put(jdVar.mo707a(), jdVar.mo707a());
                        }
                        jdVar.h();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 11:
                    if (b2 == 11) {
                        this.f735g = jdVar.mo707a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 12:
                    if (b2 == 11) {
                        this.f736h = jdVar.mo707a();
                        continue;
                        jdVar.g();
                    }
                    break;
            }
            jg.a(jdVar, b2);
            jdVar.g();
        }
    }

    public void a(boolean z) {
        this.f727a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m670a() {
        return this.f726a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m671a(ik ikVar) {
        if (ikVar == null) {
            return false;
        }
        boolean m670a = m670a();
        boolean m670a2 = ikVar.m670a();
        if ((m670a || m670a2) && !(m670a && m670a2 && this.f726a.equals(ikVar.f726a))) {
            return false;
        }
        boolean m672b = m672b();
        boolean m672b2 = ikVar.m672b();
        if ((m672b || m672b2) && !(m672b && m672b2 && this.f725a.m602a(ikVar.f725a))) {
            return false;
        }
        boolean m673c = m673c();
        boolean m673c2 = ikVar.m673c();
        if ((m673c || m673c2) && !(m673c && m673c2 && this.f730b.equals(ikVar.f730b))) {
            return false;
        }
        boolean m674d = m674d();
        boolean m674d2 = ikVar.m674d();
        if ((m674d || m674d2) && !(m674d && m674d2 && this.f731c.equals(ikVar.f731c))) {
            return false;
        }
        boolean m675e = m675e();
        boolean m675e2 = ikVar.m675e();
        if ((m675e || m675e2) && !(m675e && m675e2 && this.f732d.equals(ikVar.f732d))) {
            return false;
        }
        boolean m676f = m676f();
        boolean m676f2 = ikVar.m676f();
        if ((m676f || m676f2) && !(m676f && m676f2 && this.f733e.equals(ikVar.f733e))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = ikVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f734f.equals(ikVar.f734f))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = ikVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f724a.m585a(ikVar.f724a))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = ikVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f729a == ikVar.f729a)) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = ikVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f728a.equals(ikVar.f728a))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = ikVar.k();
        if ((k2 || k3) && !(k2 && k3 && this.f735g.equals(ikVar.f735g))) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = ikVar.l();
        if (l2 || l3) {
            return l2 && l3 && this.f736h.equals(ikVar.f736h);
        }
        return true;
    }

    public String b() {
        return this.f731c;
    }

    @Override // com.xiaomi.push.is
    public void b(jd jdVar) {
        m669a();
        jdVar.a(f723a);
        if (this.f726a != null && m670a()) {
            jdVar.a(a);
            jdVar.a(this.f726a);
            jdVar.b();
        }
        if (this.f725a != null && m672b()) {
            jdVar.a(b);
            this.f725a.b(jdVar);
            jdVar.b();
        }
        if (this.f730b != null) {
            jdVar.a(c);
            jdVar.a(this.f730b);
            jdVar.b();
        }
        if (this.f731c != null) {
            jdVar.a(d);
            jdVar.a(this.f731c);
            jdVar.b();
        }
        if (this.f732d != null && m675e()) {
            jdVar.a(e);
            jdVar.a(this.f732d);
            jdVar.b();
        }
        if (this.f733e != null && m676f()) {
            jdVar.a(f);
            jdVar.a(this.f733e);
            jdVar.b();
        }
        if (this.f734f != null && g()) {
            jdVar.a(g);
            jdVar.a(this.f734f);
            jdVar.b();
        }
        if (this.f724a != null && h()) {
            jdVar.a(h);
            this.f724a.b(jdVar);
            jdVar.b();
        }
        if (i()) {
            jdVar.a(i);
            jdVar.a(this.f729a);
            jdVar.b();
        }
        if (this.f728a != null && j()) {
            jdVar.a(j);
            jdVar.a(new jc(Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, this.f728a.size()));
            for (Map.Entry<String, String> entry : this.f728a.entrySet()) {
                jdVar.a(entry.getKey());
                jdVar.a(entry.getValue());
            }
            jdVar.d();
            jdVar.b();
        }
        if (this.f735g != null && k()) {
            jdVar.a(k);
            jdVar.a(this.f735g);
            jdVar.b();
        }
        if (this.f736h != null && l()) {
            jdVar.a(l);
            jdVar.a(this.f736h);
            jdVar.b();
        }
        jdVar.c();
        jdVar.mo710a();
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m672b() {
        return this.f725a != null;
    }

    public String c() {
        return this.f733e;
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m673c() {
        return this.f730b != null;
    }

    public String d() {
        return this.f734f;
    }

    /* renamed from: d  reason: collision with other method in class */
    public boolean m674d() {
        return this.f731c != null;
    }

    public String e() {
        return this.f735g;
    }

    /* renamed from: e  reason: collision with other method in class */
    public boolean m675e() {
        return this.f732d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ik)) {
            return m671a((ik) obj);
        }
        return false;
    }

    public String f() {
        return this.f736h;
    }

    /* renamed from: f  reason: collision with other method in class */
    public boolean m676f() {
        return this.f733e != null;
    }

    public boolean g() {
        return this.f734f != null;
    }

    public boolean h() {
        return this.f724a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f727a.get(0);
    }

    public boolean j() {
        return this.f728a != null;
    }

    public boolean k() {
        return this.f735g != null;
    }

    public boolean l() {
        return this.f736h != null;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionSendMessage(");
        boolean z2 = false;
        if (m670a()) {
            sb.append("debug:");
            String str = this.f726a;
            if (str == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (m672b()) {
            if (!z) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            }
            sb.append("target:");
            hw hwVar = this.f725a;
            if (hwVar == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(hwVar);
            }
        } else {
            z2 = z;
        }
        if (!z2) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        }
        sb.append("id:");
        String str2 = this.f730b;
        if (str2 == null) {
            sb.append(StringUtil.NULL_STRING);
        } else {
            sb.append(str2);
        }
        sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        sb.append("appId:");
        String str3 = this.f731c;
        if (str3 == null) {
            sb.append(StringUtil.NULL_STRING);
        } else {
            sb.append(str3);
        }
        if (m675e()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("packageName:");
            String str4 = this.f732d;
            if (str4 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str4);
            }
        }
        if (m676f()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append(UrlSchemaHelper.SCHEMA_TYPE_TOPIC);
            String str5 = this.f733e;
            if (str5 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str5);
            }
        }
        if (g()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("aliasName:");
            String str6 = this.f734f;
            if (str6 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str6);
            }
        }
        if (h()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("message:");
            ht htVar = this.f724a;
            if (htVar == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(htVar);
            }
        }
        if (i()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("needAck:");
            sb.append(this.f729a);
        }
        if (j()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("params:");
            Map<String, String> map = this.f728a;
            if (map == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(map);
            }
        }
        if (k()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("category:");
            String str7 = this.f735g;
            if (str7 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str7);
            }
        }
        if (l()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("userAccount:");
            String str8 = this.f736h;
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
