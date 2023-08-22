package com.xiaomi.push;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes10.dex */
public class hx implements is<hx, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public int f565a;

    /* renamed from: a  reason: collision with other field name */
    public long f566a;

    /* renamed from: a  reason: collision with other field name */
    public hw f567a;

    /* renamed from: a  reason: collision with other field name */
    public ik f568a;

    /* renamed from: a  reason: collision with other field name */
    public String f569a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f571a;

    /* renamed from: a  reason: collision with other field name */
    public short f572a;

    /* renamed from: b  reason: collision with other field name */
    public String f574b;

    /* renamed from: b  reason: collision with other field name */
    public short f575b;

    /* renamed from: c  reason: collision with other field name */
    public String f576c;

    /* renamed from: d  reason: collision with other field name */
    public String f577d;

    /* renamed from: e  reason: collision with other field name */
    public String f578e;

    /* renamed from: f  reason: collision with other field name */
    public String f579f;

    /* renamed from: g  reason: collision with other field name */
    public String f580g;

    /* renamed from: h  reason: collision with other field name */
    public String f581h;

    /* renamed from: i  reason: collision with other field name */
    public String f582i;

    /* renamed from: j  reason: collision with other field name */
    public String f583j;

    /* renamed from: k  reason: collision with other field name */
    public String f584k;

    /* renamed from: l  reason: collision with other field name */
    public String f585l;

    /* renamed from: a  reason: collision with other field name */
    public static final ji f564a = new ji("XmPushActionAckMessage");
    public static final ja a = new ja("", Constants.GZIP_CAST_TYPE, 1);
    public static final ja b = new ja("", (byte) 12, 2);
    public static final ja c = new ja("", Constants.GZIP_CAST_TYPE, 3);
    public static final ja d = new ja("", Constants.GZIP_CAST_TYPE, 4);
    public static final ja e = new ja("", (byte) 10, 5);
    public static final ja f = new ja("", Constants.GZIP_CAST_TYPE, 6);
    public static final ja g = new ja("", Constants.GZIP_CAST_TYPE, 7);
    public static final ja h = new ja("", (byte) 12, 8);
    public static final ja i = new ja("", Constants.GZIP_CAST_TYPE, 9);
    public static final ja j = new ja("", Constants.GZIP_CAST_TYPE, 10);
    public static final ja k = new ja("", (byte) 2, 11);
    public static final ja l = new ja("", Constants.GZIP_CAST_TYPE, 12);
    public static final ja m = new ja("", Constants.GZIP_CAST_TYPE, 13);
    public static final ja n = new ja("", Constants.GZIP_CAST_TYPE, 14);
    public static final ja o = new ja("", (byte) 6, 15);
    public static final ja p = new ja("", (byte) 6, 16);
    public static final ja q = new ja("", Constants.GZIP_CAST_TYPE, 20);
    public static final ja r = new ja("", Constants.GZIP_CAST_TYPE, 21);
    public static final ja s = new ja("", (byte) 8, 22);
    public static final ja t = new ja("", (byte) 13, 23);

    /* renamed from: a  reason: collision with other field name */
    public BitSet f570a = new BitSet(5);

    /* renamed from: a  reason: collision with other field name */
    public boolean f573a = false;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(hx hxVar) {
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
        if (hx.class.equals(hxVar.getClass())) {
            int compareTo = Boolean.valueOf(m597a()).compareTo(Boolean.valueOf(hxVar.m597a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m597a() || (a21 = it.a(this.f569a, hxVar.f569a)) == 0) {
                int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(hxVar.b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!b() || (a20 = it.a(this.f567a, hxVar.f567a)) == 0) {
                    int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(hxVar.c()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!c() || (a19 = it.a(this.f574b, hxVar.f574b)) == 0) {
                        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hxVar.d()));
                        if (compareTo4 != 0) {
                            return compareTo4;
                        }
                        if (!d() || (a18 = it.a(this.f576c, hxVar.f576c)) == 0) {
                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hxVar.e()));
                            if (compareTo5 != 0) {
                                return compareTo5;
                            }
                            if (!e() || (a17 = it.a(this.f566a, hxVar.f566a)) == 0) {
                                int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hxVar.f()));
                                if (compareTo6 != 0) {
                                    return compareTo6;
                                }
                                if (!f() || (a16 = it.a(this.f577d, hxVar.f577d)) == 0) {
                                    int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hxVar.g()));
                                    if (compareTo7 != 0) {
                                        return compareTo7;
                                    }
                                    if (!g() || (a15 = it.a(this.f578e, hxVar.f578e)) == 0) {
                                        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hxVar.h()));
                                        if (compareTo8 != 0) {
                                            return compareTo8;
                                        }
                                        if (!h() || (a14 = it.a(this.f568a, hxVar.f568a)) == 0) {
                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hxVar.i()));
                                            if (compareTo9 != 0) {
                                                return compareTo9;
                                            }
                                            if (!i() || (a13 = it.a(this.f579f, hxVar.f579f)) == 0) {
                                                int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(hxVar.j()));
                                                if (compareTo10 != 0) {
                                                    return compareTo10;
                                                }
                                                if (!j() || (a12 = it.a(this.f580g, hxVar.f580g)) == 0) {
                                                    int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(hxVar.k()));
                                                    if (compareTo11 != 0) {
                                                        return compareTo11;
                                                    }
                                                    if (!k() || (a11 = it.a(this.f573a, hxVar.f573a)) == 0) {
                                                        int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(hxVar.l()));
                                                        if (compareTo12 != 0) {
                                                            return compareTo12;
                                                        }
                                                        if (!l() || (a10 = it.a(this.f581h, hxVar.f581h)) == 0) {
                                                            int compareTo13 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(hxVar.m()));
                                                            if (compareTo13 != 0) {
                                                                return compareTo13;
                                                            }
                                                            if (!m() || (a9 = it.a(this.f582i, hxVar.f582i)) == 0) {
                                                                int compareTo14 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(hxVar.n()));
                                                                if (compareTo14 != 0) {
                                                                    return compareTo14;
                                                                }
                                                                if (!n() || (a8 = it.a(this.f583j, hxVar.f583j)) == 0) {
                                                                    int compareTo15 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(hxVar.o()));
                                                                    if (compareTo15 != 0) {
                                                                        return compareTo15;
                                                                    }
                                                                    if (!o() || (a7 = it.a(this.f572a, hxVar.f572a)) == 0) {
                                                                        int compareTo16 = Boolean.valueOf(p()).compareTo(Boolean.valueOf(hxVar.p()));
                                                                        if (compareTo16 != 0) {
                                                                            return compareTo16;
                                                                        }
                                                                        if (!p() || (a6 = it.a(this.f575b, hxVar.f575b)) == 0) {
                                                                            int compareTo17 = Boolean.valueOf(q()).compareTo(Boolean.valueOf(hxVar.q()));
                                                                            if (compareTo17 != 0) {
                                                                                return compareTo17;
                                                                            }
                                                                            if (!q() || (a5 = it.a(this.f584k, hxVar.f584k)) == 0) {
                                                                                int compareTo18 = Boolean.valueOf(r()).compareTo(Boolean.valueOf(hxVar.r()));
                                                                                if (compareTo18 != 0) {
                                                                                    return compareTo18;
                                                                                }
                                                                                if (!r() || (a4 = it.a(this.f585l, hxVar.f585l)) == 0) {
                                                                                    int compareTo19 = Boolean.valueOf(s()).compareTo(Boolean.valueOf(hxVar.s()));
                                                                                    if (compareTo19 != 0) {
                                                                                        return compareTo19;
                                                                                    }
                                                                                    if (!s() || (a3 = it.a(this.f565a, hxVar.f565a)) == 0) {
                                                                                        int compareTo20 = Boolean.valueOf(t()).compareTo(Boolean.valueOf(hxVar.t()));
                                                                                        if (compareTo20 != 0) {
                                                                                            return compareTo20;
                                                                                        }
                                                                                        if (!t() || (a2 = it.a(this.f571a, hxVar.f571a)) == 0) {
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
        return hx.class.getName().compareTo(hxVar.getClass().getName());
    }

    public hx a(long j2) {
        this.f566a = j2;
        a(true);
        return this;
    }

    public hx a(String str) {
        this.f574b = str;
        return this;
    }

    public hx a(short s2) {
        this.f572a = s2;
        c(true);
        return this;
    }

    public void a() {
        if (this.f574b == null) {
            throw new je("Required field 'id' was not present! Struct: " + toString());
        } else if (this.f576c != null) {
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
                    a();
                    return;
                }
                throw new je("Required field 'messageTs' was not found in serialized data! Struct: " + toString());
            }
            switch (mo696a.f814a) {
                case 1:
                    if (b2 == 11) {
                        this.f569a = jdVar.mo701a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 2:
                    if (b2 == 12) {
                        hw hwVar = new hw();
                        this.f567a = hwVar;
                        hwVar.a(jdVar);
                        continue;
                        jdVar.g();
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f574b = jdVar.mo701a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f576c = jdVar.mo701a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 5:
                    if (b2 == 10) {
                        this.f566a = jdVar.mo695a();
                        a(true);
                        continue;
                        jdVar.g();
                    }
                    break;
                case 6:
                    if (b2 == 11) {
                        this.f577d = jdVar.mo701a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f578e = jdVar.mo701a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 8:
                    if (b2 == 12) {
                        ik ikVar = new ik();
                        this.f568a = ikVar;
                        ikVar.a(jdVar);
                        continue;
                        jdVar.g();
                    }
                    break;
                case 9:
                    if (b2 == 11) {
                        this.f579f = jdVar.mo701a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 10:
                    if (b2 == 11) {
                        this.f580g = jdVar.mo701a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 11:
                    if (b2 == 2) {
                        this.f573a = jdVar.mo706a();
                        b(true);
                        continue;
                        jdVar.g();
                    }
                    break;
                case 12:
                    if (b2 == 11) {
                        this.f581h = jdVar.mo701a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 13:
                    if (b2 == 11) {
                        this.f582i = jdVar.mo701a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 14:
                    if (b2 == 11) {
                        this.f583j = jdVar.mo701a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 15:
                    if (b2 == 6) {
                        this.f572a = jdVar.mo703a();
                        c(true);
                        continue;
                        jdVar.g();
                    }
                    break;
                case 16:
                    if (b2 == 6) {
                        this.f575b = jdVar.mo703a();
                        d(true);
                        continue;
                        jdVar.g();
                    }
                    break;
                case 20:
                    if (b2 == 11) {
                        this.f584k = jdVar.mo701a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 21:
                    if (b2 == 11) {
                        this.f585l = jdVar.mo701a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 22:
                    if (b2 == 8) {
                        this.f565a = jdVar.mo694a();
                        e(true);
                        continue;
                        jdVar.g();
                    }
                    break;
                case 23:
                    if (b2 == 13) {
                        jc mo698a = jdVar.mo698a();
                        this.f571a = new HashMap(mo698a.f816a * 2);
                        for (int i2 = 0; i2 < mo698a.f816a; i2++) {
                            this.f571a.put(jdVar.mo701a(), jdVar.mo701a());
                        }
                        jdVar.h();
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
        this.f570a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m597a() {
        return this.f569a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m598a(hx hxVar) {
        if (hxVar == null) {
            return false;
        }
        boolean m597a = m597a();
        boolean m597a2 = hxVar.m597a();
        if ((m597a || m597a2) && !(m597a && m597a2 && this.f569a.equals(hxVar.f569a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = hxVar.b();
        if ((b2 || b3) && !(b2 && b3 && this.f567a.m596a(hxVar.f567a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = hxVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f574b.equals(hxVar.f574b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = hxVar.d();
        if (((d2 || d3) && !(d2 && d3 && this.f576c.equals(hxVar.f576c))) || this.f566a != hxVar.f566a) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = hxVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f577d.equals(hxVar.f577d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = hxVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f578e.equals(hxVar.f578e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = hxVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f568a.m665a(hxVar.f568a))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = hxVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f579f.equals(hxVar.f579f))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = hxVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f580g.equals(hxVar.f580g))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = hxVar.k();
        if ((k2 || k3) && !(k2 && k3 && this.f573a == hxVar.f573a)) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = hxVar.l();
        if ((l2 || l3) && !(l2 && l3 && this.f581h.equals(hxVar.f581h))) {
            return false;
        }
        boolean m2 = m();
        boolean m3 = hxVar.m();
        if ((m2 || m3) && !(m2 && m3 && this.f582i.equals(hxVar.f582i))) {
            return false;
        }
        boolean n2 = n();
        boolean n3 = hxVar.n();
        if ((n2 || n3) && !(n2 && n3 && this.f583j.equals(hxVar.f583j))) {
            return false;
        }
        boolean o2 = o();
        boolean o3 = hxVar.o();
        if ((o2 || o3) && !(o2 && o3 && this.f572a == hxVar.f572a)) {
            return false;
        }
        boolean p2 = p();
        boolean p3 = hxVar.p();
        if ((p2 || p3) && !(p2 && p3 && this.f575b == hxVar.f575b)) {
            return false;
        }
        boolean q2 = q();
        boolean q3 = hxVar.q();
        if ((q2 || q3) && !(q2 && q3 && this.f584k.equals(hxVar.f584k))) {
            return false;
        }
        boolean r2 = r();
        boolean r3 = hxVar.r();
        if ((r2 || r3) && !(r2 && r3 && this.f585l.equals(hxVar.f585l))) {
            return false;
        }
        boolean s2 = s();
        boolean s3 = hxVar.s();
        if ((s2 || s3) && !(s2 && s3 && this.f565a == hxVar.f565a)) {
            return false;
        }
        boolean t2 = t();
        boolean t3 = hxVar.t();
        if (t2 || t3) {
            return t2 && t3 && this.f571a.equals(hxVar.f571a);
        }
        return true;
    }

    public hx b(String str) {
        this.f576c = str;
        return this;
    }

    @Override // com.xiaomi.push.is
    public void b(jd jdVar) {
        a();
        jdVar.a(f564a);
        if (this.f569a != null && m597a()) {
            jdVar.a(a);
            jdVar.a(this.f569a);
            jdVar.b();
        }
        if (this.f567a != null && b()) {
            jdVar.a(b);
            this.f567a.b(jdVar);
            jdVar.b();
        }
        if (this.f574b != null) {
            jdVar.a(c);
            jdVar.a(this.f574b);
            jdVar.b();
        }
        if (this.f576c != null) {
            jdVar.a(d);
            jdVar.a(this.f576c);
            jdVar.b();
        }
        jdVar.a(e);
        jdVar.a(this.f566a);
        jdVar.b();
        if (this.f577d != null && f()) {
            jdVar.a(f);
            jdVar.a(this.f577d);
            jdVar.b();
        }
        if (this.f578e != null && g()) {
            jdVar.a(g);
            jdVar.a(this.f578e);
            jdVar.b();
        }
        if (this.f568a != null && h()) {
            jdVar.a(h);
            this.f568a.b(jdVar);
            jdVar.b();
        }
        if (this.f579f != null && i()) {
            jdVar.a(i);
            jdVar.a(this.f579f);
            jdVar.b();
        }
        if (this.f580g != null && j()) {
            jdVar.a(j);
            jdVar.a(this.f580g);
            jdVar.b();
        }
        if (k()) {
            jdVar.a(k);
            jdVar.a(this.f573a);
            jdVar.b();
        }
        if (this.f581h != null && l()) {
            jdVar.a(l);
            jdVar.a(this.f581h);
            jdVar.b();
        }
        if (this.f582i != null && m()) {
            jdVar.a(m);
            jdVar.a(this.f582i);
            jdVar.b();
        }
        if (this.f583j != null && n()) {
            jdVar.a(n);
            jdVar.a(this.f583j);
            jdVar.b();
        }
        if (o()) {
            jdVar.a(o);
            jdVar.a(this.f572a);
            jdVar.b();
        }
        if (p()) {
            jdVar.a(p);
            jdVar.a(this.f575b);
            jdVar.b();
        }
        if (this.f584k != null && q()) {
            jdVar.a(q);
            jdVar.a(this.f584k);
            jdVar.b();
        }
        if (this.f585l != null && r()) {
            jdVar.a(r);
            jdVar.a(this.f585l);
            jdVar.b();
        }
        if (s()) {
            jdVar.a(s);
            jdVar.mo705a(this.f565a);
            jdVar.b();
        }
        if (this.f571a != null && t()) {
            jdVar.a(t);
            jdVar.a(new jc(Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, this.f571a.size()));
            for (Map.Entry<String, String> entry : this.f571a.entrySet()) {
                jdVar.a(entry.getKey());
                jdVar.a(entry.getValue());
            }
            jdVar.d();
            jdVar.b();
        }
        jdVar.c();
        jdVar.mo704a();
    }

    public void b(boolean z) {
        this.f570a.set(1, z);
    }

    public boolean b() {
        return this.f567a != null;
    }

    public hx c(String str) {
        this.f577d = str;
        return this;
    }

    public void c(boolean z) {
        this.f570a.set(2, z);
    }

    public boolean c() {
        return this.f574b != null;
    }

    public hx d(String str) {
        this.f578e = str;
        return this;
    }

    public void d(boolean z) {
        this.f570a.set(3, z);
    }

    public boolean d() {
        return this.f576c != null;
    }

    public void e(boolean z) {
        this.f570a.set(4, z);
    }

    public boolean e() {
        return this.f570a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hx)) {
            return m598a((hx) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f577d != null;
    }

    public boolean g() {
        return this.f578e != null;
    }

    public boolean h() {
        return this.f568a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f579f != null;
    }

    public boolean j() {
        return this.f580g != null;
    }

    public boolean k() {
        return this.f570a.get(1);
    }

    public boolean l() {
        return this.f581h != null;
    }

    public boolean m() {
        return this.f582i != null;
    }

    public boolean n() {
        return this.f583j != null;
    }

    public boolean o() {
        return this.f570a.get(2);
    }

    public boolean p() {
        return this.f570a.get(3);
    }

    public boolean q() {
        return this.f584k != null;
    }

    public boolean r() {
        return this.f585l != null;
    }

    public boolean s() {
        return this.f570a.get(4);
    }

    public boolean t() {
        return this.f571a != null;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionAckMessage(");
        boolean z2 = false;
        if (m597a()) {
            sb.append("debug:");
            String str = this.f569a;
            if (str == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (b()) {
            if (!z) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            }
            sb.append("target:");
            hw hwVar = this.f567a;
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
        String str2 = this.f574b;
        if (str2 == null) {
            sb.append(StringUtil.NULL_STRING);
        } else {
            sb.append(str2);
        }
        sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        sb.append("appId:");
        String str3 = this.f576c;
        if (str3 == null) {
            sb.append(StringUtil.NULL_STRING);
        } else {
            sb.append(str3);
        }
        sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        sb.append("messageTs:");
        sb.append(this.f566a);
        if (f()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append(UrlSchemaHelper.SCHEMA_TYPE_TOPIC);
            String str4 = this.f577d;
            if (str4 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str4);
            }
        }
        if (g()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("aliasName:");
            String str5 = this.f578e;
            if (str5 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str5);
            }
        }
        if (h()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("request:");
            ik ikVar = this.f568a;
            if (ikVar == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(ikVar);
            }
        }
        if (i()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("packageName:");
            String str6 = this.f579f;
            if (str6 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str6);
            }
        }
        if (j()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("category:");
            String str7 = this.f580g;
            if (str7 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str7);
            }
        }
        if (k()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("isOnline:");
            sb.append(this.f573a);
        }
        if (l()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("regId:");
            String str8 = this.f581h;
            if (str8 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str8);
            }
        }
        if (m()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("callbackUrl:");
            String str9 = this.f582i;
            if (str9 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str9);
            }
        }
        if (n()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("userAccount:");
            String str10 = this.f583j;
            if (str10 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str10);
            }
        }
        if (o()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("deviceStatus:");
            sb.append((int) this.f572a);
        }
        if (p()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("geoMsgStatus:");
            sb.append((int) this.f575b);
        }
        if (q()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("imeiMd5:");
            String str11 = this.f584k;
            if (str11 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str11);
            }
        }
        if (r()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("deviceId:");
            String str12 = this.f585l;
            if (str12 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str12);
            }
        }
        if (s()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("passThrough:");
            sb.append(this.f565a);
        }
        if (t()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("extra:");
            Map<String, String> map = this.f571a;
            if (map == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(map);
            }
        }
        sb.append(SmallTailInfo.EMOTION_SUFFIX);
        return sb.toString();
    }
}
