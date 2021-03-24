package com.xiaomi.push;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.tbadk.core.data.SmallTailInfo;
import io.flutter.plugin.common.StandardMessageCodec;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
/* loaded from: classes7.dex */
public class hz implements iq<hz, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f602a;

    /* renamed from: a  reason: collision with other field name */
    public hu f603a;

    /* renamed from: a  reason: collision with other field name */
    public String f604a;

    /* renamed from: a  reason: collision with other field name */
    public List<String> f606a;

    /* renamed from: b  reason: collision with other field name */
    public String f608b;

    /* renamed from: c  reason: collision with other field name */
    public String f610c;

    /* renamed from: d  reason: collision with other field name */
    public String f611d;

    /* renamed from: e  reason: collision with other field name */
    public String f612e;

    /* renamed from: a  reason: collision with other field name */
    public static final jg f601a = new jg("XmPushActionCommand");

    /* renamed from: a  reason: collision with root package name */
    public static final iy f40733a = new iy("", StandardMessageCodec.LIST, 2);

    /* renamed from: b  reason: collision with root package name */
    public static final iy f40734b = new iy("", (byte) 11, 3);

    /* renamed from: c  reason: collision with root package name */
    public static final iy f40735c = new iy("", (byte) 11, 4);

    /* renamed from: d  reason: collision with root package name */
    public static final iy f40736d = new iy("", (byte) 11, 5);

    /* renamed from: e  reason: collision with root package name */
    public static final iy f40737e = new iy("", (byte) 15, 6);

    /* renamed from: f  reason: collision with root package name */
    public static final iy f40738f = new iy("", (byte) 11, 7);

    /* renamed from: g  reason: collision with root package name */
    public static final iy f40739g = new iy("", (byte) 11, 9);

    /* renamed from: h  reason: collision with root package name */
    public static final iy f40740h = new iy("", (byte) 2, 10);
    public static final iy i = new iy("", (byte) 2, 11);
    public static final iy j = new iy("", (byte) 10, 12);

    /* renamed from: a  reason: collision with other field name */
    public BitSet f605a = new BitSet(3);

    /* renamed from: a  reason: collision with other field name */
    public boolean f607a = false;

    /* renamed from: b  reason: collision with other field name */
    public boolean f609b = true;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(hz hzVar) {
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
        if (hz.class.equals(hzVar.getClass())) {
            int compareTo = Boolean.valueOf(m414a()).compareTo(Boolean.valueOf(hzVar.m414a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m414a() || (a11 = ir.a(this.f603a, hzVar.f603a)) == 0) {
                int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(hzVar.b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!b() || (a10 = ir.a(this.f604a, hzVar.f604a)) == 0) {
                    int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(hzVar.c()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!c() || (a9 = ir.a(this.f608b, hzVar.f608b)) == 0) {
                        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hzVar.d()));
                        if (compareTo4 != 0) {
                            return compareTo4;
                        }
                        if (!d() || (a8 = ir.a(this.f610c, hzVar.f610c)) == 0) {
                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hzVar.e()));
                            if (compareTo5 != 0) {
                                return compareTo5;
                            }
                            if (!e() || (a7 = ir.a(this.f606a, hzVar.f606a)) == 0) {
                                int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hzVar.f()));
                                if (compareTo6 != 0) {
                                    return compareTo6;
                                }
                                if (!f() || (a6 = ir.a(this.f611d, hzVar.f611d)) == 0) {
                                    int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hzVar.g()));
                                    if (compareTo7 != 0) {
                                        return compareTo7;
                                    }
                                    if (!g() || (a5 = ir.a(this.f612e, hzVar.f612e)) == 0) {
                                        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hzVar.h()));
                                        if (compareTo8 != 0) {
                                            return compareTo8;
                                        }
                                        if (!h() || (a4 = ir.a(this.f607a, hzVar.f607a)) == 0) {
                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hzVar.i()));
                                            if (compareTo9 != 0) {
                                                return compareTo9;
                                            }
                                            if (!i() || (a3 = ir.a(this.f609b, hzVar.f609b)) == 0) {
                                                int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(hzVar.j()));
                                                if (compareTo10 != 0) {
                                                    return compareTo10;
                                                }
                                                if (!j() || (a2 = ir.a(this.f602a, hzVar.f602a)) == 0) {
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
        return hz.class.getName().compareTo(hzVar.getClass().getName());
    }

    public hz a(String str) {
        this.f604a = str;
        return this;
    }

    public hz a(List<String> list) {
        this.f606a = list;
        return this;
    }

    public String a() {
        return this.f610c;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m412a() {
        if (this.f604a == null) {
            throw new jc("Required field 'id' was not present! Struct: " + toString());
        } else if (this.f608b == null) {
            throw new jc("Required field 'appId' was not present! Struct: " + toString());
        } else if (this.f610c != null) {
        } else {
            throw new jc("Required field 'cmdName' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.iq
    public void a(jb jbVar) {
        jbVar.m505a();
        while (true) {
            iy m501a = jbVar.m501a();
            byte b2 = m501a.f40866a;
            if (b2 == 0) {
                jbVar.f();
                m412a();
                return;
            }
            switch (m501a.f807a) {
                case 2:
                    if (b2 == 12) {
                        hu huVar = new hu();
                        this.f603a = huVar;
                        huVar.a(jbVar);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f604a = jbVar.m506a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f608b = jbVar.m506a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 5:
                    if (b2 == 11) {
                        this.f610c = jbVar.m506a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 6:
                    if (b2 == 15) {
                        iz m502a = jbVar.m502a();
                        this.f606a = new ArrayList(m502a.f808a);
                        for (int i2 = 0; i2 < m502a.f808a; i2++) {
                            this.f606a.add(jbVar.m506a());
                        }
                        jbVar.i();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f611d = jbVar.m506a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 9:
                    if (b2 == 11) {
                        this.f612e = jbVar.m506a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 10:
                    if (b2 == 2) {
                        this.f607a = jbVar.m510a();
                        a(true);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 11:
                    if (b2 == 2) {
                        this.f609b = jbVar.m510a();
                        b(true);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 12:
                    if (b2 == 10) {
                        this.f602a = jbVar.m500a();
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

    /* renamed from: a  reason: collision with other method in class */
    public void m413a(String str) {
        if (this.f606a == null) {
            this.f606a = new ArrayList();
        }
        this.f606a.add(str);
    }

    public void a(boolean z) {
        this.f605a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m414a() {
        return this.f603a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m415a(hz hzVar) {
        if (hzVar == null) {
            return false;
        }
        boolean m414a = m414a();
        boolean m414a2 = hzVar.m414a();
        if ((m414a || m414a2) && !(m414a && m414a2 && this.f603a.m400a(hzVar.f603a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = hzVar.b();
        if ((b2 || b3) && !(b2 && b3 && this.f604a.equals(hzVar.f604a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = hzVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f608b.equals(hzVar.f608b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = hzVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f610c.equals(hzVar.f610c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = hzVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f606a.equals(hzVar.f606a))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = hzVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f611d.equals(hzVar.f611d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = hzVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f612e.equals(hzVar.f612e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = hzVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f607a == hzVar.f607a)) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = hzVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f609b == hzVar.f609b)) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = hzVar.j();
        if (j2 || j3) {
            return j2 && j3 && this.f602a == hzVar.f602a;
        }
        return true;
    }

    public hz b(String str) {
        this.f608b = str;
        return this;
    }

    @Override // com.xiaomi.push.iq
    public void b(jb jbVar) {
        m412a();
        jbVar.a(f601a);
        if (this.f603a != null && m414a()) {
            jbVar.a(f40733a);
            this.f603a.b(jbVar);
            jbVar.b();
        }
        if (this.f604a != null) {
            jbVar.a(f40734b);
            jbVar.a(this.f604a);
            jbVar.b();
        }
        if (this.f608b != null) {
            jbVar.a(f40735c);
            jbVar.a(this.f608b);
            jbVar.b();
        }
        if (this.f610c != null) {
            jbVar.a(f40736d);
            jbVar.a(this.f610c);
            jbVar.b();
        }
        if (this.f606a != null && e()) {
            jbVar.a(f40737e);
            jbVar.a(new iz((byte) 11, this.f606a.size()));
            for (String str : this.f606a) {
                jbVar.a(str);
            }
            jbVar.e();
            jbVar.b();
        }
        if (this.f611d != null && f()) {
            jbVar.a(f40738f);
            jbVar.a(this.f611d);
            jbVar.b();
        }
        if (this.f612e != null && g()) {
            jbVar.a(f40739g);
            jbVar.a(this.f612e);
            jbVar.b();
        }
        if (h()) {
            jbVar.a(f40740h);
            jbVar.a(this.f607a);
            jbVar.b();
        }
        if (i()) {
            jbVar.a(i);
            jbVar.a(this.f609b);
            jbVar.b();
        }
        if (j()) {
            jbVar.a(j);
            jbVar.a(this.f602a);
            jbVar.b();
        }
        jbVar.c();
        jbVar.m509a();
    }

    public void b(boolean z) {
        this.f605a.set(1, z);
    }

    public boolean b() {
        return this.f604a != null;
    }

    public hz c(String str) {
        this.f610c = str;
        return this;
    }

    public void c(boolean z) {
        this.f605a.set(2, z);
    }

    public boolean c() {
        return this.f608b != null;
    }

    public hz d(String str) {
        this.f611d = str;
        return this;
    }

    public boolean d() {
        return this.f610c != null;
    }

    public hz e(String str) {
        this.f612e = str;
        return this;
    }

    public boolean e() {
        return this.f606a != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hz)) {
            return m415a((hz) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f611d != null;
    }

    public boolean g() {
        return this.f612e != null;
    }

    public boolean h() {
        return this.f605a.get(0);
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f605a.get(1);
    }

    public boolean j() {
        return this.f605a.get(2);
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionCommand(");
        if (m414a()) {
            sb.append("target:");
            hu huVar = this.f603a;
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
        String str = this.f604a;
        if (str == null) {
            sb.append(StringUtil.NULL_STRING);
        } else {
            sb.append(str);
        }
        sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        sb.append("appId:");
        String str2 = this.f608b;
        if (str2 == null) {
            sb.append(StringUtil.NULL_STRING);
        } else {
            sb.append(str2);
        }
        sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        sb.append("cmdName:");
        String str3 = this.f610c;
        if (str3 == null) {
            sb.append(StringUtil.NULL_STRING);
        } else {
            sb.append(str3);
        }
        if (e()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("cmdArgs:");
            List<String> list = this.f606a;
            if (list == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(list);
            }
        }
        if (f()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("packageName:");
            String str4 = this.f611d;
            if (str4 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str4);
            }
        }
        if (g()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("category:");
            String str5 = this.f612e;
            if (str5 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str5);
            }
        }
        if (h()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("updateCache:");
            sb.append(this.f607a);
        }
        if (i()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("response2Client:");
            sb.append(this.f609b);
        }
        if (j()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("createdTs:");
            sb.append(this.f602a);
        }
        sb.append(SmallTailInfo.EMOTION_SUFFIX);
        return sb.toString();
    }
}
