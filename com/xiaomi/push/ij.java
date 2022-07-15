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
import com.bumptech.glide.disklrucache.StrictLineReader;
import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes8.dex */
public class ij implements iu<ij, Object>, Serializable, Cloneable {
    public static /* synthetic */ Interceptable $ic;
    public static final jc A;
    public static final jc B;
    public static final jc C;
    public static final jc a;

    /* renamed from: a  reason: collision with other field name */
    public static final jk f1375a;
    public static final jc b;
    public static final jc c;
    public static final jc d;
    public static final jc e;
    public static final jc f;
    public static final jc g;
    public static final jc h;
    public static final jc i;
    public static final jc j;
    public static final jc k;
    public static final jc l;
    public static final jc m;
    public static final jc n;
    public static final jc o;
    public static final jc p;
    public static final jc q;
    public static final jc r;
    public static final jc s;
    public static final jc t;
    public static final jc u;
    public static final jc v;
    public static final jc w;
    public static final jc x;
    public static final jc y;
    public static final jc z;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public int f1376a;

    /* renamed from: a  reason: collision with other field name */
    public long f1377a;

    /* renamed from: a  reason: collision with other field name */
    public hx f1378a;

    /* renamed from: a  reason: collision with other field name */
    public hy f1379a;

    /* renamed from: a  reason: collision with other field name */
    public String f1380a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f1381a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f1382a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f1383a;

    /* renamed from: b  reason: collision with other field name */
    public int f1384b;

    /* renamed from: b  reason: collision with other field name */
    public long f1385b;

    /* renamed from: b  reason: collision with other field name */
    public String f1386b;

    /* renamed from: b  reason: collision with other field name */
    public boolean f1387b;

    /* renamed from: c  reason: collision with other field name */
    public int f1388c;

    /* renamed from: c  reason: collision with other field name */
    public String f1389c;

    /* renamed from: c  reason: collision with other field name */
    public boolean f1390c;

    /* renamed from: d  reason: collision with other field name */
    public String f1391d;

    /* renamed from: e  reason: collision with other field name */
    public String f1392e;

    /* renamed from: f  reason: collision with other field name */
    public String f1393f;

    /* renamed from: g  reason: collision with other field name */
    public String f1394g;

    /* renamed from: h  reason: collision with other field name */
    public String f1395h;

    /* renamed from: i  reason: collision with other field name */
    public String f1396i;

    /* renamed from: j  reason: collision with other field name */
    public String f1397j;

    /* renamed from: k  reason: collision with other field name */
    public String f1398k;

    /* renamed from: l  reason: collision with other field name */
    public String f1399l;

    /* renamed from: m  reason: collision with other field name */
    public String f1400m;

    /* renamed from: n  reason: collision with other field name */
    public String f1401n;

    /* renamed from: o  reason: collision with other field name */
    public String f1402o;

    /* renamed from: p  reason: collision with other field name */
    public String f1403p;

    /* renamed from: q  reason: collision with other field name */
    public String f1404q;

    /* renamed from: r  reason: collision with other field name */
    public String f1405r;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-56371905, "Lcom/xiaomi/push/ij;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-56371905, "Lcom/xiaomi/push/ij;");
                return;
            }
        }
        f1375a = new jk("XmPushActionRegistration");
        a = new jc("", Constants.GZIP_CAST_TYPE, (short) 1);
        b = new jc("", (byte) 12, (short) 2);
        c = new jc("", Constants.GZIP_CAST_TYPE, (short) 3);
        d = new jc("", Constants.GZIP_CAST_TYPE, (short) 4);
        e = new jc("", Constants.GZIP_CAST_TYPE, (short) 5);
        f = new jc("", Constants.GZIP_CAST_TYPE, (short) 6);
        g = new jc("", Constants.GZIP_CAST_TYPE, (short) 7);
        h = new jc("", Constants.GZIP_CAST_TYPE, (short) 8);
        i = new jc("", Constants.GZIP_CAST_TYPE, (short) 9);
        j = new jc("", Constants.GZIP_CAST_TYPE, (short) 10);
        k = new jc("", Constants.GZIP_CAST_TYPE, (short) 11);
        l = new jc("", Constants.GZIP_CAST_TYPE, (short) 12);
        m = new jc("", (byte) 8, (short) 13);
        n = new jc("", (byte) 8, (short) 14);
        o = new jc("", Constants.GZIP_CAST_TYPE, (short) 15);
        p = new jc("", Constants.GZIP_CAST_TYPE, (short) 16);
        q = new jc("", Constants.GZIP_CAST_TYPE, (short) 17);
        r = new jc("", Constants.GZIP_CAST_TYPE, (short) 18);
        s = new jc("", (byte) 8, (short) 19);
        t = new jc("", (byte) 8, (short) 20);
        u = new jc("", (byte) 2, (short) 21);
        v = new jc("", (byte) 10, (short) 22);
        w = new jc("", (byte) 10, (short) 23);
        x = new jc("", Constants.GZIP_CAST_TYPE, (short) 24);
        y = new jc("", Constants.GZIP_CAST_TYPE, (short) 25);
        z = new jc("", (byte) 2, (short) 26);
        A = new jc("", StrictLineReader.CR, (short) 100);
        B = new jc("", (byte) 2, (short) 101);
        C = new jc("", Constants.GZIP_CAST_TYPE, (short) 102);
    }

    public ij() {
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
        this.f1381a = new BitSet(8);
        this.f1383a = true;
        this.f1390c = false;
        this.f1387b = false;
    }

    public boolean A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f1382a != null : invokeV.booleanValue;
    }

    public boolean B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f1381a.get(7) : invokeV.booleanValue;
    }

    public boolean C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f1405r != null : invokeV.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(ij ijVar) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, ijVar)) == null) {
            if (ij.class.equals(ijVar.getClass())) {
                int compareTo = Boolean.valueOf(m1428a()).compareTo(Boolean.valueOf(ijVar.m1428a()));
                if (compareTo != 0) {
                    return compareTo;
                }
                if (!m1428a() || (a30 = iv.a(this.f1380a, ijVar.f1380a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m1430b()).compareTo(Boolean.valueOf(ijVar.m1430b()));
                    if (compareTo2 != 0) {
                        return compareTo2;
                    }
                    if (!m1430b() || (a29 = iv.a(this.f1379a, ijVar.f1379a)) == 0) {
                        int compareTo3 = Boolean.valueOf(m1431c()).compareTo(Boolean.valueOf(ijVar.m1431c()));
                        if (compareTo3 != 0) {
                            return compareTo3;
                        }
                        if (!m1431c() || (a28 = iv.a(this.f1386b, ijVar.f1386b)) == 0) {
                            int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(ijVar.d()));
                            if (compareTo4 != 0) {
                                return compareTo4;
                            }
                            if (!d() || (a27 = iv.a(this.f1389c, ijVar.f1389c)) == 0) {
                                int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(ijVar.e()));
                                if (compareTo5 != 0) {
                                    return compareTo5;
                                }
                                if (!e() || (a26 = iv.a(this.f1391d, ijVar.f1391d)) == 0) {
                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(ijVar.f()));
                                    if (compareTo6 != 0) {
                                        return compareTo6;
                                    }
                                    if (!f() || (a25 = iv.a(this.f1392e, ijVar.f1392e)) == 0) {
                                        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ijVar.g()));
                                        if (compareTo7 != 0) {
                                            return compareTo7;
                                        }
                                        if (!g() || (a24 = iv.a(this.f1393f, ijVar.f1393f)) == 0) {
                                            int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(ijVar.h()));
                                            if (compareTo8 != 0) {
                                                return compareTo8;
                                            }
                                            if (!h() || (a23 = iv.a(this.f1394g, ijVar.f1394g)) == 0) {
                                                int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(ijVar.i()));
                                                if (compareTo9 != 0) {
                                                    return compareTo9;
                                                }
                                                if (!i() || (a22 = iv.a(this.f1395h, ijVar.f1395h)) == 0) {
                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(ijVar.j()));
                                                    if (compareTo10 != 0) {
                                                        return compareTo10;
                                                    }
                                                    if (!j() || (a21 = iv.a(this.f1396i, ijVar.f1396i)) == 0) {
                                                        int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(ijVar.k()));
                                                        if (compareTo11 != 0) {
                                                            return compareTo11;
                                                        }
                                                        if (!k() || (a20 = iv.a(this.f1397j, ijVar.f1397j)) == 0) {
                                                            int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(ijVar.l()));
                                                            if (compareTo12 != 0) {
                                                                return compareTo12;
                                                            }
                                                            if (!l() || (a19 = iv.a(this.f1398k, ijVar.f1398k)) == 0) {
                                                                int compareTo13 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(ijVar.m()));
                                                                if (compareTo13 != 0) {
                                                                    return compareTo13;
                                                                }
                                                                if (!m() || (a18 = iv.a(this.f1376a, ijVar.f1376a)) == 0) {
                                                                    int compareTo14 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(ijVar.n()));
                                                                    if (compareTo14 != 0) {
                                                                        return compareTo14;
                                                                    }
                                                                    if (!n() || (a17 = iv.a(this.f1384b, ijVar.f1384b)) == 0) {
                                                                        int compareTo15 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(ijVar.o()));
                                                                        if (compareTo15 != 0) {
                                                                            return compareTo15;
                                                                        }
                                                                        if (!o() || (a16 = iv.a(this.f1399l, ijVar.f1399l)) == 0) {
                                                                            int compareTo16 = Boolean.valueOf(p()).compareTo(Boolean.valueOf(ijVar.p()));
                                                                            if (compareTo16 != 0) {
                                                                                return compareTo16;
                                                                            }
                                                                            if (!p() || (a15 = iv.a(this.f1400m, ijVar.f1400m)) == 0) {
                                                                                int compareTo17 = Boolean.valueOf(q()).compareTo(Boolean.valueOf(ijVar.q()));
                                                                                if (compareTo17 != 0) {
                                                                                    return compareTo17;
                                                                                }
                                                                                if (!q() || (a14 = iv.a(this.f1401n, ijVar.f1401n)) == 0) {
                                                                                    int compareTo18 = Boolean.valueOf(r()).compareTo(Boolean.valueOf(ijVar.r()));
                                                                                    if (compareTo18 != 0) {
                                                                                        return compareTo18;
                                                                                    }
                                                                                    if (!r() || (a13 = iv.a(this.f1402o, ijVar.f1402o)) == 0) {
                                                                                        int compareTo19 = Boolean.valueOf(s()).compareTo(Boolean.valueOf(ijVar.s()));
                                                                                        if (compareTo19 != 0) {
                                                                                            return compareTo19;
                                                                                        }
                                                                                        if (!s() || (a12 = iv.a(this.f1388c, ijVar.f1388c)) == 0) {
                                                                                            int compareTo20 = Boolean.valueOf(t()).compareTo(Boolean.valueOf(ijVar.t()));
                                                                                            if (compareTo20 != 0) {
                                                                                                return compareTo20;
                                                                                            }
                                                                                            if (!t() || (a11 = iv.a(this.f1378a, ijVar.f1378a)) == 0) {
                                                                                                int compareTo21 = Boolean.valueOf(u()).compareTo(Boolean.valueOf(ijVar.u()));
                                                                                                if (compareTo21 != 0) {
                                                                                                    return compareTo21;
                                                                                                }
                                                                                                if (!u() || (a10 = iv.a(this.f1383a, ijVar.f1383a)) == 0) {
                                                                                                    int compareTo22 = Boolean.valueOf(v()).compareTo(Boolean.valueOf(ijVar.v()));
                                                                                                    if (compareTo22 != 0) {
                                                                                                        return compareTo22;
                                                                                                    }
                                                                                                    if (!v() || (a9 = iv.a(this.f1377a, ijVar.f1377a)) == 0) {
                                                                                                        int compareTo23 = Boolean.valueOf(w()).compareTo(Boolean.valueOf(ijVar.w()));
                                                                                                        if (compareTo23 != 0) {
                                                                                                            return compareTo23;
                                                                                                        }
                                                                                                        if (!w() || (a8 = iv.a(this.f1385b, ijVar.f1385b)) == 0) {
                                                                                                            int compareTo24 = Boolean.valueOf(x()).compareTo(Boolean.valueOf(ijVar.x()));
                                                                                                            if (compareTo24 != 0) {
                                                                                                                return compareTo24;
                                                                                                            }
                                                                                                            if (!x() || (a7 = iv.a(this.f1403p, ijVar.f1403p)) == 0) {
                                                                                                                int compareTo25 = Boolean.valueOf(y()).compareTo(Boolean.valueOf(ijVar.y()));
                                                                                                                if (compareTo25 != 0) {
                                                                                                                    return compareTo25;
                                                                                                                }
                                                                                                                if (!y() || (a6 = iv.a(this.f1404q, ijVar.f1404q)) == 0) {
                                                                                                                    int compareTo26 = Boolean.valueOf(z()).compareTo(Boolean.valueOf(ijVar.z()));
                                                                                                                    if (compareTo26 != 0) {
                                                                                                                        return compareTo26;
                                                                                                                    }
                                                                                                                    if (!z() || (a5 = iv.a(this.f1387b, ijVar.f1387b)) == 0) {
                                                                                                                        int compareTo27 = Boolean.valueOf(A()).compareTo(Boolean.valueOf(ijVar.A()));
                                                                                                                        if (compareTo27 != 0) {
                                                                                                                            return compareTo27;
                                                                                                                        }
                                                                                                                        if (!A() || (a4 = iv.a(this.f1382a, ijVar.f1382a)) == 0) {
                                                                                                                            int compareTo28 = Boolean.valueOf(B()).compareTo(Boolean.valueOf(ijVar.B()));
                                                                                                                            if (compareTo28 != 0) {
                                                                                                                                return compareTo28;
                                                                                                                            }
                                                                                                                            if (!B() || (a3 = iv.a(this.f1390c, ijVar.f1390c)) == 0) {
                                                                                                                                int compareTo29 = Boolean.valueOf(C()).compareTo(Boolean.valueOf(ijVar.C()));
                                                                                                                                if (compareTo29 != 0) {
                                                                                                                                    return compareTo29;
                                                                                                                                }
                                                                                                                                if (!C() || (a2 = iv.a(this.f1405r, ijVar.f1405r)) == 0) {
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
            return ij.class.getName().compareTo(ijVar.getClass().getName());
        }
        return invokeL.intValue;
    }

    public ij a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            this.f1376a = i2;
            a(true);
            return this;
        }
        return (ij) invokeI.objValue;
    }

    public ij a(hx hxVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, hxVar)) == null) {
            this.f1378a = hxVar;
            return this;
        }
        return (ij) invokeL.objValue;
    }

    public ij a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            this.f1386b = str;
            return this;
        }
        return (ij) invokeL.objValue;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f1386b : (String) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m1427a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (this.f1386b == null) {
                throw new jg("Required field 'id' was not present! Struct: " + toString());
            } else if (this.f1389c == null) {
                throw new jg("Required field 'appId' was not present! Struct: " + toString());
            } else if (this.f1393f != null) {
            } else {
                throw new jg("Required field 'token' was not present! Struct: " + toString());
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.xiaomi.push.iu
    public void a(jf jfVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(1048585, this, jfVar) != null) {
            return;
        }
        jfVar.m1487a();
        while (true) {
            jc m1483a = jfVar.m1483a();
            byte b2 = m1483a.a;
            if (b2 == 0) {
                jfVar.f();
                m1427a();
                return;
            }
            short s2 = m1483a.f1529a;
            switch (s2) {
                case 1:
                    if (b2 == 11) {
                        this.f1380a = jfVar.m1488a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 2:
                    if (b2 == 12) {
                        hy hyVar = new hy();
                        this.f1379a = hyVar;
                        hyVar.a(jfVar);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f1386b = jfVar.m1488a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f1389c = jfVar.m1488a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 5:
                    if (b2 == 11) {
                        this.f1391d = jfVar.m1488a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 6:
                    if (b2 == 11) {
                        this.f1392e = jfVar.m1488a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f1393f = jfVar.m1488a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 8:
                    if (b2 == 11) {
                        this.f1394g = jfVar.m1488a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 9:
                    if (b2 == 11) {
                        this.f1395h = jfVar.m1488a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 10:
                    if (b2 == 11) {
                        this.f1396i = jfVar.m1488a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 11:
                    if (b2 == 11) {
                        this.f1397j = jfVar.m1488a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 12:
                    if (b2 == 11) {
                        this.f1398k = jfVar.m1488a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 13:
                    if (b2 == 8) {
                        this.f1376a = jfVar.m1481a();
                        a(true);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 14:
                    if (b2 == 8) {
                        this.f1384b = jfVar.m1481a();
                        b(true);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 15:
                    if (b2 == 11) {
                        this.f1399l = jfVar.m1488a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 16:
                    if (b2 == 11) {
                        this.f1400m = jfVar.m1488a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 17:
                    if (b2 == 11) {
                        this.f1401n = jfVar.m1488a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 18:
                    if (b2 == 11) {
                        this.f1402o = jfVar.m1488a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 19:
                    if (b2 == 8) {
                        this.f1388c = jfVar.m1481a();
                        c(true);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 20:
                    if (b2 == 8) {
                        this.f1378a = hx.a(jfVar.m1481a());
                        continue;
                        jfVar.g();
                    }
                    break;
                case 21:
                    if (b2 == 2) {
                        this.f1383a = jfVar.m1492a();
                        d(true);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 22:
                    if (b2 == 10) {
                        this.f1377a = jfVar.m1482a();
                        e(true);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 23:
                    if (b2 == 10) {
                        this.f1385b = jfVar.m1482a();
                        f(true);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 24:
                    if (b2 == 11) {
                        this.f1403p = jfVar.m1488a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 25:
                    if (b2 == 11) {
                        this.f1404q = jfVar.m1488a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 26:
                    if (b2 == 2) {
                        this.f1387b = jfVar.m1492a();
                        g(true);
                        continue;
                        jfVar.g();
                    }
                    break;
                default:
                    switch (s2) {
                        case 100:
                            if (b2 == 13) {
                                je m1485a = jfVar.m1485a();
                                this.f1382a = new HashMap(m1485a.f1531a * 2);
                                for (int i2 = 0; i2 < m1485a.f1531a; i2++) {
                                    this.f1382a.put(jfVar.m1488a(), jfVar.m1488a());
                                }
                                jfVar.h();
                                break;
                            }
                            break;
                        case 101:
                            if (b2 == 2) {
                                this.f1390c = jfVar.m1492a();
                                h(true);
                                break;
                            }
                            break;
                        case 102:
                            if (b2 == 11) {
                                this.f1405r = jfVar.m1488a();
                                continue;
                            }
                            break;
                    }
                    jfVar.g();
                    break;
            }
            ji.a(jfVar, b2);
            jfVar.g();
        }
    }

    public void a(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z2) == null) {
            this.f1381a.set(0, z2);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m1428a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f1380a != null : invokeV.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m1429a(ij ijVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, ijVar)) == null) {
            if (ijVar == null) {
                return false;
            }
            boolean m1428a = m1428a();
            boolean m1428a2 = ijVar.m1428a();
            if ((m1428a || m1428a2) && !(m1428a && m1428a2 && this.f1380a.equals(ijVar.f1380a))) {
                return false;
            }
            boolean m1430b = m1430b();
            boolean m1430b2 = ijVar.m1430b();
            if ((m1430b || m1430b2) && !(m1430b && m1430b2 && this.f1379a.m1381a(ijVar.f1379a))) {
                return false;
            }
            boolean m1431c = m1431c();
            boolean m1431c2 = ijVar.m1431c();
            if ((m1431c || m1431c2) && !(m1431c && m1431c2 && this.f1386b.equals(ijVar.f1386b))) {
                return false;
            }
            boolean d2 = d();
            boolean d3 = ijVar.d();
            if ((d2 || d3) && !(d2 && d3 && this.f1389c.equals(ijVar.f1389c))) {
                return false;
            }
            boolean e2 = e();
            boolean e3 = ijVar.e();
            if ((e2 || e3) && !(e2 && e3 && this.f1391d.equals(ijVar.f1391d))) {
                return false;
            }
            boolean f2 = f();
            boolean f3 = ijVar.f();
            if ((f2 || f3) && !(f2 && f3 && this.f1392e.equals(ijVar.f1392e))) {
                return false;
            }
            boolean g2 = g();
            boolean g3 = ijVar.g();
            if ((g2 || g3) && !(g2 && g3 && this.f1393f.equals(ijVar.f1393f))) {
                return false;
            }
            boolean h2 = h();
            boolean h3 = ijVar.h();
            if ((h2 || h3) && !(h2 && h3 && this.f1394g.equals(ijVar.f1394g))) {
                return false;
            }
            boolean i2 = i();
            boolean i3 = ijVar.i();
            if ((i2 || i3) && !(i2 && i3 && this.f1395h.equals(ijVar.f1395h))) {
                return false;
            }
            boolean j2 = j();
            boolean j3 = ijVar.j();
            if ((j2 || j3) && !(j2 && j3 && this.f1396i.equals(ijVar.f1396i))) {
                return false;
            }
            boolean k2 = k();
            boolean k3 = ijVar.k();
            if ((k2 || k3) && !(k2 && k3 && this.f1397j.equals(ijVar.f1397j))) {
                return false;
            }
            boolean l2 = l();
            boolean l3 = ijVar.l();
            if ((l2 || l3) && !(l2 && l3 && this.f1398k.equals(ijVar.f1398k))) {
                return false;
            }
            boolean m2 = m();
            boolean m3 = ijVar.m();
            if ((m2 || m3) && !(m2 && m3 && this.f1376a == ijVar.f1376a)) {
                return false;
            }
            boolean n2 = n();
            boolean n3 = ijVar.n();
            if ((n2 || n3) && !(n2 && n3 && this.f1384b == ijVar.f1384b)) {
                return false;
            }
            boolean o2 = o();
            boolean o3 = ijVar.o();
            if ((o2 || o3) && !(o2 && o3 && this.f1399l.equals(ijVar.f1399l))) {
                return false;
            }
            boolean p2 = p();
            boolean p3 = ijVar.p();
            if ((p2 || p3) && !(p2 && p3 && this.f1400m.equals(ijVar.f1400m))) {
                return false;
            }
            boolean q2 = q();
            boolean q3 = ijVar.q();
            if ((q2 || q3) && !(q2 && q3 && this.f1401n.equals(ijVar.f1401n))) {
                return false;
            }
            boolean r2 = r();
            boolean r3 = ijVar.r();
            if ((r2 || r3) && !(r2 && r3 && this.f1402o.equals(ijVar.f1402o))) {
                return false;
            }
            boolean s2 = s();
            boolean s3 = ijVar.s();
            if ((s2 || s3) && !(s2 && s3 && this.f1388c == ijVar.f1388c)) {
                return false;
            }
            boolean t2 = t();
            boolean t3 = ijVar.t();
            if ((t2 || t3) && !(t2 && t3 && this.f1378a.equals(ijVar.f1378a))) {
                return false;
            }
            boolean u2 = u();
            boolean u3 = ijVar.u();
            if ((u2 || u3) && !(u2 && u3 && this.f1383a == ijVar.f1383a)) {
                return false;
            }
            boolean v2 = v();
            boolean v3 = ijVar.v();
            if ((v2 || v3) && !(v2 && v3 && this.f1377a == ijVar.f1377a)) {
                return false;
            }
            boolean w2 = w();
            boolean w3 = ijVar.w();
            if ((w2 || w3) && !(w2 && w3 && this.f1385b == ijVar.f1385b)) {
                return false;
            }
            boolean x2 = x();
            boolean x3 = ijVar.x();
            if ((x2 || x3) && !(x2 && x3 && this.f1403p.equals(ijVar.f1403p))) {
                return false;
            }
            boolean y2 = y();
            boolean y3 = ijVar.y();
            if ((y2 || y3) && !(y2 && y3 && this.f1404q.equals(ijVar.f1404q))) {
                return false;
            }
            boolean z2 = z();
            boolean z3 = ijVar.z();
            if ((z2 || z3) && !(z2 && z3 && this.f1387b == ijVar.f1387b)) {
                return false;
            }
            boolean A2 = A();
            boolean A3 = ijVar.A();
            if ((A2 || A3) && !(A2 && A3 && this.f1382a.equals(ijVar.f1382a))) {
                return false;
            }
            boolean B2 = B();
            boolean B3 = ijVar.B();
            if ((B2 || B3) && !(B2 && B3 && this.f1390c == ijVar.f1390c)) {
                return false;
            }
            boolean C2 = C();
            boolean C3 = ijVar.C();
            if (C2 || C3) {
                return C2 && C3 && this.f1405r.equals(ijVar.f1405r);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public ij b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i2)) == null) {
            this.f1384b = i2;
            b(true);
            return this;
        }
        return (ij) invokeI.objValue;
    }

    public ij b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
            this.f1389c = str;
            return this;
        }
        return (ij) invokeL.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f1389c : (String) invokeV.objValue;
    }

    @Override // com.xiaomi.push.iu
    public void b(jf jfVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, jfVar) == null) {
            m1427a();
            jfVar.a(f1375a);
            if (this.f1380a != null && m1428a()) {
                jfVar.a(a);
                jfVar.a(this.f1380a);
                jfVar.b();
            }
            if (this.f1379a != null && m1430b()) {
                jfVar.a(b);
                this.f1379a.b(jfVar);
                jfVar.b();
            }
            if (this.f1386b != null) {
                jfVar.a(c);
                jfVar.a(this.f1386b);
                jfVar.b();
            }
            if (this.f1389c != null) {
                jfVar.a(d);
                jfVar.a(this.f1389c);
                jfVar.b();
            }
            if (this.f1391d != null && e()) {
                jfVar.a(e);
                jfVar.a(this.f1391d);
                jfVar.b();
            }
            if (this.f1392e != null && f()) {
                jfVar.a(f);
                jfVar.a(this.f1392e);
                jfVar.b();
            }
            if (this.f1393f != null) {
                jfVar.a(g);
                jfVar.a(this.f1393f);
                jfVar.b();
            }
            if (this.f1394g != null && h()) {
                jfVar.a(h);
                jfVar.a(this.f1394g);
                jfVar.b();
            }
            if (this.f1395h != null && i()) {
                jfVar.a(i);
                jfVar.a(this.f1395h);
                jfVar.b();
            }
            if (this.f1396i != null && j()) {
                jfVar.a(j);
                jfVar.a(this.f1396i);
                jfVar.b();
            }
            if (this.f1397j != null && k()) {
                jfVar.a(k);
                jfVar.a(this.f1397j);
                jfVar.b();
            }
            if (this.f1398k != null && l()) {
                jfVar.a(l);
                jfVar.a(this.f1398k);
                jfVar.b();
            }
            if (m()) {
                jfVar.a(m);
                jfVar.a(this.f1376a);
                jfVar.b();
            }
            if (n()) {
                jfVar.a(n);
                jfVar.a(this.f1384b);
                jfVar.b();
            }
            if (this.f1399l != null && o()) {
                jfVar.a(o);
                jfVar.a(this.f1399l);
                jfVar.b();
            }
            if (this.f1400m != null && p()) {
                jfVar.a(p);
                jfVar.a(this.f1400m);
                jfVar.b();
            }
            if (this.f1401n != null && q()) {
                jfVar.a(q);
                jfVar.a(this.f1401n);
                jfVar.b();
            }
            if (this.f1402o != null && r()) {
                jfVar.a(r);
                jfVar.a(this.f1402o);
                jfVar.b();
            }
            if (s()) {
                jfVar.a(s);
                jfVar.a(this.f1388c);
                jfVar.b();
            }
            if (this.f1378a != null && t()) {
                jfVar.a(t);
                jfVar.a(this.f1378a.a());
                jfVar.b();
            }
            if (u()) {
                jfVar.a(u);
                jfVar.a(this.f1383a);
                jfVar.b();
            }
            if (v()) {
                jfVar.a(v);
                jfVar.a(this.f1377a);
                jfVar.b();
            }
            if (w()) {
                jfVar.a(w);
                jfVar.a(this.f1385b);
                jfVar.b();
            }
            if (this.f1403p != null && x()) {
                jfVar.a(x);
                jfVar.a(this.f1403p);
                jfVar.b();
            }
            if (this.f1404q != null && y()) {
                jfVar.a(y);
                jfVar.a(this.f1404q);
                jfVar.b();
            }
            if (z()) {
                jfVar.a(z);
                jfVar.a(this.f1387b);
                jfVar.b();
            }
            if (this.f1382a != null && A()) {
                jfVar.a(A);
                jfVar.a(new je(Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, this.f1382a.size()));
                for (Map.Entry<String, String> entry : this.f1382a.entrySet()) {
                    jfVar.a(entry.getKey());
                    jfVar.a(entry.getValue());
                }
                jfVar.d();
                jfVar.b();
            }
            if (B()) {
                jfVar.a(B);
                jfVar.a(this.f1390c);
                jfVar.b();
            }
            if (this.f1405r != null && C()) {
                jfVar.a(C);
                jfVar.a(this.f1405r);
                jfVar.b();
            }
            jfVar.c();
            jfVar.m1491a();
        }
    }

    public void b(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z2) == null) {
            this.f1381a.set(1, z2);
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m1430b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f1379a != null : invokeV.booleanValue;
    }

    public ij c(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048595, this, i2)) == null) {
            this.f1388c = i2;
            c(true);
            return this;
        }
        return (ij) invokeI.objValue;
    }

    public ij c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, str)) == null) {
            this.f1391d = str;
            return this;
        }
        return (ij) invokeL.objValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.f1393f : (String) invokeV.objValue;
    }

    public void c(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z2) == null) {
            this.f1381a.set(2, z2);
        }
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m1431c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.f1386b != null : invokeV.booleanValue;
    }

    public ij d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, str)) == null) {
            this.f1392e = str;
            return this;
        }
        return (ij) invokeL.objValue;
    }

    public void d(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z2) == null) {
            this.f1381a.set(3, z2);
        }
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.f1389c != null : invokeV.booleanValue;
    }

    public ij e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, str)) == null) {
            this.f1393f = str;
            return this;
        }
        return (ij) invokeL.objValue;
    }

    public void e(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048605, this, z2) == null) {
            this.f1381a.set(4, z2);
        }
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.f1391d != null : invokeV.booleanValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, obj)) == null) {
            if (obj != null && (obj instanceof ij)) {
                return m1429a((ij) obj);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public ij f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048608, this, str)) == null) {
            this.f1394g = str;
            return this;
        }
        return (ij) invokeL.objValue;
    }

    public void f(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048609, this, z2) == null) {
            this.f1381a.set(5, z2);
        }
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.f1392e != null : invokeV.booleanValue;
    }

    public ij g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048611, this, str)) == null) {
            this.f1395h = str;
            return this;
        }
        return (ij) invokeL.objValue;
    }

    public void g(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048612, this, z2) == null) {
            this.f1381a.set(6, z2);
        }
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? this.f1393f != null : invokeV.booleanValue;
    }

    public ij h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048614, this, str)) == null) {
            this.f1398k = str;
            return this;
        }
        return (ij) invokeL.objValue;
    }

    public void h(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048615, this, z2) == null) {
            this.f1381a.set(7, z2);
        }
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? this.f1394g != null : invokeV.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public ij i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048618, this, str)) == null) {
            this.f1402o = str;
            return this;
        }
        return (ij) invokeL.objValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) ? this.f1395h != null : invokeV.booleanValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) ? this.f1396i != null : invokeV.booleanValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) ? this.f1397j != null : invokeV.booleanValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) ? this.f1398k != null : invokeV.booleanValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) ? this.f1381a.get(0) : invokeV.booleanValue;
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) ? this.f1381a.get(1) : invokeV.booleanValue;
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) ? this.f1399l != null : invokeV.booleanValue;
    }

    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) ? this.f1400m != null : invokeV.booleanValue;
    }

    public boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) ? this.f1401n != null : invokeV.booleanValue;
    }

    public boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) ? this.f1402o != null : invokeV.booleanValue;
    }

    public boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) ? this.f1381a.get(2) : invokeV.booleanValue;
    }

    public boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) ? this.f1378a != null : invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) {
            StringBuilder sb = new StringBuilder("XmPushActionRegistration(");
            boolean z3 = false;
            if (m1428a()) {
                sb.append("debug:");
                String str = this.f1380a;
                if (str == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str);
                }
                z2 = false;
            } else {
                z2 = true;
            }
            if (m1430b()) {
                if (!z2) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                }
                sb.append("target:");
                hy hyVar = this.f1379a;
                if (hyVar == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(hyVar);
                }
            } else {
                z3 = z2;
            }
            if (!z3) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            }
            sb.append("id:");
            String str2 = this.f1386b;
            if (str2 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str2);
            }
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("appId:");
            String str3 = this.f1389c;
            if (str3 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str3);
            }
            if (e()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("appVersion:");
                String str4 = this.f1391d;
                if (str4 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str4);
                }
            }
            if (f()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("packageName:");
                String str5 = this.f1392e;
                if (str5 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str5);
                }
            }
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("token:");
            String str6 = this.f1393f;
            if (str6 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str6);
            }
            if (h()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("deviceId:");
                String str7 = this.f1394g;
                if (str7 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str7);
                }
            }
            if (i()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("aliasName:");
                String str8 = this.f1395h;
                if (str8 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str8);
                }
            }
            if (j()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("sdkVersion:");
                String str9 = this.f1396i;
                if (str9 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str9);
                }
            }
            if (k()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("regId:");
                String str10 = this.f1397j;
                if (str10 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str10);
                }
            }
            if (l()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("pushSdkVersionName:");
                String str11 = this.f1398k;
                if (str11 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str11);
                }
            }
            if (m()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("pushSdkVersionCode:");
                sb.append(this.f1376a);
            }
            if (n()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("appVersionCode:");
                sb.append(this.f1384b);
            }
            if (o()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("androidId:");
                String str12 = this.f1399l;
                if (str12 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str12);
                }
            }
            if (p()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("imei:");
                String str13 = this.f1400m;
                if (str13 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str13);
                }
            }
            if (q()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("serial:");
                String str14 = this.f1401n;
                if (str14 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str14);
                }
            }
            if (r()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("imeiMd5:");
                String str15 = this.f1402o;
                if (str15 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str15);
                }
            }
            if (s()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("spaceId:");
                sb.append(this.f1388c);
            }
            if (t()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("reason:");
                hx hxVar = this.f1378a;
                if (hxVar == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(hxVar);
                }
            }
            if (u()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("validateToken:");
                sb.append(this.f1383a);
            }
            if (v()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("miid:");
                sb.append(this.f1377a);
            }
            if (w()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("createdTs:");
                sb.append(this.f1385b);
            }
            if (x()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("subImei:");
                String str16 = this.f1403p;
                if (str16 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str16);
                }
            }
            if (y()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("subImeiMd5:");
                String str17 = this.f1404q;
                if (str17 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str17);
                }
            }
            if (z()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("isHybridFrame:");
                sb.append(this.f1387b);
            }
            if (A()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("connectionAttrs:");
                Map<String, String> map = this.f1382a;
                if (map == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(map);
                }
            }
            if (B()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("cleanOldRegInfo:");
                sb.append(this.f1390c);
            }
            if (C()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("oldRegId:");
                String str18 = this.f1405r;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) ? this.f1381a.get(3) : invokeV.booleanValue;
    }

    public boolean v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) ? this.f1381a.get(4) : invokeV.booleanValue;
    }

    public boolean w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) ? this.f1381a.get(5) : invokeV.booleanValue;
    }

    public boolean x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) ? this.f1403p != null : invokeV.booleanValue;
    }

    public boolean y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) ? this.f1404q != null : invokeV.booleanValue;
    }

    public boolean z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) ? this.f1381a.get(6) : invokeV.booleanValue;
    }
}
