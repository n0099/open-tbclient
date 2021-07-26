package com.xiaomi.push;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.flutter.plugin.common.StandardMessageCodec;
import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
/* renamed from: com.xiaomi.push.if  reason: invalid class name */
/* loaded from: classes6.dex */
public class Cif implements iq<Cif, Object>, Serializable, Cloneable {
    public static /* synthetic */ Interceptable $ic;
    public static final iy A;
    public static final iy B;
    public static final iy C;

    /* renamed from: a  reason: collision with root package name */
    public static final iy f40681a;

    /* renamed from: a  reason: collision with other field name */
    public static final jg f661a;

    /* renamed from: b  reason: collision with root package name */
    public static final iy f40682b;

    /* renamed from: c  reason: collision with root package name */
    public static final iy f40683c;

    /* renamed from: d  reason: collision with root package name */
    public static final iy f40684d;

    /* renamed from: e  reason: collision with root package name */
    public static final iy f40685e;

    /* renamed from: f  reason: collision with root package name */
    public static final iy f40686f;

    /* renamed from: g  reason: collision with root package name */
    public static final iy f40687g;

    /* renamed from: h  reason: collision with root package name */
    public static final iy f40688h;

    /* renamed from: i  reason: collision with root package name */
    public static final iy f40689i;
    public static final iy j;
    public static final iy k;
    public static final iy l;
    public static final iy m;
    public static final iy n;
    public static final iy o;
    public static final iy p;
    public static final iy q;
    public static final iy r;
    public static final iy s;
    public static final iy t;
    public static final iy u;
    public static final iy v;
    public static final iy w;
    public static final iy x;
    public static final iy y;
    public static final iy z;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public int f662a;

    /* renamed from: a  reason: collision with other field name */
    public long f663a;

    /* renamed from: a  reason: collision with other field name */
    public ht f664a;

    /* renamed from: a  reason: collision with other field name */
    public hu f665a;

    /* renamed from: a  reason: collision with other field name */
    public String f666a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f667a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f668a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f669a;

    /* renamed from: b  reason: collision with other field name */
    public int f670b;

    /* renamed from: b  reason: collision with other field name */
    public long f671b;

    /* renamed from: b  reason: collision with other field name */
    public String f672b;

    /* renamed from: b  reason: collision with other field name */
    public boolean f673b;

    /* renamed from: c  reason: collision with other field name */
    public int f674c;

    /* renamed from: c  reason: collision with other field name */
    public String f675c;

    /* renamed from: c  reason: collision with other field name */
    public boolean f676c;

    /* renamed from: d  reason: collision with other field name */
    public String f677d;

    /* renamed from: e  reason: collision with other field name */
    public String f678e;

    /* renamed from: f  reason: collision with other field name */
    public String f679f;

    /* renamed from: g  reason: collision with other field name */
    public String f680g;

    /* renamed from: h  reason: collision with other field name */
    public String f681h;

    /* renamed from: i  reason: collision with other field name */
    public String f682i;

    /* renamed from: j  reason: collision with other field name */
    public String f683j;

    /* renamed from: k  reason: collision with other field name */
    public String f684k;

    /* renamed from: l  reason: collision with other field name */
    public String f685l;

    /* renamed from: m  reason: collision with other field name */
    public String f686m;

    /* renamed from: n  reason: collision with other field name */
    public String f687n;

    /* renamed from: o  reason: collision with other field name */
    public String f688o;

    /* renamed from: p  reason: collision with other field name */
    public String f689p;

    /* renamed from: q  reason: collision with other field name */
    public String f690q;

    /* renamed from: r  reason: collision with other field name */
    public String f691r;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-56372029, "Lcom/xiaomi/push/if;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-56372029, "Lcom/xiaomi/push/if;");
                return;
            }
        }
        f661a = new jg("XmPushActionRegistration");
        f40681a = new iy("", (byte) 11, (short) 1);
        f40682b = new iy("", StandardMessageCodec.LIST, (short) 2);
        f40683c = new iy("", (byte) 11, (short) 3);
        f40684d = new iy("", (byte) 11, (short) 4);
        f40685e = new iy("", (byte) 11, (short) 5);
        f40686f = new iy("", (byte) 11, (short) 6);
        f40687g = new iy("", (byte) 11, (short) 7);
        f40688h = new iy("", (byte) 11, (short) 8);
        f40689i = new iy("", (byte) 11, (short) 9);
        j = new iy("", (byte) 11, (short) 10);
        k = new iy("", (byte) 11, (short) 11);
        l = new iy("", (byte) 11, (short) 12);
        m = new iy("", (byte) 8, (short) 13);
        n = new iy("", (byte) 8, (short) 14);
        o = new iy("", (byte) 11, (short) 15);
        p = new iy("", (byte) 11, (short) 16);
        q = new iy("", (byte) 11, (short) 17);
        r = new iy("", (byte) 11, (short) 18);
        s = new iy("", (byte) 8, (short) 19);
        t = new iy("", (byte) 8, (short) 20);
        u = new iy("", (byte) 2, (short) 21);
        v = new iy("", (byte) 10, (short) 22);
        w = new iy("", (byte) 10, (short) 23);
        x = new iy("", (byte) 11, (short) 24);
        y = new iy("", (byte) 11, (short) 25);
        z = new iy("", (byte) 2, (short) 26);
        A = new iy("", (byte) 13, (short) 100);
        B = new iy("", (byte) 2, (short) 101);
        C = new iy("", (byte) 11, (short) 102);
    }

    public Cif() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f667a = new BitSet(8);
        this.f669a = true;
        this.f676c = false;
        this.f673b = false;
    }

    public boolean A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f668a != null : invokeV.booleanValue;
    }

    public boolean B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f667a.get(7) : invokeV.booleanValue;
    }

    public boolean C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f691r != null : invokeV.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(Cif cif) {
        InterceptResult invokeL;
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
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, cif)) == null) {
            if (Cif.class.equals(cif.getClass())) {
                int compareTo = Boolean.valueOf(m475a()).compareTo(Boolean.valueOf(cif.m475a()));
                if (compareTo != 0) {
                    return compareTo;
                }
                if (!m475a() || (a30 = ir.a(this.f666a, cif.f666a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m477b()).compareTo(Boolean.valueOf(cif.m477b()));
                    if (compareTo2 != 0) {
                        return compareTo2;
                    }
                    if (!m477b() || (a29 = ir.a(this.f665a, cif.f665a)) == 0) {
                        int compareTo3 = Boolean.valueOf(m478c()).compareTo(Boolean.valueOf(cif.m478c()));
                        if (compareTo3 != 0) {
                            return compareTo3;
                        }
                        if (!m478c() || (a28 = ir.a(this.f672b, cif.f672b)) == 0) {
                            int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(cif.d()));
                            if (compareTo4 != 0) {
                                return compareTo4;
                            }
                            if (!d() || (a27 = ir.a(this.f675c, cif.f675c)) == 0) {
                                int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(cif.e()));
                                if (compareTo5 != 0) {
                                    return compareTo5;
                                }
                                if (!e() || (a26 = ir.a(this.f677d, cif.f677d)) == 0) {
                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(cif.f()));
                                    if (compareTo6 != 0) {
                                        return compareTo6;
                                    }
                                    if (!f() || (a25 = ir.a(this.f678e, cif.f678e)) == 0) {
                                        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(cif.g()));
                                        if (compareTo7 != 0) {
                                            return compareTo7;
                                        }
                                        if (!g() || (a24 = ir.a(this.f679f, cif.f679f)) == 0) {
                                            int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(cif.h()));
                                            if (compareTo8 != 0) {
                                                return compareTo8;
                                            }
                                            if (!h() || (a23 = ir.a(this.f680g, cif.f680g)) == 0) {
                                                int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(cif.i()));
                                                if (compareTo9 != 0) {
                                                    return compareTo9;
                                                }
                                                if (!i() || (a22 = ir.a(this.f681h, cif.f681h)) == 0) {
                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(cif.j()));
                                                    if (compareTo10 != 0) {
                                                        return compareTo10;
                                                    }
                                                    if (!j() || (a21 = ir.a(this.f682i, cif.f682i)) == 0) {
                                                        int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(cif.k()));
                                                        if (compareTo11 != 0) {
                                                            return compareTo11;
                                                        }
                                                        if (!k() || (a20 = ir.a(this.f683j, cif.f683j)) == 0) {
                                                            int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(cif.l()));
                                                            if (compareTo12 != 0) {
                                                                return compareTo12;
                                                            }
                                                            if (!l() || (a19 = ir.a(this.f684k, cif.f684k)) == 0) {
                                                                int compareTo13 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(cif.m()));
                                                                if (compareTo13 != 0) {
                                                                    return compareTo13;
                                                                }
                                                                if (!m() || (a18 = ir.a(this.f662a, cif.f662a)) == 0) {
                                                                    int compareTo14 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(cif.n()));
                                                                    if (compareTo14 != 0) {
                                                                        return compareTo14;
                                                                    }
                                                                    if (!n() || (a17 = ir.a(this.f670b, cif.f670b)) == 0) {
                                                                        int compareTo15 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(cif.o()));
                                                                        if (compareTo15 != 0) {
                                                                            return compareTo15;
                                                                        }
                                                                        if (!o() || (a16 = ir.a(this.f685l, cif.f685l)) == 0) {
                                                                            int compareTo16 = Boolean.valueOf(p()).compareTo(Boolean.valueOf(cif.p()));
                                                                            if (compareTo16 != 0) {
                                                                                return compareTo16;
                                                                            }
                                                                            if (!p() || (a15 = ir.a(this.f686m, cif.f686m)) == 0) {
                                                                                int compareTo17 = Boolean.valueOf(q()).compareTo(Boolean.valueOf(cif.q()));
                                                                                if (compareTo17 != 0) {
                                                                                    return compareTo17;
                                                                                }
                                                                                if (!q() || (a14 = ir.a(this.f687n, cif.f687n)) == 0) {
                                                                                    int compareTo18 = Boolean.valueOf(r()).compareTo(Boolean.valueOf(cif.r()));
                                                                                    if (compareTo18 != 0) {
                                                                                        return compareTo18;
                                                                                    }
                                                                                    if (!r() || (a13 = ir.a(this.f688o, cif.f688o)) == 0) {
                                                                                        int compareTo19 = Boolean.valueOf(s()).compareTo(Boolean.valueOf(cif.s()));
                                                                                        if (compareTo19 != 0) {
                                                                                            return compareTo19;
                                                                                        }
                                                                                        if (!s() || (a12 = ir.a(this.f674c, cif.f674c)) == 0) {
                                                                                            int compareTo20 = Boolean.valueOf(t()).compareTo(Boolean.valueOf(cif.t()));
                                                                                            if (compareTo20 != 0) {
                                                                                                return compareTo20;
                                                                                            }
                                                                                            if (!t() || (a11 = ir.a(this.f664a, cif.f664a)) == 0) {
                                                                                                int compareTo21 = Boolean.valueOf(u()).compareTo(Boolean.valueOf(cif.u()));
                                                                                                if (compareTo21 != 0) {
                                                                                                    return compareTo21;
                                                                                                }
                                                                                                if (!u() || (a10 = ir.a(this.f669a, cif.f669a)) == 0) {
                                                                                                    int compareTo22 = Boolean.valueOf(v()).compareTo(Boolean.valueOf(cif.v()));
                                                                                                    if (compareTo22 != 0) {
                                                                                                        return compareTo22;
                                                                                                    }
                                                                                                    if (!v() || (a9 = ir.a(this.f663a, cif.f663a)) == 0) {
                                                                                                        int compareTo23 = Boolean.valueOf(w()).compareTo(Boolean.valueOf(cif.w()));
                                                                                                        if (compareTo23 != 0) {
                                                                                                            return compareTo23;
                                                                                                        }
                                                                                                        if (!w() || (a8 = ir.a(this.f671b, cif.f671b)) == 0) {
                                                                                                            int compareTo24 = Boolean.valueOf(x()).compareTo(Boolean.valueOf(cif.x()));
                                                                                                            if (compareTo24 != 0) {
                                                                                                                return compareTo24;
                                                                                                            }
                                                                                                            if (!x() || (a7 = ir.a(this.f689p, cif.f689p)) == 0) {
                                                                                                                int compareTo25 = Boolean.valueOf(y()).compareTo(Boolean.valueOf(cif.y()));
                                                                                                                if (compareTo25 != 0) {
                                                                                                                    return compareTo25;
                                                                                                                }
                                                                                                                if (!y() || (a6 = ir.a(this.f690q, cif.f690q)) == 0) {
                                                                                                                    int compareTo26 = Boolean.valueOf(z()).compareTo(Boolean.valueOf(cif.z()));
                                                                                                                    if (compareTo26 != 0) {
                                                                                                                        return compareTo26;
                                                                                                                    }
                                                                                                                    if (!z() || (a5 = ir.a(this.f673b, cif.f673b)) == 0) {
                                                                                                                        int compareTo27 = Boolean.valueOf(A()).compareTo(Boolean.valueOf(cif.A()));
                                                                                                                        if (compareTo27 != 0) {
                                                                                                                            return compareTo27;
                                                                                                                        }
                                                                                                                        if (!A() || (a4 = ir.a(this.f668a, cif.f668a)) == 0) {
                                                                                                                            int compareTo28 = Boolean.valueOf(B()).compareTo(Boolean.valueOf(cif.B()));
                                                                                                                            if (compareTo28 != 0) {
                                                                                                                                return compareTo28;
                                                                                                                            }
                                                                                                                            if (!B() || (a3 = ir.a(this.f676c, cif.f676c)) == 0) {
                                                                                                                                int compareTo29 = Boolean.valueOf(C()).compareTo(Boolean.valueOf(cif.C()));
                                                                                                                                if (compareTo29 != 0) {
                                                                                                                                    return compareTo29;
                                                                                                                                }
                                                                                                                                if (!C() || (a2 = ir.a(this.f691r, cif.f691r)) == 0) {
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
            return Cif.class.getName().compareTo(cif.getClass().getName());
        }
        return invokeL.intValue;
    }

    public Cif a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            this.f662a = i2;
            a(true);
            return this;
        }
        return (Cif) invokeI.objValue;
    }

    public Cif a(ht htVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, htVar)) == null) {
            this.f664a = htVar;
            return this;
        }
        return (Cif) invokeL.objValue;
    }

    public Cif a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            this.f672b = str;
            return this;
        }
        return (Cif) invokeL.objValue;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f672b : (String) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m474a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (this.f672b == null) {
                throw new jc("Required field 'id' was not present! Struct: " + toString());
            } else if (this.f675c == null) {
                throw new jc("Required field 'appId' was not present! Struct: " + toString());
            } else if (this.f679f != null) {
            } else {
                throw new jc("Required field 'token' was not present! Struct: " + toString());
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.xiaomi.push.iq
    public void a(jb jbVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(1048585, this, jbVar) != null) {
            return;
        }
        jbVar.m524a();
        while (true) {
            iy m520a = jbVar.m520a();
            byte b2 = m520a.f40780a;
            if (b2 == 0) {
                jbVar.f();
                m474a();
                return;
            }
            short s2 = m520a.f810a;
            switch (s2) {
                case 1:
                    if (b2 == 11) {
                        this.f666a = jbVar.m525a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 2:
                    if (b2 == 12) {
                        hu huVar = new hu();
                        this.f665a = huVar;
                        huVar.a(jbVar);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f672b = jbVar.m525a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f675c = jbVar.m525a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 5:
                    if (b2 == 11) {
                        this.f677d = jbVar.m525a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 6:
                    if (b2 == 11) {
                        this.f678e = jbVar.m525a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f679f = jbVar.m525a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 8:
                    if (b2 == 11) {
                        this.f680g = jbVar.m525a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 9:
                    if (b2 == 11) {
                        this.f681h = jbVar.m525a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 10:
                    if (b2 == 11) {
                        this.f682i = jbVar.m525a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 11:
                    if (b2 == 11) {
                        this.f683j = jbVar.m525a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 12:
                    if (b2 == 11) {
                        this.f684k = jbVar.m525a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 13:
                    if (b2 == 8) {
                        this.f662a = jbVar.m518a();
                        a(true);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 14:
                    if (b2 == 8) {
                        this.f670b = jbVar.m518a();
                        b(true);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 15:
                    if (b2 == 11) {
                        this.f685l = jbVar.m525a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 16:
                    if (b2 == 11) {
                        this.f686m = jbVar.m525a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 17:
                    if (b2 == 11) {
                        this.f687n = jbVar.m525a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 18:
                    if (b2 == 11) {
                        this.f688o = jbVar.m525a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 19:
                    if (b2 == 8) {
                        this.f674c = jbVar.m518a();
                        c(true);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 20:
                    if (b2 == 8) {
                        this.f664a = ht.a(jbVar.m518a());
                        continue;
                        jbVar.g();
                    }
                    break;
                case 21:
                    if (b2 == 2) {
                        this.f669a = jbVar.m529a();
                        d(true);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 22:
                    if (b2 == 10) {
                        this.f663a = jbVar.m519a();
                        e(true);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 23:
                    if (b2 == 10) {
                        this.f671b = jbVar.m519a();
                        f(true);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 24:
                    if (b2 == 11) {
                        this.f689p = jbVar.m525a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 25:
                    if (b2 == 11) {
                        this.f690q = jbVar.m525a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 26:
                    if (b2 == 2) {
                        this.f673b = jbVar.m529a();
                        g(true);
                        continue;
                        jbVar.g();
                    }
                    break;
                default:
                    switch (s2) {
                        case 100:
                            if (b2 == 13) {
                                ja m522a = jbVar.m522a();
                                this.f668a = new HashMap(m522a.f814a * 2);
                                for (int i2 = 0; i2 < m522a.f814a; i2++) {
                                    this.f668a.put(jbVar.m525a(), jbVar.m525a());
                                }
                                jbVar.h();
                                break;
                            }
                            break;
                        case 101:
                            if (b2 == 2) {
                                this.f676c = jbVar.m529a();
                                h(true);
                                break;
                            }
                            break;
                        case 102:
                            if (b2 == 11) {
                                this.f691r = jbVar.m525a();
                                continue;
                            }
                            break;
                    }
                    jbVar.g();
                    break;
            }
            je.a(jbVar, b2);
            jbVar.g();
        }
    }

    public void a(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z2) == null) {
            this.f667a.set(0, z2);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m475a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f666a != null : invokeV.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m476a(Cif cif) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, cif)) == null) {
            if (cif == null) {
                return false;
            }
            boolean m475a = m475a();
            boolean m475a2 = cif.m475a();
            if ((m475a || m475a2) && !(m475a && m475a2 && this.f666a.equals(cif.f666a))) {
                return false;
            }
            boolean m477b = m477b();
            boolean m477b2 = cif.m477b();
            if ((m477b || m477b2) && !(m477b && m477b2 && this.f665a.m419a(cif.f665a))) {
                return false;
            }
            boolean m478c = m478c();
            boolean m478c2 = cif.m478c();
            if ((m478c || m478c2) && !(m478c && m478c2 && this.f672b.equals(cif.f672b))) {
                return false;
            }
            boolean d2 = d();
            boolean d3 = cif.d();
            if ((d2 || d3) && !(d2 && d3 && this.f675c.equals(cif.f675c))) {
                return false;
            }
            boolean e2 = e();
            boolean e3 = cif.e();
            if ((e2 || e3) && !(e2 && e3 && this.f677d.equals(cif.f677d))) {
                return false;
            }
            boolean f2 = f();
            boolean f3 = cif.f();
            if ((f2 || f3) && !(f2 && f3 && this.f678e.equals(cif.f678e))) {
                return false;
            }
            boolean g2 = g();
            boolean g3 = cif.g();
            if ((g2 || g3) && !(g2 && g3 && this.f679f.equals(cif.f679f))) {
                return false;
            }
            boolean h2 = h();
            boolean h3 = cif.h();
            if ((h2 || h3) && !(h2 && h3 && this.f680g.equals(cif.f680g))) {
                return false;
            }
            boolean i2 = i();
            boolean i3 = cif.i();
            if ((i2 || i3) && !(i2 && i3 && this.f681h.equals(cif.f681h))) {
                return false;
            }
            boolean j2 = j();
            boolean j3 = cif.j();
            if ((j2 || j3) && !(j2 && j3 && this.f682i.equals(cif.f682i))) {
                return false;
            }
            boolean k2 = k();
            boolean k3 = cif.k();
            if ((k2 || k3) && !(k2 && k3 && this.f683j.equals(cif.f683j))) {
                return false;
            }
            boolean l2 = l();
            boolean l3 = cif.l();
            if ((l2 || l3) && !(l2 && l3 && this.f684k.equals(cif.f684k))) {
                return false;
            }
            boolean m2 = m();
            boolean m3 = cif.m();
            if ((m2 || m3) && !(m2 && m3 && this.f662a == cif.f662a)) {
                return false;
            }
            boolean n2 = n();
            boolean n3 = cif.n();
            if ((n2 || n3) && !(n2 && n3 && this.f670b == cif.f670b)) {
                return false;
            }
            boolean o2 = o();
            boolean o3 = cif.o();
            if ((o2 || o3) && !(o2 && o3 && this.f685l.equals(cif.f685l))) {
                return false;
            }
            boolean p2 = p();
            boolean p3 = cif.p();
            if ((p2 || p3) && !(p2 && p3 && this.f686m.equals(cif.f686m))) {
                return false;
            }
            boolean q2 = q();
            boolean q3 = cif.q();
            if ((q2 || q3) && !(q2 && q3 && this.f687n.equals(cif.f687n))) {
                return false;
            }
            boolean r2 = r();
            boolean r3 = cif.r();
            if ((r2 || r3) && !(r2 && r3 && this.f688o.equals(cif.f688o))) {
                return false;
            }
            boolean s2 = s();
            boolean s3 = cif.s();
            if ((s2 || s3) && !(s2 && s3 && this.f674c == cif.f674c)) {
                return false;
            }
            boolean t2 = t();
            boolean t3 = cif.t();
            if ((t2 || t3) && !(t2 && t3 && this.f664a.equals(cif.f664a))) {
                return false;
            }
            boolean u2 = u();
            boolean u3 = cif.u();
            if ((u2 || u3) && !(u2 && u3 && this.f669a == cif.f669a)) {
                return false;
            }
            boolean v2 = v();
            boolean v3 = cif.v();
            if ((v2 || v3) && !(v2 && v3 && this.f663a == cif.f663a)) {
                return false;
            }
            boolean w2 = w();
            boolean w3 = cif.w();
            if ((w2 || w3) && !(w2 && w3 && this.f671b == cif.f671b)) {
                return false;
            }
            boolean x2 = x();
            boolean x3 = cif.x();
            if ((x2 || x3) && !(x2 && x3 && this.f689p.equals(cif.f689p))) {
                return false;
            }
            boolean y2 = y();
            boolean y3 = cif.y();
            if ((y2 || y3) && !(y2 && y3 && this.f690q.equals(cif.f690q))) {
                return false;
            }
            boolean z2 = z();
            boolean z3 = cif.z();
            if ((z2 || z3) && !(z2 && z3 && this.f673b == cif.f673b)) {
                return false;
            }
            boolean A2 = A();
            boolean A3 = cif.A();
            if ((A2 || A3) && !(A2 && A3 && this.f668a.equals(cif.f668a))) {
                return false;
            }
            boolean B2 = B();
            boolean B3 = cif.B();
            if ((B2 || B3) && !(B2 && B3 && this.f676c == cif.f676c)) {
                return false;
            }
            boolean C2 = C();
            boolean C3 = cif.C();
            if (C2 || C3) {
                return C2 && C3 && this.f691r.equals(cif.f691r);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public Cif b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i2)) == null) {
            this.f670b = i2;
            b(true);
            return this;
        }
        return (Cif) invokeI.objValue;
    }

    public Cif b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
            this.f675c = str;
            return this;
        }
        return (Cif) invokeL.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f675c : (String) invokeV.objValue;
    }

    @Override // com.xiaomi.push.iq
    public void b(jb jbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, jbVar) == null) {
            m474a();
            jbVar.a(f661a);
            if (this.f666a != null && m475a()) {
                jbVar.a(f40681a);
                jbVar.a(this.f666a);
                jbVar.b();
            }
            if (this.f665a != null && m477b()) {
                jbVar.a(f40682b);
                this.f665a.b(jbVar);
                jbVar.b();
            }
            if (this.f672b != null) {
                jbVar.a(f40683c);
                jbVar.a(this.f672b);
                jbVar.b();
            }
            if (this.f675c != null) {
                jbVar.a(f40684d);
                jbVar.a(this.f675c);
                jbVar.b();
            }
            if (this.f677d != null && e()) {
                jbVar.a(f40685e);
                jbVar.a(this.f677d);
                jbVar.b();
            }
            if (this.f678e != null && f()) {
                jbVar.a(f40686f);
                jbVar.a(this.f678e);
                jbVar.b();
            }
            if (this.f679f != null) {
                jbVar.a(f40687g);
                jbVar.a(this.f679f);
                jbVar.b();
            }
            if (this.f680g != null && h()) {
                jbVar.a(f40688h);
                jbVar.a(this.f680g);
                jbVar.b();
            }
            if (this.f681h != null && i()) {
                jbVar.a(f40689i);
                jbVar.a(this.f681h);
                jbVar.b();
            }
            if (this.f682i != null && j()) {
                jbVar.a(j);
                jbVar.a(this.f682i);
                jbVar.b();
            }
            if (this.f683j != null && k()) {
                jbVar.a(k);
                jbVar.a(this.f683j);
                jbVar.b();
            }
            if (this.f684k != null && l()) {
                jbVar.a(l);
                jbVar.a(this.f684k);
                jbVar.b();
            }
            if (m()) {
                jbVar.a(m);
                jbVar.a(this.f662a);
                jbVar.b();
            }
            if (n()) {
                jbVar.a(n);
                jbVar.a(this.f670b);
                jbVar.b();
            }
            if (this.f685l != null && o()) {
                jbVar.a(o);
                jbVar.a(this.f685l);
                jbVar.b();
            }
            if (this.f686m != null && p()) {
                jbVar.a(p);
                jbVar.a(this.f686m);
                jbVar.b();
            }
            if (this.f687n != null && q()) {
                jbVar.a(q);
                jbVar.a(this.f687n);
                jbVar.b();
            }
            if (this.f688o != null && r()) {
                jbVar.a(r);
                jbVar.a(this.f688o);
                jbVar.b();
            }
            if (s()) {
                jbVar.a(s);
                jbVar.a(this.f674c);
                jbVar.b();
            }
            if (this.f664a != null && t()) {
                jbVar.a(t);
                jbVar.a(this.f664a.a());
                jbVar.b();
            }
            if (u()) {
                jbVar.a(u);
                jbVar.a(this.f669a);
                jbVar.b();
            }
            if (v()) {
                jbVar.a(v);
                jbVar.a(this.f663a);
                jbVar.b();
            }
            if (w()) {
                jbVar.a(w);
                jbVar.a(this.f671b);
                jbVar.b();
            }
            if (this.f689p != null && x()) {
                jbVar.a(x);
                jbVar.a(this.f689p);
                jbVar.b();
            }
            if (this.f690q != null && y()) {
                jbVar.a(y);
                jbVar.a(this.f690q);
                jbVar.b();
            }
            if (z()) {
                jbVar.a(z);
                jbVar.a(this.f673b);
                jbVar.b();
            }
            if (this.f668a != null && A()) {
                jbVar.a(A);
                jbVar.a(new ja((byte) 11, (byte) 11, this.f668a.size()));
                for (Map.Entry<String, String> entry : this.f668a.entrySet()) {
                    jbVar.a(entry.getKey());
                    jbVar.a(entry.getValue());
                }
                jbVar.d();
                jbVar.b();
            }
            if (B()) {
                jbVar.a(B);
                jbVar.a(this.f676c);
                jbVar.b();
            }
            if (this.f691r != null && C()) {
                jbVar.a(C);
                jbVar.a(this.f691r);
                jbVar.b();
            }
            jbVar.c();
            jbVar.m528a();
        }
    }

    public void b(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z2) == null) {
            this.f667a.set(1, z2);
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m477b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f665a != null : invokeV.booleanValue;
    }

    public Cif c(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048595, this, i2)) == null) {
            this.f674c = i2;
            c(true);
            return this;
        }
        return (Cif) invokeI.objValue;
    }

    public Cif c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, str)) == null) {
            this.f677d = str;
            return this;
        }
        return (Cif) invokeL.objValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.f679f : (String) invokeV.objValue;
    }

    public void c(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z2) == null) {
            this.f667a.set(2, z2);
        }
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m478c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.f672b != null : invokeV.booleanValue;
    }

    public Cif d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, str)) == null) {
            this.f678e = str;
            return this;
        }
        return (Cif) invokeL.objValue;
    }

    public void d(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z2) == null) {
            this.f667a.set(3, z2);
        }
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.f675c != null : invokeV.booleanValue;
    }

    public Cif e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, str)) == null) {
            this.f679f = str;
            return this;
        }
        return (Cif) invokeL.objValue;
    }

    public void e(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048605, this, z2) == null) {
            this.f667a.set(4, z2);
        }
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.f677d != null : invokeV.booleanValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, obj)) == null) {
            if (obj != null && (obj instanceof Cif)) {
                return m476a((Cif) obj);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public Cif f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048608, this, str)) == null) {
            this.f680g = str;
            return this;
        }
        return (Cif) invokeL.objValue;
    }

    public void f(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048609, this, z2) == null) {
            this.f667a.set(5, z2);
        }
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.f678e != null : invokeV.booleanValue;
    }

    public Cif g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048611, this, str)) == null) {
            this.f681h = str;
            return this;
        }
        return (Cif) invokeL.objValue;
    }

    public void g(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048612, this, z2) == null) {
            this.f667a.set(6, z2);
        }
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? this.f679f != null : invokeV.booleanValue;
    }

    public Cif h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048614, this, str)) == null) {
            this.f684k = str;
            return this;
        }
        return (Cif) invokeL.objValue;
    }

    public void h(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048615, this, z2) == null) {
            this.f667a.set(7, z2);
        }
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? this.f680g != null : invokeV.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public Cif i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048618, this, str)) == null) {
            this.f688o = str;
            return this;
        }
        return (Cif) invokeL.objValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) ? this.f681h != null : invokeV.booleanValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) ? this.f682i != null : invokeV.booleanValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) ? this.f683j != null : invokeV.booleanValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) ? this.f684k != null : invokeV.booleanValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) ? this.f667a.get(0) : invokeV.booleanValue;
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) ? this.f667a.get(1) : invokeV.booleanValue;
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) ? this.f685l != null : invokeV.booleanValue;
    }

    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) ? this.f686m != null : invokeV.booleanValue;
    }

    public boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) ? this.f687n != null : invokeV.booleanValue;
    }

    public boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) ? this.f688o != null : invokeV.booleanValue;
    }

    public boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) ? this.f667a.get(2) : invokeV.booleanValue;
    }

    public boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) ? this.f664a != null : invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) {
            StringBuilder sb = new StringBuilder("XmPushActionRegistration(");
            boolean z3 = false;
            if (m475a()) {
                sb.append("debug:");
                String str = this.f666a;
                if (str == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str);
                }
                z2 = false;
            } else {
                z2 = true;
            }
            if (m477b()) {
                if (!z2) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                }
                sb.append("target:");
                hu huVar = this.f665a;
                if (huVar == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(huVar);
                }
            } else {
                z3 = z2;
            }
            if (!z3) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            }
            sb.append("id:");
            String str2 = this.f672b;
            if (str2 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str2);
            }
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("appId:");
            String str3 = this.f675c;
            if (str3 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str3);
            }
            if (e()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("appVersion:");
                String str4 = this.f677d;
                if (str4 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str4);
                }
            }
            if (f()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("packageName:");
                String str5 = this.f678e;
                if (str5 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str5);
                }
            }
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("token:");
            String str6 = this.f679f;
            if (str6 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str6);
            }
            if (h()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("deviceId:");
                String str7 = this.f680g;
                if (str7 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str7);
                }
            }
            if (i()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("aliasName:");
                String str8 = this.f681h;
                if (str8 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str8);
                }
            }
            if (j()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("sdkVersion:");
                String str9 = this.f682i;
                if (str9 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str9);
                }
            }
            if (k()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("regId:");
                String str10 = this.f683j;
                if (str10 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str10);
                }
            }
            if (l()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("pushSdkVersionName:");
                String str11 = this.f684k;
                if (str11 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str11);
                }
            }
            if (m()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("pushSdkVersionCode:");
                sb.append(this.f662a);
            }
            if (n()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("appVersionCode:");
                sb.append(this.f670b);
            }
            if (o()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("androidId:");
                String str12 = this.f685l;
                if (str12 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str12);
                }
            }
            if (p()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("imei:");
                String str13 = this.f686m;
                if (str13 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str13);
                }
            }
            if (q()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("serial:");
                String str14 = this.f687n;
                if (str14 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str14);
                }
            }
            if (r()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("imeiMd5:");
                String str15 = this.f688o;
                if (str15 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str15);
                }
            }
            if (s()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("spaceId:");
                sb.append(this.f674c);
            }
            if (t()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("reason:");
                ht htVar = this.f664a;
                if (htVar == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(htVar);
                }
            }
            if (u()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("validateToken:");
                sb.append(this.f669a);
            }
            if (v()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("miid:");
                sb.append(this.f663a);
            }
            if (w()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("createdTs:");
                sb.append(this.f671b);
            }
            if (x()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("subImei:");
                String str16 = this.f689p;
                if (str16 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str16);
                }
            }
            if (y()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("subImeiMd5:");
                String str17 = this.f690q;
                if (str17 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str17);
                }
            }
            if (z()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("isHybridFrame:");
                sb.append(this.f673b);
            }
            if (A()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("connectionAttrs:");
                Map<String, String> map = this.f668a;
                if (map == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(map);
                }
            }
            if (B()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("cleanOldRegInfo:");
                sb.append(this.f676c);
            }
            if (C()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("oldRegId:");
                String str18 = this.f691r;
                if (str18 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str18);
                }
            }
            sb.append(SmallTailInfo.EMOTION_SUFFIX);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) ? this.f667a.get(3) : invokeV.booleanValue;
    }

    public boolean v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) ? this.f667a.get(4) : invokeV.booleanValue;
    }

    public boolean w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) ? this.f667a.get(5) : invokeV.booleanValue;
    }

    public boolean x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) ? this.f689p != null : invokeV.booleanValue;
    }

    public boolean y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) ? this.f690q != null : invokeV.booleanValue;
    }

    public boolean z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) ? this.f667a.get(6) : invokeV.booleanValue;
    }
}
