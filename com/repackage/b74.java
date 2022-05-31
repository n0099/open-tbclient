package com.repackage;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Arrays;
import java.util.HashSet;
/* loaded from: classes5.dex */
public final class b74 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    @SuppressLint({"LambdaLast"})
    public static Bundle a(@NonNull y64 y64Var, @Nullable Bundle bundle, String... strArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65536, null, y64Var, bundle, strArr)) == null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            if (bundle.getLong("timestamp", -1L) < 0) {
                bundle.putLong("timestamp", System.currentTimeMillis());
            }
            return y64Var.m(bundle, new HashSet(Arrays.asList(strArr)));
        }
        return (Bundle) invokeLLL.objValue;
    }

    @NonNull
    @SuppressLint({"LambdaLast"})
    public static Bundle b(@NonNull y64 y64Var, @NonNull String... strArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, y64Var, strArr)) == null) ? a(y64Var, null, strArr) : (Bundle) invokeLL.objValue;
    }
}
