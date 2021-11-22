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
/* loaded from: classes2.dex */
public class ii implements iq<ii, Object>, Serializable, Cloneable {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final iy f72174a;

    /* renamed from: a  reason: collision with other field name */
    public static final jg f726a;

    /* renamed from: b  reason: collision with root package name */
    public static final iy f72175b;

    /* renamed from: c  reason: collision with root package name */
    public static final iy f72176c;

    /* renamed from: d  reason: collision with root package name */
    public static final iy f72177d;

    /* renamed from: e  reason: collision with root package name */
    public static final iy f72178e;

    /* renamed from: f  reason: collision with root package name */
    public static final iy f72179f;

    /* renamed from: g  reason: collision with root package name */
    public static final iy f72180g;

    /* renamed from: h  reason: collision with root package name */
    public static final iy f72181h;

    /* renamed from: i  reason: collision with root package name */
    public static final iy f72182i;
    public static final iy j;
    public static final iy k;
    public static final iy l;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public hr f727a;

    /* renamed from: a  reason: collision with other field name */
    public hu f728a;

    /* renamed from: a  reason: collision with other field name */
    public String f729a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f730a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f731a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f732a;

    /* renamed from: b  reason: collision with other field name */
    public String f733b;

    /* renamed from: c  reason: collision with other field name */
    public String f734c;

    /* renamed from: d  reason: collision with other field name */
    public String f735d;

    /* renamed from: e  reason: collision with other field name */
    public String f736e;

    /* renamed from: f  reason: collision with other field name */
    public String f737f;

    /* renamed from: g  reason: collision with other field name */
    public String f738g;

    /* renamed from: h  reason: collision with other field name */
    public String f739h;

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
        f726a = new jg("XmPushActionSendMessage");
        f72174a = new iy("", (byte) 11, (short) 1);
        f72175b = new iy("", StandardMessageCodec.LIST, (short) 2);
        f72176c = new iy("", (byte) 11, (short) 3);
        f72177d = new iy("", (byte) 11, (short) 4);
        f72178e = new iy("", (byte) 11, (short) 5);
        f72179f = new iy("", (byte) 11, (short) 6);
        f72180g = new iy("", (byte) 11, (short) 7);
        f72181h = new iy("", StandardMessageCodec.LIST, (short) 8);
        f72182i = new iy("", (byte) 2, (short) 9);
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
        this.f730a = new BitSet(1);
        this.f732a = true;
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
                if (!m491a() || (a13 = ir.a(this.f729a, iiVar.f729a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m493b()).compareTo(Boolean.valueOf(iiVar.m493b()));
                    if (compareTo2 != 0) {
                        return compareTo2;
                    }
                    if (!m493b() || (a12 = ir.a(this.f728a, iiVar.f728a)) == 0) {
                        int compareTo3 = Boolean.valueOf(m494c()).compareTo(Boolean.valueOf(iiVar.m494c()));
                        if (compareTo3 != 0) {
                            return compareTo3;
                        }
                        if (!m494c() || (a11 = ir.a(this.f733b, iiVar.f733b)) == 0) {
                            int compareTo4 = Boolean.valueOf(m495d()).compareTo(Boolean.valueOf(iiVar.m495d()));
                            if (compareTo4 != 0) {
                                return compareTo4;
                            }
                            if (!m495d() || (a10 = ir.a(this.f734c, iiVar.f734c)) == 0) {
                                int compareTo5 = Boolean.valueOf(m496e()).compareTo(Boolean.valueOf(iiVar.m496e()));
                                if (compareTo5 != 0) {
                                    return compareTo5;
                                }
                                if (!m496e() || (a9 = ir.a(this.f735d, iiVar.f735d)) == 0) {
                                    int compareTo6 = Boolean.valueOf(m497f()).compareTo(Boolean.valueOf(iiVar.m497f()));
                                    if (compareTo6 != 0) {
                                        return compareTo6;
                                    }
                                    if (!m497f() || (a8 = ir.a(this.f736e, iiVar.f736e)) == 0) {
                                        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(iiVar.g()));
                                        if (compareTo7 != 0) {
                                            return compareTo7;
                                        }
                                        if (!g() || (a7 = ir.a(this.f737f, iiVar.f737f)) == 0) {
                                            int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(iiVar.h()));
                                            if (compareTo8 != 0) {
                                                return compareTo8;
                                            }
                                            if (!h() || (a6 = ir.a(this.f727a, iiVar.f727a)) == 0) {
                                                int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(iiVar.i()));
                                                if (compareTo9 != 0) {
                                                    return compareTo9;
                                                }
                                                if (!i() || (a5 = ir.a(this.f732a, iiVar.f732a)) == 0) {
                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(iiVar.j()));
                                                    if (compareTo10 != 0) {
                                                        return compareTo10;
                                                    }
                                                    if (!j() || (a4 = ir.a(this.f731a, iiVar.f731a)) == 0) {
                                                        int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(iiVar.k()));
                                                        if (compareTo11 != 0) {
                                                            return compareTo11;
                                                        }
                                                        if (!k() || (a3 = ir.a(this.f738g, iiVar.f738g)) == 0) {
                                                            int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(iiVar.l()));
                                                            if (compareTo12 != 0) {
                                                                return compareTo12;
                                                            }
                                                            if (!l() || (a2 = ir.a(this.f739h, iiVar.f739h)) == 0) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f727a : (hr) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m489a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f733b : (String) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m490a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.f733b == null) {
                throw new jc("Required field 'id' was not present! Struct: " + toString());
            } else if (this.f734c != null) {
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
            byte b2 = m523a.f72248a;
            if (b2 == 0) {
                jbVar.f();
                m490a();
                return;
            }
            switch (m523a.f815a) {
                case 1:
                    if (b2 == 11) {
                        this.f729a = jbVar.m528a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 2:
                    if (b2 == 12) {
                        hu huVar = new hu();
                        this.f728a = huVar;
                        huVar.a(jbVar);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f733b = jbVar.m528a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f734c = jbVar.m528a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 5:
                    if (b2 == 11) {
                        this.f735d = jbVar.m528a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 6:
                    if (b2 == 11) {
                        this.f736e = jbVar.m528a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f737f = jbVar.m528a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 8:
                    if (b2 == 12) {
                        hr hrVar = new hr();
                        this.f727a = hrVar;
                        hrVar.a(jbVar);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 9:
                    if (b2 == 2) {
                        this.f732a = jbVar.m532a();
                        a(true);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 10:
                    if (b2 == 13) {
                        ja m525a = jbVar.m525a();
                        this.f731a = new HashMap(m525a.f819a * 2);
                        for (int i2 = 0; i2 < m525a.f819a; i2++) {
                            this.f731a.put(jbVar.m528a(), jbVar.m528a());
                        }
                        jbVar.h();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 11:
                    if (b2 == 11) {
                        this.f738g = jbVar.m528a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 12:
                    if (b2 == 11) {
                        this.f739h = jbVar.m528a();
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
            this.f730a.set(0, z);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m491a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f729a != null : invokeV.booleanValue;
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
            if ((m491a || m491a2) && !(m491a && m491a2 && this.f729a.equals(iiVar.f729a))) {
                return false;
            }
            boolean m493b = m493b();
            boolean m493b2 = iiVar.m493b();
            if ((m493b || m493b2) && !(m493b && m493b2 && this.f728a.m422a(iiVar.f728a))) {
                return false;
            }
            boolean m494c = m494c();
            boolean m494c2 = iiVar.m494c();
            if ((m494c || m494c2) && !(m494c && m494c2 && this.f733b.equals(iiVar.f733b))) {
                return false;
            }
            boolean m495d = m495d();
            boolean m495d2 = iiVar.m495d();
            if ((m495d || m495d2) && !(m495d && m495d2 && this.f734c.equals(iiVar.f734c))) {
                return false;
            }
            boolean m496e = m496e();
            boolean m496e2 = iiVar.m496e();
            if ((m496e || m496e2) && !(m496e && m496e2 && this.f735d.equals(iiVar.f735d))) {
                return false;
            }
            boolean m497f = m497f();
            boolean m497f2 = iiVar.m497f();
            if ((m497f || m497f2) && !(m497f && m497f2 && this.f736e.equals(iiVar.f736e))) {
                return false;
            }
            boolean g2 = g();
            boolean g3 = iiVar.g();
            if ((g2 || g3) && !(g2 && g3 && this.f737f.equals(iiVar.f737f))) {
                return false;
            }
            boolean h2 = h();
            boolean h3 = iiVar.h();
            if ((h2 || h3) && !(h2 && h3 && this.f727a.m405a(iiVar.f727a))) {
                return false;
            }
            boolean i2 = i();
            boolean i3 = iiVar.i();
            if ((i2 || i3) && !(i2 && i3 && this.f732a == iiVar.f732a)) {
                return false;
            }
            boolean j2 = j();
            boolean j3 = iiVar.j();
            if ((j2 || j3) && !(j2 && j3 && this.f731a.equals(iiVar.f731a))) {
                return false;
            }
            boolean k2 = k();
            boolean k3 = iiVar.k();
            if ((k2 || k3) && !(k2 && k3 && this.f738g.equals(iiVar.f738g))) {
                return false;
            }
            boolean l2 = l();
            boolean l3 = iiVar.l();
            if (l2 || l3) {
                return l2 && l3 && this.f739h.equals(iiVar.f739h);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f734c : (String) invokeV.objValue;
    }

    @Override // com.xiaomi.push.iq
    public void b(jb jbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, jbVar) == null) {
            m490a();
            jbVar.a(f726a);
            if (this.f729a != null && m491a()) {
                jbVar.a(f72174a);
                jbVar.a(this.f729a);
                jbVar.b();
            }
            if (this.f728a != null && m493b()) {
                jbVar.a(f72175b);
                this.f728a.b(jbVar);
                jbVar.b();
            }
            if (this.f733b != null) {
                jbVar.a(f72176c);
                jbVar.a(this.f733b);
                jbVar.b();
            }
            if (this.f734c != null) {
                jbVar.a(f72177d);
                jbVar.a(this.f734c);
                jbVar.b();
            }
            if (this.f735d != null && m496e()) {
                jbVar.a(f72178e);
                jbVar.a(this.f735d);
                jbVar.b();
            }
            if (this.f736e != null && m497f()) {
                jbVar.a(f72179f);
                jbVar.a(this.f736e);
                jbVar.b();
            }
            if (this.f737f != null && g()) {
                jbVar.a(f72180g);
                jbVar.a(this.f737f);
                jbVar.b();
            }
            if (this.f727a != null && h()) {
                jbVar.a(f72181h);
                this.f727a.b(jbVar);
                jbVar.b();
            }
            if (i()) {
                jbVar.a(f72182i);
                jbVar.a(this.f732a);
                jbVar.b();
            }
            if (this.f731a != null && j()) {
                jbVar.a(j);
                jbVar.a(new ja((byte) 11, (byte) 11, this.f731a.size()));
                for (Map.Entry<String, String> entry : this.f731a.entrySet()) {
                    jbVar.a(entry.getKey());
                    jbVar.a(entry.getValue());
                }
                jbVar.d();
                jbVar.b();
            }
            if (this.f738g != null && k()) {
                jbVar.a(k);
                jbVar.a(this.f738g);
                jbVar.b();
            }
            if (this.f739h != null && l()) {
                jbVar.a(l);
                jbVar.a(this.f739h);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f728a != null : invokeV.booleanValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f736e : (String) invokeV.objValue;
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m494c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f733b != null : invokeV.booleanValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f737f : (String) invokeV.objValue;
    }

    /* renamed from: d  reason: collision with other method in class */
    public boolean m495d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f734c != null : invokeV.booleanValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f738g : (String) invokeV.objValue;
    }

    /* renamed from: e  reason: collision with other method in class */
    public boolean m496e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.f735d != null : invokeV.booleanValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f739h : (String) invokeV.objValue;
    }

    /* renamed from: f  reason: collision with other method in class */
    public boolean m497f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f736e != null : invokeV.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.f737f != null : invokeV.booleanValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.f727a != null : invokeV.booleanValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.f730a.get(0) : invokeV.booleanValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.f731a != null : invokeV.booleanValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.f738g != null : invokeV.booleanValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.f739h != null : invokeV.booleanValue;
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
                String str = this.f729a;
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
                hu huVar = this.f728a;
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
            String str2 = this.f733b;
            if (str2 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str2);
            }
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("appId:");
            String str3 = this.f734c;
            if (str3 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str3);
            }
            if (m496e()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("packageName:");
                String str4 = this.f735d;
                if (str4 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str4);
                }
            }
            if (m497f()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append(UrlSchemaHelper.SCHEMA_TYPE_TOPIC);
                String str5 = this.f736e;
                if (str5 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str5);
                }
            }
            if (g()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("aliasName:");
                String str6 = this.f737f;
                if (str6 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str6);
                }
            }
            if (h()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("message:");
                hr hrVar = this.f727a;
                if (hrVar == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(hrVar);
                }
            }
            if (i()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("needAck:");
                sb.append(this.f732a);
            }
            if (j()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("params:");
                Map<String, String> map = this.f731a;
                if (map == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(map);
                }
            }
            if (k()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("category:");
                String str7 = this.f738g;
                if (str7 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str7);
                }
            }
            if (l()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("userAccount:");
                String str8 = this.f739h;
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
