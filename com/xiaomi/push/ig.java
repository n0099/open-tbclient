package com.xiaomi.push;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.tbadk.core.data.SmallTailInfo;
import io.flutter.plugin.common.StandardMessageCodec;
import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes7.dex */
public class ig implements iq<ig, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public int f690a;

    /* renamed from: a  reason: collision with other field name */
    public long f691a;

    /* renamed from: a  reason: collision with other field name */
    public hu f692a;

    /* renamed from: a  reason: collision with other field name */
    public String f693a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f694a = new BitSet(5);

    /* renamed from: b  reason: collision with other field name */
    public int f695b;

    /* renamed from: b  reason: collision with other field name */
    public long f696b;

    /* renamed from: b  reason: collision with other field name */
    public String f697b;

    /* renamed from: c  reason: collision with other field name */
    public long f698c;

    /* renamed from: c  reason: collision with other field name */
    public String f699c;

    /* renamed from: d  reason: collision with other field name */
    public String f700d;

    /* renamed from: e  reason: collision with other field name */
    public String f701e;

    /* renamed from: f  reason: collision with other field name */
    public String f702f;

    /* renamed from: g  reason: collision with other field name */
    public String f703g;

    /* renamed from: h  reason: collision with other field name */
    public String f704h;

    /* renamed from: i  reason: collision with other field name */
    public String f705i;

    /* renamed from: j  reason: collision with other field name */
    public String f706j;

    /* renamed from: k  reason: collision with other field name */
    public String f707k;

    /* renamed from: l  reason: collision with other field name */
    public String f708l;

    /* renamed from: a  reason: collision with other field name */
    public static final jg f689a = new jg("XmPushActionRegistrationResult");

    /* renamed from: a  reason: collision with root package name */
    public static final iy f40783a = new iy("", (byte) 11, 1);

    /* renamed from: b  reason: collision with root package name */
    public static final iy f40784b = new iy("", StandardMessageCodec.LIST, 2);

    /* renamed from: c  reason: collision with root package name */
    public static final iy f40785c = new iy("", (byte) 11, 3);

    /* renamed from: d  reason: collision with root package name */
    public static final iy f40786d = new iy("", (byte) 11, 4);

    /* renamed from: e  reason: collision with root package name */
    public static final iy f40787e = new iy("", (byte) 10, 6);

    /* renamed from: f  reason: collision with root package name */
    public static final iy f40788f = new iy("", (byte) 11, 7);

    /* renamed from: g  reason: collision with root package name */
    public static final iy f40789g = new iy("", (byte) 11, 8);

    /* renamed from: h  reason: collision with root package name */
    public static final iy f40790h = new iy("", (byte) 11, 9);
    public static final iy i = new iy("", (byte) 11, 10);
    public static final iy j = new iy("", (byte) 10, 11);
    public static final iy k = new iy("", (byte) 11, 12);
    public static final iy l = new iy("", (byte) 11, 13);
    public static final iy m = new iy("", (byte) 10, 14);
    public static final iy n = new iy("", (byte) 11, 15);
    public static final iy o = new iy("", (byte) 8, 16);
    public static final iy p = new iy("", (byte) 11, 17);
    public static final iy q = new iy("", (byte) 8, 18);
    public static final iy r = new iy("", (byte) 11, 19);

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
        int a17;
        int a18;
        int a19;
        if (ig.class.equals(igVar.getClass())) {
            int compareTo = Boolean.valueOf(m462a()).compareTo(Boolean.valueOf(igVar.m462a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m462a() || (a19 = ir.a(this.f693a, igVar.f693a)) == 0) {
                int compareTo2 = Boolean.valueOf(m464b()).compareTo(Boolean.valueOf(igVar.m464b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!m464b() || (a18 = ir.a(this.f692a, igVar.f692a)) == 0) {
                    int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(igVar.c()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!c() || (a17 = ir.a(this.f697b, igVar.f697b)) == 0) {
                        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(igVar.d()));
                        if (compareTo4 != 0) {
                            return compareTo4;
                        }
                        if (!d() || (a16 = ir.a(this.f699c, igVar.f699c)) == 0) {
                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(igVar.e()));
                            if (compareTo5 != 0) {
                                return compareTo5;
                            }
                            if (!e() || (a15 = ir.a(this.f691a, igVar.f691a)) == 0) {
                                int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(igVar.f()));
                                if (compareTo6 != 0) {
                                    return compareTo6;
                                }
                                if (!f() || (a14 = ir.a(this.f700d, igVar.f700d)) == 0) {
                                    int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(igVar.g()));
                                    if (compareTo7 != 0) {
                                        return compareTo7;
                                    }
                                    if (!g() || (a13 = ir.a(this.f701e, igVar.f701e)) == 0) {
                                        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(igVar.h()));
                                        if (compareTo8 != 0) {
                                            return compareTo8;
                                        }
                                        if (!h() || (a12 = ir.a(this.f702f, igVar.f702f)) == 0) {
                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(igVar.i()));
                                            if (compareTo9 != 0) {
                                                return compareTo9;
                                            }
                                            if (!i() || (a11 = ir.a(this.f703g, igVar.f703g)) == 0) {
                                                int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(igVar.j()));
                                                if (compareTo10 != 0) {
                                                    return compareTo10;
                                                }
                                                if (!j() || (a10 = ir.a(this.f696b, igVar.f696b)) == 0) {
                                                    int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(igVar.k()));
                                                    if (compareTo11 != 0) {
                                                        return compareTo11;
                                                    }
                                                    if (!k() || (a9 = ir.a(this.f704h, igVar.f704h)) == 0) {
                                                        int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(igVar.l()));
                                                        if (compareTo12 != 0) {
                                                            return compareTo12;
                                                        }
                                                        if (!l() || (a8 = ir.a(this.f705i, igVar.f705i)) == 0) {
                                                            int compareTo13 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(igVar.m()));
                                                            if (compareTo13 != 0) {
                                                                return compareTo13;
                                                            }
                                                            if (!m() || (a7 = ir.a(this.f698c, igVar.f698c)) == 0) {
                                                                int compareTo14 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(igVar.n()));
                                                                if (compareTo14 != 0) {
                                                                    return compareTo14;
                                                                }
                                                                if (!n() || (a6 = ir.a(this.f706j, igVar.f706j)) == 0) {
                                                                    int compareTo15 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(igVar.o()));
                                                                    if (compareTo15 != 0) {
                                                                        return compareTo15;
                                                                    }
                                                                    if (!o() || (a5 = ir.a(this.f690a, igVar.f690a)) == 0) {
                                                                        int compareTo16 = Boolean.valueOf(p()).compareTo(Boolean.valueOf(igVar.p()));
                                                                        if (compareTo16 != 0) {
                                                                            return compareTo16;
                                                                        }
                                                                        if (!p() || (a4 = ir.a(this.f707k, igVar.f707k)) == 0) {
                                                                            int compareTo17 = Boolean.valueOf(q()).compareTo(Boolean.valueOf(igVar.q()));
                                                                            if (compareTo17 != 0) {
                                                                                return compareTo17;
                                                                            }
                                                                            if (!q() || (a3 = ir.a(this.f695b, igVar.f695b)) == 0) {
                                                                                int compareTo18 = Boolean.valueOf(r()).compareTo(Boolean.valueOf(igVar.r()));
                                                                                if (compareTo18 != 0) {
                                                                                    return compareTo18;
                                                                                }
                                                                                if (!r() || (a2 = ir.a(this.f708l, igVar.f708l)) == 0) {
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
                    return a17;
                }
                return a18;
            }
            return a19;
        }
        return ig.class.getName().compareTo(igVar.getClass().getName());
    }

    public long a() {
        return this.f691a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m460a() {
        return this.f697b;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m461a() {
        if (this.f697b == null) {
            throw new jc("Required field 'id' was not present! Struct: " + toString());
        } else if (this.f699c != null) {
        } else {
            throw new jc("Required field 'appId' was not present! Struct: " + toString());
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
                    m461a();
                    return;
                }
                throw new jc("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
            }
            switch (m501a.f807a) {
                case 1:
                    if (b2 == 11) {
                        this.f693a = jbVar.m506a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 2:
                    if (b2 == 12) {
                        hu huVar = new hu();
                        this.f692a = huVar;
                        huVar.a(jbVar);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f697b = jbVar.m506a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f699c = jbVar.m506a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 6:
                    if (b2 == 10) {
                        this.f691a = jbVar.m500a();
                        a(true);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f700d = jbVar.m506a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 8:
                    if (b2 == 11) {
                        this.f701e = jbVar.m506a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 9:
                    if (b2 == 11) {
                        this.f702f = jbVar.m506a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 10:
                    if (b2 == 11) {
                        this.f703g = jbVar.m506a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 11:
                    if (b2 == 10) {
                        this.f696b = jbVar.m500a();
                        b(true);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 12:
                    if (b2 == 11) {
                        this.f704h = jbVar.m506a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 13:
                    if (b2 == 11) {
                        this.f705i = jbVar.m506a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 14:
                    if (b2 == 10) {
                        this.f698c = jbVar.m500a();
                        c(true);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 15:
                    if (b2 == 11) {
                        this.f706j = jbVar.m506a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 16:
                    if (b2 == 8) {
                        this.f690a = jbVar.m499a();
                        d(true);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 17:
                    if (b2 == 11) {
                        this.f707k = jbVar.m506a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 18:
                    if (b2 == 8) {
                        this.f695b = jbVar.m499a();
                        e(true);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 19:
                    if (b2 == 11) {
                        this.f708l = jbVar.m506a();
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
        this.f694a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m462a() {
        return this.f693a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m463a(ig igVar) {
        if (igVar == null) {
            return false;
        }
        boolean m462a = m462a();
        boolean m462a2 = igVar.m462a();
        if ((m462a || m462a2) && !(m462a && m462a2 && this.f693a.equals(igVar.f693a))) {
            return false;
        }
        boolean m464b = m464b();
        boolean m464b2 = igVar.m464b();
        if ((m464b || m464b2) && !(m464b && m464b2 && this.f692a.m400a(igVar.f692a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = igVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f697b.equals(igVar.f697b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = igVar.d();
        if (((d2 || d3) && !(d2 && d3 && this.f699c.equals(igVar.f699c))) || this.f691a != igVar.f691a) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = igVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f700d.equals(igVar.f700d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = igVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f701e.equals(igVar.f701e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = igVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f702f.equals(igVar.f702f))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = igVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f703g.equals(igVar.f703g))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = igVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f696b == igVar.f696b)) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = igVar.k();
        if ((k2 || k3) && !(k2 && k3 && this.f704h.equals(igVar.f704h))) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = igVar.l();
        if ((l2 || l3) && !(l2 && l3 && this.f705i.equals(igVar.f705i))) {
            return false;
        }
        boolean m2 = m();
        boolean m3 = igVar.m();
        if ((m2 || m3) && !(m2 && m3 && this.f698c == igVar.f698c)) {
            return false;
        }
        boolean n2 = n();
        boolean n3 = igVar.n();
        if ((n2 || n3) && !(n2 && n3 && this.f706j.equals(igVar.f706j))) {
            return false;
        }
        boolean o2 = o();
        boolean o3 = igVar.o();
        if ((o2 || o3) && !(o2 && o3 && this.f690a == igVar.f690a)) {
            return false;
        }
        boolean p2 = p();
        boolean p3 = igVar.p();
        if ((p2 || p3) && !(p2 && p3 && this.f707k.equals(igVar.f707k))) {
            return false;
        }
        boolean q2 = q();
        boolean q3 = igVar.q();
        if ((q2 || q3) && !(q2 && q3 && this.f695b == igVar.f695b)) {
            return false;
        }
        boolean r2 = r();
        boolean r3 = igVar.r();
        if (r2 || r3) {
            return r2 && r3 && this.f708l.equals(igVar.f708l);
        }
        return true;
    }

    public String b() {
        return this.f703g;
    }

    @Override // com.xiaomi.push.iq
    public void b(jb jbVar) {
        m461a();
        jbVar.a(f689a);
        if (this.f693a != null && m462a()) {
            jbVar.a(f40783a);
            jbVar.a(this.f693a);
            jbVar.b();
        }
        if (this.f692a != null && m464b()) {
            jbVar.a(f40784b);
            this.f692a.b(jbVar);
            jbVar.b();
        }
        if (this.f697b != null) {
            jbVar.a(f40785c);
            jbVar.a(this.f697b);
            jbVar.b();
        }
        if (this.f699c != null) {
            jbVar.a(f40786d);
            jbVar.a(this.f699c);
            jbVar.b();
        }
        jbVar.a(f40787e);
        jbVar.a(this.f691a);
        jbVar.b();
        if (this.f700d != null && f()) {
            jbVar.a(f40788f);
            jbVar.a(this.f700d);
            jbVar.b();
        }
        if (this.f701e != null && g()) {
            jbVar.a(f40789g);
            jbVar.a(this.f701e);
            jbVar.b();
        }
        if (this.f702f != null && h()) {
            jbVar.a(f40790h);
            jbVar.a(this.f702f);
            jbVar.b();
        }
        if (this.f703g != null && i()) {
            jbVar.a(i);
            jbVar.a(this.f703g);
            jbVar.b();
        }
        if (j()) {
            jbVar.a(j);
            jbVar.a(this.f696b);
            jbVar.b();
        }
        if (this.f704h != null && k()) {
            jbVar.a(k);
            jbVar.a(this.f704h);
            jbVar.b();
        }
        if (this.f705i != null && l()) {
            jbVar.a(l);
            jbVar.a(this.f705i);
            jbVar.b();
        }
        if (m()) {
            jbVar.a(m);
            jbVar.a(this.f698c);
            jbVar.b();
        }
        if (this.f706j != null && n()) {
            jbVar.a(n);
            jbVar.a(this.f706j);
            jbVar.b();
        }
        if (o()) {
            jbVar.a(o);
            jbVar.a(this.f690a);
            jbVar.b();
        }
        if (this.f707k != null && p()) {
            jbVar.a(p);
            jbVar.a(this.f707k);
            jbVar.b();
        }
        if (q()) {
            jbVar.a(q);
            jbVar.a(this.f695b);
            jbVar.b();
        }
        if (this.f708l != null && r()) {
            jbVar.a(r);
            jbVar.a(this.f708l);
            jbVar.b();
        }
        jbVar.c();
        jbVar.m509a();
    }

    public void b(boolean z) {
        this.f694a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m464b() {
        return this.f692a != null;
    }

    public void c(boolean z) {
        this.f694a.set(2, z);
    }

    public boolean c() {
        return this.f697b != null;
    }

    public void d(boolean z) {
        this.f694a.set(3, z);
    }

    public boolean d() {
        return this.f699c != null;
    }

    public void e(boolean z) {
        this.f694a.set(4, z);
    }

    public boolean e() {
        return this.f694a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ig)) {
            return m463a((ig) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f700d != null;
    }

    public boolean g() {
        return this.f701e != null;
    }

    public boolean h() {
        return this.f702f != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f703g != null;
    }

    public boolean j() {
        return this.f694a.get(1);
    }

    public boolean k() {
        return this.f704h != null;
    }

    public boolean l() {
        return this.f705i != null;
    }

    public boolean m() {
        return this.f694a.get(2);
    }

    public boolean n() {
        return this.f706j != null;
    }

    public boolean o() {
        return this.f694a.get(3);
    }

    public boolean p() {
        return this.f707k != null;
    }

    public boolean q() {
        return this.f694a.get(4);
    }

    public boolean r() {
        return this.f708l != null;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionRegistrationResult(");
        boolean z2 = false;
        if (m462a()) {
            sb.append("debug:");
            String str = this.f693a;
            if (str == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (m464b()) {
            if (!z) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            }
            sb.append("target:");
            hu huVar = this.f692a;
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
        String str2 = this.f697b;
        if (str2 == null) {
            sb.append(StringUtil.NULL_STRING);
        } else {
            sb.append(str2);
        }
        sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        sb.append("appId:");
        String str3 = this.f699c;
        if (str3 == null) {
            sb.append(StringUtil.NULL_STRING);
        } else {
            sb.append(str3);
        }
        sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        sb.append("errorCode:");
        sb.append(this.f691a);
        if (f()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("reason:");
            String str4 = this.f700d;
            if (str4 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str4);
            }
        }
        if (g()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("regId:");
            String str5 = this.f701e;
            if (str5 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str5);
            }
        }
        if (h()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("regSecret:");
            String str6 = this.f702f;
            if (str6 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str6);
            }
        }
        if (i()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("packageName:");
            String str7 = this.f703g;
            if (str7 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str7);
            }
        }
        if (j()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("registeredAt:");
            sb.append(this.f696b);
        }
        if (k()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("aliasName:");
            String str8 = this.f704h;
            if (str8 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str8);
            }
        }
        if (l()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("clientId:");
            String str9 = this.f705i;
            if (str9 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str9);
            }
        }
        if (m()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("costTime:");
            sb.append(this.f698c);
        }
        if (n()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("appVersion:");
            String str10 = this.f706j;
            if (str10 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str10);
            }
        }
        if (o()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("pushSdkVersionCode:");
            sb.append(this.f690a);
        }
        if (p()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("hybridPushEndpoint:");
            String str11 = this.f707k;
            if (str11 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str11);
            }
        }
        if (q()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("appVersionCode:");
            sb.append(this.f695b);
        }
        if (r()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("region:");
            String str12 = this.f708l;
            if (str12 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str12);
            }
        }
        sb.append(SmallTailInfo.EMOTION_SUFFIX);
        return sb.toString();
    }
}
