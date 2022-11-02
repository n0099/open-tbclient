package com.xiaomi.push;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
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
/* loaded from: classes8.dex */
public class io implements iu<io, Object>, Serializable, Cloneable {
    public static /* synthetic */ Interceptable $ic;
    public static final jc a;

    /* renamed from: a  reason: collision with other field name */
    public static final jk f741a;
    public static final jc b;
    public static final jc c;
    public static final jc d;
    public static final jc e;
    public static final jc f;
    public static final jc g;
    public static final jc h;
    public static final jc i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public long f742a;

    /* renamed from: a  reason: collision with other field name */
    public hy f743a;

    /* renamed from: a  reason: collision with other field name */
    public String f744a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f745a;

    /* renamed from: b  reason: collision with other field name */
    public String f746b;

    /* renamed from: c  reason: collision with other field name */
    public String f747c;

    /* renamed from: d  reason: collision with other field name */
    public String f748d;

    /* renamed from: e  reason: collision with other field name */
    public String f749e;

    /* renamed from: f  reason: collision with other field name */
    public String f750f;

    /* renamed from: g  reason: collision with other field name */
    public String f751g;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-56371750, "Lcom/xiaomi/push/io;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-56371750, "Lcom/xiaomi/push/io;");
                return;
            }
        }
        f741a = new jk("XmPushActionSubscriptionResult");
        a = new jc("", Constants.GZIP_CAST_TYPE, (short) 1);
        b = new jc("", (byte) 12, (short) 2);
        c = new jc("", Constants.GZIP_CAST_TYPE, (short) 3);
        d = new jc("", Constants.GZIP_CAST_TYPE, (short) 4);
        e = new jc("", (byte) 10, (short) 6);
        f = new jc("", Constants.GZIP_CAST_TYPE, (short) 7);
        g = new jc("", Constants.GZIP_CAST_TYPE, (short) 8);
        h = new jc("", Constants.GZIP_CAST_TYPE, (short) 9);
        i = new jc("", Constants.GZIP_CAST_TYPE, (short) 10);
    }

    public io() {
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
        this.f745a = new BitSet(1);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(io ioVar) {
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
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, ioVar)) == null) {
            if (io.class.equals(ioVar.getClass())) {
                int compareTo = Boolean.valueOf(m515a()).compareTo(Boolean.valueOf(ioVar.m515a()));
                if (compareTo != 0) {
                    return compareTo;
                }
                if (!m515a() || (a10 = iv.a(this.f744a, ioVar.f744a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m517b()).compareTo(Boolean.valueOf(ioVar.m517b()));
                    if (compareTo2 != 0) {
                        return compareTo2;
                    }
                    if (!m517b() || (a9 = iv.a(this.f743a, ioVar.f743a)) == 0) {
                        int compareTo3 = Boolean.valueOf(m518c()).compareTo(Boolean.valueOf(ioVar.m518c()));
                        if (compareTo3 != 0) {
                            return compareTo3;
                        }
                        if (!m518c() || (a8 = iv.a(this.f746b, ioVar.f746b)) == 0) {
                            int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(ioVar.d()));
                            if (compareTo4 != 0) {
                                return compareTo4;
                            }
                            if (!d() || (a7 = iv.a(this.f747c, ioVar.f747c)) == 0) {
                                int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(ioVar.e()));
                                if (compareTo5 != 0) {
                                    return compareTo5;
                                }
                                if (!e() || (a6 = iv.a(this.f742a, ioVar.f742a)) == 0) {
                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(ioVar.f()));
                                    if (compareTo6 != 0) {
                                        return compareTo6;
                                    }
                                    if (!f() || (a5 = iv.a(this.f748d, ioVar.f748d)) == 0) {
                                        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ioVar.g()));
                                        if (compareTo7 != 0) {
                                            return compareTo7;
                                        }
                                        if (!g() || (a4 = iv.a(this.f749e, ioVar.f749e)) == 0) {
                                            int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(ioVar.h()));
                                            if (compareTo8 != 0) {
                                                return compareTo8;
                                            }
                                            if (!h() || (a3 = iv.a(this.f750f, ioVar.f750f)) == 0) {
                                                int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(ioVar.i()));
                                                if (compareTo9 != 0) {
                                                    return compareTo9;
                                                }
                                                if (!i() || (a2 = iv.a(this.f751g, ioVar.f751g)) == 0) {
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
            return io.class.getName().compareTo(ioVar.getClass().getName());
        }
        return invokeL.intValue;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f746b : (String) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m514a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.f746b == null) {
            throw new jg("Required field 'id' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.iu
    public void a(jf jfVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(1048579, this, jfVar) != null) {
            return;
        }
        jfVar.m549a();
        while (true) {
            jc m545a = jfVar.m545a();
            byte b2 = m545a.a;
            if (b2 == 0) {
                jfVar.f();
                m514a();
                return;
            }
            switch (m545a.f810a) {
                case 1:
                    if (b2 == 11) {
                        this.f744a = jfVar.m550a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 2:
                    if (b2 == 12) {
                        hy hyVar = new hy();
                        this.f743a = hyVar;
                        hyVar.a(jfVar);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f746b = jfVar.m550a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f747c = jfVar.m550a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 6:
                    if (b2 == 10) {
                        this.f742a = jfVar.m544a();
                        a(true);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f748d = jfVar.m550a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 8:
                    if (b2 == 11) {
                        this.f749e = jfVar.m550a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 9:
                    if (b2 == 11) {
                        this.f750f = jfVar.m550a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 10:
                    if (b2 == 11) {
                        this.f751g = jfVar.m550a();
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
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.f745a.set(0, z);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m515a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f744a != null : invokeV.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m516a(io ioVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, ioVar)) == null) {
            if (ioVar == null) {
                return false;
            }
            boolean m515a = m515a();
            boolean m515a2 = ioVar.m515a();
            if ((m515a || m515a2) && !(m515a && m515a2 && this.f744a.equals(ioVar.f744a))) {
                return false;
            }
            boolean m517b = m517b();
            boolean m517b2 = ioVar.m517b();
            if ((m517b || m517b2) && !(m517b && m517b2 && this.f743a.m443a(ioVar.f743a))) {
                return false;
            }
            boolean m518c = m518c();
            boolean m518c2 = ioVar.m518c();
            if ((m518c || m518c2) && !(m518c && m518c2 && this.f746b.equals(ioVar.f746b))) {
                return false;
            }
            boolean d2 = d();
            boolean d3 = ioVar.d();
            if ((d2 || d3) && !(d2 && d3 && this.f747c.equals(ioVar.f747c))) {
                return false;
            }
            boolean e2 = e();
            boolean e3 = ioVar.e();
            if ((e2 || e3) && !(e2 && e3 && this.f742a == ioVar.f742a)) {
                return false;
            }
            boolean f2 = f();
            boolean f3 = ioVar.f();
            if ((f2 || f3) && !(f2 && f3 && this.f748d.equals(ioVar.f748d))) {
                return false;
            }
            boolean g2 = g();
            boolean g3 = ioVar.g();
            if ((g2 || g3) && !(g2 && g3 && this.f749e.equals(ioVar.f749e))) {
                return false;
            }
            boolean h2 = h();
            boolean h3 = ioVar.h();
            if ((h2 || h3) && !(h2 && h3 && this.f750f.equals(ioVar.f750f))) {
                return false;
            }
            boolean i2 = i();
            boolean i3 = ioVar.i();
            if (i2 || i3) {
                return i2 && i3 && this.f751g.equals(ioVar.f751g);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f749e : (String) invokeV.objValue;
    }

    @Override // com.xiaomi.push.iu
    public void b(jf jfVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jfVar) == null) {
            m514a();
            jfVar.a(f741a);
            if (this.f744a != null && m515a()) {
                jfVar.a(a);
                jfVar.a(this.f744a);
                jfVar.b();
            }
            if (this.f743a != null && m517b()) {
                jfVar.a(b);
                this.f743a.b(jfVar);
                jfVar.b();
            }
            if (this.f746b != null) {
                jfVar.a(c);
                jfVar.a(this.f746b);
                jfVar.b();
            }
            if (this.f747c != null && d()) {
                jfVar.a(d);
                jfVar.a(this.f747c);
                jfVar.b();
            }
            if (e()) {
                jfVar.a(e);
                jfVar.a(this.f742a);
                jfVar.b();
            }
            if (this.f748d != null && f()) {
                jfVar.a(f);
                jfVar.a(this.f748d);
                jfVar.b();
            }
            if (this.f749e != null && g()) {
                jfVar.a(g);
                jfVar.a(this.f749e);
                jfVar.b();
            }
            if (this.f750f != null && h()) {
                jfVar.a(h);
                jfVar.a(this.f750f);
                jfVar.b();
            }
            if (this.f751g != null && i()) {
                jfVar.a(i);
                jfVar.a(this.f751g);
                jfVar.b();
            }
            jfVar.c();
            jfVar.m553a();
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m517b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f743a != null : invokeV.booleanValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f751g : (String) invokeV.objValue;
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m518c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f746b != null : invokeV.booleanValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f747c != null : invokeV.booleanValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f745a.get(0) : invokeV.booleanValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, obj)) == null) {
            if (obj != null && (obj instanceof io)) {
                return m516a((io) obj);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f748d != null : invokeV.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.f749e != null : invokeV.booleanValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f750f != null : invokeV.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f751g != null : invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            StringBuilder sb = new StringBuilder("XmPushActionSubscriptionResult(");
            boolean z2 = false;
            if (m515a()) {
                sb.append("debug:");
                String str = this.f744a;
                if (str == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str);
                }
                z = false;
            } else {
                z = true;
            }
            if (m517b()) {
                if (!z) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                }
                sb.append("target:");
                hy hyVar = this.f743a;
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
            String str2 = this.f746b;
            if (str2 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str2);
            }
            if (d()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("appId:");
                String str3 = this.f747c;
                if (str3 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str3);
                }
            }
            if (e()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("errorCode:");
                sb.append(this.f742a);
            }
            if (f()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("reason:");
                String str4 = this.f748d;
                if (str4 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str4);
                }
            }
            if (g()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append(UrlSchemaHelper.SCHEMA_TYPE_TOPIC);
                String str5 = this.f749e;
                if (str5 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str5);
                }
            }
            if (h()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("packageName:");
                String str6 = this.f750f;
                if (str6 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str6);
                }
            }
            if (i()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("category:");
                String str7 = this.f751g;
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
