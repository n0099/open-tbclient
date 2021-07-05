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
/* loaded from: classes8.dex */
public class im implements iq<im, Object>, Serializable, Cloneable {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final iy f43455a;

    /* renamed from: a  reason: collision with other field name */
    public static final jg f769a;

    /* renamed from: b  reason: collision with root package name */
    public static final iy f43456b;

    /* renamed from: c  reason: collision with root package name */
    public static final iy f43457c;

    /* renamed from: d  reason: collision with root package name */
    public static final iy f43458d;

    /* renamed from: e  reason: collision with root package name */
    public static final iy f43459e;

    /* renamed from: f  reason: collision with root package name */
    public static final iy f43460f;

    /* renamed from: g  reason: collision with root package name */
    public static final iy f43461g;

    /* renamed from: h  reason: collision with root package name */
    public static final iy f43462h;

    /* renamed from: i  reason: collision with root package name */
    public static final iy f43463i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public long f770a;

    /* renamed from: a  reason: collision with other field name */
    public hu f771a;

    /* renamed from: a  reason: collision with other field name */
    public String f772a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f773a;

    /* renamed from: b  reason: collision with other field name */
    public long f774b;

    /* renamed from: b  reason: collision with other field name */
    public String f775b;

    /* renamed from: c  reason: collision with other field name */
    public long f776c;

    /* renamed from: c  reason: collision with other field name */
    public String f777c;

    /* renamed from: d  reason: collision with other field name */
    public String f778d;

    /* renamed from: e  reason: collision with other field name */
    public String f779e;

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
        f769a = new jg("XmPushActionUnRegistrationResult");
        f43455a = new iy("", (byte) 11, (short) 1);
        f43456b = new iy("", StandardMessageCodec.LIST, (short) 2);
        f43457c = new iy("", (byte) 11, (short) 3);
        f43458d = new iy("", (byte) 11, (short) 4);
        f43459e = new iy("", (byte) 10, (short) 6);
        f43460f = new iy("", (byte) 11, (short) 7);
        f43461g = new iy("", (byte) 11, (short) 8);
        f43462h = new iy("", (byte) 10, (short) 9);
        f43463i = new iy("", (byte) 10, (short) 10);
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
        this.f773a = new BitSet(3);
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
                int compareTo = Boolean.valueOf(m505a()).compareTo(Boolean.valueOf(imVar.m505a()));
                if (compareTo != 0) {
                    return compareTo;
                }
                if (!m505a() || (a10 = ir.a(this.f772a, imVar.f772a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(imVar.b()));
                    if (compareTo2 != 0) {
                        return compareTo2;
                    }
                    if (!b() || (a9 = ir.a(this.f771a, imVar.f771a)) == 0) {
                        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(imVar.c()));
                        if (compareTo3 != 0) {
                            return compareTo3;
                        }
                        if (!c() || (a8 = ir.a(this.f775b, imVar.f775b)) == 0) {
                            int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(imVar.d()));
                            if (compareTo4 != 0) {
                                return compareTo4;
                            }
                            if (!d() || (a7 = ir.a(this.f777c, imVar.f777c)) == 0) {
                                int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(imVar.e()));
                                if (compareTo5 != 0) {
                                    return compareTo5;
                                }
                                if (!e() || (a6 = ir.a(this.f770a, imVar.f770a)) == 0) {
                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(imVar.f()));
                                    if (compareTo6 != 0) {
                                        return compareTo6;
                                    }
                                    if (!f() || (a5 = ir.a(this.f778d, imVar.f778d)) == 0) {
                                        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(imVar.g()));
                                        if (compareTo7 != 0) {
                                            return compareTo7;
                                        }
                                        if (!g() || (a4 = ir.a(this.f779e, imVar.f779e)) == 0) {
                                            int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(imVar.h()));
                                            if (compareTo8 != 0) {
                                                return compareTo8;
                                            }
                                            if (!h() || (a3 = ir.a(this.f774b, imVar.f774b)) == 0) {
                                                int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(imVar.i()));
                                                if (compareTo9 != 0) {
                                                    return compareTo9;
                                                }
                                                if (!i() || (a2 = ir.a(this.f776c, imVar.f776c)) == 0) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f779e : (String) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m504a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (this.f775b == null) {
                throw new jc("Required field 'id' was not present! Struct: " + toString());
            } else if (this.f777c != null) {
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
        jbVar.m524a();
        while (true) {
            iy m520a = jbVar.m520a();
            byte b2 = m520a.f43494a;
            if (b2 == 0) {
                jbVar.f();
                if (e()) {
                    m504a();
                    return;
                }
                throw new jc("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
            }
            switch (m520a.f810a) {
                case 1:
                    if (b2 == 11) {
                        this.f772a = jbVar.m525a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 2:
                    if (b2 == 12) {
                        hu huVar = new hu();
                        this.f771a = huVar;
                        huVar.a(jbVar);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f775b = jbVar.m525a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f777c = jbVar.m525a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 6:
                    if (b2 == 10) {
                        this.f770a = jbVar.m519a();
                        a(true);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f778d = jbVar.m525a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 8:
                    if (b2 == 11) {
                        this.f779e = jbVar.m525a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 9:
                    if (b2 == 10) {
                        this.f774b = jbVar.m519a();
                        b(true);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 10:
                    if (b2 == 10) {
                        this.f776c = jbVar.m519a();
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
            this.f773a.set(0, z);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m505a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f772a != null : invokeV.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m506a(im imVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, imVar)) == null) {
            if (imVar == null) {
                return false;
            }
            boolean m505a = m505a();
            boolean m505a2 = imVar.m505a();
            if ((m505a || m505a2) && !(m505a && m505a2 && this.f772a.equals(imVar.f772a))) {
                return false;
            }
            boolean b2 = b();
            boolean b3 = imVar.b();
            if ((b2 || b3) && !(b2 && b3 && this.f771a.m419a(imVar.f771a))) {
                return false;
            }
            boolean c2 = c();
            boolean c3 = imVar.c();
            if ((c2 || c3) && !(c2 && c3 && this.f775b.equals(imVar.f775b))) {
                return false;
            }
            boolean d2 = d();
            boolean d3 = imVar.d();
            if (((d2 || d3) && !(d2 && d3 && this.f777c.equals(imVar.f777c))) || this.f770a != imVar.f770a) {
                return false;
            }
            boolean f2 = f();
            boolean f3 = imVar.f();
            if ((f2 || f3) && !(f2 && f3 && this.f778d.equals(imVar.f778d))) {
                return false;
            }
            boolean g2 = g();
            boolean g3 = imVar.g();
            if ((g2 || g3) && !(g2 && g3 && this.f779e.equals(imVar.f779e))) {
                return false;
            }
            boolean h2 = h();
            boolean h3 = imVar.h();
            if ((h2 || h3) && !(h2 && h3 && this.f774b == imVar.f774b)) {
                return false;
            }
            boolean i2 = i();
            boolean i3 = imVar.i();
            if (i2 || i3) {
                return i2 && i3 && this.f776c == imVar.f776c;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.xiaomi.push.iq
    public void b(jb jbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, jbVar) == null) {
            m504a();
            jbVar.a(f769a);
            if (this.f772a != null && m505a()) {
                jbVar.a(f43455a);
                jbVar.a(this.f772a);
                jbVar.b();
            }
            if (this.f771a != null && b()) {
                jbVar.a(f43456b);
                this.f771a.b(jbVar);
                jbVar.b();
            }
            if (this.f775b != null) {
                jbVar.a(f43457c);
                jbVar.a(this.f775b);
                jbVar.b();
            }
            if (this.f777c != null) {
                jbVar.a(f43458d);
                jbVar.a(this.f777c);
                jbVar.b();
            }
            jbVar.a(f43459e);
            jbVar.a(this.f770a);
            jbVar.b();
            if (this.f778d != null && f()) {
                jbVar.a(f43460f);
                jbVar.a(this.f778d);
                jbVar.b();
            }
            if (this.f779e != null && g()) {
                jbVar.a(f43461g);
                jbVar.a(this.f779e);
                jbVar.b();
            }
            if (h()) {
                jbVar.a(f43462h);
                jbVar.a(this.f774b);
                jbVar.b();
            }
            if (i()) {
                jbVar.a(f43463i);
                jbVar.a(this.f776c);
                jbVar.b();
            }
            jbVar.c();
            jbVar.m528a();
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.f773a.set(1, z);
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f771a != null : invokeV.booleanValue;
    }

    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.f773a.set(2, z);
        }
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f775b != null : invokeV.booleanValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f777c != null : invokeV.booleanValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f773a.get(0) : invokeV.booleanValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, obj)) == null) {
            if (obj != null && (obj instanceof im)) {
                return m506a((im) obj);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f778d != null : invokeV.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.f779e != null : invokeV.booleanValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f773a.get(1) : invokeV.booleanValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f773a.get(2) : invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            StringBuilder sb = new StringBuilder("XmPushActionUnRegistrationResult(");
            boolean z2 = false;
            if (m505a()) {
                sb.append("debug:");
                String str = this.f772a;
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
                hu huVar = this.f771a;
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
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("appId:");
            String str3 = this.f777c;
            if (str3 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str3);
            }
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("errorCode:");
            sb.append(this.f770a);
            if (f()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("reason:");
                String str4 = this.f778d;
                if (str4 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str4);
                }
            }
            if (g()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("packageName:");
                String str5 = this.f779e;
                if (str5 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str5);
                }
            }
            if (h()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("unRegisteredAt:");
                sb.append(this.f774b);
            }
            if (i()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("costTime:");
                sb.append(this.f776c);
            }
            sb.append(SmallTailInfo.EMOTION_SUFFIX);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
