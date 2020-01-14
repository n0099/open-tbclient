package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class ig implements ir<ig, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public int f645a;

    /* renamed from: a  reason: collision with other field name */
    public long f646a;

    /* renamed from: a  reason: collision with other field name */
    public hu f647a;

    /* renamed from: a  reason: collision with other field name */
    public hv f648a;

    /* renamed from: a  reason: collision with other field name */
    public String f649a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f651a;

    /* renamed from: b  reason: collision with other field name */
    public int f653b;

    /* renamed from: b  reason: collision with other field name */
    public long f654b;

    /* renamed from: b  reason: collision with other field name */
    public String f655b;

    /* renamed from: c  reason: collision with other field name */
    public int f657c;

    /* renamed from: c  reason: collision with other field name */
    public String f658c;

    /* renamed from: d  reason: collision with other field name */
    public String f659d;

    /* renamed from: e  reason: collision with other field name */
    public String f660e;

    /* renamed from: f  reason: collision with other field name */
    public String f661f;

    /* renamed from: g  reason: collision with other field name */
    public String f662g;

    /* renamed from: h  reason: collision with other field name */
    public String f663h;

    /* renamed from: i  reason: collision with other field name */
    public String f664i;

    /* renamed from: j  reason: collision with other field name */
    public String f665j;

    /* renamed from: k  reason: collision with other field name */
    public String f666k;

    /* renamed from: l  reason: collision with other field name */
    public String f667l;

    /* renamed from: m  reason: collision with other field name */
    public String f668m;

    /* renamed from: n  reason: collision with other field name */
    public String f669n;

    /* renamed from: o  reason: collision with other field name */
    public String f670o;

    /* renamed from: p  reason: collision with other field name */
    public String f671p;

    /* renamed from: q  reason: collision with other field name */
    public String f672q;

    /* renamed from: r  reason: collision with other field name */
    public String f673r;

    /* renamed from: a  reason: collision with other field name */
    private static final jh f644a = new jh("XmPushActionRegistration");
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
    private BitSet f650a = new BitSet(7);

    /* renamed from: a  reason: collision with other field name */
    public boolean f652a = true;

    /* renamed from: b  reason: collision with other field name */
    public boolean f656b = false;

    public boolean A() {
        return this.f650a.get(6);
    }

    public boolean B() {
        return this.f673r != null;
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
            int compareTo = Boolean.valueOf(m420a()).compareTo(Boolean.valueOf(igVar.m420a()));
            if (compareTo == 0) {
                if (!m420a() || (a29 = is.a(this.f649a, igVar.f649a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m422b()).compareTo(Boolean.valueOf(igVar.m422b()));
                    if (compareTo2 == 0) {
                        if (!m422b() || (a28 = is.a(this.f648a, igVar.f648a)) == 0) {
                            int compareTo3 = Boolean.valueOf(m423c()).compareTo(Boolean.valueOf(igVar.m423c()));
                            if (compareTo3 == 0) {
                                if (!m423c() || (a27 = is.a(this.f655b, igVar.f655b)) == 0) {
                                    int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(igVar.d()));
                                    if (compareTo4 == 0) {
                                        if (!d() || (a26 = is.a(this.f658c, igVar.f658c)) == 0) {
                                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(igVar.e()));
                                            if (compareTo5 == 0) {
                                                if (!e() || (a25 = is.a(this.f659d, igVar.f659d)) == 0) {
                                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(igVar.f()));
                                                    if (compareTo6 == 0) {
                                                        if (!f() || (a24 = is.a(this.f660e, igVar.f660e)) == 0) {
                                                            int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(igVar.g()));
                                                            if (compareTo7 == 0) {
                                                                if (!g() || (a23 = is.a(this.f661f, igVar.f661f)) == 0) {
                                                                    int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(igVar.h()));
                                                                    if (compareTo8 == 0) {
                                                                        if (!h() || (a22 = is.a(this.f662g, igVar.f662g)) == 0) {
                                                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(igVar.i()));
                                                                            if (compareTo9 == 0) {
                                                                                if (!i() || (a21 = is.a(this.f663h, igVar.f663h)) == 0) {
                                                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(igVar.j()));
                                                                                    if (compareTo10 == 0) {
                                                                                        if (!j() || (a20 = is.a(this.f664i, igVar.f664i)) == 0) {
                                                                                            int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(igVar.k()));
                                                                                            if (compareTo11 == 0) {
                                                                                                if (!k() || (a19 = is.a(this.f665j, igVar.f665j)) == 0) {
                                                                                                    int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(igVar.l()));
                                                                                                    if (compareTo12 == 0) {
                                                                                                        if (!l() || (a18 = is.a(this.f666k, igVar.f666k)) == 0) {
                                                                                                            int compareTo13 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(igVar.m()));
                                                                                                            if (compareTo13 == 0) {
                                                                                                                if (!m() || (a17 = is.a(this.f645a, igVar.f645a)) == 0) {
                                                                                                                    int compareTo14 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(igVar.n()));
                                                                                                                    if (compareTo14 == 0) {
                                                                                                                        if (!n() || (a16 = is.a(this.f653b, igVar.f653b)) == 0) {
                                                                                                                            int compareTo15 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(igVar.o()));
                                                                                                                            if (compareTo15 == 0) {
                                                                                                                                if (!o() || (a15 = is.a(this.f667l, igVar.f667l)) == 0) {
                                                                                                                                    int compareTo16 = Boolean.valueOf(p()).compareTo(Boolean.valueOf(igVar.p()));
                                                                                                                                    if (compareTo16 == 0) {
                                                                                                                                        if (!p() || (a14 = is.a(this.f668m, igVar.f668m)) == 0) {
                                                                                                                                            int compareTo17 = Boolean.valueOf(q()).compareTo(Boolean.valueOf(igVar.q()));
                                                                                                                                            if (compareTo17 == 0) {
                                                                                                                                                if (!q() || (a13 = is.a(this.f669n, igVar.f669n)) == 0) {
                                                                                                                                                    int compareTo18 = Boolean.valueOf(r()).compareTo(Boolean.valueOf(igVar.r()));
                                                                                                                                                    if (compareTo18 == 0) {
                                                                                                                                                        if (!r() || (a12 = is.a(this.f670o, igVar.f670o)) == 0) {
                                                                                                                                                            int compareTo19 = Boolean.valueOf(s()).compareTo(Boolean.valueOf(igVar.s()));
                                                                                                                                                            if (compareTo19 == 0) {
                                                                                                                                                                if (!s() || (a11 = is.a(this.f657c, igVar.f657c)) == 0) {
                                                                                                                                                                    int compareTo20 = Boolean.valueOf(t()).compareTo(Boolean.valueOf(igVar.t()));
                                                                                                                                                                    if (compareTo20 == 0) {
                                                                                                                                                                        if (!t() || (a10 = is.a(this.f647a, igVar.f647a)) == 0) {
                                                                                                                                                                            int compareTo21 = Boolean.valueOf(u()).compareTo(Boolean.valueOf(igVar.u()));
                                                                                                                                                                            if (compareTo21 == 0) {
                                                                                                                                                                                if (!u() || (a9 = is.a(this.f652a, igVar.f652a)) == 0) {
                                                                                                                                                                                    int compareTo22 = Boolean.valueOf(v()).compareTo(Boolean.valueOf(igVar.v()));
                                                                                                                                                                                    if (compareTo22 == 0) {
                                                                                                                                                                                        if (!v() || (a8 = is.a(this.f646a, igVar.f646a)) == 0) {
                                                                                                                                                                                            int compareTo23 = Boolean.valueOf(w()).compareTo(Boolean.valueOf(igVar.w()));
                                                                                                                                                                                            if (compareTo23 == 0) {
                                                                                                                                                                                                if (!w() || (a7 = is.a(this.f654b, igVar.f654b)) == 0) {
                                                                                                                                                                                                    int compareTo24 = Boolean.valueOf(x()).compareTo(Boolean.valueOf(igVar.x()));
                                                                                                                                                                                                    if (compareTo24 == 0) {
                                                                                                                                                                                                        if (!x() || (a6 = is.a(this.f671p, igVar.f671p)) == 0) {
                                                                                                                                                                                                            int compareTo25 = Boolean.valueOf(y()).compareTo(Boolean.valueOf(igVar.y()));
                                                                                                                                                                                                            if (compareTo25 == 0) {
                                                                                                                                                                                                                if (!y() || (a5 = is.a(this.f672q, igVar.f672q)) == 0) {
                                                                                                                                                                                                                    int compareTo26 = Boolean.valueOf(z()).compareTo(Boolean.valueOf(igVar.z()));
                                                                                                                                                                                                                    if (compareTo26 == 0) {
                                                                                                                                                                                                                        if (!z() || (a4 = is.a(this.f651a, igVar.f651a)) == 0) {
                                                                                                                                                                                                                            int compareTo27 = Boolean.valueOf(A()).compareTo(Boolean.valueOf(igVar.A()));
                                                                                                                                                                                                                            if (compareTo27 == 0) {
                                                                                                                                                                                                                                if (!A() || (a3 = is.a(this.f656b, igVar.f656b)) == 0) {
                                                                                                                                                                                                                                    int compareTo28 = Boolean.valueOf(B()).compareTo(Boolean.valueOf(igVar.B()));
                                                                                                                                                                                                                                    if (compareTo28 == 0) {
                                                                                                                                                                                                                                        if (!B() || (a2 = is.a(this.f673r, igVar.f673r)) == 0) {
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
        this.f645a = i2;
        a(true);
        return this;
    }

    public ig a(hu huVar) {
        this.f647a = huVar;
        return this;
    }

    public ig a(String str) {
        this.f655b = str;
        return this;
    }

    public String a() {
        return this.f655b;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m419a() {
        if (this.f655b == null) {
            throw new jd("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f658c == null) {
            throw new jd("Required field 'appId' was not present! Struct: " + toString());
        }
        if (this.f661f == null) {
            throw new jd("Required field 'token' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.ir
    public void a(jc jcVar) {
        jcVar.m467a();
        while (true) {
            iz m463a = jcVar.m463a();
            if (m463a.a == 0) {
                jcVar.f();
                m419a();
                return;
            }
            switch (m463a.f792a) {
                case 1:
                    if (m463a.a == 11) {
                        this.f649a = jcVar.m468a();
                        break;
                    } else {
                        jf.a(jcVar, m463a.a);
                        break;
                    }
                case 2:
                    if (m463a.a == 12) {
                        this.f648a = new hv();
                        this.f648a.a(jcVar);
                        break;
                    } else {
                        jf.a(jcVar, m463a.a);
                        break;
                    }
                case 3:
                    if (m463a.a == 11) {
                        this.f655b = jcVar.m468a();
                        break;
                    } else {
                        jf.a(jcVar, m463a.a);
                        break;
                    }
                case 4:
                    if (m463a.a == 11) {
                        this.f658c = jcVar.m468a();
                        break;
                    } else {
                        jf.a(jcVar, m463a.a);
                        break;
                    }
                case 5:
                    if (m463a.a == 11) {
                        this.f659d = jcVar.m468a();
                        break;
                    } else {
                        jf.a(jcVar, m463a.a);
                        break;
                    }
                case 6:
                    if (m463a.a == 11) {
                        this.f660e = jcVar.m468a();
                        break;
                    } else {
                        jf.a(jcVar, m463a.a);
                        break;
                    }
                case 7:
                    if (m463a.a == 11) {
                        this.f661f = jcVar.m468a();
                        break;
                    } else {
                        jf.a(jcVar, m463a.a);
                        break;
                    }
                case 8:
                    if (m463a.a == 11) {
                        this.f662g = jcVar.m468a();
                        break;
                    } else {
                        jf.a(jcVar, m463a.a);
                        break;
                    }
                case 9:
                    if (m463a.a == 11) {
                        this.f663h = jcVar.m468a();
                        break;
                    } else {
                        jf.a(jcVar, m463a.a);
                        break;
                    }
                case 10:
                    if (m463a.a == 11) {
                        this.f664i = jcVar.m468a();
                        break;
                    } else {
                        jf.a(jcVar, m463a.a);
                        break;
                    }
                case 11:
                    if (m463a.a == 11) {
                        this.f665j = jcVar.m468a();
                        break;
                    } else {
                        jf.a(jcVar, m463a.a);
                        break;
                    }
                case 12:
                    if (m463a.a == 11) {
                        this.f666k = jcVar.m468a();
                        break;
                    } else {
                        jf.a(jcVar, m463a.a);
                        break;
                    }
                case 13:
                    if (m463a.a == 8) {
                        this.f645a = jcVar.m461a();
                        a(true);
                        break;
                    } else {
                        jf.a(jcVar, m463a.a);
                        break;
                    }
                case 14:
                    if (m463a.a == 8) {
                        this.f653b = jcVar.m461a();
                        b(true);
                        break;
                    } else {
                        jf.a(jcVar, m463a.a);
                        break;
                    }
                case 15:
                    if (m463a.a == 11) {
                        this.f667l = jcVar.m468a();
                        break;
                    } else {
                        jf.a(jcVar, m463a.a);
                        break;
                    }
                case 16:
                    if (m463a.a == 11) {
                        this.f668m = jcVar.m468a();
                        break;
                    } else {
                        jf.a(jcVar, m463a.a);
                        break;
                    }
                case 17:
                    if (m463a.a == 11) {
                        this.f669n = jcVar.m468a();
                        break;
                    } else {
                        jf.a(jcVar, m463a.a);
                        break;
                    }
                case 18:
                    if (m463a.a == 11) {
                        this.f670o = jcVar.m468a();
                        break;
                    } else {
                        jf.a(jcVar, m463a.a);
                        break;
                    }
                case 19:
                    if (m463a.a == 8) {
                        this.f657c = jcVar.m461a();
                        c(true);
                        break;
                    } else {
                        jf.a(jcVar, m463a.a);
                        break;
                    }
                case 20:
                    if (m463a.a == 8) {
                        this.f647a = hu.a(jcVar.m461a());
                        break;
                    } else {
                        jf.a(jcVar, m463a.a);
                        break;
                    }
                case 21:
                    if (m463a.a == 2) {
                        this.f652a = jcVar.m472a();
                        d(true);
                        break;
                    } else {
                        jf.a(jcVar, m463a.a);
                        break;
                    }
                case 22:
                    if (m463a.a == 10) {
                        this.f646a = jcVar.m462a();
                        e(true);
                        break;
                    } else {
                        jf.a(jcVar, m463a.a);
                        break;
                    }
                case 23:
                    if (m463a.a == 10) {
                        this.f654b = jcVar.m462a();
                        f(true);
                        break;
                    } else {
                        jf.a(jcVar, m463a.a);
                        break;
                    }
                case 24:
                    if (m463a.a == 11) {
                        this.f671p = jcVar.m468a();
                        break;
                    } else {
                        jf.a(jcVar, m463a.a);
                        break;
                    }
                case 25:
                    if (m463a.a == 11) {
                        this.f672q = jcVar.m468a();
                        break;
                    } else {
                        jf.a(jcVar, m463a.a);
                        break;
                    }
                case 100:
                    if (m463a.a == 13) {
                        jb m465a = jcVar.m465a();
                        this.f651a = new HashMap(m465a.f796a * 2);
                        for (int i2 = 0; i2 < m465a.f796a; i2++) {
                            this.f651a.put(jcVar.m468a(), jcVar.m468a());
                        }
                        jcVar.h();
                        break;
                    } else {
                        jf.a(jcVar, m463a.a);
                        break;
                    }
                case 101:
                    if (m463a.a == 2) {
                        this.f656b = jcVar.m472a();
                        g(true);
                        break;
                    } else {
                        jf.a(jcVar, m463a.a);
                        break;
                    }
                case 102:
                    if (m463a.a == 11) {
                        this.f673r = jcVar.m468a();
                        break;
                    } else {
                        jf.a(jcVar, m463a.a);
                        break;
                    }
                default:
                    jf.a(jcVar, m463a.a);
                    break;
            }
            jcVar.g();
        }
    }

    public void a(boolean z2) {
        this.f650a.set(0, z2);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m420a() {
        return this.f649a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m421a(ig igVar) {
        if (igVar == null) {
            return false;
        }
        boolean m420a = m420a();
        boolean m420a2 = igVar.m420a();
        if ((m420a || m420a2) && !(m420a && m420a2 && this.f649a.equals(igVar.f649a))) {
            return false;
        }
        boolean m422b = m422b();
        boolean m422b2 = igVar.m422b();
        if ((m422b || m422b2) && !(m422b && m422b2 && this.f648a.m373a(igVar.f648a))) {
            return false;
        }
        boolean m423c = m423c();
        boolean m423c2 = igVar.m423c();
        if ((m423c || m423c2) && !(m423c && m423c2 && this.f655b.equals(igVar.f655b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = igVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f658c.equals(igVar.f658c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = igVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f659d.equals(igVar.f659d))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = igVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f660e.equals(igVar.f660e))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = igVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f661f.equals(igVar.f661f))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = igVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f662g.equals(igVar.f662g))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = igVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f663h.equals(igVar.f663h))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = igVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f664i.equals(igVar.f664i))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = igVar.k();
        if ((k2 || k3) && !(k2 && k3 && this.f665j.equals(igVar.f665j))) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = igVar.l();
        if ((l2 || l3) && !(l2 && l3 && this.f666k.equals(igVar.f666k))) {
            return false;
        }
        boolean m2 = m();
        boolean m3 = igVar.m();
        if ((m2 || m3) && !(m2 && m3 && this.f645a == igVar.f645a)) {
            return false;
        }
        boolean n2 = n();
        boolean n3 = igVar.n();
        if ((n2 || n3) && !(n2 && n3 && this.f653b == igVar.f653b)) {
            return false;
        }
        boolean o2 = o();
        boolean o3 = igVar.o();
        if ((o2 || o3) && !(o2 && o3 && this.f667l.equals(igVar.f667l))) {
            return false;
        }
        boolean p2 = p();
        boolean p3 = igVar.p();
        if ((p2 || p3) && !(p2 && p3 && this.f668m.equals(igVar.f668m))) {
            return false;
        }
        boolean q2 = q();
        boolean q3 = igVar.q();
        if ((q2 || q3) && !(q2 && q3 && this.f669n.equals(igVar.f669n))) {
            return false;
        }
        boolean r2 = r();
        boolean r3 = igVar.r();
        if ((r2 || r3) && !(r2 && r3 && this.f670o.equals(igVar.f670o))) {
            return false;
        }
        boolean s2 = s();
        boolean s3 = igVar.s();
        if ((s2 || s3) && !(s2 && s3 && this.f657c == igVar.f657c)) {
            return false;
        }
        boolean t2 = t();
        boolean t3 = igVar.t();
        if ((t2 || t3) && !(t2 && t3 && this.f647a.equals(igVar.f647a))) {
            return false;
        }
        boolean u2 = u();
        boolean u3 = igVar.u();
        if ((u2 || u3) && !(u2 && u3 && this.f652a == igVar.f652a)) {
            return false;
        }
        boolean v2 = v();
        boolean v3 = igVar.v();
        if ((v2 || v3) && !(v2 && v3 && this.f646a == igVar.f646a)) {
            return false;
        }
        boolean w2 = w();
        boolean w3 = igVar.w();
        if ((w2 || w3) && !(w2 && w3 && this.f654b == igVar.f654b)) {
            return false;
        }
        boolean x2 = x();
        boolean x3 = igVar.x();
        if ((x2 || x3) && !(x2 && x3 && this.f671p.equals(igVar.f671p))) {
            return false;
        }
        boolean y2 = y();
        boolean y3 = igVar.y();
        if ((y2 || y3) && !(y2 && y3 && this.f672q.equals(igVar.f672q))) {
            return false;
        }
        boolean z2 = z();
        boolean z3 = igVar.z();
        if ((z2 || z3) && !(z2 && z3 && this.f651a.equals(igVar.f651a))) {
            return false;
        }
        boolean A2 = A();
        boolean A3 = igVar.A();
        if ((A2 || A3) && !(A2 && A3 && this.f656b == igVar.f656b)) {
            return false;
        }
        boolean B2 = B();
        boolean B3 = igVar.B();
        return !(B2 || B3) || (B2 && B3 && this.f673r.equals(igVar.f673r));
    }

    public ig b(int i2) {
        this.f653b = i2;
        b(true);
        return this;
    }

    public ig b(String str) {
        this.f658c = str;
        return this;
    }

    public String b() {
        return this.f658c;
    }

    @Override // com.xiaomi.push.ir
    public void b(jc jcVar) {
        m419a();
        jcVar.a(f644a);
        if (this.f649a != null && m420a()) {
            jcVar.a(a);
            jcVar.a(this.f649a);
            jcVar.b();
        }
        if (this.f648a != null && m422b()) {
            jcVar.a(b);
            this.f648a.b(jcVar);
            jcVar.b();
        }
        if (this.f655b != null) {
            jcVar.a(c);
            jcVar.a(this.f655b);
            jcVar.b();
        }
        if (this.f658c != null) {
            jcVar.a(d);
            jcVar.a(this.f658c);
            jcVar.b();
        }
        if (this.f659d != null && e()) {
            jcVar.a(e);
            jcVar.a(this.f659d);
            jcVar.b();
        }
        if (this.f660e != null && f()) {
            jcVar.a(f);
            jcVar.a(this.f660e);
            jcVar.b();
        }
        if (this.f661f != null) {
            jcVar.a(g);
            jcVar.a(this.f661f);
            jcVar.b();
        }
        if (this.f662g != null && h()) {
            jcVar.a(h);
            jcVar.a(this.f662g);
            jcVar.b();
        }
        if (this.f663h != null && i()) {
            jcVar.a(i);
            jcVar.a(this.f663h);
            jcVar.b();
        }
        if (this.f664i != null && j()) {
            jcVar.a(j);
            jcVar.a(this.f664i);
            jcVar.b();
        }
        if (this.f665j != null && k()) {
            jcVar.a(k);
            jcVar.a(this.f665j);
            jcVar.b();
        }
        if (this.f666k != null && l()) {
            jcVar.a(l);
            jcVar.a(this.f666k);
            jcVar.b();
        }
        if (m()) {
            jcVar.a(m);
            jcVar.a(this.f645a);
            jcVar.b();
        }
        if (n()) {
            jcVar.a(n);
            jcVar.a(this.f653b);
            jcVar.b();
        }
        if (this.f667l != null && o()) {
            jcVar.a(o);
            jcVar.a(this.f667l);
            jcVar.b();
        }
        if (this.f668m != null && p()) {
            jcVar.a(p);
            jcVar.a(this.f668m);
            jcVar.b();
        }
        if (this.f669n != null && q()) {
            jcVar.a(q);
            jcVar.a(this.f669n);
            jcVar.b();
        }
        if (this.f670o != null && r()) {
            jcVar.a(r);
            jcVar.a(this.f670o);
            jcVar.b();
        }
        if (s()) {
            jcVar.a(s);
            jcVar.a(this.f657c);
            jcVar.b();
        }
        if (this.f647a != null && t()) {
            jcVar.a(t);
            jcVar.a(this.f647a.a());
            jcVar.b();
        }
        if (u()) {
            jcVar.a(u);
            jcVar.a(this.f652a);
            jcVar.b();
        }
        if (v()) {
            jcVar.a(v);
            jcVar.a(this.f646a);
            jcVar.b();
        }
        if (w()) {
            jcVar.a(w);
            jcVar.a(this.f654b);
            jcVar.b();
        }
        if (this.f671p != null && x()) {
            jcVar.a(x);
            jcVar.a(this.f671p);
            jcVar.b();
        }
        if (this.f672q != null && y()) {
            jcVar.a(y);
            jcVar.a(this.f672q);
            jcVar.b();
        }
        if (this.f651a != null && z()) {
            jcVar.a(z);
            jcVar.a(new jb(Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, this.f651a.size()));
            for (Map.Entry<String, String> entry : this.f651a.entrySet()) {
                jcVar.a(entry.getKey());
                jcVar.a(entry.getValue());
            }
            jcVar.d();
            jcVar.b();
        }
        if (A()) {
            jcVar.a(A);
            jcVar.a(this.f656b);
            jcVar.b();
        }
        if (this.f673r != null && B()) {
            jcVar.a(B);
            jcVar.a(this.f673r);
            jcVar.b();
        }
        jcVar.c();
        jcVar.m471a();
    }

    public void b(boolean z2) {
        this.f650a.set(1, z2);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m422b() {
        return this.f648a != null;
    }

    public ig c(int i2) {
        this.f657c = i2;
        c(true);
        return this;
    }

    public ig c(String str) {
        this.f659d = str;
        return this;
    }

    public String c() {
        return this.f661f;
    }

    public void c(boolean z2) {
        this.f650a.set(2, z2);
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m423c() {
        return this.f655b != null;
    }

    public ig d(String str) {
        this.f660e = str;
        return this;
    }

    public void d(boolean z2) {
        this.f650a.set(3, z2);
    }

    public boolean d() {
        return this.f658c != null;
    }

    public ig e(String str) {
        this.f661f = str;
        return this;
    }

    public void e(boolean z2) {
        this.f650a.set(4, z2);
    }

    public boolean e() {
        return this.f659d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ig)) {
            return m421a((ig) obj);
        }
        return false;
    }

    public ig f(String str) {
        this.f662g = str;
        return this;
    }

    public void f(boolean z2) {
        this.f650a.set(5, z2);
    }

    public boolean f() {
        return this.f660e != null;
    }

    public ig g(String str) {
        this.f666k = str;
        return this;
    }

    public void g(boolean z2) {
        this.f650a.set(6, z2);
    }

    public boolean g() {
        return this.f661f != null;
    }

    public ig h(String str) {
        this.f667l = str;
        return this;
    }

    public boolean h() {
        return this.f662g != null;
    }

    public int hashCode() {
        return 0;
    }

    public ig i(String str) {
        this.f668m = str;
        return this;
    }

    public boolean i() {
        return this.f663h != null;
    }

    public ig j(String str) {
        this.f669n = str;
        return this;
    }

    public boolean j() {
        return this.f664i != null;
    }

    public ig k(String str) {
        this.f670o = str;
        return this;
    }

    public boolean k() {
        return this.f665j != null;
    }

    public boolean l() {
        return this.f666k != null;
    }

    public boolean m() {
        return this.f650a.get(0);
    }

    public boolean n() {
        return this.f650a.get(1);
    }

    public boolean o() {
        return this.f667l != null;
    }

    public boolean p() {
        return this.f668m != null;
    }

    public boolean q() {
        return this.f669n != null;
    }

    public boolean r() {
        return this.f670o != null;
    }

    public boolean s() {
        return this.f650a.get(2);
    }

    public boolean t() {
        return this.f647a != null;
    }

    public String toString() {
        boolean z2 = false;
        StringBuilder sb = new StringBuilder("XmPushActionRegistration(");
        boolean z3 = true;
        if (m420a()) {
            sb.append("debug:");
            if (this.f649a == null) {
                sb.append("null");
            } else {
                sb.append(this.f649a);
            }
            z3 = false;
        }
        if (m422b()) {
            if (!z3) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f648a == null) {
                sb.append("null");
            } else {
                sb.append(this.f648a);
            }
        } else {
            z2 = z3;
        }
        if (!z2) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f655b == null) {
            sb.append("null");
        } else {
            sb.append(this.f655b);
        }
        sb.append(", ");
        sb.append("appId:");
        if (this.f658c == null) {
            sb.append("null");
        } else {
            sb.append(this.f658c);
        }
        if (e()) {
            sb.append(", ");
            sb.append("appVersion:");
            if (this.f659d == null) {
                sb.append("null");
            } else {
                sb.append(this.f659d);
            }
        }
        if (f()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f660e == null) {
                sb.append("null");
            } else {
                sb.append(this.f660e);
            }
        }
        sb.append(", ");
        sb.append("token:");
        if (this.f661f == null) {
            sb.append("null");
        } else {
            sb.append(this.f661f);
        }
        if (h()) {
            sb.append(", ");
            sb.append("deviceId:");
            if (this.f662g == null) {
                sb.append("null");
            } else {
                sb.append(this.f662g);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("aliasName:");
            if (this.f663h == null) {
                sb.append("null");
            } else {
                sb.append(this.f663h);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("sdkVersion:");
            if (this.f664i == null) {
                sb.append("null");
            } else {
                sb.append(this.f664i);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("regId:");
            if (this.f665j == null) {
                sb.append("null");
            } else {
                sb.append(this.f665j);
            }
        }
        if (l()) {
            sb.append(", ");
            sb.append("pushSdkVersionName:");
            if (this.f666k == null) {
                sb.append("null");
            } else {
                sb.append(this.f666k);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("pushSdkVersionCode:");
            sb.append(this.f645a);
        }
        if (n()) {
            sb.append(", ");
            sb.append("appVersionCode:");
            sb.append(this.f653b);
        }
        if (o()) {
            sb.append(", ");
            sb.append("androidId:");
            if (this.f667l == null) {
                sb.append("null");
            } else {
                sb.append(this.f667l);
            }
        }
        if (p()) {
            sb.append(", ");
            sb.append("imei:");
            if (this.f668m == null) {
                sb.append("null");
            } else {
                sb.append(this.f668m);
            }
        }
        if (q()) {
            sb.append(", ");
            sb.append("serial:");
            if (this.f669n == null) {
                sb.append("null");
            } else {
                sb.append(this.f669n);
            }
        }
        if (r()) {
            sb.append(", ");
            sb.append("imeiMd5:");
            if (this.f670o == null) {
                sb.append("null");
            } else {
                sb.append(this.f670o);
            }
        }
        if (s()) {
            sb.append(", ");
            sb.append("spaceId:");
            sb.append(this.f657c);
        }
        if (t()) {
            sb.append(", ");
            sb.append("reason:");
            if (this.f647a == null) {
                sb.append("null");
            } else {
                sb.append(this.f647a);
            }
        }
        if (u()) {
            sb.append(", ");
            sb.append("validateToken:");
            sb.append(this.f652a);
        }
        if (v()) {
            sb.append(", ");
            sb.append("miid:");
            sb.append(this.f646a);
        }
        if (w()) {
            sb.append(", ");
            sb.append("createdTs:");
            sb.append(this.f654b);
        }
        if (x()) {
            sb.append(", ");
            sb.append("subImei:");
            if (this.f671p == null) {
                sb.append("null");
            } else {
                sb.append(this.f671p);
            }
        }
        if (y()) {
            sb.append(", ");
            sb.append("subImeiMd5:");
            if (this.f672q == null) {
                sb.append("null");
            } else {
                sb.append(this.f672q);
            }
        }
        if (z()) {
            sb.append(", ");
            sb.append("connectionAttrs:");
            if (this.f651a == null) {
                sb.append("null");
            } else {
                sb.append(this.f651a);
            }
        }
        if (A()) {
            sb.append(", ");
            sb.append("cleanOldRegInfo:");
            sb.append(this.f656b);
        }
        if (B()) {
            sb.append(", ");
            sb.append("oldRegId:");
            if (this.f673r == null) {
                sb.append("null");
            } else {
                sb.append(this.f673r);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    public boolean u() {
        return this.f650a.get(3);
    }

    public boolean v() {
        return this.f650a.get(4);
    }

    public boolean w() {
        return this.f650a.get(5);
    }

    public boolean x() {
        return this.f671p != null;
    }

    public boolean y() {
        return this.f672q != null;
    }

    public boolean z() {
        return this.f651a != null;
    }
}
