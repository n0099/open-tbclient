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
import java.nio.ByteBuffer;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes10.dex */
public class ie implements iq<ie, Object>, Serializable, Cloneable {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final iy f77542a;

    /* renamed from: a  reason: collision with other field name */
    public static final jg f648a;

    /* renamed from: b  reason: collision with root package name */
    public static final iy f77543b;

    /* renamed from: c  reason: collision with root package name */
    public static final iy f77544c;

    /* renamed from: d  reason: collision with root package name */
    public static final iy f77545d;

    /* renamed from: e  reason: collision with root package name */
    public static final iy f77546e;

    /* renamed from: f  reason: collision with root package name */
    public static final iy f77547f;

    /* renamed from: g  reason: collision with root package name */
    public static final iy f77548g;

    /* renamed from: h  reason: collision with root package name */
    public static final iy f77549h;

    /* renamed from: i  reason: collision with root package name */
    public static final iy f77550i;

    /* renamed from: j  reason: collision with root package name */
    public static final iy f77551j;
    public static final iy k;
    public static final iy l;
    public static final iy m;
    public static final iy n;
    public static final iy o;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public long f649a;

    /* renamed from: a  reason: collision with other field name */
    public hu f650a;

    /* renamed from: a  reason: collision with other field name */
    public String f651a;

    /* renamed from: a  reason: collision with other field name */
    public ByteBuffer f652a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f653a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f654a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f655a;

    /* renamed from: b  reason: collision with other field name */
    public String f656b;

    /* renamed from: b  reason: collision with other field name */
    public boolean f657b;

    /* renamed from: c  reason: collision with other field name */
    public String f658c;

    /* renamed from: d  reason: collision with other field name */
    public String f659d;

    /* renamed from: e  reason: collision with other field name */
    public String f660e;

    /* renamed from: f  reason: collision with other field name */
    public String f661f;

    /* renamed from: g  reason: collision with other field name */
    public String f662g;

    /* renamed from: h  reason: collision with other field name */
    public String f663h;

    /* renamed from: i  reason: collision with other field name */
    public String f664i;

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
        f648a = new jg("XmPushActionNotification");
        f77542a = new iy("", (byte) 11, (short) 1);
        f77543b = new iy("", StandardMessageCodec.LIST, (short) 2);
        f77544c = new iy("", (byte) 11, (short) 3);
        f77545d = new iy("", (byte) 11, (short) 4);
        f77546e = new iy("", (byte) 11, (short) 5);
        f77547f = new iy("", (byte) 2, (short) 6);
        f77548g = new iy("", (byte) 11, (short) 7);
        f77549h = new iy("", (byte) 13, (short) 8);
        f77550i = new iy("", (byte) 11, (short) 9);
        f77551j = new iy("", (byte) 11, (short) 10);
        k = new iy("", (byte) 11, (short) 12);
        l = new iy("", (byte) 11, (short) 13);
        m = new iy("", (byte) 11, (short) 14);
        n = new iy("", (byte) 10, (short) 15);
        o = new iy("", (byte) 2, (short) 20);
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
        this.f653a = new BitSet(3);
        this.f655a = true;
        this.f657b = false;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ie(String str, boolean z) {
        this();
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f656b = str;
        this.f655a = z;
        m471a(true);
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
        int a12;
        int a13;
        int a14;
        int a15;
        int a16;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, ieVar)) == null) {
            if (ie.class.equals(ieVar.getClass())) {
                int compareTo = Boolean.valueOf(m472a()).compareTo(Boolean.valueOf(ieVar.m472a()));
                if (compareTo != 0) {
                    return compareTo;
                }
                if (!m472a() || (a16 = ir.a(this.f651a, ieVar.f651a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m475b()).compareTo(Boolean.valueOf(ieVar.m475b()));
                    if (compareTo2 != 0) {
                        return compareTo2;
                    }
                    if (!m475b() || (a15 = ir.a(this.f650a, ieVar.f650a)) == 0) {
                        int compareTo3 = Boolean.valueOf(m476c()).compareTo(Boolean.valueOf(ieVar.m476c()));
                        if (compareTo3 != 0) {
                            return compareTo3;
                        }
                        if (!m476c() || (a14 = ir.a(this.f656b, ieVar.f656b)) == 0) {
                            int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(ieVar.d()));
                            if (compareTo4 != 0) {
                                return compareTo4;
                            }
                            if (!d() || (a13 = ir.a(this.f658c, ieVar.f658c)) == 0) {
                                int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(ieVar.e()));
                                if (compareTo5 != 0) {
                                    return compareTo5;
                                }
                                if (!e() || (a12 = ir.a(this.f659d, ieVar.f659d)) == 0) {
                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(ieVar.f()));
                                    if (compareTo6 != 0) {
                                        return compareTo6;
                                    }
                                    if (!f() || (a11 = ir.a(this.f655a, ieVar.f655a)) == 0) {
                                        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ieVar.g()));
                                        if (compareTo7 != 0) {
                                            return compareTo7;
                                        }
                                        if (!g() || (a10 = ir.a(this.f660e, ieVar.f660e)) == 0) {
                                            int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(ieVar.h()));
                                            if (compareTo8 != 0) {
                                                return compareTo8;
                                            }
                                            if (!h() || (a9 = ir.a(this.f654a, ieVar.f654a)) == 0) {
                                                int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(ieVar.i()));
                                                if (compareTo9 != 0) {
                                                    return compareTo9;
                                                }
                                                if (!i() || (a8 = ir.a(this.f661f, ieVar.f661f)) == 0) {
                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(ieVar.j()));
                                                    if (compareTo10 != 0) {
                                                        return compareTo10;
                                                    }
                                                    if (!j() || (a7 = ir.a(this.f662g, ieVar.f662g)) == 0) {
                                                        int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(ieVar.k()));
                                                        if (compareTo11 != 0) {
                                                            return compareTo11;
                                                        }
                                                        if (!k() || (a6 = ir.a(this.f663h, ieVar.f663h)) == 0) {
                                                            int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(ieVar.l()));
                                                            if (compareTo12 != 0) {
                                                                return compareTo12;
                                                            }
                                                            if (!l() || (a5 = ir.a(this.f664i, ieVar.f664i)) == 0) {
                                                                int compareTo13 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(ieVar.m()));
                                                                if (compareTo13 != 0) {
                                                                    return compareTo13;
                                                                }
                                                                if (!m() || (a4 = ir.a(this.f652a, ieVar.f652a)) == 0) {
                                                                    int compareTo14 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(ieVar.n()));
                                                                    if (compareTo14 != 0) {
                                                                        return compareTo14;
                                                                    }
                                                                    if (!n() || (a3 = ir.a(this.f649a, ieVar.f649a)) == 0) {
                                                                        int compareTo15 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(ieVar.o()));
                                                                        if (compareTo15 != 0) {
                                                                            return compareTo15;
                                                                        }
                                                                        if (!o() || (a2 = ir.a(this.f657b, ieVar.f657b)) == 0) {
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
                                return a12;
                            }
                            return a13;
                        }
                        return a14;
                    }
                    return a15;
                }
                return a16;
            }
            return ie.class.getName().compareTo(ieVar.getClass().getName());
        }
        return invokeL.intValue;
    }

    public hu a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f650a : (hu) invokeV.objValue;
    }

    public ie a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            this.f656b = str;
            return this;
        }
        return (ie) invokeL.objValue;
    }

    public ie a(ByteBuffer byteBuffer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, byteBuffer)) == null) {
            this.f652a = byteBuffer;
            return this;
        }
        return (ie) invokeL.objValue;
    }

    public ie a(Map<String, String> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, map)) == null) {
            this.f654a = map;
            return this;
        }
        return (ie) invokeL.objValue;
    }

    public ie a(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048581, this, z)) == null) {
            this.f655a = z;
            m471a(true);
            return this;
        }
        return (ie) invokeZ.objValue;
    }

    public ie a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, bArr)) == null) {
            a(ByteBuffer.wrap(bArr));
            return this;
        }
        return (ie) invokeL.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m468a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f656b : (String) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public Map<String, String> m469a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f654a : (Map) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m470a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && this.f656b == null) {
            throw new jc("Required field 'id' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.iq
    public void a(jb jbVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(1048586, this, jbVar) != null) {
            return;
        }
        jbVar.m527a();
        while (true) {
            iy m523a = jbVar.m523a();
            byte b2 = m523a.f77655a;
            if (b2 == 0) {
                jbVar.f();
                if (f()) {
                    m470a();
                    return;
                }
                throw new jc("Required field 'requireAck' was not found in serialized data! Struct: " + toString());
            }
            switch (m523a.f814a) {
                case 1:
                    if (b2 == 11) {
                        this.f651a = jbVar.m528a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 2:
                    if (b2 == 12) {
                        hu huVar = new hu();
                        this.f650a = huVar;
                        huVar.a(jbVar);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f656b = jbVar.m528a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f658c = jbVar.m528a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 5:
                    if (b2 == 11) {
                        this.f659d = jbVar.m528a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 6:
                    if (b2 == 2) {
                        this.f655a = jbVar.m532a();
                        m471a(true);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f660e = jbVar.m528a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 8:
                    if (b2 == 13) {
                        ja m525a = jbVar.m525a();
                        this.f654a = new HashMap(m525a.f818a * 2);
                        for (int i2 = 0; i2 < m525a.f818a; i2++) {
                            this.f654a.put(jbVar.m528a(), jbVar.m528a());
                        }
                        jbVar.h();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 9:
                    if (b2 == 11) {
                        this.f661f = jbVar.m528a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 10:
                    if (b2 == 11) {
                        this.f662g = jbVar.m528a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 12:
                    if (b2 == 11) {
                        this.f663h = jbVar.m528a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 13:
                    if (b2 == 11) {
                        this.f664i = jbVar.m528a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 14:
                    if (b2 == 11) {
                        this.f652a = jbVar.m529a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 15:
                    if (b2 == 10) {
                        this.f649a = jbVar.m522a();
                        b(true);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 20:
                    if (b2 == 2) {
                        this.f657b = jbVar.m532a();
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

    public void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, str, str2) == null) {
            if (this.f654a == null) {
                this.f654a = new HashMap();
            }
            this.f654a.put(str, str2);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m471a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.f653a.set(0, z);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m472a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f651a != null : invokeV.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m473a(ie ieVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, ieVar)) == null) {
            if (ieVar == null) {
                return false;
            }
            boolean m472a = m472a();
            boolean m472a2 = ieVar.m472a();
            if ((m472a || m472a2) && !(m472a && m472a2 && this.f651a.equals(ieVar.f651a))) {
                return false;
            }
            boolean m475b = m475b();
            boolean m475b2 = ieVar.m475b();
            if ((m475b || m475b2) && !(m475b && m475b2 && this.f650a.m422a(ieVar.f650a))) {
                return false;
            }
            boolean m476c = m476c();
            boolean m476c2 = ieVar.m476c();
            if ((m476c || m476c2) && !(m476c && m476c2 && this.f656b.equals(ieVar.f656b))) {
                return false;
            }
            boolean d2 = d();
            boolean d3 = ieVar.d();
            if ((d2 || d3) && !(d2 && d3 && this.f658c.equals(ieVar.f658c))) {
                return false;
            }
            boolean e2 = e();
            boolean e3 = ieVar.e();
            if (((e2 || e3) && !(e2 && e3 && this.f659d.equals(ieVar.f659d))) || this.f655a != ieVar.f655a) {
                return false;
            }
            boolean g2 = g();
            boolean g3 = ieVar.g();
            if ((g2 || g3) && !(g2 && g3 && this.f660e.equals(ieVar.f660e))) {
                return false;
            }
            boolean h2 = h();
            boolean h3 = ieVar.h();
            if ((h2 || h3) && !(h2 && h3 && this.f654a.equals(ieVar.f654a))) {
                return false;
            }
            boolean i2 = i();
            boolean i3 = ieVar.i();
            if ((i2 || i3) && !(i2 && i3 && this.f661f.equals(ieVar.f661f))) {
                return false;
            }
            boolean j2 = j();
            boolean j3 = ieVar.j();
            if ((j2 || j3) && !(j2 && j3 && this.f662g.equals(ieVar.f662g))) {
                return false;
            }
            boolean k2 = k();
            boolean k3 = ieVar.k();
            if ((k2 || k3) && !(k2 && k3 && this.f663h.equals(ieVar.f663h))) {
                return false;
            }
            boolean l2 = l();
            boolean l3 = ieVar.l();
            if ((l2 || l3) && !(l2 && l3 && this.f664i.equals(ieVar.f664i))) {
                return false;
            }
            boolean m2 = m();
            boolean m3 = ieVar.m();
            if ((m2 || m3) && !(m2 && m3 && this.f652a.equals(ieVar.f652a))) {
                return false;
            }
            boolean n2 = n();
            boolean n3 = ieVar.n();
            if ((n2 || n3) && !(n2 && n3 && this.f649a == ieVar.f649a)) {
                return false;
            }
            boolean o2 = o();
            boolean o3 = ieVar.o();
            if (o2 || o3) {
                return o2 && o3 && this.f657b == ieVar.f657b;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m474a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            a(ir.a(this.f652a));
            return this.f652a.array();
        }
        return (byte[]) invokeV.objValue;
    }

    public ie b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, str)) == null) {
            this.f658c = str;
            return this;
        }
        return (ie) invokeL.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.f658c : (String) invokeV.objValue;
    }

    @Override // com.xiaomi.push.iq
    public void b(jb jbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, jbVar) == null) {
            m470a();
            jbVar.a(f648a);
            if (this.f651a != null && m472a()) {
                jbVar.a(f77542a);
                jbVar.a(this.f651a);
                jbVar.b();
            }
            if (this.f650a != null && m475b()) {
                jbVar.a(f77543b);
                this.f650a.b(jbVar);
                jbVar.b();
            }
            if (this.f656b != null) {
                jbVar.a(f77544c);
                jbVar.a(this.f656b);
                jbVar.b();
            }
            if (this.f658c != null && d()) {
                jbVar.a(f77545d);
                jbVar.a(this.f658c);
                jbVar.b();
            }
            if (this.f659d != null && e()) {
                jbVar.a(f77546e);
                jbVar.a(this.f659d);
                jbVar.b();
            }
            jbVar.a(f77547f);
            jbVar.a(this.f655a);
            jbVar.b();
            if (this.f660e != null && g()) {
                jbVar.a(f77548g);
                jbVar.a(this.f660e);
                jbVar.b();
            }
            if (this.f654a != null && h()) {
                jbVar.a(f77549h);
                jbVar.a(new ja((byte) 11, (byte) 11, this.f654a.size()));
                for (Map.Entry<String, String> entry : this.f654a.entrySet()) {
                    jbVar.a(entry.getKey());
                    jbVar.a(entry.getValue());
                }
                jbVar.d();
                jbVar.b();
            }
            if (this.f661f != null && i()) {
                jbVar.a(f77550i);
                jbVar.a(this.f661f);
                jbVar.b();
            }
            if (this.f662g != null && j()) {
                jbVar.a(f77551j);
                jbVar.a(this.f662g);
                jbVar.b();
            }
            if (this.f663h != null && k()) {
                jbVar.a(k);
                jbVar.a(this.f663h);
                jbVar.b();
            }
            if (this.f664i != null && l()) {
                jbVar.a(l);
                jbVar.a(this.f664i);
                jbVar.b();
            }
            if (this.f652a != null && m()) {
                jbVar.a(m);
                jbVar.a(this.f652a);
                jbVar.b();
            }
            if (n()) {
                jbVar.a(n);
                jbVar.a(this.f649a);
                jbVar.b();
            }
            if (o()) {
                jbVar.a(o);
                jbVar.a(this.f657b);
                jbVar.b();
            }
            jbVar.c();
            jbVar.m531a();
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            this.f653a.set(1, z);
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m475b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f650a != null : invokeV.booleanValue;
    }

    public ie c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, str)) == null) {
            this.f659d = str;
            return this;
        }
        return (ie) invokeL.objValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.f661f : (String) invokeV.objValue;
    }

    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            this.f653a.set(2, z);
        }
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m476c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.f656b != null : invokeV.booleanValue;
    }

    public ie d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, str)) == null) {
            this.f661f = str;
            return this;
        }
        return (ie) invokeL.objValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.f658c != null : invokeV.booleanValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.f659d != null : invokeV.booleanValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, obj)) == null) {
            if (obj != null && (obj instanceof ie)) {
                return m473a((ie) obj);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.f653a.get(0) : invokeV.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.f660e != null : invokeV.booleanValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.f654a != null : invokeV.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.f661f != null : invokeV.booleanValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? this.f662g != null : invokeV.booleanValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.f663h != null : invokeV.booleanValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? this.f664i != null : invokeV.booleanValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? this.f652a != null : invokeV.booleanValue;
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? this.f653a.get(1) : invokeV.booleanValue;
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? this.f653a.get(2) : invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            StringBuilder sb = new StringBuilder("XmPushActionNotification(");
            boolean z2 = false;
            if (m472a()) {
                sb.append("debug:");
                String str = this.f651a;
                if (str == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str);
                }
                z = false;
            } else {
                z = true;
            }
            if (m475b()) {
                if (!z) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                }
                sb.append("target:");
                hu huVar = this.f650a;
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
            String str2 = this.f656b;
            if (str2 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str2);
            }
            if (d()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("appId:");
                String str3 = this.f658c;
                if (str3 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str3);
                }
            }
            if (e()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("type:");
                String str4 = this.f659d;
                if (str4 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str4);
                }
            }
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("requireAck:");
            sb.append(this.f655a);
            if (g()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("payload:");
                String str5 = this.f660e;
                if (str5 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str5);
                }
            }
            if (h()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("extra:");
                Map<String, String> map = this.f654a;
                if (map == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(map);
                }
            }
            if (i()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("packageName:");
                String str6 = this.f661f;
                if (str6 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str6);
                }
            }
            if (j()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("category:");
                String str7 = this.f662g;
                if (str7 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str7);
                }
            }
            if (k()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("regId:");
                String str8 = this.f663h;
                if (str8 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str8);
                }
            }
            if (l()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("aliasName:");
                String str9 = this.f664i;
                if (str9 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str9);
                }
            }
            if (m()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("binaryExtra:");
                ByteBuffer byteBuffer = this.f652a;
                if (byteBuffer == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    ir.a(byteBuffer, sb);
                }
            }
            if (n()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("createdTs:");
                sb.append(this.f649a);
            }
            if (o()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("alreadyLogClickInXmq:");
                sb.append(this.f657b);
            }
            sb.append(SmallTailInfo.EMOTION_SUFFIX);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
