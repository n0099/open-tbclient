package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes18.dex */
public class im implements ix<im, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public int f632a;

    /* renamed from: a  reason: collision with other field name */
    public long f633a;

    /* renamed from: a  reason: collision with other field name */
    public ia f634a;

    /* renamed from: a  reason: collision with other field name */
    public ib f635a;

    /* renamed from: a  reason: collision with other field name */
    public String f636a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f638a;

    /* renamed from: b  reason: collision with other field name */
    public int f640b;

    /* renamed from: b  reason: collision with other field name */
    public long f641b;

    /* renamed from: b  reason: collision with other field name */
    public String f642b;

    /* renamed from: c  reason: collision with other field name */
    public int f644c;

    /* renamed from: c  reason: collision with other field name */
    public String f645c;

    /* renamed from: d  reason: collision with other field name */
    public String f646d;

    /* renamed from: e  reason: collision with other field name */
    public String f647e;

    /* renamed from: f  reason: collision with other field name */
    public String f648f;

    /* renamed from: g  reason: collision with other field name */
    public String f649g;

    /* renamed from: h  reason: collision with other field name */
    public String f650h;

    /* renamed from: i  reason: collision with other field name */
    public String f651i;

    /* renamed from: j  reason: collision with other field name */
    public String f652j;

    /* renamed from: k  reason: collision with other field name */
    public String f653k;

    /* renamed from: l  reason: collision with other field name */
    public String f654l;

    /* renamed from: m  reason: collision with other field name */
    public String f655m;

    /* renamed from: n  reason: collision with other field name */
    public String f656n;

    /* renamed from: o  reason: collision with other field name */
    public String f657o;

    /* renamed from: p  reason: collision with other field name */
    public String f658p;

    /* renamed from: q  reason: collision with other field name */
    public String f659q;

    /* renamed from: r  reason: collision with other field name */
    public String f660r;

    /* renamed from: a  reason: collision with other field name */
    private static final jn f631a = new jn("XmPushActionRegistration");

    /* renamed from: a  reason: collision with root package name */
    private static final jf f4982a = new jf("", Constants.GZIP_CAST_TYPE, 1);
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
    private BitSet f637a = new BitSet(7);

    /* renamed from: a  reason: collision with other field name */
    public boolean f639a = true;

    /* renamed from: b  reason: collision with other field name */
    public boolean f643b = false;

    public boolean A() {
        return this.f637a.get(6);
    }

    public boolean B() {
        return this.f660r != null;
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
            int compareTo = Boolean.valueOf(m445a()).compareTo(Boolean.valueOf(imVar.m445a()));
            if (compareTo == 0) {
                if (!m445a() || (a29 = iy.a(this.f636a, imVar.f636a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m447b()).compareTo(Boolean.valueOf(imVar.m447b()));
                    if (compareTo2 == 0) {
                        if (!m447b() || (a28 = iy.a(this.f635a, imVar.f635a)) == 0) {
                            int compareTo3 = Boolean.valueOf(m448c()).compareTo(Boolean.valueOf(imVar.m448c()));
                            if (compareTo3 == 0) {
                                if (!m448c() || (a27 = iy.a(this.f642b, imVar.f642b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(imVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a26 = iy.a(this.f645c, imVar.f645c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(imVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a25 = iy.a(this.f646d, imVar.f646d)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(imVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a24 = iy.a(this.f647e, imVar.f647e)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(imVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a23 = iy.a(this.f648f, imVar.f648f)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(imVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a22 = iy.a(this.f649g, imVar.f649g)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(imVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a21 = iy.a(this.f650h, imVar.f650h)) == 0) {
                                                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(imVar.j()));
                                                                                    if (compareTo10 == 0) {
                                                                                        if (!j() || (a20 = iy.a(this.f651i, imVar.f651i)) == 0) {
                                                                                            int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(imVar.k()));
                                                                                            if (compareTo11 == 0) {
                                                                                                if (!k() || (a19 = iy.a(this.f652j, imVar.f652j)) == 0) {
                                                                                                    int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(imVar.l()));
                                                                                                    if (compareTo12 == 0) {
                                                                                                        if (!l() || (a18 = iy.a(this.f653k, imVar.f653k)) == 0) {
                                                                                                            int compareTo13 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(imVar.m()));
                                                                                                            if (compareTo13 == 0) {
                                                                                                                if (!m() || (a17 = iy.a(this.f632a, imVar.f632a)) == 0) {
                                                                                                                    int compareTo14 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(imVar.n()));
                                                                                                                    if (compareTo14 == 0) {
                                                                                                                        if (!n() || (a16 = iy.a(this.f640b, imVar.f640b)) == 0) {
                                                                                                                            int compareTo15 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(imVar.o()));
                                                                                                                            if (compareTo15 == 0) {
                                                                                                                                if (!o() || (a15 = iy.a(this.f654l, imVar.f654l)) == 0) {
                                                                                                                                    int compareTo16 = Boolean.valueOf(p()).compareTo(Boolean.valueOf(imVar.p()));
                                                                                                                                    if (compareTo16 == 0) {
                                                                                                                                        if (!p() || (a14 = iy.a(this.f655m, imVar.f655m)) == 0) {
                                                                                                                                            int compareTo17 = Boolean.valueOf(q()).compareTo(Boolean.valueOf(imVar.q()));
                                                                                                                                            if (compareTo17 == 0) {
                                                                                                                                                if (!q() || (a13 = iy.a(this.f656n, imVar.f656n)) == 0) {
                                                                                                                                                    int compareTo18 = Boolean.valueOf(r()).compareTo(Boolean.valueOf(imVar.r()));
                                                                                                                                                    if (compareTo18 == 0) {
                                                                                                                                                        if (!r() || (a12 = iy.a(this.f657o, imVar.f657o)) == 0) {
                                                                                                                                                            int compareTo19 = Boolean.valueOf(s()).compareTo(Boolean.valueOf(imVar.s()));
                                                                                                                                                            if (compareTo19 == 0) {
                                                                                                                                                                if (!s() || (a11 = iy.a(this.f644c, imVar.f644c)) == 0) {
                                                                                                                                                                    int compareTo20 = Boolean.valueOf(t()).compareTo(Boolean.valueOf(imVar.t()));
                                                                                                                                                                    if (compareTo20 == 0) {
                                                                                                                                                                        if (!t() || (a10 = iy.a(this.f634a, imVar.f634a)) == 0) {
                                                                                                                                                                            int compareTo21 = Boolean.valueOf(u()).compareTo(Boolean.valueOf(imVar.u()));
                                                                                                                                                                            if (compareTo21 == 0) {
                                                                                                                                                                                if (!u() || (a9 = iy.a(this.f639a, imVar.f639a)) == 0) {
                                                                                                                                                                                    int compareTo22 = Boolean.valueOf(v()).compareTo(Boolean.valueOf(imVar.v()));
                                                                                                                                                                                    if (compareTo22 == 0) {
                                                                                                                                                                                        if (!v() || (a8 = iy.a(this.f633a, imVar.f633a)) == 0) {
                                                                                                                                                                                            int compareTo23 = Boolean.valueOf(w()).compareTo(Boolean.valueOf(imVar.w()));
                                                                                                                                                                                            if (compareTo23 == 0) {
                                                                                                                                                                                                if (!w() || (a7 = iy.a(this.f641b, imVar.f641b)) == 0) {
                                                                                                                                                                                                    int compareTo24 = Boolean.valueOf(x()).compareTo(Boolean.valueOf(imVar.x()));
                                                                                                                                                                                                    if (compareTo24 == 0) {
                                                                                                                                                                                                        if (!x() || (a6 = iy.a(this.f658p, imVar.f658p)) == 0) {
                                                                                                                                                                                                            int compareTo25 = Boolean.valueOf(y()).compareTo(Boolean.valueOf(imVar.y()));
                                                                                                                                                                                                            if (compareTo25 == 0) {
                                                                                                                                                                                                                if (!y() || (a5 = iy.a(this.f659q, imVar.f659q)) == 0) {
                                                                                                                                                                                                                    int compareTo26 = Boolean.valueOf(z()).compareTo(Boolean.valueOf(imVar.z()));
                                                                                                                                                                                                                    if (compareTo26 == 0) {
                                                                                                                                                                                                                        if (!z() || (a4 = iy.a(this.f638a, imVar.f638a)) == 0) {
                                                                                                                                                                                                                            int compareTo27 = Boolean.valueOf(A()).compareTo(Boolean.valueOf(imVar.A()));
                                                                                                                                                                                                                            if (compareTo27 == 0) {
                                                                                                                                                                                                                                if (!A() || (a3 = iy.a(this.f643b, imVar.f643b)) == 0) {
                                                                                                                                                                                                                                    int compareTo28 = Boolean.valueOf(B()).compareTo(Boolean.valueOf(imVar.B()));
                                                                                                                                                                                                                                    if (compareTo28 == 0) {
                                                                                                                                                                                                                                        if (!B() || (a2 = iy.a(this.f660r, imVar.f660r)) == 0) {
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
        this.f632a = i2;
        a(true);
        return this;
    }

    public im a(ia iaVar) {
        this.f634a = iaVar;
        return this;
    }

    public im a(String str) {
        this.f642b = str;
        return this;
    }

    public String a() {
        return this.f642b;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m444a() {
        if (this.f642b == null) {
            throw new jj("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f645c == null) {
            throw new jj("Required field 'appId' was not present! Struct: " + toString());
        }
        if (this.f648f == null) {
            throw new jj("Required field 'token' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ix
    public void a(ji jiVar) {
        jiVar.m492a();
        while (true) {
            jf m488a = jiVar.m488a();
            if (m488a.f5000a == 0) {
                jiVar.f();
                m444a();
                return;
            }
            switch (m488a.f781a) {
                case 1:
                    if (m488a.f5000a == 11) {
                        this.f636a = jiVar.m493a();
                        break;
                    } else {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    }
                case 2:
                    if (m488a.f5000a == 12) {
                        this.f635a = new ib();
                        this.f635a.a(jiVar);
                        break;
                    } else {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    }
                case 3:
                    if (m488a.f5000a == 11) {
                        this.f642b = jiVar.m493a();
                        break;
                    } else {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    }
                case 4:
                    if (m488a.f5000a == 11) {
                        this.f645c = jiVar.m493a();
                        break;
                    } else {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    }
                case 5:
                    if (m488a.f5000a == 11) {
                        this.f646d = jiVar.m493a();
                        break;
                    } else {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    }
                case 6:
                    if (m488a.f5000a == 11) {
                        this.f647e = jiVar.m493a();
                        break;
                    } else {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    }
                case 7:
                    if (m488a.f5000a == 11) {
                        this.f648f = jiVar.m493a();
                        break;
                    } else {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    }
                case 8:
                    if (m488a.f5000a == 11) {
                        this.f649g = jiVar.m493a();
                        break;
                    } else {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    }
                case 9:
                    if (m488a.f5000a == 11) {
                        this.f650h = jiVar.m493a();
                        break;
                    } else {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    }
                case 10:
                    if (m488a.f5000a == 11) {
                        this.f651i = jiVar.m493a();
                        break;
                    } else {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    }
                case 11:
                    if (m488a.f5000a == 11) {
                        this.f652j = jiVar.m493a();
                        break;
                    } else {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    }
                case 12:
                    if (m488a.f5000a == 11) {
                        this.f653k = jiVar.m493a();
                        break;
                    } else {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    }
                case 13:
                    if (m488a.f5000a == 8) {
                        this.f632a = jiVar.m486a();
                        a(true);
                        break;
                    } else {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    }
                case 14:
                    if (m488a.f5000a == 8) {
                        this.f640b = jiVar.m486a();
                        b(true);
                        break;
                    } else {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    }
                case 15:
                    if (m488a.f5000a == 11) {
                        this.f654l = jiVar.m493a();
                        break;
                    } else {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    }
                case 16:
                    if (m488a.f5000a == 11) {
                        this.f655m = jiVar.m493a();
                        break;
                    } else {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    }
                case 17:
                    if (m488a.f5000a == 11) {
                        this.f656n = jiVar.m493a();
                        break;
                    } else {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    }
                case 18:
                    if (m488a.f5000a == 11) {
                        this.f657o = jiVar.m493a();
                        break;
                    } else {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    }
                case 19:
                    if (m488a.f5000a == 8) {
                        this.f644c = jiVar.m486a();
                        c(true);
                        break;
                    } else {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    }
                case 20:
                    if (m488a.f5000a == 8) {
                        this.f634a = ia.a(jiVar.m486a());
                        break;
                    } else {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    }
                case 21:
                    if (m488a.f5000a == 2) {
                        this.f639a = jiVar.m497a();
                        d(true);
                        break;
                    } else {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    }
                case 22:
                    if (m488a.f5000a == 10) {
                        this.f633a = jiVar.m487a();
                        e(true);
                        break;
                    } else {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    }
                case 23:
                    if (m488a.f5000a == 10) {
                        this.f641b = jiVar.m487a();
                        f(true);
                        break;
                    } else {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    }
                case 24:
                    if (m488a.f5000a == 11) {
                        this.f658p = jiVar.m493a();
                        break;
                    } else {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    }
                case 25:
                    if (m488a.f5000a == 11) {
                        this.f659q = jiVar.m493a();
                        break;
                    } else {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    }
                case 100:
                    if (m488a.f5000a == 13) {
                        jh m490a = jiVar.m490a();
                        this.f638a = new HashMap(m490a.f783a * 2);
                        for (int i2 = 0; i2 < m490a.f783a; i2++) {
                            this.f638a.put(jiVar.m493a(), jiVar.m493a());
                        }
                        jiVar.h();
                        break;
                    } else {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    }
                case 101:
                    if (m488a.f5000a == 2) {
                        this.f643b = jiVar.m497a();
                        g(true);
                        break;
                    } else {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    }
                case 102:
                    if (m488a.f5000a == 11) {
                        this.f660r = jiVar.m493a();
                        break;
                    } else {
                        jl.a(jiVar, m488a.f5000a);
                        break;
                    }
                default:
                    jl.a(jiVar, m488a.f5000a);
                    break;
            }
            jiVar.g();
        }
    }

    public void a(boolean z2) {
        this.f637a.set(0, z2);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m445a() {
        return this.f636a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m446a(im imVar) {
        if (imVar == null) {
            return false;
        }
        boolean m445a = m445a();
        boolean m445a2 = imVar.m445a();
        if ((m445a || m445a2) && !(m445a && m445a2 && this.f636a.equals(imVar.f636a))) {
            return false;
        }
        boolean m447b = m447b();
        boolean m447b2 = imVar.m447b();
        if ((m447b || m447b2) && !(m447b && m447b2 && this.f635a.m401a(imVar.f635a))) {
            return false;
        }
        boolean m448c = m448c();
        boolean m448c2 = imVar.m448c();
        if ((m448c || m448c2) && !(m448c && m448c2 && this.f642b.equals(imVar.f642b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = imVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f645c.equals(imVar.f645c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = imVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f646d.equals(imVar.f646d))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = imVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f647e.equals(imVar.f647e))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = imVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f648f.equals(imVar.f648f))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = imVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f649g.equals(imVar.f649g))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = imVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f650h.equals(imVar.f650h))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = imVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f651i.equals(imVar.f651i))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = imVar.k();
        if ((k2 || k3) && !(k2 && k3 && this.f652j.equals(imVar.f652j))) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = imVar.l();
        if ((l2 || l3) && !(l2 && l3 && this.f653k.equals(imVar.f653k))) {
            return false;
        }
        boolean m2 = m();
        boolean m3 = imVar.m();
        if ((m2 || m3) && !(m2 && m3 && this.f632a == imVar.f632a)) {
            return false;
        }
        boolean n2 = n();
        boolean n3 = imVar.n();
        if ((n2 || n3) && !(n2 && n3 && this.f640b == imVar.f640b)) {
            return false;
        }
        boolean o2 = o();
        boolean o3 = imVar.o();
        if ((o2 || o3) && !(o2 && o3 && this.f654l.equals(imVar.f654l))) {
            return false;
        }
        boolean p2 = p();
        boolean p3 = imVar.p();
        if ((p2 || p3) && !(p2 && p3 && this.f655m.equals(imVar.f655m))) {
            return false;
        }
        boolean q2 = q();
        boolean q3 = imVar.q();
        if ((q2 || q3) && !(q2 && q3 && this.f656n.equals(imVar.f656n))) {
            return false;
        }
        boolean r2 = r();
        boolean r3 = imVar.r();
        if ((r2 || r3) && !(r2 && r3 && this.f657o.equals(imVar.f657o))) {
            return false;
        }
        boolean s2 = s();
        boolean s3 = imVar.s();
        if ((s2 || s3) && !(s2 && s3 && this.f644c == imVar.f644c)) {
            return false;
        }
        boolean t2 = t();
        boolean t3 = imVar.t();
        if ((t2 || t3) && !(t2 && t3 && this.f634a.equals(imVar.f634a))) {
            return false;
        }
        boolean u2 = u();
        boolean u3 = imVar.u();
        if ((u2 || u3) && !(u2 && u3 && this.f639a == imVar.f639a)) {
            return false;
        }
        boolean v2 = v();
        boolean v3 = imVar.v();
        if ((v2 || v3) && !(v2 && v3 && this.f633a == imVar.f633a)) {
            return false;
        }
        boolean w2 = w();
        boolean w3 = imVar.w();
        if ((w2 || w3) && !(w2 && w3 && this.f641b == imVar.f641b)) {
            return false;
        }
        boolean x2 = x();
        boolean x3 = imVar.x();
        if ((x2 || x3) && !(x2 && x3 && this.f658p.equals(imVar.f658p))) {
            return false;
        }
        boolean y2 = y();
        boolean y3 = imVar.y();
        if ((y2 || y3) && !(y2 && y3 && this.f659q.equals(imVar.f659q))) {
            return false;
        }
        boolean z2 = z();
        boolean z3 = imVar.z();
        if ((z2 || z3) && !(z2 && z3 && this.f638a.equals(imVar.f638a))) {
            return false;
        }
        boolean A2 = A();
        boolean A3 = imVar.A();
        if ((A2 || A3) && !(A2 && A3 && this.f643b == imVar.f643b)) {
            return false;
        }
        boolean B2 = B();
        boolean B3 = imVar.B();
        return !(B2 || B3) || (B2 && B3 && this.f660r.equals(imVar.f660r));
    }

    public im b(int i2) {
        this.f640b = i2;
        b(true);
        return this;
    }

    public im b(String str) {
        this.f645c = str;
        return this;
    }

    public String b() {
        return this.f645c;
    }

    @Override // com.xiaomi.push.ix
    public void b(ji jiVar) {
        m444a();
        jiVar.a(f631a);
        if (this.f636a != null && m445a()) {
            jiVar.a(f4982a);
            jiVar.a(this.f636a);
            jiVar.b();
        }
        if (this.f635a != null && m447b()) {
            jiVar.a(b);
            this.f635a.b(jiVar);
            jiVar.b();
        }
        if (this.f642b != null) {
            jiVar.a(c);
            jiVar.a(this.f642b);
            jiVar.b();
        }
        if (this.f645c != null) {
            jiVar.a(d);
            jiVar.a(this.f645c);
            jiVar.b();
        }
        if (this.f646d != null && e()) {
            jiVar.a(e);
            jiVar.a(this.f646d);
            jiVar.b();
        }
        if (this.f647e != null && f()) {
            jiVar.a(f);
            jiVar.a(this.f647e);
            jiVar.b();
        }
        if (this.f648f != null) {
            jiVar.a(g);
            jiVar.a(this.f648f);
            jiVar.b();
        }
        if (this.f649g != null && h()) {
            jiVar.a(h);
            jiVar.a(this.f649g);
            jiVar.b();
        }
        if (this.f650h != null && i()) {
            jiVar.a(i);
            jiVar.a(this.f650h);
            jiVar.b();
        }
        if (this.f651i != null && j()) {
            jiVar.a(j);
            jiVar.a(this.f651i);
            jiVar.b();
        }
        if (this.f652j != null && k()) {
            jiVar.a(k);
            jiVar.a(this.f652j);
            jiVar.b();
        }
        if (this.f653k != null && l()) {
            jiVar.a(l);
            jiVar.a(this.f653k);
            jiVar.b();
        }
        if (m()) {
            jiVar.a(m);
            jiVar.a(this.f632a);
            jiVar.b();
        }
        if (n()) {
            jiVar.a(n);
            jiVar.a(this.f640b);
            jiVar.b();
        }
        if (this.f654l != null && o()) {
            jiVar.a(o);
            jiVar.a(this.f654l);
            jiVar.b();
        }
        if (this.f655m != null && p()) {
            jiVar.a(p);
            jiVar.a(this.f655m);
            jiVar.b();
        }
        if (this.f656n != null && q()) {
            jiVar.a(q);
            jiVar.a(this.f656n);
            jiVar.b();
        }
        if (this.f657o != null && r()) {
            jiVar.a(r);
            jiVar.a(this.f657o);
            jiVar.b();
        }
        if (s()) {
            jiVar.a(s);
            jiVar.a(this.f644c);
            jiVar.b();
        }
        if (this.f634a != null && t()) {
            jiVar.a(t);
            jiVar.a(this.f634a.a());
            jiVar.b();
        }
        if (u()) {
            jiVar.a(u);
            jiVar.a(this.f639a);
            jiVar.b();
        }
        if (v()) {
            jiVar.a(v);
            jiVar.a(this.f633a);
            jiVar.b();
        }
        if (w()) {
            jiVar.a(w);
            jiVar.a(this.f641b);
            jiVar.b();
        }
        if (this.f658p != null && x()) {
            jiVar.a(x);
            jiVar.a(this.f658p);
            jiVar.b();
        }
        if (this.f659q != null && y()) {
            jiVar.a(y);
            jiVar.a(this.f659q);
            jiVar.b();
        }
        if (this.f638a != null && z()) {
            jiVar.a(z);
            jiVar.a(new jh(Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, this.f638a.size()));
            for (Map.Entry<String, String> entry : this.f638a.entrySet()) {
                jiVar.a(entry.getKey());
                jiVar.a(entry.getValue());
            }
            jiVar.d();
            jiVar.b();
        }
        if (A()) {
            jiVar.a(A);
            jiVar.a(this.f643b);
            jiVar.b();
        }
        if (this.f660r != null && B()) {
            jiVar.a(B);
            jiVar.a(this.f660r);
            jiVar.b();
        }
        jiVar.c();
        jiVar.m496a();
    }

    public void b(boolean z2) {
        this.f637a.set(1, z2);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m447b() {
        return this.f635a != null;
    }

    public im c(int i2) {
        this.f644c = i2;
        c(true);
        return this;
    }

    public im c(String str) {
        this.f646d = str;
        return this;
    }

    public String c() {
        return this.f648f;
    }

    public void c(boolean z2) {
        this.f637a.set(2, z2);
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m448c() {
        return this.f642b != null;
    }

    public im d(String str) {
        this.f647e = str;
        return this;
    }

    public void d(boolean z2) {
        this.f637a.set(3, z2);
    }

    public boolean d() {
        return this.f645c != null;
    }

    public im e(String str) {
        this.f648f = str;
        return this;
    }

    public void e(boolean z2) {
        this.f637a.set(4, z2);
    }

    public boolean e() {
        return this.f646d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof im)) {
            return m446a((im) obj);
        }
        return false;
    }

    public im f(String str) {
        this.f649g = str;
        return this;
    }

    public void f(boolean z2) {
        this.f637a.set(5, z2);
    }

    public boolean f() {
        return this.f647e != null;
    }

    public im g(String str) {
        this.f650h = str;
        return this;
    }

    public void g(boolean z2) {
        this.f637a.set(6, z2);
    }

    public boolean g() {
        return this.f648f != null;
    }

    public im h(String str) {
        this.f653k = str;
        return this;
    }

    public boolean h() {
        return this.f649g != null;
    }

    public int hashCode() {
        return 0;
    }

    public im i(String str) {
        this.f654l = str;
        return this;
    }

    public boolean i() {
        return this.f650h != null;
    }

    public im j(String str) {
        this.f656n = str;
        return this;
    }

    public boolean j() {
        return this.f651i != null;
    }

    public im k(String str) {
        this.f657o = str;
        return this;
    }

    public boolean k() {
        return this.f652j != null;
    }

    public boolean l() {
        return this.f653k != null;
    }

    public boolean m() {
        return this.f637a.get(0);
    }

    public boolean n() {
        return this.f637a.get(1);
    }

    public boolean o() {
        return this.f654l != null;
    }

    public boolean p() {
        return this.f655m != null;
    }

    public boolean q() {
        return this.f656n != null;
    }

    public boolean r() {
        return this.f657o != null;
    }

    public boolean s() {
        return this.f637a.get(2);
    }

    public boolean t() {
        return this.f634a != null;
    }

    public String toString() {
        boolean z2 = false;
        StringBuilder sb = new StringBuilder("XmPushActionRegistration(");
        boolean z3 = true;
        if (m445a()) {
            sb.append("debug:");
            if (this.f636a == null) {
                sb.append("null");
            } else {
                sb.append(this.f636a);
            }
            z3 = false;
        }
        if (m447b()) {
            if (!z3) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f635a == null) {
                sb.append("null");
            } else {
                sb.append(this.f635a);
            }
        } else {
            z2 = z3;
        }
        if (!z2) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f642b == null) {
            sb.append("null");
        } else {
            sb.append(this.f642b);
        }
        sb.append(", ");
        sb.append("appId:");
        if (this.f645c == null) {
            sb.append("null");
        } else {
            sb.append(this.f645c);
        }
        if (e()) {
            sb.append(", ");
            sb.append("appVersion:");
            if (this.f646d == null) {
                sb.append("null");
            } else {
                sb.append(this.f646d);
            }
        }
        if (f()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f647e == null) {
                sb.append("null");
            } else {
                sb.append(this.f647e);
            }
        }
        sb.append(", ");
        sb.append("token:");
        if (this.f648f == null) {
            sb.append("null");
        } else {
            sb.append(this.f648f);
        }
        if (h()) {
            sb.append(", ");
            sb.append("deviceId:");
            if (this.f649g == null) {
                sb.append("null");
            } else {
                sb.append(this.f649g);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("aliasName:");
            if (this.f650h == null) {
                sb.append("null");
            } else {
                sb.append(this.f650h);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("sdkVersion:");
            if (this.f651i == null) {
                sb.append("null");
            } else {
                sb.append(this.f651i);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("regId:");
            if (this.f652j == null) {
                sb.append("null");
            } else {
                sb.append(this.f652j);
            }
        }
        if (l()) {
            sb.append(", ");
            sb.append("pushSdkVersionName:");
            if (this.f653k == null) {
                sb.append("null");
            } else {
                sb.append(this.f653k);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("pushSdkVersionCode:");
            sb.append(this.f632a);
        }
        if (n()) {
            sb.append(", ");
            sb.append("appVersionCode:");
            sb.append(this.f640b);
        }
        if (o()) {
            sb.append(", ");
            sb.append("androidId:");
            if (this.f654l == null) {
                sb.append("null");
            } else {
                sb.append(this.f654l);
            }
        }
        if (p()) {
            sb.append(", ");
            sb.append("imei:");
            if (this.f655m == null) {
                sb.append("null");
            } else {
                sb.append(this.f655m);
            }
        }
        if (q()) {
            sb.append(", ");
            sb.append("serial:");
            if (this.f656n == null) {
                sb.append("null");
            } else {
                sb.append(this.f656n);
            }
        }
        if (r()) {
            sb.append(", ");
            sb.append("imeiMd5:");
            if (this.f657o == null) {
                sb.append("null");
            } else {
                sb.append(this.f657o);
            }
        }
        if (s()) {
            sb.append(", ");
            sb.append("spaceId:");
            sb.append(this.f644c);
        }
        if (t()) {
            sb.append(", ");
            sb.append("reason:");
            if (this.f634a == null) {
                sb.append("null");
            } else {
                sb.append(this.f634a);
            }
        }
        if (u()) {
            sb.append(", ");
            sb.append("validateToken:");
            sb.append(this.f639a);
        }
        if (v()) {
            sb.append(", ");
            sb.append("miid:");
            sb.append(this.f633a);
        }
        if (w()) {
            sb.append(", ");
            sb.append("createdTs:");
            sb.append(this.f641b);
        }
        if (x()) {
            sb.append(", ");
            sb.append("subImei:");
            if (this.f658p == null) {
                sb.append("null");
            } else {
                sb.append(this.f658p);
            }
        }
        if (y()) {
            sb.append(", ");
            sb.append("subImeiMd5:");
            if (this.f659q == null) {
                sb.append("null");
            } else {
                sb.append(this.f659q);
            }
        }
        if (z()) {
            sb.append(", ");
            sb.append("connectionAttrs:");
            if (this.f638a == null) {
                sb.append("null");
            } else {
                sb.append(this.f638a);
            }
        }
        if (A()) {
            sb.append(", ");
            sb.append("cleanOldRegInfo:");
            sb.append(this.f643b);
        }
        if (B()) {
            sb.append(", ");
            sb.append("oldRegId:");
            if (this.f660r == null) {
                sb.append("null");
            } else {
                sb.append(this.f660r);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    public boolean u() {
        return this.f637a.get(3);
    }

    public boolean v() {
        return this.f637a.get(4);
    }

    public boolean w() {
        return this.f637a.get(5);
    }

    public boolean x() {
        return this.f658p != null;
    }

    public boolean y() {
        return this.f659q != null;
    }

    public boolean z() {
        return this.f638a != null;
    }
}
