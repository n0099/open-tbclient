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
    public static final jk f625a;
    public static final jc b;
    public static final jc c;
    public static final jc d;
    public static final jc e;
    public static final jc f;
    public static final jc g;
    public static final jc h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public hj f626a;

    /* renamed from: a  reason: collision with other field name */
    public hw f627a;

    /* renamed from: a  reason: collision with other field name */
    public hy f628a;

    /* renamed from: a  reason: collision with other field name */
    public String f629a;

    /* renamed from: a  reason: collision with other field name */
    public ByteBuffer f630a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f631a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f632a;

    /* renamed from: b  reason: collision with other field name */
    public String f633b;

    /* renamed from: b  reason: collision with other field name */
    public boolean f634b;

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
        f625a = new jk("XmPushActionContainer");
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
        this.f631a = new BitSet(2);
        this.f632a = true;
        this.f634b = true;
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
                int compareTo = Boolean.valueOf(m470a()).compareTo(Boolean.valueOf(cif.m470a()));
                if (compareTo != 0) {
                    return compareTo;
                }
                if (!m470a() || (a9 = iv.a(this.f626a, cif.f626a)) == 0) {
                    int compareTo2 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(cif.c()));
                    if (compareTo2 != 0) {
                        return compareTo2;
                    }
                    if (!c() || (a8 = iv.a(this.f632a, cif.f632a)) == 0) {
                        int compareTo3 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(cif.d()));
                        if (compareTo3 != 0) {
                            return compareTo3;
                        }
                        if (!d() || (a7 = iv.a(this.f634b, cif.f634b)) == 0) {
                            int compareTo4 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(cif.e()));
                            if (compareTo4 != 0) {
                                return compareTo4;
                            }
                            if (!e() || (a6 = iv.a(this.f630a, cif.f630a)) == 0) {
                                int compareTo5 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(cif.f()));
                                if (compareTo5 != 0) {
                                    return compareTo5;
                                }
                                if (!f() || (a5 = iv.a(this.f629a, cif.f629a)) == 0) {
                                    int compareTo6 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(cif.g()));
                                    if (compareTo6 != 0) {
                                        return compareTo6;
                                    }
                                    if (!g() || (a4 = iv.a(this.f633b, cif.f633b)) == 0) {
                                        int compareTo7 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(cif.h()));
                                        if (compareTo7 != 0) {
                                            return compareTo7;
                                        }
                                        if (!h() || (a3 = iv.a(this.f628a, cif.f628a)) == 0) {
                                            int compareTo8 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(cif.i()));
                                            if (compareTo8 != 0) {
                                                return compareTo8;
                                            }
                                            if (!i() || (a2 = iv.a(this.f627a, cif.f627a)) == 0) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f626a : (hj) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public hw m466a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f627a : (hw) invokeV.objValue;
    }

    public Cif a(hj hjVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, hjVar)) == null) {
            this.f626a = hjVar;
            return this;
        }
        return (Cif) invokeL.objValue;
    }

    public Cif a(hw hwVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, hwVar)) == null) {
            this.f627a = hwVar;
            return this;
        }
        return (Cif) invokeL.objValue;
    }

    public Cif a(hy hyVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, hyVar)) == null) {
            this.f628a = hyVar;
            return this;
        }
        return (Cif) invokeL.objValue;
    }

    public Cif a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            this.f629a = str;
            return this;
        }
        return (Cif) invokeL.objValue;
    }

    public Cif a(ByteBuffer byteBuffer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, byteBuffer)) == null) {
            this.f630a = byteBuffer;
            return this;
        }
        return (Cif) invokeL.objValue;
    }

    public Cif a(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z)) == null) {
            this.f632a = z;
            m469a(true);
            return this;
        }
        return (Cif) invokeZ.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m467a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f629a : (String) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m468a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (this.f626a == null) {
                throw new jg("Required field 'action' was not present! Struct: " + toString());
            } else if (this.f630a == null) {
                throw new jg("Required field 'pushAction' was not present! Struct: " + toString());
            } else if (this.f628a != null) {
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
        jfVar.m550a();
        while (true) {
            jc m546a = jfVar.m546a();
            byte b2 = m546a.a;
            if (b2 == 0) {
                jfVar.f();
                if (!c()) {
                    throw new jg("Required field 'encryptAction' was not found in serialized data! Struct: " + toString());
                } else if (d()) {
                    m468a();
                    return;
                } else {
                    throw new jg("Required field 'isRequest' was not found in serialized data! Struct: " + toString());
                }
            }
            switch (m546a.f810a) {
                case 1:
                    if (b2 == 8) {
                        this.f626a = hj.a(jfVar.m544a());
                        continue;
                        jfVar.g();
                    }
                    break;
                case 2:
                    if (b2 == 2) {
                        this.f632a = jfVar.m555a();
                        m469a(true);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 3:
                    if (b2 == 2) {
                        this.f634b = jfVar.m555a();
                        m473b(true);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f630a = jfVar.m552a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 5:
                    if (b2 == 11) {
                        this.f629a = jfVar.m551a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 6:
                    if (b2 == 11) {
                        this.f633b = jfVar.m551a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 7:
                    if (b2 == 12) {
                        hy hyVar = new hy();
                        this.f628a = hyVar;
                        hyVar.a(jfVar);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 8:
                    if (b2 == 12) {
                        hw hwVar = new hw();
                        this.f627a = hwVar;
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
    public void m469a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.f631a.set(0, z);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m470a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f626a != null : invokeV.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m471a(Cif cif) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, cif)) == null) {
            if (cif == null) {
                return false;
            }
            boolean m470a = m470a();
            boolean m470a2 = cif.m470a();
            if (((!m470a && !m470a2) || (m470a && m470a2 && this.f626a.equals(cif.f626a))) && this.f632a == cif.f632a && this.f634b == cif.f634b) {
                boolean e2 = e();
                boolean e3 = cif.e();
                if ((e2 || e3) && !(e2 && e3 && this.f630a.equals(cif.f630a))) {
                    return false;
                }
                boolean f2 = f();
                boolean f3 = cif.f();
                if ((f2 || f3) && !(f2 && f3 && this.f629a.equals(cif.f629a))) {
                    return false;
                }
                boolean g2 = g();
                boolean g3 = cif.g();
                if ((g2 || g3) && !(g2 && g3 && this.f633b.equals(cif.f633b))) {
                    return false;
                }
                boolean h2 = h();
                boolean h3 = cif.h();
                if ((h2 || h3) && !(h2 && h3 && this.f628a.m444a(cif.f628a))) {
                    return false;
                }
                boolean i = i();
                boolean i2 = cif.i();
                if (i || i2) {
                    return i && i2 && this.f627a.m436a(cif.f627a);
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m472a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            a(iv.a(this.f630a));
            return this.f630a.array();
        }
        return (byte[]) invokeV.objValue;
    }

    public Cif b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, str)) == null) {
            this.f633b = str;
            return this;
        }
        return (Cif) invokeL.objValue;
    }

    public Cif b(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048593, this, z)) == null) {
            this.f634b = z;
            m473b(true);
            return this;
        }
        return (Cif) invokeZ.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f633b : (String) invokeV.objValue;
    }

    @Override // com.xiaomi.push.iu
    public void b(jf jfVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, jfVar) == null) {
            m468a();
            jfVar.a(f625a);
            if (this.f626a != null) {
                jfVar.a(a);
                jfVar.a(this.f626a.a());
                jfVar.b();
            }
            jfVar.a(b);
            jfVar.a(this.f632a);
            jfVar.b();
            jfVar.a(c);
            jfVar.a(this.f634b);
            jfVar.b();
            if (this.f630a != null) {
                jfVar.a(d);
                jfVar.a(this.f630a);
                jfVar.b();
            }
            if (this.f629a != null && f()) {
                jfVar.a(e);
                jfVar.a(this.f629a);
                jfVar.b();
            }
            if (this.f633b != null && g()) {
                jfVar.a(f);
                jfVar.a(this.f633b);
                jfVar.b();
            }
            if (this.f628a != null) {
                jfVar.a(g);
                this.f628a.b(jfVar);
                jfVar.b();
            }
            if (this.f627a != null && i()) {
                jfVar.a(h);
                this.f627a.b(jfVar);
                jfVar.b();
            }
            jfVar.c();
            jfVar.m554a();
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m473b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            this.f631a.set(1, z);
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m474b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.f632a : invokeV.booleanValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.f631a.get(0) : invokeV.booleanValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.f631a.get(1) : invokeV.booleanValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.f630a != null : invokeV.booleanValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, obj)) == null) {
            if (obj != null && (obj instanceof Cif)) {
                return m471a((Cif) obj);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.f629a != null : invokeV.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.f633b != null : invokeV.booleanValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.f628a != null : invokeV.booleanValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.f627a != null : invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            StringBuilder sb = new StringBuilder("XmPushActionContainer(");
            sb.append("action:");
            hj hjVar = this.f626a;
            if (hjVar == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(hjVar);
            }
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("encryptAction:");
            sb.append(this.f632a);
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("isRequest:");
            sb.append(this.f634b);
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("pushAction:");
            ByteBuffer byteBuffer = this.f630a;
            if (byteBuffer == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                iv.a(byteBuffer, sb);
            }
            if (f()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("appid:");
                String str = this.f629a;
                if (str == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str);
                }
            }
            if (g()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("packageName:");
                String str2 = this.f633b;
                if (str2 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str2);
                }
            }
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("target:");
            hy hyVar = this.f628a;
            if (hyVar == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(hyVar);
            }
            if (i()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("metaInfo:");
                hw hwVar = this.f627a;
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
