package com.repackage;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.webkit.sdk.ZeusWebViewPreloadClass;
import com.facebook.common.internal.Sets;
import com.repackage.u82;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/* loaded from: classes7.dex */
public class v82 {
    public static /* synthetic */ Interceptable $ic;
    public static final Set<String> a;
    public static final Set<String> b;
    public static final Set<String> c;
    public static final Map<String, u82> d;
    public static boolean e;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755277375, "Lcom/repackage/v82;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755277375, "Lcom/repackage/v82;");
                return;
            }
        }
        a = Sets.newHashSet(ZeusWebViewPreloadClass.ZEUS_FILE_DIR);
        b = new HashSet(a);
        c = new HashSet(b);
        d = new HashMap();
        e = false;
    }

    public static u82 a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            c();
            return d.get(str);
        }
        return (u82) invokeL.objValue;
    }

    public static u82 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            u82.b bVar = new u82.b();
            bVar.d(ZeusWebViewPreloadClass.ZEUS_FILE_DIR);
            bVar.e(oi2.w0().a());
            bVar.b(oi2.w0().d());
            return bVar.a();
        }
        return (u82) invokeV.objValue;
    }

    public static void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            if (!e) {
                for (String str : c) {
                    if (ZeusWebViewPreloadClass.ZEUS_FILE_DIR.equals(str)) {
                        d.put(str, b());
                    }
                }
            }
            e = true;
        }
    }
}
