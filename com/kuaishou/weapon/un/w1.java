package com.kuaishou.weapon.un;

import android.content.Context;
import android.location.Location;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.InetAddress;
/* loaded from: classes4.dex */
public class w1 {
    public static /* synthetic */ Interceptable $ic = null;
    public static int a = -1;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(535007190, "Lcom/kuaishou/weapon/un/w1;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(535007190, "Lcom/kuaishou/weapon/un/w1;");
        }
    }

    public w1() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static Location a(Context context, Location location) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, location)) == null) {
            if (f(context) != 0 || v.a(context).a(64) || location == null) {
                return null;
            }
            return location;
        }
        return (Location) invokeLL.objValue;
    }

    public static String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            try {
                return v.a(context).a(512) ? w0.c(context) : y0.f55525f;
            } catch (Throwable th) {
                x0.a(th);
                return y0.f55523d;
            }
        }
        return (String) invokeL.objValue;
    }

    public static String a(Context context, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, context, i2)) == null) {
            try {
                v a2 = v.a(context);
                String a3 = a(a2, 128);
                String str = i2 == 1 ? u.f55479i : i2 == 2 ? u.f55480j : u.f55478h;
                String a4 = a2.a(str, a3);
                if (TextUtils.isEmpty(a4)) {
                    String c2 = x0.c(context, i2);
                    a2.b(str, c2);
                    return c2;
                }
                return a4;
            } catch (Throwable th) {
                x0.a(th);
                return y0.f55523d;
            }
        }
        return (String) invokeLI.objValue;
    }

    public static String a(Context context, int i2, String str) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65541, null, context, i2, str)) == null) {
            try {
                v a2 = v.a(context);
                String a3 = a(a2, 1);
                String str2 = i2 == 0 ? u.f55473c : i2 == 1 ? u.f55474d : u.f55472b;
                String a4 = a2.a(str2, a3);
                if (f(context) == 0 && !v.a(context).a(1) && !TextUtils.isEmpty(str)) {
                    if (TextUtils.isEmpty(a4) || y0.f55525f.equals(a4)) {
                        a2.b(str2, str);
                    }
                    return str;
                } else if (TextUtils.isEmpty(a4)) {
                    String g2 = x0.g(context, i2);
                    a2.b(str2, g2);
                    return g2;
                } else {
                    return a4;
                }
            } catch (Throwable th) {
                x0.a(th);
                return y0.f55523d;
            }
        }
        return (String) invokeLIL.objValue;
    }

    public static String a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, context, str)) == null) {
            try {
                v a2 = v.a(context);
                String a3 = a2.a(u.l, a(a2, 2));
                if (f(context) == 0 && !v.a(context).a(2) && !TextUtils.isEmpty(str)) {
                    if (TextUtils.isEmpty(a3) || y0.f55525f.equals(a3)) {
                        a2.b(u.l, str);
                    }
                    return str;
                } else if (TextUtils.isEmpty(a3)) {
                    String c2 = x0.c(context);
                    a2.b(u.l, c2);
                    return c2;
                } else {
                    return a3;
                }
            } catch (Throwable th) {
                x0.a(th);
                return y0.f55523d;
            }
        }
        return (String) invokeLL.objValue;
    }

    public static String a(v vVar, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65543, null, vVar, i2)) == null) ? vVar.a(i2) ? "" : y0.f55525f : (String) invokeLI.objValue;
    }

    public static InetAddress a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            try {
                v a2 = v.a();
                if (a2 != null && a2.a(8)) {
                    return x0.c();
                }
                return null;
            } catch (Throwable th) {
                x0.a(th);
                return null;
            }
        }
        return (InetAddress) invokeV.objValue;
    }

    public static int b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, context)) == null) {
            try {
                if (v.a(context).a(512)) {
                    return w0.e(context);
                }
                return -4;
            } catch (Throwable th) {
                x0.a(th);
                return -2;
            }
        }
        return invokeL.intValue;
    }

    public static String b(Context context, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65546, null, context, i2)) == null) {
            try {
                v a2 = v.a(context);
                String a3 = a(a2, 128);
                String str = i2 == 1 ? u.f55476f : i2 == 2 ? u.f55477g : u.f55475e;
                String a4 = a2.a(str, a3);
                if (TextUtils.isEmpty(a4)) {
                    String h2 = x0.h(context, i2);
                    a2.b(str, h2);
                    return h2;
                }
                return a4;
            } catch (Throwable th) {
                x0.a(th);
                return y0.f55523d;
            }
        }
        return (String) invokeLI.objValue;
    }

    public static String b(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65547, null, context, str)) == null) {
            try {
                v a2 = v.a(context);
                String a3 = a2.a(u.f55472b, a(a2, 1));
                if (f(context) == 0 && !v.a(context).a(1) && !TextUtils.isEmpty(str)) {
                    if (TextUtils.isEmpty(a3) || y0.f55525f.equals(a3)) {
                        a2.b(u.f55472b, str);
                    }
                    return str;
                } else if (TextUtils.isEmpty(a3)) {
                    String n = x0.n(context);
                    a2.b(u.f55472b, n);
                    return n;
                } else {
                    return a3;
                }
            } catch (Throwable th) {
                x0.a(th);
                return y0.f55523d;
            }
        }
        return (String) invokeLL.objValue;
    }

    public static String c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, context)) == null) {
            try {
                return v.a(context).a(512) ? w0.f(context) : y0.f55525f;
            } catch (Throwable th) {
                x0.a(th);
                return y0.f55523d;
            }
        }
        return (String) invokeL.objValue;
    }

    public static String c(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65549, null, context, str)) == null) {
            try {
                v a2 = v.a(context);
                String a3 = a2.a(u.k, a(a2, 4));
                if (f(context) == 0 && !v.a(context).a(4) && !TextUtils.isEmpty(str)) {
                    if (TextUtils.isEmpty(a3) || y0.f55525f.equals(a3)) {
                        a2.b(u.k, str);
                    }
                    return str;
                } else if (TextUtils.isEmpty(a3)) {
                    String d2 = x0.d();
                    a2.b(u.k, d2);
                    return d2;
                } else {
                    return a3;
                }
            } catch (Throwable th) {
                x0.a(th);
                return y0.f55523d;
            }
        }
        return (String) invokeLL.objValue;
    }

    public static String d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, context)) == null) {
            try {
                v a2 = v.a(context);
                String a3 = a2.a(u.f55478h, a(a2, 128));
                if (TextUtils.isEmpty(a3)) {
                    String m = x0.m(context);
                    a2.b(u.f55478h, m);
                    return m;
                }
                return a3;
            } catch (Throwable th) {
                x0.a(th);
                return y0.f55523d;
            }
        }
        return (String) invokeL.objValue;
    }

    public static String e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, context)) == null) {
            try {
                v a2 = v.a(context);
                String a3 = a2.a(u.f55475e, a(a2, 128));
                if (TextUtils.isEmpty(a3)) {
                    String p = x0.p(context);
                    a2.b(u.f55475e, p);
                    return p;
                }
                return a3;
            } catch (Throwable th) {
                x0.a(th);
                return y0.f55523d;
            }
        }
        return (String) invokeL.objValue;
    }

    public static int f(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, context)) == null) {
            if (a == -1) {
                a = new d(r1.p, context).b(d.f1, 0);
            }
            return a;
        }
        return invokeL.intValue;
    }
}
