package com.xiaomi.push;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.retry.HttpRetryStatistic;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
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
/* loaded from: classes7.dex */
public class hs implements iq<hs, Object>, Serializable, Cloneable {
    public static /* synthetic */ Interceptable $ic;
    public static final iy a;

    /* renamed from: a  reason: collision with other field name */
    public static final jg f520a;

    /* renamed from: b  reason: collision with root package name */
    public static final iy f44379b;

    /* renamed from: c  reason: collision with root package name */
    public static final iy f44380c;

    /* renamed from: d  reason: collision with root package name */
    public static final iy f44381d;

    /* renamed from: e  reason: collision with root package name */
    public static final iy f44382e;

    /* renamed from: f  reason: collision with root package name */
    public static final iy f44383f;

    /* renamed from: g  reason: collision with root package name */
    public static final iy f44384g;

    /* renamed from: h  reason: collision with root package name */
    public static final iy f44385h;
    public static final iy i;
    public static final iy j;
    public static final iy k;
    public static final iy l;
    public static final iy m;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public int f521a;

    /* renamed from: a  reason: collision with other field name */
    public long f522a;

    /* renamed from: a  reason: collision with other field name */
    public String f523a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f524a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f525a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f526a;

    /* renamed from: b  reason: collision with other field name */
    public int f527b;

    /* renamed from: b  reason: collision with other field name */
    public String f528b;

    /* renamed from: b  reason: collision with other field name */
    public Map<String, String> f529b;

    /* renamed from: c  reason: collision with other field name */
    public int f530c;

    /* renamed from: c  reason: collision with other field name */
    public String f531c;

    /* renamed from: c  reason: collision with other field name */
    public Map<String, String> f532c;

    /* renamed from: d  reason: collision with other field name */
    public String f533d;

    /* renamed from: e  reason: collision with other field name */
    public String f534e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-56372587, "Lcom/xiaomi/push/hs;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-56372587, "Lcom/xiaomi/push/hs;");
                return;
            }
        }
        f520a = new jg("PushMetaInfo");
        a = new iy("", Constants.GZIP_CAST_TYPE, (short) 1);
        f44379b = new iy("", (byte) 10, (short) 2);
        f44380c = new iy("", Constants.GZIP_CAST_TYPE, (short) 3);
        f44381d = new iy("", Constants.GZIP_CAST_TYPE, (short) 4);
        f44382e = new iy("", Constants.GZIP_CAST_TYPE, (short) 5);
        f44383f = new iy("", (byte) 8, (short) 6);
        f44384g = new iy("", Constants.GZIP_CAST_TYPE, (short) 7);
        f44385h = new iy("", (byte) 8, (short) 8);
        i = new iy("", (byte) 8, (short) 9);
        j = new iy("", (byte) 13, (short) 10);
        k = new iy("", (byte) 13, (short) 11);
        l = new iy("", (byte) 2, (short) 12);
        m = new iy("", (byte) 13, (short) 13);
    }

    public hs() {
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
        this.f524a = new BitSet(5);
        this.f526a = false;
    }

    public hs(hs hsVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {hsVar};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        BitSet bitSet = new BitSet(5);
        this.f524a = bitSet;
        bitSet.clear();
        this.f524a.or(hsVar.f524a);
        if (hsVar.m452a()) {
            this.f523a = hsVar.f523a;
        }
        this.f522a = hsVar.f522a;
        if (hsVar.m458c()) {
            this.f528b = hsVar.f528b;
        }
        if (hsVar.m459d()) {
            this.f531c = hsVar.f531c;
        }
        if (hsVar.e()) {
            this.f533d = hsVar.f533d;
        }
        this.f521a = hsVar.f521a;
        if (hsVar.g()) {
            this.f534e = hsVar.f534e;
        }
        this.f527b = hsVar.f527b;
        this.f530c = hsVar.f530c;
        if (hsVar.j()) {
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, String> entry : hsVar.f525a.entrySet()) {
                hashMap.put(entry.getKey(), entry.getValue());
            }
            this.f525a = hashMap;
        }
        if (hsVar.k()) {
            HashMap hashMap2 = new HashMap();
            for (Map.Entry<String, String> entry2 : hsVar.f529b.entrySet()) {
                hashMap2.put(entry2.getKey(), entry2.getValue());
            }
            this.f529b = hashMap2;
        }
        this.f526a = hsVar.f526a;
        if (hsVar.n()) {
            HashMap hashMap3 = new HashMap();
            for (Map.Entry<String, String> entry3 : hsVar.f532c.entrySet()) {
                hashMap3.put(entry3.getKey(), entry3.getValue());
            }
            this.f532c = hashMap3;
        }
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f521a : invokeV.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(hs hsVar) {
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
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hsVar)) == null) {
            if (hs.class.equals(hsVar.getClass())) {
                int compareTo = Boolean.valueOf(m452a()).compareTo(Boolean.valueOf(hsVar.m452a()));
                if (compareTo != 0) {
                    return compareTo;
                }
                if (!m452a() || (a14 = ir.a(this.f523a, hsVar.f523a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m456b()).compareTo(Boolean.valueOf(hsVar.m456b()));
                    if (compareTo2 != 0) {
                        return compareTo2;
                    }
                    if (!m456b() || (a13 = ir.a(this.f522a, hsVar.f522a)) == 0) {
                        int compareTo3 = Boolean.valueOf(m458c()).compareTo(Boolean.valueOf(hsVar.m458c()));
                        if (compareTo3 != 0) {
                            return compareTo3;
                        }
                        if (!m458c() || (a12 = ir.a(this.f528b, hsVar.f528b)) == 0) {
                            int compareTo4 = Boolean.valueOf(m459d()).compareTo(Boolean.valueOf(hsVar.m459d()));
                            if (compareTo4 != 0) {
                                return compareTo4;
                            }
                            if (!m459d() || (a11 = ir.a(this.f531c, hsVar.f531c)) == 0) {
                                int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hsVar.e()));
                                if (compareTo5 != 0) {
                                    return compareTo5;
                                }
                                if (!e() || (a10 = ir.a(this.f533d, hsVar.f533d)) == 0) {
                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hsVar.f()));
                                    if (compareTo6 != 0) {
                                        return compareTo6;
                                    }
                                    if (!f() || (a9 = ir.a(this.f521a, hsVar.f521a)) == 0) {
                                        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hsVar.g()));
                                        if (compareTo7 != 0) {
                                            return compareTo7;
                                        }
                                        if (!g() || (a8 = ir.a(this.f534e, hsVar.f534e)) == 0) {
                                            int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hsVar.h()));
                                            if (compareTo8 != 0) {
                                                return compareTo8;
                                            }
                                            if (!h() || (a7 = ir.a(this.f527b, hsVar.f527b)) == 0) {
                                                int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hsVar.i()));
                                                if (compareTo9 != 0) {
                                                    return compareTo9;
                                                }
                                                if (!i() || (a6 = ir.a(this.f530c, hsVar.f530c)) == 0) {
                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(hsVar.j()));
                                                    if (compareTo10 != 0) {
                                                        return compareTo10;
                                                    }
                                                    if (!j() || (a5 = ir.a(this.f525a, hsVar.f525a)) == 0) {
                                                        int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(hsVar.k()));
                                                        if (compareTo11 != 0) {
                                                            return compareTo11;
                                                        }
                                                        if (!k() || (a4 = ir.a(this.f529b, hsVar.f529b)) == 0) {
                                                            int compareTo12 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(hsVar.m()));
                                                            if (compareTo12 != 0) {
                                                                return compareTo12;
                                                            }
                                                            if (!m() || (a3 = ir.a(this.f526a, hsVar.f526a)) == 0) {
                                                                int compareTo13 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(hsVar.n()));
                                                                if (compareTo13 != 0) {
                                                                    return compareTo13;
                                                                }
                                                                if (!n() || (a2 = ir.a(this.f532c, hsVar.f532c)) == 0) {
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
            return hs.class.getName().compareTo(hsVar.getClass().getName());
        }
        return invokeL.intValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public long m447a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f522a : invokeV.longValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public hs m448a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? new hs(this) : (hs) invokeV.objValue;
    }

    public hs a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            this.f521a = i2;
            b(true);
            return this;
        }
        return (hs) invokeI.objValue;
    }

    public hs a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            this.f523a = str;
            return this;
        }
        return (hs) invokeL.objValue;
    }

    public hs a(Map<String, String> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, map)) == null) {
            this.f525a = map;
            return this;
        }
        return (hs) invokeL.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m449a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f523a : (String) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public Map<String, String> m450a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f525a : (Map) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m451a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && this.f523a == null) {
            throw new jc("Required field 'id' was not present! Struct: " + toString());
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.xiaomi.push.iq
    public void a(jb jbVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(1048586, this, jbVar) != null) {
            return;
        }
        jbVar.m566a();
        while (true) {
            iy m562a = jbVar.m562a();
            byte b2 = m562a.a;
            if (b2 == 0) {
                jbVar.f();
                if (m456b()) {
                    m451a();
                    return;
                }
                throw new jc("Required field 'messageTs' was not found in serialized data! Struct: " + toString());
            }
            int i2 = 0;
            switch (m562a.f791a) {
                case 1:
                    if (b2 == 11) {
                        this.f523a = jbVar.m567a();
                        break;
                    }
                    je.a(jbVar, b2);
                    break;
                case 2:
                    if (b2 == 10) {
                        this.f522a = jbVar.m561a();
                        a(true);
                        break;
                    }
                    je.a(jbVar, b2);
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f528b = jbVar.m567a();
                        break;
                    }
                    je.a(jbVar, b2);
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f531c = jbVar.m567a();
                        break;
                    }
                    je.a(jbVar, b2);
                    break;
                case 5:
                    if (b2 == 11) {
                        this.f533d = jbVar.m567a();
                        break;
                    }
                    je.a(jbVar, b2);
                    break;
                case 6:
                    if (b2 == 8) {
                        this.f521a = jbVar.m560a();
                        b(true);
                        break;
                    }
                    je.a(jbVar, b2);
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f534e = jbVar.m567a();
                        break;
                    }
                    je.a(jbVar, b2);
                    break;
                case 8:
                    if (b2 == 8) {
                        this.f527b = jbVar.m560a();
                        c(true);
                        break;
                    }
                    je.a(jbVar, b2);
                    break;
                case 9:
                    if (b2 == 8) {
                        this.f530c = jbVar.m560a();
                        d(true);
                        break;
                    }
                    je.a(jbVar, b2);
                    break;
                case 10:
                    if (b2 == 13) {
                        ja m564a = jbVar.m564a();
                        this.f525a = new HashMap(m564a.f795a * 2);
                        while (i2 < m564a.f795a) {
                            this.f525a.put(jbVar.m567a(), jbVar.m567a());
                            i2++;
                        }
                        jbVar.h();
                        break;
                    }
                    je.a(jbVar, b2);
                    break;
                case 11:
                    if (b2 == 13) {
                        ja m564a2 = jbVar.m564a();
                        this.f529b = new HashMap(m564a2.f795a * 2);
                        while (i2 < m564a2.f795a) {
                            this.f529b.put(jbVar.m567a(), jbVar.m567a());
                            i2++;
                        }
                        jbVar.h();
                        break;
                    }
                    je.a(jbVar, b2);
                    break;
                case 12:
                    if (b2 == 2) {
                        this.f526a = jbVar.m571a();
                        e(true);
                        break;
                    }
                    je.a(jbVar, b2);
                    break;
                case 13:
                    if (b2 == 13) {
                        ja m564a3 = jbVar.m564a();
                        this.f532c = new HashMap(m564a3.f795a * 2);
                        while (i2 < m564a3.f795a) {
                            this.f532c.put(jbVar.m567a(), jbVar.m567a());
                            i2++;
                        }
                        jbVar.h();
                        break;
                    }
                    je.a(jbVar, b2);
                    break;
                default:
                    je.a(jbVar, b2);
                    break;
            }
            jbVar.g();
        }
    }

    public void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, str, str2) == null) {
            if (this.f525a == null) {
                this.f525a = new HashMap();
            }
            this.f525a.put(str, str2);
        }
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.f524a.set(0, z);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m452a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f523a != null : invokeV.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m453a(hs hsVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, hsVar)) == null) {
            if (hsVar == null) {
                return false;
            }
            boolean m452a = m452a();
            boolean m452a2 = hsVar.m452a();
            if (((m452a || m452a2) && !(m452a && m452a2 && this.f523a.equals(hsVar.f523a))) || this.f522a != hsVar.f522a) {
                return false;
            }
            boolean m458c = m458c();
            boolean m458c2 = hsVar.m458c();
            if ((m458c || m458c2) && !(m458c && m458c2 && this.f528b.equals(hsVar.f528b))) {
                return false;
            }
            boolean m459d = m459d();
            boolean m459d2 = hsVar.m459d();
            if ((m459d || m459d2) && !(m459d && m459d2 && this.f531c.equals(hsVar.f531c))) {
                return false;
            }
            boolean e2 = e();
            boolean e3 = hsVar.e();
            if ((e2 || e3) && !(e2 && e3 && this.f533d.equals(hsVar.f533d))) {
                return false;
            }
            boolean f2 = f();
            boolean f3 = hsVar.f();
            if ((f2 || f3) && !(f2 && f3 && this.f521a == hsVar.f521a)) {
                return false;
            }
            boolean g2 = g();
            boolean g3 = hsVar.g();
            if ((g2 || g3) && !(g2 && g3 && this.f534e.equals(hsVar.f534e))) {
                return false;
            }
            boolean h2 = h();
            boolean h3 = hsVar.h();
            if ((h2 || h3) && !(h2 && h3 && this.f527b == hsVar.f527b)) {
                return false;
            }
            boolean i2 = i();
            boolean i3 = hsVar.i();
            if ((i2 || i3) && !(i2 && i3 && this.f530c == hsVar.f530c)) {
                return false;
            }
            boolean j2 = j();
            boolean j3 = hsVar.j();
            if ((j2 || j3) && !(j2 && j3 && this.f525a.equals(hsVar.f525a))) {
                return false;
            }
            boolean k2 = k();
            boolean k3 = hsVar.k();
            if ((k2 || k3) && !(k2 && k3 && this.f529b.equals(hsVar.f529b))) {
                return false;
            }
            boolean m2 = m();
            boolean m3 = hsVar.m();
            if ((m2 || m3) && !(m2 && m3 && this.f526a == hsVar.f526a)) {
                return false;
            }
            boolean n = n();
            boolean n2 = hsVar.n();
            if (n || n2) {
                return n && n2 && this.f532c.equals(hsVar.f532c);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f527b : invokeV.intValue;
    }

    public hs b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i2)) == null) {
            this.f527b = i2;
            c(true);
            return this;
        }
        return (hs) invokeI.objValue;
    }

    public hs b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, str)) == null) {
            this.f528b = str;
            return this;
        }
        return (hs) invokeL.objValue;
    }

    /* renamed from: b  reason: collision with other method in class */
    public String m454b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f528b : (String) invokeV.objValue;
    }

    /* renamed from: b  reason: collision with other method in class */
    public Map<String, String> m455b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f529b : (Map) invokeV.objValue;
    }

    @Override // com.xiaomi.push.iq
    public void b(jb jbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, jbVar) == null) {
            m451a();
            jbVar.a(f520a);
            if (this.f523a != null) {
                jbVar.a(a);
                jbVar.a(this.f523a);
                jbVar.b();
            }
            jbVar.a(f44379b);
            jbVar.a(this.f522a);
            jbVar.b();
            if (this.f528b != null && m458c()) {
                jbVar.a(f44380c);
                jbVar.a(this.f528b);
                jbVar.b();
            }
            if (this.f531c != null && m459d()) {
                jbVar.a(f44381d);
                jbVar.a(this.f531c);
                jbVar.b();
            }
            if (this.f533d != null && e()) {
                jbVar.a(f44382e);
                jbVar.a(this.f533d);
                jbVar.b();
            }
            if (f()) {
                jbVar.a(f44383f);
                jbVar.a(this.f521a);
                jbVar.b();
            }
            if (this.f534e != null && g()) {
                jbVar.a(f44384g);
                jbVar.a(this.f534e);
                jbVar.b();
            }
            if (h()) {
                jbVar.a(f44385h);
                jbVar.a(this.f527b);
                jbVar.b();
            }
            if (i()) {
                jbVar.a(i);
                jbVar.a(this.f530c);
                jbVar.b();
            }
            if (this.f525a != null && j()) {
                jbVar.a(j);
                jbVar.a(new ja(Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, this.f525a.size()));
                for (Map.Entry<String, String> entry : this.f525a.entrySet()) {
                    jbVar.a(entry.getKey());
                    jbVar.a(entry.getValue());
                }
                jbVar.d();
                jbVar.b();
            }
            if (this.f529b != null && k()) {
                jbVar.a(k);
                jbVar.a(new ja(Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, this.f529b.size()));
                for (Map.Entry<String, String> entry2 : this.f529b.entrySet()) {
                    jbVar.a(entry2.getKey());
                    jbVar.a(entry2.getValue());
                }
                jbVar.d();
                jbVar.b();
            }
            if (m()) {
                jbVar.a(l);
                jbVar.a(this.f526a);
                jbVar.b();
            }
            if (this.f532c != null && n()) {
                jbVar.a(m);
                jbVar.a(new ja(Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, this.f532c.size()));
                for (Map.Entry<String, String> entry3 : this.f532c.entrySet()) {
                    jbVar.a(entry3.getKey());
                    jbVar.a(entry3.getValue());
                }
                jbVar.d();
                jbVar.b();
            }
            jbVar.c();
            jbVar.m570a();
        }
    }

    public void b(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048597, this, str, str2) == null) {
            if (this.f529b == null) {
                this.f529b = new HashMap();
            }
            this.f529b.put(str, str2);
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            this.f524a.set(1, z);
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m456b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.f524a.get(0) : invokeV.booleanValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.f530c : invokeV.intValue;
    }

    public hs c(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048601, this, i2)) == null) {
            this.f530c = i2;
            d(true);
            return this;
        }
        return (hs) invokeI.objValue;
    }

    public hs c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, str)) == null) {
            this.f531c = str;
            return this;
        }
        return (hs) invokeL.objValue;
    }

    /* renamed from: c  reason: collision with other method in class */
    public String m457c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.f531c : (String) invokeV.objValue;
    }

    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048604, this, z) == null) {
            this.f524a.set(2, z);
        }
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m458c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.f528b != null : invokeV.booleanValue;
    }

    public hs d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, str)) == null) {
            this.f533d = str;
            return this;
        }
        return (hs) invokeL.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.f533d : (String) invokeV.objValue;
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048609, this, z) == null) {
            this.f524a.set(3, z);
        }
    }

    /* renamed from: d  reason: collision with other method in class */
    public boolean m459d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.f531c != null : invokeV.booleanValue;
    }

    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048611, this, z) == null) {
            this.f524a.set(4, z);
        }
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.f533d != null : invokeV.booleanValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048613, this, obj)) == null) {
            if (obj != null && (obj instanceof hs)) {
                return m453a((hs) obj);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? this.f524a.get(1) : invokeV.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? this.f534e != null : invokeV.booleanValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? this.f524a.get(2) : invokeV.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) ? this.f524a.get(3) : invokeV.booleanValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) ? this.f525a != null : invokeV.booleanValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) ? this.f529b != null : invokeV.booleanValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) ? this.f526a : invokeV.booleanValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) ? this.f524a.get(4) : invokeV.booleanValue;
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) ? this.f532c != null : invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            StringBuilder sb = new StringBuilder("PushMetaInfo(");
            sb.append("id:");
            String str = this.f523a;
            if (str == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str);
            }
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("messageTs:");
            sb.append(this.f522a);
            if (m458c()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append(UrlSchemaHelper.SCHEMA_TYPE_TOPIC);
                String str2 = this.f528b;
                if (str2 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str2);
                }
            }
            if (m459d()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("title:");
                String str3 = this.f531c;
                if (str3 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str3);
                }
            }
            if (e()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("description:");
                String str4 = this.f533d;
                if (str4 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str4);
                }
            }
            if (f()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("notifyType:");
                sb.append(this.f521a);
            }
            if (g()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append(HttpRetryStatistic.RETRY_URL);
                String str5 = this.f534e;
                if (str5 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str5);
                }
            }
            if (h()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("passThrough:");
                sb.append(this.f527b);
            }
            if (i()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("notifyId:");
                sb.append(this.f530c);
            }
            if (j()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("extra:");
                Map<String, String> map = this.f525a;
                if (map == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(map);
                }
            }
            if (k()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("internal:");
                Map<String, String> map2 = this.f529b;
                if (map2 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(map2);
                }
            }
            if (m()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("ignoreRegInfo:");
                sb.append(this.f526a);
            }
            if (n()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("apsProperFields:");
                Map<String, String> map3 = this.f532c;
                if (map3 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(map3);
                }
            }
            sb.append(SmallTailInfo.EMOTION_SUFFIX);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
