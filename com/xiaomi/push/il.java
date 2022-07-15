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
public class il implements iu<il, Object>, Serializable, Cloneable {
    public static /* synthetic */ Interceptable $ic;
    public static final jc a;

    /* renamed from: a  reason: collision with other field name */
    public static final jk f1428a;
    public static final jc b;
    public static final jc c;
    public static final jc d;
    public static final jc e;
    public static final jc f;
    public static final jc g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public long f1429a;

    /* renamed from: a  reason: collision with other field name */
    public hy f1430a;

    /* renamed from: a  reason: collision with other field name */
    public String f1431a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f1432a;

    /* renamed from: b  reason: collision with other field name */
    public String f1433b;

    /* renamed from: c  reason: collision with other field name */
    public String f1434c;

    /* renamed from: d  reason: collision with other field name */
    public String f1435d;

    /* renamed from: e  reason: collision with other field name */
    public String f1436e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-56371843, "Lcom/xiaomi/push/il;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-56371843, "Lcom/xiaomi/push/il;");
                return;
            }
        }
        f1428a = new jk("XmPushActionSendFeedbackResult");
        a = new jc("", Constants.GZIP_CAST_TYPE, (short) 1);
        b = new jc("", (byte) 12, (short) 2);
        c = new jc("", Constants.GZIP_CAST_TYPE, (short) 3);
        d = new jc("", Constants.GZIP_CAST_TYPE, (short) 4);
        e = new jc("", (byte) 10, (short) 6);
        f = new jc("", Constants.GZIP_CAST_TYPE, (short) 7);
        g = new jc("", Constants.GZIP_CAST_TYPE, (short) 8);
    }

    public il() {
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
        this.f1432a = new BitSet(1);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(il ilVar) {
        InterceptResult invokeL;
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        int a8;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, ilVar)) == null) {
            if (il.class.equals(ilVar.getClass())) {
                int compareTo = Boolean.valueOf(m1439a()).compareTo(Boolean.valueOf(ilVar.m1439a()));
                if (compareTo != 0) {
                    return compareTo;
                }
                if (!m1439a() || (a8 = iv.a(this.f1431a, ilVar.f1431a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(ilVar.b()));
                    if (compareTo2 != 0) {
                        return compareTo2;
                    }
                    if (!b() || (a7 = iv.a(this.f1430a, ilVar.f1430a)) == 0) {
                        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(ilVar.c()));
                        if (compareTo3 != 0) {
                            return compareTo3;
                        }
                        if (!c() || (a6 = iv.a(this.f1433b, ilVar.f1433b)) == 0) {
                            int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(ilVar.d()));
                            if (compareTo4 != 0) {
                                return compareTo4;
                            }
                            if (!d() || (a5 = iv.a(this.f1434c, ilVar.f1434c)) == 0) {
                                int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(ilVar.e()));
                                if (compareTo5 != 0) {
                                    return compareTo5;
                                }
                                if (!e() || (a4 = iv.a(this.f1429a, ilVar.f1429a)) == 0) {
                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(ilVar.f()));
                                    if (compareTo6 != 0) {
                                        return compareTo6;
                                    }
                                    if (!f() || (a3 = iv.a(this.f1435d, ilVar.f1435d)) == 0) {
                                        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ilVar.g()));
                                        if (compareTo7 != 0) {
                                            return compareTo7;
                                        }
                                        if (!g() || (a2 = iv.a(this.f1436e, ilVar.f1436e)) == 0) {
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
            return il.class.getName().compareTo(ilVar.getClass().getName());
        }
        return invokeL.intValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.f1433b == null) {
                throw new jg("Required field 'id' was not present! Struct: " + toString());
            } else if (this.f1434c != null) {
            } else {
                throw new jg("Required field 'appId' was not present! Struct: " + toString());
            }
        }
    }

    @Override // com.xiaomi.push.iu
    public void a(jf jfVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jfVar) != null) {
            return;
        }
        jfVar.m1487a();
        while (true) {
            jc m1483a = jfVar.m1483a();
            byte b2 = m1483a.a;
            if (b2 == 0) {
                jfVar.f();
                if (e()) {
                    a();
                    return;
                }
                throw new jg("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
            }
            switch (m1483a.f1529a) {
                case 1:
                    if (b2 == 11) {
                        this.f1431a = jfVar.m1488a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 2:
                    if (b2 == 12) {
                        hy hyVar = new hy();
                        this.f1430a = hyVar;
                        hyVar.a(jfVar);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f1433b = jfVar.m1488a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f1434c = jfVar.m1488a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 6:
                    if (b2 == 10) {
                        this.f1429a = jfVar.m1482a();
                        a(true);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f1435d = jfVar.m1488a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 8:
                    if (b2 == 11) {
                        this.f1436e = jfVar.m1488a();
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
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.f1432a.set(0, z);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m1439a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f1431a != null : invokeV.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m1440a(il ilVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, ilVar)) == null) {
            if (ilVar == null) {
                return false;
            }
            boolean m1439a = m1439a();
            boolean m1439a2 = ilVar.m1439a();
            if ((m1439a || m1439a2) && !(m1439a && m1439a2 && this.f1431a.equals(ilVar.f1431a))) {
                return false;
            }
            boolean b2 = b();
            boolean b3 = ilVar.b();
            if ((b2 || b3) && !(b2 && b3 && this.f1430a.m1381a(ilVar.f1430a))) {
                return false;
            }
            boolean c2 = c();
            boolean c3 = ilVar.c();
            if ((c2 || c3) && !(c2 && c3 && this.f1433b.equals(ilVar.f1433b))) {
                return false;
            }
            boolean d2 = d();
            boolean d3 = ilVar.d();
            if (((d2 || d3) && !(d2 && d3 && this.f1434c.equals(ilVar.f1434c))) || this.f1429a != ilVar.f1429a) {
                return false;
            }
            boolean f2 = f();
            boolean f3 = ilVar.f();
            if ((f2 || f3) && !(f2 && f3 && this.f1435d.equals(ilVar.f1435d))) {
                return false;
            }
            boolean g2 = g();
            boolean g3 = ilVar.g();
            if (g2 || g3) {
                return g2 && g3 && this.f1436e.equals(ilVar.f1436e);
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
            jfVar.a(f1428a);
            if (this.f1431a != null && m1439a()) {
                jfVar.a(a);
                jfVar.a(this.f1431a);
                jfVar.b();
            }
            if (this.f1430a != null && b()) {
                jfVar.a(b);
                this.f1430a.b(jfVar);
                jfVar.b();
            }
            if (this.f1433b != null) {
                jfVar.a(c);
                jfVar.a(this.f1433b);
                jfVar.b();
            }
            if (this.f1434c != null) {
                jfVar.a(d);
                jfVar.a(this.f1434c);
                jfVar.b();
            }
            jfVar.a(e);
            jfVar.a(this.f1429a);
            jfVar.b();
            if (this.f1435d != null && f()) {
                jfVar.a(f);
                jfVar.a(this.f1435d);
                jfVar.b();
            }
            if (this.f1436e != null && g()) {
                jfVar.a(g);
                jfVar.a(this.f1436e);
                jfVar.b();
            }
            jfVar.c();
            jfVar.m1491a();
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f1430a != null : invokeV.booleanValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f1433b != null : invokeV.booleanValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f1434c != null : invokeV.booleanValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f1432a.get(0) : invokeV.booleanValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, obj)) == null) {
            if (obj != null && (obj instanceof il)) {
                return m1440a((il) obj);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f1435d != null : invokeV.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f1436e != null : invokeV.booleanValue;
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
            if (m1439a()) {
                sb.append("debug:");
                String str = this.f1431a;
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
                hy hyVar = this.f1430a;
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
            String str2 = this.f1433b;
            if (str2 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str2);
            }
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("appId:");
            String str3 = this.f1434c;
            if (str3 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str3);
            }
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("errorCode:");
            sb.append(this.f1429a);
            if (f()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("reason:");
                String str4 = this.f1435d;
                if (str4 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str4);
                }
            }
            if (g()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("category:");
                String str5 = this.f1436e;
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
