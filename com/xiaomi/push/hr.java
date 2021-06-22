package com.xiaomi.push;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import io.flutter.plugin.common.StandardMessageCodec;
import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes7.dex */
public class hr implements iq<hr, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f517a;

    /* renamed from: a  reason: collision with other field name */
    public hs f518a;

    /* renamed from: a  reason: collision with other field name */
    public hu f519a;

    /* renamed from: a  reason: collision with other field name */
    public String f520a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f521a = new BitSet(4);

    /* renamed from: a  reason: collision with other field name */
    public boolean f522a = false;

    /* renamed from: b  reason: collision with other field name */
    public long f523b;

    /* renamed from: b  reason: collision with other field name */
    public String f524b;

    /* renamed from: c  reason: collision with other field name */
    public long f525c;

    /* renamed from: c  reason: collision with other field name */
    public String f526c;

    /* renamed from: d  reason: collision with other field name */
    public String f527d;

    /* renamed from: e  reason: collision with other field name */
    public String f528e;

    /* renamed from: f  reason: collision with other field name */
    public String f529f;

    /* renamed from: g  reason: collision with other field name */
    public String f530g;

    /* renamed from: h  reason: collision with other field name */
    public String f531h;

    /* renamed from: i  reason: collision with other field name */
    public String f532i;

    /* renamed from: j  reason: collision with other field name */
    public String f533j;

    /* renamed from: k  reason: collision with other field name */
    public String f534k;

    /* renamed from: l  reason: collision with other field name */
    public String f535l;

    /* renamed from: a  reason: collision with other field name */
    public static final jg f516a = new jg("PushMessage");

    /* renamed from: a  reason: collision with root package name */
    public static final iy f41560a = new iy("", StandardMessageCodec.LIST, 1);

    /* renamed from: b  reason: collision with root package name */
    public static final iy f41561b = new iy("", (byte) 11, 2);

    /* renamed from: c  reason: collision with root package name */
    public static final iy f41562c = new iy("", (byte) 11, 3);

    /* renamed from: d  reason: collision with root package name */
    public static final iy f41563d = new iy("", (byte) 11, 4);

    /* renamed from: e  reason: collision with root package name */
    public static final iy f41564e = new iy("", (byte) 10, 5);

    /* renamed from: f  reason: collision with root package name */
    public static final iy f41565f = new iy("", (byte) 10, 6);

    /* renamed from: g  reason: collision with root package name */
    public static final iy f41566g = new iy("", (byte) 11, 7);

    /* renamed from: h  reason: collision with root package name */
    public static final iy f41567h = new iy("", (byte) 11, 8);

    /* renamed from: i  reason: collision with root package name */
    public static final iy f41568i = new iy("", (byte) 11, 9);
    public static final iy j = new iy("", (byte) 11, 10);
    public static final iy k = new iy("", (byte) 11, 11);
    public static final iy l = new iy("", StandardMessageCodec.LIST, 12);
    public static final iy m = new iy("", (byte) 11, 13);
    public static final iy n = new iy("", (byte) 2, 14);
    public static final iy o = new iy("", (byte) 11, 15);
    public static final iy p = new iy("", (byte) 10, 16);
    public static final iy q = new iy("", (byte) 11, 20);
    public static final iy r = new iy("", (byte) 11, 21);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(hr hrVar) {
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
        if (hr.class.equals(hrVar.getClass())) {
            int compareTo = Boolean.valueOf(m387a()).compareTo(Boolean.valueOf(hrVar.m387a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m387a() || (a19 = ir.a(this.f519a, hrVar.f519a)) == 0) {
                int compareTo2 = Boolean.valueOf(m389b()).compareTo(Boolean.valueOf(hrVar.m389b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!m389b() || (a18 = ir.a(this.f520a, hrVar.f520a)) == 0) {
                    int compareTo3 = Boolean.valueOf(m390c()).compareTo(Boolean.valueOf(hrVar.m390c()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!m390c() || (a17 = ir.a(this.f524b, hrVar.f524b)) == 0) {
                        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hrVar.d()));
                        if (compareTo4 != 0) {
                            return compareTo4;
                        }
                        if (!d() || (a16 = ir.a(this.f526c, hrVar.f526c)) == 0) {
                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hrVar.e()));
                            if (compareTo5 != 0) {
                                return compareTo5;
                            }
                            if (!e() || (a15 = ir.a(this.f517a, hrVar.f517a)) == 0) {
                                int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hrVar.f()));
                                if (compareTo6 != 0) {
                                    return compareTo6;
                                }
                                if (!f() || (a14 = ir.a(this.f523b, hrVar.f523b)) == 0) {
                                    int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hrVar.g()));
                                    if (compareTo7 != 0) {
                                        return compareTo7;
                                    }
                                    if (!g() || (a13 = ir.a(this.f527d, hrVar.f527d)) == 0) {
                                        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hrVar.h()));
                                        if (compareTo8 != 0) {
                                            return compareTo8;
                                        }
                                        if (!h() || (a12 = ir.a(this.f528e, hrVar.f528e)) == 0) {
                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hrVar.i()));
                                            if (compareTo9 != 0) {
                                                return compareTo9;
                                            }
                                            if (!i() || (a11 = ir.a(this.f529f, hrVar.f529f)) == 0) {
                                                int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(hrVar.j()));
                                                if (compareTo10 != 0) {
                                                    return compareTo10;
                                                }
                                                if (!j() || (a10 = ir.a(this.f530g, hrVar.f530g)) == 0) {
                                                    int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(hrVar.k()));
                                                    if (compareTo11 != 0) {
                                                        return compareTo11;
                                                    }
                                                    if (!k() || (a9 = ir.a(this.f531h, hrVar.f531h)) == 0) {
                                                        int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(hrVar.l()));
                                                        if (compareTo12 != 0) {
                                                            return compareTo12;
                                                        }
                                                        if (!l() || (a8 = ir.a(this.f518a, hrVar.f518a)) == 0) {
                                                            int compareTo13 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(hrVar.m()));
                                                            if (compareTo13 != 0) {
                                                                return compareTo13;
                                                            }
                                                            if (!m() || (a7 = ir.a(this.f532i, hrVar.f532i)) == 0) {
                                                                int compareTo14 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(hrVar.n()));
                                                                if (compareTo14 != 0) {
                                                                    return compareTo14;
                                                                }
                                                                if (!n() || (a6 = ir.a(this.f522a, hrVar.f522a)) == 0) {
                                                                    int compareTo15 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(hrVar.o()));
                                                                    if (compareTo15 != 0) {
                                                                        return compareTo15;
                                                                    }
                                                                    if (!o() || (a5 = ir.a(this.f533j, hrVar.f533j)) == 0) {
                                                                        int compareTo16 = Boolean.valueOf(p()).compareTo(Boolean.valueOf(hrVar.p()));
                                                                        if (compareTo16 != 0) {
                                                                            return compareTo16;
                                                                        }
                                                                        if (!p() || (a4 = ir.a(this.f525c, hrVar.f525c)) == 0) {
                                                                            int compareTo17 = Boolean.valueOf(q()).compareTo(Boolean.valueOf(hrVar.q()));
                                                                            if (compareTo17 != 0) {
                                                                                return compareTo17;
                                                                            }
                                                                            if (!q() || (a3 = ir.a(this.f534k, hrVar.f534k)) == 0) {
                                                                                int compareTo18 = Boolean.valueOf(r()).compareTo(Boolean.valueOf(hrVar.r()));
                                                                                if (compareTo18 != 0) {
                                                                                    return compareTo18;
                                                                                }
                                                                                if (!r() || (a2 = ir.a(this.f535l, hrVar.f535l)) == 0) {
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
        return hr.class.getName().compareTo(hrVar.getClass().getName());
    }

    public long a() {
        return this.f517a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m385a() {
        return this.f520a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m386a() {
        if (this.f520a == null) {
            throw new jc("Required field 'id' was not present! Struct: " + toString());
        } else if (this.f524b == null) {
            throw new jc("Required field 'appId' was not present! Struct: " + toString());
        } else if (this.f526c != null) {
        } else {
            throw new jc("Required field 'payload' was not present! Struct: " + toString());
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.xiaomi.push.iq
    public void a(jb jbVar) {
        jbVar.m510a();
        while (true) {
            iy m506a = jbVar.m506a();
            byte b2 = m506a.f41751a;
            if (b2 == 0) {
                jbVar.f();
                m386a();
                return;
            }
            short s = m506a.f807a;
            if (s == 20) {
                if (b2 == 11) {
                    this.f534k = jbVar.m511a();
                    jbVar.g();
                }
                je.a(jbVar, b2);
                jbVar.g();
            } else if (s != 21) {
                switch (s) {
                    case 1:
                        if (b2 == 12) {
                            hu huVar = new hu();
                            this.f519a = huVar;
                            huVar.a(jbVar);
                            break;
                        }
                        je.a(jbVar, b2);
                        break;
                    case 2:
                        if (b2 == 11) {
                            this.f520a = jbVar.m511a();
                            break;
                        }
                        je.a(jbVar, b2);
                        break;
                    case 3:
                        if (b2 == 11) {
                            this.f524b = jbVar.m511a();
                            break;
                        }
                        je.a(jbVar, b2);
                        break;
                    case 4:
                        if (b2 == 11) {
                            this.f526c = jbVar.m511a();
                            break;
                        }
                        je.a(jbVar, b2);
                        break;
                    case 5:
                        if (b2 == 10) {
                            this.f517a = jbVar.m505a();
                            a(true);
                            break;
                        }
                        je.a(jbVar, b2);
                        break;
                    case 6:
                        if (b2 == 10) {
                            this.f523b = jbVar.m505a();
                            b(true);
                            break;
                        }
                        je.a(jbVar, b2);
                        break;
                    case 7:
                        if (b2 == 11) {
                            this.f527d = jbVar.m511a();
                            break;
                        }
                        je.a(jbVar, b2);
                        break;
                    case 8:
                        if (b2 == 11) {
                            this.f528e = jbVar.m511a();
                            break;
                        }
                        je.a(jbVar, b2);
                        break;
                    case 9:
                        if (b2 == 11) {
                            this.f529f = jbVar.m511a();
                            break;
                        }
                        je.a(jbVar, b2);
                        break;
                    case 10:
                        if (b2 == 11) {
                            this.f530g = jbVar.m511a();
                            break;
                        }
                        je.a(jbVar, b2);
                        break;
                    case 11:
                        if (b2 == 11) {
                            this.f531h = jbVar.m511a();
                            break;
                        }
                        je.a(jbVar, b2);
                        break;
                    case 12:
                        if (b2 == 12) {
                            hs hsVar = new hs();
                            this.f518a = hsVar;
                            hsVar.a(jbVar);
                            break;
                        }
                        je.a(jbVar, b2);
                        break;
                    case 13:
                        if (b2 == 11) {
                            this.f532i = jbVar.m511a();
                            break;
                        }
                        je.a(jbVar, b2);
                        break;
                    case 14:
                        if (b2 == 2) {
                            this.f522a = jbVar.m515a();
                            c(true);
                            break;
                        }
                        je.a(jbVar, b2);
                        break;
                    case 15:
                        if (b2 == 11) {
                            this.f533j = jbVar.m511a();
                            break;
                        }
                        je.a(jbVar, b2);
                        break;
                    case 16:
                        if (b2 == 10) {
                            this.f525c = jbVar.m505a();
                            d(true);
                            break;
                        }
                        je.a(jbVar, b2);
                        break;
                    default:
                        je.a(jbVar, b2);
                        break;
                }
                jbVar.g();
            } else {
                if (b2 == 11) {
                    this.f535l = jbVar.m511a();
                    jbVar.g();
                }
                je.a(jbVar, b2);
                jbVar.g();
            }
        }
    }

    public void a(boolean z) {
        this.f521a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m387a() {
        return this.f519a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m388a(hr hrVar) {
        if (hrVar == null) {
            return false;
        }
        boolean m387a = m387a();
        boolean m387a2 = hrVar.m387a();
        if ((m387a || m387a2) && !(m387a && m387a2 && this.f519a.m405a(hrVar.f519a))) {
            return false;
        }
        boolean m389b = m389b();
        boolean m389b2 = hrVar.m389b();
        if ((m389b || m389b2) && !(m389b && m389b2 && this.f520a.equals(hrVar.f520a))) {
            return false;
        }
        boolean m390c = m390c();
        boolean m390c2 = hrVar.m390c();
        if ((m390c || m390c2) && !(m390c && m390c2 && this.f524b.equals(hrVar.f524b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = hrVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f526c.equals(hrVar.f526c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = hrVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f517a == hrVar.f517a)) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = hrVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f523b == hrVar.f523b)) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = hrVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f527d.equals(hrVar.f527d))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = hrVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f528e.equals(hrVar.f528e))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = hrVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f529f.equals(hrVar.f529f))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = hrVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f530g.equals(hrVar.f530g))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = hrVar.k();
        if ((k2 || k3) && !(k2 && k3 && this.f531h.equals(hrVar.f531h))) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = hrVar.l();
        if ((l2 || l3) && !(l2 && l3 && this.f518a.m397a(hrVar.f518a))) {
            return false;
        }
        boolean m2 = m();
        boolean m3 = hrVar.m();
        if ((m2 || m3) && !(m2 && m3 && this.f532i.equals(hrVar.f532i))) {
            return false;
        }
        boolean n2 = n();
        boolean n3 = hrVar.n();
        if ((n2 || n3) && !(n2 && n3 && this.f522a == hrVar.f522a)) {
            return false;
        }
        boolean o2 = o();
        boolean o3 = hrVar.o();
        if ((o2 || o3) && !(o2 && o3 && this.f533j.equals(hrVar.f533j))) {
            return false;
        }
        boolean p2 = p();
        boolean p3 = hrVar.p();
        if ((p2 || p3) && !(p2 && p3 && this.f525c == hrVar.f525c)) {
            return false;
        }
        boolean q2 = q();
        boolean q3 = hrVar.q();
        if ((q2 || q3) && !(q2 && q3 && this.f534k.equals(hrVar.f534k))) {
            return false;
        }
        boolean r2 = r();
        boolean r3 = hrVar.r();
        if (r2 || r3) {
            return r2 && r3 && this.f535l.equals(hrVar.f535l);
        }
        return true;
    }

    public String b() {
        return this.f524b;
    }

    @Override // com.xiaomi.push.iq
    public void b(jb jbVar) {
        m386a();
        jbVar.a(f516a);
        if (this.f519a != null && m387a()) {
            jbVar.a(f41560a);
            this.f519a.b(jbVar);
            jbVar.b();
        }
        if (this.f520a != null) {
            jbVar.a(f41561b);
            jbVar.a(this.f520a);
            jbVar.b();
        }
        if (this.f524b != null) {
            jbVar.a(f41562c);
            jbVar.a(this.f524b);
            jbVar.b();
        }
        if (this.f526c != null) {
            jbVar.a(f41563d);
            jbVar.a(this.f526c);
            jbVar.b();
        }
        if (e()) {
            jbVar.a(f41564e);
            jbVar.a(this.f517a);
            jbVar.b();
        }
        if (f()) {
            jbVar.a(f41565f);
            jbVar.a(this.f523b);
            jbVar.b();
        }
        if (this.f527d != null && g()) {
            jbVar.a(f41566g);
            jbVar.a(this.f527d);
            jbVar.b();
        }
        if (this.f528e != null && h()) {
            jbVar.a(f41567h);
            jbVar.a(this.f528e);
            jbVar.b();
        }
        if (this.f529f != null && i()) {
            jbVar.a(f41568i);
            jbVar.a(this.f529f);
            jbVar.b();
        }
        if (this.f530g != null && j()) {
            jbVar.a(j);
            jbVar.a(this.f530g);
            jbVar.b();
        }
        if (this.f531h != null && k()) {
            jbVar.a(k);
            jbVar.a(this.f531h);
            jbVar.b();
        }
        if (this.f518a != null && l()) {
            jbVar.a(l);
            this.f518a.b(jbVar);
            jbVar.b();
        }
        if (this.f532i != null && m()) {
            jbVar.a(m);
            jbVar.a(this.f532i);
            jbVar.b();
        }
        if (n()) {
            jbVar.a(n);
            jbVar.a(this.f522a);
            jbVar.b();
        }
        if (this.f533j != null && o()) {
            jbVar.a(o);
            jbVar.a(this.f533j);
            jbVar.b();
        }
        if (p()) {
            jbVar.a(p);
            jbVar.a(this.f525c);
            jbVar.b();
        }
        if (this.f534k != null && q()) {
            jbVar.a(q);
            jbVar.a(this.f534k);
            jbVar.b();
        }
        if (this.f535l != null && r()) {
            jbVar.a(r);
            jbVar.a(this.f535l);
            jbVar.b();
        }
        jbVar.c();
        jbVar.m514a();
    }

    public void b(boolean z) {
        this.f521a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m389b() {
        return this.f520a != null;
    }

    public String c() {
        return this.f526c;
    }

    public void c(boolean z) {
        this.f521a.set(2, z);
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m390c() {
        return this.f524b != null;
    }

    public void d(boolean z) {
        this.f521a.set(3, z);
    }

    public boolean d() {
        return this.f526c != null;
    }

    public boolean e() {
        return this.f521a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hr)) {
            return m388a((hr) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f521a.get(1);
    }

    public boolean g() {
        return this.f527d != null;
    }

    public boolean h() {
        return this.f528e != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f529f != null;
    }

    public boolean j() {
        return this.f530g != null;
    }

    public boolean k() {
        return this.f531h != null;
    }

    public boolean l() {
        return this.f518a != null;
    }

    public boolean m() {
        return this.f532i != null;
    }

    public boolean n() {
        return this.f521a.get(2);
    }

    public boolean o() {
        return this.f533j != null;
    }

    public boolean p() {
        return this.f521a.get(3);
    }

    public boolean q() {
        return this.f534k != null;
    }

    public boolean r() {
        return this.f535l != null;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("PushMessage(");
        if (m387a()) {
            sb.append("to:");
            hu huVar = this.f519a;
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
        String str = this.f520a;
        if (str == null) {
            sb.append(StringUtil.NULL_STRING);
        } else {
            sb.append(str);
        }
        sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        sb.append("appId:");
        String str2 = this.f524b;
        if (str2 == null) {
            sb.append(StringUtil.NULL_STRING);
        } else {
            sb.append(str2);
        }
        sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        sb.append("payload:");
        String str3 = this.f526c;
        if (str3 == null) {
            sb.append(StringUtil.NULL_STRING);
        } else {
            sb.append(str3);
        }
        if (e()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("createAt:");
            sb.append(this.f517a);
        }
        if (f()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("ttl:");
            sb.append(this.f523b);
        }
        if (g()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("collapseKey:");
            String str4 = this.f527d;
            if (str4 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str4);
            }
        }
        if (h()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("packageName:");
            String str5 = this.f528e;
            if (str5 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str5);
            }
        }
        if (i()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("regId:");
            String str6 = this.f529f;
            if (str6 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str6);
            }
        }
        if (j()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("category:");
            String str7 = this.f530g;
            if (str7 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str7);
            }
        }
        if (k()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append(UrlSchemaHelper.SCHEMA_TYPE_TOPIC);
            String str8 = this.f531h;
            if (str8 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str8);
            }
        }
        if (l()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("metaInfo:");
            hs hsVar = this.f518a;
            if (hsVar == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(hsVar);
            }
        }
        if (m()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("aliasName:");
            String str9 = this.f532i;
            if (str9 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str9);
            }
        }
        if (n()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("isOnline:");
            sb.append(this.f522a);
        }
        if (o()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("userAccount:");
            String str10 = this.f533j;
            if (str10 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str10);
            }
        }
        if (p()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("miid:");
            sb.append(this.f525c);
        }
        if (q()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("imeiMd5:");
            String str11 = this.f534k;
            if (str11 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str11);
            }
        }
        if (r()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("deviceId:");
            String str12 = this.f535l;
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
