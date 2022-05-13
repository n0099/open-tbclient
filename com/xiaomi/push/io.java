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
public class io implements iq<io, Object>, Serializable, Cloneable {
    public static /* synthetic */ Interceptable $ic;
    public static final iy a;

    /* renamed from: a  reason: collision with other field name */
    public static final jg f770a;
    public static final iy b;
    public static final iy c;
    public static final iy d;
    public static final iy e;
    public static final iy f;
    public static final iy g;
    public static final iy h;
    public static final iy i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public long f771a;

    /* renamed from: a  reason: collision with other field name */
    public hu f772a;

    /* renamed from: a  reason: collision with other field name */
    public String f773a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f774a;

    /* renamed from: b  reason: collision with other field name */
    public String f775b;

    /* renamed from: c  reason: collision with other field name */
    public String f776c;

    /* renamed from: d  reason: collision with other field name */
    public String f777d;

    /* renamed from: e  reason: collision with other field name */
    public String f778e;

    /* renamed from: f  reason: collision with other field name */
    public String f779f;

    /* renamed from: g  reason: collision with other field name */
    public String f780g;

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
        f770a = new jg("XmPushActionUnSubscriptionResult");
        a = new iy("", Constants.GZIP_CAST_TYPE, (short) 1);
        b = new iy("", (byte) 12, (short) 2);
        c = new iy("", Constants.GZIP_CAST_TYPE, (short) 3);
        d = new iy("", Constants.GZIP_CAST_TYPE, (short) 4);
        e = new iy("", (byte) 10, (short) 6);
        f = new iy("", Constants.GZIP_CAST_TYPE, (short) 7);
        g = new iy("", Constants.GZIP_CAST_TYPE, (short) 8);
        h = new iy("", Constants.GZIP_CAST_TYPE, (short) 9);
        i = new iy("", Constants.GZIP_CAST_TYPE, (short) 10);
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
        this.f774a = new BitSet(1);
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
                int compareTo = Boolean.valueOf(m549a()).compareTo(Boolean.valueOf(ioVar.m549a()));
                if (compareTo != 0) {
                    return compareTo;
                }
                if (!m549a() || (a10 = ir.a(this.f773a, ioVar.f773a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m551b()).compareTo(Boolean.valueOf(ioVar.m551b()));
                    if (compareTo2 != 0) {
                        return compareTo2;
                    }
                    if (!m551b() || (a9 = ir.a(this.f772a, ioVar.f772a)) == 0) {
                        int compareTo3 = Boolean.valueOf(m552c()).compareTo(Boolean.valueOf(ioVar.m552c()));
                        if (compareTo3 != 0) {
                            return compareTo3;
                        }
                        if (!m552c() || (a8 = ir.a(this.f775b, ioVar.f775b)) == 0) {
                            int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(ioVar.d()));
                            if (compareTo4 != 0) {
                                return compareTo4;
                            }
                            if (!d() || (a7 = ir.a(this.f776c, ioVar.f776c)) == 0) {
                                int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(ioVar.e()));
                                if (compareTo5 != 0) {
                                    return compareTo5;
                                }
                                if (!e() || (a6 = ir.a(this.f771a, ioVar.f771a)) == 0) {
                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(ioVar.f()));
                                    if (compareTo6 != 0) {
                                        return compareTo6;
                                    }
                                    if (!f() || (a5 = ir.a(this.f777d, ioVar.f777d)) == 0) {
                                        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ioVar.g()));
                                        if (compareTo7 != 0) {
                                            return compareTo7;
                                        }
                                        if (!g() || (a4 = ir.a(this.f778e, ioVar.f778e)) == 0) {
                                            int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(ioVar.h()));
                                            if (compareTo8 != 0) {
                                                return compareTo8;
                                            }
                                            if (!h() || (a3 = ir.a(this.f779f, ioVar.f779f)) == 0) {
                                                int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(ioVar.i()));
                                                if (compareTo9 != 0) {
                                                    return compareTo9;
                                                }
                                                if (!i() || (a2 = ir.a(this.f780g, ioVar.f780g)) == 0) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f775b : (String) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m548a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.f775b == null) {
            throw new jc("Required field 'id' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.iq
    public void a(jb jbVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(1048579, this, jbVar) != null) {
            return;
        }
        jbVar.m563a();
        while (true) {
            iy m559a = jbVar.m559a();
            byte b2 = m559a.a;
            if (b2 == 0) {
                jbVar.f();
                m548a();
                return;
            }
            switch (m559a.f791a) {
                case 1:
                    if (b2 == 11) {
                        this.f773a = jbVar.m564a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 2:
                    if (b2 == 12) {
                        hu huVar = new hu();
                        this.f772a = huVar;
                        huVar.a(jbVar);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f775b = jbVar.m564a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f776c = jbVar.m564a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 6:
                    if (b2 == 10) {
                        this.f771a = jbVar.m558a();
                        a(true);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f777d = jbVar.m564a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 8:
                    if (b2 == 11) {
                        this.f778e = jbVar.m564a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 9:
                    if (b2 == 11) {
                        this.f779f = jbVar.m564a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 10:
                    if (b2 == 11) {
                        this.f780g = jbVar.m564a();
                        continue;
                        jbVar.g();
                    }
                    break;
            }
            je.a(jbVar, b2);
            jbVar.g();
        }
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.f774a.set(0, z);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m549a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f773a != null : invokeV.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m550a(io ioVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, ioVar)) == null) {
            if (ioVar == null) {
                return false;
            }
            boolean m549a = m549a();
            boolean m549a2 = ioVar.m549a();
            if ((m549a || m549a2) && !(m549a && m549a2 && this.f773a.equals(ioVar.f773a))) {
                return false;
            }
            boolean m551b = m551b();
            boolean m551b2 = ioVar.m551b();
            if ((m551b || m551b2) && !(m551b && m551b2 && this.f772a.m458a(ioVar.f772a))) {
                return false;
            }
            boolean m552c = m552c();
            boolean m552c2 = ioVar.m552c();
            if ((m552c || m552c2) && !(m552c && m552c2 && this.f775b.equals(ioVar.f775b))) {
                return false;
            }
            boolean d2 = d();
            boolean d3 = ioVar.d();
            if ((d2 || d3) && !(d2 && d3 && this.f776c.equals(ioVar.f776c))) {
                return false;
            }
            boolean e2 = e();
            boolean e3 = ioVar.e();
            if ((e2 || e3) && !(e2 && e3 && this.f771a == ioVar.f771a)) {
                return false;
            }
            boolean f2 = f();
            boolean f3 = ioVar.f();
            if ((f2 || f3) && !(f2 && f3 && this.f777d.equals(ioVar.f777d))) {
                return false;
            }
            boolean g2 = g();
            boolean g3 = ioVar.g();
            if ((g2 || g3) && !(g2 && g3 && this.f778e.equals(ioVar.f778e))) {
                return false;
            }
            boolean h2 = h();
            boolean h3 = ioVar.h();
            if ((h2 || h3) && !(h2 && h3 && this.f779f.equals(ioVar.f779f))) {
                return false;
            }
            boolean i2 = i();
            boolean i3 = ioVar.i();
            if (i2 || i3) {
                return i2 && i3 && this.f780g.equals(ioVar.f780g);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f778e : (String) invokeV.objValue;
    }

    @Override // com.xiaomi.push.iq
    public void b(jb jbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jbVar) == null) {
            m548a();
            jbVar.a(f770a);
            if (this.f773a != null && m549a()) {
                jbVar.a(a);
                jbVar.a(this.f773a);
                jbVar.b();
            }
            if (this.f772a != null && m551b()) {
                jbVar.a(b);
                this.f772a.b(jbVar);
                jbVar.b();
            }
            if (this.f775b != null) {
                jbVar.a(c);
                jbVar.a(this.f775b);
                jbVar.b();
            }
            if (this.f776c != null && d()) {
                jbVar.a(d);
                jbVar.a(this.f776c);
                jbVar.b();
            }
            if (e()) {
                jbVar.a(e);
                jbVar.a(this.f771a);
                jbVar.b();
            }
            if (this.f777d != null && f()) {
                jbVar.a(f);
                jbVar.a(this.f777d);
                jbVar.b();
            }
            if (this.f778e != null && g()) {
                jbVar.a(g);
                jbVar.a(this.f778e);
                jbVar.b();
            }
            if (this.f779f != null && h()) {
                jbVar.a(h);
                jbVar.a(this.f779f);
                jbVar.b();
            }
            if (this.f780g != null && i()) {
                jbVar.a(i);
                jbVar.a(this.f780g);
                jbVar.b();
            }
            jbVar.c();
            jbVar.m567a();
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m551b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f772a != null : invokeV.booleanValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f780g : (String) invokeV.objValue;
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m552c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f775b != null : invokeV.booleanValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f776c != null : invokeV.booleanValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f774a.get(0) : invokeV.booleanValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, obj)) == null) {
            if (obj != null && (obj instanceof io)) {
                return m550a((io) obj);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f777d != null : invokeV.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.f778e != null : invokeV.booleanValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f779f != null : invokeV.booleanValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f780g != null : invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            StringBuilder sb = new StringBuilder("XmPushActionUnSubscriptionResult(");
            boolean z2 = false;
            if (m549a()) {
                sb.append("debug:");
                String str = this.f773a;
                if (str == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str);
                }
                z = false;
            } else {
                z = true;
            }
            if (m551b()) {
                if (!z) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                }
                sb.append("target:");
                hu huVar = this.f772a;
                if (huVar == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(huVar);
                }
            } else {
                z2 = z;
            }
            if (!z2) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            }
            sb.append("id:");
            String str2 = this.f775b;
            if (str2 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str2);
            }
            if (d()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("appId:");
                String str3 = this.f776c;
                if (str3 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str3);
                }
            }
            if (e()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("errorCode:");
                sb.append(this.f771a);
            }
            if (f()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("reason:");
                String str4 = this.f777d;
                if (str4 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str4);
                }
            }
            if (g()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append(UrlSchemaHelper.SCHEMA_TYPE_TOPIC);
                String str5 = this.f778e;
                if (str5 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str5);
                }
            }
            if (h()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("packageName:");
                String str6 = this.f779f;
                if (str6 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str6);
                }
            }
            if (i()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("category:");
                String str7 = this.f780g;
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
