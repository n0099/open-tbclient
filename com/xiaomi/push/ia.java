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
/* loaded from: classes4.dex */
public class ia implements iq<ia, Object>, Serializable, Cloneable {
    public static /* synthetic */ Interceptable $ic;
    public static final iy a;

    /* renamed from: a  reason: collision with other field name */
    public static final jg f623a;

    /* renamed from: b  reason: collision with root package name */
    public static final iy f61323b;

    /* renamed from: c  reason: collision with root package name */
    public static final iy f61324c;

    /* renamed from: d  reason: collision with root package name */
    public static final iy f61325d;

    /* renamed from: e  reason: collision with root package name */
    public static final iy f61326e;

    /* renamed from: f  reason: collision with root package name */
    public static final iy f61327f;

    /* renamed from: g  reason: collision with root package name */
    public static final iy f61328g;

    /* renamed from: h  reason: collision with root package name */
    public static final iy f61329h;

    /* renamed from: i  reason: collision with root package name */
    public static final iy f61330i;

    /* renamed from: j  reason: collision with root package name */
    public static final iy f61331j;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public long f624a;

    /* renamed from: a  reason: collision with other field name */
    public hu f625a;

    /* renamed from: a  reason: collision with other field name */
    public String f626a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f627a;

    /* renamed from: a  reason: collision with other field name */
    public List<String> f628a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f629a;

    /* renamed from: b  reason: collision with other field name */
    public String f630b;

    /* renamed from: c  reason: collision with other field name */
    public String f631c;

    /* renamed from: d  reason: collision with other field name */
    public String f632d;

    /* renamed from: e  reason: collision with other field name */
    public String f633e;

    /* renamed from: f  reason: collision with other field name */
    public String f634f;

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
        f623a = new jg("XmPushActionCommandResult");
        a = new iy("", StandardMessageCodec.LIST, (short) 2);
        f61323b = new iy("", (byte) 11, (short) 3);
        f61324c = new iy("", (byte) 11, (short) 4);
        f61325d = new iy("", (byte) 11, (short) 5);
        f61326e = new iy("", (byte) 10, (short) 7);
        f61327f = new iy("", (byte) 11, (short) 8);
        f61328g = new iy("", (byte) 11, (short) 9);
        f61329h = new iy("", (byte) 15, (short) 10);
        f61330i = new iy("", (byte) 11, (short) 12);
        f61331j = new iy("", (byte) 2, (short) 13);
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
        this.f627a = new BitSet(2);
        this.f629a = true;
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
                int compareTo = Boolean.valueOf(m510a()).compareTo(Boolean.valueOf(iaVar.m510a()));
                if (compareTo != 0) {
                    return compareTo;
                }
                if (!m510a() || (a11 = ir.a(this.f625a, iaVar.f625a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m512b()).compareTo(Boolean.valueOf(iaVar.m512b()));
                    if (compareTo2 != 0) {
                        return compareTo2;
                    }
                    if (!m512b() || (a10 = ir.a(this.f626a, iaVar.f626a)) == 0) {
                        int compareTo3 = Boolean.valueOf(m513c()).compareTo(Boolean.valueOf(iaVar.m513c()));
                        if (compareTo3 != 0) {
                            return compareTo3;
                        }
                        if (!m513c() || (a9 = ir.a(this.f630b, iaVar.f630b)) == 0) {
                            int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(iaVar.d()));
                            if (compareTo4 != 0) {
                                return compareTo4;
                            }
                            if (!d() || (a8 = ir.a(this.f631c, iaVar.f631c)) == 0) {
                                int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(iaVar.e()));
                                if (compareTo5 != 0) {
                                    return compareTo5;
                                }
                                if (!e() || (a7 = ir.a(this.f624a, iaVar.f624a)) == 0) {
                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(iaVar.f()));
                                    if (compareTo6 != 0) {
                                        return compareTo6;
                                    }
                                    if (!f() || (a6 = ir.a(this.f632d, iaVar.f632d)) == 0) {
                                        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(iaVar.g()));
                                        if (compareTo7 != 0) {
                                            return compareTo7;
                                        }
                                        if (!g() || (a5 = ir.a(this.f633e, iaVar.f633e)) == 0) {
                                            int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(iaVar.h()));
                                            if (compareTo8 != 0) {
                                                return compareTo8;
                                            }
                                            if (!h() || (a4 = ir.a(this.f628a, iaVar.f628a)) == 0) {
                                                int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(iaVar.i()));
                                                if (compareTo9 != 0) {
                                                    return compareTo9;
                                                }
                                                if (!i() || (a3 = ir.a(this.f634f, iaVar.f634f)) == 0) {
                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(iaVar.j()));
                                                    if (compareTo10 != 0) {
                                                        return compareTo10;
                                                    }
                                                    if (!j() || (a2 = ir.a(this.f629a, iaVar.f629a)) == 0) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f626a : (String) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public List<String> m508a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f628a : (List) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m509a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.f626a == null) {
                throw new jc("Required field 'id' was not present! Struct: " + toString());
            } else if (this.f630b == null) {
                throw new jc("Required field 'appId' was not present! Struct: " + toString());
            } else if (this.f631c != null) {
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
        jbVar.m588a();
        while (true) {
            iy m584a = jbVar.m584a();
            byte b2 = m584a.a;
            if (b2 == 0) {
                jbVar.f();
                if (e()) {
                    m509a();
                    return;
                }
                throw new jc("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
            }
            switch (m584a.f815a) {
                case 2:
                    if (b2 == 12) {
                        hu huVar = new hu();
                        this.f625a = huVar;
                        huVar.a(jbVar);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f626a = jbVar.m589a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f630b = jbVar.m589a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 5:
                    if (b2 == 11) {
                        this.f631c = jbVar.m589a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 7:
                    if (b2 == 10) {
                        this.f624a = jbVar.m583a();
                        a(true);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 8:
                    if (b2 == 11) {
                        this.f632d = jbVar.m589a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 9:
                    if (b2 == 11) {
                        this.f633e = jbVar.m589a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 10:
                    if (b2 == 15) {
                        iz m585a = jbVar.m585a();
                        this.f628a = new ArrayList(m585a.f816a);
                        for (int i2 = 0; i2 < m585a.f816a; i2++) {
                            this.f628a.add(jbVar.m589a());
                        }
                        jbVar.i();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 12:
                    if (b2 == 11) {
                        this.f634f = jbVar.m589a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 13:
                    if (b2 == 2) {
                        this.f629a = jbVar.m593a();
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
            this.f627a.set(0, z);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m510a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f625a != null : invokeV.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m511a(ia iaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, iaVar)) == null) {
            if (iaVar == null) {
                return false;
            }
            boolean m510a = m510a();
            boolean m510a2 = iaVar.m510a();
            if ((m510a || m510a2) && !(m510a && m510a2 && this.f625a.m483a(iaVar.f625a))) {
                return false;
            }
            boolean m512b = m512b();
            boolean m512b2 = iaVar.m512b();
            if ((m512b || m512b2) && !(m512b && m512b2 && this.f626a.equals(iaVar.f626a))) {
                return false;
            }
            boolean m513c = m513c();
            boolean m513c2 = iaVar.m513c();
            if ((m513c || m513c2) && !(m513c && m513c2 && this.f630b.equals(iaVar.f630b))) {
                return false;
            }
            boolean d2 = d();
            boolean d3 = iaVar.d();
            if (((d2 || d3) && !(d2 && d3 && this.f631c.equals(iaVar.f631c))) || this.f624a != iaVar.f624a) {
                return false;
            }
            boolean f2 = f();
            boolean f3 = iaVar.f();
            if ((f2 || f3) && !(f2 && f3 && this.f632d.equals(iaVar.f632d))) {
                return false;
            }
            boolean g2 = g();
            boolean g3 = iaVar.g();
            if ((g2 || g3) && !(g2 && g3 && this.f633e.equals(iaVar.f633e))) {
                return false;
            }
            boolean h2 = h();
            boolean h3 = iaVar.h();
            if ((h2 || h3) && !(h2 && h3 && this.f628a.equals(iaVar.f628a))) {
                return false;
            }
            boolean i2 = i();
            boolean i3 = iaVar.i();
            if ((i2 || i3) && !(i2 && i3 && this.f634f.equals(iaVar.f634f))) {
                return false;
            }
            boolean j2 = j();
            boolean j3 = iaVar.j();
            if (j2 || j3) {
                return j2 && j3 && this.f629a == iaVar.f629a;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f631c : (String) invokeV.objValue;
    }

    @Override // com.xiaomi.push.iq
    public void b(jb jbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, jbVar) == null) {
            m509a();
            jbVar.a(f623a);
            if (this.f625a != null && m510a()) {
                jbVar.a(a);
                this.f625a.b(jbVar);
                jbVar.b();
            }
            if (this.f626a != null) {
                jbVar.a(f61323b);
                jbVar.a(this.f626a);
                jbVar.b();
            }
            if (this.f630b != null) {
                jbVar.a(f61324c);
                jbVar.a(this.f630b);
                jbVar.b();
            }
            if (this.f631c != null) {
                jbVar.a(f61325d);
                jbVar.a(this.f631c);
                jbVar.b();
            }
            jbVar.a(f61326e);
            jbVar.a(this.f624a);
            jbVar.b();
            if (this.f632d != null && f()) {
                jbVar.a(f61327f);
                jbVar.a(this.f632d);
                jbVar.b();
            }
            if (this.f633e != null && g()) {
                jbVar.a(f61328g);
                jbVar.a(this.f633e);
                jbVar.b();
            }
            if (this.f628a != null && h()) {
                jbVar.a(f61329h);
                jbVar.a(new iz((byte) 11, this.f628a.size()));
                for (String str : this.f628a) {
                    jbVar.a(str);
                }
                jbVar.e();
                jbVar.b();
            }
            if (this.f634f != null && i()) {
                jbVar.a(f61330i);
                jbVar.a(this.f634f);
                jbVar.b();
            }
            if (j()) {
                jbVar.a(f61331j);
                jbVar.a(this.f629a);
                jbVar.b();
            }
            jbVar.c();
            jbVar.m592a();
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.f627a.set(1, z);
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m512b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f626a != null : invokeV.booleanValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f634f : (String) invokeV.objValue;
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m513c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f630b != null : invokeV.booleanValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f631c != null : invokeV.booleanValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f627a.get(0) : invokeV.booleanValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, obj)) == null) {
            if (obj != null && (obj instanceof ia)) {
                return m511a((ia) obj);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f632d != null : invokeV.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f633e != null : invokeV.booleanValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f628a != null : invokeV.booleanValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.f634f != null : invokeV.booleanValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.f627a.get(1) : invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            StringBuilder sb = new StringBuilder("XmPushActionCommandResult(");
            if (m510a()) {
                sb.append("target:");
                hu huVar = this.f625a;
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
            String str = this.f626a;
            if (str == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str);
            }
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("appId:");
            String str2 = this.f630b;
            if (str2 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str2);
            }
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("cmdName:");
            String str3 = this.f631c;
            if (str3 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str3);
            }
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("errorCode:");
            sb.append(this.f624a);
            if (f()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("reason:");
                String str4 = this.f632d;
                if (str4 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str4);
                }
            }
            if (g()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("packageName:");
                String str5 = this.f633e;
                if (str5 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str5);
                }
            }
            if (h()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("cmdArgs:");
                List<String> list = this.f628a;
                if (list == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(list);
                }
            }
            if (i()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("category:");
                String str6 = this.f634f;
                if (str6 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str6);
                }
            }
            if (j()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("response2Client:");
                sb.append(this.f629a);
            }
            sb.append(SmallTailInfo.EMOTION_SUFFIX);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
