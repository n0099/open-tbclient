package com.xiaomi.push;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
/* loaded from: classes10.dex */
public class ii implements is<ii, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public int f689a;

    /* renamed from: a  reason: collision with other field name */
    public long f690a;

    /* renamed from: a  reason: collision with other field name */
    public hw f691a;

    /* renamed from: a  reason: collision with other field name */
    public String f692a;

    /* renamed from: a  reason: collision with other field name */
    public List<String> f694a;

    /* renamed from: b  reason: collision with other field name */
    public int f696b;

    /* renamed from: b  reason: collision with other field name */
    public long f697b;

    /* renamed from: b  reason: collision with other field name */
    public String f698b;

    /* renamed from: c  reason: collision with other field name */
    public long f699c;

    /* renamed from: c  reason: collision with other field name */
    public String f700c;

    /* renamed from: d  reason: collision with other field name */
    public String f701d;

    /* renamed from: e  reason: collision with other field name */
    public String f702e;

    /* renamed from: f  reason: collision with other field name */
    public String f703f;

    /* renamed from: g  reason: collision with other field name */
    public String f704g;

    /* renamed from: h  reason: collision with other field name */
    public String f705h;

    /* renamed from: i  reason: collision with other field name */
    public String f706i;

    /* renamed from: j  reason: collision with other field name */
    public String f707j;

    /* renamed from: k  reason: collision with other field name */
    public String f708k;

    /* renamed from: l  reason: collision with other field name */
    public String f709l;

    /* renamed from: a  reason: collision with other field name */
    public static final ji f688a = new ji("XmPushActionRegistrationResult");
    public static final ja a = new ja("", Constants.GZIP_CAST_TYPE, 1);
    public static final ja b = new ja("", (byte) 12, 2);
    public static final ja c = new ja("", Constants.GZIP_CAST_TYPE, 3);
    public static final ja d = new ja("", Constants.GZIP_CAST_TYPE, 4);
    public static final ja e = new ja("", (byte) 10, 6);
    public static final ja f = new ja("", Constants.GZIP_CAST_TYPE, 7);
    public static final ja g = new ja("", Constants.GZIP_CAST_TYPE, 8);
    public static final ja h = new ja("", Constants.GZIP_CAST_TYPE, 9);
    public static final ja i = new ja("", Constants.GZIP_CAST_TYPE, 10);
    public static final ja j = new ja("", (byte) 10, 11);
    public static final ja k = new ja("", Constants.GZIP_CAST_TYPE, 12);
    public static final ja l = new ja("", Constants.GZIP_CAST_TYPE, 13);
    public static final ja m = new ja("", (byte) 10, 14);
    public static final ja n = new ja("", Constants.GZIP_CAST_TYPE, 15);
    public static final ja o = new ja("", (byte) 8, 16);
    public static final ja p = new ja("", Constants.GZIP_CAST_TYPE, 17);
    public static final ja q = new ja("", (byte) 8, 18);
    public static final ja r = new ja("", Constants.GZIP_CAST_TYPE, 19);
    public static final ja s = new ja("", (byte) 2, 20);
    public static final ja t = new ja("", (byte) 15, 21);

    /* renamed from: a  reason: collision with other field name */
    public BitSet f693a = new BitSet(6);

    /* renamed from: a  reason: collision with other field name */
    public boolean f695a = false;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(ii iiVar) {
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
        int a20;
        int a21;
        if (ii.class.equals(iiVar.getClass())) {
            int compareTo = Boolean.valueOf(m666a()).compareTo(Boolean.valueOf(iiVar.m666a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m666a() || (a21 = it.a(this.f692a, iiVar.f692a)) == 0) {
                int compareTo2 = Boolean.valueOf(m668b()).compareTo(Boolean.valueOf(iiVar.m668b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!m668b() || (a20 = it.a(this.f691a, iiVar.f691a)) == 0) {
                    int compareTo3 = Boolean.valueOf(m669c()).compareTo(Boolean.valueOf(iiVar.m669c()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!m669c() || (a19 = it.a(this.f698b, iiVar.f698b)) == 0) {
                        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(iiVar.d()));
                        if (compareTo4 != 0) {
                            return compareTo4;
                        }
                        if (!d() || (a18 = it.a(this.f700c, iiVar.f700c)) == 0) {
                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(iiVar.e()));
                            if (compareTo5 != 0) {
                                return compareTo5;
                            }
                            if (!e() || (a17 = it.a(this.f690a, iiVar.f690a)) == 0) {
                                int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(iiVar.f()));
                                if (compareTo6 != 0) {
                                    return compareTo6;
                                }
                                if (!f() || (a16 = it.a(this.f701d, iiVar.f701d)) == 0) {
                                    int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(iiVar.g()));
                                    if (compareTo7 != 0) {
                                        return compareTo7;
                                    }
                                    if (!g() || (a15 = it.a(this.f702e, iiVar.f702e)) == 0) {
                                        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(iiVar.h()));
                                        if (compareTo8 != 0) {
                                            return compareTo8;
                                        }
                                        if (!h() || (a14 = it.a(this.f703f, iiVar.f703f)) == 0) {
                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(iiVar.i()));
                                            if (compareTo9 != 0) {
                                                return compareTo9;
                                            }
                                            if (!i() || (a13 = it.a(this.f704g, iiVar.f704g)) == 0) {
                                                int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(iiVar.j()));
                                                if (compareTo10 != 0) {
                                                    return compareTo10;
                                                }
                                                if (!j() || (a12 = it.a(this.f697b, iiVar.f697b)) == 0) {
                                                    int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(iiVar.k()));
                                                    if (compareTo11 != 0) {
                                                        return compareTo11;
                                                    }
                                                    if (!k() || (a11 = it.a(this.f705h, iiVar.f705h)) == 0) {
                                                        int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(iiVar.l()));
                                                        if (compareTo12 != 0) {
                                                            return compareTo12;
                                                        }
                                                        if (!l() || (a10 = it.a(this.f706i, iiVar.f706i)) == 0) {
                                                            int compareTo13 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(iiVar.m()));
                                                            if (compareTo13 != 0) {
                                                                return compareTo13;
                                                            }
                                                            if (!m() || (a9 = it.a(this.f699c, iiVar.f699c)) == 0) {
                                                                int compareTo14 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(iiVar.n()));
                                                                if (compareTo14 != 0) {
                                                                    return compareTo14;
                                                                }
                                                                if (!n() || (a8 = it.a(this.f707j, iiVar.f707j)) == 0) {
                                                                    int compareTo15 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(iiVar.o()));
                                                                    if (compareTo15 != 0) {
                                                                        return compareTo15;
                                                                    }
                                                                    if (!o() || (a7 = it.a(this.f689a, iiVar.f689a)) == 0) {
                                                                        int compareTo16 = Boolean.valueOf(p()).compareTo(Boolean.valueOf(iiVar.p()));
                                                                        if (compareTo16 != 0) {
                                                                            return compareTo16;
                                                                        }
                                                                        if (!p() || (a6 = it.a(this.f708k, iiVar.f708k)) == 0) {
                                                                            int compareTo17 = Boolean.valueOf(q()).compareTo(Boolean.valueOf(iiVar.q()));
                                                                            if (compareTo17 != 0) {
                                                                                return compareTo17;
                                                                            }
                                                                            if (!q() || (a5 = it.a(this.f696b, iiVar.f696b)) == 0) {
                                                                                int compareTo18 = Boolean.valueOf(r()).compareTo(Boolean.valueOf(iiVar.r()));
                                                                                if (compareTo18 != 0) {
                                                                                    return compareTo18;
                                                                                }
                                                                                if (!r() || (a4 = it.a(this.f709l, iiVar.f709l)) == 0) {
                                                                                    int compareTo19 = Boolean.valueOf(s()).compareTo(Boolean.valueOf(iiVar.s()));
                                                                                    if (compareTo19 != 0) {
                                                                                        return compareTo19;
                                                                                    }
                                                                                    if (!s() || (a3 = it.a(this.f695a, iiVar.f695a)) == 0) {
                                                                                        int compareTo20 = Boolean.valueOf(t()).compareTo(Boolean.valueOf(iiVar.t()));
                                                                                        if (compareTo20 != 0) {
                                                                                            return compareTo20;
                                                                                        }
                                                                                        if (!t() || (a2 = it.a(this.f694a, iiVar.f694a)) == 0) {
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
                return a20;
            }
            return a21;
        }
        return ii.class.getName().compareTo(iiVar.getClass().getName());
    }

    public long a() {
        return this.f690a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m663a() {
        return this.f698b;
    }

    /* renamed from: a  reason: collision with other method in class */
    public List<String> m664a() {
        return this.f694a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m665a() {
        if (this.f698b == null) {
            throw new je("Required field 'id' was not present! Struct: " + toString());
        } else if (this.f700c != null) {
        } else {
            throw new je("Required field 'appId' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.is
    public void a(jd jdVar) {
        jdVar.mo710a();
        while (true) {
            ja mo706a = jdVar.mo706a();
            byte b2 = mo706a.a;
            if (b2 == 0) {
                jdVar.f();
                if (e()) {
                    m665a();
                    return;
                }
                throw new je("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
            }
            switch (mo706a.f809a) {
                case 1:
                    if (b2 == 11) {
                        this.f692a = jdVar.mo711a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 2:
                    if (b2 == 12) {
                        hw hwVar = new hw();
                        this.f691a = hwVar;
                        hwVar.a(jdVar);
                        continue;
                        jdVar.g();
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f698b = jdVar.mo711a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f700c = jdVar.mo711a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 6:
                    if (b2 == 10) {
                        this.f690a = jdVar.mo705a();
                        a(true);
                        continue;
                        jdVar.g();
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f701d = jdVar.mo711a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 8:
                    if (b2 == 11) {
                        this.f702e = jdVar.mo711a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 9:
                    if (b2 == 11) {
                        this.f703f = jdVar.mo711a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 10:
                    if (b2 == 11) {
                        this.f704g = jdVar.mo711a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 11:
                    if (b2 == 10) {
                        this.f697b = jdVar.mo705a();
                        b(true);
                        continue;
                        jdVar.g();
                    }
                    break;
                case 12:
                    if (b2 == 11) {
                        this.f705h = jdVar.mo711a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 13:
                    if (b2 == 11) {
                        this.f706i = jdVar.mo711a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 14:
                    if (b2 == 10) {
                        this.f699c = jdVar.mo705a();
                        c(true);
                        continue;
                        jdVar.g();
                    }
                    break;
                case 15:
                    if (b2 == 11) {
                        this.f707j = jdVar.mo711a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 16:
                    if (b2 == 8) {
                        this.f689a = jdVar.mo704a();
                        d(true);
                        continue;
                        jdVar.g();
                    }
                    break;
                case 17:
                    if (b2 == 11) {
                        this.f708k = jdVar.mo711a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 18:
                    if (b2 == 8) {
                        this.f696b = jdVar.mo704a();
                        e(true);
                        continue;
                        jdVar.g();
                    }
                    break;
                case 19:
                    if (b2 == 11) {
                        this.f709l = jdVar.mo711a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 20:
                    if (b2 == 2) {
                        this.f695a = jdVar.mo716a();
                        f(true);
                        continue;
                        jdVar.g();
                    }
                    break;
                case 21:
                    if (b2 == 15) {
                        jb mo707a = jdVar.mo707a();
                        this.f694a = new ArrayList(mo707a.f810a);
                        for (int i2 = 0; i2 < mo707a.f810a; i2++) {
                            this.f694a.add(jdVar.mo711a());
                        }
                        jdVar.i();
                        continue;
                        jdVar.g();
                    }
                    break;
            }
            jg.a(jdVar, b2);
            jdVar.g();
        }
    }

    public void a(boolean z) {
        this.f693a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m666a() {
        return this.f692a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m667a(ii iiVar) {
        if (iiVar == null) {
            return false;
        }
        boolean m666a = m666a();
        boolean m666a2 = iiVar.m666a();
        if ((m666a || m666a2) && !(m666a && m666a2 && this.f692a.equals(iiVar.f692a))) {
            return false;
        }
        boolean m668b = m668b();
        boolean m668b2 = iiVar.m668b();
        if ((m668b || m668b2) && !(m668b && m668b2 && this.f691a.m606a(iiVar.f691a))) {
            return false;
        }
        boolean m669c = m669c();
        boolean m669c2 = iiVar.m669c();
        if ((m669c || m669c2) && !(m669c && m669c2 && this.f698b.equals(iiVar.f698b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = iiVar.d();
        if (((d2 || d3) && !(d2 && d3 && this.f700c.equals(iiVar.f700c))) || this.f690a != iiVar.f690a) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = iiVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f701d.equals(iiVar.f701d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = iiVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f702e.equals(iiVar.f702e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = iiVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f703f.equals(iiVar.f703f))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = iiVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f704g.equals(iiVar.f704g))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = iiVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f697b == iiVar.f697b)) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = iiVar.k();
        if ((k2 || k3) && !(k2 && k3 && this.f705h.equals(iiVar.f705h))) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = iiVar.l();
        if ((l2 || l3) && !(l2 && l3 && this.f706i.equals(iiVar.f706i))) {
            return false;
        }
        boolean m2 = m();
        boolean m3 = iiVar.m();
        if ((m2 || m3) && !(m2 && m3 && this.f699c == iiVar.f699c)) {
            return false;
        }
        boolean n2 = n();
        boolean n3 = iiVar.n();
        if ((n2 || n3) && !(n2 && n3 && this.f707j.equals(iiVar.f707j))) {
            return false;
        }
        boolean o2 = o();
        boolean o3 = iiVar.o();
        if ((o2 || o3) && !(o2 && o3 && this.f689a == iiVar.f689a)) {
            return false;
        }
        boolean p2 = p();
        boolean p3 = iiVar.p();
        if ((p2 || p3) && !(p2 && p3 && this.f708k.equals(iiVar.f708k))) {
            return false;
        }
        boolean q2 = q();
        boolean q3 = iiVar.q();
        if ((q2 || q3) && !(q2 && q3 && this.f696b == iiVar.f696b)) {
            return false;
        }
        boolean r2 = r();
        boolean r3 = iiVar.r();
        if ((r2 || r3) && !(r2 && r3 && this.f709l.equals(iiVar.f709l))) {
            return false;
        }
        boolean s2 = s();
        boolean s3 = iiVar.s();
        if ((s2 || s3) && !(s2 && s3 && this.f695a == iiVar.f695a)) {
            return false;
        }
        boolean t2 = t();
        boolean t3 = iiVar.t();
        if (t2 || t3) {
            return t2 && t3 && this.f694a.equals(iiVar.f694a);
        }
        return true;
    }

    public String b() {
        return this.f703f;
    }

    @Override // com.xiaomi.push.is
    public void b(jd jdVar) {
        m665a();
        jdVar.a(f688a);
        if (this.f692a != null && m666a()) {
            jdVar.a(a);
            jdVar.a(this.f692a);
            jdVar.b();
        }
        if (this.f691a != null && m668b()) {
            jdVar.a(b);
            this.f691a.b(jdVar);
            jdVar.b();
        }
        if (this.f698b != null) {
            jdVar.a(c);
            jdVar.a(this.f698b);
            jdVar.b();
        }
        if (this.f700c != null) {
            jdVar.a(d);
            jdVar.a(this.f700c);
            jdVar.b();
        }
        jdVar.a(e);
        jdVar.a(this.f690a);
        jdVar.b();
        if (this.f701d != null && f()) {
            jdVar.a(f);
            jdVar.a(this.f701d);
            jdVar.b();
        }
        if (this.f702e != null && g()) {
            jdVar.a(g);
            jdVar.a(this.f702e);
            jdVar.b();
        }
        if (this.f703f != null && h()) {
            jdVar.a(h);
            jdVar.a(this.f703f);
            jdVar.b();
        }
        if (this.f704g != null && i()) {
            jdVar.a(i);
            jdVar.a(this.f704g);
            jdVar.b();
        }
        if (j()) {
            jdVar.a(j);
            jdVar.a(this.f697b);
            jdVar.b();
        }
        if (this.f705h != null && k()) {
            jdVar.a(k);
            jdVar.a(this.f705h);
            jdVar.b();
        }
        if (this.f706i != null && l()) {
            jdVar.a(l);
            jdVar.a(this.f706i);
            jdVar.b();
        }
        if (m()) {
            jdVar.a(m);
            jdVar.a(this.f699c);
            jdVar.b();
        }
        if (this.f707j != null && n()) {
            jdVar.a(n);
            jdVar.a(this.f707j);
            jdVar.b();
        }
        if (o()) {
            jdVar.a(o);
            jdVar.mo715a(this.f689a);
            jdVar.b();
        }
        if (this.f708k != null && p()) {
            jdVar.a(p);
            jdVar.a(this.f708k);
            jdVar.b();
        }
        if (q()) {
            jdVar.a(q);
            jdVar.mo715a(this.f696b);
            jdVar.b();
        }
        if (this.f709l != null && r()) {
            jdVar.a(r);
            jdVar.a(this.f709l);
            jdVar.b();
        }
        if (s()) {
            jdVar.a(s);
            jdVar.a(this.f695a);
            jdVar.b();
        }
        if (this.f694a != null && t()) {
            jdVar.a(t);
            jdVar.a(new jb(Constants.GZIP_CAST_TYPE, this.f694a.size()));
            for (String str : this.f694a) {
                jdVar.a(str);
            }
            jdVar.e();
            jdVar.b();
        }
        jdVar.c();
        jdVar.mo714a();
    }

    public void b(boolean z) {
        this.f693a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m668b() {
        return this.f691a != null;
    }

    public String c() {
        return this.f704g;
    }

    public void c(boolean z) {
        this.f693a.set(2, z);
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m669c() {
        return this.f698b != null;
    }

    public void d(boolean z) {
        this.f693a.set(3, z);
    }

    public boolean d() {
        return this.f700c != null;
    }

    public void e(boolean z) {
        this.f693a.set(4, z);
    }

    public boolean e() {
        return this.f693a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ii)) {
            return m667a((ii) obj);
        }
        return false;
    }

    public void f(boolean z) {
        this.f693a.set(5, z);
    }

    public boolean f() {
        return this.f701d != null;
    }

    public boolean g() {
        return this.f702e != null;
    }

    public boolean h() {
        return this.f703f != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f704g != null;
    }

    public boolean j() {
        return this.f693a.get(1);
    }

    public boolean k() {
        return this.f705h != null;
    }

    public boolean l() {
        return this.f706i != null;
    }

    public boolean m() {
        return this.f693a.get(2);
    }

    public boolean n() {
        return this.f707j != null;
    }

    public boolean o() {
        return this.f693a.get(3);
    }

    public boolean p() {
        return this.f708k != null;
    }

    public boolean q() {
        return this.f693a.get(4);
    }

    public boolean r() {
        return this.f709l != null;
    }

    public boolean s() {
        return this.f693a.get(5);
    }

    public boolean t() {
        return this.f694a != null;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionRegistrationResult(");
        boolean z2 = false;
        if (m666a()) {
            sb.append("debug:");
            String str = this.f692a;
            if (str == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (m668b()) {
            if (!z) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            }
            sb.append("target:");
            hw hwVar = this.f691a;
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
        String str2 = this.f698b;
        if (str2 == null) {
            sb.append(StringUtil.NULL_STRING);
        } else {
            sb.append(com.xiaomi.push.service.bd.a(str2));
        }
        sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        sb.append("appId:");
        String str3 = this.f700c;
        if (str3 == null) {
            sb.append(StringUtil.NULL_STRING);
        } else {
            sb.append(str3);
        }
        sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        sb.append("errorCode:");
        sb.append(this.f690a);
        if (f()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("reason:");
            String str4 = this.f701d;
            if (str4 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str4);
            }
        }
        if (g()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("regId:");
            String str5 = this.f702e;
            if (str5 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str5);
            }
        }
        if (i()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("packageName:");
            String str6 = this.f704g;
            if (str6 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str6);
            }
        }
        if (j()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("registeredAt:");
            sb.append(this.f697b);
        }
        if (k()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("aliasName:");
            String str7 = this.f705h;
            if (str7 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str7);
            }
        }
        if (l()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("clientId:");
            String str8 = this.f706i;
            if (str8 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str8);
            }
        }
        if (m()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("costTime:");
            sb.append(this.f699c);
        }
        if (n()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("appVersion:");
            String str9 = this.f707j;
            if (str9 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str9);
            }
        }
        if (o()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("pushSdkVersionCode:");
            sb.append(this.f689a);
        }
        if (p()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("hybridPushEndpoint:");
            String str10 = this.f708k;
            if (str10 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str10);
            }
        }
        if (q()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("appVersionCode:");
            sb.append(this.f696b);
        }
        if (r()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("region:");
            String str11 = this.f709l;
            if (str11 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str11);
            }
        }
        if (s()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("isHybridFrame:");
            sb.append(this.f695a);
        }
        if (t()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("autoMarkPkgs:");
            List<String> list = this.f694a;
            if (list == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(list);
            }
        }
        sb.append(SmallTailInfo.EMOTION_SUFFIX);
        return sb.toString();
    }
}
