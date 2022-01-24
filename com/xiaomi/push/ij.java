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
public class ij implements iq<ij, Object>, Serializable, Cloneable {
    public static /* synthetic */ Interceptable $ic;
    public static final iy a;

    /* renamed from: a  reason: collision with other field name */
    public static final jg f740a;

    /* renamed from: b  reason: collision with root package name */
    public static final iy f61381b;

    /* renamed from: c  reason: collision with root package name */
    public static final iy f61382c;

    /* renamed from: d  reason: collision with root package name */
    public static final iy f61383d;

    /* renamed from: e  reason: collision with root package name */
    public static final iy f61384e;

    /* renamed from: f  reason: collision with root package name */
    public static final iy f61385f;

    /* renamed from: g  reason: collision with root package name */
    public static final iy f61386g;

    /* renamed from: h  reason: collision with root package name */
    public static final iy f61387h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public hu f741a;

    /* renamed from: a  reason: collision with other field name */
    public String f742a;

    /* renamed from: a  reason: collision with other field name */
    public List<String> f743a;

    /* renamed from: b  reason: collision with other field name */
    public String f744b;

    /* renamed from: c  reason: collision with other field name */
    public String f745c;

    /* renamed from: d  reason: collision with other field name */
    public String f746d;

    /* renamed from: e  reason: collision with other field name */
    public String f747e;

    /* renamed from: f  reason: collision with other field name */
    public String f748f;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-56371905, "Lcom/xiaomi/push/ij;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-56371905, "Lcom/xiaomi/push/ij;");
                return;
            }
        }
        f740a = new jg("XmPushActionSubscription");
        a = new iy("", (byte) 11, (short) 1);
        f61381b = new iy("", StandardMessageCodec.LIST, (short) 2);
        f61382c = new iy("", (byte) 11, (short) 3);
        f61383d = new iy("", (byte) 11, (short) 4);
        f61384e = new iy("", (byte) 11, (short) 5);
        f61385f = new iy("", (byte) 11, (short) 6);
        f61386g = new iy("", (byte) 11, (short) 7);
        f61387h = new iy("", (byte) 15, (short) 8);
    }

    public ij() {
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
    public int compareTo(ij ijVar) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, ijVar)) == null) {
            if (ij.class.equals(ijVar.getClass())) {
                int compareTo = Boolean.valueOf(m559a()).compareTo(Boolean.valueOf(ijVar.m559a()));
                if (compareTo != 0) {
                    return compareTo;
                }
                if (!m559a() || (a9 = ir.a(this.f742a, ijVar.f742a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(ijVar.b()));
                    if (compareTo2 != 0) {
                        return compareTo2;
                    }
                    if (!b() || (a8 = ir.a(this.f741a, ijVar.f741a)) == 0) {
                        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(ijVar.c()));
                        if (compareTo3 != 0) {
                            return compareTo3;
                        }
                        if (!c() || (a7 = ir.a(this.f744b, ijVar.f744b)) == 0) {
                            int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(ijVar.d()));
                            if (compareTo4 != 0) {
                                return compareTo4;
                            }
                            if (!d() || (a6 = ir.a(this.f745c, ijVar.f745c)) == 0) {
                                int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(ijVar.e()));
                                if (compareTo5 != 0) {
                                    return compareTo5;
                                }
                                if (!e() || (a5 = ir.a(this.f746d, ijVar.f746d)) == 0) {
                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(ijVar.f()));
                                    if (compareTo6 != 0) {
                                        return compareTo6;
                                    }
                                    if (!f() || (a4 = ir.a(this.f747e, ijVar.f747e)) == 0) {
                                        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ijVar.g()));
                                        if (compareTo7 != 0) {
                                            return compareTo7;
                                        }
                                        if (!g() || (a3 = ir.a(this.f748f, ijVar.f748f)) == 0) {
                                            int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(ijVar.h()));
                                            if (compareTo8 != 0) {
                                                return compareTo8;
                                            }
                                            if (!h() || (a2 = ir.a(this.f743a, ijVar.f743a)) == 0) {
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
            return ij.class.getName().compareTo(ijVar.getClass().getName());
        }
        return invokeL.intValue;
    }

    public ij a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            this.f744b = str;
            return this;
        }
        return (ij) invokeL.objValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (this.f744b == null) {
                throw new jc("Required field 'id' was not present! Struct: " + toString());
            } else if (this.f745c == null) {
                throw new jc("Required field 'appId' was not present! Struct: " + toString());
            } else if (this.f746d != null) {
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
                        this.f742a = jbVar.m589a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 2:
                    if (b2 == 12) {
                        hu huVar = new hu();
                        this.f741a = huVar;
                        huVar.a(jbVar);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f744b = jbVar.m589a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f745c = jbVar.m589a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 5:
                    if (b2 == 11) {
                        this.f746d = jbVar.m589a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 6:
                    if (b2 == 11) {
                        this.f747e = jbVar.m589a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f748f = jbVar.m589a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 8:
                    if (b2 == 15) {
                        iz m585a = jbVar.m585a();
                        this.f743a = new ArrayList(m585a.f816a);
                        for (int i2 = 0; i2 < m585a.f816a; i2++) {
                            this.f743a.add(jbVar.m589a());
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
    public boolean m559a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f742a != null : invokeV.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m560a(ij ijVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, ijVar)) == null) {
            if (ijVar == null) {
                return false;
            }
            boolean m559a = m559a();
            boolean m559a2 = ijVar.m559a();
            if ((m559a || m559a2) && !(m559a && m559a2 && this.f742a.equals(ijVar.f742a))) {
                return false;
            }
            boolean b2 = b();
            boolean b3 = ijVar.b();
            if ((b2 || b3) && !(b2 && b3 && this.f741a.m483a(ijVar.f741a))) {
                return false;
            }
            boolean c2 = c();
            boolean c3 = ijVar.c();
            if ((c2 || c3) && !(c2 && c3 && this.f744b.equals(ijVar.f744b))) {
                return false;
            }
            boolean d2 = d();
            boolean d3 = ijVar.d();
            if ((d2 || d3) && !(d2 && d3 && this.f745c.equals(ijVar.f745c))) {
                return false;
            }
            boolean e2 = e();
            boolean e3 = ijVar.e();
            if ((e2 || e3) && !(e2 && e3 && this.f746d.equals(ijVar.f746d))) {
                return false;
            }
            boolean f2 = f();
            boolean f3 = ijVar.f();
            if ((f2 || f3) && !(f2 && f3 && this.f747e.equals(ijVar.f747e))) {
                return false;
            }
            boolean g2 = g();
            boolean g3 = ijVar.g();
            if ((g2 || g3) && !(g2 && g3 && this.f748f.equals(ijVar.f748f))) {
                return false;
            }
            boolean h2 = h();
            boolean h3 = ijVar.h();
            if (h2 || h3) {
                return h2 && h3 && this.f743a.equals(ijVar.f743a);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public ij b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            this.f745c = str;
            return this;
        }
        return (ij) invokeL.objValue;
    }

    @Override // com.xiaomi.push.iq
    public void b(jb jbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, jbVar) == null) {
            a();
            jbVar.a(f740a);
            if (this.f742a != null && m559a()) {
                jbVar.a(a);
                jbVar.a(this.f742a);
                jbVar.b();
            }
            if (this.f741a != null && b()) {
                jbVar.a(f61381b);
                this.f741a.b(jbVar);
                jbVar.b();
            }
            if (this.f744b != null) {
                jbVar.a(f61382c);
                jbVar.a(this.f744b);
                jbVar.b();
            }
            if (this.f745c != null) {
                jbVar.a(f61383d);
                jbVar.a(this.f745c);
                jbVar.b();
            }
            if (this.f746d != null) {
                jbVar.a(f61384e);
                jbVar.a(this.f746d);
                jbVar.b();
            }
            if (this.f747e != null && f()) {
                jbVar.a(f61385f);
                jbVar.a(this.f747e);
                jbVar.b();
            }
            if (this.f748f != null && g()) {
                jbVar.a(f61386g);
                jbVar.a(this.f748f);
                jbVar.b();
            }
            if (this.f743a != null && h()) {
                jbVar.a(f61387h);
                jbVar.a(new iz((byte) 11, this.f743a.size()));
                for (String str : this.f743a) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f741a != null : invokeV.booleanValue;
    }

    public ij c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            this.f746d = str;
            return this;
        }
        return (ij) invokeL.objValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f744b != null : invokeV.booleanValue;
    }

    public ij d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
            this.f747e = str;
            return this;
        }
        return (ij) invokeL.objValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f745c != null : invokeV.booleanValue;
    }

    public ij e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
            this.f748f = str;
            return this;
        }
        return (ij) invokeL.objValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f746d != null : invokeV.booleanValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, obj)) == null) {
            if (obj != null && (obj instanceof ij)) {
                return m560a((ij) obj);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.f747e != null : invokeV.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f748f != null : invokeV.booleanValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f743a != null : invokeV.booleanValue;
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
            StringBuilder sb = new StringBuilder("XmPushActionSubscription(");
            boolean z2 = false;
            if (m559a()) {
                sb.append("debug:");
                String str = this.f742a;
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
                hu huVar = this.f741a;
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
            String str2 = this.f744b;
            if (str2 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str2);
            }
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("appId:");
            String str3 = this.f745c;
            if (str3 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str3);
            }
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append(UrlSchemaHelper.SCHEMA_TYPE_TOPIC);
            String str4 = this.f746d;
            if (str4 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str4);
            }
            if (f()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("packageName:");
                String str5 = this.f747e;
                if (str5 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str5);
                }
            }
            if (g()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("category:");
                String str6 = this.f748f;
                if (str6 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str6);
                }
            }
            if (h()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("aliases:");
                List<String> list = this.f743a;
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
