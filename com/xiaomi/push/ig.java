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
    public long f641a;

    /* renamed from: a  reason: collision with other field name */
    public hw f642a;

    /* renamed from: a  reason: collision with other field name */
    public String f643a;

    /* renamed from: a  reason: collision with other field name */
    public ByteBuffer f644a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f645a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f646a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f647a;

    /* renamed from: b  reason: collision with other field name */
    public String f648b;

    /* renamed from: b  reason: collision with other field name */
    public boolean f649b;

    /* renamed from: c  reason: collision with other field name */
    public String f650c;

    /* renamed from: d  reason: collision with other field name */
    public String f651d;

    /* renamed from: e  reason: collision with other field name */
    public String f652e;

    /* renamed from: f  reason: collision with other field name */
    public String f653f;

    /* renamed from: g  reason: collision with other field name */
    public String f654g;

    /* renamed from: h  reason: collision with other field name */
    public String f655h;

    /* renamed from: i  reason: collision with other field name */
    public String f656i;

    /* renamed from: a  reason: collision with other field name */
    public static final ji f640a = new ji("XmPushActionNotification");
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
        this.f645a = new BitSet(3);
        this.f647a = true;
        this.f649b = false;
    }

    public ig(String str, boolean z) {
        this();
        this.f648b = str;
        this.f647a = z;
        m652a(true);
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
            int compareTo = Boolean.valueOf(m653a()).compareTo(Boolean.valueOf(igVar.m653a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m653a() || (a16 = it.a(this.f643a, igVar.f643a)) == 0) {
                int compareTo2 = Boolean.valueOf(m656b()).compareTo(Boolean.valueOf(igVar.m656b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!m656b() || (a15 = it.a(this.f642a, igVar.f642a)) == 0) {
                    int compareTo3 = Boolean.valueOf(m657c()).compareTo(Boolean.valueOf(igVar.m657c()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!m657c() || (a14 = it.a(this.f648b, igVar.f648b)) == 0) {
                        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(igVar.d()));
                        if (compareTo4 != 0) {
                            return compareTo4;
                        }
                        if (!d() || (a13 = it.a(this.f650c, igVar.f650c)) == 0) {
                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(igVar.e()));
                            if (compareTo5 != 0) {
                                return compareTo5;
                            }
                            if (!e() || (a12 = it.a(this.f651d, igVar.f651d)) == 0) {
                                int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(igVar.f()));
                                if (compareTo6 != 0) {
                                    return compareTo6;
                                }
                                if (!f() || (a11 = it.a(this.f647a, igVar.f647a)) == 0) {
                                    int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(igVar.g()));
                                    if (compareTo7 != 0) {
                                        return compareTo7;
                                    }
                                    if (!g() || (a10 = it.a(this.f652e, igVar.f652e)) == 0) {
                                        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(igVar.h()));
                                        if (compareTo8 != 0) {
                                            return compareTo8;
                                        }
                                        if (!h() || (a9 = it.a(this.f646a, igVar.f646a)) == 0) {
                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(igVar.i()));
                                            if (compareTo9 != 0) {
                                                return compareTo9;
                                            }
                                            if (!i() || (a8 = it.a(this.f653f, igVar.f653f)) == 0) {
                                                int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(igVar.j()));
                                                if (compareTo10 != 0) {
                                                    return compareTo10;
                                                }
                                                if (!j() || (a7 = it.a(this.f654g, igVar.f654g)) == 0) {
                                                    int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(igVar.k()));
                                                    if (compareTo11 != 0) {
                                                        return compareTo11;
                                                    }
                                                    if (!k() || (a6 = it.a(this.f655h, igVar.f655h)) == 0) {
                                                        int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(igVar.l()));
                                                        if (compareTo12 != 0) {
                                                            return compareTo12;
                                                        }
                                                        if (!l() || (a5 = it.a(this.f656i, igVar.f656i)) == 0) {
                                                            int compareTo13 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(igVar.m()));
                                                            if (compareTo13 != 0) {
                                                                return compareTo13;
                                                            }
                                                            if (!m() || (a4 = it.a(this.f644a, igVar.f644a)) == 0) {
                                                                int compareTo14 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(igVar.n()));
                                                                if (compareTo14 != 0) {
                                                                    return compareTo14;
                                                                }
                                                                if (!n() || (a3 = it.a(this.f641a, igVar.f641a)) == 0) {
                                                                    int compareTo15 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(igVar.o()));
                                                                    if (compareTo15 != 0) {
                                                                        return compareTo15;
                                                                    }
                                                                    if (!o() || (a2 = it.a(this.f649b, igVar.f649b)) == 0) {
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
        return this.f642a;
    }

    public ig a(String str) {
        this.f648b = str;
        return this;
    }

    public ig a(ByteBuffer byteBuffer) {
        this.f644a = byteBuffer;
        return this;
    }

    public ig a(Map<String, String> map) {
        this.f646a = map;
        return this;
    }

    public ig a(boolean z) {
        this.f647a = z;
        m652a(true);
        return this;
    }

    public ig a(byte[] bArr) {
        a(ByteBuffer.wrap(bArr));
        return this;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m649a() {
        return this.f648b;
    }

    /* renamed from: a  reason: collision with other method in class */
    public Map<String, String> m650a() {
        return this.f646a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m651a() {
        if (this.f648b != null) {
            return;
        }
        throw new je("Required field 'id' was not present! Struct: " + toString());
    }

    @Override // com.xiaomi.push.is
    public void a(jd jdVar) {
        jdVar.mo710a();
        while (true) {
            ja mo706a = jdVar.mo706a();
            byte b2 = mo706a.a;
            if (b2 == 0) {
                jdVar.f();
                if (f()) {
                    m651a();
                    return;
                }
                throw new je("Required field 'requireAck' was not found in serialized data! Struct: " + toString());
            }
            switch (mo706a.f809a) {
                case 1:
                    if (b2 == 11) {
                        this.f643a = jdVar.mo711a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 2:
                    if (b2 == 12) {
                        hw hwVar = new hw();
                        this.f642a = hwVar;
                        hwVar.a(jdVar);
                        continue;
                        jdVar.g();
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f648b = jdVar.mo711a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f650c = jdVar.mo711a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 5:
                    if (b2 == 11) {
                        this.f651d = jdVar.mo711a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 6:
                    if (b2 == 2) {
                        this.f647a = jdVar.mo716a();
                        m652a(true);
                        continue;
                        jdVar.g();
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f652e = jdVar.mo711a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 8:
                    if (b2 == 13) {
                        jc mo708a = jdVar.mo708a();
                        this.f646a = new HashMap(mo708a.f811a * 2);
                        for (int i2 = 0; i2 < mo708a.f811a; i2++) {
                            this.f646a.put(jdVar.mo711a(), jdVar.mo711a());
                        }
                        jdVar.h();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 9:
                    if (b2 == 11) {
                        this.f653f = jdVar.mo711a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 10:
                    if (b2 == 11) {
                        this.f654g = jdVar.mo711a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 12:
                    if (b2 == 11) {
                        this.f655h = jdVar.mo711a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 13:
                    if (b2 == 11) {
                        this.f656i = jdVar.mo711a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 14:
                    if (b2 == 11) {
                        this.f644a = jdVar.mo712a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 15:
                    if (b2 == 10) {
                        this.f641a = jdVar.mo705a();
                        b(true);
                        continue;
                        jdVar.g();
                    }
                    break;
                case 20:
                    if (b2 == 2) {
                        this.f649b = jdVar.mo716a();
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
        if (this.f646a == null) {
            this.f646a = new HashMap();
        }
        this.f646a.put(str, str2);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m652a(boolean z) {
        this.f645a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m653a() {
        return this.f643a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m654a(ig igVar) {
        if (igVar == null) {
            return false;
        }
        boolean m653a = m653a();
        boolean m653a2 = igVar.m653a();
        if ((m653a || m653a2) && !(m653a && m653a2 && this.f643a.equals(igVar.f643a))) {
            return false;
        }
        boolean m656b = m656b();
        boolean m656b2 = igVar.m656b();
        if ((m656b || m656b2) && !(m656b && m656b2 && this.f642a.m606a(igVar.f642a))) {
            return false;
        }
        boolean m657c = m657c();
        boolean m657c2 = igVar.m657c();
        if ((m657c || m657c2) && !(m657c && m657c2 && this.f648b.equals(igVar.f648b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = igVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f650c.equals(igVar.f650c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = igVar.e();
        if (((e2 || e3) && !(e2 && e3 && this.f651d.equals(igVar.f651d))) || this.f647a != igVar.f647a) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = igVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f652e.equals(igVar.f652e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = igVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f646a.equals(igVar.f646a))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = igVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f653f.equals(igVar.f653f))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = igVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f654g.equals(igVar.f654g))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = igVar.k();
        if ((k2 || k3) && !(k2 && k3 && this.f655h.equals(igVar.f655h))) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = igVar.l();
        if ((l2 || l3) && !(l2 && l3 && this.f656i.equals(igVar.f656i))) {
            return false;
        }
        boolean m2 = m();
        boolean m3 = igVar.m();
        if ((m2 || m3) && !(m2 && m3 && this.f644a.equals(igVar.f644a))) {
            return false;
        }
        boolean n2 = n();
        boolean n3 = igVar.n();
        if ((n2 || n3) && !(n2 && n3 && this.f641a == igVar.f641a)) {
            return false;
        }
        boolean o2 = o();
        boolean o3 = igVar.o();
        if (o2 || o3) {
            return o2 && o3 && this.f649b == igVar.f649b;
        }
        return true;
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m655a() {
        a(it.a(this.f644a));
        return this.f644a.array();
    }

    public ig b(String str) {
        this.f650c = str;
        return this;
    }

    public String b() {
        return this.f650c;
    }

    @Override // com.xiaomi.push.is
    public void b(jd jdVar) {
        m651a();
        jdVar.a(f640a);
        if (this.f643a != null && m653a()) {
            jdVar.a(a);
            jdVar.a(this.f643a);
            jdVar.b();
        }
        if (this.f642a != null && m656b()) {
            jdVar.a(b);
            this.f642a.b(jdVar);
            jdVar.b();
        }
        if (this.f648b != null) {
            jdVar.a(c);
            jdVar.a(this.f648b);
            jdVar.b();
        }
        if (this.f650c != null && d()) {
            jdVar.a(d);
            jdVar.a(this.f650c);
            jdVar.b();
        }
        if (this.f651d != null && e()) {
            jdVar.a(e);
            jdVar.a(this.f651d);
            jdVar.b();
        }
        jdVar.a(f);
        jdVar.a(this.f647a);
        jdVar.b();
        if (this.f652e != null && g()) {
            jdVar.a(g);
            jdVar.a(this.f652e);
            jdVar.b();
        }
        if (this.f646a != null && h()) {
            jdVar.a(h);
            jdVar.a(new jc(Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, this.f646a.size()));
            for (Map.Entry<String, String> entry : this.f646a.entrySet()) {
                jdVar.a(entry.getKey());
                jdVar.a(entry.getValue());
            }
            jdVar.d();
            jdVar.b();
        }
        if (this.f653f != null && i()) {
            jdVar.a(i);
            jdVar.a(this.f653f);
            jdVar.b();
        }
        if (this.f654g != null && j()) {
            jdVar.a(j);
            jdVar.a(this.f654g);
            jdVar.b();
        }
        if (this.f655h != null && k()) {
            jdVar.a(k);
            jdVar.a(this.f655h);
            jdVar.b();
        }
        if (this.f656i != null && l()) {
            jdVar.a(l);
            jdVar.a(this.f656i);
            jdVar.b();
        }
        if (this.f644a != null && m()) {
            jdVar.a(m);
            jdVar.a(this.f644a);
            jdVar.b();
        }
        if (n()) {
            jdVar.a(n);
            jdVar.a(this.f641a);
            jdVar.b();
        }
        if (o()) {
            jdVar.a(o);
            jdVar.a(this.f649b);
            jdVar.b();
        }
        jdVar.c();
        jdVar.mo714a();
    }

    public void b(boolean z) {
        this.f645a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m656b() {
        return this.f642a != null;
    }

    public ig c(String str) {
        this.f651d = str;
        return this;
    }

    public String c() {
        return this.f653f;
    }

    public void c(boolean z) {
        this.f645a.set(2, z);
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m657c() {
        return this.f648b != null;
    }

    public ig d(String str) {
        this.f653f = str;
        return this;
    }

    public boolean d() {
        return this.f650c != null;
    }

    public boolean e() {
        return this.f651d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ig)) {
            return m654a((ig) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f645a.get(0);
    }

    public boolean g() {
        return this.f652e != null;
    }

    public boolean h() {
        return this.f646a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f653f != null;
    }

    public boolean j() {
        return this.f654g != null;
    }

    public boolean k() {
        return this.f655h != null;
    }

    public boolean l() {
        return this.f656i != null;
    }

    public boolean m() {
        return this.f644a != null;
    }

    public boolean n() {
        return this.f645a.get(1);
    }

    public boolean o() {
        return this.f645a.get(2);
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionNotification(");
        boolean z2 = false;
        if (m653a()) {
            sb.append("debug:");
            String str = this.f643a;
            if (str == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (m656b()) {
            if (!z) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            }
            sb.append("target:");
            hw hwVar = this.f642a;
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
        String str2 = this.f648b;
        if (str2 == null) {
            sb.append(StringUtil.NULL_STRING);
        } else {
            sb.append(str2);
        }
        if (d()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("appId:");
            String str3 = this.f650c;
            if (str3 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str3);
            }
        }
        if (e()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("type:");
            String str4 = this.f651d;
            if (str4 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str4);
            }
        }
        sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        sb.append("requireAck:");
        sb.append(this.f647a);
        if (g()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("payload:");
            String str5 = this.f652e;
            if (str5 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str5);
            }
        }
        if (h()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("extra:");
            Map<String, String> map = this.f646a;
            if (map == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(map);
            }
        }
        if (i()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("packageName:");
            String str6 = this.f653f;
            if (str6 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str6);
            }
        }
        if (j()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("category:");
            String str7 = this.f654g;
            if (str7 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str7);
            }
        }
        if (k()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("regId:");
            String str8 = this.f655h;
            if (str8 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str8);
            }
        }
        if (l()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("aliasName:");
            String str9 = this.f656i;
            if (str9 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str9);
            }
        }
        if (m()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("binaryExtra:");
            ByteBuffer byteBuffer = this.f644a;
            if (byteBuffer == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                it.a(byteBuffer, sb);
            }
        }
        if (n()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("createdTs:");
            sb.append(this.f641a);
        }
        if (o()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("alreadyLogClickInXmq:");
            sb.append(this.f649b);
        }
        sb.append(SmallTailInfo.EMOTION_SUFFIX);
        return sb.toString();
    }
}
