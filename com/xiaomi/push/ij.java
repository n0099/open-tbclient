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
    public static final jk f648a;
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
    public int f649a;

    /* renamed from: a  reason: collision with other field name */
    public long f650a;

    /* renamed from: a  reason: collision with other field name */
    public hx f651a;

    /* renamed from: a  reason: collision with other field name */
    public hy f652a;

    /* renamed from: a  reason: collision with other field name */
    public String f653a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f654a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f655a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f656a;

    /* renamed from: b  reason: collision with other field name */
    public int f657b;

    /* renamed from: b  reason: collision with other field name */
    public long f658b;

    /* renamed from: b  reason: collision with other field name */
    public String f659b;

    /* renamed from: b  reason: collision with other field name */
    public boolean f660b;

    /* renamed from: c  reason: collision with other field name */
    public int f661c;

    /* renamed from: c  reason: collision with other field name */
    public String f662c;

    /* renamed from: c  reason: collision with other field name */
    public boolean f663c;

    /* renamed from: d  reason: collision with other field name */
    public String f664d;

    /* renamed from: e  reason: collision with other field name */
    public String f665e;

    /* renamed from: f  reason: collision with other field name */
    public String f666f;

    /* renamed from: g  reason: collision with other field name */
    public String f667g;

    /* renamed from: h  reason: collision with other field name */
    public String f668h;

    /* renamed from: i  reason: collision with other field name */
    public String f669i;

    /* renamed from: j  reason: collision with other field name */
    public String f670j;

    /* renamed from: k  reason: collision with other field name */
    public String f671k;

    /* renamed from: l  reason: collision with other field name */
    public String f672l;

    /* renamed from: m  reason: collision with other field name */
    public String f673m;

    /* renamed from: n  reason: collision with other field name */
    public String f674n;

    /* renamed from: o  reason: collision with other field name */
    public String f675o;

    /* renamed from: p  reason: collision with other field name */
    public String f676p;

    /* renamed from: q  reason: collision with other field name */
    public String f677q;

    /* renamed from: r  reason: collision with other field name */
    public String f678r;

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
        f648a = new jk("XmPushActionRegistration");
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
        A = new jc("", (byte) 13, (short) 100);
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
        this.f654a = new BitSet(8);
        this.f656a = true;
        this.f663c = false;
        this.f660b = false;
    }

    public boolean A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f655a != null : invokeV.booleanValue;
    }

    public boolean B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f654a.get(7) : invokeV.booleanValue;
    }

    public boolean C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f678r != null : invokeV.booleanValue;
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
                int compareTo = Boolean.valueOf(m485a()).compareTo(Boolean.valueOf(ijVar.m485a()));
                if (compareTo != 0) {
                    return compareTo;
                }
                if (!m485a() || (a30 = iv.a(this.f653a, ijVar.f653a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m487b()).compareTo(Boolean.valueOf(ijVar.m487b()));
                    if (compareTo2 != 0) {
                        return compareTo2;
                    }
                    if (!m487b() || (a29 = iv.a(this.f652a, ijVar.f652a)) == 0) {
                        int compareTo3 = Boolean.valueOf(m488c()).compareTo(Boolean.valueOf(ijVar.m488c()));
                        if (compareTo3 != 0) {
                            return compareTo3;
                        }
                        if (!m488c() || (a28 = iv.a(this.f659b, ijVar.f659b)) == 0) {
                            int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(ijVar.d()));
                            if (compareTo4 != 0) {
                                return compareTo4;
                            }
                            if (!d() || (a27 = iv.a(this.f662c, ijVar.f662c)) == 0) {
                                int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(ijVar.e()));
                                if (compareTo5 != 0) {
                                    return compareTo5;
                                }
                                if (!e() || (a26 = iv.a(this.f664d, ijVar.f664d)) == 0) {
                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(ijVar.f()));
                                    if (compareTo6 != 0) {
                                        return compareTo6;
                                    }
                                    if (!f() || (a25 = iv.a(this.f665e, ijVar.f665e)) == 0) {
                                        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ijVar.g()));
                                        if (compareTo7 != 0) {
                                            return compareTo7;
                                        }
                                        if (!g() || (a24 = iv.a(this.f666f, ijVar.f666f)) == 0) {
                                            int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(ijVar.h()));
                                            if (compareTo8 != 0) {
                                                return compareTo8;
                                            }
                                            if (!h() || (a23 = iv.a(this.f667g, ijVar.f667g)) == 0) {
                                                int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(ijVar.i()));
                                                if (compareTo9 != 0) {
                                                    return compareTo9;
                                                }
                                                if (!i() || (a22 = iv.a(this.f668h, ijVar.f668h)) == 0) {
                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(ijVar.j()));
                                                    if (compareTo10 != 0) {
                                                        return compareTo10;
                                                    }
                                                    if (!j() || (a21 = iv.a(this.f669i, ijVar.f669i)) == 0) {
                                                        int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(ijVar.k()));
                                                        if (compareTo11 != 0) {
                                                            return compareTo11;
                                                        }
                                                        if (!k() || (a20 = iv.a(this.f670j, ijVar.f670j)) == 0) {
                                                            int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(ijVar.l()));
                                                            if (compareTo12 != 0) {
                                                                return compareTo12;
                                                            }
                                                            if (!l() || (a19 = iv.a(this.f671k, ijVar.f671k)) == 0) {
                                                                int compareTo13 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(ijVar.m()));
                                                                if (compareTo13 != 0) {
                                                                    return compareTo13;
                                                                }
                                                                if (!m() || (a18 = iv.a(this.f649a, ijVar.f649a)) == 0) {
                                                                    int compareTo14 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(ijVar.n()));
                                                                    if (compareTo14 != 0) {
                                                                        return compareTo14;
                                                                    }
                                                                    if (!n() || (a17 = iv.a(this.f657b, ijVar.f657b)) == 0) {
                                                                        int compareTo15 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(ijVar.o()));
                                                                        if (compareTo15 != 0) {
                                                                            return compareTo15;
                                                                        }
                                                                        if (!o() || (a16 = iv.a(this.f672l, ijVar.f672l)) == 0) {
                                                                            int compareTo16 = Boolean.valueOf(p()).compareTo(Boolean.valueOf(ijVar.p()));
                                                                            if (compareTo16 != 0) {
                                                                                return compareTo16;
                                                                            }
                                                                            if (!p() || (a15 = iv.a(this.f673m, ijVar.f673m)) == 0) {
                                                                                int compareTo17 = Boolean.valueOf(q()).compareTo(Boolean.valueOf(ijVar.q()));
                                                                                if (compareTo17 != 0) {
                                                                                    return compareTo17;
                                                                                }
                                                                                if (!q() || (a14 = iv.a(this.f674n, ijVar.f674n)) == 0) {
                                                                                    int compareTo18 = Boolean.valueOf(r()).compareTo(Boolean.valueOf(ijVar.r()));
                                                                                    if (compareTo18 != 0) {
                                                                                        return compareTo18;
                                                                                    }
                                                                                    if (!r() || (a13 = iv.a(this.f675o, ijVar.f675o)) == 0) {
                                                                                        int compareTo19 = Boolean.valueOf(s()).compareTo(Boolean.valueOf(ijVar.s()));
                                                                                        if (compareTo19 != 0) {
                                                                                            return compareTo19;
                                                                                        }
                                                                                        if (!s() || (a12 = iv.a(this.f661c, ijVar.f661c)) == 0) {
                                                                                            int compareTo20 = Boolean.valueOf(t()).compareTo(Boolean.valueOf(ijVar.t()));
                                                                                            if (compareTo20 != 0) {
                                                                                                return compareTo20;
                                                                                            }
                                                                                            if (!t() || (a11 = iv.a(this.f651a, ijVar.f651a)) == 0) {
                                                                                                int compareTo21 = Boolean.valueOf(u()).compareTo(Boolean.valueOf(ijVar.u()));
                                                                                                if (compareTo21 != 0) {
                                                                                                    return compareTo21;
                                                                                                }
                                                                                                if (!u() || (a10 = iv.a(this.f656a, ijVar.f656a)) == 0) {
                                                                                                    int compareTo22 = Boolean.valueOf(v()).compareTo(Boolean.valueOf(ijVar.v()));
                                                                                                    if (compareTo22 != 0) {
                                                                                                        return compareTo22;
                                                                                                    }
                                                                                                    if (!v() || (a9 = iv.a(this.f650a, ijVar.f650a)) == 0) {
                                                                                                        int compareTo23 = Boolean.valueOf(w()).compareTo(Boolean.valueOf(ijVar.w()));
                                                                                                        if (compareTo23 != 0) {
                                                                                                            return compareTo23;
                                                                                                        }
                                                                                                        if (!w() || (a8 = iv.a(this.f658b, ijVar.f658b)) == 0) {
                                                                                                            int compareTo24 = Boolean.valueOf(x()).compareTo(Boolean.valueOf(ijVar.x()));
                                                                                                            if (compareTo24 != 0) {
                                                                                                                return compareTo24;
                                                                                                            }
                                                                                                            if (!x() || (a7 = iv.a(this.f676p, ijVar.f676p)) == 0) {
                                                                                                                int compareTo25 = Boolean.valueOf(y()).compareTo(Boolean.valueOf(ijVar.y()));
                                                                                                                if (compareTo25 != 0) {
                                                                                                                    return compareTo25;
                                                                                                                }
                                                                                                                if (!y() || (a6 = iv.a(this.f677q, ijVar.f677q)) == 0) {
                                                                                                                    int compareTo26 = Boolean.valueOf(z()).compareTo(Boolean.valueOf(ijVar.z()));
                                                                                                                    if (compareTo26 != 0) {
                                                                                                                        return compareTo26;
                                                                                                                    }
                                                                                                                    if (!z() || (a5 = iv.a(this.f660b, ijVar.f660b)) == 0) {
                                                                                                                        int compareTo27 = Boolean.valueOf(A()).compareTo(Boolean.valueOf(ijVar.A()));
                                                                                                                        if (compareTo27 != 0) {
                                                                                                                            return compareTo27;
                                                                                                                        }
                                                                                                                        if (!A() || (a4 = iv.a(this.f655a, ijVar.f655a)) == 0) {
                                                                                                                            int compareTo28 = Boolean.valueOf(B()).compareTo(Boolean.valueOf(ijVar.B()));
                                                                                                                            if (compareTo28 != 0) {
                                                                                                                                return compareTo28;
                                                                                                                            }
                                                                                                                            if (!B() || (a3 = iv.a(this.f663c, ijVar.f663c)) == 0) {
                                                                                                                                int compareTo29 = Boolean.valueOf(C()).compareTo(Boolean.valueOf(ijVar.C()));
                                                                                                                                if (compareTo29 != 0) {
                                                                                                                                    return compareTo29;
                                                                                                                                }
                                                                                                                                if (!C() || (a2 = iv.a(this.f678r, ijVar.f678r)) == 0) {
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
            this.f649a = i2;
            a(true);
            return this;
        }
        return (ij) invokeI.objValue;
    }

    public ij a(hx hxVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, hxVar)) == null) {
            this.f651a = hxVar;
            return this;
        }
        return (ij) invokeL.objValue;
    }

    public ij a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            this.f659b = str;
            return this;
        }
        return (ij) invokeL.objValue;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f659b : (String) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m484a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (this.f659b == null) {
                throw new jg("Required field 'id' was not present! Struct: " + toString());
            } else if (this.f662c == null) {
                throw new jg("Required field 'appId' was not present! Struct: " + toString());
            } else if (this.f666f != null) {
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
        jfVar.m544a();
        while (true) {
            jc m540a = jfVar.m540a();
            byte b2 = m540a.a;
            if (b2 == 0) {
                jfVar.f();
                m484a();
                return;
            }
            short s2 = m540a.f802a;
            switch (s2) {
                case 1:
                    if (b2 == 11) {
                        this.f653a = jfVar.m545a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 2:
                    if (b2 == 12) {
                        hy hyVar = new hy();
                        this.f652a = hyVar;
                        hyVar.a(jfVar);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f659b = jfVar.m545a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f662c = jfVar.m545a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 5:
                    if (b2 == 11) {
                        this.f664d = jfVar.m545a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 6:
                    if (b2 == 11) {
                        this.f665e = jfVar.m545a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f666f = jfVar.m545a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 8:
                    if (b2 == 11) {
                        this.f667g = jfVar.m545a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 9:
                    if (b2 == 11) {
                        this.f668h = jfVar.m545a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 10:
                    if (b2 == 11) {
                        this.f669i = jfVar.m545a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 11:
                    if (b2 == 11) {
                        this.f670j = jfVar.m545a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 12:
                    if (b2 == 11) {
                        this.f671k = jfVar.m545a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 13:
                    if (b2 == 8) {
                        this.f649a = jfVar.m538a();
                        a(true);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 14:
                    if (b2 == 8) {
                        this.f657b = jfVar.m538a();
                        b(true);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 15:
                    if (b2 == 11) {
                        this.f672l = jfVar.m545a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 16:
                    if (b2 == 11) {
                        this.f673m = jfVar.m545a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 17:
                    if (b2 == 11) {
                        this.f674n = jfVar.m545a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 18:
                    if (b2 == 11) {
                        this.f675o = jfVar.m545a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 19:
                    if (b2 == 8) {
                        this.f661c = jfVar.m538a();
                        c(true);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 20:
                    if (b2 == 8) {
                        this.f651a = hx.a(jfVar.m538a());
                        continue;
                        jfVar.g();
                    }
                    break;
                case 21:
                    if (b2 == 2) {
                        this.f656a = jfVar.m549a();
                        d(true);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 22:
                    if (b2 == 10) {
                        this.f650a = jfVar.m539a();
                        e(true);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 23:
                    if (b2 == 10) {
                        this.f658b = jfVar.m539a();
                        f(true);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 24:
                    if (b2 == 11) {
                        this.f676p = jfVar.m545a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 25:
                    if (b2 == 11) {
                        this.f677q = jfVar.m545a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 26:
                    if (b2 == 2) {
                        this.f660b = jfVar.m549a();
                        g(true);
                        continue;
                        jfVar.g();
                    }
                    break;
                default:
                    switch (s2) {
                        case 100:
                            if (b2 == 13) {
                                je m542a = jfVar.m542a();
                                this.f655a = new HashMap(m542a.f804a * 2);
                                for (int i2 = 0; i2 < m542a.f804a; i2++) {
                                    this.f655a.put(jfVar.m545a(), jfVar.m545a());
                                }
                                jfVar.h();
                                break;
                            }
                            break;
                        case 101:
                            if (b2 == 2) {
                                this.f663c = jfVar.m549a();
                                h(true);
                                break;
                            }
                            break;
                        case 102:
                            if (b2 == 11) {
                                this.f678r = jfVar.m545a();
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
            this.f654a.set(0, z2);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m485a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f653a != null : invokeV.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m486a(ij ijVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, ijVar)) == null) {
            if (ijVar == null) {
                return false;
            }
            boolean m485a = m485a();
            boolean m485a2 = ijVar.m485a();
            if ((m485a || m485a2) && !(m485a && m485a2 && this.f653a.equals(ijVar.f653a))) {
                return false;
            }
            boolean m487b = m487b();
            boolean m487b2 = ijVar.m487b();
            if ((m487b || m487b2) && !(m487b && m487b2 && this.f652a.m438a(ijVar.f652a))) {
                return false;
            }
            boolean m488c = m488c();
            boolean m488c2 = ijVar.m488c();
            if ((m488c || m488c2) && !(m488c && m488c2 && this.f659b.equals(ijVar.f659b))) {
                return false;
            }
            boolean d2 = d();
            boolean d3 = ijVar.d();
            if ((d2 || d3) && !(d2 && d3 && this.f662c.equals(ijVar.f662c))) {
                return false;
            }
            boolean e2 = e();
            boolean e3 = ijVar.e();
            if ((e2 || e3) && !(e2 && e3 && this.f664d.equals(ijVar.f664d))) {
                return false;
            }
            boolean f2 = f();
            boolean f3 = ijVar.f();
            if ((f2 || f3) && !(f2 && f3 && this.f665e.equals(ijVar.f665e))) {
                return false;
            }
            boolean g2 = g();
            boolean g3 = ijVar.g();
            if ((g2 || g3) && !(g2 && g3 && this.f666f.equals(ijVar.f666f))) {
                return false;
            }
            boolean h2 = h();
            boolean h3 = ijVar.h();
            if ((h2 || h3) && !(h2 && h3 && this.f667g.equals(ijVar.f667g))) {
                return false;
            }
            boolean i2 = i();
            boolean i3 = ijVar.i();
            if ((i2 || i3) && !(i2 && i3 && this.f668h.equals(ijVar.f668h))) {
                return false;
            }
            boolean j2 = j();
            boolean j3 = ijVar.j();
            if ((j2 || j3) && !(j2 && j3 && this.f669i.equals(ijVar.f669i))) {
                return false;
            }
            boolean k2 = k();
            boolean k3 = ijVar.k();
            if ((k2 || k3) && !(k2 && k3 && this.f670j.equals(ijVar.f670j))) {
                return false;
            }
            boolean l2 = l();
            boolean l3 = ijVar.l();
            if ((l2 || l3) && !(l2 && l3 && this.f671k.equals(ijVar.f671k))) {
                return false;
            }
            boolean m2 = m();
            boolean m3 = ijVar.m();
            if ((m2 || m3) && !(m2 && m3 && this.f649a == ijVar.f649a)) {
                return false;
            }
            boolean n2 = n();
            boolean n3 = ijVar.n();
            if ((n2 || n3) && !(n2 && n3 && this.f657b == ijVar.f657b)) {
                return false;
            }
            boolean o2 = o();
            boolean o3 = ijVar.o();
            if ((o2 || o3) && !(o2 && o3 && this.f672l.equals(ijVar.f672l))) {
                return false;
            }
            boolean p2 = p();
            boolean p3 = ijVar.p();
            if ((p2 || p3) && !(p2 && p3 && this.f673m.equals(ijVar.f673m))) {
                return false;
            }
            boolean q2 = q();
            boolean q3 = ijVar.q();
            if ((q2 || q3) && !(q2 && q3 && this.f674n.equals(ijVar.f674n))) {
                return false;
            }
            boolean r2 = r();
            boolean r3 = ijVar.r();
            if ((r2 || r3) && !(r2 && r3 && this.f675o.equals(ijVar.f675o))) {
                return false;
            }
            boolean s2 = s();
            boolean s3 = ijVar.s();
            if ((s2 || s3) && !(s2 && s3 && this.f661c == ijVar.f661c)) {
                return false;
            }
            boolean t2 = t();
            boolean t3 = ijVar.t();
            if ((t2 || t3) && !(t2 && t3 && this.f651a.equals(ijVar.f651a))) {
                return false;
            }
            boolean u2 = u();
            boolean u3 = ijVar.u();
            if ((u2 || u3) && !(u2 && u3 && this.f656a == ijVar.f656a)) {
                return false;
            }
            boolean v2 = v();
            boolean v3 = ijVar.v();
            if ((v2 || v3) && !(v2 && v3 && this.f650a == ijVar.f650a)) {
                return false;
            }
            boolean w2 = w();
            boolean w3 = ijVar.w();
            if ((w2 || w3) && !(w2 && w3 && this.f658b == ijVar.f658b)) {
                return false;
            }
            boolean x2 = x();
            boolean x3 = ijVar.x();
            if ((x2 || x3) && !(x2 && x3 && this.f676p.equals(ijVar.f676p))) {
                return false;
            }
            boolean y2 = y();
            boolean y3 = ijVar.y();
            if ((y2 || y3) && !(y2 && y3 && this.f677q.equals(ijVar.f677q))) {
                return false;
            }
            boolean z2 = z();
            boolean z3 = ijVar.z();
            if ((z2 || z3) && !(z2 && z3 && this.f660b == ijVar.f660b)) {
                return false;
            }
            boolean A2 = A();
            boolean A3 = ijVar.A();
            if ((A2 || A3) && !(A2 && A3 && this.f655a.equals(ijVar.f655a))) {
                return false;
            }
            boolean B2 = B();
            boolean B3 = ijVar.B();
            if ((B2 || B3) && !(B2 && B3 && this.f663c == ijVar.f663c)) {
                return false;
            }
            boolean C2 = C();
            boolean C3 = ijVar.C();
            if (C2 || C3) {
                return C2 && C3 && this.f678r.equals(ijVar.f678r);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public ij b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i2)) == null) {
            this.f657b = i2;
            b(true);
            return this;
        }
        return (ij) invokeI.objValue;
    }

    public ij b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
            this.f662c = str;
            return this;
        }
        return (ij) invokeL.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f662c : (String) invokeV.objValue;
    }

    @Override // com.xiaomi.push.iu
    public void b(jf jfVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, jfVar) == null) {
            m484a();
            jfVar.a(f648a);
            if (this.f653a != null && m485a()) {
                jfVar.a(a);
                jfVar.a(this.f653a);
                jfVar.b();
            }
            if (this.f652a != null && m487b()) {
                jfVar.a(b);
                this.f652a.b(jfVar);
                jfVar.b();
            }
            if (this.f659b != null) {
                jfVar.a(c);
                jfVar.a(this.f659b);
                jfVar.b();
            }
            if (this.f662c != null) {
                jfVar.a(d);
                jfVar.a(this.f662c);
                jfVar.b();
            }
            if (this.f664d != null && e()) {
                jfVar.a(e);
                jfVar.a(this.f664d);
                jfVar.b();
            }
            if (this.f665e != null && f()) {
                jfVar.a(f);
                jfVar.a(this.f665e);
                jfVar.b();
            }
            if (this.f666f != null) {
                jfVar.a(g);
                jfVar.a(this.f666f);
                jfVar.b();
            }
            if (this.f667g != null && h()) {
                jfVar.a(h);
                jfVar.a(this.f667g);
                jfVar.b();
            }
            if (this.f668h != null && i()) {
                jfVar.a(i);
                jfVar.a(this.f668h);
                jfVar.b();
            }
            if (this.f669i != null && j()) {
                jfVar.a(j);
                jfVar.a(this.f669i);
                jfVar.b();
            }
            if (this.f670j != null && k()) {
                jfVar.a(k);
                jfVar.a(this.f670j);
                jfVar.b();
            }
            if (this.f671k != null && l()) {
                jfVar.a(l);
                jfVar.a(this.f671k);
                jfVar.b();
            }
            if (m()) {
                jfVar.a(m);
                jfVar.a(this.f649a);
                jfVar.b();
            }
            if (n()) {
                jfVar.a(n);
                jfVar.a(this.f657b);
                jfVar.b();
            }
            if (this.f672l != null && o()) {
                jfVar.a(o);
                jfVar.a(this.f672l);
                jfVar.b();
            }
            if (this.f673m != null && p()) {
                jfVar.a(p);
                jfVar.a(this.f673m);
                jfVar.b();
            }
            if (this.f674n != null && q()) {
                jfVar.a(q);
                jfVar.a(this.f674n);
                jfVar.b();
            }
            if (this.f675o != null && r()) {
                jfVar.a(r);
                jfVar.a(this.f675o);
                jfVar.b();
            }
            if (s()) {
                jfVar.a(s);
                jfVar.a(this.f661c);
                jfVar.b();
            }
            if (this.f651a != null && t()) {
                jfVar.a(t);
                jfVar.a(this.f651a.a());
                jfVar.b();
            }
            if (u()) {
                jfVar.a(u);
                jfVar.a(this.f656a);
                jfVar.b();
            }
            if (v()) {
                jfVar.a(v);
                jfVar.a(this.f650a);
                jfVar.b();
            }
            if (w()) {
                jfVar.a(w);
                jfVar.a(this.f658b);
                jfVar.b();
            }
            if (this.f676p != null && x()) {
                jfVar.a(x);
                jfVar.a(this.f676p);
                jfVar.b();
            }
            if (this.f677q != null && y()) {
                jfVar.a(y);
                jfVar.a(this.f677q);
                jfVar.b();
            }
            if (z()) {
                jfVar.a(z);
                jfVar.a(this.f660b);
                jfVar.b();
            }
            if (this.f655a != null && A()) {
                jfVar.a(A);
                jfVar.a(new je(Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, this.f655a.size()));
                for (Map.Entry<String, String> entry : this.f655a.entrySet()) {
                    jfVar.a(entry.getKey());
                    jfVar.a(entry.getValue());
                }
                jfVar.d();
                jfVar.b();
            }
            if (B()) {
                jfVar.a(B);
                jfVar.a(this.f663c);
                jfVar.b();
            }
            if (this.f678r != null && C()) {
                jfVar.a(C);
                jfVar.a(this.f678r);
                jfVar.b();
            }
            jfVar.c();
            jfVar.m548a();
        }
    }

    public void b(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z2) == null) {
            this.f654a.set(1, z2);
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m487b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f652a != null : invokeV.booleanValue;
    }

    public ij c(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048595, this, i2)) == null) {
            this.f661c = i2;
            c(true);
            return this;
        }
        return (ij) invokeI.objValue;
    }

    public ij c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, str)) == null) {
            this.f664d = str;
            return this;
        }
        return (ij) invokeL.objValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.f666f : (String) invokeV.objValue;
    }

    public void c(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z2) == null) {
            this.f654a.set(2, z2);
        }
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m488c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.f659b != null : invokeV.booleanValue;
    }

    public ij d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, str)) == null) {
            this.f665e = str;
            return this;
        }
        return (ij) invokeL.objValue;
    }

    public void d(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z2) == null) {
            this.f654a.set(3, z2);
        }
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.f662c != null : invokeV.booleanValue;
    }

    public ij e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, str)) == null) {
            this.f666f = str;
            return this;
        }
        return (ij) invokeL.objValue;
    }

    public void e(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048605, this, z2) == null) {
            this.f654a.set(4, z2);
        }
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.f664d != null : invokeV.booleanValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, obj)) == null) {
            if (obj != null && (obj instanceof ij)) {
                return m486a((ij) obj);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public ij f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048608, this, str)) == null) {
            this.f667g = str;
            return this;
        }
        return (ij) invokeL.objValue;
    }

    public void f(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048609, this, z2) == null) {
            this.f654a.set(5, z2);
        }
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.f665e != null : invokeV.booleanValue;
    }

    public ij g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048611, this, str)) == null) {
            this.f668h = str;
            return this;
        }
        return (ij) invokeL.objValue;
    }

    public void g(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048612, this, z2) == null) {
            this.f654a.set(6, z2);
        }
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? this.f666f != null : invokeV.booleanValue;
    }

    public ij h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048614, this, str)) == null) {
            this.f671k = str;
            return this;
        }
        return (ij) invokeL.objValue;
    }

    public void h(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048615, this, z2) == null) {
            this.f654a.set(7, z2);
        }
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? this.f667g != null : invokeV.booleanValue;
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
            this.f675o = str;
            return this;
        }
        return (ij) invokeL.objValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) ? this.f668h != null : invokeV.booleanValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) ? this.f669i != null : invokeV.booleanValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) ? this.f670j != null : invokeV.booleanValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) ? this.f671k != null : invokeV.booleanValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) ? this.f654a.get(0) : invokeV.booleanValue;
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) ? this.f654a.get(1) : invokeV.booleanValue;
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) ? this.f672l != null : invokeV.booleanValue;
    }

    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) ? this.f673m != null : invokeV.booleanValue;
    }

    public boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) ? this.f674n != null : invokeV.booleanValue;
    }

    public boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) ? this.f675o != null : invokeV.booleanValue;
    }

    public boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) ? this.f654a.get(2) : invokeV.booleanValue;
    }

    public boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) ? this.f651a != null : invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) {
            StringBuilder sb = new StringBuilder("XmPushActionRegistration(");
            boolean z3 = false;
            if (m485a()) {
                sb.append("debug:");
                String str = this.f653a;
                if (str == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str);
                }
                z2 = false;
            } else {
                z2 = true;
            }
            if (m487b()) {
                if (!z2) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                }
                sb.append("target:");
                hy hyVar = this.f652a;
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
            String str2 = this.f659b;
            if (str2 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str2);
            }
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("appId:");
            String str3 = this.f662c;
            if (str3 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str3);
            }
            if (e()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("appVersion:");
                String str4 = this.f664d;
                if (str4 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str4);
                }
            }
            if (f()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("packageName:");
                String str5 = this.f665e;
                if (str5 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str5);
                }
            }
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("token:");
            String str6 = this.f666f;
            if (str6 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str6);
            }
            if (h()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("deviceId:");
                String str7 = this.f667g;
                if (str7 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str7);
                }
            }
            if (i()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("aliasName:");
                String str8 = this.f668h;
                if (str8 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str8);
                }
            }
            if (j()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("sdkVersion:");
                String str9 = this.f669i;
                if (str9 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str9);
                }
            }
            if (k()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("regId:");
                String str10 = this.f670j;
                if (str10 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str10);
                }
            }
            if (l()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("pushSdkVersionName:");
                String str11 = this.f671k;
                if (str11 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str11);
                }
            }
            if (m()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("pushSdkVersionCode:");
                sb.append(this.f649a);
            }
            if (n()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("appVersionCode:");
                sb.append(this.f657b);
            }
            if (o()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("androidId:");
                String str12 = this.f672l;
                if (str12 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str12);
                }
            }
            if (p()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("imei:");
                String str13 = this.f673m;
                if (str13 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str13);
                }
            }
            if (q()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("serial:");
                String str14 = this.f674n;
                if (str14 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str14);
                }
            }
            if (r()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("imeiMd5:");
                String str15 = this.f675o;
                if (str15 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str15);
                }
            }
            if (s()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("spaceId:");
                sb.append(this.f661c);
            }
            if (t()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("reason:");
                hx hxVar = this.f651a;
                if (hxVar == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(hxVar);
                }
            }
            if (u()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("validateToken:");
                sb.append(this.f656a);
            }
            if (v()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("miid:");
                sb.append(this.f650a);
            }
            if (w()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("createdTs:");
                sb.append(this.f658b);
            }
            if (x()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("subImei:");
                String str16 = this.f676p;
                if (str16 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str16);
                }
            }
            if (y()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("subImeiMd5:");
                String str17 = this.f677q;
                if (str17 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str17);
                }
            }
            if (z()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("isHybridFrame:");
                sb.append(this.f660b);
            }
            if (A()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("connectionAttrs:");
                Map<String, String> map = this.f655a;
                if (map == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(map);
                }
            }
            if (B()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("cleanOldRegInfo:");
                sb.append(this.f663c);
            }
            if (C()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("oldRegId:");
                String str18 = this.f678r;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) ? this.f654a.get(3) : invokeV.booleanValue;
    }

    public boolean v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) ? this.f654a.get(4) : invokeV.booleanValue;
    }

    public boolean w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) ? this.f654a.get(5) : invokeV.booleanValue;
    }

    public boolean x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) ? this.f676p != null : invokeV.booleanValue;
    }

    public boolean y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) ? this.f677q != null : invokeV.booleanValue;
    }

    public boolean z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) ? this.f654a.get(6) : invokeV.booleanValue;
    }
}
