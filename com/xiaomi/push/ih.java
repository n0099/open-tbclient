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
/* loaded from: classes2.dex */
public class ih implements iq<ih, Object>, Serializable, Cloneable {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final iy f71248a;

    /* renamed from: a  reason: collision with other field name */
    public static final jg f717a;

    /* renamed from: b  reason: collision with root package name */
    public static final iy f71249b;

    /* renamed from: c  reason: collision with root package name */
    public static final iy f71250c;

    /* renamed from: d  reason: collision with root package name */
    public static final iy f71251d;

    /* renamed from: e  reason: collision with root package name */
    public static final iy f71252e;

    /* renamed from: f  reason: collision with root package name */
    public static final iy f71253f;

    /* renamed from: g  reason: collision with root package name */
    public static final iy f71254g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public long f718a;

    /* renamed from: a  reason: collision with other field name */
    public hu f719a;

    /* renamed from: a  reason: collision with other field name */
    public String f720a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f721a;

    /* renamed from: b  reason: collision with other field name */
    public String f722b;

    /* renamed from: c  reason: collision with other field name */
    public String f723c;

    /* renamed from: d  reason: collision with other field name */
    public String f724d;

    /* renamed from: e  reason: collision with other field name */
    public String f725e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-56371967, "Lcom/xiaomi/push/ih;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-56371967, "Lcom/xiaomi/push/ih;");
                return;
            }
        }
        f717a = new jg("XmPushActionSendFeedbackResult");
        f71248a = new iy("", (byte) 11, (short) 1);
        f71249b = new iy("", StandardMessageCodec.LIST, (short) 2);
        f71250c = new iy("", (byte) 11, (short) 3);
        f71251d = new iy("", (byte) 11, (short) 4);
        f71252e = new iy("", (byte) 10, (short) 6);
        f71253f = new iy("", (byte) 11, (short) 7);
        f71254g = new iy("", (byte) 11, (short) 8);
    }

    public ih() {
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
        this.f721a = new BitSet(1);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(ih ihVar) {
        InterceptResult invokeL;
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        int a8;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, ihVar)) == null) {
            if (ih.class.equals(ihVar.getClass())) {
                int compareTo = Boolean.valueOf(m487a()).compareTo(Boolean.valueOf(ihVar.m487a()));
                if (compareTo != 0) {
                    return compareTo;
                }
                if (!m487a() || (a8 = ir.a(this.f720a, ihVar.f720a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(ihVar.b()));
                    if (compareTo2 != 0) {
                        return compareTo2;
                    }
                    if (!b() || (a7 = ir.a(this.f719a, ihVar.f719a)) == 0) {
                        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(ihVar.c()));
                        if (compareTo3 != 0) {
                            return compareTo3;
                        }
                        if (!c() || (a6 = ir.a(this.f722b, ihVar.f722b)) == 0) {
                            int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(ihVar.d()));
                            if (compareTo4 != 0) {
                                return compareTo4;
                            }
                            if (!d() || (a5 = ir.a(this.f723c, ihVar.f723c)) == 0) {
                                int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(ihVar.e()));
                                if (compareTo5 != 0) {
                                    return compareTo5;
                                }
                                if (!e() || (a4 = ir.a(this.f718a, ihVar.f718a)) == 0) {
                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(ihVar.f()));
                                    if (compareTo6 != 0) {
                                        return compareTo6;
                                    }
                                    if (!f() || (a3 = ir.a(this.f724d, ihVar.f724d)) == 0) {
                                        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ihVar.g()));
                                        if (compareTo7 != 0) {
                                            return compareTo7;
                                        }
                                        if (!g() || (a2 = ir.a(this.f725e, ihVar.f725e)) == 0) {
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
            return ih.class.getName().compareTo(ihVar.getClass().getName());
        }
        return invokeL.intValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.f722b == null) {
                throw new jc("Required field 'id' was not present! Struct: " + toString());
            } else if (this.f723c != null) {
            } else {
                throw new jc("Required field 'appId' was not present! Struct: " + toString());
            }
        }
    }

    @Override // com.xiaomi.push.iq
    public void a(jb jbVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jbVar) != null) {
            return;
        }
        jbVar.m527a();
        while (true) {
            iy m523a = jbVar.m523a();
            byte b2 = m523a.f71329a;
            if (b2 == 0) {
                jbVar.f();
                if (e()) {
                    a();
                    return;
                }
                throw new jc("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
            }
            switch (m523a.f815a) {
                case 1:
                    if (b2 == 11) {
                        this.f720a = jbVar.m528a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 2:
                    if (b2 == 12) {
                        hu huVar = new hu();
                        this.f719a = huVar;
                        huVar.a(jbVar);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f722b = jbVar.m528a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f723c = jbVar.m528a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 6:
                    if (b2 == 10) {
                        this.f718a = jbVar.m522a();
                        a(true);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f724d = jbVar.m528a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 8:
                    if (b2 == 11) {
                        this.f725e = jbVar.m528a();
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
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.f721a.set(0, z);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m487a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f720a != null : invokeV.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m488a(ih ihVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, ihVar)) == null) {
            if (ihVar == null) {
                return false;
            }
            boolean m487a = m487a();
            boolean m487a2 = ihVar.m487a();
            if ((m487a || m487a2) && !(m487a && m487a2 && this.f720a.equals(ihVar.f720a))) {
                return false;
            }
            boolean b2 = b();
            boolean b3 = ihVar.b();
            if ((b2 || b3) && !(b2 && b3 && this.f719a.m422a(ihVar.f719a))) {
                return false;
            }
            boolean c2 = c();
            boolean c3 = ihVar.c();
            if ((c2 || c3) && !(c2 && c3 && this.f722b.equals(ihVar.f722b))) {
                return false;
            }
            boolean d2 = d();
            boolean d3 = ihVar.d();
            if (((d2 || d3) && !(d2 && d3 && this.f723c.equals(ihVar.f723c))) || this.f718a != ihVar.f718a) {
                return false;
            }
            boolean f2 = f();
            boolean f3 = ihVar.f();
            if ((f2 || f3) && !(f2 && f3 && this.f724d.equals(ihVar.f724d))) {
                return false;
            }
            boolean g2 = g();
            boolean g3 = ihVar.g();
            if (g2 || g3) {
                return g2 && g3 && this.f725e.equals(ihVar.f725e);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.xiaomi.push.iq
    public void b(jb jbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, jbVar) == null) {
            a();
            jbVar.a(f717a);
            if (this.f720a != null && m487a()) {
                jbVar.a(f71248a);
                jbVar.a(this.f720a);
                jbVar.b();
            }
            if (this.f719a != null && b()) {
                jbVar.a(f71249b);
                this.f719a.b(jbVar);
                jbVar.b();
            }
            if (this.f722b != null) {
                jbVar.a(f71250c);
                jbVar.a(this.f722b);
                jbVar.b();
            }
            if (this.f723c != null) {
                jbVar.a(f71251d);
                jbVar.a(this.f723c);
                jbVar.b();
            }
            jbVar.a(f71252e);
            jbVar.a(this.f718a);
            jbVar.b();
            if (this.f724d != null && f()) {
                jbVar.a(f71253f);
                jbVar.a(this.f724d);
                jbVar.b();
            }
            if (this.f725e != null && g()) {
                jbVar.a(f71254g);
                jbVar.a(this.f725e);
                jbVar.b();
            }
            jbVar.c();
            jbVar.m531a();
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f719a != null : invokeV.booleanValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f722b != null : invokeV.booleanValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f723c != null : invokeV.booleanValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f721a.get(0) : invokeV.booleanValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, obj)) == null) {
            if (obj != null && (obj instanceof ih)) {
                return m488a((ih) obj);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f724d != null : invokeV.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f725e != null : invokeV.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            StringBuilder sb = new StringBuilder("XmPushActionSendFeedbackResult(");
            boolean z2 = false;
            if (m487a()) {
                sb.append("debug:");
                String str = this.f720a;
                if (str == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str);
                }
                z = false;
            } else {
                z = true;
            }
            if (b()) {
                if (!z) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                }
                sb.append("target:");
                hu huVar = this.f719a;
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
            String str2 = this.f722b;
            if (str2 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str2);
            }
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("appId:");
            String str3 = this.f723c;
            if (str3 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str3);
            }
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("errorCode:");
            sb.append(this.f718a);
            if (f()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("reason:");
                String str4 = this.f724d;
                if (str4 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str4);
                }
            }
            if (g()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("category:");
                String str5 = this.f725e;
                if (str5 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str5);
                }
            }
            sb.append(SmallTailInfo.EMOTION_SUFFIX);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
