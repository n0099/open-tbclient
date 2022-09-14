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
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class fb implements iu<fb, Object>, Serializable, Cloneable {
    public static /* synthetic */ Interceptable $ic;
    public static final jc a;

    /* renamed from: a  reason: collision with other field name */
    public static final jk f349a;
    public static final jc b;
    public static final jc c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public String f350a;

    /* renamed from: a  reason: collision with other field name */
    public List<fa> f351a;

    /* renamed from: b  reason: collision with other field name */
    public String f352b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-56375036, "Lcom/xiaomi/push/fb;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-56375036, "Lcom/xiaomi/push/fb;");
                return;
            }
        }
        f349a = new jk("StatsEvents");
        a = new jc("", Constants.GZIP_CAST_TYPE, (short) 1);
        b = new jc("", Constants.GZIP_CAST_TYPE, (short) 2);
        c = new jc("", (byte) 15, (short) 3);
    }

    public fb() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public fb(String str, List<fa> list) {
        this();
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, list};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                this();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f350a = str;
        this.f351a = list;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(fb fbVar) {
        InterceptResult invokeL;
        int a2;
        int a3;
        int a4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, fbVar)) == null) {
            if (fb.class.equals(fbVar.getClass())) {
                int compareTo = Boolean.valueOf(m325a()).compareTo(Boolean.valueOf(fbVar.m325a()));
                if (compareTo != 0) {
                    return compareTo;
                }
                if (!m325a() || (a4 = iv.a(this.f350a, fbVar.f350a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(fbVar.b()));
                    if (compareTo2 != 0) {
                        return compareTo2;
                    }
                    if (!b() || (a3 = iv.a(this.f352b, fbVar.f352b)) == 0) {
                        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(fbVar.c()));
                        if (compareTo3 != 0) {
                            return compareTo3;
                        }
                        if (!c() || (a2 = iv.a(this.f351a, fbVar.f351a)) == 0) {
                            return 0;
                        }
                        return a2;
                    }
                    return a3;
                }
                return a4;
            }
            return fb.class.getName().compareTo(fbVar.getClass().getName());
        }
        return invokeL.intValue;
    }

    public fb a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            this.f352b = str;
            return this;
        }
        return (fb) invokeL.objValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (this.f350a == null) {
                throw new jg("Required field 'uuid' was not present! Struct: " + toString());
            } else if (this.f351a != null) {
            } else {
                throw new jg("Required field 'events' was not present! Struct: " + toString());
            }
        }
    }

    @Override // com.xiaomi.push.iu
    public void a(jf jfVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(1048579, this, jfVar) != null) {
            return;
        }
        jfVar.m550a();
        while (true) {
            jc m546a = jfVar.m546a();
            byte b2 = m546a.a;
            if (b2 == 0) {
                jfVar.f();
                a();
                return;
            }
            short s = m546a.f810a;
            if (s == 1) {
                if (b2 == 11) {
                    this.f350a = jfVar.m551a();
                    jfVar.g();
                }
                ji.a(jfVar, b2);
                jfVar.g();
            } else if (s != 2) {
                if (s == 3 && b2 == 15) {
                    jd m547a = jfVar.m547a();
                    this.f351a = new ArrayList(m547a.f811a);
                    for (int i = 0; i < m547a.f811a; i++) {
                        fa faVar = new fa();
                        faVar.a(jfVar);
                        this.f351a.add(faVar);
                    }
                    jfVar.i();
                    jfVar.g();
                }
                ji.a(jfVar, b2);
                jfVar.g();
            } else {
                if (b2 == 11) {
                    this.f352b = jfVar.m551a();
                    jfVar.g();
                }
                ji.a(jfVar, b2);
                jfVar.g();
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m325a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f350a != null : invokeV.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m326a(fb fbVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, fbVar)) == null) {
            if (fbVar == null) {
                return false;
            }
            boolean m325a = m325a();
            boolean m325a2 = fbVar.m325a();
            if ((m325a || m325a2) && !(m325a && m325a2 && this.f350a.equals(fbVar.f350a))) {
                return false;
            }
            boolean b2 = b();
            boolean b3 = fbVar.b();
            if ((b2 || b3) && !(b2 && b3 && this.f352b.equals(fbVar.f352b))) {
                return false;
            }
            boolean c2 = c();
            boolean c3 = fbVar.c();
            if (c2 || c3) {
                return c2 && c3 && this.f351a.equals(fbVar.f351a);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.xiaomi.push.iu
    public void b(jf jfVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, jfVar) == null) {
            a();
            jfVar.a(f349a);
            if (this.f350a != null) {
                jfVar.a(a);
                jfVar.a(this.f350a);
                jfVar.b();
            }
            if (this.f352b != null && b()) {
                jfVar.a(b);
                jfVar.a(this.f352b);
                jfVar.b();
            }
            if (this.f351a != null) {
                jfVar.a(c);
                jfVar.a(new jd((byte) 12, this.f351a.size()));
                for (fa faVar : this.f351a) {
                    faVar.b(jfVar);
                }
                jfVar.e();
                jfVar.b();
            }
            jfVar.c();
            jfVar.m554a();
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f352b != null : invokeV.booleanValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f351a != null : invokeV.booleanValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, obj)) == null) {
            if (obj != null && (obj instanceof fb)) {
                return m326a((fb) obj);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            StringBuilder sb = new StringBuilder("StatsEvents(");
            sb.append("uuid:");
            String str = this.f350a;
            if (str == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str);
            }
            if (b()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("operator:");
                String str2 = this.f352b;
                if (str2 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str2);
                }
            }
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("events:");
            List<fa> list = this.f351a;
            if (list == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(list);
            }
            sb.append(SmallTailInfo.EMOTION_SUFFIX);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
