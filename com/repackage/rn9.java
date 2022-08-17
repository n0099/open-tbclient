package com.repackage;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public final class rn9 {
    public static /* synthetic */ Interceptable $ic;
    @Nullable
    public static Boolean a;
    @Nullable
    public static Boolean b;
    @Nullable
    public static Boolean c;
    public transient /* synthetic */ FieldHolder $fh;

    @TargetApi(20)
    public static boolean a(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, context)) == null) {
            PackageManager packageManager = context.getPackageManager();
            if (a == null) {
                boolean z = false;
                if (sn9.b() && packageManager.hasSystemFeature("android.hardware.type.watch")) {
                    z = true;
                }
                a = Boolean.valueOf(z);
            }
            return a.booleanValue();
        }
        return invokeL.booleanValue;
    }

    @TargetApi(26)
    public static boolean b(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (a(context)) {
                if (!sn9.d()) {
                    return true;
                }
                if (c(context) && !sn9.e()) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @TargetApi(21)
    public static boolean c(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (b == null) {
                boolean z = false;
                if (sn9.c() && context.getPackageManager().hasSystemFeature("cn.google")) {
                    z = true;
                }
                b = Boolean.valueOf(z);
            }
            return b.booleanValue();
        }
        return invokeL.booleanValue;
    }

    public static boolean d(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            if (c == null) {
                boolean z = true;
                if (!context.getPackageManager().hasSystemFeature("android.hardware.type.iot") && !context.getPackageManager().hasSystemFeature("android.hardware.type.embedded")) {
                    z = false;
                }
                c = Boolean.valueOf(z);
            }
            return c.booleanValue();
        }
        return invokeL.booleanValue;
    }
}
