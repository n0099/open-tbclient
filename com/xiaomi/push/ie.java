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
import java.nio.ByteBuffer;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes8.dex */
public class ie implements iq<ie, Object>, Serializable, Cloneable {
    public static /* synthetic */ Interceptable $ic;
    public static final iy a;

    /* renamed from: a  reason: collision with other field name */
    public static final jg f625a;
    public static final iy b;
    public static final iy c;
    public static final iy d;
    public static final iy e;
    public static final iy f;
    public static final iy g;
    public static final iy h;
    public static final iy i;
    public static final iy j;
    public static final iy k;
    public static final iy l;
    public static final iy m;
    public static final iy n;
    public static final iy o;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public long f626a;

    /* renamed from: a  reason: collision with other field name */
    public hu f627a;

    /* renamed from: a  reason: collision with other field name */
    public String f628a;

    /* renamed from: a  reason: collision with other field name */
    public ByteBuffer f629a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f630a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f631a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f632a;

    /* renamed from: b  reason: collision with other field name */
    public String f633b;

    /* renamed from: b  reason: collision with other field name */
    public boolean f634b;

    /* renamed from: c  reason: collision with other field name */
    public String f635c;

    /* renamed from: d  reason: collision with other field name */
    public String f636d;

    /* renamed from: e  reason: collision with other field name */
    public String f637e;

    /* renamed from: f  reason: collision with other field name */
    public String f638f;

    /* renamed from: g  reason: collision with other field name */
    public String f639g;

    /* renamed from: h  reason: collision with other field name */
    public String f640h;

    /* renamed from: i  reason: collision with other field name */
    public String f641i;

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
        f625a = new jg("XmPushActionNotification");
        a = new iy("", Constants.GZIP_CAST_TYPE, (short) 1);
        b = new iy("", (byte) 12, (short) 2);
        c = new iy("", Constants.GZIP_CAST_TYPE, (short) 3);
        d = new iy("", Constants.GZIP_CAST_TYPE, (short) 4);
        e = new iy("", Constants.GZIP_CAST_TYPE, (short) 5);
        f = new iy("", (byte) 2, (short) 6);
        g = new iy("", Constants.GZIP_CAST_TYPE, (short) 7);
        h = new iy("", (byte) 13, (short) 8);
        i = new iy("", Constants.GZIP_CAST_TYPE, (short) 9);
        j = new iy("", Constants.GZIP_CAST_TYPE, (short) 10);
        k = new iy("", Constants.GZIP_CAST_TYPE, (short) 12);
        l = new iy("", Constants.GZIP_CAST_TYPE, (short) 13);
        m = new iy("", Constants.GZIP_CAST_TYPE, (short) 14);
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
        this.f630a = new BitSet(3);
        this.f632a = true;
        this.f634b = false;
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
        this.f633b = str;
        this.f632a = z;
        m506a(true);
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
                int compareTo = Boolean.valueOf(m507a()).compareTo(Boolean.valueOf(ieVar.m507a()));
                if (compareTo != 0) {
                    return compareTo;
                }
                if (!m507a() || (a16 = ir.a(this.f628a, ieVar.f628a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m510b()).compareTo(Boolean.valueOf(ieVar.m510b()));
                    if (compareTo2 != 0) {
                        return compareTo2;
                    }
                    if (!m510b() || (a15 = ir.a(this.f627a, ieVar.f627a)) == 0) {
                        int compareTo3 = Boolean.valueOf(m511c()).compareTo(Boolean.valueOf(ieVar.m511c()));
                        if (compareTo3 != 0) {
                            return compareTo3;
                        }
                        if (!m511c() || (a14 = ir.a(this.f633b, ieVar.f633b)) == 0) {
                            int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(ieVar.d()));
                            if (compareTo4 != 0) {
                                return compareTo4;
                            }
                            if (!d() || (a13 = ir.a(this.f635c, ieVar.f635c)) == 0) {
                                int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(ieVar.e()));
                                if (compareTo5 != 0) {
                                    return compareTo5;
                                }
                                if (!e() || (a12 = ir.a(this.f636d, ieVar.f636d)) == 0) {
                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(ieVar.f()));
                                    if (compareTo6 != 0) {
                                        return compareTo6;
                                    }
                                    if (!f() || (a11 = ir.a(this.f632a, ieVar.f632a)) == 0) {
                                        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ieVar.g()));
                                        if (compareTo7 != 0) {
                                            return compareTo7;
                                        }
                                        if (!g() || (a10 = ir.a(this.f637e, ieVar.f637e)) == 0) {
                                            int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(ieVar.h()));
                                            if (compareTo8 != 0) {
                                                return compareTo8;
                                            }
                                            if (!h() || (a9 = ir.a(this.f631a, ieVar.f631a)) == 0) {
                                                int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(ieVar.i()));
                                                if (compareTo9 != 0) {
                                                    return compareTo9;
                                                }
                                                if (!i() || (a8 = ir.a(this.f638f, ieVar.f638f)) == 0) {
                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(ieVar.j()));
                                                    if (compareTo10 != 0) {
                                                        return compareTo10;
                                                    }
                                                    if (!j() || (a7 = ir.a(this.f639g, ieVar.f639g)) == 0) {
                                                        int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(ieVar.k()));
                                                        if (compareTo11 != 0) {
                                                            return compareTo11;
                                                        }
                                                        if (!k() || (a6 = ir.a(this.f640h, ieVar.f640h)) == 0) {
                                                            int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(ieVar.l()));
                                                            if (compareTo12 != 0) {
                                                                return compareTo12;
                                                            }
                                                            if (!l() || (a5 = ir.a(this.f641i, ieVar.f641i)) == 0) {
                                                                int compareTo13 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(ieVar.m()));
                                                                if (compareTo13 != 0) {
                                                                    return compareTo13;
                                                                }
                                                                if (!m() || (a4 = ir.a(this.f629a, ieVar.f629a)) == 0) {
                                                                    int compareTo14 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(ieVar.n()));
                                                                    if (compareTo14 != 0) {
                                                                        return compareTo14;
                                                                    }
                                                                    if (!n() || (a3 = ir.a(this.f626a, ieVar.f626a)) == 0) {
                                                                        int compareTo15 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(ieVar.o()));
                                                                        if (compareTo15 != 0) {
                                                                            return compareTo15;
                                                                        }
                                                                        if (!o() || (a2 = ir.a(this.f634b, ieVar.f634b)) == 0) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f627a : (hu) invokeV.objValue;
    }

    public ie a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            this.f633b = str;
            return this;
        }
        return (ie) invokeL.objValue;
    }

    public ie a(ByteBuffer byteBuffer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, byteBuffer)) == null) {
            this.f629a = byteBuffer;
            return this;
        }
        return (ie) invokeL.objValue;
    }

    public ie a(Map<String, String> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, map)) == null) {
            this.f631a = map;
            return this;
        }
        return (ie) invokeL.objValue;
    }

    public ie a(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048581, this, z)) == null) {
            this.f632a = z;
            m506a(true);
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
    public String m503a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f633b : (String) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public Map<String, String> m504a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f631a : (Map) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m505a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && this.f633b == null) {
            throw new jc("Required field 'id' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.iq
    public void a(jb jbVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(1048586, this, jbVar) != null) {
            return;
        }
        jbVar.m562a();
        while (true) {
            iy m558a = jbVar.m558a();
            byte b2 = m558a.a;
            if (b2 == 0) {
                jbVar.f();
                if (f()) {
                    m505a();
                    return;
                }
                throw new jc("Required field 'requireAck' was not found in serialized data! Struct: " + toString());
            }
            switch (m558a.f791a) {
                case 1:
                    if (b2 == 11) {
                        this.f628a = jbVar.m563a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 2:
                    if (b2 == 12) {
                        hu huVar = new hu();
                        this.f627a = huVar;
                        huVar.a(jbVar);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f633b = jbVar.m563a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f635c = jbVar.m563a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 5:
                    if (b2 == 11) {
                        this.f636d = jbVar.m563a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 6:
                    if (b2 == 2) {
                        this.f632a = jbVar.m567a();
                        m506a(true);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f637e = jbVar.m563a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 8:
                    if (b2 == 13) {
                        ja m560a = jbVar.m560a();
                        this.f631a = new HashMap(m560a.f795a * 2);
                        for (int i2 = 0; i2 < m560a.f795a; i2++) {
                            this.f631a.put(jbVar.m563a(), jbVar.m563a());
                        }
                        jbVar.h();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 9:
                    if (b2 == 11) {
                        this.f638f = jbVar.m563a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 10:
                    if (b2 == 11) {
                        this.f639g = jbVar.m563a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 12:
                    if (b2 == 11) {
                        this.f640h = jbVar.m563a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 13:
                    if (b2 == 11) {
                        this.f641i = jbVar.m563a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 14:
                    if (b2 == 11) {
                        this.f629a = jbVar.m564a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 15:
                    if (b2 == 10) {
                        this.f626a = jbVar.m557a();
                        b(true);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 20:
                    if (b2 == 2) {
                        this.f634b = jbVar.m567a();
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
            if (this.f631a == null) {
                this.f631a = new HashMap();
            }
            this.f631a.put(str, str2);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m506a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.f630a.set(0, z);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m507a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f628a != null : invokeV.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m508a(ie ieVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, ieVar)) == null) {
            if (ieVar == null) {
                return false;
            }
            boolean m507a = m507a();
            boolean m507a2 = ieVar.m507a();
            if ((m507a || m507a2) && !(m507a && m507a2 && this.f628a.equals(ieVar.f628a))) {
                return false;
            }
            boolean m510b = m510b();
            boolean m510b2 = ieVar.m510b();
            if ((m510b || m510b2) && !(m510b && m510b2 && this.f627a.m457a(ieVar.f627a))) {
                return false;
            }
            boolean m511c = m511c();
            boolean m511c2 = ieVar.m511c();
            if ((m511c || m511c2) && !(m511c && m511c2 && this.f633b.equals(ieVar.f633b))) {
                return false;
            }
            boolean d2 = d();
            boolean d3 = ieVar.d();
            if ((d2 || d3) && !(d2 && d3 && this.f635c.equals(ieVar.f635c))) {
                return false;
            }
            boolean e2 = e();
            boolean e3 = ieVar.e();
            if (((e2 || e3) && !(e2 && e3 && this.f636d.equals(ieVar.f636d))) || this.f632a != ieVar.f632a) {
                return false;
            }
            boolean g2 = g();
            boolean g3 = ieVar.g();
            if ((g2 || g3) && !(g2 && g3 && this.f637e.equals(ieVar.f637e))) {
                return false;
            }
            boolean h2 = h();
            boolean h3 = ieVar.h();
            if ((h2 || h3) && !(h2 && h3 && this.f631a.equals(ieVar.f631a))) {
                return false;
            }
            boolean i2 = i();
            boolean i3 = ieVar.i();
            if ((i2 || i3) && !(i2 && i3 && this.f638f.equals(ieVar.f638f))) {
                return false;
            }
            boolean j2 = j();
            boolean j3 = ieVar.j();
            if ((j2 || j3) && !(j2 && j3 && this.f639g.equals(ieVar.f639g))) {
                return false;
            }
            boolean k2 = k();
            boolean k3 = ieVar.k();
            if ((k2 || k3) && !(k2 && k3 && this.f640h.equals(ieVar.f640h))) {
                return false;
            }
            boolean l2 = l();
            boolean l3 = ieVar.l();
            if ((l2 || l3) && !(l2 && l3 && this.f641i.equals(ieVar.f641i))) {
                return false;
            }
            boolean m2 = m();
            boolean m3 = ieVar.m();
            if ((m2 || m3) && !(m2 && m3 && this.f629a.equals(ieVar.f629a))) {
                return false;
            }
            boolean n2 = n();
            boolean n3 = ieVar.n();
            if ((n2 || n3) && !(n2 && n3 && this.f626a == ieVar.f626a)) {
                return false;
            }
            boolean o2 = o();
            boolean o3 = ieVar.o();
            if (o2 || o3) {
                return o2 && o3 && this.f634b == ieVar.f634b;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m509a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            a(ir.a(this.f629a));
            return this.f629a.array();
        }
        return (byte[]) invokeV.objValue;
    }

    public ie b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, str)) == null) {
            this.f635c = str;
            return this;
        }
        return (ie) invokeL.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.f635c : (String) invokeV.objValue;
    }

    @Override // com.xiaomi.push.iq
    public void b(jb jbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, jbVar) == null) {
            m505a();
            jbVar.a(f625a);
            if (this.f628a != null && m507a()) {
                jbVar.a(a);
                jbVar.a(this.f628a);
                jbVar.b();
            }
            if (this.f627a != null && m510b()) {
                jbVar.a(b);
                this.f627a.b(jbVar);
                jbVar.b();
            }
            if (this.f633b != null) {
                jbVar.a(c);
                jbVar.a(this.f633b);
                jbVar.b();
            }
            if (this.f635c != null && d()) {
                jbVar.a(d);
                jbVar.a(this.f635c);
                jbVar.b();
            }
            if (this.f636d != null && e()) {
                jbVar.a(e);
                jbVar.a(this.f636d);
                jbVar.b();
            }
            jbVar.a(f);
            jbVar.a(this.f632a);
            jbVar.b();
            if (this.f637e != null && g()) {
                jbVar.a(g);
                jbVar.a(this.f637e);
                jbVar.b();
            }
            if (this.f631a != null && h()) {
                jbVar.a(h);
                jbVar.a(new ja(Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, this.f631a.size()));
                for (Map.Entry<String, String> entry : this.f631a.entrySet()) {
                    jbVar.a(entry.getKey());
                    jbVar.a(entry.getValue());
                }
                jbVar.d();
                jbVar.b();
            }
            if (this.f638f != null && i()) {
                jbVar.a(i);
                jbVar.a(this.f638f);
                jbVar.b();
            }
            if (this.f639g != null && j()) {
                jbVar.a(j);
                jbVar.a(this.f639g);
                jbVar.b();
            }
            if (this.f640h != null && k()) {
                jbVar.a(k);
                jbVar.a(this.f640h);
                jbVar.b();
            }
            if (this.f641i != null && l()) {
                jbVar.a(l);
                jbVar.a(this.f641i);
                jbVar.b();
            }
            if (this.f629a != null && m()) {
                jbVar.a(m);
                jbVar.a(this.f629a);
                jbVar.b();
            }
            if (n()) {
                jbVar.a(n);
                jbVar.a(this.f626a);
                jbVar.b();
            }
            if (o()) {
                jbVar.a(o);
                jbVar.a(this.f634b);
                jbVar.b();
            }
            jbVar.c();
            jbVar.m566a();
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            this.f630a.set(1, z);
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m510b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f627a != null : invokeV.booleanValue;
    }

    public ie c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, str)) == null) {
            this.f636d = str;
            return this;
        }
        return (ie) invokeL.objValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.f638f : (String) invokeV.objValue;
    }

    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            this.f630a.set(2, z);
        }
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m511c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.f633b != null : invokeV.booleanValue;
    }

    public ie d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, str)) == null) {
            this.f638f = str;
            return this;
        }
        return (ie) invokeL.objValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.f635c != null : invokeV.booleanValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.f636d != null : invokeV.booleanValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, obj)) == null) {
            if (obj != null && (obj instanceof ie)) {
                return m508a((ie) obj);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.f630a.get(0) : invokeV.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.f637e != null : invokeV.booleanValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.f631a != null : invokeV.booleanValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.f638f != null : invokeV.booleanValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? this.f639g != null : invokeV.booleanValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.f640h != null : invokeV.booleanValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? this.f641i != null : invokeV.booleanValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? this.f629a != null : invokeV.booleanValue;
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? this.f630a.get(1) : invokeV.booleanValue;
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? this.f630a.get(2) : invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            StringBuilder sb = new StringBuilder("XmPushActionNotification(");
            boolean z2 = false;
            if (m507a()) {
                sb.append("debug:");
                String str = this.f628a;
                if (str == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str);
                }
                z = false;
            } else {
                z = true;
            }
            if (m510b()) {
                if (!z) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                }
                sb.append("target:");
                hu huVar = this.f627a;
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
            String str2 = this.f633b;
            if (str2 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str2);
            }
            if (d()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("appId:");
                String str3 = this.f635c;
                if (str3 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str3);
                }
            }
            if (e()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("type:");
                String str4 = this.f636d;
                if (str4 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str4);
                }
            }
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("requireAck:");
            sb.append(this.f632a);
            if (g()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("payload:");
                String str5 = this.f637e;
                if (str5 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str5);
                }
            }
            if (h()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("extra:");
                Map<String, String> map = this.f631a;
                if (map == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(map);
                }
            }
            if (i()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("packageName:");
                String str6 = this.f638f;
                if (str6 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str6);
                }
            }
            if (j()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("category:");
                String str7 = this.f639g;
                if (str7 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str7);
                }
            }
            if (k()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("regId:");
                String str8 = this.f640h;
                if (str8 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str8);
                }
            }
            if (l()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("aliasName:");
                String str9 = this.f641i;
                if (str9 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str9);
                }
            }
            if (m()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("binaryExtra:");
                ByteBuffer byteBuffer = this.f629a;
                if (byteBuffer == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    ir.a(byteBuffer, sb);
                }
            }
            if (n()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("createdTs:");
                sb.append(this.f626a);
            }
            if (o()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("alreadyLogClickInXmq:");
                sb.append(this.f634b);
            }
            sb.append(SmallTailInfo.EMOTION_SUFFIX);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
