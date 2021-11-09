package com.kwad.sdk.core.report;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.WorkerThread;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.UUID;
/* loaded from: classes2.dex */
public class l {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static String f65017a;

    /* renamed from: b  reason: collision with root package name */
    public static long f65018b;

    /* renamed from: c  reason: collision with root package name */
    public static Context f65019c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-615486155, "Lcom/kwad/sdk/core/report/l;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-615486155, "Lcom/kwad/sdk/core/report/l;");
                return;
            }
        }
        f65017a = f();
        f65018b = 0L;
    }

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            com.kwad.sdk.core.d.a.a("ReportIdManager", ">> updateSessionId");
            String f2 = f();
            f65017a = f2;
            return f2;
        }
        return (String) invokeV.objValue;
    }

    public static void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, context) == null) {
            f65019c = context;
        }
    }

    @WorkerThread
    public static boolean a(Context context, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65539, null, context, j)) == null) {
            if (context != null) {
                SharedPreferences.Editor edit = context.getSharedPreferences("ksadsdk_seq", 0).edit();
                edit.putLong(IAdRequestParam.SEQ, j);
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
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            if (context == null || (sharedPreferences = context.getSharedPreferences("ksadsdk_seq", 0)) == null) {
                return 0L;
            }
            return sharedPreferences.getLong(IAdRequestParam.SEQ, 1L);
        }
        return invokeL.longValue;
    }

    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) ? f65017a : (String) invokeV.objValue;
    }

    @WorkerThread
    public static boolean b(Context context, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(AdIconUtil.BAIDU_LOGO_ID, null, context, j)) == null) {
            if (context != null) {
                SharedPreferences.Editor edit = context.getSharedPreferences("ksadsdk_mplogseq", 0).edit();
                edit.putLong(IAdRequestParam.SEQ, j);
                return edit.commit();
            }
            return false;
        }
        return invokeLJ.booleanValue;
    }

    @WorkerThread
    public static long c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            long b2 = b(f65019c);
            a(f65019c, 1 + b2);
            return b2;
        }
        return invokeV.longValue;
    }

    @WorkerThread
    public static long c(Context context) {
        InterceptResult invokeL;
        SharedPreferences sharedPreferences;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) {
            if (context == null || (sharedPreferences = context.getSharedPreferences("ksadsdk_mplogseq", 0)) == null) {
                return 0L;
            }
            return sharedPreferences.getLong(IAdRequestParam.SEQ, 1L);
        }
        return invokeL.longValue;
    }

    @WorkerThread
    public static synchronized long d() {
        InterceptResult invokeV;
        long c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            synchronized (l.class) {
                c2 = c(f65019c);
                b(f65019c, 1 + c2);
            }
            return c2;
        }
        return invokeV.longValue;
    }

    public static long e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? f65018b : invokeV.longValue;
    }

    public static String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) ? UUID.randomUUID().toString() : (String) invokeV.objValue;
    }
}
