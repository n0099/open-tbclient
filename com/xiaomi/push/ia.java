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
/* loaded from: classes8.dex */
public class ia implements iq<ia, Object>, Serializable, Cloneable {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final iy f43367a;

    /* renamed from: a  reason: collision with other field name */
    public static final jg f618a;

    /* renamed from: b  reason: collision with root package name */
    public static final iy f43368b;

    /* renamed from: c  reason: collision with root package name */
    public static final iy f43369c;

    /* renamed from: d  reason: collision with root package name */
    public static final iy f43370d;

    /* renamed from: e  reason: collision with root package name */
    public static final iy f43371e;

    /* renamed from: f  reason: collision with root package name */
    public static final iy f43372f;

    /* renamed from: g  reason: collision with root package name */
    public static final iy f43373g;

    /* renamed from: h  reason: collision with root package name */
    public static final iy f43374h;

    /* renamed from: i  reason: collision with root package name */
    public static final iy f43375i;
    public static final iy j;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public long f619a;

    /* renamed from: a  reason: collision with other field name */
    public hu f620a;

    /* renamed from: a  reason: collision with other field name */
    public String f621a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f622a;

    /* renamed from: a  reason: collision with other field name */
    public List<String> f623a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f624a;

    /* renamed from: b  reason: collision with other field name */
    public String f625b;

    /* renamed from: c  reason: collision with other field name */
    public String f626c;

    /* renamed from: d  reason: collision with other field name */
    public String f627d;

    /* renamed from: e  reason: collision with other field name */
    public String f628e;

    /* renamed from: f  reason: collision with other field name */
    public String f629f;

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
        f618a = new jg("XmPushActionCommandResult");
        f43367a = new iy("", StandardMessageCodec.LIST, (short) 2);
        f43368b = new iy("", (byte) 11, (short) 3);
        f43369c = new iy("", (byte) 11, (short) 4);
        f43370d = new iy("", (byte) 11, (short) 5);
        f43371e = new iy("", (byte) 10, (short) 7);
        f43372f = new iy("", (byte) 11, (short) 8);
        f43373g = new iy("", (byte) 11, (short) 9);
        f43374h = new iy("", (byte) 15, (short) 10);
        f43375i = new iy("", (byte) 11, (short) 12);
        j = new iy("", (byte) 2, (short) 13);
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
        this.f622a = new BitSet(2);
        this.f624a = true;
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
                int compareTo = Boolean.valueOf(m446a()).compareTo(Boolean.valueOf(iaVar.m446a()));
                if (compareTo != 0) {
                    return compareTo;
                }
                if (!m446a() || (a11 = ir.a(this.f620a, iaVar.f620a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m448b()).compareTo(Boolean.valueOf(iaVar.m448b()));
                    if (compareTo2 != 0) {
                        return compareTo2;
                    }
                    if (!m448b() || (a10 = ir.a(this.f621a, iaVar.f621a)) == 0) {
                        int compareTo3 = Boolean.valueOf(m449c()).compareTo(Boolean.valueOf(iaVar.m449c()));
                        if (compareTo3 != 0) {
                            return compareTo3;
                        }
                        if (!m449c() || (a9 = ir.a(this.f625b, iaVar.f625b)) == 0) {
                            int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(iaVar.d()));
                            if (compareTo4 != 0) {
                                return compareTo4;
                            }
                            if (!d() || (a8 = ir.a(this.f626c, iaVar.f626c)) == 0) {
                                int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(iaVar.e()));
                                if (compareTo5 != 0) {
                                    return compareTo5;
                                }
                                if (!e() || (a7 = ir.a(this.f619a, iaVar.f619a)) == 0) {
                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(iaVar.f()));
                                    if (compareTo6 != 0) {
                                        return compareTo6;
                                    }
                                    if (!f() || (a6 = ir.a(this.f627d, iaVar.f627d)) == 0) {
                                        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(iaVar.g()));
                                        if (compareTo7 != 0) {
                                            return compareTo7;
                                        }
                                        if (!g() || (a5 = ir.a(this.f628e, iaVar.f628e)) == 0) {
                                            int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(iaVar.h()));
                                            if (compareTo8 != 0) {
                                                return compareTo8;
                                            }
                                            if (!h() || (a4 = ir.a(this.f623a, iaVar.f623a)) == 0) {
                                                int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(iaVar.i()));
                                                if (compareTo9 != 0) {
                                                    return compareTo9;
                                                }
                                                if (!i() || (a3 = ir.a(this.f629f, iaVar.f629f)) == 0) {
                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(iaVar.j()));
                                                    if (compareTo10 != 0) {
                                                        return compareTo10;
                                                    }
                                                    if (!j() || (a2 = ir.a(this.f624a, iaVar.f624a)) == 0) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f621a : (String) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public List<String> m444a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f623a : (List) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m445a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.f621a == null) {
                throw new jc("Required field 'id' was not present! Struct: " + toString());
            } else if (this.f625b == null) {
                throw new jc("Required field 'appId' was not present! Struct: " + toString());
            } else if (this.f626c != null) {
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
        jbVar.m524a();
        while (true) {
            iy m520a = jbVar.m520a();
            byte b2 = m520a.f43494a;
            if (b2 == 0) {
                jbVar.f();
                if (e()) {
                    m445a();
                    return;
                }
                throw new jc("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
            }
            switch (m520a.f810a) {
                case 2:
                    if (b2 == 12) {
                        hu huVar = new hu();
                        this.f620a = huVar;
                        huVar.a(jbVar);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f621a = jbVar.m525a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f625b = jbVar.m525a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 5:
                    if (b2 == 11) {
                        this.f626c = jbVar.m525a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 7:
                    if (b2 == 10) {
                        this.f619a = jbVar.m519a();
                        a(true);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 8:
                    if (b2 == 11) {
                        this.f627d = jbVar.m525a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 9:
                    if (b2 == 11) {
                        this.f628e = jbVar.m525a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 10:
                    if (b2 == 15) {
                        iz m521a = jbVar.m521a();
                        this.f623a = new ArrayList(m521a.f811a);
                        for (int i2 = 0; i2 < m521a.f811a; i2++) {
                            this.f623a.add(jbVar.m525a());
                        }
                        jbVar.i();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 12:
                    if (b2 == 11) {
                        this.f629f = jbVar.m525a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 13:
                    if (b2 == 2) {
                        this.f624a = jbVar.m529a();
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
            this.f622a.set(0, z);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m446a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f620a != null : invokeV.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m447a(ia iaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, iaVar)) == null) {
            if (iaVar == null) {
                return false;
            }
            boolean m446a = m446a();
            boolean m446a2 = iaVar.m446a();
            if ((m446a || m446a2) && !(m446a && m446a2 && this.f620a.m419a(iaVar.f620a))) {
                return false;
            }
            boolean m448b = m448b();
            boolean m448b2 = iaVar.m448b();
            if ((m448b || m448b2) && !(m448b && m448b2 && this.f621a.equals(iaVar.f621a))) {
                return false;
            }
            boolean m449c = m449c();
            boolean m449c2 = iaVar.m449c();
            if ((m449c || m449c2) && !(m449c && m449c2 && this.f625b.equals(iaVar.f625b))) {
                return false;
            }
            boolean d2 = d();
            boolean d3 = iaVar.d();
            if (((d2 || d3) && !(d2 && d3 && this.f626c.equals(iaVar.f626c))) || this.f619a != iaVar.f619a) {
                return false;
            }
            boolean f2 = f();
            boolean f3 = iaVar.f();
            if ((f2 || f3) && !(f2 && f3 && this.f627d.equals(iaVar.f627d))) {
                return false;
            }
            boolean g2 = g();
            boolean g3 = iaVar.g();
            if ((g2 || g3) && !(g2 && g3 && this.f628e.equals(iaVar.f628e))) {
                return false;
            }
            boolean h2 = h();
            boolean h3 = iaVar.h();
            if ((h2 || h3) && !(h2 && h3 && this.f623a.equals(iaVar.f623a))) {
                return false;
            }
            boolean i2 = i();
            boolean i3 = iaVar.i();
            if ((i2 || i3) && !(i2 && i3 && this.f629f.equals(iaVar.f629f))) {
                return false;
            }
            boolean j2 = j();
            boolean j3 = iaVar.j();
            if (j2 || j3) {
                return j2 && j3 && this.f624a == iaVar.f624a;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f626c : (String) invokeV.objValue;
    }

    @Override // com.xiaomi.push.iq
    public void b(jb jbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, jbVar) == null) {
            m445a();
            jbVar.a(f618a);
            if (this.f620a != null && m446a()) {
                jbVar.a(f43367a);
                this.f620a.b(jbVar);
                jbVar.b();
            }
            if (this.f621a != null) {
                jbVar.a(f43368b);
                jbVar.a(this.f621a);
                jbVar.b();
            }
            if (this.f625b != null) {
                jbVar.a(f43369c);
                jbVar.a(this.f625b);
                jbVar.b();
            }
            if (this.f626c != null) {
                jbVar.a(f43370d);
                jbVar.a(this.f626c);
                jbVar.b();
            }
            jbVar.a(f43371e);
            jbVar.a(this.f619a);
            jbVar.b();
            if (this.f627d != null && f()) {
                jbVar.a(f43372f);
                jbVar.a(this.f627d);
                jbVar.b();
            }
            if (this.f628e != null && g()) {
                jbVar.a(f43373g);
                jbVar.a(this.f628e);
                jbVar.b();
            }
            if (this.f623a != null && h()) {
                jbVar.a(f43374h);
                jbVar.a(new iz((byte) 11, this.f623a.size()));
                for (String str : this.f623a) {
                    jbVar.a(str);
                }
                jbVar.e();
                jbVar.b();
            }
            if (this.f629f != null && i()) {
                jbVar.a(f43375i);
                jbVar.a(this.f629f);
                jbVar.b();
            }
            if (j()) {
                jbVar.a(j);
                jbVar.a(this.f624a);
                jbVar.b();
            }
            jbVar.c();
            jbVar.m528a();
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.f622a.set(1, z);
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m448b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f621a != null : invokeV.booleanValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f629f : (String) invokeV.objValue;
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m449c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f625b != null : invokeV.booleanValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f626c != null : invokeV.booleanValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f622a.get(0) : invokeV.booleanValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, obj)) == null) {
            if (obj != null && (obj instanceof ia)) {
                return m447a((ia) obj);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f627d != null : invokeV.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f628e != null : invokeV.booleanValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f623a != null : invokeV.booleanValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.f629f != null : invokeV.booleanValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.f622a.get(1) : invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            StringBuilder sb = new StringBuilder("XmPushActionCommandResult(");
            if (m446a()) {
                sb.append("target:");
                hu huVar = this.f620a;
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
            String str = this.f621a;
            if (str == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str);
            }
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("appId:");
            String str2 = this.f625b;
            if (str2 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str2);
            }
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("cmdName:");
            String str3 = this.f626c;
            if (str3 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str3);
            }
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("errorCode:");
            sb.append(this.f619a);
            if (f()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("reason:");
                String str4 = this.f627d;
                if (str4 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str4);
                }
            }
            if (g()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("packageName:");
                String str5 = this.f628e;
                if (str5 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str5);
                }
            }
            if (h()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("cmdArgs:");
                List<String> list = this.f623a;
                if (list == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(list);
                }
            }
            if (i()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("category:");
                String str6 = this.f629f;
                if (str6 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str6);
                }
            }
            if (j()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("response2Client:");
                sb.append(this.f624a);
            }
            sb.append(SmallTailInfo.EMOTION_SUFFIX);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
