package com.xiaomi.push;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes10.dex */
public class ht implements is<ht, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f520a;

    /* renamed from: a  reason: collision with other field name */
    public hu f521a;

    /* renamed from: a  reason: collision with other field name */
    public hw f522a;

    /* renamed from: a  reason: collision with other field name */
    public String f523a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f524a = new BitSet(4);

    /* renamed from: a  reason: collision with other field name */
    public boolean f525a = false;

    /* renamed from: b  reason: collision with other field name */
    public long f526b;

    /* renamed from: b  reason: collision with other field name */
    public String f527b;

    /* renamed from: c  reason: collision with other field name */
    public long f528c;

    /* renamed from: c  reason: collision with other field name */
    public String f529c;

    /* renamed from: d  reason: collision with other field name */
    public String f530d;

    /* renamed from: e  reason: collision with other field name */
    public String f531e;

    /* renamed from: f  reason: collision with other field name */
    public String f532f;

    /* renamed from: g  reason: collision with other field name */
    public String f533g;

    /* renamed from: h  reason: collision with other field name */
    public String f534h;

    /* renamed from: i  reason: collision with other field name */
    public String f535i;

    /* renamed from: j  reason: collision with other field name */
    public String f536j;

    /* renamed from: k  reason: collision with other field name */
    public String f537k;

    /* renamed from: l  reason: collision with other field name */
    public String f538l;

    /* renamed from: a  reason: collision with other field name */
    public static final ji f519a = new ji("PushMessage");
    public static final ja a = new ja("", (byte) 12, 1);
    public static final ja b = new ja("", Constants.GZIP_CAST_TYPE, 2);
    public static final ja c = new ja("", Constants.GZIP_CAST_TYPE, 3);
    public static final ja d = new ja("", Constants.GZIP_CAST_TYPE, 4);
    public static final ja e = new ja("", (byte) 10, 5);
    public static final ja f = new ja("", (byte) 10, 6);
    public static final ja g = new ja("", Constants.GZIP_CAST_TYPE, 7);
    public static final ja h = new ja("", Constants.GZIP_CAST_TYPE, 8);
    public static final ja i = new ja("", Constants.GZIP_CAST_TYPE, 9);
    public static final ja j = new ja("", Constants.GZIP_CAST_TYPE, 10);
    public static final ja k = new ja("", Constants.GZIP_CAST_TYPE, 11);
    public static final ja l = new ja("", (byte) 12, 12);
    public static final ja m = new ja("", Constants.GZIP_CAST_TYPE, 13);
    public static final ja n = new ja("", (byte) 2, 14);
    public static final ja o = new ja("", Constants.GZIP_CAST_TYPE, 15);
    public static final ja p = new ja("", (byte) 10, 16);
    public static final ja q = new ja("", Constants.GZIP_CAST_TYPE, 20);
    public static final ja r = new ja("", Constants.GZIP_CAST_TYPE, 21);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(ht htVar) {
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
        if (ht.class.equals(htVar.getClass())) {
            int compareTo = Boolean.valueOf(m578a()).compareTo(Boolean.valueOf(htVar.m578a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m578a() || (a19 = it.a(this.f522a, htVar.f522a)) == 0) {
                int compareTo2 = Boolean.valueOf(m580b()).compareTo(Boolean.valueOf(htVar.m580b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!m580b() || (a18 = it.a(this.f523a, htVar.f523a)) == 0) {
                    int compareTo3 = Boolean.valueOf(m581c()).compareTo(Boolean.valueOf(htVar.m581c()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!m581c() || (a17 = it.a(this.f527b, htVar.f527b)) == 0) {
                        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(htVar.d()));
                        if (compareTo4 != 0) {
                            return compareTo4;
                        }
                        if (!d() || (a16 = it.a(this.f529c, htVar.f529c)) == 0) {
                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(htVar.e()));
                            if (compareTo5 != 0) {
                                return compareTo5;
                            }
                            if (!e() || (a15 = it.a(this.f520a, htVar.f520a)) == 0) {
                                int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(htVar.f()));
                                if (compareTo6 != 0) {
                                    return compareTo6;
                                }
                                if (!f() || (a14 = it.a(this.f526b, htVar.f526b)) == 0) {
                                    int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(htVar.g()));
                                    if (compareTo7 != 0) {
                                        return compareTo7;
                                    }
                                    if (!g() || (a13 = it.a(this.f530d, htVar.f530d)) == 0) {
                                        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(htVar.h()));
                                        if (compareTo8 != 0) {
                                            return compareTo8;
                                        }
                                        if (!h() || (a12 = it.a(this.f531e, htVar.f531e)) == 0) {
                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(htVar.i()));
                                            if (compareTo9 != 0) {
                                                return compareTo9;
                                            }
                                            if (!i() || (a11 = it.a(this.f532f, htVar.f532f)) == 0) {
                                                int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(htVar.j()));
                                                if (compareTo10 != 0) {
                                                    return compareTo10;
                                                }
                                                if (!j() || (a10 = it.a(this.f533g, htVar.f533g)) == 0) {
                                                    int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(htVar.k()));
                                                    if (compareTo11 != 0) {
                                                        return compareTo11;
                                                    }
                                                    if (!k() || (a9 = it.a(this.f534h, htVar.f534h)) == 0) {
                                                        int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(htVar.l()));
                                                        if (compareTo12 != 0) {
                                                            return compareTo12;
                                                        }
                                                        if (!l() || (a8 = it.a(this.f521a, htVar.f521a)) == 0) {
                                                            int compareTo13 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(htVar.m()));
                                                            if (compareTo13 != 0) {
                                                                return compareTo13;
                                                            }
                                                            if (!m() || (a7 = it.a(this.f535i, htVar.f535i)) == 0) {
                                                                int compareTo14 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(htVar.n()));
                                                                if (compareTo14 != 0) {
                                                                    return compareTo14;
                                                                }
                                                                if (!n() || (a6 = it.a(this.f525a, htVar.f525a)) == 0) {
                                                                    int compareTo15 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(htVar.o()));
                                                                    if (compareTo15 != 0) {
                                                                        return compareTo15;
                                                                    }
                                                                    if (!o() || (a5 = it.a(this.f536j, htVar.f536j)) == 0) {
                                                                        int compareTo16 = Boolean.valueOf(p()).compareTo(Boolean.valueOf(htVar.p()));
                                                                        if (compareTo16 != 0) {
                                                                            return compareTo16;
                                                                        }
                                                                        if (!p() || (a4 = it.a(this.f528c, htVar.f528c)) == 0) {
                                                                            int compareTo17 = Boolean.valueOf(q()).compareTo(Boolean.valueOf(htVar.q()));
                                                                            if (compareTo17 != 0) {
                                                                                return compareTo17;
                                                                            }
                                                                            if (!q() || (a3 = it.a(this.f537k, htVar.f537k)) == 0) {
                                                                                int compareTo18 = Boolean.valueOf(r()).compareTo(Boolean.valueOf(htVar.r()));
                                                                                if (compareTo18 != 0) {
                                                                                    return compareTo18;
                                                                                }
                                                                                if (!r() || (a2 = it.a(this.f538l, htVar.f538l)) == 0) {
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
        return ht.class.getName().compareTo(htVar.getClass().getName());
    }

    public long a() {
        return this.f520a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m576a() {
        return this.f523a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m577a() {
        if (this.f523a == null) {
            throw new je("Required field 'id' was not present! Struct: " + toString());
        } else if (this.f527b == null) {
            throw new je("Required field 'appId' was not present! Struct: " + toString());
        } else if (this.f529c != null) {
        } else {
            throw new je("Required field 'payload' was not present! Struct: " + toString());
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.xiaomi.push.is
    public void a(jd jdVar) {
        jdVar.mo700a();
        while (true) {
            ja mo696a = jdVar.mo696a();
            byte b2 = mo696a.a;
            if (b2 == 0) {
                jdVar.f();
                m577a();
                return;
            }
            short s = mo696a.f814a;
            if (s == 20) {
                if (b2 == 11) {
                    this.f537k = jdVar.mo701a();
                    jdVar.g();
                }
                jg.a(jdVar, b2);
                jdVar.g();
            } else if (s != 21) {
                switch (s) {
                    case 1:
                        if (b2 == 12) {
                            hw hwVar = new hw();
                            this.f522a = hwVar;
                            hwVar.a(jdVar);
                            break;
                        }
                        jg.a(jdVar, b2);
                        break;
                    case 2:
                        if (b2 == 11) {
                            this.f523a = jdVar.mo701a();
                            break;
                        }
                        jg.a(jdVar, b2);
                        break;
                    case 3:
                        if (b2 == 11) {
                            this.f527b = jdVar.mo701a();
                            break;
                        }
                        jg.a(jdVar, b2);
                        break;
                    case 4:
                        if (b2 == 11) {
                            this.f529c = jdVar.mo701a();
                            break;
                        }
                        jg.a(jdVar, b2);
                        break;
                    case 5:
                        if (b2 == 10) {
                            this.f520a = jdVar.mo695a();
                            a(true);
                            break;
                        }
                        jg.a(jdVar, b2);
                        break;
                    case 6:
                        if (b2 == 10) {
                            this.f526b = jdVar.mo695a();
                            b(true);
                            break;
                        }
                        jg.a(jdVar, b2);
                        break;
                    case 7:
                        if (b2 == 11) {
                            this.f530d = jdVar.mo701a();
                            break;
                        }
                        jg.a(jdVar, b2);
                        break;
                    case 8:
                        if (b2 == 11) {
                            this.f531e = jdVar.mo701a();
                            break;
                        }
                        jg.a(jdVar, b2);
                        break;
                    case 9:
                        if (b2 == 11) {
                            this.f532f = jdVar.mo701a();
                            break;
                        }
                        jg.a(jdVar, b2);
                        break;
                    case 10:
                        if (b2 == 11) {
                            this.f533g = jdVar.mo701a();
                            break;
                        }
                        jg.a(jdVar, b2);
                        break;
                    case 11:
                        if (b2 == 11) {
                            this.f534h = jdVar.mo701a();
                            break;
                        }
                        jg.a(jdVar, b2);
                        break;
                    case 12:
                        if (b2 == 12) {
                            hu huVar = new hu();
                            this.f521a = huVar;
                            huVar.a(jdVar);
                            break;
                        }
                        jg.a(jdVar, b2);
                        break;
                    case 13:
                        if (b2 == 11) {
                            this.f535i = jdVar.mo701a();
                            break;
                        }
                        jg.a(jdVar, b2);
                        break;
                    case 14:
                        if (b2 == 2) {
                            this.f525a = jdVar.mo706a();
                            c(true);
                            break;
                        }
                        jg.a(jdVar, b2);
                        break;
                    case 15:
                        if (b2 == 11) {
                            this.f536j = jdVar.mo701a();
                            break;
                        }
                        jg.a(jdVar, b2);
                        break;
                    case 16:
                        if (b2 == 10) {
                            this.f528c = jdVar.mo695a();
                            d(true);
                            break;
                        }
                        jg.a(jdVar, b2);
                        break;
                    default:
                        jg.a(jdVar, b2);
                        break;
                }
                jdVar.g();
            } else {
                if (b2 == 11) {
                    this.f538l = jdVar.mo701a();
                    jdVar.g();
                }
                jg.a(jdVar, b2);
                jdVar.g();
            }
        }
    }

    public void a(boolean z) {
        this.f524a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m578a() {
        return this.f522a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m579a(ht htVar) {
        if (htVar == null) {
            return false;
        }
        boolean m578a = m578a();
        boolean m578a2 = htVar.m578a();
        if ((m578a || m578a2) && !(m578a && m578a2 && this.f522a.m596a(htVar.f522a))) {
            return false;
        }
        boolean m580b = m580b();
        boolean m580b2 = htVar.m580b();
        if ((m580b || m580b2) && !(m580b && m580b2 && this.f523a.equals(htVar.f523a))) {
            return false;
        }
        boolean m581c = m581c();
        boolean m581c2 = htVar.m581c();
        if ((m581c || m581c2) && !(m581c && m581c2 && this.f527b.equals(htVar.f527b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = htVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f529c.equals(htVar.f529c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = htVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f520a == htVar.f520a)) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = htVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f526b == htVar.f526b)) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = htVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f530d.equals(htVar.f530d))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = htVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f531e.equals(htVar.f531e))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = htVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f532f.equals(htVar.f532f))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = htVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f533g.equals(htVar.f533g))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = htVar.k();
        if ((k2 || k3) && !(k2 && k3 && this.f534h.equals(htVar.f534h))) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = htVar.l();
        if ((l2 || l3) && !(l2 && l3 && this.f521a.m588a(htVar.f521a))) {
            return false;
        }
        boolean m2 = m();
        boolean m3 = htVar.m();
        if ((m2 || m3) && !(m2 && m3 && this.f535i.equals(htVar.f535i))) {
            return false;
        }
        boolean n2 = n();
        boolean n3 = htVar.n();
        if ((n2 || n3) && !(n2 && n3 && this.f525a == htVar.f525a)) {
            return false;
        }
        boolean o2 = o();
        boolean o3 = htVar.o();
        if ((o2 || o3) && !(o2 && o3 && this.f536j.equals(htVar.f536j))) {
            return false;
        }
        boolean p2 = p();
        boolean p3 = htVar.p();
        if ((p2 || p3) && !(p2 && p3 && this.f528c == htVar.f528c)) {
            return false;
        }
        boolean q2 = q();
        boolean q3 = htVar.q();
        if ((q2 || q3) && !(q2 && q3 && this.f537k.equals(htVar.f537k))) {
            return false;
        }
        boolean r2 = r();
        boolean r3 = htVar.r();
        if (r2 || r3) {
            return r2 && r3 && this.f538l.equals(htVar.f538l);
        }
        return true;
    }

    public String b() {
        return this.f527b;
    }

    @Override // com.xiaomi.push.is
    public void b(jd jdVar) {
        m577a();
        jdVar.a(f519a);
        if (this.f522a != null && m578a()) {
            jdVar.a(a);
            this.f522a.b(jdVar);
            jdVar.b();
        }
        if (this.f523a != null) {
            jdVar.a(b);
            jdVar.a(this.f523a);
            jdVar.b();
        }
        if (this.f527b != null) {
            jdVar.a(c);
            jdVar.a(this.f527b);
            jdVar.b();
        }
        if (this.f529c != null) {
            jdVar.a(d);
            jdVar.a(this.f529c);
            jdVar.b();
        }
        if (e()) {
            jdVar.a(e);
            jdVar.a(this.f520a);
            jdVar.b();
        }
        if (f()) {
            jdVar.a(f);
            jdVar.a(this.f526b);
            jdVar.b();
        }
        if (this.f530d != null && g()) {
            jdVar.a(g);
            jdVar.a(this.f530d);
            jdVar.b();
        }
        if (this.f531e != null && h()) {
            jdVar.a(h);
            jdVar.a(this.f531e);
            jdVar.b();
        }
        if (this.f532f != null && i()) {
            jdVar.a(i);
            jdVar.a(this.f532f);
            jdVar.b();
        }
        if (this.f533g != null && j()) {
            jdVar.a(j);
            jdVar.a(this.f533g);
            jdVar.b();
        }
        if (this.f534h != null && k()) {
            jdVar.a(k);
            jdVar.a(this.f534h);
            jdVar.b();
        }
        if (this.f521a != null && l()) {
            jdVar.a(l);
            this.f521a.b(jdVar);
            jdVar.b();
        }
        if (this.f535i != null && m()) {
            jdVar.a(m);
            jdVar.a(this.f535i);
            jdVar.b();
        }
        if (n()) {
            jdVar.a(n);
            jdVar.a(this.f525a);
            jdVar.b();
        }
        if (this.f536j != null && o()) {
            jdVar.a(o);
            jdVar.a(this.f536j);
            jdVar.b();
        }
        if (p()) {
            jdVar.a(p);
            jdVar.a(this.f528c);
            jdVar.b();
        }
        if (this.f537k != null && q()) {
            jdVar.a(q);
            jdVar.a(this.f537k);
            jdVar.b();
        }
        if (this.f538l != null && r()) {
            jdVar.a(r);
            jdVar.a(this.f538l);
            jdVar.b();
        }
        jdVar.c();
        jdVar.mo704a();
    }

    public void b(boolean z) {
        this.f524a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m580b() {
        return this.f523a != null;
    }

    public String c() {
        return this.f529c;
    }

    public void c(boolean z) {
        this.f524a.set(2, z);
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m581c() {
        return this.f527b != null;
    }

    public void d(boolean z) {
        this.f524a.set(3, z);
    }

    public boolean d() {
        return this.f529c != null;
    }

    public boolean e() {
        return this.f524a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ht)) {
            return m579a((ht) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f524a.get(1);
    }

    public boolean g() {
        return this.f530d != null;
    }

    public boolean h() {
        return this.f531e != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f532f != null;
    }

    public boolean j() {
        return this.f533g != null;
    }

    public boolean k() {
        return this.f534h != null;
    }

    public boolean l() {
        return this.f521a != null;
    }

    public boolean m() {
        return this.f535i != null;
    }

    public boolean n() {
        return this.f524a.get(2);
    }

    public boolean o() {
        return this.f536j != null;
    }

    public boolean p() {
        return this.f524a.get(3);
    }

    public boolean q() {
        return this.f537k != null;
    }

    public boolean r() {
        return this.f538l != null;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("PushMessage(");
        if (m578a()) {
            sb.append("to:");
            hw hwVar = this.f522a;
            if (hwVar == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(hwVar);
            }
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        }
        sb.append("id:");
        String str = this.f523a;
        if (str == null) {
            sb.append(StringUtil.NULL_STRING);
        } else {
            sb.append(str);
        }
        sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        sb.append("appId:");
        String str2 = this.f527b;
        if (str2 == null) {
            sb.append(StringUtil.NULL_STRING);
        } else {
            sb.append(str2);
        }
        sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        sb.append("payload:");
        String str3 = this.f529c;
        if (str3 == null) {
            sb.append(StringUtil.NULL_STRING);
        } else {
            sb.append(str3);
        }
        if (e()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("createAt:");
            sb.append(this.f520a);
        }
        if (f()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("ttl:");
            sb.append(this.f526b);
        }
        if (g()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("collapseKey:");
            String str4 = this.f530d;
            if (str4 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str4);
            }
        }
        if (h()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("packageName:");
            String str5 = this.f531e;
            if (str5 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str5);
            }
        }
        if (i()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("regId:");
            String str6 = this.f532f;
            if (str6 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str6);
            }
        }
        if (j()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("category:");
            String str7 = this.f533g;
            if (str7 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str7);
            }
        }
        if (k()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append(UrlSchemaHelper.SCHEMA_TYPE_TOPIC);
            String str8 = this.f534h;
            if (str8 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str8);
            }
        }
        if (l()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("metaInfo:");
            hu huVar = this.f521a;
            if (huVar == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(huVar);
            }
        }
        if (m()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("aliasName:");
            String str9 = this.f535i;
            if (str9 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str9);
            }
        }
        if (n()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("isOnline:");
            sb.append(this.f525a);
        }
        if (o()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("userAccount:");
            String str10 = this.f536j;
            if (str10 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str10);
            }
        }
        if (p()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("miid:");
            sb.append(this.f528c);
        }
        if (q()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("imeiMd5:");
            String str11 = this.f537k;
            if (str11 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str11);
            }
        }
        if (r()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("deviceId:");
            String str12 = this.f538l;
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
