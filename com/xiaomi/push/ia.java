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
/* loaded from: classes8.dex */
public class ia implements iq<ia, Object>, Serializable, Cloneable {
    public static /* synthetic */ Interceptable $ic;
    public static final iy a;

    /* renamed from: a  reason: collision with other field name */
    public static final jg f599a;
    public static final iy b;
    public static final iy c;
    public static final iy d;
    public static final iy e;
    public static final iy f;
    public static final iy g;
    public static final iy h;
    public static final iy i;
    public static final iy j;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public long f600a;

    /* renamed from: a  reason: collision with other field name */
    public hu f601a;

    /* renamed from: a  reason: collision with other field name */
    public String f602a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f603a;

    /* renamed from: a  reason: collision with other field name */
    public List<String> f604a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f605a;

    /* renamed from: b  reason: collision with other field name */
    public String f606b;

    /* renamed from: c  reason: collision with other field name */
    public String f607c;

    /* renamed from: d  reason: collision with other field name */
    public String f608d;

    /* renamed from: e  reason: collision with other field name */
    public String f609e;

    /* renamed from: f  reason: collision with other field name */
    public String f610f;

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
        f599a = new jg("XmPushActionCommandResult");
        a = new iy("", (byte) 12, (short) 2);
        b = new iy("", Constants.GZIP_CAST_TYPE, (short) 3);
        c = new iy("", Constants.GZIP_CAST_TYPE, (short) 4);
        d = new iy("", Constants.GZIP_CAST_TYPE, (short) 5);
        e = new iy("", (byte) 10, (short) 7);
        f = new iy("", Constants.GZIP_CAST_TYPE, (short) 8);
        g = new iy("", Constants.GZIP_CAST_TYPE, (short) 9);
        h = new iy("", (byte) 15, (short) 10);
        i = new iy("", Constants.GZIP_CAST_TYPE, (short) 12);
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
        this.f603a = new BitSet(2);
        this.f605a = true;
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
                int compareTo = Boolean.valueOf(m484a()).compareTo(Boolean.valueOf(iaVar.m484a()));
                if (compareTo != 0) {
                    return compareTo;
                }
                if (!m484a() || (a11 = ir.a(this.f601a, iaVar.f601a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m486b()).compareTo(Boolean.valueOf(iaVar.m486b()));
                    if (compareTo2 != 0) {
                        return compareTo2;
                    }
                    if (!m486b() || (a10 = ir.a(this.f602a, iaVar.f602a)) == 0) {
                        int compareTo3 = Boolean.valueOf(m487c()).compareTo(Boolean.valueOf(iaVar.m487c()));
                        if (compareTo3 != 0) {
                            return compareTo3;
                        }
                        if (!m487c() || (a9 = ir.a(this.f606b, iaVar.f606b)) == 0) {
                            int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(iaVar.d()));
                            if (compareTo4 != 0) {
                                return compareTo4;
                            }
                            if (!d() || (a8 = ir.a(this.f607c, iaVar.f607c)) == 0) {
                                int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(iaVar.e()));
                                if (compareTo5 != 0) {
                                    return compareTo5;
                                }
                                if (!e() || (a7 = ir.a(this.f600a, iaVar.f600a)) == 0) {
                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(iaVar.f()));
                                    if (compareTo6 != 0) {
                                        return compareTo6;
                                    }
                                    if (!f() || (a6 = ir.a(this.f608d, iaVar.f608d)) == 0) {
                                        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(iaVar.g()));
                                        if (compareTo7 != 0) {
                                            return compareTo7;
                                        }
                                        if (!g() || (a5 = ir.a(this.f609e, iaVar.f609e)) == 0) {
                                            int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(iaVar.h()));
                                            if (compareTo8 != 0) {
                                                return compareTo8;
                                            }
                                            if (!h() || (a4 = ir.a(this.f604a, iaVar.f604a)) == 0) {
                                                int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(iaVar.i()));
                                                if (compareTo9 != 0) {
                                                    return compareTo9;
                                                }
                                                if (!i() || (a3 = ir.a(this.f610f, iaVar.f610f)) == 0) {
                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(iaVar.j()));
                                                    if (compareTo10 != 0) {
                                                        return compareTo10;
                                                    }
                                                    if (!j() || (a2 = ir.a(this.f605a, iaVar.f605a)) == 0) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f602a : (String) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public List<String> m482a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f604a : (List) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m483a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.f602a == null) {
                throw new jc("Required field 'id' was not present! Struct: " + toString());
            } else if (this.f606b == null) {
                throw new jc("Required field 'appId' was not present! Struct: " + toString());
            } else if (this.f607c != null) {
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
        jbVar.m562a();
        while (true) {
            iy m558a = jbVar.m558a();
            byte b2 = m558a.a;
            if (b2 == 0) {
                jbVar.f();
                if (e()) {
                    m483a();
                    return;
                }
                throw new jc("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
            }
            switch (m558a.f791a) {
                case 2:
                    if (b2 == 12) {
                        hu huVar = new hu();
                        this.f601a = huVar;
                        huVar.a(jbVar);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f602a = jbVar.m563a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f606b = jbVar.m563a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 5:
                    if (b2 == 11) {
                        this.f607c = jbVar.m563a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 7:
                    if (b2 == 10) {
                        this.f600a = jbVar.m557a();
                        a(true);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 8:
                    if (b2 == 11) {
                        this.f608d = jbVar.m563a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 9:
                    if (b2 == 11) {
                        this.f609e = jbVar.m563a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 10:
                    if (b2 == 15) {
                        iz m559a = jbVar.m559a();
                        this.f604a = new ArrayList(m559a.f792a);
                        for (int i2 = 0; i2 < m559a.f792a; i2++) {
                            this.f604a.add(jbVar.m563a());
                        }
                        jbVar.i();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 12:
                    if (b2 == 11) {
                        this.f610f = jbVar.m563a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 13:
                    if (b2 == 2) {
                        this.f605a = jbVar.m567a();
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
            this.f603a.set(0, z);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m484a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f601a != null : invokeV.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m485a(ia iaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, iaVar)) == null) {
            if (iaVar == null) {
                return false;
            }
            boolean m484a = m484a();
            boolean m484a2 = iaVar.m484a();
            if ((m484a || m484a2) && !(m484a && m484a2 && this.f601a.m457a(iaVar.f601a))) {
                return false;
            }
            boolean m486b = m486b();
            boolean m486b2 = iaVar.m486b();
            if ((m486b || m486b2) && !(m486b && m486b2 && this.f602a.equals(iaVar.f602a))) {
                return false;
            }
            boolean m487c = m487c();
            boolean m487c2 = iaVar.m487c();
            if ((m487c || m487c2) && !(m487c && m487c2 && this.f606b.equals(iaVar.f606b))) {
                return false;
            }
            boolean d2 = d();
            boolean d3 = iaVar.d();
            if (((d2 || d3) && !(d2 && d3 && this.f607c.equals(iaVar.f607c))) || this.f600a != iaVar.f600a) {
                return false;
            }
            boolean f2 = f();
            boolean f3 = iaVar.f();
            if ((f2 || f3) && !(f2 && f3 && this.f608d.equals(iaVar.f608d))) {
                return false;
            }
            boolean g2 = g();
            boolean g3 = iaVar.g();
            if ((g2 || g3) && !(g2 && g3 && this.f609e.equals(iaVar.f609e))) {
                return false;
            }
            boolean h2 = h();
            boolean h3 = iaVar.h();
            if ((h2 || h3) && !(h2 && h3 && this.f604a.equals(iaVar.f604a))) {
                return false;
            }
            boolean i2 = i();
            boolean i3 = iaVar.i();
            if ((i2 || i3) && !(i2 && i3 && this.f610f.equals(iaVar.f610f))) {
                return false;
            }
            boolean j2 = j();
            boolean j3 = iaVar.j();
            if (j2 || j3) {
                return j2 && j3 && this.f605a == iaVar.f605a;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f607c : (String) invokeV.objValue;
    }

    @Override // com.xiaomi.push.iq
    public void b(jb jbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, jbVar) == null) {
            m483a();
            jbVar.a(f599a);
            if (this.f601a != null && m484a()) {
                jbVar.a(a);
                this.f601a.b(jbVar);
                jbVar.b();
            }
            if (this.f602a != null) {
                jbVar.a(b);
                jbVar.a(this.f602a);
                jbVar.b();
            }
            if (this.f606b != null) {
                jbVar.a(c);
                jbVar.a(this.f606b);
                jbVar.b();
            }
            if (this.f607c != null) {
                jbVar.a(d);
                jbVar.a(this.f607c);
                jbVar.b();
            }
            jbVar.a(e);
            jbVar.a(this.f600a);
            jbVar.b();
            if (this.f608d != null && f()) {
                jbVar.a(f);
                jbVar.a(this.f608d);
                jbVar.b();
            }
            if (this.f609e != null && g()) {
                jbVar.a(g);
                jbVar.a(this.f609e);
                jbVar.b();
            }
            if (this.f604a != null && h()) {
                jbVar.a(h);
                jbVar.a(new iz(Constants.GZIP_CAST_TYPE, this.f604a.size()));
                for (String str : this.f604a) {
                    jbVar.a(str);
                }
                jbVar.e();
                jbVar.b();
            }
            if (this.f610f != null && i()) {
                jbVar.a(i);
                jbVar.a(this.f610f);
                jbVar.b();
            }
            if (j()) {
                jbVar.a(j);
                jbVar.a(this.f605a);
                jbVar.b();
            }
            jbVar.c();
            jbVar.m566a();
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.f603a.set(1, z);
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m486b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f602a != null : invokeV.booleanValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f610f : (String) invokeV.objValue;
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m487c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f606b != null : invokeV.booleanValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f607c != null : invokeV.booleanValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f603a.get(0) : invokeV.booleanValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, obj)) == null) {
            if (obj != null && (obj instanceof ia)) {
                return m485a((ia) obj);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f608d != null : invokeV.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f609e != null : invokeV.booleanValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f604a != null : invokeV.booleanValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.f610f != null : invokeV.booleanValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.f603a.get(1) : invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            StringBuilder sb = new StringBuilder("XmPushActionCommandResult(");
            if (m484a()) {
                sb.append("target:");
                hu huVar = this.f601a;
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
            String str = this.f602a;
            if (str == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str);
            }
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("appId:");
            String str2 = this.f606b;
            if (str2 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str2);
            }
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("cmdName:");
            String str3 = this.f607c;
            if (str3 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str3);
            }
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("errorCode:");
            sb.append(this.f600a);
            if (f()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("reason:");
                String str4 = this.f608d;
                if (str4 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str4);
                }
            }
            if (g()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("packageName:");
                String str5 = this.f609e;
                if (str5 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str5);
                }
            }
            if (h()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("cmdArgs:");
                List<String> list = this.f604a;
                if (list == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(list);
                }
            }
            if (i()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("category:");
                String str6 = this.f610f;
                if (str6 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str6);
                }
            }
            if (j()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("response2Client:");
                sb.append(this.f605a);
            }
            sb.append(SmallTailInfo.EMOTION_SUFFIX);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
