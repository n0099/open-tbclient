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
public class im implements iq<im, Object>, Serializable, Cloneable {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final iy f71289a;

    /* renamed from: a  reason: collision with other field name */
    public static final jg f774a;

    /* renamed from: b  reason: collision with root package name */
    public static final iy f71290b;

    /* renamed from: c  reason: collision with root package name */
    public static final iy f71291c;

    /* renamed from: d  reason: collision with root package name */
    public static final iy f71292d;

    /* renamed from: e  reason: collision with root package name */
    public static final iy f71293e;

    /* renamed from: f  reason: collision with root package name */
    public static final iy f71294f;

    /* renamed from: g  reason: collision with root package name */
    public static final iy f71295g;

    /* renamed from: h  reason: collision with root package name */
    public static final iy f71296h;

    /* renamed from: i  reason: collision with root package name */
    public static final iy f71297i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public long f775a;

    /* renamed from: a  reason: collision with other field name */
    public hu f776a;

    /* renamed from: a  reason: collision with other field name */
    public String f777a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f778a;

    /* renamed from: b  reason: collision with other field name */
    public long f779b;

    /* renamed from: b  reason: collision with other field name */
    public String f780b;

    /* renamed from: c  reason: collision with other field name */
    public long f781c;

    /* renamed from: c  reason: collision with other field name */
    public String f782c;

    /* renamed from: d  reason: collision with other field name */
    public String f783d;

    /* renamed from: e  reason: collision with other field name */
    public String f784e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-56371812, "Lcom/xiaomi/push/im;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-56371812, "Lcom/xiaomi/push/im;");
                return;
            }
        }
        f774a = new jg("XmPushActionUnRegistrationResult");
        f71289a = new iy("", (byte) 11, (short) 1);
        f71290b = new iy("", StandardMessageCodec.LIST, (short) 2);
        f71291c = new iy("", (byte) 11, (short) 3);
        f71292d = new iy("", (byte) 11, (short) 4);
        f71293e = new iy("", (byte) 10, (short) 6);
        f71294f = new iy("", (byte) 11, (short) 7);
        f71295g = new iy("", (byte) 11, (short) 8);
        f71296h = new iy("", (byte) 10, (short) 9);
        f71297i = new iy("", (byte) 10, (short) 10);
    }

    public im() {
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
        this.f778a = new BitSet(3);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(im imVar) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, imVar)) == null) {
            if (im.class.equals(imVar.getClass())) {
                int compareTo = Boolean.valueOf(m508a()).compareTo(Boolean.valueOf(imVar.m508a()));
                if (compareTo != 0) {
                    return compareTo;
                }
                if (!m508a() || (a10 = ir.a(this.f777a, imVar.f777a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(imVar.b()));
                    if (compareTo2 != 0) {
                        return compareTo2;
                    }
                    if (!b() || (a9 = ir.a(this.f776a, imVar.f776a)) == 0) {
                        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(imVar.c()));
                        if (compareTo3 != 0) {
                            return compareTo3;
                        }
                        if (!c() || (a8 = ir.a(this.f780b, imVar.f780b)) == 0) {
                            int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(imVar.d()));
                            if (compareTo4 != 0) {
                                return compareTo4;
                            }
                            if (!d() || (a7 = ir.a(this.f782c, imVar.f782c)) == 0) {
                                int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(imVar.e()));
                                if (compareTo5 != 0) {
                                    return compareTo5;
                                }
                                if (!e() || (a6 = ir.a(this.f775a, imVar.f775a)) == 0) {
                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(imVar.f()));
                                    if (compareTo6 != 0) {
                                        return compareTo6;
                                    }
                                    if (!f() || (a5 = ir.a(this.f783d, imVar.f783d)) == 0) {
                                        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(imVar.g()));
                                        if (compareTo7 != 0) {
                                            return compareTo7;
                                        }
                                        if (!g() || (a4 = ir.a(this.f784e, imVar.f784e)) == 0) {
                                            int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(imVar.h()));
                                            if (compareTo8 != 0) {
                                                return compareTo8;
                                            }
                                            if (!h() || (a3 = ir.a(this.f779b, imVar.f779b)) == 0) {
                                                int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(imVar.i()));
                                                if (compareTo9 != 0) {
                                                    return compareTo9;
                                                }
                                                if (!i() || (a2 = ir.a(this.f781c, imVar.f781c)) == 0) {
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
            return im.class.getName().compareTo(imVar.getClass().getName());
        }
        return invokeL.intValue;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f784e : (String) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m507a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (this.f780b == null) {
                throw new jc("Required field 'id' was not present! Struct: " + toString());
            } else if (this.f782c != null) {
            } else {
                throw new jc("Required field 'appId' was not present! Struct: " + toString());
            }
        }
    }

    @Override // com.xiaomi.push.iq
    public void a(jb jbVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(1048579, this, jbVar) != null) {
            return;
        }
        jbVar.m527a();
        while (true) {
            iy m523a = jbVar.m523a();
            byte b2 = m523a.f71328a;
            if (b2 == 0) {
                jbVar.f();
                if (e()) {
                    m507a();
                    return;
                }
                throw new jc("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
            }
            switch (m523a.f815a) {
                case 1:
                    if (b2 == 11) {
                        this.f777a = jbVar.m528a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 2:
                    if (b2 == 12) {
                        hu huVar = new hu();
                        this.f776a = huVar;
                        huVar.a(jbVar);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f780b = jbVar.m528a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f782c = jbVar.m528a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 6:
                    if (b2 == 10) {
                        this.f775a = jbVar.m522a();
                        a(true);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f783d = jbVar.m528a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 8:
                    if (b2 == 11) {
                        this.f784e = jbVar.m528a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 9:
                    if (b2 == 10) {
                        this.f779b = jbVar.m522a();
                        b(true);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 10:
                    if (b2 == 10) {
                        this.f781c = jbVar.m522a();
                        c(true);
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
            this.f778a.set(0, z);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m508a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f777a != null : invokeV.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m509a(im imVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, imVar)) == null) {
            if (imVar == null) {
                return false;
            }
            boolean m508a = m508a();
            boolean m508a2 = imVar.m508a();
            if ((m508a || m508a2) && !(m508a && m508a2 && this.f777a.equals(imVar.f777a))) {
                return false;
            }
            boolean b2 = b();
            boolean b3 = imVar.b();
            if ((b2 || b3) && !(b2 && b3 && this.f776a.m422a(imVar.f776a))) {
                return false;
            }
            boolean c2 = c();
            boolean c3 = imVar.c();
            if ((c2 || c3) && !(c2 && c3 && this.f780b.equals(imVar.f780b))) {
                return false;
            }
            boolean d2 = d();
            boolean d3 = imVar.d();
            if (((d2 || d3) && !(d2 && d3 && this.f782c.equals(imVar.f782c))) || this.f775a != imVar.f775a) {
                return false;
            }
            boolean f2 = f();
            boolean f3 = imVar.f();
            if ((f2 || f3) && !(f2 && f3 && this.f783d.equals(imVar.f783d))) {
                return false;
            }
            boolean g2 = g();
            boolean g3 = imVar.g();
            if ((g2 || g3) && !(g2 && g3 && this.f784e.equals(imVar.f784e))) {
                return false;
            }
            boolean h2 = h();
            boolean h3 = imVar.h();
            if ((h2 || h3) && !(h2 && h3 && this.f779b == imVar.f779b)) {
                return false;
            }
            boolean i2 = i();
            boolean i3 = imVar.i();
            if (i2 || i3) {
                return i2 && i3 && this.f781c == imVar.f781c;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.xiaomi.push.iq
    public void b(jb jbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, jbVar) == null) {
            m507a();
            jbVar.a(f774a);
            if (this.f777a != null && m508a()) {
                jbVar.a(f71289a);
                jbVar.a(this.f777a);
                jbVar.b();
            }
            if (this.f776a != null && b()) {
                jbVar.a(f71290b);
                this.f776a.b(jbVar);
                jbVar.b();
            }
            if (this.f780b != null) {
                jbVar.a(f71291c);
                jbVar.a(this.f780b);
                jbVar.b();
            }
            if (this.f782c != null) {
                jbVar.a(f71292d);
                jbVar.a(this.f782c);
                jbVar.b();
            }
            jbVar.a(f71293e);
            jbVar.a(this.f775a);
            jbVar.b();
            if (this.f783d != null && f()) {
                jbVar.a(f71294f);
                jbVar.a(this.f783d);
                jbVar.b();
            }
            if (this.f784e != null && g()) {
                jbVar.a(f71295g);
                jbVar.a(this.f784e);
                jbVar.b();
            }
            if (h()) {
                jbVar.a(f71296h);
                jbVar.a(this.f779b);
                jbVar.b();
            }
            if (i()) {
                jbVar.a(f71297i);
                jbVar.a(this.f781c);
                jbVar.b();
            }
            jbVar.c();
            jbVar.m531a();
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.f778a.set(1, z);
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f776a != null : invokeV.booleanValue;
    }

    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.f778a.set(2, z);
        }
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f780b != null : invokeV.booleanValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f782c != null : invokeV.booleanValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f778a.get(0) : invokeV.booleanValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, obj)) == null) {
            if (obj != null && (obj instanceof im)) {
                return m509a((im) obj);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f783d != null : invokeV.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.f784e != null : invokeV.booleanValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f778a.get(1) : invokeV.booleanValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f778a.get(2) : invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            StringBuilder sb = new StringBuilder("XmPushActionUnRegistrationResult(");
            boolean z2 = false;
            if (m508a()) {
                sb.append("debug:");
                String str = this.f777a;
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
                hu huVar = this.f776a;
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
            String str2 = this.f780b;
            if (str2 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str2);
            }
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("appId:");
            String str3 = this.f782c;
            if (str3 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str3);
            }
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("errorCode:");
            sb.append(this.f775a);
            if (f()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("reason:");
                String str4 = this.f783d;
                if (str4 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str4);
                }
            }
            if (g()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("packageName:");
                String str5 = this.f784e;
                if (str5 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str5);
                }
            }
            if (h()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("unRegisteredAt:");
                sb.append(this.f779b);
            }
            if (i()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("costTime:");
                sb.append(this.f781c);
            }
            sb.append(SmallTailInfo.EMOTION_SUFFIX);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
