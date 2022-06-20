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
public class ie implements iu<ie, Object>, Serializable, Cloneable {
    public static /* synthetic */ Interceptable $ic;
    public static final jc a;

    /* renamed from: a  reason: collision with other field name */
    public static final jk f605a;
    public static final jc b;
    public static final jc c;
    public static final jc d;
    public static final jc e;
    public static final jc f;
    public static final jc g;
    public static final jc h;
    public static final jc i;
    public static final jc j;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public long f606a;

    /* renamed from: a  reason: collision with other field name */
    public hy f607a;

    /* renamed from: a  reason: collision with other field name */
    public String f608a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f609a;

    /* renamed from: a  reason: collision with other field name */
    public List<String> f610a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f611a;

    /* renamed from: b  reason: collision with other field name */
    public String f612b;

    /* renamed from: c  reason: collision with other field name */
    public String f613c;

    /* renamed from: d  reason: collision with other field name */
    public String f614d;

    /* renamed from: e  reason: collision with other field name */
    public String f615e;

    /* renamed from: f  reason: collision with other field name */
    public String f616f;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-56372060, "Lcom/xiaomi/push/ie;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-56372060, "Lcom/xiaomi/push/ie;");
                return;
            }
        }
        f605a = new jk("XmPushActionCommandResult");
        a = new jc("", (byte) 12, (short) 2);
        b = new jc("", Constants.GZIP_CAST_TYPE, (short) 3);
        c = new jc("", Constants.GZIP_CAST_TYPE, (short) 4);
        d = new jc("", Constants.GZIP_CAST_TYPE, (short) 5);
        e = new jc("", (byte) 10, (short) 7);
        f = new jc("", Constants.GZIP_CAST_TYPE, (short) 8);
        g = new jc("", Constants.GZIP_CAST_TYPE, (short) 9);
        h = new jc("", (byte) 15, (short) 10);
        i = new jc("", Constants.GZIP_CAST_TYPE, (short) 12);
        j = new jc("", (byte) 2, (short) 13);
    }

    public ie() {
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
        this.f609a = new BitSet(2);
        this.f611a = true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(ie ieVar) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, ieVar)) == null) {
            if (ie.class.equals(ieVar.getClass())) {
                int compareTo = Boolean.valueOf(m456a()).compareTo(Boolean.valueOf(ieVar.m456a()));
                if (compareTo != 0) {
                    return compareTo;
                }
                if (!m456a() || (a11 = iv.a(this.f607a, ieVar.f607a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m458b()).compareTo(Boolean.valueOf(ieVar.m458b()));
                    if (compareTo2 != 0) {
                        return compareTo2;
                    }
                    if (!m458b() || (a10 = iv.a(this.f608a, ieVar.f608a)) == 0) {
                        int compareTo3 = Boolean.valueOf(m459c()).compareTo(Boolean.valueOf(ieVar.m459c()));
                        if (compareTo3 != 0) {
                            return compareTo3;
                        }
                        if (!m459c() || (a9 = iv.a(this.f612b, ieVar.f612b)) == 0) {
                            int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(ieVar.d()));
                            if (compareTo4 != 0) {
                                return compareTo4;
                            }
                            if (!d() || (a8 = iv.a(this.f613c, ieVar.f613c)) == 0) {
                                int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(ieVar.e()));
                                if (compareTo5 != 0) {
                                    return compareTo5;
                                }
                                if (!e() || (a7 = iv.a(this.f606a, ieVar.f606a)) == 0) {
                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(ieVar.f()));
                                    if (compareTo6 != 0) {
                                        return compareTo6;
                                    }
                                    if (!f() || (a6 = iv.a(this.f614d, ieVar.f614d)) == 0) {
                                        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ieVar.g()));
                                        if (compareTo7 != 0) {
                                            return compareTo7;
                                        }
                                        if (!g() || (a5 = iv.a(this.f615e, ieVar.f615e)) == 0) {
                                            int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(ieVar.h()));
                                            if (compareTo8 != 0) {
                                                return compareTo8;
                                            }
                                            if (!h() || (a4 = iv.a(this.f610a, ieVar.f610a)) == 0) {
                                                int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(ieVar.i()));
                                                if (compareTo9 != 0) {
                                                    return compareTo9;
                                                }
                                                if (!i() || (a3 = iv.a(this.f616f, ieVar.f616f)) == 0) {
                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(ieVar.j()));
                                                    if (compareTo10 != 0) {
                                                        return compareTo10;
                                                    }
                                                    if (!j() || (a2 = iv.a(this.f611a, ieVar.f611a)) == 0) {
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
            return ie.class.getName().compareTo(ieVar.getClass().getName());
        }
        return invokeL.intValue;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f608a : (String) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public List<String> m454a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f610a : (List) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m455a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.f608a == null) {
                throw new jg("Required field 'id' was not present! Struct: " + toString());
            } else if (this.f612b == null) {
                throw new jg("Required field 'appId' was not present! Struct: " + toString());
            } else if (this.f613c != null) {
            } else {
                throw new jg("Required field 'cmdName' was not present! Struct: " + toString());
            }
        }
    }

    @Override // com.xiaomi.push.iu
    public void a(jf jfVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(1048580, this, jfVar) != null) {
            return;
        }
        jfVar.m544a();
        while (true) {
            jc m540a = jfVar.m540a();
            byte b2 = m540a.a;
            if (b2 == 0) {
                jfVar.f();
                if (e()) {
                    m455a();
                    return;
                }
                throw new jg("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
            }
            switch (m540a.f802a) {
                case 2:
                    if (b2 == 12) {
                        hy hyVar = new hy();
                        this.f607a = hyVar;
                        hyVar.a(jfVar);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f608a = jfVar.m545a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f612b = jfVar.m545a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 5:
                    if (b2 == 11) {
                        this.f613c = jfVar.m545a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 7:
                    if (b2 == 10) {
                        this.f606a = jfVar.m539a();
                        a(true);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 8:
                    if (b2 == 11) {
                        this.f614d = jfVar.m545a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 9:
                    if (b2 == 11) {
                        this.f615e = jfVar.m545a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 10:
                    if (b2 == 15) {
                        jd m541a = jfVar.m541a();
                        this.f610a = new ArrayList(m541a.f803a);
                        for (int i2 = 0; i2 < m541a.f803a; i2++) {
                            this.f610a.add(jfVar.m545a());
                        }
                        jfVar.i();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 12:
                    if (b2 == 11) {
                        this.f616f = jfVar.m545a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 13:
                    if (b2 == 2) {
                        this.f611a = jfVar.m549a();
                        b(true);
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
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.f609a.set(0, z);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m456a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f607a != null : invokeV.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m457a(ie ieVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, ieVar)) == null) {
            if (ieVar == null) {
                return false;
            }
            boolean m456a = m456a();
            boolean m456a2 = ieVar.m456a();
            if ((m456a || m456a2) && !(m456a && m456a2 && this.f607a.m438a(ieVar.f607a))) {
                return false;
            }
            boolean m458b = m458b();
            boolean m458b2 = ieVar.m458b();
            if ((m458b || m458b2) && !(m458b && m458b2 && this.f608a.equals(ieVar.f608a))) {
                return false;
            }
            boolean m459c = m459c();
            boolean m459c2 = ieVar.m459c();
            if ((m459c || m459c2) && !(m459c && m459c2 && this.f612b.equals(ieVar.f612b))) {
                return false;
            }
            boolean d2 = d();
            boolean d3 = ieVar.d();
            if (((d2 || d3) && !(d2 && d3 && this.f613c.equals(ieVar.f613c))) || this.f606a != ieVar.f606a) {
                return false;
            }
            boolean f2 = f();
            boolean f3 = ieVar.f();
            if ((f2 || f3) && !(f2 && f3 && this.f614d.equals(ieVar.f614d))) {
                return false;
            }
            boolean g2 = g();
            boolean g3 = ieVar.g();
            if ((g2 || g3) && !(g2 && g3 && this.f615e.equals(ieVar.f615e))) {
                return false;
            }
            boolean h2 = h();
            boolean h3 = ieVar.h();
            if ((h2 || h3) && !(h2 && h3 && this.f610a.equals(ieVar.f610a))) {
                return false;
            }
            boolean i2 = i();
            boolean i3 = ieVar.i();
            if ((i2 || i3) && !(i2 && i3 && this.f616f.equals(ieVar.f616f))) {
                return false;
            }
            boolean j2 = j();
            boolean j3 = ieVar.j();
            if (j2 || j3) {
                return j2 && j3 && this.f611a == ieVar.f611a;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f613c : (String) invokeV.objValue;
    }

    @Override // com.xiaomi.push.iu
    public void b(jf jfVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, jfVar) == null) {
            m455a();
            jfVar.a(f605a);
            if (this.f607a != null && m456a()) {
                jfVar.a(a);
                this.f607a.b(jfVar);
                jfVar.b();
            }
            if (this.f608a != null) {
                jfVar.a(b);
                jfVar.a(this.f608a);
                jfVar.b();
            }
            if (this.f612b != null) {
                jfVar.a(c);
                jfVar.a(this.f612b);
                jfVar.b();
            }
            if (this.f613c != null) {
                jfVar.a(d);
                jfVar.a(this.f613c);
                jfVar.b();
            }
            jfVar.a(e);
            jfVar.a(this.f606a);
            jfVar.b();
            if (this.f614d != null && f()) {
                jfVar.a(f);
                jfVar.a(this.f614d);
                jfVar.b();
            }
            if (this.f615e != null && g()) {
                jfVar.a(g);
                jfVar.a(this.f615e);
                jfVar.b();
            }
            if (this.f610a != null && h()) {
                jfVar.a(h);
                jfVar.a(new jd(Constants.GZIP_CAST_TYPE, this.f610a.size()));
                for (String str : this.f610a) {
                    jfVar.a(str);
                }
                jfVar.e();
                jfVar.b();
            }
            if (this.f616f != null && i()) {
                jfVar.a(i);
                jfVar.a(this.f616f);
                jfVar.b();
            }
            if (j()) {
                jfVar.a(j);
                jfVar.a(this.f611a);
                jfVar.b();
            }
            jfVar.c();
            jfVar.m548a();
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.f609a.set(1, z);
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m458b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f608a != null : invokeV.booleanValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f616f : (String) invokeV.objValue;
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m459c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f612b != null : invokeV.booleanValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f613c != null : invokeV.booleanValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f609a.get(0) : invokeV.booleanValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, obj)) == null) {
            if (obj != null && (obj instanceof ie)) {
                return m457a((ie) obj);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f614d != null : invokeV.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f615e != null : invokeV.booleanValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f610a != null : invokeV.booleanValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.f616f != null : invokeV.booleanValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.f609a.get(1) : invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            StringBuilder sb = new StringBuilder("XmPushActionCommandResult(");
            if (m456a()) {
                sb.append("target:");
                hy hyVar = this.f607a;
                if (hyVar == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(hyVar);
                }
                z = false;
            } else {
                z = true;
            }
            if (!z) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            }
            sb.append("id:");
            String str = this.f608a;
            if (str == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str);
            }
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("appId:");
            String str2 = this.f612b;
            if (str2 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str2);
            }
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("cmdName:");
            String str3 = this.f613c;
            if (str3 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str3);
            }
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("errorCode:");
            sb.append(this.f606a);
            if (f()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("reason:");
                String str4 = this.f614d;
                if (str4 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str4);
                }
            }
            if (g()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("packageName:");
                String str5 = this.f615e;
                if (str5 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str5);
                }
            }
            if (h()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("cmdArgs:");
                List<String> list = this.f610a;
                if (list == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(list);
                }
            }
            if (i()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("category:");
                String str6 = this.f616f;
                if (str6 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str6);
                }
            }
            if (j()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("response2Client:");
                sb.append(this.f611a);
            }
            sb.append(SmallTailInfo.EMOTION_SUFFIX);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
