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
    public long f519a;

    /* renamed from: a  reason: collision with other field name */
    public hu f520a;

    /* renamed from: a  reason: collision with other field name */
    public hw f521a;

    /* renamed from: a  reason: collision with other field name */
    public String f522a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f523a = new BitSet(4);

    /* renamed from: a  reason: collision with other field name */
    public boolean f524a = false;

    /* renamed from: b  reason: collision with other field name */
    public long f525b;

    /* renamed from: b  reason: collision with other field name */
    public String f526b;

    /* renamed from: c  reason: collision with other field name */
    public long f527c;

    /* renamed from: c  reason: collision with other field name */
    public String f528c;

    /* renamed from: d  reason: collision with other field name */
    public String f529d;

    /* renamed from: e  reason: collision with other field name */
    public String f530e;

    /* renamed from: f  reason: collision with other field name */
    public String f531f;

    /* renamed from: g  reason: collision with other field name */
    public String f532g;

    /* renamed from: h  reason: collision with other field name */
    public String f533h;

    /* renamed from: i  reason: collision with other field name */
    public String f534i;

    /* renamed from: j  reason: collision with other field name */
    public String f535j;

    /* renamed from: k  reason: collision with other field name */
    public String f536k;

    /* renamed from: l  reason: collision with other field name */
    public String f537l;

    /* renamed from: a  reason: collision with other field name */
    public static final ji f518a = new ji("PushMessage");
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
            int compareTo = Boolean.valueOf(m518a()).compareTo(Boolean.valueOf(htVar.m518a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m518a() || (a19 = it.a(this.f521a, htVar.f521a)) == 0) {
                int compareTo2 = Boolean.valueOf(m520b()).compareTo(Boolean.valueOf(htVar.m520b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!m520b() || (a18 = it.a(this.f522a, htVar.f522a)) == 0) {
                    int compareTo3 = Boolean.valueOf(m521c()).compareTo(Boolean.valueOf(htVar.m521c()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!m521c() || (a17 = it.a(this.f526b, htVar.f526b)) == 0) {
                        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(htVar.d()));
                        if (compareTo4 != 0) {
                            return compareTo4;
                        }
                        if (!d() || (a16 = it.a(this.f528c, htVar.f528c)) == 0) {
                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(htVar.e()));
                            if (compareTo5 != 0) {
                                return compareTo5;
                            }
                            if (!e() || (a15 = it.a(this.f519a, htVar.f519a)) == 0) {
                                int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(htVar.f()));
                                if (compareTo6 != 0) {
                                    return compareTo6;
                                }
                                if (!f() || (a14 = it.a(this.f525b, htVar.f525b)) == 0) {
                                    int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(htVar.g()));
                                    if (compareTo7 != 0) {
                                        return compareTo7;
                                    }
                                    if (!g() || (a13 = it.a(this.f529d, htVar.f529d)) == 0) {
                                        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(htVar.h()));
                                        if (compareTo8 != 0) {
                                            return compareTo8;
                                        }
                                        if (!h() || (a12 = it.a(this.f530e, htVar.f530e)) == 0) {
                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(htVar.i()));
                                            if (compareTo9 != 0) {
                                                return compareTo9;
                                            }
                                            if (!i() || (a11 = it.a(this.f531f, htVar.f531f)) == 0) {
                                                int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(htVar.j()));
                                                if (compareTo10 != 0) {
                                                    return compareTo10;
                                                }
                                                if (!j() || (a10 = it.a(this.f532g, htVar.f532g)) == 0) {
                                                    int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(htVar.k()));
                                                    if (compareTo11 != 0) {
                                                        return compareTo11;
                                                    }
                                                    if (!k() || (a9 = it.a(this.f533h, htVar.f533h)) == 0) {
                                                        int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(htVar.l()));
                                                        if (compareTo12 != 0) {
                                                            return compareTo12;
                                                        }
                                                        if (!l() || (a8 = it.a(this.f520a, htVar.f520a)) == 0) {
                                                            int compareTo13 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(htVar.m()));
                                                            if (compareTo13 != 0) {
                                                                return compareTo13;
                                                            }
                                                            if (!m() || (a7 = it.a(this.f534i, htVar.f534i)) == 0) {
                                                                int compareTo14 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(htVar.n()));
                                                                if (compareTo14 != 0) {
                                                                    return compareTo14;
                                                                }
                                                                if (!n() || (a6 = it.a(this.f524a, htVar.f524a)) == 0) {
                                                                    int compareTo15 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(htVar.o()));
                                                                    if (compareTo15 != 0) {
                                                                        return compareTo15;
                                                                    }
                                                                    if (!o() || (a5 = it.a(this.f535j, htVar.f535j)) == 0) {
                                                                        int compareTo16 = Boolean.valueOf(p()).compareTo(Boolean.valueOf(htVar.p()));
                                                                        if (compareTo16 != 0) {
                                                                            return compareTo16;
                                                                        }
                                                                        if (!p() || (a4 = it.a(this.f527c, htVar.f527c)) == 0) {
                                                                            int compareTo17 = Boolean.valueOf(q()).compareTo(Boolean.valueOf(htVar.q()));
                                                                            if (compareTo17 != 0) {
                                                                                return compareTo17;
                                                                            }
                                                                            if (!q() || (a3 = it.a(this.f536k, htVar.f536k)) == 0) {
                                                                                int compareTo18 = Boolean.valueOf(r()).compareTo(Boolean.valueOf(htVar.r()));
                                                                                if (compareTo18 != 0) {
                                                                                    return compareTo18;
                                                                                }
                                                                                if (!r() || (a2 = it.a(this.f537l, htVar.f537l)) == 0) {
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
        return this.f519a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m516a() {
        return this.f522a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m517a() {
        if (this.f522a == null) {
            throw new je("Required field 'id' was not present! Struct: " + toString());
        } else if (this.f526b == null) {
            throw new je("Required field 'appId' was not present! Struct: " + toString());
        } else if (this.f528c != null) {
        } else {
            throw new je("Required field 'payload' was not present! Struct: " + toString());
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.xiaomi.push.is
    public void a(jd jdVar) {
        jdVar.mo640a();
        while (true) {
            ja mo636a = jdVar.mo636a();
            byte b2 = mo636a.a;
            if (b2 == 0) {
                jdVar.f();
                m517a();
                return;
            }
            short s = mo636a.f813a;
            if (s == 20) {
                if (b2 == 11) {
                    this.f536k = jdVar.mo641a();
                    jdVar.g();
                }
                jg.a(jdVar, b2);
                jdVar.g();
            } else if (s != 21) {
                switch (s) {
                    case 1:
                        if (b2 == 12) {
                            hw hwVar = new hw();
                            this.f521a = hwVar;
                            hwVar.a(jdVar);
                            break;
                        }
                        jg.a(jdVar, b2);
                        break;
                    case 2:
                        if (b2 == 11) {
                            this.f522a = jdVar.mo641a();
                            break;
                        }
                        jg.a(jdVar, b2);
                        break;
                    case 3:
                        if (b2 == 11) {
                            this.f526b = jdVar.mo641a();
                            break;
                        }
                        jg.a(jdVar, b2);
                        break;
                    case 4:
                        if (b2 == 11) {
                            this.f528c = jdVar.mo641a();
                            break;
                        }
                        jg.a(jdVar, b2);
                        break;
                    case 5:
                        if (b2 == 10) {
                            this.f519a = jdVar.mo635a();
                            a(true);
                            break;
                        }
                        jg.a(jdVar, b2);
                        break;
                    case 6:
                        if (b2 == 10) {
                            this.f525b = jdVar.mo635a();
                            b(true);
                            break;
                        }
                        jg.a(jdVar, b2);
                        break;
                    case 7:
                        if (b2 == 11) {
                            this.f529d = jdVar.mo641a();
                            break;
                        }
                        jg.a(jdVar, b2);
                        break;
                    case 8:
                        if (b2 == 11) {
                            this.f530e = jdVar.mo641a();
                            break;
                        }
                        jg.a(jdVar, b2);
                        break;
                    case 9:
                        if (b2 == 11) {
                            this.f531f = jdVar.mo641a();
                            break;
                        }
                        jg.a(jdVar, b2);
                        break;
                    case 10:
                        if (b2 == 11) {
                            this.f532g = jdVar.mo641a();
                            break;
                        }
                        jg.a(jdVar, b2);
                        break;
                    case 11:
                        if (b2 == 11) {
                            this.f533h = jdVar.mo641a();
                            break;
                        }
                        jg.a(jdVar, b2);
                        break;
                    case 12:
                        if (b2 == 12) {
                            hu huVar = new hu();
                            this.f520a = huVar;
                            huVar.a(jdVar);
                            break;
                        }
                        jg.a(jdVar, b2);
                        break;
                    case 13:
                        if (b2 == 11) {
                            this.f534i = jdVar.mo641a();
                            break;
                        }
                        jg.a(jdVar, b2);
                        break;
                    case 14:
                        if (b2 == 2) {
                            this.f524a = jdVar.mo646a();
                            c(true);
                            break;
                        }
                        jg.a(jdVar, b2);
                        break;
                    case 15:
                        if (b2 == 11) {
                            this.f535j = jdVar.mo641a();
                            break;
                        }
                        jg.a(jdVar, b2);
                        break;
                    case 16:
                        if (b2 == 10) {
                            this.f527c = jdVar.mo635a();
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
                    this.f537l = jdVar.mo641a();
                    jdVar.g();
                }
                jg.a(jdVar, b2);
                jdVar.g();
            }
        }
    }

    public void a(boolean z) {
        this.f523a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m518a() {
        return this.f521a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m519a(ht htVar) {
        if (htVar == null) {
            return false;
        }
        boolean m518a = m518a();
        boolean m518a2 = htVar.m518a();
        if ((m518a || m518a2) && !(m518a && m518a2 && this.f521a.m536a(htVar.f521a))) {
            return false;
        }
        boolean m520b = m520b();
        boolean m520b2 = htVar.m520b();
        if ((m520b || m520b2) && !(m520b && m520b2 && this.f522a.equals(htVar.f522a))) {
            return false;
        }
        boolean m521c = m521c();
        boolean m521c2 = htVar.m521c();
        if ((m521c || m521c2) && !(m521c && m521c2 && this.f526b.equals(htVar.f526b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = htVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f528c.equals(htVar.f528c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = htVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f519a == htVar.f519a)) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = htVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f525b == htVar.f525b)) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = htVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f529d.equals(htVar.f529d))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = htVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f530e.equals(htVar.f530e))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = htVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f531f.equals(htVar.f531f))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = htVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f532g.equals(htVar.f532g))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = htVar.k();
        if ((k2 || k3) && !(k2 && k3 && this.f533h.equals(htVar.f533h))) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = htVar.l();
        if ((l2 || l3) && !(l2 && l3 && this.f520a.m528a(htVar.f520a))) {
            return false;
        }
        boolean m2 = m();
        boolean m3 = htVar.m();
        if ((m2 || m3) && !(m2 && m3 && this.f534i.equals(htVar.f534i))) {
            return false;
        }
        boolean n2 = n();
        boolean n3 = htVar.n();
        if ((n2 || n3) && !(n2 && n3 && this.f524a == htVar.f524a)) {
            return false;
        }
        boolean o2 = o();
        boolean o3 = htVar.o();
        if ((o2 || o3) && !(o2 && o3 && this.f535j.equals(htVar.f535j))) {
            return false;
        }
        boolean p2 = p();
        boolean p3 = htVar.p();
        if ((p2 || p3) && !(p2 && p3 && this.f527c == htVar.f527c)) {
            return false;
        }
        boolean q2 = q();
        boolean q3 = htVar.q();
        if ((q2 || q3) && !(q2 && q3 && this.f536k.equals(htVar.f536k))) {
            return false;
        }
        boolean r2 = r();
        boolean r3 = htVar.r();
        if (r2 || r3) {
            return r2 && r3 && this.f537l.equals(htVar.f537l);
        }
        return true;
    }

    public String b() {
        return this.f526b;
    }

    @Override // com.xiaomi.push.is
    public void b(jd jdVar) {
        m517a();
        jdVar.a(f518a);
        if (this.f521a != null && m518a()) {
            jdVar.a(a);
            this.f521a.b(jdVar);
            jdVar.b();
        }
        if (this.f522a != null) {
            jdVar.a(b);
            jdVar.a(this.f522a);
            jdVar.b();
        }
        if (this.f526b != null) {
            jdVar.a(c);
            jdVar.a(this.f526b);
            jdVar.b();
        }
        if (this.f528c != null) {
            jdVar.a(d);
            jdVar.a(this.f528c);
            jdVar.b();
        }
        if (e()) {
            jdVar.a(e);
            jdVar.a(this.f519a);
            jdVar.b();
        }
        if (f()) {
            jdVar.a(f);
            jdVar.a(this.f525b);
            jdVar.b();
        }
        if (this.f529d != null && g()) {
            jdVar.a(g);
            jdVar.a(this.f529d);
            jdVar.b();
        }
        if (this.f530e != null && h()) {
            jdVar.a(h);
            jdVar.a(this.f530e);
            jdVar.b();
        }
        if (this.f531f != null && i()) {
            jdVar.a(i);
            jdVar.a(this.f531f);
            jdVar.b();
        }
        if (this.f532g != null && j()) {
            jdVar.a(j);
            jdVar.a(this.f532g);
            jdVar.b();
        }
        if (this.f533h != null && k()) {
            jdVar.a(k);
            jdVar.a(this.f533h);
            jdVar.b();
        }
        if (this.f520a != null && l()) {
            jdVar.a(l);
            this.f520a.b(jdVar);
            jdVar.b();
        }
        if (this.f534i != null && m()) {
            jdVar.a(m);
            jdVar.a(this.f534i);
            jdVar.b();
        }
        if (n()) {
            jdVar.a(n);
            jdVar.a(this.f524a);
            jdVar.b();
        }
        if (this.f535j != null && o()) {
            jdVar.a(o);
            jdVar.a(this.f535j);
            jdVar.b();
        }
        if (p()) {
            jdVar.a(p);
            jdVar.a(this.f527c);
            jdVar.b();
        }
        if (this.f536k != null && q()) {
            jdVar.a(q);
            jdVar.a(this.f536k);
            jdVar.b();
        }
        if (this.f537l != null && r()) {
            jdVar.a(r);
            jdVar.a(this.f537l);
            jdVar.b();
        }
        jdVar.c();
        jdVar.mo644a();
    }

    public void b(boolean z) {
        this.f523a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m520b() {
        return this.f522a != null;
    }

    public String c() {
        return this.f528c;
    }

    public void c(boolean z) {
        this.f523a.set(2, z);
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m521c() {
        return this.f526b != null;
    }

    public void d(boolean z) {
        this.f523a.set(3, z);
    }

    public boolean d() {
        return this.f528c != null;
    }

    public boolean e() {
        return this.f523a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ht)) {
            return m519a((ht) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f523a.get(1);
    }

    public boolean g() {
        return this.f529d != null;
    }

    public boolean h() {
        return this.f530e != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f531f != null;
    }

    public boolean j() {
        return this.f532g != null;
    }

    public boolean k() {
        return this.f533h != null;
    }

    public boolean l() {
        return this.f520a != null;
    }

    public boolean m() {
        return this.f534i != null;
    }

    public boolean n() {
        return this.f523a.get(2);
    }

    public boolean o() {
        return this.f535j != null;
    }

    public boolean p() {
        return this.f523a.get(3);
    }

    public boolean q() {
        return this.f536k != null;
    }

    public boolean r() {
        return this.f537l != null;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("PushMessage(");
        if (m518a()) {
            sb.append("to:");
            hw hwVar = this.f521a;
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
        String str = this.f522a;
        if (str == null) {
            sb.append(StringUtil.NULL_STRING);
        } else {
            sb.append(str);
        }
        sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        sb.append("appId:");
        String str2 = this.f526b;
        if (str2 == null) {
            sb.append(StringUtil.NULL_STRING);
        } else {
            sb.append(str2);
        }
        sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        sb.append("payload:");
        String str3 = this.f528c;
        if (str3 == null) {
            sb.append(StringUtil.NULL_STRING);
        } else {
            sb.append(str3);
        }
        if (e()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("createAt:");
            sb.append(this.f519a);
        }
        if (f()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("ttl:");
            sb.append(this.f525b);
        }
        if (g()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("collapseKey:");
            String str4 = this.f529d;
            if (str4 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str4);
            }
        }
        if (h()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("packageName:");
            String str5 = this.f530e;
            if (str5 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str5);
            }
        }
        if (i()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("regId:");
            String str6 = this.f531f;
            if (str6 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str6);
            }
        }
        if (j()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("category:");
            String str7 = this.f532g;
            if (str7 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str7);
            }
        }
        if (k()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append(UrlSchemaHelper.SCHEMA_TYPE_TOPIC);
            String str8 = this.f533h;
            if (str8 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str8);
            }
        }
        if (l()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("metaInfo:");
            hu huVar = this.f520a;
            if (huVar == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(huVar);
            }
        }
        if (m()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("aliasName:");
            String str9 = this.f534i;
            if (str9 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str9);
            }
        }
        if (n()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("isOnline:");
            sb.append(this.f524a);
        }
        if (o()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("userAccount:");
            String str10 = this.f535j;
            if (str10 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str10);
            }
        }
        if (p()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("miid:");
            sb.append(this.f527c);
        }
        if (q()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("imeiMd5:");
            String str11 = this.f536k;
            if (str11 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str11);
            }
        }
        if (r()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("deviceId:");
            String str12 = this.f537l;
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
