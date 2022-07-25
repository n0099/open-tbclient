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
import com.bumptech.glide.disklrucache.StrictLineReader;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes8.dex */
public class ii implements iu<ii, Object>, Serializable, Cloneable {
    public static /* synthetic */ Interceptable $ic;
    public static final jc a;

    /* renamed from: a  reason: collision with other field name */
    public static final jk f638a;
    public static final jc b;
    public static final jc c;
    public static final jc d;
    public static final jc e;
    public static final jc f;
    public static final jc g;
    public static final jc h;
    public static final jc i;
    public static final jc j;
    public static final jc k;
    public static final jc l;
    public static final jc m;
    public static final jc n;
    public static final jc o;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public long f639a;

    /* renamed from: a  reason: collision with other field name */
    public hy f640a;

    /* renamed from: a  reason: collision with other field name */
    public String f641a;

    /* renamed from: a  reason: collision with other field name */
    public ByteBuffer f642a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f643a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f644a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f645a;

    /* renamed from: b  reason: collision with other field name */
    public String f646b;

    /* renamed from: b  reason: collision with other field name */
    public boolean f647b;

    /* renamed from: c  reason: collision with other field name */
    public String f648c;

    /* renamed from: d  reason: collision with other field name */
    public String f649d;

    /* renamed from: e  reason: collision with other field name */
    public String f650e;

    /* renamed from: f  reason: collision with other field name */
    public String f651f;

    /* renamed from: g  reason: collision with other field name */
    public String f652g;

    /* renamed from: h  reason: collision with other field name */
    public String f653h;

    /* renamed from: i  reason: collision with other field name */
    public String f654i;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-56371936, "Lcom/xiaomi/push/ii;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-56371936, "Lcom/xiaomi/push/ii;");
                return;
            }
        }
        f638a = new jk("XmPushActionNotification");
        a = new jc("", Constants.GZIP_CAST_TYPE, (short) 1);
        b = new jc("", (byte) 12, (short) 2);
        c = new jc("", Constants.GZIP_CAST_TYPE, (short) 3);
        d = new jc("", Constants.GZIP_CAST_TYPE, (short) 4);
        e = new jc("", Constants.GZIP_CAST_TYPE, (short) 5);
        f = new jc("", (byte) 2, (short) 6);
        g = new jc("", Constants.GZIP_CAST_TYPE, (short) 7);
        h = new jc("", StrictLineReader.CR, (short) 8);
        i = new jc("", Constants.GZIP_CAST_TYPE, (short) 9);
        j = new jc("", Constants.GZIP_CAST_TYPE, (short) 10);
        k = new jc("", Constants.GZIP_CAST_TYPE, (short) 12);
        l = new jc("", Constants.GZIP_CAST_TYPE, (short) 13);
        m = new jc("", Constants.GZIP_CAST_TYPE, (short) 14);
        n = new jc("", (byte) 10, (short) 15);
        o = new jc("", (byte) 2, (short) 20);
    }

    public ii() {
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
        this.f643a = new BitSet(3);
        this.f645a = true;
        this.f647b = false;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ii(String str, boolean z) {
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
        this.f646b = str;
        this.f645a = z;
        m483a(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(ii iiVar) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, iiVar)) == null) {
            if (ii.class.equals(iiVar.getClass())) {
                int compareTo = Boolean.valueOf(m484a()).compareTo(Boolean.valueOf(iiVar.m484a()));
                if (compareTo != 0) {
                    return compareTo;
                }
                if (!m484a() || (a16 = iv.a(this.f641a, iiVar.f641a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m487b()).compareTo(Boolean.valueOf(iiVar.m487b()));
                    if (compareTo2 != 0) {
                        return compareTo2;
                    }
                    if (!m487b() || (a15 = iv.a(this.f640a, iiVar.f640a)) == 0) {
                        int compareTo3 = Boolean.valueOf(m488c()).compareTo(Boolean.valueOf(iiVar.m488c()));
                        if (compareTo3 != 0) {
                            return compareTo3;
                        }
                        if (!m488c() || (a14 = iv.a(this.f646b, iiVar.f646b)) == 0) {
                            int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(iiVar.d()));
                            if (compareTo4 != 0) {
                                return compareTo4;
                            }
                            if (!d() || (a13 = iv.a(this.f648c, iiVar.f648c)) == 0) {
                                int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(iiVar.e()));
                                if (compareTo5 != 0) {
                                    return compareTo5;
                                }
                                if (!e() || (a12 = iv.a(this.f649d, iiVar.f649d)) == 0) {
                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(iiVar.f()));
                                    if (compareTo6 != 0) {
                                        return compareTo6;
                                    }
                                    if (!f() || (a11 = iv.a(this.f645a, iiVar.f645a)) == 0) {
                                        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(iiVar.g()));
                                        if (compareTo7 != 0) {
                                            return compareTo7;
                                        }
                                        if (!g() || (a10 = iv.a(this.f650e, iiVar.f650e)) == 0) {
                                            int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(iiVar.h()));
                                            if (compareTo8 != 0) {
                                                return compareTo8;
                                            }
                                            if (!h() || (a9 = iv.a(this.f644a, iiVar.f644a)) == 0) {
                                                int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(iiVar.i()));
                                                if (compareTo9 != 0) {
                                                    return compareTo9;
                                                }
                                                if (!i() || (a8 = iv.a(this.f651f, iiVar.f651f)) == 0) {
                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(iiVar.j()));
                                                    if (compareTo10 != 0) {
                                                        return compareTo10;
                                                    }
                                                    if (!j() || (a7 = iv.a(this.f652g, iiVar.f652g)) == 0) {
                                                        int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(iiVar.k()));
                                                        if (compareTo11 != 0) {
                                                            return compareTo11;
                                                        }
                                                        if (!k() || (a6 = iv.a(this.f653h, iiVar.f653h)) == 0) {
                                                            int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(iiVar.l()));
                                                            if (compareTo12 != 0) {
                                                                return compareTo12;
                                                            }
                                                            if (!l() || (a5 = iv.a(this.f654i, iiVar.f654i)) == 0) {
                                                                int compareTo13 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(iiVar.m()));
                                                                if (compareTo13 != 0) {
                                                                    return compareTo13;
                                                                }
                                                                if (!m() || (a4 = iv.a(this.f642a, iiVar.f642a)) == 0) {
                                                                    int compareTo14 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(iiVar.n()));
                                                                    if (compareTo14 != 0) {
                                                                        return compareTo14;
                                                                    }
                                                                    if (!n() || (a3 = iv.a(this.f639a, iiVar.f639a)) == 0) {
                                                                        int compareTo15 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(iiVar.o()));
                                                                        if (compareTo15 != 0) {
                                                                            return compareTo15;
                                                                        }
                                                                        if (!o() || (a2 = iv.a(this.f647b, iiVar.f647b)) == 0) {
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
            return ii.class.getName().compareTo(iiVar.getClass().getName());
        }
        return invokeL.intValue;
    }

    public hy a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f640a : (hy) invokeV.objValue;
    }

    public ii a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            this.f646b = str;
            return this;
        }
        return (ii) invokeL.objValue;
    }

    public ii a(ByteBuffer byteBuffer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, byteBuffer)) == null) {
            this.f642a = byteBuffer;
            return this;
        }
        return (ii) invokeL.objValue;
    }

    public ii a(Map<String, String> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, map)) == null) {
            this.f644a = map;
            return this;
        }
        return (ii) invokeL.objValue;
    }

    public ii a(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048581, this, z)) == null) {
            this.f645a = z;
            m483a(true);
            return this;
        }
        return (ii) invokeZ.objValue;
    }

    public ii a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, bArr)) == null) {
            a(ByteBuffer.wrap(bArr));
            return this;
        }
        return (ii) invokeL.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m480a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f646b : (String) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public Map<String, String> m481a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f644a : (Map) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m482a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && this.f646b == null) {
            throw new jg("Required field 'id' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.iu
    public void a(jf jfVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(1048586, this, jfVar) != null) {
            return;
        }
        jfVar.m549a();
        while (true) {
            jc m545a = jfVar.m545a();
            byte b2 = m545a.a;
            if (b2 == 0) {
                jfVar.f();
                if (f()) {
                    m482a();
                    return;
                }
                throw new jg("Required field 'requireAck' was not found in serialized data! Struct: " + toString());
            }
            switch (m545a.f809a) {
                case 1:
                    if (b2 == 11) {
                        this.f641a = jfVar.m550a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 2:
                    if (b2 == 12) {
                        hy hyVar = new hy();
                        this.f640a = hyVar;
                        hyVar.a(jfVar);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f646b = jfVar.m550a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f648c = jfVar.m550a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 5:
                    if (b2 == 11) {
                        this.f649d = jfVar.m550a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 6:
                    if (b2 == 2) {
                        this.f645a = jfVar.m554a();
                        m483a(true);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f650e = jfVar.m550a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 8:
                    if (b2 == 13) {
                        je m547a = jfVar.m547a();
                        this.f644a = new HashMap(m547a.f811a * 2);
                        for (int i2 = 0; i2 < m547a.f811a; i2++) {
                            this.f644a.put(jfVar.m550a(), jfVar.m550a());
                        }
                        jfVar.h();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 9:
                    if (b2 == 11) {
                        this.f651f = jfVar.m550a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 10:
                    if (b2 == 11) {
                        this.f652g = jfVar.m550a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 12:
                    if (b2 == 11) {
                        this.f653h = jfVar.m550a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 13:
                    if (b2 == 11) {
                        this.f654i = jfVar.m550a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 14:
                    if (b2 == 11) {
                        this.f642a = jfVar.m551a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 15:
                    if (b2 == 10) {
                        this.f639a = jfVar.m544a();
                        b(true);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 20:
                    if (b2 == 2) {
                        this.f647b = jfVar.m554a();
                        c(true);
                        continue;
                        jfVar.g();
                    }
                    break;
            }
            ji.a(jfVar, b2);
            jfVar.g();
        }
    }

    public void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, str, str2) == null) {
            if (this.f644a == null) {
                this.f644a = new HashMap();
            }
            this.f644a.put(str, str2);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m483a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.f643a.set(0, z);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m484a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f641a != null : invokeV.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m485a(ii iiVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, iiVar)) == null) {
            if (iiVar == null) {
                return false;
            }
            boolean m484a = m484a();
            boolean m484a2 = iiVar.m484a();
            if ((m484a || m484a2) && !(m484a && m484a2 && this.f641a.equals(iiVar.f641a))) {
                return false;
            }
            boolean m487b = m487b();
            boolean m487b2 = iiVar.m487b();
            if ((m487b || m487b2) && !(m487b && m487b2 && this.f640a.m443a(iiVar.f640a))) {
                return false;
            }
            boolean m488c = m488c();
            boolean m488c2 = iiVar.m488c();
            if ((m488c || m488c2) && !(m488c && m488c2 && this.f646b.equals(iiVar.f646b))) {
                return false;
            }
            boolean d2 = d();
            boolean d3 = iiVar.d();
            if ((d2 || d3) && !(d2 && d3 && this.f648c.equals(iiVar.f648c))) {
                return false;
            }
            boolean e2 = e();
            boolean e3 = iiVar.e();
            if (((e2 || e3) && !(e2 && e3 && this.f649d.equals(iiVar.f649d))) || this.f645a != iiVar.f645a) {
                return false;
            }
            boolean g2 = g();
            boolean g3 = iiVar.g();
            if ((g2 || g3) && !(g2 && g3 && this.f650e.equals(iiVar.f650e))) {
                return false;
            }
            boolean h2 = h();
            boolean h3 = iiVar.h();
            if ((h2 || h3) && !(h2 && h3 && this.f644a.equals(iiVar.f644a))) {
                return false;
            }
            boolean i2 = i();
            boolean i3 = iiVar.i();
            if ((i2 || i3) && !(i2 && i3 && this.f651f.equals(iiVar.f651f))) {
                return false;
            }
            boolean j2 = j();
            boolean j3 = iiVar.j();
            if ((j2 || j3) && !(j2 && j3 && this.f652g.equals(iiVar.f652g))) {
                return false;
            }
            boolean k2 = k();
            boolean k3 = iiVar.k();
            if ((k2 || k3) && !(k2 && k3 && this.f653h.equals(iiVar.f653h))) {
                return false;
            }
            boolean l2 = l();
            boolean l3 = iiVar.l();
            if ((l2 || l3) && !(l2 && l3 && this.f654i.equals(iiVar.f654i))) {
                return false;
            }
            boolean m2 = m();
            boolean m3 = iiVar.m();
            if ((m2 || m3) && !(m2 && m3 && this.f642a.equals(iiVar.f642a))) {
                return false;
            }
            boolean n2 = n();
            boolean n3 = iiVar.n();
            if ((n2 || n3) && !(n2 && n3 && this.f639a == iiVar.f639a)) {
                return false;
            }
            boolean o2 = o();
            boolean o3 = iiVar.o();
            if (o2 || o3) {
                return o2 && o3 && this.f647b == iiVar.f647b;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m486a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            a(iv.a(this.f642a));
            return this.f642a.array();
        }
        return (byte[]) invokeV.objValue;
    }

    public ii b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, str)) == null) {
            this.f648c = str;
            return this;
        }
        return (ii) invokeL.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.f648c : (String) invokeV.objValue;
    }

    @Override // com.xiaomi.push.iu
    public void b(jf jfVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, jfVar) == null) {
            m482a();
            jfVar.a(f638a);
            if (this.f641a != null && m484a()) {
                jfVar.a(a);
                jfVar.a(this.f641a);
                jfVar.b();
            }
            if (this.f640a != null && m487b()) {
                jfVar.a(b);
                this.f640a.b(jfVar);
                jfVar.b();
            }
            if (this.f646b != null) {
                jfVar.a(c);
                jfVar.a(this.f646b);
                jfVar.b();
            }
            if (this.f648c != null && d()) {
                jfVar.a(d);
                jfVar.a(this.f648c);
                jfVar.b();
            }
            if (this.f649d != null && e()) {
                jfVar.a(e);
                jfVar.a(this.f649d);
                jfVar.b();
            }
            jfVar.a(f);
            jfVar.a(this.f645a);
            jfVar.b();
            if (this.f650e != null && g()) {
                jfVar.a(g);
                jfVar.a(this.f650e);
                jfVar.b();
            }
            if (this.f644a != null && h()) {
                jfVar.a(h);
                jfVar.a(new je(Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, this.f644a.size()));
                for (Map.Entry<String, String> entry : this.f644a.entrySet()) {
                    jfVar.a(entry.getKey());
                    jfVar.a(entry.getValue());
                }
                jfVar.d();
                jfVar.b();
            }
            if (this.f651f != null && i()) {
                jfVar.a(i);
                jfVar.a(this.f651f);
                jfVar.b();
            }
            if (this.f652g != null && j()) {
                jfVar.a(j);
                jfVar.a(this.f652g);
                jfVar.b();
            }
            if (this.f653h != null && k()) {
                jfVar.a(k);
                jfVar.a(this.f653h);
                jfVar.b();
            }
            if (this.f654i != null && l()) {
                jfVar.a(l);
                jfVar.a(this.f654i);
                jfVar.b();
            }
            if (this.f642a != null && m()) {
                jfVar.a(m);
                jfVar.a(this.f642a);
                jfVar.b();
            }
            if (n()) {
                jfVar.a(n);
                jfVar.a(this.f639a);
                jfVar.b();
            }
            if (o()) {
                jfVar.a(o);
                jfVar.a(this.f647b);
                jfVar.b();
            }
            jfVar.c();
            jfVar.m553a();
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            this.f643a.set(1, z);
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m487b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f640a != null : invokeV.booleanValue;
    }

    public ii c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, str)) == null) {
            this.f649d = str;
            return this;
        }
        return (ii) invokeL.objValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.f651f : (String) invokeV.objValue;
    }

    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            this.f643a.set(2, z);
        }
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m488c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.f646b != null : invokeV.booleanValue;
    }

    public ii d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, str)) == null) {
            this.f651f = str;
            return this;
        }
        return (ii) invokeL.objValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.f648c != null : invokeV.booleanValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.f649d != null : invokeV.booleanValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, obj)) == null) {
            if (obj != null && (obj instanceof ii)) {
                return m485a((ii) obj);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.f643a.get(0) : invokeV.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.f650e != null : invokeV.booleanValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.f644a != null : invokeV.booleanValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.f651f != null : invokeV.booleanValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? this.f652g != null : invokeV.booleanValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.f653h != null : invokeV.booleanValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? this.f654i != null : invokeV.booleanValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? this.f642a != null : invokeV.booleanValue;
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? this.f643a.get(1) : invokeV.booleanValue;
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? this.f643a.get(2) : invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            StringBuilder sb = new StringBuilder("XmPushActionNotification(");
            boolean z2 = false;
            if (m484a()) {
                sb.append("debug:");
                String str = this.f641a;
                if (str == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str);
                }
                z = false;
            } else {
                z = true;
            }
            if (m487b()) {
                if (!z) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                }
                sb.append("target:");
                hy hyVar = this.f640a;
                if (hyVar == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(hyVar);
                }
            } else {
                z2 = z;
            }
            if (!z2) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            }
            sb.append("id:");
            String str2 = this.f646b;
            if (str2 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str2);
            }
            if (d()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("appId:");
                String str3 = this.f648c;
                if (str3 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str3);
                }
            }
            if (e()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("type:");
                String str4 = this.f649d;
                if (str4 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str4);
                }
            }
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("requireAck:");
            sb.append(this.f645a);
            if (g()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("payload:");
                String str5 = this.f650e;
                if (str5 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str5);
                }
            }
            if (h()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("extra:");
                Map<String, String> map = this.f644a;
                if (map == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(map);
                }
            }
            if (i()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("packageName:");
                String str6 = this.f651f;
                if (str6 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str6);
                }
            }
            if (j()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("category:");
                String str7 = this.f652g;
                if (str7 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str7);
                }
            }
            if (k()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("regId:");
                String str8 = this.f653h;
                if (str8 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str8);
                }
            }
            if (l()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("aliasName:");
                String str9 = this.f654i;
                if (str9 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str9);
                }
            }
            if (m()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("binaryExtra:");
                ByteBuffer byteBuffer = this.f642a;
                if (byteBuffer == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    iv.a(byteBuffer, sb);
                }
            }
            if (n()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("createdTs:");
                sb.append(this.f639a);
            }
            if (o()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("alreadyLogClickInXmq:");
                sb.append(this.f647b);
            }
            sb.append(SmallTailInfo.EMOTION_SUFFIX);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
