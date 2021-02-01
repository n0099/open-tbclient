package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class im implements ix<im, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public int f708a;

    /* renamed from: a  reason: collision with other field name */
    public long f709a;

    /* renamed from: a  reason: collision with other field name */
    public ia f710a;

    /* renamed from: a  reason: collision with other field name */
    public ib f711a;

    /* renamed from: a  reason: collision with other field name */
    public String f712a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f714a;

    /* renamed from: b  reason: collision with other field name */
    public int f716b;

    /* renamed from: b  reason: collision with other field name */
    public long f717b;

    /* renamed from: b  reason: collision with other field name */
    public String f718b;

    /* renamed from: c  reason: collision with other field name */
    public int f720c;

    /* renamed from: c  reason: collision with other field name */
    public String f721c;

    /* renamed from: d  reason: collision with other field name */
    public String f722d;

    /* renamed from: e  reason: collision with other field name */
    public String f723e;

    /* renamed from: f  reason: collision with other field name */
    public String f724f;

    /* renamed from: g  reason: collision with other field name */
    public String f725g;

    /* renamed from: h  reason: collision with other field name */
    public String f726h;

    /* renamed from: i  reason: collision with other field name */
    public String f727i;

    /* renamed from: j  reason: collision with other field name */
    public String f728j;

    /* renamed from: k  reason: collision with other field name */
    public String f729k;

    /* renamed from: l  reason: collision with other field name */
    public String f730l;

    /* renamed from: m  reason: collision with other field name */
    public String f731m;

    /* renamed from: n  reason: collision with other field name */
    public String f732n;

    /* renamed from: o  reason: collision with other field name */
    public String f733o;

    /* renamed from: p  reason: collision with other field name */
    public String f734p;

    /* renamed from: q  reason: collision with other field name */
    public String f735q;

    /* renamed from: r  reason: collision with other field name */
    public String f736r;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f707a = new jn("XmPushActionRegistration");

    /* renamed from: a  reason: collision with root package name */
    private static final jf f14143a = new jf("", Constants.GZIP_CAST_TYPE, 1);

    /* renamed from: b  reason: collision with root package name */
    private static final jf f14144b = new jf("", (byte) 12, 2);
    private static final jf c = new jf("", Constants.GZIP_CAST_TYPE, 3);
    private static final jf d = new jf("", Constants.GZIP_CAST_TYPE, 4);
    private static final jf e = new jf("", Constants.GZIP_CAST_TYPE, 5);
    private static final jf f = new jf("", Constants.GZIP_CAST_TYPE, 6);
    private static final jf g = new jf("", Constants.GZIP_CAST_TYPE, 7);
    private static final jf h = new jf("", Constants.GZIP_CAST_TYPE, 8);
    private static final jf i = new jf("", Constants.GZIP_CAST_TYPE, 9);
    private static final jf j = new jf("", Constants.GZIP_CAST_TYPE, 10);
    private static final jf k = new jf("", Constants.GZIP_CAST_TYPE, 11);
    private static final jf l = new jf("", Constants.GZIP_CAST_TYPE, 12);
    private static final jf m = new jf("", (byte) 8, 13);
    private static final jf n = new jf("", (byte) 8, 14);
    private static final jf o = new jf("", Constants.GZIP_CAST_TYPE, 15);
    private static final jf p = new jf("", Constants.GZIP_CAST_TYPE, 16);
    private static final jf q = new jf("", Constants.GZIP_CAST_TYPE, 17);
    private static final jf r = new jf("", Constants.GZIP_CAST_TYPE, 18);
    private static final jf s = new jf("", (byte) 8, 19);
    private static final jf t = new jf("", (byte) 8, 20);
    private static final jf u = new jf("", (byte) 2, 21);
    private static final jf v = new jf("", (byte) 10, 22);
    private static final jf w = new jf("", (byte) 10, 23);
    private static final jf x = new jf("", Constants.GZIP_CAST_TYPE, 24);
    private static final jf y = new jf("", Constants.GZIP_CAST_TYPE, 25);
    private static final jf z = new jf("", (byte) 13, 100);
    private static final jf A = new jf("", (byte) 2, 101);
    private static final jf B = new jf("", Constants.GZIP_CAST_TYPE, 102);

    /* renamed from: a  reason: collision with other field name */
    private BitSet f713a = new BitSet(7);

    /* renamed from: a  reason: collision with other field name */
    public boolean f715a = true;

    /* renamed from: b  reason: collision with other field name */
    public boolean f719b = false;

    public boolean A() {
        return this.f713a.get(6);
    }

    public boolean B() {
        return this.f736r != null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(im imVar) {
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
        int a22;
        int a23;
        int a24;
        int a25;
        int a26;
        int a27;
        int a28;
        int a29;
        if (getClass().equals(imVar.getClass())) {
            int compareTo = Boolean.valueOf(m468a()).compareTo(Boolean.valueOf(imVar.m468a()));
            if (compareTo == 0) {
                if (!m468a() || (a29 = iy.a(this.f712a, imVar.f712a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m470b()).compareTo(Boolean.valueOf(imVar.m470b()));
                    if (compareTo2 == 0) {
                        if (!m470b() || (a28 = iy.a(this.f711a, imVar.f711a)) == 0) {
                            int compareTo3 = Boolean.valueOf(m471c()).compareTo(Boolean.valueOf(imVar.m471c()));
                            if (compareTo3 == 0) {
                                if (!m471c() || (a27 = iy.a(this.f718b, imVar.f718b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(imVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a26 = iy.a(this.f721c, imVar.f721c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(imVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a25 = iy.a(this.f722d, imVar.f722d)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(imVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a24 = iy.a(this.f723e, imVar.f723e)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(imVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a23 = iy.a(this.f724f, imVar.f724f)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(imVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a22 = iy.a(this.f725g, imVar.f725g)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(imVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a21 = iy.a(this.f726h, imVar.f726h)) == 0) {
                                                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(imVar.j()));
                                                                                    if (compareTo10 == 0) {
                                                                                        if (!j() || (a20 = iy.a(this.f727i, imVar.f727i)) == 0) {
                                                                                            int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(imVar.k()));
                                                                                            if (compareTo11 == 0) {
                                                                                                if (!k() || (a19 = iy.a(this.f728j, imVar.f728j)) == 0) {
                                                                                                    int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(imVar.l()));
                                                                                                    if (compareTo12 == 0) {
                                                                                                        if (!l() || (a18 = iy.a(this.f729k, imVar.f729k)) == 0) {
                                                                                                            int compareTo13 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(imVar.m()));
                                                                                                            if (compareTo13 == 0) {
                                                                                                                if (!m() || (a17 = iy.a(this.f708a, imVar.f708a)) == 0) {
                                                                                                                    int compareTo14 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(imVar.n()));
                                                                                                                    if (compareTo14 == 0) {
                                                                                                                        if (!n() || (a16 = iy.a(this.f716b, imVar.f716b)) == 0) {
                                                                                                                            int compareTo15 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(imVar.o()));
                                                                                                                            if (compareTo15 == 0) {
                                                                                                                                if (!o() || (a15 = iy.a(this.f730l, imVar.f730l)) == 0) {
                                                                                                                                    int compareTo16 = Boolean.valueOf(p()).compareTo(Boolean.valueOf(imVar.p()));
                                                                                                                                    if (compareTo16 == 0) {
                                                                                                                                        if (!p() || (a14 = iy.a(this.f731m, imVar.f731m)) == 0) {
                                                                                                                                            int compareTo17 = Boolean.valueOf(q()).compareTo(Boolean.valueOf(imVar.q()));
                                                                                                                                            if (compareTo17 == 0) {
                                                                                                                                                if (!q() || (a13 = iy.a(this.f732n, imVar.f732n)) == 0) {
                                                                                                                                                    int compareTo18 = Boolean.valueOf(r()).compareTo(Boolean.valueOf(imVar.r()));
                                                                                                                                                    if (compareTo18 == 0) {
                                                                                                                                                        if (!r() || (a12 = iy.a(this.f733o, imVar.f733o)) == 0) {
                                                                                                                                                            int compareTo19 = Boolean.valueOf(s()).compareTo(Boolean.valueOf(imVar.s()));
                                                                                                                                                            if (compareTo19 == 0) {
                                                                                                                                                                if (!s() || (a11 = iy.a(this.f720c, imVar.f720c)) == 0) {
                                                                                                                                                                    int compareTo20 = Boolean.valueOf(t()).compareTo(Boolean.valueOf(imVar.t()));
                                                                                                                                                                    if (compareTo20 == 0) {
                                                                                                                                                                        if (!t() || (a10 = iy.a(this.f710a, imVar.f710a)) == 0) {
                                                                                                                                                                            int compareTo21 = Boolean.valueOf(u()).compareTo(Boolean.valueOf(imVar.u()));
                                                                                                                                                                            if (compareTo21 == 0) {
                                                                                                                                                                                if (!u() || (a9 = iy.a(this.f715a, imVar.f715a)) == 0) {
                                                                                                                                                                                    int compareTo22 = Boolean.valueOf(v()).compareTo(Boolean.valueOf(imVar.v()));
                                                                                                                                                                                    if (compareTo22 == 0) {
                                                                                                                                                                                        if (!v() || (a8 = iy.a(this.f709a, imVar.f709a)) == 0) {
                                                                                                                                                                                            int compareTo23 = Boolean.valueOf(w()).compareTo(Boolean.valueOf(imVar.w()));
                                                                                                                                                                                            if (compareTo23 == 0) {
                                                                                                                                                                                                if (!w() || (a7 = iy.a(this.f717b, imVar.f717b)) == 0) {
                                                                                                                                                                                                    int compareTo24 = Boolean.valueOf(x()).compareTo(Boolean.valueOf(imVar.x()));
                                                                                                                                                                                                    if (compareTo24 == 0) {
                                                                                                                                                                                                        if (!x() || (a6 = iy.a(this.f734p, imVar.f734p)) == 0) {
                                                                                                                                                                                                            int compareTo25 = Boolean.valueOf(y()).compareTo(Boolean.valueOf(imVar.y()));
                                                                                                                                                                                                            if (compareTo25 == 0) {
                                                                                                                                                                                                                if (!y() || (a5 = iy.a(this.f735q, imVar.f735q)) == 0) {
                                                                                                                                                                                                                    int compareTo26 = Boolean.valueOf(z()).compareTo(Boolean.valueOf(imVar.z()));
                                                                                                                                                                                                                    if (compareTo26 == 0) {
                                                                                                                                                                                                                        if (!z() || (a4 = iy.a(this.f714a, imVar.f714a)) == 0) {
                                                                                                                                                                                                                            int compareTo27 = Boolean.valueOf(A()).compareTo(Boolean.valueOf(imVar.A()));
                                                                                                                                                                                                                            if (compareTo27 == 0) {
                                                                                                                                                                                                                                if (!A() || (a3 = iy.a(this.f719b, imVar.f719b)) == 0) {
                                                                                                                                                                                                                                    int compareTo28 = Boolean.valueOf(B()).compareTo(Boolean.valueOf(imVar.B()));
                                                                                                                                                                                                                                    if (compareTo28 == 0) {
                                                                                                                                                                                                                                        if (!B() || (a2 = iy.a(this.f736r, imVar.f736r)) == 0) {
                                                                                                                                                                                                                                            return 0;
                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                        return a2;
                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                    return compareTo28;
                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                return a3;
                                                                                                                                                                                                                            }
                                                                                                                                                                                                                            return compareTo27;
                                                                                                                                                                                                                        }
                                                                                                                                                                                                                        return a4;
                                                                                                                                                                                                                    }
                                                                                                                                                                                                                    return compareTo26;
                                                                                                                                                                                                                }
                                                                                                                                                                                                                return a5;
                                                                                                                                                                                                            }
                                                                                                                                                                                                            return compareTo25;
                                                                                                                                                                                                        }
                                                                                                                                                                                                        return a6;
                                                                                                                                                                                                    }
                                                                                                                                                                                                    return compareTo24;
                                                                                                                                                                                                }
                                                                                                                                                                                                return a7;
                                                                                                                                                                                            }
                                                                                                                                                                                            return compareTo23;
                                                                                                                                                                                        }
                                                                                                                                                                                        return a8;
                                                                                                                                                                                    }
                                                                                                                                                                                    return compareTo22;
                                                                                                                                                                                }
                                                                                                                                                                                return a9;
                                                                                                                                                                            }
                                                                                                                                                                            return compareTo21;
                                                                                                                                                                        }
                                                                                                                                                                        return a10;
                                                                                                                                                                    }
                                                                                                                                                                    return compareTo20;
                                                                                                                                                                }
                                                                                                                                                                return a11;
                                                                                                                                                            }
                                                                                                                                                            return compareTo19;
                                                                                                                                                        }
                                                                                                                                                        return a12;
                                                                                                                                                    }
                                                                                                                                                    return compareTo18;
                                                                                                                                                }
                                                                                                                                                return a13;
                                                                                                                                            }
                                                                                                                                            return compareTo17;
                                                                                                                                        }
                                                                                                                                        return a14;
                                                                                                                                    }
                                                                                                                                    return compareTo16;
                                                                                                                                }
                                                                                                                                return a15;
                                                                                                                            }
                                                                                                                            return compareTo15;
                                                                                                                        }
                                                                                                                        return a16;
                                                                                                                    }
                                                                                                                    return compareTo14;
                                                                                                                }
                                                                                                                return a17;
                                                                                                            }
                                                                                                            return compareTo13;
                                                                                                        }
                                                                                                        return a18;
                                                                                                    }
                                                                                                    return compareTo12;
                                                                                                }
                                                                                                return a19;
                                                                                            }
                                                                                            return compareTo11;
                                                                                        }
                                                                                        return a20;
                                                                                    }
                                                                                    return compareTo10;
                                                                                }
                                                                                return a21;
                                                                            }
                                                                            return compareTo9;
                                                                        }
                                                                        return a22;
                                                                    }
                                                                    return compareTo8;
                                                                }
                                                                return a23;
                                                            }
                                                            return compareTo7;
                                                        }
                                                        return a24;
                                                    }
                                                    return compareTo6;
                                                }
                                                return a25;
                                            }
                                            return compareTo5;
                                        }
                                        return a26;
                                    }
                                    return compareTo4;
                                }
                                return a27;
                            }
                            return compareTo3;
                        }
                        return a28;
                    }
                    return compareTo2;
                }
                return a29;
            }
            return compareTo;
        }
        return getClass().getName().compareTo(imVar.getClass().getName());
    }

    public im a(int i2) {
        this.f708a = i2;
        a(true);
        return this;
    }

    public im a(ia iaVar) {
        this.f710a = iaVar;
        return this;
    }

    public im a(String str) {
        this.f718b = str;
        return this;
    }

    public String a() {
        return this.f718b;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m467a() {
        if (this.f718b == null) {
            throw new jj("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f721c == null) {
            throw new jj("Required field 'appId' was not present! Struct: " + toString());
        }
        if (this.f724f == null) {
            throw new jj("Required field 'token' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m515a();
        while (true) {
            jf m511a = jiVar.m511a();
            if (m511a.f14173a == 0) {
                jiVar.f();
                m467a();
                return;
            }
            switch (m511a.f857a) {
                case 1:
                    if (m511a.f14173a == 11) {
                        this.f712a = jiVar.m516a();
                        break;
                    } else {
                        jl.a(jiVar, m511a.f14173a);
                        break;
                    }
                case 2:
                    if (m511a.f14173a == 12) {
                        this.f711a = new ib();
                        this.f711a.a(jiVar);
                        break;
                    } else {
                        jl.a(jiVar, m511a.f14173a);
                        break;
                    }
                case 3:
                    if (m511a.f14173a == 11) {
                        this.f718b = jiVar.m516a();
                        break;
                    } else {
                        jl.a(jiVar, m511a.f14173a);
                        break;
                    }
                case 4:
                    if (m511a.f14173a == 11) {
                        this.f721c = jiVar.m516a();
                        break;
                    } else {
                        jl.a(jiVar, m511a.f14173a);
                        break;
                    }
                case 5:
                    if (m511a.f14173a == 11) {
                        this.f722d = jiVar.m516a();
                        break;
                    } else {
                        jl.a(jiVar, m511a.f14173a);
                        break;
                    }
                case 6:
                    if (m511a.f14173a == 11) {
                        this.f723e = jiVar.m516a();
                        break;
                    } else {
                        jl.a(jiVar, m511a.f14173a);
                        break;
                    }
                case 7:
                    if (m511a.f14173a == 11) {
                        this.f724f = jiVar.m516a();
                        break;
                    } else {
                        jl.a(jiVar, m511a.f14173a);
                        break;
                    }
                case 8:
                    if (m511a.f14173a == 11) {
                        this.f725g = jiVar.m516a();
                        break;
                    } else {
                        jl.a(jiVar, m511a.f14173a);
                        break;
                    }
                case 9:
                    if (m511a.f14173a == 11) {
                        this.f726h = jiVar.m516a();
                        break;
                    } else {
                        jl.a(jiVar, m511a.f14173a);
                        break;
                    }
                case 10:
                    if (m511a.f14173a == 11) {
                        this.f727i = jiVar.m516a();
                        break;
                    } else {
                        jl.a(jiVar, m511a.f14173a);
                        break;
                    }
                case 11:
                    if (m511a.f14173a == 11) {
                        this.f728j = jiVar.m516a();
                        break;
                    } else {
                        jl.a(jiVar, m511a.f14173a);
                        break;
                    }
                case 12:
                    if (m511a.f14173a == 11) {
                        this.f729k = jiVar.m516a();
                        break;
                    } else {
                        jl.a(jiVar, m511a.f14173a);
                        break;
                    }
                case 13:
                    if (m511a.f14173a == 8) {
                        this.f708a = jiVar.m509a();
                        a(true);
                        break;
                    } else {
                        jl.a(jiVar, m511a.f14173a);
                        break;
                    }
                case 14:
                    if (m511a.f14173a == 8) {
                        this.f716b = jiVar.m509a();
                        b(true);
                        break;
                    } else {
                        jl.a(jiVar, m511a.f14173a);
                        break;
                    }
                case 15:
                    if (m511a.f14173a == 11) {
                        this.f730l = jiVar.m516a();
                        break;
                    } else {
                        jl.a(jiVar, m511a.f14173a);
                        break;
                    }
                case 16:
                    if (m511a.f14173a == 11) {
                        this.f731m = jiVar.m516a();
                        break;
                    } else {
                        jl.a(jiVar, m511a.f14173a);
                        break;
                    }
                case 17:
                    if (m511a.f14173a == 11) {
                        this.f732n = jiVar.m516a();
                        break;
                    } else {
                        jl.a(jiVar, m511a.f14173a);
                        break;
                    }
                case 18:
                    if (m511a.f14173a == 11) {
                        this.f733o = jiVar.m516a();
                        break;
                    } else {
                        jl.a(jiVar, m511a.f14173a);
                        break;
                    }
                case 19:
                    if (m511a.f14173a == 8) {
                        this.f720c = jiVar.m509a();
                        c(true);
                        break;
                    } else {
                        jl.a(jiVar, m511a.f14173a);
                        break;
                    }
                case 20:
                    if (m511a.f14173a == 8) {
                        this.f710a = ia.a(jiVar.m509a());
                        break;
                    } else {
                        jl.a(jiVar, m511a.f14173a);
                        break;
                    }
                case 21:
                    if (m511a.f14173a == 2) {
                        this.f715a = jiVar.m520a();
                        d(true);
                        break;
                    } else {
                        jl.a(jiVar, m511a.f14173a);
                        break;
                    }
                case 22:
                    if (m511a.f14173a == 10) {
                        this.f709a = jiVar.m510a();
                        e(true);
                        break;
                    } else {
                        jl.a(jiVar, m511a.f14173a);
                        break;
                    }
                case 23:
                    if (m511a.f14173a == 10) {
                        this.f717b = jiVar.m510a();
                        f(true);
                        break;
                    } else {
                        jl.a(jiVar, m511a.f14173a);
                        break;
                    }
                case 24:
                    if (m511a.f14173a == 11) {
                        this.f734p = jiVar.m516a();
                        break;
                    } else {
                        jl.a(jiVar, m511a.f14173a);
                        break;
                    }
                case 25:
                    if (m511a.f14173a == 11) {
                        this.f735q = jiVar.m516a();
                        break;
                    } else {
                        jl.a(jiVar, m511a.f14173a);
                        break;
                    }
                case 100:
                    if (m511a.f14173a == 13) {
                        jh m513a = jiVar.m513a();
                        this.f714a = new HashMap(m513a.f859a * 2);
                        for (int i2 = 0; i2 < m513a.f859a; i2++) {
                            this.f714a.put(jiVar.m516a(), jiVar.m516a());
                        }
                        jiVar.h();
                        break;
                    } else {
                        jl.a(jiVar, m511a.f14173a);
                        break;
                    }
                case 101:
                    if (m511a.f14173a == 2) {
                        this.f719b = jiVar.m520a();
                        g(true);
                        break;
                    } else {
                        jl.a(jiVar, m511a.f14173a);
                        break;
                    }
                case 102:
                    if (m511a.f14173a == 11) {
                        this.f736r = jiVar.m516a();
                        break;
                    } else {
                        jl.a(jiVar, m511a.f14173a);
                        break;
                    }
                default:
                    jl.a(jiVar, m511a.f14173a);
                    break;
            }
            jiVar.g();
        }
    }

    public void a(boolean z2) {
        this.f713a.set(0, z2);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m468a() {
        return this.f712a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m469a(im imVar) {
        if (imVar == null) {
            return false;
        }
        boolean m468a = m468a();
        boolean m468a2 = imVar.m468a();
        if ((m468a || m468a2) && !(m468a && m468a2 && this.f712a.equals(imVar.f712a))) {
            return false;
        }
        boolean m470b = m470b();
        boolean m470b2 = imVar.m470b();
        if ((m470b || m470b2) && !(m470b && m470b2 && this.f711a.m424a(imVar.f711a))) {
            return false;
        }
        boolean m471c = m471c();
        boolean m471c2 = imVar.m471c();
        if ((m471c || m471c2) && !(m471c && m471c2 && this.f718b.equals(imVar.f718b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = imVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f721c.equals(imVar.f721c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = imVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f722d.equals(imVar.f722d))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = imVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f723e.equals(imVar.f723e))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = imVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f724f.equals(imVar.f724f))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = imVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f725g.equals(imVar.f725g))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = imVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f726h.equals(imVar.f726h))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = imVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f727i.equals(imVar.f727i))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = imVar.k();
        if ((k2 || k3) && !(k2 && k3 && this.f728j.equals(imVar.f728j))) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = imVar.l();
        if ((l2 || l3) && !(l2 && l3 && this.f729k.equals(imVar.f729k))) {
            return false;
        }
        boolean m2 = m();
        boolean m3 = imVar.m();
        if ((m2 || m3) && !(m2 && m3 && this.f708a == imVar.f708a)) {
            return false;
        }
        boolean n2 = n();
        boolean n3 = imVar.n();
        if ((n2 || n3) && !(n2 && n3 && this.f716b == imVar.f716b)) {
            return false;
        }
        boolean o2 = o();
        boolean o3 = imVar.o();
        if ((o2 || o3) && !(o2 && o3 && this.f730l.equals(imVar.f730l))) {
            return false;
        }
        boolean p2 = p();
        boolean p3 = imVar.p();
        if ((p2 || p3) && !(p2 && p3 && this.f731m.equals(imVar.f731m))) {
            return false;
        }
        boolean q2 = q();
        boolean q3 = imVar.q();
        if ((q2 || q3) && !(q2 && q3 && this.f732n.equals(imVar.f732n))) {
            return false;
        }
        boolean r2 = r();
        boolean r3 = imVar.r();
        if ((r2 || r3) && !(r2 && r3 && this.f733o.equals(imVar.f733o))) {
            return false;
        }
        boolean s2 = s();
        boolean s3 = imVar.s();
        if ((s2 || s3) && !(s2 && s3 && this.f720c == imVar.f720c)) {
            return false;
        }
        boolean t2 = t();
        boolean t3 = imVar.t();
        if ((t2 || t3) && !(t2 && t3 && this.f710a.equals(imVar.f710a))) {
            return false;
        }
        boolean u2 = u();
        boolean u3 = imVar.u();
        if ((u2 || u3) && !(u2 && u3 && this.f715a == imVar.f715a)) {
            return false;
        }
        boolean v2 = v();
        boolean v3 = imVar.v();
        if ((v2 || v3) && !(v2 && v3 && this.f709a == imVar.f709a)) {
            return false;
        }
        boolean w2 = w();
        boolean w3 = imVar.w();
        if ((w2 || w3) && !(w2 && w3 && this.f717b == imVar.f717b)) {
            return false;
        }
        boolean x2 = x();
        boolean x3 = imVar.x();
        if ((x2 || x3) && !(x2 && x3 && this.f734p.equals(imVar.f734p))) {
            return false;
        }
        boolean y2 = y();
        boolean y3 = imVar.y();
        if ((y2 || y3) && !(y2 && y3 && this.f735q.equals(imVar.f735q))) {
            return false;
        }
        boolean z2 = z();
        boolean z3 = imVar.z();
        if ((z2 || z3) && !(z2 && z3 && this.f714a.equals(imVar.f714a))) {
            return false;
        }
        boolean A2 = A();
        boolean A3 = imVar.A();
        if ((A2 || A3) && !(A2 && A3 && this.f719b == imVar.f719b)) {
            return false;
        }
        boolean B2 = B();
        boolean B3 = imVar.B();
        return !(B2 || B3) || (B2 && B3 && this.f736r.equals(imVar.f736r));
    }

    public im b(int i2) {
        this.f716b = i2;
        b(true);
        return this;
    }

    public im b(String str) {
        this.f721c = str;
        return this;
    }

    public String b() {
        return this.f721c;
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        m467a();
        jiVar.a(f707a);
        if (this.f712a != null && m468a()) {
            jiVar.a(f14143a);
            jiVar.a(this.f712a);
            jiVar.b();
        }
        if (this.f711a != null && m470b()) {
            jiVar.a(f14144b);
            this.f711a.b(jiVar);
            jiVar.b();
        }
        if (this.f718b != null) {
            jiVar.a(c);
            jiVar.a(this.f718b);
            jiVar.b();
        }
        if (this.f721c != null) {
            jiVar.a(d);
            jiVar.a(this.f721c);
            jiVar.b();
        }
        if (this.f722d != null && e()) {
            jiVar.a(e);
            jiVar.a(this.f722d);
            jiVar.b();
        }
        if (this.f723e != null && f()) {
            jiVar.a(f);
            jiVar.a(this.f723e);
            jiVar.b();
        }
        if (this.f724f != null) {
            jiVar.a(g);
            jiVar.a(this.f724f);
            jiVar.b();
        }
        if (this.f725g != null && h()) {
            jiVar.a(h);
            jiVar.a(this.f725g);
            jiVar.b();
        }
        if (this.f726h != null && i()) {
            jiVar.a(i);
            jiVar.a(this.f726h);
            jiVar.b();
        }
        if (this.f727i != null && j()) {
            jiVar.a(j);
            jiVar.a(this.f727i);
            jiVar.b();
        }
        if (this.f728j != null && k()) {
            jiVar.a(k);
            jiVar.a(this.f728j);
            jiVar.b();
        }
        if (this.f729k != null && l()) {
            jiVar.a(l);
            jiVar.a(this.f729k);
            jiVar.b();
        }
        if (m()) {
            jiVar.a(m);
            jiVar.a(this.f708a);
            jiVar.b();
        }
        if (n()) {
            jiVar.a(n);
            jiVar.a(this.f716b);
            jiVar.b();
        }
        if (this.f730l != null && o()) {
            jiVar.a(o);
            jiVar.a(this.f730l);
            jiVar.b();
        }
        if (this.f731m != null && p()) {
            jiVar.a(p);
            jiVar.a(this.f731m);
            jiVar.b();
        }
        if (this.f732n != null && q()) {
            jiVar.a(q);
            jiVar.a(this.f732n);
            jiVar.b();
        }
        if (this.f733o != null && r()) {
            jiVar.a(r);
            jiVar.a(this.f733o);
            jiVar.b();
        }
        if (s()) {
            jiVar.a(s);
            jiVar.a(this.f720c);
            jiVar.b();
        }
        if (this.f710a != null && t()) {
            jiVar.a(t);
            jiVar.a(this.f710a.a());
            jiVar.b();
        }
        if (u()) {
            jiVar.a(u);
            jiVar.a(this.f715a);
            jiVar.b();
        }
        if (v()) {
            jiVar.a(v);
            jiVar.a(this.f709a);
            jiVar.b();
        }
        if (w()) {
            jiVar.a(w);
            jiVar.a(this.f717b);
            jiVar.b();
        }
        if (this.f734p != null && x()) {
            jiVar.a(x);
            jiVar.a(this.f734p);
            jiVar.b();
        }
        if (this.f735q != null && y()) {
            jiVar.a(y);
            jiVar.a(this.f735q);
            jiVar.b();
        }
        if (this.f714a != null && z()) {
            jiVar.a(z);
            jiVar.a(new jh(Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, this.f714a.size()));
            for (Map.Entry<String, String> entry : this.f714a.entrySet()) {
                jiVar.a(entry.getKey());
                jiVar.a(entry.getValue());
            }
            jiVar.d();
            jiVar.b();
        }
        if (A()) {
            jiVar.a(A);
            jiVar.a(this.f719b);
            jiVar.b();
        }
        if (this.f736r != null && B()) {
            jiVar.a(B);
            jiVar.a(this.f736r);
            jiVar.b();
        }
        jiVar.c();
        jiVar.m519a();
    }

    public void b(boolean z2) {
        this.f713a.set(1, z2);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m470b() {
        return this.f711a != null;
    }

    public im c(int i2) {
        this.f720c = i2;
        c(true);
        return this;
    }

    public im c(String str) {
        this.f722d = str;
        return this;
    }

    public String c() {
        return this.f724f;
    }

    public void c(boolean z2) {
        this.f713a.set(2, z2);
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m471c() {
        return this.f718b != null;
    }

    public im d(String str) {
        this.f723e = str;
        return this;
    }

    public void d(boolean z2) {
        this.f713a.set(3, z2);
    }

    public boolean d() {
        return this.f721c != null;
    }

    public im e(String str) {
        this.f724f = str;
        return this;
    }

    public void e(boolean z2) {
        this.f713a.set(4, z2);
    }

    public boolean e() {
        return this.f722d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof im)) {
            return m469a((im) obj);
        }
        return false;
    }

    public im f(String str) {
        this.f725g = str;
        return this;
    }

    public void f(boolean z2) {
        this.f713a.set(5, z2);
    }

    public boolean f() {
        return this.f723e != null;
    }

    public im g(String str) {
        this.f726h = str;
        return this;
    }

    public void g(boolean z2) {
        this.f713a.set(6, z2);
    }

    public boolean g() {
        return this.f724f != null;
    }

    public im h(String str) {
        this.f729k = str;
        return this;
    }

    public boolean h() {
        return this.f725g != null;
    }

    public int hashCode() {
        return 0;
    }

    public im i(String str) {
        this.f730l = str;
        return this;
    }

    public boolean i() {
        return this.f726h != null;
    }

    public im j(String str) {
        this.f732n = str;
        return this;
    }

    public boolean j() {
        return this.f727i != null;
    }

    public im k(String str) {
        this.f733o = str;
        return this;
    }

    public boolean k() {
        return this.f728j != null;
    }

    public boolean l() {
        return this.f729k != null;
    }

    public boolean m() {
        return this.f713a.get(0);
    }

    public boolean n() {
        return this.f713a.get(1);
    }

    public boolean o() {
        return this.f730l != null;
    }

    public boolean p() {
        return this.f731m != null;
    }

    public boolean q() {
        return this.f732n != null;
    }

    public boolean r() {
        return this.f733o != null;
    }

    public boolean s() {
        return this.f713a.get(2);
    }

    public boolean t() {
        return this.f710a != null;
    }

    public String toString() {
        boolean z2 = false;
        StringBuilder sb = new StringBuilder("XmPushActionRegistration(");
        boolean z3 = true;
        if (m468a()) {
            sb.append("debug:");
            if (this.f712a == null) {
                sb.append("null");
            } else {
                sb.append(this.f712a);
            }
            z3 = false;
        }
        if (m470b()) {
            if (!z3) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f711a == null) {
                sb.append("null");
            } else {
                sb.append(this.f711a);
            }
        } else {
            z2 = z3;
        }
        if (!z2) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f718b == null) {
            sb.append("null");
        } else {
            sb.append(this.f718b);
        }
        sb.append(", ");
        sb.append("appId:");
        if (this.f721c == null) {
            sb.append("null");
        } else {
            sb.append(this.f721c);
        }
        if (e()) {
            sb.append(", ");
            sb.append("appVersion:");
            if (this.f722d == null) {
                sb.append("null");
            } else {
                sb.append(this.f722d);
            }
        }
        if (f()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f723e == null) {
                sb.append("null");
            } else {
                sb.append(this.f723e);
            }
        }
        sb.append(", ");
        sb.append("token:");
        if (this.f724f == null) {
            sb.append("null");
        } else {
            sb.append(this.f724f);
        }
        if (h()) {
            sb.append(", ");
            sb.append("deviceId:");
            if (this.f725g == null) {
                sb.append("null");
            } else {
                sb.append(this.f725g);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("aliasName:");
            if (this.f726h == null) {
                sb.append("null");
            } else {
                sb.append(this.f726h);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("sdkVersion:");
            if (this.f727i == null) {
                sb.append("null");
            } else {
                sb.append(this.f727i);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("regId:");
            if (this.f728j == null) {
                sb.append("null");
            } else {
                sb.append(this.f728j);
            }
        }
        if (l()) {
            sb.append(", ");
            sb.append("pushSdkVersionName:");
            if (this.f729k == null) {
                sb.append("null");
            } else {
                sb.append(this.f729k);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("pushSdkVersionCode:");
            sb.append(this.f708a);
        }
        if (n()) {
            sb.append(", ");
            sb.append("appVersionCode:");
            sb.append(this.f716b);
        }
        if (o()) {
            sb.append(", ");
            sb.append("androidId:");
            if (this.f730l == null) {
                sb.append("null");
            } else {
                sb.append(this.f730l);
            }
        }
        if (p()) {
            sb.append(", ");
            sb.append("imei:");
            if (this.f731m == null) {
                sb.append("null");
            } else {
                sb.append(this.f731m);
            }
        }
        if (q()) {
            sb.append(", ");
            sb.append("serial:");
            if (this.f732n == null) {
                sb.append("null");
            } else {
                sb.append(this.f732n);
            }
        }
        if (r()) {
            sb.append(", ");
            sb.append("imeiMd5:");
            if (this.f733o == null) {
                sb.append("null");
            } else {
                sb.append(this.f733o);
            }
        }
        if (s()) {
            sb.append(", ");
            sb.append("spaceId:");
            sb.append(this.f720c);
        }
        if (t()) {
            sb.append(", ");
            sb.append("reason:");
            if (this.f710a == null) {
                sb.append("null");
            } else {
                sb.append(this.f710a);
            }
        }
        if (u()) {
            sb.append(", ");
            sb.append("validateToken:");
            sb.append(this.f715a);
        }
        if (v()) {
            sb.append(", ");
            sb.append("miid:");
            sb.append(this.f709a);
        }
        if (w()) {
            sb.append(", ");
            sb.append("createdTs:");
            sb.append(this.f717b);
        }
        if (x()) {
            sb.append(", ");
            sb.append("subImei:");
            if (this.f734p == null) {
                sb.append("null");
            } else {
                sb.append(this.f734p);
            }
        }
        if (y()) {
            sb.append(", ");
            sb.append("subImeiMd5:");
            if (this.f735q == null) {
                sb.append("null");
            } else {
                sb.append(this.f735q);
            }
        }
        if (z()) {
            sb.append(", ");
            sb.append("connectionAttrs:");
            if (this.f714a == null) {
                sb.append("null");
            } else {
                sb.append(this.f714a);
            }
        }
        if (A()) {
            sb.append(", ");
            sb.append("cleanOldRegInfo:");
            sb.append(this.f719b);
        }
        if (B()) {
            sb.append(", ");
            sb.append("oldRegId:");
            if (this.f736r == null) {
                sb.append("null");
            } else {
                sb.append(this.f736r);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    public boolean u() {
        return this.f713a.get(3);
    }

    public boolean v() {
        return this.f713a.get(4);
    }

    public boolean w() {
        return this.f713a.get(5);
    }

    public boolean x() {
        return this.f734p != null;
    }

    public boolean y() {
        return this.f735q != null;
    }

    public boolean z() {
        return this.f714a != null;
    }
}
