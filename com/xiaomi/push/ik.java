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
    public ht f725a;

    /* renamed from: a  reason: collision with other field name */
    public hw f726a;

    /* renamed from: a  reason: collision with other field name */
    public String f727a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f729a;

    /* renamed from: b  reason: collision with other field name */
    public String f731b;

    /* renamed from: c  reason: collision with other field name */
    public String f732c;

    /* renamed from: d  reason: collision with other field name */
    public String f733d;

    /* renamed from: e  reason: collision with other field name */
    public String f734e;

    /* renamed from: f  reason: collision with other field name */
    public String f735f;

    /* renamed from: g  reason: collision with other field name */
    public String f736g;

    /* renamed from: h  reason: collision with other field name */
    public String f737h;

    /* renamed from: a  reason: collision with other field name */
    public static final ji f724a = new ji("XmPushActionSendMessage");
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
    public BitSet f728a = new BitSet(1);

    /* renamed from: a  reason: collision with other field name */
    public boolean f730a = true;

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
            int compareTo = Boolean.valueOf(m664a()).compareTo(Boolean.valueOf(ikVar.m664a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m664a() || (a13 = it.a(this.f727a, ikVar.f727a)) == 0) {
                int compareTo2 = Boolean.valueOf(m666b()).compareTo(Boolean.valueOf(ikVar.m666b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!m666b() || (a12 = it.a(this.f726a, ikVar.f726a)) == 0) {
                    int compareTo3 = Boolean.valueOf(m667c()).compareTo(Boolean.valueOf(ikVar.m667c()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!m667c() || (a11 = it.a(this.f731b, ikVar.f731b)) == 0) {
                        int compareTo4 = Boolean.valueOf(m668d()).compareTo(Boolean.valueOf(ikVar.m668d()));
                        if (compareTo4 != 0) {
                            return compareTo4;
                        }
                        if (!m668d() || (a10 = it.a(this.f732c, ikVar.f732c)) == 0) {
                            int compareTo5 = Boolean.valueOf(m669e()).compareTo(Boolean.valueOf(ikVar.m669e()));
                            if (compareTo5 != 0) {
                                return compareTo5;
                            }
                            if (!m669e() || (a9 = it.a(this.f733d, ikVar.f733d)) == 0) {
                                int compareTo6 = Boolean.valueOf(m670f()).compareTo(Boolean.valueOf(ikVar.m670f()));
                                if (compareTo6 != 0) {
                                    return compareTo6;
                                }
                                if (!m670f() || (a8 = it.a(this.f734e, ikVar.f734e)) == 0) {
                                    int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ikVar.g()));
                                    if (compareTo7 != 0) {
                                        return compareTo7;
                                    }
                                    if (!g() || (a7 = it.a(this.f735f, ikVar.f735f)) == 0) {
                                        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(ikVar.h()));
                                        if (compareTo8 != 0) {
                                            return compareTo8;
                                        }
                                        if (!h() || (a6 = it.a(this.f725a, ikVar.f725a)) == 0) {
                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(ikVar.i()));
                                            if (compareTo9 != 0) {
                                                return compareTo9;
                                            }
                                            if (!i() || (a5 = it.a(this.f730a, ikVar.f730a)) == 0) {
                                                int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(ikVar.j()));
                                                if (compareTo10 != 0) {
                                                    return compareTo10;
                                                }
                                                if (!j() || (a4 = it.a(this.f729a, ikVar.f729a)) == 0) {
                                                    int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(ikVar.k()));
                                                    if (compareTo11 != 0) {
                                                        return compareTo11;
                                                    }
                                                    if (!k() || (a3 = it.a(this.f736g, ikVar.f736g)) == 0) {
                                                        int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(ikVar.l()));
                                                        if (compareTo12 != 0) {
                                                            return compareTo12;
                                                        }
                                                        if (!l() || (a2 = it.a(this.f737h, ikVar.f737h)) == 0) {
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
        return this.f725a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m662a() {
        return this.f731b;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m663a() {
        if (this.f731b == null) {
            throw new je("Required field 'id' was not present! Struct: " + toString());
        } else if (this.f732c != null) {
        } else {
            throw new je("Required field 'appId' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.is
    public void a(jd jdVar) {
        jdVar.mo700a();
        while (true) {
            ja mo696a = jdVar.mo696a();
            byte b2 = mo696a.a;
            if (b2 == 0) {
                jdVar.f();
                m663a();
                return;
            }
            switch (mo696a.f814a) {
                case 1:
                    if (b2 == 11) {
                        this.f727a = jdVar.mo701a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 2:
                    if (b2 == 12) {
                        hw hwVar = new hw();
                        this.f726a = hwVar;
                        hwVar.a(jdVar);
                        continue;
                        jdVar.g();
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f731b = jdVar.mo701a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f732c = jdVar.mo701a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 5:
                    if (b2 == 11) {
                        this.f733d = jdVar.mo701a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 6:
                    if (b2 == 11) {
                        this.f734e = jdVar.mo701a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f735f = jdVar.mo701a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 8:
                    if (b2 == 12) {
                        ht htVar = new ht();
                        this.f725a = htVar;
                        htVar.a(jdVar);
                        continue;
                        jdVar.g();
                    }
                    break;
                case 9:
                    if (b2 == 2) {
                        this.f730a = jdVar.mo706a();
                        a(true);
                        continue;
                        jdVar.g();
                    }
                    break;
                case 10:
                    if (b2 == 13) {
                        jc mo698a = jdVar.mo698a();
                        this.f729a = new HashMap(mo698a.f816a * 2);
                        for (int i2 = 0; i2 < mo698a.f816a; i2++) {
                            this.f729a.put(jdVar.mo701a(), jdVar.mo701a());
                        }
                        jdVar.h();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 11:
                    if (b2 == 11) {
                        this.f736g = jdVar.mo701a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 12:
                    if (b2 == 11) {
                        this.f737h = jdVar.mo701a();
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
        this.f728a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m664a() {
        return this.f727a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m665a(ik ikVar) {
        if (ikVar == null) {
            return false;
        }
        boolean m664a = m664a();
        boolean m664a2 = ikVar.m664a();
        if ((m664a || m664a2) && !(m664a && m664a2 && this.f727a.equals(ikVar.f727a))) {
            return false;
        }
        boolean m666b = m666b();
        boolean m666b2 = ikVar.m666b();
        if ((m666b || m666b2) && !(m666b && m666b2 && this.f726a.m596a(ikVar.f726a))) {
            return false;
        }
        boolean m667c = m667c();
        boolean m667c2 = ikVar.m667c();
        if ((m667c || m667c2) && !(m667c && m667c2 && this.f731b.equals(ikVar.f731b))) {
            return false;
        }
        boolean m668d = m668d();
        boolean m668d2 = ikVar.m668d();
        if ((m668d || m668d2) && !(m668d && m668d2 && this.f732c.equals(ikVar.f732c))) {
            return false;
        }
        boolean m669e = m669e();
        boolean m669e2 = ikVar.m669e();
        if ((m669e || m669e2) && !(m669e && m669e2 && this.f733d.equals(ikVar.f733d))) {
            return false;
        }
        boolean m670f = m670f();
        boolean m670f2 = ikVar.m670f();
        if ((m670f || m670f2) && !(m670f && m670f2 && this.f734e.equals(ikVar.f734e))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = ikVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f735f.equals(ikVar.f735f))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = ikVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f725a.m579a(ikVar.f725a))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = ikVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f730a == ikVar.f730a)) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = ikVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f729a.equals(ikVar.f729a))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = ikVar.k();
        if ((k2 || k3) && !(k2 && k3 && this.f736g.equals(ikVar.f736g))) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = ikVar.l();
        if (l2 || l3) {
            return l2 && l3 && this.f737h.equals(ikVar.f737h);
        }
        return true;
    }

    public String b() {
        return this.f732c;
    }

    @Override // com.xiaomi.push.is
    public void b(jd jdVar) {
        m663a();
        jdVar.a(f724a);
        if (this.f727a != null && m664a()) {
            jdVar.a(a);
            jdVar.a(this.f727a);
            jdVar.b();
        }
        if (this.f726a != null && m666b()) {
            jdVar.a(b);
            this.f726a.b(jdVar);
            jdVar.b();
        }
        if (this.f731b != null) {
            jdVar.a(c);
            jdVar.a(this.f731b);
            jdVar.b();
        }
        if (this.f732c != null) {
            jdVar.a(d);
            jdVar.a(this.f732c);
            jdVar.b();
        }
        if (this.f733d != null && m669e()) {
            jdVar.a(e);
            jdVar.a(this.f733d);
            jdVar.b();
        }
        if (this.f734e != null && m670f()) {
            jdVar.a(f);
            jdVar.a(this.f734e);
            jdVar.b();
        }
        if (this.f735f != null && g()) {
            jdVar.a(g);
            jdVar.a(this.f735f);
            jdVar.b();
        }
        if (this.f725a != null && h()) {
            jdVar.a(h);
            this.f725a.b(jdVar);
            jdVar.b();
        }
        if (i()) {
            jdVar.a(i);
            jdVar.a(this.f730a);
            jdVar.b();
        }
        if (this.f729a != null && j()) {
            jdVar.a(j);
            jdVar.a(new jc(Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, this.f729a.size()));
            for (Map.Entry<String, String> entry : this.f729a.entrySet()) {
                jdVar.a(entry.getKey());
                jdVar.a(entry.getValue());
            }
            jdVar.d();
            jdVar.b();
        }
        if (this.f736g != null && k()) {
            jdVar.a(k);
            jdVar.a(this.f736g);
            jdVar.b();
        }
        if (this.f737h != null && l()) {
            jdVar.a(l);
            jdVar.a(this.f737h);
            jdVar.b();
        }
        jdVar.c();
        jdVar.mo704a();
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m666b() {
        return this.f726a != null;
    }

    public String c() {
        return this.f734e;
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m667c() {
        return this.f731b != null;
    }

    public String d() {
        return this.f735f;
    }

    /* renamed from: d  reason: collision with other method in class */
    public boolean m668d() {
        return this.f732c != null;
    }

    public String e() {
        return this.f736g;
    }

    /* renamed from: e  reason: collision with other method in class */
    public boolean m669e() {
        return this.f733d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ik)) {
            return m665a((ik) obj);
        }
        return false;
    }

    public String f() {
        return this.f737h;
    }

    /* renamed from: f  reason: collision with other method in class */
    public boolean m670f() {
        return this.f734e != null;
    }

    public boolean g() {
        return this.f735f != null;
    }

    public boolean h() {
        return this.f725a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f728a.get(0);
    }

    public boolean j() {
        return this.f729a != null;
    }

    public boolean k() {
        return this.f736g != null;
    }

    public boolean l() {
        return this.f737h != null;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionSendMessage(");
        boolean z2 = false;
        if (m664a()) {
            sb.append("debug:");
            String str = this.f727a;
            if (str == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (m666b()) {
            if (!z) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            }
            sb.append("target:");
            hw hwVar = this.f726a;
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
        String str2 = this.f731b;
        if (str2 == null) {
            sb.append(StringUtil.NULL_STRING);
        } else {
            sb.append(str2);
        }
        sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        sb.append("appId:");
        String str3 = this.f732c;
        if (str3 == null) {
            sb.append(StringUtil.NULL_STRING);
        } else {
            sb.append(str3);
        }
        if (m669e()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("packageName:");
            String str4 = this.f733d;
            if (str4 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str4);
            }
        }
        if (m670f()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append(UrlSchemaHelper.SCHEMA_TYPE_TOPIC);
            String str5 = this.f734e;
            if (str5 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str5);
            }
        }
        if (g()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("aliasName:");
            String str6 = this.f735f;
            if (str6 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str6);
            }
        }
        if (h()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("message:");
            ht htVar = this.f725a;
            if (htVar == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(htVar);
            }
        }
        if (i()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("needAck:");
            sb.append(this.f730a);
        }
        if (j()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("params:");
            Map<String, String> map = this.f729a;
            if (map == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(map);
            }
        }
        if (k()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("category:");
            String str7 = this.f736g;
            if (str7 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str7);
            }
        }
        if (l()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("userAccount:");
            String str8 = this.f737h;
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
