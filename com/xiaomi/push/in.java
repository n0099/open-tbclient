package com.xiaomi.push;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class in implements iq<in, Object>, Serializable, Cloneable {
    public static /* synthetic */ Interceptable $ic;
    public static final iy a;

    /* renamed from: a  reason: collision with other field name */
    public static final jg f761a;
    public static final iy b;
    public static final iy c;
    public static final iy d;
    public static final iy e;
    public static final iy f;
    public static final iy g;
    public static final iy h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public hu f762a;

    /* renamed from: a  reason: collision with other field name */
    public String f763a;

    /* renamed from: a  reason: collision with other field name */
    public List<String> f764a;

    /* renamed from: b  reason: collision with other field name */
    public String f765b;

    /* renamed from: c  reason: collision with other field name */
    public String f766c;

    /* renamed from: d  reason: collision with other field name */
    public String f767d;

    /* renamed from: e  reason: collision with other field name */
    public String f768e;

    /* renamed from: f  reason: collision with other field name */
    public String f769f;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-56371781, "Lcom/xiaomi/push/in;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-56371781, "Lcom/xiaomi/push/in;");
                return;
            }
        }
        f761a = new jg("XmPushActionUnSubscription");
        a = new iy("", Constants.GZIP_CAST_TYPE, (short) 1);
        b = new iy("", (byte) 12, (short) 2);
        c = new iy("", Constants.GZIP_CAST_TYPE, (short) 3);
        d = new iy("", Constants.GZIP_CAST_TYPE, (short) 4);
        e = new iy("", Constants.GZIP_CAST_TYPE, (short) 5);
        f = new iy("", Constants.GZIP_CAST_TYPE, (short) 6);
        g = new iy("", Constants.GZIP_CAST_TYPE, (short) 7);
        h = new iy("", (byte) 15, (short) 8);
    }

    public in() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(in inVar) {
        InterceptResult invokeL;
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        int a8;
        int a9;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, inVar)) == null) {
            if (in.class.equals(inVar.getClass())) {
                int compareTo = Boolean.valueOf(m545a()).compareTo(Boolean.valueOf(inVar.m545a()));
                if (compareTo != 0) {
                    return compareTo;
                }
                if (!m545a() || (a9 = ir.a(this.f763a, inVar.f763a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(inVar.b()));
                    if (compareTo2 != 0) {
                        return compareTo2;
                    }
                    if (!b() || (a8 = ir.a(this.f762a, inVar.f762a)) == 0) {
                        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(inVar.c()));
                        if (compareTo3 != 0) {
                            return compareTo3;
                        }
                        if (!c() || (a7 = ir.a(this.f765b, inVar.f765b)) == 0) {
                            int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(inVar.d()));
                            if (compareTo4 != 0) {
                                return compareTo4;
                            }
                            if (!d() || (a6 = ir.a(this.f766c, inVar.f766c)) == 0) {
                                int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(inVar.e()));
                                if (compareTo5 != 0) {
                                    return compareTo5;
                                }
                                if (!e() || (a5 = ir.a(this.f767d, inVar.f767d)) == 0) {
                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(inVar.f()));
                                    if (compareTo6 != 0) {
                                        return compareTo6;
                                    }
                                    if (!f() || (a4 = ir.a(this.f768e, inVar.f768e)) == 0) {
                                        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(inVar.g()));
                                        if (compareTo7 != 0) {
                                            return compareTo7;
                                        }
                                        if (!g() || (a3 = ir.a(this.f769f, inVar.f769f)) == 0) {
                                            int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(inVar.h()));
                                            if (compareTo8 != 0) {
                                                return compareTo8;
                                            }
                                            if (!h() || (a2 = ir.a(this.f764a, inVar.f764a)) == 0) {
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
            return in.class.getName().compareTo(inVar.getClass().getName());
        }
        return invokeL.intValue;
    }

    public in a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            this.f765b = str;
            return this;
        }
        return (in) invokeL.objValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (this.f765b == null) {
                throw new jc("Required field 'id' was not present! Struct: " + toString());
            } else if (this.f766c == null) {
                throw new jc("Required field 'appId' was not present! Struct: " + toString());
            } else if (this.f767d != null) {
            } else {
                throw new jc("Required field 'topic' was not present! Struct: " + toString());
            }
        }
    }

    @Override // com.xiaomi.push.iq
    public void a(jb jbVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(1048579, this, jbVar) != null) {
            return;
        }
        jbVar.m562a();
        while (true) {
            iy m558a = jbVar.m558a();
            byte b2 = m558a.a;
            if (b2 == 0) {
                jbVar.f();
                a();
                return;
            }
            switch (m558a.f791a) {
                case 1:
                    if (b2 == 11) {
                        this.f763a = jbVar.m563a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 2:
                    if (b2 == 12) {
                        hu huVar = new hu();
                        this.f762a = huVar;
                        huVar.a(jbVar);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f765b = jbVar.m563a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f766c = jbVar.m563a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 5:
                    if (b2 == 11) {
                        this.f767d = jbVar.m563a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 6:
                    if (b2 == 11) {
                        this.f768e = jbVar.m563a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f769f = jbVar.m563a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 8:
                    if (b2 == 15) {
                        iz m559a = jbVar.m559a();
                        this.f764a = new ArrayList(m559a.f792a);
                        for (int i = 0; i < m559a.f792a; i++) {
                            this.f764a.add(jbVar.m563a());
                        }
                        jbVar.i();
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
    public boolean m545a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f763a != null : invokeV.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m546a(in inVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, inVar)) == null) {
            if (inVar == null) {
                return false;
            }
            boolean m545a = m545a();
            boolean m545a2 = inVar.m545a();
            if ((m545a || m545a2) && !(m545a && m545a2 && this.f763a.equals(inVar.f763a))) {
                return false;
            }
            boolean b2 = b();
            boolean b3 = inVar.b();
            if ((b2 || b3) && !(b2 && b3 && this.f762a.m457a(inVar.f762a))) {
                return false;
            }
            boolean c2 = c();
            boolean c3 = inVar.c();
            if ((c2 || c3) && !(c2 && c3 && this.f765b.equals(inVar.f765b))) {
                return false;
            }
            boolean d2 = d();
            boolean d3 = inVar.d();
            if ((d2 || d3) && !(d2 && d3 && this.f766c.equals(inVar.f766c))) {
                return false;
            }
            boolean e2 = e();
            boolean e3 = inVar.e();
            if ((e2 || e3) && !(e2 && e3 && this.f767d.equals(inVar.f767d))) {
                return false;
            }
            boolean f2 = f();
            boolean f3 = inVar.f();
            if ((f2 || f3) && !(f2 && f3 && this.f768e.equals(inVar.f768e))) {
                return false;
            }
            boolean g2 = g();
            boolean g3 = inVar.g();
            if ((g2 || g3) && !(g2 && g3 && this.f769f.equals(inVar.f769f))) {
                return false;
            }
            boolean h2 = h();
            boolean h3 = inVar.h();
            if (h2 || h3) {
                return h2 && h3 && this.f764a.equals(inVar.f764a);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public in b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            this.f766c = str;
            return this;
        }
        return (in) invokeL.objValue;
    }

    @Override // com.xiaomi.push.iq
    public void b(jb jbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, jbVar) == null) {
            a();
            jbVar.a(f761a);
            if (this.f763a != null && m545a()) {
                jbVar.a(a);
                jbVar.a(this.f763a);
                jbVar.b();
            }
            if (this.f762a != null && b()) {
                jbVar.a(b);
                this.f762a.b(jbVar);
                jbVar.b();
            }
            if (this.f765b != null) {
                jbVar.a(c);
                jbVar.a(this.f765b);
                jbVar.b();
            }
            if (this.f766c != null) {
                jbVar.a(d);
                jbVar.a(this.f766c);
                jbVar.b();
            }
            if (this.f767d != null) {
                jbVar.a(e);
                jbVar.a(this.f767d);
                jbVar.b();
            }
            if (this.f768e != null && f()) {
                jbVar.a(f);
                jbVar.a(this.f768e);
                jbVar.b();
            }
            if (this.f769f != null && g()) {
                jbVar.a(g);
                jbVar.a(this.f769f);
                jbVar.b();
            }
            if (this.f764a != null && h()) {
                jbVar.a(h);
                jbVar.a(new iz(Constants.GZIP_CAST_TYPE, this.f764a.size()));
                for (String str : this.f764a) {
                    jbVar.a(str);
                }
                jbVar.e();
                jbVar.b();
            }
            jbVar.c();
            jbVar.m566a();
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f762a != null : invokeV.booleanValue;
    }

    public in c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            this.f767d = str;
            return this;
        }
        return (in) invokeL.objValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f765b != null : invokeV.booleanValue;
    }

    public in d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
            this.f768e = str;
            return this;
        }
        return (in) invokeL.objValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f766c != null : invokeV.booleanValue;
    }

    public in e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
            this.f769f = str;
            return this;
        }
        return (in) invokeL.objValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f767d != null : invokeV.booleanValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, obj)) == null) {
            if (obj != null && (obj instanceof in)) {
                return m546a((in) obj);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.f768e != null : invokeV.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f769f != null : invokeV.booleanValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f764a != null : invokeV.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            StringBuilder sb = new StringBuilder("XmPushActionUnSubscription(");
            boolean z2 = false;
            if (m545a()) {
                sb.append("debug:");
                String str = this.f763a;
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
                hu huVar = this.f762a;
                if (huVar == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(huVar);
                }
            } else {
                z2 = z;
            }
            if (!z2) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            }
            sb.append("id:");
            String str2 = this.f765b;
            if (str2 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str2);
            }
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("appId:");
            String str3 = this.f766c;
            if (str3 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str3);
            }
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append(UrlSchemaHelper.SCHEMA_TYPE_TOPIC);
            String str4 = this.f767d;
            if (str4 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str4);
            }
            if (f()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("packageName:");
                String str5 = this.f768e;
                if (str5 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str5);
                }
            }
            if (g()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("category:");
                String str6 = this.f769f;
                if (str6 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str6);
                }
            }
            if (h()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("aliases:");
                List<String> list = this.f764a;
                if (list == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(list);
                }
            }
            sb.append(SmallTailInfo.EMOTION_SUFFIX);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
