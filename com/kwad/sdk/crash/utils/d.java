package com.kwad.sdk.crash.utils;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.WorkerThread;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes2.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static Context f65497a;
    public transient /* synthetic */ FieldHolder $fh;

    @WorkerThread
    public static long a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            long b2 = b(f65497a);
            a(f65497a, 1 + b2);
            return b2;
        }
        return invokeV.longValue;
    }

    public static void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, context) == null) {
            f65497a = context;
        }
    }

    @WorkerThread
    public static boolean a(Context context, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65538, null, context, j)) == null) {
            if (context != null) {
                SharedPreferences.Editor edit = context.getSharedPreferences("ksadsdk_crashseq", 0).edit();
                edit.putLong("crashseq", j);
                return edit.commit();
            }
            return false;
        }
        return invokeLJ.booleanValue;
    }

    @WorkerThread
    public static long b(Context context) {
        InterceptResult invokeL;
        SharedPreferences sharedPreferences;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            if (context == null || (sharedPreferences = context.getSharedPreferences("ksadsdk_crashseq", 0)) == null) {
                return 0L;
            }
            return sharedPreferences.getLong("crashseq", 1L);
        }
        return invokeL.longValue;
    }
}
