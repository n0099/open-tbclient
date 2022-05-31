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
/* loaded from: classes8.dex */
public class ib implements iq<ib, Object>, Serializable, Cloneable {
    public static /* synthetic */ Interceptable $ic;
    public static final iy a;

    /* renamed from: a  reason: collision with other field name */
    public static final jg f611a;
    public static final iy b;
    public static final iy c;
    public static final iy d;
    public static final iy e;
    public static final iy f;
    public static final iy g;
    public static final iy h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public hf f612a;

    /* renamed from: a  reason: collision with other field name */
    public hs f613a;

    /* renamed from: a  reason: collision with other field name */
    public hu f614a;

    /* renamed from: a  reason: collision with other field name */
    public String f615a;

    /* renamed from: a  reason: collision with other field name */
    public ByteBuffer f616a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f617a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f618a;

    /* renamed from: b  reason: collision with other field name */
    public String f619b;

    /* renamed from: b  reason: collision with other field name */
    public boolean f620b;

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
        f611a = new jg("XmPushActionContainer");
        a = new iy("", (byte) 8, (short) 1);
        b = new iy("", (byte) 2, (short) 2);
        c = new iy("", (byte) 2, (short) 3);
        d = new iy("", Constants.GZIP_CAST_TYPE, (short) 4);
        e = new iy("", Constants.GZIP_CAST_TYPE, (short) 5);
        f = new iy("", Constants.GZIP_CAST_TYPE, (short) 6);
        g = new iy("", (byte) 12, (short) 7);
        h = new iy("", (byte) 12, (short) 8);
    }

    public ib() {
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
        this.f617a = new BitSet(2);
        this.f618a = true;
        this.f620b = true;
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
                int compareTo = Boolean.valueOf(m492a()).compareTo(Boolean.valueOf(ibVar.m492a()));
                if (compareTo != 0) {
                    return compareTo;
                }
                if (!m492a() || (a9 = ir.a(this.f612a, ibVar.f612a)) == 0) {
                    int compareTo2 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(ibVar.c()));
                    if (compareTo2 != 0) {
                        return compareTo2;
                    }
                    if (!c() || (a8 = ir.a(this.f618a, ibVar.f618a)) == 0) {
                        int compareTo3 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(ibVar.d()));
                        if (compareTo3 != 0) {
                            return compareTo3;
                        }
                        if (!d() || (a7 = ir.a(this.f620b, ibVar.f620b)) == 0) {
                            int compareTo4 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(ibVar.e()));
                            if (compareTo4 != 0) {
                                return compareTo4;
                            }
                            if (!e() || (a6 = ir.a(this.f616a, ibVar.f616a)) == 0) {
                                int compareTo5 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(ibVar.f()));
                                if (compareTo5 != 0) {
                                    return compareTo5;
                                }
                                if (!f() || (a5 = ir.a(this.f615a, ibVar.f615a)) == 0) {
                                    int compareTo6 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ibVar.g()));
                                    if (compareTo6 != 0) {
                                        return compareTo6;
                                    }
                                    if (!g() || (a4 = ir.a(this.f619b, ibVar.f619b)) == 0) {
                                        int compareTo7 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(ibVar.h()));
                                        if (compareTo7 != 0) {
                                            return compareTo7;
                                        }
                                        if (!h() || (a3 = ir.a(this.f614a, ibVar.f614a)) == 0) {
                                            int compareTo8 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(ibVar.i()));
                                            if (compareTo8 != 0) {
                                                return compareTo8;
                                            }
                                            if (!i() || (a2 = ir.a(this.f613a, ibVar.f613a)) == 0) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f612a : (hf) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public hs m488a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f613a : (hs) invokeV.objValue;
    }

    public ib a(hf hfVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, hfVar)) == null) {
            this.f612a = hfVar;
            return this;
        }
        return (ib) invokeL.objValue;
    }

    public ib a(hs hsVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, hsVar)) == null) {
            this.f613a = hsVar;
            return this;
        }
        return (ib) invokeL.objValue;
    }

    public ib a(hu huVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, huVar)) == null) {
            this.f614a = huVar;
            return this;
        }
        return (ib) invokeL.objValue;
    }

    public ib a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            this.f615a = str;
            return this;
        }
        return (ib) invokeL.objValue;
    }

    public ib a(ByteBuffer byteBuffer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, byteBuffer)) == null) {
            this.f616a = byteBuffer;
            return this;
        }
        return (ib) invokeL.objValue;
    }

    public ib a(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z)) == null) {
            this.f618a = z;
            m491a(true);
            return this;
        }
        return (ib) invokeZ.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m489a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f615a : (String) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m490a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (this.f612a == null) {
                throw new jc("Required field 'action' was not present! Struct: " + toString());
            } else if (this.f616a == null) {
                throw new jc("Required field 'pushAction' was not present! Struct: " + toString());
            } else if (this.f614a != null) {
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
        jbVar.m562a();
        while (true) {
            iy m558a = jbVar.m558a();
            byte b2 = m558a.a;
            if (b2 == 0) {
                jbVar.f();
                if (!c()) {
                    throw new jc("Required field 'encryptAction' was not found in serialized data! Struct: " + toString());
                } else if (d()) {
                    m490a();
                    return;
                } else {
                    throw new jc("Required field 'isRequest' was not found in serialized data! Struct: " + toString());
                }
            }
            switch (m558a.f791a) {
                case 1:
                    if (b2 == 8) {
                        this.f612a = hf.a(jbVar.m556a());
                        continue;
                        jbVar.g();
                    }
                    break;
                case 2:
                    if (b2 == 2) {
                        this.f618a = jbVar.m567a();
                        m491a(true);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 3:
                    if (b2 == 2) {
                        this.f620b = jbVar.m567a();
                        m495b(true);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f616a = jbVar.m564a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 5:
                    if (b2 == 11) {
                        this.f615a = jbVar.m563a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 6:
                    if (b2 == 11) {
                        this.f619b = jbVar.m563a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 7:
                    if (b2 == 12) {
                        hu huVar = new hu();
                        this.f614a = huVar;
                        huVar.a(jbVar);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 8:
                    if (b2 == 12) {
                        hs hsVar = new hs();
                        this.f613a = hsVar;
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
    public void m491a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.f617a.set(0, z);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m492a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f612a != null : invokeV.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m493a(ib ibVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, ibVar)) == null) {
            if (ibVar == null) {
                return false;
            }
            boolean m492a = m492a();
            boolean m492a2 = ibVar.m492a();
            if (((!m492a && !m492a2) || (m492a && m492a2 && this.f612a.equals(ibVar.f612a))) && this.f618a == ibVar.f618a && this.f620b == ibVar.f620b) {
                boolean e2 = e();
                boolean e3 = ibVar.e();
                if ((e2 || e3) && !(e2 && e3 && this.f616a.equals(ibVar.f616a))) {
                    return false;
                }
                boolean f2 = f();
                boolean f3 = ibVar.f();
                if ((f2 || f3) && !(f2 && f3 && this.f615a.equals(ibVar.f615a))) {
                    return false;
                }
                boolean g2 = g();
                boolean g3 = ibVar.g();
                if ((g2 || g3) && !(g2 && g3 && this.f619b.equals(ibVar.f619b))) {
                    return false;
                }
                boolean h2 = h();
                boolean h3 = ibVar.h();
                if ((h2 || h3) && !(h2 && h3 && this.f614a.m457a(ibVar.f614a))) {
                    return false;
                }
                boolean i = i();
                boolean i2 = ibVar.i();
                if (i || i2) {
                    return i && i2 && this.f613a.m449a(ibVar.f613a);
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m494a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            a(ir.a(this.f616a));
            return this.f616a.array();
        }
        return (byte[]) invokeV.objValue;
    }

    public ib b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, str)) == null) {
            this.f619b = str;
            return this;
        }
        return (ib) invokeL.objValue;
    }

    public ib b(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048593, this, z)) == null) {
            this.f620b = z;
            m495b(true);
            return this;
        }
        return (ib) invokeZ.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f619b : (String) invokeV.objValue;
    }

    @Override // com.xiaomi.push.iq
    public void b(jb jbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, jbVar) == null) {
            m490a();
            jbVar.a(f611a);
            if (this.f612a != null) {
                jbVar.a(a);
                jbVar.a(this.f612a.a());
                jbVar.b();
            }
            jbVar.a(b);
            jbVar.a(this.f618a);
            jbVar.b();
            jbVar.a(c);
            jbVar.a(this.f620b);
            jbVar.b();
            if (this.f616a != null) {
                jbVar.a(d);
                jbVar.a(this.f616a);
                jbVar.b();
            }
            if (this.f615a != null && f()) {
                jbVar.a(e);
                jbVar.a(this.f615a);
                jbVar.b();
            }
            if (this.f619b != null && g()) {
                jbVar.a(f);
                jbVar.a(this.f619b);
                jbVar.b();
            }
            if (this.f614a != null) {
                jbVar.a(g);
                this.f614a.b(jbVar);
                jbVar.b();
            }
            if (this.f613a != null && i()) {
                jbVar.a(h);
                this.f613a.b(jbVar);
                jbVar.b();
            }
            jbVar.c();
            jbVar.m566a();
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m495b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            this.f617a.set(1, z);
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m496b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.f618a : invokeV.booleanValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.f617a.get(0) : invokeV.booleanValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.f617a.get(1) : invokeV.booleanValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.f616a != null : invokeV.booleanValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, obj)) == null) {
            if (obj != null && (obj instanceof ib)) {
                return m493a((ib) obj);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.f615a != null : invokeV.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.f619b != null : invokeV.booleanValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.f614a != null : invokeV.booleanValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.f613a != null : invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            StringBuilder sb = new StringBuilder("XmPushActionContainer(");
            sb.append("action:");
            hf hfVar = this.f612a;
            if (hfVar == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(hfVar);
            }
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("encryptAction:");
            sb.append(this.f618a);
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("isRequest:");
            sb.append(this.f620b);
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("pushAction:");
            ByteBuffer byteBuffer = this.f616a;
            if (byteBuffer == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                ir.a(byteBuffer, sb);
            }
            if (f()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("appid:");
                String str = this.f615a;
                if (str == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str);
                }
            }
            if (g()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("packageName:");
                String str2 = this.f619b;
                if (str2 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str2);
                }
            }
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("target:");
            hu huVar = this.f614a;
            if (huVar == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(huVar);
            }
            if (i()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("metaInfo:");
                hs hsVar = this.f613a;
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
