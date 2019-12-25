package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public class ig implements ir<ig, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public int f646a;

    /* renamed from: a  reason: collision with other field name */
    public long f647a;

    /* renamed from: a  reason: collision with other field name */
    public hu f648a;

    /* renamed from: a  reason: collision with other field name */
    public hv f649a;

    /* renamed from: a  reason: collision with other field name */
    public String f650a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f652a;

    /* renamed from: b  reason: collision with other field name */
    public int f654b;

    /* renamed from: b  reason: collision with other field name */
    public long f655b;

    /* renamed from: b  reason: collision with other field name */
    public String f656b;

    /* renamed from: c  reason: collision with other field name */
    public int f658c;

    /* renamed from: c  reason: collision with other field name */
    public String f659c;

    /* renamed from: d  reason: collision with other field name */
    public String f660d;

    /* renamed from: e  reason: collision with other field name */
    public String f661e;

    /* renamed from: f  reason: collision with other field name */
    public String f662f;

    /* renamed from: g  reason: collision with other field name */
    public String f663g;

    /* renamed from: h  reason: collision with other field name */
    public String f664h;

    /* renamed from: i  reason: collision with other field name */
    public String f665i;

    /* renamed from: j  reason: collision with other field name */
    public String f666j;

    /* renamed from: k  reason: collision with other field name */
    public String f667k;

    /* renamed from: l  reason: collision with other field name */
    public String f668l;

    /* renamed from: m  reason: collision with other field name */
    public String f669m;

    /* renamed from: n  reason: collision with other field name */
    public String f670n;

    /* renamed from: o  reason: collision with other field name */
    public String f671o;

    /* renamed from: p  reason: collision with other field name */
    public String f672p;

    /* renamed from: q  reason: collision with other field name */
    public String f673q;

    /* renamed from: r  reason: collision with other field name */
    public String f674r;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f645a = new jh("XmPushActionRegistration");
    private static final iz a = new iz("", Constants.GZIP_CAST_TYPE, 1);
    private static final iz b = new iz("", (byte) 12, 2);
    private static final iz c = new iz("", Constants.GZIP_CAST_TYPE, 3);
    private static final iz d = new iz("", Constants.GZIP_CAST_TYPE, 4);
    private static final iz e = new iz("", Constants.GZIP_CAST_TYPE, 5);
    private static final iz f = new iz("", Constants.GZIP_CAST_TYPE, 6);
    private static final iz g = new iz("", Constants.GZIP_CAST_TYPE, 7);
    private static final iz h = new iz("", Constants.GZIP_CAST_TYPE, 8);
    private static final iz i = new iz("", Constants.GZIP_CAST_TYPE, 9);
    private static final iz j = new iz("", Constants.GZIP_CAST_TYPE, 10);
    private static final iz k = new iz("", Constants.GZIP_CAST_TYPE, 11);
    private static final iz l = new iz("", Constants.GZIP_CAST_TYPE, 12);
    private static final iz m = new iz("", (byte) 8, 13);
    private static final iz n = new iz("", (byte) 8, 14);
    private static final iz o = new iz("", Constants.GZIP_CAST_TYPE, 15);
    private static final iz p = new iz("", Constants.GZIP_CAST_TYPE, 16);
    private static final iz q = new iz("", Constants.GZIP_CAST_TYPE, 17);
    private static final iz r = new iz("", Constants.GZIP_CAST_TYPE, 18);
    private static final iz s = new iz("", (byte) 8, 19);
    private static final iz t = new iz("", (byte) 8, 20);
    private static final iz u = new iz("", (byte) 2, 21);
    private static final iz v = new iz("", (byte) 10, 22);
    private static final iz w = new iz("", (byte) 10, 23);
    private static final iz x = new iz("", Constants.GZIP_CAST_TYPE, 24);
    private static final iz y = new iz("", Constants.GZIP_CAST_TYPE, 25);
    private static final iz z = new iz("", (byte) 13, 100);
    private static final iz A = new iz("", (byte) 2, 101);
    private static final iz B = new iz("", Constants.GZIP_CAST_TYPE, 102);

    /* renamed from: a  reason: collision with other field name */
    private BitSet f651a = new BitSet(7);

    /* renamed from: a  reason: collision with other field name */
    public boolean f653a = true;

    /* renamed from: b  reason: collision with other field name */
    public boolean f657b = false;

    public boolean A() {
        return this.f651a.get(6);
    }

    public boolean B() {
        return this.f674r != null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(ig igVar) {
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
        if (getClass().equals(igVar.getClass())) {
            int compareTo = Boolean.valueOf(m411a()).compareTo(Boolean.valueOf(igVar.m411a()));
            if (compareTo == 0) {
                if (!m411a() || (a29 = is.a(this.f650a, igVar.f650a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m413b()).compareTo(Boolean.valueOf(igVar.m413b()));
                    if (compareTo2 == 0) {
                        if (!m413b() || (a28 = is.a(this.f649a, igVar.f649a)) == 0) {
                            int compareTo3 = Boolean.valueOf(m414c()).compareTo(Boolean.valueOf(igVar.m414c()));
                            if (compareTo3 == 0) {
                                if (!m414c() || (a27 = is.a(this.f656b, igVar.f656b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(igVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a26 = is.a(this.f659c, igVar.f659c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(igVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a25 = is.a(this.f660d, igVar.f660d)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(igVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a24 = is.a(this.f661e, igVar.f661e)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(igVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a23 = is.a(this.f662f, igVar.f662f)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(igVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a22 = is.a(this.f663g, igVar.f663g)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(igVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a21 = is.a(this.f664h, igVar.f664h)) == 0) {
                                                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(igVar.j()));
                                                                                    if (compareTo10 == 0) {
                                                                                        if (!j() || (a20 = is.a(this.f665i, igVar.f665i)) == 0) {
                                                                                            int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(igVar.k()));
                                                                                            if (compareTo11 == 0) {
                                                                                                if (!k() || (a19 = is.a(this.f666j, igVar.f666j)) == 0) {
                                                                                                    int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(igVar.l()));
                                                                                                    if (compareTo12 == 0) {
                                                                                                        if (!l() || (a18 = is.a(this.f667k, igVar.f667k)) == 0) {
                                                                                                            int compareTo13 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(igVar.m()));
                                                                                                            if (compareTo13 == 0) {
                                                                                                                if (!m() || (a17 = is.a(this.f646a, igVar.f646a)) == 0) {
                                                                                                                    int compareTo14 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(igVar.n()));
                                                                                                                    if (compareTo14 == 0) {
                                                                                                                        if (!n() || (a16 = is.a(this.f654b, igVar.f654b)) == 0) {
                                                                                                                            int compareTo15 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(igVar.o()));
                                                                                                                            if (compareTo15 == 0) {
                                                                                                                                if (!o() || (a15 = is.a(this.f668l, igVar.f668l)) == 0) {
                                                                                                                                    int compareTo16 = Boolean.valueOf(p()).compareTo(Boolean.valueOf(igVar.p()));
                                                                                                                                    if (compareTo16 == 0) {
                                                                                                                                        if (!p() || (a14 = is.a(this.f669m, igVar.f669m)) == 0) {
                                                                                                                                            int compareTo17 = Boolean.valueOf(q()).compareTo(Boolean.valueOf(igVar.q()));
                                                                                                                                            if (compareTo17 == 0) {
                                                                                                                                                if (!q() || (a13 = is.a(this.f670n, igVar.f670n)) == 0) {
                                                                                                                                                    int compareTo18 = Boolean.valueOf(r()).compareTo(Boolean.valueOf(igVar.r()));
                                                                                                                                                    if (compareTo18 == 0) {
                                                                                                                                                        if (!r() || (a12 = is.a(this.f671o, igVar.f671o)) == 0) {
                                                                                                                                                            int compareTo19 = Boolean.valueOf(s()).compareTo(Boolean.valueOf(igVar.s()));
                                                                                                                                                            if (compareTo19 == 0) {
                                                                                                                                                                if (!s() || (a11 = is.a(this.f658c, igVar.f658c)) == 0) {
                                                                                                                                                                    int compareTo20 = Boolean.valueOf(t()).compareTo(Boolean.valueOf(igVar.t()));
                                                                                                                                                                    if (compareTo20 == 0) {
                                                                                                                                                                        if (!t() || (a10 = is.a(this.f648a, igVar.f648a)) == 0) {
                                                                                                                                                                            int compareTo21 = Boolean.valueOf(u()).compareTo(Boolean.valueOf(igVar.u()));
                                                                                                                                                                            if (compareTo21 == 0) {
                                                                                                                                                                                if (!u() || (a9 = is.a(this.f653a, igVar.f653a)) == 0) {
                                                                                                                                                                                    int compareTo22 = Boolean.valueOf(v()).compareTo(Boolean.valueOf(igVar.v()));
                                                                                                                                                                                    if (compareTo22 == 0) {
                                                                                                                                                                                        if (!v() || (a8 = is.a(this.f647a, igVar.f647a)) == 0) {
                                                                                                                                                                                            int compareTo23 = Boolean.valueOf(w()).compareTo(Boolean.valueOf(igVar.w()));
                                                                                                                                                                                            if (compareTo23 == 0) {
                                                                                                                                                                                                if (!w() || (a7 = is.a(this.f655b, igVar.f655b)) == 0) {
                                                                                                                                                                                                    int compareTo24 = Boolean.valueOf(x()).compareTo(Boolean.valueOf(igVar.x()));
                                                                                                                                                                                                    if (compareTo24 == 0) {
                                                                                                                                                                                                        if (!x() || (a6 = is.a(this.f672p, igVar.f672p)) == 0) {
                                                                                                                                                                                                            int compareTo25 = Boolean.valueOf(y()).compareTo(Boolean.valueOf(igVar.y()));
                                                                                                                                                                                                            if (compareTo25 == 0) {
                                                                                                                                                                                                                if (!y() || (a5 = is.a(this.f673q, igVar.f673q)) == 0) {
                                                                                                                                                                                                                    int compareTo26 = Boolean.valueOf(z()).compareTo(Boolean.valueOf(igVar.z()));
                                                                                                                                                                                                                    if (compareTo26 == 0) {
                                                                                                                                                                                                                        if (!z() || (a4 = is.a(this.f652a, igVar.f652a)) == 0) {
                                                                                                                                                                                                                            int compareTo27 = Boolean.valueOf(A()).compareTo(Boolean.valueOf(igVar.A()));
                                                                                                                                                                                                                            if (compareTo27 == 0) {
                                                                                                                                                                                                                                if (!A() || (a3 = is.a(this.f657b, igVar.f657b)) == 0) {
                                                                                                                                                                                                                                    int compareTo28 = Boolean.valueOf(B()).compareTo(Boolean.valueOf(igVar.B()));
                                                                                                                                                                                                                                    if (compareTo28 == 0) {
                                                                                                                                                                                                                                        if (!B() || (a2 = is.a(this.f674r, igVar.f674r)) == 0) {
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
        return getClass().getName().compareTo(igVar.getClass().getName());
    }

    public ig a(int i2) {
        this.f646a = i2;
        a(true);
        return this;
    }

    public ig a(hu huVar) {
        this.f648a = huVar;
        return this;
    }

    public ig a(String str) {
        this.f656b = str;
        return this;
    }

    public String a() {
        return this.f656b;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m410a() {
        if (this.f656b == null) {
            throw new jd("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f659c == null) {
            throw new jd("Required field 'appId' was not present! Struct: " + toString());
        }
        if (this.f662f == null) {
            throw new jd("Required field 'token' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ir
    public void a(jc jcVar) {
        jcVar.m458a();
        while (true) {
            iz m454a = jcVar.m454a();
            if (m454a.a == 0) {
                jcVar.f();
                m410a();
                return;
            }
            switch (m454a.f793a) {
                case 1:
                    if (m454a.a == 11) {
                        this.f650a = jcVar.m459a();
                        break;
                    } else {
                        jf.a(jcVar, m454a.a);
                        break;
                    }
                case 2:
                    if (m454a.a == 12) {
                        this.f649a = new hv();
                        this.f649a.a(jcVar);
                        break;
                    } else {
                        jf.a(jcVar, m454a.a);
                        break;
                    }
                case 3:
                    if (m454a.a == 11) {
                        this.f656b = jcVar.m459a();
                        break;
                    } else {
                        jf.a(jcVar, m454a.a);
                        break;
                    }
                case 4:
                    if (m454a.a == 11) {
                        this.f659c = jcVar.m459a();
                        break;
                    } else {
                        jf.a(jcVar, m454a.a);
                        break;
                    }
                case 5:
                    if (m454a.a == 11) {
                        this.f660d = jcVar.m459a();
                        break;
                    } else {
                        jf.a(jcVar, m454a.a);
                        break;
                    }
                case 6:
                    if (m454a.a == 11) {
                        this.f661e = jcVar.m459a();
                        break;
                    } else {
                        jf.a(jcVar, m454a.a);
                        break;
                    }
                case 7:
                    if (m454a.a == 11) {
                        this.f662f = jcVar.m459a();
                        break;
                    } else {
                        jf.a(jcVar, m454a.a);
                        break;
                    }
                case 8:
                    if (m454a.a == 11) {
                        this.f663g = jcVar.m459a();
                        break;
                    } else {
                        jf.a(jcVar, m454a.a);
                        break;
                    }
                case 9:
                    if (m454a.a == 11) {
                        this.f664h = jcVar.m459a();
                        break;
                    } else {
                        jf.a(jcVar, m454a.a);
                        break;
                    }
                case 10:
                    if (m454a.a == 11) {
                        this.f665i = jcVar.m459a();
                        break;
                    } else {
                        jf.a(jcVar, m454a.a);
                        break;
                    }
                case 11:
                    if (m454a.a == 11) {
                        this.f666j = jcVar.m459a();
                        break;
                    } else {
                        jf.a(jcVar, m454a.a);
                        break;
                    }
                case 12:
                    if (m454a.a == 11) {
                        this.f667k = jcVar.m459a();
                        break;
                    } else {
                        jf.a(jcVar, m454a.a);
                        break;
                    }
                case 13:
                    if (m454a.a == 8) {
                        this.f646a = jcVar.m452a();
                        a(true);
                        break;
                    } else {
                        jf.a(jcVar, m454a.a);
                        break;
                    }
                case 14:
                    if (m454a.a == 8) {
                        this.f654b = jcVar.m452a();
                        b(true);
                        break;
                    } else {
                        jf.a(jcVar, m454a.a);
                        break;
                    }
                case 15:
                    if (m454a.a == 11) {
                        this.f668l = jcVar.m459a();
                        break;
                    } else {
                        jf.a(jcVar, m454a.a);
                        break;
                    }
                case 16:
                    if (m454a.a == 11) {
                        this.f669m = jcVar.m459a();
                        break;
                    } else {
                        jf.a(jcVar, m454a.a);
                        break;
                    }
                case 17:
                    if (m454a.a == 11) {
                        this.f670n = jcVar.m459a();
                        break;
                    } else {
                        jf.a(jcVar, m454a.a);
                        break;
                    }
                case 18:
                    if (m454a.a == 11) {
                        this.f671o = jcVar.m459a();
                        break;
                    } else {
                        jf.a(jcVar, m454a.a);
                        break;
                    }
                case 19:
                    if (m454a.a == 8) {
                        this.f658c = jcVar.m452a();
                        c(true);
                        break;
                    } else {
                        jf.a(jcVar, m454a.a);
                        break;
                    }
                case 20:
                    if (m454a.a == 8) {
                        this.f648a = hu.a(jcVar.m452a());
                        break;
                    } else {
                        jf.a(jcVar, m454a.a);
                        break;
                    }
                case 21:
                    if (m454a.a == 2) {
                        this.f653a = jcVar.m463a();
                        d(true);
                        break;
                    } else {
                        jf.a(jcVar, m454a.a);
                        break;
                    }
                case 22:
                    if (m454a.a == 10) {
                        this.f647a = jcVar.m453a();
                        e(true);
                        break;
                    } else {
                        jf.a(jcVar, m454a.a);
                        break;
                    }
                case 23:
                    if (m454a.a == 10) {
                        this.f655b = jcVar.m453a();
                        f(true);
                        break;
                    } else {
                        jf.a(jcVar, m454a.a);
                        break;
                    }
                case 24:
                    if (m454a.a == 11) {
                        this.f672p = jcVar.m459a();
                        break;
                    } else {
                        jf.a(jcVar, m454a.a);
                        break;
                    }
                case 25:
                    if (m454a.a == 11) {
                        this.f673q = jcVar.m459a();
                        break;
                    } else {
                        jf.a(jcVar, m454a.a);
                        break;
                    }
                case 100:
                    if (m454a.a == 13) {
                        jb m456a = jcVar.m456a();
                        this.f652a = new HashMap(m456a.f797a * 2);
                        for (int i2 = 0; i2 < m456a.f797a; i2++) {
                            this.f652a.put(jcVar.m459a(), jcVar.m459a());
                        }
                        jcVar.h();
                        break;
                    } else {
                        jf.a(jcVar, m454a.a);
                        break;
                    }
                case 101:
                    if (m454a.a == 2) {
                        this.f657b = jcVar.m463a();
                        g(true);
                        break;
                    } else {
                        jf.a(jcVar, m454a.a);
                        break;
                    }
                case 102:
                    if (m454a.a == 11) {
                        this.f674r = jcVar.m459a();
                        break;
                    } else {
                        jf.a(jcVar, m454a.a);
                        break;
                    }
                default:
                    jf.a(jcVar, m454a.a);
                    break;
            }
            jcVar.g();
        }
    }

    public void a(boolean z2) {
        this.f651a.set(0, z2);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m411a() {
        return this.f650a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m412a(ig igVar) {
        if (igVar == null) {
            return false;
        }
        boolean m411a = m411a();
        boolean m411a2 = igVar.m411a();
        if ((m411a || m411a2) && !(m411a && m411a2 && this.f650a.equals(igVar.f650a))) {
            return false;
        }
        boolean m413b = m413b();
        boolean m413b2 = igVar.m413b();
        if ((m413b || m413b2) && !(m413b && m413b2 && this.f649a.m364a(igVar.f649a))) {
            return false;
        }
        boolean m414c = m414c();
        boolean m414c2 = igVar.m414c();
        if ((m414c || m414c2) && !(m414c && m414c2 && this.f656b.equals(igVar.f656b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = igVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f659c.equals(igVar.f659c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = igVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f660d.equals(igVar.f660d))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = igVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f661e.equals(igVar.f661e))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = igVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f662f.equals(igVar.f662f))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = igVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f663g.equals(igVar.f663g))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = igVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f664h.equals(igVar.f664h))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = igVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f665i.equals(igVar.f665i))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = igVar.k();
        if ((k2 || k3) && !(k2 && k3 && this.f666j.equals(igVar.f666j))) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = igVar.l();
        if ((l2 || l3) && !(l2 && l3 && this.f667k.equals(igVar.f667k))) {
            return false;
        }
        boolean m2 = m();
        boolean m3 = igVar.m();
        if ((m2 || m3) && !(m2 && m3 && this.f646a == igVar.f646a)) {
            return false;
        }
        boolean n2 = n();
        boolean n3 = igVar.n();
        if ((n2 || n3) && !(n2 && n3 && this.f654b == igVar.f654b)) {
            return false;
        }
        boolean o2 = o();
        boolean o3 = igVar.o();
        if ((o2 || o3) && !(o2 && o3 && this.f668l.equals(igVar.f668l))) {
            return false;
        }
        boolean p2 = p();
        boolean p3 = igVar.p();
        if ((p2 || p3) && !(p2 && p3 && this.f669m.equals(igVar.f669m))) {
            return false;
        }
        boolean q2 = q();
        boolean q3 = igVar.q();
        if ((q2 || q3) && !(q2 && q3 && this.f670n.equals(igVar.f670n))) {
            return false;
        }
        boolean r2 = r();
        boolean r3 = igVar.r();
        if ((r2 || r3) && !(r2 && r3 && this.f671o.equals(igVar.f671o))) {
            return false;
        }
        boolean s2 = s();
        boolean s3 = igVar.s();
        if ((s2 || s3) && !(s2 && s3 && this.f658c == igVar.f658c)) {
            return false;
        }
        boolean t2 = t();
        boolean t3 = igVar.t();
        if ((t2 || t3) && !(t2 && t3 && this.f648a.equals(igVar.f648a))) {
            return false;
        }
        boolean u2 = u();
        boolean u3 = igVar.u();
        if ((u2 || u3) && !(u2 && u3 && this.f653a == igVar.f653a)) {
            return false;
        }
        boolean v2 = v();
        boolean v3 = igVar.v();
        if ((v2 || v3) && !(v2 && v3 && this.f647a == igVar.f647a)) {
            return false;
        }
        boolean w2 = w();
        boolean w3 = igVar.w();
        if ((w2 || w3) && !(w2 && w3 && this.f655b == igVar.f655b)) {
            return false;
        }
        boolean x2 = x();
        boolean x3 = igVar.x();
        if ((x2 || x3) && !(x2 && x3 && this.f672p.equals(igVar.f672p))) {
            return false;
        }
        boolean y2 = y();
        boolean y3 = igVar.y();
        if ((y2 || y3) && !(y2 && y3 && this.f673q.equals(igVar.f673q))) {
            return false;
        }
        boolean z2 = z();
        boolean z3 = igVar.z();
        if ((z2 || z3) && !(z2 && z3 && this.f652a.equals(igVar.f652a))) {
            return false;
        }
        boolean A2 = A();
        boolean A3 = igVar.A();
        if ((A2 || A3) && !(A2 && A3 && this.f657b == igVar.f657b)) {
            return false;
        }
        boolean B2 = B();
        boolean B3 = igVar.B();
        return !(B2 || B3) || (B2 && B3 && this.f674r.equals(igVar.f674r));
    }

    public ig b(int i2) {
        this.f654b = i2;
        b(true);
        return this;
    }

    public ig b(String str) {
        this.f659c = str;
        return this;
    }

    public String b() {
        return this.f659c;
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        m410a();
        jcVar.a(f645a);
        if (this.f650a != null && m411a()) {
            jcVar.a(a);
            jcVar.a(this.f650a);
            jcVar.b();
        }
        if (this.f649a != null && m413b()) {
            jcVar.a(b);
            this.f649a.b(jcVar);
            jcVar.b();
        }
        if (this.f656b != null) {
            jcVar.a(c);
            jcVar.a(this.f656b);
            jcVar.b();
        }
        if (this.f659c != null) {
            jcVar.a(d);
            jcVar.a(this.f659c);
            jcVar.b();
        }
        if (this.f660d != null && e()) {
            jcVar.a(e);
            jcVar.a(this.f660d);
            jcVar.b();
        }
        if (this.f661e != null && f()) {
            jcVar.a(f);
            jcVar.a(this.f661e);
            jcVar.b();
        }
        if (this.f662f != null) {
            jcVar.a(g);
            jcVar.a(this.f662f);
            jcVar.b();
        }
        if (this.f663g != null && h()) {
            jcVar.a(h);
            jcVar.a(this.f663g);
            jcVar.b();
        }
        if (this.f664h != null && i()) {
            jcVar.a(i);
            jcVar.a(this.f664h);
            jcVar.b();
        }
        if (this.f665i != null && j()) {
            jcVar.a(j);
            jcVar.a(this.f665i);
            jcVar.b();
        }
        if (this.f666j != null && k()) {
            jcVar.a(k);
            jcVar.a(this.f666j);
            jcVar.b();
        }
        if (this.f667k != null && l()) {
            jcVar.a(l);
            jcVar.a(this.f667k);
            jcVar.b();
        }
        if (m()) {
            jcVar.a(m);
            jcVar.a(this.f646a);
            jcVar.b();
        }
        if (n()) {
            jcVar.a(n);
            jcVar.a(this.f654b);
            jcVar.b();
        }
        if (this.f668l != null && o()) {
            jcVar.a(o);
            jcVar.a(this.f668l);
            jcVar.b();
        }
        if (this.f669m != null && p()) {
            jcVar.a(p);
            jcVar.a(this.f669m);
            jcVar.b();
        }
        if (this.f670n != null && q()) {
            jcVar.a(q);
            jcVar.a(this.f670n);
            jcVar.b();
        }
        if (this.f671o != null && r()) {
            jcVar.a(r);
            jcVar.a(this.f671o);
            jcVar.b();
        }
        if (s()) {
            jcVar.a(s);
            jcVar.a(this.f658c);
            jcVar.b();
        }
        if (this.f648a != null && t()) {
            jcVar.a(t);
            jcVar.a(this.f648a.a());
            jcVar.b();
        }
        if (u()) {
            jcVar.a(u);
            jcVar.a(this.f653a);
            jcVar.b();
        }
        if (v()) {
            jcVar.a(v);
            jcVar.a(this.f647a);
            jcVar.b();
        }
        if (w()) {
            jcVar.a(w);
            jcVar.a(this.f655b);
            jcVar.b();
        }
        if (this.f672p != null && x()) {
            jcVar.a(x);
            jcVar.a(this.f672p);
            jcVar.b();
        }
        if (this.f673q != null && y()) {
            jcVar.a(y);
            jcVar.a(this.f673q);
            jcVar.b();
        }
        if (this.f652a != null && z()) {
            jcVar.a(z);
            jcVar.a(new jb(Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, this.f652a.size()));
            for (Map.Entry<String, String> entry : this.f652a.entrySet()) {
                jcVar.a(entry.getKey());
                jcVar.a(entry.getValue());
            }
            jcVar.d();
            jcVar.b();
        }
        if (A()) {
            jcVar.a(A);
            jcVar.a(this.f657b);
            jcVar.b();
        }
        if (this.f674r != null && B()) {
            jcVar.a(B);
            jcVar.a(this.f674r);
            jcVar.b();
        }
        jcVar.c();
        jcVar.m462a();
    }

    public void b(boolean z2) {
        this.f651a.set(1, z2);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m413b() {
        return this.f649a != null;
    }

    public ig c(int i2) {
        this.f658c = i2;
        c(true);
        return this;
    }

    public ig c(String str) {
        this.f660d = str;
        return this;
    }

    public String c() {
        return this.f662f;
    }

    public void c(boolean z2) {
        this.f651a.set(2, z2);
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m414c() {
        return this.f656b != null;
    }

    public ig d(String str) {
        this.f661e = str;
        return this;
    }

    public void d(boolean z2) {
        this.f651a.set(3, z2);
    }

    public boolean d() {
        return this.f659c != null;
    }

    public ig e(String str) {
        this.f662f = str;
        return this;
    }

    public void e(boolean z2) {
        this.f651a.set(4, z2);
    }

    public boolean e() {
        return this.f660d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ig)) {
            return m412a((ig) obj);
        }
        return false;
    }

    public ig f(String str) {
        this.f663g = str;
        return this;
    }

    public void f(boolean z2) {
        this.f651a.set(5, z2);
    }

    public boolean f() {
        return this.f661e != null;
    }

    public ig g(String str) {
        this.f667k = str;
        return this;
    }

    public void g(boolean z2) {
        this.f651a.set(6, z2);
    }

    public boolean g() {
        return this.f662f != null;
    }

    public ig h(String str) {
        this.f668l = str;
        return this;
    }

    public boolean h() {
        return this.f663g != null;
    }

    public int hashCode() {
        return 0;
    }

    public ig i(String str) {
        this.f669m = str;
        return this;
    }

    public boolean i() {
        return this.f664h != null;
    }

    public ig j(String str) {
        this.f670n = str;
        return this;
    }

    public boolean j() {
        return this.f665i != null;
    }

    public ig k(String str) {
        this.f671o = str;
        return this;
    }

    public boolean k() {
        return this.f666j != null;
    }

    public boolean l() {
        return this.f667k != null;
    }

    public boolean m() {
        return this.f651a.get(0);
    }

    public boolean n() {
        return this.f651a.get(1);
    }

    public boolean o() {
        return this.f668l != null;
    }

    public boolean p() {
        return this.f669m != null;
    }

    public boolean q() {
        return this.f670n != null;
    }

    public boolean r() {
        return this.f671o != null;
    }

    public boolean s() {
        return this.f651a.get(2);
    }

    public boolean t() {
        return this.f648a != null;
    }

    public String toString() {
        boolean z2 = false;
        StringBuilder sb = new StringBuilder("XmPushActionRegistration(");
        boolean z3 = true;
        if (m411a()) {
            sb.append("debug:");
            if (this.f650a == null) {
                sb.append("null");
            } else {
                sb.append(this.f650a);
            }
            z3 = false;
        }
        if (m413b()) {
            if (!z3) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f649a == null) {
                sb.append("null");
            } else {
                sb.append(this.f649a);
            }
        } else {
            z2 = z3;
        }
        if (!z2) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f656b == null) {
            sb.append("null");
        } else {
            sb.append(this.f656b);
        }
        sb.append(", ");
        sb.append("appId:");
        if (this.f659c == null) {
            sb.append("null");
        } else {
            sb.append(this.f659c);
        }
        if (e()) {
            sb.append(", ");
            sb.append("appVersion:");
            if (this.f660d == null) {
                sb.append("null");
            } else {
                sb.append(this.f660d);
            }
        }
        if (f()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f661e == null) {
                sb.append("null");
            } else {
                sb.append(this.f661e);
            }
        }
        sb.append(", ");
        sb.append("token:");
        if (this.f662f == null) {
            sb.append("null");
        } else {
            sb.append(this.f662f);
        }
        if (h()) {
            sb.append(", ");
            sb.append("deviceId:");
            if (this.f663g == null) {
                sb.append("null");
            } else {
                sb.append(this.f663g);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("aliasName:");
            if (this.f664h == null) {
                sb.append("null");
            } else {
                sb.append(this.f664h);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("sdkVersion:");
            if (this.f665i == null) {
                sb.append("null");
            } else {
                sb.append(this.f665i);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("regId:");
            if (this.f666j == null) {
                sb.append("null");
            } else {
                sb.append(this.f666j);
            }
        }
        if (l()) {
            sb.append(", ");
            sb.append("pushSdkVersionName:");
            if (this.f667k == null) {
                sb.append("null");
            } else {
                sb.append(this.f667k);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("pushSdkVersionCode:");
            sb.append(this.f646a);
        }
        if (n()) {
            sb.append(", ");
            sb.append("appVersionCode:");
            sb.append(this.f654b);
        }
        if (o()) {
            sb.append(", ");
            sb.append("androidId:");
            if (this.f668l == null) {
                sb.append("null");
            } else {
                sb.append(this.f668l);
            }
        }
        if (p()) {
            sb.append(", ");
            sb.append("imei:");
            if (this.f669m == null) {
                sb.append("null");
            } else {
                sb.append(this.f669m);
            }
        }
        if (q()) {
            sb.append(", ");
            sb.append("serial:");
            if (this.f670n == null) {
                sb.append("null");
            } else {
                sb.append(this.f670n);
            }
        }
        if (r()) {
            sb.append(", ");
            sb.append("imeiMd5:");
            if (this.f671o == null) {
                sb.append("null");
            } else {
                sb.append(this.f671o);
            }
        }
        if (s()) {
            sb.append(", ");
            sb.append("spaceId:");
            sb.append(this.f658c);
        }
        if (t()) {
            sb.append(", ");
            sb.append("reason:");
            if (this.f648a == null) {
                sb.append("null");
            } else {
                sb.append(this.f648a);
            }
        }
        if (u()) {
            sb.append(", ");
            sb.append("validateToken:");
            sb.append(this.f653a);
        }
        if (v()) {
            sb.append(", ");
            sb.append("miid:");
            sb.append(this.f647a);
        }
        if (w()) {
            sb.append(", ");
            sb.append("createdTs:");
            sb.append(this.f655b);
        }
        if (x()) {
            sb.append(", ");
            sb.append("subImei:");
            if (this.f672p == null) {
                sb.append("null");
            } else {
                sb.append(this.f672p);
            }
        }
        if (y()) {
            sb.append(", ");
            sb.append("subImeiMd5:");
            if (this.f673q == null) {
                sb.append("null");
            } else {
                sb.append(this.f673q);
            }
        }
        if (z()) {
            sb.append(", ");
            sb.append("connectionAttrs:");
            if (this.f652a == null) {
                sb.append("null");
            } else {
                sb.append(this.f652a);
            }
        }
        if (A()) {
            sb.append(", ");
            sb.append("cleanOldRegInfo:");
            sb.append(this.f657b);
        }
        if (B()) {
            sb.append(", ");
            sb.append("oldRegId:");
            if (this.f674r == null) {
                sb.append("null");
            } else {
                sb.append(this.f674r);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    public boolean u() {
        return this.f651a.get(3);
    }

    public boolean v() {
        return this.f651a.get(4);
    }

    public boolean w() {
        return this.f651a.get(5);
    }

    public boolean x() {
        return this.f672p != null;
    }

    public boolean y() {
        return this.f673q != null;
    }

    public boolean z() {
        return this.f652a != null;
    }
}
