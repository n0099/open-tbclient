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
public class ey implements iq<ey, Object>, Serializable, Cloneable {
    public static /* synthetic */ Interceptable $ic;
    public static final iy a;

    /* renamed from: a  reason: collision with other field name */
    public static final jg f336a;
    public static final iy b;
    public static final iy c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public String f337a;

    /* renamed from: a  reason: collision with other field name */
    public List<ex> f338a;

    /* renamed from: b  reason: collision with other field name */
    public String f339b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-56375284, "Lcom/xiaomi/push/ey;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-56375284, "Lcom/xiaomi/push/ey;");
                return;
            }
        }
        f336a = new jg("StatsEvents");
        a = new iy("", Constants.GZIP_CAST_TYPE, (short) 1);
        b = new iy("", Constants.GZIP_CAST_TYPE, (short) 2);
        c = new iy("", (byte) 15, (short) 3);
    }

    public ey() {
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
    public ey(String str, List<ex> list) {
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
        this.f337a = str;
        this.f338a = list;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(ey eyVar) {
        InterceptResult invokeL;
        int a2;
        int a3;
        int a4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, eyVar)) == null) {
            if (ey.class.equals(eyVar.getClass())) {
                int compareTo = Boolean.valueOf(m339a()).compareTo(Boolean.valueOf(eyVar.m339a()));
                if (compareTo != 0) {
                    return compareTo;
                }
                if (!m339a() || (a4 = ir.a(this.f337a, eyVar.f337a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(eyVar.b()));
                    if (compareTo2 != 0) {
                        return compareTo2;
                    }
                    if (!b() || (a3 = ir.a(this.f339b, eyVar.f339b)) == 0) {
                        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(eyVar.c()));
                        if (compareTo3 != 0) {
                            return compareTo3;
                        }
                        if (!c() || (a2 = ir.a(this.f338a, eyVar.f338a)) == 0) {
                            return 0;
                        }
                        return a2;
                    }
                    return a3;
                }
                return a4;
            }
            return ey.class.getName().compareTo(eyVar.getClass().getName());
        }
        return invokeL.intValue;
    }

    public ey a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            this.f339b = str;
            return this;
        }
        return (ey) invokeL.objValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (this.f337a == null) {
                throw new jc("Required field 'uuid' was not present! Struct: " + toString());
            } else if (this.f338a != null) {
            } else {
                throw new jc("Required field 'events' was not present! Struct: " + toString());
            }
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
                a();
                return;
            }
            short s = m559a.f791a;
            if (s == 1) {
                if (b2 == 11) {
                    this.f337a = jbVar.m564a();
                    jbVar.g();
                }
                je.a(jbVar, b2);
                jbVar.g();
            } else if (s != 2) {
                if (s == 3 && b2 == 15) {
                    iz m560a = jbVar.m560a();
                    this.f338a = new ArrayList(m560a.f792a);
                    for (int i = 0; i < m560a.f792a; i++) {
                        ex exVar = new ex();
                        exVar.a(jbVar);
                        this.f338a.add(exVar);
                    }
                    jbVar.i();
                    jbVar.g();
                }
                je.a(jbVar, b2);
                jbVar.g();
            } else {
                if (b2 == 11) {
                    this.f339b = jbVar.m564a();
                    jbVar.g();
                }
                je.a(jbVar, b2);
                jbVar.g();
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m339a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f337a != null : invokeV.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m340a(ey eyVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, eyVar)) == null) {
            if (eyVar == null) {
                return false;
            }
            boolean m339a = m339a();
            boolean m339a2 = eyVar.m339a();
            if ((m339a || m339a2) && !(m339a && m339a2 && this.f337a.equals(eyVar.f337a))) {
                return false;
            }
            boolean b2 = b();
            boolean b3 = eyVar.b();
            if ((b2 || b3) && !(b2 && b3 && this.f339b.equals(eyVar.f339b))) {
                return false;
            }
            boolean c2 = c();
            boolean c3 = eyVar.c();
            if (c2 || c3) {
                return c2 && c3 && this.f338a.equals(eyVar.f338a);
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
            jbVar.a(f336a);
            if (this.f337a != null) {
                jbVar.a(a);
                jbVar.a(this.f337a);
                jbVar.b();
            }
            if (this.f339b != null && b()) {
                jbVar.a(b);
                jbVar.a(this.f339b);
                jbVar.b();
            }
            if (this.f338a != null) {
                jbVar.a(c);
                jbVar.a(new iz((byte) 12, this.f338a.size()));
                for (ex exVar : this.f338a) {
                    exVar.b(jbVar);
                }
                jbVar.e();
                jbVar.b();
            }
            jbVar.c();
            jbVar.m567a();
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f339b != null : invokeV.booleanValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f338a != null : invokeV.booleanValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, obj)) == null) {
            if (obj != null && (obj instanceof ey)) {
                return m340a((ey) obj);
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
            String str = this.f337a;
            if (str == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str);
            }
            if (b()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("operator:");
                String str2 = this.f339b;
                if (str2 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str2);
                }
            }
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("events:");
            List<ex> list = this.f338a;
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
