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
    public long f646a;

    /* renamed from: a  reason: collision with other field name */
    public hw f647a;

    /* renamed from: a  reason: collision with other field name */
    public String f648a;

    /* renamed from: a  reason: collision with other field name */
    public ByteBuffer f649a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f650a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f651a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f652a;

    /* renamed from: b  reason: collision with other field name */
    public String f653b;

    /* renamed from: b  reason: collision with other field name */
    public boolean f654b;

    /* renamed from: c  reason: collision with other field name */
    public String f655c;

    /* renamed from: d  reason: collision with other field name */
    public String f656d;

    /* renamed from: e  reason: collision with other field name */
    public String f657e;

    /* renamed from: f  reason: collision with other field name */
    public String f658f;

    /* renamed from: g  reason: collision with other field name */
    public String f659g;

    /* renamed from: h  reason: collision with other field name */
    public String f660h;

    /* renamed from: i  reason: collision with other field name */
    public String f661i;

    /* renamed from: a  reason: collision with other field name */
    public static final ji f645a = new ji("XmPushActionNotification");
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
        this.f650a = new BitSet(3);
        this.f652a = true;
        this.f654b = false;
    }

    public ig(String str, boolean z) {
        this();
        this.f653b = str;
        this.f652a = z;
        m642a(true);
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
            int compareTo = Boolean.valueOf(m643a()).compareTo(Boolean.valueOf(igVar.m643a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m643a() || (a16 = it.a(this.f648a, igVar.f648a)) == 0) {
                int compareTo2 = Boolean.valueOf(m646b()).compareTo(Boolean.valueOf(igVar.m646b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!m646b() || (a15 = it.a(this.f647a, igVar.f647a)) == 0) {
                    int compareTo3 = Boolean.valueOf(m647c()).compareTo(Boolean.valueOf(igVar.m647c()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!m647c() || (a14 = it.a(this.f653b, igVar.f653b)) == 0) {
                        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(igVar.d()));
                        if (compareTo4 != 0) {
                            return compareTo4;
                        }
                        if (!d() || (a13 = it.a(this.f655c, igVar.f655c)) == 0) {
                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(igVar.e()));
                            if (compareTo5 != 0) {
                                return compareTo5;
                            }
                            if (!e() || (a12 = it.a(this.f656d, igVar.f656d)) == 0) {
                                int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(igVar.f()));
                                if (compareTo6 != 0) {
                                    return compareTo6;
                                }
                                if (!f() || (a11 = it.a(this.f652a, igVar.f652a)) == 0) {
                                    int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(igVar.g()));
                                    if (compareTo7 != 0) {
                                        return compareTo7;
                                    }
                                    if (!g() || (a10 = it.a(this.f657e, igVar.f657e)) == 0) {
                                        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(igVar.h()));
                                        if (compareTo8 != 0) {
                                            return compareTo8;
                                        }
                                        if (!h() || (a9 = it.a(this.f651a, igVar.f651a)) == 0) {
                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(igVar.i()));
                                            if (compareTo9 != 0) {
                                                return compareTo9;
                                            }
                                            if (!i() || (a8 = it.a(this.f658f, igVar.f658f)) == 0) {
                                                int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(igVar.j()));
                                                if (compareTo10 != 0) {
                                                    return compareTo10;
                                                }
                                                if (!j() || (a7 = it.a(this.f659g, igVar.f659g)) == 0) {
                                                    int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(igVar.k()));
                                                    if (compareTo11 != 0) {
                                                        return compareTo11;
                                                    }
                                                    if (!k() || (a6 = it.a(this.f660h, igVar.f660h)) == 0) {
                                                        int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(igVar.l()));
                                                        if (compareTo12 != 0) {
                                                            return compareTo12;
                                                        }
                                                        if (!l() || (a5 = it.a(this.f661i, igVar.f661i)) == 0) {
                                                            int compareTo13 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(igVar.m()));
                                                            if (compareTo13 != 0) {
                                                                return compareTo13;
                                                            }
                                                            if (!m() || (a4 = it.a(this.f649a, igVar.f649a)) == 0) {
                                                                int compareTo14 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(igVar.n()));
                                                                if (compareTo14 != 0) {
                                                                    return compareTo14;
                                                                }
                                                                if (!n() || (a3 = it.a(this.f646a, igVar.f646a)) == 0) {
                                                                    int compareTo15 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(igVar.o()));
                                                                    if (compareTo15 != 0) {
                                                                        return compareTo15;
                                                                    }
                                                                    if (!o() || (a2 = it.a(this.f654b, igVar.f654b)) == 0) {
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
        return this.f647a;
    }

    public ig a(String str) {
        this.f653b = str;
        return this;
    }

    public ig a(ByteBuffer byteBuffer) {
        this.f649a = byteBuffer;
        return this;
    }

    public ig a(Map<String, String> map) {
        this.f651a = map;
        return this;
    }

    public ig a(boolean z) {
        this.f652a = z;
        m642a(true);
        return this;
    }

    public ig a(byte[] bArr) {
        a(ByteBuffer.wrap(bArr));
        return this;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m639a() {
        return this.f653b;
    }

    /* renamed from: a  reason: collision with other method in class */
    public Map<String, String> m640a() {
        return this.f651a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m641a() {
        if (this.f653b != null) {
            return;
        }
        throw new je("Required field 'id' was not present! Struct: " + toString());
    }

    @Override // com.xiaomi.push.is
    public void a(jd jdVar) {
        jdVar.mo700a();
        while (true) {
            ja mo696a = jdVar.mo696a();
            byte b2 = mo696a.a;
            if (b2 == 0) {
                jdVar.f();
                if (f()) {
                    m641a();
                    return;
                }
                throw new je("Required field 'requireAck' was not found in serialized data! Struct: " + toString());
            }
            switch (mo696a.f814a) {
                case 1:
                    if (b2 == 11) {
                        this.f648a = jdVar.mo701a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 2:
                    if (b2 == 12) {
                        hw hwVar = new hw();
                        this.f647a = hwVar;
                        hwVar.a(jdVar);
                        continue;
                        jdVar.g();
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f653b = jdVar.mo701a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f655c = jdVar.mo701a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 5:
                    if (b2 == 11) {
                        this.f656d = jdVar.mo701a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 6:
                    if (b2 == 2) {
                        this.f652a = jdVar.mo706a();
                        m642a(true);
                        continue;
                        jdVar.g();
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f657e = jdVar.mo701a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 8:
                    if (b2 == 13) {
                        jc mo698a = jdVar.mo698a();
                        this.f651a = new HashMap(mo698a.f816a * 2);
                        for (int i2 = 0; i2 < mo698a.f816a; i2++) {
                            this.f651a.put(jdVar.mo701a(), jdVar.mo701a());
                        }
                        jdVar.h();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 9:
                    if (b2 == 11) {
                        this.f658f = jdVar.mo701a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 10:
                    if (b2 == 11) {
                        this.f659g = jdVar.mo701a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 12:
                    if (b2 == 11) {
                        this.f660h = jdVar.mo701a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 13:
                    if (b2 == 11) {
                        this.f661i = jdVar.mo701a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 14:
                    if (b2 == 11) {
                        this.f649a = jdVar.mo702a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 15:
                    if (b2 == 10) {
                        this.f646a = jdVar.mo695a();
                        b(true);
                        continue;
                        jdVar.g();
                    }
                    break;
                case 20:
                    if (b2 == 2) {
                        this.f654b = jdVar.mo706a();
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
        if (this.f651a == null) {
            this.f651a = new HashMap();
        }
        this.f651a.put(str, str2);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m642a(boolean z) {
        this.f650a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m643a() {
        return this.f648a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m644a(ig igVar) {
        if (igVar == null) {
            return false;
        }
        boolean m643a = m643a();
        boolean m643a2 = igVar.m643a();
        if ((m643a || m643a2) && !(m643a && m643a2 && this.f648a.equals(igVar.f648a))) {
            return false;
        }
        boolean m646b = m646b();
        boolean m646b2 = igVar.m646b();
        if ((m646b || m646b2) && !(m646b && m646b2 && this.f647a.m596a(igVar.f647a))) {
            return false;
        }
        boolean m647c = m647c();
        boolean m647c2 = igVar.m647c();
        if ((m647c || m647c2) && !(m647c && m647c2 && this.f653b.equals(igVar.f653b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = igVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f655c.equals(igVar.f655c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = igVar.e();
        if (((e2 || e3) && !(e2 && e3 && this.f656d.equals(igVar.f656d))) || this.f652a != igVar.f652a) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = igVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f657e.equals(igVar.f657e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = igVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f651a.equals(igVar.f651a))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = igVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f658f.equals(igVar.f658f))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = igVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f659g.equals(igVar.f659g))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = igVar.k();
        if ((k2 || k3) && !(k2 && k3 && this.f660h.equals(igVar.f660h))) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = igVar.l();
        if ((l2 || l3) && !(l2 && l3 && this.f661i.equals(igVar.f661i))) {
            return false;
        }
        boolean m2 = m();
        boolean m3 = igVar.m();
        if ((m2 || m3) && !(m2 && m3 && this.f649a.equals(igVar.f649a))) {
            return false;
        }
        boolean n2 = n();
        boolean n3 = igVar.n();
        if ((n2 || n3) && !(n2 && n3 && this.f646a == igVar.f646a)) {
            return false;
        }
        boolean o2 = o();
        boolean o3 = igVar.o();
        if (o2 || o3) {
            return o2 && o3 && this.f654b == igVar.f654b;
        }
        return true;
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m645a() {
        a(it.a(this.f649a));
        return this.f649a.array();
    }

    public ig b(String str) {
        this.f655c = str;
        return this;
    }

    public String b() {
        return this.f655c;
    }

    @Override // com.xiaomi.push.is
    public void b(jd jdVar) {
        m641a();
        jdVar.a(f645a);
        if (this.f648a != null && m643a()) {
            jdVar.a(a);
            jdVar.a(this.f648a);
            jdVar.b();
        }
        if (this.f647a != null && m646b()) {
            jdVar.a(b);
            this.f647a.b(jdVar);
            jdVar.b();
        }
        if (this.f653b != null) {
            jdVar.a(c);
            jdVar.a(this.f653b);
            jdVar.b();
        }
        if (this.f655c != null && d()) {
            jdVar.a(d);
            jdVar.a(this.f655c);
            jdVar.b();
        }
        if (this.f656d != null && e()) {
            jdVar.a(e);
            jdVar.a(this.f656d);
            jdVar.b();
        }
        jdVar.a(f);
        jdVar.a(this.f652a);
        jdVar.b();
        if (this.f657e != null && g()) {
            jdVar.a(g);
            jdVar.a(this.f657e);
            jdVar.b();
        }
        if (this.f651a != null && h()) {
            jdVar.a(h);
            jdVar.a(new jc(Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, this.f651a.size()));
            for (Map.Entry<String, String> entry : this.f651a.entrySet()) {
                jdVar.a(entry.getKey());
                jdVar.a(entry.getValue());
            }
            jdVar.d();
            jdVar.b();
        }
        if (this.f658f != null && i()) {
            jdVar.a(i);
            jdVar.a(this.f658f);
            jdVar.b();
        }
        if (this.f659g != null && j()) {
            jdVar.a(j);
            jdVar.a(this.f659g);
            jdVar.b();
        }
        if (this.f660h != null && k()) {
            jdVar.a(k);
            jdVar.a(this.f660h);
            jdVar.b();
        }
        if (this.f661i != null && l()) {
            jdVar.a(l);
            jdVar.a(this.f661i);
            jdVar.b();
        }
        if (this.f649a != null && m()) {
            jdVar.a(m);
            jdVar.a(this.f649a);
            jdVar.b();
        }
        if (n()) {
            jdVar.a(n);
            jdVar.a(this.f646a);
            jdVar.b();
        }
        if (o()) {
            jdVar.a(o);
            jdVar.a(this.f654b);
            jdVar.b();
        }
        jdVar.c();
        jdVar.mo704a();
    }

    public void b(boolean z) {
        this.f650a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m646b() {
        return this.f647a != null;
    }

    public ig c(String str) {
        this.f656d = str;
        return this;
    }

    public String c() {
        return this.f658f;
    }

    public void c(boolean z) {
        this.f650a.set(2, z);
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m647c() {
        return this.f653b != null;
    }

    public ig d(String str) {
        this.f658f = str;
        return this;
    }

    public boolean d() {
        return this.f655c != null;
    }

    public boolean e() {
        return this.f656d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ig)) {
            return m644a((ig) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f650a.get(0);
    }

    public boolean g() {
        return this.f657e != null;
    }

    public boolean h() {
        return this.f651a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f658f != null;
    }

    public boolean j() {
        return this.f659g != null;
    }

    public boolean k() {
        return this.f660h != null;
    }

    public boolean l() {
        return this.f661i != null;
    }

    public boolean m() {
        return this.f649a != null;
    }

    public boolean n() {
        return this.f650a.get(1);
    }

    public boolean o() {
        return this.f650a.get(2);
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionNotification(");
        boolean z2 = false;
        if (m643a()) {
            sb.append("debug:");
            String str = this.f648a;
            if (str == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (m646b()) {
            if (!z) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            }
            sb.append("target:");
            hw hwVar = this.f647a;
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
        String str2 = this.f653b;
        if (str2 == null) {
            sb.append(StringUtil.NULL_STRING);
        } else {
            sb.append(str2);
        }
        if (d()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("appId:");
            String str3 = this.f655c;
            if (str3 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str3);
            }
        }
        if (e()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("type:");
            String str4 = this.f656d;
            if (str4 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str4);
            }
        }
        sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        sb.append("requireAck:");
        sb.append(this.f652a);
        if (g()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("payload:");
            String str5 = this.f657e;
            if (str5 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str5);
            }
        }
        if (h()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("extra:");
            Map<String, String> map = this.f651a;
            if (map == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(map);
            }
        }
        if (i()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("packageName:");
            String str6 = this.f658f;
            if (str6 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str6);
            }
        }
        if (j()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("category:");
            String str7 = this.f659g;
            if (str7 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str7);
            }
        }
        if (k()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("regId:");
            String str8 = this.f660h;
            if (str8 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str8);
            }
        }
        if (l()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("aliasName:");
            String str9 = this.f661i;
            if (str9 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str9);
            }
        }
        if (m()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("binaryExtra:");
            ByteBuffer byteBuffer = this.f649a;
            if (byteBuffer == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                it.a(byteBuffer, sb);
            }
        }
        if (n()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("createdTs:");
            sb.append(this.f646a);
        }
        if (o()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("alreadyLogClickInXmq:");
            sb.append(this.f654b);
        }
        sb.append(SmallTailInfo.EMOTION_SUFFIX);
        return sb.toString();
    }
}
