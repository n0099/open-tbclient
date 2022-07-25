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
public class ia implements iu<ia, Object>, Serializable, Cloneable {
    public static /* synthetic */ Interceptable $ic;
    public static final jc a;

    /* renamed from: a  reason: collision with other field name */
    public static final jk f582a;
    public static final jc b;
    public static final jc c;
    public static final jc d;
    public static final jc e;
    public static final jc f;
    public static final jc g;
    public static final jc h;
    public static final jc i;
    public static final jc j;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public long f583a;

    /* renamed from: a  reason: collision with other field name */
    public hy f584a;

    /* renamed from: a  reason: collision with other field name */
    public String f585a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f586a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f587a;

    /* renamed from: b  reason: collision with other field name */
    public String f588b;

    /* renamed from: c  reason: collision with other field name */
    public String f589c;

    /* renamed from: d  reason: collision with other field name */
    public String f590d;

    /* renamed from: e  reason: collision with other field name */
    public String f591e;

    /* renamed from: f  reason: collision with other field name */
    public String f592f;

    /* renamed from: g  reason: collision with other field name */
    public String f593g;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-56372184, "Lcom/xiaomi/push/ia;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-56372184, "Lcom/xiaomi/push/ia;");
                return;
            }
        }
        f582a = new jk("XmPushActionAckNotification");
        a = new jc("", Constants.GZIP_CAST_TYPE, (short) 1);
        b = new jc("", (byte) 12, (short) 2);
        c = new jc("", Constants.GZIP_CAST_TYPE, (short) 3);
        d = new jc("", Constants.GZIP_CAST_TYPE, (short) 4);
        e = new jc("", Constants.GZIP_CAST_TYPE, (short) 5);
        f = new jc("", (byte) 10, (short) 7);
        g = new jc("", Constants.GZIP_CAST_TYPE, (short) 8);
        h = new jc("", StrictLineReader.CR, (short) 9);
        i = new jc("", Constants.GZIP_CAST_TYPE, (short) 10);
        j = new jc("", Constants.GZIP_CAST_TYPE, (short) 11);
    }

    public ia() {
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
        this.f586a = new BitSet(1);
        this.f583a = 0L;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(ia iaVar) {
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
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, iaVar)) == null) {
            if (ia.class.equals(iaVar.getClass())) {
                int compareTo = Boolean.valueOf(m448a()).compareTo(Boolean.valueOf(iaVar.m448a()));
                if (compareTo != 0) {
                    return compareTo;
                }
                if (!m448a() || (a11 = iv.a(this.f585a, iaVar.f585a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m450b()).compareTo(Boolean.valueOf(iaVar.m450b()));
                    if (compareTo2 != 0) {
                        return compareTo2;
                    }
                    if (!m450b() || (a10 = iv.a(this.f584a, iaVar.f584a)) == 0) {
                        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(iaVar.c()));
                        if (compareTo3 != 0) {
                            return compareTo3;
                        }
                        if (!c() || (a9 = iv.a(this.f588b, iaVar.f588b)) == 0) {
                            int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(iaVar.d()));
                            if (compareTo4 != 0) {
                                return compareTo4;
                            }
                            if (!d() || (a8 = iv.a(this.f589c, iaVar.f589c)) == 0) {
                                int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(iaVar.e()));
                                if (compareTo5 != 0) {
                                    return compareTo5;
                                }
                                if (!e() || (a7 = iv.a(this.f590d, iaVar.f590d)) == 0) {
                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(iaVar.f()));
                                    if (compareTo6 != 0) {
                                        return compareTo6;
                                    }
                                    if (!f() || (a6 = iv.a(this.f583a, iaVar.f583a)) == 0) {
                                        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(iaVar.g()));
                                        if (compareTo7 != 0) {
                                            return compareTo7;
                                        }
                                        if (!g() || (a5 = iv.a(this.f591e, iaVar.f591e)) == 0) {
                                            int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(iaVar.h()));
                                            if (compareTo8 != 0) {
                                                return compareTo8;
                                            }
                                            if (!h() || (a4 = iv.a(this.f587a, iaVar.f587a)) == 0) {
                                                int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(iaVar.i()));
                                                if (compareTo9 != 0) {
                                                    return compareTo9;
                                                }
                                                if (!i() || (a3 = iv.a(this.f592f, iaVar.f592f)) == 0) {
                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(iaVar.j()));
                                                    if (compareTo10 != 0) {
                                                        return compareTo10;
                                                    }
                                                    if (!j() || (a2 = iv.a(this.f593g, iaVar.f593g)) == 0) {
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
            return ia.class.getName().compareTo(iaVar.getClass().getName());
        }
        return invokeL.intValue;
    }

    public ia a(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2)) == null) {
            this.f583a = j2;
            a(true);
            return this;
        }
        return (ia) invokeJ.objValue;
    }

    public ia a(hy hyVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, hyVar)) == null) {
            this.f584a = hyVar;
            return this;
        }
        return (ia) invokeL.objValue;
    }

    public ia a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            this.f588b = str;
            return this;
        }
        return (ia) invokeL.objValue;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f588b : (String) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public Map<String, String> m446a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f587a : (Map) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m447a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && this.f588b == null) {
            throw new jg("Required field 'id' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.iu
    public void a(jf jfVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(1048583, this, jfVar) != null) {
            return;
        }
        jfVar.m549a();
        while (true) {
            jc m545a = jfVar.m545a();
            byte b2 = m545a.a;
            if (b2 == 0) {
                jfVar.f();
                m447a();
                return;
            }
            switch (m545a.f809a) {
                case 1:
                    if (b2 == 11) {
                        this.f585a = jfVar.m550a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 2:
                    if (b2 == 12) {
                        hy hyVar = new hy();
                        this.f584a = hyVar;
                        hyVar.a(jfVar);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f588b = jfVar.m550a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f589c = jfVar.m550a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 5:
                    if (b2 == 11) {
                        this.f590d = jfVar.m550a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 7:
                    if (b2 == 10) {
                        this.f583a = jfVar.m544a();
                        a(true);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 8:
                    if (b2 == 11) {
                        this.f591e = jfVar.m550a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 9:
                    if (b2 == 13) {
                        je m547a = jfVar.m547a();
                        this.f587a = new HashMap(m547a.f811a * 2);
                        for (int i2 = 0; i2 < m547a.f811a; i2++) {
                            this.f587a.put(jfVar.m550a(), jfVar.m550a());
                        }
                        jfVar.h();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 10:
                    if (b2 == 11) {
                        this.f592f = jfVar.m550a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 11:
                    if (b2 == 11) {
                        this.f593g = jfVar.m550a();
                        continue;
                        jfVar.g();
                    }
                    break;
            }
            ji.a(jfVar, b2);
            jfVar.g();
        }
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.f586a.set(0, z);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m448a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f585a != null : invokeV.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m449a(ia iaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, iaVar)) == null) {
            if (iaVar == null) {
                return false;
            }
            boolean m448a = m448a();
            boolean m448a2 = iaVar.m448a();
            if ((m448a || m448a2) && !(m448a && m448a2 && this.f585a.equals(iaVar.f585a))) {
                return false;
            }
            boolean m450b = m450b();
            boolean m450b2 = iaVar.m450b();
            if ((m450b || m450b2) && !(m450b && m450b2 && this.f584a.m443a(iaVar.f584a))) {
                return false;
            }
            boolean c2 = c();
            boolean c3 = iaVar.c();
            if ((c2 || c3) && !(c2 && c3 && this.f588b.equals(iaVar.f588b))) {
                return false;
            }
            boolean d2 = d();
            boolean d3 = iaVar.d();
            if ((d2 || d3) && !(d2 && d3 && this.f589c.equals(iaVar.f589c))) {
                return false;
            }
            boolean e2 = e();
            boolean e3 = iaVar.e();
            if ((e2 || e3) && !(e2 && e3 && this.f590d.equals(iaVar.f590d))) {
                return false;
            }
            boolean f2 = f();
            boolean f3 = iaVar.f();
            if ((f2 || f3) && !(f2 && f3 && this.f583a == iaVar.f583a)) {
                return false;
            }
            boolean g2 = g();
            boolean g3 = iaVar.g();
            if ((g2 || g3) && !(g2 && g3 && this.f591e.equals(iaVar.f591e))) {
                return false;
            }
            boolean h2 = h();
            boolean h3 = iaVar.h();
            if ((h2 || h3) && !(h2 && h3 && this.f587a.equals(iaVar.f587a))) {
                return false;
            }
            boolean i2 = i();
            boolean i3 = iaVar.i();
            if ((i2 || i3) && !(i2 && i3 && this.f592f.equals(iaVar.f592f))) {
                return false;
            }
            boolean j2 = j();
            boolean j3 = iaVar.j();
            if (j2 || j3) {
                return j2 && j3 && this.f593g.equals(iaVar.f593g);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public ia b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
            this.f589c = str;
            return this;
        }
        return (ia) invokeL.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f590d : (String) invokeV.objValue;
    }

    @Override // com.xiaomi.push.iu
    public void b(jf jfVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, jfVar) == null) {
            m447a();
            jfVar.a(f582a);
            if (this.f585a != null && m448a()) {
                jfVar.a(a);
                jfVar.a(this.f585a);
                jfVar.b();
            }
            if (this.f584a != null && m450b()) {
                jfVar.a(b);
                this.f584a.b(jfVar);
                jfVar.b();
            }
            if (this.f588b != null) {
                jfVar.a(c);
                jfVar.a(this.f588b);
                jfVar.b();
            }
            if (this.f589c != null && d()) {
                jfVar.a(d);
                jfVar.a(this.f589c);
                jfVar.b();
            }
            if (this.f590d != null && e()) {
                jfVar.a(e);
                jfVar.a(this.f590d);
                jfVar.b();
            }
            if (f()) {
                jfVar.a(f);
                jfVar.a(this.f583a);
                jfVar.b();
            }
            if (this.f591e != null && g()) {
                jfVar.a(g);
                jfVar.a(this.f591e);
                jfVar.b();
            }
            if (this.f587a != null && h()) {
                jfVar.a(h);
                jfVar.a(new je(Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, this.f587a.size()));
                for (Map.Entry<String, String> entry : this.f587a.entrySet()) {
                    jfVar.a(entry.getKey());
                    jfVar.a(entry.getValue());
                }
                jfVar.d();
                jfVar.b();
            }
            if (this.f592f != null && i()) {
                jfVar.a(i);
                jfVar.a(this.f592f);
                jfVar.b();
            }
            if (this.f593g != null && j()) {
                jfVar.a(j);
                jfVar.a(this.f593g);
                jfVar.b();
            }
            jfVar.c();
            jfVar.m553a();
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m450b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f584a != null : invokeV.booleanValue;
    }

    public ia c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, str)) == null) {
            this.f590d = str;
            return this;
        }
        return (ia) invokeL.objValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f588b != null : invokeV.booleanValue;
    }

    public ia d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, str)) == null) {
            this.f591e = str;
            return this;
        }
        return (ia) invokeL.objValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f589c != null : invokeV.booleanValue;
    }

    public ia e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, str)) == null) {
            this.f592f = str;
            return this;
        }
        return (ia) invokeL.objValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.f590d != null : invokeV.booleanValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, obj)) == null) {
            if (obj != null && (obj instanceof ia)) {
                return m449a((ia) obj);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.f586a.get(0) : invokeV.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.f591e != null : invokeV.booleanValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.f587a != null : invokeV.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.f592f != null : invokeV.booleanValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.f593g != null : invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            StringBuilder sb = new StringBuilder("XmPushActionAckNotification(");
            boolean z2 = false;
            if (m448a()) {
                sb.append("debug:");
                String str = this.f585a;
                if (str == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str);
                }
                z = false;
            } else {
                z = true;
            }
            if (m450b()) {
                if (!z) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                }
                sb.append("target:");
                hy hyVar = this.f584a;
                if (hyVar == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(hyVar);
                }
            } else {
                z2 = z;
            }
            if (!z2) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            }
            sb.append("id:");
            String str2 = this.f588b;
            if (str2 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str2);
            }
            if (d()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("appId:");
                String str3 = this.f589c;
                if (str3 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str3);
                }
            }
            if (e()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("type:");
                String str4 = this.f590d;
                if (str4 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str4);
                }
            }
            if (f()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("errorCode:");
                sb.append(this.f583a);
            }
            if (g()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("reason:");
                String str5 = this.f591e;
                if (str5 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str5);
                }
            }
            if (h()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("extra:");
                Map<String, String> map = this.f587a;
                if (map == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(map);
                }
            }
            if (i()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("packageName:");
                String str6 = this.f592f;
                if (str6 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str6);
                }
            }
            if (j()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("category:");
                String str7 = this.f593g;
                if (str7 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str7);
                }
            }
            sb.append(SmallTailInfo.EMOTION_SUFFIX);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
