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
/* loaded from: classes6.dex */
public class ib implements iq<ib, Object>, Serializable, Cloneable {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final iy f40390a;

    /* renamed from: a  reason: collision with other field name */
    public static final jg f630a;

    /* renamed from: b  reason: collision with root package name */
    public static final iy f40391b;

    /* renamed from: c  reason: collision with root package name */
    public static final iy f40392c;

    /* renamed from: d  reason: collision with root package name */
    public static final iy f40393d;

    /* renamed from: e  reason: collision with root package name */
    public static final iy f40394e;

    /* renamed from: f  reason: collision with root package name */
    public static final iy f40395f;

    /* renamed from: g  reason: collision with root package name */
    public static final iy f40396g;

    /* renamed from: h  reason: collision with root package name */
    public static final iy f40397h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public hf f631a;

    /* renamed from: a  reason: collision with other field name */
    public hs f632a;

    /* renamed from: a  reason: collision with other field name */
    public hu f633a;

    /* renamed from: a  reason: collision with other field name */
    public String f634a;

    /* renamed from: a  reason: collision with other field name */
    public ByteBuffer f635a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f636a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f637a;

    /* renamed from: b  reason: collision with other field name */
    public String f638b;

    /* renamed from: b  reason: collision with other field name */
    public boolean f639b;

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
        f630a = new jg("XmPushActionContainer");
        f40390a = new iy("", (byte) 8, (short) 1);
        f40391b = new iy("", (byte) 2, (short) 2);
        f40392c = new iy("", (byte) 2, (short) 3);
        f40393d = new iy("", (byte) 11, (short) 4);
        f40394e = new iy("", (byte) 11, (short) 5);
        f40395f = new iy("", (byte) 11, (short) 6);
        f40396g = new iy("", StandardMessageCodec.LIST, (short) 7);
        f40397h = new iy("", StandardMessageCodec.LIST, (short) 8);
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
        this.f636a = new BitSet(2);
        this.f637a = true;
        this.f639b = true;
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
                int compareTo = Boolean.valueOf(m454a()).compareTo(Boolean.valueOf(ibVar.m454a()));
                if (compareTo != 0) {
                    return compareTo;
                }
                if (!m454a() || (a9 = ir.a(this.f631a, ibVar.f631a)) == 0) {
                    int compareTo2 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(ibVar.c()));
                    if (compareTo2 != 0) {
                        return compareTo2;
                    }
                    if (!c() || (a8 = ir.a(this.f637a, ibVar.f637a)) == 0) {
                        int compareTo3 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(ibVar.d()));
                        if (compareTo3 != 0) {
                            return compareTo3;
                        }
                        if (!d() || (a7 = ir.a(this.f639b, ibVar.f639b)) == 0) {
                            int compareTo4 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(ibVar.e()));
                            if (compareTo4 != 0) {
                                return compareTo4;
                            }
                            if (!e() || (a6 = ir.a(this.f635a, ibVar.f635a)) == 0) {
                                int compareTo5 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(ibVar.f()));
                                if (compareTo5 != 0) {
                                    return compareTo5;
                                }
                                if (!f() || (a5 = ir.a(this.f634a, ibVar.f634a)) == 0) {
                                    int compareTo6 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ibVar.g()));
                                    if (compareTo6 != 0) {
                                        return compareTo6;
                                    }
                                    if (!g() || (a4 = ir.a(this.f638b, ibVar.f638b)) == 0) {
                                        int compareTo7 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(ibVar.h()));
                                        if (compareTo7 != 0) {
                                            return compareTo7;
                                        }
                                        if (!h() || (a3 = ir.a(this.f633a, ibVar.f633a)) == 0) {
                                            int compareTo8 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(ibVar.i()));
                                            if (compareTo8 != 0) {
                                                return compareTo8;
                                            }
                                            if (!i() || (a2 = ir.a(this.f632a, ibVar.f632a)) == 0) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f631a : (hf) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public hs m450a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f632a : (hs) invokeV.objValue;
    }

    public ib a(hf hfVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, hfVar)) == null) {
            this.f631a = hfVar;
            return this;
        }
        return (ib) invokeL.objValue;
    }

    public ib a(hs hsVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, hsVar)) == null) {
            this.f632a = hsVar;
            return this;
        }
        return (ib) invokeL.objValue;
    }

    public ib a(hu huVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, huVar)) == null) {
            this.f633a = huVar;
            return this;
        }
        return (ib) invokeL.objValue;
    }

    public ib a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            this.f634a = str;
            return this;
        }
        return (ib) invokeL.objValue;
    }

    public ib a(ByteBuffer byteBuffer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, byteBuffer)) == null) {
            this.f635a = byteBuffer;
            return this;
        }
        return (ib) invokeL.objValue;
    }

    public ib a(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z)) == null) {
            this.f637a = z;
            m453a(true);
            return this;
        }
        return (ib) invokeZ.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m451a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f634a : (String) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m452a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (this.f631a == null) {
                throw new jc("Required field 'action' was not present! Struct: " + toString());
            } else if (this.f635a == null) {
                throw new jc("Required field 'pushAction' was not present! Struct: " + toString());
            } else if (this.f633a != null) {
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
        jbVar.m524a();
        while (true) {
            iy m520a = jbVar.m520a();
            byte b2 = m520a.f40508a;
            if (b2 == 0) {
                jbVar.f();
                if (!c()) {
                    throw new jc("Required field 'encryptAction' was not found in serialized data! Struct: " + toString());
                } else if (d()) {
                    m452a();
                    return;
                } else {
                    throw new jc("Required field 'isRequest' was not found in serialized data! Struct: " + toString());
                }
            }
            switch (m520a.f810a) {
                case 1:
                    if (b2 == 8) {
                        this.f631a = hf.a(jbVar.m518a());
                        continue;
                        jbVar.g();
                    }
                    break;
                case 2:
                    if (b2 == 2) {
                        this.f637a = jbVar.m529a();
                        m453a(true);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 3:
                    if (b2 == 2) {
                        this.f639b = jbVar.m529a();
                        m457b(true);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f635a = jbVar.m526a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 5:
                    if (b2 == 11) {
                        this.f634a = jbVar.m525a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 6:
                    if (b2 == 11) {
                        this.f638b = jbVar.m525a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 7:
                    if (b2 == 12) {
                        hu huVar = new hu();
                        this.f633a = huVar;
                        huVar.a(jbVar);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 8:
                    if (b2 == 12) {
                        hs hsVar = new hs();
                        this.f632a = hsVar;
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
    public void m453a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.f636a.set(0, z);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m454a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f631a != null : invokeV.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m455a(ib ibVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, ibVar)) == null) {
            if (ibVar == null) {
                return false;
            }
            boolean m454a = m454a();
            boolean m454a2 = ibVar.m454a();
            if (((!m454a && !m454a2) || (m454a && m454a2 && this.f631a.equals(ibVar.f631a))) && this.f637a == ibVar.f637a && this.f639b == ibVar.f639b) {
                boolean e2 = e();
                boolean e3 = ibVar.e();
                if ((e2 || e3) && !(e2 && e3 && this.f635a.equals(ibVar.f635a))) {
                    return false;
                }
                boolean f2 = f();
                boolean f3 = ibVar.f();
                if ((f2 || f3) && !(f2 && f3 && this.f634a.equals(ibVar.f634a))) {
                    return false;
                }
                boolean g2 = g();
                boolean g3 = ibVar.g();
                if ((g2 || g3) && !(g2 && g3 && this.f638b.equals(ibVar.f638b))) {
                    return false;
                }
                boolean h2 = h();
                boolean h3 = ibVar.h();
                if ((h2 || h3) && !(h2 && h3 && this.f633a.m419a(ibVar.f633a))) {
                    return false;
                }
                boolean i2 = i();
                boolean i3 = ibVar.i();
                if (i2 || i3) {
                    return i2 && i3 && this.f632a.m411a(ibVar.f632a);
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m456a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            a(ir.a(this.f635a));
            return this.f635a.array();
        }
        return (byte[]) invokeV.objValue;
    }

    public ib b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, str)) == null) {
            this.f638b = str;
            return this;
        }
        return (ib) invokeL.objValue;
    }

    public ib b(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048593, this, z)) == null) {
            this.f639b = z;
            m457b(true);
            return this;
        }
        return (ib) invokeZ.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f638b : (String) invokeV.objValue;
    }

    @Override // com.xiaomi.push.iq
    public void b(jb jbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, jbVar) == null) {
            m452a();
            jbVar.a(f630a);
            if (this.f631a != null) {
                jbVar.a(f40390a);
                jbVar.a(this.f631a.a());
                jbVar.b();
            }
            jbVar.a(f40391b);
            jbVar.a(this.f637a);
            jbVar.b();
            jbVar.a(f40392c);
            jbVar.a(this.f639b);
            jbVar.b();
            if (this.f635a != null) {
                jbVar.a(f40393d);
                jbVar.a(this.f635a);
                jbVar.b();
            }
            if (this.f634a != null && f()) {
                jbVar.a(f40394e);
                jbVar.a(this.f634a);
                jbVar.b();
            }
            if (this.f638b != null && g()) {
                jbVar.a(f40395f);
                jbVar.a(this.f638b);
                jbVar.b();
            }
            if (this.f633a != null) {
                jbVar.a(f40396g);
                this.f633a.b(jbVar);
                jbVar.b();
            }
            if (this.f632a != null && i()) {
                jbVar.a(f40397h);
                this.f632a.b(jbVar);
                jbVar.b();
            }
            jbVar.c();
            jbVar.m528a();
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m457b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            this.f636a.set(1, z);
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m458b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.f637a : invokeV.booleanValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.f636a.get(0) : invokeV.booleanValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.f636a.get(1) : invokeV.booleanValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.f635a != null : invokeV.booleanValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, obj)) == null) {
            if (obj != null && (obj instanceof ib)) {
                return m455a((ib) obj);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.f634a != null : invokeV.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.f638b != null : invokeV.booleanValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.f633a != null : invokeV.booleanValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.f632a != null : invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            StringBuilder sb = new StringBuilder("XmPushActionContainer(");
            sb.append("action:");
            hf hfVar = this.f631a;
            if (hfVar == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(hfVar);
            }
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("encryptAction:");
            sb.append(this.f637a);
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("isRequest:");
            sb.append(this.f639b);
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("pushAction:");
            ByteBuffer byteBuffer = this.f635a;
            if (byteBuffer == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                ir.a(byteBuffer, sb);
            }
            if (f()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("appid:");
                String str = this.f634a;
                if (str == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str);
                }
            }
            if (g()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("packageName:");
                String str2 = this.f638b;
                if (str2 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str2);
                }
            }
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("target:");
            hu huVar = this.f633a;
            if (huVar == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(huVar);
            }
            if (i()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("metaInfo:");
                hs hsVar = this.f632a;
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
