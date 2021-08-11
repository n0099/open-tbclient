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
/* loaded from: classes10.dex */
public class ii implements iq<ii, Object>, Serializable, Cloneable {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final iy f77579a;

    /* renamed from: a  reason: collision with other field name */
    public static final jg f725a;

    /* renamed from: b  reason: collision with root package name */
    public static final iy f77580b;

    /* renamed from: c  reason: collision with root package name */
    public static final iy f77581c;

    /* renamed from: d  reason: collision with root package name */
    public static final iy f77582d;

    /* renamed from: e  reason: collision with root package name */
    public static final iy f77583e;

    /* renamed from: f  reason: collision with root package name */
    public static final iy f77584f;

    /* renamed from: g  reason: collision with root package name */
    public static final iy f77585g;

    /* renamed from: h  reason: collision with root package name */
    public static final iy f77586h;

    /* renamed from: i  reason: collision with root package name */
    public static final iy f77587i;

    /* renamed from: j  reason: collision with root package name */
    public static final iy f77588j;
    public static final iy k;
    public static final iy l;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public hr f726a;

    /* renamed from: a  reason: collision with other field name */
    public hu f727a;

    /* renamed from: a  reason: collision with other field name */
    public String f728a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f729a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f730a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f731a;

    /* renamed from: b  reason: collision with other field name */
    public String f732b;

    /* renamed from: c  reason: collision with other field name */
    public String f733c;

    /* renamed from: d  reason: collision with other field name */
    public String f734d;

    /* renamed from: e  reason: collision with other field name */
    public String f735e;

    /* renamed from: f  reason: collision with other field name */
    public String f736f;

    /* renamed from: g  reason: collision with other field name */
    public String f737g;

    /* renamed from: h  reason: collision with other field name */
    public String f738h;

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
        f725a = new jg("XmPushActionSendMessage");
        f77579a = new iy("", (byte) 11, (short) 1);
        f77580b = new iy("", StandardMessageCodec.LIST, (short) 2);
        f77581c = new iy("", (byte) 11, (short) 3);
        f77582d = new iy("", (byte) 11, (short) 4);
        f77583e = new iy("", (byte) 11, (short) 5);
        f77584f = new iy("", (byte) 11, (short) 6);
        f77585g = new iy("", (byte) 11, (short) 7);
        f77586h = new iy("", StandardMessageCodec.LIST, (short) 8);
        f77587i = new iy("", (byte) 2, (short) 9);
        f77588j = new iy("", (byte) 13, (short) 10);
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
        this.f729a = new BitSet(1);
        this.f731a = true;
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
                int compareTo = Boolean.valueOf(m491a()).compareTo(Boolean.valueOf(iiVar.m491a()));
                if (compareTo != 0) {
                    return compareTo;
                }
                if (!m491a() || (a13 = ir.a(this.f728a, iiVar.f728a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m493b()).compareTo(Boolean.valueOf(iiVar.m493b()));
                    if (compareTo2 != 0) {
                        return compareTo2;
                    }
                    if (!m493b() || (a12 = ir.a(this.f727a, iiVar.f727a)) == 0) {
                        int compareTo3 = Boolean.valueOf(m494c()).compareTo(Boolean.valueOf(iiVar.m494c()));
                        if (compareTo3 != 0) {
                            return compareTo3;
                        }
                        if (!m494c() || (a11 = ir.a(this.f732b, iiVar.f732b)) == 0) {
                            int compareTo4 = Boolean.valueOf(m495d()).compareTo(Boolean.valueOf(iiVar.m495d()));
                            if (compareTo4 != 0) {
                                return compareTo4;
                            }
                            if (!m495d() || (a10 = ir.a(this.f733c, iiVar.f733c)) == 0) {
                                int compareTo5 = Boolean.valueOf(m496e()).compareTo(Boolean.valueOf(iiVar.m496e()));
                                if (compareTo5 != 0) {
                                    return compareTo5;
                                }
                                if (!m496e() || (a9 = ir.a(this.f734d, iiVar.f734d)) == 0) {
                                    int compareTo6 = Boolean.valueOf(m497f()).compareTo(Boolean.valueOf(iiVar.m497f()));
                                    if (compareTo6 != 0) {
                                        return compareTo6;
                                    }
                                    if (!m497f() || (a8 = ir.a(this.f735e, iiVar.f735e)) == 0) {
                                        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(iiVar.g()));
                                        if (compareTo7 != 0) {
                                            return compareTo7;
                                        }
                                        if (!g() || (a7 = ir.a(this.f736f, iiVar.f736f)) == 0) {
                                            int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(iiVar.h()));
                                            if (compareTo8 != 0) {
                                                return compareTo8;
                                            }
                                            if (!h() || (a6 = ir.a(this.f726a, iiVar.f726a)) == 0) {
                                                int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(iiVar.i()));
                                                if (compareTo9 != 0) {
                                                    return compareTo9;
                                                }
                                                if (!i() || (a5 = ir.a(this.f731a, iiVar.f731a)) == 0) {
                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(iiVar.j()));
                                                    if (compareTo10 != 0) {
                                                        return compareTo10;
                                                    }
                                                    if (!j() || (a4 = ir.a(this.f730a, iiVar.f730a)) == 0) {
                                                        int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(iiVar.k()));
                                                        if (compareTo11 != 0) {
                                                            return compareTo11;
                                                        }
                                                        if (!k() || (a3 = ir.a(this.f737g, iiVar.f737g)) == 0) {
                                                            int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(iiVar.l()));
                                                            if (compareTo12 != 0) {
                                                                return compareTo12;
                                                            }
                                                            if (!l() || (a2 = ir.a(this.f738h, iiVar.f738h)) == 0) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f726a : (hr) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m489a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f732b : (String) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m490a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.f732b == null) {
                throw new jc("Required field 'id' was not present! Struct: " + toString());
            } else if (this.f733c != null) {
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
        jbVar.m527a();
        while (true) {
            iy m523a = jbVar.m523a();
            byte b2 = m523a.f77655a;
            if (b2 == 0) {
                jbVar.f();
                m490a();
                return;
            }
            switch (m523a.f814a) {
                case 1:
                    if (b2 == 11) {
                        this.f728a = jbVar.m528a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 2:
                    if (b2 == 12) {
                        hu huVar = new hu();
                        this.f727a = huVar;
                        huVar.a(jbVar);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f732b = jbVar.m528a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f733c = jbVar.m528a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 5:
                    if (b2 == 11) {
                        this.f734d = jbVar.m528a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 6:
                    if (b2 == 11) {
                        this.f735e = jbVar.m528a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f736f = jbVar.m528a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 8:
                    if (b2 == 12) {
                        hr hrVar = new hr();
                        this.f726a = hrVar;
                        hrVar.a(jbVar);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 9:
                    if (b2 == 2) {
                        this.f731a = jbVar.m532a();
                        a(true);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 10:
                    if (b2 == 13) {
                        ja m525a = jbVar.m525a();
                        this.f730a = new HashMap(m525a.f818a * 2);
                        for (int i2 = 0; i2 < m525a.f818a; i2++) {
                            this.f730a.put(jbVar.m528a(), jbVar.m528a());
                        }
                        jbVar.h();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 11:
                    if (b2 == 11) {
                        this.f737g = jbVar.m528a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 12:
                    if (b2 == 11) {
                        this.f738h = jbVar.m528a();
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
            this.f729a.set(0, z);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m491a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f728a != null : invokeV.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m492a(ii iiVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, iiVar)) == null) {
            if (iiVar == null) {
                return false;
            }
            boolean m491a = m491a();
            boolean m491a2 = iiVar.m491a();
            if ((m491a || m491a2) && !(m491a && m491a2 && this.f728a.equals(iiVar.f728a))) {
                return false;
            }
            boolean m493b = m493b();
            boolean m493b2 = iiVar.m493b();
            if ((m493b || m493b2) && !(m493b && m493b2 && this.f727a.m422a(iiVar.f727a))) {
                return false;
            }
            boolean m494c = m494c();
            boolean m494c2 = iiVar.m494c();
            if ((m494c || m494c2) && !(m494c && m494c2 && this.f732b.equals(iiVar.f732b))) {
                return false;
            }
            boolean m495d = m495d();
            boolean m495d2 = iiVar.m495d();
            if ((m495d || m495d2) && !(m495d && m495d2 && this.f733c.equals(iiVar.f733c))) {
                return false;
            }
            boolean m496e = m496e();
            boolean m496e2 = iiVar.m496e();
            if ((m496e || m496e2) && !(m496e && m496e2 && this.f734d.equals(iiVar.f734d))) {
                return false;
            }
            boolean m497f = m497f();
            boolean m497f2 = iiVar.m497f();
            if ((m497f || m497f2) && !(m497f && m497f2 && this.f735e.equals(iiVar.f735e))) {
                return false;
            }
            boolean g2 = g();
            boolean g3 = iiVar.g();
            if ((g2 || g3) && !(g2 && g3 && this.f736f.equals(iiVar.f736f))) {
                return false;
            }
            boolean h2 = h();
            boolean h3 = iiVar.h();
            if ((h2 || h3) && !(h2 && h3 && this.f726a.m405a(iiVar.f726a))) {
                return false;
            }
            boolean i2 = i();
            boolean i3 = iiVar.i();
            if ((i2 || i3) && !(i2 && i3 && this.f731a == iiVar.f731a)) {
                return false;
            }
            boolean j2 = j();
            boolean j3 = iiVar.j();
            if ((j2 || j3) && !(j2 && j3 && this.f730a.equals(iiVar.f730a))) {
                return false;
            }
            boolean k2 = k();
            boolean k3 = iiVar.k();
            if ((k2 || k3) && !(k2 && k3 && this.f737g.equals(iiVar.f737g))) {
                return false;
            }
            boolean l2 = l();
            boolean l3 = iiVar.l();
            if (l2 || l3) {
                return l2 && l3 && this.f738h.equals(iiVar.f738h);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f733c : (String) invokeV.objValue;
    }

    @Override // com.xiaomi.push.iq
    public void b(jb jbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, jbVar) == null) {
            m490a();
            jbVar.a(f725a);
            if (this.f728a != null && m491a()) {
                jbVar.a(f77579a);
                jbVar.a(this.f728a);
                jbVar.b();
            }
            if (this.f727a != null && m493b()) {
                jbVar.a(f77580b);
                this.f727a.b(jbVar);
                jbVar.b();
            }
            if (this.f732b != null) {
                jbVar.a(f77581c);
                jbVar.a(this.f732b);
                jbVar.b();
            }
            if (this.f733c != null) {
                jbVar.a(f77582d);
                jbVar.a(this.f733c);
                jbVar.b();
            }
            if (this.f734d != null && m496e()) {
                jbVar.a(f77583e);
                jbVar.a(this.f734d);
                jbVar.b();
            }
            if (this.f735e != null && m497f()) {
                jbVar.a(f77584f);
                jbVar.a(this.f735e);
                jbVar.b();
            }
            if (this.f736f != null && g()) {
                jbVar.a(f77585g);
                jbVar.a(this.f736f);
                jbVar.b();
            }
            if (this.f726a != null && h()) {
                jbVar.a(f77586h);
                this.f726a.b(jbVar);
                jbVar.b();
            }
            if (i()) {
                jbVar.a(f77587i);
                jbVar.a(this.f731a);
                jbVar.b();
            }
            if (this.f730a != null && j()) {
                jbVar.a(f77588j);
                jbVar.a(new ja((byte) 11, (byte) 11, this.f730a.size()));
                for (Map.Entry<String, String> entry : this.f730a.entrySet()) {
                    jbVar.a(entry.getKey());
                    jbVar.a(entry.getValue());
                }
                jbVar.d();
                jbVar.b();
            }
            if (this.f737g != null && k()) {
                jbVar.a(k);
                jbVar.a(this.f737g);
                jbVar.b();
            }
            if (this.f738h != null && l()) {
                jbVar.a(l);
                jbVar.a(this.f738h);
                jbVar.b();
            }
            jbVar.c();
            jbVar.m531a();
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m493b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f727a != null : invokeV.booleanValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f735e : (String) invokeV.objValue;
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m494c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f732b != null : invokeV.booleanValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f736f : (String) invokeV.objValue;
    }

    /* renamed from: d  reason: collision with other method in class */
    public boolean m495d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f733c != null : invokeV.booleanValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f737g : (String) invokeV.objValue;
    }

    /* renamed from: e  reason: collision with other method in class */
    public boolean m496e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.f734d != null : invokeV.booleanValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, obj)) == null) {
            if (obj != null && (obj instanceof ii)) {
                return m492a((ii) obj);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f738h : (String) invokeV.objValue;
    }

    /* renamed from: f  reason: collision with other method in class */
    public boolean m497f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f735e != null : invokeV.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.f736f != null : invokeV.booleanValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.f726a != null : invokeV.booleanValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.f729a.get(0) : invokeV.booleanValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.f730a != null : invokeV.booleanValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.f737g != null : invokeV.booleanValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.f738h != null : invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            StringBuilder sb = new StringBuilder("XmPushActionSendMessage(");
            boolean z2 = false;
            if (m491a()) {
                sb.append("debug:");
                String str = this.f728a;
                if (str == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str);
                }
                z = false;
            } else {
                z = true;
            }
            if (m493b()) {
                if (!z) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                }
                sb.append("target:");
                hu huVar = this.f727a;
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
            String str2 = this.f732b;
            if (str2 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str2);
            }
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("appId:");
            String str3 = this.f733c;
            if (str3 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str3);
            }
            if (m496e()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("packageName:");
                String str4 = this.f734d;
                if (str4 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str4);
                }
            }
            if (m497f()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append(UrlSchemaHelper.SCHEMA_TYPE_TOPIC);
                String str5 = this.f735e;
                if (str5 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str5);
                }
            }
            if (g()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("aliasName:");
                String str6 = this.f736f;
                if (str6 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str6);
                }
            }
            if (h()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("message:");
                hr hrVar = this.f726a;
                if (hrVar == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(hrVar);
                }
            }
            if (i()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("needAck:");
                sb.append(this.f731a);
            }
            if (j()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("params:");
                Map<String, String> map = this.f730a;
                if (map == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(map);
                }
            }
            if (k()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("category:");
                String str7 = this.f737g;
                if (str7 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str7);
                }
            }
            if (l()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("userAccount:");
                String str8 = this.f738h;
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
