package com.xiaomi.push;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes10.dex */
public class ig implements is<ig, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f645a;

    /* renamed from: a  reason: collision with other field name */
    public hw f646a;

    /* renamed from: a  reason: collision with other field name */
    public String f647a;

    /* renamed from: a  reason: collision with other field name */
    public ByteBuffer f648a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f649a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f650a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f651a;

    /* renamed from: b  reason: collision with other field name */
    public String f652b;

    /* renamed from: b  reason: collision with other field name */
    public boolean f653b;

    /* renamed from: c  reason: collision with other field name */
    public String f654c;

    /* renamed from: d  reason: collision with other field name */
    public String f655d;

    /* renamed from: e  reason: collision with other field name */
    public String f656e;

    /* renamed from: f  reason: collision with other field name */
    public String f657f;

    /* renamed from: g  reason: collision with other field name */
    public String f658g;

    /* renamed from: h  reason: collision with other field name */
    public String f659h;

    /* renamed from: i  reason: collision with other field name */
    public String f660i;

    /* renamed from: a  reason: collision with other field name */
    public static final ji f644a = new ji("XmPushActionNotification");
    public static final ja a = new ja("", Constants.GZIP_CAST_TYPE, 1);
    public static final ja b = new ja("", (byte) 12, 2);
    public static final ja c = new ja("", Constants.GZIP_CAST_TYPE, 3);
    public static final ja d = new ja("", Constants.GZIP_CAST_TYPE, 4);
    public static final ja e = new ja("", Constants.GZIP_CAST_TYPE, 5);
    public static final ja f = new ja("", (byte) 2, 6);
    public static final ja g = new ja("", Constants.GZIP_CAST_TYPE, 7);
    public static final ja h = new ja("", (byte) 13, 8);
    public static final ja i = new ja("", Constants.GZIP_CAST_TYPE, 9);
    public static final ja j = new ja("", Constants.GZIP_CAST_TYPE, 10);
    public static final ja k = new ja("", Constants.GZIP_CAST_TYPE, 12);
    public static final ja l = new ja("", Constants.GZIP_CAST_TYPE, 13);
    public static final ja m = new ja("", Constants.GZIP_CAST_TYPE, 14);
    public static final ja n = new ja("", (byte) 10, 15);
    public static final ja o = new ja("", (byte) 2, 20);

    public ig() {
        this.f649a = new BitSet(3);
        this.f651a = true;
        this.f653b = false;
    }

    public ig(String str, boolean z) {
        this();
        this.f652b = str;
        this.f651a = z;
        m645a(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(ig igVar) {
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
        int a15;
        int a16;
        if (ig.class.equals(igVar.getClass())) {
            int compareTo = Boolean.valueOf(m646a()).compareTo(Boolean.valueOf(igVar.m646a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m646a() || (a16 = it.a(this.f647a, igVar.f647a)) == 0) {
                int compareTo2 = Boolean.valueOf(m649b()).compareTo(Boolean.valueOf(igVar.m649b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!m649b() || (a15 = it.a(this.f646a, igVar.f646a)) == 0) {
                    int compareTo3 = Boolean.valueOf(m650c()).compareTo(Boolean.valueOf(igVar.m650c()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!m650c() || (a14 = it.a(this.f652b, igVar.f652b)) == 0) {
                        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(igVar.d()));
                        if (compareTo4 != 0) {
                            return compareTo4;
                        }
                        if (!d() || (a13 = it.a(this.f654c, igVar.f654c)) == 0) {
                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(igVar.e()));
                            if (compareTo5 != 0) {
                                return compareTo5;
                            }
                            if (!e() || (a12 = it.a(this.f655d, igVar.f655d)) == 0) {
                                int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(igVar.f()));
                                if (compareTo6 != 0) {
                                    return compareTo6;
                                }
                                if (!f() || (a11 = it.a(this.f651a, igVar.f651a)) == 0) {
                                    int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(igVar.g()));
                                    if (compareTo7 != 0) {
                                        return compareTo7;
                                    }
                                    if (!g() || (a10 = it.a(this.f656e, igVar.f656e)) == 0) {
                                        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(igVar.h()));
                                        if (compareTo8 != 0) {
                                            return compareTo8;
                                        }
                                        if (!h() || (a9 = it.a(this.f650a, igVar.f650a)) == 0) {
                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(igVar.i()));
                                            if (compareTo9 != 0) {
                                                return compareTo9;
                                            }
                                            if (!i() || (a8 = it.a(this.f657f, igVar.f657f)) == 0) {
                                                int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(igVar.j()));
                                                if (compareTo10 != 0) {
                                                    return compareTo10;
                                                }
                                                if (!j() || (a7 = it.a(this.f658g, igVar.f658g)) == 0) {
                                                    int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(igVar.k()));
                                                    if (compareTo11 != 0) {
                                                        return compareTo11;
                                                    }
                                                    if (!k() || (a6 = it.a(this.f659h, igVar.f659h)) == 0) {
                                                        int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(igVar.l()));
                                                        if (compareTo12 != 0) {
                                                            return compareTo12;
                                                        }
                                                        if (!l() || (a5 = it.a(this.f660i, igVar.f660i)) == 0) {
                                                            int compareTo13 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(igVar.m()));
                                                            if (compareTo13 != 0) {
                                                                return compareTo13;
                                                            }
                                                            if (!m() || (a4 = it.a(this.f648a, igVar.f648a)) == 0) {
                                                                int compareTo14 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(igVar.n()));
                                                                if (compareTo14 != 0) {
                                                                    return compareTo14;
                                                                }
                                                                if (!n() || (a3 = it.a(this.f645a, igVar.f645a)) == 0) {
                                                                    int compareTo15 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(igVar.o()));
                                                                    if (compareTo15 != 0) {
                                                                        return compareTo15;
                                                                    }
                                                                    if (!o() || (a2 = it.a(this.f653b, igVar.f653b)) == 0) {
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
                return a15;
            }
            return a16;
        }
        return ig.class.getName().compareTo(igVar.getClass().getName());
    }

    public hw a() {
        return this.f646a;
    }

    public ig a(String str) {
        this.f652b = str;
        return this;
    }

    public ig a(ByteBuffer byteBuffer) {
        this.f648a = byteBuffer;
        return this;
    }

    public ig a(Map<String, String> map) {
        this.f650a = map;
        return this;
    }

    public ig a(boolean z) {
        this.f651a = z;
        m645a(true);
        return this;
    }

    public ig a(byte[] bArr) {
        a(ByteBuffer.wrap(bArr));
        return this;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m642a() {
        return this.f652b;
    }

    /* renamed from: a  reason: collision with other method in class */
    public Map<String, String> m643a() {
        return this.f650a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m644a() {
        if (this.f652b != null) {
            return;
        }
        throw new je("Required field 'id' was not present! Struct: " + toString());
    }

    @Override // com.xiaomi.push.is
    public void a(jd jdVar) {
        jdVar.mo703a();
        while (true) {
            ja mo699a = jdVar.mo699a();
            byte b2 = mo699a.a;
            if (b2 == 0) {
                jdVar.f();
                if (f()) {
                    m644a();
                    return;
                }
                throw new je("Required field 'requireAck' was not found in serialized data! Struct: " + toString());
            }
            switch (mo699a.f813a) {
                case 1:
                    if (b2 == 11) {
                        this.f647a = jdVar.mo704a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 2:
                    if (b2 == 12) {
                        hw hwVar = new hw();
                        this.f646a = hwVar;
                        hwVar.a(jdVar);
                        continue;
                        jdVar.g();
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f652b = jdVar.mo704a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f654c = jdVar.mo704a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 5:
                    if (b2 == 11) {
                        this.f655d = jdVar.mo704a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 6:
                    if (b2 == 2) {
                        this.f651a = jdVar.mo709a();
                        m645a(true);
                        continue;
                        jdVar.g();
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f656e = jdVar.mo704a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 8:
                    if (b2 == 13) {
                        jc mo701a = jdVar.mo701a();
                        this.f650a = new HashMap(mo701a.f815a * 2);
                        for (int i2 = 0; i2 < mo701a.f815a; i2++) {
                            this.f650a.put(jdVar.mo704a(), jdVar.mo704a());
                        }
                        jdVar.h();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 9:
                    if (b2 == 11) {
                        this.f657f = jdVar.mo704a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 10:
                    if (b2 == 11) {
                        this.f658g = jdVar.mo704a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 12:
                    if (b2 == 11) {
                        this.f659h = jdVar.mo704a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 13:
                    if (b2 == 11) {
                        this.f660i = jdVar.mo704a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 14:
                    if (b2 == 11) {
                        this.f648a = jdVar.mo705a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 15:
                    if (b2 == 10) {
                        this.f645a = jdVar.mo698a();
                        b(true);
                        continue;
                        jdVar.g();
                    }
                    break;
                case 20:
                    if (b2 == 2) {
                        this.f653b = jdVar.mo709a();
                        c(true);
                        continue;
                        jdVar.g();
                    }
                    break;
            }
            jg.a(jdVar, b2);
            jdVar.g();
        }
    }

    public void a(String str, String str2) {
        if (this.f650a == null) {
            this.f650a = new HashMap();
        }
        this.f650a.put(str, str2);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m645a(boolean z) {
        this.f649a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m646a() {
        return this.f647a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m647a(ig igVar) {
        if (igVar == null) {
            return false;
        }
        boolean m646a = m646a();
        boolean m646a2 = igVar.m646a();
        if ((m646a || m646a2) && !(m646a && m646a2 && this.f647a.equals(igVar.f647a))) {
            return false;
        }
        boolean m649b = m649b();
        boolean m649b2 = igVar.m649b();
        if ((m649b || m649b2) && !(m649b && m649b2 && this.f646a.m599a(igVar.f646a))) {
            return false;
        }
        boolean m650c = m650c();
        boolean m650c2 = igVar.m650c();
        if ((m650c || m650c2) && !(m650c && m650c2 && this.f652b.equals(igVar.f652b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = igVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f654c.equals(igVar.f654c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = igVar.e();
        if (((e2 || e3) && !(e2 && e3 && this.f655d.equals(igVar.f655d))) || this.f651a != igVar.f651a) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = igVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f656e.equals(igVar.f656e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = igVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f650a.equals(igVar.f650a))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = igVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f657f.equals(igVar.f657f))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = igVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f658g.equals(igVar.f658g))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = igVar.k();
        if ((k2 || k3) && !(k2 && k3 && this.f659h.equals(igVar.f659h))) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = igVar.l();
        if ((l2 || l3) && !(l2 && l3 && this.f660i.equals(igVar.f660i))) {
            return false;
        }
        boolean m2 = m();
        boolean m3 = igVar.m();
        if ((m2 || m3) && !(m2 && m3 && this.f648a.equals(igVar.f648a))) {
            return false;
        }
        boolean n2 = n();
        boolean n3 = igVar.n();
        if ((n2 || n3) && !(n2 && n3 && this.f645a == igVar.f645a)) {
            return false;
        }
        boolean o2 = o();
        boolean o3 = igVar.o();
        if (o2 || o3) {
            return o2 && o3 && this.f653b == igVar.f653b;
        }
        return true;
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m648a() {
        a(it.a(this.f648a));
        return this.f648a.array();
    }

    public ig b(String str) {
        this.f654c = str;
        return this;
    }

    public String b() {
        return this.f654c;
    }

    @Override // com.xiaomi.push.is
    public void b(jd jdVar) {
        m644a();
        jdVar.a(f644a);
        if (this.f647a != null && m646a()) {
            jdVar.a(a);
            jdVar.a(this.f647a);
            jdVar.b();
        }
        if (this.f646a != null && m649b()) {
            jdVar.a(b);
            this.f646a.b(jdVar);
            jdVar.b();
        }
        if (this.f652b != null) {
            jdVar.a(c);
            jdVar.a(this.f652b);
            jdVar.b();
        }
        if (this.f654c != null && d()) {
            jdVar.a(d);
            jdVar.a(this.f654c);
            jdVar.b();
        }
        if (this.f655d != null && e()) {
            jdVar.a(e);
            jdVar.a(this.f655d);
            jdVar.b();
        }
        jdVar.a(f);
        jdVar.a(this.f651a);
        jdVar.b();
        if (this.f656e != null && g()) {
            jdVar.a(g);
            jdVar.a(this.f656e);
            jdVar.b();
        }
        if (this.f650a != null && h()) {
            jdVar.a(h);
            jdVar.a(new jc(Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, this.f650a.size()));
            for (Map.Entry<String, String> entry : this.f650a.entrySet()) {
                jdVar.a(entry.getKey());
                jdVar.a(entry.getValue());
            }
            jdVar.d();
            jdVar.b();
        }
        if (this.f657f != null && i()) {
            jdVar.a(i);
            jdVar.a(this.f657f);
            jdVar.b();
        }
        if (this.f658g != null && j()) {
            jdVar.a(j);
            jdVar.a(this.f658g);
            jdVar.b();
        }
        if (this.f659h != null && k()) {
            jdVar.a(k);
            jdVar.a(this.f659h);
            jdVar.b();
        }
        if (this.f660i != null && l()) {
            jdVar.a(l);
            jdVar.a(this.f660i);
            jdVar.b();
        }
        if (this.f648a != null && m()) {
            jdVar.a(m);
            jdVar.a(this.f648a);
            jdVar.b();
        }
        if (n()) {
            jdVar.a(n);
            jdVar.a(this.f645a);
            jdVar.b();
        }
        if (o()) {
            jdVar.a(o);
            jdVar.a(this.f653b);
            jdVar.b();
        }
        jdVar.c();
        jdVar.mo707a();
    }

    public void b(boolean z) {
        this.f649a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m649b() {
        return this.f646a != null;
    }

    public ig c(String str) {
        this.f655d = str;
        return this;
    }

    public String c() {
        return this.f657f;
    }

    public void c(boolean z) {
        this.f649a.set(2, z);
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m650c() {
        return this.f652b != null;
    }

    public ig d(String str) {
        this.f657f = str;
        return this;
    }

    public boolean d() {
        return this.f654c != null;
    }

    public boolean e() {
        return this.f655d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ig)) {
            return m647a((ig) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f649a.get(0);
    }

    public boolean g() {
        return this.f656e != null;
    }

    public boolean h() {
        return this.f650a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f657f != null;
    }

    public boolean j() {
        return this.f658g != null;
    }

    public boolean k() {
        return this.f659h != null;
    }

    public boolean l() {
        return this.f660i != null;
    }

    public boolean m() {
        return this.f648a != null;
    }

    public boolean n() {
        return this.f649a.get(1);
    }

    public boolean o() {
        return this.f649a.get(2);
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionNotification(");
        boolean z2 = false;
        if (m646a()) {
            sb.append("debug:");
            String str = this.f647a;
            if (str == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (m649b()) {
            if (!z) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            }
            sb.append("target:");
            hw hwVar = this.f646a;
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
        String str2 = this.f652b;
        if (str2 == null) {
            sb.append(StringUtil.NULL_STRING);
        } else {
            sb.append(str2);
        }
        if (d()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("appId:");
            String str3 = this.f654c;
            if (str3 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str3);
            }
        }
        if (e()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("type:");
            String str4 = this.f655d;
            if (str4 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str4);
            }
        }
        sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        sb.append("requireAck:");
        sb.append(this.f651a);
        if (g()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("payload:");
            String str5 = this.f656e;
            if (str5 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str5);
            }
        }
        if (h()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("extra:");
            Map<String, String> map = this.f650a;
            if (map == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(map);
            }
        }
        if (i()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("packageName:");
            String str6 = this.f657f;
            if (str6 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str6);
            }
        }
        if (j()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("category:");
            String str7 = this.f658g;
            if (str7 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str7);
            }
        }
        if (k()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("regId:");
            String str8 = this.f659h;
            if (str8 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str8);
            }
        }
        if (l()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("aliasName:");
            String str9 = this.f660i;
            if (str9 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str9);
            }
        }
        if (m()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("binaryExtra:");
            ByteBuffer byteBuffer = this.f648a;
            if (byteBuffer == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                it.a(byteBuffer, sb);
            }
        }
        if (n()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("createdTs:");
            sb.append(this.f645a);
        }
        if (o()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("alreadyLogClickInXmq:");
            sb.append(this.f653b);
        }
        sb.append(SmallTailInfo.EMOTION_SUFFIX);
        return sb.toString();
    }
}
