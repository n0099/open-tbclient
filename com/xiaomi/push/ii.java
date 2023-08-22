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
    public int f694a;

    /* renamed from: a  reason: collision with other field name */
    public long f695a;

    /* renamed from: a  reason: collision with other field name */
    public hw f696a;

    /* renamed from: a  reason: collision with other field name */
    public String f697a;

    /* renamed from: a  reason: collision with other field name */
    public List<String> f699a;

    /* renamed from: b  reason: collision with other field name */
    public int f701b;

    /* renamed from: b  reason: collision with other field name */
    public long f702b;

    /* renamed from: b  reason: collision with other field name */
    public String f703b;

    /* renamed from: c  reason: collision with other field name */
    public long f704c;

    /* renamed from: c  reason: collision with other field name */
    public String f705c;

    /* renamed from: d  reason: collision with other field name */
    public String f706d;

    /* renamed from: e  reason: collision with other field name */
    public String f707e;

    /* renamed from: f  reason: collision with other field name */
    public String f708f;

    /* renamed from: g  reason: collision with other field name */
    public String f709g;

    /* renamed from: h  reason: collision with other field name */
    public String f710h;

    /* renamed from: i  reason: collision with other field name */
    public String f711i;

    /* renamed from: j  reason: collision with other field name */
    public String f712j;

    /* renamed from: k  reason: collision with other field name */
    public String f713k;

    /* renamed from: l  reason: collision with other field name */
    public String f714l;

    /* renamed from: a  reason: collision with other field name */
    public static final ji f693a = new ji("XmPushActionRegistrationResult");
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
    public BitSet f698a = new BitSet(6);

    /* renamed from: a  reason: collision with other field name */
    public boolean f700a = false;

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
            int compareTo = Boolean.valueOf(m656a()).compareTo(Boolean.valueOf(iiVar.m656a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m656a() || (a21 = it.a(this.f697a, iiVar.f697a)) == 0) {
                int compareTo2 = Boolean.valueOf(m658b()).compareTo(Boolean.valueOf(iiVar.m658b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!m658b() || (a20 = it.a(this.f696a, iiVar.f696a)) == 0) {
                    int compareTo3 = Boolean.valueOf(m659c()).compareTo(Boolean.valueOf(iiVar.m659c()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!m659c() || (a19 = it.a(this.f703b, iiVar.f703b)) == 0) {
                        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(iiVar.d()));
                        if (compareTo4 != 0) {
                            return compareTo4;
                        }
                        if (!d() || (a18 = it.a(this.f705c, iiVar.f705c)) == 0) {
                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(iiVar.e()));
                            if (compareTo5 != 0) {
                                return compareTo5;
                            }
                            if (!e() || (a17 = it.a(this.f695a, iiVar.f695a)) == 0) {
                                int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(iiVar.f()));
                                if (compareTo6 != 0) {
                                    return compareTo6;
                                }
                                if (!f() || (a16 = it.a(this.f706d, iiVar.f706d)) == 0) {
                                    int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(iiVar.g()));
                                    if (compareTo7 != 0) {
                                        return compareTo7;
                                    }
                                    if (!g() || (a15 = it.a(this.f707e, iiVar.f707e)) == 0) {
                                        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(iiVar.h()));
                                        if (compareTo8 != 0) {
                                            return compareTo8;
                                        }
                                        if (!h() || (a14 = it.a(this.f708f, iiVar.f708f)) == 0) {
                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(iiVar.i()));
                                            if (compareTo9 != 0) {
                                                return compareTo9;
                                            }
                                            if (!i() || (a13 = it.a(this.f709g, iiVar.f709g)) == 0) {
                                                int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(iiVar.j()));
                                                if (compareTo10 != 0) {
                                                    return compareTo10;
                                                }
                                                if (!j() || (a12 = it.a(this.f702b, iiVar.f702b)) == 0) {
                                                    int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(iiVar.k()));
                                                    if (compareTo11 != 0) {
                                                        return compareTo11;
                                                    }
                                                    if (!k() || (a11 = it.a(this.f710h, iiVar.f710h)) == 0) {
                                                        int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(iiVar.l()));
                                                        if (compareTo12 != 0) {
                                                            return compareTo12;
                                                        }
                                                        if (!l() || (a10 = it.a(this.f711i, iiVar.f711i)) == 0) {
                                                            int compareTo13 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(iiVar.m()));
                                                            if (compareTo13 != 0) {
                                                                return compareTo13;
                                                            }
                                                            if (!m() || (a9 = it.a(this.f704c, iiVar.f704c)) == 0) {
                                                                int compareTo14 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(iiVar.n()));
                                                                if (compareTo14 != 0) {
                                                                    return compareTo14;
                                                                }
                                                                if (!n() || (a8 = it.a(this.f712j, iiVar.f712j)) == 0) {
                                                                    int compareTo15 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(iiVar.o()));
                                                                    if (compareTo15 != 0) {
                                                                        return compareTo15;
                                                                    }
                                                                    if (!o() || (a7 = it.a(this.f694a, iiVar.f694a)) == 0) {
                                                                        int compareTo16 = Boolean.valueOf(p()).compareTo(Boolean.valueOf(iiVar.p()));
                                                                        if (compareTo16 != 0) {
                                                                            return compareTo16;
                                                                        }
                                                                        if (!p() || (a6 = it.a(this.f713k, iiVar.f713k)) == 0) {
                                                                            int compareTo17 = Boolean.valueOf(q()).compareTo(Boolean.valueOf(iiVar.q()));
                                                                            if (compareTo17 != 0) {
                                                                                return compareTo17;
                                                                            }
                                                                            if (!q() || (a5 = it.a(this.f701b, iiVar.f701b)) == 0) {
                                                                                int compareTo18 = Boolean.valueOf(r()).compareTo(Boolean.valueOf(iiVar.r()));
                                                                                if (compareTo18 != 0) {
                                                                                    return compareTo18;
                                                                                }
                                                                                if (!r() || (a4 = it.a(this.f714l, iiVar.f714l)) == 0) {
                                                                                    int compareTo19 = Boolean.valueOf(s()).compareTo(Boolean.valueOf(iiVar.s()));
                                                                                    if (compareTo19 != 0) {
                                                                                        return compareTo19;
                                                                                    }
                                                                                    if (!s() || (a3 = it.a(this.f700a, iiVar.f700a)) == 0) {
                                                                                        int compareTo20 = Boolean.valueOf(t()).compareTo(Boolean.valueOf(iiVar.t()));
                                                                                        if (compareTo20 != 0) {
                                                                                            return compareTo20;
                                                                                        }
                                                                                        if (!t() || (a2 = it.a(this.f699a, iiVar.f699a)) == 0) {
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
        return this.f695a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m653a() {
        return this.f703b;
    }

    /* renamed from: a  reason: collision with other method in class */
    public List<String> m654a() {
        return this.f699a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m655a() {
        if (this.f703b == null) {
            throw new je("Required field 'id' was not present! Struct: " + toString());
        } else if (this.f705c != null) {
        } else {
            throw new je("Required field 'appId' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.is
    public void a(jd jdVar) {
        jdVar.mo700a();
        while (true) {
            ja mo696a = jdVar.mo696a();
            byte b2 = mo696a.a;
            if (b2 == 0) {
                jdVar.f();
                if (e()) {
                    m655a();
                    return;
                }
                throw new je("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
            }
            switch (mo696a.f814a) {
                case 1:
                    if (b2 == 11) {
                        this.f697a = jdVar.mo701a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 2:
                    if (b2 == 12) {
                        hw hwVar = new hw();
                        this.f696a = hwVar;
                        hwVar.a(jdVar);
                        continue;
                        jdVar.g();
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f703b = jdVar.mo701a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f705c = jdVar.mo701a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 6:
                    if (b2 == 10) {
                        this.f695a = jdVar.mo695a();
                        a(true);
                        continue;
                        jdVar.g();
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f706d = jdVar.mo701a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 8:
                    if (b2 == 11) {
                        this.f707e = jdVar.mo701a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 9:
                    if (b2 == 11) {
                        this.f708f = jdVar.mo701a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 10:
                    if (b2 == 11) {
                        this.f709g = jdVar.mo701a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 11:
                    if (b2 == 10) {
                        this.f702b = jdVar.mo695a();
                        b(true);
                        continue;
                        jdVar.g();
                    }
                    break;
                case 12:
                    if (b2 == 11) {
                        this.f710h = jdVar.mo701a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 13:
                    if (b2 == 11) {
                        this.f711i = jdVar.mo701a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 14:
                    if (b2 == 10) {
                        this.f704c = jdVar.mo695a();
                        c(true);
                        continue;
                        jdVar.g();
                    }
                    break;
                case 15:
                    if (b2 == 11) {
                        this.f712j = jdVar.mo701a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 16:
                    if (b2 == 8) {
                        this.f694a = jdVar.mo694a();
                        d(true);
                        continue;
                        jdVar.g();
                    }
                    break;
                case 17:
                    if (b2 == 11) {
                        this.f713k = jdVar.mo701a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 18:
                    if (b2 == 8) {
                        this.f701b = jdVar.mo694a();
                        e(true);
                        continue;
                        jdVar.g();
                    }
                    break;
                case 19:
                    if (b2 == 11) {
                        this.f714l = jdVar.mo701a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 20:
                    if (b2 == 2) {
                        this.f700a = jdVar.mo706a();
                        f(true);
                        continue;
                        jdVar.g();
                    }
                    break;
                case 21:
                    if (b2 == 15) {
                        jb mo697a = jdVar.mo697a();
                        this.f699a = new ArrayList(mo697a.f815a);
                        for (int i2 = 0; i2 < mo697a.f815a; i2++) {
                            this.f699a.add(jdVar.mo701a());
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
        this.f698a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m656a() {
        return this.f697a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m657a(ii iiVar) {
        if (iiVar == null) {
            return false;
        }
        boolean m656a = m656a();
        boolean m656a2 = iiVar.m656a();
        if ((m656a || m656a2) && !(m656a && m656a2 && this.f697a.equals(iiVar.f697a))) {
            return false;
        }
        boolean m658b = m658b();
        boolean m658b2 = iiVar.m658b();
        if ((m658b || m658b2) && !(m658b && m658b2 && this.f696a.m596a(iiVar.f696a))) {
            return false;
        }
        boolean m659c = m659c();
        boolean m659c2 = iiVar.m659c();
        if ((m659c || m659c2) && !(m659c && m659c2 && this.f703b.equals(iiVar.f703b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = iiVar.d();
        if (((d2 || d3) && !(d2 && d3 && this.f705c.equals(iiVar.f705c))) || this.f695a != iiVar.f695a) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = iiVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f706d.equals(iiVar.f706d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = iiVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f707e.equals(iiVar.f707e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = iiVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f708f.equals(iiVar.f708f))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = iiVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f709g.equals(iiVar.f709g))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = iiVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f702b == iiVar.f702b)) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = iiVar.k();
        if ((k2 || k3) && !(k2 && k3 && this.f710h.equals(iiVar.f710h))) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = iiVar.l();
        if ((l2 || l3) && !(l2 && l3 && this.f711i.equals(iiVar.f711i))) {
            return false;
        }
        boolean m2 = m();
        boolean m3 = iiVar.m();
        if ((m2 || m3) && !(m2 && m3 && this.f704c == iiVar.f704c)) {
            return false;
        }
        boolean n2 = n();
        boolean n3 = iiVar.n();
        if ((n2 || n3) && !(n2 && n3 && this.f712j.equals(iiVar.f712j))) {
            return false;
        }
        boolean o2 = o();
        boolean o3 = iiVar.o();
        if ((o2 || o3) && !(o2 && o3 && this.f694a == iiVar.f694a)) {
            return false;
        }
        boolean p2 = p();
        boolean p3 = iiVar.p();
        if ((p2 || p3) && !(p2 && p3 && this.f713k.equals(iiVar.f713k))) {
            return false;
        }
        boolean q2 = q();
        boolean q3 = iiVar.q();
        if ((q2 || q3) && !(q2 && q3 && this.f701b == iiVar.f701b)) {
            return false;
        }
        boolean r2 = r();
        boolean r3 = iiVar.r();
        if ((r2 || r3) && !(r2 && r3 && this.f714l.equals(iiVar.f714l))) {
            return false;
        }
        boolean s2 = s();
        boolean s3 = iiVar.s();
        if ((s2 || s3) && !(s2 && s3 && this.f700a == iiVar.f700a)) {
            return false;
        }
        boolean t2 = t();
        boolean t3 = iiVar.t();
        if (t2 || t3) {
            return t2 && t3 && this.f699a.equals(iiVar.f699a);
        }
        return true;
    }

    public String b() {
        return this.f708f;
    }

    @Override // com.xiaomi.push.is
    public void b(jd jdVar) {
        m655a();
        jdVar.a(f693a);
        if (this.f697a != null && m656a()) {
            jdVar.a(a);
            jdVar.a(this.f697a);
            jdVar.b();
        }
        if (this.f696a != null && m658b()) {
            jdVar.a(b);
            this.f696a.b(jdVar);
            jdVar.b();
        }
        if (this.f703b != null) {
            jdVar.a(c);
            jdVar.a(this.f703b);
            jdVar.b();
        }
        if (this.f705c != null) {
            jdVar.a(d);
            jdVar.a(this.f705c);
            jdVar.b();
        }
        jdVar.a(e);
        jdVar.a(this.f695a);
        jdVar.b();
        if (this.f706d != null && f()) {
            jdVar.a(f);
            jdVar.a(this.f706d);
            jdVar.b();
        }
        if (this.f707e != null && g()) {
            jdVar.a(g);
            jdVar.a(this.f707e);
            jdVar.b();
        }
        if (this.f708f != null && h()) {
            jdVar.a(h);
            jdVar.a(this.f708f);
            jdVar.b();
        }
        if (this.f709g != null && i()) {
            jdVar.a(i);
            jdVar.a(this.f709g);
            jdVar.b();
        }
        if (j()) {
            jdVar.a(j);
            jdVar.a(this.f702b);
            jdVar.b();
        }
        if (this.f710h != null && k()) {
            jdVar.a(k);
            jdVar.a(this.f710h);
            jdVar.b();
        }
        if (this.f711i != null && l()) {
            jdVar.a(l);
            jdVar.a(this.f711i);
            jdVar.b();
        }
        if (m()) {
            jdVar.a(m);
            jdVar.a(this.f704c);
            jdVar.b();
        }
        if (this.f712j != null && n()) {
            jdVar.a(n);
            jdVar.a(this.f712j);
            jdVar.b();
        }
        if (o()) {
            jdVar.a(o);
            jdVar.mo705a(this.f694a);
            jdVar.b();
        }
        if (this.f713k != null && p()) {
            jdVar.a(p);
            jdVar.a(this.f713k);
            jdVar.b();
        }
        if (q()) {
            jdVar.a(q);
            jdVar.mo705a(this.f701b);
            jdVar.b();
        }
        if (this.f714l != null && r()) {
            jdVar.a(r);
            jdVar.a(this.f714l);
            jdVar.b();
        }
        if (s()) {
            jdVar.a(s);
            jdVar.a(this.f700a);
            jdVar.b();
        }
        if (this.f699a != null && t()) {
            jdVar.a(t);
            jdVar.a(new jb(Constants.GZIP_CAST_TYPE, this.f699a.size()));
            for (String str : this.f699a) {
                jdVar.a(str);
            }
            jdVar.e();
            jdVar.b();
        }
        jdVar.c();
        jdVar.mo704a();
    }

    public void b(boolean z) {
        this.f698a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m658b() {
        return this.f696a != null;
    }

    public String c() {
        return this.f709g;
    }

    public void c(boolean z) {
        this.f698a.set(2, z);
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m659c() {
        return this.f703b != null;
    }

    public void d(boolean z) {
        this.f698a.set(3, z);
    }

    public boolean d() {
        return this.f705c != null;
    }

    public void e(boolean z) {
        this.f698a.set(4, z);
    }

    public boolean e() {
        return this.f698a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ii)) {
            return m657a((ii) obj);
        }
        return false;
    }

    public void f(boolean z) {
        this.f698a.set(5, z);
    }

    public boolean f() {
        return this.f706d != null;
    }

    public boolean g() {
        return this.f707e != null;
    }

    public boolean h() {
        return this.f708f != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f709g != null;
    }

    public boolean j() {
        return this.f698a.get(1);
    }

    public boolean k() {
        return this.f710h != null;
    }

    public boolean l() {
        return this.f711i != null;
    }

    public boolean m() {
        return this.f698a.get(2);
    }

    public boolean n() {
        return this.f712j != null;
    }

    public boolean o() {
        return this.f698a.get(3);
    }

    public boolean p() {
        return this.f713k != null;
    }

    public boolean q() {
        return this.f698a.get(4);
    }

    public boolean r() {
        return this.f714l != null;
    }

    public boolean s() {
        return this.f698a.get(5);
    }

    public boolean t() {
        return this.f699a != null;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionRegistrationResult(");
        boolean z2 = false;
        if (m656a()) {
            sb.append("debug:");
            String str = this.f697a;
            if (str == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (m658b()) {
            if (!z) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            }
            sb.append("target:");
            hw hwVar = this.f696a;
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
        String str2 = this.f703b;
        if (str2 == null) {
            sb.append(StringUtil.NULL_STRING);
        } else {
            sb.append(com.xiaomi.push.service.bd.a(str2));
        }
        sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        sb.append("appId:");
        String str3 = this.f705c;
        if (str3 == null) {
            sb.append(StringUtil.NULL_STRING);
        } else {
            sb.append(str3);
        }
        sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        sb.append("errorCode:");
        sb.append(this.f695a);
        if (f()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("reason:");
            String str4 = this.f706d;
            if (str4 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str4);
            }
        }
        if (g()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("regId:");
            String str5 = this.f707e;
            if (str5 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str5);
            }
        }
        if (i()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("packageName:");
            String str6 = this.f709g;
            if (str6 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str6);
            }
        }
        if (j()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("registeredAt:");
            sb.append(this.f702b);
        }
        if (k()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("aliasName:");
            String str7 = this.f710h;
            if (str7 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str7);
            }
        }
        if (l()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("clientId:");
            String str8 = this.f711i;
            if (str8 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str8);
            }
        }
        if (m()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("costTime:");
            sb.append(this.f704c);
        }
        if (n()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("appVersion:");
            String str9 = this.f712j;
            if (str9 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str9);
            }
        }
        if (o()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("pushSdkVersionCode:");
            sb.append(this.f694a);
        }
        if (p()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("hybridPushEndpoint:");
            String str10 = this.f713k;
            if (str10 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str10);
            }
        }
        if (q()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("appVersionCode:");
            sb.append(this.f701b);
        }
        if (r()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("region:");
            String str11 = this.f714l;
            if (str11 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str11);
            }
        }
        if (s()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("isHybridFrame:");
            sb.append(this.f700a);
        }
        if (t()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("autoMarkPkgs:");
            List<String> list = this.f699a;
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
