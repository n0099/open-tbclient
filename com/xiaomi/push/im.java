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
/* loaded from: classes7.dex */
public class im implements iq<im, Object>, Serializable, Cloneable {
    public static /* synthetic */ Interceptable $ic;
    public static final iy a;

    /* renamed from: a  reason: collision with other field name */
    public static final jg f750a;

    /* renamed from: b  reason: collision with root package name */
    public static final iy f44490b;

    /* renamed from: c  reason: collision with root package name */
    public static final iy f44491c;

    /* renamed from: d  reason: collision with root package name */
    public static final iy f44492d;

    /* renamed from: e  reason: collision with root package name */
    public static final iy f44493e;

    /* renamed from: f  reason: collision with root package name */
    public static final iy f44494f;

    /* renamed from: g  reason: collision with root package name */
    public static final iy f44495g;

    /* renamed from: h  reason: collision with root package name */
    public static final iy f44496h;
    public static final iy i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public long f751a;

    /* renamed from: a  reason: collision with other field name */
    public hu f752a;

    /* renamed from: a  reason: collision with other field name */
    public String f753a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f754a;

    /* renamed from: b  reason: collision with other field name */
    public long f755b;

    /* renamed from: b  reason: collision with other field name */
    public String f756b;

    /* renamed from: c  reason: collision with other field name */
    public long f757c;

    /* renamed from: c  reason: collision with other field name */
    public String f758c;

    /* renamed from: d  reason: collision with other field name */
    public String f759d;

    /* renamed from: e  reason: collision with other field name */
    public String f760e;

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
        f750a = new jg("XmPushActionUnRegistrationResult");
        a = new iy("", Constants.GZIP_CAST_TYPE, (short) 1);
        f44490b = new iy("", (byte) 12, (short) 2);
        f44491c = new iy("", Constants.GZIP_CAST_TYPE, (short) 3);
        f44492d = new iy("", Constants.GZIP_CAST_TYPE, (short) 4);
        f44493e = new iy("", (byte) 10, (short) 6);
        f44494f = new iy("", Constants.GZIP_CAST_TYPE, (short) 7);
        f44495g = new iy("", Constants.GZIP_CAST_TYPE, (short) 8);
        f44496h = new iy("", (byte) 10, (short) 9);
        i = new iy("", (byte) 10, (short) 10);
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
        this.f754a = new BitSet(3);
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
                int compareTo = Boolean.valueOf(m547a()).compareTo(Boolean.valueOf(imVar.m547a()));
                if (compareTo != 0) {
                    return compareTo;
                }
                if (!m547a() || (a10 = ir.a(this.f753a, imVar.f753a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(imVar.b()));
                    if (compareTo2 != 0) {
                        return compareTo2;
                    }
                    if (!b() || (a9 = ir.a(this.f752a, imVar.f752a)) == 0) {
                        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(imVar.c()));
                        if (compareTo3 != 0) {
                            return compareTo3;
                        }
                        if (!c() || (a8 = ir.a(this.f756b, imVar.f756b)) == 0) {
                            int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(imVar.d()));
                            if (compareTo4 != 0) {
                                return compareTo4;
                            }
                            if (!d() || (a7 = ir.a(this.f758c, imVar.f758c)) == 0) {
                                int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(imVar.e()));
                                if (compareTo5 != 0) {
                                    return compareTo5;
                                }
                                if (!e() || (a6 = ir.a(this.f751a, imVar.f751a)) == 0) {
                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(imVar.f()));
                                    if (compareTo6 != 0) {
                                        return compareTo6;
                                    }
                                    if (!f() || (a5 = ir.a(this.f759d, imVar.f759d)) == 0) {
                                        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(imVar.g()));
                                        if (compareTo7 != 0) {
                                            return compareTo7;
                                        }
                                        if (!g() || (a4 = ir.a(this.f760e, imVar.f760e)) == 0) {
                                            int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(imVar.h()));
                                            if (compareTo8 != 0) {
                                                return compareTo8;
                                            }
                                            if (!h() || (a3 = ir.a(this.f755b, imVar.f755b)) == 0) {
                                                int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(imVar.i()));
                                                if (compareTo9 != 0) {
                                                    return compareTo9;
                                                }
                                                if (!i() || (a2 = ir.a(this.f757c, imVar.f757c)) == 0) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f760e : (String) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m546a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (this.f756b == null) {
                throw new jc("Required field 'id' was not present! Struct: " + toString());
            } else if (this.f758c != null) {
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
        jbVar.m566a();
        while (true) {
            iy m562a = jbVar.m562a();
            byte b2 = m562a.a;
            if (b2 == 0) {
                jbVar.f();
                if (e()) {
                    m546a();
                    return;
                }
                throw new jc("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
            }
            switch (m562a.f791a) {
                case 1:
                    if (b2 == 11) {
                        this.f753a = jbVar.m567a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 2:
                    if (b2 == 12) {
                        hu huVar = new hu();
                        this.f752a = huVar;
                        huVar.a(jbVar);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f756b = jbVar.m567a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f758c = jbVar.m567a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 6:
                    if (b2 == 10) {
                        this.f751a = jbVar.m561a();
                        a(true);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f759d = jbVar.m567a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 8:
                    if (b2 == 11) {
                        this.f760e = jbVar.m567a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 9:
                    if (b2 == 10) {
                        this.f755b = jbVar.m561a();
                        b(true);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 10:
                    if (b2 == 10) {
                        this.f757c = jbVar.m561a();
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
            this.f754a.set(0, z);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m547a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f753a != null : invokeV.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m548a(im imVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, imVar)) == null) {
            if (imVar == null) {
                return false;
            }
            boolean m547a = m547a();
            boolean m547a2 = imVar.m547a();
            if ((m547a || m547a2) && !(m547a && m547a2 && this.f753a.equals(imVar.f753a))) {
                return false;
            }
            boolean b2 = b();
            boolean b3 = imVar.b();
            if ((b2 || b3) && !(b2 && b3 && this.f752a.m461a(imVar.f752a))) {
                return false;
            }
            boolean c2 = c();
            boolean c3 = imVar.c();
            if ((c2 || c3) && !(c2 && c3 && this.f756b.equals(imVar.f756b))) {
                return false;
            }
            boolean d2 = d();
            boolean d3 = imVar.d();
            if (((d2 || d3) && !(d2 && d3 && this.f758c.equals(imVar.f758c))) || this.f751a != imVar.f751a) {
                return false;
            }
            boolean f2 = f();
            boolean f3 = imVar.f();
            if ((f2 || f3) && !(f2 && f3 && this.f759d.equals(imVar.f759d))) {
                return false;
            }
            boolean g2 = g();
            boolean g3 = imVar.g();
            if ((g2 || g3) && !(g2 && g3 && this.f760e.equals(imVar.f760e))) {
                return false;
            }
            boolean h2 = h();
            boolean h3 = imVar.h();
            if ((h2 || h3) && !(h2 && h3 && this.f755b == imVar.f755b)) {
                return false;
            }
            boolean i2 = i();
            boolean i3 = imVar.i();
            if (i2 || i3) {
                return i2 && i3 && this.f757c == imVar.f757c;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.xiaomi.push.iq
    public void b(jb jbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, jbVar) == null) {
            m546a();
            jbVar.a(f750a);
            if (this.f753a != null && m547a()) {
                jbVar.a(a);
                jbVar.a(this.f753a);
                jbVar.b();
            }
            if (this.f752a != null && b()) {
                jbVar.a(f44490b);
                this.f752a.b(jbVar);
                jbVar.b();
            }
            if (this.f756b != null) {
                jbVar.a(f44491c);
                jbVar.a(this.f756b);
                jbVar.b();
            }
            if (this.f758c != null) {
                jbVar.a(f44492d);
                jbVar.a(this.f758c);
                jbVar.b();
            }
            jbVar.a(f44493e);
            jbVar.a(this.f751a);
            jbVar.b();
            if (this.f759d != null && f()) {
                jbVar.a(f44494f);
                jbVar.a(this.f759d);
                jbVar.b();
            }
            if (this.f760e != null && g()) {
                jbVar.a(f44495g);
                jbVar.a(this.f760e);
                jbVar.b();
            }
            if (h()) {
                jbVar.a(f44496h);
                jbVar.a(this.f755b);
                jbVar.b();
            }
            if (i()) {
                jbVar.a(i);
                jbVar.a(this.f757c);
                jbVar.b();
            }
            jbVar.c();
            jbVar.m570a();
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.f754a.set(1, z);
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f752a != null : invokeV.booleanValue;
    }

    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.f754a.set(2, z);
        }
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f756b != null : invokeV.booleanValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f758c != null : invokeV.booleanValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f754a.get(0) : invokeV.booleanValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, obj)) == null) {
            if (obj != null && (obj instanceof im)) {
                return m548a((im) obj);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f759d != null : invokeV.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.f760e != null : invokeV.booleanValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f754a.get(1) : invokeV.booleanValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f754a.get(2) : invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            StringBuilder sb = new StringBuilder("XmPushActionUnRegistrationResult(");
            boolean z2 = false;
            if (m547a()) {
                sb.append("debug:");
                String str = this.f753a;
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
                hu huVar = this.f752a;
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
            String str2 = this.f756b;
            if (str2 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str2);
            }
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("appId:");
            String str3 = this.f758c;
            if (str3 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str3);
            }
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("errorCode:");
            sb.append(this.f751a);
            if (f()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("reason:");
                String str4 = this.f759d;
                if (str4 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str4);
                }
            }
            if (g()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("packageName:");
                String str5 = this.f760e;
                if (str5 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str5);
                }
            }
            if (h()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("unRegisteredAt:");
                sb.append(this.f755b);
            }
            if (i()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("costTime:");
                sb.append(this.f757c);
            }
            sb.append(SmallTailInfo.EMOTION_SUFFIX);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
