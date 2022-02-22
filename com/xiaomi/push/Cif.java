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
/* loaded from: classes4.dex */
public class Cif implements iq<Cif, Object>, Serializable, Cloneable {
    public static /* synthetic */ Interceptable $ic;
    public static final iy A;
    public static final iy B;
    public static final iy C;
    public static final iy a;

    /* renamed from: a  reason: collision with other field name */
    public static final jg f666a;

    /* renamed from: b  reason: collision with root package name */
    public static final iy f61515b;

    /* renamed from: c  reason: collision with root package name */
    public static final iy f61516c;

    /* renamed from: d  reason: collision with root package name */
    public static final iy f61517d;

    /* renamed from: e  reason: collision with root package name */
    public static final iy f61518e;

    /* renamed from: f  reason: collision with root package name */
    public static final iy f61519f;

    /* renamed from: g  reason: collision with root package name */
    public static final iy f61520g;

    /* renamed from: h  reason: collision with root package name */
    public static final iy f61521h;

    /* renamed from: i  reason: collision with root package name */
    public static final iy f61522i;

    /* renamed from: j  reason: collision with root package name */
    public static final iy f61523j;
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
    public int f667a;

    /* renamed from: a  reason: collision with other field name */
    public long f668a;

    /* renamed from: a  reason: collision with other field name */
    public ht f669a;

    /* renamed from: a  reason: collision with other field name */
    public hu f670a;

    /* renamed from: a  reason: collision with other field name */
    public String f671a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f672a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f673a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f674a;

    /* renamed from: b  reason: collision with other field name */
    public int f675b;

    /* renamed from: b  reason: collision with other field name */
    public long f676b;

    /* renamed from: b  reason: collision with other field name */
    public String f677b;

    /* renamed from: b  reason: collision with other field name */
    public boolean f678b;

    /* renamed from: c  reason: collision with other field name */
    public int f679c;

    /* renamed from: c  reason: collision with other field name */
    public String f680c;

    /* renamed from: c  reason: collision with other field name */
    public boolean f681c;

    /* renamed from: d  reason: collision with other field name */
    public String f682d;

    /* renamed from: e  reason: collision with other field name */
    public String f683e;

    /* renamed from: f  reason: collision with other field name */
    public String f684f;

    /* renamed from: g  reason: collision with other field name */
    public String f685g;

    /* renamed from: h  reason: collision with other field name */
    public String f686h;

    /* renamed from: i  reason: collision with other field name */
    public String f687i;

    /* renamed from: j  reason: collision with other field name */
    public String f688j;

    /* renamed from: k  reason: collision with other field name */
    public String f689k;

    /* renamed from: l  reason: collision with other field name */
    public String f690l;

    /* renamed from: m  reason: collision with other field name */
    public String f691m;

    /* renamed from: n  reason: collision with other field name */
    public String f692n;

    /* renamed from: o  reason: collision with other field name */
    public String f693o;

    /* renamed from: p  reason: collision with other field name */
    public String f694p;

    /* renamed from: q  reason: collision with other field name */
    public String f695q;

    /* renamed from: r  reason: collision with other field name */
    public String f696r;

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
        f666a = new jg("XmPushActionRegistration");
        a = new iy("", (byte) 11, (short) 1);
        f61515b = new iy("", StandardMessageCodec.LIST, (short) 2);
        f61516c = new iy("", (byte) 11, (short) 3);
        f61517d = new iy("", (byte) 11, (short) 4);
        f61518e = new iy("", (byte) 11, (short) 5);
        f61519f = new iy("", (byte) 11, (short) 6);
        f61520g = new iy("", (byte) 11, (short) 7);
        f61521h = new iy("", (byte) 11, (short) 8);
        f61522i = new iy("", (byte) 11, (short) 9);
        f61523j = new iy("", (byte) 11, (short) 10);
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
        this.f672a = new BitSet(8);
        this.f674a = true;
        this.f681c = false;
        this.f678b = false;
    }

    public boolean A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f673a != null : invokeV.booleanValue;
    }

    public boolean B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f672a.get(7) : invokeV.booleanValue;
    }

    public boolean C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f696r != null : invokeV.booleanValue;
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
                int compareTo = Boolean.valueOf(m538a()).compareTo(Boolean.valueOf(cif.m538a()));
                if (compareTo != 0) {
                    return compareTo;
                }
                if (!m538a() || (a30 = ir.a(this.f671a, cif.f671a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m540b()).compareTo(Boolean.valueOf(cif.m540b()));
                    if (compareTo2 != 0) {
                        return compareTo2;
                    }
                    if (!m540b() || (a29 = ir.a(this.f670a, cif.f670a)) == 0) {
                        int compareTo3 = Boolean.valueOf(m541c()).compareTo(Boolean.valueOf(cif.m541c()));
                        if (compareTo3 != 0) {
                            return compareTo3;
                        }
                        if (!m541c() || (a28 = ir.a(this.f677b, cif.f677b)) == 0) {
                            int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(cif.d()));
                            if (compareTo4 != 0) {
                                return compareTo4;
                            }
                            if (!d() || (a27 = ir.a(this.f680c, cif.f680c)) == 0) {
                                int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(cif.e()));
                                if (compareTo5 != 0) {
                                    return compareTo5;
                                }
                                if (!e() || (a26 = ir.a(this.f682d, cif.f682d)) == 0) {
                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(cif.f()));
                                    if (compareTo6 != 0) {
                                        return compareTo6;
                                    }
                                    if (!f() || (a25 = ir.a(this.f683e, cif.f683e)) == 0) {
                                        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(cif.g()));
                                        if (compareTo7 != 0) {
                                            return compareTo7;
                                        }
                                        if (!g() || (a24 = ir.a(this.f684f, cif.f684f)) == 0) {
                                            int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(cif.h()));
                                            if (compareTo8 != 0) {
                                                return compareTo8;
                                            }
                                            if (!h() || (a23 = ir.a(this.f685g, cif.f685g)) == 0) {
                                                int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(cif.i()));
                                                if (compareTo9 != 0) {
                                                    return compareTo9;
                                                }
                                                if (!i() || (a22 = ir.a(this.f686h, cif.f686h)) == 0) {
                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(cif.j()));
                                                    if (compareTo10 != 0) {
                                                        return compareTo10;
                                                    }
                                                    if (!j() || (a21 = ir.a(this.f687i, cif.f687i)) == 0) {
                                                        int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(cif.k()));
                                                        if (compareTo11 != 0) {
                                                            return compareTo11;
                                                        }
                                                        if (!k() || (a20 = ir.a(this.f688j, cif.f688j)) == 0) {
                                                            int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(cif.l()));
                                                            if (compareTo12 != 0) {
                                                                return compareTo12;
                                                            }
                                                            if (!l() || (a19 = ir.a(this.f689k, cif.f689k)) == 0) {
                                                                int compareTo13 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(cif.m()));
                                                                if (compareTo13 != 0) {
                                                                    return compareTo13;
                                                                }
                                                                if (!m() || (a18 = ir.a(this.f667a, cif.f667a)) == 0) {
                                                                    int compareTo14 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(cif.n()));
                                                                    if (compareTo14 != 0) {
                                                                        return compareTo14;
                                                                    }
                                                                    if (!n() || (a17 = ir.a(this.f675b, cif.f675b)) == 0) {
                                                                        int compareTo15 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(cif.o()));
                                                                        if (compareTo15 != 0) {
                                                                            return compareTo15;
                                                                        }
                                                                        if (!o() || (a16 = ir.a(this.f690l, cif.f690l)) == 0) {
                                                                            int compareTo16 = Boolean.valueOf(p()).compareTo(Boolean.valueOf(cif.p()));
                                                                            if (compareTo16 != 0) {
                                                                                return compareTo16;
                                                                            }
                                                                            if (!p() || (a15 = ir.a(this.f691m, cif.f691m)) == 0) {
                                                                                int compareTo17 = Boolean.valueOf(q()).compareTo(Boolean.valueOf(cif.q()));
                                                                                if (compareTo17 != 0) {
                                                                                    return compareTo17;
                                                                                }
                                                                                if (!q() || (a14 = ir.a(this.f692n, cif.f692n)) == 0) {
                                                                                    int compareTo18 = Boolean.valueOf(r()).compareTo(Boolean.valueOf(cif.r()));
                                                                                    if (compareTo18 != 0) {
                                                                                        return compareTo18;
                                                                                    }
                                                                                    if (!r() || (a13 = ir.a(this.f693o, cif.f693o)) == 0) {
                                                                                        int compareTo19 = Boolean.valueOf(s()).compareTo(Boolean.valueOf(cif.s()));
                                                                                        if (compareTo19 != 0) {
                                                                                            return compareTo19;
                                                                                        }
                                                                                        if (!s() || (a12 = ir.a(this.f679c, cif.f679c)) == 0) {
                                                                                            int compareTo20 = Boolean.valueOf(t()).compareTo(Boolean.valueOf(cif.t()));
                                                                                            if (compareTo20 != 0) {
                                                                                                return compareTo20;
                                                                                            }
                                                                                            if (!t() || (a11 = ir.a(this.f669a, cif.f669a)) == 0) {
                                                                                                int compareTo21 = Boolean.valueOf(u()).compareTo(Boolean.valueOf(cif.u()));
                                                                                                if (compareTo21 != 0) {
                                                                                                    return compareTo21;
                                                                                                }
                                                                                                if (!u() || (a10 = ir.a(this.f674a, cif.f674a)) == 0) {
                                                                                                    int compareTo22 = Boolean.valueOf(v()).compareTo(Boolean.valueOf(cif.v()));
                                                                                                    if (compareTo22 != 0) {
                                                                                                        return compareTo22;
                                                                                                    }
                                                                                                    if (!v() || (a9 = ir.a(this.f668a, cif.f668a)) == 0) {
                                                                                                        int compareTo23 = Boolean.valueOf(w()).compareTo(Boolean.valueOf(cif.w()));
                                                                                                        if (compareTo23 != 0) {
                                                                                                            return compareTo23;
                                                                                                        }
                                                                                                        if (!w() || (a8 = ir.a(this.f676b, cif.f676b)) == 0) {
                                                                                                            int compareTo24 = Boolean.valueOf(x()).compareTo(Boolean.valueOf(cif.x()));
                                                                                                            if (compareTo24 != 0) {
                                                                                                                return compareTo24;
                                                                                                            }
                                                                                                            if (!x() || (a7 = ir.a(this.f694p, cif.f694p)) == 0) {
                                                                                                                int compareTo25 = Boolean.valueOf(y()).compareTo(Boolean.valueOf(cif.y()));
                                                                                                                if (compareTo25 != 0) {
                                                                                                                    return compareTo25;
                                                                                                                }
                                                                                                                if (!y() || (a6 = ir.a(this.f695q, cif.f695q)) == 0) {
                                                                                                                    int compareTo26 = Boolean.valueOf(z()).compareTo(Boolean.valueOf(cif.z()));
                                                                                                                    if (compareTo26 != 0) {
                                                                                                                        return compareTo26;
                                                                                                                    }
                                                                                                                    if (!z() || (a5 = ir.a(this.f678b, cif.f678b)) == 0) {
                                                                                                                        int compareTo27 = Boolean.valueOf(A()).compareTo(Boolean.valueOf(cif.A()));
                                                                                                                        if (compareTo27 != 0) {
                                                                                                                            return compareTo27;
                                                                                                                        }
                                                                                                                        if (!A() || (a4 = ir.a(this.f673a, cif.f673a)) == 0) {
                                                                                                                            int compareTo28 = Boolean.valueOf(B()).compareTo(Boolean.valueOf(cif.B()));
                                                                                                                            if (compareTo28 != 0) {
                                                                                                                                return compareTo28;
                                                                                                                            }
                                                                                                                            if (!B() || (a3 = ir.a(this.f681c, cif.f681c)) == 0) {
                                                                                                                                int compareTo29 = Boolean.valueOf(C()).compareTo(Boolean.valueOf(cif.C()));
                                                                                                                                if (compareTo29 != 0) {
                                                                                                                                    return compareTo29;
                                                                                                                                }
                                                                                                                                if (!C() || (a2 = ir.a(this.f696r, cif.f696r)) == 0) {
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
            this.f667a = i2;
            a(true);
            return this;
        }
        return (Cif) invokeI.objValue;
    }

    public Cif a(ht htVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, htVar)) == null) {
            this.f669a = htVar;
            return this;
        }
        return (Cif) invokeL.objValue;
    }

    public Cif a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            this.f677b = str;
            return this;
        }
        return (Cif) invokeL.objValue;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f677b : (String) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m537a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (this.f677b == null) {
                throw new jc("Required field 'id' was not present! Struct: " + toString());
            } else if (this.f680c == null) {
                throw new jc("Required field 'appId' was not present! Struct: " + toString());
            } else if (this.f684f != null) {
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
        jbVar.m587a();
        while (true) {
            iy m583a = jbVar.m583a();
            byte b2 = m583a.a;
            if (b2 == 0) {
                jbVar.f();
                m537a();
                return;
            }
            short s2 = m583a.f815a;
            switch (s2) {
                case 1:
                    if (b2 == 11) {
                        this.f671a = jbVar.m588a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 2:
                    if (b2 == 12) {
                        hu huVar = new hu();
                        this.f670a = huVar;
                        huVar.a(jbVar);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f677b = jbVar.m588a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f680c = jbVar.m588a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 5:
                    if (b2 == 11) {
                        this.f682d = jbVar.m588a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 6:
                    if (b2 == 11) {
                        this.f683e = jbVar.m588a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f684f = jbVar.m588a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 8:
                    if (b2 == 11) {
                        this.f685g = jbVar.m588a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 9:
                    if (b2 == 11) {
                        this.f686h = jbVar.m588a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 10:
                    if (b2 == 11) {
                        this.f687i = jbVar.m588a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 11:
                    if (b2 == 11) {
                        this.f688j = jbVar.m588a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 12:
                    if (b2 == 11) {
                        this.f689k = jbVar.m588a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 13:
                    if (b2 == 8) {
                        this.f667a = jbVar.m581a();
                        a(true);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 14:
                    if (b2 == 8) {
                        this.f675b = jbVar.m581a();
                        b(true);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 15:
                    if (b2 == 11) {
                        this.f690l = jbVar.m588a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 16:
                    if (b2 == 11) {
                        this.f691m = jbVar.m588a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 17:
                    if (b2 == 11) {
                        this.f692n = jbVar.m588a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 18:
                    if (b2 == 11) {
                        this.f693o = jbVar.m588a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 19:
                    if (b2 == 8) {
                        this.f679c = jbVar.m581a();
                        c(true);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 20:
                    if (b2 == 8) {
                        this.f669a = ht.a(jbVar.m581a());
                        continue;
                        jbVar.g();
                    }
                    break;
                case 21:
                    if (b2 == 2) {
                        this.f674a = jbVar.m592a();
                        d(true);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 22:
                    if (b2 == 10) {
                        this.f668a = jbVar.m582a();
                        e(true);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 23:
                    if (b2 == 10) {
                        this.f676b = jbVar.m582a();
                        f(true);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 24:
                    if (b2 == 11) {
                        this.f694p = jbVar.m588a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 25:
                    if (b2 == 11) {
                        this.f695q = jbVar.m588a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 26:
                    if (b2 == 2) {
                        this.f678b = jbVar.m592a();
                        g(true);
                        continue;
                        jbVar.g();
                    }
                    break;
                default:
                    switch (s2) {
                        case 100:
                            if (b2 == 13) {
                                ja m585a = jbVar.m585a();
                                this.f673a = new HashMap(m585a.f819a * 2);
                                for (int i2 = 0; i2 < m585a.f819a; i2++) {
                                    this.f673a.put(jbVar.m588a(), jbVar.m588a());
                                }
                                jbVar.h();
                                break;
                            }
                            break;
                        case 101:
                            if (b2 == 2) {
                                this.f681c = jbVar.m592a();
                                h(true);
                                break;
                            }
                            break;
                        case 102:
                            if (b2 == 11) {
                                this.f696r = jbVar.m588a();
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
            this.f672a.set(0, z2);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m538a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f671a != null : invokeV.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m539a(Cif cif) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, cif)) == null) {
            if (cif == null) {
                return false;
            }
            boolean m538a = m538a();
            boolean m538a2 = cif.m538a();
            if ((m538a || m538a2) && !(m538a && m538a2 && this.f671a.equals(cif.f671a))) {
                return false;
            }
            boolean m540b = m540b();
            boolean m540b2 = cif.m540b();
            if ((m540b || m540b2) && !(m540b && m540b2 && this.f670a.m482a(cif.f670a))) {
                return false;
            }
            boolean m541c = m541c();
            boolean m541c2 = cif.m541c();
            if ((m541c || m541c2) && !(m541c && m541c2 && this.f677b.equals(cif.f677b))) {
                return false;
            }
            boolean d2 = d();
            boolean d3 = cif.d();
            if ((d2 || d3) && !(d2 && d3 && this.f680c.equals(cif.f680c))) {
                return false;
            }
            boolean e2 = e();
            boolean e3 = cif.e();
            if ((e2 || e3) && !(e2 && e3 && this.f682d.equals(cif.f682d))) {
                return false;
            }
            boolean f2 = f();
            boolean f3 = cif.f();
            if ((f2 || f3) && !(f2 && f3 && this.f683e.equals(cif.f683e))) {
                return false;
            }
            boolean g2 = g();
            boolean g3 = cif.g();
            if ((g2 || g3) && !(g2 && g3 && this.f684f.equals(cif.f684f))) {
                return false;
            }
            boolean h2 = h();
            boolean h3 = cif.h();
            if ((h2 || h3) && !(h2 && h3 && this.f685g.equals(cif.f685g))) {
                return false;
            }
            boolean i2 = i();
            boolean i3 = cif.i();
            if ((i2 || i3) && !(i2 && i3 && this.f686h.equals(cif.f686h))) {
                return false;
            }
            boolean j2 = j();
            boolean j3 = cif.j();
            if ((j2 || j3) && !(j2 && j3 && this.f687i.equals(cif.f687i))) {
                return false;
            }
            boolean k2 = k();
            boolean k3 = cif.k();
            if ((k2 || k3) && !(k2 && k3 && this.f688j.equals(cif.f688j))) {
                return false;
            }
            boolean l2 = l();
            boolean l3 = cif.l();
            if ((l2 || l3) && !(l2 && l3 && this.f689k.equals(cif.f689k))) {
                return false;
            }
            boolean m2 = m();
            boolean m3 = cif.m();
            if ((m2 || m3) && !(m2 && m3 && this.f667a == cif.f667a)) {
                return false;
            }
            boolean n2 = n();
            boolean n3 = cif.n();
            if ((n2 || n3) && !(n2 && n3 && this.f675b == cif.f675b)) {
                return false;
            }
            boolean o2 = o();
            boolean o3 = cif.o();
            if ((o2 || o3) && !(o2 && o3 && this.f690l.equals(cif.f690l))) {
                return false;
            }
            boolean p2 = p();
            boolean p3 = cif.p();
            if ((p2 || p3) && !(p2 && p3 && this.f691m.equals(cif.f691m))) {
                return false;
            }
            boolean q2 = q();
            boolean q3 = cif.q();
            if ((q2 || q3) && !(q2 && q3 && this.f692n.equals(cif.f692n))) {
                return false;
            }
            boolean r2 = r();
            boolean r3 = cif.r();
            if ((r2 || r3) && !(r2 && r3 && this.f693o.equals(cif.f693o))) {
                return false;
            }
            boolean s2 = s();
            boolean s3 = cif.s();
            if ((s2 || s3) && !(s2 && s3 && this.f679c == cif.f679c)) {
                return false;
            }
            boolean t2 = t();
            boolean t3 = cif.t();
            if ((t2 || t3) && !(t2 && t3 && this.f669a.equals(cif.f669a))) {
                return false;
            }
            boolean u2 = u();
            boolean u3 = cif.u();
            if ((u2 || u3) && !(u2 && u3 && this.f674a == cif.f674a)) {
                return false;
            }
            boolean v2 = v();
            boolean v3 = cif.v();
            if ((v2 || v3) && !(v2 && v3 && this.f668a == cif.f668a)) {
                return false;
            }
            boolean w2 = w();
            boolean w3 = cif.w();
            if ((w2 || w3) && !(w2 && w3 && this.f676b == cif.f676b)) {
                return false;
            }
            boolean x2 = x();
            boolean x3 = cif.x();
            if ((x2 || x3) && !(x2 && x3 && this.f694p.equals(cif.f694p))) {
                return false;
            }
            boolean y2 = y();
            boolean y3 = cif.y();
            if ((y2 || y3) && !(y2 && y3 && this.f695q.equals(cif.f695q))) {
                return false;
            }
            boolean z2 = z();
            boolean z3 = cif.z();
            if ((z2 || z3) && !(z2 && z3 && this.f678b == cif.f678b)) {
                return false;
            }
            boolean A2 = A();
            boolean A3 = cif.A();
            if ((A2 || A3) && !(A2 && A3 && this.f673a.equals(cif.f673a))) {
                return false;
            }
            boolean B2 = B();
            boolean B3 = cif.B();
            if ((B2 || B3) && !(B2 && B3 && this.f681c == cif.f681c)) {
                return false;
            }
            boolean C2 = C();
            boolean C3 = cif.C();
            if (C2 || C3) {
                return C2 && C3 && this.f696r.equals(cif.f696r);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public Cif b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i2)) == null) {
            this.f675b = i2;
            b(true);
            return this;
        }
        return (Cif) invokeI.objValue;
    }

    public Cif b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
            this.f680c = str;
            return this;
        }
        return (Cif) invokeL.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f680c : (String) invokeV.objValue;
    }

    @Override // com.xiaomi.push.iq
    public void b(jb jbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, jbVar) == null) {
            m537a();
            jbVar.a(f666a);
            if (this.f671a != null && m538a()) {
                jbVar.a(a);
                jbVar.a(this.f671a);
                jbVar.b();
            }
            if (this.f670a != null && m540b()) {
                jbVar.a(f61515b);
                this.f670a.b(jbVar);
                jbVar.b();
            }
            if (this.f677b != null) {
                jbVar.a(f61516c);
                jbVar.a(this.f677b);
                jbVar.b();
            }
            if (this.f680c != null) {
                jbVar.a(f61517d);
                jbVar.a(this.f680c);
                jbVar.b();
            }
            if (this.f682d != null && e()) {
                jbVar.a(f61518e);
                jbVar.a(this.f682d);
                jbVar.b();
            }
            if (this.f683e != null && f()) {
                jbVar.a(f61519f);
                jbVar.a(this.f683e);
                jbVar.b();
            }
            if (this.f684f != null) {
                jbVar.a(f61520g);
                jbVar.a(this.f684f);
                jbVar.b();
            }
            if (this.f685g != null && h()) {
                jbVar.a(f61521h);
                jbVar.a(this.f685g);
                jbVar.b();
            }
            if (this.f686h != null && i()) {
                jbVar.a(f61522i);
                jbVar.a(this.f686h);
                jbVar.b();
            }
            if (this.f687i != null && j()) {
                jbVar.a(f61523j);
                jbVar.a(this.f687i);
                jbVar.b();
            }
            if (this.f688j != null && k()) {
                jbVar.a(k);
                jbVar.a(this.f688j);
                jbVar.b();
            }
            if (this.f689k != null && l()) {
                jbVar.a(l);
                jbVar.a(this.f689k);
                jbVar.b();
            }
            if (m()) {
                jbVar.a(m);
                jbVar.a(this.f667a);
                jbVar.b();
            }
            if (n()) {
                jbVar.a(n);
                jbVar.a(this.f675b);
                jbVar.b();
            }
            if (this.f690l != null && o()) {
                jbVar.a(o);
                jbVar.a(this.f690l);
                jbVar.b();
            }
            if (this.f691m != null && p()) {
                jbVar.a(p);
                jbVar.a(this.f691m);
                jbVar.b();
            }
            if (this.f692n != null && q()) {
                jbVar.a(q);
                jbVar.a(this.f692n);
                jbVar.b();
            }
            if (this.f693o != null && r()) {
                jbVar.a(r);
                jbVar.a(this.f693o);
                jbVar.b();
            }
            if (s()) {
                jbVar.a(s);
                jbVar.a(this.f679c);
                jbVar.b();
            }
            if (this.f669a != null && t()) {
                jbVar.a(t);
                jbVar.a(this.f669a.a());
                jbVar.b();
            }
            if (u()) {
                jbVar.a(u);
                jbVar.a(this.f674a);
                jbVar.b();
            }
            if (v()) {
                jbVar.a(v);
                jbVar.a(this.f668a);
                jbVar.b();
            }
            if (w()) {
                jbVar.a(w);
                jbVar.a(this.f676b);
                jbVar.b();
            }
            if (this.f694p != null && x()) {
                jbVar.a(x);
                jbVar.a(this.f694p);
                jbVar.b();
            }
            if (this.f695q != null && y()) {
                jbVar.a(y);
                jbVar.a(this.f695q);
                jbVar.b();
            }
            if (z()) {
                jbVar.a(z);
                jbVar.a(this.f678b);
                jbVar.b();
            }
            if (this.f673a != null && A()) {
                jbVar.a(A);
                jbVar.a(new ja((byte) 11, (byte) 11, this.f673a.size()));
                for (Map.Entry<String, String> entry : this.f673a.entrySet()) {
                    jbVar.a(entry.getKey());
                    jbVar.a(entry.getValue());
                }
                jbVar.d();
                jbVar.b();
            }
            if (B()) {
                jbVar.a(B);
                jbVar.a(this.f681c);
                jbVar.b();
            }
            if (this.f696r != null && C()) {
                jbVar.a(C);
                jbVar.a(this.f696r);
                jbVar.b();
            }
            jbVar.c();
            jbVar.m591a();
        }
    }

    public void b(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z2) == null) {
            this.f672a.set(1, z2);
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m540b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f670a != null : invokeV.booleanValue;
    }

    public Cif c(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048595, this, i2)) == null) {
            this.f679c = i2;
            c(true);
            return this;
        }
        return (Cif) invokeI.objValue;
    }

    public Cif c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, str)) == null) {
            this.f682d = str;
            return this;
        }
        return (Cif) invokeL.objValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.f684f : (String) invokeV.objValue;
    }

    public void c(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z2) == null) {
            this.f672a.set(2, z2);
        }
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m541c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.f677b != null : invokeV.booleanValue;
    }

    public Cif d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, str)) == null) {
            this.f683e = str;
            return this;
        }
        return (Cif) invokeL.objValue;
    }

    public void d(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z2) == null) {
            this.f672a.set(3, z2);
        }
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.f680c != null : invokeV.booleanValue;
    }

    public Cif e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, str)) == null) {
            this.f684f = str;
            return this;
        }
        return (Cif) invokeL.objValue;
    }

    public void e(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048605, this, z2) == null) {
            this.f672a.set(4, z2);
        }
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.f682d != null : invokeV.booleanValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, obj)) == null) {
            if (obj != null && (obj instanceof Cif)) {
                return m539a((Cif) obj);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public Cif f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048608, this, str)) == null) {
            this.f685g = str;
            return this;
        }
        return (Cif) invokeL.objValue;
    }

    public void f(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048609, this, z2) == null) {
            this.f672a.set(5, z2);
        }
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.f683e != null : invokeV.booleanValue;
    }

    public Cif g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048611, this, str)) == null) {
            this.f686h = str;
            return this;
        }
        return (Cif) invokeL.objValue;
    }

    public void g(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048612, this, z2) == null) {
            this.f672a.set(6, z2);
        }
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? this.f684f != null : invokeV.booleanValue;
    }

    public Cif h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048614, this, str)) == null) {
            this.f689k = str;
            return this;
        }
        return (Cif) invokeL.objValue;
    }

    public void h(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048615, this, z2) == null) {
            this.f672a.set(7, z2);
        }
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? this.f685g != null : invokeV.booleanValue;
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
            this.f693o = str;
            return this;
        }
        return (Cif) invokeL.objValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) ? this.f686h != null : invokeV.booleanValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) ? this.f687i != null : invokeV.booleanValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) ? this.f688j != null : invokeV.booleanValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) ? this.f689k != null : invokeV.booleanValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) ? this.f672a.get(0) : invokeV.booleanValue;
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) ? this.f672a.get(1) : invokeV.booleanValue;
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) ? this.f690l != null : invokeV.booleanValue;
    }

    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) ? this.f691m != null : invokeV.booleanValue;
    }

    public boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) ? this.f692n != null : invokeV.booleanValue;
    }

    public boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) ? this.f693o != null : invokeV.booleanValue;
    }

    public boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) ? this.f672a.get(2) : invokeV.booleanValue;
    }

    public boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) ? this.f669a != null : invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) {
            StringBuilder sb = new StringBuilder("XmPushActionRegistration(");
            boolean z3 = false;
            if (m538a()) {
                sb.append("debug:");
                String str = this.f671a;
                if (str == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str);
                }
                z2 = false;
            } else {
                z2 = true;
            }
            if (m540b()) {
                if (!z2) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                }
                sb.append("target:");
                hu huVar = this.f670a;
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
            String str2 = this.f677b;
            if (str2 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str2);
            }
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("appId:");
            String str3 = this.f680c;
            if (str3 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str3);
            }
            if (e()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("appVersion:");
                String str4 = this.f682d;
                if (str4 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str4);
                }
            }
            if (f()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("packageName:");
                String str5 = this.f683e;
                if (str5 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str5);
                }
            }
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("token:");
            String str6 = this.f684f;
            if (str6 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str6);
            }
            if (h()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("deviceId:");
                String str7 = this.f685g;
                if (str7 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str7);
                }
            }
            if (i()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("aliasName:");
                String str8 = this.f686h;
                if (str8 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str8);
                }
            }
            if (j()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("sdkVersion:");
                String str9 = this.f687i;
                if (str9 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str9);
                }
            }
            if (k()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("regId:");
                String str10 = this.f688j;
                if (str10 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str10);
                }
            }
            if (l()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("pushSdkVersionName:");
                String str11 = this.f689k;
                if (str11 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str11);
                }
            }
            if (m()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("pushSdkVersionCode:");
                sb.append(this.f667a);
            }
            if (n()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("appVersionCode:");
                sb.append(this.f675b);
            }
            if (o()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("androidId:");
                String str12 = this.f690l;
                if (str12 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str12);
                }
            }
            if (p()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("imei:");
                String str13 = this.f691m;
                if (str13 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str13);
                }
            }
            if (q()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("serial:");
                String str14 = this.f692n;
                if (str14 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str14);
                }
            }
            if (r()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("imeiMd5:");
                String str15 = this.f693o;
                if (str15 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str15);
                }
            }
            if (s()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("spaceId:");
                sb.append(this.f679c);
            }
            if (t()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("reason:");
                ht htVar = this.f669a;
                if (htVar == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(htVar);
                }
            }
            if (u()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("validateToken:");
                sb.append(this.f674a);
            }
            if (v()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("miid:");
                sb.append(this.f668a);
            }
            if (w()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("createdTs:");
                sb.append(this.f676b);
            }
            if (x()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("subImei:");
                String str16 = this.f694p;
                if (str16 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str16);
                }
            }
            if (y()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("subImeiMd5:");
                String str17 = this.f695q;
                if (str17 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str17);
                }
            }
            if (z()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("isHybridFrame:");
                sb.append(this.f678b);
            }
            if (A()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("connectionAttrs:");
                Map<String, String> map = this.f673a;
                if (map == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(map);
                }
            }
            if (B()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("cleanOldRegInfo:");
                sb.append(this.f681c);
            }
            if (C()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("oldRegId:");
                String str18 = this.f696r;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) ? this.f672a.get(3) : invokeV.booleanValue;
    }

    public boolean v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) ? this.f672a.get(4) : invokeV.booleanValue;
    }

    public boolean w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) ? this.f672a.get(5) : invokeV.booleanValue;
    }

    public boolean x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) ? this.f694p != null : invokeV.booleanValue;
    }

    public boolean y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) ? this.f695q != null : invokeV.booleanValue;
    }

    public boolean z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) ? this.f672a.get(6) : invokeV.booleanValue;
    }
}
