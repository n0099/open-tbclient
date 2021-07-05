package com.ksad.lottie;

import android.util.Log;
import androidx.annotation.RestrictTo;
import androidx.core.os.TraceCompat;
import com.airbnb.lottie.L;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashSet;
import java.util.Set;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes7.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static boolean f33717a;

    /* renamed from: b  reason: collision with root package name */
    public static final Set<String> f33718b;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f33719c;

    /* renamed from: d  reason: collision with root package name */
    public static String[] f33720d;

    /* renamed from: e  reason: collision with root package name */
    public static long[] f33721e;

    /* renamed from: f  reason: collision with root package name */
    public static int f33722f;

    /* renamed from: g  reason: collision with root package name */
    public static int f33723g;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1819785918, "Lcom/ksad/lottie/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1819785918, "Lcom/ksad/lottie/c;");
                return;
            }
        }
        f33718b = new HashSet();
        f33719c = false;
        f33722f = 0;
        f33723g = 0;
    }

    public static void a(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, str) == null) && f33717a) {
            Log.d(L.TAG, str);
        }
    }

    public static void b(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, str) == null) || f33718b.contains(str)) {
            return;
        }
        Log.w(L.TAG, str);
        f33718b.add(str);
    }

    public static void c(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65539, null, str) == null) && f33719c) {
            int i2 = f33722f;
            if (i2 == 20) {
                f33723g++;
                return;
            }
            f33720d[i2] = str;
            f33721e[i2] = System.nanoTime();
            TraceCompat.beginSection(str);
            f33722f++;
        }
    }

    public static float d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65540, null, str)) == null) {
            int i2 = f33723g;
            if (i2 > 0) {
                f33723g = i2 - 1;
                return 0.0f;
            } else if (f33719c) {
                int i3 = f33722f - 1;
                f33722f = i3;
                if (i3 != -1) {
                    if (str.equals(f33720d[i3])) {
                        TraceCompat.endSection();
                        return ((float) (System.nanoTime() - f33721e[f33722f])) / 1000000.0f;
                    }
                    throw new IllegalStateException("Unbalanced trace call " + str + ". Expected " + f33720d[f33722f] + ".");
                }
                throw new IllegalStateException("Can't end trace section. There are none.");
            } else {
                return 0.0f;
            }
        }
        return invokeL.floatValue;
    }
}
