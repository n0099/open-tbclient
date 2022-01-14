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
import io.flutter.plugin.common.StandardMessageCodec;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class in implements iq<in, Object>, Serializable, Cloneable {
    public static /* synthetic */ Interceptable $ic;
    public static final iy a;

    /* renamed from: a  reason: collision with other field name */
    public static final jg f785a;

    /* renamed from: b  reason: collision with root package name */
    public static final iy f61368b;

    /* renamed from: c  reason: collision with root package name */
    public static final iy f61369c;

    /* renamed from: d  reason: collision with root package name */
    public static final iy f61370d;

    /* renamed from: e  reason: collision with root package name */
    public static final iy f61371e;

    /* renamed from: f  reason: collision with root package name */
    public static final iy f61372f;

    /* renamed from: g  reason: collision with root package name */
    public static final iy f61373g;

    /* renamed from: h  reason: collision with root package name */
    public static final iy f61374h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public hu f786a;

    /* renamed from: a  reason: collision with other field name */
    public String f787a;

    /* renamed from: a  reason: collision with other field name */
    public List<String> f788a;

    /* renamed from: b  reason: collision with other field name */
    public String f789b;

    /* renamed from: c  reason: collision with other field name */
    public String f790c;

    /* renamed from: d  reason: collision with other field name */
    public String f791d;

    /* renamed from: e  reason: collision with other field name */
    public String f792e;

    /* renamed from: f  reason: collision with other field name */
    public String f793f;

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
        f785a = new jg("XmPushActionUnSubscription");
        a = new iy("", (byte) 11, (short) 1);
        f61368b = new iy("", StandardMessageCodec.LIST, (short) 2);
        f61369c = new iy("", (byte) 11, (short) 3);
        f61370d = new iy("", (byte) 11, (short) 4);
        f61371e = new iy("", (byte) 11, (short) 5);
        f61372f = new iy("", (byte) 11, (short) 6);
        f61373g = new iy("", (byte) 11, (short) 7);
        f61374h = new iy("", (byte) 15, (short) 8);
    }

    public in() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
                int compareTo = Boolean.valueOf(m571a()).compareTo(Boolean.valueOf(inVar.m571a()));
                if (compareTo != 0) {
                    return compareTo;
                }
                if (!m571a() || (a9 = ir.a(this.f787a, inVar.f787a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(inVar.b()));
                    if (compareTo2 != 0) {
                        return compareTo2;
                    }
                    if (!b() || (a8 = ir.a(this.f786a, inVar.f786a)) == 0) {
                        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(inVar.c()));
                        if (compareTo3 != 0) {
                            return compareTo3;
                        }
                        if (!c() || (a7 = ir.a(this.f789b, inVar.f789b)) == 0) {
                            int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(inVar.d()));
                            if (compareTo4 != 0) {
                                return compareTo4;
                            }
                            if (!d() || (a6 = ir.a(this.f790c, inVar.f790c)) == 0) {
                                int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(inVar.e()));
                                if (compareTo5 != 0) {
                                    return compareTo5;
                                }
                                if (!e() || (a5 = ir.a(this.f791d, inVar.f791d)) == 0) {
                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(inVar.f()));
                                    if (compareTo6 != 0) {
                                        return compareTo6;
                                    }
                                    if (!f() || (a4 = ir.a(this.f792e, inVar.f792e)) == 0) {
                                        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(inVar.g()));
                                        if (compareTo7 != 0) {
                                            return compareTo7;
                                        }
                                        if (!g() || (a3 = ir.a(this.f793f, inVar.f793f)) == 0) {
                                            int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(inVar.h()));
                                            if (compareTo8 != 0) {
                                                return compareTo8;
                                            }
                                            if (!h() || (a2 = ir.a(this.f788a, inVar.f788a)) == 0) {
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
            this.f789b = str;
            return this;
        }
        return (in) invokeL.objValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (this.f789b == null) {
                throw new jc("Required field 'id' was not present! Struct: " + toString());
            } else if (this.f790c == null) {
                throw new jc("Required field 'appId' was not present! Struct: " + toString());
            } else if (this.f791d != null) {
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
        jbVar.m588a();
        while (true) {
            iy m584a = jbVar.m584a();
            byte b2 = m584a.a;
            if (b2 == 0) {
                jbVar.f();
                a();
                return;
            }
            switch (m584a.f815a) {
                case 1:
                    if (b2 == 11) {
                        this.f787a = jbVar.m589a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 2:
                    if (b2 == 12) {
                        hu huVar = new hu();
                        this.f786a = huVar;
                        huVar.a(jbVar);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f789b = jbVar.m589a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f790c = jbVar.m589a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 5:
                    if (b2 == 11) {
                        this.f791d = jbVar.m589a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 6:
                    if (b2 == 11) {
                        this.f792e = jbVar.m589a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f793f = jbVar.m589a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 8:
                    if (b2 == 15) {
                        iz m585a = jbVar.m585a();
                        this.f788a = new ArrayList(m585a.f816a);
                        for (int i2 = 0; i2 < m585a.f816a; i2++) {
                            this.f788a.add(jbVar.m589a());
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
    public boolean m571a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f787a != null : invokeV.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m572a(in inVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, inVar)) == null) {
            if (inVar == null) {
                return false;
            }
            boolean m571a = m571a();
            boolean m571a2 = inVar.m571a();
            if ((m571a || m571a2) && !(m571a && m571a2 && this.f787a.equals(inVar.f787a))) {
                return false;
            }
            boolean b2 = b();
            boolean b3 = inVar.b();
            if ((b2 || b3) && !(b2 && b3 && this.f786a.m483a(inVar.f786a))) {
                return false;
            }
            boolean c2 = c();
            boolean c3 = inVar.c();
            if ((c2 || c3) && !(c2 && c3 && this.f789b.equals(inVar.f789b))) {
                return false;
            }
            boolean d2 = d();
            boolean d3 = inVar.d();
            if ((d2 || d3) && !(d2 && d3 && this.f790c.equals(inVar.f790c))) {
                return false;
            }
            boolean e2 = e();
            boolean e3 = inVar.e();
            if ((e2 || e3) && !(e2 && e3 && this.f791d.equals(inVar.f791d))) {
                return false;
            }
            boolean f2 = f();
            boolean f3 = inVar.f();
            if ((f2 || f3) && !(f2 && f3 && this.f792e.equals(inVar.f792e))) {
                return false;
            }
            boolean g2 = g();
            boolean g3 = inVar.g();
            if ((g2 || g3) && !(g2 && g3 && this.f793f.equals(inVar.f793f))) {
                return false;
            }
            boolean h2 = h();
            boolean h3 = inVar.h();
            if (h2 || h3) {
                return h2 && h3 && this.f788a.equals(inVar.f788a);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public in b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            this.f790c = str;
            return this;
        }
        return (in) invokeL.objValue;
    }

    @Override // com.xiaomi.push.iq
    public void b(jb jbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, jbVar) == null) {
            a();
            jbVar.a(f785a);
            if (this.f787a != null && m571a()) {
                jbVar.a(a);
                jbVar.a(this.f787a);
                jbVar.b();
            }
            if (this.f786a != null && b()) {
                jbVar.a(f61368b);
                this.f786a.b(jbVar);
                jbVar.b();
            }
            if (this.f789b != null) {
                jbVar.a(f61369c);
                jbVar.a(this.f789b);
                jbVar.b();
            }
            if (this.f790c != null) {
                jbVar.a(f61370d);
                jbVar.a(this.f790c);
                jbVar.b();
            }
            if (this.f791d != null) {
                jbVar.a(f61371e);
                jbVar.a(this.f791d);
                jbVar.b();
            }
            if (this.f792e != null && f()) {
                jbVar.a(f61372f);
                jbVar.a(this.f792e);
                jbVar.b();
            }
            if (this.f793f != null && g()) {
                jbVar.a(f61373g);
                jbVar.a(this.f793f);
                jbVar.b();
            }
            if (this.f788a != null && h()) {
                jbVar.a(f61374h);
                jbVar.a(new iz((byte) 11, this.f788a.size()));
                for (String str : this.f788a) {
                    jbVar.a(str);
                }
                jbVar.e();
                jbVar.b();
            }
            jbVar.c();
            jbVar.m592a();
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f786a != null : invokeV.booleanValue;
    }

    public in c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            this.f791d = str;
            return this;
        }
        return (in) invokeL.objValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f789b != null : invokeV.booleanValue;
    }

    public in d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
            this.f792e = str;
            return this;
        }
        return (in) invokeL.objValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f790c != null : invokeV.booleanValue;
    }

    public in e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
            this.f793f = str;
            return this;
        }
        return (in) invokeL.objValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f791d != null : invokeV.booleanValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, obj)) == null) {
            if (obj != null && (obj instanceof in)) {
                return m572a((in) obj);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.f792e != null : invokeV.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f793f != null : invokeV.booleanValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f788a != null : invokeV.booleanValue;
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
            if (m571a()) {
                sb.append("debug:");
                String str = this.f787a;
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
                hu huVar = this.f786a;
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
            String str2 = this.f789b;
            if (str2 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str2);
            }
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("appId:");
            String str3 = this.f790c;
            if (str3 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str3);
            }
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append(UrlSchemaHelper.SCHEMA_TYPE_TOPIC);
            String str4 = this.f791d;
            if (str4 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str4);
            }
            if (f()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("packageName:");
                String str5 = this.f792e;
                if (str5 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str5);
                }
            }
            if (g()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("category:");
                String str6 = this.f793f;
                if (str6 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str6);
                }
            }
            if (h()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("aliases:");
                List<String> list = this.f788a;
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
