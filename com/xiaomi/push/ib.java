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
/* loaded from: classes10.dex */
public class ib implements iq<ib, Object>, Serializable, Cloneable {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final iy f78267a;

    /* renamed from: a  reason: collision with other field name */
    public static final jg f634a;

    /* renamed from: b  reason: collision with root package name */
    public static final iy f78268b;

    /* renamed from: c  reason: collision with root package name */
    public static final iy f78269c;

    /* renamed from: d  reason: collision with root package name */
    public static final iy f78270d;

    /* renamed from: e  reason: collision with root package name */
    public static final iy f78271e;

    /* renamed from: f  reason: collision with root package name */
    public static final iy f78272f;

    /* renamed from: g  reason: collision with root package name */
    public static final iy f78273g;

    /* renamed from: h  reason: collision with root package name */
    public static final iy f78274h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public hf f635a;

    /* renamed from: a  reason: collision with other field name */
    public hs f636a;

    /* renamed from: a  reason: collision with other field name */
    public hu f637a;

    /* renamed from: a  reason: collision with other field name */
    public String f638a;

    /* renamed from: a  reason: collision with other field name */
    public ByteBuffer f639a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f640a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f641a;

    /* renamed from: b  reason: collision with other field name */
    public String f642b;

    /* renamed from: b  reason: collision with other field name */
    public boolean f643b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-56372153, "Lcom/xiaomi/push/ib;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-56372153, "Lcom/xiaomi/push/ib;");
                return;
            }
        }
        f634a = new jg("XmPushActionContainer");
        f78267a = new iy("", (byte) 8, (short) 1);
        f78268b = new iy("", (byte) 2, (short) 2);
        f78269c = new iy("", (byte) 2, (short) 3);
        f78270d = new iy("", (byte) 11, (short) 4);
        f78271e = new iy("", (byte) 11, (short) 5);
        f78272f = new iy("", (byte) 11, (short) 6);
        f78273g = new iy("", StandardMessageCodec.LIST, (short) 7);
        f78274h = new iy("", StandardMessageCodec.LIST, (short) 8);
    }

    public ib() {
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
        this.f640a = new BitSet(2);
        this.f641a = true;
        this.f643b = true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(ib ibVar) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, ibVar)) == null) {
            if (ib.class.equals(ibVar.getClass())) {
                int compareTo = Boolean.valueOf(m457a()).compareTo(Boolean.valueOf(ibVar.m457a()));
                if (compareTo != 0) {
                    return compareTo;
                }
                if (!m457a() || (a9 = ir.a(this.f635a, ibVar.f635a)) == 0) {
                    int compareTo2 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(ibVar.c()));
                    if (compareTo2 != 0) {
                        return compareTo2;
                    }
                    if (!c() || (a8 = ir.a(this.f641a, ibVar.f641a)) == 0) {
                        int compareTo3 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(ibVar.d()));
                        if (compareTo3 != 0) {
                            return compareTo3;
                        }
                        if (!d() || (a7 = ir.a(this.f643b, ibVar.f643b)) == 0) {
                            int compareTo4 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(ibVar.e()));
                            if (compareTo4 != 0) {
                                return compareTo4;
                            }
                            if (!e() || (a6 = ir.a(this.f639a, ibVar.f639a)) == 0) {
                                int compareTo5 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(ibVar.f()));
                                if (compareTo5 != 0) {
                                    return compareTo5;
                                }
                                if (!f() || (a5 = ir.a(this.f638a, ibVar.f638a)) == 0) {
                                    int compareTo6 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ibVar.g()));
                                    if (compareTo6 != 0) {
                                        return compareTo6;
                                    }
                                    if (!g() || (a4 = ir.a(this.f642b, ibVar.f642b)) == 0) {
                                        int compareTo7 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(ibVar.h()));
                                        if (compareTo7 != 0) {
                                            return compareTo7;
                                        }
                                        if (!h() || (a3 = ir.a(this.f637a, ibVar.f637a)) == 0) {
                                            int compareTo8 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(ibVar.i()));
                                            if (compareTo8 != 0) {
                                                return compareTo8;
                                            }
                                            if (!i() || (a2 = ir.a(this.f636a, ibVar.f636a)) == 0) {
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
            return ib.class.getName().compareTo(ibVar.getClass().getName());
        }
        return invokeL.intValue;
    }

    public hf a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f635a : (hf) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public hs m453a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f636a : (hs) invokeV.objValue;
    }

    public ib a(hf hfVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, hfVar)) == null) {
            this.f635a = hfVar;
            return this;
        }
        return (ib) invokeL.objValue;
    }

    public ib a(hs hsVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, hsVar)) == null) {
            this.f636a = hsVar;
            return this;
        }
        return (ib) invokeL.objValue;
    }

    public ib a(hu huVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, huVar)) == null) {
            this.f637a = huVar;
            return this;
        }
        return (ib) invokeL.objValue;
    }

    public ib a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            this.f638a = str;
            return this;
        }
        return (ib) invokeL.objValue;
    }

    public ib a(ByteBuffer byteBuffer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, byteBuffer)) == null) {
            this.f639a = byteBuffer;
            return this;
        }
        return (ib) invokeL.objValue;
    }

    public ib a(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z)) == null) {
            this.f641a = z;
            m456a(true);
            return this;
        }
        return (ib) invokeZ.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m454a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f638a : (String) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m455a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (this.f635a == null) {
                throw new jc("Required field 'action' was not present! Struct: " + toString());
            } else if (this.f639a == null) {
                throw new jc("Required field 'pushAction' was not present! Struct: " + toString());
            } else if (this.f637a != null) {
            } else {
                throw new jc("Required field 'target' was not present! Struct: " + toString());
            }
        }
    }

    @Override // com.xiaomi.push.iq
    public void a(jb jbVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(1048587, this, jbVar) != null) {
            return;
        }
        jbVar.m527a();
        while (true) {
            iy m523a = jbVar.m523a();
            byte b2 = m523a.f78390a;
            if (b2 == 0) {
                jbVar.f();
                if (!c()) {
                    throw new jc("Required field 'encryptAction' was not found in serialized data! Struct: " + toString());
                } else if (d()) {
                    m455a();
                    return;
                } else {
                    throw new jc("Required field 'isRequest' was not found in serialized data! Struct: " + toString());
                }
            }
            switch (m523a.f814a) {
                case 1:
                    if (b2 == 8) {
                        this.f635a = hf.a(jbVar.m521a());
                        continue;
                        jbVar.g();
                    }
                    break;
                case 2:
                    if (b2 == 2) {
                        this.f641a = jbVar.m532a();
                        m456a(true);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 3:
                    if (b2 == 2) {
                        this.f643b = jbVar.m532a();
                        m460b(true);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f639a = jbVar.m529a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 5:
                    if (b2 == 11) {
                        this.f638a = jbVar.m528a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 6:
                    if (b2 == 11) {
                        this.f642b = jbVar.m528a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 7:
                    if (b2 == 12) {
                        hu huVar = new hu();
                        this.f637a = huVar;
                        huVar.a(jbVar);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 8:
                    if (b2 == 12) {
                        hs hsVar = new hs();
                        this.f636a = hsVar;
                        hsVar.a(jbVar);
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
    public void m456a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.f640a.set(0, z);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m457a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f635a != null : invokeV.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m458a(ib ibVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, ibVar)) == null) {
            if (ibVar == null) {
                return false;
            }
            boolean m457a = m457a();
            boolean m457a2 = ibVar.m457a();
            if (((!m457a && !m457a2) || (m457a && m457a2 && this.f635a.equals(ibVar.f635a))) && this.f641a == ibVar.f641a && this.f643b == ibVar.f643b) {
                boolean e2 = e();
                boolean e3 = ibVar.e();
                if ((e2 || e3) && !(e2 && e3 && this.f639a.equals(ibVar.f639a))) {
                    return false;
                }
                boolean f2 = f();
                boolean f3 = ibVar.f();
                if ((f2 || f3) && !(f2 && f3 && this.f638a.equals(ibVar.f638a))) {
                    return false;
                }
                boolean g2 = g();
                boolean g3 = ibVar.g();
                if ((g2 || g3) && !(g2 && g3 && this.f642b.equals(ibVar.f642b))) {
                    return false;
                }
                boolean h2 = h();
                boolean h3 = ibVar.h();
                if ((h2 || h3) && !(h2 && h3 && this.f637a.m422a(ibVar.f637a))) {
                    return false;
                }
                boolean i2 = i();
                boolean i3 = ibVar.i();
                if (i2 || i3) {
                    return i2 && i3 && this.f636a.m414a(ibVar.f636a);
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m459a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            a(ir.a(this.f639a));
            return this.f639a.array();
        }
        return (byte[]) invokeV.objValue;
    }

    public ib b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, str)) == null) {
            this.f642b = str;
            return this;
        }
        return (ib) invokeL.objValue;
    }

    public ib b(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048593, this, z)) == null) {
            this.f643b = z;
            m460b(true);
            return this;
        }
        return (ib) invokeZ.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f642b : (String) invokeV.objValue;
    }

    @Override // com.xiaomi.push.iq
    public void b(jb jbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, jbVar) == null) {
            m455a();
            jbVar.a(f634a);
            if (this.f635a != null) {
                jbVar.a(f78267a);
                jbVar.a(this.f635a.a());
                jbVar.b();
            }
            jbVar.a(f78268b);
            jbVar.a(this.f641a);
            jbVar.b();
            jbVar.a(f78269c);
            jbVar.a(this.f643b);
            jbVar.b();
            if (this.f639a != null) {
                jbVar.a(f78270d);
                jbVar.a(this.f639a);
                jbVar.b();
            }
            if (this.f638a != null && f()) {
                jbVar.a(f78271e);
                jbVar.a(this.f638a);
                jbVar.b();
            }
            if (this.f642b != null && g()) {
                jbVar.a(f78272f);
                jbVar.a(this.f642b);
                jbVar.b();
            }
            if (this.f637a != null) {
                jbVar.a(f78273g);
                this.f637a.b(jbVar);
                jbVar.b();
            }
            if (this.f636a != null && i()) {
                jbVar.a(f78274h);
                this.f636a.b(jbVar);
                jbVar.b();
            }
            jbVar.c();
            jbVar.m531a();
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m460b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            this.f640a.set(1, z);
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m461b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.f641a : invokeV.booleanValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.f640a.get(0) : invokeV.booleanValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.f640a.get(1) : invokeV.booleanValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.f639a != null : invokeV.booleanValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, obj)) == null) {
            if (obj != null && (obj instanceof ib)) {
                return m458a((ib) obj);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.f638a != null : invokeV.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.f642b != null : invokeV.booleanValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.f637a != null : invokeV.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.f636a != null : invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            StringBuilder sb = new StringBuilder("XmPushActionContainer(");
            sb.append("action:");
            hf hfVar = this.f635a;
            if (hfVar == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(hfVar);
            }
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("encryptAction:");
            sb.append(this.f641a);
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("isRequest:");
            sb.append(this.f643b);
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("pushAction:");
            ByteBuffer byteBuffer = this.f639a;
            if (byteBuffer == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                ir.a(byteBuffer, sb);
            }
            if (f()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("appid:");
                String str = this.f638a;
                if (str == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str);
                }
            }
            if (g()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("packageName:");
                String str2 = this.f642b;
                if (str2 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str2);
                }
            }
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("target:");
            hu huVar = this.f637a;
            if (huVar == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(huVar);
            }
            if (i()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("metaInfo:");
                hs hsVar = this.f636a;
                if (hsVar == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(hsVar);
                }
            }
            sb.append(SmallTailInfo.EMOTION_SUFFIX);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
