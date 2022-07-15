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
    public static final jk f1344a;
    public static final jc b;
    public static final jc c;
    public static final jc d;
    public static final jc e;
    public static final jc f;
    public static final jc g;
    public static final jc h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public hj f1345a;

    /* renamed from: a  reason: collision with other field name */
    public hw f1346a;

    /* renamed from: a  reason: collision with other field name */
    public hy f1347a;

    /* renamed from: a  reason: collision with other field name */
    public String f1348a;

    /* renamed from: a  reason: collision with other field name */
    public ByteBuffer f1349a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f1350a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f1351a;

    /* renamed from: b  reason: collision with other field name */
    public String f1352b;

    /* renamed from: b  reason: collision with other field name */
    public boolean f1353b;

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
        f1344a = new jk("XmPushActionContainer");
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
        this.f1350a = new BitSet(2);
        this.f1351a = true;
        this.f1353b = true;
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
                int compareTo = Boolean.valueOf(m1407a()).compareTo(Boolean.valueOf(cif.m1407a()));
                if (compareTo != 0) {
                    return compareTo;
                }
                if (!m1407a() || (a9 = iv.a(this.f1345a, cif.f1345a)) == 0) {
                    int compareTo2 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(cif.c()));
                    if (compareTo2 != 0) {
                        return compareTo2;
                    }
                    if (!c() || (a8 = iv.a(this.f1351a, cif.f1351a)) == 0) {
                        int compareTo3 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(cif.d()));
                        if (compareTo3 != 0) {
                            return compareTo3;
                        }
                        if (!d() || (a7 = iv.a(this.f1353b, cif.f1353b)) == 0) {
                            int compareTo4 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(cif.e()));
                            if (compareTo4 != 0) {
                                return compareTo4;
                            }
                            if (!e() || (a6 = iv.a(this.f1349a, cif.f1349a)) == 0) {
                                int compareTo5 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(cif.f()));
                                if (compareTo5 != 0) {
                                    return compareTo5;
                                }
                                if (!f() || (a5 = iv.a(this.f1348a, cif.f1348a)) == 0) {
                                    int compareTo6 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(cif.g()));
                                    if (compareTo6 != 0) {
                                        return compareTo6;
                                    }
                                    if (!g() || (a4 = iv.a(this.f1352b, cif.f1352b)) == 0) {
                                        int compareTo7 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(cif.h()));
                                        if (compareTo7 != 0) {
                                            return compareTo7;
                                        }
                                        if (!h() || (a3 = iv.a(this.f1347a, cif.f1347a)) == 0) {
                                            int compareTo8 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(cif.i()));
                                            if (compareTo8 != 0) {
                                                return compareTo8;
                                            }
                                            if (!i() || (a2 = iv.a(this.f1346a, cif.f1346a)) == 0) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f1345a : (hj) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public hw m1403a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f1346a : (hw) invokeV.objValue;
    }

    public Cif a(hj hjVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, hjVar)) == null) {
            this.f1345a = hjVar;
            return this;
        }
        return (Cif) invokeL.objValue;
    }

    public Cif a(hw hwVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, hwVar)) == null) {
            this.f1346a = hwVar;
            return this;
        }
        return (Cif) invokeL.objValue;
    }

    public Cif a(hy hyVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, hyVar)) == null) {
            this.f1347a = hyVar;
            return this;
        }
        return (Cif) invokeL.objValue;
    }

    public Cif a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            this.f1348a = str;
            return this;
        }
        return (Cif) invokeL.objValue;
    }

    public Cif a(ByteBuffer byteBuffer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, byteBuffer)) == null) {
            this.f1349a = byteBuffer;
            return this;
        }
        return (Cif) invokeL.objValue;
    }

    public Cif a(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z)) == null) {
            this.f1351a = z;
            m1406a(true);
            return this;
        }
        return (Cif) invokeZ.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m1404a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f1348a : (String) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m1405a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (this.f1345a == null) {
                throw new jg("Required field 'action' was not present! Struct: " + toString());
            } else if (this.f1349a == null) {
                throw new jg("Required field 'pushAction' was not present! Struct: " + toString());
            } else if (this.f1347a != null) {
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
        jfVar.m1487a();
        while (true) {
            jc m1483a = jfVar.m1483a();
            byte b2 = m1483a.a;
            if (b2 == 0) {
                jfVar.f();
                if (!c()) {
                    throw new jg("Required field 'encryptAction' was not found in serialized data! Struct: " + toString());
                } else if (d()) {
                    m1405a();
                    return;
                } else {
                    throw new jg("Required field 'isRequest' was not found in serialized data! Struct: " + toString());
                }
            }
            switch (m1483a.f1529a) {
                case 1:
                    if (b2 == 8) {
                        this.f1345a = hj.a(jfVar.m1481a());
                        continue;
                        jfVar.g();
                    }
                    break;
                case 2:
                    if (b2 == 2) {
                        this.f1351a = jfVar.m1492a();
                        m1406a(true);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 3:
                    if (b2 == 2) {
                        this.f1353b = jfVar.m1492a();
                        m1410b(true);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f1349a = jfVar.m1489a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 5:
                    if (b2 == 11) {
                        this.f1348a = jfVar.m1488a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 6:
                    if (b2 == 11) {
                        this.f1352b = jfVar.m1488a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 7:
                    if (b2 == 12) {
                        hy hyVar = new hy();
                        this.f1347a = hyVar;
                        hyVar.a(jfVar);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 8:
                    if (b2 == 12) {
                        hw hwVar = new hw();
                        this.f1346a = hwVar;
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
    public void m1406a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.f1350a.set(0, z);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m1407a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f1345a != null : invokeV.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m1408a(Cif cif) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, cif)) == null) {
            if (cif == null) {
                return false;
            }
            boolean m1407a = m1407a();
            boolean m1407a2 = cif.m1407a();
            if (((!m1407a && !m1407a2) || (m1407a && m1407a2 && this.f1345a.equals(cif.f1345a))) && this.f1351a == cif.f1351a && this.f1353b == cif.f1353b) {
                boolean e2 = e();
                boolean e3 = cif.e();
                if ((e2 || e3) && !(e2 && e3 && this.f1349a.equals(cif.f1349a))) {
                    return false;
                }
                boolean f2 = f();
                boolean f3 = cif.f();
                if ((f2 || f3) && !(f2 && f3 && this.f1348a.equals(cif.f1348a))) {
                    return false;
                }
                boolean g2 = g();
                boolean g3 = cif.g();
                if ((g2 || g3) && !(g2 && g3 && this.f1352b.equals(cif.f1352b))) {
                    return false;
                }
                boolean h2 = h();
                boolean h3 = cif.h();
                if ((h2 || h3) && !(h2 && h3 && this.f1347a.m1381a(cif.f1347a))) {
                    return false;
                }
                boolean i = i();
                boolean i2 = cif.i();
                if (i || i2) {
                    return i && i2 && this.f1346a.m1373a(cif.f1346a);
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m1409a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            a(iv.a(this.f1349a));
            return this.f1349a.array();
        }
        return (byte[]) invokeV.objValue;
    }

    public Cif b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, str)) == null) {
            this.f1352b = str;
            return this;
        }
        return (Cif) invokeL.objValue;
    }

    public Cif b(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048593, this, z)) == null) {
            this.f1353b = z;
            m1410b(true);
            return this;
        }
        return (Cif) invokeZ.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f1352b : (String) invokeV.objValue;
    }

    @Override // com.xiaomi.push.iu
    public void b(jf jfVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, jfVar) == null) {
            m1405a();
            jfVar.a(f1344a);
            if (this.f1345a != null) {
                jfVar.a(a);
                jfVar.a(this.f1345a.a());
                jfVar.b();
            }
            jfVar.a(b);
            jfVar.a(this.f1351a);
            jfVar.b();
            jfVar.a(c);
            jfVar.a(this.f1353b);
            jfVar.b();
            if (this.f1349a != null) {
                jfVar.a(d);
                jfVar.a(this.f1349a);
                jfVar.b();
            }
            if (this.f1348a != null && f()) {
                jfVar.a(e);
                jfVar.a(this.f1348a);
                jfVar.b();
            }
            if (this.f1352b != null && g()) {
                jfVar.a(f);
                jfVar.a(this.f1352b);
                jfVar.b();
            }
            if (this.f1347a != null) {
                jfVar.a(g);
                this.f1347a.b(jfVar);
                jfVar.b();
            }
            if (this.f1346a != null && i()) {
                jfVar.a(h);
                this.f1346a.b(jfVar);
                jfVar.b();
            }
            jfVar.c();
            jfVar.m1491a();
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m1410b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            this.f1350a.set(1, z);
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m1411b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.f1351a : invokeV.booleanValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.f1350a.get(0) : invokeV.booleanValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.f1350a.get(1) : invokeV.booleanValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.f1349a != null : invokeV.booleanValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, obj)) == null) {
            if (obj != null && (obj instanceof Cif)) {
                return m1408a((Cif) obj);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.f1348a != null : invokeV.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.f1352b != null : invokeV.booleanValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.f1347a != null : invokeV.booleanValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.f1346a != null : invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            StringBuilder sb = new StringBuilder("XmPushActionContainer(");
            sb.append("action:");
            hj hjVar = this.f1345a;
            if (hjVar == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(hjVar);
            }
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("encryptAction:");
            sb.append(this.f1351a);
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("isRequest:");
            sb.append(this.f1353b);
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("pushAction:");
            ByteBuffer byteBuffer = this.f1349a;
            if (byteBuffer == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                iv.a(byteBuffer, sb);
            }
            if (f()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("appid:");
                String str = this.f1348a;
                if (str == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str);
                }
            }
            if (g()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("packageName:");
                String str2 = this.f1352b;
                if (str2 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str2);
                }
            }
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("target:");
            hy hyVar = this.f1347a;
            if (hyVar == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(hyVar);
            }
            if (i()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("metaInfo:");
                hw hwVar = this.f1346a;
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
