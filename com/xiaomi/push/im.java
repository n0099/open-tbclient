package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes7.dex */
public class im implements ix<im, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public int f631a;

    /* renamed from: a  reason: collision with other field name */
    public long f632a;

    /* renamed from: a  reason: collision with other field name */
    public ia f633a;

    /* renamed from: a  reason: collision with other field name */
    public ib f634a;

    /* renamed from: a  reason: collision with other field name */
    public String f635a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f637a;

    /* renamed from: b  reason: collision with other field name */
    public int f639b;

    /* renamed from: b  reason: collision with other field name */
    public long f640b;

    /* renamed from: b  reason: collision with other field name */
    public String f641b;

    /* renamed from: c  reason: collision with other field name */
    public int f643c;

    /* renamed from: c  reason: collision with other field name */
    public String f644c;

    /* renamed from: d  reason: collision with other field name */
    public String f645d;

    /* renamed from: e  reason: collision with other field name */
    public String f646e;

    /* renamed from: f  reason: collision with other field name */
    public String f647f;

    /* renamed from: g  reason: collision with other field name */
    public String f648g;

    /* renamed from: h  reason: collision with other field name */
    public String f649h;

    /* renamed from: i  reason: collision with other field name */
    public String f650i;

    /* renamed from: j  reason: collision with other field name */
    public String f651j;

    /* renamed from: k  reason: collision with other field name */
    public String f652k;

    /* renamed from: l  reason: collision with other field name */
    public String f653l;

    /* renamed from: m  reason: collision with other field name */
    public String f654m;

    /* renamed from: n  reason: collision with other field name */
    public String f655n;

    /* renamed from: o  reason: collision with other field name */
    public String f656o;

    /* renamed from: p  reason: collision with other field name */
    public String f657p;

    /* renamed from: q  reason: collision with other field name */
    public String f658q;

    /* renamed from: r  reason: collision with other field name */
    public String f659r;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f630a = new jn("XmPushActionRegistration");
    private static final jf a = new jf("", Constants.GZIP_CAST_TYPE, 1);
    private static final jf b = new jf("", (byte) 12, 2);
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
    private BitSet f636a = new BitSet(7);

    /* renamed from: a  reason: collision with other field name */
    public boolean f638a = true;

    /* renamed from: b  reason: collision with other field name */
    public boolean f642b = false;

    public boolean A() {
        return this.f636a.get(6);
    }

    public boolean B() {
        return this.f659r != null;
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
            int compareTo = Boolean.valueOf(m442a()).compareTo(Boolean.valueOf(imVar.m442a()));
            if (compareTo == 0) {
                if (!m442a() || (a29 = iy.a(this.f635a, imVar.f635a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m444b()).compareTo(Boolean.valueOf(imVar.m444b()));
                    if (compareTo2 == 0) {
                        if (!m444b() || (a28 = iy.a(this.f634a, imVar.f634a)) == 0) {
                            int compareTo3 = Boolean.valueOf(m445c()).compareTo(Boolean.valueOf(imVar.m445c()));
                            if (compareTo3 == 0) {
                                if (!m445c() || (a27 = iy.a(this.f641b, imVar.f641b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(imVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a26 = iy.a(this.f644c, imVar.f644c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(imVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a25 = iy.a(this.f645d, imVar.f645d)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(imVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a24 = iy.a(this.f646e, imVar.f646e)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(imVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a23 = iy.a(this.f647f, imVar.f647f)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(imVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a22 = iy.a(this.f648g, imVar.f648g)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(imVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a21 = iy.a(this.f649h, imVar.f649h)) == 0) {
                                                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(imVar.j()));
                                                                                    if (compareTo10 == 0) {
                                                                                        if (!j() || (a20 = iy.a(this.f650i, imVar.f650i)) == 0) {
                                                                                            int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(imVar.k()));
                                                                                            if (compareTo11 == 0) {
                                                                                                if (!k() || (a19 = iy.a(this.f651j, imVar.f651j)) == 0) {
                                                                                                    int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(imVar.l()));
                                                                                                    if (compareTo12 == 0) {
                                                                                                        if (!l() || (a18 = iy.a(this.f652k, imVar.f652k)) == 0) {
                                                                                                            int compareTo13 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(imVar.m()));
                                                                                                            if (compareTo13 == 0) {
                                                                                                                if (!m() || (a17 = iy.a(this.f631a, imVar.f631a)) == 0) {
                                                                                                                    int compareTo14 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(imVar.n()));
                                                                                                                    if (compareTo14 == 0) {
                                                                                                                        if (!n() || (a16 = iy.a(this.f639b, imVar.f639b)) == 0) {
                                                                                                                            int compareTo15 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(imVar.o()));
                                                                                                                            if (compareTo15 == 0) {
                                                                                                                                if (!o() || (a15 = iy.a(this.f653l, imVar.f653l)) == 0) {
                                                                                                                                    int compareTo16 = Boolean.valueOf(p()).compareTo(Boolean.valueOf(imVar.p()));
                                                                                                                                    if (compareTo16 == 0) {
                                                                                                                                        if (!p() || (a14 = iy.a(this.f654m, imVar.f654m)) == 0) {
                                                                                                                                            int compareTo17 = Boolean.valueOf(q()).compareTo(Boolean.valueOf(imVar.q()));
                                                                                                                                            if (compareTo17 == 0) {
                                                                                                                                                if (!q() || (a13 = iy.a(this.f655n, imVar.f655n)) == 0) {
                                                                                                                                                    int compareTo18 = Boolean.valueOf(r()).compareTo(Boolean.valueOf(imVar.r()));
                                                                                                                                                    if (compareTo18 == 0) {
                                                                                                                                                        if (!r() || (a12 = iy.a(this.f656o, imVar.f656o)) == 0) {
                                                                                                                                                            int compareTo19 = Boolean.valueOf(s()).compareTo(Boolean.valueOf(imVar.s()));
                                                                                                                                                            if (compareTo19 == 0) {
                                                                                                                                                                if (!s() || (a11 = iy.a(this.f643c, imVar.f643c)) == 0) {
                                                                                                                                                                    int compareTo20 = Boolean.valueOf(t()).compareTo(Boolean.valueOf(imVar.t()));
                                                                                                                                                                    if (compareTo20 == 0) {
                                                                                                                                                                        if (!t() || (a10 = iy.a(this.f633a, imVar.f633a)) == 0) {
                                                                                                                                                                            int compareTo21 = Boolean.valueOf(u()).compareTo(Boolean.valueOf(imVar.u()));
                                                                                                                                                                            if (compareTo21 == 0) {
                                                                                                                                                                                if (!u() || (a9 = iy.a(this.f638a, imVar.f638a)) == 0) {
                                                                                                                                                                                    int compareTo22 = Boolean.valueOf(v()).compareTo(Boolean.valueOf(imVar.v()));
                                                                                                                                                                                    if (compareTo22 == 0) {
                                                                                                                                                                                        if (!v() || (a8 = iy.a(this.f632a, imVar.f632a)) == 0) {
                                                                                                                                                                                            int compareTo23 = Boolean.valueOf(w()).compareTo(Boolean.valueOf(imVar.w()));
                                                                                                                                                                                            if (compareTo23 == 0) {
                                                                                                                                                                                                if (!w() || (a7 = iy.a(this.f640b, imVar.f640b)) == 0) {
                                                                                                                                                                                                    int compareTo24 = Boolean.valueOf(x()).compareTo(Boolean.valueOf(imVar.x()));
                                                                                                                                                                                                    if (compareTo24 == 0) {
                                                                                                                                                                                                        if (!x() || (a6 = iy.a(this.f657p, imVar.f657p)) == 0) {
                                                                                                                                                                                                            int compareTo25 = Boolean.valueOf(y()).compareTo(Boolean.valueOf(imVar.y()));
                                                                                                                                                                                                            if (compareTo25 == 0) {
                                                                                                                                                                                                                if (!y() || (a5 = iy.a(this.f658q, imVar.f658q)) == 0) {
                                                                                                                                                                                                                    int compareTo26 = Boolean.valueOf(z()).compareTo(Boolean.valueOf(imVar.z()));
                                                                                                                                                                                                                    if (compareTo26 == 0) {
                                                                                                                                                                                                                        if (!z() || (a4 = iy.a(this.f637a, imVar.f637a)) == 0) {
                                                                                                                                                                                                                            int compareTo27 = Boolean.valueOf(A()).compareTo(Boolean.valueOf(imVar.A()));
                                                                                                                                                                                                                            if (compareTo27 == 0) {
                                                                                                                                                                                                                                if (!A() || (a3 = iy.a(this.f642b, imVar.f642b)) == 0) {
                                                                                                                                                                                                                                    int compareTo28 = Boolean.valueOf(B()).compareTo(Boolean.valueOf(imVar.B()));
                                                                                                                                                                                                                                    if (compareTo28 == 0) {
                                                                                                                                                                                                                                        if (!B() || (a2 = iy.a(this.f659r, imVar.f659r)) == 0) {
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
        this.f631a = i2;
        a(true);
        return this;
    }

    public im a(ia iaVar) {
        this.f633a = iaVar;
        return this;
    }

    public im a(String str) {
        this.f641b = str;
        return this;
    }

    public String a() {
        return this.f641b;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m441a() {
        if (this.f641b == null) {
            throw new jj("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f644c == null) {
            throw new jj("Required field 'appId' was not present! Struct: " + toString());
        }
        if (this.f647f == null) {
            throw new jj("Required field 'token' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m489a();
        while (true) {
            jf m485a = jiVar.m485a();
            if (m485a.a == 0) {
                jiVar.f();
                m441a();
                return;
            }
            switch (m485a.f780a) {
                case 1:
                    if (m485a.a == 11) {
                        this.f635a = jiVar.m490a();
                        break;
                    } else {
                        jl.a(jiVar, m485a.a);
                        break;
                    }
                case 2:
                    if (m485a.a == 12) {
                        this.f634a = new ib();
                        this.f634a.a(jiVar);
                        break;
                    } else {
                        jl.a(jiVar, m485a.a);
                        break;
                    }
                case 3:
                    if (m485a.a == 11) {
                        this.f641b = jiVar.m490a();
                        break;
                    } else {
                        jl.a(jiVar, m485a.a);
                        break;
                    }
                case 4:
                    if (m485a.a == 11) {
                        this.f644c = jiVar.m490a();
                        break;
                    } else {
                        jl.a(jiVar, m485a.a);
                        break;
                    }
                case 5:
                    if (m485a.a == 11) {
                        this.f645d = jiVar.m490a();
                        break;
                    } else {
                        jl.a(jiVar, m485a.a);
                        break;
                    }
                case 6:
                    if (m485a.a == 11) {
                        this.f646e = jiVar.m490a();
                        break;
                    } else {
                        jl.a(jiVar, m485a.a);
                        break;
                    }
                case 7:
                    if (m485a.a == 11) {
                        this.f647f = jiVar.m490a();
                        break;
                    } else {
                        jl.a(jiVar, m485a.a);
                        break;
                    }
                case 8:
                    if (m485a.a == 11) {
                        this.f648g = jiVar.m490a();
                        break;
                    } else {
                        jl.a(jiVar, m485a.a);
                        break;
                    }
                case 9:
                    if (m485a.a == 11) {
                        this.f649h = jiVar.m490a();
                        break;
                    } else {
                        jl.a(jiVar, m485a.a);
                        break;
                    }
                case 10:
                    if (m485a.a == 11) {
                        this.f650i = jiVar.m490a();
                        break;
                    } else {
                        jl.a(jiVar, m485a.a);
                        break;
                    }
                case 11:
                    if (m485a.a == 11) {
                        this.f651j = jiVar.m490a();
                        break;
                    } else {
                        jl.a(jiVar, m485a.a);
                        break;
                    }
                case 12:
                    if (m485a.a == 11) {
                        this.f652k = jiVar.m490a();
                        break;
                    } else {
                        jl.a(jiVar, m485a.a);
                        break;
                    }
                case 13:
                    if (m485a.a == 8) {
                        this.f631a = jiVar.m483a();
                        a(true);
                        break;
                    } else {
                        jl.a(jiVar, m485a.a);
                        break;
                    }
                case 14:
                    if (m485a.a == 8) {
                        this.f639b = jiVar.m483a();
                        b(true);
                        break;
                    } else {
                        jl.a(jiVar, m485a.a);
                        break;
                    }
                case 15:
                    if (m485a.a == 11) {
                        this.f653l = jiVar.m490a();
                        break;
                    } else {
                        jl.a(jiVar, m485a.a);
                        break;
                    }
                case 16:
                    if (m485a.a == 11) {
                        this.f654m = jiVar.m490a();
                        break;
                    } else {
                        jl.a(jiVar, m485a.a);
                        break;
                    }
                case 17:
                    if (m485a.a == 11) {
                        this.f655n = jiVar.m490a();
                        break;
                    } else {
                        jl.a(jiVar, m485a.a);
                        break;
                    }
                case 18:
                    if (m485a.a == 11) {
                        this.f656o = jiVar.m490a();
                        break;
                    } else {
                        jl.a(jiVar, m485a.a);
                        break;
                    }
                case 19:
                    if (m485a.a == 8) {
                        this.f643c = jiVar.m483a();
                        c(true);
                        break;
                    } else {
                        jl.a(jiVar, m485a.a);
                        break;
                    }
                case 20:
                    if (m485a.a == 8) {
                        this.f633a = ia.a(jiVar.m483a());
                        break;
                    } else {
                        jl.a(jiVar, m485a.a);
                        break;
                    }
                case 21:
                    if (m485a.a == 2) {
                        this.f638a = jiVar.m494a();
                        d(true);
                        break;
                    } else {
                        jl.a(jiVar, m485a.a);
                        break;
                    }
                case 22:
                    if (m485a.a == 10) {
                        this.f632a = jiVar.m484a();
                        e(true);
                        break;
                    } else {
                        jl.a(jiVar, m485a.a);
                        break;
                    }
                case 23:
                    if (m485a.a == 10) {
                        this.f640b = jiVar.m484a();
                        f(true);
                        break;
                    } else {
                        jl.a(jiVar, m485a.a);
                        break;
                    }
                case 24:
                    if (m485a.a == 11) {
                        this.f657p = jiVar.m490a();
                        break;
                    } else {
                        jl.a(jiVar, m485a.a);
                        break;
                    }
                case 25:
                    if (m485a.a == 11) {
                        this.f658q = jiVar.m490a();
                        break;
                    } else {
                        jl.a(jiVar, m485a.a);
                        break;
                    }
                case 100:
                    if (m485a.a == 13) {
                        jh m487a = jiVar.m487a();
                        this.f637a = new HashMap(m487a.f782a * 2);
                        for (int i2 = 0; i2 < m487a.f782a; i2++) {
                            this.f637a.put(jiVar.m490a(), jiVar.m490a());
                        }
                        jiVar.h();
                        break;
                    } else {
                        jl.a(jiVar, m485a.a);
                        break;
                    }
                case 101:
                    if (m485a.a == 2) {
                        this.f642b = jiVar.m494a();
                        g(true);
                        break;
                    } else {
                        jl.a(jiVar, m485a.a);
                        break;
                    }
                case 102:
                    if (m485a.a == 11) {
                        this.f659r = jiVar.m490a();
                        break;
                    } else {
                        jl.a(jiVar, m485a.a);
                        break;
                    }
                default:
                    jl.a(jiVar, m485a.a);
                    break;
            }
            jiVar.g();
        }
    }

    public void a(boolean z2) {
        this.f636a.set(0, z2);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m442a() {
        return this.f635a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m443a(im imVar) {
        if (imVar == null) {
            return false;
        }
        boolean m442a = m442a();
        boolean m442a2 = imVar.m442a();
        if ((m442a || m442a2) && !(m442a && m442a2 && this.f635a.equals(imVar.f635a))) {
            return false;
        }
        boolean m444b = m444b();
        boolean m444b2 = imVar.m444b();
        if ((m444b || m444b2) && !(m444b && m444b2 && this.f634a.m398a(imVar.f634a))) {
            return false;
        }
        boolean m445c = m445c();
        boolean m445c2 = imVar.m445c();
        if ((m445c || m445c2) && !(m445c && m445c2 && this.f641b.equals(imVar.f641b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = imVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f644c.equals(imVar.f644c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = imVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f645d.equals(imVar.f645d))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = imVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f646e.equals(imVar.f646e))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = imVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f647f.equals(imVar.f647f))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = imVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f648g.equals(imVar.f648g))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = imVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f649h.equals(imVar.f649h))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = imVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f650i.equals(imVar.f650i))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = imVar.k();
        if ((k2 || k3) && !(k2 && k3 && this.f651j.equals(imVar.f651j))) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = imVar.l();
        if ((l2 || l3) && !(l2 && l3 && this.f652k.equals(imVar.f652k))) {
            return false;
        }
        boolean m2 = m();
        boolean m3 = imVar.m();
        if ((m2 || m3) && !(m2 && m3 && this.f631a == imVar.f631a)) {
            return false;
        }
        boolean n2 = n();
        boolean n3 = imVar.n();
        if ((n2 || n3) && !(n2 && n3 && this.f639b == imVar.f639b)) {
            return false;
        }
        boolean o2 = o();
        boolean o3 = imVar.o();
        if ((o2 || o3) && !(o2 && o3 && this.f653l.equals(imVar.f653l))) {
            return false;
        }
        boolean p2 = p();
        boolean p3 = imVar.p();
        if ((p2 || p3) && !(p2 && p3 && this.f654m.equals(imVar.f654m))) {
            return false;
        }
        boolean q2 = q();
        boolean q3 = imVar.q();
        if ((q2 || q3) && !(q2 && q3 && this.f655n.equals(imVar.f655n))) {
            return false;
        }
        boolean r2 = r();
        boolean r3 = imVar.r();
        if ((r2 || r3) && !(r2 && r3 && this.f656o.equals(imVar.f656o))) {
            return false;
        }
        boolean s2 = s();
        boolean s3 = imVar.s();
        if ((s2 || s3) && !(s2 && s3 && this.f643c == imVar.f643c)) {
            return false;
        }
        boolean t2 = t();
        boolean t3 = imVar.t();
        if ((t2 || t3) && !(t2 && t3 && this.f633a.equals(imVar.f633a))) {
            return false;
        }
        boolean u2 = u();
        boolean u3 = imVar.u();
        if ((u2 || u3) && !(u2 && u3 && this.f638a == imVar.f638a)) {
            return false;
        }
        boolean v2 = v();
        boolean v3 = imVar.v();
        if ((v2 || v3) && !(v2 && v3 && this.f632a == imVar.f632a)) {
            return false;
        }
        boolean w2 = w();
        boolean w3 = imVar.w();
        if ((w2 || w3) && !(w2 && w3 && this.f640b == imVar.f640b)) {
            return false;
        }
        boolean x2 = x();
        boolean x3 = imVar.x();
        if ((x2 || x3) && !(x2 && x3 && this.f657p.equals(imVar.f657p))) {
            return false;
        }
        boolean y2 = y();
        boolean y3 = imVar.y();
        if ((y2 || y3) && !(y2 && y3 && this.f658q.equals(imVar.f658q))) {
            return false;
        }
        boolean z2 = z();
        boolean z3 = imVar.z();
        if ((z2 || z3) && !(z2 && z3 && this.f637a.equals(imVar.f637a))) {
            return false;
        }
        boolean A2 = A();
        boolean A3 = imVar.A();
        if ((A2 || A3) && !(A2 && A3 && this.f642b == imVar.f642b)) {
            return false;
        }
        boolean B2 = B();
        boolean B3 = imVar.B();
        return !(B2 || B3) || (B2 && B3 && this.f659r.equals(imVar.f659r));
    }

    public im b(int i2) {
        this.f639b = i2;
        b(true);
        return this;
    }

    public im b(String str) {
        this.f644c = str;
        return this;
    }

    public String b() {
        return this.f644c;
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        m441a();
        jiVar.a(f630a);
        if (this.f635a != null && m442a()) {
            jiVar.a(a);
            jiVar.a(this.f635a);
            jiVar.b();
        }
        if (this.f634a != null && m444b()) {
            jiVar.a(b);
            this.f634a.b(jiVar);
            jiVar.b();
        }
        if (this.f641b != null) {
            jiVar.a(c);
            jiVar.a(this.f641b);
            jiVar.b();
        }
        if (this.f644c != null) {
            jiVar.a(d);
            jiVar.a(this.f644c);
            jiVar.b();
        }
        if (this.f645d != null && e()) {
            jiVar.a(e);
            jiVar.a(this.f645d);
            jiVar.b();
        }
        if (this.f646e != null && f()) {
            jiVar.a(f);
            jiVar.a(this.f646e);
            jiVar.b();
        }
        if (this.f647f != null) {
            jiVar.a(g);
            jiVar.a(this.f647f);
            jiVar.b();
        }
        if (this.f648g != null && h()) {
            jiVar.a(h);
            jiVar.a(this.f648g);
            jiVar.b();
        }
        if (this.f649h != null && i()) {
            jiVar.a(i);
            jiVar.a(this.f649h);
            jiVar.b();
        }
        if (this.f650i != null && j()) {
            jiVar.a(j);
            jiVar.a(this.f650i);
            jiVar.b();
        }
        if (this.f651j != null && k()) {
            jiVar.a(k);
            jiVar.a(this.f651j);
            jiVar.b();
        }
        if (this.f652k != null && l()) {
            jiVar.a(l);
            jiVar.a(this.f652k);
            jiVar.b();
        }
        if (m()) {
            jiVar.a(m);
            jiVar.a(this.f631a);
            jiVar.b();
        }
        if (n()) {
            jiVar.a(n);
            jiVar.a(this.f639b);
            jiVar.b();
        }
        if (this.f653l != null && o()) {
            jiVar.a(o);
            jiVar.a(this.f653l);
            jiVar.b();
        }
        if (this.f654m != null && p()) {
            jiVar.a(p);
            jiVar.a(this.f654m);
            jiVar.b();
        }
        if (this.f655n != null && q()) {
            jiVar.a(q);
            jiVar.a(this.f655n);
            jiVar.b();
        }
        if (this.f656o != null && r()) {
            jiVar.a(r);
            jiVar.a(this.f656o);
            jiVar.b();
        }
        if (s()) {
            jiVar.a(s);
            jiVar.a(this.f643c);
            jiVar.b();
        }
        if (this.f633a != null && t()) {
            jiVar.a(t);
            jiVar.a(this.f633a.a());
            jiVar.b();
        }
        if (u()) {
            jiVar.a(u);
            jiVar.a(this.f638a);
            jiVar.b();
        }
        if (v()) {
            jiVar.a(v);
            jiVar.a(this.f632a);
            jiVar.b();
        }
        if (w()) {
            jiVar.a(w);
            jiVar.a(this.f640b);
            jiVar.b();
        }
        if (this.f657p != null && x()) {
            jiVar.a(x);
            jiVar.a(this.f657p);
            jiVar.b();
        }
        if (this.f658q != null && y()) {
            jiVar.a(y);
            jiVar.a(this.f658q);
            jiVar.b();
        }
        if (this.f637a != null && z()) {
            jiVar.a(z);
            jiVar.a(new jh(Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, this.f637a.size()));
            for (Map.Entry<String, String> entry : this.f637a.entrySet()) {
                jiVar.a(entry.getKey());
                jiVar.a(entry.getValue());
            }
            jiVar.d();
            jiVar.b();
        }
        if (A()) {
            jiVar.a(A);
            jiVar.a(this.f642b);
            jiVar.b();
        }
        if (this.f659r != null && B()) {
            jiVar.a(B);
            jiVar.a(this.f659r);
            jiVar.b();
        }
        jiVar.c();
        jiVar.m493a();
    }

    public void b(boolean z2) {
        this.f636a.set(1, z2);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m444b() {
        return this.f634a != null;
    }

    public im c(int i2) {
        this.f643c = i2;
        c(true);
        return this;
    }

    public im c(String str) {
        this.f645d = str;
        return this;
    }

    public String c() {
        return this.f647f;
    }

    public void c(boolean z2) {
        this.f636a.set(2, z2);
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m445c() {
        return this.f641b != null;
    }

    public im d(String str) {
        this.f646e = str;
        return this;
    }

    public void d(boolean z2) {
        this.f636a.set(3, z2);
    }

    public boolean d() {
        return this.f644c != null;
    }

    public im e(String str) {
        this.f647f = str;
        return this;
    }

    public void e(boolean z2) {
        this.f636a.set(4, z2);
    }

    public boolean e() {
        return this.f645d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof im)) {
            return m443a((im) obj);
        }
        return false;
    }

    public im f(String str) {
        this.f648g = str;
        return this;
    }

    public void f(boolean z2) {
        this.f636a.set(5, z2);
    }

    public boolean f() {
        return this.f646e != null;
    }

    public im g(String str) {
        this.f649h = str;
        return this;
    }

    public void g(boolean z2) {
        this.f636a.set(6, z2);
    }

    public boolean g() {
        return this.f647f != null;
    }

    public im h(String str) {
        this.f652k = str;
        return this;
    }

    public boolean h() {
        return this.f648g != null;
    }

    public int hashCode() {
        return 0;
    }

    public im i(String str) {
        this.f653l = str;
        return this;
    }

    public boolean i() {
        return this.f649h != null;
    }

    public im j(String str) {
        this.f655n = str;
        return this;
    }

    public boolean j() {
        return this.f650i != null;
    }

    public im k(String str) {
        this.f656o = str;
        return this;
    }

    public boolean k() {
        return this.f651j != null;
    }

    public boolean l() {
        return this.f652k != null;
    }

    public boolean m() {
        return this.f636a.get(0);
    }

    public boolean n() {
        return this.f636a.get(1);
    }

    public boolean o() {
        return this.f653l != null;
    }

    public boolean p() {
        return this.f654m != null;
    }

    public boolean q() {
        return this.f655n != null;
    }

    public boolean r() {
        return this.f656o != null;
    }

    public boolean s() {
        return this.f636a.get(2);
    }

    public boolean t() {
        return this.f633a != null;
    }

    public String toString() {
        boolean z2 = false;
        StringBuilder sb = new StringBuilder("XmPushActionRegistration(");
        boolean z3 = true;
        if (m442a()) {
            sb.append("debug:");
            if (this.f635a == null) {
                sb.append("null");
            } else {
                sb.append(this.f635a);
            }
            z3 = false;
        }
        if (m444b()) {
            if (!z3) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f634a == null) {
                sb.append("null");
            } else {
                sb.append(this.f634a);
            }
        } else {
            z2 = z3;
        }
        if (!z2) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f641b == null) {
            sb.append("null");
        } else {
            sb.append(this.f641b);
        }
        sb.append(", ");
        sb.append("appId:");
        if (this.f644c == null) {
            sb.append("null");
        } else {
            sb.append(this.f644c);
        }
        if (e()) {
            sb.append(", ");
            sb.append("appVersion:");
            if (this.f645d == null) {
                sb.append("null");
            } else {
                sb.append(this.f645d);
            }
        }
        if (f()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f646e == null) {
                sb.append("null");
            } else {
                sb.append(this.f646e);
            }
        }
        sb.append(", ");
        sb.append("token:");
        if (this.f647f == null) {
            sb.append("null");
        } else {
            sb.append(this.f647f);
        }
        if (h()) {
            sb.append(", ");
            sb.append("deviceId:");
            if (this.f648g == null) {
                sb.append("null");
            } else {
                sb.append(this.f648g);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("aliasName:");
            if (this.f649h == null) {
                sb.append("null");
            } else {
                sb.append(this.f649h);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("sdkVersion:");
            if (this.f650i == null) {
                sb.append("null");
            } else {
                sb.append(this.f650i);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("regId:");
            if (this.f651j == null) {
                sb.append("null");
            } else {
                sb.append(this.f651j);
            }
        }
        if (l()) {
            sb.append(", ");
            sb.append("pushSdkVersionName:");
            if (this.f652k == null) {
                sb.append("null");
            } else {
                sb.append(this.f652k);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("pushSdkVersionCode:");
            sb.append(this.f631a);
        }
        if (n()) {
            sb.append(", ");
            sb.append("appVersionCode:");
            sb.append(this.f639b);
        }
        if (o()) {
            sb.append(", ");
            sb.append("androidId:");
            if (this.f653l == null) {
                sb.append("null");
            } else {
                sb.append(this.f653l);
            }
        }
        if (p()) {
            sb.append(", ");
            sb.append("imei:");
            if (this.f654m == null) {
                sb.append("null");
            } else {
                sb.append(this.f654m);
            }
        }
        if (q()) {
            sb.append(", ");
            sb.append("serial:");
            if (this.f655n == null) {
                sb.append("null");
            } else {
                sb.append(this.f655n);
            }
        }
        if (r()) {
            sb.append(", ");
            sb.append("imeiMd5:");
            if (this.f656o == null) {
                sb.append("null");
            } else {
                sb.append(this.f656o);
            }
        }
        if (s()) {
            sb.append(", ");
            sb.append("spaceId:");
            sb.append(this.f643c);
        }
        if (t()) {
            sb.append(", ");
            sb.append("reason:");
            if (this.f633a == null) {
                sb.append("null");
            } else {
                sb.append(this.f633a);
            }
        }
        if (u()) {
            sb.append(", ");
            sb.append("validateToken:");
            sb.append(this.f638a);
        }
        if (v()) {
            sb.append(", ");
            sb.append("miid:");
            sb.append(this.f632a);
        }
        if (w()) {
            sb.append(", ");
            sb.append("createdTs:");
            sb.append(this.f640b);
        }
        if (x()) {
            sb.append(", ");
            sb.append("subImei:");
            if (this.f657p == null) {
                sb.append("null");
            } else {
                sb.append(this.f657p);
            }
        }
        if (y()) {
            sb.append(", ");
            sb.append("subImeiMd5:");
            if (this.f658q == null) {
                sb.append("null");
            } else {
                sb.append(this.f658q);
            }
        }
        if (z()) {
            sb.append(", ");
            sb.append("connectionAttrs:");
            if (this.f637a == null) {
                sb.append("null");
            } else {
                sb.append(this.f637a);
            }
        }
        if (A()) {
            sb.append(", ");
            sb.append("cleanOldRegInfo:");
            sb.append(this.f642b);
        }
        if (B()) {
            sb.append(", ");
            sb.append("oldRegId:");
            if (this.f659r == null) {
                sb.append("null");
            } else {
                sb.append(this.f659r);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    public boolean u() {
        return this.f636a.get(3);
    }

    public boolean v() {
        return this.f636a.get(4);
    }

    public boolean w() {
        return this.f636a.get(5);
    }

    public boolean x() {
        return this.f657p != null;
    }

    public boolean y() {
        return this.f658q != null;
    }

    public boolean z() {
        return this.f637a != null;
    }
}
