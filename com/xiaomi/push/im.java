package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class im implements ix<im, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public int f709a;

    /* renamed from: a  reason: collision with other field name */
    public long f710a;

    /* renamed from: a  reason: collision with other field name */
    public ia f711a;

    /* renamed from: a  reason: collision with other field name */
    public ib f712a;

    /* renamed from: a  reason: collision with other field name */
    public String f713a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f715a;

    /* renamed from: b  reason: collision with other field name */
    public int f717b;

    /* renamed from: b  reason: collision with other field name */
    public long f718b;

    /* renamed from: b  reason: collision with other field name */
    public String f719b;

    /* renamed from: c  reason: collision with other field name */
    public int f721c;

    /* renamed from: c  reason: collision with other field name */
    public String f722c;

    /* renamed from: d  reason: collision with other field name */
    public String f723d;

    /* renamed from: e  reason: collision with other field name */
    public String f724e;

    /* renamed from: f  reason: collision with other field name */
    public String f725f;

    /* renamed from: g  reason: collision with other field name */
    public String f726g;

    /* renamed from: h  reason: collision with other field name */
    public String f727h;

    /* renamed from: i  reason: collision with other field name */
    public String f728i;

    /* renamed from: j  reason: collision with other field name */
    public String f729j;

    /* renamed from: k  reason: collision with other field name */
    public String f730k;

    /* renamed from: l  reason: collision with other field name */
    public String f731l;

    /* renamed from: m  reason: collision with other field name */
    public String f732m;

    /* renamed from: n  reason: collision with other field name */
    public String f733n;

    /* renamed from: o  reason: collision with other field name */
    public String f734o;

    /* renamed from: p  reason: collision with other field name */
    public String f735p;

    /* renamed from: q  reason: collision with other field name */
    public String f736q;

    /* renamed from: r  reason: collision with other field name */
    public String f737r;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f708a = new jn("XmPushActionRegistration");

    /* renamed from: a  reason: collision with root package name */
    private static final jf f14441a = new jf("", Constants.GZIP_CAST_TYPE, 1);

    /* renamed from: b  reason: collision with root package name */
    private static final jf f14442b = new jf("", (byte) 12, 2);
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
    private BitSet f714a = new BitSet(7);

    /* renamed from: a  reason: collision with other field name */
    public boolean f716a = true;

    /* renamed from: b  reason: collision with other field name */
    public boolean f720b = false;

    public boolean A() {
        return this.f714a.get(6);
    }

    public boolean B() {
        return this.f737r != null;
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
            int compareTo = Boolean.valueOf(m472a()).compareTo(Boolean.valueOf(imVar.m472a()));
            if (compareTo == 0) {
                if (!m472a() || (a29 = iy.a(this.f713a, imVar.f713a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m474b()).compareTo(Boolean.valueOf(imVar.m474b()));
                    if (compareTo2 == 0) {
                        if (!m474b() || (a28 = iy.a(this.f712a, imVar.f712a)) == 0) {
                            int compareTo3 = Boolean.valueOf(m475c()).compareTo(Boolean.valueOf(imVar.m475c()));
                            if (compareTo3 == 0) {
                                if (!m475c() || (a27 = iy.a(this.f719b, imVar.f719b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(imVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a26 = iy.a(this.f722c, imVar.f722c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(imVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a25 = iy.a(this.f723d, imVar.f723d)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(imVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a24 = iy.a(this.f724e, imVar.f724e)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(imVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a23 = iy.a(this.f725f, imVar.f725f)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(imVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a22 = iy.a(this.f726g, imVar.f726g)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(imVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a21 = iy.a(this.f727h, imVar.f727h)) == 0) {
                                                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(imVar.j()));
                                                                                    if (compareTo10 == 0) {
                                                                                        if (!j() || (a20 = iy.a(this.f728i, imVar.f728i)) == 0) {
                                                                                            int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(imVar.k()));
                                                                                            if (compareTo11 == 0) {
                                                                                                if (!k() || (a19 = iy.a(this.f729j, imVar.f729j)) == 0) {
                                                                                                    int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(imVar.l()));
                                                                                                    if (compareTo12 == 0) {
                                                                                                        if (!l() || (a18 = iy.a(this.f730k, imVar.f730k)) == 0) {
                                                                                                            int compareTo13 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(imVar.m()));
                                                                                                            if (compareTo13 == 0) {
                                                                                                                if (!m() || (a17 = iy.a(this.f709a, imVar.f709a)) == 0) {
                                                                                                                    int compareTo14 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(imVar.n()));
                                                                                                                    if (compareTo14 == 0) {
                                                                                                                        if (!n() || (a16 = iy.a(this.f717b, imVar.f717b)) == 0) {
                                                                                                                            int compareTo15 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(imVar.o()));
                                                                                                                            if (compareTo15 == 0) {
                                                                                                                                if (!o() || (a15 = iy.a(this.f731l, imVar.f731l)) == 0) {
                                                                                                                                    int compareTo16 = Boolean.valueOf(p()).compareTo(Boolean.valueOf(imVar.p()));
                                                                                                                                    if (compareTo16 == 0) {
                                                                                                                                        if (!p() || (a14 = iy.a(this.f732m, imVar.f732m)) == 0) {
                                                                                                                                            int compareTo17 = Boolean.valueOf(q()).compareTo(Boolean.valueOf(imVar.q()));
                                                                                                                                            if (compareTo17 == 0) {
                                                                                                                                                if (!q() || (a13 = iy.a(this.f733n, imVar.f733n)) == 0) {
                                                                                                                                                    int compareTo18 = Boolean.valueOf(r()).compareTo(Boolean.valueOf(imVar.r()));
                                                                                                                                                    if (compareTo18 == 0) {
                                                                                                                                                        if (!r() || (a12 = iy.a(this.f734o, imVar.f734o)) == 0) {
                                                                                                                                                            int compareTo19 = Boolean.valueOf(s()).compareTo(Boolean.valueOf(imVar.s()));
                                                                                                                                                            if (compareTo19 == 0) {
                                                                                                                                                                if (!s() || (a11 = iy.a(this.f721c, imVar.f721c)) == 0) {
                                                                                                                                                                    int compareTo20 = Boolean.valueOf(t()).compareTo(Boolean.valueOf(imVar.t()));
                                                                                                                                                                    if (compareTo20 == 0) {
                                                                                                                                                                        if (!t() || (a10 = iy.a(this.f711a, imVar.f711a)) == 0) {
                                                                                                                                                                            int compareTo21 = Boolean.valueOf(u()).compareTo(Boolean.valueOf(imVar.u()));
                                                                                                                                                                            if (compareTo21 == 0) {
                                                                                                                                                                                if (!u() || (a9 = iy.a(this.f716a, imVar.f716a)) == 0) {
                                                                                                                                                                                    int compareTo22 = Boolean.valueOf(v()).compareTo(Boolean.valueOf(imVar.v()));
                                                                                                                                                                                    if (compareTo22 == 0) {
                                                                                                                                                                                        if (!v() || (a8 = iy.a(this.f710a, imVar.f710a)) == 0) {
                                                                                                                                                                                            int compareTo23 = Boolean.valueOf(w()).compareTo(Boolean.valueOf(imVar.w()));
                                                                                                                                                                                            if (compareTo23 == 0) {
                                                                                                                                                                                                if (!w() || (a7 = iy.a(this.f718b, imVar.f718b)) == 0) {
                                                                                                                                                                                                    int compareTo24 = Boolean.valueOf(x()).compareTo(Boolean.valueOf(imVar.x()));
                                                                                                                                                                                                    if (compareTo24 == 0) {
                                                                                                                                                                                                        if (!x() || (a6 = iy.a(this.f735p, imVar.f735p)) == 0) {
                                                                                                                                                                                                            int compareTo25 = Boolean.valueOf(y()).compareTo(Boolean.valueOf(imVar.y()));
                                                                                                                                                                                                            if (compareTo25 == 0) {
                                                                                                                                                                                                                if (!y() || (a5 = iy.a(this.f736q, imVar.f736q)) == 0) {
                                                                                                                                                                                                                    int compareTo26 = Boolean.valueOf(z()).compareTo(Boolean.valueOf(imVar.z()));
                                                                                                                                                                                                                    if (compareTo26 == 0) {
                                                                                                                                                                                                                        if (!z() || (a4 = iy.a(this.f715a, imVar.f715a)) == 0) {
                                                                                                                                                                                                                            int compareTo27 = Boolean.valueOf(A()).compareTo(Boolean.valueOf(imVar.A()));
                                                                                                                                                                                                                            if (compareTo27 == 0) {
                                                                                                                                                                                                                                if (!A() || (a3 = iy.a(this.f720b, imVar.f720b)) == 0) {
                                                                                                                                                                                                                                    int compareTo28 = Boolean.valueOf(B()).compareTo(Boolean.valueOf(imVar.B()));
                                                                                                                                                                                                                                    if (compareTo28 == 0) {
                                                                                                                                                                                                                                        if (!B() || (a2 = iy.a(this.f737r, imVar.f737r)) == 0) {
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
        this.f709a = i2;
        a(true);
        return this;
    }

    public im a(ia iaVar) {
        this.f711a = iaVar;
        return this;
    }

    public im a(String str) {
        this.f719b = str;
        return this;
    }

    public String a() {
        return this.f719b;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m471a() {
        if (this.f719b == null) {
            throw new jj("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f722c == null) {
            throw new jj("Required field 'appId' was not present! Struct: " + toString());
        }
        if (this.f725f == null) {
            throw new jj("Required field 'token' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m519a();
        while (true) {
            jf m515a = jiVar.m515a();
            if (m515a.f14471a == 0) {
                jiVar.f();
                m471a();
                return;
            }
            switch (m515a.f858a) {
                case 1:
                    if (m515a.f14471a == 11) {
                        this.f713a = jiVar.m520a();
                        break;
                    } else {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    }
                case 2:
                    if (m515a.f14471a == 12) {
                        this.f712a = new ib();
                        this.f712a.a(jiVar);
                        break;
                    } else {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    }
                case 3:
                    if (m515a.f14471a == 11) {
                        this.f719b = jiVar.m520a();
                        break;
                    } else {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    }
                case 4:
                    if (m515a.f14471a == 11) {
                        this.f722c = jiVar.m520a();
                        break;
                    } else {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    }
                case 5:
                    if (m515a.f14471a == 11) {
                        this.f723d = jiVar.m520a();
                        break;
                    } else {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    }
                case 6:
                    if (m515a.f14471a == 11) {
                        this.f724e = jiVar.m520a();
                        break;
                    } else {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    }
                case 7:
                    if (m515a.f14471a == 11) {
                        this.f725f = jiVar.m520a();
                        break;
                    } else {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    }
                case 8:
                    if (m515a.f14471a == 11) {
                        this.f726g = jiVar.m520a();
                        break;
                    } else {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    }
                case 9:
                    if (m515a.f14471a == 11) {
                        this.f727h = jiVar.m520a();
                        break;
                    } else {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    }
                case 10:
                    if (m515a.f14471a == 11) {
                        this.f728i = jiVar.m520a();
                        break;
                    } else {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    }
                case 11:
                    if (m515a.f14471a == 11) {
                        this.f729j = jiVar.m520a();
                        break;
                    } else {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    }
                case 12:
                    if (m515a.f14471a == 11) {
                        this.f730k = jiVar.m520a();
                        break;
                    } else {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    }
                case 13:
                    if (m515a.f14471a == 8) {
                        this.f709a = jiVar.m513a();
                        a(true);
                        break;
                    } else {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    }
                case 14:
                    if (m515a.f14471a == 8) {
                        this.f717b = jiVar.m513a();
                        b(true);
                        break;
                    } else {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    }
                case 15:
                    if (m515a.f14471a == 11) {
                        this.f731l = jiVar.m520a();
                        break;
                    } else {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    }
                case 16:
                    if (m515a.f14471a == 11) {
                        this.f732m = jiVar.m520a();
                        break;
                    } else {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    }
                case 17:
                    if (m515a.f14471a == 11) {
                        this.f733n = jiVar.m520a();
                        break;
                    } else {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    }
                case 18:
                    if (m515a.f14471a == 11) {
                        this.f734o = jiVar.m520a();
                        break;
                    } else {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    }
                case 19:
                    if (m515a.f14471a == 8) {
                        this.f721c = jiVar.m513a();
                        c(true);
                        break;
                    } else {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    }
                case 20:
                    if (m515a.f14471a == 8) {
                        this.f711a = ia.a(jiVar.m513a());
                        break;
                    } else {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    }
                case 21:
                    if (m515a.f14471a == 2) {
                        this.f716a = jiVar.m524a();
                        d(true);
                        break;
                    } else {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    }
                case 22:
                    if (m515a.f14471a == 10) {
                        this.f710a = jiVar.m514a();
                        e(true);
                        break;
                    } else {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    }
                case 23:
                    if (m515a.f14471a == 10) {
                        this.f718b = jiVar.m514a();
                        f(true);
                        break;
                    } else {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    }
                case 24:
                    if (m515a.f14471a == 11) {
                        this.f735p = jiVar.m520a();
                        break;
                    } else {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    }
                case 25:
                    if (m515a.f14471a == 11) {
                        this.f736q = jiVar.m520a();
                        break;
                    } else {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    }
                case 100:
                    if (m515a.f14471a == 13) {
                        jh m517a = jiVar.m517a();
                        this.f715a = new HashMap(m517a.f860a * 2);
                        for (int i2 = 0; i2 < m517a.f860a; i2++) {
                            this.f715a.put(jiVar.m520a(), jiVar.m520a());
                        }
                        jiVar.h();
                        break;
                    } else {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    }
                case 101:
                    if (m515a.f14471a == 2) {
                        this.f720b = jiVar.m524a();
                        g(true);
                        break;
                    } else {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    }
                case 102:
                    if (m515a.f14471a == 11) {
                        this.f737r = jiVar.m520a();
                        break;
                    } else {
                        jl.a(jiVar, m515a.f14471a);
                        break;
                    }
                default:
                    jl.a(jiVar, m515a.f14471a);
                    break;
            }
            jiVar.g();
        }
    }

    public void a(boolean z2) {
        this.f714a.set(0, z2);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m472a() {
        return this.f713a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m473a(im imVar) {
        if (imVar == null) {
            return false;
        }
        boolean m472a = m472a();
        boolean m472a2 = imVar.m472a();
        if ((m472a || m472a2) && !(m472a && m472a2 && this.f713a.equals(imVar.f713a))) {
            return false;
        }
        boolean m474b = m474b();
        boolean m474b2 = imVar.m474b();
        if ((m474b || m474b2) && !(m474b && m474b2 && this.f712a.m428a(imVar.f712a))) {
            return false;
        }
        boolean m475c = m475c();
        boolean m475c2 = imVar.m475c();
        if ((m475c || m475c2) && !(m475c && m475c2 && this.f719b.equals(imVar.f719b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = imVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f722c.equals(imVar.f722c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = imVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f723d.equals(imVar.f723d))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = imVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f724e.equals(imVar.f724e))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = imVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f725f.equals(imVar.f725f))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = imVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f726g.equals(imVar.f726g))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = imVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f727h.equals(imVar.f727h))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = imVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f728i.equals(imVar.f728i))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = imVar.k();
        if ((k2 || k3) && !(k2 && k3 && this.f729j.equals(imVar.f729j))) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = imVar.l();
        if ((l2 || l3) && !(l2 && l3 && this.f730k.equals(imVar.f730k))) {
            return false;
        }
        boolean m2 = m();
        boolean m3 = imVar.m();
        if ((m2 || m3) && !(m2 && m3 && this.f709a == imVar.f709a)) {
            return false;
        }
        boolean n2 = n();
        boolean n3 = imVar.n();
        if ((n2 || n3) && !(n2 && n3 && this.f717b == imVar.f717b)) {
            return false;
        }
        boolean o2 = o();
        boolean o3 = imVar.o();
        if ((o2 || o3) && !(o2 && o3 && this.f731l.equals(imVar.f731l))) {
            return false;
        }
        boolean p2 = p();
        boolean p3 = imVar.p();
        if ((p2 || p3) && !(p2 && p3 && this.f732m.equals(imVar.f732m))) {
            return false;
        }
        boolean q2 = q();
        boolean q3 = imVar.q();
        if ((q2 || q3) && !(q2 && q3 && this.f733n.equals(imVar.f733n))) {
            return false;
        }
        boolean r2 = r();
        boolean r3 = imVar.r();
        if ((r2 || r3) && !(r2 && r3 && this.f734o.equals(imVar.f734o))) {
            return false;
        }
        boolean s2 = s();
        boolean s3 = imVar.s();
        if ((s2 || s3) && !(s2 && s3 && this.f721c == imVar.f721c)) {
            return false;
        }
        boolean t2 = t();
        boolean t3 = imVar.t();
        if ((t2 || t3) && !(t2 && t3 && this.f711a.equals(imVar.f711a))) {
            return false;
        }
        boolean u2 = u();
        boolean u3 = imVar.u();
        if ((u2 || u3) && !(u2 && u3 && this.f716a == imVar.f716a)) {
            return false;
        }
        boolean v2 = v();
        boolean v3 = imVar.v();
        if ((v2 || v3) && !(v2 && v3 && this.f710a == imVar.f710a)) {
            return false;
        }
        boolean w2 = w();
        boolean w3 = imVar.w();
        if ((w2 || w3) && !(w2 && w3 && this.f718b == imVar.f718b)) {
            return false;
        }
        boolean x2 = x();
        boolean x3 = imVar.x();
        if ((x2 || x3) && !(x2 && x3 && this.f735p.equals(imVar.f735p))) {
            return false;
        }
        boolean y2 = y();
        boolean y3 = imVar.y();
        if ((y2 || y3) && !(y2 && y3 && this.f736q.equals(imVar.f736q))) {
            return false;
        }
        boolean z2 = z();
        boolean z3 = imVar.z();
        if ((z2 || z3) && !(z2 && z3 && this.f715a.equals(imVar.f715a))) {
            return false;
        }
        boolean A2 = A();
        boolean A3 = imVar.A();
        if ((A2 || A3) && !(A2 && A3 && this.f720b == imVar.f720b)) {
            return false;
        }
        boolean B2 = B();
        boolean B3 = imVar.B();
        return !(B2 || B3) || (B2 && B3 && this.f737r.equals(imVar.f737r));
    }

    public im b(int i2) {
        this.f717b = i2;
        b(true);
        return this;
    }

    public im b(String str) {
        this.f722c = str;
        return this;
    }

    public String b() {
        return this.f722c;
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        m471a();
        jiVar.a(f708a);
        if (this.f713a != null && m472a()) {
            jiVar.a(f14441a);
            jiVar.a(this.f713a);
            jiVar.b();
        }
        if (this.f712a != null && m474b()) {
            jiVar.a(f14442b);
            this.f712a.b(jiVar);
            jiVar.b();
        }
        if (this.f719b != null) {
            jiVar.a(c);
            jiVar.a(this.f719b);
            jiVar.b();
        }
        if (this.f722c != null) {
            jiVar.a(d);
            jiVar.a(this.f722c);
            jiVar.b();
        }
        if (this.f723d != null && e()) {
            jiVar.a(e);
            jiVar.a(this.f723d);
            jiVar.b();
        }
        if (this.f724e != null && f()) {
            jiVar.a(f);
            jiVar.a(this.f724e);
            jiVar.b();
        }
        if (this.f725f != null) {
            jiVar.a(g);
            jiVar.a(this.f725f);
            jiVar.b();
        }
        if (this.f726g != null && h()) {
            jiVar.a(h);
            jiVar.a(this.f726g);
            jiVar.b();
        }
        if (this.f727h != null && i()) {
            jiVar.a(i);
            jiVar.a(this.f727h);
            jiVar.b();
        }
        if (this.f728i != null && j()) {
            jiVar.a(j);
            jiVar.a(this.f728i);
            jiVar.b();
        }
        if (this.f729j != null && k()) {
            jiVar.a(k);
            jiVar.a(this.f729j);
            jiVar.b();
        }
        if (this.f730k != null && l()) {
            jiVar.a(l);
            jiVar.a(this.f730k);
            jiVar.b();
        }
        if (m()) {
            jiVar.a(m);
            jiVar.a(this.f709a);
            jiVar.b();
        }
        if (n()) {
            jiVar.a(n);
            jiVar.a(this.f717b);
            jiVar.b();
        }
        if (this.f731l != null && o()) {
            jiVar.a(o);
            jiVar.a(this.f731l);
            jiVar.b();
        }
        if (this.f732m != null && p()) {
            jiVar.a(p);
            jiVar.a(this.f732m);
            jiVar.b();
        }
        if (this.f733n != null && q()) {
            jiVar.a(q);
            jiVar.a(this.f733n);
            jiVar.b();
        }
        if (this.f734o != null && r()) {
            jiVar.a(r);
            jiVar.a(this.f734o);
            jiVar.b();
        }
        if (s()) {
            jiVar.a(s);
            jiVar.a(this.f721c);
            jiVar.b();
        }
        if (this.f711a != null && t()) {
            jiVar.a(t);
            jiVar.a(this.f711a.a());
            jiVar.b();
        }
        if (u()) {
            jiVar.a(u);
            jiVar.a(this.f716a);
            jiVar.b();
        }
        if (v()) {
            jiVar.a(v);
            jiVar.a(this.f710a);
            jiVar.b();
        }
        if (w()) {
            jiVar.a(w);
            jiVar.a(this.f718b);
            jiVar.b();
        }
        if (this.f735p != null && x()) {
            jiVar.a(x);
            jiVar.a(this.f735p);
            jiVar.b();
        }
        if (this.f736q != null && y()) {
            jiVar.a(y);
            jiVar.a(this.f736q);
            jiVar.b();
        }
        if (this.f715a != null && z()) {
            jiVar.a(z);
            jiVar.a(new jh(Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, this.f715a.size()));
            for (Map.Entry<String, String> entry : this.f715a.entrySet()) {
                jiVar.a(entry.getKey());
                jiVar.a(entry.getValue());
            }
            jiVar.d();
            jiVar.b();
        }
        if (A()) {
            jiVar.a(A);
            jiVar.a(this.f720b);
            jiVar.b();
        }
        if (this.f737r != null && B()) {
            jiVar.a(B);
            jiVar.a(this.f737r);
            jiVar.b();
        }
        jiVar.c();
        jiVar.m523a();
    }

    public void b(boolean z2) {
        this.f714a.set(1, z2);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m474b() {
        return this.f712a != null;
    }

    public im c(int i2) {
        this.f721c = i2;
        c(true);
        return this;
    }

    public im c(String str) {
        this.f723d = str;
        return this;
    }

    public String c() {
        return this.f725f;
    }

    public void c(boolean z2) {
        this.f714a.set(2, z2);
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m475c() {
        return this.f719b != null;
    }

    public im d(String str) {
        this.f724e = str;
        return this;
    }

    public void d(boolean z2) {
        this.f714a.set(3, z2);
    }

    public boolean d() {
        return this.f722c != null;
    }

    public im e(String str) {
        this.f725f = str;
        return this;
    }

    public void e(boolean z2) {
        this.f714a.set(4, z2);
    }

    public boolean e() {
        return this.f723d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof im)) {
            return m473a((im) obj);
        }
        return false;
    }

    public im f(String str) {
        this.f726g = str;
        return this;
    }

    public void f(boolean z2) {
        this.f714a.set(5, z2);
    }

    public boolean f() {
        return this.f724e != null;
    }

    public im g(String str) {
        this.f727h = str;
        return this;
    }

    public void g(boolean z2) {
        this.f714a.set(6, z2);
    }

    public boolean g() {
        return this.f725f != null;
    }

    public im h(String str) {
        this.f730k = str;
        return this;
    }

    public boolean h() {
        return this.f726g != null;
    }

    public int hashCode() {
        return 0;
    }

    public im i(String str) {
        this.f731l = str;
        return this;
    }

    public boolean i() {
        return this.f727h != null;
    }

    public im j(String str) {
        this.f733n = str;
        return this;
    }

    public boolean j() {
        return this.f728i != null;
    }

    public im k(String str) {
        this.f734o = str;
        return this;
    }

    public boolean k() {
        return this.f729j != null;
    }

    public boolean l() {
        return this.f730k != null;
    }

    public boolean m() {
        return this.f714a.get(0);
    }

    public boolean n() {
        return this.f714a.get(1);
    }

    public boolean o() {
        return this.f731l != null;
    }

    public boolean p() {
        return this.f732m != null;
    }

    public boolean q() {
        return this.f733n != null;
    }

    public boolean r() {
        return this.f734o != null;
    }

    public boolean s() {
        return this.f714a.get(2);
    }

    public boolean t() {
        return this.f711a != null;
    }

    public String toString() {
        boolean z2 = false;
        StringBuilder sb = new StringBuilder("XmPushActionRegistration(");
        boolean z3 = true;
        if (m472a()) {
            sb.append("debug:");
            if (this.f713a == null) {
                sb.append("null");
            } else {
                sb.append(this.f713a);
            }
            z3 = false;
        }
        if (m474b()) {
            if (!z3) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f712a == null) {
                sb.append("null");
            } else {
                sb.append(this.f712a);
            }
        } else {
            z2 = z3;
        }
        if (!z2) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f719b == null) {
            sb.append("null");
        } else {
            sb.append(this.f719b);
        }
        sb.append(", ");
        sb.append("appId:");
        if (this.f722c == null) {
            sb.append("null");
        } else {
            sb.append(this.f722c);
        }
        if (e()) {
            sb.append(", ");
            sb.append("appVersion:");
            if (this.f723d == null) {
                sb.append("null");
            } else {
                sb.append(this.f723d);
            }
        }
        if (f()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f724e == null) {
                sb.append("null");
            } else {
                sb.append(this.f724e);
            }
        }
        sb.append(", ");
        sb.append("token:");
        if (this.f725f == null) {
            sb.append("null");
        } else {
            sb.append(this.f725f);
        }
        if (h()) {
            sb.append(", ");
            sb.append("deviceId:");
            if (this.f726g == null) {
                sb.append("null");
            } else {
                sb.append(this.f726g);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("aliasName:");
            if (this.f727h == null) {
                sb.append("null");
            } else {
                sb.append(this.f727h);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("sdkVersion:");
            if (this.f728i == null) {
                sb.append("null");
            } else {
                sb.append(this.f728i);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("regId:");
            if (this.f729j == null) {
                sb.append("null");
            } else {
                sb.append(this.f729j);
            }
        }
        if (l()) {
            sb.append(", ");
            sb.append("pushSdkVersionName:");
            if (this.f730k == null) {
                sb.append("null");
            } else {
                sb.append(this.f730k);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("pushSdkVersionCode:");
            sb.append(this.f709a);
        }
        if (n()) {
            sb.append(", ");
            sb.append("appVersionCode:");
            sb.append(this.f717b);
        }
        if (o()) {
            sb.append(", ");
            sb.append("androidId:");
            if (this.f731l == null) {
                sb.append("null");
            } else {
                sb.append(this.f731l);
            }
        }
        if (p()) {
            sb.append(", ");
            sb.append("imei:");
            if (this.f732m == null) {
                sb.append("null");
            } else {
                sb.append(this.f732m);
            }
        }
        if (q()) {
            sb.append(", ");
            sb.append("serial:");
            if (this.f733n == null) {
                sb.append("null");
            } else {
                sb.append(this.f733n);
            }
        }
        if (r()) {
            sb.append(", ");
            sb.append("imeiMd5:");
            if (this.f734o == null) {
                sb.append("null");
            } else {
                sb.append(this.f734o);
            }
        }
        if (s()) {
            sb.append(", ");
            sb.append("spaceId:");
            sb.append(this.f721c);
        }
        if (t()) {
            sb.append(", ");
            sb.append("reason:");
            if (this.f711a == null) {
                sb.append("null");
            } else {
                sb.append(this.f711a);
            }
        }
        if (u()) {
            sb.append(", ");
            sb.append("validateToken:");
            sb.append(this.f716a);
        }
        if (v()) {
            sb.append(", ");
            sb.append("miid:");
            sb.append(this.f710a);
        }
        if (w()) {
            sb.append(", ");
            sb.append("createdTs:");
            sb.append(this.f718b);
        }
        if (x()) {
            sb.append(", ");
            sb.append("subImei:");
            if (this.f735p == null) {
                sb.append("null");
            } else {
                sb.append(this.f735p);
            }
        }
        if (y()) {
            sb.append(", ");
            sb.append("subImeiMd5:");
            if (this.f736q == null) {
                sb.append("null");
            } else {
                sb.append(this.f736q);
            }
        }
        if (z()) {
            sb.append(", ");
            sb.append("connectionAttrs:");
            if (this.f715a == null) {
                sb.append("null");
            } else {
                sb.append(this.f715a);
            }
        }
        if (A()) {
            sb.append(", ");
            sb.append("cleanOldRegInfo:");
            sb.append(this.f720b);
        }
        if (B()) {
            sb.append(", ");
            sb.append("oldRegId:");
            if (this.f737r == null) {
                sb.append("null");
            } else {
                sb.append(this.f737r);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    public boolean u() {
        return this.f714a.get(3);
    }

    public boolean v() {
        return this.f714a.get(4);
    }

    public boolean w() {
        return this.f714a.get(5);
    }

    public boolean x() {
        return this.f735p != null;
    }

    public boolean y() {
        return this.f736q != null;
    }

    public boolean z() {
        return this.f715a != null;
    }
}
