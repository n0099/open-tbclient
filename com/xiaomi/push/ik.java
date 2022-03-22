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
import java.util.BitSet;
/* loaded from: classes7.dex */
public class ik implements iq<ik, Object>, Serializable, Cloneable {
    public static /* synthetic */ Interceptable $ic;
    public static final iy a;

    /* renamed from: a  reason: collision with other field name */
    public static final jg f725a;

    /* renamed from: b  reason: collision with root package name */
    public static final iy f44476b;

    /* renamed from: c  reason: collision with root package name */
    public static final iy f44477c;

    /* renamed from: d  reason: collision with root package name */
    public static final iy f44478d;

    /* renamed from: e  reason: collision with root package name */
    public static final iy f44479e;

    /* renamed from: f  reason: collision with root package name */
    public static final iy f44480f;

    /* renamed from: g  reason: collision with root package name */
    public static final iy f44481g;

    /* renamed from: h  reason: collision with root package name */
    public static final iy f44482h;
    public static final iy i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public long f726a;

    /* renamed from: a  reason: collision with other field name */
    public hu f727a;

    /* renamed from: a  reason: collision with other field name */
    public String f728a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f729a;

    /* renamed from: b  reason: collision with other field name */
    public String f730b;

    /* renamed from: c  reason: collision with other field name */
    public String f731c;

    /* renamed from: d  reason: collision with other field name */
    public String f732d;

    /* renamed from: e  reason: collision with other field name */
    public String f733e;

    /* renamed from: f  reason: collision with other field name */
    public String f734f;

    /* renamed from: g  reason: collision with other field name */
    public String f735g;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-56371874, "Lcom/xiaomi/push/ik;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-56371874, "Lcom/xiaomi/push/ik;");
                return;
            }
        }
        f725a = new jg("XmPushActionSubscriptionResult");
        a = new iy("", Constants.GZIP_CAST_TYPE, (short) 1);
        f44476b = new iy("", (byte) 12, (short) 2);
        f44477c = new iy("", Constants.GZIP_CAST_TYPE, (short) 3);
        f44478d = new iy("", Constants.GZIP_CAST_TYPE, (short) 4);
        f44479e = new iy("", (byte) 10, (short) 6);
        f44480f = new iy("", Constants.GZIP_CAST_TYPE, (short) 7);
        f44481g = new iy("", Constants.GZIP_CAST_TYPE, (short) 8);
        f44482h = new iy("", Constants.GZIP_CAST_TYPE, (short) 9);
        i = new iy("", Constants.GZIP_CAST_TYPE, (short) 10);
    }

    public ik() {
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
        this.f729a = new BitSet(1);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(ik ikVar) {
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
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, ikVar)) == null) {
            if (ik.class.equals(ikVar.getClass())) {
                int compareTo = Boolean.valueOf(m540a()).compareTo(Boolean.valueOf(ikVar.m540a()));
                if (compareTo != 0) {
                    return compareTo;
                }
                if (!m540a() || (a10 = ir.a(this.f728a, ikVar.f728a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m542b()).compareTo(Boolean.valueOf(ikVar.m542b()));
                    if (compareTo2 != 0) {
                        return compareTo2;
                    }
                    if (!m542b() || (a9 = ir.a(this.f727a, ikVar.f727a)) == 0) {
                        int compareTo3 = Boolean.valueOf(m543c()).compareTo(Boolean.valueOf(ikVar.m543c()));
                        if (compareTo3 != 0) {
                            return compareTo3;
                        }
                        if (!m543c() || (a8 = ir.a(this.f730b, ikVar.f730b)) == 0) {
                            int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(ikVar.d()));
                            if (compareTo4 != 0) {
                                return compareTo4;
                            }
                            if (!d() || (a7 = ir.a(this.f731c, ikVar.f731c)) == 0) {
                                int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(ikVar.e()));
                                if (compareTo5 != 0) {
                                    return compareTo5;
                                }
                                if (!e() || (a6 = ir.a(this.f726a, ikVar.f726a)) == 0) {
                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(ikVar.f()));
                                    if (compareTo6 != 0) {
                                        return compareTo6;
                                    }
                                    if (!f() || (a5 = ir.a(this.f732d, ikVar.f732d)) == 0) {
                                        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ikVar.g()));
                                        if (compareTo7 != 0) {
                                            return compareTo7;
                                        }
                                        if (!g() || (a4 = ir.a(this.f733e, ikVar.f733e)) == 0) {
                                            int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(ikVar.h()));
                                            if (compareTo8 != 0) {
                                                return compareTo8;
                                            }
                                            if (!h() || (a3 = ir.a(this.f734f, ikVar.f734f)) == 0) {
                                                int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(ikVar.i()));
                                                if (compareTo9 != 0) {
                                                    return compareTo9;
                                                }
                                                if (!i() || (a2 = ir.a(this.f735g, ikVar.f735g)) == 0) {
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
            return ik.class.getName().compareTo(ikVar.getClass().getName());
        }
        return invokeL.intValue;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f730b : (String) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m539a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.f730b == null) {
            throw new jc("Required field 'id' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.iq
    public void a(jb jbVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(1048579, this, jbVar) != null) {
            return;
        }
        jbVar.m566a();
        while (true) {
            iy m562a = jbVar.m562a();
            byte b2 = m562a.a;
            if (b2 == 0) {
                jbVar.f();
                m539a();
                return;
            }
            switch (m562a.f791a) {
                case 1:
                    if (b2 == 11) {
                        this.f728a = jbVar.m567a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 2:
                    if (b2 == 12) {
                        hu huVar = new hu();
                        this.f727a = huVar;
                        huVar.a(jbVar);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f730b = jbVar.m567a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f731c = jbVar.m567a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 6:
                    if (b2 == 10) {
                        this.f726a = jbVar.m561a();
                        a(true);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f732d = jbVar.m567a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 8:
                    if (b2 == 11) {
                        this.f733e = jbVar.m567a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 9:
                    if (b2 == 11) {
                        this.f734f = jbVar.m567a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 10:
                    if (b2 == 11) {
                        this.f735g = jbVar.m567a();
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
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.f729a.set(0, z);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m540a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f728a != null : invokeV.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m541a(ik ikVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, ikVar)) == null) {
            if (ikVar == null) {
                return false;
            }
            boolean m540a = m540a();
            boolean m540a2 = ikVar.m540a();
            if ((m540a || m540a2) && !(m540a && m540a2 && this.f728a.equals(ikVar.f728a))) {
                return false;
            }
            boolean m542b = m542b();
            boolean m542b2 = ikVar.m542b();
            if ((m542b || m542b2) && !(m542b && m542b2 && this.f727a.m461a(ikVar.f727a))) {
                return false;
            }
            boolean m543c = m543c();
            boolean m543c2 = ikVar.m543c();
            if ((m543c || m543c2) && !(m543c && m543c2 && this.f730b.equals(ikVar.f730b))) {
                return false;
            }
            boolean d2 = d();
            boolean d3 = ikVar.d();
            if ((d2 || d3) && !(d2 && d3 && this.f731c.equals(ikVar.f731c))) {
                return false;
            }
            boolean e2 = e();
            boolean e3 = ikVar.e();
            if ((e2 || e3) && !(e2 && e3 && this.f726a == ikVar.f726a)) {
                return false;
            }
            boolean f2 = f();
            boolean f3 = ikVar.f();
            if ((f2 || f3) && !(f2 && f3 && this.f732d.equals(ikVar.f732d))) {
                return false;
            }
            boolean g2 = g();
            boolean g3 = ikVar.g();
            if ((g2 || g3) && !(g2 && g3 && this.f733e.equals(ikVar.f733e))) {
                return false;
            }
            boolean h2 = h();
            boolean h3 = ikVar.h();
            if ((h2 || h3) && !(h2 && h3 && this.f734f.equals(ikVar.f734f))) {
                return false;
            }
            boolean i2 = i();
            boolean i3 = ikVar.i();
            if (i2 || i3) {
                return i2 && i3 && this.f735g.equals(ikVar.f735g);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f733e : (String) invokeV.objValue;
    }

    @Override // com.xiaomi.push.iq
    public void b(jb jbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jbVar) == null) {
            m539a();
            jbVar.a(f725a);
            if (this.f728a != null && m540a()) {
                jbVar.a(a);
                jbVar.a(this.f728a);
                jbVar.b();
            }
            if (this.f727a != null && m542b()) {
                jbVar.a(f44476b);
                this.f727a.b(jbVar);
                jbVar.b();
            }
            if (this.f730b != null) {
                jbVar.a(f44477c);
                jbVar.a(this.f730b);
                jbVar.b();
            }
            if (this.f731c != null && d()) {
                jbVar.a(f44478d);
                jbVar.a(this.f731c);
                jbVar.b();
            }
            if (e()) {
                jbVar.a(f44479e);
                jbVar.a(this.f726a);
                jbVar.b();
            }
            if (this.f732d != null && f()) {
                jbVar.a(f44480f);
                jbVar.a(this.f732d);
                jbVar.b();
            }
            if (this.f733e != null && g()) {
                jbVar.a(f44481g);
                jbVar.a(this.f733e);
                jbVar.b();
            }
            if (this.f734f != null && h()) {
                jbVar.a(f44482h);
                jbVar.a(this.f734f);
                jbVar.b();
            }
            if (this.f735g != null && i()) {
                jbVar.a(i);
                jbVar.a(this.f735g);
                jbVar.b();
            }
            jbVar.c();
            jbVar.m570a();
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m542b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f727a != null : invokeV.booleanValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f735g : (String) invokeV.objValue;
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m543c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f730b != null : invokeV.booleanValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f731c != null : invokeV.booleanValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f729a.get(0) : invokeV.booleanValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, obj)) == null) {
            if (obj != null && (obj instanceof ik)) {
                return m541a((ik) obj);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f732d != null : invokeV.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.f733e != null : invokeV.booleanValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f734f != null : invokeV.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f735g != null : invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            StringBuilder sb = new StringBuilder("XmPushActionSubscriptionResult(");
            boolean z2 = false;
            if (m540a()) {
                sb.append("debug:");
                String str = this.f728a;
                if (str == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str);
                }
                z = false;
            } else {
                z = true;
            }
            if (m542b()) {
                if (!z) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                }
                sb.append("target:");
                hu huVar = this.f727a;
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
            String str2 = this.f730b;
            if (str2 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str2);
            }
            if (d()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("appId:");
                String str3 = this.f731c;
                if (str3 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str3);
                }
            }
            if (e()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("errorCode:");
                sb.append(this.f726a);
            }
            if (f()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("reason:");
                String str4 = this.f732d;
                if (str4 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str4);
                }
            }
            if (g()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append(UrlSchemaHelper.SCHEMA_TYPE_TOPIC);
                String str5 = this.f733e;
                if (str5 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str5);
                }
            }
            if (h()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("packageName:");
                String str6 = this.f734f;
                if (str6 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str6);
                }
            }
            if (i()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("category:");
                String str7 = this.f735g;
                if (str7 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str7);
                }
            }
            sb.append(SmallTailInfo.EMOTION_SUFFIX);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
