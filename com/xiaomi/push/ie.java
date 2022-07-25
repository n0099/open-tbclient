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
    public static final jk f612a;
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
    public long f613a;

    /* renamed from: a  reason: collision with other field name */
    public hy f614a;

    /* renamed from: a  reason: collision with other field name */
    public String f615a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f616a;

    /* renamed from: a  reason: collision with other field name */
    public List<String> f617a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f618a;

    /* renamed from: b  reason: collision with other field name */
    public String f619b;

    /* renamed from: c  reason: collision with other field name */
    public String f620c;

    /* renamed from: d  reason: collision with other field name */
    public String f621d;

    /* renamed from: e  reason: collision with other field name */
    public String f622e;

    /* renamed from: f  reason: collision with other field name */
    public String f623f;

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
        f612a = new jk("XmPushActionCommandResult");
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
        this.f616a = new BitSet(2);
        this.f618a = true;
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
                int compareTo = Boolean.valueOf(m461a()).compareTo(Boolean.valueOf(ieVar.m461a()));
                if (compareTo != 0) {
                    return compareTo;
                }
                if (!m461a() || (a11 = iv.a(this.f614a, ieVar.f614a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m463b()).compareTo(Boolean.valueOf(ieVar.m463b()));
                    if (compareTo2 != 0) {
                        return compareTo2;
                    }
                    if (!m463b() || (a10 = iv.a(this.f615a, ieVar.f615a)) == 0) {
                        int compareTo3 = Boolean.valueOf(m464c()).compareTo(Boolean.valueOf(ieVar.m464c()));
                        if (compareTo3 != 0) {
                            return compareTo3;
                        }
                        if (!m464c() || (a9 = iv.a(this.f619b, ieVar.f619b)) == 0) {
                            int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(ieVar.d()));
                            if (compareTo4 != 0) {
                                return compareTo4;
                            }
                            if (!d() || (a8 = iv.a(this.f620c, ieVar.f620c)) == 0) {
                                int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(ieVar.e()));
                                if (compareTo5 != 0) {
                                    return compareTo5;
                                }
                                if (!e() || (a7 = iv.a(this.f613a, ieVar.f613a)) == 0) {
                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(ieVar.f()));
                                    if (compareTo6 != 0) {
                                        return compareTo6;
                                    }
                                    if (!f() || (a6 = iv.a(this.f621d, ieVar.f621d)) == 0) {
                                        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ieVar.g()));
                                        if (compareTo7 != 0) {
                                            return compareTo7;
                                        }
                                        if (!g() || (a5 = iv.a(this.f622e, ieVar.f622e)) == 0) {
                                            int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(ieVar.h()));
                                            if (compareTo8 != 0) {
                                                return compareTo8;
                                            }
                                            if (!h() || (a4 = iv.a(this.f617a, ieVar.f617a)) == 0) {
                                                int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(ieVar.i()));
                                                if (compareTo9 != 0) {
                                                    return compareTo9;
                                                }
                                                if (!i() || (a3 = iv.a(this.f623f, ieVar.f623f)) == 0) {
                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(ieVar.j()));
                                                    if (compareTo10 != 0) {
                                                        return compareTo10;
                                                    }
                                                    if (!j() || (a2 = iv.a(this.f618a, ieVar.f618a)) == 0) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f615a : (String) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public List<String> m459a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f617a : (List) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m460a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.f615a == null) {
                throw new jg("Required field 'id' was not present! Struct: " + toString());
            } else if (this.f619b == null) {
                throw new jg("Required field 'appId' was not present! Struct: " + toString());
            } else if (this.f620c != null) {
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
        jfVar.m549a();
        while (true) {
            jc m545a = jfVar.m545a();
            byte b2 = m545a.a;
            if (b2 == 0) {
                jfVar.f();
                if (e()) {
                    m460a();
                    return;
                }
                throw new jg("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
            }
            switch (m545a.f809a) {
                case 2:
                    if (b2 == 12) {
                        hy hyVar = new hy();
                        this.f614a = hyVar;
                        hyVar.a(jfVar);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f615a = jfVar.m550a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f619b = jfVar.m550a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 5:
                    if (b2 == 11) {
                        this.f620c = jfVar.m550a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 7:
                    if (b2 == 10) {
                        this.f613a = jfVar.m544a();
                        a(true);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 8:
                    if (b2 == 11) {
                        this.f621d = jfVar.m550a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 9:
                    if (b2 == 11) {
                        this.f622e = jfVar.m550a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 10:
                    if (b2 == 15) {
                        jd m546a = jfVar.m546a();
                        this.f617a = new ArrayList(m546a.f810a);
                        for (int i2 = 0; i2 < m546a.f810a; i2++) {
                            this.f617a.add(jfVar.m550a());
                        }
                        jfVar.i();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 12:
                    if (b2 == 11) {
                        this.f623f = jfVar.m550a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 13:
                    if (b2 == 2) {
                        this.f618a = jfVar.m554a();
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
            this.f616a.set(0, z);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m461a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f614a != null : invokeV.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m462a(ie ieVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, ieVar)) == null) {
            if (ieVar == null) {
                return false;
            }
            boolean m461a = m461a();
            boolean m461a2 = ieVar.m461a();
            if ((m461a || m461a2) && !(m461a && m461a2 && this.f614a.m443a(ieVar.f614a))) {
                return false;
            }
            boolean m463b = m463b();
            boolean m463b2 = ieVar.m463b();
            if ((m463b || m463b2) && !(m463b && m463b2 && this.f615a.equals(ieVar.f615a))) {
                return false;
            }
            boolean m464c = m464c();
            boolean m464c2 = ieVar.m464c();
            if ((m464c || m464c2) && !(m464c && m464c2 && this.f619b.equals(ieVar.f619b))) {
                return false;
            }
            boolean d2 = d();
            boolean d3 = ieVar.d();
            if (((d2 || d3) && !(d2 && d3 && this.f620c.equals(ieVar.f620c))) || this.f613a != ieVar.f613a) {
                return false;
            }
            boolean f2 = f();
            boolean f3 = ieVar.f();
            if ((f2 || f3) && !(f2 && f3 && this.f621d.equals(ieVar.f621d))) {
                return false;
            }
            boolean g2 = g();
            boolean g3 = ieVar.g();
            if ((g2 || g3) && !(g2 && g3 && this.f622e.equals(ieVar.f622e))) {
                return false;
            }
            boolean h2 = h();
            boolean h3 = ieVar.h();
            if ((h2 || h3) && !(h2 && h3 && this.f617a.equals(ieVar.f617a))) {
                return false;
            }
            boolean i2 = i();
            boolean i3 = ieVar.i();
            if ((i2 || i3) && !(i2 && i3 && this.f623f.equals(ieVar.f623f))) {
                return false;
            }
            boolean j2 = j();
            boolean j3 = ieVar.j();
            if (j2 || j3) {
                return j2 && j3 && this.f618a == ieVar.f618a;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f620c : (String) invokeV.objValue;
    }

    @Override // com.xiaomi.push.iu
    public void b(jf jfVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, jfVar) == null) {
            m460a();
            jfVar.a(f612a);
            if (this.f614a != null && m461a()) {
                jfVar.a(a);
                this.f614a.b(jfVar);
                jfVar.b();
            }
            if (this.f615a != null) {
                jfVar.a(b);
                jfVar.a(this.f615a);
                jfVar.b();
            }
            if (this.f619b != null) {
                jfVar.a(c);
                jfVar.a(this.f619b);
                jfVar.b();
            }
            if (this.f620c != null) {
                jfVar.a(d);
                jfVar.a(this.f620c);
                jfVar.b();
            }
            jfVar.a(e);
            jfVar.a(this.f613a);
            jfVar.b();
            if (this.f621d != null && f()) {
                jfVar.a(f);
                jfVar.a(this.f621d);
                jfVar.b();
            }
            if (this.f622e != null && g()) {
                jfVar.a(g);
                jfVar.a(this.f622e);
                jfVar.b();
            }
            if (this.f617a != null && h()) {
                jfVar.a(h);
                jfVar.a(new jd(Constants.GZIP_CAST_TYPE, this.f617a.size()));
                for (String str : this.f617a) {
                    jfVar.a(str);
                }
                jfVar.e();
                jfVar.b();
            }
            if (this.f623f != null && i()) {
                jfVar.a(i);
                jfVar.a(this.f623f);
                jfVar.b();
            }
            if (j()) {
                jfVar.a(j);
                jfVar.a(this.f618a);
                jfVar.b();
            }
            jfVar.c();
            jfVar.m553a();
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.f616a.set(1, z);
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m463b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f615a != null : invokeV.booleanValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f623f : (String) invokeV.objValue;
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m464c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f619b != null : invokeV.booleanValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f620c != null : invokeV.booleanValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f616a.get(0) : invokeV.booleanValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, obj)) == null) {
            if (obj != null && (obj instanceof ie)) {
                return m462a((ie) obj);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f621d != null : invokeV.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f622e != null : invokeV.booleanValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f617a != null : invokeV.booleanValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.f623f != null : invokeV.booleanValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.f616a.get(1) : invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            StringBuilder sb = new StringBuilder("XmPushActionCommandResult(");
            if (m461a()) {
                sb.append("target:");
                hy hyVar = this.f614a;
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
            String str = this.f615a;
            if (str == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str);
            }
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("appId:");
            String str2 = this.f619b;
            if (str2 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str2);
            }
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("cmdName:");
            String str3 = this.f620c;
            if (str3 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str3);
            }
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("errorCode:");
            sb.append(this.f613a);
            if (f()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("reason:");
                String str4 = this.f621d;
                if (str4 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str4);
                }
            }
            if (g()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("packageName:");
                String str5 = this.f622e;
                if (str5 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str5);
                }
            }
            if (h()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("cmdArgs:");
                List<String> list = this.f617a;
                if (list == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(list);
                }
            }
            if (i()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("category:");
                String str6 = this.f623f;
                if (str6 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str6);
                }
            }
            if (j()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("response2Client:");
                sb.append(this.f618a);
            }
            sb.append(SmallTailInfo.EMOTION_SUFFIX);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
