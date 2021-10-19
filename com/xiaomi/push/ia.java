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
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
/* loaded from: classes10.dex */
public class ia implements iq<ia, Object>, Serializable, Cloneable {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final iy f78257a;

    /* renamed from: a  reason: collision with other field name */
    public static final jg f622a;

    /* renamed from: b  reason: collision with root package name */
    public static final iy f78258b;

    /* renamed from: c  reason: collision with root package name */
    public static final iy f78259c;

    /* renamed from: d  reason: collision with root package name */
    public static final iy f78260d;

    /* renamed from: e  reason: collision with root package name */
    public static final iy f78261e;

    /* renamed from: f  reason: collision with root package name */
    public static final iy f78262f;

    /* renamed from: g  reason: collision with root package name */
    public static final iy f78263g;

    /* renamed from: h  reason: collision with root package name */
    public static final iy f78264h;

    /* renamed from: i  reason: collision with root package name */
    public static final iy f78265i;

    /* renamed from: j  reason: collision with root package name */
    public static final iy f78266j;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public long f623a;

    /* renamed from: a  reason: collision with other field name */
    public hu f624a;

    /* renamed from: a  reason: collision with other field name */
    public String f625a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f626a;

    /* renamed from: a  reason: collision with other field name */
    public List<String> f627a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f628a;

    /* renamed from: b  reason: collision with other field name */
    public String f629b;

    /* renamed from: c  reason: collision with other field name */
    public String f630c;

    /* renamed from: d  reason: collision with other field name */
    public String f631d;

    /* renamed from: e  reason: collision with other field name */
    public String f632e;

    /* renamed from: f  reason: collision with other field name */
    public String f633f;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-56372184, "Lcom/xiaomi/push/ia;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-56372184, "Lcom/xiaomi/push/ia;");
                return;
            }
        }
        f622a = new jg("XmPushActionCommandResult");
        f78257a = new iy("", StandardMessageCodec.LIST, (short) 2);
        f78258b = new iy("", (byte) 11, (short) 3);
        f78259c = new iy("", (byte) 11, (short) 4);
        f78260d = new iy("", (byte) 11, (short) 5);
        f78261e = new iy("", (byte) 10, (short) 7);
        f78262f = new iy("", (byte) 11, (short) 8);
        f78263g = new iy("", (byte) 11, (short) 9);
        f78264h = new iy("", (byte) 15, (short) 10);
        f78265i = new iy("", (byte) 11, (short) 12);
        f78266j = new iy("", (byte) 2, (short) 13);
    }

    public ia() {
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
        this.f626a = new BitSet(2);
        this.f628a = true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(ia iaVar) {
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
        int a11;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, iaVar)) == null) {
            if (ia.class.equals(iaVar.getClass())) {
                int compareTo = Boolean.valueOf(m449a()).compareTo(Boolean.valueOf(iaVar.m449a()));
                if (compareTo != 0) {
                    return compareTo;
                }
                if (!m449a() || (a11 = ir.a(this.f624a, iaVar.f624a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m451b()).compareTo(Boolean.valueOf(iaVar.m451b()));
                    if (compareTo2 != 0) {
                        return compareTo2;
                    }
                    if (!m451b() || (a10 = ir.a(this.f625a, iaVar.f625a)) == 0) {
                        int compareTo3 = Boolean.valueOf(m452c()).compareTo(Boolean.valueOf(iaVar.m452c()));
                        if (compareTo3 != 0) {
                            return compareTo3;
                        }
                        if (!m452c() || (a9 = ir.a(this.f629b, iaVar.f629b)) == 0) {
                            int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(iaVar.d()));
                            if (compareTo4 != 0) {
                                return compareTo4;
                            }
                            if (!d() || (a8 = ir.a(this.f630c, iaVar.f630c)) == 0) {
                                int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(iaVar.e()));
                                if (compareTo5 != 0) {
                                    return compareTo5;
                                }
                                if (!e() || (a7 = ir.a(this.f623a, iaVar.f623a)) == 0) {
                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(iaVar.f()));
                                    if (compareTo6 != 0) {
                                        return compareTo6;
                                    }
                                    if (!f() || (a6 = ir.a(this.f631d, iaVar.f631d)) == 0) {
                                        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(iaVar.g()));
                                        if (compareTo7 != 0) {
                                            return compareTo7;
                                        }
                                        if (!g() || (a5 = ir.a(this.f632e, iaVar.f632e)) == 0) {
                                            int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(iaVar.h()));
                                            if (compareTo8 != 0) {
                                                return compareTo8;
                                            }
                                            if (!h() || (a4 = ir.a(this.f627a, iaVar.f627a)) == 0) {
                                                int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(iaVar.i()));
                                                if (compareTo9 != 0) {
                                                    return compareTo9;
                                                }
                                                if (!i() || (a3 = ir.a(this.f633f, iaVar.f633f)) == 0) {
                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(iaVar.j()));
                                                    if (compareTo10 != 0) {
                                                        return compareTo10;
                                                    }
                                                    if (!j() || (a2 = ir.a(this.f628a, iaVar.f628a)) == 0) {
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
                return a11;
            }
            return ia.class.getName().compareTo(iaVar.getClass().getName());
        }
        return invokeL.intValue;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f625a : (String) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public List<String> m447a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f627a : (List) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m448a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.f625a == null) {
                throw new jc("Required field 'id' was not present! Struct: " + toString());
            } else if (this.f629b == null) {
                throw new jc("Required field 'appId' was not present! Struct: " + toString());
            } else if (this.f630c != null) {
            } else {
                throw new jc("Required field 'cmdName' was not present! Struct: " + toString());
            }
        }
    }

    @Override // com.xiaomi.push.iq
    public void a(jb jbVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(1048580, this, jbVar) != null) {
            return;
        }
        jbVar.m527a();
        while (true) {
            iy m523a = jbVar.m523a();
            byte b2 = m523a.f78390a;
            if (b2 == 0) {
                jbVar.f();
                if (e()) {
                    m448a();
                    return;
                }
                throw new jc("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
            }
            switch (m523a.f814a) {
                case 2:
                    if (b2 == 12) {
                        hu huVar = new hu();
                        this.f624a = huVar;
                        huVar.a(jbVar);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f625a = jbVar.m528a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f629b = jbVar.m528a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 5:
                    if (b2 == 11) {
                        this.f630c = jbVar.m528a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 7:
                    if (b2 == 10) {
                        this.f623a = jbVar.m522a();
                        a(true);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 8:
                    if (b2 == 11) {
                        this.f631d = jbVar.m528a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 9:
                    if (b2 == 11) {
                        this.f632e = jbVar.m528a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 10:
                    if (b2 == 15) {
                        iz m524a = jbVar.m524a();
                        this.f627a = new ArrayList(m524a.f815a);
                        for (int i2 = 0; i2 < m524a.f815a; i2++) {
                            this.f627a.add(jbVar.m528a());
                        }
                        jbVar.i();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 12:
                    if (b2 == 11) {
                        this.f633f = jbVar.m528a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 13:
                    if (b2 == 2) {
                        this.f628a = jbVar.m532a();
                        b(true);
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
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.f626a.set(0, z);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m449a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f624a != null : invokeV.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m450a(ia iaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, iaVar)) == null) {
            if (iaVar == null) {
                return false;
            }
            boolean m449a = m449a();
            boolean m449a2 = iaVar.m449a();
            if ((m449a || m449a2) && !(m449a && m449a2 && this.f624a.m422a(iaVar.f624a))) {
                return false;
            }
            boolean m451b = m451b();
            boolean m451b2 = iaVar.m451b();
            if ((m451b || m451b2) && !(m451b && m451b2 && this.f625a.equals(iaVar.f625a))) {
                return false;
            }
            boolean m452c = m452c();
            boolean m452c2 = iaVar.m452c();
            if ((m452c || m452c2) && !(m452c && m452c2 && this.f629b.equals(iaVar.f629b))) {
                return false;
            }
            boolean d2 = d();
            boolean d3 = iaVar.d();
            if (((d2 || d3) && !(d2 && d3 && this.f630c.equals(iaVar.f630c))) || this.f623a != iaVar.f623a) {
                return false;
            }
            boolean f2 = f();
            boolean f3 = iaVar.f();
            if ((f2 || f3) && !(f2 && f3 && this.f631d.equals(iaVar.f631d))) {
                return false;
            }
            boolean g2 = g();
            boolean g3 = iaVar.g();
            if ((g2 || g3) && !(g2 && g3 && this.f632e.equals(iaVar.f632e))) {
                return false;
            }
            boolean h2 = h();
            boolean h3 = iaVar.h();
            if ((h2 || h3) && !(h2 && h3 && this.f627a.equals(iaVar.f627a))) {
                return false;
            }
            boolean i2 = i();
            boolean i3 = iaVar.i();
            if ((i2 || i3) && !(i2 && i3 && this.f633f.equals(iaVar.f633f))) {
                return false;
            }
            boolean j2 = j();
            boolean j3 = iaVar.j();
            if (j2 || j3) {
                return j2 && j3 && this.f628a == iaVar.f628a;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f630c : (String) invokeV.objValue;
    }

    @Override // com.xiaomi.push.iq
    public void b(jb jbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, jbVar) == null) {
            m448a();
            jbVar.a(f622a);
            if (this.f624a != null && m449a()) {
                jbVar.a(f78257a);
                this.f624a.b(jbVar);
                jbVar.b();
            }
            if (this.f625a != null) {
                jbVar.a(f78258b);
                jbVar.a(this.f625a);
                jbVar.b();
            }
            if (this.f629b != null) {
                jbVar.a(f78259c);
                jbVar.a(this.f629b);
                jbVar.b();
            }
            if (this.f630c != null) {
                jbVar.a(f78260d);
                jbVar.a(this.f630c);
                jbVar.b();
            }
            jbVar.a(f78261e);
            jbVar.a(this.f623a);
            jbVar.b();
            if (this.f631d != null && f()) {
                jbVar.a(f78262f);
                jbVar.a(this.f631d);
                jbVar.b();
            }
            if (this.f632e != null && g()) {
                jbVar.a(f78263g);
                jbVar.a(this.f632e);
                jbVar.b();
            }
            if (this.f627a != null && h()) {
                jbVar.a(f78264h);
                jbVar.a(new iz((byte) 11, this.f627a.size()));
                for (String str : this.f627a) {
                    jbVar.a(str);
                }
                jbVar.e();
                jbVar.b();
            }
            if (this.f633f != null && i()) {
                jbVar.a(f78265i);
                jbVar.a(this.f633f);
                jbVar.b();
            }
            if (j()) {
                jbVar.a(f78266j);
                jbVar.a(this.f628a);
                jbVar.b();
            }
            jbVar.c();
            jbVar.m531a();
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.f626a.set(1, z);
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m451b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f625a != null : invokeV.booleanValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f633f : (String) invokeV.objValue;
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m452c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f629b != null : invokeV.booleanValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f630c != null : invokeV.booleanValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f626a.get(0) : invokeV.booleanValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, obj)) == null) {
            if (obj != null && (obj instanceof ia)) {
                return m450a((ia) obj);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f631d != null : invokeV.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f632e != null : invokeV.booleanValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f627a != null : invokeV.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.f633f != null : invokeV.booleanValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.f626a.get(1) : invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            StringBuilder sb = new StringBuilder("XmPushActionCommandResult(");
            if (m449a()) {
                sb.append("target:");
                hu huVar = this.f624a;
                if (huVar == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(huVar);
                }
                z = false;
            } else {
                z = true;
            }
            if (!z) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            }
            sb.append("id:");
            String str = this.f625a;
            if (str == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str);
            }
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("appId:");
            String str2 = this.f629b;
            if (str2 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str2);
            }
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("cmdName:");
            String str3 = this.f630c;
            if (str3 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str3);
            }
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("errorCode:");
            sb.append(this.f623a);
            if (f()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("reason:");
                String str4 = this.f631d;
                if (str4 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str4);
                }
            }
            if (g()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("packageName:");
                String str5 = this.f632e;
                if (str5 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str5);
                }
            }
            if (h()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("cmdArgs:");
                List<String> list = this.f627a;
                if (list == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(list);
                }
            }
            if (i()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("category:");
                String str6 = this.f633f;
                if (str6 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str6);
                }
            }
            if (j()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("response2Client:");
                sb.append(this.f628a);
            }
            sb.append(SmallTailInfo.EMOTION_SUFFIX);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
