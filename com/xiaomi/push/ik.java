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
    public ht f720a;

    /* renamed from: a  reason: collision with other field name */
    public hw f721a;

    /* renamed from: a  reason: collision with other field name */
    public String f722a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f724a;

    /* renamed from: b  reason: collision with other field name */
    public String f726b;

    /* renamed from: c  reason: collision with other field name */
    public String f727c;

    /* renamed from: d  reason: collision with other field name */
    public String f728d;

    /* renamed from: e  reason: collision with other field name */
    public String f729e;

    /* renamed from: f  reason: collision with other field name */
    public String f730f;

    /* renamed from: g  reason: collision with other field name */
    public String f731g;

    /* renamed from: h  reason: collision with other field name */
    public String f732h;

    /* renamed from: a  reason: collision with other field name */
    public static final ji f719a = new ji("XmPushActionSendMessage");
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
    public BitSet f723a = new BitSet(1);

    /* renamed from: a  reason: collision with other field name */
    public boolean f725a = true;

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
            int compareTo = Boolean.valueOf(m674a()).compareTo(Boolean.valueOf(ikVar.m674a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m674a() || (a13 = it.a(this.f722a, ikVar.f722a)) == 0) {
                int compareTo2 = Boolean.valueOf(m676b()).compareTo(Boolean.valueOf(ikVar.m676b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!m676b() || (a12 = it.a(this.f721a, ikVar.f721a)) == 0) {
                    int compareTo3 = Boolean.valueOf(m677c()).compareTo(Boolean.valueOf(ikVar.m677c()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!m677c() || (a11 = it.a(this.f726b, ikVar.f726b)) == 0) {
                        int compareTo4 = Boolean.valueOf(m678d()).compareTo(Boolean.valueOf(ikVar.m678d()));
                        if (compareTo4 != 0) {
                            return compareTo4;
                        }
                        if (!m678d() || (a10 = it.a(this.f727c, ikVar.f727c)) == 0) {
                            int compareTo5 = Boolean.valueOf(m679e()).compareTo(Boolean.valueOf(ikVar.m679e()));
                            if (compareTo5 != 0) {
                                return compareTo5;
                            }
                            if (!m679e() || (a9 = it.a(this.f728d, ikVar.f728d)) == 0) {
                                int compareTo6 = Boolean.valueOf(m680f()).compareTo(Boolean.valueOf(ikVar.m680f()));
                                if (compareTo6 != 0) {
                                    return compareTo6;
                                }
                                if (!m680f() || (a8 = it.a(this.f729e, ikVar.f729e)) == 0) {
                                    int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ikVar.g()));
                                    if (compareTo7 != 0) {
                                        return compareTo7;
                                    }
                                    if (!g() || (a7 = it.a(this.f730f, ikVar.f730f)) == 0) {
                                        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(ikVar.h()));
                                        if (compareTo8 != 0) {
                                            return compareTo8;
                                        }
                                        if (!h() || (a6 = it.a(this.f720a, ikVar.f720a)) == 0) {
                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(ikVar.i()));
                                            if (compareTo9 != 0) {
                                                return compareTo9;
                                            }
                                            if (!i() || (a5 = it.a(this.f725a, ikVar.f725a)) == 0) {
                                                int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(ikVar.j()));
                                                if (compareTo10 != 0) {
                                                    return compareTo10;
                                                }
                                                if (!j() || (a4 = it.a(this.f724a, ikVar.f724a)) == 0) {
                                                    int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(ikVar.k()));
                                                    if (compareTo11 != 0) {
                                                        return compareTo11;
                                                    }
                                                    if (!k() || (a3 = it.a(this.f731g, ikVar.f731g)) == 0) {
                                                        int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(ikVar.l()));
                                                        if (compareTo12 != 0) {
                                                            return compareTo12;
                                                        }
                                                        if (!l() || (a2 = it.a(this.f732h, ikVar.f732h)) == 0) {
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
        return this.f720a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m672a() {
        return this.f726b;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m673a() {
        if (this.f726b == null) {
            throw new je("Required field 'id' was not present! Struct: " + toString());
        } else if (this.f727c != null) {
        } else {
            throw new je("Required field 'appId' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.is
    public void a(jd jdVar) {
        jdVar.mo710a();
        while (true) {
            ja mo706a = jdVar.mo706a();
            byte b2 = mo706a.a;
            if (b2 == 0) {
                jdVar.f();
                m673a();
                return;
            }
            switch (mo706a.f809a) {
                case 1:
                    if (b2 == 11) {
                        this.f722a = jdVar.mo711a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 2:
                    if (b2 == 12) {
                        hw hwVar = new hw();
                        this.f721a = hwVar;
                        hwVar.a(jdVar);
                        continue;
                        jdVar.g();
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f726b = jdVar.mo711a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f727c = jdVar.mo711a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 5:
                    if (b2 == 11) {
                        this.f728d = jdVar.mo711a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 6:
                    if (b2 == 11) {
                        this.f729e = jdVar.mo711a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f730f = jdVar.mo711a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 8:
                    if (b2 == 12) {
                        ht htVar = new ht();
                        this.f720a = htVar;
                        htVar.a(jdVar);
                        continue;
                        jdVar.g();
                    }
                    break;
                case 9:
                    if (b2 == 2) {
                        this.f725a = jdVar.mo716a();
                        a(true);
                        continue;
                        jdVar.g();
                    }
                    break;
                case 10:
                    if (b2 == 13) {
                        jc mo708a = jdVar.mo708a();
                        this.f724a = new HashMap(mo708a.f811a * 2);
                        for (int i2 = 0; i2 < mo708a.f811a; i2++) {
                            this.f724a.put(jdVar.mo711a(), jdVar.mo711a());
                        }
                        jdVar.h();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 11:
                    if (b2 == 11) {
                        this.f731g = jdVar.mo711a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 12:
                    if (b2 == 11) {
                        this.f732h = jdVar.mo711a();
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
        this.f723a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m674a() {
        return this.f722a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m675a(ik ikVar) {
        if (ikVar == null) {
            return false;
        }
        boolean m674a = m674a();
        boolean m674a2 = ikVar.m674a();
        if ((m674a || m674a2) && !(m674a && m674a2 && this.f722a.equals(ikVar.f722a))) {
            return false;
        }
        boolean m676b = m676b();
        boolean m676b2 = ikVar.m676b();
        if ((m676b || m676b2) && !(m676b && m676b2 && this.f721a.m606a(ikVar.f721a))) {
            return false;
        }
        boolean m677c = m677c();
        boolean m677c2 = ikVar.m677c();
        if ((m677c || m677c2) && !(m677c && m677c2 && this.f726b.equals(ikVar.f726b))) {
            return false;
        }
        boolean m678d = m678d();
        boolean m678d2 = ikVar.m678d();
        if ((m678d || m678d2) && !(m678d && m678d2 && this.f727c.equals(ikVar.f727c))) {
            return false;
        }
        boolean m679e = m679e();
        boolean m679e2 = ikVar.m679e();
        if ((m679e || m679e2) && !(m679e && m679e2 && this.f728d.equals(ikVar.f728d))) {
            return false;
        }
        boolean m680f = m680f();
        boolean m680f2 = ikVar.m680f();
        if ((m680f || m680f2) && !(m680f && m680f2 && this.f729e.equals(ikVar.f729e))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = ikVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f730f.equals(ikVar.f730f))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = ikVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f720a.m589a(ikVar.f720a))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = ikVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f725a == ikVar.f725a)) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = ikVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f724a.equals(ikVar.f724a))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = ikVar.k();
        if ((k2 || k3) && !(k2 && k3 && this.f731g.equals(ikVar.f731g))) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = ikVar.l();
        if (l2 || l3) {
            return l2 && l3 && this.f732h.equals(ikVar.f732h);
        }
        return true;
    }

    public String b() {
        return this.f727c;
    }

    @Override // com.xiaomi.push.is
    public void b(jd jdVar) {
        m673a();
        jdVar.a(f719a);
        if (this.f722a != null && m674a()) {
            jdVar.a(a);
            jdVar.a(this.f722a);
            jdVar.b();
        }
        if (this.f721a != null && m676b()) {
            jdVar.a(b);
            this.f721a.b(jdVar);
            jdVar.b();
        }
        if (this.f726b != null) {
            jdVar.a(c);
            jdVar.a(this.f726b);
            jdVar.b();
        }
        if (this.f727c != null) {
            jdVar.a(d);
            jdVar.a(this.f727c);
            jdVar.b();
        }
        if (this.f728d != null && m679e()) {
            jdVar.a(e);
            jdVar.a(this.f728d);
            jdVar.b();
        }
        if (this.f729e != null && m680f()) {
            jdVar.a(f);
            jdVar.a(this.f729e);
            jdVar.b();
        }
        if (this.f730f != null && g()) {
            jdVar.a(g);
            jdVar.a(this.f730f);
            jdVar.b();
        }
        if (this.f720a != null && h()) {
            jdVar.a(h);
            this.f720a.b(jdVar);
            jdVar.b();
        }
        if (i()) {
            jdVar.a(i);
            jdVar.a(this.f725a);
            jdVar.b();
        }
        if (this.f724a != null && j()) {
            jdVar.a(j);
            jdVar.a(new jc(Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, this.f724a.size()));
            for (Map.Entry<String, String> entry : this.f724a.entrySet()) {
                jdVar.a(entry.getKey());
                jdVar.a(entry.getValue());
            }
            jdVar.d();
            jdVar.b();
        }
        if (this.f731g != null && k()) {
            jdVar.a(k);
            jdVar.a(this.f731g);
            jdVar.b();
        }
        if (this.f732h != null && l()) {
            jdVar.a(l);
            jdVar.a(this.f732h);
            jdVar.b();
        }
        jdVar.c();
        jdVar.mo714a();
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m676b() {
        return this.f721a != null;
    }

    public String c() {
        return this.f729e;
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m677c() {
        return this.f726b != null;
    }

    public String d() {
        return this.f730f;
    }

    /* renamed from: d  reason: collision with other method in class */
    public boolean m678d() {
        return this.f727c != null;
    }

    public String e() {
        return this.f731g;
    }

    /* renamed from: e  reason: collision with other method in class */
    public boolean m679e() {
        return this.f728d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ik)) {
            return m675a((ik) obj);
        }
        return false;
    }

    public String f() {
        return this.f732h;
    }

    /* renamed from: f  reason: collision with other method in class */
    public boolean m680f() {
        return this.f729e != null;
    }

    public boolean g() {
        return this.f730f != null;
    }

    public boolean h() {
        return this.f720a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f723a.get(0);
    }

    public boolean j() {
        return this.f724a != null;
    }

    public boolean k() {
        return this.f731g != null;
    }

    public boolean l() {
        return this.f732h != null;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionSendMessage(");
        boolean z2 = false;
        if (m674a()) {
            sb.append("debug:");
            String str = this.f722a;
            if (str == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (m676b()) {
            if (!z) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            }
            sb.append("target:");
            hw hwVar = this.f721a;
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
        String str2 = this.f726b;
        if (str2 == null) {
            sb.append(StringUtil.NULL_STRING);
        } else {
            sb.append(str2);
        }
        sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        sb.append("appId:");
        String str3 = this.f727c;
        if (str3 == null) {
            sb.append(StringUtil.NULL_STRING);
        } else {
            sb.append(str3);
        }
        if (m679e()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("packageName:");
            String str4 = this.f728d;
            if (str4 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str4);
            }
        }
        if (m680f()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append(UrlSchemaHelper.SCHEMA_TYPE_TOPIC);
            String str5 = this.f729e;
            if (str5 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str5);
            }
        }
        if (g()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("aliasName:");
            String str6 = this.f730f;
            if (str6 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str6);
            }
        }
        if (h()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("message:");
            ht htVar = this.f720a;
            if (htVar == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(htVar);
            }
        }
        if (i()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("needAck:");
            sb.append(this.f725a);
        }
        if (j()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("params:");
            Map<String, String> map = this.f724a;
            if (map == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(map);
            }
        }
        if (k()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("category:");
            String str7 = this.f731g;
            if (str7 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str7);
            }
        }
        if (l()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("userAccount:");
            String str8 = this.f732h;
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
