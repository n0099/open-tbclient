package com.kwad.sdk.contentalliance.detail.photo.comment;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes7.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static Set<String> f34676a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-399007927, "Lcom/kwad/sdk/contentalliance/detail/photo/comment/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-399007927, "Lcom/kwad/sdk/contentalliance/detail/photo/comment/c;");
                return;
            }
        }
        f34676a = new HashSet();
    }

    public static void a(long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
            f34676a.add(d(j, j2));
        }
    }

    public static void b(long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
            f34676a.remove(d(j, j2));
        }
    }

    public static boolean c(long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{Long.valueOf(j), Long.valueOf(j2)})) == null) ? f34676a.contains(d(j, j2)) : invokeCommon.booleanValue;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r4v0 long), (r6v0 long)] */
    public static String d(long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65540, null, new Object[]{Long.valueOf(j), Long.valueOf(j2)})) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(j);
            sb.append(j2);
            return sb.toString();
        }
        return (String) invokeCommon.objValue;
    }
}
