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
/* loaded from: classes4.dex */
public class hn implements iq<hn, Object>, Serializable, Cloneable {
    public static /* synthetic */ Interceptable $ic;
    public static final iy a;

    /* renamed from: a  reason: collision with other field name */
    public static final jg f503a;

    /* renamed from: b  reason: collision with root package name */
    public static final iy f61245b;

    /* renamed from: c  reason: collision with root package name */
    public static final iy f61246c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public long f504a;

    /* renamed from: a  reason: collision with other field name */
    public hh f505a;

    /* renamed from: a  reason: collision with other field name */
    public String f506a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f507a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-56372742, "Lcom/xiaomi/push/hn;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-56372742, "Lcom/xiaomi/push/hn;");
                return;
            }
        }
        f503a = new jg("DataCollectionItem");
        a = new iy("", (byte) 10, (short) 1);
        f61245b = new iy("", (byte) 8, (short) 2);
        f61246c = new iy("", (byte) 11, (short) 3);
    }

    public hn() {
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
        this.f507a = new BitSet(1);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(hn hnVar) {
        InterceptResult invokeL;
        int a2;
        int a3;
        int a4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, hnVar)) == null) {
            if (hn.class.equals(hnVar.getClass())) {
                int compareTo = Boolean.valueOf(m450a()).compareTo(Boolean.valueOf(hnVar.m450a()));
                if (compareTo != 0) {
                    return compareTo;
                }
                if (!m450a() || (a4 = ir.a(this.f504a, hnVar.f504a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(hnVar.b()));
                    if (compareTo2 != 0) {
                        return compareTo2;
                    }
                    if (!b() || (a3 = ir.a(this.f505a, hnVar.f505a)) == 0) {
                        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(hnVar.c()));
                        if (compareTo3 != 0) {
                            return compareTo3;
                        }
                        if (!c() || (a2 = ir.a(this.f506a, hnVar.f506a)) == 0) {
                            return 0;
                        }
                        return a2;
                    }
                    return a3;
                }
                return a4;
            }
            return hn.class.getName().compareTo(hnVar.getClass().getName());
        }
        return invokeL.intValue;
    }

    public hn a(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2)) == null) {
            this.f504a = j2;
            a(true);
            return this;
        }
        return (hn) invokeJ.objValue;
    }

    public hn a(hh hhVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, hhVar)) == null) {
            this.f505a = hhVar;
            return this;
        }
        return (hn) invokeL.objValue;
    }

    public hn a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            this.f506a = str;
            return this;
        }
        return (hn) invokeL.objValue;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f506a : (String) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m449a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.f505a == null) {
                throw new jc("Required field 'collectionType' was not present! Struct: " + toString());
            } else if (this.f506a != null) {
            } else {
                throw new jc("Required field 'content' was not present! Struct: " + toString());
            }
        }
    }

    @Override // com.xiaomi.push.iq
    public void a(jb jbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, jbVar) == null) {
            jbVar.m588a();
            while (true) {
                iy m584a = jbVar.m584a();
                byte b2 = m584a.a;
                if (b2 == 0) {
                    break;
                }
                short s = m584a.f815a;
                if (s == 1) {
                    if (b2 == 10) {
                        this.f504a = jbVar.m583a();
                        a(true);
                        jbVar.g();
                    }
                    je.a(jbVar, b2);
                    jbVar.g();
                } else if (s != 2) {
                    if (s == 3 && b2 == 11) {
                        this.f506a = jbVar.m589a();
                        jbVar.g();
                    }
                    je.a(jbVar, b2);
                    jbVar.g();
                } else {
                    if (b2 == 8) {
                        this.f505a = hh.a(jbVar.m582a());
                        jbVar.g();
                    }
                    je.a(jbVar, b2);
                    jbVar.g();
                }
            }
            jbVar.f();
            if (m450a()) {
                m449a();
                return;
            }
            throw new jc("Required field 'collectedAt' was not found in serialized data! Struct: " + toString());
        }
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.f507a.set(0, z);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m450a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f507a.get(0) : invokeV.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m451a(hn hnVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, hnVar)) == null) {
            if (hnVar != null && this.f504a == hnVar.f504a) {
                boolean b2 = b();
                boolean b3 = hnVar.b();
                if ((b2 || b3) && !(b2 && b3 && this.f505a.equals(hnVar.f505a))) {
                    return false;
                }
                boolean c2 = c();
                boolean c3 = hnVar.c();
                if (c2 || c3) {
                    return c2 && c3 && this.f506a.equals(hnVar.f506a);
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.xiaomi.push.iq
    public void b(jb jbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, jbVar) == null) {
            m449a();
            jbVar.a(f503a);
            jbVar.a(a);
            jbVar.a(this.f504a);
            jbVar.b();
            if (this.f505a != null) {
                jbVar.a(f61245b);
                jbVar.a(this.f505a.a());
                jbVar.b();
            }
            if (this.f506a != null) {
                jbVar.a(f61246c);
                jbVar.a(this.f506a);
                jbVar.b();
            }
            jbVar.c();
            jbVar.m592a();
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f505a != null : invokeV.booleanValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f506a != null : invokeV.booleanValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, obj)) == null) {
            if (obj != null && (obj instanceof hn)) {
                return m451a((hn) obj);
            }
            return false;
        }
        return invokeL.booleanValue;
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
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            StringBuilder sb = new StringBuilder("DataCollectionItem(");
            sb.append("collectedAt:");
            sb.append(this.f504a);
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("collectionType:");
            hh hhVar = this.f505a;
            if (hhVar == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(hhVar);
            }
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("content:");
            String str = this.f506a;
            if (str == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str);
            }
            sb.append(SmallTailInfo.EMOTION_SUFFIX);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
