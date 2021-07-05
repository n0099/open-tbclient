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
import io.flutter.plugin.common.StandardMessageCodec;
import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes8.dex */
public class ii implements iq<ii, Object>, Serializable, Cloneable {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final iy f43420a;

    /* renamed from: a  reason: collision with other field name */
    public static final jg f721a;

    /* renamed from: b  reason: collision with root package name */
    public static final iy f43421b;

    /* renamed from: c  reason: collision with root package name */
    public static final iy f43422c;

    /* renamed from: d  reason: collision with root package name */
    public static final iy f43423d;

    /* renamed from: e  reason: collision with root package name */
    public static final iy f43424e;

    /* renamed from: f  reason: collision with root package name */
    public static final iy f43425f;

    /* renamed from: g  reason: collision with root package name */
    public static final iy f43426g;

    /* renamed from: h  reason: collision with root package name */
    public static final iy f43427h;

    /* renamed from: i  reason: collision with root package name */
    public static final iy f43428i;
    public static final iy j;
    public static final iy k;
    public static final iy l;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public hr f722a;

    /* renamed from: a  reason: collision with other field name */
    public hu f723a;

    /* renamed from: a  reason: collision with other field name */
    public String f724a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f725a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f726a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f727a;

    /* renamed from: b  reason: collision with other field name */
    public String f728b;

    /* renamed from: c  reason: collision with other field name */
    public String f729c;

    /* renamed from: d  reason: collision with other field name */
    public String f730d;

    /* renamed from: e  reason: collision with other field name */
    public String f731e;

    /* renamed from: f  reason: collision with other field name */
    public String f732f;

    /* renamed from: g  reason: collision with other field name */
    public String f733g;

    /* renamed from: h  reason: collision with other field name */
    public String f734h;

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
        f721a = new jg("XmPushActionSendMessage");
        f43420a = new iy("", (byte) 11, (short) 1);
        f43421b = new iy("", StandardMessageCodec.LIST, (short) 2);
        f43422c = new iy("", (byte) 11, (short) 3);
        f43423d = new iy("", (byte) 11, (short) 4);
        f43424e = new iy("", (byte) 11, (short) 5);
        f43425f = new iy("", (byte) 11, (short) 6);
        f43426g = new iy("", (byte) 11, (short) 7);
        f43427h = new iy("", StandardMessageCodec.LIST, (short) 8);
        f43428i = new iy("", (byte) 2, (short) 9);
        j = new iy("", (byte) 13, (short) 10);
        k = new iy("", (byte) 11, (short) 11);
        l = new iy("", (byte) 11, (short) 12);
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
        this.f725a = new BitSet(1);
        this.f727a = true;
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
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, iiVar)) == null) {
            if (ii.class.equals(iiVar.getClass())) {
                int compareTo = Boolean.valueOf(m488a()).compareTo(Boolean.valueOf(iiVar.m488a()));
                if (compareTo != 0) {
                    return compareTo;
                }
                if (!m488a() || (a13 = ir.a(this.f724a, iiVar.f724a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m490b()).compareTo(Boolean.valueOf(iiVar.m490b()));
                    if (compareTo2 != 0) {
                        return compareTo2;
                    }
                    if (!m490b() || (a12 = ir.a(this.f723a, iiVar.f723a)) == 0) {
                        int compareTo3 = Boolean.valueOf(m491c()).compareTo(Boolean.valueOf(iiVar.m491c()));
                        if (compareTo3 != 0) {
                            return compareTo3;
                        }
                        if (!m491c() || (a11 = ir.a(this.f728b, iiVar.f728b)) == 0) {
                            int compareTo4 = Boolean.valueOf(m492d()).compareTo(Boolean.valueOf(iiVar.m492d()));
                            if (compareTo4 != 0) {
                                return compareTo4;
                            }
                            if (!m492d() || (a10 = ir.a(this.f729c, iiVar.f729c)) == 0) {
                                int compareTo5 = Boolean.valueOf(m493e()).compareTo(Boolean.valueOf(iiVar.m493e()));
                                if (compareTo5 != 0) {
                                    return compareTo5;
                                }
                                if (!m493e() || (a9 = ir.a(this.f730d, iiVar.f730d)) == 0) {
                                    int compareTo6 = Boolean.valueOf(m494f()).compareTo(Boolean.valueOf(iiVar.m494f()));
                                    if (compareTo6 != 0) {
                                        return compareTo6;
                                    }
                                    if (!m494f() || (a8 = ir.a(this.f731e, iiVar.f731e)) == 0) {
                                        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(iiVar.g()));
                                        if (compareTo7 != 0) {
                                            return compareTo7;
                                        }
                                        if (!g() || (a7 = ir.a(this.f732f, iiVar.f732f)) == 0) {
                                            int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(iiVar.h()));
                                            if (compareTo8 != 0) {
                                                return compareTo8;
                                            }
                                            if (!h() || (a6 = ir.a(this.f722a, iiVar.f722a)) == 0) {
                                                int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(iiVar.i()));
                                                if (compareTo9 != 0) {
                                                    return compareTo9;
                                                }
                                                if (!i() || (a5 = ir.a(this.f727a, iiVar.f727a)) == 0) {
                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(iiVar.j()));
                                                    if (compareTo10 != 0) {
                                                        return compareTo10;
                                                    }
                                                    if (!j() || (a4 = ir.a(this.f726a, iiVar.f726a)) == 0) {
                                                        int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(iiVar.k()));
                                                        if (compareTo11 != 0) {
                                                            return compareTo11;
                                                        }
                                                        if (!k() || (a3 = ir.a(this.f733g, iiVar.f733g)) == 0) {
                                                            int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(iiVar.l()));
                                                            if (compareTo12 != 0) {
                                                                return compareTo12;
                                                            }
                                                            if (!l() || (a2 = ir.a(this.f734h, iiVar.f734h)) == 0) {
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
            return ii.class.getName().compareTo(iiVar.getClass().getName());
        }
        return invokeL.intValue;
    }

    public hr a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f722a : (hr) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m486a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f728b : (String) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m487a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.f728b == null) {
                throw new jc("Required field 'id' was not present! Struct: " + toString());
            } else if (this.f729c != null) {
            } else {
                throw new jc("Required field 'appId' was not present! Struct: " + toString());
            }
        }
    }

    @Override // com.xiaomi.push.iq
    public void a(jb jbVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(1048580, this, jbVar) != null) {
            return;
        }
        jbVar.m524a();
        while (true) {
            iy m520a = jbVar.m520a();
            byte b2 = m520a.f43494a;
            if (b2 == 0) {
                jbVar.f();
                m487a();
                return;
            }
            switch (m520a.f810a) {
                case 1:
                    if (b2 == 11) {
                        this.f724a = jbVar.m525a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 2:
                    if (b2 == 12) {
                        hu huVar = new hu();
                        this.f723a = huVar;
                        huVar.a(jbVar);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f728b = jbVar.m525a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f729c = jbVar.m525a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 5:
                    if (b2 == 11) {
                        this.f730d = jbVar.m525a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 6:
                    if (b2 == 11) {
                        this.f731e = jbVar.m525a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f732f = jbVar.m525a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 8:
                    if (b2 == 12) {
                        hr hrVar = new hr();
                        this.f722a = hrVar;
                        hrVar.a(jbVar);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 9:
                    if (b2 == 2) {
                        this.f727a = jbVar.m529a();
                        a(true);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 10:
                    if (b2 == 13) {
                        ja m522a = jbVar.m522a();
                        this.f726a = new HashMap(m522a.f814a * 2);
                        for (int i2 = 0; i2 < m522a.f814a; i2++) {
                            this.f726a.put(jbVar.m525a(), jbVar.m525a());
                        }
                        jbVar.h();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 11:
                    if (b2 == 11) {
                        this.f733g = jbVar.m525a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 12:
                    if (b2 == 11) {
                        this.f734h = jbVar.m525a();
                        continue;
                        jbVar.g();
                    }
                    break;
            }
            je.a(jbVar, b2);
            jbVar.g();
        }
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.f725a.set(0, z);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m488a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f724a != null : invokeV.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m489a(ii iiVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, iiVar)) == null) {
            if (iiVar == null) {
                return false;
            }
            boolean m488a = m488a();
            boolean m488a2 = iiVar.m488a();
            if ((m488a || m488a2) && !(m488a && m488a2 && this.f724a.equals(iiVar.f724a))) {
                return false;
            }
            boolean m490b = m490b();
            boolean m490b2 = iiVar.m490b();
            if ((m490b || m490b2) && !(m490b && m490b2 && this.f723a.m419a(iiVar.f723a))) {
                return false;
            }
            boolean m491c = m491c();
            boolean m491c2 = iiVar.m491c();
            if ((m491c || m491c2) && !(m491c && m491c2 && this.f728b.equals(iiVar.f728b))) {
                return false;
            }
            boolean m492d = m492d();
            boolean m492d2 = iiVar.m492d();
            if ((m492d || m492d2) && !(m492d && m492d2 && this.f729c.equals(iiVar.f729c))) {
                return false;
            }
            boolean m493e = m493e();
            boolean m493e2 = iiVar.m493e();
            if ((m493e || m493e2) && !(m493e && m493e2 && this.f730d.equals(iiVar.f730d))) {
                return false;
            }
            boolean m494f = m494f();
            boolean m494f2 = iiVar.m494f();
            if ((m494f || m494f2) && !(m494f && m494f2 && this.f731e.equals(iiVar.f731e))) {
                return false;
            }
            boolean g2 = g();
            boolean g3 = iiVar.g();
            if ((g2 || g3) && !(g2 && g3 && this.f732f.equals(iiVar.f732f))) {
                return false;
            }
            boolean h2 = h();
            boolean h3 = iiVar.h();
            if ((h2 || h3) && !(h2 && h3 && this.f722a.m402a(iiVar.f722a))) {
                return false;
            }
            boolean i2 = i();
            boolean i3 = iiVar.i();
            if ((i2 || i3) && !(i2 && i3 && this.f727a == iiVar.f727a)) {
                return false;
            }
            boolean j2 = j();
            boolean j3 = iiVar.j();
            if ((j2 || j3) && !(j2 && j3 && this.f726a.equals(iiVar.f726a))) {
                return false;
            }
            boolean k2 = k();
            boolean k3 = iiVar.k();
            if ((k2 || k3) && !(k2 && k3 && this.f733g.equals(iiVar.f733g))) {
                return false;
            }
            boolean l2 = l();
            boolean l3 = iiVar.l();
            if (l2 || l3) {
                return l2 && l3 && this.f734h.equals(iiVar.f734h);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f729c : (String) invokeV.objValue;
    }

    @Override // com.xiaomi.push.iq
    public void b(jb jbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, jbVar) == null) {
            m487a();
            jbVar.a(f721a);
            if (this.f724a != null && m488a()) {
                jbVar.a(f43420a);
                jbVar.a(this.f724a);
                jbVar.b();
            }
            if (this.f723a != null && m490b()) {
                jbVar.a(f43421b);
                this.f723a.b(jbVar);
                jbVar.b();
            }
            if (this.f728b != null) {
                jbVar.a(f43422c);
                jbVar.a(this.f728b);
                jbVar.b();
            }
            if (this.f729c != null) {
                jbVar.a(f43423d);
                jbVar.a(this.f729c);
                jbVar.b();
            }
            if (this.f730d != null && m493e()) {
                jbVar.a(f43424e);
                jbVar.a(this.f730d);
                jbVar.b();
            }
            if (this.f731e != null && m494f()) {
                jbVar.a(f43425f);
                jbVar.a(this.f731e);
                jbVar.b();
            }
            if (this.f732f != null && g()) {
                jbVar.a(f43426g);
                jbVar.a(this.f732f);
                jbVar.b();
            }
            if (this.f722a != null && h()) {
                jbVar.a(f43427h);
                this.f722a.b(jbVar);
                jbVar.b();
            }
            if (i()) {
                jbVar.a(f43428i);
                jbVar.a(this.f727a);
                jbVar.b();
            }
            if (this.f726a != null && j()) {
                jbVar.a(j);
                jbVar.a(new ja((byte) 11, (byte) 11, this.f726a.size()));
                for (Map.Entry<String, String> entry : this.f726a.entrySet()) {
                    jbVar.a(entry.getKey());
                    jbVar.a(entry.getValue());
                }
                jbVar.d();
                jbVar.b();
            }
            if (this.f733g != null && k()) {
                jbVar.a(k);
                jbVar.a(this.f733g);
                jbVar.b();
            }
            if (this.f734h != null && l()) {
                jbVar.a(l);
                jbVar.a(this.f734h);
                jbVar.b();
            }
            jbVar.c();
            jbVar.m528a();
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m490b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f723a != null : invokeV.booleanValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f731e : (String) invokeV.objValue;
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m491c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f728b != null : invokeV.booleanValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f732f : (String) invokeV.objValue;
    }

    /* renamed from: d  reason: collision with other method in class */
    public boolean m492d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f729c != null : invokeV.booleanValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f733g : (String) invokeV.objValue;
    }

    /* renamed from: e  reason: collision with other method in class */
    public boolean m493e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.f730d != null : invokeV.booleanValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, obj)) == null) {
            if (obj != null && (obj instanceof ii)) {
                return m489a((ii) obj);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f734h : (String) invokeV.objValue;
    }

    /* renamed from: f  reason: collision with other method in class */
    public boolean m494f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f731e != null : invokeV.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.f732f != null : invokeV.booleanValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.f722a != null : invokeV.booleanValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.f725a.get(0) : invokeV.booleanValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.f726a != null : invokeV.booleanValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.f733g != null : invokeV.booleanValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.f734h != null : invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            StringBuilder sb = new StringBuilder("XmPushActionSendMessage(");
            boolean z2 = false;
            if (m488a()) {
                sb.append("debug:");
                String str = this.f724a;
                if (str == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str);
                }
                z = false;
            } else {
                z = true;
            }
            if (m490b()) {
                if (!z) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                }
                sb.append("target:");
                hu huVar = this.f723a;
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
            String str2 = this.f728b;
            if (str2 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str2);
            }
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("appId:");
            String str3 = this.f729c;
            if (str3 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str3);
            }
            if (m493e()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("packageName:");
                String str4 = this.f730d;
                if (str4 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str4);
                }
            }
            if (m494f()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append(UrlSchemaHelper.SCHEMA_TYPE_TOPIC);
                String str5 = this.f731e;
                if (str5 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str5);
                }
            }
            if (g()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("aliasName:");
                String str6 = this.f732f;
                if (str6 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str6);
                }
            }
            if (h()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("message:");
                hr hrVar = this.f722a;
                if (hrVar == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(hrVar);
                }
            }
            if (i()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("needAck:");
                sb.append(this.f727a);
            }
            if (j()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("params:");
                Map<String, String> map = this.f726a;
                if (map == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(map);
                }
            }
            if (k()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("category:");
                String str7 = this.f733g;
                if (str7 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str7);
                }
            }
            if (l()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("userAccount:");
                String str8 = this.f734h;
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
