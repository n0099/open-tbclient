package com.xiaomi.push;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.tbadk.core.data.SmallTailInfo;
import io.flutter.plugin.common.StandardMessageCodec;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes7.dex */
public class ie implements iq<ie, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f642a;

    /* renamed from: a  reason: collision with other field name */
    public hu f643a;

    /* renamed from: a  reason: collision with other field name */
    public String f644a;

    /* renamed from: a  reason: collision with other field name */
    public ByteBuffer f645a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f646a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f647a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f648a;

    /* renamed from: b  reason: collision with other field name */
    public String f649b;

    /* renamed from: b  reason: collision with other field name */
    public boolean f650b;

    /* renamed from: c  reason: collision with other field name */
    public String f651c;

    /* renamed from: d  reason: collision with other field name */
    public String f652d;

    /* renamed from: e  reason: collision with other field name */
    public String f653e;

    /* renamed from: f  reason: collision with other field name */
    public String f654f;

    /* renamed from: g  reason: collision with other field name */
    public String f655g;

    /* renamed from: h  reason: collision with other field name */
    public String f656h;

    /* renamed from: i  reason: collision with other field name */
    public String f657i;

    /* renamed from: a  reason: collision with other field name */
    public static final jg f641a = new jg("XmPushActionNotification");

    /* renamed from: a  reason: collision with root package name */
    public static final iy f41540a = new iy("", (byte) 11, 1);

    /* renamed from: b  reason: collision with root package name */
    public static final iy f41541b = new iy("", StandardMessageCodec.LIST, 2);

    /* renamed from: c  reason: collision with root package name */
    public static final iy f41542c = new iy("", (byte) 11, 3);

    /* renamed from: d  reason: collision with root package name */
    public static final iy f41543d = new iy("", (byte) 11, 4);

    /* renamed from: e  reason: collision with root package name */
    public static final iy f41544e = new iy("", (byte) 11, 5);

    /* renamed from: f  reason: collision with root package name */
    public static final iy f41545f = new iy("", (byte) 2, 6);

    /* renamed from: g  reason: collision with root package name */
    public static final iy f41546g = new iy("", (byte) 11, 7);

    /* renamed from: h  reason: collision with root package name */
    public static final iy f41547h = new iy("", (byte) 13, 8);

    /* renamed from: i  reason: collision with root package name */
    public static final iy f41548i = new iy("", (byte) 11, 9);
    public static final iy j = new iy("", (byte) 11, 10);
    public static final iy k = new iy("", (byte) 11, 12);
    public static final iy l = new iy("", (byte) 11, 13);
    public static final iy m = new iy("", (byte) 11, 14);
    public static final iy n = new iy("", (byte) 10, 15);
    public static final iy o = new iy("", (byte) 2, 20);

    public ie() {
        this.f646a = new BitSet(3);
        this.f648a = true;
        this.f650b = false;
    }

    public ie(String str, boolean z) {
        this();
        this.f649b = str;
        this.f648a = z;
        m454a(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(ie ieVar) {
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
        if (ie.class.equals(ieVar.getClass())) {
            int compareTo = Boolean.valueOf(m455a()).compareTo(Boolean.valueOf(ieVar.m455a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m455a() || (a16 = ir.a(this.f644a, ieVar.f644a)) == 0) {
                int compareTo2 = Boolean.valueOf(m458b()).compareTo(Boolean.valueOf(ieVar.m458b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!m458b() || (a15 = ir.a(this.f643a, ieVar.f643a)) == 0) {
                    int compareTo3 = Boolean.valueOf(m459c()).compareTo(Boolean.valueOf(ieVar.m459c()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!m459c() || (a14 = ir.a(this.f649b, ieVar.f649b)) == 0) {
                        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(ieVar.d()));
                        if (compareTo4 != 0) {
                            return compareTo4;
                        }
                        if (!d() || (a13 = ir.a(this.f651c, ieVar.f651c)) == 0) {
                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(ieVar.e()));
                            if (compareTo5 != 0) {
                                return compareTo5;
                            }
                            if (!e() || (a12 = ir.a(this.f652d, ieVar.f652d)) == 0) {
                                int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(ieVar.f()));
                                if (compareTo6 != 0) {
                                    return compareTo6;
                                }
                                if (!f() || (a11 = ir.a(this.f648a, ieVar.f648a)) == 0) {
                                    int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ieVar.g()));
                                    if (compareTo7 != 0) {
                                        return compareTo7;
                                    }
                                    if (!g() || (a10 = ir.a(this.f653e, ieVar.f653e)) == 0) {
                                        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(ieVar.h()));
                                        if (compareTo8 != 0) {
                                            return compareTo8;
                                        }
                                        if (!h() || (a9 = ir.a(this.f647a, ieVar.f647a)) == 0) {
                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(ieVar.i()));
                                            if (compareTo9 != 0) {
                                                return compareTo9;
                                            }
                                            if (!i() || (a8 = ir.a(this.f654f, ieVar.f654f)) == 0) {
                                                int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(ieVar.j()));
                                                if (compareTo10 != 0) {
                                                    return compareTo10;
                                                }
                                                if (!j() || (a7 = ir.a(this.f655g, ieVar.f655g)) == 0) {
                                                    int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(ieVar.k()));
                                                    if (compareTo11 != 0) {
                                                        return compareTo11;
                                                    }
                                                    if (!k() || (a6 = ir.a(this.f656h, ieVar.f656h)) == 0) {
                                                        int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(ieVar.l()));
                                                        if (compareTo12 != 0) {
                                                            return compareTo12;
                                                        }
                                                        if (!l() || (a5 = ir.a(this.f657i, ieVar.f657i)) == 0) {
                                                            int compareTo13 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(ieVar.m()));
                                                            if (compareTo13 != 0) {
                                                                return compareTo13;
                                                            }
                                                            if (!m() || (a4 = ir.a(this.f645a, ieVar.f645a)) == 0) {
                                                                int compareTo14 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(ieVar.n()));
                                                                if (compareTo14 != 0) {
                                                                    return compareTo14;
                                                                }
                                                                if (!n() || (a3 = ir.a(this.f642a, ieVar.f642a)) == 0) {
                                                                    int compareTo15 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(ieVar.o()));
                                                                    if (compareTo15 != 0) {
                                                                        return compareTo15;
                                                                    }
                                                                    if (!o() || (a2 = ir.a(this.f650b, ieVar.f650b)) == 0) {
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
        return ie.class.getName().compareTo(ieVar.getClass().getName());
    }

    public hu a() {
        return this.f643a;
    }

    public ie a(String str) {
        this.f649b = str;
        return this;
    }

    public ie a(ByteBuffer byteBuffer) {
        this.f645a = byteBuffer;
        return this;
    }

    public ie a(Map<String, String> map) {
        this.f647a = map;
        return this;
    }

    public ie a(boolean z) {
        this.f648a = z;
        m454a(true);
        return this;
    }

    public ie a(byte[] bArr) {
        a(ByteBuffer.wrap(bArr));
        return this;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m451a() {
        return this.f649b;
    }

    /* renamed from: a  reason: collision with other method in class */
    public Map<String, String> m452a() {
        return this.f647a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m453a() {
        if (this.f649b != null) {
            return;
        }
        throw new jc("Required field 'id' was not present! Struct: " + toString());
    }

    @Override // com.xiaomi.push.iq
    public void a(jb jbVar) {
        jbVar.m510a();
        while (true) {
            iy m506a = jbVar.m506a();
            byte b2 = m506a.f41648a;
            if (b2 == 0) {
                jbVar.f();
                if (f()) {
                    m453a();
                    return;
                }
                throw new jc("Required field 'requireAck' was not found in serialized data! Struct: " + toString());
            }
            switch (m506a.f807a) {
                case 1:
                    if (b2 == 11) {
                        this.f644a = jbVar.m511a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 2:
                    if (b2 == 12) {
                        hu huVar = new hu();
                        this.f643a = huVar;
                        huVar.a(jbVar);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f649b = jbVar.m511a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f651c = jbVar.m511a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 5:
                    if (b2 == 11) {
                        this.f652d = jbVar.m511a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 6:
                    if (b2 == 2) {
                        this.f648a = jbVar.m515a();
                        m454a(true);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f653e = jbVar.m511a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 8:
                    if (b2 == 13) {
                        ja m508a = jbVar.m508a();
                        this.f647a = new HashMap(m508a.f811a * 2);
                        for (int i2 = 0; i2 < m508a.f811a; i2++) {
                            this.f647a.put(jbVar.m511a(), jbVar.m511a());
                        }
                        jbVar.h();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 9:
                    if (b2 == 11) {
                        this.f654f = jbVar.m511a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 10:
                    if (b2 == 11) {
                        this.f655g = jbVar.m511a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 12:
                    if (b2 == 11) {
                        this.f656h = jbVar.m511a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 13:
                    if (b2 == 11) {
                        this.f657i = jbVar.m511a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 14:
                    if (b2 == 11) {
                        this.f645a = jbVar.m512a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 15:
                    if (b2 == 10) {
                        this.f642a = jbVar.m505a();
                        b(true);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 20:
                    if (b2 == 2) {
                        this.f650b = jbVar.m515a();
                        c(true);
                        continue;
                        jbVar.g();
                    }
                    break;
            }
            je.a(jbVar, b2);
            jbVar.g();
        }
    }

    public void a(String str, String str2) {
        if (this.f647a == null) {
            this.f647a = new HashMap();
        }
        this.f647a.put(str, str2);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m454a(boolean z) {
        this.f646a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m455a() {
        return this.f644a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m456a(ie ieVar) {
        if (ieVar == null) {
            return false;
        }
        boolean m455a = m455a();
        boolean m455a2 = ieVar.m455a();
        if ((m455a || m455a2) && !(m455a && m455a2 && this.f644a.equals(ieVar.f644a))) {
            return false;
        }
        boolean m458b = m458b();
        boolean m458b2 = ieVar.m458b();
        if ((m458b || m458b2) && !(m458b && m458b2 && this.f643a.m405a(ieVar.f643a))) {
            return false;
        }
        boolean m459c = m459c();
        boolean m459c2 = ieVar.m459c();
        if ((m459c || m459c2) && !(m459c && m459c2 && this.f649b.equals(ieVar.f649b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = ieVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f651c.equals(ieVar.f651c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = ieVar.e();
        if (((e2 || e3) && !(e2 && e3 && this.f652d.equals(ieVar.f652d))) || this.f648a != ieVar.f648a) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = ieVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f653e.equals(ieVar.f653e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = ieVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f647a.equals(ieVar.f647a))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = ieVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f654f.equals(ieVar.f654f))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = ieVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f655g.equals(ieVar.f655g))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = ieVar.k();
        if ((k2 || k3) && !(k2 && k3 && this.f656h.equals(ieVar.f656h))) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = ieVar.l();
        if ((l2 || l3) && !(l2 && l3 && this.f657i.equals(ieVar.f657i))) {
            return false;
        }
        boolean m2 = m();
        boolean m3 = ieVar.m();
        if ((m2 || m3) && !(m2 && m3 && this.f645a.equals(ieVar.f645a))) {
            return false;
        }
        boolean n2 = n();
        boolean n3 = ieVar.n();
        if ((n2 || n3) && !(n2 && n3 && this.f642a == ieVar.f642a)) {
            return false;
        }
        boolean o2 = o();
        boolean o3 = ieVar.o();
        if (o2 || o3) {
            return o2 && o3 && this.f650b == ieVar.f650b;
        }
        return true;
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m457a() {
        a(ir.a(this.f645a));
        return this.f645a.array();
    }

    public ie b(String str) {
        this.f651c = str;
        return this;
    }

    public String b() {
        return this.f651c;
    }

    @Override // com.xiaomi.push.iq
    public void b(jb jbVar) {
        m453a();
        jbVar.a(f641a);
        if (this.f644a != null && m455a()) {
            jbVar.a(f41540a);
            jbVar.a(this.f644a);
            jbVar.b();
        }
        if (this.f643a != null && m458b()) {
            jbVar.a(f41541b);
            this.f643a.b(jbVar);
            jbVar.b();
        }
        if (this.f649b != null) {
            jbVar.a(f41542c);
            jbVar.a(this.f649b);
            jbVar.b();
        }
        if (this.f651c != null && d()) {
            jbVar.a(f41543d);
            jbVar.a(this.f651c);
            jbVar.b();
        }
        if (this.f652d != null && e()) {
            jbVar.a(f41544e);
            jbVar.a(this.f652d);
            jbVar.b();
        }
        jbVar.a(f41545f);
        jbVar.a(this.f648a);
        jbVar.b();
        if (this.f653e != null && g()) {
            jbVar.a(f41546g);
            jbVar.a(this.f653e);
            jbVar.b();
        }
        if (this.f647a != null && h()) {
            jbVar.a(f41547h);
            jbVar.a(new ja((byte) 11, (byte) 11, this.f647a.size()));
            for (Map.Entry<String, String> entry : this.f647a.entrySet()) {
                jbVar.a(entry.getKey());
                jbVar.a(entry.getValue());
            }
            jbVar.d();
            jbVar.b();
        }
        if (this.f654f != null && i()) {
            jbVar.a(f41548i);
            jbVar.a(this.f654f);
            jbVar.b();
        }
        if (this.f655g != null && j()) {
            jbVar.a(j);
            jbVar.a(this.f655g);
            jbVar.b();
        }
        if (this.f656h != null && k()) {
            jbVar.a(k);
            jbVar.a(this.f656h);
            jbVar.b();
        }
        if (this.f657i != null && l()) {
            jbVar.a(l);
            jbVar.a(this.f657i);
            jbVar.b();
        }
        if (this.f645a != null && m()) {
            jbVar.a(m);
            jbVar.a(this.f645a);
            jbVar.b();
        }
        if (n()) {
            jbVar.a(n);
            jbVar.a(this.f642a);
            jbVar.b();
        }
        if (o()) {
            jbVar.a(o);
            jbVar.a(this.f650b);
            jbVar.b();
        }
        jbVar.c();
        jbVar.m514a();
    }

    public void b(boolean z) {
        this.f646a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m458b() {
        return this.f643a != null;
    }

    public ie c(String str) {
        this.f652d = str;
        return this;
    }

    public String c() {
        return this.f654f;
    }

    public void c(boolean z) {
        this.f646a.set(2, z);
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m459c() {
        return this.f649b != null;
    }

    public ie d(String str) {
        this.f654f = str;
        return this;
    }

    public boolean d() {
        return this.f651c != null;
    }

    public boolean e() {
        return this.f652d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ie)) {
            return m456a((ie) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f646a.get(0);
    }

    public boolean g() {
        return this.f653e != null;
    }

    public boolean h() {
        return this.f647a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f654f != null;
    }

    public boolean j() {
        return this.f655g != null;
    }

    public boolean k() {
        return this.f656h != null;
    }

    public boolean l() {
        return this.f657i != null;
    }

    public boolean m() {
        return this.f645a != null;
    }

    public boolean n() {
        return this.f646a.get(1);
    }

    public boolean o() {
        return this.f646a.get(2);
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionNotification(");
        boolean z2 = false;
        if (m455a()) {
            sb.append("debug:");
            String str = this.f644a;
            if (str == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (m458b()) {
            if (!z) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            }
            sb.append("target:");
            hu huVar = this.f643a;
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
        String str2 = this.f649b;
        if (str2 == null) {
            sb.append(StringUtil.NULL_STRING);
        } else {
            sb.append(str2);
        }
        if (d()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("appId:");
            String str3 = this.f651c;
            if (str3 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str3);
            }
        }
        if (e()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("type:");
            String str4 = this.f652d;
            if (str4 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str4);
            }
        }
        sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        sb.append("requireAck:");
        sb.append(this.f648a);
        if (g()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("payload:");
            String str5 = this.f653e;
            if (str5 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str5);
            }
        }
        if (h()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("extra:");
            Map<String, String> map = this.f647a;
            if (map == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(map);
            }
        }
        if (i()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("packageName:");
            String str6 = this.f654f;
            if (str6 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str6);
            }
        }
        if (j()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("category:");
            String str7 = this.f655g;
            if (str7 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str7);
            }
        }
        if (k()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("regId:");
            String str8 = this.f656h;
            if (str8 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str8);
            }
        }
        if (l()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("aliasName:");
            String str9 = this.f657i;
            if (str9 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str9);
            }
        }
        if (m()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("binaryExtra:");
            ByteBuffer byteBuffer = this.f645a;
            if (byteBuffer == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                ir.a(byteBuffer, sb);
            }
        }
        if (n()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("createdTs:");
            sb.append(this.f642a);
        }
        if (o()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("alreadyLogClickInXmq:");
            sb.append(this.f650b);
        }
        sb.append(SmallTailInfo.EMOTION_SUFFIX);
        return sb.toString();
    }
}
