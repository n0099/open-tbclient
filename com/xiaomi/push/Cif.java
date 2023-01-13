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
/* renamed from: com.xiaomi.push.if  reason: invalid class name */
/* loaded from: classes8.dex */
public class Cif implements iu<Cif, Object>, Serializable, Cloneable {
    public static /* synthetic */ Interceptable $ic;
    public static final jc a;

    /* renamed from: a  reason: collision with other field name */
    public static final jk f648a;
    public static final jc b;
    public static final jc c;
    public static final jc d;
    public static final jc e;
    public static final jc f;
    public static final jc g;
    public static final jc h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public hj f649a;

    /* renamed from: a  reason: collision with other field name */
    public hw f650a;

    /* renamed from: a  reason: collision with other field name */
    public hy f651a;

    /* renamed from: a  reason: collision with other field name */
    public String f652a;

    /* renamed from: a  reason: collision with other field name */
    public ByteBuffer f653a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f654a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f655a;

    /* renamed from: b  reason: collision with other field name */
    public String f656b;

    /* renamed from: b  reason: collision with other field name */
    public boolean f657b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-56372029, "Lcom/xiaomi/push/if;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-56372029, "Lcom/xiaomi/push/if;");
                return;
            }
        }
        f648a = new jk("XmPushActionContainer");
        a = new jc("", (byte) 8, (short) 1);
        b = new jc("", (byte) 2, (short) 2);
        c = new jc("", (byte) 2, (short) 3);
        d = new jc("", Constants.GZIP_CAST_TYPE, (short) 4);
        e = new jc("", Constants.GZIP_CAST_TYPE, (short) 5);
        f = new jc("", Constants.GZIP_CAST_TYPE, (short) 6);
        g = new jc("", (byte) 12, (short) 7);
        h = new jc("", (byte) 12, (short) 8);
    }

    public Cif() {
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
        this.f654a = new BitSet(2);
        this.f655a = true;
        this.f657b = true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(Cif cif) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cif)) == null) {
            if (Cif.class.equals(cif.getClass())) {
                int compareTo = Boolean.valueOf(m542a()).compareTo(Boolean.valueOf(cif.m542a()));
                if (compareTo != 0) {
                    return compareTo;
                }
                if (!m542a() || (a9 = iv.a(this.f649a, cif.f649a)) == 0) {
                    int compareTo2 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(cif.c()));
                    if (compareTo2 != 0) {
                        return compareTo2;
                    }
                    if (!c() || (a8 = iv.a(this.f655a, cif.f655a)) == 0) {
                        int compareTo3 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(cif.d()));
                        if (compareTo3 != 0) {
                            return compareTo3;
                        }
                        if (!d() || (a7 = iv.a(this.f657b, cif.f657b)) == 0) {
                            int compareTo4 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(cif.e()));
                            if (compareTo4 != 0) {
                                return compareTo4;
                            }
                            if (!e() || (a6 = iv.a(this.f653a, cif.f653a)) == 0) {
                                int compareTo5 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(cif.f()));
                                if (compareTo5 != 0) {
                                    return compareTo5;
                                }
                                if (!f() || (a5 = iv.a(this.f652a, cif.f652a)) == 0) {
                                    int compareTo6 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(cif.g()));
                                    if (compareTo6 != 0) {
                                        return compareTo6;
                                    }
                                    if (!g() || (a4 = iv.a(this.f656b, cif.f656b)) == 0) {
                                        int compareTo7 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(cif.h()));
                                        if (compareTo7 != 0) {
                                            return compareTo7;
                                        }
                                        if (!h() || (a3 = iv.a(this.f651a, cif.f651a)) == 0) {
                                            int compareTo8 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(cif.i()));
                                            if (compareTo8 != 0) {
                                                return compareTo8;
                                            }
                                            if (!i() || (a2 = iv.a(this.f650a, cif.f650a)) == 0) {
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
            return Cif.class.getName().compareTo(cif.getClass().getName());
        }
        return invokeL.intValue;
    }

    public hj a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f649a : (hj) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public hw m538a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f650a : (hw) invokeV.objValue;
    }

    public Cif a(hj hjVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, hjVar)) == null) {
            this.f649a = hjVar;
            return this;
        }
        return (Cif) invokeL.objValue;
    }

    public Cif a(hw hwVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, hwVar)) == null) {
            this.f650a = hwVar;
            return this;
        }
        return (Cif) invokeL.objValue;
    }

    public Cif a(hy hyVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, hyVar)) == null) {
            this.f651a = hyVar;
            return this;
        }
        return (Cif) invokeL.objValue;
    }

    public Cif a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            this.f652a = str;
            return this;
        }
        return (Cif) invokeL.objValue;
    }

    public Cif a(ByteBuffer byteBuffer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, byteBuffer)) == null) {
            this.f653a = byteBuffer;
            return this;
        }
        return (Cif) invokeL.objValue;
    }

    public Cif a(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z)) == null) {
            this.f655a = z;
            m541a(true);
            return this;
        }
        return (Cif) invokeZ.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m539a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f652a : (String) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m540a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (this.f649a == null) {
                throw new jg("Required field 'action' was not present! Struct: " + toString());
            } else if (this.f653a == null) {
                throw new jg("Required field 'pushAction' was not present! Struct: " + toString());
            } else if (this.f651a != null) {
            } else {
                throw new jg("Required field 'target' was not present! Struct: " + toString());
            }
        }
    }

    @Override // com.xiaomi.push.iu
    public void a(jf jfVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(1048587, this, jfVar) != null) {
            return;
        }
        jfVar.mo622a();
        while (true) {
            jc mo618a = jfVar.mo618a();
            byte b2 = mo618a.a;
            if (b2 == 0) {
                jfVar.f();
                if (!c()) {
                    throw new jg("Required field 'encryptAction' was not found in serialized data! Struct: " + toString());
                } else if (d()) {
                    m540a();
                    return;
                } else {
                    throw new jg("Required field 'isRequest' was not found in serialized data! Struct: " + toString());
                }
            }
            switch (mo618a.f833a) {
                case 1:
                    if (b2 == 8) {
                        this.f649a = hj.a(jfVar.mo616a());
                        continue;
                        jfVar.g();
                    }
                    break;
                case 2:
                    if (b2 == 2) {
                        this.f655a = jfVar.mo628a();
                        m541a(true);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 3:
                    if (b2 == 2) {
                        this.f657b = jfVar.mo628a();
                        m545b(true);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f653a = jfVar.mo624a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 5:
                    if (b2 == 11) {
                        this.f652a = jfVar.mo623a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 6:
                    if (b2 == 11) {
                        this.f656b = jfVar.mo623a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 7:
                    if (b2 == 12) {
                        hy hyVar = new hy();
                        this.f651a = hyVar;
                        hyVar.a(jfVar);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 8:
                    if (b2 == 12) {
                        hw hwVar = new hw();
                        this.f650a = hwVar;
                        hwVar.a(jfVar);
                        continue;
                        jfVar.g();
                    }
                    break;
            }
            ji.a(jfVar, b2);
            jfVar.g();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m541a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.f654a.set(0, z);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m542a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f649a != null : invokeV.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m543a(Cif cif) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, cif)) == null) {
            if (cif == null) {
                return false;
            }
            boolean m542a = m542a();
            boolean m542a2 = cif.m542a();
            if (((!m542a && !m542a2) || (m542a && m542a2 && this.f649a.equals(cif.f649a))) && this.f655a == cif.f655a && this.f657b == cif.f657b) {
                boolean e2 = e();
                boolean e3 = cif.e();
                if ((e2 || e3) && !(e2 && e3 && this.f653a.equals(cif.f653a))) {
                    return false;
                }
                boolean f2 = f();
                boolean f3 = cif.f();
                if ((f2 || f3) && !(f2 && f3 && this.f652a.equals(cif.f652a))) {
                    return false;
                }
                boolean g2 = g();
                boolean g3 = cif.g();
                if ((g2 || g3) && !(g2 && g3 && this.f656b.equals(cif.f656b))) {
                    return false;
                }
                boolean h2 = h();
                boolean h3 = cif.h();
                if ((h2 || h3) && !(h2 && h3 && this.f651a.m516a(cif.f651a))) {
                    return false;
                }
                boolean i = i();
                boolean i2 = cif.i();
                if (i || i2) {
                    return i && i2 && this.f650a.m508a(cif.f650a);
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m544a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            a(iv.a(this.f653a));
            return this.f653a.array();
        }
        return (byte[]) invokeV.objValue;
    }

    public Cif b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, str)) == null) {
            this.f656b = str;
            return this;
        }
        return (Cif) invokeL.objValue;
    }

    public Cif b(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048593, this, z)) == null) {
            this.f657b = z;
            m545b(true);
            return this;
        }
        return (Cif) invokeZ.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f656b : (String) invokeV.objValue;
    }

    @Override // com.xiaomi.push.iu
    public void b(jf jfVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, jfVar) == null) {
            m540a();
            jfVar.a(f648a);
            if (this.f649a != null) {
                jfVar.a(a);
                jfVar.mo627a(this.f649a.a());
                jfVar.b();
            }
            jfVar.a(b);
            jfVar.a(this.f655a);
            jfVar.b();
            jfVar.a(c);
            jfVar.a(this.f657b);
            jfVar.b();
            if (this.f653a != null) {
                jfVar.a(d);
                jfVar.a(this.f653a);
                jfVar.b();
            }
            if (this.f652a != null && f()) {
                jfVar.a(e);
                jfVar.a(this.f652a);
                jfVar.b();
            }
            if (this.f656b != null && g()) {
                jfVar.a(f);
                jfVar.a(this.f656b);
                jfVar.b();
            }
            if (this.f651a != null) {
                jfVar.a(g);
                this.f651a.b(jfVar);
                jfVar.b();
            }
            if (this.f650a != null && i()) {
                jfVar.a(h);
                this.f650a.b(jfVar);
                jfVar.b();
            }
            jfVar.c();
            jfVar.mo626a();
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m545b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            this.f654a.set(1, z);
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m546b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.f655a : invokeV.booleanValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.f654a.get(0) : invokeV.booleanValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.f654a.get(1) : invokeV.booleanValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.f653a != null : invokeV.booleanValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, obj)) == null) {
            if (obj != null && (obj instanceof Cif)) {
                return m543a((Cif) obj);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.f652a != null : invokeV.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.f656b != null : invokeV.booleanValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.f651a != null : invokeV.booleanValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.f650a != null : invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            StringBuilder sb = new StringBuilder("XmPushActionContainer(");
            sb.append("action:");
            hj hjVar = this.f649a;
            if (hjVar == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(hjVar);
            }
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("encryptAction:");
            sb.append(this.f655a);
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("isRequest:");
            sb.append(this.f657b);
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("pushAction:");
            ByteBuffer byteBuffer = this.f653a;
            if (byteBuffer == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                iv.a(byteBuffer, sb);
            }
            if (f()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("appid:");
                String str = this.f652a;
                if (str == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str);
                }
            }
            if (g()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("packageName:");
                String str2 = this.f656b;
                if (str2 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str2);
                }
            }
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("target:");
            hy hyVar = this.f651a;
            if (hyVar == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(hyVar);
            }
            if (i()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("metaInfo:");
                hw hwVar = this.f650a;
                if (hwVar == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(hwVar);
                }
            }
            sb.append(SmallTailInfo.EMOTION_SUFFIX);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
