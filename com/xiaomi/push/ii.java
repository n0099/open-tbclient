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
import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes8.dex */
public class ii implements iq<ii, Object>, Serializable, Cloneable {
    public static /* synthetic */ Interceptable $ic;
    public static final iy a;

    /* renamed from: a  reason: collision with other field name */
    public static final jg f702a;
    public static final iy b;
    public static final iy c;
    public static final iy d;
    public static final iy e;
    public static final iy f;
    public static final iy g;
    public static final iy h;
    public static final iy i;
    public static final iy j;
    public static final iy k;
    public static final iy l;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public hr f703a;

    /* renamed from: a  reason: collision with other field name */
    public hu f704a;

    /* renamed from: a  reason: collision with other field name */
    public String f705a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f706a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f707a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f708a;

    /* renamed from: b  reason: collision with other field name */
    public String f709b;

    /* renamed from: c  reason: collision with other field name */
    public String f710c;

    /* renamed from: d  reason: collision with other field name */
    public String f711d;

    /* renamed from: e  reason: collision with other field name */
    public String f712e;

    /* renamed from: f  reason: collision with other field name */
    public String f713f;

    /* renamed from: g  reason: collision with other field name */
    public String f714g;

    /* renamed from: h  reason: collision with other field name */
    public String f715h;

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
        f702a = new jg("XmPushActionSendMessage");
        a = new iy("", Constants.GZIP_CAST_TYPE, (short) 1);
        b = new iy("", (byte) 12, (short) 2);
        c = new iy("", Constants.GZIP_CAST_TYPE, (short) 3);
        d = new iy("", Constants.GZIP_CAST_TYPE, (short) 4);
        e = new iy("", Constants.GZIP_CAST_TYPE, (short) 5);
        f = new iy("", Constants.GZIP_CAST_TYPE, (short) 6);
        g = new iy("", Constants.GZIP_CAST_TYPE, (short) 7);
        h = new iy("", (byte) 12, (short) 8);
        i = new iy("", (byte) 2, (short) 9);
        j = new iy("", (byte) 13, (short) 10);
        k = new iy("", Constants.GZIP_CAST_TYPE, (short) 11);
        l = new iy("", Constants.GZIP_CAST_TYPE, (short) 12);
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
        this.f706a = new BitSet(1);
        this.f708a = true;
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
                int compareTo = Boolean.valueOf(m526a()).compareTo(Boolean.valueOf(iiVar.m526a()));
                if (compareTo != 0) {
                    return compareTo;
                }
                if (!m526a() || (a13 = ir.a(this.f705a, iiVar.f705a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m528b()).compareTo(Boolean.valueOf(iiVar.m528b()));
                    if (compareTo2 != 0) {
                        return compareTo2;
                    }
                    if (!m528b() || (a12 = ir.a(this.f704a, iiVar.f704a)) == 0) {
                        int compareTo3 = Boolean.valueOf(m529c()).compareTo(Boolean.valueOf(iiVar.m529c()));
                        if (compareTo3 != 0) {
                            return compareTo3;
                        }
                        if (!m529c() || (a11 = ir.a(this.f709b, iiVar.f709b)) == 0) {
                            int compareTo4 = Boolean.valueOf(m530d()).compareTo(Boolean.valueOf(iiVar.m530d()));
                            if (compareTo4 != 0) {
                                return compareTo4;
                            }
                            if (!m530d() || (a10 = ir.a(this.f710c, iiVar.f710c)) == 0) {
                                int compareTo5 = Boolean.valueOf(m531e()).compareTo(Boolean.valueOf(iiVar.m531e()));
                                if (compareTo5 != 0) {
                                    return compareTo5;
                                }
                                if (!m531e() || (a9 = ir.a(this.f711d, iiVar.f711d)) == 0) {
                                    int compareTo6 = Boolean.valueOf(m532f()).compareTo(Boolean.valueOf(iiVar.m532f()));
                                    if (compareTo6 != 0) {
                                        return compareTo6;
                                    }
                                    if (!m532f() || (a8 = ir.a(this.f712e, iiVar.f712e)) == 0) {
                                        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(iiVar.g()));
                                        if (compareTo7 != 0) {
                                            return compareTo7;
                                        }
                                        if (!g() || (a7 = ir.a(this.f713f, iiVar.f713f)) == 0) {
                                            int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(iiVar.h()));
                                            if (compareTo8 != 0) {
                                                return compareTo8;
                                            }
                                            if (!h() || (a6 = ir.a(this.f703a, iiVar.f703a)) == 0) {
                                                int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(iiVar.i()));
                                                if (compareTo9 != 0) {
                                                    return compareTo9;
                                                }
                                                if (!i() || (a5 = ir.a(this.f708a, iiVar.f708a)) == 0) {
                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(iiVar.j()));
                                                    if (compareTo10 != 0) {
                                                        return compareTo10;
                                                    }
                                                    if (!j() || (a4 = ir.a(this.f707a, iiVar.f707a)) == 0) {
                                                        int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(iiVar.k()));
                                                        if (compareTo11 != 0) {
                                                            return compareTo11;
                                                        }
                                                        if (!k() || (a3 = ir.a(this.f714g, iiVar.f714g)) == 0) {
                                                            int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(iiVar.l()));
                                                            if (compareTo12 != 0) {
                                                                return compareTo12;
                                                            }
                                                            if (!l() || (a2 = ir.a(this.f715h, iiVar.f715h)) == 0) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f703a : (hr) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m524a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f709b : (String) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m525a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.f709b == null) {
                throw new jc("Required field 'id' was not present! Struct: " + toString());
            } else if (this.f710c != null) {
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
        jbVar.m562a();
        while (true) {
            iy m558a = jbVar.m558a();
            byte b2 = m558a.a;
            if (b2 == 0) {
                jbVar.f();
                m525a();
                return;
            }
            switch (m558a.f791a) {
                case 1:
                    if (b2 == 11) {
                        this.f705a = jbVar.m563a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 2:
                    if (b2 == 12) {
                        hu huVar = new hu();
                        this.f704a = huVar;
                        huVar.a(jbVar);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f709b = jbVar.m563a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f710c = jbVar.m563a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 5:
                    if (b2 == 11) {
                        this.f711d = jbVar.m563a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 6:
                    if (b2 == 11) {
                        this.f712e = jbVar.m563a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f713f = jbVar.m563a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 8:
                    if (b2 == 12) {
                        hr hrVar = new hr();
                        this.f703a = hrVar;
                        hrVar.a(jbVar);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 9:
                    if (b2 == 2) {
                        this.f708a = jbVar.m567a();
                        a(true);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 10:
                    if (b2 == 13) {
                        ja m560a = jbVar.m560a();
                        this.f707a = new HashMap(m560a.f795a * 2);
                        for (int i2 = 0; i2 < m560a.f795a; i2++) {
                            this.f707a.put(jbVar.m563a(), jbVar.m563a());
                        }
                        jbVar.h();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 11:
                    if (b2 == 11) {
                        this.f714g = jbVar.m563a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 12:
                    if (b2 == 11) {
                        this.f715h = jbVar.m563a();
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
            this.f706a.set(0, z);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m526a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f705a != null : invokeV.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m527a(ii iiVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, iiVar)) == null) {
            if (iiVar == null) {
                return false;
            }
            boolean m526a = m526a();
            boolean m526a2 = iiVar.m526a();
            if ((m526a || m526a2) && !(m526a && m526a2 && this.f705a.equals(iiVar.f705a))) {
                return false;
            }
            boolean m528b = m528b();
            boolean m528b2 = iiVar.m528b();
            if ((m528b || m528b2) && !(m528b && m528b2 && this.f704a.m457a(iiVar.f704a))) {
                return false;
            }
            boolean m529c = m529c();
            boolean m529c2 = iiVar.m529c();
            if ((m529c || m529c2) && !(m529c && m529c2 && this.f709b.equals(iiVar.f709b))) {
                return false;
            }
            boolean m530d = m530d();
            boolean m530d2 = iiVar.m530d();
            if ((m530d || m530d2) && !(m530d && m530d2 && this.f710c.equals(iiVar.f710c))) {
                return false;
            }
            boolean m531e = m531e();
            boolean m531e2 = iiVar.m531e();
            if ((m531e || m531e2) && !(m531e && m531e2 && this.f711d.equals(iiVar.f711d))) {
                return false;
            }
            boolean m532f = m532f();
            boolean m532f2 = iiVar.m532f();
            if ((m532f || m532f2) && !(m532f && m532f2 && this.f712e.equals(iiVar.f712e))) {
                return false;
            }
            boolean g2 = g();
            boolean g3 = iiVar.g();
            if ((g2 || g3) && !(g2 && g3 && this.f713f.equals(iiVar.f713f))) {
                return false;
            }
            boolean h2 = h();
            boolean h3 = iiVar.h();
            if ((h2 || h3) && !(h2 && h3 && this.f703a.m440a(iiVar.f703a))) {
                return false;
            }
            boolean i2 = i();
            boolean i3 = iiVar.i();
            if ((i2 || i3) && !(i2 && i3 && this.f708a == iiVar.f708a)) {
                return false;
            }
            boolean j2 = j();
            boolean j3 = iiVar.j();
            if ((j2 || j3) && !(j2 && j3 && this.f707a.equals(iiVar.f707a))) {
                return false;
            }
            boolean k2 = k();
            boolean k3 = iiVar.k();
            if ((k2 || k3) && !(k2 && k3 && this.f714g.equals(iiVar.f714g))) {
                return false;
            }
            boolean l2 = l();
            boolean l3 = iiVar.l();
            if (l2 || l3) {
                return l2 && l3 && this.f715h.equals(iiVar.f715h);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f710c : (String) invokeV.objValue;
    }

    @Override // com.xiaomi.push.iq
    public void b(jb jbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, jbVar) == null) {
            m525a();
            jbVar.a(f702a);
            if (this.f705a != null && m526a()) {
                jbVar.a(a);
                jbVar.a(this.f705a);
                jbVar.b();
            }
            if (this.f704a != null && m528b()) {
                jbVar.a(b);
                this.f704a.b(jbVar);
                jbVar.b();
            }
            if (this.f709b != null) {
                jbVar.a(c);
                jbVar.a(this.f709b);
                jbVar.b();
            }
            if (this.f710c != null) {
                jbVar.a(d);
                jbVar.a(this.f710c);
                jbVar.b();
            }
            if (this.f711d != null && m531e()) {
                jbVar.a(e);
                jbVar.a(this.f711d);
                jbVar.b();
            }
            if (this.f712e != null && m532f()) {
                jbVar.a(f);
                jbVar.a(this.f712e);
                jbVar.b();
            }
            if (this.f713f != null && g()) {
                jbVar.a(g);
                jbVar.a(this.f713f);
                jbVar.b();
            }
            if (this.f703a != null && h()) {
                jbVar.a(h);
                this.f703a.b(jbVar);
                jbVar.b();
            }
            if (i()) {
                jbVar.a(i);
                jbVar.a(this.f708a);
                jbVar.b();
            }
            if (this.f707a != null && j()) {
                jbVar.a(j);
                jbVar.a(new ja(Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, this.f707a.size()));
                for (Map.Entry<String, String> entry : this.f707a.entrySet()) {
                    jbVar.a(entry.getKey());
                    jbVar.a(entry.getValue());
                }
                jbVar.d();
                jbVar.b();
            }
            if (this.f714g != null && k()) {
                jbVar.a(k);
                jbVar.a(this.f714g);
                jbVar.b();
            }
            if (this.f715h != null && l()) {
                jbVar.a(l);
                jbVar.a(this.f715h);
                jbVar.b();
            }
            jbVar.c();
            jbVar.m566a();
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m528b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f704a != null : invokeV.booleanValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f712e : (String) invokeV.objValue;
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m529c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f709b != null : invokeV.booleanValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f713f : (String) invokeV.objValue;
    }

    /* renamed from: d  reason: collision with other method in class */
    public boolean m530d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f710c != null : invokeV.booleanValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f714g : (String) invokeV.objValue;
    }

    /* renamed from: e  reason: collision with other method in class */
    public boolean m531e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.f711d != null : invokeV.booleanValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, obj)) == null) {
            if (obj != null && (obj instanceof ii)) {
                return m527a((ii) obj);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f715h : (String) invokeV.objValue;
    }

    /* renamed from: f  reason: collision with other method in class */
    public boolean m532f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f712e != null : invokeV.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.f713f != null : invokeV.booleanValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.f703a != null : invokeV.booleanValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.f706a.get(0) : invokeV.booleanValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.f707a != null : invokeV.booleanValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.f714g != null : invokeV.booleanValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.f715h != null : invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            StringBuilder sb = new StringBuilder("XmPushActionSendMessage(");
            boolean z2 = false;
            if (m526a()) {
                sb.append("debug:");
                String str = this.f705a;
                if (str == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str);
                }
                z = false;
            } else {
                z = true;
            }
            if (m528b()) {
                if (!z) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                }
                sb.append("target:");
                hu huVar = this.f704a;
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
            String str2 = this.f709b;
            if (str2 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str2);
            }
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("appId:");
            String str3 = this.f710c;
            if (str3 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str3);
            }
            if (m531e()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("packageName:");
                String str4 = this.f711d;
                if (str4 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str4);
                }
            }
            if (m532f()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append(UrlSchemaHelper.SCHEMA_TYPE_TOPIC);
                String str5 = this.f712e;
                if (str5 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str5);
                }
            }
            if (g()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("aliasName:");
                String str6 = this.f713f;
                if (str6 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str6);
                }
            }
            if (h()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("message:");
                hr hrVar = this.f703a;
                if (hrVar == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(hrVar);
                }
            }
            if (i()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("needAck:");
                sb.append(this.f708a);
            }
            if (j()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("params:");
                Map<String, String> map = this.f707a;
                if (map == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(map);
                }
            }
            if (k()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("category:");
                String str7 = this.f714g;
                if (str7 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str7);
                }
            }
            if (l()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("userAccount:");
                String str8 = this.f715h;
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
