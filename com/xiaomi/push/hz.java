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
import java.util.BitSet;
import java.util.List;
/* loaded from: classes7.dex */
public class hz implements iq<hz, Object>, Serializable, Cloneable {
    public static /* synthetic */ Interceptable $ic;
    public static final iy a;

    /* renamed from: a  reason: collision with other field name */
    public static final jg f585a;

    /* renamed from: b  reason: collision with root package name */
    public static final iy f44408b;

    /* renamed from: c  reason: collision with root package name */
    public static final iy f44409c;

    /* renamed from: d  reason: collision with root package name */
    public static final iy f44410d;

    /* renamed from: e  reason: collision with root package name */
    public static final iy f44411e;

    /* renamed from: f  reason: collision with root package name */
    public static final iy f44412f;

    /* renamed from: g  reason: collision with root package name */
    public static final iy f44413g;

    /* renamed from: h  reason: collision with root package name */
    public static final iy f44414h;
    public static final iy i;
    public static final iy j;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public long f586a;

    /* renamed from: a  reason: collision with other field name */
    public hu f587a;

    /* renamed from: a  reason: collision with other field name */
    public String f588a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f589a;

    /* renamed from: a  reason: collision with other field name */
    public List<String> f590a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f591a;

    /* renamed from: b  reason: collision with other field name */
    public String f592b;

    /* renamed from: b  reason: collision with other field name */
    public boolean f593b;

    /* renamed from: c  reason: collision with other field name */
    public String f594c;

    /* renamed from: d  reason: collision with other field name */
    public String f595d;

    /* renamed from: e  reason: collision with other field name */
    public String f596e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-56372370, "Lcom/xiaomi/push/hz;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-56372370, "Lcom/xiaomi/push/hz;");
                return;
            }
        }
        f585a = new jg("XmPushActionCommand");
        a = new iy("", (byte) 12, (short) 2);
        f44408b = new iy("", Constants.GZIP_CAST_TYPE, (short) 3);
        f44409c = new iy("", Constants.GZIP_CAST_TYPE, (short) 4);
        f44410d = new iy("", Constants.GZIP_CAST_TYPE, (short) 5);
        f44411e = new iy("", (byte) 15, (short) 6);
        f44412f = new iy("", Constants.GZIP_CAST_TYPE, (short) 7);
        f44413g = new iy("", Constants.GZIP_CAST_TYPE, (short) 9);
        f44414h = new iy("", (byte) 2, (short) 10);
        i = new iy("", (byte) 2, (short) 11);
        j = new iy("", (byte) 10, (short) 12);
    }

    public hz() {
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
        this.f589a = new BitSet(3);
        this.f591a = false;
        this.f593b = true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(hz hzVar) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, hzVar)) == null) {
            if (hz.class.equals(hzVar.getClass())) {
                int compareTo = Boolean.valueOf(m475a()).compareTo(Boolean.valueOf(hzVar.m475a()));
                if (compareTo != 0) {
                    return compareTo;
                }
                if (!m475a() || (a11 = ir.a(this.f587a, hzVar.f587a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(hzVar.b()));
                    if (compareTo2 != 0) {
                        return compareTo2;
                    }
                    if (!b() || (a10 = ir.a(this.f588a, hzVar.f588a)) == 0) {
                        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(hzVar.c()));
                        if (compareTo3 != 0) {
                            return compareTo3;
                        }
                        if (!c() || (a9 = ir.a(this.f592b, hzVar.f592b)) == 0) {
                            int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hzVar.d()));
                            if (compareTo4 != 0) {
                                return compareTo4;
                            }
                            if (!d() || (a8 = ir.a(this.f594c, hzVar.f594c)) == 0) {
                                int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hzVar.e()));
                                if (compareTo5 != 0) {
                                    return compareTo5;
                                }
                                if (!e() || (a7 = ir.a(this.f590a, hzVar.f590a)) == 0) {
                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hzVar.f()));
                                    if (compareTo6 != 0) {
                                        return compareTo6;
                                    }
                                    if (!f() || (a6 = ir.a(this.f595d, hzVar.f595d)) == 0) {
                                        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hzVar.g()));
                                        if (compareTo7 != 0) {
                                            return compareTo7;
                                        }
                                        if (!g() || (a5 = ir.a(this.f596e, hzVar.f596e)) == 0) {
                                            int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hzVar.h()));
                                            if (compareTo8 != 0) {
                                                return compareTo8;
                                            }
                                            if (!h() || (a4 = ir.a(this.f591a, hzVar.f591a)) == 0) {
                                                int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hzVar.i()));
                                                if (compareTo9 != 0) {
                                                    return compareTo9;
                                                }
                                                if (!i() || (a3 = ir.a(this.f593b, hzVar.f593b)) == 0) {
                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(hzVar.j()));
                                                    if (compareTo10 != 0) {
                                                        return compareTo10;
                                                    }
                                                    if (!j() || (a2 = ir.a(this.f586a, hzVar.f586a)) == 0) {
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
            return hz.class.getName().compareTo(hzVar.getClass().getName());
        }
        return invokeL.intValue;
    }

    public hz a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            this.f588a = str;
            return this;
        }
        return (hz) invokeL.objValue;
    }

    public hz a(List<String> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list)) == null) {
            this.f590a = list;
            return this;
        }
        return (hz) invokeL.objValue;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f594c : (String) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m473a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (this.f588a == null) {
                throw new jc("Required field 'id' was not present! Struct: " + toString());
            } else if (this.f592b == null) {
                throw new jc("Required field 'appId' was not present! Struct: " + toString());
            } else if (this.f594c != null) {
            } else {
                throw new jc("Required field 'cmdName' was not present! Struct: " + toString());
            }
        }
    }

    @Override // com.xiaomi.push.iq
    public void a(jb jbVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(1048581, this, jbVar) != null) {
            return;
        }
        jbVar.m566a();
        while (true) {
            iy m562a = jbVar.m562a();
            byte b2 = m562a.a;
            if (b2 == 0) {
                jbVar.f();
                m473a();
                return;
            }
            switch (m562a.f791a) {
                case 2:
                    if (b2 == 12) {
                        hu huVar = new hu();
                        this.f587a = huVar;
                        huVar.a(jbVar);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f588a = jbVar.m567a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f592b = jbVar.m567a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 5:
                    if (b2 == 11) {
                        this.f594c = jbVar.m567a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 6:
                    if (b2 == 15) {
                        iz m563a = jbVar.m563a();
                        this.f590a = new ArrayList(m563a.f792a);
                        for (int i2 = 0; i2 < m563a.f792a; i2++) {
                            this.f590a.add(jbVar.m567a());
                        }
                        jbVar.i();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f595d = jbVar.m567a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 9:
                    if (b2 == 11) {
                        this.f596e = jbVar.m567a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 10:
                    if (b2 == 2) {
                        this.f591a = jbVar.m571a();
                        a(true);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 11:
                    if (b2 == 2) {
                        this.f593b = jbVar.m571a();
                        b(true);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 12:
                    if (b2 == 10) {
                        this.f586a = jbVar.m561a();
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

    /* renamed from: a  reason: collision with other method in class */
    public void m474a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            if (this.f590a == null) {
                this.f590a = new ArrayList();
            }
            this.f590a.add(str);
        }
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.f589a.set(0, z);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m475a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f587a != null : invokeV.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m476a(hz hzVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, hzVar)) == null) {
            if (hzVar == null) {
                return false;
            }
            boolean m475a = m475a();
            boolean m475a2 = hzVar.m475a();
            if ((m475a || m475a2) && !(m475a && m475a2 && this.f587a.m461a(hzVar.f587a))) {
                return false;
            }
            boolean b2 = b();
            boolean b3 = hzVar.b();
            if ((b2 || b3) && !(b2 && b3 && this.f588a.equals(hzVar.f588a))) {
                return false;
            }
            boolean c2 = c();
            boolean c3 = hzVar.c();
            if ((c2 || c3) && !(c2 && c3 && this.f592b.equals(hzVar.f592b))) {
                return false;
            }
            boolean d2 = d();
            boolean d3 = hzVar.d();
            if ((d2 || d3) && !(d2 && d3 && this.f594c.equals(hzVar.f594c))) {
                return false;
            }
            boolean e2 = e();
            boolean e3 = hzVar.e();
            if ((e2 || e3) && !(e2 && e3 && this.f590a.equals(hzVar.f590a))) {
                return false;
            }
            boolean f2 = f();
            boolean f3 = hzVar.f();
            if ((f2 || f3) && !(f2 && f3 && this.f595d.equals(hzVar.f595d))) {
                return false;
            }
            boolean g2 = g();
            boolean g3 = hzVar.g();
            if ((g2 || g3) && !(g2 && g3 && this.f596e.equals(hzVar.f596e))) {
                return false;
            }
            boolean h2 = h();
            boolean h3 = hzVar.h();
            if ((h2 || h3) && !(h2 && h3 && this.f591a == hzVar.f591a)) {
                return false;
            }
            boolean i2 = i();
            boolean i3 = hzVar.i();
            if ((i2 || i3) && !(i2 && i3 && this.f593b == hzVar.f593b)) {
                return false;
            }
            boolean j2 = j();
            boolean j3 = hzVar.j();
            if (j2 || j3) {
                return j2 && j3 && this.f586a == hzVar.f586a;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public hz b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            this.f592b = str;
            return this;
        }
        return (hz) invokeL.objValue;
    }

    @Override // com.xiaomi.push.iq
    public void b(jb jbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, jbVar) == null) {
            m473a();
            jbVar.a(f585a);
            if (this.f587a != null && m475a()) {
                jbVar.a(a);
                this.f587a.b(jbVar);
                jbVar.b();
            }
            if (this.f588a != null) {
                jbVar.a(f44408b);
                jbVar.a(this.f588a);
                jbVar.b();
            }
            if (this.f592b != null) {
                jbVar.a(f44409c);
                jbVar.a(this.f592b);
                jbVar.b();
            }
            if (this.f594c != null) {
                jbVar.a(f44410d);
                jbVar.a(this.f594c);
                jbVar.b();
            }
            if (this.f590a != null && e()) {
                jbVar.a(f44411e);
                jbVar.a(new iz(Constants.GZIP_CAST_TYPE, this.f590a.size()));
                for (String str : this.f590a) {
                    jbVar.a(str);
                }
                jbVar.e();
                jbVar.b();
            }
            if (this.f595d != null && f()) {
                jbVar.a(f44412f);
                jbVar.a(this.f595d);
                jbVar.b();
            }
            if (this.f596e != null && g()) {
                jbVar.a(f44413g);
                jbVar.a(this.f596e);
                jbVar.b();
            }
            if (h()) {
                jbVar.a(f44414h);
                jbVar.a(this.f591a);
                jbVar.b();
            }
            if (i()) {
                jbVar.a(i);
                jbVar.a(this.f593b);
                jbVar.b();
            }
            if (j()) {
                jbVar.a(j);
                jbVar.a(this.f586a);
                jbVar.b();
            }
            jbVar.c();
            jbVar.m570a();
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.f589a.set(1, z);
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f588a != null : invokeV.booleanValue;
    }

    public hz c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
            this.f594c = str;
            return this;
        }
        return (hz) invokeL.objValue;
    }

    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.f589a.set(2, z);
        }
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f592b != null : invokeV.booleanValue;
    }

    public hz d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, str)) == null) {
            this.f595d = str;
            return this;
        }
        return (hz) invokeL.objValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f594c != null : invokeV.booleanValue;
    }

    public hz e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, str)) == null) {
            this.f596e = str;
            return this;
        }
        return (hz) invokeL.objValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.f590a != null : invokeV.booleanValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, obj)) == null) {
            if (obj != null && (obj instanceof hz)) {
                return m476a((hz) obj);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.f595d != null : invokeV.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.f596e != null : invokeV.booleanValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.f589a.get(0) : invokeV.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.f589a.get(1) : invokeV.booleanValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.f589a.get(2) : invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            StringBuilder sb = new StringBuilder("XmPushActionCommand(");
            if (m475a()) {
                sb.append("target:");
                hu huVar = this.f587a;
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
            String str = this.f588a;
            if (str == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str);
            }
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("appId:");
            String str2 = this.f592b;
            if (str2 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str2);
            }
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("cmdName:");
            String str3 = this.f594c;
            if (str3 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str3);
            }
            if (e()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("cmdArgs:");
                List<String> list = this.f590a;
                if (list == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(list);
                }
            }
            if (f()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("packageName:");
                String str4 = this.f595d;
                if (str4 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str4);
                }
            }
            if (g()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("category:");
                String str5 = this.f596e;
                if (str5 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str5);
                }
            }
            if (h()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("updateCache:");
                sb.append(this.f591a);
            }
            if (i()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("response2Client:");
                sb.append(this.f593b);
            }
            if (j()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("createdTs:");
                sb.append(this.f586a);
            }
            sb.append(SmallTailInfo.EMOTION_SUFFIX);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
