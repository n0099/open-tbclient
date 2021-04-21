package com.xiaomi.push;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.tbadk.core.data.SmallTailInfo;
import io.flutter.plugin.common.StandardMessageCodec;
import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes7.dex */
public class hw implements iq<hw, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public hu f585a;

    /* renamed from: a  reason: collision with other field name */
    public String f586a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f588a;

    /* renamed from: b  reason: collision with other field name */
    public String f589b;

    /* renamed from: c  reason: collision with other field name */
    public String f590c;

    /* renamed from: d  reason: collision with other field name */
    public String f591d;

    /* renamed from: e  reason: collision with other field name */
    public String f592e;

    /* renamed from: f  reason: collision with other field name */
    public String f593f;

    /* renamed from: g  reason: collision with other field name */
    public String f594g;

    /* renamed from: a  reason: collision with other field name */
    public static final jg f583a = new jg("XmPushActionAckNotification");

    /* renamed from: a  reason: collision with root package name */
    public static final iy f41107a = new iy("", (byte) 11, 1);

    /* renamed from: b  reason: collision with root package name */
    public static final iy f41108b = new iy("", StandardMessageCodec.LIST, 2);

    /* renamed from: c  reason: collision with root package name */
    public static final iy f41109c = new iy("", (byte) 11, 3);

    /* renamed from: d  reason: collision with root package name */
    public static final iy f41110d = new iy("", (byte) 11, 4);

    /* renamed from: e  reason: collision with root package name */
    public static final iy f41111e = new iy("", (byte) 11, 5);

    /* renamed from: f  reason: collision with root package name */
    public static final iy f41112f = new iy("", (byte) 10, 7);

    /* renamed from: g  reason: collision with root package name */
    public static final iy f41113g = new iy("", (byte) 11, 8);

    /* renamed from: h  reason: collision with root package name */
    public static final iy f41114h = new iy("", (byte) 13, 9);
    public static final iy i = new iy("", (byte) 11, 10);
    public static final iy j = new iy("", (byte) 11, 11);

    /* renamed from: a  reason: collision with other field name */
    public BitSet f587a = new BitSet(1);

    /* renamed from: a  reason: collision with other field name */
    public long f584a = 0;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(hw hwVar) {
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
        if (hw.class.equals(hwVar.getClass())) {
            int compareTo = Boolean.valueOf(m409a()).compareTo(Boolean.valueOf(hwVar.m409a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m409a() || (a11 = ir.a(this.f586a, hwVar.f586a)) == 0) {
                int compareTo2 = Boolean.valueOf(m411b()).compareTo(Boolean.valueOf(hwVar.m411b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!m411b() || (a10 = ir.a(this.f585a, hwVar.f585a)) == 0) {
                    int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(hwVar.c()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!c() || (a9 = ir.a(this.f589b, hwVar.f589b)) == 0) {
                        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hwVar.d()));
                        if (compareTo4 != 0) {
                            return compareTo4;
                        }
                        if (!d() || (a8 = ir.a(this.f590c, hwVar.f590c)) == 0) {
                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hwVar.e()));
                            if (compareTo5 != 0) {
                                return compareTo5;
                            }
                            if (!e() || (a7 = ir.a(this.f591d, hwVar.f591d)) == 0) {
                                int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hwVar.f()));
                                if (compareTo6 != 0) {
                                    return compareTo6;
                                }
                                if (!f() || (a6 = ir.a(this.f584a, hwVar.f584a)) == 0) {
                                    int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hwVar.g()));
                                    if (compareTo7 != 0) {
                                        return compareTo7;
                                    }
                                    if (!g() || (a5 = ir.a(this.f592e, hwVar.f592e)) == 0) {
                                        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hwVar.h()));
                                        if (compareTo8 != 0) {
                                            return compareTo8;
                                        }
                                        if (!h() || (a4 = ir.a(this.f588a, hwVar.f588a)) == 0) {
                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hwVar.i()));
                                            if (compareTo9 != 0) {
                                                return compareTo9;
                                            }
                                            if (!i() || (a3 = ir.a(this.f593f, hwVar.f593f)) == 0) {
                                                int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(hwVar.j()));
                                                if (compareTo10 != 0) {
                                                    return compareTo10;
                                                }
                                                if (!j() || (a2 = ir.a(this.f594g, hwVar.f594g)) == 0) {
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
        return hw.class.getName().compareTo(hwVar.getClass().getName());
    }

    public hw a(long j2) {
        this.f584a = j2;
        a(true);
        return this;
    }

    public hw a(hu huVar) {
        this.f585a = huVar;
        return this;
    }

    public hw a(String str) {
        this.f589b = str;
        return this;
    }

    public String a() {
        return this.f589b;
    }

    /* renamed from: a  reason: collision with other method in class */
    public Map<String, String> m407a() {
        return this.f588a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m408a() {
        if (this.f589b != null) {
            return;
        }
        throw new jc("Required field 'id' was not present! Struct: " + toString());
    }

    @Override // com.xiaomi.push.iq
    public void a(jb jbVar) {
        jbVar.m509a();
        while (true) {
            iy m505a = jbVar.m505a();
            byte b2 = m505a.f41251a;
            if (b2 == 0) {
                jbVar.f();
                m408a();
                return;
            }
            switch (m505a.f807a) {
                case 1:
                    if (b2 == 11) {
                        this.f586a = jbVar.m510a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 2:
                    if (b2 == 12) {
                        hu huVar = new hu();
                        this.f585a = huVar;
                        huVar.a(jbVar);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f589b = jbVar.m510a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f590c = jbVar.m510a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 5:
                    if (b2 == 11) {
                        this.f591d = jbVar.m510a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 7:
                    if (b2 == 10) {
                        this.f584a = jbVar.m504a();
                        a(true);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 8:
                    if (b2 == 11) {
                        this.f592e = jbVar.m510a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 9:
                    if (b2 == 13) {
                        ja m507a = jbVar.m507a();
                        this.f588a = new HashMap(m507a.f811a * 2);
                        for (int i2 = 0; i2 < m507a.f811a; i2++) {
                            this.f588a.put(jbVar.m510a(), jbVar.m510a());
                        }
                        jbVar.h();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 10:
                    if (b2 == 11) {
                        this.f593f = jbVar.m510a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 11:
                    if (b2 == 11) {
                        this.f594g = jbVar.m510a();
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
        this.f587a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m409a() {
        return this.f586a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m410a(hw hwVar) {
        if (hwVar == null) {
            return false;
        }
        boolean m409a = m409a();
        boolean m409a2 = hwVar.m409a();
        if ((m409a || m409a2) && !(m409a && m409a2 && this.f586a.equals(hwVar.f586a))) {
            return false;
        }
        boolean m411b = m411b();
        boolean m411b2 = hwVar.m411b();
        if ((m411b || m411b2) && !(m411b && m411b2 && this.f585a.m404a(hwVar.f585a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = hwVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f589b.equals(hwVar.f589b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = hwVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f590c.equals(hwVar.f590c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = hwVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f591d.equals(hwVar.f591d))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = hwVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f584a == hwVar.f584a)) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = hwVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f592e.equals(hwVar.f592e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = hwVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f588a.equals(hwVar.f588a))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = hwVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f593f.equals(hwVar.f593f))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = hwVar.j();
        if (j2 || j3) {
            return j2 && j3 && this.f594g.equals(hwVar.f594g);
        }
        return true;
    }

    public hw b(String str) {
        this.f590c = str;
        return this;
    }

    public String b() {
        return this.f591d;
    }

    @Override // com.xiaomi.push.iq
    public void b(jb jbVar) {
        m408a();
        jbVar.a(f583a);
        if (this.f586a != null && m409a()) {
            jbVar.a(f41107a);
            jbVar.a(this.f586a);
            jbVar.b();
        }
        if (this.f585a != null && m411b()) {
            jbVar.a(f41108b);
            this.f585a.b(jbVar);
            jbVar.b();
        }
        if (this.f589b != null) {
            jbVar.a(f41109c);
            jbVar.a(this.f589b);
            jbVar.b();
        }
        if (this.f590c != null && d()) {
            jbVar.a(f41110d);
            jbVar.a(this.f590c);
            jbVar.b();
        }
        if (this.f591d != null && e()) {
            jbVar.a(f41111e);
            jbVar.a(this.f591d);
            jbVar.b();
        }
        if (f()) {
            jbVar.a(f41112f);
            jbVar.a(this.f584a);
            jbVar.b();
        }
        if (this.f592e != null && g()) {
            jbVar.a(f41113g);
            jbVar.a(this.f592e);
            jbVar.b();
        }
        if (this.f588a != null && h()) {
            jbVar.a(f41114h);
            jbVar.a(new ja((byte) 11, (byte) 11, this.f588a.size()));
            for (Map.Entry<String, String> entry : this.f588a.entrySet()) {
                jbVar.a(entry.getKey());
                jbVar.a(entry.getValue());
            }
            jbVar.d();
            jbVar.b();
        }
        if (this.f593f != null && i()) {
            jbVar.a(i);
            jbVar.a(this.f593f);
            jbVar.b();
        }
        if (this.f594g != null && j()) {
            jbVar.a(j);
            jbVar.a(this.f594g);
            jbVar.b();
        }
        jbVar.c();
        jbVar.m513a();
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m411b() {
        return this.f585a != null;
    }

    public hw c(String str) {
        this.f591d = str;
        return this;
    }

    public boolean c() {
        return this.f589b != null;
    }

    public hw d(String str) {
        this.f592e = str;
        return this;
    }

    public boolean d() {
        return this.f590c != null;
    }

    public hw e(String str) {
        this.f593f = str;
        return this;
    }

    public boolean e() {
        return this.f591d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hw)) {
            return m410a((hw) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f587a.get(0);
    }

    public boolean g() {
        return this.f592e != null;
    }

    public boolean h() {
        return this.f588a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f593f != null;
    }

    public boolean j() {
        return this.f594g != null;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionAckNotification(");
        boolean z2 = false;
        if (m409a()) {
            sb.append("debug:");
            String str = this.f586a;
            if (str == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (m411b()) {
            if (!z) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            }
            sb.append("target:");
            hu huVar = this.f585a;
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
        String str2 = this.f589b;
        if (str2 == null) {
            sb.append(StringUtil.NULL_STRING);
        } else {
            sb.append(str2);
        }
        if (d()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("appId:");
            String str3 = this.f590c;
            if (str3 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str3);
            }
        }
        if (e()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("type:");
            String str4 = this.f591d;
            if (str4 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str4);
            }
        }
        if (f()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("errorCode:");
            sb.append(this.f584a);
        }
        if (g()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("reason:");
            String str5 = this.f592e;
            if (str5 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str5);
            }
        }
        if (h()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("extra:");
            Map<String, String> map = this.f588a;
            if (map == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(map);
            }
        }
        if (i()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("packageName:");
            String str6 = this.f593f;
            if (str6 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str6);
            }
        }
        if (j()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("category:");
            String str7 = this.f594g;
            if (str7 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str7);
            }
        }
        sb.append(SmallTailInfo.EMOTION_SUFFIX);
        return sb.toString();
    }
}
