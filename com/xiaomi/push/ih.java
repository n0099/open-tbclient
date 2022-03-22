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
import java.util.BitSet;
/* loaded from: classes7.dex */
public class ih implements iq<ih, Object>, Serializable, Cloneable {
    public static /* synthetic */ Interceptable $ic;
    public static final iy a;

    /* renamed from: a  reason: collision with other field name */
    public static final jg f693a;

    /* renamed from: b  reason: collision with root package name */
    public static final iy f44456b;

    /* renamed from: c  reason: collision with root package name */
    public static final iy f44457c;

    /* renamed from: d  reason: collision with root package name */
    public static final iy f44458d;

    /* renamed from: e  reason: collision with root package name */
    public static final iy f44459e;

    /* renamed from: f  reason: collision with root package name */
    public static final iy f44460f;

    /* renamed from: g  reason: collision with root package name */
    public static final iy f44461g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public long f694a;

    /* renamed from: a  reason: collision with other field name */
    public hu f695a;

    /* renamed from: a  reason: collision with other field name */
    public String f696a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f697a;

    /* renamed from: b  reason: collision with other field name */
    public String f698b;

    /* renamed from: c  reason: collision with other field name */
    public String f699c;

    /* renamed from: d  reason: collision with other field name */
    public String f700d;

    /* renamed from: e  reason: collision with other field name */
    public String f701e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-56371967, "Lcom/xiaomi/push/ih;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-56371967, "Lcom/xiaomi/push/ih;");
                return;
            }
        }
        f693a = new jg("XmPushActionSendFeedbackResult");
        a = new iy("", Constants.GZIP_CAST_TYPE, (short) 1);
        f44456b = new iy("", (byte) 12, (short) 2);
        f44457c = new iy("", Constants.GZIP_CAST_TYPE, (short) 3);
        f44458d = new iy("", Constants.GZIP_CAST_TYPE, (short) 4);
        f44459e = new iy("", (byte) 10, (short) 6);
        f44460f = new iy("", Constants.GZIP_CAST_TYPE, (short) 7);
        f44461g = new iy("", Constants.GZIP_CAST_TYPE, (short) 8);
    }

    public ih() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f697a = new BitSet(1);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(ih ihVar) {
        InterceptResult invokeL;
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        int a8;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, ihVar)) == null) {
            if (ih.class.equals(ihVar.getClass())) {
                int compareTo = Boolean.valueOf(m526a()).compareTo(Boolean.valueOf(ihVar.m526a()));
                if (compareTo != 0) {
                    return compareTo;
                }
                if (!m526a() || (a8 = ir.a(this.f696a, ihVar.f696a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(ihVar.b()));
                    if (compareTo2 != 0) {
                        return compareTo2;
                    }
                    if (!b() || (a7 = ir.a(this.f695a, ihVar.f695a)) == 0) {
                        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(ihVar.c()));
                        if (compareTo3 != 0) {
                            return compareTo3;
                        }
                        if (!c() || (a6 = ir.a(this.f698b, ihVar.f698b)) == 0) {
                            int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(ihVar.d()));
                            if (compareTo4 != 0) {
                                return compareTo4;
                            }
                            if (!d() || (a5 = ir.a(this.f699c, ihVar.f699c)) == 0) {
                                int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(ihVar.e()));
                                if (compareTo5 != 0) {
                                    return compareTo5;
                                }
                                if (!e() || (a4 = ir.a(this.f694a, ihVar.f694a)) == 0) {
                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(ihVar.f()));
                                    if (compareTo6 != 0) {
                                        return compareTo6;
                                    }
                                    if (!f() || (a3 = ir.a(this.f700d, ihVar.f700d)) == 0) {
                                        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ihVar.g()));
                                        if (compareTo7 != 0) {
                                            return compareTo7;
                                        }
                                        if (!g() || (a2 = ir.a(this.f701e, ihVar.f701e)) == 0) {
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
            return ih.class.getName().compareTo(ihVar.getClass().getName());
        }
        return invokeL.intValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.f698b == null) {
                throw new jc("Required field 'id' was not present! Struct: " + toString());
            } else if (this.f699c != null) {
            } else {
                throw new jc("Required field 'appId' was not present! Struct: " + toString());
            }
        }
    }

    @Override // com.xiaomi.push.iq
    public void a(jb jbVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jbVar) != null) {
            return;
        }
        jbVar.m566a();
        while (true) {
            iy m562a = jbVar.m562a();
            byte b2 = m562a.a;
            if (b2 == 0) {
                jbVar.f();
                if (e()) {
                    a();
                    return;
                }
                throw new jc("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
            }
            switch (m562a.f791a) {
                case 1:
                    if (b2 == 11) {
                        this.f696a = jbVar.m567a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 2:
                    if (b2 == 12) {
                        hu huVar = new hu();
                        this.f695a = huVar;
                        huVar.a(jbVar);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f698b = jbVar.m567a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f699c = jbVar.m567a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 6:
                    if (b2 == 10) {
                        this.f694a = jbVar.m561a();
                        a(true);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f700d = jbVar.m567a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 8:
                    if (b2 == 11) {
                        this.f701e = jbVar.m567a();
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
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.f697a.set(0, z);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m526a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f696a != null : invokeV.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m527a(ih ihVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, ihVar)) == null) {
            if (ihVar == null) {
                return false;
            }
            boolean m526a = m526a();
            boolean m526a2 = ihVar.m526a();
            if ((m526a || m526a2) && !(m526a && m526a2 && this.f696a.equals(ihVar.f696a))) {
                return false;
            }
            boolean b2 = b();
            boolean b3 = ihVar.b();
            if ((b2 || b3) && !(b2 && b3 && this.f695a.m461a(ihVar.f695a))) {
                return false;
            }
            boolean c2 = c();
            boolean c3 = ihVar.c();
            if ((c2 || c3) && !(c2 && c3 && this.f698b.equals(ihVar.f698b))) {
                return false;
            }
            boolean d2 = d();
            boolean d3 = ihVar.d();
            if (((d2 || d3) && !(d2 && d3 && this.f699c.equals(ihVar.f699c))) || this.f694a != ihVar.f694a) {
                return false;
            }
            boolean f2 = f();
            boolean f3 = ihVar.f();
            if ((f2 || f3) && !(f2 && f3 && this.f700d.equals(ihVar.f700d))) {
                return false;
            }
            boolean g2 = g();
            boolean g3 = ihVar.g();
            if (g2 || g3) {
                return g2 && g3 && this.f701e.equals(ihVar.f701e);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.xiaomi.push.iq
    public void b(jb jbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, jbVar) == null) {
            a();
            jbVar.a(f693a);
            if (this.f696a != null && m526a()) {
                jbVar.a(a);
                jbVar.a(this.f696a);
                jbVar.b();
            }
            if (this.f695a != null && b()) {
                jbVar.a(f44456b);
                this.f695a.b(jbVar);
                jbVar.b();
            }
            if (this.f698b != null) {
                jbVar.a(f44457c);
                jbVar.a(this.f698b);
                jbVar.b();
            }
            if (this.f699c != null) {
                jbVar.a(f44458d);
                jbVar.a(this.f699c);
                jbVar.b();
            }
            jbVar.a(f44459e);
            jbVar.a(this.f694a);
            jbVar.b();
            if (this.f700d != null && f()) {
                jbVar.a(f44460f);
                jbVar.a(this.f700d);
                jbVar.b();
            }
            if (this.f701e != null && g()) {
                jbVar.a(f44461g);
                jbVar.a(this.f701e);
                jbVar.b();
            }
            jbVar.c();
            jbVar.m570a();
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f695a != null : invokeV.booleanValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f698b != null : invokeV.booleanValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f699c != null : invokeV.booleanValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f697a.get(0) : invokeV.booleanValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, obj)) == null) {
            if (obj != null && (obj instanceof ih)) {
                return m527a((ih) obj);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f700d != null : invokeV.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f701e != null : invokeV.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            StringBuilder sb = new StringBuilder("XmPushActionSendFeedbackResult(");
            boolean z2 = false;
            if (m526a()) {
                sb.append("debug:");
                String str = this.f696a;
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
                hu huVar = this.f695a;
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
            String str2 = this.f698b;
            if (str2 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str2);
            }
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("appId:");
            String str3 = this.f699c;
            if (str3 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str3);
            }
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("errorCode:");
            sb.append(this.f694a);
            if (f()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("reason:");
                String str4 = this.f700d;
                if (str4 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str4);
                }
            }
            if (g()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("category:");
                String str5 = this.f701e;
                if (str5 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str5);
                }
            }
            sb.append(SmallTailInfo.EMOTION_SUFFIX);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
