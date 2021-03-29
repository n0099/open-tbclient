package com.xiaomi.push;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.tbadk.core.data.SmallTailInfo;
import io.flutter.plugin.common.StandardMessageCodec;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
/* loaded from: classes7.dex */
public class ia implements iq<ia, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f616a;

    /* renamed from: a  reason: collision with other field name */
    public hu f617a;

    /* renamed from: a  reason: collision with other field name */
    public String f618a;

    /* renamed from: a  reason: collision with other field name */
    public List<String> f620a;

    /* renamed from: b  reason: collision with other field name */
    public String f622b;

    /* renamed from: c  reason: collision with other field name */
    public String f623c;

    /* renamed from: d  reason: collision with other field name */
    public String f624d;

    /* renamed from: e  reason: collision with other field name */
    public String f625e;

    /* renamed from: f  reason: collision with other field name */
    public String f626f;

    /* renamed from: a  reason: collision with other field name */
    public static final jg f615a = new jg("XmPushActionCommandResult");

    /* renamed from: a  reason: collision with root package name */
    public static final iy f40749a = new iy("", StandardMessageCodec.LIST, 2);

    /* renamed from: b  reason: collision with root package name */
    public static final iy f40750b = new iy("", (byte) 11, 3);

    /* renamed from: c  reason: collision with root package name */
    public static final iy f40751c = new iy("", (byte) 11, 4);

    /* renamed from: d  reason: collision with root package name */
    public static final iy f40752d = new iy("", (byte) 11, 5);

    /* renamed from: e  reason: collision with root package name */
    public static final iy f40753e = new iy("", (byte) 10, 7);

    /* renamed from: f  reason: collision with root package name */
    public static final iy f40754f = new iy("", (byte) 11, 8);

    /* renamed from: g  reason: collision with root package name */
    public static final iy f40755g = new iy("", (byte) 11, 9);

    /* renamed from: h  reason: collision with root package name */
    public static final iy f40756h = new iy("", (byte) 15, 10);
    public static final iy i = new iy("", (byte) 11, 12);
    public static final iy j = new iy("", (byte) 2, 13);

    /* renamed from: a  reason: collision with other field name */
    public BitSet f619a = new BitSet(2);

    /* renamed from: a  reason: collision with other field name */
    public boolean f621a = true;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(ia iaVar) {
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
        if (ia.class.equals(iaVar.getClass())) {
            int compareTo = Boolean.valueOf(m427a()).compareTo(Boolean.valueOf(iaVar.m427a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m427a() || (a11 = ir.a(this.f617a, iaVar.f617a)) == 0) {
                int compareTo2 = Boolean.valueOf(m429b()).compareTo(Boolean.valueOf(iaVar.m429b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!m429b() || (a10 = ir.a(this.f618a, iaVar.f618a)) == 0) {
                    int compareTo3 = Boolean.valueOf(m430c()).compareTo(Boolean.valueOf(iaVar.m430c()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!m430c() || (a9 = ir.a(this.f622b, iaVar.f622b)) == 0) {
                        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(iaVar.d()));
                        if (compareTo4 != 0) {
                            return compareTo4;
                        }
                        if (!d() || (a8 = ir.a(this.f623c, iaVar.f623c)) == 0) {
                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(iaVar.e()));
                            if (compareTo5 != 0) {
                                return compareTo5;
                            }
                            if (!e() || (a7 = ir.a(this.f616a, iaVar.f616a)) == 0) {
                                int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(iaVar.f()));
                                if (compareTo6 != 0) {
                                    return compareTo6;
                                }
                                if (!f() || (a6 = ir.a(this.f624d, iaVar.f624d)) == 0) {
                                    int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(iaVar.g()));
                                    if (compareTo7 != 0) {
                                        return compareTo7;
                                    }
                                    if (!g() || (a5 = ir.a(this.f625e, iaVar.f625e)) == 0) {
                                        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(iaVar.h()));
                                        if (compareTo8 != 0) {
                                            return compareTo8;
                                        }
                                        if (!h() || (a4 = ir.a(this.f620a, iaVar.f620a)) == 0) {
                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(iaVar.i()));
                                            if (compareTo9 != 0) {
                                                return compareTo9;
                                            }
                                            if (!i() || (a3 = ir.a(this.f626f, iaVar.f626f)) == 0) {
                                                int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(iaVar.j()));
                                                if (compareTo10 != 0) {
                                                    return compareTo10;
                                                }
                                                if (!j() || (a2 = ir.a(this.f621a, iaVar.f621a)) == 0) {
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
        return ia.class.getName().compareTo(iaVar.getClass().getName());
    }

    public String a() {
        return this.f618a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public List<String> m425a() {
        return this.f620a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m426a() {
        if (this.f618a == null) {
            throw new jc("Required field 'id' was not present! Struct: " + toString());
        } else if (this.f622b == null) {
            throw new jc("Required field 'appId' was not present! Struct: " + toString());
        } else if (this.f623c != null) {
        } else {
            throw new jc("Required field 'cmdName' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.iq
    public void a(jb jbVar) {
        jbVar.m505a();
        while (true) {
            iy m501a = jbVar.m501a();
            byte b2 = m501a.f40867a;
            if (b2 == 0) {
                jbVar.f();
                if (e()) {
                    m426a();
                    return;
                }
                throw new jc("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
            }
            switch (m501a.f807a) {
                case 2:
                    if (b2 == 12) {
                        hu huVar = new hu();
                        this.f617a = huVar;
                        huVar.a(jbVar);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f618a = jbVar.m506a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f622b = jbVar.m506a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 5:
                    if (b2 == 11) {
                        this.f623c = jbVar.m506a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 7:
                    if (b2 == 10) {
                        this.f616a = jbVar.m500a();
                        a(true);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 8:
                    if (b2 == 11) {
                        this.f624d = jbVar.m506a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 9:
                    if (b2 == 11) {
                        this.f625e = jbVar.m506a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 10:
                    if (b2 == 15) {
                        iz m502a = jbVar.m502a();
                        this.f620a = new ArrayList(m502a.f808a);
                        for (int i2 = 0; i2 < m502a.f808a; i2++) {
                            this.f620a.add(jbVar.m506a());
                        }
                        jbVar.i();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 12:
                    if (b2 == 11) {
                        this.f626f = jbVar.m506a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 13:
                    if (b2 == 2) {
                        this.f621a = jbVar.m510a();
                        b(true);
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
        this.f619a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m427a() {
        return this.f617a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m428a(ia iaVar) {
        if (iaVar == null) {
            return false;
        }
        boolean m427a = m427a();
        boolean m427a2 = iaVar.m427a();
        if ((m427a || m427a2) && !(m427a && m427a2 && this.f617a.m400a(iaVar.f617a))) {
            return false;
        }
        boolean m429b = m429b();
        boolean m429b2 = iaVar.m429b();
        if ((m429b || m429b2) && !(m429b && m429b2 && this.f618a.equals(iaVar.f618a))) {
            return false;
        }
        boolean m430c = m430c();
        boolean m430c2 = iaVar.m430c();
        if ((m430c || m430c2) && !(m430c && m430c2 && this.f622b.equals(iaVar.f622b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = iaVar.d();
        if (((d2 || d3) && !(d2 && d3 && this.f623c.equals(iaVar.f623c))) || this.f616a != iaVar.f616a) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = iaVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f624d.equals(iaVar.f624d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = iaVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f625e.equals(iaVar.f625e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = iaVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f620a.equals(iaVar.f620a))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = iaVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f626f.equals(iaVar.f626f))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = iaVar.j();
        if (j2 || j3) {
            return j2 && j3 && this.f621a == iaVar.f621a;
        }
        return true;
    }

    public String b() {
        return this.f623c;
    }

    @Override // com.xiaomi.push.iq
    public void b(jb jbVar) {
        m426a();
        jbVar.a(f615a);
        if (this.f617a != null && m427a()) {
            jbVar.a(f40749a);
            this.f617a.b(jbVar);
            jbVar.b();
        }
        if (this.f618a != null) {
            jbVar.a(f40750b);
            jbVar.a(this.f618a);
            jbVar.b();
        }
        if (this.f622b != null) {
            jbVar.a(f40751c);
            jbVar.a(this.f622b);
            jbVar.b();
        }
        if (this.f623c != null) {
            jbVar.a(f40752d);
            jbVar.a(this.f623c);
            jbVar.b();
        }
        jbVar.a(f40753e);
        jbVar.a(this.f616a);
        jbVar.b();
        if (this.f624d != null && f()) {
            jbVar.a(f40754f);
            jbVar.a(this.f624d);
            jbVar.b();
        }
        if (this.f625e != null && g()) {
            jbVar.a(f40755g);
            jbVar.a(this.f625e);
            jbVar.b();
        }
        if (this.f620a != null && h()) {
            jbVar.a(f40756h);
            jbVar.a(new iz((byte) 11, this.f620a.size()));
            for (String str : this.f620a) {
                jbVar.a(str);
            }
            jbVar.e();
            jbVar.b();
        }
        if (this.f626f != null && i()) {
            jbVar.a(i);
            jbVar.a(this.f626f);
            jbVar.b();
        }
        if (j()) {
            jbVar.a(j);
            jbVar.a(this.f621a);
            jbVar.b();
        }
        jbVar.c();
        jbVar.m509a();
    }

    public void b(boolean z) {
        this.f619a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m429b() {
        return this.f618a != null;
    }

    public String c() {
        return this.f626f;
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m430c() {
        return this.f622b != null;
    }

    public boolean d() {
        return this.f623c != null;
    }

    public boolean e() {
        return this.f619a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ia)) {
            return m428a((ia) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f624d != null;
    }

    public boolean g() {
        return this.f625e != null;
    }

    public boolean h() {
        return this.f620a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f626f != null;
    }

    public boolean j() {
        return this.f619a.get(1);
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionCommandResult(");
        if (m427a()) {
            sb.append("target:");
            hu huVar = this.f617a;
            if (huVar == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(huVar);
            }
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        }
        sb.append("id:");
        String str = this.f618a;
        if (str == null) {
            sb.append(StringUtil.NULL_STRING);
        } else {
            sb.append(str);
        }
        sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        sb.append("appId:");
        String str2 = this.f622b;
        if (str2 == null) {
            sb.append(StringUtil.NULL_STRING);
        } else {
            sb.append(str2);
        }
        sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        sb.append("cmdName:");
        String str3 = this.f623c;
        if (str3 == null) {
            sb.append(StringUtil.NULL_STRING);
        } else {
            sb.append(str3);
        }
        sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        sb.append("errorCode:");
        sb.append(this.f616a);
        if (f()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("reason:");
            String str4 = this.f624d;
            if (str4 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str4);
            }
        }
        if (g()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("packageName:");
            String str5 = this.f625e;
            if (str5 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str5);
            }
        }
        if (h()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("cmdArgs:");
            List<String> list = this.f620a;
            if (list == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(list);
            }
        }
        if (i()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("category:");
            String str6 = this.f626f;
            if (str6 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str6);
            }
        }
        if (j()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("response2Client:");
            sb.append(this.f621a);
        }
        sb.append(SmallTailInfo.EMOTION_SUFFIX);
        return sb.toString();
    }
}
