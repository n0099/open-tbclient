package com.xiaomi.push;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.disklrucache.StrictLineReader;
import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes8.dex */
public class im implements iu<im, Object>, Serializable, Cloneable {
    public static /* synthetic */ Interceptable $ic;
    public static final jc a;

    /* renamed from: a  reason: collision with other field name */
    public static final jk f718a;
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
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public hv f719a;

    /* renamed from: a  reason: collision with other field name */
    public hy f720a;

    /* renamed from: a  reason: collision with other field name */
    public String f721a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f722a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f723a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f724a;

    /* renamed from: b  reason: collision with other field name */
    public String f725b;

    /* renamed from: c  reason: collision with other field name */
    public String f726c;

    /* renamed from: d  reason: collision with other field name */
    public String f727d;

    /* renamed from: e  reason: collision with other field name */
    public String f728e;

    /* renamed from: f  reason: collision with other field name */
    public String f729f;

    /* renamed from: g  reason: collision with other field name */
    public String f730g;

    /* renamed from: h  reason: collision with other field name */
    public String f731h;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-56371812, "Lcom/xiaomi/push/im;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-56371812, "Lcom/xiaomi/push/im;");
                return;
            }
        }
        f718a = new jk("XmPushActionSendMessage");
        a = new jc("", Constants.GZIP_CAST_TYPE, (short) 1);
        b = new jc("", (byte) 12, (short) 2);
        c = new jc("", Constants.GZIP_CAST_TYPE, (short) 3);
        d = new jc("", Constants.GZIP_CAST_TYPE, (short) 4);
        e = new jc("", Constants.GZIP_CAST_TYPE, (short) 5);
        f = new jc("", Constants.GZIP_CAST_TYPE, (short) 6);
        g = new jc("", Constants.GZIP_CAST_TYPE, (short) 7);
        h = new jc("", (byte) 12, (short) 8);
        i = new jc("", (byte) 2, (short) 9);
        j = new jc("", StrictLineReader.CR, (short) 10);
        k = new jc("", Constants.GZIP_CAST_TYPE, (short) 11);
        l = new jc("", Constants.GZIP_CAST_TYPE, (short) 12);
    }

    public im() {
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
        this.f722a = new BitSet(1);
        this.f724a = true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(im imVar) {
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
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, imVar)) == null) {
            if (im.class.equals(imVar.getClass())) {
                int compareTo = Boolean.valueOf(m506a()).compareTo(Boolean.valueOf(imVar.m506a()));
                if (compareTo != 0) {
                    return compareTo;
                }
                if (!m506a() || (a13 = iv.a(this.f721a, imVar.f721a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m508b()).compareTo(Boolean.valueOf(imVar.m508b()));
                    if (compareTo2 != 0) {
                        return compareTo2;
                    }
                    if (!m508b() || (a12 = iv.a(this.f720a, imVar.f720a)) == 0) {
                        int compareTo3 = Boolean.valueOf(m509c()).compareTo(Boolean.valueOf(imVar.m509c()));
                        if (compareTo3 != 0) {
                            return compareTo3;
                        }
                        if (!m509c() || (a11 = iv.a(this.f725b, imVar.f725b)) == 0) {
                            int compareTo4 = Boolean.valueOf(m510d()).compareTo(Boolean.valueOf(imVar.m510d()));
                            if (compareTo4 != 0) {
                                return compareTo4;
                            }
                            if (!m510d() || (a10 = iv.a(this.f726c, imVar.f726c)) == 0) {
                                int compareTo5 = Boolean.valueOf(m511e()).compareTo(Boolean.valueOf(imVar.m511e()));
                                if (compareTo5 != 0) {
                                    return compareTo5;
                                }
                                if (!m511e() || (a9 = iv.a(this.f727d, imVar.f727d)) == 0) {
                                    int compareTo6 = Boolean.valueOf(m512f()).compareTo(Boolean.valueOf(imVar.m512f()));
                                    if (compareTo6 != 0) {
                                        return compareTo6;
                                    }
                                    if (!m512f() || (a8 = iv.a(this.f728e, imVar.f728e)) == 0) {
                                        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(imVar.g()));
                                        if (compareTo7 != 0) {
                                            return compareTo7;
                                        }
                                        if (!g() || (a7 = iv.a(this.f729f, imVar.f729f)) == 0) {
                                            int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(imVar.h()));
                                            if (compareTo8 != 0) {
                                                return compareTo8;
                                            }
                                            if (!h() || (a6 = iv.a(this.f719a, imVar.f719a)) == 0) {
                                                int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(imVar.i()));
                                                if (compareTo9 != 0) {
                                                    return compareTo9;
                                                }
                                                if (!i() || (a5 = iv.a(this.f724a, imVar.f724a)) == 0) {
                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(imVar.j()));
                                                    if (compareTo10 != 0) {
                                                        return compareTo10;
                                                    }
                                                    if (!j() || (a4 = iv.a(this.f723a, imVar.f723a)) == 0) {
                                                        int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(imVar.k()));
                                                        if (compareTo11 != 0) {
                                                            return compareTo11;
                                                        }
                                                        if (!k() || (a3 = iv.a(this.f730g, imVar.f730g)) == 0) {
                                                            int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(imVar.l()));
                                                            if (compareTo12 != 0) {
                                                                return compareTo12;
                                                            }
                                                            if (!l() || (a2 = iv.a(this.f731h, imVar.f731h)) == 0) {
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
            return im.class.getName().compareTo(imVar.getClass().getName());
        }
        return invokeL.intValue;
    }

    public hv a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f719a : (hv) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m504a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f725b : (String) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m505a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.f725b == null) {
                throw new jg("Required field 'id' was not present! Struct: " + toString());
            } else if (this.f726c != null) {
            } else {
                throw new jg("Required field 'appId' was not present! Struct: " + toString());
            }
        }
    }

    @Override // com.xiaomi.push.iu
    public void a(jf jfVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(1048580, this, jfVar) != null) {
            return;
        }
        jfVar.m550a();
        while (true) {
            jc m546a = jfVar.m546a();
            byte b2 = m546a.a;
            if (b2 == 0) {
                jfVar.f();
                m505a();
                return;
            }
            switch (m546a.f810a) {
                case 1:
                    if (b2 == 11) {
                        this.f721a = jfVar.m551a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 2:
                    if (b2 == 12) {
                        hy hyVar = new hy();
                        this.f720a = hyVar;
                        hyVar.a(jfVar);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f725b = jfVar.m551a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f726c = jfVar.m551a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 5:
                    if (b2 == 11) {
                        this.f727d = jfVar.m551a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 6:
                    if (b2 == 11) {
                        this.f728e = jfVar.m551a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f729f = jfVar.m551a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 8:
                    if (b2 == 12) {
                        hv hvVar = new hv();
                        this.f719a = hvVar;
                        hvVar.a(jfVar);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 9:
                    if (b2 == 2) {
                        this.f724a = jfVar.m555a();
                        a(true);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 10:
                    if (b2 == 13) {
                        je m548a = jfVar.m548a();
                        this.f723a = new HashMap(m548a.f812a * 2);
                        for (int i2 = 0; i2 < m548a.f812a; i2++) {
                            this.f723a.put(jfVar.m551a(), jfVar.m551a());
                        }
                        jfVar.h();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 11:
                    if (b2 == 11) {
                        this.f730g = jfVar.m551a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 12:
                    if (b2 == 11) {
                        this.f731h = jfVar.m551a();
                        continue;
                        jfVar.g();
                    }
                    break;
            }
            ji.a(jfVar, b2);
            jfVar.g();
        }
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.f722a.set(0, z);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m506a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f721a != null : invokeV.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m507a(im imVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, imVar)) == null) {
            if (imVar == null) {
                return false;
            }
            boolean m506a = m506a();
            boolean m506a2 = imVar.m506a();
            if ((m506a || m506a2) && !(m506a && m506a2 && this.f721a.equals(imVar.f721a))) {
                return false;
            }
            boolean m508b = m508b();
            boolean m508b2 = imVar.m508b();
            if ((m508b || m508b2) && !(m508b && m508b2 && this.f720a.m444a(imVar.f720a))) {
                return false;
            }
            boolean m509c = m509c();
            boolean m509c2 = imVar.m509c();
            if ((m509c || m509c2) && !(m509c && m509c2 && this.f725b.equals(imVar.f725b))) {
                return false;
            }
            boolean m510d = m510d();
            boolean m510d2 = imVar.m510d();
            if ((m510d || m510d2) && !(m510d && m510d2 && this.f726c.equals(imVar.f726c))) {
                return false;
            }
            boolean m511e = m511e();
            boolean m511e2 = imVar.m511e();
            if ((m511e || m511e2) && !(m511e && m511e2 && this.f727d.equals(imVar.f727d))) {
                return false;
            }
            boolean m512f = m512f();
            boolean m512f2 = imVar.m512f();
            if ((m512f || m512f2) && !(m512f && m512f2 && this.f728e.equals(imVar.f728e))) {
                return false;
            }
            boolean g2 = g();
            boolean g3 = imVar.g();
            if ((g2 || g3) && !(g2 && g3 && this.f729f.equals(imVar.f729f))) {
                return false;
            }
            boolean h2 = h();
            boolean h3 = imVar.h();
            if ((h2 || h3) && !(h2 && h3 && this.f719a.m427a(imVar.f719a))) {
                return false;
            }
            boolean i2 = i();
            boolean i3 = imVar.i();
            if ((i2 || i3) && !(i2 && i3 && this.f724a == imVar.f724a)) {
                return false;
            }
            boolean j2 = j();
            boolean j3 = imVar.j();
            if ((j2 || j3) && !(j2 && j3 && this.f723a.equals(imVar.f723a))) {
                return false;
            }
            boolean k2 = k();
            boolean k3 = imVar.k();
            if ((k2 || k3) && !(k2 && k3 && this.f730g.equals(imVar.f730g))) {
                return false;
            }
            boolean l2 = l();
            boolean l3 = imVar.l();
            if (l2 || l3) {
                return l2 && l3 && this.f731h.equals(imVar.f731h);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f726c : (String) invokeV.objValue;
    }

    @Override // com.xiaomi.push.iu
    public void b(jf jfVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, jfVar) == null) {
            m505a();
            jfVar.a(f718a);
            if (this.f721a != null && m506a()) {
                jfVar.a(a);
                jfVar.a(this.f721a);
                jfVar.b();
            }
            if (this.f720a != null && m508b()) {
                jfVar.a(b);
                this.f720a.b(jfVar);
                jfVar.b();
            }
            if (this.f725b != null) {
                jfVar.a(c);
                jfVar.a(this.f725b);
                jfVar.b();
            }
            if (this.f726c != null) {
                jfVar.a(d);
                jfVar.a(this.f726c);
                jfVar.b();
            }
            if (this.f727d != null && m511e()) {
                jfVar.a(e);
                jfVar.a(this.f727d);
                jfVar.b();
            }
            if (this.f728e != null && m512f()) {
                jfVar.a(f);
                jfVar.a(this.f728e);
                jfVar.b();
            }
            if (this.f729f != null && g()) {
                jfVar.a(g);
                jfVar.a(this.f729f);
                jfVar.b();
            }
            if (this.f719a != null && h()) {
                jfVar.a(h);
                this.f719a.b(jfVar);
                jfVar.b();
            }
            if (i()) {
                jfVar.a(i);
                jfVar.a(this.f724a);
                jfVar.b();
            }
            if (this.f723a != null && j()) {
                jfVar.a(j);
                jfVar.a(new je(Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, this.f723a.size()));
                for (Map.Entry<String, String> entry : this.f723a.entrySet()) {
                    jfVar.a(entry.getKey());
                    jfVar.a(entry.getValue());
                }
                jfVar.d();
                jfVar.b();
            }
            if (this.f730g != null && k()) {
                jfVar.a(k);
                jfVar.a(this.f730g);
                jfVar.b();
            }
            if (this.f731h != null && l()) {
                jfVar.a(l);
                jfVar.a(this.f731h);
                jfVar.b();
            }
            jfVar.c();
            jfVar.m554a();
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m508b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f720a != null : invokeV.booleanValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f728e : (String) invokeV.objValue;
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m509c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f725b != null : invokeV.booleanValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f729f : (String) invokeV.objValue;
    }

    /* renamed from: d  reason: collision with other method in class */
    public boolean m510d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f726c != null : invokeV.booleanValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f730g : (String) invokeV.objValue;
    }

    /* renamed from: e  reason: collision with other method in class */
    public boolean m511e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.f727d != null : invokeV.booleanValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, obj)) == null) {
            if (obj != null && (obj instanceof im)) {
                return m507a((im) obj);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f731h : (String) invokeV.objValue;
    }

    /* renamed from: f  reason: collision with other method in class */
    public boolean m512f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f728e != null : invokeV.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.f729f != null : invokeV.booleanValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.f719a != null : invokeV.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.f722a.get(0) : invokeV.booleanValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.f723a != null : invokeV.booleanValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.f730g != null : invokeV.booleanValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.f731h != null : invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            StringBuilder sb = new StringBuilder("XmPushActionSendMessage(");
            boolean z2 = false;
            if (m506a()) {
                sb.append("debug:");
                String str = this.f721a;
                if (str == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str);
                }
                z = false;
            } else {
                z = true;
            }
            if (m508b()) {
                if (!z) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                }
                sb.append("target:");
                hy hyVar = this.f720a;
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
            String str2 = this.f725b;
            if (str2 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str2);
            }
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("appId:");
            String str3 = this.f726c;
            if (str3 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str3);
            }
            if (m511e()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("packageName:");
                String str4 = this.f727d;
                if (str4 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str4);
                }
            }
            if (m512f()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append(UrlSchemaHelper.SCHEMA_TYPE_TOPIC);
                String str5 = this.f728e;
                if (str5 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str5);
                }
            }
            if (g()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("aliasName:");
                String str6 = this.f729f;
                if (str6 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str6);
                }
            }
            if (h()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("message:");
                hv hvVar = this.f719a;
                if (hvVar == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(hvVar);
                }
            }
            if (i()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("needAck:");
                sb.append(this.f724a);
            }
            if (j()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("params:");
                Map<String, String> map = this.f723a;
                if (map == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(map);
                }
            }
            if (k()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("category:");
                String str7 = this.f730g;
                if (str7 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str7);
                }
            }
            if (l()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("userAccount:");
                String str8 = this.f731h;
                if (str8 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str8);
                }
            }
            sb.append(SmallTailInfo.EMOTION_SUFFIX);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
