package com.xiaomi.push;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.util.TbEnum;
import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes10.dex */
public class ih implements is<ih, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public int f663a;

    /* renamed from: a  reason: collision with other field name */
    public long f664a;

    /* renamed from: a  reason: collision with other field name */
    public hv f665a;

    /* renamed from: a  reason: collision with other field name */
    public hw f666a;

    /* renamed from: a  reason: collision with other field name */
    public String f667a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f669a;

    /* renamed from: b  reason: collision with other field name */
    public int f671b;

    /* renamed from: b  reason: collision with other field name */
    public long f672b;

    /* renamed from: b  reason: collision with other field name */
    public String f673b;

    /* renamed from: c  reason: collision with other field name */
    public int f675c;

    /* renamed from: c  reason: collision with other field name */
    public String f676c;

    /* renamed from: d  reason: collision with other field name */
    public String f678d;

    /* renamed from: e  reason: collision with other field name */
    public String f679e;

    /* renamed from: f  reason: collision with other field name */
    public String f680f;

    /* renamed from: g  reason: collision with other field name */
    public String f681g;

    /* renamed from: h  reason: collision with other field name */
    public String f682h;

    /* renamed from: i  reason: collision with other field name */
    public String f683i;

    /* renamed from: j  reason: collision with other field name */
    public String f684j;

    /* renamed from: k  reason: collision with other field name */
    public String f685k;

    /* renamed from: l  reason: collision with other field name */
    public String f686l;

    /* renamed from: m  reason: collision with other field name */
    public String f687m;

    /* renamed from: n  reason: collision with other field name */
    public String f688n;

    /* renamed from: o  reason: collision with other field name */
    public String f689o;

    /* renamed from: p  reason: collision with other field name */
    public String f690p;

    /* renamed from: q  reason: collision with other field name */
    public String f691q;

    /* renamed from: r  reason: collision with other field name */
    public String f692r;

    /* renamed from: a  reason: collision with other field name */
    public static final ji f662a = new ji("XmPushActionRegistration");
    public static final ja a = new ja("", Constants.GZIP_CAST_TYPE, 1);
    public static final ja b = new ja("", (byte) 12, 2);
    public static final ja c = new ja("", Constants.GZIP_CAST_TYPE, 3);
    public static final ja d = new ja("", Constants.GZIP_CAST_TYPE, 4);
    public static final ja e = new ja("", Constants.GZIP_CAST_TYPE, 5);
    public static final ja f = new ja("", Constants.GZIP_CAST_TYPE, 6);
    public static final ja g = new ja("", Constants.GZIP_CAST_TYPE, 7);
    public static final ja h = new ja("", Constants.GZIP_CAST_TYPE, 8);
    public static final ja i = new ja("", Constants.GZIP_CAST_TYPE, 9);
    public static final ja j = new ja("", Constants.GZIP_CAST_TYPE, 10);
    public static final ja k = new ja("", Constants.GZIP_CAST_TYPE, 11);
    public static final ja l = new ja("", Constants.GZIP_CAST_TYPE, 12);
    public static final ja m = new ja("", (byte) 8, 13);
    public static final ja n = new ja("", (byte) 8, 14);
    public static final ja o = new ja("", Constants.GZIP_CAST_TYPE, 15);
    public static final ja p = new ja("", Constants.GZIP_CAST_TYPE, 16);
    public static final ja q = new ja("", Constants.GZIP_CAST_TYPE, 17);
    public static final ja r = new ja("", Constants.GZIP_CAST_TYPE, 18);
    public static final ja s = new ja("", (byte) 8, 19);
    public static final ja t = new ja("", (byte) 8, 20);
    public static final ja u = new ja("", (byte) 2, 21);
    public static final ja v = new ja("", (byte) 10, 22);
    public static final ja w = new ja("", (byte) 10, 23);
    public static final ja x = new ja("", Constants.GZIP_CAST_TYPE, 24);
    public static final ja y = new ja("", Constants.GZIP_CAST_TYPE, 25);
    public static final ja z = new ja("", (byte) 2, 26);
    public static final ja A = new ja("", (byte) 13, 100);
    public static final ja B = new ja("", (byte) 2, TbEnum.MsgContentType.MSG_CONTENT_TYPE_TEXT_GEN_IMAGE);
    public static final ja C = new ja("", Constants.GZIP_CAST_TYPE, TbEnum.MsgContentType.MSG_CONTENT_TYPE_SINGLE_TEXT_IMAGE);

    /* renamed from: a  reason: collision with other field name */
    public BitSet f668a = new BitSet(8);

    /* renamed from: a  reason: collision with other field name */
    public boolean f670a = true;

    /* renamed from: c  reason: collision with other field name */
    public boolean f677c = false;

    /* renamed from: b  reason: collision with other field name */
    public boolean f674b = false;

    public boolean A() {
        return this.f669a != null;
    }

    public boolean B() {
        return this.f668a.get(7);
    }

    public boolean C() {
        return this.f692r != null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(ih ihVar) {
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
        int a30;
        if (ih.class.equals(ihVar.getClass())) {
            int compareTo = Boolean.valueOf(m649a()).compareTo(Boolean.valueOf(ihVar.m649a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m649a() || (a30 = it.a(this.f667a, ihVar.f667a)) == 0) {
                int compareTo2 = Boolean.valueOf(m651b()).compareTo(Boolean.valueOf(ihVar.m651b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!m651b() || (a29 = it.a(this.f666a, ihVar.f666a)) == 0) {
                    int compareTo3 = Boolean.valueOf(m652c()).compareTo(Boolean.valueOf(ihVar.m652c()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!m652c() || (a28 = it.a(this.f673b, ihVar.f673b)) == 0) {
                        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(ihVar.d()));
                        if (compareTo4 != 0) {
                            return compareTo4;
                        }
                        if (!d() || (a27 = it.a(this.f676c, ihVar.f676c)) == 0) {
                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(ihVar.e()));
                            if (compareTo5 != 0) {
                                return compareTo5;
                            }
                            if (!e() || (a26 = it.a(this.f678d, ihVar.f678d)) == 0) {
                                int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(ihVar.f()));
                                if (compareTo6 != 0) {
                                    return compareTo6;
                                }
                                if (!f() || (a25 = it.a(this.f679e, ihVar.f679e)) == 0) {
                                    int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ihVar.g()));
                                    if (compareTo7 != 0) {
                                        return compareTo7;
                                    }
                                    if (!g() || (a24 = it.a(this.f680f, ihVar.f680f)) == 0) {
                                        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(ihVar.h()));
                                        if (compareTo8 != 0) {
                                            return compareTo8;
                                        }
                                        if (!h() || (a23 = it.a(this.f681g, ihVar.f681g)) == 0) {
                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(ihVar.i()));
                                            if (compareTo9 != 0) {
                                                return compareTo9;
                                            }
                                            if (!i() || (a22 = it.a(this.f682h, ihVar.f682h)) == 0) {
                                                int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(ihVar.j()));
                                                if (compareTo10 != 0) {
                                                    return compareTo10;
                                                }
                                                if (!j() || (a21 = it.a(this.f683i, ihVar.f683i)) == 0) {
                                                    int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(ihVar.k()));
                                                    if (compareTo11 != 0) {
                                                        return compareTo11;
                                                    }
                                                    if (!k() || (a20 = it.a(this.f684j, ihVar.f684j)) == 0) {
                                                        int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(ihVar.l()));
                                                        if (compareTo12 != 0) {
                                                            return compareTo12;
                                                        }
                                                        if (!l() || (a19 = it.a(this.f685k, ihVar.f685k)) == 0) {
                                                            int compareTo13 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(ihVar.m()));
                                                            if (compareTo13 != 0) {
                                                                return compareTo13;
                                                            }
                                                            if (!m() || (a18 = it.a(this.f663a, ihVar.f663a)) == 0) {
                                                                int compareTo14 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(ihVar.n()));
                                                                if (compareTo14 != 0) {
                                                                    return compareTo14;
                                                                }
                                                                if (!n() || (a17 = it.a(this.f671b, ihVar.f671b)) == 0) {
                                                                    int compareTo15 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(ihVar.o()));
                                                                    if (compareTo15 != 0) {
                                                                        return compareTo15;
                                                                    }
                                                                    if (!o() || (a16 = it.a(this.f686l, ihVar.f686l)) == 0) {
                                                                        int compareTo16 = Boolean.valueOf(p()).compareTo(Boolean.valueOf(ihVar.p()));
                                                                        if (compareTo16 != 0) {
                                                                            return compareTo16;
                                                                        }
                                                                        if (!p() || (a15 = it.a(this.f687m, ihVar.f687m)) == 0) {
                                                                            int compareTo17 = Boolean.valueOf(q()).compareTo(Boolean.valueOf(ihVar.q()));
                                                                            if (compareTo17 != 0) {
                                                                                return compareTo17;
                                                                            }
                                                                            if (!q() || (a14 = it.a(this.f688n, ihVar.f688n)) == 0) {
                                                                                int compareTo18 = Boolean.valueOf(r()).compareTo(Boolean.valueOf(ihVar.r()));
                                                                                if (compareTo18 != 0) {
                                                                                    return compareTo18;
                                                                                }
                                                                                if (!r() || (a13 = it.a(this.f689o, ihVar.f689o)) == 0) {
                                                                                    int compareTo19 = Boolean.valueOf(s()).compareTo(Boolean.valueOf(ihVar.s()));
                                                                                    if (compareTo19 != 0) {
                                                                                        return compareTo19;
                                                                                    }
                                                                                    if (!s() || (a12 = it.a(this.f675c, ihVar.f675c)) == 0) {
                                                                                        int compareTo20 = Boolean.valueOf(t()).compareTo(Boolean.valueOf(ihVar.t()));
                                                                                        if (compareTo20 != 0) {
                                                                                            return compareTo20;
                                                                                        }
                                                                                        if (!t() || (a11 = it.a(this.f665a, ihVar.f665a)) == 0) {
                                                                                            int compareTo21 = Boolean.valueOf(u()).compareTo(Boolean.valueOf(ihVar.u()));
                                                                                            if (compareTo21 != 0) {
                                                                                                return compareTo21;
                                                                                            }
                                                                                            if (!u() || (a10 = it.a(this.f670a, ihVar.f670a)) == 0) {
                                                                                                int compareTo22 = Boolean.valueOf(v()).compareTo(Boolean.valueOf(ihVar.v()));
                                                                                                if (compareTo22 != 0) {
                                                                                                    return compareTo22;
                                                                                                }
                                                                                                if (!v() || (a9 = it.a(this.f664a, ihVar.f664a)) == 0) {
                                                                                                    int compareTo23 = Boolean.valueOf(w()).compareTo(Boolean.valueOf(ihVar.w()));
                                                                                                    if (compareTo23 != 0) {
                                                                                                        return compareTo23;
                                                                                                    }
                                                                                                    if (!w() || (a8 = it.a(this.f672b, ihVar.f672b)) == 0) {
                                                                                                        int compareTo24 = Boolean.valueOf(x()).compareTo(Boolean.valueOf(ihVar.x()));
                                                                                                        if (compareTo24 != 0) {
                                                                                                            return compareTo24;
                                                                                                        }
                                                                                                        if (!x() || (a7 = it.a(this.f690p, ihVar.f690p)) == 0) {
                                                                                                            int compareTo25 = Boolean.valueOf(y()).compareTo(Boolean.valueOf(ihVar.y()));
                                                                                                            if (compareTo25 != 0) {
                                                                                                                return compareTo25;
                                                                                                            }
                                                                                                            if (!y() || (a6 = it.a(this.f691q, ihVar.f691q)) == 0) {
                                                                                                                int compareTo26 = Boolean.valueOf(z()).compareTo(Boolean.valueOf(ihVar.z()));
                                                                                                                if (compareTo26 != 0) {
                                                                                                                    return compareTo26;
                                                                                                                }
                                                                                                                if (!z() || (a5 = it.a(this.f674b, ihVar.f674b)) == 0) {
                                                                                                                    int compareTo27 = Boolean.valueOf(A()).compareTo(Boolean.valueOf(ihVar.A()));
                                                                                                                    if (compareTo27 != 0) {
                                                                                                                        return compareTo27;
                                                                                                                    }
                                                                                                                    if (!A() || (a4 = it.a(this.f669a, ihVar.f669a)) == 0) {
                                                                                                                        int compareTo28 = Boolean.valueOf(B()).compareTo(Boolean.valueOf(ihVar.B()));
                                                                                                                        if (compareTo28 != 0) {
                                                                                                                            return compareTo28;
                                                                                                                        }
                                                                                                                        if (!B() || (a3 = it.a(this.f677c, ihVar.f677c)) == 0) {
                                                                                                                            int compareTo29 = Boolean.valueOf(C()).compareTo(Boolean.valueOf(ihVar.C()));
                                                                                                                            if (compareTo29 != 0) {
                                                                                                                                return compareTo29;
                                                                                                                            }
                                                                                                                            if (!C() || (a2 = it.a(this.f692r, ihVar.f692r)) == 0) {
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
                                            return a22;
                                        }
                                        return a23;
                                    }
                                    return a24;
                                }
                                return a25;
                            }
                            return a26;
                        }
                        return a27;
                    }
                    return a28;
                }
                return a29;
            }
            return a30;
        }
        return ih.class.getName().compareTo(ihVar.getClass().getName());
    }

    public ih a(int i2) {
        this.f663a = i2;
        a(true);
        return this;
    }

    public ih a(hv hvVar) {
        this.f665a = hvVar;
        return this;
    }

    public ih a(String str) {
        this.f673b = str;
        return this;
    }

    public String a() {
        return this.f673b;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m648a() {
        if (this.f673b == null) {
            throw new je("Required field 'id' was not present! Struct: " + toString());
        } else if (this.f676c == null) {
            throw new je("Required field 'appId' was not present! Struct: " + toString());
        } else if (this.f680f != null) {
        } else {
            throw new je("Required field 'token' was not present! Struct: " + toString());
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.xiaomi.push.is
    public void a(jd jdVar) {
        jdVar.mo700a();
        while (true) {
            ja mo696a = jdVar.mo696a();
            byte b2 = mo696a.a;
            if (b2 == 0) {
                jdVar.f();
                m648a();
                return;
            }
            short s2 = mo696a.f814a;
            switch (s2) {
                case 1:
                    if (b2 == 11) {
                        this.f667a = jdVar.mo701a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 2:
                    if (b2 == 12) {
                        hw hwVar = new hw();
                        this.f666a = hwVar;
                        hwVar.a(jdVar);
                        continue;
                        jdVar.g();
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f673b = jdVar.mo701a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f676c = jdVar.mo701a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 5:
                    if (b2 == 11) {
                        this.f678d = jdVar.mo701a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 6:
                    if (b2 == 11) {
                        this.f679e = jdVar.mo701a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f680f = jdVar.mo701a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 8:
                    if (b2 == 11) {
                        this.f681g = jdVar.mo701a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 9:
                    if (b2 == 11) {
                        this.f682h = jdVar.mo701a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 10:
                    if (b2 == 11) {
                        this.f683i = jdVar.mo701a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 11:
                    if (b2 == 11) {
                        this.f684j = jdVar.mo701a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 12:
                    if (b2 == 11) {
                        this.f685k = jdVar.mo701a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 13:
                    if (b2 == 8) {
                        this.f663a = jdVar.mo694a();
                        a(true);
                        continue;
                        jdVar.g();
                    }
                    break;
                case 14:
                    if (b2 == 8) {
                        this.f671b = jdVar.mo694a();
                        b(true);
                        continue;
                        jdVar.g();
                    }
                    break;
                case 15:
                    if (b2 == 11) {
                        this.f686l = jdVar.mo701a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 16:
                    if (b2 == 11) {
                        this.f687m = jdVar.mo701a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 17:
                    if (b2 == 11) {
                        this.f688n = jdVar.mo701a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 18:
                    if (b2 == 11) {
                        this.f689o = jdVar.mo701a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 19:
                    if (b2 == 8) {
                        this.f675c = jdVar.mo694a();
                        c(true);
                        continue;
                        jdVar.g();
                    }
                    break;
                case 20:
                    if (b2 == 8) {
                        this.f665a = hv.a(jdVar.mo694a());
                        continue;
                        jdVar.g();
                    }
                    break;
                case 21:
                    if (b2 == 2) {
                        this.f670a = jdVar.mo706a();
                        d(true);
                        continue;
                        jdVar.g();
                    }
                    break;
                case 22:
                    if (b2 == 10) {
                        this.f664a = jdVar.mo695a();
                        e(true);
                        continue;
                        jdVar.g();
                    }
                    break;
                case 23:
                    if (b2 == 10) {
                        this.f672b = jdVar.mo695a();
                        f(true);
                        continue;
                        jdVar.g();
                    }
                    break;
                case 24:
                    if (b2 == 11) {
                        this.f690p = jdVar.mo701a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 25:
                    if (b2 == 11) {
                        this.f691q = jdVar.mo701a();
                        continue;
                        jdVar.g();
                    }
                    break;
                case 26:
                    if (b2 == 2) {
                        this.f674b = jdVar.mo706a();
                        g(true);
                        continue;
                        jdVar.g();
                    }
                    break;
                default:
                    switch (s2) {
                        case 100:
                            if (b2 == 13) {
                                jc mo698a = jdVar.mo698a();
                                this.f669a = new HashMap(mo698a.f816a * 2);
                                for (int i2 = 0; i2 < mo698a.f816a; i2++) {
                                    this.f669a.put(jdVar.mo701a(), jdVar.mo701a());
                                }
                                jdVar.h();
                                break;
                            }
                            break;
                        case 101:
                            if (b2 == 2) {
                                this.f677c = jdVar.mo706a();
                                h(true);
                                break;
                            }
                            break;
                        case 102:
                            if (b2 == 11) {
                                this.f692r = jdVar.mo701a();
                                continue;
                            }
                            break;
                    }
                    jdVar.g();
                    break;
            }
            jg.a(jdVar, b2);
            jdVar.g();
        }
    }

    public void a(boolean z2) {
        this.f668a.set(0, z2);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m649a() {
        return this.f667a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m650a(ih ihVar) {
        if (ihVar == null) {
            return false;
        }
        boolean m649a = m649a();
        boolean m649a2 = ihVar.m649a();
        if ((m649a || m649a2) && !(m649a && m649a2 && this.f667a.equals(ihVar.f667a))) {
            return false;
        }
        boolean m651b = m651b();
        boolean m651b2 = ihVar.m651b();
        if ((m651b || m651b2) && !(m651b && m651b2 && this.f666a.m596a(ihVar.f666a))) {
            return false;
        }
        boolean m652c = m652c();
        boolean m652c2 = ihVar.m652c();
        if ((m652c || m652c2) && !(m652c && m652c2 && this.f673b.equals(ihVar.f673b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = ihVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f676c.equals(ihVar.f676c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = ihVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f678d.equals(ihVar.f678d))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = ihVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f679e.equals(ihVar.f679e))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = ihVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f680f.equals(ihVar.f680f))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = ihVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f681g.equals(ihVar.f681g))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = ihVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f682h.equals(ihVar.f682h))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = ihVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f683i.equals(ihVar.f683i))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = ihVar.k();
        if ((k2 || k3) && !(k2 && k3 && this.f684j.equals(ihVar.f684j))) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = ihVar.l();
        if ((l2 || l3) && !(l2 && l3 && this.f685k.equals(ihVar.f685k))) {
            return false;
        }
        boolean m2 = m();
        boolean m3 = ihVar.m();
        if ((m2 || m3) && !(m2 && m3 && this.f663a == ihVar.f663a)) {
            return false;
        }
        boolean n2 = n();
        boolean n3 = ihVar.n();
        if ((n2 || n3) && !(n2 && n3 && this.f671b == ihVar.f671b)) {
            return false;
        }
        boolean o2 = o();
        boolean o3 = ihVar.o();
        if ((o2 || o3) && !(o2 && o3 && this.f686l.equals(ihVar.f686l))) {
            return false;
        }
        boolean p2 = p();
        boolean p3 = ihVar.p();
        if ((p2 || p3) && !(p2 && p3 && this.f687m.equals(ihVar.f687m))) {
            return false;
        }
        boolean q2 = q();
        boolean q3 = ihVar.q();
        if ((q2 || q3) && !(q2 && q3 && this.f688n.equals(ihVar.f688n))) {
            return false;
        }
        boolean r2 = r();
        boolean r3 = ihVar.r();
        if ((r2 || r3) && !(r2 && r3 && this.f689o.equals(ihVar.f689o))) {
            return false;
        }
        boolean s2 = s();
        boolean s3 = ihVar.s();
        if ((s2 || s3) && !(s2 && s3 && this.f675c == ihVar.f675c)) {
            return false;
        }
        boolean t2 = t();
        boolean t3 = ihVar.t();
        if ((t2 || t3) && !(t2 && t3 && this.f665a.equals(ihVar.f665a))) {
            return false;
        }
        boolean u2 = u();
        boolean u3 = ihVar.u();
        if ((u2 || u3) && !(u2 && u3 && this.f670a == ihVar.f670a)) {
            return false;
        }
        boolean v2 = v();
        boolean v3 = ihVar.v();
        if ((v2 || v3) && !(v2 && v3 && this.f664a == ihVar.f664a)) {
            return false;
        }
        boolean w2 = w();
        boolean w3 = ihVar.w();
        if ((w2 || w3) && !(w2 && w3 && this.f672b == ihVar.f672b)) {
            return false;
        }
        boolean x2 = x();
        boolean x3 = ihVar.x();
        if ((x2 || x3) && !(x2 && x3 && this.f690p.equals(ihVar.f690p))) {
            return false;
        }
        boolean y2 = y();
        boolean y3 = ihVar.y();
        if ((y2 || y3) && !(y2 && y3 && this.f691q.equals(ihVar.f691q))) {
            return false;
        }
        boolean z2 = z();
        boolean z3 = ihVar.z();
        if ((z2 || z3) && !(z2 && z3 && this.f674b == ihVar.f674b)) {
            return false;
        }
        boolean A2 = A();
        boolean A3 = ihVar.A();
        if ((A2 || A3) && !(A2 && A3 && this.f669a.equals(ihVar.f669a))) {
            return false;
        }
        boolean B2 = B();
        boolean B3 = ihVar.B();
        if ((B2 || B3) && !(B2 && B3 && this.f677c == ihVar.f677c)) {
            return false;
        }
        boolean C2 = C();
        boolean C3 = ihVar.C();
        if (C2 || C3) {
            return C2 && C3 && this.f692r.equals(ihVar.f692r);
        }
        return true;
    }

    public ih b(int i2) {
        this.f671b = i2;
        b(true);
        return this;
    }

    public ih b(String str) {
        this.f676c = str;
        return this;
    }

    public String b() {
        return this.f676c;
    }

    @Override // com.xiaomi.push.is
    public void b(jd jdVar) {
        m648a();
        jdVar.a(f662a);
        if (this.f667a != null && m649a()) {
            jdVar.a(a);
            jdVar.a(this.f667a);
            jdVar.b();
        }
        if (this.f666a != null && m651b()) {
            jdVar.a(b);
            this.f666a.b(jdVar);
            jdVar.b();
        }
        if (this.f673b != null) {
            jdVar.a(c);
            jdVar.a(this.f673b);
            jdVar.b();
        }
        if (this.f676c != null) {
            jdVar.a(d);
            jdVar.a(this.f676c);
            jdVar.b();
        }
        if (this.f678d != null && e()) {
            jdVar.a(e);
            jdVar.a(this.f678d);
            jdVar.b();
        }
        if (this.f679e != null && f()) {
            jdVar.a(f);
            jdVar.a(this.f679e);
            jdVar.b();
        }
        if (this.f680f != null) {
            jdVar.a(g);
            jdVar.a(this.f680f);
            jdVar.b();
        }
        if (this.f681g != null && h()) {
            jdVar.a(h);
            jdVar.a(this.f681g);
            jdVar.b();
        }
        if (this.f682h != null && i()) {
            jdVar.a(i);
            jdVar.a(this.f682h);
            jdVar.b();
        }
        if (this.f683i != null && j()) {
            jdVar.a(j);
            jdVar.a(this.f683i);
            jdVar.b();
        }
        if (this.f684j != null && k()) {
            jdVar.a(k);
            jdVar.a(this.f684j);
            jdVar.b();
        }
        if (this.f685k != null && l()) {
            jdVar.a(l);
            jdVar.a(this.f685k);
            jdVar.b();
        }
        if (m()) {
            jdVar.a(m);
            jdVar.mo705a(this.f663a);
            jdVar.b();
        }
        if (n()) {
            jdVar.a(n);
            jdVar.mo705a(this.f671b);
            jdVar.b();
        }
        if (this.f686l != null && o()) {
            jdVar.a(o);
            jdVar.a(this.f686l);
            jdVar.b();
        }
        if (this.f687m != null && p()) {
            jdVar.a(p);
            jdVar.a(this.f687m);
            jdVar.b();
        }
        if (this.f688n != null && q()) {
            jdVar.a(q);
            jdVar.a(this.f688n);
            jdVar.b();
        }
        if (this.f689o != null && r()) {
            jdVar.a(r);
            jdVar.a(this.f689o);
            jdVar.b();
        }
        if (s()) {
            jdVar.a(s);
            jdVar.mo705a(this.f675c);
            jdVar.b();
        }
        if (this.f665a != null && t()) {
            jdVar.a(t);
            jdVar.mo705a(this.f665a.a());
            jdVar.b();
        }
        if (u()) {
            jdVar.a(u);
            jdVar.a(this.f670a);
            jdVar.b();
        }
        if (v()) {
            jdVar.a(v);
            jdVar.a(this.f664a);
            jdVar.b();
        }
        if (w()) {
            jdVar.a(w);
            jdVar.a(this.f672b);
            jdVar.b();
        }
        if (this.f690p != null && x()) {
            jdVar.a(x);
            jdVar.a(this.f690p);
            jdVar.b();
        }
        if (this.f691q != null && y()) {
            jdVar.a(y);
            jdVar.a(this.f691q);
            jdVar.b();
        }
        if (z()) {
            jdVar.a(z);
            jdVar.a(this.f674b);
            jdVar.b();
        }
        if (this.f669a != null && A()) {
            jdVar.a(A);
            jdVar.a(new jc(Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, this.f669a.size()));
            for (Map.Entry<String, String> entry : this.f669a.entrySet()) {
                jdVar.a(entry.getKey());
                jdVar.a(entry.getValue());
            }
            jdVar.d();
            jdVar.b();
        }
        if (B()) {
            jdVar.a(B);
            jdVar.a(this.f677c);
            jdVar.b();
        }
        if (this.f692r != null && C()) {
            jdVar.a(C);
            jdVar.a(this.f692r);
            jdVar.b();
        }
        jdVar.c();
        jdVar.mo704a();
    }

    public void b(boolean z2) {
        this.f668a.set(1, z2);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m651b() {
        return this.f666a != null;
    }

    public ih c(int i2) {
        this.f675c = i2;
        c(true);
        return this;
    }

    public ih c(String str) {
        this.f678d = str;
        return this;
    }

    public String c() {
        return this.f680f;
    }

    public void c(boolean z2) {
        this.f668a.set(2, z2);
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m652c() {
        return this.f673b != null;
    }

    public ih d(String str) {
        this.f679e = str;
        return this;
    }

    public void d(boolean z2) {
        this.f668a.set(3, z2);
    }

    public boolean d() {
        return this.f676c != null;
    }

    public ih e(String str) {
        this.f680f = str;
        return this;
    }

    public void e(boolean z2) {
        this.f668a.set(4, z2);
    }

    public boolean e() {
        return this.f678d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ih)) {
            return m650a((ih) obj);
        }
        return false;
    }

    public ih f(String str) {
        this.f681g = str;
        return this;
    }

    public void f(boolean z2) {
        this.f668a.set(5, z2);
    }

    public boolean f() {
        return this.f679e != null;
    }

    public ih g(String str) {
        this.f682h = str;
        return this;
    }

    public void g(boolean z2) {
        this.f668a.set(6, z2);
    }

    public boolean g() {
        return this.f680f != null;
    }

    public ih h(String str) {
        this.f685k = str;
        return this;
    }

    public void h(boolean z2) {
        this.f668a.set(7, z2);
    }

    public boolean h() {
        return this.f681g != null;
    }

    public int hashCode() {
        return 0;
    }

    public ih i(String str) {
        this.f689o = str;
        return this;
    }

    public boolean i() {
        return this.f682h != null;
    }

    public boolean j() {
        return this.f683i != null;
    }

    public boolean k() {
        return this.f684j != null;
    }

    public boolean l() {
        return this.f685k != null;
    }

    public boolean m() {
        return this.f668a.get(0);
    }

    public boolean n() {
        return this.f668a.get(1);
    }

    public boolean o() {
        return this.f686l != null;
    }

    public boolean p() {
        return this.f687m != null;
    }

    public boolean q() {
        return this.f688n != null;
    }

    public boolean r() {
        return this.f689o != null;
    }

    public boolean s() {
        return this.f668a.get(2);
    }

    public boolean t() {
        return this.f665a != null;
    }

    public String toString() {
        boolean z2;
        StringBuilder sb = new StringBuilder("XmPushActionRegistration(");
        boolean z3 = false;
        if (m649a()) {
            sb.append("debug:");
            String str = this.f667a;
            if (str == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str);
            }
            z2 = false;
        } else {
            z2 = true;
        }
        if (m651b()) {
            if (!z2) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            }
            sb.append("target:");
            hw hwVar = this.f666a;
            if (hwVar == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(hwVar);
            }
        } else {
            z3 = z2;
        }
        if (!z3) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        }
        sb.append("id:");
        String str2 = this.f673b;
        if (str2 == null) {
            sb.append(StringUtil.NULL_STRING);
        } else {
            sb.append(com.xiaomi.push.service.bd.a(str2));
        }
        sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        sb.append("appId:");
        String str3 = this.f676c;
        if (str3 == null) {
            sb.append(StringUtil.NULL_STRING);
        } else {
            sb.append(str3);
        }
        if (e()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("appVersion:");
            String str4 = this.f678d;
            if (str4 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str4);
            }
        }
        if (f()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("packageName:");
            String str5 = this.f679e;
            if (str5 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str5);
            }
        }
        sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        sb.append("token:");
        String str6 = this.f680f;
        if (str6 == null) {
            sb.append(StringUtil.NULL_STRING);
        } else {
            sb.append(str6);
        }
        if (h()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("deviceId:");
            String str7 = this.f681g;
            if (str7 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str7);
            }
        }
        if (i()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("aliasName:");
            String str8 = this.f682h;
            if (str8 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str8);
            }
        }
        if (j()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("sdkVersion:");
            String str9 = this.f683i;
            if (str9 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str9);
            }
        }
        if (k()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("regId:");
            String str10 = this.f684j;
            if (str10 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str10);
            }
        }
        if (l()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("pushSdkVersionName:");
            String str11 = this.f685k;
            if (str11 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str11);
            }
        }
        if (m()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("pushSdkVersionCode:");
            sb.append(this.f663a);
        }
        if (n()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("appVersionCode:");
            sb.append(this.f671b);
        }
        if (o()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("androidId:");
            String str12 = this.f686l;
            if (str12 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str12);
            }
        }
        if (p()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("imei:");
            String str13 = this.f687m;
            if (str13 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str13);
            }
        }
        if (q()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("serial:");
            String str14 = this.f688n;
            if (str14 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str14);
            }
        }
        if (r()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("imeiMd5:");
            String str15 = this.f689o;
            if (str15 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str15);
            }
        }
        if (s()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("spaceId:");
            sb.append(this.f675c);
        }
        if (t()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("reason:");
            hv hvVar = this.f665a;
            if (hvVar == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(hvVar);
            }
        }
        if (u()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("validateToken:");
            sb.append(this.f670a);
        }
        if (v()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("miid:");
            sb.append(this.f664a);
        }
        if (w()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("createdTs:");
            sb.append(this.f672b);
        }
        if (x()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("subImei:");
            String str16 = this.f690p;
            if (str16 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str16);
            }
        }
        if (y()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("subImeiMd5:");
            String str17 = this.f691q;
            if (str17 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str17);
            }
        }
        if (z()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("isHybridFrame:");
            sb.append(this.f674b);
        }
        if (A()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("connectionAttrs:");
            Map<String, String> map = this.f669a;
            if (map == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(map);
            }
        }
        if (B()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("cleanOldRegInfo:");
            sb.append(this.f677c);
        }
        if (C()) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("oldRegId:");
            String str18 = this.f692r;
            if (str18 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str18);
            }
        }
        sb.append(SmallTailInfo.EMOTION_SUFFIX);
        return sb.toString();
    }

    public boolean u() {
        return this.f668a.get(3);
    }

    public boolean v() {
        return this.f668a.get(4);
    }

    public boolean w() {
        return this.f668a.get(5);
    }

    public boolean x() {
        return this.f690p != null;
    }

    public boolean y() {
        return this.f691q != null;
    }

    public boolean z() {
        return this.f668a.get(6);
    }
}
