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
/* loaded from: classes8.dex */
public class hr implements iu<hr, Object>, Serializable, Cloneable {
    public static /* synthetic */ Interceptable $ic;
    public static final jc a;

    /* renamed from: a  reason: collision with other field name */
    public static final jk f494a;
    public static final jc b;
    public static final jc c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public long f495a;

    /* renamed from: a  reason: collision with other field name */
    public hl f496a;

    /* renamed from: a  reason: collision with other field name */
    public String f497a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f498a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-56372618, "Lcom/xiaomi/push/hr;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-56372618, "Lcom/xiaomi/push/hr;");
                return;
            }
        }
        f494a = new jk("DataCollectionItem");
        a = new jc("", (byte) 10, (short) 1);
        b = new jc("", (byte) 8, (short) 2);
        c = new jc("", Constants.GZIP_CAST_TYPE, (short) 3);
    }

    public hr() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f498a = new BitSet(1);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(hr hrVar) {
        InterceptResult invokeL;
        int a2;
        int a3;
        int a4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, hrVar)) == null) {
            if (hr.class.equals(hrVar.getClass())) {
                int compareTo = Boolean.valueOf(m410a()).compareTo(Boolean.valueOf(hrVar.m410a()));
                if (compareTo != 0) {
                    return compareTo;
                }
                if (!m410a() || (a4 = iv.a(this.f495a, hrVar.f495a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(hrVar.b()));
                    if (compareTo2 != 0) {
                        return compareTo2;
                    }
                    if (!b() || (a3 = iv.a(this.f496a, hrVar.f496a)) == 0) {
                        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(hrVar.c()));
                        if (compareTo3 != 0) {
                            return compareTo3;
                        }
                        if (!c() || (a2 = iv.a(this.f497a, hrVar.f497a)) == 0) {
                            return 0;
                        }
                        return a2;
                    }
                    return a3;
                }
                return a4;
            }
            return hr.class.getName().compareTo(hrVar.getClass().getName());
        }
        return invokeL.intValue;
    }

    public hr a(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j)) == null) {
            this.f495a = j;
            a(true);
            return this;
        }
        return (hr) invokeJ.objValue;
    }

    public hr a(hl hlVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, hlVar)) == null) {
            this.f496a = hlVar;
            return this;
        }
        return (hr) invokeL.objValue;
    }

    public hr a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            this.f497a = str;
            return this;
        }
        return (hr) invokeL.objValue;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f497a : (String) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m409a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.f496a == null) {
                throw new jg("Required field 'collectionType' was not present! Struct: " + toString());
            } else if (this.f497a != null) {
            } else {
                throw new jg("Required field 'content' was not present! Struct: " + toString());
            }
        }
    }

    @Override // com.xiaomi.push.iu
    public void a(jf jfVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, jfVar) == null) {
            jfVar.m549a();
            while (true) {
                jc m545a = jfVar.m545a();
                byte b2 = m545a.a;
                if (b2 == 0) {
                    break;
                }
                short s = m545a.f809a;
                if (s == 1) {
                    if (b2 == 10) {
                        this.f495a = jfVar.m544a();
                        a(true);
                        jfVar.g();
                    }
                    ji.a(jfVar, b2);
                    jfVar.g();
                } else if (s != 2) {
                    if (s == 3 && b2 == 11) {
                        this.f497a = jfVar.m550a();
                        jfVar.g();
                    }
                    ji.a(jfVar, b2);
                    jfVar.g();
                } else {
                    if (b2 == 8) {
                        this.f496a = hl.a(jfVar.m543a());
                        jfVar.g();
                    }
                    ji.a(jfVar, b2);
                    jfVar.g();
                }
            }
            jfVar.f();
            if (m410a()) {
                m409a();
                return;
            }
            throw new jg("Required field 'collectedAt' was not found in serialized data! Struct: " + toString());
        }
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.f498a.set(0, z);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m410a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f498a.get(0) : invokeV.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m411a(hr hrVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, hrVar)) == null) {
            if (hrVar != null && this.f495a == hrVar.f495a) {
                boolean b2 = b();
                boolean b3 = hrVar.b();
                if ((b2 || b3) && !(b2 && b3 && this.f496a.equals(hrVar.f496a))) {
                    return false;
                }
                boolean c2 = c();
                boolean c3 = hrVar.c();
                if (c2 || c3) {
                    return c2 && c3 && this.f497a.equals(hrVar.f497a);
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.xiaomi.push.iu
    public void b(jf jfVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, jfVar) == null) {
            m409a();
            jfVar.a(f494a);
            jfVar.a(a);
            jfVar.a(this.f495a);
            jfVar.b();
            if (this.f496a != null) {
                jfVar.a(b);
                jfVar.a(this.f496a.a());
                jfVar.b();
            }
            if (this.f497a != null) {
                jfVar.a(c);
                jfVar.a(this.f497a);
                jfVar.b();
            }
            jfVar.c();
            jfVar.m553a();
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f496a != null : invokeV.booleanValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f497a != null : invokeV.booleanValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, obj)) == null) {
            if (obj != null && (obj instanceof hr)) {
                return m411a((hr) obj);
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
            sb.append(this.f495a);
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("collectionType:");
            hl hlVar = this.f496a;
            if (hlVar == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(hlVar);
            }
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("content:");
            String str = this.f497a;
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
